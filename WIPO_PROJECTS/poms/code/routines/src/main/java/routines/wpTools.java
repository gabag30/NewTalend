package routines;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
//import org.apache.log4j.Logger;

/**
 *1
 * @author gabag
 */
public class wpTools {
    //static Logger logger = Logger.getLogger(basicTools.class);
    
    

	
	public static  boolean listOfPdfToMerge(String uriWP,List<File> filesToMerge, String nameMergedFile, File outputFolder)
    throws  IOException {
            outputFolder.mkdirs();
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //adding files
            filesToMerge.forEach((ff) -> {
                try {
                    builder.addBinaryBody("files",new FileInputStream(ff),ContentType.APPLICATION_OCTET_STREAM,ff.getName());
                } catch (IOException e) {
                    //logger.warn(e);
                }
            });
            //System.out.println("trying to get the bookmarks to processs");
            //System.out.println(System.getProperty("user.dir") + "/config/BookmarkTranslate.properties");
//adding bookmarks
            filesToMerge.forEach((File ff) -> {
                try {
                    basicTools pm = new basicTools();
                    String Booki=pm.getBookMarkNameFromFile(ff,new File (System.getProperty("user.dir") + "/config/BookmarkTranslate.properties"));
                    //Booki=(Booki.isEmpty()) ? "Solicitud" : Booki;
                    //logger.warn(Booki);
                    builder.addTextBody("bookmarks", Booki , ContentType.TEXT_PLAIN);
                } catch (Exception e) {
                    //logger.warn(e);
                }
            });
            //System.out.println("Going to processs");
            HttpEntity multipart = builder.build();    
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost uploadFile = new HttpPost("http://"+ uriWP +"/wipopublish-api-files/api/files/pdf/merge");
                File finalFile = new File (outputFolder + File.separator + nameMergedFile);
                try {
                    uploadFile.setEntity(multipart);
                    CloseableHttpResponse response = httpClient.execute(uploadFile);
                   Header[] headers = response.getAllHeaders();
		for (Header h : headers) {
			
                        if(h.getName().equals("Content-Type")) {
                            
                            //System.out.println(">>>>>>>>>>>>"+h.getValue().toString());
                            if (!h.getValue().equalsIgnoreCase("application/pdf")) {
                                //logger.warn ("One of the PDFs to merge has an issue, please check.");
                                HttpEntity responseEntity = response.getEntity();
                                
                                
                                //logger.info(IOUtils.toString(responseEntity.getContent(),"utf8"));
                                httpClient.close();
                                return false;
                            } else {
                                HttpEntity responseEntity = response.getEntity();
                                FileOutputStream fos;
                                try (InputStream is = responseEntity.getContent()) {
                                    fos = new FileOutputStream(finalFile);
                                    int inByte;
                                    while((inByte = is.read()) != -1)
                                        fos.write(inByte);
                                }
                                fos.close();
                                httpClient.close();
                                return true;
                            }
                            
                        }
                          /*
                                 System.out.print("Names --->" + h.getName() );
                                System.out.print("values --->" +h.getValue());
                                
                                if (h.getValue().equalsIgnoreCase("application/pdf")) {
                                logger.warn ("One of the PDFs to merge has an issue, please check.");
                                httpClient.close();
                                return false;
                                
                                */
                            
                        
                }
                } catch (IOException e) {
                    //logger.warn("Couldn't download the merged file");
                    finalFile.delete();
                    httpClient.close();
                    return false;
                
                }
                }
                
