#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms4096M -Xmx10240M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.12.1.jar:$ROOT_PATH/../lib/log4j-api-2.12.1.jar:$ROOT_PATH/../lib/log4j-core-2.12.1.jar:$ROOT_PATH/../lib/jtds-1.3.1-patch-20190523.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/imgscalr-lib-4.2.jar:$ROOT_PATH/../lib/crypto-utils.jar:$ROOT_PATH/../lib/slf4j-api-1.7.25.jar:$ROOT_PATH/a1_gen_marcas_0_1.jar:$ROOT_PATH/g1_val_mig_agents_0_1.jar:$ROOT_PATH/fa_corr_pre_mig_tm_py_0_1.jar:$ROOT_PATH/g2a_val_tm_0_1.jar:$ROOT_PATH/f_ipas_env_cre_0_1.jar: wipo_projects.a1_gen_marcas_0_1.A1_Gen_Marcas "$@"
