




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

@Named("jxxxbh400xwwqqhxxxxxemployeeList")
@ViewScoped
public class Jxxxbh400xwwqqhxxxxxemployeeList implements Serializable
{
   private Logger log = Logger.getLogger(Jxxxbh400xwwqqhxxxxxemployee.class.getCanonicalName());
	@Inject
	Identity identity;
   @Inject R3RestClient r3RestClient;

   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
    @Inject 
    Jxxxbh400xwwqqhxxxxxemployeeHome jxxxbh400xwwqqhxxxxxemployeeHome;
    @Inject 
    Yxxxuq1n1xwwqqqxxxxxblobdataHome yxxxuq1n1xwwqqqxxxxxblobdataHome;

    @Inject 
    Yxxxuh566xwwqqwxxxxxuserList yxxxuh566xwwqqwxxxxxuserList;




	 @Inject 
	 Yxxxuh566xwwqqwxxxxxuserHome yxxxuh566xwwqqwxxxxxuserHome;
	 private Yxxxuh566xwwqqwxxxxxuser user;
         @Inject
         Yxxxch522xhhxxhxxxxxclientHome yxxxch522xhhxxhxxxxxclientHome;
      @Inject
      Jxxxuq300xwwqqhxxxxxvendorHome jxxxuq300xwwqqhxxxxxvendorHome;
      @Inject
      Jxxxuq201xwwqqhxxxxxcustomerHome jxxxuq201xwwqqhxxxxxcustomerHome;
	@Inject 
	Fxxxuq1ggxwwqqhxxxxxmembersgroupHome fxxxuq1ggxwwqqhxxxxxmembersgroupHome;
	private Fxxxuq1ggxwwqqhxxxxxmembersgroup fxxxuq1ggxwwqqhxxxxxmembersgroup;
      @Inject
      Yxxxuq1m1xwwqqqxxxxxclobdataHome yxxxuq1m1xwwqqqxxxxxclobdataHome;
      @Inject
      Yxxxuq1m1xwwqqqxxxxxclobdataList yxxxuq1m1xwwqqqxxxxxclobdataList;
      private Yxxxuq1m1xwwqqqxxxxxclobdata yxxxuq1m1xwwqqqxxxxxclobdata;


	 @Inject 
	 Yxxxch5a1xhhxxhxxxxxtruefalseHome yxxxch5a1xhhxxhxxxxxtruefalseHome;
	 private Yxxxch5a1xhhxxhxxxxxtruefalse yxxxch5a1xhhxxhxxxxxtruefalse;

    @Inject CustomIdentity customIdentity; 
     private DualListModel<Jxxxbh400xwwqqhxxxxxemployee> toDualSuggestList;
      private DualListModel<Jxxxbh400xwwqqhxxxxxemployee> ccDualSuggestListE;
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
                int listSize=getwwqqhxxxxxemployeeKeyList().size();
                start=  listSize==0 ? "0" : String.valueOf(getwwqqhxxxxxemployeeKeyList().get(0)) ;
                end=    listSize==0 ? "0" : String.valueOf(getwwqqhxxxxxemployeeKeyList().get(listSize-1));

          // initialize mailrelay0ff
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
           List<Jxxxbh400xwwqqhxxxxxemployee> source = new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
           source=this.getSuggestList("email");
           List<Jxxxbh400xwwqqhxxxxxemployee> target = new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
           toDualSuggestList = new DualListModel<Jxxxbh400xwwqqhxxxxxemployee>(source, target);

            List<Jxxxbh400xwwqqhxxxxxemployee> sourceE = new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
            sourceE=getSuggestList("emailE");
            List<Jxxxbh400xwwqqhxxxxxemployee> targetE = new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
            ccDualSuggestListE = new DualListModel<Jxxxbh400xwwqqhxxxxxemployee>(sourceE, targetE);
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
     List<Jxxxbh400xwwqqhxxxxxemployee> sresults=null;
     List<Jxxxbh400xwwqqhxxxxxemployee> eresults2=null;

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

     private static final String EJBQL = "select jxxxbh400xwwqqhxxxxxemployee from Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee "  ;

     private static final String[] RESTRICTIONS = {
        "lower(jxxxbh400xwwqqhxxxxxemployee.a0xxuktxbvxxxxxxxxxxemployee) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.a0xxuktxbvxxxxxxxxxxemployee},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.b1xxuxxxbv21xxxxxxxxtitle) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.b1xxuxxxbv21xxxxxxxxtitle},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.b2xxuxxrbx22xxxxxxxxjobtitle) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.b2xxuxxrbx22xxxxxxxxjobtitle},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.b3xxuslnbvixxxxxxxxxlastname) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.b3xxuslnbvixxxxxxxxxlastname},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.b4xxu2fnbvxxxxxxxxxxfirstname) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.b4xxu2fnbvxxxxxxxxxxfirstname},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.b5xxuxxrbvxxxxxxxxxxmiddlenam) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.b5xxuxxrbvxxxxxxxxxxmiddlenam},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.c4xxuz1xbv04xxxxxxxxcusttax1) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.c4xxuz1xbv04xxxxxxxxcusttax1},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.c5xxuz2xbv05xxxxxxxxcusttax2) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.c5xxuz2xbv05xxxxxxxxcusttax2},'%'))",









        "lower(jxxxbh400xwwqqhxxxxxemployee.m1xxh3pobv27xxxxxxxxphoneo) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.m1xxh3pobv27xxxxxxxxphoneo},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.m2xxh4phbv27xxxxxxxxphoneh) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.m2xxh4phbv27xxxxxxxxphoneh},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.m3xxh5pcbv27xxxxxxxxphonec) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.m3xxh5pcbv27xxxxxxxxphonec},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.m4xxhxxrbx27xxxxxxxxphonex) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.m4xxhxxrbx27xxxxxxxxphonex},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n1xxhxxrbx19xxxxxxxxlanaddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n1xxhxxrbx19xxxxxxxxlanaddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n2xxhxxrbx25xxxxxxxxwanaddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n2xxhxxrbx25xxxxxxxxwanaddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n3xxhxxrbx44xxxxxxxxlmailaddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n3xxhxxrbx44xxxxxxxxlmailaddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n4xxhxxrbv24xxxxxxxximailaddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n4xxhxxrbv24xxxxxxxximailaddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n5xxuxxrbxxxxxxxxxxxrmailaddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n5xxuxxrbxxxxxxxxxxxrmailaddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n6xxhxxrbx23xxxxxxxxintaddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n6xxhxxrbx23xxxxxxxxintaddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.n7xxuxxrbxxxxxxxxxxxinraddr) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.n7xxuxxrbxxxxxxxxxxxinraddr},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.o1xxuxxrbv45xxxxxxxxtype) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.o1xxuxxrbv45xxxxxxxxtype},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.o2xxuwmrbv40xxxxxxxxintegrset) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.o2xxuwmrbv40xxxxxxxxintegrset},'%'))",










        "lower(jxxxbh400xwwqqhxxxxxemployee.y0xxuzsxbvxxxxxxxxxxdescript) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.y0xxuzsxbvxxxxxxxxxxdescript},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.y6xxuz3xxvxxxxxxxxxxcusttax3) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.y6xxuz3xxvxxxxxxxxxxcusttax3},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.y9xxuxxrbvxxxxxxxxxxbywho) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.y9xxuxxrbvxxxxxxxxxxbywho},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.yaxxuzkybvxxxxxxxxxxkeywords) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.yaxxuzkybvxxxxxxxxxxkeywords},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.ybxxuznybvxxxxxxxxxxnotes) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.ybxxuznybvxxxxxxxxxxnotes},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.ycxxuzdrbvxxxxxxxxxxdocmnt) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.ycxxuzdrbvxxxxxxxxxxdocmnt},'%'))",



        "lower(jxxxbh400xwwqqhxxxxxemployee.z9xxutlolvxxxxxxxxxxlastorder) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.z9xxutlolvxxxxxxxxxxlastorder},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.z9xxutlqlvxxxxxxxxxxlastquote) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.z9xxutlqlvxxxxxxxxxxlastquote},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.zaxxutlilvxxxxxxxxxxlastinvoic) like lower( concat(#{jxxxbh400xwwqqhxxxxxemployeeList.jxxxbh400xwwqqhxxxxxemployee.zaxxutlilvxxxxxxxxxxlastinvoic},'%'))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.zexxutoxlhxxxxxxxxxxowner) like lower( concat('%',#{jxxxbh400xwwqqhxxxxxemployeeList.ownerCddCode}))",
        "lower(jxxxbh400xwwqqhxxxxxemployee.zzxxu2oxxhxxxxxxxxxxowner2) = lower(#{jxxxbh400xwwqqhxxxxxemployeeList.dataOwner2Code})",
    };