        return true;
        
        }
   
	public static  boolean pdfFolderToMerge(String uriWP,String folderToMerge, String nameMergedFile, String outputFolder)
		    throws  IOException {
		            
					new File(outputFolder).mkdirs();
		            List<File> filesToMerge = (List<File>) FileUtils.listFiles(new File(folderToMerge), new String[] { "pdf", "PDF"}, false);
		                //System.out.println(files.toString());
		            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		            //adding files
		            filesToMerge.forEach((ff) -> {
		                try {
		                	//System.out.println("adding file: " + FilenameUtils.removeExtension(ff.getName()) );
		                    builder.addBinaryBody("files",new FileInputStream(ff),ContentType.APPLICATION_OCTET_STREAM,ff.getName());
		                    
		                } catch (IOException e) {
		                    System.out.println(e.getLocalizedMessage());
		                }
		            });
	          
		          
		            for (int i = 0; i < filesToMerge.size(); i ++) {
		                // i is the index
		                // yourArrayList.get(i) is the element
		            	File ff=filesToMerge.get(i);
		            	String bookmark="";
		            	String booki="";
		            	
		            	bookmark= FilenameUtils.removeExtension(ff.getName());
	                	bookmark = bookmark.substring(0, bookmark.lastIndexOf('_'));
	                	if (i!=0) 
		                	booki=FilenameUtils.removeExtension(filesToMerge.get(i-1).getName()).substring(0, FilenameUtils.removeExtension(filesToMerge.get(i-1).getName()).lastIndexOf('_'));
		                try {     	
		                	if  (Boolean.FALSE.equals(bookmark.equalsIgnoreCase(booki))) {
		                		//System.out.println("adding bookmark for:" + nameMergedFile);
		                		builder.addTextBody("bookmarks",bookmark, ContentType.TEXT_PLAIN);
		                	} else {
		                		builder.addTextBody("bookmarks","___", ContentType.TEXT_PLAIN);
		                	}
		                } catch (Exception e) {
		                    System.out.println(e.getLocalizedMessage());
		                }
	                	
	                	
		            }
		            
		            
		            	//	);
		            //System.out.println("Going to processs");
		            HttpEntity multipart = builder.build();    
		            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
		                HttpPost uploadFile = new HttpPost("http://"+ uriWP +"/wipopublish-api-files/api/files/pdf/merge");
		                File finalFile = new File (outputFolder + File.separator + nameMergedFile+".pdf");
		                try {
		                    uploadFile.setEntity(multipart);
		                    CloseableHttpResponse response = httpClient.execute(uploadFile);
		                   Header[] headers = response.getAllHeaders();
				for (Header h : headers) {
					
		                        if(h.getName().equals("Content-Type")) {
		                            
		                            //System.out.println(">>>>>>>>>>>>"+h.getValue().toString());
		                            //HttpEntity responseEntity = response.getEntity();
	                                
	                                
	                                //System.out.println(IOUtils.toString(responseEntity.getContent(),"utf8"));
		                            if (!h.getValue().equalsIgnoreCase("application/pdf")) {
		                            	System.out.println("One of the PDFs to merge has an issue, please check. " + folderToMerge);
		                                HttpEntity responseEntity = response.getEntity();
		                                
		                                
		                                System.out.println(IOUtils.toString(responseEntity.getContent(),"utf8"));
		                                httpClient.close();
		                                return false;
		                            } else {
		                                HttpEntity responseEntity = response.getEntity();
		                                FileOutputStream fos;
		                                try (InputStream is = responseEntity.getContent()) {
		                                    fos = new FileOutputStream(finalFile);
		                                    int inByte;
		                                    while((inByte = is.read()) != -1)
		                                        fos.write(inByte);
		                                }
		                                fos.close();
		                                httpClient.close();
		                                //System.out.println("downloading complete.");
		                                return true;
		                            }
		                            
		                        }
		                          /*
		                                 System.out.print("Names --->" + h.getName() );
		                                System.out.print("values --->" +h.getValue());
		                                
		                                if (h.getValue().equalsIgnoreCase("application/pdf")) {
		                                logger.warn ("One of the PDFs to merge has an issue, please check.");
		                                httpClient.close();
		                                return false;
		                                
		                                */
		                            
		                        
		                }
		                } catch (IOException e) {
		                    System.out.println("Couldn't download the merged file");
		                    finalFile.delete();
		                    httpClient.close();
		                    return false;
		                
		                }
		                }
		                
		        return true;
		        
		        }
		   
	
	
    public static  boolean convertTiffToPdf(String uriWP,String fileToConvert, String namePdfFile, String outputFolder)
    	    throws  IOException {
    	            new File(outputFolder).mkdirs();
    	            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    	            //adding file
    	            try {
    	            	builder.addBinaryBody("file",new FileInputStream(new File (fileToConvert)),ContentType.APPLICATION_OCTET_STREAM,new File (fileToConvert).getName());
    	            	builder.addTextBody("watermarkContent", "" , ContentType.TEXT_PLAIN);
    	            } catch (Exception e) {
	                    //logger.warn(e);
    	            	System.out.println(e.getLocalizedMessage());
	                }
    	               	            
    	            //System.out.println("Going to processs");
    	            HttpEntity multipart = builder.build();    
    	            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
    	                HttpPost uploadFile = new HttpPost("http://"+ uriWP +"/wipopublish-api-files/api/files/transform/to/pdf");
    	                File finalFile = new File (outputFolder + File.separator + namePdfFile);
    	                try {
    	                    uploadFile.setEntity(multipart);
    	                    CloseableHttpResponse response = httpClient.execute(uploadFile);
    	                   Header[] headers = response.getAllHeaders();
    			for (Header h : headers) {
    				
    	                        if(h.getName().equals("Content-Type")) {
    	                            
    	                            //System.out.println(">>>>>>>>>>>>"+h.getValue().toString());
    	                            if (!h.getValue().equalsIgnoreCase("application/pdf")) {
    	                                System.out.println("One of the PDFs to merge has an issue, please check.");
    	                                HttpEntity responseEntity = response.getEntity();
    	                                
    	                                
    	                                System.out.println(IOUtils.toString(responseEntity.getContent(),"utf8"));
    	                                httpClient.close();
    	                                return false;
    	                            } else {
    	                                HttpEntity responseEntity = response.getEntity();
    	                                FileOutputStream fos;
    	                                try (InputStream is = responseEntity.getContent()) {
    	                                    fos = new FileOutputStream(finalFile);
    	                                    int inByte;
    	                                    while((inByte = is.read()) != -1)
    	                                        fos.write(inByte);
    	                                }
    	                                fos.close();
    	                                httpClient.close();
    	                                return true;
    	                            }
    	                            
    	                        }
    	                             	                            
    	                        
    	                }
    	                } catch (IOException e) {
    	                	System.out.println("Couldn't download the transformed file");
    	                    finalFile.delete();
    	                    httpClient.close();
    	                    return false;
    	                
    	                }
    	                }
    	                
    	        return true;
    	        
    	        }
    	   
}
