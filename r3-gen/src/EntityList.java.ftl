<#assign messagingCandidate = "N">  
<#assign mailingCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#assign menuAttributesp2 = menuAttributes?substring(efS,efE)>
<#if (menuAttributes?contains("M") || menuAttributes?contains("J") ) >
 <#assign mailingCandidate ="Y" >
 <#assign qKey ="" >
 <#if (menuAttributesp2?contains("20"))>
  <#assign unsctype ="1" >
  <#assign qKey ="a0xxukxxbvxxxxxxxxxxcustomer" >
 </#if>
 <#if (menuAttributesp2?contains("30"))>
  <#assign unsctype ="2" >
  <#assign qKey ="a0xxukxxbvxxxxxxxxxxvendor" >
 </#if>
 <#if (menuAttributesp2?contains("40"))>
  <#assign unsctype ="3" >
  <#assign qKey ="a0xxuktxbvxxxxxxxxxxemployee" >
 </#if>

</#if>
<#if (menuAttributes?contains("P") ) >
 <#assign messagingCandidate ="Y" >
</#if>
<#include "../util/TypeInfo.ftl">
<#include "../view/assigns/mergedassigns.properties" >
<#assign clientImailaddr = "d4xxhxxrbv24xxxxxxxximailaddr">
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign listName = componentName + "List">
<#assign homeName = componentName + "Home">
<#assign ids ="xxxxxxxxx">
<#assign idsType ="xxxxxxxxx">
<#assign ids1 ="xxxxxxxxx">
<#assign ids1Type ="xxxxxxxxx">
<#assign firstTime="Y"> 
<#assign itemClass ="Y" >
<#assign statusFlagField="Not assigned">
<#assign estatusFlagField="zexxzzfxhhxxxxxxxxxxstatusfl">
<#assign cstatusFlagField="zaxxzzfxhhxxxxxxxxxxstatusfl">
<#assign vstatusFlagField="zdxxzzfxhhxxxxxxxxxxstatusfl">
<#assign statusFlagDateField="Not assigned">
<#assign imailaddrField="Not assigned">
<#assign dateField="Not assigned">
<#assign documentField = "" >
<#assign keyField = "" >
<#assign descriptField = "" >
<#assign notesField = "" >
<#assign keyFieldType = "" >
<#assign keyAutoGen="Y">
<#assign ownerField="">
<#assign parentName="">
<#assign clientKeyField="a0xxukxxbvxxxxxxxxxxclientversion">
<#assign showi=0>
<#assign search1="">
<#assign search2="">
<#assign search3="">
<#assign clientClientversion="a0xxukxxbvxxxxxxxxxxclientversion">
<#assign clobdataentityDataFieldName="b1xxuzaxbvxxxxxxxxxxdata">
<#assign itemQtyField="b0xxziqxlvxxsaxxxxxxquantity">




package ${actionPackage};

<#if pojo.packageName != "">
import ${pojo.packageName}.*;
</#if>
import org.picketlink.Identity;
import org.picketlink.idm.IdentityManagementException;
import org.picketlink.authentication.AuthenticationException;
import org.picketlink.common.exceptions.PicketLinkException;

import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query; 
import org.apache.deltaspike.data.api.QueryParam; 
import org.apache.deltaspike.data.api.Repository; 
import org.apache.deltaspike.data.api.SingleResultType; 

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ByteArrayInputStream;


import java.util.Date;
import java.util.Calendar;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext; 
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.annotation.PostConstruct;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.SimpleFileResolver;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import net.sf.jasperreports.engine.SimpleJasperReportsContext;
import net.sf.jasperreports.repo.FileRepositoryService;
import net.sf.jasperreports.repo.FileRepositoryPersistenceServiceFactory;
import net.sf.jasperreports.repo.RepositoryService;
import net.sf.jasperreports.repo.PersistenceServiceFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.net.URL;

import javax.faces.application.FacesMessage;
import java.text.SimpleDateFormat; 

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.Session;
import org.hibernate.type.*;
import javax.mail.MessagingException;
import com.rcomputer.genapp.action.SessionConfig;


<#if (menuAttributesp2?contains("89") ) >
import biweekly.component.VEvent;
import biweekly.ICalendar;
import biweekly.property.Attendee;
import biweekly.property.ProductId;
import biweekly.io.text.ICalWriter;
import biweekly.ICalVersion;
import biweekly.Biweekly;

</#if>

import com.sendgrid.smtpapi.SMTPAPI;
//simple-mail

import javax.mail.BodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import com.outjected.email.api.ContentDisposition;
import com.outjected.email.api.EmailMessage;
import com.outjected.email.api.MessagePriority;
import com.outjected.email.api.SendFailedException;
import com.rcomputer.genapp.action.MailMessageImpl;
import com.rcomputer.genapp.action.SimpleMailConfig;
import com.outjected.email.impl.attachments.URLAttachment;
import com.outjected.email.impl.attachments.InputStreamAttachment;
import com.outjected.email.impl.templating.freemarker.FreeMarkerTemplate;
import com.outjected.email.impl.util.EmailAttachmentUtil;
import com.outjected.email.impl.util.MailTestUtil;
import com.outjected.email.impl.util.MessageConverter;
//import com.outjected.email.util.SMTPAuthenticator;
//import com.outjected.email.util.TestMailConfigs;
import com.google.common.io.Resources;
import com.outjected.email.api.EmailAttachment;
import com.outjected.email.api.MailMessage;
import com.outjected.email.api.ContentType;
 import org.jsoup.Jsoup;
 //put conditional import
 import org.jsoup.nodes.Document;
 import org.jsoup.nodes.Element;
 import org.jsoup.select.Elements;
 import org.jsoup.safety.Whitelist;
 import org.primefaces.model.DualListModel;

<#if (menuAttributesp2?contains("1A") || menuAttributesp2?contains("18") || menuAttributesp2?contains("19") ) >
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
</#if>





<#if (componentName?substring(0,1)=="n")>   
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
</#if>

<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
      <#break>
    </#foreach>
<#else>
     <#assign ids = pojo.identifierProperty.name>
</#if>
<#if (ids?substring(pkS,pkE)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
</#if>

/**
* This is Action List class 
* @author 3r Computer Systems  
* @version 2.0
*/

@Named("${listName}")
@ViewScoped
public class ${entityName}List implements Serializable
{
   private Logger log = Logger.getLogger(${entityName}.class.getCanonicalName());
	@Inject
	Identity identity;
   @Inject R3RestClient r3RestClient;

   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
   <#if menuAttributesp2 != "40" >
        //except for employee itself
	private ${employeeEntityName?cap_first} ${employeeEntityName};
   </#if>
    @Inject 
    ${employeeEntityName?cap_first}Home ${employeeEntityName}Home;
    @Inject 
    ${blobdataEntityName?cap_first}Home ${blobdataEntityName}Home;

    @Inject 
    ${userEntityName?cap_first}List ${userEntityName}List;

<#if menuAttributesp2 == "23" || menuAttributesp2 == "24">
	@Inject
	${usagebyperiodsEntityName?cap_first}List ${usagebyperiodsEntityName}List;

</#if>
<#if menuAttributesp2 == "56" >
	@Inject 
	${userEntityName?cap_first}Home ${userEntityName}Home;
	@Inject 
	${itemEntityName?cap_first}List ${itemEntityName}List;

</#if>
<#if menuAttributesp2 == "59" >
	@Inject 
	${itemEntityName?cap_first}Home ${itemEntityName}Home;

</#if>
<#if menuAttributesp2 == "51" >
    //@Inject Authenticator authenticator;
    // authenticator extends baseauthenticator needs qualifier to resolve optionslist injecting authenticator to get country
    // jsf does not have this problem 
    // bypass plus a good idea is to store country and language etc in userprofil record 00 and optionslist should get from there
    // p1 for country p2 for language p3 for variant
	@Inject 
	${userproflEntityName?cap_first}Home ${userproflEntityName}Home;
	private ${userproflEntityName?cap_first} ${userproflEntityName};
	private ${userEntityName?cap_first} ${userEntityName};
	@Inject 
	${clobdataEntityName?cap_first}Home ${clobdataEntityName}Home;


</#if>
<#if menuAttributesp2 == "52" >
	@Inject
	${rate1fEntityName?cap_first}List ${rate1fEntityName}List;
	@Inject
	${cuordersEntityName?cap_first}Home ${cuordersEntityName}Home;
                 @Inject
                 ${clientEntityName?cap_first}Home  ${clientEntityName}Home;


</#if>


<#if menuAttributesp2 == "89" >
	@Inject 
	${scheduleDetailsEntityName?cap_first}List ${scheduleDetailsEntityName}List;
	private ${scheduleDetailsEntityName?cap_first} ${scheduleDetailsEntityName};
	@Inject 
	${scheduleDetailsEntityName?cap_first}Home ${scheduleDetailsEntityName}Home;
	@Inject 
	${scheduleEntityName?cap_first}Home ${scheduleEntityName}Home;
	@Inject 
	${employeeEntityName?cap_first}List ${employeeEntityName}List;
	@Inject 
	${vendorEntityName?cap_first}Home ${vendorEntityName}Home;
	private ${vendorEntityName?cap_first} ${vendorEntityName};
	@Inject 
	${customerEntityName?cap_first}Home ${customerEntityName}Home;
	private ${customerEntityName?cap_first} ${customerEntityName};
	@Inject 
	${membersgroupEntityName?cap_first}Home ${membersgroupEntityName}Home;
	private ${membersgroupEntityName?cap_first} ${membersgroupEntityName};
	@Inject 
	${clobdataEntityName?cap_first}Home ${clobdataEntityName}Home;
	@Inject 
	${clobdataEntityName?cap_first}List ${clobdataEntityName}List;
	private ${clobdataEntityName?cap_first} ${clobdataEntityName};
	private ${blobdataEntityName?cap_first} ${blobdataEntityName};
	 @Inject 
	 ${userEntityName?cap_first}Home ${userEntityName}Home;
	 private ${userEntityName?cap_first} user;

</#if>

   <#if (menuAttributesp2 ="60"  ) >
	 @Inject 
	 ${accountEntityName?cap_first}Home ${accountEntityName}Home;
        @Inject
        ${clientEntityName?cap_first}List ${clientEntityName}List;
        ${clientEntityName?cap_first} ${clientEntityName};

   </#if>
   <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
	 @Inject 
	 ${userEntityName?cap_first}Home ${userEntityName}Home;
	 private ${userEntityName?cap_first} user;
         @Inject
         Yxxxch522xhhxxhxxxxxclientHome yxxxch522xhhxxhxxxxxclientHome;
         <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30") >
          @Inject
          ${employeeEntityName?cap_first}List ${employeeEntityName}List;
         </#if>
         <#if (menuAttributesp2 ="20" && ccontactEntityName?? && ccontactEntityName?length > eL) >
          @Inject
          ${ccontactEntityName?cap_first}List ${ccontactEntityName}List;
          ${ccontactEntityName?cap_first}  ${ccontactEntityName};
         </#if>
         <#if (menuAttributesp2 ="30" && vcontactEntityName?? && vcontactEntityName?length > eL) >
          @Inject
          ${vcontactEntityName?cap_first}List ${vcontactEntityName}List;
          ${vcontactEntityName?cap_first}  ${vcontactEntityName};
         </#if>
      @Inject
      ${vendorEntityName?cap_first}Home ${vendorEntityName}Home;
      @Inject
      ${customerEntityName?cap_first}Home ${customerEntityName}Home;
	@Inject 
	${membersgroupEntityName?cap_first}Home ${membersgroupEntityName}Home;
	private ${membersgroupEntityName?cap_first} ${membersgroupEntityName};
      @Inject
      ${clobdataEntityName?cap_first}Home ${clobdataEntityName}Home;
      @Inject
      ${clobdataEntityName?cap_first}List ${clobdataEntityName}List;
      private ${clobdataEntityName?cap_first} ${clobdataEntityName};

   </#if>
   <#if menuAttributesp2 == "1A" > 
	@Inject 
	${userproflEntityName?cap_first}Home ${userproflEntityName}Home;
	private ${userproflEntityName?cap_first} ${userproflEntityName};
	@Inject 
	${customerEntityName?cap_first}Home ${customerEntityName}Home;
	private ${customerEntityName?cap_first} ${customerEntityName};
	@Inject 
	${userEntityName?cap_first}Home ${userEntityName}Home;
	private ${userEntityName?cap_first} ${userEntityName};
	@Inject
	${rate1fEntityName?cap_first}List ${rate1fEntityName}List;
                 @Inject
                 ${clientEntityName?cap_first}List ${clientEntityName}List;
                 ${clientEntityName?cap_first} ${clientEntityName};
                 @Inject 
                 ${serialnumbersEntityName?cap_first}List ${serialnumbersEntityName}List;


   </#if>
   <#if menuAttributes?contains("T") >
        // private String userFullName="";



   </#if>
   <#if menuAttributesp2 == "1M" > 
	@Inject 
	${clobdataEntityName?cap_first}Home ${clobdataEntityName}Home;
   </#if>
   <#if menuAttributesp2 == "36" > 
	@Inject 
	${venarthaEntityName?cap_first}Home ${venarthaEntityName}Home;
   </#if>

	 @Inject 
	 ${truefalseEntityName?cap_first}Home ${truefalseEntityName}Home;
   <#if !(menuAttributesp2 =="5A")> 
	 private ${truefalseEntityName?cap_first} ${truefalseEntityName};
   </#if>
   <#if (menuAttributesp2 =="9C")> 
	 private ${rate1fEntityName?cap_first} ${rate1fEntityName};
   </#if>

    @Inject CustomIdentity customIdentity; 
    <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
     private DualListModel<${entityName}> toDualSuggestList;
      private DualListModel<${employeeEntityName?cap_first}> ccDualSuggestListE;
    </#if>
    @PostConstruct
    public void initialize() {
      ownerCode=customIdentity.getOwner();
      ownerCddCode=ownerCode.substring(ownerCode.length()-3,ownerCode.length() );
      productCode=customIdentity.getProduct();
      subProductCode=customIdentity.getSubProduct();

     {
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
      if (userIP == null) {  
       userIP = req.getRemoteAddr();  
       if (userIP == null) {  
        userIP = "noIP";  
       }      
      }
     }
     masterSiteCode=customIdentity.getMasterSiteCode();
        <#if keyAutoGen=="Y"  && keyField == ""> 
              <#if menuAttributesp2 == "68" >
                int listSize=get${entityName?substring(10)}SuggestSeqList().size();
                if(listSize > 2000){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("upto")+" "+bundle.getString("2000")+ " "+bundle.getString("journal")+ " "+bundle.getString("entries")+ " "+bundle.getString("shown")+ ", "+bundle.getString("change")+ " "+bundle.getString("start")+ " "+bundle.getString("value")+ " "+bundle.getString("for")+ " "+bundle.getString("more"), ""));
                }
                start=  listSize==0 ? "0" : get${entityName?substring(10)}SuggestSeqList().get(0).getB5cczjsibvxxxxxxxxxxjnlseq()+"" ;
                end=    listSize==0 ? "0" : get${entityName?substring(10)}SuggestSeqList().get(listSize-1).getB5cczjsibvxxxxxxxxxxjnlseq()+"";
              <#else>
                int listSize=get${entityName?substring(10)}KeyList().size();
                start=  listSize==0 ? "0" : String.valueOf(get${entityName?substring(10)}KeyList().get(0)) ;
                end=    listSize==0 ? "0" : String.valueOf(get${entityName?substring(10)}KeyList().get(listSize-1));
              </#if>
        <#else>
           int listSize=get${entityName?substring(10)}KeyList().size();
           start=  listSize==0 ? "0" : get${entityName?substring(10)}KeyList().get(0) ;
           end=    listSize==0 ? "0" : get${entityName?substring(10)}KeyList().get(listSize-1);
        </#if>
        <#if menuAttributesp2 == "60" >
         if(fYearEndS == null || fYearEndS.isEmpty() ){   
          ${clientEntityName?cap_first} client=${clientEntityName}List.getKeyToEntity("01");
          fYearEndS=new SimpleDateFormat("yyyy MMM dd").format(client.getZcxxdwfebvxxxxxxxxxxfyrend());
         }//show it in report parameter selection
        </#if>

          // initialize mailrelay0ff
          <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
            Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
             .createQuery(
             "select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
             .setParameter("nKeyName","01")
             .setParameter("owner2", owner2Code)
             .getSingleResult();
            if(client.getP1xxfxxxbvxxxxxxxxxxconfirm()!=null ){
             mailRelayOff=client.getP1xxfxxxbvxxxxxxxxxxconfirm();
            }else{//null means default is mailrelay
             mailRelayOff=false;
            }
           List<${entityName}> source = new ArrayList<${entityName}>();
           source=this.getSuggestList("email");
           List<${entityName}> target = new ArrayList<${entityName}>();
           toDualSuggestList = new DualListModel<${entityName}>(source, target);

           <#if (menuAttributesp2 !="40")>
            List<${employeeEntityName?cap_first}> sourceE = new ArrayList<${employeeEntityName?cap_first}>();
            sourceE=${employeeEntityName}List.getSuggestList("emailE");
            List<${employeeEntityName?cap_first}> targetE = new ArrayList<${employeeEntityName?cap_first}>();
            ccDualSuggestListE = new DualListModel<${employeeEntityName?cap_first}>(sourceE, targetE);
           <#else>
            List<${employeeEntityName?cap_first}> sourceE = new ArrayList<${employeeEntityName?cap_first}>();
            sourceE=getSuggestList("emailE");
            List<${employeeEntityName?cap_first}> targetE = new ArrayList<${employeeEntityName?cap_first}>();
            ccDualSuggestListE = new DualListModel<${employeeEntityName?cap_first}>(sourceE, targetE);
           </#if>
          </#if>
          mailingSource="<p style=\"font-family:arial;color:black;font-size:20px;\">";
          <#if menuAttributesp2 =="33">
           mailingSource=mailingSource+"We would appreciate a propmpt response for our request for a quatation. We have attached the details as an attachment to this email. </p>"; 
          <#elseif menuAttributesp2 =="34">
           mailingSource=mailingSource+"We would appreciate a propmpt response for our purchase Order, we have attached the PO details as an attachment to this email.</p>";
          <#elseif menuAttributesp2 =="56">
           mailingSource=mailingSource+"Thank you for visiting this site "+urlName+" and using our services. <br></br>You may use your existing Social Media logon id or Sign up using our App and use a new logon id and password. Using a logon Id, allows better user experience like access to usage history, limited file uploads or editing options. There is a password reset option, in case you have an Id but don't remember the password.<br></br>From time to time, we remove Ids which are inactive for a long time.  </p>"
                      +"<p style=\"font-family:arial;color:black;font-size:20px;\"> Just login once in a while, browse around and keep your account active."     ;
          <#else>
           mailingSource=mailingSource+"Thank you for using our service. We have attached your receipt as a confirmation.</p>";
          </#if>
                        //context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext(); 
                        //  context,req and hostUrl already set in construct
                        String serverName=context.getServerInfo();// check if tomcat or wildfly
                        if(serverName.contains("omcat")){
                         tomeeYN=true;
                        }

          if(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-LOGO-C","PIC",0) !=null){
                        int hostPort=0;
                        if(req.getServerPort()==8080){
                         hostUrl=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort(); 
                        }else{
                         hostUrl=req.getScheme()+"://"+req.getServerName(); 
                        }  
           String quotePE="\"";
           mailingSource=mailingSource+"<img  alt=\"logo\""+" src="+quotePE+hostUrl+"/ImageServletCdi/?seq=1&amp;id=B3R-LOGO-C&amp;height=50"+quotePE+"/>";//email needs full url  
          }
    }

   private Boolean showNamesYN = false;//needed for mailrelay and if all bcc for non relay
   private Boolean showAsBCCYN = false;
   private Map <String,String> fieldKeyList=null;
   private String owner2Code="";
   private String masterSiteCode="";
   private String selectedOwnerCode="";
   private String clientEMail="";
   private String eMailFirstName="";
   private String eMailLastName="";
   private String eMailAddress="";//used by Ical 
   private String e1mailAddress="";//used by emailsend
   private String userFullName="";
   private String timeStamp="";
   private String dataOwner2Code="";
     private String ownerCode="sss";
     private String subProductCode="";
      private String ownerCddCode="";
      private String productCode="";


      private int mprinted=512;
      private int mdel=256;
      private int mmark=128;
      private int munmark=1023;
      private int mconsign=64;
      private int mnoMail=64;
      private int minvoiced=64;
      //  can be used for other status, use it for 1st entry in group,account or to mark a row as editable etc 
      //               where line field is not there 
      private int mpartial=32;
      private int mshipped=32;
      private int mpaid=16;
      private int mclosed=8;
      private int mreturn=4;
      private int mcopy=2;
      // copy means record was copied from another 
      private int mtoPay=2;
      //open becomes active  , mutually exclusive
      private int mactive=1;
      private int mordered=1;
      private int mopen=0;
      private int category;
      private int subcategory;
      private int subcategory3;
      private int categoryUi;
      private int subcategoryUi;
      private String itemTagType="";
      // open means record created
      // use setXx(getXx()| mcopy)) to set copy flag leaving other bits as is 
      // use setXx(getXx()& _mcopy)) to clear copy flag leaving other bits as is 
      // the following shows which bit counting 0 as the right most bit 
      // used as if bitset(status,_matcive)
      // or as iif(bitset(status,_mmark),.t.,.f.)
      //_mactive=0  && 0th bit from right starting at 0 bit, value 1
      private int _mopen=0;
      //0th bit ,numeric value 0
      private int _mactive=0;
      // && 0th bit ,numeric value 1
      private int _mcopy=1;
      //   && 1th bit ,numeric value 2
      private int _mreturn=2;
      // && 2nd bit                4 
      private int _mclosed=3;
      // && 3rd                    8 
      private int _mpaid=4;
      //   && 4th                   16
      private int _mpartial=5;
      private int _mshipped=5;
      // && 5th                   32 
      private int _mconsign=6;
      private int _minvoiced=6;
      // && 6th                   64
      private int _mmark=7;
      //    && 7th                   128
      private int _mdel=8;
      //     && 8th                    
      private int _mprinted=9;
      // && 9th                   512 
      private Calendar calendar = Calendar.getInstance();
      private Calendar calendare = Calendar.getInstance();
      private DataSource ds;
      private String countryIsoEq="";
        boolean mailRelayOff=true; 
	private boolean bcontinue = true;
	private boolean showSharedData = false;
	private boolean showResultsCount = false;
	private boolean showResultsData = false;
        private Integer paramResultsCount = 0;
        private BigDecimal allow3Amount=new BigDecimal("0.0");
        <#if (menuAttributesp2?contains("1A"))>
         private String sortByValue="bm";
         private Integer dpr=16;
        </#if>


     Map parameters = new HashMap();
     int xvc=1;
     String reportNamePrefix="";
     String reportNameMinusPrefix="";
     List<${entityName}> sresults=null;
     <#if (menuAttributesp2 ="89" ) >
     List<${employeeEntityName?cap_first}> eresults=null;
     List<${employeeEntityName?cap_first}> eresults2=null;
     List<${vendorEntityName?cap_first}> vresults=null;
     List<${vendorEntityName?cap_first}> vresults2=null;
     List<${customerEntityName?cap_first}> cresults=null;
     List<${customerEntityName?cap_first}> cresults2=null;
     </#if>
     <#if (menuAttributesp2 ="20" )  >
     List<${customerEntityName?cap_first}> cresults2=null;
     <#if (ccontactEntityName?? && ccontactEntityName?? && ccontactEntityName?length > eL)>
      List<${ccontactEntityName?cap_first}> conresults=null;
      List<${ccontactEntityName?cap_first}> conresults2=null;
     </#if>
     </#if>
     <#if (menuAttributesp2 ="30" ) >
     List<${vendorEntityName?cap_first}> vresults2=null;
     <#if (vcontactEntityName?? && vcontactEntityName?? && vcontactEntityName?length > eL)>
     List<${vcontactEntityName?cap_first}> vonresults=null;
     List<${vcontactEntityName?cap_first}> vonresults2=null;
     </#if>
     </#if>
     <#if (menuAttributesp2 ="40" ) >
     List<${employeeEntityName?cap_first}> eresults2=null;
     </#if>
     <#if (menuAttributesp2 ="52" ) >
      private List <String> clientPayByList=new ArrayList<String>();
      private String clientPayBySelected="";// depends on the site


     </#if>

     List<${employeeEntityName?cap_first}> ccresults=new ArrayList<${employeeEntityName?cap_first}>();
     //String lorderColumn = "a0xxuobxbxxxxxxxxxxxsid";
     //String lorderDirection = "desc";
     //String orderColumnPrev = "";
     //String orderDirectionPrev = "";
     //String lorder ="a0xxuobxbxxxxxxxxxxxsid desc";
     //remove above after test check new assigns below
     private String eMailingAddress1="";
     private String eMailingAddress2="";
     private String eMailingAddress3="";
     private String eMailingAddress4="";
     private Integer eMailingAttachSeq1=-1;
     private Integer eMailingAttachSeq2=-1;
     private Integer eMailingAttachSeq3=-1;
     private Integer eMailingAttachSeq4=-1;
     private Integer eMailingAttachSeq5=-1;
     private Integer eMailingTextAttachSeq1=-1;
     private Integer eMailingTextAttachSeq2=-1;
     private Integer eMailingTextAttachSeq3=-1;
     private Integer eMailingTextAttachSeq4=-1;
     private Integer eMailingTextAttachSeq5=-1;
     private Boolean[] checkMapI=new Boolean[6];
     private Boolean[] checkMapT=new Boolean[6];

     private Integer maxResultsVal;// changes as 6/50/100 rows
     private String subKey = "";  
     private Integer optionNumber=1;
     // id and 8 columns, save in userprofl and increase by 8 but check against max cols
     private Boolean skipColumns=false;
     private Boolean options01Show=true;// show as default
     private Boolean options02Show=false;
     private Boolean options03Show=false;
     private Boolean options04Show=false;
     private Boolean options05Show=false;
     private Boolean options06Show=false;
     private Boolean options07Show=false;
     private Boolean options08Show=false;
     private Boolean options09Show=false;
     private Boolean options10Show=false;
     private Boolean options11Show=false;
     private Boolean options12Show=false;
     private Boolean options13Show=false;
     private Boolean options14Show=false;
     private Boolean options15Show=false;
     private Boolean options16Show=false;
     private Boolean options17Show=false;
     private Boolean options18Show=false;
     private Boolean options19Show=false;
     private Boolean options20Show=false;
     private Boolean options21Show=false;
     private Boolean options22Show=false;
     private Boolean options23Show=false;
     private Boolean options24Show=false;
     private Boolean options25Show=false;
     private Boolean options26Show=false;
     private Boolean options27Show=false;
     private Boolean options28Show=false;
     private Boolean options29Show=false;
     private Boolean options30Show=false;
     private Boolean options31Show=false;
     private Boolean options32Show=false;
     private Boolean options33Show=false;
     private Boolean options34Show=false;
     private Boolean options35Show=false;
     private Boolean options36Show=false;
     private Boolean options37Show=false;
     private Boolean options38Show=false;
     private Boolean options39Show=false;
     private Boolean options40Show=false;
     private Boolean options41Show=false;
     private Boolean options42Show=false;
     private Boolean options43Show=false;
     private Boolean options44Show=false;
     private Boolean options45Show=false;
     private Boolean options46Show=false;
     private Boolean options47Show=false;
     private Boolean options48Show=false;
     private Boolean options49Show=false;
     private Boolean options50Show=false;
     private Boolean options51Show=false;
     private Boolean options52Show=false;
     private Boolean options53Show=false;
     private Boolean options54Show=false;
     private Boolean options55Show=false;
     private Boolean options56Show=false;
     private Boolean options57Show=false;
     private Boolean options58Show=false;
     private Boolean options59Show=false;
     private Boolean options60Show=false;
     private String headers ="";
     private String[] showColumnNames =new String[138];
     private Map <String,String> showClassNames=null;
     private String   selectedClass="com.rcomputer.genapp.model.Fxxxuq111xwwqqhxxxxxaddress";
     private String   selectedQualifier="de";
     private Boolean tomeeYN = false;// to allow myfaces vd mojarra jsf or jndi naming

     <#if (menuAttributesp2 ="51") >
           
            String optionOptions="";
            String optionPurpose="";
            String optionFilter="";
            Integer indexStart=0;
            Integer indexEnd=0;
            String optionFilterRevised="";
            String transformedValue="";
            String transformedPurposeValue="";
            Boolean doneOnce=false;
            String entityCode="";
            int optionNo=0;
            //productCode already set from customIdentity
        </#if>


      FacesContext facesContext = FacesContext.getCurrentInstance(); 
      ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
      ///SEVERITY_INFO, "any string in quotes"+e.getMessage+bundle.getString("id_password_not_matching")

      ExternalContext externalContext = facesContext.getExternalContext(); 
      // if following can be set here, remove set in postconstruct
      ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext(); 
      HttpServletRequest req = (HttpServletRequest) externalContext.getRequest(); 
      String hostUrl="";
                HttpSession session = req.getSession();

                String urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();
                int urlPort=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerPort();

                Locale browserLocale=facesContext.getViewRoot().getLocale();
      private String userIP = req.getHeader("X-FORWARDED-FOR");

      HttpServletResponse resp = (HttpServletResponse) externalContext.getResponse(); 
	 private static final Pattern FROM_PATTERN = Pattern.compile(
			"(^|\\s)(from)\\s", 2);
	 private static final Pattern WHERE_PATTERN = Pattern.compile(
			"\\s(where)\\s", 2);
	 private static final Pattern ORDER_PATTERN = Pattern.compile(
			"\\s(order)(\\s)+by\\s", 2);

     private static final String EJBQL = "select ${componentName} from ${entityName} ${componentName} "  ;

     private static final String[] RESTRICTIONS = {
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if !c2h.isCollection(property) && !isToOne(property)>
   <#-- not foreign or collection properties  property name ${property.name} -->
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#if isString(componentProperty)>
        "lower(${componentName}.${property.name}.${componentProperty.name}) like lower(concat(${'#'}{${listName}.${componentName}.${property.name}.${componentProperty.name}},'%'))",
    </#if>
   </#foreach>
  <#else>
   <#if isString(property)>
     <#if property.name?substring(pfS,pfE)=="to"> 
      <#assign ownerField=property.name>
     </#if>   
     <#if property.name?substring(pfS,pfE)=="2o"> 
      <#assign owner2Field=property.name>
     </#if>   
     <#if property.name?substring(pfS,pfE)=="2o">
        "lower(${componentName}.${property.name}) = lower(${'#'}{${listName}.dataOwner2Code})",
     <#elseif property.name=ownerField>
        "lower(${componentName}.${property.name}) like lower( concat('%',${'#'}{${listName}.ownerCddCode}))",
     <#else>
        "lower(${componentName}.${property.name}) like lower( concat(${'#'}{${listName}.${componentName}.${property.name}},'%'))",
     </#if>
   </#if>
  </#if>
 <#else>
   <#-- collection(foreign to others) or manytoone(foreign)  property name ${property.name} -->
    <#if menuAttributesp2 == "1T" >
     
    </#if>

 </#if>
</#if>
</#foreach>
<#-- jay add this after test
"rtrim(fpxxuq15item.a0xxukixbxxxxxxxxxxxmatcode) >= ${'#'}{fpxxuq15itemList.start}",
-->
    };



<#if pojo.isComponent(pojo.identifierProperty)>
    private ${entityName} ${componentName};
<#else>
    private ${entityName} ${componentName} = new ${entityName}();
 /*
  In case of non composite ie Single Field Key
 */
    <#assign ids = pojo.identifierProperty.name>
    <#assign ids1 = pojo.identifierProperty.name>
      /*
      ids = pojo.identifierProperty.name >>> ${ids}
      */
      <#if ids?substring(pfS,pfE)=="im">
          <#assign itemClass ="Y" >
      </#if>


</#if>

<#assign idName = entityName + util.upper(pojo.identifierProperty.name)>
<#if c2j.isComponent(pojo.identifierProperty)>
 <#assign idType = entityName + "Id">
<#else>
 <#assign idType = pojo.importType(pojo.identifierProperty.type.returnedClass.name)>
</#if>

<#assign useDateKey="">
<#assign useDateKeyField="">
// add more logic here to pick up foreign fields if transaction or mailing, pks,pfs=05 efs=06,added multiple K test
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
   //not foreign or collection properties  property name ${property.name}
  <#if c2j.isComponent(property)>
   //not foreign or collection but component  property name ${property.name}
   <#foreach componentProperty in property.value.propertyIterator>
   //not foreign or collection but component  so each component property name ${property.name}
    <#if descriptField != "">
      <#assign search1=descriptField>
    <#else>    
     <#if componentProperty.name?substring(pkS,pkE)=="k" || componentProperty.name?substring(pkS,pkE)=="n">
      <#assign keyField=componentProperty.name>
      //keyfield property name ${componentProperty.name}
      <#assign keyFieldType=componentProperty.value.typeName>
      <#if componentProperty.name?substring(pkS,pkE)=="k" && isString(property)>
       <#assign search1=componentProperty.name>
      </#if>
      <#if componentProperty.name?substring(pkS,pkE)=="n" && isString(property)>
       <#assign search1=componentProperty.name>
      </#if>
     </#if>
    </#if>
    <#if componentProperty.name?substring(pfS,pfE)=="ss">
      <#assign useDateKey="Y">
      <#assign useDateKeyField=componentProperty.name>
    </#if>
   </#foreach>
  <#else>
   //not foreign or collection also not component  property name ${property.name}
    <#if descriptField != "">
      <#assign search1=descriptField>
    <#else>    
     <#if property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n">
      <#assign keyField=property.name>
      //not component keyfield property name ${property.name}
      <#assign keyFieldType=property.value.typeName>
      <#if property.name?substring(pkS,pkE)=="k" && isString(property)>
       <#assign search1=property.name>
      </#if>
      <#if property.name?substring(pkS,pkE)=="n" && (isString(property) || property?is_string) >
       <#assign search1=property.name>
      </#if>
     </#if>
     <#if property.name?substring(pfS,pfE)=="ee">
      <#assign useDateKey="Y">
     </#if>
     <#if property.name?substring(pfS,pfE)=="zf"> 
      <#assign statusFlagField=property.name>
     </#if>
     <#if property.name?substring(pfS,pfE)=="zt"> 
      <#assign statusFlagDateField=property.name>
     </#if>
     <#if property.name?substring(pfS,pfE)=="zn" > 
      <#assign notesField=property.name>
      <#if notesField !="">
       <#assign search2=property.name>
      </#if>
     </#if>
     <#if property.name?substring(10,12)=="49">
      <#assign search2=property.name>
     </#if>
     <#if property.name?substring(10,12)=="24">
      <#assign imailaddrField=property.name>
     </#if> 
     <#if property.name?substring(pfS,pfE)=="zd" || property.name?substring(pfS,pfE)=="zb" || property.name?substring(pfS,pfE)=="za"  > 
      <#assign documentField=property.name>
     </#if>
    </#if>    
  </#if>
 <#else>
   <#-- //foreign or collection properties  property name ${property.name} -->
 </#if>
</#if>
</#foreach>
<#if menuAttributesp2 == "54" >
  //groupmembers check before changing search2, it may already be set below
  <#assign search2=customerEntityName+".c1xxuslnbvixxxxxxxxxlastname">
  <#assign search3=membersgroupEntityName+".a0xxukxxbvxxxxxxxxxxgroupid">
</#if>
<#if menuAttributesp2 == "59" >
  //rate1f check here before changing getResultList. Besides keyfield two other fields can be included
  <#assign search2="b2xxuxxrbv51xxxxxxxxstepname">
  <#assign search3="h3xxuxxrbvxxxxxxxxxxincentive">
</#if>

<#if menuAttributesp2 == "56" >//users
  <#assign search3="c1xxuxxxbvxxxxxxxxxxotherid">
</#if>
<#if menuAttributesp2 == "1R" >//resource
  <#assign search2="a1xxuxxxbvxxxxxxxxxxvalue">
</#if>

<#if (menuAttributes?contains("M") ) >
  <#assign search3="b1xxuzaxbvxxxxxxxxxxdata">
  <#if menuAttributesp2 == "16" >  
  <#assign search3="b1xxuszsbvxxxxxxxxxxdescript">
  </#if>
<#elseif (menuAttributes?contains("T") ) >
 <#if menuAttributes?substring(efS,efS2)?contains("2")>
  <#assign search2=customerEntityName+".a0xxukxxbvxxxxxxxxxxcustomer">
 </#if> 
 <#if menuAttributes?substring(efS,efS2)?contains("3")>
  <#assign search2=vendorEntityName+".a0xxukxxbvxxxxxxxxxxvendor">
 </#if> 
 <#if menuAttributes?substring(efS,efS2)?contains("4")>
  <#assign search2=employeeEntityName+"ByEmployee.a0xxuktxbvxxxxxxxxxxemployee">
 </#if> 
  //not all txns have item as foreign field, check for cp,vp,venartha
 <#if menuAttributesp2 != "27" && menuAttributesp2 != "38" && menuAttributesp2 != "36">  
  <#assign search3=itemEntityName+".a0xxukixbxxxxxxxxxxxmatcode">
 </#if>

</#if>

   <#if keyField !="">
    <#if menuAttributesp2 == "1M" >
     String lorderColumn = "a1xxuxxxbv49xxxxxxxxfromkey";
     String lorder ="a1xxuxxxbv49xxxxxxxxfromkey";
    <#elseif menuAttributesp2 == "1N" >
     String lorderColumn = "a1xxuxxxbv49xxxxxxxxfromkey";
     String lorder ="a1xxuxxxbv49xxxxxxxxfromkey asc";
    <#else>
     String lorderColumn = "${keyField}";
     String lorder ="${keyField} asc";
    </#if>
   <#else>
    <#if menuAttributesp2 == "2B" >
     String lorderColumn = "fpxxfq1a5xwwqqhxxxxxitem.fxxxcq144xwwqqhxxxxxlocation";
     String lorder ="fpxxfq1a5xwwqqhxxxxxitem.fxxxcq144xwwqqhxxxxxlocation desc";
     <#assign search1="a0xxuobxbxxxxxxxxxxxsid">
    <#else>
     String lorder ="a0xxuobxbxxxxxxxxxxxsid desc";
     String lorderColumn=" cc.a0xxukixbxxxxxxxxxxxmatcode ";
    </#if>
   </#if>
     String lorderDirection = "asc";
     String orderColumnPrev = "";
     String orderDirectionPrev = "";
     int urlIndex=0;





public ${entityName}List()
{




            checkMapI[0]=Boolean.FALSE;
            checkMapI[1]=Boolean.FALSE;
            checkMapI[2]=Boolean.FALSE;
            checkMapI[3]=Boolean.FALSE;
            checkMapI[4]=Boolean.FALSE;
            checkMapI[5]=Boolean.FALSE;
            checkMapT[0]=Boolean.FALSE;
            checkMapT[1]=Boolean.FALSE;
            checkMapT[2]=Boolean.FALSE;
            checkMapT[3]=Boolean.FALSE;
            checkMapT[4]=Boolean.FALSE;
            checkMapT[5]=Boolean.FALSE;
       

<#if pojo.isComponent(pojo.identifierProperty)>
        ${componentName} = new ${entityName}();
        ${componentName}.setId( new ${entityName}Id() );
    <#assign firstTime="Y"> 
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
    <#if (property.name?length > eL)>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
     <#assign idsType=property.value.typeName>
     <#if firstTime=="Y">
      <#assign ids1 = pojo.getGetterSignature(property)?substring(3)>
      <#assign ids1Type=property.value.typeName>
      <#assign firstTime="N"> 
     </#if>
      /*
      ids = pojo.getGetterSignature(property)?substring(3) >>> ${ids}
      idsType ${idsType} 
      */
      <#if (ids?length < 8) >
        /*
        ${ids}
        */
        <#assign ids="jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj">
      </#if>  
    </#if>
    </#foreach>

</#if>
        ///setEjbql(EJBQL);
        ///setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        <#if (menuAttributesp2?contains("51") || menuAttributesp2?contains("57") ) >
         // parameters exceeded the maximum of 1000, for entitities like options, userprofl 
         // jay add logic to get default value from jsf and/or client setting
         setMaxResults(3);//options, userprofl
          maxResultsVal=1;
        <#else>
         if(maxResultsVal == null){
          maxResultsVal=6;
         }
         setMaxResults(maxResultsVal);
        </#if>
        // added desc order by sid 
        <#if menuAttributesp2 == "1M" >
          setOrder( "${componentName}.a1xxuxxxbv49xxxxxxxxfromkey,${componentName}.a3xxexnsbvxxxxxxxxxxsequence" );
        <#elseif menuAttributesp2 == "1N" >
          setOrder( "${componentName}.a1xxuxxxbv49xxxxxxxxfromkey,${componentName}.a3xxexnsbvxxxxxxxxxxsequence" );
        <#else>
         // setOrderColumn does not work see override resultList    
         <#if keyField !="">
          //setOrderColumn( "${componentName}.${keyField}" );
         </#if>
        </#if>
        //${keyField}
        
}

    public ${entityName} get${entityName}()
    {
        return ${componentName};
    }

    public boolean isBitSet(Integer a, Integer n){ 
     if (a == null){
      a=0;
     }
     return (a & (1 << n)) != 0; 
    }


      private String  reportName  = "de${entityName}";
      String reference="";
      <#if menuAttributesp2 == "60" >
      private String  fYearEndS="";
      </#if>
      private boolean markedOnes = false;
      private String  targetId = "";
      private String  displayAs  = "HTML";
      private String  sendAs  = "";
      private String  sortOrder  = "";
      private String  sortKey  = "";
      private String  fontName  = "";
      
      private Integer groupSid=0;
      private Integer[] toSelects;
      private Integer[] ccSelects;
      private List<String> toDraftSelects;
      private List<String> ccDraftSelects;
      
     <#if useDateKey="Y">
      private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
      private String start = "         ";
      private String end = "ZZZZZZZZZZZZZZZ";
      private String group = "         ";
     <#else>
      private String start = "         ";
      private String group = "         ";
      private String end = "ZZZZZZZZZZZZZZZ";
     </#if>
      private String searchVal="";
      private String searchValJ="";
      private String searchVal2="";
      private Date searchDate=new Date(0);
      private Date searchDateD=null;
      private Integer searchStatus=null;
      private String searchType=null;

      private String  mailingAddress = "";
      private String  mailingSubject = "Enter Subject here";
      private String  useTemplate = "template_mailing.xhtml";
      private String  attachment = "If any";
      private String  mailingSource = "Enter text";
      StringBuffer sBuffer = new StringBuffer();
      private byte[] mailingBytes1 = null;
      private byte[] mailingBytes2 = null;
      private byte[] mailingBytes3 = null;
      private byte[] mailingBytes4 = null;
      private byte[] mailingBytes5 = null;
      private byte[] mailingBytes = null;
      private String mailingText = null;
      private String mailingText1 = null;
      private String mailingText2 = null;
      private String mailingText3 = null;
      private String mailingText4 = null;
      private String mailingText5 = null;
      private String mailingBytes1Type = null;
      private String mailingBytes2Type = null;
      private String mailingBytes3Type = null;
      private String mailingBytes4Type = null;
      private String mailingBytes5Type = null;
      private String mailingText1Type = null;
      private String mailingText2Type = null;
      private String mailingText3Type = null;
      private String mailingText4Type = null;
      private String mailingText5Type = null;
      private String mailingBytes1TypeMime = null;
      private String mailingBytes2TypeMime = null;
      private String mailingBytes3TypeMime = null;
      private String mailingBytes4TypeMime = null;
      private String mailingBytes5TypeMime = null;
      private String mailInfo="";
      private String mailInfoTo="";
      private String mailInfoCC="";
      private String mailInfoBCC="";
      private String mailNameInfo="";
      private String  mailingStatus = "";
      private String mailAttachInfo="";
      private Integer noMailCount=0;

      private String  signatureSource = "";
      private String  unsubscribeSource = "";
      private String  signatureImageSource = "";// doc key to blob
      private boolean signatureYN = false;
      private boolean multilingualYN = false;
      private boolean contactYN = false;
      private boolean unsubscribeYN = false;
      private boolean signatureImageYN = false;
      private boolean searchOn=false;
      private Integer firstResult;
      private Integer maxResults;
      private String orderColumn;
      private String order;
      private String orderDirection;
      private DataModel dataModel;


      Locale locale = new Locale("en", "CA","3rcomp");
	public Boolean getMarkedOnes() {
		return this.markedOnes;
	}

	public void setMarkedOnes(Boolean markedOnes) {
		this.markedOnes = markedOnes;
	}

	public String getOwner2Code() {
		return owner2Code;
	}

	public void setOwner2Code(String owner2Code) {
		this.owner2Code = owner2Code;
	}

	public Boolean getShowNamesYN() {
		return this.showNamesYN;
	}

	public void setShowNamesYN(Boolean showNamesYN) {
		this.showNamesYN = showNamesYN;
	}


	public Boolean getShowAsBCCYN() {
		return this.showAsBCCYN;
	}

	public void setShowAsBCCYN(Boolean showAsBCCYN) {
		this.showAsBCCYN = showAsBCCYN;
	}


	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getOwnerCddCode() {
		return ownerCddCode;
	}

	public void setOwnerCddCode(String ownerCddCode) {
		this.ownerCddCode = ownerCddCode;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
        <#if menuAttributesp2 == "60" >
	public String getFYearEndS() {
		return fYearEndS;
	}

	public void setFYearEndS(String fYearEndS) {
		this.fYearEndS = fYearEndS;
	}
        </#if>

	public String getDisplayAs() {
		return displayAs;
	}
	public void setDisplayAs(String displayAs) {
		this.displayAs = displayAs;
	}

	public String getSendAs() {
		return sendAs;
	}

	public void setSendAs(String sendAs) {
		this.sendAs = sendAs;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
	public String getMailingStatus() {
		return mailingStatus;
	}

	public void setMailingStatus(String mailingStatus) {
		this.mailingStatus = mailingStatus;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	public Integer getGroupSid() {
		return groupSid;
	}

	public void setGroupSid(Integer groupSid) {
		this.groupSid = groupSid;
	}
	public Integer[] getToSelects() {
		return toSelects;
	}

	public void setToSelects(Integer[] toSelects) {
		this.toSelects = toSelects;
	}

	public Integer[] getCcSelects() {
		return ccSelects;
	}

	public void setCcSelects(Integer[] ccSelects) {
		this.ccSelects = ccSelects;
	}
<#if (menuAttributesp2?contains("52") ) >
	public String getClientPayBySelected() {
		return clientPayBySelected;
	}

	public void setClientPayBySelected(String clientPayBySelected) {
     		this.clientPayBySelected = clientPayBySelected;

	}
    /**
    * method is used to update order details based on client PayBy value 
    * value is used to calculate shipping pickup rate
    * order details do not carry order type or terms, orderHome payByController method uses these values for order itself
    * updateDetailsAll calls getClientPayBySelected() method from here and sets order ship code
    * @return null or empty 
    * @param arg payBy ie pd- paynow/deliver, pp- paynow/pickup, np- no paynow/pay at pickup, cd- no paynow/delivery time pay cash or credit 
    * @exception tbd
    */ 

	public String updateClientPayBySelected(String clientPayBySelected) {
            try{
                this.clientPayBySelected = clientPayBySelected;//set 
                if(clientPayBySelected.equals("pd")){
                 //show/hode shipping or pickup cost and adj total shown
                 trexuq244xwwqqhxxxxxcuordersHome.setNextShow(true);

                 trexuq244xwwqqhxxxxxcuordersHome.updateDetailsAll();//change needs to iterate over 
                 FacesContext.getCurrentInstance().getExternalContext().redirect("/checkout.wflow?payBy="+clientPayBySelected+"#bottom");
                } 

                if(clientPayBySelected.equals("np") || clientPayBySelected.equals("pp")){
                 //not paid ie pay and pickup show/hode shipping or pickup cost and adj total shown 
                 trexuq244xwwqqhxxxxxcuordersHome.setNextShow(true);
                 trexuq244xwwqqhxxxxxcuordersHome.updateDetailsAll();//change needs to iterate over 

                 //return "checkout#bottom";  //browser does the page section not jsf
                 FacesContext.getCurrentInstance().getExternalContext().redirect("/checkout.wflow?payBy="+clientPayBySelected+"#bottom");
                } 
                if(clientPayBySelected.equals("cd")){
                 //cash/pay and delivery
                 trexuq244xwwqqhxxxxxcuordersHome.setNextShow(true);
                 trexuq244xwwqqhxxxxxcuordersHome.updateDetailsAll();
                 //show/hode shipping or pickup cost and adj total shown
                 FacesContext.getCurrentInstance().getExternalContext().redirect("/checkout.wflow?payBy="+clientPayBySelected+"#bottom");
                } 
                return "" ;  //to top where error msg
            }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 FacesMessage.SEVERITY_ERROR,bundle.getString("update")+" "+bundle.getString("site")+" "+bundle.getString("payByList")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                return null;
            }

	}


      public List<String> getClientPayByList() {
        // used by cart checkout to check whether the client/site offers online card payment option 
        //should be read only list in order of usage
        // however if selection is empty it needs to set a default for the site and
        // selection will be empty until customer makes a selection
        // make it two parts

       try{
        clientPayByList=new ArrayList<String>();
        int i=0;
        int j=0;
        int k=0;
        String cardApi=getKeyToEntity("01",customIdentity.getOwner2()).getDaxxuzxdssxxxxxxxxxxapiclientid();
        if  (cardApi !=null && !cardApi.isEmpty()) {
         clientPayByList.add("pd"+bundle.getString("PrePay and Delivery"));
         i=i+1;//1 means pd only
        }

        if  (cardApi !=null && !cardApi.isEmpty()) {
         clientPayByList.add("pp"+bundle.getString("PrePay and PickUp"));
         i=i+1;//2 means pd and pp
        }

        ${clientEntityName?cap_first} posApp=getKeyToEntity("03",customIdentity.getOwner2());
        if  (posApp !=null) {
         clientPayByList.add("np"+bundle.getString("ToPay and PickUp"));
         j=j+1;
        }else{
         clientPayByList.add("np"+bundle.getString("Pay and PickUp"));
         j=j+1;
        }
        ${rate1fEntityName?cap_first} codRate=${rate1fEntityName}List.getKeyStepToEntity("CS","CS");
        if  (codRate !=null) {
         clientPayByList.add("cd"+bundle.getString("ToPay at Delivery"));
         k=k+1;
        }

        if(clientPayBySelected.isEmpty() && (i==2 || i==1)){ 
         clientPayBySelected="pd";
        }
        if(clientPayBySelected.isEmpty() && j==1){ 
         clientPayBySelected="np";
        }

        if(clientPayBySelected.isEmpty() && k==1){ 
         clientPayBySelected="cd";
        }


        return clientPayByList;

       }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 FacesMessage.SEVERITY_ERROR,bundle.getString("get")+" "+bundle.getString("site")+" "+bundle.getString("payByList")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                return null;
       }

      }


</#if>
	public List<String> getToDraftSelects() {
		return toDraftSelects;
	}

	public void setToDraftSelects(List<String> toDraftSelects) {
		this.toDraftSelects = toDraftSelects;
	}

	public List<String> getCcDraftSelects() {
		return ccDraftSelects;
	}

	public void setCcDraftSelects(List<String> ccDraftSelects) {
		this.ccDraftSelects = ccDraftSelects;
	}


	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getSearchVal() {
		return searchVal;
	}

	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal==null?"":searchVal;
                searchValJ=searchVal;

	}

	public String getSearchValJ() {
		return searchValJ;
	}

	public Integer getSearchStatus() {
		return searchStatus;
	}

	public String getSearchVal2() {
		return searchVal2;
	}

	public void setSearchVal2(String searchVal2) {
		this.searchVal2 = searchVal2==null?"":searchVal2;
	}

	public void setSearchStatus(Integer searchStatus) {
		this.searchStatus = searchStatus;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}
      

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public String getMailingSubject() {
		return mailingSubject;
	}


	public void setMailingSubject(String mailingSubject) {
		this.mailingSubject = mailingSubject;
	}
        //for cc
	public String getEMailingAddress1() {
		return eMailingAddress1;
	}
     
	public void setEMailingAddress1(String eMailingAddress1) {
		this.eMailingAddress1 = eMailingAddress1;
	}

        //for bcc
	public String getEMailingAddress2() {
		return eMailingAddress2;
	}
     
	public void setEMailingAddress2(String eMailingAddress2) {
		this.eMailingAddress2 = eMailingAddress2;
	}
        //not used
	public String getEMailingAddress3() {
		return eMailingAddress3;
	}
     
	public void setEMailingAddress3(String eMailingAddress3) {
		this.eMailingAddress3 = eMailingAddress3;
	}
        //not used
	public String getEMailingAddress4() {
		return eMailingAddress4;
	}
     
	public void setEMailingAddress4(String eMailingAddress4) {
		this.eMailingAddress4 = eMailingAddress4;
	}

	public String getDataOwner2Code() {
		return dataOwner2Code;
	}

	public void setDataOwner2Code(String dataOwner2Code) {
		this.dataOwner2Code = dataOwner2Code;
	}

	public Boolean getShowSharedData() {
		return this.showSharedData;
	}

	public void setShowSharedData(Boolean showSharedData) {
		this.showSharedData = showSharedData;
	}

	public Boolean getShowResultsCount() {
		return this.showResultsCount;
	}

	public void setShowResultsCount(Boolean showResultsCount) {
		this.showResultsCount = showResultsCount;
	}
	public Integer getparamResultsCount() {
		return paramResultsCount;
	}
     
	public void setparamResultsCount(Integer paramResultsCount) {
		this.paramResultsCount = paramResultsCount;
	}
	public BigDecimal getallow3Amount() {
		return allow3Amount;
	}
     
	public void setallow3Amount(BigDecimal allow3Amount) {
		this.allow3Amount = allow3Amount;
	}

        public boolean isAllow3Ok(){
         if (this.allow3Amount.compareTo(new BigDecimal("0.0")) == 1){    
          return true; 
         }else{
          return false; 
         }
        }

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	public int getSubcategoryUi() {
		return subcategoryUi;
	}

	public void setSubcategoryUi(int subcategoryUi) {
		this.subcategoryUi = subcategoryUi;
	}

	public Boolean getShowResultsData() {
		return this.showResultsData;
	}

	public void setShowResultsData(Boolean showResultsData) {
		this.showResultsData = showResultsData;
	}
        public boolean getSkipColumns(){ 
         return skipColumns;
        }
	public void setskipColumns(boolean skipColumns) {
		this.skipColumns = skipColumns;
	}

   <#if (menuAttributesp2 ="51") >
	public Integer getOptionNumber() {
		return optionNumber;
	}
     
	public void setOptionNumber(Integer optionNumber) {
		this.optionNumber = optionNumber;
	}
        public boolean getOptions01Show(){ 
         return options01Show;
        }
        public boolean getOptions02Show(){ 
         return options02Show;
        }
        public boolean getOptions03Show(){ 
         return options03Show;
        }
        public boolean getOptions04Show(){ 
         return options04Show;
        }
        public boolean getOptions05Show(){ 
         return options05Show;
        }
        public boolean getOptions06Show(){ 
         return options06Show;
        }
        public boolean getOptions07Show(){ 
         return options07Show;
        }
        public boolean getOptions08Show(){ 
         return options08Show;
        }
        public boolean getOptions09Show(){ 
         return options09Show;
        }
        public boolean getOptions10Show(){ 
         return options10Show;
        }
        public boolean getOptions11Show(){ 
         return options11Show;
        }
        public boolean getOptions12Show(){ 
         return options12Show;
        }
        public boolean getOptions13Show(){ 
         return options13Show;
        }
        public boolean getOptions14Show(){ 
         return options14Show;
        }
        public boolean getOptions15Show(){ 
         return options15Show;
        }
        public boolean getOptions16Show(){ 
         return options16Show;
        }
        public boolean getOptions17Show(){ 
         return options17Show;
        }
        public boolean getOptions18Show(){ 
         return options18Show;
        }
        public boolean getOptions19Show(){ 
         return options19Show;
        }
        public boolean getOptions20Show(){ 
         return options20Show;
        }
        public boolean getOptions21Show(){ 
         return options21Show;
        }
        public boolean getOptions22Show(){ 
         return options22Show;
        }
        public boolean getOptions23Show(){ 
         return options23Show;
        }
        public boolean getOptions24Show(){ 
         return options24Show;
        }
        public boolean getOptions25Show(){ 
         return options25Show;
        }
        public boolean getOptions26Show(){ 
         return options26Show;
        }
        public boolean getOptions27Show(){ 
         return options27Show;
        }
        public boolean getOptions28Show(){ 
         return options28Show;
        }
        public boolean getOptions29Show(){ 
         return options29Show;
        }
        public boolean getOptions30Show(){ 
         return options30Show;
        }
        public boolean getOptions31Show(){ 
         return options31Show;
        }
        public boolean getOptions32Show(){ 
         return options32Show;
        }
        public boolean getOptions33Show(){ 
         return options33Show;
        }
        public boolean getOptions34Show(){ 
         return options34Show;
        }
        public boolean getOptions35Show(){ 
         return options35Show;
        }
        public boolean getOptions36Show(){ 
         return options36Show;
        }
        public boolean getOptions37Show(){ 
         return options37Show;
        }
        public boolean getOptions38Show(){ 
         return options38Show;
        }
        public boolean getOptions39Show(){ 
         return options39Show;
        }
        public boolean getOptions40Show(){ 
         return options40Show;
        }
        public boolean getOptions41Show(){ 
         return options41Show;
        }
        public boolean getOptions42Show(){ 
         return options42Show;
        }
        public boolean getOptions43Show(){ 
         return options43Show;
        }
        public boolean getOptions44Show(){ 
         return options44Show;
        }
        public boolean getOptions45Show(){ 
         return options45Show;
        }
        public boolean getOptions46Show(){ 
         return options46Show;
        }
        public boolean getOptions47Show(){ 
         return options47Show;
        }
        public boolean getOptions48Show(){ 
         return options48Show;
        }
        public boolean getOptions49Show(){ 
         return options49Show;
        }
        public boolean getOptions50Show(){ 
         return options50Show;
        }
        public boolean getOptions51Show(){ 
         return options51Show;
        }
        public boolean getOptions52Show(){ 
         return options52Show;
        }
        public boolean getOptions53Show(){ 
         return options53Show;
        }
        public boolean getOptions54Show(){ 
         return options54Show;
        }
        public boolean getOptions55Show(){ 
         return options55Show;
        }
        public boolean getOptions56Show(){ 
         return options56Show;
        }
        public boolean getOptions57Show(){ 
         return options57Show;
        }
        public boolean getOptions58Show(){ 
         return options58Show;
        }
        public boolean getOptions59Show(){ 
         return options59Show;
        }
        public boolean getOptions60Show(){ 
         return options60Show;
        }
   </#if>

   <#if (menuAttributesp2 ="89") >
        public Date nextSchedule(String type){
		// will return date for next scheduled event 
                calendar.add(Calendar.DATE, -30); 
                Date toDay= calendar.getTime();
		List<${scheduleEntityName?cap_first}> nextEvent = getEntityManager()
				.createQuery(
						"select cc from ${scheduleEntityName?cap_first} cc where (cc.bexxuxxrbv37xxxxxxxxtype = :type AND cc.b5gxdxsdbvxxxxxxxxxxsdatet >= :toDay  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.b5gxdxsdbvxxxxxxxxxxsdatet")
				.setParameter("type", type).setParameter("toDay", toDay).setParameter("owner2", owner2Code).getResultList();

               if (nextEvent.isEmpty()){ 
                return null;
               }else{
                return nextEvent.get(0).getB5gxdxsdbvxxxxxxxxxxsdatet();
               }
        } 
    /**
    * The following method is used for showing recent/next schedule/calendar event 
    * called by clientFcal and xxxFcal pages 
    * @return schedule descript field value based on type( future). now assumes for "fp" for public 
    * if type other than fp then show any type 
    * selects events starting 15 days past today. null if none otherwise returns the first entry which clould be in recent past
    * @exception no select result or select failed. 
    * @see 
    *  added additional sort logic for price etc
    */ 

        public String nextScheduleDescript(String type){
	// will return date and descript for next scheduled event 
                type=type.trim();
                calendar.add(Calendar.DATE, -15); 
                Date toDay= calendar.getTime();           
	List<${scheduleEntityName?cap_first}> nextEvent = null;
                if(type.toUpperCase().equals("FP")){ 
	 nextEvent = getEntityManager()
	.createQuery(
	"select cc from ${scheduleEntityName?cap_first} cc where (cc.bexxuxxrbv37xxxxxxxxtype = :type AND cc.b5gxdxsdbvxxxxxxxxxxsdatet >= :toDay  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.b5gxdxsdbvxxxxxxxxxxsdatet")
	.setParameter("type", type).setParameter("toDay", toDay).setParameter("owner2", owner2Code).getResultList();

               }else{
	 nextEvent = getEntityManager()
	.createQuery(
	"select cc from ${scheduleEntityName?cap_first} cc where (cc.b5gxdxsdbvxxxxxxxxxxsdatet >= :toDay  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.b5gxdxsdbvxxxxxxxxxxsdatet")
	.setParameter("toDay", toDay).setParameter("owner2", owner2Code).getResultList();
               }
               if (nextEvent.isEmpty()){ 
                return null;
               }else{
                return nextEvent.get(0).getB2xxuxsxbvxxxxxxxxxxssdatet()+" "+nextEvent.get(0).getB1xxhszsbv35xxxxxxxxdescript();
               }
        } 
    /**
    * The following method is used for showing recent/next schedule/calendar event 
    * called by clientFcal and xxxFcal pages 
    * @return schedule descript field value based on type( future). now assumes for "fp" for public 
    * if type other than fp then show any type 
    * selects events starting 15 days past today. null if none otherwise returns the first entry which clould be in recent past
    * @exception no select result or select failed. 
    * @see 
    *  added additional sort logic for price etc
    */ 

        public String nextSchedulePDescript(String type){
	// will return date and descript for next scheduled event with matching passcode in descript
                type=type.trim();//holds passcode
                calendar.add(Calendar.DATE, -15); 
                Date toDay= calendar.getTime();           
		List<${scheduleEntityName?cap_first}> nextEvent = null;
		nextEvent = getEntityManager()
		 .createQuery(
		  "select cc from ${scheduleEntityName?cap_first} cc where (cc.b5gxdxsdbvxxxxxxxxxxsdatet >= :toDay  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND substring(cc.b1xxhszsbv35xxxxxxxxdescript,1,4)=:passCode) order by cc.b5gxdxsdbvxxxxxxxxxxsdatet")
			.setParameter("toDay", toDay).setParameter("owner2", owner2Code).setParameter("passCode", type).getResultList();
               if (nextEvent.isEmpty()){ 
                return null;
               }else{
                return nextEvent.get(0).getB2xxuxsxbvxxxxxxxxxxssdatet()+" "+nextEvent.get(0).getB1xxhszsbv35xxxxxxxxdescript();
               }
        } 

   </#if>

   <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ||menuAttributesp2="89") >

	public Boolean[] getCheckMapI() {
		return this.checkMapI;
	}
        public void setCheckMapI(Boolean[] checkMapI){
                this.checkMapI=checkMapI;
        }
	public Boolean[] getCheckMapT() {
		return this.checkMapT;
	}
        public void setCheckMapT(Boolean[] checkMapT){
                this.checkMapT=checkMapT;
        }


	public Integer geteMailingAttachSeq1() {
		return eMailingAttachSeq1;
	}
     
	public void seteMailingAttachSeq1(Integer eMailingAttachSeq1) {
		this.eMailingAttachSeq1 = eMailingAttachSeq1;
	}


	public Integer geteMailingAttachSeq2() {
		return eMailingAttachSeq2;
	}
     
	public void seteMailingAttachSeq2(Integer eMailingAttachSeq2) {
		this.eMailingAttachSeq2 = eMailingAttachSeq2;
	}

	public Integer geteMailingAttachSeq3() {
		return eMailingAttachSeq3;
	}
     
	public void seteMailingAttachSeq3(Integer eMailingAttachSeq3) {
		this.eMailingAttachSeq3 = eMailingAttachSeq3;
	}
	public Integer geteMailingAttachSeq4() {
		return eMailingAttachSeq4;
	}
     
	public void seteMailingAttachSeq4(Integer eMailingAttachSeq4) {
		this.eMailingAttachSeq4 = eMailingAttachSeq4;
	}

	public Integer geteMailingAttachSeq5() {
		return eMailingAttachSeq5;
	}
     
	public void seteMailingAttachSeq5(Integer eMailingAttachSeq5) {
		this.eMailingAttachSeq5 = eMailingAttachSeq5;
	}

	public void eMailingAttachSeq(Integer index,Integer seqValue,String lobType) {
         if(index == 1){
          eMailingAttachSeq1=seqValue;
          mailingBytes1Type=lobType;
         }
         if(index == 2){
          eMailingAttachSeq2=seqValue;
          mailingBytes2Type=lobType;
         }
         if(index == 3){
          eMailingAttachSeq3=seqValue;
          mailingBytes3Type=lobType;
         }
         if(index == 4){
          eMailingAttachSeq4=seqValue;
          mailingBytes4Type=lobType;
         }
         if(index == 5){
          eMailingAttachSeq5=seqValue;
          mailingBytes5Type=lobType;
         }
	}


	public void eMailingDettachSeq(Integer index,Integer seqValue) {
         if(index == 1){
          eMailingAttachSeq1=-1;
         }
         if(index == 2){
          eMailingAttachSeq2=-1;
         }
         if(index == 3){
          eMailingAttachSeq3=-1;
         }
         if(index == 4){
          eMailingAttachSeq4=-1;
         }
         if(index == 5){
          eMailingAttachSeq5=-1;
         }
	}

	public boolean checkEMailingAttachSeq(Integer index) {
         if(index ==1 && eMailingAttachSeq1 != -1){
          return true;
         }
         if(index ==2 && eMailingAttachSeq2 != -1){
          return true;
         }
         if(index ==3 && eMailingAttachSeq3 != -1){
          return true;
         }
         if(index ==4 && eMailingAttachSeq4 != -1){
          return true;
         }
         if(index ==5 && eMailingAttachSeq5 != -1){
          return true;
         }
         return false; 
	}

	public Integer geteMailingTextAttachSeq1() {
		return eMailingTextAttachSeq1;
	}
     
	public void seteMailingTextAttachSeq1(Integer eMailingTextAttachSeq1) {
		this.eMailingTextAttachSeq1 = eMailingTextAttachSeq1;
	}


	public Integer geteMailingTextAttachSeq2() {
		return eMailingTextAttachSeq2;
	}
     
	public void seteMailingTextAttachSeq2(Integer eMailingTextAttachSeq2) {
		this.eMailingTextAttachSeq2 = eMailingTextAttachSeq2;
	}

	public Integer geteMailingTextAttachSeq3() {
		return eMailingTextAttachSeq3;
	}
     
	public void seteMailingTextAttachSeq3(Integer eMailingTextAttachSeq3) {
		this.eMailingTextAttachSeq3 = eMailingTextAttachSeq3;
	}
	public Integer geteMailingTextAttachSeq4() {
		return eMailingTextAttachSeq4;
	}
     
	public void seteMailingTextAttachSeq4(Integer eMailingTextAttachSeq4) {
		this.eMailingTextAttachSeq4 = eMailingTextAttachSeq4;
	}

	public Integer geteMailingTextAttachSeq5() {
		return eMailingTextAttachSeq5;
	}
     
	public void seteMailingTextAttachSeq5(Integer eMailingTextAttachSeq5) {
		this.eMailingTextAttachSeq5 = eMailingTextAttachSeq5;
	}

	public void eMailingTextAttachSeq(Integer index,Integer seqValue,String lobType) {
         if(index == 1){
          eMailingTextAttachSeq1=seqValue;
          mailingText1Type=lobType;
         }
         if(index == 2){
          eMailingTextAttachSeq2=seqValue;
          mailingText2Type=lobType;
         }
         if(index == 3){
          eMailingTextAttachSeq3=seqValue;
          mailingText3Type=lobType;
         }
         if(index == 4){
          eMailingTextAttachSeq4=seqValue;
          mailingText4Type=lobType;
         }
         if(index == 5){
          eMailingTextAttachSeq5=seqValue;
          mailingText5Type=lobType;
         }
	}


	public void eMailingTextDettachSeq(Integer index,Integer seqValue) {
         if(index == 1){
          eMailingTextAttachSeq1=-1;
         }
         if(index == 2){
          eMailingTextAttachSeq2=-1;
         }
         if(index == 3){
          eMailingTextAttachSeq3=-1;
         }
         if(index == 4){
          eMailingTextAttachSeq4=-1;
         }
         if(index == 5){
          eMailingTextAttachSeq4=-1;
         }
	}

	public boolean checkEMailingTextAttachSeq(Integer index) {
         if(index ==1 && eMailingTextAttachSeq1 != -1){
          return true;
         }
         if(index ==2 && eMailingTextAttachSeq2 != -1){
          return true;
         }
         if(index ==3 && eMailingTextAttachSeq3 != -1){
          return true;
         }
         if(index ==4 && eMailingTextAttachSeq4 != -1){
          return true;
         }
         if(index ==5 && eMailingTextAttachSeq5 != -1){
          return true;
         }
         return false; 
	}





	public String getSignatureSource() {
         if (signatureSource ==null || "".equals(signatureSource.trim()) ){
          try{
 			user = (${userEntityName?cap_first}) getEntityManager()
 					.createQuery(
 							"select cc from ${userEntityName?cap_first} cc where cc.a0xxukuxbvxxxxxxxxxxid = :username and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 					.setParameter("username", customIdentity.getUsername())
 					.setParameter("owner2", owner2Code)
 					.getSingleResult();
           if( user.getE4xxuznrbvxxxxxxxxxxsignature()==null || "".equals(user.getE4xxuznrbvxxxxxxxxxxsignature().trim()) ){
            setSignatureSource("<p>"+customIdentity.getUsername()+"</p><br/><br/><p style=\"font-family:arial;font-size:10px;\"> Generated by  <a href=\"http://www.raaspi.com\">3R Workflow solutions</a></p>");
           } 
           else{
            setSignatureSource(user.getE4xxuznrbvxxxxxxxxxxsignature());
           }
          } catch (Exception e) {
           log.severe("Error getting user in signature source"+ e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("signature")+": "+ e.getMessage(),""));

          }
         }
		return signatureSource;
	}
        
	public void setSignatureSource(String signatureSource) {
		this.signatureSource = signatureSource;
	}
        // signatureImageSource is a string key to blob , not image itself
        // need to test how signature image can be shown as if inline attachment
	public String getSignatureImageSource() {
		return signatureImageSource;
	}

	public void setSignatureImageSource(String signatureImageSource) {
		this.signatureImageSource = signatureImageSource;
	}

	public String getUnsubscribeSource() {
		return unsubscribeSource;
	}

	public void setUnsubscribeSource(String unsubscribeSource) {
		this.unsubscribeSource = unsubscribeSource;
	}




	public Boolean getSignatureYN() {
		return this.signatureYN;
	}

	public void setSignatureYN(Boolean signatureYN) {
		this.signatureYN = signatureYN;
	}

	public Boolean getMultilingualYN() {
		return this.multilingualYN;
	}

	public void setMultilingualYN(Boolean multilingualYN) {
		this.multilingualYN = multilingualYN;
	}
	public Boolean getContactYN() {
		return this.contactYN;
	}

	public void setContactYN(Boolean contactYN) {
		this.contactYN = contactYN;
	}
	public Boolean getSignatureImageYN() {
		return this.signatureImageYN;
	}

	public void setSignatureImageYN(Boolean signatureImageYN) {
		this.signatureImageYN = signatureImageYN;
	}

	public Boolean getMailRelayOff() {
		return this.mailRelayOff;
	}

	public void setMailRelayOff(boolean mailRelayOff) {
		this.mailRelayOff = mailRelayOff;
	}

	public Boolean getUnsubscribeYN() {
		return this.unsubscribeYN;
	}

	public void setUnsubscribeYN(Boolean unsubscribeYN) {
		this.unsubscribeYN = unsubscribeYN;
	}


	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}



   </#if>

	public String getUseTemplate() {
		return useTemplate;
	}

	public void setUseTemplate(String useTemplate) {
		this.useTemplate = useTemplate;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getMailingSource() {
		return mailingSource;
	}

	public void setMailingSource(String mailingSource) {
		this.mailingSource = mailingSource;
	}

	public String getMailInfo() {
		return mailInfo;
	}

	public void setMailInfo(String mailInfo) {
		this.mailInfo = mailInfo;
	}

	public String getMailInfoCC() {
		return mailInfoCC;
	}

	public void setMailInfoCC(String mailInfoCC) {
		this.mailInfoCC = mailInfoCC;
	}

	public String getMailInfoBCC() {
		return mailInfoBCC;
	}

	public void setMailInfoBCC(String mailInfoBCC) {
		this.mailInfoBCC = mailInfoBCC;
	}
	public String getMailInfoTo() {
		return mailInfoTo;
	}

	public void setMailInfoTo(String mailInfoTo) {
		this.mailInfoTo = mailInfoTo;
	}
	public String getMailAttachInfo() {
		return mailAttachInfo;
	}

	public void setMailAttachInfo(String mailAttachInfo) {
		this.mailAttachInfo = mailAttachInfo;
	}
	public String getMailNameInfo() {
		return mailNameInfo;
	}

	public void setMailingNameInfo(String mailNameInfo) {
		this.mailNameInfo = mailNameInfo;
	}

	public String getSelectedOwnerCode() {
		return selectedOwnerCode;
	}

	public void setSelectedOwnerCode(String selectedOwnerCode) {
		this.selectedOwnerCode = selectedOwnerCode;
	}


	public byte[] getMailingBytes() {
           
		return mailingBytes;
	}

	public void setMailingBytes(byte[] mailingBytes) {
		this.mailingBytes = mailingBytes;
	}

	public byte[] getMailingImage1() {
           
		return mailingBytes1;
	}

	public void setMailingImage1(byte[] mailingBytes) {
		this.mailingBytes1 = mailingBytes;
	}

	public byte[] getMailingImage2() {
           
		return mailingBytes2;
	}

	public void setMailingImage2(byte[] mailingBytes) {
		this.mailingBytes2 = mailingBytes;
	}
	public byte[] getMailingImage3() {
           
		return mailingBytes3;
	}

	public void setMailingImage3(byte[] mailingBytes) {
		this.mailingBytes3 = mailingBytes;
	}
	public byte[] getMailingImage4() {
           
		return mailingBytes4;
	}

	public void setMailingImage4(byte[] mailingBytes) {
		this.mailingBytes4 = mailingBytes;
	}

	public byte[] getMailingImage5() {
           
		return mailingBytes5;
	}

	public void setMailingImage5(byte[] mailingBytes) {
		this.mailingBytes5 = mailingBytes;
	}
	public String getMailingImage1Type() {
           
		return mailingBytes1Type;
	}

	public void setMailingImage1Type(String mailingType ) {
		this.mailingBytes1Type = mailingType;
	}

	public String getMailingImage2Type() {
           
		return mailingBytes2Type;
	}

	public void setMailingImage2Type(String mailingType ) {
		this.mailingBytes2Type = mailingType;
	}
	public String getMailingImage3Type() {
           
		return mailingBytes3Type;
	}

	public void setMailingImage3Type(String mailingType ) {
		this.mailingBytes3Type = mailingType;
	}

	public String getMailingImage4Type() {
           
		return mailingBytes4Type;
	}

	public void setMailingImage4Type(String mailingType ) {
		this.mailingBytes4Type = mailingType;
	}

	public String getMailingImage5Type() {
           
		return mailingBytes5Type;
	}

	public void setMailingImage5Type(String mailingType ) {
		this.mailingBytes5Type = mailingType;
	}


	public String getMailingText() {
           
		return mailingText;
	}

	public void setMailingText(String mailingText) {
		this.mailingText = mailingText;
	}

	public String getMailingText1() {
           
		return mailingText1;
	}

	public void setMailingText1(String mailingText) {
		this.mailingText1 = mailingText;
	}

	public String getMailingText2() {
           
		return mailingText2;
	}

	public void setMailingText2(String mailingText) {
		this.mailingText2 = mailingText;
	}
	public String getMailingText3() {
           
		return mailingText3;
	}

	public void setMailingText3(String mailingText) {
		this.mailingText3 = mailingText;
	}
	public String getMailingText4() {
           
		return mailingText4;
	}
	public void setMailingText4(String mailingText) {
		this.mailingText4 = mailingText;
	}



	public String getMailingText5() {
           
		return mailingText5;
	}
	public void setMailingText5(String mailingText) {
		this.mailingText5 = mailingText;
	}


	public String getMailingText1Type() {
           
		return mailingText1Type;
	}

	public void setMailingText1Type(String mailingTextType) {
		this.mailingText1Type = mailingTextType;
	}

	public String getMailingText2Type() {
           
		return mailingText2Type;
	}

	public void setMailingText2Type(String mailingTextType) {
		this.mailingText2Type = mailingTextType;
	}
	public String getMailingText3Type() {
           
		return mailingText3Type;
	}

	public void setMailingText3Type(String mailingTextType) {
		this.mailingText3Type = mailingTextType;
	}
	public String getMailingText4Type() {
           
		return mailingText4Type;
	}

	public void setMailingText4Type(String mailingTextType) {
		this.mailingText4Type = mailingTextType;
	}

	public String getMailingImage1TypeMime() {
           
		return mailingBytes1TypeMime;
	}

	public void setMailingImage1TypeMime(String mailingTypeMime ) {
		this.mailingBytes1TypeMime = mailingTypeMime;
	}

	public String getMailingImage2TypeMime() {
           
		return mailingBytes2TypeMime;
	}

	public void setMailingImage2TypeMime(String mailingTypeMime ) {
		this.mailingBytes2TypeMime = mailingTypeMime;
	}
	public String getMailingImage3TypeMime() {
           
		return mailingBytes3TypeMime;
	}

	public void setMailingImage3TypeMime(String mailingTypeMime ) {
		this.mailingBytes3TypeMime = mailingTypeMime;
	}

	public String getMailingImage4TypeMime() {
           
		return mailingBytes4TypeMime;
	}

	public void setMailingImage4TypeMime(String mailingTypeMime ) {
		this.mailingBytes4TypeMime = mailingTypeMime;
	}

	public String getMailingImage5TypeMime() {
           
		return mailingBytes5TypeMime;
	}

	public void setMailingImage5TypeMime(String mailingTypeMime ) {
		this.mailingBytes5TypeMime = mailingTypeMime;
	}



	public String getMailingAddress() {
		return mailingAddress;
	}
     
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
   <#if menuAttributesp2 == "51" >
	public String optionsShow() {
         switch (optionNumber) {
            case 1:  options01Show = true;
                     break;
            case 2:  options02Show = true;
                     break;
            case 3:  options03Show = true;
                     break;
            case 4:  options04Show = true;
                     break;
            case 5:  options05Show = true;
                     break;
            case 6:  options06Show = true;
                     break;
            case 7:  options07Show = true;
                     break;
            case 8:  options08Show = true;
                     break;
            case 9:  options09Show = true;
                     break;
            case 10:  options10Show = true;
                     break;
            case 11:  options11Show = true;
                     break;
            case 12:  options12Show = true;
                     break;
            case 13:  options13Show = true;
                     break;
            case 14:  options14Show = true;
                     break;
            case 15:  options15Show = true;
                     break;
            case 16:  options16Show = true;
                     break;
            case 17:  options17Show = true;
                     break;
            case 18:  options18Show = true;
                     break;
            case 19:  options19Show = true;
                     break;
            case 20:  options20Show = true;
                     break;
            case 21:  options21Show = true;
                     break;
            case 22:  options22Show = true;
                     break;
            case 23:  options23Show = true;
                     break;
            case 24:  options24Show = true;
                     break;
            case 25:  options25Show = true;
                     break;
            case 26:  options26Show = true;
                     break;
            case 27:  options27Show = true;
                     break;
            case 28:  options28Show = true;
                     break;
            case 29:  options29Show = true;
                     break;
            case 30:  options30Show = true;
                     break;
            case 31:  options31Show = true;
                     break;
            case 32:  options32Show = true;
                     break;
            case 33:  options33Show = true;
                     break;
            case 34:  options34Show = true;
                     break;
            case 35:  options35Show = true;
                     break;
            case 36:  options36Show = true;
                     break;
            case 37:  options37Show = true;
                     break;
            case 38:  options38Show = true;
                     break;
            case 39:  options39Show = true;
                     break;
            case 40:  options40Show = true;
                     break;
            case 41:  options41Show = true;
                     break;
            case 42:  options42Show = true;
                     break;
            case 43:  options43Show = true;
                     break;
            case 44:  options44Show = true;
                     break;
            case 45:  options45Show = true;
                     break;
            case 46:  options46Show = true;
                     break;
            case 47:  options47Show = true;
                     break;
            case 48:  options48Show = true;
                     break;
            case 49:  options49Show = true;
                     break;
            case 50:  options50Show = true;
                     break;
            case 51:  options51Show = true;
                     break;
            case 52:  options52Show = true;
                     break;
            case 53:  options53Show = true;
                     break;
            case 54:  options54Show = true;
                     break;
            case 55:  options55Show = true;
                     break;
            case 56:  options56Show = true;
                     break;
            case 57:  options57Show = true;
                     break;
            case 58:  options58Show = true;
                     break;
            case 59:  options59Show = true;
                     break;
            case 60:  options60Show = true;
                     break;

            default: FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString( "invalid_option"),""));
                     break;
         }
                if(optionNumber !=1){
                 options01Show=false; // turn off default show
                }
		return "";
	}


     public List<${entityName}> getResultListByColumn(Integer column){
      sresults=null;// reset 
List<Yrxxch511xhhxxhxxxxxoptions> results=null;
      switch(column){
       case 1:
		results	  =  getEntityManager()
					.createQuery(
							"select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2").setParameter("owner2", owner2Code)
					.getResultList();
      }
      return results;
     }
   </#if>

     public List<${entityName}> getResultListMaxSet(Integer maxResultsVal){
      sresults=null;// reset 
      this.maxResultsVal=maxResultsVal;
      return getResultList();
     }

     public List<${entityName}> getSystemResultListMaxSet(Integer maxResultsVal){
      this.maxResultsVal=maxResultsVal;
      return getSystemResultList();
     }

     public void setMaxResultsVal(Integer maxResultsVal){
      this.maxResultsVal=maxResultsVal;
      setMaxResults(maxResultsVal); 
    }
    
     public Integer getMaxResultsVal(){
      return maxResultsVal;
     }

     public Long getResultCount(){
     // show owner2 only not including SYSTEM, affected pagination
       <#if statusFlagField !="Not assigned">
        
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;
       </#if>

     }
     public Long getSystemResultCount(){
     // show SYSTEM only not including owner2, affected pagination
       <#if statusFlagField !="Not assigned">

		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", "SYSTEM")
					.getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", "SYSTEM")
					.getSingleResult();
                return count;
       </#if>

     }

     public Long getResultCountClosed(){
       <#if statusFlagField !="Not assigned">

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from ${entityName} cc where cc.${statusFlagField} = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		 .getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code)
	 	 .getSingleResult();
                return count;
       </#if>

     }
     public Long getResultCountReturned(){
       <#if statusFlagField !="Not assigned">

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from ${entityName} cc where cc.${statusFlagField} = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mreturn)
		 .getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                return count;
       </#if>

     }
     public Long getResultCountOrdered(){
       <#if statusFlagField !="Not assigned">

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName} cc where cc.${statusFlagField} = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code).setParameter("flag", mordered)
		.getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                return count;
       </#if>

     }

    <#if menuAttributesp2 == "23" || menuAttributesp2 == "24"  >
     public BigDecimal getResultAmountOrdered(){
        BigDecimal netTotal=new BigDecimal("0.0");
       //hardcode now, use assign field value later  use * not NC for all orders
       <#if statusFlagField !="Not assigned">
        <#if menuAttributesp2 == "24" > // cuorders
         for (${cuordersEntityName?cap_first} itemOrderDetail:getSuggestList("*") ){
          netTotal=netTotal.add(itemOrderDetail.getZ1xxztprlxxxxxxxxxxxamounttotal());
         }
        </#if>
        <#if menuAttributesp2 == "23" > // cuquotes
         for (${cuquoteEntityName?cap_first} itemOrderDetail:getSuggestList("*") ){
          netTotal=netTotal.add(itemOrderDetail.getZ1xxztprlxxxxxxxxxxxamounttotal());
         }
        </#if>
       </#if>
        return netTotal; 

     }

     public int getResultAmountOrderedVsBudget(){
       //hardcode now, use assign field value later ,  use * not NC for all orders
        BigDecimal netTotal=new BigDecimal("0.0");
        BigDecimal netBudget=new BigDecimal("0.0");
        int ratio=0;
       <#if statusFlagField !="Not assigned">
        <#if menuAttributesp2 == "24" > // cuorders 
         for (${cuordersEntityName?cap_first} itemOrderDetail:getSuggestList("*") ){
          netTotal=netTotal.add(itemOrderDetail.getZ1xxztprlxxxxxxxxxxxamounttotal());
         }
         if(fxxxuq1bhxwwqqhxxxxxusagebyperiodsList.getKeyToEntity("cob"+owner2Code) !=null){
          netBudget=fxxxuq1bhxwwqqhxxxxxusagebyperiodsList.getKeyToEntity("cob"+owner2Code).getE3xxzbtrbvxxxxxxxxxxperiodtotalsb();// use budget
         }
         if(netBudget.compareTo(BigDecimal.ZERO)==0){
          netBudget=netTotal;//avoid div by 0
          if(netBudget.compareTo(BigDecimal.ZERO)==0){
           netBudget=BigDecimal.ONE;
          }     
         }       
         ratio=netTotal.multiply(new BigDecimal("15.00")).divide(netBudget,2, RoundingMode.HALF_UP).intValue();
        </#if>
 
        <#if menuAttributesp2 == "23" > // cuquote
         for (${cuquoteEntityName?cap_first} itemOrderDetail:getSuggestList("*") ){
          netTotal=netTotal.add(itemOrderDetail.getZ1xxztprlxxxxxxxxxxxamounttotal());
         }
         if(fxxxuq1bhxwwqqhxxxxxusagebyperiodsList.getKeyToEntity("cqb"+owner2Code) !=null){
          netBudget=fxxxuq1bhxwwqqhxxxxxusagebyperiodsList.getKeyToEntity("cqb"+owner2Code).getE3xxzbtrbvxxxxxxxxxxperiodtotalsb();
         }
         if(netBudget.compareTo(BigDecimal.ZERO)==0){
          netBudget=netTotal;//avoid div by 0
          if(netBudget.compareTo(BigDecimal.ZERO)==0){
           netBudget=BigDecimal.ONE;
          }     
         }       
         ratio=netTotal.multiply(new BigDecimal("15.00")).divide(netBudget,2, RoundingMode.HALF_UP).intValue();
        </#if>
       </#if>
        return ratio; 

     }
    </#if>

     public Long getResultCountShipped(){
       <#if statusFlagField !="Not assigned">

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from ${entityName}  cc where cc.${statusFlagField} = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", mshipped)
	.getSingleResult();
         return count;
       <#else>
	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from ${entityName}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code)
	.getSingleResult();
         return count;
       </#if>

     }
     public Long getResultCountInvoiced(){
       //invoiced refers to flag value 64 and may mean approved or ? or invoiced depending on the entity
       <#if statusFlagField !="Not assigned">

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from ${entityName}  cc where cc.${statusFlagField} = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", minvoiced)
	.getSingleResult();
         return count;
       <#else>
	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from ${entityName}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code)
	.getSingleResult();
         return count;
       </#if>

     }
    <#if menuAttributesp2 == "26">
     public Long getResultCountInvoicedNotPaid(){
       //invoiced refers to flag value 64 and may mean final approved or ? or invoiced depending on the entity
       <#if statusFlagField !="Not assigned">
        calendar.add(Calendar.DATE, -7); //7 days grace, can check futher
        Date searchDate= calendar.getTime();
	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from ${entityName}  cc where cc.${statusFlagField} = :flag AND cast(cc.c4xxcxxrlxxxxxxxxxxxtermsdat AS date) < cast(:searchDate AS date) AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("searchDate", searchDate).setParameter("flag", minvoiced)
	.getSingleResult();
         return count;
       <#else>
	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from ${entityName}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code)
	.getSingleResult();
           return count;
       </#if>

     }
   </#if> 
<#if (menuAttributesp2?contains("27") ) >
    /**
    * method is used to get payment records filtered by paytype (cash,card) and latest or not  
    * called by checkoutInvoiced
    * @return list can be empty but not null 
    * @param arg 2 type paytype or all(paytypes) or allall(paytypes and owners. latest true/false sids sorted desc / asc
    * @exception tbd
    * getSuggestList for other standard filters
    */ 

	public List<${entityName}> getPaidByTypeList(String type,boolean latest) {
         String paytype="card";//POS jay todo set EMailingAddress of the customer in paymentHome
         // also add a parameter to specify any card payment id 
         if (type.equals("all")){
          if(latest){
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
           .setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode)
	   .getResultList();
          }else{
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
           .setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode)
	   .getResultList();
          }
         }
         else{
          if (type.equals("allall")){
           if(latest){
	    return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
            .setParameter("owner2", owner2Code)
	    .getResultList();
           }else{
	    return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
            .setParameter("owner2", owner2Code)
	    .getResultList();
           }
          }
          else{
           if(latest){
	    return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode AND cc.b6xxuxxrbv10xxxxxxxxpaytype=:type order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
        	.setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("type", type)
		.getResultList();
           }else{
	    return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode AND cc.b6xxuxxrbv10xxxxxxxxpaytype=:type order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
        	.setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("type", type)
		.getResultList();
           }
          }//allall         
         }//all

     }

</#if>
<#if (menuAttributesp2?contains("26") ) >
	public List<${entityName}> getPaidByTypeList(String type,boolean latest) {
         String paytype="card";//POS jay todo set EMailingAddress of the customer in paymentHome
         // also add a parameter to specify any card payment id 
         if (type.equals("all")){
          if(latest){
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
           .setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("flag", mpaid)
	   .getResultList();
          }else{
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
           .setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("flag", mpaid)
	   .getResultList();
          }
         }else{
          if(latest){
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode AND cc.y7xxuxxrbv10xxxxxxxxtype=:type order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
        	.setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("type", type).setParameter("flag", mpaid)
		.getResultList();
          }else{
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${ownerField}=:ownerCode AND cc.y7xxuxxrbv10xxxxxxxxtype=:type order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
        	.setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("type", type).setParameter("flag", mpaid)
		.getResultList();
          }
        }

     }

</#if>


    <#if menuAttributesp2 == "52">

     public Long getResultCountTrialPending(){
       <#if statusFlagField !="Not assigned">
                calendar.add(Calendar.DATE, +30); //client 30 days in advance, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();
		Long count =  (Long)getEntityManager()
		 .createQuery(
		 "select count(cc) from ${entityName}  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type ")
		 .setParameter("type", "TrialPending").setParameter("nKeyName","01")
		 .getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from ${entityName}  cc where (cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type ")
		 .getSingleResult();
                return count;
       </#if>

     }

     public Long getResultCountTrialExpiring(){
       <#if statusFlagField !="Not assigned">
                calendar.add(Calendar.DATE, +30); //30 days in advance, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName}  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.${statusFlagField} <> :flag AND cast(cc.f8xxcxxxlvxxxxxxxxxxlicenseend AS date) < cast(:searchDate AS date) ")
		.setParameter("searchDate", searchDate).setParameter("flag", mclosed).setParameter("nKeyName","01")
		.getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                return count;
       </#if>

     }

     public Long getResultCountNotActivated(){
       <#if statusFlagField !="Not assigned">
                calendar.add(Calendar.DATE, -3); //3 days in past, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName}  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.${statusFlagField} = :flag AND cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date)  ")
		.setParameter("searchDate", searchDate).setParameter("flag", mordered).setParameter("nKeyName","01")
		.getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                return count;
       </#if>

     }

     public Long getResultCountSiteIdle(){
       <#if statusFlagField !="Not assigned">
                calendar.add(Calendar.DATE, -30); //30 days in past, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();


		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName}  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.${statusFlagField} <> :flag AND cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date)  ")
					.setParameter("searchDate", searchDate).setParameter("flag", mclosed).setParameter("nKeyName","01")
					.getSingleResult();
                return count;
       <#else>
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;
       </#if>

     }
   //client only
   </#if> 

    <#if menuAttributesp2 == "52" || menuAttributesp2 == "1A">

     public ${entityName} getKeyToEntity(String key,String owner2){
      // another site restrict to raaspi site  added for item
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
        .createQuery(
          "select cc from ${entityName} cc where cc.${keyField} = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )")
           .setParameter("nKeyName",key)
           .setParameter("owner2", owner2)
           .getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 

   //client and Item only
   </#if> 




<#if menuAttributesp2 == "1N">

     public Integer getAttachCount(){
                // select count(*) returned 5 when it should be 3 using size because -1 not -1-c was used can go back

			List<${componentName?cap_first}> results =  getEntityManager()
					.createQuery("select cc from ${componentName?cap_first} cc where cc.a1xxuxxxbv49xxxxxxxxfromkey = :fromKey AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.${statusFlagDateField}").setParameter("owner2", owner2Code).
                setParameter("fromKey", "3R-ATTACHMENT-1-C").getResultList();
                return results.size();

     }
    /**
    * The following method is used to extract outputLink value to wrap image defined as @link="url value"
    * example @link="http://raaspi.lraaspi.com:8080/home.wflow"  
    * called by clientFcal and xxxFcal pages 
    * @return schedule descript field value based on type( future). now assumes for "fp" for public 
    * selects events starting 15 days past today. null if none otherwise returns the first entry which clould be in recent past
    * @exception no select result or select failed. 
    * @see 
    *  added additional sort logic for price etc
    */ 

     public String getAtValue(String key,int keySequence,String atKey){
			List<${componentName?cap_first}> results =  getEntityManager()
					.createQuery("select cc from ${componentName?cap_first} cc where cc.a1xxuxxxbv49xxxxxxxxfromkey = :fromKey and a3xxexnsbvxxxxxxxxxxsequence = :sequence AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by ${statusFlagDateField}").setParameter("owner2", owner2Code).
                setParameter("fromKey", key).setParameter("atKey", atKey).setParameter("sequence", keySequence).getResultList();
                if(results.size()>1){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("duplicate")+" "+bundle.getString("for")+" "+key+" "+bundle.getString("sequence")+" "+keySequence+" , "+bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used"), ""));
                }
                String notes=results.get(0).getY3xxuxznbvxxxxxxxxxxnotes().trim();
                //ayKey is @link= or @fade= or @video= or @mp3=
                int begin=notes.lastIndexOf(atKey+"\"");
                if(begin==-1){
                 return null;
                }
                int end=notes.substring(begin).indexOf("\"");
                String value=notes.substring(begin,end);
                return value;

     }


</#if>

<#if menuAttributesp2 == "1M">

     public Integer getAttachCount(){
      List<${componentName?cap_first}> results =  getEntityManager()
       .createQuery("select cc from ${componentName?cap_first} cc where cc.a1xxuxxxbv49xxxxxxxxfromkey = :fromKey AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  cc.${statusFlagDateField}").setParameter("owner2", owner2Code).
           setParameter("fromKey", "3R-ATTACHMENT-1-C").getResultList();
            return results.size();
     }
</#if>

     public List<${entityName}> getSystemResultList(){
      //use SYSTEM only,  allow PH to see

      <#if !search2?has_content>
       <#assign search2=search1>
      </#if>
      <#if !search3?has_content>
       <#assign search3=search1>
      </#if>
      // start null seems to make query return null, also null pointer to make lowercase
      if(start == null){
       start=" ";
      }
      if(end == null){
       end="zzzzz";
      }
     <#if menuAttributesp2 == "1A" > 
      if(sortByValue.equals("lh")){
       String jj=lorderDirection;
      }
     </#if>


      if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PQ") ){
           if ( (getOrderColumn() != null && !getOrderColumn().equals(orderColumnPrev)) ||  (getOrderDirection() != null && !getOrderDirection().equals(orderDirectionPrev))   ){
            if(getOrderColumn()!=null){
             lorderColumn=getOrderColumn();
            }
            if(getOrderDirection()!=null){
            lorderDirection=getOrderDirection();
            }
            lorder="lower("+lorderColumn+") "+lorderDirection;//order case insensitive
            sresults=null;
           }
           getEntityManager().clear();// otherwise search was causing row being overwritten by search row
           <#if search1 != "">
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            if(searchVal == null || searchVal.isEmpty() ){
             searchVal=searchValJ;// until why seachVal getting empty this logic needed           
            }
           </#if>

           // add logic to handle client(52),options(51),user(56) userprofl (57) etc which wont or on exception have user as owner
          <#if menuAttributesp2 == "56" >
		List<${entityName?cap_first}> results =  getEntityManager()
					.createQuery(
							"select cc from ${entityName}  cc where cc.a0xxuobxbxxxxxxxxxxxsid=:logonsid  and ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder) 
					.setParameter("logonsid", customIdentity.getUserSid())
                                        .setParameter("owner2", "SYSTEM")
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
 					.getResultList();
          <#elseif menuAttributesp2 == "52" >
		List<${entityName?cap_first}> results =  getEntityManager()
					.createQuery(
							"select cc from ${entityName}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
					.setParameter("owner2", "SYSTEM")
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
          <#else>    
          // means could return empty in xxx.list       
                <#if ownerField !="">      
		List<${entityName?cap_first}> results =  getEntityManager()
                                     .createQuery(
                                       "select cc from ${entityName}  cc where cc.${ownerField}=:owner  and  ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner", ownerCode)
                                        .setParameter("owner2", "SYSTEM")
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .getResultList();
                <#else>
		List<${entityName?cap_first}> results =  getEntityManager()
                                     .createQuery(
                                       "select cc from ${entityName}  cc where  ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner2", "SYSTEM")
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .getResultList();
                </#if>
          </#if>
          sresults=results;
          return sresults;
      }
      else{
           if ( (getOrderColumn() != null && !getOrderColumn().equals(orderColumnPrev)) ||  (getOrderDirection() != null && !getOrderDirection().equals(orderDirectionPrev))   ){
            if(getOrderColumn()!=null){
             lorderColumn=getOrderColumn();
            }
            if(getOrderDirection()!=null){
            lorderDirection=getOrderDirection();
            }
            lorder="lower("+lorderColumn+") "+lorderDirection;
            sresults=null;
           }
           <#if (menuAttributesp2?contains("60") ) >
            lorder="a0xxukwxbvxxxxxxxxxxaccount asc";
           </#if>  
 
           getEntityManager().clear();// otherwise search was causing row being overwritten by search row
            // jsf cannot handle too many rows and columns for options(51) so return 1 but allow search to pick any, client(52)which also has many rows/columns checking not needed since only one record matching owner2 is shown
            // employee(40) restrict to own record,if demo user. otherwise show all like default user(56) restrict to own record if demo user
           <#if search1 != "">
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            //options date not needed in search, options(51) maxresults reduced from 100 to default 3 to avoid excessive parameters
            <#if (menuAttributesp2?contains("51") ) >
		sresults =  getEntityManager()
					.createQuery(
							"select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();

            <#else>
             //employee add search
             <#if menuAttributesp2 == "40" >
             if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
              Integer useremplsid=${employeeEntityName}Home.getCurrentUserToEmployee().getA0xxuobxbxxxxxxxxxxxsid();
              sresults =  getEntityManager()
	.createQuery(
	"select cc from ${entityName?cap_first}  cc where ((cc.zexxutoxlhxxxxxxxxxxowner=:owner or a0xxuobxbxxxxxxxxxxxsid=:useremplsid) and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2) order by "+ lorder)
                           .setParameter("owner", ownerCode)
                           .setParameter("useremplsid", useremplsid)
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .setParameter("owner2", "SYSTEM")
                           .getResultList();
             }else{
	  sresults =  getEntityManager()
	.createQuery(
	 "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${statusFlagDateField} AS date) >= cast(:searchDate AS date)) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();
             } 
             <#elseif menuAttributesp2 == "56" >
              //user
             if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
	 sresults =  getEntityManager()
	.createQuery(
	"select cc from ${entityName}  cc where cc.a0xxuobxbxxxxxxxxxxxsid=:logonsid  and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	.setParameter("logonsid", customIdentity.getUserSid())
                                        .setParameter("owner2", "SYSTEM")
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult() !=null?getFirstResult():0)
	.getResultList();
             }else{
                 setMaxResults(maxResultsVal);
                 setFirstResult(getFirstResult()!=null?getFirstResult():0);
		 sresults =  getEntityManager()
					.createQuery(
					"select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${statusFlagDateField} AS date) >= cast(:searchDate AS date)) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
					.getResultList();
             }
             <#elseif menuAttributesp2 == "56" >
              if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
 		 sresults =  getEntityManager()
					.createQuery(
					"select cc from ${entityName}  cc where cc.a0xxuobxbxxxxxxxxxxxsid=:logonsid  and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("logonsid", customIdentity.getUserSid())
                                        .setParameter("owner2", "SYSTEM")
					.getResultList();
              }else{

		 sresults =  getEntityManager()
					.createQuery(
					"select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .getResultList();
              }
             <#elseif menuAttributesp2 == "54" >
             //seach2value can be null
		  sresults =  getEntityManager()
			      .createQuery(
		              "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or (jxxxuq201xwwqqhxxxxxcustomer is not null and lower(${search2}) like lower(concat('%',:searchVal,'%'))) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${statusFlagDateField} AS date) >= cast(:searchDate AS date)) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                              .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                              .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                              .getResultList();

             <#else>
              //all others
                  <#if statusFlagDateField == "Not assigned">
                   //dateField 
                   <#if menuAttributesp2?contains("1F")>
                    <#assign dateField="z4xxcxxrlxxxxxxxxxxxscandatet">
                   <#elseif menuAttributesp2?contains("8A")>
                    <#assign dateField="b5gxdxxdbvxxxxxxxxxxsdatet">
                   <#elseif menuAttributesp2?contains("1Q")>
                    <#assign dateField="">
                   <#elseif menuAttributesp2?contains("68")>
                    <#assign dateField="b1xxcjpdhvxxxxxxxxxxpostdate">
                   <#elseif menuAttributesp2?contains("1I")>
                    <#assign dateField="b1xxcsxraxxxxxxxxxxxdatetimeofscan">
                   <#elseif menuAttributesp2?contains("58")>
                    <#assign dateField="z3xxcxxrlxxxxxxxxxxxdatet">
                   <#elseif menuAttributesp2?contains("65")>
                    <#assign dateField="b5xxcxxrlxxxxxxxxxxxpostdate">
                   <#else> 
                    <#assign dateField="">
                   </#if> 
                  <#else>
                   //statusfield
                   <#assign dateField=statusFlagDateField>
                  </#if>


                 //:: type cast operator conflicts with the JPA so use cast(:searchDate AS date) dateField ${dateField} statflgdt ${statusFlagDateField}
                 <#if dateField !="">
                  <#if menuAttributesp2 == "68" >
                   // seq is integer field  endi increased and removed hyphen
                   Integer startI=0; 
                   Integer endI=999999;
                   try{
                    startI=Integer.parseInt(start.replace("-",""));
                   }catch(Exception e){
                   }
                   try{
                    endI=Integer.parseInt(end.replace("-",""));
                   }catch(Exception e){
                   } 
		   sresults =  getEntityManager()
					.createQuery(
		  "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and (cc.b5cczjsibvxxxxxxxxxxjnlseq between :start and :end) ) order by "+ lorder)
                   .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", startI).setParameter("end", endI)
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                  <#else>
		   sresults =  getEntityManager()
					.createQuery(
                  <#if statusFlagField !="Not assigned">
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                  <#else>
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                  </#if>
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                  </#if>
                 <#else>
		  sresults =  getEntityManager()
					.createQuery(
                  <#if statusFlagField !="Not assigned">
                   <#if menuAttributesp2 == "1A" >
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (:searchType is null or cc.c6xxusxrbv16xxxxxxxxtype = :searchType) ) and (:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                   <#elseif menuAttributesp2 == "24">
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (:searchType is null or cc.c6xxusxrbv16xxxxxxxxtype = :searchType) ) and (:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                   <#else>
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                   </#if>

                  <#else>
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                  </#if>
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                 </#if>
             </#if>
             // all others end
            </#if>
            //non options end
           <#else>
           // search1 ie keyfield is bempty ie keyfield is non string as in userprofl(57) or detail entities
             <#if menuAttributesp2 == "57" >
                  List<${entityName?cap_first}> sresults =  getEntityManager()
                         .createQuery(
                           "select cc from ${entityName}  cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                           .setParameter("owner2", "SYSTEM")
                           .getResultList();
             <#else>
                <#if ownerField !="">      
      	List<${entityName?cap_first}> sresults =  getEntityManager()
                  .createQuery(
                   "select cc from ${entityName}  cc where cc.${ownerField}=:owner  and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                     .setParameter("owner", ownerCode)
                     .setParameter("owner2", "SYSTEM")
                  .getResultList();
                <#else>
      	List<${entityName?cap_first}> sresults =  getEntityManager()
                  .createQuery(
                   "select cc from ${entityName}  cc where  zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                     .setParameter("owner2", "SYSTEM")
                  .getResultList();
                </#if>
             </#if>

           </#if>
          orderColumnPrev=lorderColumn;
          orderDirectionPrev=lorderDirection;
          if( sresults.size() == 0 && (searchVal != null && !searchVal.isEmpty()) ){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("empty"),""));

          }
          return sresults;

      }
      
     }

       /**
    * The following method added since hql seems to be dropping order by in some queries (perioddates getResultList() )and where order is important
    * @param args -none
    * @return List<Yxxxuq632xwwqqhxxxxxperioddates>
    * @exception to be added
    * @see getResultList()
    */

     public List<${entityName}> getSortedResultList(){
            if(getOrderColumn()!=null){
             lorderColumn=getOrderColumn();
            }
            if(getOrderDirection()!=null){
            lorderDirection=getOrderDirection();
            }
            lorder=lorderColumn+" "+lorderDirection;
            sresults=null;
            sresults =  getEntityManager()
             .createQuery(
               "select cc from ${entityName?cap_first}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2  ) order by "+ lorder)
                 .setParameter("owner2", owner2Code)
                  .getResultList();
       return sresults;
      }


       /**
    * The following method overrides seam method because setOrder did not work 
    * @param args -none
    * @return List<${entityName}>
    * @exception to be added
    * @see 
    * order by is added as part of the query 
    * order is added to sql but its value is sanitized and not entered externally
    * a0xxuobxbxxxxxxxxxxxsid is same for all entities 
    * cc where cc.clause was added here because mixing this method with seam query for search was causing cache dirty and entity
    * update issue
    * search1 refers to keyproperty, search2 refers to descript or if a property has option49 as in clobdata or customer,vendor
    * or employee if transactions like order. if more than one proprties, last match used and if no match search1 value used
    *  search3 used for item if Txn, group id if groupmembers,can we use it for price if item? if no value in search3 use search1 value
    *  except for txn like payments
    */

     public List<${entityName}> getResultList(){
      // shopping items for visitors are not fetched here but in itembrowselist or in itemdetailbrowselist 
      // if visitor ,for any table, allow only own or owned records
      // jay resultList check whether any exception needed 
      // ?? if employee table allow only owned or owned records for "U" user
      // maxResults may be set by caller or already set as 6
      // search1 ie key property may be empty , getFirst is a method in seam superclass and sets the first record
      // use seq not key seqs for numeric ordering //jayresultList
 
      <#if !search2?has_content>
       <#assign search2=search1>
      </#if>
      <#if !search3?has_content>
       <#assign search3=search1>
      </#if>
      // start null seems to make query return null, also null pointer to make lowercase
     <#if menuAttributesp2 == "2B" > 
      if(start == null){
       start="1";
      }
      if(end == null){
       end="99999";
      }
     <#else>
      if(start == null){
       start=" ";
      }
      if(end == null){
       end="zzzzz";
      }
     </#if>
     <#if menuAttributesp2 == "1A" > 
      if(sortByValue.equals("lh")){
       String jj=lorderDirection;
      }
     </#if>


      if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH") ){
           //if visitors. added sort order 
           if ( (getOrderColumn() != null && !getOrderColumn().equals(orderColumnPrev)) ||  (getOrderDirection() != null && !getOrderDirection().equals(orderDirectionPrev))   ){
            if(getOrderColumn()!=null){
             lorderColumn=getOrderColumn();
            }
            if(getOrderDirection()!=null){
            lorderDirection=getOrderDirection();
            }
            lorder=lorderColumn+" "+lorderDirection;
            sresults=null;
           }
           getEntityManager().clear();// otherwise search was causing row being overwritten by search row
           <#if search1 != "">
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            if(searchVal == null || searchVal.isEmpty() ){
             searchVal=searchValJ;// until why seachVal getting empty this logic needed           
            }
           </#if>
           // for visitors, added logic to handle client(52),options(51),user(56) userprofl (57) etc which wont or on exception have user as owner
          <#if menuAttributesp2 == "56" >
              List<${entityName?cap_first}> results =  getEntityManager()
	.createQuery(
	"select cc from ${entityName}  cc where cc.a0xxuobxbxxxxxxxxxxxsid=:logonsid  and ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
	.setParameter("logonsid", customIdentity.getUserSid())
                  .setParameter("owner2", owner2Code)
                  .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                  .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
	.getResultList();
          <#elseif menuAttributesp2 == "52" >
	List<${entityName?cap_first}> results =  getEntityManager()
	.createQuery(
	"select cc from ${entityName}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
	.setParameter("owner2", owner2Code)
                  .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                 .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
	.getResultList();
          <#else>    
          // means could return empty in xxx.list       
                <#if ownerField !="">      
                                   List<${entityName?cap_first}> results =  getEntityManager()
                                    .createQuery(
                                     "select cc from ${entityName}  cc where cc.${ownerField}=:owner  and ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                      .setParameter("owner", ownerCode)
                                        .setParameter("owner2", owner2Code) 
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                       .getResultList();
                <#else>
                                   List<${entityName?cap_first}> results =  getEntityManager()
                                    .createQuery(
                                     "select cc from ${entityName}  cc where  ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner2", owner2Code) 
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                       .getResultList();
                </#if>
          </#if>
          sresults=results;
          return sresults;
      }//backOffice users begins 
      else{
           if ( (getOrderColumn() != null && !getOrderColumn().equals(orderColumnPrev)) ||  (getOrderDirection() != null && !getOrderDirection().equals(orderDirectionPrev))   ){
            if(getOrderColumn()!=null){
             lorderColumn=getOrderColumn();
            }
            if(getOrderDirection()!=null){
            lorderDirection=getOrderDirection();
            }
            lorder=lorderColumn+" "+lorderDirection;
            sresults=null;
           }
           <#if (menuAttributesp2?contains("60") ) >
            lorder="a0xxukwxbvxxxxxxxxxxaccount asc";
           </#if>  
 
           getEntityManager().clear();// otherwise search was causing row being overwritten by search row
            // jsf cannot handle too many rows and columns for options(51) so return 1 but allow search to pick any, client(52)which also has many rows/columns checking not needed since only one record matching owner2 is shown
            // employee(40) restrict to own record,if demo user. otherwise show all like default user(56) restrict to own record if demo user
           <#if search1 != "">
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            if(searchVal == null || searchVal.isEmpty() ){
             searchVal=searchValJ;// until why seachVal getting empty this logic needed           
            }

            //for options/51, date not needed in search
            <#if (menuAttributesp2?contains("51") ) >
	sresults =  getEntityManager()
	.createQuery(
	"select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                   .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                   .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                  .getResultList();

            <#else>
             //below non options, employee, add search
             <#if menuAttributesp2 == "40" >
              if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
               Integer useremplsid=${employeeEntityName}Home.getCurrentUserToEmployee().getA0xxuobxbxxxxxxxxxxxsid();
 		  sresults =  getEntityManager()
                                       .createQuery(
                                         "select cc from ${entityName?cap_first}  cc where ((cc.zexxutoxlhxxxxxxxxxxowner=:owner or cc.a0xxuobxbxxxxxxxxxxxsid=:useremplsid) and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2) order by "+ lorder)
                                        .setParameter("owner", ownerCode)
                                        .setParameter("useremplsid", useremplsid)
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .setParameter("owner2", owner2Code)
                                        .getResultList();
              }else{
		  sresults =  getEntityManager()
                                      .createQuery(
                                        "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${statusFlagDateField} AS date) >= cast(:searchDate AS date)) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .getResultList();
              } 
             <#elseif menuAttributesp2 == "56" >
              if(searchStatus !=null && searchStatus.equals(-1)){//user dc
	                sresults =  getEntityManager()
                                 .createQuery(
                                "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and c2xxuxuaiv38xxxxxxxxalevel = null and (a0xxukuxbvxxxxxxxxxxid between :start and :end) ) order by "+ lorder)
                                .setParameter("owner2", owner2Code).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                .getResultList();
                 orderColumnPrev=lorderColumn;
                 orderDirectionPrev=lorderDirection;
                 if( sresults.size() == 0 && (searchVal != null && !searchVal.isEmpty()) ){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("empty"),""));
                 }
                 return sresults;
              }
              if(searchStatus !=null && searchStatus.equals(-2)){//sc
                            sresults =  getEntityManager()
                            .createQuery(
                            "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and c9xxuxxxbvxxxxxxxxxxactivationkey !=null and (a0xxukuxbvxxxxxxxxxxid between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", owner2Code).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();
                 orderColumnPrev=lorderColumn;
                 orderDirectionPrev=lorderDirection;
                 if( sresults.size() == 0 && (searchVal != null && !searchVal.isEmpty()) ){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("empty"),""));
                 }
                 return sresults;

              }
              if(searchStatus !=null && searchStatus.equals(-3)){//uc
                calendar.add(Calendar.DATE, -30); // 30 days no activity
                Date searchDate= calendar.getTime();
                 sresults =  getEntityManager()
                 .createQuery(
                  "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and cast(cc.z2xxcztxlxxxxxxxxxxxstatusfldt AS date)< cast(:searchDate AS date) and (cc.a0xxukuxbvxxxxxxxxxxid  between :start and :end) ) order by "+ lorder)
                   .setParameter("owner2", owner2Code).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchDate", searchDate)
                   .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                 orderColumnPrev=lorderColumn;
                 orderDirectionPrev=lorderDirection;
                 if( sresults.size() == 0 && (searchVal != null && !searchVal.isEmpty()) ){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("empty"),""));
                 }
                 return sresults;
              }
              if(searchStatus !=null && searchStatus.equals(-4)){//LH
                 Date searchDate= new Date(System.currentTimeMillis() - 3600 * 1000);
                 sresults =  getEntityManager()
                .createQuery(
                 "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and z2xxcztxlxxxxxxxxxxxstatusfldt >=:searchDate ) and (a0xxukuxbvxxxxxxxxxxid  between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", owner2Code).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchDate", searchDate)
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();
                 orderColumnPrev=lorderColumn;
                 orderDirectionPrev=lorderDirection;
                 if( sresults.size() == 0 && (searchVal != null && !searchVal.isEmpty()) ){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("empty"),""));
                 }
                 return sresults;
              }else{
               if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
                sresults =  getEntityManager()
                 .createQuery(
                   "select cc from ${entityName}  cc where cc.a0xxuobxbxxxxxxxxxxxsid=:logonsid  and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                    .setParameter("logonsid", customIdentity.getUserSid())
                     .setParameter("owner2", owner2Code)
                      .getResultList();
               }else{

	 sresults =  getEntityManager()
                   .createQuery(
                          "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (lower(${search1}) between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();
               }
              }
             <#elseif menuAttributesp2 == "54" >
             //groupmembers seach2value can be null
                 sresults =  getEntityManager()
                 .createQuery(
                  "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or (jxxxuq201xwwqqhxxxxxcustomer !=null and lower(${search2}) like lower(concat('%',:searchVal,'%'))) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${statusFlagDateField} AS date) >= cast(:searchDate AS date)) and (lower(${search1}) between :start and :end) )) order by "+ lorder)
                   .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();

             <#else>
              //all others
                  <#if statusFlagDateField == "Not assigned">
                   //dateField 
                   <#if menuAttributesp2?contains("1F")>
                    <#assign dateField="z4xxcxxrlxxxxxxxxxxxscandatet">
                   <#elseif menuAttributesp2?contains("8A")>
                    <#assign dateField="b5gxdxxdbvxxxxxxxxxxsdatet">
                   <#elseif menuAttributesp2?contains("1Q")>
                    <#assign dateField="">
                   <#elseif menuAttributesp2?contains("68")>
                    <#assign dateField="b1xxcjpdhvxxxxxxxxxxpostdate">
                   <#elseif menuAttributesp2?contains("1I")>
                    <#assign dateField="b1xxcsxraxxxxxxxxxxxdatetimeofscan">
                   <#elseif menuAttributesp2?contains("58")>
                    <#assign dateField="z3xxcxxrlxxxxxxxxxxxdatet">
                   <#elseif menuAttributesp2?contains("65")>
                    <#assign dateField="b5xxcxxrlxxxxxxxxxxxpostdate">
                   <#elseif menuAttributesp2?contains("82")>
                    <#assign dateField="zexxcxxrlxxxxxxxxxxxnewdate">
                   <#else> 
                    <#assign dateField="">
                   </#if> 
                  <#else>
                   //statusfield
                   <#assign dateField=statusFlagDateField>
                  </#if>


                 //:: type cast operator conflicts with the JPA so use cast(:searchDate AS date) dateField ${dateField} statflgdt ${statusFlagDateField}
                 <#if dateField !="">
                  <#if menuAttributesp2 == "68" >
                   //journal  seq is integer field oct14 endi increased and removed hyphen
                   // use seq instead of seqs start/end now uss suggestist and seq field
                   Integer startI=0; 
                   Integer endI=999999;
                   try{
                    startI=Integer.parseInt(start.replace("-",""));
                   }catch(Exception e){
                   }
                   try{
                    endI=Integer.parseInt(end.replace("-",""));
                   }catch(Exception e){
                   } 
                   sresults =  getEntityManager()
                    .createQuery(
                   <#if statusFlagField !="Not assigned">
		   "select cc from ${entityName?cap_first}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and ((lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and cc.b5cczjsibvxxxxxxxxxxjnlseq between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", startI).setParameter("end", endI).setParameter("searchStatus", searchStatus)
                   <#else>
		   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and cc.b5cczjsibvxxxxxxxxxxjnlseq between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", startI).setParameter("end", endI)
                   </#if>
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                   //not 68
                  <#else>
	   sresults =  getEntityManager()
	   .createQuery(
                   <#if statusFlagField !="Not assigned">
                    //these have statusfields but some needs extra search
                    <#if menuAttributesp2 == "1A" >
	    "select cc from ${entityName?cap_first}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and (:searchType is null or cc.c6xxusxrbv16xxxxxxxxtype = :searchType)  and ((lower(cc.a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(cc.w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(cc.a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%'))) and (cast(cc.z6xxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus).setParameter("searchType", searchType)
                    <#elseif menuAttributesp2 == "24">
                    //searchType added tbd can be used for other txns
	    "select cc from ${entityName?cap_first}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and (:searchType is null or cc.y9xxcxxxbv10xxxxxxxxtype = :searchType)  and ((lower(cc.a0xxuncobvxxxxxxxxxxpurchsno) like lower(concat('%',:searchVal,'%')) or lower(fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(jxxxuq201xwwqqhxxxxxcustomer.a0xxukxxbvxxxxxxxxxxcustomer) like lower(concat('%',:searchVal,'%')) or lower(cc.a0xxuncobvxxxxxxxxxxpurchsno) like lower(concat('%',:searchVal,'%'))) and (cast(cc.zdxxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and cc.a0xxuncobvxxxxxxxxxxpurchsno between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus).setParameter("searchType", searchType)
                    <#else>
                                   <#if menuAttributesp2 == "2B" >
                                    //cuodetails , used by picklist.xhtml, show non shipped orders 
                                      "select cc from ${entityName}  cc where zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl = :ord or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :ord or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :toPay) and ${search1} between :start and :end) order by "+ lorder) 
                                        .setParameter("owner2", owner2Code).setParameter("ord", mordered).setParameter("toPay", mtoPay).setParameter("start", Integer.parseInt(start)).setParameter("end", Integer.parseInt(end))
                                    <#else>
		    "select cc from ${entityName?cap_first}  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((:searchStatus is null  or cc.${statusFlagField} = :searchStatus) ) and ((lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%')))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and lower(${search1}) between :start and :end) ) order by "+ lorder)
                    .                     setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                                    </#if>
                    </#if>
                   <#else>// no statusfld
	    "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and (cast(cc.${dateField} AS date) >= cast(:searchDate AS date)) and lower(${search1}) between :start and :end) )  order by "+ lorder)
                    .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                   </#if>
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                  </#if>
                 <#else>//not date 
                   sresults =  getEntityManager()
                   .createQuery(
                   "select cc from ${entityName?cap_first}  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(${search1}) like lower(concat('%',:searchVal,'%')) or lower(${search2}) like lower(concat('%',:searchVal,'%')) or lower(${search3}) like lower(concat('%',:searchVal,'%'))) and lower(${search1}) between :start and :end) ) order by "+ lorder)
                   .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                 </#if>
             </#if>
             // all others end
            </#if>//options/nonoptions
            //non options end
           <#else>
           // search1 ie keyfield is empty ie keyfield is non string as in userprofl(57) or detail entities  added maxresults to avoid too many parameters
             <#if menuAttributesp2 == "57" >
            		List<${entityName?cap_first}> sresults =  getEntityManager()
                                    .createQuery(
                                    "select cc from ${entityName}  cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                                     .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal)
                                    .getResultList();
             <#else>
                <#if ownerField !="">      
            		List<${entityName?cap_first}> sresults =  getEntityManager()
                                     .createQuery(
                                      "select cc from ${entityName}  cc where cc.${ownerField}=:owner  and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                                       .setParameter("owner", ownerCode)
                           .              setParameter("owner2", owner2Code).setMaxResults(maxResultsVal)
                                         .getResultList();
                <#else>
            		List<${entityName?cap_first}> sresults =  getEntityManager()
                                     .createQuery(
                                      "select cc from ${entityName}  cc where zzxxu2oxxhxxxxxxxxxxowner2 = :owner2" ) 
                                        .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal)
                                         .getResultList();
                </#if>
             </#if>

           </#if>
          orderColumnPrev=lorderColumn;
          orderDirectionPrev=lorderDirection;
          if( sresults.size() == 0 && (searchVal != null && !searchVal.isEmpty()) ){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("empty"),""));

          }
          return sresults;

      }
      
     }
     public boolean isNextExists(){ return getResultCount() > (getFirstResult()!=null?getFirstResult():0) + getMaxResults(); }
     public boolean isSystemNextExists(){ return getSystemResultCount() > (getFirstResult()!=null?getFirstResult():0) + getMaxResults(); }

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public String getClientEMail() {
		return clientEMail;
	}

	public void setClientEMail(String clientEMail) {
		this.clientEMail = clientEMail;
	}

	public String getEmailFirstName() {
		return eMailFirstName;
	}

	public void setEmailFirstName(String eMailFirstName) {
		this.eMailFirstName = eMailFirstName;
	}
	public String getEmailLastName() {
		return eMailLastName;
	}

	public void setEmailLastName(String eMailLastName) {
		this.eMailLastName = eMailLastName;
	}

	public String getEmailAddress() {
		return eMailAddress;
	}

	public void setEmailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}

	public String getE1mailAddress() {
		return e1mailAddress;
	}

	public void setE1mailAddress(String e1mailAddress) {
		this.e1mailAddress = e1mailAddress;
	}

     public ${entityName} getSidSToEntity(String sidS){
      return getSidToEntity(Integer.parseInt(sidS));//
     }

     public ${entityName} getSidToEntity(Integer sid){
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from ${entityName} cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 



<#if menuAttributesp2 == "54" >

	public List<${groupmembersEntityName?cap_first}> getGroupGMembersList(int groupSid) {
          List<${groupmembersEntityName?cap_first}> gresults2=null;

          // called by import 
		 gresults2= getEntityManager()
				.createQuery( 
						"select cc from ${groupmembersEntityName?cap_first} cc where cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).getResultList();
          return gresults2; 
        }
</#if>



<#if menuAttributesp2 == "1N" >
     //used in mailingsend or in homeMockUp to check what seqs exist for -M  
	public List<${blobdataEntityName?cap_first}> getAllResultListSeqs(String table,String keyWPrefix,String keyQualifier,int keySequence,String owner) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;

                if(owner.isEmpty()){
		    return getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :blobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) order by a3xxexnsbvxxxxxxxxxxsequence")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
               }else{
		    return getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :blobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and z3xxutoxlhxxxxxxxxxxowner = :owner) order by a3xxexnsbvxxxxxxxxxxsequence")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", owner2Code).setParameter("owner", owner).getResultList();
               }

	}

     public Integer getNextSeqAvailable(String table,String keyWPrefix,String keyQualifier,int keySequence) {
      // get a list of existing blobs for the key starting with seqno requested , can have gaps. 
      // start with 0 and if available use it, otherwise add 1 and see if available
      // if 3R-TOP-BKGR seq 0,1,2 are valid also   get all records ie ignore oweners when calling getAllResultListSeqs
      int nextSeq=1;
      nextSeq=keySequence;//start with requested seq not default value 1
      List<${blobdataEntityName?cap_first}> jaySeqs = getAllResultListSeqs(table,keyWPrefix,keyQualifier,keySequence,"");
      Iterator <${blobdataEntityName?cap_first}> iterator = jaySeqs.iterator();
      while (iterator.hasNext()){
       ${blobdataEntityName?cap_first} jay=iterator.next();
       //limit check is in calling method
       // jay check why seq 0 not being used 1 being used 
       if (jay.getA3xxexnsbvxxxxxxxxxxsequence() != nextSeq && jay.getA3xxexnsbvxxxxxxxxxxsequence() > nextSeq){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_WARN,bundle.getString("binary")+" "+bundle.getString("data")+", "+bundle.getString("sequence")+" "+bundle.getString("available")+" "+nextSeq+", "+bundle.getString("used")+" "+jay.getA3xxexnsbvxxxxxxxxxxsequence(),""));
        return nextSeq;
       }
       else {
         nextSeq=nextSeq+1;
       } 
      }
      // if no seq exists or no gap found, top-bkgr uses 1 and 2 only , 0 is already used to allow color as background instead of image
      if(keyWPrefix.contains("3R-TOP-BKGR")){
        nextSeq=nextSeq==0?1:nextSeq;
      }
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_WARN,bundle.getString("binary")+" "+bundle.getString("data")+" "+bundle.getString("sequence")+" "+nextSeq+" "+bundle.getString("will")+" "+bundle.getString("be")+" "+bundle.getString("used")+" "+bundle.getString("for")+" "+bundle.getString("key")+" 3R-TOP-BKGR",""));
      return nextSeq;
     } 


     public ${entityName} getOldest() {
      // get oldest entity based on statusfldt but skip if that seq is already marked to be attached
      // jay checkEMailingAttachSeq(Integer index) logic later to skip
                        ${componentName}=null;
			List<${componentName?cap_first}> results =  getEntityManager()
					.createQuery("select cc from ${componentName?cap_first} cc where cc.a1xxuxxxbv49xxxxxxxxfromkey = :fromKey AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  cc.${statusFlagDateField}").setParameter("owner2", owner2Code).
                setParameter("fromKey", "3R-ATTACHMENT-1-C").getResultList();
                           if(!results.isEmpty()){
                            ${componentName} = results.get(0);
                           }
                           return ${componentName};

    } 

     
	public List<${blobdataEntityName?cap_first}> getSystemResultListSeqs(String table,String keyWPrefix,String keyQualifier,int keySequence) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;

		    return getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :blobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", "SYSTEM").getResultList();

	}

     public Yxxxuq1n1xwwqqqxxxxxblobdata getSystemBlobDataInstance(String table,String keyWPrefix,String keyQualifier,int keySequence) {
     // 
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	   String slobkeyhash = keyWPrefix.substring(1);
	   String qualifier = keyQualifier;
	   int sequence = keySequence;
           List<${blobdataEntityName?cap_first}> results=null;
           try {
		results =  getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :blobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", "SYSTEM").getResultList();

         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return null;
        }
        if(results.isEmpty()){
          return null;
        }
        if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
       }
       return results.get(0);
     }




	public ${blobdataEntityName?cap_first} getUserBlobDataInstance(String table,String keyWPrefix,String keyQualifier,int keySequence,String jowner2Code) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }
	   String slobkeyhash = keyWPrefix.substring(1);
	   String qualifier = keyQualifier;
	   int sequence = keySequence;
           List<${blobdataEntityName?cap_first}> results=null;
           try {
		 results = getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :blobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", jowner2Code).getResultList();
         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return null;
        }
        if(results.isEmpty()){
          return null;
        }
        if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
       }
       return results.get(0);
     }

      // system record 0 is not allowed to change because it will affect all tenants 
      // so this is called when owner2 wants to change the Image value, so on return from here create under owner2 if needed or return existing
      // one under owner2. SYSTEM record will be used when no value change and the login is under DataBaseResourceLoader

	public ${blobdataEntityName?cap_first} getUserBlobDataInstance(String table,String keyWPrefix,String keyQualifier,int keySequence) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	   String slobkeyhash = keyWPrefix.substring(1);
	   String qualifier = keyQualifier;
	   int sequence = keySequence;
           List<${blobdataEntityName?cap_first}> results=null;
           try {
		 results = getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :blobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return null;
        }
        if(results.isEmpty()){
          return null;
        }
        if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
       }
       return results.get(0);
     }

     public ${blobdataEntityName?cap_first} getDocmntWPrefixToEntity(String docmnt){
      if(docmnt == null || docmnt.isEmpty()){
       return null;
      }
      ${blobdataEntityName?cap_first} entity=null;
      List<${blobdataEntityName?cap_first}> results=null;
      docmnt=docmnt.substring(1);
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from ${blobdataEntityName?cap_first} cc where cc.a1xxuxxxbv49xxxxxxxxfromkey = :sDocmnt and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("sDocmnt",docmnt)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${blobdataEntityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+", "+docmnt,""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 



</#if>
<#if menuAttributesp2 == "1M" >

     // added endSequence to allow blocks like 0-9 summary,10-29 tech specs, 30-99 reviews. 0,10,30 are
     //reserved for headers  sort dsc added to show latest first and limit to 20, add pgination tbd
     // add order by as param and allow filter by rating etc
     //used in cartItem to get clobdata HDR/TXT for
     // seq 0...n for Item docmnt. clobdata will hold Item summary, tech specs, reviews. Hdr for labels and Txt for body
	public List<${clobdataEntityName?cap_first}> getAllResultListSeqs(String table,String keyWPrefix,String keyQualifier,int keySequence,String owner,int endSequence) {
         try{
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;
                if(owner.isEmpty()){
		 return getEntityManager()
		  .createQuery(
		  "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :clobdatasequence and a3xxexnsbvxxxxxxxxxxsequence <= :clobdataendSequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM')order by a3xxexnsbvxxxxxxxxxxsequence desc")
		  .setParameter("clobdatafromtable", actualTable).setParameter("clobdatafromkey", slobkeyhash)
                  .setParameter("clobdataqualifier", qualifier).setParameter("clobdatasequence", sequence)
                  .setParameter("clobdataendSequence", endSequence).setParameter("owner2", owner2Code).setMaxResults(20).getResultList();
               }else{
		    return getEntityManager()
			.createQuery(
			"select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :clobdatasequence and a3xxexnsbvxxxxxxxxxxsequence <= :clobdataendSequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and z3xxutoxlhxxxxxxxxxxowner = :owner)order by a3xxexnsbvxxxxxxxxxxsequence desc")
	               .setParameter("clobdatafromtable", actualTable).setParameter(
			"clobdatafromkey", slobkeyhash).setParameter(
			"clobdataqualifier", qualifier).setParameter("clobdataendSequence", endSequence).setParameter(
			"clobdatasequence", sequence).setParameter("owner2", owner2Code).setParameter("owner", owner).setMaxResults(20).getResultList();
               }
         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("clobdata")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return null;
         }


	}


     //used in mailingsend or in homeMockUp to check what seqs exist for -M 
	public List<${clobdataEntityName?cap_first}> getAllResultListSeqs(String table,String keyWPrefix,String keyQualifier,int keySequence,String owner) {
         try{
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;
                if(owner.isEmpty()){
		 return getEntityManager()
                  .createQuery(
                   "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM')order by a3xxexnsbvxxxxxxxxxxsequence")
                    .setParameter("clobdatafromtable", actualTable).setParameter(
                    "clobdatafromkey", slobkeyhash).setParameter(
                    "clobdataqualifier", qualifier).setParameter(
                    "clobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
               }else{
                return getEntityManager()
                 .createQuery(
                  "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and z3xxutoxlhxxxxxxxxxxowner = :owner)order by a3xxexnsbvxxxxxxxxxxsequence")
                  .setParameter("clobdatafromtable", actualTable).setParameter(
                  "clobdatafromkey", slobkeyhash).setParameter(
                  "clobdataqualifier", qualifier).setParameter(
                  "clobdatasequence", sequence).setParameter("owner2", owner2Code).setParameter("owner", owner).getResultList();
               }

         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("clobdata")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return null;
         }
	}


      // get a list of existing clobs for the key starting with seqno requested , can have gaps. 
      // start with 0 and if available use it, otherwise add 1 and see if available also   get all records ie ignore oweners when calling getAllResultListSeqs
      // do not use any limit but add logic to give warning to delete old records
      // 

     public Integer getNextSeqAvailable(String table,String keyWPrefix,String keyQualifier,int keySequence) {
      int nextSeq=1 ;
      nextSeq=keySequence;// should start with requested seq not default 1
      List<${clobdataEntityName?cap_first}> jaySeqs = getAllResultListSeqs(table,keyWPrefix,keyQualifier,keySequence,"");
      Iterator <${clobdataEntityName?cap_first}> iterator = jaySeqs.iterator();
      while (iterator.hasNext()){
       ${clobdataEntityName?cap_first} jay=iterator.next();
       //limit check is in calling method
       if (jay.getA3xxexnsbvxxxxxxxxxxsequence() != nextSeq && jay.getA3xxexnsbvxxxxxxxxxxsequence() > nextSeq){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_WARN,bundle.getString("text")+" "+bundle.getString("data")+", "+bundle.getString("sequence")+" "+bundle.getString("available")+" "+nextSeq+" "+bundle.getString("used")+" "+jay.getA3xxexnsbvxxxxxxxxxxsequence(),""));
        return nextSeq;
       }
       else {
        nextSeq=nextSeq+1;
       } 
      }
        //suppress from userFacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
        //FacesMessage.SEVERITY_WARN,bundle.getString("text")+" "+bundle.getString("data")+", "+bundle.getString("sequence")+" "+bundle.getString("used")+" "+nextSeq,""));

      return nextSeq;
     } 

     //not used
	public List<${clobdataEntityName?cap_first}> getSystemResultListSeqs(String table,String keyWPrefix,String keyQualifier,int keySequence) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;

                return getEntityManager()
                 .createQuery(
                  "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence >= :clobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                   .setParameter("clobdatafromtable", actualTable).setParameter(
                   "clobdatafromkey", slobkeyhash).setParameter(
                   "clobdataqualifier", qualifier).setParameter(
                   "clobdatasequence", sequence).setParameter("owner2", "SYSTEM").getResultList();

	}

	public String getCleaned(String strHTML) {
         String cleanedHTML = Jsoup.clean(strHTML, Whitelist.none());  
         String text= cleanedHTML.replace("&nbsp;"," "); 
         text= text.replace("&amp;","&"); 
         return text;
        }

	public String getclobDataSystemInstance(String table,String keyWPrefix,String keyQualifier,int keySequence,int size) {
         ${clobdataEntityName?cap_first} clobdata= getclobDataSystemInstance(table,keyWPrefix,keyQualifier,keySequence);
                if(clobdata==null){
                 return null;
                }
                else{
                 int dl=clobdata.getB1xxuzaxbvxxxxxxxxxxdata().length();
                 if (dl > size){
			  return clobdata.getB1xxuzaxbvxxxxxxxxxxdata().substring(0,size);
                 }else {
			  return clobdata.getB1xxuzaxbvxxxxxxxxxxdata();
                 }
                } 


        }

/**
 returns gallery (SYSTEM) entities for a key ie include all vendors and themes
*@param1 clobdata,@param2 key like A3R-TOP-BKGR-C,@param3 qualifier is theme , @param4 sequence 0

*/
	public ${clobdataEntityName?cap_first} getclobDataSystemInstance(String table,String keyWPrefix,String keyQualifier,int keySequence) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;
                bcontinue=true;
                List<${clobdataEntityName?cap_first}> results=null;
           try {
		 results=  getEntityManager()
                  .createQuery(
                   "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 )")
                    .setParameter("clobdatafromtable", actualTable).setParameter(
                     "clobdatafromkey", slobkeyhash).setParameter(
                     "clobdataqualifier", qualifier).setParameter(
                     "clobdatasequence", sequence).setParameter("owner2", "SYSTEM").getResultList();
         } catch ( Exception other){
          bcontinue=false;
          yxxxuq1m1xwwqqqxxxxxclobdata=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("shared")+" "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));

         }
         if(results.isEmpty()){
          // check if -C exists
          try{
		 results=  getEntityManager()
			.createQuery(
			 "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 )")
			  .setParameter("clobdatafromtable", actualTable).setParameter(
			   "clobdatafromkey", slobkeyhash.replace("-M","-C")).setParameter(
			   "clobdataqualifier", qualifier).setParameter(
			   "clobdatasequence", sequence).setParameter("owner2", "SYSTEM").getResultList();
          } catch ( Exception other){
           bcontinue=false;
           yxxxuq1m1xwwqqqxxxxxclobdata=null;
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("shared")+" "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));
          }
          if(results.isEmpty()){
           return null;
          }
          ${clobdataEntityName}Home.clearInstance();
          yxxxuq1m1xwwqqqxxxxxclobdata=results.get(0);
          yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey(slobkeyhash.replace("-C","-M"));
          yxxxuq1m1xwwqqqxxxxxclobdata.setZ2xxcztxlxxxxxxxxxxxstatusfldt(Calendar.getInstance().getTime());
          ${clobdataEntityName}Home.superdotpersist();
          return yxxxuq1m1xwwqqqxxxxxclobdata;
         }
         if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("shared")+" "+bundle.getString("clobdata")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));

          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
         } 
         return results.get(0);


	}
/**
 returns gallery (SYSTEM) entities for a vendor and theme and a key
*@param1 clobdata,@param2 key like A3R-TOP-BKGR-C,@param3 qualifier is theme , @param4 sequence 0, @param5 owner is vendor but not used
* owner (vendor) not needed since theme name is already unique
*/
	public ${clobdataEntityName?cap_first} getclobDataSystemOwnerInstance(String table,String keyWPrefix,String keyQualifier,int keySequence,String ownerCode) {
      // this is called only when owner2 wants to change the HDR/TXT value, so on return from here create under owner2 if needed or return existing
      // one under owner2. SYSTEM record will be used when no value change and the login is under DataBaseResourceLoader
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;
                bcontinue=true;
                List<${clobdataEntityName?cap_first}> results=null;
           try {
		 results=  getEntityManager()
                  .createQuery(
                   "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 )")
                   .setParameter("clobdatafromtable", actualTable).setParameter(
                     "clobdatafromkey", slobkeyhash).setParameter(
                     "clobdataqualifier", qualifier).setParameter(
                     "clobdatasequence", sequence).setParameter("owner2", "SYSTEM").getResultList();
         } catch ( Exception other){
          bcontinue=false;
          yxxxuq1m1xwwqqqxxxxxclobdata=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+" "+ownerCode+", "+bundle.getString("shared")+" "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));

         }
         if(results.isEmpty()){
          return null;
         }
         if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+" "+ownerCode+", "+bundle.getString("shared")+" "+bundle.getString("clobdata")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));

          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
         } 
         if(keyQualifier.isEmpty()){//theme
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("Theme")+" "+bundle.getString("not")+" "+bundle.getString("selected")+", "+bundle.getString("default")+" "+bundle.getString("entry")+" "+bundle.getString("used"),""));
         } 
         return results.get(0);


	}
/**
* may be not used yet below with 4 params more used
* returns  entities for new site or another site 
*@param1 clobdata,@param2 key like A3R-TOP-BKGR-C,@param3 qualifier is theme , @param4 sequence 0,@param5 owner2 xxx 
* if preview -M does not exist but publish -C exists then it means -C manually created and can cause confusion, so
* fix it by creating -M from -C and retuen it 

*/
	public ${clobdataEntityName?cap_first} getclobDataInstance(String table,String keyWPrefix,String keyQualifier,int keySequence,String jowner2Code) {
           String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;
                bcontinue=true;
                List<${clobdataEntityName?cap_first}> results=null;
           try {
		 results=  getEntityManager()
			.createQuery(
			 "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 )")
			  .setParameter("clobdatafromtable", actualTable).setParameter(
			   "clobdatafromkey", slobkeyhash).setParameter(
			   "clobdataqualifier", qualifier).setParameter(
			   "clobdatasequence", sequence).setParameter("owner2", jowner2Code).getResultList();
         } catch ( Exception other){
          bcontinue=false;
          yxxxuq1m1xwwqqqxxxxxclobdata=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash.replace("-M","-C")+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));

         }
         if(results ==null || results.isEmpty()){
          //  check for null, check if -C exists
          try{
		 results=  getEntityManager()
			.createQuery(
			 "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 )")
			  .setParameter("clobdatafromtable", actualTable).setParameter(
			   "clobdatafromkey", slobkeyhash.replace("-M","-C")).setParameter(
			   "clobdataqualifier", qualifier).setParameter(
			   "clobdatasequence", sequence).setParameter("owner2", jowner2Code).getResultList();
          } catch ( Exception other){
           bcontinue=false;
           yxxxuq1m1xwwqqqxxxxxclobdata=null;
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));
          }
          if(results.isEmpty()){
           return null;
          }
          ${clobdataEntityName}Home.clearInstance();
          yxxxuq1m1xwwqqqxxxxxclobdata=results.get(0);
          yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey(slobkeyhash.replace("-C","-M"));
          yxxxuq1m1xwwqqqxxxxxclobdata.setZ2xxcztxlxxxxxxxxxxxstatusfldt(Calendar.getInstance().getTime());
          ${clobdataEntityName}Home.superdotpersist();
          return yxxxuq1m1xwwqqqxxxxxclobdata;
         }
         if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));

          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
         } 
         return results.get(0);


	}


/**
 returns site entities for a key
*@param1 clobdata,@param2 key like A3R-TOP-BKGR-C,@param3 qualifier is theme , @param4 sequence 0

*/
	public ${clobdataEntityName?cap_first} getclobDataInstance(String table,String keyWPrefix,String keyQualifier,int keySequence) {
                String actualTable=table;
           if(keyWPrefix.length() <1 ){
            return null;
           }

	     	String slobkeyhash = keyWPrefix.substring(1);
		String qualifier = keyQualifier;
		int sequence = keySequence;
                bcontinue=true;
                List<${clobdataEntityName?cap_first}> results=null;
         try {
		 results=  getEntityManager()
					.createQuery(
					 "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) order by ${statusFlagField} desc")
					  .setParameter("clobdatafromtable", actualTable).setParameter(
					   "clobdatafromkey", slobkeyhash).setParameter(
					    "clobdataqualifier", qualifier).setParameter(
						"clobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
         } catch ( Exception other){
          bcontinue=false;
          yxxxuq1m1xwwqqqxxxxxclobdata=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));

          //add logic to check type of error and decide for now return  added order by statusfldt desc
          return null;
         }
         if(results == null || results.isEmpty()){
          // check if -C exists then create -M from -C to avoid no fallback if publish not good
          String slobkeyhashM=slobkeyhash;
          try{
                 slobkeyhash=slobkeyhash.substring(0,slobkeyhash.length()-1)+"C";
		 results=  getEntityManager()
			.createQuery(
			 "select cc from ${clobdataEntityName?cap_first} cc where cc.a0xxukcdlvxxxxxxxxxxfromtable=:clobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:clobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:clobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :clobdatasequence AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 )")
			  .setParameter("clobdatafromtable", actualTable).setParameter(
			   "clobdatafromkey", slobkeyhash).setParameter(
			   "clobdataqualifier", qualifier).setParameter(
			   "clobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
          } catch ( Exception other){
           bcontinue=false;
           yxxxuq1m1xwwqqqxxxxxclobdata=null;
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("error")+" "+other.getMessage(),""));
           return null;
          }
          if(results.isEmpty()){
           return null;
          }
          ${clobdataEntityName}Home.clearInstance();
          yxxxuq1m1xwwqqqxxxxxclobdata=results.get(0);
          yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxuobxbxxxxxxxxxxxsid(null);
          yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey(slobkeyhashM);
          yxxxuq1m1xwwqqqxxxxxclobdata.setZ2xxcztxlxxxxxxxxxxxstatusfldt(Calendar.getInstance().getTime());
          entityManager.detach(yxxxuq1m1xwwqqqxxxxxclobdata);
          ${clobdataEntityName}Home.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
          ${clobdataEntityName}Home.superdotpersist();
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("missing")+" "+slobkeyhashM+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("created")+" "+bundle.getString("from")+" "+slobkeyhash,""));
          return yxxxuq1m1xwwqqqxxxxxclobdata;
         }  
         if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,slobkeyhash+" "+qualifier+" "+sequence+", "+bundle.getString("clobdata")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));

          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("latest")+" "+bundle.getString("saved")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates")+" "+bundle.getString("or")+" "+bundle.getString("update")+" "+bundle.getString("to")+" "+bundle.getString("be")+" "+bundle.getString("saved")+" "+bundle.getString("as")+" "+bundle.getString("latest"), ""));
         } 
         return results.get(0);


	}
     public ${entityName} getOldest() {
      // get oldest attachment entity based on statusfldt
                        ${componentName}=null;
			List<${componentName?cap_first}> results =  getEntityManager()
			.createQuery("select cc from ${componentName?cap_first} where  a1xxuxxxbv49xxxxxxxxfromkey = :fromKey AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  cc.${statusFlagDateField}").setParameter("owner2", owner2Code).
                         setParameter("fromKey", "3R-ATTACHMENT-1-C").getResultList();
                           if(!results.isEmpty()){
                            ${componentName} = results.get(0);
                           }
                           return ${componentName};

    } 


</#if>
<#if menuAttributesp2 == "1R" >
      // this is called only when owner2 wants to change the message value, so on return from here create under owner2 if needed or return existing
      // one under owner2. SYSTEM record will be used when no value change and the login is under DataBaseResourceLoader

	public ${resourceEntityName?cap_first} getresourceInstance(String msgKey) {
         try{
		${resourceEntityName}= (${resourceEntityName?cap_first}) getEntityManager()
                 .createQuery(
                  "select cc from ${resourceEntityName?cap_first} cc where cc.a0xxukrdbvxxxxxxxxxxkey=:key and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
                  .setParameter("key", msgKey).setParameter("owner2", owner2Code).getSingleResult();
         } catch ( NoResultException nre){
          ${resourceEntityName}=null;
         } catch ( Exception ignore){
          // multiple or some other, return empty object so that a new one not created
          //${resourceEntityName}=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("get")+" "+bundle.getString("message")+" "+bundle.getString("resource")+" "+bundle.getString("error")+" "+ignore.getMessage(), ""));

         }
          return ${resourceEntityName};
     }
          
</#if>
<#if menuAttributesp2 == "A4" >
/**
get coorder sid from the order key passed
then search in cuidetails for order sid and matcode, quantity, line #
if found return orderdetail list,can be maultiple match 
**/
     public ${entityName} getDetailByParentKey(String orderKey,String matcode, BigDecimal qtyOrd, int line ){
      ${entityName} entity=null;
      List<${entityName}> results=null;
      
      try{
/*
       results = getEntityManager()
                 .createQuery(
                  "select cc from ${entityName} cc where cc.a0xxuncobvxxxxxxxxxxpurchsno = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
                   .setParameter("nKeyName",orderkey)
                   .setParameter("owner2", owner2Code)
                    .getResultList();
*/
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 

</#if>
<#if menuAttributesp2 == "1L" >
         List <${resource_bundleEntityName?cap_first}> results=null;

	public ${resource_bundleEntityName?cap_first} getresource_bundleInstance(String msgKey) {
         try{
               // assume SYSTEM sid will be less than owner2 sid(wrong) , system msgs are now regenerated
               // however user msg bundle wont have m or m_lang bundle, users must have m_lang_US.... logic works??
               results=  getEntityManager()
                          .createQuery(
                           "select cc from ${resource_bundleEntityName?cap_first} cc where cc.a0xxukrdbvxxxxxxxxxxname=:key and (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') order by cc.a0xxuobxbxxxxxxxxxxxsid")
                           .setParameter("key", msgKey).setParameter("owner2", owner2Code).getResultList();
         } catch ( NoResultException nre){
          ${resource_bundleEntityName}=null;
         } catch ( Exception ignore){
          ${resource_bundleEntityName}=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("get")+" "+bundle.getString("message")+" "+bundle.getString("bundle")+" "+bundle.getString("error")+" "+ignore.getMessage(), ""));


         }
         if(results.size() >0){
          //could be SYSTEM only or SYSTEM and followed by owner2
          if(results.size()==1){
           return results.get(0);
          }else{
           return results.get(1); 
          }
         }else{
          return null;
         }
     }
</#if>

 <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >

        public List<${employeeEntityName?cap_first}> getCcList(){
         return ccresults;
       }

	public List<${entityName}> getMailingList() {
          //only sresults returned, ccresults (employee) built but not part of sresults which can be one of customer/vendor/employee 
          //sresults is a list of Entity objects , since we are going to add to it, cannot be null clear() it or new
          //sresults will hold one type of entities like customer/vendor/employee but not a mixture
          //from the webpage we get toDraftlist which is string of keys for one type customer/vendor/employee  or 
          // the same type extracted from the group.
          // this string keys are converted to sid (step unnecessary now) and the full entity is retrieved and added
          // to sresults
          // ccresults is similar to sresults but holds employee entity only   
          // conresults and vonresults are similar to sresults but holds customer/vendor contact entity only   
          sresults= new ArrayList<${entityName}>();
          <#if menuAttributesp2 ="20" && (ccontactEntityName?? && ccontactEntityName?length > eL)>
           conresults= new ArrayList<${ccontactEntityName?cap_first}>();
          </#if>
          <#if menuAttributesp2 ="30" && (vcontactEntityName?? && vcontactEntityName?length > eL)>
           vonresults= new ArrayList<${vcontactEntityName?cap_first}>();
          </#if>
          Integer jaySid=-1;
          // copy from toDraftSelects to toSelects , ccDraftSelects to ccSelects . draft has key whereas to/ccSelect
          // has sid
          // ccSelects or toSelects or groupXMembers come from view and already filtered out unsubscribed (status 64)
          // and those without email addr via suggestlist
         
         <#if keyField!="" && statusFlagField !="Not assigned">
          // take care of cc list first. cc list always shows employee only
          // customer or vendor are in to: list only not in cclist
          if (ccDualSuggestListE.getTarget() !=null && ccDualSuggestListE.getTarget().size()  >0 && ccDualSuggestListE.getTarget().get(0) !=null ){
           //now create new objects from toSelects and add to null sresults
       
           // ccDraftSelects has customer key via dropdownList and ccSelect has sid
          
           // loop through array and add, but this method gets called many times so make sure ccresults starts empty
           // ccresults is used in iterator in mailingcontent for multiple Cc
           // they also need to be added to 
           // filter out those without email address
           ccresults= new ArrayList<${employeeEntityName?cap_first}>();
           ${employeeEntityName}=${employeeEntityName}Home.getInstance();
           for(int i=0; i<ccDualSuggestListE.getTarget().size(); i++){
            <#if (menuAttributesp2 ="40")>
	     ${employeeEntityName}=this.getCcDualSuggestListE().getTarget().get(i);
            <#else> 
	     ${employeeEntityName}=${employeeEntityName}List.getCcDualSuggestListE().getTarget().get(i);
            </#if>

            if(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr() !=null && ${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr().contains("@")){
             ccresults.add(${employeeEntityName});
             //sresults.add(${componentName});
            }
           }
          }
          // either group or entity not both are allowed ??
          if (groupSid !=null && groupSid  >0){
           //now create new objects from groupmembers and add to null sresults
           // also add last email to instance because a to: dummy entry is still needed even if its gets ignored later
           // used to indicate last email sent as well
           ${componentName}=${componentName}Home.getInstance();
           <#if menuAttributesp2 ="20">
           // groupSid has group sid via dropdownList 
           // to make non null,send checks for size plus may add contact logic for group
           fxxxuq1ggxwwqqhxxxxxmembersgroupHome.setFxxxuq1ggxwwqqhxxxxxmembersgroupA0xxuobxbxxxxxxxxxxxsid(groupSid);
	   fxxxuq1ggxwwqqhxxxxxmembersgroup=fxxxuq1ggxwwqqhxxxxxmembersgroupHome.getDefinedInstance();
           sresults.addAll(getGroupCMembersList(fxxxuq1ggxwwqqhxxxxxmembersgroup.getA0xxuobxbxxxxxxxxxxxsid()));
           ${componentName}.setQ4xxhxxxbv24xxxxxxxximailaddr(sresults.get(sresults.size()-1).getQ4xxhxxxbv24xxxxxxxximailaddr());         


           <#elseif menuAttributesp2 ="30" && (vcontactEntityName?? && vcontactEntityName?length > eL)>
           //vonresults= new ArrayList<${vcontactEntityName?cap_first}>();
           // groupSid has group sid via dropdownList 
           fxxxuq1ggxwwqqhxxxxxmembersgroupHome.setFxxxuq1ggxwwqqhxxxxxmembersgroupA0xxuobxbxxxxxxxxxxxsid(groupSid);
   	   fxxxuq1ggxwwqqhxxxxxmembersgroup=fxxxuq1ggxwwqqhxxxxxmembersgroupHome.getDefinedInstance();
           sresults.addAll(getGroupVMembersList(fxxxuq1ggxwwqqhxxxxxmembersgroup.getA0xxuobxbxxxxxxxxxxxsid()));
           ${componentName}.setN4xxhxxrbv24xxxxxxxximailaddr(sresults.get(sresults.size()-1).getN4xxhxxrbv24xxxxxxxximailaddr());         

           <#elseif menuAttributesp2 ="40">
           // groupSid has group sid via dropdownList 
           fxxxuq1ggxwwqqhxxxxxmembersgroupHome.setFxxxuq1ggxwwqqhxxxxxmembersgroupA0xxuobxbxxxxxxxxxxxsid(groupSid);
	   fxxxuq1ggxwwqqhxxxxxmembersgroup=fxxxuq1ggxwwqqhxxxxxmembersgroupHome.getDefinedInstance();
           sresults.addAll(getGroupEMembersList(fxxxuq1ggxwwqqhxxxxxmembersgroup.getA0xxuobxbxxxxxxxxxxxsid()));
           ${componentName}.setN4xxhxxrbv24xxxxxxxximailaddr(sresults.get(sresults.size()-1).getN4xxhxxrbv24xxxxxxxximailaddr());         
           </#if>
           group=fxxxuq1ggxwwqqhxxxxxmembersgroup.getA0xxukxxbvxxxxxxxxxxgroupid();
           return sresults; 
          //cc allways then either group or ToSelects but no all list  
          }
          else{
           if (toDualSuggestList.getTarget() !=null && toDualSuggestList.getTarget().size()  >0 && toDualSuggestList.getTarget().get(0) !=null){
            //now create new objects from toSelects and add to null sresults
            // toSelects has customer key via dropdownList 
            // loop through array and add 
            ${componentName}=${componentName}Home.getInstance();
            <#if menuAttributesp2 ="20" && (ccontactEntityName?? && ccontactEntityName?length > eL)>
            conresults= new ArrayList<${ccontactEntityName?cap_first}>();
            for(int i=0; i<toDualSuggestList.getTarget().size(); i++){
             ${componentName}=this.getToDualSuggestList().getTarget().get(i);

             if(${componentName}.getQ4xxhxxxbv24xxxxxxxximailaddr() !=null && ${componentName}.getQ4xxhxxxbv24xxxxxxxximailaddr().contains("@")){
              sresults.add(${componentName});
              if(contactYN){
               conresults2= getCcontactsList(${componentName}.getA0xxuobxbxxxxxxxxxxxsid());
               if(!conresults2.isEmpty()){
                conresults.addAll(conresults2);
               }
              }
             }
            }
            <#elseif menuAttributesp2 ="30" && (vcontactEntityName?? && vcontactEntityName?length > eL)>
            vonresults= new ArrayList<${vcontactEntityName?cap_first}>();
            if(toDraftSelects !=null){
             for(int i=0; i<toDraftSelects.size(); i++){
              ${componentName}=this.getKeyToEntity(toDraftSelects.get(i));
              if(${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr() !=null && ${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr().contains("@")){
               sresults.add(${componentName});
               if(contactYN){
                vonresults2= getVvontactsList(${componentName}.getA0xxuobxbxxxxxxxxxxxsid());
                if(!vonresults.isEmpty()){
                 vonresults.addAll(vonresults2);
                }
               }
              }
             }
            }
            <#elseif menuAttributesp2 ="40">
            if(toDraftSelects !=null){
             for(int i=0; i<toDraftSelects.size(); i++){
              ${componentName}=this.getKeyToEntity(toDraftSelects.get(i));
              if(${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr() !=null && ${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr().contains("@")){
               sresults.add(${componentName});
              }
             }
           }
            </#if>
            return sresults; 
           }//end group
           else{
            //dont allow whole mailing list, its too risky
            return sresults;
           }//group/list
          }//cc/group/list
         <#else> 
         </#if>


  }

</#if> 
 <#if (menuAttributesp2 ="89" || menuAttributesp2 ="40" ) >
        //89-schedule, get employee instances including name,Imail for a group 
	public List<${employeeEntityName?cap_first}> getGroupEMembersList(int groupSid) {
          // called by getMailingList which is called by send()ie regular Emailing and preview EMailing or by getEIMailAddrList which needs instances to get names etc along with email addr 
          // filter out unsubscribed and empty email address
          //iterate through group members for this group and look for employee only 
           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
                 // owner created records only
		 eresults2= getEntityManager()
				.createQuery( 
						"select cc.${employeeEntityName} from ${groupmembersEntityName?cap_first} cc where cc.${employeeEntityName}.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.${ownerField}=:owner  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${employeeEntityName}.${estatusFlagField} != :flag AND cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();

           }else{
		 eresults2= getEntityManager()
				.createQuery( 
						"select cc.${employeeEntityName} from ${groupmembersEntityName?cap_first} cc where cc.${employeeEntityName}.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${employeeEntityName}.${estatusFlagField} != :flag AND cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();

           }
        return eresults2; 
        }
 </#if>
 <#if (menuAttributesp2 ="89" || menuAttributesp2 ="30" ) >
	public List<${vendorEntityName?cap_first}> getGroupVMembersList(int groupSid) {
          // called by getMailingList which is called by send()ie regular Emailing and preview EMailing or by getVIMailAddrList which needs instances to get names etc along with email addr 
          // filter out unsubscribed and empty email address

           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 vresults2= getEntityManager()
				.createQuery( 
						"select cc.${vendorEntityName} from ${groupmembersEntityName?cap_first} cc where cc.${vendorEntityName}.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.${ownerField}=:owner  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${vendorEntityName}.${vstatusFlagField} != :flag AND cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();
           }else{
		 vresults2= getEntityManager()
				.createQuery( 
						"select cc.${vendorEntityName} from ${groupmembersEntityName?cap_first} cc where cc.${vendorEntityName}.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${vendorEntityName}.${vstatusFlagField} != :flag AND cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();
           }
        return vresults2; 
        }
     <#if (menuAttributesp2 ="30" && vcontactEntityName?? && vcontactEntityName?length > eL ) >

	public List<${vcontactEntityName?cap_first}> getVvontactsList(int vendorSid) {
          // called by getMailingList which is called by send()ie regular Emailing and preview EMailing or by getVIMailAddrList which needs instances to get names etc along with email addr 
          // filter out unsubscribed and empty email address
           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 vonresults2= getEntityManager()
				.createQuery( 
						"select cc from ${vcontactEntityName?cap_first} cc where cc.l4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.${ownerField}=:owner  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z2xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.${vendorEntityName}.a0xxuobxbxxxxxxxxxxxsid=:vendorSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("vendorSid", vendorSid).setParameter("flag", mnoMail).getResultList();

           }else{
		 vonresults2= getEntityManager()
				.createQuery( 
						"select cc from ${vcontactEntityName?cap_first} cc where cc.l4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z2xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.${vendorEntityName}.a0xxuobxbxxxxxxxxxxxsid=:vendorSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("vendorSid", vendorSid).setParameter("flag", mnoMail).getResultList();
           }
        return vonresults2; 
       }
     </#if>
    
     <#if (menuAttributesp2 ="30")>
      public Jxxxuq300xwwqqhxxxxxvendor getVoVendorLike(String slike){
       List<Jxxxuq300xwwqqhxxxxxvendor> entityList=null;
       try{
        entityList = getEntityManager()
					.createQuery(
							"select cc from Jxxxuq300xwwqqhxxxxxvendor cc where cc.lower(a0xxukxxbvxxxxxxxxxxvendor) like lower(concat('%',:nKeyName,'%'))  and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName",slike)
					.setParameter("owner2", owner2Code)
					.getResultList();
        return entityList.get(0);
       }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(), ""));


        return null;
       }
      }
    </#if>


 </#if>
 <#if (menuAttributesp2 ="89" || menuAttributesp2 ="20" ) >
	public List<${customerEntityName?cap_first}> getGroupCMembersList(int groupSid) {
          // called by getMailingList which is called by send()ie regular Emailing and preview EMailing or by getCIMailAddrList which needs instances to get names etc along with email addr 
          // filter out unsubscribed and empty email address
           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 cresults2= getEntityManager()
				.createQuery( 
						"select cc.${customerEntityName} from ${groupmembersEntityName?cap_first} cc where cc.${customerEntityName}.q4xxhxxxbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.${ownerField}=:owner  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${customerEntityName}.${cstatusFlagField} != :flag AND cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();

           }else{
		 cresults2= getEntityManager()
				.createQuery( 
						"select cc.${customerEntityName} from ${groupmembersEntityName?cap_first} cc where cc.${customerEntityName}.q4xxhxxxbv24xxxxxxxximailaddr LIKE  '%@%'  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${customerEntityName}.${cstatusFlagField} != :flag AND cc.${membersgroupEntityName}.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();
           }
        return cresults2; 
        }
     <#if (menuAttributesp2 ="20"  ) >
     // get customer with email matching, optional coupon matching
     //if 
    public Jxxxuq201xwwqqhxxxxxcustomer getEmailCouponToEntity(String email,String coupon){
     Jxxxuq201xwwqqhxxxxxcustomer entity=null;
     List<Jxxxuq201xwwqqhxxxxxcustomer> results=null;
     if(coupon.isEmpty()){
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Jxxxuq201xwwqqhxxxxxcustomer cc where cc.q4xxhxxxbv24xxxxxxxximailaddr = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",email)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("customer")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_INFO,bundle.getString("customer")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
         //return null;  allow tbd ckeck any risk???
      }
      return results.get(0);
     } 
     if(!coupon.isEmpty()){
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Jxxxuq201xwwqqhxxxxxcustomer cc where cc.q4xxhxxxbv24xxxxxxxximailaddr = :nKeyName and q5xxuxxxbxxxxxxxxxxxrmailaddr =:coupon AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",email)
	.setParameter("coupon", coupon)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("customer")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          //log it
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_INFO,bundle.getString("customer")+" "+bundle.getString("with")+" "+bundle.getString("coupon")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          return null;
      }
      return results.get(0);
     } 
     return null;
   } 

        <#if (ccontactEntityName?? && ccontactEntityName?length > eL)>
	public List<${ccontactEntityName?cap_first}> getCcontactsList(int customerSid) {
          // called by getMailingList which is called by send()ie regular Emailing and preview EMailing or by getCIMailAddrList which needs instances to get names etc along with email addr 
          // filter out unsubscribed and empty email address
           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 conresults2= getEntityManager()
				.createQuery( 
						"select cc from ${ccontactEntityName?cap_first} cc where cc.p8xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.${ownerField}=:owner  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z3xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid=:customerSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("customerSid", customerSid).setParameter("flag", mnoMail).getResultList();

           }else{
		 conresults2= getEntityManager()
				.createQuery( 
						"select cc from ${ccontactEntityName?cap_first} cc where cc.p8xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z3xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid=:customerSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("customerSid", customerSid).setParameter("flag", mnoMail).getResultList();
           }
        return conresults2; 
        }
        </#if>
     </#if>
 </#if>



 <#if (menuAttributesp2 ="89"  ) >


	public List<${employeeEntityName?cap_first}> getEIMailAddrList(Integer sid) {
          // called by EVite which sends emails to schedule participants and sid is schedule sid
          //eresults is a list of scheduleDetails instances whose master's sid matches the sid passed here
          //1. createQuery to get scheduleDetails list containing employee info if not null
          //2. call getGroupCMembersList(groupSid) to add to employee for the group if not null to eresults
          //3. call entityDetailedList how??? where ??
          <#assign employeeImailaddrField="n4xxhxxrbv24xxxxxxxximailaddr">
          int istart=0;
          int iend=99999999;
          
         
           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 eresults= getEntityManager()
				.createQuery( 
						"select e from ${employeeEntityName?cap_first} e,${scheduleDetailsEntityName?cap_first} cc where (cc.${employeeEntityName}.a0xxuobxbxxxxxxxxxxxsid=e.a0xxuobxbxxxxxxxxxxxsid) AND (e.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%')  AND (cc.${ownerField}=:owner ) AND e.${estatusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) AND (cc.${scheduleEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid)   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("flag", mnoMail).getResultList();
           }else{
		 eresults= getEntityManager()
				.createQuery( 
						"select e from ${employeeEntityName?cap_first} e,${scheduleDetailsEntityName?cap_first} cc where (cc.${employeeEntityName}.a0xxuobxbxxxxxxxxxxxsid=e.a0xxuobxbxxxxxxxxxxxsid) AND (e.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%')  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) AND e.${estatusFlagField} != :flag AND (cc.${scheduleEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid)   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("flag", mnoMail).getResultList();
           }
        //merge into one , remove dupl eresults.removeAll(eresults2)
        // schedule has group sid 
        if(${scheduleEntityName}.get${membersgroupEntityName?cap_first}()!=null){
         ${membersgroupEntityName}Home.set${membersgroupEntityName?cap_first}A0xxuobxbxxxxxxxxxxxsid(${scheduleEntityName}.get${membersgroupEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid());
	 ${membersgroupEntityName}=${membersgroupEntityName}Home.getDefinedInstance();
         if(${membersgroupEntityName} != null){
          eresults.addAll(getGroupEMembersList(${membersgroupEntityName}.getA0xxuobxbxxxxxxxxxxxsid()));
         }
        }
        return eresults; 


  }

	public List<${vendorEntityName?cap_first}> getVIMailAddrList(Integer sid) {
          // called by EVite which sends emails to schedule participants and sid is schedule sid
          //eresults is a list of scheduleDetails instances whose master's sid matches the sid passed here
          //1. createQuery to get scheduleDetails list containing vendor info if not null
          //2. call getGroupCMembersList(groupSid) to add to vendor for the group if not null to eresults
          //3. call entityDetailedList
          <#assign vendorImailaddrField="n4xxhxxrbv24xxxxxxxximailaddr">
          int istart=0;
          int iend=99999999;
          if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 vresults= getEntityManager()
				.createQuery( 
         
						"select e from ${vendorEntityName?cap_first} e,${scheduleDetailsEntityName?cap_first} cc where (cc.${vendorEntityName}.a0xxuobxbxxxxxxxxxxxsid=e.a0xxuobxbxxxxxxxxxxxsid) AND (e.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%')  AND (cc.${ownerField}=:owner ) AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) AND e.${vstatusFlagField} != :flag AND (cc.${scheduleEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid)   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("flag", mnoMail).getResultList();
           }else{
		 vresults= getEntityManager()
				.createQuery( 
						"select e from ${vendorEntityName?cap_first} e,${scheduleDetailsEntityName?cap_first} cc where (cc.${vendorEntityName}.a0xxuobxbxxxxxxxxxxxsid=e.a0xxuobxbxxxxxxxxxxxsid) AND  (e.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%')  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) AND e.${vstatusFlagField} != :flag AND (cc.${scheduleEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid)   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("flag", mnoMail).getResultList();
           }
        //merge into one , remove dupl eresults.removeAll(eresults2)
        // schedule has group sid 
        if(${scheduleEntityName}.get${membersgroupEntityName?cap_first}()!=null){
         ${membersgroupEntityName}Home.set${membersgroupEntityName?cap_first}A0xxuobxbxxxxxxxxxxxsid(${scheduleEntityName}.get${membersgroupEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid());
	 ${membersgroupEntityName}=${membersgroupEntityName}Home.getDefinedInstance();
         if(${membersgroupEntityName} != null){
          vresults.addAll(getGroupVMembersList(${membersgroupEntityName}.getA0xxuobxbxxxxxxxxxxxsid()));
         }
        }
        return vresults; 


  }

	public List<${customerEntityName?cap_first}> getCIMailAddrList(Integer sid) {
          // called by EVite which sends emails to schedule participants and sid is schedule sid
          //eresults is a list of scheduleDetails instances whose master's sid matches the sid passed here
          //1. createQuery to get scheduleDetails list containing customer info if not null
          //2. call getGroupCMembersList(groupSid) to add to customer for the group if not null to eresults
          //3. call entityDetailedList
          <#assign customerImailaddrField="q4xxhxxxbv24xxxxxxxximailaddr">
          int istart=0;
          int iend=99999999;
          if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
		 cresults= getEntityManager()
				.createQuery( 
         
						"select e from ${customerEntityName?cap_first} e,${scheduleDetailsEntityName?cap_first} cc where (cc.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid=e.a0xxuobxbxxxxxxxxxxxsid) AND (e.q4xxhxxxbv24xxxxxxxximailaddr LIKE  '%@%')  AND (cc.${ownerField}=:owner ) AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) AND e.${cstatusFlagField} != :flag  AND (cc.${scheduleEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid)   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("flag", mnoMail).getResultList();
           }else{
		 cresults= getEntityManager()
				.createQuery( 
						"select e from ${customerEntityName?cap_first} e,${scheduleDetailsEntityName?cap_first} cc where (cc.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid=e.a0xxuobxbxxxxxxxxxxxsid) AND  (e.q4xxhxxxbv24xxxxxxxximailaddr LIKE  '%@%')  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) AND e.${cstatusFlagField} != :flag  AND (cc.${scheduleEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid)   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("flag", mnoMail).getResultList();
           }
        //merge into one , remove dupl eresults.removeAll(eresults2)
        // schedule has group sid 
        if(${scheduleEntityName}.get${membersgroupEntityName?cap_first}()!=null){
         ${membersgroupEntityName}Home.set${membersgroupEntityName?cap_first}A0xxuobxbxxxxxxxxxxxsid(${scheduleEntityName}.get${membersgroupEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid());
	 ${membersgroupEntityName}=${membersgroupEntityName}Home.getDefinedInstance();
         if(${membersgroupEntityName} != null){
          cresults.addAll(getGroupCMembersList(${membersgroupEntityName}.getA0xxuobxbxxxxxxxxxxxsid()));
         }
        }
        return cresults; 


  }

</#if> 



	public List<${entityName}> getFlaggedAsList(int flag) {
		// will return objects matching flag 
       <#if statusFlagField !="Not assigned">
		return getEntityManager()
				.createQuery(
						"select cc from ${entityName} cc where (cc.${statusFlagField} = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

       <#else>
               return null; 
       </#if>
	}

	public List<${entityName}> getNotFlaggedAsList(int flag) {
		// will return objects not matching flag 

       <#if statusFlagField !="Not assigned">
		return getEntityManager()
				.createQuery(
						"select cc from ${entityName} cc where (cc.${statusFlagField} != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

       <#else>
               return null; 
       </#if>
	}

	public List<${entityName}> getOldByList(int days) {
	// will return objects statusfldt < today-days
       <#if statusFlagField !="Not assigned">
        calendar.add(Calendar.DATE, -days); //xx days in past, can check further for 15 days/7 days/ expiry
        Date searchDate= calendar.getTime();

	return getEntityManager()
	 .createQuery(
	  "select cc from ${entityName} cc where (cast(cc.${statusFlagDateField} AS date) < cast(:searchDate AS date AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
	   .setParameter("searchDate", searchDate).setParameter("owner2", owner2Code).getResultList();

       <#else>
               return null; 
       </#if>
	}


  <#if keyAutoGen=="Y"  && keyField != ""> 
   <#if keyField?substring(6,8)=="cq" || keyField?substring(6,8)=="co" || keyField?substring(6,8)=="ci" || keyField?substring(6,8)=="cp" ||  keyField?substring(6,8)=="sh"
      || keyField?substring(6,8)=="vq" || keyField?substring(6,8)=="vo" || keyField?substring(6,8)=="vi" || keyField?substring(6,8)=="vp" ||  keyField?substring(6,8)=="sv"
      || keyField?substring(6,8)=="eo" || menuAttributesp2 == "66" || menuAttributesp2 == "56" || menuAttributesp2 == "89" || menuAttributesp2 == "1A" || menuAttributesp2 == "1G">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#if keyField?substring(6,8)=="cq">
     <#assign copyFrom = "Xoxxuq2c4xwwqqhxxxxxcuqdetails">
     <#assign lineField = "z1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="co">
     <#assign copyFrom = "Xoxxuq2b4xwwqqhxxxxxcuodetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="ci">
     <#assign copyFrom = "Xoxxuq2a4xwwqqhxxxxxcuidetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="sh">
     <#assign copyFrom = "Xoxxuq295xwwqqhxxxxxshipmentdetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="cp">
     <#assign copyFrom = "Xoxxuq284xwwqqhxxxxxcupdetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="vq">
     <#assign copyFrom = "Xoxxuq3e4xwwqqhxxxxxvendqdetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="vo">
     <#assign copyFrom = "Xoxxuq3d4xwwqqhxxxxxvendodetails">
     <#assign lineField = "a1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="vi">
     <#assign copyFrom = "Xoxxuq3c4xwwqqhxxxxxvendidetails">
     <#assign lineField = "a1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="sv">
     <#assign copyFrom = "Xoxxuq399xvwwqqhxxxxvshipmendetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="vp">
     <#assign copyFrom = "Xoxxuq3b4xwwqqhxxxxxvendpdetails">
     <#assign lineField = "a1xxzo11bvlxxxxxxxxxline">
    <#elseif keyField?substring(6,8)=="eo">
     <#assign copyFrom = "Xoxxuq454xwwqqhxxxxxemplodetails">
     <#assign lineField = "b1xxzo11bvlxxxxxxxxxline">
    <#elseif menuAttributesp2 == "56">
     <#assign copyFrom = "${userproflEntityName?cap_first}">
    <#elseif menuAttributesp2 == "89">
     <#assign copyFrom = "${scheduleDetailsEntityName?cap_first}">
    <#elseif menuAttributesp2 == "1G">
     <#assign copyFrom = "${groupmembersEntityName?cap_first}">
    </#if> 
    <#if menuAttributesp2 == "1A">
     <#assign copyFrom = "${itemEntityName?cap_first}">
     public List<${copyFrom}> entityDetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${copyFrom} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("detailed")+" "+bundle.getString("list")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }
     public String itemVariantsText(Integer sid) {
       if(sid == null){
        return null;
       }
       String variants="";
       String subcodesn2 = getSidToEntity(sid).getG2xxuxn2bvxxxxxxxxxxsubcodesn2();
       String subcodesn3 = getSidToEntity(sid).getG2xxuxn3bvxxxxxxxxxxsubcodesn3();//each item label can be customized
       if(subcodesn3 !=null && subcodesn3.isEmpty()){
        subcodesn3="size   colour  materialbrand   ";//default value
       }else{
        subcodesn3=subcodesn3+"                                ";
        subcodesn3=subcodesn3.substring(0,32);
       }
       try{
        if(subcodesn2 !=null && !subcodesn2.isEmpty()){
         if(subcodesn2.length()>7){
          variants=variants+subcodesn3.substring(0,8)+": "+subcodesn2.substring(0,8)+"\u2714";
         }
         if(subcodesn2.length()>15){
          variants=variants+subcodesn3.substring(8,16)+": "+subcodesn2.substring(8,16)+"\u2714";
         }
         if(subcodesn2.length()>23){
          variants=variants+subcodesn3.substring(16,24)+": "+subcodesn2.substring(16,24)+"\u2714";
         }
         if(subcodesn2.length()>31){
          variants=variants+subcodesn3.substring(24,32)+": "+subcodesn2.substring(24,32)+"\u2714";
         }
         return variants;

        }else{
         return null;
        }
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("variants")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }
     public String itemVariantSizeText(Integer sid) {
       if(sid == null){
        return null;
       }
       String variants="";
       String subcodesn2 = getSidToEntity(sid).getG2xxuxn2bvxxxxxxxxxxsubcodesn2();
       String subcodesn3 = getSidToEntity(sid).getG2xxuxn3bvxxxxxxxxxxsubcodesn3();//each item label can be customized
       if(subcodesn3 !=null && subcodesn3.isEmpty()){
        subcodesn3="size   colour  materialbrand   ";//default value
       }else{
        subcodesn3=subcodesn3+"                                    ";
        subcodesn3=subcodesn3.substring(0,35);
       }
       try{
        if(subcodesn2 !=null && !subcodesn2.trim().isEmpty()){
         if(subcodesn2.length()>7){
          variants=variants+subcodesn3.substring(0,9)+subcodesn2.substring(0,8);
         }
         return variants;
        }else{
         return null;
        }
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("variant")+" "+bundle.getString("size")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }
     public String itemVariantColourText(Integer sid) {
       if(sid == null){
        return null;
       }
       String variants="";
       String subcodesn2 = getSidToEntity(sid).getG2xxuxn2bvxxxxxxxxxxsubcodesn2();
       String subcodesn3 = getSidToEntity(sid).getG2xxuxn3bvxxxxxxxxxxsubcodesn3();//each item label can be customized
       if(subcodesn3 !=null && subcodesn3.isEmpty()){
        subcodesn3="size    :colour  :material:brand   :";//default value
       }else{
        subcodesn3=subcodesn3+"                                    ";
        subcodesn3=subcodesn3.substring(0,35);
       }
       try{
        if(subcodesn2 !=null && !subcodesn2.trim().isEmpty()){
         if(subcodesn2.length()>7){
          variants=variants+subcodesn3.substring(9,18)+subcodesn2.substring(8,16);
         }
         return variants;
        }else{
         return null;
        }
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("variant")+" "+bundle.getString("colour")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }

     public String itemVariantMaterialText(Integer sid) {
       if(sid == null){
        return null;
       }
       String variants="";
       String subcodesn2 = getSidToEntity(sid).getG2xxuxn2bvxxxxxxxxxxsubcodesn2();
       String subcodesn3 = getSidToEntity(sid).getG2xxuxn3bvxxxxxxxxxxsubcodesn3();//each item label can be customized
       if(subcodesn3 !=null && subcodesn3.isEmpty()){
        subcodesn3="size   colour  materialbrand   ";//default value
       }else{
        subcodesn3=subcodesn3+"                                    ";
        subcodesn3=subcodesn3.substring(0,35);
       }
       try{
        if(subcodesn2 !=null && !subcodesn2.trim().isEmpty()){
         if(subcodesn2.length()>7){
          variants=variants+subcodesn3.substring(18,27)+subcodesn2.substring(16,24);
         }
         return variants;
        }else{
         return null;
        }
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("variant")+" "+bundle.getString("material")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }
     public String itemVariantBrandText(Integer sid) {
       if(sid == null){
        return null;
       }
       String variants="";
       String subcodesn2 = getSidToEntity(sid).getG2xxuxn2bvxxxxxxxxxxsubcodesn2();
       String subcodesn3 = getSidToEntity(sid).getG2xxuxn3bvxxxxxxxxxxsubcodesn3();//each item label can be customized
       if(subcodesn3 !=null && subcodesn3.isEmpty()){
        subcodesn3="size   colour  materialbrand       ";//default value
       }else{
        subcodesn3=subcodesn3+"                                    ";
        subcodesn3=subcodesn3.substring(0,35);
       }
       try{
        if(subcodesn2 !=null && !subcodesn2.trim().isEmpty()){
         if(subcodesn2.length()>7){
          int n2Len=subcodesn2.length();
          int n3Len=subcodesn3.length();
          variants=variants+subcodesn3.substring(27,n3Len)+subcodesn2.substring(24,n2Len);
         }
         return variants;
        }else{
         return null;
        }
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("variant")+" "+bundle.getString("brand")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }
    <#else> 
     <#if menuAttributesp2 == "56"  || menuAttributesp2 == "1G">
      public List<${copyFrom}> entityDetailedList(Integer sid) {
       // exclude line -1 (means deleted) userprofl(57) does not have line  groupmembers(54)
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${copyFrom} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
     <#else>
      public List<${copyFrom}> entityDetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${copyFrom} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND (cc.${lineField} > (-1)) AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
     </#if>           
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        <#if menuAttributesp2 == "56">
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("user")+" "+bundle.getString("profole")+" "+bundle.getString("list")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
        <#else>
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("detailed")+" "+bundle.getString("list")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
        </#if>
           return null;
       }
     }
    </#if>
    //key fields contd
    <#if keyField?substring(6,8)=="cq" || keyField?substring(6,8)=="co" || keyField?substring(6,8)=="ci" || keyField?substring(6,8)=="cp" ||  keyField?substring(6,8)=="sh"
      || keyField?substring(6,8)=="vq" || keyField?substring(6,8)=="vo" || keyField?substring(6,8)=="vi" || keyField?substring(6,8)=="vp" ||  keyField?substring(6,8)=="sv"
      || keyField?substring(6,8)=="eo" || menuAttributesp2?contains("89") || menuAttributesp2?contains("36") >
    <#if keyField?substring(6,8)=="vo">
      /***
      * called by Home generateOrders() to check any order exists for this item and if so return vendor
      * to be used for reorder
      * parm1 is low stock Item sid
      */
      public List<Trexuq344xwwqqhxxxxxvendorders> getAnyVoVendorForItemSid(Integer sid){
       List<Trexuq344xwwqqhxxxxxvendorders> entities=null;
       try{
        entities = getEntityManager()
					.createQuery(
					 "select cc from Trexuq344xwwqqhxxxxxvendorders cc where cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :nKeyName and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName",sid)
					.setParameter("owner2", owner2Code)
					.getResultList();
        return entities;
       }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("${vendordersEntityName?substring(eL)}")+" "+bundle.getString("list")+" "+bundle.getString("error")+" "+e.getMessage(), ""));

        return null;
       }
      }

      /***
      * called by Home generateOrders() to avoid reorder in case open order for this item exists
      * there can be same item but diff vendors
      */
      public List<Trexuq344xwwqqhxxxxxvendorders> getToVoForItemSid(Integer sid){
       List<Trexuq344xwwqqhxxxxxvendorders> entities=null;
       try{
        entities = getEntityManager()
					.createQuery(
					 "select cc from Trexuq344xwwqqhxxxxxvendorders cc where cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :nKeyName and z5xxzzfxhhxxxxxxxxxxstatusfl != :flag and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName",sid)
					.setParameter("owner2", owner2Code)
					.setParameter("flag", mclosed)
					.getResultList();
        return entities;
       }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("${vendordersEntityName?substring(eL)}")+" "+bundle.getString("list")+" "+bundle.getString("error")+" "+e.getMessage(), ""));

        return null;
       }
      }

      /***
      * called by Home generateOrders() to avoid reorder in case open order for this item exists
      * there can be same item but diff vendors
      */
      public Integer getCountItemsToOrder(){
       Integer count=0;
       BigDecimal toOrderQty=new BigDecimal("0.0");

       try{
                List<${itemEntityName?cap_first}> sresults= new ArrayList<${itemEntityName?cap_first}>();
		sresults= getEntityManager()
				.createQuery(
				 "select cc from ${itemEntityName?cap_first} cc where (cc.b0xxziqxlvxxsaxxxxxxquantity < cc.c4fbzxxxbvxxxxxxxxxxqtylevel1 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				  .setParameter("owner2", owner2Code).getResultList();
        for (${itemEntityName?cap_first} item : sresults){
         //query open vendor orders for this item, orders can be with different vendors
         // or no current order exists 
         toOrderQty=item.getB0xxziqxlvxxsaxxxxxxquantity().abs();
         for (Trexuq344xwwqqhxxxxxvendorders order : this.getToVoForItemSid(item.getA0xxuobxbxxxxxxxxxxxsid()) ){
          if(order !=null){
           toOrderQty=toOrderQty.subtract(order.getZ3xxztqrlxxxxxxxxxxxqtytotal());
           if( toOrderQty.compareTo(new BigDecimal("0.0"))  > 0 ){
            count=count+Integer.valueOf(toOrderQty.intValue());
           }
          }else{
            count=count+1;
          }
         }
        }
       } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR, bundle.getString("reorder")+" "+bundle.getString("list")+" "+bundle.getString("error")+" "+ e.getMessage(),""));
       }
       return count;

      }


    </#if>
     // needed to support delete status rather than removed child (had difficulty plus may be better this way
     // using line because details dont have status fields. line -1 means removed can test for <0 status value
     //  used by txns and schedule, added check for null value for status/line      
     //  po sid is passed as param. Since details store this sid in xxxNo and gets its own sid, compare sid int to xxxNo int field 
     public List<${copyFrom}> entityLessStatusDetailedList(Integer sid,int status) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${copyFrom} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid and (cc.${lineField} is NULL or cc.${lineField} != :s) AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).setParameter("s", status).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("detailed")+" "+bundle.getString("statused")+" "+bundle.getString("list")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }
    </#if> 
   </#if>
  </#if>



   <#if keyField != "">
    <#if (menuAttributesp2?contains("25") ) >
     public ${entityName} getOrderSidToEntity(Integer sid){
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from ${entityName} cc where cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid = :nSid and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	.setParameter("nSid",sid)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 
    </#if>

    <#if menuAttributesp2 == "56" >//user only may have id as emailxx
     public Yxxxuh566xwwqqwxxxxxuser getKeyToEntity(String key){
      Yxxxuh566xwwqqwxxxxxuser entity=null;
      List<Yxxxuh566xwwqqwxxxxxuser> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Yxxxuh566xwwqqwxxxxxuser cc where cc.a0xxukuxbvxxxxxxxxxxid like lower(concat(:nKeyName,'%'))  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("user")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("user")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          customIdentity.setHoldValue3(""+results.size());//caller may examine this

      }
      return results.get(0);

    } 


    <#else> 
     public ${entityName} getKeyToEntity(String key){
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from ${entityName} cc where cc.${keyField} = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+" "+bundle.getString("found"),""));
          // end user may see it,FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          // FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          customIdentity.setHoldValue3(""+results.size());//caller may examine this
      }
      return results.get(0);

    } 

    </#if> 

     public ${entityName} getKeyContainsToEntity(String key){
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from ${entityName} cc where cc.${keyField} like :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key+'%')
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 





     //keyValue is called in dataTable and avoids having to implement eagerloading in getresultList
     // key passed is the record key ie sid and return the natural key value
     public String getKeyValue(Integer key) {
     if(key == null || key == 0){
      return null;
     }
     try{
      String value= getEntityManager().createQuery(" select ${keyField} from ${entityName} cc where cc.${ids1?lower_case} = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${ids1?lower_case}  ")
        				.setParameter("keyOfEntity", key).setParameter("owner2", owner2Code)
					.getSingleResult().toString();

       return value;
      }
      catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(), ""));

       return null;
      }
     }

      <#if menuAttributesp2 == "20" || menuAttributesp2 == "30" || menuAttributesp2 == "40" > 
     // key passed is the record key ie sid and return the email+companyname+lastname+firstname value
     // to be called if entity is customer,vendor or employee

     public String getKeyDemographValue(Integer key) {
     if(key == null || key == 0){
      return null;
     }
     try{
      <#if menuAttributesp2 == "20"> 
      ${entityName} cc=getSidToEntity(key);
      String value1=cc.getQ4xxhxxxbv24xxxxxxxximailaddr()==null?"":cc.getQ4xxhxxxbv24xxxxxxxximailaddr()+",";
      String value2=cc.getD1xxu3cnbvixxxxxxxxxcustomerascompanyname()==null?"":cc.getD1xxu3cnbvixxxxxxxxxcustomerascompanyname()+" ";
      String value3=cc.getC1xxuslnbvixxxxxxxxxlastname()==null?"":cc.getC1xxuslnbvixxxxxxxxxlastname()+" ";
      String value4=cc.getC2xxu2fnbvixxxxxxxxxfirstname()==null?"":cc.getC2xxu2fnbvixxxxxxxxxfirstname();
      String value=value1+value2+value3+value4;

      <#elseif menuAttributesp2 == "30">
      ${entityName} cc=getSidToEntity(key);
      String value1=cc.getN4xxhxxrbv24xxxxxxxximailaddr()==null?"":cc.getN4xxhxxrbv24xxxxxxxximailaddr()+",";
      String value2=cc.getD1xxu3cnbvxxxxxxxxxxvendorascompanyname()==null?"":cc.getD1xxu3cnbvxxxxxxxxxxvendorascompanyname()+" ";
      String value3=cc.getB3xxuslnbvxxxxxxxxxxlastname()==null?"":cc.getB3xxuslnbvxxxxxxxxxxlastname()+" ";
      String value4=cc.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":cc.getB4xxu2fnbvxxxxxxxxxxfirstname();
      String value=value1+value2+value3+value4;
      <#else>
      ${entityName} cc=getSidToEntity(key);
      String value1=cc.getN4xxhxxrbv24xxxxxxxximailaddr()==null?"":cc.getN4xxhxxrbv24xxxxxxxximailaddr()+",";
      String value3=cc.getB3xxuslnbvixxxxxxxxxlastname()==null?"":cc.getB3xxuslnbvixxxxxxxxxlastname()+" ";
      String value4=cc.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":cc.getB4xxu2fnbvxxxxxxxxxxfirstname();
      String value=value1+value3+value4;
      </#if>

       return value;
      }
      catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(), ""));

       return null;
      }
     }
    </#if> 

     public String getKeyOwner2Value(Integer key) {
     if(key == null || key == 0){
      return null;
     }
     try{
      String value= getEntityManager().createQuery(" select ${keyField}||'/'||zzxxu2oxxhxxxxxxxxxxowner2 from ${entityName} cc where cc.${ids1?lower_case} = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${ids1?lower_case}  ")
        				.setParameter("keyOfEntity", key).setParameter("owner2", owner2Code)
					.getSingleResult().toString();

       return value;
      }
      catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(), ""));

       return null;
      }
     }
     // suggest is called when only key values are needed and should be faster
     public ArrayList<String> suggest(String input) {
      String userInput = (String) input;
      if (userInput == "*" || userInput == null ){
       //allow digits
       userInput="0";
      }
      if (userInput == "email" ){
       userInput="0";
      }
      ArrayList<String> ret = new ArrayList<String>();
 
      for (${entityName} ${entityName?lower_case} : getSuggestList(userInput)) {
       <#if keyFieldType?contains("tring")>
         ret.add(${entityName?lower_case}.get${keyField?cap_first}());
       <#else>
        //if (${entityName?lower_case}.get${keyField?cap_first}() >= Integer.valueOf(userInput) ) {
         ret.add(""+${entityName?lower_case}.get${keyField?cap_first}());
       </#if>
       //}
      }
     if (!ret.isEmpty()){
     Collections.sort(ret,String.CASE_INSENSITIVE_ORDER);
     // set start/end
     start=ret.get(0);
     end=ret.get(ret.size()-1); 
     }
     return ret;
    }
     // overdrive getSuggestList if type field is present
     // not used because cannot pass hideTypePrefix needs testing, instead getSuggestList has added logic for hide
     // based on entity type
     public List<${entityName}> getSuggestList(String prefix,String hideTypePrefix) {
     // getSuggestList is called when non key values are also needed like item key, its price etc 
     // when is keyfield blank probably never for keyAutogen
     
        <#if keyAutoGen=="Y" && statusFlagField !="Not assigned">
          <#if keyField == "">
		     Integer nenteredValue = 0;
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${ids1?lower_case} >=:keyOfEntity AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix ) AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${ids1?lower_case}  ")
        				.setParameter("keyOfEntity", nenteredValue).setParameter("owner2", owner2Code)
					.getResultList();
          <#else>
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity  AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix )  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
          </#if>
        <#else>
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.id.${ids1?lower_case} >=:keyOfEntity AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix )  AND cc.id.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField} ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
        </#if>
	}
   <#else>
    //no keyField but Sid is allways there 
     public ArrayList<Integer> suggest(Integer input) {
      ArrayList<Integer> ret = new ArrayList<Integer>();
      for (${entityName} ${entityName?lower_case} : getNextSids(input)) {
         ret.add(${entityName?lower_case}.getA0xxuobxbxxxxxxxxxxxsid());
      }
      return ret;
     }
   </#if> 
   

     <#if menuAttributesp2?contains("1M")>
     public int getSiteCustommizationsDone(){
                int netCount =0;
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName}  cc where cc.${statusFlagField} != :flag AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 AND a1xxuxxxbv49xxxxxxxxfromkey like '3R-%-C' AND a2xxuxxxbv50xxxxxxxxqualifier = 'TXT' ")
					.setParameter("owner2", owner2Code).setParameter("flag", mclosed)
					.getSingleResult();
                netCount=count.intValue();
                return netCount;
     }


     public int getSitePolicyDone(){
                int netCount =0;
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from ${entityName}  cc where cc.${statusFlagField} != :flag AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 AND a1xxuxxxbv49xxxxxxxxfromkey = '3R-LEGAL_NOTICE-1-C' AND a1xxuxxxbv49xxxxxxxxfromkey = '3R-RETURNS_POLICY-1-C' AND a1xxuxxxbv49xxxxxxxxfromkey = '3R-PRIVACY_POLICY-1-C' AND a2xxuxxxbv50xxxxxxxxqualifier = 'TXT' ")
					.setParameter("owner2", owner2Code).setParameter("flag", mclosed)
					.getSingleResult();
                netCount=count.intValue();
                return netCount;

     }



     </#if>



     <#if menuAttributesp2?contains("1A")>
        /***
        * used by mydashboard to show item needing publish review
        * get fromkey from clobdata preadd prefix (assume B) and call this method
        */

     public ${itemEntityName?cap_first} getDocmntWPrefixToEntity(String docmnt){
      if(docmnt == null || docmnt.isEmpty()){
       return null;
      }
      ${itemEntityName?cap_first} entity=null;
      List<${itemEntityName?cap_first}> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from ${itemEntityName?cap_first} cc where cc.w8xxuzdrbvxxxxxxxxxxdocmnt = :sDocmnt and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("sDocmnt",docmnt)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${itemEntityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${itemEntityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+", "+docmnt,""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used"), ""));
      }
      return results.get(0);

     } 

        /***
        * assumes aliascode in Item has ApplicationFunction (client prodcode) value like fsot or eege or ee
        * manually add code in items meant for raaspi subscription, better put a warning if raaspi,SI-D and 
        * alias code is empty
        */
        public Integer clientApplicationFunctionToSid(String key){
         ${componentName}=null;
	 List<${componentName?cap_first}> results =  getEntityManager()
	 .createQuery("select cc from ${componentName?cap_first} cc where cc.f1xxuxxrbvxxxxxxxxxxaliascode = :Key AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  ${statusFlagDateField}")
         .setParameter("owner2", owner2Code)
         .setParameter("Key", key).getResultList();
         if(!results.isEmpty()){
          ${componentName} = results.get(0);
          return ${componentName}.getA0xxuobxbxxxxxxxxxxxsid();
         }else{
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO, bundle.getString("No")+" "+bundle.getString("matching")+" "+bundle.getString("entry")+" "+bundle.getString("found")+", "+bundle.getString("please")+" "+bundle.getString("go")+" "+bundle.getString("to")+" "+bundle.getString("shopping")+" "+bundle.getString("items")+" "+bundle.getString("and")+" "+bundle.getString("select")+" "+bundle.getString("manually"),""));

          return 0;
         }
   
        }

        public String getThemeSearchedList(String st) {
       // called by home page find search as action method and string return value will reload
                // the page itemdetailsBrowse or IssuedetailsBrowse
                // sresults is used to hold search results
                // param t is for theme selects see getSearchedList for other params
          String sresults="";
          ${itemEntityName?cap_first} item=null;
          searchPattern=searchPattern.trim();
          String[] myData = searchPattern.split(", ");
          String matCode=null;
          try{
           if (st.equals("t")){
            //seach selectItem list for a match
            Iterator<${itemEntityName?cap_first}> itr = getSuggestListTheme("","").iterator();
            while (itr.hasNext()) {
              item=itr.next();
              for (String s: myData) {
               if(item.getB1xxuszsbvxxxxxxxxxxdescript().toLowerCase().contains(s)){
                sresults=sresults+item.getB1xxuszsbvxxxxxxxxxxdescript()+", ";
                matCode=item.getA0xxukixbxxxxxxxxxxxmatcode();//last of the matching
               }
              }
            } 
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty")+", "+bundle.getString("retry")+" "+bundle.getString("with")+" "+bundle.getString("multiple")+" "+bundle.getString("keywords"),""));
                 searchPattern="xy xz";
                 return "";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("suggest")+" "+bundle.getString("select")+" "+sresults,""));

                 if(matCode !=null){
                  yxxxuh566xwwqqwxxxxxuserHome.setClientApplicationFunction(matCode);
                 }else{
                 }
                 searchPattern="xyz..";
                 return "";
            }
           }
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("call")+" "+bundle.getString("invalid")+" "+st,""));
           searchPattern="xyz..";
           return "";

         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("search")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
           searchPattern="xyz..";
          return "";
         }
       }


     public int getVistorOptionsDone(){
                int netCount =0;
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName}  cc where cc.${statusFlagField} != :flag AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 AND c6xxusxrbv16xxxxxxxxtype = 'SI-L1' ")
		.setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		.getSingleResult();
                if(count > 0){
                 netCount=1;
                }
		count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from ${entityName}  cc where cc.${statusFlagField} != :flag AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 AND c6xxusxrbv16xxxxxxxxtype = 'IB' ")
		.setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		.getSingleResult();
                if(count > 0){
                 netCount=netCount+1;
                }

                

                return netCount;
     }





    /**
    * populates select list for vendor themes , return all themes or for specified vendor.
    * these are shopping items (SI-D) but misccode2 has theme names and they exist in raaspi site only. 
    * subcodesn has 'TH' ???
    * Theme vendors are users of raaspi site.
    * @param args -String vendor and String Theme but partameter theme is for now ignored.
    * @return  type List of items which holds theme names in misccode2 and vendor name in misccode1 if vendor is specified
    * @exception runtime error
    * @see 
    */
	public List<${entityName}> getSuggestListTheme(String vendor,String theme) {
                //returns item type SI-D and misccode2 matching parameter theme
                // returned item records have theme vendor code in misccode1 
                // for now parameter vendor ignored, add logic to use vendor/theme and return all items if needed 
                // returns SI-L1 if vendor is C
                   if(vendor.isEmpty() && !theme.isEmpty()){ 
                       if(theme.equals("1")){
                        theme="%/Business"; 
                    return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
                    .setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
                    .getResultList();
                   }
                       if(theme.equals("2")){
                        theme="%/ERP"; 
			 return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("3")){
                        theme="%/Laboratory"; 
			 return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("45")){
                        theme="%/Organization"; 
			 return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("67")){
                        theme="%/Agency"; 
			 return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("89")){
                        theme="%/News Forum"; 
                        String theme2="%/Users Forum";
			 return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE :theme2 or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme).setParameter("theme2", theme2)
					.getResultList();
                        }

			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} != :flag AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :theme) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                   }
                   if(vendor.isEmpty() && theme.isEmpty()){
             
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} != :flag AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
					.getResultList();
                   }

                   if(!vendor.isEmpty() && theme.isEmpty()){
                      if(vendor.equals("C")){
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} != :flag AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='')  AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' ) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-L1' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
					.getResultList();
                      }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} != :flag AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :vendor AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' ) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("vendor", vendor)
					.getResultList();
                      }
                   }
                   if(!vendor.isEmpty() && !theme.isEmpty()){
             
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${statusFlagField} != :flag AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :vendor) AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :theme) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme).setParameter("vendor", vendor)
					.getResultList();
                   }
                   return null;
        }

     </#if>

     <#if menuAttributesp2?contains("30")>
    /**  do not use this, instead use one list only ie theme list but sorted by vendor
    * populates select list for theme vendors, only vendor type "TH" are shown.
    * @param args -String vendor and String Theme but both are ignored
    * @return  type List of vendors 
    * @exception runtime error
    * @see 
    */

      public List<${entityName}> getSuggestListThemeVendor(String vendor,String theme) {
         //vendor type is TV ie theme vendor as opposed to normal value CL corporation large or CS small etc
         // for now parameter vendor and theme ignored, add logic to use vendor/theme and return all items if needed
         try{
            return getEntityManager().createQuery(" select cc from ${vendorEntityName?cap_first} cc where cc.${statusFlagField} != :flag AND cc.y5xxuxxrbv29xxxxxxxxtype = 'TV'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.${keyField}  ")
            .setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
             .getResultList();
         } catch ( Exception e){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("vendor")+" "+bundle.getString("list")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
           return Collections.emptyList();
         }
        }
     </#if>
     <#if menuAttributesp2?contains("59")>
        //
     public Yxxxuq591xwwqqhxxxxxrate1f getRaaspiIncentiveToEntity(String key,String incentive){
      // key is usertype PC,DC etc and incentive holds productCode or coupon name
      Yxxxuq591xwwqqhxxxxxrate1f entity=null;
      incentive=incentive.toLowerCase();// for lower need to use like not =
      List<Yxxxuq591xwwqqhxxxxxrate1f> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	 "select cc from Yxxxuq591xwwqqhxxxxxrate1f cc where cc.a0xxukxxbvxxxxxxxxxxusertype = :nKeyName and (lower(h3xxuxxrbvxxxxxxxxxxincentive) like :incentive ) and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	 .setParameter("nKeyName",key)
	 .setParameter("incentive", incentive)
 	 .setParameter("owner2", masterSiteCode)
	 .getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("rate1f")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_INFO,bundle.getString("rate1f")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 



     public ${entityName} getKeyStepToEntity(String key,String stepName){
      // usertype and stepName
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	 "select cc from ${entityName} cc where cc.${keyField} = :nKeyName and (b2xxuxxrbv51xxxxxxxxstepname=:stepName ) and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	 .setParameter("nKeyName",key)
	 .setParameter("stepName", stepName)
 	 .setParameter("owner2", owner2Code)
	 .getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 

        

        public BigDecimal getCouponCodeValue(String itemKey){
         String couponId=fpxxfq1a5xwwqqhxxxxxitemHome.getCouponCode().toLowerCase();//entered in cart 
         for (Yxxxuq591xwwqqhxxxxxrate1f entry : this.getSuggestList("DC")){

          if(entry.getB2xxuxxrbv51xxxxxxxxstepname().equals("ANY") && entry.getH3xxuxxrbvxxxxxxxxxxincentive().toLowerCase().equals(couponId)
              && calendar.getTime().after(entry.getH1xxcxxrbvxxxxxxxxxxeffdate()) && calendar.getTime().before(entry.getH2xxcxxrbvxxxxxxxxxxenddate())){
           return entry.getB4xxcxxrbvxxxxxxxxxxvalue();
          } //stepName can be 25ch or less
          String itemKeyR="";
          if(itemKey.length() >25){
           itemKeyR=itemKey.substring(0,25);
          }else{
           itemKeyR=itemKey;//taken care of ANY
          }
          if(entry.getB2xxuxxrbv51xxxxxxxxstepname().equals(itemKeyR) && entry.getH3xxuxxrbvxxxxxxxxxxincentive().toLowerCase().equals(couponId)
              && calendar.getTime().after(entry.getH1xxcxxrbvxxxxxxxxxxeffdate()) && calendar.getTime().before(entry.getH2xxcxxrbvxxxxxxxxxxenddate())){
           return entry.getB4xxcxxrbvxxxxxxxxxxvalue();
          } 
         }
         if(couponId !=null && !couponId.isEmpty()){ 
          //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          // FacesMessage.SEVERITY_WARN,bundle.getString("no")+" "+bundle.getString("coupon")+" "+bundle.getString("match")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+couponId,""));
         }
         return BigDecimal.ZERO;// bad code or does not exist or not entered, multiple msgs here. now msg in calling method
        }

        public String getCouponCodeValueType(String itemKey){
         String couponId=fpxxfq1a5xwwqqhxxxxxitemHome.getCouponCode().toLowerCase();//entered in cart 
         for (Yxxxuq591xwwqqhxxxxxrate1f entry : this.getSuggestList("DC")){

          if(entry.getB2xxuxxrbv51xxxxxxxxstepname().equals("ANY") && entry.getH3xxuxxrbvxxxxxxxxxxincentive().toLowerCase().equals(couponId)
              && calendar.getTime().after(entry.getH1xxcxxrbvxxxxxxxxxxeffdate()) && calendar.getTime().before(entry.getH2xxcxxrbvxxxxxxxxxxenddate())){
           return entry.getA0xxukxxbvxxxxxxxxxxusertype();
          } //stepName can be 25ch or less
          String itemKeyR="";
          if(itemKey.length() >25){
           itemKeyR=itemKey.substring(0,25);
          }else{
           itemKeyR=itemKey;//taken care of ANY
          }

          if(entry.getB2xxuxxrbv51xxxxxxxxstepname().equals(itemKeyR) && entry.getH3xxuxxrbvxxxxxxxxxxincentive().toLowerCase().equals(couponId)
              && calendar.getTime().after(entry.getH1xxcxxrbvxxxxxxxxxxeffdate()) && calendar.getTime().before(entry.getH2xxcxxrbvxxxxxxxxxxenddate())){
           return entry.getA0xxukxxbvxxxxxxxxxxusertype();
          } 
         }
         if(couponId !=null && !couponId.isEmpty()){ 
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_WARN,bundle.getString("no")+" "+bundle.getString("coupon")+" "+bundle.getString("match")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+couponId,""));
         }
         return "";// bad code or does not exist or not entered

        }
        public Boolean getCouponCodeExists(String itemKey){
         for (Yxxxuq591xwwqqhxxxxxrate1f entry : this.getSuggestList("DC")){

          if(entry.getB2xxuxxrbv51xxxxxxxxstepname().equals("ANY") 
              && calendar.getTime().after(entry.getH1xxcxxrbvxxxxxxxxxxeffdate()) && calendar.getTime().before(entry.getH2xxcxxrbvxxxxxxxxxxenddate())){
           return true;
          } //stepName can be 25ch or less
          String itemKeyR="";
          if(itemKey.length() >25){
           itemKeyR=itemKey.substring(0,25);
          }else{
           itemKeyR=itemKey;//taken care of ANY
          }
          if(entry.getB2xxuxxrbv51xxxxxxxxstepname().equals(itemKeyR) 
              && calendar.getTime().after(entry.getH1xxcxxrbvxxxxxxxxxxeffdate()) && calendar.getTime().before(entry.getH2xxcxxrbvxxxxxxxxxxenddate())){
           return true;
          } 
         }
         return false;// no matching coupon exists for this site
        }

      public BigDecimal getCODCharge(${itemEntityName?cap_first} ${itemEntityName}){
       String shipSubCode="";
       if (${itemEntityName} == null){
        shipSubCode="CM";//C(OD+size medium meant for one charge for a COD order
       }else{
        String iShipCode="";//size of item
        if (${itemEntityName}.getC3fbuxscbvxxxxxxxxxxshipcode().isEmpty()){
         iShipCode="S";//small size
        }else{
         iShipCode=${itemEntityName}.getC3fbuxscbvxxxxxxxxxxshipcode().length()>1?${itemEntityName}.getC3fbuxscbvxxxxxxxxxxshipcode().substring(1,2):"S";// size is the 2nd ch from left
         if(iShipCode.equals("X")){
          iShipCode="S";//small
         }
        } 
       shipSubCode="C"+iShipCode;//C(OD+size
       }
         try {
                ${rate1fEntityName?cap_first} ${rate1fEntityName} =null;
			List<${rate1fEntityName?cap_first}> results =  entityManager
					.createQuery("select cc from ${rate1fEntityName?cap_first} cc where cc.a0xxukxxbvxxxxxxxxxxusertype=:useCode  and b1xxuxxrbvxxxxxxxxxxprodtype=:usageIn and b2xxuxxrbv51xxxxxxxxstepname=:useSubCode and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("useCode", "CS")
					.setParameter("usageIn", "P")
					.setParameter("useSubCode", shipSubCode)
                                        .setParameter("owner2", owner2Code)
					.getResultList();
                           if(!results.isEmpty()){
                            ${rate1fEntityName} = results.get(0);
                             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                             FacesMessage.SEVERITY_INFO,bundle.getString("Applicable")+" "+bundle.getString("COD")+" "+bundle.getString("charge")+" "+yxxxuq591xwwqqhxxxxxrate1f.getB4xxcxxrbvxxxxxxxxxxvalue().toString()+" "+bundle.getString("added"),""));
                            return yxxxuq591xwwqqhxxxxxrate1f.getB4xxcxxrbvxxxxxxxxxxvalue();// value will go into instance
                           }
                           else{
                            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                             //FacesMessage.SEVERITY_ERROR,bundle.getString("Default")+" "+bundle.getString("10.00")+" "+bundle.getString("used")+" "+bundle.getString("as")+" "+bundle.getString("COD")+" "+bundle.getString("charge")+", "+bundle.getString("COD")+" "+bundle.getString("rate")+" "+bundle.getString("entry")+" "+bundle.getString("stepName")+" "+shipSubCode+" "+bundle.getString("not")+" "+bundle.getString("found"),""));
                            bcontinue=true;
                            return new BigDecimal("0.0");// fall back value, form not shown if no entry but paypal calls this
                           }

       } catch (Exception ex) {
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
               FacesMessage.SEVERITY_ERROR,bundle.getString("COD")+" "+bundle.getString("charge")+", "+bundle.getString("rate")+" "+" "+bundle.getString("entry")+" "+bundle.getString("stepName")+" "+shipSubCode+" "+bundle.getString("read")+" "+bundle.getString("error")+" "+ex.getMessage(),""));
          bcontinue=false;
          return new BigDecimal("0.0");// default is 0 if no entry in rate table

       }
     }



     </#if>
	public List<${entityName}> getSystemSuggestList(String prefix) {
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                return null;

        }
    <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
        public DualListModel<${entityName}> getToDualSuggestList() {
         return toDualSuggestList;
        }

        public void setToDualSuggestList(DualListModel<${entityName}> toDualSuggestList) {
         this.toDualSuggestList = toDualSuggestList;
        }

        <#if (menuAttributesp2="40" ) >
         public DualListModel<${entityName}> getCcDualSuggestListE() {
           return ccDualSuggestListE;
         }
         public void setCcDualSuggestListE(DualListModel<${entityName}> ccDualSuggestListE) {
          this.ccDualSuggestListE = ccDualSuggestListE; 
         }
        </#if>

    </#if>

     public List<${entityName}> getSuggestList(String prefix) {
     // getSuggestList is called when whole object is needed ie non key values are also needed like item key, its price etc 
     // when is keyfield blank probably never for keyAutogen
     // getflaggesaslist also gets a list based on status field value (only one status value)
     // if item hide certain types or account show prefix 3 or A or 3
     // if item prefix "O" show if status Ordered (value 1)
     // if item prefix "I" show if status Invoiced (value 64)
     // if item prefix "IP" show if status Invoiced (value 64) and shiptype 1st ch is P ie PickUp , used by cartPOS
     // if item prefix "P" show if status Paid (value 16)
     // if item prefix "S" show if status Shipped (value 32)
     // if item,usagebyperiods etc prefix "NC" show if status not closed (value != 8)
     // added NC for txns 
     // if cob or cqb applies to quote or ordrs falls into other so like NC all not closed
     // closed entities are excluded
     // if item prefix is LT- (lab test) show only types LT- and change prefix to 0
     // for report we need prefix * to allow selecting any record ignoring flag but cntent controlled by searchStatus
     // ex orders may get closed but we may want to see data
     // if eagerLoading is to be added use select yxxxuq1r1xwwqqhxxxxxresource from Yxxxuq1r1xwwqqhxxxxxresource yxxxuq1r1xwwqqhxxxxxresource join fetch
     //   yxxxuq1r1xwwqqhxxxxxresource.yxxxuq1l1xwwqqhxxxxxresource_bundle
     // added prefix "MY" to return own emplorders for todo list
     // added prefix "LH" to return statusflupdate in last hour
     //BackOffice txn flow as follows
     // usage chart for xxedit.quoteorderexists.xhtlml for select list via suggestlist(prefix) for copy and convert
     // Order Processing 3 options
     // (1) BackOffice merchant entries for customer phone,email request or corporate purchase orders 
     // Flow >>Quote-            >>order               >> Shipment                 >>invoice               >> payment
     //          |Fn:23 pkey:cq |Fn:24 pkey:cq  |Fn:25 pkey:co              |Fn:26 pkey:co       |Fn:27 pkey:ci             |
     //          |quote to quote | quote to order | order to shipment      | order to invoice   | invoice to payment
     //          |make status 0 | make status 8 | make status 32          | make status 64   |  failed
     //          |/open after      | /closed             |/shipped                       | /invoiced             | 
     //          |copy                 | after copy         |after copy                     | after copy            |
    //           |cq/23               |cq/23                |co/24                              |co/24                    |ci/26
    //cu       |NCNINP not    |NCNINP not       |OPTNS orderd+paid    |NCNINP not          |NCI not 
    //           |closd,inv,paid |closd,inv,paid   | +terms paid +toPay+  | closd,inv,paid       |closd,inv
    //           |                         |                           | not shipped                  |                                |
    //          |Fn:33 pkey:vq |Fn:34 pkey:vq  |Fn:37 pkey:vo                |Fn:3a pkey:vo       |Fn:38 pkey:vi
    //           |vq/33               |vq/33                |vo/34                             |vo/34                     |vi/3A
    //vend   |same               |same                 |OPNS ordrd+paid         |same                       |same
    //           |                         |                           |+not shipped                 |                                |    
    //(2) cartCheckOut flow as follows-customer online entry via website or phone apps
     // Flow >>>order              >>invoice             >>picklist pick                >> Shipment                 >>> payment capture
     //                                      (payment auth)      
     //          |                         |                           |Optional Orders            |                                       |
    //           |                         |                           | PickList by Location   |                                       |
     //          |cartItem          |Checkout           | BackOffce                    |BackOffce                     | BackOffce                    |
     //          |                         |                           |Shipment for pickup or| Shipment                     | Capture payment
     //          |make status 1| keep status 1  | delivery status 2           | make po status 64     |  
     //          |/active             | /active             |/picked                            | /invoiced                    | 
     //          |                         | terms ToPay   |                                        | after copy                    | make po 16/paid
    //           |                         | and PickUp,     |co/24                              |co/24                            |ci/26
    //           |                         | Delivery                          |                                        |
    //           |                         |
    //           |                         |
    //           |                         | terms Paid      |
    //           |                         | and PickUp,     |
    //           |                         | Delivery            |
    //           |                         |Order,Invoice,
    //           |                         | Paymnt recrds|
    //           |                         | shipment not
    //           |                         |
    //           |                         |
    //cu       |NCNINP not    |NCNINP not       |OPTNS orderd+paid    |NCNINP not          |NCI not 
    //           |closd,inv,paid |closd,inv,paid   | +terms paid +toPay+  | closd,inv,paid       |closd,inv
    //           |                         |                           | not shipped                  |                                |
   //(3)cartPOS flow as follows- at store Merchant entry for in Person customer
   // Flow >>>>order              >>>invoice  
   //                                          Shipment
   //                                            Payment 
     //          |                         |                           |
    //           |                         |                           |  
     //          |cartPOS           |Checkout POS  |                    |
     //          |                         |                           |
     //          |make status 1|  status 16        |   
     //          |/active             | /paid                | 
     //          |                         |                          |
    //           |                         |                          |
    //cu       |NCNINP not    |                          | 
    //           |closd,inv,paid |                          |
    //           |                         |                          |
   //(3)cartPOS shortcut buttons at bottom
   //            |Accept Pamnt|Pay on PickUp |Pay on Deliv  |PrePaid PickUp | PrePaid Deliv | BackOffice Orders|
   //            | IP                    | COP                  | POD               |PP                       | PD                   |MY
   //(4)shipmentEdit.quotreOrderExists  Tab for cuorders
   //            |Accept Pamnt|Pay on PickUp |Pay on Deliv  |PrePaid PickUp | PrePaid Deliv | BackOffice Orders|
   //            | IP                    | COP                  | POD               |PP                       | PD                   |MY

 
        <#if keyAutoGen=="Y"> 
          <#if keyField == "" && statusFlagField !="Not assigned">
		     Integer nenteredValue = 0;
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${ids1?lower_case} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${ids1?lower_case}  ")
        				.setParameter("keyOfEntity", nenteredValue).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
          <#else>
              <#if menuAttributesp2 == "56">
               if(prefix.equals("LH")){
                        // user, allow digits and alpha but no closed for owner, remove 56 once start usig fieldName
                        prefix="0";
                        Date lastHour= new Date(System.currentTimeMillis() - 3600 * 1000);
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.z2xxcztxlxxxxxxxxxxxstatusfldt>=:lastHour  order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("lastHour", lastHour)
					.getResultList();
               }
              </#if>
              <#if menuAttributesp2 == "23" || menuAttributesp2=="24" || menuAttributesp2=="25"   || menuAttributesp2=="26" || menuAttributesp2=="27" || menuAttributesp2=="33" || menuAttributesp2=="34" || menuAttributesp2=="3A"   || menuAttributesp2=="37" || menuAttributesp2=="38" || menuAttributesp2=="36" || menuAttributesp2=="44" > 
               <#if menuAttributesp2 == "23" || menuAttributesp2=="24" || menuAttributesp2=="33" || menuAttributesp2=="34" > 
               if(prefix.equals("NCNINP")){
                        // quote,orders  , allow digits and alpha but not closed and  not paid and not invoiced
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc  where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag  AND cc.${statusFlagField} != :flag2 AND cc.${statusFlagField} != :flag3 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mpaid).setParameter("flag3", minvoiced).setParameter("owner2", owner2Code)
					.getResultList();
               }
               </#if>
               <#if menuAttributesp2 == "26" || menuAttributesp2=="3A" > 
               if(prefix.equals("NCI")){
                        // invoice  , allow digits and alpha but not closed and  invoiced
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc  where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag  AND cc.${statusFlagField} = :flag2  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", minvoiced).setParameter("owner2", owner2Code)
					.getResultList();
               }
              </#if>
              <#if menuAttributesp2 == "44">
               if(prefix.equals("MY")){
                 // employee orders, allow digits and alpha but no closed for owner
                 prefix="0";
                 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zdxxutoxlhxxxxxxxxxxowner=:ownerCode  order by cc.${keyField}  ")
       	.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode)
	.getResultList();
               }
               </#if>
               <#if menuAttributesp2 == "24">
                if(prefix.equals("OPTNS")){
                        // customer order, allow digits and alpha , order can be order or toPay or  paid or terms as PrePay and not shipped
                        prefix="0";
                        String terms1="PrePay and%";
 			 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND (cc.${statusFlagField} = :flag OR cc.${statusFlagField} = :flag4 AND cc.${statusFlagField} != :flag3 OR cc.${statusFlagField} = :flag2 OR cc.c2xxcxxxbv09xxxxxxxxterms like :terms1)   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mordered).setParameter("flag2", mpaid).setParameter("flag3", mshipped).setParameter("flag4", mtoPay).setParameter("terms1", terms1).setParameter("owner2", owner2Code)
		        			.getResultList();
               }
                if(prefix.equals("NS")){
                        // customer order, allow digits and alpha , order  not shipped
                        prefix="0";
 			 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND (cc.${statusFlagField} = :flag AND cc.${statusFlagField} != :flag3 )   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mordered).setParameter("flag3", mshipped).setParameter("owner2", owner2Code)
		        			.getResultList();
               }

               if(prefix.equals("MY")){
                        // cuorder,allow digits and alpha but no closed for owner
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} = :flag2  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode  order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mordered).setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode)
					.getResultList();
               }
                if(prefix.equals("COP")){
                   // cuorder, not closed(8) and terms 'PickUp'  and not shipped(32) and not invoiced(64) ie <paid(16)
                   // used to render convertCartToPos method to change status to invoiced
                  prefix="0";
                  String terms2="ToPay and PickUp";
              	return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} < :flag2 AND cc.c2xxcxxxbv09xxxxxxxxterms like :terms2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}")
                   .setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mpaid).setParameter("terms2", terms2)
                  .setParameter("owner2", owner2Code)
                   .getResultList();
                }
                if(prefix.equals("PP")){
                        // cuorders paid (prepay) or invoiced (capture after shipment)  status and terms PrePay and PickUp ... and type cart
                        prefix="0";
                        String terms1="PrePay and PickUp";
                        return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.${statusFlagField} = :flag2  OR cc.${statusFlagField} = :flag3 ) AND cc.c2xxcxxxbv09xxxxxxxxterms like :terms1 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}")
                          .setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mpaid).setParameter("flag3", minvoiced).setParameter("terms1", terms1)
                          .setParameter("owner2", owner2Code)
                          .getResultList();
                }
                if(prefix.equals("PD")){
                        // cuorders paid (prepay)  or invoiced (capture after shipment)  and terms PrePay and Delivery... and type cart
                        prefix="0";
                        String terms1="PrePay and Delivery";
                        return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.${statusFlagField} = :flag2  OR cc.${statusFlagField} = :flag3 ) AND cc.c2xxcxxxbv09xxxxxxxxterms like :terms1 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}")
                          .setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mpaid).setParameter("flag3", minvoiced).setParameter("terms1", terms1)
                          .setParameter("owner2", owner2Code)
                          .getResultList();
                }
                if(prefix.equals("POD")){
                        // cuorders ToPay(2) status and terms ToPay and ... and type cart
                        prefix="0";
                        String terms1="ToPay and Delivery";
                        return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} = :flag2 AND cc.c2xxcxxxbv09xxxxxxxxterms like :terms1 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}")
                          .setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mtoPay).setParameter("terms1", terms1)
                          .setParameter("owner2", owner2Code)
                          .getResultList();
                }
               if(prefix.equals("NC")){
                        // customer order , allow digits and alpha but not closed and shipped status ready for payment and not PrePay and not invoiced
                        prefix="0";
	return getEntityManager().createQuery(" select cc from ${entityName} cc  where (cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag  AND cc.${statusFlagField} != :flag2 AND cc.${statusFlagField} != :flag3 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
	.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("flag2", mpaid).setParameter("flag3", minvoiced).setParameter("owner2", owner2Code)
	.getResultList();
               }
               </#if>
               <#if menuAttributesp2 == "34">
                if(prefix.equals("OP")){
                        // allow digits and alpha , vendor order can be order or  paid 
                        prefix="0";
	 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND (cc.${statusFlagField} = :flag AND cc.${statusFlagField} != :flag3 OR cc.${statusFlagField} = :flag2 )   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
                   .setParameter("keyOfEntity", prefix).setParameter("flag", mordered).setParameter("flag2", mpaid).setParameter("flag3", mshipped).setParameter("owner2", owner2Code)
                    .getResultList();
                }
               </#if>

               if(prefix.equals("*")){
                        // * means allow digits and alpha but any status fl add outstanding amt !=0.0
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("O")){
                        // allow digits and alpha, ordered and toPay
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND (cc.${statusFlagField} = :flag OR cc.${statusFlagField} = :flag2)   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mordered).setParameter("flag2", mtoPay).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("I")){
                        // allow digits and alpha, invoiced
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} = :flag   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", minvoiced).setParameter("owner2", owner2Code)
					.getResultList();
               }
               <#if menuAttributesp2 == "26">
               String shiptype1="P";//pickUp
               if(prefix.equals("IP")){
                        // allow digits and alpha, invoiced and pickup
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} = :flag   AND substring(cc.c2xxuxxrbv51xxxxxxxxshiptype,1,1)=:shiptype1 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", minvoiced).setParameter("shiptype1", shiptype1).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("IPDTP")){
                        // invoice records, allow digits and alpha, invoiced and terms ToPay and not shipped
                        prefix="0";
                       String terms2="ToPay and%";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.c3xxuxxrbv09xxxxxxxxterms like :terms2 AND cc.${statusFlagField} = :flag   AND (substring(cc.c2xxuxxrbv51xxxxxxxxshiptype,1,1)=:shiptype1 OR cc.c2xxuxxrbv51xxxxxxxxshiptype =null)  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", minvoiced).setParameter("shiptype1", shiptype1).setParameter("terms2", terms2).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("IPDPP")){
                        // invoice records, allow digits and alpha, invoiced and terms PrePay and not shipped
                        prefix="0";
                       String terms1="PrePay and%";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} = :flag  AND cc.c3xxuxxrbv09xxxxxxxxterms like :terms1  AND (substring(cc.c2xxuxxrbv51xxxxxxxxshiptype,1,1)=:shiptype1 OR cc.c2xxuxxrbv51xxxxxxxxshiptype =null)  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", minvoiced).setParameter("shiptype1", shiptype1).setParameter("terms1", terms1).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("INP")){
                        // allow digits and alpha, invoiced,picked/delivered and not Paid 
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} = :flag   AND cc.${statusFlagField} != :flag2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", minvoiced).setParameter("flag2", mpaid).setParameter("owner2", owner2Code)
					.getResultList();
               }
               </#if>
               if(prefix.equals("C")){
                        // show closed , needed for copynsave
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} = :flag   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                 
               }else{
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND (cc.${statusFlagField} != :flag )   AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
               }
              <#elseif menuAttributesp2 == "1A" > // Item but depends called by whom
                //  Item but depends called by whom
                if(prefix !=null && prefix.equals("a") ){//used by countAlias stock count
                         prefix="0";
			return getEntityManager().createQuery(" select cc from ${itemEntityName?cap_first} cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.f1xxuxxrbvxxxxxxxxxxaliascode is not null AND cc.f1xxuxxrbvxxxxxxxxxxaliascode !='' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();

                }

                if(prefix.startsWith("LT-")){
                        // sorted by keyfield LT is labtest
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "LT-%").setParameter("owner2", owner2Code)
					.getResultList();
                }
                if(prefix.startsWith("SI-L%")){
                //item add dont show details, only shopping sub categories
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "SI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
                }
                if(prefix.startsWith("SI-L*")){
                //item add dont show details, only shopping and theme items sub categories 
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)    order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "SI-L*").setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
                }
                if(prefix.startsWith("SI-L1")){
                //item add dont show details, only shopping categories
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "SI-L1").setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
                }
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                if(prefix.startsWith("PI-L*")){
                //item add dont show details, only shopping categories  added owner check  allow public
                 prefix="0";
                 String owner2CodeS="SYSTEM";// test how it behaves
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode or cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = '_public') order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "PI-L%").setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.${keyField}")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "PI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }else{
                // in transactions and itemjob or bom details hide categories and show shopping (SI-) and inventory(IX)
                 String hideTypePrefix1="%I-L%";
                 String hideTypePrefix2="PI-D";
                 String hideTypePrefix1B="%I-L%";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE  :hideTypePrefix1 AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE  :hideTypePrefix1B AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE  :hideTypePrefix2  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("hideTypePrefix1", hideTypePrefix1).setParameter("hideTypePrefix1B", hideTypePrefix1B).setParameter("hideTypePrefix2", hideTypePrefix2).setParameter("owner2", owner2Code)
					.getResultList();
                }
              <#elseif menuAttributesp2 == "60" > // Account if prefix has filter then hide else show all
                String show1="D";
                String show2="A";
                String show3="I";
                if(prefix.contains("3A3")){ 
                 show1=prefix.substring(3,4)+"%";
                 show2=prefix.substring(4,5)+"%";
                 show3=prefix.substring(5,6)+"%";
                 prefix=" ";
		 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.b2xxuwtxbv02xxxxxxxxtype LIKE  :show1  AND (cc.b1xxuwgxbv01xxxxxxxxcategory LIKE  :show2  OR cc.b1xxuwgxbv01xxxxxxxxcategory LIKE  :show3) AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("show1", show1).setParameter("show2", show2).setParameter("show3", show3).setParameter("owner2", owner2Code)
					.getResultList();

                }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }

              <#elseif menuAttributesp2 == "59" > // rate1f
                if(prefix.contains("LT-")){ 
                 //prefix="0";
		 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.b3xxzxxrbvxxxxxxxxxxstep = 0 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }
                if(prefix.contains("DC")){ 
                 //type Discount Coupon
		 return getEntityManager().createQuery(" select cc from Yxxxuq591xwwqqhxxxxxrate1f cc where (cc.a0xxukxxbvxxxxxxxxxxusertype =:keyOfEntity OR cc.a0xxukxxbvxxxxxxxxxxusertype =:keyOfEntityP) AND cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.b2xxuxxrbv51xxxxxxxxstepname is not null AND cc.b3xxzxxrbvxxxxxxxxxxstep = 0 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukxxbvxxxxxxxxxxusertype  ")
        				.setParameter("keyOfEntity", prefix).setParameter("keyOfEntityP", prefix+"%").setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }
              <#elseif (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
               <#if menuAttributesp2 ="20">
                if(prefix.equals("keyWord")){
                        prefix=customIdentity.getHoldValue2();// last name or first name or company name
			return getEntityManager().createQuery(" select cc from ${customerEntityName?cap_first} cc where ( lower(cc.c1xxuslnbvixxxxxxxxxlastname) like lower(concat('%',:prefix,'%')) or lower(cc.a0xxukxxbvxxxxxxxxxxcustomer) like lower(concat('%',:prefix,'%')) or lower(cc.d1xxu3cnbvixxxxxxxxxcustomerascompanyname) like lower(concat('%',:prefix,'%')) ) AND cc.zaxxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2    order by cc.a0xxukxxbvxxxxxxxxxxcustomer")
        				.setParameter("prefix", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }

                if(prefix.equals("nextC")){
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${customerEntityName?cap_first} cc where cc.yfxxcxxybvxxxxxxxxxxnxtcontact >=cc.ydxxuxxybvxxxxxxxxxxcontacted AND cc.zaxxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2    order by cc.a0xxukxxbvxxxxxxxxxxcustomer")
        				.setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }
                if(prefix.equals("contacted")){
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${customerEntityName?cap_first} cc where cc.ydxxuxxybvxxxxxxxxxxcontacted <=cc.yfxxcxxybvxxxxxxxxxxnxtcontact AND cc.zaxxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2    order by cc.a0xxukxxbvxxxxxxxxxxcustomer")
        				.setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                }
               </#if>
               if(prefix.equals("emailE")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${employeeEntityName?cap_first} cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :noMail AND cc.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("emailV")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${vendorEntityName?cap_first} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} != :noMail AND cc.${imailaddrField} LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("emailC")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${customerEntityName?cap_first} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} != :noMail AND cc.${imailaddrField} LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("email")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} != :noMail AND cc.${imailaddrField} LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }else{
                       if(prefix.equals("time")){
                        // sorted by time to allow import to pick latest
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND cc.${statusFlagField} != :noMail AND cc.${imailaddrField} LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${statusFlagDateField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
                       }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                       }
               }
              <#elseif (menuAttributesp2 ="1L" ) >
                      if(owner2Code.equals(masterSiteCode)){
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM' )   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                      }else{
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                      }

              <#elseif (menuAttributesp2 = "1R" ) >
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();

              <#elseif (menuAttributesp2 = "5B" ) >
                        if(prefix !=null && !prefix.isEmpty() && !prefix.equals("email") ){
                         String tableNm=prefix;
                         prefix="0";//assume table name
			 return getEntityManager().createQuery(" select cc from Yrxxch5b1xhhxxhxxxxximportcsv cc where cc.a2xxukcxbvxxxxxxxxxxrow >=:keyOfEntity AND cc.a1xxuxhrbvoxxxxxxxxxtablenm = :tableNm AND cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a2xxukcxbvxxxxxxxxxxrow  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("tableNm", tableNm).setParameter("owner2", owner2Code).setMaxResults(maxResultsVal)
					.getResultList();
                        }else{
                         return null;
                        }
              <#elseif statusFlagField !="Not assigned">
                        //in send() method nomail (unsubscribed) is filtered out for group members 
                        if(prefix !=null && (prefix.isEmpty() || prefix.equals("email")) ){
                         prefix="0";
                        } 
                        <#if (menuAttributesp2 = "1F" ) >
                         String mat="";

                         if(prefix.length()>2 && prefix.substring(0,1)=="sm"){
                          mat=prefix.substring(2);
                          prefix="sm";
                         }
                         if(prefix !=null && prefix.equals("s") ){
                          prefix="0";
			  return getEntityManager().createQuery(" select cc from Fxxxuq1ffxwwqqhefxxxserialnumbers cc where cc.ycxxuxxrbvxxxxxxxxxxtype='s' AND cc.z6xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )   order by cc.a0xxukxxbvxxxxxxxxxxserialno  ")
        				.setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                         }
                         if(prefix !=null && prefix.equals("m") ){
                          prefix="0";
			  return getEntityManager().createQuery(" select cc from Fxxxuq1ffxwwqqhefxxxserialnumbers cc where cc.ycxxuxxrbvxxxxxxxxxxtype='m' AND cc.z6xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )   order by cc.a0xxukxxbvxxxxxxxxxxserialno  ")
        				.setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                         }
                         if(prefix !=null && prefix.equals("a") ){
                          prefix="0";
			  return getEntityManager().createQuery(" select cc from Fxxxuq1ffxwwqqhefxxxserialnumbers cc where cc.ycxxuxxrbvxxxxxxxxxxtype='a' AND cc.z6xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )   order by cc.a0xxukxxbvxxxxxxxxxxserialno  ")
        				.setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                         }
                         if(prefix !=null && prefix.equals("sm") ){
                          prefix="0";
			  return getEntityManager().createQuery(" select cc from Fxxxuq1ffxwwqqhefxxxserialnumbers cc where cc.${keyField} =:keyOfEntity AND cc.ycxxuxxrbvxxxxxxxxxxtype='s' AND cc.z6xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )   order by cc.a0xxukxxbvxxxxxxxxxxserialno  ")
        				.setParameter("keyOfEntity", mat).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                         }
                        </#if>

			 return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${keyField} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField}  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
              <#else>
                        return Collections.emptyList();
              </#if>
          </#if>
        <#elseif statusFlagField !="Not assigned">
                        prefix="0";
			return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.id.${ids1?lower_case} >=:keyOfEntity AND cc.${statusFlagField} != :flag AND (cc.id.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.${keyField} ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
        <#else>
                        return Collections.emptyList();
        </#if>


	}
     public List<${entityName}> getNextSids(Integer sid){
      sresults=null;// reset 
      List<${entityName}> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and cc.a0xxuobxbxxxxxxxxxxxsid >=:sid order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).setParameter("sid", sid)
					.getResultList();
      return results;
     }
     public List<Integer> getAllSids(){
      List<Integer> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc.a0xxuobxbxxxxxxxxxxxsid from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).getResultList();
      return results;
     }


<#if (menuAttributesp2?contains("92")   ) && jobassignmentEntityName?? >
	public List<${jobassignmentEntityName?cap_first}> entityJobassignmentsList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${jobassignmentEntityName?cap_first} cc where (cc.${itemjobEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return Collections.emptyList();
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("get")+" "+bundle.getString("jobassign")+"s "+bundle.getString("error")+" "+e.getMessage(), ""));

           return Collections.emptyList();
       }
     }
</#if>
<#if (menuAttributesp2?contains("9A")   )  && jobassignmentEntityName??>
	public List<${jobassignmentdetailsEntityName?cap_first}> entityDetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${jobassignmentdetailsEntityName?cap_first} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return Collections.emptyList();
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("detail")+" "+bundle.getString("error")+" "+e.getMessage(), ""));

           return Collections.emptyList();
       }
     }
     public List<${jobassignmentdetailsEntityName?cap_first}> entityLessStatusDetailedList(Integer sid,int status) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${jobassignmentdetailsEntityName?cap_first} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.b1xxzo11bvlxxxxxxxxxline != :s AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).setParameter("s", status).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("detailed")+" "+bundle.getString("statused")+" "+bundle.getString("list")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }


</#if>

<#if (menuAttributesp2?contains("9C")   ) && processattributesEntityName?? >
	public ${processattributesEntityName?cap_first} getAttributes(String stepName) {
         ${processattributesEntityName?cap_first} aresult=new ${processattributesEntityName?cap_first}(); 
         String range="";
         String prevName="";
       try{
        //loop through rate table matching process correspondng item key
        // stepname matches the detail test (attribute total wbc), usertype not used but holds process detail ie cbc as lt-cbc
        // lt- (labtest) is used to filter out and cbc etc can be used for category 
			List<${rate1fEntityName?cap_first}> results =  getEntityManager()
					.createQuery("select cc from ${rate1fEntityName?cap_first} cc where cc.B2xxuxxrbv51xxxxxxxxstepname=:stepName and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by b3xxzxxrbvxxxxxxxxxxstep")
					.setParameter("stepName", stepName)
                                        .setParameter("owner2", owner2Code)
					.getResultList();
                        //iterate
                       Iterator <Yxxxuq591xwwqqhxxxxxrate1f> iterator = results.iterator();
   		       while (iterator.hasNext()) {
		        yxxxuq591xwwqqhxxxxxrate1f = iterator.next();
                        if(!yxxxuq591xwwqqhxxxxxrate1f.getB2xxuxxrbv51xxxxxxxxstepname().equals(prevName)){  
                         if(!prevName.isEmpty()){
                          // ignore now
                         } 
                         prevName=yxxxuq591xwwqqhxxxxxrate1f.getB2xxuxxrbv51xxxxxxxxstepname();
                         aresult.setA4xxuuxxbv19xxxxxxxxname(prevName);
                         if(yxxxuq591xwwqqhxxxxxrate1f.getB3xxzxxrbvxxxxxxxxxxstep() == 0){
                          aresult.setA9xxtxsclxxxxxxxxxxxtype(yxxxuq591xwwqqhxxxxxrate1f.getB1xxuxxrbvxxxxxxxxxxprodtype());
                          aresult.setA9xxtxsolxxxxxxxxxxxvalue(""+yxxxuq591xwwqqhxxxxxrate1f.getB4xxcxxrbvxxxxxxxxxxvalue());
                          aresult.setA4xxuuxxbv19xxxxxxxxname(prevName);
                          // only step 0 value is passed to decide on input allowed or not
                          aresult.setZaxxzxxxavxxxxxxxxxxstep(yxxxuq591xwwqqhxxxxxrate1f.getB3xxzxxrbvxxxxxxxxxxstep());
                         }
                        }else{
                         // same step name continuing
                         if(yxxxuq591xwwqqhxxxxxrate1f.getB3xxzxxrbvxxxxxxxxxxstep() == 1){
                          range=""+yxxxuq591xwwqqhxxxxxrate1f.getB4xxcxxrbvxxxxxxxxxxvalue();
                          aresult.setA8xxuxxrlxxxxxxxxxxxrange(range);
                         }
                         if(yxxxuq591xwwqqhxxxxxrate1f.getB3xxzxxrbvxxxxxxxxxxstep() == 3){
                          range=range+","+yxxxuq591xwwqqhxxxxxrate1f.getB4xxcxxrbvxxxxxxxxxxvalue();
                          aresult.setA8xxuxxrlxxxxxxxxxxxrange(range);
                         }
                        }
                       }
                       return  aresult; 
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"Get Attributes error "+e.getMessage(), ""));

                return null;
       }
     }
	public List<${processattributesEntityName?cap_first}> entityDetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${processattributesEntityName?cap_first} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return Collections.emptyList();
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return Collections.emptyList();
       }
     }
     public List<${processattributesEntityName?cap_first}> entityLessStatusDetailedList(Integer sid,int status) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${processattributesEntityName?cap_first} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :s AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).setParameter("s", status).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("detailed")+" "+bundle.getString("statused")+" "+bundle.getString("list")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));
           return null;
       }
     }


</#if>
<#if menuAttributesp2 == "1A">
	public String getSortByValue() {
		return sortByValue;
	}

	public void setSortByValue(String sortByValue) {
		this.sortByValue = sortByValue;
	}

     public void setDpr(Integer dpr){
      this.dpr=dpr;
    }
    
     public Integer getDpr(){
      return dpr;
     }



</#if>


<#if ( menuAttributesp2?contains("65")  ) >
        <#assign lineField="b1xxzo11bvlxxxxxxxxxline">
	public List<${gentriesDetailsEntityName?cap_first}> entityDetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${gentriesDetailsEntityName?cap_first} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return Collections.emptyList();
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return Collections.emptyList();
       }
     }
	public List<${gentriesDetailsEntityName?cap_first}> entityLessStatusDetailedList(Integer sid,int status){
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${gentriesDetailsEntityName?cap_first} cc where (cc.${componentName}.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.${lineField} != :s  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).setParameter("s", status).getResultList();  
       } catch ( NoResultException ignore){
           return Collections.emptyList();
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("detailed")+" "+bundle.getString("statussed")+" "+bundle.getString("list")+ " "+bundle.getString("error")+" "+e.getMessage(), ""));

           return Collections.emptyList();
       }
     }
</#if>

<#if (menuAttributesp2?contains("26") ) >
    /**
    * The following method called by paymentout.xhtml
    * @param args invoice value all (invoice) or any other value ,equal true or false
    * url params categoryJay passes invoice number, ignored if all is used. If equal is false then invoice >= used
    * @return String set by persist
    * @exception None 
    * @see persist()
    * 
    */
	public List<${entityName}> getPaymentDueByCustomerList(String invoice,boolean equal) {
	  Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

          if (params.get("categoryJay") != null &&  !params.get("categoryJay").isEmpty()){ 
           invoice=params.get("categoryJay");
                   String msonorde=""+invoice;
                   int mponolen=7;
                   String padding = new String();
                   int padlen=-1;
                   int len = Math.abs(mponolen) - msonorde.length();
                   if (len < 1) {
                     msonorde=msonorde.toString();
                   }else{
                    for (int ii = 0 ; ii < len ; ++ii){
                     padding = padding + '0';
                    }
                     msonorde= (padlen < 0 ? padding + msonorde : msonorde + padding); 
                   }
            invoice=msonorde;     

          }

         if (invoice.equals("all")){
	  return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :mpaid order by cc.${customerEntityName}.b1xxudrravnxxxxxxxxxcustomer")
        				.setParameter("mpaid", minvoiced).setParameter("owner2", owner2Code)
					.getResultList();
         }
         else{
          if(equal){
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.a0xxuncibvxxxxxxxxxxinvoice =:keyOfEntity AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :mpaid order by cc.${customerEntityName}.a0xxukxxbvxxxxxxxxxxcustomer")
        				.setParameter("keyOfEntity", invoice).setParameter("mpaid", minvoiced).setParameter("owner2", owner2Code)
					.getResultList();
          }else{
	   return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.a0xxuncibvxxxxxxxxxxinvoice >=:keyOfEntity AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :mpaid order by cc.${customerEntityName}.a0xxukxxbvxxxxxxxxxxcustomer")
        				.setParameter("keyOfEntity", invoice).setParameter("mpaid", minvoiced).setParameter("owner2", owner2Code)
					.getResultList();
          }
        }



      }

</#if>



<#if (menuAttributesp2?contains("38") ) >
	public List<${entityName}> getPaymentDueByVendorList(String prefix,boolean equal) {
         String paytype="q";//chq
         if (prefix.equals("all")){
	  return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zaxxzzfxhhxxxxxxxxxxstatusfl = :mpaid order by cc.${vendorEntityName}.a0xxukxxbvxxxxxxxxxxvendor")
        				.setParameter("mpaid", mpaid).setParameter("owner2", owner2Code)
					.getResultList();
        }
        else{
         if(equal){
          //came from venarthaEdit  chaeck paytype
	  return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${vendorEntityName}.a0xxukxxbvxxxxxxxxxxvendor =:keyOfEntity AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zaxxzzfxhhxxxxxxxxxxstatusfl = :mpaid AND cc.b5xxuxxrbv10xxxxxxxxpaytype = :paytype order by cc.${vendorEntityName}.a0xxukxxbvxxxxxxxxxxvendor")
        				.setParameter("keyOfEntity", prefix).setParameter("mpaid", mpaid).setParameter("paytype", paytype).setParameter("owner2", owner2Code)
					.getResultList();
         }else{
	  return getEntityManager().createQuery(" select cc from ${entityName} cc where cc.${vendorEntityName}.a0xxukxxbvxxxxxxxxxxvendor =>:keyOfEntity AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zaxxzzfxhhxxxxxxxxxxstatusfl = :mpaid order by cc.${vendorEntityName}.a0xxukxxbvxxxxxxxxxxvendor")
        				.setParameter("keyOfEntity", prefix).setParameter("mpaid", mpaid).setParameter("owner2", owner2Code)
					.getResultList();
         }  
       }



     }

</#if>
<#if (menuAttributesp2?contains("51") ) >
    /**
    * The following method creates filtered map of purpose/options used in selectItems 
    * @param args -2 params, first is 2 characters entity id and second param is 2 digits option number 
    * param 1 ie entity id is matched against say h=entity1 entity2 or h=entity1;h=entity2
    * param 2 ie option # say 11 for City is used
    * each option entry in the option table has 3 fields options11         purpose11                value11 (sets condition)
    *                                                    actual value      display value            empty ie no filter value
    *
    *                                                    ignored           filtered display value   filter value 2 alpha country
    *                                                                      space or ; separed       entity ignored
    *                                                                      if multi entries         ca=Toronto us=Boston 
    *                                                                      ca=Toronto city us=Boston 
    *                                                                                               
    *                                                    ignored           filtered display value   s or h for entity  
    *                                                                      Rental                   show/hide s=9e(machine)     
    *                                                                                               sp or hp for product
    *                                                                                               sr or hr for role
    * @return normally a map where key (label) showing purpose and value showing options  or null and value is empty
    * if value has entries then a map where key(label) is still purpose but value is value and options is ignored
    * of course the filter characters like ca= or s= are stripped off
    * @exception None.
    * @see 
    * in the table called options, column called value will have filter value which will dictate whether it will be hidden,visible or 
    * to use the specified value rather than value in column called options
    * to hide a value in column called options for say activity entity put in value column h=18. to hide for both item and activity put value= h=1a,18
    * to show a value in column called options for say activity entity put s=18 in value column. to show for both item and activity put value= s=1a,18
    * to show based on locale put in pupose ca=manual-cheque us=manual-check  in value put ca=m us=m
    * to use value rather than whats in options column, use xxx where xxx is the value in value column example gst value
    * to show for a product use sp=ps where ps is productcode in value like fs ie forum
    * to hide for a product use hp=ps where ps is productcode in value
    * to hide for a Role use hr=RI to hide for Role User Admin to be done
    * to show only for a Role sr=RI to show for Role User Admin

    */

     private List<${optionsEntityName?cap_first}> listofOptions;
	public Map<String,String> getoptionsFieldList(String entityCode,int optionNo) {
            fieldKeyList=new LinkedHashMap<String,String>();
            //user can change country via footer when not logged in, default is "". this country value is used for user options drop down
            //check re another country used for messages based on locale country in databaseresourceloader
            //countryIsoEq=authenticator.getCountry().toLowerCase(); cannot inject plus better to save and use
            ${userproflEntityName}=${userEntityName}List.getUserProfiles();
            //some webpage like signup needs options when the userprofil does not exist yet, use default country
            if(${userproflEntityName} == null){
             countryIsoEq="ca=";
            }else{
             countryIsoEq=${userproflEntityName}.getC3xxuxxrbvxxxxxxxxxxp1(); 
            }
            if (countryIsoEq == null || countryIsoEq.length()==0 ){
                countryIsoEq="ca=";
               }
            else{
                if(!countryIsoEq.contains("=")){
                 countryIsoEq=countryIsoEq+"=";
                }
            }
            this.entityCode=entityCode;
            this.optionNo=optionNo;

            if (fieldKeyList.isEmpty()){
              List<${optionsEntityName?cap_first}> listofOptions = getEntityManager().createQuery("select cc from ${optionsEntityName?cap_first} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by cc.a0xxukcxbvxxxxxxxxxxrow")
                   .setParameter("owner2", owner2Code).getResultList() ;

		   Iterator<${optionsEntityName?cap_first}> itr = listofOptions.iterator();
		   while (itr.hasNext()) {
		    ${optionsEntityName} = itr.next();

               switch(optionNo){
               <#list 01..56 as i>
                <#if i=1>
                 <#assign optionsField="b1xxuo01bvxxxxxxxxxxoptions01">
                 <#assign purposeField="b2xxup01bvxxxxxxxxxxpurpose01">
                 <#assign valueField="b3xxuv01bvxxxxxxxxxxvalue01">
                </#if>
                <#if i=2>
                 <#assign optionsField="b4xxuo02bvxxxxxxxxxxoptions02">
                 <#assign purposeField="b5xxup02bvxxxxxxxxxxpurpose02">
                 <#assign valueField="b6xxuv02bvxxxxxxxxxxvalue02">
                </#if>
                <#if i=3>
                 <#assign optionsField="b7xxuo03bvxxxxxxxxxxoptions03">
                 <#assign purposeField="b8xxup03bvxxxxxxxxxxpurpose03">
                 <#assign   valueField="b9xxuv03bvxxxxxxxxxxvalue03">
                </#if>
                <#if i=4>
                 <#assign optionsField="c1xxuo04bvxxxxxxxxxxoptions04">
                 <#assign purposeField="c2xxup04bvxxxxxxxxxxpurpose04">
                 <#assign   valueField="c3xxuv04bvxxxxxxxxxxvalue04">
                </#if>
                <#if i=5>
                 <#assign optionsField="c4xxuo05bvxxxxxxxxxxoptions05">
                 <#assign purposeField="c5xxup05bvxxxxxxxxxxpurpose05">
                 <#assign   valueField="c6xxuv05bvxxxxxxxxxxvalue05">
                </#if>
                <#if i=6>
                 <#assign optionsField="c7xxuo06bvxxxxxxxxxxoptions06">
                 <#assign purposeField="c8xxup06bvxxxxxxxxxxpurpose06">
                 <#assign   valueField="c9xxuv06bvxxxxxxxxxxvalue06">
                </#if>
                <#if i=7>
                 <#assign optionsField="d1xxuo07bvxxxxxxxxxxoptions07">
                 <#assign purposeField="d2xxup07bvxxxxxxxxxxpurpose07">
                 <#assign   valueField="d3xxuv07bvxxxxxxxxxxvalue07">
                </#if>
                <#if i=8>
                 <#assign optionsField="d4xxuo08bvxxxxxxxxxxoptions08">
                 <#assign purposeField="d5xxup08bvxxxxxxxxxxpurpose08">
                 <#assign   valueField="d6xxuv08bvxxxxxxxxxxvalue08">
                </#if>
                <#if i=9>
                 <#assign optionsField="d7xxuo09bvxxxxxxxxxxoptions09">
                 <#assign purposeField="d8xxup09bvxxxxxxxxxxpurpose09">
                 <#assign   valueField="d9xxuv09bvxxxxxxxxxxvalue09">
                </#if>
                <#if i=10>
                 <#assign optionsField="e1xxuo10bvxxxxxxxxxxoptions10">
                 <#assign purposeField="e2xxup10bvxxxxxxxxxxpurpose10">
                 <#assign   valueField="e3xxuv10bvxxxxxxxxxxvalue10">
                </#if>
                <#if i=11>
                 <#assign optionsField="e4xxuo11bvxxxxxxxxxxoptions11">
                 <#assign purposeField="e5xxup11bvxxxxxxxxxxpurpose11">
                 <#assign   valueField="e6xxuv11bvxxxxxxxxxxvalue11">
                </#if>
                <#if i=12>
                 <#assign optionsField="e7xxuo12bvxxxxxxxxxxoptions12">
                 <#assign purposeField="e8xxup12bvxxxxxxxxxxpurpose12">
                 <#assign   valueField="e9xxuv12bvxxxxxxxxxxvalue12">
                </#if>
                <#if i=13>
                 <#assign optionsField="f1xxuo13bvxxxxxxxxxxoptions13">
                 <#assign purposeField="f2xxup13bvxxxxxxxxxxpurpose13">
                 <#assign   valueField="f3xxuv13bvxxxxxxxxxxvalue13">
                </#if>
                <#if i=14>
                 <#assign optionsField="f4xxuo14bvxxxxxxxxxxoptions14">
                 <#assign purposeField="f5xxup14bvxxxxxxxxxxpurpose14">
                 <#assign   valueField="f6xxuv14bvxxxxxxxxxxvalue14">
                </#if>
                <#if i=15>
                 <#assign optionsField="f7xxuo15bvxxxxxxxxxxoptions15">
                 <#assign purposeField="f8xxup15bvxxxxxxxxxxpurpose15">
                 <#assign   valueField="f9xxuv15bvxxxxxxxxxxvalue15">
                </#if>
                <#if i=16>
                 <#assign optionsField="g1xxuo16bvxxxxxxxxxxoptions16">
                 <#assign purposeField="g2xxup16bvxxxxxxxxxxpurpose16">
                 <#assign   valueField="g3xxuv16bvxxxxxxxxxxvalue16">
                </#if>
                <#if i=17>
                 <#assign optionsField="g4xxuo17bvxxxxxxxxxxoptions17">
                 <#assign purposeField="g5xxup17bvxxxxxxxxxxpurpose17">
                 <#assign   valueField="g6xxuv17bvxxxxxxxxxxvalue17">
                </#if>
                <#if i=18>
                 <#assign optionsField="g7xxuo18bvxxxxxxxxxxoptions18">
                 <#assign purposeField="g8xxup18bvxxxxxxxxxxpurpose18">
                 <#assign   valueField="g9xxuv18bvxxxxxxxxxxvalue18">
                </#if>
                <#if i=19>
                 <#assign optionsField="h1xxuo19bvxxxxxxxxxxoptions19">
                 <#assign purposeField="h2xxup19bvxxxxxxxxxxpurpose19">
                 <#assign   valueField="h3xxuv19bvxxxxxxxxxxvalue19">
                </#if>
                <#if i=20>
                 <#assign optionsField="h4xxuo20bvxxxxxxxxxxoptions20">
                 <#assign purposeField="h5xxup20bvxxxxxxxxxxpurpose20">
                 <#assign   valueField="h6xxuv20bvxxxxxxxxxxvalue20">
                </#if>
                <#if i=21>
                 <#assign optionsField="h7xxuo21bvxxxxxxxxxxoptions21">
                 <#assign purposeField="h8xxup21bvxxxxxxxxxxpurpose21">
                 <#assign   valueField="h9xxuv21bvxxxxxxxxxxvalue21">
                </#if>
                <#if i=22>
                 <#assign optionsField="i1xxuo22bvxxxxxxxxxxoptions22">
                 <#assign purposeField="i2xxup22bvxxxxxxxxxxpurpose22">
                 <#assign   valueField="i3xxuv22bvxxxxxxxxxxvalue22">
                </#if>
                <#if i=23>
                 <#assign optionsField="i4xxuo23bvxxxxxxxxxxoptions23">
                 <#assign purposeField="i5xxup23bvxxxxxxxxxxpurpose23">
                 <#assign   valueField="i6xxuv23bvxxxxxxxxxxvalue23">
                </#if>
                <#if i=24>
                 <#assign optionsField="i7xxuo24bvxxxxxxxxxxoptions24">
                 <#assign purposeField="i8xxup24bvxxxxxxxxxxpurpose24">
                 <#assign   valueField="i9xxuv24bvxxxxxxxxxxvalue24">
                </#if>
                <#if i=25>
                 <#assign optionsField="j1xxuo25bvxxxxxxxxxxoptions25">
                 <#assign purposeField="j2xxup25bvxxxxxxxxxxpurpose25">
                 <#assign   valueField="j3xxuv25bvxxxxxxxxxxvalue25">
                </#if>
                <#if i=26>
                 <#assign optionsField="j4xxuo26bvxxxxxxxxxxoptions26">
                 <#assign purposeField="j5xxup26bvxxxxxxxxxxpurpose26">
                 <#assign   valueField="j6xxuv26bvxxxxxxxxxxvalue26">
                </#if>
                <#if i=27>
                 <#assign optionsField="j7xxuo27bvxxxxxxxxxxoptions27">
                 <#assign purposeField="j8xxup27bvxxxxxxxxxxpurpose27">
                 <#assign   valueField="j9xxuv27bvxxxxxxxxxxvalue27">
                </#if>
                <#if i=28>
                 <#assign optionsField="k1xxuo28bvxxxxxxxxxxoptions28">
                 <#assign purposeField="k2xxup28bvxxxxxxxxxxpurpose28">
                 <#assign   valueField="k3xxuv28bvxxxxxxxxxxvalue28">
                </#if>
                <#if i=29>
                 <#assign optionsField="k4xxuo29bvxxxxxxxxxxoptions29">
                 <#assign purposeField="k5xxup29bvxxxxxxxxxxpurpose29">
                 <#assign   valueField="k6xxuv29bvxxxxxxxxxxvalue29">
                </#if>
                <#if i=30>
                 <#assign optionsField="k7xxuo30bvxxxxxxxxxxoptions30">
                 <#assign purposeField="k8xxup30bvxxxxxxxxxxpurpose30">
                 <#assign   valueField="k9xxuv30bvxxxxxxxxxxvalue30">
                </#if>
                <#if i=31>
                 <#assign optionsField="l1xxuo31bvxxxxxxxxxxoptions31">
                 <#assign purposeField="l2xxup31bvxxxxxxxxxxpurpose31">
                 <#assign   valueField="l3xxuv31bvxxxxxxxxxxvalue31">
                </#if>
                <#if i=32>
                 <#assign optionsField="l4xxuo32bvxxxxxxxxxxoptions32">
                 <#assign purposeField="l5xxup32bvxxxxxxxxxxpurpose32">
                 <#assign   valueField="l6xxuv32bvxxxxxxxxxxvalue32">
                </#if>
                <#if i=33>
                 <#assign optionsField="l7xxuo33bvxxxxxxxxxxoptions33">
                 <#assign purposeField="l8xxup33bvxxxxxxxxxxpurpose33">
                 <#assign   valueField="l9xxuv33bvxxxxxxxxxxvalue33">
                </#if>
                <#if i=34>
                 <#assign optionsField="m1xxuo34bvxxxxxxxxxxoptions34">
                 <#assign purposeField="m2xxup34bvxxxxxxxxxxpurpose34">
                 <#assign   valueField="m3xxuv34bvxxxxxxxxxxvalue34">
                </#if>
                <#if i=35>
                 <#assign optionsField="m4xxuo35bvxxxxxxxxxxoptions35">
                 <#assign purposeField="m5xxup35bvxxxxxxxxxxpurpose35">
                 <#assign   valueField="m6xxuv35bvxxxxxxxxxxvalue35">
                </#if>
                <#if i=36>
                 <#assign optionsField="m7xxuo36bvxxxxxxxxxxoptions36">
                 <#assign purposeField="m8xxup36bvxxxxxxxxxxpurpose36">
                 <#assign   valueField="m9xxuv36bvxxxxxxxxxxvalue36">
                </#if>
                <#if i=37>
                 <#assign optionsField="n1xxuo37bvxxxxxxxxxxoptions37">
                 <#assign purposeField="n2xxup37bvxxxxxxxxxxpurpose37">
                 <#assign   valueField="n3xxuv37bvxxxxxxxxxxvalue37">
                </#if>
                <#-- 38 alevel 39 blevel put role based hide -->
                <#if i=38>
                 <#assign optionsField="n4xxuo38bvxxxxxxxxxxoptions38">
                 <#assign purposeField="n5xxup38bvxxxxxxxxxxpurpose38">
                 <#assign   valueField="n6xxuv38bvxxxxxxxxxxvalue38">
                </#if>
                <#if i=39>
                 <#assign optionsField="n7xxuo39bvxxxxxxxxxxoptions39">
                 <#assign purposeField="n8xxup39bvxxxxxxxxxxpurpose39">
                 <#assign   valueField="n9xxuv39bvxxxxxxxxxxvalue39">
                </#if>
                <#if i=40>
                 <#assign optionsField="o1xxuo40bvxxxxxxxxxxoptions40">
                 <#assign purposeField="o2xxup40bvxxxxxxxxxxpurpose40">
                 <#assign   valueField="o3xxuv40bvxxxxxxxxxxvalue40">
                </#if>
                <#if i=41>
                 <#assign optionsField="o4xxuo41bvxxxxxxxxxxoptions41">
                 <#assign purposeField="o5xxup41bvxxxxxxxxxxpurpose41">
                 <#assign   valueField="o6xxuv41bvxxxxxxxxxxvalue41">
                </#if>
                <#if i=42>
                 <#assign optionsField="o7xxuo42bvxxxxxxxxxxoptions42">
                 <#assign purposeField="o8xxup42bvxxxxxxxxxxpurpose42">
                 <#assign   valueField="o9xxuv42bvxxxxxxxxxxvalue42">
                </#if>
                <#if i=43>
                 <#assign optionsField="p1xxuo43bvxxxxxxxxxxoptions43">
                 <#assign purposeField="p2xxup43bvxxxxxxxxxxpurpose43">
                 <#assign   valueField="p3xxuv43bvxxxxxxxxxxvalue43">
                </#if>
                <#if i=44>
                 <#assign optionsField="p4xxuo44bvxxxxxxxxxxoptions44">
                 <#assign purposeField="p5xxup44bvxxxxxxxxxxpurpose44">
                 <#assign   valueField="p6xxuv44bvxxxxxxxxxxvalue44">
                </#if>
                <#if i=45>
                 <#assign optionsField="p7xxuo45bvxxxxxxxxxxoptions45">
                 <#assign purposeField="p8xxup45bvxxxxxxxxxxpurpose45">
                 <#assign   valueField="p9xxuv45bvxxxxxxxxxxvalue45">
                </#if>
                <#if i=46>
                 <#assign optionsField="q1xxuo46bvxxxxxxxxxxoptions46">
                 <#assign purposeField="q2xxup46bvxxxxxxxxxxpurpose46">
                 <#assign   valueField="q3xxuv46bvxxxxxxxxxxvalue46">
                </#if>
                <#if i=47>
                 <#assign optionsField="q4xxuo47bvxxxxxxxxxxoptions47">
                 <#assign purposeField="q5xxup47bvxxxxxxxxxxpurpose47">
                 <#assign   valueField="q6xxuv47bvxxxxxxxxxxvalue47">
                </#if>
                <#if i=48>
                 <#assign optionsField="q7xxuo48bvxxxxxxxxxxoptions48">
                 <#assign purposeField="q8xxup48bvxxxxxxxxxxpurpose48">
                 <#assign   valueField="q9xxuv48bvxxxxxxxxxxvalue48">
                </#if>
                <#if i=49>
                 <#assign optionsField="r1xxuo49bvxxxxxxxxxxoptions49">
                 <#assign purposeField="r2xxup49bvxxxxxxxxxxpurpose49">
                 <#assign   valueField="r3xxuv49bvxxxxxxxxxxvalue49">
                </#if>
                <#if i=50>
                 <#assign optionsField="r4xxuo50bvxxxxxxxxxxoptions50">
                 <#assign purposeField="r5xxup50bvxxxxxxxxxxpurpose50">
                 <#assign   valueField="r6xxuv50bvxxxxxxxxxxvalue50">
                </#if>
                <#if i=51>
                 <#assign optionsField="r7xxuo51bvxxxxxxxxxxoptions51">
                 <#assign purposeField="r8xxup51bvxxxxxxxxxxpurpose51">
                 <#assign   valueField="r9xxuv51bvxxxxxxxxxxvalue51">
                </#if>
                <#if i=52>
                 <#assign optionsField="s1xxuo52bvxxxxxxxxxxoptions52">
                 <#assign purposeField="s2xxup52bvxxxxxxxxxxpurpose52">
                 <#assign   valueField="s3xxuv52bvxxxxxxxxxxvalue52">
                </#if>
                <#if i=53>
                 <#assign optionsField="s4xxuo53bvxxxxxxxxxxoptions53">
                 <#assign purposeField="s5xxup53bvxxxxxxxxxxpurpose53">
                 <#assign   valueField="s6xxuv53bvxxxxxxxxxxvalue53">
                </#if>
                <#if i=54>
                 <#assign optionsField="s7xxuo54bvxxxxxxxxxxoptions54">
                 <#assign purposeField="s8xxup54bvxxxxxxxxxxpurpose54">
                 <#assign   valueField="s9xxuv54bvxxxxxxxxxxvalue54">
                </#if>
                <#if i=55>
                 <#assign optionsField="t1xxuo55bvxxxxxxxxxxoptions55">
                 <#assign purposeField="t2xxup55bvxxxxxxxxxxpurpose55">
                 <#assign   valueField="t3xxuv55bvxxxxxxxxxxvalue55">
                </#if>
                <#if i=56>
                 <#assign optionsField="t4xxuo56bvxxxxxxxxxxoptions56">
                 <#assign purposeField="t5xxup56bvxxxxxxxxxxpurpose56">
                 <#assign   valueField="t6xxuv56bvxxxxxxxxxxvalue56">
                </#if>
                <#if i=57>
                 <#assign optionsField="t7xxuo57bvxxxxxxxxxxoptions57">
                 <#assign purposeField="t8xxup57bvxxxxxxxxxxpurpose57">
                 <#assign   valueField="t9xxuv57bvxxxxxxxxxxvalue57">
                </#if>
                <#if i=58>
                 <#assign optionsField="u1xxuo58bvxxxxxxxxxxoptions58">
                 <#assign purposeField="u2xxup58bvxxxxxxxxxxpurpose58">
                 <#assign   valueField="u3xxuv58bvxxxxxxxxxxvalue58">
                </#if>
                <#if i=59>
                 <#assign optionsField="u4xxuo59bvxxxxxxxxxxoptions59">
                 <#assign purposeField="u5xxup59bvxxxxxxxxxxpurpose59">
                 <#assign   valueField="u6xxuv59bvxxxxxxxxxxvalue59">
                </#if>
                <#if i=60>
                 <#assign optionsField="u7xxuo60bvxxxxxxxxxxoptions60">
                 <#assign purposeField="u8xxup60bvxxxxxxxxxxpurpose60">
                 <#assign   valueField="u9xxuv60bvxxxxxxxxxxvalue60">
                </#if>
                <#if i=61>
                 <#assign optionsField="v1xxuo61bvxxxxxxxxxxoptions61">
                 <#assign purposeField="v2xxup61bvxxxxxxxxxxpurpose61">
                 <#assign   valueField="v3xxuv61bvxxxxxxxxxxvalue61">
                </#if>

                case ${i}:
                 optionFilter=${optionsEntityName}.get${valueField?cap_first}()==null?"":${optionsEntityName}.get${valueField?cap_first}().replaceAll(" +", " ");
                 optionOptions=${optionsEntityName}.get${optionsField?cap_first}()==null?"":${optionsEntityName}.get${optionsField?cap_first}().replaceAll(" +", " ");
                 optionPurpose=${optionsEntityName}.get${purposeField?cap_first}()==null?"":${optionsEntityName}.get${purposeField?cap_first}().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;
               </#list>
               }
              }

            }
            //   if clobdata then add the current instance key value if non 3R to prefill 
            
             if( entityCode.equals("1m") && optionNo ==49 ){
              if(${clobdataEntityName}Home.getInstance() !=null && ${clobdataEntityName}Home.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey() !=null){
               fieldKeyList.put(${clobdataEntityName}Home.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey(),${clobdataEntityName}Home.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey());
              }
             }
             if(entityCode.equals("1n") && optionNo ==49 ){
              if(${blobdataEntityName}Home.getInstance() !=null && ${blobdataEntityName}Home.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey() !=null){
               fieldKeyList.put(${blobdataEntityName}Home.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey(),${blobdataEntityName}Home.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey());
              }
             }
            return fieldKeyList;



      }
      public void setOptionsKeyFields(){
                 if (optionFilter != null && optionFilter.length()!=0 ){
                  // labels for tax1 etc is controlled by locale ie en-us or en-ca which will have extra entries 
                  //jay add logic based on locale pick values for  pst, gst etc ie us=5 ca=13 
                  //possibilities are 1)entityCode but not in filter meaning locale based value 
                  // 2) entityCode in filter meaning hide/show
                  // 3)same as possibility 1 ie no match for entity in filter but filter has t(tax)country codeie tca=13 tus=9 
                   // parameter 1 ie entity code is present but should not be part of the filter
                  if(!optionFilter.contains("sp=") && !optionFilter.contains("hp=") && !optionFilter.contains(entityCode) ){  
                   if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                    if ( optionFilter.contains(countryIsoEq) ){
                     // stripoff contrycode matched row from options value colmn  label is purpose colmn 
                     indexStart=optionFilter.indexOf(countryIsoEq);
                     optionFilterRevised=optionFilter.substring(indexStart);
                     indexEnd=optionFilterRevised.indexOf(";");
                     if (indexEnd == -1){
                       // no ; but space ,actual entry in purpose colmn can have space too and multiple =
                       // get next = sign, but reset indexStart to 0 because Revised is getting shorter
                       indexStart=0;
                       indexEnd=optionFilterRevised.indexOf("=",indexStart+3);
                       if (indexEnd == -1){
                        //last entry or only entry
                        indexEnd=optionFilterRevised.length();
                       }else{
                        // backoff 3 chrs from next = found
                        indexEnd=indexEnd-3;
                       }
                     }
                     transformedValue=optionFilterRevised.substring(3,indexEnd);
                     // make sure we have entries for us and possibly for gb,ca
                     // gb=xxx;ca=yyy us=xx y z   in=1234 can be ; or space as separator no end character
                     
                     if ( optionPurpose.contains(countryIsoEq) ){
                      indexStart=optionPurpose.indexOf(countryIsoEq);
                      optionFilterRevised=optionPurpose.substring(indexStart);
                      indexEnd=optionFilterRevised.indexOf(";");
                      if (indexEnd == -1){
                       // no ; but space ,actual entry in purpose colmn can have space too and multiple =
                       // get next = sign
                       indexStart=0;
                       indexEnd=optionFilterRevised.indexOf("=",indexStart+3);
                       if (indexEnd == -1){
                        //last entry or only entry
                        indexEnd=optionFilterRevised.length();
                       }else{
                        // found backoff 3 chrs from next = found
                        indexEnd=indexEnd-3;
                       }
                      }
                     }  
                     transformedPurposeValue=optionFilterRevised.substring(3,indexEnd);
                     fieldKeyList.put(transformedPurposeValue,transformedValue);
                    }
                    else{
                     // applies to certain options like 12 ie province which if missing causes problem
                     // jay comment out here and add logic for specific cases
                     if ( optionFilter.contains("=") && !doneOnce){
                      //fieldKeyList.put("No entry for locale "+localeSelector.getLocale().getCountry()," ");
                      doneOnce=true;
                     }
                     else{
                      // option value like fst/tax  remove this code since it does not allow multi country tax use tca=13 not 13
                      fieldKeyList.put(optionPurpose,optionFilter);
                     }
                    }
                   }
                  }
                  // means hide or show with matching entity code in filter 
                  if ( optionFilter.contains("h=") && optionFilter.contains(entityCode)  ) {   
                   //do nothing if entitycode matches but add for other entity codes
                     transformedValue=optionFilter.substring(2,4);
                     if (!entityCode.equals(transformedValue)){
                      if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                       fieldKeyList.put(optionPurpose,optionOptions);
                      }
                     }
                  }
                  if ( optionFilter.contains("s=") && optionFilter.contains(entityCode) ) {   
                   // add if entitycode matches and skip for other entitycode
                     transformedValue=optionFilter.substring(2,4);
                     if (entityCode.equals(transformedValue)){
                      if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                       fieldKeyList.put(optionPurpose,optionOptions);
                      }
                     }
                  }
                  //check for prod code
                  if ( optionFilter.contains("hp=") && optionFilter.contains(productCode)  ) {   
                   //do nothing if prodCode matches but add for other prod codes
                     transformedValue=optionFilter.substring(3,5);
                     if (!productCode.equals(transformedValue)){
                      if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                       fieldKeyList.put(optionPurpose,optionOptions);
                      }
                     }
                  }

                  if ( optionFilter.contains("sp=") && optionFilter.contains(productCode) ) {   
                   // add if productcode matches and skip for other productcode
                     transformedValue=optionFilter.substring(3,5);
                     if (productCode.equals(transformedValue)){
                      if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                       fieldKeyList.put(optionPurpose,optionOptions);
                      }
                     }
                  }

                  //Should not come here
                  // jay add error logic
                 }
                 //optionfilter null or empty
                 else{
                    // value field does not have any filter or value ie regular entries of purpose and option value
                    // do not skip blank purpose fields as they are used in select list to make blank as default value
                    if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                     fieldKeyList.put(optionPurpose,optionOptions);
                    }
                 }
                 // store last option16 (item type) value used in identity to be used in in edit??
                 if (optionNo==16){
                    if(optionPurpose != null && optionPurpose.length()!=0 && optionOptions !=null && optionOptions.length()!=0){
                     customIdentity.setOption16(optionOptions+"="+optionPurpose);
                    }
                 }

      }
</#if>
<#if (menuAttributesp2?contains("52") ) >

	public List<${entityName}> getClientsList() {
		return getEntityManager()
		.createQuery(
		 "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").getResultList();

	}

                 public void nextDataOwner2Code() {
                   List<${entityName}> sresults=null;
                  if(${clientEntityName}Home.get${entityName}From().isEmpty()){
                   sresults=getEntityManager()
                              .createQuery(
                                "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2 order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01")
                                    .setParameter("nextOwner2", dataOwner2Code).getResultList();
                   if(sresults.size() > 5){
                    dataOwner2Code=sresults.get(5).getZzxxu2oxxhxxxxxxxxxxowner2();
                   }// otherwise same value
                 }else{
                   sresults=getEntityManager()
                              .createQuery(
                                "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2 and cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").setParameter("type", yxxxch522xhhxxhxxxxxclientHome.getYxxxch522xhhxxhxxxxxclientFrom())
                                    .setParameter("nextOwner2", dataOwner2Code).getResultList();
                   if(sresults.size() > 5){
                    dataOwner2Code=sresults.get(5).getZzxxu2oxxhxxxxxxxxxxowner2();
                   }// otherwise same value
                 }
                }
                 public void prevDataOwner2Code() {
                   List<${entityName}> sresults=null;
                   sresults=getEntityManager()
                              .createQuery(
                                "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 < :nextOwner2 order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01")
                                    .setParameter("nextOwner2", dataOwner2Code).getResultList();
                   if(sresults.size() > 5){
                    dataOwner2Code=sresults.get(0).getZzxxu2oxxhxxxxxxxxxxowner2();
                   }// otherwise same value
                 }

	public List<${entityName}> getClientsList(String prefix) {
                    ${clientEntityName}Home.setYxxxch522xhhxxhxxxxxclientFrom(prefix);
                    if(prefix.equals("TrialPending")){
		return getEntityManager()
		.createQuery(
		 "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type   and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2  order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").setParameter("nextOwner2", dataOwner2Code).setParameter("type", "TrialPending").getResultList();
                    }
		return getEntityManager()
		.createQuery(
		 "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2  order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").setParameter("nextOwner2", dataOwner2Code).getResultList();
	}

	public List<${entityName}> getOwner2ClientList(String owner2Code) {
		return getEntityManager()
		.createQuery(
		 "select cc from ${entityName} cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName  and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.zzxxu2oxxhxxxxxxxxxxowner2")
                   .setParameter("nKeyName","01").setParameter("owner2", owner2Code).getResultList();

	}


	public boolean isSSOActive() {
         try {
                 ${clientEntityName?cap_first} client =(${clientEntityName?cap_first}) getEntityManager()
					.createQuery(
							"select cc from ${clientEntityName?cap_first} cc where cc.${clientClientversion} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
      if (client == null) {
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,"Registration Process ie Create Site to be completed First", ""));

                          return false;
      }
                      if (client.getH5xxuxxxivxxxxxxxxxxncode() == null || "".equals(client.getH5xxuxxxivxxxxxxxxxxncode())){
                       return false;
                      }else{
                       return true;     
                      }
         } catch (Exception exc) {
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,"Registration Process ie Create Site to be completed First", ""));

          return false ; 
         }

	}
</#if>

      <#if menuAttributesp2 == "68" >
        // needs sort order for journal seq is numeric and suitable for sort but seqs is alpha used for start/end
	public List<${entityName}> get${entityName?substring(10)}SuggestSeqList() {
		     Integer nenteredValue = 0;
			return getEntityManager().createQuery("select cc from ${entityName} cc where cc.b5cczjsibvxxxxxxxxxxjnlseq >=:keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM') order by cc.b5cczjsibvxxxxxxxxxxjnlseq ")
        				.setParameter("keyOfEntity", nenteredValue).setParameter("owner2", owner2Code)
					.getResultList();
        }

      </#if>
	public List<String> get${entityName?substring(10)}KeyList() {
                 // ${ids1Type}${ids1}  ${keyFieldType} ${keyField}
        <#if ids1Type == "java.util.Date" >
		     Date enteredValue= new Date();
        </#if>
        <#if keyAutoGen=="Y"> 
          <#if keyField == "">
		     Integer nenteredValue = 0;
			return getEntityManager().createQuery("select cc.${ids1?lower_case} from ${entityName} cc where cc.${ids1?lower_case} >=:keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM') ")
        				.setParameter("keyOfEntity", nenteredValue).setParameter("owner2", owner2Code)
					.getResultList();
          <#else>
    
                <#if keyFieldType?contains("tring")>
		       String enteredValue = "";
                <#else>
 		      Integer enteredValue = 1;
                </#if>
                        //order case insensitive
			return getEntityManager().createQuery("select cc.${keyField} from ${entityName} cc where cc.${keyField} >=:keyOfEntity   AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')  order by lower(cc.${keyField}) ")
        				.setParameter("keyOfEntity", enteredValue).setParameter("owner2", owner2Code)
					.getResultList();
          </#if>
        <#else>
			return getEntityManager().createQuery("select cc.id.${ids1?lower_case} from ${entityName} cc where cc.id.${ids1?lower_case} >=:keyOfEntity  AND (cc.id.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM') order by cc.${ids1?lower_case} ")
        				.setParameter("keyOfEntity", enteredValue).setParameter("owner2", owner2Code)
					.getResultList();
        </#if>
   


      }
<#if (menuAttributesp2?contains("1A") || menuAttributesp2?contains("18") || menuAttributesp2?contains("19")) >

	public List<${entityName}> getSortedByParentList(String type) {
               if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
                if (type.equals("all")){
 		 return getEntityManager()
		 .createQuery(
		 " select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode  order by cc.${entityName?lower_case}.${keyField}  ")
                  .setParameter("ownerCode", ownerCode).setParameter("owner2", owner2Code)
		 .getResultList();

                }else{
 		 return getEntityManager()
		 .createQuery(
		 " select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode and cc.c6xxusxrbv16xxxxxxxxtype like :type order by cc.${entityName?lower_case}.${keyField}  ")
                  .setParameter("ownerCode", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type)
		 .getResultList();
                }
               }else{
                if (type.equals("all")){
		 return getEntityManager()
		 .createQuery(
		 " select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.${entityName?lower_case}.${keyField}  ")
                 .setParameter("owner2", owner2Code)
		 .getResultList();
                }else{
		 return getEntityManager()
		 .createQuery(
		 " select cc from ${entityName} cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.c6xxusxrbv16xxxxxxxxtype like :type  order by cc.${entityName?lower_case}.${keyField}  ")
                  .setParameter("owner2", owner2Code).setParameter("type", type)
		 .getResultList();
                }
               }

	}


        private List<${entityName}>items;
        private ${entityName} item;
        private String prevParent="";
        private Map<String, List<${entityName}> > itemsMap;
        private Map<String, List<${entityName}> > itemsSIMap;

          <#if (menuAttributesp2?contains("1A") || menuAttributesp2?contains("18") || menuAttributesp2?contains("19") ) >
           private TreeNode rootNode;
           private TreeNode currentSelection = null;
           private TreeNode root;

           public TreeNode getRoot() {
            return root;
           }

/**
  public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {
        // considering only single selection
        List<Object> selection = new ArrayList<Object>(selectionChangeEvent.getNewSelection());
        Object currentSelectionKey = selection.get(0);
        UITree tree = (UITree) selectionChangeEvent.getSource();
 
        Object storedKey = tree.getRowKey();
        tree.setRowKey(currentSelectionKey);
        currentSelection = (TreeNode) tree.getRowData();
        tree.setRowKey(storedKey);
    }
*/
   public TreeNode getCurrentSelection() {
        return currentSelection;
    }
 
    public void setCurrentSelection(TreeNode currentSelection) {
        this.currentSelection = currentSelection;
    }


          public void buildRootNode(){
           this.rootNode = new DefaultTreeNode("all", null);
           //getItemsMap will get parent as key and value as its children
           Map<String, List<${entityName}>> itemsMap = getItemsMap();
           //getItemsMap() > get resultList > filter out non parent
           // returns item entries for a parent key
           for (Map.Entry<String, List<${entityName}>> entry : itemsMap.entrySet()) {
            TreeNode node=new DefaultTreeNode(entry.getKey(),rootNode);
            for (${entityName} child : entry.getValue()){
             TreeNode childNode=new DefaultTreeNode(child.get${keyField?cap_first}(),node);
            }
           }
          }
          </#if>
        public Map<String, List<${entityName}> > getItemsMap(){
        //item=getResultList().get(0);
        List<${entityName}> itemsFromMap = null;
      if (itemsMap==null){
       itemsMap = new HashMap<String, List<${entityName}>>();
       setMaxResultsVal(1200);
       // no need, caused filtering  setOrderColumn("${entityName?lower_case}.${entityName?lower_case}.${keyField}");
       for (${entityName} item : getResultList()) {
        // skip if no parent, capture child detail and save parent as prev.
        if (item.get${entityName}() != null ){
         if (!item.get${entityName}().get${keyField?cap_first}().equals(prevParent)){
          itemsFromMap = new ArrayList<${entityName}>();
          prevParent=item.get${entityName}().get${keyField?cap_first}();
         }
        }
        // skip if no parent, else Map parent key, child details as a list of details ie jay as key 
        //  but value as a list of ronnie,rian (itemsFromMap
        if (item.get${entityName}() != null){
         itemsFromMap.add(item);
         itemsMap.put(item.get${entityName}().get${keyField?cap_first}(), itemsFromMap);
        }
       }
      }
      return itemsMap;
     }

    <#if (menuAttributesp2?contains("1A"))>
     public TreeNode newNodeWithChildren(Fpxxfq1a5xwwqqhxxxxxitem ttParent, TreeNode parent){
          TreeNode newNode= new DefaultTreeNode(ttParent, parent);
          for (Fpxxfq1a5xwwqqhxxxxxitem tt : this.getSortedByParentList("all")){
               TreeNode newNode2= newNodeWithChildren(tt, newNode);
          }
          return newNode;
     }

     public TreeNode getRootNode() {
         return rootNode;
     }

     public void setRootNode(TreeNode node) {
         rootNode = node;
     }


     public Map<String, List<${entityName}> > getItemsSIMap(){
      //item=getResultList().get(0);
        List<${entityName}> itemsFromMap = null;
      if (itemsMap==null){
       itemsMap = new HashMap<String, List<${entityName}>>();
         setMaxResultsVal(1200);
         setOrderColumn("${entityName?lower_case}.${entityName?lower_case}.${keyField}");
       for (${entityName} item : getResultList()) {
        // skip if no parent, capture child detail if type SI-D and save parent as prev.
        if (item.get${entityName}() != null ){
         if ( item.get${entityName}().get${keyField?cap_first}() != prevParent){
          itemsFromMap = new ArrayList<${entityName}>();
          prevParent=item.get${entityName}().get${keyField?cap_first}();
         }
        }
        // skip if no parent, else Map parent key, child details as a list of details ie jay as key 
        //  but value as a list of ronnie,rian (itemsFromMap
        if (item.get${entityName}() != null && item.getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
         itemsFromMap.add(item);
         itemsMap.put(item.get${entityName}().get${keyField?cap_first}(), itemsFromMap);
        }
       }
      }
      return itemsMap;
     }
   </#if>

	private Integer prevParentSid = null;
	public List<String> getItemsMapKeys(String type) {
	List<String> parents = new ArrayList<String>();
	for (${entityName} item : getSortedByParentList(type)) {
 	 if (item.get${entityName}() != null ) {
          // save in parents list only if the parent's parent is highest ie it has no parent
          if (item.get${entityName}().get${entityName}()==null){
	   if (item.get${entityName}().getA0xxuobxbxxxxxxxxxxxsid() != prevParentSid) {
            parents.add(item.get${entityName}().get${keyField?cap_first}());
	    prevParentSid = item.get${entityName}().getA0xxuobxbxxxxxxxxxxxsid();
           }
          }
         }
        }
	return parents;
	}

    <#if (menuAttributesp2?contains("1A"))>
	public List<String> getItemsSIMapKeys() {
	List<String> parents = new ArrayList<String>();
	for (${entityName} item : getSortedByParentList("SI-D")) {
        if (item.get${entityName}() != null && item.getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
          // save in parents list only if the parent's parent is highest ie it has no parent
          if (item.get${entityName}().get${entityName}()==null){
	   if (item.get${entityName}().getA0xxuobxbxxxxxxxxxxxsid() != prevParentSid) {
            parents.add(item.get${entityName}().get${keyField?cap_first}());
	    prevParentSid = item.get${entityName}().getA0xxuobxbxxxxxxxxxxxsid();
           }
          }
         }
        }
	 return parents;
	}
    </#if>

     String searchPattern="xyz.."; 
	public String getSearchPattern() {
		return searchPattern;
	}

	public void setSearchPattern(String searchPattern) {
		this.searchPattern = searchPattern;
	}

     String searchPatternU="xyz.."; 
	public String getSearchPatternU() {
		return searchPatternU;
	}

	public void setSearchPatternU(String searchPatternU) {
		this.searchPatternU = searchPatternU;
	}


	public String getSearchedList(String st) {
                // called by home page find search as action method and string return value will reload
                // the page itemdetailsBrowse or IssuedetailsBrowse
                // sresults is used to hold search results
		// param st is s shop or b bug or p picture or h theme or l for blog or lS System blogs . 
                // if prod fs restrict results for pictures 
                // for bugs, include entries if misccode1 matches logonId
                // for system blogs added param lS ie SYSTEM  if space in searchPattern replace
                // with % so abc xyz will become %abc%xyz
                // include subcodesn and n2 bugs use it for tags and cart use it for colour material etc
          String logonId=customIdentity.getUsername();
          String owner=customIdentity.getOwner();
          String foundS="";
          String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
          List<Yxxxuq1m1xwwqqqxxxxxclobdata> cresults=null;
          if(searchPattern.trim().isEmpty()){
           searchPattern="xyz..";
          }
          searchPattern=searchPattern.replaceFirst(" ","%"); 

          try{
           if (st.equals("b")){//bugs from issueBrowse page
            sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.y2xxuxxrbvxxxxxxxxxxmisccode1='' or cc.zexxutoxlhxxxxxxxxxxowner =:owner ) AND (cc.c6xxusxrbv16xxxxxxxxtype like 'IB%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IQ%'  ) AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE  lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )))  order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("logonId", logonId).setParameter("owner", owner).setFirstResult(0).getResultList();
            if (sresults.isEmpty()){
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty"),""));

             return "Home";
            }else
            {
              return "";
            }
           } 
           if (st.equals("s")){//site search from home page or from ItemDetails page
            if(productCode.equals("f") && subProductCode.equals("b")){
             sresults = getEntityManager()
             .createQuery(
              "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.y2xxuxxrbvxxxxxxxxxxmisccode1='' or cc.zexxutoxlhxxxxxxxxxxowner =:owner ) AND (cc.c6xxusxrbv16xxxxxxxxtype like 'IB%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IQ%'  ) AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE  lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )))  order by cc.a0xxukixbxxxxxxxxxxxmatcode")
               .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("logonId", logonId).setParameter("owner", owner).setFirstResult(0).getResultList();
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+sresults.size()+" "+bundle.getString("result(s)")+" "+bundle.getString("in")+" "+bundle.getString("isuues")+" "+bundle.getString("items"),""));
            }
            //shopping items first
            sresults = getEntityManager()
		 .createQuery(
                 <#if menuAttributesp2?contains("1A")>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )) order by cc.${keyField}")
                 <#elseif menuAttributesp2?contains("19")>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbvxxxxxxxxxxmatcodetemp) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                 <#else>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c5xxuxxrbv37xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukaxbvxxxxxxxxxxactivitycode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                 </#if> 
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+sresults.size()+" "+bundle.getString("result(s)")+" "+bundle.getString("in")+" "+bundle.getString("shopping")+" "+bundle.getString("items"),""));
                 if (viewId.contains("ItemDetails")) {
                  return null;
                 }
                 // if home page ie site search then continue in blogs/bugs/inventory now
                 sresults = getEntityManager()
                 .createQuery(
                 <#if menuAttributesp2?contains("1A")>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype like 'BI%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IB%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IX%') AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                 <#elseif menuAttributesp2?contains("19")>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbvxxxxxxxxxxmatcodetemp) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                 <#else>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c5xxuxxrbv37xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukaxbvxxxxxxxxxxactivitycode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                 </#if> 
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
                 if (sresults.isEmpty()){
                  // search in clob now , remove 19 now obsolete
                  cresults = getEntityManager()
		  .createQuery(
                  <#if menuAttributesp2?contains("1A")>
		   "select cc from Yxxxuq1m1xwwqqqxxxxxclobdata cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (lower(cc.a1xxuxxxbv49xxxxxxxxfromkey) LIKE   lower(concat ('%',:p2,'%')) OR lower(cc.a1xxuxxxbv49xxxxxxxxfromkey) LIKE   lower(concat ('%',:p3,'%')) ) AND lower(cc.b1xxuzaxbvxxxxxxxxxxdata) LIKE   lower(concat ('%',:pattern,'%')) ) ")
                  <#elseif menuAttributesp2?contains("19")>
		   "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbvxxxxxxxxxxmatcodetemp) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                  <#else>
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c5xxuxxrbv37xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukaxbvxxxxxxxxxxactivitycode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
                  </#if> 
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("p2", "POLICY").setParameter("p3", "3R-").getResultList();  
                   if (cresults.isEmpty()){
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_ERROR,bundle.getString("Search")+" "+bundle.getString("result")+" "+bundle.getString("empty")+", "+bundle.getString("pattern")+" "+bundle.getString("used")+" "+bundle.getString("%")+searchPattern+bundle.getString("%")+", "+bundle.getString("press")+" "+bundle.getString("Reset")+" "+bundle.getString("search")+" "+bundle.getString("before")+" "+bundle.getString("next")+" "+bundle.getString("search"),""));
                    //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      //FacesMessage.SEVERITY_ERROR,bundle.getString("Click")+" "+bundle.getString("on")+" "+bundle.getString("HOME")+", "+bundle.getString("to")+" "+bundle.getString("reload")+" "+bundle.getString("menu")+", "+bundle.getString("if")+" "+bundle.getString("needed"),""));
                    return null;
                   }else{
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+cresults.size()+" "+bundle.getString("result(s)")+" "+bundle.getString("in")+" "+bundle.getString("Text")+" "+bundle.getString("document"),""));
                    foundS=cresults.get(0).getA1xxuxxxbv49xxxxxxxxfromkey().substring(3)+", "+cresults.get(0).getB1xxuzaxbvxxxxxxxxxxdata();
                    foundS=Jsoup.parse(foundS).text();
                    if(foundS.length()>119){
                     foundS=foundS.substring(0,119);
                    } 
            
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+foundS,""));
                    if(cresults.size()>1){
                     foundS=cresults.get(1).getA1xxuxxxbv49xxxxxxxxfromkey().substring(3)+", "+cresults.get(0).getB1xxuzaxbvxxxxxxxxxxdata();
                     foundS=Jsoup.parse(foundS).text();
                     if(foundS.length()>119){
                      foundS=foundS.substring(0,119);
                     }              
                     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+foundS+", "+bundle.getString("press")+" "+bundle.getString("Reset")+" "+bundle.getString("search")+" "+bundle.getString("before")+" "+bundle.getString("next")+" "+bundle.getString("search"),""));
                    }
                    //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      //FacesMessage.SEVERITY_ERROR,bundle.getString("Click")+" "+bundle.getString("on")+" "+bundle.getString("HOME")+", "+bundle.getString("to")+" "+bundle.getString("reload")+" "+bundle.getString("menu")+", "+bundle.getString("if")+" "+bundle.getString("needed"),""));
                    return null;//stay same page and no reload

                   }

                 }else{
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+sresults.size()+" "+bundle.getString("result(s)")+" "+bundle.getString("in")+" "+bundle.getString("blogs")+", "+bundle.getString("use")+" "+bundle.getString("sort")+" "+bundle.getString("or")+" "+bundle.getString("browser")+" "+bundle.getString("search")+" "+bundle.getString("to")+" "+bundle.getString("locate")+" "+bundle.getString("faster"),""));
                   foundS=sresults.get(0).getB1xxuszsbvxxxxxxxxxxdescript();
                   if(foundS.length()>119){
                    foundS=foundS.substring(0,119);
                   }             
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+foundS,""));
                   if(sresults.size()>1){
                    foundS=sresults.get(1).getB1xxuszsbvxxxxxxxxxxdescript();
                    if(foundS.length()>119){
                     foundS=foundS.substring(0,119);
                    }             
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+foundS,""));
                   }
                    //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                      //FacesMessage.SEVERITY_ERROR,bundle.getString("Click")+" "+bundle.getString("on")+" "+bundle.getString("HOME")+" "+bundle.getString("or")+" "+bundle.getString("Reset")+" "+bundle.getString("search")+" "+bundle.getString("to")+" "+bundle.getString("continue"),""));
                   return null;//stay same page and no reload
                 }

            }else{
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+sresults.size()+" "+bundle.getString("result(s)")+" "+bundle.getString("in")+" "+bundle.getString("shopping")+" "+bundle.getString("items"),""));
             foundS=sresults.get(0).getB1xxuszsbvxxxxxxxxxxdescript();
             if(foundS.length()>119){
              foundS=foundS.substring(0,119);
             }             
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+foundS,""));
             if(sresults.size()>1){
              foundS=sresults.get(1).getB1xxuszsbvxxxxxxxxxxdescript();
              if(foundS.length()>119){
               foundS=foundS.substring(0,119);
              }             
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+foundS,""));
             }
             //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              //FacesMessage.SEVERITY_ERROR,bundle.getString("Click")+" "+bundle.getString("on")+" "+bundle.getString("HOME")+" "+bundle.getString("or")+" "+bundle.getString("Reset")+" "+bundle.getString("search")+" "+bundle.getString("to")+" "+bundle.getString("continue"),""));
             return null;//stay same page and no reload
            }
           }
           if (st.equals("p")){//picture
            //where (owner2 AND type like pic AND (matcode OR descript...))) AND ( miscode miscode2))) )
            if(productCode.equals("f") && subProductCode.equals("s")){
		sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'PI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) ) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'PI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )) order by cc.${keyField}")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
            }
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty"),""));
                 return "";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("check")+" "+bundle.getString("search")+" "+bundle.getString("result")+", "+bundle.getString("scroll")+" "+bundle.getString("down"),""));
                 return "";
            }
           }
           if (st.equals("l")){//blogs
            //where (owner2  AND type like blog AND (matcode OR descript...))) AND ( miscode miscode2))) )
            if(productCode.equals("f") && subProductCode.equals("s")){
		sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) ) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )) order by cc.${keyField}")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
            }
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty"),""));
                 return "";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("check")+" "+bundle.getString("search")+" "+bundle.getString("result")+", "+bundle.getString("scroll")+" "+bundle.getString("down"),""));
                 return "";
            }
           }
           if (st.equals("lS")){
            //where (owner2 is SYSTEM AND type like blog AND (matcode OR descript...))) AND ( miscode miscode2))) )
            if(productCode.equals("f") && subProductCode.equals("s")){
		sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", "SYSTEM").setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
		   .setParameter("pattern", searchPattern).setParameter("owner2", "SYSTEM").getResultList();
            }
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty"),""));
                 return "";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("check")+" "+bundle.getString("search")+" "+bundle.getString("result")+", "+bundle.getString("scroll")+" "+bundle.getString("down"),""));
                 return "";
            }
           }

           if (st.equals("h")){
            //where (owner2 AND type like shopping AND (matcode OR descript...))) AND ( miscode miscode2))) )
            // if theme it means owner2 for item is raaspi (clobdata in SYSTEM) 
            if(productCode.equals("f") && subProductCode.equals("s")){
		sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", masterSiteCode).setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.${itemDescript}) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.${keyField}")
		   .setParameter("pattern", searchPattern).setParameter("owner2", masterSiteCode).getResultList();
            }
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty"),""));
                 return "";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO, bundle.getString("check")+" "+bundle.getString("search")+" "+bundle.getString("result")+", "+bundle.getString("scroll")+" "+bundle.getString("down"),""));
                 return "";//same page but content will show result because if searchpattern is not null sreults returned
            }
           }
          
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("call")+" "+bundle.getString("invalid")+" "+st,""));

           return "";
         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("search")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return "";
         }

	}

	public String getSearchedList(String type, String parent) {
		// xxxxxxxxx logic not complete and not used just return the view value for now
		List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND  cc.fpxxuq1a5xitem.a0xxukixbxxxxxxxxxxxmatcode = :parent AND (cc.a0xxukixbxxxxxxxxxxxmatcode LIKE  :pattern OR cc.${itemDescript} LIKE  :pattern  OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 LIKE  :pattern)) order by cc.${keyField} ")
		   .setParameter("type", type).setParameter("parent", parent).setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
           return "ItemDetailsBrowse";
	}

<#if (menuAttributesp2?contains("1A")) >
        public Integer getThemeDetailsForCatOrViaSubBrowseListCnt(int sid){
         //itemdetails filters out TH
         //return getItemDetailsForCatOrViaSubBrowseListCnt(sid);
           String type="SI-D";   
           String type2="SI-L1";//categoey   
           category=sid;      
     	   List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).setParameter("category", sid)
                                       .getResultList();

         return results.size();

        }

        public Integer getItemDetailsForCatOrViaSubBrowseListCnt(int sid){
           String type="SI-D";   
           String type2="SI-L1";//categoey   
           category=sid;      
     	   List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", sid)
					.getResultList();

         return results.size();
        }

        <#assign itemTypePropertyName= "c6xxusxrbv16xxxxxxxxtype">

	public List<${entityName}> getItemCategoriesBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getItemBrowseList();
        }

	public List<${entityName}> getItemSubCategoriesBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getItemSubBrowseList();
        }

	public List<${entityName}> getItemDetailsBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getItemDetailsBrowseList();
        }


	public List<${entityName}> getItemBrowseList() {

    //* @see getItemDetailsBrowseList meant for details List, this one for parents or grandparents 
    // if cat is 0 or subcat has any value then return SI-L1 ie cats only
    // if cat has a value then return that category , same as sid to Entity method

           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       // show all (if parecode=0 or subcode has value or subcode3 has value), show specific if parentcode has value,
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="SI-L1";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
       if (params.get("subcategory3") != null &&  !params.get("subcategory3").isEmpty()){ 
	   subcategory3 = Integer.parseInt(params.get("subcategory3"));
       }

      start=category;
      type="SI-L1";
       String owner2CodeS="SYSTEM";


      try{
       //select * from genapp.item where type='SI-D' and owner2='raasbackoffice' order by case when subcodesn is null then ''  else subcodesn end,case when subcodesn2 is null then ''  else subcodesn2 end,matcode
       if (category == 0 ||subcategory != 0 ||subcategory3 != 0){
          // show all parents items ie SI-L1 types and ordered by  if subcodesn is null orderby was not selecting, so dont use
                if(itemTagType != null && !itemTagType.isEmpty()){
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   searchVal="";
                   itemTagType="";//reset before next call 
                   return results;

                }
                if(searchVal !=null && !searchVal.isEmpty()){//
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   searchVal="";
                   itemTagType="";//reset before next call 
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).getResultList();
                   searchVal="";
                   itemTagType="";//reset before next call 
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c2fbcxxrehxxsxxxxxxxspriceffdt <= :toDay AND cc.h1xxcxxrbxxxxxxxxxxxeffdate >= :toDay AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("toDay", toDay).setParameter("type", type).getResultList();
                   return results;

                }
                if(sortByValue.equals(" i")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).getResultList();
                   return results;
                }

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));


           return null;
       }
	}


        public Integer getBlogDetailsForCatOrViaSubBrowseListCnt(int sid){
           String type="BI-D";   
           String type2="BI-L1";//categoey   
           category=sid;      
     	   List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", sid)
					.getResultList();

         return results.size();
        }

    /**
    * The following method allows to call getBlogSubBrowseList by passing subCategory
    * sid as method parameter rather than page parameter 
    * @return List of item entities whose parent matches subcategory sid or subcategory entities if category
    * has sid but subCat has no sid 
    * @exception no select result or select failed. 
    * @see 
    *  added to support bootstrap like ui
    */ 

	public List<${itemEntityName?cap_first}> getBlogSubDetBrowseList(int sid) {
         subcategoryUi=sid;
         return getBlogSubBrowseList();
        }

	public List<${itemEntityName?cap_first}> getBlogCatSubBrowseList(int sid) {
         subcategoryUi=0;
         categoryUi=sid;

         return getBlogSubBrowseList();
        }

    /**
    * @return List of non details if category and subcategory is 0 
    * if subcatUi has value then return details under it 
    * @exception no select result or select failed. 
    * @see 
    */ 

	public List<${entityName}> getBlogSubBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getBlogDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // show specific children subcodes if parentcode has non 0 value, show specific subcode 
       //           if subcode has a value

       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="BI-L*";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
       //
       if(categoryUi !=0){
         category=categoryUi;
       }
       if(subcategoryUi !=0){
         subcategory=subcategoryUi;
       }

      start=category;
      //category=0;
      type="BI-L*";
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }

      try{
       if (category == 0 && subcategory == 0 && subcategory3 == 0 && subcategoryUi == 0){
                if(itemTagType != null && !itemTagType.isEmpty()){
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;

                }

          // 
          //
          // return null;
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
           return results;
       }
       if(subcategoryUi !=0){
         subcategory=subcategoryUi;
       }
       // return details under this sub
       if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
		    .getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only but dont use sid only check for ownwr2

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
	}




	public List<${entityName}> getBlogBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getBlogBrowseList();
        }


	public List<${entityName}> getBlogDetailsBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getBlogDetailsBrowseList();
        }


	public List<${entityName}> getBlogBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
          // use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Map<String,String> params = 
       facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="BI-L1";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
        type = params.get("type");
       }
      start=category;
      type="BI-L1";
       boolean showSystemR=false;
       String owner2CodeS="SYSTEM";
       try{
        Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
	.createQuery(
	 "select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	.setParameter("nKeyName","01")
	.setParameter("owner2", owner2Code)
	.getSingleResult();
       showSystemR=client.getZ4xxfxxxbvxxxxxxxxxxlistbuilde();
       if(showSystemR){
        owner2CodeS="SYSTEM";
       }else{
        owner2CodeS=owner2Code;
       }
      } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+ bundle.getString("client")+" "+owner2Code+" "+ bundle.getString("record")+": "+ e.getMessage(),""));
         return null;
      }

      try{
       //select * from genapp.item where type='BI-D' and owner2='raasbackoffice' order by case when subcodesn is null then ''  else subcodesn end,case when subcodesn2 is null then ''  else subcodesn2 end,matcode
       if (category == 0){
                if(itemTagType != null && !itemTagType.isEmpty()){//
                 searchVal="#"+itemTagType;
                 List<${itemEntityName?cap_first}> results = getEntityManager()
                 .createQuery(
                  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
                   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";//reset before next call 
                   return results;

                }

                if(searchVal !=null && !searchVal.isEmpty()){//
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";//reset before next call 
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("toDay", toDay).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals(" i")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                   return results;
                }

          // show all parents items ie BI-L1 types and ordered by 
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                return results;
       }
       else {
          // category has parent code, so that parent item only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));


           return null;
       }
      }

	public List<${entityName}> getSystemBlogBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="BI-L1";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=category;
      type="BI-L1";
      String owner2CodeS="SYSTEM";
      try{
       //select * from genapp.item where type='BI-D' and owner2='raasbackoffice' order by case when subcodesn is null then ''  else subcodesn end,case when subcodesn2 is null then ''  else subcodesn2 end,matcode
       if (category == 0){
          // show all parents items ie BI-L1 types and ordered by 
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2S", owner2CodeS)
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2S", owner2CodeS).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));


           return null;
       }
      }




	public List<${entityName}> getThemeBrowseList(String vendor,String theme) {
           // separate method calls are needed otherwise cannot filter out Category and details
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
	   // use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       // removed subcodesn  added parameters to filter to support click-xxx xhtml
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="SI-L1";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=category;
      type="SI-L1";
      String owner2CodeS="SYSTEM";

      if(vendor.isEmpty() && !theme.isEmpty()){ 
       return getSuggestListTheme("",theme);//
      }

      try{
       if (category == 0){
          // show all parents items ie SI-L1 types and ordered by 
                if(vendor != null && !vendor.isEmpty()){//
                 searchVal="#"+vendor;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("toDay", toDay).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals(" i")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").getResultList();
                   return results;
                }

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
                .getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("category")+" "+bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));


           return null;
       }
     }

	public List<${entityName}> getSubThemeBrowseList(String vendor,String theme) {
           
           // separate method calls are needed otherwise cannot filter out Category and details
           // since theme items can reside only in raaspi,
           // harcode owner2Code to raaspi, allows demo sites to show subthemes and details but not main
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       // removed subcodesn
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="SI-L*";
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=subcategory;
      type="SI-L*";

      try{
       if (subcategory == 0){
          // show all parents items ie SI-L* types and ordered by 
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
              .getResultList();
           return results;
       }
       else {
          // subcategory has parent code, so that parent item only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2", masterSiteCode).setParameter("category", subcategory).setParameter("type", type).setParameter("flag", mclosed)
              .getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("subcategory")+" "+bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));


           return null;
       }
     }


    /**
    * The following method called by ItemDetailsBrowse,Blog and Image to support breadcrumbs
    * parameter via url categoryJay 
    * @return List of item cat or subcat sibling entities related to detail item selected 
    * @exception no select result or select failed tbd
    * @see 
    *  added to support bootstrap like ui
    */ 
	public List<${itemEntityName?cap_first}> getBlogCatAndSubBrowseList() {
               String type="BI-L%";
          int categoryJay=0;
          int nSidP=0;
          List<${itemEntityName?cap_first}> results =null;

          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
          facesContext.getExternalContext().getRequestParameterMap();
          if (params.get("categoryJay") != null &&  !params.get("categoryJay").isEmpty()){ 
	   categoryJay = Integer.parseInt(params.get("categoryJay"));
           //if detail then gets its cat and subs (if any) under the cat
           //if subcat then get subs under the parent cat ie siblings
           //if cat then get show the all subcats under it  
           if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() == null){//cat get its subs
                type="BI-L1";
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
			.getResultList();
   
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("BI-L*") 
             && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() != null){//subcat get its siblings
                type="BI-L*";
                nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();

            }else{
             if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().contains("BI-D") 
              && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() != null){//direct cat or subcat exists
                type="BI-L%";
                if(getSidToEntity(categoryJay).get${itemEntityName?cap_first}().get${itemEntityName?cap_first}()==null){
                 nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
                }else{//get sub's parent
                 nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
                }
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
          }
          
           return results;

        }



    /**
    * The following method allows to call getBlogDetailsBrowseList by passing category 
    * sid as method parameter rather than page parameter 
    * @return List of item entities all details if category sid is 0 or specific details for a category sid
    * subcat items are excluded
    * @exception no select result or select failed. 
    * @see 
    *  added to support bootstrap like ui. Note categoryUi or subcategoryui sids
    * uniquely identifies details under it no need for categoryUi and subCategoyUi together 
    */ 

	public List<${itemEntityName?cap_first}> getBlogDetailsForCatOrViaSubBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=-1;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

	public List<${itemEntityName?cap_first}> getBlogDetailsForSubOnlyBrowseList(int sid) {
         subcategoryUi=sid;
         categoryUi=0;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }
	public List<${itemEntityName?cap_first}> getBlogDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }
 
       public List<${itemEntityName?cap_first}> getBlogDetailsAllBrowseList(int sid) {
         categoryUi=0;
         subcategoryUi=-2;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }


    /**
    * The following method selects shopping details based on category and subcategory 
    * called by BlogDetailsBrowse.xhtml which is used for online shopping 
    * @return List of item entities
    * @exception no select result or select failed. 
    * @see 
    * added additional sort logic for price etc
    */ 
     public List<${entityName}> getBlogDetailsBrowseList() {
	   // for SI types only, use price later for less than range
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used then show search results 
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){//searchpattern is set by search button and will show search results
        return sresults;
       }
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="BI-%";//all shopping only ie detail or category or subcategory
       String type2="BI-L%";//categoey or subcategory
       boolean showSystemR=false;
       String owner2CodeS="SYSTEM";
       try{
        Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
	.createQuery(
	 "select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	.setParameter("nKeyName","01")
	.setParameter("owner2", owner2Code)
	.getSingleResult();
       showSystemR=client.getZ4xxfxxxbvxxxxxxxxxxlistbuilde();
       if(showSystemR){
        owner2CodeS="SYSTEM";
       }else{
        owner2CodeS=owner2Code;
       }
      } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+ bundle.getString("client")+" "+owner2Code+" "+ bundle.getString("record")+": "+ e.getMessage(),""));
         return null;
      }
       //get all details whose parent (cat or subcat) is catsubJay
       if (params.get("catsubJay") != null &&  !params.get("catsubJay").isEmpty()
          && (subcategoryUi ==0 && categoryUi ==0)
          && (itemTagType == null || itemTagType.isEmpty())){ 
	  int catsubJay = Integer.parseInt(params.get("catsubJay"));
          type="BI-D";
          List<Fpxxfq1a5xwwqqhxxxxxitem> results =null;

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", catsubJay)
			.getResultList();
            return results;
       }

       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
           // all shopping details except fees either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
       if(categoryUi !=0){
         category=categoryUi;
       }

       if(subcategoryUi >=0){
         subcategory=subcategoryUi;
       }
       //-1 means direct under cat or 1 level down under a sub for same cat sid
       //-2 means ignores cat sid, sets as 0 and is used as alias for getItemDetailsBrowseList() but direct meaning ...All
       if(subcategoryUi ==-2 || subcategoryUi ==-1){
         subcategory=0;
       }

      try{
       if (category == 0 ){
                if(itemTagType != null && !itemTagType.isEmpty()){//
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }

                // not search below, here if search. changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
                if(searchVal2 !=null && !searchVal2.isEmpty()){// include if parent misccode1 is null  added type check
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (( (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.${itemEntityName}.y2xxuxxrbvxxxxxxxxxxmisccode1 is null or cc.${itemEntityName}.y2xxuxxrbvxxxxxxxxxxmisccode1 = '') and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).setParameter("searchVal", searchVal2).getResultList();
                   //searchVal="";
                   return results;
                }
       }
       if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  (cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("subcategory", subcategory)
			.getResultList();
           return results;
       }
       if (category == 0 ){
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
              if(subcategoryUi == -1){
               //include where cat is parent or as grandparent
               //category has value , so so all details under it , including one level down ie under any subcat
                // show details if under this cat and under this subcat
     	        List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;

              }else{

                // show details only not sub category item
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                   return results;
              }
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }




    /**
    * The following method selects shopping details based on category and subcategory 
    * called by itemDetailsBrowse.xhtml which is used for online shopping 
    * @return List of item entities
    * @exception no select result or select failed. 
    * @see 
    * added additional sort logic for price etc
    */ 
    public List<${entityName}> getSystemBlogDetailsBrowseList() {
    // for SI types only, use price later for less than range
    // category for hierarchy order and type for what to include
    // category 0 means ignore parentcode
       // if search was used then show search results 
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return sresults;
       }
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="BI-%";//all shopping only ie detail or category or subcategory
       String type2="BI-L%";//categoey or subcategory
       String owner2CodeS="SYSTEM";

       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
           // all shopping details except fees either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
      try{
        if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  (cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2S", owner2CodeS).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
       if (category == 0 ){
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
                // show details only not sub category item
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }





	public List<${entityName}> getItemDetailsFeesList() {
		// use price later for less than range
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used then show search results 
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       String type="SI-F";
       if (params.get("detailType") != null ){ 
	   type="SI-F";
       }
       if (type.equals("SI-F")){
                // if fees, show details only no category or sub category item
        try{
		List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type)
					.getResultList();
           return results;
        } catch ( NoResultException ignore){
           return null;
        } catch ( Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
        }
       }else{
         return null;
       }
     }


	public List<${entityName}> getItemDetailsPaidList() {
	 // shows all offerings and may be suitable for back office
         // for customer we need to use a subset of this and obtained by getItemSearchByParameterList
         // save the parameters in userprofl and retrieve them to requery
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used then show search results 
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return sresults;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="FI-D";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }

           // all shopping details except fees either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
      try{
        if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
       if (category == 0 ){
                // first time ? allways show something, if empty h:command wont submit because it was not rendered before
                // will show upto first 10 details  
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid !=null ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc").setMaxResults(10)
		   .setParameter("type", type).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
       }
       else {
                // show details only not sub category item
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("category", category)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }

    /**
    * The following method allows to call getItemSubBrowseList by passing subCategory
    * sid as method parameter rather than page parameter 
    * @return List of item entities whose parent matches subcategory sid or subcategory entities if category
    * has sid but subCat has no sid 
    * @exception no select result or select failed. 
    * @see 
    *  added to support bootstrap like ui
    */ 

       public List<${itemEntityName?cap_first}> getItemSubDetBrowseList(int sid) {
         subcategoryUi=sid;
         return getItemSubBrowseList();
        }

    /**
    * The following method shows theme categories and subcategories and called from siteEditEasy/homePageEdtor/homeOtherPagesEdtr view gallery button >ThemesBrowseClient.wflow
    * no method parameter 
    * ???page parameter type SI-L , categoryJay and sid
    * @return List of item entities whose parent matches subcategory sid or subcategory entities if category
    * has sid but subCat has no sid 
    * @exception no select result or select failed. 
    * @see getThemeDetailsBrowseList
    * Need to allow SYSTEM records so that tenant sites can show theme gallery/sub gallery  items same reason as theme blobs and clobs are  SYSTEM
    */ 
          public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeCatAndSubBrowseList() {
          String type="SI-L%";
          int categoryJay=0;
          int nSidP=0;
          List<Fpxxfq1a5xwwqqhxxxxxitem> results =null;

          FacesContext facesContext = FacesContext.getCurrentInstance();
          Map<String,String> params = 
          facesContext.getExternalContext().getRequestParameterMap();
          if (params.get("categoryJay") != null &&  !params.get("categoryJay").isEmpty()){ 
           categoryJay = Integer.parseInt(params.get("categoryJay"));
           //if detail then gets its cat and subs (if any) under the cat
           //if subcat then get subs under the parent cat ie siblings
           //if cat then get show the all subcats under it  
           if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() == null){//cat get its subs
                type="SI-L1";
                results = getEntityManager()
                .createQuery(
                 "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  OR cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND  cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH' AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
                 .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
                 .getResultList();
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("SI-L*") 
             && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//subcat get its siblings
                type="SI-L*";
                nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                results = getEntityManager()
                .createQuery(
                "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  OR cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH' AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
               .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
              .getResultList();
            }else{
             if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().contains("SI-D") 
              && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//direct cat or subcat exists
                type="SI-L%";
                if(getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem()==null){
                 nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                }else{//get sub's parent
                 nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                }
               results = getEntityManager()
               .createQuery(
               "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  OR cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH' AND   cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
               .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
               .getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  OR cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH' AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
          }
          
           return results;

        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeCatSubBrowseList(int sid) {
         subcategoryUi=0;
         categoryUi=sid;

         return getThemeSubBrowseList();
        }



	public List<${itemEntityName?cap_first}> getItemCatSubBrowseList(int sid) {
         subcategoryUi=0;
         categoryUi=sid;

         return getItemSubBrowseList();
        }

    /**
    * The following method called by ItemDetailsBrowse,Blog and Image to support breadcrumbs
    * parameter via url categoryJay 
    * @return List of item cat or subcat sibling entities related to detail item selected 
    * @exception no select result or select failed tbd
    * @see 
    *  added to support bootstrap like ui
    */ 
	public List<${itemEntityName?cap_first}> getItemCatAndSubBrowseList() {
               String type="SI-L%";
          int categoryJay=0;
          int nSidP=0;
          List<${itemEntityName?cap_first}> results =null;

          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
          facesContext.getExternalContext().getRequestParameterMap();
          if (params.get("categoryJay") != null &&  !params.get("categoryJay").isEmpty()){ 
	   categoryJay = Integer.parseInt(params.get("categoryJay"));
           //if detail then gets its cat and subs (if any) under the cat
           //if subcat then get subs under the parent cat ie siblings
           //if cat then get show the all subcats under it  
           if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() == null){//cat get its subs
                type="SI-L1";
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
			.getResultList();
   
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("SI-L*") 
             && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() != null){//subcat get its siblings
                type="SI-L*";
                nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();

            }else{
             if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().contains("SI-D") 
              && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() != null){//direct cat or subcat exists
                type="SI-L%";
                if(getSidToEntity(categoryJay).get${itemEntityName?cap_first}().get${itemEntityName?cap_first}()==null){
                 nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
                }else{//get sub's parent
                 nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
                }
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
          }
          
           return results;

        }


    /**
    * @return List of non details if category and subcategory is 0 
    * if subcatUi has value then return details under it 
    * @exception no select result or select failed. 
    * @see 
    */ 

	public List<${entityName}> getItemSubBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // show specific children subcodes if parentcode has non 0 value, show specific subcode 
       //           if subcode has a value

       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="SI-L*";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
       //
       if(categoryUi !=0){
         category=categoryUi;
       }
       if(subcategoryUi !=0){
         subcategory=subcategoryUi;
       }

      start=category;
      //category=0;
      type="SI-L*";
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }

      try{
       if (category == 0 && subcategory == 0 && subcategory3 == 0 && subcategoryUi == 0){
                if(itemTagType != null && !itemTagType.isEmpty()){
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;

                }

          // 
          //
          // return null;
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
           return results;
       }
       if(subcategoryUi !=0){
         subcategory=subcategoryUi;
       }
       // return details under this sub
       if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
		    .getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only but dont use sid only check for ownwr2

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
	}


	public List<${entityName}> getItemSub3BrowseList() {
           // added,jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       // show specific children subcodes3 if subcode has value, show specific subcode3 
       //           if subcode3 has a value

       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       subcategory=0;
       String type="SI-L3";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
       if (params.get("subcategory3") != null &&  !params.get("subcategory3").isEmpty()){ 
	   subcategory3 = Integer.parseInt(params.get("subcategory3"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=subcategory;
      //category=0;
      type="SI-L3";
      try{
       // always show top level & details until a categord
       if (category == 0 && subcategory == 0 && subcategory3 == 0){
          // 
           return null;
       }
       if(subcategory != 0) {
          // category has subcode code, so get its children L3
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", subcategory).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       if (subcategory3 != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory3)
					.getResultList();
           return results;
       }

       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
           return null;
	}


	public List<${entityName}> getItemSubPaidList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="FI-L*";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=category;
      //category=0;
      type="FI-L*";
      try{
       if (category == 0){
          // 
           return null;
       }
       else {
          // category has parent code, so that parent item only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
	}

        // 
        public Integer getImageDetailsForCatOrViaSubBrowseListCnt(int sid){
           String type="PI-D";   
           String type2="PI-L1";//categoey   
           category=sid;      
     	   List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", sid)
					.getResultList();

         return results.size();
        }

    /**
    * The following method allows to call getImageSubBrowseList by passing subCategory
    * sid as method parameter rather than page parameter 
    * @return List of item entities whose parent matches subcategory sid or subcategory entities if category
    * has sid but subCat has no sid 
    * @exception no select result or select failed. 
    * @see 
    *  added to support bootstrap like ui
    */ 

       public List<${itemEntityName?cap_first}> getImageSubDetBrowseList(int sid) {
         subcategoryUi=sid;
         return getImageSubBrowseList();
        }

	public List<${itemEntityName?cap_first}> getImageCatSubBrowseList(int sid) {
         subcategoryUi=0;
         categoryUi=sid;

         return getImageSubBrowseList();
        }


	public List<${entityName}> getImageBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getImageBrowseList();
        }


	public List<${entityName}> getImageDetailsBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getImageDetailsBrowseList();
        }


	public List<${entityName}> getImageCategoriesBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getImageBrowseList();
        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeCategoriesBrowseList(String type) {
         itemTagType="";
         if(type.equals("promo")){
          itemTagType="promo";
         }
         if(type.equals("sale")){
          itemTagType="sale";
         }
         if(type.equals("coupon")){
          itemTagType="coupon";
         }
         return getThemeBrowseList("","");
        }

	public List<${entityName}> getImageBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="PI-L1";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=category;
      type="PI-L1";

      try{
       //select * from genapp.item where type='PI-D' and owner2='raasbackoffice' order by case when subcodesn is null then ''  else subcodesn end,case when subcodesn2 is null then ''  else subcodesn2 end,matcode
       if (category == 0){
                if(itemTagType != null && !itemTagType.isEmpty()){//
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }

                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals(" i")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }

          // show all parents items ie PI-L1 types and ordered by 
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only.  no need to sort for one item
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));


           return null;
       }
      }


    /**
    * The following method called by ItemDetailsBrowse,Blog and Image to support breadcrumbs
    * parameter via url categoryJay 
    * @return List of item cat or subcat sibling entities related to detail item selected 
    * @exception no select result or select failed tbd
    * @see 
    *  added to support bootstrap like ui
    */ 
	public List<${itemEntityName?cap_first}> getImageCatAndSubBrowseList() {
               String type="PI-L%";
          int categoryJay=0;
          int nSidP=0;
          List<${itemEntityName?cap_first}> results =null;

          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
          facesContext.getExternalContext().getRequestParameterMap();
          if (params.get("categoryJay") != null &&  !params.get("categoryJay").isEmpty()){ 
	   categoryJay = Integer.parseInt(params.get("categoryJay"));
           //if detail then gets its cat and subs (if any) under the cat
           //if subcat then get subs under the parent cat ie siblings
           //if cat then get show the all subcats under it  
           if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() == null){//cat get its subs
                type="PI-L1";
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
			.getResultList();
   
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("PI-L*") 
             && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() != null){//subcat get its siblings
                type="PI-L*";
                nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();

            }else{
             if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().contains("PI-D") 
              && getSidToEntity(categoryJay).get${itemEntityName?cap_first}() != null){//direct cat or subcat exists
                type="PI-L%";
                if(getSidToEntity(categoryJay).get${itemEntityName?cap_first}().get${itemEntityName?cap_first}()==null){
                 nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
                }else{//get sub's parent
                 nSidP=getSidToEntity(categoryJay).get${itemEntityName?cap_first}().get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
                }
		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
          }
          
           return results;

        }



	public List<${entityName}> getImageSubBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
		// use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="PI-L*";
       String type2="PI-L*";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
      start=category;
      //category=0;
      type="PI-L*";
      try{
       if (category == 0){
          // 
           return null;
       }
       else {
          // category has parent code, so that parent item only but dont use sid only
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.${statusFlagField} != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
      }

     public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeSubBrowseList() {
           //jay any method called by a4j:repeat will get called by each repeat, so use a switch so that initial result is returned
           // without db call
          // use price later in where clause for less than range, use sid in desc order to show recent addrd ones first
           // params category,type are shared by this and getItemDetailsBrowseList method. 
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // show specific children subcodes if parentcode has non 0 value, show specific subcode 
       //           if subcode has a value

       // if search was used show details only because may have diff parents  
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return null;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       int start=0;
       category=0;
       String type="SI-L*";
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("type") != null){ 
	  type = params.get("type");
       }
       //
       if(categoryUi !=0){
         category=categoryUi;
       }
       if(subcategoryUi !=0){
         subcategory=subcategoryUi;
       }

      start=category;
      //category=0;
      type="SI-L*";
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }

      try{
       if (category == 0 && subcategory == 0 && subcategory3 == 0 && subcategoryUi == 0){
                if(itemTagType != null && !itemTagType.isEmpty()){
                 searchVal="#"+itemTagType;
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;

                }

               List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
               .createQuery(
                "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
                .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("flag", mclosed)
                 .getResultList();
           return results;
       }
       if(subcategoryUi !=0){
         subcategory=subcategoryUi;
       }
       // return details under this sub
       if (subcategory != 0 ){
       List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
       .createQuery(
        "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
        .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("subcategory", subcategory)
        .getResultList();
          return results;
       }
       else {
          // category has parent code, so that parent item only but dont use sid only check for ownwr2

       List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
       .createQuery(
        "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
        .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("category", category).setParameter("type", type).setParameter("flag", mclosed)
        .getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
   }


	public List<${entityName}> getIssueBrowseList() {
           // if search was used then show search results, issues do not use category but allows two types
           // so no parent type checking involved. misccode1 can have a user logon id and in that case its 
           // rendered for that logon id and the owner only 
           String type1="IB";
           String type2="IQ";
           String type="";
           String logonId=customIdentity.getUsername();
           String owner=customIdentity.getOwner();


           if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
            return sresults;
           }
                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner) )  ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner) ) ) ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ) ) ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  )))  AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("mi")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2) AND  (cc.zexxutoxlhxxxxxxxxxxowner =:owner)  )) order by cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }


           if(this.markedOnes){
		 List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ) AND cc.${statusFlagField} != :flag  AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2)
                           .setParameter("flag", mclosed).setParameter("logonId", logonId)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
           else{
		 List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ) AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
     }

	public List<${entityName}> getIssueRepliesList(int parentSid) {
                // pagination is done by main table
		List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :pSid  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("pSid", parentSid).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
     }

    /**
    * The following method returns upto 6 items whose type is SI-L1
    * In reality it will return only 1 record since for now only one dummy CI-L1 is created
    * @param args Unused.
    * @return one record which is a dummy CI-L1 , There is no option to create CI-L1 by user
    *  option to add new CI-L1 added
    * @exception none but should be added jay
    * called by itemsReviewSelect
    * @see 
    * 
    */
	public List<${entityName}> getReviewBrowseList() {
           
           // if search was used then show search results 
           String type1="CI-L1";
           String type2="CI-L1";

           if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
            return sresults;
           }
           if(this.markedOnes){
		 List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND cc.${statusFlagField} != :flag  AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2)
                           .setParameter("flag", mclosed)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
           else{
		 List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
     }

	public List<${entityName}> getReviewRepliesList(int parentSid) {
                // pagination is done by main table
		List<${entityName}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :pSid  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("pSid", parentSid).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
     }
    public String selectCategory() {
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }

     return "";
    }
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeDetailsForCatOrViaSubBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=-1;
         sresults=getThemeDetailsBrowseList("","");
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

    /**
    * The following method allows to call getItemDetailsBrowseList by passing category 
    * sid as method parameter rather than page parameter 
    * @return List of item entities all details if category sid is 0 or specific details for a category sid
    * subcat items are excluded
    * @exception no select result or select failed. 
    * @see 
    *  added to support bootstrap like ui. Note categoryUi or subcategoryui sids
    * uniquely identifies details under it no need for categoryUi and subCategoyUi together 
    */ 

	public List<${itemEntityName?cap_first}> getItemDetailsForCatOrViaSubBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=-1;
         sresults=getItemDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

         public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeDetailsForSubOnlyBrowseList(int sid) {
         subcategoryUi=sid;
         categoryUi=0;
         sresults=getThemeDetailsBrowseList("","");
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

        public List<${itemEntityName?cap_first}> getItemDetailsForSubOnlyBrowseList(int sid) {
         subcategoryUi=sid;
         categoryUi=0;
         sresults=getItemDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

        public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getThemeDetailsBrowseList("","");
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 

        }

       public List<${itemEntityName?cap_first}> getItemDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getItemDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

       public List<${itemEntityName?cap_first}> getItemDetailsAllBrowseList(int sid) {
         categoryUi=0;
         subcategoryUi=-2;
         sresults=getItemDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }


    /**
    * The following method selects shopping details based on category and subcategory 
    * if parameters are all 0 then returns all items type SI-D
    * if cat is 0 but subcat has value then returns SI-D whose parent is the subcat
    * if subcat is 0 but cat has value then returns SI-D whose parent is Cat ignores those under subcat
    * if bot cat and subcat has value then returns SI-D whose parent matches cat or parent matches subcat
    * 
    * called by itemDetailsBrowse.xhtml which is used for online shopping 
    * @return List of item entities
    * @exception no select result or select failed. 
    * @see getItemBrowseList seems no difference except name is vague. This should replace any call to getItemBrowseList
    * @see getItemSubBrowseList seems like a subset of this. This should replace any call to getItemSubBrowseList 
    *  added additional sort logic for price etc
    * check misccodes to filter out non theme items
    *   
    */ 
	public List<${entityName}> getItemDetailsBrowseList() {
	   // for SI types only, use price later for less than range
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode ie all details with parentcode of SI-L1
       // if search was used then show search results 
       // show specific children details of subcodes3 if subcode3 has value, show specific children
       //           details of subcode if subcode3 list is null or size 0 and subcode has a value 
       //           show first few details if category is 0 or specific children details if parentcode has value
       //           (can happen if no subcodes or L3 for that parent)
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return sresults;
       }
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="SI-%";//all shopping only ie detail or category or subcategory
       String type2="SI-L%";//categoey or subcategory
       String type3="SI-L3";//category level3
       String typeSub="SI-L*";
       // get all details whose parent (cat or subcat) is catsubJay
       if (params.get("catsubJay") != null &&  !params.get("catsubJay").isEmpty()
          && (subcategoryUi ==0 && categoryUi ==0)
          && (itemTagType == null || itemTagType.isEmpty())){ 
	  int catsubJay = Integer.parseInt(params.get("catsubJay"));
          type="SI-%";// to include SI-(q)
          List<Fpxxfq1a5xwwqqhxxxxxitem> results =null;

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", catsubJay)
			.getResultList();
            return results;
       }

       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
       if (params.get("subcategory3") != null &&  !params.get("subcategory3").isEmpty()){ 
	   subcategory3 = Integer.parseInt(params.get("subcategory3"));
       }
           // all shopping details except fees either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
       //following overides or mutually exclusive to parameter passed values

       if(categoryUi !=0){
         category=categoryUi;
       }

       if(subcategoryUi >=0){
         subcategory=subcategoryUi;
       }
       //-1 means direct under cat or 1 level down under a sub for same cat sid
       //-2 means ignores cat sid, sets as 0 and is used as alias for getItemDetailsBrowseList() but direct meaning ...All
       if(subcategoryUi ==-2 || subcategoryUi ==-1){
         subcategory=0;
       }

      try{
        if (subcategory3 != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH' AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory3)
					.getResultList();
           return results;
        }
        if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype = :type AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", typeSub).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
        }


       // check for SI-L1
       // show detail if 3rd level selected
       if (category == 0 && subcategory == 0 && subcategory3 == 0 && categoryUi == 0){
                // check if type L3 exists then show L3 not L2 
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory, added parent in sort

                if(itemTagType != null && !itemTagType.isEmpty()){
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }


                if(searchVal2 !=null && !searchVal2.isEmpty()){//
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where ( (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  and (cc.${itemEntityName}.y2xxuxxrbvxxxxxxxxxxmisccode1 is null or cc.${itemEntityName}.y2xxuxxrbvxxxxxxxxxxmisccode1 = '') and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("type2", type2).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal2).getResultList();
                   //searchVal="";
                   return results;
                }
                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  AND  (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  AND  (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.c2fbcxxrehxxsxxxxxxxspriceffdt <= :toDay AND cc.h1xxcxxrbxxxxxxxxxxxeffdate >= :toDay)  order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
              if(subcategoryUi == -1){
               //include where cat is parent or as grandparent
               //category has value , so so all details under it , including one level down ie under any subcat
                // show details if under this cat and under this subcat
     	        List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;

              }else{
                // cat as parent only
     	        List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;
              }
       }
      } catch ( NoResultException ignore){
           return null;
      } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
      }
     }



    /**
    * The following method selects shopping details based on category and subcategory 
    * called by itemDetailsBrowse.xhtml which is used for online shopping 
    * @return List of item entities
    * @exception no select result or select failed. 
    * @see 
    *  added additional sort logic for price etc
    * check misccodes to filter out non theme items
    */ 
     public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeDetailsBrowseList(String vendor,String theme) {
      // for SI types only, use price later for less than range
      // category for hierarchy order and type for what to include
      // category 0 means ignore parentcode
       // if search was used then show search results 
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return sresults;
       }
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Map<String,String> params = 
       facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="SI-%";//all shopping only ie detail or category or subcategory
       String type2="SI-L%";//categoey or subcategory

      if(vendor.isEmpty() && !theme.isEmpty()){ 
       return getSuggestListTheme("",theme);//
      }
       // get all details whose parent (cat or subcat) is catsubJay
       if (params.get("catsubJay") != null &&  !params.get("catsubJay").isEmpty()
          && (subcategoryUi ==0 && categoryUi ==0)
          && (vendor == null || vendor.isEmpty())){ 
          int catsubJay = Integer.parseInt(params.get("catsubJay"));
          type="SI-D";
          List<Fpxxfq1a5xwwqqhxxxxxitem> results =null;

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", catsubJay)
			.getResultList();
            return results;
       }


       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
           // all shopping details except fees either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
      try{
                if(searchVal2 !=null && !searchVal2.isEmpty()){// include if parent misccode1 is null
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH' ) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("searchVal", searchVal2).getResultList();
                   //searchVal="";
                   return results;
                }

        if (subcategory != 0 ){
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("subcategory", subcategory)
                                       .getResultList();
           return results;
       }
       // check for PI-L1 ,category 0 means all , exclude not empty miscoded1 ie challenge one, limit details less clutter
       //
       if(categoryUi !=0){
         category=categoryUi;
       }

       if(subcategoryUi >=0){
         subcategory=subcategoryUi;
       }
       //-1 means direct under cat or 1 level down under a sub for same cat sid
       //-2 means ignores cat sid, sets as 0 and is used as alias for getItemDetailsBrowseList() but direct meaning ...All
       if(subcategoryUi ==-2 || subcategoryUi ==-1){
         subcategory=0;
       }

       if (category == 0 ){
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
                if(vendor !=null && !vendor.isEmpty()){//
                 searchVal="#"+vendor;
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn ='TH' ) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''   AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''    AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''    AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''    AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("cb")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''    AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.y2xxuxxrbvxxxxxxxxxxmisccode1 asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("su")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''    AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("gu")){
                 
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''    AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else substring( cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3,locate(cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3,'/') ) end asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }



		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
                // show details only not sub category item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
                                       .getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("details")+" "+bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }

    /**
    * The following method allows to call getImageDetailsBrowseList by passing category 
    * sid as method parameter rather than page parameter 
    * @return List of item entities all details if category sid is 0 or specific details for a category sid
    * subcat items are excluded
    * @exception no select result or select failed. 
    * @see 
    *  added to support bootstrap like ui. Note categoryUi or subcategoryui sids
    * uniquely identifies details under it no need for categoryUi and subCategoyUi together 
    */ 

	public List<${itemEntityName?cap_first}> getImageDetailsForCatOrViaSubBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=-1;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

	public List<${itemEntityName?cap_first}> getImageDetailsForSubOnlyBrowseList(int sid) {
         subcategoryUi=sid;
         categoryUi=0;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }
	public List<${itemEntityName?cap_first}> getImageDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

	public List<${itemEntityName?cap_first}> getImageDetailsAllBrowseList(int sid) {
         categoryUi=0;
         subcategoryUi=-2;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }



	public List<${entityName}> getImageDetailsBrowseList() {
		// use price later for less than range
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used then show search results 
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return sresults;
       }
       FacesContext facesContext = FacesContext.getCurrentInstance();
       Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="PI-%";//all shopping only ie detail or category or subcategory
       String type2="PI-L%";//categoey or subcategory
       // get all details whose parent (cat or subcat) is catsubJay
       if (params.get("catsubJay") != null &&  !params.get("catsubJay").isEmpty()
          && (subcategoryUi ==0 && categoryUi ==0)
          && (itemTagType == null || itemTagType.isEmpty())){ 
	  int catsubJay = Integer.parseInt(params.get("catsubJay"));
          type="PI-D";
          List<Fpxxfq1a5xwwqqhxxxxxitem> results =null;

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", catsubJay)
			.getResultList();
            return results;
       }

       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
           // all shopping details except fees either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
      try{
        if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
       // check for PI-L1 ,category 0 means all , exclude not empty miscoded1 ie challenge one, limit details less clutter
       //
       if(categoryUi !=0){
         category=categoryUi;
       }

       if(subcategoryUi >=0){
         subcategory=subcategoryUi;
       }
       //-1 means direct under cat or 1 level down under a sub for same cat sid
       //-2 means ignores cat sid, sets as 0 and is used as alias for getItemDetailsBrowseList() but direct meaning ...All
       if(subcategoryUi ==-2 || subcategoryUi ==-1){
         subcategory=0;
       }
       if (category == 0 ){
                if(itemTagType != null && !itemTagType.isEmpty()){//
                 searchVal="#"+itemTagType;
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }

                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory, added parent in sort
                setMaxResultsVal(6);
                if(sortByValue.equals("bm")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("ai")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2 AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'a' AND 'i'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2 AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2 AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
              if(subcategoryUi == -1){
               //include where cat is parent or as grandparent
               //category has value , so so all details under it , including one level down ie under any subcat
                // show details if under this cat and under this subcat
     	        List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;

              }else{

                // show selected details only not sub category item
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;
              }
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }
	public List<${entityName}> getImageDetailsBrowseListS(Integer category,Integer subcategory) {
        //xxListS for slide, category and subcategory are sid integers
       String type="PI-%";//all shopping only ie detail or category or subcategory
       String type2="PI-L%";//categoey or subcategory

      try{
        if (subcategory != 0 ){
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
                // show selected details only not sub category item
		List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
           return results;
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }



        <#if menuAttributesp2?contains("19")>
         <#assign itemEntityName=itemEntityNameSave>
        </#if>



	public List<${entityName}> getItemSearchByParameterList() {
         // seq 0  vendor will use ItemEdit to add item with type approval. Need to allow quantity to be spefied by vendor
         //        in addition to backoffice receive
         // seq 1  sponsorfind (itemdetailsGet) calls the other searchbyparameter and stores parameter in userprofl
         // seq 1b cart icon is shown, if not empty will show allow3 count
         // seq 2  sponsorselect (PaidSelect) calls this method to retrieve selection parameters and redo selections
         //        and returns list, if enough quantity exists and status 0
         // seq 2b after sponsorselect the basket icon is shown and clicking it will call basketout to requst approval
         // seq 3  cbasketin (getApprovedList) vbasketin (getVendorApproved) shows status
         // seq 4  basketout uses cartedList(basket) to show the selected items and show in different forms to customer and                //        vendor (approver)
         //        orderdetail's items's owner is checked to filter out other vendor items 
         // seq 5  vendor will approve/reject if reject item quantity increased, approved goes down 
         //        if logged in then retrieve param values saved in userprofl margin for amount,mtstyle for criteria,ststyle
         //        for type
         BigDecimal amount=new BigDecimal("0.0");
         String zone="";
         String criteria ="";
         String type ="";
         List<${entityName}> results=null;
         if (identity.isLoggedIn()){
           ${userproflEntityName}=${userEntityName}List.getUserProfiles();
         }
         if(${userproflEntityName} !=null){
          amount=${userproflEntityName}.getE3xxzxxxlvxxxxxxxxxxmargin(); 
          zone=${userproflEntityName}.getD3xxuxxrbvxxxxxxxxxxdtstyle();
          criteria=${userproflEntityName}.getD1xxuxxrbvxxxxxxxxxxmtstyle();           
          type=${userproflEntityName}.getD2xxuxxrbvxxxxxxxxxxststyle(); 
         }else{
          return null;
         }                                                          
         results = getItemSearchByParameterList(zone,amount,criteria,type);
         if(results != null){
           this.paramResultsCount=results.size();
         }
         return results;
        }
    /**
    * returns sponsor search results
    * called frequently by home menu render check for FI-D items and indirectly by ItemsPaidSelect.xhtml which calls getItemSearchByParameterList()
    * which in turn calls this method
    * @param args -sponsorship search zone,amount,criteria,type, but checks parameters as needed, so multiple queries in sequence  
    *  user allow3 (string) replaced by userprofl footer which is decimal
    * userprof footer is used to check enough fees paid or not
    * userprofl margin is used to store the amount,dtstyle stores zone,mtstyle stores criteria, ststyle stores type 
    * and used by getItemSearchByParameterList() 
    * @return items size 0 to higher or null
    * @exception 
    * @see 
    * check same temp user or not, customIdentity is per session and values are for each session and is sss to start with
    * only sss means no temp or parmanent user yet 
    */

	public List<${entityName}> getItemSearchByParameterList(String zone,BigDecimal amount,String criteria,String type) {
                 if (!identity.isLoggedIn()){
                     if(customIdentity.getOwner().equals("sss")){
                      String ts=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                      subKey=ts.substring(17,19)+ts.substring(14,16)+ts.substring(11,13)+ts.substring(0,7)+userIP;
                      ownerCode=subKey+"sss";
                      customIdentity.setOwner(ownerCode);
                      // create temp customer record
 	              if (${customerEntityName} == null) {
 	               ${customerEntityName}=${customerEntityName}Home.getInstance();
	              }

                      ${customerEntityName}.setA0xxukxxbvxxxxxxxxxxcustomer(subKey);
                      ${customerEntityName}.setZdxxutoxlhxxxxxxxxxxowner(ownerCode);
                      ${customerEntityName}.setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                      ${customerEntityName}.setF2xxuwmxbv40xxxxxxxxintegrset("DEFAULT");
                      ${customerEntityName}Home.persist();

                      // create temp user record 
 	              if (${userEntityName} == null) {
 	               ${userEntityName}=${userEntityName}Home.getInstance();
	              }
  
                      ${userEntityName}.setA0xxukuxbvxxxxxxxxxxid(subKey);
                      ${userEntityName}.set${customerEntityName?cap_first}(${customerEntityName});
                      ${userEntityName}.setZ5xxutoxlhxxxxxxxxxxowner(ownerCode);
                      ${userEntityName}.setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                      ${userEntityName}Home.persist();
                      customIdentity.setOwner(ownerCode);
                      // set currentUserName to this temp user 
                      ///customIdentity.getCredentials().setUsername(subKey);
                      customIdentity.setUserSid(${userEntityName}.getA0xxuobxbxxxxxxxxxxxsid());
                     
                   }
                  }
                  //end of temp user logic
          this.showResultsCount=true;
          List<${entityName}> results=null;

          try {
           //12 zone
           if(zone == null || zone.equals("")){
            //13 criteria null zone null
            if(criteria == null || criteria.equals("")){
             if(type == null || type.equals("")){
              results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("owner2", owner2Code).getResultList();

             }else{
              results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("type", type).setParameter("owner2", owner2Code).getResultList();
             }
            //13 criteria
            }else{
            //criteria not null zone null
             if(type == null || type.equals("")){
              results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("criteria", criteria).setParameter("owner2", owner2Code).getResultList();

             }else{
              results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("criteria", criteria).setParameter("type", type).setParameter("owner2", owner2Code).getResultList();
             }
            }
           //12 zone not null
           }else{
            //zone not null criteria null
             if(criteria == null || criteria.equals("")){
              if(type == null || type.equals("")){
               results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("owner2", owner2Code).getResultList();

              }else{
               results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("type", type).setParameter("owner2", owner2Code).getResultList();
              }
             }else{
             //zone not null criteria not null
              if(type == null || type.equals("")){
               results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("criteria", criteria).setParameter("owner2", owner2Code).getResultList();

              }else{
               results = getEntityManager()
		 .createQuery(
		  "select cc from ${entityName} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.${itemQtyField} > 0 ) order by cc.${keyField}")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("criteria", criteria).setParameter("type", type).setParameter("owner2", owner2Code).getResultList();
              }
            //13
            }
           //12
           }                         
         } catch ( NoResultException nre){
          results=null;
          return results;
         } catch ( Exception e){
          results=null;
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

          return results;
         }
          this.paramResultsCount=results.size();
          //get user record first
            if(${userEntityName} ==null){
 		${userEntityName} = (${userEntityName?cap_first}) getEntityManager()
 					.createQuery(
 							"select cc from ${userEntityName?cap_first} cc where cc.a0xxuobxbxxxxxxxxxxxsid = :usersid and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
 					.setParameter("usersid", customIdentity.getUserSid())
 					.setParameter("owner2", owner2Code)
 					.getSingleResult();
           }
          //save params in userprofl
          try{
           //
           if (!identity.isLoggedIn()){
                 return null;
           } 
	   ${userproflEntityName}  =  (${userproflEntityName?cap_first}) getEntityManager()
					.createQuery(
							"select cc from ${userproflEntityName?cap_first} cc where   cc.a0xxuobxbxxxxxxxxxxxsid=:logonid  and cc.b1xxuxxrbvxxxxxxxxxxrow=:row  and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("logonid", customIdentity.getUserSid())
					.setParameter("row", "00")
                                        .setParameter("owner2", owner2Code)
					.getSingleResult();
           // get allow3 amount first
           if(${userproflEntityName}.getE4xxzxxxlvxxxxxxxxxxfooter()!=null){
            allow3Amount=${userproflEntityName}.getE4xxzxxxlvxxxxxxxxxxfooter();
           }

           ${userproflEntityName}.setE3xxzxxxlvxxxxxxxxxxmargin(amount);           
           ${userproflEntityName}.setD3xxuxxrbvxxxxxxxxxxdtstyle(zone);           
           ${userproflEntityName}.setD1xxuxxrbvxxxxxxxxxxmtstyle(criteria);           
           ${userproflEntityName}.setD2xxuxxrbvxxxxxxxxxxststyle(type);
           ${userproflEntityName}Home.setInstance(${userproflEntityName});
           ${userproflEntityName}Home.update();
           ${userproflEntityName}Home.clearInstance();

	  } catch (NoResultException e) {
           //create record

           ${userproflEntityName}=${userproflEntityName}Home.getInstance();
           ${userproflEntityName}.set${userEntityName?cap_first}(${userEntityName});
           ${userproflEntityName}.setB1xxuxxrbvxxxxxxxxxxrow("00");
           ${userproflEntityName}.setE3xxzxxxlvxxxxxxxxxxmargin(amount);           
           ${userproflEntityName}.setD3xxuxxrbvxxxxxxxxxxdtstyle(zone);           
           ${userproflEntityName}.setD1xxuxxrbvxxxxxxxxxxmtstyle(criteria);           
           ${userproflEntityName}.setD2xxuxxrbvxxxxxxxxxxststyle(type);                                                                      ${userproflEntityName}Home.setInstance(${userproflEntityName});
           ${userproflEntityName}Home.persist();
           ${userproflEntityName}Home.clearInstance();

          } catch (Exception e) {
			log.severe("Error accessing userprofl"+ e);
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("user")+" "+ bundle.getString("profile")+" "+ bundle.getString("access")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));
            return null;

         }
          return results;
        }


</#if>

<#if (menuAttributesp2?contains("1A")) >
    /**
    * method is used for getting a count of all not closed and invoiced but not (paid or shipped)  orders of type cart
    * called by myDashboard
    * @return list of customer orders 
    * @param args  none
    * @exception tbd
    */ 


     public Integer getAllCartedCount(){
		List<${cuordersEntityName?cap_first}> results =  getEntityManager()
		 .createQuery("select cc from ${cuordersEntityName?cap_first} cc where cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((cc.zcxxzzfxhhxxxxxxxxxxstatusfl = :si or cc.zcxxzzfxhhxxxxxxxxxxstatusfl < :sp) and cc.zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc) order by cc.a0xxuobxbxxxxxxxxxxxsid")
                .setParameter("owner2", owner2Code).setParameter("si", minvoiced).setParameter("sp", mpaid).setParameter("sc", mclosed).
                 setParameter("type", "cart").getResultList();
                return results.size();

     }

    /**
    * method is used for getting a list of order details which are on a cart but not checkedOut
    * called by checkout(cart),cartItem(cart),cart(cart) and checkoutPOS(pos),cartPOS(pos)
    * cartPOS and checkoutPOS uses the same method    
    * order term null/blank not paid or checkedOut
    * POS point of sale cash/credit and pickup/delivery) done by sales agent
    * @return list of customer orders 
    * @param args  type cart, pos. cart means order type cart but terms not pos, pos means order type cart but terms is pos
    * @exception tbd
    * @see getBasketedList type basket
    * @see getConfirmedCartedList for prePaid/invoiced checkedOut orders with terms not null
    */ 
    public List<${cuodetailsEntityName?cap_first}> getCartedList(String type) {
       // meant for a customer ie show records for a customer 
       // carted but < paid or not toPay or not in basket for fi- but not vendor approved/rejected ie less than minvoiced (64)
      // carted and not paid  or closed after invoiced/payment
      // ownerCode needs to be reread from customIdentity or reinject list?
      // part 1 gets order for a customer if status < 16  ie  active 1 waiting confirmation and 2nd part gets otder details for that order
      //  added COP/COD  removed singleresult  added codcop check
      ownerCode=customIdentity.getOwner();
      ${cuordersEntityName?cap_first} ${cuordersEntityName}=null;
      List<${cuordersEntityName?cap_first}> results=null;
      //order term null/blank or POS or pp > PrePay and PickUp, pd > PrePay and Delivery, np > ToPay and PickUp, cd > ToPay and Delivery 
      // ui has pp but backend has as PrePay and PickUp   
      try{
          if (type.equals("cart")){
                //terms initially will be null after confirm to cart and will not be changed until checkout done
            String terms1="PrePay and%";
            String terms2="ToPay and%";
		results=  getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl = :ma  and (c2xxcxxxbv09xxxxxxxxterms is null or c2xxcxxxbv09xxxxxxxxterms = '' or c2xxcxxxbv09xxxxxxxxterms like :terms1 or c2xxcxxxbv09xxxxxxxxterms like :terms2 ))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("terms1", terms1).setParameter("terms2", terms2).setParameter("type", type).setParameter("ma", mactive).getResultList();
         }else{
          if (type.equals("pos")){
                type="cart";
                //customer at POS checkout after in store shopping or for preordered pickup, included shipped
		results=  getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and (((zcxxzzfxhhxxxxxxxxxxstatusfl = :sh or zcxxzzfxhhxxxxxxxxxxstatusfl < :s) and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is not  null and c2xxcxxxbv09xxxxxxxxterms != '' and c2xxcxxxbv09xxxxxxxxterms ='POS')))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("sh", mshipped).setParameter("s", mpaid).setParameter("sc", mclosed).getResultList();
          }else{
            //following not used 
            if (type.equals("basket")){
		results= getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mclosed).getResultList();
            }else{
                // basketCI
		results= getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mclosed).getResultList();
            }
           }
          }
          if(results.isEmpty()){
           return null;
          }
          if(results.size() >1 && (type.equals("pos") || type.equals("cart"))){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_INFO,bundle.getString("multiple")+" "+bundle.getString("orders")+" "+bundle.getString("entries")+" "+bundle.getString("exist"),""));
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_ERROR,bundle.getString("CHECKOUT")+" "+bundle.getString("will")+" "+bundle.getString("show")+" "+bundle.getString("one")+" "+bundle.getString("order")+", "+bundle.getString("close")+" "+bundle.getString("if")+" "+bundle.getString("needed"), ""));
          }

          ${cuordersEntityName}=results.get(0);//get oldest


           if (type.equals("cart") || type.equals("pos")){
            // support not show deleted (256) status
            return
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.${lineField} != :s AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", ${cuordersEntityName}.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).setParameter("s", -1).getResultList();  
           }else{
            return
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid  AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", ${cuordersEntityName}.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).getResultList();  
           }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           // to add logic if not single then delete from details and then order for all except paid and latest cid and return latest
           // check how emty cart works
           //log.severe("${'#'}{messages['getCartedList']}"+ e);
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("cartedList")+" "+bundle.getString("type")+" "+type,""));

           return null;
       }
     }

	public List<${cuodetailsEntityName?cap_first}> getCartedItemTypeList(String type,String itemType) {
                // meant for a customer ie show how many digital , pick up , si-d etc 
		// carted but < paid or in basket for fi- but not vendor approved/rejected ie less than minvoiced (64)
                // carted and not paid  or closed after invoiced/payment
                // ownerCode needs to be reread from customIdentity or reinject list?
                // part 1 gets order for a customer if status < 16  ie  active 1 waiting confirmation and 2nd part gets otder details for that order
                // 
      ownerCode=customIdentity.getOwner();
      ${cuordersEntityName?cap_first} ${cuordersEntityName}=null;
      try{
          if (type.equals("cart")){
                //customer is purchasing shopping items
		${cuordersEntityName}= (${cuordersEntityName?cap_first}) getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).getSingleResult();
          }else{
           if (type.equals("basket")){
                //customer looking at it and will see all status ie 0 (to request) to 512 (final approved)
                // final ie manager/vendor approved 512 (to allow manager to have final say in case dispute etc or better                 // commision)
                // status 32 to 256 will be shown as pending final approval
                // once all processed status will be 8 ie mclosed
		${cuordersEntityName}= (${cuordersEntityName?cap_first}) getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mclosed).getSingleResult();
           }else{
                // basketCI
		${cuordersEntityName}= (${cuordersEntityName?cap_first}) getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mclosed).getSingleResult();
           }
          }
           if (type.equals("cart")){
            // support not show deleted (256) status
            return
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:itemType and cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.${lineField} != :s AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", ${cuordersEntityName}.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).setParameter("itemType", itemType).setParameter("s", -1).getResultList();  
           }else{
            return
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid  AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", ${cuordersEntityName}.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).getResultList();  
           }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           // to add logic if not single then delete from details and then order for all except paid and latest cid and return latest
           // check how emty cart works
           //log.severe("${'#'}{messages['getCartedList']}"+ e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
     }

    /**
    * method is used to get a list orderdetails for current cartOrder for a wner, where payLater condition is involved, meaning order term being ToPay .. or involves
    * item which is type SI-C meaning extra cod charge
    *   called by getCartedPayDelMiscLaterTotal(),getCartedPayDelMiscLaterTotal(), getCartedPayTaxLaterTotal, getTotalCartedPayLater
    *   ,getTotalCartedPayBaseLater()
    * @return null or List
    * @param arg type value cart, 
    * @exception noresult and general exception
    */
      public List<${cuodetailsEntityName?cap_first}> getCartedPayLaterList(String type) {
        // carted but not to be paid now ie if matcode type is SI-C or some cond like no payment api in client
        // ownerCode needs to be reread from customIdentity or reinject list?  cod/cop
        // get details directly
      ownerCode=customIdentity.getOwner();
      List<Trexuq244xwwqqhxxxxxcuorders> currentCartOrder = this.getCurrentCartOrder(type);
      if(currentCartOrder.size() == 0){
       return null;
      }
      if(currentCartOrder.get(0) !=null && !(currentCartOrder.get(0).getC2xxcxxxbv09xxxxxxxxterms().contains("ToPay and Delivery"))){
       return null;
      } 
      Integer cosid=currentCartOrder.get(0).getA0xxuobxbxxxxxxxxxxxsid();
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl < :s and cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms like 'ToPay and%' ) OR cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype) AND cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("mtype", "SI-C").setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("sid", cosid).getResultList();  


       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           // to add logic if not single then delete from details and then order for all except paid and latest cid and return latest
           // check how emty cart works
           log.severe("${'#'}{messages['getCartedList']}"+ e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));


           return null;
       }
     }
    /**
    * method is used to get total Del and Misc charge for a payLater order. The del/misc charges were added manually at order creation time
    * calls getCartedPayLaterList()
    @see   getCartedPayDelMiscLaterTotal(),getCartedPayDelMiscLaterTotal(), getCartedPayTaxLaterTotal, getTotalCartedPayLater
    @see   getTotalCartedPayBaseLater()
    * @return BigDecimal 
    * @param none
    * @exception noresult and general exception
    */

	public BigDecimal getCartedPayDelMiscLaterTotal() {
	// carted but not to be paid now ie if matcode type is SI-C order some cond(tbd)
                // ownerCode needs to be reread from customIdentity or reinject list?
                BigDecimal totalDelMiscPayLater=new BigDecimal("0.0");
                if(getCartedPayLaterList("cart") != null){
                 for (${cuodetailsEntityName?cap_first} itemOrderDetail:getCartedPayLaterList("cart") ){
                  totalDelMiscPayLater=totalDelMiscPayLater.add(itemOrderDetail.getZbxxzlxxavxxxxxxxxxxdelivchrg()).add(itemOrderDetail.getZcxxzmxxavxxxxxxxxxxmiscchrg());
                 }
                }
	return totalDelMiscPayLater;
      }
    /**
    * method is used to get total Taxes
    * calls getCartedPayLaterList()
    @see   getCartedPayDelMiscLaterTotal(),getCartedPayDelMiscLaterTotal(), getCartedPayTaxLaterTotal, getTotalCartedPayLater
    @see   getTotalCartedPayBaseLater()
    * @return BigDecimal 
    * @param none
    * @exception noresult and general exception
    */

      public BigDecimal getCartedPayTaxLaterTotal(String type) {
	// carted but not to be paid now ie if matcode type is SI-C order some cond(tbd)
                // ownerCode needs to be reread from customIdentity or reinject list?
                BigDecimal totalTaxPayLater=new BigDecimal("0.0");
                if(getCartedPayLaterList(type) != null){
                 for (${cuodetailsEntityName?cap_first} itemOrderDetail:getCartedPayLaterList(type) ){
                  totalTaxPayLater=totalTaxPayLater.add(itemOrderDetail.getZdxxzxz1avxxxxxxxxxxtax1amt()).add(itemOrderDetail.getZexxzxz2avxxxxxxxxxxtax2amt()).add(itemOrderDetail.getZfxxzxz3avxxxxxxxxxxtax3amt());
                 }
                }
		return totalTaxPayLater;
     }
    /**
    * method is used to get total COD charge by getting cod charge from rate table for each item
    * calls getCartedPayLaterList()
    @see   getCartedPayDelMiscLaterTotal(),getCartedPayDelMiscLaterTotal(), getCartedPayTaxLaterTotal, getTotalCartedPayLater
    @see   getTotalCartedPayBaseLater()
    * @return BigDecimal 
    * @param none
    * @exception noresult and general exception
    */

        // added parameter type. Charge extra only if COD ie PrePay and Delivery
            public BigDecimal getTotalCartedPayLater(String type) {
                BigDecimal totalPayLater=new BigDecimal("0.0");
                BigDecimal payLater=new BigDecimal("0.0");
                if(getCartedPayLaterList(type) != null){
                 for (${cuodetailsEntityName?cap_first} itemOrderDetail:getCartedList(type) ){
                  fpxxfq1a5xwwqqhxxxxxitem=itemOrderDetail.get${itemEntityName?cap_first}();
                  payLater=${rate1fEntityName}List.getCODCharge(fpxxfq1a5xwwqqhxxxxxitem);
                  if(!bcontinue){
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+", "+bundle.getString("cannot")+" "+bundle.getString("continue"),""));
                   return BigDecimal.ZERO;
                  }
                  totalPayLater=totalPayLater.add(payLater);
                 }
                }
	return totalPayLater;
              }

    /**
    * method is used to get total Base charges using base amount from order detail
    * calls getCartedPayLaterList()
    @see   getCartedPayDelMiscLaterTotal(),getCartedPayDelMiscLaterTotal(), getCartedPayTaxLaterTotal, getTotalCartedPayLater
    @see   getTotalCartedPayBaseLater()
    * @return BigDecimal 
    * @param none
    * @exception noresult and general exception
    */

        // now refers to COD charge for COD payment option. only if COD payment chosen
	public BigDecimal getTotalCartedPayBaseLater() {
                BigDecimal totalPayBaseLater=new BigDecimal("0.0");
                if(getCartedPayLaterList("cart") != null){
                 for (${cuodetailsEntityName?cap_first} itemOrderDetail:getCartedPayLaterList("cart") ){
                  totalPayBaseLater=totalPayBaseLater.add(itemOrderDetail.getZbxxzbxxavxxxxxxxxxxbaseamount());
                 }
                }
		return totalPayBaseLater;
	}

    /**
    * method is used to get Net Pay base total by adding TotalCartedPayLater to amountTotal
    * calls getCartedPayLaterList()
    @see   getCartedPayDelMiscLaterTotal(),getCartedPayDelMiscLaterTotal(), getCartedPayTaxLaterTotal, getTotalCartedPayLater
    @see   getTotalCartedPayBaseLater()
    * @return BigDecimal 
    * @param none
    * @exception noresult and general exception
    */

        // addded param type
        // paylater now refers to COD charge on top of shipping charge and added to base total
        public BigDecimal getNetCartedPayTotal(String type) {
                BigDecimal netPayTotal=new BigDecimal("0.0");
                if(getCurrentCartOrder(type).size() > 0){
                 if(getCurrentCartOrder(type).get(0) !=null && getCurrentCartOrder(type).get(0).getC2xxcxxxbv09xxxxxxxxterms().contains("ToPay and Delivery") 
                     && getCurrentCartOrder(type).get(0).getZ1xxztprlxxxxxxxxxxxamounttotal() !=null){
                  netPayTotal=getCurrentCartOrder(type).get(0).getZ1xxztprlxxxxxxxxxxxamounttotal().add(getTotalCartedPayLater(type));
                 }else{
                  netPayTotal=getCurrentCartOrder(type).get(0).getZ1xxztprlxxxxxxxxxxxamounttotal();
                 }
                }
	return netPayTotal;
          }
	public BigDecimal getNetInvoiceCartedPayTotal(String key) {
                BigDecimal netPayTotal=new BigDecimal("0.0");
                if(getCurrentCartInvoiceFor(key).size() > 0){
                 netPayTotal=getCurrentCartInvoiceFor(key).get(0).getZ1xxztprlxxxxxxxxxxxamounttotal();
                }
		return netPayTotal;
	}



	public List<${cuodetailsEntityName?cap_first}> getApprovedRejectedCartedList(String type) {
                // not used
		// those in basket and approved ie 32 or rejected ie 04 or paid and pending ie 16
                // owner checking will mean only user ie customer who created will see it
                // see VendorApproved..... for vendor use
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s OR ${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s2 OR trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s3)  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mpaid).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           //log.severe("${'#'}{messages['ApprovedRejectedCartedList']}"+ e);
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));
           return null;
       }
	}

    /**
    * method is used for getting a list of order details which are on a basket (fees/FI-D items,CI-D )
    * called by basketout(basket),basketoutCs(basketCI),basketoutCsAll(basketCiAll),cbasketin(basket)
    * cartPOS and checkoutPOS uses the same method    
    * terms null if card payment and delivery/pickup
    * terms COD(cd) for no pay now but cash on delivery,
    * COP no pay now but cash on pick up. done by customer
    * codcop no pay now but cash or credit card at pickup. (back office sends email when ready). done by customer 
    * POS point of sale cash/credit and pickup/delivery) done by sales agent
    * @return list of customer orders 
    * @param args  type cart, pos
    * @exception tbd
    * @see getCartedList type cart
    */ 

 public List<${cuodetailsEntityName?cap_first}> getBasketedList(String type) {
                // viewed by customer called by cbasketin for fi- items or by cbasketincase for CI items
                // return details for the latest / last order only ie order status is 1 ?   
		// those in basket put and confirmed by customer 16 mpaid or later approved/rejected by manager or by vendor
                // and not closed detail
                // details dont have owner but parent order has owner 
                // jay add agent concept ie customer should select a manager
                // added basketCiAll
      try{
          if (type.equals("basket")){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("owner", ownerCode).setParameter("s3", mclosed).getResultList();  
          }else{
           //basketCI
           if (type.equals("basketCI")){
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner  and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("owner", ownerCode).setParameter("s3", mclosed).getResultList();  
           }else{
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s3", mclosed).getResultList();  
           }
         }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));
           return null;
       }
 }

	public List<${itemEntityName?cap_first}> getItemDetailsBasketedList() {
	 // shows all offerings and may be suitable for back office
         // for customer we need to use a subset of this and obtained by getItemSearchByParameterList
         // save the parameters in userprofl and retrieve them to requery
           // category for hierarchy order and type for what to include
           // category 0 means ignore parentcode
       // if search was used then show search results 
          FacesContext facesContext = FacesContext.getCurrentInstance();
      String type="CI-D";
      if (getBasketedList("basketCI").size() == 0){//
       return null;
      }
      category=getBasketedList("basketCI").get(0).get${itemEntityName?cap_first}().getA0xxuobxbxxxxxxxxxxxsid();
      try{
        // show details only not sub category item
	List<${itemEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${itemEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("category", category)
					.getResultList();
           return results;
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }


 public List<${cuodetailsEntityName?cap_first}> getCustomerRequestedAndUpCartedList(String type) {
                // viewed by Manager called by basketin for fi- items
		// those in basket put and confirmed by customer 16 mpaid or later approved/rejected by manager or by vendor
                // and detail not closed
                // no owner checking since multiple customers are involved
                // jay add agent concept ie customer should select a manager
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND ${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl <= :s2 and cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.${cuordersEntityName}.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mpaid).setParameter("s2", mprinted).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));
           return null;
       }
 }
 public List<${cuodetailsEntityName?cap_first}> getCustomerRequestedAndUpCartedListCI(String type) {
                // viewed by Employee Analyst called by ebasketin for ci- items
		// those in basket and its order put and confirmed(mpaid) by customer >= 16  or later approved/rejected by manager !=512(mprinted)
                // no owner checking since multiple customers are involved
                // jay add agent concept ie customer should select a manager
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND ${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl <= :s2 and cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.${cuordersEntityName}.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mopen).setParameter("s2", mprinted).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
 }
	public List<${cuodetailsEntityName?cap_first}> getManagerApprovedRejectedCartedList(String type) {
                //viewed by vendor and called by vbasketin for fi- items
		// those orders in basket and manager approved ie 32 (mshipped) or vendor statused , no use showing manager rejected(4) or closed(8)
                // 512 will not have approve/reject button
                // jay no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl != :s2 AND cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.${cuordersEntityName}.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

	public List<${cuodetailsEntityName?cap_first}> getEmployeeApprovedRejectedCartedListCI(String type) {
                //viewed by manager and called by mbasketin for ci- items
		// those in basket and employee approved ie 32 or vendor? statused , no use showing manager rejected or closed
                // 512 will not have approve/reject button
                // jay no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl != :s2 AND cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.${cuordersEntityName}.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

	public List<${cuodetailsEntityName?cap_first}> getManagerApprovedRejectedCartList(String type) {
                //not used this is cartedList viewed by vendor for fi-items
		// baskets and manager approved ie 32 or vendor statused , no use showing manager rejected or closed
                // 512 will not have approve/reject button
                // jay no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC                 // offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl != :s2 AND cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

	public List<${cuodetailsEntityName?cap_first}> getManagerVendorApprovedRejectedCartedList(String type) {
                // used since checking for status 512 does the same thing, viewed by vendor for fi-items
		// those in basket and approved ie 32 or rejected 04
                // no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s OR ${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s2 OR cc.zhxxzzfxhhxxxxxxxxxxstatusfl = :s3)  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mpaid).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}



	public List<${cuodetailsEntityName?cap_first}> getVendorApprovedRejectedCartedList(String type) {
		// those in basket and approved ie 32 or rejected 04
                // no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s OR ${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s2 OR cc.zhxxzzfxhhxxxxxxxxxxstatusfl = :s3)  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mpaid).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

    /**
    * method is used for getting a list of order details which are on a cart but checkedout and terms not null
    * Excludes non checkedout order and its details
    * called by checkout(cart), and checkoutPOS(pos),cartPOS(pos)
    * cartPOS and checkoutPOS uses the same method    
    * order term POS or pp > PrePay and PickUp, pd > PrePay and Delivery, np > ToPay and PickUp, cd > ToPay and Delivery
    * POS point of sale cash/credit and pickup/delivery) done by sales agent
    * @return list of customer order details
    * @param args  type cart, pos. cart means order type cart but terms not pos, pos means order type cart but terms is pos
    * @exception tbd
    * @see getBasketedList type basket
    * @see getCartedList for cartedList but not checkedOut
    */ 

    public List<${cuodetailsEntityName?cap_first}> getConfirmedCartedList(String type) {
      try{
          if (type.equals("pos")){
           type="cart";
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms ='POS' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc)) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
         	   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", minvoiced).setParameter("sc", mclosed).getResultList();  
          }else{
           if (type.equals("cart")){
            String terms1="PrePay and%";
            String terms2="ToPay and%";
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND (cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms like :terms1 or cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms like :terms2)  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl > :ma )) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("ma", mactive).setParameter("s", minvoiced).setParameter("sc", mclosed).setParameter("terms1", terms1).setParameter("terms2", terms2).getResultList();  
           }else{
            //basketCI
            type=type.substring(0,type.length()-2);
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mpaid).getResultList();  
            }
          }
      } catch ( NoResultException ignore){
           return null;
      } catch ( Exception e){
           //log.severe("${'#'}{messages['getConfirmedCartedList']}", e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("type")+" "+type+" "+bundle.getString("paid")+" "+bundle.getString("list")+" "+bundle.getString("expected"),""));

           return null;
       }
   }


    public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getPaidCartedList(String type) {
		// carted and paid  changed to invoiced  or closed after invoiced/payment 
                // added type POS for in store POS orders
      try{
          if (type.equals("pos")){
           type="cart";
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms ='POS' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc)) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
         	   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).getResultList();  
          }else{
           if (type.equals("cart")){
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND (cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms is  null or cc.${cuordersEntityName}.c2xxcxxxbv09xxxxxxxxterms = '')  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc)) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).getResultList();  
           }else{
            //basketCI
            type=type.substring(0,type.length()-2);
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mpaid).getResultList();  
            }
          }
      } catch ( NoResultException ignore){
           return null;
      } catch ( Exception e){
           //log.severe("${'#'}{messages['getConfirmedCartedList']}", e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("type")+" "+type+" "+bundle.getString("paid")+" "+bundle.getString("list")+" "+bundle.getString("expected"),""));

           return null;
       }
   }


    public List<${cuodetailsEntityName?cap_first}> getConfirmedBasketedList(String type) {
		//  can be many cases/pffers and paid/summitted (16) only
      try{
          if (type.equals("basket")){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).getResultList();  
          }else{
            //basketCI
            type=type.substring(0,type.length()-2);
            return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.zexxutoxlhxxxxxxxxxxowner=:owner and cc.${cuordersEntityName}.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mpaid).getResultList();  
          }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           //log.severe("${'#'}{messages['getConfirmedCartedList']}", e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
   }

   public List<Xoxxuq2a4xwwqqhxxxxxcuidetails> getInvoicedCartedListFor(String key) {
	
      //type is invoicecart  leads to rendering addProductToPayment which uses paypal
      //allows customer to pay online by card for any invoiced order if they dont want to use shopping cart
      // see getInvoiceDetails(String key) for customer to pay onsite pos or via portable pos terminal 
      String type="invoicecart";
      try{
          if (key !=null && !key.isEmpty()){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2a4xwwqqhxxxxxcuidetails cc where (cc.trexuq266xwwqqhxxxxxcuinvoice.y7xxuxxrbv10xxxxxxxxtype=:type AND cc.trexuq266xwwqqhxxxxxcuinvoice.a0xxuncibvxxxxxxxxxxinvoice=:key AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.trexuq266xwwqqhxxxxxcuinvoice.zexxutoxlhxxxxxxxxxxowner=:owner or 'sss'=:owner) and cc.trexuq266xwwqqhxxxxxcuinvoice.z5xxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", minvoiced).setParameter("key", key).getResultList();  
          }else{
           //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage( //at page start up type is ""
             //FacesMessage.SEVERITY_ERROR,bundle.getString("type")+" "+bundle.getString("not")+" "+bundle.getString("invoicecart"),""));
           return null;
          }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           //log.severe("${'#'}{messages['getConfirmedCartedList']}", e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("invoice")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
   }

   public List<Xoxxuq2a4xwwqqhxxxxxcuidetails> getInvoicDetails(String key) {
	
      // used by checkoutInvoiced
      //allows customer to pay online by card for any invoiced(64) order if they dont want to use shopping cart
      // see getInvoiceDetails(String key) for customer to pay onsite pos or via portable pos terminal 
      String type="invoicecart";
      try{
          if (key !=null && !key.isEmpty()){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2a4xwwqqhxxxxxcuidetails cc where (cc.trexuq266xwwqqhxxxxxcuinvoice.a0xxuncibvxxxxxxxxxxinvoice=:key AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.trexuq266xwwqqhxxxxxcuinvoice.z5xxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner2", owner2Code).setParameter("s", minvoiced).setParameter("key", key).getResultList();  
          }else{
           //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage( //at page start up type is ""
             //FacesMessage.SEVERITY_ERROR,bundle.getString("type")+" "+bundle.getString("not")+" "+bundle.getString("invoicecart"),""));
           return null;
          }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           //log.severe("${'#'}{messages['getConfirmedCartedList']}", e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("invoice")+" "+type+" "+bundle.getString("records")+" "+bundle.getString("expected"),""));

           return null;
       }
   }



</#if>

   public List<${shipmentdetailsEntityName?cap_first}> getShippedCartedList(Integer sid) {
		// shipped items for a po ignore sid for now because we show history
      try{
         if(sid !=0){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${shipmentdetailsEntityName?cap_first} cc where (cc.z5xxuxxrbvxxxxxxxxxxcpono=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zrxxutoxlhxxxxxxxxxxowner=:owner and cc.zmxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("s", mshipped).getResultList();  
         }else{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${shipmentdetailsEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zrxxutoxlhxxxxxxxxxxowner=:owner and cc.zmxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("s", mshipped).getResultList();  
         }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           log.severe("${'#'}{messages['getShippedCartedList']}"+ e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+"shipped"+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
   }



	public List<${cuqdetailsEntityName?cap_first}> cuqdetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuqdetailsEntityName?cap_first} cc where (cc.${cuquoteEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

      // switch to entityDetailedList ????? ex ${cuordersEntityName}List.entityDetailedList(${cuordersEntityName}Home.instance.a0xxuobxbxxxxxxxxxxxsid
	public List<${cuodetailsEntityName?cap_first}> detailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<${cuidetailsEntityName?cap_first}> cuidetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${cuidetailsEntityName?cap_first} cc where (cc.${cuinvoiceEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<${vendqdetailsEntityName?cap_first}> vendqdetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${vendqdetailsEntityName?cap_first} cc where (cc.${venquoteEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<${vendodetailsEntityName?cap_first}> vendodetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${vendodetailsEntityName?cap_first} cc where (cc.${vendordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<${vendidetailsEntityName?cap_first}> vendidetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from ${vendidetailsEntityName?cap_first} cc where (cc.${vinvoiceEntityName}.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

    /**
    * method is used for getting current shopping cart order for a type and for unique email/temp or logon user
    * called by service Agency/basketout(cart) , ecommerce/checkout(cart), cart(cart),itemDetailsBrowse(cart) as list.getCurrentCartOrder('cart')
    * cartPOS(pos) and checkoutPOS(pos),itemDetailsPOS(pos) uses the same method   list.getCurrentCartOrder('pos')
    * called by beans ShoppingCartBeanAddon/ShoppingCartBean methods checkSetCodCustomer(cod), confirmPDPayment(codcop),
    * confirmPickUpPayment(codcop) changes terms codcop to PICKUP, confirmPayment(cart),saleRequest(cart),getPayment(cart)
    * stripeCartBean tbd
    * captureRequest(cart)
    * @return customer online order being processed ie checkedout/invoiced or not paid but checkedout status 2(toPay)   
    * @param args  type cart or pos or basket
    * @exception tbd
    */ 

	public List<${cuordersEntityName?cap_first}> getCurrentCartOrder(String type) {
                if(type.equals("cart") ){
                 //order terms null or blank if created but no checkout yet. If checkout then will have value , sort order desc
                 String terms1="PrePay and%";
                 String terms2="ToPay and%";
  		 return getEntityManager()
 		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl = :ma and (c2xxcxxxbv09xxxxxxxxterms is  null or c2xxcxxxbv09xxxxxxxxterms = '' or c2xxcxxxbv09xxxxxxxxterms like :terms1 or c2xxcxxxbv09xxxxxxxxterms like :terms2) )  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("ma", mactive).setParameter("owner2", owner2Code).setParameter("terms1", terms1).setParameter("terms2", terms2).setParameter("type", type).getResultList();
                }else{
                 if(type.equals("pos")){
                  type="cart";
  		  return getEntityManager()
 		  .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl = :sh or zcxxzzfxhhxxxxxxxxxxstatusfl < :s) and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is not null and c2xxcxxxbv09xxxxxxxxterms ='POS')  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("sh", mshipped).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                 }else{
                  if(type.equals("basket")){
  		   return getEntityManager()
 		    .createQuery(
		     "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is  null or c2xxcxxxbv09xxxxxxxxterms = '') or (c2xxcxxxbv09xxxxxxxxterms not like 'Paid/%' or c2xxcxxxbv09xxxxxxxxterms not like 'ToPay and%'))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		     .setParameter("owner", ownerCode).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                  }else{
                   log.severe("getCurrentCartOrder-unknown type "+ type);
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_INFO,bundle.getString("Unknown")+" "+ bundle.getString("order")+" "+bundle.getString("type")+": "+ type,""));
                   return null;
                  }
                 }
                }


	}

    /**
    * method is used for getting current shopping cart order for a type and for unique email/temp or logon user
    * called by service Agency/basketout(cart) , ecommerce/checkout(cart), cart(cart),itemDetailsBrowse(cart) as list.getCurrentCartOrder('cart')
    * cartPOS(pos) and checkoutPOS(pos),itemDetailsPOS(pos) uses the same method   list.getCurrentCartOrder('pos')
    * called by beans ShoppingCartBeanAddon/ShoppingCartBean methods checkSetCodCustomer(cod), confirmPDPayment(codcop),
    * confirmPickUpPayment(codcop) changes terms codcop to PICKUP, confirmPayment(cart),saleRequest(cart),getPayment(cart)
    * stripeCartBean tbd
    * captureRequest(cart)
    * @return customer online order being processed ie checkedout/invoiced or not paid but checkedout status 2(toPay)   
    * @param args  type cart or pos or basket
    * @exception tbd
    */ 

	public List<${cuordersEntityName?cap_first}> getCurrentConfirmedCartOrder(String type) {
                if(type.equals("cart") ){
                 //order terms null or blank if created but no checkout yet. If checkout then will have value 
                 String terms1="PrePay and%";
                 String terms2="ToPay and%";
                 //currentCartOrder and currentConfirmedCartOrder are mutually excluse
                 //first check if there is any currentCartOrder, if none, then only, return the last confirmedCardOrder 
                 //as currentConfirmedCartOrder else return null, sort order desc
                 if (!getCurrentCartOrder("cart").isEmpty()){
                  return null;
                 }else{
  		  return getEntityManager()
 		  .createQuery(
		   "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl > :ma and (c2xxcxxxbv09xxxxxxxxterms like :terms1 or c2xxcxxxbv09xxxxxxxxterms like :terms2 )  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		    .setParameter("owner", ownerCode).setParameter("ma", mactive).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("terms1", terms1).setParameter("terms2",terms2).getResultList();
                 }
                }else{
                 if(type.equals("pos")){
                  type="cart";
  		  return getEntityManager()
 		  .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl = :sh or zcxxzzfxhhxxxxxxxxxxstatusfl < :s) and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is not null and c2xxcxxxbv09xxxxxxxxterms ='POS')  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("sh", mshipped).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                 }else{
                  if(type.equals("basket")){
  		   return getEntityManager()
 		    .createQuery(
		     "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is  null or c2xxcxxxbv09xxxxxxxxterms = '') or (c2xxcxxxbv09xxxxxxxxterms not like 'Paid/%' or c2xxcxxxbv09xxxxxxxxterms not like 'ToPay and%'))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		     .setParameter("owner", ownerCode).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                  }else{
                   log.severe("getCurrentCartOrder-unknown type "+ type);
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_INFO,bundle.getString("Unknown")+" "+ bundle.getString("order")+" "+bundle.getString("type")+": "+ type,""));
                   return null;
                  }
                 }
                }


	}



	public List<Trexuq266xwwqqhxxxxxcuinvoice> getCurrentCartInvoiceFor(String key) {
		// jay remove hard coding, status invoiced ie 64 and not closed and loggedin/not owner
                String type="invoicecart";

		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq266xwwqqhxxxxxcuinvoice cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.zexxutoxlhxxxxxxxxxxowner=:owner or 'sss'=:owner) and (z5xxzzfxhhxxxxxxxxxxstatusfl = :s and z5xxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y7xxuxxrbv10xxxxxxxxtype=:type AND cc.a0xxuncibvxxxxxxxxxxinvoice=:key) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("s", minvoiced).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("key", key).getResultList();
	}

   public String getFullKey(String key) {
                 String msonorde;
                 try{  
                   msonorde=""+key;
                   int mponolen=7;
                   String padding = new String();
                   int padlen=-1;
                   int len = Math.abs(mponolen) - msonorde.length();
                   if (len < 1) {
                     msonorde=msonorde.toString();
                   }else{
                    for (int ii = 0 ; ii < len ; ++ii){
                     padding = padding + '0';
                    }
                     msonorde= (padlen < 0 ? padding + msonorde : msonorde + padding); 
                   }
                  } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,bundle.getString("ivalid")+" "+ bundle.getString("invoice")+" "+bundle.getString("record")+" "+e.getMessage(),""));
                    return null;
                  }

    return msonorde;
   }


	public List<Trexuq266xwwqqhxxxxxcuinvoice> getCartInvoiceFor(String key) {
		// jay remove hard coding, status invoiced ie 64 and not closed and loggedin/not owner
                key=getFullKey(key);
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq266xwwqqhxxxxxcuinvoice cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.zexxutoxlhxxxxxxxxxxowner=:owner or 'sss'=:owner) and (z5xxzzfxhhxxxxxxxxxxstatusfl = :s and z5xxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y7xxuxxrbv10xxxxxxxxtype=:type AND cc.a0xxuncibvxxxxxxxxxxinvoice=:key)   order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("s", minvoiced).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", "invoicecart").setParameter("key", key).getResultList();
	}


    /**
    * method is used for getting current cart orders for type cart or for types non cart , no owner checking done
    * called by checkout.xhtml  yet meant for admin usage
    * @return list of customer orders 
    * @param arg  type 
    * @exception tbd
    */ 

        public List<${cuordersEntityName?cap_first}> getCurrentCartOrders(String type) {
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("sc", mclosed).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl >= :s )  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
          }
        }

	public List<${cuordersEntityName?cap_first}> getCurrentCartOrdersV(String type) {
		// no owners checked used by Vendor if type basket and for say attachments
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mshipped).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").getResultList();
          }
	}

	public List<${cuordersEntityName?cap_first}> getCurrentCartOrdersE(String type) {
		// no owners checked used by Employee if type basket and for say attachments
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "CI-D").getResultList();
          }
	}

	public List<${cuordersEntityName?cap_first}> getCurrentCartOrdersC(String type) {
		// owner checked used by Customer if type basket and for say attachments
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("owner", ownerCode).setParameter("type", type).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner  and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mclosed).setParameter("owner2", owner2Code).setParameter("owner", ownerCode).setParameter("type", type).setParameter("mtype", "CI-D").getResultList();
          }
	}


	public List<${cuordersEntityName?cap_first}> getCurrentToPayCartOrder() {
		// include item type SI-D(regular ie shipment/pickup) or  SI-P(pay but pickup only) and exclude SI-C (COD ie pay on delivery)
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype !=:itype    ) order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner", ownerCode).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", "cart").setParameter("itype", "SI-C").getResultList();
	}




	public List<${cuodetailsEntityName?cap_first}> getCurrentCartOrderDetails(String type) {
		//  added type
                if(getCurrentCartOrder(type) ==null || getCurrentCartOrder(type).size()==0){
                 return null;
                }
                Integer osid=getCurrentCartOrder(type).get(0).getA0xxuobxbxxxxxxxxxxxsid();
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:osid) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner2", owner2Code).setParameter("osid", osid).getResultList();
	}

	public BigDecimal getCurrentCartOrderSaving(String type) {
		// status less than mpaid ie 16, totals should be some of detail totals
                //  get order details, loop through and calculate savings  addd type
                BigDecimal saving=BigDecimal.ZERO;
                BigDecimal regularAmount=BigDecimal.ZERO;
                BigDecimal discountedAmount=BigDecimal.ZERO;
                if(getCurrentCartOrderDetails(type)==null){
                 return saving;
                }
                for (${cuodetailsEntityName?cap_first} entry: getCurrentCartOrderDetails(type)){
                 if(entry.getB1xxzo11bvlxxxxxxxxxline() <1){
                  continue;
                 }
                 regularAmount=entry.getZ3xxeqxxbvnxxxxxxxxxqtyordrd().multiply(entry.get${itemEntityName?cap_first}().getB8fbzpxxbvxxxxxxxxxxselprice());
                 discountedAmount=entry.getZbxxzbxxavxxxxxxxxxxbaseamount();
                 saving=saving.add(regularAmount.subtract(discountedAmount));
                }
                return saving;
	}


	public List<${cuordersEntityName?cap_first}> getCompletedCartOrder() {
		// jay remove hard coding
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuordersEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "cartC").getResultList();
	}

	public List<${cuodetailsEntityName?cap_first}> getcompletedCartOrderDetails() {
		// jay remove hard coding
                Integer osid=getCompletedCartOrder().get(0).getA0xxuobxbxxxxxxxxxxxsid();
		return getEntityManager()
		 .createQuery(
		  "select cc from ${cuodetailsEntityName?cap_first} cc where (cc.${cuordersEntityName}.a0xxuobxbxxxxxxxxxxxsid=:osid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner2", owner2Code).setParameter("osid", osid).getResultList();
	}



</#if>

<#if (menuAttributesp2?contains("1A")) >
      // if from another site, restrict to raaspi site 

     public ${entityName} getSidToEntity(Integer sid,String owner2){
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from ${entityName} cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 
</#if>

<#if (menuAttributesp2?contains("24")) >
     public ${entityName} getKeyToEntity(String key,String owner2){
      // another site restrict to raaspi site jay add code
      ${entityName} entity=null;
      List<${entityName}> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from ${entityName} cc where cc.${keyField} = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )")
					.setParameter("nKeyName",key)
					.setParameter("owner2", owner2)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 


</#if>

     Connection conn = null;

      public void eLabel(String reference,String sendAs,String start,String end,Boolean markedOnes,String reportName) {  
         this.reference=reference;
         displayAs=sendAs;
         this.start=start;
         this.end=end;
         this.markedOnes=markedOnes;
         this.reportName="59"+reportName;
      
         this.print();
      }

      public void ePrint(String sendAs,String start,String end,Boolean markedOnes,String reportName) {  
         // allows to invoke print directly from another method, also adds the prefix to the reportname
         //displayAs=sendAs; ignore sendas param, since displayAs variable is now set before calling ePrint  
         this.start=start;
         this.end=end;
         this.markedOnes=markedOnes;
         this.reportName="ma"+reportName;
      
         this.print();
      }

     <#if (menuAttributesp2?contains("89") ) >
      public void eVite(String sendAs,Integer sid,Boolean markedOnes) {
            // called by scheduleEdit, sid is schedule sid
            // 1. first set up event using schedule  
            // 2a. call getEIMailAddrList(sid) which will create a list of Employee eMails going throgh schedule details
            // 2b. call getVIMailAddrList(sid) which will create a list of Vendor eMails going throgh schedule details
            // 2c. call getCIMailAddrList(sid) which will create a list of Customer eMails going throgh schedule details
            // for the sid matching schedule sid. each of above 3 methods calls getGroupXMailingAddrList(groupSid) where
            // X is E,V or C, which will go through group members and adds to the list
            // So getXIMailAddressList is a list of individual added to schedule as well as groupmember for X
            // 3. set mailing to, from, source etc and call iCalSend() to send scheduleMailingContent as eMail
            ${scheduleEntityName?cap_first} cc = ${scheduleEntityName}Home.getInstance();
            ${clientEntityName?cap_first} client = null;
              //jay split into 2 try to give unique msg or add singleresult exception
	      try {
                 client =(${clientEntityName?cap_first}) getEntityManager()
					.createQuery(
							"select cc from ${clientEntityName?cap_first} cc where cc.${clientKeyField} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();

			 ${scheduleEntityName} = (${scheduleEntityName?cap_first}) getEntityManager().createQuery("select cc from ${scheduleEntityName?cap_first} cc where cc.a0xxuobxbxxxxxxxxxxxsid = :sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2")
				.setParameter("sid", sid).setParameter("owner2", owner2Code).getSingleResult();
			if (${scheduleEntityName} != null ) {
			     // that's fine - It should exist.

			}
	      } catch (NoResultException nre) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_WARN,bundle.getString("${scheduleEntityName?substring(eL)?cap_first}")+" "+bundle.getString("not")+" "+bundle.getString("selected"),""));


	      }
         // if usertoEmployee has Email then use it , if empty then use client which should have some value
         if (${employeeEntityName}Home.getCurrentUserToEmployee()==null || "".equals(${employeeEntityName}Home.getCurrentUserToEmployee())){

          setClientEMail(client.get${clientImailaddr?cap_first}().trim());
         } 
         else{
           ${employeeEntityName}=${employeeEntityName}Home.getCurrentUserToEmployee();
           setClientEMail(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
           setUserFullName(${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname() +" "+${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname());
         }
         // if demo user no email saved in employee except in user
         ${userEntityName?cap_first} theUser = ${userEntityName}List.getKeyToEntity(customIdentity.getUsername());
         if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
          setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
         }

            //below based on alf.io 
         
            VEvent event = new VEvent();
            event.setUid("U"+sid);
            event.setDescription(${scheduleEntityName}.getB1xxhszsbv35xxxxxxxxdescript());
 
           int urlIndex=0;
           event.setSummary(req.getRequestURL()+" -"+${scheduleEntityName}.getB1xxhszsbv35xxxxxxxxdescript());


            event.setOrganizer(clientEMail);
            if (${scheduleEntityName}.getFxxxcq144xwwqqhxxxxxlocation() != null){
             event.setLocation(${scheduleEntityName}.getFxxxcq144xwwqqhxxxxxlocation().getA0xxukxxbvxxxxxxxxxxlocation());
            }
            event.setSequence(1);
            event.setDateStart(${scheduleEntityName}.getB5gxdxsdbvxxxxxxxxxxsdatet());
            event.setDateEnd(${scheduleEntityName}.getB8xxceedbvxxxxxxxxxxedatet());
            // need to move this to icalsend because attendee info is known in icalsend , not now
            //Attendee attendee = new Attendee("Jay Mitra", "jaymitra2@gmail.com");
            //attendee.setRsvp(true);
            //attendee.setRole(Role.CHAIR);
            //attendee.setParticipationStatus(ParticipationStatus.CONFIRMED);
            //event.setProperty(attendee);

            ICalendar ical = new ICalendar();
            ical.addEvent(event);
            ProductId prodid = new ProductId("-//"+client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna()+"//"+owner2Code+"//EN");
            ical.setProductId(prodid);
            StringWriter strWriter = new StringWriter();
            ICalWriter writer = new ICalWriter(strWriter, ICalVersion.V2_0);
            try {
             writer.write(ical);
            } catch (IOException e) {
             log.warning("was not able to generate iCal for event " +  e);
           }
           setMailingSubject(${scheduleEntityName}.getB1xxhszsbv35xxxxxxxxdescript());
           // regular text is followed with ics content because first part human readable and last part email reader readable
           String part1=${scheduleEntityName}.getB1xxhszsbv35xxxxxxxxdescript();
           part1=part1+"/n"+ "Organizer "+clientEMail;
           if (fxxxuq89bxwwqqhxxxxxschedule.getFxxxcq144xwwqqhxxxxxlocation() != null){
            part1=part1+"/n"+ "Location "+${scheduleEntityName}.getFxxxcq144xwwqqhxxxxxlocation().getA0xxukxxbvxxxxxxxxxxlocation();
           }
           part1=part1+"/n"+ "Start "+${scheduleEntityName}.getB5gxdxsdbvxxxxxxxxxxsdatet();
           part1=part1+"/n"+ "End "+${scheduleEntityName}.getB8xxceedbvxxxxxxxxxxedatet();
           String part2Pre="Calendar App may use the following to add the event automatically or use the attachment to add manually ";  
           setMailingSource(part1+"/n "+part2Pre+"/n"+Biweekly.write(ical).go());
           //attachment1 is read from mailingText1.bytes but mailingText1 is saved as String
           setMailingText1(Biweekly.write(ical).go());


           //employee 
           getEIMailAddrList(sid);
           // sid is schedule sid
           // set Attendee based on list returned ?? ie ctreate a new event ?
           //now eMail ical as content and attachment scheduleMailingContent.xhtml willl be rendered as email 
           // List.mailingAddress holds to names, mailingSource holds content, List.mailingBytes holds attachment
           // similar to send() method used for regular email send
           icalSend("e");
           //vendor
           getVIMailAddrList(sid);
           icalSend("v");
           //customer
           getCIMailAddrList(sid);
           icalSend("c");


      }
     </#if>
     <#if (menuAttributesp2?contains("60") ) >
      public void rollnPrint() {  
         // roll up subtotals and totals for accounts and then print report
         ${accountEntityName}Home.accountTotalsRollUp("trial");      
         this.print();
      }
     </#if>

     <#if menuAttributesp2 == "36">
      public String markPrinted() {  
       this.searchStatus=mpaid;
       if(this.getResultList().size()==0){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("No")+ " "+bundle.getString("outstanding")+ " "+bundle.getString("to")+ " "+bundle.getString("print"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("use")+ " "+bundle.getString("individual")+ " "+bundle.getString("venartha")+ " "+bundle.getString("Edit")+ " "+bundle.getString("to")+ " "+bundle.getString("allow")+ " "+bundle.getString("Generate")+ " "+bundle.getString("and")+ " "+bundle.getString("reprint"),""));
          return "";
       }
        print();//first generate if any
       //assume will be printed,loop start/end and flag printed
       //venarthaedit edit will have printed/not printed button for each chq to allow reprint
                if(!bcontinue){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_INFO,bundle.getString("Error")+ " "+bundle.getString("during")+ " "+bundle.getString("generate")+ ", "+bundle.getString("exiting"),""));

                }
		try {
                ${componentName?cap_first} ${componentName}li=null;
                List<${componentName?cap_first}> listofStatus=this.getResultList() ;
			Iterator<${componentName?cap_first}> itr = listofStatus.iterator();
			while (itr.hasNext()) {
			  ${componentName}li = itr.next();
		          ${componentName}li.set${statusFlagField?cap_first}(mprinted);//512
                          ${componentName}Home.clearInstance();
                          ${componentName}Home.getInstance();
                          ${componentName}Home.setInstance(${componentName}li); 
                          ${componentName}Home.superUpdate();                          
			}
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                          FacesMessage.SEVERITY_INFO,bundle.getString("marking")+ " "+bundle.getString("as")+ " "+bundle.getString("Printed")+ " "+bundle.getString("done"),""));
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                            FacesMessage.SEVERITY_INFO,bundle.getString("use")+ " "+bundle.getString("individual")+ " "+bundle.getString("venartha")+ " "+bundle.getString("Edit")+ " "+bundle.getString("to")+ " "+bundle.getString("allow")+ " "+bundle.getString("Generate")+ " "+bundle.getString("and")+ " "+bundle.getString("reprint"),""));
		} catch (Exception e) {
			log.severe("Mark iterator error " + e.getMessage());
		}
                return "";

      }
     </#if>



      public void print() {  
           // reportname has 2 ch prefix to indicate type of reports and are stripped off later
           // 59,66= Avery label de= default dg=demographic me=metrics fi=financia sk=stock 
           // load messages from data base, now bundleName is ignored,it is hardcoded as "m"
           // jasperSoft need to pass resourcebundle and locale to subreport  via parameter
           // pass prefix based truefalse field selection values as show00nh and show00n as
           // report parameters
           <#if menuAttributesp2 == "36">
            this.searchStatus=mpaid;
            if(this.getResultList().size()==0){
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("No")+ " "+bundle.getString("outstanding")+ " "+bundle.getString("to")+ " "+bundle.getString("print"),""));
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("use")+ " "+bundle.getString("individual")+ " "+bundle.getString("venartha")+ " "+bundle.getString("Edit")+ " "+bundle.getString("to")+ " "+bundle.getString("allow")+ " "+bundle.getString("Generate")+ " "+bundle.getString("and")+ " "+bundle.getString("reprint"),""));
             return ;
           }
           </#if>
           <#if menuAttributesp2 == "1A">
            //the itemstock report called form item report but uses serialnumbers table not item table
            if(reportName.contains("serialnumbers")){
             fxxxuq1ffxwwqqhefxxxserialnumbersList.print();
             return;
            }
           </#if>
           ResourceBundle resourceBundle = new DatabaseResourceLoader();
                if(end == null || end.isEmpty() || end.equals("0") ){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_WARN,bundle.getString("no")+" "+bundle.getString("record")+" "+bundle.getString("found")+" "+bundle.getString("or")+" "+bundle.getString("end")+" "+bundle.getString("not")+" "+bundle.getString("selected"),""));
                 return;
                }

		// Set class path for compiling XML templates
		System.setProperty("jasper.reports.compile.class.path", context.getRealPath("/WEB-INF/reports/"));


		// Specify a default folder for storing 
		// compiled XML templates
		System.setProperty("jasper.reports.compile.temp", context
				.getRealPath("WEB-INF/reports/"));


		//log.info("Report Class Path ="+System.getProperty("jasper.reports.compile.class.path"));

           bcontinue=true;
           int xvi=0;
           String companyName="";
        <#if menuAttributesp2 == "60" >
           try{

                ${clientEntityName?cap_first} client=${clientEntityName}List.getKeyToEntity("01");//remove below
                client =(${clientEntityName?cap_first}) getEntityManager()
		.createQuery(
		"select cc from ${clientEntityName?cap_first} cc where cc.${clientKeyField} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
		.setParameter("nKeyName","01")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                companyName=client.getB2xxuzcxbvxxxxxxxxxxenterprisecompanyna(); 
                if(fYearEndS == null || fYearEndS.isEmpty()){ 
                 fYearEndS=new SimpleDateFormat("yyyy MMM dd").format(client.getZcxxdwfebvxxxxxxxxxxfyrend());
                }//do not override if set by user, also set in get
	  } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_WARN,bundle.getString("client")+" "+bundle.getString("record")+" "+owner2Code+" "+bundle.getString("not")+" "+bundle.getString("found"),""));
             return;
	  }
        </#if>
       

 	  try {
                        // Get a database connection
                        // start/end/marked ones logic not complete,supposed to be used as scope. marked not used
                        // start/end refers to incorrect value in case journal report since it refers to account list as default
                        // not journal list. may be use parameter like eprint so that calling module can decide
                        conn = getConnection();
                        //locale=localeSelector.getLocale();
                        String reportTitle = "Jay Report";
                        String recordMarkedOnly = "";
                        parameters.put("DisplayAs", displayAs);
                        parameters.put("reference", reference);
                        // if serialnumber report invoked from item then start needs to be independent of item value
                        if(reportName.contains("serialnumbers")){
                         start="000000";
                         end="zzzzzz";
                        } 
                        <#if (menuAttributesp2?contains("68"))>
			parameters.put("Start", Integer.parseInt(start.replace("-","")));
			parameters.put("End", Integer.parseInt(end.replace("-","")));
                        <#else>
			parameters.put("Start", start);
			parameters.put("End", end);
                        </#if>
			parameters.put("MarkedOnes", markedOnes);
			parameters.put("TargetId", targetId);
			parameters.put("SortKey", sortKey);
			parameters.put("SortOrder", sortOrder);
			parameters.put("Status", searchStatus);
                        reportNamePrefix=reportName.substring(0,2);
                        reportNameMinusPrefix=reportName.substring(2);
			parameters.put("ReportName", reportNameMinusPrefix);
                        // 6.17 deprecated parameters.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(new File(context.getRealPath("/WEB-INF/reports/"))));
                        //depecated fileResolver replaced by net.sf.jasperreports.repo.RepositoryService
                        parameters.put(JRParameter.REPORT_LOCALE, locale);
                        parameters.put("owner2Code", owner2Code);
                        parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, resourceBundle);
                        parameters.put("CompanyName", companyName); 
                        context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext(); 
                      /*  already set at bean construct
                        HttpServletRequest req = (HttpServletRequest) externalContext.getRequest(); 
                        int hostPort=0;
                        hostUrl="";
                        if(req.getServerPort()==8080){
                         hostUrl=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort(); 
                        }else{
                         hostUrl=req.getScheme()+"://"+req.getServerName(); 
                        }  
                      */
                        parameters.put("subreportPath", context.getRealPath("/WEB-INF/reports/"));

                        parameters.put("reqUrl",hostUrl );//gets abc.com:port
                        <#if menuAttributesp2 == "60" >
                         parameters.put("fYearEndS", fYearEndS);
                        </#if>
	  } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_WARN,bundle.getString("database")+" "+bundle.getString("connect")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                return;
	  }
     // truefalse table can be used for reports to indicate a field should be printed or not. The field is passed
     // as $P{show00nh as name and show00n as value} Note it starts with sid as show001 and
     // sorted by full property name axxxxx, yxxx not column name sid,matcode etc
     // If enttry exists in truefalse then load from there using loadTruefalses() or create a new entry here 
     //
     // in createInstance of truefalse, instance property show00x has default values as true, so we need 
     // to set to false to hide. Example prefix dg will hide numeric fields 
     // de default dg demographics me quantity  a1 ad hoc 1 a2 ad hoc 2 a3 ad hoc 3 fi financial used by transactions
     // Once entry exists, user can alter it to customixe. TBD add option to reset to default? 


          try{
                <#assign showi=0> 
                if (!reportNamePrefix.equals("fi")){
                 //following for parameter label not value true/false for non fi reports ie non Txn
                 <#foreach property in pojo.allPropertiesIterator>
                 <#if (property.name?length > eL)>
                  <#if !c2h.isCollection(property) >
                   <#assign showi=showi+1> 
                   <#if c2j.isComponent(property)>
                    <#foreach componentProperty in property.value.propertyIterator>
		           parameters.put("${"show"+showi?string?left_pad(3,"0")}h", "${'#'}{messages[${componentProperty.name?substring(pL)?cap_first}]}");
                    </#foreach>
                   <#else>
                     <#if c2h.isManyToOne(property)>
		            parameters.put("${"show"+showi?string?left_pad(3,"0")}h", "${'#'}{messages[${property.columnIterator.next().name}]}");
                     <#else>
		            parameters.put("${"show"+showi?string?left_pad(3,"0")}h", "${'#'}{messages[${property.name?substring(pL)?cap_first}]}");
                     </#if>
                   </#if>
                  </#if>
                 </#if>
                 </#foreach>
                 // done with labels, now load corresponding values from truefalses db or if new create 
                 loadTruefalses(); //sets bcontinue
                 // if found bcontinue is true and  report parameters shownnn are already set from db
                 // if not found then create db entry and then load default values for report prefix type
                 // and then persist truefalse
                 // and call loadTruefalses() again 
                 if (!bcontinue){//not found
                    ${truefalseEntityName}Home.clearInstance();
                    ${truefalseEntityName}=${truefalseEntityName}Home.getInstance();
                    ${truefalseEntityName}.setA0xxukrdbvxxxxxxxxxxtablename("${componentName?substring(eL)}");
                    ${truefalseEntityName}.setA1xxuxxxbvxxxxxxxxxxqualifier(reportNamePrefix);
                  //default
                 if(reportNamePrefix.equals("de")){ 
                 <#assign showi=0> 
                 <#foreach property in pojo.allPropertiesIterator>
                 <#if (property.name?length > eL)>
                  <#if !c2h.isCollection(property)>
                   <#if !(menuAttributesp2 =="5A")> 
                    <#assign showi=showi+1> 
                       <#if (property.name?substring(0,1)=="y" || property.name?substring(0,1)=="z" || property.name?substring(pefS,pefE)=="19" || property.name?substring(pefS,pefE) =="25" || property.name?substring(pefS,pefE) =="44") && showi lt 137>
                        ${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow${showi?string?left_pad(3,"0")}(false);
                       </#if> 
                   </#if>
                  </#if>
                 </#if>
                 </#foreach>
                   //${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow001(false);//hide sid 
                 }
                 //demographic
                 if (reportNamePrefix.equals("dg")){
                 <#assign showi=0> 
                 <#foreach property in pojo.allPropertiesIterator>
                 <#if (property.name?length > eL)>
                  <#if !c2h.isCollection(property)>
                   <#if !(menuAttributesp2 =="5A")> 
                    <#assign showi=showi+1> 
                       <#if (property.name?substring(0,1)=="y" || property.name?substring(0,1)=="z" || property.name?substring(pefS,pefE)=="19" || property.name?substring(pefS,pefE) =="25" || property.name?substring(pefS,pefE) =="44") && showi lt 137>
                        ${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow${showi?string?left_pad(3,"0")}(false);
                       </#if>
                       <#if property.value.type.name?contains("BigDecimal") && showi lt 137>
                        ${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow${showi?string?left_pad(3,"0")}(false);
                       </#if>
                   </#if>
                  </#if>
                 </#if>
                 </#foreach>
                  // ${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow001(false); table never had sid
                  // by default showxxx are true but .ftl gen time for "me" it will put false if not type decimal
                  // but at report side it will always include some key values
                 }
                 if (reportNamePrefix.equals("me")){
                 // show001 etc refers to decimal items not the original seq, start false from show003
                 //show002 is qty
                 <#assign showi=-1> 
                 <#foreach property in pojo.allPropertiesIterator>
                  <#if !c2h.isCollection(property)>
                   <#if !(menuAttributesp2 =="5A")> 
                    <#assign showi=showi+1> 
                       <#if !property.value.type.name?contains("ecimal") && showi gt 0 && showi lt 137>
                        ${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow${showi?string?left_pad(3,"0")}(false);
                       </#if>
                   </#if>
                  </#if>
                 </#foreach>
                 }
                 //any other prefix like adhock etc
                 if (reportNamePrefix.equals("a1") || reportNamePrefix.equals("a2")){
                 <#assign showi=0> 
                 <#foreach property in pojo.allPropertiesIterator>
                 <#if (property.name?length > eL)>
                  <#if !c2h.isCollection(property)>
                   <#if !(menuAttributesp2 =="5A")> 
                    <#assign showi=showi+1>   
                       <#if (property.name?substring(0,1)=="y" || property.name?substring(0,1)=="z" || property.name?substring(pefS,pefE)=="19" || property.name?substring(pefS,pefE) =="25" || property.name?substring(pefS,pefE) =="44") && showi lt 137>
                        ${truefalseEntityName}.setA1xxyxxxbvxxxxxxxxxxshow${showi?string?left_pad(3,"0")}(false);
                       </#if>
                   </#if>
                  </#if>
                 </#if>
                 </#foreach>
                 }
                 if (customIdentity.isDebug()){
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_WARN,bundle.getString("Report")+" "+bundle.getString("prefix")+" "+reportNamePrefix+" "+bundle.getString("setting")+" "+bundle.getString("saved"),""));
                 }
                  yxxxch5a1xhhxxhxxxxxtruefalseHome.clearInstance();           
                  yxxxch5a1xhhxxhxxxxxtruefalseHome.setInstance(yxxxch5a1xhhxxhxxxxxtruefalse);           
                  yxxxch5a1xhhxxhxxxxxtruefalseHome.persist();
                  loadTruefalses(); //load from persisted one
                 }//bcontinue
                }
                parameters.put("show001", false);//hide sid from reports
                if (bcontinue){
                 //log.info("Report file resolver Path ="
                 //+ context.getRealPath("/WEB-INF/reports/"));
                 //upgraded to jasper Report 6.17.0
                        SimpleJasperReportsContext context = new SimpleJasperReportsContext();
                        //not sure where the following can be useful,seems like getCompiledReport can be replaced
                        //FileRepositoryService fileRepository = new FileRepositoryService(context, "/WEB-INF/reports", false);
                        //context.setExtensions(RepositoryService.class, Collections.singletonList(fileRepository));
                        //context.setExtensions(PersistenceServiceFactory.class, Collections.singletonList(FileRepositoryPersistenceServiceFactory.getInstance()));
                       JasperReport jasperReport = getCompiledReport(reportNameMinusPrefix);
                        //after changing from request scope to viewscope has to get current faces context
                        // and a new resp since jsf already has a resp with state as writer, wont allow outputstream 
                        // in same resp  
                        facesContext = FacesContext.getCurrentInstance(); 
                        if(facesContext !=null){
                         externalContext = facesContext.getExternalContext(); 
                         resp = (HttpServletResponse) externalContext.getResponse(); 
                        }
                        int noOfColumns = 10;           
                        if (displayAs.toUpperCase().indexOf("HTML") >= 0) {
                          JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(
                          jasperReport, parameters,conn);
                         //JasperPrint jasperPrint = JasperFillManager.fillReport(
                         //jasperReport, parameters, conn);
                         noOfColumns = 5;//does it make smaller width?
                         jasperPrint.setPageWidth(noOfColumns * 108);
                          generateHtmlOutput(jasperPrint, req, resp);
                        }
                       else {
                          if(displayAs.toUpperCase().indexOf("PDF") >= 0){
                                JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(
                                                jasperReport, parameters,conn);
                                jasperPrint.setPageWidth(noOfColumns * 108);
                                generatePDFOutput(resp, parameters, jasperReport);
                          }
                          else {
                           if(displayAs.toUpperCase().indexOf("EXCEL") >= 0){
                                JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(
                                                jasperReport, parameters,conn);
                                jasperPrint.setPageWidth(noOfColumns * 108);
				generateEXCELOutput(jasperPrint, req, resp);
                           }
                           //wont come further here for HTML or PDF, but can be used if logic differs in future
                           else {
                            if(displayAs.toUpperCase().indexOf("EMAILPDF") >= 0){
                                JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(
                                                jasperReport, parameters,conn);
                                jasperPrint.setPageWidth(noOfColumns * 108);
		             mailingBytes = null;
		             mailingBytes = JasperRunManager.runReportToPdf(jasperReport, parameters,conn);
                            }else{
                             //handle shoppingCard print which comes as SEMAIL or PEMAIL
                             // displayAs becomes EMAIL before coming here 
                             if(displayAs.toUpperCase().indexOf("EMAIL") >= 0){
                                JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(
                                jasperReport, parameters,conn);
                                noOfColumns = 5;//does it make smaller width?
                                jasperPrint.setPageWidth(noOfColumns * 108);
				generateHtmlOutput(jasperPrint, req, resp);
                             // end of email

                            }
                            else {
                             // Assume it is  CSV report but make it harder if customer data to stop stealing
                             setDisplayAs("CSV");
                                if(ownerCode.contains("manager")){
                                JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(
                                                jasperReport, parameters,conn);
                                 jasperPrint.setPageWidth(noOfColumns * 108);
                                 generateCSVOutput(jasperPrint, req, resp);
                                }else{
                                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                   FacesMessage.SEVERITY_WARN,bundle.getString("only")+" "+bundle.getString("manager")+" "+bundle.getString("is")+" "+bundle.getString("allowed")+" "+bundle.getString("to")+" "+bundle.getString("run")+" "+bundle.getString("csv")+" "+bundle.getString("report"),""));
                                } 
                           }//emailhtml
                          }//emailpdf
                         }//excel
                        }//pdf
                       }//html                           
                }//bcontinue                                         
              } catch (Exception e) {
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                  FacesMessage.SEVERITY_WARN,bundle.getString("${entityName?substring(eL)}")+" "+bundle.getString("report")+" "+bundle.getString("generate")+" "+bundle.getString("failed")+" "+e.getMessage(),""));
                 bcontinue=false;// 
              } finally {
                if (conn != null) {
                  try {
                         conn.close();
                        log.info("Jasper Report Connection closed by pgm ");
	} catch (SQLException sqle) {
                  // Ignore
                 }
               }
             }
           }

       <#if (menuAttributesp2 =="5A")> 

	public String[] getShowColumnNames() {
		return showColumnNames;
	}

	public void setShowColumnNames(String[] showColumnNames ) {
		 this.showColumnNames = showColumnNames;
	}

	public String getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(String selectedClass ) {
		 this.selectedClass = selectedClass;
	}
	public String getSelectedQualifier() {
		return selectedQualifier;
	}

	public void setSelectedQualifier(String selectedQualifier ) {
		 this.selectedQualifier = selectedQualifier;
	}

    public String columnNmToProprtyNm(String jentityName, String colNm){
      //jentityName is  Class name Trexuq277xwwqqhxxxxxcpayment, colNm is column01,matcode ...
      // return genapp 20ch plus prop/column nm , in case of importcsv prop and col nm same, not allways true
      // need better logic for other tables 
      jentityName="com.rcomputer.genapp.model."+jentityName;

               try{
                   Session session = getEntityManager().unwrap(org.hibernate.Session.class);

                   ClassMetadata hibernateMetadata = session.getSessionFactory().getClassMetadata(Class.forName(jentityName));
                   String[] showPropertyNames=hibernateMetadata.getPropertyNames();
  
                   for (int i = 0; i < showPropertyNames.length; i++){
                      if(showPropertyNames[i].substring(20).equals(colNm)){
                       return showPropertyNames[i];
                      } 
                   }     
                                 
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,bundle.getString(jentityName)+" "+bundle.getString("and")+" "+bundle.getString("column")+" "+bundle.getString("name")+" "+colNm+" "+bundle.getString("to")+" "+bundle.getString("property")+" "+bundle.getString("not")+" "+bundle.getString("found"),""));
                   return null;
               }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString(jentityName)+" "+bundle.getString("and")+" "+bundle.getString("column")+" "+bundle.getString("name")+" "+colNm+" "+bundle.getString("to")+" "+bundle.getString("property")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                return null ;
               }


     
    }

    public ArrayList<String> entityColumnNames(String jentityName,Boolean trim,Boolean upper,int size){
      //jentityName is  Class name Trexuq277xwwqqhxxxxxcpayment
      jentityName="com.rcomputer.genapp.model."+jentityName;
      mapColumnNames(jentityName,trim,upper);// create array
      ArrayList<String> ret=new ArrayList<String>();
                   for (int i = 0; i < showColumnNames.length; i++){
                    if(showColumnNames[i] != null){
                     ret.add(showColumnNames[i]);
                    }
                    if (i >= size){
                     break;
                    }
                   }     
      return ret;//first 20 ch of property name removed by called method mapColumnNames
     
    }

    /**
    * The following method loads property name values into an array which can be used 
    * as the labels for truefalse table columns to show or hide fields in report for a specific entity
    * called by truefalse edit or list 
    * @return void but populates showColumnNames array
    * @exception no entity class found 
    * @see 
    * 
    */ 

      public void mapColumnNames(String jentityName,Boolean trim,Boolean upper) {
                //jentityName is fully qualified Class name com.rcomputer.genapp.model.Trexuq277xwwqqhxxxxxcpayment 
                if(jentityName != null && jentityName.isEmpty()){
                 jentityName=selectedClass;
                } 
                try{
                   Session session = getEntityManager().unwrap(org.hibernate.Session.class);

                   ClassMetadata hibernateMetadata = session.getSessionFactory().getClassMetadata(Class.forName(jentityName));
                   String[] showPropertyNames=hibernateMetadata.getPropertyNames();
                   // need to trim off 20 ch prefix of property value
                   // skip i=2, no skip except sid
  
                   for (int i = 0; i < showPropertyNames.length; i++){
                     if(trim){
                      showColumnNames[i] = showPropertyNames[i].substring(20);
                     }else{
                      showColumnNames[i] = showPropertyNames[i];
                     }
                     if(upper){
                      showColumnNames[i] = showPropertyNames[i].toUpperCase();
                     }

                   }     
                                 
                   return  ;
               }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString(jentityName)+" "+bundle.getString("map")+" "+bundle.getString("column")+" "+bundle.getString("names")+" "+bundle.getString("names")+" "+e.getMessage(),""));

                return ;
               }

      }



    /**
    * The following method loads all table and class names into a String,String map which can be used 
    * to select table/fully qualified class for which column names will be shown
    * called by step3 importcsvHome mapRow00ToProperty > truefalselist.getClassNames(all 
    * also by step2 importMappingEdit>>ruefalseList.getClassNames('import')
    * @return map of table name,class name
    * assume table name is the same as class name without prefix, classname left as is, upto the calling method
    * or view to remove prefix
    * @exception no entity class found 
    * @see 
    * 
    */ 

      public Map<String,String> getClassNames(String purpose) {
                try{
                   showClassNames=new LinkedHashMap<String,String>();
                   Session session = getEntityManager().unwrap(org.hibernate.Session.class);
                   Map<String, ClassMetadata> m = (Map<String, ClassMetadata>) session.getSessionFactory().getAllClassMetadata();
                   for(String entityName : m.keySet()){
                    if(purpose.equals("import")){
                     //filter in a subset for now
                     if(entityName.substring(47).equals("customer") || entityName.substring(47).equals("division") 
                      || entityName.substring(47).equals("vendor")  || entityName.substring(47).equals("employee")
                      || entityName.substring(47).equals("item")  || entityName.substring(47).equals("schedule")
                      || entityName.substring(47).equals("address")  || entityName.substring(47).equals("user")
                      || entityName.substring(47).equals("rate1f")  || entityName.substring(47).equals("account")
                      || entityName.substring(47).equals("acintegr")  || entityName.substring(47).equals("blobdata")
                      || entityName.substring(47).equals("clobdata")  
                       ){
                      showClassNames.put(entityName.substring(47),entityName);
                     }                     
                    }else{
                      showClassNames.put(entityName.substring(47),entityName);
                    }
                   }//for end
                   Map<String, String> treeMap = new TreeMap<String, String>(showClassNames);
                   return  treeMap;
               }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                 FacesMessage.SEVERITY_ERROR,bundle.getString("get")+" "+bundle.getString("class")+" "+bundle.getString("names")+" "+bundle.getString("error")+" "+e.getMessage(),""));

                return null;
               }

      }



</#if>


    /**
    * The following method loads values from truefalse table to show or hide fields in report
    * called by print() which will initialize the table if bcontinue is set false here 
    * @return void but bcontinue set to false if error
    * @exception no select result or select failed. 
    * @see 
    *  since entiyProperty names skip sid, table entries index 1 holds say matcode, AddressCode etc not sid
    * Report showcolumn001 expects sid but it does not exist in db, so skip it and start from 002 <-001 
    */ 

      public void loadTruefalses() {  
                ${truefalseEntityName?cap_first} truefalses =null;
                bcontinue=true;
                try {
                 List<${truefalseEntityName?cap_first}> results =  getEntityManager()
                  .createQuery(
                   "select cc from ${truefalseEntityName?cap_first} cc where   cc.a0xxukrdbvxxxxxxxxxxtablename=:tableName  and cc.a1xxuxxxbvxxxxxxxxxxqualifier=:qualifier and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                      .setParameter("tableName", "${entityName?substring(eL)}")
                      .setParameter("qualifier", reportNamePrefix)
                      .setParameter("owner2", owner2Code)
                      .getResultList();
                           if(!results.isEmpty()){
                            truefalses = results.get(0);
                           }
                           else{
                            if (customIdentity.isDebug()){
                             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_WARN,bundle.getString("report")+" "+bundle.getString("columns")+", "+bundle.getString("selections")+" "+ bundle.getString("not")+" "+ bundle.getString("done"),""));
                             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("continuing")+" "+ bundle.getString("with")+" "+ bundle.getString("defaults"),""));
                            }
                            bcontinue=false;
                           } 

               } catch (NoResultException ex) {
                            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_WARN,bundle.getString("report")+" "+bundle.getString("columns")+", "+bundle.getString("selections")+" "+ bundle.getString("not")+" "+ bundle.getString("done"),""));

                            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("continuing")+" "+ bundle.getString("with")+" "+ bundle.getString("defaults"),""));
                            bcontinue=false;
             }

               if (bcontinue){
                <#assign showi=1> //report fields starting with sid we skip it below and send show002......
                <#assign showiC=0> //columns 001 has key ... no sid . 2 <-1, 3 <-2
                <#foreach property in pojo.allPropertiesIterator>
                 <#if !c2h.isCollection(property) >
                  <#assign showi=showi+1> 
                  <#assign showiC=showiC+1> 
                  <#if c2j.isComponent(property)>
                   <#foreach componentProperty in property.value.propertyIterator>
                    <#if !(menuAttributesp2 =="5A" || menuAttributesp2 =="1R" || menuAttributesp2 =="51" || menuAttributesp2 =="52"  )>
			     parameters.put("${"show"+showi?string?left_pad(3,"0")}", truefalses.getA1xxyxxxbvxxxxxxxxxxshow${showiC?string?left_pad(3,"0")}());
                    <#else>
			     parameters.put("${"show"+showi?string?left_pad(3,"0")}", true);//for these ignore table entries for now
                    </#if>
                   </#foreach>
                  <#else>
                   <#if !(menuAttributesp2 =="5A" || menuAttributesp2 =="1R" || menuAttributesp2 =="51" || menuAttributesp2 =="52"  )>
			    parameters.put("${"show"+showi?string?left_pad(3,"0")}", truefalses.getA1xxyxxxbvxxxxxxxxxxshow${showiC?string?left_pad(3,"0")}());
                   <#else>
			    parameters.put("${"show"+showi?string?left_pad(3,"0")}", true);
                   </#if>
                  </#if>
                 </#if>
                </#foreach>
                //
                parameters.put("show001", false);

               }
      }

	private void generateHtmlOutput(JasperPrint jasperPrint,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException, JRException {

		HtmlExporter exporter = new HtmlExporter();
                Map imagesData = new HashMap();//
		req.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
		resp.setContentType("text/html");
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                //request to send html report via email can come from backoffice or from self serve shopping cart
                // SEMAIL (order) or PEMAIL (invoice)
                //unlike report view via browser which gets it fron server, images need to be part of the email 
                //one can also put image url pf say logo in the mailing source ie just before jasper report
                //for now if barcode use pdf as attachment to email
                if(displayAs.toUpperCase().indexOf("EMAILHTML") >= 0 ||
                    displayAs.toUpperCase().indexOf("EMAIL") >= 0){
 		 exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sBuffer);//
                 //exporter.setParameter(HtmlExporterParameter.IMAGES_URI, "cid:");//try this for logo
                 //exporter.setParameter(HtmlExporterParameter.IMAGES_MAP, imagesData);
                }else{
		 exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, resp.getWriter());
  		 //exporter.setParameter(HtmlExporterParameter.IMAGES_URI,"servlets/image?image=");
                }
                //exporter.setParameter(HtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);

		exporter.setParameter(JRDocxExporterParameter.FRAMES_AS_NESTED_TABLES, "false");

		exporter.exportReport();
	}

	private void generatePDFOutput(HttpServletResponse resp, Map parameters,
			JasperReport jasperReport) throws JRException, NamingException,
			SQLException, IOException {

		byte[] bytes = null;

		bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
				conn);

		resp.setContentType("application/pdf");
		resp.setContentLength(bytes.length);
		ServletOutputStream ouputStream = resp.getOutputStream();
		ouputStream.write(bytes, 0, bytes.length);
		ouputStream.flush();
		ouputStream.close();
                facesContext.responseComplete();

	}
        private void generateEXCELOutput(JasperPrint jasperPrint,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, JRException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("Content-disposition", "attachment; filename="+reportNameMinusPrefix+".xlsx");
        ServletOutputStream servletOutputStream=response.getOutputStream();
        JRXlsxExporter docxExporter=new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        docxExporter.exportReport();
       }

      private void generateCSVOutput(JasperPrint jasperPrint,
        HttpServletRequest request, HttpServletResponse response)
        throws IOException, JRException {
        response.setContentType("text/csv");
        response.addHeader("Content-disposition", "attachment; filename="+reportNameMinusPrefix+".csv");
        ServletOutputStream servletOutputStream=response.getOutputStream();
       JRCsvExporter docxExporter=new JRCsvExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
      }



	private DataSource getDataSource() throws NamingException {
                   if (ds == null) {
                   Context ctx = new InitialContext();
                     if(tomeeYN){//
                      ds = (DataSource) ctx.lookup("java:openejb/Resource/RaaspiSQLDS");  
                     }else{
                      ds = (DataSource) ctx.lookup("RaaspiSQLDS");   
                     }
                    }
                   return ds;
	}

	private Connection getConnection() throws SQLException, NamingException {
		return getDataSource().getConnection();
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(context.getRealPath(
				"/WEB-INF/reports/" + fileName + ".jasper"));

		// If compiled file is not found, then
		// compile XML template
		if (!reportFile.exists()) {
			File reportDesignFile = new File(context.getRealPath(
					"/WEB-INF/reports/" + fileName + ".jrxml"));
			
			JasperCompileManager.compileReportToFile(reportDesignFile.getPath());
		}
                try{

		 JasperReport jasperReport = (JasperReport) JRLoader
				.loadObjectFromFile(reportFile.getPath());
 		 return jasperReport;

                }catch(Exception e){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("error")+" "+e.getMessage(), ""));
		      log.severe("report error cause "+e.getCause());

                return null;
                } 

	}

protected String getCountEjbql()
    {
        String ejbql = getRenderedEjbql();
        Matcher fromMatcher = FROM_PATTERN.matcher(ejbql);
        if(!fromMatcher.find())
        {
            throw new IllegalArgumentException("no from clause found in query");
        } else
        {
            int fromLoc = fromMatcher.start(2);
            Matcher orderMatcher = ORDER_PATTERN.matcher(ejbql);
            int orderLoc = orderMatcher.find() ? orderMatcher.start(1) : ejbql.length();
            Matcher whereMatcher = WHERE_PATTERN.matcher(ejbql);
            int whereLoc = whereMatcher.find() ? whereMatcher.start(1) : orderLoc;
            String subject = "*";
            return (new StringBuilder(ejbql.length() + 15)).append("select count(").append(subject).append(") ").append(ejbql.substring(fromLoc, whereLoc).replace("join fetch", "join")).append(ejbql.substring(whereLoc, orderLoc)).toString().trim();
        }

    }
 <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
   public void saveAsDraft() {
              try {
                 mailingSubject=${clobdataEntityName}Home.sanitize(mailingSubject);//
                 mailingSource=${clobdataEntityName}Home.sanitize(mailingSource);
                 ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-DRAFT",ownerCode,0);
                 if(${clobdataEntityName} == null){   
                  ${clobdataEntityName}Home.clearInstance();
		  ${clobdataEntityName} = ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
		  ${clobdataEntityName}.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  ${clobdataEntityName}.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-DRAFT");
		  ${clobdataEntityName}.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  ${clobdataEntityName}.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);// each user will have own draft
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  ${clobdataEntityName}.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  ${clobdataEntityName}Home.persist();
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,"Draft created" ,""));

                 }else{
  		  ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-DRAFT",ownerCode,0);
                  mailingSubject=${clobdataEntityName}Home.sanitize(mailingSubject);//
                  mailingSource=${clobdataEntityName}Home.sanitize(mailingSource);
		  //${clobdataEntityName}.setB1xxuzaxbvxxxxxxxxxxdata(mailingSource);
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  ${clobdataEntityName}Home.clearInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
                  ${clobdataEntityName}Home.superUpdate();
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,"Draft updated" ,""));

                 }
              } catch (Exception e) {
               log.severe("Error saving draft"+ e);
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_ERROR,"Draft save failed: " + e.getMessage(),""));
              }

   }


   public void loadDraft() {
                 ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-DRAFT",ownerCode,0); // each owner will load own draft
                 if(${clobdataEntityName} == null){   
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString("no")+" "+bundle.getString("draft")+" ("+bundle.getString("key")+": "+bundle.getString("MAIL-DRAFT")+") "+" "+bundle.getString("record")+" "+bundle.getString("found")+" "+bundle.getString("in")+" "+bundle.getString("text")+" "+bundle.getString("data"),""));
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString("you")+" "+bundle.getString("may")+" "+bundle.getString("check")+" "+bundle.getString("for")+" ("+bundle.getString("key")+": "+bundle.getString("MAIL-CONTENT")+") "+" "+bundle.getString("which")+" "+bundle.getString("holds")+" "+bundle.getString("mail")+" "+bundle.getString("already")+" "+bundle.getString("sent"),""));
                  return;
                 }else{
                  mailingSource=${clobdataEntityName}.getB1xxuzaxbvxxxxxxxxxxdata();
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,bundle.getString("Last")+" "+bundle.getString("saved")+" "+bundle.getString("Draft")+" "+bundle.getString("for")+" "+ownerCode+" "+bundle.getString("loaded"),""));

                 }
   }
  
   public void send() {
    /**
    * major change  to use sendgrid x-smtpi ie
    * no loop here but send the to: list to sendgrid via x-smtpi header and sendgrid will loop
    * The following method renders xxxMailingContent.xhtml which calls xxxMailingList method 
    * which is another method of this bean and uses filters like start/end , flag etc
    * SMTP config is in testmailcofig class
    * called by MailingSend.xhtml
    * @param args via viewparam subject - mailingSubject,content - mailingSource and oneEmailTo - e1mailAddress 
    * @return -none
    * @exception EMail_send_fail
    * @see 
    * Checks how many eMails to send and gives message if none
    * otherwise renders Enity specific MailingContent.xhtml to take care of actual EMail processing
    * messages are sent to target list via x-smtpi and to imailaddr value in client record via smtp to: for copy and audit 
    */  
    mailAttachInfo="";
    bcontinue=true;
    try {
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_INFO," ",""));

        int mailingSize=getMailingList()==null?0:getMailingList().size();
        // onetime e1mailAddress may exist and comes as view param and for ebasketIn toAddress,
        if( e1mailAddress !=null &&  !e1mailAddress.isEmpty() && !(e1mailAddress.contains("@") && e1mailAddress.contains("."))){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("emailAddress")+" "+e1mailAddress+" "+bundle.getString("invalid")+" ,"+bundle.getString("expecting")+" "+bundle.getString("like")+" "+bundle.getString("xx@yy.com"), ""));
         return;
        }else{
         mailingSize=mailingSize+1;
        }
        mailingSource=${clobdataEntityName}Home.sanitize(mailingSource);
        if ( mailingSize < 1 && (e1mailAddress ==null || e1mailAddress.isEmpty()) ){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_WARN,bundle.getString("none_selected"), ""));
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO, bundle.getString("check_selection_criteria"),""));
        }
        else{
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("send")+" "+bundle.getString("started"),""));


         // if usertoEmployee has Email then use it as toAddress , if empty then use client which should have some value
         // it serves the need for a real toAddress and sender to get a copy. XSmtpi header has all the toAddresses selected including onetimeEmail
         ${employeeEntityName?cap_first} ${employeeEntityName}= ${homeName}.getCurrentUserToEmployee();
         setUserFullName((${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()) +" "+(${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()));
         if (${employeeEntityName}==null || "".equals(${employeeEntityName}) ||
             ${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()==null || 
             "".equals(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()) ){
                 ${clientEntityName?cap_first} client =(${clientEntityName?cap_first}) getEntityManager()
					.createQuery(
							"select cc from ${clientEntityName?cap_first} cc where cc.${clientKeyField} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();

          setClientEMail(client.get${clientImailaddr?cap_first}().trim());
         } 
         else{
           setClientEMail(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
         }
         // if demo user no email saved in employee except in user
         ${userEntityName?cap_first} theUser = ${userEntityName}List.getKeyToEntity(customIdentity.getUsername());
         if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
          setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
         }

         if("".equals(eMailingAddress1)){
          //eMailingAddress1="mail@3rcomputer.com";
         }
         //checkMapI[1],2 etc was set via checkBoxes
         if (checkMapI[1]){ 
          setMailingImage1(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          mailAttachInfo=mailAttachInfo+" attach1."+mailingBytes1Type;
         }  
         if (checkMapI[2]){ 
          setMailingImage2(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          mailAttachInfo=mailAttachInfo+" attach2."+mailingBytes2Type;
         }  
         if (checkMapI[3]){ 
          setMailingImage3(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          mailAttachInfo=mailAttachInfo+" attach3."+mailingBytes3Type;
         }  
         if (checkMapI[4]){ 
          setMailingImage4(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          mailAttachInfo=mailAttachInfo+" attach4."+mailingBytes4Type;
         }  
         if (checkMapI[5]){ 
          setMailingImage5(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          mailAttachInfo=mailAttachInfo+" attach5."+mailingBytes5Type;
         }  
         // mailingtext1,2 etc are saved as string but mailcontent converts to byte
         // add logic to include as attach
         setMailingText(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",0,12000) );

         if (checkMapT[1]){ 
          setMailingText1(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",1,12000) );
          mailAttachInfo=mailAttachInfo+" attach1.txt";
         }  
         if (checkMapT[2]){ 
          setMailingText2(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",2,12000) );
          mailAttachInfo=mailAttachInfo+" attach2.txt";
         }  
         if (checkMapT[3]){ 
          setMailingText3(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",3,12000) );
          mailAttachInfo=mailAttachInfo+" attach3.txt";
         }  
         if (checkMapT[4]){ 
          setMailingText4(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",4,12000) );
          mailAttachInfo=mailAttachInfo+" attach4.txt";
         }  

         if (checkMapT[5]){ 
          setMailingText5(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",5,12000) );
          mailAttachInfo=mailAttachInfo+" attach5.txt";
         }  
         // signatureSource already built 

         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO," ",""));

         int ccSize=ccresults.size();
         int contSize=0;
         <#if (menuAttributesp2 ="20" && ccontactEntityName?? && ccontactEntityName?length > eL)>
         contSize=conresults.size();
         </#if>
         <#if (menuAttributesp2 ="30" && vcontactEntityName?? && vcontactEntityName?length > eL)>
         contSize=vonresults.size();
         </#if>
         if (contSize < 1){
          if(group.trim().isEmpty()){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("group")+" "+group+" "+Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }         
         }else{
          if(group.trim().isEmpty()){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("contacts")+" "+bundle.getString("count")+" "+Integer.toString(contSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("group")+" "+group+" "+Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("contacts")+" "+bundle.getString("count")+" "+Integer.toString(contSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }
         }
         // logic below now uses sendgrid smtpX and no looping here
         // build x-smtpi header
          buildXsmtpi();// has loop to go over customer etc list. unsubscribe logic moved there
         //buildXsmtpi allways puts senders email in to list for a copy of what was sent and we need not save in clobdata

          //show only the last email sent
          timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 	  log.severe("email render start "+ timeStamp);
          // getShowNamesYN already taken care of in buildXsmtpi
          //renderer.render("/${entityName?substring(eL)}MailingContent.xhtml");
          emailRender("/${entityName?substring(eL)}MailingContent.xhtml","x");

          timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 	  log.severe("email render end "+ timeStamp);
          if(!bcontinue){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+bundle.getString("failed"),""));
           return; 
          }
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+bundle.getString("done")+" "+bundle.getString("ending")+" "+bundle.getString("with")+" "+${componentName}.get${imailaddrField?cap_first}(),""));

          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+ bundle.getString("attachment")+" "+bundle.getString("selections")+" "+bundle.getString("before")+" "+bundle.getString("next")+" "+bundle.getString("send"),""));
          //removed logic to reset check boxes because under converation scope they get set back by jsf
          timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 	  log.severe("email msg end "+ timeStamp);
         //save or update a copy of subject and source in clob data jay do it before sending so that can be sent manualy if needed
		 ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-STATUS",ownerCode,0);
                 if(${clobdataEntityName} == null){   
                  ${clobdataEntityName}Home.clearInstance();
		  ${clobdataEntityName} = ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
		  ${clobdataEntityName}.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  ${clobdataEntityName}.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-STATUS");
		  ${clobdataEntityName}.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  ${clobdataEntityName}.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  if(group.trim().isEmpty()){
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  ${clobdataEntityName}.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  ${clobdataEntityName}Home.persist();
                 }else{
                  if(group.trim().isEmpty()){
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
                  ${clobdataEntityName}Home.superUpdate();
                 }///
		 ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-CONTENT",ownerCode,0);
                 if(${clobdataEntityName} == null){   
                  ${clobdataEntityName}Home.clearInstance();
		  ${clobdataEntityName} = ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
		  ${clobdataEntityName}.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  ${clobdataEntityName}.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-CONTENT");
		  ${clobdataEntityName}.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  ${clobdataEntityName}.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  // add to/cc list as a line
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  ${clobdataEntityName}.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  ${clobdataEntityName}Home.persist();
                 }else{
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
                  ${clobdataEntityName}Home.superUpdate();
                 }

          return;
        }//mailingSize check 
/* sendgrid email is sent using smtp but curl api end point can also be used. To test API key authentication we can use curl rather than telnet for smtp. 
curl --request POST \
--url https://api.sendgrid.com/v3/mail/send \
--header 'Authorization: Bearer <<YOUR_API_KEY>>' \
--header 'Content-Type: application/json' \
--data '{"personalizations":[{"to":[{"email":"john.doe@example.com","name":"John Doe"}],"subject":"Hello, World!"}],"content": [{"type": "text/plain", "value": "Heya!"}],"from":{"email":"sam.smith@example.com","name":"Sam Smith"},"reply_to":{"email":"sam.smith@example.com","name":"Sam Smith"}}'
*/
    } catch (Exception e) {
         log.severe("Error sending mail"+ e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"Email sending failed: " + e.getMessage(),""));
    }
   }


</#if>
/**
*  used to send emails and called by send() and previewSend or from cart/txn esend to send txn and regular emails
* 1. if mailRelayoff  in client version/record 01 has checkmark blank (default) , then gather mailRelay (05 record) smtp server/port/etc information ,
* 2. if mailRelayoff has checkMark on, then gather site (01 record) smtp server/port/etc information
* 3. Then gather gmail server information, if record 07 has information
* 4  If valid gMail info then use it, otherwise use mailRelay or site smtp depending on mailRelayOff checkbox.
* 5. As redundancy, mailRelay will be tried if other options fail 
* for flag e we can use variable mailingAddress to override toAddress,name and client email as cc (add as an option via client flag)
* for flag x we dont override, x-smtpi header has the email addresses and client email gets a copy as a real toAddress
* default can stay, its better to overide with clientEmail , also ebasketin will override it, icalsend uses mailingAddress(??)  
* templates will replace subject and body only
* header("X-SMTPAPI",headers) for m:header name="X-SMTPAPI" value="${'#'}{${listName}.headers}" 
* headers xml string of all to: addresses
" @see "xxxcustomerhome emailRender method to send admin type emails"
* @see "createClientRecord01 for record01 and 05"
*/ 

      public Void emailRender(String content,String flag) throws MessagingException, IOException{
         String fromName = this.owner2Code;//site name
         String fromAddress = " ";//override this with xxx.yyyy.com where yyyy.com is registered with sendgrid or mail relay server
         String siteAddress05="";// if site uses email address using another domain name
         // to avoid spam or phising warning.
         // mail relay is done using @3rcomputer.com mail service, so fromAddress should match domain name
         //esend() already put value in clientEMail
         //fromAddress=clientEMail;
         if(!mailRelayOff){
          fromAddress ="via@"+customIdentity.getMasterSiteUrl(); // via@3rcomputer.com if mailRelay otherwise smtpuser say mail@raaspi.com  or xxx@gmail.com
         }else{
          fromAddress=getClientEMail();//useremployee/client email
         }
         String replyToName = "No Reply";
         String replyToAddress ="no-reply@" +customIdentity.getMasterSiteUrl(); //no-reply@3rcomputer.com
         // stack forum says replyTo can be diff from from domain name, so use logon id user email , can create a user with no-reply email
         // for replyTo try using clientEMail which is employee email or client email sept05 check for empty
         replyToName= " ";
         if(!clientEMail.isEmpty()){
          replyToAddress=clientEMail;
         }
         String toName = "support ";
         String toAddress = "support@"+customIdentity.getMasterSiteUrl(); //support@3rcomputer.com
         String ccName = "ratna";
         String ccAddress = ""; 

         String htmlBody = "<html><body><b>Hello</b> World!</body></html>";
         String textBody = "This is a Text Body!";

         String ENVELOPE_FROM_ADDRESS = "support@"+customIdentity.getMasterSiteUrl();//support@3rcomputer.com

         //SessionConfig mailConfig = TestMailConfigs.standardConfig();
         String messageId = "id@"+customIdentity.getMasterSiteUrl(); //jay@3rcomputer.com
         String host05="smtp.sendgrid.net";
         String host="smtp.sendgrid.net";
         int port05=587;
         int port=587;//465 is used for ssl only, which is replaced by tls. 587 is used by both tls and non ssl
         String userName05="apikey";
         String userName="apikey";
         String password05="SG.BxxxxxxxxxxyyyyyiBg";//manually enter in client record 05
         String password="SG.BxxxxxxxxxxyyyyyiBg";//manually enter in client records
         boolean auth=true;
         String auth_mechanisms="LOGIN PLAIN DIGEST-MD5 NTLM";
         //gmail use XOAUTH2 , if null auth will use id/password, if XOAUTH2 then email as id/access token 
         // as password. if client version 07 record has value in id (refresh token) and in secret(access token) 
         // then set XOAUTH2 so that java mail will use OAUTH. client version 01 will still hold id/pw for
         // non gmail send like sendgrid or hostpapa or zoho smtp send
         boolean ssl=false;// ssl is outdated and not supported here, disable AVG to test locally
         boolean tls=false;// in case of zoho antivirus like AVG blocks request, works ok in openshift
         mailRelayOff=false;
         Boolean smtpError=false;
         try {
          //${clientEntityName?cap_first} client=${clientEntityName}List.getKeyToEntity("01"); needs inject
          ${clientEntityName?cap_first} client =(${clientEntityName?cap_first}) entityManager
	.createQuery(
	"select cc from ${clientEntityName?cap_first} cc where cc.${clientClientversion} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
	.setParameter("nKeyName","01")
	.setParameter("owner2", owner2Code)
	.getSingleResult();

          if (client == null) {
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("create") +" "+bundle.getString("site") +" "+bundle.getString("first"),""));

                       return null ;
                      }
                      if(client.getP1xxfxxxbvxxxxxxxxxxconfirm()!=null ){
                        mailRelayOff=client.getP1xxfxxxbvxxxxxxxxxxconfirm();
                      }else{//null means default is mailrelay
                        mailRelayOff=false;
                      }
                      if(!mailRelayOff){
                       //means mailRelayOn,added logic here to read default values from client record 05 for default smtp relay server like sendgrid
                       ${clientEntityName?cap_first} client05 =null;
                       try {
                              client05 =(${clientEntityName?cap_first}) entityManager
		.createQuery(
		"select cc from ${clientEntityName?cap_first} cc where cc.${clientClientversion} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
		.setParameter("nKeyName","05")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                             if(client05 !=null){
                              fromAddress=client05.getD5xxuxxrbvxxxxxxxxxxrmailaddr();//show in o5 quick edit, need to match the sender info setup in mailrelay server
                              siteAddress05=client05.getD4xxhxxrbv24xxxxxxxximailaddr();//exmpl mail@raaspi.com 
                              host=client05.getZ8xxuxxxbvxxxxxxxxxxsmtpserver().trim();//exmpl smtp.sendgrid.net
                              userName=client05.getZ9xxuxxxbvxxxxxxxxxxsmtpuser().trim();//exmpl apikey if sendgrid. logic may need change to support other mailRelay server 
                              userName05=userName;
                              password=client05.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();//access token
                              password05=password;
                              if(password == null || password.isEmpty() || password.equals("SG.BxxxxxxxxxxyyyyyiBg") ){
                               smtpError=true; //both record 01 and 05 checked
                               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                FacesMessage.SEVERITY_INFO,bundle.getString("MailRelay") +" "+host+" "+bundle.getString("smtp")+" "+bundle.getString("password")+" / "+bundle.getString("ApiSecret")+" "+bundle.getString("information") +" "+bundle.getString("invalid"),""));
                               bcontinue=false;
                               return null;
                              }
                             }
                        } catch (Exception exc) {
                               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                FacesMessage.SEVERITY_INFO,bundle.getString("Client") +" "+bundle.getString("record")+" "+bundle.getString("05")+" "+bundle.getString("for")+" "+bundle.getString("mailRelay") +" "+bundle.getString("missing"),""));
                               bcontinue=false;
                               return null;
                        }
                      }else{
                       if(client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver()!=null && !client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver().isEmpty()){
                        host=client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver().trim();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("host")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser()!=null && !client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser().isEmpty()){
                        userName=client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser().trim();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("userName")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getZaxxuxxxssxxxxxxxxxxsmtppass()!=null && !client.getZaxxuxxxssxxxxxxxxxxsmtppass().isEmpty()){
                        password=client.getZaxxuxxxssxxxxxxxxxxsmtppass().trim();
                       }else{
                         //smtpError=true; check record 07 then act
                         //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           //FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("password")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getL6xxzxxrbvxxxxxxxxxxaltselen()!=null && client.getL6xxzxxrbvxxxxxxxxxxaltselen() !=0){
                        port=client.getL6xxzxxrbvxxxxxxxxxxaltselen();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("port")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getO9xxfxxxbvxxxxxxxxxxbeepsou()!=null ){
                        auth=client.getO9xxfxxxbvxxxxxxxxxxbeepsou();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("auth")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getP2xxfxxxbvxxxxxxxxxxlinefeed()!=null ){
                        tls=client.getP2xxfxxxbvxxxxxxxxxxlinefeed();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("ssl")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(smtpError){
                        bcontinue=false;
                        return null;
                       } 
          }
         } catch (Exception exc) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
            bcontinue=false;
            return null; 
         }
         // raaspi and lraaspi record 07 holds gmail Oauth app id/secret not refresh/access 
         ${clientEntityName?cap_first} client = null;
         if(owner2Code.contains(masterSiteCode) || owner2Code.contains("l++masterSiteCode")
           || !mailRelayOff ){
          //skip checking record 07, will not use gmail OAuth. It will use record 01 set up
         }else{
          // check Gmail smtp or not. Note client record below points to version 07 not 01
          //${clientEntityName?cap_first} client=${clientEntityName}List.getKeyToEntity("07");
         try {
          client =(${clientEntityName?cap_first}) entityManager
					.createQuery(
							"select cc from ${clientEntityName?cap_first} cc where cc.${clientClientversion} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","07")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
          if(client !=null && client.getDaxxuzxdssxxxxxxxxxxapiclientid() !=null && !client.getDaxxuzxdssxxxxxxxxxxapiclientid().isEmpty()
              && client.getDbxxuzxdssxxxxxxxxxxapiclientsecret() !=null && !client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().isEmpty()){
           auth_mechanisms="XOAUTH2";//gmail smtp
           password=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();//access token
           //check if token expired and refresh if needed
           calendar.getTime();
           calendare.setTime(client.getZfxxcztxlxxxxxxxxxxxstatusfldt());
           calendare.add(Calendar.MINUTE, 59);
           if(calendare.before(calendar)){
            password=r3RestClient.getAccessTokenGMail(client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim(),"refresh_token",owner2Code );
           }      
           if(password == null || password.isEmpty()){
            smtpError=true; //both record 01 and 07 checked
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("GMail") +" "+bundle.getString("smtp")+" "+bundle.getString("password")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
            return null;
           }
          }else{
           //access token may fail, check for it in mail send 
           // if needed use restclient to request new access but avoid user permission by using refresh token
           // in restclient use scope offline (user not needed) to get refresh token
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,host+" "+bundle.getString("client")+" "+bundle.getString("record") +" "+bundle.getString("version")+" "+bundle.getString("07") +" "+bundle.getString("needs")+" "+bundle.getString("both") +" "+bundle.getString("id")+" "+bundle.getString("and") +" "+bundle.getString("secret"),""));
            return null;
          }
         } catch (Exception exc) {
           //ignore no record 07 normal occurrence, can use resultList 
         }
         if(password == null || password.isEmpty()){// will come here only if record 01 pw missing
          smtpError=true; //both record 01 and 07 checked
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("password")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
          return null;
         }
         }//common  for both Raaspi or other sites, raaspi cannot use gmail smtp

         String smtpDomain="";
         urlIndex=host.indexOf(".");
         if (urlIndex != -1){
          smtpDomain=host.substring(urlIndex+1);
         }
         if(smtpDomain.isEmpty()){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,host+" "+bundle.getString("smtp")+" "+bundle.getString("domain") +" "+bundle.getString("empty"),""));
           return null;
         }
         // in case of mailRelay fromAddress matches smtp server 3rcomputer, sendgrid is not smtp server
         if(mailRelayOff && !fromAddress.contains(smtpDomain)){
          /* that's how non cpanel emails work ie use relay but spf/dkim seems to work ok
          if(fromAddress.contains("doNotReply@")){
           fromAddress="doNotReply@"+smtpDomain;
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO, bundle.getString("from")+" "+bundle.getString("email")+" "+bundle.getString("address")+" "+bundle.getString("defaulting")+" "+bundle.getString("to")+" "+fromAddress+", "+bundle.getString("ensure")+" "+bundle.getString("it")+" "+bundle.getString("exists"),""));
          }else{
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_WARN,bundle.getString("select cc from_address") +" "+fromAddress+", "+bundle.getString("domain") +" "+bundle.getString("not")+" "+bundle.getString("matching")+" "+bundle.getString("smtp")+" "+bundle.getString("server")+" "+bundle.getString("domain")+" "+smtpDomain,""));
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_WARN,bundle.getString("sent") +" "+bundle.getString("emails")+" "+bundle.getString("may")+" "+bundle.getString("get")+" "+bundle.getString("rejected")+" "+bundle.getString("by")+" "+bundle.getString("email")+" "+bundle.getString("clients"),""));
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_WARN,bundle.getString("Sender") +" "+bundle.getString("email")+" "+bundle.getString("address")+" "+bundle.getString("should")+" "+bundle.getString("be")+" "+bundle.getString("changed")+" "+bundle.getString("to")+" "+bundle.getString("avoid")+" "+bundle.getString("warning"),""));
          }
          */
         }else{
            //relay being used , via@xxx needs to be specified and site may not have its own domain email . They need to be specified in client record 05 field 
            if(siteAddress05 != null && !siteAddress05.isEmpty()){
             ENVELOPE_FROM_ADDRESS=siteAddress05;
            }
         }

         
         SessionConfig mailConfig = TestMailConfigs.standardConfig(host,port,userName,password,auth,tls,auth_mechanisms);
 

         EmailMessage e;

         String uuid = java.util.UUID.randomUUID().toString();
         String subjectTemplate = "Text Message from ${version} Mail - " + uuid;
         String version = "simple-mail";
         String subject = "Text Message from " + version + " Mail - " + uuid;
         String useTemplate="${entityName?substring(eL)}MailingContent.fmt";
         toName = this.eMailFirstName+" "+this.eMailLastName;
         //this needs to be a valid format but not used. headers have real to:list
         //override default value using pickList
         subjectTemplate=this.mailingSubject;
         boolean anyAtt=false;
         MailMessage mm =null;
         // ios email client needs attachment suffix to match actual mime type, cannot hardcode pdf or just .txt 
         //for attacments display 3R-ATTACHMENT-1-C qualifier PIC for blob and TXT for clob. type holds mime 
         // email content is html, so image or html data can be embedded instead of attachment 
     
       try{
         //esend from cart/transaction, assume pdf rerports for now, flag is x if mailing>send>customer.
         // esend from cart/transaction can be any of pdf/html/csv etc atleast pdf or html
         //if html then it can be embedded (preferred) not as attachment
         if(flag.equals("e")){
         <#if menuAttributesp2 == "33" >
         subjectTemplate=bundle.getString("Quotation")+" "+bundle.getString("Request")+" "+bundle.getString("from")+" "+owner2Code;
         <#elseif menuAttributesp2 == "34" >
         subjectTemplate=bundle.getString("Order")+" "+bundle.getString("Request")+" "+bundle.getString("from")+" "+owner2Code;
         <#elseif menuAttributesp2 == "37" >
         subjectTemplate=bundle.getString("Shipment")+" "+bundle.getString("Request")+" "+bundle.getString("from")+" "+owner2Code;
         <#elseif menuAttributesp2 == "3A" >
         subjectTemplate=bundle.getString("Invoice")+" "+bundle.getString("Confirmation")+" "+bundle.getString("from")+" "+owner2Code;
         <#elseif menuAttributesp2 == "38" >
         subjectTemplate=bundle.getString("Payment")+" "+bundle.getString("Confirmation")+" "+bundle.getString("from")+" "+owner2Code;
         <#elseif menuAttributesp2 == "56" >
         subjectTemplate=bundle.getString("Follow")+" "+bundle.getString("up")+" "+bundle.getString("from")+" "+owner2Code;
         <#elseif menuAttributesp2 == "89" >
         //set in evite subjectTemplate=bundle.getString("Meeting")+" "+bundle.getString("invite")+" "+bundle.getString("from")+" "+owner2Code;
         <#else>
         subjectTemplate=bundle.getString("Transaction")+" "+bundle.getString("Receipt")+" "+bundle.getString("from")+" "+owner2Code;
         </#if>
         //emailingContent for emailing and attaching report as receipt 
          toName="";// mailingAddress set by esend using mailTo, headers are empty todo allow multilingual
          toAddress=mailingAddress;
          if(siteAddress05 !=null && !siteAddress05.isEmpty()){
           toAddress=siteAddress05;// avoid invalid email addr ie no email addr for site domain
          }
          useTemplate="${entityName?substring(eL)}eMailingContent.fmt";
         <#if menuAttributesp2 == "56" || menuAttributesp2 == "89">
           if(!mailRelayOff){
               e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).send();

           }else{
               e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).send();
           }
           String toS=toAddress;
           if(toS==null || toS.isEmpty()){
            toS="not selected";
           } 
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("sent")+" "+bundle.getString("to")+": "+toS,""));
           return null;
         }
         <#else>
         // esend from cart/transaction can be any of pdf/html/csv etc. If html, add report html text 
         // at end of bodyHtml
          String reportBody="";

          if(multilingualYN){
           if(!mailRelayOff){
               if(displayAs.equals("EMAILHTML") || displayAs.equals("SEMAIL")){
                reportBody=mailingSource+sBuffer.toString();
                e =
                    new MailMessageImpl(mailConfig).contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(reportBody)
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).send();

               }else{
                e =
                    new MailMessageImpl(mailConfig).contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).addAttachment(
                            new InputStreamAttachment("${entityName?substring(eL)}.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
               }
           }else{
               if(displayAs.equals("EMAILHTML") || displayAs.equals("SEMAIL")){
                reportBody=mailingSource+sBuffer.toString();
                e =
                    new MailMessageImpl(mailConfig).contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(reportBody).send();
               }else{
                e =
                    new MailMessageImpl(mailConfig).contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addAttachment(
                            new InputStreamAttachment("${entityName?substring(eL)}.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
               }
           }
          }else{
            if(!mailRelayOff){
               if(displayAs.equals("EMAILHTML") || displayAs.equals("SEMAIL")){
                reportBody=mailingSource+sBuffer.toString();
               e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(reportBody)
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).send();
             }else{ 
               e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).addAttachment(
                            new InputStreamAttachment("${entityName?substring(eL)}.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
             }
            }else{
               if(displayAs.equals("EMAILHTML") || displayAs.equals("SEMAIL")){
                reportBody=mailingSource+sBuffer.toString();
               e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(reportBody)
                            .put("list", this).send();
              }else{
               e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addAttachment(
                            new InputStreamAttachment("${entityName?substring(eL)}.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
              }
           }//relay
          }//multil
           String toS=toAddress;
           if(toS==null || toS.isEmpty()){
            toS="not selected";
           } 
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("sent")+" "+bundle.getString("to")+": "+toS,""));
          return null;
         }
        </#if>
         //x from send or previewsend,check for attachment blob/vlob data type and adjust mm.attach
         //flag is i if esend from cart/transaction and already checked
         if(flag.equals("x")){
          // x is MailingContent for regular emailing w optional attachments and using xsmtpi where long tolist is in header but also sends
          // to toList value , getClientEmail tries to get an email related to user employee/client site and puts the value in mailingAddress
          subjectTemplate=this.mailingSubject;
          // added ! to use sender's email, not default
          if(!getClientEMail().isEmpty() && !mailingAddress.isEmpty()){
           toAddress=mailingAddress;// should not be empty if empty  then default is support@customIdentity.getMasterSiteUrl()
          }///  value in e1mailAddress including coming from ebasketin gets added to xsmtpi header toAddress
          if(siteAddress05 !=null && !siteAddress05.isEmpty()){
           toAddress=siteAddress05;// avoid invalid email addr ie no email addr for site domain
          }
          //if(!e1mailAddress.isEmpty()){
           //toAddress=e1mailAddress;
          //}
          if(!mailRelayOff){
           //gets toAddress+from headers
          }else{
           //if no mailRelay,multiple addresses needs to be a collection. In case of relay simpleMail was getting
           // one toaddress as relay was getting list via header, now no header and it will get all receiepients
           // could not get java.lang.String addresslist to work, so switched to adding one entry at a time
           //  didnt work before because list is String ... which is array of string, not a csv,
           // we can either use myData in to(myData) and let SimpleMail loop or use the loop below to add ourselves
            mm=new MailMessageImpl(mailConfig);
           // avoid dupl,we dont need dummy toaddress like in relay
            if(!e1mailAddress.isEmpty()){
             toAddress=e1mailAddress+", "+mailInfoTo; // added onetime e1mailAddr
            }else{
             toAddress=mailInfoTo;  
             if(siteAddress05 !=null && !siteAddress05.isEmpty()){
              toAddress=siteAddress05;// avoid invalid email addr ie no email addr for site domain
             }
            }
            String[] myData = toAddress.split(", ");
            for (String s: myData) {
             if(s !=null && !s.trim().isEmpty()){ 
              if(!getShowAsBCCYN()){
               if(!getShowNamesYN()){
                mm.to(s);
               }else{
                mm.bcc(s);//showNames implies bcc or mailRelay which is like bcc
               }
              }else{
               mm.bcc(s);
              }
             }
            }
            ccAddress=mailInfoCC; 
            String[] myDataCC = ccAddress.split(", ");
            for (String s: myDataCC) {
             if(s !=null && !s.trim().isEmpty()){ 
              if(!getShowAsBCCYN()){
               if(!getShowNamesYN()){
                mm.cc(s);
               }else{
                mm.bcc(s);//showNames implies bcc or mailRelay which is like bcc
               }
              }else{
               mm.bcc(s);
              }
             }
            }
            //  ensure at least one To: to avoid spam if all bcc, plus it ensures a copy to fromAddress
            mm.to(fromAddress);                        
          }
          //at this point mm contains many To and cc and sent to SMTP server who will loop not here
          if(multilingualYN){
           if(!mailRelayOff){//bulk no mm with to,cc created yet
              mm= new MailMessageImpl(mailConfig).contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers);
           }else{
              //mm already exists with to and cc
              mm= mm.contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this);
           }
          }else{
           if(!mailRelayOff){
             mm= new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers);
           }else{
              //mm already exists with to
             mm= mm.from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this);
           }
          } 
           if (checkMapI[1]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach1."+this.getMailingImage1Type(), this.getMailingImage1TypeMime(), ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingImage1())));
           }
           if (checkMapI[2]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach2."+this.getMailingImage2Type(), this.getMailingImage2TypeMime(), ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingImage2())));
           }
           if (checkMapI[3]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach3."+this.getMailingImage3Type(), this.getMailingImage3TypeMime(), ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingImage3())));
           }
           if (checkMapI[4]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach4."+this.getMailingImage4Type(), this.getMailingImage4TypeMime(), ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingImage4())));
           }
           if (checkMapI[5]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach5."+this.getMailingImage5Type(), this.getMailingImage5TypeMime(), ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingImage5())));
           }
           if (checkMapT[1]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach1.text", "text/plain", ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingText1().getBytes())));
           }
           if (checkMapT[2]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach2.text", "text/plain", ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingText2().getBytes())));
           }
           if (checkMapT[3]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach3.text", "text/plain", ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingText3().getBytes())));
           }
           if (checkMapT[4]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach4.text", "text/plain", ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingText4().getBytes())));
           }
           if (checkMapT[5]) {
            anyAtt=true;
            mm.addAttachment(new InputStreamAttachment("attach5.text", "text/plain", ContentDisposition.INLINE,new ByteArrayInputStream(this.getMailingText5().getBytes())));
           }
           if(anyAtt){
            e=mm.send();
           }else{
            // why checking anyAtt , test mm.send for both ??
            if(multilingualYN){
             if(!mailRelayOff){
              e =
                    new MailMessageImpl(mailConfig).contentType(ContentType.ALTERNATIVE).charset("UTF-8").from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).send();
              
             }else{
              //mm already exists 
              e =
                    mm.send();
             }
           }else{
            if(!mailRelayOff){
             e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(useTemplate)).getInput()))
                            .put("list", this).addHeader("X-SMTPAPI",this.headers).send();
            }else{
              //mm already exists 
             e =
                    mm.send();
            }
           }
          }
          //still flag x here, not common point after send, esend (flag e) has a different point 
           String toS=toAddress;
           if(toS==null || toS.isEmpty()){
            toS="not selected";
           } 
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
             FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("sent")+" "+bundle.getString("to")+": "+toS,""));

         }else{
          // shouldnt come here ie flag not e or x
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("invalid")+" "+ bundle.getString("email")+" "+bundle.getString("content")+" "+bundle.getString("flag")+" "+flag,""));
         }
       } catch (Exception exc) {
         // new logic needed to handle gmail access token expiry. Treat it as expected
         //if exc.getMessage() contains 401? then call r3restclient new method getTokenOffline()
         //getTokenOffline() will save new token
         //then set a bypass flag called tokenReset and call this mailrender again
         log.severe("Error sending mail "+" "+ bundle.getString("exception")+ exc.getMessage());
           String toS=toAddress;
           if(toS==null || toS.isEmpty()){
            toS="not selected";
           } 
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+bundle.getString("failed")+" "+bundle.getString("for")+": "+toS+", "+" "+ bundle.getString("exception")+exc.getMessage(),""));
         String cause="";
         if(exc.getCause() !=null && exc.getCause().getCause()!=null){
          cause=exc.getCause().getCause().getMessage();
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("cause")+" "+ exc.getCause().getCause().getMessage(),""));
         }
         // retry with refresh if failed on bad token or expired token then only get a new token using
         // existing refresh token(client site record 07 clientId)
         // send again using new token is there subcode for expired or check token expiry?
         if(cause.contains("invalid")){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("Invalid")+" "+ bundle.getString("email")+" "+bundle.getString("may")+" "+bundle.getString("mean")+" "+bundle.getString("space ")+" "+bundle.getString("at")+" "+bundle.getString("end")+", "+" "+bundle.getString("sender")+" "+bundle.getString("email")+" "+bundle.getString("not")+" "+bundle.getString("smtp")+" "+bundle.getString("user"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("client")+" "+ bundle.getString("record")+" "+bundle.getString("05")+" "+bundle.getString("client")+" "+bundle.getString("email ")+" "+bundle.getString("field")+" "+bundle.getString("allows")+" "+bundle.getString("override"),""));
         } 
         if(cause.contains("334")){
          
          password=r3RestClient.getAccessTokenGMail(client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim(),"refresh_token",owner2Code );
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("Oauth")+" "+ bundle.getString("accessToken")+" "+bundle.getString("failure")+", ",""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("new")+" "+ bundle.getString("token")+" "+bundle.getString("received")+" "+bundle.getString("and")+" "+bundle.getString("saved"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("Please")+" "+ bundle.getString("resend")+" "+bundle.getString("the")+" "+bundle.getString("email"),""));

         }
         
       }
         return null;
      }



 <#if (menuAttributesp2 ="20" || menuAttributesp2 = "30"||menuAttributesp2="40" ) >
   public void fetchMailingStatus(){
         setMailingStatus(${clobdataEntityName}Home.getClobdata("clobdata","AMAIL-STATUS",ownerCode,0,12000) );

   }
   public Integer keyToSid(String key){
                        ${componentName}=null;
			List<${componentName?cap_first}> results =  getEntityManager()
			    .createQuery("select cc from ${componentName?cap_first} cc where cc.${keyField} = :Key AND cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  cc.${statusFlagDateField}").setParameter("owner2", owner2Code).
                            setParameter("Key", key).getResultList();
                           if(!results.isEmpty()){
                            ${componentName} = results.get(0);
                           }
                           return ${componentName}.getA0xxuobxbxxxxxxxxxxxsid();
   
   }


   public void previewSend() {
    /**
    * The following method allows preview of EMail message send.  
    * It does not send any message except one to client email for preview (tbd)
    * @param args -none
    * @return -none
    * @exception EMail_send_fail
    * @see 
    * Checks how many eMails to send and gives message if none
    * otherwise renders Enity specific MailingContent.xhtml to take care of actual EMail processing
    * messages are not sent to target list but only to imailaddr value in client record for preview and audit (tbd)
    */

    try {
        // clear
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO," ",""));
        mailInfo="";
        mailInfoTo="";
        mailInfoCC="";
        mailInfoBCC="";
        mailNameInfo="";
        int mailingSize=getMailingList()==null?0:getMailingList().size();
        if( e1mailAddress !=null &&  !e1mailAddress.isEmpty() && !(e1mailAddress.contains("@") && e1mailAddress.contains("."))){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("emailAddress")+" "+e1mailAddress+" "+bundle.getString("invalid")+" ,"+bundle.getString("expecting")+" "+bundle.getString("like")+" "+bundle.getString("xx@yy.com"), ""));
         return;
        }else{
         mailingSize=mailingSize+1;
        }
        if ( mailingSize < 1 && (e1mailAddress ==null || e1mailAddress.isEmpty()) ){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("none")+" "+bundle.getString("selected"),""));

         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("selection")+" "+bundle.getString("criteria"),""));

        }
        else{
         int ccSize=ccresults.size();
         int contSize=0;
         <#if (menuAttributesp2 ="20" && ccontactEntityName?? && ccontactEntityName?length > eL)>
         contSize=conresults.size();
         </#if>
         <#if (menuAttributesp2 ="30" && vcontactEntityName?? && vcontactEntityName?length > eL)>
         contSize=vonresults.size();
         </#if>
         if (contSize < 1){
          if(group.trim().isEmpty()){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("group")+" "+group+" "+Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }         
         }else{
          if(group.trim().isEmpty()){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("contacts")+" "+bundle.getString("count")+" "+Integer.toString(contSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("group")+" "+group+" "+Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected")+",plus "+bundle.getString("Cc")+" "+bundle.getString("count")+  Integer.toString(ccSize)+",plus "+bundle.getString("contacts")+" "+bundle.getString("count")+" "+Integer.toString(contSize)+",plus "+bundle.getString("sender")+" "+bundle.getString("copy")+" "+bundle.getString("to")+" "+clientEMail,""));
          }
         }
         ${employeeEntityName?cap_first} ${employeeEntityName}= ${homeName}.getCurrentUserToEmployee();
         setUserFullName((${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()) +" "+(${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()));
         if (${employeeEntityName}==null || "".equals(${employeeEntityName}) ||
             ${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()==null || 
             "".equals(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()) ){

                 ${clientEntityName?cap_first} client =(${clientEntityName?cap_first}) getEntityManager()
					.createQuery(
							"select cc from ${clientEntityName?cap_first} cc where cc.${clientKeyField} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
          setClientEMail(client.get${clientImailaddr?cap_first}());
         }else{
          setClientEMail(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
         }
         // if demo user no email saved in employee except in user
         ${userEntityName?cap_first} theUser = ${userEntityName}List.getKeyToEntity(customIdentity.getUsername());
         if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
          setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
         }

         //send one email to user/client email as toAddress to store the content and for preview, others including e1mailAddress are in xsmtpi header
         //checkMapI[1],2 etc was set via checkBoxes
         if (checkMapI[1]){ 
          setMailingImage1(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          mailInfo=mailInfo+" attach1."+mailingBytes1Type;
         }  
         if (checkMapI[2]){ 
          setMailingImage2(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          mailInfo=mailInfo+" attach2."+mailingBytes2Type;
         }  
         if (checkMapI[3]){ 
          setMailingImage3(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          mailInfo=mailInfo+" attach3."+mailingBytes3Type;
         }  
         if (checkMapI[4]){ 
          setMailingImage4(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          mailInfo=mailInfo+" attach4."+mailingBytes4Type;
         }  
         if (checkMapI[5]){ 
          setMailingImage5(${blobdataEntityName}Home.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5TypeMime(${blobdataEntityName}Home.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5Type(${blobdataEntityName}Home.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          mailInfo=mailInfo+" attach5."+mailingBytes5Type;
         }  
         // mailingtext1,2 etc are saved as string but mailcontent converts to byte
         setMailingText(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",0,12000) );

         if (checkMapT[1]){ 
          setMailingText1(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",1,12000) );
         }  
         if (checkMapT[2]){ 
          setMailingText2(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",2,12000) );
         }  
         if (checkMapT[3]){ 
          setMailingText3(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",3,12000) );
         }  
         if (checkMapT[4]){ 
          setMailingText4(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",4,12000) );
         }  

         if (checkMapT[5]){ 
          setMailingText5(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",5,12000) );
         }  
         // signatureSource already done in getter but rendered conditionally 
         //useTemplate used later points to xxxmailing.fmt which includes mailing source+signature source+unsubscribe source
         if(!getSignatureYN()){
          signatureSource="";
         }
         
         if(getUnsubscribeYN()){
            // we need to build and pass the html string with keyCode,sid and type to .fmt via the variable list, escape \"
            //  test showed if url has http:// and 8080 then sendgrid substitues click.3rcomputer etc
              String activationLink="";
              if(urlPort ==8080){
               activationLink = urlName+"/unsc.wflow";
              }else{
               activationLink = urlName+"/unsc.wflow";
              } 
              setUnsubscribeSource("<p style=\"font-family:arial;color:red;font-size:12px;\">Unsubscribe by clicking <a href=\""+activationLink+"?keyCode=keyx&unsc=unx&type=1\">unsubscribe</a></p>");
         }

         SMTPAPI header = new SMTPAPI();
         // jay put sender's name here instead of blank ie loop through but dont send ?, mailInfo may already have attach info
         mailInfo=mailInfo+" ";
         mailNameInfo=mailNameInfo+" sentTo names- not available in preview";
         // build x-smtpi header
         //add sender(logonid) email address to keep track of what was sent. getclientEmail will have id/user or client email
         header.addCategory(owner2Code);// can be used in webhook
         header.addTo(getUserFullName()+" <"+getClientEMail()+">") ;
         header.addSubstitution("keyx", "ignore");
         header.addSubstitution("unx", "0");
         mailInfo=mailInfo+getClientEMail()+",";
         mailInfoTo=mailInfoTo+getClientEMail()+", ";
         //mailInfo gathers attach info and clientemail but not used now
         headers = header.jsonString();
         emailRender("/${entityName?substring(eL)}MailingContent.xhtml","x");

         //timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
         //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     //FacesMessage.SEVERITY_INFO,bundle.getString("If")+" "+bundle.getString("no")+" "+bundle.getString("error")+", "+bundle.getString("preview")+" "+ bundle.getString("email")+" "+bundle.getString("sent")+" "+bundle.getString("to")+" "+getClientEMail(),""));


         //save or update a copy of subject and source in clob data jay do it before sending so that can be sent manualy if needed
		 ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-STATUS",ownerCode,0);
                 if(${clobdataEntityName} == null){   
                  ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName} = ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
		  ${clobdataEntityName}.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  ${clobdataEntityName}.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  ${clobdataEntityName}.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-STATUS");
		  ${clobdataEntityName}.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  if(group.trim().isEmpty()){
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  ${clobdataEntityName}.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  ${clobdataEntityName}Home.persist();
                 }else{
                  if(group.trim().isEmpty()){
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
                  ${clobdataEntityName}Home.superUpdate();
                 }
		 ${clobdataEntityName} = ${clobdataEntityName}List.getclobDataInstance("clobdata","AMAIL-CONTENT",ownerCode,0);
                 if(${clobdataEntityName} == null){   
                  ${clobdataEntityName}Home.clearInstance();
		  ${clobdataEntityName} = ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
		  ${clobdataEntityName}.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  ${clobdataEntityName}.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-CONTENT");
		  ${clobdataEntityName}.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  ${clobdataEntityName}.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailingSubject+"  "+mailingSource);
                  ${clobdataEntityName}.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  ${clobdataEntityName}Home.persist();
                 }else{
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailingSubject+"  "+mailingSource);
                  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
                  ${clobdataEntityName}Home.superUpdate();
                 }


        }//mailingSize check
      } catch (Exception e) {
         log.severe("Error sending mail"+ e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+bundle.getString("failed")+", "+bundle.getString("check")+" "+ bundle.getString("internet")+" "+ bundle.getString("connection")+" "+e.getMessage(),""));
    
      }
     
   }
   
  public void buildXsmtpi(){
    //called by send only and not by previewsend
    SMTPAPI header = new SMTPAPI();
    //header.addTo("test@example.com"); addTo will add , if multiple addresses
    // To and CC and e1mailAddress gets added to XSMTPI header as sendgrid does not allow cc tag. mailingcontent will show cclist as cc
    // sender email (clientEmail value) goes to toAddress
    mailInfo=" ";
    mailInfoTo="";
    mailInfoCC="";
    mailInfoBCC="";
    mailNameInfo="";
    if(getShowNamesYN()){
     if (mailAttachInfo.length() > 1){
      mailNameInfo="included "+mailAttachInfo+" Sent To ";
      }else{
      mailNameInfo=mailNameInfo+" Sent To ";
     }
    }else{
     if (mailAttachInfo.length() > 1){
      mailNameInfo="included "+mailAttachInfo;
     }else{
      mailNameInfo=mailNameInfo;
     }
    }
    //mailInfo gathers emailAddress info,  used for not emailRelay 
    //mailNameInfo used now, but jay put a limit in length
    //getMailingList has toList only
    // need to iterate over ccresults too
    Iterator<${entityName}> itr = getMailingList().iterator();
    int ilimit=0;
   try{
    header.addCategory(owner2Code);// can be used in webhook
    while (itr.hasNext()) {
     ${componentName} = itr.next();
      ++ilimit;
     <#if (menuAttributesp2 ="20") >
      header.addTo((${componentName}.getC2xxu2fnbvixxxxxxxxxfirstname()==null?"":${componentName}.getC2xxu2fnbvixxxxxxxxxfirstname())+" "+(${componentName}.getC1xxuslnbvixxxxxxxxxlastname()==null?"":${componentName}.getC1xxuslnbvixxxxxxxxxlastname())+" <"+${componentName}.getQ4xxhxxxbv24xxxxxxxximailaddr()+">") ;
      header.addSubstitution("keyx", jxxxuq201xwwqqhxxxxxcustomer.getA0xxukxxbvxxxxxxxxxxcustomer());
      header.addSubstitution("unx", jxxxuq201xwwqqhxxxxxcustomer.getA0xxuobxbxxxxxxxxxxxsid()+"");
      mailInfo=mailInfo+${componentName}.getQ4xxhxxxbv24xxxxxxxximailaddr()+", ";
      mailInfoTo=mailInfoTo+${componentName}.getQ4xxhxxxbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
       if(ilimit <101){
        mailNameInfo=mailNameInfo+(${componentName}.getC2xxu2fnbvixxxxxxxxxfirstname()==null?"":${componentName}.getC2xxu2fnbvixxxxxxxxxfirstname())+" "+(${componentName}.getC1xxuslnbvixxxxxxxxxlastname()==null?"":${componentName}.getC1xxuslnbvixxxxxxxxxlastname())+", ";
       }       
      }else{
       mailNameInfo="";
      }
      // filter out last comma later after cc
     </#if>
     <#if (menuAttributesp2 ="30") >
      header.addTo((${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(${componentName}.getB3xxuslnbvxxxxxxxxxxlastname()==null?"":${componentName}.getB3xxuslnbvxxxxxxxxxxlastname())+" <"+${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr()+">") ;
      header.addSubstitution("keyx", ${componentName}.getA0xxukxxbvxxxxxxxxxxvendor());
      header.addSubstitution("unx", ${componentName}.getA0xxuobxbxxxxxxxxxxxsid()+"");
      mailInfo=mailInfo+${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoTo=mailInfoTo+${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
       if(ilimit <101){
        mailNameInfo=mailNameInfo+(${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(${componentName}.getB3xxuslnbvxxxxxxxxxxlastname()==null?"":${componentName}.getB3xxuslnbvxxxxxxxxxxlastname())+", ";
       }       
      }else{
       mailNameInfo="";
      // filter out last comma later after vc
      }
     </#if>
     <#if (menuAttributesp2 ="40") >
      header.addTo((${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(${componentName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${componentName}.getB3xxuslnbvixxxxxxxxxlastname())+" <"+${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr()+">") ;
      header.addSubstitution("keyx", ${componentName}.getA0xxuktxbvxxxxxxxxxxemployee());
      header.addSubstitution("unx", ${componentName}.getA0xxuobxbxxxxxxxxxxxsid()+"");
      mailInfo=mailInfo+${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoTo=mailInfoTo+${componentName}.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
       if(ilimit <101){
        mailNameInfo=mailNameInfo+(${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${componentName}.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(${componentName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${componentName}.getB3xxuslnbvixxxxxxxxxlastname())+", ";
       }       
      }else{
       mailNameInfo="";
      }
     </#if>
         if(getUnsubscribeYN()){
            // we need to build and pass the html string with keyCode,sid and type to .fmt via the variable list, otherwise leave as empty
            // above header is used by sendgrid only?
            //unsubscribeSource below has keyx,unx and values are paased via list(this).unsubscribeSource
            // sendgrid sub: tag did not handle http or 8080 in <h:ref url
              String activationLink="";
              if(urlPort ==8080){
               activationLink = urlName+"/unsc.wflow";
              }else{
               activationLink = urlName+"/unsc.wflow";
              } 
             <#if (menuAttributesp2 ="20")>
              setUnsubscribeSource("<p style=\"font-family:arial;color:red;font-size:12px;\">Unsubscribe by clicking <a href=\""+activationLink+"?keyCode=keyx&unsc=unx&type=1\">unsubscribe</a></p>");
             </#if>          
             <#if (menuAttributesp2 ="30")>
              setUnsubscribeSource("<p style=\"font-family:arial;color:red;font-size:12px;\">Unsubscribe by clicking <a href=\""+activationLink+"?keyCode=keyx&unsc=unx&type=2\">unsubscribe</a></p>");
             </#if>          
             <#if (menuAttributesp2 ="40")>
              setUnsubscribeSource("<p style=\"font-family:arial;color:red;font-size:12px;\">Unsubscribe by clicking <a href=\""+activationLink+"?keyCode=keyx&unsc=unx&type=3\">unsubscribe</a></p>");
             </#if>          
         }

    }
    // get rid of last , if any employee no cc/vc 
    if(mailInfo.length() >2 && mailInfo.substring(mailInfo.length()-2,mailInfo.length()).contains(", ")){
     mailInfo=mailInfo.substring(0,mailInfo.length()-2);
    }
    if(mailInfoTo.length() >2 && mailInfoTo.substring(mailInfoTo.length()-2,mailInfoTo.length()).contains(", ")){
     mailInfoTo=mailInfoTo.substring(0,mailInfoTo.length()-2);
    }
    if(mailNameInfo.length() >2 && mailNameInfo.substring(mailNameInfo.length()-2,mailNameInfo.length()).contains(", ")){
     mailNameInfo=mailNameInfo.substring(0,mailNameInfo.length()-2);
    }

    if(ilimit >100){
       mailNameInfo=mailNameInfo+" ..more";
    }
   ///add e1mailAddress to the header but dont add it to mailName its like bcc  treat it as to not bcc
   // shownameYN will decide
    if(!e1mailAddress.isEmpty()){
      header.addTo(e1mailAddress+" <"+e1mailAddress+">") ;
    }
    header.addCategory(owner2Code);// can be used in webhook

   } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO, "To List build XSmtpi " + e.getMessage(),""));

   }
    //contacts if any
    <#if (menuAttributesp2 ="20" && ccontactEntityName?? && ccontactEntityName?length > eL)>
    Iterator<${ccontactEntityName?cap_first}> itrcon = conresults.iterator();
    try{
     while (itrcon.hasNext()) {
     ${ccontactEntityName} = itrcon.next();
      header.addTo((${ccontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname()==null?"":${ccontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname())+" "+(${ccontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname()==null?"":${ccontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname())+" <"+${ccontactEntityName}.getP8xxhxxrbv24xxxxxxxximailaddr()+">") ;
      mailInfo=mailInfo+${ccontactEntityName}.getP8xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoTo=mailInfoTo+${ccontactEntityName}.getP8xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
      mailNameInfo=mailNameInfo+(${ccontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname()==null?"":${ccontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname())+" "+(${ccontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname()==null?"":${ccontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname())+", ";
      }
     }
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO, "To List build XSmtpi " + e.getMessage(),""));

    }
    // get rid of last , if any customer/contact
    if(mailInfo.length() >2 && mailInfo.substring(mailInfo.length()-2,mailInfo.length()).contains(", ")){
     mailInfo=mailInfo.substring(0,mailInfo.length()-2);
    }
    if(mailInfoTo.length() >2 && mailInfoTo.substring(mailInfoTo.length()-2,mailInfoTo.length()).contains(", ")){
     mailInfoTo=mailInfoTo.substring(0,mailInfoTo.length()-2);
    }
    if(mailNameInfo.length() >2 && mailNameInfo.substring(mailNameInfo.length()-2,mailNameInfo.length()).contains(", ")){
     mailNameInfo=mailNameInfo.substring(0,mailNameInfo.length()-2);
    }
    </#if>
    <#if (menuAttributesp2 ="30" && vcontactEntityName?? && vcontactEntityName?length > eL) >
    Iterator<${vcontactEntityName?cap_first}> itrcon = vonresults.iterator();
    try{
     while (itrcon.hasNext()) {
     ${vcontactEntityName} = itrcon.next();
      header.addTo((${vcontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname()==null?"":${vcontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname())+" "+(${vcontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname()==null?"":${vcontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname())+" <"+${vcontactEntityName}.getL4xxhxxrbv24xxxxxxxximailaddr()+">") ;
      mailInfo=mailInfo+${vcontactEntityName}.getL4xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoTo=mailInfoTo+${vcontactEntityName}.getL4xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
      mailNameInfo=mailNameInfo+(${vcontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname()==null?"":${vcontactEntityName}.getB4xxu3frbvixxxxxxxxxfirstname())+" "+(${vcontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname()==null?"":${vcontactEntityName}.getB3xxuslrbvixxxxxxxxxlastname())+", ";
      }
     }
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO, "To List build XSmtpi " + e.getMessage(),""));

    }
    // get rid of last , if any vendor/vontact
    if(mailInfo.length() >2 && mailInfo.substring(mailInfo.length()-2,mailInfo.length()).contains(", ")){
     mailInfo=mailInfo.substring(0,mailInfo.length()-2);
    }
    if(mailInfoTo.length() >2 && mailInfoTo.substring(mailInfoTo.length()-2,mailInfoTo.length()).contains(", ")){
     mailInfoTo=mailInfoTo.substring(0,mailInfoTo.length()-2);
    }
    if(mailNameInfo.length() >2 && mailNameInfo.substring(mailNameInfo.length()-2,mailNameInfo.length()).contains(", ")){
     mailNameInfo=mailNameInfo.substring(0,mailNameInfo.length()-2);
    }
    </#if>

    //loop through CC and add to xsmtpi header for relay, need mailInfoCC like mailInfoTo logic for non relay
    mailInfoCC="";//had  infoTo values
    Iterator<${employeeEntityName?cap_first}> itre = ccresults.iterator();
   try{
    while (itre.hasNext()) {
      ${employeeEntityName} = itre.next();
      header.addTo((${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname())+" <"+${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()+">") ;
      mailInfo=mailInfo+${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoCC=mailInfoCC+${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
       if(mailNameInfo !=null && !mailNameInfo.isEmpty()){
        mailNameInfo=mailNameInfo+", ";
       } 
       mailNameInfo=mailNameInfo+(${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname().substring(0,1))+" "+(${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname())+", ";
      }
    //add sender(logonid) email address to keep track of what was sent. getclientEmail will have id/user or client email
     header.addTo(getUserFullName()+" <"+getClientEMail()+">") ;
     mailInfoCC=mailInfoCC+getClientEMail()+", ";
 
    }
    headers = header.jsonString();
    //headers=headers.replace("\"","&quot;");
   } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO, "CC List build XSmtpi " + e.getMessage(),""));
   }
    // get rid of last , if any cc/employee 
    if(mailInfo.length() >2 && mailInfo.substring(mailInfo.length()-2,mailInfo.length()).contains(", ")){
     mailInfo=mailInfo.substring(0,mailInfo.length()-2);
    }
    if(mailInfoCC.length() >2 && mailInfoCC.substring(mailInfoCC.length()-2,mailInfoCC.length()).contains(", ")){
     mailInfoCC=mailInfoCC.substring(0,mailInfoCC.length()-2);
    }
    if(mailNameInfo.length() >2 && mailNameInfo.substring(mailNameInfo.length()-2,mailNameInfo.length()).contains(", ")){
     mailNameInfo=mailNameInfo.substring(0,mailNameInfo.length()-2);
    }

  }
</#if>

 <#if (menuAttributesp2 ="89"  ) >
  
   public void icalSend(String source) {
    /**
    * The following method renders xxxMailingContent.xhtml which calls xxxMailingList method 
    * which is another method of this bean and uses filters like start/end , flag etc
    * This method uses source parameter to determine which result to use ie employee/vendor/customer
    * SMTP config is in jboss appserver components.xml
    * @param args -none
    * @return -none
    * @exception EMail_send_fail
    * @see 
    * Checks how many eMails to send and gives message if none
    * otherwise renders Enity specific MailingContent.xhtml to take care of actual EMail processing
    * messages are sent to target list and to imailaddr value in client record for copy and audit 
    */
    String context="";
    if(source.equals("e")){
     context="employee";
    }
    if(source.equals("v")){
     context="vendor";
    }
    if(source.equals("c")){
     context="customer";
    }
    try {
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString(""),""));


        int mailingSize=(eresults==null?0:eresults.size())+(vresults==null?0:vresults.size())+(cresults==null?0:cresults.size());
        if ( mailingSize < 1){
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("no")+" "+bundle.getString("email")+" "+bundle.getString("match")+" "+bundle.getString("found")+" "+bundle.getString("for")+" "+context,""));

         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("selected")+" "+context+" "+bundle.getString("details")+"/ "+bundle.getString("unsubscribe")+" "+bundle.getString("flag"),""));


        }
        else{
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("send")+" "+ bundle.getString("started"),""));



         if("".equals(eMailingAddress1)){
          //eMailingAddress1="mail@3rcomputer.com";
         }
         
         setMailingText(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",0,12000) );

         if (eMailingTextAttachSeq1 != -1){ 
          setMailingText1(${clobdataEntityName}Home.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",eMailingTextAttachSeq1,12000) );
         }  
         // signatureSource already done 
         //jay repeat here rather than ui:repeat to avoid 5 mts time out in Mandrill streaming ie 504 issue 
         // but will mean connection for each send 
         // or add logic if sendgrid to use x-smtp header to offload sending list to sendgrid server
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,Integer.toString(mailingSize)+" "+bundle.getString("recipients")+" "+bundle.getString("with")+" "+bundle.getString("emailaddress")+" "+bundle.getString("selected"),""));


        if(source.equals("e")){
         Iterator<${employeeEntityName?cap_first}> itr = eresults.iterator();
         while (itr.hasNext()) {
          //FacesMessages.instance().clear();
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO," ",""));


 	  ${employeeEntityName} = itr.next();
          setEmailFirstName(${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname());
          setEmailLastName(${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname());
          setEmailAddress(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr());
          mailInfo=mailInfo+${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()+",";
          //renderer.render("/${entityName?substring(eL)}MailingContent.xhtml");
          mailingAddress=eMailAddress;
           emailRender("/scheduleMailingContent.fmt","e");
         }
        }else if (source.equals("v")){
         Iterator<${vendorEntityName?cap_first}> itr = vresults.iterator();
         while (itr.hasNext()) {
          //FacesMessages.instance().clear();
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO," ",""));

 	  ${vendorEntityName} = itr.next();
          setEmailFirstName(${vendorEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname());
          setEmailLastName(${vendorEntityName}.getB3xxuslnbvxxxxxxxxxxlastname());
          setEmailAddress(${vendorEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr());
          mailInfo=mailInfo+${vendorEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr()+",";
          //renderer.render("/${entityName?substring(eL)}MailingContent.xhtml");
          mailingAddress=eMailAddress;
           emailRender("/scheduleMailingContent.fmt","e");
         }
        }else if (source.equals("c")){
         Iterator<${customerEntityName?cap_first}> itr = cresults.iterator();
         while (itr.hasNext()) {
          //FacesMessages.instance().clear();
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO," ",""));

 	  ${customerEntityName} = itr.next();
          setEmailFirstName(${customerEntityName}.getC2xxu2fnbvixxxxxxxxxfirstname());
          setEmailLastName(${customerEntityName}.getC1xxuslnbvixxxxxxxxxlastname());
          setEmailAddress(${customerEntityName}.getQ4xxhxxxbv24xxxxxxxximailaddr());
          mailInfo=mailInfo+${customerEntityName}.getQ4xxhxxxbv24xxxxxxxximailaddr()+",";
          //renderer.render("/${entityName?substring(eL)}MailingContent.xhtml");
          mailingAddress=eMailAddress;
           emailRender("/scheduleMailingContent.fmt","e");
         }
        }else{
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_INFO,bundle.getString("unknown")+" "+ bundle.getString("source")+" "+source,""));



        }
        
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+ bundle.getString("done")+", "+ bundle.getString("last")+" "+ bundle.getString("email")+" "+eMailAddress,""));



         //save a copy of subject and source in clob data jay do it before sending so that can be sent manualy if needed
         // do not reuse because unlike MAIL-CONTENT, no control when gets created and overwritten
         // automatic purge of these and others if date is old
                  ${clobdataEntityName}Home.clearInstance();
		  ${clobdataEntityName} = ${clobdataEntityName}Home.getInstance();
		  ${clobdataEntityName}Home.setInstance(${clobdataEntityName});
		  ${clobdataEntityName}.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  ${clobdataEntityName}.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-SENT");
		  ${clobdataEntityName}.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  ${clobdataEntityName}.set${clobdataentityDataFieldName?cap_first}(mailInfo+" "+mailingSubject+this.getMailingSource());
                  ${clobdataEntityName}.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  ${clobdataEntityName}Home.persist();

        } 
    } catch (Exception e) {
      log.severe("Error sending mail"+ e);
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO, "Email sending failed: " + e.getMessage(),""));


    }
   }
</#if>

<#if (menuAttributesp2 =="18") && activityEntityName??> 
	public List<${entityName}> getActivityDetailsBrowseList() {
	   // for all activities
           // category for hierarchy order and type (not used now) for what to include
           // category 0 means ignore parentcode
       // if search was used then show search results 
       if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
        return sresults;
       }
          FacesContext facesContext = FacesContext.getCurrentInstance();
	  Map<String,String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
       category=0;
       subcategory=0;
       String type="%";//all ie detail or category or subcategory
       String type2="SI-L%";//categoey or subcategory
       if (params.get("category") != null &&  !params.get("category").isEmpty()){ 
	   category = Integer.parseInt(params.get("category"));
       }
       if (params.get("subcategory") != null &&  !params.get("subcategory").isEmpty()){ 
	   subcategory = Integer.parseInt(params.get("subcategory"));
       }
           // all  details either point to a category or to a subcategory under a category
           // so if category is selected then details will display only those directly under category
           // if subcategory is selected then details will display only those directly under sub category
      try{
        if (subcategory != 0 ){
		List<${activityEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${activityEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.${activityEntityName}.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
       if (category == 0 ){
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
		List<${activityEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${activityEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c5xxuxxrbv37xxxxxxxxtype LIKE :type AND cc.c5xxuxxrbv37xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
                // show details only not sub category activity
		List<${activityEntityName?cap_first}> results = getEntityManager()
		 .createQuery(
		  "select cc from ${activityEntityName?cap_first} cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c5xxuxxrbv37xxxxxxxxtype LIKE :type OR cc.c5xxuxxrbv37xxxxxxxxtype NOT LIKE :type2)  AND cc.${activityEntityName}.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
           return results;
       }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("browse")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));

           return null;
       }
     }
</#if>


<#if (menuAttributesp2 =="51")> 
	public ${userproflEntityName?cap_first} getUserProfile(String optionRow,String optionNo) {
                if (!identity.isLoggedIn()){
                 return null;
                } 

	     	String row = optionRow;
		String option = optionNo;
		List<${userproflEntityName?cap_first}> results =  getEntityManager()
					.createQuery(
							"select cc from ${userproflEntityName?cap_first} cc where   cc.a0xxuobxbxxxxxxxxxxxsid=:logonid  and cc.b1xxuxxrbvxxxxxxxxxxrow=:row and cc.b1xxuxxrbvxxxxxxxxxxoption=:option and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("logonid", customIdentity.getUserSid())
					.setParameter("row", row)
					.setParameter("option", option)
                           .setParameter("owner2", owner2Code)
					.getResultList();
                           if(!results.isEmpty()){          
                            return results.get(0);
                           }
                           else{
                            return null;
                           } 
 

	}

</#if>
<#if (menuAttributesp2 =="56")> 
	public String getUsageSearchedList(String st) {
                // called by home page find search as action method and string return value will reload
                // the page itemdetailsBrowse or IssuedetailsBrowse
                // sresults is used to hold search results
		// param st is s shop or b bug or p picture. if prod fs restrict results for pictures 
          String sresults="";
          String usage=null;
          String usageV=null;
          String searchPatternU=${itemEntityName}List.getSearchPatternU().toLowerCase().trim();
          String[] myData = searchPatternU.split(", ");
          //SelectItem item=null;
          SelectItem itemGr=null;
          SelectItem itemF=null;
          try{
           if (st.equals("u")){
            //seach selectItem list for a match
            
            Iterator<SelectItem> itr = ${userEntityName}Home.getAvailableItems().iterator();//return groups
            while (itr.hasNext()) {
              itemGr=itr.next();
              for (String s: myData) {
               usage=itemGr.getLabel().toLowerCase();     
               if(usage.contains(s)){
                sresults=sresults+usage+ "-";//group label, no value yet. allways search group members
               }
               itemF=((SelectItemGroup)itemGr).getSelectItems()[0];//save first which is generic
               for (SelectItem item: ((SelectItemGroup)itemGr).getSelectItems()){
                usage=item.getLabel().toLowerCase();     
                if(usage.contains(s)){
                 sresults=sresults+usage+" ";
                 usageV=item.getValue().toString();
                }
               }
               if(usageV == null){
                 usageV=itemF.getValue().toString();
               } 
              }
            } 
            if (sresults.isEmpty()){
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("result")+" "+bundle.getString("empty")+", "+bundle.getString("retry")+" "+bundle.getString("with")+" "+bundle.getString("multiple")+" "+bundle.getString("keywords"),""));
                 return "";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO, bundle.getString("suggest")+" "+bundle.getString("select")+" "+sresults,""));
                 if(usageV !=null){
                  yxxxuh566xwwqqwxxxxxuserHome.setClientApplicationFunction(usageV);
                 }else{
                 }
                 return "";
            }
           }
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO, bundle.getString("search")+" "+bundle.getString("call")+" "+bundle.getString("invalid")+" "+st,""));

           return "";

         }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("search")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
          return "";
         }
       }




	public ${userproflEntityName?cap_first} getUserProfiles() {
                if (!identity.isLoggedIn()){
                 return null;
                } 

                 // added loggedIn check, during debug userSid was showing as 0 because of proxy, the following forces to refresh 
                Integer userSidjay=customIdentity.getUserSid();
		List<${userproflEntityName?cap_first}> results =  getEntityManager()
					.createQuery(
							"select cc from ${userproflEntityName?cap_first} cc where   cc.a0xxuobxbxxxxxxxxxxxsid=:logonid  and cc.b1xxuxxrbvxxxxxxxxxxrow=:row and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("logonid", userSidjay)
					.setParameter("row", "00")
                                        .setParameter("owner2", owner2Code)
					.getResultList();
                           if(!results.isEmpty()){          
                            return results.get(0);
                           }
                           else{
                            return null;
                           } 
 

	}

     public Integer userAuthNotMailedCount(){
      List<${userEntityName?cap_first}> results =  getEntityManager()
       .createQuery("select cc from ${userEntityName?cap_first} cc where cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :partial AND cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  cc.${statusFlagDateField}").setParameter("owner2", owner2Code).
           setParameter("partial", mpartial).getResultList();
            return results.size();
     }

</#if>

   public void eSend(String sendAs,String start,String end,Boolean markedOnes,String eMailTo) {
    /**
    * The following method calls xxxMailingList method Print which is another method of this bean and uses
    * filters like start/end , flag etc and then this method renders exxxMailingContent.xhtml.  
    * the print output goes to xxxmailingBytes and is shown as attachment by rendering xxxmaiingContent
    * @param args sendAs SEMAIL if from cart, PEmail if from POS ,UEmail if userEdit, EMAIL otherwise
    * @param args start order number needed by called print method which produces report
    * @param args end order number needed by called print method
    * @param args markedOnes needed by called print method
    * @param args eMailTo eMail address of recipient
    * @return -none
    * @exception EMail_send_fail
    * @see 
    * called by shoppingCart,transactions if from ShoppingCart sendAs is SEMAIL otherwise EMAIL
    * sendAs is now EMAIL or SMAIL (assumes PDF) but in future it can be EMAILPDF or EMAILEXCL or or EMAILHTML or EMAIL etc
    *  now using EMAILHTML etc which gets passed to emailRender via displayAs , HTML allows avoiding attaching report to email
    * parameters for print except last one used by rendered eMailingContent
    * calls print() to generare report which produces mailingbytes for pdf if sendAs is eMail.
    * xxxMailingContent uses mailingbytes
    * Checks how many eMails to send and gives message if none
    * otherwise renders Enity specific MailingContent.xhtml to take care of actual EMail processing
    * messages are sent to target list and from imailaddr value in client record for copy and audit 
    */

    boolean fromCart=false;
    try {
         if (eMailTo==null || eMailTo.isEmpty()){  
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("to")+" "+ bundle.getString("empty"),""));


           return;
         }
         else{
          //jay eMail validation 
          eMailTo=eMailTo.trim();
          Pattern pattern = Pattern.compile("^.+@.+\\..+$");
          Matcher matcher = pattern.matcher(eMailTo);
          if(!matcher.matches()){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("value")+" "+ bundle.getString("invalid"),""));


           return;
          }
         }

         // before calling print setup start/end to current key value, displayAs and markedOnes flag. Based on displayAs source will be eMailBytes 
         if(sendAs.equals("SEMAIL") || sendAs.equals("PEMAIL")){
          fromCart=true;
          this.sendAs=sendAs.substring(1);
         }
         if(sendAs.equals("UEMAIL")){
          this.sendAs=sendAs.substring(1);
         }
         displayAs=sendAs;
         this.start=start;
         this.end=end;
         this.markedOnes=markedOnes;
         // reprtName holds the dropdown selected report, use it. 
         <#if menuAttributes?contains("T") >
          <#if (menuAttributesp2?contains("1A"))>
           if(sendAs.equals("SEMAIL")){
            ${cuordersEntityName}List.reportName="ma${entityName}Master";
           }else{
            ${cuinvoiceEntityName}List.reportName="ma${entityName}Master";
           }
          <#elseif (menuAttributesp2?contains("25"))>
           if(getKeyToEntity(start).getZ7xxzzfxhhxxxxxxxxxxstatusfl() !=32){
            //jay tbd add logic to get corresponding customer and email address and compare
           } 
          <#else>
           // can come here from report selection or from txn, if txn then extended_persist sets the reportName
           if(sendAs.equals("SEMAIL")){
            reportName="ma${entityName}Master";
            displayAs="EMAILHTML";
           }
           if(sendAs.equals("PEMAIL")){
            reportName="57cuinvoiceReceipt57Master";
            displayAs="EMAILHTML";
           }
          </#if>  
         <#else>
          //reportName="xx${entityName}";  holds selected report
         </#if>
         <#if (!menuAttributesp2?contains("56"))>
          this.print(); //generate report 
          if(customIdentity.getClientMsgLevel().contains("D")){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO, bundle.getString("Report")+" "+reportName.substring(20)+" "+bundle.getString("to")+" "+bundle.getString("send")+" "+bundle.getString("by")+" "+bundle.getString("email"),""));
          } 
         </#if>

         mailingAddress=eMailTo;
         // 
                ${clientEntityName?cap_first} client =(${clientEntityName?cap_first}) getEntityManager()
		.createQuery(
		"select cc from ${clientEntityName?cap_first} cc  where cc.${clientKeyField} = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
		.setParameter("nKeyName","01")
		.setParameter("owner2", owner2Code)
		.getSingleResult();

         setClientEMail("doNotReply@"+owner2Code+customIdentity.getTld()); 
         //can come here as loggedIn or not loggedIn but eMail entered
         if(identity.isLoggedIn()){   
          //All loggedIn has customer record but may not have employee example self signedup 
          // if usertoEmployee has Email then use it , if empty then use client which should have some value
          if (${employeeEntityName}Home.getCurrentUserToEmployee()==null || "".equals(${employeeEntityName}Home.getCurrentUserToEmployee())){
           // try customer 
           setClientEMail(client.get${clientImailaddr?cap_first}().trim());
          } 
          else{
           ${employeeEntityName}=${employeeEntityName}Home.getCurrentUserToEmployee();
           setClientEMail(${employeeEntityName}.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
           setUserFullName(${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":${employeeEntityName}.getB4xxu2fnbvxxxxxxxxxxfirstname() +" "+${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname()==null?"":${employeeEntityName}.getB3xxuslnbvixxxxxxxxxlastname());
          }
          // if demo user no email saved in employee except in user
          ${userEntityName?cap_first} theUser = ${userEntityName}List.getKeyToEntity(customIdentity.getUsername());
          if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
           setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
          }

         }else{
          if (client.get${clientImailaddr?cap_first}() == null || client.get${clientImailaddr?cap_first}().isEmpty()){
           setClientEMail("doNotReply@"+owner2Code+customIdentity.getTld()); 
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_WARN,bundle.getString("client")+" "+bundle.getString("email")+" "+bundle.getString("address")+" "+bundle.getString("is")+" "+bundle.getString("missing"),""));

          }else{
           setClientEMail(client.get${clientImailaddr?cap_first}());
          }
         } 
         // from uses clientEMail,cc uses eMailingAddress1, to uses mailingAddress
         //renderer.render("/${entityName?substring(eL)}eMailingContent.xhtml");
         emailRender("/${entityName?substring(eL)}eMailingContent.xhtml","e");
         //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           //FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+bundle.getString("send")+" "+bundle.getString("for")+" "+ eMailTo,""));

    } catch (Exception e) {
         bcontinue=false;
         log.severe("Error sending mail"+ e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+bundle.getString("sent")+" "+bundle.getString("failed"),""));

         if(fromCart){
          if(sendAs.equals("SEMAIL")){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("purchase")+" "+bundle.getString("history")+" "+bundle.getString("at")+" "+bundle.getString("bottom")+" "+bundle.getString("of")+" "+bundle.getString("page")+" "+bundle.getString("for")+" "+bundle.getString("status"),""));
          }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+bundle.getString("invoice")+" "+bundle.getString("status")+" "+bundle.getString("using")+" "+bundle.getString("contactus")+"/"+bundle.getString("customer")+" "+bundle.getString("payment"),""));
          }

         }
    }
   }

	public void send(String sendAs,String start,String end,Boolean markedOnes,String source) {
     // needs clean ups sendAs HTML,start Email, end same for now,markedOnes ignore , source is the report output as attachment to a mailing template
     // used to send print output as attachment from any edit including cuquote etc

		try {
			//renderer.render("/${itemEntityName?substring(eL)}MailingContent.xhtml");
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+ bundle.getString("done"),""));


		} catch (Exception e) {
			log.severe("Error sending mail"+ e);
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+ bundle.getString("failed")+" "+e.getMessage(),""));

		}
	}




///added
/*
   public List<${entityName}> getResultList(){
    return sresults;
   }
*/

    public EntityManager getEntityManager(){
        //return emf.createEntityManager();
        return entityManager;
    }
   public String getOrderColumn() {
       return orderColumn;
   }

   public void setOrderColumn(String orderColumn) {
       //this.orderColumn = sanitizeOrderColumn(orderColumn);
        this.orderColumn = orderColumn;
   }
   public String getOrder() {
       return order;
   }

   public void setOrder(String order) {
        this.order = order;
   }

   public String getOrderDirection() {
       return orderDirection;
   }

   public void setOrderDirection(String orderDirection) {
       //this.orderDirection = sanitizeOrderDirection(orderDirection);
         this.orderDirection = orderDirection; 
   }
   /**
    * Returns true if the previous page exists
    */
   public boolean isPreviousExists()
   {
      return getFirstResult()!=null && getFirstResult()!=0;
   }

   public boolean isSystemPreviousExists()
   {
      return getFirstResult()!=null && getFirstResult()!=0;
   }


   /**
    * Returns true if the query is paginated, revealing
    * whether navigation controls are needed.
    */
   /**
    * Returns true if the query is paginated, revealing
    * whether navigation controls are needed.
    */
   public boolean isPaginated() {
      return isNextExists() || isPreviousExists();
   }
   /**
    * Returns the index of the first result of the current page
    */
   public Integer getFirstResult()
   {
      return firstResult;
   }

   /**
    * Set the index at which the page to display should start
    */
   public void setFirstResult(Integer firstResult)
   {
      this.firstResult = firstResult;
      refresh();
   }
   /**
    * The page size
    */
   public Integer getMaxResults()
   {
       return maxResults;
   }

   public void setMaxResults(Integer maxResults)
   {
      this.maxResults = maxResults;
      refresh();
   }
  protected String getRenderedEjbql()
   {
   return "";
   }
  public void refresh()
   {
      clearDataModel();
   }
   protected void clearDataModel()
   {
      dataModel = null;
   }

   /**
    * Get the index of the first result of the next page
    * 
    */
   public int getNextFirstResult()
   {
      Integer fr = getFirstResult();
      return ( fr==null ? 0 : fr ) + getMaxResults();
   }

   public Integer getPageCount()
   {
      if ( getMaxResults()==null )
      {
         return null;
      }
      else
      {
         int rc = getResultCount().intValue();
         int mr = getMaxResults().intValue();
         int pages = rc / mr;
         return rc % mr == 0 ? pages : pages+1;
      }
   }

   public Integer getSystemPageCount()
   {
      if ( getMaxResults()==null )
      {
         return null;
      }
      else
      {
         int rc = getSystemResultCount().intValue();
         int mr = getMaxResults().intValue();
         int pages = rc / mr;
         return rc % mr == 0 ? pages : pages+1;
      }
   }

   /**
    * Get the index of the first result of the previous page
    * 
    */
   public int getPreviousFirstResult()
   {
      Integer fr = getFirstResult();
      Integer mr = getMaxResults();
      return mr >= ( fr==null ? 0 : fr ) ? 
               0 : fr - mr;
   }

   public Long getLastFirstResult()
   {
      Integer pc = getPageCount();
      return pc==null ? null : ( pc.longValue()-1 ) * getMaxResults();
   }
   public Long getSystemLastFirstResult()
   {
      Integer pc = getSystemPageCount();
      return pc==null ? null : ( pc.longValue()-1 ) * getMaxResults();
   }


    
}//end
</#if>