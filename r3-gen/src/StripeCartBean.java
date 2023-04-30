package com.rcomputer.genapp.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rcomputer.genapp.action.*;
//import static org.jboss.seam.ScopeType.SESSION;
//import org.jboss.seam.annotations.Scope;
import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.Remove;
//import org.jboss.seam.core.ResourceLoader;
//import org.jboss.seam.annotations.In;
import javax.enterprise.inject.Model;
//import org.jboss.seam.annotations.Logger;
//import org.jboss.seam.annotations.Name;
import javax.inject.Named;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.faces.application.FacesMessage;
//import org.jboss.seam.annotations.Destroy;
//import org.jboss.seam.annotations.web.RequestParameter;
//import org.jboss.seam.log.Log;
import java.util.logging.Logger;
//import org.jboss.seam.international.StatusMessages;
import javax.faces.application.FacesMessage;
//import org.jboss.seam.international.StatusMessage.Severity;
//import org.jboss.seam.international.StatusMessage;

//import org.jboss.seam.web.ServletContexts;
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
//import org.jboss.seam.faces.FacesMessages;

import org.apache.http.client.ClientProtocolException;
//import org.jboss.resteasy.client.ClientRequest;
//import org.jboss.resteasy.client.ClientResponse;
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
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import com.paypal.core.rest.OAuthTokenCredential;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;



@Named("r3Cart")
@SessionScoped
//@Transactional sept06 2018 removed was causing resourceloading issue You cannot set autocommit during a managed transaction

//there are 4 rest supporting module
//(1)shoppingCartBean is a restClient meant for payPal and uses paypal restClient apis(why does it have rest jar?)
//(2)R3RestClient is also a restClient but meant for Shopify and uses jax-rs apis
//(3)xxxPie/BarCharts uses javaScript based rest client to call 3r xxxEntityServices
//(4)xxxEntityService beans not client but server rest services and called by rest clients
// (1) saleRequest() method called by checkout.xhtml paypal checkout buttn and call paypal api
// (2) invoke paypal login page express payment request via  checkout.xhtml link button value approvalUrl / login to paypal
// (2b)paypal invokes makePayPalPayment method via f:viewAction in checkout.xhtml and takeAction method here to capture shipping info
//  and to show confirmpayment button
// (3) confirmPayment method called by checkout.xhtml payment execution request via payment module execute method

public class ShoppingCartBean implements java.io.Serializable{
   private Logger log = Logger.getLogger(ShoppingCartBean.class.getCanonicalName());

   @Inject
   Fpxxfq1a5xwwqqhxxxxxitemHome fpxxfq1a5xwwqqhxxxxxitemHome;
   @Inject
   Fpxxfq1a5xwwqqhxxxxxitemList fpxxfq1a5xwwqqhxxxxxitemList;
   @Inject
   Yxxxch522xhhxxhxxxxxclientList yxxxch522xhhxxhxxxxxclientList;
   List<Yxxxch522xhhxxhxxxxxclient> yxxxch522xhhxxhxxxxxclient;
   @Inject
   Trexuq244xwwqqhxxxxxcuordersList trexuq244xwwqqhxxxxxcuordersList;
   @Inject
   Jxxxuq201xwwqqhxxxxxcustomerHome jxxxuq201xwwqqhxxxxxcustomerHome;
   private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;


   private Boolean inSaleReady=true;
   private Boolean inPayment=false;
   private Boolean inApproved=false;
   private Boolean inConfirmed=false;
   private Boolean inPDSaleReady=true;
   private Boolean inPDPayment=false;
   private Boolean inPDApproved=false;
   private Boolean inPDConfirmed=false;
   private Boolean inAuthCaptureMode=false;
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
   String url=null;
   String currCode="USD";
   private ResourceBundle bundle=null;
    private FacesContext facesContext=null;
String authorizationID ="";


    @PostConstruct
    public void initialize() {
      facesContext = FacesContext.getCurrentInstance();
      bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");

    }


