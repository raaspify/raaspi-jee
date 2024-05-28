package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.Identity;
import org.picketlink.idm.IdentityManagementException;
import org.picketlink.authentication.AuthenticationException;
import org.picketlink.common.exceptions.PicketLinkException;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.Currency;
import java.util.Locale.Builder;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.enterprise.inject.Default;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.sql.DataSource;
import javax.naming.NamingException;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.ResultSet;


/**
* This is Action class Authenticator which extends org.picketlink.authentication
* to provide id/password based login function 
* each user session  comes here via call to checkCreateTables() ie create master site or not
* home page loggedIn or not, calls its currcaldates method and setClientChosenSkin() method
*  comes here via login page > customIdentity > authenticate()
* has logic to log or email msg if bot attack is detected
* client field ncontact can hold bad IP address and if match then kill the session
* setClientChosenSkin method has extra logic to count stats like homepagevisit etc and 
* persist in client field locbaradj
* usagebyPerods table record with key visitstats3r holds the stats and MyDashboard.xhtml will display them
* @author 3r Computer Systems  
* @version 2.0
*/

@Named ("authenticator")
@SessionScoped
@PicketLink
@Default

public class Authenticator extends BaseAuthenticator implements Serializable{
     @Inject
     private Identity identity;
     @Inject
     SqlSupport sqlSupport;
     @Inject SqlAdminSupport sqlAdminSupport;
     @Inject
     Yxxxuq1r1xwwqqhxxxxxresourceHome yxxxuq1r1xwwqqhxxxxxresourceHome;
     @Inject 
     DefaultLoginCredentials credentials;
     @Inject File file;

     private Logger log = Logger.getLogger(Authenticator.class.getCanonicalName());
     // locale.builder allows setting locale values
     private Builder localeSelector = new Builder();

   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
	 @Inject
	 Yxxxuh566xwwqqwxxxxxuserHome yxxxuh566xwwqqwxxxxxuserHome;
	 private Yxxxuh566xwwqqwxxxxxuser user;
	@Inject
	Yxxxch575xwwqqhxxxxxuserproflList yxxxch575xwwqqhxxxxxuserproflList;
	private Yxxxch575xwwqqhxxxxxuserprofl yxxxch575xwwqqhxxxxxuserprofl;
        @Inject
	Yxxxuh566xwwqqwxxxxxuserList yxxxuh566xwwqqwxxxxxuserList;
	@Inject
	Yxxxch575xwwqqhxxxxxuserproflHome yxxxch575xwwqqhxxxxxuserproflHome;

	@Inject
	Yxxxch621xwwqqhxxxxxacperiodHome yxxxch621xwwqqhxxxxxacperiodHome;
	Yxxxch621xwwqqhxxxxxacperiod acperiodnew;
	@Inject
	Yxxxuq632xwwqqhxxxxxperioddatesHome yxxxuq632xwwqqhxxxxxperioddatesHome;
	Yxxxuq632xwwqqhxxxxxperioddates yxxxuq632xwwqqhxxxxxperioddates;
     @Inject
     Jxxxbh400xwwqqhxxxxxemployeeHome jxxxbh400xwwqqhxxxxxemployeeHome;
     Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
     @Inject
     Yxxxch522xhhxxhxxxxxclientHome yxxxch522xhhxxhxxxxxclientHome;
     Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient;
     @Inject
     Fxxxuq111xwwqqhxxxxxaddressHome fxxxuq111xwwqqhxxxxxaddressHome;
     Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress;
     @Inject
     Jxxxuq201xwwqqhxxxxxcustomerHome jxxxuq201xwwqqhxxxxxcustomerHome;
     Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
     @Inject
     Fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome;
     Fxxxuq1bhxwwqqhxxxxxusagebyperiods fxxxuq1bhxwwqqhxxxxxusagebyperiods;

     @Inject CustomIdentity customIdentity; 
     @Inject SkinBean skinBean; 
	String value = "";
	Boolean checkPeriod = false;
	String curracperiod = "";
	private String currdivperiod = "";
	private String currdivperioddescript = "";
	String companycode = "THIS";
	String divcode = "THIS";
	private Boolean bcontinue = new Boolean("true");
	private Calendar calendar = Calendar.getInstance();
        private Calendar calendare = Calendar.getInstance();
	String currcaldates = calendar.getTime().toString().substring(0, 10);
	String currbusdates = calendar.getTime().toString().substring(0, 10);
	String currlocaldate = calendar.getTime().toString().substring(0, 10);
	private Date toDay = calendar.getTime();
	private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
	private String toDays = s.format(calendar.getTime()).toString();
	Date currbusdate = calendar.getTime();
	Date currcaldate = calendar.getTime();
      private int mactive=1;
      // && 2nd bit                4 
      private int _mclosed=3;
      private int _mpartial=5;
      // && 5th                   32 
      private int _mconsign=6;
      // && 6th                   64
	String role = "";
     char[] passToChar;
     private String owner2Code=""; 
     String logonId="";
     private String ssoToken="";
     private Yxxxuh566xwwqqwxxxxxuser ssoUser=null; 
     private List<Yxxxuh566xwwqqwxxxxxuser> results;
     private String urlName="";
     private boolean thisUserSsoPW=false;
     private boolean addressFound=false;
     private Locale locale;
     String language="en";
     String country="US";
     String requestCountry;
     String currencySymbol="$";
     HttpServletRequest req=null;
     String reqAgent="";

     //unlike language and country variant is not set by jsf footer/login.xhtml ,but can be done via
     // message/bundle setup . 3 values are passed via sessionMap objects.
     ///owner2Code is forced into variant for resource control may be variant can be used as owner2Code+variant
     //setClientChosenSkin method here is called by home even if not logged in
     String variant="";
     private ResourceBundle bundle=null;
     private int homePagevisitCount=0;
     private int homePagebotCount=0;
     private int homePageclickCount=0;
     private int botCount=0;

     private String userIP=null;
     Yxxxch522xhhxxhxxxxxclient client;
     Yxxxch621xwwqqhxxxxxacperiod acperiod;
     private boolean applyTax1 = false;
     private boolean applyTax2 = false;
     private boolean applyTax3 = false;
     private boolean debug = false;
     ServletContext contextS=null;
     String viewId = null;
     private Boolean tomeeYN = false;// to allow myfaces vs mojarra jsf or jndi naming
      private DataSource ds;



    @PostConstruct
    public void initialize() {
      /// locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();   
      /// takes care of initial or default resourcebundle locale values, later user may change locale via footer/login 
      //each new request comes here, if browser not for more requests for a session but hackers using curl etc 
      //or rest call will come each time they request since they dont use cookie with jsessionId or jsessionId in url
      //certain pages like login,register, issues browse comes to authenticate method for login or pseudo login
      //setClientChosenSkin method here is called by home page even if not logged in
     ExternalContext externalContext =null;
     try{
      FacesContext facesContext = FacesContext.getCurrentInstance();
      contextS = (ServletContext)facesContext.getExternalContext().getContext(); 
      String urlName=null;
      if (facesContext !=null){
          externalContext = facesContext.getExternalContext();
          req = (HttpServletRequest) externalContext.getRequest(); 
          // robots.txt can be used to stop search engines, debug flag from raaspi client for all requests
         // try addded and master indicator(UserHome >doMasterSite()> client looseit) added in client 01 to avoid hard coding raaspi as master   
          urlName=req.getServerName();
          int urlIndex=0;
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
         if(owner2Code.length() >40){
          log.severe("owner2Code "+owner2Code+" exceeds 40 chs, cannot continue");
          return;
         } 
      }else{
       //facesContext should not be null, 
        log.severe("Authenticator initialize facesContext is null, value: "+facesContext );
      }
      // raaspi app session for each user comes here first, so check if db/schema/table exists, create if needed
      //but not sure why, createquery catch logic does not work here.
      // setclientChosen -> dataBaseResourceLoader ->getContents() query for resource catch works  
      // put checkCreateTables here, will create schema and tables and master site ,if none 
      //tbd String return and navigate ???
      if (!checkCreateTables()){
       return; //checkCreateTables had exception
      }
      //tables already exist or were created
         //String owner2CodeR="raaspi"; instead use master indicator
          client =(Yxxxch522xhhxxhxxxxxclient) entityManager
		.createQuery(
		"select c from Yxxxch522xhhxxhxxxxxclient c where c.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
		.setParameter("nKeyName","01")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
          reqAgent="";
          //if client looseit(master site) and level(debug) on
          if (client != null && client.getE9xxfxxrbvxxxxxxxxxxlevel() && client.getF2xxfxxxbvxxxxxxxxxxlooseit() ) {
           userIP = req.getHeader("X-FORWARDED-FOR");  //get from req header
           if (userIP == null) {  
            userIP = req.getRemoteAddr();  //get from socket connection
           }
           reqAgent=req.getHeader("user-agent");//if debug, check for bot, will skip if requestor impersonating as regular web request
           if(contextS != null && (reqAgent.contains("bot") || reqAgent.contains("Bot"))){
            if(contextS.getAttribute("botcount") !=null && botCount < 5000){
             botCount=Integer.parseInt(contextS.getAttribute("botcount").toString());
             contextS.setAttribute("botcount",botCount+1);
            }else{
             contextS.setAttribute("botcount",1);
            }
            int limit=400;
            if(botCount == limit || botCount == (limit+100)){
             sqlSupport.emailRender("bot");
             log.info("Alert!!!!!!bot Attack-email sent ??????????? " );
             log.severe("bot Debug 400/500: "+req.getHeader("user-agent")+" "+ req.getServerName()+" "+req.getRequestURI()+" "+userIP);
            }
           }
           // below common to any http requests coming bot or not, curl or not , if debug level on
           //will add more logic like same userIP and same url ie req.getServerName() say 10 times in 5mts then kick out 
           String badAgent=client.getG7xxuxrrbvxxxxxxxxxxncustome();
           String badIP=client.getG8xxuxrcbvxxxxxxxxxxncontact();
           if((badIP !=null && !badIP.isEmpty() && userIP.contains(badIP)) || (badAgent !=null && !badAgent.isEmpty() && reqAgent.contains(badAgent)) ){
                 HttpSession session = req.getSession(false);//gets current session but will not create a new
                 if(session==null){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("session")+" "+ bundle.getString("invalid"),""));
                   return;
                 }
            session.setMaxInactiveInterval(1);//kill it, reduces maxsessions count. invalidate destroys but removes after inactive time out
            return;
           }
           //if debug on any request will come here and log, unless >5000 bad ip or useragent matched above and were kicked out 
           if(botCount < 5000){
            log.severe("Master site Debug: "+req.getHeader("user-agent")+" "+ req.getServerName()+" "+req.getRequestURI()+" "+userIP);
           }
           // bad requests will continue and kicked out but not logged any more

          }//client level/debug end 
          // new logic need to go in application scope cdi bean to take action if 300 sessions reached
          // and show in dashboard 
          // session.setMaxInactiveInterval(.2); kill it in .2 sec, reduces maxsessions count. invalidate destroys but removes after inactive time out
          // assume a request coming when sessions are at 300 is the cause
          // requests were coming at 500 ms
     }catch(Exception e){
       //any null exception can come here
       //(HttpServletRequest) externalContext should not be null
        String emsg=e.getMessage();
         log.severe("Authenticator initialize exception externalContext  value: "+externalContext +" ,If needed try in another OS verstion");     
         log.severe("Authenticator initialize externalContext req value: "+req );     
         log.severe("Authenticator initialize externalContext req serverNamevalue: "+req.getServerName() );     
         e.printStackTrace(System.out);
          Locale rbLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
          log.severe("Used locale enUSo2 after DatabaseResourceLoader error "+rbLocale==null?"null":rbLocale.getLanguage()+","+rbLocale==null?"null":rbLocale.getCountry()+","
            +rbLocale==null?"null":rbLocale.getVariant()+" "+emsg );
      //log error
     }
      locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();

