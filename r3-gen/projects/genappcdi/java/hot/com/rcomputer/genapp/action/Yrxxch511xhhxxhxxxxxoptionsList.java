



package com.rcomputer.genapp.action;

import com.rcomputer.genapp.model.*;
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








/**
* This is Action List class 
* @author 3r Computer Systems  
* @version 2.0
*/

@Named("yrxxch511xhhxxhxxxxxoptionsList")
@ViewScoped
public class Yrxxch511xhhxxhxxxxxoptionsList implements Serializable
{
   private Logger log = Logger.getLogger(Yrxxch511xhhxxhxxxxxoptions.class.getCanonicalName());
	@Inject
	Identity identity;
   @Inject R3RestClient r3RestClient;

   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
        //except for employee itself
	private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
    @Inject 
    Jxxxbh400xwwqqhxxxxxemployeeHome jxxxbh400xwwqqhxxxxxemployeeHome;
    @Inject 
    Yxxxuq1n1xwwqqqxxxxxblobdataHome yxxxuq1n1xwwqqqxxxxxblobdataHome;

    @Inject 
    Yxxxuh566xwwqqwxxxxxuserList yxxxuh566xwwqqwxxxxxuserList;

    //@Inject Authenticator authenticator;
    // authenticator extends baseauthenticator needs qualifier to resolve optionslist injecting authenticator to get country
    // jsf does not have this problem 
    // bypass plus a good idea is to store country and language etc in userprofil record 00 and optionslist should get from there
    // p1 for country p2 for language p3 for variant
	@Inject 
	Yxxxch575xwwqqhxxxxxuserproflHome yxxxch575xwwqqhxxxxxuserproflHome;
	private Yxxxch575xwwqqhxxxxxuserprofl yxxxch575xwwqqhxxxxxuserprofl;
	private Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser;
	@Inject 
	Yxxxuq1m1xwwqqqxxxxxclobdataHome yxxxuq1m1xwwqqqxxxxxclobdataHome;






	 @Inject 
	 Yxxxch5a1xhhxxhxxxxxtruefalseHome yxxxch5a1xhhxxhxxxxxtruefalseHome;
	 private Yxxxch5a1xhhxxhxxxxxtruefalse yxxxch5a1xhhxxhxxxxxtruefalse;

    @Inject CustomIdentity customIdentity; 
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
                int listSize=gethhxxhxxxxxoptionsKeyList().size();
                start=  listSize==0 ? "0" : String.valueOf(gethhxxhxxxxxoptionsKeyList().get(0)) ;
                end=    listSize==0 ? "0" : String.valueOf(gethhxxhxxxxxoptionsKeyList().get(listSize-1));

          // initialize mailrelay0ff
          mailingSource="<p style=\"font-family:arial;color:black;font-size:20px;\">";
           mailingSource=mailingSource+"Thank you for using our service. We have attached your receipt as a confirmation.</p>";
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


     Map parameters = new HashMap();
     int xvc=1;
     String reportNamePrefix="";
     String reportNameMinusPrefix="";
     List<Yrxxch511xhhxxhxxxxxoptions> sresults=null;

     List<Jxxxbh400xwwqqhxxxxxemployee> ccresults=new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
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

     private static final String EJBQL = "select yrxxch511xhhxxhxxxxxoptions from Yrxxch511xhhxxhxxxxxoptions yrxxch511xhhxxhxxxxxoptions "  ;

     private static final String[] RESTRICTIONS = {
        "lower(yrxxch511xhhxxhxxxxxoptions.a0xxukcxbvxxxxxxxxxxrow) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.a0xxukcxbvxxxxxxxxxxrow},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b1xxuo01bvxxxxxxxxxxoptions01) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b1xxuo01bvxxxxxxxxxxoptions01},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b2xxup01bvxxxxxxxxxxpurpose01) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b2xxup01bvxxxxxxxxxxpurpose01},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b3xxuv01bvxxxxxxxxxxvalue01) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b3xxuv01bvxxxxxxxxxxvalue01},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b4xxuo02bvxxxxxxxxxxoptions02) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b4xxuo02bvxxxxxxxxxxoptions02},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b5xxup02bvxxxxxxxxxxpurpose02) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b5xxup02bvxxxxxxxxxxpurpose02},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b6xxuv02bvxxxxxxxxxxvalue02) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b6xxuv02bvxxxxxxxxxxvalue02},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b7xxuo03bvxxxxxxxxxxoptions03) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b7xxuo03bvxxxxxxxxxxoptions03},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b8xxup03bvxxxxxxxxxxpurpose03) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b8xxup03bvxxxxxxxxxxpurpose03},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.b9xxuv03bvxxxxxxxxxxvalue03) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.b9xxuv03bvxxxxxxxxxxvalue03},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c1xxuo04bvxxxxxxxxxxoptions04) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c1xxuo04bvxxxxxxxxxxoptions04},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c2xxup04bvxxxxxxxxxxpurpose04) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c2xxup04bvxxxxxxxxxxpurpose04},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c3xxuv04bvxxxxxxxxxxvalue04) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c3xxuv04bvxxxxxxxxxxvalue04},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c4xxuo05bvxxxxxxxxxxoptions05) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c4xxuo05bvxxxxxxxxxxoptions05},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c5xxup05bvxxxxxxxxxxpurpose05) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c5xxup05bvxxxxxxxxxxpurpose05},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c6xxuv05bvxxxxxxxxxxvalue05) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c6xxuv05bvxxxxxxxxxxvalue05},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c7xxuo06bvxxxxxxxxxxoptions06) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c7xxuo06bvxxxxxxxxxxoptions06},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c8xxup06bvxxxxxxxxxxpurpose06) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c8xxup06bvxxxxxxxxxxpurpose06},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.c9xxuv06bvxxxxxxxxxxvalue06) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.c9xxuv06bvxxxxxxxxxxvalue06},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d1xxuo07bvxxxxxxxxxxoptions07) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d1xxuo07bvxxxxxxxxxxoptions07},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d2xxup07bvxxxxxxxxxxpurpose07) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d2xxup07bvxxxxxxxxxxpurpose07},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d3xxuv07bvxxxxxxxxxxvalue07) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d3xxuv07bvxxxxxxxxxxvalue07},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d4xxuo08bvxxxxxxxxxxoptions08) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d4xxuo08bvxxxxxxxxxxoptions08},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d5xxup08bvxxxxxxxxxxpurpose08) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d5xxup08bvxxxxxxxxxxpurpose08},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d6xxuv08bvxxxxxxxxxxvalue08) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d6xxuv08bvxxxxxxxxxxvalue08},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d7xxuo09bvxxxxxxxxxxoptions09) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d7xxuo09bvxxxxxxxxxxoptions09},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d8xxup09bvxxxxxxxxxxpurpose09) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d8xxup09bvxxxxxxxxxxpurpose09},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.d9xxuv09bvxxxxxxxxxxvalue09) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.d9xxuv09bvxxxxxxxxxxvalue09},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e1xxuo10bvxxxxxxxxxxoptions10) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e1xxuo10bvxxxxxxxxxxoptions10},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e2xxup10bvxxxxxxxxxxpurpose10) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e2xxup10bvxxxxxxxxxxpurpose10},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e3xxuv10bvxxxxxxxxxxvalue10) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e3xxuv10bvxxxxxxxxxxvalue10},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e4xxuo11bvxxxxxxxxxxoptions11) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e4xxuo11bvxxxxxxxxxxoptions11},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e5xxup11bvxxxxxxxxxxpurpose11) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e5xxup11bvxxxxxxxxxxpurpose11},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e6xxuv11bvxxxxxxxxxxvalue11) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e6xxuv11bvxxxxxxxxxxvalue11},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e7xxuo12bvxxxxxxxxxxoptions12) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e7xxuo12bvxxxxxxxxxxoptions12},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e8xxup12bvxxxxxxxxxxpurpose12) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e8xxup12bvxxxxxxxxxxpurpose12},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.e9xxuv12bvxxxxxxxxxxvalue12) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.e9xxuv12bvxxxxxxxxxxvalue12},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f1xxuo13bvxxxxxxxxxxoptions13) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f1xxuo13bvxxxxxxxxxxoptions13},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f2xxup13bvxxxxxxxxxxpurpose13) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f2xxup13bvxxxxxxxxxxpurpose13},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f3xxuv13bvxxxxxxxxxxvalue13) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f3xxuv13bvxxxxxxxxxxvalue13},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f4xxuo14bvxxxxxxxxxxoptions14) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f4xxuo14bvxxxxxxxxxxoptions14},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f5xxup14bvxxxxxxxxxxpurpose14) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f5xxup14bvxxxxxxxxxxpurpose14},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f6xxuv14bvxxxxxxxxxxvalue14) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f6xxuv14bvxxxxxxxxxxvalue14},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f7xxuo15bvxxxxxxxxxxoptions15) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f7xxuo15bvxxxxxxxxxxoptions15},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f8xxup15bvxxxxxxxxxxpurpose15) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f8xxup15bvxxxxxxxxxxpurpose15},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.f9xxuv15bvxxxxxxxxxxvalue15) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.f9xxuv15bvxxxxxxxxxxvalue15},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g1xxuo16bvxxxxxxxxxxoptions16) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g1xxuo16bvxxxxxxxxxxoptions16},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g2xxup16bvxxxxxxxxxxpurpose16) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g2xxup16bvxxxxxxxxxxpurpose16},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g3xxuv16bvxxxxxxxxxxvalue16) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g3xxuv16bvxxxxxxxxxxvalue16},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g4xxuo17bvxxxxxxxxxxoptions17) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g4xxuo17bvxxxxxxxxxxoptions17},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g5xxup17bvxxxxxxxxxxpurpose17) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g5xxup17bvxxxxxxxxxxpurpose17},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g6xxuv17bvxxxxxxxxxxvalue17) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g6xxuv17bvxxxxxxxxxxvalue17},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g7xxuo18bvxxxxxxxxxxoptions18) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g7xxuo18bvxxxxxxxxxxoptions18},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g8xxup18bvxxxxxxxxxxpurpose18) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g8xxup18bvxxxxxxxxxxpurpose18},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.g9xxuv18bvxxxxxxxxxxvalue18) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.g9xxuv18bvxxxxxxxxxxvalue18},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h1xxuo19bvxxxxxxxxxxoptions19) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h1xxuo19bvxxxxxxxxxxoptions19},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h2xxup19bvxxxxxxxxxxpurpose19) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h2xxup19bvxxxxxxxxxxpurpose19},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h3xxuv19bvxxxxxxxxxxvalue19) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h3xxuv19bvxxxxxxxxxxvalue19},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h4xxuo20bvxxxxxxxxxxoptions20) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h4xxuo20bvxxxxxxxxxxoptions20},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h5xxup20bvxxxxxxxxxxpurpose20) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h5xxup20bvxxxxxxxxxxpurpose20},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h6xxuv20bvxxxxxxxxxxvalue20) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h6xxuv20bvxxxxxxxxxxvalue20},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h7xxuo21bvxxxxxxxxxxoptions21) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h7xxuo21bvxxxxxxxxxxoptions21},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h8xxup21bvxxxxxxxxxxpurpose21) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h8xxup21bvxxxxxxxxxxpurpose21},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.h9xxuv21bvxxxxxxxxxxvalue21) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.h9xxuv21bvxxxxxxxxxxvalue21},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i1xxuo22bvxxxxxxxxxxoptions22) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i1xxuo22bvxxxxxxxxxxoptions22},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i2xxup22bvxxxxxxxxxxpurpose22) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i2xxup22bvxxxxxxxxxxpurpose22},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i3xxuv22bvxxxxxxxxxxvalue22) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i3xxuv22bvxxxxxxxxxxvalue22},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i4xxuo23bvxxxxxxxxxxoptions23) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i4xxuo23bvxxxxxxxxxxoptions23},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i5xxup23bvxxxxxxxxxxpurpose23) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i5xxup23bvxxxxxxxxxxpurpose23},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i6xxuv23bvxxxxxxxxxxvalue23) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i6xxuv23bvxxxxxxxxxxvalue23},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i7xxuo24bvxxxxxxxxxxoptions24) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i7xxuo24bvxxxxxxxxxxoptions24},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i8xxup24bvxxxxxxxxxxpurpose24) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i8xxup24bvxxxxxxxxxxpurpose24},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.i9xxuv24bvxxxxxxxxxxvalue24) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.i9xxuv24bvxxxxxxxxxxvalue24},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j1xxuo25bvxxxxxxxxxxoptions25) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j1xxuo25bvxxxxxxxxxxoptions25},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j2xxup25bvxxxxxxxxxxpurpose25) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j2xxup25bvxxxxxxxxxxpurpose25},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j3xxuv25bvxxxxxxxxxxvalue25) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j3xxuv25bvxxxxxxxxxxvalue25},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j4xxuo26bvxxxxxxxxxxoptions26) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j4xxuo26bvxxxxxxxxxxoptions26},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j5xxup26bvxxxxxxxxxxpurpose26) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j5xxup26bvxxxxxxxxxxpurpose26},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j6xxuv26bvxxxxxxxxxxvalue26) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j6xxuv26bvxxxxxxxxxxvalue26},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j7xxuo27bvxxxxxxxxxxoptions27) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j7xxuo27bvxxxxxxxxxxoptions27},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j8xxup27bvxxxxxxxxxxpurpose27) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j8xxup27bvxxxxxxxxxxpurpose27},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.j9xxuv27bvxxxxxxxxxxvalue27) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.j9xxuv27bvxxxxxxxxxxvalue27},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k1xxuo28bvxxxxxxxxxxoptions28) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k1xxuo28bvxxxxxxxxxxoptions28},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k2xxup28bvxxxxxxxxxxpurpose28) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k2xxup28bvxxxxxxxxxxpurpose28},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k3xxuv28bvxxxxxxxxxxvalue28) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k3xxuv28bvxxxxxxxxxxvalue28},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k4xxuo29bvxxxxxxxxxxoptions29) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k4xxuo29bvxxxxxxxxxxoptions29},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k5xxup29bvxxxxxxxxxxpurpose29) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k5xxup29bvxxxxxxxxxxpurpose29},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k6xxuv29bvxxxxxxxxxxvalue29) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k6xxuv29bvxxxxxxxxxxvalue29},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k7xxuo30bvxxxxxxxxxxoptions30) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k7xxuo30bvxxxxxxxxxxoptions30},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k8xxup30bvxxxxxxxxxxpurpose30) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k8xxup30bvxxxxxxxxxxpurpose30},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.k9xxuv30bvxxxxxxxxxxvalue30) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.k9xxuv30bvxxxxxxxxxxvalue30},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l1xxuo31bvxxxxxxxxxxoptions31) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l1xxuo31bvxxxxxxxxxxoptions31},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l2xxup31bvxxxxxxxxxxpurpose31) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l2xxup31bvxxxxxxxxxxpurpose31},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l3xxuv31bvxxxxxxxxxxvalue31) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l3xxuv31bvxxxxxxxxxxvalue31},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l4xxuo32bvxxxxxxxxxxoptions32) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l4xxuo32bvxxxxxxxxxxoptions32},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l5xxup32bvxxxxxxxxxxpurpose32) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l5xxup32bvxxxxxxxxxxpurpose32},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l6xxuv32bvxxxxxxxxxxvalue32) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l6xxuv32bvxxxxxxxxxxvalue32},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l7xxuo33bvxxxxxxxxxxoptions33) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l7xxuo33bvxxxxxxxxxxoptions33},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l8xxup33bvxxxxxxxxxxpurpose33) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l8xxup33bvxxxxxxxxxxpurpose33},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.l9xxuv33bvxxxxxxxxxxvalue33) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.l9xxuv33bvxxxxxxxxxxvalue33},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m1xxuo34bvxxxxxxxxxxoptions34) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m1xxuo34bvxxxxxxxxxxoptions34},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m2xxup34bvxxxxxxxxxxpurpose34) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m2xxup34bvxxxxxxxxxxpurpose34},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m3xxuv34bvxxxxxxxxxxvalue34) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m3xxuv34bvxxxxxxxxxxvalue34},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m4xxuo35bvxxxxxxxxxxoptions35) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m4xxuo35bvxxxxxxxxxxoptions35},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m5xxup35bvxxxxxxxxxxpurpose35) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m5xxup35bvxxxxxxxxxxpurpose35},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m6xxuv35bvxxxxxxxxxxvalue35) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m6xxuv35bvxxxxxxxxxxvalue35},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m7xxuo36bvxxxxxxxxxxoptions36) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m7xxuo36bvxxxxxxxxxxoptions36},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m8xxup36bvxxxxxxxxxxpurpose36) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m8xxup36bvxxxxxxxxxxpurpose36},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.m9xxuv36bvxxxxxxxxxxvalue36) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.m9xxuv36bvxxxxxxxxxxvalue36},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n1xxuo37bvxxxxxxxxxxoptions37) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n1xxuo37bvxxxxxxxxxxoptions37},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n2xxup37bvxxxxxxxxxxpurpose37) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n2xxup37bvxxxxxxxxxxpurpose37},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n3xxuv37bvxxxxxxxxxxvalue37) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n3xxuv37bvxxxxxxxxxxvalue37},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n4xxuo38bvxxxxxxxxxxoptions38) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n4xxuo38bvxxxxxxxxxxoptions38},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n5xxup38bvxxxxxxxxxxpurpose38) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n5xxup38bvxxxxxxxxxxpurpose38},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n6xxuv38bvxxxxxxxxxxvalue38) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n6xxuv38bvxxxxxxxxxxvalue38},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n7xxuo39bvxxxxxxxxxxoptions39) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n7xxuo39bvxxxxxxxxxxoptions39},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n8xxup39bvxxxxxxxxxxpurpose39) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n8xxup39bvxxxxxxxxxxpurpose39},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.n9xxuv39bvxxxxxxxxxxvalue39) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.n9xxuv39bvxxxxxxxxxxvalue39},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o1xxuo40bvxxxxxxxxxxoptions40) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o1xxuo40bvxxxxxxxxxxoptions40},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o2xxup40bvxxxxxxxxxxpurpose40) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o2xxup40bvxxxxxxxxxxpurpose40},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o3xxuv40bvxxxxxxxxxxvalue40) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o3xxuv40bvxxxxxxxxxxvalue40},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o4xxuo41bvxxxxxxxxxxoptions41) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o4xxuo41bvxxxxxxxxxxoptions41},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o5xxup41bvxxxxxxxxxxpurpose41) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o5xxup41bvxxxxxxxxxxpurpose41},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o6xxuv41bvxxxxxxxxxxvalue41) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o6xxuv41bvxxxxxxxxxxvalue41},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o7xxuo42bvxxxxxxxxxxoptions42) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o7xxuo42bvxxxxxxxxxxoptions42},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o8xxup42bvxxxxxxxxxxpurpose42) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o8xxup42bvxxxxxxxxxxpurpose42},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.o9xxuv42bvxxxxxxxxxxvalue42) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.o9xxuv42bvxxxxxxxxxxvalue42},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p1xxuo43bvxxxxxxxxxxoptions43) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p1xxuo43bvxxxxxxxxxxoptions43},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p2xxup43bvxxxxxxxxxxpurpose43) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p2xxup43bvxxxxxxxxxxpurpose43},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p3xxuv43bvxxxxxxxxxxvalue43) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p3xxuv43bvxxxxxxxxxxvalue43},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p4xxuo44bvxxxxxxxxxxoptions44) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p4xxuo44bvxxxxxxxxxxoptions44},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p5xxup44bvxxxxxxxxxxpurpose44) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p5xxup44bvxxxxxxxxxxpurpose44},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p6xxuv44bvxxxxxxxxxxvalue44) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p6xxuv44bvxxxxxxxxxxvalue44},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p7xxuo45bvxxxxxxxxxxoptions45) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p7xxuo45bvxxxxxxxxxxoptions45},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p8xxup45bvxxxxxxxxxxpurpose45) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p8xxup45bvxxxxxxxxxxpurpose45},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.p9xxuv45bvxxxxxxxxxxvalue45) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.p9xxuv45bvxxxxxxxxxxvalue45},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q1xxuo46bvxxxxxxxxxxoptions46) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q1xxuo46bvxxxxxxxxxxoptions46},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q2xxup46bvxxxxxxxxxxpurpose46) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q2xxup46bvxxxxxxxxxxpurpose46},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q3xxuv46bvxxxxxxxxxxvalue46) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q3xxuv46bvxxxxxxxxxxvalue46},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q4xxuo47bvxxxxxxxxxxoptions47) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q4xxuo47bvxxxxxxxxxxoptions47},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q5xxup47bvxxxxxxxxxxpurpose47) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q5xxup47bvxxxxxxxxxxpurpose47},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q6xxuv47bvxxxxxxxxxxvalue47) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q6xxuv47bvxxxxxxxxxxvalue47},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q7xxuo48bvxxxxxxxxxxoptions48) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q7xxuo48bvxxxxxxxxxxoptions48},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q8xxup48bvxxxxxxxxxxpurpose48) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q8xxup48bvxxxxxxxxxxpurpose48},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.q9xxuv48bvxxxxxxxxxxvalue48) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.q9xxuv48bvxxxxxxxxxxvalue48},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r1xxuo49bvxxxxxxxxxxoptions49) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r1xxuo49bvxxxxxxxxxxoptions49},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r2xxup49bvxxxxxxxxxxpurpose49) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r2xxup49bvxxxxxxxxxxpurpose49},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r3xxuv49bvxxxxxxxxxxvalue49) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r3xxuv49bvxxxxxxxxxxvalue49},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r4xxuo50bvxxxxxxxxxxoptions50) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r4xxuo50bvxxxxxxxxxxoptions50},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r5xxup50bvxxxxxxxxxxpurpose50) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r5xxup50bvxxxxxxxxxxpurpose50},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r6xxuv50bvxxxxxxxxxxvalue50) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r6xxuv50bvxxxxxxxxxxvalue50},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r7xxuo51bvxxxxxxxxxxoptions51) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r7xxuo51bvxxxxxxxxxxoptions51},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r8xxup51bvxxxxxxxxxxpurpose51) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r8xxup51bvxxxxxxxxxxpurpose51},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.r9xxuv51bvxxxxxxxxxxvalue51) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.r9xxuv51bvxxxxxxxxxxvalue51},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s1xxuo52bvxxxxxxxxxxoptions52) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s1xxuo52bvxxxxxxxxxxoptions52},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s2xxup52bvxxxxxxxxxxpurpose52) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s2xxup52bvxxxxxxxxxxpurpose52},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s3xxuv52bvxxxxxxxxxxvalue52) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s3xxuv52bvxxxxxxxxxxvalue52},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s4xxuo53bvxxxxxxxxxxoptions53) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s4xxuo53bvxxxxxxxxxxoptions53},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s5xxup53bvxxxxxxxxxxpurpose53) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s5xxup53bvxxxxxxxxxxpurpose53},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s6xxuv53bvxxxxxxxxxxvalue53) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s6xxuv53bvxxxxxxxxxxvalue53},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s7xxuo54bvxxxxxxxxxxoptions54) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s7xxuo54bvxxxxxxxxxxoptions54},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s8xxup54bvxxxxxxxxxxpurpose54) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s8xxup54bvxxxxxxxxxxpurpose54},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.s9xxuv54bvxxxxxxxxxxvalue54) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.s9xxuv54bvxxxxxxxxxxvalue54},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t1xxuo55bvxxxxxxxxxxoptions55) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t1xxuo55bvxxxxxxxxxxoptions55},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t2xxup55bvxxxxxxxxxxpurpose55) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t2xxup55bvxxxxxxxxxxpurpose55},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t3xxuv55bvxxxxxxxxxxvalue55) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t3xxuv55bvxxxxxxxxxxvalue55},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t4xxuo56bvxxxxxxxxxxoptions56) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t4xxuo56bvxxxxxxxxxxoptions56},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t5xxup56bvxxxxxxxxxxpurpose56) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t5xxup56bvxxxxxxxxxxpurpose56},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t6xxuv56bvxxxxxxxxxxvalue56) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t6xxuv56bvxxxxxxxxxxvalue56},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t7xxuo57bvxxxxxxxxxxoptions57) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t7xxuo57bvxxxxxxxxxxoptions57},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t8xxup57bvxxxxxxxxxxpurpose57) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t8xxup57bvxxxxxxxxxxpurpose57},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.t9xxuv57bvxxxxxxxxxxvalue57) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.t9xxuv57bvxxxxxxxxxxvalue57},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u1xxuo58bvxxxxxxxxxxoptions58) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u1xxuo58bvxxxxxxxxxxoptions58},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u2xxup58bvxxxxxxxxxxpurpose58) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u2xxup58bvxxxxxxxxxxpurpose58},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u3xxuv58bvxxxxxxxxxxvalue58) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u3xxuv58bvxxxxxxxxxxvalue58},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u4xxuo59bvxxxxxxxxxxoptions59) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u4xxuo59bvxxxxxxxxxxoptions59},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u5xxup59bvxxxxxxxxxxpurpose59) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u5xxup59bvxxxxxxxxxxpurpose59},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u6xxuv59bvxxxxxxxxxxvalue59) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u6xxuv59bvxxxxxxxxxxvalue59},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u7xxuo60bvxxxxxxxxxxoptions60) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u7xxuo60bvxxxxxxxxxxoptions60},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u8xxup60bvxxxxxxxxxxpurpose60) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u8xxup60bvxxxxxxxxxxpurpose60},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.u9xxuv60bvxxxxxxxxxxvalue60) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.u9xxuv60bvxxxxxxxxxxvalue60},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.v1xxuo61bvxxxxxxxxxxoptions61) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.v1xxuo61bvxxxxxxxxxxoptions61},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.v2xxup61bvxxxxxxxxxxpurpose61) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.v2xxup61bvxxxxxxxxxxpurpose61},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.v3xxuv61bvxxxxxxxxxxvalue61) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.v3xxuv61bvxxxxxxxxxxvalue61},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.y9xxuznxbvxxxxxxxxxxnotes) like lower( concat(#{yrxxch511xhhxxhxxxxxoptionsList.yrxxch511xhhxxhxxxxxoptions.y9xxuznxbvxxxxxxxxxxnotes},'%'))",
        "lower(yrxxch511xhhxxhxxxxxoptions.z3xxutoxlhxxxxxxxxxxowner) like lower( concat('%',#{yrxxch511xhhxxhxxxxxoptionsList.ownerCddCode}))",
        "lower(yrxxch511xhhxxhxxxxxoptions.zzxxu2oxxhxxxxxxxxxxowner2) = lower(#{yrxxch511xhhxxhxxxxxoptionsList.dataOwner2Code})",
    };



