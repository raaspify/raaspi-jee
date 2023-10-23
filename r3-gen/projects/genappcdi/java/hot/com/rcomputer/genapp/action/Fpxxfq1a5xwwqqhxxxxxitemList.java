



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

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;







/**
* This is Action List class 
* @author 3r Computer Systems  
* @version 2.0
*/

@Named("fpxxfq1a5xwwqqhxxxxxitemList")
@ViewScoped
public class Fpxxfq1a5xwwqqhxxxxxitemList implements Serializable
{
   private Logger log = Logger.getLogger(Fpxxfq1a5xwwqqhxxxxxitem.class.getCanonicalName());
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
	Yxxxch575xwwqqhxxxxxuserproflHome yxxxch575xwwqqhxxxxxuserproflHome;
	private Yxxxch575xwwqqhxxxxxuserprofl yxxxch575xwwqqhxxxxxuserprofl;
	@Inject 
	Jxxxuq201xwwqqhxxxxxcustomerHome jxxxuq201xwwqqhxxxxxcustomerHome;
	private Jxxxuq201xwwqqhxxxxxcustomer jxxxuq201xwwqqhxxxxxcustomer;
	@Inject 
	Yxxxuh566xwwqqwxxxxxuserHome yxxxuh566xwwqqwxxxxxuserHome;
	private Yxxxuh566xwwqqwxxxxxuser yxxxuh566xwwqqwxxxxxuser;
	@Inject
	Yxxxuq591xwwqqhxxxxxrate1fList yxxxuq591xwwqqhxxxxxrate1fList;
                 @Inject
                 Yxxxch522xhhxxhxxxxxclientList yxxxch522xhhxxhxxxxxclientList;
                 Yxxxch522xhhxxhxxxxxclient yxxxch522xhhxxhxxxxxclient;
                 @Inject 
                 Fxxxuq1ffxwwqqhefxxxserialnumbersList fxxxuq1ffxwwqqhefxxxserialnumbersList;



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
                int listSize=getwwqqhxxxxxitemKeyList().size();
                start=  listSize==0 ? "0" : String.valueOf(getwwqqhxxxxxitemKeyList().get(0)) ;
                end=    listSize==0 ? "0" : String.valueOf(getwwqqhxxxxxitemKeyList().get(listSize-1));

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
         private String sortByValue="bm";
         private Integer dpr=16;


     Map parameters = new HashMap();
     int xvc=1;
     String reportNamePrefix="";
     String reportNameMinusPrefix="";
     List<Fpxxfq1a5xwwqqhxxxxxitem> sresults=null;

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

     private static final String EJBQL = "select fpxxfq1a5xwwqqhxxxxxitem from Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem "  ;

     private static final String[] RESTRICTIONS = {
        "lower(fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.b1xxuszsbvxxxxxxxxxxdescript) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.b1xxuszsbvxxxxxxxxxxdescript},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.b3xxuxxrbvxxxxxxxxxxsource1) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.b3xxuxxrbvxxxxxxxxxxsource1},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.b5fbuxxrbvxxxxxxxxxxupccode) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.b5fbuxxrbvxxxxxxxxxxupccode},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.c3fbuxscbvxxxxxxxxxxshipcode) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.c3fbuxscbvxxxxxxxxxxshipcode},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.c5fbuuxrbv18xxxxxxxxunit) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.c5fbuuxrbv18xxxxxxxxunit},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype},'%'))",


        "lower(fpxxfq1a5xwwqqhxxxxxitem.f1xxuxxrbvxxxxxxxxxxaliascode) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.f1xxuxxrbvxxxxxxxxxxaliascode},'%'))",








        "lower(fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn1bvxxxxxxxxxxsubcodesn) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn1bvxxxxxxxxxxsubcodesn},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn2bvxxxxxxxxxxsubcodesn2) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn2bvxxxxxxxxxxsubcodesn2},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn3bvxxxxxxxxxxsubcodesn3) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn3bvxxxxxxxxxxsubcodesn3},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.h2xxuwmrbv40xxxxxxxxintegrset) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.h2xxuwmrbv40xxxxxxxxintegrset},'%'))",






















        "lower(fpxxfq1a5xwwqqhxxxxxitem.w7xxuznxbvxxxxxxxxxxnotes) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.w7xxuznxbvxxxxxxxxxxnotes},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.w8xxuzdrbvxxxxxxxxxxdocmnt) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.w8xxuzdrbvxxxxxxxxxxdocmnt},'%'))",






















        "lower(fpxxfq1a5xwwqqhxxxxxitem.y1xxuxxrbvxxxxxxxxxxsource2) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.y1xxuxxrbvxxxxxxxxxxsource2},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.y3xxuxxrbvxxxxxxxxxxmisccode2) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.y3xxuxxrbvxxxxxxxxxxmisccode2},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.zexxutoxlhxxxxxxxxxxowner) like lower( concat('%',#{fpxxfq1a5xwwqqhxxxxxitemList.ownerCddCode}))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.zxxrbvxxxvxxxxxxxxxxbarupc) like lower( concat(#{fpxxfq1a5xwwqqhxxxxxitemList.fpxxfq1a5xwwqqhxxxxxitem.zxxrbvxxxvxxxxxxxxxxbarupc},'%'))",
        "lower(fpxxfq1a5xwwqqhxxxxxitem.zzxxu2oxxhxxxxxxxxxxowner2) = lower(#{fpxxfq1a5xwwqqhxxxxxitemList.dataOwner2Code})",
    };



    private Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem = new Fpxxfq1a5xwwqqhxxxxxitem();
 /*
  In case of non composite ie Single Field Key
 */
      /*
      ids = pojo.identifierProperty.name >>> a0xxuobxbxxxxxxxxxxxsid
      */




// add more logic here to pick up foreign fields if transaction or mailing, pks,pfs=05 efs=06,added multiple K test
   //not foreign or collection properties  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection also not component  property name a0xxuobxbxxxxxxxxxxxsid
   //not foreign or collection properties  property name a0xxukixbxxxxxxxxxxxmatcode
   //not foreign or collection also not component  property name a0xxukixbxxxxxxxxxxxmatcode
      //not component keyfield property name a0xxukixbxxxxxxxxxxxmatcode
   //not foreign or collection properties  property name b0xxziqxlvxxsaxxxxxxquantity
   //not foreign or collection also not component  property name b0xxziqxlvxxsaxxxxxxquantity
   //not foreign or collection properties  property name b1xxuszsbvxxxxxxxxxxdescript
   //not foreign or collection also not component  property name b1xxuszsbvxxxxxxxxxxdescript
   //not foreign or collection properties  property name b3xxuxxrbvxxxxxxxxxxsource1
   //not foreign or collection also not component  property name b3xxuxxrbvxxxxxxxxxxsource1
   //not foreign or collection properties  property name b5fbuxxrbvxxxxxxxxxxupccode
   //not foreign or collection also not component  property name b5fbuxxrbvxxxxxxxxxxupccode
   //not foreign or collection properties  property name b6fbzicxbvxxxxxxxxxxcost
   //not foreign or collection also not component  property name b6fbzicxbvxxxxxxxxxxcost
   //not foreign or collection properties  property name b7fbzxxxbvxxxxxxxxxxreplcost
   //not foreign or collection also not component  property name b7fbzxxxbvxxxxxxxxxxreplcost
   //not foreign or collection properties  property name b8fbzpxxbvxxxxxxxxxxselprice
   //not foreign or collection also not component  property name b8fbzpxxbvxxxxxxxxxxselprice
   //not foreign or collection properties  property name b9xxzxxxlvxxxxxxxxxxspricold
   //not foreign or collection also not component  property name b9xxzxxxlvxxxxxxxxxxspricold
   //not foreign or collection properties  property name c1xxzxxxbhxxsxxxxxxxspricnew
   //not foreign or collection also not component  property name c1xxzxxxbhxxsxxxxxxxspricnew
   //not foreign or collection properties  property name c2fbcxxrehxxsxxxxxxxspriceffdt
   //not foreign or collection also not component  property name c2fbcxxrehxxsxxxxxxxspriceffdt
   //not foreign or collection properties  property name c3fbuxscbvxxxxxxxxxxshipcode
   //not foreign or collection also not component  property name c3fbuxscbvxxxxxxxxxxshipcode
   //not foreign or collection properties  property name c4fbzxxxbvxxxxxxxxxxqtylevel1
   //not foreign or collection also not component  property name c4fbzxxxbvxxxxxxxxxxqtylevel1
   //not foreign or collection properties  property name c5fbuuxrbv18xxxxxxxxunit
   //not foreign or collection also not component  property name c5fbuuxrbv18xxxxxxxxunit
   //not foreign or collection properties  property name c6xxusxrbv16xxxxxxxxtype
   //not foreign or collection also not component  property name c6xxusxrbv16xxxxxxxxtype
   //not foreign or collection properties  property name c7fbfxz1bvxxxxxxxxxxtax1
   //not foreign or collection also not component  property name c7fbfxz1bvxxxxxxxxxxtax1
   //not foreign or collection properties  property name c8fbfxz2bvxxxxxxxxxxtax2
   //not foreign or collection also not component  property name c8fbfxz2bvxxxxxxxxxxtax2
   //not foreign or collection properties  property name f1xxuxxrbvxxxxxxxxxxaliascode
   //not foreign or collection also not component  property name f1xxuxxrbvxxxxxxxxxxaliascode
   //not foreign or collection properties  property name f3xxzxxxlvxxxxxxxxxxavgprice
   //not foreign or collection also not component  property name f3xxzxxxlvxxxxxxxxxxavgprice
   //not foreign or collection properties  property name g2xxuxn1bvxxxxxxxxxxsubcodesn
   //not foreign or collection also not component  property name g2xxuxn1bvxxxxxxxxxxsubcodesn
   //not foreign or collection properties  property name g2xxuxn2bvxxxxxxxxxxsubcodesn2
   //not foreign or collection also not component  property name g2xxuxn2bvxxxxxxxxxxsubcodesn2
   //not foreign or collection properties  property name g2xxuxn3bvxxxxxxxxxxsubcodesn3
   //not foreign or collection also not component  property name g2xxuxn3bvxxxxxxxxxxsubcodesn3
   //not foreign or collection properties  property name h1xxcxxrbxxxxxxxxxxxeffdate
   //not foreign or collection also not component  property name h1xxcxxrbxxxxxxxxxxxeffdate
   //not foreign or collection properties  property name h2xxuwmrbv40xxxxxxxxintegrset
   //not foreign or collection also not component  property name h2xxuwmrbv40xxxxxxxxintegrset
   //not foreign or collection properties  property name w7xxuznxbvxxxxxxxxxxnotes
   //not foreign or collection also not component  property name w7xxuznxbvxxxxxxxxxxnotes
   //not foreign or collection properties  property name w8xxuzdrbvxxxxxxxxxxdocmnt
   //not foreign or collection also not component  property name w8xxuzdrbvxxxxxxxxxxdocmnt
   //not foreign or collection properties  property name y1xxuxxrbvxxxxxxxxxxsource2
   //not foreign or collection also not component  property name y1xxuxxrbvxxxxxxxxxxsource2
   //not foreign or collection properties  property name y2xxuxxrbvxxxxxxxxxxmisccode1
   //not foreign or collection also not component  property name y2xxuxxrbvxxxxxxxxxxmisccode1
   //not foreign or collection properties  property name y3xxuxxrbvxxxxxxxxxxmisccode2
   //not foreign or collection also not component  property name y3xxuxxrbvxxxxxxxxxxmisccode2
   //not foreign or collection properties  property name y4xxuxxrbvxxxxxxxxxxcaseqty
   //not foreign or collection also not component  property name y4xxuxxrbvxxxxxxxxxxcaseqty
   //not foreign or collection properties  property name y5xxcxxrlxxxxxxxxxxxdatetorenew
   //not foreign or collection also not component  property name y5xxcxxrlxxxxxxxxxxxdatetorenew
   //not foreign or collection properties  property name y6fbfxz3bvxxxxxxxxxxtax3
   //not foreign or collection also not component  property name y6fbfxz3bvxxxxxxxxxxtax3
   //not foreign or collection properties  property name z2xxcsxrlxxxxxxxxxxxdateadded
   //not foreign or collection also not component  property name z2xxcsxrlxxxxxxxxxxxdateadded
   //not foreign or collection properties  property name z2xxcxxrlxxxxxxxxxxxdateexpiry
   //not foreign or collection also not component  property name z2xxcxxrlxxxxxxxxxxxdateexpiry
   //not foreign or collection properties  property name z2xxzzprhvxxxxxxxxxxprintmstat
   //not foreign or collection also not component  property name z2xxzzprhvxxxxxxxxxxprintmstat
   //not foreign or collection properties  property name z3xxczqxlhxxxxxxxxxxprinmtfldt
   //not foreign or collection also not component  property name z3xxczqxlhxxxxxxxxxxprinmtfldt
   //not foreign or collection properties  property name z4xxzxxxlvxxxxxxxxxxavgcost
   //not foreign or collection also not component  property name z4xxzxxxlvxxxxxxxxxxavgcost
   //not foreign or collection properties  property name z5xxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection also not component  property name z5xxzzfxhhxxxxxxxxxxstatusfl
   //not foreign or collection properties  property name z6xxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection also not component  property name z6xxcztxlxxxxxxxxxxxstatusfldt
   //not foreign or collection properties  property name z7xxzxxxlvxxxxxxxxxxcuordqty
   //not foreign or collection also not component  property name z7xxzxxxlvxxxxxxxxxxcuordqty
   //not foreign or collection properties  property name z8xxzxxxlvxxxxxxxxxxvenorqty
   //not foreign or collection also not component  property name z8xxzxxxlvxxxxxxxxxxvenorqty
   //not foreign or collection properties  property name z9xxzxxxlvxxxxxxxxxxcupicqty
   //not foreign or collection also not component  property name z9xxzxxxlvxxxxxxxxxxcupicqty
   //not foreign or collection properties  property name zaxxzxxxlvxxxxxxxxxxvenpiqty
   //not foreign or collection also not component  property name zaxxzxxxlvxxxxxxxxxxvenpiqty
   //not foreign or collection properties  property name zbxxzxxxlvxxxxxxxxxxcuinvqty
   //not foreign or collection also not component  property name zbxxzxxxlvxxxxxxxxxxcuinvqty
   //not foreign or collection properties  property name zcxxzxxxlvxxxxxxxxxxcushiqty
   //not foreign or collection also not component  property name zcxxzxxxlvxxxxxxxxxxcushiqty
   //not foreign or collection properties  property name zdxxzxxxlvxxxxxxxxxxvenshqty
   //not foreign or collection also not component  property name zdxxzxxxlvxxxxxxxxxxvenshqty
   //not foreign or collection properties  property name zexxutoxlhxxxxxxxxxxowner
   //not foreign or collection also not component  property name zexxutoxlhxxxxxxxxxxowner
   //not foreign or collection properties  property name zxxrbvxxxvxxxxxxxxxxbarupc
   //not foreign or collection also not component  property name zxxrbvxxxvxxxxxxxxxxbarupc
   //not foreign or collection properties  property name zzxxu2oxxhxxxxxxxxxxowner2
   //not foreign or collection also not component  property name zzxxu2oxxhxxxxxxxxxxowner2



