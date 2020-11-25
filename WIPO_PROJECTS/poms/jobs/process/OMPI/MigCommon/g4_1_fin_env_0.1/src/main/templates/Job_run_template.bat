%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms4096M -Xmx10240M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/dom4j-2.1.3.jar;../lib/crypto-utils-0.31.11.jar;../lib/talend_DB_mssqlUtil-1.4.jar;../lib/slf4j-api-1.7.25.jar;../lib/ini4j-0.5.1.jar;../lib/mssql-jdbc.jar;g4_1_fin_env_0_1.jar; wipo_projects.g4_1_fin_env_0_1.G4_1_Fin_env %*
