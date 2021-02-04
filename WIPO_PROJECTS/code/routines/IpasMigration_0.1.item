package routines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class IpasMigration {

	public static boolean isValidationFailed;
	private static final String MADRID_PROCESSING_MANUAL = "M";
	private static final String MADRID_PROCESSING_SEMI_AUTOMATIC = "S";
	private static final String MADRID_PROCESSING_AUTOMATIC = "A";
	private static final List<Map<String, String>> lstValidationLog = new ArrayList<>();
	private static final Map<String, List<String>> dataReferenceViolationMessageMap = new HashMap<>();
	private static final Map<String, String> countryCodeMap = new HashMap<>();
	private static final Map<String, String> st3CodeMap = new HashMap<>();
	private static String validationMessage = null;
	public static boolean goAheadJobInitialization = false;
	public static boolean goAheadJobConfiguration = false;
	public static boolean goAheadJobCommon = false;
	public static boolean goAheadJobTrademark = false;
	public static boolean goAheadJobPatentDesign = false;
	public static boolean goAheadJobBlob = false;
	public static boolean goAheadJobDataVerification = false;
	public static boolean goAheadJobUpdateNewFunctionality = false;
	public static boolean goAheadJobOptionList = false;

	private static Set<String> initMadridConfig() {
		Set<String> madridConfigurationParam = new HashSet<>();
		madridConfigurationParam.add("Execute_Special_Action_For_BIRTH_Without_User_Document_Approval");
		madridConfigurationParam.add("Execute_Special_Action_for_DEATH_without_Userdoc_approval");
		madridConfigurationParam.add("Mark_Reject_Status_Code_For_Subsequent_Madrid_BIRTH_EXN");
		madridConfigurationParam.add("Madrid2_LAW_CODE");
		madridConfigurationParam.add("Madrid2_APPL_TYP");
		madridConfigurationParam.add("Madrid_BIRTH_EXN_Implementation_Method");
		madridConfigurationParam.add("Madrid2_DOC_ORI");
		madridConfigurationParam.add("Madrid_Final_Status_BIRTH");
		madridConfigurationParam.add("Madrid_Final_Status_BIRTH_ENN");
		madridConfigurationParam.add("Madrid_Final_Status_BIRTH_EXN");
		madridConfigurationParam.add("Madrid_Final_Status_BIRTH_FUN");
		madridConfigurationParam.add("Madrid_Final_Status_BIRTH_OBN");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_CBNT");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_CPN");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_FUN");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_P2N");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_RAN");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_REN2");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_REN3");
		madridConfigurationParam.add("Madrid_Final_Status_DEATH_RNN");
		madridConfigurationParam.add("Madrid2_Language1");
		madridConfigurationParam.add("Madrid2_Language2");
		madridConfigurationParam.add("Madrid2_Language3");
		madridConfigurationParam.add("Madrid_Monitor_Url");
		madridConfigurationParam.add("Madrid_NEWNAME_Implementation_Method");
		madridConfigurationParam.add("Madrid_PROLONG_Implementation_Method");
		madridConfigurationParam.add("Madrid2_REPRESENTATIVE_TYP");
		madridConfigurationParam.add("Madrid_RESTRICT_Implementation_method");
		madridConfigurationParam.add("Madrid_Special_Action_BIRTH");
		madridConfigurationParam.add("Madrid_Special_Action_BIRTH_CPN");
		madridConfigurationParam.add("Madrid_Special_Action_BIRTH_ENN");
		madridConfigurationParam.add("Madrid_Special_Action_BIRTH_EXN");
		madridConfigurationParam.add("Madrid_Special_Action_BIRTH_FUN");
		madridConfigurationParam.add("Madrid_Special_Action_BIRTH_OBN");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_CBNT");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_CPN");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_FUN");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_P2N");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_RAN");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_REN2");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_REN3");
		madridConfigurationParam.add("Madrid_Special_Action_DEATH_RNN");

		madridConfigurationParam.add("Madrid2_UserdocType_CREATED");
		madridConfigurationParam.add("Madrid_UserdocType_NEWNAME");
		madridConfigurationParam.add("Madrid2_UserdocType_PAID");
		madridConfigurationParam.add("Madrid2_UserdocType_PROCESSED");
		madridConfigurationParam.add("Madrid2_UserdocType_PROLONG");
		madridConfigurationParam.add("Madrid2_UserdocType_RESTRICT");
		madridConfigurationParam.add("Madrid2_APPL_SUBTYP_Agreement");
		madridConfigurationParam.add("Madrid2_APPL_SUBTYP_ART9SEXIES");
		madridConfigurationParam.add("Madrid2_APPL_SUBTYP_Protocol");
		madridConfigurationParam.add("Madrid2_FinalStatus_Backlog_Registered");
		madridConfigurationParam.add("Madrid2_SpecialAction_Backlog_Registered");
		madridConfigurationParam.add("Madrid2_UserdocType_BIRTH");
		madridConfigurationParam.add("Madrid2_UserdocType_CORRECTION");
		madridConfigurationParam.add("Madrid2_UserdocType_DEATH");
		madridConfigurationParam.add("Madrid2_UserdocType_LICENCEBIRTH");
		madridConfigurationParam.add("Madrid2_UserdocType_LICENCENEWNAME");
		madridConfigurationParam.add("Madrid2_UserdocType_NEWBASE");
		madridConfigurationParam.add("Madrid2_UserdocType_NEWNAME");
		madridConfigurationParam.add("Madrid_notification_time_limit");
		madridConfigurationParam.add("Madrid2_APPL_SUBTYP_Agreement2");
		madridConfigurationParam.add("Madrid2_APPL_SUBTYP_Protocol2");
		madridConfigurationParam.add("Madrid2_APPL_SUBTYP_ART9SEXIES2");
		madridConfigurationParam.add("Madrid_REGISTRATION_TYP");
		madridConfigurationParam.add("Madrid_REGISTRATION_SER");
		madridConfigurationParam.add("Madrid2_FILE_SEQ");
		madridConfigurationParam.add("Madrid2_FILE_TYP");

		// madridConfigurationParam.add("Madrid_Rejection_reason_note_field");
		// madridConfigurationParam.add("Madrid_note_action_on_successful_extraction");

		// madridConfigurationParam.add("header");
		return madridConfigurationParam;
	}

	/**
	 * This method will check whether the parameter is one of the Madrid parameter
	 * 
	 * @param paramName Parameter name
	 * @return true if Madrid else false
	 */
	public static boolean checkIfMadridParameter(String paramName) {
		Set<String> madridConfigurationParam = initMadridConfig();
		// System.out.println(madridConfigurationParam.size()+ " Checking param name: "
		// + paramName + " check: " + madridConfigurationParam.contains(paramName));
		return madridConfigurationParam.contains(paramName);
	}

	public static String madridConvertParamName(String oldParamName) {

		if (oldParamName.startsWith("Madrid2_")) {
			return oldParamName.replaceFirst("Madrid2_", "Madrid_");
		} else if (oldParamName.equals("Execute_Special_Action_for_DEATH_without_Userdoc_approval")) {
			return "Execute_Special_Action_For_DEATH_Without_Userdoc_Approval";
		}
		return oldParamName;
	}

	public static String madridConvertParamValue(String paramName, String originalValue) {
		String newValue = originalValue;

		if (originalValue != null && !"".equalsIgnoreCase(originalValue)) {

			switch (paramName) {
			case "Madrid_BIRTH_EXN_Implementation_Method":
			case "Madrid_PROLONG_Implementation_Method":
			case "Madrid_NEWNAME_Implementation_Method":
				if ("F".equalsIgnoreCase(originalValue)) {
					newValue = MADRID_PROCESSING_AUTOMATIC;
				} else if ("P".equalsIgnoreCase(originalValue)) {
					newValue = MADRID_PROCESSING_SEMI_AUTOMATIC;
				}

				break;
			case "Madrid_RESTRICT_Implementation_method":
				if ("0".equalsIgnoreCase(originalValue)) {
					newValue = MADRID_PROCESSING_MANUAL;
				} else if ("1".equalsIgnoreCase(originalValue)) {
					newValue = MADRID_PROCESSING_AUTOMATIC;
				} else if ("2".equalsIgnoreCase(originalValue)) {
					newValue = MADRID_PROCESSING_SEMI_AUTOMATIC;
				}

				break;

			default:
				break;
			}

		}
		return newValue;
	}

	/**
	 * This function will evaluate the doc code for the user document
	 * 
	 * @param indOwner          Indicator Owner
	 * @param indRepr           Indicator representative
	 * @param indRenewal        Indicator renewal
	 * @param indAffectFile     Indicator affected file
	 * @param affectFileCount   Count of affected file
	 * @param withFileProcCount Count of process with files
	 * @param withUDProcCount   Count of process with UD
	 * @return evaluated user document code
	 */
	public static String evaluateUserdocCode(String indOwner, String indRepr, String indRenewal, String indAffectFile,
			long affectFileCount, long withFileProcCount, long withUDProcCount) {

		String firstEvaluation = ("N".equals(indOwner) && "N".equals(indRepr) && "N".equals(indRenewal)
				|| (indOwner == null && indRepr == null && indRenewal == null))
						? "UDGEN"
						: ("S".equals(indOwner) && "S".equals(indRepr)) ? "UDCOR"
								: ("S".equals(indOwner) && !"S".equals(indRepr)) ? "UDCOW"
										: (!"S".equals(indOwner) && "S".equals(indRepr)) ? "UDCRP"
												: ("S".equals(indRenewal) ? "UDREN" : "UDGEN");

		if ("UDGEN".equals(firstEvaluation)) {
			if (affectFileCount == 0 && withFileProcCount == 0 && withUDProcCount == 0 && "N".equals(indAffectFile)) {
				firstEvaluation = "UDDOC";
			}
		}
		return firstEvaluation;
	}

	/**
	 * This function will return the Logger instance
	 * 
	 * @param logclass Logger class
	 * @return Logger instance
	 */
	public static Logger getLogger(Class logclass) {
		return Logger.getLogger(logclass);
	}

	/**
	 * This function will log the table after completion based on the row count
	 * 
	 * @param logclass     Logger class
	 * @param tableName    Migration table name in context
	 * @param srcRowCount  Original row count
	 * @param destRowCount Migrated row count
	 */
	public static void logIt(Class logclass, String tableName, int srcRowCount, int destRowCount) {
		if (destRowCount < srcRowCount) {
			getLogger(logclass).error(
					tableName + " migration have some problem. Rows migrated: " + destRowCount + "/" + srcRowCount);
		} else {
			getLogger(logclass).info(tableName + " migrated successfully. Rows migrated: " + destRowCount);
		}
	}

	/**
	 * This function will log table after completion based on the row count. This
	 * method is specific for the table where one table is split into two.
	 * 
	 * @param logclass      Logger class
	 * @param tableName     Source table name and one of the destination table
	 * @param srcRowCount   Source row count
	 * @param destRowCount1 Destination rowCount
	 * @param destRowCount2 Additional table destination row count
	 * @param destTable2    Name of the additional table
	 */
	public static void logIt(Class logclass, String tableName, int srcRowCount, int destRowCount1, int destRowCount2,
			String destTable2) {
		if (destRowCount1 + destRowCount2 < srcRowCount) {
			getLogger(logclass).error(tableName + " migration have some problem. Rows migrated into destination : "
					+ tableName + " = " + +destRowCount1 + " and in second table : " + destTable2 + " = "
					+ destRowCount2 + " is not equal to source row count: " + srcRowCount);
		} else {
			getLogger(logclass).info(tableName + " migrated successfully. Rows migrated: " + tableName + "="
					+ destRowCount1 + " second table : " + destTable2 + " = " + destRowCount2);
		}

	}

	/**
	 * This function will return the converted Userdoc type code
	 * 
	 * @param currentUserDocTypeCode
	 * @return converted code
	 */
	public static String convertedUserDocTypeName(String currentUserDocTypeCode) {
		return currentUserDocTypeCode.length() < 7 ? "#" + currentUserDocTypeCode
				: "#" + currentUserDocTypeCode.substring(1, 6);
	}

	/**
	 * This function temporary set the validation message
	 * 
	 * @param message
	 */
	public static void addValidationMessage(String message) {
		validationMessage = message;
	}

	/**
	 * This function returns the temporary validation message
	 * 
	 * @return
	 */
	public static String getValidationMessage() {
		return validationMessage;
	}

	public static void addValidationMessage(Map<String, String> msgMap) {
		lstValidationLog.add(msgMap);
	}

	/**
	 * This function will return the error string for logging
	 * 
	 * @return
	 */
	public static String prepareLog() {
		StringBuffer strBufRow = new StringBuffer();
		String header = "";
		boolean firstRow = true;
		if (lstValidationLog != null && !lstValidationLog.isEmpty()) {

			Set<String> keySet = lstValidationLog.get(0).keySet();
			for (Map<String, String> map : lstValidationLog) {
				StringBuffer strBufCol = new StringBuffer();
				for (String key : keySet) {
					if (firstRow) {
						header += key + ";";
					}

					strBufCol.append(map.get(key)).append(";");
				}

				strBufRow.append(strBufCol).append("\n");
				firstRow = false;
			}
		}
		return validationMessage + " Failed Row Count: "
				+ (lstValidationLog != null ? lstValidationLog.size() + "" : "0") + "\n" + header
				+ "\n--------------------------\n" + strBufRow.toString();
	}

	public static void resetValidationLog() {
		lstValidationLog.clear();
	}

	/**
	 * Decide based on the option provided that whether the job needs to be executed
	 * or not.
	 * 
	 * @param option User input option
	 */
	public static void setJobsToExecute(String option) {

		if (option != null && !option.equals("")) {

			if (option.contains("0") || option.toLowerCase().contains("a")) {
				goAheadJobInitialization = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("b")) {
				goAheadJobConfiguration = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("c")) {
				goAheadJobCommon = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("d")) {
				goAheadJobTrademark = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("e")) {
				goAheadJobPatentDesign = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("f")) {
				goAheadJobBlob = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("g")) {
				goAheadJobOptionList = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("h")) {
				goAheadJobUpdateNewFunctionality = true;
			}
			if (option.contains("0") || option.toLowerCase().contains("i")) {
				goAheadJobDataVerification = true;
			}
		}
	}

	/**
	 * This function will prepare query for reference check based on the parameters
	 * passed.
	 * 
	 * @param foreignTable Referenced table name
	 * @param primaryTable Primary table name
	 * @param fkColumn     Semi-colon seperated columns of referred table
	 * @param pkColumn     Semi-colon seperated columns of primary table
	 * @return Query to check
	 */
	public static String prepareFkCheckQuery(final String foreignTable, final String primaryTable,
			final String fkColumn, final String pkColumn, final String constraintName) {
		final String FK_TABLE_ALIAS = "t1";
		final String PR_TABLE_ALIAS = "t2";

		final StringBuffer selQuery = new StringBuffer();
		selQuery.append("select distinct ");
		// foreign columns set
		final StringBuffer fkCols = new StringBuffer();
		final StringBuffer fkColSel = new StringBuffer();
		final StringBuffer fkColName = new StringBuffer();
		final StringBuffer prCols = new StringBuffer();
		final StringBuffer notNullClause = new StringBuffer();
		final StringBuffer joinClause = new StringBuffer();

		String primaryColAry[] = pkColumn.split(";");
		String refColAry[] = fkColumn.split(";");

		for (int i = 0; i < refColAry.length; i++) {
			if (fkCols.toString() != null && !fkCols.toString().equals("")) {
				fkCols.append(",");
				fkColSel.append("|| '-' ||");
				fkColName.append("-");
				prCols.append(",");
				notNullClause.append(" and ");
				joinClause.append(" and ");
			}
			notNullClause.append(FK_TABLE_ALIAS + "." + refColAry[i]);
			notNullClause.append(" is not null ");
			fkCols.append(FK_TABLE_ALIAS + "." + refColAry[i]);
			fkColSel.append(FK_TABLE_ALIAS + "." + refColAry[i]);
			fkColName.append(refColAry[i]);
			prCols.append(PR_TABLE_ALIAS + "." + primaryColAry[i]);
			joinClause
					.append(" " + FK_TABLE_ALIAS + "." + refColAry[i] + "=" + PR_TABLE_ALIAS + "." + primaryColAry[i]);

		}

		selQuery.append(fkColSel);
		selQuery.append(" as keyval ");
		selQuery.append(", '" + fkColName.toString() + "' as keyvalname ");
		selQuery.append(", '" + foreignTable + "' as foreigntable ");
		selQuery.append(", '" + primaryTable + "' as primarytable ");
		selQuery.append(", '" + constraintName + "' as constraintname ");
		selQuery.append(" from ");
		selQuery.append(foreignTable);
		selQuery.append(" " + FK_TABLE_ALIAS);// table alias
		selQuery.append(" where ");
		selQuery.append(notNullClause);
		/// selQuery.append(" and (");
		// selQuery.append(fkCols);
		selQuery.append(" and not exists ( select ");
		selQuery.append(prCols);
		selQuery.append(" from ");
		selQuery.append(primaryTable);
		selQuery.append(" " + PR_TABLE_ALIAS);// table alias
		selQuery.append(" where ");
		selQuery.append(joinClause);
		selQuery.append(" ) ");
		return selQuery.toString();
	}

	public static void addDataViolationMessage(final String keyval, final String kevalName, final String foreignTable,
			final String primaryTable, final String constraintName) {

		if (keyval != null && !keyval.equals("")) {
			String messageKey = "Constraint violated: " + constraintName.toLowerCase() + " on table "
					+ foreignTable.toLowerCase() + " referring table  " + primaryTable.toLowerCase()
					+ " for below data \n (" + kevalName.toLowerCase() + ")";

			List<String> lstViolatedRows = dataReferenceViolationMessageMap.get(messageKey);
			if (lstViolatedRows == null || lstViolatedRows.isEmpty()) {
				lstViolatedRows = new ArrayList<>();
			}
			lstViolatedRows.add(keyval);
			dataReferenceViolationMessageMap.put(messageKey, lstViolatedRows);
		}
	}

	public static void logFkviolation(Class logger) {
		if (!dataReferenceViolationMessageMap.isEmpty()) {

			getLogger(logger).error("Data integration violation found for the following entries:");

			for (String key : dataReferenceViolationMessageMap.keySet()) {
				StringBuffer dispKey = new StringBuffer(key + " \n **************************************\n");

				List<String> lstViolatedRows = dataReferenceViolationMessageMap.get(key);
				for (String strViolatedrow : lstViolatedRows) {
					dispKey.append(strViolatedrow + "\n");
				}
				getLogger(logger).error(dispKey);
			}

		} else {
			getLogger(logger).info("Data integration check is completed. No violation found");
		}

	}

	public static void testContext() {

	}

	/**
	 * From comma seperated values, it creates a quoted comma seperated values
	 * 
	 * @param srcString
	 * @return
	 */
	public static String getQuottedString(String srcString) {
		StringBuffer retStr = new StringBuffer();
		if (srcString != null && !srcString.equalsIgnoreCase("")) {
			String[] strAry = srcString.split(",");
			for (String string : strAry) {
				if (retStr.length() > 0) {
					retStr.append(",");
				}
				retStr.append("'").append(string).append("'");
			}
		}
		return retStr.toString();
	}

	/**
	 * Returns the mapped value of the country code
	 * 
	 * @param countryCode country code
	 * @return corresponding st3 code
	 */
	public static String getSt3CodeForCountry(String countryCode) {
		return countryCodeMap.get(countryCode);
	}

	/**
	 * Returns the mapped value of the st3code to country
	 * 
	 * @param st3Code
	 * @return
	 */
	public static String getCountryCodeForSt3(String st3Code) {
		return st3CodeMap.get(st3Code);
	}

	/**
	 * This function will initialize and populate the mapping of country code to ST3
	 * codes
	 * 
	 * @param contextString
	 */
	public static void populateCountryCodeMap(String contextString) {
		if (contextString != null && !contextString.equals("") && countryCodeMap.isEmpty()) {
			// Initialize only if not done
			String[] coary = contextString.split(",");
			for (String cogrp : coary) {
				String[] codes = cogrp.trim().split("\\^");
				countryCodeMap.put(codes[0].trim(), codes[1].trim());
				if (!codes[1].trim().equalsIgnoreCase("KEEP")) {
					st3CodeMap.put(codes[1].trim(), codes[0].trim());
				}

			}
		}
	}

	/**
	 * Conver the value X to S and others to N
	 * 
	 * @param indValue
	 * @return
	 */
	public static String convertCountryIndicator(String indValue) {
		if (indValue != null && indValue.trim().equalsIgnoreCase("X")) {
			return "S";
		} else {
			return null;
		}
	}

	/**
	 * This function will evaluate the country and return according to the
	 * configuration.
	 * 
	 * @param countryCode Current country code to be evaluated
	 * @return final country code.
	 */
	public static String evaluateCountryCode(String countryCode) {
		if (countryCode != null) {
			String transCntryCode = countryCodeMap.get(countryCode);
			if (transCntryCode == null || transCntryCode.equalsIgnoreCase("KEEP")) {
				return countryCode;
			} else {
				return transCntryCode;
			}
		}
		return null;
	}

	/**
	 * Changes the context init path if the runtime execution detected.
	 * @param currentPath
	 * @return
	 */
	public static String changeContextPathOfInit(String currentPath) {
		String runtimePath = System.getenv("IPAS4MIG_HOME");
		String retPath = currentPath;
		if(runtimePath != null && !"".equals(runtimePath)) {
			retPath = runtimePath + java.io.File.separator + "resources" + java.io.File.separator;
			getLogger(IpasMigration.class).info("Runtime execution detected, changing init file path to: "+ retPath);

		}
		return retPath;
	}
	
	/**
	 * Append the doc extension to the value 
	 * @param fileName file name
	 * @return
	 */
	public static String appendDocExtension(String fileName) {
		if(fileName != null && !fileName.trim().equals("")) {
			return fileName + ".doc";
		}
		return null;
	}

	/**
	 * Check if the parameter is the JOurnal template wrapper
	 * @param configCode Cofiguration code
	 * @return
	 */
	public static boolean isJournalWrapper(String configCode) {
		return configCode.equals("JournalTemplateWrapperFile1") || configCode.equals("JournalTemplateWrapperFile2") 
				||configCode.equals("JournalTemplateWrapperFile3") ||configCode.equals("JournalTemplateWrapperFile4") 
				||configCode.equals("JournalTemplateWrapperFile5");
	}
}
