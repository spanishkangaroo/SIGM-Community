/*
 * Created on 15-mar-2011
 *
 */
package ieci.tdw.ispac.api.rule.docs.tags;

import ieci.tdw.ispac.api.ICatalogAPI;
import ieci.tdw.ispac.api.IEntitiesAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.entities.SpacEntities;
import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.api.rule.IRule;
import ieci.tdw.ispac.api.rule.IRuleContext;
import ieci.tdw.ispac.ispaclib.context.IClientContext;
import ieci.tdw.ispac.ispaclib.dao.cat.CTEntityDAO;
import ieci.tdw.ispac.ispaclib.dao.entity.EntityFactoryDAO;
import ieci.tdw.ispac.ispaclib.dao.entity.MultivalueTable;
import ieci.tdw.ispac.ispaclib.dao.join.TableJoinFactoryDAO;
import ieci.tdw.ispac.ispaclib.db.DbCnt;
import ieci.tdw.ispac.ispaclib.db.DbResultSet;
import ieci.tdw.ispac.ispaclib.entity.def.EntityDef;
import ieci.tdw.ispac.ispaclib.entity.def.EntityField;
import ieci.tdw.ispac.ispaclib.utils.DBUtil;
import ieci.tdw.ispac.ispaclib.utils.StringUtils;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Cuando se genera un documento para un registro determinado de una entidad,
 * DOCUMENTOS A NIVEL DE ENTIDAD , se
 * ha de poder mostrar datos de dicho registro en el documento que se est�
 * generando. Con el tag <ispactag entity='SPAC_DT_INTERVINIENTES'
 * property='xxx'/> se obtienen los valores de campos simples , para campos
 * validados se ha de utilizar esta regla.
 *
 * Adem�s esta regla tambi�n dar� soporte a obtener valores de campos validados
 * pertenecientes a una entidad agregada por composici�n
 * <ul>
 * Atributos
 * <li>entity: Entidad a la que pertenece la propiedad/campo que queremos
 * obtener (OBLIGATORIO)</li>
 * <li>property: Propiedad/Campo a mostrar (OBLIGATORIO)</li>
 * <li>sqlquery: Filtro a tener en cuenta en la consulta (OPCIONAL)</li>
 * <li>multivaluefieldseparator: Separadores para los valores de un campo
 * multivalor (OPCIONAL)</li>
 * <li>codetable: Nombre de la tabla de validaci�n (OBLIGATORIO)</li>
 * <li>code: Nombre de la columna que contiene el c�digo en la tabla de
 * validaci�n. Por defecto es valor (OPCIONAL)</li>
 * <li>value: Nombre de la columna que contiene el sustituto en la tabla de
 * validaci�n. Por defecto es sustituto (OPCIONAL)</li>
 * <li>mainentity: Nombre de la entidad principal. Campo �til en los casos que
 * se quieran mostrar datos de una entidad auxiliar(OPCIONAL)</li>
 * <li>bindfield: Indica el campo que relaciona un registro de la entidad
 * principal (mainentity) con la entidad (entity). En aquellos casos que se
 * especifique valor para el atributo mainentity ser� necesario informar este
 * atributo.(OPCIONAL)</li>
 * </ul>
 * <p>
 * Ejemplos
 * </p>
 * <ispactag rule='PropertyRegSubstitute' entity='SPAC_DT_INTERVINIENTES'
 * property='TIPO_DIRECCION' codetable='SPAC_TBL_005' /> <ispactag
 * rule='PropertyRegSubstitute' entity='SEC_PARTICIPANTES' property='RECURSOS'
 * codetable='SPAC_VLDTBL_RECURSOS' multivaluefieldseparator='\n'
 * mainentity='SPAC_DT_INTERVINIENTES' bindfield='ID_PARTICIPANTE' />
 *
 * @author iecisa
 *
 */
public class PropertyRegSubstituteRule implements IRule {
	/**
	 * Logger de la clase.
	 */
	private static final Logger logger = Logger
			.getLogger(PropertyRegSubstituteRule.class);

	public boolean init(IRuleContext rctx) throws ISPACRuleException {
		return true;
	}

	public boolean validate(IRuleContext rctx) throws ISPACRuleException {
		return true;
	}

