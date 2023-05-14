package com.rcomputer.genapp.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rcomputer.genapp.action.*;
import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.Remove;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.net.URI;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

import org.apache.http.client.ClientProtocolException;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Sale;
import com.paypal.api.payments.Refund;
import com.paypal.api.payments.Authorization;
import com.paypal.api.payments.Capture;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Address;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.ChargeModels;
import com.paypal.api.payments.Currency;
import com.paypal.api.payments.MerchantPreferences;
import com.paypal.api.payments.PaymentDefinition;
import com.paypal.api.payments.Plan;
import com.paypal.api.payments.Patch;
import com.paypal.api.payments.Agreement;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import com.paypal.core.rest.OAuthTokenCredential;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import com.squareup.connect.ApiClient;
import com.squareup.connect.ApiException;
import com.squareup.connect.api.PaymentsApi;
import com.squareup.connect.auth.OAuth;
import com.squareup.connect.models.*;
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
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import javax.faces.context.Flash;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
* This supports shopping cart actions like payments for cards like Paypal, Square.
* comes here from checkout.xhtml for online purchase and payment or checkoutPOS.xhtml for in person purchase and payment. 
* pages invoke appropriate methods via view action calling takeAction or directly calling a method here.
*
*   saleRequest() method called by checkout.xhtml paypal checkout buttn and call paypal api. cuorders already exists
*   invoke paypal login page express payment request via  checkout.xhtml link button value approvalUrl / login to paypal
*   paypal invokes makePayPalPayment method via f:viewAction in checkout.xhtml and takeAction method here to capture shipping info
*   and to show confirmpayment button
*   confirmPayment method called by checkout.xhtml payment execution request via payment module execute method
*     calls itemHome.updateProductsToShip to create invoice against which shipment to be done
* 
*   Note:There is confirmPayPayment which calls updateInvoicesToPay to update existing invoice
* there are 4 rest supporting module
* (1)shoppingCartBean is a restClient meant for payPal and uses paypal restClient apis(why does it have rest jar?)
* (2)R3RestClient is also a restClient but meant for Shopify and uses jax-rs apis
* (3)xxxPie/BarCharts uses javaScript based rest client to call 3r xxxEntityServices
* (4)xxxEntityService beans not client but server rest services and called by rest clients
*
* @author 3r Computer Systems
*/
@Named("r3Cart")
@SessionScoped
//@Transactional  removed was causing resourceloading issue You cannot set autocommit during a managed transaction


public class ShoppingCartBean implements java.io.Serializable{
   private Logger log = Logger.getLogger(ShoppingCartBean.class.getCanonicalName());

   @Inject
   Fpxxfq1a5xwwqqhxxxxxitemHome fpxxfq1a5xwwqqhxxxxxitemHome;
   @Inject
   Fpxxfq1a5xwwqqhxxxxxitemList fpxxfq1a5xwwqqhxxxxxitemList;
   @Inject
   Yxxxch522xhhxxhxxxxxclientList yxxxch522xhhxxhxxxxxclientList;
   Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient;
   @Inject
   Trexuq244xwwqqhxxxxxcuordersList trexuq244xwwqqhxxxxxcuordersList;
   @Inject
   Trexuq244xwwqqhxxxxxcuordersHome trexuq244xwwqqhxxxxxcuordersHome;
   private Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders;

   @Inject
   Jxxxuq201xwwqqhxxxxxcustomerHome jxxxuq201xwwqqhxxxxxcustomerHome;
   private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
   @Inject
   Trexuq266xwwqqhxxxxxcuinvoiceList trexuq266xwwqqhxxxxxcuinvoiceList;
   @Inject CustomIdentity customIdentity;
   @Inject
   Jxxxuq201xwwqqhxxxxxcustomerList jxxxuq201xwwqqhxxxxxcustomerList;
   @Inject
   Trexuq277xwwqqhxxxxxcpaymentHome trexuq277xwwqqhxxxxxcpaymentHome;
   @Inject
   Xoxxuq284xwwqqhxxxxxcupdetailsHome xoxxuq284xwwqqhxxxxxcupdetailsHome;
   @Inject
   Fxxxuq111xwwqqhxxxxxaddressHome fxxxuq111xwwqqhxxxxxaddressHome;
   private Fxxxuq111xwwqqhxxxxxaddress fxxxuq111xwwqqhxxxxxaddress;

   private Boolean inSaleReady=true;
   private Boolean inPaycReady=true;
   private Boolean inPayment=false;
   private Boolean inApproved=false;
   private Boolean inConfirmed=false;
   private Boolean inPDSaleReady=true;
   private Boolean inPDPayment=false;
   private Boolean inPDApproved=false;
   private Boolean inPDConfirmed=false;
   private Boolean inAuthCaptureMode=false;
   private Boolean inSaleNAprove=false;
   private String guid="";
   Map<String, String> map = new HashMap<String, String>();
   Map<String, String> configurationMap = new HashMap<String, String>();
   APIContext apiContext = null;
   ExternalContext extCtxt = null;
   HttpServletRequest httpreq = null;
   String approvalUrl="";
   String payerId="";
   String accessToken="";
   String clientId="";
   String clientSecret="";
   Boolean bcontinue=true;
   String vEmailAddress="";
   String vEmailAddress2="";
   String transactionId;
   String line1="";
   String line2="";
   String city="";
   String state="";
   String postalCode="";
   String fName="";
   String lName="";
   String payerEmail="";
   String url=null;
   String currCode="CAD";//merchant/bank currency
   String currSymb="C$";
   String defaultc="CAD";//item/customer currency
   String keyorder="C$";
   String orderTerm="";
   private ResourceBundle bundle=null;
   private FacesContext facesContext=null;

   String authorizationID ="";
   String viewId="";
   private String clientMsgLevel="EWI";// D details or debug, E error W warn I info
   private String invoiceKey="";
  // The environment variable containing a Square Personal Access Token.
    // This must be set in order for the application to start.
    private static final String SQUARE_ACCESS_TOKEN_ENV_VAR = "SQUARE_ACCESS_TOKEN";

    // The environment variable containing a Square application ID.
    // This must be set in order for the application to start.
    private static final String SQUARE_APP_ID_ENV_VAR = "SQUARE_APP_ID";

    // The environment variable containing a Square location ID.
    // This must be set in order for the application to start.
    private static final String SQUARE_LOCATION_ID_ENV_VAR = "SQUARE_LOCATION_ID";

    // The environment variable indicate the square environment - sandbox or production.
    // This must be set in order for the application to start.
    private static final String SQUARE_ENV_ENV_VAR = "SQUARE_ENV";
         ApiClient squareClient = null;

   private Boolean inPosMode=false;
   private Boolean inCodMode=false;
   protected Plan instance = null;


    @PostConstruct
    public void initialize() {
      facesContext = FacesContext.getCurrentInstance();
      bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");

    }

  public Boolean getInPosMode() {
    return inPosMode;
  }

  public Boolean getInSaleReady() {
    return inSaleReady;
  }

  public Boolean getInPaycReady() {
    return inPaycReady;
  }

  public Boolean getInPayment() {
    return inPayment;
  }


 public Boolean getInApproved() {
    return inApproved;
  }

 public Boolean getInConfirmed() {
    return inConfirmed;
  }

  public Boolean getInPDSaleReady() {
    return inSaleReady;
  }

  public Boolean getInPDPayment() {
    return inPDPayment;
  }


 public Boolean getInPDApproved() {
    return inPDApproved;
  }

 public Boolean getInPDConfirmed() {
    return inPDConfirmed;
  }

  public String getVEmailAddress() {
    return vEmailAddress;
  }

  public void setVEmailAddress(String vEmailAddress) {
    this.vEmailAddress=vEmailAddress;
  }

  public String getVEmailAddress2() {
    return vEmailAddress2;
  }

  public void setVEmailAddress2(String vEmailAddress2) {
    this.vEmailAddress2=vEmailAddress2;
  }

  public String getGuid() {
    return guid;
  }


  public String getPayerId() {
    return payerId;
  }

  public String getApprovalUrl() {
    return approvalUrl;
  }

 public Boolean getInAuthCaptureMode() {
    return inAuthCaptureMode;
  }

 public void setInAuthCaptureMode(boolean inAuthCaptureMode ) {
    this.inAuthCaptureMode = inAuthCaptureMode;
  }



  public String getInvoiceKey() {
    return invoiceKey;
  }