    private Yrxxch511xhhxxhxxxxxoptions yrxxch511xhhxxhxxxxxoptions = new Yrxxch511xhhxxhxxxxxoptions();
 /*
  In case of non composite ie Single Field Key
 */
      /*
      ids = pojo.identifierProperty.name >>> a0xxuobxbxxxxxxxxxxxsid
      */




// add more logic here to pick up foreign fields if transaction or mailing, pks,pfs=05 efs=06,added multiple K test
   //not foreign or collection properties  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection also not component  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection properties  property name a0xxukcxbvxxxxxxxxxxrow
   //not foreign or collection also not component  property name a0xxukcxbvxxxxxxxxxxrow
      //not component keyfield property name a0xxukcxbvxxxxxxxxxxrow
   //not foreign or collection properties  property name b1xxuo01bvxxxxxxxxxxoptions01
   //not foreign or collection also not component  property name b1xxuo01bvxxxxxxxxxxoptions01
   //not foreign or collection properties  property name b2xxup01bvxxxxxxxxxxpurpose01
   //not foreign or collection also not component  property name b2xxup01bvxxxxxxxxxxpurpose01
   //not foreign or collection properties  property name b3xxuv01bvxxxxxxxxxxvalue01
   //not foreign or collection also not component  property name b3xxuv01bvxxxxxxxxxxvalue01
   //not foreign or collection properties  property name b4xxuo02bvxxxxxxxxxxoptions02
   //not foreign or collection also not component  property name b4xxuo02bvxxxxxxxxxxoptions02
   //not foreign or collection properties  property name b5xxup02bvxxxxxxxxxxpurpose02
   //not foreign or collection also not component  property name b5xxup02bvxxxxxxxxxxpurpose02
   //not foreign or collection properties  property name b6xxuv02bvxxxxxxxxxxvalue02
   //not foreign or collection also not component  property name b6xxuv02bvxxxxxxxxxxvalue02
   //not foreign or collection properties  property name b7xxuo03bvxxxxxxxxxxoptions03
   //not foreign or collection also not component  property name b7xxuo03bvxxxxxxxxxxoptions03
   //not foreign or collection properties  property name b8xxup03bvxxxxxxxxxxpurpose03
   //not foreign or collection also not component  property name b8xxup03bvxxxxxxxxxxpurpose03
   //not foreign or collection properties  property name b9xxuv03bvxxxxxxxxxxvalue03
   //not foreign or collection also not component  property name b9xxuv03bvxxxxxxxxxxvalue03
   //not foreign or collection properties  property name c1xxuo04bvxxxxxxxxxxoptions04
   //not foreign or collection also not component  property name c1xxuo04bvxxxxxxxxxxoptions04
   //not foreign or collection properties  property name c2xxup04bvxxxxxxxxxxpurpose04
   //not foreign or collection also not component  property name c2xxup04bvxxxxxxxxxxpurpose04
   //not foreign or collection properties  property name c3xxuv04bvxxxxxxxxxxvalue04
   //not foreign or collection also not component  property name c3xxuv04bvxxxxxxxxxxvalue04
   //not foreign or collection properties  property name c4xxuo05bvxxxxxxxxxxoptions05
   //not foreign or collection also not component  property name c4xxuo05bvxxxxxxxxxxoptions05
   //not foreign or collection properties  property name c5xxup05bvxxxxxxxxxxpurpose05
   //not foreign or collection also not component  property name c5xxup05bvxxxxxxxxxxpurpose05
   //not foreign or collection properties  property name c6xxuv05bvxxxxxxxxxxvalue05
   //not foreign or collection also not component  property name c6xxuv05bvxxxxxxxxxxvalue05
   //not foreign or collection properties  property name c7xxuo06bvxxxxxxxxxxoptions06
   //not foreign or collection also not component  property name c7xxuo06bvxxxxxxxxxxoptions06
   //not foreign or collection properties  property name c8xxup06bvxxxxxxxxxxpurpose06
   //not foreign or collection also not component  property name c8xxup06bvxxxxxxxxxxpurpose06
   //not foreign or collection properties  property name c9xxuv06bvxxxxxxxxxxvalue06
   //not foreign or collection also not component  property name c9xxuv06bvxxxxxxxxxxvalue06
   //not foreign or collection properties  property name d1xxuo07bvxxxxxxxxxxoptions07
   //not foreign or collection also not component  property name d1xxuo07bvxxxxxxxxxxoptions07
   //not foreign or collection properties  property name d2xxup07bvxxxxxxxxxxpurpose07
   //not foreign or collection also not component  property name d2xxup07bvxxxxxxxxxxpurpose07
   //not foreign or collection properties  property name d3xxuv07bvxxxxxxxxxxvalue07
   //not foreign or collection also not component  property name d3xxuv07bvxxxxxxxxxxvalue07
   //not foreign or collection properties  property name d4xxuo08bvxxxxxxxxxxoptions08
   //not foreign or collection also not component  property name d4xxuo08bvxxxxxxxxxxoptions08
   //not foreign or collection properties  property name d5xxup08bvxxxxxxxxxxpurpose08
   //not foreign or collection also not component  property name d5xxup08bvxxxxxxxxxxpurpose08
   //not foreign or collection properties  property name d6xxuv08bvxxxxxxxxxxvalue08
   //not foreign or collection also not component  property name d6xxuv08bvxxxxxxxxxxvalue08
   //not foreign or collection properties  property name d7xxuo09bvxxxxxxxxxxoptions09
   //not foreign or collection also not component  property name d7xxuo09bvxxxxxxxxxxoptions09
   //not foreign or collection properties  property name d8xxup09bvxxxxxxxxxxpurpose09
   //not foreign or collection also not component  property name d8xxup09bvxxxxxxxxxxpurpose09
   //not foreign or collection properties  property name d9xxuv09bvxxxxxxxxxxvalue09
   //not foreign or collection also not component  property name d9xxuv09bvxxxxxxxxxxvalue09
   //not foreign or collection properties  property name e1xxuo10bvxxxxxxxxxxoptions10
   //not foreign or collection also not component  property name e1xxuo10bvxxxxxxxxxxoptions10
   //not foreign or collection properties  property name e2xxup10bvxxxxxxxxxxpurpose10
   //not foreign or collection also not component  property name e2xxup10bvxxxxxxxxxxpurpose10
   //not foreign or collection properties  property name e3xxuv10bvxxxxxxxxxxvalue10
   //not foreign or collection also not component  property name e3xxuv10bvxxxxxxxxxxvalue10
   //not foreign or collection properties  property name e4xxuo11bvxxxxxxxxxxoptions11
   //not foreign or collection also not component  property name e4xxuo11bvxxxxxxxxxxoptions11
   //not foreign or collection properties  property name e5xxup11bvxxxxxxxxxxpurpose11
   //not foreign or collection also not component  property name e5xxup11bvxxxxxxxxxxpurpose11
   //not foreign or collection properties  property name e6xxuv11bvxxxxxxxxxxvalue11
   //not foreign or collection also not component  property name e6xxuv11bvxxxxxxxxxxvalue11
   //not foreign or collection properties  property name e7xxuo12bvxxxxxxxxxxoptions12
   //not foreign or collection also not component  property name e7xxuo12bvxxxxxxxxxxoptions12
   //not foreign or collection properties  property name e8xxup12bvxxxxxxxxxxpurpose12
   //not foreign or collection also not component  property name e8xxup12bvxxxxxxxxxxpurpose12
   //not foreign or collection properties  property name e9xxuv12bvxxxxxxxxxxvalue12
   //not foreign or collection also not component  property name e9xxuv12bvxxxxxxxxxxvalue12
   //not foreign or collection properties  property name f1xxuo13bvxxxxxxxxxxoptions13
   //not foreign or collection also not component  property name f1xxuo13bvxxxxxxxxxxoptions13
   //not foreign or collection properties  property name f2xxup13bvxxxxxxxxxxpurpose13
   //not foreign or collection also not component  property name f2xxup13bvxxxxxxxxxxpurpose13
   //not foreign or collection properties  property name f3xxuv13bvxxxxxxxxxxvalue13
   //not foreign or collection also not component  property name f3xxuv13bvxxxxxxxxxxvalue13
   //not foreign or collection properties  property name f4xxuo14bvxxxxxxxxxxoptions14
   //not foreign or collection also not component  property name f4xxuo14bvxxxxxxxxxxoptions14
   //not foreign or collection properties  property name f5xxup14bvxxxxxxxxxxpurpose14
   //not foreign or collection also not component  property name f5xxup14bvxxxxxxxxxxpurpose14
   //not foreign or collection properties  property name f6xxuv14bvxxxxxxxxxxvalue14
   //not foreign or collection also not component  property name f6xxuv14bvxxxxxxxxxxvalue14
   //not foreign or collection properties  property name f7xxuo15bvxxxxxxxxxxoptions15
   //not foreign or collection also not component  property name f7xxuo15bvxxxxxxxxxxoptions15
   //not foreign or collection properties  property name f8xxup15bvxxxxxxxxxxpurpose15
   //not foreign or collection also not component  property name f8xxup15bvxxxxxxxxxxpurpose15
   //not foreign or collection properties  property name f9xxuv15bvxxxxxxxxxxvalue15
   //not foreign or collection also not component  property name f9xxuv15bvxxxxxxxxxxvalue15
   //not foreign or collection properties  property name g1xxuo16bvxxxxxxxxxxoptions16
   //not foreign or collection also not component  property name g1xxuo16bvxxxxxxxxxxoptions16
   //not foreign or collection properties  property name g2xxup16bvxxxxxxxxxxpurpose16
   //not foreign or collection also not component  property name g2xxup16bvxxxxxxxxxxpurpose16
   //not foreign or collection properties  property name g3xxuv16bvxxxxxxxxxxvalue16
   //not foreign or collection also not component  property name g3xxuv16bvxxxxxxxxxxvalue16
   //not foreign or collection properties  property name g4xxuo17bvxxxxxxxxxxoptions17
   //not foreign or collection also not component  property name g4xxuo17bvxxxxxxxxxxoptions17
   //not foreign or collection properties  property name g5xxup17bvxxxxxxxxxxpurpose17
   //not foreign or collection also not component  property name g5xxup17bvxxxxxxxxxxpurpose17
   //not foreign or collection properties  property name g6xxuv17bvxxxxxxxxxxvalue17
   //not foreign or collection also not component  property name g6xxuv17bvxxxxxxxxxxvalue17
   //not foreign or collection properties  property name g7xxuo18bvxxxxxxxxxxoptions18
   //not foreign or collection also not component  property name g7xxuo18bvxxxxxxxxxxoptions18
   //not foreign or collection properties  property name g8xxup18bvxxxxxxxxxxpurpose18
   //not foreign or collection also not component  property name g8xxup18bvxxxxxxxxxxpurpose18
   //not foreign or collection properties  property name g9xxuv18bvxxxxxxxxxxvalue18
   //not foreign or collection also not component  property name g9xxuv18bvxxxxxxxxxxvalue18
   //not foreign or collection properties  property name h1xxuo19bvxxxxxxxxxxoptions19
   //not foreign or collection also not component  property name h1xxuo19bvxxxxxxxxxxoptions19
   //not foreign or collection properties  property name h2xxup19bvxxxxxxxxxxpurpose19
   //not foreign or collection also not component  property name h2xxup19bvxxxxxxxxxxpurpose19
   //not foreign or collection properties  property name h3xxuv19bvxxxxxxxxxxvalue19
   //not foreign or collection also not component  property name h3xxuv19bvxxxxxxxxxxvalue19
   //not foreign or collection properties  property name h4xxuo20bvxxxxxxxxxxoptions20
   //not foreign or collection also not component  property name h4xxuo20bvxxxxxxxxxxoptions20
   //not foreign or collection properties  property name h5xxup20bvxxxxxxxxxxpurpose20
   //not foreign or collection also not component  property name h5xxup20bvxxxxxxxxxxpurpose20
   //not foreign or collection properties  property name h6xxuv20bvxxxxxxxxxxvalue20
   //not foreign or collection also not component  property name h6xxuv20bvxxxxxxxxxxvalue20
   //not foreign or collection properties  property name h7xxuo21bvxxxxxxxxxxoptions21
   //not foreign or collection also not component  property name h7xxuo21bvxxxxxxxxxxoptions21
   //not foreign or collection properties  property name h8xxup21bvxxxxxxxxxxpurpose21
   //not foreign or collection also not component  property name h8xxup21bvxxxxxxxxxxpurpose21
   //not foreign or collection properties  property name h9xxuv21bvxxxxxxxxxxvalue21
   //not foreign or collection also not component  property name h9xxuv21bvxxxxxxxxxxvalue21
   //not foreign or collection properties  property name i1xxuo22bvxxxxxxxxxxoptions22
   //not foreign or collection also not component  property name i1xxuo22bvxxxxxxxxxxoptions22
   //not foreign or collection properties  property name i2xxup22bvxxxxxxxxxxpurpose22
   //not foreign or collection also not component  property name i2xxup22bvxxxxxxxxxxpurpose22
   //not foreign or collection properties  property name i3xxuv22bvxxxxxxxxxxvalue22
   //not foreign or collection also not component  property name i3xxuv22bvxxxxxxxxxxvalue22
   //not foreign or collection properties  property name i4xxuo23bvxxxxxxxxxxoptions23
   //not foreign or collection also not component  property name i4xxuo23bvxxxxxxxxxxoptions23
   //not foreign or collection properties  property name i5xxup23bvxxxxxxxxxxpurpose23
   //not foreign or collection also not component  property name i5xxup23bvxxxxxxxxxxpurpose23
   //not foreign or collection properties  property name i6xxuv23bvxxxxxxxxxxvalue23
   //not foreign or collection also not component  property name i6xxuv23bvxxxxxxxxxxvalue23
   //not foreign or collection properties  property name i7xxuo24bvxxxxxxxxxxoptions24
   //not foreign or collection also not component  property name i7xxuo24bvxxxxxxxxxxoptions24
   //not foreign or collection properties  property name i8xxup24bvxxxxxxxxxxpurpose24
   //not foreign or collection also not component  property name i8xxup24bvxxxxxxxxxxpurpose24
   //not foreign or collection properties  property name i9xxuv24bvxxxxxxxxxxvalue24
   //not foreign or collection also not component  property name i9xxuv24bvxxxxxxxxxxvalue24
   //not foreign or collection properties  property name j1xxuo25bvxxxxxxxxxxoptions25
   //not foreign or collection also not component  property name j1xxuo25bvxxxxxxxxxxoptions25
   //not foreign or collection properties  property name j2xxup25bvxxxxxxxxxxpurpose25
   //not foreign or collection also not component  property name j2xxup25bvxxxxxxxxxxpurpose25
   //not foreign or collection properties  property name j3xxuv25bvxxxxxxxxxxvalue25
   //not foreign or collection also not component  property name j3xxuv25bvxxxxxxxxxxvalue25
   //not foreign or collection properties  property name j4xxuo26bvxxxxxxxxxxoptions26
   //not foreign or collection also not component  property name j4xxuo26bvxxxxxxxxxxoptions26
   //not foreign or collection properties  property name j5xxup26bvxxxxxxxxxxpurpose26
   //not foreign or collection also not component  property name j5xxup26bvxxxxxxxxxxpurpose26
   //not foreign or collection properties  property name j6xxuv26bvxxxxxxxxxxvalue26
   //not foreign or collection also not component  property name j6xxuv26bvxxxxxxxxxxvalue26
   //not foreign or collection properties  property name j7xxuo27bvxxxxxxxxxxoptions27
   //not foreign or collection also not component  property name j7xxuo27bvxxxxxxxxxxoptions27
   //not foreign or collection properties  property name j8xxup27bvxxxxxxxxxxpurpose27
   //not foreign or collection also not component  property name j8xxup27bvxxxxxxxxxxpurpose27
   //not foreign or collection properties  property name j9xxuv27bvxxxxxxxxxxvalue27
   //not foreign or collection also not component  property name j9xxuv27bvxxxxxxxxxxvalue27
   //not foreign or collection properties  property name k1xxuo28bvxxxxxxxxxxoptions28
   //not foreign or collection also not component  property name k1xxuo28bvxxxxxxxxxxoptions28
   //not foreign or collection properties  property name k2xxup28bvxxxxxxxxxxpurpose28
   //not foreign or collection also not component  property name k2xxup28bvxxxxxxxxxxpurpose28
   //not foreign or collection properties  property name k3xxuv28bvxxxxxxxxxxvalue28
   //not foreign or collection also not component  property name k3xxuv28bvxxxxxxxxxxvalue28
   //not foreign or collection properties  property name k4xxuo29bvxxxxxxxxxxoptions29
   //not foreign or collection also not component  property name k4xxuo29bvxxxxxxxxxxoptions29
   //not foreign or collection properties  property name k5xxup29bvxxxxxxxxxxpurpose29
   //not foreign or collection also not component  property name k5xxup29bvxxxxxxxxxxpurpose29
   //not foreign or collection properties  property name k6xxuv29bvxxxxxxxxxxvalue29
   //not foreign or collection also not component  property name k6xxuv29bvxxxxxxxxxxvalue29
   //not foreign or collection properties  property name k7xxuo30bvxxxxxxxxxxoptions30
   //not foreign or collection also not component  property name k7xxuo30bvxxxxxxxxxxoptions30
   //not foreign or collection properties  property name k8xxup30bvxxxxxxxxxxpurpose30
   //not foreign or collection also not component  property name k8xxup30bvxxxxxxxxxxpurpose30
   //not foreign or collection properties  property name k9xxuv30bvxxxxxxxxxxvalue30
   //not foreign or collection also not component  property name k9xxuv30bvxxxxxxxxxxvalue30
   //not foreign or collection properties  property name l1xxuo31bvxxxxxxxxxxoptions31
   //not foreign or collection also not component  property name l1xxuo31bvxxxxxxxxxxoptions31
   //not foreign or collection properties  property name l2xxup31bvxxxxxxxxxxpurpose31
   //not foreign or collection also not component  property name l2xxup31bvxxxxxxxxxxpurpose31
   //not foreign or collection properties  property name l3xxuv31bvxxxxxxxxxxvalue31
   //not foreign or collection also not component  property name l3xxuv31bvxxxxxxxxxxvalue31
   //not foreign or collection properties  property name l4xxuo32bvxxxxxxxxxxoptions32
   //not foreign or collection also not component  property name l4xxuo32bvxxxxxxxxxxoptions32
   //not foreign or collection properties  property name l5xxup32bvxxxxxxxxxxpurpose32
   //not foreign or collection also not component  property name l5xxup32bvxxxxxxxxxxpurpose32
   //not foreign or collection properties  property name l6xxuv32bvxxxxxxxxxxvalue32
   //not foreign or collection also not component  property name l6xxuv32bvxxxxxxxxxxvalue32
   //not foreign or collection properties  property name l7xxuo33bvxxxxxxxxxxoptions33
   //not foreign or collection also not component  property name l7xxuo33bvxxxxxxxxxxoptions33
   //not foreign or collection properties  property name l8xxup33bvxxxxxxxxxxpurpose33
   //not foreign or collection also not component  property name l8xxup33bvxxxxxxxxxxpurpose33
   //not foreign or collection properties  property name l9xxuv33bvxxxxxxxxxxvalue33
   //not foreign or collection also not component  property name l9xxuv33bvxxxxxxxxxxvalue33
   //not foreign or collection properties  property name m1xxuo34bvxxxxxxxxxxoptions34
   //not foreign or collection also not component  property name m1xxuo34bvxxxxxxxxxxoptions34
   //not foreign or collection properties  property name m2xxup34bvxxxxxxxxxxpurpose34
   //not foreign or collection also not component  property name m2xxup34bvxxxxxxxxxxpurpose34
   //not foreign or collection properties  property name m3xxuv34bvxxxxxxxxxxvalue34
   //not foreign or collection also not component  property name m3xxuv34bvxxxxxxxxxxvalue34
   //not foreign or collection properties  property name m4xxuo35bvxxxxxxxxxxoptions35
   //not foreign or collection also not component  property name m4xxuo35bvxxxxxxxxxxoptions35
   //not foreign or collection properties  property name m5xxup35bvxxxxxxxxxxpurpose35
   //not foreign or collection also not component  property name m5xxup35bvxxxxxxxxxxpurpose35
   //not foreign or collection properties  property name m6xxuv35bvxxxxxxxxxxvalue35
   //not foreign or collection also not component  property name m6xxuv35bvxxxxxxxxxxvalue35
   //not foreign or collection properties  property name m7xxuo36bvxxxxxxxxxxoptions36
   //not foreign or collection also not component  property name m7xxuo36bvxxxxxxxxxxoptions36
   //not foreign or collection properties  property name m8xxup36bvxxxxxxxxxxpurpose36
   //not foreign or collection also not component  property name m8xxup36bvxxxxxxxxxxpurpose36
   //not foreign or collection properties  property name m9xxuv36bvxxxxxxxxxxvalue36
   //not foreign or collection also not component  property name m9xxuv36bvxxxxxxxxxxvalue36
   //not foreign or collection properties  property name n1xxuo37bvxxxxxxxxxxoptions37
   //not foreign or collection also not component  property name n1xxuo37bvxxxxxxxxxxoptions37
   //not foreign or collection properties  property name n2xxup37bvxxxxxxxxxxpurpose37
   //not foreign or collection also not component  property name n2xxup37bvxxxxxxxxxxpurpose37
   //not foreign or collection properties  property name n3xxuv37bvxxxxxxxxxxvalue37
   //not foreign or collection also not component  property name n3xxuv37bvxxxxxxxxxxvalue37
   //not foreign or collection properties  property name n4xxuo38bvxxxxxxxxxxoptions38
   //not foreign or collection also not component  property name n4xxuo38bvxxxxxxxxxxoptions38
   //not foreign or collection properties  property name n5xxup38bvxxxxxxxxxxpurpose38
   //not foreign or collection also not component  property name n5xxup38bvxxxxxxxxxxpurpose38
   //not foreign or collection properties  property name n6xxuv38bvxxxxxxxxxxvalue38
   //not foreign or collection also not component  property name n6xxuv38bvxxxxxxxxxxvalue38
   //not foreign or collection properties  property name n7xxuo39bvxxxxxxxxxxoptions39
   //not foreign or collection also not component  property name n7xxuo39bvxxxxxxxxxxoptions39
   //not foreign or collection properties  property name n8xxup39bvxxxxxxxxxxpurpose39
   //not foreign or collection also not component  property name n8xxup39bvxxxxxxxxxxpurpose39
   //not foreign or collection properties  property name n9xxuv39bvxxxxxxxxxxvalue39
   //not foreign or collection also not component  property name n9xxuv39bvxxxxxxxxxxvalue39
   //not foreign or collection properties  property name o1xxuo40bvxxxxxxxxxxoptions40
   //not foreign or collection also not component  property name o1xxuo40bvxxxxxxxxxxoptions40
   //not foreign or collection properties  property name o2xxup40bvxxxxxxxxxxpurpose40
   //not foreign or collection also not component  property name o2xxup40bvxxxxxxxxxxpurpose40
   //not foreign or collection properties  property name o3xxuv40bvxxxxxxxxxxvalue40
   //not foreign or collection also not component  property name o3xxuv40bvxxxxxxxxxxvalue40
   //not foreign or collection properties  property name o4xxuo41bvxxxxxxxxxxoptions41
   //not foreign or collection also not component  property name o4xxuo41bvxxxxxxxxxxoptions41
   //not foreign or collection properties  property name o5xxup41bvxxxxxxxxxxpurpose41
   //not foreign or collection also not component  property name o5xxup41bvxxxxxxxxxxpurpose41
   //not foreign or collection properties  property name o6xxuv41bvxxxxxxxxxxvalue41
   //not foreign or collection also not component  property name o6xxuv41bvxxxxxxxxxxvalue41
   //not foreign or collection properties  property name o7xxuo42bvxxxxxxxxxxoptions42
   //not foreign or collection also not component  property name o7xxuo42bvxxxxxxxxxxoptions42
   //not foreign or collection properties  property name o8xxup42bvxxxxxxxxxxpurpose42
   //not foreign or collection also not component  property name o8xxup42bvxxxxxxxxxxpurpose42
   //not foreign or collection properties  property name o9xxuv42bvxxxxxxxxxxvalue42
   //not foreign or collection also not component  property name o9xxuv42bvxxxxxxxxxxvalue42
   //not foreign or collection properties  property name p1xxuo43bvxxxxxxxxxxoptions43
   //not foreign or collection also not component  property name p1xxuo43bvxxxxxxxxxxoptions43
   //not foreign or collection properties  property name p2xxup43bvxxxxxxxxxxpurpose43
   //not foreign or collection also not component  property name p2xxup43bvxxxxxxxxxxpurpose43
   //not foreign or collection properties  property name p3xxuv43bvxxxxxxxxxxvalue43
   //not foreign or collection also not component  property name p3xxuv43bvxxxxxxxxxxvalue43
   //not foreign or collection properties  property name p4xxuo44bvxxxxxxxxxxoptions44
   //not foreign or collection also not component  property name p4xxuo44bvxxxxxxxxxxoptions44
   //not foreign or collection properties  property name p5xxup44bvxxxxxxxxxxpurpose44
   //not foreign or collection also not component  property name p5xxup44bvxxxxxxxxxxpurpose44
   //not foreign or collection properties  property name p6xxuv44bvxxxxxxxxxxvalue44
   //not foreign or collection also not component  property name p6xxuv44bvxxxxxxxxxxvalue44
   //not foreign or collection properties  property name p7xxuo45bvxxxxxxxxxxoptions45
   //not foreign or collection also not component  property name p7xxuo45bvxxxxxxxxxxoptions45
   //not foreign or collection properties  property name p8xxup45bvxxxxxxxxxxpurpose45
   //not foreign or collection also not component  property name p8xxup45bvxxxxxxxxxxpurpose45
   //not foreign or collection properties  property name p9xxuv45bvxxxxxxxxxxvalue45
   //not foreign or collection also not component  property name p9xxuv45bvxxxxxxxxxxvalue45
   //not foreign or collection properties  property name q1xxuo46bvxxxxxxxxxxoptions46
   //not foreign or collection also not component  property name q1xxuo46bvxxxxxxxxxxoptions46
   //not foreign or collection properties  property name q2xxup46bvxxxxxxxxxxpurpose46
   //not foreign or collection also not component  property name q2xxup46bvxxxxxxxxxxpurpose46
   //not foreign or collection properties  property name q3xxuv46bvxxxxxxxxxxvalue46
   //not foreign or collection also not component  property name q3xxuv46bvxxxxxxxxxxvalue46
   //not foreign or collection properties  property name q4xxuo47bvxxxxxxxxxxoptions47
   //not foreign or collection also not component  property name q4xxuo47bvxxxxxxxxxxoptions47
   //not foreign or collection properties  property name q5xxup47bvxxxxxxxxxxpurpose47
   //not foreign or collection also not component  property name q5xxup47bvxxxxxxxxxxpurpose47
   //not foreign or collection properties  property name q6xxuv47bvxxxxxxxxxxvalue47
   //not foreign or collection also not component  property name q6xxuv47bvxxxxxxxxxxvalue47
   //not foreign or collection properties  property name q7xxuo48bvxxxxxxxxxxoptions48
   //not foreign or collection also not component  property name q7xxuo48bvxxxxxxxxxxoptions48
   //not foreign or collection properties  property name q8xxup48bvxxxxxxxxxxpurpose48
   //not foreign or collection also not component  property name q8xxup48bvxxxxxxxxxxpurpose48
   //not foreign or collection properties  property name q9xxuv48bvxxxxxxxxxxvalue48
   //not foreign or collection also not component  property name q9xxuv48bvxxxxxxxxxxvalue48
   //not foreign or collection properties  property name r1xxuo49bvxxxxxxxxxxoptions49
   //not foreign or collection also not component  property name r1xxuo49bvxxxxxxxxxxoptions49
   //not foreign or collection properties  property name r2xxup49bvxxxxxxxxxxpurpose49
   //not foreign or collection also not component  property name r2xxup49bvxxxxxxxxxxpurpose49
   //not foreign or collection properties  property name r3xxuv49bvxxxxxxxxxxvalue49
   //not foreign or collection also not component  property name r3xxuv49bvxxxxxxxxxxvalue49
   //not foreign or collection properties  property name r4xxuo50bvxxxxxxxxxxoptions50
   //not foreign or collection also not component  property name r4xxuo50bvxxxxxxxxxxoptions50
   //not foreign or collection properties  property name r5xxup50bvxxxxxxxxxxpurpose50
   //not foreign or collection also not component  property name r5xxup50bvxxxxxxxxxxpurpose50
   //not foreign or collection properties  property name r6xxuv50bvxxxxxxxxxxvalue50
   //not foreign or collection also not component  property name r6xxuv50bvxxxxxxxxxxvalue50
   //not foreign or collection properties  property name r7xxuo51bvxxxxxxxxxxoptions51
   //not foreign or collection also not component  property name r7xxuo51bvxxxxxxxxxxoptions51
   //not foreign or collection properties  property name r8xxup51bvxxxxxxxxxxpurpose51
   //not foreign or collection also not component  property name r8xxup51bvxxxxxxxxxxpurpose51
   //not foreign or collection properties  property name r9xxuv51bvxxxxxxxxxxvalue51
   //not foreign or collection also not component  property name r9xxuv51bvxxxxxxxxxxvalue51
   //not foreign or collection properties  property name s1xxuo52bvxxxxxxxxxxoptions52
   //not foreign or collection also not component  property name s1xxuo52bvxxxxxxxxxxoptions52
   //not foreign or collection properties  property name s2xxup52bvxxxxxxxxxxpurpose52
   //not foreign or collection also not component  property name s2xxup52bvxxxxxxxxxxpurpose52
   //not foreign or collection properties  property name s3xxuv52bvxxxxxxxxxxvalue52
   //not foreign or collection also not component  property name s3xxuv52bvxxxxxxxxxxvalue52
   //not foreign or collection properties  property name s4xxuo53bvxxxxxxxxxxoptions53
   //not foreign or collection also not component  property name s4xxuo53bvxxxxxxxxxxoptions53
   //not foreign or collection properties  property name s5xxup53bvxxxxxxxxxxpurpose53
   //not foreign or collection also not component  property name s5xxup53bvxxxxxxxxxxpurpose53
   //not foreign or collection properties  property name s6xxuv53bvxxxxxxxxxxvalue53
   //not foreign or collection also not component  property name s6xxuv53bvxxxxxxxxxxvalue53
   //not foreign or collection properties  property name s7xxuo54bvxxxxxxxxxxoptions54
   //not foreign or collection also not component  property name s7xxuo54bvxxxxxxxxxxoptions54
   //not foreign or collection properties  property name s8xxup54bvxxxxxxxxxxpurpose54
   //not foreign or collection also not component  property name s8xxup54bvxxxxxxxxxxpurpose54
   //not foreign or collection properties  property name s9xxuv54bvxxxxxxxxxxvalue54
   //not foreign or collection also not component  property name s9xxuv54bvxxxxxxxxxxvalue54
   //not foreign or collection properties  property name t1xxuo55bvxxxxxxxxxxoptions55
   //not foreign or collection also not component  property name t1xxuo55bvxxxxxxxxxxoptions55
   //not foreign or collection properties  property name t2xxup55bvxxxxxxxxxxpurpose55
   //not foreign or collection also not component  property name t2xxup55bvxxxxxxxxxxpurpose55
   //not foreign or collection properties  property name t3xxuv55bvxxxxxxxxxxvalue55
   //not foreign or collection also not component  property name t3xxuv55bvxxxxxxxxxxvalue55
   //not foreign or collection properties  property name t4xxuo56bvxxxxxxxxxxoptions56
   //not foreign or collection also not component  property name t4xxuo56bvxxxxxxxxxxoptions56
   //not foreign or collection properties  property name t5xxup56bvxxxxxxxxxxpurpose56
   //not foreign or collection also not component  property name t5xxup56bvxxxxxxxxxxpurpose56
   //not foreign or collection properties  property name t6xxuv56bvxxxxxxxxxxvalue56
   //not foreign or collection also not component  property name t6xxuv56bvxxxxxxxxxxvalue56
   //not foreign or collection properties  property name t7xxuo57bvxxxxxxxxxxoptions57
   //not foreign or collection also not component  property name t7xxuo57bvxxxxxxxxxxoptions57
   //not foreign or collection properties  property name t8xxup57bvxxxxxxxxxxpurpose57
   //not foreign or collection also not component  property name t8xxup57bvxxxxxxxxxxpurpose57
   //not foreign or collection properties  property name t9xxuv57bvxxxxxxxxxxvalue57
   //not foreign or collection also not component  property name t9xxuv57bvxxxxxxxxxxvalue57
   //not foreign or collection properties  property name u1xxuo58bvxxxxxxxxxxoptions58
   //not foreign or collection also not component  property name u1xxuo58bvxxxxxxxxxxoptions58
   //not foreign or collection properties  property name u2xxup58bvxxxxxxxxxxpurpose58
   //not foreign or collection also not component  property name u2xxup58bvxxxxxxxxxxpurpose58
   //not foreign or collection properties  property name u3xxuv58bvxxxxxxxxxxvalue58
   //not foreign or collection also not component  property name u3xxuv58bvxxxxxxxxxxvalue58
   //not foreign or collection properties  property name u4xxuo59bvxxxxxxxxxxoptions59
   //not foreign or collection also not component  property name u4xxuo59bvxxxxxxxxxxoptions59
   //not foreign or collection properties  property name u5xxup59bvxxxxxxxxxxpurpose59
   //not foreign or collection also not component  property name u5xxup59bvxxxxxxxxxxpurpose59
   //not foreign or collection properties  property name u6xxuv59bvxxxxxxxxxxvalue59
   //not foreign or collection also not component  property name u6xxuv59bvxxxxxxxxxxvalue59
   //not foreign or collection properties  property name u7xxuo60bvxxxxxxxxxxoptions60
   //not foreign or collection also not component  property name u7xxuo60bvxxxxxxxxxxoptions60
   //not foreign or collection properties  property name u8xxup60bvxxxxxxxxxxpurpose60
   //not foreign or collection also not component  property name u8xxup60bvxxxxxxxxxxpurpose60
   //not foreign or collection properties  property name u9xxuv60bvxxxxxxxxxxvalue60
   //not foreign or collection also not component  property name u9xxuv60bvxxxxxxxxxxvalue60
   //not foreign or collection properties  property name v1xxuo61bvxxxxxxxxxxoptions61
   //not foreign or collection also not component  property name v1xxuo61bvxxxxxxxxxxoptions61
   //not foreign or collection properties  property name v2xxup61bvxxxxxxxxxxpurpose61
   //not foreign or collection also not component  property name v2xxup61bvxxxxxxxxxxpurpose61
   //not foreign or collection properties  property name v3xxuv61bvxxxxxxxxxxvalue61
   //not foreign or collection also not component  property name v3xxuv61bvxxxxxxxxxxvalue61
   //not foreign or collection properties  property name y9xxuznxbvxxxxxxxxxxnotes
   //not foreign or collection also not component  property name y9xxuznxbvxxxxxxxxxxnotes
   //not foreign or collection properties  property name z1xxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection also not component  property name z1xxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection properties  property name z2xxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection also not component  property name z2xxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection properties  property name z3xxutoxlhxxxxxxxxxxowner
   //not foreign or collection also not component  property name z3xxutoxlhxxxxxxxxxxowner
   //not foreign or collection properties  property name zzxxu2oxxhxxxxxxxxxxowner2
   //not foreign or collection also not component  property name zzxxu2oxxhxxxxxxxxxxowner2