     // save requst Country and getter to be used for currency, timezone etc and overide except language
     requestCountry=locale.getCountry();
     // allow supported language to avoid Can't find bundle ...locale cs_US_3rcomputer
     // locale is language,country and variation. java gets it from request header accept language
     // sent by the browser. may differ browser to browser settings
     if(locale.getLanguage().equals("en") || locale.getLanguage().equals("fr") || locale.getLanguage().equals("de")
          || locale.getLanguage().equals("bn")){
      locale=new Locale(locale.getLanguage(),"US",owner2Code);
     }else{
      locale=new Locale("en","US",owner2Code);
     }
    
    }



	public void setHomePageclickCount(int homePageclickCount) {
		this.homePageclickCount = homePageclickCount;
	}

	public int getHomePageclickCount() {
		return homePageclickCount;
	}


	public void setMenuFromValue(String value) {
		this.value = value;
	}

	public String getMenuFromValue() {
		return value;
	}
        public Locale getLocale() {
         // locale value is used on all pages via rtemplate, cannot return null will cause null exception
         if(locale ==null){
          locale=new Locale("en","US",owner2Code);
         }
         return locale;
       }

        public String getLanguage() {
         //return locale.getLanguage();
         return language;
        }

        public void setLanguage(String language) {
         this.language=language;
         locale = new Locale(language,country==null?"":country,owner2Code);
         FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mlanguage", language);
        }

       public String getCurrencySymbol() {
        return currencySymbol;
       }

       public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
       }


        public String getCountry() {
         //return locale.getCountry();
         return country;
        }

        public void setCountry(String country) {
         this.country=country;
         locale = new Locale(language==null?"":language,country,owner2Code);
         FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mcountry", country);
        }

        public String getVariant() {
         return variant;
        }

        public void setVariant(String variant) {
         this.variant=variant;
         locale = new Locale(language==null?"":language,country==null?"":country, variant);
         FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mvariant", variant);
        }


	public String getCurrcaldates() {
		checkSetAcPeriod();
		return currcaldates;
	}

	public String getCurrbusdates() {
		checkSetAcPeriod();
		return currbusdates;
	}

	public String getCurracperiod() {
		checkSetAcPeriod();
                if(acperiod !=null){
		 return acperiod.getA1xxuxwpbv47xxxxxxxxcurrperiod();
                }else{
                 return null;
                }
	}

	public String getCurrlocaldate() {
		return currlocaldate;
	}

	public Date getCurrcaldate() {
		return currcaldate;
	}


     public boolean isBitSet(Integer a, Integer n){ 
      if (a == null){
       a=0;
      }
      return (a & (1 << n)) != 0; 
     }

        /***
        * comes here from login via customIdentity isentity.login or from socialLogin via userHome loginFacebookUser isentity.logIn
        * loggedIn status is not reached here since this is only part of PicketLink authenticate, not login
        */
        @Override
        public void authenticate() {
        Locale rbLocale=FacesContext.getCurrentInstance().getViewRoot().getLocale();
        int mstatusfl=0;
        try{
         FacesContext context = FacesContext.getCurrentInstance();
         bundle = context.getApplication().getResourceBundle(context, "messages");
        }catch(Exception e){
          String emsg=e.getMessage();
          locale=new Locale("en","US","o2");
          FacesContext context = FacesContext.getCurrentInstance();
          //DBControl.reLoadBundle("men_Uso2",owner2Code);
          bundle = context.getApplication().getResourceBundle(context, "messages");
          if(rbLocale !=null){
 	   log.severe("Used locale enUSo2 after DatabaseResourceLoader error with locale "+rbLocale.getLanguage()+","+rbLocale.getCountry()+","+rbLocale.getVariant()+" "+emsg );
          }else{
 	   log.severe("Used locale enUSo2 after DatabaseResourceLoader error, locale was null "+emsg );
          }
        }
                String messages = bundle.getString("item");
                try {
                 //owner2 will be determined from the url request is coming from (we may need a table if multiple url for same client
                 // virtual urls need to be unique (real dns names are unique)
                 // sso support via ssoToken which is kept in client field ncode. and if first time a new user for this site will be created 
                 // copying from existing records but pw will be ssoPW
                 // a client (tenant) record need to have the ncode field populated with a token.
                 // token value will be established by a master tenant (arbitrary selection among a group client records who want sso)
                 // and its ncode will have this token value and other sso partners will have the same code in their ncode
                 // in authentication logic if user is not found then it will search all client records for this user and if found 
                 // will validate entered pw against it and will put "ssoPW" as dummy pw 
                 ExternalContext extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                 Locale currentLocale = extCtxt.getRequestLocale();
                 String jay=currentLocale.getLanguage();
                 thisUserSsoPW=false;
                 if(jay == null | jay.length()==0){
                  //localeSelector.setLanguage(currentLocale.getLanguage());
                 }
                 else{
                  //localeSelector.setLanguage(jay);
                 }
                 jay=currentLocale.getCountry();
                 if(jay == null | jay.length()==0 ){
                  //localeSelector.setRegion(currentLocale.getCountry());
                 }
                 else{
                  localeSelector.setRegion(jay);
                 }
                 req = (HttpServletRequest) extCtxt.getRequest(); 

                 //webserver undertow creates a seesion if a http request comes. If webserver the session is reused using cookie
                 // Each page with rtemplate calls
                 //getLocale method here. Home page calls setClientChosenSkin even if not logged in and checks
                 // ip and visitCount

                 HttpSession session = req.getSession(false);//gets current session but will not create a new
                 if(session==null){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("session")+" "+ bundle.getString("invalid"),""));
                   return;
                 }
                 // increase session timeout to 40 mts is in customIdentity and in userHome loginFacebookUser method 
                 urlName=((javax.servlet.http.HttpServletRequest) extCtxt.getRequest()).getServerName();
                 int urlIndex=0;
                 urlIndex=urlName.lastIndexOf(".");
                 if (urlIndex == -1){
                  urlIndex=urlName.length();
                 }       
                 if (urlName.contains("www.")){
                  owner2Code=urlName.substring(4,urlIndex);
                 }else{
                  owner2Code=urlName.substring(0,urlIndex);
                 }
                 //extract subdomain if used
                 owner2Code=owner2Code.replace("."+customIdentity.getMasterSiteCode(),"");
                 if(owner2Code.length() >40){
                  log.severe("owner2Code "+owner2Code+" exceeds 40 ch, cannot continue");
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("owner2Code")+" "+owner2Code+" "+bundle.getString("exceeds")+" "+bundle.getString("40 ch")+" ,"+bundle.getString("cannot")+" "+bundle.getString("continue"),""));
                  return;
                 } 
                 //session.setAttribute("owner2Attribute", owner2Code);         
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select c from Yxxxch522xhhxxhxxxxxclient c where c.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                      if (client != null) {
	       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
                         client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                       // first check whether Client Table is locked for Bus Date maintenance , not sure where is the lock logic
                       // remove hard coded property names
                       mstatusfl=client.getZexxzzfxhhxxxxxxxxxxstatusfl();
                       if (isBitSet(mstatusfl, _mpartial)){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("system")+" "+bundle.getString("maintenance")+" "+bundle.getString("try")+" "+bundle.getString("later"),""));
	        return;
	     }
                       // update changes the client statusfldate and tracks when last logon for this tenant
                       // client first 2 chrs are prod and subprod, last 2 chrs are saved during site create and are qualifiers within prodsubprod
                       // last 2chrs are for future use
                       yxxxch522xhhxxhxxxxxclientHome.update();
			  customIdentity.setProduct(client.getG2xxuxpclvxxxxxxxxxxprodcode().substring(0, 1));
			  customIdentity.setSubProduct(client.getG2xxuxpclvxxxxxxxxxxprodcode().substring(1, 2));
			  customIdentity.setSize(client.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize());
			  //customIdentity.setClientMsgLevel(client.get???D9xxuxxxbvxxxxxxxxxxenterprisecompsize());
			  customIdentity.setClientMsgLevel("ewi");
			  customIdentity.setOwner2(owner2Code);
                          ssoToken=client.getH5xxuxxxivxxxxxxxxxxncode();
                          //localeSelector.setVariant(client.getG2xxuxpclvxxxxxxxxxxprodcode().substring(0, 2));
                          //log.info("Locale set to #{localeSelector.getLanguage()} #{localeSelector.getCountry()} #{localeSelector.getVariant()}");

                      }
                 if(customIdentity.getOption16()!=null && customIdentity.getUserSid()== -1 ){
                  // onfblogin method is called by java script facebook login 
                  // if it was called then Option16 was set to fb id and UserSid was set to user sid after a user record created
                  // if no facebook login was involved then option16 and userSid will have null and  not -1 value
                  // and continue under else logic for regular application login with id/pw. 
                 
                  logonId=customIdentity.getOption16().trim();
                  if (isBitSet(mstatusfl, _mclosed) && !logonId.toLowerCase().contains("manager") ){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_INFO,bundle.getString("service")+" "+ bundle.getString("decommisoned"),""));
	        return;
                  }

                  this.credentials.setUserId(logonId);
                  customIdentity.setOption16(null);
                  customIdentity.setUsername(logonId);
                  customIdentity.setSmUid(logonId);
                  //customIdentity.setUserSid() gets real value further down
 		  results =  entityManager
 					.createQuery(
 					"select c from Yxxxuh566xwwqqwxxxxxuser c where c.a0xxukuxbvxxxxxxxxxxid = :username and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 					.setParameter("username", logonId)
 					.setParameter("owner2", owner2Code)
 					.getResultList();
                  if(results.isEmpty()){
                   // since rediret following msg wont show
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("facebook")+" "+bundle.getString("signup")+" "+bundle.getString("not")+" "+bundle.getString("done"),""));

                   FacesContext.getCurrentInstance().getExternalContext().redirect("/fbsignup.wflow");
                  }
                  user=results.get(0);
                 }else{
                  // for non fb regular app logon/pw process
                  if (this.credentials.getPassword()==null){
                   // not logged in yet but productcode & subcode,owner2 (same as urlPrefix) and locale set
                   return;
                  }
                  String password=this.credentials.getPassword().trim();
                  logonId=this.credentials.getUserId().trim();
                  customIdentity.setUsername(logonId);
                  //customIdentity.setUserSid() gets real value further down
 		  results =  entityManager
 		  .createQuery(
 		   "select c from Yxxxuh566xwwqqwxxxxxuser c where c.a0xxukuxbvxxxxxxxxxxid = :username and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 		    .setParameter("username", logonId)
 			.setParameter("owner2", owner2Code)
 			 .getResultList();
                  // results to check user entry but could be real or sso or not found
                  if(!results.isEmpty() && results.get(0).getC4xxuxupivxxxxxxxxxxcurrpw().equals("ssoPW")){
                   thisUserSsoPW=true;
                   ssoUser= results.get(0);
                   // jay add logic to use real user employee if added later 
                  }
                  // continue further as we need to check pw for sso found or may have to create sso if real one exists
                  if(results.isEmpty() || thisUserSsoPW ){
                   //user not on this site, check sso on or not for this site and create sso user record if sso is allowed and a real user exists somewhere
                   if(ssoToken !=null && !ssoToken.isEmpty()){
                     List<Yxxxch522xhhxxhxxxxxclient> resultsC = entityManager
					.createQuery(
					"select c from Yxxxch522xhhxxhxxxxxclient c where c.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and c.h5xxuxxxivxxxxxxxxxxncode = :ssoToken")
					.setParameter("nKeyName","01")
					.setParameter("ssoToken", ssoToken)
					.getResultList();  
                    bcontinue=false;   
                    // loop through all clients sharing the ssotoken and search through their users for any real user ie no ssoPW, 
                    // sso may exist but real got deleted
                    for(Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient:resultsC){
	      results =  entityManager
 					.createQuery(
					"select c from Yxxxuh566xwwqqwxxxxxuser c where c.a0xxukuxbvxxxxxxxxxxid = :username and c.c4xxuxupivxxxxxxxxxxcurrpw !='ssoPW' ")
 					.setParameter("username", logonId)
 					.getResultList();
                    }
                    if(results==null || results.isEmpty()){
                     //real user not found in any sso client
                      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("signup")+" "+bundle.getString("not")+" "+bundle.getString("done")+" "+bundle.getString("or")+" "+bundle.getString("this")+" "+bundle.getString("user")+" "+bundle.getString("now")+" "+bundle.getString("removed"),""));
                     //because of session cookie previous identity.loggedIn stays true
                     session.invalidate();
                     return;
                    }
                    // if not empty ie real user found  then create ssoUser if needed
                    if(!results.isEmpty() && !thisUserSsoPW ){
                      // ssoUser does not exist, so create one
                      if (!thisUserSsoPW){
                       createSSO();
                      }
                    }
                   }
                  }
                  if(results==null || results.isEmpty()){
                     //logon entry not found anywhere
                      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                       FacesMessage.SEVERITY_INFO,bundle.getString("signup")+" "+bundle.getString("not")+" "+bundle.getString("done")+" "+bundle.getString("or")+" "+bundle.getString("this")+" "+bundle.getString("user")+" "+bundle.getString("now")+" "+bundle.getString("removed"),""));
                     return;
                  }
                 //real user record found results.get(0), use it for password checking and any further use ie use related customer records etc for stat, purchase
                 // sso user ssoUser is a place holder to indicate sso user exists for this site like a shadow user
                 user=results.get(0);
                 byte[] saltToByte = user.getC8xxuxxxbvxxxxxxxxxxpasswordhash();
                 PasswordSupport.setHashNoon(saltToByte);               
                 String passwordKey=PasswordSupport.hash(password);
                 ///remove later
                 ///passwordKey=user.getC4xxuxupivxxxxxxxxxxcurrpw();

                 if (!passwordKey.equals(user.getC4xxuxupivxxxxxxxxxxcurrpw()) ){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO, bundle.getString("id_password_not_matching"),""));
		  return;
                 }
		 if (user.getZ1xxzzfxhhxxxxxxxxxxstatusfl() != mactive
					&& user.getC9xxuxxxbvxxxxxxxxxxactivationkey() != null) {
                  // assume manager/admin activation should be true otherwise can get stuck if pw forgotten
                  if(user.getA0xxukuxbvxxxxxxxxxxid().equals("manager")||user.getA0xxukuxbvxxxxxxxxxxid().equals("admin")){
    
                  }else{
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_INFO,bundle.getString("needs")+" "+bundle.getString("activation")+", "+bundle.getString("check")+" "+bundle.getString("for")+" "+bundle.getString("email")+" "+bundle.getString("sent")+" "+bundle.getString("with")+" "+bundle.getString("activation")+" "+bundle.getString("link"),""));
	    return;
                  }
                 }

                 if (user.getC5xxcxxxbvxxxxxxxxxxexpiry() !=null && user.getC5xxcxxxbvxxxxxxxxxxexpiry().before( calendar.getTime())  ) {
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("password")+" "+bundle.getString("expired")+", "+new SimpleDateFormat("yyyy.MMM.dd.HH.mm").format(user.getC5xxcxxxbvxxxxxxxxxxexpiry()),""));

                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("use")+" "+bundle.getString("reset")+" "+bundle.getString("password")+" "+bundle.getString("button")+" "+bundle.getString("shown")+" "+bundle.getString("below"),""));


                  return;
                 }
                 if (user.getC7xxfxxxivxxxxxxxxxxtemporarypassword() ) {
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_INFO,bundle.getString("temporary")+" "+bundle.getString("password")+" "+bundle.getString("being")+" "+bundle.getString("used")+", "+bundle.getString("change")+" "+bundle.getString("before")+" "+new SimpleDateFormat("yyyy.MMM.dd.HH.mm").format(user.getC5xxcxxxbvxxxxxxxxxxexpiry()),""));
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_INFO,bundle.getString("change")+" "+bundle.getString("password")+" "+bundle.getString("button")+" "+bundle.getString("is")+", "+bundle.getString("on")+" "+bundle.getString("home")+" "+bundle.getString("page")+", "+bundle.getString("beside")+" "+bundle.getString("logout")+" "+bundle.getString("button"),""));

		 }
                //end of fb/regular user???
                }
                logInA();//update user record statusfldt

		     log.info(currbusdates+" authenticated #0,"+ logonId+", "+owner2Code);
                     User ju=new User(this.credentials.getUserId());
                     setAccount(ju);
                     setStatus(AuthenticationStatus.SUCCESS);
                     boolean lg=identity.isLoggedIn();  
		     log.info("authenticated2 #0,"+ getStatus()+" "+identity.isLoggedIn());

                         // continue to use the real user record unless in demo site. demo users have higher roles and employee record
                         // skip if this is not SSO user ie a real demo user continuing to log on
                         if(thisUserSsoPW){
                          // sso user is a copy of user with some mod if demo sites
                          user=ssoUser;
                         }
			 if (user.getC2xxuxuaiv38xxxxxxxxalevel() != null) {
				//* U-user functions,A-Admin Functions,F-? E-Everything,H-Most but not all,M-Medium level
				//replace alevel with "U",blevel with "Q" 

				//getRole
				//for (UserRole mr : user.getUxxxiv38xxxxxxxxalevel()) 
				role = user.getC2xxuxuaiv38xxxxxxxxalevel().trim()
						+ user.getC3xxuxubiv39xxxxxxxxblevel().trim();
				customIdentity.setRole(role.toUpperCase()); 
			 }
                 // taking the company etc last characters to make more unique and give hints about record viewing scope
                 if (user.getJxxxbh400xwwqqhxxxxxemployee() != null) {
                  jxxxbh400xwwqqhxxxxxemployeeHome.setJxxxbh400xwwqqhxxxxxemployeeA0xxuobxbxxxxxxxxxxxsid( user.getJxxxbh400xwwqqhxxxxxemployee().getA0xxuobxbxxxxxxxxxxxsid() );
                  jxxxbh400xwwqqhxxxxxemployee = jxxxbh400xwwqqhxxxxxemployeeHome.getDefinedInstance();
                  String cdd="sss";
                  String suffix="";
                  if(jxxxbh400xwwqqhxxxxxemployee.getDxxxch1d3xwwqqhxxlxxcompany() != null){
                   suffix=jxxxbh400xwwqqhxxxxxemployee.getDxxxch1d3xwwqqhxxlxxcompany().getA0xxukcxbvxxxxxxxxxxcompanycode();
                  }
                  if (suffix !=null && suffix.length()>0){
                   cdd=suffix.substring(suffix.length()-1,suffix.length());
                  }else{
                   cdd="s";
                  } 
                  suffix="";
                  if(jxxxbh400xwwqqhxxxxxemployee.getFxxxch133xhhxqhxxlxxdivision() != null){
                   suffix=jxxxbh400xwwqqhxxxxxemployee.getFxxxch133xhhxqhxxlxxdivision().getA0xxukoxbvxxxxxxxxxxdivcode();
                  }
                  if (suffix !=null && suffix.length()>0){
                   cdd=cdd+suffix.substring(suffix.length()-1,suffix.length());
                  }else{
                   cdd=cdd+"s";
                  } 
                  suffix="";
                  if(jxxxbh400xwwqqhxxxxxemployee.getFxxxch122xhhxqhxxlxxdepartment() !=null ){
                   suffix=jxxxbh400xwwqqhxxxxxemployee.getFxxxch122xhhxqhxxlxxdepartment().getA0xxukexbvxxxxxxxxxxdepcode();
                  } 
                  if (suffix !=null && suffix.length()>0){
                   cdd=cdd+suffix.substring(suffix.length()-1,suffix.length());
                  }else{
                   cdd=cdd+"s";
                  } 
			  customIdentity.setOwner(logonId+cdd);///
			  customIdentity.setOwnerSid(jxxxbh400xwwqqhxxxxxemployee.getA0xxuobxbxxxxxxxxxxxsid());
                  
                 }else{
			  customIdentity.setOwner(logonId+"sss");
                 }
			 customIdentity.setUserSid(user.getA0xxuobxbxxxxxxxxxxxsid());
			 customIdentity.setRestrict1(user.getY1xxuxxxivxxxxxxxxxxrestrict1()==null?"":user.getY1xxuxxxivxxxxxxxxxxrestrict1());
			 customIdentity.setRestrict2(user.getY2xxuxxxivxxxxxxxxxxrestrict2()==null?"":user.getY2xxuxxxivxxxxxxxxxxrestrict2());
			 customIdentity.setRestrict3(user.getY3xxuxxxivxxxxxxxxxxrestrict3()==null?"":user.getY3xxuxxxivxxxxxxxxxxrestrict3());
			 customIdentity.setAllow1(user.getY4xxuxxxivxxxxxxxxxxallow1()==null?"":user.getY4xxuxxxivxxxxxxxxxxallow1());
			 customIdentity.setAllow2(user.getY5xxuxxxivxxxxxxxxxxallow2()==null?"":user.getY5xxuxxxivxxxxxxxxxxallow2());
			 customIdentity.setAllow3(user.getY6xxuxxxivxxxxxxxxxxallow3()==null?"":user.getY6xxuxxxivxxxxxxxxxxallow3());


   




                 	checkPeriod = checkSetAcPeriod();//calls setUserChosenSkin which sets uswrprifl
	if (!checkPeriod) {
		// allow users with UH/UQ role to continue to fix or do Fiscal year end.
                                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO, "Accounting Period check failed-contact admin",""));

		if ( role.substring(0, 2).equals("UH") || role.substring(0, 2).equals("UQ") ) {
                                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("accounting")+" "+bundle.getString("period")+" "+bundle.getString("check")+" "+bundle.getString("failed")+", "+bundle.getString("do")+" "+bundle.getString("year")+" "+bundle.getString("end")+" "+bundle.getString("or")+" "+bundle.getString("update")+" "+bundle.getString("period")+" "+bundle.getString("dates"),""));
                                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("accounting")+" "+bundle.getString("if")+" "+bundle.getString("needed")+", "+bundle.getString("set")+", "+bundle.getString("current")+" "+bundle.getString("calendar")+" "+bundle.getString("date")+" "+bundle.getString("same")+" "+bundle.getString("as")+" "+bundle.getString("today"),""));

		return;
		} else {
		return;
		}
	}
			customIdentity.setCurrcaldates(currcaldates);
			customIdentity.setCurrbusdates(currbusdates);
			return ;
		} catch (NoResultException ex) {
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("failed")+", "+bundle.getString("contact")+", "+bundle.getString("site")+", "+bundle.getString("admin"),""));

		 return;
  	        } catch (Exception e) {
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("login")+" "+bundle.getString("failed")+", "+bundle.getString("contact")+", "+bundle.getString("site")+", "+bundle.getString("admin"),""));
                    		        log.severe("lauthenticate try failed"+ e);
		 return ;
		}
       
	}
        public void createSSO(){
                       // results get(0) is real entry not another sso user, so copy from other tenant and create user (w dummy sso pw),address and 
                       // customer so that sso logged in user can buy on this site as well just like fb signup/login
                       // if current site is demo site, role needs to be U not V with restrict D and employee record 
                       // if starting user was a demo user and current site a non demo site ,then change to V from U
                       thisUserSsoPW=true;
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_INFO,bundle.getString("Single")+" "+bundle.getString("SignOn")+" "+bundle.getString("(SSO)")+" "+bundle.getString("activated"),""));

                       yxxxuh566xwwqqwxxxxxuserHome.createInstance();
                       yxxxuh566xwwqqwxxxxxuserHome.getInstance().setA0xxukuxbvxxxxxxxxxxid(results.get(0).getA0xxukuxbvxxxxxxxxxxid());
                       yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC1xxuxxxbvxxxxxxxxxxotherid(results.get(0).getC1xxuxxxbvxxxxxxxxxxotherid());
                       // ssouser points to customer entity, which needs to be created
                       yxxxuh566xwwqqwxxxxxuserHome.setInCreateUser(false);
                       yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC4xxuxupivxxxxxxxxxxcurrpw("ssoPW");
                       yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC6xxuxuoivxxxxxxxxxxoldpw(results.get(0).getZzxxu2oxxhxxxxxxxxxxowner2());
                       yxxxuh566xwwqqwxxxxxuserHome.getInstance().setY1xxuxxxivxxxxxxxxxxrestrict1(results.get(0).getY1xxuxxxivxxxxxxxxxxrestrict1());
                       yxxxuh566xwwqqwxxxxxuserHome.getInstance().setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                       if(urlName.startsWith("mybusiness") || urlName.startsWith("myorg") || urlName.startsWith("mycustommade")){
                        yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC2xxuxuaiv38xxxxxxxxalevel("U");
                        yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC3xxuxubiv39xxxxxxxxblevel("H");
                        yxxxuh566xwwqqwxxxxxuserHome.getInstance().setY1xxuxxxivxxxxxxxxxxrestrict1("D");
                       }else{
                        yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC2xxuxuaiv38xxxxxxxxalevel("V");
                        yxxxuh566xwwqqwxxxxxuserHome.getInstance().setC3xxuxubiv39xxxxxxxxblevel("H");
                       }

                       // ssouser record to be created here to indicate sso entry and further use except for password authentication
                       // real user and sso user may have different client as owner2 and getinstance will fail 
                       // copy and create customer/address from real to sso user
                       // in case of demo ssouser an employee record is needed for backoffice functions so copy and create or just create if real does not have
                       // so sso allows convenient login but each sso user will have its own foreign customer/employee etc records 
                       createEmpl();
                       // now take care of copying and creating customer/address
                       createCustAddr();
                       // persist sso user
                       yxxxuh566xwwqqwxxxxxuserHome.persist();
                       ssoUser=yxxxuh566xwwqqwxxxxxuserHome.getInstance();

        }
        public void createEmpl(){
                       if(urlName.startsWith("mybusiness") || urlName.startsWith("myorg") || urlName.startsWith("mycustommade")){
                        if(results.get(0).getJxxxbh400xwwqqhxxxxxemployee() !=null){
                         // ok we needed employee record and we got it as in case of another demo site or back office created employee user
                         // we need to create it under current client/owner2
                         jxxxbh400xwwqqhxxxxxemployeeHome.createInstance();
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setA0xxuktxbvxxxxxxxxxxemployee(results.get(0).getJxxxbh400xwwqqhxxxxxemployee                        ().getA0xxuktxbvxxxxxxxxxxemployee());
                         // copy other info besides key
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                         jxxxbh400xwwqqhxxxxxemployeeHome.persist();
                         yxxxuh566xwwqqwxxxxxuserHome.getInstance().setJxxxbh400xwwqqhxxxxxemployee(jxxxbh400xwwqqhxxxxxemployeeHome.getInstance());
                        }else{
                         //visitors should have email info as it is a reqd field for user sign up, so use it to create employee
                         // jay add logic as part of sso user regular login to use real user employee in case it gets added later and delete sso one
                         String subKey=results.get(0).getC1xxuxxxbvxxxxxxxxxxotherid();
                         int atAt=subKey.indexOf("@");
                         if (atAt != -1){
                          if (atAt > 2 ){
                           subKey="de"+subKey.substring(2,atAt)+"x"+subKey.substring(atAt+2);
                          }
                         }
                         else{
                          if (subKey.length() !=0 && subKey.length()>2 ){
                           subKey="de"+subKey.substring(2)+"AXZ";
                          }
                         }
                         if (subKey.length() !=0){
                          String subKeyh=Integer.toString(subKey.hashCode());
                          if (subKey.length() > 9){
                           subKey=subKey.substring(0,10)+subKeyh;
                          }
                          else {
                           subKey=subKey+subKeyh;
                          }
                         }
                         jxxxbh400xwwqqhxxxxxemployeeHome.createInstance();
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setA0xxuktxbvxxxxxxxxxxemployee(subKey);
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setN4xxhxxrbv24xxxxxxxximailaddr("");
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setO2xxuwmrbv40xxxxxxxxintegrset("DEFAULT");
                         jxxxbh400xwwqqhxxxxxemployeeHome.persist();
                         yxxxuh566xwwqqwxxxxxuserHome.getInstance().setJxxxbh400xwwqqhxxxxxemployee(jxxxbh400xwwqqhxxxxxemployee);
                        }
                       }else{
                        // not mybusiness or myorg so we dont care about creating employee record
                        // but create one if one exists because later it may be used to build owner field
                        if(results.get(0).getJxxxbh400xwwqqhxxxxxemployee() !=null){
                         jxxxbh400xwwqqhxxxxxemployeeHome.createInstance();
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setA0xxuktxbvxxxxxxxxxxemployee(results.get(0).getJxxxbh400xwwqqhxxxxxemployee                        ().getA0xxuktxbvxxxxxxxxxxemployee());
                         // copy other info besides key
                         jxxxbh400xwwqqhxxxxxemployeeHome.getInstance().setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                         jxxxbh400xwwqqhxxxxxemployeeHome.persist();
                         yxxxuh566xwwqqwxxxxxuserHome.getInstance().setJxxxbh400xwwqqhxxxxxemployee(jxxxbh400xwwqqhxxxxxemployeeHome.getInstance());
                        }
                       }
        }
        public void createCustAddr(){
                       if(results.get(0).getJxxxuq201xwwqqhxxxxxcustomer()==null){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_ERROR,bundle.getString("no")+" "+bundle.getString("customer")+" "+bundle.getString("record")+", "+bundle.getString("cannot")+" "+bundle.getString("continue"),""));
                          return;
                       }
                       if(results.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getFxxxuq111xwwqqhxxxxxaddressByMailtocode() !=null){
                          addressFound=true;
                          fxxxuq111xwwqqhxxxxxaddressHome.createInstance();
                          fxxxuq111xwwqqhxxxxxaddressHome.getInstance().setA0xxukbxbxxxxxxxxxxxaddrescode(results.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getFxxxuq111xwwqqhxxxxxaddressByMailtocode().getA0xxukbxbxxxxxxxxxxxaddrescode());
                          // copy other info besides key
                          fxxxuq111xwwqqhxxxxxaddressHome.getInstance().setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                          fxxxuq111xwwqqhxxxxxaddressHome.persist();
                          // user does not have address as foreign, only via customer

                       }
                       if(results.get(0).getJxxxuq201xwwqqhxxxxxcustomer() !=null){
                         jxxxuq201xwwqqhxxxxxcustomerHome.createInstance();
                         jxxxuq201xwwqqhxxxxxcustomerHome.getInstance().setA0xxukxxbvxxxxxxxxxxcustomer(results.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getA0xxukxxbvxxxxxxxxxxcustomer());
                         if(addressFound){ 
                          jxxxuq201xwwqqhxxxxxcustomerHome.getInstance().setFxxxuq111xwwqqhxxxxxaddressByMailtocode(fxxxuq111xwwqqhxxxxxaddressHome.getInstance());
                         } 
                         jxxxuq201xwwqqhxxxxxcustomerHome.getInstance().setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                         jxxxuq201xwwqqhxxxxxcustomerHome.persist();
                         yxxxuh566xwwqqwxxxxxuserHome.getInstance().setJxxxuq201xwwqqhxxxxxcustomer(jxxxuq201xwwqqhxxxxxcustomerHome.getInstance());

                       }
        }

	public boolean checkSetAcPeriod() {
                Yxxxch621xwwqqhxxxxxacperiod acperiod =null;
                try {
			acperiod = (Yxxxch621xwwqqhxxxxxacperiod) entityManager
					.createQuery(
							"select c from Yxxxch621xwwqqhxxxxxacperiod c where c.a0xxukwpbv47xxxxxxxxrowid = :rowid and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2" )
					.setParameter("owner2", owner2Code)
					.setParameter("rowid", "01").getSingleResult();

			           if (acperiod != null & acperiod.getA0xxukwpbv47xxxxxxxxrowid() != null) {
				      currcaldates = acperiod.getB3xxdwerbvxxxxxxxxxxcurrcaldate().toString()
						.substring(0, 10);
				      currbusdate = acperiod.getB2xxdwerbvxxxxxxxxxxcurrbusdate();
				      currbusdates = acperiod.getB2xxdwerbvxxxxxxxxxxcurrbusdate().toString()
						.substring(0, 10);
				      currlocaldate = acperiod.getB4xxdwerbvxxxxxxxxxxcurrlocaldate()
						.toString().substring(0, 10);
				      curracperiod = acperiod.getA1xxuxwpbv47xxxxxxxxcurrperiod();
                                      if(curracperiod == null){
                                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                        FacesMessage.SEVERITY_ERROR,bundle.getString("current")+" "+bundle.getString("accounting")+" "+bundle.getString("period")+" "+bundle.getString("is")+" "+bundle.getString("null")+", "+bundle.getString("assumed")+" "+bundle.getString("as")+" "+bundle.getString("12")+" , "+bundle.getString("needs")+" "+bundle.getString("followup"),""));
                                        curracperiod="12";
                                      }
			              customIdentity.setCurracperiod(acperiod.getA1xxuxwpbv47xxxxxxxxcurrperiod());
			           }else {
				       return false;
			           }
                           // if hold currentbusinessdate is on then give message and return
                           // so that old a/c adj can be run over a few calendar days
                            if (acperiod != null && isBitSet(acperiod.getZ1xxzzfxhhxxxxxxxxxxstatusfl(),_mconsign)){
 			     if ( !role.isEmpty() && (role.substring(0, 2).equals("UH") || role.substring(0, 2).equals("UQ")) ) {
                              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                               FacesMessage.SEVERITY_INFO,bundle.getString("current")+" "+bundle.getString("bussines")+" "+bundle.getString("date")+" "+currbusdates+", "+bundle.getString("is")+" "+bundle.getString("on")+" "+bundle.getString("hold"),""));
                             }
                             return true; 
                            }  
                            if (!currcaldates.equals(toDays)) {
                            // eod not done, force it here, roll period and/or roll business date
	          // monthly assumed here.  compare was faling depending on the time, use generic CAST(myField AS DATE) rather than postgre 
                                     // specific date() to convert start/end time stamp to date
                                try {
		 yxxxuq632xwwqqhxxxxxperioddates = (Yxxxuq632xwwqqhxxxxxperioddates) entityManager
		.createQuery(
                  	"select c from Yxxxuq632xwwqqhxxxxxperioddates c where c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and :toDay between cast(c.b2xxdwsrbvxxxxxxxxxxstartdate as date) and cast(c.b3xxdwerbvxxxxxxxxxxenddate as date)")
   	                  .setParameter("toDay", toDay, TemporalType.DATE)
		  .setParameter("owner2", owner2Code)
		         .getSingleResult();
			                 if (yxxxuq632xwwqqhxxxxxperioddates.getA0xxukwpbv47xxxxxxxxperiod() != null) {
					  currdivperiod = yxxxuq632xwwqqhxxxxxperioddates.getA0xxukwpbv47xxxxxxxxperiod();
					  currdivperioddescript = yxxxuq632xwwqqhxxxxxperioddates.getB1xxuszsbvxxxxxxxxxxdescript();
                                         }
                                         // catch all exception not just nre, 
                                         }catch (Exception e) {
					// end of fiscal year or bad division dates 
					bcontinue = false;
                                        if(!checkPeriod){
                                         if ( acperiod != null &  !role.isEmpty() && (role.substring(0, 2).equals("UH") || role.substring(0, 2).equals("UQ")) 
                                          && !isBitSet(acperiod.getZ1xxzzfxhhxxxxxxxxxxstatusfl(),_mconsign)  ) {
                                        
                                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                           FacesMessage.SEVERITY_INFO,bundle.getString("checking")+" "+bundle.getString("if")+" "+bundle.getString("today")+" "+toDay+" "+bundle.getString("inside")+" "+bundle.getString("period")+" "+bundle.getString("dates")+", "+bundle.getString("range"),""));
                                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                           FacesMessage.SEVERITY_WARN,bundle.getString("period")+" "+bundle.getString("dates")+" "+bundle.getString("read")+", "+bundle.getString("failed")+", "+e,""));
                                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                           FacesMessage.SEVERITY_INFO,bundle.getString("either")+" "+bundle.getString("perform")+" "+bundle.getString("yearend")+", "+bundle.getString("or")+" "+bundle.getString("hold")+" "+bundle.getString("business")+" "+bundle.getString("date"),""));
                                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                           FacesMessage.SEVERITY_INFO,bundle.getString("goto")+" "+bundle.getString("setup")+"/"+bundle.getString("accounting")+" "+bundle.getString("period")+", "+bundle.getString("change")+" "+bundle.getString("dates")+" "+bundle.getString("back")+" "+bundle.getString("and")+" "+bundle.getString("hold"),""));
                                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                           FacesMessage.SEVERITY_INFO,(bundle.getString("if")+" "+bundle.getString("still")+" "+bundle.getString("not")+" "+bundle.getString("ready")+" "+bundle.getString("for")+" "+bundle.getString("year")+" "+bundle.getString("end")),""));
                                                                   }
                    		         //log.severe("login-inner try checkSetAcPeriod failed, bad fiscal year or dates"+ e);
                                        } 
					return false;
				       }
				       if (bcontinue && !curracperiod.equals(currdivperiod)) {
					// persist new period
					acperiod.setA1xxuxwpbv47xxxxxxxxcurrperiod(currdivperiod);
					acperiod.setB1xxuxzsbvxxxxxxxxxxdescript(currdivperioddescript);
				       }
				       if (bcontinue) {
					// add logic if next day is holiday or not business day 7=sat, 1=sunday
					Calendar nextDay = (Calendar) calendar.clone();
                                        // do not let go past p14 date because posting date becomes
                                        // beyond f yr (p13/14 dates get copied to next fyr)
                                        if(nextDay.equals(yxxxuq632xwwqqhxxxxxperioddates.getB3xxdwerbvxxxxxxxxxxenddate()) 
                                         || nextDay.after(yxxxuq632xwwqqhxxxxxperioddates.getB3xxdwerbvxxxxxxxxxxenddate()) ){
                                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                          FacesMessage.SEVERITY_INFO,bundle.getString("end")+" "+bundle.getString("of")+" "+bundle.getString("period14")+", "+bundle.getString("reached")+", "+bundle.getString("yearend")+" "+bundle.getString("is")+" "+bundle.getString("need"),""));
                                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                          FacesMessage.SEVERITY_INFO,bundle.getString("business")+" "+bundle.getString("date")+" "+bundle.getString("will")+", "+bundle.getString("not")+", "+bundle.getString("roll")+" "+bundle.getString("roll")+", "+bundle.getString("otherwise"),""));
                                         acperiod.setZ1xxzzfxhhxxxxxxxxxxstatusfl(_mconsign);//hold cbd

                                        }else{
					 acperiod.setB3xxdwerbvxxxxxxxxxxcurrcaldate(nextDay.getTime());
					 if (nextDay.get(Calendar.DAY_OF_WEEK) == 7) {
						nextDay.add(Calendar.DAY_OF_YEAR, 2);
					 }
					 if (nextDay.get(Calendar.DAY_OF_WEEK) == 1) {
						nextDay.add(Calendar.DAY_OF_YEAR, 1);
					 }
					 acperiod.setB2xxdwerbvxxxxxxxxxxcurrbusdate(nextDay.getTime());
                                        }

				        if ( acperiod != null){
                                         yxxxch621xwwqqhxxxxxacperiodHome.setInstance(acperiod);
					 yxxxch621xwwqqhxxxxxacperiodHome.update();
                                         // reset daily bot count mar19 only if raaspi jul17 2021
                                         if (customIdentity.isMasterSite()){
                                          log.info(customIdentity.getMasterSiteCode()+" date change and botCount value before reset ??????? "+botCount);
                                          contextS.setAttribute("botcount",0); 
                                         }
                                        }
                                   }
                            }
                            setUserChosenSkin();
			    return true;

               } catch (Exception e) {
			  bcontinue = false;
                          if(!checkPeriod){
			   if (acperiod != null &&  !role.isEmpty() && (role.substring(0, 2).equals("UH") || role.substring(0, 2).equals("UQ")) ) {
                            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                             FacesMessage.SEVERITY_INFO,bundle.getString("Today")+" "+toDays+" "+bundle.getString("outside")+" "+bundle.getString("accounting")+", "+bundle.getString("period")+" "+bundle.getString("dates"),""));
                             if (isBitSet(acperiod.getZ1xxzzfxhhxxxxxxxxxxstatusfl(),_mconsign)){
                              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                               FacesMessage.SEVERITY_INFO,bundle.getString("current")+" "+bundle.getString("bussines")+" "+bundle.getString("date")+" "+currbusdates+", "+bundle.getString("is")+" "+bundle.getString("on")+" "+bundle.getString("hold"),""));
                             }
                            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                             FacesMessage.SEVERITY_INFO,bundle.getString("Fiscal")+" "+bundle.getString("year")+" "+bundle.getString("end")+", "+bundle.getString("may")+", "+bundle.getString("be")+" "+bundle.getString("needed"),""));
			    return true;
 		           } else {
			    return true;
			   }
                           //log.severe("login-main try checkSetAcPeriod failed"+ e);
                          }
			   return false;
		}

	}


 

        public String setClientChosenSkin(String viewUrl){

          // set skin to client default value evenif not logged in via home.xhtml f:metadata tag f:preRenderView listener
                 //do not flip or set LeftShownt here, it should be done manually during session
                 // otherwise it will reverse what was manually done
                 // added home page visitor count,  put try to avoid app hung if exception
                homePageclickCount=homePageclickCount+1;// update this each time home page gets invoked
                req=null;
                try{ 
                 FacesContext context = FacesContext.getCurrentInstance();
                 bundle = context.getApplication().getResourceBundle(context, "messages");
                 if(skinBean.getSkint() ==null){
                  skinBean.setSkin(skinBean.getSkint());
                  //return ""; later
                 }
                 //if visitor and userset then below returns wont happen and skin will come from client or update client if needed 
                 if(skinBean.getUserSet()){
                  skinBean.setLeftShown(skinBean.getLeftShownt());
                  return "";
                 }
                 if(skinBean.getUserSetIcon()){
                  skinBean.setIconShown(skinBean.getIconShownt());
                  return "";
                 }
                 ExternalContext extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                 req = (HttpServletRequest) extCtxt.getRequest(); 
                 userIP = req.getHeader("X-FORWARDED-FOR");  //get from req header
                 if (userIP == null) {  
                  userIP = req.getRemoteAddr();  //get from socket connection
                 }
                 HttpSession session = req.getSession();//gets session or will create one
                 urlName=((javax.servlet.http.HttpServletRequest) extCtxt.getRequest()).getServerName();
                 int urlIndex=0;
                 urlIndex=urlName.lastIndexOf(".");
                 if (urlIndex == -1){
                  urlIndex=urlName.length();
                 }       
                 if (urlName.contains("www.")){
                  owner2Code=urlName.substring(4,urlIndex);
                 }else{
                  owner2Code=urlName.substring(0,urlIndex);
                 }
                 //extract subdomain if used
                 owner2Code=owner2Code.replace("."+customIdentity.getMasterSiteCode(),"");
  	         customIdentity.setOwner2(owner2Code);// use customIdentity owner2Code instead of checking in each bean and xhtml
                 //why setting again, should we compare??
                 } catch (Exception ex) {
                  log.severe("get resourceBundle or req getSession error? "+ex.getMessage() );

                  return "";
                 }
                 // wildcard dns added, so check for client record first before usagebyperiods
                 Yxxxch522xhhxxhxxxxxclient client=null;

                 try{
                 client =(Yxxxch522xhhxxhxxxxxclient) entityManager
	.createQuery(
	"select c from Yxxxch522xhhxxhxxxxxclient c where a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	.setParameter("nKeyName","01")
	.setParameter("owner2", owner2Code)
	.getSingleResult();
	} catch (Exception ex) {
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("no")+" "+bundle.getString("client")+", "+bundle.getString("record")+", "+bundle.getString("for")+" "+owner2Code,""));

                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("site")+", "+bundle.getString("url")+", "+bundle.getString("spelling"),""));
          
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("If")+" "+bundle.getString("needed")+", "+bundle.getString("visit")+", "+customIdentity.getMasterSiteCode()+" "+bundle.getString("site")+" "+bundle.getString("to")+" "+bundle.getString("create")+" "+bundle.getString("free")+" "+bundle.getString("trial")+" "+bundle.getString("site"),""));
	return "";
	}


                 Fxxxuq1bhxwwqqhxxxxxusagebyperiods usagebyperiods=null;
                 try{
                 usagebyperiods =(Fxxxuq1bhxwwqqhxxxxxusagebyperiods) entityManager
					.createQuery(
					"select c from Fxxxuq1bhxwwqqhxxxxxusagebyperiods c where c.a0xxukupbvxxxxxxxxxxusagetrackerid = :nKeyName and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","visitstats3r")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
	} catch (NoResultException nre) {
                  log.severe("why no visitstats3r entry for? "+owner2Code );

                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  //FacesMessage.SEVERITY_INFO,bundle.getString("no")+" "+"visitstats3r"+" "+bundle.getString("usagebyperiods")+", "+bundle.getString("record")+", "+bundle.getString("for")+" "+owner2Code,""));

                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  //FacesMessage.SEVERITY_INFO,bundle.getString("creating")+" "+bundle.getString("one"),""));
                 fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.clearInstance();
                 usagebyperiods=fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.getInstance();
                 usagebyperiods.setA0xxukupbvxxxxxxxxxxusagetrackerid("visitstats3r");
                 fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.persist();
                } catch ( Exception ex){
                  log.severe("no visitstats3r persist for? "+owner2Code+", "+ex.getMessage() );
                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  //FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+bundle.getString("getting")+" "+"visitstats3r"+" "+bundle.getString("usagebyperiods")+" "+bundle.getString("record")+", "+bundle.getString("for")+" "+owner2Code+": "+ex.getMessage(),""));
                 //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  //FacesMessage.SEVERITY_INFO,bundle.getString("site")+" "+bundle.getString("visit")+" "+bundle.getString("stats")+" "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("skipped"),""));
                }

                try{
	     if (client != null) {
	       yxxxch522xhhxxhxxxxxclientHome.setId( client.getA0xxuobxbxxxxxxxxxxxsid() );
                         client = yxxxch522xhhxxhxxxxxclientHome.getDefinedInstance();
                        // authenticator.getCurrencySymbol is used in txns like cuinvoice as default currency
                        // client currcode/currsymb for merchant account via customIdentity 
                        //defaultc/keyorder via authenticator for items and charge. custmer card currency is variable
                        // depends on their bank 
                        // defaultc/keyorder is set by doregister method when creating site
                        // currcode/currsymb set during payment processor and different based in record 01 or 03 etc
                        currencySymbol=client.getY2xxuxxxbvxxxxxxxxxxkeyorder();//itemCurrency
                        customIdentity.setApplyTax1((client.getV6xxuxz1bvxxxxxxxxxxtax1code() !=null && !client.getV6xxuxz1bvxxxxxxxxxxtax1code().isEmpty())?true:false);
                        customIdentity.setApplyTax2((client.getV7xxuxz2bvxxxxxxxxxxtax2code() !=null && !client.getV7xxuxz2bvxxxxxxxxxxtax2code().isEmpty())?true:false);
                        customIdentity.setApplyTax3((client.getV8xxuxz3bvxxxxxxxxxxtax3code() !=null && !client.getV8xxuxz3bvxxxxxxxxxxtax3code().isEmpty())?true:false);
                        customIdentity.setConvRate( BigDecimal.valueOf(client.getP4xxzxxrbvxxxxxxxxxxshibaradj()).movePointLeft(2) );//
                        customIdentity.setCurrencySymbol(client.getY2xxuxxxbvxxxxxxxxxxkeyorder());//item
                        customIdentity.setMcurrencySymbol(client.getJ9xxuxxxbvxxxxxxxxxxcurrsymb());//merchant
                        customIdentity.setCurrencyCode(client.getY8xxuxxxbvxxxxxxxxxxdefaultc());//item
                        customIdentity.setMcurrencyCode(client.getK1xxuxxxbvxxxxxxxxxxcurrcode());//merchant
                        customIdentity.setDebug(client.getE9xxfxxrbvxxxxxxxxxxlevel());//Unlike Boolean, boolean cannot have null

                        if(client.getI9xxfxxxbvxxxxxxxxxxloccol() != null ){
                         // set true/false from client
                         skinBean.setLeftShown(client.getI9xxfxxxbvxxxxxxxxxxloccol());
                        }
                        if(client.getI8xxfxxxbvxxxxxxxxxxrepcol() != null ){
                         // set true/false from client
                         skinBean.setIconShown(client.getI8xxfxxxbvxxxxxxxxxxrepcol());
                        }

                        // if user did not choose skin then only use client default
                        if(skinBean.getSkint() ==null){
                         if(client.getJ5xxuxxxbvxxxxxxxxxxhilcolor() != null ){
                          skinBean.setMenuFont(client.getJ5xxuxxxbvxxxxxxxxxxhilcolor());
                         }
                         //
                         if(client.getJ6xxuxxxbvxxxxxxxxxxtextcolor() != null ){
                          skinBean.setMenuFontMobile(client.getJ6xxuxxxbvxxxxxxxxxxtextcolor());
                         }
                         if(client.getM2xxuxxxbvxxxxxxxxxxrepcsize() != null ){
                          skinBean.setMobileMenuFontSize(client.getM2xxuxxxbvxxxxxxxxxxrepcsize());
                         }
                         if(client.getJ7xxuxxxbvxxxxxxxxxxbaccolor() != null ){
                          String fs=client.getJ7xxuxxxbvxxxxxxxxxxbaccolor();                          
                          if(req.getHeader("user-agent").contains("Mobi") && !req.getHeader("user-agent").contains("iPad")){
                           skinBean.setMenuFontSize("12px;");
                          }else{
                           skinBean.setMenuFontSize(client.getJ7xxuxxxbvxxxxxxxxxxbaccolor());
                          }
                         }
                        }
                        //comes here for each home page load, but will count each session short or long as one visit
                        // session will hold the values,  save vistior stats in usagebyperiods
                        // skip bot visits
                        if(usagebyperiods !=null && homePagevisitCount==0){
                         if(reqAgent.contains("bot") || reqAgent.contains("Bot")){
                          homePagebotCount=homePagebotCount+1;
                         }else{
                          homePagevisitCount=homePagevisitCount+1;
                         } 
                         client.setP6xxzxxrbvxxxxxxxxxxlocbaradj(client.getP6xxzxxrbvxxxxxxxxxxlocbaradj()+1); 
                          if(usagebyperiods.getD5xxzc0rbxxxxxxxxxxxperiod0formulae().length() > 15){
                           client.setW2xxuxxxbvxxxxxxxxxxintpassw(usagebyperiods.getD5xxzc0rbxxxxxxxxxxxperiod0formulae().substring(0,15));//paas like digitalocean returns 2 IPs
                          }else{
                          client.setW2xxuxxxbvxxxxxxxxxxintpassw(usagebyperiods.getD5xxzc0rbxxxxxxxxxxxperiod0formulae());//prev 
                          }
                          usagebyperiods.setD5xxzc0rbxxxxxxxxxxxperiod0formulae(userIP);//current
                         //  save in client, use https://www.iplocate.io/api/lookup/8.8.8.8 ip info
                         // or  https://ip2c.org/ip=70.50.20.9
                          fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.clearInstance();
                          fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.setInstance(usagebyperiods);
                          fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.superdotupdate();
                        }else{
                         //logon id is empty unless login was done , count would be 1 or 2 but not 3
                         // in temp user logic like in case,shopping capture not logged in temp user and save in usagebyperiods
                         if(usagebyperiods !=null && homePagevisitCount < 3 && !logonId.isEmpty() ){
                          if(logonId.length()>10){
                           client.setZ1xxuxxxbvxxxxxxxxxxlastuser(usagebyperiods.getD3xxul0rbvxxxxxxxxxxperiod0label()); 
                           usagebyperiods.setD3xxul0rbvxxxxxxxxxxperiod0label(logonId.substring(0,10));//current
                          }else{
                           client.setZ1xxuxxxbvxxxxxxxxxxlastuser(usagebyperiods.getD3xxul0rbvxxxxxxxxxxperiod0label()); 
                           usagebyperiods.setD3xxul0rbvxxxxxxxxxxperiod0label(logonId);//current     
                          }
                          yxxxch575xwwqqhxxxxxuserprofl=yxxxuh566xwwqqwxxxxxuserList.getUserProfiles();
                          if(yxxxch575xwwqqhxxxxxuserprofl != null){
                           calendare.setTime(yxxxch575xwwqqhxxxxxuserprofl.getZ2xxcztxlxxxxxxxxxxxstatusfldt());
                           String lastVisitDt=new SimpleDateFormat("yyyy.MM.dd").format(yxxxch575xwwqqhxxxxxuserprofl.getZ2xxcztxlxxxxxxxxxxxstatusfldt());
                           client.setW3xxuxxxbvxxxxxxxxxxinrpassw(usagebyperiods.getE3xxul0rbvxxxxxxxxxxperiodtotalslabel()); 
                           usagebyperiods.setE3xxul0rbvxxxxxxxxxxperiodtotalslabel(lastVisitDt);//current
                          }
                          homePagevisitCount=3;
                          fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.clearInstance();
                          fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.setInstance(usagebyperiods);
                          fxxxuq1bhxwwqqhxxxxxusagebyperiodsHome.superdotupdate();
                         }
                        }
                        if(skinBean.ContainsSkin(client.getJ4xxuxxxbvxxxxxxxxxxscrcolor())){
                         skinBean.setSkin(client.getJ4xxuxxxbvxxxxxxxxxxscrcolor());
                        }else{
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_INFO,bundle.getString("invalid")+" "+bundle.getString("client")+" "+bundle.getString("theme")+", "+bundle.getString("value")+" "+client.getJ4xxuxxxbvxxxxxxxxxxscrcolor()+", "+bundle.getString("client")+" "+bundle.getString("record")+" "+bundle.getString("updated")+" "+bundle.getString("to")+" "+bundle.getString("default")+" "+bundle.getString("value")+" "+"r3WhiteModern",""));
                         client.setJ4xxuxxxbvxxxxxxxxxxscrcolor("r3WhiteModern"); 
                        }
                        if(homePagevisitCount ==1 || homePagevisitCount ==3 || !skinBean.ContainsSkin(client.getJ4xxuxxxbvxxxxxxxxxxscrcolor())){ 
                         yxxxch522xhhxxhxxxxxclientHome.setInstance(client);
                         yxxxch522xhhxxhxxxxxclientHome.update();
                         if(homePagevisitCount ==3){
                          homePagevisitCount=4;// dont update anymore for logonId 
                         }
                         if(homePagevisitCount !=4){
                          homePagevisitCount=2;//ie very ist page load ie count 1, so in loop either 2 or 4 now
                         }
                         skinBean.setSkin(client.getJ4xxuxxxbvxxxxxxxxxxscrcolor());
                        }
                      }
                } catch ( Exception ex){
                  log.severe("client record update failed for "+owner2Code+" "+ ex.getCause()+", "+ex.getMessage() );
                  if(ex.getCause() !=null && ex.getCause().getCause()!=null){
                   String rootMsg=ex.getCause().getCause().getMessage();
                   log.severe("more.. "+rootMsg );
                  }
                  //ex.printStackTrace();
                  return "/home-ui.xhtml";//visitor only no backoffice

                }

                      //rmlpassw v1v2 v1 =2 means home gets redirected to home-s(tatic)
                      //v2(client.W5xxuxxxbvxxxxxxxxxxrmlpassw.fn:substring(2,4) =2 means 
                      // use page nav menu not 3R-MENU. give warning about any missing login?. 
                      if(viewUrl != null && !viewUrl.isEmpty()){ 
                       String jay=client.getW5xxuxxxbvxxxxxxxxxxrmlpassw();
                       viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();

                       if(!identity.isLoggedIn() && viewId.contains("home.") && jay !=null && jay.length()>0 && jay.substring(0,1).equals("2")){
                        return "/home-s.xhtml";
                       }
                       if(viewId.contains("home.") && !identity.isLoggedIn()){
                        return "/home-ui.xhtml";
                       }
                       /*
                       if(viewId.contains("ItemDetailsBrowse.") && jay !=null && jay.length()>1 && jay.substring(1,2).equals("2")){
                        return "/ItemDetailsBrow-s.xhtml";
                       }
                       */
                      }
                      return "";

        }

        public void setUserChosenSkin(){

          // set skin to user default value as part of login ie this bean(authenticator) calls this method as part of login method
          // look into using menu font style as well but need to increase field sizes
                 if(skinBean.getSkint() !=null){
                  skinBean.setSkin(skinBean.getSkint());
                  return;
                 }
                      yxxxch575xwwqqhxxxxxuserprofl=yxxxuh566xwwqqwxxxxxuserList.getUserProfiles();
                      //if not loggedIn there is no profile
                      if (!identity.isLoggedIn()){
                       return;
                      } 
                      if(yxxxch575xwwqqhxxxxxuserprofl==null){
                       if(user == null){
                        return;
                       }
                       //create userprofl record
                       try{          
                        yxxxch575xwwqqhxxxxxuserprofl=yxxxch575xwwqqhxxxxxuserproflHome.createInstance();
                        yxxxch575xwwqqhxxxxxuserprofl=yxxxch575xwwqqhxxxxxuserproflHome.getInstance();
                        yxxxch575xwwqqhxxxxxuserprofl.setYxxxuh566xwwqqwxxxxxuser(user);
                        yxxxch575xwwqqhxxxxxuserprofl.setB1xxuxxrbvxxxxxxxxxxrow("00");
                        yxxxch575xwwqqhxxxxxuserproflHome.setInstance(yxxxch575xwwqqhxxxxxuserprofl);
                        yxxxch575xwwqqhxxxxxuserproflHome.persist();
                       } catch (Exception e) {
			 log.severe("Error accessing userprofl"+ e);
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("user")+ " "+bundle.getString("profile")+ " "+bundle.getString("access")+ " "+bundle.getString("failed")+ " - "+e.getMessage(),""));
                       }
                      }
                      if(yxxxch575xwwqqhxxxxxuserprofl != null && this.country !=null && !this.country.isEmpty()){
                         yxxxch575xwwqqhxxxxxuserprofl.setC3xxuxxrbvxxxxxxxxxxp1(this.country.toLowerCase()); 
                         yxxxch575xwwqqhxxxxxuserproflHome.setInstance(yxxxch575xwwqqhxxxxxuserprofl);
                         yxxxch575xwwqqhxxxxxuserproflHome.update();
                      } 
		      if (yxxxch575xwwqqhxxxxxuserprofl != null) {
                       if(yxxxch575xwwqqhxxxxxuserprofl.getB1xxuxxrbvxxxxxxxxxxscrcolor() != null && !yxxxch575xwwqqhxxxxxuserprofl.getB1xxuxxrbvxxxxxxxxxxscrcolor().isEmpty()){
                        if(skinBean.ContainsSkin(yxxxch575xwwqqhxxxxxuserprofl.getB1xxuxxrbvxxxxxxxxxxscrcolor())){
                         skinBean.setSkin(yxxxch575xwwqqhxxxxxuserprofl.getB1xxuxxrbvxxxxxxxxxxscrcolor());
    
                        }else{
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_INFO,bundle.getString("invalid")+" "+bundle.getString("user")+" "+bundle.getString("theme")+" "+bundle.getString("value")+" "+yxxxch575xwwqqhxxxxxuserprofl.getB1xxuxxrbvxxxxxxxxxxscrcolor()+", "+bundle.getString("updated")+" "+bundle.getString("to")+" "+bundle.getString("default")+" "+bundle.getString("value")+" "+"r3WhiteModern",""));
                         yxxxch575xwwqqhxxxxxuserprofl.setB1xxuxxrbvxxxxxxxxxxscrcolor("r3WhiteModern"); 
                         yxxxch575xwwqqhxxxxxuserprofl.setC3xxuxxrbvxxxxxxxxxxp1(this.country.toLowerCase()); 
                         yxxxch575xwwqqhxxxxxuserproflHome.setInstance(yxxxch575xwwqqhxxxxxuserprofl);
                         yxxxch575xwwqqhxxxxxuserproflHome.update();
                         skinBean.setSkin(yxxxch575xwwqqhxxxxxuserprofl.getB1xxuxxrbvxxxxxxxxxxscrcolor());

                        }

                       }  
                      }

        }
        public void logOutA(){

                 //not used cant inject in customIdentity mark user as status 1 ie not logged in any more
                 // compromise soln is to check statusfl update datetime
 		  results =  entityManager
 					.createQuery(
 							"select c from Yxxxuh566xwwqqwxxxxxuser c where c.a0xxukuxbvxxxxxxxxxxid = :username and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 					.setParameter("username", logonId)
 					.setParameter("owner2", owner2Code)
 					.getResultList();
                  if(results.isEmpty()){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_INFO,bundle.getString("user")+" "+logonId+" "+bundle.getString("record")+" "+bundle.getString("not")+" "+bundle.getString("founf"),""));
                  }
                  user=results.get(0);
                  user.setZ1xxzzfxhhxxxxxxxxxxstatusfl(mactive);
                  yxxxuh566xwwqqwxxxxxuserHome.clearInstance();
                  yxxxuh566xwwqqwxxxxxuserHome.setInstance(user);
                  yxxxuh566xwwqqwxxxxxuserHome.superUpdate();//status date updated
       }
       public void logInA(){
                 // change statusfldt to indicale last/recent login 
 		  results =  entityManager
 					.createQuery(
 							"select c from Yxxxuh566xwwqqwxxxxxuser c where c.a0xxukuxbvxxxxxxxxxxid = :username and c.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 					.setParameter("username", logonId)
 					.setParameter("owner2", owner2Code)
 					.getResultList();
                  if(results.isEmpty()){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_INFO,bundle.getString("user")+" "+logonId+" "+bundle.getString("record")+" "+bundle.getString("not")+" "+bundle.getString("founf"),""));
                  }
                  user=results.get(0);
                  //user.setZ1xxzzfxhhxxxxxxxxxxstatusfl(2);//2 mcopy skip until logout can update back
                  yxxxuh566xwwqqwxxxxxuserHome.clearInstance();
                  yxxxuh566xwwqqwxxxxxuserHome.setInstance(user);
                  yxxxuh566xwwqqwxxxxxuserHome.superUpdate();//status date updated



       }                   


  public String check() {
    if (!identity.isLoggedIn()) {
        return "error.xhtml?faces-redirect=true";
    } else {
        return null;
    }
  }

