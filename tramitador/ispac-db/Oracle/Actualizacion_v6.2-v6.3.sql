-----------------------------------
-- Actualizaci�n de v6.2 a v6.3
-----------------------------------


--
-- Informaci�n de versi�n
--

INSERT INTO spac_infosistema (id, codigo, valor, fecha_actualizacion) VALUES (SPAC_SQ_ID_INFOSISTEMA.NEXTVAL, 'VERSIONBD', '6.3', current_timestamp);
INSERT INTO spac_infosistema (id, codigo, valor, fecha_actualizacion) VALUES (SPAC_SQ_ID_INFOSISTEMA.NEXTVAL, 'VERSIONAPP', '6.3', current_timestamp);


--
-- Se a�aden dos columnas m�s a spac_procesos spac_fases y spac_tramites para guardar el nombre del responsable 
-- y el nombre del responsable secundario.
--

ALTER TABLE SPAC_PROCESOS ADD RESP VARCHAR2 (250);
ALTER TABLE SPAC_TRAMITES ADD RESP VARCHAR2 (250);
ALTER TABLE SPAC_FASES ADD RESP VARCHAR2 (250);
ALTER TABLE SPAC_PROCESOS ADD RESP_SEC VARCHAR2 (250);
ALTER TABLE SPAC_TRAMITES ADD RESP_SEC VARCHAR2 (250);
ALTER TABLE SPAC_FASES ADD RESP_SEC VARCHAR2 (250);


--
-- Actualizaci�n de la vista de plazos
--

CREATE OR REPLACE VIEW SPAC_DEADLINE AS 
SELECT OBJ.NUMEXP, OBJ.FECHA_LIMITE, PROCEDIMIENTO.NOMBRE AS NOMBRE_PCD, OBJ.ID_RESP, OBJ.ID AS ID_OBJETO, 'RESOLUCI�N EXPEDIENTE' AS DESCRIPCION, 1 AS TIPO
   FROM SPAC_PROCESOS OBJ, SPAC_CT_PROCEDIMIENTOS PROCEDIMIENTO
  WHERE OBJ.ID_PCD = PROCEDIMIENTO.ID AND OBJ.ESTADO = 1 AND OBJ.FECHA_LIMITE IS NOT NULL
UNION 
 SELECT OBJ.NUMEXP, OBJ.FECHA_LIMITE, PROCEDIMIENTO.NOMBRE AS NOMBRE_PCD, OBJ.ID_RESP, OBJ.ID AS ID_OBJETO, 'RESOLUCI�N FASE' AS DESCRIPCION, 2 AS TIPO
   FROM SPAC_FASES OBJ, SPAC_CT_PROCEDIMIENTOS PROCEDIMIENTO
  WHERE OBJ.ID_PCD = PROCEDIMIENTO.ID AND OBJ.ESTADO = 1 AND OBJ.TIPO=1 AND OBJ.FECHA_LIMITE IS NOT NULL
UNION 
 SELECT OBJ.NUMEXP, OBJ.FECHA_LIMITE, PROCEDIMIENTO.NOMBRE AS NOMBRE_PCD, OBJ.ID_RESP, OBJ.ID AS ID_OBJETO, OBJ.NOMBRE AS DESCRIPCION, 3 AS TIPO
   FROM SPAC_TRAMITES OBJ, SPAC_CT_PROCEDIMIENTOS PROCEDIMIENTO
  WHERE OBJ.ID_PCD = PROCEDIMIENTO.ID AND OBJ.ESTADO = 1 AND OBJ.FECHA_LIMITE IS NOT NULL
UNION 
 SELECT OBJ.NUMEXP, OBJ.FECHA_LIMITE, PROCEDIMIENTO.NOMBRE AS NOMBRE_PCD, OBJ.ID_RESP, OBJ.ID AS ID_OBJETO, 'RESOLUCI�N ACTIVIDAD' AS DESCRIPCION, 4 AS TIPO
   FROM SPAC_FASES OBJ, SPAC_P_PROCEDIMIENTOS PROCEDIMIENTO
  WHERE OBJ.ID_PCD = PROCEDIMIENTO.ID AND OBJ.ESTADO = 1 AND OBJ.TIPO=2 AND OBJ.FECHA_LIMITE IS NOT NULL;


--
-- Creaci�n de �ndices
--

CREATE INDEX SPAC_EXPEDIENTES_IX_NUMEXP ON SPAC_EXPEDIENTES (NUMEXP);
CREATE INDEX SPAC_DT_DOCUMENTOS_IX_NUMEXP ON SPAC_DT_DOCUMENTOS (NUMEXP);
CREATE INDEX SPAC_DT_TRAMITES_IX_NUMEXP ON SPAC_DT_TRAMITES (NUMEXP);
CREATE INDEX SPAC_DT_TRAMITES_IX_IDTRAMEXP ON  SPAC_DT_TRAMITES (ID_TRAM_EXP);
CREATE INDEX SPAC_DT_INT_IX_NUMEXP ON  SPAC_DT_INTERVINIENTES (NUMEXP);

CREATE INDEX SPAC_PROCESOS_IX_NUMEXP ON SPAC_PROCESOS (NUMEXP);
CREATE INDEX SPAC_PROCESOS_IX_IDRESP ON SPAC_PROCESOS (ID_RESP);
CREATE INDEX SPAC_FASES_IX_NUMEXP ON SPAC_FASES (NUMEXP);
CREATE INDEX SPAC_FASES_IX_IDRESP ON SPAC_FASES (ID_RESP);
CREATE INDEX SPAC_TRAMITES_IX_NUMEXP ON SPAC_TRAMITES (NUMEXP);
CREATE INDEX SPAC_TRAMITES_IX_IDRESP ON SPAC_TRAMITES (ID_RESP);