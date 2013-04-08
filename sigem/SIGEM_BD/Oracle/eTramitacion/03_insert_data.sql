--
-- Data for: sgm_pe_al12nsec
--

INSERT INTO sgm_pe_al12nsec (numsec, minimo, maximo) VALUES (1, 1, 1000);


--
-- Data for: sgm_pe_al3nsec
--

INSERT INTO sgm_pe_al3nsec (modelo, numsec, minimo, maximo) VALUES ('001', 1, 1, 1000);


--
-- Data for: sgm_pe_tasas
--

INSERT INTO sgm_pe_tasas (codigo, id_entidad_emisora, nombre, tipo, modelo, captura, datos_especificos) VALUES ('000', '000000', 'Liquidacion AL2', 'AL2', '', '', '');
INSERT INTO sgm_pe_tasas (codigo, id_entidad_emisora, nombre, tipo, modelo, captura, datos_especificos) VALUES ('100', '000000', 'Liquidacion AL1', 'AL1', '', '', '<NOMBRE>Tributo del Ayuntamiento</NOMBRE>');
INSERT INTO sgm_pe_tasas (codigo, id_entidad_emisora, nombre, tipo, modelo, captura, datos_especificos) VALUES ('200', '000000', 'Prueba autoliquidacion', 'AL3', '001', '0', '<NOMBRE>AUTOLIQUIDACION DE PRUEBAS</NOMBRE>');


--
-- Data for: sgmntinfo_estado_noti
--

INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (-2, 'Notificacion con errores', 'Error devuelto por conector');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (-1, 'Fallo', 'Fallo');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (0, 'Notificación creada', 'Notificación creada');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (1, 'Notificación enviada', 'Notificación enviada');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (2, 'Notificación puesta a disposición', 'Notificación puesta a disposición');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (3, 'Notificacion leída', 'Notificacion leída');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (4, 'Notificación expirada después de 10 días', 'Notificación expirada después de 10 días');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (5, 'Notificación rechazada', 'Notificación rechazada');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (6, 'Notificación finalizada (Cambio de estado comunicado al sistema emisor)', 'Notificación finalizada (Cambio de estado comunicado al sistema emisor)');
INSERT INTO sgmntinfo_estado_noti (cguid, cuidsisnot, cdescripcion) VALUES (7, 'Usuario no suscrito', 'Usuario no suscrito');


--
-- Data for: sgmrdetiposmime
--

INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('3dm', 'x-world/x-3dmf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('3dmf', 'x-world/x-3dmf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('a', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aab', 'application/x-authorware-bin');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aam', 'application/x-authorware-map');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aas', 'application/x-authorware-seg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('abc', 'text/vnd.abc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('acgi', 'text/html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('afl', 'video/animaflex');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ai', 'application/postscript');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aif', 'audio/aiff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aifc', 'audio/aiff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aiff', 'audio/aiff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aim', 'application/x-aim');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aip', 'text/x-audiosoft-intra');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ani', 'application/x-navi-animation');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aos', 'application/x-nokia-9000-communicator-add-on-software');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('aps', 'application/mime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('arc', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('arj', 'application/arj');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('art', 'image/x-jg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('asf', 'video/x-ms-asf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('asm', 'text/x-asm');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('asp', 'text/asp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('asx', 'video/x-ms-asf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('au', 'audio/basic');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('avi', 'video/avi');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('avs', 'video/avs-video');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bcpio', 'application/x-bcpio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bin', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bm', 'image/bmp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bmp', 'image/bmp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('boo', 'application/book');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('book', 'application/book');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('boz', 'application/x-bzip2');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bsh', 'application/x-bsh');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bz', 'application/x-bzip');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('bz2', 'application/x-bzip2');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('c', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('c++', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cat', 'application/vnd.ms-pki.seccat');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cc', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ccad', 'application/clariscad');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cco', 'application/x-cocoa');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cdf', 'application/cdf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cer', 'application/x-x509-ca-cert');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cha', 'application/x-chat');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('chat', 'application/x-chat');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('class', 'application/java');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('com', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('conf', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cpio', 'application/x-cpio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cpp', 'text/x-c');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cpt', 'application/x-compactpro');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('crl', 'application/pkcs-crl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('crt', 'application/x-x509-user-cert');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('csh', 'application/x-csh');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('css', 'text/css');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('cxx', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dcr', 'application/x-director');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('deepv', 'application/x-deepv');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('def', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('der', 'application/x-x509-ca-cert');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dif', 'video/x-dv');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dir', 'application/x-director');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dl', 'video/dl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('doc', 'application/msword');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dot', 'application/msword');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dp', 'application/commonground');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('drw', 'application/drafting');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dump', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dv', 'video/x-dv');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dvi', 'application/x-dvi');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dwf', 'model/vnd.dwf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dwg', 'image/vnd.dwg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dxf', 'application/dxf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('dxr', 'application/x-director');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('el', 'text/x-script.elisp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('elc', 'application/x-elc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('env', 'application/x-envoy');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('eps', 'application/postscript');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('es', 'application/x-esrehber');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('etx', 'text/x-setext');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('evy', 'application/envoy');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('exe', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('f', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('f77', 'text/x-fortran');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('f90', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('fdf', 'application/vnd.fdf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('fif', 'application/fractals');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('fli', 'video/fli');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('flo', 'image/florian');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('flx', 'text/vnd.fmi.flexstor');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('fmf', 'video/x-atomic3d-feature');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('for', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('fpx', 'image/vnd.fpx');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('frl', 'application/freeloader');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('funk', 'audio/make');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('g', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('g3', 'image/g3fax');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gif', 'image/gif');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gl', 'video/gl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gsd', 'audio/x-gsm');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gsm', 'audio/x-gsm');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gsp', 'application/x-gsp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gss', 'application/x-gss');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gtar', 'application/x-gtar');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gz', 'application/x-compressed');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('gzip', 'application/x-gzip');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('h', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hdf', 'application/x-hdf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('help', 'application/x-helpfile');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hgl', 'application/vnd.hp-hpgl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hh', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hlb', 'text/x-script');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hlp', 'application/hlp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hpg', 'application/vnd.hp-hpgl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hpgl', 'application/vnd.hp-hpgl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hqx', 'application/binhex');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('hta', 'application/hta');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('htc', 'text/x-component');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('htm', 'text/html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('html', 'text/html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('htmls', 'text/html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('htt', 'text/webviewhtml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('htx', 'text/html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ice', 'x-conference/x-cooltalk');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ico', 'image/x-icon');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('idc', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ief', 'image/ief');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('iefs', 'image/ief');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('iges', 'application/iges');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('igs', 'application/iges');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ima', 'application/x-ima');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('imap', 'application/x-httpd-imap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('inf', 'application/inf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ins', 'application/x-internett-signup');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ip', 'application/x-ip2');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('isu', 'video/x-isvideo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('it', 'audio/it');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('iv', 'application/x-inventor');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ivr', 'i-world/i-vrml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ivy', 'application/x-livescreen');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jam', 'audio/x-jam');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jav', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('java', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jcm', 'application/x-java-commerce');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jfif', 'image/jpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jfif-tbn', 'image/jpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jpe', 'image/jpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jpeg', 'image/jpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jpg', 'image/jpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jps', 'image/x-jps');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('js', 'application/x-javascript');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('jut', 'image/jutvision');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('kar', 'audio/midi');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ksh', 'application/x-ksh');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('la', 'audio/nspaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lam', 'audio/x-liveaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('latex', 'application/x-latex');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lha', 'application/lha');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lhx', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('list', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lma', 'audio/nspaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('log', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lsp', 'application/x-lisp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lst', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lsx', 'text/x-la-asf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ltx', 'application/x-latex');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lzh', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('lzx', 'application/lzx');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('m', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('m1v', 'video/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('m2a', 'audio/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('m2v', 'video/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('m3u', 'audio/x-mpequrl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('man', 'application/x-troff-man');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('map', 'application/x-navimap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mar', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mbd', 'application/mbedlet');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mc$', 'application/x-magic-cap-package-1.0');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mcd', 'application/mcad');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mcf', 'image/vasa');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mcp', 'application/netmc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('me', 'application/x-troff-me');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mht', 'message/rfc822');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mhtml', 'message/rfc822');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mid', 'audio/midi');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('midi', 'audio/midi');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mif', 'application/x-frame');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mime', 'message/rfc822');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mjf', 'audio/x-vnd.audioexplosion.mjuicemediafile');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mjpg', 'video/x-motion-jpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mm', 'application/base64');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mme', 'application/base64');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mod', 'audio/mod');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('moov', 'video/quicktime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mov', 'video/quicktime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('movie', 'video/x-sgi-movie');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mp2', 'audio/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mp3', 'audio/mpeg3');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpa', 'audio/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpc', 'application/x-project');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpe', 'video/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpeg', 'video/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpg', 'video/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpga', 'audio/mpeg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpp', 'application/vnd.ms-project');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpt', 'application/x-project');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpv', 'application/x-project');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mpx', 'application/x-project');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mrc', 'application/marc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ms', 'application/x-troff-ms');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mv', 'video/x-sgi-movie');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('my', 'audio/make');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('mzz', 'application/x-vnd.audioexplosion.mzz');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('nap', 'image/naplps');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('naplps', 'image/naplps');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('nc', 'application/x-netcdf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ncm', 'application/vnd.nokia.configuration-message');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('nif', 'image/x-niff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('niff', 'image/x-niff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('nix', 'application/x-mix-transfer');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('nsc', 'application/x-conference');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('nvd', 'application/x-navidoc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('o', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('oda', 'application/oda');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('omc', 'application/x-omc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('omcd', 'application/x-omcdatamaker');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('omcr', 'application/x-omcregerator');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p', 'text/x-pascal');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p10', 'application/pkcs10');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p12', 'application/pkcs-12');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p7a', 'application/x-pkcs7-signature');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p7c', 'application/pkcs7-mime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p7m', 'application/pkcs7-mime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p7r', 'application/x-pkcs7-certreqresp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('p7s', 'application/pkcs7-signature');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('part', 'application/pro_eng');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pas', 'text/pascal');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pbm', 'image/x-portable-bitmap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pcl', 'application/x-pcl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pct', 'image/x-pict');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pcx', 'image/x-pcx');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pdb', 'chemical/x-pdb');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pdf', 'application/pdf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pfunk', 'audio/make');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pgm', 'image/x-portable-graymap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pic', 'image/pict');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pict', 'image/pict');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pkg', 'application/x-newton-compatible-pkg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pko', 'application/vnd.ms-pki.pko');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pl', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('plx', 'application/x-pixclscript');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pm', 'image/x-xpixmap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pm4', 'application/x-pagemaker');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pm5', 'application/x-pagemaker');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('png', 'image/png');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pnm', 'application/x-portable-anymap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pot', 'application/mspowerpoint');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pov', 'model/x-pov');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ppa', 'application/vnd.ms-powerpoint');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ppm', 'image/x-portable-pixmap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pps', 'application/mspowerpoint');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ppt', 'application/mspowerpoint');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ppz', 'application/mspowerpoint');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pre', 'application/x-freelance');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('prt', 'application/pro_eng');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ps', 'application/postscript');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('psd', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pvu', 'paleovu/x-pv');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pwz', 'application/vnd.ms-powerpoint');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('py', 'text/x-script.phyton');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('pyc', 'applicaiton/x-bytecode.python');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qcp', 'audio/vnd.qcelp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qd3', 'x-world/x-3dmf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qd3d', 'x-world/x-3dmf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qif', 'image/x-quicktime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qt', 'video/quicktime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qtc', 'video/x-qtc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qti', 'image/x-quicktime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('qtif', 'image/x-quicktime');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ra', 'audio/x-pn-realaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ram', 'audio/x-pn-realaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ras', 'application/x-cmu-raster');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rast', 'image/cmu-raster');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rexx', 'text/x-script.rexx');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rf', 'image/vnd.rn-realflash');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rgb', 'image/x-rgb');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rm', 'audio/x-pn-realaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rmi', 'audio/mid');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rmm', 'audio/x-pn-realaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rmp', 'audio/x-pn-realaudio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rng', 'application/ringing-tones');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rnx', 'application/vnd.rn-realplayer');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('roff', 'application/x-troff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rp', 'image/vnd.rn-realpix');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rpm', 'audio/x-pn-realaudio-plugin');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rt', 'text/richtext');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rtf', 'application/rtf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rtx', 'application/rtf');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('rv', 'video/vnd.rn-realvideo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('s', 'text/x-asm');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('s3m', 'audio/s3m');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('saveme', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sbk', 'application/x-tbook');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('scm', 'application/x-lotusscreencam');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sdml', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sdp', 'application/sdp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sdp', 'application/x-sdp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sdr', 'application/sounder');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sea', 'application/sea');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('set', 'application/set');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sgm', 'text/sgml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sgml', 'text/sgml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sh', 'application/x-bsh');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('shar', 'application/x-bsh');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('shtml', 'text/html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sid', 'audio/x-psid');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sit', 'application/x-sit');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('skd', 'application/x-koan');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('skm', 'application/x-koan');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('skp', 'application/x-koan');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('skt', 'application/x-koan');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sl', 'application/x-seelogo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('smi', 'application/smil');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('smil', 'application/smil');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('snd', 'audio/basic');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sol', 'application/solids');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('spc', 'application/x-pkcs7-certificates');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('spl', 'application/futuresplash');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('spr', 'application/x-sprite');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sprite', 'application/x-sprite');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('src', 'application/x-wais-source');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ssi', 'text/x-server-parsed-html');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ssm', 'application/streamingmedia');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sst', 'application/vnd.ms-pki.certstore');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('step', 'application/step');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('stl', 'application/sla');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('stp', 'application/step');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sv4cpio', 'application/x-sv4cpio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('sv4crc', 'application/x-sv4crc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('svf', 'image/x-dwg');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('svr', 'application/x-world');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('swf', 'application/x-shockwave-flash');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('t', 'application/x-troff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('talk', 'text/x-speech');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tar', 'application/x-tar');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tbk', 'application/toolbook');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tcl', 'application/x-tcl');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tcsh', 'text/x-script.tcsh');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tex', 'application/x-tex');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('texi', 'application/x-texinfo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('texinfo', 'application/x-texinfo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('text', 'application/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tgz', 'application/gnutar');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tif', 'image/tiff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tiff', 'image/tiff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tr', 'application/x-troff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tsi', 'audio/tsp-audio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tsp', 'application/dsptype');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('tsv', 'text/tab-separated-values');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('turbot', 'image/florian');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('txt', 'text/plain');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('uil', 'text/x-uil');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('uni', 'text/uri-list');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('unis', 'text/uri-list');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('unv', 'application/i-deas');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('uri', 'text/uri-list');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('uris', 'text/uri-list');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('ustar', 'application/x-ustar');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('uu', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('uue', 'text/x-uuencode');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vcd', 'application/x-cdlink');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vcs', 'text/x-vcalendar');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vda', 'application/vda');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vdo', 'video/vdo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vew', 'application/groupwise');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('viv', 'video/vivo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vivo', 'video/vivo');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vmd', 'application/vocaltec-media-desc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vmf', 'application/vocaltec-media-file');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('voc', 'audio/voc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vos', 'video/vosaic');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vox', 'audio/voxware');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vqe', 'audio/x-twinvq-plugin');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vqf', 'audio/x-twinvq');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vql', 'audio/x-twinvq-plugin');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vrml', 'application/x-vrml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vrt', 'x-world/x-vrt');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vsd', 'application/x-visio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vst', 'application/x-visio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('vsw', 'application/x-visio');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('w60', 'application/wordperfect6.0');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('w61', 'application/wordperfect6.1');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('w6w', 'application/msword');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wav', 'audio/wav');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wb1', 'application/x-qpro');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wbmp', 'image/vnd.wap.wbmp');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('web', 'application/vnd.xara');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wiz', 'application/msword');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wk1', 'application/x-123');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wmf', 'windows/metafile');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wml', 'text/vnd.wap.wml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wmlc', 'application/vnd.wap.wmlc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wmls', 'text/vnd.wap.wmlscript');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wmlsc', 'application/vnd.wap.wmlscriptc');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('word', 'application/msword');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wp', 'application/wordperfect');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wp5', 'application/wordperfect');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wp6', 'application/wordperfect');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wpd', 'application/wordperfect');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wq1', 'application/x-lotus');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wri', 'application/mswrite');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wrl', 'application/x-world');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wrz', 'model/vrml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wsc', 'text/scriplet');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wsrc', 'application/x-wais-source');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('wtk', 'application/x-wintalk');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xbm', 'image/x-xbitmap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xdr', 'video/x-amt-demorun');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xgz', 'xgl/drawing');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xif', 'image/vnd.xiff');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xl', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xla', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlb', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlc', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xld', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlk', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xll', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlm', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xls', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlt', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlv', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xlw', 'application/excel');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xm', 'audio/xm');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xml', 'text/xml');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xmz', 'xgl/movie');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xpix', 'application/x-vnd.ls-xpix');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xpm', 'image/x-xpixmap');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('x-png', 'image/png');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xsr', 'video/x-amt-showrun');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xwd', 'image/x-xwd');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('xyz', 'chemical/x-pdb');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('z', 'application/x-compress');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('zip', 'application/x-compressed');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('zoo', 'application/octet-stream');
INSERT INTO sgmrdetiposmime (extension, tipomime) VALUES ('zsh', 'text/x-script.zsh');


