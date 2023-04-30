package com.rcomputer.genapp.action;
import java.io.Serializable;
import com.rcomputer.genapp.model.*;

import javax.ejb.Startup;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Alternative;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.picketlink.Identity;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.IdentityManagementException;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.authentication.AuthenticationException;
import org.picketlink.common.exceptions.PicketLinkException;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.persistence.*;

/**
* This is Action class
* comes here from login page which call login() method
* which in turn calls Authenticator authenticate() method()
* increases session time out to 40mts from visitor 10mts, if loggedIn
* @author 3r Computer Systems
*/

@Named("customIdentity")
@SessionScoped

public class CustomIdentity implements Serializable{
   private Logger log = Logger.getLogger(CustomIdentity.class.getCanonicalName());
   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;

   @Inject
   private Identity identity;
   @Inject
    private Instance<RelationshipManager> relationshipManager;
   @Inject
    private Instance<IdentityManager> identityManager;
   @Inject
     Yxxxch522xhhxxhxxxxxclientList yxxxch522xhhxxhxxxxxclientList;
  Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient;
  private String owner="sss";
  private Integer ownerSid=0;
  private Integer userSid=0;
  private String owner2="raaspi";
  private String masterSiteCode="";
  private String masterSiteEmail="";
  private String masterSiteUrl="";
  private String restrict1="";
  private String restrict2="";
  private String restrict3="";
  private String allow1="";
  private String allow2="";
  private String allow3="";
  private String product="x";
  private String subproduct="x";
  private String size="S";
  String curracperiod = "";
  private String currcaldates;
  private String currbusdates;
  private String option16;
  private String msgKey;
  private String msgTempKey;//not used
  private String msgPermKey;//not used
  private String msgValue;
  private String labelView="VM";
  private String mobileView="";
  private int urlIndex=0;
  private String username="";
  private String role="";
  private String holdValue="";
  private String holdValue2="";
  private String holdValue3="";
  private String smUid=null;
  private String clientMsgLevel="EWI";// D details or debug, E error W warn I info
  private String clientLoggingLevel="M";
  private String imailaddr="";
  private BigDecimal discountValue=BigDecimal.ZERO;//set by itemhome addproducttoorder and used in
  private String discountType="";//DC% if percent
     String currencySymbol="$";
     String mcurrencySymbol="$";
     String currencyCode="USD";
     String mcurrencyCode="CAD";
     BigDecimal convRate=new BigDecimal("1.0");
     	private boolean applyTax1 = false;
	private boolean applyTax2 = false;
	private boolean applyTax3 = false;
  private String keyValue="";
  private String keyValue2="";
  private String keyValue3="";
  private boolean debug = false;
  private String[] holdArray=new String[200];
  String loggedTimeOut="40";
    //
    @PostConstruct
    public void initialize() {
     ExternalContext externalContext=null;
     String urlName="";
     try{
      FacesContext facesContext = FacesContext.getCurrentInstance();
        //log.severe("jay customIdentity initialize facesContext: "+facesContext+" "+masterSiteEmail+" "+masterSiteCode+" "+masterSiteUrl);

      if(facesContext != null ){
       externalContext = facesContext.getExternalContext();
       urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();
       urlIndex=urlName.lastIndexOf(".");
       if (urlIndex == -1){
        urlIndex=urlName.length();
       }
       if (urlName.contains("www.")){
        owner2=urlName.substring(4,urlIndex);
       }else{
        owner2=urlName.substring(0,urlIndex);
       }
          //extract subdomain if used. if subdomain, masterSiteCode will have a value
         if(!this.getMasterSiteCode().isEmpty()){
          owner2=owner2.replace("."+this.getMasterSiteCode(),"");
         }
         if(owner2.length() >40){
                  log.severe("owner2Code "+owner2+" exceeds 40 ch, cannot continue");
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,"owner2Code"+" "+owner2+" "+"exceeds 40 ch cannot continue",""));
                  return;
        }
       Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient=null;
       List<Yxxxch522xhhxxhxxxxxclient> results=null;
       try{
        if(entityManager == null){
         log.severe("Error at customIdentity initialize() "+"entityManager: null for "+owner2);
        }
        results = entityManager
	.createQuery(
	"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName AND cc.f2xxfxxxbvxxxxxxxxxxlooseit=:masterYN")
	.setParameter("nKeyName","01")
	.setParameter("masterYN", true)
	.getResultList();
       }catch(Exception e){
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        //FacesMessage.SEVERITY_ERROR,"customIdentity initialize() MasterSite Client record read error "+e.getMessage(), ""));
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        //FacesMessage.SEVERITY_ERROR,"This error happens until MasterSite is created and server is stopped and started ", ""));
        log.severe("customIdentity initialize() MasterSite Client record read error "+e.getMessage());
        log.info("This error happens until MasterSite is created and server is stopped and started ");
        return;
       }
       if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,"customIdentity initialize() Client multiple entries",""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,"first one used, delete duplicates", ""));
       }
       if(results.size() >0){
        masterSiteEmail=results.get(0).getD3xxhxxrbv44xxxxxxxxlmailaddr();
        masterSiteCode=results.get(0).getZzxxu2oxxhxxxxxxxxxxowner2();
        masterSiteUrl=results.get(0).getD6xxuxxrbvxxxxxxxxxxintaddr();
        //www. and .yy or .zz already removed from url, owner2 value now can be xxx or xxx.masterSiteCode
        // extract xxx part if subdomain is used and make it site owner2 value
        if(!this.getMasterSiteCode().isEmpty()){
         owner2=owner2.replace("."+masterSiteCode,"");
        }
       }
       //log.severe("jay values: "+masterSiteEmail+" "+masterSiteCode+" "+masterSiteUrl);
       loggedTimeOut=externalContext.getInitParameter("loggedTimeOut");
       if(loggedTimeOut==null || loggedTimeOut.isEmpty()){
        log.severe("Error loggedTimeOut from web.xml context: "+ loggedTimeOut);
        loggedTimeOut="40";
       }
      }//end of facesContext check
     } catch (Exception e) {
        log.severe("Error at customIdentity initialize() "+"externalContext: "+externalContext+" url: "+urlName+" error: "+ e.getMessage());
     }
    }




    /**
    * The following getter and setter methods are for convenience and for performance ie avoid db access
    * The actual values are set mostly by Authenticator which is called by takeaction in home page
    * or during login
    * @exception none.
    * @see
    * authenticator
    */

	public String getImailaddr() {
		return imailaddr;
	}

	public void setImailaddr(String imailaddr) {
		this.imailaddr = imailaddr.trim();// avoid blank space at end, if copy paste
	}


  public String getClientMsgLevel() {
    return clientMsgLevel;
  }

  public void setClientMsgLevel(String clientMsgLevel) {
    this.clientMsgLevel = clientMsgLevel;
  }

  public String getClientLoggingLevel() {
    return clientLoggingLevel;
  }

  public void setClientLoggingLevel(String clientLoggingLevel) {
    this.clientLoggingLevel = clientLoggingLevel;
  }


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  public String getHoldValue() {
    return holdValue;
  }

  public void setHoldValue(String holdValue) {
    this.holdValue = holdValue;
  }

  public String getHoldValue2() {
    return holdValue2;
  }

  public void setHoldValue2(String holdValue2) {
    this.holdValue2 = holdValue2;
  }

  public String getHoldValue3() {
    return holdValue3;
  }

  public void setHoldValue3(String holdValue3) {
    this.holdValue3 = holdValue3;
  }

  public String getKeyValue() {
    return keyValue;
  }

  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }

