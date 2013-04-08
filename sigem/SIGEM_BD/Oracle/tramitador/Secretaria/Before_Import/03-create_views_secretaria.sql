create  view SEC_TBL_VIEW_ORGANO_CARGO  (ID, VALOR, SUSTITUTO, VIGENTE , ORDEN) as

SELECT   CAST ((ORG.ID*100+CARGO.ID) AS NUMBER),
	    CAST ( (ORG.VALOR + '-' || CARGO.VALOR) AS VARCHAR (5) ) ,
	    CAST( (ORG.SUSTITUTO || '-' ||CARGO.SUSTITUTO) AS VARCHAR (30)),
	     CAST (1 AS NUMBER)  , CAST(ORG.ORDEN*100+CARGO.ORDEN AS NUMBER)
FROM  SEC_VLDTBL_ORGANO_GOBIERNO  ORG , SEC_VLDTBL_CARGO_ORGANO CARGO
;



CREATE VIEW SEC_TBL_VIEW_AREA_CARGO  (ID, VALOR, SUSTITUTO, VIGENTE , ORDEN) as
SELECT  CAST (( AREA.ID*100+CARGO.ID ) AS int),
	CAST ((AREA.VALOR || '-' || CARGO.VALOR) AS  CHARACTER VARYING (5)),
	CAST ((AREA.SUSTITUTO || '-' || CARGO.SUSTITUTO) AS CHARACTER VARYING (30)),
	CAST (1 AS NUMERIC(1,0))  , CAST(AREA.ORDEN*100+CARGO.ORDEN AS NUMERIC(10,0))
FROM  SEC_VLDTBL_AREA_GOBIERNO  AREA , SEC_VLDTBL_CARGO_AREA CARGO
;







