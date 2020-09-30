package routines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
//edited-by-gb 16-03-2011
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Reader;
//end

/**
 * This class stores the information about the indexation of a document. 
 * It allows to add a section, remove a section, check the validity
 * of the table of contents according to rules and read and save 
 * the indexation information from a flat file.
 * For the table of contents checking, a configuration file named 
 * indexationCombinations.ini is used. This file contains regular expressions
 * describing the valid sequences of sections taking into acccount the
 * document type and the indexation type of the document.
 * 
 * @author Christophe Mazenc
 * @version 1.0 January 2005
 */

public class DocumentIndexation 
{
	public static String FILENAME = "indexation.lst";
	public static String XMLNAME = "indexation.xml";
	
  private DocumentIndexation()
  {
    indexationTags = new HashMap();
  }

  
  public static DocumentIndexation getNewDocumentIndexation(String docType)
  {
	  //if (!init(DocumentIndexation.class.getPackage().getName() + ".DocumentIndexation"))
	  if (!init("config/ini/DocumentIndexation.properties"))
	  {
		throw new RuntimeException("Cannot load DocumentIndexation.properties");
	  }
	  DocumentIndexation docIdx = new DocumentIndexation();
	  docIdx.documentType = docType;
	  return docIdx;
  }

  /**
  * <pre>Private utility function to prepend a String with a given
  *      character in order to get a given length.</pre>
  */		 		
  private static String lpad(String src, int nb, char c)
  {
	 StringBuffer result = new StringBuffer(src);
	 int i;
	 for (i=src.length();i<nb;i++)
	 {
		result.insert(0,c);
	 }
	 return result.toString();
  }


  /**
  * <pre>Private utility function to prepend a String with a given
  *      character in order to get a given length.</pre>
  */		 		
  private static String rpad(String src, int nb, char c)
  {
	 StringBuffer result = new StringBuffer(src);
	 int i;
	 for (i=src.length();i<nb;i++)
	 {
		result.append(c);
	 }
	 return result.toString();
  }

