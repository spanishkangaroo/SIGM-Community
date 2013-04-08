
------------------------------------------------------
-- Configuraci�n del PUBLICADOR para los prototipos --
------------------------------------------------------

--
-- Aplicaci�n de publicaci�n
--

UPDATE pub_aplicaciones_hitos set nombre='PUBLICADOR_SIGEM' where id=1;

--
-- Acciones de publicaci�n
--
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (2, 'CT-Alta Expediente', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.AltaExpedienteAction', 1, 'Consulta Telem�tica - Alta de expediente', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (3, 'CT-Establecer Hito Actual', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.EstablecerHitoActualAction', 1, 'Consulta Telem�tica - Establecer Hito Actual', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (4, 'CT-Establecer Hito Hist�rico', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.EstablecerHitoHistoricoAction', 1, 'Consulta Telem�tica - Establecer Hito Hist�rico', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (5, 'Notificaci�n Telem�tica', 'ieci.tdw.ispac.ispacpublicador.business.action.notificacionTelematica.NotificacionTelematicaAction', 1, 'Notificaci�n Telem�tica', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (6, 'CT-Anexar Ficheros Hito Actual', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.AnexarFicherosHitoActualAction', 1, 'Consulta Telem�tica - Anexar Ficheros al Hito Actual', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (7, 'CT-Solicitud Subsanaci�n', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.SolicitudSubsanacionAction', 1, 'Consulta Telem�tica - Solicitud de Subsanaci�n', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (8, 'CT-Cambio Interesado Expediente', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.CambioInteresadoExpedienteAction', 1, 'Consulta Telem�tica - Cambio del interesado principal del expediente', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (9, 'CT-Cerrar Expediente', 'ieci.tdw.ispac.ispacpublicador.business.action.consultaTelematica.CerrarExpedienteAction', 1, 'Consulta Telem�tica - Cerrar expediente', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (10, 'MC-Env�o e-mail', 'ieci.tdw.ispac.ispacpublicador.business.action.mensajesCortos.EnvioMailAction', 1, 'Mensajes Cortos - Env�o de e-mail', 1);
INSERT INTO pub_acciones (id, nombre, clase, activa, descripcion, tipo) VALUES (11, 'MC-Env�o SMS', 'ieci.tdw.ispac.ispacpublicador.business.action.mensajesCortos.EnvioSmsAction', 1, 'Mensajes Cortos - Env�o de SMS', 1);
ALTER SEQUENCE pub_sq_id_acciones RESTART WITH 12;

--
-- Reglas de publicaci�n
--
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, -1, -1, -1, -1, 8, 5, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''ASUNTO_EMAIL''>Notificaci�n telem�tica/Notificacio telematica/Jakinarazpen telematikoa/Notificaci�n telem�tica</attribute><attribute name=''TEXTO_EMAIL''>Notificaci�n expediente n� ${NUMEXP}/Notificacio expedient num. ${NUMEXP}/${NUMEXP} zk.ko espedientearen jakinarazpena/Notificaci�n expediente n� ${NUMEXP}</attribute><attribute name=''DESCRIPCION_NOTIFICACION''><labels><label locale=''es''>Dispone de una notificaci�n correspondiente al expediente n� ${NUMEXP}. Puede usted recogerla accediendo a su buz�n en la siguiente direcci�n: URL</label><label locale=''eu''>${NUMEXP} zk.ko espedientearen jakinarazpen bat duzu. Hura jasotzeko, postontzira sar zaitezke helbide honetan: URLa</label><label locale=''ca''>Disposeu d''una notificacio corresponent a l''expedient num. ${NUMEXP}. Podeu recollir-la accedint a la vostra bustia a l''adre�a seguent: URL</label><label locale=''gl''>Disp�n dunha notificaci�n correspondente ao expediente n� ${NUMEXP}. Pode recollela accedendo � s�a caixa de correo no seguinte enderezo: URL</label></labels></attribute></attributes>', 1, 1, 1);

INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 6, 0, 0, 3, 2, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''APORTACION''>N</attribute><attribute name=''CODPRES''>1</attribute></attributes>', 1, 2, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 6, 0, 0, 3, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Solicitud recibida</label><label locale=''eu''>Eskaera hartua</label><label locale=''ca''>Sol�licitud rebuda</label><label locale=''gl''>Solicitude recibida</label></labels></attribute></attributes>', 1, 3, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, -1, -1, -1, 8, 8, 1, NULL, 1, 4, 2);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 6, 5, 0, 6, 6, 1, NULL, 1, 5, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 7, 0, 0, 3, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Se est� estudiando su solicitud</label><label locale=''eu''>Zure eskaera estudiatzean dago</label><label locale=''ca''>S''est� estudiant la seva sol�licitud</label><label locale=''gl''>Est� a estudarse a s�a solicitude</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 6, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 7, 8, 0, 6, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Se le enviar� una comunicaci�n referente al expediente</label><label locale=''eu''>Espedienteari buruzko mezu bat bidaliko dizugu</label><label locale=''ca''>Se li enviar� una comunicaci� referent a l''expedient</label><label locale=''gl''>Enviar�selle unha comunicaci�n referente ao expediente</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute><attribute name=''ENVIAR_DOCUMENTOS''>S</attribute></attributes>', 1, 7, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 8, 11, 0, 6, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Se le enviar� una comunicaci�n referente al expediente</label><label locale=''eu''>Espedienteari buruzko mezu bat bidaliko dizugu</label><label locale=''ca''>Se li enviar� una comunicaci� referent a l''expedient</label><label locale=''gl''>Enviar�selle unha comunicaci�n referente ao expediente</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute><attribute name=''ENVIAR_DOCUMENTOS''>S</attribute></attributes>', 1, 8, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 8, 0, 0, 4, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Expediente finalizado</label><label locale=''eu''>Espediente bukatua</label><label locale=''ca''>Expedient finalitzat</label><label locale=''gl''>Expediente finalizado</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 9, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 3, 0, 0, 0, 2, 9, 1, null, 1, 1, 0);

INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 10, 0, 0, 3, 2, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''APORTACION''>N</attribute><attribute name=''CODPRES''>1</attribute></attributes>', 1, 10, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 10, 0, 0, 3, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Solicitud recibida</label><label locale=''eu''>Eskaera hartua</label><label locale=''ca''>Sol�licitud rebuda</label><label locale=''gl''>Solicitude recibida</label></labels></attribute></attributes>', 1, 11, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, -1, -1, -1, 8, 8, 1, NULL, 1, 12, 2);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 10, 15, 0, 5, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Comprobando la documentaci�n aportada</label><label locale=''eu''>Dokumentazio porturatua egiaztatzean</label><label locale=''ca''>Comprovant la documentaci� aportada</label><label locale=''gl''>Comprobando a documentaci�n achegada</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 13, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 10, 15, 0, 5, 7, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''MENSAJE_SUBSANACION''><labels><label locale=''es''>Documentos a subsanar: ${NOMBRE_DOC}.</label><label locale=''eu''>Konpontzera dokumentuak: ${NOMBRE_DOC}.</label><label locale=''ca''>Documents a esmenar: ${NOMBRE_DOC}.</label><label locale=''gl''>Documentos a emendar: ${NOMBRE_DOC}.</label></labels></attribute></attributes>', 1, 14, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 10, 15, 0, 6, 6, 1, NULL, 1, 15, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 11, 0, 0, 3, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Se est� estudiando su solicitud</label><label locale=''eu''>Zure eskaera estudiatzean dago</label><label locale=''ca''>S''est� estudiant la seva sol�licitud</label><label locale=''gl''>Est� a estudarse a s�a solicitude</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 16, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 12, 20, 0, 6, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Decisi�n sobre la solicitud</label><label locale=''eu''>Eskaeraz erabakia</label><label locale=''ca''>Decisi� sobre la sol�licitud</label><label locale=''gl''>Decisi�n sobre a solicitude</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute><attribute name=''ENVIAR_DOCUMENTOS''>S</attribute></attributes>', 1, 17, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 12, 0, 0, 4, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Expediente finalizado</label><label locale=''eu''>Espediente bukatua</label><label locale=''ca''>Expedient finalitzat</label><label locale=''gl''>Expediente finalizado</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 18, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 4, 0, 0, 0, 2, 9, 1, null, 1, 1, 0);

INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 14, 0, 0, 3, 2, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''APORTACION''>N</attribute><attribute name=''CODPRES''>1</attribute></attributes>', 1, 19, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 14, 0, 0, 3, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Solicitud recibida</label><label locale=''eu''>Eskaera hartua</label><label locale=''ca''>Sol�licitud rebuda</label><label locale=''gl''>Solicitude recibida</label></labels></attribute></attributes>', 1, 20, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, -1, -1, -1, 8, 8, 1, NULL, 1, 21, 2);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 14, 33, 0, 5, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Comprobando la documentaci�n aportada</label><label locale=''eu''>Dokumentazio porturatua egiaztatzean</label><label locale=''ca''>Comprovant la documentaci� aportada</label><label locale=''gl''>Comprobando a documentaci�n achegada</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 22, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 14, 33, 0, 5, 7, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''TASA_1''><tax><name>Resguardo del pago de tasa</name><labels><label locale=''es''>Resguardo del pago de tasa</label><label locale=''eu''>Tasaren ordainagiria</label><label locale=''ca''>Protegeixo del pagament de taxa</label><label locale=''gl''>Resgardo do pago de taxa</label></labels><import>1000</import><sender_entity_id>000000</sender_entity_id><self_settlement_id>200</self_settlement_id></tax></attribute><attribute name=''MENSAJE_SUBSANACION''><labels><label locale=''es''>Documentos a subsanar: ${NOMBRE_DOC}.</label><label locale=''eu''>Konpontzera dokumentuak: ${NOMBRE_DOC}.</label><label locale=''ca''>Documents a esmenar: ${NOMBRE_DOC}.</label><label locale=''gl''>Documentos a emendar: ${NOMBRE_DOC}.</label></labels></attribute><attribute name=''MENSAJE_PAGO''><labels><label locale=''es''>Durante la tramitaci�n de su expediente ${NUMEXP} de ${NOMBREPROCEDIMIENTO} se le comunica que es necesario que acredite el pago de la tasa de ${NOMBRE_PAGO} por un valor de ${IMPORTE_PAGO} euros.</label><label locale=''eu''>${NOMBREPROCEDIMIENTO}(e)ko ${NUMEXP} espedientea bideratzen ari dela, jakinarazten zaizu ${NOMBRE_PAGO}ren tasa (${IMPORTE_PAGO} eurokoa) ordaindu izana ziurtatu behar duzula.</label><label locale=''ca''>Durant la tramitacio del vostre expedient ${NUMEXP} de ${NOMBREPROCEDIMIENTO} se us comunica que acrediteu el pagament de la taxa de ${NOMBRE_PAGO} per un valor de ${IMPORTE_PAGO} euros.</label><label locale=''gl''>Durante a tramitaci�n do seu expediente ${NUMEXP} de ${NOMBREPROCEDIMIENTO} comunicar�selle que � necesario que acredite o pagamento da taxa de ${NOMBRE_PAGO} por un valor de ${IMPORTE_PAGO} euros.</label></labels></attribute></attributes>', 1, 23, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 14, 33, 0, 6, 6, 1, NULL, 1, 24, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 15, 0, 0, 3, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Se est� estudiando su solicitud</label><label locale=''eu''>Zure eskaera estudiatzean dago</label><label locale=''ca''>S''est� estudiant la seva sol�licitud</label><label locale=''gl''>Est� a estudarse a s�a solicitude</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 25, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 16, 38, 0, 6, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Decisi�n sobre la solicitud</label><label locale=''eu''>Eskaeraz erabakia</label><label locale=''ca''>Decisi� sobre la sol�licitud</label><label locale=''gl''>Decisi�n sobre a solicitude</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute><attribute name=''ENVIAR_DOCUMENTOS''>S</attribute></attributes>', 1, 26, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 16, 0, 0, 4, 3, 1, '<?xml version=''1.0'' encoding=''ISO-8859-1''?><attributes><attribute name=''DESCRIPCION''><labels><label locale=''es''>Expediente finalizado</label><label locale=''eu''>Espediente bukatua</label><label locale=''ca''>Expedient finalitzat</label><label locale=''gl''>Expediente finalizado</label></labels></attribute><attribute name=''PASO_A_HISTORICO''>S</attribute></attributes>', 1, 27, 0);
INSERT INTO pub_reglas (id, id_pcd, id_fase, id_tramite, tipo_doc, id_evento, id_accion, id_condicion, atributos, id_aplicacion, orden, id_info) VALUES (NEXTVAL FOR pub_sq_id_reglas, 5, 0, 0, 0, 2, 9, 1, null, 1, 1, 0);
