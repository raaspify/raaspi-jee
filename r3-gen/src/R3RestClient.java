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
import javax.transaction.Transactional;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.math.BigDecimal;
import org.picketlink.Identity;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;






/**
* meant for Shopify and uses jax-rs apis
* there are 4 rest supporting module
* (1)shoppingCartBean is a restClient meant for payPal and uses paypal restClient apis(why does it have rest jar?)
* (2)R3RestClient is also a restClient but meant for Shopify and uses jax-rs apis
* (3)xxxPie/BarCharts uses javaScript based rest client to call 3r xxxEntityServices
* (4)xxxEntityService beans not client but server rest services and called by rest clients
*
* raaspi       client record 01 has paypal  id/secret
*     02 has shopify id/secret for a specific app  like raasbackoffice
* Once App is installed via raaspi install App menue
* xxbackoffice client record 01 has paypal  id/secret (if needed)
* xxbackoffice "      "      02 has shopify oauth token for an app and store combination. no clientId just token
* xx means say raaspifybackoffice or another shopify store backoffice site
*
* @author 3r Computer Systems
*/

@Named("r3RestClient")
@SessionScoped //if basic auth
//https://3883bace594b967c12f7c01f37beb904:4968376be18028c1a9fbc9d20f65c49e@raaspishopify.myshopify.com/admin/products.json
//
// if oAuth then simply send http req with token, but getting token is multisteps
//1 ask for permission and installation approval first ie connect and authorize
// https://raaspishopify.myshopify.com/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4&amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow&amp;scope=read_products&amp;state=001%20&amp;grant_options[]=
// https://raaspishopify.myshopify.com/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]=
// https://raaspishopify.myshopify.com/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=https://c485c194.ngrok.io/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]=
/// in shopifyBackOffice url put just shopify url ie raaspishopify.myshopify.com
//2 response will be accesscode and hmac,shop,state and time
// {X-Frame-Options=[DENY], Content-Type=[text/html; charset=utf-8], X-Sorting-Hat-PodId=[18, 18], Transfer-Encoding=[chunked], Location=[https://raaspishopify.myshopify.com/admin/auth/login], X-Permitted-Cross-Domain-Policies=[none], X-Sorting-Hat-ShopId-Cached=[0, 0], X-Request-ID=[56fc9489-1793-4b62-b69b-c0dbdc9625ac], Date=[Fri, 04 Aug 2017 00:14:26 GMT], X-Content-Type-Options=[nosniff, nosniff, nosniff], X-ShopId=[21949653], Connection=[keep-alive], X-Sorting-Hat-Section=[pod, pod], X-ShardId=[18], X-Download-Options=[noopen], Content-Security-Policy=[default-src 'self' data: blob: 'unsafe-inline' 'unsafe-eval' https://* shopify-pos://*; block-all-mixed-content; child-src 'self' https://* shopify-pos://*; connect-src 'self' wss://* https://*; script-src https://cdn.shopify.com https://checkout.shopifycs.com https://js-agent.newrelic.com https://bam.nr-data.net https://dme0ih8comzn4.cloudfront.net https://api.stripe.com https://mpsnare.iesnare.com https://appcenter.intuit.com https://www.paypal.com https://maps.googleapis.com https://stats.g.doubleclick.net https://www.google-analytics.com https://visitors.shopify.com https://v.shopify.com https://widget.intercom.io https://js.intercomcdn.com 'self' 'unsafe-inline' 'unsafe-eval'; upgrade-insecure-requests; report-uri /csp-report?source%5Baction%5D=authorize&source%5Bapp%5D=Shopify&source%5Bcontroller%5D=admin%2Foauth&source%5Bsection%5D=admin&source%5Buuid%5D=56fc9489-1793-4b62-b69b-c0dbdc9625ac], X-Dc=[chi2,ash], P3P=[CP="NOI DSP COR NID ADMa OPTa OUR NOR"], X-XSS-Protection=[1; mode=block; report=/xss-report?source%5Baction%5D=authorize&source%5Bapp%5D=Shopify&source%5Bcontroller%5D=admin%2Foauth&source%5Bsection%5D=admin&source%5Buuid%5D=56fc9489-1793-4b62-b69b-c0dbdc9625ac], Referrer-Policy=[origin-when-cross-origin], X-Sorting-Hat-ShopId=[21949653, 21949653], X-Sorting-Hat-PodId-Cached=[0, 0], Set-Cookie=[_secure_admin_session_id=2a58da236fffaff80c620138280f84ce; path=/admin; expires=Sat, 04 Nov 2017 00:14:26 -0000; secure; HttpOnly], Server=[nginx], Strict-Transport-Security=[max-age=7776000]}
// http://raasbackoffice.lraaspi.com:8080/shopifyBackOffice.wflow?code=85852c0ae5417dc0fd2d903b82fb8198&hmac=c8b284ee83fa87d3970fa99b8d71c8932c430fa6e276caa6e7cc7dd90b924ffb&shop=raaspishopify.myshopify.com&state=001+&timestamp=1501639888
// validate data to make sure it came from shopify
// accessCode needs to be exchanged for accessToken by asking Shopify with admin rest api
//   /admin/oauth/access_token
// once access token is obtained authenticated rest api reqs are done by including header X-Shopify-Access-Token: {access_token}

public class R3RestClient implements java.io.Serializable{
     private Logger log = Logger.getLogger(R3RestClient.class.getCanonicalName());
     @PersistenceContext(unitName = "genappcdi")
     private EntityManager entityManager;

     @Inject
     Yxxxch522xhhxxhxxxxxclientHome yxxxch522xhhxxhxxxxxclientHome;
     Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient;
     @Inject
     Yxxxch522xhhxxhxxxxxclientList yxxxch522xhhxxhxxxxxclientList;
     @Inject
     Yxxxuh566xwwqqwxxxxxuserHome yxxxuh566xwwqqwxxxxxuserHome;
     Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser;
	@Inject
	Yxxxuq1m1xwwqqqxxxxxclobdataHome yxxxuq1m1xwwqqqxxxxxclobdataHome;
	private Yxxxuq1m1xwwqqqxxxxxclobdata yxxxuq1m1xwwqqqxxxxxclobdata;
	@Inject
	Yxxxuq1m1xwwqqqxxxxxclobdataList yxxxuq1m1xwwqqqxxxxxclobdataList;
	@Inject
	Yxxxuq1n1xwwqqqxxxxxblobdataHome yxxxuq1n1xwwqqqxxxxxblobdataHome;
	private Yxxxuq1n1xwwqqqxxxxxblobdata yxxxuq1n1xwwqqqxxxxxblobdata;
     @Inject
     Fpxxfq1a5xwwqqhxxxxxitemHome fpxxfq1a5xwwqqhxxxxxitemHome;

     @Inject
     Fpxxfq1a5xwwqqhxxxxxitemList fpxxfq1a5xwwqqhxxxxxitemList;

     @Inject
     Trexuq244xwwqqhxxxxxcuordersHome trexuq244xwwqqhxxxxxcuordersHome;
     @Inject
     Trexuq244xwwqqhxxxxxcuordersList trexuq244xwwqqhxxxxxcuordersList;


     @Inject
     Jxxxuq201xwwqqhxxxxxcustomerHome jxxxuq201xwwqqhxxxxxcustomerHome;
     @Inject
     Jxxxuq201xwwqqhxxxxxcustomerList jxxxuq201xwwqqhxxxxxcustomerList;
     @Inject
     Jxxxbh400xwwqqhxxxxxemployeeHome jxxxbh400xwwqqhxxxxxemployeeHome;


     @Inject
     Xoxxuq2b4xwwqqhxxxxxcuodetailsHome xoxxuq2b4xwwqqhxxxxxcuodetailsHome;
     @Inject
     Xoxxuq2b4xwwqqhxxxxxcuodetailsList xoxxuq2b4xwwqqhxxxxxcuodetailsList;

     @Inject
     Fxxxuq111xwwqqhxxxxxaddressHome fxxxuq111xwwqqhxxxxxaddressHome;
     @Inject
     Fxxxuq111xwwqqhxxxxxaddressList fxxxuq111xwwqqhxxxxxaddressList;
     @Inject
     Yxxxuq591xwwqqhxxxxxrate1fList yxxxuq591xwwqqhxxxxxrate1fList;
     private Yxxxuq591xwwqqhxxxxxrate1f     yxxxuq591xwwqqhxxxxxrate1f; 
     @Inject
     private Identity identity;


     @Inject
     CustomIdentity customIdentity;


      private int mactive=1;
      // && 2nd bit                4
      private int _mclosed=3;
      private int _mpartial=5;
      // && 5th                   32
      private int _mconsign=6;
      // && 6th                   64
      private int mpartial=32;
      private int mclosed=8;
      private boolean bcontinue =false;
      boolean smtpEnabled = true;
      String savedPassword="";
      private Calendar calendar = Calendar.getInstance();
      private Calendar calendare = Calendar.getInstance();
      private String key="";
      private String subKey="";
      private boolean inRegistrationAndCreateUser=false;
      private ResourceBundle bundle=null;
      private FacesContext facesContext=null;

               ExternalContext externalContext=null;
               ServletContext context=null;
               String serverName="";
               private Boolean tomeeYN = false;// bypass openshift router logic for now until logic aded 
               private String hostingAt = "op";// op for openshift, aw for amazon aws, hero for heroku, lo for Local 
               HttpServletRequest requestH=null;
               private String urlName=null;
               private int urlIndex=0;
               String owner2Code=null;//not used
               String owner2CodeApp=null;//shopify backoffice subdomain of raaspi or custom domain
               String owner2CodeClient=null;//used in installOrAuthorize method, called from raaspi site
               private String ownerCode="sss";

                 String code=null;
                 String hmac=null;
                 String shop=null;
                 String state=null;
                 String time=null;
                 String email=null;
                 String client_id=null;
                 String client_secret=null;
                 String client_c=null;
                 String client_p=null;
                 String scope=null;
                 String redirect_uri=null;
                 String access_token=null;
                 Yxxxch522xhhxxhxxxxxclient client=null;
    String outputs="";
    String pp90="";
    int inC=0;
    int adC=0;
    int adA=0;
    int updtC=0;
    int inA=0;
    int updtA=0;
    private boolean statusCh =false;
    String themeName="";
    String contxt="";
    String chargeResponse=null;
    String activateResponse=null;
    boolean clientExists=false;
    boolean clientJustCreated=false;            

    String shopUrl="";
    String clientFullUrlName="";
    String couponName="";


    @PostConstruct
    public void initialize() {
      facesContext = FacesContext.getCurrentInstance();
      if(facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       externalContext = facesContext.getExternalContext();
       context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
       hostingAt=context.getInitParameter(hostingAt);//
       requestH = (HttpServletRequest) externalContext.getRequest();
       serverName=context.getServerInfo();// check if tomcat or wildfly
       if(serverName.contains("omcat")){
        tomeeYN=true;
       }
       urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();

          urlIndex=urlName.lastIndexOf(".");
          if (urlIndex == -1){
            urlIndex=urlName.length();
          }
          if (urlName.contains("www.")){
           owner2CodeApp=urlName.substring(4,urlIndex);
          }else{
           owner2CodeApp=urlName.substring(0,urlIndex);
          }
          //extract subdomain if used. if subdomain, masterSiteCode will have a value
         if(!customIdentity.getMasterSiteCode().isEmpty()){
          owner2CodeApp=owner2CodeApp.replace("."+customIdentity.getMasterSiteCode(),"");
         }


      }
      ownerCode=customIdentity.getOwner();
    }

    public String getOutputs(){
     return outputs;
    }
    public void setOutputs(String outputs){
     this.outputs=outputs;
    }

    public int getInC(){
     return inC;
    }
    public void setInC(int inC){
     this.inC=inC;
    }

    public int getAdC(){
     return adC;
    }
    public void setAdC(int adC){
     this.adC=adC;
    }

    public int getAdA(){
     return adA;
    }
    public void setAdA(int adA){
     this.adA=adA;
    }
    public int getUpdtC(){
     return updtC;
    }
    public void setUpdtC(int updtC){
     this.updtC=updtC;
    }

    public int getInA(){
     return inA;
    }
    public void setInA(int inA){
     this.inA=inA;
    }

    public int getUpdtA(){
     return updtA;
    }
    public void setUpdtA(int updtA){
     this.updtA=updtA;
    }

    /**
    * Raaspi allows merchants to install public app and obtain access token for specific shop
    * once installed merchants can sync data from their own Raaspi site to their shop data
    * this method sends request to shopify to allow install and sendback auth verification data
    * this method uses shopify partner id and secret key stored in raaspi client record 02
    * if the secret is compromised then change the key, but also generate a refresh key so that old tokens will work
    * see shoauthverify method below, refresh key will be valid for one hour only
    * @param args-option 1 shop url to identify shop
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * prod/raaspiB ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]= ";
    * test/local   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shoauthverify.wflow &amp;state=001 &amp;grant_options[]= ";
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath
    */
    /*

    Data is in name/value pairs
    Data is separated by commas
    Curly braces hold objects
    Square brackets hold arrays

    */

