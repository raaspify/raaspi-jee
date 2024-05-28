



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

@Named("yxxxch522xhhxxhxxxxxclientList")
@ViewScoped
public class Yxxxch522xhhxxhxxxxxclientList implements Serializable
{
   private Logger log = Logger.getLogger(Yxxxch522xhhxxhxxxxxclient.class.getCanonicalName());
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

	@Inject
	Yxxxuq591xwwqqhxxxxxrate1fList yxxxuq591xwwqqhxxxxxrate1fList;
	@Inject
	Trexuq244xwwqqhxxxxxcuordersHome trexuq244xwwqqhxxxxxcuordersHome;
                 @Inject
                 Yxxxch522xhhxxhxxxxxclientHome  yxxxch522xhhxxhxxxxxclientHome;






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
                int listSize=gethhxxhxxxxxclientKeyList().size();
                start=  listSize==0 ? "0" : String.valueOf(gethhxxhxxxxxclientKeyList().get(0)) ;
                end=    listSize==0 ? "0" : String.valueOf(gethhxxhxxxxxclientKeyList().get(listSize-1));

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
     List<Yxxxch522xhhxxhxxxxxclient> sresults=null;
      private List <String> clientPayByList=new ArrayList<String>();
      private String clientPayBySelected="";// depends on the site



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

     private static final String EJBQL = "select yxxxch522xhhxxhxxxxxclient from Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient "  ;

     private static final String[] RESTRICTIONS = {
        "lower(yxxxch522xhhxxhxxxxxclient.a0xxukxxbvxxxxxxxxxxclientversion) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.a0xxukxxbvxxxxxxxxxxclientversion},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b1xxuisxlvxxxxxxxxxxserialnum) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b1xxuisxlvxxxxxxxxxxserialnum},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b2xxuzcxbvxxxxxxxxxxenterprisecompanyna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b2xxuzcxbvxxxxxxxxxxenterprisecompanyna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b3xxuxzsbvxxxxxxxxxxdescript) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b3xxuxzsbvxxxxxxxxxxdescript},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b4xxuxa1bvxxxxxxxxxxaddrl1) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b4xxuxa1bvxxxxxxxxxxaddrl1},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b5xxub2xbvxxxxxxxxxxaddrl2) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b5xxub2xbvxxxxxxxxxxaddrl2},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b6xxub3xevxxxxxxxxxxaddrl3) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b6xxub3xevxxxxxxxxxxaddrl3},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b7xxhxacbv11xxxxxxxxcity) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b7xxhxacbv11xxxxxxxxcity},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b8xxhbpxbv12xxxxxxxxprovnstate) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b8xxhbpxbv12xxxxxxxxprovnstate},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.b9xxhboxev13xxxxxxxxcountryname) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.b9xxhboxev13xxxxxxxxcountryname},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.c1xxhxazbv14xxxxxxxxpzcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.c1xxhxazbv14xxxxxxxxpzcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.c6xxhxxxbv27xxxxxxxxphoneo) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.c6xxhxxxbv27xxxxxxxxphoneo},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.c7xxhxxxbv27xxxxxxxxphoneh) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.c7xxhxxxbv27xxxxxxxxphoneh},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.c8xxhxxrbv27xxxxxxxxphonec) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.c8xxhxxrbv27xxxxxxxxphonec},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.c9xxhxxrbv27xxxxxxxxphonex) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.c9xxhxxrbv27xxxxxxxxphonex},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d1xxhxxrbv19xxxxxxxxlanaddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d1xxhxxrbv19xxxxxxxxlanaddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d2xxhxxrbv25xxxxxxxxwanaddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d2xxhxxrbv25xxxxxxxxwanaddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d3xxhxxrbv44xxxxxxxxlmailaddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d3xxhxxrbv44xxxxxxxxlmailaddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d4xxhxxrbv24xxxxxxxximailaddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d4xxhxxrbv24xxxxxxxximailaddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d5xxuxxrbvxxxxxxxxxxrmailaddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d5xxuxxrbvxxxxxxxxxxrmailaddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d6xxuxxrbvxxxxxxxxxxintaddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d6xxuxxrbvxxxxxxxxxxintaddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d7xxuxxrbvxxxxxxxxxxinraddr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d7xxuxxrbvxxxxxxxxxxinraddr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d8xxuzxdbvxxxxxxxxxxenterprisecompcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d8xxuzxdbvxxxxxxxxxxenterprisecompcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.d9xxuxxxbvxxxxxxxxxxenterprisecompsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.d9xxuxxxbvxxxxxxxxxxenterprisecompsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.daxxuzxdssxxxxxxxxxxapiclientid) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.daxxuzxdssxxxxxxxxxxapiclientid},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.dbxxuzxdssxxxxxxxxxxapiclientsecret) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.dbxxuzxdssxxxxxxxxxxapiclientsecret},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.e2xxuxxxbvxxxxxxxxxxbarcsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.e2xxuxxxbvxxxxxxxxxxbarcsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.f1xxuxxxbvxxxxxxxxxxposkipp) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.f1xxuxxxbvxxxxxxxxxxposkipp},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.f3xxuxxxbvxxxxxxxxxxjobskip) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.f3xxuxxxbvxxxxxxxxxxjobskip},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.f6xxuxxxlvxxxxxxxxxxlicensetype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.f6xxuxxxlvxxxxxxxxxxlicensetype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g1xxuxxxbvxxxxxxxxxxproddesc) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g1xxuxxxbvxxxxxxxxxxproddesc},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g2xxuxpclvxxxxxxxxxxprodcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g2xxuxpclvxxxxxxxxxxprodcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g3xxuxxxbvxxnxxxxxxxnjob) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g3xxuxxxbvxxnxxxxxxxnjob},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g4xxuxxxssxxnxxxxxxxnmateria) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g4xxuxxxssxxnxxxxxxxnmateria},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g5xxuxxxbvxxxxxxxxxxnactivity) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g5xxuxxxbvxxxxxxxxxxnactivity},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g6xxuxxxbvxxxxxxxxxxnbutt) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g6xxuxxxbvxxxxxxxxxxnbutt},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g7xxuxrrbvxxxxxxxxxxncustome) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g7xxuxrrbvxxxxxxxxxxncustome},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g8xxuxrcbvxxxxxxxxxxncontact) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g8xxuxrcbvxxxxxxxxxxncontact},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.g9xxuxvvbvxxnxxxxxxxnvendor) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.g9xxuxvvbvxxnxxxxxxxnvendor},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h1xxuxttbvxxxxxxxxxxnemployee) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h1xxuxttbvxxxxxxxxxxnemployee},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h2xxuxxxbvxxxxxxxxxxnschedule) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h2xxuxxxbvxxxxxxxxxxnschedule},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h3xxuxxxbvxxxxxxxxxxnreject) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h3xxuxxxbvxxxxxxxxxxnreject},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h4xxuxxxbvxxxxxxxxxxnreturn) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h4xxuxxxbvxxxxxxxxxxnreturn},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h5xxuxxxivxxxxxxxxxxncode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h5xxuxxxivxxxxxxxxxxncode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h6xxuxxxbvxxxxxxxxxxmanufid) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h6xxuxxxbvxxxxxxxxxxmanufid},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h7xxuxxxbvxxxxxxxxxxbartype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h7xxuxxxbvxxxxxxxxxxbartype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h8xxuxxxbvxxxxxxxxxxcadtype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h8xxuxxxbvxxxxxxxxxxcadtype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.h9xxuxxxbvxxxxxxxxxxcartype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.h9xxuxxxbvxxxxxxxxxxcartype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.i1xxuxxxbvxxxxxxxxxxshitype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.i1xxuxxxbvxxxxxxxxxxshitype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.i2xxuxxxbvxxxxxxxxxxreptype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.i2xxuxxxbvxxxxxxxxxxreptype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.i3xxuxxxbvxxxxxxxxxxloctype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.i3xxuxxxbvxxxxxxxxxxloctype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j2xxuxxxbvxxxxxxxxxxcountrycode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j2xxuxxxbvxxxxxxxxxxcountrycode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j3xxuxxxbvxxxxxxxxxxnaltseri) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j3xxuxxxbvxxxxxxxxxxnaltseri},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j4xxuxxxbvxxxxxxxxxxscrcolor) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j4xxuxxxbvxxxxxxxxxxscrcolor},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j5xxuxxxbvxxxxxxxxxxhilcolor) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j5xxuxxxbvxxxxxxxxxxhilcolor},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j6xxuxxxbvxxxxxxxxxxtextcolor) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j6xxuxxxbvxxxxxxxxxxtextcolor},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j7xxuxxxbvxxxxxxxxxxbaccolor) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j7xxuxxxbvxxxxxxxxxxbaccolor},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j8xxuxxxbvxxxxxxxxxxdatetype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j8xxuxxxbvxxxxxxxxxxdatetype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.j9xxuxxxbvxxxxxxxxxxcurrsymb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.j9xxuxxxbvxxxxxxxxxxcurrsymb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k1xxuxxxbvxxxxxxxxxxcurrcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k1xxuxxxbvxxxxxxxxxxcurrcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k3xxuxxxbvxxxxxxxxxxbarprint) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k3xxuxxxbvxxxxxxxxxxbarprint},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k4xxuxxxbvxxxxxxxxxxcarprint) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k4xxuxxxbvxxxxxxxxxxcarprint},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k5xxuxxxbvxxxxxxxxxxcadprint) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k5xxuxxxbvxxxxxxxxxxcadprint},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k6xxuxxxbvxxxxxxxxxxlocprint) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k6xxuxxxbvxxxxxxxxxxlocprint},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k7xxuxxxbvxxxxxxxxxxshiprint) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k7xxuxxxbvxxxxxxxxxxshiprint},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k8xxuxxxbvxxxxxxxxxxrepprint) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k8xxuxxxbvxxxxxxxxxxrepprint},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.k9xxuxxxbvxxxxxxxxxxbarprty) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.k9xxuxxxbvxxxxxxxxxxbarprty},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l1xxuxxxbvxxxxxxxxxxrepprty) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l1xxuxxxbvxxxxxxxxxxrepprty},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l2xxuxxxbvxxxxxxxxxxcarprty) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l2xxuxxxbvxxxxxxxxxxcarprty},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l3xxuxxxbvxxxxxxxxxxcadprty) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l3xxuxxxbvxxxxxxxxxxcadprty},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l4xxuxxxbvxxxxxxxxxxshiprty) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l4xxuxxxbvxxxxxxxxxxshiprty},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l5xxuxxxbvxxxxxxxxxxlocprty) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l5xxuxxxbvxxxxxxxxxxlocprty},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l8xxuxxxbvxxxxxxxxxxcarcsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l8xxuxxxbvxxxxxxxxxxcarcsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.l9xxuxxxbvxxxxxxxxxxcadcsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.l9xxuxxxbvxxxxxxxxxxcadcsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m1xxuxxxbvxxxxxxxxxxshicsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m1xxuxxxbvxxxxxxxxxxshicsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m2xxuxxxbvxxxxxxxxxxrepcsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m2xxuxxxbvxxxxxxxxxxrepcsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m3xxuxxxbvxxxxxxxxxxloccsize) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m3xxuxxxbvxxxxxxxxxxloccsize},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m4xxuxxxbvxxxxxxxxxxcs) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m4xxuxxxbvxxxxxxxxxxcs},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m5xxuxxxbvxxxxxxxxxxnconftyp) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m5xxuxxxbvxxxxxxxxxxnconftyp},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m6xxuxxxbvxxxxxxxxxxnlocatio) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m6xxuxxxbvxxxxxxxxxxnlocatio},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m7xxuoxxbvxxxxxxxxxxndivcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m7xxuoxxbvxxxxxxxxxxndivcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m8xxuexxbvxxxxxxxxxxndepcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m8xxuexxbvxxxxxxxxxxndepcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.m9xxuxxxbvxxxxxxxxxxnaddcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.m9xxuxxxbvxxxxxxxxxxnaddcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o1xxuxxxbvxxxxxxxxxxnfloor) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o1xxuxxxbvxxxxxxxxxxnfloor},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o2xxuxxxbvxxxxxxxxxxnroom) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o2xxuxxxbvxxxxxxxxxxnroom},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o3xxuxxxbvxxxxxxxxxxnrack) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o3xxuxxxbvxxxxxxxxxxnrack},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o4xxuxxxbvxxxxxxxxxxmenutype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o4xxuxxxbvxxxxxxxxxxmenutype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o5xxuxxxbvxxxxxxxxxxpadtype) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o5xxuxxxbvxxxxxxxxxxpadtype},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o6xxuxxxbvxxxxxxxxxxnrate1ta) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o6xxuxxxbvxxxxxxxxxxnrate1ta},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o7xxuxxxbvxxxxxxxxxxnrate2ta) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o7xxuxxxbvxxxxxxxxxxnrate2ta},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.o8xxuxxxbvxxxxxxxxxxdefconft) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.o8xxuxxxbvxxxxxxxxxxdefconft},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.p8xxuxxxbvxxxxxxxxxxncorder) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.p8xxuxxxbvxxxxxxxxxxncorder},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.p9xxuxxxbvxxxxxxxxxxnsperson) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.p9xxuxxxbvxxxxxxxxxxnsperson},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.q8xxuxcqbvxxxxxxxxxxcustomerquotenb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.q8xxuxcqbvxxxxxxxxxxcustomerquotenb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r1xxuxcqbvxxxxxxxxxxcustomerquotena) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r1xxuxcqbvxxxxxxxxxxcustomerquotena},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r2xxuxcobvxxxxxxxxxxcustomerordernb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r2xxuxcobvxxxxxxxxxxcustomerordernb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r4xxuxcobvxxxxxxxxxxcustomerorderna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r4xxuxcobvxxxxxxxxxxcustomerorderna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r5xxuxvobvxxxxxxxxxxvendorordernb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r5xxuxvobvxxxxxxxxxxvendorordernb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r7xxuxvobvxxxxxxxxxxvendororderna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r7xxuxvobvxxxxxxxxxxvendororderna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r8xxuxjobvxxxxxxxxxxjobnb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r8xxuxjobvxxxxxxxxxxjobnb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.r8xxuxvobvxxxxxxxxxxemployeeordernb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.r8xxuxvobvxxxxxxxxxxemployeeordernb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.raxxuxvobvxxxxxxxxxxemployeeorderna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.raxxuxvobvxxxxxxxxxxemployeeorderna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.s1xxuxjobvxxxxxxxxxxjobna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.s1xxuxjobvxxxxxxxxxxjobna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.s2xxuxcibvxxxxxxxxxxcustomerinvoicenb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.s2xxuxcibvxxxxxxxxxxcustomerinvoicenb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.s4xxuxcibvxxxxxxxxxxcustomerinvoicena) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.s4xxuxcibvxxxxxxxxxxcustomerinvoicena},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.s5xxuxvibvxxxxxxxxxxvendorinvoicenb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.s5xxuxvibvxxxxxxxxxxvendorinvoicenb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.s7xxuxvibvxxxxxxxxxxvendorinvoicena) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.s7xxuxvibvxxxxxxxxxxvendorinvoicena},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.s8xxuxcrbvxxxxxxxxxxcustomerpicknb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.s8xxuxcrbvxxxxxxxxxxcustomerpicknb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.saxxuxcpbvxxxxxxxxxxcustomerpaymntnb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.saxxuxcpbvxxxxxxxxxxcustomerpaymntnb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.scxxuxcpbvxxxxxxxxxxcustomerpaymntna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.scxxuxcpbvxxxxxxxxxxcustomerpaymntna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t1xxuxcrbvxxxxxxxxxxcustomerpickna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t1xxuxcrbvxxxxxxxxxxcustomerpickna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t2xxuxvpbvxxxxxxxxxxvendorpaymntnb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t2xxuxvpbvxxxxxxxxxxvendorpaymntnb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t2xxuxvqbvxxxxxxxxxxvendorquotenb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t2xxuxvqbvxxxxxxxxxxvendorquotenb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t4xxuxvpbvxxxxxxxxxxvendorpaymntna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t4xxuxvpbvxxxxxxxxxxvendorpaymntna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t4xxuxvqbvxxxxxxxxxxtaskna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t4xxuxvqbvxxxxxxxxxxtaskna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t4xxuxvqbvxxxxxxxxxxtasknb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t4xxuxvqbvxxxxxxxxxxtasknb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t4xxuxvqbvxxxxxxxxxxvendorquotena) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t4xxuxvqbvxxxxxxxxxxvendorquotena},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t5xxuxvpbvxxxxxxxxxxvendorchqnb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t5xxuxvpbvxxxxxxxxxxvendorchqnb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t5xxzwprbvxxxxxxxxxxarseqb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t5xxzwprbvxxxxxxxxxxarseqb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t7xxuxvpbvxxxxxxxxxxvendorchqna) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t7xxuxvpbvxxxxxxxxxxvendorchqna},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t7xxzwprbvxxxxxxxxxxarseqa) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t7xxzwprbvxxxxxxxxxxarseqa},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.t8xxzwppbvxxxxxxxxxxapseqb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.t8xxzwppbvxxxxxxxxxxapseqb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.u1xxzwppbvxxxxxxxxxxapseqa) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.u1xxzwppbvxxxxxxxxxxapseqa},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.u2xxzwplbvxxxxxxxxxxglseqb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.u2xxzwplbvxxxxxxxxxxglseqb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.u4xxzwplbvxxxxxxxxxxglseqa) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.u4xxzwplbvxxxxxxxxxxglseqa},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.u5xxzwpabvxxxxxxxxxxpaseqb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.u5xxzwpabvxxxxxxxxxxpaseqb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.u7xxzwpabvxxxxxxxxxxpaseqa) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.u7xxzwpabvxxxxxxxxxxpaseqa},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.u8xxzwpibvxxxxxxxxxxicseqb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.u8xxzwpibvxxxxxxxxxxicseqb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v1xxzwpibvxxxxxxxxxxicseqa) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v1xxzwpibvxxxxxxxxxxicseqa},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v2xxzwpjbvxxxxxxxxxxjoseqb) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v2xxzwpjbvxxxxxxxxxxjoseqb},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v4xxzwpjbvxxxxxxxxxxjoseqa) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v4xxzwpjbvxxxxxxxxxxjoseqa},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v5xxuxxxbvxxxxxxxxxxsglentry) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v5xxuxxxbvxxxxxxxxxxsglentry},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v6xxuxz1bvxxxxxxxxxxtax1code) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v6xxuxz1bvxxxxxxxxxxtax1code},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v7xxuxz2bvxxxxxxxxxxtax2code) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v7xxuxz2bvxxxxxxxxxxtax2code},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.v8xxuxz3bvxxxxxxxxxxtax3code) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.v8xxuxz3bvxxxxxxxxxxtax3code},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w1xxuxxxbvxxxxxxxxxxedipassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w1xxuxxxbvxxxxxxxxxxedipassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w2xxuxxxbvxxxxxxxxxxintpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w2xxuxxxbvxxxxxxxxxxintpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w3xxuxxxbvxxxxxxxxxxinrpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w3xxuxxxbvxxxxxxxxxxinrpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w4xxuxxxbvxxxxxxxxxximlpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w4xxuxxxbvxxxxxxxxxximlpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w5xxuxxxbvxxxxxxxxxxrmlpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w5xxuxxxbvxxxxxxxxxxrmlpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w6xxuxxxbvxxxxxxxxxxlmlpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w6xxuxxxbvxxxxxxxxxxlmlpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w7xxuxxxbvxxxxxxxxxxhospassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w7xxuxxxbvxxxxxxxxxxhospassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w8xxuxxxbvxxxxxxxxxxlanpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w8xxuxxxbvxxxxxxxxxxlanpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.w9xxuxxxbvxxxxxxxxxxwanpassw) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.w9xxuxxxbvxxxxxxxxxxwanpassw},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x1xxuxxxbvxxxxxxxxxxashostid) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x1xxuxxxbvxxxxxxxxxxashostid},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x2xxuxxxbvxxxxxxxxxxhdstyle) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x2xxuxxxbvxxxxxxxxxxhdstyle},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x3xxuxxxbvxxxxxxxxxxmtstyle) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x3xxuxxxbvxxxxxxxxxxmtstyle},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x4xxuxxxbvxxxxxxxxxxststyle) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x4xxuxxxbvxxxxxxxxxxststyle},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x5xxuxxxbvxxxxxxxxxxdtstyle) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x5xxuxxxbvxxxxxxxxxxdtstyle},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x6xxuxxxbvxxxxxxxxxxftstyle) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x6xxuxxxbvxxxxxxxxxxftstyle},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x7xxuxxxbvxxxxxxxxxxdefaultr) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x7xxuxxxbvxxxxxxxxxxdefaultr},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.x9xxuxxxbvxxxxxxxxxxdbname) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.x9xxuxxxbvxxxxxxxxxxdbname},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.y1xxuxxxbvxxxxxxxxxxrootdir) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.y1xxuxxxbvxxxxxxxxxxrootdir},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.y2xxuxxxbvxxxxxxxxxxkeyorder) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.y2xxuxxxbvxxxxxxxxxxkeyorder},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.y8xxuxxxbvxxxxxxxxxxdefaultc) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.y8xxuxxxbvxxxxxxxxxxdefaultc},'%'))",

        "lower(yxxxch522xhhxxhxxxxxclient.z1xxuxxxbvxxxxxxxxxxlastuser) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.z1xxuxxxbvxxxxxxxxxxlastuser},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.z8xxuxxxbvxxxxxxxxxxpop3server) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.z8xxuxxxbvxxxxxxxxxxpop3server},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.z8xxuxxxbvxxxxxxxxxxsmtpserver) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.z8xxuxxxbvxxxxxxxxxxsmtpserver},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.z9xxuxxxbvxxxxxxxxxxpop3user) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.z9xxuxxxbvxxxxxxxxxxpop3user},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.z9xxuxxxbvxxxxxxxxxxsmtpuser) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.z9xxuxxxbvxxxxxxxxxxsmtpuser},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.zaxxuxxxssxxxxxxxxxxpop3pass) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.zaxxuxxxssxxxxxxxxxxpop3pass},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.zaxxuxxxssxxxxxxxxxxsmtppass) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.zaxxuxxxssxxxxxxxxxxsmtppass},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.zbxxuxxxbvxxxxxxxxxxsmatcode) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.zbxxuxxxbvxxxxxxxxxxsmatcode},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.zgxxuznxbvxxxxxxxxxxnotes) like lower( concat(#{yxxxch522xhhxxhxxxxxclientList.yxxxch522xhhxxhxxxxxclient.zgxxuznxbvxxxxxxxxxxnotes},'%'))",
        "lower(yxxxch522xhhxxhxxxxxclient.zhxxutoxlhxxxxxxxxxxowner) like lower( concat('%',#{yxxxch522xhhxxhxxxxxclientList.ownerCddCode}))",
        "lower(yxxxch522xhhxxhxxxxxclient.zzxxu2oxxhxxxxxxxxxxowner2) = lower(#{yxxxch522xhhxxhxxxxxclientList.dataOwner2Code})",
    };