  public Boolean getInSaleReady() {
    return inSaleReady;
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
  public String takeAction(){
    String viewId =  FacesContext.getCurrentInstance().getViewRoot().getViewId();
    if (viewId.contains("checkout.")){
     extCtxt = FacesContext.getCurrentInstance().getExternalContext();
     httpreq = (HttpServletRequest) extCtxt.getRequest();
     if (httpreq.getParameter("PayerID") != null ){
      try{
       this.makePayPalPayment(httpreq.getParameter("PayerID"),httpreq.getParameter("guid"));
      }catch(Exception e){
       //we get exception since there is no ntgrok locally
       if(httpreq.getServerName().contains("ngrok") && httpreq.getServerName().contains("8080") ){
        return "raaspi.l3recommerce.com:8080/checkout.wflow";
       }

       log.severe(e.getMessage());
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("in")+" "+bundle.getString("paypal")+" "+bundle.getString("response")+" "+bundle.getString("handling")+", "+bundle.getString("try")+" "+bundle.getString("again"),""));

                     bcontinue=false;

      }
     }
    }
     return null;
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
           yxxxch522xhhxxhxxxxxclient = yxxxch522xhhxxhxxxxxclientList.getResultList();
           String clCurrCode=yxxxch522xhhxxhxxxxxclient.get(0).getK1xxuxxxbvxxxxxxxxxxcurrcode();
           if (clCurrCode != null && !clCurrCode.isEmpty()){
            currCode=clCurrCode;
           }
           inAuthCaptureMode=!yxxxch522xhhxxhxxxxxclient.get(0).getF4xxfxxxbvxxxxxxxxxxcartonfl();

