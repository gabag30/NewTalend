package routines;

import com.lowagie.text.Image;

import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;

import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.codec.TiffImage;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BadPdfFormatException;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfDestination;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfOutline;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.SimpleBookmark;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import org.apache.commons.io.FileUtils;

//import org.apache.pdfbox.multipdf.PDFMergerUtility;
//import org.apache.pdfbox.pdmodel.PDDocument;
  
import java.io.File; 
import java.io.IOException;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.ghost4j.Ghostscript;
import org.ghost4j.GhostscriptException;


/**
 *
 * @author gabriel
 */
public class PdfOperations {
    
    protected static DocumentIndexation index; 
    public static File pdfFolder;//=OcrServer.pdfFolder;
    public static File tempFolder;//=OcrServer.tempFolder;
   
    static File pdfApplFolder;
   
    public static File convertZippedTiffToIndexedPdf (File zipFile, String docID, String applNum) {
        try {
            
            //pdfFolder.mkdirs();
            
            File temporal=new File(tempFolder + 
                            File.separator + 
                            applNum + 
                            File.separator + docID);
            
            temporal.mkdirs();
            //System.out.println(temporal.getCanonicalPath());
            PdfOperations.extractAllFromZip(zipFile, temporal.getCanonicalPath());
            pdfApplFolder=new File(pdfFolder + File.separator + "App-"+applNum);
            pdfApplFolder.mkdirs();
            PdfOperations.createPdfFromFolder(temporal,applNum + "_" + docID);
            FileUtils.deleteDirectory(temporal);
            return pdfApplFolder;
        
        
        
        } catch (IOException | DocumentException e) {
            System.out.println("Erro while trying to unzip a file.");
            System.out.println("error: " + e.getLocalizedMessage());
        }
                
   
        
        return null;
    }
    
 


