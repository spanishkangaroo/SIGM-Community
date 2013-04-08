
package es.ieci.tecdoc.isicres.admin.sbo.idoc.dao;

import es.ieci.tecdoc.isicres.admin.base.dbex.DbColumnDef;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbConnection;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbConnectionConfig;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbDataType;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbIndexDef;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbSelectFns;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbTableFns;
import es.ieci.tecdoc.isicres.admin.base.dbex.DbUtil;


public class DaoDATNodeTbl
{
   
   // **************************************************************************
   /* 
 *@SF-SEVILLA 
 *02-may-2006 / antmaria
 */
   private static final String TN ="IDOCDATNODE";

   private static final DbColumnDef CD_ID = new DbColumnDef
   ("ID", DbDataType.LONG_INTEGER, false);

   private static final DbColumnDef CD_TYPE = new DbColumnDef
   ("TYPE", DbDataType.LONG_INTEGER, false);
   
   private static final DbColumnDef CD_PARENTID = new DbColumnDef
   ("PARENTID", DbDataType.LONG_INTEGER, false);  
  
   private static final DbColumnDef[] ACD = 
   {CD_ID, CD_TYPE, CD_PARENTID};  
   
   private static final String ACN = DbUtil.getColumnNames(ACD);   
  
   // **************************************************************************

   private static String getDefaultQual(int parentId)
   {
      return "WHERE " + CD_PARENTID.getName() + "= " + parentId;
   } 
   
   // **************************************************************************
   
   protected static String getColName(DbColumnDef colDef, boolean qualified)
   {
      String colName = colDef.getName();
      
      if (qualified)
         colName =  TN + "." + colName;
      
      return colName;
   }
   
   public static String getTblName()
   {      
      return TN;
   }
   
   public static String getIdColName(boolean qualified)
   {
      return getColName(CD_ID, qualified);
   }
   
   public static String getTypeColName(boolean qualified)
   {
      return getColName(CD_TYPE, qualified);
   }
   
   public static String getParentIdColName(boolean qualified)
   {
      return getColName(CD_PARENTID, qualified);
   }
      
   // **************************************************************************
   
   private DaoDATNodeTbl()
   {
   }
   
   // **************************************************************************
   
   
   public static int selectChildCount(DbConnection dbConn, int parentId)
                     throws Exception
   {

      return DbSelectFns.selectCount(dbConn, TN, getDefaultQual(parentId));

   }  
   
// **************************************************************************
   
   public static void createTable(DbConnection dbConn) throws Exception
   {
      String indexName,indexName2,indexName3;
      String colNamesIndex,colNamesIndex2,colNamesIndex3;
      DbIndexDef indexDef, indexDef2, indexDef3;
      
      indexName = TN + "1";
      colNamesIndex = "ID,TYPE";
      indexName2 = TN + "2";
      colNamesIndex2 = "PARENTID";
      indexName3 = TN + "3";
      colNamesIndex3 = "TYPE";
      
      indexDef= new DbIndexDef(indexName,colNamesIndex,true);
      indexDef2= new DbIndexDef(indexName2,colNamesIndex2,false);
      indexDef3= new DbIndexDef(indexName3,colNamesIndex3,false);
      
      DbTableFns.createTable(dbConn, TN,ACD);
      
      DbTableFns.createIndex(dbConn, TN,indexDef);
      DbTableFns.createIndex(dbConn, TN,indexDef2);
      DbTableFns.createIndex(dbConn, TN,indexDef3);
   }
   
   public static void dropTable(DbConnection dbConn) throws Exception
   {
      String idxName, idxName2, idxName3;  
      
      idxName = TN + "1";
      idxName2 = TN + "2";
      idxName3 = TN + "3";
   
      dropIndex(dbConn, TN,idxName);
      dropIndex(dbConn, TN,idxName2);
      dropIndex(dbConn, TN,idxName3);     
      DbTableFns.dropTable(dbConn, TN);
        
   }
   
   private static void dropIndex(DbConnection dbConn, String tblName, String indexName)
   {
      try
      {
         DbTableFns.dropIndex(dbConn, tblName,indexName);
      }
      catch(Exception e)
      {
         
      }
   }
   
// **************************************************************************
   protected static String getSelectStatementTextChildrenDirNodes(int parentId) 
                        throws Exception
   {  

      String  text;
      
      text = "SELECT " + getIdColName(true) + " FROM " + TN
             + " WHERE " + getParentIdColName(true) + "= " 
             + parentId + " AND " + getTypeColName(true) +
             "= " + DaoDATNodeType.DIR + " AND " + getIdColName(true) +
             " = " + DaoDirTbl.getIdColName(true);
      
      return text;

   }
   
   protected static String getSelectStatementTextChildrenArchNodes(int parentId) 
                           throws Exception
   {  

      String text;

      text = "SELECT " + getIdColName(true) + " FROM " + TN
             + " WHERE " + getParentIdColName(true) + "= " 
             + parentId + " AND " + getTypeColName(true) +
             "= " + DaoDATNodeType.ARCH + " AND " + getIdColName(true) +
             " = " + DaoArchHdrTbl.getIdColName(true);
      
      return text;

   }   
   
} // class