          //comes here twice from shopify, first when add App/partner install button pressed. send back to Merchant
          // scope authorization.
          //2nd time when Merchant agrees with scope and presses Install for shop. Create new site
          // At very end redirect to new site or existing site
         //to test locally do the following (make sure app is deleted from shop)
         //remove from whitelist
         //http://raaspi.com/installApp.wflow
         //https://www.raaspi.com/installApp.wflow
         //replace with
         //http://raaspi.lraaspi.com/installApp.wflow
         //http://raaspi.lraaspi.com:8080/installApp.wflow
         //remove/change app url  https://www.raaspi.com/installApp.wflow
         // to                    https://www.raaspi.lraaspi.com/installApp.wflow so it fails
         // when it fails change to http://raaspi.lraaspi.com:8080
         // change again the broweser url as needed
         // https://www.raaspi.com/installApp.wflow?hmac=cff6d0008412ac800facedabc3bc3654846f8fce9fcedd0bf88e5a4f95197033&shop=cometojo.myshopify.com&timestamp=1585872363
         // was trying cometojo but got error public app access system error client raaspishopify null 
         //shopify() 
         public String installOrAuthorize(){
         
          String ret="";
          shopUrl="";
          facesContext = FacesContext.getCurrentInstance();
          if(facesContext !=null){
           bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
           externalContext = facesContext.getExternalContext();
           requestH = (HttpServletRequest) externalContext.getRequest();
           //  owner2CodeApp value needs to be reestablished if multiple use in same session
           urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();

           urlIndex=urlName.lastIndexOf(".");
           if (urlIndex == -1){
            urlIndex=urlName.length();
           }
           if (urlName.contains("www.")){
            owner2CodeApp=urlName.substring(4,urlIndex);
           }else{
            owner2CodeApp=urlName.substring(0,urlIndex);
           }
          //extract subdomain if used. if subdomain, masterSiteCode will have a value
         if(!customIdentity.getMasterSiteCode().isEmpty()){
          owner2CodeApp=owner2CodeApp.replace("."+customIdentity.getMasterSiteCode(),"");
         }

          }
          if(requestH == null  ){
                 log.severe(bundle.getString("Shopify")+" "+bundle.getString("installOrAuthorize")+" "+bundle.getString("invoked")+" null requestH ");
                 return "";// not from shopify?
          }
                 code=requestH.getParameter("code");
                 hmac=requestH.getParameter("hmac");
                 shop=requestH.getParameter("shop");
                 state=requestH.getParameter("state");
                 time=requestH.getParameter("timestamp");
                 shopUrl=shop;
                 if(requestH != null && requestH.getParameter("code") ==null){
                  //paas 1, send back for merchant scope authorization and install
                  //client record 02 for raaspi will hold shopify partner api key, record 01 holds Paypal, 03 can hold others
                  try{
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","02")
			.setParameter("owner2", owner2CodeApp)
			.getSingleResult();
                      //client not raaspi id holds merchant id and secret holds Token for that id
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();

                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        return null;
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        return null;
          	       }
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       client_secret=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       scope="read_products,read_customers,read_orders,read_inventory";
                       redirect_uri="https://www."+customIdentity.getMasterSiteUrl()+"/installApp.wflow";
                       String state="001";

                       // update changes the client statusfldate and tracks when last install for this tenant
                       yxxxch522xhhxxhxxxxxclientHome.update();
                      }
	             } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));

                        return null;

                     }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("client")+" "+owner2CodeApp+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                        return null;

                     }


                  String jj="";
                  URI uri=URI.create("");
                  ret="";
                  ret="https://"+shopUrl+"/admin/oauth/authorize?client_id="+client_id+" &amp;scope="+scope+" &amp;redirect_uri="+redirect_uri+" &amp;state=001 &amp;grant_options[]= ";
                  /*
                  if(urlName.contains("raaspi.com")){
                   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id="+client_id+" &amp;scope="+scope+" &amp;redirect_uri="+redirect_uri+" &amp;state=001 &amp;grant_options[]= ";
                  }else{
                   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id="+client_id+" &amp;scope="+scope+" &amp;redirect_uri=http://raaspi.lraaspi.com:8080/installApp.wflow &amp;state=001 &amp;grant_options[]= ";
                  }
                  */
 	          try {
		   ClientRequest request = new ClientRequest(ret);
                   request.accept(MediaType.TEXT_PLAIN);
		   ClientResponse<String> response = request.get(String.class);
		   if (response.getStatus() != 200 && response.getStatus() != 303) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("invalid")+" "+bundle.getString("request")+" "+bundle.getString("to")+" "+bundle.getString("shopify")+", "+" "+bundle.getString("response")+" "+bundle.getString("received")+" "+response.getStatus(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("store")+" "+bundle.getString("name")+" ex:mystore.myshopify.com",""));
                        return null;

                   }
                   //rasspi need to verify the response
		   BufferedReader br = new BufferedReader(new InputStreamReader(
		   new ByteArrayInputStream(response.getEntity().getBytes())));

		   String output;
		   outputs="";
		   while ((output = br.readLine()) != null) {
                     outputs=outputs+System.lineSeparator()+output;
		   }
                   // in pass1 redirect to shopify store
                   ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                   externalContext.redirect(ret);

                   return null;
	          } catch (ClientProtocolException e) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("store")+" "+bundle.getString("name")+" ex:mystore.myshopify.com"+" "+e.getMessage(),""));
                        return null;
	         } catch (IOException e) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        log.severe(bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+ e.getMessage());
                        return null;
	         } catch (Exception e) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        log.severe("#{messages['public_app_install_failed']}"+ e.getMessage());

                        return null;

	         }
                }//end of pass1, start of pass2 with code value
                 log.severe(bundle.getString("pass2")+" "+bundle.getString("invoked")+" code "+code);

                String secret = "3eb9710290fcaeb70d8ecd41f02e6bcc";
                try {
                 String message = "code="+code+"&shop="+shop+"&state="+state+"&timestamp="+time;
                 Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
                 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
                 sha256_HMAC.init(secret_key);
                 byte[] mac_data=sha256_HMAC.doFinal(message.getBytes());
                 String rat=Hex.encodeHexString(mac_data);

                 String hash = Base64.encodeBase64String(mac_data);
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("hash")+" "+rat,""));

                }
                catch (Exception e){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,bundle.getString("authVerify")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                }
                //get access token to be saved in new client
                try{
                 ret="https://"+shop+"/admin/oauth/access_token";
		 ClientRequest request = new ClientRequest(ret);
                 request.accept(MediaType.APPLICATION_JSON);
                 String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"code\":\""+code+"\"}";
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("input")+" "+input);
                 request.body(MediaType.APPLICATION_JSON,input);
		 ClientResponse<String> response = request.post(String.class);
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+response);
                 pp90="";
                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject  jobject = jelement.getAsJsonObject();
                 if(jobject.getAsJsonPrimitive("access_token") == null){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_INFO,bundle.getString("Shopify")+" "+bundle.getString("accesstoken")+" "+bundle.getString("already")+" "+bundle.getString("exists"),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_INFO,bundle.getString("goto")+" "+redirect_uri+" "+bundle.getString("and")+" "+bundle.getString("click")+" "+" "+bundle.getString("sync")+" "+bundle.getString("data"),""));


                 }else{
                  access_token = jobject.getAsJsonPrimitive("access_token").getAsString();
                 }
                 log.severe(bundle.getString("access")+" "+bundle.getString("token")+" "+access_token+" for "+ret);

                 //create raaspi site for this merchant/shop and store this access-token as secret
                 // no need for this method or connectorAuthorize unless the scope needs to be changed for this merchant
                 // from now raaspi site of this merchant will be used to sync data and use as backoffice
                 pp90="";
                 //shop is xxx.myshopify.com or xxx.com
                 String enterprisecompcode=this.shop;
                 String urlName=this.shop;
                 if(urlName.contains(".myshopify.com")){
                  urlIndex=urlName.lastIndexOf(".myshopify.com");
                 }
                 if (urlIndex == -1){
                  urlIndex=urlName.lastIndexOf(".");//no subdomain of myshopify.com ie xxx.com or xxx.net
                  if (urlIndex == -1){//no .com how?
                   urlIndex=urlName.length();
                  }
                 }
                 // urlIndex 3 if xxx.myshopify.com , 3 if xxx.com or 3 if xxx or 7 if www.xxx.com 
                 if (urlName.contains("www.")){
                  owner2CodeClient=urlName.substring(4,urlIndex);//xxx
                 }else{
                  owner2CodeClient=urlName.substring(0,urlIndex);//xxx
                 }
                 //if scope changes then access-token changes?? then need to update client records
                 serverName=requestH.getServerName();
                }
                catch (Exception e){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,bundle.getString("authorization")+" / "+bundle.getString("access")+" "+bundle.getString("token")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                 return "";
                }
                 shopUrl=shop;//use store api or url parameter to shauthverify invoke
                 email="jaymitra2@gmail.com";//get from shop api response
                 boolean agrrement=true;// get agreement in last step
                 String themeName="backofficeG 20201438302262";//hardcode
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,"",""));
                 this.themeName=themeName;//save it, this is session scoped
                 if(!agrrement){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString("please") +" "+bundle.getString("agree") +" "+bundle.getString("to")+" "+bundle.getString("terms"),""));
                  return null;

                 }


                // put doquickRegister here to create new site  after merchant installs app
                 //quickregister calls copydefaultstoUser to copy themes
                 // when userHome is called, it will call createClientRegister which will create client 01 record
                 // harcode applicationFunction before that
                 email=getShopData(owner2CodeClient);
                 if(email==null){
                  email="support@3rcomputer.com";//gets used in quickregister only if new site gets created
                 }
                 doQuickRegister();
                  //quickRegister sets clientExists as true only if client already exists also sets clientJustCreated
                  //  installAppStaus expects xxx not xxx.myshopify.com.
                  // use owner2CodeClient (xxx) not shop xxx.myshopify.com
                 int urlPort=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerPort();
                 if(clientJustCreated ){
                  // put 3 secs delay to avoid edge route not set up
                  try{
                   Thread.sleep(3000);//3 secs
                  }catch (Exception e){
                    log.severe("#{messages['thread_sleep_failed']}"+ e.getMessage());
                  }

                  if(urlPort!=8080){
                   ret="https://"+"www.raaspi.com/installAppStatus.wflow?websiteName="+owner2CodeClient+"&websiteFullUrl="+clientFullUrlName; 
                  }else{
                   ret="http://raaspi.lraaspi.com:8080/installAppStatus.wflow?websiteName="+owner2CodeClient+"&websiteFullUrl="+"http://"+owner2CodeClient+".lraaspi.com:8080/home.wflow";
                  }
                 }else{// in case install update button done from shopify but site already exists  
                  if(urlPort!=8080){
                   ret="https://"+clientFullUrlName+"/home.wflow"  ;
                  }else{
                   ret="http://"+owner2CodeClient+".lraaspi.com:8080/home.wflow"  ;
                  }
                 }
                  try{
                   //FacesContext context = FacesContext.getCurrentInstance();
                   //context.addMessage(clientId, message);
                   //externalContext.getFlash().setKeepMessages(true);
                   //return "users.xhtml?faces-redirect=true";
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
         }



    /**
    * Raaspi allows sites to install Google Gmail app and obtain access token for specific site
    * once installed site users can send emails from their own Raaspi site.
    * This avoids authentication problems since google stops sending SMTP requesing using gmail id/password.
    * clientEditEasy version 07 has a button GMail Mail Server authorize which will send Oauth request to GMail using Raaspi credentials
    * this method uses Raaspi App Gmail Client_id id and secret key stored in raaspi client record 07 (created if needed)
    * once Gmail sends Oauth token back, it will be saved in client site record 07 (created if needed)as secret
    * if the secret is compromised then change the key, but also generate a refresh key so that old tokens will work
    * see shoauthverify method below, refresh key will be valid for one hour only
    * @param args-option 1 gmail id which will allow app to access/send gmails
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * prod/raaspiB ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]= ";
    * test/local   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shoauthverify.wflow &amp;state=001 &amp;grant_options[]= ";
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath
    */
    /*

    Data is in name/value pairs
    Data is separated by commas
    Curly braces hold objects
    Square brackets hold arrays

    */
          // comes twice, first with a token and 2nd time back after xcnging token with access code
          //when authorize button in clientEditEasy is pressed by site A user a browser link request
          // sends Oauth req to GMail. Gmail in turn asks site A to agree or deny
          //if Site A agrees with scope and allows then
          // At very end Google redirects to installAppGmail.xhtml which has viewaction to come here
          //exmple  ?code=4/vAHojvAdDa4HofDvyLRfpDhSvisb8pzES12nZ8DoMViDC01gQBtGAFNDRS3x2Xdvs1aFtp_DpaBn0rOkEAzdIzw&scope=https://mail.google.com/
          //"" https://www.raaspi.com/installAppGmail.wflow?state=myworld&code=4/vAGg5iDdjqRQowwT5rN9q5jo0vlQ20rzuwt5MVd1AS7v0PLKGdi3OK0pD74S7Vv3WGnUziHHbsX15uiN8niztno&scope=https://mail.google.com/
         public String installOrAuthorizeGMail(){
          String refresh_token="";
          String ret="";
          String owner2_url="";
          String state="";//oauth server paases the request url via response param state 
          String grant_type="authorization_code";
          String redirect_uri="https://www.raaspi.com/installAppGmail.wflow";
          //scope https://www.googleapis.com/auth/gmail.send
          //https://mail.google.com/ everything
          facesContext = FacesContext.getCurrentInstance();
          if(facesContext !=null){
           bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
           externalContext = facesContext.getExternalContext();
           requestH = (HttpServletRequest) externalContext.getRequest();
          }
          if(requestH == null ){
                 //owner2_url=getUrl(state); no param to get state, so no redirect
                 log.severe(bundle.getString("installOrAuthorizeGmail")+" "+bundle.getString("invoked")+" null requestH ");
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,bundle.getString("return")+" "+bundle.getString("url")+" "+bundle.getString("missing"),""));
                 return "";
          }
                 state=requestH.getParameter("state");
                 if(state.contains("8080")){
                  redirect_uri="http://raaspi.lraaspi.com:8080/installAppGmail.wflow";                 }
                 code=requestH.getParameter("code");
                 access_token=requestH.getParameter("access_token");
                 refresh_token=requestH.getParameter("refresh_token");
                 owner2_url=state;

                 time=requestH.getParameter("timestamp");

                 //temp auth code needs to be xchanged for permanent access token
                 if(requestH != null && requestH.getParameter("access_token") ==null
                  && requestH.getParameter("code") !=null){
                  //step1 running in site A send back for Gmail scope authorization and install
                  //client record 03 for raaspi will hold Square api credentials , record 01 holds Paypal, 07 GMail
                  log.severe(bundle.getString("authorization")+" "+bundle.getString("code")+" "+code);

                  String oAuthOwner=customIdentity.getMasterSiteCode();
                  try{
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
                      .createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","07")
			.setParameter("owner2", oAuthOwner)
			.getSingleResult();
                      //in pass 1 owner2 is raaspi and we get code as authorization code to request token
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        ret=owner2_url ;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                         return "";
                        }
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                          return "";
                        }
          	       }
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       client_secret=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("setup")+" "+bundle.getString("yet"),""));
                        ret=owner2_url ;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                         return "";
                        }
		       }
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+" "+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       // update changes the client statusfldate and tracks when last install for this tenant
                       yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                       yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                       yxxxch522xhhxxhxxxxxclientHome.update();
                      }
                     //main try/catch for raaspi client record 07
	             } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Gmail")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));

                        ret=owner2_url ;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                         return "";
                        }
                     }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                          return "";
                        }

                     }

                  //continue request access token by POST to be saved in merchant site
                  shop="www.googleapis.com";
                  try{
                   ret="https://"+shop+"/oauth2/v4/token";
		   ClientRequest request = new ClientRequest(ret);
                   request.accept(MediaType.APPLICATION_JSON);
                   String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"grant_type\":\""+grant_type+"\",\"code\":\""+code+"\",\"redirect_uri\":\""+redirect_uri+"\"}";
                   request.body(MediaType.APPLICATION_JSON,input);
		   ClientResponse<String> response = request.post(String.class);
                   pp90="";
                   String respString= response.getEntity(String.class);
                   log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+respString);
                   JsonElement jelement = new JsonParser().parse(respString);
                   JsonObject  jobject = jelement.getAsJsonObject();
                   if(jobject.getAsJsonPrimitive("access_token") == null){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_INFO,bundle.getString("GMail")+" "+bundle.getString("SMTP")+" "+bundle.getString("Email")+" "+bundle.getString("send")+" "+bundle.getString("accesstoken")+" "+bundle.getString("null")+"/ "+bundle.getString("exists")+"/ "+bundle.getString("authorizationCode")+" "+bundle.getString("expired"),""));
                    ret=owner2_url;
                    try{
                     externalContext.redirect(ret);
                     return null;
                    }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                       return "";
                    }

                   }else{
                    if(jobject.getAsJsonPrimitive("refresh_token") !=null){
                     refresh_token = jobject.getAsJsonPrimitive("refresh_token").getAsString();//can be empty
                    }
                    access_token = jobject.getAsJsonPrimitive("access_token").getAsString();
                   }
                   log.severe(bundle.getString("access")+" "+bundle.getString("token")+" "+access_token+" for "+owner2_url);
                   // ya29.Il-4B6rI-sJZwQoNeGBNSgujnayJzBT0lm4u23pEXxfgSOexr5d0RjnDX3VWHuArgkm7bBAiwmoCNF_wTt-dVteFsw-d3--qUkJK05WNcBpqtNQ8Vl51kq48dUFpImwt2A
                   //           ya29.ImC4B2heIV-U7DCc3sf1l-9tcGEmyvekro8URdFFUPtzwEZqCHaw8Z3J3614vgiVjLuXpOTVeqRD9gmVv_28LFQ1AmQKKPIe3zqGE_9i-SsaUSkTfOHMvxm2XoTFdrBXuTw
                  } catch (ClientProtocolException e2) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                   ret=owner2_url;
                   try{
                    externalContext.redirect(ret);
                    return null;
                   }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                    return "";
                   }
                  } catch (IOException e2) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                        log.severe(bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+ e2.getMessage());
                        ret=owner2_url;
                    try{
                     externalContext.redirect(ret);
                     return null;
                    }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                     return "";
                    }
    	          } catch (Exception e2) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                        log.severe("#{messages['public_app_install_failed']}"+ e2.getMessage());

                   ret=owner2_url;
                   try{
                    externalContext.redirect(ret);
                    return null;
                   }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                    return "";
                   }

	          }
                 // got accessCode and possibly refresh_code, now save in client A
                  //get access token to be saved in new client
                   log.severe(bundle.getString("site")+" "+bundle.getString("url")+" "+owner2_url);
                   owner2CodeApp=getOwner2Code(state);

                   try{
                    client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","07")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
                      //in pass 2 owner2 is merchant site
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                          return "";
                        }
                      }
                      if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        ret=owner2_url;
                       try{
                        externalContext.redirect(ret);
                        return null;
                       }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        return "";
                       }
         	      }
                      client_id=refresh_token;
                      client_secret=access_token;
                      if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("refresh")+" "+bundle.getString("token")+" "+bundle.getString("empty")+", "+bundle.getString("token")+" "+bundle.getString("not")+" "+bundle.getString("expired"),""));
                        // emailrender expects non empty value in rec07 client id
                        client_id="place holder for Refresh Token";
                       /*
                       ret=owner2_url;
                       try{
                        externalContext.redirect(ret);
                        return null;
                       }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        return "";
                       }
                       */
		      }else{
                       client.setDaxxuzxdssxxxxxxxxxxapiclientid(client_id.trim());//refresh token new value
                       //1//0dORO-RjzyKgSCgYIARAAGA0SNwF-L9IrcoLHgsDbMNUhYLIVfjvJHzaC3f2-Gp_WAxhwy5MwLCsLBVCAxFBs9WwEJ50iwpWznNc 
               
                      }
                      if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+" "+bundle.getString("setup")+bundle.getString("yet"),""));
                       ret=owner2_url;
                       try{
                        externalContext.redirect(ret);
                        return null;
                       }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        return "";
                       }
		      }
                      client.setDbxxuzxdssxxxxxxxxxxapiclientsecret(client_secret.trim());//access token
                       // update changes the client statusfldate and tracks when last install for this tenant
                      yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                      yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                      yxxxch522xhhxxhxxxxxclientHome.allowUpdate();//timestamp to be used to check expiry
                    }
                   } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Gmail")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));

                       ret=owner2_url;
                       try{
                        externalContext.redirect(ret);
                        return null;
                       }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                         return "";
                       }

                   }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                    ret=owner2_url;
                    try{
                     externalContext.redirect(ret);
                     return null;
                    }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                      return "";
                    }

                   }


                  //redirect to user site
                  // check if subdomain or not
                  //String owner2_url=httpreq.getServerName();
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                 }else{
                  // should not come here
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("should")+" "+bundle.getString("app")+" "+bundle.getString("not")+" "+bundle.getString("come")+" "+bundle.getString("here"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                 }



         }

    public String getAccessTokenGMail(String refresh_token,String grant_type,String owner2CodeApp ){
     log.severe(bundle.getString("refresh_token")+" "+refresh_token+" "+bundle.getString("grant_type")+" "+grant_type);
     //first check parameters and get refresh_token and grant_type , then get app id and secret
          String ret="";
          String owner2_url=owner2CodeApp;
                  String oAuthOwner=customIdentity.getMasterSiteCode();
                  try{
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
                      .createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","07")
			.setParameter("owner2", oAuthOwner)
			.getSingleResult();
                      //in pass 1 owner2 is raaspi and we get code as authorization code to request token
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                         return "";
                        }
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                          return "";
                        }
          	       }
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       client_secret=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("setup")+" "+bundle.getString("yet"),""));
                         return null;
		       }
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+" "+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       // update changes the client statusfldate and tracks when last install for this tenant
                       //yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                       //yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                       //yxxxch522xhhxxhxxxxxclientHome.update();//not install
                      }
                     //main try/catch for raaspi client record 07
	             } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Gmail")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                         return null;
                     }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                         return null;
                        }


                  //continue request access token by POST to be saved in merchant site
                  shop="www.googleapis.com";
                  try{
                   ret="https://"+shop+"/oauth2/v4/token";
		   ClientRequest request = new ClientRequest(ret);
                   request.accept(MediaType.APPLICATION_JSON);
                   String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"grant_type\":\""+grant_type+"\",\"refresh_token\":\""+refresh_token+"\"}";
                   request.body(MediaType.APPLICATION_JSON,input);
		   ClientResponse<String> response = request.post(String.class);
                   pp90="";
                   String respString= response.getEntity(String.class);
                   log.severe(bundle.getString("GMail")+" "+bundle.getString("SMTP")+" "+bundle.getString("Email")+" "+bundle.getString("getAccessToken")+" "+bundle.getString("response")+" "+respString);
                   JsonElement jelement = new JsonParser().parse(respString);
                   JsonObject  jobject = jelement.getAsJsonObject();
                   if(jobject.getAsJsonPrimitive("access_token") == null){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_INFO,bundle.getString("GMail")+" "+bundle.getString("SMTP")+" "+bundle.getString("Email")+" "+bundle.getString("get")+" "+bundle.getString("accesstoken")+" "+bundle.getString("null"),""));
                    return null;
                   }
                   access_token = jobject.getAsJsonPrimitive("access_token").getAsString();

                  }catch (ClientProtocolException e2) {
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                    return "";
                  } catch (IOException e2) {
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                        log.severe(bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+ e2.getMessage());
                     return "";
    	          } catch (Exception e2) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                    return "";
	          }

///////////////////////////////
                 // got accessCode and possibly refresh_code, now save in client A
                  //get access token to be saved in new client
                   try{
                    client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select  cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","07")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
                      //in phase 2 owner2 is merchant site
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                          return "";
                      }
                      if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));
                        return "";
         	      }
                      client.setDbxxuzxdssxxxxxxxxxxapiclientsecret(access_token.trim());//access token
                       // update changes the client statusfldate and tracks when last install for this tenant
                      yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                      yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                      yxxxch522xhhxxhxxxxxclientHome.allowUpdate();//timestamp to be used to check expiry
                    }
                   } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Gmail")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));

                         return "";

                   }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                      return "";

                   }


//////////////////////////////////////////

       return access_token;
    }


    String getOwner2Code(String state){
     //called by gmail( and square(
     try{
      URI uri = new URI(state);
      String host=uri.getHost();
          int urlIndex=host.lastIndexOf(".");//
          if (urlIndex == -1){//not found
            urlIndex=host.length();
          }       
          if (host.contains("www.")){
           owner2Code=host.substring(4,urlIndex);// 
          }else{
           owner2Code=host.substring(0,urlIndex);
          }

          //extract subdomain if used. if subdomain, masterSiteCode will have a value
         if(!customIdentity.getMasterSiteCode().isEmpty()){
          owner2Code=owner2Code.replace("."+customIdentity.getMasterSiteCode(),"");
         }
      return owner2Code;
     }catch (Exception ex){
      log.severe(state+"rest_client_URI_failed "+ ex.getMessage());
       return null;
     }
    }

    String getUrl(String owner2){
     int urlPort=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerPort();
     String owner2_url=customIdentity.getMasterSiteUrl();
     if(owner2==""){
      owner2="myorgp";
     }
     if(urlPort==8080){
      owner2_url=owner2+".customIdentity.getMasterSiteUrl():8080";
     }else{
      owner2_url=owner2+".customIdentity.getMasterSiteUrl()";
     }
     //harcode now for say myorgp but later use client app id field as url
     return owner2_url;
    }

    /**
    * Raaspi allows sites to install Square app like POS and obtain access token for specific site
    * once installed site users can use RAASPI for Square payment from their own Raaspi site.
    * This avoids authentication problems since google stops sending SMTP requesing using gmail id/password.
    * clientEditEasy version 01 has a button GMail setup which will send Oauth request to GMail using Raaspi credentials
    * this method uses Raaspi App Square App_id id (client id here) and secret key (or token) stored in raaspi
    * client record 03 (created if needed)
    * once Square sends Oauth token back, it will be saved in record 03 (created if needed)as secret
    * if the secret is compromised then change the key, but also generate a refresh key so that old tokens will work
    * see shoauthverify method below, refresh key will be valid for one hour only
    * @param args-option 1 square id which will allow app to access/send gmails
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * for Paypal ShoppingcartBean init step calls Paypal supplied method OAuthTokenCredential to get AccessToken
    * each client has their paypal clientId/Secret in client record 01
    * recheck paypal logic whether betther option ie get client agree and get token using raaspi id
    * prod/raaspiB ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]= ";
    * test/local   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shoauthverify.wflow &amp;state=001 &amp;grant_options[]= ";
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath
    */
    /*

    Data is in name/value pairs
    Data is separated by commas
    Curly braces hold objects
    Square brackets hold arrays

    */

          //comes here once when button in clientEditEasy is pressed by site A and site A user logs in
          // and sends authorization request. A redirect comes back here with code=xxx
          // gets invoked with value in code, this mthod sends Oauth req to Square for token.
          // response comes back with value in access_token and (merchant_id ??)
          // At very end this method which runs in RAASPI server sends redirect to site A Home page
         //raaspi.lraaspi.com:8080/installAppSquare.wflow?code=sq0cgp-VX8oTcEwAIcJvxXgcRjbcw&response_type=code&state=myorgp#_=_
         public String installOrAuthorizeSquare(){
          //unlike gmail, square allow only one redirect, so in test it will not come here
          // we can simulate only. add a log to capture response in prod
          String refresh_token="";
          String merchant_id="";
          String ret="";
          String owner2_url="";
          String state="";
          String grant_type="authorization_code";
          facesContext = FacesContext.getCurrentInstance();
          if(facesContext !=null){
           bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
           externalContext = facesContext.getExternalContext();
           requestH = (HttpServletRequest) externalContext.getRequest();
          }
          if(requestH == null ){
                 //owner2_url=getUrl(state);
                 log.severe(bundle.getString("installOrAuthorizeSquare")+" "+bundle.getString("invoked")+" null requestH ");
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,bundle.getString("return")+" "+bundle.getString("url")+" "+bundle.getString("missing"),""));
                 return "";
          }
                 state=requestH.getParameter("state");
                 code=requestH.getParameter("code");
                 access_token=requestH.getParameter("access_token");
                 merchant_id=requestH.getParameter("merchant_id");
                 owner2_url=requestH.getParameter("owner2_url");
                 owner2_url=state;

                 time=requestH.getParameter("timestamp");

                 //temp auth code needs to be xchanged for permanent access token
                 if(requestH != null && requestH.getParameter("access_token") ==null
                  && requestH.getParameter("code") !=null){
                  //step1 running in site A send back for Square scope authorization and install
                  //client record 03 for raaspi will hold Square api credentials , record 01 holds Paypal, 07 GMail
                  log.severe(bundle.getString("authorization")+" "+bundle.getString("code")+" "+code);
                  String oAuthOwner=customIdentity.getMasterSiteCode();
                  try{
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","03")
					.setParameter("owner2", oAuthOwner)
					.getSingleResult();
                      //in pass 1 owner2 is raaspi and we get code as authorization code to request token
                      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
                       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                       ret=owner2_url;
                       try{
                        externalContext.redirect(ret);
                        return null;
                       }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                          return "";
                       }
                     }
                     if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));
                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        return "";
                        }
          	    }
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       client_secret=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("setup")+" "+bundle.getString("yet"),""));
                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                        return "";
                       }
                      }
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+" "+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       // update changes the client statusfldate and tracks when last install for this tenant
                       yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                       yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                       yxxxch522xhhxxhxxxxxclientHome.update();
                      }
                  } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                   ret=owner2_url;
                   try{
                    externalContext.redirect(ret);
                    return null;
                   }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                   }
                  }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                }

                  //continue request access token by POST to be saved in merchant site
                  shop="connect.squareup.com";
                  try{
                   ret="https://"+shop+"/oauth2/token";
		   ClientRequest request = new ClientRequest(ret);
                   request.accept(MediaType.APPLICATION_JSON);
                   String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"grant_type\":\""+grant_type+"\",\"code\":\""+code+"\"}";
                   request.body(MediaType.APPLICATION_JSON,input);
		   ClientResponse<String> response = request.post(String.class);
                   pp90="";
                   String respString= response.getEntity(String.class);
                   log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+respString);
                   JsonElement jelement = new JsonParser().parse(respString);
                   JsonObject  jobject = jelement.getAsJsonObject();
                   if(jobject.getAsJsonPrimitive("access_token") == null){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_INFO,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("accesstoken")+" "+bundle.getString("null")+"/ "+bundle.getString("exists")+"/ "+bundle.getString("authorizationCode")+" "+bundle.getString("expired"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
                  }else{
                    if(jobject.getAsJsonPrimitive("refresh_token") !=null){
                     refresh_token = jobject.getAsJsonPrimitive("refresh_token").getAsString();//can be empty
                    }
                    access_token = jobject.getAsJsonPrimitive("access_token").getAsString();
                  }
                  log.severe(bundle.getString("access")+" "+bundle.getString("token")+" "+access_token+" for "+owner2_url);
          } catch (ClientProtocolException e2) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
                  } catch (IOException e2) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                        log.severe(bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+ e2.getMessage());
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
         } catch (Exception e2) {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                        log.severe(bundle.getString("Square")+" "+bundle.getString("Api")+" "+"public_app_install_failed"+ e2.getMessage());

                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

          }
                 // got accessCode now save in client A
                  //get access token to be saved in new client
                   log.severe(bundle.getString("site")+" "+bundle.getString("url")+" "+owner2_url);
                   owner2CodeApp=getOwner2Code(state);

                   try{
                    client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","03")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
                      //in pass 2 owner2 is merchant site
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
               }
                       client_id=getOwner2Code(state);
                       client_secret=access_token;
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("setup")+" "+bundle.getString("yet"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
		       }
                       client.setDaxxuzxdssxxxxxxxxxxapiclientid(client_id.trim());
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+" "+bundle.getString("setup")+bundle.getString("yet"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }
		       }
                       client.setDbxxuzxdssxxxxxxxxxxapiclientsecret(client_secret.trim());
                       // update changes the client statusfldate and tracks when last install for this tenant
                       yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                       yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                       yxxxch522xhhxxhxxxxxclientHome.allowUpdate();//timestamp to be used to check expiry
                      }
	             } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));

                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                     }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                 }


                  //redirect to merchant site
                  // check if subdomain or not
                  //String owner2_url=httpreq.getServerName();
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                 }else{
                  // should not come here
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("app")+" "+bundle.getString("should")+" "+bundle.getString("not")+" "+bundle.getString("come")+" "+bundle.getString("here"),""));
                  ret=owner2_url;
                  try{
                   externalContext.redirect(ret);
                   return null;
                  }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                   return "";
                  }

                 }

         }

    public String getAccessTokenSquare(String refresh_token,String grant_type,String owner2CodeApp ){
     log.severe(bundle.getString("refresh_token")+" "+refresh_token+" "+bundle.getString("grant_type")+" "+grant_type);
     //first check parameters and get refresh_token and grant_type , then get app id and secret
          String ret="";
          String owner2_url=owner2CodeApp;
                  String oAuthOwner=customIdentity.getMasterSiteCode();
                  try{
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
                      .createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","03")
			.setParameter("owner2", oAuthOwner)
			.getSingleResult();
                      //in pass 1 owner2 is raaspi and we get code as authorization code to request token
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                         return "";
                        }
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        ret=owner2_url;
                        try{
                         externalContext.redirect(ret);
                         return null;
                        }catch (Exception e){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("redirect")+" / "+bundle.getString("to")+" "+ret+" "+bundle.getString("error")+" "+e.getMessage(),""));
                          return "";
                        }
          	       }
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       client_secret=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("setup")+" "+bundle.getString("yet"),""));
                         return null;
		       }
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+" "+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       // update changes the client statusfldate and tracks when last install for this tenant
                       //yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                       //yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                       //yxxxch522xhhxxhxxxxxclientHome.update();//not install
                      }
                     //main try/catch for raaspi client record 03
	             } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                         return null;
                     }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                         return null;
                        }


                  //continue request access token by POST to be saved in merchant site
                  shop="connect.squareup.com";
                  try{
                   ret="https://"+shop+"/oauth2/token";
                  ClientRequest request = new ClientRequest(ret);
                   request.accept(MediaType.APPLICATION_JSON);
                   String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"grant_type\":\""+grant_type+"\",\"refresh_token\":\""+refresh_token+"\"}";
                   request.body(MediaType.APPLICATION_JSON,input);
                   ClientResponse<String> response = request.post(String.class);
                   pp90="";
                   String respString= response.getEntity(String.class);
                   log.severe(bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("getAccessToken")+" "+bundle.getString("response")+" "+respString);
                   JsonElement jelement = new JsonParser().parse(respString);
                   JsonObject  jobject = jelement.getAsJsonObject();
                   if(jobject.getAsJsonPrimitive("access_token") == null){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_INFO,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("accesstoken")+" "+bundle.getString("null"),""));
                    return null;
                   }
                   access_token = jobject.getAsJsonPrimitive("access_token").getAsString();
                  }catch (ClientProtocolException e2) {
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                    return "";
                  } catch (IOException e2) {
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                        log.severe(bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+ e2.getMessage());
                     return "";
    	          } catch (Exception e2) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("install")+" "+bundle.getString("system")+"/"+bundle.getString("connection")+" "+bundle.getString("error")+" "+e2.getMessage(),""));
                    return "";
	          }

