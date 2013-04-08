--
-- Tablas del Publicador
--
CREATE TABLE pub_acciones (
    id integer NOT NULL,
    nombre character varying(255),
    clase character varying(255),
    activa smallint DEFAULT 0,
    descripcion character varying(255),
    tipo smallint DEFAULT 1
);
CREATE TABLE pub_aplicaciones_hitos (
    id integer NOT NULL,
    nombre character varying(255),
    activa smallint
);
CREATE TABLE pub_condiciones (
    id integer NOT NULL,
    nombre character varying(255),
    clase character varying(255),
    descripcion character varying(255)
);
CREATE TABLE pub_errores (
    id_hito integer NOT NULL,
    id_aplicacion integer NOT NULL,
    id_sistema character varying(32) NOT NULL,
    id_objeto character varying(64) NOT NULL,
    descripcion character varying(255),
    id_error integer
);
CREATE TABLE pub_hitos_activos (
    id_hito integer NOT NULL,
    id_pcd integer,
    id_fase integer,
    id_tramite integer,
    tipo_doc integer,
    id_objeto character varying(64),
    id_evento integer,
    estado smallint,
    id_aplicacion integer NOT NULL,
    ip_maquina character varying(15),
    fecha timestamp without time zone,
    id_sistema character varying(32) NOT NULL,
    info_aux text,
    id_info integer
);
CREATE TABLE pub_reglas (
    id integer NOT NULL,
    id_pcd integer,
    id_fase integer,
    id_tramite integer,
    tipo_doc integer,
    id_evento integer,
    id_accion integer,
    id_condicion integer,
    atributos text,
    id_aplicacion integer,
    orden integer,
    id_info integer
);
CREATE TABLE pub_ultimo_hito_tratado (
    id_sistema character varying(32) NOT NULL,
    id_hito integer
);

--
-- Tablas internas del tramitador
--
CREATE TABLE spac_anotaciones (
    id integer NOT NULL,
    id_exp integer,
    id_fase integer,
    id_tramite integer,
    fecha timestamp without time zone,
    autor character varying(250),
    texto character varying(4000)
);
CREATE TABLE spac_avisos_electronicos (
    id_aviso integer NOT NULL,
    id_proc integer,
    id_resp integer,
    tipo_destinatario smallint,
    id_destinatario integer,
    fecha date,
    id_expediente character varying(64),
    id_fase integer,
    id_tramite integer,
    id_fase_pcd integer,
    id_tramite_pcd integer,
    estado_aviso smallint,
    mensaje character varying(254),
    tipo_aviso character varying(64),
    id_mproc integer,
    uid_resp character varying(250),
    uid_destinatario character varying(250)
);

CREATE TABLE spac_calendarios
(
  id numeric NOT NULL, -- Identificador �nico del calendario
  calendario text, -- Calendarios de festivos
  nombre character varying(256)

);

CREATE TABLE spac_ct_aplicaciones (
    id integer NOT NULL,
    nombre character varying(100),
    descripcion character varying(250),
    clase character varying(250),
    pagina character varying(250),
    parametros text,
    formateador character varying(250),
	xml_formateador text,
    frm_jsp text,
    frm_version smallint,
    ent_principal_id integer,
    ent_principal_nombre character varying(100),
	documentos character varying(2)  DEFAULT 'NO'::character varying
);
CREATE TABLE spac_ct_entidades (
    id integer NOT NULL,
    tipo smallint,
    nombre character varying(100),
    campo_pk character varying(100),
    campo_numexp character varying(100),
    schema_expr character varying(100),
    frm_edit integer,
    descripcion character varying(250),
    sec_pk character varying(100),
    definicion text,
    frm_jsp text,
    fecha timestamp with time zone
);
CREATE TABLE spac_ct_entidades_resources (
    id integer NOT NULL,
    id_ent integer NOT NULL,
    idioma character varying(5),
    clave character varying(250),
    valor character varying(250)
);
CREATE TABLE spac_ct_fases (
    id integer NOT NULL,
    nombre character varying(250),
    orden integer,
    cod_fase character varying(16),
    falta timestamp without time zone,
    descripcion character varying(1024),
    observaciones character varying(500),
    autor character varying(64)
);
CREATE TABLE spac_ct_frmbusqueda (
    id integer NOT NULL,
    descripcion character varying(250),
    autor character varying(100),
    fecha timestamp without time zone,
    frm_bsq text,
    tipo smallint
);

