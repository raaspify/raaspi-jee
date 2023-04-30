<#assign tobegeneratedCandidate = "N">  
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign homeName = componentName + "Home">
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#assign menuAttributes2 = pojo.shortName?substring(0,eL)>
<#-- jay remove hard code -->
<#if (menuAttributes2?substring(efS,efE) == '1a' | menuAttributes2?substring(efS,efE) == '18' | menuAttributes2?substring(efS,efE) == '89' )
     | menuAttributes2?substring(efS,efE) == '20' | menuAttributes2?substring(efS,efE) == '30'| menuAttributes2?substring(efS,efE) == '40'
      | menuAttributes2?substring(efS,efE) == '9a' | menuAttributes2?substring(efS,efE) == '52'    >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
package ${actionPackage};
<#if pojo.packageName != "">
import ${pojo.packageName}.*;
</#if>
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
@Named("${componentName}CalendarService")
@Path("/${componentName?substring(eL)}t")
public class ${componentName?cap_first}CalendarService 
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

   private Logger log = Logger.getLogger(${entityName}.class.getCanonicalName());
	@Inject
	Identity identity;
   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
    @Inject CustomIdentity customIdentity; 
   <#if (menuAttributes2?substring(efS,efE) == '52') >
    @Inject ${scheduleEntityName?cap_first} ${scheduleEntityName};
   </#if>
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
       

      <#if (menuAttributes2?substring(efS,efE) == '20') >
      List<Object[]> items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.c1xxuslnbvixxxxxxxxxlastname ||' , ' || coalesce(c.p1xxh4pobv27xxxxxxxxphoneo,'')||' (o)  '|| coalesce(c.p2xxh5phbv27xxxxxxxxphoneh,'')||' (h)  '|| coalesce(c.p3xxhxxxbv27xxxxxxxxphonec,'')||' (c)  '  , c.yfxxcxxybvxxxxxxxxxxnxtcontact from ${componentName?cap_first} c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and c.zdxxutoxlhxxxxxxxxxxowner=:owner order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).setParameter("owner", ownerCode).getResultList();
      </#if> 
      <#if (menuAttributes2?substring(efS,efE) == '30') >
      List<Object[]> items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxukxxbvxxxxxxxxxxvendor, c.o3xxuxxrbvxxxxxxxxxxcontacted from ${componentName?cap_first} c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).getResultList();
      </#if> 
      <#if (menuAttributes2?substring(efS,efE) == '40') >
      List<Object[]> items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxuktxbvxxxxxxxxxxemployee, c.y8xxcxxrbvxxxxxxxxxxcontacted from ${componentName?cap_first} c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).getResultList();
      </#if> 
      <#if (menuAttributes2?substring(efS,efE) == '1a') >
      List<Object[]> items = null;
      if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ") || customIdentity.hasRole("VH") || customIdentity.hasRole("PH") ){
       items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxukixbxxxxxxxxxxxmatcode, c.z2xxcsxrlxxxxxxxxxxxdateadded from ${componentName?cap_first} c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and c.zzxxu2oxxhxxxxxxxxxxowner2=:ownerCode order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).setParameter("owner", ownerCode).getResultList();
      }else{
       items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxukixbxxxxxxxxxxxmatcode, c.c2fbcxxrehxxsxxxxxxxspriceffdt from ${componentName?cap_first} c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).getResultList();
      }

      </#if> 
      <#if (menuAttributes2?substring(efS,efE) == '18') >
      List<Object[]> items =
            entityManager.createQuery("select c.a0xxuobxbxxxxxxxxxxxsid, c.a0xxukaxbvxxxxxxxxxxactivitycode, c.c8xxcxxrlxxxxxxxxxxxeffdate from ${componentName?cap_first} c  where c.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by c.a0xxuobxbxxxxxxxxxxxsid  asc")
             .setParameter("owner2", owner2Code).getResultList();
      </#if> 
      <#if (menuAttributes2?substring(efS,efE) == '89') >
      List<Object[]> items =
            entityManager.createQuery("select   s.a0xxuobxbxxxxxxxxxxxsid,s.b1xxhszsbv35xxxxxxxxdescript ||' , ' || coalesce((select c.c1xxuslnbvixxxxxxxxxlastname  from ${customerEntityName?cap_first} c where s.${customerEntityName}=c.a0xxuobxbxxxxxxxxxxxsid),'') || coalesce((select e.b3xxuslnbvixxxxxxxxxlastname  from ${employeeEntityName?cap_first} e where s.${employeeEntityName}=e.a0xxuobxbxxxxxxxxxxxsid),'') || coalesce((select v.b3xxuslnbvxxxxxxxxxxlastname  from ${vendorEntityName?cap_first} v where s.${vendorEntityName}=v.a0xxuobxbxxxxxxxxxxxsid),'')  , s.b5gxdxsdbvxxxxxxxxxxsdatet from ${scheduleEntityName?cap_first} s where s.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by s.b1xxhszsbv35xxxxxxxxdescript  asc")
             .setParameter("owner2", owner2Code).getResultList();
          
            //entityManager.createQuery("select   s.a0xxuobxbxxxxxxxxxxxsid,coalesce((select p.b1xxhszsbv35xxxxxxxxdescript from ${scheduleEntityName?cap_first} p where s.${scheduleEntityName}=p.a0xxuobxbxxxxxxxxxxxsid),'')||'-'  || coalesce((select c.c1xxuslnbvixxxxxxxxxlastname  from ${customerEntityName?cap_first} c where s.${customerEntityName}=c.a0xxuobxbxxxxxxxxxxxsid),'')||'/' || coalesce((select e.b3xxuslnbvixxxxxxxxxlastname  from ${employeeEntityName?cap_first} e where s.${employeeEntityName}=e.a0xxuobxbxxxxxxxxxxxsid),'')||'/' || coalesce((select v.b3xxuslnbvxxxxxxxxxxlastname  from ${vendorEntityName?cap_first} v where s.${vendorEntityName}=v.a0xxuobxbxxxxxxxxxxxsid),'')  , coalesce((select p.b5gxdxsdbvxxxxxxxxxxsdatet  from Fxxxuq89bxwwqqhxxxxxschedule p where s.fxxxuq89bxwwqqhxxxxxschedule=p.a0xxuobxbxxxxxxxxxxxsid),null) from  ${scheduleDetailsEntityName?cap_first} s where s.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by s.a0xxuobxbxxxxxxxxxxxsid  asc")
            // .setParameter("owner2", owner2Code).getResultList(); dont use detail


      </#if> 
      <#-- 52/client shows filtered calendar for visitors -->
      <#if (menuAttributes2?substring(efS,efE) == '52') >
      List<Object[]> items =
            entityManager.createQuery("select   s.a0xxuobxbxxxxxxxxxxxsid,s.b1xxhszsbv35xxxxxxxxdescript ||' , ' || coalesce((select c.c1xxuslnbvixxxxxxxxxlastname  from ${customerEntityName?cap_first} c where s.${customerEntityName}=c.a0xxuobxbxxxxxxxxxxxsid),'') || coalesce((select e.b3xxuslnbvixxxxxxxxxlastname  from ${employeeEntityName?cap_first} e where s.${employeeEntityName}=e.a0xxuobxbxxxxxxxxxxxsid),'') || coalesce((select v.b3xxuslnbvxxxxxxxxxxlastname  from ${vendorEntityName?cap_first} v where s.${vendorEntityName}=v.a0xxuobxbxxxxxxxxxxxsid),'')  , s.b5gxdxsdbvxxxxxxxxxxsdatet from ${scheduleEntityName?cap_first} s where s.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and s.bexxuxxrbv37xxxxxxxxtype = :type order by s.b1xxhszsbv35xxxxxxxxdescript  asc")
             .setParameter("owner2", owner2Code).setParameter("type", "FP").getResultList();

      </#if> 
      <#if (menuAttributes2?substring(efS,efE) == '9a') >
      List<Object[]> items =
            entityManager.createQuery("select   s.a0xxuobxbxxxxxxxxxxxsid,s.a0xxukxxbvxxxxxxxxxxjobassign, s.b5gxdxsdbvxxxxxxxxxxsdatet from ${componentName?cap_first} s where s.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by s.a0xxukxxbvxxxxxxxxxxjobassign  asc")
             .setParameter("owner2", owner2Code).getResultList();

      </#if> 

      StringBuilder s = new StringBuilder();
      s.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      s.append("<root>\n");
      <#--item[1] descript (needs xml escape) as key,item[2] date as value, item[0] sid as url used to connect parent with children nodes     -->
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
       <#if (menuAttributes2?substring(efS,efE) != '52') >
        if (!identity.isLoggedIn()) {
         return false;
        }
       </#if> 
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
</#if>
</#if>