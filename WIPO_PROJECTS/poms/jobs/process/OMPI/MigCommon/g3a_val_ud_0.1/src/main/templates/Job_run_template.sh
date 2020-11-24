#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.12.1.jar:$ROOT_PATH/../lib/log4j-api-2.12.1.jar:$ROOT_PATH/../lib/log4j-core-2.12.1.jar:$ROOT_PATH/../lib/jtds-1.3.1-patch-20190523.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/imgscalr-lib-4.2.jar:$ROOT_PATH/../lib/crypto-utils-0.31.11.jar:$ROOT_PATH/../lib/slf4j-api-1.7.25.jar:$ROOT_PATH/g3a_val_ud_0_1.jar: wipo_projects.g3a_val_ud_0_1.G3a_Val_UD --context=Default "$@"