    private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee = new Jxxxbh400xwwqqhxxxxxemployee();
 /*
  In case of non composite ie Single Field Key
 */
      /*
      ids = pojo.identifierProperty.name >>> a0xxuobxbxxxxxxxxxxxsid
      */




// add more logic here to pick up foreign fields if transaction or mailing, pks,pfs=05 efs=06,added multiple K test
   //not foreign or collection properties  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection also not component  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection properties  property name a0xxuktxbvxxxxxxxxxxemployee
   //not foreign or collection also not component  property name a0xxuktxbvxxxxxxxxxxemployee
      //not component keyfield property name a0xxuktxbvxxxxxxxxxxemployee
   //not foreign or collection properties  property name b1xxuxxxbv21xxxxxxxxtitle
   //not foreign or collection also not component  property name b1xxuxxxbv21xxxxxxxxtitle
   //not foreign or collection properties  property name b2xxuxxrbx22xxxxxxxxjobtitle
   //not foreign or collection also not component  property name b2xxuxxrbx22xxxxxxxxjobtitle
   //not foreign or collection properties  property name b3xxuslnbvixxxxxxxxxlastname
   //not foreign or collection also not component  property name b3xxuslnbvixxxxxxxxxlastname
   //not foreign or collection properties  property name b4xxu2fnbvxxxxxxxxxxfirstname
   //not foreign or collection also not component  property name b4xxu2fnbvxxxxxxxxxxfirstname
   //not foreign or collection properties  property name b5xxuxxrbvxxxxxxxxxxmiddlenam
   //not foreign or collection also not component  property name b5xxuxxrbvxxxxxxxxxxmiddlenam
   //not foreign or collection properties  property name c1xxfxz1bxxxxxxxxxxxtax1
   //not foreign or collection also not component  property name c1xxfxz1bxxxxxxxxxxxtax1
   //not foreign or collection properties  property name c4xxuz1xbv04xxxxxxxxcusttax1
   //not foreign or collection also not component  property name c4xxuz1xbv04xxxxxxxxcusttax1
   //not foreign or collection properties  property name c5xxuz2xbv05xxxxxxxxcusttax2
   //not foreign or collection also not component  property name c5xxuz2xbv05xxxxxxxxcusttax2
   //not foreign or collection properties  property name m1xxh3pobv27xxxxxxxxphoneo
   //not foreign or collection also not component  property name m1xxh3pobv27xxxxxxxxphoneo
   //not foreign or collection properties  property name m2xxh4phbv27xxxxxxxxphoneh
   //not foreign or collection also not component  property name m2xxh4phbv27xxxxxxxxphoneh
   //not foreign or collection properties  property name m3xxh5pcbv27xxxxxxxxphonec
   //not foreign or collection also not component  property name m3xxh5pcbv27xxxxxxxxphonec
   //not foreign or collection properties  property name m4xxhxxrbx27xxxxxxxxphonex
   //not foreign or collection also not component  property name m4xxhxxrbx27xxxxxxxxphonex
   //not foreign or collection properties  property name n1xxhxxrbx19xxxxxxxxlanaddr
   //not foreign or collection also not component  property name n1xxhxxrbx19xxxxxxxxlanaddr
   //not foreign or collection properties  property name n2xxhxxrbx25xxxxxxxxwanaddr
   //not foreign or collection also not component  property name n2xxhxxrbx25xxxxxxxxwanaddr
   //not foreign or collection properties  property name n3xxhxxrbx44xxxxxxxxlmailaddr
   //not foreign or collection also not component  property name n3xxhxxrbx44xxxxxxxxlmailaddr
   //not foreign or collection properties  property name n4xxhxxrbv24xxxxxxxximailaddr
   //not foreign or collection also not component  property name n4xxhxxrbv24xxxxxxxximailaddr
   //not foreign or collection properties  property name n5xxuxxrbxxxxxxxxxxxrmailaddr
   //not foreign or collection also not component  property name n5xxuxxrbxxxxxxxxxxxrmailaddr
   //not foreign or collection properties  property name n6xxhxxrbx23xxxxxxxxintaddr
   //not foreign or collection also not component  property name n6xxhxxrbx23xxxxxxxxintaddr
   //not foreign or collection properties  property name n7xxuxxrbxxxxxxxxxxxinraddr
   //not foreign or collection also not component  property name n7xxuxxrbxxxxxxxxxxxinraddr
   //not foreign or collection properties  property name o1xxuxxrbv45xxxxxxxxtype
   //not foreign or collection also not component  property name o1xxuxxrbv45xxxxxxxxtype
   //not foreign or collection properties  property name o2xxuwmrbv40xxxxxxxxintegrset
   //not foreign or collection also not component  property name o2xxuwmrbv40xxxxxxxxintegrset
   //not foreign or collection properties  property name y0xxuzsxbvxxxxxxxxxxdescript
   //not foreign or collection also not component  property name y0xxuzsxbvxxxxxxxxxxdescript
   //not foreign or collection properties  property name y6xxfxxrbvxxxxxxxxxxshiplabel
   //not foreign or collection also not component  property name y6xxfxxrbvxxxxxxxxxxshiplabel
   //not foreign or collection properties  property name y6xxuz3xxvxxxxxxxxxxcusttax3
   //not foreign or collection also not component  property name y6xxuz3xxvxxxxxxxxxxcusttax3
   //not foreign or collection properties  property name y8xxcxxrbvxxxxxxxxxxcontacted
   //not foreign or collection also not component  property name y8xxcxxrbvxxxxxxxxxxcontacted
   //not foreign or collection properties  property name y9xxuxxrbvxxxxxxxxxxbywho
   //not foreign or collection also not component  property name y9xxuxxrbvxxxxxxxxxxbywho
   //not foreign or collection properties  property name yaxxuzkybvxxxxxxxxxxkeywords
   //not foreign or collection also not component  property name yaxxuzkybvxxxxxxxxxxkeywords
   //not foreign or collection properties  property name ybxxuznybvxxxxxxxxxxnotes
   //not foreign or collection also not component  property name ybxxuznybvxxxxxxxxxxnotes
   //not foreign or collection properties  property name ycxxuzdrbvxxxxxxxxxxdocmnt
   //not foreign or collection also not component  property name ycxxuzdrbvxxxxxxxxxxdocmnt
   //not foreign or collection properties  property name z1xxztpxlvxxxxxxxxxxempltotl
   //not foreign or collection also not component  property name z1xxztpxlvxxxxxxxxxxempltotl
   //not foreign or collection properties  property name z2xxfxz2bxxxxxxxxxxxtax2
   //not foreign or collection also not component  property name z2xxfxz2bxxxxxxxxxxxtax2
   //not foreign or collection properties  property name z2xxztqxlvxxxxxxxxxxempltqty
   //not foreign or collection also not component  property name z2xxztqxlvxxxxxxxxxxempltqty
   //not foreign or collection properties  property name z3xxfxz3bxxxxxxxxxxxtax3
   //not foreign or collection also not component  property name z3xxfxz3bxxxxxxxxxxxtax3
   //not foreign or collection properties  property name z5xxztrplvxxxxxxxxxxemprtotl
   //not foreign or collection also not component  property name z5xxztrplvxxxxxxxxxxemprtotl
   //not foreign or collection properties  property name z6xxztrqlvxxxxxxxxxxemprtqty
   //not foreign or collection also not component  property name z6xxztrqlvxxxxxxxxxxemprtqty
   //not foreign or collection properties  property name z7xxztmplvxxxxxxxxxxempmtotl
   //not foreign or collection also not component  property name z7xxztmplvxxxxxxxxxxempmtotl
   //not foreign or collection properties  property name z8xxztdplvxxxxxxxxxxempdtotl
   //not foreign or collection also not component  property name z8xxztdplvxxxxxxxxxxempdtotl
   //not foreign or collection properties  property name z9xxutlolvxxxxxxxxxxlastorder
   //not foreign or collection also not component  property name z9xxutlolvxxxxxxxxxxlastorder
   //not foreign or collection properties  property name z9xxutlqlvxxxxxxxxxxlastquote
   //not foreign or collection also not component  property name z9xxutlqlvxxxxxxxxxxlastquote
   //not foreign or collection properties  property name zaxxutlilvxxxxxxxxxxlastinvoic
   //not foreign or collection also not component  property name zaxxutlilvxxxxxxxxxxlastinvoic
   //not foreign or collection properties  property name zbxxztlplvxxxxxxxxxxlastpaymq
   //not foreign or collection also not component  property name zbxxztlplvxxxxxxxxxxlastpaymq
   //not foreign or collection properties  property name zcxxzzprhvxxxxxxxxxxprintmstat
   //not foreign or collection also not component  property name zcxxzzprhvxxxxxxxxxxprintmstat
   //not foreign or collection properties  property name zdxxczqxlhxxxxxxxxxxprinmtfldt
   //not foreign or collection also not component  property name zdxxczqxlhxxxxxxxxxxprinmtfldt
   //not foreign or collection properties  property name zexxutoxlhxxxxxxxxxxowner
   //not foreign or collection also not component  property name zexxutoxlhxxxxxxxxxxowner
   //not foreign or collection properties  property name zexxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection also not component  property name zexxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection properties  property name zfxxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection also not component  property name zfxxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection properties  property name zzxxu2oxxhxxxxxxxxxxowner2
   //not foreign or collection also not component  property name zzxxu2oxxhxxxxxxxxxxowner2



