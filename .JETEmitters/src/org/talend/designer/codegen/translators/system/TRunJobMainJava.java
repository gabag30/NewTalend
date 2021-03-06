package org.talend.designer.codegen.translators.system;

import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.BlockCode;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TRunJobMainJava
{
  protected static String nl;
  public static synchronized TRunJobMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMainJava result = new TRunJobMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.util.List<String> paraList_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\tif(childJob_commandLine_Mapper_";
  protected final String TEXT_8 = ".get(";
  protected final String TEXT_9 = ")==null){" + NL + "\t\t\tthrow new RuntimeException(\"The child job named \"+";
  protected final String TEXT_10 = "+\" is not in the job list.\");" + NL + "\t\t}" + NL + "\t\tparaList_";
  protected final String TEXT_11 = ".addAll(childJob_commandLine_Mapper_";
  protected final String TEXT_12 = "));" + NL + "\t";
  protected final String TEXT_13 = NL + "\t        \t\t\tparaList_";
  protected final String TEXT_14 = ".add(";
  protected final String TEXT_15 = ");" + NL + "\t      \t\t\t";
  protected final String TEXT_16 = ".add(\"";
  protected final String TEXT_17 = "\");" + NL + "\t      \t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t" + NL + "\t\t\tString osName_";
  protected final String TEXT_19 = " = System.getProperty(\"os.name\");" + NL + "\t\t\tif (osName_";
  protected final String TEXT_20 = " != null && osName_";
  protected final String TEXT_21 = ".toLowerCase().startsWith(\"win\")){" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\tparaList_";
  protected final String TEXT_23 = "\");" + NL + "\t\t\t\t\t\tString m2 = System.getProperty(\"talend.component.manager.m2.repository\");" + NL + "\t\t\t\t\t\tif (m2 != null){" + NL + "\t\t\t\t\t\t\tparaList_";
  protected final String TEXT_24 = ".add(\"-Dtalend.component.manager.m2.repository=\" + m2);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(enableLogStash){" + NL + "\t\t\t\t\t\t\tSystem.getProperties().stringPropertyNames().stream()" + NL + "\t\t\t\t\t\t\t\t.filter(it -> it.startsWith(\"audit.\"))" + NL + "\t\t\t\t\t\t\t\t.forEach(key -> paraList_";
  protected final String TEXT_25 = ".add(\"-D\" + key + \"=\" + System.getProperty(key)));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tSystem.getProperties().stringPropertyNames().stream()" + NL + "\t\t\t\t\t\t\t.filter(it -> it.startsWith(\"runtime.lineage.\") || \"classpath.extended\".equals(it))" + NL + "\t\t\t\t\t\t\t.forEach(key -> paraList_";
  protected final String TEXT_26 = ".add(\"-D\" + key + \"=\" + System.getProperty(key)));" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t      \t\t\t\t\tString classpath_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = ";" + NL + "\t\t      \t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t      \t\t\t\t\tif(audit_jar_path_";
  protected final String TEXT_31 = "!=null && !audit_jar_path_";
  protected final String TEXT_32 = ".isEmpty()) {" + NL + "\t\t      \t\t\t\t\t\tclasspath_";
  protected final String TEXT_33 = " += audit_jar_path_";
  protected final String TEXT_34 = ";" + NL + "\t\t      \t\t\t\t\t}" + NL + "\t\t      \t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_36 = ".addArgumentsTo(paraList_";
  protected final String TEXT_37 = ", dealChildJobLibrary_";
  protected final String TEXT_38 = ".replaceJarPathsFromCrcMap(classpath_";
  protected final String TEXT_39 = "));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t      \t\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_43 = NL + "              \t\t\t\t\tString classpath_";
  protected final String TEXT_44 = " = \"";
  protected final String TEXT_45 = "\";" + NL + "              \t\t\t\t\t";
  protected final String TEXT_46 = NL + "              \t\t\t\t\tif(audit_jar_path_";
  protected final String TEXT_47 = NL + "\t        \t\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_48 = ", \"";
  protected final String TEXT_49 = "\");" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t} else {" + NL + "\t      \t\t";
  protected final String TEXT_51 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t      \t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t        \t\t\t\tjvm_argument_helper_";
  protected final String TEXT_53 = ".replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t\t     \t \t\t\t";
  protected final String TEXT_54 = NL + "\t      \t\t\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_55 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\tjvm_argument_helper_";
  protected final String TEXT_57 = ".reset();" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t" + NL + "\t  \t";
  protected final String TEXT_59 = NL + "\t\t\tif(!\"\".equals(log4jLevel)){" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_60 = ".add(\"--log4jLevel=\"+log4jLevel);" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tif(enableLogStash){" + NL + "\t\t\tparaList_";
  protected final String TEXT_62 = ".add(\"--audit.enabled=\"+enableLogStash);" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t//for feature:10589" + NL + "\t";
  protected final String TEXT_64 = NL + "\t\tparaList_";
  protected final String TEXT_65 = ".add(\"--stat_port=\" + null);" + NL + "\t";
  protected final String TEXT_66 = ".add(\"--stat_port=\" + portStats);" + NL + "\t";
  protected final String TEXT_67 = NL + NL + "\tif(resuming_logs_dir_path != null){" + NL + "\t\tparaList_";
  protected final String TEXT_68 = ".add(\"--resuming_logs_dir_path=\" + resuming_logs_dir_path);" + NL + "\t}" + NL + "\tString childResumePath_";
  protected final String TEXT_69 = " = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);" + NL + "\tString tRunJobName_";
  protected final String TEXT_70 = " = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);" + NL + "\tif(\"";
  protected final String TEXT_71 = "\".equals(tRunJobName_";
  protected final String TEXT_72 = ") && childResumePath_";
  protected final String TEXT_73 = " != null){" + NL + "\t\tparaList_";
  protected final String TEXT_74 = ".add(\"--resuming_checkpoint_path=\" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));" + NL + "\t}" + NL + "\tparaList_";
  protected final String TEXT_75 = ".add(\"--parent_part_launcher=JOB:\" + jobName + \"/NODE:";
  protected final String TEXT_76 = "\");" + NL + "\t" + NL + "\tjava.util.Map<String, Object> parentContextMap_";
  protected final String TEXT_77 = " = new java.util.HashMap<String, Object>();" + NL + "" + NL + "\t";
  protected final String TEXT_78 = " " + NL + "\tjava.util.List<String> paraListForLog_";
  protected final String TEXT_79 = " = new java.util.ArrayList<String>();" + NL + "\tparaListForLog_";
  protected final String TEXT_80 = ".addAll(paraList_";
  protected final String TEXT_81 = ");" + NL + "\tList<String> parametersToEncrypt_";
  protected final String TEXT_82 = NL + "\t\t\tparametersToEncrypt_";
  protected final String TEXT_83 = " .add(\"";
  protected final String TEXT_84 = "\");" + NL + "\t\t\t";
  protected final String TEXT_85 = NL + "\t\t";
  protected final String TEXT_86 = ".synchronizeContext();";
  protected final String TEXT_87 = NL + "            class ContextProcessor_";
  protected final String TEXT_88 = " {" + NL + "                    private void transmitContext_0() {";
  protected final String TEXT_89 = NL + "                        }" + NL + "" + NL + "                        private void transmitContext_";
  protected final String TEXT_90 = "() {";
  protected final String TEXT_91 = NL + "                    parentContextMap_";
  protected final String TEXT_92 = ".put(\"";
  protected final String TEXT_93 = "\", ";
  protected final String TEXT_94 = ");" + NL + "                    paraList_";
  protected final String TEXT_95 = ".add(\"--context_type \" + \"";
  protected final String TEXT_96 = "\" + \"=\" + \"";
  protected final String TEXT_97 = "\");";
  protected final String TEXT_98 = NL + "                        }" + NL + "                    public void transmitAllContext() {";
  protected final String TEXT_99 = NL + "                        transmitContext_";
  protected final String TEXT_100 = "();";
  protected final String TEXT_101 = NL + "                    }" + NL + "            }" + NL + "            new ContextProcessor_";
  protected final String TEXT_102 = "().transmitAllContext();";
  protected final String TEXT_103 = NL + "\t\tjava.util.Enumeration<?> propertyNames_";
  protected final String TEXT_104 = ".propertyNames();" + NL + "\t\twhile (propertyNames_";
  protected final String TEXT_105 = ".hasMoreElements()) {" + NL + "\t\t\tString key_";
  protected final String TEXT_106 = " = (String) propertyNames_";
  protected final String TEXT_107 = ".nextElement();" + NL + "\t\t\tObject value_";
  protected final String TEXT_108 = " = (Object) ";
  protected final String TEXT_109 = ".get(key_";
  protected final String TEXT_110 = ");" + NL + "\t\t\tif(value_";
  protected final String TEXT_111 = "!=null) {  " + NL + "\t\t\t\tparaList_";
  protected final String TEXT_112 = ".add(\"--context_param \" + key_";
  protected final String TEXT_113 = " + \"=\" + value_";
  protected final String TEXT_114 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_115 = " + \"=\" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\tif(parametersToEncrypt_";
  protected final String TEXT_117 = " .contains(key_";
  protected final String TEXT_118 = ") && value_";
  protected final String TEXT_119 = " != null) {" + NL + "\t\t\t\tparaListForLog_";
  protected final String TEXT_120 = " + \"=\" + routines.system.PasswordEncryptUtil.encryptPassword(String.valueOf(value_";
  protected final String TEXT_121 = ")));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tparaListForLog_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_123 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_124 = NL + NL + "\tObject obj_";
  protected final String TEXT_125 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_126 = NL + "\t\tobj_";
  protected final String TEXT_127 = ";" + NL + "\t\tif(obj_";
  protected final String TEXT_128 = "!=null) {" + NL + "\t\t\tif (obj_";
  protected final String TEXT_129 = ".getClass().getName().equals(\"java.util.Date\")) {" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_130 = ".add(\"--context_param ";
  protected final String TEXT_131 = "=\" + ((java.util.Date) obj_";
  protected final String TEXT_132 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t\tparaList_";
  protected final String TEXT_133 = "=\" + RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_134 = "));" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tparaList_";
  protected final String TEXT_135 = "=\" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\tif(parametersToEncrypt_";
  protected final String TEXT_137 = " .contains(\"";
  protected final String TEXT_138 = "\") && obj_";
  protected final String TEXT_139 = " != null) {" + NL + "\t\t\tparaListForLog_";
  protected final String TEXT_140 = "=\" + routines.system.PasswordEncryptUtil.encryptPassword(String.valueOf(RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_141 = "))));" + NL + "\t\t} else {" + NL + "\t\t\tparaListForLog_";
  protected final String TEXT_142 = "));" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t\tparentContextMap_";
  protected final String TEXT_144 = "\", obj_";
  protected final String TEXT_145 = ");" + NL + "\t";
  protected final String TEXT_146 = NL + "\t";
  protected final String TEXT_147 = NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_148 = " in ";
  protected final String TEXT_149 = " call ";
  protected final String TEXT_150 = "\"+";
  protected final String TEXT_151 = "+\"";
  protected final String TEXT_152 = " with:\\n\\n\" + paraListForLog_";
  protected final String TEXT_153 = " + \"\\n\");" + NL + "\t";
  protected final String TEXT_154 = " childJob_";
  protected final String TEXT_155 = " = new ";
  protected final String TEXT_156 = NL + "        if (childJob_";
  protected final String TEXT_157 = " instanceof routines.system.api.TalendESBJob) {" + NL + "            ((routines.system.api.TalendESBJob)childJob_";
  protected final String TEXT_158 = ").setEndpointRegistry(registry);" + NL + "        }" + NL;
  protected final String TEXT_159 = NL + "\t    // pass DataSources" + NL + "\t    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_";
  protected final String TEXT_160 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap" + NL + "\t            .get(KEY_DB_DATASOURCES);" + NL + "\t    if (null != talendDataSources_";
  protected final String TEXT_161 = ") {" + NL + "\t        java.util.Map<String, javax.sql.DataSource> dataSources_";
  protected final String TEXT_162 = " = new java.util.HashMap<String, javax.sql.DataSource>();" + NL + "\t        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_";
  protected final String TEXT_163 = " : talendDataSources_";
  protected final String TEXT_164 = NL + "\t\t\t        .entrySet()) {" + NL + "\t            dataSources_";
  protected final String TEXT_165 = ".put(talendDataSourceEntry_";
  protected final String TEXT_166 = ".getKey()," + NL + "\t                    talendDataSourceEntry_";
  protected final String TEXT_167 = ".getValue().getRawDataSource());" + NL + "\t        }" + NL + "\t        childJob_";
  protected final String TEXT_168 = ".setDataSources(dataSources_";
  protected final String TEXT_169 = ");" + NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_170 = "  " + NL + "\t\t\tchildJob_";
  protected final String TEXT_171 = ".parentContextMap = parentContextMap_";
  protected final String TEXT_172 = ";" + NL + "\t\t";
  protected final String TEXT_173 = "  " + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_175 = " - The child job '";
  protected final String TEXT_176 = "' starts on the version '";
  protected final String TEXT_177 = "' with the context '";
  protected final String TEXT_178 = "'.\");" + NL + "\t\t";
  protected final String TEXT_179 = NL + "\t\tString[][] childReturn_";
  protected final String TEXT_180 = " = childJob_";
  protected final String TEXT_181 = ".runJob((String[]) paraList_";
  protected final String TEXT_182 = ".toArray(new String[paraList_";
  protected final String TEXT_183 = ".size()]));" + NL + "\t\t";
  protected final String TEXT_184 = "' is done.\");" + NL + "\t\t";
  protected final String TEXT_185 = NL + "            if(childJob_";
  protected final String TEXT_186 = ".getErrorCode() == null){" + NL + "                globalMap.put(\"";
  protected final String TEXT_187 = "_CHILD_RETURN_CODE\", childJob_";
  protected final String TEXT_188 = ".getStatus() != null && (\"failure\").equals(childJob_";
  protected final String TEXT_189 = ".getStatus()) ? 1 : 0);" + NL + "            }else{" + NL + "                globalMap.put(\"";
  protected final String TEXT_190 = ".getErrorCode());" + NL + "            }" + NL + "            if (childJob_";
  protected final String TEXT_191 = ".getExceptionStackTrace() != null) {" + NL + "                globalMap.put(\"";
  protected final String TEXT_192 = "_CHILD_EXCEPTION_STACKTRACE\", childJob_";
  protected final String TEXT_193 = ".getExceptionStackTrace());" + NL + "            }";
  protected final String TEXT_194 = NL + "                    ((java.util.Map)threadLocal.get()).put(\"errorCode\", childJob_";
  protected final String TEXT_195 = ".getErrorCode());";
  protected final String TEXT_196 = NL + "                    errorCode = childJob_";
  protected final String TEXT_197 = ".getErrorCode();";
  protected final String TEXT_198 = NL + "                if (childJob_";
  protected final String TEXT_199 = ".getErrorCode() != null || (\"failure\").equals(childJob_";
  protected final String TEXT_200 = ".getStatus())) {" + NL + "                    java.lang.Exception ce_";
  protected final String TEXT_201 = ".getException();" + NL + "                    throw new RuntimeException(\"Child job running failed.\\n\" + ((ce_";
  protected final String TEXT_202 = "!=null) ? (ce_";
  protected final String TEXT_203 = ".getClass().getName() + \": \" + ce_";
  protected final String TEXT_204 = ".getMessage()) : \"\"));" + NL + "                }";
  protected final String TEXT_205 = NL + "\t\t\tfor (String[] item_";
  protected final String TEXT_206 = " : childReturn_";
  protected final String TEXT_207 = ") { " + NL + "\t\t\t\tif(childJob_";
  protected final String TEXT_208 = ".hastBufferOutputComponent() || ";
  protected final String TEXT_209 = "){" + NL + "\t\t\t    \t";
  protected final String TEXT_210 = "\t\t" + NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_211 = " < item_";
  protected final String TEXT_212 = ".length){\t\t\t\t" + NL + "\t\t\t           \t\t";
  protected final String TEXT_213 = NL + "\t\t\t\t           \t\t";
  protected final String TEXT_214 = " = item_";
  protected final String TEXT_215 = "[";
  protected final String TEXT_216 = "];" + NL + "\t\t\t           \t\t";
  protected final String TEXT_217 = " = ParserUtils.parseTo_Date(item_";
  protected final String TEXT_218 = "], ";
  protected final String TEXT_219 = ");" + NL + "\t\t\t           \t\t";
  protected final String TEXT_220 = "\t\t\t\t\t\t\t" + NL + "\t\t\t           \t\t\t";
  protected final String TEXT_221 = "].getBytes();" + NL + "\t\t\t           \t\t";
  protected final String TEXT_222 = NL + "\t\t\t           \t\t\t";
  protected final String TEXT_223 = " = ParserUtils.parseTo_";
  protected final String TEXT_224 = "(item_";
  protected final String TEXT_225 = "], \",\");" + NL + "\t\t\t           \t\t";
  protected final String TEXT_226 = "]);" + NL + "\t\t\t           \t\t";
  protected final String TEXT_227 = NL + "\t\t           \t\t}else{" + NL + "\t\t\t           \t\t";
  protected final String TEXT_228 = ";" + NL + "\t\t           \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\t}" + NL + "\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\tclass ConsoleHelper_";
  protected final String TEXT_234 = " {" + NL + "\t\t\t\t\tprivate Thread getNormalThread(Process process) {" + NL + "\t\t\t\t\t\treturn new Thread() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\tnew java.io.InputStreamReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tprocess.getInputStream()));" + NL + "\t\t\t\t\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\twhile ((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tSystem.out.println(line);" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t} catch (java.io.IOException ioe) {" + NL + "\t\t\t\t\t\t            ";
  protected final String TEXT_235 = NL + "\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_236 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t\t\t            ";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t};" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprivate Thread getErrorThread(Process process, StringBuffer sb) {" + NL + "\t\t\t\t\t\treturn new Thread() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\tnew java.io.InputStreamReader(" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tprocess.getErrorStream()));" + NL + "\t\t\t\t\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\twhile ((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tsb.append(line)" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t.append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t} catch (java.io.IOException ioe) {" + NL + "\t\t\t\t\t\t            ";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t};" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tConsoleHelper_";
  protected final String TEXT_239 = " consoleHelper_";
  protected final String TEXT_240 = " = new ConsoleHelper_";
  protected final String TEXT_241 = "();" + NL + "" + NL + "\t\tRuntime runtime_";
  protected final String TEXT_242 = " = Runtime.getRuntime();" + NL + "\t\tProcess ps_";
  protected final String TEXT_243 = " = null;" + NL + "" + NL + "\t\t//0 indicates normal termination" + NL + "        int result_";
  protected final String TEXT_244 = ";" + NL + "        StringBuffer errorMsg_";
  protected final String TEXT_245 = " = new StringBuffer();" + NL + "        try {" + NL + "            ps_";
  protected final String TEXT_246 = " = runtime_";
  protected final String TEXT_247 = ".exec((String[])paraList_";
  protected final String TEXT_248 = ".size()]));" + NL + "" + NL + "            Thread normal_";
  protected final String TEXT_249 = " = consoleHelper_";
  protected final String TEXT_250 = ".getNormalThread(ps_";
  protected final String TEXT_251 = ");";
  protected final String TEXT_252 = NL + "                log.info(\"";
  protected final String TEXT_253 = "'.\");";
  protected final String TEXT_254 = NL + "            normal_";
  protected final String TEXT_255 = ".start();";
  protected final String TEXT_256 = "' is done.\");";
  protected final String TEXT_257 = NL + NL + "            Thread error_";
  protected final String TEXT_258 = ".getErrorThread(ps_";
  protected final String TEXT_259 = ", errorMsg_";
  protected final String TEXT_260 = ");" + NL + "            error_";
  protected final String TEXT_261 = ".start();" + NL + "" + NL + "            result_";
  protected final String TEXT_262 = " = ps_";
  protected final String TEXT_263 = ".waitFor();" + NL + "            normal_";
  protected final String TEXT_264 = ".join();" + NL + "            error_";
  protected final String TEXT_265 = ".join();" + NL + "        } catch (ThreadDeath tde) {";
  protected final String TEXT_266 = NL + "            \tlog.error(\"";
  protected final String TEXT_267 = " - thread was terminated.\");";
  protected final String TEXT_268 = NL + "            ps_";
  protected final String TEXT_269 = ".destroy();" + NL + "            throw tde;" + NL + "        }" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_270 = "_CHILD_RETURN_CODE\",result_";
  protected final String TEXT_271 = ");" + NL + "\t\tif(result_";
  protected final String TEXT_272 = " != 0){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_273 = "_CHILD_EXCEPTION_STACKTRACE\",errorMsg_";
  protected final String TEXT_274 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_275 = "  " + NL + "\t    \t\tthrow new RuntimeException(\"Child job returns \" + result_";
  protected final String TEXT_276 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_277 = NL + "\t\t\t\t";
  protected final String TEXT_278 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_279 = " - Child job returns \" + result_";
  protected final String TEXT_280 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t\tSystem.err.println(\"Child job returns \" + result_";
  protected final String TEXT_282 = NL + "  \t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_283 = NL + "  \t\t\t\tSystem.err.println(\"when tRunJob runs in an independent process, it can't extract datas from tBufferOutput of child job.\"); " + NL + "\t\t\t";
  protected final String TEXT_284 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
        columns = metadata.getListColumns();
    }
}
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
//if tRunJob is the first node, it can get the return values of the child job.
//if tRunJob is middle node of the FLOW link, it will be data_auto_propagate=true 
List< ? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
boolean useIndependentProcess = "true".equals(ElementParameterParser.getValue(node, "__USE_INDEPENDENT_PROCESS__"));
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_CHILD_ERROR__"));  
boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();  
boolean transmitWholeContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_WHOLE_CONTEXT__"));  
boolean printParameter = ("true").equals(ElementParameterParser.getValue(node, "__PRINT_PARAMETER__")); 

boolean originalContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_ORIGINAL_CONTEXT__")); 

IProcess currentProcess = node.getProcess();
List<Map<String, String>> contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
String version = ElementParameterParser.getValue(node,"__PROCESS_TYPE_VERSION__");
String[] codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\""};
String[] commandLineWindows = new String[] {"<command>"};
String[] commandLineUnix = new String[] {"<command>"};
String[] commandLine = new String[] {"<command>"};
String childJob = ElementParameterParser.getValue(node,"__PROCESS__");