/**
* method is used to check if database and tables already exist
* if not they will be created
* @param none
* @return false if exception, otherwise true if exists or true after creating tables
*/    

 public boolean checkCreateTables(){
      //using jdbc connection to get database metadata rather than entitymanager way to be ORM neutral
      DatabaseMetaData databaseMetaData=null;
      String productName="";
      String tableName="CLIENT_C";//use all upper case
      Connection conn =null;
      try{
       conn = getConnection();
       databaseMetaData = conn.getMetaData();
       productName = databaseMetaData.getDatabaseProductName();
      } catch (Exception e) {
       log.severe("No datasouce connection or databaseMetaData, Cannot continue");
       return false; 
      }finally{
       if(conn != null){
        try{
         conn.close();
        }catch (Exception e) {
         log.severe("conn.close exception");
         return false; 
        }
       }
      }
      //at this point finally clause should have closed the connection
      if(productName==null || productName.isEmpty()){
       log.severe("No datasource setup yet, check tomee.xml or standalone.xml etc. Cannot continue");
       if(conn != null){
        try{
         conn.close();
        }catch (Exception e) {
         log.severe("conn.close exception");
         return false; 
        }
       }
       return false;
      }
      if(productName.contains("PostgreSQL")){
        tableName="client_c";
      }
      try{
       ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, new String[] {"TABLE"});
       if(resultSet.next()){
        return true;//if next exists then true, no need to continue if client_c exists
       }
       tableName="CLIENT";
       if(productName.contains("PostgreSQL")){
        tableName="client";
       }
       resultSet = databaseMetaData.getTables(null, null, tableName, new String[] {"TABLE"});
       if(resultSet.next()){
        return true;//if next exists then true, no need to continue if client exists
       }
      } catch (Exception e) {
       log.severe("No tables info from databaseMetaData, Cannot continue");
       return false; 
      }finally{
       if(conn != null){
        try{
         conn.close();
        }catch (Exception e) {
         log.severe("conn.close exception");
         return false; 
        }
       }
      }

      log.info(" checkCreateTables-DB Name "+ productName+ "- creating schema,tables,tables_b and tables_c");
      if(productName.contains("HSQL")){
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_INFO,"After site create is done, please login using id manager and password manager or admin with password admin. ",""));
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_WARN,"Temporary passwords will EXPIRE in 48 hrs. Please change the employee and client email id if mail@"+owner2Code+".com is not a working one. ",""));
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_WARN,"Reset or change password commands will send passwords via email and you will not see it, if email id is invalid . ",""));

       sqlAdminSupport.createSchema("","","");//product hql,schema genapp,owner sa
       sqlAdminSupport.createTables("","");//dbproduct,schema
       sqlAdminSupport.createTables_b("","");
       sqlAdminSupport.createTables_c("","");
       //create system messages
       yxxxuq1r1xwwqqhxxxxxresourceHome.copyDefaultMessagesToSYSTEM();//default for master and future tenant sites 
       String emailId="mail@"+owner2Code+customIdentity.getTld();
       if(customIdentity.getTld() ==null || customIdentity.getTld().isEmpty()){
        emailId="mail@"+owner2Code+".com";
       }
       // create master site with 2 default users, log the password because email is valid but dummy
       yxxxuh566xwwqqwxxxxxuserHome.doMasterSite(owner2Code,emailId);
       file.preLoadThemes(); // loads  csv themes from root.war/WEB-INF/resources/csv dir 
       return true;
      }
      if(productName.contains("SQLite")){
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_INFO,"After site create is done, please login using id manager and password manager or admin with password admin. ",""));
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_WARN,"Temporary passwords will EXPIRE in 48 hrs. Please change the employee and client email id if mail@"+owner2Code+".com is not a working one. ",""));
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_WARN,"Reset or change password commands will send passwords via email and you will not see it, if email id is invalid . ",""));

       sqlAdminSupport.createSchema("lsql","","");//product lsql,schema genapp,owner none
       sqlAdminSupport.createTables("lsql","");//dbproduct,schema
       sqlAdminSupport.createTables_b("lsql","");
       sqlAdminSupport.createTables_c("lsql","");
       //create system messages
       yxxxuq1r1xwwqqhxxxxxresourceHome.copyDefaultMessagesToSYSTEM();//default for master and future tenant sites 
       String emailId="mail@"+owner2Code+customIdentity.getTld();
       // create master site with 2 default users, log the password because email is valid but dummy
       yxxxuh566xwwqqwxxxxxuserHome.doMasterSite(owner2Code,emailId);
       file.preLoadThemes(); // loads  csv themes from root.war/WEB-INF/resources/csv dir 
       return true;
      }

      if(productName.contains("PostgreSQL")){
       sqlAdminSupport.createSchema("psql","","postgres");//product psql,schema genapp,owner postgres
       sqlAdminSupport.createTables("psql","");//product,schema
       sqlAdminSupport.createTables_b("psql","");
       sqlAdminSupport.createTables_c("psql","");
       //create system messages
       yxxxuq1r1xwwqqhxxxxxresourceHome.copyDefaultMessagesToSYSTEM();//default for master and future tenant sites 
       String emailId="mail@"+owner2Code+customIdentity.getTld();
       if(customIdentity.getTld() ==null || customIdentity.getTld().isEmpty()){
        emailId="mail@"+owner2Code+".com";
       }
       // create master site with 2 default users, log the password because email is valid but dummy
       yxxxuh566xwwqqwxxxxxuserHome.doMasterSite(owner2Code,emailId);
       file.preLoadThemes();
       return true;
      }
       
      return false;

  }
	private Connection getConnection() throws SQLException, NamingException {
		return getDataSource().getConnection();
	}
	private DataSource getDataSource() throws NamingException {
                        String serverName=contextS.getServerInfo();//jun10 2021 check if tomcat or wildfly
                        if(serverName.contains("omcat")){
                         tomeeYN=true;
                        }
                        if (ds == null) {
                         Context ctx = new InitialContext();
                         if(tomeeYN){//jun10 2021
                          ds = (DataSource) ctx.lookup("java:openejb/Resource/RaaspiSQLDS");  
                         }else{
                          ds = (DataSource) ctx.lookup("RaaspiSQLDS");   
                         }
                       }
                      return ds;
	}



 
}