CREATE TABLE spac_ct_frmbusqueda_org
(
  id integer NOT NULL,
  id_searchfrm integer,
  uid_usr character varying(32)
);

CREATE TABLE spac_ct_fstr (
    id integer NOT NULL,
    id_fase integer,
    id_tramite integer
);
CREATE TABLE spac_ct_pcdorg (
    id integer NOT NULL,
    cod_pcd character varying(100) NOT NULL,
    id_unidad_tramitadora character varying(250) NOT NULL,
    fecha_ini_prod date,
    orden integer
);
CREATE TABLE spac_ct_procedimientos (
    id integer NOT NULL,
    cod_pcd character varying(100),
    nombre character varying(250),
    id_padre integer,
    titulo character varying(254),
    objeto character varying(254),
    asunto character varying(512),
    act_func character varying(2),
    mtrs_comp character varying(2),
    sit_tlm character varying(2),
    url character varying(254),
    interesado character varying(64),
    tp_rel character varying(4),
    org_rsltr character varying(80),
    forma_inic character varying(1),
    plz_resol integer,
    unid_plz character varying(1),
    finicio date,
    ffin date,
    efec_silen character varying(1),
    fin_via_admin character varying(2),
    recursos character varying(500),
    fcatalog date,
    autor character varying(64),
    estado character varying(1),
    nversion smallint,
    observaciones character varying(500),
    lugar_present character varying(500),
    cnds_ecnmcs character varying(500),
    ingresos character varying(1024),
    f_cbr_pgo character varying(1024),
    infr_sanc character varying(1024),
    calendario character varying(1024),
    dscr_tram character varying(1024),
    normativa character varying(1024),
    cnd_particip character varying(500),
    documentacion text,
    grupos_delegacion character varying(1000),
    cod_sistema_productor character varying(2) DEFAULT '00'::character varying,
    mapeo_rt text
);
CREATE TABLE spac_ct_reglas (
    id integer NOT NULL,
    nombre character varying(100),
    descripcion character varying(250),
    clase character varying(250),
    tipo smallint
);
CREATE TABLE spac_ct_tpdoc (
    id integer NOT NULL,
    nombre character varying(100),
    cod_tpdoc character varying(16),
    tipo character varying(64),
    autor character varying(64),
    descripcion character varying(1024),
    fecha timestamp without time zone,
    tiporeg character varying(64),
    observaciones character varying(512)
);
CREATE TABLE spac_ct_tramites (
    id integer NOT NULL,
    nombre character varying(250),
    cod_tram character varying(16),
    descripcion character varying(1024),
    tipo character varying(32),
    ordenacion character varying(2),
    observaciones character varying(512),
    fcreacion timestamp without time zone,
    autor character varying(64),
    id_subproceso integer
);
CREATE TABLE spac_ct_trtd (
    id integer NOT NULL,
    id_tramite integer,
    id_tpdoc integer
);
CREATE TABLE spac_ctos_firma (
    id integer NOT NULL,
    id_instancia_circuito integer,
    fecha date,
    id_documento integer,
    id_circuito integer,
    id_paso integer,
    id_firmante character varying(128),
    nombre_firmante character varying(32),
    estado smallint
);
CREATE TABLE spac_ctos_firma_cabecera (
    id_circuito integer NOT NULL,
    num_pasos smallint,
    descripcion character varying(256),
	tipo smallint,
	sistema character varying(64),
	secuencia character varying(64),
	aplicacion character varying(64)
);
CREATE TABLE spac_p_ctosfirma (
    id integer NOT NULL,
    id_circuito integer,
	id_pcd integer
);
CREATE TABLE spac_ctos_firma_detalle (
    id integer NOT NULL,
    id_circuito integer,
    id_paso integer,
    id_firmante character varying(128),
    nombre_firmante character varying(32),
	tipo_notif character varying(2),
	dir_notif character varying(64),
	tipo_firmante character varying(16)
);
CREATE TABLE spac_docobj (
    id integer NOT NULL,
    tam integer,
    obj bytea,
    mimetype character varying(40)
);
CREATE TABLE spac_dt_documentos (
    id integer NOT NULL,
    numexp character varying(30),
    fdoc timestamp without time zone,
    nombre character varying(100),
    autor character varying(250),
    id_fase integer,
    id_tramite integer,
    id_tpdoc integer,
    tp_reg character varying(16),
    nreg character varying(64),
    freg timestamp without time zone,
    infopag character varying(100),
    id_fase_pcd integer,
    id_tramite_pcd integer,
    estado character varying(16),
    origen character varying(250),
    descripcion character varying(250),
    origen_id character varying(20),
    destino character varying(250),
    autor_info character varying(250),
    estadofirma character varying(2),
	id_notificacion character varying(64),
    estadonotificacion character varying(2),
    destino_id character varying(20),
    fnotificacion timestamp without time zone,
    faprobacion timestamp without time zone,
    origen_tipo character varying(1),
    destino_tipo character varying(1),
    id_plantilla integer,
    bloqueo character(2),
    repositorio character varying(8),
    extension character varying(64),
    ffirma timestamp without time zone,
    infopag_rde character varying(256),
    extension_rde character varying(64),
    id_reg_entidad integer,
	id_entidad integer,
	cod_cotejo character varying(50),
	id_proceso_firma text,
	id_circuito integer,
	hash character varying(512),
	funcion_hash character varying(128)
);
CREATE TABLE spac_dt_intervinientes (
    id integer NOT NULL,
    id_ext character varying(32),
    numexp character varying(30),
    rol character varying(4),
    tipo smallint,
    tipo_persona character varying(1),
    ndoc character varying(12),
    nombre character varying(250),
    iddireccionpostal character varying(32),
    dirnot character varying(250),
    email character varying(250),
    c_postal character varying(10),
    localidad character varying(150),
    caut character varying(150),
    tfno_fijo character varying(32),
    tfno_movil character varying(32),
    tipo_direccion character(1),
    direcciontelematica character varying(60)
);
CREATE TABLE spac_dt_tramites (
    id integer NOT NULL,
    numexp character varying(30),
    nombre character varying(250),
    estado smallint,
    id_tram_pcd integer,
    id_fase_pcd integer,
    id_fase_exp integer,
    id_tram_exp integer,
    id_tram_ctl integer,
    num_acto character varying(16),
    cod_acto character varying(16),
    estado_info character varying(100),
    fecha_inicio timestamp without time zone,
    fecha_cierre timestamp without time zone,
    fecha_limite timestamp without time zone,
    fecha_fin timestamp without time zone,
    fecha_inicio_plazo timestamp without time zone,
    plazo integer,
    uplazo character varying(1),
    observaciones character varying(254),
    descripcion character varying(100),
    und_resp character varying(250),
    fase_pcd character varying(250),
    id_subproceso integer,
    id_resp_closed character varying(250)
);
CREATE TABLE spac_registros_es(
  id integer NOT NULL,
  numexp character varying(30) NOT NULL,
  nreg character varying(32),
  freg timestamp without time zone,
  asunto text,
  id_interesado character varying(32),
  interesado character varying(128),
  tp_reg character varying(16),
  id_tramite integer,
  origino_expediente character varying(2)
);
CREATE TABLE spac_exp_relacionados (
    id integer NOT NULL,
    numexp_padre character varying(30) NOT NULL,
    numexp_hijo character varying(30) NOT NULL,
    relacion character varying(64)
);
CREATE TABLE spac_expedientes (
    id integer NOT NULL,
    id_pcd integer,
    numexp character varying(30),
    referencia_interna character varying(30),
    nreg character varying(64),
    freg timestamp without time zone,
    estadoinfo character varying(128),
    festado timestamp without time zone,
    nifciftitular character varying(16),
    idtitular character varying(32),
    iddireccionpostal character varying(32),
    domicilio character varying(128),
    ciudad character varying(64),
    regionpais character varying(64),
    cpostal character varying(5),
    identidadtitular character varying(128),
    tipopersona character varying(1),
    roltitular character varying(4),
    asunto character varying(512),
    finicioplazo timestamp without time zone,
    poblacion character varying(64),
    municipio character varying(64),
    localizacion character varying(256),
    exprelacionados character varying(256),
    codprocedimiento character varying(16),
    nombreprocedimiento character varying(128),
    plazo integer,
    uplazo character varying(1),
    formaterminacion character varying(1),
    utramitadora character varying(256),
    funcionactividad character varying(80),
    materias character varying(2),
    servpresactuaciones character varying(128),
    tipodedocumental character varying(16),
    palabrasclave character varying(64),
    fcierre timestamp without time zone,
    estadoadm character varying(128),
    hayrecurso character varying(2),
    efectosdelsilencio character varying(1),
    fapertura timestamp without time zone,
    observaciones character varying(256),
    idunidadtramitadora character varying(250),
    idproceso integer,
    tipodireccioninteresado character varying(16),
    nversion character varying(16),
    idseccioniniciadora character varying(64),
    seccioniniciadora character varying(250),
    tfnofijo character varying(32),
    tfnomovil character varying(32),
    direcciontelematica character varying(60)
);