    public static byte[] mergePDF(List<InputStream> list, File singlePdf)
    throws DocumentException, IOException {
        try (OutputStream outputStream = new FileOutputStream(singlePdf)) {
            int pageOffset = 0;
            ArrayList masterBookMarkList = new ArrayList();
            
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            for (InputStream in : list) {
                PdfReader reader = new PdfReader(in);
                int totalPages = reader.getNumberOfPages();
                List bookmarks= SimpleBookmark.getBookmark(reader);
                if (bookmarks != null) {
                    if (pageOffset != 0)
                        SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset,null);
                    masterBookMarkList.addAll(bookmarks);
                }
                pageOffset += totalPages;
                for (int i = 1; i <= totalPages; i++) {
                    document.newPage();
                    // import the page from source pdf
                    PdfImportedPage page = writer.getImportedPage(reader, i);
                    // add the page to the destination pdf
                    cb.addTemplate(page, 0, 0);
                }
            }
            outputStream.flush();
            if (!masterBookMarkList.isEmpty())
                writer.setOutlines(masterBookMarkList);
            document.close();
        } catch (Exception e) {
            System.out.println("Error while merging PDFs: " + e.getLocalizedMessage());
        }
        byte[] array = Files.readAllBytes(singlePdf.toPath());
        singlePdf.delete();
        return array;
    }
   
    public static File mergeListOfPdf(List<InputStream> list, File singlePdf, List bm)
    	    throws DocumentException, IOException {
    	        try (OutputStream outputStream = new FileOutputStream(singlePdf)) {
    	            int pageOffset = 0;
    	            ArrayList masterBookMarkList = new ArrayList();
    	            
    	            Document document = new Document();
    	            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
    	            document.open();
    	            PdfContentByte cb = writer.getDirectContent();
    	            for (InputStream in : list) {
    	                PdfReader reader = new PdfReader(in);
    	                int totalPages = reader.getNumberOfPages();
    	                for (int i = 1; i <= totalPages; i++) {
    	                    document.newPage();
    	                    // import the page from source pdf
    	                    PdfImportedPage page = writer.getImportedPage(reader, i);
    	                    // add the page to the destination pdf
    	                    cb.addTemplate(page, 0, 0);
    	                }
    	                in.close();
    	            }
    	            outputStream.flush();
    	            writer.setOutlines(bm);
    	            document.close();
    	        } catch (Exception e) {
    	            System.out.println("Error while merging PDFs: " +e.getLocalizedMessage());
    	        }
    	        return singlePdf;
    	    }
    	    
    	    
    	    
    
    
    public static List getBookmarksFromPdf(File singlePdf)
    throws DocumentException, IOException  {
        List<HashMap<String,Object>> bookmarks;
        try (FileInputStream in = new FileInputStream (singlePdf)) {
            PdfReader reader = new PdfReader(in);
            bookmarks = SimpleBookmark.getBookmark(reader);
            
            reader.close();
        }
        return bookmarks;
    }

    
    
    
    
    /*
    public boolean putBookmarksInPdf(File singlePdf, List bookmarks)
    throws DocumentException, IOException  {
        ArrayList masterBookMarkList = new ArrayList();
        masterBookMarkList.addAll(bookmarks);
        FileInputStream in = new FileInputStream (singlePdf);
        PdfReader reader = new PdfReader(in);
        List bookmarks= SimpleBookmark.getBookmark(reader);
        reader.close();
        in.close();
        return false;
    }
    */
    
    public static File[] printPDFToSingleTiff (File PDFFile, File DestinationFolder) {
        
         //get Ghostscript instance
        Ghostscript gs = Ghostscript.getInstance();
        //prepare Ghostscript interpreter parameters
        //refer to Ghostscript documentation for parameter usage
        String[] gsArgs = new String[14];
        gsArgs[0] = "-dQUIET";
        gsArgs[1] = "-dNOPAUSE";
        gsArgs[2] = "-sPAPERSIZE=a4";
        gsArgs[3] = "-g2479x3508";
        gsArgs[4] = "-dPDFFitPage";
        gsArgs[5] = "-dBATCH";
        gsArgs[6] = "-dSAFER";
        
        gsArgs[7] = "-sDEVICE=tiffg4";
        gsArgs[8] = "-r300x300";
        
        gsArgs[9] = "-sOutputFile=" + DestinationFolder.toString() + "/" + "%06d.tif";
        gsArgs[10] = "-c";
        gsArgs[11] = "save";
        gsArgs[12] = "-f";
        gsArgs[13] = PDFFile.toString();
        //execute and exit interpreter
        try {
            gs.initialize(gsArgs);
            gs.exit();
        } catch (GhostscriptException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        //output File[] to keep absolute path information
        File [] results = DestinationFolder.listFiles();
        return results;
    }
    
    
    public static void singleTiffToPDF (String item, String destination, String finalFileName) throws DocumentException,IOException {
            Document docu = new Document(PageSize.A4);
            new File(destination).mkdirs();
            FileOutputStream str= new FileOutputStream(destination + 
                    File.separator + finalFileName +".pdf");
            PdfWriter wri = PdfWriter.getInstance(docu,str);
            docu.setPageSize(new Rectangle(PageSize.A4.getWidth(),PageSize.A4.getHeight()));
            docu.open();
            RandomAccessFileOrArray ra1 = new RandomAccessFileOrArray(new File(item).getCanonicalPath());
            Image ima = TiffImage.getTiffImage(ra1, 1);
            
            ima.scaleToFit(PageSize.A4.getWidth(),PageSize.A4.getHeight());
            ima.setAbsolutePosition(0, 0);
            docu.add(ima);
            ra1.close();
            docu.close();
            wri.close();
            str.close();
        }
    
    public static void createSymLink (String item, String destination, String finalFileName) throws DocumentException,IOException {
       
        new File(destination).mkdirs();
        FileOutputStream str= new FileOutputStream(destination + 
                File.separator + finalFileName +".pdf");
       
    }
    
    public static void tiffToPDF (String item, String destination, String finalFileName) throws DocumentException,IOException {
		RandomAccessFileOrArray myTifFile = null;
		Document tiffToPDF= null;
		PdfWriter pdfWriter = null;
		File destFolder=new File (destination);
		destFolder.mkdirs();
		try{
			myTifFile = new RandomAccessFileOrArray(new File(item).getCanonicalPath());
			int numberOfPages = TiffImage.getNumberOfPages(myTifFile);
			tiffToPDF = new Document(PageSize.A4);      
			pdfWriter = PdfWriter.getInstance(tiffToPDF, new FileOutputStream(destination + 
                    File.separator + finalFileName +".pdf"));
			pdfWriter.setStrictImageSequence(true);
			tiffToPDF.open();
			for(int tiffImageCounter = 1;tiffImageCounter <= numberOfPages;tiffImageCounter++) 
				 {
					Image img = TiffImage.getTiffImage(myTifFile, tiffImageCounter);

					img.setAbsolutePosition(0,0);

					img.scaleAbsolute(PageSize.A4.getWidth(),PageSize.A4.getHeight());

					tiffToPDF.add(img);
					if (tiffImageCounter < numberOfPages) 
						tiffToPDF.newPage();
				} 

		} catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
		}
    }
    
    public static boolean extractAllFromZip(File zipToModify,String Destination) {
        try {
            File dir = new File (Destination);
            dir.mkdirs();
            ZipFile zipFile = new ZipFile(zipToModify);       
            zipFile.extractAll(Destination);
        } catch (ZipException e) {
            System.out.println("Zip exception"+ e.getLocalizedMessage());
        }
        return true;
    }
    
    public static File createPdfFromFolder (File folderToConvert, String fileName) throws DocumentException,IOException {
        
        
        int end=folderToConvert.getName().lastIndexOf("-");
        String nameOfBookmark=folderToConvert.getName().substring(0, (end));
        int typeStart=nameOfBookmark.indexOf("-");
        String type=nameOfBookmark.substring(typeStart+1);
        String docDate=folderToConvert.getName().substring(end+1);
                
        //System.out.println(folderToConvert.getName() + "--"+ nameOfBookmark+"--"+type);
                
        Document document = new Document(PageSize.A4);
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(pdfApplFolder +File.separator + docDate + "_" + type  + ".pdf"));
        document.setPageSize(new Rectangle(2480,3508));
        document.open();
        PdfContentByte cb = copy.getDirectContent();
        PdfOutline root = cb.getRootOutline();
        PdfReader reader;
        
        String typeDossier=type;
        String currentBookmark="";
        DossierInfo.init();
        Integer docType=Integer.parseInt(type);
        try {
            typeDossier=DossierInfo.getDocumentTypeName(docType);
        }
        catch (NumberFormatException e) {
            System.out.println("Number format exception."+ e.getLocalizedMessage());
        }
        int j=1;
        File indexation = new File(folderToConvert + "/" + "indexation.lst");
        index = DocumentIndexation.getNewDocumentIndexation(typeDossier);
        
        System.out.println("Finding doc type for: " + typeDossier);
        PdfOutline oline2= new PdfOutline(root, 
                    PdfAction.gotoLocalPage((1), 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,typeDossier + " Fecha: " + docDate);
        oline2.setOpen(true);
        /*
        PdfOutline section0 = new PdfOutline(oline2, 
        PdfAction.gotoLocalPage(1, 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,typeDossier + " Fecha: " + docDate);
        */
        List<File> files = (List<File>) FileUtils.listFiles(folderToConvert, new String[] { "tif", "TIF"}, true);
        
        for (File item : files) {
           try {
                System.out.println("Starting to process page: " + j);
                index.readDocumentIndexation(item.getParent());
                String character=index.getIndexation(item.getName());
                if (character != null && !character.isEmpty()){
                    currentBookmark = DocumentSection.getLongName(character.charAt(0));
                    if (!currentBookmark.matches("Hoj.*?")){
                        System.out.println("Found new section: " + currentBookmark + " affecting page " + j);
                        PdfOutline section1 = new PdfOutline(oline2, 
                        PdfAction.gotoLocalPage(j, 
                        new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                        ,currentBookmark);
                    }
                } 
                copy=addTiffToPdfNoText(item,copy);
                /*
                if (!currentBookmark.equals("Dibujos")){ 
                    String fileN = item.getName().substring(0,item.getName().length()-4);
                    File pdfWText;
                    pdfWText = doOcr(item, fileN, nameOfBookmark.substring(0,typeStart), currentBookmark, j);
                    if (null!=pdfWText){
                        System.out.println(pdfWText.toString());
                        reader = new PdfReader(pdfWText.getAbsolutePath());
                        copy.addPage(copy.getImportedPage(reader, 1));
                        copy.freeReader(reader);
                        reader.close();
                    } else {
                        //"Empty page!!" from tesseract
                        copy=addTiffToPdfNoText(item,copy);
                    }
                } else {
                    copy=addTiffToPdfNoText(item,copy);
                } 
                */
                
            } catch ( Exception e) {
                System.out.println("Algo raro paso."+ e.getLocalizedMessage());
            }
            j++;
        }

//add front page
        /*
        reader = new PdfReader(frontPage.getAbsolutePath());
        copy.setPageSize(new Rectangle(2480,3508));
        copy.addPage(copy.getImportedPage(reader, 1));
        copy.freeReader(reader);
        reader.close();
        */
        
        
        
        document.close();
        
        return new File(pdfApplFolder +File.separator + type + "_" + docDate + ".pdf");
    }
    
    
    public static File createPdfFromFolderWithBookMarks (File folderToConvert, String fileName,List bookmarks) throws DocumentException,IOException {
        
        
        int end=folderToConvert.getName().lastIndexOf("-");
        
        String nameOfBookmark=folderToConvert.getName().substring(0, (end));
        
        int typeStart=nameOfBookmark.indexOf("-");
        String type=nameOfBookmark.substring(typeStart+1);
        String docDate=folderToConvert.getName().substring(end+1);
                
        //System.out.println(folderToConvert.getName() + "--"+ nameOfBookmark+"--"+type);
                
        Document document = new Document(PageSize.A4);
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(folderToConvert +File.separator + fileName  + ".pdf"));
        document.setPageSize(new Rectangle(2480,3508));
        document.open();
        PdfContentByte cb = copy.getDirectContent();
        PdfOutline root = cb.getRootOutline();
        PdfReader reader;
        
        String typeDossier=type;
        String currentBookmark="";
        DossierInfo.init();
        Integer docType=Integer.parseInt(type);
        try {
            typeDossier=DossierInfo.getDocumentTypeName(docType);
        }
        catch (NumberFormatException e) {
            System.out.println("Number format exception."+ e.getLocalizedMessage());
        }
        int j=1;
        File indexation = new File(folderToConvert + "/" + "indexation.lst");
        index = DocumentIndexation.getNewDocumentIndexation(typeDossier);
        
        System.out.println("Finding doc type for: " + typeDossier);
        PdfOutline oline2= new PdfOutline(root, 
                    PdfAction.gotoLocalPage((1), 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,typeDossier + " Fecha: " + docDate);
        oline2.setOpen(true);
        /*
        PdfOutline section0 = new PdfOutline(oline2, 
        PdfAction.gotoLocalPage(1, 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,typeDossier + " Fecha: " + docDate);
        */
        List<File> files = (List<File>) FileUtils.listFiles(folderToConvert, new String[] { "tif", "TIF"}, true);
        
        for (File item : files) {
           try {
                System.out.println("Starting to process page: " + j);
                index.readDocumentIndexation(item.getParent());
                String character=index.getIndexation(item.getName());
                if (character != null && !character.isEmpty()){
                    currentBookmark = DocumentSection.getLongName(character.charAt(0));
                    if (!currentBookmark.matches("Hoj.*?")){
                        System.out.println("Found new section: " + currentBookmark + " affecting page " + j);
                        PdfOutline section1 = new PdfOutline(oline2, 
                        PdfAction.gotoLocalPage(j, 
                        new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                        ,currentBookmark);
                    }
                } 
                copy=addTiffToPdfNoText(item,copy);
                /*
                if (!currentBookmark.equals("Dibujos")){ 
                    String fileN = item.getName().substring(0,item.getName().length()-4);
                    File pdfWText;
                    pdfWText = doOcr(item, fileN, nameOfBookmark.substring(0,typeStart), currentBookmark, j);
                    if (null!=pdfWText){
                        System.out.println(pdfWText.toString());
                        reader = new PdfReader(pdfWText.getAbsolutePath());
                        copy.addPage(copy.getImportedPage(reader, 1));
                        copy.freeReader(reader);
                        reader.close();
                    } else {
                        //"Empty page!!" from tesseract
                        copy=addTiffToPdfNoText(item,copy);
                    }
                } else {
                    copy=addTiffToPdfNoText(item,copy);
                } 
                */
                
            } catch ( Exception e) {
                System.out.println("Algo raro paso."+ e.getLocalizedMessage());
            }
            j++;
        }

//add front page
        /*
        reader = new PdfReader(frontPage.getAbsolutePath());
        copy.setPageSize(new Rectangle(2480,3508));
        copy.addPage(copy.getImportedPage(reader, 1));
        copy.freeReader(reader);
        reader.close();
        */
        
        
        
        document.close();
        
        return new File(pdfApplFolder +File.separator + type + "_" + docDate + ".pdf");
    }
    
public static void createPdfFromListOfTiffFilesWithBookMarks (ArrayList<String> listOfTiffs, String finalLocation, 
		String fileName,ArrayList<String>  bookmarks) throws DocumentException,IOException {
		Document document = new Document(PageSize.A4);
        File finalPdf = new File (finalLocation +File.separator + fileName  + ".pdf");
        
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(finalPdf));
        document.open();
        document.setPageSize(new Rectangle(2480,3508));
        
        
        PdfContentByte cb = copy.getDirectContent();
        PdfOutline root = cb.getRootOutline();
        
        PdfReader reader;
        int j=0;
        /*PdfOutline oline2= new PdfOutline(root, 
                    PdfAction.gotoLocalPage((1), 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,"Expediente N°: " + fileName);
        
        oline2.setOpen(true);*/
        System.out.println(listOfTiffs.size());
        for (String item2 : listOfTiffs) {
        	File item = new File (item2);
           try {
        	   //if (item.exists()) {
	                System.out.println("Starting to process page: " + j);
	                String localBook = bookmarks.get(j).toString(); 
	                if (!localBook.isEmpty() && localBook!=""){
		        	    //System.out.println("Found new section: " + bookmarks.get(j) + " affecting page " + j);
			            try {
			        	    PdfOutline section1 = new PdfOutline(root, 
				               PdfAction.gotoLocalPage(j+1, 
				               new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
			               ,bookmarks.get(j).toString());
			        	    
			            } catch (Exception e) {
			            	System.out.println("problema con el bookmark");
			            }
	                }
	       
	                copy=addTiffToPdfNoText(item,copy);

        	  
                
            } catch ( Exception e) {
                System.out.println("Algo raro paso."+ e.toString());
                e.printStackTrace();
                System.exit(2);
               // copy.close();
     		   //document.close();
     		   
     		   //FileUtils.deleteQuietly(finalPdf);
            }
            j++;
        }        
        
        copy.close();
        document.close();
        
        //return new File(pdfApplFolder +File.separator + type + "_" + docDate + ".pdf");
    }
    
    
    public static void ocrImagesFromFile(List<File> args, File frontPage,String name, String applNum, String fileName, String DocID) throws DocumentException,
            IOException  {
        Document document = new Document(PageSize.A4);
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(name + fileName));
        document.setPageSize(new Rectangle(2480,3508));
        document.open();
        PdfContentByte cb = copy.getDirectContent();
        PdfOutline root = cb.getRootOutline();
        PdfReader reader;
        int end=DocID.lastIndexOf("-");
        String nameOfBookmark=DocID.substring(0, (end));
        int typeStart=nameOfBookmark.indexOf("-");
        String type=nameOfBookmark.substring(typeStart+1);
        String typeDossier=type;
        String currentBookmark="";
        try {
            typeDossier=DossierInfo.getDocumentTypeName(Integer.parseInt(type));
        }
        catch (NumberFormatException e) {
            System.out.println("Number format exception."+ e.getLocalizedMessage());
        }
        //add front page
        int j=1;
        reader = new PdfReader(frontPage.getAbsolutePath());
        copy.setPageSize(new Rectangle(2480,3508));
        copy.addPage(copy.getImportedPage(reader, 1));
        copy.freeReader(reader);
        reader.close();
        System.out.println("Finding doc type for: " + typeDossier);
        PdfOutline oline2= new PdfOutline(root, 
                    PdfAction.gotoLocalPage((1), 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,typeDossier + " N°: " + applNum);
        oline2.setOpen(true);
        PdfOutline section0 = new PdfOutline(oline2, 
        PdfAction.gotoLocalPage(1, 
                    new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                    ,"Primera página");
        //-----------------------------
        File indexation = new File(args.get(0).getParent() + "/" + "indexation.lst");
        index = DocumentIndexation.getNewDocumentIndexation(typeDossier);
        j++;                
        for (File item : args) {
           try {
                System.out.println("Starting to process page: " + j);
                index.readDocumentIndexation(item.getParent());
                String character=index.getIndexation(item.getName());
                if (character != null && !character.isEmpty()){
                    currentBookmark = DocumentSection.getLongName(character.charAt(0));
                    if (!currentBookmark.matches("Hoj.*?")){
                        System.out.println("Found new section: " + currentBookmark + " affecting page " + j);
                        PdfOutline section1 = new PdfOutline(oline2, 
                        PdfAction.gotoLocalPage(j, 
                        new PdfDestination(PdfDestination.XYZ, -1, 10000, 0), copy)
                        ,currentBookmark);
                    }
                } 
                if (!currentBookmark.equals("Dibujos")){ 
                    String fileN = item.getName().substring(0,item.getName().length()-4);
                    File pdfWText;
                    pdfWText = doOcr(item, fileN, applNum, currentBookmark, j);
                    if (null!=pdfWText){
                        reader = new PdfReader(pdfWText.getAbsolutePath());
                        copy.addPage(copy.getImportedPage(reader, 1));
                        copy.freeReader(reader);
                        reader.close();
                    } else {
                        //"Empty page!!" from tesseract
                        copy=addTiffToPdfNoText(item,copy);
                    }
                } else {
                    copy=addTiffToPdfNoText(item,copy);
                } 
            } catch (BadPdfFormatException | IOException e) {
                System.out.println("Algo raro paso."+ e.getLocalizedMessage());
            }
            j++;
        }
        copy.close();
        document.close();
    }
    
    private static PdfCopy addTiffToPdfNoText (File item,PdfCopy copy)  {
        try {
    	Document document2 = new Document(PageSize.A4);
        
        try {
        	System.out.println(item.getAbsolutePath());
        RandomAccessFileOrArray ra = new RandomAccessFileOrArray(item.getAbsolutePath());
        
        try {
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	try {
        PdfWriter writer = PdfWriter.getInstance(document2, baos);
        writer.setStrictImageSequence(true);
        document2.open();
        try{
		    Image image = TiffImage.getTiffImage(ra, 1);
		    image.scaleToFit(PageSize.A4.getWidth(),PageSize.A4.getHeight());
		    image.setAbsolutePosition(0, 0);
		    document2.add(image);
		    document2.close();
		    
        } catch (Exception e) {
        	System.out.println("el problem es con el tiff");
        }
        
        try {
	        PdfReader reader=new PdfReader(baos.toByteArray());
	        copy.addPage(copy.getImportedPage(reader, 1));
	        copy.freeReader(reader);
	        reader.close();
	        return copy;
        } catch (Exception ee) {
        	System.out.println("el problema es aqui con el reader" );
        	ee.printStackTrace();
        	System.exit(1);
        }
        baos.close();
	    ra.close();
        	} catch (Exception ee) {
            	System.out.println("el problema es aqui con el siguiente al  byte array");
            	ee.printStackTrace();
            	System.exit(1);
        	}
        	
        } catch (Exception ee) {
        	System.out.println("el problema es aqui con el byte array");
        	ee.printStackTrace();
        	System.exit(1);
        }
        
        } catch (Exception ee) {
        	System.out.println("el problema es aqui con el random access");
        	ee.printStackTrace();
        	System.exit(1);
        }
       
        } catch (Exception ee) {
        	System.out.println("el problema es aqui es con lo de arrriba");
        	ee.printStackTrace();
        }
        return null;
    }
    
    
    private static File doOcr (File item, String fileN, String applNum, String currentBookmark, Integer j) {
        /*
        try {
            //System.out.println(item.toString());
            //System.out.println("Processing page: " +  fileN);
            //String oci= instance.doOCR(item);
            //System.out.println(oci);
            
        instance.createDocuments(
                    item.toString(),
                    fileN, 
                    item.getParent(),
                    formats);
            
        } catch (IOException e){
            System.out.println("IO exception."+ e.getLocalizedMessage());
            //Empty page!! exception
            return null;
        }
        */
        if (currentBookmark.equals("Reivindicaciones")|| currentBookmark.equals("Memoria Descriptiva")){
            try{  
                String pageTextHtml = FileUtils.readFileToString(new File(item.getParent() +File.separator + fileN +".hocr"));
                String pageText = FileUtils.readFileToString(new File(item.getParent() +File.separator + fileN +".txt"));
                //System.out.println(item.getParent() +File.separator + fileN +".txt");
                pageText=pageText.replace("\"", "");
                pageText=pageText.replace("\'", "");
                pageText=pageText.replace("Á", "A");
                pageText=pageText.replace("É", "E");
                pageText=pageText.replace("Í", "I");
                pageText=pageText.replace("Ó", "O");
                pageText=pageText.replace("Ú", "U");
                //pageText=pageText.replaceAll("([^A-Za-z0-9 ])\\1+","");
                //di.setPageText(applNum,(j),currentBookmark + "-html",StringEscapeUtils.escapeXml11(pageTextHtml));
                //di.setPageText(applNum,(j),currentBookmark + "-text",StringEscapeUtils.escapeXml11(pageText));
            } catch (IOException e) {
               System.out.println(e.getLocalizedMessage());
            }
        }
        return new File(item.getParent(), item.getName().substring(0,item.getName().length()-4) + ".pdf");
    }

    	
    
	
    
    
}