  public void setInvoiceKey(String invoiceKey) {
    this.invoiceKey= invoiceKey;
  }


  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1= line1;
  }

  public String getLine2() {
    return line2;
  }
  public String getCity() {
    return city;
  }
  public String getState() {
    return state;
  }

  public String getPostalCode() {
    return postalCode;
  }
  public String getFName() {
    return fName;
  }
  public String getLName() {
    return lName;
  }
  public String getPayerEmail() {
    return payerEmail;
  }

  public String takeAction(){
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        flash.setKeepMessages(true);

    String state="";
    String owner2_url="";
    String cartOrder="";
    String oOwner2Code="";
    viewId =  FacesContext.getCurrentInstance().getViewRoot().getViewId();
    if (viewId.contains("checkout.") || viewId.contains("checkoutPOS.") || viewId.contains("checkoutinvoiced") || viewId.contains("paymentout.")){
     extCtxt = FacesContext.getCurrentInstance().getExternalContext();
     httpreq = (HttpServletRequest) extCtxt.getRequest();
     if (httpreq.getParameter("PayerID") != null ){//paypal
      //String owner2_url=httpreq.getParameter("owner2_url"); use this after oAuth is used for payPal
      try{
       this.makePayPalPayment(httpreq.getParameter("PayerID"),httpreq.getParameter("guid"));
       if(inSaleNAprove){
        confirmPayment();
        inSaleNAprove=false;
       }
      }catch(Exception e){
       inSaleNAprove=false;
       //we get exception since there is no ntgrok locally
       log.severe(e.getMessage());
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("in")+" "+bundle.getString("paypal")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
       bcontinue=false;
      /* use below when oAuth will be used, now it starts and stays in owner2 site
       try{
        if(httpreq.getServerName().contains("8080")){
         //extCtxt.redirect("http://"+owner2_url+".lraaspi.com:8080/checkout.wflow");// needs testing
         extCtxt.redirect("https://"+owner2_url+"/checkout.wflow");
        }else{
         extCtxt.redirect("https://"+owner2_url+"/checkout.wflow");
        }
       }catch(Exception ex){
       }
      */
     }
     return "";
    }
     //ios response is one param called data with Json data block
     //data block is json object and can be {"transaction_id":"xx","status":"ok"}
     // or as {"error_code":"payment_canceled","status":"error"}

     if (httpreq.getParameter("data") != null ){
      try{
       log.info("square_ios_payment data json object= "+ httpreq.getParameter("data"));
       //here it comes via callback after square POS terminal so session variables are not available
       //The square POS app takes care of collecting the payment and return here.
       //if ok it calls addWithDetailsCod to keep RAASPI side in sync
       //{"status":"ok","state":"r3po0000045r3bkhttp:\/\/myorgp.raaspi.com\/checkoutPOS.wflow","transaction_id":"76Tu09z7Y3G97UYuSa4fJE7eV","client_transaction_id":"CBEE9118-76A9-48B7-9BAC-D56D67B19312"} cash
       //{"status":"ok","state":"r3po0000045r3bkhttp:\/\/myorgp.raaspi.com\/checkoutPOS.wflow","transaction_id":"ZDwCaDr5ohvRWI8hARzM9k5eV","client_transaction_id":"BD4DBB1B-3773-4CFD-99DA-EE707260D2E0"} card reader
       //{"error_code":"payment_canceled","status":"error","state":"r3por3bkhttp:\/\/myorgp.3recommerce.com\/checkoutPOS.wflow"}
      //http://raaspi.lraaspi.com:8080/checkoutPOS.wflow?data={"status":"ok","state":"r3po0000138r3o2myorgpr3bkhttp:\/\/myorgp.raaspi.com\/checkoutPOS.wflow","transaction_id":"J70SJZ8izlbEOp2PBl1fSLAfV","client_transaction_id":"0B9DE94A-55FE-43CC-8DED-3C96B54C5B76"}
       String respString= httpreq.getParameter("data");//see r3RestClient for Gson parse
       JsonElement jelement = new JsonParser().parse(respString);
       JsonObject  jobject = jelement.getAsJsonObject();
       state=jobject.getAsJsonPrimitive("state").getAsString();
       if( state != null){
        String[] parts = state.split("r3bk");
        owner2_url = parts[1].replaceAll("\\\\", ""); // link
        parts=parts[0].split("r3o2");
        cartOrder = parts[0].substring(4); // po
        oOwner2Code = parts[1];
        //cartOrder="0000040";
        //owner2_url="https://myorgp.raaspi.com/checkoutPOS.wflow?pos=pos";
       }
       if(state != null){
        if(jobject.getAsJsonPrimitive("error_code") !=null){
         String error= jobject.getAsJsonPrimitive("error_code").getAsString();
         if(error != null){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,error+" "+bundle.getString("Error")+" "+bundle.getString("in")+" "+bundle.getString("square")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
           bcontinue=false;
           extCtxt.redirect(owner2_url);
           return null;
         }
        }
       }
       //no error,
        String status= jobject.getAsJsonPrimitive("status").getAsString();
        if(!status.equals("ok")){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,status+" "+bundle.getString("Error")+" "+bundle.getString("in")+" "+bundle.getString("square")+" "+bundle.getString("response")+" "+bundle.getString("status")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
         bcontinue=false;
         extCtxt.redirect(owner2_url);
         return null;
        }
       //BigDecimal amtIn=jobject.getAsJsonPrimitive("???").getAsString();
       String tranId= jobject.getAsJsonPrimitive("transaction_id").getAsString();
       String clTranId= jobject.getAsJsonPrimitive("client_transaction_id").getAsString();
       log.info(bundle.getString("square_ios_order/url")+" "+cartOrder+" "+owner2_url);

       trexuq277xwwqqhxxxxxcpaymentHome.addWithDetailsPos(cartOrder, tranId,clTranId,oOwner2Code);
       extCtxt.redirect(owner2_url);
       return null;
      }catch(Exception e){
       //we get exception since there is no ntgrok locally
       log.severe(e.getMessage());
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("in")+" "+bundle.getString("square")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
        bcontinue=false;
       try{
         extCtxt.redirect(owner2_url);
       }catch(Exception ex){
        //ignore
       }
      }//catch
       return null;
     }
     // android response comes as parameter values like com.squareup.pos.CLIENT_TRANSACTION_ID="xx"
     // or com.squareup.pos.ERROR_CODE="TRANSACTION_CANCELED"
     //com.squareup.pos.ERROR_TRANSACTION_CANCELED
     if (httpreq.getParameter("com.squareup.pos.REQUEST_METADATA") != null ){//android also gets owner2 via REQUEST_METADATA(state)
      try{
       log.info("#{messages['square_android_metadata']}"+ httpreq.getParameter("com.squareup.pos.REQUEST_METADATA"));
       log.info("#{messages['square_android_cltran']}"+ httpreq.getParameter("com.squareup.pos.CLIENT_TRANSACTION_ID"));
       log.info("#{messages['square_android_tran']}"+ httpreq.getParameter("com.squareup.pos.SERVER_TRANSACTION_ID"));
       log.info("#{messages['square_android_error']}"+ httpreq.getParameter("com.squareup.pos.ERROR_CODE"));
       //here it comes via callback after square POS terminal so session variables are not available
       //The square POS app takes care of collecting the payment and return here.
       //if ok it calls addWithDetailsCod to keep RAASPI side in sync
       //no json just parameter value as string
       //(below method is also called for Cash payment in checkoutPOS and amtin and chqid is used)
       state=httpreq.getParameter("com.squareup.pos.REQUEST_METADATA");
       if( state != null){
        String[] parts = state.split("r3bk");
        owner2_url = parts[1].replaceAll("\\\\", ""); // link
        parts=parts[0].split("r3o2");
        cartOrder = parts[0].substring(4); // po
        oOwner2Code = parts[1];
        //cartOrder="0000040";
        //owner2_url="https://myorgp.raaspi.com/checkoutPOS.wflow?pos=pos";
       }

       String error=httpreq.getParameter("com.squareup.pos.ERROR_CODE");
       if(error != null ){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,error+" "+bundle.getString("Error")+" "+bundle.getString("in")+" "+bundle.getString("square")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
         bcontinue=false;
         extCtxt.redirect(owner2_url);
         return null;
       }
       //no error, so continue jay check whether bean still has values
       log.info(bundle.getString("square_android_order/url")+" "+ cartOrder+" "+owner2_url);

       String tranId= httpreq.getParameter("com.squareup.pos.SERVER_TRANSACTION_ID");
       String clTranId= httpreq.getParameter("com.squareup.pos.CLIENT_TRANSACTION_ID");
       trexuq277xwwqqhxxxxxcpaymentHome.addWithDetailsPos(cartOrder, tranId,clTranId,oOwner2Code);
       extCtxt.redirect(owner2_url);
         return null;
      }catch(Exception e){
       //we get exception since there is no ntgrok locally
       log.severe(e.getMessage());
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("in")+" "+bundle.getString("square")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
       bcontinue=false;
       try{
         extCtxt.redirect(owner2_url);
       }catch(Exception ex){
       }
      }
         return null;
     }
     //see
     if (httpreq.getParameter("nonce") != null ){//square online form also gets owner2_url
      log.info("#{messages['square_form_payment']}"+ httpreq.getParameter("nonce"));
      log.info("#{messages['square_form_payment']}"+ httpreq.getParameter("owner2_url"));
      owner2_url=httpreq.getParameter("owner2_url");
      //checkout square button > onGetCardNonce in ..paymentform.js
      //here calls charge() and sync Raaspi with addWithDetailsCod ??
      extCtxt = FacesContext.getCurrentInstance().getExternalContext();
      httpreq = (HttpServletRequest) extCtxt.getRequest();
      NonceForm form = new NonceForm();
      Map<String, Object> model=new HashMap<String, Object>();
      model.put("appId", "jay009");
      try{
       log.info("#{messages['square_form_payment']}"+ httpreq.getParameter("charge"));
       charge(form, model);//calls charge method below which uses square Payment API
       //checkout paybysquare creates nonce (card info based token) and then
       //The square POS app takes care of collecting the payment and return here.
       //if ok it calls addWithDetailsCod to keep RAASPI side in sync
       //todo handle errors
       //(below method is also called for Cash payment in checkoutPOS and amtin and chqid is used)
       //trexuq277xwwqqhxxxxxcpaymentHome.addWithDetailsCod();
       //return to owner site
       if(httpreq.getServerName().contains("8080")){
        //extCtxt.redirect("http://"+owner2_url+".lraaspi.com:8080/checkout.wflow"); oct09 2021
        extCtxt.redirect("https://"+owner2_url+"/checkout.wflow");
       }else{
        extCtxt.redirect("https://"+owner2_url+"/checkout.wflow");
       }
      }catch(Exception e){
       //we get exception since there is no ntgrok locally
       log.severe(e.getMessage());
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("in")+" "+bundle.getString("square")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
        bcontinue=false;
       try{
        if(httpreq.getServerName().contains("8080")){
         //extCtxt.redirect("http://"+owner2_url+".lraaspi.com:8080/checkout.wflow"); oct09 2021 needs test
         extCtxt.redirect("https://"+owner2_url+"/checkout.wflow");
        }else{
         extCtxt.redirect("https://"+owner2_url+"/checkout.wflow");
        }
       }catch(Exception ex){
       }
      }
      return null;
     }

     //following are not a callback from payment processor, rather set by itemdetailsPOS/cartPOS page to indicate inPosMode
     // so that only logged in backoffice users will use pos for other customers and order>payment only
     // if flag is off customers use for themselves and order>invoice>payment done
     if (httpreq.getParameter("pos") != null ){//online pos set by cart. checkout form needs required field customer to have value
      //visitor/guest checkout form doesnt have this field rendered
      inPosMode=true;//session variable if on will checkSet default value. will be off if visitors or guest
      // allows setting default value in multiple pages as in paypal process
     }
     if (inPosMode){
      checkSetCustomer();
      return "";
     }
     if (httpreq.getParameter("cod") != null ){//online cod set by itemsdetails. checkout form needs required field customer to have value
      //visitor/guest checkout form needs some fields prefilled if COD
      inCodMode=true;//session variable if on will checkSet default value. will be off if visitors or guest
      // allows setting default value in multiple pages as in paypal process
     }
     if (inCodMode){
      checkSetCodCustomer();
       return "";
     }

     if (httpreq.getParameter("categoryJay") != null ){//online cod set by itemsdetails. checkout form needs required field customer to have value
      //visitor/guest checkout form needs some fields prefilled if COD
      //tbd initialize r3. status??
      invoiceKey=httpreq.getParameter("categoryJay");//store as session varaible
      return null;
     }else{
      //log if no match
      log.info("takeAction-no call back match for httpreq.getQueryString "+ httpreq.getQueryString());
     }
    }
     return null;
   }

  public String checkSetCustomer(){
      String userIds="";
      //set amountIn as well used by cash/paypal/sq payment, if there is a cart
      String type="cart";// can also be cod ???
      if (inPosMode){
       type="pos";
      }
      if(fpxxfq1a5xwwqqhxxxxxitemList.getCartedList(type) !=null && fpxxfq1a5xwwqqhxxxxxitemList.getCartedList(type).get(0) != null){
       BigDecimal orderAmount=fpxxfq1a5xwwqqhxxxxxitemList.getCartedList(type).get(0).getTrexuq244xwwqqhxxxxxcuorders().getZ1xxztprlxxxxxxxxxxxamounttotal().setScale(2, RoundingMode.HALF_UP);
       xoxxuq284xwwqqhxxxxxcupdetailsHome.getInstance().setZ6xxzxxxavxxxxxxxxxxamountin(orderAmount);
      }
      try{
       //this.makePayPalPayment(httpreq.getParameter("PayerID"),httpreq.getParameter("guid"));
       log.info("#{messages['pos_payment']}"+ httpreq.getParameter("pos"));
       //get or create generic customer for POS staff's generic customer
       userIds=customIdentity.getUsername().length()>10?customIdentity.getUsername().substring(0,10):customIdentity.getUsername();
       jxxxuq201xwwqqhxxxxxcustomer=jxxxuq201xwwqqhxxxxxcustomerList.getKeyToEntity("customer/"+userIds);
       if(jxxxuq201xwwqqhxxxxxcustomer==null){
        jxxxuq201xwwqqhxxxxxcustomerHome.clearInstance();
        jxxxuq201xwwqqhxxxxxcustomer=jxxxuq201xwwqqhxxxxxcustomerHome.getInstance();
        jxxxuq201xwwqqhxxxxxcustomer.setA0xxukxxbvxxxxxxxxxxcustomer("customer/"+userIds);
        jxxxuq201xwwqqhxxxxxcustomer.setF2xxuwmxbv40xxxxxxxxintegrset("DEFAULT");
        jxxxuq201xwwqqhxxxxxcustomer.setC1xxuslnbvixxxxxxxxxlastname("customerxxx");
        jxxxuq201xwwqqhxxxxxcustomer.setY0xxuzsxbvxxxxxxxxxxdescript("customer/"+userIds);
        jxxxuq201xwwqqhxxxxxcustomerHome.persist();
       }
       if(jxxxuq201xwwqqhxxxxxcustomer.getA0xxukxxbvxxxxxxxxxxcustomer().equals("customer/"+userIds)){
        jxxxuq201xwwqqhxxxxxcustomerHome.setLastjxxxuq201xwwqqhxxxxxcustomerP("customer/"+userIds);
       }else{
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("Customer")+" "+"customer/"+userIds+" "+bundle.getString("not")+" "+bundle.getString("set")+", "+bundle.getString("needs")+" "+bundle.getString("manual")+" "+bundle.getString("selection"),""));
       }
       return "";
      }catch(Exception e){
       //we get exception since there is no ntgrok locally
       if(httpreq.getServerName().contains("ngrok") && httpreq.getServerName().contains("8080") ){
        if(viewId.contains("checkout.")){
         return "raaspi.lraaspi.com:8080/checkout.wflow";
        }else{
         return "raaspi.lraaspi.com:8080/paymentout.wflow";
        }
       }

       log.severe(e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("Customer")+" "+"customer/"+userIds+" "+bundle.getString("not")+" "+bundle.getString("set")+", "+bundle.getString("needs")+" "+bundle.getString("manual")+" "+bundle.getString("selection"),""));

        bcontinue=false;
        return "";
      }
  }

  public String checkSetCodCustomer(){
      String userIds="";
      String type="cod";
      try{
       log.info("#{messages['cod_payment']}"+ httpreq.getParameter("cod"));
       //get customer for current order. There can be temp customer w temp address
       List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);
       Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer = currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer();
       if(jxxxuq201xwwqqhxxxxxcustomer !=null){
        //prefill customerHome.instance for email,names etc. then prefill addressHome.instance values for address
        //for temp, mostly missing, so COD confirm method cuordersHome.updateOrderTermCode needs to save
        //entered values
        jxxxuq201xwwqqhxxxxxcustomerHome.getInstance();
        jxxxuq201xwwqqhxxxxxcustomerHome.setInstance(jxxxuq201xwwqqhxxxxxcustomer);
       }else{
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("Customer")+" "+bundle.getString("record")+" "+bundle.getString("not")+" "+bundle.getString("found")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));
        bcontinue=false;
       }
       fxxxuq111xwwqqhxxxxxaddress=jxxxuq201xwwqqhxxxxxcustomer.getFxxxuq111xwwqqhxxxxxaddressByMailtocode();
       if(fxxxuq111xwwqqhxxxxxaddress !=null){
        fxxxuq111xwwqqhxxxxxaddressHome.getInstance();
        fxxxuq111xwwqqhxxxxxaddressHome.setInstance(fxxxuq111xwwqqhxxxxxaddress);
       }
       return "";
      }catch(Exception e){
       //we get exception since there is no ntgrok locally
       if(httpreq.getServerName().contains("ngrok") && httpreq.getServerName().contains("8080") ){
        if(viewId.contains("checkout.")){
         return "raaspi.lraaspi.com:8080/checkout.wflow";
        }else{
         return "raaspi.lraaspi.com:8080/paymentout.wflow";
        }
       }

       log.severe(e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("Customer")+" "+bundle.getString("record")+" "+bundle.getString("not")+" "+bundle.getString("found")+", "+bundle.getString("needs")+" "+bundle.getString("manual")+" "+bundle.getString("entries"),""));

        bcontinue=false;
        return "";
      }
  }


 public void init(String owner2Code){
           // called by saleRequest method
           // ##Load Configuration
           // Load SDK configuration for
           // the resource. This intialization code can be
           // done as Init Servlet.
           // change the code later to get tenant specific info like paypal account details from client table
           // sdk_config.properties is in genapp.jar copied by build-r3ui.xml
           configurationMap = new HashMap<String, String>();
           //add logic to get the values from client table row
           yxxxch522xhhxxhxxxxxclient = yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("01");
           clientMsgLevel="EWI";// D details or debug, E error W warn I info
           String clCurrCode=yxxxch522xhhxxhxxxxxclient.getK1xxuxxxbvxxxxxxxxxxcurrcode();
           if (clCurrCode != null && !clCurrCode.isEmpty()){
            currCode=clCurrCode;//merchant/bank
           }
           String clCurrSymb=yxxxch522xhhxxhxxxxxclient.getJ9xxuxxxbvxxxxxxxxxxcurrsymb();
           if (clCurrSymb != null && !clCurrSymb.isEmpty()){
            currSymb=clCurrSymb;
           }

           clCurrCode=yxxxch522xhhxxhxxxxxclient.getY8xxuxxxbvxxxxxxxxxxdefaultc();
           if (clCurrCode != null && !clCurrCode.isEmpty()){
            defaultc=clCurrCode;//item/customer
           }
           clCurrSymb=yxxxch522xhhxxhxxxxxclient.getY2xxuxxxbvxxxxxxxxxxkeyorder();
           if (clCurrSymb != null && !clCurrSymb.isEmpty()){
            keyorder=clCurrSymb;
           }
           inAuthCaptureMode=!yxxxch522xhhxxhxxxxxclient.getF4xxfxxxbvxxxxxxxxxxcartonfl();

           clientId=yxxxch522xhhxxhxxxxxclient.getDaxxuzxdssxxxxxxxxxxapiclientid();
           clientSecret=yxxxch522xhhxxhxxxxxclient.getDbxxuzxdssxxxxxxxxxxapiclientsecret();
           if ( clientId == null || clientSecret==null ){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("paypal")+bundle.getString("api")+bundle.getString("key")+bundle.getString("not")+bundle.getString("set")+bundle.getString("up")+bundle.getString("yet"),""));


                bcontinue=false;
                return;
           }
           extCtxt = FacesContext.getCurrentInstance().getExternalContext();
           httpreq = (HttpServletRequest) extCtxt.getRequest();
           url=httpreq.getServerName();
           inApproved=false;
           configurationMap.put("http.ConnectionTimeOut","5000");
           configurationMap.put("http.Retry","1");
           configurationMap.put("http.ReadTimeOut","30000");
           configurationMap.put("http.MaxConnection","100");
           configurationMap.put("http.UseProxy","false");
           configurationMap.put("http.GoogleAppEngine","false");
           configurationMap.put("clientId",clientId);
           configurationMap.put("clientSecret", clientSecret);
           String clMerchantLocation=yxxxch522xhhxxhxxxxxclient.getZbxxuxxxbvxxxxxxxxxxsmatcode();
           if(clMerchantLocation == null || clMerchantLocation.isEmpty() || clMerchantLocation.contains("Sandbox") || clMerchantLocation.contains("sandbox")){
            configurationMap.put("service.EndPoint", "https://api.sandbox.paypal.com");
            configurationMap.put("mode", "sandbox");
           }else{
            configurationMap.put("service.EndPoint", "https://api.paypal.com");
            configurationMap.put("mode", "live");
           }
           try {
            accessToken = new OAuthTokenCredential(clientId, clientSecret, configurationMap).getAccessToken();
            apiContext = new APIContext(accessToken);
            //apiContext.setConfigurationMap(configurationMap); method not found. configurationMap was passed to generate accessToken
           } catch (Exception e) {
             // does not come here , jsf exception gets it
             log.severe(e.getMessage());
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again"),""));
              bcontinue=false;
           }

 }

 public void confirmPDPayment(){
  // PD PickupDelivery? non Paypal
  inPDPayment=false;
  inPDApproved=false;
  inPDSaleReady=true;
  String type="codcop";

  // session scope, no init for pd
  inPDConfirmed=false;
  List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);
  String start =currentCartOrder.get(0).getA0xxuncobvxxxxxxxxxxpurchsno();
  String end = currentCartOrder.get(0).getA0xxuncobvxxxxxxxxxxpurchsno();
  vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();
  // update order / details by calling updateProductsToShip, statusflg to show paid and to show under history
  guid=vEmailAddress;
  //posting is in persist but called via below method
  if (fpxxfq1a5xwwqqhxxxxxitemHome.updateProductsToShip(guid,"",inAuthCaptureMode)==null){
   ///error msg given in updateProductsToShip ?
   return;
  }
  // send the order as attachment, look in existing logic
  trexuq244xwwqqhxxxxxcuordersList.setReportName("fiTrexuq244xwwqqhxxxxxcuordersMaster");
  trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress);
  //added logic to get the values from client table row
  yxxxch522xhhxxhxxxxxclient = yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("01");
  if(yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize()==null ||
     yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().isEmpty() || yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
   String clEmailAddress=yxxxch522xhhxxhxxxxxclient.getD4xxhxxrbv24xxxxxxxximailaddr();
   if (vEmailAddress != null && !vEmailAddress.isEmpty()){

    trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,clEmailAddress);//send copy if small, others should monitor via backoffice
    // jay add client flag also
   }
  }
  //send to optional ex buying on behalf of or for gift (add option to hide price)
   if (vEmailAddress2 != null && !vEmailAddress2.isEmpty() ){
    trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress2);
   }

 }


 public void confirmPickUpPayment(){
 //not used now ???
 //comes from checkout for Store pickup if rate has pickup rate entry and paypal client record
 // No shipment involved , optional charge pickup after payment
 // payment should be on hold and readjust totals during order shipment process
 // regular confirmpayment should also allow for adjustment if item out of stock/backorder
      String type="codcop";
      List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);
      if (currentCartOrder.size() >0){
       trexuq244xwwqqhxxxxxcuordersHome.clearInstance();
       trexuq244xwwqqhxxxxxcuorders=currentCartOrder.get(0);
       trexuq244xwwqqhxxxxxcuorders.setC2xxcxxxbv09xxxxxxxxterms("Paid/Pickup");
       trexuq244xwwqqhxxxxxcuordersHome.setInstance(trexuq244xwwqqhxxxxxcuorders);
       trexuq244xwwqqhxxxxxcuordersHome.superUpdate();
      }
      confirmPayment();
 }

    /**
    * method is called from checkout,checkoutPOS,paymentout and also from methods confirmPickUpPayment,
    * for paynow values pp and pd it calls r3cart/ShoppingCartBean for card processing and order status/terms update
    * for no paynow ie np and cd it calls updateOrderTermCode bypassing any card processing because no payment now
    * order type will be cart and terms initially null will be changed to as follows
    * pp > Paid/Pickup, pd > Paid/Deliv, np > ToPay/Pickup, cd > ToPay/Deliv
    * Based on customer ?? tbd or backoffice can change terms to dd/Pickup or dd/Deliv where dd days like 30/Deliv for 30 days
    * @return null or empty
    * @param arg cpoId not used for now null, payBy ie pd- paynow/deliver, pp- paynow/pickup, np- no paynow/pay at pickup, cd- no paynow/delivery time pay cash or credit
    * itemList.getCurrentCartOrder(xx) is used later to get cpoId
    * @exception tbd
    */

 public void confirmPayment(){
 // (3) Payment confirmation by user and by client default payment is kept as authorized
 // after shipment is done a capture is done to convert authorized amount into captured amount.
 // if needed, manual capture can also be done at Paypal site
 // paypal, last step and invoked by user , button shown after paypal response from paypal f:viewaction invokes makePayPalPayment method
 // which in turn calls this final method
 // if netPay is zero then assume its cod/pos and paypal payment authorization is bypassed
 // otherwise calls itemHome.updateProductsToShip(guid,tranId,authcaptureMode) which will
 // if cod will create invoice from order and payment from invoice
 // if paypal auth then will create invoice using the order info
 // at end calls itemHome.updateInvoicesToPay
 // Finally sends emails as confirmation to user and client
 // if pos then skip invoices just payment as if by chq
      String type="cart";

               try{
                 if(inPosMode && !inApproved){
                  //this method is also called for Cash payment in checkout and amtin and chqid is used
                  //here it comes via callback after paypal so session variables are not available
                  //set chqid here with paymentId before calling otherwise it will be cash
                  trexuq277xwwqqhxxxxxcpaymentHome.addWithDetailsCod("r3Cart","r3Cart");
                  return;
                 }
                 if (fpxxfq1a5xwwqqhxxxxxitemList.getNetCartedPayTotal("cart").compareTo( new BigDecimal("0.0"))==0){
                        //no paypal payment but cod shipment needs to be done
                        //look into adding support for POS logic here as well and clean up COD for India type
                        inPayment=false;
                        inApproved=false;
                        inSaleReady=true;
                        inPaycReady=true;
                        inConfirmed=true;
                        guid="cod";
                        List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);
                        String start =currentCartOrder.get(0).getA0xxuncobvxxxxxxxxxxpurchsno();
                        String end = currentCartOrder.get(0).getA0xxuncobvxxxxxxxxxxpurchsno();
                        vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();
                        if(vEmailAddress == null || vEmailAddress.isEmpty()){
                         vEmailAddress=payerEmail;// created in makePayPalPayment step 2.b but session will hold it
                         //need to save it in customer record , step 3a (auth/capture) below needs it uq201xwwqqhxxxxxcustomer().getA0xxuobxbxxxxxxxxxxxsid(),vEmailAddress);
                         // below updateProductsToShip method will save it if needed
                        }
                        //updates done here, below method eventually calls persist which has posting logic
                        // if below method failed ie null no posting ,aug 16 should not be posting payment if authorize or if it fails

                        // this method ends up calling extended invoice and if payment extended payment which involves posting
                        if (fpxxfq1a5xwwqqhxxxxxitemHome.updateProductsToShip(guid,"",inAuthCaptureMode)==null){
                         return;
                        }
                        trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress);
                        if(yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize()==null ||
                         yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().isEmpty() || yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
                         String clEmailAddress=yxxxch522xhhxxhxxxxxclient.getD4xxhxxrbv24xxxxxxxximailaddr();
                         if (clEmailAddress != null && !clEmailAddress.isEmpty()){
                          trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,clEmailAddress);//send copy if small, others should monitor via backoffice

                          // jay add client flag also
                         }
                        }
                        // so that correct messages and buttons get rendered,
                        // in next cart nothing is shown if same session, we need to set inSaleReady to true
                        // but check for inConfirm
                        // add logic not to show cart unless it matched the current owner/temp owner
                        inSaleReady=true;
                        inPaycReady=true;
                        inConfirmed=false;
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("you")+" "+bundle.getString("will")+" "+bundle.getString("receive")+" "+bundle.getString("email")+" "+bundle.getString("from")+" "+bundle.getString("us")+" "+bundle.getString("confirming")+" "+bundle.getString("your")+" "+bundle.getString("cod")+" "+bundle.getString("order")+" "+bundle.getString("refrence")+"("+start+")",""));


                        return;
                 }
                 // NetCartedPayTotal has value and make payment (auth/capture) via paypal payment amount is same as NetCartedPayTotal
                 BigDecimal jsA=fpxxfq1a5xwwqqhxxxxxitemList.getNetCartedPayTotal("cart");//save now since getNet amount checks for status which may change

                 if (payerId != null && !inConfirmed) {
	Payment payment = new Payment();
	if (guid.length() != 0) {
                   payment.setId(map.get(guid));
	}
                  // compare guid values being same?
	PaymentExecution paymentExecution = new PaymentExecution();
	paymentExecution.setPayerId(payerId);
                        inPayment=false;
                        inApproved=false;
                        inSaleReady=true;
                        inPaycReady=true;

                  try {
                     extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                     httpreq = (HttpServletRequest) extCtxt.getRequest();

// (3a) payment execution request via payment module execute method to move money from buyer to merchant
	     //payment.execute(apiContext, paymentExecution); created auth payment but was not retrieved, now we can look at it
	     Payment createdAuthPayment = payment.execute(apiContext, paymentExecution);
                     authorizationID = createdAuthPayment.getTransactions().get(0)
                      .getRelatedResources().get(0).getAuthorization().getId();
                     //save this in order as notes or in , also pass order # to paypal as reference somehow
	     httpreq.setAttribute("response", Payment.getLastResponse());
	     //req.getRequestDispatcher("response.jsp").forward(req, resp);

                     inConfirmed=true;
                     List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);
                     if (currentCartOrder.size() >0){
                      trexuq244xwwqqhxxxxxcuordersHome.clearInstance();
                      trexuq244xwwqqhxxxxxcuorders=currentCartOrder.get(0);
                      trexuq244xwwqqhxxxxxcuorders.setC2xxcxxxbv09xxxxxxxxterms(orderTerm);
                      trexuq244xwwqqhxxxxxcuordersHome.setInstance(trexuq244xwwqqhxxxxxcuorders);
                      trexuq244xwwqqhxxxxxcuordersHome.superUpdate();
                     }
                     vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();
                     // update order / details statusflg to show paid and to show under history
                     // below calls several methods ending in persist() which calls posting, but where shipment cost is posted???
                     //transactionId=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();//
                     transactionId="jay";
                     //following calls cuinvoiceHome.cartExtended_persist >  cuinvoiceHome.extended_persist(true) to create invoice
                     if (fpxxfq1a5xwwqqhxxxxxitemHome.updateProductsToShip(payment.getId(),authorizationID,inAuthCaptureMode).equals(null)){
                      return;
                     }
                     // update order attach to hold auth id or payment id, transction id is in payment.transactions[0].related_resources[0].sale.id
                     // transaction id is shown to customer by paypal. We need to show it too and store it in this cart order's notes

                     // send Email as confirmation also the content should say payment processor will send email as well
                     // rather than updating customer record with paypal kept address etc info, initially put the info
                     // inside email body  of vendorderseMailingContent.fmt
                     // email copy should go to client email as well and as part of back office info can be updated or
                     // simply use the email info as a referenec.
                     // temp user/purchase is short living
                     // revisit this, if the use case changes
                     // only if size is small send to site admin as well
                     List<Xoxxuq2b4xwwqqhxxxxxcuodetails> currentCartOrderDet=fpxxfq1a5xwwqqhxxxxxitemList.getConfirmedCartedList("cart");
                     if (currentCartOrderDet != null && currentCartOrderDet.size() >0){
                      String start =currentCartOrderDet.get(0).getTrexuq244xwwqqhxxxxxcuorders().getA0xxuncobvxxxxxxxxxxpurchsno();
                      String end = currentCartOrderDet.get(0).getTrexuq244xwwqqhxxxxxcuorders().getA0xxuncobvxxxxxxxxxxpurchsno();
                      trexuq244xwwqqhxxxxxcuordersList.setReportName("fiTrexuq244xwwqqhxxxxxcuordersMaster");
                      trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress);
                      if(yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize()==null ||
                         yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().isEmpty() || yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
                         String clEmailAddress=yxxxch522xhhxxhxxxxxclient.getD4xxhxxrbv24xxxxxxxximailaddr();
                         if (clEmailAddress != null && !clEmailAddress.isEmpty()){
                          trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,clEmailAddress);//send copy if small, others should monitor via backoffice
                          // jay add client flag also
                         }
                       }
                       //send to optional ex buying on behalf of or for gift (add option to hide price)
                       if (vEmailAddress2 != null && !vEmailAddress2.isEmpty() ){
                        trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress2);
                       }
                       inSaleReady=false;
                       inSaleReady=true;//for next cart
                       inPaycReady=true;
                       inConfirmed=false;
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("The")+" "+bundle.getString("payment")+" "+bundle.getString("will")+" "+bundle.getString("stay")+" "+bundle.getString("as")+" "+bundle.getString("authorized")+", "+bundle.getString("amount")+" "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("deducted")+" "+bundle.getString("once")+" "+bundle.getString("item")+" "+bundle.getString("shipment")+" / "+bundle.getString("pickup")+" "+bundle.getString("confirmed"),""));
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("you")+" "+bundle.getString("will")+" "+bundle.getString("receive")+" "+bundle.getString("email")+" "+bundle.getString("from")+" "+bundle.getString("us")+" "+bundle.getString("confirming")+" "+bundle.getString("your")+" "+bundle.getString("order")+" "+bundle.getString("refrence")+"("+start+")",""));
                       String js=jsA.toString();
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("a")+" "+bundle.getString("separate")+" "+bundle.getString("email")+" "+bundle.getString("will")+" "+bundle.getString("come")+" "+bundle.getString("from")+" "+bundle.getString("the")+" "+bundle.getString("payment")+" "+bundle.getString("processor")+" "+bundle.getString("confirming")+" "+bundle.getString("payment")+" "+bundle.getString("of")+" "+bundle.getString("amount")+" "+js,""));
                     }else{
                       //no confirmedCartedList , error situation
                       inSaleReady=false;
                       inSaleReady=true;//for next cart
                       inPaycReady=true;
                       inConfirmed=false;
	     log.severe("sale confirm rest error, confirmOrderDetail is null or empty, itemList.getCartedList logic error ");
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+bundle.getString("confirmation")+" "+bundle.getString("step")+" "+bundle.getString("got")+" "+bundle.getString("skipped"),""));
                       //if (identity.isLoggedIn()){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("if")+" "+bundle.getString("loggedIn")+", "+bundle.getString("check")+" "+bundle.getString("purchase")+" "+bundle.getString("history")+" "+bundle.getString("at")+" "+bundle.getString("bottom")+" "+bundle.getString("of")+" "+bundle.getString("page")+" "+bundle.getString("for")+" "+bundle.getString("status"),""));
                       //}
                       String js=jsA.toString();
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("a")+" "+bundle.getString("separate")+" "+bundle.getString("email")+" "+bundle.getString("should")+" "+bundle.getString("come")+" "+bundle.getString("from")+" "+bundle.getString("the")+" "+bundle.getString("payment")+" "+bundle.getString("processor")+" "+bundle.getString("confirming")+" "+bundle.getString("payment")+" "+bundle.getString("of")+" "+bundle.getString("amount")+" "+js,""));

                     }
                  } catch (PayPalRESTException e) {
	     httpreq.setAttribute("error", e.getMessage());
                     // add error msg to show via attribute error  but how and where why forward are commented out??
	     log.severe("sale confirm rest error "+e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
        	  } catch (Exception e) {
	     httpreq.setAttribute("error", e.getMessage());
                     // add error msg to show
	     log.severe("sale confirm  error "+e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
                  }

                 }//if payerId
               } catch (Exception e) {
	     httpreq.setAttribute("error", e.getMessage());
                     // add error msg to show
	     log.severe(e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
               }

 }

 public void makePayPalPayment(String payerid,String guid) throws Exception
 {
           // (2b) following gets invoked after getting response from express ie after paypal login via f:viewAction in checkout.xhtml
           //  payerid  etc are keyed in at paypal site and response comes back & vire-action gets invoked
           //  we need payerId in next step ie confirm
                this.payerId=payerid;
                this.guid=guid;
	Payment payment = new Payment();
	if (guid.length() != 0) {
                   payment.setId(map.get(guid));
	}
                 //get paypal kept shipping info
                 payment = Payment.get(apiContext, payment.getId());

                 ShippingAddress shippingAddress = payment.getPayer().getPayerInfo().getShippingAddress();
                 Address billingAddress = payment.getPayer().getPayerInfo().getBillingAddress();

                 line1=shippingAddress.getLine1();
                 line2=shippingAddress.getLine2();
                 city=shippingAddress.getCity();
                 state=shippingAddress.getState();
                 postalCode=shippingAddress.getPostalCode();
                 fName=payment.getPayer().getPayerInfo().getFirstName();
                 lName=payment.getPayer().getPayerInfo().getLastName();
                 payerEmail=payment.getPayer().getPayerInfo().getLastName();//

                 inPayment=false;
                 inApproved=true;
                 inConfirmed=false;
                 // in future,if temp customer,copy paypal kept shipping ,name and phone info into temp customer(using email) record
                 // if logged in customer, compare name and shipping address against site kept info and put comment if same
                 // or difference. May be used to verify before actual shipping
                 // now copy the info into body of the email to be sent in next step ie confirmpayment

                return;
 }



 public String cancelPayPalPayment()
 {
           //reset status flags to force creating a new payment not used
                               inSaleReady=true;
                               inPaycReady=true;
                               inPayment=false;
                               inApproved=false;
                               inConfirmed=false;
        return "";
 }


 public void salePDRequest() throws Exception
 {  // action by checkout salePDRequest button Place Order for nonpaypal PickUpDelivery
  bcontinue=true;
  inPDSaleReady=false;
  inPDConfirmed=false;
  inPDApproved=true;

  // vEmailAddress2 is optional email address
  if (vEmailAddress2 != null && !vEmailAddress2.isEmpty() && !vEmailAddress2.contains("@")){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("optional")+" "+bundle.getString("email")+" "+ bundle.getString("invalid"),""));


   //inPDApproved=false;
   //return;
  }

 }

 public void saleNAproveRequest(String orderTerm) throws Exception
  {
   this.orderTerm=orderTerm;
   saleNAproveRequest();// orderTerm can be used in confirmPayment()
  }



 public void saleNAproveRequest() throws Exception
  {
  try{
   saleRequest();
   inSaleNAprove=true;
   extCtxt = FacesContext.getCurrentInstance().getExternalContext();
   extCtxt.redirect(approvalUrl);
   //following gets called via action method when Paypal sends response
   //confirmPayment();
   return;
  } catch (Exception e) {
    log.severe(e.getMessage());
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
     FacesMessage.SEVERITY_ERROR,e.getMessage()+", "+bundle.getString("correct")+" "+ bundle.getString("and")+", "+bundle.getString("try")+" "+ bundle.getString("again"),""));
     bcontinue=false;
     return;
  }

 }

 public void saleRequest() throws Exception
 {
          trexuq244xwwqqhxxxxxcuordersHome.updateOrderTermCode(fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder("cart").get(0).getA0xxuobxbxxxxxxxxxxxsid(),orderTerm);//PrePay and ...
         // (1) action by checkout saleRequest button Paypal Purchase , variable values are session scope ie value held
                String type="cart";
                if (fpxxfq1a5xwwqqhxxxxxitemList.getNetCartedPayTotal("cart").compareTo( new BigDecimal("0.0"))==0){
                 inSaleReady=false;
                 inPayment=false;
                 inApproved=true;
                 inConfirmed=false;
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_INFO,bundle.getString("error")+", "+ bundle.getString("NetCartedPay")+", "+bundle.getString("Total")+" "+ bundle.getString("zero"),""));
                 return;
                }
           bcontinue=true;
           init("demo");
		// ###AccessToken
		// Retrieve the access token from
		// OAuthTokenCredential by passing in
		// ClientID and ClientSecret
		//apiContext = null;
		//String accessToken = null;
           if(!bcontinue){
            return;
           }
           try {
	//accessToken = GenerateAccessToken.getAccessToken();
	// ### Api Context
	// Pass in a `ApiContext` object to authenticate
	// the call and to send a unique request id
	// (that ensures idempotency). The SDK generates
	// a request id if you do not pass one explicitly.
	//apiContext = new APIContext(accessToken);
                if (apiContext == null){
                      log.severe("#{messages['error_condition_check_internet']}");
                      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                       FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+ bundle.getString("condition")+", "+bundle.getString("check")+" "+ bundle.getString("internet"),""));
                      bcontinue=false;
                      return;

                }
			// Use this variant if you want to pass in a request id
			// that is meaningful in your application, ideally
			// a order id.
			/*
			 * String requestId = Long.toString(System.nanoTime(); APIContext
			 * apiContext = new APIContext(accessToken, requestId ));
			 */
	} catch (Exception e) {
                     log.severe(e.getMessage());
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,e.getMessage()+", "+bundle.getString("correct")+" "+ bundle.getString("and")+", "+bundle.getString("try")+" "+ bundle.getString("again"),""));
                     bcontinue=false;
                     return;
	}

                // now get the order details from Fpxxfq1a5xwwqqhxxxxxitemList
                // create a new mehod to get totals from cuorder using getCurrentCartOrder
                // replaced pay with cart but check how pos/cod/cop can come here?
                List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);

			// ###Details exclude to be payed later
			// Let's you specify details of a payment amount.
                //
			Details details = new Details();
			//details.setShipping(String.format("%.2f",currentCartOrder.get(0).getZ6xxzltxavxxxxxxxxxxdelivchrgt().add(fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type).get(0).getZ7xxzmtxavxxxxxxxxxxmiscchrgt()).subtract(fpxxfq1a5xwwqqhxxxxxitemList.getCartedPayDelMiscLaterTotal())));doubling ??
			details.setShipping(String.format("%.2f",currentCartOrder.get(0).getZ6xxzltxavxxxxxxxxxxdelivchrgt().subtract(fpxxfq1a5xwwqqhxxxxxitemList.getCartedPayDelMiscLaterTotal())));
			details.setSubtotal(String.format("%.2f",currentCartOrder.get(0).getZ7xxzbtxavxxxxxxxxxxbaseamountt()));
			//details.setTax(String.format("%.2f",currentCartOrder.get(0).getZ8xxzxz1avxxxxxxxxxxtax1amtt().add(currentCartOrder.get(0).getZ9xxzxz2avxxxxxxxxxxtax2amtt()).add(currentCartOrder.get(0).getZaxxzxz3avxxxxxxxxxxtax3amtt()).subtract(fpxxfq1a5xwwqqhxxxxxitemList.getCartedPayTaxLaterTotal(type)) ));doubling
			details.setTax(String.format("%.2f",currentCartOrder.get(0).getZ8xxzxz1avxxxxxxxxxxtax1amtt().add(currentCartOrder.get(0).getZaxxzxz3avxxxxxxxxxxtax3amtt()).subtract(fpxxfq1a5xwwqqhxxxxxitemList.getCartedPayTaxLaterTotal(type))));


			// ###Amount
			// Let's you specify a payment amount.
			Amount amount = new Amount();
                        // if item curr is null or empty get from client, client set default from
                        // locale ( whose locale) but can be changed
                        //amount.setCurrency(currCode);//tbd option to select and show conv rate
                        amount.setCurrency(defaultc);//
                        // Total must be equal to sum of shipping(delivery charge) , tax (tax1) and subtotal (baseamount).
                        // misc charge will be added to delivery charge with a note
                       amount.setTotal(String.format("%.2f",(currentCartOrder.get(0).getZ1xxztprlxxxxxxxxxxxamounttotal())));
                       amount.setDetails(details);

			// ###Transaction
			// A transaction defines the contract of a
			// payment - what is the payment for and who
			// is fulfilling it. Transaction is created with
			// a `Payee` and `Amount` types
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setDescription("This is the payment transaction description.");

                        // a ListofItems to show as order
			ArrayList<Item> items = new ArrayList<Item>();


			// The Payment creation API requires a list of
			// Transaction; add the created `Transaction`
			// to a List
                // use a for loop using fpxxfq1a5xwwqqhxxxxxitemList.getCartedList()
                // we can decide here intent to be authorize (to hold amount and capture payment after shipment)
                // or sale(if SI-P (pay and PickUp POS ?? by vendor/customer) or SI-D (digital goods)  or SI-S? (drop ship) )
                // SI-P still pays as final not authorize but pick up only, si-C is cash on deliv so no payment at check out
                // but paypal wont accept if si-c only item since net amt will be zero
                // so dont send sale request to paypal
                //at least one with shipment out of mixed types will mean authorize and then capture fund in shipment
                // sale also means no shipment and item qty should be reduced and order status updated
                for (Xoxxuq2b4xwwqqhxxxxxcuodetails itemOrderDetail : fpxxfq1a5xwwqqhxxxxxitemList.getCartedList("cart")) {
                 if(itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
                  //inAuthCaptureMode=true; use default value set in init from client table
                 }
                 if(!itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getC6xxusxrbv16xxxxxxxxtype().equals("SI-C")){
                  Item item = new Item();
                  item.setName(itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getB1xxuszsbvxxxxxxxxxxdescript());
                  item.setPrice(String.format("%.2f",itemOrderDetail.getZ5xxzpxravxxxxxxxxxxordprice()));
                  //item.setCurrency(currCode);//tbd option to select and show conv rate
                  item.setCurrency(defaultc);//

                  item.setQuantity(itemOrderDetail.getZ3xxeqxxbvnxxxxxxxxxqtyordrd().toBigInteger().toString());
                  item.setSku(itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode());
                  items.add(item);
                 }
                }
                ItemList itemList = new ItemList();
                itemList.setItems(items);

                transaction.setItemList(itemList);




			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(transaction);

			// ###Payer
			// A resource representing a Payer that funds a payment
			// Payment Method
			// as 'paypal'
			Payer payer = new Payer();
			payer.setPaymentMethod("paypal");

			// ###Payment
			// A Payment Resource; create one using
			// the above types and intent as 'sale'
			Payment payment = new Payment();
                        if(inAuthCaptureMode){
 			 payment.setIntent("authorize");
                        }else{
			 payment.setIntent("sale");
                        }
			payment.setPayer(payer);
			payment.setTransactions(transactions);

			// ###Redirect URLs
			RedirectUrls redirectUrls = new RedirectUrls();
			guid = UUID.randomUUID().toString().replaceAll("-", "");
                        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                        httpreq = (HttpServletRequest) extCtxt.getRequest();

                        // allow local test before production
                        //upto login uses rest ie http req/response but after login url redirect is used
                        // along with local viewaction to process the returned data and needs internet access from paypal
                        // use ngrok url (which points to local host:8080) if port 8080 detected
                        String revisedUrl=httpreq.getServerName() + ":" + httpreq.getServerPort();
                        if(yxxxch522xhhxxhxxxxxclient.getZaxxuxxxssxxxxxxxxxxpop3pass() !=null
                          && !yxxxch522xhhxxhxxxxxclient.getZaxxuxxxssxxxxxxxxxxpop3pass().isEmpty()){
                         revisedUrl=yxxxch522xhhxxhxxxxxclient.getZaxxuxxxssxxxxxxxxxxpop3pass()+".ngrok.io";
                        }
			 redirectUrls.setCancelUrl(httpreq.getScheme() + "://"
					+ revisedUrl
					+ httpreq.getContextPath() + "/checkout.wflow?guid=" + guid);
			 redirectUrls.setReturnUrl(httpreq.getScheme() + "://"
					+ revisedUrl
					+ httpreq.getContextPath() + "/checkout.wflow?guid=" + guid);
			payment.setRedirectUrls(redirectUrls);

			// Create a payment by posting to the APIService
			// using a valid AccessToken
			// The return object contains the status;
                        try {
// (1) sale request via payment module
                         //below line sends payment approval http request to paypal
                         // and holds response in payment object which also holds 3 links
                         // if no approval then do not send the real payment request
                         Payment createdPayment = payment.create(apiContext);
                         log.info("#{messages['Created_payment']}"+ createdPayment.getId()+" " + createdPayment.getState());
                         //this.setPayerId(createdPayment.getId());

				// ###Payment Approval Url
				Iterator<Links> links = createdPayment.getLinks().iterator();
				while (links.hasNext()) {
				 Links link = links.next();
				 if (link.getRel().equalsIgnoreCase("approval_url")) {
                                                                          inSaleReady=false;
                                                                          inPayment=true;
                                                                          inApproved=false;
                                                                          inConfirmed=false;
                                                                          approvalUrl=link.getHref();
                                                                          // URI uri=create(link.getHref());
				 }
				}
				//req.setAttribute("response", Payment.getLastResponse());
				map.put(guid, createdPayment.getId());
                        } catch (PayPalRESTException e) {
                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));

                          //e.printStackTrace();
                          //throw new PayPalRESTException("INVALID CARD"
                          // + e.getMessage());
                         //req.setAttribute("error", e.getMessage());
                           //log.severe(e.getMessage());
                         //FacesMessages.instance().add(e.getMessage());
                         //FacesMessages.instance().add(Severity.ERROR,"#{messages['correct_and_try_again']} ");
                           //bcontinue=false;
                           //return;
                         }
                        //req.setAttribute("request", Payment.getLastRequest());
                        //req.getRequestDispatcher("checkout.xhtml").forward(req, resp);
                        //now send the actual payment request to paypal express url using easyrest request client
                        // use the redirectUrls above to mimic pressing link https://www.sandbox.paypal.com/cgi-bin/webscr?                                // cmd=_express-checkout&token=EC-56A84315H5725162U
                        // now look at the response which should have payerId
                        // if needed make sure return url is to checkout and not to /paymentwithpaypal
