package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;
import org.picketlink.Identity;
import javax.persistence.*;
import javax.annotation.PostConstruct;

import javax.ws.rs.*;
import java.util.GregorianCalendar;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.apache.commons.lang3.StringEscapeUtils;
import javax.ws.rs.core.MediaType;
import java.util.Base64;
import java.util.UUID;





/**
 * @author 3r computer Systems
 */
@Named("jxxxbh400xwwqqhxxxxxemployeeCalendarService")
@Path("/employeet")
public class Jxxxbh400xwwqqhxxxxxemployeeCalendarService 
{
     private String owner2Code="";
     private int urlIndex=0;
     private String ownerCode="sss";
    /*  wildfly ok but tomee error @session context not in this thread. Currently ownerCode is not used
    @PostConstruct
    public void initialize() {
      ownerCode=customIdentity.getOwner();
    }
    */

   private Logger log = Logger.getLogger(Jxxxbh400xwwqqhxxxxxemployee.class.getCanonicalName());
	@Inject
	Identity identity;
   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
    @Inject CustomIdentity customIdentity; 
   @GET
   @Produces("application/xml")
   public String getItems(@HeaderParam("Host") String hostName,@HeaderParam("Authorization") String authString)
   {
     if(!isUserAuthenticated(authString)){
            return "User not authenticated";
     }
     String[] str = hostName.split(":");//serverName+port localhost:8080 
     String serverName=str[0];

     String urlName=serverName;
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
       

      List<Object[]> items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxuktxbvxxxxxxxxxxemployee, c.y8xxcxxrbvxxxxxxxxxxcontacted from Jxxxbh400xwwqqhxxxxxemployee c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).getResultList();

      StringBuilder s = new StringBuilder();
      s.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      s.append("<root>\n");
      for (Object[] item : items)
      {
         s.append("\t<entity>\n");
          s.append("\t<Item>" + StringEscapeUtils.escapeXml(item[1].toString()) + "</Item>\n");
          s.append("\t<Value>" + item[2].toString() + "</Value>\n");
          s.append("\t<ItemUrl>" + item[0].toString() + "</ItemUrl>\n");
         s.append("\t</entity>\n");
      }
      s.append("</root>\n");
      return s.toString();
   }
    private boolean isUserAuthenticated(String authString){
        if (!identity.isLoggedIn()) {
         return false;
        }
        if(authString == null || authString.length() <7){
         return false;
        }
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = Base64.getDecoder().decode(authString.substring("Basic ".length()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
	    log.severe("Authentication error"+e.getMessage());
            return false;
        }
        decodedAuth = new String(bytes);
         
        /** 
         for now hardcoded value, in future look into getting from server
         it still checks for loggedIn first to protect against typing in /rest/itemq
         */
        if(decodedAuth.equals("clientId:restPW")){
         return true;
        }else{
         return false;
        }
    }

    public String generateuuid(){
     final String uuid = UUID.randomUUID().toString().replace("-", "");
     return uuid;
    }
   public void BasicSend(){
    //payload = 'Basic ' + base64encode(username + ':' + password);
    //httpRequest.addHeader('Authorization', payload)   
   }

}