    private Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient = new Yxxxch522xhhxxhxxxxxclient();
 /*
  In case of non composite ie Single Field Key
 */
      /*
      ids = pojo.identifierProperty.name >>> a0xxuobxbxxxxxxxxxxxsid
      */




// add more logic here to pick up foreign fields if transaction or mailing, pks,pfs=05 efs=06,added multiple K test
   //not foreign or collection properties  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection also not component  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection properties  property name a0xxukxxbvxxxxxxxxxxclientversion
   //not foreign or collection also not component  property name a0xxukxxbvxxxxxxxxxxclientversion
      //not component keyfield property name a0xxukxxbvxxxxxxxxxxclientversion
   //not foreign or collection properties  property name b1xxuisxlvxxxxxxxxxxserialnum
   //not foreign or collection also not component  property name b1xxuisxlvxxxxxxxxxxserialnum
   //not foreign or collection properties  property name b2xxuzcxbvxxxxxxxxxxenterprisecompanyna
   //not foreign or collection also not component  property name b2xxuzcxbvxxxxxxxxxxenterprisecompanyna
   //not foreign or collection properties  property name b3xxuxzsbvxxxxxxxxxxdescript
   //not foreign or collection also not component  property name b3xxuxzsbvxxxxxxxxxxdescript
   //not foreign or collection properties  property name b4xxuxa1bvxxxxxxxxxxaddrl1
   //not foreign or collection also not component  property name b4xxuxa1bvxxxxxxxxxxaddrl1
   //not foreign or collection properties  property name b5xxub2xbvxxxxxxxxxxaddrl2
   //not foreign or collection also not component  property name b5xxub2xbvxxxxxxxxxxaddrl2
   //not foreign or collection properties  property name b6xxub3xevxxxxxxxxxxaddrl3
   //not foreign or collection also not component  property name b6xxub3xevxxxxxxxxxxaddrl3
   //not foreign or collection properties  property name b7xxhxacbv11xxxxxxxxcity
   //not foreign or collection also not component  property name b7xxhxacbv11xxxxxxxxcity
   //not foreign or collection properties  property name b8xxhbpxbv12xxxxxxxxprovnstate
   //not foreign or collection also not component  property name b8xxhbpxbv12xxxxxxxxprovnstate
   //not foreign or collection properties  property name b9xxhboxev13xxxxxxxxcountryname
   //not foreign or collection also not component  property name b9xxhboxev13xxxxxxxxcountryname
   //not foreign or collection properties  property name c1xxhxazbv14xxxxxxxxpzcode
   //not foreign or collection also not component  property name c1xxhxazbv14xxxxxxxxpzcode
   //not foreign or collection properties  property name c6xxhxxxbv27xxxxxxxxphoneo
   //not foreign or collection also not component  property name c6xxhxxxbv27xxxxxxxxphoneo
   //not foreign or collection properties  property name c7xxhxxxbv27xxxxxxxxphoneh
   //not foreign or collection also not component  property name c7xxhxxxbv27xxxxxxxxphoneh
   //not foreign or collection properties  property name c8xxhxxrbv27xxxxxxxxphonec
   //not foreign or collection also not component  property name c8xxhxxrbv27xxxxxxxxphonec
   //not foreign or collection properties  property name c9xxhxxrbv27xxxxxxxxphonex
   //not foreign or collection also not component  property name c9xxhxxrbv27xxxxxxxxphonex
   //not foreign or collection properties  property name d1xxhxxrbv19xxxxxxxxlanaddr
   //not foreign or collection also not component  property name d1xxhxxrbv19xxxxxxxxlanaddr
   //not foreign or collection properties  property name d2xxhxxrbv25xxxxxxxxwanaddr
   //not foreign or collection also not component  property name d2xxhxxrbv25xxxxxxxxwanaddr
   //not foreign or collection properties  property name d3xxhxxrbv44xxxxxxxxlmailaddr
   //not foreign or collection also not component  property name d3xxhxxrbv44xxxxxxxxlmailaddr
   //not foreign or collection properties  property name d4xxhxxrbv24xxxxxxxximailaddr
   //not foreign or collection also not component  property name d4xxhxxrbv24xxxxxxxximailaddr
   //not foreign or collection properties  property name d5xxuxxrbvxxxxxxxxxxrmailaddr
   //not foreign or collection also not component  property name d5xxuxxrbvxxxxxxxxxxrmailaddr
   //not foreign or collection properties  property name d6xxuxxrbvxxxxxxxxxxintaddr
   //not foreign or collection also not component  property name d6xxuxxrbvxxxxxxxxxxintaddr
   //not foreign or collection properties  property name d7xxuxxrbvxxxxxxxxxxinraddr
   //not foreign or collection also not component  property name d7xxuxxrbvxxxxxxxxxxinraddr
   //not foreign or collection properties  property name d8xxuzxdbvxxxxxxxxxxenterprisecompcode
   //not foreign or collection also not component  property name d8xxuzxdbvxxxxxxxxxxenterprisecompcode
   //not foreign or collection properties  property name d9xxuxxxbvxxxxxxxxxxenterprisecompsize
   //not foreign or collection also not component  property name d9xxuxxxbvxxxxxxxxxxenterprisecompsize
   //not foreign or collection properties  property name daxxuzxdssxxxxxxxxxxapiclientid
   //not foreign or collection also not component  property name daxxuzxdssxxxxxxxxxxapiclientid
   //not foreign or collection properties  property name dbxxuzxdssxxxxxxxxxxapiclientsecret
   //not foreign or collection also not component  property name dbxxuzxdssxxxxxxxxxxapiclientsecret
   //not foreign or collection properties  property name e2xxuxxxbvxxxxxxxxxxbarcsize
   //not foreign or collection also not component  property name e2xxuxxxbvxxxxxxxxxxbarcsize
   //not foreign or collection properties  property name e9xxfxxrbvxxxxxxxxxxlevel
   //not foreign or collection also not component  property name e9xxfxxrbvxxxxxxxxxxlevel
   //not foreign or collection properties  property name f1xxuxxxbvxxxxxxxxxxposkipp
   //not foreign or collection also not component  property name f1xxuxxxbvxxxxxxxxxxposkipp
   //not foreign or collection properties  property name f2xxfxxxbvxxxxxxxxxxlooseit
   //not foreign or collection also not component  property name f2xxfxxxbvxxxxxxxxxxlooseit
   //not foreign or collection properties  property name f3xxuxxxbvxxxxxxxxxxjobskip
   //not foreign or collection also not component  property name f3xxuxxxbvxxxxxxxxxxjobskip
   //not foreign or collection properties  property name f4xxfxxxbvxxxxxxxxxxcartonfl
   //not foreign or collection also not component  property name f4xxfxxxbvxxxxxxxxxxcartonfl
   //not foreign or collection properties  property name f5xxfxxxbvxxxxxxxxxxpicklist
   //not foreign or collection also not component  property name f5xxfxxxbvxxxxxxxxxxpicklist
   //not foreign or collection properties  property name f6xxuxxxlvxxxxxxxxxxlicensetype
   //not foreign or collection also not component  property name f6xxuxxxlvxxxxxxxxxxlicensetype
   //not foreign or collection properties  property name f7xxcxxxlvxxxxxxxxxxlicensestart
   //not foreign or collection also not component  property name f7xxcxxxlvxxxxxxxxxxlicensestart
   //not foreign or collection properties  property name f8xxcxxxlvxxxxxxxxxxlicenseend
   //not foreign or collection also not component  property name f8xxcxxxlvxxxxxxxxxxlicenseend
   //not foreign or collection properties  property name g1xxuxxxbvxxxxxxxxxxproddesc
   //not foreign or collection also not component  property name g1xxuxxxbvxxxxxxxxxxproddesc
   //not foreign or collection properties  property name g2xxuxpclvxxxxxxxxxxprodcode
   //not foreign or collection also not component  property name g2xxuxpclvxxxxxxxxxxprodcode
   //not foreign or collection properties  property name g3xxuxxxbvxxnxxxxxxxnjob
   //not foreign or collection also not component  property name g3xxuxxxbvxxnxxxxxxxnjob
   //not foreign or collection properties  property name g4xxuxxxssxxnxxxxxxxnmateria
   //not foreign or collection also not component  property name g4xxuxxxssxxnxxxxxxxnmateria
   //not foreign or collection properties  property name g5xxuxxxbvxxxxxxxxxxnactivity
   //not foreign or collection also not component  property name g5xxuxxxbvxxxxxxxxxxnactivity
   //not foreign or collection properties  property name g6xxuxxxbvxxxxxxxxxxnbutt
   //not foreign or collection also not component  property name g6xxuxxxbvxxxxxxxxxxnbutt
   //not foreign or collection properties  property name g7xxuxrrbvxxxxxxxxxxncustome
   //not foreign or collection also not component  property name g7xxuxrrbvxxxxxxxxxxncustome
   //not foreign or collection properties  property name g8xxuxrcbvxxxxxxxxxxncontact
   //not foreign or collection also not component  property name g8xxuxrcbvxxxxxxxxxxncontact
   //not foreign or collection properties  property name g9xxuxvvbvxxnxxxxxxxnvendor
   //not foreign or collection also not component  property name g9xxuxvvbvxxnxxxxxxxnvendor
   //not foreign or collection properties  property name h1xxuxttbvxxxxxxxxxxnemployee
   //not foreign or collection also not component  property name h1xxuxttbvxxxxxxxxxxnemployee
   //not foreign or collection properties  property name h2xxuxxxbvxxxxxxxxxxnschedule
   //not foreign or collection also not component  property name h2xxuxxxbvxxxxxxxxxxnschedule
   //not foreign or collection properties  property name h3xxuxxxbvxxxxxxxxxxnreject
   //not foreign or collection also not component  property name h3xxuxxxbvxxxxxxxxxxnreject
   //not foreign or collection properties  property name h4xxuxxxbvxxxxxxxxxxnreturn
   //not foreign or collection also not component  property name h4xxuxxxbvxxxxxxxxxxnreturn
   //not foreign or collection properties  property name h5xxuxxxivxxxxxxxxxxncode
   //not foreign or collection also not component  property name h5xxuxxxivxxxxxxxxxxncode
   //not foreign or collection properties  property name h6xxuxxxbvxxxxxxxxxxmanufid
   //not foreign or collection also not component  property name h6xxuxxxbvxxxxxxxxxxmanufid
   //not foreign or collection properties  property name h7xxuxxxbvxxxxxxxxxxbartype
   //not foreign or collection also not component  property name h7xxuxxxbvxxxxxxxxxxbartype
   //not foreign or collection properties  property name h8xxuxxxbvxxxxxxxxxxcadtype
   //not foreign or collection also not component  property name h8xxuxxxbvxxxxxxxxxxcadtype
   //not foreign or collection properties  property name h9xxuxxxbvxxxxxxxxxxcartype
   //not foreign or collection also not component  property name h9xxuxxxbvxxxxxxxxxxcartype
   //not foreign or collection properties  property name i1xxuxxxbvxxxxxxxxxxshitype
   //not foreign or collection also not component  property name i1xxuxxxbvxxxxxxxxxxshitype
   //not foreign or collection properties  property name i2xxuxxxbvxxxxxxxxxxreptype
   //not foreign or collection also not component  property name i2xxuxxxbvxxxxxxxxxxreptype
   //not foreign or collection properties  property name i3xxuxxxbvxxxxxxxxxxloctype
   //not foreign or collection also not component  property name i3xxuxxxbvxxxxxxxxxxloctype
   //not foreign or collection properties  property name i4xxfxxxbvxxxxxxxxxxbarcol
   //not foreign or collection also not component  property name i4xxfxxxbvxxxxxxxxxxbarcol
   //not foreign or collection properties  property name i5xxfxxxbvxxxxxxxxxxcarcol
   //not foreign or collection also not component  property name i5xxfxxxbvxxxxxxxxxxcarcol
   //not foreign or collection properties  property name i6xxfxxxbvxxxxxxxxxxcadcol
   //not foreign or collection also not component  property name i6xxfxxxbvxxxxxxxxxxcadcol
   //not foreign or collection properties  property name i7xxfxxxbvxxxxxxxxxxshicol
   //not foreign or collection also not component  property name i7xxfxxxbvxxxxxxxxxxshicol
   //not foreign or collection properties  property name i8xxfxxxbvxxxxxxxxxxrepcol
   //not foreign or collection also not component  property name i8xxfxxxbvxxxxxxxxxxrepcol
   //not foreign or collection properties  property name i9xxfxxxbvxxxxxxxxxxloccol
   //not foreign or collection also not component  property name i9xxfxxxbvxxxxxxxxxxloccol
   //not foreign or collection properties  property name j1xxfxxxbvxxxxxxxxxxaltseria
   //not foreign or collection also not component  property name j1xxfxxxbvxxxxxxxxxxaltseria
   //not foreign or collection properties  property name j2xxuxxxbvxxxxxxxxxxcountrycode
   //not foreign or collection also not component  property name j2xxuxxxbvxxxxxxxxxxcountrycode
   //not foreign or collection properties  property name j3xxuxxxbvxxxxxxxxxxnaltseri
   //not foreign or collection also not component  property name j3xxuxxxbvxxxxxxxxxxnaltseri
   //not foreign or collection properties  property name j4xxuxxxbvxxxxxxxxxxscrcolor
   //not foreign or collection also not component  property name j4xxuxxxbvxxxxxxxxxxscrcolor
   //not foreign or collection properties  property name j5xxuxxxbvxxxxxxxxxxhilcolor
   //not foreign or collection also not component  property name j5xxuxxxbvxxxxxxxxxxhilcolor
   //not foreign or collection properties  property name j6xxuxxxbvxxxxxxxxxxtextcolor
   //not foreign or collection also not component  property name j6xxuxxxbvxxxxxxxxxxtextcolor
   //not foreign or collection properties  property name j7xxuxxxbvxxxxxxxxxxbaccolor
   //not foreign or collection also not component  property name j7xxuxxxbvxxxxxxxxxxbaccolor
   //not foreign or collection properties  property name j8xxuxxxbvxxxxxxxxxxdatetype
   //not foreign or collection also not component  property name j8xxuxxxbvxxxxxxxxxxdatetype
   //not foreign or collection properties  property name j9xxuxxxbvxxxxxxxxxxcurrsymb
   //not foreign or collection also not component  property name j9xxuxxxbvxxxxxxxxxxcurrsymb
   //not foreign or collection properties  property name k1xxuxxxbvxxxxxxxxxxcurrcode
   //not foreign or collection also not component  property name k1xxuxxxbvxxxxxxxxxxcurrcode
   //not foreign or collection properties  property name k2xxfxxxbvxxxxxxxxxxprinbar
   //not foreign or collection also not component  property name k2xxfxxxbvxxxxxxxxxxprinbar
   //not foreign or collection properties  property name k3xxuxxxbvxxxxxxxxxxbarprint
   //not foreign or collection also not component  property name k3xxuxxxbvxxxxxxxxxxbarprint
   //not foreign or collection properties  property name k4xxuxxxbvxxxxxxxxxxcarprint
   //not foreign or collection also not component  property name k4xxuxxxbvxxxxxxxxxxcarprint
   //not foreign or collection properties  property name k5xxuxxxbvxxxxxxxxxxcadprint
   //not foreign or collection also not component  property name k5xxuxxxbvxxxxxxxxxxcadprint
   //not foreign or collection properties  property name k6xxuxxxbvxxxxxxxxxxlocprint
   //not foreign or collection also not component  property name k6xxuxxxbvxxxxxxxxxxlocprint
   //not foreign or collection properties  property name k7xxuxxxbvxxxxxxxxxxshiprint
   //not foreign or collection also not component  property name k7xxuxxxbvxxxxxxxxxxshiprint
   //not foreign or collection properties  property name k8xxuxxxbvxxxxxxxxxxrepprint
   //not foreign or collection also not component  property name k8xxuxxxbvxxxxxxxxxxrepprint
   //not foreign or collection properties  property name k9xxuxxxbvxxxxxxxxxxbarprty
   //not foreign or collection also not component  property name k9xxuxxxbvxxxxxxxxxxbarprty
   //not foreign or collection properties  property name l1xxuxxxbvxxxxxxxxxxrepprty
   //not foreign or collection also not component  property name l1xxuxxxbvxxxxxxxxxxrepprty
   //not foreign or collection properties  property name l2xxuxxxbvxxxxxxxxxxcarprty
   //not foreign or collection also not component  property name l2xxuxxxbvxxxxxxxxxxcarprty
   //not foreign or collection properties  property name l3xxuxxxbvxxxxxxxxxxcadprty
   //not foreign or collection also not component  property name l3xxuxxxbvxxxxxxxxxxcadprty
   //not foreign or collection properties  property name l4xxuxxxbvxxxxxxxxxxshiprty
   //not foreign or collection also not component  property name l4xxuxxxbvxxxxxxxxxxshiprty
   //not foreign or collection properties  property name l5xxuxxxbvxxxxxxxxxxlocprty
   //not foreign or collection also not component  property name l5xxuxxxbvxxxxxxxxxxlocprty
   //not foreign or collection properties  property name l6xxzxxrbvxxxxxxxxxxaltselen
   //not foreign or collection also not component  property name l6xxzxxrbvxxxxxxxxxxaltselen
   //not foreign or collection properties  property name l7xxzxxrbvxxxxxxxxxxcustolen
   //not foreign or collection also not component  property name l7xxzxxrbvxxxxxxxxxxcustolen
   //not foreign or collection properties  property name l8xxuxxxbvxxxxxxxxxxcarcsize
   //not foreign or collection also not component  property name l8xxuxxxbvxxxxxxxxxxcarcsize
   //not foreign or collection properties  property name l9xxuxxxbvxxxxxxxxxxcadcsize
   //not foreign or collection also not component  property name l9xxuxxxbvxxxxxxxxxxcadcsize
   //not foreign or collection properties  property name m1xxuxxxbvxxxxxxxxxxshicsize
   //not foreign or collection also not component  property name m1xxuxxxbvxxxxxxxxxxshicsize
   //not foreign or collection properties  property name m2xxuxxxbvxxxxxxxxxxrepcsize
   //not foreign or collection also not component  property name m2xxuxxxbvxxxxxxxxxxrepcsize
   //not foreign or collection properties  property name m3xxuxxxbvxxxxxxxxxxloccsize
   //not foreign or collection also not component  property name m3xxuxxxbvxxxxxxxxxxloccsize
   //not foreign or collection properties  property name m4xxuxxxbvxxxxxxxxxxcs
   //not foreign or collection also not component  property name m4xxuxxxbvxxxxxxxxxxcs
   //not foreign or collection properties  property name m5xxuxxxbvxxxxxxxxxxnconftyp
   //not foreign or collection also not component  property name m5xxuxxxbvxxxxxxxxxxnconftyp
   //not foreign or collection properties  property name m6xxuxxxbvxxxxxxxxxxnlocatio
   //not foreign or collection also not component  property name m6xxuxxxbvxxxxxxxxxxnlocatio
   //not foreign or collection properties  property name m7xxuoxxbvxxxxxxxxxxndivcode
   //not foreign or collection also not component  property name m7xxuoxxbvxxxxxxxxxxndivcode
   //not foreign or collection properties  property name m8xxuexxbvxxxxxxxxxxndepcode
   //not foreign or collection also not component  property name m8xxuexxbvxxxxxxxxxxndepcode
   //not foreign or collection properties  property name m9xxuxxxbvxxxxxxxxxxnaddcode
   //not foreign or collection also not component  property name m9xxuxxxbvxxxxxxxxxxnaddcode
   //not foreign or collection properties  property name o1xxuxxxbvxxxxxxxxxxnfloor
   //not foreign or collection also not component  property name o1xxuxxxbvxxxxxxxxxxnfloor
   //not foreign or collection properties  property name o2xxuxxxbvxxxxxxxxxxnroom
   //not foreign or collection also not component  property name o2xxuxxxbvxxxxxxxxxxnroom
   //not foreign or collection properties  property name o3xxuxxxbvxxxxxxxxxxnrack
   //not foreign or collection also not component  property name o3xxuxxxbvxxxxxxxxxxnrack
   //not foreign or collection properties  property name o4xxuxxxbvxxxxxxxxxxmenutype
   //not foreign or collection also not component  property name o4xxuxxxbvxxxxxxxxxxmenutype
   //not foreign or collection properties  property name o5xxuxxxbvxxxxxxxxxxpadtype
   //not foreign or collection also not component  property name o5xxuxxxbvxxxxxxxxxxpadtype
   //not foreign or collection properties  property name o6xxuxxxbvxxxxxxxxxxnrate1ta
   //not foreign or collection also not component  property name o6xxuxxxbvxxxxxxxxxxnrate1ta
   //not foreign or collection properties  property name o7xxuxxxbvxxxxxxxxxxnrate2ta
   //not foreign or collection also not component  property name o7xxuxxxbvxxxxxxxxxxnrate2ta
   //not foreign or collection properties  property name o8xxuxxxbvxxxxxxxxxxdefconft
   //not foreign or collection also not component  property name o8xxuxxxbvxxxxxxxxxxdefconft
   //not foreign or collection properties  property name o9xxfxxxbvxxxxxxxxxxbeepsou
   //not foreign or collection also not component  property name o9xxfxxxbvxxxxxxxxxxbeepsou
   //not foreign or collection properties  property name p1xxfxxxbvxxxxxxxxxxconfirm
   //not foreign or collection also not component  property name p1xxfxxxbvxxxxxxxxxxconfirm
   //not foreign or collection properties  property name p2xxfxxxbvxxxxxxxxxxlinefeed
   //not foreign or collection also not component  property name p2xxfxxxbvxxxxxxxxxxlinefeed
   //not foreign or collection properties  property name p3xxzxxrbvxxxxxxxxxxrefbaradj
   //not foreign or collection also not component  property name p3xxzxxrbvxxxxxxxxxxrefbaradj
   //not foreign or collection properties  property name p4xxzxxrbvxxxxxxxxxxshibaradj
   //not foreign or collection also not component  property name p4xxzxxrbvxxxxxxxxxxshibaradj
   //not foreign or collection properties  property name p5xxzxxrbvxxxxxxxxxxcusbaradj
   //not foreign or collection also not component  property name p5xxzxxrbvxxxxxxxxxxcusbaradj
   //not foreign or collection properties  property name p6xxzxxrbvxxxxxxxxxxlocbaradj
   //not foreign or collection also not component  property name p6xxzxxrbvxxxxxxxxxxlocbaradj
   //not foreign or collection properties  property name p7xxzxxrbvxxxxxxxxxxcarbaradj
   //not foreign or collection also not component  property name p7xxzxxrbvxxxxxxxxxxcarbaradj
   //not foreign or collection properties  property name p8xxuxxxbvxxxxxxxxxxncorder
   //not foreign or collection also not component  property name p8xxuxxxbvxxxxxxxxxxncorder
   //not foreign or collection properties  property name p9xxuxxxbvxxxxxxxxxxnsperson
   //not foreign or collection also not component  property name p9xxuxxxbvxxxxxxxxxxnsperson
   //not foreign or collection properties  property name q1xxfxxxbvxxxxxxxxxxprompti
   //not foreign or collection also not component  property name q1xxfxxxbvxxxxxxxxxxprompti
   //not foreign or collection properties  property name q8xxuxcqbvxxxxxxxxxxcustomerquotenb
   //not foreign or collection also not component  property name q8xxuxcqbvxxxxxxxxxxcustomerquotenb
   //not foreign or collection properties  property name q9xxuxcqbvxxxxxxxxxxcustomerquoten
   //not foreign or collection also not component  property name q9xxuxcqbvxxxxxxxxxxcustomerquoten
   //not foreign or collection properties  property name r1xxuxcqbvxxxxxxxxxxcustomerquotena
   //not foreign or collection also not component  property name r1xxuxcqbvxxxxxxxxxxcustomerquotena
   //not foreign or collection properties  property name r2xxuxcobvxxxxxxxxxxcustomerordernb
   //not foreign or collection also not component  property name r2xxuxcobvxxxxxxxxxxcustomerordernb
   //not foreign or collection properties  property name r3xxuxcobvxxxxxxxxxxcustomerordern
   //not foreign or collection also not component  property name r3xxuxcobvxxxxxxxxxxcustomerordern
   //not foreign or collection properties  property name r4xxuxcobvxxxxxxxxxxcustomerorderna
   //not foreign or collection also not component  property name r4xxuxcobvxxxxxxxxxxcustomerorderna
   //not foreign or collection properties  property name r5xxuxvobvxxxxxxxxxxvendorordernb
   //not foreign or collection also not component  property name r5xxuxvobvxxxxxxxxxxvendorordernb
   //not foreign or collection properties  property name r6xxuxvobvxxxxxxxxxxvendorordern
   //not foreign or collection also not component  property name r6xxuxvobvxxxxxxxxxxvendorordern
   //not foreign or collection properties  property name r7xxuxvobvxxxxxxxxxxvendororderna
   //not foreign or collection also not component  property name r7xxuxvobvxxxxxxxxxxvendororderna
   //not foreign or collection properties  property name r8xxuxjobvxxxxxxxxxxjobnb
   //not foreign or collection also not component  property name r8xxuxjobvxxxxxxxxxxjobnb
   //not foreign or collection properties  property name r8xxuxvobvxxxxxxxxxxemployeeordernb
   //not foreign or collection also not component  property name r8xxuxvobvxxxxxxxxxxemployeeordernb
   //not foreign or collection properties  property name r9xxuxjobvxxxxxxxxxxjobn
   //not foreign or collection also not component  property name r9xxuxjobvxxxxxxxxxxjobn
   //not foreign or collection properties  property name r9xxuxvobvxxxxxxxxxxemployeeordern
   //not foreign or collection also not component  property name r9xxuxvobvxxxxxxxxxxemployeeordern
   //not foreign or collection properties  property name raxxuxvobvxxxxxxxxxxemployeeorderna
   //not foreign or collection also not component  property name raxxuxvobvxxxxxxxxxxemployeeorderna
   //not foreign or collection properties  property name s1xxuxjobvxxxxxxxxxxjobna
   //not foreign or collection also not component  property name s1xxuxjobvxxxxxxxxxxjobna
   //not foreign or collection properties  property name s2xxuxcibvxxxxxxxxxxcustomerinvoicenb
   //not foreign or collection also not component  property name s2xxuxcibvxxxxxxxxxxcustomerinvoicenb
   //not foreign or collection properties  property name s3xxuxcibvxxxxxxxxxxcustomerinvoicen
   //not foreign or collection also not component  property name s3xxuxcibvxxxxxxxxxxcustomerinvoicen
   //not foreign or collection properties  property name s4xxuxcibvxxxxxxxxxxcustomerinvoicena
   //not foreign or collection also not component  property name s4xxuxcibvxxxxxxxxxxcustomerinvoicena
   //not foreign or collection properties  property name s5xxuxvibvxxxxxxxxxxvendorinvoicenb
   //not foreign or collection also not component  property name s5xxuxvibvxxxxxxxxxxvendorinvoicenb
   //not foreign or collection properties  property name s6xxuxvibvxxxxxxxxxxvendorinvoicen
   //not foreign or collection also not component  property name s6xxuxvibvxxxxxxxxxxvendorinvoicen
   //not foreign or collection properties  property name s7xxuxvibvxxxxxxxxxxvendorinvoicena
   //not foreign or collection also not component  property name s7xxuxvibvxxxxxxxxxxvendorinvoicena
   //not foreign or collection properties  property name s8xxuxcrbvxxxxxxxxxxcustomerpicknb
   //not foreign or collection also not component  property name s8xxuxcrbvxxxxxxxxxxcustomerpicknb
   //not foreign or collection properties  property name s9xxuxcrbvxxxxxxxxxxcustomerpickn
   //not foreign or collection also not component  property name s9xxuxcrbvxxxxxxxxxxcustomerpickn
   //not foreign or collection properties  property name saxxuxcpbvxxxxxxxxxxcustomerpaymntnb
   //not foreign or collection also not component  property name saxxuxcpbvxxxxxxxxxxcustomerpaymntnb
   //not foreign or collection properties  property name sbxxuxcpbvxxxxxxxxxxcustomerpaymntn
   //not foreign or collection also not component  property name sbxxuxcpbvxxxxxxxxxxcustomerpaymntn
   //not foreign or collection properties  property name scxxuxcpbvxxxxxxxxxxcustomerpaymntna
   //not foreign or collection also not component  property name scxxuxcpbvxxxxxxxxxxcustomerpaymntna
   //not foreign or collection properties  property name t1xxuxcrbvxxxxxxxxxxcustomerpickna
   //not foreign or collection also not component  property name t1xxuxcrbvxxxxxxxxxxcustomerpickna
   //not foreign or collection properties  property name t2xxuxvpbvxxxxxxxxxxvendorpaymntnb
   //not foreign or collection also not component  property name t2xxuxvpbvxxxxxxxxxxvendorpaymntnb
   //not foreign or collection properties  property name t2xxuxvqbvxxxxxxxxxxvendorquotenb
   //not foreign or collection also not component  property name t2xxuxvqbvxxxxxxxxxxvendorquotenb
   //not foreign or collection properties  property name t3xxuxvpbvxxxxxxxxxxvendorpaymntn
   //not foreign or collection also not component  property name t3xxuxvpbvxxxxxxxxxxvendorpaymntn
   //not foreign or collection properties  property name t3xxuxvqbvxxxxxxxxxxvendorquoten
   //not foreign or collection also not component  property name t3xxuxvqbvxxxxxxxxxxvendorquoten
   //not foreign or collection properties  property name t4xxuxvpbvxxxxxxxxxxvendorpaymntna
   //not foreign or collection also not component  property name t4xxuxvpbvxxxxxxxxxxvendorpaymntna
   //not foreign or collection properties  property name t4xxuxvqbvxxxxxxxxxxtaskn
   //not foreign or collection also not component  property name t4xxuxvqbvxxxxxxxxxxtaskn
   //not foreign or collection properties  property name t4xxuxvqbvxxxxxxxxxxtaskna
   //not foreign or collection also not component  property name t4xxuxvqbvxxxxxxxxxxtaskna
   //not foreign or collection properties  property name t4xxuxvqbvxxxxxxxxxxtasknb
   //not foreign or collection also not component  property name t4xxuxvqbvxxxxxxxxxxtasknb
   //not foreign or collection properties  property name t4xxuxvqbvxxxxxxxxxxvendorquotena
   //not foreign or collection also not component  property name t4xxuxvqbvxxxxxxxxxxvendorquotena
   //not foreign or collection properties  property name t5xxuxvpbvxxxxxxxxxxvendorchqnb
   //not foreign or collection also not component  property name t5xxuxvpbvxxxxxxxxxxvendorchqnb
   //not foreign or collection properties  property name t5xxzwprbvxxxxxxxxxxarseqb
   //not foreign or collection also not component  property name t5xxzwprbvxxxxxxxxxxarseqb
   //not foreign or collection properties  property name t6xxuxvpbvxxxxxxxxxxvendorchqn
   //not foreign or collection also not component  property name t6xxuxvpbvxxxxxxxxxxvendorchqn
   //not foreign or collection properties  property name t6xxzwprbvxxxxxxxxxxarseq
   //not foreign or collection also not component  property name t6xxzwprbvxxxxxxxxxxarseq
   //not foreign or collection properties  property name t7xxuxvpbvxxxxxxxxxxvendorchqna
   //not foreign or collection also not component  property name t7xxuxvpbvxxxxxxxxxxvendorchqna
   //not foreign or collection properties  property name t7xxzwprbvxxxxxxxxxxarseqa
   //not foreign or collection also not component  property name t7xxzwprbvxxxxxxxxxxarseqa
   //not foreign or collection properties  property name t8xxzwppbvxxxxxxxxxxapseqb
   //not foreign or collection also not component  property name t8xxzwppbvxxxxxxxxxxapseqb
   //not foreign or collection properties  property name t9xxzwppbvxxxxxxxxxxapseq
   //not foreign or collection also not component  property name t9xxzwppbvxxxxxxxxxxapseq
   //not foreign or collection properties  property name u1xxzwppbvxxxxxxxxxxapseqa
   //not foreign or collection also not component  property name u1xxzwppbvxxxxxxxxxxapseqa
   //not foreign or collection properties  property name u2xxzwplbvxxxxxxxxxxglseqb
   //not foreign or collection also not component  property name u2xxzwplbvxxxxxxxxxxglseqb
   //not foreign or collection properties  property name u3xxzwplbvxxxxxxxxxxglseq
   //not foreign or collection also not component  property name u3xxzwplbvxxxxxxxxxxglseq
   //not foreign or collection properties  property name u4xxzwplbvxxxxxxxxxxglseqa
   //not foreign or collection also not component  property name u4xxzwplbvxxxxxxxxxxglseqa
   //not foreign or collection properties  property name u5xxzwpabvxxxxxxxxxxpaseqb
   //not foreign or collection also not component  property name u5xxzwpabvxxxxxxxxxxpaseqb
   //not foreign or collection properties  property name u6xxzwpabvxxxxxxxxxxpaseq
   //not foreign or collection also not component  property name u6xxzwpabvxxxxxxxxxxpaseq
   //not foreign or collection properties  property name u7xxzwpabvxxxxxxxxxxpaseqa
   //not foreign or collection also not component  property name u7xxzwpabvxxxxxxxxxxpaseqa
   //not foreign or collection properties  property name u8xxzwpibvxxxxxxxxxxicseqb
   //not foreign or collection also not component  property name u8xxzwpibvxxxxxxxxxxicseqb
   //not foreign or collection properties  property name u9xxzwpibvxxxxxxxxxxicseq
   //not foreign or collection also not component  property name u9xxzwpibvxxxxxxxxxxicseq
   //not foreign or collection properties  property name v1xxzwpibvxxxxxxxxxxicseqa
   //not foreign or collection also not component  property name v1xxzwpibvxxxxxxxxxxicseqa
   //not foreign or collection properties  property name v2xxzwpjbvxxxxxxxxxxjoseqb
   //not foreign or collection also not component  property name v2xxzwpjbvxxxxxxxxxxjoseqb
   //not foreign or collection properties  property name v3xxzwpjbvxxxxxxxxxxjoseq
   //not foreign or collection also not component  property name v3xxzwpjbvxxxxxxxxxxjoseq
   //not foreign or collection properties  property name v4xxzwpjbvxxxxxxxxxxjoseqa
   //not foreign or collection also not component  property name v4xxzwpjbvxxxxxxxxxxjoseqa
   //not foreign or collection properties  property name v5xxuxxxbvxxxxxxxxxxsglentry
   //not foreign or collection also not component  property name v5xxuxxxbvxxxxxxxxxxsglentry
   //not foreign or collection properties  property name v6xxuxz1bvxxxxxxxxxxtax1code
   //not foreign or collection also not component  property name v6xxuxz1bvxxxxxxxxxxtax1code
   //not foreign or collection properties  property name v7xxuxz2bvxxxxxxxxxxtax2code
   //not foreign or collection also not component  property name v7xxuxz2bvxxxxxxxxxxtax2code
   //not foreign or collection properties  property name v8xxuxz3bvxxxxxxxxxxtax3code
   //not foreign or collection also not component  property name v8xxuxz3bvxxxxxxxxxxtax3code
   //not foreign or collection properties  property name v9xxuxxxbvxxxxxxxxxxndecimal
   //not foreign or collection also not component  property name v9xxuxxxbvxxxxxxxxxxndecimal
   //not foreign or collection properties  property name w1xxuxxxbvxxxxxxxxxxedipassw
   //not foreign or collection also not component  property name w1xxuxxxbvxxxxxxxxxxedipassw
   //not foreign or collection properties  property name w2xxuxxxbvxxxxxxxxxxintpassw
   //not foreign or collection also not component  property name w2xxuxxxbvxxxxxxxxxxintpassw
   //not foreign or collection properties  property name w3xxuxxxbvxxxxxxxxxxinrpassw
   //not foreign or collection also not component  property name w3xxuxxxbvxxxxxxxxxxinrpassw
   //not foreign or collection properties  property name w4xxuxxxbvxxxxxxxxxximlpassw
   //not foreign or collection also not component  property name w4xxuxxxbvxxxxxxxxxximlpassw
   //not foreign or collection properties  property name w5xxuxxxbvxxxxxxxxxxrmlpassw
   //not foreign or collection also not component  property name w5xxuxxxbvxxxxxxxxxxrmlpassw
   //not foreign or collection properties  property name w6xxuxxxbvxxxxxxxxxxlmlpassw
   //not foreign or collection also not component  property name w6xxuxxxbvxxxxxxxxxxlmlpassw
   //not foreign or collection properties  property name w7xxuxxxbvxxxxxxxxxxhospassw
   //not foreign or collection also not component  property name w7xxuxxxbvxxxxxxxxxxhospassw
   //not foreign or collection properties  property name w8xxuxxxbvxxxxxxxxxxlanpassw
   //not foreign or collection also not component  property name w8xxuxxxbvxxxxxxxxxxlanpassw
   //not foreign or collection properties  property name w9xxuxxxbvxxxxxxxxxxwanpassw
   //not foreign or collection also not component  property name w9xxuxxxbvxxxxxxxxxxwanpassw
   //not foreign or collection properties  property name x1xxuxxxbvxxxxxxxxxxashostid
   //not foreign or collection also not component  property name x1xxuxxxbvxxxxxxxxxxashostid
   //not foreign or collection properties  property name x2xxuxxxbvxxxxxxxxxxhdstyle
   //not foreign or collection also not component  property name x2xxuxxxbvxxxxxxxxxxhdstyle
   //not foreign or collection properties  property name x3xxuxxxbvxxxxxxxxxxmtstyle
   //not foreign or collection also not component  property name x3xxuxxxbvxxxxxxxxxxmtstyle
   //not foreign or collection properties  property name x4xxuxxxbvxxxxxxxxxxststyle
   //not foreign or collection also not component  property name x4xxuxxxbvxxxxxxxxxxststyle
   //not foreign or collection properties  property name x5xxuxxxbvxxxxxxxxxxdtstyle
   //not foreign or collection also not component  property name x5xxuxxxbvxxxxxxxxxxdtstyle
   //not foreign or collection properties  property name x6xxuxxxbvxxxxxxxxxxftstyle
   //not foreign or collection also not component  property name x6xxuxxxbvxxxxxxxxxxftstyle
   //not foreign or collection properties  property name x7xxuxxxbvxxxxxxxxxxdefaultr
   //not foreign or collection also not component  property name x7xxuxxxbvxxxxxxxxxxdefaultr
   //not foreign or collection properties  property name x9xxuxxxbvxxxxxxxxxxdbname
   //not foreign or collection also not component  property name x9xxuxxxbvxxxxxxxxxxdbname
   //not foreign or collection properties  property name y1xxuxxxbvxxxxxxxxxxrootdir
   //not foreign or collection also not component  property name y1xxuxxxbvxxxxxxxxxxrootdir
   //not foreign or collection properties  property name y2xxuxxxbvxxxxxxxxxxkeyorder
   //not foreign or collection also not component  property name y2xxuxxxbvxxxxxxxxxxkeyorder
   //not foreign or collection properties  property name y3xxcxxrlxxxxxxxxxxxcurrbusdat
   //not foreign or collection also not component  property name y3xxcxxrlxxxxxxxxxxxcurrbusdat
   //not foreign or collection properties  property name y4xxcxxrlxxxxxxxxxxxlastbusdat
   //not foreign or collection also not component  property name y4xxcxxrlxxxxxxxxxxxlastbusdat
   //not foreign or collection properties  property name y5xxcxxrlxxxxxxxxxxxcurrcaldat
   //not foreign or collection also not component  property name y5xxcxxrlxxxxxxxxxxxcurrcaldat
   //not foreign or collection properties  property name y6xxcxxrlxxxxxxxxxxxlastcaldat
   //not foreign or collection also not component  property name y6xxcxxrlxxxxxxxxxxxlastcaldat
   //not foreign or collection properties  property name y7xxfxxxbvxxxxxxxxxxpreprocess
   //not foreign or collection also not component  property name y7xxfxxxbvxxxxxxxxxxpreprocess
   //not foreign or collection properties  property name y8xxuxxxbvxxxxxxxxxxdefaultc
   //not foreign or collection also not component  property name y8xxuxxxbvxxxxxxxxxxdefaultc
   //not foreign or collection properties  property name y8xxzxxrbvxxxxxxxxxxmargin
   //not foreign or collection also not component  property name y8xxzxxrbvxxxxxxxxxxmargin
   //not foreign or collection properties  property name y9xxzxxrbvxxxxxxxxxxfooter
   //not foreign or collection also not component  property name y9xxzxxrbvxxxxxxxxxxfooter
   //not foreign or collection properties  property name z1xxuxxxbvxxxxxxxxxxlastuser
   //not foreign or collection also not component  property name z1xxuxxxbvxxxxxxxxxxlastuser
   //not foreign or collection properties  property name z2xxfxxxbvxxxxxxxxxxlistbuildc
   //not foreign or collection also not component  property name z2xxfxxxbvxxxxxxxxxxlistbuildc
   //not foreign or collection properties  property name z3xxfxxxbvxxxxxxxxxxlistbuildv
   //not foreign or collection also not component  property name z3xxfxxxbvxxxxxxxxxxlistbuildv
   //not foreign or collection properties  property name z4xxfxxxbvxxxxxxxxxxlistbuilde
   //not foreign or collection also not component  property name z4xxfxxxbvxxxxxxxxxxlistbuilde
   //not foreign or collection properties  property name z5xxzxxrbvxxxxxxxxxxlistbrownc
   //not foreign or collection also not component  property name z5xxzxxrbvxxxxxxxxxxlistbrownc
   //not foreign or collection properties  property name z6xxzxxrbvxxxxxxxxxxlistbrownv
   //not foreign or collection also not component  property name z6xxzxxrbvxxxxxxxxxxlistbrownv
   //not foreign or collection properties  property name z7xxzxxrbvxxxxxxxxxxlistbrowne
   //not foreign or collection also not component  property name z7xxzxxrbvxxxxxxxxxxlistbrowne
   //not foreign or collection properties  property name z8xxuxxxbvxxxxxxxxxxpop3server
   //not foreign or collection also not component  property name z8xxuxxxbvxxxxxxxxxxpop3server
   //not foreign or collection properties  property name z8xxuxxxbvxxxxxxxxxxsmtpserver
   //not foreign or collection also not component  property name z8xxuxxxbvxxxxxxxxxxsmtpserver
   //not foreign or collection properties  property name z9xxuxxxbvxxxxxxxxxxpop3user
   //not foreign or collection also not component  property name z9xxuxxxbvxxxxxxxxxxpop3user
   //not foreign or collection properties  property name z9xxuxxxbvxxxxxxxxxxsmtpuser
   //not foreign or collection also not component  property name z9xxuxxxbvxxxxxxxxxxsmtpuser
   //not foreign or collection properties  property name zaxxuxxxssxxxxxxxxxxpop3pass
   //not foreign or collection also not component  property name zaxxuxxxssxxxxxxxxxxpop3pass
   //not foreign or collection properties  property name zaxxuxxxssxxxxxxxxxxsmtppass
   //not foreign or collection also not component  property name zaxxuxxxssxxxxxxxxxxsmtppass
   //not foreign or collection properties  property name zbxxuxxxbvxxxxxxxxxxsmatcode
   //not foreign or collection also not component  property name zbxxuxxxbvxxxxxxxxxxsmatcode
   //not foreign or collection properties  property name zcxxdwfebvxxxxxxxxxxfyrend
   //not foreign or collection also not component  property name zcxxdwfebvxxxxxxxxxxfyrend
   //not foreign or collection properties  property name zdxxzwfpbvxxxxxxxxxxfperiods
   //not foreign or collection also not component  property name zdxxzwfpbvxxxxxxxxxxfperiods
   //not foreign or collection properties  property name zexxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection also not component  property name zexxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection properties  property name zfxxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection also not component  property name zfxxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection properties  property name zgxxuznxbvxxxxxxxxxxnotes
   //not foreign or collection also not component  property name zgxxuznxbvxxxxxxxxxxnotes
   //not foreign or collection properties  property name zhxxutoxlhxxxxxxxxxxowner
   //not foreign or collection also not component  property name zhxxutoxlhxxxxxxxxxxowner
   //not foreign or collection properties  property name zzxxu2oxxhxxxxxxxxxxowner2
   //not foreign or collection also not component  property name zzxxu2oxxhxxxxxxxxxxowner2



