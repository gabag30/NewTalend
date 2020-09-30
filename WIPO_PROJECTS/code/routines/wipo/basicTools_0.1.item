package routines;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author gabag
 */
public class basicTools {
    static Logger logger = Logger.getLogger(basicTools.class);
    public File folderToProcess = null;
    public String ip_WP = null;
    public String port_WP = null;
    public Properties props = null;
    public File outputFolder = null;
    public File resultsFolder = null;
    public File processedFolder = null;
     
    public static void main(String[] args) throws IOException{
    
        /*
        loadConfiguration pm = new loadConfiguration();
        File cf = new File (System.getProperty("user.dir") + "/config/PdfMerge.properties");
        if (cf.exists()) {
        pm.loadConfiguration(cf,args[1]);
  
        }
        */
     }   
       public void loadConfiguration  (File configFile) throws IOException {
        this.props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(configFile);
            this.props.load(fis);
            this.folderToProcess = new File(this.props.getProperty("source_Folder"));
            this.outputFolder = new File (this.props.getProperty("output_Folder"));
            this.resultsFolder = new File (outputFolder +File.separator + "results");
            this.processedFolder = new File (outputFolder +File.separator + "processed");
            this.ip_WP = this.props.getProperty("WP_ipAddress");
            this.port_WP = this.props.getProperty("WP_port"); 
            resultsFolder.mkdirs();
            processedFolder.mkdirs();
        } catch (IOException e2) {
            logger.info("missing PdfMerge.properties!!!",e2);
        }
        
    }
       public  List<File> getSubdirs(File file) {
        List<File> subdirs = Arrays.asList(file.listFiles(File::isDirectory));
        subdirs = new ArrayList<>(subdirs);
        List<File> deepSubdirs = new ArrayList<>();
        for(File subdir : subdirs) {
            deepSubdirs.addAll(getSubdirs(subdir)); 
        }
        subdirs.addAll(deepSubdirs);
        return subdirs;
    } 
       public  boolean moveFolders (File sourceFolder, File destinationFolder) {
           try {
                FileUtils.copyDirectory(sourceFolder, destinationFolder, true);
                //Boolean copySucc = FileUtils.contentEquals(sourceFolder, destinationFolder);
                //if (copySucc.equals(true)) {
                    FileUtils.deleteDirectory(sourceFolder);
                    logger.info("Folder: " + sourceFolder.getName() + " moved to " + destinationFolder);
                    return true;
                //} else {
                  //  logger.warn ("Couldn't move the folder " + sourceFolder.getName() + " to the Processed Folder. Please check!");
                   // return false;
                //}
            } catch (IOException e10) {
                      logger.warn ("Exception while moving the folder " + sourceFolder.getName(),e10);
                      return false;
                  }
       }
       @SuppressWarnings("empty-statement")
    public  String getBookMarkNameFromFile (File filecito,File configFile) {
        //System.out.println(">>>>>"+filecito.getName());
        String name = FilenameUtils.removeExtension(filecito.getName()).replaceAll("[0-9]", "") ;//.substring(0,substring(0, str.lastIndexOf('.'))).replaceAll("[0-9]", "");
        //System.out.println(">>>>>"+name);
        this.props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(configFile);
            this.props.load(fis);
            String bookmark = this.props.getProperty(name);
            if (!bookmark.isEmpty())
                return bookmark;
            return "--";
        } catch (IOException e){
            logger.warn ("couldn't get a bookmark");
            return "--";
        } 
    }
    public  String getBookMarkNameFromString (String name,File configFile) {
        name = name.substring(-4).replaceAll("[0-9]", "");
        this.props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(configFile);
            this.props.load(fis);
            String bookmark = this.props.getProperty(name);
            if (!bookmark.isEmpty())
                return bookmark;
            return "--";
        } catch (IOException e){
            logger.warn ("couldn't get a bookmark");
            return "--";
        } 
    }
    
    public static byte[] ByteArrayFromFile(String filePath) {
		try {
		System.out.println(filePath);	
    	File file = new File(filePath);
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
				
			System.out.println("File "+file+" cannot be opened.");
			e.printStackTrace();
		}
		
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = "Any String you want".getBytes();;
        
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
        	System.out.println("Couldn't load the file");
        	
        	System.out.println(ex);
        }
        fis.close();
        byte[] bytes = bos.toByteArray();
        return bytes;
        
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
}

}