// (2) express payment request via  checkout.xhtml link button value approvalUrl / login to paypal

                       // exception handling
                       // normal response is captured by faces-config.xml
                       // we need to add in faces-config.xml http code 400 for paypal data validation error and 401 for authentication                          error ie valid non expired access token

 }

//called refundRequest method which is to be called by saleCancel in checkout
 public void getPayment() throws Exception
 {
               String type="cart";

		try {
			// ###AccessToken
			// Retrieve the access token from
			// OAuthTokenCredential by passing in
			// ClientID and ClientSecret
			// It is not mandatory to generate Access Token on a per call basis.
			// Typically the access token can be generated once and
			// reused within the expiry window
			//String accessToken = GenerateAccessToken.getAccessToken();

			// Retrieve the payment object by calling the
			// static `get` method
			// on the Payment class by passing a valid
			// AccessToken and Payment ID
                        // paymentId is stored in cuorder attach field for cart orders
                        List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder(type);
                        String payId =currentCartOrder.get(0).getYbxxuxxrblxxxxxxxxxxattach();

			Payment payment = Payment.get(accessToken,payId);
                        transactionId=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();
			log.info("Payment retrieved ID = " + payment.getId()
					+ ", status = " + payment.getState());
			log.info("Transaction retrieved ID = " + transactionId
					+ ", status = " + payment.getState());

                        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                        httpreq = (HttpServletRequest) extCtxt.getRequest();
			httpreq.setAttribute("response", Payment.getLastResponse());

		} catch (PayPalRESTException e) {
			httpreq.setAttribute("error", e.getMessage());
		}

 }
 public void refundRequest() throws Exception
 {         // action by checkout saleCancel button
                //get tramsactionId from pay id and put in setId
                 getPayment();
		// ###Sale
		// A sale transaction.
		// Create a Sale object with the
		// given sale transaction id.
		Sale sale = new Sale();
		//sale.setId("03W403310B593121A");
                if(transactionId != null && !transactionId.isEmpty() ){
		 sale.setId(transactionId);
                }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("no")+" "+bundle.getString("transaction"),""));

                 return;
                }
		// ###Refund
		// A refund transaction.
		// Use the amount to create
		// a refund object
		 Refund refund = new Refund();
		// ###Amount
		// Create an Amount object to
		// represent the amount to be
		// refunded. Create the refund object, if the refund is partial
		 Amount amount = new Amount();
                 //amount.setCurrency(currCode);//tbd option to select and show conv rate
                 amount.setCurrency(defaultc);//

		 amount.setTotal("0.01");
		 refund.setAmount(amount);
		try {
			// ###AccessToken
			// Retrieve the access token from
			// OAuthTokenCredential by passing in
			// ClientID and ClientSecret
			// It is not mandatory to generate Access Token on a per call basis.
			// Typically the access token can be generated once and
			// reused within the expiry window
			//String accessToken = GenerateAccessToken.getAccessToken();

			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.
			APIContext apiContext = new APIContext(accessToken);
			// Use this variant if you want to pass in a request id
			// that is meaningful in your application, ideally
			// a order id.
			/*
			 * String requestId = Long.toString(System.nanoTime();
			 * APIContext apiContext = new APIContext(accessToken, requestId ));
			 */

			// Refund by posting to the APIService
			// using a valid AccessToken
			sale.refund(apiContext, refund);
			//ResultPrinter.addResult(httpreq, httpresp, "Sale Refunded", Sale.getLastRequest(), Sale.getLastResponse(), null);
		} catch (PayPalRESTException e) {
			//ResultPrinter.addResult(httpreq, httpresp, "Sale Refunded", Sale.getLastRequest(), null, e.getMessage());
		}

                        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                        httpreq = (HttpServletRequest) extCtxt.getRequest();
		        //httpreq.getRequestDispatcher("response.jsp").forward(httpreq, httpresp);


 }

 public void captureRequest(String authId) throws Exception
  {
      // action by customer shipping edit after shipping to capture payment which has been authorized

                try {
                        // ###Capture
                        // A capture transaction
                        // if in same session, jay add new code if done later which is normal may be call init()?
                        if(accessToken == null || accessToken.isEmpty()){// added null check
                         init("demo");
                        }
                        APIContext apiContext = new APIContext(accessToken);
                        Authorization authorization = Authorization.get(apiContext,authId);
                        //check state
                        if(authorization.getState().equals("captured")){
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("authorization")+" "+bundle.getString("capture")+" "+bundle.getString("already")+" "+bundle.getString("done"),""));
                         return;
                        }


			// ###Amount
			// Let's you specify a payment amount.
			Amount amount = new Amount();
			//amount.setCurrency(currCode);
                        amount.setCurrency(authorization.getAmount().getCurrency());
                        //amount.setTotal("4.54");
                        amount.setTotal(authorization.getAmount().getTotal());
			// Total must be equal to sum of shipping(delivery charge) , tax (tax1) and subtotal (baseamount).
                        // misc charge will be added to delivery charge with a note
			//amount.setTotal(String.format("%.2f",currentCartOrder.get(0).getZ1xxztprlxxxxxxxxxxxamounttotal()));
			//amount.setDetails(details);

			Capture capture = new Capture();
			capture.setAmount(amount);

			// ##IsFinalCapture
			// If set to true, all remaining
			// funds held by the authorization
			// will be released in the funding
			// instrument. Default is 'false'.
			capture.setIsFinalCapture(true);


			// Capture by POSTing to
			// URI v1/payments/authorization/{authorization_id}/capture
                       Capture responseCapture = authorization.capture(apiContext, capture);
                        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                        httpreq = (HttpServletRequest) extCtxt.getRequest();
                        httpreq.setAttribute("response", Authorization.getLastResponse());
                        //transactionId=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();//
                        log.info(bundle.getString("capture")+" "+bundle.getString("id")+" "+responseCapture.getId()+" " +bundle.getString("and")+" " +bundle.getString("status")+ " "+responseCapture.getState() );
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("authorization")+" "+bundle.getString("capture")+" "+bundle.getString("done"),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("meaning")+", "+bundle.getString("authorized")+" "+bundle.getString("money")+" "+bundle.getString("getting")+" "+bundle.getString("transferred")+" "+bundle.getString("from")+" "+bundle.getString("customer")+" "+bundle.getString("to")+" "+bundle.getString("merchant"),""));
                } catch (PayPalRESTException e) {
		  httpreq.setAttribute("error", e.getMessage());
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("authorization")+" "+bundle.getString("capture")+" "+bundle.getString("error")+" "+e.getMessage(),""));
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("checking")+", "+bundle.getString("capture")+" "+bundle.getString("status")+" / "+bundle.getString("manual")+", "+bundle.getString("capture")+" "+bundle.getString("at")+" "+bundle.getString("paypal")+" "+bundle.getString("site")+" "+bundle.getString("is")+" "+bundle.getString("also")+" "+bundle.getString("possible"),""));

               }
		//httpreq.setAttribute("request", Authorization.getLastRequest());
		//httpreq.getRequestDispatcher("response.jsp").forward(req, resp);

  }

 public void payRequest(String key) throws Exception
   // (1) action by paymentout checkout button Paypal Purchase , variable values are session scope ie value held
   // unlike saleRequest which involves one current order, payRequest may involve multiple invoices for a customer
 {
                if (fpxxfq1a5xwwqqhxxxxxitemList.getNetInvoiceCartedPayTotal(key).compareTo( new BigDecimal("0.0"))==0){
                                  inPaycReady=false;
                                  inPayment=false;
                                  inApproved=true;
                                  inConfirmed=false;
                 return;
                }
           bcontinue=true;
           init("demo");
		// ###AccessToken
		// Retrieve the access token from
		// OAuthTokenCredential by passing in
		// ClientID and ClientSecret
		//apiContext = null;
		//String accessToken = null;
           if(!bcontinue){
            return;
           }
		try {
			//accessToken = GenerateAccessToken.getAccessToken();

			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.
			//apiContext = new APIContext(accessToken);
                if (apiContext == null){
    		      log.severe("#{messages['error_condition_check_internet']}");
                      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+ bundle.getString("condition")+", "+bundle.getString("check")+" "+ bundle.getString("internet"),""));


                      bcontinue=false;
                      return;

                }
			// Use this variant if you want to pass in a request id
			// that is meaningful in your application, ideally
			// a order id.
			/*
			 * String requestId = Long.toString(System.nanoTime(); APIContext
			 * apiContext = new APIContext(accessToken, requestId ));
			 */
		} catch (Exception e) {
    		     log.severe("invoice pay confirm rest error "+e.getMessage());
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+", "+bundle.getString("correct")+" "+ bundle.getString("and")+", "+bundle.getString("try")+" "+ bundle.getString("again"),""));

                     bcontinue=false;
                     return;


		}

                // now get the order details from Fpxxfq1a5xwwqqhxxxxxitemList
                // create a new mehod to get totals from cuorder using getCurrentCartOrder

                List<Trexuq266xwwqqhxxxxxcuinvoice> currentCartInvoice = fpxxfq1a5xwwqqhxxxxxitemList.getCartInvoiceFor(key);

			// ###Details exclude to be payed later
			// Let's you specify details of a payment amount.
                //
			Details details = new Details();
			details.setShipping(String.format("%.2f",currentCartInvoice.get(0).getZ7xxzltxavxxxxxxxxxxdelivchrgt()));
			details.setSubtotal(String.format("%.2f",currentCartInvoice.get(0).getZ7xxzbtxavxxxxxxxxxxbaseamountt()));
			details.setTax(String.format("%.2f",currentCartInvoice.get(0).getZ9xxzxz1avxxxxxxxxxxtax1amtt().add(currentCartInvoice.get(0).getZaxxzxz2avxxxxxxxxxxtax2amtt()).add(currentCartInvoice.get(0).getZbxxzxz3avxxxxxxxxxxtax3amtt()) ));


			// ###Amount
			// Let's you specify a payment amount.
			Amount amount = new Amount();
                        // if item curr is null or empty get from client, client set default from
                        // locale ( whose locale) but can be changed
			//amount.setCurrency(currCode);
			amount.setCurrency(defaultc);
			// Total must be equal to sum of shipping(delivery charge) , tax (tax1) and subtotal (baseamount).
                        // misc charge will be added to delivery charge with a note
			amount.setTotal(String.format("%.2f",(currentCartInvoice.get(0).getZ1xxztprlxxxxxxxxxxxamounttotal())));
			amount.setDetails(details);

			// ###Transaction
			// A transaction defines the contract of a
			// payment - what is the payment for and who
			// is fulfilling it. Transaction is created with
			// a `Payee` and `Amount` types
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction
					.setDescription("This is the invoice payment transaction description.");

                        // a ListofItems to show as order
			ArrayList<Item> items = new ArrayList<Item>();


			// The Payment creation API requires a list of
			// Transaction; add the created `Transaction`
			// to a List
                // use a for loop using fpxxfq1a5xwwqqhxxxxxitemList.getCartedList()
                // we can decide here intent to be authorize (to hold amount and capture payment after shipment)
                // or sale(if SI-P (pay and PickUp POS ?? by vendor/customer) or SI-D (digital goods)  or SI-S? (drop ship) )
                // SI-P still pays as final not authorize but pick up only, si-C is cash on deliv so no payment at check out
                // but paypal wont accept if si-c only item since net amt will be zero
                // so dont send sale request to paypal
                //at least one with shipment out of mixed types will mean authorize and then capture fund in shipment
                // sale also means no shipment and item qty should be reduced and order status updated
                for (Xoxxuq2a4xwwqqhxxxxxcuidetails itemOrderDetail : fpxxfq1a5xwwqqhxxxxxitemList.getInvoicedCartedListFor(key)) {
                 if(itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
                  //inAuthCaptureMode=true; use default value set in init from client table
                 }
                 if(!itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getC6xxusxrbv16xxxxxxxxtype().equals("SI-C")){
                  Item item = new Item();
                  item.setName(itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getB1xxuszsbvxxxxxxxxxxdescript());
                  item.setPrice(String.format("%.2f",itemOrderDetail.getZ5xxzpxravxxxxxxxxxxordprice()));
                  //item.setCurrency(currCode);
                  item.setCurrency(defaultc);
                  item.setQuantity(itemOrderDetail.getZ3xxeqxxbvnxxxxxxxxxqtyordrd().toBigInteger().toString());
                  item.setSku(itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode());
                  items.add(item);
                 }
                }
                ItemList itemList = new ItemList();
                itemList.setItems(items);

                transaction.setItemList(itemList);




			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(transaction);

			// ###Payer
			// A resource representing a Payer that funds a payment
			// Payment Method
			// as 'paypal'
			Payer payer = new Payer();
			payer.setPaymentMethod("paypal");

			// ###Payment
			// A Payment Resource; create one using
			// the above types and intent as 'sale'
			Payment payment = new Payment();
                        if(inAuthCaptureMode){
 			 payment.setIntent("authorize");
                        }else{
			 payment.setIntent("sale");
                        }
			payment.setPayer(payer);
			payment.setTransactions(transactions);

			// ###Redirect URLs
			RedirectUrls redirectUrls = new RedirectUrls();
			guid = UUID.randomUUID().toString().replaceAll("-", "");
                        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                        httpreq = (HttpServletRequest) extCtxt.getRequest();

                        // allow local test before production
                        //upto login uses rest ie http req/response but after login url redirect is used
                        // along with local viewaction to process the returned data and needs internet access from paypal
                        // use ngrok url (which points to local host:8080) if port 8080 detected
                        String revisedUrl=httpreq.getServerName() + ":" + httpreq.getServerPort();
                        if(yxxxch522xhhxxhxxxxxclient.getZaxxuxxxssxxxxxxxxxxpop3pass() !=null
                          && !yxxxch522xhhxxhxxxxxclient.getZaxxuxxxssxxxxxxxxxxpop3pass().isEmpty()){
                         revisedUrl=yxxxch522xhhxxhxxxxxclient.getZaxxuxxxssxxxxxxxxxxpop3pass()+".ngrok.io";
                        }
			redirectUrls.setCancelUrl(httpreq.getScheme() + "://"
					+ revisedUrl
					+ httpreq.getContextPath() + "/paymentout.wflow?guid=" + guid);
			redirectUrls.setReturnUrl(httpreq.getScheme() + "://"
					+ revisedUrl
					+ httpreq.getContextPath() + "/paymentout.wflow?guid=" + guid);
			payment.setRedirectUrls(redirectUrls);

			// Create a payment by posting to the APIService
			// using a valid AccessToken
			// The return object contains the status;
			try {
// (1) pay request via payment module
                         //below line sends payment approval http request to paypal
                         // and holds response in payment object which also holds 3 links
                         // if no approval then do not send the real payment request
			     Payment createdPayment = payment.create(apiContext);
			     log.info("#{messages['invoice']}"+" "+"#{messages['Created_payment']}"+ createdPayment.getId()+" " + createdPayment.getState());
                             //this.setPayerId(createdPayment.getId());

				// ###Payment Approval Url
				Iterator<Links> links = createdPayment.getLinks().iterator();
				while (links.hasNext()) {
				 Links link = links.next();
				 if (link.getRel().equalsIgnoreCase("approval_url")) {
                                  inPaycReady=false;
                                  inPayment=true;
                                  inApproved=false;
                                  inConfirmed=false;
                                  approvalUrl=link.getHref();
                                  // URI uri=create(link.getHref());
				 }
				}
				//req.setAttribute("response", Payment.getLastResponse());
				map.put(guid, createdPayment.getId());
			} catch (PayPalRESTException e) {
    		          log.severe("invoice pay approval rest error "+e.getMessage());

                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));

                          //e.printStackTrace();
                          //throw new PayPalRESTException("INVALID CARD"
                          // + e.getMessage());
			   //req.setAttribute("error", e.getMessage());
                           //log.severe(e.getMessage());
			   //FacesMessages.instance().add(e.getMessage());
		           //FacesMessages.instance().add(Severity.ERROR,"#{messages['correct_and_try_again']} ");
                           //bcontinue=false;
                           //return;
			}
		        //req.setAttribute("request", Payment.getLastRequest());
		        //req.getRequestDispatcher("checkout.xhtml").forward(req, resp);
                        //now send the actual payment request to paypal express url using easyrest request client
                        // use the redirectUrls above to mimic pressing link https://www.sandbox.paypal.com/cgi-bin/webscr?                                // cmd=_express-checkout&token=EC-56A84315H5725162U
                        // now look at the response which should have payerId
                        // if needed make sure return url is to checkout and not to /paymentwithpaypal
