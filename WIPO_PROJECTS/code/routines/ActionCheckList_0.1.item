package routines;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
public class ActionCheckList {
	private String procType;
	private Long procNum;
	private Long actionNum;
	private Date actionDate;
	private String loginId;
	private String checklistTemplate1;
	private String checklistValue1;
	private String checklistTemplate2;
	private String checklistValue2;
	private String checklistTemplate3;
	private String checklistValue3;
	// Map<list-code,Map<option-list,output-text>
	private Map<String, Map<String, String>> mapListCodes = new HashMap<>();

	public Map<String, Map<String, String>> getMapListCodes() {
		return mapListCodes;
	}

	public void addOptionList(String listCode, String optionNumber, String optionText) {
		Map<String, String> option = mapListCodes.get(getConvertedOptionListCode(listCode));
		if (option == null) {
			option = new HashMap<>();
		}
		option.put(optionNumber, optionText);
		mapListCodes.put(getConvertedOptionListCode(listCode), option);
	}

	public String getChecklistTemplate1() {
		return checklistTemplate1;
	}

	public String getChecklistValue1() {
		return checklistValue1;
	}

	public String getChecklistTemplate2() {
		return checklistTemplate2;
	}

	public String getChecklistValue2() {
		return checklistValue2;
	}

	public String getChecklistTemplate3() {
		return checklistTemplate3;
	}

	public String getChecklistValue3() {
		return checklistValue3;
	}

	public String getProcType() {
		return procType;
	}

	public void setProcType(String procType) {
		this.procType = procType;
	}

	public Long getProcNum() {
		return procNum;
	}

	public void setProcNum(Long procNum) {
		this.procNum = procNum;
	}

	public Long getActionNum() {
		return actionNum;
	}