--
-- Data for: sgmrtcatalogo_organos
--

INSERT INTO sgmrtcatalogo_organos (organo, descripcion) VALUES ('001', 'Servicio de Relaciones con el Ciudadano');
INSERT INTO sgmrtcatalogo_organos (organo, descripcion) VALUES ('002', 'Servicio de Tramitación de Licencias');
INSERT INTO sgmrtcatalogo_organos (organo, descripcion) VALUES ('003', 'Servicio de Secretaría');


--
-- Data for: sgmrtcatalogo_tipoconector
--

INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('1', 'Autenticación con certificado digital');
INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('2', 'Autenticación con usuario Web de nivel 2');
INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('3', 'Creación de firma');
INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('4', 'Verificación de firma');
INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('5', 'Validación del contenido de un documento');
INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('6', 'Obtención del certificado');
INSERT INTO sgmrtcatalogo_tipoconector (tipoid, descripcion) VALUES ('7', 'Autenticación con certificado digital vía web');


--
-- Data for: sgmrtregistro_secuencia
--

INSERT INTO sgmrtregistro_secuencia (anyo, etiqueta, secuencia) VALUES ('2012', '99900', 0);


--
-- Data for: sgmrtcatalogo_conectores
--

INSERT INTO sgmrtcatalogo_conectores (conectorid, descripcion, tipo) VALUES ('AUTH_CERTIFICADO', 'Autenticación con certificado digital', '1');
INSERT INTO sgmrtcatalogo_conectores (conectorid, descripcion, tipo) VALUES ('AUTH_WEB_USER', 'Autenticación con usuario Web de Nivel 2', '2');


--
-- Data for: sgmrtcatalogo_documentos
--

INSERT INTO sgmrtcatalogo_documentos (id, descripcion, extension, conector_firma, conector_contenido) VALUES ('PDF', 'Documento PDF', 'PDF', '', '');
INSERT INTO sgmrtcatalogo_documentos (id, descripcion, extension, conector_firma, conector_contenido) VALUES ('JPEG', 'Documento imagen con formato JPEG', 'JPG', '', '');
INSERT INTO sgmrtcatalogo_documentos (id, descripcion, extension, conector_firma, conector_contenido) VALUES ('DOC', 'Documento DOC', 'DOC', '', '');
INSERT INTO sgmrtcatalogo_documentos (id, descripcion, extension, conector_firma, conector_contenido) VALUES ('DOC_GIF', 'Fotografía', 'GIF', '', '');
