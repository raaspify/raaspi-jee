package com.rcomputer.genapp.action;





/*

* @author Brendan Healey

*

* Originates from BalusC. Used like this:

*

* <h:graphicImage value="/ImageServletCdi/?id=#{tm.id}" default values seq 0,'blobdata','PIC', no scaling
* <h:graphicImage value="/ImageServletCdi/?seq=1&amp;id=A3R-MID-TOP-C&amp;width=700
* <h:graphicImage value="/ImageServletCdi/?img=/img/ecomm-wwwcart.jpg&amp;qlf=jpg&amp;height=110">

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








@WebServlet(name = "SitemapServletCdi", urlPatterns = {"/sitemap.xml"})

public class SitemapServletCdi extends HttpServlet {
      @PersistenceContext(unitName = "genappcdi")
      EntityManager entityManager;

      @Inject
      Yxxxuq1m1xwwqqqxxxxxclobdataHome yxxxuq1m1xwwqqqxxxxxclobdataHome;
      private Yxxxuq1m1xwwqqqxxxxxclobdata yxxxuq1m1xwwqqqxxxxxclobdata;
     //call getclobdata via sessionscoped sqlAdminSupport
     @Inject
     SqlAdminSupport sqlAdminSupport;
     @Inject CustomIdentity customIdentity;

     private Logger log = Logger.getLogger(ImageServletCdi.class.getCanonicalName());
     Integer urlIndex;
     String owner2Code=null;
     private ServletContext context=null;





//balu
/**
 Do not use it unless scaling is involved, replaces s:transformsize
 width=0 and height=0 means no scaling
 img != null means image value supplied either \img\Cart32.png etc or #{file.data}
 *doGet intercepts HTTP Get requests, also need an entry in web.xml servlet name ImageServletCdi, class com.rcomputer.genapp.action.ImageServletCdi
 *and sends back response.getOutputStream().write(imageData)ie byte[]->outputStream->response to browser to show image
**/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //initially respond content of clobdata(String id = request.getPathInfo().trim().substring(1);
        //jun01 2018 scope SYSTEM means get system images, if null or any other value get owner2 only
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

        String clobdata=sqlAdminSupport.getClobdata("clobdata","A3R-siteMap","TXT",0,120000,owner2Code);
        response.setContentType("text/xml");
         try{
          ServletContext context = getServletContext();
         } catch (Exception e) {
   	   log.severe("sitemap servlet context error "+e);
           return;
	 }
        try{
         if(clobdata !=null){
          response.getWriter().write(clobdata);
         }else{
          response.setStatus(HttpServletResponse.SC_NO_CONTENT);
         }
        } catch (Exception e) {
   	   log.severe("sitemap to response error "+e);
           response.setStatus(HttpServletResponse.SC_NO_CONTENT);
           return;
	}




    }
//balu end




}