// (2) express payment request via  checkout.xhtml link button value approvalUrl / login to paypal

                       // exception handling
                       // normal response is captured by faces-config.xml
                       // we need to add in faces-config.xml http code 400 for paypal data validation error and 401 for authentication                          error ie valid non expired access token

 }
    /**
    * method is called by paymentout(allows customer to pay back office created invoice on line)
    * raaspi unique feature suitable for service provider or semi online solution
    * @return void
    * @param arg invoice key
    * @exception payPal rest call exception
    */

 public void confirmPayPayment(String key){
 // There are 3 payments method-confirmPickUpPayment,confirmPayment and confirmPayPayment
 // (3) Payment confirmation by user and by client default payment is kept as authorized
 // after shipment is done a capture is done in payment to convert authorized amount into captured amount.
 // if needed, manual capture can also be done at Paypal site
 // paypal, last step and invoked by user , button shown after paypal response from paypal f:viewaction invokes makePayPalPayment method
 // which in turn calls this final method
 // if netPay is zero then assume its cod/pos and paypal payment authorization is bypassed
 //  COD payment now part of backoffice inperson/POS payment not part customer pay flow
 // netPay refers to COD charge and shown to cusomer as COD charge
 // COD payment is now handled by entityHome addWithDetailsCOD for cash/chq or for card by Square POS terminal
 // in future Paypal payAnywhere terminal or Stripe Terminal
 // since invoice already exists itemHome.updateInvoicesToPay method is called to update
               key=invoiceKey;// was saved already use this rather than parameter which is empty
               key=fpxxfq1a5xwwqqhxxxxxitemList.getFullKey(key);

               String start="";
               String end="zzzzzzzz";
               try{
                 if (fpxxfq1a5xwwqqhxxxxxitemList.getNetInvoiceCartedPayTotal(key).compareTo( new BigDecimal("0.0"))==0){
                        //no paypal payment but cod shipment needs to be done
                        //look into adding support for POS logic here as well and clean up COD for India type
                        inPayment=false;
                        inApproved=false;
                        inSaleReady=true;
                        inPaycReady=true;
                        inConfirmed=true;
                        guid="cod";
                        // why using currentCartOrder variable for Invoice entity????
                        List<Trexuq266xwwqqhxxxxxcuinvoice> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartInvoiceFor(key);
                        start =currentCartOrder.get(0).getA0xxuncibvxxxxxxxxxxinvoice();
                        end = currentCartOrder.get(0).getA0xxuncibvxxxxxxxxxxinvoice();
                        vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();

                        //updates done here, below method eventually calls persist which has posting logic
                        // if below method failed ie null no posting ,aug 16 should not be posting payment if authorize or if it fails
                        // this method ends up calling extended invoice and if payment extended payment which involves posting
                        // need to call a new method to update invoice ???
                        if (fpxxfq1a5xwwqqhxxxxxitemHome.updateInvoicesToPay(key,guid,"",inAuthCaptureMode)==null){
                         return;
                        }
                        /* call similar method but invoice report not order
                        trexuq244xwwqqhxxxxxcuordersList.eSend("PEMAIL",start,end,false,vEmailAddress);
                        if(yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize()==null ||
                         yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().isEmpty() || yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
                         String clEmailAddress=yxxxch522xhhxxhxxxxxclient.getD4xxhxxrbv24xxxxxxxximailaddr();
                         if (clEmailAddress != null && !clEmailAddress.isEmpty()){
                          trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,clEmailAddress);//send copy if small, others should monitor via backoffice

                          // jay add client flag also
                         }
                        }
                        */
                        // so that correct messages and buttons get rendered,
                        // in next cart nothing is shown if same session, we need to set inSaleReady to true
                        // but check for inConfirm
                        // add logic not to show cart unless it matched the current owner/temp owner
                        inSaleReady=true;
                        inPaycReady=true;
                        inConfirmed=false;
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("you")+" "+bundle.getString("will")+" "+bundle.getString("receive")+" "+bundle.getString("email")+" "+bundle.getString("from")+" "+bundle.getString("us")+" "+bundle.getString("confirming")+" "+bundle.getString("your")+" "+bundle.getString("cod")+" "+bundle.getString("order")+" "+bundle.getString("refrence")+"("+start+")",""));


                        return;
                 }
                 // NetCartedPayTotal has value and make payment (auth/capture) via paypal payment amount is same as NetCartedPayTotal
                 BigDecimal jsA=fpxxfq1a5xwwqqhxxxxxitemList.getNetInvoiceCartedPayTotal(key);//save now since getNet amount checks for status which may change

                 if (payerId != null && !inConfirmed) {
			Payment payment = new Payment();
			if (guid.length() != 0) {
			payment.setId(map.get(guid));
			}
                        // compare guid values being same?

			PaymentExecution paymentExecution = new PaymentExecution();
			paymentExecution.setPayerId(payerId);
                        inPayment=false;
                        inApproved=false;
                        inSaleReady=true;
                        inPaycReady=true;

                  try {
                     extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                     httpreq = (HttpServletRequest) extCtxt.getRequest();

// (3a) payment execution request via payment module execute method to move money from buyer to merchant
		     //payment.execute(apiContext, paymentExecution); created auth payment but was not retrieved, now we can look at it

		     Payment createdAuthPayment = payment.execute(apiContext, paymentExecution);
                     authorizationID = createdAuthPayment.getTransactions().get(0)
			.getRelatedResources().get(0).getAuthorization().getId();
                     //save this in order as notes or in , also pass order # to paypal as reference somehow
		     httpreq.setAttribute("response", Payment.getLastResponse());
		     //req.getRequestDispatcher("response.jsp").forward(req, resp);

                     inConfirmed=true;
                     List<Trexuq266xwwqqhxxxxxcuinvoice> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartInvoiceFor(key);
                     start =currentCartOrder.get(0).getA0xxuncibvxxxxxxxxxxinvoice();
                     end = currentCartOrder.get(0).getA0xxuncibvxxxxxxxxxxinvoice();

                     vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();
                     // update order / details statusflg to show paid and to show under history
                     // below calls several methods ending in persist() which calls posting, but where shipment cost is posted???
                     //transactionId=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();//
                     transactionId="jay";
                     // ******new method ******updates existing invoice  ***
                     if (fpxxfq1a5xwwqqhxxxxxitemHome.updateInvoicesToPay(key,payment.getId(),authorizationID,inAuthCaptureMode).equals(null)){
                      return;
                     }
                     //*******************************************************************************
                     // update order attach to hold auth id or payment id, transction id is in payment.transactions[0].related_resources[0].sale.id
                     // transaction id is shown to customer by paypal. We need to show it too and store it in this cart order's notes

                     // send Email as confirmation also the content should say payment processor will send email as well
                     // rather than updating customer record with paypal kept address etc info, initially put the info
                     // inside email body  of vendorderseMailingContent.fmt
                     // email copy should go to client email as well and as part of back office info can be updated or
                     // simply use the email info as a referenec.
                     // temp user/purchase is short living
                     // revisit this, if the use case changes
                     // only if size is small send to site admin as well
                     // invoice status changed already
                     //List<Xoxxuq2a4xwwqqhxxxxxcuidetails> currentCartOrderDet=fpxxfq1a5xwwqqhxxxxxitemList.getInvoicedCartedList(key);
                     if (vEmailAddress !=null && !vEmailAddress.isEmpty()){
                      trexuq266xwwqqhxxxxxcuinvoiceList.setReportName("fiTrexuq266xwwqqhxxxxxcuinvoiceMaster");
                      trexuq266xwwqqhxxxxxcuinvoiceList.eSend("SEMAIL",start,end,false,vEmailAddress);
                      if(yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize()==null ||
                         yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().isEmpty() || yxxxch522xhhxxhxxxxxclient.getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
                         String clEmailAddress=yxxxch522xhhxxhxxxxxclient.getD4xxhxxrbv24xxxxxxxximailaddr();
                         if (clEmailAddress != null && !clEmailAddress.isEmpty()){
                          trexuq266xwwqqhxxxxxcuinvoiceList.eSend("SEMAIL",start,end,false,clEmailAddress);//send copy if small, others should monitor via backoffice

                          // jay add client flag also
                         }
                      }
                      //send to optional ex buying on behalf of or for gift (add option to hide price)
                      if (vEmailAddress2 != null && !vEmailAddress2.isEmpty() ){
                        trexuq266xwwqqhxxxxxcuinvoiceList.eSend("SEMAIL",start,end,false,vEmailAddress2);
                      }
                       inSaleReady=false;
                       inSaleReady=true;//for next cart
                       inPaycReady=true;
                       inConfirmed=false;
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("The")+" "+bundle.getString("payment")+" "+bundle.getString("will")+" "+bundle.getString("stay")+" "+bundle.getString("as")+" "+bundle.getString("authorized")+", "+bundle.getString("amount")+" "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("deducted")+" "+bundle.getString("once")+" "+bundle.getString("invoice")+" "+bundle.getString("and")+" "+bundle.getString("payment")+" "+bundle.getString("verified"),""));

                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("you")+" "+bundle.getString("will")+" "+bundle.getString("receive")+" "+bundle.getString("email")+" "+bundle.getString("from")+" "+bundle.getString("us")+" "+bundle.getString("confirming")+" "+bundle.getString("your")+" "+bundle.getString("invoice")+" "+bundle.getString("refrence")+"("+start+")",""));
                       String js=jsA.toString();
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("a")+" "+bundle.getString("separate")+" "+bundle.getString("email")+" "+bundle.getString("will")+" "+bundle.getString("come")+" "+bundle.getString("from")+" "+bundle.getString("the")+" "+bundle.getString("payment")+" "+bundle.getString("processor")+" "+bundle.getString("confirming")+" "+bundle.getString("payment")+" "+bundle.getString("of")+" "+bundle.getString("amount")+" "+js,""));

                     }else{
                       //no vemail , error situation
                       inSaleReady=false;
                       inSaleReady=true;//for next cart
                       inPaycReady=true;
                       inConfirmed=false;
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                        FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+bundle.getString("confirmation")+" "+bundle.getString("step")+" "+bundle.getString("got")+" "+bundle.getString("skipped"),""));
                       //if (identity.isLoggedIn()){
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                         FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("invoice")+" "+bundle.getString("status")+" "+bundle.getString("using")+" "+bundle.getString("contactus")+"/"+bundle.getString("customer")+" "+bundle.getString("payment"),""));
                       //}
                       String js=jsA.toString();
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("a")+" "+bundle.getString("separate")+" "+bundle.getString("email")+" "+bundle.getString("should")+" "+bundle.getString("come")+" "+bundle.getString("from")+" "+bundle.getString("the")+" "+bundle.getString("payment")+" "+bundle.getString("processor")+" "+bundle.getString("confirming")+" "+bundle.getString("payment")+" "+bundle.getString("of")+" "+bundle.getString("amount")+" "+js,""));

                     }
                  } catch (PayPalRESTException e) {
                      httpreq.setAttribute("error", e.getMessage());
                     // add error msg to show via attribute error  but how and where why forward are commented out??
 	     log.severe("payment confirm rest error "+e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
        	  } catch (Exception e) {
		     httpreq.setAttribute("error", e.getMessage());
                     // add error msg to show
    		     log.severe("payment confirm  error "+e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
                  }

                 }//if payerId
               } catch (Exception e) {
		     httpreq.setAttribute("error", e.getMessage());
                     // add error msg to show
    		     log.severe("payment confirm  error "+e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
               }

 }


    //@PostMapping("/charge")
    String charge(NonceForm form, Map<String, Object> model) throws ApiException {
        //squareClient = new ApiClient();
        // To learn more about splitting payments with additional recipients,
        // see the Payments API documentation on our [developer site]
        // (https://developer.squareup.com/docs/payments-api/overview).
        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest()
            .idempotencyKey(UUID.randomUUID().toString())
            .amountMoney(new Money().amount(1_00L).currency("USD"))
            .sourceId(form.getNonce())
            .note("From a Square sample Java app");

        //PaymentsApi paymentsApi = new PaymentsApi(squareClient);

        //CreatePaymentResponse response = paymentsApi.createPayment(createPaymentRequest);

        //model.put("payment", response.getPayment());

        return "charge";
    }