CREATE TABLE spac_fases (
    id integer NOT NULL,
	id_fase_bpm character varying(64),
    id_exp integer,
    id_pcd integer,
    id_fase integer,
    numexp character varying(30),
    fecha_inicio date,
    fecha_limite date,
    estado smallint,
    observaciones character varying(4000),
    id_resp character varying(250),
	resp character varying (250),
    id_resp_sec character varying(250),
	resp_sec character varying(250),
	estado_plazo integer,
	num_dias_plazo integer,
	id_calendario integer,
	tipo smallint,
	fecha_inicio_plazo date,
	estado_anterior smallint
);

CREATE TABLE spac_gestion_aplicaciones (
    id integer NOT NULL,
    nombre_aplicacion_gestion character varying(100),
    enlace character varying(50),
    clsid character varying(50),
    codebase character varying(50)
);
CREATE TABLE spac_gestion_fases (
    id integer NOT NULL,
    id_pcd integer NOT NULL,
    id_fase integer,
    id_aplicacion_gestion integer NOT NULL
);
CREATE TABLE spac_hitos (
    id integer NOT NULL,
    id_exp integer,
    id_fase integer,
    id_tramite integer,
    hito integer,
    fecha timestamp without time zone,
    fecha_limite timestamp without time zone,
    info text,
    autor character varying(250),
    descripcion character varying(250),
    id_info integer
);
CREATE TABLE spac_infotramite (
    id integer NOT NULL,
    numexp character varying(30),
    id_tramite integer,
    id_ct_tramite integer,
    id_pcd integer,
    id_p_fase integer,
    info text
);
CREATE TABLE spac_infosistema (
	id integer NOT NULL,
  	codigo character varying (16) NOT NULL,
	valor character varying (16) NOT NULL,
	fecha_actualizacion timestamp NOT NULL
);
CREATE TABLE spac_p_blp (
    id integer NOT NULL,
    nbytes integer,
    bloque bytea,
    mimetype character varying(40)
);
CREATE TABLE spac_p_entidades (
    id integer NOT NULL,
    id_ent integer,
    id_pcd integer,
    tp_rel integer,
    orden integer,
    frm_edit integer,
    frm_readonly smallint,
    id_rule_frm integer,
    id_rule_visible integer
);
CREATE TABLE spac_p_eventos (
    id_obj integer NOT NULL,
    tp_obj integer NOT NULL,
    evento integer NOT NULL,
    orden integer NOT NULL,
    id_regla integer,
	condicion text
);
CREATE TABLE spac_p_fases (
    id integer NOT NULL,
    id_ctfase integer,
    id_pcd integer,
    nombre character varying(250),
    id_resp character varying(250),
    id_resp_sec character varying(250)
);
CREATE TABLE spac_p_flujos (
    id integer NOT NULL,
    id_flujo_bpm character varying(64),
    id_pcd integer,
    id_origen integer,
    id_destino integer
);
CREATE TABLE spac_p_frmfases (
    id integer NOT NULL,
    id_ent integer,
    id_fase integer,
    frm_edit integer,
    frm_readonly smallint,
    id_rule_frm integer,
    id_rule_visible integer
);
CREATE TABLE spac_p_frmtramites (
    id integer NOT NULL,
    id_ent integer,
    id_tramite integer,
    frm_edit integer,
    frm_readonly smallint,
    id_rule_frm integer,
    id_rule_visible integer
);
CREATE TABLE spac_p_fstd (
    id integer NOT NULL,
    id_fase integer,
    id_tpdoc integer
);
CREATE TABLE spac_p_nodos (
    id integer NOT NULL,
    id_nodo_bpm character varying(64),
    id_pcd integer,
    tipo integer,
    g_info character varying(4000)
);
CREATE TABLE spac_p_plantdoc (
    id integer NOT NULL,
    id_tpdoc integer,
    fecha timestamp without time zone,
    nombre character varying(250),
	cod_plant character varying(16),
    expresion character varying(2000),
    mimetype character varying(60),
    path character varying(250),
    estacion character varying(250)
);
CREATE TABLE spac_p_plantillas (
    id integer NOT NULL,
    id_p_plantdoc integer,
    id_pcd integer
);
CREATE TABLE spac_p_plazos (
    id integer NOT NULL,
    plazo character varying(250)
);
CREATE TABLE spac_p_procedimientos (
    id integer NOT NULL,
    id_pcd_bpm character varying(64),
    nversion smallint,
    nombre character varying(250),
    estado smallint,
    tipo smallint DEFAULT 1,
    id_resp character varying(250),
    id_resp_sec character varying(250),
    id_group integer,
    id_crt character varying(250),
	nombre_crt character varying(250),
    ts_crt date,
    id_upd character varying(250),
	nombre_upd character varying(250),
    ts_upd date
);
CREATE TABLE spac_p_relplazos (
    id integer NOT NULL,
    tp_obj integer NOT NULL,
    id_obj integer NOT NULL
);
CREATE TABLE spac_p_sincnodo (
    id integer NOT NULL,
    id_pcd integer,
    tipo smallint
);
CREATE TABLE spac_p_tramites (
    id integer NOT NULL,
    id_cttramite integer,
    id_tramite_bpm character varying(64),
    id_pcd integer,
    id_fase integer,
    nombre character varying(250),
	orden integer,
	obligatorio smallint,
    libre smallint,
    id_resp character varying(250),
    id_resp_sec character varying(250),
    id_pcd_sub integer
);
CREATE TABLE spac_p_dep_tramites (
    id integer NOT NULL,
    id_tramite_padre integer NOT NULL,
    id_tramite_hijo integer NOT NULL
);
CREATE TABLE spac_p_versplant (
    id integer NOT NULL,
    id_plant integer,
    fecha timestamp without time zone,
    usuario character varying(250),
    estado smallint
);