///////////////////////////////
                 // got accessCode and possibly refresh_code, now save in client A
                  //get access token to be saved in new client
                   try{
                    client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","03")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
                      //in phase 2 owner2 is merchant site
		      if (client != null) {
                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                          return "";
                      }
                      if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("service")+" "+bundle.getString("decommisioned"),""));
                        return "";
         	      }
                      client.setDbxxuzxdssxxxxxxxxxxapiclientsecret(access_token.trim());//access token
                       // update changes the client statusfldate and tracks when last install for this tenant
                      yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                      yxxxch522xhhxxhxxxxxclientHome.setInstance(client);

                      yxxxch522xhhxxhxxxxxclientHome.allowUpdate();
                    }
                   } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));

                         return "";

                   }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("Square")+" "+bundle.getString("Api")+" "+bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                      return "";

                   }


//////////////////////////////////////////

       return access_token;
    }


    /**
    *Raaspi pulls data from shopify using html basic auth ie id/password already defined in Shopify for a private app
    * @param args -option one serverName is used extract port used, option two shopUrl is used to identify shopify
    * @return none void type
    * @exception None.
    * @see
    * in the table called options, column called value will have filter value which will dictate whether it will be hidden,visible or
    * to use the specified value rather than value in column called options
    * to hide a value in column called options for say activity entity put h=1a. to hide for both item and activity put value= h=1a,18
    * to show a value in column called options for say activity entity put s=1a. to show for both item and activity put value= s=1a,18
    * to show based on locale put in pupose ca=manual-cheque us=manual-check  in value put ca=m us=m
    * to use value rather than whats in options colimn, use v=xxx cc where cc. xxx is the value.
    */

         public String connectnBaseAuthorizenData(String serverName, String shopUrl){
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", shopUrl)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       // first check whether Client Table is locked for Bus Date maintenance , not sure cc where cc. is the lock logic
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
                       yxxxch522xhhxxhxxxxxclientHome.update();
			  customIdentity.setProduct(client.getG2xxuxpclvxxxxxxxxxxprodcode().substring(0, 1));
			  customIdentity.setSubProduct(client.getG2xxuxpclvxxxxxxxxxxprodcode().substring(1, 2));
			  customIdentity.setSize(client.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize());
			  customIdentity.setOwner2(shopUrl);

                      }
	             } catch (NoResultException ex) {
                       //ignore
                     }catch (Exception ex){
			//FacesMessages.instance().add("#{messages['exception']} "+ex);
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("install")+" / "+bundle.getString("access")+" "+bundle.getString("code")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));

                     }
                    return null;


         }
    /**
    * Raaspi allows merchants to install public app and obtain access token for specific shop
    * once installed merchants can sync data (products) from their own Raaspi site to their shop data
    * this method sends request to shopify to allow install and sendback auth verification data
    * item type SI-D come as variants which is array of lists of shopify product variants including array
    * the product itself can be type SI-L* under one SI-L1 Products_via-API
    * unlike customer/address cc where cc. customStrategy is used,a diff logic of Gson parser is used to get variants by tag name
    * @param args-option 1 shop url to identify shop
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * prod/raaspiB ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]= ";
    * test/local   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shoauthverify.wflow &amp;state=001 &amp;grant_options[]= ";
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath
    */
        //syncDataProducts
        public String syncData(){
             String keyToE="tbdA";
             String shopUrl="";
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             int errcnt=0;
             Fpxxfq1a5xwwqqhxxxxxitem itemP;
             Fpxxfq1a5xwwqqhxxxxxitem itemL;
             JsonArray jarray=null;
             Fpxxfq1a5xwwqqhxxxxxitem[] items=null;
             Fpxxfq1a5xwwqqhxxxxxitem categoryItem=null;

              if (!identity.isLoggedIn() || !(customIdentity.hasRole("UH") || customIdentity.hasRole("UQ")) ) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("and")+" "+bundle.getString("correct")+" "+bundle.getString("user")+" "+bundle.getString("level")+" "+bundle.getString("is")+" "+bundle.getString("required"),""));
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       if (client.getF6xxuxxxlvxxxxxxxxxxlicensetype().equals("TrialPending")){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("email")+" "+bundle.getString("notification")+" "+bundle.getString("for")+" "+bundle.getString("login")+" "+bundle.getString("information"),""));
                       }
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient,""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient+" "+ex.getMessage(),""));
                        return null;

                }


                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 FacesMessage.SEVERITY_INFO,bundle.getString("including")+", "+bundle.getString("the")+" "+bundle.getString("case")+" "+bundle.getString("install")+" "+bundle.getString("just")+" "+bundle.getString("performed"),""));

               return null;
              }

                // accesstoken recvd e25b608df4cbd55b4598ebc0a2a141d0
                // lets try with this token

                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 FacesMessage.SEVERITY_INFO,"sync products data started",""));

                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","02")
			.setParameter("owner2", owner2CodeApp)
			.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;
                 }

                try{
                 //make rest api using token in header for products
                 String ret="https://raaspishopify.myshopify.com//admin/products.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"//admin/products.json";
                 }else{
                  // mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"//admin/products.json";
                 }

		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);
                //debug purpose comment out
		BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));
                pp90="";
                adA=0;
                updtA=0;

		String output;
		outputs="";
                int skipLines=0;
                int line=0;
                int lines=0;
                int maxLines=500;
		while ((output = br.readLine()) != null) {
                     line=line+1;
                     if(line < skipLines){
                      continue;
                     }
                     lines=lines+1;
                     if(lines > maxLines){
                      break;
                     }
                     String doutput="";
                     String routput="";
                     routput=output;
                     while (routput.length()>120){
                      doutput=routput.substring(0,120)+System.lineSeparator();
                      routput= routput.substring(121,routput.length());
                      outputs=outputs+doutput+System.lineSeparator();
                      if(routput.length() <120){
                       outputs=outputs+System.lineSeparator()+routput;
                      }
                     }
                     outputs=outputs+System.lineSeparator()+output;
		}

                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject jobject = jelement.getAsJsonObject();

                jarray = jobject.getAsJsonArray("products");//products start with { so it is json object


                GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategy());
                Gson gson = gsonBuilder.create();
                items = gson.fromJson(jarray.toString(), Fpxxfq1a5xwwqqhxxxxxitem[].class);
                categoryItem=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity("Products_via_API");
                if(categoryItem==null){
                 //look into using SI-L1s for shopify Collection
                 fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();
                 itemP=fpxxfq1a5xwwqqhxxxxxitemHome.getInstance();
                 itemP.setB1xxuszsbvxxxxxxxxxxdescript("Products_via_API");
                 itemP.setA0xxukixbxxxxxxxxxxxmatcode("Products_via_API");
                 itemP.setC6xxusxrbv16xxxxxxxxtype("SI-L1");
                 itemP.setZ2xxcsxrlxxxxxxxxxxxdateadded(new Date());
                 fpxxfq1a5xwwqqhxxxxxitemHome.setInstance(itemP);
                 fpxxfq1a5xwwqqhxxxxxitemHome.persistRest();
                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   //FacesMessage.SEVERITY_INFO,bundle.getString("since")+" "+bundle.getString("category")+" "+"Products_via_API"+" "+bundle.getString("just")+" "+bundle.getString("got")+" "+bundle.getString("created")+", "+bundle.getString("please")+" "+bundle.getString("run")+" "+bundle.getString("sync")+" "+bundle.getString("products")+" "+bundle.getString("again")+" "+bundle.getString("to")+" "+bundle.getString("sync")+" "+bundle.getString("the")+" "+bundle.getString("rest")+" "+bundle.getString("under")+" "+bundle.getString("it"),""));
                 //return "";
                 // get it again, so that sid value is there
                 categoryItem=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity("Products_via_API");
                }
               }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("getting")+" "+bundle.getString("data")+" "+bundle.getString("for")+" "+shopUrl+" "+ex.getMessage(),""));
                        return null;
               }

                inC=0;
                updtC=0;
                adC=0;
                // items is an json array of products coming from Shopify like
                // "products:[{"id":mm,"title":"xxx",....."variants":[{"id":nn,"product_id":mm,"price":56.00,..},{..}],
                //     "options":[{},..],"images":[{},..]
                // each variant will have type is SI-D
                // but create a new parent item of type SI-L* using field values coming from customStrategy(Item)
                // using id,title from gson array "id":mm,"title":"xxx",....."variants":[{"id":,
                // since shopify id is like raaspi sid, store id+title in matcode
                for (Fpxxfq1a5xwwqqhxxxxxitem item : items){
              try{
                   // one row, one item with details, save si-L* first, then variants as SI-D with parentcode
                   contxt=item.getB1xxuszsbvxxxxxxxxxxdescript();
                   fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();
                   itemL=fpxxfq1a5xwwqqhxxxxxitemHome.getInstance();
                   itemL.setB1xxuszsbvxxxxxxxxxxdescript(item.getB1xxuszsbvxxxxxxxxxxdescript());
                   int mlen=32-item.getA0xxukixbxxxxxxxxxxxmatcode().length();
                   if(mlen>10 && item.getB1xxuszsbvxxxxxxxxxxdescript().length()>10){
                    mlen=10;
                    itemL.setA0xxukixbxxxxxxxxxxxmatcode(item.getA0xxukixbxxxxxxxxxxxmatcode()+item.getB1xxuszsbvxxxxxxxxxxdescript().substring(0,mlen));
                   }else{
                    itemL.setA0xxukixbxxxxxxxxxxxmatcode(item.getA0xxukixbxxxxxxxxxxxmatcode()+item.getB1xxuszsbvxxxxxxxxxxdescript());
                   }
                   itemL.setZ6xxcztxlxxxxxxxxxxxstatusfldt(item.getZ6xxcztxlxxxxxxxxxxxstatusfldt());

                   itemL.setZ2xxcsxrlxxxxxxxxxxxdateadded(item.getZ2xxcsxrlxxxxxxxxxxxdateadded());

                   itemL.setW7xxuznxbvxxxxxxxxxxnotes(item.getW7xxuznxbvxxxxxxxxxxnotes());
                   itemL.setB3xxuxxrbvxxxxxxxxxxsource1(item.getB3xxuxxrbvxxxxxxxxxxsource1());
                   itemL.setY2xxuxxrbvxxxxxxxxxxmisccode1(item.getY2xxuxxrbvxxxxxxxxxxmisccode1());

                   itemL.setC6xxusxrbv16xxxxxxxxtype("SI-L*");

                   // getinstance and save it as itemP for later compare against status date
                   itemP=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity(itemL.getA0xxukixbxxxxxxxxxxxmatcode());
                   if(fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity(itemL.getA0xxukixbxxxxxxxxxxxmatcode())==null){
                    //new sub cat entry
                    //customStrategy overwriote statusfltdt,addeddate using shopify dates
                    if(itemL.getFpxxfq1a5xwwqqhxxxxxitem() ==null){
                      itemL.setFpxxfq1a5xwwqqhxxxxxitem(categoryItem);
                    }
                    fpxxfq1a5xwwqqhxxxxxitemHome.setInstance(itemL);
                    //set Id to inform hibernate it exists otherwise detached parent
                    if(fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid() ==null){
                       fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().setFpxxfq1a5xwwqqhxxxxxitem(categoryItem);
                    }
                    
                    fpxxfq1a5xwwqqhxxxxxitemHome.persistRest();//sub category itemL bypasses key from subcodes
                    adC=adC+1;

                   }else{
                     //sub cat exists but check if changed
                     calendare.setTime(itemP.getZ6xxcztxlxxxxxxxxxxxstatusfldt());//from raaspi
                     calendar.setTime(itemL.getZ6xxcztxlxxxxxxxxxxxstatusfldt());//from shopify
                     if(calendar.after(calendare)){
                      //if e(external) date after p(previous) update , but key should not change even if description changes
                      //set Id to inform hibernate it exists otherwise detached parent
                      fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().setA0xxuobxbxxxxxxxxxxxsid(itemP.getA0xxuobxbxxxxxxxxxxxsid());
                      if(fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().getFpxxfq1a5xwwqqhxxxxxitem() ==null){
                       fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().setFpxxfq1a5xwwqqhxxxxxitem(categoryItem);
                      }
                      fpxxfq1a5xwwqqhxxxxxitemHome.updateRest(item.getB1xxuszsbvxxxxxxxxxxdescript());
                      updtC=updtC+1;
                     }else{
                      //no change for subcat item , skip
                     }
                   }



                   //get entity fields which cannot be easily translated to json string via (item)customStrategy
                   // unless another customStrategyVariants is used or array index is used.
                   // Here, we will extract the values from variants Array to json object and then by tag value
                   JsonObject row=jarray.get(inC).getAsJsonObject(); //variants value starts with [ so it json array
                   // fitst variant ie get(0) has value for the product's default or only variant
                   JsonObject variants=null;
                   String value=null;
                   String checkedDataAndSize=null;
                   String shippingOptions=null;
                   String barUpc=null;
                   String titleC=null;
                   String productD=item.getB1xxuszsbvxxxxxxxxxxdescript();
                   inC=inC+1;

                   for (int i =0;i<row.get("variants").getAsJsonArray().size();i++){
                    //item was created in upper loop via customStrategy and has matCode, descript, notes,statusfldt etc
                    // but had product values (parent), override as needed with variant value otherwise inherit values
                    variants=row.get("variants").getAsJsonArray().get(i).getAsJsonObject();
                    value=variants.get("price").toString().replace("\"","");//already string value
                    item.setB8fbzpxxbvxxxxxxxxxxselprice(new BigDecimal(value));
                    value=variants.get("sku").toString().replace("\"","");//already string value
                    item.setF1xxuxxrbvxxxxxxxxxxaliascode(value);

                    value=variants.get("barcode").toString().replace("\"","");//already string value
                    item.setZxxrbvxxxvxxxxxxxxxxbarupc(value);
                    value=variants.get("inventory_quantity").toString();
                    item.setB0xxziqxlvxxsaxxxxxxquantity(new BigDecimal(value));
                    value=variants.get("inventory_item_id").toString();// inventory item has the cost
                    // make a rasp api call and get cost
                    value=getItemCost(shopUrl,value);
                    item.setB6fbzicxbvxxxxxxxxxxcost(new BigDecimal(value));

                    checkedDataAndSize="";
                    shippingOptions="XXXX";
                    barUpc=variants.get("barcode").toString().replace("\"","");
                    checkedDataAndSize=checkedDataAndSize+shippingOptions+"S"+"cm"
                    +"1.0"+"cm"+"1.0"+"cm"+"1.0"+variants.get("weight_unit").toString().replace("\"","")+variants.get("weight").toString();//free ship will put X, otherwise S/M/L
                    item.setC3fbuxscbvxxxxxxxxxxshipcode(checkedDataAndSize);
                    titleC=variants.get("title").toString().replace("\"","");
                    item.setB1xxuszsbvxxxxxxxxxxdescript(titleC);
                    value=variants.get("id").toString();
                    mlen=32-value.length();
                    //default variants have same title ie default title, so qualify using product title/descript ie id+prod title+variant title
                    //if variants enabled then title will be say small and optionally medium, large etc
                    //in shopify they are stored as one item (called product) and variants
                    //in raaspi we use subcategory (SI-L*) for a product and then SI-D items for variants  
                    if(mlen <0){
                     item.setA0xxukixbxxxxxxxxxxxmatcode(value);
                    }
                    if(mlen>10 && productD.length()>10){
                     productD=productD.substring(0,10);
                    }
                    if(mlen>14 && titleC.length()>4){
                     item.setA0xxukixbxxxxxxxxxxxmatcode(value+productD+titleC.substring(0,4));
                    }else{
                     item.setA0xxukixbxxxxxxxxxxxmatcode(value+productD+titleC);
                    }
                    // to avoid subcategories without variant, description called default Title via customstrategy
                    // descript use productD  if no variants and use variant titleC-productD if variants subject to 120 ch max
                    if(titleC.contains("Default Title")){
                     item.setB1xxuszsbvxxxxxxxxxxdescript(productD);
                    }else{
                     String td=titleC+"-"+productD;
                     if(td.length()>120){
                      td=td.substring(0,120);
                     }
                     item.setB1xxuszsbvxxxxxxxxxxdescript(td);
                    }  
                    value=variants.get("updated_at").toString().replace("\"","");
                    item.setZ6xxcztxlxxxxxxxxxxxstatusfldt(sdf.parse(value));

                    value=variants.get("created_at").toString().replace("\"","");
                    item.setZ2xxcsxrlxxxxxxxxxxxdateadded(sdf.parse(value));

                    pp90="";
                    fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();

                    item.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge
                    item.setZexxutoxlhxxxxxxxxxxowner(ownerCode);

                    //if(item.getC6xxusxrbv16xxxxxxxxtype() == null || item.getC6xxusxrbv16xxxxxxxxtype().isEmpty() ){
                     item.setC6xxusxrbv16xxxxxxxxtype("SI-D");
                    //}
                    if(item.getZ5xxzzfxhhxxxxxxxxxxstatusfl() == null ){
                     item.setZ5xxzzfxhhxxxxxxxxxxstatusfl(0);
                    }
                    if(item.getC4fbzxxxbvxxxxxxxxxxqtylevel1() == null ){
                     item.setC4fbzxxxbvxxxxxxxxxxqtylevel1(new BigDecimal("0.0"));
                    }

                    if(item.getB6fbzicxbvxxxxxxxxxxcost() == null ){
                     item.setB6fbzicxbvxxxxxxxxxxcost(new BigDecimal("0.0"));
                    }

                    if(item.getZ2xxcsxrlxxxxxxxxxxxdateadded() == null){
                     item.setZ2xxcsxrlxxxxxxxxxxxdateadded(new Date());
                    }// same as dateadded to avoid null value
                    if(item.getH1xxcxxrbxxxxxxxxxxxeffdate() == null){//sale end
                     item.setH1xxcxxrbxxxxxxxxxxxeffdate(new Date());
                    }
                    if(item.getC2fbcxxrehxxsxxxxxxxspriceffdt() == null){//sale start
                     item.setC2fbcxxrehxxsxxxxxxxspriceffdt(new Date());
                    }
                    if(item.getZ7xxzxxxlvxxxxxxxxxxcuordqty() == null){//avoid null in cartPOS remove
                     item.setZ7xxzxxxlvxxxxxxxxxxcuordqty(new BigDecimal("0.0"));
                    }

                    //hardcode non shopify maintained values required by raaspi
                    value=variants.get("taxable").toString();//boolean value
                    item.setC7fbfxz1bvxxxxxxxxxxtax1(Boolean.valueOf(value));

                    item.setC8fbfxz2bvxxxxxxxxxxtax2(false);
                    item.setY6fbfxz3bvxxxxxxxxxxtax3(false);
                    // now set parent
                    item.setFpxxfq1a5xwwqqhxxxxxitem(itemL);
                    itemP=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity(item.getA0xxukixbxxxxxxxxxxxmatcode());
                    fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();
                    fpxxfq1a5xwwqqhxxxxxitemHome.setInstance(item);

                    if(itemP !=null){
                     //item exists
                     if(item.getZ6xxcztxlxxxxxxxxxxxstatusfldt() != null){
                      calendare.setTime(item.getZ6xxcztxlxxxxxxxxxxxstatusfldt());//from shopify
                      calendar.setTime(itemP.getZ6xxcztxlxxxxxxxxxxxstatusfldt());//from raaspi
                      if(calendare.after(calendar)){
                       //if e(external) date after p(previous) update , but key should not change even if description changes

                       //item values comes from shopify, make sure sids are set
                       if(fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid() ==null){
                        fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().getFpxxfq1a5xwwqqhxxxxxitem().setA0xxuobxbxxxxxxxxxxxsid(itemP.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid());
                       }
                       if(fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().getA0xxuobxbxxxxxxxxxxxsid() ==null){
                        fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().setA0xxuobxbxxxxxxxxxxxsid(itemP.getA0xxuobxbxxxxxxxxxxxsid());
                       }

                       fpxxfq1a5xwwqqhxxxxxitemHome.updateRest(item.getB1xxuszsbvxxxxxxxxxxdescript());
                       updtC=updtC+1;
                      }else{
                       //no change , skip updating
                      }
                     }else{
                      //already exists,assume no change and skip
                     }
                    }else{
                     //new item, does not exist but values including effdate already set before deciding on parent
                       //persist logic needs change to allow predefined item key rather than generate from subkeys
                       // if the parent instance doesnt have sid then query and set it first otherwise persist fails
                       //set parent Id to subcode to inform hibernate it exists
                       if(fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid() ==null){
                        itemL=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity(itemL.getA0xxukixbxxxxxxxxxxxmatcode());
                        fpxxfq1a5xwwqqhxxxxxitemHome.getInstance().setFpxxfq1a5xwwqqhxxxxxitem(itemL);
                       }

                       fpxxfq1a5xwwqqhxxxxxitemHome.persistRest();
                       adC=adC+1;
                    }
                    fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();//avoid detach entity for next variant
                    // reuse item but clear out sid
                    item.setA0xxuobxbxxxxxxxxxxxsid(null);

                   }//end of variants loop

              }catch (Exception e){
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+bundle.getString("at")+" "+contxt+" "+e.getMessage(),""));
               errcnt=errcnt+1;
               if(errcnt >10){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_ERROR,bundle.getString("many")+" "+bundle.getString("errors")+" "+bundle.getString("not")+" "+bundle.getString("continuing"),""));
                break;
               }
              }
             }//end of items loop
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("completed"),""));

             return "";
        }

        public String syncDataCustomers(){
             //foreign entities account,address,company,location
             String keyToE="tbdA";
             String shopUrl="";

              if (!identity.isLoggedIn() || !(customIdentity.hasRole("UH") || customIdentity.hasRole("UQ")) ) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("and")+" "+bundle.getString("correct")+" "+bundle.getString("user")+" "+bundle.getString("level")+" "+bundle.getString("is")+" "+bundle.getString("required"),""));
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       if (client.getF6xxuxxxlvxxxxxxxxxxlicensetype().equals("TrialPending")){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("email")+" "+bundle.getString("notification")+" "+bundle.getString("for")+" "+bundle.getString("login")+" "+bundle.getString("information"),""));
                       }
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient,""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient+" "+ex.getMessage(),""));
                        return null;

                }


                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("if")+" "+bundle.getString("install")+" "+bundle.getString("just")+" "+bundle.getString("performed"),""));

               return null;
              }

                // accesstoken recvd e25b608df4cbd55b4598ebc0a2a141d0
                // lets try with this token

              try{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,"sync customer data started",""));

                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","02")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();

                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;

                }


                 //make rest api using token in header for products
                 String ret="https://raaspishopify.myshopify.com//admin/customers.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"/admin/customers.json";
                 }else{
                  // mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"/admin/customers.json";
                 }

		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);
                //response from shopify is shown as output but is mapped to raaspi
                // using CustomStrategyCustomer.java
		BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));
                pp90="";
                adA=0;
                updtA=0;

		String output;
		outputs="";
                int skipLines=0;
                int line=0;
                int lines=0;
                int maxLines=500;
		while ((output = br.readLine()) != null) {
                     line=line+1;
                     if(line < skipLines){
                      continue;
                     }
                     lines=lines+1;
                     if(lines > maxLines){
                      break;
                     }
                     String doutput="";
                     String routput="";
                     routput=output;
                     while (routput.length()>120){
                      doutput=routput.substring(0,120)+System.lineSeparator();
                      routput= routput.substring(121,routput.length());
                      outputs=outputs+doutput+System.lineSeparator();
                      if(routput.length() <120){
                       outputs=outputs+System.lineSeparator()+routput;
                      }
                     }
                     outputs=outputs+System.lineSeparator()+output;
		}

                 Jxxxuq201xwwqqhxxxxxcustomer customerP;
                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject jobject = jelement.getAsJsonObject();

                JsonArray jarray = jobject.getAsJsonArray("customers");
                //CustomStrategyCustomer.java implements FieldNamingStrategy to map shopify labels to raaspi labels
                GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategyCustomer());
                Gson gson = gsonBuilder.create();
                Jxxxuq201xwwqqhxxxxxcustomer[] customers = gson.fromJson(jarray.toString(), Jxxxuq201xwwqqhxxxxxcustomer[].class);
                inC=0;
                updtC=0;
                adC=0;
                Fxxxuq111xwwqqhxxxxxaddress address=null;
                Fxxxuq111xwwqqhxxxxxaddress addressP=null;

                JsonArray jarrayA =null;

                for (Jxxxuq201xwwqqhxxxxxcustomer customer : customers){
                   //get entity fields like address which cannot be translated to json string from customer data
                   // but can be translated using customstrategyaddress
                   jarrayA = jarray.get(inC).getAsJsonObject().getAsJsonArray("addresses");
                 //persist/update  address first, then persist/update customer address
                 for(int j = 0; j < jarrayA.size(); j++){
                  //CustomStrategyAddress.java implements FieldNamingStrategy to map shopify labels to raaspi labels
                  String aId=jarrayA.get(j).getAsJsonObject().get("id").toString();
                  gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategyAddress());
                  gson = gsonBuilder.create();
                  address = gson.fromJson(jarrayA.get(j).getAsJsonObject().toString(), Fxxxuq111xwwqqhxxxxxaddress.class);
                  //for (Fxxxuq111xwwqqhxxxxxaddress address : addresses){
                   pp90="";
                   inA=inA+1;
                   //address entity holds data coming via rest, addressP holds existing entity, if any, for the id/key
                   addressP=fxxxuq111xwwqqhxxxxxaddressList.getKeyToEntity(aId);
                   fxxxuq111xwwqqhxxxxxaddressHome.clearInstance();
                   address.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge
                   address.setZ3xxutoxlhxxxxxxxxxxowner(ownerCode);
                   if(address.getZ1xxzzfxhhxxxxxxxxxxstatusfl() == null ){
                    address.setZ1xxzzfxhhxxxxxxxxxxstatusfl(0);
                    address.setZ2xxcztxlxxxxxxxxxxxstatusfldt(Calendar.getInstance().getTime());
                   }
                   //address rest data doesnt have ststusfldt eqv, so query corresponding customer and check
                   // its status assuming if address is changed customer ststusdt also change
                   // so hold adddress update decision until later, persist if address not in backoffice
                   // addressP will not be null because of cache but force it to read id
                   if(addressP !=null){
                    //if(statusCh){
                      fxxxuq111xwwqqhxxxxxaddressHome.setInstance(addressP);

                      //fxxxuq111xwwqqhxxxxxaddressHome.updateRest(address.getA0xxukbxbxxxxxxxxxxxaddrescode()); hold till customer update check
                      //updtA=updtA+1;
                    //}
                   }else{
                    //does not exist so persist it
                      fxxxuq111xwwqqhxxxxxaddressHome.setInstance(address);
                      if(address == null){
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("failed")+", "+bundle.getString("address")+" "+keyToE+" "+bundle.getString("missing"),""));
                       //return "";
                      }
                      fxxxuq111xwwqqhxxxxxaddressHome.persistRest();
                      adA=adA+1;
                   }
                 }//adresses loop, end of address persist/update
                   //now take care of customer along with its address
                   pp90="";
                   inC=inC+1;
                   // getinstance
                   customerP=jxxxuq201xwwqqhxxxxxcustomerList.getKeyToEntity(customer.getA0xxukxxbvxxxxxxxxxxcustomer());
                   jxxxuq201xwwqqhxxxxxcustomerHome.clearInstance();
                   customer.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge
                   customer.setZdxxutoxlhxxxxxxxxxxowner(ownerCode);
                   if(customer.getZaxxzzfxhhxxxxxxxxxxstatusfl() == null ){
                    customer.setZaxxzzfxhhxxxxxxxxxxstatusfl(0);
                   }

                   if(customerP !=null){
                    if(customer.getZbxxcztxlxxxxxxxxxxxstatusfldt() != null){
                     calendare.setTime(customer.getZbxxcztxlxxxxxxxxxxxstatusfldt());
                     calendar.setTime(customerP.getZbxxcztxlxxxxxxxxxxxstatusfldt());
                     if(calendare.after(calendar)){
                      //if e(external) date after p(previous) update , but key should not change even if description changes
                      customerP.setZbxxcztxlxxxxxxxxxxxstatusfldt(customer.getZbxxcztxlxxxxxxxxxxxstatusfldt());
                      jxxxuq201xwwqqhxxxxxcustomerHome.setInstance(customerP);
                      //set Id to inform hibernate it exists
                      jxxxuq201xwwqqhxxxxxcustomerHome.getInstance().setA0xxuobxbxxxxxxxxxxxsid(customerP.getA0xxuobxbxxxxxxxxxxxsid());
                      jxxxuq201xwwqqhxxxxxcustomerHome.updateRest(customer.getA0xxukxxbvxxxxxxxxxxcustomer());
                      statusCh=true;
                      updtC=updtC+1;
                      fxxxuq111xwwqqhxxxxxaddressHome.updateRest(address.getA0xxukbxbxxxxxxxxxxxaddrescode());//update address since customer status date changed
                      updtA=updtA+1;

                     }else{
                      //no change , skip
                     }
                    }else{
                     //already exists,assume no change and skip
                    }
                   }else{
                    jxxxuq201xwwqqhxxxxxcustomerHome.setInstance(customer);
                    //does not exist
                    // we need to populate foreign fields using raaspi data ex ship address,billing address,
                      //Fxxxuq111xwwqqhxxxxxaddress address=fxxxuq111xwwqqhxxxxxaddressList.getKeyToEntity("11740384147");
                      //if(address == null){
                       //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         //            FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("failed")+", "+bundle.getString("address")+" "+keyToE+" "+bundle.getString("missing"),""));
                       //return "";
                      //}
                      if(addressP !=null ){
                       customer.setFxxxuq111xwwqqhxxxxxaddressByMailtocode(addressP);
                       customer.setFxxxuq111xwwqqhxxxxxaddressByShiptocode(addressP);
                      }
                      //persist changed to allow existing customer # rather than generate key
                      jxxxuq201xwwqqhxxxxxcustomerHome.persistRest();
                      adC=adC+1;
                   }
                }
                //end of customer object
                //end of both customer and address



                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("completed"),""));
               }
              catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

              }


         return "";
        }

        public String syncDataAddresses(){
             //not used, incomplete logic address is part of customer now foreign entities account,address,company,location
             String keyToE="tbdA";
             String shopUrl="";

              if (!identity.isLoggedIn() || !(customIdentity.hasRole("UH") || customIdentity.hasRole("UQ")) ) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("and")+" "+bundle.getString("correct")+" "+bundle.getString("user")+" "+bundle.getString("level")+" "+bundle.getString("is")+" "+bundle.getString("required"),""));
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       if (client.getF6xxuxxxlvxxxxxxxxxxlicensetype().equals("TrialPending")){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("email")+" "+bundle.getString("notification")+" "+bundle.getString("for")+" "+bundle.getString("login")+" "+bundle.getString("information"),""));
                       }
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient,""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient+" "+ex.getMessage(),""));
                        return null;

                }


                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("if")+" "+bundle.getString("install")+" "+bundle.getString("just")+" "+bundle.getString("performed"),""));

               return null;
              }

                // accesstoken recvd e25b608df4cbd55b4598ebc0a2a141d0
                // lets try with this token

              try{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,"sync Address data started",""));

                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","02")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;

                }


                 //make rest api using token in header for products
                 String ret="https://raaspishopify.myshopify.com//admin/customers.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"/admin/customers.json";
                 }else{
                  // mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"/admin/customers.json";
                 }

		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);
                //response from shopify is shown as output but is mapped to raaspi
                // using CustomStrategyAddress.java
		BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));
                  pp90="";
		String output;
		outputs="";
                int skipLines=0;
                int line=0;
                int lines=0;
                int maxLines=500;
		while ((output = br.readLine()) != null) {
                     line=line+1;
                     if(line < skipLines){
                      continue;
                     }
                     lines=lines+1;
                     if(lines > maxLines){
                      break;
                     }
                     String doutput="";
                     String routput="";
                     routput=output;
                     while (routput.length()>120){
                      doutput=routput.substring(0,120)+System.lineSeparator();
                      routput= routput.substring(121,routput.length());
                      outputs=outputs+doutput+System.lineSeparator();
                      if(routput.length() <120){
                       outputs=outputs+System.lineSeparator()+routput;
                      }
                     }
                     outputs=outputs+System.lineSeparator()+output;
		}
                //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                //                     FacesMessage.SEVERITY_INFO,outputs,""));
                // comment out above

                 Fxxxuq111xwwqqhxxxxxaddress addressP;
                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject jobject = jelement.getAsJsonObject();

                 JsonArray jarray = jobject.getAsJsonArray("customers");
                 //CustomStrategyCustomer.java implements FieldNamingStrategy to map shopify labels to raaspi labels
                GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategyAddress());
                Gson gson = gsonBuilder.create();
                Fxxxuq111xwwqqhxxxxxaddress[] addresses = gson.fromJson(jarray.toString(), Fxxxuq111xwwqqhxxxxxaddress[].class);
                inC=0;
                updtC=0;
                adC=0;
                for (Fxxxuq111xwwqqhxxxxxaddress address : addresses){
                   pp90="";
                   inC=inC+1;
                   // getinstance
                   addressP=fxxxuq111xwwqqhxxxxxaddressList.getKeyToEntity(address.getA0xxukbxbxxxxxxxxxxxaddrescode());
                   fxxxuq111xwwqqhxxxxxaddressHome.clearInstance();
                   address.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge
                   address.setZ3xxutoxlhxxxxxxxxxxowner(ownerCode);
                   if(address.getZ1xxzzfxhhxxxxxxxxxxstatusfl() == null ){
                    address.setZ1xxzzfxhhxxxxxxxxxxstatusfl(0);
                   }

                   fxxxuq111xwwqqhxxxxxaddressHome.setInstance(address);
                   if(addressP !=null){
                    if(address.getZ2xxcztxlxxxxxxxxxxxstatusfldt() != null){
                     calendare.setTime(address.getZ2xxcztxlxxxxxxxxxxxstatusfldt());
                     calendar.setTime(addressP.getZ2xxcztxlxxxxxxxxxxxstatusfldt());
                     if(calendare.after(calendar)){
                      //if e(external) date after p(previous) update , but key should not change even if description changes
                      //set Id to inform hibernate it exists
                      fxxxuq111xwwqqhxxxxxaddressHome.getInstance().setA0xxuobxbxxxxxxxxxxxsid(address.getA0xxuobxbxxxxxxxxxxxsid());
                      fxxxuq111xwwqqhxxxxxaddressHome.updateRest(address.getA0xxukbxbxxxxxxxxxxxaddrescode());
                      updtC=updtC+1;
                     }else{
                      //no change , skip
                     }
                    }else{
                     //already exists,assume no change and skip
                    }
                   }else{
                    //does not exist
                    // we need to populate foreign fields using raaspi data ex ship address,billing address,
                      //Fxxxuq111xwwqqhxxxxxaddress address=fxxxuq111xwwqqhxxxxxaddressList.getKeyToEntity("11740384147");
                      if(address == null){
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("failed")+", "+bundle.getString("address")+" "+keyToE+" "+bundle.getString("missing"),""));
                       //return "";
                      }
                      // get customer first
                      //customer.setFxxxuq111xwwqqhxxxxxaddressByMailtocode(address);
                      //persist changed to allow existing customer # rather than generate key
                      //jxxxuq201xwwqqhxxxxxcustomerHome.persistRest();
                   }
                }
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("completed"),""));
               }
                catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

                }


         return "";
        }



    /**
    * not used yet
    * The following method is used to Sync Order Txns
    * There can be five type (like Paypal)-Authorization,Sale,Capture,Void,Refund
    * called by ???
    * @return null or ""
    * uses CustomStrategyTransaction to map shopify order txns to raaspi order details ?? and at end saves order
    * details at raaspi
    * @exception no select result or select failed. Also key missing etc
    * @see syncDataOrders
    *
    */
        public String syncDataTransactions(){
             String keyToE="tbdI";
             String shopUrl="";

              if (!identity.isLoggedIn() || !(customIdentity.hasRole("UH") || customIdentity.hasRole("UQ")) ) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("and")+" "+bundle.getString("correct")+" "+bundle.getString("user")+" "+bundle.getString("level")+" "+bundle.getString("is")+" "+bundle.getString("required"),""));
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       if (client.getF6xxuxxxlvxxxxxxxxxxlicensetype().equals("TrialPending")){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("email")+" "+bundle.getString("notification")+" "+bundle.getString("for")+" "+bundle.getString("login")+" "+bundle.getString("information"),""));
                       }
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient,""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient+" "+ex.getMessage(),""));
                        return null;

                }


                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("if")+" "+bundle.getString("install")+" "+bundle.getString("just")+" "+bundle.getString("performed"),""));

               return null;
              }

                // accesstoken recvd e25b608df4cbd55b4598ebc0a2a141d0
                // lets try with this token

              try{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,"sync Transactions data started",""));

                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","02")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();

                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;

                }


                 //make rest api using token in header for orders
                 //
                 String ret="https://raaspishopify.myshopify.com//admin/transactions.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"//admin/transactions.json";
                 }else{
                  // mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"//admin/transactions.json";
                 }

		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);
                //debug purpose comment out
		BufferedReader br = new BufferedReader(new InputStreamReader(
		new ByteArrayInputStream(response.getEntity().getBytes())));
                pp90="";
                adA=0;
                updtA=0;

		String output;
		outputs="";
                int skipLines=0;
                int line=0;
                int lines=0;
                int maxLines=500;
		while ((output = br.readLine()) != null) {
                     line=line+1;
                     if(line < skipLines){
                      continue;
                     }
                     lines=lines+1;
                     if(lines > maxLines){
                      break;
                     }
                     String doutput="";
                     String routput="";
                     routput=output;
                     while (routput.length()>120){
                      doutput=routput.substring(0,120)+System.lineSeparator();
                      routput= routput.substring(121,routput.length());
                      outputs=outputs+doutput+System.lineSeparator();
                      if(routput.length() <120){
                       outputs=outputs+System.lineSeparator()+routput;
                      }
                     }
                     outputs=outputs+System.lineSeparator()+output;
		}

                 Trexuq244xwwqqhxxxxxcuorders orderP;
                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject jobject = jelement.getAsJsonObject();

                 JsonArray jarray = jobject.getAsJsonArray("orders");

                 JsonObject eachorder = null;
                 String j1=null;
                 JsonObject j2=null;
                 String matCodeSubCat=null;
                 String matCode=null;
               //we may need to use index in the loop below for each order instance
               // ex matCode from line_items can be used in order and also in cuodetails

                GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategyOrder());
                Gson gson = gsonBuilder.create();

                Trexuq244xwwqqhxxxxxcuorders[] orders = gson.fromJson(jarray.toString(), Trexuq244xwwqqhxxxxxcuorders[].class);

                inC=0;
                updtC=0;
                adC=0;
                for (Trexuq244xwwqqhxxxxxcuorders order : orders){
                   int oi=0;
                   pp90="";
                   inC=inC+1;
                   // getinstance
                   orderP=trexuq244xwwqqhxxxxxcuordersList.getKeyToEntity(order.getA0xxuncobvxxxxxxxxxxpurchsno());
                   trexuq244xwwqqhxxxxxcuordersHome.clearInstance();
                   order.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge
                   order.setZexxutoxlhxxxxxxxxxxowner(ownerCode);

                   if(order.getY9xxcxxxbv10xxxxxxxxtype() == null || order.getY9xxcxxxbv10xxxxxxxxtype().isEmpty() ){
                    order.setY9xxcxxxbv10xxxxxxxxtype("cart");
                   }
                   if(order.getZcxxzzfxhhxxxxxxxxxxstatusfl() == null ){
                    order.setZcxxzzfxhhxxxxxxxxxxstatusfl(64);//make it invoiced if authorized in shopify
                    order.setZcxxzzfxhhxxxxxxxxxxstatusfl(16);//make it paid if sale in shopify
                   }

                   if(order.getC1xxcxxxbxxxxxxxxxxxodatet() == null){
                    order.setC1xxcxxxbxxxxxxxxxxxodatet(new Date());
                   }
                   trexuq244xwwqqhxxxxxcuordersHome.setInstance(order);
                   if(orderP !=null){
                    if(order.getZdxxcztxlxxxxxxxxxxxstatusfldt() != null){
                     calendare.setTime(order.getZdxxcztxlxxxxxxxxxxxstatusfldt());
                     calendar.setTime(orderP.getZdxxcztxlxxxxxxxxxxxstatusfldt());
                     if(calendare.after(calendar)){
                      //if e(external) date after p(previous) update , but key should not change even if description changes
                      //orfder built from shopify ensure sid has value
                      trexuq244xwwqqhxxxxxcuordersHome.getInstance().setA0xxuobxbxxxxxxxxxxxsid(orderP.getA0xxuobxbxxxxxxxxxxxsid());
                      trexuq244xwwqqhxxxxxcuordersHome.updateRest(order.getA0xxuncobvxxxxxxxxxxpurchsno());
                      updtC=updtC+1;
                     }else{
                      //no change , skip
                     }
                    }else{
                     //already exists,assume no change and skip
                    }
                   }else{
                    //does not exist
                    // we need to populate foreign fields using raaspi data ex item,customer,customer ship address,billing address,
                    //   employee as sales agent. quote stays as null but the keys come from json data
                    // need to create cuodetails from shopify json data
                    // in shopify there is Order (Cuorder status ) DraftOrder ie order entered by Merchant but not paid yet, when paid becomes Order (Cuorder)
                    // Order Transaction showing financial valuesfor each order (CuOrders and cuodetails), Abondoned checkouts (Cuorder status & temp user/logonid )
                    // Order Risk (Cuorder notes, need new logic to show fraud indicator see https://help.shopify.com/en/manual/orders/fraud-analysis#fraud-analysis-indicators
                    // use ip address, history (cuodetails)
                    // cuodetails come as line_items which is array of lists of items including array
                    eachorder = jarray.get(oi).getAsJsonObject();//jarray has many order as array members
                    j1=eachorder.get("email").toString();//refer to object member by name and non array string value
                    j2=eachorder.getAsJsonArray("line_items").get(oi).getAsJsonObject();//object member can be referred by name and array by index
                    matCodeSubCat=j2.get("product_id").toString();
                    matCode=j2.get("variant_id").toString();

                      keyToE=matCodeSubCat;
                      keyToE=matCodeSubCat;
                      Fpxxfq1a5xwwqqhxxxxxitem item=fpxxfq1a5xwwqqhxxxxxitemList.getKeyToEntity(keyToE);
                      if(item == null){
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("failed")+", "+bundle.getString("product")+" "+keyToE+" "+bundle.getString("missing"),""));
                       return "";
                      }

                      order.setFpxxfq1a5xwwqqhxxxxxitem(item);
                      //need to sync customer first but it comes as json single Object  ie "customer":{"id":1234,"first_name":"bob","total_spent":"8.0"}
                      keyToE=order.getJxxxuq201xwwqqhxxxxxcustomer().getA0xxukxxbvxxxxxxxxxxcustomer();
                      Jxxxuq201xwwqqhxxxxxcustomer customer=jxxxuq201xwwqqhxxxxxcustomerList.getKeyToEntity(keyToE);
                      if(customer == null){
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("failed")+", "+bundle.getString("customer")+" "+keyToE+" "+bundle.getString("missing"),""));
                       return "";
                      }
                      order.setJxxxuq201xwwqqhxxxxxcustomer(customer);

                      Xoxxuq2b4xwwqqhxxxxxcuodetails cuodetail=null;
                      //persist changed to allow existing order # rather than generate key
                      trexuq244xwwqqhxxxxxcuordersHome.persistRest();
                      adC=adC+1;
                   }
                }
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("completed"),""));
               }
                catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

                }


         return "";
        }


    /**
    * The following method is used to Sync Orders
    * Shopify order is a customer's completed request to purchase one or more products from a shop like
    * raaspi checkout order
    * raaspi backOffice created orders are Shopify Draft Orders
    * called by SyncData.xhtml
    * @return null or ""
    * uses CustomStrategyTransaction to map shopify order txns to raaspi orders and at end saves orders at raaspi
    * @exception no select result or select failed. Also key missing etc
    * @see syncDataTransactions
    *
    */

        public String syncDataOrders(){
             String keyToE="tbdI";
             String shopUrl="";
             boolean updated=false;
             boolean nnew=false;
             int errcnt=0;
             Xoxxuq2b4xwwqqhxxxxxcuodetails orderdetail=null;
             Xoxxuq2b4xwwqqhxxxxxcuodetails orderdetailP=null;
             //Trexuq244xwwqqhxxxxxcuorders order=null;
             Trexuq244xwwqqhxxxxxcuorders orderP=null;
             Fpxxfq1a5xwwqqhxxxxxitem item=null;

              if (!identity.isLoggedIn() || !(customIdentity.hasRole("UH") || customIdentity.hasRole("UQ")) ) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("and")+" "+bundle.getString("correct")+" "+bundle.getString("user")+" "+bundle.getString("level")+" "+bundle.getString("is")+" "+bundle.getString("required"),""));
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       if (client.getF6xxuxxxlvxxxxxxxxxxlicensetype().equals("TrialPending")){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("email")+" "+bundle.getString("notification")+" "+bundle.getString("for")+" "+bundle.getString("login")+" "+bundle.getString("information"),""));
                       }
                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient,""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("shop")+" "+owner2CodeClient+" "+ex.getMessage(),""));
                        return null;

                }


                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("if")+" "+bundle.getString("install")+" "+bundle.getString("just")+" "+bundle.getString("performed"),""));

               return null;
              }

                // accesstoken recvd e25b608df4cbd55b4598ebc0a2a141d0
                // lets try with this token

                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,"sync Orders data started",""));

                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","02")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();

                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;

                }

               try{

                 //make rest api using token in header for orders
                 //
                 String ret="https://raaspishopify.myshopify.com//admin/orders.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"/admin/orders.json";
                 }else{
                  // mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"/admin/orders.json";
                 }

		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);
                //debug purpose comment out
		BufferedReader br = new BufferedReader(new InputStreamReader(
		new ByteArrayInputStream(response.getEntity().getBytes())));
                pp90="";
                adA=0;
                updtA=0;

		String output;
		outputs="";
                int skipLines=0;
                int line=0;
                int lines=0;
                int maxLines=500;
		while ((output = br.readLine()) != null) {
                     line=line+1;
                     if(line < skipLines){
                      continue;
                     }
                     lines=lines+1;
                     if(lines > maxLines){
                      break;
                     }
                     String doutput="";
                     String routput="";
                     routput=output;
                     while (routput.length()>120){
                      doutput=routput.substring(0,120)+System.lineSeparator();
                      routput= routput.substring(121,routput.length());
                      outputs=outputs+doutput+System.lineSeparator();
                      if(routput.length() <120){
                       outputs=outputs+System.lineSeparator()+routput;
                      }
                     }
                     outputs=outputs+System.lineSeparator()+output;
		}

                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject jobject = jelement.getAsJsonObject();
                 JsonObject jjobject=null;

                 JsonArray jarray = jobject.getAsJsonArray("orders");//whole responseString was parsed above

                 JsonObject eachorder = null;
                 String j1=null;
                 JsonObject j2=null;
                 String matCodeSubCat=null;
                 String matCode=null;
                 String descript=null;
               //we may need to use index in the loop below for each order instance
               // ex matCode from line_items can be used in order and also in cuodetails

                GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategyOrder());
                Gson gson = gsonBuilder.create();

                Trexuq244xwwqqhxxxxxcuorders[] orders = gson.fromJson(jarray.toString(), Trexuq244xwwqqhxxxxxcuorders[].class);

                inC=0;
                updtC=0;
                adC=0;
                int oi=0;
                //jarray holds shopify data for all orders as json, orders hold the same data as raaspi entity
                // jarray each index inC holds each order json data as jsonObject row. Index i is used to loop
                // line_items inside row
                //
                //
                // order entity holds order info and used to check if it exists in raaspi and if so update date

                for (Trexuq244xwwqqhxxxxxcuorders order : orders){
                   pp90="";
                   //inC=inC+1;
                   // getinstance
                   contxt="order "+order.getA0xxuncobvxxxxxxxxxxpurchsno();
                   orderP=trexuq244xwwqqhxxxxxcuordersList.getKeyToEntity(order.getA0xxuncobvxxxxxxxxxxpurchsno());
                   trexuq244xwwqqhxxxxxcuordersHome.clearInstance();
                   order.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge
                   order.setZexxutoxlhxxxxxxxxxxowner(ownerCode);
                   if(order.getY9xxcxxxbv10xxxxxxxxtype() == null || order.getY9xxcxxxbv10xxxxxxxxtype().isEmpty() ){
                    order.setY9xxcxxxbv10xxxxxxxxtype("cart");
                   }
                   if(order.getZcxxzzfxhhxxxxxxxxxxstatusfl() == null ){
                    order.setZcxxzzfxhhxxxxxxxxxxstatusfl(64);//make it invoiced if authorized in shopify
                    order.setZcxxzzfxhhxxxxxxxxxxstatusfl(16);//make it paid if sale in shopify
                   }

                   if(order.getC1xxcxxxbxxxxxxxxxxxodatet() == null){
                    order.setC1xxcxxxbxxxxxxxxxxxodatet(new Date());
                   }
                   if(orderP !=null && orderP.getA0xxuobxbxxxxxxxxxxxsid()!=null ){
                    nnew=false;
                    // if update we should use existing orderP as base and change those values coming
                    // via rest refer to customStrategyOrder. orderP hold foreign
                    if(order.getZdxxcztxlxxxxxxxxxxxstatusfldt() != null){
                     calendare.setTime(order.getZdxxcztxlxxxxxxxxxxxstatusfldt());
                     calendar.setTime(orderP.getZdxxcztxlxxxxxxxxxxxstatusfldt());//from raaspi
                     if(calendare.after(calendar)){
                      updated=true;
                      // either webhook or use printfl(not used or needed) for addtional flag and dt and delete
                      //if e(external) date after p(previous) update , but key should not change even if description changes
                      orderP.setZ1xxztprlxxxxxxxxxxxamounttotal(order.getZ1xxztprlxxxxxxxxxxxamounttotal());
                      orderP.setZdxxcztxlxxxxxxxxxxxstatusfldt(order.getZdxxcztxlxxxxxxxxxxxstatusfldt());
                      order.setZcxxzzfxhhxxxxxxxxxxstatusfl(64);//make it invoiced if authorized in shopify
                      order.setZcxxzzfxhhxxxxxxxxxxstatusfl(16);//make it paid if sale in shopify

                      trexuq244xwwqqhxxxxxcuordersHome.setInstance(orderP);
                      //set Id to avoid being new ?? but orderP is being used
                      if(trexuq244xwwqqhxxxxxcuordersHome.getInstance().getA0xxuobxbxxxxxxxxxxxsid()==null){
                       trexuq244xwwqqhxxxxxcuordersHome.getInstance().setA0xxuobxbxxxxxxxxxxxsid(orderP.getA0xxuobxbxxxxxxxxxxxsid());
                      }
                      trexuq244xwwqqhxxxxxcuordersHome.updateRest(order.getA0xxuncobvxxxxxxxxxxpurchsno());
                      updtC=updtC+1;
                      inC=inC+1;// need to increase even if
                      continue;// until new logic in raaspi. what happens when removed in shopify??
                     }else{
                      //no change , skip
                      updated=false;
                      inC=inC+1;// need to increase even if
                      continue;
                     }
                    }else{
                     //already exists,assume no change and skip
                      updated=false;
                    }
                   }else{
                    //does not exist
                    nnew=true;
                    //adC=adC+1; order and first detail persist is combined
                   }
                    trexuq244xwwqqhxxxxxcuordersHome.setInstance(order);
                    // we need to populate foreign fields using raaspi data ex item,customer,customer ship address,billing address,
                    //   employee as sales agent. quote stays as null but the keys come from json data
                    // need to create cuodetails from shopify json data
                    // in shopify there is Order (Cuorder status ) DraftOrder ie order entered by Merchant but not paid yet, when paid becomes Order (Cuorder)
                    // Order Transaction showing financial valuesfor each order (CuOrders and cuodetails), Abondoned checkouts (Cuorder status & temp user/logonid )
                    // Order Risk (Cuorder notes, need new logic to show fraud indicator see https://help.shopify.com/en/manual/orders/fraud-analysis#fraud-analysis-indicators
                    // use ip address, history (cuodetails)
                    // cuodetails come as line_items which is array of lists of items including array
                    // ecahorder which was here, seems same as row so moved to below
//---------------------cuodetail--- similar to child item
                   //get entity fields which cannot be easily translated to json string via (order)customStrategy
                   // unless another customStrategyVariants is used or array index is used.
                   // Here, we will extract the values from variants(line_items) Array to json object and then by tag value
                   JsonObject row=jarray.get(inC).getAsJsonObject(); //variants value starts with [ so it json array
                   // fitst variant ie get(0) has value for the product's default or only variant
                   jelement=null;
                   JsonObject line_item=null;
                   JsonObject tax_lines=null;
                   JsonObject shipping_lines=null;
                   String value=null;
                   String checkedDataAndSize=null;
                   String shippingOptions=null;
                   String barUpc=null;
                   String titleC=null;
                   inC=inC+1;
                   xoxxuq2b4xwwqqhxxxxxcuodetailsHome.clearInstance();
                   orderdetail=xoxxuq2b4xwwqqhxxxxxcuodetailsHome.getInstance();
                   xoxxuq2b4xwwqqhxxxxxcuodetailsHome.clearInstance();
                   orderdetailP=xoxxuq2b4xwwqqhxxxxxcuodetailsHome.getInstance();

                   if(row.get("line_items").isJsonNull()){
                    continue;
                   }
                    jjobject=row.get("total_shipping_price_set").getAsJsonObject();

                    if(jjobject !=null && !jjobject.isJsonNull()){
                     jjobject=jjobject.get("shop_money").getAsJsonObject();
                    }

                   for (int i =0;i<row.get("line_items").getAsJsonArray().size();i++){
                    //order was created in upper loop via orderStrategy and has purchsno, descript, notes,statusfldt etc
                    // but had product values (parent), override as needed with variant value otherwise inherit values
                    line_item=row.get("line_items").getAsJsonArray().get(i).getAsJsonObject();
                    //eachorder = jarray.get(oi).getAsJsonObject();//jarray has many order as array members
                    j1=row.get("email").toString();//refer to object member by name and non array string value
                    //j2=eachorder.getAsJsonArray("line_items").get(0).getAsJsonObject();//object member can be referred by name and array by index
                    keyToE=line_item.get("product_id").toString();
                      //order does not have body_html /descript so use contains search not equal
                      item=fpxxfq1a5xwwqqhxxxxxitemList.getKeyContainsToEntity(keyToE);
                      if(item == null){
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("failed")+", "+bundle.getString("product")+" "+keyToE+" "+bundle.getString("missing"),""));
                       return "";
                      }
                      order.setFpxxfq1a5xwwqqhxxxxxitem(item);
                      //need to sync customer first but it comes as json single Object  ie "customer":{"id":1234,"first_name":"bob","total_spent":"8.0"}
                      if(order.getJxxxuq201xwwqqhxxxxxcustomer()==null){
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("order")+" "+orderP+", "+bundle.getString("customer")+" "+bundle.getString("data")+" "+bundle.getString("missing"),""));
                      }else{
                       keyToE=order.getJxxxuq201xwwqqhxxxxxcustomer().getA0xxukxxbvxxxxxxxxxxcustomer();
                       Jxxxuq201xwwqqhxxxxxcustomer customer=jxxxuq201xwwqqhxxxxxcustomerList.getKeyToEntity(keyToE);
                       if(customer == null){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("customer")+" "+keyToE+" "+bundle.getString("missing")+", "+bundle.getString("try")+" "+bundle.getString("Sync")+" "+bundle.getString("customers"),""));
                       }else{
                        order.setJxxxuq201xwwqqhxxxxxcustomer(customer);
                       }
                      }





                    value=line_item.get("price").toString().replace("\"","");//already string value
                    contxt=contxt+" last value "+value;
                    orderdetail.setZ5xxzpxravxxxxxxxxxxordprice(new BigDecimal(value));
                    value=line_item.get("quantity").toString().replace("\"","");//already string value
                    contxt=contxt+", "+value;
                    orderdetail.setZ3xxeqxxbvnxxxxxxxxxqtyordrd(new BigDecimal(value));
                    if(line_item.get("tax_lines").getAsJsonArray().size() > 0){
                       tax_lines=line_item.get("tax_lines").getAsJsonArray().get(0).getAsJsonObject();
                       value=tax_lines.get("price").toString().replace("\"","");
                       contxt=contxt+", "+value;
                       trexuq244xwwqqhxxxxxcuordersHome.setDetailTax1(new BigDecimal(value));
                    }


                     //shipping_lines is another element like line_item not within line_item
                     //needs another loop like line_item but is it really needed? using the total for ist line

                    if(jjobject !=null && !jjobject.isJsonNull() && i==0){
                    contxt=contxt+", "+value;
                     value=jjobject.get("amount").toString().replace("\"","");
                     //orderdetail.setZbxxzlxxavxxxxxxxxxxdelivchrg(new BigDecimal(value));
                     trexuq244xwwqqhxxxxxcuordersHome.setDetailDel(new BigDecimal(value));

                    }

                    pp90="";
                    xoxxuq2b4xwwqqhxxxxxcuodetailsHome.clearInstance();

                    orderdetail.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeApp);//not via getInstance, look into merge

                    // now set parent
                    orderP=trexuq244xwwqqhxxxxxcuordersHome.getInstance();
                    //orderdetail.setTrexuq244xwwqqhxxxxxcuorders(orderP);
                    //xoxxuq2b4xwwqqhxxxxxcuodetailsHome.clearInstance();
                    //xoxxuq2b4xwwqqhxxxxxcuodetailsHome.setInstance(orderdetail);
                    // simulate backoffice ie item qty and price, add logic for deliv,misc tax etc
                    item.setB8fbzpxxbvxxxxxxxxxxselprice(orderdetail.getZ5xxzpxravxxxxxxxxxxordprice());
                    item.setB0xxziqxlvxxsaxxxxxxquantity(orderdetail.getZ3xxeqxxbvnxxxxxxxxxqtyordrd());
                    //xoxxuq2b4xwwqqhxxxxxcuodetailsHome.setDetailMis();

                    //order exists in raaspi
                       trexuq244xwwqqhxxxxxcuordersHome.setNextShow(true);//jay added to entityHome
                       trexuq244xwwqqhxxxxxcuordersHome.setRestEntity(true);//jay added to entityHome
                       Integer currentCartedPOSID;
                       currentCartedPOSID=trexuq244xwwqqhxxxxxcuordersHome.getInstance().getA0xxuobxbxxxxxxxxxxxsid();
                       //flow is 1. cartPersist with o while item has the qty and price. creates order and detail
                       //2.call more to reset detail entity or do it here
                       //3.call updatedetailsall to add next item
                       //if currentCartedPOSID is null then create order and add detail, if not null then only add detail
                       // last parameter quantity is used for if C not type O
                       if(nnew){
                        if(i==0 ){
                         trexuq244xwwqqhxxxxxcuordersHome.cartpersist(currentCartedPOSID,"o",new Integer(i),new BigDecimal("0.0"));
                         adC=adC+1;
                        }else{
                         trexuq244xwwqqhxxxxxcuordersHome.more();
                         trexuq244xwwqqhxxxxxcuordersHome.updateDetailsAll();
                        }
                       }
                       if (updated){
                         //no logic in raaspi for updating existing order, is it ok to assume no change to order, issue
                         // credit or delete only??
                         updtC=updtC+1;
                        //skip if not new and no change at shopify
                       }

                    xoxxuq2b4xwwqqhxxxxxcuodetailsHome.clearInstance();//avoid detach entity for next variant
                    // reuse item but clear out sid
                    orderdetail.setA0xxuobxbxxxxxxxxxxxsid(null);
                    fpxxfq1a5xwwqqhxxxxxitemHome.clearInstance();

                   }//end of line_items/detail loop

