cd ..
call mvn initialize -Ddb=sqlserver -DdatabaseHost=10.228.75.75 -DdatabaseName=SIGM_3_ARCHIVO_000 -DusernameJdbc=SIGM_3_ARCHIVO_000 -DpasswordJdbc=SIGM_3_ARCHIVO_000 -DfullTextCatalogName=ARCHIVO -DgrantProceduresUserName=SIGM_3_ARCHIVO_000 -Pgenerate-bd,init-sqlserver-archivo
cd cmds
pause