CREATE TABLE spac_procesos (
    id integer NOT NULL,
    id_proceso_bpm character varying(64),
	id_pcd integer,
    numexp character varying(30),
    estado smallint,
    fecha_inicio timestamp without time zone,
    fecha_limite timestamp without time zone,
    fecha_cierre timestamp without time zone,
    id_resp character varying(250),
	resp character varying (250),
    id_resp_sec character varying(250),
	resp_sec character varying(250),
    estado_plazo integer,
	num_dias_plazo integer,
	id_calendario integer,
	tipo smallint,
	fecha_inicio_plazo timestamp without time zone,
	fecha_eliminacion timestamp without time zone,
	estado_anterior smallint
);


CREATE TABLE spac_s_bloqueos (
    id character varying(200),
    tp_obj integer NOT NULL,
    id_obj integer NOT NULL,
    numexp character varying(30) NOT NULL,
    fecha timestamp without time zone
);

CREATE TABLE spac_s_sesiones (
    id character varying(200) NOT NULL,
    fecha timestamp without time zone,
    datos character varying(4000),
    usuario character varying(250),
    hits integer,
    tiempo_op numeric,
    tiempo_ss numeric,
    host character varying(150),
    keep_alive timestamp with time zone,
    aplicacion character varying(32)
);

CREATE TABLE spac_s_vars (
    id integer NOT NULL,
    nombre character varying(60),
    valor character varying(4000),
    id_ses character varying(200)
);
CREATE TABLE spac_sincnodo (
    id integer NOT NULL,
    id_exp integer,
    id_nodo integer,
    estado character varying(4000),
    id_pcd integer,
    tipo smallint
);
CREATE TABLE spac_ss_funciones (
    id integer NOT NULL,
    uid_usr character varying(120),
    funcion numeric
);
CREATE TABLE spac_ss_permisos (
    id integer NOT NULL,
    id_pcd integer,
    uid_usr character varying(120),
    permiso numeric
);
CREATE TABLE spac_ss_supervision (
    id integer NOT NULL,
    uid_supervisor character varying(120),
    uid_supervisado character varying(120),
    tipo numeric
);
CREATE TABLE spac_tbl_001 (
    id integer NOT NULL,
    valor character varying(1),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_002 (
    id integer NOT NULL,
    valor character varying(4),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_003 (
    id integer NOT NULL,
    valor character varying(8),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_004 (
    id integer NOT NULL,
    valor character varying(8),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_005 (
    id integer NOT NULL,
    valor character varying(8),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_006 (
    id integer NOT NULL,
    valor character varying(8),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_008 (
    id integer NOT NULL,
    valor character varying(8),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_009 (
  	id integer NOT NULL,
    valor character varying(2),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tramitaciones_agrupadas (
    id integer NOT NULL,
    id_resp character varying(250),
    estado smallint,
    id_fase integer,
    id_ultimo_tramite integer,
    id_ultimo_tipodoc integer,
    id_ultimo_template integer,
    fecha_creacion timestamp without time zone
);
CREATE TABLE spac_tramitcs_agrupadas_exps (
    id integer NOT NULL,
    id_tram_agrup integer NOT NULL,
    numexp character varying(30)
);
CREATE TABLE spac_tramites (
    id integer NOT NULL,
	id_tramite_bpm character varying(64),
    id_exp integer,
    id_pcd integer,
    id_fase_exp integer,
    id_fase_pcd integer,
    id_tramite integer,
    id_cttramite integer,
    numexp character varying(30),
    nombre character varying(250),
    fecha_inicio date,
    fecha_limite date,
    estado smallint,
    observaciones character varying(4000),
    id_resp character varying(250),
	resp character varying (250),
    id_resp_sec character varying(250),
	resp_sec character varying(250),
    estado_plazo integer,
	num_dias_plazo integer,
	id_calendario integer,
	tipo smallint,
	id_subproceso integer,
	fecha_inicio_plazo date,
	estado_anterior smallint
);

CREATE TABLE spac_vars (
    id integer NOT NULL,
    nombre character varying(64),
    valor text,
    descripcion character varying(256)
);
CREATE TABLE spac_vldtbl_acts_funcs (
    id integer NOT NULL,
    valor character varying(2),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_efec_slncio (
    id integer NOT NULL,
    valor character varying(1),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_forma_inic (
    id integer NOT NULL,
    valor character varying(1),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_mats_comp (
    id integer NOT NULL,
    valor character varying(2),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_recursos (
    id integer NOT NULL,
    valor character varying(2),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_sist_productores (
    id integer NOT NULL,
    valor character varying(2),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_sit_tlm (
    id integer NOT NULL,
    valor character varying(2),
    sustituto character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_tiporeg (
    id integer NOT NULL,
    valor character varying(10),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_tipos_docs (
    id integer,
    valor character varying(64),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_vldtbl_tipos_tram (
    id integer,
    valor character varying(32),
    vigente numeric(1),
	orden numeric(10)
);
CREATE TABLE spac_tbl_007 (
    id integer,
    valor character varying(64),
    vigente numeric(1),
	orden numeric(10)
);

CREATE TABLE spac_vldtbl_tipo_notif (
    id integer NOT NULL,
    valor character varying(2),
    sustituto character varying(64),
    vigente numeric(1),
    orden numeric(10)
);

CREATE TABLE spac_ss_sustitucion (
	id integer NOT NULL,
	uid_sustituto character varying(120),
	uid_sustituido character varying(120)
);
CREATE TABLE spac_ss_fechsustituciones (
  id integer NOT NULL,
  fecha_inicio date,
  fecha_fin date,
  descripcion character varying(255)
);
CREATE TABLE spac_ss_sustitucionfecha (
	id integer NOT NULL,
	id_sustitucion integer,
	id_fechsustitucion integer
);

CREATE TABLE spac_numexp_contador (
	anio integer NOT NULL,
	contador integer,
	formato character varying(32),
	id_pcd integer NOT NULL DEFAULT -1
);


CREATE TABLE spac_ct_informes (
  	id integer NOT NULL,
  	nombre character varying(100),
  	descripcion character varying(255),
  	xml text,
  	fecha timestamp without time zone,
  	tipo integer,
  	filas smallint,
  	columnas smallint,
	frm_params text,
	visibilidad smallint DEFAULT 0

);

CREATE TABLE spac_p_informes (
  	id_obj integer NOT NULL,
  	tp_obj integer NOT NULL,
  	id_informe integer NOT NULL
);

CREATE TABLE spac_ct_frmbusq_informes (
  	id_fmrbusqueda integer NOT NULL,
  	id_informe integer NOT NULL
);

CREATE TABLE spac_ct_informes_org
(
  id          integer   NOT NULL,
  id_informe  integer,
  uid_usr     character varying(32)
);


CREATE TABLE spac_ct_jerarquias(
  id integer NOT NULL,
  id_entidad_padre integer,
  id_entidad_hija integer,
  nombre character varying(64),
  descripcion character varying(4000),
  tipo integer DEFAULT 1
);

CREATE TABLE spac_ayudas
(
	id 			integer 				NOT NULL,
	nombre		character varying(100),
	tipo_obj 	integer,
	id_obj 		integer,
	idioma 		character varying(5),
	contenido   text
);



CREATE TABLE SPAC_PERMISOS
(
   tp_obj   integer not null not null,
   id_obj   integer not null not null ,
   id_resp  character varying (250) not null,
   resp_name character varying (250)not null ,
   permiso integer not null
);

