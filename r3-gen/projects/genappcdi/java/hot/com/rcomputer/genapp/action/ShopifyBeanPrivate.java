package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance; 
import javax.enterprise.inject.Alternative;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.faces.application.FacesMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.net.URI;
import java.util.Date;
import java.util.Calendar;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.google.gson.GsonBuilder; 
import com.google.gson.Gson; 
import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonParser; 
import com.google.gson.JsonElement; 
import com.google.gson.JsonObject; 
import com.google.gson.JsonPrimitive; 
import com.google.gson.JsonArray; 
import com.google.gson.annotations.Expose;
import com.google.gson.FieldNamingPolicy;
import java.util.ResourceBundle;
import java.lang.Object;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import java.math.BigDecimal;


@Named("r3ShopifyAdminP")
@SessionScoped //if basic auth

public class ShopifyBeanPrivate implements java.io.Serializable{
     private Logger log = Logger.getLogger(ShopifyBeanPrivate.class.getCanonicalName());
     @PersistenceContext(unitName = "genappcdi")
     private EntityManager entityManager;

     @Inject
     Yxxxch522xhhxxhxxxxxclientHome yxxxch522xhhxxhxxxxxclientHome;
     Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient;
     @Inject
     CustomIdentity customIdentity;
     @Inject
     Fpxxfq1a5xwwqqhxxxxxitemHome fpxxfq1a5xwwqqhxxxxxitemHome;
     @Inject
     Fpxxfq1a5xwwqqhxxxxxitemList fpxxfq1a5xwwqqhxxxxxitemList;



      private int mactive=1;
      // && 2nd bit                4 
      private int _mclosed=3;
      private int _mpartial=5;
      // && 5th                   32 
      private int _mconsign=6;
      // && 6th                   64
   private ResourceBundle bundle=null;
    private FacesContext facesContext=null;

               ExternalContext externalContext=null;
               ServletContext context=null;
               HttpServletRequest requestH=null;
                 String code=null; 
                 String hmac=null; 
                 String shop=null; 
                 String state=null; 
                 String time=null; 
   private Calendar calendar = Calendar.getInstance();
   private Calendar calendare = Calendar.getInstance();
   private String owner2Code="";
   private String urlName=null;
   private int urlIndex=0;




    @PostConstruct
    public void initialize() {
      facesContext = FacesContext.getCurrentInstance(); 
      if(facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       externalContext = facesContext.getExternalContext(); 
       context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext(); 
       requestH = (HttpServletRequest) externalContext.getRequest(); 
       urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();

       if(urlName.contains(".lraaspi.com")){
        urlIndex=urlName.lastIndexOf(".lraaspi.com");
       }
       else{
        urlIndex=urlName.lastIndexOf(".raaspi.com");
       }
       if (urlIndex == -1){
                 urlIndex=urlName.lastIndexOf(".");
                 if (urlIndex == -1){
                  urlIndex=urlName.length();
                 }
       }
       if (urlName.contains("www.")){
                  owner2Code=urlName.substring(4,urlIndex);
       }else{
                  owner2Code=urlName.substring(0,urlIndex);
       }


      }
    }




    /**
    * Raaspi pulls data from shopify using html basic auth ie id/password already defined in Shopify for a private app
    * @param args-option 1 restPath is used to the rest request path like //admin/products.json
    * option 2 shopName is the shop name. Shopify shops will use common Rasspi site for backOfficce and 
    * parameter two says whose data will be used and apiKey is stored as a virtual client id
    * Using option two as the key we can get Shopify shop basic authentication id/password.
    * @return none void type
    * @exception None.
    * @see 
    * https://apikey:password@hostname/admin/resource.json
    * https://3883bace594b967c12f7c01f37beb904:4968376be18028c1a9fbc9d20f65c49e@raaspishopify.myshopify.com/admin/products.json
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath 
    */

