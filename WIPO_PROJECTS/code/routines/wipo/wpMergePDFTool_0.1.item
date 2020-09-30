package routines;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import routines.basicTools;
import routines.wpTools;


/**
 *
 * @author gabag
 */
public class wpMergePDFTool {
    static Logger logger = Logger.getLogger(wpMergePDFTool.class);
    public File folderToProcess = null;
    public String ip_WP = null;
    public String port_WP = null;
    public Properties props = null;
    public File outputFolder = null;
    public File resultsFolder = null;
    public File processedFolder = null;
    
    public static void main(String[] args) throws IOException{
        
        try {
            Properties props1 = new Properties();
            props1.load(new FileInputStream("log4j.properties"));
            PropertyConfigurator.configure(props1);
        } catch (IOException e1) {
            System.out.println("missing log4j.properties!!!" + e1.getLocalizedMessage());
        }
        logger.info("Working Directory = " +System.getProperty("user.dir"));
        basicTools pm = new basicTools();
        File cf = new File (System.getProperty("user.dir") + "/config/PdfMerge.properties");
        if (cf.exists()) {
            pm.loadConfiguration(cf);
            List<File> listF = pm.getSubdirs(pm.folderToProcess);
            Integer totalFiles = listF.size();
            logger.warn("Total files to process: " + totalFiles); 
            for(File o : listF) {
                logger.warn("Folder to process: " + o);
                List<File> files = (List<File>) FileUtils.listFiles(o, new String[] { "pdf", "PDF"}, false);
                //System.out.println(files.toString());
                if (!files.isEmpty() ) {
                    Boolean pdfGen = wpTools.listOfPdfToMerge(pm.ip_WP + ":" + pm.port_WP,files, o.getName()+ ".pdf",pm.resultsFolder);
                    if (pdfGen.equals(true)){
                        pm.moveFolders(o,new File (pm.processedFolder + File.separator+o.getName()));
                    }
                    logger.warn("Still " + (--totalFiles) +" folders to go.");
                }
            }
        } else {
            logger.warn("Configuration file not found.");
        }
    } 
    /*
    public static  List<File> getSubdirs(File file) {
        List<File> subdirs = Arrays.asList(file.listFiles(File::isDirectory));
        subdirs = new ArrayList<>(subdirs);
        List<File> deepSubdirs = new ArrayList<>();
        for(File subdir : subdirs) {
            deepSubdirs.addAll(getSubdirs(subdir)); 
        }
        subdirs.addAll(deepSubdirs);
        return subdirs;
    }  
    
    public void loadConfiguration  (File configFile, String folder) throws IOException {
        this.props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(configFile);
            this.props.load(fis);
            this.folderToProcess = new File(folder);
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

    */
    
