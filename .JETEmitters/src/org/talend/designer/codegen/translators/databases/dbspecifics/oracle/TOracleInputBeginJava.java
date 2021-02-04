package org.talend.designer.codegen.translators.databases.dbspecifics.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TOracleInputBeginJava
{
  protected static String nl;
  public static synchronized TOracleInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleInputBeginJava result = new TOracleInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_19 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_20 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Uses an existing connection ";
  protected final String TEXT_23 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_26 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_27 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\tconn_";
  protected final String TEXT_30 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_31 = ", dbUser_";
  protected final String TEXT_32 = ", dbPwd_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t";
  protected final String TEXT_34 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_35 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_36 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\tif(\"com.mysql.cj.jdbc.Driver\".equals((String)globalMap.get(\"driverClass_";
  protected final String TEXT_38 = "\"))" + NL + "\t\t\t    && routines.system.BundleUtils.inOSGi()) {" + NL + "\t\t\t        Class.forName(\"com.mysql.cj.jdbc.AbandonedConnectionCleanupThread\")." + NL + "\t\t\t            getMethod(\"checkedShutdown\").invoke(null, (Object[]) null);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\tconn_";
  protected final String TEXT_40 = ".setAutoCommit(";
  protected final String TEXT_41 = NL + "\t\t\t\tlog.";
  protected final String TEXT_42 = "(\"";
  protected final String TEXT_43 = " - \" + ";
  protected final String TEXT_44 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t    \t\tlog.";
  protected final String TEXT_46 = "\");" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_48 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_50 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_51 = ": pstmt_";
  protected final String TEXT_52 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_53 = " += (countEach_";
  protected final String TEXT_54 = " < 0 ? 0 : ";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_57 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_58 = ") {";
  protected final String TEXT_59 = NL + "    \t\t\tString dsAlias_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ";" + NL + "        \t\tif (dataSources_";
  protected final String TEXT_62 = ".get(dsAlias_";
  protected final String TEXT_63 = ") == null) {" + NL + "           \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_64 = " + \" available!\");" + NL + "              \t}" + NL + "        \t\tconn_";
  protected final String TEXT_65 = " = dataSources_";
  protected final String TEXT_66 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_67 = NL + "\t\t\t\tString driverClass_";
  protected final String TEXT_68 = " = \"";
  protected final String TEXT_69 = "\";" + NL + "\t\t\t    java.lang.Class jdbcclazz_";
  protected final String TEXT_70 = " = java.lang.Class.forName(driverClass_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\t\t\tString dbUser_";
  protected final String TEXT_73 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t";
  protected final String TEXT_75 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_76 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_77 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_78 = "; ";
  protected final String TEXT_79 = NL + "\t\t\t\t" + NL + "\t\t\t\tString dbPwd_";
  protected final String TEXT_80 = " = decryptedPassword_";
  protected final String TEXT_81 = ",dbUser_";
  protected final String TEXT_82 = ",dbPwd_";
  protected final String TEXT_83 = NL + "\t\t        ";
  protected final String TEXT_84 = NL + "\t\t    }";
  protected final String TEXT_85 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_86 = " = conn_";
  protected final String TEXT_87 = ".createStatement();";
  protected final String TEXT_88 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_90 = " = rs_";
  protected final String TEXT_91 = ".getString(";
  protected final String TEXT_92 = "column_index_";
  protected final String TEXT_93 = NL + "                        if(tmpContent_";
  protected final String TEXT_94 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_95 = " = tmpContent_";
  protected final String TEXT_96 = ";" + NL + "                        }";
  protected final String TEXT_97 = NL + "                    if(tmpContent_";
  protected final String TEXT_98 = " != null && tmpContent_";
  protected final String TEXT_99 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_100 = NL + "                        ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_103 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_104 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_105 = NL + "                                ";
  protected final String TEXT_106 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_107 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_108 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_109 = ")) {\t\t\t  \t\t";
  protected final String TEXT_110 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_111 = "' in '";
  protected final String TEXT_112 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_113 = NL + "                    }";
  protected final String TEXT_114 = NL + "\t\t\t";
  protected final String TEXT_115 = " = routines.system.JDBCUtil.getDate(rs_";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = NL + "        \t";
  protected final String TEXT_118 = " = routines.system.JDBCUtil.getString(rs_";
  protected final String TEXT_119 = "false";
  protected final String TEXT_120 = "true";
  protected final String TEXT_121 = NL + "            ";
  protected final String TEXT_122 = ".get";
  protected final String TEXT_123 = "(";
  protected final String TEXT_124 = ");" + NL + "            if(rs_";
  protected final String TEXT_125 = ".wasNull()){";
  protected final String TEXT_126 = NL + "                    ";
  protected final String TEXT_127 = " = null;";
  protected final String TEXT_128 = NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_129 = NL + "            }";
  protected final String TEXT_130 = NL + "\t\t\tString url_";
  protected final String TEXT_131 = NL + "\t\t\t\turl_";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_134 = " + \":\" + ";
  protected final String TEXT_135 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_136 = " + \")(port=\" + ";
  protected final String TEXT_137 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_138 = " + \")))\";";
  protected final String TEXT_139 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_140 = NL + "\t    \t\t\turl_";
  protected final String TEXT_141 = NL;
  protected final String TEXT_142 = NL + "\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_143 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\tif (null != dataSources_";
  protected final String TEXT_144 = ") {" + NL + "        \t\t\tString dsAlias_";
  protected final String TEXT_145 = ";" + NL + "            \t\tif (dataSources_";
  protected final String TEXT_146 = ") == null) {" + NL + "               \t\t\tthrow new RuntimeException(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_147 = " + \" available!\");" + NL + "                  \t}" + NL + "            \t\tconn_";
  protected final String TEXT_148 = ").getConnection();" + NL + "        \t\t} else {";
  protected final String TEXT_149 = NL + "\t\t\t\tString driverClass_";
  protected final String TEXT_150 = "\";" + NL + "\t\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_151 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\tString dbUser_";
  protected final String TEXT_153 = ";" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_154 = NL + NL + "\t\t\t\t";
  protected final String TEXT_155 = NL + NL + "\t\t\t\tString dbPwd_";
  protected final String TEXT_156 = NL + "\t\t\t\t\tconn_";
  protected final String TEXT_157 = NL + "\t\t\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_158 = " = new java.util.Properties();" + NL + "\t\t\t\t\tatnParamsPrope_";
  protected final String TEXT_159 = ".put(\"user\",dbUser_";
  protected final String TEXT_160 = ");" + NL + "\t\t\t\t\tatnParamsPrope_";
  protected final String TEXT_161 = ".put(\"password\",dbPwd_";
  protected final String TEXT_162 = ");" + NL + "                    if(";
  protected final String TEXT_163 = " != null && !\"\\\"\\\"\".equals(";
  protected final String TEXT_164 = ") && !\"\".equals(";
  protected final String TEXT_165 = ")){" + NL + "                        atnParamsPrope_";
  protected final String TEXT_166 = ".load(new java.io.ByteArrayInputStream(";
  protected final String TEXT_167 = ".replace(\"&\", \"\\n\").getBytes()));" + NL + "                    }" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_168 = ", atnParamsPrope_";
  protected final String TEXT_169 = NL + "\t\t\t\t}";
  protected final String TEXT_170 = NL + "\t\t\t\tjava.sql.Statement stmtGetTZ_";
  protected final String TEXT_171 = ".createStatement();" + NL + "\t\t\t\tjava.sql.ResultSet rsGetTZ_";
  protected final String TEXT_172 = " = stmtGetTZ_";
  protected final String TEXT_173 = ".executeQuery(\"select sessiontimezone from dual\");" + NL + "\t\t\t\tString sessionTimezone_";
  protected final String TEXT_174 = " = java.util.TimeZone.getDefault().getID();" + NL + "\t\t\t\twhile (rsGetTZ_";
  protected final String TEXT_175 = ".next()) {" + NL + "\t\t\t\t\tsessionTimezone_";
  protected final String TEXT_176 = " = rsGetTZ_";
  protected final String TEXT_177 = ".getString(1);" + NL + "\t\t\t\t}" + NL + "                                if (!(conn_";
  protected final String TEXT_178 = " instanceof oracle.jdbc.OracleConnection) &&" + NL + "                                        conn_";
  protected final String TEXT_179 = ".isWrapperFor(oracle.jdbc.OracleConnection.class)) {" + NL + "                                    if (conn_";
  protected final String TEXT_180 = ".unwrap(oracle.jdbc.OracleConnection.class) != null) {" + NL + "                                        ((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_181 = ".unwrap(oracle.jdbc.OracleConnection.class)).setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_182 = ");" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    ((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_183 = ").setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_184 = ");" + NL + "                                }";
  protected final String TEXT_185 = NL + "                boolean isTimeZoneNull_";
  protected final String TEXT_186 = " = false;" + NL + "\t\t\t\tboolean isConnectionWrapped_";
  protected final String TEXT_187 = " = !(conn_";
  protected final String TEXT_188 = " instanceof oracle.jdbc.OracleConnection) && conn_";
  protected final String TEXT_189 = ".isWrapperFor(oracle.jdbc.OracleConnection.class);" + NL + "\t\t\t\toracle.jdbc.OracleConnection unwrappedOraConn_";
  protected final String TEXT_190 = " = null;" + NL + "                if (isConnectionWrapped_";
  protected final String TEXT_191 = ") {" + NL + "\t\t\t\t\tunwrappedOraConn_";
  protected final String TEXT_192 = ".unwrap(oracle.jdbc.OracleConnection.class);" + NL + "                    if (unwrappedOraConn_";
  protected final String TEXT_193 = " != null) {" + NL + "                        isTimeZoneNull_";
  protected final String TEXT_194 = " = (unwrappedOraConn_";
  protected final String TEXT_195 = ".getSessionTimeZone() == null);" + NL + "                    }" + NL + "                } else {" + NL + "                    isTimeZoneNull_";
  protected final String TEXT_196 = " = (((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_197 = ").getSessionTimeZone() == null);" + NL + "                }" + NL + "" + NL + "\t\t\t\tif(isTimeZoneNull_";
  protected final String TEXT_198 = ") {" + NL + "\t\t\t\t\tjava.sql.Statement stmtGetTZ_";
  protected final String TEXT_199 = ".createStatement();" + NL + "\t\t\t\t\tjava.sql.ResultSet rsGetTZ_";
  protected final String TEXT_200 = ".executeQuery(\"select sessiontimezone from dual\");" + NL + "\t\t\t\t\tString sessionTimezone_";
  protected final String TEXT_201 = " = java.util.TimeZone.getDefault().getID();" + NL + "\t\t\t\t\twhile (rsGetTZ_";
  protected final String TEXT_202 = ".next()) {" + NL + "\t\t\t\t\t\tsessionTimezone_";
  protected final String TEXT_203 = ".getString(1);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (isConnectionWrapped_";
  protected final String TEXT_204 = " && unwrappedOraConn_";
  protected final String TEXT_205 = " != null) {" + NL + "                        unwrappedOraConn_";
  protected final String TEXT_206 = ".setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_207 = ");" + NL + "                    } else {" + NL + "                        ((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_208 = ");" + NL + "                    }" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_209 = NL + "                stmt_";
  protected final String TEXT_210 = ".setFetchSize(";
  protected final String TEXT_211 = ");" + NL;
  protected final String TEXT_212 = NL + "\t\t\t\tjava.io.Reader reader_";
  protected final String TEXT_213 = ".getCharacterStream(";
  protected final String TEXT_214 = ");" + NL + "\t\t\t\tjava.io.BufferedReader br_";
  protected final String TEXT_215 = " = null;" + NL + "\t\t\t\tif(reader_";
  protected final String TEXT_216 = " != null) {" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_217 = " = new java.io.BufferedReader(reader_";
  protected final String TEXT_218 = ");" + NL + " \t                StringBuffer content_";
  protected final String TEXT_219 = " = new StringBuffer();" + NL + " \t                int c_";
  protected final String TEXT_220 = " =0;" + NL + " \t                while( (c_";
  protected final String TEXT_221 = " = br_";
  protected final String TEXT_222 = ".read()) != -1) {" + NL + " \t                \tcontent_";
  protected final String TEXT_223 = ".append((char)c_";
  protected final String TEXT_224 = ");" + NL + "\t\t\t\t\t}" + NL + " \t                br_";
  protected final String TEXT_225 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_226 = " = content_";
  protected final String TEXT_227 = ".toString();" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_228 = " = null;" + NL + "\t\t\t\t}";
  protected final String TEXT_229 = NL + "\t\t\tbyte [] tmpBytes_";
  protected final String TEXT_230 = ".getBytes(";
  protected final String TEXT_231 = ");" + NL + "\t\t\tif(tmpBytes_";
  protected final String TEXT_232 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_233 = " = tmpBytes_";
  protected final String TEXT_234 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_235 = " = null;" + NL + "\t\t\t}";
  protected final String TEXT_236 = NL + "    \t\t\tTalendTimestampWithTZ talendTimestampWithTZ = null;" + NL + "    \t\t\tif(((oracle.jdbc.OracleResultSet) rs_";
  protected final String TEXT_237 = ").getTIMESTAMPTZ(";
  protected final String TEXT_238 = ") != null){" + NL + "    \t\t\t\ttalendTimestampWithTZ = org.talend.oracle.OracleTSTZUtil.toTalendTSTZ(((oracle.jdbc.OracleResultSet) rs_";
  protected final String TEXT_239 = ").toBytes());" + NL + "                }" + NL + "                if(talendTimestampWithTZ != null){" + NL + "                \t";
  protected final String TEXT_240 = " = talendTimestampWithTZ;" + NL + "                }else{" + NL + "                \t";
  protected final String TEXT_241 = " = null;" + NL + "                }" + NL + "    \t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\tjava.sql.Timestamp timestamp = rs_";
  protected final String TEXT_243 = ".getTimestamp(";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t\tif(timestamp != null) {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_245 = " = new java.util.Date(timestamp.getTime());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_246 = " = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_247 = NL + "\t\t\t\t";
  protected final String TEXT_248 = " = routines.system.JDBCUtil.getDoubleObject2(rs_";
  protected final String TEXT_249 = " = routines.system.JDBCUtil.getDouble2(rs_";
  protected final String TEXT_250 = " = routines.system.JDBCUtil.getDoubleObject(rs_";
  protected final String TEXT_251 = " = routines.system.JDBCUtil.getDouble(rs_";
  protected final String TEXT_252 = NL + "\t\t\t\tObject tmpObj_";
  protected final String TEXT_253 = "_";
  protected final String TEXT_254 = ".getObject(";
  protected final String TEXT_255 = ");" + NL + "\t\t\t\tif(tmpObj_";
  protected final String TEXT_256 = " != null) {";
  protected final String TEXT_257 = NL + "\t\t\t\t\t";
  protected final String TEXT_258 = " = oracle.xdb.XMLType.createXML((oracle.sql.OPAQUE) tmpObj_";
  protected final String TEXT_259 = ").getStringVal();";
  protected final String TEXT_260 = " = tmpObj_";
  protected final String TEXT_261 = NL + "\t\t\t\t} else {";
  protected final String TEXT_262 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_263 = NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_264 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\t\t\tif(!";
  protected final String TEXT_266 = " && rs_";
  protected final String TEXT_267 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_268 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_269 = " == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_270 = " == 0 && rs_";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\tif(rs_";
  protected final String TEXT_272 = NL + "\t\t\t\t\tif(rs_";
  protected final String TEXT_273 = ") != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_274 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_275 = NL + " \t                \tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_276 = NL + "\t\t\t\t\t}";
  protected final String TEXT_277 = NL + NL + NL + "\t";
  protected final String TEXT_278 = NL + "\t\t    int nb_line_";
  protected final String TEXT_279 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_280 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_281 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_282 = NL + "             boolean currentAutoCommitMode";
  protected final String TEXT_283 = " =  conn_";
  protected final String TEXT_284 = ".getAutoCommit();" + NL + "             conn_";
  protected final String TEXT_285 = ".setAutoCommit(true);" + NL + "             try{";
  protected final String TEXT_286 = NL + "                           try{" + NL + "                               conn_";
  protected final String TEXT_287 = ".createStatement().execute(\"BEGIN QUERY LOGGING WITH SQL,OBJECTS ON \" + ";
  protected final String TEXT_288 = ");" + NL + "                           }catch(Exception e){" + NL + "                                 System.err.println(e.getMessage());" + NL + "                           }";
  protected final String TEXT_289 = NL + "                 conn_";
  protected final String TEXT_290 = ".createStatement().execute(" + NL + "              \"SET QUERY_BAND='\" +";
  protected final String TEXT_291 = NL + "               ";
  protected final String TEXT_292 = " + \"=\" + ";
  protected final String TEXT_293 = " + \";\" +";
  protected final String TEXT_294 = " \"' FOR SESSION\"" + NL + "           );" + NL + "              }catch(Exception e){" + NL + "               System.err.println(e.getMessage());" + NL + "      }" + NL + "      conn_";
  protected final String TEXT_295 = ".setAutoCommit(currentAutoCommitMode";
  protected final String TEXT_296 = NL + "\t\t    ";
  protected final String TEXT_297 = NL + NL + "\t\t    String dbquery_";
  protected final String TEXT_298 = ";" + NL + "\t\t    ";
  protected final String TEXT_299 = NL;
  protected final String TEXT_300 = NL + "            \tglobalMap.put(\"";
  protected final String TEXT_301 = "_QUERY\",dbquery_";
  protected final String TEXT_302 = NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_303 = " = null;" + NL + "" + NL + "\t\t    try {" + NL + "\t\t    \trs_";
  protected final String TEXT_304 = " = stmt_";
  protected final String TEXT_305 = ".executeQuery(dbquery_";
  protected final String TEXT_306 = ");" + NL + "\t\t    \tjava.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_307 = ".getMetaData();" + NL + "\t\t    \tint colQtyInRs_";
  protected final String TEXT_308 = " = rsmd_";
  protected final String TEXT_309 = ".getColumnCount();" + NL;
  protected final String TEXT_310 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_311 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_312 = ".setDbmsId(\"";
  protected final String TEXT_313 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_314 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_315 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_316 = ".add(\"";
  protected final String TEXT_317 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_318 = NL + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_319 = ";" + NL + "" + NL + "            for (int i = ";
  protected final String TEXT_320 = "; i <= rsmd_";
  protected final String TEXT_321 = ".getColumnCount()-";
  protected final String TEXT_322 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_323 = ".contains(rsmd_";
  protected final String TEXT_324 = ".getColumnLabel(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_325 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_326 = ".setName(rsmd_";
  protected final String TEXT_327 = ".getColumnLabel(i));" + NL + "                \tdcm_";
  protected final String TEXT_328 = ".setDbName(rsmd_";
  protected final String TEXT_329 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_330 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_331 = "\", rsmd_";
  protected final String TEXT_332 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_333 = ".getPrecision(i), rsmd_";
  protected final String TEXT_334 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_335 = ".setDbType(rsmd_";
  protected final String TEXT_336 = ".getColumnTypeName(i));" + NL + "                \tdcm_";
  protected final String TEXT_337 = ".setDbTypeId(rsmd_";
  protected final String TEXT_338 = ".getColumnType(i));";
  protected final String TEXT_339 = NL + "                \tdcm_";
  protected final String TEXT_340 = ".setFormat(";
  protected final String TEXT_341 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_342 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_343 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_344 = ".setLength(rsmd_";
  protected final String TEXT_345 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_346 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_347 = NL + "\t\t\tdcm_";
  protected final String TEXT_348 = ".getPrecision(i));";
  protected final String TEXT_349 = ".setPrecision(rsmd_";
  protected final String TEXT_350 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_351 = ".setNullable(rsmd_";
  protected final String TEXT_352 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_353 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_354 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_355 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_356 = ".metadatas.add(dcm_";
  protected final String TEXT_357 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_358 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_359 = " = null;" + NL + "\t\t    ";
  protected final String TEXT_360 = NL + "\t\t    \tint column_index_";
  protected final String TEXT_361 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_362 = NL + "\t\t    \tlog.debug(\"";
  protected final String TEXT_363 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_364 = NL + "\t\t    while (rs_";
  protected final String TEXT_365 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_366 = "++;" + NL + "\t\t        ";
  protected final String TEXT_367 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_368 = " + dcg_";
  protected final String TEXT_369 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_370 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_371 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_372 = NL + "\t\t\t\t\t\t\tif(colQtyInRs_";
  protected final String TEXT_373 = " < ";
  protected final String TEXT_374 = ") {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_375 = ";" + NL + "\t\t\t\t\t\t\t} else {";
  protected final String TEXT_376 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_377 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_378 = NL + "\t\t                            ";
  protected final String TEXT_379 = " = (List)rs_";
  protected final String TEXT_380 = NL + "\t                         \t\t";
  protected final String TEXT_381 = NL + "                                    oracle.sql.STRUCT jGeomStruct = (oracle.sql.STRUCT) rs_";
  protected final String TEXT_382 = ");" + NL + "                                    if (jGeomStruct != null) {" + NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load(jGeomStruct);" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_383 = NL + "                                    ";
  protected final String TEXT_384 = " = new Geometry(wktValue);" + NL + "                                    } else {";
  protected final String TEXT_385 = NL + "                                      ";
  protected final String TEXT_386 = " = null;" + NL + "                                    }";
  protected final String TEXT_387 = NL + "                                        if (";
  protected final String TEXT_388 = NL + "                                        ";
  protected final String TEXT_389 = ".setEPSG(";
  protected final String TEXT_390 = ");" + NL + "                                        }";
  protected final String TEXT_391 = NL + "                                  ";
  protected final String TEXT_392 = "=dcg_";
  protected final String TEXT_393 = NL + "\t\t\t\t\t\t\t\t\t\tList<String> list_";
  protected final String TEXT_394 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_395 = "; i_";
  protected final String TEXT_396 = "  <= rsmd_";
  protected final String TEXT_397 = ".getColumnCount(); i_";
  protected final String TEXT_398 = " ++){" + NL + "\t\t\t\t\t    \t\t\t\t\t";
  protected final String TEXT_399 = NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_400 = ".getColumnTypeName(i_";
  protected final String TEXT_401 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_402 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_403 = ".getClob(i_";
  protected final String TEXT_404 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_405 = " !=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_406 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_407 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_408 = ".add(tNTextImpl_";
  protected final String TEXT_409 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_410 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t";
  protected final String TEXT_411 = " " + NL + "\t\t\t\t\t\t   \t\t\t\t\tif(\"NTEXT\".equals(rsmd_";
  protected final String TEXT_412 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t   \t\t\t\t\t\tlist_";
  protected final String TEXT_413 = ".add(rs_";
  protected final String TEXT_414 = ".getString(i_";
  protected final String TEXT_415 = "));" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t";
  protected final String TEXT_416 = NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_417 = ", rs_";
  protected final String TEXT_418 = ", fixedColumnCount_";
  protected final String TEXT_419 = ",list_";
  protected final String TEXT_420 = ",";
  protected final String TEXT_421 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_422 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_423 = NL + "                                  Object geom = rs_";
  protected final String TEXT_424 = ");" + NL + "                                  if (geom != null) {" + NL + "                                  \torg.postgis.Geometry o =" + NL + "                                      org.postgis.PGgeometry.geomFromString(geom.toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_425 = " = new Geometry(sb.toString());" + NL + "                                  } else {" + NL + "                                  \t";
  protected final String TEXT_426 = " = null;" + NL + "                                  }";
  protected final String TEXT_427 = NL + "\t\t                          ";
  protected final String TEXT_428 = NL + "\t\t                    }";
  protected final String TEXT_429 = NL + "\t\t\t\t\t";
  protected final String TEXT_430 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_431 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_432 = ";" + NL + "\t\t                            ";
  protected final String TEXT_433 = NL + NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_23);
    } else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
			connect_end();
		}
		
		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
     /* TESB-24900 - graceful shutdown for MYSQL connection */ 
    stringBuffer.append(TEXT_37);
    stringBuffer.append((connection!=null)?connection.replaceAll("'","").trim():"");
    stringBuffer.append(TEXT_38);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_33);
    
		}

		public void query(INode node, String dbQueryVariableName){
			beforeComponentProcess(node);
			//for input
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbQueryVariableName +" + \"'.");
		}

		/**
		* @deprecated please use another method instead: query(INode node, String dbQueryVariableName) because execution of the query expression can be not idempotent
		*/
		@Deprecated
		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_44);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_46);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_55);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
		protected String dbport;
		protected String dbname;
		protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
		protected boolean isDynamic;
		protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;

		public void beforeComponentProcess(INode node){
			cid = node.getUniqueName();
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas != null) && (metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					isDynamic = metadata.isDynamicSchema();
				}
			}
			log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();
		}

		public void afterUseExistConnection(INode node) {
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
				newInstance(node);

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_73);
    
				String passwordFieldName = "__PASS__";
				
    stringBuffer.append(TEXT_74);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_71);
    } else {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    this.setURL(node);
    stringBuffer.append(TEXT_74);
    
				log4jCodeGenerateUtil.debugConnectionParams(node);
				if (!needUserAndPassword){
					log4jCodeGenerateUtil.connect_begin_noUser();
				} else {
					log4jCodeGenerateUtil.connect_begin();
				}
				
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
			} else {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
			}
			log4jCodeGenerateUtil.connect_end();

    stringBuffer.append(TEXT_83);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_84);
    
			}
		}
		
		protected void newInstance(INode node) {
			//do nothing as default
			//for sybase jdbc in java 11, we have to call jdbcclazz.newInstance method
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_96);
    
                    }

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_107);
    
                        } else {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_112);
    
                        }

    stringBuffer.append(TEXT_113);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_116);
    if(trimMethod==null||trimMethod.isEmpty()){
    stringBuffer.append(TEXT_119);
    } else {
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_71);
    
	    }
	    
	    public void generateDoubleResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	generateOthersResultSet(firstConnName, column, currentColNo, "Double");
	    }
	    
	    public void generateBooleanResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	generateOthersResultSet(firstConnName, column, currentColNo, "Boolean");
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_123);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_126);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_127);
    
                } else {
                    
    stringBuffer.append(TEXT_128);
        
                }
                
    stringBuffer.append(TEXT_129);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    
	class DBInputBeginUtil extends DefaultDBInputUtil{

		private INode node = null;

		public void beforeComponentProcess(INode node){
			super.beforeComponentProcess(node);
			this.node = node;
		}

		public void setURL(INode node) {

			String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");
			String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
			if("ORACLE_RAC".equals(connectionType)) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_132);
    
			} else if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_132);
    
			} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_138);
    
			} else if(("ORACLE_OCI").equals(connectionType)) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_132);
    
			}else if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_132);
    
			}

    stringBuffer.append(TEXT_141);
    
		}

		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			if ("ORACLE_11".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_18".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";
			}else {
				return "oracle.jdbc.driver.OracleDriver";
			}
		}

		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
			dbport = ElementParameterParser.getValue(node, "__PORT__");
			dbname = ElementParameterParser.getValue(node, "__DBNAME__");
			dbuser = ElementParameterParser.getValue(node, "__USER__");

			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
			if(specify_alias){
				String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
			}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    this.setURL(node);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_153);
    
				String passwordFieldName = "__PASS__";
				
    stringBuffer.append(TEXT_154);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_71);
    } else {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
					log4jCodeGenerateUtil.debugConnectionParams(node);
					log4jCodeGenerateUtil.connect_begin();
				if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
				}else if (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
				} else {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( dbproperties );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
				}
				log4jCodeGenerateUtil.connect_end();
			if(specify_alias){

    stringBuffer.append(TEXT_169);
    
			}
			if(!"ORACLE_8".equals(dbVersion)){

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
			}
		}

		public void afterUseExistConnection(INode node) {
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			if(!"ORACLE_8".equals(dbVersion)){
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
			}
	    }

		public void createStatement(INode node) {

			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
			if(!("true").equals(useCursor)) {
				 super.createStatement(node);
			}else {
            	super.createMinValueStatement(node);

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_211);
    
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {
			String columnType = column.getType();
			if(columnType != null && ("CLOB").equals(columnType)) {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_228);
    
			} else {
				super.generateStringResultSet(firstConnName, column, currentColNo, trimMethod);
			}
	    }

	   	public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_235);
    
	    }

	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));

	    	String dbType = column.getType();
	    	if(dbType==null){
                super.generateTimestampResultSet(firstConnName,column,currentColNo);
                return;
            }
	    	boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");

	    	String dbVersion = "";
			String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
				String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
			    for(INode targetNode : nodes){
			    	if (targetNode.getUniqueName().equals(connection)) {
				      dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
				    }
			    }
			}else{
				dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
			}
	    	boolean supportTSTZ = false;
	    	if("ORACLE_11".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion) || "ORACLE_18".equals(dbVersion) ){
	    		supportTSTZ = true;
	    	}
	    	if(isTSWithTZ && supportTSTZ){
	    	
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_241);
    
    		}else{
	    		if(noNullValues){//FIXME any difference when the value of the parameter is true and false?
				
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_244);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_246);
    
				}else{
					super.generateTimestampResultSet(firstConnName,column,currentColNo);
				}
			}
	    }

		public void generateDoubleResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
			boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));
	    	if(noNullValues){
	    		if(column.isNullable()) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
				} else {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
				}
	    	} else {
	    		if(column.isNullable()) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
				} else {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
				}
	    	}
	    }
	    
	   	public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {
		   	boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));
	   		boolean isConvert = ("true").equals(ElementParameterParser.getValue(node, "__IS_CONVERT_XMLTYPE__"));
			List<Map<String, String>> convertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONVERT_XMLTYPE__");

			if(("Object").equals(typeToGenerate)){

				boolean needConvert = false;
	   			String convertToJavaType = "";
				if (isConvert && convertColumns.size() > 0) {
					for(java.util.Map<String, String> convertcolumn : convertColumns) {
						if (convertcolumn.get("REFCOL").equals(column.getLabel()) ) {
							needConvert = true;
							convertToJavaType = convertcolumn.get("CONVETTYPE");
						}
					}
				}


    stringBuffer.append(TEXT_252);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_255);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    
				if (needConvert && "String".equals(convertToJavaType)) {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    
				} else {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
				}

    stringBuffer.append(TEXT_261);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_262);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_127);
    
					} else {

    stringBuffer.append(TEXT_263);
    
					}

    stringBuffer.append(TEXT_169);
    
			} else {
				if(noNullValues){

    stringBuffer.append(TEXT_257);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_123);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_264);
    
					if(("Boolean").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_265);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_267);
    
					}else if(("Bytes").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_268);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_269);
    
					}else if(("Byte").equals(typeToGenerate) || ("Float").equals(typeToGenerate) || ("Int").equals(typeToGenerate) || ("Long").equals(typeToGenerate) || ("Short").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_268);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_267);
    
					}else{
					
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_267);
    
					}
					
    stringBuffer.append(TEXT_247);
    
				}else{
				
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_273);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_123);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_274);
    
				}
				
    
				if(column.isNullable()) {

    stringBuffer.append(TEXT_262);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_127);
    
				} else {

    stringBuffer.append(TEXT_275);
    
				}

    stringBuffer.append(TEXT_276);
    
			}
	    }
	    //---------end according schema type to generate ResultSet
	}//end class

	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_277);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	if("tJDBCInput".equals(node.getComponent().getName())) {
		boolean isEnableMapping = ("true").equals(ElementParameterParser.getValue(node, "__ENABLE_MAPPING__"));
		if (!isEnableMapping) {
			dbms = "";
		}
	}
	
	boolean isAmazonAurora = "mysql_id".equalsIgnoreCase(dbms) && node.isVirtualGenerateNode() && (cid.matches("^.*?tAmazonAuroraInput_\\d+_in$") || cid.matches("^.*?tDBInput_\\d+_in$"));
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");

    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;
		        
		        if(isAmazonAurora){
                    conn += "_in";
                }

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_281);
    log4jCodeGenerateUtil.useExistConnection(node);
    
				dbInputBeginUtil.afterUseExistConnection(node);
		    } else {
				dbInputBeginUtil.createConnection(node);
				if ("teradata_id".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_74);
    
      boolean queryBand = "true".equals(ElementParameterParser.getValue(node, "__QUERY_BAND__"));
      boolean activateQueryLogging = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_QUERY_LOGGING__"));
      String usrName = ElementParameterParser.getValue(node, "__USER__");
      List<Map<String, String>> queryBandList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__QUERY_BAND_PARAMETERS__");
      if(queryBand){
    stringBuffer.append(TEXT_282);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    
                    if(activateQueryLogging){
                        
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append( usrName );
    stringBuffer.append(TEXT_288);
    
                    }
                  
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
            for(Map<String, String> map : queryBandList) {

    stringBuffer.append(TEXT_291);
    stringBuffer.append( map.get("KEY") );
    stringBuffer.append(TEXT_292);
    stringBuffer.append( map.get("VALUE") );
    stringBuffer.append(TEXT_293);
    
            }

    stringBuffer.append(TEXT_294);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    }
    
				}
		    }

    stringBuffer.append(TEXT_296);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_298);
     log4jCodeGenerateUtil.query(node, "dbquery_" + cid); 
    stringBuffer.append(TEXT_299);
     
            if(isAmazonAurora){
            // why 3: ==> "_in".length()
            
    stringBuffer.append(TEXT_300);
    stringBuffer.append( cid.substring(0,cid.length() - 3) );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
            }else{
            
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
            }
            
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    

		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_317);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_71);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    
		} else {

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
		}

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
		    }
		    
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    if(isDynamic){
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    }
    stringBuffer.append(TEXT_296);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    }
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();

		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(isDynamic){
								if(!("Dynamic").equals(typeToGenerate) && dynamic_index < currentColNo) {
								
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    }else{
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_370);
    }
    stringBuffer.append(TEXT_371);
    
							}
							
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_374);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_375);
    
								typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);

								if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_376);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    
								} else if(("Timestamp").equals(typeToGenerate)) {
									if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_377);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_377);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_378);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_71);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_380);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if(("Double").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_380);
    dbInputBeginUtil.generateDoubleResultSet(firstConnName, column, currentColNo);
    
								} else if(("Boolean").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_380);
    dbInputBeginUtil.generateBooleanResultSet(firstConnName, column, currentColNo);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_384);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_386);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_387);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_390);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_376);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_391);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
     //for bug TDI-20886
									boolean trim = whetherTrimAllCol || whetherTrimCol;
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {
										String driver = "";
										if(("true").equals(useExistingConn)) {
											String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
											INode connectionNode = null; 
											for (INode processNode : node.getProcess().getGeneratingNodes()) { 
												if(connection.equals(processNode.getUniqueName())) { 
													connectionNode = processNode; 
													break; 
												} 
											}
											driver = ElementParameterParser.getValue(connectionNode,"__DRIVER__");
										} else {
											driver = ElementParameterParser.getValue(node,"__DRIVER__");
										}

    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
     if("JTDS".equals(driver)) { 
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
     } else {
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
     } 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_71);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_421);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_71);
    
									}else{

    stringBuffer.append(TEXT_422);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_71);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    if(isDynamic){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_424);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_426);
    
                 	            } else {

    stringBuffer.append(TEXT_427);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_428);
    
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_429);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_432);
    
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_433);
    stringBuffer.append(TEXT_141);
    return stringBuffer.toString();
  }
}
