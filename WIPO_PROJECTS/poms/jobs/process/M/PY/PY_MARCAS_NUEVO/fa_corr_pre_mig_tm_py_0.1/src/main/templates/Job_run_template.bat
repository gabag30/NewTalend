%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/jtds-1.3.1-patch-20190523.jar;../lib/dom4j-2.1.3.jar;../lib/imgscalr-lib-4.2.jar;../lib/crypto-utils.jar;../lib/slf4j-api-1.7.25.jar;fa_corr_pre_mig_tm_py_0_1.jar; wipo_projects.fa_corr_pre_mig_tm_py_0_1.Fa_Corr_pre_mig_TM_PY --context=Default %*