  private static boolean init(String className)
  {
  	if (idxCombinations!=null)
  		return true;
       String line;
      
	  BufferedReader config = null;
	  try {
	  	
		//PropertyResourceBundle r = (PropertyResourceBundle) ResourceBundle.getBundle(className);
                //edited-by-gb 16-03-2011
                //PropertyResourceBundle r = new PropertyResourceBundle(new FileReader(new File(className)));
		Reader reader = new InputStreamReader(new FileInputStream(className), "UTF-8");  
                PropertyResourceBundle r = new PropertyResourceBundle(reader);
                //end
                idxCombinations = new HashMap();
		orderingStrings = new HashMap();
		idxMust = new HashMap();
 	    
		int n;
		int pos,pos2,pos3,pos4;
		String s;
		int i=1;

		while (true)
		{
			line = r.getString("C"+i);
			pos = line.indexOf(":");
			pos2 = line.indexOf(":",pos+1);
			pos3 = line.indexOf(":",pos2+1);
			// System.out.println("Reading indexation combination C"+i+"="+line);			
			idxCombinations.put(line.substring(0,pos),line.substring(pos+1,pos2));
			orderingStrings.put(line.substring(0,pos),line.substring(pos2+1,pos3));
			if (pos3+1<line.length())
			{
			  n=1;
			  s=line.substring(pos3+1);
          
			  for (int j=0;j<s.length();j++)
				if (s.charAt(j)==',')
				  n++;
			  String[] idxs=new String[n];
			  n=0;
			  int j=s.indexOf(",");
			  if (j==-1)
				idxs[0]=s;
			  for (;j>=0;)
			  {
				idxs[n]=s.substring(0,j);
				s=s.substring(j+1);
				j=s.indexOf(",");
				n++;
			  }
			  idxs[n]=s;
			  idxMust.put(line.substring(0,pos),idxs);
			}
			i++;
		}
	  }
	  catch (MissingResourceException e)
	  {
		if (!e.getKey().startsWith("C"))
		{
			System.out.println("Incorrect File DocumentIndexation.properties");
			return false;
		}	
	  }
	  catch (RuntimeException e)
	  {
	  	e.printStackTrace();
		System.out.println("Cannot find file DocumentIndexation.properties");
		return false;
	  } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Cannot find file DocumentIndexation.properties");
		return false;

	} catch (IOException e) {
		// TODO Auto-generated catch block
	  	e.printStackTrace();
		System.out.println("Cannot find file DocumentIndexation.properties");
		return false;

	}
    return true;
  }


  /**
   * Reads a document indexation from a flat file "indexation.lst"
   * @param the directory where the indexation flat file is located.
   * @return true in case of success, false otherwise 
   */
  public boolean readDocumentIndexation(String docDir)
  {
    indexationTags.clear();
    String idx;
    File idxFile = new File(docDir+File.separator+FILENAME);
    if (idxFile.exists())
    {
      try
      {
        BufferedReader config = new BufferedReader( new InputStreamReader(new FileInputStream(docDir+File.separator+FILENAME),"UTF-8") );
        String line;
        for (line=config.readLine();line!=null&&line.length()>0;line=config.readLine())
        {
           idx = line.substring(line.indexOf(',')+1);
           indexationTags.put(line.substring(0,line.indexOf(',')),line.substring(line.indexOf(',')+1));
        }
        config.close();
      }
      catch (IOException e)
      {
        return false;
      }
    }
    updatePagesWithTags();
    return true;
  }

  public boolean saveIndexation(String docDir, String indexContent) {
    File idxFile = new File(docDir+File.separator+FILENAME);
    try
    {
      if (idxFile.exists())
        idxFile.delete();
      idxFile.createNewFile();
	  OutputStreamWriter idxOut = new OutputStreamWriter(new FileOutputStream(idxFile),"UTF-8");
      idxOut.write(indexContent);
      idxOut.close();
    }
    catch(IOException ioe)
    {
      return false;
    }
    return true;
  }

  public boolean saveXMLIndexation(String docDir, String indexContent) {
	    File idxFile = new File(docDir+File.separator+XMLNAME);
	    try
	    {
	      if (idxFile.exists())
	        idxFile.delete();
	      idxFile.createNewFile();
		  OutputStreamWriter idxOut = new OutputStreamWriter(new FileOutputStream(idxFile),"UTF-8");
	      idxOut.write(indexContent);
	      idxOut.close();
	    }
	    catch(IOException ioe)
	    {
	      return false;
	    }
	    return true;
	  }
  
  
  /**
   * Saves the pamphlet indexation in a flat file "indexation.lst"
   * @param the directory where the indexation flat file is located.
   * @return true in case of success, false otherwise 
   */
  public boolean saveIndexation(String docDir)
  {
    return saveIndexation(docDir, getIndexation());
  }

  public boolean saveXMLIndexation(String docDir, String[] pagesList, String docType, int pageNum)
  {
    return saveXMLIndexation(docDir, getXMLIndexation(pagesList, docType, pageNum));
  }
  
  public String getIndexation() {
    StringBuffer idxTxt = new StringBuffer("");
    Set idxSet = indexationTags.entrySet();
    Iterator i = idxSet.iterator();
    for (;i.hasNext();)
    {
      Map.Entry me=(Map.Entry)i.next();
      idxTxt.append(me.getKey());
      idxTxt.append(",");
      idxTxt.append(me.getValue());
      idxTxt.append("\n");
    }
    return idxTxt.toString();
  }

  /**********************************************************/
  /*										*/
  /*	M?hode qui met ?jour le tableau pagesWithTags  	*/
  /*	qui contient la liste ordonn? des noms des pages     */
  /*  ayant une indexation                                  */
  /*										*/
  /**********************************************************/

  private void updatePagesWithTags()
  {
    if (indexationTags.size()>0)
    {
      Set s = indexationTags.keySet();
      pagesWithTags = new String[indexationTags.size()];
      pagesWithTags = (String[]) s.toArray(pagesWithTags );
      Arrays.sort(pagesWithTags);
    }
  }

  /**
   * returns the starting page number of section number n
   * @param String[] the names of the pages.
   * @param int the section number.
   * @return the page number of -1 if not found 
   */
  public int getSectionNPageNumber(String[] pagesList,int n)
  {
  	if (pagesWithTags==null)
  		return -1;
    if (n>=0 && n<pagesWithTags.length)
    {
      String pageName = pagesWithTags[n];
      int pos = Arrays.binarySearch(pagesList,pageName);
      return pos;
    }
    else
     return -1;
  }

  /**********************************************************/
  /**
   * Finds the page information of a given page number
   * @see PageInfo
   * @param String[] pagesList: array of page names of the pamphlet.
   *        int pageNr: page number 
   * @return PageInfo  
   */

  /**********************************************************/
  /*										*/
  /*	M?hode qui retourne les tags d'indexation            */
  /*  d'une page identifi? par son num?o                  */
  /*										*/
  /**********************************************************/

  public String findIndexationTags(String[] pagesList,int pageNr)
  {
  	if (pagesList == null || pagesList.length<=pageNr)
  		return null;
    return (String) indexationTags.get(pagesList[pageNr]);
  }


  /**********************************************************/
  /*										*/
  /*	M?hode qui retourne le num?o de page de la premi?e */
  /*  page de la section pr??ente                         */
  /*										*/
  /**********************************************************/
  public int getPreviousSectionFirstPageNr(String[] pagesList, int pageNr)
  {
    if (indexationTags.size()>0)
    {
      int pos = Arrays.binarySearch(pagesWithTags,pagesList[pageNr]);
      if (pos<0)
        if (-pos-2>=0 && -pos-2<pagesWithTags.length)
          return Arrays.binarySearch(pagesList,pagesWithTags[-pos-2]);
        else
          return pageNr;         
      else
      {
        if (pos==0)
          return pageNr;
        return Arrays.binarySearch(pagesList,pagesWithTags[pos-1]);         
      }
    }
    return pageNr;
  }
 

  /**********************************************************/
  /*										*/
  /*	M?hode qui retourne le num?o de page de la premi?e */
  /*  page de la section suivante                           */
  /*										*/
  /**********************************************************/
  public int getNextSectionFirstPageNr(String[] pagesList,int pageNr)
  {
    if (indexationTags.size()>0)
    {
      int pos = Arrays.binarySearch(pagesWithTags,pagesList[pageNr]);
      if (pos<0)
        if (-pos-1<pagesWithTags.length)
          return Arrays.binarySearch(pagesList,pagesWithTags[-pos-1]);
        else
          return pageNr;         
      else
      {
        if (pos+1<pagesWithTags.length)
          return Arrays.binarySearch(pagesList,pagesWithTags[pos+1]);
        else
          return pageNr;
      }
    }
    return pageNr;
  }


  private String getLongName(String tags)
  {
  	StringBuffer res= new StringBuffer();
	int k=0;
	DocumentSection ps = DocumentSection.getNewDocumentSection();
	for (k=0;k<tags.length();k++)
	{	
	  ps.setCode(tags.charAt(k));
	  if (k!=0)
	  res.append('+');
	  res.append(ps.getLongName());
	}
	return res.toString();
 	
  }
  
  /**********************************************************************/
  /*												*/
  /* M?hode qui g??e la table des mati?es                           */
  /* 												*/
  /**********************************************************************/
  public String getTOC(String[] pagesList)
  {
    StringBuffer res = new StringBuffer("");
    String[] indexations = new String[indexationTags.size()];
    Set idxSet = indexationTags.entrySet();
    Iterator i = idxSet.iterator();
    String tags;
    String subDoc="";
    String tiffName;
    String pageNum;
    boolean fp=false;
    int pos;
    int j=0;
    for (;i.hasNext();)
    {
      Map.Entry me=(Map.Entry)i.next();
      tiffName=(String)me.getKey();
      tags=(String)me.getValue();
      subDoc = getLongName(tags);
      pos = Arrays.binarySearch(pagesList,tiffName)+1;
      
      indexations[j++]= lpad(""+pos,7,'0')+tags.charAt(0)+rpad(subDoc,30,'.')+lpad(""+pos,7,'.');
    }
    Arrays.sort(indexations);
    for (j=0;j<indexations.length;j++)
    {
          res.append(indexations[j].substring(8));
          res.append("\n");
    }

    res.append(rpad("",37,'-'));    
    res.append("\n");
    res.append(rpad("Total number of pages",30,' ')+lpad(""+pagesList.length,7,' '));
    res.append("\n");
    String toc = res.toString();
    if (indexations.length==0)
      toc= "No indexation entered yet!\n\n";
    return toc;
  }

  /**********************************************************************/
  /*												*/
  /* M?hode qui g??e la table des mati?es                           */
  /* 												*/
  /**********************************************************************/
  public String[] getTOCList(String[] pagesList)
  {
  	String[] emptyTOC = {"No indexation entered yet!"};
	if (indexationTags.size()==0)
		return emptyTOC;
	
	String[] res = new String[indexationTags.size()];
	String[] indexations = new String[indexationTags.size()];
	Set idxSet = indexationTags.entrySet();
	Iterator i = idxSet.iterator();
	String tags;
	String subDoc="";
	String tiffName;
	String pageNum;
	boolean fp=false;
	int pos;
	int j=0;
	for (;i.hasNext();)
	{
	  Map.Entry me=(Map.Entry)i.next();
	  tiffName=(String)me.getKey();
	  tags=(String)me.getValue();
	  subDoc = getLongName(tags);
	  pos = Arrays.binarySearch(pagesList,tiffName)+1;
      
	  indexations[j++]= lpad(""+pos,7,'0')+tags.charAt(0)+rpad(subDoc,30,'.')+lpad(""+pos,7,'.');
	}
	Arrays.sort(indexations);
	for (j=0;j<indexations.length;j++)
	{
		  res[j]=indexations[j].substring(8);
	}
    return res;
  }

  /**********************************************************************/
  /*												*/
  /* M?hode qui ajoute une section ?une page                          */
  /* 												*/
  /**********************************************************************/
  /**
   * Adds a section to the pamphlet indexation
   * @see PamphletSection
   * @param String[] pagesList: array of page names of the pamphlet.
   *        int pageNr: starting page number of the section
   *        PamphletSection ps: section to be added to the indexation 
   * @return true in case of success, false otherwise  
   */
  public boolean addIndexation(String[] pagesList, int pageNr, DocumentSection ps)
  {
    char idxCode = ps.getCode();
    boolean res=addIndexation(pagesList, pageNr, idxCode);
    if (res==false)
      return res;
    return true;
  }


  /**********************************************************************/
  /*												*/
  /* M?hode qui bouge une indexation                                   */
  /* 												*/
  /**********************************************************************/
  public void moveIndexation(String srcPageName, String dstPageName)
  {
      String idxVal = (String) indexationTags.get(srcPageName);
      if (idxVal!=null)
      {
    	  indexationTags.remove(srcPageName);
    	  indexationTags.put(dstPageName,idxVal);
      } 
    	  
      updatePagesWithTags();
  }

  public void removeIndexation(String srcPageName)
  {
      String idxVal = (String) indexationTags.get(srcPageName);
      if (idxVal!=null)
      {
    	  indexationTags.remove(srcPageName);
      } 
    	  
      updatePagesWithTags();
  }
  
  public String getIndexation(String srcPageName)
  {
      return (String) indexationTags.get(srcPageName);
  }

  public void addIndexation(String dstPageName, String idxVal)
  {
	  indexationTags.put(dstPageName,idxVal);
	  
	  updatePagesWithTags();
  }
  
  
  /**********************************************************************/
  /*												*/
  /* M?hode qui ajoute une indexation ?une page                       */
  /* 												*/
  /**********************************************************************/
  private boolean addIndexation(String[] pagesList, int pageNr, char idxCode)
  {
	DocumentSection ps = DocumentSection.getNewDocumentSection();
     boolean ok=ps.setCode(idxCode);
     if (ok==false)
       // echec car code de section inconnu
       return false;

     if (pageNr<0 || pageNr>=pagesList.length)
       // echec car num?o de page incorrect
       return false;

     String pageName = pagesList[pageNr];

     int pos = -1;
     String tags;
     tags = (String) indexationTags.get(pageName);
     if (tags!=null)
         pos = tags.indexOf(idxCode);

     // si il n'y a aucune indexation ?cette page, on la rajoute
     if (tags==null||tags.length()==0)
       indexationTags.put(pageName,""+idxCode);
     else 
     {
		indexationTags.put(pageName,tags+idxCode);
     }
     updatePagesWithTags();
     return true;
  }


  /**********************************************************************/
  /*												*/
  /* M?hode qui supprime une indexation d'une page                     */
  /* 												*/
  /**********************************************************************/
  public boolean removeIndexation(String[] pagesList, int pageNr, char idxCode)
  {
	DocumentSection ps = DocumentSection.getNewDocumentSection();
     boolean ok=ps.setCode(idxCode);
     if (ok==false)
       // echec car code de section inconnu
       return false;

     if (pageNr<0 || pageNr>=pagesList.length)
       // echec car num?o de page incorrect
       return false;

     String pageName = pagesList[pageNr];

     String tags;
     tags = (String) indexationTags.get(pageName);
     int pos = -1;
     if (tags!=null)
          pos = tags.indexOf(idxCode);
     if (tags.length()==1)
     {
        // si il n'y a que cette indexation, on la supprime
        indexationTags.remove(pageName);
     }
     else
     {
        // on enl?e le tag de l'indexation
        if (pos==0)
           tags = tags.substring(1);
         else if (pos==tags.length()-1)
           tags = tags.substring(0,tags.length()-1);
         else
            tags = tags.substring(0,pos)+tags.substring(pos+1);
         indexationTags.put(pageName,tags);
      }
     updatePagesWithTags();
     return true;
  }


  /**********************************************************************/
  /*												*/
  /* M?hode qui supprime toutes les indexations d'une page             */
  /* 												*/
  /**********************************************************************/
  /**
   * removes from the indexation the sections starting at a given page number
   * @param String[] pagesList: array of page names of the pamphlet.
   *        int pageNr: starting page number of the sections to be removed
   * @return true in case of success, false otherwise  
   */
  public boolean removeIndexations(String[] pagesList, int pageNr)
  {
     if (pageNr<0 || pageNr>=pagesList.length)
       // echec car num?o de page incorrect
       return false;
     indexationTags.remove(pagesList[pageNr]);
     updatePagesWithTags();
     return true;
  }

  /**********************************************************************/
  /*												*/
  /* M?hode qui supprime toutes les indexations                        */
  /* 												*/
  /**********************************************************************/
  /**
   * removes from the pamphlet indexation all the sections 
   * @return true in case of success, false otherwise  
   */
  public boolean removeIndexations()
  {
     indexationTags.clear();
     updatePagesWithTags();
     return true;
  }


  /**********************************************************************/
  /*												*/
  /* M?hode qui trie une cha?e par ordre lexicographique              */
  /* 												*/
  /**********************************************************************/
  private String sortedString(String src)
  {
    if (src==null)
      return null;
    else
    {
      if (src.length()==1)
        return src;
      else
      {
        int i;
        int pos=0;
        char c=src.charAt(0);
        for (i=1;i<src.length();i++)
          if (src.charAt(i)<c)
          {
            pos=i;
            c=src.charAt(i);
          }
        String res="";
        if (pos==0)
          return ""+c+sortedString(src.substring(1));
        else
          if (pos<src.length()-1)
            return ""+c+sortedString(src.substring(0,pos)+src.substring(pos+1));
          else
            return ""+c+sortedString(src.substring(0,pos));
      }
    }
  }


  /**********************************************************************/
  /*												*/
  /* M?hode qui v?ifie l'indexation                                   */
  /* 												*/
  /**********************************************************************/
  /**
   * Checks if the logic of the sections sequence follows the rules.
   * @param String[] pagesList: array of page names of the document.
   * @param String   key: document and indexation types.
   * @return true if the indexation is valid, false otherwise
   * if the function returns false, an error string or a warning string is
   * set depending on the gravity of the error. @see getError and getWarning  
   */
 public boolean isIndexationOK(String[] pagesList, String key)
 {
    boolean indexationHasWarnings = false;
    String res = "";
    boolean checkWithXMLContent=true;
    // reinitialisation des messages d'erreur
    errorString="";
    warningString="";


    // construction de la cha?e d'indexation
    String[] sections = new String[indexationTags.size()];
    Set idxSet = indexationTags.entrySet(); 
    int[] idxPage = new int[200];          // max indexations: 200   
    Iterator i = idxSet.iterator();
    String indexationsString="";
    String curIdx;
    Map.Entry me;
    int j=0;
    for (;i.hasNext();)
    {
      me=(Map.Entry)i.next();
      sections[j++]=(String)me.getKey();
    }
    Arrays.sort(sections);
    j=0;
    for (int l=0;l<sections.length;l++)
    {
      // on impose les tags par ordre lexicographique pour chaque page
      curIdx = sortedString((String) indexationTags.get(sections[l]));
      indexationsString +=curIdx;
      // on sauve les num?os de page des indexations ?des fins de reporting d'erreurs
      int k;
      for (k=0;k<curIdx.length();k++)
         idxPage[j++]= Arrays.binarySearch(pagesList, sections[l])+1;
    }

    int pos=0;    
    String missingIdx="";


    // v?ification de l'ordre des indexations du document
    // utilisation du package GNU regexp
    String idxCombination=(String)idxCombinations.get(key);
    if (idxCombination!=null && idxCombination.length()>0)
    {	
	    Pattern exp=null; 
	    Pattern expWithoutFp=null;
	    try
	    {
	        exp = Pattern.compile(idxCombination);
	    }
	    catch (Exception re)
	    {
	    	re.printStackTrace();
			System.out.println("idx key="+key);
	        errorString="Problem when reading the indexation regular expression.";
	        return false;
	    }
	
	    if (!exp.matcher(indexationsString).matches())
	    {
	      // la chaine d'indexation n'est pas conforme ?l'expression r?uli?e
	      
		  int l=1;
	
	      for (l=1;(l<indexationsString.length() && exp.matcher(indexationsString.substring(0,l)).matches());l++);
	
	      errorString = "Bad indexation found in page "+idxPage[l-1]+".";
	      return false;
	     
	    }
    }
    
	// recherche des sections obligatoires depuis le fichier ini
	String[] idxObli=(String[])idxMust.get(key);

	if (idxObli!=null)
	{  
	  int k;    
	  for (k=0; k<idxObli.length && pos>=0; k++)
	  {
		pos=indexationsString.indexOf(idxObli[k]);
		if (pos<0)
		{
		  // il manque l'index obligatoire
		  missingIdx=getLongName(idxObli[k]);
		}
	  }
	  if (pos<0)
	  {
		  errorString="Missing section: "+missingIdx+".";
		  return false;
	  }
	}	
	return true;

 }

 public int size()
 {
   if (indexationTags==null)
     return 0;
   else
     return indexationTags.size();
 }

  /**
   * Returns the warning set by the indexation checking procedure (Free text)
   * @return String
   */
 public String getWarning()
 {
   return warningString;
 }

  /**
   * Returns the error set by the indexation checking procedure (Free text)
   * @return String
   */
 public String getError()
 {
   return errorString;
 }

  /**
   * Returns an hashmap containing the pamphlet sections: key   = Page Number
   *                                                      value = Array of sections of the page 
   * @param String[] pagesList: array of page names of the pamphlet.
   * @return hashmap
   */
  public HashMap getSections(String[] pagesList)
  {
    HashMap res = new HashMap();
    Set idxSet = indexationTags.entrySet();
    String tags, tiffName;
    int pos;
    Iterator i = idxSet.iterator();
    for (;i.hasNext();)
    {
      Map.Entry me=(Map.Entry)i.next();
      tiffName=(String)me.getKey();
      pos = Arrays.binarySearch(pagesList,tiffName);
      if (pos <0)
        throw new IllegalArgumentException("unknown page: "+tiffName);
      tags=(String)me.getValue();
      DocumentSection[] ds = new DocumentSection[tags.length()];
      for (int j=0;j<tags.length();j++)
      {
      	ds[j]=DocumentSection.getNewDocumentSection();
      	ds[j].setCode(tags.charAt(j));
      }
      res.put(""+(pos+1),ds);
    }
    return res;
  }
  
  public String getType() {
  	return documentType;
  }
  
  private String getStartEntity(String tags)
  {
	StringBuffer res= new StringBuffer();
	int k=0;
	DocumentSection ps = DocumentSection.getNewDocumentSection();
	for (k=0;k<tags.length();k++)
	{	
	  ps.setCode(tags.charAt(k));
	  res.append('<');
	  res.append(ps.getLongName().replaceAll(" ","-"));
	  res.append('>');
	}
	return res.toString();
  }
  
  private String getEndEntity(String tags)
  {
	StringBuffer res= new StringBuffer();
	int k=0;
	DocumentSection ps = DocumentSection.getNewDocumentSection();
	for (k=tags.length()-1;k>=0;k--)
	{	
	  ps.setCode(tags.charAt(k));
	  res.append("</");
	  res.append(ps.getLongName().replaceAll(" ","-"));
	  res.append('>');
	}
	return res.toString();
 	
  }


  
  /**********************************************************************/
  /*												                    */
  /* M?hode qui recup?e l'indexation sous format XML                  */
  /* 												                    */
  /**********************************************************************/
  public String getXMLIndexation(String[] pagesList, String docType, int pageNum)
  {
	StringBuffer res = new StringBuffer();
	res.append("<"+docType.replace(' ', '_')+">\n");
	String tags; 
	String prevTags=null;
	for (int i=0;i<pageNum;i++)
	{
		tags = (String) indexationTags.get(pagesList[i]);

		if (tags!=null)
		{
			if (prevTags!=null)
			{
				res.append(getEndEntity(prevTags));
				res.append("\n");
			}

			res.append(getStartEntity(tags));			
			res.append("\n");
			
			prevTags = tags;
		}
		
		res.append("<doc-page id=\""+lpad(""+(i+1),6,'0')+"\" type=\"tif\" file=\""+
						  pagesList[i]+"\" wi=\"2540\" he=\"3560\"/>\n");
		
		
	}
	if (prevTags!=null)
	{
		res.append(getEndEntity(prevTags));
		res.append("\n");
	}
		
	res.append("</"+docType.replace(' ', '_')+">\n");
	
    return res.toString();
  }

 protected static String getIndexationRegExp(String docType)
 {
 	
	//if (!init(DocumentIndexation.class.getPackage().getName() + ".DocumentIndexation"))
	if (!init("config/ini/DocumentIndexation.properties"))
	{
	  throw new RuntimeException("Cannot load DocumentIndexation.properties");
	}
	return (String) idxCombinations.get(docType);
 }
 
 public static String getOrderingString(String docType)
 {
 	
	//if (!init(DocumentIndexation.class.getPackage().getName() + ".DocumentIndexation"))
	if (!init("config/ini/DocumentIndexation.properties"))
	{
	  throw new RuntimeException("Cannot load DocumentIndexation.properties");
	}
	return (String) orderingStrings.get(docType);
 }
 
 public static int getOrder(String docType, char code) {
	//if (!init(DocumentIndexation.class.getPackage().getName() + ".DocumentIndexation"))
	if (!init("config/ini/DocumentIndexation.properties"))
	{
	  throw new RuntimeException("Cannot load DocumentIndexation.properties");
	}
	int order = 1;
	if (preferredOrderingStrings == null) {
		preferredOrderingStrings = new HashMap();
		String preferredOrder = ((String )orderingStrings.get(docType));
		if (preferredOrder != null) {
			String[] shortNames = ((String )orderingStrings.get(docType)).split(",");
			for (int i=0; i<shortNames.length; i++) {
				if (!preferredOrderingStrings.containsKey(shortNames[i]) && shortNames[i].length() == 1) {
					preferredOrderingStrings.put(String.valueOf(shortNames[i].charAt(0)), new Integer(order++));
				}
			}
		}
	}
	if (code != ((char )0)) {
		Integer pos = (Integer ) preferredOrderingStrings.get(String.valueOf(code));
		if (pos != null)
			return pos.intValue();
	}
	return preferredOrderingStrings.size()+1; // put to the end
 } 
 
 public static boolean isIndexable(String docType) {
	//if (!init(DocumentIndexation.class.getPackage().getName() + ".DocumentIndexation"))
	if (!init("config/ini/DocumentIndexation.properties"))
	{
	  throw new RuntimeException("Cannot load DocumentIndexation.properties");
	}
	int order = 1;
	HashMap map = new HashMap();
	String[] shortNames = ((String )orderingStrings.get(docType)).split(",");
	return (shortNames != null && shortNames.length>0);
 } 

 public static String[] getDocumentTypes()
 {
	//if (!init(DocumentIndexation.class.getPackage().getName() + ".DocumentIndexation"))
	if (!init("config/ini/DocumentIndexation.properties"))
	{
	  throw new RuntimeException("Cannot load DocumentIndexation.properties");
	}
	String[] res = new String[idxCombinations.size()];
 	res = (String[]) idxCombinations.keySet().toArray(res);
 	Arrays.sort(res);
 	return res;
 }

 private String warningString="";
 private String errorString="";
 private String documentType="";

 private String[] pagesWithTags;     // tableau ordonn?des noms des pages ayant une indexation
 private HashMap indexationTags;     // stockage des ruptures de tags d'indexation
 private static HashMap idxCombinations; // stockage des combinaisons d'indexations; cl?repubCode+kindCode
 private static HashMap idxMust; // stockage des indexations obligatoires; cl?repubCode+kindCode
 private static HashMap orderingStrings; // stockage des indexations obligatoires; cl?repubCode+kindCode
 private static HashMap preferredOrderingStrings; // stockage des indexations obligatoires; cl?repubCode+kindCode

	 
}