           clientId=yxxxch522xhhxxhxxxxxclient.get(0).getDaxxuzxdssxxxxxxxxxxapiclientid();
           clientSecret=yxxxch522xhhxxhxxxxxclient.get(0).getDbxxuzxdssxxxxxxxxxxapiclientsecret();
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
           if(clientId.contains("Aag_9BB6b8VOSvkoXtFpiuLlGDHB0FSI_cfyq9GQTmWNLT_NiOOohrpQLMHG")){
            configurationMap.put("service.EndPoint", "https://api.sandbox.paypal.com");
            configurationMap.put("mode", "sandbox");
           }else{
            configurationMap.put("service.EndPoint", "https://api.paypal.com");
            configurationMap.put("mode", "live");
           }
           try {
            accessToken = new OAuthTokenCredential(clientId, clientSecret, configurationMap).getAccessToken();
            apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(configurationMap);

		} catch (Exception e) {
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
  // session scope, no init for pd
  inPDConfirmed=false;
  List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder('codcop');
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
  yxxxch522xhhxxhxxxxxclient = yxxxch522xhhxxhxxxxxclientList.getResultList();
  if(yxxxch522xhhxxhxxxxxclient.get(0).getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
   String clEmailAddress=yxxxch522xhhxxhxxxxxclient.get(0).getD4xxhxxrbv24xxxxxxxximailaddr();
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

 public void confirmPayment(){
 // (3) Payment confirmation by user and by client default payment is kept as autorized
 // after shipment is done a capture is done to convert authorized amount into captured amount.
 // if needed, manual capture can also be done at Paypal site
 // paypal, last step and invoked by user , button shown after paypal response from paypal f:viewaction invokes makePayPalPayment method
 // which in turn calls this final method
 // if netPay is zero then assume its cod/pos and paypal payment authorization is bypassed
 // otherwise calls itemHome.updateProductsToShip(guid,tranId,authcaptureMode) which will 
 // if cod will create invoice from order and payment from invoice
 // if paypal auth then will create invoice using the order info
 // sends emails as confirmation to user and client
               try{
                 if (fpxxfq1a5xwwqqhxxxxxitemList.getNetCartedPayTotal().compareTo( new BigDecimal("0.0"))==0){
                        //no paypal payment but cod shipment needs to be done
                        //look into adding support for POS logic here as well and clean up COD for India type
                        inPayment=false;
                        inApproved=false;
                        inSaleReady=true;
                        inConfirmed=true;
                        guid="cod";
                        List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder('cart');
                        String start =currentCartOrder.get(0).getA0xxuncobvxxxxxxxxxxpurchsno();
                        String end = currentCartOrder.get(0).getA0xxuncobvxxxxxxxxxxpurchsno();
                        vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();

                        //updates done here, below method eventually calls persist which has posting logic
                        //june 30 2018, if below method failed ie null no posting ,aug 16 should not be posting payment if authorize or if it fails
                        // this method ends up calling extended invoice and if payment extended payment which involves posting
                        if (fpxxfq1a5xwwqqhxxxxxitemHome.updateProductsToShip(guid,"",inAuthCaptureMode)==null){
                         return;
                        }
                        trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress);
                        if(yxxxch522xhhxxhxxxxxclient.get(0).getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
                         String clEmailAddress=yxxxch522xhhxxhxxxxxclient.get(0).getD4xxhxxrbv24xxxxxxxximailaddr();
                         if (clEmailAddress != null && !clEmailAddress.isEmpty()){
                          trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,clEmailAddress);//send copy if small, others should monitor via backoffice

                          // jay add client flag also
                         }
                        }
                        //mar10 2018 so that correct messages and buttons get rendered,
                        //july 02 2018, in next cart nothing is shown if same session, we need to set inSaleReady to true
                        // but check for inConfirm
                        // add logic not to show cart unless it matched the current owner/temp owner   
                        inSaleReady=true;
                        inConfirmed=false;
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("you")+" "+bundle.getString("will")+" "+bundle.getString("receive")+" "+bundle.getString("email")+" "+bundle.getString("from")+" "+bundle.getString("us")+" "+bundle.getString("confirming")+" "+bundle.getString("your")+" "+bundle.getString("cod")+" "+bundle.getString("order")+" "+bundle.getString("refrence")+"("+start+")",""));


                        return;
                 }
                 // NetCartedPayTotal has value and make payment (auth/capture) via paypal payment amount is same as NetCartedPayTotal
                 BigDecimal jsA=fpxxfq1a5xwwqqhxxxxxitemList.getNetCartedPayTotal();//save now since getNet amount checks for status which may change

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
                     List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder('cart');
                     vEmailAddress=currentCartOrder.get(0).getJxxxuq201xwwqqhxxxxxcustomer().getQ4xxhxxxbv24xxxxxxxximailaddr();
                     // update order / details statusflg to show paid and to show under history
                     //june 30 2018, below calls several methods ending in persist() which calls posting, but where shipment cost is posted???
                     //transactionId=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();//aug31 2018
                     transactionId="jay";
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
                     //2018 feb 27 only if size is small send to site admin as well
                     List<Xoxxuq2b4xwwqqhxxxxxcuodetails> currentCartOrderDet=fpxxfq1a5xwwqqhxxxxxitemList.getConfirmedCartedList("cart");
                     if (currentCartOrderDet.size() >0){
                      String start =currentCartOrderDet.get(0).getTrexuq244xwwqqhxxxxxcuorders().getA0xxuncobvxxxxxxxxxxpurchsno();
                      String end = currentCartOrderDet.get(0).getTrexuq244xwwqqhxxxxxcuorders().getA0xxuncobvxxxxxxxxxxpurchsno();
                      trexuq244xwwqqhxxxxxcuordersList.setReportName("fiTrexuq244xwwqqhxxxxxcuordersMaster");
                      trexuq244xwwqqhxxxxxcuordersList.eSend("SEMAIL",start,end,false,vEmailAddress);
                       if(yxxxch522xhhxxhxxxxxclient.get(0).getD9xxuxxxbvxxxxxxxxxxenterprisecompsize().equals("S")){
                         String clEmailAddress=yxxxch522xhhxxhxxxxxclient.get(0).getD4xxhxxrbv24xxxxxxxximailaddr();
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
                       inSaleReady=true;//for next cart sep04 2018
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
                       inConfirmed=false;
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
                     // add error msg to show via attribute error july 01 2018 but how and where why forward are commented out??
    		     log.severe(e.getMessage());
                     inConfirmed=false;
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("following")+" "+bundle.getString("error")+" "+bundle.getString("logged")+" "+e.getMessage(),""));
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+" "+bundle.getString("correct")+" "+bundle.getString("and")+" "+bundle.getString("try")+" "+bundle.getString("again")+", "+bundle.getString("or")+" "+bundle.getString("contact")+" "+bundle.getString("site")+" "+bundle.getString("support"),""));
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
                               inPayment=false;
                               inApproved=false;
                               inConfirmed=false;
        return "home";
 }


 public void salePDRequest() throws Exception
 {         // action by checkout salePDRequest button Place Order for nonpaypal PickUpDelivery
  bcontinue=true;
  inPDSaleReady=false;
  inPDConfirmed=false;
  inPDApproved=true;

  // vEmailAddress is initialized from cart order attach value, for guest will have a value. for login may or may not
  if (!vEmailAddress.contains("@")){
   //inPDConfirmed=false; check why vemailaddress has no value
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("missing"),""));


   //inPDApproved=false;
   //return;
  }

 }


 public void saleRequest() throws Exception
 {         // (1) action by checkout saleRequest button Paypal Purchase , variable values are session scope ie value held
                if (fpxxfq1a5xwwqqhxxxxxitemList.getNetCartedPayTotal().compareTo( new BigDecimal("0.0"))==0){
                                  inSaleReady=false;
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
    		     log.severe(e.getMessage());
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,e.getMessage()+", "+bundle.getString("correct")+" "+ bundle.getString("and")+", "+bundle.getString("try")+" "+ bundle.getString("again"),""));

                     bcontinue=false;
                     return;


		}

                // now get the order details from Fpxxfq1a5xwwqqhxxxxxitemList
                // create a new mehod to get totals from cuorder using getCurrentCartOrder

                List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder('cart');

			// ###Details exclude to be payed later
			// Let's you specify details of a payment amount.
                //
			Details details = new Details();
			details.setShipping(String.format("%.2f",currentCartOrder.get(0).getZ6xxzltxavxxxxxxxxxxdelivchrgt().add(currentCartOrder.get(0).getZ7xxzmtxavxxxxxxxxxxmiscchrgt()).subtract(fpxxfq1a5xwwqqhxxxxxitemList.getCartedPayDelMiscLaterTotal())));
			details.setSubtotal(String.format("%.2f",currentCartOrder.get(0).getZ7xxzbtxavxxxxxxxxxxbaseamountt()));
			details.setTax(String.format("%.2f",currentCartOrder.get(0).getZ8xxzxz1avxxxxxxxxxxtax1amtt().add(currentCartOrder.get(0).getZ9xxzxz2avxxxxxxxxxxtax2amtt()).add(currentCartOrder.get(0).getZaxxzxz3avxxxxxxxxxxtax3amtt()).subtract(fpxxfq1a5xwwqqhxxxxxitemList.getCartedPayTaxLaterTotal()) ));


			// ###Amount
			// Let's you specify a payment amount.
			Amount amount = new Amount();
                        // if item curr is null or empty get from client, client set default from
                        // locale ( whose locale) but can be changed
			amount.setCurrency(currCode);
			// Total must be equal to sum of shipping(delivery charge) , tax (tax1) and subtotal (baseamount).
                        // misc charge will be added to delivery charge with a note
			amount.setTotal(String.format("%.2f",(currentCartOrder.get(0).getZ1xxztprlxxxxxxxxxxxamounttotal()).subtract(fpxxfq1a5xwwqqhxxxxxitemList.getTotalCartedPayLater())));
			amount.setDetails(details);

			// ###Transaction
			// A transaction defines the contract of a
			// payment - what is the payment for and who
			// is fulfilling it. Transaction is created with
			// a `Payee` and `Amount` types
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction
					.setDescription("This is the payment transaction description.");

                        // a ListofItems to show as order
			ArrayList<Item> items = new ArrayList<Item>();


			// The Payment creation API requires a list of
			// Transaction; add the created `Transaction`
			// to a List
                // use a for loop using fpxxfq1a5xwwqqhxxxxxitemList.getCartedList()
                // we can decide here intent to be authorize (to hold amount and capture payment after shipment)
                // or sale(if SI-P (pay and PickUp POS ?? by vendor/customer) or SI-DG (digital goods)  or SI-S? (drop ship) )
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
                  item.setCurrency(currCode);
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

                        //mar10 2018 allow local test before production
                        //upto login uses rest ie http req/response but after login url redirect is used
                        // along with local viewaction to process the returned data and needs internet access from paypal
                        // use ngrok url (which points to local host:8080) if port 8080 detected
                        String revisedUrl=httpreq.getServerName() + ":" + httpreq.getServerPort();
                        if(yxxxch522xhhxxhxxxxxclient.get(0).getZaxxuxxxbvxxxxxxxxxxpop3pass() !=null
                          && !yxxxch522xhhxxhxxxxxclient.get(0).getZaxxuxxxbvxxxxxxxxxxpop3pass().isEmpty()){
                         revisedUrl=yxxxch522xhhxxhxxxxxclient.get(0).getZaxxuxxxbvxxxxxxxxxxpop3pass()+".ngrok.io";
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
                        List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = fpxxfq1a5xwwqqhxxxxxitemList.getCurrentCartOrder('cart');
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
		 amount.setCurrency(currCode);
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
                        if(accessToken.isEmpty()){
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
			// instrument. Default is ‘false’.
			capture.setIsFinalCapture(true);


			// Capture by POSTing to
			// URI v1/payments/authorization/{authorization_id}/capture
			Capture responseCapture = authorization.capture(apiContext, capture);
                        extCtxt = FacesContext.getCurrentInstance().getExternalContext();
                        httpreq = (HttpServletRequest) extCtxt.getRequest();
			httpreq.setAttribute("response", Authorization.getLastResponse());
                        //transactionId=payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();//aug31 2018

		        log.info("#{messages['capture']} #{messages['id']}+ responseCapture.getId()"+" " + "#{messages['and']} #{messages['status']}"+ responseCapture.getState());
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







}