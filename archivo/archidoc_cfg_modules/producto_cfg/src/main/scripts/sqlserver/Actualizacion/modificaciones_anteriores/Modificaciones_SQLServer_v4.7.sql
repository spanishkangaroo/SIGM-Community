-- /***************************/
-- /* Actualización 4.5->4.7  */
-- /***************************/

INSERT INTO AGINFOSISTEMA (NOMBRE,VALOR,FECHAACTUALIZACION) VALUES ('VERSIONBD','4.7',getdate());

IF OBJECT_ID('dbo.UPDATECODREF') IS NOT NULL BEGIN
	DROP PROCEDURE dbo.UPDATECODREF;
END;

IF OBJECT_ID('dbo.GETFINCODREFPADRE') IS NOT NULL BEGIN
	DROP FUNCTION dbo.GETFINCODREFPADRE;
END

IF OBJECT_ID('dbo.GETCODREF') IS NOT NULL BEGIN
	DROP FUNCTION dbo.GETCODREF;
END

--Catalogo de Tablas Temporales
--NOTA: Para esta funcionalidad necesario permiso de db_ddladmin o permisos para crear tablas. ya que la aplicacion necesita crear tablas en tiempo de ejecucion
CREATE TABLE ASGFCTLGTBLTMP(
	ID smallint	NOT NULL,
	NOMBRETABLA VARCHAR(16) NOT NULL,
	IDUSUARIO VARCHAR(32),
	ESTADO smallint default 0,
	FECHA datetime
);

CREATE UNIQUE INDEX ASGFCTLGTBLTMP1 ON ASGFCTLGTBLTMP(ID);
CREATE UNIQUE INDEX ASGFCTLGTBLTMP2 ON ASGFCTLGTBLTMP(NOMBRETABLA);

CREATE UNIQUE INDEX ASGFFONDO2 ON ASGFFONDO(CODARCHIVO,IDENTPRODUCTORA);