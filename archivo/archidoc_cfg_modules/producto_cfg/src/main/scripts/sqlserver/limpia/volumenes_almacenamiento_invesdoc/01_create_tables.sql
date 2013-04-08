CREATE TABLE dbo.IVOLACTDIR (
	VOLID int NOT NULL ,
	ACTDIR int NOT NULL ,
	NUMFILES int NOT NULL 
); 


CREATE TABLE dbo.IVOLARCHLIST (
	ARCHID int NOT NULL ,
	LISTID int NOT NULL 
); 

CREATE TABLE dbo.IVOLFILEFTS (
	ID int NOT NULL ,
	EXTID1 int NOT NULL ,
	EXTID2 int NOT NULL ,
	EXTID3 int NOT NULL ,
	EXTID4 int NOT NULL ,
	PATH varchar (254) NOT NULL ,
	TIMESTAMP datetime NOT NULL 
); 


CREATE TABLE dbo.IVOLFILEHDR (
	ID int NOT NULL ,
	VOLID int NOT NULL ,
	LOC varchar (254) NOT NULL ,
	EXTID1 int NOT NULL ,
	EXTID2 int NOT NULL ,
	EXTID3 int NOT NULL ,
	FLAGS int NOT NULL ,
	STAT int NOT NULL ,
	TIMESTAMP datetime NULL ,
	FILESIZE float NOT NULL 
); 


CREATE TABLE dbo.IVOLLISTHDR (
	ID int NOT NULL ,
	NAME varchar (32) NOT NULL ,
	FLAGS int NOT NULL ,
	STAT int NOT NULL ,
	REMARKS varchar (254) NULL ,
	CRTRID int NOT NULL ,
	CRTNDATE datetime NOT NULL ,
	UPDRID int NULL ,
	UPDDATE datetime NULL 
); 


CREATE TABLE dbo.IVOLLISTVOL (
	LISTID int NOT NULL ,
	VOLID int NOT NULL ,
	SORTORDER int NOT NULL 
); 

CREATE TABLE dbo.IVOLNEXTID (
	TYPE int NOT NULL ,
	ID int NOT NULL 
); 


CREATE TABLE dbo.IVOLREPHDR (
	ID int NOT NULL ,
	NAME varchar (32) NOT NULL ,
	TYPE int NOT NULL ,
	INFO text NOT NULL ,
	STAT int NOT NULL ,
	REMARKS varchar (254) NULL ,
	CRTRID int NOT NULL ,
	CRTNDATE datetime NOT NULL ,
	UPDRID int NULL ,
	UPDDATE datetime NULL 
); 


CREATE TABLE dbo.IVOLVOLHDR (
	ID int NOT NULL ,
	NAME varchar (32) NOT NULL ,
	REPID int NOT NULL ,
	INFO text NOT NULL ,
	ITEMP int NOT NULL ,
	ACTSIZE varchar (32) NOT NULL ,
	NUMFILES int NOT NULL ,
	STAT int NOT NULL ,
	REMARKS varchar (254) NULL ,
	CRTRID int NOT NULL ,
	CRTNDATE datetime NOT NULL ,
	UPDRID int NULL ,
	UPDDATE datetime NULL 
);


CREATE TABLE dbo.IVOLVOLTBL (
	LOCID varchar (32) NOT NULL ,
	EXTID1 int NOT NULL ,
	EXTID2 int NOT NULL ,
	EXTID3 int NOT NULL ,
	EXTID4 int NOT NULL ,
	FILEEXT varchar (10) NOT NULL ,
	FILEVAL image NOT NULL 
); 