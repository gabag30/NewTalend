%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms2560M -Xmx10240M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/ojdbc6.jar;../lib/dom4j-2.1.3.jar;../lib/imgscalr-lib-4.2.jar;../lib/crypto-utils-0.31.11.jar;../lib/talend-oracle-timestamptz.jar;../lib/slf4j-api-1.7.25.jar;mark_resize_0_3.jar; wipo_projects.mark_resize_0_3.MARK_RESIZE %*
