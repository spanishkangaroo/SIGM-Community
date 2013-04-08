--
-- VISTAS
--

--
-- Esta vista esta solo para DB2
--
DROP VIEW SPAC_SQ_SEQUENCES;
--

DROP VIEW SPAC_WL_BATCHTASK;
DROP VIEW SPAC_WL_PROC;
DROP VIEW SPAC_WL_PCD;
DROP VIEW SPAC_WL_TASK;
DROP VIEW SPAC_WL_CLOSE_TASK;
DROP VIEW SPAC_WL_ACTIVITY;
DROP VIEW SPAC_DEADLINE;
DROP VIEW SPAC_PCD_PERMISOS;
DROP VIEW SPAC_V_AVISOS_ELECTRONICOS;
DROP VIEW SPAC_WL_PROC_TRASH;

--
-- TABLAS
--
DROP TABLE PUB_ACCIONES;
DROP TABLE PUB_APLICACIONES_HITOS;
DROP TABLE PUB_CONDICIONES;
DROP TABLE PUB_ERRORES;
DROP TABLE PUB_HITOS_ACTIVOS;
DROP TABLE PUB_REGLAS;
DROP TABLE PUB_ULTIMO_HITO_TRATADO;
DROP TABLE SPAC_ANOTACIONES;
DROP TABLE SPAC_AVISOS_ELECTRONICOS;
DROP TABLE SPAC_CALENDARIOS;
DROP TABLE SPAC_CT_APLICACIONES;
DROP TABLE SPAC_CT_ENTIDADES;
DROP TABLE SPAC_CT_ENTIDADES_RESOURCES;
DROP TABLE SPAC_CT_FASES;
DROP TABLE SPAC_CT_FRMBUSQUEDA;
DROP TABLE SPAC_CT_FRMBUSQUEDA_ORG;
DROP TABLE SPAC_CT_FSTR;
DROP TABLE SPAC_CT_JERARQUIAS;
DROP TABLE SPAC_CT_PCDORG;
DROP TABLE SPAC_CT_PROCEDIMIENTOS;
DROP TABLE SPAC_CT_REGLAS;
DROP TABLE SPAC_CT_TPDOC;
DROP TABLE SPAC_CT_TRAMITES;
DROP TABLE SPAC_CT_TRTD;
DROP TABLE SPAC_CTOS_FIRMA;
DROP TABLE SPAC_CTOS_FIRMA_CABECERA;
DROP TABLE SPAC_P_CTOSFIRMA;
DROP TABLE SPAC_CTOS_FIRMA_DETALLE;
DROP TABLE SPAC_DOCOBJ;
DROP TABLE SPAC_DT_DOCUMENTOS;
DROP TABLE SPAC_DT_INTERVINIENTES;
DROP TABLE SPAC_DT_TRAMITES;
DROP TABLE SPAC_REGISTROS_ES;
DROP TABLE SPAC_EXP_RELACIONADOS;
DROP TABLE SPAC_EXPEDIENTES;
DROP TABLE SPAC_FASES;
DROP TABLE SPAC_GESTION_APLICACIONES;
DROP TABLE SPAC_GESTION_FASES;
DROP TABLE SPAC_HITOS;
DROP TABLE SPAC_INFOTRAMITE;
DROP TABLE SPAC_INFOSISTEMA;
DROP TABLE SPAC_NUMEXP_CONTADOR;
DROP TABLE SPAC_P_BLP;
DROP TABLE SPAC_P_ENTIDADES;
DROP TABLE SPAC_P_EVENTOS;
DROP TABLE SPAC_P_FASES;
DROP TABLE SPAC_P_FLUJOS;
DROP TABLE SPAC_P_FRMFASES;
DROP TABLE SPAC_P_FRMTRAMITES;
DROP TABLE SPAC_P_FSTD;
DROP TABLE SPAC_P_NODOS;
DROP TABLE SPAC_P_PLANTDOC;
DROP TABLE SPAC_P_PLANTILLAS;
DROP TABLE SPAC_P_PLAZOS;
DROP TABLE SPAC_P_PROCEDIMIENTOS;
DROP TABLE SPAC_P_RELPLAZOS;
DROP TABLE SPAC_P_SINCNODO;
DROP TABLE SPAC_P_TRAMITES;
DROP TABLE SPAC_P_DEP_TRAMITES;
DROP TABLE SPAC_P_VERSPLANT;
DROP TABLE SPAC_PROCESOS;
DROP TABLE SPAC_S_BLOQUEOS;
DROP TABLE SPAC_S_SESIONES;
DROP TABLE SPAC_S_VARS;
DROP TABLE SPAC_SINCNODO;
DROP TABLE SPAC_SS_FECHSUSTITUCIONES;
DROP TABLE SPAC_SS_SUSTITUCIONFECHA;
DROP TABLE SPAC_SS_FUNCIONES;
DROP TABLE SPAC_SS_PERMISOS;
DROP TABLE SPAC_PERMISOS;
DROP TABLE SPAC_SS_SUPERVISION;
DROP TABLE SPAC_SS_SUSTITUCION;
DROP TABLE SPAC_TBL_001;
DROP TABLE SPAC_TBL_002;
DROP TABLE SPAC_TBL_003;
DROP TABLE SPAC_TBL_004;
DROP TABLE SPAC_TBL_005;
DROP TABLE SPAC_TBL_006;
DROP TABLE SPAC_TBL_007;
DROP TABLE SPAC_VLDTBL_TIPO_NOTIF;
DROP TABLE SPAC_TBL_008;
DROP TABLE SPAC_TBL_009;
DROP TABLE SPAC_TRAMITACIONES_AGRUPADAS;
DROP TABLE SPAC_TRAMITCS_AGRUPADAS_EXPS;
DROP TABLE SPAC_TRAMITES;
DROP TABLE SPAC_VARS;
DROP TABLE SPAC_VLDTBL_ACTS_FUNCS;
DROP TABLE SPAC_VLDTBL_EFEC_SLNCIO;
DROP TABLE SPAC_VLDTBL_FORMA_INIC;
DROP TABLE SPAC_VLDTBL_MATS_COMP;
DROP TABLE SPAC_VLDTBL_RECURSOS;
DROP TABLE SPAC_VLDTBL_SIST_PRODUCTORES;
DROP TABLE SPAC_VLDTBL_SIT_TLM;
DROP TABLE SPAC_VLDTBL_TIPOREG;
DROP TABLE SPAC_VLDTBL_TIPOS_DOCS;
DROP TABLE SPAC_VLDTBL_TIPOS_TRAM;
DROP TABLE SPAC_CT_INFORMES;
DROP TABLE SPAC_CT_INFORMES_ORG;
DROP TABLE SPAC_P_INFORMES;
DROP TABLE SPAC_CT_FRMBUSQ_INFORMES;
DROP TABLE SPAC_AYUDAS;