     String lorderColumn = "a0xxukxxbvxxxxxxxxxxclientversion";
     String lorder ="a0xxukxxbvxxxxxxxxxxclientversion asc";
     String lorderDirection = "asc";
     String orderColumnPrev = "";
     String orderDirectionPrev = "";
     int urlIndex=0;





public Yxxxch522xhhxxhxxxxxclientList()
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
         if(maxResultsVal == null){
          maxResultsVal=6;
         }
         setMaxResults(maxResultsVal);
        // added desc order by sid 
         // setOrderColumn does not work see override resultList    
          //setOrderColumn( "yxxxch522xhhxxhxxxxxclient.a0xxukxxbvxxxxxxxxxxclientversion" );
        //a0xxukxxbvxxxxxxxxxxclientversion
        
}

    public Yxxxch522xhhxxhxxxxxclient getYxxxch522xhhxxhxxxxxclient()
    {
        return yxxxch522xhhxxhxxxxxclient;
    }

    public boolean isBitSet(Integer a, Integer n){ 
     if (a == null){
      a=0;
     }
     return (a & (1 << n)) != 0; 
    }


      private String  reportName  = "deYxxxch522xhhxxhxxxxxclient";
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

        Yxxxch522xhhxxhxxxxxclient posApp=getKeyToEntity("03",customIdentity.getOwner2());
        if  (posApp !=null) {
         clientPayByList.add("np"+bundle.getString("ToPay and PickUp"));
         j=j+1;
        }else{
         clientPayByList.add("np"+bundle.getString("Pay and PickUp"));
         j=j+1;
        }
        Yxxxuq591xwwqqhxxxxxrate1f codRate=yxxxuq591xwwqqhxxxxxrate1fList.getKeyStepToEntity("CS","CS");
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

     public List<Yxxxch522xhhxxhxxxxxclient> getResultListMaxSet(Integer maxResultsVal){
      sresults=null;// reset 
      this.maxResultsVal=maxResultsVal;
      return getResultList();
     }

     public List<Yxxxch522xhhxxhxxxxxclient> getSystemResultListMaxSet(Integer maxResultsVal){
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
							"select count(cc) from Yxxxch522xhhxxhxxxxxclient cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;

     }
     public Long getSystemResultCount(){
     // show SYSTEM only not including owner2, affected pagination

		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from Yxxxch522xhhxxhxxxxxclient cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", "SYSTEM")
					.getSingleResult();
                return count;

     }

     public Long getResultCountClosed(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Yxxxch522xhhxxhxxxxxclient cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountReturned(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Yxxxch522xhhxxhxxxxxclient cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mreturn)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountOrdered(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Yxxxch522xhhxxhxxxxxclient cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code).setParameter("flag", mordered)
		.getSingleResult();
                return count;

     }


     public Long getResultCountShipped(){

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Yxxxch522xhhxxhxxxxxclient  cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", mshipped)
	.getSingleResult();
         return count;

     }
     public Long getResultCountInvoiced(){
       //invoiced refers to flag value 64 and may mean approved or ? or invoiced depending on the entity

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Yxxxch522xhhxxhxxxxxclient  cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", minvoiced)
	.getSingleResult();
         return count;

     }



     public Long getResultCountTrialPending(){
                calendar.add(Calendar.DATE, +30); //client 30 days in advance, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();
		Long count =  (Long)getEntityManager()
		 .createQuery(
		 "select count(cc) from Yxxxch522xhhxxhxxxxxclient  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type ")
		 .setParameter("type", "TrialPending").setParameter("nKeyName","01")
		 .getSingleResult();
                return count;

     }

     public Long getResultCountTrialExpiring(){
                calendar.add(Calendar.DATE, +30); //30 days in advance, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();
		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Yxxxch522xhhxxhxxxxxclient  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zexxzzfxhhxxxxxxxxxxstatusfl <> :flag AND cast(cc.f8xxcxxxlvxxxxxxxxxxlicenseend AS date) < cast(:searchDate AS date) ")
		.setParameter("searchDate", searchDate).setParameter("flag", mclosed).setParameter("nKeyName","01")
		.getSingleResult();
                return count;

     }

     public Long getResultCountNotActivated(){
                calendar.add(Calendar.DATE, -3); //3 days in past, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Yxxxch522xhhxxhxxxxxclient  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date)  ")
		.setParameter("searchDate", searchDate).setParameter("flag", mordered).setParameter("nKeyName","01")
		.getSingleResult();
                return count;

     }

     public Long getResultCountSiteIdle(){
                calendar.add(Calendar.DATE, -30); //30 days in past, can check further for 15 days/7 days/ expiry
                Date searchDate= calendar.getTime();


		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from Yxxxch522xhhxxhxxxxxclient  cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zexxzzfxhhxxxxxxxxxxstatusfl <> :flag AND cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date)  ")
					.setParameter("searchDate", searchDate).setParameter("flag", mclosed).setParameter("nKeyName","01")
					.getSingleResult();
                return count;

     }
   //client only


     public Yxxxch522xhhxxhxxxxxclient getKeyToEntity(String key,String owner2){
      // another site restrict to raaspi site  added for item
      Yxxxch522xhhxxhxxxxxclient entity=null;
      List<Yxxxch522xhhxxhxxxxxclient> results=null;
      try{
       results = getEntityManager()
        .createQuery(
          "select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )")
           .setParameter("nKeyName",key)
           .setParameter("owner2", owner2)
           .getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("client")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("client")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 

   //client and Item only






     public List<Yxxxch522xhhxxhxxxxxclient> getSystemResultList(){
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
		List<Yxxxch522xhhxxhxxxxxclient> results =  getEntityManager()
					.createQuery(
							"select cc from Yxxxch522xhhxxhxxxxxclient  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%')) or lower(zgxxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukxxbvxxxxxxxxxxclientversion) between :start and :end) ) order by "+ lorder)
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
             //employee add search
              //all others
                   //statusfield


                 //:: type cast operator conflicts with the JPA so use cast(:searchDate AS date) dateField zfxxcztxlxxxxxxxxxxxstatusfldt statflgdt zfxxcztxlxxxxxxxxxxxstatusfldt
		   sresults =  getEntityManager()
					.createQuery(
		   "select cc from Yxxxch522xhhxxhxxxxxclient  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (:searchStatus is null  or cc.zexxzzfxhhxxxxxxxxxxstatusfl = :searchStatus) ) and (lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%')) or lower(zgxxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%'))) and (cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and lower(a0xxukxxbvxxxxxxxxxxclientversion) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                    .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
             // all others end
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
    * The following method added since hql seems to be dropping order by in some queries (perioddates getResultList() )and where order is important
    * @param args -none
    * @return List<Yxxxuq632xwwqqhxxxxxperioddates>
    * @exception to be added
    * @see getResultList()
    */

     public List<Yxxxch522xhhxxhxxxxxclient> getSortedResultList(){
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
               "select cc from Yxxxch522xhhxxhxxxxxclient  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2  ) order by "+ lorder)
                 .setParameter("owner2", owner2Code)
                  .getResultList();
       return sresults;
      }


       /**
    * The following method overrides seam method because setOrder did not work 
    * @param args -none
    * @return List<Yxxxch522xhhxxhxxxxxclient>
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

     public List<Yxxxch522xhhxxhxxxxxclient> getResultList(){
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
	List<Yxxxch522xhhxxhxxxxxclient> results =  getEntityManager()
	.createQuery(
	"select cc from Yxxxch522xhhxxhxxxxxclient  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%')) or lower(zgxxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukxxbvxxxxxxxxxxclientversion) between :start and :end) ) order by "+ lorder)
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
             //below non options, employee, add search
              //all others
                   //statusfield


                 //:: type cast operator conflicts with the JPA so use cast(:searchDate AS date) dateField zfxxcztxlxxxxxxxxxxxstatusfldt statflgdt zfxxcztxlxxxxxxxxxxxstatusfldt
	   sresults =  getEntityManager()
	   .createQuery(
                    //these have statusfields but some needs extra search
		    "select cc from Yxxxch522xhhxxhxxxxxclient  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((:searchStatus is null  or cc.zexxzzfxhhxxxxxxxxxxstatusfl = :searchStatus) ) and ((lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%')) or lower(zgxxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukxxbvxxxxxxxxxxclientversion) like lower(concat('%',:searchVal,'%')))) and (cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and lower(a0xxukxxbvxxxxxxxxxxclientversion) between :start and :end) ) order by "+ lorder)
                    .                     setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus)
                                       .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                   .getResultList();
                              // all others end
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

     public Yxxxch522xhhxxhxxxxxclient getSidSToEntity(String sidS){
      return getSidToEntity(Integer.parseInt(sidS));//
     }

     public Yxxxch522xhhxxhxxxxxclient getSidToEntity(Integer sid){
      Yxxxch522xhhxxhxxxxxclient entity=null;
      List<Yxxxch522xhhxxhxxxxxclient> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("client")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("client")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 













	public List<Yxxxch522xhhxxhxxxxxclient> getFlaggedAsList(int flag) {
		// will return objects matching flag 
		return getEntityManager()
				.createQuery(
						"select cc from Yxxxch522xhhxxhxxxxxclient cc where (cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Yxxxch522xhhxxhxxxxxclient> getNotFlaggedAsList(int flag) {
		// will return objects not matching flag 

		return getEntityManager()
				.createQuery(
						"select cc from Yxxxch522xhhxxhxxxxxclient cc where (cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Yxxxch522xhhxxhxxxxxclient> getOldByList(int days) {
	// will return objects statusfldt < today-days
        calendar.add(Calendar.DATE, -days); //xx days in past, can check further for 15 days/7 days/ expiry
        Date searchDate= calendar.getTime();

	return getEntityManager()
	 .createQuery(
	  "select cc from Yxxxch522xhhxxhxxxxxclient cc where (cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
	   .setParameter("searchDate", searchDate).setParameter("owner2", owner2Code).getResultList();

	}






         public Yxxxch522xhhxxhxxxxxclient getKeyToEntity(String key){
      Yxxxch522xhhxxhxxxxxclient entity=null;
      List<Yxxxch522xhhxxhxxxxxclient> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("client")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("client")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+" "+bundle.getString("found"),""));
          // end user may see it,FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          // FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          customIdentity.setHoldValue3(""+results.size());//caller may examine this
      }
      return results.get(0);

    } 


     public Yxxxch522xhhxxhxxxxxclient getKeyContainsToEntity(String key){
      Yxxxch522xhhxxhxxxxxclient entity=null;
      List<Yxxxch522xhhxxhxxxxxclient> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion like :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key+'%')
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("client")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("client")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
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
      String value= getEntityManager().createQuery(" select a0xxukxxbvxxxxxxxxxxclientversion from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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
      String value= getEntityManager().createQuery(" select a0xxukxxbvxxxxxxxxxxclientversion||'/'||zzxxu2oxxhxxxxxxxxxxowner2 from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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
 
      for (Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient : getSuggestList(userInput)) {
         ret.add(yxxxch522xhhxxhxxxxxclient.getA0xxukxxbvxxxxxxxxxxclientversion());
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
     public List<Yxxxch522xhhxxhxxxxxclient> getSuggestList(String prefix,String hideTypePrefix) {
     // getSuggestList is called when non key values are also needed like item key, its price etc 
     // when is keyfield blank probably never for keyAutogen
     
			return getEntityManager().createQuery(" select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion >=:keyOfEntity  AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix )  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukxxbvxxxxxxxxxxclientversion  ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
	}
   





	public List<Yxxxch522xhhxxhxxxxxclient> getSystemSuggestList(String prefix) {
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  order by cc.a0xxukxxbvxxxxxxxxxxclientversion")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukxxbvxxxxxxxxxxclientversion")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                return null;

        }

     public List<Yxxxch522xhhxxhxxxxxclient> getSuggestList(String prefix) {
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

			 return getEntityManager().createQuery(" select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxukxxbvxxxxxxxxxxclientversion  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();


	}
     public List<Yxxxch522xhhxxhxxxxxclient> getNextSids(Integer sid){
      sresults=null;// reset 
      List<Yxxxch522xhhxxhxxxxxclient> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and cc.a0xxuobxbxxxxxxxxxxxsid >=:sid order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).setParameter("sid", sid)
					.getResultList();
      return results;
     }
     public List<Integer> getAllSids(){
      List<Integer> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc.a0xxuobxbxxxxxxxxxxxsid from Yxxxch522xhhxxhxxxxxclient cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).getResultList();
      return results;
     }










	public List<Yxxxch522xhhxxhxxxxxclient> getClientsList() {
		return getEntityManager()
		.createQuery(
		 "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").getResultList();

	}

                 public void nextDataOwner2Code() {
                   List<Yxxxch522xhhxxhxxxxxclient> sresults=null;
                  if(yxxxch522xhhxxhxxxxxclientHome.getYxxxch522xhhxxhxxxxxclientFrom().isEmpty()){
                   sresults=getEntityManager()
                              .createQuery(
                                "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2 order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01")
                                    .setParameter("nextOwner2", dataOwner2Code).getResultList();
                   if(sresults.size() > 5){
                    dataOwner2Code=sresults.get(5).getZzxxu2oxxhxxxxxxxxxxowner2();
                   }// otherwise same value
                 }else{
                   sresults=getEntityManager()
                              .createQuery(
                                "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2 and cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").setParameter("type", yxxxch522xhhxxhxxxxxclientHome.getYxxxch522xhhxxhxxxxxclientFrom())
                                    .setParameter("nextOwner2", dataOwner2Code).getResultList();
                   if(sresults.size() > 5){
                    dataOwner2Code=sresults.get(5).getZzxxu2oxxhxxxxxxxxxxowner2();
                   }// otherwise same value
                 }
                }
                 public void prevDataOwner2Code() {
                   List<Yxxxch522xhhxxhxxxxxclient> sresults=null;
                   sresults=getEntityManager()
                              .createQuery(
                                "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 < :nextOwner2 order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01")
                                    .setParameter("nextOwner2", dataOwner2Code).getResultList();
                   if(sresults.size() > 5){
                    dataOwner2Code=sresults.get(0).getZzxxu2oxxhxxxxxxxxxxowner2();
                   }// otherwise same value
                 }

	public List<Yxxxch522xhhxxhxxxxxclient> getClientsList(String prefix) {
                    yxxxch522xhhxxhxxxxxclientHome.setYxxxch522xhhxxhxxxxxclientFrom(prefix);
                    if(prefix.equals("TrialPending")){
		return getEntityManager()
		.createQuery(
		 "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.f6xxuxxxlvxxxxxxxxxxlicensetype = :type   and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2  order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").setParameter("nextOwner2", dataOwner2Code).setParameter("type", "TrialPending").getResultList();
                    }
		return getEntityManager()
		.createQuery(
		 "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 >= :nextOwner2  order by cc.zzxxu2oxxhxxxxxxxxxxowner2").setParameter("nKeyName","01").setParameter("nextOwner2", dataOwner2Code).getResultList();
	}

	public List<Yxxxch522xhhxxhxxxxxclient> getOwner2ClientList(String owner2Code) {
		return getEntityManager()
		.createQuery(
		 "select cc from Yxxxch522xhhxxhxxxxxclient cc  where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName  and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.zzxxu2oxxhxxxxxxxxxxowner2")
                   .setParameter("nKeyName","01").setParameter("owner2", owner2Code).getResultList();

	}


	public boolean isSSOActive() {
         try {
                 Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
					.createQuery(
							"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
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

	public List<String> gethhxxhxxxxxclientKeyList() {
                 // xxxxxxxxxa0xxuobxbxxxxxxxxxxxsid  java.lang.String a0xxukxxbvxxxxxxxxxxclientversion
    
		       String enteredValue = "";
                        //order case insensitive
			return getEntityManager().createQuery("select cc.a0xxukxxbvxxxxxxxxxxclientversion from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion >=:keyOfEntity   AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')  order by lower(cc.a0xxukxxbvxxxxxxxxxxclientversion) ")
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
		            parameters.put("show002h", "#{messages[Clientversion]}");
		            parameters.put("show003h", "#{messages[Serialnum]}");
		            parameters.put("show004h", "#{messages[Enterprisecompanyna]}");
		            parameters.put("show005h", "#{messages[Descript]}");
		            parameters.put("show006h", "#{messages[Addrl1]}");
		            parameters.put("show007h", "#{messages[Addrl2]}");
		            parameters.put("show008h", "#{messages[Addrl3]}");
		            parameters.put("show009h", "#{messages[City]}");
		            parameters.put("show010h", "#{messages[Provnstate]}");
		            parameters.put("show011h", "#{messages[Countryname]}");
		            parameters.put("show012h", "#{messages[Pzcode]}");
		            parameters.put("show013h", "#{messages[Phoneo]}");
		            parameters.put("show014h", "#{messages[Phoneh]}");
		            parameters.put("show015h", "#{messages[Phonec]}");
		            parameters.put("show016h", "#{messages[Phonex]}");
		            parameters.put("show017h", "#{messages[Lanaddr]}");
		            parameters.put("show018h", "#{messages[Wanaddr]}");
		            parameters.put("show019h", "#{messages[Lmailaddr]}");
		            parameters.put("show020h", "#{messages[Imailaddr]}");
		            parameters.put("show021h", "#{messages[Rmailaddr]}");
		            parameters.put("show022h", "#{messages[Intaddr]}");
		            parameters.put("show023h", "#{messages[Inraddr]}");
		            parameters.put("show024h", "#{messages[Enterprisecompcode]}");
		            parameters.put("show025h", "#{messages[Enterprisecompsize]}");
		            parameters.put("show026h", "#{messages[Apiclientid]}");
		            parameters.put("show027h", "#{messages[Apiclientsecret]}");
		            parameters.put("show028h", "#{messages[Barcsize]}");
		            parameters.put("show029h", "#{messages[Level]}");
		            parameters.put("show030h", "#{messages[Poskipp]}");
		            parameters.put("show031h", "#{messages[Looseit]}");
		            parameters.put("show032h", "#{messages[Jobskip]}");
		            parameters.put("show033h", "#{messages[Cartonfl]}");
		            parameters.put("show034h", "#{messages[Picklist]}");
		            parameters.put("show035h", "#{messages[Licensetype]}");
		            parameters.put("show036h", "#{messages[Licensestart]}");
		            parameters.put("show037h", "#{messages[Licenseend]}");
		            parameters.put("show038h", "#{messages[Proddesc]}");
		            parameters.put("show039h", "#{messages[Prodcode]}");
		            parameters.put("show040h", "#{messages[Njob]}");
		            parameters.put("show041h", "#{messages[Nmateria]}");
		            parameters.put("show042h", "#{messages[Nactivity]}");
		            parameters.put("show043h", "#{messages[Nbutt]}");
		            parameters.put("show044h", "#{messages[Ncustome]}");
		            parameters.put("show045h", "#{messages[Ncontact]}");
		            parameters.put("show046h", "#{messages[Nvendor]}");
		            parameters.put("show047h", "#{messages[Nemployee]}");
		            parameters.put("show048h", "#{messages[Nschedule]}");
		            parameters.put("show049h", "#{messages[Nreject]}");
		            parameters.put("show050h", "#{messages[Nreturn]}");
		            parameters.put("show051h", "#{messages[Ncode]}");
		            parameters.put("show052h", "#{messages[Manufid]}");
		            parameters.put("show053h", "#{messages[Bartype]}");
		            parameters.put("show054h", "#{messages[Cadtype]}");
		            parameters.put("show055h", "#{messages[Cartype]}");
		            parameters.put("show056h", "#{messages[Shitype]}");
		            parameters.put("show057h", "#{messages[Reptype]}");
		            parameters.put("show058h", "#{messages[Loctype]}");
		            parameters.put("show059h", "#{messages[Barcol]}");
		            parameters.put("show060h", "#{messages[Carcol]}");
		            parameters.put("show061h", "#{messages[Cadcol]}");
		            parameters.put("show062h", "#{messages[Shicol]}");
		            parameters.put("show063h", "#{messages[Repcol]}");
		            parameters.put("show064h", "#{messages[Loccol]}");
		            parameters.put("show065h", "#{messages[Altseria]}");
		            parameters.put("show066h", "#{messages[Countrycode]}");
		            parameters.put("show067h", "#{messages[Naltseri]}");
		            parameters.put("show068h", "#{messages[Scrcolor]}");
		            parameters.put("show069h", "#{messages[Hilcolor]}");
		            parameters.put("show070h", "#{messages[Textcolor]}");
		            parameters.put("show071h", "#{messages[Baccolor]}");
		            parameters.put("show072h", "#{messages[Datetype]}");
		            parameters.put("show073h", "#{messages[Currsymb]}");
		            parameters.put("show074h", "#{messages[Currcode]}");
		            parameters.put("show075h", "#{messages[Prinbar]}");
		            parameters.put("show076h", "#{messages[Barprint]}");
		            parameters.put("show077h", "#{messages[Carprint]}");
		            parameters.put("show078h", "#{messages[Cadprint]}");
		            parameters.put("show079h", "#{messages[Locprint]}");
		            parameters.put("show080h", "#{messages[Shiprint]}");
		            parameters.put("show081h", "#{messages[Repprint]}");
		            parameters.put("show082h", "#{messages[Barprty]}");
		            parameters.put("show083h", "#{messages[Repprty]}");
		            parameters.put("show084h", "#{messages[Carprty]}");
		            parameters.put("show085h", "#{messages[Cadprty]}");
		            parameters.put("show086h", "#{messages[Shiprty]}");
		            parameters.put("show087h", "#{messages[Locprty]}");
		            parameters.put("show088h", "#{messages[Altselen]}");
		            parameters.put("show089h", "#{messages[Custolen]}");
		            parameters.put("show090h", "#{messages[Carcsize]}");
		            parameters.put("show091h", "#{messages[Cadcsize]}");
		            parameters.put("show092h", "#{messages[Shicsize]}");
		            parameters.put("show093h", "#{messages[Repcsize]}");
		            parameters.put("show094h", "#{messages[Loccsize]}");
		            parameters.put("show095h", "#{messages[Cs]}");
		            parameters.put("show096h", "#{messages[Nconftyp]}");
		            parameters.put("show097h", "#{messages[Nlocatio]}");
		            parameters.put("show098h", "#{messages[Ndivcode]}");
		            parameters.put("show099h", "#{messages[Ndepcode]}");
		            parameters.put("show100h", "#{messages[Naddcode]}");
		            parameters.put("show101h", "#{messages[Nfloor]}");
		            parameters.put("show102h", "#{messages[Nroom]}");
		            parameters.put("show103h", "#{messages[Nrack]}");
		            parameters.put("show104h", "#{messages[Menutype]}");
		            parameters.put("show105h", "#{messages[Padtype]}");
		            parameters.put("show106h", "#{messages[Nrate1ta]}");
		            parameters.put("show107h", "#{messages[Nrate2ta]}");
		            parameters.put("show108h", "#{messages[Defconft]}");
		            parameters.put("show109h", "#{messages[Beepsou]}");
		            parameters.put("show110h", "#{messages[Confirm]}");
		            parameters.put("show111h", "#{messages[Linefeed]}");
		            parameters.put("show112h", "#{messages[Refbaradj]}");
		            parameters.put("show113h", "#{messages[Shibaradj]}");
		            parameters.put("show114h", "#{messages[Cusbaradj]}");
		            parameters.put("show115h", "#{messages[Locbaradj]}");
		            parameters.put("show116h", "#{messages[Carbaradj]}");
		            parameters.put("show117h", "#{messages[Ncorder]}");
		            parameters.put("show118h", "#{messages[Nsperson]}");
		            parameters.put("show119h", "#{messages[Prompti]}");
		            parameters.put("show120h", "#{messages[Customerquotenb]}");
		            parameters.put("show121h", "#{messages[Customerquoten]}");
		            parameters.put("show122h", "#{messages[Customerquotena]}");
		            parameters.put("show123h", "#{messages[Customerordernb]}");
		            parameters.put("show124h", "#{messages[Customerordern]}");
		            parameters.put("show125h", "#{messages[Customerorderna]}");
		            parameters.put("show126h", "#{messages[Vendorordernb]}");
		            parameters.put("show127h", "#{messages[Vendorordern]}");
		            parameters.put("show128h", "#{messages[Vendororderna]}");
		            parameters.put("show129h", "#{messages[Jobnb]}");
		            parameters.put("show130h", "#{messages[Employeeordernb]}");
		            parameters.put("show131h", "#{messages[Jobn]}");
		            parameters.put("show132h", "#{messages[Employeeordern]}");
		            parameters.put("show133h", "#{messages[Employeeorderna]}");
		            parameters.put("show134h", "#{messages[Jobna]}");
		            parameters.put("show135h", "#{messages[Customerinvoicenb]}");
		            parameters.put("show136h", "#{messages[Customerinvoicen]}");
		            parameters.put("show137h", "#{messages[Customerinvoicena]}");
		            parameters.put("show138h", "#{messages[Vendorinvoicenb]}");
		            parameters.put("show139h", "#{messages[Vendorinvoicen]}");
		            parameters.put("show140h", "#{messages[Vendorinvoicena]}");
		            parameters.put("show141h", "#{messages[Customerpicknb]}");
		            parameters.put("show142h", "#{messages[Customerpickn]}");
		            parameters.put("show143h", "#{messages[Customerpaymntnb]}");
		            parameters.put("show144h", "#{messages[Customerpaymntn]}");
		            parameters.put("show145h", "#{messages[Customerpaymntna]}");
		            parameters.put("show146h", "#{messages[Customerpickna]}");
		            parameters.put("show147h", "#{messages[Vendorpaymntnb]}");
		            parameters.put("show148h", "#{messages[Vendorquotenb]}");
		            parameters.put("show149h", "#{messages[Vendorpaymntn]}");
		            parameters.put("show150h", "#{messages[Vendorquoten]}");
		            parameters.put("show151h", "#{messages[Vendorpaymntna]}");
		            parameters.put("show152h", "#{messages[Taskn]}");
		            parameters.put("show153h", "#{messages[Taskna]}");
		            parameters.put("show154h", "#{messages[Tasknb]}");
		            parameters.put("show155h", "#{messages[Vendorquotena]}");
		            parameters.put("show156h", "#{messages[Vendorchqnb]}");
		            parameters.put("show157h", "#{messages[Arseqb]}");
		            parameters.put("show158h", "#{messages[Vendorchqn]}");
		            parameters.put("show159h", "#{messages[Arseq]}");
		            parameters.put("show160h", "#{messages[Vendorchqna]}");
		            parameters.put("show161h", "#{messages[Arseqa]}");
		            parameters.put("show162h", "#{messages[Apseqb]}");
		            parameters.put("show163h", "#{messages[Apseq]}");
		            parameters.put("show164h", "#{messages[Apseqa]}");
		            parameters.put("show165h", "#{messages[Glseqb]}");
		            parameters.put("show166h", "#{messages[Glseq]}");
		            parameters.put("show167h", "#{messages[Glseqa]}");
		            parameters.put("show168h", "#{messages[Paseqb]}");
		            parameters.put("show169h", "#{messages[Paseq]}");
		            parameters.put("show170h", "#{messages[Paseqa]}");
		            parameters.put("show171h", "#{messages[Icseqb]}");
		            parameters.put("show172h", "#{messages[Icseq]}");
		            parameters.put("show173h", "#{messages[Icseqa]}");
		            parameters.put("show174h", "#{messages[Joseqb]}");
		            parameters.put("show175h", "#{messages[Joseq]}");
		            parameters.put("show176h", "#{messages[Joseqa]}");
		            parameters.put("show177h", "#{messages[Sglentry]}");
		            parameters.put("show178h", "#{messages[Tax1code]}");
		            parameters.put("show179h", "#{messages[Tax2code]}");
		            parameters.put("show180h", "#{messages[Tax3code]}");
		            parameters.put("show181h", "#{messages[Ndecimal]}");
		            parameters.put("show182h", "#{messages[Edipassw]}");
		            parameters.put("show183h", "#{messages[Intpassw]}");
		            parameters.put("show184h", "#{messages[Inrpassw]}");
		            parameters.put("show185h", "#{messages[Imlpassw]}");
		            parameters.put("show186h", "#{messages[Rmlpassw]}");
		            parameters.put("show187h", "#{messages[Lmlpassw]}");
		            parameters.put("show188h", "#{messages[Hospassw]}");
		            parameters.put("show189h", "#{messages[Lanpassw]}");
		            parameters.put("show190h", "#{messages[Wanpassw]}");
		            parameters.put("show191h", "#{messages[Ashostid]}");
		            parameters.put("show192h", "#{messages[Hdstyle]}");
		            parameters.put("show193h", "#{messages[Mtstyle]}");
		            parameters.put("show194h", "#{messages[Ststyle]}");
		            parameters.put("show195h", "#{messages[Dtstyle]}");
		            parameters.put("show196h", "#{messages[Ftstyle]}");
		            parameters.put("show197h", "#{messages[Defaultr]}");
		            parameters.put("show198h", "#{messages[Dbname]}");
		            parameters.put("show199h", "#{messages[Rootdir]}");
		            parameters.put("show200h", "#{messages[Keyorder]}");
		            parameters.put("show201h", "#{messages[Currbusdat]}");
		            parameters.put("show202h", "#{messages[Lastbusdat]}");
		            parameters.put("show203h", "#{messages[Currcaldat]}");
		            parameters.put("show204h", "#{messages[Lastcaldat]}");
		            parameters.put("show205h", "#{messages[Preprocess]}");
		            parameters.put("show206h", "#{messages[Defaultc]}");
		            parameters.put("show207h", "#{messages[Margin]}");
		            parameters.put("show208h", "#{messages[Footer]}");
		            parameters.put("show209h", "#{messages[Lastuser]}");
		            parameters.put("show210h", "#{messages[Listbuildc]}");
		            parameters.put("show211h", "#{messages[Listbuildv]}");
		            parameters.put("show212h", "#{messages[Listbuilde]}");
		            parameters.put("show213h", "#{messages[Listbrownc]}");
		            parameters.put("show214h", "#{messages[Listbrownv]}");
		            parameters.put("show215h", "#{messages[Listbrowne]}");
		            parameters.put("show216h", "#{messages[Pop3server]}");
		            parameters.put("show217h", "#{messages[Smtpserver]}");
		            parameters.put("show218h", "#{messages[Pop3user]}");
		            parameters.put("show219h", "#{messages[Smtpuser]}");
		            parameters.put("show220h", "#{messages[Pop3pass]}");
		            parameters.put("show221h", "#{messages[Smtppass]}");
		            parameters.put("show222h", "#{messages[Smatcode]}");
		            parameters.put("show223h", "#{messages[Fyrend]}");
		            parameters.put("show224h", "#{messages[Fperiods]}");
		            parameters.put("show225h", "#{messages[Statusfl]}");
		            parameters.put("show226h", "#{messages[Statusfldt]}");
		            parameters.put("show227h", "#{messages[Notes]}");
		            parameters.put("show228h", "#{messages[Owner]}");
		            parameters.put("show229h", "#{messages[Owner2]}");
                 // done with labels, now load corresponding values from truefalses db or if new create 
                 loadTruefalses(); //sets bcontinue
                 // if found bcontinue is true and  report parameters shownnn are already set from db
                 // if not found then create db entry and then load default values for report prefix type
                 // and then persist truefalse
                 // and call loadTruefalses() again 
                 if (!bcontinue){//not found
                    yxxxch5a1xhhxxhxxxxxtruefalseHome.clearInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse=yxxxch5a1xhhxxhxxxxxtruefalseHome.getInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA0xxukrdbvxxxxxxxxxxtablename("client");
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxuxxxbvxxxxxxxxxxqualifier(reportNamePrefix);
                  //default
                 if(reportNamePrefix.equals("de")){ 
                   //yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false);//hide sid 
                 }
                 //demographic
                 if (reportNamePrefix.equals("dg")){
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
                  FacesMessage.SEVERITY_WARN,bundle.getString("client")+" "+bundle.getString("report")+" "+bundle.getString("generate")+" "+bundle.getString("failed")+" "+e.getMessage(),""));
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
                      .setParameter("tableName", "client")
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
			    parameters.put("show192", true);
			    parameters.put("show193", true);
			    parameters.put("show194", true);
			    parameters.put("show195", true);
			    parameters.put("show196", true);
			    parameters.put("show197", true);
			    parameters.put("show198", true);
			    parameters.put("show199", true);
			    parameters.put("show200", true);
			    parameters.put("show201", true);
			    parameters.put("show202", true);
			    parameters.put("show203", true);
			    parameters.put("show204", true);
			    parameters.put("show205", true);
			    parameters.put("show206", true);
			    parameters.put("show207", true);
			    parameters.put("show208", true);
			    parameters.put("show209", true);
			    parameters.put("show210", true);
			    parameters.put("show211", true);
			    parameters.put("show212", true);
			    parameters.put("show213", true);
			    parameters.put("show214", true);
			    parameters.put("show215", true);
			    parameters.put("show216", true);
			    parameters.put("show217", true);
			    parameters.put("show218", true);
			    parameters.put("show219", true);
			    parameters.put("show220", true);
			    parameters.put("show221", true);
			    parameters.put("show222", true);
			    parameters.put("show223", true);
			    parameters.put("show224", true);
			    parameters.put("show225", true);
			    parameters.put("show226", true);
			    parameters.put("show227", true);
			    parameters.put("show228", true);
			    parameters.put("show229", true);
			    parameters.put("show230", true);
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
* header("X-SMTPAPI",headers) for m:header name="X-SMTPAPI" value="#{yxxxch522xhhxxhxxxxxclientList.headers}" 
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
         String subjectTemplate = "Text Message from 4.0.0 Mail - " + uuid;
         String version = "simple-mail";
         String subject = "Text Message from " + version + " Mail - " + uuid;
         String useTemplate="clientMailingContent.fmt";
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
         subjectTemplate=bundle.getString("Transaction")+" "+bundle.getString("Receipt")+" "+bundle.getString("from")+" "+owner2Code;
         //emailingContent for emailing and attaching report as receipt 
          toName="";// mailingAddress set by esend using mailTo, headers are empty todo allow multilingual
          toAddress=mailingAddress;
          if(siteAddress05 !=null && !siteAddress05.isEmpty()){
           toAddress=siteAddress05;// avoid invalid email addr ie no email addr for site domain
          }
          useTemplate="clienteMailingContent.fmt";
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
                            new InputStreamAttachment("client.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("client.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("client.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("client.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
          //reportName="xxYxxxch522xhhxxhxxxxxclient";  holds selected report
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

         setClientEMail("doNotReply@"+owner2Code+customIdentity.getTld()); 
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
           setClientEMail("doNotReply@"+owner2Code+customIdentity.getTld()); 
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_WARN,bundle.getString("client")+" "+bundle.getString("email")+" "+bundle.getString("address")+" "+bundle.getString("is")+" "+bundle.getString("missing"),""));

          }else{
           setClientEMail(client.getD4xxhxxrbv24xxxxxxxximailaddr());
          }
         } 
         // from uses clientEMail,cc uses eMailingAddress1, to uses mailingAddress
         //renderer.render("/clienteMailingContent.xhtml");
         emailRender("/clienteMailingContent.xhtml","e");
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
   public List<Yxxxch522xhhxxhxxxxxclient> getResultList(){
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
