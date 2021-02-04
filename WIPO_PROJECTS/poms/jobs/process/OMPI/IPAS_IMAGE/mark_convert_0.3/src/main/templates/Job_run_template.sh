#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.12.1.jar:$ROOT_PATH/../lib/log4j-api-2.12.1.jar:$ROOT_PATH/../lib/log4j-core-2.12.1.jar:$ROOT_PATH/../lib/ojdbc6.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/imgscalr-lib-4.2.jar:$ROOT_PATH/../lib/crypto-utils-0.31.11.jar:$ROOT_PATH/../lib/talend_file_enhanced-1.0.jar:$ROOT_PATH/../lib/talend-oracle-timestamptz.jar:$ROOT_PATH/../lib/slf4j-api-1.7.25.jar:$ROOT_PATH/mark_convert_0_3.jar: wipo_projects.mark_convert_0_3.MARK_CONVERT "$@"
