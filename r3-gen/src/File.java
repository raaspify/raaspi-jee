package com.rcomputer.genapp.model;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.annotation.PostConstruct;

import javax.servlet.http.Part;
import com.rcomputer.genapp.action.*;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.Part;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import java.util.Base64;

 import com.opencsv.CSVParser;
 import com.opencsv.CSVParserBuilder;
 import com.opencsv.RFC4180Parser;
 import com.opencsv.RFC4180ParserBuilder;
 import com.opencsv.CSVReader;
 import com.opencsv.CSVReaderBuilder;

import org.omnifaces.util.Servlets;
import org.omnifaces.util.Utils;
import javax.servlet.ServletContext;
import javax.faces.context.ExternalContext;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import net.coobird.thumbnailator.*;
import java.nio.charset.StandardCharsets;




/**
* This is Raaspi File Model class
* utility class for uploading local files and managing their content
* images are scaled to avoid large size and demand on memory and storage
* @author 3r Computer Systems
* @version 2.0
*/
@Named("file")
@ViewScoped
@Transactional

public class File implements java.io.Serializable{
   @Inject
   Yxxxuq1m1xwwqqqxxxxxclobdataHome yxxxuq1m1xwwqqqxxxxxclobdataHome;
   private Yxxxuq1m1xwwqqqxxxxxclobdata yxxxuq1m1xwwqqqxxxxxclobdata;
   @Inject
   Yxxxuq1n1xwwqqqxxxxxblobdataHome yxxxuq1n1xwwqqqxxxxxblobdataHome;
   private Yxxxuq1n1xwwqqqxxxxxblobdata yxxxuq1n1xwwqqqxxxxxblobdata;
   @Inject
   Fpxxfq1a5xwwqqhxxxxxitemHome fpxxfq1a5xwwqqhxxxxxitemHome;
   private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem;
   @Inject CustomIdentity customIdentity;


     private String Name;
     private String mime;
     private long length;
     private byte[] data;
     private String text;
     private String photo = "";
     private Part part;
     private List<Part> lfiles; // local files +getter+setter
     File jayfile;
     private ResourceBundle bundle=null;
     private FacesContext facesContext=null;

     boolean bcontinue = true;
     private Logger log = Logger.getLogger(File.class.getCanonicalName());
     String jay;
     String lines[];
     String csvData;
     String[] csvDataArray;
     String[] csvDataArray2;

     int element=0;
     int importdone=0;
     int importnotdone=0;
     int i=0;
     int ii=0;
     int importexception=0;
     int csvElements=0;
     String skipRecordOne="N";
     String lineBy="N";
     String delimeterBy="C";
     String enclosedBy="D";
     int duplDropped=0;
     int importAdded=0;
     Fpxxfq1a5xwwqqhxxxxxitem parentEntity=null;
     int skipl=0;
     //RFC4180Parser instead of CSVParser allows null escape
     RFC4180Parser parser = null;
     CSVReader reader = null;
     String name;
     String type;
     long size;
     private ServletContext context=null;
     private Boolean dataIsClob = false;
     private Boolean dataIsBlob = false;
     private int uploadsAvailable = 3;
     File rfile=null;
    @PostConstruct
    public void initialize() {
      facesContext = FacesContext.getCurrentInstance();
      bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");

    }



	public String getText() {
		return text;
	}

	public void setText(String textp) {
		text = textp;
	}

	public byte[] getData() {
		return data;
	}
	public void setData(byte[] datap) {
		data = datap;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
                                    Name = name;
	}


	public long getLength() {
		return length;
	}
	public void setLength(long lengthp) {
		length = lengthp;
	}

	public String getMime() {
		return mime;
	}
	public void setMime(String mimep) {
		mime = mimep;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photop) {
		photo = photop;
	}

	public Part getPart() {
		return part;
	}
        //lfiles are actual local files
	public void setPart(Part partp) {
		part = partp;
                //fileUpload();
	}

	public List<Part> getLfiles() {
		return lfiles;
	}

        public void setLfiles(List<Part> lfiles) {
         this.lfiles = lfiles;
        }


        public int getUploadsAvailable() {
         return uploadsAvailable;
        }