//---------------------end of cuodetail--------------------

                }//each order
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("sync")+" "+bundle.getString("completed"),""));

               }catch (Exception e){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+bundle.getString("at")+" "+contxt+" "+e.getMessage(),""));
                errcnt=errcnt+1;
                if(errcnt >10){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 FacesMessage.SEVERITY_ERROR,bundle.getString("many")+" "+bundle.getString("errors")+" "+bundle.getString("not")+" "+bundle.getString("continuing"),""));
                }
               }



            return "";
        }

    /**
    A merchant triggers a charge with an event that you've identified, such as app installation, service plan upgrade, or individual purchase.
    -not applicapable
    The app creates a charge for the merchant, which might be a recurring or one-time charge.
    -after trial, raaspi will create one time charge post json including raaspi url as return_url and send to shopify
     token tells shopify which shop
     Shopify verifies the charge and returns a confirmation_url that redirects the merchant to accept or decline the charge.
    -response to raaspi (may be delay) will have charge_id appended to decorated_return_url and a new tag confirmation_url with shop url and charge signature
    When the merchant accepts the charge they are redirected to the return_url specified when issuing the charge. The decorated_return_url contains the charge_id.
    -raaspi gets the response, need to add page action logic to activate method to process
    If the merchant accepts, then the app uses the charge_id to activate the charge. If the charge is declined, then Shopify redirects the merchant and provides a notification message that the app charge was declined.
     -need to check whether to activate the charge and start/renew subscription or if decline stop trial
    After the charge is activated, you'll get paid. If you do not activate a RecurringApplicationCharge, then the merchant is not charged and you are not paid. If you do not activate an ApplicationCharge,
     then the merchant is charged when accepting, but you are not paid
    - if accept send activate_charge to shopify and wait for payment from shopify

    * Raaspi allows merchants to install public app and obtain access token for specific shop
    * once installed merchants can sync data from their own Raaspi site to their shop data
    * this method gets invoked by page view action when shopify responds to install request
    * this method checks the hmac etc to confirm that response did come from specific shop
    * and once confirmed makes request to obtain permanent token to access data
    * if token is received two things happen
    * 1. create a raaspi site xxx.raaspi.com(mimic registration) where xxx is shopname.if xxx taken make it xxxn
    * 2. save token in client as secret and shop url as rinraddr
    * at end redirect to xxx.raaspi.com which has a new menu sync data under start here if rinraddr is not null/isEmpty
    * @param args-option 1 shop url to identify shop
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * prod/raaspiB ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]= ";
    * test/local   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shoauthverify.wflow &amp;state=001 &amp;grant_options[]= ";
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath
    */

     public String applicationCharge(String action,String clientOwner2){
      String shopUrl="";
      String strippedV="";
      String viewId="";
      ExternalContext extCtxt = null;
      HttpServletRequest httpreq = null;
      facesContext = FacesContext.getCurrentInstance();
      if(facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       externalContext = facesContext.getExternalContext();
      }

      if(clientOwner2.equals("shopId")){
       viewId =  FacesContext.getCurrentInstance().getViewRoot().getViewId();
       if (viewId.contains("SqlAdmin")){
        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
        httpreq = (HttpServletRequest) extCtxt.getRequest();
        if (httpreq.getParameter("PayerID") != null ){
         try{
          //this.makePayPalPayment(httpreq.getParameter("PayerID"),httpreq.getParameter("guid"));
         }catch(Exception e){
          //we get exception since there is no ntgrok locally
          //on any command window type ngrok http 8080
          //will see https://f2ac96f7.ngrok.io will forward to local host 8080

          if(httpreq.getServerName().contains("ngrok") && httpreq.getServerName().contains("8080") ){
           if(viewId.contains("checkout.")){
            return "raaspi.lraaspi.com:8080/checkout.wflow";
           }else{
            return "raaspi.lraaspi.com:8080/paymentout.wflow";
           }
          }
          log.severe("r3RestClient shopify charge/payment Exception "+e.getMessage());
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("in")+" "+bundle.getString("paypal")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
          bcontinue=false;
         }
        }
       }
       return null;
      }


              //we need to use access token specific for client
              try{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,"Merchant charge/activate started",""));

                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","02")
					.setParameter("owner2", clientOwner2)
					.getSingleResult();
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();

                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;

                }


                 String input ="";
                 String ret="https://raaspishopify.myshopify.com//admin/application_charges.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"/admin/";
                 }else{
                  // in the browser,mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"/admin/";
                 }
                 if(action.equals("a")){
                  ret=ret+"activate.json";
                  if (chargeResponse !=null){
                   //stripoff confirmatio_return url
                   strippedV=chargeResponse;
                   input=strippedV;
                  }else{
                    //read from clobdata
                    chargeResponse=yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","A"+shopUrl,"TXT",0).getB1xxuzaxbvxxxxxxxxxxdata();
                    if (chargeResponse ==null){
                    }else{
                     strippedV=chargeResponse;//use java indexof to strip
                     input=strippedV;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,bundle.getString("merchant")+" "+shopUrl+" "+bundle.getString("charge")+" "+bundle.getString("create")+" "+bundle.getString("in")+" "+bundle.getString("clob")+" "+bundle.getString("not")+" "+bundle.getString("done"),""));
                     return "";
                    }
                  }
                  // process activity ie send to shopify
                  ret=ret+"application_charges.json";
                  input = "{\"application_charge\":{\"name\":\"App charge\",\"price\": 120.0,\"return_url\":\"https://www.raaspi.com\",\"test\":true}}";
                  input=strippedV;
		  ClientRequest request = new ClientRequest(ret);
		  request = new ClientRequest(ret);
                  request.header("Accept",MediaType.APPLICATION_JSON);
                  request.header("Content-Type", MediaType.APPLICATION_JSON);
                  request.header("X-Shopify-Access-Token", access_token);
                  request.body(MediaType.APPLICATION_JSON,input);
  		  ClientResponse<String> response = request.post(String.class);
                  log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+response);
                  activateResponse= response.getEntity(String.class);


                 }
                 //(action.equals("c")){
                 // read from clobdata
                 chargeResponse=yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","A"+shopUrl,"TXT",0).getB1xxuzaxbvxxxxxxxxxxdata();
                 if (chargeResponse !=null){
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,bundle.getString("merchant")+" "+shopUrl+" "+bundle.getString("charge")+" "+bundle.getString("response")+" "+bundle.getString("exists")+" "+bundle.getString("clobdata")+" "+bundle.getString("key")+" "+shopUrl+", "+bundle.getString("investigate")+" "+bundle.getString("and")+", "+bundle.getString("delete")+", "+bundle.getString("before")+", "+bundle.getString("trying"),""));
                     return "";

                 }
                 ret=ret+"application_charges.json";
                 input = "{\"application_charge\":{\"name\":\"App charge\",\"price\": 120.0,\"return_url\":\"https://www.raaspi.com\",\"test\":true}}";
		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);


                 // add logic with a flag to add refresh_token along with id,secret and code if partnrer secret has changed
                 // refresh token will tell shopify to allow new token value for existing customers with old token
                 // needs testing
                 request.body(MediaType.APPLICATION_JSON,input);
		 ClientResponse<String> response = request.post(String.class);
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+response);
                   pp90="";
                 chargeResponse= response.getEntity(String.class);
                 if(action.equals("c")){
                  //added logic to save as clobdata key store id if session ends to be used as input fot activate
                  try{
                   //create clobdata instance and persist when activate done delete it
                   yxxxuq1m1xwwqqqxxxxxclobdataHome.createInstance();
                   yxxxuq1m1xwwqqqxxxxxclobdata=yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		   yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		   yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey(shopUrl);
 		   yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(0);
		   yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier("TXT");
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(chargeResponse);
                   yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                   yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
                   yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                  }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("merchant")+" "+shopUrl+" "+bundle.getString("charge")+" "+bundle.getString("clobdata")+" "+bundle.getString("persist")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        return null ;

                  }

                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,bundle.getString("merchant")+" "+shopUrl+" "+bundle.getString("charge")+" "+bundle.getString("create")+" "+bundle.getString("done"),""));

                 }
                 JsonElement jelement = new JsonParser().parse(chargeResponse);
                 JsonObject  jobject = jelement.getAsJsonObject();
                 return null;
              }catch (Exception e){
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_ERROR,bundle.getString("merchant")+" "+shopUrl+" "+bundle.getString("charge")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                 return "";
              }

         }


    /**
    * Raaspi allows merchants to install public app and obtain access token for specific shop
    * once installed merchants can sync data from their own Raaspi site to their shop data
    * this method gets invoked by page view action when shopify responds to install request
    * this method checks the hmac etc to confirm that response did come from specific shop
    * and once confirmed makes request to obtain permanent token to access data
    * if token is received two things happen
    * 1. create a raaspi site xxx.raaspi.com(mimic registration) where xxx is shopname.if xxx taken make it xxxn
    * 2. save token in client as secret and shop url as rinraddr
    * at end redirect to xxx.raaspi.com which has a new menu sync data under start here if rinraddr is not null/isEmpty
    * @param args-option 1 shop url to identify shop
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * prod/raaspiB ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=3374f2430c2d99bba31ecb254488bff4 &amp;scope=read_products &amp;redirect_uri=https://raasBackOffice.raaspi.com/shopifyBackOffice.wflow &amp;state=001 &amp;grant_options[]= ";
    * test/local   ret="https://"+shopUrl+"/admin/oauth/authorize?client_id=2fdeaac312b8eb595c94b855176f18ea &amp;scope=read_products &amp;redirect_uri=http://raasBackOffice.lraaspi.com:8080/shoauthverify.wflow &amp;state=001 &amp;grant_options[]= ";
    * prefix--api key-------------------------:pw------------------------------@shopName-------------------/restPath
    */

     public String shoauthverify(){
      // not used any more, logic is part of installorauth method
      facesContext = FacesContext.getCurrentInstance();
      if(facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       externalContext = facesContext.getExternalContext();

       //                 requestH = (HttpServletRequest) externalContext.getRequest();
      }

/*
                if(requestH != null && requestH.getParameter("code") !=null){
                 code=requestH.getParameter("code");
                 hmac=requestH.getParameter("hmac");
                 shop=requestH.getParameter("shop");
                 state=requestH.getParameter("state");
                 time=requestH.getParameter("timestamp");
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("invoked")+" code "+code);
                }else{
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("invoked")+" null requestH ");
                 return "";
                }
*/
                // if not authorized/installed will go to shopify install page first but always will redirect with hmac info
                // first time ie client does not exist,create a client records with owner2 as shopurl ie as if a new site registration
                //
                // change redirect to include xxx/shoauthverify and add a hook in pages.xml to invoke method for /shoauthverify
                // after verify it should send req for oauth token and save it in client

                String secret = "3eb9710290fcaeb70d8ecd41f02e6bcc";
                try {
                 String message = "code="+code+"&shop="+shop+"&state="+state+"&timestamp="+time;

                 Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
                 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
                 sha256_HMAC.init(secret_key);
                 byte[] mac_data=sha256_HMAC.doFinal(message.getBytes());
                 String rat=Hex.encodeHexString(mac_data);

                 String hash = Base64.encodeBase64String(mac_data);
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("hash")+" "+rat,""));

                }
                catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("authVerify")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                }
                //
                try{
                 String ret="https://"+shop+"/admin/oauth/access_token";
		 ClientRequest request = new ClientRequest(ret);
                 request.accept(MediaType.APPLICATION_JSON);
                 //escape quotes, can also use request.getFormParameters instead of Json
                 // this method gets invoked by call back from installOrAuthorize, so client record should be in session
                 //test whether client_id holds value or we need to read client record
                 /*
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("key")+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                 */

               //String input = "{\"client_id\":\"2fdeaac312b8eb595c94b855176f18ea\",\"client_secret\":\"3eb9710290fcaeb70d8ecd41f02e6bcc\",\"code\":\""+code+"\"}";
                 String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"code\":\""+code+"\"}";
                 // add logic with a flag to add refresh_token along with id,secret and code if partnrer secret has changed
                 // refresh token will tell shopify to allow new token value for existing customers with old token
                 // needs testing
                 request.body(MediaType.APPLICATION_JSON,input);
		 ClientResponse<String> response = request.post(String.class);
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+response);
                   pp90="";
                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject  jobject = jelement.getAsJsonObject();
                 if(jobject.getAsJsonPrimitive("access_token") == null){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("accesstoken")+" "+bundle.getString("already")+" "+bundle.getString("exists"),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("goto")+" "+redirect_uri+" "+bundle.getString("and")+" "+bundle.getString("click")+" "+" "+bundle.getString("sync")+" "+bundle.getString("data"),""));


                 }else{
                  access_token = jobject.getAsJsonPrimitive("access_token").getAsString();
                 }
                 log.severe(bundle.getString("access")+" "+bundle.getString("token")+" "+access_token);

                 //create raaspi site for this merchant/shop and store this access-token as secret
                 // no need for this method or connectorAuthorize unless the scope needs to be changed for this merchant
                 // from now raaspi site of this merchant will be used to sync data and use as backoffice
                 pp90="";
                 //shop is xxx.myshopify.com
                 String enterprisecompcode=this.shop;
                 String urlName=this.shop;
                 if(urlName.contains(".myshopify.com")){
                  urlIndex=urlName.lastIndexOf(".myshopify.com");
                 }
                 if (urlIndex == -1){
                  urlIndex=urlName.lastIndexOf(".");
                  if (urlIndex == -1){
                   urlIndex=urlName.length();
                  }
                 }

                 if (urlName.contains("www.")){
                  owner2CodeClient=urlName.substring(4,urlIndex);
                 }else{
                  owner2CodeClient=urlName.substring(0,urlIndex);
                 }
                 //if scope changes then access-token changes?? then need to update client records
                 serverName=requestH.getServerName();
                 doQuickRegister();
                 if(serverName.contains("raaspi.com")){
                  ret="https://"+owner2CodeClient+".raaspi.com/home.wflow"  ;
                 }else{
                  ret="http://"+owner2CodeClient+".lraaspi.com:8080/home.wflow"  ;
                 }

                 externalContext.redirect(ret);
                 return pp90;
                }
                catch (Exception e){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,bundle.getString("authorization")+" / "+bundle.getString("access")+" "+bundle.getString("token")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                 return "";
                }

         }

         public String processWebhook(BufferedReader body){
                // since this is push from shopify, needs ngrok to find a local ip
                // instead of api calls from raaspi, webhook pushes changes with data to raaspi ex order placed, account posting
                // like shopify, sendgrid also has webhooks for email processing results
                // if not authorized/installed will go to shopify install page first but always will redirect with hmac info
                // first time ie client does not exist,create a client records with owner2 as shopurl ie as if a new site registration
                //
                // change redirect to include xxx/installApp and add a viewAction in installApp.xhtml to invoke method for /shoauthverify
                // after verify it should send req for oauth token and save it in client
                pp90="";
                try{
                 JsonElement jelement = new JsonParser().parse(body);
                 JsonObject  jobject = jelement.getAsJsonObject();

                 JsonArray jarray = jobject.getAsJsonArray();
                 //Gson gson = new Gson();
                 //cannot update model to use @serialized tag in reveng.xml, so use customdeserialize
                 //Fpxxfq1a5xwwqqhxxxxxitem userObject = gson.fromJson(jarray.get(0).toString(), Fpxxfq1a5xwwqqhxxxxxitem.class);
                 GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingStrategy(new CustomStrategy());
                 //gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampDeserializer());
                 Gson gson = gsonBuilder.create();
                 Fpxxfq1a5xwwqqhxxxxxitem[] items = gson.fromJson(jarray.toString(), Fpxxfq1a5xwwqqhxxxxxitem[].class);
                 for (Fpxxfq1a5xwwqqhxxxxxitem item : items){
                   pp90="";
                   // getinstance
                   //item.setZzzxxu2oxxhxxxxxxxxxxowner2("raasppiShopify.myShopify.com");
                 }

                 //parse into a tree called element which can have object {},array [] or primitive "jay", 6.0 or null
                 // {"products":[{"id":56,template_suffix:null,tags:"","variants":[{"id":99,..,"price":"45.00",..}]
                 // .. ]}
                 // objects have curly braces and has key and value pair, array is used to group the objects
                 pp90="";
                }
                catch (Exception e){
                 //FacesMessages.instance().add("#{messages['error']} "+e);
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

                }


          return "";
         }

         public String processSgWebhook(){
                // since this is push from sendgrid, needs ngrok to find a local ip
                // instead of api calls from raaspi, webhook pushes changes with data to raaspi ex order placed, account posting
                // like sendgrid, shopify also has webhooks for shopping processing results
                // if not authorized/installed will go to shopify install page first but always will redirect with hmac info
                // first time ie client does not exist,create a client records with owner2 as shopurl ie as if a new site registration
                //
                // change redirect to include xxx/shoauthverify and add a hook via viewaction in xx.xhtml to invoke method for /shoauthverify
                // after verify it should send req for oauth token and save it in client
                 String ret="https://raaspi//webhook/sg";
         	try {
		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 //request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);

                }
                catch (Exception e){
                 //FacesMessages.instance().add("#{messages['error']} "+e);
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(),""));

                }


          return "";
         }

     public boolean isBitSet(Integer a, Integer n){
      if (a == null){
       a=0;
      }
      return (a & (1 << n)) != 0;
     }

    @Transactional
    //called by installorAuth ie shopify install from shopify app
    // There is logic here to compare the token sent by shopify (it can change if merchant changes scope or uninstall
    // the app and then install again) and if differs stores the new token value in client record 02 column apiclientsecret
    // So there is no separate method to create/store a new token value, just uninstall and reinstall
    // data at raaspi end stays the same
    //@see doRegister in userHomefor createSite under master site, doMastersite for creating master site in userHome
    
    public void doQuickRegister() {

            Yxxxch522xhhxxhxxxxxclient client01=null;
            bcontinue=true;
            clientExists=false;
            boolean clientRec02Exists=false;
            String  oldToken=null;
            // first create the image and text data to be used by the new site,blobdataHome copydefaultsToUser handles both
            if(email==null || email.isEmpty()){
               email="support@3rcomputer.com";//can be used to forward to real address
            }

         try {
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zexxzzfxhhxxxxxxxxxxstatusfl != :mclosed and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01").setParameter("mclosed",mclosed)
					.setParameter("owner2", owner2CodeClient)
					.getSingleResult();
		      if (client != null) {
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("website")+" "+bundle.getString("name")+" / "+bundle.getString("url")+" "+bundle.getString("prefix")+", "+bundle.getString("already")+" "+bundle.getString("exists") ,""));
                       //bcontinue=false; can happen if scope is being changed or did not complete last time
                       clientExists=true;
                       clientFullUrlName=client.getD6xxuxxrbvxxxxxxxxxxintaddr();

                       //return;
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("continuing") ,""));

                     }
         } catch (Exception ignore) {
          //
         }

         //may be no shopify client records yet, used getKeyToEntity later


         try {
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
		  .createQuery(
		  "select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zexxzzfxhhxxxxxxxxxxstatusfl != :mclosed and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","02").setParameter("mclosed",mclosed)
			.setParameter("owner2", owner2CodeClient)
			.getSingleResult();
                      if (client != null) {
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("access")+" "+bundle.getString("token")+" "+bundle.getString("also")+" "+bundle.getString("exists") ,""));
                       //bcontinue=false; can happen if scope or email was changed or did not complete last time
                       clientRec02Exists=true;
                       oldToken=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       if(!access_token.equals(oldToken)){
                        //update record02
                        yxxxch522xhhxxhxxxxxclientHome.clearInstance();
                        client.setDbxxuzxdssxxxxxxxxxxapiclientsecret(access_token.trim());
                        client.setB2xxuzcxbvxxxxxxxxxxenterprisecompanyna(this.shop);
                        client.setB2xxuzcxbvxxxxxxxxxxenterprisecompanyna(this.shop);
                        client.setD4xxhxxrbv24xxxxxxxximailaddr(email);
                        yxxxch522xhhxxhxxxxxclientHome.setInstance(client);
                        yxxxch522xhhxxhxxxxxclientHome.allowUpdate();
                       }
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("continuing") ,""));

                     }
         } catch (Exception ignore) {
           //
         }
         try{
            String clientName=this.shop;
            String savedActivationKey=null;
            //enterprisecompcode is same as website name, owner2Code now refers to new client as owner2 not where installApp button exists
            //if(enterprisecompcode.length() > this.clientFullUrlName.length()){
             //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             //                        FacesMessage.SEVERITY_ERROR,bundle.getString("prefix")+" "+bundle.getString("part")+" "+enterprisecompcode+" "+bundle.getString("exceeds")+" "+bundle.getString("url")+" "+this.clientFullUrlName ,""));

              //return;
            //}
            //skip creating client/users etc if already exists
          if(!clientExists){
             // 6 paramters, last param ie usage/prodcode applicationFunction is used to set if empty
             //createClientRegister will then use the value from here
             //since shopify addons cannot be subscribed via raaspi (only via shopify) no need to put value in product variable
             // need to support free trial
             //themeName was saved in global themeName
             yxxxuq1n1xwwqqqxxxxxblobdataHome.copyDefaultsToUSER("v",this.themeName,owner2CodeClient,clientName,this.email,"eest");

             //create user instance
             yxxxuh566xwwqqwxxxxxuserHome.createInstance();
             yxxxuh566xwwqqwxxxxxuser=yxxxuh566xwwqqwxxxxxuserHome.getInstance();
             yxxxuh566xwwqqwxxxxxuser.setZ1xxzzfxhhxxxxxxxxxxstatusfl(mactive);
             yxxxuh566xwwqqwxxxxxuser.setC7xxfxxxivxxxxxxxxxxtemporarypassword(true);
             yxxxuh566xwwqqwxxxxxuserHome.setClientEmail(email);
             String clientUrl=null;
             if(serverName.contains("raaspi.com")){
                  clientUrl=owner2CodeClient+".raaspi.com"  ;
                 }else{
                  clientUrl=owner2CodeClient+".lraaspi.com"  ;
             }

             yxxxuh566xwwqqwxxxxxuserHome.setClientFullUrlName(clientUrl);//D6xxuxxrbvxxxxxxxxxxintaddr

             if (smtpEnabled) {
                yxxxuh566xwwqqwxxxxxuser.setZ1xxzzfxhhxxxxxxxxxxstatusfl(mpartial);
                yxxxuh566xwwqqwxxxxxuser.setA0xxukuxbvxxxxxxxxxxid("admin");
                //in future look into whether to bypass activation
                savedActivationKey=yxxxuh566xwwqqwxxxxxuserHome.getMD5Hash(yxxxuh566xwwqqwxxxxxuser.getA0xxukuxbvxxxxxxxxxxid() + clientName + email + System.currentTimeMillis());
                yxxxuh566xwwqqwxxxxxuser.setC9xxuxxxbvxxxxxxxxxxactivationkey(savedActivationKey);
                //this.instance.setC9xxuxxxbvxxxxxxxxxxactivationkey("shopify");
             } else {
                // TODO: Fix for production ... No way to activate using email
                // if SMTP is not enabled ...
                System.out.println("WARNING!!! SMTP eMailer not enabled ... partially activating user without email activation.");
                yxxxuh566xwwqqwxxxxxuser.setZ1xxzzfxhhxxxxxxxxxxstatusfl(mpartial);
             }
             savedPassword=PasswordSupport.tempPassword();
             yxxxuh566xwwqqwxxxxxuser.setC6xxuxuoivxxxxxxxxxxoldpw(savedPassword);
  	     yxxxuh566xwwqqwxxxxxuser.setC4xxuxupivxxxxxxxxxxcurrpw(PasswordSupport.hash(savedPassword));
	     yxxxuh566xwwqqwxxxxxuser.setC8xxuxxxbvxxxxxxxxxxpasswordhash(PasswordSupport.getHashNoon() );
	     yxxxuh566xwwqqwxxxxxuser.setZ2xxcztxlxxxxxxxxxxxstatusfldt(calendar.getTime());
             calendare.add(Calendar.HOUR, 48);
             yxxxuh566xwwqqwxxxxxuser.setC5xxcxxxbvxxxxxxxxxxexpiry(calendare.getTime() );
	     yxxxuh566xwwqqwxxxxxuser.setC2xxuxuaiv38xxxxxxxxalevel("I");
	     yxxxuh566xwwqqwxxxxxuser.setC3xxuxubiv39xxxxxxxxblevel("H");
             calendare.add(Calendar.HOUR, 24);
             yxxxuh566xwwqqwxxxxxuser.setC5xxcxxxbvxxxxxxxxxxexpiry(calendare.getTime() );
             yxxxuh566xwwqqwxxxxxuser.setC1xxuxxxbvxxxxxxxxxxotherid(email);

             inRegistrationAndCreateUser=true;
             yxxxuh566xwwqqwxxxxxuserHome.setInRegistrationAndCreateUser(true);

             yxxxuh566xwwqqwxxxxxuser.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeClient);
             // in 2nd user persist a new client will also be created with owner2 set as owner2CodeClient and enterprisecompcode set to enterprisecompcode .
             // also account,acintgr,acperiod will be cloned from 3rcomp owner2 to new account owner2
             subKey="admin";
             yxxxuh566xwwqqwxxxxxuserHome.setSubKey("admin");
             yxxxuh566xwwqqwxxxxxuserHome.persist(owner2CodeClient); // call persist with overdrive so that owner2Code has new site name, not the myflow name
             // during persist client will be created by createClientRegister because inRegistrationAndCreateUser
             yxxxuh566xwwqqwxxxxxuserHome.setClientApplicationFunction("eege");// set client prodcod
            // admin & client just persisted,now persist backoffice manager user id2
            yxxxuh566xwwqqwxxxxxuserHome.clearInstance();
            yxxxuh566xwwqqwxxxxxuser=yxxxuh566xwwqqwxxxxxuserHome.getInstance();
            //cripple this as wee but avoid another activation key, both will activate using one key
            yxxxuh566xwwqqwxxxxxuser.setC1xxuxxxbvxxxxxxxxxxotherid(email);
            yxxxuh566xwwqqwxxxxxuser.setC7xxfxxxivxxxxxxxxxxtemporarypassword(true);
            yxxxuh566xwwqqwxxxxxuser.setC9xxuxxxbvxxxxxxxxxxactivationkey("nonNull");
            yxxxuh566xwwqqwxxxxxuser.setZ1xxzzfxhhxxxxxxxxxxstatusfl(mpartial);
            yxxxuh566xwwqqwxxxxxuser.setA0xxukuxbvxxxxxxxxxxid("manager");
            yxxxuh566xwwqqwxxxxxuser.setC4xxuxupivxxxxxxxxxxcurrpw(PasswordSupport.tempPassword());
            yxxxuh566xwwqqwxxxxxuser.setC6xxuxuoivxxxxxxxxxxoldpw(yxxxuh566xwwqqwxxxxxuser.getC4xxuxupivxxxxxxxxxxcurrpw());
            yxxxuh566xwwqqwxxxxxuser.setY7xxuxznbvxxxxxxxxxxnotes(savedPassword+"  and  "+yxxxuh566xwwqqwxxxxxuser.getC4xxuxupivxxxxxxxxxxcurrpw());
	    yxxxuh566xwwqqwxxxxxuser.setC4xxuxupivxxxxxxxxxxcurrpw(PasswordSupport.hash(yxxxuh566xwwqqwxxxxxuser.getC4xxuxupivxxxxxxxxxxcurrpw()));
	    yxxxuh566xwwqqwxxxxxuser.setC8xxuxxxbvxxxxxxxxxxpasswordhash(PasswordSupport.getHashNoon() );
            // calendar gets altered in clientregister ie 3 months added for trial end
	    yxxxuh566xwwqqwxxxxxuser.setZ2xxcztxlxxxxxxxxxxxstatusfldt(Calendar.getInstance().getTime());
            calendare.add(Calendar.HOUR, 48);
            yxxxuh566xwwqqwxxxxxuser.setC5xxcxxxbvxxxxxxxxxxexpiry(calendare.getTime() );
	    yxxxuh566xwwqqwxxxxxuser.setC2xxuxuaiv38xxxxxxxxalevel("U");
	    yxxxuh566xwwqqwxxxxxuser.setC3xxuxubiv39xxxxxxxxblevel("H");
            calendare.add(Calendar.HOUR, 24);
            yxxxuh566xwwqqwxxxxxuser.setC5xxcxxxbvxxxxxxxxxxexpiry(calendare.getTime() );
            inRegistrationAndCreateUser=true;
            yxxxuh566xwwqqwxxxxxuser.setZzxxu2oxxhxxxxxxxxxxowner2(owner2CodeClient);
            // in following user persist a new client will also be created with owner2 set as owner2CodeClient and enterprisecompcode set to enterprisecompcode .
            // also account,acintgr,acperiod will be cloned from 3rcomp owner2 to new account owner2
            //may072018 either add setter in userhome for inregistrationxxx,subKey or call doregisterfrom which sets these values
            subKey="manager";
            yxxxuh566xwwqqwxxxxxuserHome.setSubKey("manager");
            yxxxuh566xwwqqwxxxxxuserHome.persist(owner2CodeClient);
            //not sure whether we can access client 01 by userHome.getClient.. using keytoEntity for now

            if (smtpEnabled) {
                try {
                   // will be addressed to admin using manager record (passwords and email are saved in both)
		   log.severe("in case clob not saved,debug code "+"/"+owner2CodeClient+","+yxxxuh566xwwqqwxxxxxuser.getY7xxuxznbvxxxxxxxxxxnotes()+" xx:"+savedActivationKey);//continue, user need not know

                   yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/getactivation.xhtml"," to you- "+email);
                } catch (Exception zzz) {
                    log.severe("#{messages['getting_activation_email_send_failed']}"+ zzz.getMessage());

                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,bundle.getString("email")+" "+bundle.getString("send")+" "+bundle.getString("failed")+", "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("resent")+" "+bundle.getString("later"),""));

                }

                try {
                   // send another email to support group for their actions
                   yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/activationSetup.xhtml"," to our support team for their actions");
                } catch (Exception zzz) {
                    log.severe("#{messages['activation_setup_email_send_failed']}"+ zzz);

                }


             }
             ////??may062018yxxxuh566xwwqqwxxxxxuserHome.registrationScreenName = null;
             //may072018 add creating record 02 and put shopify access_token in secret, record 02 can be used for paypal
                 try{
                  //create client instance and persist key 02 (key 01 already created by userhome but no copy here)
                  yxxxch522xhhxxhxxxxxclientHome.createInstance();
                  client=yxxxch522xhhxxhxxxxxclientHome.getInstance();
                  client.setA0xxukxxbvxxxxxxxxxxclientversion("02");
                  client.setDbxxuzxdssxxxxxxxxxxapiclientsecret(access_token.trim());
                  client.setB2xxuzcxbvxxxxxxxxxxenterprisecompanyna(clientName);
                  client.setB3xxuxzsbvxxxxxxxxxxdescript("shopify access record- "+clientName);

                  yxxxch522xhhxxhxxxxxclientHome.setInstance(client);
                  yxxxch522xhhxxhxxxxxclientHome.persist();
                  // automate openshift router create. openAuthorize method here is also called by doRegister
                  //in DoRegister it used to quit at this point and manual  process in sqladmin created route
                  // and then called eMailReadyToActivate which copyDefaultsToOwner2 and copyOptions and then sent email  .. 
                  // now openAuthorize (also called by doRegister) will automate create route and calling emailreadytoactivate
                  client01=yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("01",owner2CodeClient);
                  clientFullUrlName=client01.getD6xxuxxrbvxxxxxxxxxxintaddr();//clientUrl
                  if(clientFullUrlName == null || clientFullUrlName.isEmpty()){
                   clientFullUrlName=clientUrl;
                  }
                  if(hostingAt.equals("op")){
                   openAuthorize("r",client01);//record 01, suport should check and if needed create manually from dashboard
                  }
                  clientJustCreated=true;
                  //openAuthorize > userHome emailReadyToActivate > copyUsersdefault, copyOptions and then sends activate email
                  //raaspi dashboard should alert if it fails
                 }catch (Exception ex){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("token")+" "+bundle.getString("persist")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        //return ;

                 }


             yxxxuh566xwwqqwxxxxxuser = null; // do this last ... just to reset the register
         }//end of ifClientExists
        }catch (Exception ex){//9
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("backoffice")+" "+bundle.getString("site")+" "+bundle.getString("setup")+" "+bundle.getString("system")+" "+bundle.getString("error")+ex.getMessage(),""));
                        //return ;

        }



    }

    //in redeem.xhtml,if Coupon was redeemed but site create skipped, part2 calls this method to carry on dositecreate
    @Transactional
    public void callDoSiteCreate(String email,String siteName,String couponId) {
     Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer=jxxxuq201xwwqqhxxxxxcustomerList.getEmailCouponToEntity(email,couponId);
     if(jxxxuq201xwwqqhxxxxxcustomer==null){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Cannot")+" "+bundle.getString("find")+" "+bundle.getString("any")+" "+bundle.getString("coupon")+" "+bundle.getString("matching")+" "+bundle.getString("email")+" "+email+", "+" "+bundle.getString("coupon")+" "+couponId,""));
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Visit")+" "+bundle.getString("www.raaspi.com")+" "+bundle.getString("contactUs/faq")+" "+bundle.getString("section"),""));
      return;
     }
     //for a given coupon only an unique customer record. find a user by customer sid, the get userId from user     
     String fName=jxxxuq201xwwqqhxxxxxcustomer.getC2xxu2fnbvixxxxxxxxxfirstname();
     String lName=jxxxuq201xwwqqhxxxxxcustomer.getC1xxuslnbvixxxxxxxxxlastname();
     int customerSid=jxxxuq201xwwqqhxxxxxcustomer.getA0xxuobxbxxxxxxxxxxxsid();
     Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser= getUserByCustomerSid(customerSid);
     if(yxxxuh566xwwqqwxxxxxuser == null){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Cannot")+" "+bundle.getString("find")+" "+bundle.getString("any")+" "+bundle.getString("loginId")+" "+bundle.getString("matching")+" "+bundle.getString("email")+" "+email+", "+" "+bundle.getString("coupon")+" "+couponId,""));
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Visit")+" "+bundle.getString("www.raaspi.com")+" "+bundle.getString("contactUs/faq")+" "+bundle.getString("section"),""));
      return;
     }
     String userId=yxxxuh566xwwqqwxxxxxuser.getA0xxukuxbvxxxxxxxxxxid();//userId normally same as email but can be emailnn
     String password=yxxxuh566xwwqqwxxxxxuser.getC6xxuxuoivxxxxxxxxxxoldpw();// old pw not changed in raaspi . maager/admin still gets created in new site
     email=jxxxuq201xwwqqhxxxxxcustomer.getQ4xxhxxxbv24xxxxxxxximailaddr();//both user and customer has it
     siteName=siteName.trim();
     email=email.trim();
     couponId=couponId.trim();
     //validate coupon staus using ratetable
     yxxxuq591xwwqqhxxxxxrate1f=yxxxuq591xwwqqhxxxxxrate1fList.getRaaspiIncentiveToEntity("SC",couponId);
     if(yxxxuq591xwwqqhxxxxxrate1f==null){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Cannot")+" "+bundle.getString("find")+" "+bundle.getString("any")+" "+bundle.getString("loginId")+" "+bundle.getString("matching")+" "+bundle.getString("email")+" "+email+", "+" "+bundle.getString("coupon")+" "+couponId,""));
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Visit")+" "+bundle.getString("www.raaspi.com")+" "+bundle.getString("contactUs/faq")+" "+bundle.getString("section"),""));
      return;
     }
     int couponStatus = yxxxuq591xwwqqhxxxxxrate1f.getZ1xxzzfxhhxxxxxxxxxxstatusfl();
     if(couponStatus != 0){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Coupon")+" "+bundle.getString("invalid")+" "+bundle.getString("or")+" "+bundle.getString("already")+" "+bundle.getString("used")+", "+bundle.getString("coupon")+" "+couponId,""));
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("Visit")+" "+bundle.getString("www.raaspi.com")+" "+bundle.getString("contactUs/faq")+" "+bundle.getString("section"),""));
      return;

     }
     // in redeem siteName > userHome.setClientApplicationName, which has logic to check for extra suffix
     // like xxx.com or www.xxx.com. The logic removes extra stuff.
             
        if (siteName.trim().length() > 35 ) {// input length max 35 but extra protection
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("site")+" "+bundle.getString("name")+" "+bundle.getString("length")+" "+siteName.trim().length()+" > "+bundle.getString("35") ,""));

            return;
        }
     //following method adds .raaspi.com for url, also checks if site already exists or not. siteName is used as clientOwner2

     doSiteCreate(fName,lName,userId,password,email,siteName,couponId);     
    }



   public Yxxxuh566xwwqqwxxxxxuser getUserByCustomerSid(int customerSid){
          Yxxxuh566xwwqqwxxxxxuser user=null;
           String owner2Code=customIdentity.getMasterSiteCode();//user n customer were created in raaspi
          try{
 			user = (Yxxxuh566xwwqqwxxxxxuser) entityManager
 					.createQuery(
 							"select cc from  Yxxxuh566xwwqqwxxxxxuser cc where cc.jxxxuq201xwwqqhxxxxxcustomer.a0xxuobxbxxxxxxxxxxxsid = :customerSid and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 					.setParameter("customerSid", customerSid)
 					.setParameter("owner2", owner2Code)
 					.getSingleResult();
                        return user;
          } catch (Exception e) {
           log.severe("Error getting user record for callCreateSite"+ e);

          }
	  return null;
    }

    //called by redeem.xhtml part1 after coupon redeem and then pressing create App/website or by redeem part2 create webapp/site button >via above docallSiteCreate
    @Transactional
    public void doSiteCreate(String fName,String lName,String userId,String password, String email,String siteName,String couponId) {
            //7 params userId can be emailnn so diff from email, password null ie temp pw for manager,admin or value is user chosen
            couponName=couponId.trim();
            fName=fName.trim();
            lName=lName.trim();
            password=password.trim();
            owner2CodeClient=siteName;
            owner2CodeApp=siteName;
            Yxxxch522xhhxxhxxxxxclient client01=null;
            bcontinue=true;
            clientExists=false;
            boolean clientRec02Exists=false;
            String  oldToken=null;
            // first create the image and text data to be used by the new site,blobdataHome copydefaultsToUser handles both
            if(email==null || email.isEmpty()){
               email="support@3rcomputer.com";//can be used to forward to real address
            }

         try {
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zexxzzfxhhxxxxxxxxxxstatusfl != :mclosed and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","01").setParameter("mclosed",mclosed)
			.setParameter("owner2", owner2CodeClient)
			.getSingleResult();
		      if (client != null) {
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("website")+" "+bundle.getString("name")+" / "+bundle.getString("url")+" "+bundle.getString("prefix")+" "+siteName+" , "+bundle.getString("already")+" "+bundle.getString("exists") ,""));
                       bcontinue=false; //can happen if scope is being changed or did not complete last time
                       clientExists=true;
                       clientFullUrlName=client.getD6xxuxxrbvxxxxxxxxxxintaddr();

                       return;

                     }
         } catch (Exception ignore) {
         }

         try{
            String clientName=siteName;
            String savedActivationKey=null;
             //tbd populate themename based on product saved in customer record

             //String themeName="backofficeG 20201438302262";//hardcode
             String  themeName="Nature/Gene6.354-129272933";//hardcode Nature/Generic/erp for theme
             this.themeName=themeName;//save it in Global, this is session scoped
             //use couponCode to be unique
             Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer=jxxxuq201xwwqqhxxxxxcustomerList.getEmailCouponToEntity(email,couponName);
             if(jxxxuq201xwwqqhxxxxxcustomer ==null){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("No")+" "+bundle.getString("customer")+" "+bundle.getString("with")+" "+bundle.getString("email")+" "+email+" "+bundle.getString("found")+" "+bundle.getString("registered")+" "+bundle.getString("for")+" "+bundle.getString("coupon")+" "+couponName ,""));
              return;
             } 
             if(jxxxuq201xwwqqhxxxxxcustomer.getQ5xxuxxxbxxxxxxxxxxxrmailaddr() ==null
               || jxxxuq201xwwqqhxxxxxcustomer.getQ5xxuxxxbxxxxxxxxxxxrmailaddr().isEmpty()){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("No")+" "+bundle.getString("registered")+" "+bundle.getString("customer")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+bundle.getString("email")+" "+email+", "+bundle.getString("coupon")+" "+couponName ,""));
              return;
             } 
             String incentive=jxxxuq201xwwqqhxxxxxcustomer.getQ5xxuxxxbxxxxxxxxxxxrmailaddr();//holds coupon code
             // bypass 
             yxxxuq591xwwqqhxxxxxrate1f=yxxxuq591xwwqqhxxxxxrate1fList.getRaaspiIncentiveToEntity("SC",incentive);
             String sItemSid=yxxxuq591xwwqqhxxxxxrate1f.getB2xxuxxrbv51xxxxxxxxstepname();
             if(sItemSid.equals("S") && yxxxuq591xwwqqhxxxxxrate1f.getA0xxukxxbvxxxxxxxxxxusertype().equals("SC")){
              sItemSid="281";
              // causes persist yxxxuq591xwwqqhxxxxxrate1f.setB2xxuxxrbv51xxxxxxxxstepname(sItemSid);
             } 
             if(sItemSid ==null
               || sItemSid.isEmpty()){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("No")+" "+bundle.getString("registered")+" "+bundle.getString("product")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+bundle.getString("email")+" "+email+", "+bundle.getString("coupon")+" "+couponName ,""));
              return;
             } 
             int itemSid=0;//product sid 281
             try{// coupons type SC means stepName is item sid ie numeric, also temp bypass
              itemSid=Integer.parseInt(sItemSid);
             }catch (Exception e){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_ERROR,bundle.getString("Coupon")+ " "+couponId+" "+bundle.getString("access/stepName")+" "+bundle.getString("error"),""));
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_ERROR,bundle.getString("Please")+" "+bundle.getString("contact")+" "+bundle.getString("our")+" "+bundle.getString("support")+" "+bundle.getString("team")+", "+bundle.getString("if")+" "+bundle.getString("needed"),""));
              return ;
             }

             String from=yxxxuh566xwwqqwxxxxxuserHome.getFunctionGroupForItemSid(itemSid);
             if(from==null || from.isEmpty()){
              return;//message already given
             }
             //(1) copies default themes
             yxxxuh566xwwqqwxxxxxuserHome.setSiteUsingFromValue(from);//for from selection,sets theme name,application fn, trial period

             //above metod establishes product code using from and ratetable
             //above setSiteUsingFromValue calls this >yxxxuq1n1xwwqqqxxxxxblobdataHome.copyDefaultsToUSER("v",this.themeName,owner2CodeClient,clientName,this.email,"eest");
             //although in blobdata it calls copythemetouser,publishThemeTouser,backupThemetoUser

             //createEmployeeCustomerAddressSignup creates backOffice users alog with employee,address n customer for the user
             //for the new site
             //user who is creating the site
             yxxxuh566xwwqqwxxxxxuserHome.createEmployeeCustomerAddressSignup("coupon",fName,lName,email,siteName,userId);
             //params requestType demo,coupon,firstName space lastName or company name,email,raaspi or client site name,userId  

             //admin and create client record for new site
             yxxxuh566xwwqqwxxxxxuserHome.createEmployeeCustomerAddressSignup("coupon","admin","",email,siteName,userId);
             //params requestType demo,coupon,firstName space lastName or company name,email,raaspi or client site name 

             yxxxuh566xwwqqwxxxxxuserHome.createClientRecord01(siteName,email,couponName);//creates client 01 record for client
             //make sure methods or the class has @transactional other wise jpa errors. period 365 days hardcoded tbd use rate
 
             //manager and create visitstat record in usageby table and xml base sitemap in clobdata to be modified
             yxxxuh566xwwqqwxxxxxuserHome.createEmployeeCustomerAddressSignup("coupon","manager","",email,siteName,userId);
             //params requestType demo,coupon,firstName space lastName or company name,email,raaspi or client site name 
             yxxxuh566xwwqqwxxxxxuserHome.createClientVisitNSiteMap(siteName);//creates client 01 record for client

             

             String clientfullUrlName=siteName+"raaspi.com";
             //Although activation not needed since already verified, but gives extra protection since verification 
             // is now done twice. Plus it gives a chance to create options etc plus existing flow can be used 

            // future yxxxuh566xwwqqwxxxxxuserHome.sendUserActivationEmail(String clientfullUrlName,String clientName,String clientEMail){
            if (smtpEnabled) {
                try {
                   // will be addressed to admin using manager record (passwords in manager notes and email are saved in both)
		   //log.severe("in case clob not saved,debug code "+"/"+owner2CodeClient+","+yxxxuh566xwwqqwxxxxxuser.getY7xxuxznbvxxxxxxxxxxnotes()+" xx:"+savedActivationKey);//continue, user need not know
                   //following expects to: address in userHome.instance.otherId

                   yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/getactivation.xhtml"," to you- "+email);
                } catch (Exception zzz) {
                    log.severe("#{messages['getting_activation_email_send_failed']}"+ zzz.getMessage());

                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,bundle.getString("email")+" "+bundle.getString("send")+" "+bundle.getString("failed")+", "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("resent")+" "+bundle.getString("later"),""));

                }

                try {
                   // send another email to support group for their actions
                   yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/activationSetup.xhtml"," to our support team for their actions");
                } catch (Exception zzz) {
                    log.severe("#{messages['activation_setup_email_send_failed']}"+ zzz);

                }


             }
             //activation will invoke (2,3,4 ie copy default values for account,rate etc and options)

             //parameters String clientfullUrlName,String clientName,String clientEMail
             yxxxuh566xwwqqwxxxxxuser = null; // do this last ... just to reset the register

          facesContext = FacesContext.getCurrentInstance();
          if(facesContext !=null){
           bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
           externalContext = facesContext.getExternalContext();
           requestH = (HttpServletRequest) externalContext.getRequest();
           serverName=requestH.getServerName();
          }else{
          }

                  // automate openshift router create. openAuthorize method here is also called by doRegister
                  //in DoRegister it used to quit at this point and manual  process in sqladmin created route
                  // and then called eMailReadyToActivate which copyDefaultsToOwner2 and copyOptions and then sent email  .. 
                  // now openAuthorize (also called by doRegister) will automate create route and calling emailreadytoactivate
                  client01=yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("01",owner2CodeClient);
                  String clientUrl=null;
                  if(serverName.contains("raaspi.com")){
                   clientUrl=owner2CodeClient+".raaspi.com"  ;
                  }else{
                   clientUrl=owner2CodeClient+".lraaspi.com"  ;
                  }
                  clientFullUrlName=client01.getD6xxuxxrbvxxxxxxxxxxintaddr();//clientUrl
                  if(clientFullUrlName == null || clientFullUrlName.isEmpty()){
                   clientFullUrlName=clientUrl;
                  }
                  //following ist parameter is not used, for now it will create new router entry in openshift
                  //then calls yxxxuh566xwwqqwxxxxxuserHome.copyDefaultsToOwner2(owner2CodeApp), creates initial entries
                  //yxxxuh566xwwqqwxxxxxuserHome.copyOptionsDefaultsToOwner2(owner2CodeApp), create default options
                  //yxxxuh566xwwqqwxxxxxuserHome.copy2OptionsDefaultsToOwner2(owner2CodeApp), more option rows
                  //yxxxuh566xwwqqwxxxxxuserHome.eMailReadyToActivate(newClient);
                  if(hostingAt.equals("op")){
                   openAuthorize("r",client01);//record 01, suport should check and if needed create manually from dashboard
                  }
                  clientJustCreated=true;

        }catch (Exception ex){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("backoffice")+" "+bundle.getString("site")+" "+bundle.getString("setup")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
           return ;

        }



    }

    //called by quicksite.xhtml to create site with base theme
    //authenticator redirects to quicksite.xhtml if no tables exists or if tables exist but no client record exists 
    //may be used as a choice in addition to free trial
    @Transactional
    public void doQuickSiteCreate(String fName,String lName,String userId,String password, String email,String siteName,String couponId) {
            //7 params userId can be emailnn so diff from email, password null ie temp pw for manager,admin or value is user chosen
            couponName=couponId.trim();
            fName=fName.trim();
            lName=lName.trim();
            password=password.trim();
            owner2CodeClient=siteName;
            owner2CodeApp=siteName;
            Yxxxch522xhhxxhxxxxxclient client01=null;
            bcontinue=true;
            clientExists=false;
            boolean clientRec02Exists=false;
            String  oldToken=null;
            // first create the image and text data to be used by the new site,blobdataHome copydefaultsToUser handles both
            if(email==null || email.isEmpty()){
               email="support@3rcomputer.com";//can be used to forward to real address
            }

         try {
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zexxzzfxhhxxxxxxxxxxstatusfl != :mclosed and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","01").setParameter("mclosed",mclosed)
			.setParameter("owner2", owner2CodeClient)
			.getSingleResult();
		      if (client != null) {
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("website")+" "+bundle.getString("name")+" / "+bundle.getString("url")+" "+bundle.getString("prefix")+" "+siteName+" , "+bundle.getString("already")+" "+bundle.getString("exists") ,""));
                       bcontinue=false; //can happen if scope is being changed or did not complete last time
                       clientExists=true;
                       clientFullUrlName=client.getD6xxuxxrbvxxxxxxxxxxintaddr();

                       return;

                     }
         } catch (Exception ignore) {
         }

         try{
            String clientName=siteName;
            String savedActivationKey=null;
             //tbd populate themename based on product saved in customer record

             //String themeName="backofficeG 20201438302262";//hardcode
             String  themeName="Nature/Gene6.354-129272933";//hardcode Nature/Generic/erp for theme
             this.themeName=themeName;//save it in Global, this is session scoped
             //use couponCode to be unique
             Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer=jxxxuq201xwwqqhxxxxxcustomerList.getEmailCouponToEntity(email,couponName);
             if(jxxxuq201xwwqqhxxxxxcustomer ==null){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("No")+" "+bundle.getString("customer")+" "+bundle.getString("with")+" "+bundle.getString("email")+" "+email+" "+bundle.getString("found")+" "+bundle.getString("registered")+" "+bundle.getString("for")+" "+bundle.getString("coupon")+" "+couponName ,""));
              return;
             } 
             if(jxxxuq201xwwqqhxxxxxcustomer.getQ5xxuxxxbxxxxxxxxxxxrmailaddr() ==null
               || jxxxuq201xwwqqhxxxxxcustomer.getQ5xxuxxxbxxxxxxxxxxxrmailaddr().isEmpty()){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("No")+" "+bundle.getString("registered")+" "+bundle.getString("customer")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+bundle.getString("email")+" "+email+", "+bundle.getString("coupon")+" "+couponName ,""));
              return;
             } 
             String incentive=jxxxuq201xwwqqhxxxxxcustomer.getQ5xxuxxxbxxxxxxxxxxxrmailaddr();//holds coupon code
             // bypass 
             yxxxuq591xwwqqhxxxxxrate1f=yxxxuq591xwwqqhxxxxxrate1fList.getRaaspiIncentiveToEntity("SC",incentive);
             String sItemSid=yxxxuq591xwwqqhxxxxxrate1f.getB2xxuxxrbv51xxxxxxxxstepname();
             if(sItemSid.equals("S") && yxxxuq591xwwqqhxxxxxrate1f.getA0xxukxxbvxxxxxxxxxxusertype().equals("SC")){
              sItemSid="281";
              // causes persist yxxxuq591xwwqqhxxxxxrate1f.setB2xxuxxrbv51xxxxxxxxstepname(sItemSid);
             } 
             if(sItemSid ==null
               || sItemSid.isEmpty()){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("No")+" "+bundle.getString("registered")+" "+bundle.getString("product")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+bundle.getString("email")+" "+email+", "+bundle.getString("coupon")+" "+couponName ,""));
              return;
             } 
             int itemSid=0;//product sid 281
             try{// coupons type SC means stepName is item sid ie numeric, also temp bypass
              itemSid=Integer.parseInt(sItemSid);
             }catch (Exception e){
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_ERROR,bundle.getString("Coupon")+ " "+couponId+" "+bundle.getString("access/stepName")+" "+bundle.getString("error"),""));
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_ERROR,bundle.getString("Please")+" "+bundle.getString("contact")+" "+bundle.getString("our")+" "+bundle.getString("support")+" "+bundle.getString("team")+", "+bundle.getString("if")+" "+bundle.getString("needed"),""));
              return ;
             }

             String from=yxxxuh566xwwqqwxxxxxuserHome.getFunctionGroupForItemSid(itemSid);
             if(from==null || from.isEmpty()){
              return;//message already given
             }
             yxxxuh566xwwqqwxxxxxuserHome.setSiteUsingFromValue(from);//for from selection,sets theme name,application fn, trial period

             //above metod establishes product code usimg from and ratetable
             //above setSiteUsingFromValue calls this >yxxxuq1n1xwwqqqxxxxxblobdataHome.copyDefaultsToUSER("v",this.themeName,owner2CodeClient,clientName,this.email,"eest");
             //although in blobdata it calls copythemetouser,publishThemeTouser,backupThemetoUser

             //createEmployeeCustomerAddressSignup creates backOffice users alog with employee,address n customer for the user
             //for the new site
             //user who is creating the site
             yxxxuh566xwwqqwxxxxxuserHome.createEmployeeCustomerAddressSignup("coupon",fName,lName,email,siteName,userId);
             //params requestType demo,coupon,firstName space lastName or company name,email,raaspi or client site name,userId  

             //admin and create client record for new site
             yxxxuh566xwwqqwxxxxxuserHome.createEmployeeCustomerAddressSignup("coupon","admin","",email,siteName,userId);
             //params requestType demo,coupon,firstName space lastName or company name,email,raaspi or client site name 

             yxxxuh566xwwqqwxxxxxuserHome.createClientRecord01(siteName,email,couponName);//creates client 01 record for client
             //make sure methods or the class has @transactional other wise jpa errors. period 365 days hardcoded tbd use rate
 
             //manager and create visitstat record in usageby table and xml base sitemap in clobdata to be modified
             yxxxuh566xwwqqwxxxxxuserHome.createEmployeeCustomerAddressSignup("coupon","manager","",email,siteName,userId);
             //params requestType demo,coupon,firstName space lastName or company name,email,raaspi or client site name 
             yxxxuh566xwwqqwxxxxxuserHome.createClientVisitNSiteMap(siteName);//creates client 01 record for client

             

             String clientfullUrlName=siteName+"raaspi.com";
             //Although activation not needed since already verified, but gives extra protection since verification 
             // is now done twice. Plus it gives a chance to create options etc plus existing flow can be used 

            // future yxxxuh566xwwqqwxxxxxuserHome.sendUserActivationEmail(String clientfullUrlName,String clientName,String clientEMail){
            if (smtpEnabled) {
                try {
                   // will be addressed to admin using manager record (passwords in manager notes and email are saved in both)
		   //log.severe("in case clob not saved,debug code "+"/"+owner2CodeClient+","+yxxxuh566xwwqqwxxxxxuser.getY7xxuxznbvxxxxxxxxxxnotes()+" xx:"+savedActivationKey);//continue, user need not know
                   //following expects to: address in userHome.instance.otherId

                   yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/getactivation.xhtml"," to you- "+email);
                } catch (Exception zzz) {
                    log.severe("#{messages['getting_activation_email_send_failed']}"+ zzz.getMessage());

                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,bundle.getString("email")+" "+bundle.getString("send")+" "+bundle.getString("failed")+", "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("resent")+" "+bundle.getString("later"),""));

                }

                try {
                   // send another email to support group for their actions
                   yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/activationSetup.xhtml"," to our support team for their actions");
                } catch (Exception zzz) {
                    log.severe("#{messages['activation_setup_email_send_failed']}"+ zzz);

                }


             }

             //parameters String clientfullUrlName,String clientName,String clientEMail
             yxxxuh566xwwqqwxxxxxuser = null; // do this last ... just to reset the register

          facesContext = FacesContext.getCurrentInstance();
          if(facesContext !=null){
           bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
           externalContext = facesContext.getExternalContext();
           requestH = (HttpServletRequest) externalContext.getRequest();
           serverName=requestH.getServerName();
          }else{
          }

                  // automate openshift router create. openAuthorize method here is also called by doRegister
                  //in DoRegister it used to quit at this point and manual  process in sqladmin created route
                  // and then called eMailReadyToActivate which copyDefaultsToOwner2 and copyOptions and then sent email  .. 
                  // now openAuthorize (also called by doRegister) will automate create route and calling emailreadytoactivate
                  client01=yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("01",owner2CodeClient);
                  String clientUrl=null;
                  if(serverName.contains("raaspi.com")){
                   clientUrl=owner2CodeClient+".raaspi.com"  ;
                  }else{
                   clientUrl=owner2CodeClient+".lraaspi.com"  ;
                  }
                  clientFullUrlName=client01.getD6xxuxxrbvxxxxxxxxxxintaddr();//clientUrl
                  if(clientFullUrlName == null || clientFullUrlName.isEmpty()){
                   clientFullUrlName=clientUrl;
                  }
                  //following ist parameter is not used, for now it will create new router entry in openshift
                  //then calls yxxxuh566xwwqqwxxxxxuserHome.copyDefaultsToOwner2(owner2CodeApp), creates initial entries
                  //yxxxuh566xwwqqwxxxxxuserHome.copyOptionsDefaultsToOwner2(owner2CodeApp), create default options
                  //yxxxuh566xwwqqwxxxxxuserHome.copy2OptionsDefaultsToOwner2(owner2CodeApp), more option rows
                  //yxxxuh566xwwqqwxxxxxuserHome.eMailReadyToActivate(newClient);
                  if(hostingAt.equals("op")){
                   openAuthorize("r",client01);//record 01, suport should check and if needed create manually from dashboard
                  }
                  clientJustCreated=true;


        }catch (Exception ex){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("backoffice")+" "+bundle.getString("site")+" "+bundle.getString("setup")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
           return ;

        }



    }


    public String getItemCost(String shopUrl,String value){
               String ret="";
               try{
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"/admin/inventory_items/"+value+".json";
                 }else{
                  // mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"/admin/inventory_items/"+value+".json";
                 }

		 ClientRequest request = new ClientRequest(ret);
		 request = new ClientRequest(ret);
                 request.header("Accept",MediaType.APPLICATION_JSON);
                 request.header("Content-Type", MediaType.APPLICATION_JSON);
                 request.header("X-Shopify-Access-Token", access_token);
		 ClientResponse<String> response = request.get(String.class);
		 if (response.getStatus() != 200 && response.getStatus() != 303) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("invalid")+" "+bundle.getString("request")+" "+bundle.getString("to")+" "+bundle.getString("shopify")+", "+" "+bundle.getString("response")+" "+bundle.getString("received")+" "+response.getStatus(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("check")+" "+bundle.getString("store")+" "+bundle.getString("name")+" ex:mystore.myshopify.com",""));
                        return "0.00";

 		}
                String respString= response.getEntity(String.class);
                String cost="0.0";
                if(respString !=null){
                 JsonElement jelement = new JsonParser().parse(respString);
                 if(jelement !=null){
                  JsonObject jobject = jelement.getAsJsonObject();
                  JsonObject jcost = jobject.getAsJsonObject("inventory_item");//in shopify null means no inventory
                  if(jcost != null){
                   if(jcost.get("cost") !=null && !jcost.get("cost").isJsonNull() ){
                    cost=jcost.get("cost").getAsString();
                   }
                  }
                 }
                }
                return cost;
               }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("itemCost")+"/ "+contxt+" "+bundle.getString("get")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        return "0.0" ;

               }


    }

  public Yxxxch522xhhxxhxxxxxclient getClient(){
                if (client !=null && client.getZzxxu2oxxhxxxxxxxxxxowner2().equals(owner2Code)){
                 return client;
                }
                try{
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2CodeApp)
					.getSingleResult();
                  return client;
		} catch (Exception ex) {
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("no")+" "+bundle.getString("client")+", "+bundle.getString("record")+", "+bundle.getString("for")+" "+owner2CodeApp,""));

                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("site")+", "+bundle.getString("url")+", "+bundle.getString("spelling"),""));

			return null;
		}


  }
     //get shop related data from shopify
     public String getShopData(String clientOwner2){
      String strippedV="";
      String viewId="";
      ExternalContext extCtxt = null;
      HttpServletRequest httpreq = null;
      facesContext = FacesContext.getCurrentInstance();
      if(facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       externalContext = facesContext.getExternalContext();
      }
      //access_token either already saved in client or was cdreated earlier
                if(access_token==null){
                 try{
                  client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","02")
					.setParameter("owner2", clientOwner2)
					.getSingleResult();
		      if (client != null) {
		       //yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               //client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       //access_token is based on public app key/secret and a code which came from shopify store
                       // was saved in raaspi client record 2 and is mapped to a store and a public app
                       access_token=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       shopUrl=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna();

                      }
	         } catch (NoResultException ex) {
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("cannot")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token"),""));
                        return null;

                 }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("exception")+" "+bundle.getString("in")+" "+bundle.getString("find")+" "+bundle.getString("record")+" "+bundle.getString("for")+" "+bundle.getString("access")+" "+bundle.getString("token")+" "+ex.getMessage(),""));
                        return null;

                }
               }
               if(access_token==null){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("access")+" "+bundle.getString("token")+" "+bundle.getString("null"),""));
                        return null;

               }




            try{
                 String input ="";
                 String ret="https://raaspishopify.myshopify.com//admin/2019-04/shop.json";
                 if(urlName.contains("raaspi.com")){
                  ret="https://"+shopUrl+"/admin/api/2019-07/shop.json";
                 }else{
                  // in the browser,mannually change to http since shopify wont respond otherwise
                  ret="https://"+shopUrl+"/admin/api/2019-07/shop.json";
                 }
		  ClientRequest request = new ClientRequest(ret);
		  request = new ClientRequest(ret);
                  request.header("Accept",MediaType.APPLICATION_JSON);
                  request.header("Content-Type", MediaType.APPLICATION_JSON);
                  request.header("X-Shopify-Access-Token", access_token);
  		  ClientResponse<String> response = request.get(String.class);
                  log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+response);
                  chargeResponse= response.getEntity(String.class);

                 JsonElement jelement = new JsonParser().parse(chargeResponse);
                 JsonObject  jobject = jelement.getAsJsonObject();
                 //get object property value of name email within  object name shop
                 JsonObject jjobject = jobject.get("shop").getAsJsonObject();//shop start with { so it is json object
                 String jemail=jjobject.getAsJsonPrimitive("email").getAsString(); //get xxx not "xxx"
                 return jemail;
              }catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("merchant")+" "+shopUrl+" "+bundle.getString("shopdata")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                 return "";
              }

         }

    /**
    * Raaspi uses openshift Rest API to install new route as part of quickregister here
    * this method uses openshift service accunt named robot and its token stored in client record 08
    * if the secret is compromised then change the key, but also generate a refresh key so that old tokens will work
    * see openauthverify method below, refresh key will be valid for one hour only
    * @param args-option 1 oauth endpoint url 
    * @return String blank/none for now
    * @exception client record not found and http request/response error
    * @see
    * prod         ret="https://api.pro-us-east-1.openshift.com/oauth/authorize?client_id=openshift-challenging-client&code_challenge=tzxx2jL7e_0CATNlB40ypHOsIpou7r9F8Kcq9zrP2Hc&code_challenge_method=S256&redirect_uri=https%3A%2F%2Fapi.pro-us-east-1.openshift.com%2Foauth%2Ftoken%2Fimplicit&response_type=code
    * above endpoint obtained by using oc get routes --loglevel=9 and 
    * secret is very long (832ch), need to create a new or redefine field in client make it 1200chrs
    * prefix--api key-------------------------:pw------------------------------@endpoint-------------------/restPath
    */
    /*

    */

          //comes here once only, from local doQuickRegister method or regular doRegister ie after new site successfully created
          //we may also need a way to call this method manually from say raaspi dashboard  
          // Since we already created a long lasting service account token robot which is a bearer token as well
          // then last step is to call restAPI
          // API calls must be authenticated with an access/bearer token
          // a bearer token must be passed in as an HTTP Authorization header
          // POST /apis/route.openshift.io/v1/routes HTTP/1.1
          // Authorization: Bearer $TOKEN
          // Accept: application/json
          // Connection: close
          // Content-Type: application/json'
 
          // {
          // "kind": "Route",
          // "apiVersion": "route.openshift.io/v1",
          // ...
          //  }

          // At very end redirect to ???