     String lorderColumn = "a0xxukcxbvxxxxxxxxxxrow";
     String lorder ="a0xxukcxbvxxxxxxxxxxrow asc";
     String lorderDirection = "asc";
     String orderColumnPrev = "";
     String orderDirectionPrev = "";
     int urlIndex=0;





public Yrxxch511xhhxxhxxxxxoptionsList()
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
       

        ///setEjbql(EJBQL);
        ///setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
         // parameters exceeded the maximum of 1000, for entitities like options, userprofl 
         // jay add logic to get default value from jsf and/or client setting
         setMaxResults(3);//options, userprofl
          maxResultsVal=1;
        // added desc order by sid 
         // setOrderColumn does not work see override resultList    
          //setOrderColumn( "yrxxch511xhhxxhxxxxxoptions.a0xxukcxbvxxxxxxxxxxrow" );
        //a0xxukcxbvxxxxxxxxxxrow
        
}

    public Yrxxch511xhhxxhxxxxxoptions getYrxxch511xhhxxhxxxxxoptions()
    {
        return yrxxch511xhhxxhxxxxxoptions;
    }

    public boolean isBitSet(Integer a, Integer n){ 
     if (a == null){
      a=0;
     }
     return (a & (1 << n)) != 0; 
    }


      private String  reportName  = "deYrxxch511xhhxxhxxxxxoptions";
      String reference="";
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
      
      private String start = "         ";
      private String group = "         ";
      private String end = "ZZZZZZZZZZZZZZZ";
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


     public List<Yrxxch511xhhxxhxxxxxoptions> getResultListByColumn(Integer column){
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

     public List<Yrxxch511xhhxxhxxxxxoptions> getResultListMaxSet(Integer maxResultsVal){
      sresults=null;// reset 
      this.maxResultsVal=maxResultsVal;
      return getResultList();
     }

     public List<Yrxxch511xhhxxhxxxxxoptions> getSystemResultListMaxSet(Integer maxResultsVal){
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
        
		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from Yrxxch511xhhxxhxxxxxoptions cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;

     }
     public Long getSystemResultCount(){
     // show SYSTEM only not including owner2, affected pagination

		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from Yrxxch511xhhxxhxxxxxoptions cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", "SYSTEM")
					.getSingleResult();
                return count;

     }

     public Long getResultCountClosed(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Yrxxch511xhhxxhxxxxxoptions cc where cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountReturned(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Yrxxch511xhhxxhxxxxxoptions cc where cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mreturn)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountOrdered(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Yrxxch511xhhxxhxxxxxoptions cc where cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code).setParameter("flag", mordered)
		.getSingleResult();
                return count;

     }


     public Long getResultCountShipped(){

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Yrxxch511xhhxxhxxxxxoptions  cc where cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", mshipped)
	.getSingleResult();
         return count;

     }
     public Long getResultCountInvoiced(){
       //invoiced refers to flag value 64 and may mean approved or ? or invoiced depending on the entity

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Yrxxch511xhhxxhxxxxxoptions  cc where cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", minvoiced)
	.getSingleResult();
         return count;

     }









     public List<Yrxxch511xhhxxhxxxxxoptions> getSystemResultList(){
      //use SYSTEM only,  allow PH to see

      // start null seems to make query return null, also null pointer to make lowercase
      if(start == null){
       start=" ";
      }
      if(end == null){
       end="zzzzz";
      }


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
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            if(searchVal == null || searchVal.isEmpty() ){
             searchVal=searchValJ;// until why seachVal getting empty this logic needed           
            }

           // add logic to handle client(52),options(51),user(56) userprofl (57) etc which wont or on exception have user as owner
          // means could return empty in xxx.list       
		List<Yrxxch511xhhxxhxxxxxoptions> results =  getEntityManager()
                                     .createQuery(
                                       "select cc from Yrxxch511xhhxxhxxxxxoptions  cc where cc.z3xxutoxlhxxxxxxxxxxowner=:owner  and  ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%')) or lower(y9xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukcxbvxxxxxxxxxxrow) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner", ownerCode)
                                        .setParameter("owner2", "SYSTEM")
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .getResultList();
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
 
           getEntityManager().clear();// otherwise search was causing row being overwritten by search row
            // jsf cannot handle too many rows and columns for options(51) so return 1 but allow search to pick any, client(52)which also has many rows/columns checking not needed since only one record matching owner2 is shown
            // employee(40) restrict to own record,if demo user. otherwise show all like default user(56) restrict to own record if demo user
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            //options date not needed in search, options(51) maxresults reduced from 100 to default 3 to avoid excessive parameters
		sresults =  getEntityManager()
					.createQuery(
							"select cc from Yrxxch511xhhxxhxxxxxoptions  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%')) or lower(y9xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukcxbvxxxxxxxxxxrow) between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();

            //non options end
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
    * The following method overrides seam method because setOrder did not work 
    * @param args -none
    * @return List<Yrxxch511xhhxxhxxxxxoptions>
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

     public List<Yrxxch511xhhxxhxxxxxoptions> getResultList(){
      // shopping items for visitors are not fetched here but in itembrowselist or in itemdetailbrowselist 
      // if visitor ,for any table, allow only own or owned records
      // jay resultList check whether any exception needed 
      // ?? if employee table allow only owned or owned records for "U" user
      // maxResults may be set by caller or already set as 6
      // search1 ie key property may be empty , getFirst is a method in seam superclass and sets the first record
      // use seq not key seqs for numeric ordering //jayresultList

      // start null seems to make query return null, also null pointer to make lowercase
      if(start == null){
       start=" ";
      }
      if(end == null){
       end="zzzzz";
      }


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
            //search1 ie keyfield has value
            if(this.searchDate == null){
             searchDateD=new Date(0);           
            }else{
             searchDateD=this.searchDate;
            }
            if(searchVal == null || searchVal.isEmpty() ){
             searchVal=searchValJ;// until why seachVal getting empty this logic needed           
            }
           // for visitors, added logic to handle client(52),options(51),user(56) userprofl (57) etc which wont or on exception have user as owner
          // means could return empty in xxx.list       
                                   List<Yrxxch511xhhxxhxxxxxoptions> results =  getEntityManager()
                                    .createQuery(
                                     "select cc from Yrxxch511xhhxxhxxxxxoptions  cc where cc.z3xxutoxlhxxxxxxxxxxowner=:owner  and ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%')) or lower(y9xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukcxbvxxxxxxxxxxrow) between :start and :end) ) order by "+ lorder)
                                      .setParameter("owner", ownerCode)
                                        .setParameter("owner2", owner2Code) 
                                        .setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                       .getResultList();
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
 
           getEntityManager().clear();// otherwise search was causing row being overwritten by search row
            // jsf cannot handle too many rows and columns for options(51) so return 1 but allow search to pick any, client(52)which also has many rows/columns checking not needed since only one record matching owner2 is shown
            // employee(40) restrict to own record,if demo user. otherwise show all like default user(56) restrict to own record if demo user
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
	sresults =  getEntityManager()
	.createQuery(
	"select cc from Yrxxch511xhhxxhxxxxxoptions  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%')) or lower(y9xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukcxbvxxxxxxxxxxrow) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukcxbvxxxxxxxxxxrow) between :start and :end) ) order by "+ lorder)
                   .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                   .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                  .getResultList();

//options/nonoptions
            //non options end
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

     public Yrxxch511xhhxxhxxxxxoptions getSidSToEntity(String sidS){
      return getSidToEntity(Integer.parseInt(sidS));//
     }

     public Yrxxch511xhhxxhxxxxxoptions getSidToEntity(Integer sid){
      Yrxxch511xhhxxhxxxxxoptions entity=null;
      List<Yrxxch511xhhxxhxxxxxoptions> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("options")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("options")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 













	public List<Yrxxch511xhhxxhxxxxxoptions> getFlaggedAsList(int flag) {
		// will return objects matching flag 
		return getEntityManager()
				.createQuery(
						"select cc from Yrxxch511xhhxxhxxxxxoptions cc where (cc.z1xxzzfxhhxxxxxxxxxxstatusfl = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Yrxxch511xhhxxhxxxxxoptions> getNotFlaggedAsList(int flag) {
		// will return objects not matching flag 

		return getEntityManager()
				.createQuery(
						"select cc from Yrxxch511xhhxxhxxxxxoptions cc where (cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Yrxxch511xhhxxhxxxxxoptions> getOldByList(int days) {
	// will return objects statusfldt < today-days
        calendar.add(Calendar.DATE, -days); //xx days in past, can check further for 15 days/7 days/ expiry
        Date searchDate= calendar.getTime();

	return getEntityManager()
	 .createQuery(
	  "select cc from Yrxxch511xhhxxhxxxxxoptions cc where (cast(cc.z2xxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
	   .setParameter("searchDate", searchDate).setParameter("owner2", owner2Code).getResultList();

	}






         public Yrxxch511xhhxxhxxxxxoptions getKeyToEntity(String key){
      Yrxxch511xhhxxhxxxxxoptions entity=null;
      List<Yrxxch511xhhxxhxxxxxoptions> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("options")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("options")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+" "+bundle.getString("found"),""));
          // end user may see it,FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          // FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          customIdentity.setHoldValue3(""+results.size());//caller may examine this
      }
      return results.get(0);

    } 


     public Yrxxch511xhhxxhxxxxxoptions getKeyContainsToEntity(String key){
      Yrxxch511xhhxxhxxxxxoptions entity=null;
      List<Yrxxch511xhhxxhxxxxxoptions> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow like :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key+'%')
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("options")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("options")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
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
      String value= getEntityManager().createQuery(" select a0xxukcxbvxxxxxxxxxxrow from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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


     public String getKeyOwner2Value(Integer key) {
     if(key == null || key == 0){
      return null;
     }
     try{
      String value= getEntityManager().createQuery(" select a0xxukcxbvxxxxxxxxxxrow||'/'||zzxxu2oxxhxxxxxxxxxxowner2 from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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
 
      for (Yrxxch511xhhxxhxxxxxoptions yrxxch511xhhxxhxxxxxoptions : getSuggestList(userInput)) {
         ret.add(yrxxch511xhhxxhxxxxxoptions.getA0xxukcxbvxxxxxxxxxxrow());
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
     public List<Yrxxch511xhhxxhxxxxxoptions> getSuggestList(String prefix,String hideTypePrefix) {
     // getSuggestList is called when non key values are also needed like item key, its price etc 
     // when is keyfield blank probably never for keyAutogen
     
			return getEntityManager().createQuery(" select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow >=:keyOfEntity  AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix )  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukcxbvxxxxxxxxxxrow  ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
	}
   





	public List<Yrxxch511xhhxxhxxxxxoptions> getSystemSuggestList(String prefix) {
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow >=:keyOfEntity AND cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode order by cc.a0xxukcxbvxxxxxxxxxxrow")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow >=:keyOfEntity AND cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukcxbvxxxxxxxxxxrow")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                return null;

        }

     public List<Yrxxch511xhhxxhxxxxxoptions> getSuggestList(String prefix) {
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

 
                        //in send() method nomail (unsubscribed) is filtered out for group members 
                        if(prefix !=null && (prefix.isEmpty() || prefix.equals("email")) ){
                         prefix="0";
                        } 

			 return getEntityManager().createQuery(" select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow >=:keyOfEntity AND cc.z1xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxukcxbvxxxxxxxxxxrow  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();


	}
     public List<Yrxxch511xhhxxhxxxxxoptions> getNextSids(Integer sid){
      sresults=null;// reset 
      List<Yrxxch511xhhxxhxxxxxoptions> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and cc.a0xxuobxbxxxxxxxxxxxsid >=:sid order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).setParameter("sid", sid)
					.getResultList();
      return results;
     }
     public List<Integer> getAllSids(){
      List<Integer> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc.a0xxuobxbxxxxxxxxxxxsid from Yrxxch511xhhxxhxxxxxoptions cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).getResultList();
      return results;
     }









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

     private List<Yrxxch511xhhxxhxxxxxoptions> listofOptions;
	public Map<String,String> getoptionsFieldList(String entityCode,int optionNo) {
            fieldKeyList=new LinkedHashMap<String,String>();
            //user can change country via footer when not logged in, default is "". this country value is used for user options drop down
            //check re another country used for messages based on locale country in databaseresourceloader
            //countryIsoEq=authenticator.getCountry().toLowerCase(); cannot inject plus better to save and use
            yxxxch575xwwqqhxxxxxuserprofl=yxxxuh566xwwqqwxxxxxuserList.getUserProfiles();
            //some webpage like signup needs options when the userprofil does not exist yet, use default country
            if(yxxxch575xwwqqhxxxxxuserprofl == null){
             countryIsoEq="ca=";
            }else{
             countryIsoEq=yxxxch575xwwqqhxxxxxuserprofl.getC3xxuxxrbvxxxxxxxxxxp1(); 
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
              List<Yrxxch511xhhxxhxxxxxoptions> listofOptions = getEntityManager().createQuery("select cc from Yrxxch511xhhxxhxxxxxoptions cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 order by cc.a0xxukcxbvxxxxxxxxxxrow")
                   .setParameter("owner2", owner2Code).getResultList() ;

		   Iterator<Yrxxch511xhhxxhxxxxxoptions> itr = listofOptions.iterator();
		   while (itr.hasNext()) {
		    yrxxch511xhhxxhxxxxxoptions = itr.next();

               switch(optionNo){

                case 1:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getB3xxuv01bvxxxxxxxxxxvalue01()==null?"":yrxxch511xhhxxhxxxxxoptions.getB3xxuv01bvxxxxxxxxxxvalue01().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getB1xxuo01bvxxxxxxxxxxoptions01()==null?"":yrxxch511xhhxxhxxxxxoptions.getB1xxuo01bvxxxxxxxxxxoptions01().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getB2xxup01bvxxxxxxxxxxpurpose01()==null?"":yrxxch511xhhxxhxxxxxoptions.getB2xxup01bvxxxxxxxxxxpurpose01().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 2:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getB6xxuv02bvxxxxxxxxxxvalue02()==null?"":yrxxch511xhhxxhxxxxxoptions.getB6xxuv02bvxxxxxxxxxxvalue02().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getB4xxuo02bvxxxxxxxxxxoptions02()==null?"":yrxxch511xhhxxhxxxxxoptions.getB4xxuo02bvxxxxxxxxxxoptions02().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getB5xxup02bvxxxxxxxxxxpurpose02()==null?"":yrxxch511xhhxxhxxxxxoptions.getB5xxup02bvxxxxxxxxxxpurpose02().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 3:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getB9xxuv03bvxxxxxxxxxxvalue03()==null?"":yrxxch511xhhxxhxxxxxoptions.getB9xxuv03bvxxxxxxxxxxvalue03().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getB7xxuo03bvxxxxxxxxxxoptions03()==null?"":yrxxch511xhhxxhxxxxxoptions.getB7xxuo03bvxxxxxxxxxxoptions03().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getB8xxup03bvxxxxxxxxxxpurpose03()==null?"":yrxxch511xhhxxhxxxxxoptions.getB8xxup03bvxxxxxxxxxxpurpose03().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 4:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getC3xxuv04bvxxxxxxxxxxvalue04()==null?"":yrxxch511xhhxxhxxxxxoptions.getC3xxuv04bvxxxxxxxxxxvalue04().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getC1xxuo04bvxxxxxxxxxxoptions04()==null?"":yrxxch511xhhxxhxxxxxoptions.getC1xxuo04bvxxxxxxxxxxoptions04().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getC2xxup04bvxxxxxxxxxxpurpose04()==null?"":yrxxch511xhhxxhxxxxxoptions.getC2xxup04bvxxxxxxxxxxpurpose04().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 5:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getC6xxuv05bvxxxxxxxxxxvalue05()==null?"":yrxxch511xhhxxhxxxxxoptions.getC6xxuv05bvxxxxxxxxxxvalue05().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getC4xxuo05bvxxxxxxxxxxoptions05()==null?"":yrxxch511xhhxxhxxxxxoptions.getC4xxuo05bvxxxxxxxxxxoptions05().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getC5xxup05bvxxxxxxxxxxpurpose05()==null?"":yrxxch511xhhxxhxxxxxoptions.getC5xxup05bvxxxxxxxxxxpurpose05().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 6:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getC9xxuv06bvxxxxxxxxxxvalue06()==null?"":yrxxch511xhhxxhxxxxxoptions.getC9xxuv06bvxxxxxxxxxxvalue06().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getC7xxuo06bvxxxxxxxxxxoptions06()==null?"":yrxxch511xhhxxhxxxxxoptions.getC7xxuo06bvxxxxxxxxxxoptions06().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getC8xxup06bvxxxxxxxxxxpurpose06()==null?"":yrxxch511xhhxxhxxxxxoptions.getC8xxup06bvxxxxxxxxxxpurpose06().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 7:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getD3xxuv07bvxxxxxxxxxxvalue07()==null?"":yrxxch511xhhxxhxxxxxoptions.getD3xxuv07bvxxxxxxxxxxvalue07().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getD1xxuo07bvxxxxxxxxxxoptions07()==null?"":yrxxch511xhhxxhxxxxxoptions.getD1xxuo07bvxxxxxxxxxxoptions07().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getD2xxup07bvxxxxxxxxxxpurpose07()==null?"":yrxxch511xhhxxhxxxxxoptions.getD2xxup07bvxxxxxxxxxxpurpose07().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 8:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getD6xxuv08bvxxxxxxxxxxvalue08()==null?"":yrxxch511xhhxxhxxxxxoptions.getD6xxuv08bvxxxxxxxxxxvalue08().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getD4xxuo08bvxxxxxxxxxxoptions08()==null?"":yrxxch511xhhxxhxxxxxoptions.getD4xxuo08bvxxxxxxxxxxoptions08().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getD5xxup08bvxxxxxxxxxxpurpose08()==null?"":yrxxch511xhhxxhxxxxxoptions.getD5xxup08bvxxxxxxxxxxpurpose08().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 9:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getD9xxuv09bvxxxxxxxxxxvalue09()==null?"":yrxxch511xhhxxhxxxxxoptions.getD9xxuv09bvxxxxxxxxxxvalue09().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getD7xxuo09bvxxxxxxxxxxoptions09()==null?"":yrxxch511xhhxxhxxxxxoptions.getD7xxuo09bvxxxxxxxxxxoptions09().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getD8xxup09bvxxxxxxxxxxpurpose09()==null?"":yrxxch511xhhxxhxxxxxoptions.getD8xxup09bvxxxxxxxxxxpurpose09().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 10:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getE3xxuv10bvxxxxxxxxxxvalue10()==null?"":yrxxch511xhhxxhxxxxxoptions.getE3xxuv10bvxxxxxxxxxxvalue10().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getE1xxuo10bvxxxxxxxxxxoptions10()==null?"":yrxxch511xhhxxhxxxxxoptions.getE1xxuo10bvxxxxxxxxxxoptions10().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getE2xxup10bvxxxxxxxxxxpurpose10()==null?"":yrxxch511xhhxxhxxxxxoptions.getE2xxup10bvxxxxxxxxxxpurpose10().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 11:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getE6xxuv11bvxxxxxxxxxxvalue11()==null?"":yrxxch511xhhxxhxxxxxoptions.getE6xxuv11bvxxxxxxxxxxvalue11().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getE4xxuo11bvxxxxxxxxxxoptions11()==null?"":yrxxch511xhhxxhxxxxxoptions.getE4xxuo11bvxxxxxxxxxxoptions11().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getE5xxup11bvxxxxxxxxxxpurpose11()==null?"":yrxxch511xhhxxhxxxxxoptions.getE5xxup11bvxxxxxxxxxxpurpose11().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 12:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getE9xxuv12bvxxxxxxxxxxvalue12()==null?"":yrxxch511xhhxxhxxxxxoptions.getE9xxuv12bvxxxxxxxxxxvalue12().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getE7xxuo12bvxxxxxxxxxxoptions12()==null?"":yrxxch511xhhxxhxxxxxoptions.getE7xxuo12bvxxxxxxxxxxoptions12().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getE8xxup12bvxxxxxxxxxxpurpose12()==null?"":yrxxch511xhhxxhxxxxxoptions.getE8xxup12bvxxxxxxxxxxpurpose12().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 13:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getF3xxuv13bvxxxxxxxxxxvalue13()==null?"":yrxxch511xhhxxhxxxxxoptions.getF3xxuv13bvxxxxxxxxxxvalue13().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getF1xxuo13bvxxxxxxxxxxoptions13()==null?"":yrxxch511xhhxxhxxxxxoptions.getF1xxuo13bvxxxxxxxxxxoptions13().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getF2xxup13bvxxxxxxxxxxpurpose13()==null?"":yrxxch511xhhxxhxxxxxoptions.getF2xxup13bvxxxxxxxxxxpurpose13().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 14:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getF6xxuv14bvxxxxxxxxxxvalue14()==null?"":yrxxch511xhhxxhxxxxxoptions.getF6xxuv14bvxxxxxxxxxxvalue14().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getF4xxuo14bvxxxxxxxxxxoptions14()==null?"":yrxxch511xhhxxhxxxxxoptions.getF4xxuo14bvxxxxxxxxxxoptions14().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getF5xxup14bvxxxxxxxxxxpurpose14()==null?"":yrxxch511xhhxxhxxxxxoptions.getF5xxup14bvxxxxxxxxxxpurpose14().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 15:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getF9xxuv15bvxxxxxxxxxxvalue15()==null?"":yrxxch511xhhxxhxxxxxoptions.getF9xxuv15bvxxxxxxxxxxvalue15().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getF7xxuo15bvxxxxxxxxxxoptions15()==null?"":yrxxch511xhhxxhxxxxxoptions.getF7xxuo15bvxxxxxxxxxxoptions15().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getF8xxup15bvxxxxxxxxxxpurpose15()==null?"":yrxxch511xhhxxhxxxxxoptions.getF8xxup15bvxxxxxxxxxxpurpose15().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 16:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getG3xxuv16bvxxxxxxxxxxvalue16()==null?"":yrxxch511xhhxxhxxxxxoptions.getG3xxuv16bvxxxxxxxxxxvalue16().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getG1xxuo16bvxxxxxxxxxxoptions16()==null?"":yrxxch511xhhxxhxxxxxoptions.getG1xxuo16bvxxxxxxxxxxoptions16().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getG2xxup16bvxxxxxxxxxxpurpose16()==null?"":yrxxch511xhhxxhxxxxxoptions.getG2xxup16bvxxxxxxxxxxpurpose16().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 17:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getG6xxuv17bvxxxxxxxxxxvalue17()==null?"":yrxxch511xhhxxhxxxxxoptions.getG6xxuv17bvxxxxxxxxxxvalue17().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getG4xxuo17bvxxxxxxxxxxoptions17()==null?"":yrxxch511xhhxxhxxxxxoptions.getG4xxuo17bvxxxxxxxxxxoptions17().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getG5xxup17bvxxxxxxxxxxpurpose17()==null?"":yrxxch511xhhxxhxxxxxoptions.getG5xxup17bvxxxxxxxxxxpurpose17().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 18:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getG9xxuv18bvxxxxxxxxxxvalue18()==null?"":yrxxch511xhhxxhxxxxxoptions.getG9xxuv18bvxxxxxxxxxxvalue18().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getG7xxuo18bvxxxxxxxxxxoptions18()==null?"":yrxxch511xhhxxhxxxxxoptions.getG7xxuo18bvxxxxxxxxxxoptions18().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getG8xxup18bvxxxxxxxxxxpurpose18()==null?"":yrxxch511xhhxxhxxxxxoptions.getG8xxup18bvxxxxxxxxxxpurpose18().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 19:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getH3xxuv19bvxxxxxxxxxxvalue19()==null?"":yrxxch511xhhxxhxxxxxoptions.getH3xxuv19bvxxxxxxxxxxvalue19().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getH1xxuo19bvxxxxxxxxxxoptions19()==null?"":yrxxch511xhhxxhxxxxxoptions.getH1xxuo19bvxxxxxxxxxxoptions19().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getH2xxup19bvxxxxxxxxxxpurpose19()==null?"":yrxxch511xhhxxhxxxxxoptions.getH2xxup19bvxxxxxxxxxxpurpose19().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 20:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getH6xxuv20bvxxxxxxxxxxvalue20()==null?"":yrxxch511xhhxxhxxxxxoptions.getH6xxuv20bvxxxxxxxxxxvalue20().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getH4xxuo20bvxxxxxxxxxxoptions20()==null?"":yrxxch511xhhxxhxxxxxoptions.getH4xxuo20bvxxxxxxxxxxoptions20().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getH5xxup20bvxxxxxxxxxxpurpose20()==null?"":yrxxch511xhhxxhxxxxxoptions.getH5xxup20bvxxxxxxxxxxpurpose20().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 21:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getH9xxuv21bvxxxxxxxxxxvalue21()==null?"":yrxxch511xhhxxhxxxxxoptions.getH9xxuv21bvxxxxxxxxxxvalue21().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getH7xxuo21bvxxxxxxxxxxoptions21()==null?"":yrxxch511xhhxxhxxxxxoptions.getH7xxuo21bvxxxxxxxxxxoptions21().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getH8xxup21bvxxxxxxxxxxpurpose21()==null?"":yrxxch511xhhxxhxxxxxoptions.getH8xxup21bvxxxxxxxxxxpurpose21().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 22:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getI3xxuv22bvxxxxxxxxxxvalue22()==null?"":yrxxch511xhhxxhxxxxxoptions.getI3xxuv22bvxxxxxxxxxxvalue22().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getI1xxuo22bvxxxxxxxxxxoptions22()==null?"":yrxxch511xhhxxhxxxxxoptions.getI1xxuo22bvxxxxxxxxxxoptions22().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getI2xxup22bvxxxxxxxxxxpurpose22()==null?"":yrxxch511xhhxxhxxxxxoptions.getI2xxup22bvxxxxxxxxxxpurpose22().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 23:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getI6xxuv23bvxxxxxxxxxxvalue23()==null?"":yrxxch511xhhxxhxxxxxoptions.getI6xxuv23bvxxxxxxxxxxvalue23().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getI4xxuo23bvxxxxxxxxxxoptions23()==null?"":yrxxch511xhhxxhxxxxxoptions.getI4xxuo23bvxxxxxxxxxxoptions23().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getI5xxup23bvxxxxxxxxxxpurpose23()==null?"":yrxxch511xhhxxhxxxxxoptions.getI5xxup23bvxxxxxxxxxxpurpose23().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 24:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getI9xxuv24bvxxxxxxxxxxvalue24()==null?"":yrxxch511xhhxxhxxxxxoptions.getI9xxuv24bvxxxxxxxxxxvalue24().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getI7xxuo24bvxxxxxxxxxxoptions24()==null?"":yrxxch511xhhxxhxxxxxoptions.getI7xxuo24bvxxxxxxxxxxoptions24().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getI8xxup24bvxxxxxxxxxxpurpose24()==null?"":yrxxch511xhhxxhxxxxxoptions.getI8xxup24bvxxxxxxxxxxpurpose24().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 25:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getJ3xxuv25bvxxxxxxxxxxvalue25()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ3xxuv25bvxxxxxxxxxxvalue25().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getJ1xxuo25bvxxxxxxxxxxoptions25()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ1xxuo25bvxxxxxxxxxxoptions25().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getJ2xxup25bvxxxxxxxxxxpurpose25()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ2xxup25bvxxxxxxxxxxpurpose25().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 26:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getJ6xxuv26bvxxxxxxxxxxvalue26()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ6xxuv26bvxxxxxxxxxxvalue26().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getJ4xxuo26bvxxxxxxxxxxoptions26()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ4xxuo26bvxxxxxxxxxxoptions26().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getJ5xxup26bvxxxxxxxxxxpurpose26()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ5xxup26bvxxxxxxxxxxpurpose26().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 27:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getJ9xxuv27bvxxxxxxxxxxvalue27()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ9xxuv27bvxxxxxxxxxxvalue27().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getJ7xxuo27bvxxxxxxxxxxoptions27()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ7xxuo27bvxxxxxxxxxxoptions27().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getJ8xxup27bvxxxxxxxxxxpurpose27()==null?"":yrxxch511xhhxxhxxxxxoptions.getJ8xxup27bvxxxxxxxxxxpurpose27().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 28:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getK3xxuv28bvxxxxxxxxxxvalue28()==null?"":yrxxch511xhhxxhxxxxxoptions.getK3xxuv28bvxxxxxxxxxxvalue28().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getK1xxuo28bvxxxxxxxxxxoptions28()==null?"":yrxxch511xhhxxhxxxxxoptions.getK1xxuo28bvxxxxxxxxxxoptions28().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getK2xxup28bvxxxxxxxxxxpurpose28()==null?"":yrxxch511xhhxxhxxxxxoptions.getK2xxup28bvxxxxxxxxxxpurpose28().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 29:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getK6xxuv29bvxxxxxxxxxxvalue29()==null?"":yrxxch511xhhxxhxxxxxoptions.getK6xxuv29bvxxxxxxxxxxvalue29().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getK4xxuo29bvxxxxxxxxxxoptions29()==null?"":yrxxch511xhhxxhxxxxxoptions.getK4xxuo29bvxxxxxxxxxxoptions29().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getK5xxup29bvxxxxxxxxxxpurpose29()==null?"":yrxxch511xhhxxhxxxxxoptions.getK5xxup29bvxxxxxxxxxxpurpose29().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 30:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getK9xxuv30bvxxxxxxxxxxvalue30()==null?"":yrxxch511xhhxxhxxxxxoptions.getK9xxuv30bvxxxxxxxxxxvalue30().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getK7xxuo30bvxxxxxxxxxxoptions30()==null?"":yrxxch511xhhxxhxxxxxoptions.getK7xxuo30bvxxxxxxxxxxoptions30().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getK8xxup30bvxxxxxxxxxxpurpose30()==null?"":yrxxch511xhhxxhxxxxxoptions.getK8xxup30bvxxxxxxxxxxpurpose30().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 31:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getL3xxuv31bvxxxxxxxxxxvalue31()==null?"":yrxxch511xhhxxhxxxxxoptions.getL3xxuv31bvxxxxxxxxxxvalue31().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getL1xxuo31bvxxxxxxxxxxoptions31()==null?"":yrxxch511xhhxxhxxxxxoptions.getL1xxuo31bvxxxxxxxxxxoptions31().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getL2xxup31bvxxxxxxxxxxpurpose31()==null?"":yrxxch511xhhxxhxxxxxoptions.getL2xxup31bvxxxxxxxxxxpurpose31().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 32:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getL6xxuv32bvxxxxxxxxxxvalue32()==null?"":yrxxch511xhhxxhxxxxxoptions.getL6xxuv32bvxxxxxxxxxxvalue32().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getL4xxuo32bvxxxxxxxxxxoptions32()==null?"":yrxxch511xhhxxhxxxxxoptions.getL4xxuo32bvxxxxxxxxxxoptions32().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getL5xxup32bvxxxxxxxxxxpurpose32()==null?"":yrxxch511xhhxxhxxxxxoptions.getL5xxup32bvxxxxxxxxxxpurpose32().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 33:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getL9xxuv33bvxxxxxxxxxxvalue33()==null?"":yrxxch511xhhxxhxxxxxoptions.getL9xxuv33bvxxxxxxxxxxvalue33().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getL7xxuo33bvxxxxxxxxxxoptions33()==null?"":yrxxch511xhhxxhxxxxxoptions.getL7xxuo33bvxxxxxxxxxxoptions33().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getL8xxup33bvxxxxxxxxxxpurpose33()==null?"":yrxxch511xhhxxhxxxxxoptions.getL8xxup33bvxxxxxxxxxxpurpose33().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 34:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getM3xxuv34bvxxxxxxxxxxvalue34()==null?"":yrxxch511xhhxxhxxxxxoptions.getM3xxuv34bvxxxxxxxxxxvalue34().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getM1xxuo34bvxxxxxxxxxxoptions34()==null?"":yrxxch511xhhxxhxxxxxoptions.getM1xxuo34bvxxxxxxxxxxoptions34().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getM2xxup34bvxxxxxxxxxxpurpose34()==null?"":yrxxch511xhhxxhxxxxxoptions.getM2xxup34bvxxxxxxxxxxpurpose34().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 35:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getM6xxuv35bvxxxxxxxxxxvalue35()==null?"":yrxxch511xhhxxhxxxxxoptions.getM6xxuv35bvxxxxxxxxxxvalue35().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getM4xxuo35bvxxxxxxxxxxoptions35()==null?"":yrxxch511xhhxxhxxxxxoptions.getM4xxuo35bvxxxxxxxxxxoptions35().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getM5xxup35bvxxxxxxxxxxpurpose35()==null?"":yrxxch511xhhxxhxxxxxoptions.getM5xxup35bvxxxxxxxxxxpurpose35().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 36:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getM9xxuv36bvxxxxxxxxxxvalue36()==null?"":yrxxch511xhhxxhxxxxxoptions.getM9xxuv36bvxxxxxxxxxxvalue36().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getM7xxuo36bvxxxxxxxxxxoptions36()==null?"":yrxxch511xhhxxhxxxxxoptions.getM7xxuo36bvxxxxxxxxxxoptions36().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getM8xxup36bvxxxxxxxxxxpurpose36()==null?"":yrxxch511xhhxxhxxxxxoptions.getM8xxup36bvxxxxxxxxxxpurpose36().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 37:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getN3xxuv37bvxxxxxxxxxxvalue37()==null?"":yrxxch511xhhxxhxxxxxoptions.getN3xxuv37bvxxxxxxxxxxvalue37().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getN1xxuo37bvxxxxxxxxxxoptions37()==null?"":yrxxch511xhhxxhxxxxxoptions.getN1xxuo37bvxxxxxxxxxxoptions37().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getN2xxup37bvxxxxxxxxxxpurpose37()==null?"":yrxxch511xhhxxhxxxxxoptions.getN2xxup37bvxxxxxxxxxxpurpose37().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 38:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getN6xxuv38bvxxxxxxxxxxvalue38()==null?"":yrxxch511xhhxxhxxxxxoptions.getN6xxuv38bvxxxxxxxxxxvalue38().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getN4xxuo38bvxxxxxxxxxxoptions38()==null?"":yrxxch511xhhxxhxxxxxoptions.getN4xxuo38bvxxxxxxxxxxoptions38().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getN5xxup38bvxxxxxxxxxxpurpose38()==null?"":yrxxch511xhhxxhxxxxxoptions.getN5xxup38bvxxxxxxxxxxpurpose38().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 39:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getN9xxuv39bvxxxxxxxxxxvalue39()==null?"":yrxxch511xhhxxhxxxxxoptions.getN9xxuv39bvxxxxxxxxxxvalue39().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getN7xxuo39bvxxxxxxxxxxoptions39()==null?"":yrxxch511xhhxxhxxxxxoptions.getN7xxuo39bvxxxxxxxxxxoptions39().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getN8xxup39bvxxxxxxxxxxpurpose39()==null?"":yrxxch511xhhxxhxxxxxoptions.getN8xxup39bvxxxxxxxxxxpurpose39().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 40:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getO3xxuv40bvxxxxxxxxxxvalue40()==null?"":yrxxch511xhhxxhxxxxxoptions.getO3xxuv40bvxxxxxxxxxxvalue40().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getO1xxuo40bvxxxxxxxxxxoptions40()==null?"":yrxxch511xhhxxhxxxxxoptions.getO1xxuo40bvxxxxxxxxxxoptions40().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getO2xxup40bvxxxxxxxxxxpurpose40()==null?"":yrxxch511xhhxxhxxxxxoptions.getO2xxup40bvxxxxxxxxxxpurpose40().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 41:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getO6xxuv41bvxxxxxxxxxxvalue41()==null?"":yrxxch511xhhxxhxxxxxoptions.getO6xxuv41bvxxxxxxxxxxvalue41().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getO4xxuo41bvxxxxxxxxxxoptions41()==null?"":yrxxch511xhhxxhxxxxxoptions.getO4xxuo41bvxxxxxxxxxxoptions41().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getO5xxup41bvxxxxxxxxxxpurpose41()==null?"":yrxxch511xhhxxhxxxxxoptions.getO5xxup41bvxxxxxxxxxxpurpose41().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 42:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getO9xxuv42bvxxxxxxxxxxvalue42()==null?"":yrxxch511xhhxxhxxxxxoptions.getO9xxuv42bvxxxxxxxxxxvalue42().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getO7xxuo42bvxxxxxxxxxxoptions42()==null?"":yrxxch511xhhxxhxxxxxoptions.getO7xxuo42bvxxxxxxxxxxoptions42().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getO8xxup42bvxxxxxxxxxxpurpose42()==null?"":yrxxch511xhhxxhxxxxxoptions.getO8xxup42bvxxxxxxxxxxpurpose42().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 43:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getP3xxuv43bvxxxxxxxxxxvalue43()==null?"":yrxxch511xhhxxhxxxxxoptions.getP3xxuv43bvxxxxxxxxxxvalue43().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getP1xxuo43bvxxxxxxxxxxoptions43()==null?"":yrxxch511xhhxxhxxxxxoptions.getP1xxuo43bvxxxxxxxxxxoptions43().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getP2xxup43bvxxxxxxxxxxpurpose43()==null?"":yrxxch511xhhxxhxxxxxoptions.getP2xxup43bvxxxxxxxxxxpurpose43().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 44:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getP6xxuv44bvxxxxxxxxxxvalue44()==null?"":yrxxch511xhhxxhxxxxxoptions.getP6xxuv44bvxxxxxxxxxxvalue44().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getP4xxuo44bvxxxxxxxxxxoptions44()==null?"":yrxxch511xhhxxhxxxxxoptions.getP4xxuo44bvxxxxxxxxxxoptions44().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getP5xxup44bvxxxxxxxxxxpurpose44()==null?"":yrxxch511xhhxxhxxxxxoptions.getP5xxup44bvxxxxxxxxxxpurpose44().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 45:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getP9xxuv45bvxxxxxxxxxxvalue45()==null?"":yrxxch511xhhxxhxxxxxoptions.getP9xxuv45bvxxxxxxxxxxvalue45().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getP7xxuo45bvxxxxxxxxxxoptions45()==null?"":yrxxch511xhhxxhxxxxxoptions.getP7xxuo45bvxxxxxxxxxxoptions45().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getP8xxup45bvxxxxxxxxxxpurpose45()==null?"":yrxxch511xhhxxhxxxxxoptions.getP8xxup45bvxxxxxxxxxxpurpose45().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 46:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getQ3xxuv46bvxxxxxxxxxxvalue46()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ3xxuv46bvxxxxxxxxxxvalue46().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getQ1xxuo46bvxxxxxxxxxxoptions46()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ1xxuo46bvxxxxxxxxxxoptions46().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getQ2xxup46bvxxxxxxxxxxpurpose46()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ2xxup46bvxxxxxxxxxxpurpose46().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 47:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getQ6xxuv47bvxxxxxxxxxxvalue47()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ6xxuv47bvxxxxxxxxxxvalue47().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getQ4xxuo47bvxxxxxxxxxxoptions47()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ4xxuo47bvxxxxxxxxxxoptions47().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getQ5xxup47bvxxxxxxxxxxpurpose47()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ5xxup47bvxxxxxxxxxxpurpose47().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 48:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getQ9xxuv48bvxxxxxxxxxxvalue48()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ9xxuv48bvxxxxxxxxxxvalue48().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getQ7xxuo48bvxxxxxxxxxxoptions48()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ7xxuo48bvxxxxxxxxxxoptions48().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getQ8xxup48bvxxxxxxxxxxpurpose48()==null?"":yrxxch511xhhxxhxxxxxoptions.getQ8xxup48bvxxxxxxxxxxpurpose48().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 49:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getR3xxuv49bvxxxxxxxxxxvalue49()==null?"":yrxxch511xhhxxhxxxxxoptions.getR3xxuv49bvxxxxxxxxxxvalue49().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getR1xxuo49bvxxxxxxxxxxoptions49()==null?"":yrxxch511xhhxxhxxxxxoptions.getR1xxuo49bvxxxxxxxxxxoptions49().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getR2xxup49bvxxxxxxxxxxpurpose49()==null?"":yrxxch511xhhxxhxxxxxoptions.getR2xxup49bvxxxxxxxxxxpurpose49().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 50:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getR6xxuv50bvxxxxxxxxxxvalue50()==null?"":yrxxch511xhhxxhxxxxxoptions.getR6xxuv50bvxxxxxxxxxxvalue50().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getR4xxuo50bvxxxxxxxxxxoptions50()==null?"":yrxxch511xhhxxhxxxxxoptions.getR4xxuo50bvxxxxxxxxxxoptions50().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getR5xxup50bvxxxxxxxxxxpurpose50()==null?"":yrxxch511xhhxxhxxxxxoptions.getR5xxup50bvxxxxxxxxxxpurpose50().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 51:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getR9xxuv51bvxxxxxxxxxxvalue51()==null?"":yrxxch511xhhxxhxxxxxoptions.getR9xxuv51bvxxxxxxxxxxvalue51().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getR7xxuo51bvxxxxxxxxxxoptions51()==null?"":yrxxch511xhhxxhxxxxxoptions.getR7xxuo51bvxxxxxxxxxxoptions51().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getR8xxup51bvxxxxxxxxxxpurpose51()==null?"":yrxxch511xhhxxhxxxxxoptions.getR8xxup51bvxxxxxxxxxxpurpose51().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 52:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getS3xxuv52bvxxxxxxxxxxvalue52()==null?"":yrxxch511xhhxxhxxxxxoptions.getS3xxuv52bvxxxxxxxxxxvalue52().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getS1xxuo52bvxxxxxxxxxxoptions52()==null?"":yrxxch511xhhxxhxxxxxoptions.getS1xxuo52bvxxxxxxxxxxoptions52().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getS2xxup52bvxxxxxxxxxxpurpose52()==null?"":yrxxch511xhhxxhxxxxxoptions.getS2xxup52bvxxxxxxxxxxpurpose52().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 53:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getS6xxuv53bvxxxxxxxxxxvalue53()==null?"":yrxxch511xhhxxhxxxxxoptions.getS6xxuv53bvxxxxxxxxxxvalue53().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getS4xxuo53bvxxxxxxxxxxoptions53()==null?"":yrxxch511xhhxxhxxxxxoptions.getS4xxuo53bvxxxxxxxxxxoptions53().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getS5xxup53bvxxxxxxxxxxpurpose53()==null?"":yrxxch511xhhxxhxxxxxoptions.getS5xxup53bvxxxxxxxxxxpurpose53().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 54:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getS9xxuv54bvxxxxxxxxxxvalue54()==null?"":yrxxch511xhhxxhxxxxxoptions.getS9xxuv54bvxxxxxxxxxxvalue54().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getS7xxuo54bvxxxxxxxxxxoptions54()==null?"":yrxxch511xhhxxhxxxxxoptions.getS7xxuo54bvxxxxxxxxxxoptions54().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getS8xxup54bvxxxxxxxxxxpurpose54()==null?"":yrxxch511xhhxxhxxxxxoptions.getS8xxup54bvxxxxxxxxxxpurpose54().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 55:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getT3xxuv55bvxxxxxxxxxxvalue55()==null?"":yrxxch511xhhxxhxxxxxoptions.getT3xxuv55bvxxxxxxxxxxvalue55().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getT1xxuo55bvxxxxxxxxxxoptions55()==null?"":yrxxch511xhhxxhxxxxxoptions.getT1xxuo55bvxxxxxxxxxxoptions55().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getT2xxup55bvxxxxxxxxxxpurpose55()==null?"":yrxxch511xhhxxhxxxxxoptions.getT2xxup55bvxxxxxxxxxxpurpose55().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;

                case 56:
                 optionFilter=yrxxch511xhhxxhxxxxxoptions.getT6xxuv56bvxxxxxxxxxxvalue56()==null?"":yrxxch511xhhxxhxxxxxoptions.getT6xxuv56bvxxxxxxxxxxvalue56().replaceAll(" +", " ");
                 optionOptions=yrxxch511xhhxxhxxxxxoptions.getT4xxuo56bvxxxxxxxxxxoptions56()==null?"":yrxxch511xhhxxhxxxxxoptions.getT4xxuo56bvxxxxxxxxxxoptions56().replaceAll(" +", " ");
                 optionPurpose=yrxxch511xhhxxhxxxxxoptions.getT5xxup56bvxxxxxxxxxxpurpose56()==null?"":yrxxch511xhhxxhxxxxxoptions.getT5xxup56bvxxxxxxxxxxpurpose56().replaceAll(" +", " ");
                 setOptionsKeyFields();//to reduce method size

                 break;
               }
              }

            }
            //   if clobdata then add the current instance key value if non 3R to prefill 
            
             if( entityCode.equals("1m") && optionNo ==49 ){
              if(yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance() !=null && yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey() !=null){
               fieldKeyList.put(yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey(),yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey());
              }
             }
             if(entityCode.equals("1n") && optionNo ==49 ){
              if(yxxxuq1n1xwwqqqxxxxxblobdataHome.getInstance() !=null && yxxxuq1n1xwwqqqxxxxxblobdataHome.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey() !=null){
               fieldKeyList.put(yxxxuq1n1xwwqqqxxxxxblobdataHome.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey(),yxxxuq1n1xwwqqqxxxxxblobdataHome.getInstance().getA1xxuxxxbv49xxxxxxxxfromkey());
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

	public List<String> gethhxxhxxxxxoptionsKeyList() {
                 // xxxxxxxxxa0xxuobxbxxxxxxxxxxxsid  java.lang.String a0xxukcxbvxxxxxxxxxxrow
    
		       String enteredValue = "";
                        //order case insensitive
			return getEntityManager().createQuery("select cc.a0xxukcxbvxxxxxxxxxxrow from Yrxxch511xhhxxhxxxxxoptions cc where cc.a0xxukcxbvxxxxxxxxxxrow >=:keyOfEntity   AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')  order by lower(cc.a0xxukcxbvxxxxxxxxxxrow) ")
        				.setParameter("keyOfEntity", enteredValue).setParameter("owner2", owner2Code)
					.getResultList();
   


      }



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





      public void print() {  
           // reportname has 2 ch prefix to indicate type of reports and are stripped off later
           // 59,66= Avery label de= default dg=demographic me=metrics fi=financia sk=stock 
           // load messages from data base, now bundleName is ignored,it is hardcoded as "m"
           // jasperSoft need to pass resourcebundle and locale to subreport  via parameter
           // pass prefix based truefalse field selection values as show00nh and show00n as
           // report parameters
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
			parameters.put("Start", start);
			parameters.put("End", end);
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
                if (!reportNamePrefix.equals("fi")){
                 //following for parameter label not value true/false for non fi reports ie non Txn
		            parameters.put("show001h", "#{messages[Sid]}");
		            parameters.put("show002h", "#{messages[Row]}");
		            parameters.put("show003h", "#{messages[Options01]}");
		            parameters.put("show004h", "#{messages[Purpose01]}");
		            parameters.put("show005h", "#{messages[Value01]}");
		            parameters.put("show006h", "#{messages[Options02]}");
		            parameters.put("show007h", "#{messages[Purpose02]}");
		            parameters.put("show008h", "#{messages[Value02]}");
		            parameters.put("show009h", "#{messages[Options03]}");
		            parameters.put("show010h", "#{messages[Purpose03]}");
		            parameters.put("show011h", "#{messages[Value03]}");
		            parameters.put("show012h", "#{messages[Options04]}");
		            parameters.put("show013h", "#{messages[Purpose04]}");
		            parameters.put("show014h", "#{messages[Value04]}");
		            parameters.put("show015h", "#{messages[Options05]}");
		            parameters.put("show016h", "#{messages[Purpose05]}");
		            parameters.put("show017h", "#{messages[Value05]}");
		            parameters.put("show018h", "#{messages[Options06]}");
		            parameters.put("show019h", "#{messages[Purpose06]}");
		            parameters.put("show020h", "#{messages[Value06]}");
		            parameters.put("show021h", "#{messages[Options07]}");
		            parameters.put("show022h", "#{messages[Purpose07]}");
		            parameters.put("show023h", "#{messages[Value07]}");
		            parameters.put("show024h", "#{messages[Options08]}");
		            parameters.put("show025h", "#{messages[Purpose08]}");
		            parameters.put("show026h", "#{messages[Value08]}");
		            parameters.put("show027h", "#{messages[Options09]}");
		            parameters.put("show028h", "#{messages[Purpose09]}");
		            parameters.put("show029h", "#{messages[Value09]}");
		            parameters.put("show030h", "#{messages[Options10]}");
		            parameters.put("show031h", "#{messages[Purpose10]}");
		            parameters.put("show032h", "#{messages[Value10]}");
		            parameters.put("show033h", "#{messages[Options11]}");
		            parameters.put("show034h", "#{messages[Purpose11]}");
		            parameters.put("show035h", "#{messages[Value11]}");
		            parameters.put("show036h", "#{messages[Options12]}");
		            parameters.put("show037h", "#{messages[Purpose12]}");
		            parameters.put("show038h", "#{messages[Value12]}");
		            parameters.put("show039h", "#{messages[Options13]}");
		            parameters.put("show040h", "#{messages[Purpose13]}");
		            parameters.put("show041h", "#{messages[Value13]}");
		            parameters.put("show042h", "#{messages[Options14]}");
		            parameters.put("show043h", "#{messages[Purpose14]}");
		            parameters.put("show044h", "#{messages[Value14]}");
		            parameters.put("show045h", "#{messages[Options15]}");
		            parameters.put("show046h", "#{messages[Purpose15]}");
		            parameters.put("show047h", "#{messages[Value15]}");
		            parameters.put("show048h", "#{messages[Options16]}");
		            parameters.put("show049h", "#{messages[Purpose16]}");
		            parameters.put("show050h", "#{messages[Value16]}");
		            parameters.put("show051h", "#{messages[Options17]}");
		            parameters.put("show052h", "#{messages[Purpose17]}");
		            parameters.put("show053h", "#{messages[Value17]}");
		            parameters.put("show054h", "#{messages[Options18]}");
		            parameters.put("show055h", "#{messages[Purpose18]}");
		            parameters.put("show056h", "#{messages[Value18]}");
		            parameters.put("show057h", "#{messages[Options19]}");
		            parameters.put("show058h", "#{messages[Purpose19]}");
		            parameters.put("show059h", "#{messages[Value19]}");
		            parameters.put("show060h", "#{messages[Options20]}");
		            parameters.put("show061h", "#{messages[Purpose20]}");
		            parameters.put("show062h", "#{messages[Value20]}");
		            parameters.put("show063h", "#{messages[Options21]}");
		            parameters.put("show064h", "#{messages[Purpose21]}");
		            parameters.put("show065h", "#{messages[Value21]}");
		            parameters.put("show066h", "#{messages[Options22]}");
		            parameters.put("show067h", "#{messages[Purpose22]}");
		            parameters.put("show068h", "#{messages[Value22]}");
		            parameters.put("show069h", "#{messages[Options23]}");
		            parameters.put("show070h", "#{messages[Purpose23]}");
		            parameters.put("show071h", "#{messages[Value23]}");
		            parameters.put("show072h", "#{messages[Options24]}");
		            parameters.put("show073h", "#{messages[Purpose24]}");
		            parameters.put("show074h", "#{messages[Value24]}");
		            parameters.put("show075h", "#{messages[Options25]}");
		            parameters.put("show076h", "#{messages[Purpose25]}");
		            parameters.put("show077h", "#{messages[Value25]}");
		            parameters.put("show078h", "#{messages[Options26]}");
		            parameters.put("show079h", "#{messages[Purpose26]}");
		            parameters.put("show080h", "#{messages[Value26]}");
		            parameters.put("show081h", "#{messages[Options27]}");
		            parameters.put("show082h", "#{messages[Purpose27]}");
		            parameters.put("show083h", "#{messages[Value27]}");
		            parameters.put("show084h", "#{messages[Options28]}");
		            parameters.put("show085h", "#{messages[Purpose28]}");
		            parameters.put("show086h", "#{messages[Value28]}");
		            parameters.put("show087h", "#{messages[Options29]}");
		            parameters.put("show088h", "#{messages[Purpose29]}");
		            parameters.put("show089h", "#{messages[Value29]}");
		            parameters.put("show090h", "#{messages[Options30]}");
		            parameters.put("show091h", "#{messages[Purpose30]}");
		            parameters.put("show092h", "#{messages[Value30]}");
		            parameters.put("show093h", "#{messages[Options31]}");
		            parameters.put("show094h", "#{messages[Purpose31]}");
		            parameters.put("show095h", "#{messages[Value31]}");
		            parameters.put("show096h", "#{messages[Options32]}");
		            parameters.put("show097h", "#{messages[Purpose32]}");
		            parameters.put("show098h", "#{messages[Value32]}");
		            parameters.put("show099h", "#{messages[Options33]}");
		            parameters.put("show100h", "#{messages[Purpose33]}");
		            parameters.put("show101h", "#{messages[Value33]}");
		            parameters.put("show102h", "#{messages[Options34]}");
		            parameters.put("show103h", "#{messages[Purpose34]}");
		            parameters.put("show104h", "#{messages[Value34]}");
		            parameters.put("show105h", "#{messages[Options35]}");
		            parameters.put("show106h", "#{messages[Purpose35]}");
		            parameters.put("show107h", "#{messages[Value35]}");
		            parameters.put("show108h", "#{messages[Options36]}");
		            parameters.put("show109h", "#{messages[Purpose36]}");
		            parameters.put("show110h", "#{messages[Value36]}");
		            parameters.put("show111h", "#{messages[Options37]}");
		            parameters.put("show112h", "#{messages[Purpose37]}");
		            parameters.put("show113h", "#{messages[Value37]}");
		            parameters.put("show114h", "#{messages[Options38]}");
		            parameters.put("show115h", "#{messages[Purpose38]}");
		            parameters.put("show116h", "#{messages[Value38]}");
		            parameters.put("show117h", "#{messages[Options39]}");
		            parameters.put("show118h", "#{messages[Purpose39]}");
		            parameters.put("show119h", "#{messages[Value39]}");
		            parameters.put("show120h", "#{messages[Options40]}");
		            parameters.put("show121h", "#{messages[Purpose40]}");
		            parameters.put("show122h", "#{messages[Value40]}");
		            parameters.put("show123h", "#{messages[Options41]}");
		            parameters.put("show124h", "#{messages[Purpose41]}");
		            parameters.put("show125h", "#{messages[Value41]}");
		            parameters.put("show126h", "#{messages[Options42]}");
		            parameters.put("show127h", "#{messages[Purpose42]}");
		            parameters.put("show128h", "#{messages[Value42]}");
		            parameters.put("show129h", "#{messages[Options43]}");
		            parameters.put("show130h", "#{messages[Purpose43]}");
		            parameters.put("show131h", "#{messages[Value43]}");
		            parameters.put("show132h", "#{messages[Options44]}");
		            parameters.put("show133h", "#{messages[Purpose44]}");
		            parameters.put("show134h", "#{messages[Value44]}");
		            parameters.put("show135h", "#{messages[Options45]}");
		            parameters.put("show136h", "#{messages[Purpose45]}");
		            parameters.put("show137h", "#{messages[Value45]}");
		            parameters.put("show138h", "#{messages[Options46]}");
		            parameters.put("show139h", "#{messages[Purpose46]}");
		            parameters.put("show140h", "#{messages[Value46]}");
		            parameters.put("show141h", "#{messages[Options47]}");
		            parameters.put("show142h", "#{messages[Purpose47]}");
		            parameters.put("show143h", "#{messages[Value47]}");
		            parameters.put("show144h", "#{messages[Options48]}");
		            parameters.put("show145h", "#{messages[Purpose48]}");
		            parameters.put("show146h", "#{messages[Value48]}");
		            parameters.put("show147h", "#{messages[Options49]}");
		            parameters.put("show148h", "#{messages[Purpose49]}");
		            parameters.put("show149h", "#{messages[Value49]}");
		            parameters.put("show150h", "#{messages[Options50]}");
		            parameters.put("show151h", "#{messages[Purpose50]}");
		            parameters.put("show152h", "#{messages[Value50]}");
		            parameters.put("show153h", "#{messages[Options51]}");
		            parameters.put("show154h", "#{messages[Purpose51]}");
		            parameters.put("show155h", "#{messages[Value51]}");
		            parameters.put("show156h", "#{messages[Options52]}");
		            parameters.put("show157h", "#{messages[Purpose52]}");
		            parameters.put("show158h", "#{messages[Value52]}");
		            parameters.put("show159h", "#{messages[Options53]}");
		            parameters.put("show160h", "#{messages[Purpose53]}");
		            parameters.put("show161h", "#{messages[Value53]}");
		            parameters.put("show162h", "#{messages[Options54]}");
		            parameters.put("show163h", "#{messages[Purpose54]}");
		            parameters.put("show164h", "#{messages[Value54]}");
		            parameters.put("show165h", "#{messages[Options55]}");
		            parameters.put("show166h", "#{messages[Purpose55]}");
		            parameters.put("show167h", "#{messages[Value55]}");
		            parameters.put("show168h", "#{messages[Options56]}");
		            parameters.put("show169h", "#{messages[Purpose56]}");
		            parameters.put("show170h", "#{messages[Value56]}");
		            parameters.put("show171h", "#{messages[Options57]}");
		            parameters.put("show172h", "#{messages[Purpose57]}");
		            parameters.put("show173h", "#{messages[Value57]}");
		            parameters.put("show174h", "#{messages[Options58]}");
		            parameters.put("show175h", "#{messages[Purpose58]}");
		            parameters.put("show176h", "#{messages[Value58]}");
		            parameters.put("show177h", "#{messages[Options59]}");
		            parameters.put("show178h", "#{messages[Purpose59]}");
		            parameters.put("show179h", "#{messages[Value59]}");
		            parameters.put("show180h", "#{messages[Options60]}");
		            parameters.put("show181h", "#{messages[Purpose60]}");
		            parameters.put("show182h", "#{messages[Value60]}");
		            parameters.put("show183h", "#{messages[Options61]}");
		            parameters.put("show184h", "#{messages[Purpose61]}");
		            parameters.put("show185h", "#{messages[Value61]}");
		            parameters.put("show186h", "#{messages[Notes]}");
		            parameters.put("show187h", "#{messages[Statusfl]}");
		            parameters.put("show188h", "#{messages[Statusfldt]}");
		            parameters.put("show189h", "#{messages[Owner]}");
		            parameters.put("show190h", "#{messages[Owner2]}");
                 // done with labels, now load corresponding values from truefalses db or if new create 
                 loadTruefalses(); //sets bcontinue
                 // if found bcontinue is true and  report parameters shownnn are already set from db
                 // if not found then create db entry and then load default values for report prefix type
                 // and then persist truefalse
                 // and call loadTruefalses() again 
                 if (!bcontinue){//not found
                    yxxxch5a1xhhxxhxxxxxtruefalseHome.clearInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse=yxxxch5a1xhhxxhxxxxxtruefalseHome.getInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA0xxukrdbvxxxxxxxxxxtablename("options");
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxuxxxbvxxxxxxxxxxqualifier(reportNamePrefix);
                  //default
                 if(reportNamePrefix.equals("de")){ 
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow057(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow058(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow059(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow075(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow076(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow077(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow132(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow133(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow134(false);
                   //yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false);//hide sid 
                 }
                 //demographic
                 if (reportNamePrefix.equals("dg")){
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow057(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow058(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow059(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow075(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow076(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow077(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow132(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow133(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow134(false);
                  // yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false); table never had sid
                  // by default showxxx are true but .ftl gen time for "me" it will put false if not type decimal
                  // but at report side it will always include some key values
                 }
                 if (reportNamePrefix.equals("me")){
                 // show001 etc refers to decimal items not the original seq, start false from show003
                 //show002 is qty
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow002(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow003(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow004(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow005(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow006(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow007(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow008(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow009(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow010(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow011(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow012(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow013(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow014(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow015(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow016(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow017(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow018(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow019(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow020(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow021(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow022(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow023(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow024(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow025(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow026(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow027(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow028(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow029(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow030(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow031(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow032(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow033(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow034(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow035(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow036(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow037(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow038(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow039(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow040(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow041(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow042(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow043(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow044(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow045(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow046(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow047(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow048(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow049(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow050(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow051(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow052(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow053(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow054(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow055(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow056(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow057(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow058(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow059(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow060(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow061(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow062(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow063(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow064(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow065(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow066(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow067(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow068(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow069(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow070(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow071(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow072(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow073(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow074(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow075(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow076(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow077(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow078(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow079(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow080(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow081(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow082(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow083(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow084(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow085(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow086(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow087(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow088(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow089(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow090(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow091(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow092(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow093(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow094(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow095(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow096(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow097(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow098(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow099(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow100(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow101(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow102(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow103(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow104(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow105(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow106(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow107(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow108(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow109(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow110(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow111(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow112(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow113(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow114(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow115(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow116(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow117(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow118(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow119(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow120(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow121(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow122(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow123(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow124(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow125(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow126(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow127(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow128(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow129(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow130(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow131(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow132(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow133(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow134(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow135(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow136(false);
                 }
                 //any other prefix like adhock etc
                 if (reportNamePrefix.equals("a1") || reportNamePrefix.equals("a2")){
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow057(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow058(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow059(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow075(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow076(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow077(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow132(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow133(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow134(false);
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
                  FacesMessage.SEVERITY_WARN,bundle.getString("options")+" "+bundle.getString("report")+" "+bundle.getString("generate")+" "+bundle.getString("failed")+" "+e.getMessage(),""));
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
                Yxxxch5a1xhhxxhxxxxxtruefalse truefalses =null;
                bcontinue=true;
                try {
                 List<Yxxxch5a1xhhxxhxxxxxtruefalse> results =  getEntityManager()
                  .createQuery(
                   "select cc from Yxxxch5a1xhhxxhxxxxxtruefalse cc where   cc.a0xxukrdbvxxxxxxxxxxtablename=:tableName  and cc.a1xxuxxxbvxxxxxxxxxxqualifier=:qualifier and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
                      .setParameter("tableName", "options")
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
                 //report fields starting with sid we skip it below and send show002......
                 //columns 001 has key ... no sid . 2 <-1, 3 <-2
			    parameters.put("show002", true);
			    parameters.put("show003", true);
			    parameters.put("show004", true);
			    parameters.put("show005", true);
			    parameters.put("show006", true);
			    parameters.put("show007", true);
			    parameters.put("show008", true);
			    parameters.put("show009", true);
			    parameters.put("show010", true);
			    parameters.put("show011", true);
			    parameters.put("show012", true);
			    parameters.put("show013", true);
			    parameters.put("show014", true);
			    parameters.put("show015", true);
			    parameters.put("show016", true);
			    parameters.put("show017", true);
			    parameters.put("show018", true);
			    parameters.put("show019", true);
			    parameters.put("show020", true);
			    parameters.put("show021", true);
			    parameters.put("show022", true);
			    parameters.put("show023", true);
			    parameters.put("show024", true);
			    parameters.put("show025", true);
			    parameters.put("show026", true);
			    parameters.put("show027", true);
			    parameters.put("show028", true);
			    parameters.put("show029", true);
			    parameters.put("show030", true);
			    parameters.put("show031", true);
			    parameters.put("show032", true);
			    parameters.put("show033", true);
			    parameters.put("show034", true);
			    parameters.put("show035", true);
			    parameters.put("show036", true);
			    parameters.put("show037", true);
			    parameters.put("show038", true);
			    parameters.put("show039", true);
			    parameters.put("show040", true);
			    parameters.put("show041", true);
			    parameters.put("show042", true);
			    parameters.put("show043", true);
			    parameters.put("show044", true);
			    parameters.put("show045", true);
			    parameters.put("show046", true);
			    parameters.put("show047", true);
			    parameters.put("show048", true);
			    parameters.put("show049", true);
			    parameters.put("show050", true);
			    parameters.put("show051", true);
			    parameters.put("show052", true);
			    parameters.put("show053", true);
			    parameters.put("show054", true);
			    parameters.put("show055", true);
			    parameters.put("show056", true);
			    parameters.put("show057", true);
			    parameters.put("show058", true);
			    parameters.put("show059", true);
			    parameters.put("show060", true);
			    parameters.put("show061", true);
			    parameters.put("show062", true);
			    parameters.put("show063", true);
			    parameters.put("show064", true);
			    parameters.put("show065", true);
			    parameters.put("show066", true);
			    parameters.put("show067", true);
			    parameters.put("show068", true);
			    parameters.put("show069", true);
			    parameters.put("show070", true);
			    parameters.put("show071", true);
			    parameters.put("show072", true);
			    parameters.put("show073", true);
			    parameters.put("show074", true);
			    parameters.put("show075", true);
			    parameters.put("show076", true);
			    parameters.put("show077", true);
			    parameters.put("show078", true);
			    parameters.put("show079", true);
			    parameters.put("show080", true);
			    parameters.put("show081", true);
			    parameters.put("show082", true);
			    parameters.put("show083", true);
			    parameters.put("show084", true);
			    parameters.put("show085", true);
			    parameters.put("show086", true);
			    parameters.put("show087", true);
			    parameters.put("show088", true);
			    parameters.put("show089", true);
			    parameters.put("show090", true);
			    parameters.put("show091", true);
			    parameters.put("show092", true);
			    parameters.put("show093", true);
			    parameters.put("show094", true);
			    parameters.put("show095", true);
			    parameters.put("show096", true);
			    parameters.put("show097", true);
			    parameters.put("show098", true);
			    parameters.put("show099", true);
			    parameters.put("show100", true);
			    parameters.put("show101", true);
			    parameters.put("show102", true);
			    parameters.put("show103", true);
			    parameters.put("show104", true);
			    parameters.put("show105", true);
			    parameters.put("show106", true);
			    parameters.put("show107", true);
			    parameters.put("show108", true);
			    parameters.put("show109", true);
			    parameters.put("show110", true);
			    parameters.put("show111", true);
			    parameters.put("show112", true);
			    parameters.put("show113", true);
			    parameters.put("show114", true);
			    parameters.put("show115", true);
			    parameters.put("show116", true);
			    parameters.put("show117", true);
			    parameters.put("show118", true);
			    parameters.put("show119", true);
			    parameters.put("show120", true);
			    parameters.put("show121", true);
			    parameters.put("show122", true);
			    parameters.put("show123", true);
			    parameters.put("show124", true);
			    parameters.put("show125", true);
			    parameters.put("show126", true);
			    parameters.put("show127", true);
			    parameters.put("show128", true);
			    parameters.put("show129", true);
			    parameters.put("show130", true);
			    parameters.put("show131", true);
			    parameters.put("show132", true);
			    parameters.put("show133", true);
			    parameters.put("show134", true);
			    parameters.put("show135", true);
			    parameters.put("show136", true);
			    parameters.put("show137", true);
			    parameters.put("show138", true);
			    parameters.put("show139", true);
			    parameters.put("show140", true);
			    parameters.put("show141", true);
			    parameters.put("show142", true);
			    parameters.put("show143", true);
			    parameters.put("show144", true);
			    parameters.put("show145", true);
			    parameters.put("show146", true);
			    parameters.put("show147", true);
			    parameters.put("show148", true);
			    parameters.put("show149", true);
			    parameters.put("show150", true);
			    parameters.put("show151", true);
			    parameters.put("show152", true);
			    parameters.put("show153", true);
			    parameters.put("show154", true);
			    parameters.put("show155", true);
			    parameters.put("show156", true);
			    parameters.put("show157", true);
			    parameters.put("show158", true);
			    parameters.put("show159", true);
			    parameters.put("show160", true);
			    parameters.put("show161", true);
			    parameters.put("show162", true);
			    parameters.put("show163", true);
			    parameters.put("show164", true);
			    parameters.put("show165", true);
			    parameters.put("show166", true);
			    parameters.put("show167", true);
			    parameters.put("show168", true);
			    parameters.put("show169", true);
			    parameters.put("show170", true);
			    parameters.put("show171", true);
			    parameters.put("show172", true);
			    parameters.put("show173", true);
			    parameters.put("show174", true);
			    parameters.put("show175", true);
			    parameters.put("show176", true);
			    parameters.put("show177", true);
			    parameters.put("show178", true);
			    parameters.put("show179", true);
			    parameters.put("show180", true);
			    parameters.put("show181", true);
			    parameters.put("show182", true);
			    parameters.put("show183", true);
			    parameters.put("show184", true);
			    parameters.put("show185", true);
			    parameters.put("show186", true);
			    parameters.put("show187", true);
			    parameters.put("show188", true);
			    parameters.put("show189", true);
			    parameters.put("show190", true);
			    parameters.put("show191", true);
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
* header("X-SMTPAPI",headers) for m:header name="X-SMTPAPI" value="#{yrxxch511xhhxxhxxxxxoptionsList.headers}" 
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
          //Yxxxch522xhhxxhxxxxxclient client=yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("01"); needs inject
          Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) entityManager
	.createQuery(
	"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
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
                       Yxxxch522xhhxxhxxxxxclient client05 =null;
                       try {
                              client05 =(Yxxxch522xhhxxhxxxxxclient) entityManager
		.createQuery(
		"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid asc")
		.setParameter("nKeyName","05")
		.setParameter("owner2", owner2Code)
		.getSingleResult();
                             if(client05 !=null){
                              fromAddress=client05.getD5xxuxxrbvxxxxxxxxxxrmailaddr();//show in o5 quick edit, need to match the sender info setup in mailrelay server
                              siteAddress05=client05.getD4xxhxxrbv24xxxxxxxximailaddr();//exmpl mail@raaspi.com 
                              host=client05.getZ8xxuxxxbvxxxxxxxxxxsmtpserver();//exmpl smtp.sendgrid.net
                              userName=client05.getZ9xxuxxxbvxxxxxxxxxxsmtpuser();//exmpl apikey if sendgrid. logic may need change to support other mailRelay server 
                              userName05=userName;
                              password=client05.getDbxxuzxdssxxxxxxxxxxapiclientsecret();//access token
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
                        host=client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("host")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser()!=null && !client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser().isEmpty()){
                        userName=client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser();
                       }else{
                         smtpError=true;
                         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                           FacesMessage.SEVERITY_INFO,bundle.getString("client") +" "+bundle.getString("smtp")+" "+bundle.getString("userName")+" "+bundle.getString("information") +" "+bundle.getString("missing"),""));
                       }
                       if(client.getZaxxuxxxssxxxxxxxxxxsmtppass()!=null && !client.getZaxxuxxxssxxxxxxxxxxsmtppass().isEmpty()){
                        password=client.getZaxxuxxxssxxxxxxxxxxsmtppass();
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
         Yxxxch522xhhxxhxxxxxclient client = null;
         if(owner2Code.contains(masterSiteCode) || owner2Code.contains("l++masterSiteCode")
           || !mailRelayOff ){
          //skip checking record 07, will not use gmail OAuth. It will use record 01 set up
         }else{
          // check Gmail smtp or not. Note client record below points to version 07 not 01
          //Yxxxch522xhhxxhxxxxxclient client=yxxxch522xhhxxhxxxxxclientList.getKeyToEntity("07");
         try {
          client =(Yxxxch522xhhxxhxxxxxclient) entityManager
					.createQuery(
							"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","07")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
          if(client !=null && client.getDaxxuzxdssxxxxxxxxxxapiclientid() !=null && !client.getDaxxuzxdssxxxxxxxxxxapiclientid().isEmpty()
              && client.getDbxxuzxdssxxxxxxxxxxapiclientsecret() !=null && !client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().isEmpty()){
           auth_mechanisms="XOAUTH2";//gmail smtp
           password=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret();//access token
           //check if token expired and refresh if needed
           calendar.getTime();
           calendare.setTime(client.getZfxxcztxlxxxxxxxxxxxstatusfldt());
           calendare.add(Calendar.MINUTE, 59);
           if(calendare.before(calendar)){
            password=r3RestClient.getAccessTokenGMail(client.getDaxxuzxdssxxxxxxxxxxapiclientid(),"refresh_token",owner2Code );
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
              FacesMessage.SEVERITY_INFO, bundle.getString("select cc from")+" "+bundle.getString("email")+" "+bundle.getString("address")+" "+bundle.getString("defaulting")+" "+bundle.getString("to")+" "+fromAddress+", "+bundle.getString("ensure")+" "+bundle.getString("it")+" "+bundle.getString("exists"),""));
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
         String subjectTemplate = "Text Message from 4.0.0 Mail - " + uuid;
         String version = "simple-mail";
         String subject = "Text Message from " + version + " Mail - " + uuid;
         String useTemplate="optionsMailingContent.fmt";
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
         subjectTemplate=bundle.getString("Transaction")+" "+bundle.getString("Receipt")+" "+bundle.getString("select cc from")+" "+owner2Code;
         //emailingContent for emailing and attaching report as receipt 
          toName="";// mailingAddress set by esend using mailTo, headers are empty todo allow multilingual
          toAddress=mailingAddress;
          useTemplate="optionseMailingContent.fmt";
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
                            new InputStreamAttachment("options.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("options.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("options.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("options.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
         if(cause.contains("334")){
          
          password=r3RestClient.getAccessTokenGMail(client.getDaxxuzxdssxxxxxxxxxxapiclientid(),"refresh_token",owner2Code );
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







	public Yxxxch575xwwqqhxxxxxuserprofl getUserProfile(String optionRow,String optionNo) {
                if (!identity.isLoggedIn()){
                 return null;
                } 

	     	String row = optionRow;
		String option = optionNo;
		List<Yxxxch575xwwqqhxxxxxuserprofl> results =  getEntityManager()
					.createQuery(
							"select cc from Yxxxch575xwwqqhxxxxxuserprofl cc where   cc.a0xxuobxbxxxxxxxxxxxsid=:logonid  and cc.b1xxuxxrbvxxxxxxxxxxrow=:row and cc.b1xxuxxrbvxxxxxxxxxxoption=:option and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
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
          //reportName="xxYrxxch511xhhxxhxxxxxoptions";  holds selected report
          this.print(); //generate report 
          if(customIdentity.getClientMsgLevel().contains("D")){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_INFO, bundle.getString("Report")+" "+reportName.substring(20)+" "+bundle.getString("to")+" "+bundle.getString("send")+" "+bundle.getString("by")+" "+bundle.getString("email"),""));
          } 

         mailingAddress=eMailTo;
         // 
                Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
		.createQuery(
		"select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
		.setParameter("nKeyName","01")
		.setParameter("owner2", owner2Code)
		.getSingleResult();

         setClientEMail("doNotReply@"+owner2Code+".com"); 
         //can come here as loggedIn or not loggedIn but eMail entered
         if(identity.isLoggedIn()){   
          //All loggedIn has customer record but may not have employee example self signedup 
          // if usertoEmployee has Email then use it , if empty then use client which should have some value
          if (jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee()==null || "".equals(jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee())){
           // try customer 
           setClientEMail(client.getD4xxhxxrbv24xxxxxxxximailaddr().trim());
          } 
          else{
           jxxxbh400xwwqqhxxxxxemployee=jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee();
           setClientEMail(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
           setUserFullName(jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname() +" "+jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname());
          }
          // if demo user no email saved in employee except in user
          Yxxxuh566xwwqqwxxxxxuser theUser = yxxxuh566xwwqqwxxxxxuserList.getKeyToEntity(customIdentity.getUsername());
          if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
           setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
          }

         }else{
          if (client.getD4xxhxxrbv24xxxxxxxximailaddr() == null || client.getD4xxhxxrbv24xxxxxxxximailaddr().isEmpty()){
           setClientEMail("doNotReply@"+owner2Code+".com"); 
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_WARN,bundle.getString("client")+" "+bundle.getString("email")+" "+bundle.getString("address")+" "+bundle.getString("is")+" "+bundle.getString("missing"),""));

          }else{
           setClientEMail(client.getD4xxhxxrbv24xxxxxxxximailaddr());
          }
         } 
         // from uses clientEMail,cc uses eMailingAddress1, to uses mailingAddress
         //renderer.render("/optionseMailingContent.xhtml");
         emailRender("/optionseMailingContent.xhtml","e");
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
			//renderer.render("/itemMailingContent.xhtml");
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
   public List<Yrxxch511xhhxxhxxxxxoptions> getResultList(){
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