/***paypal subscription


    Create a Billing Plan with the subscription/recurring payment properties and activate it.

    Create a Billing Agreement passing the ID of the plan you want to use for that particular customer.

    Redirect buyer to PayPal for approval of the agreement.

    Execute the agreement after buyer has approved it and returned back to your site.

*/

	/**
	 * Create a plan.
	 *
	 * https://developer.paypal.com/webapps/developer/docs/api/#create-a-plan
	 *
	 * @return newly created Plan instance
	 * @throws PayPalRESTException
	 */
	public Plan createPlan(APIContext context) throws PayPalRESTException, IOException {
		// Build Plan object
		Plan plan = new Plan();
		plan.setName("T-Shirt of the Month Club Plan");
		plan.setDescription("Template creation.");
		plan.setType("fixed");

		//payment_definitions
		PaymentDefinition paymentDefinition = new PaymentDefinition();
		paymentDefinition.setName("Regular Payments");
		paymentDefinition.setType("REGULAR");
		paymentDefinition.setFrequency("MONTH");
		paymentDefinition.setFrequencyInterval("1");
		paymentDefinition.setCycles("12");

		//currency
		Currency currency = new Currency();
		currency.setCurrency("USD");
		currency.setValue("20");
		paymentDefinition.setAmount(currency);

		//charge_models
		ChargeModels chargeModels = new com.paypal.api.payments.ChargeModels();
		chargeModels.setType("SHIPPING");
		chargeModels.setAmount(currency);
		List<ChargeModels> chargeModelsList = new ArrayList<ChargeModels>();
		chargeModelsList.add(chargeModels);
		paymentDefinition.setChargeModels(chargeModelsList);

		//payment_definition
		List<PaymentDefinition> paymentDefinitionList = new ArrayList<PaymentDefinition>();
		paymentDefinitionList.add(paymentDefinition);
		plan.setPaymentDefinitions(paymentDefinitionList);

		//merchant_preferences
		MerchantPreferences merchantPreferences = new MerchantPreferences();
		merchantPreferences.setSetupFee(currency);
		merchantPreferences.setCancelUrl("http://www.cancel.com");
		merchantPreferences.setReturnUrl("http://www.return.com");
		merchantPreferences.setMaxFailAttempts("0");
		merchantPreferences.setAutoBillAmount("YES");
		merchantPreferences.setInitialFailAmountAction("CONTINUE");
		plan.setMerchantPreferences(merchantPreferences);

		this.instance = plan.create(context);
		return this.instance;
	}

	/**
	 * Update a plan
	 *
	 * https://developer.paypal.com/webapps/developer/docs/api/#update-a-plan
	 *
	 * @return updated Plan instance
	 * @throws PayPalRESTException
	 */
	public Plan update(APIContext context) throws PayPalRESTException, IOException {

		List<Patch> patchRequestList = new ArrayList<Patch>();
		Map<String, String> value = new HashMap<String, String>();
		value.put("state", "ACTIVE");

		Patch patch = new Patch();
		patch.setPath("/");
		patch.setValue(value);
		patch.setOp("replace");
		patchRequestList.add(patch);

		this.instance.update(context, patchRequestList);
		return this.instance;
	}

	/**
	 * Retrieve a plan
	 *
	 * https://developer.paypal.com/webapps/developer/docs/api/#retrieve-a-plan
	 *
	 * @return the retrieved plan
	 * @throws PayPalRESTException
	 */
	public Plan retrieve(APIContext context) throws PayPalRESTException {
		return Plan.get(context, this.instance.getId());
	}


	public Plan createAgreement(APIContext context) throws PayPalRESTException, IOException {

// Create new agreement
Agreement agreement = new Agreement();
agreement.setName("Base Agreement");
agreement.setDescription("Basic Agreement");
agreement.setStartDate("2020-06-17T9:45:04Z");

// Set plan ID
Plan plan = new Plan();
plan.setId("P-0PK90852BK763535UTMSTGMQ");
agreement.setPlan(plan);

// Add payer details
Payer payer = new Payer();
payer.setPaymentMethod("paypal");
agreement.setPayer(payer);

// Set shipping address information
ShippingAddress shipping = new ShippingAddress();
shipping.setLine1("111 First Street");
shipping.setCity("Saratoga");
shipping.setState("CA");
shipping.setPostalCode("95070");
shipping.setCountryCode("US");
agreement.setShippingAddress(shipping);

// Create agreement
try {
  agreement = agreement.create(apiContext);

  for (Links links : agreement.getLinks()) {
    if ("approval_url".equals(links.getRel())) {
      URL url = new URL(links.getHref());

      //REDIRECT USER TO url

      break;
    }
  }
} catch (PayPalRESTException e) {
  log.severe(e.getMessage());
} catch (MalformedURLException e) {
  e.printStackTrace();
} catch (UnsupportedEncodingException e) {
  e.printStackTrace();
}


//After you extract the token, call the billing agreement execute method to complete
//the billing agreement, signing up the user for the associated subscription purchase.
//token obtained when creating the agreement (following redirect)
//Agreement agreement =  new Agreement();
agreement =  new Agreement();
//agreement.setToken(token);
agreement.setToken(accessToken);


try {
  Agreement activeAgreement = agreement.execute(apiContext, agreement.getToken());
  System.out.println("Agreement created with ID " + activeAgreement.getId());
} catch (PayPalRESTException e) {
  log.severe(e.getMessage());
}

//added
 return plan;

	}

/**
	 * Main method that calls all methods above in a flow.
	 *
	 * @param args
	 */
	public void PaySubscribe(String option) {
		try {
			//SubscriptionSample subscriptionSample = new SubscriptionSample();

			//APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			APIContext context = new APIContext(accessToken);

			//subscriptionSample.create(context);
			log.severe("create response:\n" + Plan.getLastResponse());
			//subscriptionSample.update(context);
			log.severe("plan updated");
			//subscriptionSample.retrieve(context);
			log.severe("retrieve response:\n" + Plan.getLastResponse());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
                }
        }


}