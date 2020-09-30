package routines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//edited-by-gb 16-03-2011
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Reader;
//end
import java.io.IOException;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


/**
 * This class represents a document section and its characteristics. 
 * In order to set the current document section instance to a given section,
 * the setCode() function shall be used. The sections are uniquely identified 
 * by a char and defined from the DocumentSection property file.
 *
 * @author Christophe Mazenc
 */
public class DocumentSection 
{
  protected DocumentSection()
  {
  }

  
  public static DocumentSection getNewDocumentSection() {
	//if (!init(DocumentSection.class.getPackage().getName()+".DocumentSection"))
	  if (!init("./config/ini/DocumentSection.properties"))
			throw new RuntimeException("Cannot load DocumentSection.properties");
	return new DocumentSection();
  }
  
 
 /**
 * Method that loads the definition of the sections from the property file.
 * The sections are keyed using the characters starting from 'A'.
 * The following characteristics of the sections are uploaded:
 * column 1: long name of the section
 * column 2: short name of the section
 * column 3: tooltip
 * column 4: section stamping mode:           N = no stamping
 *                                            H = only right top stamp
 *                                            Y = left and right top stamps
 * column 5: section page numbering:          N = no page numbering
 *                                            Y = page numbering with section total
 *                                            H = page numbering without section total
 *                                            C = continue previous section numbering
*/
  public static boolean init(String className)
  {
    String line;
    if (longIndexations!=null)
      return true;
	nbSubDocs=0;
	BufferedReader config = null;
	ArrayList longIndexationsList = new ArrayList(20);
	ArrayList shortIndexationsList = new ArrayList(20);
	ArrayList indexationCodeList = new ArrayList(20);
	ArrayList tooltipList = new ArrayList(20);
	ArrayList paginationModeList = new ArrayList(20);
	ArrayList stampModeList = new ArrayList(20);
	try {
	  //PropertyResourceBundle r = (PropertyResourceBundle) ResourceBundle.getBundle(className);
          //edited-by-gb 16-03-2011
          // PropertyResourceBundle r = new PropertyResourceBundle(new FileReader(new File(className))); 
          Reader reader = new InputStreamReader(new FileInputStream(className), "UTF-8");  
	  PropertyResourceBundle r = new PropertyResourceBundle(reader);
          //end
	  
	  int pos=0;
	  int pos2=0;
	  int pos3=0;
	  int pos4=0;
	  int i=0;
	  while (true)
	  {
		line = r.getString(""+(char)('A'+i));
		// System.out.println("Reading section information combination "+(char)('A'+i)+"="+line);			
		pos = line.indexOf(',');
		pos2 = line.indexOf(',',pos+1);
		pos3 = line.indexOf(',',pos2+1);
		pos4 = line.indexOf(',',pos3+1);
		indexationCodeList.add(new Character((char)('A'+i)));
		longIndexationsList.add(line.substring(0,pos));
		shortIndexationsList.add(line.substring(pos+1,pos2));
		tooltipList.add(line.substring(pos2+1,pos3));
		stampModeList.add(line.substring(pos3+1,pos4));
		paginationModeList.add(line.substring(pos4+1));
		
		i++;
	  }  
	}
	catch (MissingResourceException e)
	{
		if (e.getKey().length()!=1)
		{	
			e.printStackTrace();
			return false;
		}	
	}
	catch (RuntimeException e)
	{
		e.printStackTrace();
		return false;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	nbSubDocs= indexationCodeList.size();
	longIndexations = new String[nbSubDocs];
	shortIndexations = new String[nbSubDocs];
	indexationCode = new char[nbSubDocs];
	tooltip = new String[nbSubDocs];
	stampMode = new char[nbSubDocs];
	paginationMode = new char[nbSubDocs];
	longIndexations = (String[]) longIndexationsList.toArray(longIndexations);
	shortIndexations = (String[]) shortIndexationsList.toArray(shortIndexations);
	tooltip = (String[]) tooltipList.toArray(tooltip);
	for (int i=0;i<nbSubDocs;i++)
	{
		indexationCode[i] = ((Character)indexationCodeList.get(i)).charValue();
		stampMode[i] = ((String)stampModeList.get(i)).charAt(0);
		paginationMode[i] = ((String)paginationModeList.get(i)).charAt(0);
	}
	return true;
  }
 
  
  /**
  * Method that returns the number of sections read from the property file.
  * */
  public static int length()
  {
	return nbSubDocs;
  }

 public boolean setNumber(int nb)
 {
    if (nb<0 || nb>=nbSubDocs)
      return false;
    idxNr=nb;
    idxChar = (char) (nb+(int)'A');
    return true;
 }

 
 protected boolean setTags(String tags)
 {
    if (tags==null)
      return false;
    for (int i=0;i<tags.length();i++)
    {
      if (!setCode(tags.charAt(i)))
         return false;
    }
    return true;
 }

 /**
 * Sets the current section instance to the section identified by the character
 * passed in parameter. 
 * */ 
 public boolean setCode(char c)
 {
    int nb= 0-(int)'A'+(int)c;
   	if (nb<0 || nb>=nbSubDocs)
      return false;
    idxNr = nb;
    idxChar = c;
    return true;
 }


 /**
 * Gets the long name of the section identified by the the character
 * passed in parameter. 
 * */ 
 public static String getLongName(char c)
 {
 	if (nbSubDocs == 0)
 		//if (!init(DocumentSection.class.getPackage().getName()+".DocumentSection"))
 		if (!init("./config/ini/DocumentSection.properties"))
 			return "";
	int nb= 0-(int)'A'+(int)c;
	if (nb<0 || nb>=nbSubDocs)
	  return "";
   return longIndexations[nb];
 }

 /**
  * Gets the long name of the section identified by the the character
  * passed in parameter. 
  * */ 
  public static char getCode(String shortName)
  {
  	if (nbSubDocs == 0)
  		//if (!init(DocumentSection.class.getPackage().getName()+".DocumentSection"))
  		if (!init("./config/ini/DocumentSection.properties"))
  			return (char )0;
  	for (int i=0; i<shortIndexations.length; i++) {
  		if (shortIndexations[i].equalsIgnoreCase(shortName)) {
  			return indexationCode[i];
  		}
  	}
  	return (char )0;
  }

 /**
  * Gets the short name of the section identified by the the character
  * passed in parameter. 
  * */ 
  public static String getShortName(char c)
  {
  	if (nbSubDocs == 0)
  		//if (!init(DocumentSection.class.getPackage().getName()+".DocumentSection"))
  		if (!init("./config/ini/DocumentSection.properties"))
  			return "";
 	int nb= 0-(int)'A'+(int)c;
 	if (nb<0 || nb>=nbSubDocs)
 	  return "";
    return shortIndexations[nb];
  }
 
  /**
   * Gets the short name of the section identified by the the character
   * passed in parameter. 
   * */ 
   public static char getCodeByTag(String tagname)
   {
   	if (nbSubDocs == 0)
   		//if (!init(DocumentSection.class.getPackage().getName()+".DocumentSection"))
   		if (!init("./config/ini/DocumentSection.properties"))
   		  	return (char )0;
  	for (int i=0; i<tooltip.length; i++) {
  		if (tooltip[i].equalsIgnoreCase(tagname)) {
  			return indexationCode[i];
  		}
  	}
  	return (char )0;
   }
   
  /**
   * Gets the short name of the section identified by the the character
   * passed in parameter. 
   * */ 
   public static String getTooltip(char c)
   {
   	if (nbSubDocs == 0)
   		//if (!init(DocumentSection.class.getPackage().getName()+".DocumentSection"))
   		if (!init("./config/ini/DocumentSection.properties"))
   			return "";
  	int nb= 0-(int)'A'+(int)c;
  	if (nb<0 || nb>=nbSubDocs)
  	  return "";
     return tooltip[nb];
   }
 /**
 * Gets the short name of the section. 
 * */ 
 public String getShortName()
 {
   return shortIndexations[idxNr];
 }

 /**
 * Gets the long name of the section. 
 * */ 
 public String getLongName()
 {
   return longIndexations[idxNr];
 }

/**
* Gets a longer text describing the section that can be uses as a tooltip. 
* */ 
public String getToolTip()
 {
   return tooltip[idxNr];
 }

 /**
 * Gets the section's identifying character. 
 * */ 
 public char getCode()
 {
   return idxChar;
 }

 protected int getNumber()
 {
   return idxNr;
 }

 /**
 * Tests if two sections are equal. 
 * */ 
 public boolean equals(DocumentSection ps)
 {
 	if (ps==null)
 		return false;
	if (ps.getCode()!=getCode())
		return false;
	return true;
 }
 
 
 /**
 * Method that computes how a page containing several sections should be
 * paginated.
 * **/
 public static char getPaginationType(String tags)
 {
   char res = WITH_TOTAL;
    
   if (tags==null)
   {
	 return NONE;
   }
   else
   {
	 for (int i=0;i<tags.length();i++)
	 {
	   if (paginationMode[0-(int)'A'+(int)tags.charAt(i)]==NONE)
		 return NONE;
	   else if (paginationMode[0-(int)'A'+(int)tags.charAt(i)]==WITHOUT_TOTAL)
		 res=WITHOUT_TOTAL;
	   else if (paginationMode[0-(int)'A'+(int)tags.charAt(i)]==AS_BEFORE)
		 res=AS_BEFORE;
	 }
   }
   return res;
 }

 /**
 * Method that computes how a page containing several sections should be
 * stamped.
 * **/
 public static char getStampingType(String tags)
 {
   char res = NO_STAMP;
    
   if (tags==null)
   {
	 return NO_STAMP;
   }
   else
   {
	 for (int i=0;i<tags.length();i++)
	 {
	   if (paginationMode[0-(int)'A'+(int)tags.charAt(i)]==NO_STAMP)
		 return NO_STAMP;
	   else if (paginationMode[0-(int)'A'+(int)tags.charAt(i)]==RIGHT_AND_LEFT)
		 res=RIGHT_AND_LEFT;
	   else if (paginationMode[0-(int)'A'+(int)tags.charAt(i)]==ONLY_RIGHT)
		 res=ONLY_RIGHT;
	 }
   }
   return res;
 }

 /**
 * Gets the the section's stamping mode:
 * @return char: NO_STAMP (this section shall not be stamped in the document)
 *               RIGHT_AND_LEFT (two stamps shall be applied on each page of this section)
 *               ONLY_RIGHT (One stamp shall be applied on each page of this section)
 * */ 
 public char getStampingMode()
 {
   return stampMode[idxNr];
 }

 /**
 * Gets the the section's pagination mode:
 * @return char: WITH_TOTAL (this section shall be paginated with the section total)
 *               WITHOUT_TOTAL (this section shall be paginated without section total)
 *               NONE (this section shall not be paginated)
 *               AS_BEFORE (This section shall be considered as a continuation of the
 *                          previous section in the document for pagination)
 **/
 public char getPaginationMode()
 {
   return paginationMode[idxNr];
 }



 private static String[] longIndexations;   
 private static String[] shortIndexations;  
 private static char[] indexationCode;      
 private static String[] tooltip;           
 
 private static char[] stampMode,paginationMode; 

 public static final char NO_STAMP='N';
 public static final char RIGHT_AND_LEFT='Y';
 public static final char ONLY_RIGHT='H';
 public static final char NONE='N';
 public static final char WITH_TOTAL='Y';
 public static final char WITHOUT_TOTAL='H';
 public static final char AS_BEFORE='C';


 private static int nbSubDocs;       // nb sections 

 private int idxNr=0;                  // section number
 private char idxChar='A';             // section key
}