boolean isPropagateChildResult = ("true").equals(ElementParameterParser.getValue(node, "__PROPAGATE_CHILD_RESULT__"));

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
String dynamicJobName = ElementParameterParser.getValue(node,"__CONTEXT_JOB__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean propagateData = false;
Set<String> inputCols = new HashSet<String>();
String inputConnName = null;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
	//For TDI-28558

	List<IMetadataColumn> inputMetadataColumn = new java.util.ArrayList<IMetadataColumn>();
	List<IMetadataColumn> outputMetadataColumn = new java.util.ArrayList<IMetadataColumn>();
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				inputConnName = incomingConn.getName();
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputMetadataColumn.add(inputCol);
					inputCols.add(inputCol.getLabel());
				}
				break;
			}
		}
	}
	if(node.getOutgoingConnections()!=null) {
		for (IConnection outputConn : node.getOutgoingConnections()) {
			if (outputConn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
				IMetadataTable outputMetadataTable = outputConn.getMetadataTable();
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					outputMetadataColumn.add(outputCol);
				}
			}
		}
	}
	if(inputMetadataColumn!=null && outputMetadataColumn!=null){
		if(inputMetadataColumn.size() == outputMetadataColumn.size()){
			int size = inputMetadataColumn.size();
			for(int i = 0;i< size; i++){
				if(!inputMetadataColumn.get(i).getLabel().equals(outputMetadataColumn.get(i).getLabel()) ||
				   !inputMetadataColumn.get(i).getTalendType().equals(outputMetadataColumn.get(i).getTalendType())){
					propagateData = false;
					break;
				}else{
					propagateData = true;
				}
			}
		}
	}
	if(useDynamicJob || useIndependentProcess || !isPropagateChildResult){
		if (propagateData) {
			for (IConnection conn : node.getOutgoingConnections()) {
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
					IMetadataTable outputMetadataTable = conn.getMetadataTable();
					if (outputMetadataTable!=null) {
						for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
							if (inputCols.contains(outputCol.getLabel())) {
							
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_6);
    
							}
						}
					}
					break;
				}
			}
		}
	}
	
	if(useDynamicJob){
		useIndependentProcess = true;
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_12);
    
	}else{
		boolean use_custom_jvm_setting = "true".equals(ElementParameterParser.getValue(node, "__USE_CUSTOM_JVM_SETTING__"));
		try {
			if(useIndependentProcess){
		    	commandLineWindows = ProcessorUtilities.getCommandLine("win32", false, true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, use_custom_jvm_setting, codeOptions);
		    	// remove the 2 fist lines
		    	if (commandLineWindows.length > 0 && ProcessorUtilities.isExportConfig()){
		    		int tmpSize = commandLineWindows.length - 2;
		    		String[] tmp = new String[tmpSize];
		    		System.arraycopy(commandLineWindows, 2, tmp, 0, tmpSize);
		    		commandLineWindows = tmp;
	    		}
		    	commandLineUnix = ProcessorUtilities.getCommandLine("linux", false, true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, use_custom_jvm_setting, codeOptions);
	    		// remove the 2 first lines
				if (commandLineUnix.length > 0 && ProcessorUtilities.isExportConfig()){
					int tmpSize = commandLineUnix.length - 2;
					String[] tmp = new String[tmpSize];
					System.arraycopy(commandLineUnix, 2, tmp, 0, tmpSize);
					commandLineUnix = tmp;
				}
			}else{
		    	commandLine = ProcessorUtilities.getMainCommand(process,version, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);  
			}
		} catch (ProcessorException e) {
		}


		if (!useIndependentProcess) {
			for (int i = 0; i < commandLine.length; i++) {
				if (i == 0){
					childJob = commandLine[0];
				} else if (i > 0){
					if (commandLine[i].indexOf("\"") >= 0){
	      			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_15);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(commandLine[i] );
    stringBuffer.append(TEXT_17);
    }
	    		}
	  		}
		} else {
	  	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
				boolean isCP = false;
				for (int i = 0; i < commandLineWindows.length; i++) {
					if (i == 0){
					
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(commandLineWindows[i]);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
					} else if (i > 0){
		      			if (commandLineWindows[i].indexOf("\"") >= 0){
							if(commandLineWindows[i].indexOf(".jar")>=0){
		      				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_29);
    if(isCP && (commandLineWindows[i].endsWith(":\"") || commandLineWindows[i].endsWith(";\""))) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_39);
    
							}else{
		      				
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_42);
    
		          			}
		          			
		          			if("\"-cp\"".equals(commandLineWindows[i]) || "\"-classpath\"".equals(commandLineWindows[i])) {
		          				isCP = true;
		          			} else {
		          				isCP = false;
		          			}
		      			}else{
		          			if(commandLineWindows[i].indexOf(".jar")>=0){
              				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_45);
    if(isCP && (commandLineWindows[i].endsWith(":") || commandLineWindows[i].endsWith(";"))) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_39);
    
		          			}else{
              				
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_49);
    
		          			}
		          			
		          			if("-cp".equals(commandLineWindows[i]) || "-classpath".equals(commandLineWindows[i])) {
		          				isCP = true;
		          			} else {
		          				isCP = false;
		          			}
		      			}	
		    		}
		  		}
		  		
    stringBuffer.append(TEXT_50);
    
				for (int i = 0; i < commandLineUnix.length; i++) {
					if (i == 0){
					
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(commandLineUnix[i]);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
					} else if (i > 0){
						String param;
						if (commandLineUnix[i].indexOf("\"") >= 0){
							param = commandLineUnix[i];
						} else {
							param = "\""+commandLineUnix[i]+"\"";
						}
						if (param.contains("$ROOT_PATH")) {
							if(param.indexOf(".jar") >= 0){
		      				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_29);
    if(isCP && (param.endsWith(":\"") || param.endsWith(";\""))) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_51);
    }else{
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_53);
    
		      				}
		      			}else{
							if(param.indexOf(".jar") >= 0){
		      				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_29);
    if(isCP && (param.endsWith(":\"") || param.endsWith(";\""))) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_51);
    }else{
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_42);
    
		      				}
		      			}
		      			
		      			if("\"-cp\"".equals(param) || "\"-classpath\"".equals(param)) {
		      				isCP = true;
		      			} else {
		      				isCP = false;
		      			}
	    			}
		  		}
		  		
    stringBuffer.append(TEXT_55);
    
			if(use_custom_jvm_setting) {
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    
		}
		if(isLog4jEnabled){//For TDI-27659
		
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
		}
		
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
	}
	
    stringBuffer.append(TEXT_63);
    if(useIndependentProcess){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    }else{
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	List<? extends IConnection> iterateConns = node.getIncomingConnections(EConnectionType.ITERATE);
	if(iterateConns != null)  { 
		iterateConnSet.addAll(iterateConns);
	}
	boolean parallelIterate = false;
	for (IConnection iterateConn : iterateConnSet) {
		parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	}
	if(printParameter) {
	
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
		List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
		for (IContextParameter ctxParam :params){
			if("id_Password".equals(ctxParam.getType())) {
			
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ctxParam.getName() );
    stringBuffer.append(TEXT_84);
    
			}
		}
	}
	if(transmitWholeContext){//111111
	
    stringBuffer.append(TEXT_85);
     
		//bug21906
		String localContext = "context";
		if(parallelIterate) {
			localContext = "localContext";
		}
		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_86);
    
		List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
        /*Create local class to avoid 64kB method problem when huge amount of context variables declared*/
        if (!params.isEmpty()) {
            final int defaultInnerMethodLenght = 500;
            int lastMethodNumber = 0;

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
                for (int i = 1; i <= params.size(); i++) {
                    IContextParameter ctxParam = params.get(i-1);
                    String ctxParamName = ctxParam.getName();
                    String ctxParameterType = ctxParam.getType();
                    if (i % defaultInnerMethodLenght == 0) {
                    /* close previous method and declare new */
                        lastMethodNumber++;

    stringBuffer.append(TEXT_89);
    stringBuffer.append(lastMethodNumber);
    stringBuffer.append(TEXT_90);
    
                    } //endIf

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ctxParamName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ctxParam.getType());
    stringBuffer.append(TEXT_97);
    
                } //endFor

    /*close last method*/
    stringBuffer.append(TEXT_98);
    
                    for (int i = 0; i <=lastMethodNumber; i++) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_100);
    
                    }

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
        }

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
			if(printParameter) {
			
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
			}
			
    stringBuffer.append(TEXT_123);
    
	}//111111
	
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
	for (int i=0; i<contextParams.size(); i++) {
		Map<String, String> contextParam = contextParams.get(i);
		String name = contextParam.get("PARAM_NAME_COLUMN");
		String value = contextParam.get("PARAM_VALUE_COLUMN");
		//bug22181
		if(parallelIterate && value!=null && value.contains("context.")) {
			value = value.replace("context.","localContext.");
		}
		
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_135);
     if(printParameter){ 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
     } 
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
	}
	
    stringBuffer.append(TEXT_146);
    if(printParameter){
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_149);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
	if (!useIndependentProcess){//AAAAAAAAAAAA
	
    stringBuffer.append(TEXT_85);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(childJob );
    stringBuffer.append(TEXT_100);
    
            if (ProcessorUtilities.isEsbJob(currentProcess)) {
        
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    
            }
        
    stringBuffer.append(TEXT_159);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    if(originalContext){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_184);
    }
    
		if (childJob != null) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    
            if (dieOnError) {
                if (isRunInMultiThread){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    
                }else {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    
                }

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
            }
        }

		String firstConnName = null; 
		if(outConns != null && outConns.size() > 0) {
			for (IConnection conn : outConns) {
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)){
	      			firstConnName = conn.getName(); //get the first available flow link
	      			break;
	      		}
	    	}
		}
		boolean inConnNull = false;
		if(inConns == null || inConns.size() == 0) {
			inConnNull = true; 
		}
		if(firstConnName != null && (isPropagateChildResult || inConnNull)) {//b
			List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
			blockCodes.add(new BlockCode("C_01"));
			((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
	    	
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(inConnNull);
    stringBuffer.append(TEXT_209);
    
					int columnSize = columns.size();
					for (int i = 0; i < columnSize; i++) {//a
						IMetadataColumn column = columns.get(i);
						String label = column.getLabel();
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			        	
    stringBuffer.append(TEXT_210);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_216);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_219);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_220);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_221);
    }else if(javaType == JavaTypesManager.LIST) {
    stringBuffer.append(TEXT_222);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_223);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_225);
    } else {
    stringBuffer.append(TEXT_222);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_223);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_228);
    
					}//a
					if (inConnNull==false && propagateData) {//d
					
    stringBuffer.append(TEXT_229);
    
						for (IConnection conn : node.getOutgoingConnections()) {
							if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
								IMetadataTable outputMetadataTable = conn.getMetadataTable();
								if (outputMetadataTable!=null) {
									for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
										if (inputCols.contains(outputCol.getLabel())) {
										
    stringBuffer.append(TEXT_230);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_231);
    
										}
									}
								}
								break;
							}
						}
					}//d
					
    stringBuffer.append(TEXT_232);
    
		}//b  
	} else { //AAAAAAAAAAAA

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	// use independent process to run subjob
	
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_253);
    }
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(!useDynamicJob){
    stringBuffer.append(childJob );
    }else{
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    }
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    if (dieOnError) { 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    }else{
    stringBuffer.append(TEXT_277);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    }
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    }
    stringBuffer.append(TEXT_282);
    
		String firstConnName = null; 
		if(outConns != null && outConns.size() > 0) {
			for (IConnection conn : outConns) {
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
					firstConnName = conn.getName(); //get the first available flow link
					break;
				}
			}
		}
		if(firstConnName != null) {//b
	    	if(inConns == null || inConns.size() == 0){//c
			
    stringBuffer.append(TEXT_277);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    }
    stringBuffer.append(TEXT_283);
    
			}//c
		}//b  
	}//AAAAAAAAAAAA
	
    stringBuffer.append(TEXT_284);
    return stringBuffer.toString();
  }
}
