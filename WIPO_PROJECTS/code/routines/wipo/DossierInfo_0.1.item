package routines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//added-by-me 8-03-2011
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Reader;
//end
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class DossierInfo {

	private static String[] s_documentTypesCodes;
	private static HashMap<Integer, String> s_documentTypeName;
	private static HashMap<Integer, String> s_documentTypeShortName;
	private static HashMap<String, Integer> s_documentTypeCode;
	public static int s_maxDocumentNameLength=0;
        
	private static HashMap<Integer, String> s_documentStatusMap;
	
	public static String lpad(String src, int nb, char c)
	{
	   StringBuffer result = new StringBuffer(src);
	   int i;
	   for (i=src.length();i<nb;i++)
	   {
		  result.insert(0,c);
	   }
	   return result.toString();
	}
	
	public static String[] getDocumentTypes()
	{
		String[] res = new String[s_documentTypesCodes.length];
		for (int i=0;i<s_documentTypesCodes.length;i++)
		{
			//System.out.println(s_documentTypeName.size());
			//System.out.println(s_documentTypeName.get(Integer.parseInt(s_documentTypesCodes[i])));
			res[i]=(String)s_documentTypeName.get(Integer.parseInt(s_documentTypesCodes[i]));
		}
		return res;
	}
	
	public static String getDocumentTypeName(int id)
	{
		return s_documentTypeName.get(id);
	}
	
	public static String getDocumentTypeShortName(int id)
	{
		return s_documentTypeShortName.get(id);
	}
	
	public static String getDocumentStatusName(int id)
	{
		return s_documentStatusMap.get(id);
	}
	
	public static void init()
	{
		if (s_documentTypesCodes==null)
		{	
			try
			{
				
				//original
				//BufferedReader in = new BufferedReader(new FileReader(new File("DocumentTypes.ini")));

                                //added-by-me 8-03-2011
                                File test=new File("./config/ini/DocumentTypes.ini");
                                if(!test.exists())
                                    System.out.println("Check configuration ini files not copied");
                                Reader reader = new InputStreamReader(new FileInputStream("./config/ini/DocumentTypes.ini"), "UTF-8");
                                BufferedReader in = new BufferedReader(reader);
                                //end 
                                
                                
                                ArrayList<String> docTypesCodes = new ArrayList<String>();
				s_documentTypeName = new HashMap<Integer, String>();
				s_documentTypeShortName = new HashMap<Integer, String>();
				s_documentTypeCode = new HashMap<String, Integer>();
				String line = in.readLine();
				int pos,pos2;
				while (line!=null)
				{
					pos = line.indexOf('|');
					pos2 = line.indexOf('|',pos+1);
					docTypesCodes.add(line.substring(0,pos));
					s_documentTypeName.put(Integer.parseInt(line.substring(0,pos)),line.substring(pos+1,pos2));
					s_documentTypeShortName.put(Integer.parseInt(line.substring(0,pos)),line.substring(pos2+1));
					s_documentTypeCode.put(line.substring(pos2+1), Integer.parseInt(line.substring(0,pos)));
					s_maxDocumentNameLength = Math.max(line.substring(4).length(), s_maxDocumentNameLength);
					line = in.readLine();
				}
				s_documentTypesCodes = new String[docTypesCodes.size()];
				s_documentTypesCodes = (String[])docTypesCodes.toArray(s_documentTypesCodes);
				in.close();
				
				
                                
                                //edited-by-gb 21-03-2011
				//in = new BufferedReader(new FileReader(new File("DocumentStatus.ini")));
				                                
                                Reader reader2 = new InputStreamReader(new FileInputStream("./config/ini/DocumentStatus.ini"), "UTF-8");
                                in = new BufferedReader(reader2);
                                //end
                                s_documentStatusMap = new HashMap<Integer, String>();

				for (line = in.readLine(); line != null; line = in.readLine())
				{
					pos = line.lastIndexOf('=');
					if (pos > 0)
					{
						int key = Integer.parseInt(line.substring(0, pos));
						String value = line.substring(pos+1);
						
						s_documentStatusMap.put(new Integer(key), value);
					}
				}
			 	
				in.close();
				
			}
			catch (Throwable e)
			{
				System.out.println("Fatal error: incorrect DocumentTypes.ini");
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	public static String validateDossierNumber(String IANum)//, String date, int type)
	{
		//String year,month,day,RO,number;
		String num = IANum.toUpperCase();
		
		if (num.length() > 12 || num.length() == 0)
			return null;
		
		
		/*//2011.02.28 Rachel :: WipoScan.ini DOCLENGTH ADD
		int docLeng = Integer.parseInt(ConfigInfo.getDocLength());
		
		if (num.length() > docLeng || num.length() == 0)
			return null;
		
		
		for (int i = 0; i < num.length(); i++)
		{
			char a = num.charAt(i);
			if (a < '0' || (a > '9' && a < 'A') || a > 'Z')
				return null;
		}
				
		return lpad(num,docLeng,'0');*/
		
		return num;
		
		/*
		try
		{
			if (num.charAt(4)=='/' && num.charAt(7)=='/')
			{
				year = num.substring(0,4);
				month = num.substring(5,7);
				day = num.substring(8,10);
			}	
			else //if (num.charAt(4)!='/' && num.charAt(7)!='/')
			{
				year = num.substring(0,4);
				month = num.substring(4,6);
				day = num.substring(6,8);
			}
			
			
			int pos = num.lastIndexOf('/');
			num = num.substring(pos-2);
			RO=num.substring(0,2);
			number = num.substring(3);
	
			
			int y=Integer.parseInt(year);
			int m=Integer.parseInt(month);
			int d=Integer.parseInt(day);
			int n=Integer.parseInt(number);
			if (y<1984 || y >2200)
				return null;
			if (m<0 || m >12)
				return null;
			if (d<0 || d >31)
				return null;
			if (n<0 ||n> 999999)
				return null;
		}
		catch (Exception e)
		{
			return null;
		}
		
		//System.out.println("result: "+year+month+day+"-"+RO+number);

		return year+"/"+month+"/"+day+"/"+RO+"/"+lpad(number,6,'0');
		*/
	}
	
}
