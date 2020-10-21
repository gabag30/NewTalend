// ============================================================================
//
// Copyright (c) 2006-2015, Talend Inc.
//
// This source code has been automatically generated by_Talend Open Studio for Data Integration
// / Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package wipo_projects.mock_job_for_guess_schema_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.TalendDate;
import routines.Relational;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

//the import part of tLibraryLoad_1
//import java.util.List;

//the import part of tLibraryLoad_2
//import java.util.List;

//the import part of tJavaFlex_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: Mock_job_for_Guess_schema Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 7.4.1.20200916_1624-M2
 * @status
 */
public class Mock_job_for_Guess_schema implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (hostInterMed != null) {

				this.setProperty("hostInterMed", hostInterMed.toString());

			}

			if (portInterMed != null) {

				this.setProperty("portInterMed", portInterMed.toString());

			}

			if (userInterMed != null) {

				this.setProperty("userInterMed", userInterMed.toString());

			}

			if (passwordInterMed != null) {

				this.setProperty("passwordInterMed", passwordInterMed.toString());

			}

			if (databaseInterMed != null) {

				this.setProperty("databaseInterMed", databaseInterMed.toString());

			}

			if (processAll != null) {

				this.setProperty("processAll", processAll.toString());

			}

			if (postgreUser != null) {

				this.setProperty("postgreUser", postgreUser.toString());

			}

			if (postgrePassword != null) {

				this.setProperty("postgrePassword", postgrePassword.toString());

			}

			if (postgreDb != null) {

				this.setProperty("postgreDb", postgreDb.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String hostInterMed;

		public String getHostInterMed() {
			return this.hostInterMed;
		}

		public String portInterMed;

		public String getPortInterMed() {
			return this.portInterMed;
		}

		public String userInterMed;

		public String getUserInterMed() {
			return this.userInterMed;
		}

		public String passwordInterMed;

		public String getPasswordInterMed() {
			return this.passwordInterMed;
		}

		public String databaseInterMed;

		public String getDatabaseInterMed() {
			return this.databaseInterMed;
		}

		public String processAll;

		public String getProcessAll() {
			return this.processAll;
		}

		public String postgreUser;

		public String getPostgreUser() {
			return this.postgreUser;
		}

		public String postgrePassword;

		public String getPostgrePassword() {
			return this.postgrePassword;
		}

		public String postgreDb;

		public String getPostgreDb() {
			return this.postgreDb;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Mock_job_for_Guess_schema";
	private final String projectName = "WIPO_PROJECTS";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Mock_job_for_Guess_schema.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Mock_job_for_Guess_schema.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tLibraryLoad_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLibraryLoad_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLibraryLoad_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLibraryLoad_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaFlex_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tJavaFlex_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLibraryLoad_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLibraryLoad_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tJavaFlex_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLibraryLoad_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLibraryLoad_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tLibraryLoad_1 begin ] start
				 */

				ok_Hash.put("tLibraryLoad_1", false);
				start_Hash.put("tLibraryLoad_1", System.currentTimeMillis());

				currentComponent = "tLibraryLoad_1";

				int tos_count_tLibraryLoad_1 = 0;

				/**
				 * [tLibraryLoad_1 begin ] stop
				 */

				/**
				 * [tLibraryLoad_1 main ] start
				 */

				currentComponent = "tLibraryLoad_1";

				tos_count_tLibraryLoad_1++;

				/**
				 * [tLibraryLoad_1 main ] stop
				 */

				/**
				 * [tLibraryLoad_1 process_data_begin ] start
				 */

				currentComponent = "tLibraryLoad_1";

				/**
				 * [tLibraryLoad_1 process_data_begin ] stop
				 */

				/**
				 * [tLibraryLoad_1 process_data_end ] start
				 */

				currentComponent = "tLibraryLoad_1";

				/**
				 * [tLibraryLoad_1 process_data_end ] stop
				 */

				/**
				 * [tLibraryLoad_1 end ] start
				 */

				currentComponent = "tLibraryLoad_1";

				ok_Hash.put("tLibraryLoad_1", true);
				end_Hash.put("tLibraryLoad_1", System.currentTimeMillis());

				/**
				 * [tLibraryLoad_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tLibraryLoad_1 finally ] start
				 */

				currentComponent = "tLibraryLoad_1";

				/**
				 * [tLibraryLoad_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLibraryLoad_1_SUBPROCESS_STATE", 1);
	}

	public void tLibraryLoad_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLibraryLoad_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tLibraryLoad_2 begin ] start
				 */

				ok_Hash.put("tLibraryLoad_2", false);
				start_Hash.put("tLibraryLoad_2", System.currentTimeMillis());

				currentComponent = "tLibraryLoad_2";

				int tos_count_tLibraryLoad_2 = 0;

				/**
				 * [tLibraryLoad_2 begin ] stop
				 */

				/**
				 * [tLibraryLoad_2 main ] start
				 */

				currentComponent = "tLibraryLoad_2";

				tos_count_tLibraryLoad_2++;

				/**
				 * [tLibraryLoad_2 main ] stop
				 */

				/**
				 * [tLibraryLoad_2 process_data_begin ] start
				 */

				currentComponent = "tLibraryLoad_2";

				/**
				 * [tLibraryLoad_2 process_data_begin ] stop
				 */

				/**
				 * [tLibraryLoad_2 process_data_end ] start
				 */

				currentComponent = "tLibraryLoad_2";

				/**
				 * [tLibraryLoad_2 process_data_end ] stop
				 */

				/**
				 * [tLibraryLoad_2 end ] start
				 */

				currentComponent = "tLibraryLoad_2";

				ok_Hash.put("tLibraryLoad_2", true);
				end_Hash.put("tLibraryLoad_2", System.currentTimeMillis());

				/**
				 * [tLibraryLoad_2 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tLibraryLoad_2 finally ] start
				 */

				currentComponent = "tLibraryLoad_2";

				/**
				 * [tLibraryLoad_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLibraryLoad_2_SUBPROCESS_STATE", 1);
	}

	public void tJavaFlex_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tJavaFlex_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tJavaFlex_1 begin ] start
				 */

				ok_Hash.put("tJavaFlex_1", false);
				start_Hash.put("tJavaFlex_1", System.currentTimeMillis());

				currentComponent = "tJavaFlex_1";

				int tos_count_tJavaFlex_1 = 0;

				java.util.Properties prop = new java.util.Properties();
				String additionalParams = "";
				additionalParams = additionalParams.replaceAll("&", "\n");
				String dbType = "PostgreSQL";
				String user = "postgres";
				if (user != null && !"".equals(user)) {
					prop.put("user", user);
				}
				String password = "W1P0w1p0";
				if (password != null && !"".equals(password)) {
					prop.put("password", password);
				}
				try {
					if (additionalParams != null && !"".equals(additionalParams)
							&& dbType.toUpperCase().contains("ORACLE")) {
						prop.load(new java.io.ByteArrayInputStream(additionalParams.getBytes()));
					}
				} catch (IOException e) {
				}
				java.lang.Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/Paraguay?";
				java.sql.Connection conn = java.sql.DriverManager.getConnection(url, prop);
				java.sql.Statement stm = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
						java.sql.ResultSet.CONCUR_READ_ONLY);
				try {
					stm.setFetchSize(50);
				} catch (Exception e) {
// Exception is thrown if db don't support, no need to catch exception here
				}
				java.sql.ResultSet rs = stm.executeQuery(
						"select \"num_acta\",\"num_acta_nuevo\" from \"marca\" where \"num_acta_nuevo\" is not null");
				java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				int numbOfColumn = rsmd.getColumnCount();

				String fileName = (new java.io.File(
						"G:/TOS_DI-20200916_1624-V7.4.1M2/temp/TempGuessSchemaDelimitedFile.csv")).getAbsolutePath()
								.replace("\\", "/");
				com.talend.csv.CSVWriter csvWriter = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(new java.io.FileOutputStream(fileName, false), "GBK")));

				csvWriter.setSeparator(';');
				csvWriter.setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);
				int nbRows = 0;
				String[] columnNames = new String[numbOfColumn];
				String[] nullables = new String[numbOfColumn];
				String[] lengths = new String[numbOfColumn];
				String[] precisions = new String[numbOfColumn];
				String[] dbtypes = new String[numbOfColumn];
				for (int i = 1; i <= numbOfColumn; i++) {
					columnNames[i - 1] = rsmd.getColumnName(i);
					nullables[i - 1] = rsmd.isNullable(i) == 0 ? "false" : "true";
					lengths[i - 1] = Integer.toString(rsmd.getScale(i));
					precisions[i - 1] = Integer.toString(rsmd.getPrecision(i));
					dbtypes[i - 1] = rsmd.getColumnTypeName(i);
				}
				csvWriter.writeNext(columnNames);
				csvWriter.writeNext(nullables);
				csvWriter.writeNext(lengths);
				csvWriter.writeNext(precisions);
				csvWriter.writeNext(dbtypes);
				while (rs.next()) {

					/**
					 * [tJavaFlex_1 begin ] stop
					 */

					/**
					 * [tJavaFlex_1 main ] start
					 */

					currentComponent = "tJavaFlex_1";

					String[] dataOneRow = new String[numbOfColumn];
					for (int i = 1; i <= numbOfColumn; i++) {

						try {
							String tempStr = rs.getString(i);
							dataOneRow[i - 1] = tempStr;
						} catch (java.sql.SQLException e) {
						}
					}
					csvWriter.writeNext(dataOneRow);

					tos_count_tJavaFlex_1++;

					/**
					 * [tJavaFlex_1 main ] stop
					 */

					/**
					 * [tJavaFlex_1 process_data_begin ] start
					 */

					currentComponent = "tJavaFlex_1";

					/**
					 * [tJavaFlex_1 process_data_begin ] stop
					 */

					/**
					 * [tJavaFlex_1 process_data_end ] start
					 */

					currentComponent = "tJavaFlex_1";

					/**
					 * [tJavaFlex_1 process_data_end ] stop
					 */

					/**
					 * [tJavaFlex_1 end ] start
					 */

					currentComponent = "tJavaFlex_1";

					nbRows++;
					if (nbRows > 50)
						break;
				}
				conn.close();
				csvWriter.close();

				ok_Hash.put("tJavaFlex_1", true);
				end_Hash.put("tJavaFlex_1", System.currentTimeMillis());

				/**
				 * [tJavaFlex_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tJavaFlex_1 finally ] start
				 */

				currentComponent = "tJavaFlex_1";

				/**
				 * [tJavaFlex_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tJavaFlex_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Mock_job_for_Guess_schema Mock_job_for_Guess_schemaClass = new Mock_job_for_Guess_schema();

		int exitCode = Mock_job_for_Guess_schemaClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Mock_job_for_Guess_schema.class.getClassLoader().getResourceAsStream(
					"wipo_projects/mock_job_for_guess_schema_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Mock_job_for_Guess_schema.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				// defaultProps is in order to keep the original context value
				if (context != null && context.isEmpty()) {
					defaultProps.load(inContext);
					context = new ContextProperties(defaultProps);
				}

				inContext.close();
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("hostInterMed", "id_String");
					if (context.getStringValue("hostInterMed") == null) {
						context.hostInterMed = null;
					} else {
						context.hostInterMed = (String) context.getProperty("hostInterMed");
					}
					context.setContextType("portInterMed", "id_String");
					if (context.getStringValue("portInterMed") == null) {
						context.portInterMed = null;
					} else {
						context.portInterMed = (String) context.getProperty("portInterMed");
					}
					context.setContextType("userInterMed", "id_String");
					if (context.getStringValue("userInterMed") == null) {
						context.userInterMed = null;
					} else {
						context.userInterMed = (String) context.getProperty("userInterMed");
					}
					context.setContextType("passwordInterMed", "id_String");
					if (context.getStringValue("passwordInterMed") == null) {
						context.passwordInterMed = null;
					} else {
						context.passwordInterMed = (String) context.getProperty("passwordInterMed");
					}
					context.setContextType("databaseInterMed", "id_String");
					if (context.getStringValue("databaseInterMed") == null) {
						context.databaseInterMed = null;
					} else {
						context.databaseInterMed = (String) context.getProperty("databaseInterMed");
					}
					context.setContextType("processAll", "id_String");
					if (context.getStringValue("processAll") == null) {
						context.processAll = null;
					} else {
						context.processAll = (String) context.getProperty("processAll");
					}
					context.setContextType("postgreUser", "id_String");
					if (context.getStringValue("postgreUser") == null) {
						context.postgreUser = null;
					} else {
						context.postgreUser = (String) context.getProperty("postgreUser");
					}
					context.setContextType("postgrePassword", "id_String");
					if (context.getStringValue("postgrePassword") == null) {
						context.postgrePassword = null;
					} else {
						context.postgrePassword = (String) context.getProperty("postgrePassword");
					}
					context.setContextType("postgreDb", "id_String");
					if (context.getStringValue("postgreDb") == null) {
						context.postgreDb = null;
					} else {
						context.postgreDb = (String) context.getProperty("postgreDb");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("hostInterMed")) {
				context.hostInterMed = (String) parentContextMap.get("hostInterMed");
			}
			if (parentContextMap.containsKey("portInterMed")) {
				context.portInterMed = (String) parentContextMap.get("portInterMed");
			}
			if (parentContextMap.containsKey("userInterMed")) {
				context.userInterMed = (String) parentContextMap.get("userInterMed");
			}
			if (parentContextMap.containsKey("passwordInterMed")) {
				context.passwordInterMed = (String) parentContextMap.get("passwordInterMed");
			}
			if (parentContextMap.containsKey("databaseInterMed")) {
				context.databaseInterMed = (String) parentContextMap.get("databaseInterMed");
			}
			if (parentContextMap.containsKey("processAll")) {
				context.processAll = (String) parentContextMap.get("processAll");
			}
			if (parentContextMap.containsKey("postgreUser")) {
				context.postgreUser = (String) parentContextMap.get("postgreUser");
			}
			if (parentContextMap.containsKey("postgrePassword")) {
				context.postgrePassword = (String) parentContextMap.get("postgrePassword");
			}
			if (parentContextMap.containsKey("postgreDb")) {
				context.postgreDb = (String) parentContextMap.get("postgreDb");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tLibraryLoad_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tLibraryLoad_1) {
			globalMap.put("tLibraryLoad_1_SUBPROCESS_STATE", -1);

			e_tLibraryLoad_1.printStackTrace();

		}
		try {
			errorCode = null;
			tLibraryLoad_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tLibraryLoad_2) {
			globalMap.put("tLibraryLoad_2_SUBPROCESS_STATE", -1);

			e_tLibraryLoad_2.printStackTrace();

		}
		try {
			errorCode = null;
			tJavaFlex_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tJavaFlex_1) {
			globalMap.put("tJavaFlex_1_SUBPROCESS_STATE", -1);

			e_tJavaFlex_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : Mock_job_for_Guess_schema");
		}

		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 41147 characters generated by Talend Open Studio for Data Integration on the
 * October 21, 2020 at 5:04:20 PM CEST
 ************************************************************************************************/