#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms4096M -Xmx10240M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.12.1.jar:$ROOT_PATH/../lib/log4j-api-2.12.1.jar:$ROOT_PATH/../lib/log4j-core-2.12.1.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/crypto-utils-0.31.11.jar:$ROOT_PATH/../lib/talend_DB_mssqlUtil-1.4.jar:$ROOT_PATH/../lib/slf4j-api-1.7.25.jar:$ROOT_PATH/../lib/ini4j-0.5.1.jar:$ROOT_PATH/../lib/mssql-jdbc.jar:$ROOT_PATH/g4_1_fin_env_0_1.jar: wipo_projects.g4_1_fin_env_0_1.G4_1_Fin_env "$@"
