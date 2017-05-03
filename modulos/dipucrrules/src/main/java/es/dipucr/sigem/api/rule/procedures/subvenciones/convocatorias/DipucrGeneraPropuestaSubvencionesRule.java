package es.dipucr.sigem.api.rule.procedures.subvenciones.convocatorias;

import ieci.tdw.ispac.api.IEntitiesAPI;
import ieci.tdw.ispac.api.IGenDocAPI;
import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.IProcedureAPI;
import ieci.tdw.ispac.api.errors.ISPACRuleException;
import ieci.tdw.ispac.api.item.IItem;
import ieci.tdw.ispac.api.item.IItemCollection;
import ieci.tdw.ispac.api.rule.IRuleContext;
import ieci.tdw.ispac.ispaclib.context.ClientContext;
import ieci.tdw.ispac.ispaclib.context.IClientContext;
import ieci.tdw.ispac.ispaclib.gendoc.openoffice.OpenOfficeHelper;
import ieci.tdw.ispac.ispaclib.util.FileTemporaryManager;
import ieci.tdw.ispac.ispaclib.utils.MimetypeMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.sun.star.lang.XComponent;

import es.dipucr.sigem.api.rule.common.documento.DipucrAutoGeneraDocIniTramiteRule;
import es.dipucr.sigem.api.rule.common.utils.DipucrCommonFunctions;
import es.dipucr.sigem.api.rule.common.utils.DocumentosUtil;

public class DipucrGeneraPropuestaSubvencionesRule extends DipucrAutoGeneraDocIniTramiteRule{
	private static final Logger logger = Logger.getLogger(DipucrGeneraPropuestaSubvencionesRule.class);	

	public boolean init(IRuleContext rulectx) throws ISPACRuleException {
		logger.info("INICIO - DipucrGeneraPropuestaSubvencionesRule");
		
		tipoDocumento = "Contenido de la propuesta";
		plantilla = "Contenido de la propuesta";
		
		logger.info("FIN - DipucrGeneraPropuestaSubvencionesRule");
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public Object execute(IRuleContext rulectx) throws ISPACRuleException {
		try
    	{
			//----------------------------------------------------------------------------------------------
	        ClientContext cct = (ClientContext) rulectx.getClientContext();
	        IInvesflowAPI invesFlowAPI = cct.getAPI();
	        IEntitiesAPI entitiesAPI = invesFlowAPI.getEntitiesAPI();
	        IGenDocAPI genDocAPI = invesFlowAPI.getGenDocAPI();
			IProcedureAPI procedureAPI = invesFlowAPI.getProcedureAPI();
	        //----------------------------------------------------------------------------------------------
	        
	        Object connectorSession = null;
	    	OpenOfficeHelper ooHelper = null;
	    	
	        //Obtiene el expediente
	        String numexp = rulectx.getNumExp();
	        IItem entityDocument = null;
			int documentTypeId = 0;
			int documentId  = 0;
			int templateId = 0;
			int taskId = rulectx.getTaskId();
			
			IItem processTask =  entitiesAPI.getTask(rulectx.getTaskId());
			int idTramCtl = processTask.getInt("ID_TRAM_CTL");
			
			IItemCollection taskTpDocCollection = (IItemCollection)procedureAPI.getTaskTpDoc(idTramCtl);     		
    		Iterator it = taskTpDocCollection.iterator();
			while (it.hasNext()){
    			IItem taskTpDoc = (IItem)it.next();
    			if ((((String)taskTpDoc.get("CT_TPDOC:NOMBRE")).trim().toUpperCase()).equals((tipoDocumento).trim().toUpperCase())){    				
    				documentTypeId = taskTpDoc.getInt("TASKTPDOC:ID_TPDOC");
    			}
    		}
			
			cct.setSsVariable("NOMBRE_TRAMITE", processTask.getString("NOMBRE"));
			
			IItemCollection tpDocsTemplatesCollection = (IItemCollection)procedureAPI.getTpDocsTemplates(documentTypeId);
			Iterator docs = tpDocsTemplatesCollection.iterator();
			while (docs.hasNext()){
				IItem tpDocsTemplate = (IItem)docs.next();
				if(((String)tpDocsTemplate.get("NOMBRE")).trim().toUpperCase().equals(plantilla.trim().toUpperCase())){
					templateId = tpDocsTemplate.getInt("ID");
				}
			}
			
    		entityDocument  = genDocAPI.createTaskDocument(taskId, documentTypeId);
    		documentId = entityDocument.getKeyInt();	
    		
			//String sFileTemplate = getFile(genDocAPI, connectorSession, infoPag, templateId, idPlantilla);
												
			// Generar el documento a partir la plantilla 
    		IItem entityTemplate = genDocAPI.attachTaskTemplate(connectorSession, taskId, documentId, templateId);
									
			String docref = entityTemplate.getString("INFOPAG");
			String sMimetype = genDocAPI.getMimeType(connectorSession, docref);
			entityTemplate.set("EXTENSION", MimetypeMapping.getExtension(sMimetype));
			String mime = "application/vnd.oasis.opendocument.text";
			String templateDescripcion = entityTemplate.getString("DESCRIPCION");
			entityTemplate.set("DESCRIPCION", templateDescripcion);

			entityTemplate.store(cct);
			
			//Abre el documento
			String extension = "odt";
			String fileName = FileTemporaryManager.getInstance().newFileName("."+extension);
			fileName = FileTemporaryManager.getInstance().getFileTemporaryPath() + "/" + fileName;
			OutputStream out = new FileOutputStream(fileName);
    		connectorSession = genDocAPI.createConnectorSession();
    		genDocAPI.getDocument(connectorSession, docref, out);
//			File file = new File(fileName);
    		ooHelper = OpenOfficeHelper.getInstance();
    		XComponent xComponent = ooHelper.loadDocument("file://" + fileName);
    		
    		//Concatenamos las bases
    		
    		//Recuperamos el documento Informe del servicio
    		IItemCollection itemCol = entitiesAPI.getDocuments(numexp, "NOMBRE='Informe del servicio'", "FDOC DESC");
    		Iterator iteratorDoc = itemCol.iterator();
    		if(iteratorDoc.hasNext()){
    			String infoPagBases = ((IItem)iteratorDoc.next()).getString("INFOPAG");
	        	File fileBases = DocumentosUtil.getFile(cct, infoPagBases, null, null);
	        	DipucrCommonFunctions.Concatena(xComponent, "file://" + fileBases.getPath(), ooHelper);
	        	fileBases.delete();
    		}
    		
    		 //Guarda el documento
			String fileNameOut = FileTemporaryManager.getInstance().newFileName(".odt");
			fileNameOut = FileTemporaryManager.getInstance().getFileTemporaryPath() + "/" + fileNameOut;
    		OpenOfficeHelper.saveDocument(xComponent,"file://" + fileNameOut,"");
    		File fileOut = new File(fileNameOut);
    		InputStream in = new FileInputStream(fileOut);			    		
    		genDocAPI.setDocument(connectorSession, documentId, docref, in, (int)(fileOut.length()), mime);

    		cct.deleteSsVariable("NOMBRE_TRAMITE");
    		if(ooHelper!= null) ooHelper.dispose();
    		
	        return new Boolean(true);
        }
    	catch(Exception e) 
        {
        	if (e instanceof ISPACRuleException)
        	{
			    throw new ISPACRuleException(e);
        	}
        	throw new ISPACRuleException("No se ha podido generar el documento.",e);
        }
	}
	
	public void setSsVariables(IClientContext cct, IRuleContext rulectx) {
	}

	public void deleteSsVariables(IClientContext cct) {	
	}
}