        public void setUploadsAvailable(int uploadsAvailablep) {
         uploadsAvailable = uploadsAvailablep;
        }


    /**
    * The following method loads local files to App Server using browser html5 input
    * uses omnifaces to handle multi files upload.
    * called by themeImport.xhtml, needs enctype="multipart/form-data" in h:form tag
    * and use xmlns:o="http://omnifaces.org/ui" in  ui:composition tag and omnifaces-2.6.9.jar in lib
    * @param args none
    * @return String empty
    * @exception caught and logged or messages shown. multipart/form-data if enctype not specified in <form tag
    * @see preLoadThemes(), (future fileUploadS , fileUploadSF)
    *
    */

    public String fileUpload(String purpose) {
     //import csv theme file/files into item/clob/blob records
     if(purpose.isEmpty()){
      purpose="csv";
     }
     byte[] imageInByte=null;
     text=null;
     int i = 0;
     ByteArrayOutputStream baos=null;
     //files = new ArrayList<File>();
     try {
      if (lfiles != null && lfiles.size()>0) {
        for (Part lfile : lfiles) {
            rfile=new File();
            imageInByte=null;
            dataIsClob=false;
            dataIsBlob=false;
            name = Servlets.getSubmittedFileName(lfile);//omnifaces Servlets
            type = lfile.getContentType();
            size = lfile.getSize();//file size
            if(size==0){
             continue;//give error msg
            }
            data = Utils.toByteArray(lfile.getInputStream());//omniface utils to byte[]
            length=data.length;//file content > byte length
            if(purpose.equals("csv")){
             csvData= new String(data);//add char encoding
             csvDataToEntity();
            }
            if(purpose.equals("clobblob")){
             String jayMime=type;//contenttype
             String jayImageFormat="jpg";
             if(jayMime.contains("image/")){
              jayImageFormat=jayMime.substring(6);
              rfile.setLength(data.length);
              try{
               //700x700 jpg image length in bytes 536,814, large images are scaled down to reduce memory/storage
               if(data.length > 536813){
                BufferedImage originalImage = ImageIO.read(lfile.getInputStream());
                BufferedImage thumbnail = Thumbnails.of(originalImage)
                .size(700, 700)
                .asBufferedImage();
                baos = new ByteArrayOutputStream();
                ImageIO.write( thumbnail, jayImageFormat, baos );
                baos.flush();
                imageInByte = baos.toByteArray();
                rfile.setLength(imageInByte.length);
                rfile.setData(imageInByte);
                baos.close();
               }else{
                rfile.setData(data);
               }
               dataIsBlob=true;
              } catch (Exception e) {
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("image")+" "+bundle.getString("transform")+ " "+bundle.getString("failed")+" "+e.getMessage(),""));
              }
             }else{
              //non image but byte data pdf or text
              // raaspi file object has data in byte array
              dataIsClob=true;
              rfile.setLength(data.length);//local file (size)> byte array(length) and from byte > text (length) in raaspi file object
              rfile.setText(new String(data, StandardCharsets.UTF_8));
              rfile.setLength(rfile.getText().length());//local file size and data converted from byte > text in raaspi file object
             }
             rfile.setName(name);// sets name and mime for a file object
             int extDot = name.lastIndexOf('.');
             if (extDot > 0) {
              String extension = name.substring(extDot + 1);
              extension = extension.toLowerCase();
              mime=getMimeFromExtension(extension);
              rfile.setMime(mime);
             }

             //uploadsAvailable--; was in entityHome
            }//purpose, when needed any entity can access the yxxxuq1n1xwwqqqxxxxxblobdataHome getFiles method to retrieve one or many uploaded files
            yxxxuq1n1xwwqqqxxxxxblobdataHome.addToFiles(rfile);// blobdataHome now holds list of uploaded file objects
        }//for each file
       //if files uploaded
      }else{
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_ERROR,bundle.getString("No")+" "+bundle.getString("file")+" "+ bundle.getString("selected"),""));
       return "";
      }
     } catch (Exception ex) {
       jay=ex.getMessage();
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_ERROR,bundle.getString("File")+" "+ name+" "+ bundle.getString("upload")+" "+ bundle.getString("error")+" "+ex.getMessage(),""));
     }
     return "";
    }

    /**
    * The following method transforms csvdata to corresponding entity
    * called by method fileUpload()
    * @param args none
    * @return String empty
    * @exception caught and logged or messages shown
    * @see fileUpload
    *
    */
    public String csvDataToEntity() {
            //RFC4180Parser instead of CSVParser allows null escape
            parser =
             new RFC4180ParserBuilder()
             .build();
            skipl=0;
            CSVReader reader =
            new CSVReaderBuilder(new StringReader(csvData))
             .withSkipLines(skipl)
             .withCSVParser(parser)
             .build();

            try {
                if(name.contains("items")){
                 csvElements=11;//Item

                }
                if(name.contains("clob")){
                 csvElements=8;//clobs

                }
                if(name.contains("blob")){
                 csvElements=8;//blobda and itemblob

                }
                if(csvElements==0){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("no")+" "+ bundle.getString("proccesing")+" "+ bundle.getString("for")+" "+ bundle.getString("file")+" "+ name,""));
                   return "";
                }

               importdone=0;
               importnotdone=0;
               i=0;
             while ((csvDataArray2 = reader.readNext()) != null) {
                 // csvDataArray2[] is an array of values from the line
                i=i+1;
                if(name.contains("items")){
                 fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();
                 fpxxfq1a5xwwqqhxxxxxitem=fpxxfq1a5xwwqqhxxxxxitemHome.getInstance();
                 fpxxfq1a5xwwqqhxxxxxitem.setA0xxukixbxxxxxxxxxxxmatcode(csvDataArray2[0]);
                 fpxxfq1a5xwwqqhxxxxxitem.setB1xxuszsbvxxxxxxxxxxdescript(csvDataArray2[1]);
                 fpxxfq1a5xwwqqhxxxxxitem.setY2xxuxxrbvxxxxxxxxxxmisccode1(csvDataArray2[2]);
                 fpxxfq1a5xwwqqhxxxxxitem.setY3xxuxxrbvxxxxxxxxxxmisccode2(csvDataArray2[3]);
                 fpxxfq1a5xwwqqhxxxxxitem.setC6xxusxrbv16xxxxxxxxtype(csvDataArray2[4]);
                 //themeCategory comes as method param
                 //we need to create theme catagory record first and save its sid
                 // children will use that sid as item parent key 5th pos
                 if(!csvDataArray2[5].isEmpty()){
                  fpxxfq1a5xwwqqhxxxxxitem.setFpxxfq1a5xwwqqhxxxxxitem(parentEntity);
                 }
                 fpxxfq1a5xwwqqhxxxxxitem.setG2xxuxn1bvxxxxxxxxxxsubcodesn(csvDataArray2[6]);
                 fpxxfq1a5xwwqqhxxxxxitem.setG2xxuxn3bvxxxxxxxxxxsubcodesn3(csvDataArray2[7]);
                 fpxxfq1a5xwwqqhxxxxxitem.setW7xxuznxbvxxxxxxxxxxnotes(csvDataArray2[8]);
                 fpxxfq1a5xwwqqhxxxxxitem.setW8xxuzdrbvxxxxxxxxxxdocmnt(csvDataArray2[9]);
                 fpxxfq1a5xwwqqhxxxxxitem.setZexxutoxlhxxxxxxxxxxowner(csvDataArray2[10]);
                 fpxxfq1a5xwwqqhxxxxxitem.setZzxxu2oxxhxxxxxxxxxxowner2(customIdentity.getOwner2());//
                 fpxxfq1a5xwwqqhxxxxxitemHome.superdotpersist();
                 if(csvDataArray2[5].isEmpty()){
                  parentEntity=fpxxfq1a5xwwqqhxxxxxitem;// entity only after persist
                 }

                }//end of if items for one line/record
                if(name.contains("clob")){
                 yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
                 yxxxuq1m1xwwqqqxxxxxclobdata=yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
                 yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable(csvDataArray2[0]);
                 yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey(csvDataArray2[1]);
                 yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(csvDataArray2[2]);
                 yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(Integer.parseInt(csvDataArray2[3]));
                 yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype(csvDataArray2[4]);
                 yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(csvDataArray2[5]);
                 yxxxuq1m1xwwqqqxxxxxclobdata.setY3xxuxznbvxxxxxxxxxxnotes(csvDataArray2[6]);
                 yxxxuq1m1xwwqqqxxxxxclobdata.setZ3xxutoxlhxxxxxxxxxxowner(csvDataArray2[7]);
                 if(csvDataArray2[8].equals("SYSTEM")){
                  yxxxuq1m1xwwqqqxxxxxclobdata.setZzxxu2oxxhxxxxxxxxxxowner2("SYSTEM");//
                 }else{
                  yxxxuq1m1xwwqqqxxxxxclobdata.setZzxxu2oxxhxxxxxxxxxxowner2(customIdentity.getOwner2());//
                 }
                 if(!yxxxuq1m1xwwqqqxxxxxclobdataHome.duplicateClobBlobExists(csvDataArray2[0],csvDataArray2[1],csvDataArray2[2],Integer.parseInt(csvDataArray2[3]))){
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.superdotpersist();
                 }else{
                 }
                }
                //blob will accept itemblob or blob file
                if(name.contains("blob")) {
                 yxxxuq1n1xwwqqqxxxxxblobdataHome.clearInstance();
                 yxxxuq1n1xwwqqqxxxxxblobdata=yxxxuq1n1xwwqqqxxxxxblobdataHome.getInstance();
                 yxxxuq1n1xwwqqqxxxxxblobdata.setA0xxukbdlvxxxxxxxxxxfromtable(csvDataArray2[0]);
                 yxxxuq1n1xwwqqqxxxxxblobdata.setA1xxuxxxbv49xxxxxxxxfromkey(csvDataArray2[1]);
                 yxxxuq1n1xwwqqqxxxxxblobdata.setA2xxuxxxbv50xxxxxxxxqualifier(csvDataArray2[2]);
                 yxxxuq1n1xwwqqqxxxxxblobdata.setA3xxexnsbvxxxxxxxxxxsequence(Integer.parseInt(csvDataArray2[3]));
                 yxxxuq1n1xwwqqqxxxxxblobdata.setA4xxexxxbvxxxxxxxxxxtype(csvDataArray2[4]);
                 byte[] data = Base64.getDecoder().decode(csvDataArray2[5].getBytes());
                 yxxxuq1n1xwwqqqxxxxxblobdata.setB1xxuzbxbvxxxxxxxxxxdata(data);
                 yxxxuq1n1xwwqqqxxxxxblobdata.setZ3xxutoxlhxxxxxxxxxxowner(csvDataArray2[6]);
                 if(csvDataArray2[7].equals("SYSTEM")){
                  yxxxuq1n1xwwqqqxxxxxblobdata.setZzxxu2oxxhxxxxxxxxxxowner2("SYSTEM");//
                 }else{
                  yxxxuq1n1xwwqqqxxxxxblobdata.setZzxxu2oxxhxxxxxxxxxxowner2(customIdentity.getOwner2());//
                 }
                 if(!yxxxuq1n1xwwqqqxxxxxblobdataHome.duplicateClobBlobExists(csvDataArray2[0],csvDataArray2[1],csvDataArray2[2],Integer.parseInt(csvDataArray2[3]))){
                  yxxxuq1n1xwwqqqxxxxxblobdataHome.superdotpersist();
                 }else{
                 }
                }
                 importdone=importdone+1;
                 if(!bcontinue){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("aborting")+" "+ bundle.getString("import")+", "+ bundle.getString("changes")+" "+ bundle.getString("rolled")+" "+ bundle.getString("back")+", "+ bundle.getString("fix")+" "+ bundle.getString("and")+" "+ bundle.getString("try")+" "+ bundle.getString("again"),""));
                   return "";

                 }
                 if(importdone >=990){
                  // runs out of memory,try session.flush and clear.
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString("upto")+" 900 "+ bundle.getString("records")+" "+bundle.getString("per")+" "+bundle.getString("import"),""));

                  break;
                 }
             }//end of while more csv line loop
            }catch (Exception ef){//try/catch for each file
                  importexception=importexception+1;
                  if(importexception <6){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+ ef.getCause()+", "+ ef.getMessage()+" "+csvDataArray2,""));
                    log.severe(" theme import error "+' ' + ef.getCause()+' ' + ef.getMessage()+' '+jay);
                  }
            }

            //give stats for a file
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              //FacesMessage.SEVERITY_INFO,bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone,""));
            log.info( bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone);
            return "";
	}


    /**
    * The following method loads csv theme files from root.war/WEB-INF/resources/csv dir to data base, called by runfatjar > Aurhenticator > doMasterSite()
    * @param args none
    * @return String empty
    * @exception caught and logged or messages shown
    * @see preLoadThemes()
    *
    */
       public String preLoadThemes() {
          //fileContent=from preLoadedFiles
          String csvFilePath="";
          try{
            context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();

            //csvData= new String(fileContent);//add char encoding
            name="Pre built sitems.csv";
            csvFilePath = context.getRealPath("/WEB-INF/resources/"+name);
            csvData = new String(Files.readAllBytes(Paths.get(csvFilePath)));
            csvDataToEntity();
            //give stats for a file
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              //FacesMessage.SEVERITY_INFO,bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone,""));
            log.info(bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone);
             name="Pre built sitemblob.csv";
            csvFilePath = context.getRealPath("/WEB-INF/resources/"+name);
            csvData = new String(Files.readAllBytes(Paths.get(csvFilePath)));
            csvDataToEntity();
            //give stats for a file
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              //FacesMessage.SEVERITY_INFO,bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone,""));
            log.info(bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone);
            name="Pre built sclob.csv";
            csvFilePath = context.getRealPath("/WEB-INF/resources/"+name);
            csvData = new String(Files.readAllBytes(Paths.get(csvFilePath)));
            csvDataToEntity();
            //give stats for a file
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              //FacesMessage.SEVERITY_INFO,bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone,""));
            log.info(bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone);
            name="Pre built sblob.csv";
            csvFilePath = context.getRealPath("/WEB-INF/resources/"+name);
            csvData = new String(Files.readAllBytes(Paths.get(csvFilePath)));
            csvDataToEntity();
            //give stats for a file
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              //FacesMessage.SEVERITY_INFO,bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone,""));
           log.info(bundle.getString("For")+" "+csvFilePath+" "+bundle.getString("total")+" "+i+" = "+ bundle.getString("dropped")+" "+importnotdone+importexception+"  "+ bundle.getString("added")+" "+importdone);
            return "";

          }catch (Exception ef){//try/catch for each file
                  if(importexception <6){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+ ef.getCause()+", "+ ef.getMessage()+" "+name,""));
                   log.severe(" preLoad themes error "+' ' + ef.getCause()+' ' + ef.getMessage()+' '+csvFilePath);
                  }
	   return "";
         }

       }


       public String getMimeFromExtension(String extension) {
          if ("bmp".equals(extension)) {
                         mime = "image/bmp";
          } else if ("jpg".equals(extension)) {
				mime = "image/jpeg";
			} else if ("gif".equals(extension)) {
				mime = "image/gif";
			} else if ("png".equals(extension)) {
				mime = "image/png";
			} else if ("xml".equals(extension)) {
				mime = "text/xml";
			} else if ("doc".equals(extension)) {
				mime = "application/msword";
			} else if ("txt".equals(extension)) {
				mime = "text/plain";
			} else if ("pdf".equals(extension)) {
				mime = "application/pdf";
			} else if ("xls".equals(extension)) {
				mime = "application/vnd.ms-excel";
			} else if ("doc".equals(extension)) {
				mime = "application/msword";
			} else if ("application/vnd.ms-powerpoint".equals(extension)) {
				mime = "ppt";
			} else if ("text/html".equals(extension)) {
				mime = "txt/html";
			} else if ("text/htm".equals(extension)) {
				mime = "txt";
			} else if ("text/csv".equals(extension)) {
				mime = "csv";
			} else if ("mp3".equals(extension)) {
				mime = "audio/mpeg";
			} else if ("mp4".equals(extension)) {
				mime = "video/mp4";
                        } else {
                           mime = "image/unknown";
          }
          return mime;
	}

}