         public String connectnBaseAuthorizenData(String restPath, String shopName){
                 //clear msg because session scope??
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"",""));

                 Yxxxch522xhhxxhxxxxxclient client;
                 try{
                     client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"from Yxxxch522xhhxxhxxxxxclient where a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       // first check whether Client Table is locked for Bus Date maintenance , not sure where is the lock logic
                       // remove hard coded property names
			  int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
      		        //FacesMessages.instance().add("#{messages['system_maintence_try_later']}");
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("api")+bundle.getString("key")+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));

		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
      		        //FacesMessages.instance().add("#{messages['service_decommisoned']}");
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

          		       }
                        // update changes the client statusfldate and tracks when last logon for this tenant
			client.setZfxxcztxlxxxxxxxxxxxstatusfldt(Calendar.getInstance().getTime());
                        yxxxch522xhhxxhxxxxxclientHome.allowUpdate();

                      }
	             } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("no")+" "+bundle.getString("client")+" "+bundle.getString("record")+" "+bundle.getString("entry")+" "+bundle.getString("for")+" "+shopName,""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("use")+" "+bundle.getString("raaspi.com")+" "+bundle.getString("to")+" "+bundle.getString("create")+" "+bundle.getString("site")+" "+shopName,""));

                        return null;   
                       
                     }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+ex.getMessage(),""));
                        return null;   

                     }
 	  try {
                //String restApiUrl="https://raaspishopify.myshopify.com";
                String clId=client.getDaxxuzxdssxxxxxxxxxxapiclientid();
                String clPW=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret();
                String auth = clId + ":" + clPW;
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
                String authHeader = "Basic " + new String(encodedAuth);
                if(client.getD7xxuxxrbvxxxxxxxxxxinraddr() != null && !client.getD7xxuxxrbvxxxxxxxxxxinraddr().isEmpty()){
                 shopName=client.getD7xxuxxrbvxxxxxxxxxxinraddr();
                } 
                String restApiUrl="https://"+auth+"@"+shopName;
     
		ClientRequest request = new ClientRequest(restApiUrl + restPath);
                request.accept(MediaType.TEXT_PLAIN);
                request.header("AUTHORIZATION", authHeader);
		ClientResponse<String> response = request.get(String.class);


		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));
                String pp90="";
		String output;
		String outputs="";
		while ((output = br.readLine()) != null) {
                     outputs=outputs+System.lineSeparator()+output;
		}
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,outputs,""));
                Fpxxfq1a5xwwqqhxxxxxitem itemP;
                String respString= response.getEntity(String.class);//get message entity
                JsonElement jelement = new JsonParser().parse(respString);
                JsonObject jobject = jelement.getAsJsonObject();

                JsonArray jarray = jobject.getAsJsonArray("products");

                GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategy());
                Gson gson = gsonBuilder.create();
                Fpxxfq1a5xwwqqhxxxxxitem[] items = gson.fromJson(jarray.toString(), Fpxxfq1a5xwwqqhxxxxxitem[].class);
                Fpxxfq1a5xwwqqhxxxxxitem categoryItem=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity("Products_via_API");         
                if(categoryItem==null){
                 fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance(); 
                 itemP=fpxxfq1a5xwwqqhxxxxxitemHome.getInstance();
                 itemP.setA0xxukixbxxxxxxxxxxxmatcode("Products_via_API");
                 itemP.setC6xxusxrbv16xxxxxxxxtype("SI-L1");
                 itemP.setZ2xxcsxrlxxxxxxxxxxxdateadded(new Date());
                 fpxxfq1a5xwwqqhxxxxxitemHome.setInstance(itemP);
                 fpxxfq1a5xwwqqhxxxxxitemHome.persist();
                }
                for (Fpxxfq1a5xwwqqhxxxxxitem item : items){
                   pp90="";
                   // getinstance
                   itemP=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity(item.getA0xxukixbxxxxxxxxxxxmatcode()); 
                   fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance(); 
                   item.setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                   if(item.getC6xxusxrbv16xxxxxxxxtype() == null || item.getC6xxusxrbv16xxxxxxxxtype().isEmpty() ){
                    item.setC6xxusxrbv16xxxxxxxxtype("SI-D");
                   }
                   if(item.getZ5xxzzfxhhxxxxxxxxxxstatusfl() == null ){
                    item.setZ5xxzzfxhhxxxxxxxxxxstatusfl(0);
                   }
                   if(item.getC4fbzxxxbvxxxxxxxxxxqtylevel1() == null ){
                    item.setC4fbzxxxbvxxxxxxxxxxqtylevel1(new BigDecimal("0.0"));
                   }

                   if(item.getB8fbzpxxbvxxxxxxxxxxselprice() == null ){
                    item.setB8fbzpxxbvxxxxxxxxxxselprice(new BigDecimal("0.0"));
                   }
                   if(item.getB6fbzicxbvxxxxxxxxxxcost() == null ){
                    item.setB6fbzicxbvxxxxxxxxxxcost(new BigDecimal("0.0"));
                   }

                   if(item.getZ2xxcsxrlxxxxxxxxxxxdateadded() == null){
                    item.setZ2xxcsxrlxxxxxxxxxxxdateadded(new Date());
                   }
                   if(item.getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
                    if(item.getFpxxfq1a5xwwqqhxxxxxitem() ==null){
                     item.setFpxxfq1a5xwwqqhxxxxxitem(categoryItem);  
                    }
                   }
                   fpxxfq1a5xwwqqhxxxxxitemHome.setInstance(item);
                   if(itemP !=null){
                    if(item.getZ6xxcztxlxxxxxxxxxxxstatusfldt() != null){
                     calendare.setTime(item.getZ6xxcztxlxxxxxxxxxxxstatusfldt());
                     calendar.setTime(itemP.getZ6xxcztxlxxxxxxxxxxxstatusfldt());
                     if(calendar.before(calendare)){
                      fpxxfq1a5xwwqqhxxxxxitemHome.update();
                     }else{
                      //no change , skip
                     }
                    }else{
                     //already exists,assume no change and skip
                    }
                   }else{
                    //does not exist
                      fpxxfq1a5xwwqqhxxxxxitemHome.persist();
                   }
                }
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("completed"),""));



	  } catch (ClientProtocolException e) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

	  } catch (IOException e) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

	  } catch (Exception e) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

	  }




          
          return null; 



         }
     public boolean isBitSet(Integer a, Integer n){ 
      if (a == null){
       a=0;
      }
      return (a & (1 << n)) != 0; 
     }





}