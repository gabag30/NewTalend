%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms4096M -Xmx10240M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/jtds-1.3.1-patch-20190523.jar;../lib/dom4j-2.1.3.jar;../lib/imgscalr-lib-4.2.jar;../lib/crypto-utils-0.31.11.jar;../lib/slf4j-api-1.7.25.jar;a1_gen_marcas_0_1.jar;fc_corr_pre_mig_ud_0_1.jar;g1_val_mig_agents_0_1.jar;fa_corr_pre_mig_tm_py_0_1.jar;g3a_val_ud_0_1.jar;g2a_val_tm_0_1.jar;f_ipas_env_cre_0_1.jar;g2b_mig_tm_0_1.jar; wipo_projects.a1_gen_marcas_0_1.A1_Gen_Marcas %*
