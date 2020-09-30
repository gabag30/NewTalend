package routines;

import java.io.Serializable;
import routines.DossierInfo;


public class Dossier implements Serializable {

	private int m_BatID = -1;
	private String m_DocID = null;
	private String m_DocNum = null;
	private String m_DocDate = null;
	private int m_DocType = -1;
	private int m_DocPage = 0;
	private int m_DocStatus = -1;
	private String m_Title = null;
	private String m_Abstract = null;
	
	public Dossier()
	{
	}
	
	public Dossier(int BatID, String DocID, String DocNum, String DocDate, int DocType,  /*String DocTypeName,*/ int DocPage, int DocStatus)
	{
		m_BatID = BatID;
		m_DocID = new String(DocID);
		m_DocNum = new String(DocNum);
		m_DocDate = new String(DocDate);
		m_DocType = DocType;
		m_DocPage = DocPage;
		m_DocStatus = DocStatus;
	}
	
	public void setMembers(int BatID, String DocID, String DocNum, String DocDate, int DocType, /*String DocTypeName,*/ int DocPage, int DocStatus)
	{
		m_BatID = BatID;
		m_DocID = new String(DocID);
		m_DocNum = new String(DocNum);
		m_DocDate = new String(DocDate);
		m_DocType = DocType;
		m_DocPage = DocPage;
		m_DocStatus = DocStatus;
	}
	
	public void setBatID(int BatID)
	{
		m_BatID = BatID;
	}
	
	public void setDocID(String DocID)
	{
		m_DocID = new String(DocID);
	}

	public void compDocID()
	{
              /* edited-by-gb to solve lucene index realated issue with "-" on the DocID */
		m_DocID = DossierInfo.lpad(m_DocNum.replaceAll("-", ""), 12, '0')  + "-" + DossierInfo.lpad(Integer.toString(m_DocType), 2, '0') + "-" + m_DocDate.replaceAll("[^0-9]", ""); //m_DocDate.replaceAll("/", "");
	}
	
	public String tryDocID(String DocNum)
	{
              /* edited-by-gb to solve lucene index realated issue with "-" on the DocID */
		return DossierInfo.lpad(m_DocNum.replaceAll("-", ""), 12, '0') + "-" + DossierInfo.lpad(Integer.toString(m_DocType), 2, '0') + "-" + m_DocDate.replaceAll("[^0-9]", ""); //m_DocDate.replaceAll("/", "");
	}
	
	public void setDocNum(String DocNum)
	{
		m_DocNum = new String(DocNum);
	}
	
	
	public void setDocDate(String DocDate)
	{
		m_DocDate = new String(DocDate);
	}

	public void setDocType(int DocType)
	{
		m_DocType = DocType;
	}

	public void setDocPage(int DocPage)
	{
		m_DocPage = DocPage;
	}

	public void setDocStatus(int DocStatus)
	{
		m_DocStatus = DocStatus;
	}

	public int getBatID()
	{
		return m_BatID;
	}
	
	public String getDocID()
	{
		return m_DocID;
	}
	
	
	public String getDocNum()
	{
		return m_DocNum;
	}
	

	public String getDocDate()
	{
		return m_DocDate;
	}

	public int getDocType()
	{
		return m_DocType;
	}

        //edited-by-gb 15-03-2011
        public String getDocTypeName()
	{
		return DossierInfo.getDocumentTypeName(m_DocType);
	}
        //end

	public int getDocPage()
	{
		return m_DocPage;
	}

	public int getDocStatus()
	{
		return m_DocStatus;
	}
 
	//chlee20101005
	public void setTitle(String title)
	{
		m_Title = new String(title);
	}

	public String getTitle()
	{
		return m_Title;
	}
	
	public void setAbstract(String abstract_str)
	{
		m_Abstract = new String(abstract_str);
	}

	public String getAbstract()
	{
		return m_Abstract;
	}
	
}