--
-- PROCEDURES
--
DROP PROCEDURE spac_nextval;


--
-- SECUENCIAS
--

-- Secuencias para las tablas internas
DROP SEQUENCE spac_sq_id_anotaciones;
DROP SEQUENCE spac_sq_id_avisos_electronicos;
DROP SEQUENCE spac_sq_id_ctaplicaciones;
DROP SEQUENCE spac_sq_id_ctentidades;
DROP SEQUENCE spac_sq_id_ctfases;
DROP SEQUENCE spac_sq_id_ctfrmbusqueda;
DROP SEQUENCE spac_sq_id_ctfrmbusqueda_org;
DROP SEQUENCE spac_sq_id_ctfstr;
DROP SEQUENCE spac_sq_id_ctos_firma;
DROP SEQUENCE spac_sq_id_ctos_firma_cabecera;
DROP SEQUENCE spac_sq_id_ctos_firma_detalle;
DROP SEQUENCE spac_sq_id_ctos_firma_instance;
DROP SEQUENCE spac_sq_id_ctpcdorg;
DROP SEQUENCE spac_sq_id_ctreglas;
DROP SEQUENCE spac_sq_id_cttpdoc;
DROP SEQUENCE spac_sq_id_cttramites;
DROP SEQUENCE spac_sq_id_cttrtd;
DROP SEQUENCE spac_sq_id_docobj;
DROP SEQUENCE spac_sq_id_dtdocumentos;
DROP SEQUENCE spac_sq_id_dtintervinientes;
DROP SEQUENCE spac_sq_id_dttramites;
DROP SEQUENCE spac_sq_id_entidadesresources;
DROP SEQUENCE spac_sq_id_exp_relacionado;
DROP SEQUENCE spac_sq_id_expedientes;
DROP SEQUENCE spac_sq_id_registroses;
DROP SEQUENCE spac_sq_id_fases;
DROP SEQUENCE spac_sq_id_hitos;
DROP SEQUENCE spac_sq_id_infotramite;
DROP SEQUENCE spac_sq_id_infosistema;
DROP SEQUENCE spac_sq_id_p_plantillas;
DROP SEQUENCE spac_sq_id_pentidades;
DROP SEQUENCE spac_sq_id_peventos;
--DROP SEQUENCE spac_sq_id_pfases;
DROP SEQUENCE spac_sq_id_pflujos;
DROP SEQUENCE spac_sq_id_pfrmfases;
DROP SEQUENCE spac_sq_id_pfrmtramites;
DROP SEQUENCE spac_sq_id_pfstd;
DROP SEQUENCE spac_sq_id_pnodos;
DROP SEQUENCE spac_sq_id_pplantillas;
DROP SEQUENCE spac_sq_id_pplazos;
DROP SEQUENCE spac_sq_id_pprocedimientos;
DROP SEQUENCE spac_sq_id_procesos;
DROP SEQUENCE spac_sq_id_ptramites;
DROP SEQUENCE spac_sq_id_pdeptramites;
DROP SEQUENCE spac_sq_id_sincnodos;
DROP SEQUENCE spac_sq_id_ssfunciones;
DROP SEQUENCE spac_sq_id_sspermisos;
DROP SEQUENCE spac_sq_id_sssuperv;
DROP SEQUENCE spac_sq_id_svars;
DROP SEQUENCE spac_sq_tramitacion_agrupada;
DROP SEQUENCE spac_sq_tramtcs_group_exps;
DROP SEQUENCE spac_sq_id_tramites;
DROP SEQUENCE spac_sq_id_vars;
DROP SEQUENCE spac_sq_id_pctosfirma;
DROP SEQUENCE spac_sq_id_calendarios;
DROP SEQUENCE spac_sq_id_sssustitucion;
DROP SEQUENCE spac_sq_id_ssfechsustituciones;
DROP SEQUENCE spac_sq_id_sssustitucionfecha;
DROP SEQUENCE spac_sq_id_ctinformes;
DROP SEQUENCE spac_sq_id_ctinformes_org;
DROP SEQUENCE spac_sq_id_ctjerarquias;
DROP SEQUENCE spac_sq_id_ayudas;