     String lorderColumn = "a0xxuktxbvxxxxxxxxxxemployee";
     String lorder ="a0xxuktxbvxxxxxxxxxxemployee asc";
     String lorderDirection = "asc";
     String orderColumnPrev = "";
     String orderDirectionPrev = "";
     int urlIndex=0;





public Jxxxbh400xwwqqhxxxxxemployeeList()
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
          //setOrderColumn( "jxxxbh400xwwqqhxxxxxemployee.a0xxuktxbvxxxxxxxxxxemployee" );
        //a0xxuktxbvxxxxxxxxxxemployee
        
}

    public Jxxxbh400xwwqqhxxxxxemployee getJxxxbh400xwwqqhxxxxxemployee()
    {
        return jxxxbh400xwwqqhxxxxxemployee;
    }

    public boolean isBitSet(Integer a, Integer n){ 
     if (a == null){
      a=0;
     }
     return (a & (1 << n)) != 0; 
    }


      private String  reportName  = "deJxxxbh400xwwqqhxxxxxemployee";
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
 			user = (Yxxxuh566xwwqqwxxxxxuser) getEntityManager()
 					.createQuery(
 							"select cc from Yxxxuh566xwwqqwxxxxxuser cc where cc.a0xxukuxbvxxxxxxxxxxid = :username and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
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

     public List<Jxxxbh400xwwqqhxxxxxemployee> getResultListMaxSet(Integer maxResultsVal){
      sresults=null;// reset 
      this.maxResultsVal=maxResultsVal;
      return getResultList();
     }

     public List<Jxxxbh400xwwqqhxxxxxemployee> getSystemResultListMaxSet(Integer maxResultsVal){
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
							"select count(cc) from Jxxxbh400xwwqqhxxxxxemployee cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;

     }
     public Long getSystemResultCount(){
     // show SYSTEM only not including owner2, affected pagination

		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from Jxxxbh400xwwqqhxxxxxemployee cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", "SYSTEM")
					.getSingleResult();
                return count;

     }

     public Long getResultCountClosed(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Jxxxbh400xwwqqhxxxxxemployee cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountReturned(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Jxxxbh400xwwqqhxxxxxemployee cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mreturn)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountOrdered(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Jxxxbh400xwwqqhxxxxxemployee cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code).setParameter("flag", mordered)
		.getSingleResult();
                return count;

     }


     public Long getResultCountShipped(){

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Jxxxbh400xwwqqhxxxxxemployee  cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", mshipped)
	.getSingleResult();
         return count;

     }
     public Long getResultCountInvoiced(){
       //invoiced refers to flag value 64 and may mean approved or ? or invoiced depending on the entity

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Jxxxbh400xwwqqhxxxxxemployee  cc where cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", minvoiced)
	.getSingleResult();
         return count;

     }









     public List<Jxxxbh400xwwqqhxxxxxemployee> getSystemResultList(){
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
		List<Jxxxbh400xwwqqhxxxxxemployee> results =  getEntityManager()
                                     .createQuery(
                                       "select cc from Jxxxbh400xwwqqhxxxxxemployee  cc where cc.zexxutoxlhxxxxxxxxxxowner=:owner  and  ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%')) or lower(ybxxuznybvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxuktxbvxxxxxxxxxxemployee) between :start and :end) ) order by "+ lorder)
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
             //employee add search
             if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
              Integer useremplsid=jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee().getA0xxuobxbxxxxxxxxxxxsid();
              sresults =  getEntityManager()
	.createQuery(
	"select cc from Jxxxbh400xwwqqhxxxxxemployee  cc where ((cc.zexxutoxlhxxxxxxxxxxowner=:owner or a0xxuobxbxxxxxxxxxxxsid=:useremplsid) and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2) order by "+ lorder)
                           .setParameter("owner", ownerCode)
                           .setParameter("useremplsid", useremplsid)
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .setParameter("owner2", "SYSTEM")
                           .getResultList();
             }else{
	  sresults =  getEntityManager()
	.createQuery(
	 "select cc from Jxxxbh400xwwqqhxxxxxemployee  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%')) or lower(ybxxuznybvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%'))) and (cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and (lower(a0xxuktxbvxxxxxxxxxxemployee) between :start and :end) ) order by "+ lorder)
                           .setParameter("owner2", "SYSTEM").setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                           .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                           .getResultList();
             } 
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
    * The following method overrides seam method because setOrder did not work 
    * @param args -none
    * @return List<Jxxxbh400xwwqqhxxxxxemployee>
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

     public List<Jxxxbh400xwwqqhxxxxxemployee> getResultList(){
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
                                   List<Jxxxbh400xwwqqhxxxxxemployee> results =  getEntityManager()
                                    .createQuery(
                                     "select cc from Jxxxbh400xwwqqhxxxxxemployee  cc where cc.zexxutoxlhxxxxxxxxxxowner=:owner  and ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%')) or lower(ybxxuznybvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxuktxbvxxxxxxxxxxemployee) between :start and :end) ) order by "+ lorder)
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
             //below non options, employee, add search
              if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
               Integer useremplsid=jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee().getA0xxuobxbxxxxxxxxxxxsid();
 		  sresults =  getEntityManager()
                                       .createQuery(
                                         "select cc from Jxxxbh400xwwqqhxxxxxemployee  cc where ((cc.zexxutoxlhxxxxxxxxxxowner=:owner or cc.a0xxuobxbxxxxxxxxxxxsid=:useremplsid) and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2) order by "+ lorder)
                                        .setParameter("owner", ownerCode)
                                        .setParameter("useremplsid", useremplsid)
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .setParameter("owner2", owner2Code)
                                        .getResultList();
              }else{
		  sresults =  getEntityManager()
                                      .createQuery(
                                        "select cc from Jxxxbh400xwwqqhxxxxxemployee  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%')) or lower(ybxxuznybvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxuktxbvxxxxxxxxxxemployee) like lower(concat('%',:searchVal,'%'))) and (cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and (lower(a0xxuktxbvxxxxxxxxxxemployee) between :start and :end) ) order by "+ lorder)
                                        .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase())
                                        .setMaxResults(maxResultsVal).setFirstResult(getFirstResult()!=null?getFirstResult():0)
                                        .getResultList();
              } 
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

     public Jxxxbh400xwwqqhxxxxxemployee getSidSToEntity(String sidS){
      return getSidToEntity(Integer.parseInt(sidS));//
     }

     public Jxxxbh400xwwqqhxxxxxemployee getSidToEntity(Integer sid){
      Jxxxbh400xwwqqhxxxxxemployee entity=null;
      List<Jxxxbh400xwwqqhxxxxxemployee> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("employee")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("employee")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 








        public List<Jxxxbh400xwwqqhxxxxxemployee> getCcList(){
         return ccresults;
       }

	public List<Jxxxbh400xwwqqhxxxxxemployee> getMailingList() {
          //only sresults returned, ccresults (employee) built but not part of sresults which can be one of customer/vendor/employee 
          //sresults is a list of Entity objects , since we are going to add to it, cannot be null clear() it or new
          //sresults will hold one type of entities like customer/vendor/employee but not a mixture
          //from the webpage we get toDraftlist which is string of keys for one type customer/vendor/employee  or 
          // the same type extracted from the group.
          // this string keys are converted to sid (step unnecessary now) and the full entity is retrieved and added
          // to sresults
          // ccresults is similar to sresults but holds employee entity only   
          // conresults and vonresults are similar to sresults but holds customer/vendor contact entity only   
          sresults= new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
          Integer jaySid=-1;
          // copy from toDraftSelects to toSelects , ccDraftSelects to ccSelects . draft has key whereas to/ccSelect
          // has sid
          // ccSelects or toSelects or groupXMembers come from view and already filtered out unsubscribed (status 64)
          // and those without email addr via suggestlist
         
          // take care of cc list first. cc list always shows employee only
          // customer or vendor are in to: list only not in cclist
          if (ccDualSuggestListE.getTarget() !=null && ccDualSuggestListE.getTarget().size()  >0 && ccDualSuggestListE.getTarget().get(0) !=null ){
           //now create new objects from toSelects and add to null sresults
       
           // ccDraftSelects has customer key via dropdownList and ccSelect has sid
          
           // loop through array and add, but this method gets called many times so make sure ccresults starts empty
           // ccresults is used in iterator in mailingcontent for multiple Cc
           // they also need to be added to 
           // filter out those without email address
           ccresults= new ArrayList<Jxxxbh400xwwqqhxxxxxemployee>();
           jxxxbh400xwwqqhxxxxxemployee=jxxxbh400xwwqqhxxxxxemployeeHome.getInstance();
           for(int i=0; i<ccDualSuggestListE.getTarget().size(); i++){
	     jxxxbh400xwwqqhxxxxxemployee=this.getCcDualSuggestListE().getTarget().get(i);

            if(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr() !=null && jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr().contains("@")){
             ccresults.add(jxxxbh400xwwqqhxxxxxemployee);
             //sresults.add(jxxxbh400xwwqqhxxxxxemployee);
            }
           }
          }
          // either group or entity not both are allowed ??
          if (groupSid !=null && groupSid  >0){
           //now create new objects from groupmembers and add to null sresults
           // also add last email to instance because a to: dummy entry is still needed even if its gets ignored later
           // used to indicate last email sent as well
           jxxxbh400xwwqqhxxxxxemployee=jxxxbh400xwwqqhxxxxxemployeeHome.getInstance();
           // groupSid has group sid via dropdownList 
           fxxxuq1ggxwwqqhxxxxxmembersgroupHome.setFxxxuq1ggxwwqqhxxxxxmembersgroupA0xxuobxbxxxxxxxxxxxsid(groupSid);
	   fxxxuq1ggxwwqqhxxxxxmembersgroup=fxxxuq1ggxwwqqhxxxxxmembersgroupHome.getDefinedInstance();
           sresults.addAll(getGroupEMembersList(fxxxuq1ggxwwqqhxxxxxmembersgroup.getA0xxuobxbxxxxxxxxxxxsid()));
           jxxxbh400xwwqqhxxxxxemployee.setN4xxhxxrbv24xxxxxxxximailaddr(sresults.get(sresults.size()-1).getN4xxhxxrbv24xxxxxxxximailaddr());         
           group=fxxxuq1ggxwwqqhxxxxxmembersgroup.getA0xxukxxbvxxxxxxxxxxgroupid();
           return sresults; 
          //cc allways then either group or ToSelects but no all list  
          }
          else{
           if (toDualSuggestList.getTarget() !=null && toDualSuggestList.getTarget().size()  >0 && toDualSuggestList.getTarget().get(0) !=null){
            //now create new objects from toSelects and add to null sresults
            // toSelects has customer key via dropdownList 
            // loop through array and add 
            jxxxbh400xwwqqhxxxxxemployee=jxxxbh400xwwqqhxxxxxemployeeHome.getInstance();
            for(int i=0; i<toDraftSelects.size(); i++){
	     jxxxbh400xwwqqhxxxxxemployee=this.getKeyToEntity(toDraftSelects.get(i));
             if(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr() !=null && jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr().contains("@")){
              sresults.add(jxxxbh400xwwqqhxxxxxemployee);
             }
            }
            return sresults; 
           }//end group
           else{
            //dont allow whole mailing list, its too risky
            return sresults;
           }//group/list
          }//cc/group/list


  }

        //89-schedule, get employee instances including name,Imail for a group 
	public List<Jxxxbh400xwwqqhxxxxxemployee> getGroupEMembersList(int groupSid) {
          // called by getMailingList which is called by send()ie regular Emailing and preview EMailing or by getEIMailAddrList which needs instances to get names etc along with email addr 
          // filter out unsubscribed and empty email address
          //iterate through group members for this group and look for employee only 
           if ( customIdentity.getRestrict1() !=null && customIdentity.getRestrict1().equals("D")){
                 // owner created records only
		 eresults2= getEntityManager()
				.createQuery( 
						"select cc.jxxxbh400xwwqqhxxxxxemployee from Jxxxuq54exwwqqhxxxxxgroupmembers cc where cc.jxxxbh400xwwqqhxxxxxemployee.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%' AND cc.zexxutoxlhxxxxxxxxxxowner=:owner  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.jxxxbh400xwwqqhxxxxxemployee.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fxxxuq1ggxwwqqhxxxxxmembersgroup.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();

           }else{
		 eresults2= getEntityManager()
				.createQuery( 
						"select cc.jxxxbh400xwwqqhxxxxxemployee from Jxxxuq54exwwqqhxxxxxgroupmembers cc where cc.jxxxbh400xwwqqhxxxxxemployee.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.jxxxbh400xwwqqhxxxxxemployee.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fxxxuq1ggxwwqqhxxxxxmembersgroup.a0xxuobxbxxxxxxxxxxxsid=:groupSid   order by cc.a0xxuobxbxxxxxxxxxxxsid ")
				.setParameter("owner2", owner2Code).setParameter("groupSid", groupSid).setParameter("flag", mnoMail).getResultList();

           }
        return eresults2; 
        }






	public List<Jxxxbh400xwwqqhxxxxxemployee> getFlaggedAsList(int flag) {
		// will return objects matching flag 
		return getEntityManager()
				.createQuery(
						"select cc from Jxxxbh400xwwqqhxxxxxemployee cc where (cc.zexxzzfxhhxxxxxxxxxxstatusfl = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Jxxxbh400xwwqqhxxxxxemployee> getNotFlaggedAsList(int flag) {
		// will return objects not matching flag 

		return getEntityManager()
				.createQuery(
						"select cc from Jxxxbh400xwwqqhxxxxxemployee cc where (cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Jxxxbh400xwwqqhxxxxxemployee> getOldByList(int days) {
	// will return objects statusfldt < today-days
        calendar.add(Calendar.DATE, -days); //xx days in past, can check further for 15 days/7 days/ expiry
        Date searchDate= calendar.getTime();

	return getEntityManager()
	 .createQuery(
	  "select cc from Jxxxbh400xwwqqhxxxxxemployee cc where (cast(cc.zfxxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
	   .setParameter("searchDate", searchDate).setParameter("owner2", owner2Code).getResultList();

	}






         public Jxxxbh400xwwqqhxxxxxemployee getKeyToEntity(String key){
      Jxxxbh400xwwqqhxxxxxemployee entity=null;
      List<Jxxxbh400xwwqqhxxxxxemployee> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("employee")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("employee")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+" "+bundle.getString("found"),""));
          // end user may see it,FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          // FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          customIdentity.setHoldValue3(""+results.size());//caller may examine this
      }
      return results.get(0);

    } 


     public Jxxxbh400xwwqqhxxxxxemployee getKeyContainsToEntity(String key){
      Jxxxbh400xwwqqhxxxxxemployee entity=null;
      List<Jxxxbh400xwwqqhxxxxxemployee> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee like :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key+'%')
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("employee")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("employee")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
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
      String value= getEntityManager().createQuery(" select a0xxuktxbvxxxxxxxxxxemployee from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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

     // key passed is the record key ie sid and return the email+companyname+lastname+firstname value
     // to be called if entity is customer,vendor or employee

     public String getKeyDemographValue(Integer key) {
     if(key == null || key == 0){
      return null;
     }
     try{
      Jxxxbh400xwwqqhxxxxxemployee cc=getSidToEntity(key);
      String value1=cc.getN4xxhxxrbv24xxxxxxxximailaddr()==null?"":cc.getN4xxhxxrbv24xxxxxxxximailaddr()+",";
      String value3=cc.getB3xxuslnbvixxxxxxxxxlastname()==null?"":cc.getB3xxuslnbvixxxxxxxxxlastname()+" ";
      String value4=cc.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":cc.getB4xxu2fnbvxxxxxxxxxxfirstname();
      String value=value1+value3+value4;

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
      String value= getEntityManager().createQuery(" select a0xxuktxbvxxxxxxxxxxemployee||'/'||zzxxu2oxxhxxxxxxxxxxowner2 from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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
 
      for (Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee : getSuggestList(userInput)) {
         ret.add(jxxxbh400xwwqqhxxxxxemployee.getA0xxuktxbvxxxxxxxxxxemployee());
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
     public List<Jxxxbh400xwwqqhxxxxxemployee> getSuggestList(String prefix,String hideTypePrefix) {
     // getSuggestList is called when non key values are also needed like item key, its price etc 
     // when is keyfield blank probably never for keyAutogen
     
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity  AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix )  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
	}
   





	public List<Jxxxbh400xwwqqhxxxxxemployee> getSystemSuggestList(String prefix) {
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode order by cc.a0xxuktxbvxxxxxxxxxxemployee")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxuktxbvxxxxxxxxxxemployee")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                return null;

        }
        public DualListModel<Jxxxbh400xwwqqhxxxxxemployee> getToDualSuggestList() {
         return toDualSuggestList;
        }

        public void setToDualSuggestList(DualListModel<Jxxxbh400xwwqqhxxxxxemployee> toDualSuggestList) {
         this.toDualSuggestList = toDualSuggestList;
        }

         public DualListModel<Jxxxbh400xwwqqhxxxxxemployee> getCcDualSuggestListE() {
           return ccDualSuggestListE;
         }
         public void setCcDualSuggestListE(DualListModel<Jxxxbh400xwwqqhxxxxxemployee> ccDualSuggestListE) {
          this.ccDualSuggestListE = ccDualSuggestListE; 
         }


     public List<Jxxxbh400xwwqqhxxxxxemployee> getSuggestList(String prefix) {
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

 
               if(prefix.equals("emailE")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :noMail AND cc.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("emailV")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Jxxxuq300xwwqqhxxxxxvendor cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :noMail AND cc.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("emailC")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Jxxxuq201xwwqqhxxxxxcustomer cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :noMail AND cc.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }
               if(prefix.equals("email")){
                        // allow digits
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :noMail AND cc.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
               }else{
                       if(prefix.equals("time")){
                        // sorted by time to allow import to pick latest
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :noMail AND cc.n4xxhxxrbv24xxxxxxxximailaddr LIKE  '%@%'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.zfxxcztxlxxxxxxxxxxxstatusfldt  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("noMail", mnoMail).setParameter("owner2", owner2Code)
					.getResultList();
                       }else{
			return getEntityManager().createQuery(" select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity AND cc.zexxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuktxbvxxxxxxxxxxemployee  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
                       }
               }


	}
     public List<Jxxxbh400xwwqqhxxxxxemployee> getNextSids(Integer sid){
      sresults=null;// reset 
      List<Jxxxbh400xwwqqhxxxxxemployee> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and cc.a0xxuobxbxxxxxxxxxxxsid >=:sid order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).setParameter("sid", sid)
					.getResultList();
      return results;
     }
     public List<Integer> getAllSids(){
      List<Integer> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc.a0xxuobxbxxxxxxxxxxxsid from Jxxxbh400xwwqqhxxxxxemployee cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).getResultList();
      return results;
     }










	public List<String> getwwqqhxxxxxemployeeKeyList() {
                 // xxxxxxxxxa0xxuobxbxxxxxxxxxxxsid  java.lang.String a0xxuktxbvxxxxxxxxxxemployee
    
		       String enteredValue = "";
                        //order case insensitive
			return getEntityManager().createQuery("select cc.a0xxuktxbvxxxxxxxxxxemployee from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee >=:keyOfEntity   AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')  order by lower(cc.a0xxuktxbvxxxxxxxxxxemployee) ")
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
		            parameters.put("show002h", "#{messages[Employee]}");
		            parameters.put("show003h", "#{messages[Title]}");
		            parameters.put("show004h", "#{messages[Jobtitle]}");
		            parameters.put("show005h", "#{messages[Lastname]}");
		            parameters.put("show006h", "#{messages[Firstname]}");
		            parameters.put("show007h", "#{messages[Middlenam]}");
		            parameters.put("show008h", "#{messages[Tax1]}");
		            parameters.put("show009h", "#{messages[Custtax1]}");
		            parameters.put("show010h", "#{messages[Custtax2]}");
		            parameters.put("show011h", "#{messages[companycode]}");
		            parameters.put("show012h", "#{messages[residency]}");
		            parameters.put("show013h", "#{messages[depcode]}");
		            parameters.put("show014h", "#{messages[divcode]}");
		            parameters.put("show015h", "#{messages[location]}");
		            parameters.put("show016h", "#{messages[mailtocode]}");
		            parameters.put("show017h", "#{messages[shiptocode]}");
		            parameters.put("show018h", "#{messages[Phoneo]}");
		            parameters.put("show019h", "#{messages[Phoneh]}");
		            parameters.put("show020h", "#{messages[Phonec]}");
		            parameters.put("show021h", "#{messages[Phonex]}");
		            parameters.put("show022h", "#{messages[Lanaddr]}");
		            parameters.put("show023h", "#{messages[Wanaddr]}");
		            parameters.put("show024h", "#{messages[Lmailaddr]}");
		            parameters.put("show025h", "#{messages[Imailaddr]}");
		            parameters.put("show026h", "#{messages[Rmailaddr]}");
		            parameters.put("show027h", "#{messages[Intaddr]}");
		            parameters.put("show028h", "#{messages[Inraddr]}");
		            parameters.put("show029h", "#{messages[Type]}");
		            parameters.put("show030h", "#{messages[Integrset]}");
		            parameters.put("show031h", "#{messages[Descript]}");
		            parameters.put("show032h", "#{messages[Shiplabel]}");
		            parameters.put("show033h", "#{messages[Custtax3]}");
		            parameters.put("show034h", "#{messages[Contacted]}");
		            parameters.put("show035h", "#{messages[Bywho]}");
		            parameters.put("show036h", "#{messages[Keywords]}");
		            parameters.put("show037h", "#{messages[Notes]}");
		            parameters.put("show038h", "#{messages[Docmnt]}");
		            parameters.put("show039h", "#{messages[defaultglac]}");
		            parameters.put("show040h", "#{messages[Empltotl]}");
		            parameters.put("show041h", "#{messages[Tax2]}");
		            parameters.put("show042h", "#{messages[Empltqty]}");
		            parameters.put("show043h", "#{messages[Tax3]}");
		            parameters.put("show044h", "#{messages[Emprtotl]}");
		            parameters.put("show045h", "#{messages[Emprtqty]}");
		            parameters.put("show046h", "#{messages[Empmtotl]}");
		            parameters.put("show047h", "#{messages[Empdtotl]}");
		            parameters.put("show048h", "#{messages[Lastorder]}");
		            parameters.put("show049h", "#{messages[Lastquote]}");
		            parameters.put("show050h", "#{messages[Lastinvoic]}");
		            parameters.put("show051h", "#{messages[Lastpaymq]}");
		            parameters.put("show052h", "#{messages[Printmstat]}");
		            parameters.put("show053h", "#{messages[Prinmtfldt]}");
		            parameters.put("show054h", "#{messages[Owner]}");
		            parameters.put("show055h", "#{messages[Statusfl]}");
		            parameters.put("show056h", "#{messages[Statusfldt]}");
		            parameters.put("show057h", "#{messages[Owner2]}");
                 // done with labels, now load corresponding values from truefalses db or if new create 
                 loadTruefalses(); //sets bcontinue
                 // if found bcontinue is true and  report parameters shownnn are already set from db
                 // if not found then create db entry and then load default values for report prefix type
                 // and then persist truefalse
                 // and call loadTruefalses() again 
                 if (!bcontinue){//not found
                    yxxxch5a1xhhxxhxxxxxtruefalseHome.clearInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse=yxxxch5a1xhhxxhxxxxxtruefalseHome.getInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA0xxukrdbvxxxxxxxxxxtablename("employee");
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxuxxxbvxxxxxxxxxxqualifier(reportNamePrefix);
                  //default
                 if(reportNamePrefix.equals("de")){ 
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
                   //yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false);//hide sid 
                 }
                 //demographic
                 if (reportNamePrefix.equals("dg")){
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
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow040(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow042(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow047(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow048(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow049(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow051(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow052(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow053(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow054(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow055(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow056(false);
                 }
                 //any other prefix like adhock etc
                 if (reportNamePrefix.equals("a1") || reportNamePrefix.equals("a2")){
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
                  FacesMessage.SEVERITY_WARN,bundle.getString("employee")+" "+bundle.getString("report")+" "+bundle.getString("generate")+" "+bundle.getString("failed")+" "+e.getMessage(),""));
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
                      .setParameter("tableName", "employee")
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
			    parameters.put("show002", truefalses.getA1xxyxxxbvxxxxxxxxxxshow001());
			    parameters.put("show003", truefalses.getA1xxyxxxbvxxxxxxxxxxshow002());
			    parameters.put("show004", truefalses.getA1xxyxxxbvxxxxxxxxxxshow003());
			    parameters.put("show005", truefalses.getA1xxyxxxbvxxxxxxxxxxshow004());
			    parameters.put("show006", truefalses.getA1xxyxxxbvxxxxxxxxxxshow005());
			    parameters.put("show007", truefalses.getA1xxyxxxbvxxxxxxxxxxshow006());
			    parameters.put("show008", truefalses.getA1xxyxxxbvxxxxxxxxxxshow007());
			    parameters.put("show009", truefalses.getA1xxyxxxbvxxxxxxxxxxshow008());
			    parameters.put("show010", truefalses.getA1xxyxxxbvxxxxxxxxxxshow009());
			    parameters.put("show011", truefalses.getA1xxyxxxbvxxxxxxxxxxshow010());
			    parameters.put("show012", truefalses.getA1xxyxxxbvxxxxxxxxxxshow011());
			    parameters.put("show013", truefalses.getA1xxyxxxbvxxxxxxxxxxshow012());
			    parameters.put("show014", truefalses.getA1xxyxxxbvxxxxxxxxxxshow013());
			    parameters.put("show015", truefalses.getA1xxyxxxbvxxxxxxxxxxshow014());
			    parameters.put("show016", truefalses.getA1xxyxxxbvxxxxxxxxxxshow015());
			    parameters.put("show017", truefalses.getA1xxyxxxbvxxxxxxxxxxshow016());
			    parameters.put("show018", truefalses.getA1xxyxxxbvxxxxxxxxxxshow017());
			    parameters.put("show019", truefalses.getA1xxyxxxbvxxxxxxxxxxshow018());
			    parameters.put("show020", truefalses.getA1xxyxxxbvxxxxxxxxxxshow019());
			    parameters.put("show021", truefalses.getA1xxyxxxbvxxxxxxxxxxshow020());
			    parameters.put("show022", truefalses.getA1xxyxxxbvxxxxxxxxxxshow021());
			    parameters.put("show023", truefalses.getA1xxyxxxbvxxxxxxxxxxshow022());
			    parameters.put("show024", truefalses.getA1xxyxxxbvxxxxxxxxxxshow023());
			    parameters.put("show025", truefalses.getA1xxyxxxbvxxxxxxxxxxshow024());
			    parameters.put("show026", truefalses.getA1xxyxxxbvxxxxxxxxxxshow025());
			    parameters.put("show027", truefalses.getA1xxyxxxbvxxxxxxxxxxshow026());
			    parameters.put("show028", truefalses.getA1xxyxxxbvxxxxxxxxxxshow027());
			    parameters.put("show029", truefalses.getA1xxyxxxbvxxxxxxxxxxshow028());
			    parameters.put("show030", truefalses.getA1xxyxxxbvxxxxxxxxxxshow029());
			    parameters.put("show031", truefalses.getA1xxyxxxbvxxxxxxxxxxshow030());
			    parameters.put("show032", truefalses.getA1xxyxxxbvxxxxxxxxxxshow031());
			    parameters.put("show033", truefalses.getA1xxyxxxbvxxxxxxxxxxshow032());
			    parameters.put("show034", truefalses.getA1xxyxxxbvxxxxxxxxxxshow033());
			    parameters.put("show035", truefalses.getA1xxyxxxbvxxxxxxxxxxshow034());
			    parameters.put("show036", truefalses.getA1xxyxxxbvxxxxxxxxxxshow035());
			    parameters.put("show037", truefalses.getA1xxyxxxbvxxxxxxxxxxshow036());
			    parameters.put("show038", truefalses.getA1xxyxxxbvxxxxxxxxxxshow037());
			    parameters.put("show039", truefalses.getA1xxyxxxbvxxxxxxxxxxshow038());
			    parameters.put("show040", truefalses.getA1xxyxxxbvxxxxxxxxxxshow039());
			    parameters.put("show041", truefalses.getA1xxyxxxbvxxxxxxxxxxshow040());
			    parameters.put("show042", truefalses.getA1xxyxxxbvxxxxxxxxxxshow041());
			    parameters.put("show043", truefalses.getA1xxyxxxbvxxxxxxxxxxshow042());
			    parameters.put("show044", truefalses.getA1xxyxxxbvxxxxxxxxxxshow043());
			    parameters.put("show045", truefalses.getA1xxyxxxbvxxxxxxxxxxshow044());
			    parameters.put("show046", truefalses.getA1xxyxxxbvxxxxxxxxxxshow045());
			    parameters.put("show047", truefalses.getA1xxyxxxbvxxxxxxxxxxshow046());
			    parameters.put("show048", truefalses.getA1xxyxxxbvxxxxxxxxxxshow047());
			    parameters.put("show049", truefalses.getA1xxyxxxbvxxxxxxxxxxshow048());
			    parameters.put("show050", truefalses.getA1xxyxxxbvxxxxxxxxxxshow049());
			    parameters.put("show051", truefalses.getA1xxyxxxbvxxxxxxxxxxshow050());
			    parameters.put("show052", truefalses.getA1xxyxxxbvxxxxxxxxxxshow051());
			    parameters.put("show053", truefalses.getA1xxyxxxbvxxxxxxxxxxshow052());
			    parameters.put("show054", truefalses.getA1xxyxxxbvxxxxxxxxxxshow053());
			    parameters.put("show055", truefalses.getA1xxyxxxbvxxxxxxxxxxshow054());
			    parameters.put("show056", truefalses.getA1xxyxxxbvxxxxxxxxxxshow055());
			    parameters.put("show057", truefalses.getA1xxyxxxbvxxxxxxxxxxshow056());
			    parameters.put("show058", truefalses.getA1xxyxxxbvxxxxxxxxxxshow057());
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
   public void saveAsDraft() {
              try {
                 mailingSubject=yxxxuq1m1xwwqqqxxxxxclobdataHome.sanitize(mailingSubject);//
                 mailingSource=yxxxuq1m1xwwqqqxxxxxclobdataHome.sanitize(mailingSource);
		 yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-DRAFT",ownerCode,0);
                 if(yxxxuq1m1xwwqqqxxxxxclobdata == null){   
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-DRAFT");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_INFO,"Draft created" ,""));

                 }else{
  		  yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-DRAFT",ownerCode,0);
                  mailingSubject=yxxxuq1m1xwwqqqxxxxxclobdataHome.sanitize(mailingSubject);//
                  mailingSource=yxxxuq1m1xwwqqqxxxxxclobdataHome.sanitize(mailingSource);
		  //yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSource);
                  yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.superUpdate();
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
		 yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-DRAFT",ownerCode,0);
                 if(yxxxuq1m1xwwqqqxxxxxclobdata == null){   
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString("no")+" "+bundle.getString("draft")+" ("+bundle.getString("key")+": "+bundle.getString("MAIL-DRAFT")+") "+" "+bundle.getString("record")+" "+bundle.getString("found")+" "+bundle.getString("in")+" "+bundle.getString("text")+" "+bundle.getString("data"),""));
                  FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                   FacesMessage.SEVERITY_ERROR,bundle.getString("you")+" "+bundle.getString("may")+" "+bundle.getString("check")+" "+bundle.getString("for")+" ("+bundle.getString("key")+": "+bundle.getString("MAIL-CONTENT")+") "+" "+bundle.getString("which")+" "+bundle.getString("holds")+" "+bundle.getString("mail")+" "+bundle.getString("already")+" "+bundle.getString("sent"),""));
                  return;
                 }else{
                  mailingSource=yxxxuq1m1xwwqqqxxxxxclobdata.getB1xxuzaxbvxxxxxxxxxxdata();
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
        mailingSource=yxxxuq1m1xwwqqqxxxxxclobdataHome.sanitize(mailingSource);
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
         Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee= jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee();
         setUserFullName((jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()) +" "+(jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()));
         if (jxxxbh400xwwqqhxxxxxemployee==null || "".equals(jxxxbh400xwwqqhxxxxxemployee) ||
             jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()==null || 
             "".equals(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()) ){
                 Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
					.createQuery(
							"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();

          setClientEMail(client.getD4xxhxxrbv24xxxxxxxximailaddr().trim());
         } 
         else{
           setClientEMail(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
         }
         // if demo user no email saved in employee except in user
         Yxxxuh566xwwqqwxxxxxuser theUser = yxxxuh566xwwqqwxxxxxuserList.getKeyToEntity(customIdentity.getUsername());
         if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
          setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
         }

         if("".equals(eMailingAddress1)){
          //eMailingAddress1="mail@3rcomputer.com";
         }
         //checkMapI[1],2 etc was set via checkBoxes
         if (checkMapI[1]){ 
          setMailingImage1(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          mailAttachInfo=mailAttachInfo+" attach1."+mailingBytes1Type;
         }  
         if (checkMapI[2]){ 
          setMailingImage2(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          mailAttachInfo=mailAttachInfo+" attach2."+mailingBytes2Type;
         }  
         if (checkMapI[3]){ 
          setMailingImage3(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          mailAttachInfo=mailAttachInfo+" attach3."+mailingBytes3Type;
         }  
         if (checkMapI[4]){ 
          setMailingImage4(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          mailAttachInfo=mailAttachInfo+" attach4."+mailingBytes4Type;
         }  
         if (checkMapI[5]){ 
          setMailingImage5(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          mailAttachInfo=mailAttachInfo+" attach5."+mailingBytes5Type;
         }  
         // mailingtext1,2 etc are saved as string but mailcontent converts to byte
         // add logic to include as attach
         setMailingText(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",0,12000) );

         if (checkMapT[1]){ 
          setMailingText1(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",1,12000) );
          mailAttachInfo=mailAttachInfo+" attach1.txt";
         }  
         if (checkMapT[2]){ 
          setMailingText2(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",2,12000) );
          mailAttachInfo=mailAttachInfo+" attach2.txt";
         }  
         if (checkMapT[3]){ 
          setMailingText3(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",3,12000) );
          mailAttachInfo=mailAttachInfo+" attach3.txt";
         }  
         if (checkMapT[4]){ 
          setMailingText4(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",4,12000) );
          mailAttachInfo=mailAttachInfo+" attach4.txt";
         }  

         if (checkMapT[5]){ 
          setMailingText5(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",5,12000) );
          mailAttachInfo=mailAttachInfo+" attach5.txt";
         }  
         // signatureSource already built 

         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO," ",""));

         int ccSize=ccresults.size();
         int contSize=0;
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
          //renderer.render("/employeeMailingContent.xhtml");
          emailRender("/employeeMailingContent.xhtml","x");

          timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 	  log.severe("email render end "+ timeStamp);
          if(!bcontinue){
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+bundle.getString("failed"),""));
           return; 
          }
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("email")+" "+ bundle.getString("send")+" "+bundle.getString("done")+" "+bundle.getString("ending")+" "+bundle.getString("with")+" "+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr(),""));

          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("check")+" "+ bundle.getString("attachment")+" "+bundle.getString("selections")+" "+bundle.getString("before")+" "+bundle.getString("next")+" "+bundle.getString("send"),""));
          //removed logic to reset check boxes because under converation scope they get set back by jsf
          timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 	  log.severe("email msg end "+ timeStamp);
         //save or update a copy of subject and source in clob data jay do it before sending so that can be sent manualy if needed
		 yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-STATUS",ownerCode,0);
                 if(yxxxuq1m1xwwqqqxxxxxclobdata == null){   
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-STATUS");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  if(group.trim().isEmpty()){
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                 }else{
                  if(group.trim().isEmpty()){
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.superUpdate();
                 }///
		 yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-CONTENT",ownerCode,0);
                 if(yxxxuq1m1xwwqqqxxxxxclobdata == null){   
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-CONTENT");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  // add to/cc list as a line
                  yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                 }else{
                  yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSubject+"  "+mailingSource+" sentList: "+mailNameInfo);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.superUpdate();
                 }

          return;
        }//mailingSize check 
    } catch (Exception e) {
         log.severe("Error sending mail"+ e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"Email sending failed: " + e.getMessage(),""));
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
* header("X-SMTPAPI",headers) for m:header name="X-SMTPAPI" value="#{jxxxbh400xwwqqhxxxxxemployeeList.headers}" 
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
         String useTemplate="employeeMailingContent.fmt";
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
          useTemplate="employeeeMailingContent.fmt";
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
                            new InputStreamAttachment("employee.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("employee.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("employee.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("employee.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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



   public void fetchMailingStatus(){
         setMailingStatus(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","AMAIL-STATUS",ownerCode,0,12000) );

   }
   public Integer keyToSid(String key){
                        jxxxbh400xwwqqhxxxxxemployee=null;
			List<Jxxxbh400xwwqqhxxxxxemployee> results =  getEntityManager()
			    .createQuery("select cc from Jxxxbh400xwwqqhxxxxxemployee cc where cc.a0xxuktxbvxxxxxxxxxxemployee = :Key AND cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  cc.zfxxcztxlxxxxxxxxxxxstatusfldt").setParameter("owner2", owner2Code).
                            setParameter("Key", key).getResultList();
                           if(!results.isEmpty()){
                            jxxxbh400xwwqqhxxxxxemployee = results.get(0);
                           }
                           return jxxxbh400xwwqqhxxxxxemployee.getA0xxuobxbxxxxxxxxxxxsid();
   
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
         Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee= jxxxbh400xwwqqhxxxxxemployeeHome.getCurrentUserToEmployee();
         setUserFullName((jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()) +" "+(jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()));
         if (jxxxbh400xwwqqhxxxxxemployee==null || "".equals(jxxxbh400xwwqqhxxxxxemployee) ||
             jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()==null || 
             "".equals(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()) ){

                 Yxxxch522xhhxxhxxxxxclient client =(Yxxxch522xhhxxhxxxxxclient) getEntityManager()
					.createQuery(
							"select cc from Yxxxch522xhhxxhxxxxxclient cc where cc.a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nKeyName","01")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
          setClientEMail(client.getD4xxhxxrbv24xxxxxxxximailaddr());
         }else{
          setClientEMail(jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr().trim());
         }
         // if demo user no email saved in employee except in user
         Yxxxuh566xwwqqwxxxxxuser theUser = yxxxuh566xwwqqwxxxxxuserList.getKeyToEntity(customIdentity.getUsername());
         if(theUser.getY1xxuxxxivxxxxxxxxxxrestrict1() != null && theUser.getY1xxuxxxivxxxxxxxxxxrestrict1().equals("D")){
          setClientEMail(theUser.getA0xxukuxbvxxxxxxxxxxid());
         }

         //send one email to user/client email as toAddress to store the content and for preview, others including e1mailAddress are in xsmtpi header
         //checkMapI[1],2 etc was set via checkBoxes
         if (checkMapI[1]){ 
          setMailingImage1(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          setMailingImage1Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",1) );
          mailInfo=mailInfo+" attach1."+mailingBytes1Type;
         }  
         if (checkMapI[2]){ 
          setMailingImage2(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          setMailingImage2Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",2) );
          mailInfo=mailInfo+" attach2."+mailingBytes2Type;
         }  
         if (checkMapI[3]){ 
          setMailingImage3(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          setMailingImage3Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",3) );
          mailInfo=mailInfo+" attach3."+mailingBytes3Type;
         }  
         if (checkMapI[4]){ 
          setMailingImage4(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          setMailingImage4Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",4) );
          mailInfo=mailInfo+" attach4."+mailingBytes4Type;
         }  
         if (checkMapI[5]){ 
          setMailingImage5(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5TypeMime(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataTypeMime("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          setMailingImage5Type(yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdataType("blobdata","B3R-ATTACHMENT-1-C","PIC",5) );
          mailInfo=mailInfo+" attach5."+mailingBytes5Type;
         }  
         // mailingtext1,2 etc are saved as string but mailcontent converts to byte
         setMailingText(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",0,12000) );

         if (checkMapT[1]){ 
          setMailingText1(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",1,12000) );
         }  
         if (checkMapT[2]){ 
          setMailingText2(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",2,12000) );
         }  
         if (checkMapT[3]){ 
          setMailingText3(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",3,12000) );
         }  
         if (checkMapT[4]){ 
          setMailingText4(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",4,12000) );
         }  

         if (checkMapT[5]){ 
          setMailingText5(yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata("clobdata","A3R-ATTACHMENT-1-C","TXT",5,12000) );
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
         emailRender("/employeeMailingContent.xhtml","x");

         //timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
         //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     //FacesMessage.SEVERITY_INFO,bundle.getString("If")+" "+bundle.getString("no")+" "+bundle.getString("error")+", "+bundle.getString("preview")+" "+ bundle.getString("email")+" "+bundle.getString("sent")+" "+bundle.getString("to")+" "+getClientEMail(),""));


         //save or update a copy of subject and source in clob data jay do it before sending so that can be sent manualy if needed
		 yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-STATUS",ownerCode,0);
                 if(yxxxuq1m1xwwqqqxxxxxclobdata == null){   
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-STATUS");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  if(group.trim().isEmpty()){
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                 }else{
                  if(group.trim().isEmpty()){
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }else{
                   yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(timeStamp+" "+bundle.getString("group")+" "+group+" "+" To count "+Integer.toString(mailingSize)+" cc count "+Integer.toString(ccSize)+" contacts count "+Integer.toString(contSize)+" "+bundle.getString("sender")+" "+bundle.getString("copy")+" 1 "+" preview sent to "+getClientEMail());
                  }
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.superUpdate();
                 }
		 yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataList.getclobDataInstance("clobdata","AMAIL-CONTENT",ownerCode,0);
                 if(yxxxuq1m1xwwqqqxxxxxclobdata == null){   
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("clobdata");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-CONTENT");
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(0);
		  yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                  yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSubject+"  "+mailingSource);
                  yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                 }else{
                  yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata(mailingSubject+"  "+mailingSource);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
                  yxxxuq1m1xwwqqqxxxxxclobdataHome.superUpdate();
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
    Iterator<Jxxxbh400xwwqqhxxxxxemployee> itr = getMailingList().iterator();
    int ilimit=0;
   try{
    header.addCategory(owner2Code);// can be used in webhook
    while (itr.hasNext()) {
     jxxxbh400xwwqqhxxxxxemployee = itr.next();
      ++ilimit;
      header.addTo((jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname())+" <"+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()+">") ;
      header.addSubstitution("keyx", jxxxbh400xwwqqhxxxxxemployee.getA0xxuktxbvxxxxxxxxxxemployee());
      header.addSubstitution("unx", jxxxbh400xwwqqhxxxxxemployee.getA0xxuobxbxxxxxxxxxxxsid()+"");
      mailInfo=mailInfo+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoTo=mailInfoTo+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
       if(ilimit <101){
        mailNameInfo=mailNameInfo+(jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname())+", ";
       }       
      }else{
       mailNameInfo="";
      }
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
              setUnsubscribeSource("<p style=\"font-family:arial;color:red;font-size:12px;\">Unsubscribe by clicking <a href=\""+activationLink+"?keyCode=keyx&unsc=unx&type=3\">unsubscribe</a></p>");
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

    //loop through CC and add to xsmtpi header for relay, need mailInfoCC like mailInfoTo logic for non relay
    mailInfoCC="";//had  infoTo values
    Iterator<Jxxxbh400xwwqqhxxxxxemployee> itre = ccresults.iterator();
   try{
    while (itre.hasNext()) {
      jxxxbh400xwwqqhxxxxxemployee = itre.next();
      header.addTo((jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname())+" "+(jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname())+" <"+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()+">") ;
      mailInfo=mailInfo+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      mailInfoCC=mailInfoCC+jxxxbh400xwwqqhxxxxxemployee.getN4xxhxxrbv24xxxxxxxximailaddr()+", ";
      if(getShowNamesYN()){
       if(mailNameInfo !=null && !mailNameInfo.isEmpty()){
        mailNameInfo=mailNameInfo+", ";
       } 
       mailNameInfo=mailNameInfo+(jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB4xxu2fnbvxxxxxxxxxxfirstname().substring(0,1))+" "+(jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname()==null?"":jxxxbh400xwwqqhxxxxxemployee.getB3xxuslnbvixxxxxxxxxlastname())+", ";
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
          //reportName="xxJxxxbh400xwwqqhxxxxxemployee";  holds selected report
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
         //renderer.render("/employeeeMailingContent.xhtml");
         emailRender("/employeeeMailingContent.xhtml","e");
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
   public List<Jxxxbh400xwwqqhxxxxxemployee> getResultList(){
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