	public Object execute(IRuleContext rctx) throws ISPACRuleException {

		try {
			IClientContext cct = rctx.getClientContext();

			IInvesflowAPI invesflowAPI = cct.getAPI();
			IEntitiesAPI entitiesAPI = invesflowAPI.getEntitiesAPI();

			String entityname = rctx.get("entity");
			String property = rctx.get("property");
			String sqlquery = rctx.get("sqlquery");
			String mainentity = rctx.get("mainentity");
			String bindfield = rctx.get("bindfield");

			if (StringUtils.isNotEmpty(sqlquery)) {
				sqlquery = "(" + sqlquery + ") AND ";
			}
			String multivaluefieldseparator = rctx
					.get("multivaluefieldseparator");

			String codetable = rctx.get("codetable");
			String code = rctx.get("code");
			String value = rctx.get("value");

			String regId = cct.getStateContext().getKey() + "";

			// Si estamos en el contexto del tr�mite el reg de la entidad se
			// obtiene del contexto del documento
			if (cct.getStateContext().getEntity() == SpacEntities.SPAC_DT_TRAMITES) {

				NodeList nodeList = rctx.getDocContext().getElementsByTagName(
						"_regentityid");

				if (nodeList != null) {
					Node regentityid = nodeList.item(0);
					// Obtengo el primer hijo que es el que tiene el id
					if (regentityid != null) {
						regentityid = regentityid.getFirstChild();
						if (regentityid != null) {
							// Obtengo el valor
							regId = regentityid.getNodeValue();
						}
					}
				}

			}
			if (logger.isDebugEnabled()) {
				Log.debug(" Ejecutando regla PropertyRegSubstituteRule regiId:"
						+ regId);
			}
			if (StringUtils.isNotBlank(regId + "")) {
				if (StringUtils.isBlank(sqlquery)) {
					sqlquery = "";
				}
				if (StringUtils.isBlank(mainentity)) {
					sqlquery += " " + entityname + ".ID= " + regId;
				} else {
					sqlquery += " " + entityname + "." + bindfield + "="
							+ regId;
				}
			}
			// Obtener el registro de la entidad
			IItemCollection itemCollection = null;
			if (StringUtils.isEmpty(mainentity)) {
				itemCollection = entitiesAPI.getEntities(entityname, rctx
						.getNumExp(), sqlquery);
			} else {
				TableJoinFactoryDAO tableJoinFactoryDAO = new TableJoinFactoryDAO();
				tableJoinFactoryDAO.addTable(entityname, entityname);
				tableJoinFactoryDAO.addTable(mainentity, mainentity);
				itemCollection = tableJoinFactoryDAO.queryTableJoin(
						cct.getConnection(),
						" WHERE " + sqlquery + "AND " + mainentity + ".ID="
								+ regId + " AND " + mainentity + ".NUMEXP="
								+ entityname + ".NUMEXP").disconnect();
			}

			if (itemCollection.next()) {

				IItem entity = itemCollection.value();

				if (StringUtils.isBlank(code)) {
					code = ICatalogAPI.VALOR_FIELD_NAME.toUpperCase();
				}

				if (StringUtils.isBlank(value)) {
					value = ICatalogAPI.SUSTITUTO_FIELD_NAME.toUpperCase();
				}

				CTEntityDAO ctentity = EntityFactoryDAO.getInstance()
						.getCatalogEntityDAO(cct.getConnection(), entityname);
				EntityDef entityDef = EntityDef.parseEntityDef(ctentity
						.getDefinition());
				EntityField entityField = entityDef.getField(property);
				// Si el campo es multivalor se sacan todos los sustitutos de
				// todos los campos
				if (entityField.isMultivalue()) {
					DbResultSet dbrs = null;
					String stmt = null;
					DbCnt cnt = cct.getConnection();
					StringBuffer buffer = new StringBuffer();
					try {
						String multivalueTable = MultivalueTable.getInstance()
								.composeMultivalueTableName(ctentity.getName(),
										entityField.getType().getJdbcType());
						stmt = "SELECT  "
								+ codetable
								+ ".SUSTITUTO "
								+ " FROM  "
								+ multivalueTable
								+ ", "
								+ codetable
								+ " WHERE "
								+ multivalueTable
								+ "."
								+ MultivalueTable.FIELD_FIELD
								+ " = '"
								+ DBUtil.replaceQuotes(entityField
										.getPhysicalName().toUpperCase())
								+ "'  AND " + multivalueTable + "."
								+ MultivalueTable.FIELD_REG + " = "
								+ entity.getString(entityname + ":ID")
								+ "   AND " + multivalueTable + "."
								+ MultivalueTable.FIELD_VALUE + " = "
								+ codetable + "." + code;
						dbrs = cct.getConnection().executeQuery(stmt);
						while (dbrs.getResultSet().next()) {
							buffer.append(dbrs.getResultSet().getString(value));
							if (StringUtils.isEmpty(multivaluefieldseparator)) {
								buffer.append("\n");
							} else {
								buffer.append(StringUtils
												.unescapeJava(multivaluefieldseparator));
							}
						}
					} catch (SQLException e) {
						throw new ISPACRuleException(e);
					} finally {
						if (dbrs != null) {
							dbrs.close();
						}
						cct.releaseConnection(cnt);
					}
					if (logger.isDebugEnabled()) {
						Log
								.debug(" Resultado regla PropertyRegSubstituteRule :"
										+ buffer.toString());
					}
					return buffer.toString();
				}

				String codevalue="";
				// Obtener el valor del c�digo en la entidad principal
				if(StringUtils.isBlank(mainentity)){
					codevalue= entity
					.getString(property);
				}
				else{codevalue= entity
						.getString(entityname + ":" + property);
				}
				if (StringUtils.isNotBlank(codevalue)) {

					String sqlQuery = "WHERE " + code + " = '"
							+ DBUtil.replaceQuotes(codevalue) + "'";

					itemCollection = entitiesAPI.queryEntities(codetable,
							sqlQuery);

					if (itemCollection.next()) {

						IItem substitute = itemCollection.value();

						if (logger.isDebugEnabled()) {
							Log.debug(" Resultado regla PropertyRegSubstituteRule :"
											+ substitute.getString(value));
						}
						return substitute.getString(value);
					}
				}
			}

			return "";
		} catch (ISPACException e) {
			throw new ISPACRuleException(
					"Error obteniendo el valor sustituto.", e);
		}
	}

	public void cancel(IRuleContext rctx) throws ISPACRuleException {

	}
}