public String getHoldArray(int index)
{
 return holdArray[index];
}

public void setHoldArray(int index,String value)
{
 this.holdArray[index] = value;
}

  public String getKeyValue2() {
    return keyValue2;
  }

  public void setKeyValue2(String keyValue2) {
    this.keyValue2 = keyValue2;
  }

  public String getKeyValue3() {
    return keyValue3;
  }

  public void setKeyValue3(String keyValue3) {
    this.keyValue3 = keyValue3;
  }


  public BigDecimal getDiscountValue() {
    return discountValue;
  }

  public void setDiscountValue(BigDecimal discountValue) {
    this.discountValue = discountValue;
  }

  public String getDiscountType() {
    return discountType;
  }

  public void setDiscountType(String discountType) {
    this.discountType = discountType;
  }

 // ownersid is user employee sid
  public Integer getOwnerSid() {
    return ownerSid;
  }

  public void setOwnerSid(Integer ownerSid) {
    this.ownerSid = ownerSid;
  }


  public Integer getUserSid() {

    return userSid;
  }

  public void setUserSid(Integer userSid) {
    this.userSid = userSid;
  }

       public String getMcurrencySymbol() {
        return mcurrencySymbol;
       }

       public String getCurrencySymbol() {
        return currencySymbol;
       }

       public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
       }
       public void setMcurrencySymbol(String mcurrencySymbol) {
        this.mcurrencySymbol = mcurrencySymbol;
       }


       public String getCurrencyCode() {
        return currencyCode;
       }

       public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
       }

       public String getMcurrencyCode() {
        return mcurrencyCode;
       }

       public void setMcurrencyCode(String mcurrencyCode) {
        this.mcurrencyCode = mcurrencyCode;
       }

       public BigDecimal getConvRate() {
        return convRate;
       }

       public void setConvRate(BigDecimal convRate) {
        this.convRate = convRate;
       }

     //
     public boolean isMasterSite(){
      if(masterSiteCode.equals(owner2)){
       return true;
      }else{
       return false;
      }
     }
     public String getMasterSiteCode(){
        //log.severe("jay get values: "+masterSiteEmail+" "+masterSiteCode+" "+masterSiteUrl);

      return masterSiteCode;
    }

    public void setMasterSiteCode(String masterSiteCode) {
     this.masterSiteCode = masterSiteCode;
    }


     public String getMasterSiteEmail(){
      return masterSiteEmail;
    }

    public void setMasterSiteEmail(String masterSiteEmail) {
     this.masterSiteEmail = masterSiteEmail;
    }

    public String getMasterSiteUrl(){
      return masterSiteUrl;
    }

    public void setMasterSiteUrl(String masterSiteUrl) {
     this.masterSiteUrl = masterSiteUrl;
    }


  public String getOwner2() {
       return owner2;

  }

  public void setOwner2(String owner2) {
    this.owner2 = owner2;
  }


  public String getRestrict1() {
    return restrict1;
  }

  public void setRestrict1(String restrict1) {
    this.restrict1 = restrict1;
  }

  public String getRestrict2() {
    return restrict2;
  }

  public void setRestrict2(String restrict2) {
    this.restrict2 = restrict2;
  }

  public String getRestrict3() {
    return restrict3;
  }

  public void setRestrict3(String restrict3) {
    this.restrict3 = restrict3;
  }

  public String getAllow1() {
    return allow1;
  }

  public void setAllow1(String allow1) {
    this.allow1 = allow1;
  }


  public String getAllow2() {
    return allow2;
  }

  public void setAllow2(String allow2) {
    this.allow2 = allow2;
  }

  public String getAllow3() {
    return allow3;
  }

  public void setAllow3(String allow3) {
    this.allow3 = allow3;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getMsgKey() {
    return msgKey;
  }

  public void setMsgKey(String msgKey) {
    this.msgKey = msgKey;
  }
  //not used
  public String getMsgTempKey() {
    return msgTempKey;
  }

  public void setMsgTempKey(String msgTempKey) {
    this.msgTempKey = msgTempKey;
  }
  //not used
  public String getMsgPermKey() {
    return msgPermKey;
  }

  public void setMsgPermKey(String msgPermKey) {
    this.msgPermKey = msgPermKey;
  }


  public String getMsgValue() {
    return msgValue;
  }

  public void setMsgValue(String msgValue) {
    if (msgValue == null || msgValue.isEmpty()){
     this.msgValue = "No value set";
    }else{
    this.msgValue = msgValue;
    }
  }

  public String getLabelView() {
    return labelView;
  }

  public void setLabelView(String labelView) {
    this.labelView = labelView;
  }

  public String getMobileView() {
    return mobileView;
  }

  public void setMobileView(String mobileView) {
    this.mobileView = mobileView;
  }

  public String getSubProduct() {
    return subproduct;
  }

  public void setSubProduct(String subproduct) {
    this.subproduct = subproduct;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getCurrcaldates() {
    return currcaldates;
  }

  public void setCurrcaldates(String currcaldates) {
    this.currcaldates = currcaldates;
  }

  public String getCurrbusdates() {
    return currbusdates;
  }


  public void setCurrbusdates(String currbusdates) {
    this.currbusdates = currbusdates;
  }

  public String getCurracperiod() {
  	 return curracperiod;
  }
  public void setCurracperiod(String curracperiod) {
    this.curracperiod = curracperiod;
  }

  public String getOption16() {
    return option16;
  }

  public void setOption16(String option16) {
    this.option16 = option16;
  }
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

    public String getSmUid() {
        return smUid;
    }
    public void setSmUid(String smUid) {
        this.smUid = smUid;
    }


    public boolean hasRole(String roleName) {
        if(role != null && this.role.equals(roleName)) {
         return true;
        }else{
         return false;
        }
    }
    private IdentityManager getIdentityManager() {
        return this.identityManager.get();
    }

     public boolean isApplyTax1() {
         return applyTax1;//default false
     }

     public void setApplyTax1(boolean applyTax1){
      this.applyTax1=applyTax1;
     }

     public boolean isApplyTax2() {
         return applyTax2;//default false
     }

     public void setApplyTax2(boolean applyTax2){
      this.applyTax2=applyTax2;
     }
     public boolean isApplyTax3() {
         return applyTax3;//default false
     }

     public void setApplyTax3(boolean applyTax3){
      this.applyTax3=applyTax3;
     }
     public boolean isDebug() {
         return debug;//default false
     }

     public void setDebug(boolean debug){
      this.debug=debug;
     }


/*
    private Identity getIdentity() {
        return this.identity;
    }
*/
  public String login() {
                 ExternalContext extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                 HttpServletRequest req = (HttpServletRequest) extCtxt.getRequest();
                 HttpSession session = req.getSession(false);
                 if(session != null){
                  // was picking up prev user's roles if same browser session
                  //session.invalidate();
                 }
                 session=req.getSession();
                 AuthenticationResult result = this.identity.login();//ends up calling identity extension Authenticator authenticate()
                 if (AuthenticationResult.FAILED.equals(result)) {
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,"Authentication was unsuccessful.  Please check your username and password " + "before trying again.",""));
                  return null;
                 }else{
                  // increase session time out to 40 mts 40*60 secs from standard 10 mts 10*60 secs
                  //if attack comes every sec then max session 500 will be reached in 8 mts but in another
                  // 2 mts ie 10 mts session time out, oldest will be removed. The IP/user agent should prevent it. We may make 500 to 700
                  //look into standard as 5*60 and check url if invoice.cart or checkout then 10*60
                  if(identity.isLoggedIn()){
                   //session.setMaxInactiveInterval(2400);//40 mts
                   int timeOut=Integer.parseInt(loggedTimeOut)*60;
                   session.setMaxInactiveInterval(timeOut);//40 mts
                  }

                  return "home?faces-redirect=true";
                 }

  }
  public String logout() {
                 this.setSmUid(null);
                 ExternalContext extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                 HttpServletRequest req = (HttpServletRequest) extCtxt.getRequest();
                 HttpSession session = req.getSession(false);
                 if(session != null){
                  // prevents prev user loggedIn status using session cookie
                  session.invalidate();
                 }



            identity.logout();
            return "/home.xhtml?faces-redirect=true";//avoid pageCount but need to reload during login
  }

  public void onActive() {
        //send msg based on current view page
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Browser activity detected before server session timeout", "save any unsaved data or send Email before session ends, in case session expires"));
  }

}
