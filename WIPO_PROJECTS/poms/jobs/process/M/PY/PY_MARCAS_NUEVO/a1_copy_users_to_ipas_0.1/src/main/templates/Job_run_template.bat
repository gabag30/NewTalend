%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/log4j-1.2-api-2.12.1.jar;../lib/commons-collections-3.2.2.jar;../lib/jtds-1.3.1-patch-20190523.jar;../lib/jboss-serialization.jar;../lib/imgscalr-lib-4.2.jar;../lib/postgresql-42.2.9.jar;../lib/advancedPersistentLookupLib-1.2.jar;../lib/slf4j-api-1.7.25.jar;../lib/dom4j-2.1.3.jar;../lib/talend_DB_mssqlUtil-1.4.jar;../lib/trove.jar;../lib/crypto-utils.jar;a1_copy_users_to_ipas_0_1.jar; wipo_projects.a1_copy_users_to_ipas_0_1.A1_Copy_users_to_ipas %*