-- Secuencias para las tablas de validación
DROP SEQUENCE spac_sq_spac_tbl_001;
DROP SEQUENCE spac_sq_spac_tbl_002;
DROP SEQUENCE spac_sq_spac_tbl_003;
DROP SEQUENCE spac_sq_spac_tbl_004;
DROP SEQUENCE spac_sq_spac_tbl_005;
DROP SEQUENCE spac_sq_spac_tbl_006;
DROP SEQUENCE spac_sq_spac_tbl_008;
DROP SEQUENCE spac_sq_spac_tbl_009;
DROP SEQUENCE spac_sq_spac_vldtbl_acts_funcs;
DROP SEQUENCE spac_sq_spac_vldtbl_efec_slnc;
DROP SEQUENCE spac_sq_spac_vldtbl_forma_inic;
DROP SEQUENCE spac_sq_spac_vldtbl_mats_comp;
DROP SEQUENCE spac_sq_spac_vldtbl_recursos;
DROP SEQUENCE spac_sq_spac_vldtbl_sist_prod;
DROP SEQUENCE spac_sq_spac_vldtbl_sit_tlm;
DROP SEQUENCE spac_sq_spac_vldtbl_tiporeg;
DROP SEQUENCE spac_sq_spac_vldtbl_tipos_docs;
DROP SEQUENCE spac_sq_spac_vldtbl_tipos_tram;
DROP SEQUENCE spac_sq_spac_tbl_007;
DROP SEQUENCE  spac_sq_vldtbl_tipo_notif;
  
-- Secuencias para el publicador
DROP SEQUENCE pub_sq_id_acciones;
DROP SEQUENCE pub_sq_id_aplicaciones_hitos;
DROP SEQUENCE pub_sq_id_condiciones;
DROP SEQUENCE pub_sq_id_reglas;

