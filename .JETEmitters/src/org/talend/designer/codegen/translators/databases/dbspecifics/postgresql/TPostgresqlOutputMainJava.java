package org.talend.designer.codegen.translators.databases.dbspecifics.postgresql;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TPostgresqlOutputMainJava {
  protected static String nl;
  public static synchronized TPostgresqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlOutputMainJava result = new TPostgresqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + (";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_12 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                            ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = NL + "                        ";
  protected final String TEXT_22 = ".append(\" | \");";
  protected final String TEXT_23 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_24 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_25 = NL + "            StringBuilder ";
  protected final String TEXT_26 = " = new StringBuilder();    ";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = NL + "                    if(";
  protected final String TEXT_30 = " == null){";
  protected final String TEXT_31 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_32 = ");" + NL + "                    }   ";
  protected final String TEXT_33 = NL + "                ";
  protected final String TEXT_34 = ".append(\"|\");";
  protected final String TEXT_35 = NL + "            ";
  protected final String TEXT_36 = " = null;";
  protected final String TEXT_37 = NL + "\t\tquery_";
  protected final String TEXT_38 = " = new StringBuffer(\"\");";
  protected final String TEXT_39 = NL + "\t\tif(nb_line_";
  protected final String TEXT_40 = "==0) {" + NL + "\t\t";
  protected final String TEXT_41 = NL + "            try (java.sql.Statement stmtDrop_";
  protected final String TEXT_42 = " = conn_";
  protected final String TEXT_43 = ".createStatement()) {";
  protected final String TEXT_44 = NL + "                              stmtDrop_";
  protected final String TEXT_45 = ".setQueryTimeout(Integer.valueOf(Integer.valueOf(";
  protected final String TEXT_46 = ")));";
  protected final String TEXT_47 = NL + "                stmtDrop_";
  protected final String TEXT_48 = ".execute(\"";
  protected final String TEXT_49 = "\" ";
  protected final String TEXT_50 = NL + "            }";
  protected final String TEXT_51 = NL + "                 conn_";
  protected final String TEXT_52 = ".commit();";
  protected final String TEXT_53 = NL + "            try (java.sql.Statement stmtCreate_";
  protected final String TEXT_54 = NL + "                              stmtCreate_";
  protected final String TEXT_55 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_56 = "));";
  protected final String TEXT_57 = NL + "                    \troutines.system.Dynamic dynamic_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "\t                    if (";
  protected final String TEXT_60 = ") {" + NL + "\t                        for (int i = 0; i < dynamic_";
  protected final String TEXT_61 = ".getColumnCount(); i++) {" + NL + "\t                        \troutines.system.DynamicMetadata column = dynamic_";
  protected final String TEXT_62 = ".getColumnMetadata(i);" + NL + "\t                        \tcolumn.setName(column.getName().toLowerCase());" + NL + "\t                        }" + NL + "\t                    }" + NL + "                        stmtCreate_";
  protected final String TEXT_63 = ".execute(((\"";
  protected final String TEXT_64 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(dynamic_";
  protected final String TEXT_65 = ", \"";
  protected final String TEXT_66 = "\")";
  protected final String TEXT_67 = ".toUpperCase()";
  protected final String TEXT_68 = ")+\")";
  protected final String TEXT_69 = "\"));";
  protected final String TEXT_70 = NL + "                stmtCreate_";
  protected final String TEXT_71 = ")\");";
  protected final String TEXT_72 = NL + "                    routines.system.Dynamic dynamic_";
  protected final String TEXT_73 = ";" + NL + "                    if (";
  protected final String TEXT_74 = ") {" + NL + "                        for (int i = 0; i < dynamic_";
  protected final String TEXT_75 = ".getColumnCount(); i++) {" + NL + "                        \troutines.system.DynamicMetadata column = dynamic_";
  protected final String TEXT_76 = ".getColumnMetadata(i);" + NL + "                        \tcolumn.setName(column.getName().toLowerCase());" + NL + "                        }" + NL + "                    }" + NL + "                    stmtCreate_";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = NL + "                    String keyCheckTable_";
  protected final String TEXT_79 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_80 = "+\"][\"+";
  protected final String TEXT_81 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_82 = " + \"]\";";
  protected final String TEXT_83 = NL + "                    // [%connection%][checktable][tableName]" + NL + "                    String keyCheckTable_";
  protected final String TEXT_84 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_85 = NL + NL + "                if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_86 = ")== null){//}" + NL + "" + NL + "                    synchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_87 = ")) {//}" + NL + "                        if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_88 = ")== null){//}";
  protected final String TEXT_89 = NL + "                                boolean whetherExist_";
  protected final String TEXT_90 = " = false;" + NL + "                                try (java.sql.Statement isExistStmt_";
  protected final String TEXT_91 = ".createStatement()) {" + NL + "                                    try {" + NL + "                                        isExistStmt_";
  protected final String TEXT_92 = ".execute(\"SELECT TOP 1 1 FROM [\" + tableName_";
  protected final String TEXT_93 = " + \"]\" );" + NL + "                                        whetherExist_";
  protected final String TEXT_94 = " = true;" + NL + "                                    } catch (java.lang.Exception e){" + NL + "                                        whetherExist_";
  protected final String TEXT_95 = " = false;" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_96 = NL + "                                ";
  protected final String TEXT_97 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_98 = ".getMetaData();" + NL + "                                if(tableNameForSearch_";
  protected final String TEXT_99 = ".indexOf(\"\\\"\")==-1){" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_100 = " = tableNameForSearch_";
  protected final String TEXT_101 = ".toUpperCase();" + NL + "                                }else{" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_102 = ".replaceAll(\"\\\"\",\"\");" + NL + "                                }" + NL + "                                boolean whetherExist_";
  protected final String TEXT_103 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_104 = " = dbMetaData_";
  protected final String TEXT_105 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_106 = ", tableNameForSearch_";
  protected final String TEXT_107 = ", new String[]{\"TABLE\"})) {" + NL + "                                    if(rsTable_";
  protected final String TEXT_108 = ".next()) {" + NL + "                                        whetherExist_";
  protected final String TEXT_109 = " = true;" + NL + "                                    }" + NL + "                                }" + NL;
  protected final String TEXT_110 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_111 = ".getTables(null, null, null, new String[]{\"TABLE\"})) {" + NL + "                                    while(rsTable_";
  protected final String TEXT_112 = ".next()) {" + NL + "                                        String table_";
  protected final String TEXT_113 = " = rsTable_";
  protected final String TEXT_114 = ".getString(\"TABLE_NAME\");" + NL + "                                        String schema_";
  protected final String TEXT_115 = ".getString(\"TABLE_SCHEM\");" + NL + "                                        if(table_";
  protected final String TEXT_116 = ".equals";
  protected final String TEXT_117 = "IgnoreCase";
  protected final String TEXT_118 = "(";
  protected final String TEXT_119 = ")" + NL + "                                            && (schema_";
  protected final String TEXT_120 = "(dbschema_";
  protected final String TEXT_121 = ") || dbschema_";
  protected final String TEXT_122 = ".trim().length() ==0)) {" + NL + "                                            whetherExist_";
  protected final String TEXT_123 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_124 = "((";
  protected final String TEXT_125 = ")";
  protected final String TEXT_126 = ") || (dbschema_";
  protected final String TEXT_127 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_128 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_129 = ")))) {" + NL + "                                            whetherExist_";
  protected final String TEXT_130 = ".getTables(null, null, null, new String[]{\"TABLE\"})) {" + NL + "                                    String defaultSchema_";
  protected final String TEXT_131 = " = \"public\";" + NL + "                                    if(dbschema_";
  protected final String TEXT_132 = " == null || dbschema_";
  protected final String TEXT_133 = ".trim().length() == 0) {" + NL + "                                        try(java.sql.Statement stmtSchema_";
  protected final String TEXT_134 = ".createStatement();" + NL + "                                            java.sql.ResultSet rsSchema_";
  protected final String TEXT_135 = " = stmtSchema_";
  protected final String TEXT_136 = ".executeQuery(\"select current_schema() \")) {" + NL + "                                            while(rsSchema_";
  protected final String TEXT_137 = ".next()){" + NL + "                                                defaultSchema_";
  protected final String TEXT_138 = " = rsSchema_";
  protected final String TEXT_139 = ".getString(\"current_schema\");" + NL + "                                            }" + NL + "                                        }" + NL + "                                    }" + NL + "                                    while(rsTable_";
  protected final String TEXT_140 = ".toLowerCase()";
  protected final String TEXT_141 = ") || ((dbschema_";
  protected final String TEXT_142 = " ==null || dbschema_";
  protected final String TEXT_143 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_144 = "(schema_";
  protected final String TEXT_145 = NL + "                                String tableForSearch_";
  protected final String TEXT_146 = ";" + NL + "                                if(tableForSearch_";
  protected final String TEXT_147 = " != null){" + NL + "                                    if(tableForSearch_";
  protected final String TEXT_148 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_149 = ".endsWith(\"\\\"\")){" + NL + "                                        tableForSearch_";
  protected final String TEXT_150 = " =  tableForSearch_";
  protected final String TEXT_151 = ".substring(1,tableForSearch_";
  protected final String TEXT_152 = ".length()-1);" + NL + "                                    }else{" + NL + "                                        tableForSearch_";
  protected final String TEXT_153 = ".toUpperCase();" + NL + "                                    }" + NL + "                                }" + NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_154 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_155 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_156 = ".getTables(null, conn_";
  protected final String TEXT_157 = ".getSchema(), tableForSearch_";
  protected final String TEXT_158 = ", new String[]{\"TABLE\"})) {" + NL + "                                       if(rsTable_";
  protected final String TEXT_159 = " = true;" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_160 = ".getTables(null, schemaForSearch_";
  protected final String TEXT_161 = ", null, new String[]{\"TABLE\"})) {" + NL + "                                    while(rsTable_";
  protected final String TEXT_162 = ".next()) {" + NL + "                                        if(rsTable_";
  protected final String TEXT_163 = ".getString(\"TABLE_NAME\").equalsIgnoreCase(tableForSearch_";
  protected final String TEXT_164 = ")) {" + NL + "                                            whetherExist_";
  protected final String TEXT_165 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }" + NL + "                            " + NL + "                            ";
  protected final String TEXT_166 = ".getMetaData();";
  protected final String TEXT_167 = NL + "                                    java.sql.ResultSet rsTable_";
  protected final String TEXT_168 = ".getTables(";
  protected final String TEXT_169 = ", null, null, new String[]{\"TABLE\"});";
  protected final String TEXT_170 = ".getTables(conn_";
  protected final String TEXT_171 = ".getCatalog(), null, null, new String[]{\"TABLE\"});";
  protected final String TEXT_172 = " = false;" + NL + "                                while(rsTable_";
  protected final String TEXT_173 = ".next()) {" + NL + "                                    String table_";
  protected final String TEXT_174 = ".getString(\"TABLE_NAME\");" + NL + "                                    if(table_";
  protected final String TEXT_175 = ".equalsIgnoreCase(";
  protected final String TEXT_176 = ")) {" + NL + "                                        whetherExist_";
  protected final String TEXT_177 = " = true;" + NL + "                                        break;" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_178 = ".getString(\"TABLE_NAME\");" + NL + "                                        if(table_";
  protected final String TEXT_179 = NL + "                                if(!whetherExist_";
  protected final String TEXT_180 = ") {" + NL + "                                    try (java.sql.Statement stmtCreate_";
  protected final String TEXT_181 = NL + "                                                      stmtCreate_";
  protected final String TEXT_182 = NL + "                                            routines.system.Dynamic dynamic_";
  protected final String TEXT_183 = ";" + NL + "\t\t\t\t\t\t                    if (";
  protected final String TEXT_184 = ") {" + NL + "\t\t\t\t\t\t                        for (int i = 0; i < dynamic_";
  protected final String TEXT_185 = ".getColumnCount(); i++) {" + NL + "\t\t\t\t\t\t                        \troutines.system.DynamicMetadata column = dynamic_";
  protected final String TEXT_186 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t                        \tcolumn.setName(column.getName().toLowerCase());" + NL + "\t\t\t\t\t\t                        }" + NL + "\t\t\t\t\t\t                    }" + NL + "                                            stmtCreate_";
  protected final String TEXT_187 = NL + "                                        stmtCreate_";
  protected final String TEXT_188 = NL + "                                    }" + NL + "                                }";
  protected final String TEXT_189 = NL + "                                if(whetherExist_";
  protected final String TEXT_190 = ") {" + NL + "                                    try (java.sql.Statement stmtDrop_";
  protected final String TEXT_191 = NL + "                                                      stmtDrop_";
  protected final String TEXT_192 = NL + "                                        stmtDrop_";
  protected final String TEXT_193 = NL + "                                    }";
  protected final String TEXT_194 = NL + "                                            conn_";
  protected final String TEXT_195 = NL + "                                }" + NL + "                                try(java.sql.Statement stmtCreate_";
  protected final String TEXT_196 = NL + "                                                  stmtCreate_";
  protected final String TEXT_197 = NL + "\t\t                                routines.system.Dynamic dynamic_";
  protected final String TEXT_198 = ";" + NL + "\t\t\t\t\t                    if (";
  protected final String TEXT_199 = ") {" + NL + "\t\t\t\t\t                        for (int i = 0; i < dynamic_";
  protected final String TEXT_200 = ".getColumnCount(); i++) {" + NL + "\t\t\t\t\t                        \troutines.system.DynamicMetadata column = dynamic_";
  protected final String TEXT_201 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t                        \tcolumn.setName(column.getName().toLowerCase());" + NL + "\t\t\t\t\t                        }" + NL + "\t\t\t\t\t                    }" + NL + "                                        stmtCreate_";
  protected final String TEXT_202 = NL + "                                    stmtCreate_";
  protected final String TEXT_203 = NL + "                                }";
  protected final String TEXT_204 = NL + "                            GlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_205 = ", true);" + NL + "            //{{{" + NL + "                        } // end of if" + NL + "                    } // end synchronized" + NL + "                }";
  protected final String TEXT_206 = NL + "            try (java.sql.Statement stmtClear_";
  protected final String TEXT_207 = NL + "                              stmtClear_";
  protected final String TEXT_208 = NL + "                stmtClear_";
  protected final String TEXT_209 = ".executeUpdate(\"";
  protected final String TEXT_210 = "\");";
  protected final String TEXT_211 = NL + "            int rsTruncCountNumber_";
  protected final String TEXT_212 = " = 0;" + NL + "            try(java.sql.Statement stmtTruncCount_";
  protected final String TEXT_213 = NL + "                              stmtTruncCount_";
  protected final String TEXT_214 = NL + "                try (java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_215 = " = stmtTruncCount_";
  protected final String TEXT_216 = ".executeQuery(\"";
  protected final String TEXT_217 = "\")) {" + NL + "                    if(rsTruncCount_";
  protected final String TEXT_218 = ".next()) {" + NL + "                        rsTruncCountNumber_";
  protected final String TEXT_219 = " = rsTruncCount_";
  protected final String TEXT_220 = ".getInt(1);" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "            try (java.sql.Statement stmtTrunc_";
  protected final String TEXT_221 = NL + "                              stmtTrunc_";
  protected final String TEXT_222 = NL + "                conn_";
  protected final String TEXT_223 = NL + "                stmtTrunc_";
  protected final String TEXT_224 = NL + "                    if(!conn_";
  protected final String TEXT_225 = ".getAutoCommit()){" + NL + "                        conn_";
  protected final String TEXT_226 = ".commit();" + NL + "                    }";
  protected final String TEXT_227 = NL + "                deletedCount_";
  protected final String TEXT_228 = " += rsTruncCountNumber_";
  protected final String TEXT_229 = ";" + NL + "            }";
  protected final String TEXT_230 = NL + "            try (java.sql.Statement stmtTruncCount_";
  protected final String TEXT_231 = ".createStatement();" + NL + "                java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_232 = "\");" + NL + "                java.sql.Statement stmtTrunc_";
  protected final String TEXT_233 = NL + "                while(rsTruncCount_";
  protected final String TEXT_234 = ".next()) {" + NL + "                    deletedCount_";
  protected final String TEXT_235 = " += rsTruncCount_";
  protected final String TEXT_236 = ".getInt(1);" + NL + "                }" + NL + "            }";
  protected final String TEXT_237 = NL + "\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_238 = ";" + NL + "            if (";
  protected final String TEXT_239 = ") {" + NL + "                for (int i = 0; i < dynamic_";
  protected final String TEXT_240 = ".getColumnCount(); i++) {" + NL + "                \troutines.system.DynamicMetadata column = dynamic_";
  protected final String TEXT_241 = ".getColumnMetadata(i);" + NL + "                \tcolumn.setName(column.getName().toLowerCase());" + NL + "                }" + NL + "            }";
  protected final String TEXT_242 = NL + "\t\t\t\tString insert_";
  protected final String TEXT_243 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_244 = " + \"\\\" (";
  protected final String TEXT_245 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(dynamic_";
  protected final String TEXT_246 = "\")+\") VALUES (";
  protected final String TEXT_247 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(dynamic_";
  protected final String TEXT_248 = ")+\")\";";
  protected final String TEXT_249 = " + \"\\\" (\"+DynamicUtils.getInsertIntoStmtColumnsList(dynamic_";
  protected final String TEXT_250 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(dynamic_";
  protected final String TEXT_251 = NL + "    pstmt_";
  protected final String TEXT_252 = ".prepareStatement(insert_";
  protected final String TEXT_253 = ");" + NL + "    resourceMap.put(\"pstmt_";
  protected final String TEXT_254 = "\", pstmt_";
  protected final String TEXT_255 = " = null;" + NL + "    String keyPsmt_";
  protected final String TEXT_256 = " + \"[psmt]\" + \"[\" + ";
  protected final String TEXT_257 = " + \"]\";" + NL + "    if(GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_258 = ")== null){" + NL + "        pstmt_";
  protected final String TEXT_259 = ");" + NL + "        resourceMap.put(\"pstmt_";
  protected final String TEXT_260 = ");" + NL + "        GlobalResource.resourceMap.put(keyPsmt_";
  protected final String TEXT_261 = ", pstmt_";
  protected final String TEXT_262 = ");" + NL + "    }else{" + NL + "        pstmt_";
  protected final String TEXT_263 = " = (java.sql.PreparedStatement)GlobalResource.resourceMap.get(keyPsmt_";
  protected final String TEXT_264 = ");" + NL + "    }";
  protected final String TEXT_265 = NL + "\t\t\t\tString update_";
  protected final String TEXT_266 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_267 = " + \"\\\" SET ";
  protected final String TEXT_268 = ", \"+DynamicUtils.getUpdateSet(dynamic_";
  protected final String TEXT_269 = "\")+\" WHERE ";
  protected final String TEXT_270 = "\";";
  protected final String TEXT_271 = " + \"\\\" SET \"+DynamicUtils.getUpdateSet(dynamic_";
  protected final String TEXT_272 = NL + "\t    pstmt_";
  protected final String TEXT_273 = ".prepareStatement(update_";
  protected final String TEXT_274 = ");" + NL + "\t    resourceMap.put(\"pstmt_";
  protected final String TEXT_275 = ");" + NL + "\t    ";
  protected final String TEXT_276 = ".prepareStatement(\"SELECT COUNT(1) FROM \\\"\" + tableName_";
  protected final String TEXT_277 = " + \"\\\" WHERE ";
  protected final String TEXT_278 = "\");" + NL + "\t    resourceMap.put(\"pstmt_";
  protected final String TEXT_279 = ");" + NL + "\t    pstmtInsert_";
  protected final String TEXT_280 = ");" + NL + "\t    resourceMap.put(\"pstmtInsert_";
  protected final String TEXT_281 = "\", pstmtInsert_";
  protected final String TEXT_282 = ");" + NL + "\t    pstmtUpdate_";
  protected final String TEXT_283 = ");" + NL + "\t    resourceMap.put(\"pstmtUpdate_";
  protected final String TEXT_284 = "\", pstmtUpdate_";
  protected final String TEXT_285 = NL + "\t    pstmtUpdate_";
  protected final String TEXT_286 = NL + "\t    String delete_";
  protected final String TEXT_287 = " = \"DELETE FROM \\\"\" + tableName_";
  protected final String TEXT_288 = "\";" + NL + "\t    pstmt_";
  protected final String TEXT_289 = ".prepareStatement(delete_";
  protected final String TEXT_290 = NL + "       \t";
  protected final String TEXT_291 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_292 = " = insert_";
  protected final String TEXT_293 = ".split(\"\\\\?\");";
  protected final String TEXT_294 = NL + "\t\t\tupdate_";
  protected final String TEXT_295 = " += \" \";" + NL + "\t    \tupdateSQLSplits_";
  protected final String TEXT_296 = " = update_";
  protected final String TEXT_297 = " += \" \";" + NL + "\t\t\tupdateSQLSplits_";
  protected final String TEXT_298 = ".split(\"\\\\?\");" + NL + "\t\t\tinsertSQLSplits_";
  protected final String TEXT_299 = NL + "\t\t\tdelete_";
  protected final String TEXT_300 = " += \" \";" + NL + "\t\t   \tdeleteSQLSplits_";
  protected final String TEXT_301 = " = delete_";
  protected final String TEXT_302 = NL + "\t\t\treplace_";
  protected final String TEXT_303 = " += \" \";" + NL + "\t\t\treplaceSQLSplits_";
  protected final String TEXT_304 = " = replace_";
  protected final String TEXT_305 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_306 = " += \" \";" + NL + "\t\t\tinsertIgnoreSQLSplits_";
  protected final String TEXT_307 = " = insertIgnore_";
  protected final String TEXT_308 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_309 = NL + "\t\t\t\tcommitEvery_";
  protected final String TEXT_310 = " = buffersSize_";
  protected final String TEXT_311 = ";";
  protected final String TEXT_312 = NL + "\t\t\t\tbatchSize_";
  protected final String TEXT_313 = NL + "        whetherReject_";
  protected final String TEXT_314 = " = false;";
  protected final String TEXT_315 = NL + "                        query_";
  protected final String TEXT_316 = NL + "                            geometryColumnName_";
  protected final String TEXT_317 = " = \"";
  protected final String TEXT_318 = "\";" + NL + "                            if (firstGeometry_";
  protected final String TEXT_319 = ") {" + NL + "                                dimension_";
  protected final String TEXT_320 = " = 2;" + NL + "" + NL + "                                // A null first geometry will lead to unknown coordinate system" + NL + "                                if (";
  protected final String TEXT_321 = " == null) {" + NL + "                            \t    SRID_";
  protected final String TEXT_322 = " = -1;" + NL + "                                } else {" + NL + "                                    org.opengis.referencing.crs.CoordinateReferenceSystem refSys_";
  protected final String TEXT_323 = " =" + NL + "                                        ((org.talend.sdi.geometry.Geometry) ";
  protected final String TEXT_324 = ").getCRS();" + NL + "                                    if (refSys_";
  protected final String TEXT_325 = " != null) {" + NL + "                                        dimension_";
  protected final String TEXT_326 = " = refSys_";
  protected final String TEXT_327 = ".getCoordinateSystem().getDimension();" + NL + "                                        try {" + NL + "                                            java.util.Set ident_";
  protected final String TEXT_328 = ".getIdentifiers();" + NL + "                                            if ((ident_";
  protected final String TEXT_329 = " == null || ident_";
  protected final String TEXT_330 = ".isEmpty())" + NL + "                                                && refSys_";
  protected final String TEXT_331 = " == org.geotools.referencing.crs.DefaultGeographicCRS.WGS84) {" + NL + "                                                SRID_";
  protected final String TEXT_332 = " = 4326;" + NL + "                                            } else {" + NL + "                                                String code_";
  protected final String TEXT_333 = " = ((org.geotools.referencing.NamedIdentifier) ident_";
  protected final String TEXT_334 = ".toArray()[0]).getCode();" + NL + "                                                SRID_";
  protected final String TEXT_335 = " = Integer.parseInt(code_";
  protected final String TEXT_336 = ");" + NL + "                                            }" + NL + "                                        } catch (java.lang.Exception e) {" + NL + "                                            String SRIDError_";
  protected final String TEXT_337 = " = \"SRID_";
  protected final String TEXT_338 = " could not be determined\";";
  protected final String TEXT_339 = NL + "                                            System.out.println(SRIDError_";
  protected final String TEXT_340 = ");" + NL + "                                            SRID_";
  protected final String TEXT_341 = " = -1;" + NL + "                                        }" + NL + "                                     }  else {" + NL + "                                        SRID_";
  protected final String TEXT_342 = " = -1;" + NL + "                                     }" + NL + "                                     firstGeometry_";
  protected final String TEXT_343 = " = false;" + NL + "                                 }" + NL + "                            }";
  protected final String TEXT_344 = NL + "\t\t\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_345 = ",";
  protected final String TEXT_346 = ", ";
  protected final String TEXT_347 = ",insertSQLSplits_";
  protected final String TEXT_348 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_350 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_351 = NL + "                globalMap.put(\"";
  protected final String TEXT_352 = "_QUERY\", query_";
  protected final String TEXT_353 = ".toString().trim());";
  protected final String TEXT_354 = NL + "\t\t\t";
  protected final String TEXT_355 = NL + "    \t\tpstmt_";
  protected final String TEXT_356 = ".addBatch();" + NL + "    \t\tnb_line_";
  protected final String TEXT_357 = "++;" + NL + "    \t\t  ";
  protected final String TEXT_358 = NL + "    \t\t  ";
  protected final String TEXT_359 = NL + "    \t\t  batchSizeCounter_";
  protected final String TEXT_360 = NL + "            try {" + NL + "                nb_line_";
  protected final String TEXT_361 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_362 = NL + "                \tsp_";
  protected final String TEXT_363 = ".setSavepoint();" + NL + "\t\t\t\t";
  protected final String TEXT_364 = NL + "                insertedCount_";
  protected final String TEXT_365 = " = insertedCount_";
  protected final String TEXT_366 = " + pstmt_";
  protected final String TEXT_367 = ".executeUpdate();";
  protected final String TEXT_368 = NL + "\t\t\t\t";
  protected final String TEXT_369 = NL + "\t                conn_";
  protected final String TEXT_370 = ".releaseSavepoint(sp_";
  protected final String TEXT_371 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_372 = NL + "            } catch(java.lang.Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_373 = ".rollback(sp_";
  protected final String TEXT_374 = ");" + NL + "\t            ";
  protected final String TEXT_375 = NL + "                whetherReject_";
  protected final String TEXT_376 = " = true;";
  protected final String TEXT_377 = NL + "                    throw(e);";
  protected final String TEXT_378 = " = new ";
  protected final String TEXT_379 = "Struct();";
  protected final String TEXT_380 = NL + "                        rejectedCount_";
  protected final String TEXT_381 = " = rejectedCount_";
  protected final String TEXT_382 = " + 1;";
  protected final String TEXT_383 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_384 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_385 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_386 = NL + "            }";
  protected final String TEXT_387 = NL + "                    routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_388 = ",updateSQLSplits_";
  protected final String TEXT_389 = NL + "\t\t\t\t\tint count_";
  protected final String TEXT_390 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_391 = NL + "\t\t\t\t\t   ";
  protected final String TEXT_392 = NL + "\t\t\t\t\t";
  protected final String TEXT_393 = NL + "\t\t\t\t\t\t\tquery_";
  protected final String TEXT_394 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t\t   query_";
  protected final String TEXT_396 = ";" + NL + "\t\t\t    ";
  protected final String TEXT_397 = NL + "\t                sp_";
  protected final String TEXT_398 = ".setSavepoint();" + NL + "\t            ";
  protected final String TEXT_399 = NL + "                updatedCount_";
  protected final String TEXT_400 = " = updatedCount_";
  protected final String TEXT_401 = NL + "                \tconn_";
  protected final String TEXT_402 = NL + "                    \t";
  protected final String TEXT_403 = NL + "            int checkCount_";
  protected final String TEXT_404 = " = -1;" + NL + "            try (java.sql.ResultSet rs_";
  protected final String TEXT_405 = " = pstmt_";
  protected final String TEXT_406 = ".executeQuery()) {" + NL + "                while(rs_";
  protected final String TEXT_407 = ".next()) {" + NL + "                    checkCount_";
  protected final String TEXT_408 = " = rs_";
  protected final String TEXT_409 = ".getInt(1);" + NL + "                }" + NL + "            }" + NL + "            if(checkCount_";
  protected final String TEXT_410 = " > 0) {";
  protected final String TEXT_411 = NL + "                            query_";
  protected final String TEXT_412 = NL + NL + "\t\t\t\t\t\tint count_";
  protected final String TEXT_413 = ", pstmtUpdate_";
  protected final String TEXT_414 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_415 = NL + "\t\t\t\t\t\t\t\tquery_";
  protected final String TEXT_416 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_417 = ";" + NL + "\t\t\t\t    \t";
  protected final String TEXT_418 = NL + "                    globalMap.put(\"";
  protected final String TEXT_419 = NL + "                try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_420 = NL + "\t                    sp_";
  protected final String TEXT_421 = ".setSavepoint();" + NL + "\t                ";
  protected final String TEXT_422 = NL + "                    updatedCount_";
  protected final String TEXT_423 = " + pstmtUpdate_";
  protected final String TEXT_424 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_425 = "++;";
  protected final String TEXT_426 = NL + "    \t                conn_";
  protected final String TEXT_427 = ");" + NL + "    \t            ";
  protected final String TEXT_428 = NL + "                } catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_429 = NL + "                    whetherReject_";
  protected final String TEXT_430 = NL + "                        throw(e);";
  protected final String TEXT_431 = NL + "                        nb_line_";
  protected final String TEXT_432 = NL + "                                ";
  protected final String TEXT_433 = NL + "                            rejectedCount_";
  protected final String TEXT_434 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_435 = NL + "                }" + NL + "            } else {";
  protected final String TEXT_436 = NL + "\t\t\t\t\t\troutines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_437 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\t\t\t\tDynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_439 = ", pstmtInsert_";
  protected final String TEXT_440 = NL + "                    insertedCount_";
  protected final String TEXT_441 = " + pstmtInsert_";
  protected final String TEXT_442 = NL + "                }" + NL + "            }";
  protected final String TEXT_443 = NL + "            int updateFlag_";
  protected final String TEXT_444 = "=0;";
  protected final String TEXT_445 = NL + NL + "\t\t\t\t\tint count_";
  protected final String TEXT_446 = NL + "    \t\t\t\t\t";
  protected final String TEXT_447 = NL + "\t\t\t\t\t\tquery_";
  protected final String TEXT_448 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_449 = NL + NL + "            try {" + NL + "\t\t\t\t";
  protected final String TEXT_450 = NL + "                updateFlag_";
  protected final String TEXT_451 = "=pstmtUpdate_";
  protected final String TEXT_452 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_453 = "+updateFlag_";
  protected final String TEXT_454 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_455 = NL + "            if(updateFlag_";
  protected final String TEXT_456 = " == 0) {" + NL + "            \t";
  protected final String TEXT_457 = NL + "\t\t\t\tquery_";
  protected final String TEXT_458 = " = new StringBuffer(\"\");" + NL + "        \t\t";
  protected final String TEXT_459 = ");" + NL + "\t                \t\t\t";
  protected final String TEXT_460 = NL + "    \t            }else{" + NL + "    \t\t\t\t\tnb_line_";
  protected final String TEXT_461 = "++;" + NL + "    \t\t\t\t\t";
  protected final String TEXT_462 = NL + "     \t\t\t\t\t";
  protected final String TEXT_463 = NL + "    \t\t\t\t}" + NL + "                } catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_464 = NL + "                }";
  protected final String TEXT_465 = NL + "\t                        query_";
  protected final String TEXT_466 = ";" + NL + "\t                        ";
  protected final String TEXT_467 = ".addBatch();" + NL + "\t\t\tnb_line_";
  protected final String TEXT_468 = "++;" + NL + "\t\t\t  ";
  protected final String TEXT_469 = "++;" + NL + "    \t\t";
  protected final String TEXT_470 = NL + "            try {" + NL + "\t\t\t\t";
  protected final String TEXT_471 = NL + "                deletedCount_";
  protected final String TEXT_472 = " = deletedCount_";
  protected final String TEXT_473 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_474 = NL + "                    nb_line_";
  protected final String TEXT_475 = NL + "            if(!whetherReject_";
  protected final String TEXT_476 = ") {";
  protected final String TEXT_477 = NL + "    \t\t\tif ((batchSize_";
  protected final String TEXT_478 = " > 0) && (batchSize_";
  protected final String TEXT_479 = " <= batchSizeCounter_";
  protected final String TEXT_480 = ")) {" + NL + "                try {" + NL + "\t\t\t\t\t\tint countSum_";
  protected final String TEXT_481 = " = 0;" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_482 = NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_483 = ": pstmt_";
  protected final String TEXT_484 = ".executeBatch()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_485 = " += (countEach_";
  protected final String TEXT_486 = " < 0 ? 0 : countEach_";
  protected final String TEXT_487 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_488 = NL + "\t\t\t\t    \t";
  protected final String TEXT_489 = NL + "\t\t\t\t    \t\tinsertedCount_";
  protected final String TEXT_490 = " += countSum_";
  protected final String TEXT_491 = NL + "\t\t\t\t    \t\tupdatedCount_";
  protected final String TEXT_492 = NL + "\t\t\t\t    \t    deletedCount_";
  protected final String TEXT_493 = NL + "            \t    \tbatchSizeCounter_";
  protected final String TEXT_494 = " = 0;" + NL + "                }catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_495 = "){" + NL + "\t\t\t\t    \tjava.sql.SQLException ne_";
  protected final String TEXT_496 = " = e_";
  protected final String TEXT_497 = ".getNextException(),sqle_";
  protected final String TEXT_498 = "=null;" + NL + "\t\t\t\t    \tString errormessage_";
  protected final String TEXT_499 = ";" + NL + "\t\t\t\t\t\tif (ne_";
  protected final String TEXT_500 = " != null) {" + NL + "\t\t\t\t\t\t\t// build new exception to provide the original cause" + NL + "\t\t\t\t\t\t\tsqle_";
  protected final String TEXT_501 = " = new java.sql.SQLException(e_";
  protected final String TEXT_502 = ".getMessage() + \"\\ncaused by: \" + ne_";
  protected final String TEXT_503 = ".getMessage(), ne_";
  protected final String TEXT_504 = ".getSQLState(), ne_";
  protected final String TEXT_505 = ".getErrorCode(), ne_";
  protected final String TEXT_506 = ");" + NL + "\t\t\t\t\t\t\terrormessage_";
  protected final String TEXT_507 = " = sqle_";
  protected final String TEXT_508 = ".getMessage();" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\terrormessage_";
  protected final String TEXT_509 = ".getMessage();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t    \t";
  protected final String TEXT_510 = NL + "\t\t\t\t    \t\tif (ne_";
  protected final String TEXT_511 = " != null) {" + NL + "\t\t\t\t    \t\t\tthrow(sqle_";
  protected final String TEXT_512 = ");" + NL + "\t\t\t\t    \t\t}else{" + NL + "\t\t\t\t            \tthrow(e_";
  protected final String TEXT_513 = ");" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t    \t";
  protected final String TEXT_514 = NL + "\t\t\t\t    \tint countSum_";
  protected final String TEXT_515 = " = 0;" + NL + "\t\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_516 = ": e_";
  protected final String TEXT_517 = ".getUpdateCounts()) {" + NL + "\t\t\t\t\t\t\tcountSum_";
  protected final String TEXT_518 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_519 = NL + "\t\t\t\t    \tSystem.err.println(errormessage_";
  protected final String TEXT_520 = ");" + NL + "\t\t\t\t    \t";
  protected final String TEXT_521 = NL + "\t\t\t\t\t}" + NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_522 = NL + "    \t\t    commitCounter_";
  protected final String TEXT_523 = "++;" + NL + "                if(commitEvery_";
  protected final String TEXT_524 = " <= commitCounter_";
  protected final String TEXT_525 = NL + "                if ((batchSize_";
  protected final String TEXT_526 = " > 0) && (batchSizeCounter_";
  protected final String TEXT_527 = " > 0)) {" + NL + "                try {" + NL + "                \t\tint countSum_";
  protected final String TEXT_528 = " = 0;" + NL + "                \t\t    ";
  protected final String TEXT_529 = NL + "            \t    \t";
  protected final String TEXT_530 = NL + "            \t    \t\tinsertedCount_";
  protected final String TEXT_531 = ";" + NL + "            \t    \t";
  protected final String TEXT_532 = NL + "            \t    \t\tupdatedCount_";
  protected final String TEXT_533 = NL + "            \t    \t    deletedCount_";
  protected final String TEXT_534 = NL + "                batchSizeCounter_";
  protected final String TEXT_535 = " = 0;" + NL + "               }catch (java.sql.BatchUpdateException e_";
  protected final String TEXT_536 = "){" + NL + "\t\t\t    \tjava.sql.SQLException ne_";
  protected final String TEXT_537 = "=null;" + NL + "\t\t\t    \tString errormessage_";
  protected final String TEXT_538 = ";" + NL + "\t\t\t\t\tif (ne_";
  protected final String TEXT_539 = " != null) {" + NL + "\t\t\t\t\t\t// build new exception to provide the original cause" + NL + "\t\t\t\t\t\tsqle_";
  protected final String TEXT_540 = ");" + NL + "\t\t\t\t\t\terrormessage_";
  protected final String TEXT_541 = ".getMessage();" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\terrormessage_";
  protected final String TEXT_542 = ".getMessage();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t    \t";
  protected final String TEXT_543 = NL + "\t\t\t    \t\tif (ne_";
  protected final String TEXT_544 = " != null) {" + NL + "\t\t\t    \t\t\tthrow(sqle_";
  protected final String TEXT_545 = ");" + NL + "\t\t\t    \t\t}else{" + NL + "\t\t\t            \tthrow(e_";
  protected final String TEXT_546 = ");" + NL + "\t\t\t            }" + NL + "\t\t\t    \t";
  protected final String TEXT_547 = NL + "\t\t\t    \tint countSum_";
  protected final String TEXT_548 = " = 0;" + NL + "\t\t\t\t\tfor(int countEach_";
  protected final String TEXT_549 = ".getUpdateCounts()) {" + NL + "\t\t\t\t\t\tcountSum_";
  protected final String TEXT_550 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_551 = NL + "\t\t\t    \t\tinsertedCount_";
  protected final String TEXT_552 = ";" + NL + "\t\t\t    \t";
  protected final String TEXT_553 = NL + "\t\t\t    \t\tupdatedCount_";
  protected final String TEXT_554 = NL + "\t\t\t    \t    deletedCount_";
  protected final String TEXT_555 = NL + "\t\t\t    \tSystem.err.println(errormessage_";
  protected final String TEXT_556 = ");" + NL + "\t\t\t    \t";
  protected final String TEXT_557 = NL + "\t\t\t\t}" + NL + "            }";
  protected final String TEXT_558 = ".commit();" + NL + "                \t";
  protected final String TEXT_559 = NL + "                \tcommitCounter_";
  protected final String TEXT_560 = "=0;" + NL + "                }";

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
    public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String REDSHIFT = "redshift_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String SNOWFLAKE = "snowflake_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
            if(this.getColumn()!=null) {
                if (this.getColumn().getTalendType().equals("id_Geometry")) {
                    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
                        return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
                    return this.sqlStmt;
                }
            } else {
                return this.sqlStmt;
            }
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient
        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
          return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
          return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
              // minus are also a problem
              if (columnName.contains("-")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? SYBASE.equalsIgnoreCase(getDBMSId()) ? 1 : 0 : column.getColumn().getLength();
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if(ORACLE.equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (((MYSQL.equalsIgnoreCase(getDBMSId()))||(AS400.equalsIgnoreCase(getDBMSId())))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else if ((SNOWFLAKE.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("NUMBER".equalsIgnoreCase(dataType)))||("VARCHAR".equalsIgnoreCase(dataType))
                                    || ("CHAR".equalsIgnoreCase(dataType))||(("CHARACTER".equalsIgnoreCase(dataType)))||("STRING".equalsIgnoreCase(dataType))|| ("TEXT".equalsIgnoreCase(dataType))
                                    ||(("BINARY".equalsIgnoreCase(dataType)))||("VARBINARY".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                boolean isSpecialDBAndNotSetLength = (POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId())) && column.getColumn().getLength() == null;
                                if (!lengthIgnored) {
                                    if (isSpecialDBAndNotSetLength) {
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    if(!isSpecialDBAndNotSetLength) {
                                        createSQL.append(comma + precision);
                                    }
                                }
                                if (isSpecialDBAndNotSetLength) {
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            if(MYSQL.equalsIgnoreCase(getDBMSId()) ) {
                                String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                                int index = pkList.indexOf(columnStr);
                                if(index !=-1){
                                    for (int i=index;i>0;i--) {
                                        pkList.set(i, pkList.get(i-1));
                                    }
                                    pkList.set(0, columnStr);
                                }
                            }
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            if(DB2.equalsIgnoreCase(getDBMSId())&&column.isKey()){
                            	createSQL.append(" not null ");
                            }else{
                                createSQL.append(setNullable(column.getColumn().isNullable()));
                            }
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
        protected String getLengthStringRepresentation(String dataType, Integer length) {
        	return String.valueOf(length);
    	}
    
        protected String getAutoIncrement(int startValue, int step) {
            if(SYBASE.equalsIgnoreCase(getDBMSId()) || EXASOL.equalsIgnoreCase(getDBMSId())){
                return " IDENTITY NOT NULL";
            } else if(MYSQL.equalsIgnoreCase(getDBMSId()) ) {
                return " AUTO_INCREMENT";
            } else if(DB2.equalsIgnoreCase(getDBMSId())){
                return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
            } else if(TERADATA.equalsIgnoreCase(getDBMSId())){
                return " generated by default as identity (start with " + startValue + " increment by " + step + " no cycle) not null";
            }else {
                return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
            }
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.name.equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
                Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
                skeletonColumn.setOperator("=");
                skeletonColumn.setDataType(column.getType());
                stmtStructure.add(skeletonColumn);
                
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
                actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
                actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
                for(Column column : stmtStructure) {
                    if(column.isReplaced()) {
                        List<Column> replacedColumns = column.getReplacement();
                        for(Column replacedColumn : replacedColumns) {
                            actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
                        }
                    } else {
                        actionSQLMap = processSQLClause(column, actionSQLMap);        
                    }
                }
            }
            return actionSQLMap;
        }
        
        private boolean isSpecifyIdentityKey = false;
        
        public void setIsSpecifyIdentityKey(boolean isSpecifyIdentityKey) {
            this.isSpecifyIdentityKey = isSpecifyIdentityKey;
        }
        
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
            if(!(isSpecifyIdentityKey && (column.getName().equals(identityKey))) && column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol, Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(column, (incomingConnName+"."+dynCol+".getColumnCount()+"+index), incomingConnName, cid, actionType);
        }

        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType, String dynamic) {
            return generateSetBooleanForNullableKeyStmt(column, (index + dynamic + cid), incomingConnName, cid, actionType);
        }

        protected String generateSetBooleanForNullableKeyStmt(Column column, String index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(column, ""+index, incomingConnName, cid, actionType);
        }     
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
                String fieldDelimiter, 
                String newLineChar,
                String nullIndicator) {
        return null;
            
        }
        
        public String generateCode4TabelExist() {
            boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            StringBuilder code = new StringBuilder();  
            code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
            if (hasSchema()) {
                code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
                code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("} else {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("}\r\n");
            }
            return code.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }

        /*
         * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
         * this because of some db default add getLProtectedChar() and getRProtectedChar() to schema when create table. e.g:db2
         * 
         * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
        */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }   
        
        protected boolean hasSchema() {
            return false;
        }
        
        protected String getInsertQueryForDynamicSchema(String connection, String tableName, String insertColumnNames, String insertValues, String dataAction) {
            StringBuilder statementQuery = new StringBuilder();
            String quote = "\"";
            String dot = ".";
            String plus = "+";
            String comma = ",";

            StringBuilder queryPrefix = new StringBuilder("String ");

            if ("INSERT_IGNORE".equals(dataAction)) {
                queryPrefix.append("insert_").append(cid).append(" = ").append(quote).append("INSERT IGNORE INTO ");
            } else if ("REPLACE".equals(dataAction)) {
                queryPrefix.append("replace_").append(cid).append(" = ").append(quote).append("REPLACE INTO ");
            } else if ("INSERT_ON_DUPLICATE_KEY_UPDATE".equals(dataAction)) {
                queryPrefix.append("insertIgnore_").append(cid).append(" = ").append(quote).append("INSERT IGNORE INTO ");
            } else {
                queryPrefix.append("insert_").append(cid).append(" = ").append(quote).append("INSERT INTO ");
            }
            statementQuery.append(queryPrefix).append(getLProtectedChar()).append(quote).append(plus).append(tableName).append(cid).append(plus).append(quote).append(getRProtectedChar()).append(" (").append(quote).append(plus)
                .append("DynamicUtils.getInsertIntoStmtColumnsList(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(insertColumnNames).append(quote).append("))").append(plus)
                .append(quote).append(") VALUES (").append(quote).append(plus)
                .append("DynamicUtils.getInsertIntoStmtValuesList(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(insertValues).append(quote).append("))").append(plus)
                .append(quote).append(")").append(quote);

            return statementQuery.toString();
        }

        protected String getUpdateQueryForDynamicSchema(String connection, String tableName, String updateSetStmt, String updateWhereStmt, boolean supportNullWhere) {
            StringBuilder statementQuery = new StringBuilder();
            String quote = "\"";
            String dot = ".";
            String plus = "+";
            String comma = ",";
            statementQuery.append("String update_").append(cid).append(" = ").append(quote).append("UPDATE ").append(getLProtectedChar()).append(quote).append(plus).append(tableName).append(cid).append(plus).append(quote).append(getRProtectedChar()).append(" SET ").append(quote).append(plus)
                .append("DynamicUtils.getUpdateSet(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(updateSetStmt).append(quote).append("))").append(plus)
                .append(quote).append(" WHERE ").append(quote).append(plus)
                .append("DynamicUtils.getUpdateWhere(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(updateWhereStmt).append(quote).append(")").append(comma).append(supportNullWhere).append(")");
            return statementQuery.toString();
        }
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if (typeToGenerate.equals("Long")) {
                    setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + length);                                    
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                
                                createSQL.append(suffix);
                                
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if (VECTORWISE.equalsIgnoreCase(getDBMSId())){
                createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
        String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class HiveManager extends Manager {
        String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
        boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
            this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
                String recordDelimiter, String nullIndicator) {     
            StringBuilder copyBulkSQL = new StringBuilder();
            copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            copyBulkSQL.append(" (\"+");                
            int counter = 0;
            for(IMetadataColumn column : columnList) {
                counter++;
                // add each table field and separator
                copyBulkSQL.append( 
                "\n\"\\n" +
                  column.getOriginalDbColumnName() 
                + "="
                + (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
            
                // add these only if not last entry
                if (counter < columnList.size()){
                    copyBulkSQL.append(
                    //convertDelim(fieldDelimiter)
                    "\"+field_delimiter_"+cid +"+\""
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    + " ,"
                    + "\""
                    + "+"
                    );
                } else {
                    copyBulkSQL.append(
                    recordDelimiter
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    );
                    copyBulkSQL.append(")");
                }       
            } 
            return copyBulkSQL.toString();
        } 

        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
            + cid + " + \"\\\" TO TRUNCATED");
            return truncateTableSQL.toString();
        }                       
    }
    
    public class VectorWiseManager extends IngresManager {
        public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
    }   
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
            return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                    MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                    dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){                    
                    String pattern = column.getColumn().getPattern();
                    setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                    if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                    }
                    setStmt.append("}else{\r\n");
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                    setStmt.append("}\r\n");
                }else if("TIME".equals(dbType)){//TDI-30431 begin
                    String timePattern = column.getColumn().getPattern();
                    //Compatible with Time,Date and String,it will fail if Time contain fractional seconds.(Solution:Use sqljdbc.jar and setTime() instead)
                    //setStmt.append(prefix + cid + ".setString(" + index + dynamic + "," + incomingConnName + "." + column.getName()+".toString()");// For Time and String
                    setStmt.append(prefix + cid + ".setString(" + index + dynamic + ","
                                    + incomingConnName + "." + column.getName()
                                    +" instanceof java.util.Date ? new java.text.SimpleDateFormat("+timePattern+").format("
                                    + incomingConnName + "." + column.getName()+") : "
                                    + incomingConnName + "." + column.getName()+".toString()");//Compatible with tFileInputDelimiter Date Type and Time and String
                    setStmt.append(");\r\n");
                }else{//TDI-30431 end
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                if ("TIME".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIME);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                }
                setStmt.append("}\r\n");
            } else if("String".equals(typeToGenerate)) {
                   if ("NVARCHAR".equalsIgnoreCase(column.dataType) || "NCHAR".equalsIgnoreCase(column.dataType) || "NTEXT".equalsIgnoreCase(column.dataType)) {
                        boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
                        setStmt.append("String driver = null;\r\n");
                        if (useExistingConnection) {
                            String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
                            setStmt.append("driver = ((String)globalMap.get(\"driver_" + connection + "\"));\r\n");
                        } else {
                            setStmt.append("driver = \"" + ElementParameterParser.getValue(node, "__DRIVER__") +"\";\r\n");
                        }

                        setStmt.append("if (\"MSSQL_PROP\".equals(driver)) {\r\n");
                            setStmt.append(prefix + cid + ".setNString(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                        setStmt.append("} else {\r\n");
                            setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                        setStmt.append("}\r\n");
                   } else {
                        setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                   }
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + getLengthStringRepresentation(dataType, length));
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + getLengthStringRepresentation(dataType, length));
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                
                                createSQL.append(suffix);
                                
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
        protected String getLengthStringRepresentation(String dataType, Integer length) {
	        if (("VARCHAR".equalsIgnoreCase(dataType) && length > 8000) || ("NVARCHAR".equalsIgnoreCase(dataType) && length > 4000)
	                || ("VARBINARY".equalsIgnoreCase(dataType) && length > 8000)) {
	            return "MAX";
	        }
	        return String.valueOf(length);
	    }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();

            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                //also check if DBType is year
                boolean isDBTypeEqualsYear = column.getColumn().getType().equalsIgnoreCase("year");
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                if (isDBTypeEqualsYear) {
                    setStmt.append("java.util.Calendar yearCalendar_" + cid + " = new java.util.GregorianCalendar();\r\n");
                    setStmt.append("yearCalendar_" + cid + ".setTimeInMillis(date_" + cid + ");\r\n");
                    setStmt.append("\r\n");
                    setStmt.append("int yearValue_" + cid + " = yearCalendar_" + cid + ".get(java.util.Calendar.YEAR);\r\n");
                    setStmt.append("if (yearValue_" + cid + " > 2155 || yearValue_" + cid + " < 1901) { \r\n");
                    setStmt.append("\t" + prefix + cid + ".setInt(" + index + ", 0);\r\n");
                } else {
                    setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                    setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                }
                setStmt.append("} else {");

                if (isDBTypeEqualsYear) {
                    setStmt.append("\t" + prefix + cid + ".setInt(" + index + ", yearValue_" + cid + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                }
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");

            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
          private String[] oracleKeyWords= {
                    "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                    "ADD","CONNECT","DISTINCT" ,
                    "ALL","BY","CREATE","DROP",
                    "ALTER","CHAR","CURRENT","ELSE",
                    "AND","CHECK","DATE","EXCLUSIVE",
                    "ANY","CLUSTER","DECIMAL"," EXISTS",
                    "AS","COLUMN","DEFAULT","FILE",
                    "ASC","COMMENT","DELETE","FLOAT",
                    "FOR","LONG","PCTFREE","SUCCESSFUL",
                    "FROM","MAXEXTENTS","PRIOR","SYNONYM",
                    "GRANT","MINUS","PRIVILEGES","SYSDATE",
                    "GROUP","MODE","PUBLIC","TABLE",
                    "HAVING","MODIFY","RAW","THEN",
                    "IDENTIFIED","NETWORK","RENAME","TO",
                    "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                    "IN","NOCOMPRESS","REVOKE","UID",
                    "INCREMENT","NOT","ROW","UNION",
                    "INDEX","NOWAIT","ROWID","UNIQUE",
                    "INITIAL","NULL","ROWNUM","UPDATE",
                    "INSERT","NUMBER","ROWS","USER",
                    "INTEGER","OF","SELECT","VALIDATE",
                    "INTERSECT","OFFLINE","SESSION","VALUES",
                    "INTO","ON","SET","VARCHAR",
                    "IS","ONLINE","SHARE","VARCHAR2",
                    "LEVEL","OPTION","SIZE","VIEW",
                    "LIKE","OR","SMALLINT","WHENEVER",
                    "LOCK","ORDER","START","WHERE","WITH"
                    };
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
        	return generateSetStmt(typeToGenerate, column.getColumn().getType(), column, index, incomingConnName, cid, actionType, dynamic);
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            if(dbType == null){
            	dbType = "";
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_10".equals(dbVersion) || "ORACLE_11".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_18".equals(dbVersion) )){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
                        setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                        setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && (dbType.equals("XMLTYPE")||dbType.equals("CLOB")))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  clobTypeUtil_" + cid + ".getCLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  blobTypeUtil_" + cid + ".getBLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
            if(convertToUppercase){
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
            }else{
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
            }
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
            String columnName = column.getColumnName();
            String dataType = column.getDataType();
            if(dataType!=null)
            {
            boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
            if(trimChar && "char".equals(dataType.toLowerCase()))
            {
                columnName = "trim("+columnName+")";
            }
            }
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");
            } else if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + ", " + incomingConnName + "." + column.getName() + ", java.sql.Types.OTHER);\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class RedshiftManager extends PostgreManager {

         String redshiftTracker = org.talend.core.utils.TrackerUtil.getRedshiftTracker();
         public RedshiftManager(String cid) {
             super(cid);
         }
         
         protected String getDBMSId() {
             return REDSHIFT;
         }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append(redshiftTracker +" \\n " + "SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append(redshiftTracker +" \\n " + "DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append(redshiftTracker +" \\n " + "TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }

        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append(redshiftTracker +" \\n " + "DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
         
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
        	
        	
            createSQL.append(redshiftTracker +" \\n " + "CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if(("DECIMAL".equalsIgnoreCase(dataType) || "NUMERIC".equalsIgnoreCase(dataType)) 
                        	&& (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                            && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {
                        	
                        } else { 
	                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
	                            if (!precisionIgnored) {
	                                prefix = "(";
	                                suffix = ") ";
	                                createSQL.append(prefix + precision);
	                            }
	                            if (!lengthIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (precisionIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + length);
	                            }
	                            createSQL.append(suffix);
	                        } else {
	                            if (!lengthIgnored) {
	                                if (column.getColumn().getLength() == null) {
	                                } else { 
	                                    prefix = "(";
	                                    suffix = ") ";
	                                    createSQL.append(prefix + length);                                    
	                                }
	                            }
	                            if (!precisionIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (lengthIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                
	                                if(column.getColumn().getLength() != null) {
	                                    createSQL.append(comma + precision);
	                                }
	                            }
	                            if (column.getColumn().getLength() == null) {
	                            } else {
	                                createSQL.append(suffix);
	                            }
	                        }
	                    }
                            
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class GreenplumManager extends PostgrePlusManager {
         public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
         private String[] sybaseKeyWords= {
                 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                "ADD","CONNECT","COUNT","DISTINCT" ,
                "ALL","BY","CREATE","DROP",
                "ALTER","CHAR","CURRENT","ELSE",
                "AND","CHECK","DATE","EXCLUSIVE",
                "ANY","CLUSTER","DECIMAL"," EXISTS",
                "AS","COLUMN","DEFAULT","FILE",
                "ASC","COMMENT","DELETE","FLOAT",
                "FOR","LONG","PCTFREE","SUCCESSFUL",
                "FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
                "GRANT","MINUS","PRIVILEGES","SYSDATE",
                "GROUP","MODE","PUBLIC","TABLE",
                "HAVING","MODIFY","RAW","THEN",
                "IDENTIFIED","NETWORK","RENAME","TO",
                "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                "IN","NOCOMPRESS","REVOKE","UID",
                "INCREMENT","NOT","ROW","UNION",
                "INDEX","NOWAIT","ROWID","UNIQUE",
                "INITIAL","NULL","ROWNUM","UPDATE",
                "INSERT","NUMBER","ROWS","USER",
                "INTEGER","OF","SELECT","VALIDATE",
                "INTERSECT","OFFLINE","SESSION","VALUES",
                "INTO","ON","SET","VARCHAR",
                "IS","ONLINE","SHARE",
                "LEVEL","OPTION","SIZE","VIEW",
                "LIKE","OR","SMALLINT","WHENEVER",
                "LOCK","ORDER","START","WHERE","WITH"
                 
         };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal")){
                if(column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                    setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
                    setStmt.append("} else {\r\n");
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                    setStmt.append("}\r\n");
                }else{
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
                
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes") || typeToGenerate.equals("Object")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            } else if ((typeToGenerate.equals("Object")) && (dbType != null && (dbType.equals("CLOB")))){
                setStmt.append("if (" + incomingConnName + "." + column.getName() + " instanceof String){\r\n");
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()) , (" + incomingConnName + "." + column.getName() + ").toString().getBytes().length);\r\n"); 
                setStmt.append("} else if (" + incomingConnName + "." + column.getName() + " instanceof byte[]){\r\n");
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + ") , ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n"); 
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + length);                                    
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                
                                createSQL.append(suffix);
                                
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && "UUID".equals(column.column.getType())) {//TODO the same with the common dynamic process code, maybe need to use java.sql.Types.NULL always
                	setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.NULL);\r\n");
                } else {
                	setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //TODO remove another generateSetStmt method after a full research on db type process
        //strange thing is that we process some db type difference if dynamic type exists, 
        //think it is not right, should do the same thing if dynamic type exists or not.
        //now only keep the old action, not affect the current feature fix
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else if(column.column != null && "UUID".equals(column.column.getType())) {//TODO the same with the common dynamic process code, maybe need to use java.sql.Types.NULL always
                	setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.NULL);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
         
        public String getCreateTableSQL(List<Column> columnList){

            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";

                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                
                                createSQL.append(suffix);
                                
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        
        }
        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        String lChar = "";
        String rChar = "";
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return lChar;
        }
        protected String getRProtectedChar() {
            return rChar;
        }        
        public void setLProtectedChar(String lChar){
            this.lChar = lChar;
        }
        public void setRProtectedChar(String rChar){
            this.rChar = rChar;
        }
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
    
		private String[] keywords = { "ABS", "ACOS", "ADD_DAYS", "ADD_HOURS",
				"ADD_MINUTES", "ADD_MONTHS", "ADD_SECONDS", "ADD_WEEKS",
				"ADD_YEARS", "ADMIN", "ALIGN", "ALWAYS", "ANALYZE", "ANSI",
				"ASCII", "ASIN", "ASSIGNMENT", "ASYMMETRIC", "ATAN", "ATAN2",
				"ATOMIC", "AUDIT", "AUTHENTICATED", "AUTO", "AVG", "BACKUP",
				"BERNOULLI", "BIT_AND", "BIT_CHECK", "BIT_LENGTH", "BIT_NOT",
				"BIT_OR", "BIT_SET", "BIT_TO_NUM", "BIT_XOR", "BREADTH",
				"CEIL", "CEILING", "CHANGE", "CHARACTERS", "CHARACTER_LENGTH",
				"CHR", "CLEAR", "COBOL", "COLOGNE_PHONETIC", "COMMENT",
				"COMMENTS", "COMMITTED", "CONCAT", "CONNECT", "CONVERT_TZ",
				"CORR", "COS", "COSH", "COT", "COUNT", "COVAR_POP",
				"COVAR_SAMP", "CREATED", "CROSS", "CURDATE", "DATABASE",
				"DATE_TRUNC", "DAYS_BETWEEN", "DECODE", "DEFAULTS", "DEGREES",
				"DELIMIT", "DELIMITER", "DENSE_RANK", "DEPTH", "DIAGNOSTICS",
				"DICTIONARY", "DISTRIBUTE", "DISTRIBUTION", "DIV", "DOWN",
				"DUMP", "EDIT_DISTANCE", "EMITS", "ENCODING", "ESTIMATE",
				"EVALUATE", "EXA", "EXCLUDE", "EXCLUDING", "EXP", "EXPRESSION",
				"FIRST_VALUE", "FLOOR", "FLUSH", "FOREIGN", "FORTRAN",
				"FROM_POSIX_TIME", "GREATEST", "GROUPING_ID", "HANDLER", "HAS",
				"HASH", "HASH_MD5", "HASH_SHA", "HASH_SHA1", "HASH_TIGER",
				"HIERARCHY", "HOURS_BETWEEN", "IDENTIFIED", "IGNORE",
				"INCLUDING", "INITIALLY", "INSTR", "INVALID", "ISOLATION",
				"IS_BOOLEAN", "IS_DATE", "IS_DSINTERVAL", "IS_NUMBER",
				"IS_TIMESTAMP", "IS_YMINTERVAL", "JAVA", "JAVASCRIPT", "KEEP",
				"KEY", "KEYS", "KILL", "LAG", "LANGUAGE", "LAST_VALUE",
				"LCASE", "LEAD", "LEAST", "LENGTH", "LINK", "LN", "LOCATE",
				"LOCK", "LOG10", "LOG2", "LOGS", "LONG", "LOWER", "LPAD",
				"LTRIM", "LUA", "MAX", "MAXIMAL", "MEDIAN", "MID", "MIN",
				"MINUTES_BETWEEN", "MONTHS_BETWEEN", "MUMPS", "NEVER", "NICE",
				"NORMALIZED", "NOW", "NULLIFZERO", "NULLS", "NUMTODSINTERVAL",
				"NUMTOYMINTERVAL", "NVL", "OCTETS", "OCTET_LENGTH", "OFFSET",
				"OPTIMIZE", "ORA", "OWNER", "PADDING", "PARTITION", "PASCAL",
				"PERCENTILE_CONT", "PERCENTILE_DISC", "PI", "PLI",
				"POSIX_TIME", "POWER", "PRECISION", "PRELOAD", "PRIMARY",
				"PRIORITY", "PRIVILEGE", "PYTHON", "QUERY_CACHE",
				"QUERY_TIMEOUT", "R", "RADIANS", "RAND", "RANK",
				"RATIO_TO_REPORT", "RECOMPRESS", "RECORD", "REGEXP_INSTR",
				"REGEXP_REPLACE", "REGEXP_SUBSTR", "REGR_AVGX", "REGR_AVGY",
				"REGR_COUNT", "REGR_INTERCEPT", "REGR_R2", "REGR_SLOPE",
				"REGR_SXX", "REGR_SXY", "REGR_SYY", "REJECT", "REORGANIZE",
				"REPEATABLE", "REVERSE", "ROLE", "ROUND", "ROWID",
				"ROW_NUMBER", "RPAD", "RTRIM", "SCALAR", "SCHEMAS", "SCHEME",
				"SECONDS_BETWEEN", "SECURE", "SERIALIZABLE", "SHUT", "SIGN",
				"SIMPLE", "SIN", "SINH", "SIZE", "SKIP", "SOUNDEX", "SQRT",
				"STATISTICS", "STDDEV", "STDDEV_POP", "STDDEV_SAMP", "ST_AREA",
				"ST_BOUNDARY", "ST_BUFFER", "ST_CENTROID", "ST_CONTAINS",
				"ST_CONVEXHULL", "ST_CROSSES", "ST_DIFFERENCE", "ST_DIMENSION",
				"ST_DISJOINT", "ST_DISTANCE", "ST_ENDPOINT", "ST_ENVELOPE",
				"ST_EQUALS", "ST_EXTERIORRING", "ST_FORCE2D", "ST_GEOMETRYN",
				"ST_GEOMETRYTYPE", "ST_INTERIORRINGN", "ST_INTERSECTION",
				"ST_INTERSECTS", "ST_ISCLOSED", "ST_ISEMPTY", "ST_ISRING",
				"ST_ISSIMPLE", "ST_LENGTH", "ST_NUMGEOMETRIES",
				"ST_NUMINTERIORRINGS", "ST_NUMPOINTS", "ST_OVERLAPS",
				"ST_POINTN", "ST_SETSRID", "ST_STARTPOINT", "ST_SYMDIFFERENCE",
				"ST_TOUCHES", "ST_TRANSFORM", "ST_UNION", "ST_WITHIN", "ST_X",
				"ST_Y", "SUBSTR", "SUM", "SYMMETRIC", "SYS_CONNECT_BY_PATH",
				"SYS_GUID", "TABLES", "TABLESAMPLE", "TAN", "TANH", "TASKS",
				"TIES", "TIME_ZONE", "TIME_ZONE_BEHAVIOR", "TO_CHAR",
				"TO_DATE", "TO_DSINTERVAL", "TO_NUMBER", "TO_TIMESTAMP",
				"TO_YMINTERVAL", "TRANSLATE", "TRUNC", "TYPE", "UCASE",
				"UNBOUNDED", "UNCOMMITTED", "UNDO", "UNICODE", "UNICODECHR",
				"UNLIMITED", "UPPER", "UTF8", "VARIANCE", "VARYING", "VAR_POP",
				"VAR_SAMP", "WEEK", "WRITE", "YEARS_BETWEEN", "ZEROIFNULL" };
				
        public ExasolManager(String cid) {
            super(cid);
        }

        protected boolean isReservedWord(String keyword) {
            for (int i=0 ; i < keywords.length ; i++){
                if (keywords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }

        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getLProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }
        protected String getRProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }  
    }
    
    public class AzureSynapseManager extends MSSQLManager{
    
        public AzureSynapseManager(String cid) {
            super(cid);
        }
        
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            boolean isPolyBase = "POLYBASE".equals(ElementParameterParser.getValue(node,"__LOAD_METHOD__"));
            if(isPolyBase){
                dropTableSQL.append("DROP EXTERNAL TABLE " + getLProtectedChar() + "\" + ext_tableName_" + cid + " + \"" + getRProtectedChar());
            }else{
                dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            }
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            boolean isPolyBase = "POLYBASE".equals(ElementParameterParser.getValue(node,"__LOAD_METHOD__"));
            if(isPolyBase){
                createSQL.append("CREATE EXTERNAL TABLE " + getLProtectedChar() + "\" + ext_tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            }else{
                createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            }
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + getLengthStringRepresentation(dataType, length));
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + getLengthStringRepresentation(dataType, length));
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    
                                    createSQL.append(comma + precision);
                                }
                                createSQL.append(suffix);
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }

    public class SnowflakeManager extends Manager {
       public SnowflakeManager(String cid) {
          super(cid);
       }
       protected String getDBMSId() {
          return SNOWFLAKE;
       }
       protected String getLProtectedChar() {
          return "";
       }
       protected String getRProtectedChar() {
          return "";
       }
    }

    public class UnDefinedManager extends Manager{
        
        private String dbmsId = "";
        
        public UnDefinedManager(String cid) {
            super(cid);
        }
        public void setDBMSId(String dbmsId){
            this.dbmsId = dbmsId;
        }
        protected String getDBMSId() {
            return this.dbmsId;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    //the managers which only work for tELTJDBCOutput component, we add it to ignore the text quote which wrap the schema, table or column name.
    
    public class AS400ELTManager extends AS400Manager {
        public AS400ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class AccessELTManager extends AccessManager {
        public AccessELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class DB2ELTManager extends DB2Manager {
        public DB2ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class FirebirdELTManager extends FirebirdManager {
        public FirebirdELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HSQLDBELTManager extends HSQLDBManager {
        public HSQLDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HiveELTManager extends HiveManager {
        public HiveELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InformixELTManager extends InformixManager {
        public InformixELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class IngresELTManager extends IngresManager {
        public IngresELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VectorWiseELTManager extends VectorWiseManager {
        public VectorWiseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InterbaseELTManager extends InterbaseManager {
        public InterbaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class JavaDBELTManager extends JavaDBManager {
        public JavaDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MaxDBELTManager extends MaxDBManager {
        public MaxDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLELTManager extends MSSQLManager {
        public MSSQLELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MysqlELTManager extends MysqlManager {
        public MysqlELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class NetezzaELTManager extends NetezzaManager {
        public NetezzaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class OracleELTManager extends OracleManager {
        public OracleELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgrePlusELTManager extends PostgrePlusManager {
        public PostgrePlusELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class GreenplumELTManager extends GreenplumManager {
        public GreenplumELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgreELTManager extends PostgreManager {
        public PostgreELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class RedshiftELTManager extends RedshiftManager {
        public RedshiftELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SQLiteELTManager extends SQLiteManager {
        public SQLiteELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SybaseELTManager extends SybaseManager {
        public SybaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class TeradataELTManager extends TeradataManager {
        public TeradataELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VerticaELTManager extends VerticaManager {
        public VerticaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class ExasolELTManager extends ExasolManager {
        public ExasolELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SAPHanaELTManager extends SAPHanaManager {
        public SAPHanaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }

    public class SnowflakeELTManager extends SnowflakeManager {
        public SnowflakeELTManager(String cid) {
            super(cid);
        }
    }
    
    public Manager getELTManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresELTManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SNOWFLAKE)) {
                manager = new SnowflakeELTManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //ELT part end
    
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                if(cid != null && cid.indexOf("tAzureSynapseBulkExec") > -1){
                    manager = new AzureSynapseManager(cid);
                }else{
                    manager = new MSSQLManager(cid); 
                }
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SNOWFLAKE)) {
                manager = new SnowflakeManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }
    
    public Manager getELTManager(String dbmsId, String cid, INode node) {
        Manager manager = getELTManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
    }
    
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$") || cidx.matches("^.*?tDBOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
	
	public String varForTableName(String varName, String dbmsId) {
		if ("id_MSSQL".equals(dbmsId) || cid.startsWith("tMSSQL")) {
			return "\"[\" +" + var(varName) + " + \"]\"";
		} else if ("ibmdb2_id".equals(dbmsId) || "redshift_id".equals(dbmsId) || "postgres_id".equals(dbmsId) || cid.startsWith("tDB2") || 
			cid.startsWith("tRedshift") || cid.startsWith("tGreenplum")){
			return new StringBuilder().append("\"\\\"\" +").append(var(varName)).append("+ \"\\\"\"").toString();
		} else {
			return var(varName);
		}
	}
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
                    java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                    ignoredParamsTypes.addAll(
                        java.util.Arrays.asList(
                            org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                            org.talend.core.model.process.EParameterFieldType.LABEL,
                            org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                            org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                            org.talend.core.model.process.EParameterFieldType.IMAGE,
                            org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                            org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                            org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                            org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                            org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                            org.talend.core.model.process.EParameterFieldType.VERSION,
                            org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                            org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                            org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                            org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                            org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                            org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                            org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                            )
                    );
                    for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                        if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                            continue;
                        }
                        String name = ep.getName();
                        if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                            String epName = "__" + name + "__";
                            String password = "";
                            if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                                password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                            }else{
                                String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                                if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                                    passwordValue = "\"\"";
                                } 
                                password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                            } 
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_10);
    
                        }   
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_22);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    
                }else{
                
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    
                }
                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_2);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			debug(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			debug(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		debug(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			debug(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			debug(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			debug(str("Closing the connection to the database."));
		}else{
			debug(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection to the database has closed."));	
		}else{
			debug(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		debug(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		debug(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlDebugPrint(String sql){
		debug(str("'"), sql, str("'."));
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		debug(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    

    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    dbLog = new DBLogUtil(node);

    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");
    String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");
    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");

    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));

    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");

    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));

	boolean useSpatialOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_SPATIAL_OPTIONS__"));
    boolean createSpatialIndex = ("true").equals(ElementParameterParser.getValue(node,"__SPATIAL_INDEX__"));
    boolean createGeometryColumns = ("true").equals(ElementParameterParser.getValue(node,"__GEOMETRY_COLUMNS__"));

	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	String batchSize=ElementParameterParser.getValue(node,"__BATCH_SIZE__");
	
	boolean convertToLowercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_LOWERCASE__"));

	//feature:22704
	boolean savePoint = ("true").equals(ElementParameterParser.getValue(node,"__SAVE_POINT__"));
	boolean showSavePoint = false;

    if(("true").equals(useExistingConn)) {
        showSavePoint =  savePoint && !useBatchSize && !("true").equals(dieOnError);
    }else{
        showSavePoint =  savePoint && !useBatchSize && !("true").equals(dieOnError) && (!("").equals(commitEvery) && !("0").equals(commitEvery));
    }

    //feature:2880
    getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");

    String incomingConnName = null;
    List<IMetadataColumn> columnList = getColumnList(node);

    List< ? extends IConnection> conns = node.getIncomingConnections();
    if(conns!=null && conns.size()>0){
        IConnection conn = conns.get(0);
        incomingConnName = conn.getName();
    }

    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }

    boolean useBatch = useBatchSize && (rejectConnName == null)
                     && (
                          ("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)
                        );

    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    
        }
    }

	Manager manager = null;
	boolean isDynamic = false;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		isDynamic = metadata.isDynamicSchema();
	}

	List<Column> stmtStructure =  getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
    isDynamic = isDynamic && !getManager(dbmsId, cid).isDynamicColumnReplaced();
	IMetadataColumn talendDynCol = null;
    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt:stmtStructure){
    	if (!colStmt.isReplaced()&&!colStmt.isAddCol()&&!colStmt.isDynamic()) {
    		colStruct.add(colStmt);
    		if (convertToLowercase)
    			colStmt.setColumnName(colStmt.getColumnName().toLowerCase());
    	} else if ( colStmt.isReplaced() ) {
	    	List <Column> replacements = colStmt.getReplacement() ;
	    	for (int i=0; i < replacements.size() ; i++) {
	    		Column columnTest =columnTest = replacements.get(i);
	    		if (convertToLowercase)
	    			columnTest.setColumnName(columnTest.getColumnName().toLowerCase());
	    		String sqlExpression = columnTest.getSqlStmt();
				if (sqlExpression.contains("?")) {
					colStruct.add(colStmt);
				}
			}
    	}
    }

	if(isEnableDebug) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	}

	if(isDynamic) {
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
			if(columnList != null && columnList.size()>0) {
       manager = null;
    
    
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
boolean convertToLowercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_LOWERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    manager = getManager(dbmsId, cid);
    
    String ending="";
    
    //TODO need to remove it as it seems not useful now
    if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
        ending="WITH STRUCTURE = VECTORWISE";
    }

    boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__USE_CASCADE__"));
    
    //bugfix: TDI-31650
    boolean setQueryTimeOut = false;
    String queryTimeOutInSeconds = null;
    if(SYBASE.equalsIgnoreCase(dbmsId)){
        setQueryTimeOut = "true".equals(ElementParameterParser.getValue(node,"__SET_QUERY_TIMEOUT__"));
        queryTimeOutInSeconds = ElementParameterParser.getValue(node,"__QUERY_TIMEOUT_IN_SECONDS__");
    }
	
    if(!("NONE").equals(tableAction)) {
        if(("DROP_CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_46);
    
               }
             
    dbLog.table().dropTry(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_49);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_10);
    dbLog.table().dropDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_50);
    
                if (TERADATA.equalsIgnoreCase(dbmsId)) {
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
                }
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
               }
             
    dbLog.table().createTry(dbLog.varForTableName("tableName", dbmsId));
    
                if(isDynamic) {
                List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                    if(conns_dynamic!=null && conns_dynamic.size()>0){
                        String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(convertToLowercase_tableAction);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_66);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_69);
    
                    }
                } else {
            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_71);
    
            }
            
    dbLog.table().createDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_50);
    
        } else if(("CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
               }
             
    dbLog.table().createTry(dbLog.varForTableName("tableName", dbmsId));
    
            if(isDynamic) {
                List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(convertToLowercase_tableAction);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_66);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_69);
    
                }
            } else {
            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_71);
    
            }
            
    dbLog.table().createDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_50);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
            boolean tableNameCaseSensitive=false;
            if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
                tableNameCaseSensitive=true;
            }
            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_77);
    //bug22719: informix use independent connection, should remove this code after use shared connection
                if(INFORMIX.equalsIgnoreCase(dbmsId)){
                    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
                    String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
                    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
                    String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
                    String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
                    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_82);
    }else{
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
            }
            
    
                            /*
                            case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
                            so in mssql use "Select" checked the table whether exist.
                            */
                            //TODO we will use like "select" sql intead of use system table to checked table?
                            if(MSSQL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
                            } else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_96);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
                            } else if ( SYBASE.equalsIgnoreCase(dbmsId)
                                        || INFORMIX.equalsIgnoreCase(dbmsId) ) {
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                            } else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_125);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                            } else if (GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_125);
    if(convertToLowercase_tableAction){
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
                            } else if(REDSHIFT.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
                            } else if(MYSQL.equalsIgnoreCase(dbmsId)) {
                                boolean useExistMySQLConn = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
                                String dbnameMySQL = null;
                                if (useExistMySQLConn) {
                                    List< ? extends INode> nodes =  node.getProcess().getNodesOfType("tMysqlConnection");
                                    String connectionMySQL = ElementParameterParser.getValue(node,"__CONNECTION__");
                                    for (INode ne : nodes) {
                                        if (connectionMySQL.equals(ne.getUniqueName())) {
                                            dbnameMySQL = ElementParameterParser.getValue(ne, "__DBNAME__");
                                            break;
                                        }
                                    }
                                } else {
                                    dbnameMySQL = ElementParameterParser.getValue(node, "__DBNAME__");
                                }
                                dbnameMySQL = ("".equals(dbnameMySQL)) ? null : dbnameMySQL;
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    if (dbnameMySQL != null) {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(dbnameMySQL);
    stringBuffer.append(TEXT_169);
    } else {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
                            } else {
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                            }
                            
    
                            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
                            
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
                                       }
                                     
    dbLog.table().createTry(dbLog.varForTableName("tableName", dbmsId));
    
                                    if(isDynamic) {
                                        List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                        if(conns_dynamic!=null && conns_dynamic.size()>0){
                                            String query=manager.getCreateTableSQL(stmtStructure);
                                            
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(convertToLowercase_tableAction);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_66);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_69);
    
                                        }
                                    } else {
                                    
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_71);
    
                                    }
                                    
    dbLog.table().createDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_188);
    
                            } else {
                            
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
                                           if(setQueryTimeOut){
                                                
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
                                           }
                                     
    dbLog.table().dropTry(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_49);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_10);
    dbLog.table().dropDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_193);
    
                                        if (TERADATA.equalsIgnoreCase(dbmsId)) {
                                    
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
                                        }
                                    
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
                                       if(setQueryTimeOut){
                                        
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
                                   }
                                 
    dbLog.table().createTry(dbLog.varForTableName("tableName", dbmsId));
    
                                if(isDynamic) {
                                    List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                    if(conns_dynamic!=null && conns_dynamic.size()>0){
		                                String query=manager.getCreateTableSQL(stmtStructure);
                                        
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(convertToLowercase_tableAction);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_66);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_69);
    
                                    }
                                } else {
                                
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_71);
    
                                }
                                
    dbLog.table().createDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_203);
    
                            }
                            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    
            }
            
    
        } else if(("CLEAR").equals(tableAction)) {
        
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
               }
             
    dbLog.table().clearTry(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_210);
    dbLog.table().clearDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_50);
    
        }else if(("TRUNCATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
               }
             
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_56);
    
               }
             
    dbLog.table().truncateTry(dbLog.varForTableName("tableName", dbmsId));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_210);
    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_224);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    }
    dbLog.table().truncateDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
        } else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    dbLog.table().truncateReuseStorageTry(dbLog.varForTableName("tableName", dbmsId));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_210);
    dbLog.table().truncateReuseStorageDone(dbLog.varForTableName("tableName", dbmsId));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
        }
    }
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
    talendDynCol = getDynamicColumn();
    
	String insertColNameStr = insertColName.toString();
	String updateSetStmtStr = updateSetStmt.toString();
	String updateWhereStmtStr = updateWhereStmt.toString();
	String deleteWhereStmtStr = deleteWhereStmt.toString();
	
	if(("INSERT").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(convertToLowercase);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
			if(!("".equals(insertColNameStr))) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(insertColNameStr);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    			} else {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
			}
		}
		
		boolean usingStatsLogs = cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB");
		if(!usingStatsLogs) {
    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
    } else {
    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    
    }
	} else if (("UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(convertToLowercase);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
			if(!("".equals(updateSetStmtStr))) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(updateSetStmtStr);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_270);
    			} else {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_270);
    
			}
		}
	    
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    
	} else if (("INSERT_OR_UPDATE").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(convertToLowercase);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
			if(!("".equals(insertColNameStr))) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(insertColNameStr);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    			} else {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
			}
			if(!("".equals(updateSetStmtStr))) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(updateSetStmtStr);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_270);
    			} else {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_270);
    
			}
		}
	    
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    
	} else if (("UPDATE_OR_INSERT").equals(dataAction)) {
		List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
		if(conns_dynamic!=null && conns_dynamic.size()>0){
			IConnection conn = conns_dynamic.get(0);

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(convertToLowercase);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
			if(!("".equals(insertColNameStr))) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(insertColNameStr);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    			} else {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
			}
			if(!("".equals(updateSetStmtStr))) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(updateSetStmtStr);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_270);
    			} else {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(updateWhereStmtStr);
    stringBuffer.append(TEXT_270);
    
			}
		}
	    
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    
	} else if (("DELETE").equals(dataAction)) {
	    
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(deleteWhereStmtStr);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    
	}
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_290);
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    
		}

    
    }
}
		
    stringBuffer.append(TEXT_308);
    
	} //end isDynamic

	boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	boolean createTable = "CREATE".equals(tableAction) || "DROP_CREATE".equals(tableAction) || "CREATE_IF_NOT_EXISTS".equals(tableAction) || "DROP_IF_EXISTS_AND_CREATE".equals(tableAction);

	if (isParallelize) { // bug0014422
		String tAsyncIn_cid = "";
		if(conns!=null && conns.size() > 0) {
			tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
		}
		if(!"true".equals(useExistingConn)) {
	    	if(!("").equals(commitEvery)&&!("0").equals(commitEvery)) {

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_311);
    
	    	}
    	}
		if (useBatch) {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_311);
    
    	}
	} // end bug0014422

    if(incomingConnName != null && columnList != null) {
        
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
        if(("INSERT").equals(dataAction)) {
            int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                    }
					if (typeToGenerate.equals("Geometry")) {
                        counter++;
                        if((createGeometryColumns || createSpatialIndex) && useSpatialOptions && !isParallelize && createTable) {
                            
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getColumn().getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    dbLog.logIgnoredException(dbLog.var("SRIDError"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    
                        }
                    }
                    counter++;
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(getDynamicColumn());
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
						if(isEnableDebug) {
						
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
						}
				if("Dynamic".equals(typeToGenerate)) {
				
    stringBuffer.append(TEXT_349);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_350);
    
				}
			}
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
            }
            
    stringBuffer.append(TEXT_354);
    if (useBatch) {
    		
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_358);
    
    		  dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
    		  
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
    		}else {
    		
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    if(showSavePoint){
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    }
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_368);
    if(showSavePoint){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    }
    stringBuffer.append(TEXT_372);
    if(showSavePoint){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_377);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_379);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                        }
                        
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
                    } else {
                        
    dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_385);
    
                    }
                }
                
    stringBuffer.append(TEXT_386);
    
            } // end whether use batch
            
    
        } else if(("UPDATE").equals(dataAction)) {
            int counterCol = 1;
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                    }
					if (typeToGenerate.equals("Geometry"))
                        counterCol++;
                    counterCol++;
                }
            }
			if(isDynamic) {
			Column dynamicColumn = getColumn(talendDynCol);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
                if(isEnableDebug) {
                
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
                }
                
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_350);
    
				}
			}

            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) {
					if(isDynamic){
					
    stringBuffer.append(TEXT_391);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_392);
    
					}else{
					
    stringBuffer.append(TEXT_391);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    stringBuffer.append(TEXT_392);
    
					}
					if(isEnableDebug) {
						if(isDynamic){
						
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_394);
    
						}else{
						
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_394);
    
						}
					}
                    	counterCol++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    stringBuffer.append(TEXT_2);
    
                    if(isEnableDebug) {
                        if(isDynamic){
			    
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_396);
    
			    }else{
			    
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_396);
    
			    }
                    }
					if (typeToGenerate.equals("Geometry"))
    	                counterCol++;
                    counterCol++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
            }
            
    if (useBatch) {
    		
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_358);
    
    		  dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
    		  
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
    		}else {
    		
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    if(showSavePoint){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    }
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_368);
    if(showSavePoint){
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_372);
    if(showSavePoint){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_377);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_379);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                        }
                        
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
                    } else {
                        
    dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_385);
    
                    }
                }
                
    stringBuffer.append(TEXT_386);
    
            } // end whether use batch
        } else if (("INSERT_OR_UPDATE").equals(dataAction)) {
            int columnIndex = 1;
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_402);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                    	columnIndex++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
					if (typeToGenerate.equals("Geometry"))
                       columnIndex++;
                    columnIndex++;
                }
            }
            
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    
                int counterCol = 1;
                for(Column column : colStruct) {
                    if(column.isUpdatable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                        }
                        counterCol++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(getDynamicColumn());
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
						if(isEnableDebug) {
						
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
						}
					
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_414);
    
					}
				}
                for(Column column : colStruct) {
                    if(column.isUpdateKey()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
	                    //#############for feature:2880
					if(whereSupportNull && column.getColumn().isNullable()) {
				if(isDynamic){
				
    stringBuffer.append(TEXT_392);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_368);
    
				}else{
				
    stringBuffer.append(TEXT_392);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_368);
    
				}
		                     if(isEnableDebug) {
					if(isDynamic){
							
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_416);
    
							}else{
							
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_416);
    
							}

	                    	}
	                    	counterCol++;
	                       }
	                     //#############
	                    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                        if(isEnableDebug) {
                           if(isDynamic){
				   		
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_417);
    
				    	}else{
				    	
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_417);
    
				    	}
                        }
                        counterCol++;
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
                }
                
    stringBuffer.append(TEXT_419);
    if(showSavePoint){
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    }
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_392);
    if(showSavePoint){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_428);
    if(showSavePoint){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_430);
    
                    } else {
                    	
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_379);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_432);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                            }
                            
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
                        } else {
                            
    dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_434);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_435);
    
                int counterInsert = 1;
                for(Column columnInsert : colStruct) {
                    if(columnInsert.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                        }
						if (typeToGenerate.equals("Geometry"))
	                        counterInsert++;
                        counterInsert++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(getDynamicColumn());
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
					if(isEnableDebug) {
					
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterInsert);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    
					}
					
    stringBuffer.append(TEXT_438);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_414);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
                }
                
    stringBuffer.append(TEXT_419);
    if(showSavePoint){
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    }
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_392);
    if(showSavePoint){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_428);
    if(showSavePoint){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_430);
    
                    } else {
                    	
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_379);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_432);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                            }
                            
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
                        } else {
                            
    dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_434);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_442);
    
        } else if (("UPDATE_OR_INSERT").equals(dataAction)) {
            
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    
            int counterColUpdate = 1;
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                    }
					if (typeToGenerate.equals("Geometry"))
                        counterColUpdate++;
                    counterColUpdate++;
                }
            }
			if(isDynamic) {
				Column dynamicColumn = getColumn(getDynamicColumn());
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
				if("Dynamic".equals(typeToGenerate)) {
					if(isEnableDebug) {
					
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterColUpdate);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    
					}
					
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_350);
    
				}
			}

            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    //#############for feature:2880 and 6980
				if(whereSupportNull && columnUpdate.getColumn().isNullable()) {
					if(isDynamic){
					
    stringBuffer.append(TEXT_446);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_392);
    
					}else{
					
    stringBuffer.append(TEXT_446);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    stringBuffer.append(TEXT_392);
    
					}
					if(isEnableDebug) {
						if(isDynamic){
						
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_394);
    
						}else{
						
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_394);
    
						}
					}
							if (typeToGenerate.equals("Geometry"))
								counterColUpdate++;
                    	counterColUpdate++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                    if(isEnableDebug) {
					if(isDynamic){
					
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_448);
    
					}else{
					
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_448);
    
					}
                    }
					if (typeToGenerate.equals("Geometry"))
						counterColUpdate++;
                    counterColUpdate++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
            }
            
    stringBuffer.append(TEXT_449);
    if(showSavePoint){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    }
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    if(showSavePoint){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    
            	if(isEnableDebug) {
            	
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    
        		}
                int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                        }
						if (typeToGenerate.equals("Geometry"))
                    	    counter++;
                        counter++;
                    }
                }
				if(isDynamic) {
					Column dynamicColumn = getColumn(talendDynCol);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
					if("Dynamic".equals(typeToGenerate)) {
						if(isEnableDebug) {
						
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    
	    					}
						
    stringBuffer.append(TEXT_438);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_414);
    
					}
				}
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
                }
                
    stringBuffer.append(TEXT_392);
    if(showSavePoint){
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    }
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_392);
    if(showSavePoint){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_462);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_463);
    if(showSavePoint){
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_430);
    
                    } else {
                    	
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_379);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_432);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                            }
                            
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
                        } else {
                            
    dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_434);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_464);
    

        } else if (("DELETE").equals(dataAction)) {
            int keyCounter = 1;
            for(Column column : colStruct) {
                if(column.isDeleteKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_392);
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_402);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
	                    if(isEnableDebug) {
	                        
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_466);
    
	                    	}
						if (typeToGenerate.equals("Geometry"))
                    	    keyCounter++;
                    	 keyCounter++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_311);
    
                    }
					if (typeToGenerate.equals("Geometry"))
                        keyCounter++;
                    keyCounter++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
            }
            
    if (useBatch) {
    		
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_358);
    
    		  dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
    		  
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    
    		}else {
    		
    stringBuffer.append(TEXT_470);
    if(showSavePoint){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    }
    if(isEnableDebug){dbLog.data().sqlDebugPrint("globalMap.get(\""+cid+"_QUERY\")");}
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    dbLog.data().deleting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_368);
    if(showSavePoint){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_372);
    if(showSavePoint){
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_377);
    
                } else {
                	
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_379);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                        }
                        
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
                    } else {
                        
    dbLog.logPrintedException("e.getMessage()");
    stringBuffer.append(TEXT_385);
    
                    }
                }
                
    stringBuffer.append(TEXT_386);
    
            } // end whether use batch
            
    
        }



        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_378);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_379);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_432);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_386);
    
        }

		//////////batch execute by batch size///////
    	if (useBatch) {
    		
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_488);
    if (("INSERT").equals(dataAction)) {
				    	
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
				    	}else if (("UPDATE").equals(dataAction)) {
				    	
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
				    	}else if (("DELETE").equals(dataAction)) {
				    	
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
				    	}
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    if(("true").equals(dieOnError)) {
				    	
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
				    	}else {
				    	
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    if (("INSERT").equals(dataAction)) {
				    	
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
				    	}else if (("UPDATE").equals(dataAction)) {
				    	
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
				    	}else if (("DELETE").equals(dataAction)) {
				    	
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
				    	}
				    	dbLog.logPrintedException("errormessage_"+cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
				    	}
    stringBuffer.append(TEXT_521);
    
    	}
        ////////////commit every////////////
		if(!"true".equals(useExistingConn)) {
    		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
    		    
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    
        if (useBatch) {
        
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_529);
    if (("INSERT").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    
            	    	}else if (("UPDATE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    
            	    	}else if (("DELETE").equals(dataAction)) {
            	    	
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    
            	    	}
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    if(("true").equals(dieOnError)) {
			    	
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    
			    	}else {
			    	
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    if (("INSERT").equals(dataAction)) {
			    	
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    
			    	}else if (("UPDATE").equals(dataAction)) {
			    	
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    
			    	}else if (("DELETE").equals(dataAction)) {
			    	
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    
			    	}
			    	dbLog.logPrintedException("errormessage_"+cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    
			    	}
    stringBuffer.append(TEXT_557);
    
        }
        
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    
    		}
    	}
    }

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