//{"kind":"Status","apiVersion":"v1","metadata":{},"status":"Failure","message":"routes HTTP.route.openshift.io \"1.1\" is forbidden: User \"system:serviceaccount:raaspi:robot\" cannot create routes HTTP.route.openshift.io at the cluster scope: no RBAC policy matched","reason":"Forbidden","details":{"name":"1.1","group":"route.openshift.io","kind":"routes HTTP"},"code":403}
//       add api for oc delete route kaitoys.raaspi.com , use loglevel 9 to see the api calls  

         public String openAuthorize(String type, Yxxxch522xhhxxhxxxxxclient newClient){
          //newClient is record 01 emailreadytoactivate below needs 01, type not used 
          Boolean debug=false;
          clientFullUrlName=newClient.getD6xxuxxrbvxxxxxxxxxxintaddr();
          owner2CodeApp=newClient.getZzxxu2oxxhxxxxxxxxxxowner2();
          owner2CodeClient=owner2CodeApp;
          String ret="";
          String secret="";
          shopUrl="api.pro-us-east-1.openshift.com:443";
          facesContext = FacesContext.getCurrentInstance();
          if(facesContext !=null){
           bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
           externalContext = facesContext.getExternalContext();
           //requestH = (HttpServletRequest) externalContext.getRequest();
          }
          String oAuthOwner=customIdentity.getMasterSiteCode();
                  //client record 08 for raaspi will hold openshift rest api secret, record 01 holds Paypal, 03 can hold others
          try{
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","08")
			.setParameter("owner2", oAuthOwner)
			.getSingleResult();
                      //client not raaspi id holds merchant id and secret holds Token for that id
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();

                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        return null;
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        return null;
          	       }
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       client_secret=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
                       debug=client.getE9xxfxxrbvxxxxxxxxxxlevel();//record 08
                       if (client_id ==null || client_id.isEmpty() ){
                       client_id="jay";
                        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         //FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));
                        //return null;
		       }
                       if (client_secret ==null || client_secret.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("Openshift")+" "+bundle.getString("oauth")+" "+bundle.getString("api")+" "+bundle.getString("not")+" "+bundle.getString("fully")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                  }
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","09")
			.setParameter("owner2", oAuthOwner)
			.getSingleResult();
                      //09 holds route ssl certificate and bundle for intermediate files, no /r ie LF allowed by openshift
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();

                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,customIdentity.getMasterSiteCode()+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        return null;
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        return null;
          	       }
                       //client_c=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret();
                       client_c=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().replace("\n", "\\n").replace("\r", "\\r");// removed trim
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("router")+" "+bundle.getString("ssl")+" "+bundle.getString("certicate_values")+" "+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       if (client_c ==null || client_c.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("openshift")+" "+bundle.getString("oauth/route")+" "+bundle.getString("ssl")+" "+bundle.getString("not")+" "+bundle.getString("fully")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                  }
                   client =(Yxxxch522xhhxxhxxxxxclient) entityManager
			.createQuery(
			"select cc from  Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
			.setParameter("nKeyName","10")
			.setParameter("owner2", oAuthOwner)
			.getSingleResult();
                      //client raaspi holds openshift route ssl private key without paraphrase
		      if (client != null) {
		       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
 	               client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();

                       // first check whether raaspi Client Table is locked by sqladmin for Bus Date maintenance (no logic yet to set forvrec 02)
                       // remove hard coded property names
		       int mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("openshift")+" "+bundle.getString("app")+" "+bundle.getString("temporarily")+" "+bundle.getString("stopped")+bundle.getString("for")+bundle.getString("maintenance"),""));
                        return null;
		       }
                       if (isBitSet(mstatusfl, _mclosed) ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("service")+" "+bundle.getString("decommisioned"),""));

                        return null;
          	       }
                       client_p=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().replace("\r","");//route private key
                       if (client_p ==null || client_p.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("private")+" "+bundle.getString("key")+" "+bundle.getString("ssl")+" "+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                       if (client_p ==null || client_p.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("private")+" "+bundle.getString("key")+" "+bundle.getString("ssl")+" "+bundle.getString("not")+" "+bundle.getString("fully")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }

                       // update changes the client statusfldate and tracks when last rest call for this tenant
                       yxxxch522xhhxxhxxxxxclientHome.update();
                    }

          } catch (NoResultException ex) {
                      if(debug){// need not be error, assume automated router only if record 08/09/10 exists
                        //similar logic can be implemented for any hosting env which supports api for routing
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("openshift")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+bundle.getString("exception")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                      }
                      return null;

          }catch (Exception ex){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("openshift")+" "+bundle.getString("app")+" "+bundle.getString("access")+" "+bundle.getString("system")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_ERROR,bundle.getString("please")+" "+bundle.getString("notify")+" "+customIdentity.getMasterSiteCode()+" "+bundle.getString("support"),""));
                        return null;

          }


                log.severe(bundle.getString("creating")+" "+bundle.getString("route")+" for "+owner2CodeClient);
                secret=client_secret;
                //invoke create route via POST request
         try{
                 ret="https://"+shopUrl+"/apis/route.openshift.io/v1/namespaces/raaspi/routes";
		 ClientRequest request = new ClientRequest(ret);
                 request.header("Authorization","Bearer "+secret);
                 request.header("Accept","application/json, */*");
                 request.header("Content-Type","application/json");
                 request.header("Connection","close");
                 String input = "{\"kind\":\"Route\",\"apiVersion\":\"route.openshift.io/v1\",\"metadata\":{\"name\":\""+clientFullUrlName+"\",\"creationTimestamp\":null,\"labels\":{\"app\":\"genapp\"}},\"spec\":{\"host\":\""+clientFullUrlName+"\",\"to\":{\"kind\":\"\",\"name\":\"genapp\",\"weight\":null},\"port\":{\"targetPort\":\"8080-tcp\"},\"tls\":{\"termination\":\"edge\",\"certificate\":\""+client_c+"\",\"key\":\""+client_p+"\",\"insecureEdgeTerminationPolicy\":\"Redirect\"}},\"status\":{\"ingress\":[]}}";
                 request.body(MediaType.APPLICATION_JSON,input);
                 request.header("User-Agent","oc/v1.7.6+a08f5eeb62 (windows/amd64) kubernetes/c84beff");
		 ClientResponse<String> response = request.post(String.class);
                 pp90="";
                 String respString= response.getEntity(String.class);
                 if(debug){//record 08 has flag
                  log.severe(bundle.getString("openshift")+" "+bundle.getString("input")+" "+input);
                  log.severe(bundle.getString("openshift")+" "+bundle.getString("response")+" "+respString);
                 }

                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject  jobject = jelement.getAsJsonObject();
                 if(respString.contains("Failure")){
                  access_token ="Failure";
                  //dont give response log it for manual process
                 }
                 //if(jobject.getAsJsonPrimitive("status") == null || jobject.getAsJsonPrimitive("status").equals("Failure")){
                        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         //FacesMessage.SEVERITY_INFO,bundle.getString("create")+" "+bundle.getString("route")+" "+bundle.getString("failed")+", "+owner2CodeClient,""));
            

                 //}else{
                  //access_token = jobject.getAsJsonPrimitive("status").getAsString();
                  access_token ="200";
                 //}
                 //route created, automate 
                 //response 
                 log.severe(bundle.getString("route")+" "+bundle.getString("created")+" "+access_token+" for "+owner2CodeClient);
                 //yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/getactivation.xhtml"," to you- "+email);// already invoked by doQuickRegister/DoRegister
                 //yxxxuh566xwwqqwxxxxxuserHome.Emailsend("/activationSetup.xhtml"," to our support team for their actions");
                 //following replaces manual activity by Raaspi support
                 // although inRegistrationAndCreateUser was set in doQuickRegister value is not retained?
                 yxxxuh566xwwqqwxxxxxuserHome.setInRegistrationAndCreateUser(true);

                 //following simulates sqladmin action after dns and route setup just done
                 //DoRegister/DoQuickRegister > persist(admin) > inRegistrationAndCreateUser > createClientRegister()
                 //sets clientFullUrlName. Following works if clientFullUrlName intaddr not empty

                 yxxxuh566xwwqqwxxxxxuserHome.copyDefaultsToOwner2(owner2CodeApp);
                 log.severe(bundle.getString("copy")+" "+bundle.getString("defaults")+"done for "+owner2CodeClient);
                 //above deletes/creates many tables like account,periods,clobdata and defaults shop,blog items

                 yxxxuh566xwwqqwxxxxxuserHome.copyOptionsDefaultsToOwner2(owner2CodeApp);
                 yxxxuh566xwwqqwxxxxxuserHome.copy2OptionsDefaultsToOwner2(owner2CodeApp);

                 yxxxuh566xwwqqwxxxxxuserHome.eMailReadyToActivate(newClient,couponName);//new mthod to pass couponName
                 //only  activation email done in this call 

                 log.severe(bundle.getString("routeplusdefaults")+" "+bundle.getString("bcontinue")+" "+bcontinue+" for "+owner2CodeClient);
         }catch (Exception e){
                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 // FacesMessage.SEVERITY_ERROR,bundle.getString("create_route")+" "+bundle.getString("error")+", "+owner2CodeClient+" "+e.getMessage(),""));
                 log.severe(bundle.getString("route")+" "+bundle.getString("create")+" "+bundle.getString("failed")+" for "+owner2CodeClient+" ,"+e.getMessage());

         }
                 return null;


     }




     public String manageDns(String nameServerBy){
      //to be finished 
      /*
       GET -H "Authorization: Bearer <token>" https://openshift.redhat.com:8443/oapi/v1 --insecure

       POST /apis/route.openshift.io/v1/routes HTTP/1.1
       Authorization: Bearer $TOKEN
       Accept: application/json
       Connection: close
       Content-Type: application/json'

       {
        "kind": "Route",
        "apiVersion": "route.openshift.io/v1",
        ...
       }
      */
      //comes here twice first after new site created to get bearer token from openshift and again to make route request
      // using short live token
      // in case of Openshift requests are a method rest calls, not an external url redirects
      // 
      String ret="";
      shopUrl="";
      facesContext = FacesContext.getCurrentInstance();
      if(facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       externalContext = facesContext.getExternalContext();
       requestH = (HttpServletRequest) externalContext.getRequest();
      }


/*
                if(requestH != null && requestH.getParameter("code") !=null){
                 code=requestH.getParameter("code");
                 hmac=requestH.getParameter("hmac");
                 shop=requestH.getParameter("shop");
                 state=requestH.getParameter("state");
                 time=requestH.getParameter("timestamp");
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("invoked")+" code "+code);
                }else{
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("invoked")+" null requestH ");
                 return "";
                }
*/
                // if not authorized/installed will go to shopify install page first but always will redirect with hmac info
                // first time ie client does not exist,create a client records with owner2 as shopurl ie as if a new site registration
                //
                // change redirect to include xxx/shoauthverify and add a hook in pages.xml to invoke method for /shoauthverify
                // after verify it should send req for oauth token and save it in client

                String secret = "3eb9710290fcaeb70d8ecd41f02e6bcc";
                try {
                 String message = "code="+code+"&shop="+shop+"&state="+state+"&timestamp="+time;

                 Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
                 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
                 sha256_HMAC.init(secret_key);
                 byte[] mac_data=sha256_HMAC.doFinal(message.getBytes());
                 String rat=Hex.encodeHexString(mac_data);

                 String hash = Base64.encodeBase64String(mac_data);
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("hash")+" "+rat,""));

                }
                catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("authVerify")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                }
                //
                try{
                 ret="https://"+shop+"/admin/oauth/access_token";
		 ClientRequest request = new ClientRequest(ret);
                 request.accept(MediaType.APPLICATION_JSON);
                 //escape quotes, can also use request.getFormParameters instead of Json
                 // this method gets invoked by call back from installOrAuthorize, so client record should be in session
                 //test whether client_id holds value or we need to read client record
                 /*
                       client_id=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
                       if (client_id ==null || client_id.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("public")+" "+bundle.getString("app")+" "+bundle.getString("api")+" "+bundle.getString("key")+bundle.getString("not")+bundle.getString("setup")+bundle.getString("yet"),""));
                        return null;
		       }
                 */

               //String input = "{\"client_id\":\"2fdeaac312b8eb595c94b855176f18ea\",\"client_secret\":\"3eb9710290fcaeb70d8ecd41f02e6bcc\",\"code\":\""+code+"\"}";
                 String input = "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"code\":\""+code+"\"}";
                 // add logic with a flag to add refresh_token along with id,secret and code if partnrer secret has changed
                 // refresh token will tell shopify to allow new token value for existing customers with old token
                 // needs testing
                 request.body(MediaType.APPLICATION_JSON,input);
		 ClientResponse<String> response = request.post(String.class);
                 log.severe(bundle.getString("shoauthverify")+" "+bundle.getString("response")+" "+response);
                   pp90="";
                 String respString= response.getEntity(String.class);
                 JsonElement jelement = new JsonParser().parse(respString);
                 JsonObject  jobject = jelement.getAsJsonObject();
                 if(jobject.getAsJsonPrimitive("access_token") == null){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("accesstoken")+" "+bundle.getString("already")+" "+bundle.getString("exists"),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("goto")+" "+redirect_uri+" "+bundle.getString("and")+" "+bundle.getString("click")+" "+" "+bundle.getString("sync")+" "+bundle.getString("data"),""));


                 }else{
                  access_token = jobject.getAsJsonPrimitive("access_token").getAsString();
                 }
                 log.severe(bundle.getString("access")+" "+bundle.getString("token")+" "+access_token);

                 //create raaspi site for this merchant/shop and store this access-token as secret
                 // no need for this method or connectorAuthorize unless the scope needs to be changed for this merchant
                 // from now raaspi site of this merchant will be used to sync data and use as backoffice
                 pp90="";
                 //shop is xxx.myshopify.com
                 String enterprisecompcode=this.shop;
                 String urlName=this.shop;
                 if(urlName.contains(".myshopify.com")){
                  urlIndex=urlName.lastIndexOf(".myshopify.com");
                 }
                 if (urlIndex == -1){
                  urlIndex=urlName.lastIndexOf(".");
                  if (urlIndex == -1){
                   urlIndex=urlName.length();
                  }
                 }

                 if (urlName.contains("www.")){
                  owner2CodeClient=urlName.substring(4,urlIndex);
                 }else{
                  owner2CodeClient=urlName.substring(0,urlIndex);
                 }
                 //if scope changes then access-token changes?? then need to update client records
                 serverName=requestH.getServerName();
                 doQuickRegister();
                 if(serverName.contains("raaspi.com")){
                  ret="https://"+owner2CodeClient+".raaspi.com/home.wflow"  ;
                 }else{
                  ret="http://"+owner2CodeClient+".lraaspi.com:8080/home.wflow"  ;
                 }

                 externalContext.redirect(ret);
                 return pp90;
                }
                catch (Exception e){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("authorization")+" / "+bundle.getString("access")+" "+bundle.getString("token")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                 return "";
                }

         }


     public String ip2C(String ip){
        //String ip = "184.147.246.175"; //or any other IP here
        try{
        HttpURLConnection urlcon = (HttpURLConnection)new URL("http://ip2c.org/"+ip).openConnection();
        urlcon.setDefaultUseCaches(false);
        urlcon.setUseCaches(false);
        urlcon.connect();
        InputStream is = urlcon.getInputStream();
        int c = 0;
        String s = "";
        while((c = is.read()) != -1) s+= (char)c;
         is.close();
         switch(s.charAt(0))
        {
         case '0':
          //System.out.println("Something wrong");
          return "e";
         case '1':
          String[] reply = s.split(";");
          //System.out.println("Two-letter: " + reply[1]);
          //System.out.println("Three-letter: " + reply[2]);
          //System.out.println("Full name: " + reply[3]);
          return "reply[1]+reply[2]+reply[3]";
         case '2':
          //System.out.println("Not found in database");
          return "x";
         }
         return "x";
         }catch(Exception e){
          log.severe("Error in ip2c "+ e.getMessage());
         }
          return "x";
    }




}