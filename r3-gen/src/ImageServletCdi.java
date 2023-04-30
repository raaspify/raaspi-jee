/** not Generated
* to serve image data from database or from a file under server dir
* used in <h:graphicImage as value
*
*/

package com.rcomputer.genapp.action;


/*
* comes as http request with query parameters ie //ImageServletCdi/?xx=vv&yy=ww etc
* <h:graphicImage value="/ImageServletCdi/?id=#{tm.id}" default values seq 0,'blobdata','PIC', no scaling
* <h:graphicImage value="/ImageServletCdi/?seq=1&amp;id=A3R-MID-TOP-C&amp;width=700
* <h:graphicImage value="/ImageServletCdi/?img=/img/ecomm-wwwcart.jpg&amp;qlf=jpg&amp;height=110">
* jun01 2020 <href="/ImageServletCdi/?table=clobdata&amp;css=/xx/cssnamel1.l2.css">
* <h:graphicImage value="/ImageServletCdi/?table=clobdata&amp;id=/xx/jsnamel1.l2..js">
* <img src="/ImageServletCdi/?seq=0&amp;id=B3R-LOGO-C&amp;height=0" notice uses src instead of value, needed to use uI:fragment since no render
* Like images but was stored as text in Clobdata key as qualified cssname and qlf as TXT seq as 0 ??or key as jsname and qlf as TXT
* we need to standardize default seq as 0 or 1

* where Membership implements PhotoInterface...

*

*/