     String lorderColumn = "a0xxukixbxxxxxxxxxxxmatcode";
     String lorder ="a0xxukixbxxxxxxxxxxxmatcode asc";
     String lorderDirection = "asc";
     String orderColumnPrev = "";
     String orderDirectionPrev = "";
     int urlIndex=0;





public Fpxxfq1a5xwwqqhxxxxxitemList()
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
          //setOrderColumn( "fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode" );
        //a0xxukixbxxxxxxxxxxxmatcode
        
}

    public Fpxxfq1a5xwwqqhxxxxxitem getFpxxfq1a5xwwqqhxxxxxitem()
    {
        return fpxxfq1a5xwwqqhxxxxxitem;
    }

    public boolean isBitSet(Integer a, Integer n){ 
     if (a == null){
      a=0;
     }
     return (a & (1 << n)) != 0; 
    }


      private String  reportName  = "deFpxxfq1a5xwwqqhxxxxxitem";
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

     public List<Fpxxfq1a5xwwqqhxxxxxitem> getResultListMaxSet(Integer maxResultsVal){
      sresults=null;// reset 
      this.maxResultsVal=maxResultsVal;
      return getResultList();
     }

     public List<Fpxxfq1a5xwwqqhxxxxxitem> getSystemResultListMaxSet(Integer maxResultsVal){
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
							"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", owner2Code)
					.getSingleResult();
                return count;

     }
     public Long getSystemResultCount(){
     // show SYSTEM only not including owner2, affected pagination

		Long count =  (Long)getEntityManager()
					.createQuery(
							"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) ")
					.setParameter("owner2", "SYSTEM")
					.getSingleResult();
                return count;

     }

     public Long getResultCountClosed(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountReturned(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		 "select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		 .setParameter("owner2", owner2Code).setParameter("flag", mreturn)
		 .getSingleResult();
                return count;

     }
     public Long getResultCountOrdered(){

		Long count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
		.setParameter("owner2", owner2Code).setParameter("flag", mordered)
		.getSingleResult();
                return count;

     }


     public Long getResultCountShipped(){

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem  cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", mshipped)
	.getSingleResult();
         return count;

     }
     public Long getResultCountInvoiced(){
       //invoiced refers to flag value 64 and may mean approved or ? or invoiced depending on the entity

	Long count =  (Long)getEntityManager()
	.createQuery(
	"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem  cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :flag AND (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') ")
	.setParameter("owner2", owner2Code).setParameter("flag", minvoiced)
	.getSingleResult();
         return count;

     }




     public Fpxxfq1a5xwwqqhxxxxxitem getKeyToEntity(String key,String owner2){
      // another site restrict to raaspi site  added for item
      Fpxxfq1a5xwwqqhxxxxxitem entity=null;
      List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
      try{
       results = getEntityManager()
        .createQuery(
          "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 )")
           .setParameter("nKeyName",key)
           .setParameter("owner2", owner2)
           .getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("item")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

    } 

   //client and Item only






     public List<Fpxxfq1a5xwwqqhxxxxxitem> getSystemResultList(){
      //use SYSTEM only,  allow PH to see

      // start null seems to make query return null, also null pointer to make lowercase
      if(start == null){
       start=" ";
      }
      if(end == null){
       end="zzzzz";
      }
      if(sortByValue.equals("lh")){
       String jj=lorderDirection;
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results =  getEntityManager()
                                     .createQuery(
                                       "select cc from Fpxxfq1a5xwwqqhxxxxxitem  cc where cc.zexxutoxlhxxxxxxxxxxowner=:owner  and  ((zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukixbxxxxxxxxxxxmatcode) between :start and :end) ) order by "+ lorder)
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
              //all others
                   //statusfield


                 //:: type cast operator conflicts with the JPA so use cast(:searchDate AS date) dateField z6xxcztxlxxxxxxxxxxxstatusfldt statflgdt z6xxcztxlxxxxxxxxxxxstatusfldt
		   sresults =  getEntityManager()
					.createQuery(
		   "select cc from Fpxxfq1a5xwwqqhxxxxxitem  cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and (:searchStatus is null  or cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :searchStatus) ) and (lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%'))) and (cast(cc.z6xxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and lower(a0xxukixbxxxxxxxxxxxmatcode) between :start and :end) ) order by "+ lorder)
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
    * The following method overrides seam method because setOrder did not work 
    * @param args -none
    * @return List<Fpxxfq1a5xwwqqhxxxxxitem>
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

     public List<Fpxxfq1a5xwwqqhxxxxxitem> getResultList(){
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
      if(sortByValue.equals("lh")){
       String jj=lorderDirection;
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
                                   List<Fpxxfq1a5xwwqqhxxxxxitem> results =  getEntityManager()
                                    .createQuery(
                                     "select cc from Fpxxfq1a5xwwqqhxxxxxitem  cc where cc.zexxutoxlhxxxxxxxxxxowner=:owner  and ((cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ) and (lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%'))) and (lower(a0xxukixbxxxxxxxxxxxmatcode) between :start and :end) ) order by "+ lorder)
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
              //all others
                   //statusfield


                 //:: type cast operator conflicts with the JPA so use cast(:searchDate AS date) dateField z6xxcztxlxxxxxxxxxxxstatusfldt statflgdt z6xxcztxlxxxxxxxxxxxstatusfldt
	   sresults =  getEntityManager()
	   .createQuery(
                    //these have statusfields but some needs extra search
	    "select cc from Fpxxfq1a5xwwqqhxxxxxitem  cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((:searchStatus is null  or cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :searchStatus) ) and (:searchType is null or cc.c6xxusxrbv16xxxxxxxxtype = :searchType)  and ((lower(cc.a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(cc.w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%')) or lower(cc.a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%'))) and (cast(cc.z6xxcztxlxxxxxxxxxxxstatusfldt AS date) >= cast(:searchDate AS date)) and lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between :start and :end) ) order by "+ lorder)
                    .setParameter("owner2", owner2Code).setHint("org.hibernate.readOnly","false").setParameter("searchVal", searchVal).setParameter("searchDate", searchDateD).setParameter("start", start.toLowerCase()).setParameter("end", end.toLowerCase()).setParameter("searchStatus", searchStatus).setParameter("searchType", searchType)
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

     public Fpxxfq1a5xwwqqhxxxxxitem getSidSToEntity(String sidS){
      return getSidToEntity(Integer.parseInt(sidS));//
     }

     public Fpxxfq1a5xwwqqhxxxxxitem getSidToEntity(Integer sid){
      Fpxxfq1a5xwwqqhxxxxxitem entity=null;
      List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2Code)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("item")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

     } 













	public List<Fpxxfq1a5xwwqqhxxxxxitem> getFlaggedAsList(int flag) {
		// will return objects matching flag 
		return getEntityManager()
				.createQuery(
						"select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.z5xxzzfxhhxxxxxxxxxxstatusfl = :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getNotFlaggedAsList(int flag) {
		// will return objects not matching flag 

		return getEntityManager()
				.createQuery(
						"select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
				.setParameter("flag", flag).setParameter("owner2", owner2Code).getResultList();

	}

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getOldByList(int days) {
	// will return objects statusfldt < today-days
        calendar.add(Calendar.DATE, -days); //xx days in past, can check further for 15 days/7 days/ expiry
        Date searchDate= calendar.getTime();

	return getEntityManager()
	 .createQuery(
	  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cast(cc.z6xxcztxlxxxxxxxxxxxstatusfldt AS date) < cast(:searchDate AS date AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2)")
	   .setParameter("searchDate", searchDate).setParameter("owner2", owner2Code).getResultList();

	}


     public List<Fpxxfq1a5xwwqqhxxxxxitem> entityDetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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
    //key fields contd




         public Fpxxfq1a5xwwqqhxxxxxitem getKeyToEntity(String key){
      Fpxxfq1a5xwwqqhxxxxxitem entity=null;
      List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode = :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key)
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("item")+" "+bundle.getString("multiple")+" "+bundle.getString("entries")+" "+bundle.getString("found"),""));
          // end user may see it,FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          // FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
          customIdentity.setHoldValue3(""+results.size());//caller may examine this
      }
      return results.get(0);

    } 


     public Fpxxfq1a5xwwqqhxxxxxitem getKeyContainsToEntity(String key){
      Fpxxfq1a5xwwqqhxxxxxitem entity=null;
      List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
      try{
       results = getEntityManager()
	.createQuery(
	"select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode like :nKeyName AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')")
	.setParameter("nKeyName",key+'%')
	.setParameter("owner2", owner2Code)
	.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("item")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
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
      String value= getEntityManager().createQuery(" select a0xxukixbxxxxxxxxxxxmatcode from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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
      String value= getEntityManager().createQuery(" select a0xxukixbxxxxxxxxxxxmatcode||'/'||zzxxu2oxxhxxxxxxxxxxowner2 from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxuobxbxxxxxxxxxxxsid = :keyOfEntity  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')   order by cc.a0xxuobxbxxxxxxxxxxxsid  ")
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
 
      for (Fpxxfq1a5xwwqqhxxxxxitem fpxxfq1a5xwwqqhxxxxxitem : getSuggestList(userInput)) {
         ret.add(fpxxfq1a5xwwqqhxxxxxitem.getA0xxukixbxxxxxxxxxxxmatcode());
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
     public List<Fpxxfq1a5xwwqqhxxxxxitem> getSuggestList(String prefix,String hideTypePrefix) {
     // getSuggestList is called when non key values are also needed like item key, its price etc 
     // when is keyfield blank probably never for keyAutogen
     
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity  AND !( cc.c6xxusxrbv16xxxxxxxxtype LIKE  hideTypePrefix )  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukixbxxxxxxxxxxxmatcode  ")
        				.setParameter("keyOfEntity", prefix).setParameter("owner2", owner2Code)
					.getResultList();
	}
   




        /***
        * assumes aliascode in Item has ApplicationFunction (client prodcode) value like fsot or eege or ee
        * manually add code in items meant for raaspi subscription, better put a warning if raaspi,SI-D and 
        * alias code is empty
        */
        public Integer clientApplicationFunctionToSid(String key){
         fpxxfq1a5xwwqqhxxxxxitem=null;
	 List<Fpxxfq1a5xwwqqhxxxxxitem> results =  getEntityManager()
	 .createQuery("select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.f1xxuxxrbvxxxxxxxxxxaliascode = :Key AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by  z6xxcztxlxxxxxxxxxxxstatusfldt")
         .setParameter("owner2", owner2Code)
         .setParameter("Key", key).getResultList();
         if(!results.isEmpty()){
          fpxxfq1a5xwwqqhxxxxxitem = results.get(0);
          return fpxxfq1a5xwwqqhxxxxxitem.getA0xxuobxbxxxxxxxxxxxsid();
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
          Fpxxfq1a5xwwqqhxxxxxitem item=null;
          searchPattern=searchPattern.trim();
          String[] myData = searchPattern.split(", ");
          String matCode=null;
          try{
           if (st.equals("t")){
            //seach selectItem list for a match
            Iterator<Fpxxfq1a5xwwqqhxxxxxitem> itr = getSuggestListTheme("","").iterator();
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
		"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem  cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 AND c6xxusxrbv16xxxxxxxxtype = 'SI-L1' ")
		.setParameter("owner2", owner2Code).setParameter("flag", mclosed)
		.getSingleResult();
                if(count > 0){
                 netCount=1;
                }
		count =  (Long)getEntityManager()
		.createQuery(
		"select count(cc) from Fpxxfq1a5xwwqqhxxxxxitem  cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 AND c6xxusxrbv16xxxxxxxxtype = 'IB' ")
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getSuggestListTheme(String vendor,String theme) {
                //returns item type SI-D and misccode2 matching parameter theme
                // returned item records have theme vendor code in misccode1 
                // for now parameter vendor ignored, add logic to use vendor/theme and return all items if needed 
                // returns SI-L1 if vendor is C
                   if(vendor.isEmpty() && !theme.isEmpty()){ 
                       if(theme.equals("1")){
                        theme="%/Business"; 
                    return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
                    .setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
                    .getResultList();
                   }
                       if(theme.equals("2")){
                        theme="%/ERP"; 
			 return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("3")){
                        theme="%/Laboratory"; 
			 return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("45")){
                        theme="%/Organization"; 
			 return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("67")){
                        theme="%/Agency"; 
			 return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                        }
                       if(theme.equals("89")){
                        theme="%/News Forum"; 
                        String theme2="%/Users Forum";
			 return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  :theme or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE :theme2 or cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 LIKE  '%/Generic') and cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme).setParameter("theme2", theme2)
					.getResultList();
                        }

			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :theme) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH' AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme)
					.getResultList();
                   }
                   if(vendor.isEmpty() && theme.isEmpty()){
             
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
					.getResultList();
                   }

                   if(!vendor.isEmpty() && theme.isEmpty()){
                      if(vendor.equals("C")){
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='')  AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' ) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-L1' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
					.getResultList();
                      }else{
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :vendor AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' ) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("vendor", vendor)
					.getResultList();
                      }
                   }
                   if(!vendor.isEmpty() && !theme.isEmpty()){
             
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :vendor) AND (cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :theme) AND cc.c6xxusxrbv16xxxxxxxxtype ='SI-D' AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) order by cc.y2xxuxxrbvxxxxxxxxxxmisccode1,cc.y3xxuxxrbvxxxxxxxxxxmisccode2")
        				.setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM").setParameter("theme", theme).setParameter("vendor", vendor)
					.getResultList();
                   }
                   return null;
        }


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getSystemSuggestList(String prefix) {
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                return null;

        }

     public List<Fpxxfq1a5xwwqqhxxxxxitem> getSuggestList(String prefix) {
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

 
 // Item but depends called by whom
                //  Item but depends called by whom
                if(prefix !=null && prefix.equals("a") ){//used by countAlias stock count
                         prefix="0";
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.f1xxuxxrbvxxxxxxxxxxaliascode is not null AND cc.f1xxuxxrbvxxxxxxxxxxaliascode !='' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();

                }

                if(prefix.startsWith("LT-")){
                        // sorted by keyfield LT is labtest
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "LT-%").setParameter("owner2", owner2Code)
					.getResultList();
                }
                if(prefix.startsWith("SI-L%")){
                //item add dont show details, only shopping sub categories
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "SI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
                }
                if(prefix.startsWith("SI-L*")){
                //item add dont show details, only shopping and theme items sub categories 
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)    order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "SI-L*").setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
                }
                if(prefix.startsWith("SI-L1")){
                //item add dont show details, only shopping categories
                        prefix="0";
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "SI-L1").setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
                }
                if(prefix.startsWith("BI-L*")){
                //item add dont show details, only blog categories
                String owner2CodeS="SYSTEM";// test how it behaves
                 prefix="0";
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 //NC will come here
                 }else{
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "BI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }
                if(prefix.startsWith("PI-L*")){
                //item add dont show details, only shopping categories  added owner check  allow public
                 prefix="0";
                 String owner2CodeS="SYSTEM";// test how it behaves
                 if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode or cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = '_public') order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "PI-L%").setParameter("owner2", owner2Code).setParameter("ownerCode", ownerCode).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }else{
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype LIKE  :showTypePrefix1  AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)   order by cc.a0xxukixbxxxxxxxxxxxmatcode")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("showTypePrefix1", "PI-L%").setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS)
					.getResultList();
                 }
                }else{
                // in transactions and itemjob or bom details hide categories and show shopping (SI-) and inventory(IX)
                 String hideTypePrefix1="%I-L%";
                 String hideTypePrefix2="PI-D";
                 String hideTypePrefix1B="%I-L%";
			return getEntityManager().createQuery(" select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE  :hideTypePrefix1 AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE  :hideTypePrefix1B AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE  :hideTypePrefix2  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.a0xxukixbxxxxxxxxxxxmatcode  ")
        				.setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("hideTypePrefix1", hideTypePrefix1).setParameter("hideTypePrefix1B", hideTypePrefix1B).setParameter("hideTypePrefix2", hideTypePrefix2).setParameter("owner2", owner2Code)
					.getResultList();
                }
              

	}
     public List<Fpxxfq1a5xwwqqhxxxxxitem> getNextSids(Integer sid){
      sresults=null;// reset 
      List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and cc.a0xxuobxbxxxxxxxxxxxsid >=:sid order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).setParameter("sid", sid)
					.getResultList();
      return results;
     }
     public List<Integer> getAllSids(){
      List<Integer> results=null;
		results	  =  getEntityManager()
			.createQuery("select cc.a0xxuobxbxxxxxxxxxxxsid from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner2", owner2Code).getResultList();
      return results;
     }



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










	public List<String> getwwqqhxxxxxitemKeyList() {
                 // xxxxxxxxxa0xxuobxbxxxxxxxxxxxsid  java.lang.String a0xxukixbxxxxxxxxxxxmatcode
    
		       String enteredValue = "";
                        //order case insensitive
			return getEntityManager().createQuery("select cc.a0xxukixbxxxxxxxxxxxmatcode from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxukixbxxxxxxxxxxxmatcode >=:keyOfEntity   AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM')  order by lower(cc.a0xxukixbxxxxxxxxxxxmatcode) ")
        				.setParameter("keyOfEntity", enteredValue).setParameter("owner2", owner2Code)
					.getResultList();
   


      }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getSortedByParentList(String type) {
               if( customIdentity.hasRole("VW") || customIdentity.hasRole("VQ")||customIdentity.hasRole("VH")||customIdentity.hasRole("PH")){
                if (type.equals("all")){
 		 return getEntityManager()
		 .createQuery(
		 " select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode  order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode  ")
                  .setParameter("ownerCode", ownerCode).setParameter("owner2", owner2Code)
		 .getResultList();

                }else{
 		 return getEntityManager()
		 .createQuery(
		 " select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.zexxutoxlhxxxxxxxxxxowner=:ownerCode and cc.c6xxusxrbv16xxxxxxxxtype like :type order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode  ")
                  .setParameter("ownerCode", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type)
		 .getResultList();
                }
               }else{
                if (type.equals("all")){
		 return getEntityManager()
		 .createQuery(
		 " select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2   order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode  ")
                 .setParameter("owner2", owner2Code)
		 .getResultList();
                }else{
		 return getEntityManager()
		 .createQuery(
		 " select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and cc.c6xxusxrbv16xxxxxxxxtype like :type  order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode  ")
                  .setParameter("owner2", owner2Code).setParameter("type", type)
		 .getResultList();
                }
               }

	}


        private List<Fpxxfq1a5xwwqqhxxxxxitem>items;
        private Fpxxfq1a5xwwqqhxxxxxitem item;
        private String prevParent="";
        private Map<String, List<Fpxxfq1a5xwwqqhxxxxxitem> > itemsMap;
        private Map<String, List<Fpxxfq1a5xwwqqhxxxxxitem> > itemsSIMap;

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
           Map<String, List<Fpxxfq1a5xwwqqhxxxxxitem>> itemsMap = getItemsMap();
           //getItemsMap() > get resultList > filter out non parent
           // returns item entries for a parent key
           for (Map.Entry<String, List<Fpxxfq1a5xwwqqhxxxxxitem>> entry : itemsMap.entrySet()) {
            TreeNode node=new DefaultTreeNode(entry.getKey(),rootNode);
            for (Fpxxfq1a5xwwqqhxxxxxitem child : entry.getValue()){
             TreeNode childNode=new DefaultTreeNode(child.getA0xxukixbxxxxxxxxxxxmatcode(),node);
            }
           }
          }
        public Map<String, List<Fpxxfq1a5xwwqqhxxxxxitem> > getItemsMap(){
        //item=getResultList().get(0);
        List<Fpxxfq1a5xwwqqhxxxxxitem> itemsFromMap = null;
      if (itemsMap==null){
       itemsMap = new HashMap<String, List<Fpxxfq1a5xwwqqhxxxxxitem>>();
       setMaxResultsVal(1200);
       // no need, caused filtering  setOrderColumn("fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode");
       for (Fpxxfq1a5xwwqqhxxxxxitem item : getResultList()) {
        // skip if no parent, capture child detail and save parent as prev.
        if (item.getFpxxfq1a5xwwqqhxxxxxitem() != null ){
         if (!item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode().equals(prevParent)){
          itemsFromMap = new ArrayList<Fpxxfq1a5xwwqqhxxxxxitem>();
          prevParent=item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode();
         }
        }
        // skip if no parent, else Map parent key, child details as a list of details ie jay as key 
        //  but value as a list of ronnie,rian (itemsFromMap
        if (item.getFpxxfq1a5xwwqqhxxxxxitem() != null){
         itemsFromMap.add(item);
         itemsMap.put(item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode(), itemsFromMap);
        }
       }
      }
      return itemsMap;
     }

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


     public Map<String, List<Fpxxfq1a5xwwqqhxxxxxitem> > getItemsSIMap(){
      //item=getResultList().get(0);
        List<Fpxxfq1a5xwwqqhxxxxxitem> itemsFromMap = null;
      if (itemsMap==null){
       itemsMap = new HashMap<String, List<Fpxxfq1a5xwwqqhxxxxxitem>>();
         setMaxResultsVal(1200);
         setOrderColumn("fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode");
       for (Fpxxfq1a5xwwqqhxxxxxitem item : getResultList()) {
        // skip if no parent, capture child detail if type SI-D and save parent as prev.
        if (item.getFpxxfq1a5xwwqqhxxxxxitem() != null ){
         if ( item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode() != prevParent){
          itemsFromMap = new ArrayList<Fpxxfq1a5xwwqqhxxxxxitem>();
          prevParent=item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode();
         }
        }
        // skip if no parent, else Map parent key, child details as a list of details ie jay as key 
        //  but value as a list of ronnie,rian (itemsFromMap
        if (item.getFpxxfq1a5xwwqqhxxxxxitem() != null && item.getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
         itemsFromMap.add(item);
         itemsMap.put(item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode(), itemsFromMap);
        }
       }
      }
      return itemsMap;
     }

	private Integer prevParentSid = null;
	public List<String> getItemsMapKeys(String type) {
	List<String> parents = new ArrayList<String>();
	for (Fpxxfq1a5xwwqqhxxxxxitem item : getSortedByParentList(type)) {
 	 if (item.getFpxxfq1a5xwwqqhxxxxxitem() != null ) {
          // save in parents list only if the parent's parent is highest ie it has no parent
          if (item.getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem()==null){
	   if (item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid() != prevParentSid) {
            parents.add(item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode());
	    prevParentSid = item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
           }
          }
         }
        }
	return parents;
	}

	public List<String> getItemsSIMapKeys() {
	List<String> parents = new ArrayList<String>();
	for (Fpxxfq1a5xwwqqhxxxxxitem item : getSortedByParentList("SI-D")) {
        if (item.getFpxxfq1a5xwwqqhxxxxxitem() != null && item.getC6xxusxrbv16xxxxxxxxtype().equals("SI-D")){
          // save in parents list only if the parent's parent is highest ie it has no parent
          if (item.getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem()==null){
	   if (item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid() != prevParentSid) {
            parents.add(item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxukixbxxxxxxxxxxxmatcode());
	    prevParentSid = item.getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
           }
          }
         }
        }
	 return parents;
	}

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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.y2xxuxxrbvxxxxxxxxxxmisccode1='' or cc.zexxutoxlhxxxxxxxxxxowner =:owner ) AND (cc.c6xxusxrbv16xxxxxxxxtype like 'IB%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IQ%'  ) AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE  lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )))  order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
              "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.y2xxuxxrbvxxxxxxxxxxmisccode1='' or cc.zexxutoxlhxxxxxxxxxxowner =:owner ) AND (cc.c6xxusxrbv16xxxxxxxxtype like 'IB%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IQ%'  ) AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE  lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )))  order by cc.a0xxukixbxxxxxxxxxxxmatcode")
               .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("logonId", logonId).setParameter("owner", owner).setFirstResult(0).getResultList();
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
              FacesMessage.SEVERITY_INFO,bundle.getString("found")+" "+sresults.size()+" "+bundle.getString("result(s)")+" "+bundle.getString("in")+" "+bundle.getString("isuues")+" "+bundle.getString("items"),""));
            }
            //shopping items first
            sresults = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype like 'BI%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IB%' OR cc.c6xxusxrbv16xxxxxxxxtype like 'IX%') AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
                 if (sresults.isEmpty()){
                  // search in clob now , remove 19 now obsolete
                  cresults = getEntityManager()
		  .createQuery(
		   "select cc from Yxxxuq1m1xwwqqqxxxxxclobdata cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (lower(cc.a1xxuxxxbv49xxxxxxxxfromkey) LIKE   lower(concat ('%',:p2,'%')) OR lower(cc.a1xxuxxxbv49xxxxxxxxfromkey) LIKE   lower(concat ('%',:p3,'%')) ) AND lower(cc.b1xxuzaxbvxxxxxxxxxxdata) LIKE   lower(concat ('%',:pattern,'%')) ) ")
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'PI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) ) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'PI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) ) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))  OR lower(cc.g2xxuxn1bvxxxxxxxxxxsubcodesn) LIKE lower(concat('%',:pattern,'%')) OR lower(cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2) LIKE lower(concat('%',:pattern,'%')) )) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", "SYSTEM").setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'BI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%'  AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%'))) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is null OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:blankv) OR (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 <>:blankv AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2= :answerv)))) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("pattern", searchPattern).setParameter("owner2", masterSiteCode).setParameter("blankv", "").setParameter("answerv", customIdentity.getOption16())
					.getResultList();
            }else{
                sresults = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype like 'SI%' AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) LIKE   lower(concat ('%',:pattern,'%')) OR lower(cc.b1xxuszsbvxxxxxxxxxxdescript) LIKE  lower( concat ('%',:pattern,'%'))  OR lower(cc.y2xxuxxrbvxxxxxxxxxxmisccode1) LIKE   lower(concat ('%',:pattern,'%')))) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND  cc.fpxxuq1a5xitem.a0xxukixbxxxxxxxxxxxmatcode = :parent AND (cc.a0xxukixbxxxxxxxxxxxmatcode LIKE  :pattern OR cc.b1xxuszsbvxxxxxxxxxxdescript LIKE  :pattern  OR cc.y2xxuxxrbvxxxxxxxxxxmisccode1 LIKE  :pattern)) order by cc.a0xxukixbxxxxxxxxxxxmatcode ")
		   .setParameter("type", type).setParameter("parent", parent).setParameter("pattern", searchPattern).setParameter("owner2", owner2Code).getResultList();
           return "ItemDetailsBrowse";
	}

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
     	   List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", sid)
					.getResultList();

         return results.size();
        }


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemCategoriesBrowseList(String type) {
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSubCategoriesBrowseList(String type) {
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsBrowseList(String type) {
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemBrowseList() {

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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   searchVal="";
                   itemTagType="";//reset before next call 
                   return results;

                }
                if(searchVal !=null && !searchVal.isEmpty()){//
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   searchVal="";
                   itemTagType="";//reset before next call 
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).getResultList();
                   searchVal="";
                   itemTagType="";//reset before next call 
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c2fbcxxrehxxsxxxxxxxspriceffdt <= :toDay AND cc.h1xxcxxrbxxxxxxxxxxxeffdate >= :toDay AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("toDay", toDay).setParameter("type", type).getResultList();
                   return results;

                }
                if(sortByValue.equals(" i")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).getResultList();
                   return results;
                }

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
     	   List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogSubDetBrowseList(int sid) {
         subcategoryUi=sid;
         return getBlogSubBrowseList();
        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogCatSubBrowseList(int sid) {
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogSubBrowseList() {
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;

                }

          // 
          //
          // return null;
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
		    .getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only but dont use sid only check for ownwr2

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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




	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogBrowseList(String type) {
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogDetailsBrowseList(String type) {
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogBrowseList() {
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
                 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
                 .createQuery(
                  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
                   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";//reset before next call 
                   return results;

                }

                if(searchVal !=null && !searchVal.isEmpty()){//
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";//reset before next call 
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("toDay", toDay).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals(" i")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                   return results;
                }

          // show all parents items ie BI-L1 types and ordered by 
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).getResultList();
                return results;
       }
       else {
          // category has parent code, so that parent item only
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getSystemBlogBrowseList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  ) AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2S", owner2CodeS)
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S  )  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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




	public List<Fpxxfq1a5xwwqqhxxxxxitem> getThemeBrowseList(String vendor,String theme) {
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;
                }

                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("toDay", toDay).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals(" i")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM").getResultList();
                   return results;
                }

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code).setParameter("owner2S", "SYSTEM")
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getSubThemeBrowseList(String vendor,String theme) {
           
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !='' AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", masterSiteCode).setParameter("owner2S", "SYSTEM")
              .getResultList();
           return results;
       }
       else {
          // subcategory has parent code, so that parent item only
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn='TH'  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 is not null AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 !='' AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 is not null AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 !=''  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogCatAndSubBrowseList() {
               String type="BI-L%";
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
                type="BI-L1";
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
			.getResultList();
   
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("BI-L*") 
             && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//subcat get its siblings
                type="BI-L*";
                nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();

            }else{
             if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().contains("BI-D") 
              && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//direct cat or subcat exists
                type="BI-L%";
                if(getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem()==null){
                 nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                }else{//get sub's parent
                 nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                }
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogDetailsForCatOrViaSubBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=-1;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogDetailsForSubOnlyBrowseList(int sid) {
         subcategoryUi=sid;
         categoryUi=0;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getBlogDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }
 
       public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogDetailsAllBrowseList(int sid) {
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
     public List<Fpxxfq1a5xwwqqhxxxxxitem> getBlogDetailsBrowseList() {
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }

                // not search below, here if search. changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
                if(searchVal2 !=null && !searchVal2.isEmpty()){// include if parent misccode1 is null  added type check
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (( (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) and (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '') and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).setParameter("searchVal", searchVal2).getResultList();
                   //searchVal="";
                   return results;
                }
       }
       if (subcategory != 0 ){
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("subcategory", subcategory)
			.getResultList();
           return results;
       }
       if (category == 0 ){
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
              if(subcategoryUi == -1){
               //include where cat is parent or as grandparent
               //category has value , so so all details under it , including one level down ie under any subcat
                // show details if under this cat and under this subcat
     	        List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;

              }else{

                // show details only not sub category item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 or cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
    public List<Fpxxfq1a5xwwqqhxxxxxitem> getSystemBlogDetailsBrowseList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S)  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2S", owner2CodeS).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
       if (category == 0 ){
                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S ) AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)   AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2S", owner2CodeS).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
                // show details only not sub category item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2S )  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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





	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsFeesList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsPaidList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
       if (category == 0 ){
                // first time ? allways show something, if empty h:command wont submit because it was not rendered before
                // will show upto first 10 details  
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid !=null ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc").setMaxResults(10)
		   .setParameter("type", type).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
       }
       else {
                // show details only not sub category item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

       public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSubDetBrowseList(int sid) {
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



	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemCatSubBrowseList(int sid) {
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemCatAndSubBrowseList() {
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
			.getResultList();
   
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("SI-L*") 
             && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//subcat get its siblings
                type="SI-L*";
                nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSubBrowseList() {
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype = :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   return results;

                }

          // 
          //
          // return null;
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
		    .getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only but dont use sid only check for ownwr2

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSub3BrowseList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("category", subcategory).setParameter("type", type).setParameter("flag", mclosed)
					.getResultList();
           return results;
       }
       if (subcategory3 != 0 ){
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSubPaidList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
     	   List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

       public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageSubDetBrowseList(int sid) {
         subcategoryUi=sid;
         return getImageSubBrowseList();
        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageCatSubBrowseList(int sid) {
         subcategoryUi=0;
         categoryUi=sid;

         return getImageSubBrowseList();
        }


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageBrowseList(String type) {
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsBrowseList(String type) {
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageCategoriesBrowseList(String type) {
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageBrowseList() {
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }

                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals(" i")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  '0' AND 'i')))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                   return results;
                }

          // show all parents items ie PI-L1 types and ordered by 
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("flag", mclosed).setParameter("owner2", owner2Code)
					.getResultList();
           return results;
       }
       else {
          // category has parent code, so that parent item only.  no need to sort for one item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag   )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageCatAndSubBrowseList() {
               String type="PI-L%";
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
                type="PI-L1";
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", categoryJay)
			.getResultList();
   
           }else{
            if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().equals("PI-L*") 
             && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//subcat get its siblings
                type="PI-L*";
                nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();

            }else{
             if(getSidToEntity(categoryJay) !=null && getSidToEntity(categoryJay).getC6xxusxrbv16xxxxxxxxtype().contains("PI-D") 
              && getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem() != null){//direct cat or subcat exists
                type="PI-L%";
                if(getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem()==null){
                 nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                }else{//get sub's parent
                 nSidP=getSidToEntity(categoryJay).getFpxxfq1a5xwwqqhxxxxxitem().getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
                }
		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag AND (cc.a0xxuobxbxxxxxxxxxxxsid = :nSid OR (cc.fpxxfq1a5xwwqqhxxxxxitem !=null AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :nSid)) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed).setParameter("nSid", nSidP)
			.getResultList();
             }
            }
           }   
          //no param, show subcats
          }else{

		results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype LIKE  :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("flag", mclosed)
			.getResultList();
          }
          
           return results;

        }



	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageSubBrowseList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category AND cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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


	public List<Fpxxfq1a5xwwqqhxxxxxitem> getIssueBrowseList() {
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner) )  ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner) ) ) ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ) ) ) order by cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  )))  AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("mi")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2) AND  (cc.zexxutoxlhxxxxxxxxxxowner =:owner)  )) order by cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("owner", owner).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type1 OR cc.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ))) order by cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner).getResultList();
                   return results;
                }


           if(this.markedOnes){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ) AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2)
                           .setParameter("flag", mclosed).setParameter("logonId", logonId)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
           else{
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND  (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 != null AND (cc.y2xxuxxrbvxxxxxxxxxxmisccode1 =:logonId or cc.zexxutoxlhxxxxxxxxxxowner =:owner)  ) AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2).setParameter("logonId", logonId).setParameter("owner", owner)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
     }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getIssueRepliesList(int parentSid) {
                // pagination is done by main table
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :pSid  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getReviewBrowseList() {
           
           // if search was used then show search results 
           String type1="CI-L1";
           String type2="CI-L1";

           if(!"".equals(this.searchPattern) && !"xyz..".equals(this.searchPattern) ){
            return sresults;
           }
           if(this.markedOnes){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND cc.z5xxzzfxhhxxxxxxxxxxstatusfl != :flag  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2)
                           .setParameter("flag", mclosed)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
           else{
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.c6xxusxrbv16xxxxxxxxtype = :type1 OR cc.c6xxusxrbv16xxxxxxxxtype = :type2) AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid is null)  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type1", type1).setParameter("type2", type2)
                           .setMaxResults(6).setFirstResult(getFirstResult()!=null?getFirstResult():0)
					.getResultList();
            return results;
           }
     }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getReviewRepliesList(int parentSid) {
                // pagination is done by main table
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :pSid  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsForCatOrViaSubBrowseList(int sid) {
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

        public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsForSubOnlyBrowseList(int sid) {
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

       public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getItemDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

       public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsAllBrowseList(int sid) {
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsBrowseList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH' AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory3)
					.getResultList();
           return results;
        }
        if (subcategory != 0 ){
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype = :type AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }


                if(searchVal2 !=null && !searchVal2.isEmpty()){//
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where ( (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  and (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '') and ( lower(a0xxukixbxxxxxxxxxxxmatcode) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("type2", type2).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal2).getResultList();
                   //searchVal="";
                   return results;
                }
                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.c2fbcxxrehxxsxxxxxxxspriceffdt <= :toDay AND cc.h1xxcxxrbxxxxxxxxxxxeffdate >= :toDay)  order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("az")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("za")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
              if(subcategoryUi == -1){
               //include where cat is parent or as grandparent
               //category has value , so so all details under it , including one level down ie under any subcat
                // show details if under this cat and under this subcat
     	        List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;

              }else{
                // cat as parent only
     	        List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  and cc.b8fbzpxxbvxxxxxxxxxxselprice != 0 AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsForCatOrViaSubBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=-1;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsForSubOnlyBrowseList(int sid) {
         subcategoryUi=sid;
         categoryUi=0;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsForCatOnlyBrowseList(int sid) {
         categoryUi=sid;
         subcategoryUi=0;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsAllBrowseList(int sid) {
         categoryUi=0;
         subcategoryUi=-2;
         sresults=getImageDetailsBrowseList();
         categoryUi=0;//reset before next call
         subcategoryUi=0;
         return sresults; 
        }



	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsBrowseList() {
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
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH') AND ((cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) and ( lower(y2xxuxxrbvxxxxxxxxxxmisccode1) like lower(concat('%',:searchVal,'%')) or lower(w7xxuznxbvxxxxxxxxxxnotes) like lower(concat('%',:searchVal,'%'))or lower(b1xxuszsbvxxxxxxxxxxdescript) like lower(concat('%',:searchVal,'%')) ) ) order by case when cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null then ''  else cc.g2xxuxn1bvxxxxxxxxxxsubcodesn end ,case when cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2 is null then ''  else cc.g2xxuxn2bvxxxxxxxxxxsubcodesn2  end,case when cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3 is null then ''  else cc.g2xxuxn3bvxxxxxxxxxxsubcodesn3  end,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("type", type).setParameter("owner2", owner2Code).setParameter("searchVal", searchVal).getResultList();
                   //searchVal="";
                   itemTagType="";
                   return results;

                }

                // changed from show only if category selected, otherwise mismatch repeat and browselist and add commandbutton fails
                // show all details jay put a limit because pagination is via client memory, added parent in sort
                setMaxResultsVal(6);
                if(sortByValue.equals("bm")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

                if(sortByValue.equals("lh")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hl")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.b8fbzpxxbvxxxxxxxxxxselprice desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("si")){
                Date toDay= calendar.getTime();

		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2) AND cc.y5xxcxxrlxxxxxxxxxxxdatetorenew < :toDay) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.c1xxzxxxbhxxsxxxxxxxspricnew desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).setParameter("toDay", toDay).getResultList();
                   return results;
                }
                if(sortByValue.equals("ai")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2 AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'a' AND 'i'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("jq")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2 AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'j' AND 'q'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("rz")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2 AND (lower(cc.a0xxukixbxxxxxxxxxxxmatcode) between  'r' AND 'z'))) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("hr")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.z7xxzxxxlvxxxxxxxxxxcuordqty desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }
                if(sortByValue.equals("ne")){
		 List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null) AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.z2xxcsxrlxxxxxxxxxxxdateadded desc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
                   return results;
                }

		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype LIKE :type2 AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND (cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 = '' or cc.fpxxfq1a5xwwqqhxxxxxitem.y2xxuxxrbvxxxxxxxxxxmisccode1 is null)  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type AND cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)) order by cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid,cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setMaxResults(maxResultsVal).setParameter("type", type).setParameter("type2", type2).getResultList();
           return results;
       }
       else {
              if(subcategoryUi == -1){
               //include where cat is parent or as grandparent
               //category has value , so so all details under it , including one level down ie under any subcat
                // show details if under this cat and under this subcat
     	        List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.g2xxuxn1bvxxxxxxxxxxsubcodesn is null or cc.g2xxuxn1bvxxxxxxxxxxsubcodesn !='TH')  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category OR (cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem != null AND cc.fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category)  )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("type2", type2).setParameter("category", category)
					.getResultList();
                return results;

              }else{

                // show selected details only not sub category item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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
	public List<Fpxxfq1a5xwwqqhxxxxxitem> getImageDetailsBrowseListS(Integer category,Integer subcategory) {
        //xxListS for slide, category and subcategory are sid integers
       String type="PI-%";//all shopping only ie detail or category or subcategory
       String type2="PI-L%";//categoey or subcategory

      try{
        if (subcategory != 0 ){
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :subcategory ) )  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
		   .setParameter("owner2", owner2Code).setParameter("subcategory", subcategory)
					.getResultList();
           return results;
       }
                // show selected details only not sub category item
		List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  (cc.c6xxusxrbv16xxxxxxxxtype LIKE :type OR cc.c6xxusxrbv16xxxxxxxxtype NOT LIKE :type2)  AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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






	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSearchByParameterList() {
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
         List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
         if (identity.isLoggedIn()){
           yxxxch575xwwqqhxxxxxuserprofl=yxxxuh566xwwqqwxxxxxuserList.getUserProfiles();
         }
         if(yxxxch575xwwqqhxxxxxuserprofl !=null){
          amount=yxxxch575xwwqqhxxxxxuserprofl.getE3xxzxxxlvxxxxxxxxxxmargin(); 
          zone=yxxxch575xwwqqhxxxxxuserprofl.getD3xxuxxrbvxxxxxxxxxxdtstyle();
          criteria=yxxxch575xwwqqhxxxxxuserprofl.getD1xxuxxrbvxxxxxxxxxxmtstyle();           
          type=yxxxch575xwwqqhxxxxxuserprofl.getD2xxuxxrbvxxxxxxxxxxststyle(); 
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemSearchByParameterList(String zone,BigDecimal amount,String criteria,String type) {
                 if (!identity.isLoggedIn()){
                     if(customIdentity.getOwner().equals("sss")){
                      String ts=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                      subKey=ts.substring(17,19)+ts.substring(14,16)+ts.substring(11,13)+ts.substring(0,7)+userIP;
                      ownerCode=subKey+"sss";
                      customIdentity.setOwner(ownerCode);
                      // create temp customer record
 	              if (jxxxuq201xwwqqhxxxxxcustomer == null) {
 	               jxxxuq201xwwqqhxxxxxcustomer=jxxxuq201xwwqqhxxxxxcustomerHome.getInstance();
	              }

                      jxxxuq201xwwqqhxxxxxcustomer.setA0xxukxxbvxxxxxxxxxxcustomer(subKey);
                      jxxxuq201xwwqqhxxxxxcustomer.setZdxxutoxlhxxxxxxxxxxowner(ownerCode);
                      jxxxuq201xwwqqhxxxxxcustomer.setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                      jxxxuq201xwwqqhxxxxxcustomer.setF2xxuwmxbv40xxxxxxxxintegrset("DEFAULT");
                      jxxxuq201xwwqqhxxxxxcustomerHome.persist();

                      // create temp user record 
 	              if (yxxxuh566xwwqqwxxxxxuser == null) {
 	               yxxxuh566xwwqqwxxxxxuser=yxxxuh566xwwqqwxxxxxuserHome.getInstance();
	              }
  
                      yxxxuh566xwwqqwxxxxxuser.setA0xxukuxbvxxxxxxxxxxid(subKey);
                      yxxxuh566xwwqqwxxxxxuser.setJxxxuq201xwwqqhxxxxxcustomer(jxxxuq201xwwqqhxxxxxcustomer);
                      yxxxuh566xwwqqwxxxxxuser.setZ5xxutoxlhxxxxxxxxxxowner(ownerCode);
                      yxxxuh566xwwqqwxxxxxuser.setZzxxu2oxxhxxxxxxxxxxowner2(owner2Code);
                      yxxxuh566xwwqqwxxxxxuserHome.persist();
                      customIdentity.setOwner(ownerCode);
                      // set currentUserName to this temp user 
                      ///customIdentity.getCredentials().setUsername(subKey);
                      customIdentity.setUserSid(yxxxuh566xwwqqwxxxxxuser.getA0xxuobxbxxxxxxxxxxxsid());
                     
                   }
                  }
                  //end of temp user logic
          this.showResultsCount=true;
          List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;

          try {
           //12 zone
           if(zone == null || zone.equals("")){
            //13 criteria null zone null
            if(criteria == null || criteria.equals("")){
             if(type == null || type.equals("")){
              results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("amount", amount).setParameter("owner2", owner2Code).getResultList();

             }else{
              results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("amount", amount).setParameter("type", type).setParameter("owner2", owner2Code).getResultList();
             }
            //13 criteria
            }else{
            //criteria not null zone null
             if(type == null || type.equals("")){
              results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("amount", amount).setParameter("criteria", criteria).setParameter("owner2", owner2Code).getResultList();

             }else{
              results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("owner2", owner2Code).getResultList();

              }else{
               results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("type", type).setParameter("owner2", owner2Code).getResultList();
              }
             }else{
             //zone not null criteria not null
              if(type == null || type.equals("")){
               results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone  AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
		   .setParameter("amount", amount).setParameter("zone", zone).setParameter("criteria", criteria).setParameter("owner2", owner2Code).getResultList();

              }else{
               results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.b8fbzpxxbvxxxxxxxxxxselprice >= :amount AND cc.y1xxuxxrbvxxxxxxxxxxsource2 = :zone AND cc.y2xxuxxrbvxxxxxxxxxxmisccode1 = :criteria AND cc.y3xxuxxrbvxxxxxxxxxxmisccode2 = :type AND cc.c6xxusxrbv16xxxxxxxxtype = 'FI-D' AND cc.b0xxziqxlvxxsaxxxxxxquantity > 0 ) order by cc.a0xxukixbxxxxxxxxxxxmatcode")
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
            if(yxxxuh566xwwqqwxxxxxuser ==null){
 		yxxxuh566xwwqqwxxxxxuser = (Yxxxuh566xwwqqwxxxxxuser) getEntityManager()
 					.createQuery(
 							"select cc from Yxxxuh566xwwqqwxxxxxuser cc where cc.a0xxuobxbxxxxxxxxxxxsid = :usersid and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 ")
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
	   yxxxch575xwwqqhxxxxxuserprofl  =  (Yxxxch575xwwqqhxxxxxuserprofl) getEntityManager()
					.createQuery(
							"select cc from Yxxxch575xwwqqhxxxxxuserprofl cc where   cc.a0xxuobxbxxxxxxxxxxxsid=:logonid  and cc.b1xxuxxrbvxxxxxxxxxxrow=:row  and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("logonid", customIdentity.getUserSid())
					.setParameter("row", "00")
                                        .setParameter("owner2", owner2Code)
					.getSingleResult();
           // get allow3 amount first
           if(yxxxch575xwwqqhxxxxxuserprofl.getE4xxzxxxlvxxxxxxxxxxfooter()!=null){
            allow3Amount=yxxxch575xwwqqhxxxxxuserprofl.getE4xxzxxxlvxxxxxxxxxxfooter();
           }

           yxxxch575xwwqqhxxxxxuserprofl.setE3xxzxxxlvxxxxxxxxxxmargin(amount);           
           yxxxch575xwwqqhxxxxxuserprofl.setD3xxuxxrbvxxxxxxxxxxdtstyle(zone);           
           yxxxch575xwwqqhxxxxxuserprofl.setD1xxuxxrbvxxxxxxxxxxmtstyle(criteria);           
           yxxxch575xwwqqhxxxxxuserprofl.setD2xxuxxrbvxxxxxxxxxxststyle(type);
           yxxxch575xwwqqhxxxxxuserproflHome.setInstance(yxxxch575xwwqqhxxxxxuserprofl);
           yxxxch575xwwqqhxxxxxuserproflHome.update();
           yxxxch575xwwqqhxxxxxuserproflHome.clearInstance();

	  } catch (NoResultException e) {
           //create record

           yxxxch575xwwqqhxxxxxuserprofl=yxxxch575xwwqqhxxxxxuserproflHome.getInstance();
           yxxxch575xwwqqhxxxxxuserprofl.setYxxxuh566xwwqqwxxxxxuser(yxxxuh566xwwqqwxxxxxuser);
           yxxxch575xwwqqhxxxxxuserprofl.setB1xxuxxrbvxxxxxxxxxxrow("00");
           yxxxch575xwwqqhxxxxxuserprofl.setE3xxzxxxlvxxxxxxxxxxmargin(amount);           
           yxxxch575xwwqqhxxxxxuserprofl.setD3xxuxxrbvxxxxxxxxxxdtstyle(zone);           
           yxxxch575xwwqqhxxxxxuserprofl.setD1xxuxxrbvxxxxxxxxxxmtstyle(criteria);           
           yxxxch575xwwqqhxxxxxuserprofl.setD2xxuxxrbvxxxxxxxxxxststyle(type);                                                                      yxxxch575xwwqqhxxxxxuserproflHome.setInstance(yxxxch575xwwqqhxxxxxuserprofl);
           yxxxch575xwwqqhxxxxxuserproflHome.persist();
           yxxxch575xwwqqhxxxxxuserproflHome.clearInstance();

          } catch (Exception e) {
			log.severe("Error accessing userprofl"+ e);
                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("user")+" "+ bundle.getString("profile")+" "+ bundle.getString("access")+" "+ bundle.getString("error")+": "+ e.getMessage(),""));
            return null;

         }
          return results;
        }



    /**
    * method is used for getting a count of all not closed and invoiced but not (paid or shipped)  orders of type cart
    * called by myDashboard
    * @return list of customer orders 
    * @param args  none
    * @exception tbd
    */ 


     public Integer getAllCartedCount(){
		List<Trexuq244xwwqqhxxxxxcuorders> results =  getEntityManager()
		 .createQuery("select cc from Trexuq244xwwqqhxxxxxcuorders cc where cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 and ((cc.zcxxzzfxhhxxxxxxxxxxstatusfl = :si or cc.zcxxzzfxhhxxxxxxxxxxstatusfl < :sp) and cc.zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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
    public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getCartedList(String type) {
       // meant for a customer ie show records for a customer 
       // carted but < paid or not toPay or not in basket for fi- but not vendor approved/rejected ie less than minvoiced (64)
      // carted and not paid  or closed after invoiced/payment
      // ownerCode needs to be reread from customIdentity or reinject list?
      // part 1 gets order for a customer if status < 16  ie  active 1 waiting confirmation and 2nd part gets otder details for that order
      //  added COP/COD  removed singleresult  added codcop check
      ownerCode=customIdentity.getOwner();
      Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders=null;
      List<Trexuq244xwwqqhxxxxxcuorders> results=null;
      //order term null/blank or POS or pp > PrePay and PickUp, pd > PrePay and Delivery, np > ToPay and PickUp, cd > ToPay and Delivery 
      // ui has pp but backend has as PrePay and PickUp   
      try{
          if (type.equals("cart")){
                //terms initially will be null after confirm to cart and will not be changed until checkout done
            String terms1="PrePay and%";
            String terms2="ToPay and%";
		results=  getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl = :ma  and (c2xxcxxxbv09xxxxxxxxterms is null or c2xxcxxxbv09xxxxxxxxterms = '' or c2xxcxxxbv09xxxxxxxxterms like :terms1 or c2xxcxxxbv09xxxxxxxxterms like :terms2 ))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("terms1", terms1).setParameter("terms2", terms2).setParameter("type", type).setParameter("ma", mactive).getResultList();
         }else{
          if (type.equals("pos")){
                type="cart";
                //customer at POS checkout after in store shopping or for preordered pickup, included shipped
		results=  getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and (((zcxxzzfxhhxxxxxxxxxxstatusfl = :sh or zcxxzzfxhhxxxxxxxxxxstatusfl < :s) and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is not  null and c2xxcxxxbv09xxxxxxxxterms != '' and c2xxcxxxbv09xxxxxxxxterms ='POS')))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("sh", mshipped).setParameter("s", mpaid).setParameter("sc", mclosed).getResultList();
          }else{
            //following not used 
            if (type.equals("basket")){
		results= getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mclosed).getResultList();
            }else{
                // basketCI
		results= getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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

          trexuq244xwwqqhxxxxxcuorders=results.get(0);//get oldest


           if (type.equals("cart") || type.equals("pos")){
            // support not show deleted (256) status
            return
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.b1xxzo11bvlxxxxxxxxxline != :s AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", trexuq244xwwqqhxxxxxcuorders.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).setParameter("s", -1).getResultList();  
           }else{
            return
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:sid  AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", trexuq244xwwqqhxxxxxcuorders.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).getResultList();  
           }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           // to add logic if not single then delete from details and then order for all except paid and latest cid and return latest
           // check how emty cart works
           //log.severe("#{messages['getCartedList']}"+ e);
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
          FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("cartedList")+" "+bundle.getString("type")+" "+type,""));

           return null;
       }
     }

	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getCartedItemTypeList(String type,String itemType) {
                // meant for a customer ie show how many digital , pick up , si-d etc 
		// carted but < paid or in basket for fi- but not vendor approved/rejected ie less than minvoiced (64)
                // carted and not paid  or closed after invoiced/payment
                // ownerCode needs to be reread from customIdentity or reinject list?
                // part 1 gets order for a customer if status < 16  ie  active 1 waiting confirmation and 2nd part gets otder details for that order
                // 
      ownerCode=customIdentity.getOwner();
      Trexuq244xwwqqhxxxxxcuorders trexuq244xwwqqhxxxxxcuorders=null;
      try{
          if (type.equals("cart")){
                //customer is purchasing shopping items
		trexuq244xwwqqhxxxxxcuorders= (Trexuq244xwwqqhxxxxxcuorders) getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).getSingleResult();
          }else{
           if (type.equals("basket")){
                //customer looking at it and will see all status ie 0 (to request) to 512 (final approved)
                // final ie manager/vendor approved 512 (to allow manager to have final say in case dispute etc or better                 // commision)
                // status 32 to 256 will be shown as pending final approval
                // once all processed status will be 8 ie mclosed
		trexuq244xwwqqhxxxxxcuorders= (Trexuq244xwwqqhxxxxxcuorders) getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mclosed).getSingleResult();
           }else{
                // basketCI
		trexuq244xwwqqhxxxxxcuorders= (Trexuq244xwwqqhxxxxxcuorders) getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mclosed).getSingleResult();
           }
          }
           if (type.equals("cart")){
            // support not show deleted (256) status
            return
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:itemType and cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.b1xxzo11bvlxxxxxxxxxline != :s AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", trexuq244xwwqqhxxxxxcuorders.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).setParameter("itemType", itemType).setParameter("s", -1).getResultList();  
           }else{
            return
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:sid  AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", trexuq244xwwqqhxxxxxcuorders.getA0xxuobxbxxxxxxxxxxxsid()).setParameter("owner2", owner2Code).getResultList();  
           }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           // to add logic if not single then delete from details and then order for all except paid and latest cid and return latest
           // check how emty cart works
           //log.severe("#{messages['getCartedList']}"+ e);
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
      public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getCartedPayLaterList(String type) {
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
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:sid and cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner AND  cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl < :s and cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms like 'ToPay and%' ) OR cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) AND cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("mtype", "SI-C").setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("sid", cosid).getResultList();  


       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           // to add logic if not single then delete from details and then order for all except paid and latest cid and return latest
           // check how emty cart works
           log.severe("#{messages['getCartedList']}"+ e);
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
                 for (Xoxxuq2b4xwwqqhxxxxxcuodetails itemOrderDetail:getCartedPayLaterList("cart") ){
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
                 for (Xoxxuq2b4xwwqqhxxxxxcuodetails itemOrderDetail:getCartedPayLaterList(type) ){
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
                 for (Xoxxuq2b4xwwqqhxxxxxcuodetails itemOrderDetail:getCartedList(type) ){
                  fpxxfq1a5xwwqqhxxxxxitem=itemOrderDetail.getFpxxfq1a5xwwqqhxxxxxitem();
                  payLater=yxxxuq591xwwqqhxxxxxrate1fList.getCODCharge(fpxxfq1a5xwwqqhxxxxxitem);
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
                 for (Xoxxuq2b4xwwqqhxxxxxcuodetails itemOrderDetail:getCartedPayLaterList("cart") ){
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



	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getApprovedRejectedCartedList(String type) {
                // not used
		// those in basket and approved ie 32 or rejected ie 04 or paid and pending ie 16
                // owner checking will mean only user ie customer who created will see it
                // see VendorApproved..... for vendor use
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s OR trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s2 OR trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s3)  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mpaid).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           //log.severe("#{messages['ApprovedRejectedCartedList']}"+ e);
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

 public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getBasketedList(String type) {
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
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("owner", ownerCode).setParameter("s3", mclosed).getResultList();  
          }else{
           //basketCI
           if (type.equals("basketCI")){
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner  and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("owner", ownerCode).setParameter("s3", mclosed).getResultList();  
           }else{
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
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

	public List<Fpxxfq1a5xwwqqhxxxxxitem> getItemDetailsBasketedList() {
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
      category=getBasketedList("basketCI").get(0).getFpxxfq1a5xwwqqhxxxxxitem().getA0xxuobxbxxxxxxxxxxxsid();
      try{
        // show details only not sub category item
	List<Fpxxfq1a5xwwqqhxxxxxitem> results = getEntityManager()
		 .createQuery(
		  "select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  AND  cc.c6xxusxrbv16xxxxxxxxtype = :type AND cc.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid = :category  ) order by cc.a0xxukixbxxxxxxxxxxxmatcode asc")
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


 public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getCustomerRequestedAndUpCartedList(String type) {
                // viewed by Manager called by basketin for fi- items
		// those in basket put and confirmed by customer 16 mpaid or later approved/rejected by manager or by vendor
                // and detail not closed
                // no owner checking since multiple customers are involved
                // jay add agent concept ie customer should select a manager
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl <= :s2 and cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mpaid).setParameter("s2", mprinted).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));
           return null;
       }
 }
 public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getCustomerRequestedAndUpCartedListCI(String type) {
                // viewed by Employee Analyst called by ebasketin for ci- items
		// those in basket and its order put and confirmed(mpaid) by customer >= 16  or later approved/rejected by manager !=512(mprinted)
                // no owner checking since multiple customers are involved
                // jay add agent concept ie customer should select a manager
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl <= :s2 and cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mopen).setParameter("s2", mprinted).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
 }
	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getManagerApprovedRejectedCartedList(String type) {
                //viewed by vendor and called by vbasketin for fi- items
		// those orders in basket and manager approved ie 32 (mshipped) or vendor statused , no use showing manager rejected(4) or closed(8)
                // 512 will not have approve/reject button
                // jay no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl != :s2 AND cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getEmployeeApprovedRejectedCartedListCI(String type) {
                //viewed by manager and called by mbasketin for ci- items
		// those in basket and employee approved ie 32 or vendor? statused , no use showing manager rejected or closed
                // 512 will not have approve/reject button
                // jay no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl != :s2 AND cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno desc")
		   .setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getManagerApprovedRejectedCartList(String type) {
                //not used this is cartedList viewed by vendor for fi-items
		// baskets and manager approved ie 32 or vendor statused , no use showing manager rejected or closed
                // 512 will not have approve/reject button
                // jay no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC                 // offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s AND cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl != :s2 AND cc.zhxxzzfxhhxxxxxxxxxxstatusfl != :s3 )  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mclosed).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}

	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getManagerVendorApprovedRejectedCartedList(String type) {
                // used since checking for status 512 does the same thing, viewed by vendor for fi-items
		// those in basket and approved ie 32 or rejected 04
                // no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s OR trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s2 OR cc.zhxxzzfxhhxxxxxxxxxxstatusfl = :s3)  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").setParameter("s", mshipped).setParameter("s2", mreturn).setParameter("s3", mpaid).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+type+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
	}



	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getVendorApprovedRejectedCartedList(String type) {
		// those in basket and approved ie 32 or rejected 04
                // no owner checking but soon replace with item created by vendor checking so that BMO cannot see RBC offerings
      try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2  and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s OR trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s2 OR cc.zhxxzzfxhhxxxxxxxxxxstatusfl = :s3)  ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
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

    public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getConfirmedCartedList(String type) {
      try{
          if (type.equals("pos")){
           type="cart";
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms ='POS' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc)) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
         	   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", minvoiced).setParameter("sc", mclosed).getResultList();  
          }else{
           if (type.equals("cart")){
            String terms1="PrePay and%";
            String terms2="ToPay and%";
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND (cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms like :terms1 or cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms like :terms2)  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc or cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl > :ma )) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("ma", mactive).setParameter("s", minvoiced).setParameter("sc", mclosed).setParameter("terms1", terms1).setParameter("terms2", terms2).getResultList();  
           }else{
            //basketCI
            type=type.substring(0,type.length()-2);
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mpaid).getResultList();  
            }
          }
      } catch ( NoResultException ignore){
           return null;
      } catch ( Exception e){
           //log.severe("#{messages['getConfirmedCartedList']}", e);
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
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms ='POS' AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc)) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
         	   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).getResultList();  
          }else{
           if (type.equals("cart")){
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND (cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms is  null or cc.trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms = '')  AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and (cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s or cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :sc)) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).setParameter("sc", mclosed).getResultList();  
           }else{
            //basketCI
            type=type.substring(0,type.length()-2);
            return 
             getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mpaid).getResultList();  
            }
          }
      } catch ( NoResultException ignore){
           return null;
      } catch ( Exception e){
           //log.severe("#{messages['getConfirmedCartedList']}", e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("type")+" "+type+" "+bundle.getString("paid")+" "+bundle.getString("list")+" "+bundle.getString("expected"),""));

           return null;
       }
   }


    public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getConfirmedBasketedList(String type) {
		//  can be many cases/pffers and paid/summitted (16) only
      try{
          if (type.equals("basket")){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("s", mpaid).getResultList();  
          }else{
            //basketCI
            type=type.substring(0,type.length()-2);
            return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner=:owner and cc.trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl >= :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "basket").setParameter("mtype", "CI-D").setParameter("s", mpaid).getResultList();  
          }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           //log.severe("#{messages['getConfirmedCartedList']}", e);
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
           //log.severe("#{messages['getConfirmedCartedList']}", e);
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
           //log.severe("#{messages['getConfirmedCartedList']}", e);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("invoice")+" "+type+" "+bundle.getString("records")+" "+bundle.getString("expected"),""));

           return null;
       }
   }




   public List<Xoxxuq295xwwqqhxxxxxshipmentdetails> getShippedCartedList(Integer sid) {
		// shipped items for a po ignore sid for now because we show history
      try{
         if(sid !=0){
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq295xwwqqhxxxxxshipmentdetails cc where (cc.z5xxuxxrbvxxxxxxxxxxcpono=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zrxxutoxlhxxxxxxxxxxowner=:owner and cc.zmxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("sid", sid).setParameter("s", mshipped).getResultList();  
         }else{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq295xwwqqhxxxxxshipmentdetails cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zrxxutoxlhxxxxxxxxxxowner=:owner and cc.zmxxzzfxhhxxxxxxxxxxstatusfl = :s ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("s", mshipped).getResultList();  
         }
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
           log.severe("#{messages['getShippedCartedList']}"+ e);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
            FacesMessage.SEVERITY_ERROR,bundle.getString("application")+" "+bundle.getString("error")+" "+e.getMessage()+", "+bundle.getString("single")+" "+"shipped"+" "+bundle.getString("record")+" "+bundle.getString("expected"),""));

           return null;
       }
   }



	public List<Xoxxuq2c4xwwqqhxxxxxcuqdetails> cuqdetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2c4xwwqqhxxxxxcuqdetails cc where (cc.trexuq233xwwqqhxxxxxcuquote.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

      // switch to entityDetailedList ????? ex trexuq244xwwqqhxxxxxcuordersList.entityDetailedList(trexuq244xwwqqhxxxxxcuordersHome.instance.a0xxuobxbxxxxxxxxxxxsid
	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> detailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<Xoxxuq2a4xwwqqhxxxxxcuidetails> cuidetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2a4xwwqqhxxxxxcuidetails cc where (cc.trexuq266xwwqqhxxxxxcuinvoice.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<Xoxxuq3e4xwwqqhxxxxxvendqdetails> vendqdetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq3e4xwwqqhxxxxxvendqdetails cc where (cc.trexuq333xwwqqhxxxxxvenquote.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<Xoxxuq3d4xwwqqhxxxxxvendodetails> vendodetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq3d4xwwqqhxxxxxvendodetails cc where (cc.trexuq344xwwqqhxxxxxvendorders.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("sid", sid).setParameter("owner2", owner2Code).getResultList();  
       } catch ( NoResultException ignore){
           return null;
       } catch ( Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_ERROR,"DetailedList error "+e.getMessage(), ""));

           return null;
       }
     }

	public List<Xoxxuq3c4xwwqqhxxxxxvendidetails> vendidetailedList(Integer sid) {
       try{
           return 
            getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq3c4xwwqqhxxxxxvendidetails cc where (cc.trexuq3a6xwwqqhxxxxxvinvoice.a0xxuobxbxxxxxxxxxxxsid=:sid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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

	public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentCartOrder(String type) {
                if(type.equals("cart") ){
                 //order terms null or blank if created but no checkout yet. If checkout then will have value , sort order desc
                 String terms1="PrePay and%";
                 String terms2="ToPay and%";
  		 return getEntityManager()
 		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl = :ma and (c2xxcxxxbv09xxxxxxxxterms is  null or c2xxcxxxbv09xxxxxxxxterms = '' or c2xxcxxxbv09xxxxxxxxterms like :terms1 or c2xxcxxxbv09xxxxxxxxterms like :terms2) )  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		   .setParameter("owner", ownerCode).setParameter("ma", mactive).setParameter("owner2", owner2Code).setParameter("terms1", terms1).setParameter("terms2", terms2).setParameter("type", type).getResultList();
                }else{
                 if(type.equals("pos")){
                  type="cart";
  		  return getEntityManager()
 		  .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl = :sh or zcxxzzfxhhxxxxxxxxxxstatusfl < :s) and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is not null and c2xxcxxxbv09xxxxxxxxterms ='POS')  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("sh", mshipped).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                 }else{
                  if(type.equals("basket")){
  		   return getEntityManager()
 		    .createQuery(
		     "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is  null or c2xxcxxxbv09xxxxxxxxterms = '') or (c2xxcxxxbv09xxxxxxxxterms not like 'Paid/%' or c2xxcxxxbv09xxxxxxxxterms not like 'ToPay and%'))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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

	public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentConfirmedCartOrder(String type) {
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
		   "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl > :ma and (c2xxcxxxbv09xxxxxxxxterms like :terms1 or c2xxcxxxbv09xxxxxxxxterms like :terms2 )  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid desc")
		    .setParameter("owner", ownerCode).setParameter("ma", mactive).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("terms1", terms1).setParameter("terms2",terms2).getResultList();
                 }
                }else{
                 if(type.equals("pos")){
                  type="cart";
  		  return getEntityManager()
 		  .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl = :sh or zcxxzzfxhhxxxxxxxxxxstatusfl < :s) and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is not null and c2xxcxxxbv09xxxxxxxxterms ='POS')  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("sh", mshipped).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
                 }else{
                  if(type.equals("basket")){
  		   return getEntityManager()
 		    .createQuery(
		     "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc and (c2xxcxxxbv09xxxxxxxxterms is  null or c2xxcxxxbv09xxxxxxxxterms = '') or (c2xxcxxxbv09xxxxxxxxterms not like 'Paid/%' or c2xxcxxxbv09xxxxxxxxterms not like 'ToPay and%'))  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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

        public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentCartOrders(String type) {
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("sc", mclosed).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl >= :s )  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
          }
        }

	public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentCartOrdersV(String type) {
		// no owners checked used by Vendor if type basket and for say attachments
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mshipped).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "FI-D").getResultList();
          }
	}

	public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentCartOrdersE(String type) {
		// no owners checked used by Employee if type basket and for say attachments
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mclosed).setParameter("owner2", owner2Code).setParameter("type", type).setParameter("mtype", "CI-D").getResultList();
          }
	}

	public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentCartOrdersC(String type) {
		// owner checked used by Customer if type basket and for say attachments
          if (type.equals("cart")){
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("owner", ownerCode).setParameter("type", type).getResultList();
          }else{
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner  and zcxxzzfxhhxxxxxxxxxxstatusfl != :s  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype=:mtype) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("s", mclosed).setParameter("owner2", owner2Code).setParameter("owner", ownerCode).setParameter("type", type).setParameter("mtype", "CI-D").getResultList();
          }
	}


	public List<Trexuq244xwwqqhxxxxxcuorders> getCurrentToPayCartOrder() {
		// include item type SI-D(regular ie shipment/pickup) or  SI-P(pay but pickup only) and exclude SI-C (COD ie pay on delivery)
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND  cc.zexxutoxlhxxxxxxxxxxowner=:owner and (zcxxzzfxhhxxxxxxxxxxstatusfl < :s and zcxxzzfxhhxxxxxxxxxxstatusfl <> :sc)  AND cc.y9xxcxxxbv10xxxxxxxxtype=:type AND cc.fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype !=:itype    ) order by cc.a0xxuobxbxxxxxxxxxxxsid").setParameter("owner", ownerCode).setParameter("s", mpaid).setParameter("sc", mclosed).setParameter("owner2", owner2Code).setParameter("type", "cart").setParameter("itype", "SI-C").getResultList();
	}




	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getCurrentCartOrderDetails(String type) {
		//  added type
                if(getCurrentCartOrder(type) ==null || getCurrentCartOrder(type).size()==0){
                 return null;
                }
                Integer osid=getCurrentCartOrder(type).get(0).getA0xxuobxbxxxxxxxxxxxsid();
		return getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:osid) order by cc.a0xxuobxbxxxxxxxxxxxsid")
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
                for (Xoxxuq2b4xwwqqhxxxxxcuodetails entry: getCurrentCartOrderDetails(type)){
                 if(entry.getB1xxzo11bvlxxxxxxxxxline() <1){
                  continue;
                 }
                 regularAmount=entry.getZ3xxeqxxbvnxxxxxxxxxqtyordrd().multiply(entry.getFpxxfq1a5xwwqqhxxxxxitem().getB8fbzpxxbvxxxxxxxxxxselprice());
                 discountedAmount=entry.getZbxxzbxxavxxxxxxxxxxbaseamount();
                 saving=saving.add(regularAmount.subtract(discountedAmount));
                }
                return saving;
	}


	public List<Trexuq244xwwqqhxxxxxcuorders> getCompletedCartOrder() {
		// jay remove hard coding
		return getEntityManager()
		 .createQuery(
		  "select cc from Trexuq244xwwqqhxxxxxcuorders cc where (cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 AND cc.zexxutoxlhxxxxxxxxxxowner=:owner AND cc.y9xxcxxxbv10xxxxxxxxtype=:type) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner", ownerCode).setParameter("owner2", owner2Code).setParameter("type", "cartC").getResultList();
	}

	public List<Xoxxuq2b4xwwqqhxxxxxcuodetails> getcompletedCartOrderDetails() {
		// jay remove hard coding
                Integer osid=getCompletedCartOrder().get(0).getA0xxuobxbxxxxxxxxxxxsid();
		return getEntityManager()
		 .createQuery(
		  "select cc from Xoxxuq2b4xwwqqhxxxxxcuodetails cc where (cc.trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid=:osid AND cc.zzxxu2oxxhxxxxxxxxxxowner2=:owner2 ) order by cc.a0xxuobxbxxxxxxxxxxxsid")
		   .setParameter("owner2", owner2Code).setParameter("osid", osid).getResultList();
	}




      // if from another site, restrict to raaspi site 

     public Fpxxfq1a5xwwqqhxxxxxitem getSidToEntity(Integer sid,String owner2){
      Fpxxfq1a5xwwqqhxxxxxitem entity=null;
      List<Fpxxfq1a5xwwqqhxxxxxitem> results=null;
      try{
       results = getEntityManager()
					.createQuery(
							"select cc from Fpxxfq1a5xwwqqhxxxxxitem cc where cc.a0xxuobxbxxxxxxxxxxxsid = :nSid and cc.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
					.setParameter("nSid",sid)
					.setParameter("owner2", owner2)
					.getResultList();
      }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_ERROR,bundle.getString("item")+" "+bundle.getString("error")+" "+e.getMessage(), ""));
       return null;
      }
      if(results.isEmpty()){
          return null;
      }
      if(results.size() >1){
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_INFO,bundle.getString("item")+" "+bundle.getString("multiple")+" "+bundle.getString("entries"),""));
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
           FacesMessage.SEVERITY_ERROR,bundle.getString("first")+" "+bundle.getString("one")+" "+bundle.getString("used")+", "+bundle.getString("delete")+" "+bundle.getString("duplicates"), ""));
      }
      return results.get(0);

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
            //the itemstock report called form item report but uses serialnumbers table not item table
            if(reportName.contains("serialnumbers")){
             fxxxuq1ffxwwqqhefxxxserialnumbersList.print();
             return;
            }
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
		            parameters.put("show002h", "#{messages[Matcode]}");
		            parameters.put("show003h", "#{messages[Quantity]}");
		            parameters.put("show004h", "#{messages[Descript]}");
		            parameters.put("show005h", "#{messages[Source1]}");
		            parameters.put("show006h", "#{messages[Upccode]}");
		            parameters.put("show007h", "#{messages[Cost]}");
		            parameters.put("show008h", "#{messages[Replcost]}");
		            parameters.put("show009h", "#{messages[Selprice]}");
		            parameters.put("show010h", "#{messages[Spricold]}");
		            parameters.put("show011h", "#{messages[Spricnew]}");
		            parameters.put("show012h", "#{messages[Spriceffdt]}");
		            parameters.put("show013h", "#{messages[Shipcode]}");
		            parameters.put("show014h", "#{messages[Qtylevel1]}");
		            parameters.put("show015h", "#{messages[Unit]}");
		            parameters.put("show016h", "#{messages[Type]}");
		            parameters.put("show017h", "#{messages[Tax1]}");
		            parameters.put("show018h", "#{messages[Tax2]}");
		            parameters.put("show019h", "#{messages[Aliascode]}");
		            parameters.put("show020h", "#{messages[Avgprice]}");
		            parameters.put("show021h", "#{messages[parentcode]}");
		            parameters.put("show022h", "#{messages[location]}");
		            parameters.put("show023h", "#{messages[Subcodesn]}");
		            parameters.put("show024h", "#{messages[Subcodesn2]}");
		            parameters.put("show025h", "#{messages[Subcodesn3]}");
		            parameters.put("show026h", "#{messages[Effdate]}");
		            parameters.put("show027h", "#{messages[Integrset]}");
		            parameters.put("show028h", "#{messages[Notes]}");
		            parameters.put("show029h", "#{messages[Docmnt]}");
		            parameters.put("show030h", "#{messages[Source2]}");
		            parameters.put("show031h", "#{messages[Misccode1]}");
		            parameters.put("show032h", "#{messages[Misccode2]}");
		            parameters.put("show033h", "#{messages[Caseqty]}");
		            parameters.put("show034h", "#{messages[Datetorenew]}");
		            parameters.put("show035h", "#{messages[Tax3]}");
		            parameters.put("show036h", "#{messages[Dateadded]}");
		            parameters.put("show037h", "#{messages[Dateexpiry]}");
		            parameters.put("show038h", "#{messages[Printmstat]}");
		            parameters.put("show039h", "#{messages[Prinmtfldt]}");
		            parameters.put("show040h", "#{messages[Avgcost]}");
		            parameters.put("show041h", "#{messages[Statusfl]}");
		            parameters.put("show042h", "#{messages[Statusfldt]}");
		            parameters.put("show043h", "#{messages[Cuordqty]}");
		            parameters.put("show044h", "#{messages[Venorqty]}");
		            parameters.put("show045h", "#{messages[Cupicqty]}");
		            parameters.put("show046h", "#{messages[Venpiqty]}");
		            parameters.put("show047h", "#{messages[Cuinvqty]}");
		            parameters.put("show048h", "#{messages[Cushiqty]}");
		            parameters.put("show049h", "#{messages[Venshqty]}");
		            parameters.put("show050h", "#{messages[Owner]}");
		            parameters.put("show051h", "#{messages[Barupc]}");
		            parameters.put("show052h", "#{messages[Owner2]}");
                 // done with labels, now load corresponding values from truefalses db or if new create 
                 loadTruefalses(); //sets bcontinue
                 // if found bcontinue is true and  report parameters shownnn are already set from db
                 // if not found then create db entry and then load default values for report prefix type
                 // and then persist truefalse
                 // and call loadTruefalses() again 
                 if (!bcontinue){//not found
                    yxxxch5a1xhhxxhxxxxxtruefalseHome.clearInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse=yxxxch5a1xhhxxhxxxxxtruefalseHome.getInstance();
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA0xxukrdbvxxxxxxxxxxtablename("item");
                    yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxuxxxbvxxxxxxxxxxqualifier(reportNamePrefix);
                  //default
                 if(reportNamePrefix.equals("de")){ 
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
                   //yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false);//hide sid 
                 }
                 //demographic
                 if (reportNamePrefix.equals("dg")){
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
                  // yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false); table never had sid
                  // by default showxxx are true but .ftl gen time for "me" it will put false if not type decimal
                  // but at report side it will always include some key values
                 }
                 if (reportNamePrefix.equals("me")){
                 // show001 etc refers to decimal items not the original seq, start false from show003
                 //show002 is qty
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow001(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow003(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow004(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow005(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow011(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow012(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow014(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow015(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow016(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow017(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow018(false);
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
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow033(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow034(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow035(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow036(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow037(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow038(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow040(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow041(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow049(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow050(false);
                        yxxxch5a1xhhxxhxxxxxtruefalse.setA1xxyxxxbvxxxxxxxxxxshow051(false);
                 }
                 //any other prefix like adhock etc
                 if (reportNamePrefix.equals("a1") || reportNamePrefix.equals("a2")){
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
                  FacesMessage.SEVERITY_WARN,bundle.getString("item")+" "+bundle.getString("report")+" "+bundle.getString("generate")+" "+bundle.getString("failed")+" "+e.getMessage(),""));
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
                      .setParameter("tableName", "item")
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
* header("X-SMTPAPI",headers) for m:header name="X-SMTPAPI" value="#{fpxxfq1a5xwwqqhxxxxxitemList.headers}" 
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
         String useTemplate="itemMailingContent.fmt";
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
          useTemplate="itemeMailingContent.fmt";
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
                            new InputStreamAttachment("item.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("item.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("item.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
                            new InputStreamAttachment("item.pdf", "application/pdf", ContentDisposition.ATTACHMENT,new ByteArrayInputStream(this.getMailingBytes()))).send();
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
          //reportName="xxFpxxfq1a5xwwqqhxxxxxitem";  holds selected report
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
         //renderer.render("/itemeMailingContent.xhtml");
         emailRender("/itemeMailingContent.xhtml","e");
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
   public List<Fpxxfq1a5xwwqqhxxxxxitem> getResultList(){
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
