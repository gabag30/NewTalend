%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms4096M -Xmx10240M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/dom4j-2.1.3.jar;../lib/crypto-utils.jar;../lib/slf4j-api-1.7.25.jar;a1_gen_marcas_0_1.jar;g1_val_mig_agents_0_1.jar; wipo_projects.a1_gen_marcas_0_1.A1_Gen_Marcas %*