import java.io.Closeable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.*;
import com.rcomputer.genapp.model.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ImageServletCdi", urlPatterns = {"/ImageServletCdi/*"})

public class ImageServletCdi extends HttpServlet {
      @PersistenceContext(unitName = "genappcdi")
      EntityManager entityManager;

     @Inject
     Yxxxuq1n1xwwqqqxxxxxblobdataHome yxxxuq1n1xwwqqqxxxxxblobdataHome;
     @Inject
     SqlAdminSupport sqlAdminSupport;
     @Inject File file;
     @Inject CustomIdentity customIdentity;

     private Logger log = Logger.getLogger(ImageServletCdi.class.getCanonicalName());
     String id="";
     String table="";
     String scope="";
     String qlf="";
     Integer seq=0;
     Integer width=0;
     Integer height=0;
     Integer urlIndex;
     String owner2Code=null;
     byte[] imageData=null;
     String textData=null;
     String img="";
     private ServletContext context=null;
     ///private ArrayList<File> files = new ArrayList<File>();
     ///private File file;
     private Boolean dataIsClob = false;
     private Boolean dataIsBlob = false;
     String keyWPrefix="";

//
/**
 Do not use it unless scaling is involved, replaces s:transformsize
 width=0 and height=0 means no scaling
 img != null means image value supplied either \img\Cart32.png etc or #{file.data}
 *doGet intercepts HTTP Get requests, also need an entry in web.xml servlet name ImageServletCdi, class com.rcomputer.genapp.action.ImageServletCdi
 *and sends back response.getOutputStream().write(imageData)ie byte[]->outputStream->response to browser to show image
 *jun01 2020
 * or sends back response.getWriter().write(textData)ie char[]->writer->response to browser to show css, js text
**/
    /**
    * The following method intercepts HTTP Get requests and sends back response.getOutputStream().write(imageData)
    * gets byte[]->outputStream->response to browser to show image
    * like any servlet, this needs an entry in web.xml servlet name ImageServletCdi, class com.rcomputer.genapp.action.ImageServletCdi
    * @param args 2 param1 http request, param2 http response
    * @return void
    * @exception ServletException, IOException
    *
    *
    */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id = request.getPathInfo().trim().substring(1);
        //jun01 2018 scope SYSTEM means get system images, if null or any other value get owner2 only
        scope=request.getParameter("scope");
        table=request.getParameter("table");
        img=request.getParameter("img");
        id = request.getParameter("id");
        qlf=request.getParameter("qlf");
        if(request.getParameter("seq") !=null){
         seq = Integer.parseInt(request.getParameter("seq"));
	}
        //dec11 2020 get rid of / ie height="50/" not sure where from put try/catch

        try{
         width=Integer.parseInt(request.getParameter("width")==null?"0":request.getParameter("width"));

         height=Integer.parseInt(request.getParameter("height")==null?"0":request.getParameter("height"));
        }catch (Exception e){
 	  log.severe("Error image had width and height as "+width+","+height+" "+ e.getMessage());
          width=0;
          height=0;
        }

	//log.severe("id "+ id+" seq "+seq+" width "+width);
        //sep10 2019 why only jpeg , pdf support, other types like png??? alter contentTpe after checking the data
        // needs iframe to see the pdf doc
        response.setContentType(getServletContext().getMimeType("image/jpeg"));
        //response.setContentLength(image.getBytes().length);
        String urlName=request.getServerName();
          urlIndex=urlName.lastIndexOf(".");
          if (urlIndex == -1){
            urlIndex=urlName.length();
          }
          if (urlName.contains("www.")){
           owner2Code=urlName.substring(4,urlIndex);
          }else{
           owner2Code=urlName.substring(0,urlIndex);
          }
          //extract subdomain if used. if subdomain, masterSiteCode will have a value
         if(!customIdentity.getMasterSiteCode().isEmpty()){
          owner2Code=owner2Code.replace("."+customIdentity.getMasterSiteCode(),"");
         }
        //added logic to get bytedata and transform image size
       if(table !=null && table.equals("clobdata")){
        ////////////////////////////////clobdata starts
        //css,js
         //textData value can be a folder file or string data if no # but just "file.data=" exists in it
         //files.get(i).getData() has the byte value and qualifier qlf has the mime
         if (qlf==null || qlf==""){
          qlf="TXT";
         }
         //default seq 0
         textData=null;
         try{
           textData=this.getClobdata(table,"A"+id,qlf,seq,400096);
         }catch (Exception e){
 	  log.severe("Error getClobdata "+ e.getMessage());
         }
         try{
          ServletContext context = getServletContext();
          if(img !=null && img.contains("file.data=")){
	   if (file.getMimeFromExtension("").equals("text/plain") || file.getMimeFromExtension("").equals("text/xml")) {
            dataIsClob = true;
           }else {
            dataIsBlob = true;
            imageData = file.getData();
            width=200;
	   }
          }else{
           response.setContentType(getServletContext().getMimeType("text/css"));
           response.getWriter().write(textData);
           response.flushBuffer();
          }
         } catch (Exception e) {
   	   log.severe(table+ "image error "+e);
           return;
	 }
       ///////////////////////////blobda data starts
       }else{
        //gif,jpg,pdf
        if (table==null || table ==""){
         table="blobdata";
        }
        if(img==null){//imagedata comes from blobdata already stored as byte array
         if (qlf==null || qlf==""){
          qlf="PIC";
         }
         try{
          String test="y";
          if(test.equals("n")){
           imageData=sqlAdminSupport.getBlobdata(table,id,qlf,seq,owner2Code);
          }else{
           imageData=this.getBlobdata(table,id,qlf,seq,owner2Code);
           //check in case not image data but byte data holding key for real image
          
           if (imageData !=null && imageData.length > 3 && imageData[0] == 0x3c &&
            imageData[1] == 0x68 && // h imageData here has key for the binary data
            imageData[2] == 0x74 && // t
            imageData[3] == 0x6d) { // m
             extractImageKeys(imageData);//overrides id/keyWPreix and continue
             imageData=this.getBlobdata(table,id,qlf,seq,owner2Code);
            }
          }
         }catch (Exception e){
 	  log.severe("Error getBlobdata "+ e.getMessage());
          //try local read to avoid context issue
          imageData=this.getBlobdata(table,id,qlf,seq,owner2Code);
         }
        }else{//comes from a file from img dir
         if (qlf==null || qlf==""){
          qlf="jpg";
         }
         //img value can be a folder file or byte data if no # but just "file.data=" exists in it
         //files.get(i).getData() has the byte value and qualifier qlf has the mime
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         imageData=null;
         BufferedImage originalImage=null;
         try{
          ServletContext context = getServletContext();
          if(img.contains("file.data=")){
	   if (file.getMimeFromExtension("").equals("text/plain") || file.getMimeFromExtension("").equals("text/xml")) {
            dataIsClob = true;
           }else {
            dataIsBlob = true;
            imageData = file.getData();
            width=200;
	   }
          }else{
           //if animated gif, ImageIO will copy first image only. save in blob and read  to show animation
           originalImage = ImageIO.read(new java.io.File(context.getRealPath(img)));
           ImageIO.write( originalImage, qlf, baos );
           baos.flush();
           imageData = baos.toByteArray();
           baos.close();
          }
         } catch (Exception e) {
   	   log.severe(table+ "image error "+e);
           return;
	 }
        }
        //check byte array for %PDF change mime and bypass scaling
        if (imageData !=null && imageData.length > 4 && imageData[0] == 0x25 && // % nov24 2020 added check for size
            imageData[1] == 0x50 && // P
            imageData[2] == 0x44 && // D
            imageData[3] == 0x46 && // F, -
            imageData[4] == 0x2D) {
            response.setContentType(getServletContext().getMimeType("application.pdf"));
        }else{
         if(imageData !=null && width !=0){
            imageData=scale(imageData,width,0);
         }else{
            if(imageData !=null && height !=0){
             imageData=scale(imageData,0,height);
         }
         if (imageData !=null && imageData.length > 3 && imageData[0] == 0x47 && // G
            imageData[1] == 0x49 && // I
            imageData[2] == 0x46 && // F
            imageData[3] == 0x38) { // 8
            response.setContentType(getServletContext().getMimeType("application.gif"));
         }else{
          if (imageData !=null && imageData.length > 7 && imageData[0] == 0x89 && //
            imageData[1] == 0x50 && // P
            imageData[2] == 0x4e && // N
            imageData[3] == 0x47 && // G
            imageData[4] == 0x0d && // \r
            imageData[5] == 0x0a && // \n
            imageData[6] == 0x1a && //
            imageData[7] == 0x0a) { // \n
            response.setContentType(getServletContext().getMimeType("application.png"));
           }
          }//contentType cchange
         }//others
        }//pdf vs others
        try{
         if(imageData !=null){
          response.getOutputStream().write(imageData);
         }else{
	  //log.severe("imageData is null for "+ id+" seq "+seq+" width "+width);
          response.setStatus(HttpServletResponse.SC_NO_CONTENT);
         }
        } catch (Exception e) {
   	   log.severe(table+ "image to response error "+e);
           response.setStatus(HttpServletResponse.SC_NO_CONTENT);
           return;
	}
       }//clob vs blob
    }