	public void setActionNum(Long actionNum) {
		this.actionNum = actionNum;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Based on the populated option map this method will further generate the json
	 * data and populate the corresponding attribute of the checklist.
	 */
	public void populateChecklistData() {

		// For each list code in the map, one set of attribute is to be populate
		// Maximum possible list code in map are 3
		Set<String> listCodes = mapListCodes.keySet();
		int chkListCount = 1;
		for (String listCode : listCodes) {
			Map<String, String> option = mapListCodes.get(listCode);
			String checklistDataValue = prepareJsonValue(listCode, option);

			if (chkListCount == 1) {
				checklistTemplate1 = listCode;
				checklistValue1 = checklistDataValue;
			} else if (chkListCount == 2) {
				checklistTemplate2 = listCode;
				checklistValue2 = checklistDataValue;
			} else if (chkListCount == 3) {
				checklistTemplate3 = listCode;
				checklistValue3 = checklistDataValue;
			}
			chkListCount++;
		}

	}

	private String wrapDoubleQuote(String value) {
		return "\"" + value + "\"";
	}

	private String prepareJsonValue(String listCode, Map<String, String> option) {

		StringBuffer buf = new StringBuffer();
		buf.append("{");
		buf.append(wrapDoubleQuote("id") + ":");// Response id
		buf.append(wrapDoubleQuote(listCode + "_response_id"));
		buf.append(",");
		buf.append(prepareItemsNode(listCode, option)); // Items node
		buf.append(",");
		buf.append(wrapDoubleQuote("templateId") + ":");
		buf.append(wrapDoubleQuote("OL_" + listCode)); // Template id
		buf.append(",");
		buf.append(emptyHistroyTag());
		buf.append("}");
		return buf.toString();
	}

	/**
	 * @return
	 */
	private String emptyHistroyTag() {
		return wrapDoubleQuote("history") + ": []";
	}

	private StringBuffer prepareItemsNode(String listCode, Map<String, String> option) {
		StringBuffer buf = new StringBuffer();
		buf.append(wrapDoubleQuote("items") + ":");
		buf.append("{");
		int count = 1;
		for (String optionId : option.keySet()) {
			buf.append(prepareOptionChildrenNode(optionId, option.get(optionId)));
			if (option.size() > count) {
				buf.append(",");
			}
			count++;
		}
		buf.append("}");

		return buf;
	}

	private StringBuffer prepareOptionChildrenNode(String optionId, String optionNotes) {
		StringBuffer buf = new StringBuffer();
		buf.append(wrapDoubleQuote(optionId) + ":");
		buf.append("{");
		buf.append(wrapDoubleQuote("id") + ":");
		buf.append(wrapDoubleQuote(UUID.randomUUID().toString()));
		buf.append(",");
		buf.append(prepareNotesNode(optionNotes));
		buf.append(",");
		buf.append(wrapDoubleQuote("placeholders") + ":{}");
		buf.append(",");
		buf.append(wrapDoubleQuote("reviewed") + ":" + wrapDoubleQuote("true"));
		buf.append("}");
		return buf;
	}

	private StringBuffer prepareNotesNode(String optionNotes) {
		StringBuffer buf = new StringBuffer();
		String nodeId = UUID.randomUUID().toString();
		buf.append(wrapDoubleQuote("notes") + ":");
		buf.append("{");
		buf.append(wrapDoubleQuote("allComments") + ":[]");
		buf.append(",");
		buf.append(prepareDefaultValueNote("comment"));
		buf.append(",");
		// Prepare the comments node if optionNotes data exist
		if (optionNotes != null && !optionNotes.equals("")) {
			buf.append(wrapDoubleQuote("comments") + ":");
			buf.append("[");
			buf.append("{");
			buf.append(wrapDoubleQuote("parentId") + ":");
			buf.append(wrapDoubleQuote(nodeId));
			buf.append(",");
			buf.append(wrapDoubleQuote("author") + ":");
			buf.append(wrapDoubleQuote(getLoginId()));
			buf.append(",");
			buf.append(wrapDoubleQuote("content") + ":");
			buf.append(wrapDoubleQuote(optionNotes.replaceAll("\"", "\\\\\"")));
			buf.append(",");
			buf.append(wrapDoubleQuote("date") + ":");
			buf.append(wrapDoubleQuote(getFormattedActionDate()));
			buf.append(",");
			buf.append(wrapDoubleQuote("id") + ":");
			buf.append(wrapDoubleQuote(UUID.randomUUID().toString()));
			buf.append(",");
			buf.append(emptyHistroyTag());
			buf.append("}");
			buf.append("]");

		} else {
			// empty comment node
			buf.append(wrapDoubleQuote("comments") + ":[]");
		}
		buf.append(",");
		buf.append(wrapDoubleQuote("id") + ":");
		buf.append(wrapDoubleQuote(nodeId));
		buf.append(",");
		buf.append(prepareDefaultValueNote("legalBackground"));
		buf.append(",");
		buf.append(prepareDefaultValueNote("overcomeAction"));
		buf.append("}");

		return buf;
	}

	private StringBuffer prepareDefaultValueNote(String forNode) {
		StringBuffer buf = new StringBuffer();
		buf.append(wrapDoubleQuote(forNode) + ":");
		buf.append("{");
		buf.append(wrapDoubleQuote("content") + ":" + "\"\"");
		buf.append(",");
		buf.append(wrapDoubleQuote("date") + ":");
		buf.append(wrapDoubleQuote(getFormattedActionDate()));
		buf.append(",");
		buf.append(wrapDoubleQuote("id") + ":");
		buf.append(wrapDoubleQuote(UUID.randomUUID().toString()));
		buf.append(",");
		buf.append(emptyHistroyTag());
		buf.append("}");
		return buf;
	}

	private String getFormattedActionDate() {
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss aaa");
		return format.format(actionDate);
	}

	/**
	 * Return the list code name by adding prefix of OL_ if possible
	 * @param listCode
	 * @return
	 */
	public static String getConvertedOptionListCode(String listCode) {
		return listCode.length() > 5 ? listCode : "OL_"+listCode ;
	}
}