    /*
    public static  boolean listOfPdfToMerge(String uriWP,List<File> filesToMerge, String nameMergedFile, File outputFolder)
    throws  IOException {
            outputFolder.mkdirs();
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //adding files
            filesToMerge.forEach((ff) -> {
                try {
                    builder.addBinaryBody("files",new FileInputStream(ff),ContentType.APPLICATION_OCTET_STREAM,ff.getName());
                } catch (IOException e) {
                    logger.warn(e);
                }
            });
            //adding bookmarks
            filesToMerge.forEach((File ff) -> {
                try {
                    String Booki=pdfMergeTool.getBookMarkName(ff.getCanonicalPath());
                    //Booki=(Booki.isEmpty()) ? "Solicitud" : Booki;
                    logger.warn(Booki);
                    builder.addTextBody("bookmarks", Booki , ContentType.TEXT_PLAIN);
                } catch (IOException e) {
                    logger.warn(e);
                }
            });
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
                            
                            
                            if (!h.getValue().equalsIgnoreCase("application/pdf")) {
                                logger.warn ("One of the PDFs to merge has an issue, please check.");
                                HttpEntity responseEntity = response.getEntity();
                                
                                
                                logger.info(IOUtils.toString(responseEntity.getContent(),"utf8"));
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
                          
                            //     System.out.print("Names --->" + h.getName() );
                              //  System.out.print("values --->" +h.getValue());
                                
                                
                            
                        
                }
                } catch (IOException e) {
                    logger.warn("Couldn't download the merged file");
                    finalFile.delete();
                    httpClient.close();
                    return false;
                
                }
                }
                
        return true;
        
        }
   
        */
      /*  
        @SuppressWarnings("empty-statement")
    public static String getBookMarkName (String name) {
        if (name.matches(".+AZ[^A-Z,a-z].+?"))
                { name="Procedimiento de presentación";}
        else if (name.matches(".+AA[^A-Z,a-z].+?"))
                { name="Presentación";}
        else if (name.matches(".+AB[^A-Z,a-z].+?"))
                { name="Presentación de documentos";}
        else if (name.matches(".+AC[^A-Z,a-z].+?")){ name="Ampliación de termino";}
        else if (name.matches(".+AE[^A-Z,a-z].+?")){ name="Rehabilitación de una solicitud caducada";}
        else if (name.matches(".+AF[^A-Z,a-z].+?")){ name="Prioridad";}
        else if (name.matches(".+AK[^A-Z,a-z].+?")){ name="Presentación de Poder";}
        else if (name.matches(".+AL[^A-Z,a-z].+?")){ name="Providencia de Forma";}
        else if (name.matches(".+AK[^A-Z,a-z].+?")){ name="Providencia de Fondo";}
        else if (name.matches(".+BZ[^A-Z,a-z].+?")){ name="Aviso";}
        else if (name.matches(".+BC[^A-Z,a-z].+?")){ name="Orden de mantener en secreto";}
        else if (name.matches(".+BD[^A-Z,a-z].+?")){ name="Anulación de la orden de mantener en secreto";}
        else if (name.matches(".+CZ[^A-Z,a-z].+?")){ name="Oposición";}
        else if (name.matches(".+CC[^A-Z,a-z].+?")){ name="Oposición Rechazada";}
        else if (name.matches(".+CD[^A-Z,a-z].+?")){ name="Denegación de la Solicitud después de una oposición";}
        else if (name.matches(".+CE[^A-Z,a-z].+?")){ name="Retiro de la solicitud después de la oposición";}
        else if (name.matches(".+CF[^A-Z,a-z].+?")){ name="Objeción del solicitante a la intervención de un tercero";}
        else if (name.matches(".+CH[^A-Z,a-z].+?")){ name="Por ejemplo medios de prueba";}
        else if (name.matches(".+DZ[^A-Z,a-z].+?")){ name="Modificación";}
        else if (name.matches(".+EZ[^A-Z,a-z].+?")){ name="Búsqueda";}
        else if (name.matches(".+EC[^A-Z,a-z].+?")){ name="Búsqueda internacional";}
        
        else if (name.matches(".+FA[^A-Z,a-z].+?")){ name="Archivada sin más tramite";}
        else if (name.matches(".+FB[^A-Z,a-z].+?")){ name="Suspensión del proceso de concesión";}
        else if (name.matches(".+FC[^A-Z,a-z].+?")){ name="Dictamen denegatorio";}
        else if (name.matches(".+FD[^A-Z,a-z].+?")){ name="Nula/caducada";}
        else if (name.matches(".+FG[^A-Z,a-z].+?")){ name="Resolución a otorgar";}
        else if (name.matches(".+FK[^A-Z,a-z].+?")){ name="Certificado";}
        else if (name.matches(".+GZ[^A-Z,a-z].+?")){ name="Situación Legal";}
        else if (name.matches(".+GB[^A-Z,a-z].+?")){ name="Cesión de Inventores,Cambio de titular";}
        else if (name.matches(".+GE[^A-Z,a-z].+?")){ name="Sustitución de Poder";}
        else if (name.matches(".+GC[^A-Z,a-z].+?")){ name="Constancias y Duplicados";}
        else if (name.matches(".+HZ[^A-Z,a-z].+?")){ name="Beneficio a inventor/reducción de tasas";}
        else if (name.matches(".+HA[^A-Z,a-z].+?")){ name="Nombre del Inventor";}
        else if (name.matches(".+HB[^A-Z,a-z].+?")){ name="Corrección de los nombres";}
        else if (name.matches(".+HC[^A-Z,a-z].+?")){ name="Cambio de nombres";}
        else if (name.matches(".+HD[^A-Z,a-z].+?")){ name="Corrección de direcciones";}
        else if (name.matches(".+HE[^A-Z,a-z].+?")){ name="Cambio de direcciones";}
        else if (name.matches(".+HF[^A-Z,a-z].+?")){ name="corrección de fechas";}
        else if (name.matches(".+HG[^A-Z,a-z].+?")){ name="Corrección de clasificaciones";}
        else if (name.matches(".+HH[^A-Z,a-z].+?")){ name="Este código se usa para cualquier documento que no se pueda catalogar.";}
        else if (name.matches(".+LZ[^A-Z,a-z].+?")){ name="LIMITACION DEL DERECHO DE PROPIEDAD INDUSTRIAL";}
        else if (name.matches(".+LA[^A-Z,a-z].+?")){ name="Inicio de la petición de limitación del derecho.";}
        else if (name.matches(".+LB[^A-Z,a-z].+?")){ name="Rechazo de la petición de limitación del derecho";}
        else if (name.matches(".+LC[^A-Z,a-z].+?")){ name="Anulación de las Reivindicaciones";}
        else if (name.matches(".+LD[^A-Z,a-z].+?")){ name="Renuncia Parcial";}
        else if (name.matches(".+LE[^A-Z,a-z].+?")){ name="Suspensión del derecho de propiedad industrial";}
        else if (name.matches(".+MZ[^A-Z,a-z].+?")){ name="Prescripción del derecho de propiedad industrial";}
        else if (name.matches(".+MA[^A-Z,a-z].+?")){ name="Abandono o retiro";}
        else if (name.matches(".+MB[^A-Z,a-z].+?")){ name="Petición de anulación";}
        else if (name.matches(".+MC[^A-Z,a-z].+?")){ name="Anulación";}
        else if (name.matches(".+MD[^A-Z,a-z].+?")){ name="Proceso de oposición iniciado";}
        else if (name.matches(".+ME[^A-Z,a-z].+?")){ name="Proceso de revocación iniciado";}
        else if (name.matches(".+MF[^A-Z,a-z].+?")){ name="Derecho revocado después de revocación u oposición ";}
        else if (name.matches(".+MG[^A-Z,a-z].+?")){ name="Otras decisiones concernientes a la revocación ";}
        else if (name.matches(".+MH[^A-Z,a-z].+?")){ name="Renuncia ";}
        else if (name.matches(".+MK[^A-Z,a-z].+?")){ name="Expiración del plazo";}
        else if (name.matches(".+ML[^A-Z,a-z].+?")){ name="Anulación de la prórroga del plazo";}
        else if (name.matches(".+MM[^A-Z,a-z].+?")){ name="Anulación o prescripción por impago de las tasas";}
        else if (name.matches(".+MN[^A-Z,a-z].+?")){ name="Rechazo de la renovación ";}
        else if (name.matches(".+MP[^A-Z,a-z].+?")){ name="Denegación de la protección nacional";}
        else if (name.matches(".+NZ[^A-Z,a-z].+?")){ name="Mantenimiento o prorroga del derecho de propiedad industrial";}
        else if (name.matches(".+ND[^A-Z,a-z].+?")){ name="Renovación o prórroga concedida";}
        else if (name.matches(".+NE[^A-Z,a-z].+?")){ name="Petición de restauración de un derecho caducado";}
        else if (name.matches(".+NF[^A-Z,a-z].+?")){ name="Restauración del derecho caducado ";}
        else if (name.matches(".+NG[^A-Z,a-z].+?")){ name="Confirmación de un derecho después de revocación u oposición ";}
        else if (name.matches(".+NH[^A-Z,a-z].+?")){ name="Anulación de la denegación de renovación ";}
        else if (name.matches(".+PZ[^A-Z,a-z].+?")){ name="Situación Jurídica ";}
        else if (name.matches(".+PA[^A-Z,a-z].+?")){ name="Transformación de derecho a otro ";}
        else if (name.matches(".+PB[^A-Z,a-z].+?")){ name="Reivindicación de la titularidad ";}
        else if (name.matches(".+PC[^A-Z,a-z].+?")){ name="Transferencia o Sesión";}
        else if (name.matches(".+PD[^A-Z,a-z].+?")){ name="Cambio de titular";}
        else if (name.matches(".+PE[^A-Z,a-z].+?")){ name="Beneficio Publico";}
        else if (name.matches(".+PG[^A-Z,a-z].+?")){ name="Constancias y Duplicados";}
        else if (name.matches(".+PF[^A-Z,a-z].+?")){ name="Sustitución de poder";}
        else if (name.matches(".+QZ[^A-Z,a-z].+?")){ name="Licencia";}
        else if (name.matches(".+QA[^A-Z,a-z].+?")){ name="Oferta de Licencia";}
        else if (name.matches(".+QB[^A-Z,a-z].+?")){ name="Licencia concedida o registrada";}
        else if (name.matches(".+QC[^A-Z,a-z].+?")){ name="Rescisión de una licencia";}
        else if (name.matches(".+RZ[^A-Z,a-z].+?")){ name="Decisiones no previstas en otros lugares";}
        else if (name.matches(".+RA[^A-Z,a-z].+?")){ name="Petición de acción por infracción iniciada";}
        else if (name.matches(".+RB[^A-Z,a-z].+?")){ name="Decisión concerniente a la acción por infracción";}
        else if (name.matches(".+RC[^A-Z,a-z].+?")){ name="Pignoración";}
        else if (name.matches(".+RD[^A-Z,a-z].+?")){ name="Embargo";}
        else if (name.matches(".+RE[^A-Z,a-z].+?")){ name="Decisión constatando la dependencia";}
        else if (name.matches(".+RF[^A-Z,a-z].+?")){ name="Levantamiento de la pignoración";}
        else if (name.matches(".+RH[^A-Z,a-z].+?")){ name="Otras decisiones de la oficina de propiedad industrial";}
        else if (name.matches(".+RL[^A-Z,a-z].+?")){ name="Acciones judiciales y sentencias dictadas";}
        else if (name.matches(".+SZ[^A-Z,a-z].+?")){ name="Divulgación Publica";}
        else if (name.matches(".+SA[^A-Z,a-z].+?")){ name="Orden de mantener en secreto";}
        else if (name.matches(".+SB[^A-Z,a-z].+?")){ name="Levantamiento de la orden de mantener en secreto";}
        else if (name.matches(".+SC[^A-Z,a-z].+?")){ name="Puesta a disposición del público";}
        else if (name.matches(".+TZ[^A-Z,a-z].+?")){ name="Correcciones, cambios diversos";}
        else if (name.matches(".+TA[^A-Z,a-z].+?")){ name="Indicación del nombre del inventor";}
        else if (name.matches(".+TB[^A-Z,a-z].+?")){ name="Corrección de nombres";}
        else if (name.matches(".+TC[^A-Z,a-z].+?")){ name="Cambio de nombres";}
        else if (name.matches(".+TD[^A-Z,a-z].+?")){ name="Corrección de direcciones";}
        else if (name.matches(".+TE[^A-Z,a-z].+?")){ name="Cambio de direcciones";}
        else if (name.matches(".+TG[^A-Z,a-z].+?")){ name="Corrección de clasificaciones";}
        else if (name.matches(".+TH[^A-Z,a-z].+?")){ name="Corrección o cambio en general";}
        else if (name.matches(".+PDR[^A-Z,a-z].+?")){ name="Pago de registro";}
        else if (name.matches(".+PDA[^A-Z,a-z].+?")){ name="Pago de Anualidad";}
        else if (name.matches(".+PPQ[^A-Z,a-z].+?")){ name="Pago de Primer Quinquenio";}
        else if (name.matches(".+PPP[^A-Z,a-z].+?")){ name="Pago de Presentación de Solicitud PCT";}
        else if (name.matches(".+PPR[^A-Z,a-z].+?")){ name="Pago por Restauración de la Presentación de Solicitud PCT";}
        else if (name.matches(".+PPF[^A-Z,a-z].+?")){ name="Pago por Examen de Fondo";}
        else if (name.matches(".+PPS[^A-Z,a-z].+?")){ name="Pago por Sobretasa";}
        else if (name.matches(".+PPM[^A-Z,a-z].+?")){ name="Pago por Modificaciones";}
        else if (name.matches(".+PDC[^A-Z,a-z].+?")){ name="Pago de Certificaciones";}
        else {name="Solicitud";};
        return name;
    }



    */
    
    
}