//balu end

public byte[] scale(byte[] fileData, int width, int height) {
        ByteArrayInputStream in = new ByteArrayInputStream(fileData);
        try {
            BufferedImage img = ImageIO.read(in);
            if(img == null){
             //apr 06 2019 can be null if not image like mp4
             return null;
            }
            if(height == 0) {
                height = (width * img.getHeight())/ img.getWidth();
            }
            if(width == 0) {
                width = (height * img.getWidth())/ img.getHeight();
            }
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0,0,0), null);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            ImageIO.write(imageBuff, "jpg", buffer);

            return buffer.toByteArray();
        } catch (Exception e) {
	  log.severe("id "+ id+" seq "+seq+" width "+width+" "+e.getMessage());
          return null;
        }
    }

     public byte[] getBlobdata(String fromTable,String id,String keyQualifier,int keySequence,String owner2Code) {
      String sqlScript ="";
      keyWPrefix=id;
      try {
       if(keyWPrefix.isEmpty() || keyWPrefix.trim().length() < 2){
        return null;//oct30 2020 avoid exception
       }
       sqlScript="select cc.data from genapp.blobdata cc where cc.fromtable=:fromTable and cc.fromkey=:fromkey and cc.qualifier=:qualifier and cc.sequence = :sequence and cc.owner2=:owner2"  ;
       Query q = entityManager.createNativeQuery(sqlScript);
       q.setParameter("fromTable",fromTable);
       q.setParameter("fromkey",keyWPrefix.substring(1));
       q.setParameter("qualifier",keyQualifier);
       q.setParameter("sequence",keySequence);
       String uScope="";
       if(scope != null){
        uScope=scope.toUpperCase();
       }
       if(uScope.equals("SYSTEM")){
        q.setParameter("owner2", "SYSTEM");
       }else{
        if(uScope.equals(customIdentity.getMasterSiteCode().toUpperCase())){//nov02 2020 oct09 2021
         q.setParameter("owner2", customIdentity.getMasterSiteCode());
        }else{
         q.setParameter("owner2", owner2Code);
        }
       }
       if(!q.getResultList().isEmpty()){
        byte[] bd= (byte[])q.getResultList().get(0);
        return bd;
       }else{
        return null;
       }
      }catch (Exception e){
   	   log.severe("image servlet blobdata sql read error id "+id+" ,qualifier "+keyQualifier+", "+e);
           return null;

      }
  }

