package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;
import org.picketlink.Identity;
import javax.persistence.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
//import javax.persistence.EntityManager;
import java.util.GregorianCalendar;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;
import java.util.Base64;
import java.util.UUID;

/**
* provides chart data for xxbar.xhtml or xxline.xhtml
* there are 4 rest supporting module
* (1)shoppingCartBean is a restClient meant for payPal and uses paypal restClient apis(why does it have rest jar?)
* (2)R3RestClient is also a restClient but meant for Shopify and uses jax-rs apis
* (3)xxxPie/BarCharts uses javaScript based rest client to call 3r xxxEntityServices
* (4)xxxEntityService beans not client but server rest services and called by rest clients
*
* @author 3R Computer 
*/
@Named("jxxxuq201xwwqqhxxxxxcustomerEntityService")
@ApplicationPath("rest")
@Path("/customerq")
public class Jxxxuq201xwwqqhxxxxxcustomerEntityService extends Application
{
     private String owner2Code="";
     private int urlIndex=0;
     private String select="m";
     private String data="a";
     private String selectdata="ma";
     
   private Logger log = Logger.getLogger(Jxxxuq201xwwqqhxxxxxcustomer.class.getCanonicalName());
   @Inject
   Identity identity;
   @Inject CustomIdentity customIdentity;
   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;

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

      List<Object[]> items = null;
      int i=0;
      if(selectdata.equals("ma")){
        items = entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxukxxbvxxxxxxxxxxcustomer,c.c1xxuslnbvixxxxxxxxxlastname || ' ' || c.c2xxu2fnbvixxxxxxxxxfirstname,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname, c.z1xxzrpxlexxxxxxxxxxcusttotl,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname,c.z2xxzrqxlexxxxxxxxxxcusttqty,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname,c.z1xxzrrplexxxxxxxxxxcusrtotl,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname,c.z2xxzrrqlexxxxxxxxxxcusrtqty,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname,c.zcxxzxxxlvxxxxxxxxxxtotlpaid,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname,c.z3xxzrmplexxxxxxxxxxcusmtotl,c.d1xxu3cnbvixxxxxxxxxcustomerascompanyname,c.z4xxzrdplexxxxxxxxxxcusdtotl from Jxxxuq201xwwqqhxxxxxcustomer c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by c.zbxxcztxlxxxxxxxxxxxstatusfldt  desc").setMaxResults(6)
            .setParameter("owner2", owner2Code).getResultList();
       }
      else{
       if(selectdata.equals("mr")){
        items = entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxukxxbvxxxxxxxxxxcustomer, c.z1xxzrrplexxxxxxxxxxcusrtotl from Jxxxuq201xwwqqhxxxxxcustomer c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zaxxzzfxhhxxxxxxxxxxstatusfl > 127  order by c.zbxxcztxlxxxxxxxxxxxstatusfldt  desc").setMaxResults(6)
            .setParameter("owner2", owner2Code).getResultList();
       }
       else{
       }
      }
      // jqplot expects xml data as follows
      // [data] where data is [],[] for pie or for 2 sets/series of bar/line charts  or [] for single set/series
      //pie chart  [[[n,v],[n,v]]] n name and v value
      //bar chart  [[v,v,v,v][v,v,v]] v y axis value x axis will show 1,2 etc
      //    ticks  [n,n,n,n]  n x axis tick names instead of 1,2  
      //line chart [[v,v,v]]  v y axis values x axis done automatically to show 1,2
      //    each group of [n.v] or [v,v..] is part of series
      //    series label [{label:"xx"},]    
      // pie chart series will be added later,but bar chart needs series now
      // pie chart will show distribution of say amount of purchase  among customers 
      // bar chart will show purchase amt, return amt etc for one customer and same thing for others 
      // in the series
      // rest request will be /seam/resource/rest/customerq/{m(arked)}/a(mt)q(ty)
      //                                                                         /a(ll)/r(trn)
      //                                                                         /k(ey)xxxxx/m(isc)
      //                                                                         /m/m(etrics)
      // key value is returned so that req and resonse can be matched for added integrity checking
      StringBuilder s = new StringBuilder();
      //xml hdr
      //<root>
      //  <entity>
      //   <key>
      //   </key>
      //   <label>
      //   </label>
      //   <metrix>
      //    <item> 
      //    <value>
      //    <item>
      //    <value>
      //    .
      //    .
      //   </metrix>
      //   .. 
      //  </entity>  
      //  ...
      //</root>
      s.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      s.append("<root>\n");
      for (Object[] item : items)
      {
         s.append("\t<entity>\n");
          s.append("\t<key>" + item[i+1] + "</key>\n");
          s.append("\t<label>" + item[i+2] + "</label>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+3] + "</item>\n");
           s.append("\t<value>" + item[i+4] + "</value>\n");
          s.append("\t</metrix>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+5] + "</item>\n");
           s.append("\t<value>" + item[i+6] + "</value>\n");
          s.append("\t</metrix>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+7] + "</item>\n");
           s.append("\t<value>" + item[i+8] + "</value>\n");
          s.append("\t</metrix>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+9] + "</item>\n");
           s.append("\t<value>" + item[i+10] + "</value>\n");
          s.append("\t</metrix>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+11] + "</item>\n");
           s.append("\t<value>" + item[i+12] + "</value>\n");
          s.append("\t</metrix>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+13] + "</item>\n");
           s.append("\t<value>" + item[i+14] + "</value>\n");
          s.append("\t</metrix>\n");
          s.append("\t<metrix>\n");
           s.append("\t<item>" + item[i+15] + "</item>\n");
           s.append("\t<value>" + item[i+16] + "</value>\n");
          s.append("\t</metrix>\n");

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
