package com.rcomputer.genapp.addon;
import com.rcomputer.genapp.model.*;
import com.rcomputer.genapp.action.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;

import javax.servlet.http.Part;
import com.rcomputer.genapp.action.*;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;
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
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;


@Named("PluginManagerAddon")
//@SessionScoped
@RequestScoped
@Transactional
/**
* This is Model class
* @author 3r Computer Systems
* @version 2.0
*/

public class PluginManagerAddon implements java.io.Serializable{
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
        private List<Part> files; // +getter+setter
        byte[] fileContent;
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


    @PostConstruct
    public void initialize() {
      facesContext = FacesContext.getCurrentInstance();
      bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");

    }



	public String getText() {
		return new String(text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
		int extDot = name.lastIndexOf('.');
		if (extDot > 0) {
			String extension = name.substring(extDot + 1);
			extension = extension.toLowerCase();
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
				mime = "txt";
			} else if ("text/htm".equals(extension)) {
				mime = "txt";
			} else if ("mp3".equals(extension)) {
				mime = "audio/mpeg";
			} else if ("mp4".equals(extension)) {
				mime = "video/mp4";
			} else {
				mime = "image/unknown";
			}
		}
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}

	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
                //fileUpload();
	}
	public List<Part> getFiles() {
		return files;
	}

	public void setFiles(List<Part> files) {
		this.files = files;
	}

        public byte[] getFileContent() {
         return fileContent;
        }


    /**
    * The following method loads classes from a jar file under a plugins dir into jvm
    * Classloader is part of jre (run time) and deals with dir and file structure,
    * jar may contain many classes, so request and load classes as needed into memory.
    * Convert the File reference to a URL, use URL class loader (load jars via URLs) for this custom class loader
    * @param args none
    * @return String empty
    * @exception caught and logged or messages shown
    * @see preLoadThemes()
    *
    */
      public String preLoadPlugins(String jarName, String className) {
       try{
        Class c=null;
        String classNamej="";//from jar file
        if(jarName==null || jarName.isEmpty()){
         jarName="jaytomee.jar";
        }
        if(className==null || className.isEmpty()){
         className="com.rcomputer.genapp.addon.ShoppingCartBeanPlugin.class";
        }

        context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        String jarPath=context.getRealPath("/WEB-INF/plugins/"+jarName);//jaytomee.jar includes META-INF/manifest-mf and ShoppingCartBeanPlugin.class
        try{
         //all plugin classes must be submitted in a .jar format. May be ui part ie .xhtml can be in jar
         // as well as .csv?
         //get files under Plugins dir, but get only those whose name ends in ".jar"
         JarFile jarFile = new JarFile(jarPath);
         Enumeration<JarEntry> e = jarFile.entries();

         //URL classUrl; if classFile no jar involved
         //classUrl = new URL("file:///home/kent/eclipsews/SmallExample/bin/IndependentClass.class");
         URL[] urls = { new URL("jar:file:" + jarPath+"!/") };//url array holds all paths
         URLClassLoader cl = URLClassLoader.newInstance(urls);//but create one loader instance for all classes
         ClassLoader pcl=cl.getParent();

         while (e.hasMoreElements()) {
           JarEntry je = e.nextElement();
           if(je.isDirectory() || !je.getName().endsWith(".class")){
            continue;
           }
           // -6 because of .class
           classNamej = je.getName().substring(0,je.getName().length()-6);
           classNamej = classNamej.replace('/', '.');
           className = className.substring(0,className.length()-6);
           if (classNamej.equals(className)) {
            c = cl.loadClass(className);//loads class object from plugin directory or from cache?
            ShoppingCartBeanAddon r3CartAddon = (ShoppingCartBeanAddon) c.newInstance();
           }
           //for now allow only extension to existing classes

         }//all elements in a jar

     	 return "";


        }catch (Exception ef){//try/catch for each file
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+ ef.getCause()+", "+ ef.getMessage()+" "+jarName,""));
		   log.severe(" Load / instantiate class error "+' ' + ef.getCause()+' ' + ef.getMessage()+' '+jarName);
	   return "";
        }
       }catch (Exception ef){//try/catch for jar file
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+ ef.getCause()+", "+ ef.getMessage()+" "+jarName,""));
		   log.severe(" Load and instantiate class error "+' ' + ef.getCause()+' ' + ef.getMessage()+' '+jarName);
	   return "";
       }
      }


}