public BufferedImage rotateClockwise90(String table,String id,String qlf,int seq,String owner2Code) {
//jpg/png (bits) ->file(byte[] array ->Image(bufferedImage) by ImageIO.Read
//90 degree angle is Math.PI / 2, 180 degrees would be Math.PI
//  byte[] imageData=null;
    BufferedImage dest=null;
    imageData=this.getBlobdata(table,id,qlf,seq,owner2Code);
    ByteArrayInputStream in = new ByteArrayInputStream(imageData);
    try {
     BufferedImage src = ImageIO.read(in);
     int width = src.getWidth();
     int height = src.getHeight();
     dest = new BufferedImage(height, width, src.getType());
     Graphics2D graphics2D = dest.createGraphics();
     graphics2D.translate((height - width) / 2, (height - width) / 2);
     graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
     graphics2D.drawRenderedImage(src, null);
    }catch (Exception e){
   	   log.severe("rotate image error "+e);
           return null;
    }

    return dest;
}

	public String getClobdata(String table,String keyWPrefix,String keyQualifier,int keySequence,int size) {
           String actualTable=table;
           String slobkeyhash=null;
           if(keyWPrefix.length() > 0){
	     	 slobkeyhash = keyWPrefix.substring(1);
           }else{
            return null;
           }
		String qualifier = keyQualifier;
		int sequence = keySequence;


		try {
               Yxxxuq1m1xwwqqqxxxxxclobdata clobdata=null;
		    List<Yxxxuq1m1xwwqqqxxxxxclobdata> results =  entityManager
					.createQuery(
							"select cc from  Yxxxuq1m1xwwqqqxxxxxclobdata cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2  ")
					.setParameter("clobdatafromtable", actualTable).setParameter(
							"clobdatafromkey", slobkeyhash).setParameter(
							"clobdataqualifier", qualifier).setParameter(
							"clobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
                if(!results.isEmpty()){
                 if ( !results.get(0).getZzxxu2oxxhxxxxxxxxxxowner2().equals("SYSTEM")) {
                  clobdata= results.get(0);
                 }else{
                  if (results.size() > 1){
                   clobdata= results.get(1);
                  }else{
                   clobdata= results.get(0);
                  }
                 }
                 if(clobdata==null){
                  return null;
                 }
                }
                else{
                 return null;
                }
                if(clobdata.getB1xxuzaxbvxxxxxxxxxxdata()==null){
                 return null;
                }
                else{
                 int dl=clobdata.getB1xxuzaxbvxxxxxxxxxxdata().length();
                 if (dl > size){
			  return clobdata.getB1xxuzaxbvxxxxxxxxxxdata().substring(0,size);
                 }else {
			  return clobdata.getB1xxuzaxbvxxxxxxxxxxdata();
                 }
                }
		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
         	   log.severe("servlet clobdata sql read error "+e);

			return null;
		}
	}


    /**
    * The following method takes the html string and
    * gets byte[]->outputStream->response to browser to show image
    * like any servlet, this needs an entry in web.xml servlet name ImageServletCdi, class com.rcomputer.genapp.action.ImageServletCdi
    * @param args 2 param1 http request, param2 http response
    * @return void
    * @exception ServletException, IOException
    *
    *
    */
	public void extractImageKeys(byte[] keyData) {
                   String imgUrl=new String(keyData, StandardCharsets.UTF_8);
                   //img src=table=YXXXUH566XWWQQWXXXXXUSER&amp;seq=1&amp;qlf=1&amp;id=X813986167&amp;width=50
                   //60, 104, 116, 109, 108, 62, 10, 60, 104, 101 <html
                   //3c  68  74  6d  6c  3e
                   int index1=imgUrl.indexOf("table=")+6;
                   int index2=imgUrl.indexOf("&",index1);
                   table=imgUrl.substring(index1,index2);

                   index1=imgUrl.indexOf("seq=")+4;
                   index2=imgUrl.indexOf("&",index1);
                   seq=Integer.parseInt(imgUrl.substring(index1,index2));

                   index1=imgUrl.indexOf("qlf=")+4;
                   index2=imgUrl.indexOf("&",index1);
                   qlf=imgUrl.substring(index1,index2);

                   index1=imgUrl.indexOf(";id=")+4;
                   index2=imgUrl.indexOf("&",index1);
                   id=imgUrl.substring(index1,index2);


        }



}