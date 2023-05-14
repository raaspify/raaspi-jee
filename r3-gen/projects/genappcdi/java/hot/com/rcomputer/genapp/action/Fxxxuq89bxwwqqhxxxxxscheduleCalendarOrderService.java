package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;
import org.picketlink.Identity;
import javax.persistence.*;
import javax.annotation.PostConstruct;

import javax.ws.rs.*;
import javax.persistence.EntityManager;
import java.util.GregorianCalendar;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;
import java.util.Base64;
import java.util.UUID;




/**
* This gets calendar data for orders 
* there are 4 rest supporting module
* (1)shoppingCartBean is a restClient meant for payPal and uses paypal restClient apis(why does it have rest jar?)
* (2)R3RestClient is also a restClient but meant for Shopify and uses jax-rs apis
* (3)xxxPie/BarCharts uses javaScript based rest client to call 3r xxxEntityServices
* (4)xxxEntityService beans not client but server rest services and called by rest clients
*
* @author 3r computer Systems
*/
@Named("fxxxuq89bxwwqqhxxxxxscheduleCalendarOrderService")
@Path("/scheduleo")
public class Fxxxuq89bxwwqqhxxxxxscheduleCalendarOrderService 
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
   private Logger log = Logger.getLogger(Fxxxuq89bxwwqqhxxxxxschedule.class.getCanonicalName());
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
            entityManager.createQuery("select  s from Fxxxuq89bxwwqqhxxxxxschedule s where s.a0xxuobxbxxxxxxxxxxxsid,s.b1xxhszsbv35xxxxxxxxdescript ||' , ' || coalesce((select c.c1xxuslnbvixxxxxxxxxlastname  from Jxxxuq201xwwqqhxxxxxcustomer c where s.jxxxuq201xwwqqhxxxxxcustomer=c.a0xxuobxbxxxxxxxxxxxsid),'') || coalesce((select e.b3xxuslnbvixxxxxxxxxlastname  from Jxxxbh400xwwqqhxxxxxemployee e where s.jxxxbh400xwwqqhxxxxxemployee=e.a0xxuobxbxxxxxxxxxxxsid),'') || coalesce((select v.b3xxuslnbvxxxxxxxxxxlastname  from Jxxxuq300xwwqqhxxxxxvendor v where s.jxxxuq300xwwqqhxxxxxvendor=v.a0xxuobxbxxxxxxxxxxxsid),'')  , s.b5gxdxsdbvxxxxxxxxxxsdatet from Fxxxuq89bxwwqqhxxxxxschedule s where s.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by s.b1xxhszsbv35xxxxxxxxdescript  asc")
             .setParameter("owner2", owner2Code).getResultList();


      StringBuilder s = new StringBuilder();
      s.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      s.append("<root>\n");
      for (Object[] item : items)
      {
         s.append("\t<entity>\n");
          s.append("\t<Item>" + item[1] + "</Item>\n");
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
