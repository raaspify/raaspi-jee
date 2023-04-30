package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;
//import org.jboss.seam.security.Identity;
import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
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
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import java.math.BigInteger;
import javax.faces.view.ViewScoped;
import javax.enterprise.context.RequestScoped;
//import static org.jboss.seam.international.StatusMessage.Severity.ERROR;
//import javax.faces.application.FacesMessage.Severity;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.mail.MessagingException;

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
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import javax.annotation.PostConstruct;

/**
 * Component used to do additional administer databased data like -C daily backup
 * sqlSupport.backupTenants using _c by taskAgent,sqlSupport.backupTenantC by tenant,sqlSupport.restoreTenantC are used
 *  added emailreminder function here, because requestScope cannot call ViewScope beans like xxxHome
 * @author j mitra
 */
@Named("sqlSupport")
//@ViewScoped
@RequestScoped
@Transactional
public class SqlSupport implements Serializable {
    @Inject CustomIdentity customIdentity;

  //@Resource UserTransaction utx;
   private Logger log = Logger.getLogger(SqlSupport.class.getCanonicalName());
	//@Inject  inject wont work in requestScoped, use query like for client in emailRender
	//Jxxxbh400xwwqqhxxxxxemployeeHome jxxxbh400xwwqqhxxxxxemployeeHome;
        //private Jxxxbh400xwwqqhxxxxxemployee jxxxbh400xwwqqhxxxxxemployee;
      @PersistenceContext(unitName = "genappcdi")
      EntityManager entityManager;
       private String owner2Code="";
       private Calendar calendar = Calendar.getInstance();
      private Calendar calendare = Calendar.getInstance();

       private SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-ddHmm");
       String urlName;

       private int urlIndex=0;
       ResourceBundle bundle =null;
       private boolean bcontinue = true;
       boolean mailRelayOff=true;
       String descript="";
       String dateTimes="";
       Fxxxuq89bxwwqqhxxxxxschedule fxxxuq89bxwwqqhxxxxxschedule=null;
       ServletContext context=null;
       String schemaName;
       private Boolean tomeeYN = false;// to allow myfaces vs mojarra jsf or jndi naming
       private DataSource ds;
       FacesContext facesContext=null;
    //
    @PostConstruct
    public void initialize() {
     try{
      facesContext = FacesContext.getCurrentInstance(); 
      if (facesContext !=null){
       bundle = facesContext.getApplication().getResourceBundle(facesContext, "messages");
       ExternalContext externalContext = facesContext.getExternalContext();
       context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
       HttpServletRequest req = (HttpServletRequest) externalContext.getRequest();
       HttpSession session = req.getSession();
       urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();

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
      }
     } catch (Exception e) {
        log.severe("Error at customIdentity initialize() "+ e.getMessage());
     }
    }      
	public byte[] getBlobdata(String table,String keyWPrefix,String keyQualifier,int keySequence,String owner2Code) {
         this.owner2Code=owner2Code;
         return this.getBlobdata(table,keyWPrefix,keyQualifier,keySequence);
        }
    /**
    * The following method gets blobdata from both user and SYSTEM for a specific key
    * @param args String table,keyWPrefix,String keyQualifier,int keySequence
    * @return byte[] image stream
    * @exception No Record Exists
    * @see
    *
    */

	public byte[] getBlobdata(String table,String keyWPrefix,String keyQualifier,int keySequence) {
           String actualTable=table;
           String slobkeyhash;
           if(keyWPrefix.length() > 0){
	     slobkeyhash = keyWPrefix.substring(1);
           }else{
            return null;
           }
		String qualifier = keyQualifier;
		int sequence = keySequence;

		try {
               Yxxxuq1n1xwwqqqxxxxxblobdata blobdata=null;
		    List<Yxxxuq1n1xwwqqqxxxxxblobdata> results = entityManager
					.createQuery(
							"select cc from Yxxxuq1n1xwwqqqxxxxxblobdata cc where cc.a0xxukbdlvxxxxxxxxxxfromtable=:blobdatafromtable and cc.a1xxuxxxbv49xxxxxxxxfromkey=:blobdatafromkey and cc.a2xxuxxxbv50xxxxxxxxqualifier=:blobdataqualifier and a3xxexnsbvxxxxxxxxxxsequence = :blobdatasequence and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2  ")
					           .setParameter("blobdatafromtable", actualTable).setParameter(
							"blobdatafromkey", slobkeyhash).setParameter(
							"blobdataqualifier", qualifier).setParameter(
							"blobdatasequence", sequence).setParameter("owner2", owner2Code).getResultList();
                if(!results.isEmpty()){
                 if ( !results.get(0).getZzxxu2oxxhxxxxxxxxxxowner2().equals("SYSTEM")) {
                  return results.get(0).getB1xxuzbxbvxxxxxxxxxxdata();
                 }else{
                  if (results.size() > 1){
                   return results.get(1).getB1xxuzbxbvxxxxxxxxxxdata();
                  }else{
                   return results.get(0).getB1xxuzbxbvxxxxxxxxxxdata();
                  }
                 }
                }else{
                 // use bkgr color richSkin.headerGradientColor if no image supplied , which is default
                  return null;
                }
        } catch (NoResultException e) {
               return null;
        }
	}



	public String  backupTenants() {
      // only this method is used now for system backup using _c tables
      // C:\schemaspygui\postgres_postgre_ has tables relation and dependency info like deletionOrder.txt
      // add a lock ??
      // to file not used since in cloud pl/sql does not seem to have access to files
      // this backUp is on demand and done by tenant
      // there is daily backup to tables for all tenants while app is up and also a separate sbnapshot daily backup when app is stopped
      // snapshot is on file and meant for disaster situation
      //
      // 1-remove rows from backup if not in main ie any old (ie not used) rows in backup will be removed
      // 2-insert into backup if new rows in main
      // 3-update backup if row in main has different change time  (relies on statusfldate change)
      // follow the deletion order list produced by schemaspygui C:\schemaspygui\postgres_postgre_\deletionOrder.txt ( future use the list as input to automate )
      // insertionOrder.txt for insert, for update order does not matter because we are not dropping or adding any relation but will follow
      // insertionOrder.txt
      // resource_bundle,resource,clob and blob have SYSTEM records which need extra logic
      // SYSTEM records should not be deleted from main or backup table but should be copied into backup if needed ??? revisit
      // SELECT * FROM information_schema.columns WHERE table_schema = 'genapp'  AND table_name   = 'client'
      //use DatabaseMetaData, as in authenticator.java, to avoid harcoding here
      //using jdbc connection to get database metadata rather than entitymanager way to be ORM neutral
      DatabaseMetaData databaseMetaData=null;
      String productName="";
      String dbProductName="hsql";
      if(schemaName == null || schemaName.isEmpty()){
       schemaName="genapp";
      }
      //try with resource ensures resouce gets closed, better than using finally to close
      try(Connection conn = getConnection();){
       databaseMetaData = conn.getMetaData();
       productName = databaseMetaData.getDatabaseProductName();
      } catch (Exception e) {
       log.severe("No datasouce connection or databaseMetaData, Cannot continue");
       return null;
      }
      if(productName==null || productName.isEmpty()){
       log.severe("No datasouce setup yet, check tomee.xml or standalone.xml etc. Cannot continue");
       return null;
      }
      if(productName.contains("PostgreSQL")){
       dbProductName="psql";
      }

     String sqlScript ="";
     String masterSiteCode="";
     String shicsize="";
try{
     int deletedCount=0;
     int updatedCount=0;
     int insertedCount=0;
     int countp=0;
     Query q=null;
     // check automated backup off or not. Need to find the master site(if client record 01 has looseit true)
     // and if shicsize value is "off" which is initial value
     try{
      sqlScript="select c.owner2, c.shicsize from "+schemaName+".client c where c.looseit=true and c.clientversion=:clientversion";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("clientversion", "01");
      Object[] result = (Object[])q.getSingleResult();
      if(result !=null){
       shicsize = (String)result[1];
       masterSiteCode=(String)result[0];
      }else{
       int len=sqlScript.length();
       len=len>120?120:len;
       log.info("system backup error, while checking for master site  "+ sqlScript.substring(0,len));
       return null;
      }
     } catch (Exception e) {
      int len=sqlScript.length();
      len=len>120?120:len;
      log.info("system backup error in finding master site  "+ sqlScript.substring(0,len)+"," + e.getMessage());
      return null;
     }
     sqlScript="delete from "+schemaName+".serialnumbers_c b where   not exists  (select sid from "+schemaName+".serialnumbers a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);
     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".scandate_c b where   not exists  (select a.sid from "+schemaName+".scandate a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".rate1f_c b where   not exists  (select a.sid from "+schemaName+".rate1f a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".options_c b where   not exists  (select a.sid from "+schemaName+".options a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".nextserialno_c b where   not exists  (select a.sid from "+schemaName+".nextserialno a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".journal_c b where   not exists  (select a.sid from "+schemaName+".journal a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".jjournal_c b where   not exists  (select a.sid from "+schemaName+".jjournal a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".hlogfile_c b where   not exists  (select a.sid from "+schemaName+".hlogfile a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".genoptions_c b where   not exists  (select a.sid from "+schemaName+".genoptions a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".editlog_c b where   not exists  (select a.sid from "+schemaName+".editlog a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".clobdata_c b where   not exists  (select a.sid from "+schemaName+".clobdata a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cjournal_c b where   not exists  (select a.sid from "+schemaName+".cjournal a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".blobdata_c b where   not exists  (select a.sid from "+schemaName+".blobdata a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".arthatbl_c b where   not exists  (select a.sid from "+schemaName+".arthatbl a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".arthahist_c b where   not exists  (select a.sid from "+schemaName+".arthahist a where  a.sid = b.sid)";
     q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".acperiod_c b where   not exists  (select a.sid from "+schemaName+".acperiod a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".jobassignment_c b where   not exists  (select a.sid from "+schemaName+".jobassignment a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".schedule_c b where   not exists  (select a.sid from "+schemaName+".schedule a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vshipmendetails_c b where   not exists  (select a.sid from "+schemaName+".vshipmendetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vcontact_c b where   not exists  (select a.sid from "+schemaName+".vcontact a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".shipmentdetails_c b where   not exists  (select a.sid from "+schemaName+".shipmentdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".ccontact_c b where   not exists  (select a.sid from "+schemaName+".ccontact a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendqdetails_c b where   not exists  (select a.sid from "+schemaName+".vendqdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendpdetails_c b where   not exists  (select a.sid from "+schemaName+".vendpdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendodetails_c b where   not exists  (select a.sid from "+schemaName+".vendodetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendidetails_c b where   not exists  (select a.sid from "+schemaName+".vendidetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".resourcedetails_c b where   not exists  (select a.sid from "+schemaName+".resourcedetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".processdetails_c b where   not exists  (select a.sid from "+schemaName+".processdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".emplodetails_c b where   not exists  (select a.sid from "+schemaName+".emplodetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuqdetails_c b where   not exists  (select a.sid from "+schemaName+".cuqdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuodetails_c b where   not exists  (select a.sid from "+schemaName+".cuodetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuidetails_c b where   not exists  (select a.sid from "+schemaName+".cuidetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".usagebyperiods_c b where   not exists  (select a.sid from "+schemaName+".usagebyperiods a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgenfields_c b where   not exists  (select a.sid from "+schemaName+".rgenfields a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".itembomdetails_c b where   not exists  (select a.sid from "+schemaName+".itembomdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".holiday_c b where   not exists  (select a.sid from "+schemaName+".holiday a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".gentriesdetails_c b where   not exists  (select a.sid from "+schemaName+".gentriesdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cupdetails_c b where   not exists  (select a.sid from "+schemaName+".cupdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activityjobdetails_c b where   not exists  (select a.sid from "+schemaName+".activityjobdetails a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".wageearneraux_c b where   not exists  (select a.sid from "+schemaName+".wageearneraux a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".venartha_c b where   not exists  (select a.sid from "+schemaName+".venartha a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".userprofl_c b where   not exists  (select a.sid from "+schemaName+".userprofl a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".resource_c b where   not exists  (select a.sid from "+schemaName+".resource a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".processattributes_c b where   not exists  (select a.sid from "+schemaName+".processattributes a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".controlusagebyperiods_c b where   not exists  (select a.sid from "+schemaName+".controlusagebyperiods a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".acintegr_c b where   not exists  (select a.sid from "+schemaName+".acintegr a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".\"USER_c\" b where   not exists  (select a.sid from "+schemaName+".\"USER\" a where  a.sid = b.sid)";
     if(dbProductName.equals("psql")){
      sqlScript="delete from "+schemaName+".\"user_c\" b where   not exists  (select a.sid from "+schemaName+".\"user\" a where  a.sid = b.sid)";
     }

      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".emplorders_c b where   not exists  (select a.sid from "+schemaName+".emplorders a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vpayment_c b where   not exists  (select a.sid from "+schemaName+".vpayment a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".task_c b where   not exists  (select a.sid from "+schemaName+".task a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cpayment_c b where   not exists  (select a.sid from "+schemaName+".cpayment a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".glentries_c b where   not exists  (select a.sid from "+schemaName+".glentries a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".controlusagebyperiods_c b where   not exists  (select a.sid from "+schemaName+".controlusagebyperiods a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activityjob_c b where   not exists  (select a.sid from "+schemaName+".activityjob a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".wageearner_c b where   not exists  (select a.sid from "+schemaName+".wageearner a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgentable_c b where   not exists  (select a.sid from "+schemaName+".rgentable a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".itemjob_c b where   not exists  (select a.sid from "+schemaName+".itemjob a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vshipmen_c b where   not exists  (select a.sid from "+schemaName+".vshipmen a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".groupmembers_c b where   not exists  (select a.sid from "+schemaName+".groupmembers a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vinvoice_c b where   not exists  (select a.sid from "+schemaName+".vinvoice a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".shipment_c b where   not exists  (select a.sid from "+schemaName+".shipment a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendorders_c b where   not exists  (select a.sid from "+schemaName+".vendorders a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuinvoice_c b where   not exists  (select a.sid from "+schemaName+".cuinvoice a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuorders_c b where   not exists  (select a.sid from "+schemaName+".cuorders a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".project_c b where   not exists  (select a.sid from "+schemaName+".project a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".outline_c b where   not exists  (select a.sid from "+schemaName+".outline a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".venquote_c b where   not exists  (select a.sid from "+schemaName+".venquote a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuquote_c b where   not exists  (select a.sid from "+schemaName+".cuquote a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".machine_c b where   not exists  (select a.sid from "+schemaName+".machine a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activity_c b where   not exists  (select a.sid from "+schemaName+".activity a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".item_c b where   not exists  (select a.sid from "+schemaName+".item a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".employee_c b where   not exists  (select a.sid from "+schemaName+".employee a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".customer_c b where   not exists  (select a.sid from "+schemaName+".customer a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendor_c b where   not exists  (select a.sid from "+schemaName+".vendor a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".location_c b where   not exists  (select a.sid from "+schemaName+".location a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;
     sqlScript="delete from "+schemaName+".account_c b where   not exists  (select a.sid from "+schemaName+".account a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".rgendb_c b where   not exists  (select a.sid from "+schemaName+".rgendb a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".company_c b where   not exists  (select a.sid from "+schemaName+".company a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".rollupgroup_c b where   not exists  (select a.sid from "+schemaName+".rollupgroup a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".rgenapp_c b where   not exists  (select a.sid from "+schemaName+".rgenapp a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".resource_bundle_c b where   not exists  (select a.sid from "+schemaName+".resource_bundle a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".perioddates_c b where   not exists  (select a.sid from "+schemaName+".perioddates a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".itembom_c b where   not exists  (select a.sid from "+schemaName+".itembom a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where not exists (select a.sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid)";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where not exists (select a.sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();

     sqlScript="delete from "+schemaName+".control_c b where   not exists  (select a.sid from "+schemaName+".control a where  a.sid = b.sid )";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".client_c b where   not exists  (select a.sid from "+schemaName+".client a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".residency_c b where   not exists  (select a.sid from "+schemaName+".residency a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".membersgroup_c b where   not exists  (select a.sid from "+schemaName+".membersgroup a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".division_c b where   not exists  (select a.sid from "+schemaName+".division a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".department_c b where   not exists  (select a.sid from "+schemaName+".department a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".address_c b where   not exists  (select a.sid from "+schemaName+".address a where  a.sid = b.sid)";
      q = entityManager.createNativeQuery(sqlScript);

     deletedCount = deletedCount +q.executeUpdate();





     // insert into backup if new rows in main
     // follow insertionOrder.txt produced by schemaSpyGui which is in reverse order of deleteOrder.txt.

      sqlScript="insert into "+schemaName+".address_c select * from "+schemaName+".address a where  not exists (select a.sid from "+schemaName+".address_c b where b.sid = a.sid)";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".department_c select * from "+schemaName+".department a where  not exists (select a.sid from "+schemaName+".department_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".division_c select * from "+schemaName+".division a where  not exists (select a.sid from "+schemaName+".division_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".membersgroup_c select * from "+schemaName+".membersgroup a where  not exists (select a.sid from "+schemaName+".membersgroup_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".residency_c select * from "+schemaName+".residency a where  not exists (select a.sid from "+schemaName+".residency_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".client_c select * from "+schemaName+".client a where  not exists (select a.sid from "+schemaName+".client_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".control_c select * from "+schemaName+".control a where  not exists (select a.sid from "+schemaName+".control_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itembom_c select * from "+schemaName+".itembom a where  not exists (select a.sid from "+schemaName+".itembom_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where  not exists (select a.sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".perioddates_c select * from "+schemaName+".perioddates a where  not exists (select a.sid from "+schemaName+".perioddates_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rgenapp_c select * from "+schemaName+".rgenapp a where  not exists (select a.sid from "+schemaName+".rgenapp_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rollupgroup_c select * from "+schemaName+".rollupgroup a where  not exists (select a.sid from "+schemaName+".rollupgroup_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".company_c select * from "+schemaName+".company a where  not exists (select a.sid from "+schemaName+".company_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rgendb_c select * from "+schemaName+".rgendb a where  not exists (select a.sid from "+schemaName+".rgendb_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();
      countp=insertedCount;

      sqlScript="insert into "+schemaName+".account_c select * from "+schemaName+".account a where  not exists (select a.sid from "+schemaName+".account_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();
      countp=insertedCount;

      sqlScript="insert into "+schemaName+".location_c select * from "+schemaName+".location a where  not exists (select a.sid from "+schemaName+".location_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vendor_c select * from "+schemaName+".vendor a where  not exists (select a.sid from "+schemaName+".vendor_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".customer_c select * from "+schemaName+".customer a where  not exists (select a.sid from "+schemaName+".customer_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".employee_c select * from "+schemaName+".employee a where  not exists (select a.sid from "+schemaName+".employee_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".item_c select * from "+schemaName+".item a where  not exists (select a.sid from "+schemaName+".item_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".activity_c select * from "+schemaName+".activity a where  not exists (select a.sid from "+schemaName+".activity_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".machine_c select * from "+schemaName+".machine a where  not exists (select a.sid from "+schemaName+".machine_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuquote_c select * from "+schemaName+".cuquote a where  not exists (select a.sid from "+schemaName+".cuquote_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".venquote_c select * from "+schemaName+".venquote a where  not exists (select a.sid from "+schemaName+".venquote_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".outline_c select * from "+schemaName+".outline a where  not exists (select a.sid from "+schemaName+".outline_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".project_c select * from "+schemaName+".project a where  not exists (select a.sid from "+schemaName+".project_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuorders_c select * from "+schemaName+".cuorders a where  not exists (select a.sid from "+schemaName+".cuorders_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vendorders_c select * from "+schemaName+".vendorders a where  not exists (select a.sid from "+schemaName+".vendorders_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vshipmen_c select * from "+schemaName+".vshipmen a where  not exists (select a.sid from "+schemaName+".vshipmen_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuinvoice_c select * from "+schemaName+".cuinvoice a where  not exists (select a.sid from "+schemaName+".cuinvoice_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".shipment_c select * from "+schemaName+".shipment a where  not exists (select a.sid from "+schemaName+".shipment_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vinvoice_c select * from "+schemaName+".vinvoice a where  not exists (select a.sid from "+schemaName+".vinvoice_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".groupmembers_c select * from "+schemaName+".groupmembers a where  not exists (select a.sid from "+schemaName+".groupmembers_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".processdetails_c select * from "+schemaName+".processdetails a where  not exists (select a.sid from "+schemaName+".processdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itemjob_c select * from "+schemaName+".itemjob a where  not exists (select a.sid from "+schemaName+".itemjob_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".rgentable_c select * from "+schemaName+".rgentable a where  not exists (select a.sid from "+schemaName+".rgentable_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".wageearner_c select * from "+schemaName+".wageearner a where  not exists (select a.sid from "+schemaName+".wageearner_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".activityjob_c select * from "+schemaName+".activityjob a where  not exists (select a.sid from "+schemaName+".activityjob_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".glentries_c select * from "+schemaName+".glentries a where  not exists (select a.sid from "+schemaName+".glentries_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cpayment_c select * from "+schemaName+".cpayment a where  not exists (select a.sid from "+schemaName+".cpayment_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".task_c select * from "+schemaName+".task a where  not exists (select a.sid from "+schemaName+".task_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vpayment_c select * from "+schemaName+".vpayment a where  not exists (select a.sid from "+schemaName+".vpayment_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".emplorders_c select * from "+schemaName+".emplorders a where  not exists (select a.sid from "+schemaName+".emplorders_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


     sqlScript="insert into "+schemaName+".\"USER_c\" select * from "+schemaName+".user a where  not exists (select a.sid from "+schemaName+".\"USER_c\" b where b.sid = a.sid )";
     if(dbProductName.equals("psql")){
      sqlScript="insert into "+schemaName+".\"user_c\" select * from "+schemaName+".user a where  not exists (select a.sid from "+schemaName+".\"user_c\" b where b.sid = a.sid )";
     }

      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".acintegr_c select * from "+schemaName+".acintegr a where  not exists (select a.sid from "+schemaName+".acintegr_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".controlusagebyperiods_c select * from "+schemaName+".controlusagebyperiods a where  not exists (select a.sid from "+schemaName+".controlusagebyperiods_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".processattributes_c select * from "+schemaName+".processattributes a where  not exists (select a.sid from "+schemaName+".processattributes_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_c select * from "+schemaName+".resource a where  not exists (select a.sid from "+schemaName+".resource_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_c select * from "+schemaName+".resource a where  not exists (select a.sid from "+schemaName+".resource_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".userprofl_c select * from "+schemaName+".userprofl a where  not exists (select a.sid from "+schemaName+".userprofl_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".venartha_c select * from "+schemaName+".venartha a where  not exists (select a.sid from "+schemaName+".venartha_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".wageearneraux_c select * from "+schemaName+".wageearneraux a where  not exists (select a.sid from "+schemaName+".wageearneraux_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".activityjobdetails_c select * from "+schemaName+".activityjobdetails a where  not exists (select a.sid from "+schemaName+".activityjobdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cupdetails_c select * from "+schemaName+".cupdetails a where  not exists (select a.sid from "+schemaName+".cupdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".gentriesdetails_c select * from "+schemaName+".gentriesdetails a where  not exists (select a.sid from "+schemaName+".gentriesdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".holiday_c select * from "+schemaName+".holiday a where  not exists (select a.sid from "+schemaName+".holiday_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itembomdetails_c select * from "+schemaName+".itembomdetails a where  not exists (select a.sid from "+schemaName+".itembomdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();




      sqlScript="insert into "+schemaName+".rgenfields_c select * from "+schemaName+".rgenfields a where  not exists (select a.sid from "+schemaName+".rgenfields_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".usagebyperiods_c select * from "+schemaName+".usagebyperiods a where  not exists (select a.sid from "+schemaName+".usagebyperiods_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuidetails_c select * from "+schemaName+".cuidetails a where  not exists (select a.sid from "+schemaName+".cuidetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuodetails_c select * from "+schemaName+".cuodetails a where  not exists (select a.sid from "+schemaName+".cuodetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuqdetails_c select * from "+schemaName+".cuqdetails a where  not exists (select a.sid from "+schemaName+".cuqdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".emplodetails_c select * from "+schemaName+".emplodetails a where  not exists (select a.sid from "+schemaName+".emplodetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".resourcedetails_c select * from "+schemaName+".resourcedetails a where  not exists (select a.sid from "+schemaName+".resourcedetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendidetails_c select * from "+schemaName+".vendidetails a where  not exists (select a.sid from "+schemaName+".vendidetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendodetails_c select * from "+schemaName+".vendodetails a where  not exists (select a.sid from "+schemaName+".vendodetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendpdetails_c select * from "+schemaName+".vendpdetails a where  not exists (select a.sid from "+schemaName+".vendpdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendqdetails_c select * from "+schemaName+".vendqdetails a where  not exists (select a.sid from "+schemaName+".vendqdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".ccontact_c select * from "+schemaName+".ccontact a where  not exists (select a.sid from "+schemaName+".ccontact_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".shipmentdetails_c select * from "+schemaName+".shipmentdetails a where  not exists (select a.sid from "+schemaName+".shipmentdetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vcontact_c select * from "+schemaName+".vcontact a where  not exists (select a.sid from "+schemaName+".vcontact_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vshipmendetails_c select * from "+schemaName+".vshipmendetails a where  not exists (select a.sid from "+schemaName+".vshipmendetails_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".schedule_c select * from "+schemaName+".schedule a where  not exists (select a.sid from "+schemaName+".schedule_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".jobassignment_c select * from "+schemaName+".jobassignment a where  not exists (select a.sid from "+schemaName+".jobassignment_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".acperiod_c select * from "+schemaName+".acperiod a where  not exists (select a.sid from "+schemaName+".acperiod_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".arthahist_c select * from "+schemaName+".arthahist a where  not exists (select a.sid from "+schemaName+".arthahist_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".arthatbl_c select * from "+schemaName+".arthatbl a where  not exists (select a.sid from "+schemaName+".arthatbl_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".holiday_c select * from "+schemaName+".holiday a where  not exists (select a.sid from "+schemaName+".holiday_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".blobdata_c select * from "+schemaName+".blobdata a where  not exists (select a.sid from "+schemaName+".blobdata_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".blobdata_c select * from "+schemaName+".blobdata a where not exists (select a.sid from "+schemaName+".blobdata_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cjournal_c select * from "+schemaName+".cjournal a where  not exists (select a.sid from "+schemaName+".cjournal_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".clobdata_c select * from "+schemaName+".clobdata a where  not exists (select a.sid from "+schemaName+".clobdata_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".clobdata_c select * from "+schemaName+".clobdata a where  not exists (select a.sid from "+schemaName+".clobdata_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".editlog_c select * from "+schemaName+".editlog a where  not exists (select a.sid from "+schemaName+".editlog_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".genoptions_c select * from "+schemaName+".genoptions a where  not exists (select a.sid from "+schemaName+".genoptions_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".hlogfile_c select * from "+schemaName+".hlogfile a where  not exists (select a.sid from "+schemaName+".hlogfile_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".jjournal_c select * from "+schemaName+".jjournal a where  not exists (select a.sid from "+schemaName+".jjournal_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".journal_c select * from "+schemaName+".journal a where  not exists (select a.sid from "+schemaName+".journal_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".nextserialno_c select * from "+schemaName+".nextserialno a where  not exists (select a.sid from "+schemaName+".nextserialno_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".options_c select * from "+schemaName+".options a where  not exists (select a.sid from "+schemaName+".options_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".rate1f_c select * from "+schemaName+".rate1f a where  not exists (select a.sid from "+schemaName+".rate1f_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".scandate_c select * from "+schemaName+".scandate a where  not exists (select a.sid from "+schemaName+".scandate_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".serialnumbers_c select * from "+schemaName+".serialnumbers a where  not exists (select a.sid from "+schemaName+".serialnumbers_c b where b.sid = a.sid )";
      q = entityManager.createNativeQuery(sqlScript);

      insertedCount=insertedCount+q.executeUpdate();




      // update backup if row in main has changed (relies on statusfldate change)
      // jay whats about those not having statusfldt? either add field or rely on parent status fld
      // and group the updates together
      // order should not matter because all the foreign keys should exist but will follow insert order
//postgresql UPDATE genapp.journal_b SET sid=a.sid,spostdate=a.spostdate,postdate=a.postdate,owner2=a.owner2 FROM  genapp.journal a  where(genapp.journal_b.sid=a.sid AND a.postdate<>genapp.journal_b.postdate AND a.owner2='localhost')
//hsqldb or stanard UPDATE genapp.journal_b b SET (sid,spostdate,postdate,owner2)=(SELECT sid,spostdate,postdate,owner2 FROM  genapp.journal a where b.sid=a.sid AND a.postdate<>b.postdate AND a.owner2='localhost')
/*
sqlScript="UPDATE "+schemaName+".journal_b b SET(sid,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,statusfl,owner,owner2)=(SELECT sid,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,statusfl,owner,owner2 FROM "+schemaName+".journal a where a.sid=b.sid AND a.postdate<>b.postdate and a.owner2=:owner2)";
if(dbProductName.equals("psql")){
 sqlScript="UPDATE "+schemaName+".journal_b SET sid=a.sid,a.spostdate=a.spostdate,postdate=a.postdate,calendardt=a.calendardt,jrnltype=a.jrnltype,jnlseqb=,jnlseq=a.jnlseq,jnlseqs=a.jnlseqs,period=a.period,account=a.account,debit=a.debit,credit=a.credit,xreference=a.xreference,descript=a.descript,statusfl=a.statusfl,owner=a.owner,owner2=a.owner2) FROM "+schemaName+".journal a where(genapp.journal_b.sid=a.sid AND a.postdate<>genapp.journal_b.postdate AND a.owner2=:owner2)";
}
sqlScript="UPDATE "+schemaName+".ADDRESS_c b SET(SID,ADDRESCODE,ADDRL1,ADDRL2,ADDRL3,CITY,PROVNSTATE,COUNTRY,PZCODE,DESCRIPT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,PRINTMSTAT,PRINMTFLDT)=(a.SID,a.ADDRESCODE,a.ADDRL1,a.ADDRL2,a.ADDRL3,a.CITY,a.PROVNSTATE,a.COUNTRY,a.PZCODE,a.DESCRIPT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.PRINTMSTAT,a.PRINMTFLDT)FROM "+schemaName+".address a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".OPTIONS_c b SET(SID,ROW,OPTIONS01,PURPOSE01,VALUE01,OPTIONS02,PURPOSE02,VALUE02,OPTIONS03,PURPOSE03,VALUE03,OPTIONS04,PURPOSE04,VALUE04,OPTIONS05,PURPOSE05,VALUE05,OPTIONS06,PURPOSE06,VALUE06,OPTIONS07,PURPOSE07,VALUE07,OPTIONS08,PURPOSE08,VALUE08,OPTIONS09,PURPOSE09,VALUE09,OPTIONS10,PURPOSE10,VALUE10,OPTIONS11,PURPOSE11,VALUE11,OPTIONS12,PURPOSE12,VALUE12,OPTIONS13,PURPOSE13,VALUE13,OPTIONS14,PURPOSE14,VALUE14,OPTIONS15,PURPOSE15,VALUE15,OPTIONS16,PURPOSE16,VALUE16,OPTIONS17,PURPOSE17,VALUE17,OPTIONS18,PURPOSE18,VALUE18,OPTIONS19,PURPOSE19,VALUE19,OPTIONS20,PURPOSE20,VALUE20,OPTIONS21,PURPOSE21,VALUE21,OPTIONS22,PURPOSE22,VALUE22,OPTIONS23,PURPOSE23,VALUE23,OPTIONS24,PURPOSE24,VALUE24,OPTIONS25,PURPOSE25,VALUE25,OPTIONS26,PURPOSE26,VALUE26,OPTIONS27,PURPOSE27,VALUE27,OPTIONS28,PURPOSE28,VALUE28,OPTIONS29,PURPOSE29,VALUE29,OPTIONS30,PURPOSE30,VALUE30,OPTIONS31,PURPOSE31,VALUE31,OPTIONS32,PURPOSE32,VALUE32,OPTIONS33,PURPOSE33,VALUE33,OPTIONS34,PURPOSE34,VALUE34,OPTIONS35,PURPOSE35,VALUE35,OPTIONS36,PURPOSE36,VALUE36,OPTIONS37,PURPOSE37,VALUE37,OPTIONS38,PURPOSE38,VALUE38,OPTIONS39,PURPOSE39,VALUE39,OPTIONS40,PURPOSE40,VALUE40,OPTIONS41,PURPOSE41,VALUE41,OPTIONS42,PURPOSE42,VALUE42,OPTIONS43,PURPOSE43,VALUE43,OPTIONS44,PURPOSE44,VALUE44,OPTIONS45,PURPOSE45,VALUE45,OPTIONS46,PURPOSE46,VALUE46,OPTIONS47,PURPOSE47,VALUE47,OPTIONS48,PURPOSE48,VALUE48,OPTIONS49,PURPOSE49,VALUE49,OPTIONS50,PURPOSE50,VALUE50,OPTIONS51,PURPOSE51,VALUE51,OPTIONS52,PURPOSE52,VALUE52,OPTIONS53,PURPOSE53,VALUE53,OPTIONS54,PURPOSE54,VALUE54,OPTIONS55,PURPOSE55,VALUE55,OPTIONS56,PURPOSE56,VALUE56,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.ROW,a.OPTIONS01,a.PURPOSE01,a.VALUE01,a.OPTIONS02,a.PURPOSE02,a.VALUE02,a.OPTIONS03,a.PURPOSE03,a.VALUE03,a.OPTIONS04,a.PURPOSE04,a.VALUE04,a.OPTIONS05,a.PURPOSE05,a.VALUE05,a.OPTIONS06,a.PURPOSE06,a.VALUE06,a.OPTIONS07,a.PURPOSE07,a.VALUE07,a.OPTIONS08,a.PURPOSE08,a.VALUE08,a.OPTIONS09,a.PURPOSE09,a.VALUE09,a.OPTIONS10,a.PURPOSE10,a.VALUE10,a.OPTIONS11,a.PURPOSE11,a.VALUE11,a.OPTIONS12,a.PURPOSE12,a.VALUE12,a.OPTIONS13,a.PURPOSE13,a.VALUE13,a.OPTIONS14,a.PURPOSE14,a.VALUE14,a.OPTIONS15,a.PURPOSE15,a.VALUE15,a.OPTIONS16,a.PURPOSE16,a.VALUE16,a.OPTIONS17,a.PURPOSE17,a.VALUE17,a.OPTIONS18,a.PURPOSE18,a.VALUE18,a.OPTIONS19,a.PURPOSE19,a.VALUE19,a.OPTIONS20,a.PURPOSE20,a.VALUE20,a.OPTIONS21,a.PURPOSE21,a.VALUE21,a.OPTIONS22,a.PURPOSE22,a.VALUE22,a.OPTIONS23,a.PURPOSE23,a.VALUE23,a.OPTIONS24,a.PURPOSE24,a.VALUE24,a.OPTIONS25,a.PURPOSE25,a.VALUE25,a.OPTIONS26,a.PURPOSE26,a.VALUE26,a.OPTIONS27,a.PURPOSE27,a.VALUE27,a.OPTIONS28,a.PURPOSE28,a.VALUE28,a.OPTIONS29,a.PURPOSE29,a.VALUE29,a.OPTIONS30,a.PURPOSE30,a.VALUE30,a.OPTIONS31,a.PURPOSE31,a.VALUE31,a.OPTIONS32,a.PURPOSE32,a.VALUE32,a.OPTIONS33,a.PURPOSE33,a.VALUE33,a.OPTIONS34,a.PURPOSE34,a.VALUE34,a.OPTIONS35,a.PURPOSE35,a.VALUE35,a.OPTIONS36,a.PURPOSE36,a.VALUE36,a.OPTIONS37,a.PURPOSE37,a.VALUE37,a.OPTIONS38,a.PURPOSE38,a.VALUE38,a.OPTIONS39,a.PURPOSE39,a.VALUE39,a.OPTIONS40,a.PURPOSE40,a.VALUE40,a.OPTIONS41,a.PURPOSE41,a.VALUE41,a.OPTIONS42,a.PURPOSE42,a.VALUE42,a.OPTIONS43,a.PURPOSE43,a.VALUE43,a.OPTIONS44,a.PURPOSE44,a.VALUE44,a.OPTIONS45,a.PURPOSE45,a.VALUE45,a.OPTIONS46,a.PURPOSE46,a.VALUE46,a.OPTIONS47,a.PURPOSE47,a.VALUE47,a.OPTIONS48,a.PURPOSE48,a.VALUE48,a.OPTIONS49,a.PURPOSE49,a.VALUE49,a.OPTIONS50,a.PURPOSE50,a.VALUE50,a.OPTIONS51,a.PURPOSE51,a.VALUE51,a.OPTIONS52,a.PURPOSE52,a.VALUE52,a.OPTIONS53,a.PURPOSE53,a.VALUE53,a.OPTIONS54,a.PURPOSE54,a.VALUE54,a.OPTIONS55,a.PURPOSE55,a.VALUE55,a.OPTIONS56,a.PURPOSE56,a.VALUE56,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".OPTIONS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

String line1="UPDATE "+schemaName+".CLIENT_c b SET(SID,CLIENTVERSION,SERIALNUM,ENTERPRISECOMPANYNA,DESCRIPT,ADDRL1,ADDRL2,ADDRL3,CITY,PROVNSTATE,COUNTRYNAME,PZCODE,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,ENTERPRISECOMPCODE,ENTERPRISECOMPSIZE,BARCSIZE,LEVEL,POSKIPP,LOOSEIT,JOBSKIP,CARTONFL,PICKLIST,PRODDESC,PRODCODE,NJOB,NMATERIA,NACTIVITY,NBUTT,NCUSTOME,NCONTACT,NVENDOR,NEMPLOYEE,NSCHEDULE,NREJECT,NRETURN,NCODE,MANUFID,BARTYPE,CADTYPE,CARTYPE,SHITYPE,REPTYPE,LOCTYPE,BARCOL,CARCOL,CADCOL,SHICOL,REPCOL,LOCCOL,ALTSERIA,COUNTRYCODE,NALTSERI,SCRCOLOR,HILCOLOR,TEXTCOLOR,BACCOLOR,DATETYPE,CURRSYMB,CURRCODE,PRINBAR,BARPRINT,CARPRINT,CADPRINT,LOCPRINT,SHIPRINT,REPPRINT,BARPRTY,REPPRTY,CARPRTY,CADPRTY,SHIPRTY,LOCPRTY,ALTSELEN,CUSTOLEN,CARCSIZE,CADCSIZE,SHICSIZE,REPCSIZE,LOCCSIZE,CS,NCONFTYP,NLOCATIO,NDIVCODE,NDEPCODE,NADDCODE,NFLOOR,NROOM,NRACK,MENUTYPE,PADTYPE,NRATE1TA,NRATE2TA,DEFCONFT,BEEPSOU,CONFIRM,LINEFEED,REFBARADJ,SHIBARADJ,CUSBARADJ,LOCBARADJ,CARBARADJ,NCORDER,NSPERSON,PROMPTI,CUSTOMERQUOTENB,CUSTOMERQUOTEN,CUSTOMERQUOTENA,CUSTOMERORDERNB,CUSTOMERORDERN,CUSTOMERORDERNA,VENDORORDERNB,VENDORORDERN,VENDORORDERNA,EMPLOYEEORDERNB,EMPLOYEEORDERN,EMPLOYEEORDERNA,JOBNB,JOBN,JOBNA,CUSTOMERINVOICENB,CUSTOMERINVOICEN,CUSTOMERINVOICENA,VENDORINVOICENB,VENDORINVOICEN,VENDORINVOICENA,CUSTOMERPICKNB,CUSTOMERPICKN,CUSTOMERPICKNA,VENDORQUOTENB,VENDORQUOTEN,VENDORQUOTENA,CUSTOMERPAYMNTNB,CUSTOMERPAYMNTN,CUSTOMERPAYMNTNA,VENDORPAYMNTNB,VENDORPAYMNTN,VENDORPAYMNTNA,VENDORCHQNB,VENDORCHQN,VENDORCHQNA,TASKNB,TASKN,TASKNA,ARSEQB,ARSEQ,ARSEQA,APSEQB,APSEQ,APSEQA,GLSEQB,GLSEQ,GLSEQA,PASEQB,PASEQ,PASEQA,ICSEQB,ICSEQ,ICSEQA,JOSEQB,JOSEQ,JOSEQA,SGLENTRY,TAX1CODE,TAX2CODE,TAX3CODE,NDECIMAL,EDIPASSW,INTPASSW,INRPASSW,IMLPASSW,RMLPASSW,LMLPASSW,HOSPASSW,LANPASSW,WANPASSW,ASHOSTID,HDSTYLE,MTSTYLE,STSTYLE,DTSTYLE,FTSTYLE,DEFAULTR,DEFAULTC,DBNAME,ROOTDIR,KEYORDER,CURRBUSDAT,LASTBUSDAT,CURRCALDAT,LASTCALDAT,PREPROCESS,MARGIN,FOOTER,LASTUSER,LISTBUILDC,LISTBUILDV,LISTBUILDE,LISTBROWNC,LISTBROWNV,LISTBROWNE,SMTPSERVER,SMTPUSER,SMTPPASS,POP3SERVER,POP3USER,POP3PASS,SMATCODE,FYREND,FPERIODS,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,licensetype,licensestart,licenseend)=(a.sid,a.CLIENTVERSION,a.SERIALNUM,a.ENTERPRISECOMPANYNA,a.DESCRIPT,a.ADDRL1,a.ADDRL2,a.ADDRL3,a.CITY,a.PROVNSTATE,a.COUNTRYNAME,a.PZCODE,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.ENTERPRISECOMPCODE,a.ENTERPRISECOMPSIZE,a.BARCSIZE,a.LEVEL,a.POSKIPP,a.LOOSEIT,a.JOBSKIP,a.CARTONFL,a.PICKLIST,a.PRODDESC,a.PRODCODE,a.NJOB,a.NMATERIA,a.NACTIVITY,a.NBUTT,a.NCUSTOME,a.NCONTACT,a.NVENDOR,a.NEMPLOYEE,a.NSCHEDULE,a.NREJECT,a.NRETURN,a.NCODE,a.MANUFID,a.BARTYPE,a.CADTYPE,a.CARTYPE,a.SHITYPE,a.REPTYPE,a.LOCTYPE,a.BARCOL,a.CARCOL,a.CADCOL,a.SHICOL,a.REPCOL,a.LOCCOL,a.ALTSERIA,a.COUNTRYCODE,a.NALTSERI,a.SCRCOLOR,a.HILCOLOR,";
sqlScript=line1+"a.TEXTCOLOR,a.BACCOLOR,a.DATETYPE,a.CURRSYMB,a.CURRCODE,a.PRINBAR,a.BARPRINT,a.CARPRINT,a.CADPRINT,a.LOCPRINT,a.SHIPRINT,a.REPPRINT,a.BARPRTY,a.REPPRTY,a.CARPRTY,a.CADPRTY,a.SHIPRTY,a.LOCPRTY,a.ALTSELEN,a.CUSTOLEN,a.CARCSIZE,a.CADCSIZE,a.SHICSIZE,a.REPCSIZE,a.LOCCSIZE,a.CS,a.NCONFTYP,a.NLOCATIO,a.NDIVCODE,a.NDEPCODE,a.NADDCODE,a.NFLOOR,a.NROOM,a.NRACK,a.MENUTYPE,a.PADTYPE,a.NRATE1TA,a.NRATE2TA,a.DEFCONFT,a.BEEPSOU,a.CONFIRM,a.LINEFEED,a.REFBARADJ,a.SHIBARADJ,a.CUSBARADJ,a.LOCBARADJ,a.CARBARADJ,a.NCORDER,a.NSPERSON,a.PROMPTI,a.CUSTOMERQUOTENB,a.CUSTOMERQUOTEN,a.CUSTOMERQUOTENA,a.CUSTOMERORDERNB,a.CUSTOMERORDERN,a.CUSTOMERORDERNA,a.VENDORORDERNB,a.VENDORORDERN,a.VENDORORDERNA,a.EMPLOYEEORDERNB,a.EMPLOYEEORDERN,a.EMPLOYEEORDERNA,a.JOBNB,a.JOBN,a.JOBNA,a.CUSTOMERINVOICENB,a.CUSTOMERINVOICEN,a.CUSTOMERINVOICENA,a.VENDORINVOICENB,a.VENDORINVOICEN,a.VENDORINVOICENA,a.CUSTOMERPICKNB,a.CUSTOMERPICKN,a.CUSTOMERPICKNA,a.VENDORQUOTENB,a.VENDORQUOTEN,a.VENDORQUOTENA,a.CUSTOMERPAYMNTNB,a.CUSTOMERPAYMNTN,a.CUSTOMERPAYMNTNA,a.VENDORPAYMNTNB,a.VENDORPAYMNTN,a.VENDORPAYMNTNA,a.VENDORCHQNB,a.VENDORCHQN,a.VENDORCHQNA,a.TASKNB,a.TASKN,a.TASKNA,a.ARSEQB,a.ARSEQ,a.ARSEQA,a.APSEQB,a.APSEQ,a.APSEQA,a.GLSEQB,a.GLSEQ,a.GLSEQA,a.PASEQB,a.PASEQ,a.PASEQA,a.ICSEQB,a.ICSEQ,a.ICSEQA,a.JOSEQB,a.JOSEQ,a.JOSEQA,a.SGLENTRY,a.TAX1CODE,a.TAX2CODE,a.TAX3CODE,a.NDECIMAL,a.EDIPASSW,a.INTPASSW,a.INRPASSW,a.IMLPASSW,a.RMLPASSW,a.LMLPASSW,a.HOSPASSW,a.LANPASSW,a.WANPASSW,a.ASHOSTID,a.HDSTYLE,a.MTSTYLE,a.STSTYLE,a.DTSTYLE,a.FTSTYLE,a.DEFAULTR,a.DEFAULTC,a.DBNAME,a.ROOTDIR,a.KEYORDER,a.CURRBUSDAT,a.LASTBUSDAT,a.CURRCALDAT,a.LASTCALDAT,a.PREPROCESS,a.MARGIN,a.FOOTER,a.LASTUSER,a.LISTBUILDC,a.LISTBUILDV,a.LISTBUILDE,a.LISTBROWNC,a.LISTBROWNV,a.LISTBROWNE,a.SMTPSERVER,a.SMTPUSER,a.SMTPPASS,a.POP3SERVER,a.POP3USER,a.POP3PASS,a.SMATCODE,a.FYREND,a.FPERIODS,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.licensetype,a.licensestart,a.licenseend)FROM "+schemaName+".CLIENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".DEPARTMENT_c b SET(SID,DEPCODE,DESCRIPT,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.DEPCODE,a.DESCRIPT,a.GLPREFIX,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".DEPARTMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".COMPANY_c b SET(SID,COMPANYCODE,DESCRIPT,LEGALNAME,MAILTOCODE,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.COMPANYCODE,a.DESCRIPT,a.LEGALNAME,a.MAILTOCODE,a.GLPREFIX,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".COMPANY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CONTROL_c b SET(SID,CONTROLCODE,DESCRIPT,TYPEOFCONTROL,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.CONTROLCODE,a.DESCRIPT,a.TYPEOFCONTROL,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".CONTROL a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".DIVISION_c b SET(SID,DIVCODE,DESCRIPT,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.DIVCODE,a.DESCRIPT,a.GLPREFIX,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".DIVISION a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".LOCATION_c b SET(SID,LOCATION,DESCRIPT,COMPANYCODE,ADDRESSCODE,FLOOR,ROOM,RACK,PRINTMSTAT,PRINMTFLDT,EXCLUDE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.LOCATION,a.DESCRIPT,a.COMPANYCODE,a.ADDRESSCODE,a.FLOOR,a.ROOM,a.RACK,a.PRINTMSTAT,a.PRINMTFLDT,a.EXCLUDE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".LOCATION a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".RESIDENCY_c b SET(SID,RESIDENCY,DESCRIPT,MUNICIPALITY,PROVINCE,COUNTRYNAME,EXCLUDE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.RESIDENCY,a.DESCRIPT,a.MUNICIPALITY,a.PROVINCE,a.COUNTRYNAME,a.EXCLUDE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RESIDENCY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();
countp=updatedCount;

sqlScript="UPDATE "+schemaName+".ACCOUNT_c b SET(SID,ACCOUNT,DESCRIPT,CATEGORY,TYPE,BUDGET,ACTUAL,ACTUALN,PREVBUDG,PREVACT,SEQUENCE,CHILD,PARENT,ROLLUPQ,COMPANYCODE,DEPCODE,DIVCODE,STATUSFL,STATUSFLDT,CURRENCY,NOTES,OWNER,OWNER2,P0,P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P8T,P9T,P10T,P11T)=(a.SID,a.ACCOUNT,a.DESCRIPT,a.CATEGORY,a.TYPE,a.BUDGET,a.ACTUAL,a.ACTUALN,a.PREVBUDG,a.PREVACT,a.SEQUENCE,a.CHILD,a.PARENT,a.ROLLUPQ,a.COMPANYCODE,a.DEPCODE,a.DIVCODE,a.STATUSFL,a.STATUSFLDT,a.CURRENCY,a.NOTES,a.OWNER,a.OWNER2,a.P0,a.P1,a.P2,a.P3,a.P4,a.P5,a.P6,a.P7,a.P8,a.P9,a.P10,a.P11,a.P12,a.P13,a.P14,a.P8T,a.P9T,a.P10T,a.P11T)FROM "+schemaName+".ACCOUNT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();
countp=updatedCount;

sqlScript="UPDATE "+schemaName+".CUSTOMER_c b SET(SID,CUSTOMER,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,CUSTOMERASCOMPANYNAME,CUSTTOTL,CUSTTQTY,COMPANYCODE,LOCATION,MAILTOCODE,SHIPTOCODE,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,DOB,PLACEOFBIRTH,SEX,AGE,CUSRTOTL,CUSRTQTY,CUSMTOTL,CUSDTOTL,LASTORDER,LASTINVOIC,LASTPAYMNQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,TOTLPAID,CONTACTED,BYWHO,NXTCONTACT,VIA,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.CUSTOMER,a.DESCRIPT,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.CUSTOMERASCOMPANYNAME,a.CUSTTOTL,a.CUSTTQTY,a.COMPANYCODE,a.LOCATION,a.MAILTOCODE,a.SHIPTOCODE,a.TAX1,a.TAX2,a.TAX3,a.CUSTTAX1,a.CUSTTAX2,a.CUSTTAX3,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.DOB,a.PLACEOFBIRTH,a.SEX,a.AGE,a.CUSRTOTL,a.CUSRTQTY,a.CUSMTOTL,a.CUSDTOTL,a.LASTORDER,a.LASTINVOIC,a.LASTPAYMNQ,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.TYPE,a.DEFAULTGLAC,a.INTEGRSET,a.STATUSFL,a.STATUSFLDT,a.TOTLPAID,a.CONTACTED,a.BYWHO,a.NXTCONTACT,a.VIA,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".CUSTOMER a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);

updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VENDOR_c b SET(SID,VENDOR,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,VENDORASCOMPANYNAME,VENDTOTL,VENDTQTY,COMPANYCODE,LOCATION,MAILTOCODE,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,VENRTOTL,VENRTQTY,VENMTOTL,VENDDTOTL,LASTQUOTE,LASTORDER,LASTINVOIC,LASTPAYMQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,SHIPTOCODE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,TOTLPAID,CONTACTED,BYWHO,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.VENDOR,a.DESCRIPT,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.VENDORASCOMPANYNAME,a.VENDTOTL,a.VENDTQTY,a.COMPANYCODE,a.LOCATION,a.MAILTOCODE,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.VENRTOTL,a.VENRTQTY,a.VENMTOTL,a.VENDDTOTL,a.LASTQUOTE,a.LASTORDER,a.LASTINVOIC,a.LASTPAYMQ,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.TYPE,a.SHIPTOCODE,a.DEFAULTGLAC,a.INTEGRSET,a.STATUSFL,a.STATUSFLDT,a.TOTLPAID,a.CONTACTED,a.BYWHO,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VENDOR a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".EMPLOYEE_c b SET(SID,EMPLOYEE,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,COMPANYCODE,EMPLTOTL,EMPLTQTY,DIVCODE,DEPCODE,LOCATION,RESIDENCY,MAILTOCODE,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,EMPRTOTL,EMPRTQTY,EMPMTOTL,EMPDTOTL,LASTQUOTE,LASTORDER,LASTINVOIC,LASTPAYMQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,SHIPTOCODE,TYPE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,CONTACTED,BYWHO,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.EMPLOYEE,a.DESCRIPT,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.COMPANYCODE,a.EMPLTOTL,a.EMPLTQTY,a.DIVCODE,a.DEPCODE,a.LOCATION,a.RESIDENCY,a.MAILTOCODE,a.TAX1,a.TAX2,a.TAX3,a.CUSTTAX1,a.CUSTTAX2,a.CUSTTAX3,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.EMPRTOTL,a.EMPRTQTY,a.EMPMTOTL,a.EMPDTOTL,a.LASTQUOTE,a.LASTORDER,a.LASTINVOIC,a.LASTPAYMQ,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.SHIPTOCODE,a.TYPE,a.DEFAULTGLAC,a.INTEGRSET,a.STATUSFL,a.STATUSFLDT,a.CONTACTED,a.BYWHO,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".EMPLOYEE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VCONTACT_c b SET(SID,CONTACT,VENDOR,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,LOCATION,MAILTOCODE,SHIPTOCODE,PRINTSTA,SHIPLABEL,TYPE,STATUSFL,STATUSFLDT,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.CONTACT,a.VENDOR,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.LOCATION,a.MAILTOCODE,a.SHIPTOCODE,a.PRINTSTA,a.SHIPLABEL,a.TYPE,a.STATUSFL,a.STATUSFLDT,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VCONTACT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CCONTACT_c b SET(SID,CONTACT,CUSTOMER,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,LOCATION,MAILTOCODE,SHIPTOCODE,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,STATUSFL,STATUSFLDT,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.CONTACT,a.CUSTOMER,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.TAX1,a.TAX2,a.TAX3,a.CUSTTAX1,a.CUSTTAX2,a.CUSTTAX3,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.LOCATION,a.MAILTOCODE,a.SHIPTOCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.TYPE,a.STATUSFL,a.STATUSFLDT,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".CCONTACT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".PERIODDATES_c b SET(SID,PERIOD,DESCRIPT,STARTDATE,ENDDATE,STARTOFWEEK,STARTOFBWEEK,ENDOFBWEEK,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PERIOD,a.DESCRIPT,a.STARTDATE,a.ENDDATE,a.STARTOFWEEK,a.STARTOFBWEEK,a.ENDOFBWEEK,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".PERIODDATES a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".ACPERIOD_c b SET(SID,ROWID,CURRPERIOD,DESCRIPT,CURRBUSDATE,CURRCALDATE,CURRLOCALDATE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.ROWID,a.CURRPERIOD,a.DESCRIPT,a.CURRBUSDATE,a.CURRCALDATE,a.CURRLOCALDATE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ACPERIOD a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".WAGEEARNER_c b SET(SID,WAGEEARNERID,EMPLOYEE,SIN,BIRTHDT,FEDCLAIM,PROVCLAIM,PAYYRFREQ,PAYPERIOD,WCB,WCBYTD,EMPLINSUR,INSYTD,VACRETAIN,VACATONYT,WAGEUNIT,WAGERATE,OTIMEUNIT,OTIMERATE,WAGEUNITS,OTIMUNITS,WAGEOUT,OVTIMEOUT,SALARYOUT,COMMISSION,BENEFITS,VACATION,VACPAYOUT,ADVANCE,PENSION,AFTERTAX,UNIONDUES,MEDICAL,FINCOMETX,PINCOMETX,THISPAYA,LASTPAYA,PAYYTD,FPENSIYTD,PPENSIYTD,ITAXYTD,PTAXYTD,GRPAYYTD,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.WAGEEARNERID,a.EMPLOYEE,a.SIN,a.BIRTHDT,a.FEDCLAIM,a.PROVCLAIM,a.PAYYRFREQ,a.PAYPERIOD,a.WCB,a.WCBYTD,a.EMPLINSUR,a.INSYTD,a.VACRETAIN,a.VACATONYT,a.WAGEUNIT,a.WAGERATE,a.OTIMEUNIT,a.OTIMERATE,a.WAGEUNITS,a.OTIMUNITS,a.WAGEOUT,a.OVTIMEOUT,a.SALARYOUT,a.COMMISSION,a.BENEFITS,a.VACATION,a.VACPAYOUT,a.ADVANCE,a.PENSION,a.AFTERTAX,a.UNIONDUES,a.MEDICAL,a.FINCOMETX,a.PINCOMETX,a.THISPAYA,a.LASTPAYA,a.PAYYTD,a.FPENSIYTD,a.PPENSIYTD,a.ITAXYTD,a.PTAXYTD,a.GRPAYYTD,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".WAGEEARNER a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ARTHATBL_c b SET(SID,USAGE,WCBPERCNT,INSFACTOR,VACATONRATE,PENSIONMAX,WCBMAX,INSMAX,ITAXLV0RATE,ITAXLV1RATE,ITAXLV2RATE,ITAXLV3RATE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.USAGE,a.WCBPERCNT,a.INSFACTOR,a.VACATONRATE,a.PENSIONMAX,a.WCBMAX,a.INSMAX,a.ITAXLV0RATE,a.ITAXLV1RATE,a.ITAXLV2RATE,a.ITAXLV3RATE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ARTHATBL a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ROLLUPGROUP_c b SET(SID,GROUPID,DESCRIPT,TYPE,CURRPW,EXPIRY,CURRENCY,PERIOD0B,PERIOD0,PERIODTOTALSB,PERIODTOTALS,PERIOD1BUDGET,PERIOD1ACTUAL,PERIOD2B,PERIOD2,PERIOD3B,PERIOD3,PERIOD4B,PERIOD4,PERIOD5B,PERIOD5,PERIOD6B,PERIOD6,PERIOD7B,PERIOD7,PERIOD8B,PERIOD8,PERIOD9B,PERIOD9,PERIOD10B,PERIOD10,PERIOD11B,PERIOD11,PERIOD12B,PERIOD12,PERIODNB,PERIODN,NOTES,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.GROUPID,a.DESCRIPT,a.TYPE,a.CURRPW,a.EXPIRY,a.CURRENCY,a.PERIOD0B,a.PERIOD0,a.PERIODTOTALSB,a.PERIODTOTALS,a.PERIOD1BUDGET,a.PERIOD1ACTUAL,a.PERIOD2B,a.PERIOD2,a.PERIOD3B,a.PERIOD3,a.PERIOD4B,a.PERIOD4,a.PERIOD5B,a.PERIOD5,a.PERIOD6B,a.PERIOD6,a.PERIOD7B,a.PERIOD7,a.PERIOD8B,a.PERIOD8,a.PERIOD9B,a.PERIOD9,a.PERIOD10B,a.PERIOD10,a.PERIOD11B,a.PERIOD11,a.PERIOD12B,a.PERIOD12,a.PERIODNB,a.PERIODN,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ROLLUPGROUP a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".MEMBERSGROUP_c b SET(SID,GROUPID,DESCRIPT,QUANTITY,MODE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.GROUPID,a.DESCRIPT,a.QUANTITY,a.MODE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".MEMBERSGROUP a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ARTHAHIST_c b SET(SID,WAGEEARNER,SIN,PERIOD,MONTH,CCYY,VACATION,WAGE,OVERTIME,SALARY,COMMISSION,BENEFIT,FINCOMETX,PINCOMETX,WCBOUT,EMPLINSUR,VACPAYOUT,ADVANCE,FPENSOBTX,FPENSOATX,UNIONDUES,MEDICAL,PAYAMT,NOTES,NOTES2,CHQNUMBER,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.WAGEEARNER,a.SIN,a.PERIOD,a.MONTH,a.CCYY,a.VACATION,a.WAGE,a.OVERTIME,a.SALARY,a.COMMISSION,a.BENEFIT,a.FINCOMETX,a.PINCOMETX,a.WCBOUT,a.EMPLINSUR,a.VACPAYOUT,a.ADVANCE,a.FPENSOBTX,a.FPENSOATX,a.UNIONDUES,a.MEDICAL,a.PAYAMT,a.NOTES,a.NOTES2,a.CHQNUMBER,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ARTHAHIST a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".HOLIDAY_c b SET(SID,SHOLIDAY,HOLIDAY,DESCRIPT,TYPE,STATUSFL,STATUSFLDT,EMPLOYEE,RESIDENCY,OWNER,OWNER2)=(a.SID,a.SHOLIDAY,a.HOLIDAY,a.DESCRIPT,a.TYPE,a.STATUSFL,a.STATUSFLDT,a.EMPLOYEE,a.RESIDENCY,a.OWNER,a.OWNER2)FROM "+schemaName+".HOLIDAY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ITEM_c b SET(SID,MATCODE,QUANTITY,DESCRIPT,DATEADDED,DATEEXPIRY,DATETORENEW,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,LOCATION,BARUPC)=(a.SID,a.MATCODE,a.QUANTITY,a.DESCRIPT,a.DATEADDED,a.DATEEXPIRY,a.DATETORENEW,a.SOURCE1,a.SOURCE2,a.UPCCODE,a.COST,a.REPLCOST,a.SELPRICE,a.SPRICOLD,a.SPRICNEW,a.SPRICEFFDT,a.SHIPCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.MISCCODE1,a.MISCCODE2,a.QTYLEVEL1,a.UNIT,a.CASEQTY,a.TYPE,a.TAX1,a.TAX2,a.TAX3,a.ALIASCODE,a.PARENTCODE,a.AVGPRICE,a.AVGCOST,a.STATUSFL,a.STATUSFLDT,a.SUBCODESN,a.SUBCODESN2,a.SUBCODESN3,a.CUORDQTY,a.VENORQTY,a.CUPICQTY,a.VENPIQTY,a.CUINVQTY,a.CUSHIQTY,a.VENSHQTY,a.EFFDATE,a.INTEGRSET,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.LOCATION,a.BARUPC)FROM "+schemaName+".ITEM a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ACTIVITY_c b SET(SID,ACTIVITYCODE,QUANTITY,DESCRIPT,DATE,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,BARUPC)=(a.SID,a.ACTIVITYCODE,a.QUANTITY,a.DESCRIPT,a.DATE,a.SOURCE1,a.SOURCE2,a.UPCCODE,a.COST,a.REPLCOST,a.SELPRICE,a.SPRICOLD,a.SPRICNEW,a.SPRICEFFDT,a.SHIPCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.MISCCODE1,a.MISCCODE2,a.QTYLEVEL1,a.UNIT,a.CASEQTY,a.TYPE,a.TAX1,a.TAX2,a.TAX3,a.ALIASCODE,a.PARENTCODE,a.AVGPRICE,a.AVGCOST,a.STATUSFL,a.STATUSFLDT,a.SUBCODESN,a.SUBCODESN2,a.SUBCODESN3,a.CUORDQTY,a.VENORQTY,a.CUPICQTY,a.VENPIQTY,a.CUINVQTY,a.CUSHIQTY,a.VENSHQTY,a.EFFDATE,a.INTEGRSET,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.BARUPC)FROM "+schemaName+".ACTIVITY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".SCHEDULE_c b SET(SID,TODO,DESCRIPT,EMPLOYEE,SSDATET,ACTIVITYCODE,LOCATION,SDATET,DURATIONH,DURATIONM,STIMEH,STIMEM,STIMEAMPM,EDATET,PRIORITY,PERCNTDONE,VENDOR,VONTACT,CUSTOMER,TYPE,MAILTOCODE,OTHEREMPLO,REPEATF,STATUSFL,STATUSFLDT,PRIVATEIND,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.TODO,a.DESCRIPT,a.EMPLOYEE,a.SSDATET,a.ACTIVITYCODE,a.LOCATION,a.SDATET,a.DURATIONH,a.DURATIONM,a.STIMEH,a.STIMEM,a.STIMEAMPM,a.EDATET,a.PRIORITY,a.PERCNTDONE,a.VENDOR,a.VONTACT,a.CUSTOMER,a.TYPE,a.MAILTOCODE,a.OTHEREMPLO,a.REPEATF,a.STATUSFL,a.STATUSFLDT,a.PRIVATEIND,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".SCHEDULE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".USERPROFL_c b SET(SID,LOGONID,ROW,OPTION,SELECTVALUE,SCRCOLOR,HILCOLOR,TEXTCOLOR,BACCOLOR,BEEPSOU,CONFIRM,PROMPTI,P1,P2,P3,P4,P5,P6,MTSTYLE,STSTYLE,DTSTYLE,FTSTYLE,DEFAULTR,DEFAULTC,DBNAME,ROOTDIR,KEYORDER,MARGIN,FOOTER,LISTBUILDC,LISTBUILDV,LISTBUILDE,LISTBROWNC,LISTBROWNV,LISTBROWNE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.LOGONID,a.ROW,a.OPTION,a.SELECTVALUE,a.SCRCOLOR,a.HILCOLOR,a.TEXTCOLOR,a.BACCOLOR,a.BEEPSOU,a.CONFIRM,a.PROMPTI,a.P1,a.P2,a.P3,a.P4,a.P5,a.P6,a.MTSTYLE,a.STSTYLE,a.DTSTYLE,a.FTSTYLE,a.DEFAULTR,a.DEFAULTC,a.DBNAME,a.ROOTDIR,a.KEYORDER,a.MARGIN,a.FOOTER,a.LISTBUILDC,a.LISTBUILDV,a.LISTBUILDE,a.LISTBROWNC,a.LISTBROWNV,a.LISTBROWNE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".USERPROFL a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".\"USER_c\" b SET(SID,ID,CLIENT,EMPLOYEE,VENDOR,CUSTOMER,OTHERID,ALEVEL,BLEVEL,CURRPW,EXPIRY,OLDPW,TEMPORARYPASSWORD,PASSWORDHASH,ACTIVATIONKEY,RESTRICT1,RESTRICT2,RESTRICT3,ALLOW1,ALLOW2,ALLOW3,MAXPROFLROW,CPROFLROW,STATUSFL,STATUSFLDT,UCURRCALDA,PREPROCESS,NOTES,DOCMNT,OWNER,OWNER2)=(a.SID,a.ID,a.CLIENT,a.EMPLOYEE,a.VENDOR,a.CUSTOMER,a.OTHERID,a.ALEVEL,a.BLEVEL,a.CURRPW,a.EXPIRY,a.OLDPW,a.TEMPORARYPASSWORD,a.PASSWORDHASH,a.ACTIVATIONKEY,a.RESTRICT1,a.RESTRICT2,a.RESTRICT3,a.ALLOW1,a.ALLOW2,a.ALLOW3,a.MAXPROFLROW,a.CPROFLROW,a.STATUSFL,a.STATUSFLDT,a.UCURRCALDA,a.PREPROCESS,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2)FROM "+schemaName+".\"USER\" a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
if(dbProductName.equals("psql")){
 sqlScript="UPDATE "+schemaName+".\"user_c\" b SET(SID,ID,CLIENT,EMPLOYEE,VENDOR,CUSTOMER,OTHERID,ALEVEL,BLEVEL,CURRPW,EXPIRY,OLDPW,TEMPORARYPASSWORD,PASSWORDHASH,ACTIVATIONKEY,RESTRICT1,RESTRICT2,RESTRICT3,ALLOW1,ALLOW2,ALLOW3,MAXPROFLROW,CPROFLROW,STATUSFL,STATUSFLDT,UCURRCALDA,PREPROCESS,NOTES,DOCMNT,OWNER,OWNER2)=(a.SID,a.ID,a.CLIENT,a.EMPLOYEE,a.VENDOR,a.CUSTOMER,a.OTHERID,a.ALEVEL,a.BLEVEL,a.CURRPW,a.EXPIRY,a.OLDPW,a.TEMPORARYPASSWORD,a.PASSWORDHASH,a.ACTIVATIONKEY,a.RESTRICT1,a.RESTRICT2,a.RESTRICT3,a.ALLOW1,a.ALLOW2,a.ALLOW3,a.MAXPROFLROW,a.CPROFLROW,a.STATUSFL,a.STATUSFLDT,a.UCURRCALDA,a.PREPROCESS,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2)FROM "+schemaName+".\"user\" a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
}

q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VENARTHA_c b SET(SID,CHQNUMBER,RECONCILED,VENDORC,DATE,ADDRESCODE,CHQAMT,AMTVERBOS,NOTES,ADVISEL1,ADVISEL2,ADVISEL3,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.CHQNUMBER,a.RECONCILED,a.VENDORC,a.DATE,a.ADDRESCODE,a.CHQAMT,a.AMTVERBOS,a.NOTES,a.ADVISEL1,a.ADVISEL2,a.ADVISEL3,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".VENARTHA a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".ACINTEGR_c b SET(SID,MODULEID,USAGEDESCR,USAGECODE,SETSID,ACCOUNT,EXTRAINTFIELD,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.MODULEID,a.USAGEDESCR,a.USAGECODE,a.SETSID,a.ACCOUNT,a.EXTRAINTFIELD,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ACINTEGR a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ITEMJOB_c b SET(SID,JOBNO,MATCODE,PRODDATET,QTYALLOC,PONO,QTYOSTND,QTYALSTK,QTYISSUD,JOBTOTL,STATUSFL,CUSTOMEJ,VENDOR,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,PRINTMSTATJ,PRINMTFLDTJ,TYPE,MATCODEOUT,QTYOUT,NOTES,OWNER,OWNER2)=(a.SID,a.JOBNO,a.MATCODE,a.PRODDATET,a.QTYALLOC,a.PONO,a.QTYOSTND,a.QTYALSTK,a.QTYISSUD,a.JOBTOTL,a.STATUSFL,a.CUSTOMEJ,a.VENDOR,a.STATUSFLDT,a.PRINTMSTAT,a.PRINMTFLDT,a.PRINTMSTATJ,a.PRINMTFLDTJ,a.TYPE,a.MATCODEOUT,a.QTYOUT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ITEMJOB a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".ACTIVITYJOB_c b SET(SID,JOBNO,ACTIVITYCODE,PRODDATET,QTYALLOC,PONO,QTYOSTND,QTYALSTK,QTYISSUD,JOBTOTL,STATUSFL,CUSTOMEJ,VENDOR,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,PRINTMSTATJ,PRINMTFLDTJ,TYPE,MATCODEOUT,QTYOUT,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.JOBNO,a.ACTIVITYCODE,a.PRODDATET,a.QTYALLOC,a.PONO,a.QTYOSTND,a.QTYALSTK,a.QTYISSUD,a.JOBTOTL,a.STATUSFL,a.CUSTOMEJ,a.VENDOR,a.STATUSFLDT,a.PRINTMSTAT,a.PRINMTFLDT,a.PRINTMSTATJ,a.PRINMTFLDTJ,a.TYPE,a.MATCODEOUT,a.QTYOUT,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".ACTIVITYJOB a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".PROCESSATTRIBUTES_c b SET(SID,PDETAILS,NAME,VALUE,TYPE,RANGE,STEP,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PDETAILS,a.NAME,a.VALUE,a.TYPE,a.RANGE,a.STEP,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".PROCESSATTRIBUTES a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".PROCESSDETAILS_c b SET(SID,PROCESS,CPONO,MATCODE,CUSTOMER,SDATET,DURATIONH,DURATIONM,STIMEH,STIMEM,STIMEAMPM,EDATET,PRIORITY,PERCNTDONE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PROCESS,a.CPONO,a.MATCODE,a.CUSTOMER,a.SDATET,a.DURATIONH,a.DURATIONM,a.STIMEH,a.STIMEM,a.STIMEAMPM,a.EDATET,a.PRIORITY,a.PERCNTDONE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".PROCESSDETAILS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VENQUOTE_c b SET(SID,PURCHSNO,DELVDATET,VENDOR,MATCODE,REPLICATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,CINVOICE,JOBNO,VPONO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.VENDOR,a.MATCODE,a.REPLICATE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.CINVOICE,a.JOBNO,a.VPONO,a.RFPORD,a.STATUSFLDT,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.SHIPCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VENQUOTE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".VENDORDERS_c b SET(SID,PURCHSNO,DELVDATET,VENDOR,MATCODE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,JOBNO,VENDQNO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.VENDOR,a.MATCODE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.JOBNO,a.VENDQNO,a.RFPORD,a.STATUSFLDT,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.SHIPCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VENDORDERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".VSHIPMEN_c b SET(SID,SHIPCODE,MATCODE,SHIPPER,PONO,CPONO,INVOICE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,CARRIER,TYPE,SHIPDATET,SHIPDATETA,TARENO,PACKNO,VENDOR,CUSTOMER,BILLTOCODE,BILLTOSAMEASSHIPTO,SHIPTOCODE,NOTES,STATUSFL,STATUSFLDT,SERIALNO,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2)=(a.SID,a.SHIPCODE,a.MATCODE,a.SHIPPER,a.PONO,a.CPONO,a.INVOICE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.CARRIER,a.TYPE,a.SHIPDATET,a.SHIPDATETA,a.TARENO,a.PACKNO,a.VENDOR,a.CUSTOMER,a.BILLTOCODE,a.BILLTOSAMEASSHIPTO,a.SHIPTOCODE,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.SERIALNO,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".VSHIPMEN a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CUQUOTE_c b SET(SID,PURCHSNO,DELVDATET,VENDOR,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,CUSTOMER,MATCODE,REPLICATE,CINVOICE,ORDPRICE,JOBNO,VPONO,QUOORDT,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,TYPE,TERMS,PRIORITY,ODATET,SHIPCODE,ACTIVITYCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,ATTACH,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.VENDOR,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.CUSTOMER,a.MATCODE,a.REPLICATE,a.CINVOICE,a.ORDPRICE,a.JOBNO,a.VPONO,a.QUOORDT,a.STATUSFLDT,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.TERMS,a.PRIORITY,a.ODATET,a.SHIPCODE,a.ACTIVITYCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.ATTACH,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".CUQUOTE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".CUORDERS_c b SET(SID,PURCHSNO,DELVDATET,CUSTOMER,MATCODE,CUQUOTE,CINVOICE,JOBNO,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,VPONO,RFPORD,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,DOCMNT,SHIPCODEFROMPAY,SHIPCODE,BARPO)=(a.SID,a.PURCHSNO,a.DELVDATET,a.CUSTOMER,a.MATCODE,a.CUQUOTE,a.CINVOICE,a.JOBNO,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.VPONO,a.RFPORD,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT,a.SHIPCODEFROMPAY,a.SHIPCODE,a.BARPO)FROM "+schemaName+".CUORDERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CUINVOICE_c b SET(SID,INVOICE,CUSTOMER,MATCODE,INVODATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,PONO,REF1TYP,REF1CODE,SHIPDATET,SHIPTYPE,SHIPCODE,TERMS,STATUSFL,STATUSFLDT,TERMSDAT,DISCOUNP,DISCOUDT,DISCOUDS,NETDDAT,NETDDYS,FOB,TYPE,INTEGRSET,ATTACH,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,AGENT,NOTES,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,DOCMNT,BARINVOICE)=(a.SID,a.INVOICE,a.CUSTOMER,a.MATCODE,a.INVODATE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.PONO,a.REF1TYP,a.REF1CODE,a.SHIPDATET,a.SHIPTYPE,a.SHIPCODE,a.TERMS,a.STATUSFL,a.STATUSFLDT,a.TERMSDAT,a.DISCOUNP,a.DISCOUDT,a.DISCOUDS,a.NETDDAT,a.NETDDYS,a.FOB,a.TYPE,a.INTEGRSET,a.ATTACH,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.AGENT,a.NOTES,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2,a.DOCMNT,a.BARINVOICE)FROM "+schemaName+".CUINVOICE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".SHIPMENT_c b SET(SID,SHIPCODE,MATCODE,SHIPPER,PONO,CPONO,INVOICE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,CARRIER,TYPE,SHIPDATET,SHIPDATETA,TARENO,PACKNO,CUSTOMER,BILLTOCODE,BILLTOSAMEASSHIPTO,SHIPTOCODE,NOTES,STATUSFL,STATUSFLDT,SERIALNO,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,BARSHIPCOD)=(a.SID,a.SHIPCODE,a.MATCODE,a.SHIPPER,a.PONO,a.CPONO,a.INVOICE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.CARRIER,a.TYPE,a.SHIPDATET,a.SHIPDATETA,a.TARENO,a.PACKNO,a.CUSTOMER,a.BILLTOCODE,a.BILLTOSAMEASSHIPTO,a.SHIPTOCODE,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.SERIALNO,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2,a.BARSHIPCOD)FROM "+schemaName+".SHIPMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".EMPLORDERS_c b SET(SID,PURCHSNO,DELVDATET,EMPLOYEE,MATCODE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,JOBNO,VPONO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.EMPLOYEE,a.MATCODE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.JOBNO,a.VPONO,a.RFPORD,a.STATUSFLDT,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.SHIPCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".EMPLORDERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".HLOGFILE_c b SET(SID,SERIALNO,MATCODE,QUANRECD,VENDOR,LOCATION,RECVRPT,INFLG,PHY,DATETIN,DATETOUT,JOBNO,PRINTMSTAT,PRINMTFLDT,PONO,SCANDATET,QUANISSD,BUTT,STATUSFL,QUANREJD,CUSTOMER,CPONO,CUSTOMEJ,ORGCOST,ORGPONO,ORGJOBNO,ALTSERNO,SELPRICE,PHYSQTY,SPERSON,CARTONID,CARTONPR,PACKCODE,TARECODE,SHIPCODE,TYPE,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.SERIALNO,a.MATCODE,a.QUANRECD,a.VENDOR,a.LOCATION,a.RECVRPT,a.INFLG,a.PHY,a.DATETIN,a.DATETOUT,a.JOBNO,a.PRINTMSTAT,a.PRINMTFLDT,a.PONO,a.SCANDATET,a.QUANISSD,a.BUTT,a.STATUSFL,a.QUANREJD,a.CUSTOMER,a.CPONO,a.CUSTOMEJ,a.ORGCOST,a.ORGPONO,a.ORGJOBNO,a.ALTSERNO,a.SELPRICE,a.PHYSQTY,a.SPERSON,a.CARTONID,a.CARTONPR,a.PACKCODE,a.TARECODE,a.SHIPCODE,a.TYPE,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".HLOGFILE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CPAYMENT_c b SET(SID,PAYMENT,CUSTOMER,CINVOICE,CHEQDATE,PAYMENTDUEDATE,POSTINGPERIOD,MATCODE,INTEGRSET,ACCOUNT,AMOUNTTOTAL,AMOUNTOSTNDT,AMOUNTIN,QTYTOTAL,QTYOSTNDT,DISCOUNT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,PAYTYPE,PAYBYID,PAYBYDATE,CURRENCY,CONVRATE,LOCAMOUNTT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PAYMENT,a.CUSTOMER,a.CINVOICE,a.CHEQDATE,a.PAYMENTDUEDATE,a.POSTINGPERIOD,a.MATCODE,a.INTEGRSET,a.ACCOUNT,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.AMOUNTIN,a.QTYTOTAL,a.QTYOSTNDT,a.DISCOUNT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.PAYTYPE,a.PAYBYID,a.PAYBYDATE,a.CURRENCY,a.CONVRATE,a.LOCAMOUNTT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".CPAYMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".MACHINE_c b SET(SID,MACHINECODE,QUANTITY,DESCRIPT,DATEADDED,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,BARUPC)=(a.SID,a.MACHINECODE,a.QUANTITY,a.DESCRIPT,a.DATEADDED,a.SOURCE1,a.SOURCE2,a.UPCCODE,a.COST,a.REPLCOST,a.SELPRICE,a.SPRICOLD,a.SPRICNEW,a.SPRICEFFDT,a.SHIPCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.MISCCODE1,a.MISCCODE2,a.QTYLEVEL1,a.UNIT,a.CASEQTY,a.TYPE,a.TAX1,a.TAX2,a.TAX3,a.ALIASCODE,a.PARENTCODE,a.AVGPRICE,a.AVGCOST,a.STATUSFL,a.STATUSFLDT,a.SUBCODESN,a.SUBCODESN2,a.SUBCODESN3,a.CUORDQTY,a.VENORQTY,a.CUPICQTY,a.VENPIQTY,a.CUINVQTY,a.CUSHIQTY,a.VENSHQTY,a.EFFDATE,a.INTEGRSET,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.BARUPC)FROM "+schemaName+".MACHINE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".GROUPMEMBERS_c b SET(SID,GROUPID,MEMBERID,DESCRIPT,SOURCETYPE,MEMBEREM,MEMBERCU,MEMBERVE,MEMBERIT,MEMBERAC,MEMBERMA,TYPE,CURRPW,EXPIRY,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.GROUPID,a.MEMBERID,a.DESCRIPT,a.SOURCETYPE,a.MEMBEREM,a.MEMBERCU,a.MEMBERVE,a.MEMBERIT,a.MEMBERAC,a.MEMBERMA,a.TYPE,a.CURRPW,a.EXPIRY,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".GROUPMEMBERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ITEMBOM_c b SET(SID,BOMCODE,DESCRIPT,QUANTITY,MODE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.BOMCODE,a.DESCRIPT,a.QUANTITY,a.MODE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ITEMBOM a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".ITEMBOMDETAILS_c b SET(SID,BOMCODE,MATCODE,MODE,SUBQTY,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.BOMCODE,a.MATCODE,a.MODE,a.SUBQTY,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ITEMBOMDETAILS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".TASK_c b SET(SID,TASKID,DESCRIPT,ACTIVITYCODE,PROJECTTEAM,RESOURCE,MODE,ESTSTART,CALCSTART,ACTLSTART,ESTEND,CALCEND,ACTLEND,SUBQTY,BOMCODE,LOCATION,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.TASKID,a.DESCRIPT,a.ACTIVITYCODE,a.PROJECTTEAM,a.RESOURCE,a.MODE,a.ESTSTART,a.CALCSTART,a.ACTLSTART,a.ESTEND,a.CALCEND,a.ACTLEND,a.SUBQTY,a.BOMCODE,a.LOCATION,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".TASK a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VINVOICE_c b SET(SID,INVOICE,VENDOR,MATCODE,INTEGRSET,INVODATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,PONO,REF1TYP,REF1CODE,SHIPDATET,SHIPTYPE,SHIPCODE,TERMS,STATUSFL,STATUSFLDT,TERMSDAT,DISCOUNP,DISCOUDT,DISCOUDS,NETDDAT,NETDDYS,FOB,TYPE,ATTACH,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,AGENT,NOTES,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,DOCMNT)=(a.SID,a.INVOICE,a.VENDOR,a.MATCODE,a.INTEGRSET,a.INVODATE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.PONO,a.REF1TYP,a.REF1CODE,a.SHIPDATET,a.SHIPTYPE,a.SHIPCODE,a.TERMS,a.STATUSFL,a.STATUSFLDT,a.TERMSDAT,a.DISCOUNP,a.DISCOUDT,a.DISCOUDS,a.NETDDAT,a.NETDDYS,a.FOB,a.TYPE,a.ATTACH,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.AGENT,a.NOTES,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VINVOICE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".VPAYMENT_c b SET(SID,PAYMENT,VENDOR,VINVOICE,CHEQDATE,PAYMENTDUEDATE,POSTINGPERIOD,MATCODE,INTEGRSET,ACCOUNT,AMOUNTTOTAL,AMOUNTOSTNDT,AMOUNTIN,QTYTOTAL,QTYOSTNDT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,DISCOUNT,PAYTYPE,PAYBYID,PAYBYDATE,CURRENCY,CONVRATE,LOCAMOUNT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PAYMENT,a.VENDOR,a.VINVOICE,a.CHEQDATE,a.PAYMENTDUEDATE,a.POSTINGPERIOD,a.MATCODE,a.INTEGRSET,a.ACCOUNT,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.AMOUNTIN,a.QTYTOTAL,a.QTYOSTNDT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.DISCOUNT,a.PAYTYPE,a.PAYBYID,a.PAYBYDATE,a.CURRENCY,a.CONVRATE,a.LOCAMOUNT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".VPAYMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".WAGEEARNERAUX_c b SET(SID,WAGEEARNERID,LINE,SIN,WCBYTDL,WCBYTDN,INSYTDL,INSYTDN,VACATONYL,VACATONYN,PAYYTDL,FPENSIYTL,PPENSIYTL,ITAXYTDL,PTAXYTDL,PAYYTDN,FPENSIYTN,PPENSIYTN,ITAXYTDN,PATXYTDN,GPAYYTDL,GPAYYTDN,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.WAGEEARNERID,a.LINE,a.SIN,a.WCBYTDL,a.WCBYTDN,a.INSYTDL,a.INSYTDN,a.VACATONYL,a.VACATONYN,a.PAYYTDL,a.FPENSIYTL,a.PPENSIYTL,a.ITAXYTDL,a.PTAXYTDL,a.PAYYTDN,a.FPENSIYTN,a.PPENSIYTN,a.ITAXYTDN,a.PATXYTDN,a.GPAYYTDL,a.GPAYYTDN,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".WAGEEARNERAUX a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".Rgenapp_c b SET(SID,APPNAME,DESCRIPT,APPTYPE,APPWACCOUNTING,APPWEMAIL,APPWJMSMQ,APPVENDOR,APPVERSION,APPPLATFORM,APPMODELPKG,APPACTIONPKG,APPSKIN,APPDEPLOYTYPE,CREATEFIDATA,REVENGDATA,INITIALIZEFIDATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.APPNAME,a.DESCRIPT,a.APPTYPE,a.APPWACCOUNTING,a.APPWEMAIL,a.APPWJMSMQ,a.APPVENDOR,a.APPVERSION,a.APPPLATFORM,a.APPMODELPKG,a.APPACTIONPKG,a.APPSKIN,a.APPDEPLOYTYPE,a.CREATEFIDATA,a.REVENGDATA,a.INITIALIZEFIDATA,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".Rgenapp a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RGENDB_c b SET(SID,DBNAME,DESCRIPT,DBTYPE,DBVENDOR,DBVERSION,DBPLATFORM,APPCODE,SQLDRIVER,SQLURL,SQLUSER,SQLPASSWORD,SQLCLASSPATH,SQLCREATEDBSCRIPT,SQLDROPDBSCRIPT,SQLCREATETBLSSCRIPT,SQLLOADTBLSSCRIPT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.DBNAME,a.DESCRIPT,a.DBTYPE,a.DBVENDOR,a.DBVERSION,a.DBPLATFORM,a.APPCODE,a.SQLDRIVER,a.SQLURL,a.SQLUSER,a.SQLPASSWORD,a.SQLCLASSPATH,a.SQLCREATEDBSCRIPT,a.SQLDROPDBSCRIPT,a.SQLCREATETBLSSCRIPT,a.SQLLOADTBLSSCRIPT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RGENDB a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RGENTABLE_c b SET(SID,TABLENAME,DBCODE,INADDMENU,INLISTMENU,INTRANSACTIONMENU,INREPORTMENU,INGRAPHSMENU,INMAILINGMENU,INGENERATEMENU,INADMINMENU,INMAINTENANCEMENU,INLABELSMENU,INSKIPMENU,INCUSTOM1MENU,MENULEVEL,MENUROLE,MENULABELGROUP,SUBMENUSEQUENCE,USAGESCOPE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.TABLENAME,a.DBCODE,a.INADDMENU,a.INLISTMENU,a.INTRANSACTIONMENU,a.INREPORTMENU,a.INGRAPHSMENU,a.INMAILINGMENU,a.INGENERATEMENU,a.INADMINMENU,a.INMAINTENANCEMENU,a.INLABELSMENU,a.INSKIPMENU,a.INCUSTOM1MENU,a.MENULEVEL,a.MENUROLE,a.MENULABELGROUP,a.SUBMENUSEQUENCE,a.USAGESCOPE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RGENTABLE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT));UPDATE "+schemaName+".RGENFIELDS_c b SET(SID,DBCODE,TABLENAME,FIELDNAME,FIELDTYPE,FIELDLENGTH,INGROUP,SEQWITHINGROUP,FOCUSSEQ,FUTURE1,INITIALVALUE,KEYORADDITIONAL,KEYORADDITIONAL2,KEYORADDITIONAL3,SHOWINMENU,SHOWINREPORT,PROCESSOPTION1,PROCESSOPTION2,FDBCODE,FTABLENAME,FFIELDKEYNAME1,FFIELDKEYNAME2,FFIELDKEYNAME3,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.DBCODE,a.TABLENAME,a.FIELDNAME,a.FIELDTYPE,a.FIELDLENGTH,a.INGROUP,a.SEQWITHINGROUP,a.FOCUSSEQ,a.FUTURE1,a.INITIALVALUE,a.KEYORADDITIONAL,a.KEYORADDITIONAL2,a.KEYORADDITIONAL3,a.SHOWINMENU,a.SHOWINREPORT,a.PROCESSOPTION1,a.PROCESSOPTION2,a.FDBCODE,a.FTABLENAME,a.FFIELDKEYNAME1,a.FFIELDKEYNAME2,a.FFIELDKEYNAME3,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RGENFIELDS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".GENOPTIONS_c b SET(SID,ROW,GENOPTIONS01,GENPURPOSE01,GENVALUE01,GENOPTIONS02,GENPURPOSE02,GENVALUE02,GENOPTIONS03,GENPURPOSE03,GENVALUE03,GENOPTIONS04,GENPURPOSE04,GENVALUE04,GENOPTIONS05,GENPURPOSE05,GENVALUE05,GENOPTIONS06,GENPURPOSE06,GENVALUE06,GENOPTIONS07,GENPURPOSE07,GENVALUE07,GENOPTIONS08,GENPURPOSE08,GENVALUE08,GENOPTIONS09,GENPURPOSE09,GENVALUE09,GENOPTIONS10,GENPURPOSE10,GENVALUE10,GENOPTIONS11,GENPURPOSE11,GENVALUE11,GENOPTIONS12,GENPURPOSE12,GENVALUE12,GENOPTIONS13,GENPURPOSE13,GENVALUE13,GENOPTIONS14,GENPURPOSE14,GENVALUE14,GENOPTIONS15,GENPURPOSE15,GENVALUE15,GENOPTIONS16,GENPURPOSE16,GENVALUE16,GENOPTIONS17,GENPURPOSE17,GENVALUE17,GENOPTIONS18,GENPURPOSE18,GENVALUE18,GENOPTIONS19,GENPURPOSE19,GENVALUE19,GENOPTIONS20,GENPURPOSE20,GENVALUE20,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.ROW,a.GENOPTIONS01,a.GENPURPOSE01,a.GENVALUE01,a.GENOPTIONS02,a.GENPURPOSE02,a.GENVALUE02,a.GENOPTIONS03,a.GENPURPOSE03,a.GENVALUE03,a.GENOPTIONS04,a.GENPURPOSE04,a.GENVALUE04,a.GENOPTIONS05,a.GENPURPOSE05,a.GENVALUE05,a.GENOPTIONS06,a.GENPURPOSE06,a.GENVALUE06,a.GENOPTIONS07,a.GENPURPOSE07,a.GENVALUE07,a.GENOPTIONS08,a.GENPURPOSE08,a.GENVALUE08,a.GENOPTIONS09,a.GENPURPOSE09,a.GENVALUE09,a.GENOPTIONS10,a.GENPURPOSE10,a.GENVALUE10,a.GENOPTIONS11,a.GENPURPOSE11,a.GENVALUE11,a.GENOPTIONS12,a.GENPURPOSE12,a.GENVALUE12,a.GENOPTIONS13,a.GENPURPOSE13,a.GENVALUE13,a.GENOPTIONS14,a.GENPURPOSE14,a.GENVALUE14,a.GENOPTIONS15,a.GENPURPOSE15,a.GENVALUE15,a.GENOPTIONS16,a.GENPURPOSE16,a.GENVALUE16,a.GENOPTIONS17,a.GENPURPOSE17,a.GENVALUE17,a.GENOPTIONS18,a.GENPURPOSE18,a.GENVALUE18,a.GENOPTIONS19,a.GENPURPOSE19,a.GENVALUE19,a.GENOPTIONS20,a.GENPURPOSE20,a.GENVALUE20,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".GENOPTIONS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".BLOBDATA_c b SET(SID,FROMTABLE,FROMKEY,QUALIFIER,SEQUENCE,TYPE,DATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.FROMTABLE,a.FROMKEY,a.QUALIFIER,a.SEQUENCE,a.TYPE,a.DATA,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".BLOBDATA a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CLOBDATA_c b SET(SID,FROMTABLE,FROMKEY,QUALIFIER,SEQUENCE,TYPE,DATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.FROMTABLE,a.FROMKEY,a.QUALIFIER,a.SEQUENCE,a.TYPE,a.DATA,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".CLOBDATA a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CONTROLUSAGEBYPERIODS_c b SET(SID,CTLUSAGETRACKERID,DESCRIPT,CONTROLCODE,CURRENCY,PERIOD0LABEL,PERIOD0B,PERIOD0,PERIODTOTALSLABEL,PERIODTOTALSB,PERIODTOTALS,PERIOD1LABEL,PERIOD1BUDGET,PERIOD1ACTUAL,PERIOD2LABEL,PERIOD2B,PERIOD2,PERIOD3LABEL,PERIOD3B,PERIOD3,PERIOD4LABEL,PERIOD4B,PERIOD4,PERIOD5LABEL,PERIOD5B,PERIOD5,PERIOD6LABEL,PERIOD6B,PERIOD6,PERIOD7LABEL,PERIOD7B,PERIOD7,PERIOD8LABEL,PERIOD8B,PERIOD8,PERIOD9LABEL,PERIOD9B,PERIOD9,PERIOD10LABEL,PERIOD10B,PERIOD10,PERIOD11LABEL,PERIOD11B,PERIOD11,PERIOD12LABEL,PERIOD12B,PERIOD12,PERIODNLABEL,PERIODNB,PERIODN,NOTES,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.CTLUSAGETRACKERID,a.DESCRIPT,a.CONTROLCODE,a.CURRENCY,a.PERIOD0LABEL,a.PERIOD0B,a.PERIOD0,a.PERIODTOTALSLABEL,a.PERIODTOTALSB,a.PERIODTOTALS,a.PERIOD1LABEL,a.PERIOD1BUDGET,a.PERIOD1ACTUAL,a.PERIOD2LABEL,a.PERIOD2B,a.PERIOD2,a.PERIOD3LABEL,a.PERIOD3B,a.PERIOD3,a.PERIOD4LABEL,a.PERIOD4B,a.PERIOD4,a.PERIOD5LABEL,a.PERIOD5B,a.PERIOD5,a.PERIOD6LABEL,a.PERIOD6B,a.PERIOD6,a.PERIOD7LABEL,a.PERIOD7B,a.PERIOD7,a.PERIOD8LABEL,a.PERIOD8B,a.PERIOD8,a.PERIOD9LABEL,a.PERIOD9B,a.PERIOD9,a.PERIOD10LABEL,a.PERIOD10B,a.PERIOD10,a.PERIOD11LABEL,a.PERIOD11B,a.PERIOD11,a.PERIOD12LABEL,a.PERIOD12B,a.PERIOD12,a.PERIODNLABEL,a.PERIODNB,a.PERIODN,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".CONTROLUSAGEBYPERIODS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RESOURCE_BUNDLE_c b SET(SID,NAME,LANGUAGE,COUNTRY,VARIANT,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.NAME,a.LANGUAGE,a.COUNTRY,a.VARIANT,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".RESOURCE_BUNDLE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".RESOURCE_c b SET(SID,_KEY,_VALUE,RESOURCEBUNDLE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a._KEY,a._VALUE,a.RESOURCEBUNDLE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".RESOURCE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".TRUEFALSE_c b SET(SID,TABLENAME,QUALIFIER,SHOW001,SHOW002,SHOW003,SHOW004,SHOW005,SHOW006,SHOW007,SHOW008,SHOW009,SHOW010,SHOW011,SHOW012,SHOW013,SHOW014,SHOW015,SHOW016,SHOW017,SHOW018,SHOW019,SHOW020,SHOW021,SHOW022,SHOW023,SHOW024,SHOW025,SHOW026,SHOW027,SHOW028,SHOW029,SHOW030,SHOW031,SHOW032,SHOW033,SHOW034,SHOW035,SHOW036,SHOW037,SHOW038,SHOW039,SHOW040,SHOW041,SHOW042,SHOW043,SHOW044,SHOW045,SHOW046,SHOW047,SHOW048,SHOW049,SHOW050,SHOW051,SHOW052,SHOW053,SHOW054,SHOW055,SHOW056,SHOW057,SHOW058,SHOW059,SHOW060,SHOW061,SHOW062,SHOW063,SHOW064,SHOW065,SHOW066,SHOW067,SHOW068,SHOW069,SHOW070,SHOW071,SHOW072,SHOW073,SHOW074,SHOW075,SHOW076,SHOW077,SHOW078,SHOW079,SHOW080,SHOW081,SHOW082,SHOW083,SHOW084,SHOW085,SHOW086,SHOW087,SHOW088,SHOW089,SHOW090,SHOW091,SHOW092,SHOW093,SHOW094,SHOW095,SHOW096,SHOW097,SHOW098,SHOW099,SHOW100,SHOW101,SHOW102,SHOW103,SHOW104,SHOW105,SHOW106,SHOW107,SHOW108,SHOW109,SHOW110,SHOW111,SHOW112,SHOW113,SHOW114,SHOW115,SHOW116,SHOW117,SHOW118,SHOW119,SHOW120,SHOW121,SHOW122,SHOW123,SHOW124,SHOW125,SHOW126,SHOW127,SHOW128,SHOW129,SHOW130,SHOW131,SHOW132,SHOW133,SHOW134,SHOW135,SHOW136,SHOW137,SHOW138,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.TABLENAME,a.QUALIFIER,a.SHOW001,a.SHOW002,a.SHOW003,a.SHOW004,a.SHOW005,a.SHOW006,a.SHOW007,a.SHOW008,a.SHOW009,a.SHOW010,a.SHOW011,a.SHOW012,a.SHOW013,a.SHOW014,a.SHOW015,a.SHOW016,a.SHOW017,a.SHOW018,a.SHOW019,a.SHOW020,a.SHOW021,a.SHOW022,a.SHOW023,a.SHOW024,a.SHOW025,a.SHOW026,a.SHOW027,a.SHOW028,a.SHOW029,a.SHOW030,a.SHOW031,a.SHOW032,a.SHOW033,a.SHOW034,a.SHOW035,a.SHOW036,a.SHOW037,a.SHOW038,a.SHOW039,a.SHOW040,a.SHOW041,a.SHOW042,a.SHOW043,a.SHOW044,a.SHOW045,a.SHOW046,a.SHOW047,a.SHOW048,a.SHOW049,a.SHOW050,a.SHOW051,a.SHOW052,a.SHOW053,a.SHOW054,a.SHOW055,a.SHOW056,a.SHOW057,a.SHOW058,a.SHOW059,a.SHOW060,a.SHOW061,a.SHOW062,a.SHOW063,a.SHOW064,a.SHOW065,a.SHOW066,a.SHOW067,a.SHOW068,a.SHOW069,a.SHOW070,a.SHOW071,a.SHOW072,a.SHOW073,a.SHOW074,a.SHOW075,a.SHOW076,a.SHOW077,a.SHOW078,a.SHOW079,a.SHOW080,a.SHOW081,a.SHOW082,a.SHOW083,a.SHOW084,a.SHOW085,a.SHOW086,a.SHOW087,a.SHOW088,a.SHOW089,a.SHOW090,a.SHOW091,a.SHOW092,a.SHOW093,a.SHOW094,a.SHOW095,a.SHOW096,a.SHOW097,a.SHOW098,a.SHOW099,a.SHOW100,a.SHOW101,a.SHOW102,a.SHOW103,a.SHOW104,a.SHOW105,a.SHOW106,a.SHOW107,a.SHOW108,a.SHOW109,a.SHOW110,a.SHOW111,a.SHOW112,a.SHOW113,a.SHOW114,a.SHOW115,a.SHOW116,a.SHOW117,a.SHOW118,a.SHOW119,a.SHOW120,a.SHOW121,a.SHOW122,a.SHOW123,a.SHOW124,a.SHOW125,a.SHOW126,a.SHOW127,a.SHOW128,a.SHOW129,a.SHOW130,a.SHOW131,a.SHOW132,a.SHOW133,a.SHOW134,a.SHOW135,a.SHOW136,a.SHOW137,a.SHOW138,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".TRUEFALSE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".RATE1F_c b SET(SID,USERTYPE,PRODTYPE,STEPNAME,STEP,VALUE,EFFDATE,ENDDATE,INCENTIVE,IEFFDATE,IENDDATE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.USERTYPE,a.PRODTYPE,a.STEPNAME,a.STEP,a.VALUE,a.EFFDATE,a.ENDDATE,a.INCENTIVE,a.IEFFDATE,a.IENDDATE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".RATE1F a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT))";
q=entityManager.createNativeQuery(sqlScript);
updatedCount=updatedCount+q.executeUpdate();
*/
sqlScript="backUp scripts done,next show counters and then update mastersite client record 02";

     //no facesContext if from TaskAgent
      if (facesContext !=null){
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
         FacesMessage.SEVERITY_INFO,bundle.getString("backup")+" "+bundle.getString("All_sites")+", "+bundle.getString("removed")+": "+deletedCount+" "+ bundle.getString("updated")+": "+updatedCount+" "+bundle.getString("inserted")+": "+insertedCount,""));
      }


    //  update client record 01 field shicsize to show last backupdate as a varchar  update raaspi client
    // enhance logic to use _s rather than -c ??? why
     sqlScript="update "+schemaName+".client set shicsize=:backupdts where owner2=:owner2Code and clientversion=:clientversion";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2Code", masterSiteCode).setParameter("clientversion", "01").setParameter("backupdts", sdf.format(calendar.getTime()));
      q.executeUpdate();


} catch (Exception e) {
     int len=sqlScript.length();
     len=len>120?120:len;
     log.info("system backup error in  "+ sqlScript.substring(0,len)+"," + e.getMessage());

}

	 return "backUp tenants done on _c tables";
}





	public String  restoreTenantC() {

     String sqlScript ="";
     int deletedCount=0;
     int updatedCount=0;
     int insertedCount=0;
try{
     //restore from system backup
     // 1-remove rows from main if not in backup ie any new rows in main will be removed
     // 2-insert into main if old rows in backUp
     // 3-update main if row in backup has different change time  (relies on statusfldate change)
      // follow the deletion order list produced by schemaspygui C:\schemaspygui\postgres_postgre_\deletionOrder.txt ( future use the list as input to automate )
      // insertionOrder.txt for insert, for update order does not matter because we are not dropping or adding any relation but will follow
      // insertionOrder.txt

     // remove rows from main if not in backup ie any new rows in main will be removed
      // resource_bundle,resource,clob and blob have SYSTEM records which need extra logic
      // SYSTEM records should not be deleted from main or backup table but should be copied into backup if needed ?? revisit
      // give warning before restore that any new users/passwords since last back up will be lost. We cannot exclude user table
      // because other tables are related to user
      // jay add logic to exit if backup count is below ? for resource, clobdata , client etc
      // prevent running after truncate
      //use DatabaseMetaData, as in authenticator.java, to avoid harcoding here
      //using jdbc connection to get database metadata rather than entitymanager way to be ORM neutral
      DatabaseMetaData databaseMetaData=null;
      String productName="";
      String dbProductName="hsql";
      try(Connection conn = getConnection();){
       databaseMetaData = conn.getMetaData();
       productName = databaseMetaData.getDatabaseProductName();
      } catch (Exception e) {
       log.severe("No datasouce connection or databaseMetaData, Cannot continue");
       return null;
      }
      if(productName==null || productName.isEmpty()){
       log.severe("No datasouce setup yet, check tomee.xml or standalone.xml etc. Cannot continue");
       return null;
      }
      if(productName.contains("PostgreSQL")){
       dbProductName="psql";
      }
      if(schemaName == null || schemaName.isEmpty()){
       schemaName="genapp";
      }
     sqlScript="select count(*) from "+schemaName+".client_c a where  a.owner2=:owner2 ";
     Query q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
((BigInteger) q.getSingleResult()).intValue();
     deletedCount = deletedCount +((BigInteger) q.getSingleResult()).intValue();

     sqlScript="select count(*) from "+schemaName+".blobdata_c a where  a.owner2=:owner2 ";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +((BigInteger) q.getSingleResult()).intValue();

     if(deletedCount == 0){
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+bundle.getString("backup")+" "+bundle.getString("empty"),""));
      return "";
     }
     deletedCount=0;

     sqlScript="delete from "+schemaName+".serialnumbers a where  a.owner2=:owner2  and  not exists  (select a.sid from "+schemaName+".serialnumbers_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".scandate a where  a.owner2=:owner2  and  not exists  (select a.sid from "+schemaName+".scandate_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rate1f a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rate1f_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".options a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".options_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".nextserialno a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".nextserialno_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".journal a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".journal_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".jjournal a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".jjournal_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".hlogfile a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".hlogfile_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".genoptions a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".genoptions_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".editlog a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".editlog_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".clobdata a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".clobdata_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     //if(owner2Code.equals("raaspi")){
     if(customIdentity.isMasterSite()){
      sqlScript="delete from "+schemaName+".clobdata a where  a.owner2='SYSTEM'  and  not exists  (select sid from "+schemaName+".clobdata_c b where a.sid = b.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      deletedCount = deletedCount +q.executeUpdate();
     }
     sqlScript="delete from "+schemaName+".cjournal a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cjournal_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".blobdata a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".blobdata_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     //if(owner2Code.equals("raaspi")){
     if(customIdentity.isMasterSite()){
      sqlScript="delete from "+schemaName+".blobdata a where  a.owner2='SYSTEM'  and  not exists  (select sid from "+schemaName+".blobdata_c b where a.sid = b.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      deletedCount = deletedCount +q.executeUpdate();
     }
     sqlScript="delete from "+schemaName+".arthatbl a where  a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".arthatbl_c b where a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".arthahist a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".arthahist_c b where  a.sid = b.sid and b.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".acperiod a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".acperiod_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".jobassignment a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".jobassignment_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".schedule a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".schedule_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vshipmendetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vshipmendetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vcontact a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vcontact_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".shipmentdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".shipmentdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".ccontact a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".ccontact_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendqdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendqdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendpdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendpdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendodetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendodetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendidetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendidetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".resourcedetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resourcedetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".emplodetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".emplodetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuqdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuqdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuodetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuodetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuidetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuidetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".usagebyperiods a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".usagebyperiods_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgenfields a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgenfields_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".itembomdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".itembomdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".holiday a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".holiday_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".gentriesdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".gentriesdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cupdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cupdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activityjobdetails a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".activityjobdetails_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".wageearneraux a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".wageearneraux_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".venartha a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".venartha_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".userprofl a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".userprofl_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".resource a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resource_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     //if(owner2Code.equals("raaspi")){
     if(customIdentity.isMasterSite()){
      sqlScript="delete from "+schemaName+".resource a where   a.owner2='SYSTEM'  and  not exists  (select sid from "+schemaName+".resource_c b where  a.sid = b.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      deletedCount = deletedCount +q.executeUpdate();
     }

     sqlScript="delete from "+schemaName+".controlusagebyperiods a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".controlusagebyperiods_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".acintegr a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".acintegr_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".\"USER\" a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".\"USER_c\" b where  a.sid = b.sid and b.owner2=:owner2)";
     if(dbProductName.equals("psql")){
      sqlScript="delete from "+schemaName+".\"user\" a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".\"user_c\" b where  a.sid = b.sid and b.owner2=:owner2)";
     }

      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".emplorders a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".emplorders_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vpayment a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vpayment_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".task a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".task_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cpayment a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cpayment_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".glentries a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".glentries_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".controlusagebyperiods a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".controlusagebyperiods_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activityjob a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".activityjob_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".wageearner a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".wageearner_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgentable a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgentable_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".itemjob a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".itemjob_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vshipmen a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vshipmen_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".groupmembers a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".groupmembers_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vinvoice a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vinvoice_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".shipment a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".shipment_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendorders a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendorders_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuinvoice a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuinvoice_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuorders a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuorders_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".project a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".project_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".outline a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".outline_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".venquote a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".venquote_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuquote a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuquote_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".machine a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".machine_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activity a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".activity_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".item a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".item_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".employee a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".employee_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".customer a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".customer_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendor a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendor_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".location a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".location_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".account a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".account_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgendb a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgendb_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".company a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".company_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".rollupgroup a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rollupgroup_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".rgenapp a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgenapp_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".resource_bundle a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resource_bundle_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     if(customIdentity.isMasterSite()){
     sqlScript="delete from "+schemaName+".resource_bundle a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resource_bundle_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", "SYSTEM");
     deletedCount = deletedCount +q.executeUpdate();
     }

     sqlScript="delete from "+schemaName+".perioddates a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".perioddates_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".itembom a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".itembom_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".control a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".control_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".client a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".client_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".residency a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".residency_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".membersgroup a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".membersgroup_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".division a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".division_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".department a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".department_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".address a where   a.owner2=:owner2  and  not exists  (select sid from "+schemaName+".address_c b where  a.sid = b.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();




     // insert into main if old rows in backUp

      sqlScript="insert into "+schemaName+".address select * from "+schemaName+".address_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".address  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".department select * from "+schemaName+".department_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".department  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".division select * from "+schemaName+".division_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".division  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".membersgroup select * from "+schemaName+".membersgroup_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".membersgroup  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".residency select * from "+schemaName+".residency_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".residency  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".client select * from "+schemaName+".client_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".client  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".control select * from "+schemaName+".control_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".control  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itembom select * from "+schemaName+".itembom_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".itembom  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".perioddates select * from "+schemaName+".perioddates_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".perioddates  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_bundle select * from "+schemaName+".resource_bundle_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".resource_bundle  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".resource_bundle select * from "+schemaName+".resource_bundle_c b where  b.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".resource_bundle  a where b.sid = a.sid and a.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".rgenapp select * from "+schemaName+".rgenapp_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgenapp  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rollupgroup select * from "+schemaName+".rollupgroup_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".rollupgroup  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".company select * from "+schemaName+".company_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".company  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rgendb select * from "+schemaName+".rgendb_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgendb  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".account select * from "+schemaName+".account_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".account  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".location select * from "+schemaName+".location_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".location  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vendor select * from "+schemaName+".vendor_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendor  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".customer select * from "+schemaName+".customer_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".customer  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".employee select * from "+schemaName+".employee_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".employee  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".item select * from "+schemaName+".item_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".item  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".activity select * from "+schemaName+".activity_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".activity  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".machine select * from "+schemaName+".machine_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".machine  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuquote select * from "+schemaName+".cuquote_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuquote  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".venquote select * from "+schemaName+".venquote_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".venquote  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".outline select * from "+schemaName+".outline_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".outline  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".project select * from "+schemaName+".project_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".project  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuorders select * from "+schemaName+".cuorders_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuorders  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuinvoice select * from "+schemaName+".cuinvoice_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuinvoice  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vendorders select * from "+schemaName+".vendorders_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendorders  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".shipment select * from "+schemaName+".shipment_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".shipment  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vinvoice select * from "+schemaName+".vinvoice_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vinvoice  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".groupmembers select * from "+schemaName+".groupmembers_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".groupmembers  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vshipmen select * from "+schemaName+".vshipmen_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vshipmen  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itemjob select * from "+schemaName+".itemjob_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".itemjob  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".rgentable select * from "+schemaName+".rgentable_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgentable  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".wageearner select * from "+schemaName+".wageearner_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".wageearner  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".activityjob select * from "+schemaName+".activityjob_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".activityjob  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".glentries select * from "+schemaName+".glentries_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".glentries  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cpayment select * from "+schemaName+".cpayment_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cpayment  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".task select * from "+schemaName+".task_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".task  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vpayment select * from "+schemaName+".vpayment_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vpayment  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".emplorders select * from "+schemaName+".emplorders_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".emplorders  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

     sqlScript="insert into "+schemaName+".\"USER\" select * from "+schemaName+".\"USER_c\" b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".\"USER\" a where b.sid = a.sid and a.owner2=:owner2)";
     if(dbProductName.equals("psql")){
      sqlScript="insert into "+schemaName+".\"user\" select * from "+schemaName+".\"user_c\" b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".\"user\" a where b.sid = a.sid and a.owner2=:owner2)";
     }

      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".acintegr select * from "+schemaName+".acintegr_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".acintegr  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".controlusagebyperiods select * from "+schemaName+".controlusagebyperiods_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".controlusagebyperiods  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource select * from "+schemaName+".resource_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".resource  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".resource select * from "+schemaName+".resource_c b where  b.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".resource  a where b.sid = a.sid and a.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".userprofl select * from "+schemaName+".userprofl_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".userprofl  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".venartha select * from "+schemaName+".venartha_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".venartha  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".wageearneraux select * from "+schemaName+".wageearneraux_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".wageearneraux  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".activityjobdetails select * from "+schemaName+".activityjobdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".activityjobdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cupdetails select * from "+schemaName+".cupdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cupdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".gentriesdetails select * from "+schemaName+".gentriesdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".gentriesdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".holiday select * from "+schemaName+".holiday_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".holiday  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itembomdetails select * from "+schemaName+".itembomdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".itembomdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();



      sqlScript="insert into "+schemaName+".rgenfields select * from "+schemaName+".rgenfields_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgenfields  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".usagebyperiods select * from "+schemaName+".usagebyperiods_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".usagebyperiods  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuidetails select * from "+schemaName+".cuidetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuidetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuodetails select * from "+schemaName+".cuodetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuodetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuqdetails select * from "+schemaName+".cuqdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuqdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".emplodetails select * from "+schemaName+".emplodetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".emplodetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".resourcedetails select * from "+schemaName+".resourcedetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".resourcedetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendidetails select * from "+schemaName+".vendidetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendidetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendodetails select * from "+schemaName+".vendodetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendodetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendpdetails select * from "+schemaName+".vendpdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendpdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendqdetails select * from "+schemaName+".vendqdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendqdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".ccontact select * from "+schemaName+".ccontact_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".ccontact  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".shipmentdetails select * from "+schemaName+".shipmentdetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".shipmentdetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vcontact select * from "+schemaName+".vcontact_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vcontact  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vshipmendetails select * from "+schemaName+".vshipmendetails_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".vshipmendetails  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".schedule select * from "+schemaName+".schedule_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".schedule  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".jobassignment select * from "+schemaName+".jobassignment_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".jobassignment  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".acperiod select * from "+schemaName+".acperiod_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".acperiod  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".arthahist select * from "+schemaName+".arthahist_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".arthahist  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".arthatbl select * from "+schemaName+".arthatbl_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".arthatbl  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".holiday select * from "+schemaName+".holiday_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".holiday  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".blobdata select * from "+schemaName+".blobdata_c b where  b.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".blobdata  a where b.sid = a.sid and a.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".blobdata select * from "+schemaName+".blobdata_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".blobdata  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cjournal select * from "+schemaName+".cjournal_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".cjournal  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".clobdata select * from "+schemaName+".clobdata_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".clobdata  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".clobdata select * from "+schemaName+".clobdata_c b where  b.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".clobdata  a where b.sid = a.sid and a.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".editlog select * from "+schemaName+".editlog_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".editlog  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".genoptions select * from "+schemaName+".genoptions_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".genoptions  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".hlogfile select * from "+schemaName+".hlogfile_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".hlogfile  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".jjournal select * from "+schemaName+".jjournal_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".jjournal  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".journal select * from "+schemaName+".journal_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".journal  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".nextserialno select * from "+schemaName+".nextserialno_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".nextserialno  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".options select * from "+schemaName+".options_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".options  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".rate1f select * from "+schemaName+".rate1f_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".rate1f  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".scandate select * from "+schemaName+".scandate_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".scandate  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".serialnumbers select * from "+schemaName+".serialnumbers_c b where  b.owner2=:owner2  and  not exists (select sid from "+schemaName+".serialnumbers  a where b.sid = a.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();





      // update main if row in backup has different change time (relies on statusfldate change)
      // use postingdate instead of statusdt
      // journals,glentries,details do not get updated so are not included in updates jay add logic to prevent updating glentries ??
      // , they are included now, can get updated by repair
//postgresql UPDATE genapp.journal_b SET sid=a.sid,spostdate=a.spostdate,postdate=a.postdate,owner2=a.owner2 FROM  genapp.journal a  where(genapp.journal_b.sid=a.sid AND a.postdate<>genapp.journal_b.postdate AND a.owner2='localhost')
//hsqldb or stanard UPDATE genapp.journal_b b SET (sid,spostdate,postdate,owner2)=(SELECT sid,spostdate,postdate,owner2 FROM  genapp.journal a where b.sid=a.sid AND a.postdate<>b.postdate AND a.owner2='localhost')
/*
sqlScript="UPDATE "+schemaName+".journal_b b SET(sid,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,statusfl,owner,owner2)=(SELECT sid,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,statusfl,owner,owner2 FROM "+schemaName+".journal a where a.sid=b.sid AND a.postdate<>b.postdate and a.owner2=:owner2)";
if(dbProductName.equals("psql")){
 sqlScript="UPDATE "+schemaName+".journal_b SET sid=a.sid,a.spostdate=a.spostdate,postdate=a.postdate,calendardt=a.calendardt,jrnltype=a.jrnltype,jnlseqb=,jnlseq=a.jnlseq,jnlseqs=a.jnlseqs,period=a.period,account=a.account,debit=a.debit,credit=a.credit,xreference=a.xreference,descript=a.descript,statusfl=a.statusfl,owner=a.owner,owner2=a.owner2) FROM "+schemaName+".journal a where(genapp.journal_b.sid=a.sid AND a.postdate<>genapp.journal_b.postdate AND a.owner2=:owner2)";
}
sqlScript="UPDATE "+schemaName+".JOURNAL a SET(SID,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,STATUSFL,OWNER,OWNER2)=(b.SID,b.spostdate,b.postdate,b.calendardt,b.jrnltype,b.jnlseqb,b.jnlseq,b.jnlseqs,b.period,b.account,b.debit,b.credit,b.xreference,b.descript,b.STATUSFL,b.OWNER,b.OWNER2)FROM "+schemaName+".journal_c b where((b.sid=a.sid) AND (a.postdate<>b.postdate) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".gentriesdetails a SET(SID,glentrysidno,line,depcode,divcode,account,debitamt,creditamt,linetotl,notes,STATUSFL,statusfldt,OWNER,OWNER2)=(b.SID,b.glentrysidno,b.line,b.depcode,b.divcode,b.account,b.debitamt,b.creditamt,b.linetotl,b.notes,b.STATUSFL,b.statusfldt,b.OWNER,b.OWNER2)FROM "+schemaName+".gentriesdetails_c b where((b.sid=a.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".glentries a SET(SID,glentryno,descript,refcode,period,postdate,calendardt,depcode,divcode,account,tdebitamt,tcreditamt,notes,STATUSFL,statusfldt,OWNER,OWNER2)=(b.SID,b.glentryno,b.descript,b.refcode,b.period,b.postdate,b.calendardt,b.depcode,b.divcode,b.account,b.tdebitamt,b.tcreditamt,b.notes,b.STATUSFL,b.statusfldt,b.OWNER,b.OWNER2)FROM "+schemaName+".glentries_c b where((b.sid=a.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();


sqlScript="UPDATE "+schemaName+".ADDRESS a SET(SID,ADDRESCODE,ADDRL1,ADDRL2,ADDRL3,CITY,PROVNSTATE,COUNTRY,PZCODE,DESCRIPT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,PRINTMSTAT,PRINMTFLDT)=(b.SID,b.ADDRESCODE,b.ADDRL1,b.ADDRL2,b.ADDRL3,b.CITY,b.PROVNSTATE,b.COUNTRY,b.PZCODE,b.DESCRIPT,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2,b.PRINTMSTAT,b.PRINMTFLDT)FROM "+schemaName+".address_c b where((b.sid=a.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".OPTIONS a SET(SID,ROW,OPTIONS01,PURPOSE01,VALUE01,OPTIONS02,PURPOSE02,VALUE02,OPTIONS03,PURPOSE03,VALUE03,OPTIONS04,PURPOSE04,VALUE04,OPTIONS05,PURPOSE05,VALUE05,OPTIONS06,PURPOSE06,VALUE06,OPTIONS07,PURPOSE07,VALUE07,OPTIONS08,PURPOSE08,VALUE08,OPTIONS09,PURPOSE09,VALUE09,OPTIONS10,PURPOSE10,VALUE10,OPTIONS11,PURPOSE11,VALUE11,OPTIONS12,PURPOSE12,VALUE12,OPTIONS13,PURPOSE13,VALUE13,OPTIONS14,PURPOSE14,VALUE14,OPTIONS15,PURPOSE15,VALUE15,OPTIONS16,PURPOSE16,VALUE16,OPTIONS17,PURPOSE17,VALUE17,OPTIONS18,PURPOSE18,VALUE18,OPTIONS19,PURPOSE19,VALUE19,OPTIONS20,PURPOSE20,VALUE20,OPTIONS21,PURPOSE21,VALUE21,OPTIONS22,PURPOSE22,VALUE22,OPTIONS23,PURPOSE23,VALUE23,OPTIONS24,PURPOSE24,VALUE24,OPTIONS25,PURPOSE25,VALUE25,OPTIONS26,PURPOSE26,VALUE26,OPTIONS27,PURPOSE27,VALUE27,OPTIONS28,PURPOSE28,VALUE28,OPTIONS29,PURPOSE29,VALUE29,OPTIONS30,PURPOSE30,VALUE30,OPTIONS31,PURPOSE31,VALUE31,OPTIONS32,PURPOSE32,VALUE32,OPTIONS33,PURPOSE33,VALUE33,OPTIONS34,PURPOSE34,VALUE34,OPTIONS35,PURPOSE35,VALUE35,OPTIONS36,PURPOSE36,VALUE36,OPTIONS37,PURPOSE37,VALUE37,OPTIONS38,PURPOSE38,VALUE38,OPTIONS39,PURPOSE39,VALUE39,OPTIONS40,PURPOSE40,VALUE40,OPTIONS41,PURPOSE41,VALUE41,OPTIONS42,PURPOSE42,VALUE42,OPTIONS43,PURPOSE43,VALUE43,OPTIONS44,PURPOSE44,VALUE44,OPTIONS45,PURPOSE45,VALUE45,OPTIONS46,PURPOSE46,VALUE46,OPTIONS47,PURPOSE47,VALUE47,OPTIONS48,PURPOSE48,VALUE48,OPTIONS49,PURPOSE49,VALUE49,OPTIONS50,PURPOSE50,VALUE50,OPTIONS51,PURPOSE51,VALUE51,OPTIONS52,PURPOSE52,VALUE52,OPTIONS53,PURPOSE53,VALUE53,OPTIONS54,PURPOSE54,VALUE54,OPTIONS55,PURPOSE55,VALUE55,OPTIONS56,PURPOSE56,VALUE56,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.ROW,b.OPTIONS01,b.PURPOSE01,b.VALUE01,b.OPTIONS02,b.PURPOSE02,b.VALUE02,b.OPTIONS03,b.PURPOSE03,b.VALUE03,b.OPTIONS04,b.PURPOSE04,a.VALUE04,b.OPTIONS05,b.PURPOSE05,b.VALUE05,b.OPTIONS06,b.PURPOSE06,b.VALUE06,b.OPTIONS07,b.PURPOSE07,b.VALUE07,b.OPTIONS08,b.PURPOSE08,b.VALUE08,b.OPTIONS09,b.PURPOSE09,b.VALUE09,b.OPTIONS10,b.PURPOSE10,b.VALUE10,b.OPTIONS11,b.PURPOSE11,b.VALUE11,b.OPTIONS12,b.PURPOSE12,b.VALUE12,b.OPTIONS13,b.PURPOSE13,b.VALUE13,b.OPTIONS14,b.PURPOSE14,b.VALUE14,b.OPTIONS15,b.PURPOSE15,b.VALUE15,b.OPTIONS16,b.PURPOSE16,b.VALUE16,b.OPTIONS17,b.PURPOSE17,b.VALUE17,b.OPTIONS18,b.PURPOSE18,b.VALUE18,b.OPTIONS19,b.PURPOSE19,b.VALUE19,b.OPTIONS20,b.PURPOSE20,b.VALUE20,b.OPTIONS21,b.PURPOSE21,b.VALUE21,b.OPTIONS22,b.PURPOSE22,b.VALUE22,b.OPTIONS23,b.PURPOSE23,b.VALUE23,b.OPTIONS24,b.PURPOSE24,b.VALUE24,b.OPTIONS25,b.PURPOSE25,b.VALUE25,b.OPTIONS26,b.PURPOSE26,b.VALUE26,b.OPTIONS27,b.PURPOSE27,b.VALUE27,b.OPTIONS28,b.PURPOSE28,b.VALUE28,b.OPTIONS29,b.PURPOSE29,b.VALUE29,b.OPTIONS30,b.PURPOSE30,b.VALUE30,b.OPTIONS31,b.PURPOSE31,b.VALUE31,b.OPTIONS32,b.PURPOSE32,b.VALUE32,b.OPTIONS33,b.PURPOSE33,b.VALUE33,b.OPTIONS34,b.PURPOSE34,b.VALUE34,b.OPTIONS35,b.PURPOSE35,b.VALUE35,b.OPTIONS36,b.PURPOSE36,b.VALUE36,b.OPTIONS37,b.PURPOSE37,b.VALUE37,b.OPTIONS38,b.PURPOSE38,b.VALUE38,b.OPTIONS39,b.PURPOSE39,b.VALUE39,b.OPTIONS40,b.PURPOSE40,b.VALUE40,b.OPTIONS41,b.PURPOSE41,b.VALUE41,b.OPTIONS42,b.PURPOSE42,b.VALUE42,b.OPTIONS43,b.PURPOSE43,b.VALUE43,b.OPTIONS44,b.PURPOSE44,b.VALUE44,b.OPTIONS45,b.PURPOSE45,b.VALUE45,b.OPTIONS46,b.PURPOSE46,b.VALUE46,b.OPTIONS47,b.PURPOSE47,b.VALUE47,b.OPTIONS48,b.PURPOSE48,b.VALUE48,b.OPTIONS49,b.PURPOSE49,b.VALUE49,b.OPTIONS50,b.PURPOSE50,b.VALUE50,b.OPTIONS51,b.PURPOSE51,b.VALUE51,b.OPTIONS52,b.PURPOSE52,b.VALUE52,b.OPTIONS53,b.PURPOSE53,b.VALUE53,b.OPTIONS54,b.PURPOSE54,b.VALUE54,b.OPTIONS55,b.PURPOSE55,b.VALUE55,b.OPTIONS56,b.PURPOSE56,b.VALUE56,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".OPTIONS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
String line1="UPDATE "+schemaName+".CLIENT a SET(SID,CLIENTVERSION,SERIALNUM,ENTERPRISECOMPANYNA,DESCRIPT,ADDRL1,ADDRL2,ADDRL3,CITY,PROVNSTATE,COUNTRYNAME,PZCODE,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,ENTERPRISECOMPCODE,ENTERPRISECOMPSIZE,BARCSIZE,LEVEL,POSKIPP,LOOSEIT,JOBSKIP,CARTONFL,PICKLIST,PRODDESC,PRODCODE,NJOB,NMATERIA,NACTIVITY,NBUTT,NCUSTOME,NCONTACT,NVENDOR,NEMPLOYEE,NSCHEDULE,NREJECT,NRETURN,NCODE,MANUFID,BARTYPE,CADTYPE,CARTYPE,SHITYPE,REPTYPE,LOCTYPE,BARCOL,CARCOL,CADCOL,SHICOL,REPCOL,LOCCOL,ALTSERIA,COUNTRYCODE,NALTSERI,SCRCOLOR,HILCOLOR,TEXTCOLOR,BACCOLOR,DATETYPE,CURRSYMB,CURRCODE,PRINBAR,BARPRINT,CARPRINT,CADPRINT,LOCPRINT,SHIPRINT,REPPRINT,BARPRTY,REPPRTY,CARPRTY,CADPRTY,SHIPRTY,LOCPRTY,ALTSELEN,CUSTOLEN,CARCSIZE,CADCSIZE,SHICSIZE,REPCSIZE,LOCCSIZE,CS,NCONFTYP,NLOCATIO,NDIVCODE,NDEPCODE,NADDCODE,NFLOOR,NROOM,NRACK,MENUTYPE,PADTYPE,NRATE1TA,NRATE2TA,DEFCONFT,BEEPSOU,CONFIRM,LINEFEED,REFBARADJ,SHIBARADJ,CUSBARADJ,LOCBARADJ,CARBARADJ,NCORDER,NSPERSON,PROMPTI,CUSTOMERQUOTENB,CUSTOMERQUOTEN,CUSTOMERQUOTENA,CUSTOMERORDERNB,CUSTOMERORDERN,CUSTOMERORDERNA,VENDORORDERNB,VENDORORDERN,VENDORORDERNA,EMPLOYEEORDERNB,EMPLOYEEORDERN,EMPLOYEEORDERNA,JOBNB,JOBN,JOBNA,CUSTOMERINVOICENB,CUSTOMERINVOICEN,CUSTOMERINVOICENA,VENDORINVOICENB,VENDORINVOICEN,VENDORINVOICENA,CUSTOMERPICKNB,CUSTOMERPICKN,CUSTOMERPICKNA,VENDORQUOTENB,VENDORQUOTEN,VENDORQUOTENA,CUSTOMERPAYMNTNB,CUSTOMERPAYMNTN,CUSTOMERPAYMNTNA,VENDORPAYMNTNB,VENDORPAYMNTN,VENDORPAYMNTNA,VENDORCHQNB,VENDORCHQN,VENDORCHQNA,TASKNB,TASKN,TASKNA,ARSEQB,ARSEQ,ARSEQA,APSEQB,APSEQ,APSEQA,GLSEQB,GLSEQ,GLSEQA,PASEQB,PASEQ,PASEQA,ICSEQB,ICSEQ,ICSEQA,JOSEQB,JOSEQ,JOSEQA,SGLENTRY,TAX1CODE,TAX2CODE,TAX3CODE,NDECIMAL,EDIPASSW,INTPASSW,INRPASSW,IMLPASSW,RMLPASSW,LMLPASSW,HOSPASSW,LANPASSW,WANPASSW,ASHOSTID,HDSTYLE,MTSTYLE,STSTYLE,DTSTYLE,FTSTYLE,DEFAULTR,DEFAULTC,DBNAME,ROOTDIR,KEYORDER,CURRBUSDAT,LASTBUSDAT,CURRCALDAT,LASTCALDAT,PREPROCESS,MARGIN,FOOTER,LASTUSER,LISTBUILDC,LISTBUILDV,LISTBUILDE,LISTBROWNC,LISTBROWNV,LISTBROWNE,SMTPSERVER,SMTPUSER,SMTPPASS,POP3SERVER,POP3USER,POP3PASS,SMATCODE,FYREND,FPERIODS,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,licensetype,licensestart,licenseend)=(b.sid,b.CLIENTVERSION,b.SERIALNUM,b.ENTERPRISECOMPANYNA,b.DESCRIPT,b.ADDRL1,b.ADDRL2,b.ADDRL3,b.CITY,b.PROVNSTATE,b.COUNTRYNAME,b.PZCODE,b.PHONEO,b.PHONEH,b.PHONEC,b.PHONEX,b.LANADDR,b.WANADDR,b.LMAILADDR,b.IMAILADDR,b.RMAILADDR,b.INTADDR,b.INRADDR,b.ENTERPRISECOMPCODE,b.ENTERPRISECOMPSIZE,b.BARCSIZE,b.LEVEL,b.POSKIPP,b.LOOSEIT,b.JOBSKIP,b.CARTONFL,b.PICKLIST,b.PRODDESC,b.PRODCODE,b.NJOB,b.NMATERIA,b.NACTIVITY,b.NBUTT,b.NCUSTOME,b.NCONTACT,b.NVENDOR,b.NEMPLOYEE,b.NSCHEDULE,b.NREJECT,b.NRETURN,b.NCODE,b.MANUFID,b.BARTYPE,b.CADTYPE,b.CARTYPE,b.SHITYPE,b.REPTYPE,b.LOCTYPE,b.BARCOL,b.CARCOL,b.CADCOL,b.SHICOL,b.REPCOL,b.LOCCOL,b.ALTSERIA,b.COUNTRYCODE,b.NALTSERI,b.SCRCOLOR,b.HILCOLOR,";
sqlScript=line1+"a.TEXTCOLOR,b.BACCOLOR,b.DATETYPE,b.CURRSYMB,b.CURRCODE,b.PRINBAR,b.BARPRINT,b.CARPRINT,b.CADPRINT,b.LOCPRINT,b.SHIPRINT,b.REPPRINT,b.BARPRTY,b.REPPRTY,b.CARPRTY,b.CADPRTY,b.SHIPRTY,b.LOCPRTY,b.ALTSELEN,b.CUSTOLEN,b.CARCSIZE,b.CADCSIZE,b.SHICSIZE,b.REPCSIZE,b.LOCCSIZE,b.CS,b.NCONFTYP,b.NLOCATIO,b.NDIVCODE,b.NDEPCODE,b.NADDCODE,b.NFLOOR,b.NROOM,b.NRACK,b.MENUTYPE,b.PADTYPE,b.NRATE1TA,b.NRATE2TA,b.DEFCONFT,b.BEEPSOU,b.CONFIRM,b.LINEFEED,b.REFBARADJ,b.SHIBARADJ,b.CUSBARADJ,b.LOCBARADJ,b.CARBARADJ,b.NCORDER,b.NSPERSON,b.PROMPTI,b.CUSTOMERQUOTENB,b.CUSTOMERQUOTEN,b.CUSTOMERQUOTENA,b.CUSTOMERORDERNB,b.CUSTOMERORDERN,b.CUSTOMERORDERNA,b.VENDORORDERNB,b.VENDORORDERN,b.VENDORORDERNA,b.EMPLOYEEORDERNB,b.EMPLOYEEORDERN,b.EMPLOYEEORDERNA,b.JOBNB,b.JOBN,b.JOBNA,b.CUSTOMERINVOICENB,b.CUSTOMERINVOICEN,b.CUSTOMERINVOICENA,b.VENDORINVOICENB,b.VENDORINVOICEN,b.VENDORINVOICENA,b.CUSTOMERPICKNB,b.CUSTOMERPICKN,b.CUSTOMERPICKNA,b.VENDORQUOTENB,b.VENDORQUOTEN,b.VENDORQUOTENA,b.CUSTOMERPAYMNTNB,b.CUSTOMERPAYMNTN,b.CUSTOMERPAYMNTNA,b.VENDORPAYMNTNB,b.VENDORPAYMNTN,b.VENDORPAYMNTNA,b.VENDORCHQNB,b.VENDORCHQN,b.VENDORCHQNA,b.TASKNB,b.TASKN,b.TASKNA,b.ARSEQB,b.ARSEQ,b.ARSEQA,b.APSEQB,b.APSEQ,b.APSEQA,b.GLSEQB,b.GLSEQ,b.GLSEQA,b.PASEQB,b.PASEQ,b.PASEQA,b.ICSEQB,b.ICSEQ,b.ICSEQA,b.JOSEQB,b.JOSEQ,b.JOSEQA,b.SGLENTRY,b.TAX1CODE,b.TAX2CODE,b.TAX3CODE,b.NDECIMAL,b.EDIPASSW,b.INTPASSW,b.INRPASSW,b.IMLPASSW,b.RMLPASSW,b.LMLPASSW,b.HOSPASSW,b.LANPASSW,b.WANPASSW,b.ASHOSTID,b.HDSTYLE,b.MTSTYLE,b.STSTYLE,b.DTSTYLE,b.FTSTYLE,b.DEFAULTR,b.DEFAULTC,b.DBNAME,b.ROOTDIR,b.KEYORDER,b.CURRBUSDAT,b.LASTBUSDAT,b.CURRCALDAT,b.LASTCALDAT,b.PREPROCESS,b.MARGIN,b.FOOTER,b.LASTUSER,b.LISTBUILDC,b.LISTBUILDV,b.LISTBUILDE,b.LISTBROWNC,b.LISTBROWNV,b.LISTBROWNE,b.SMTPSERVER,b.SMTPUSER,b.SMTPPASS,b.POP3SERVER,b.POP3USER,b.POP3PASS,b.SMATCODE,b.FYREND,b.FPERIODS,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2,b.licensetype,b.licensestart,b.licenseend)FROM "+schemaName+".CLIENT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".DEPARTMENT a SET(SID,DEPCODE,DESCRIPT,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.sid,b.DEPCODE,b.DESCRIPT,b.GLPREFIX,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".DEPARTMENT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".COMPANY a SET(SID,COMPANYCODE,DESCRIPT,LEGALNAME,MAILTOCODE,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.sid,b.COMPANYCODE,b.DESCRIPT,b.LEGALNAME,b.MAILTOCODE,b.GLPREFIX,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".COMPANY_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CONTROL a SET(SID,CONTROLCODE,DESCRIPT,TYPEOFCONTROL,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.sid,b.CONTROLCODE,b.DESCRIPT,b.TYPEOFCONTROL,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".CONTROL_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();



sqlScript="UPDATE "+schemaName+".DIVISION a SET(SID,DIVCODE,DESCRIPT,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.sid,b.DIVCODE,b.DESCRIPT,b.GLPREFIX,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".DIVISION_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".LOCATION a SET(SID,LOCATION,DESCRIPT,COMPANYCODE,ADDRESSCODE,FLOOR,ROOM,RACK,PRINTMSTAT,PRINMTFLDT,EXCLUDE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.sid,b.LOCATION,b.DESCRIPT,b.COMPANYCODE,b.ADDRESSCODE,b.FLOOR,b.ROOM,b.RACK,b.PRINTMSTAT,b.PRINMTFLDT,b.EXCLUDE,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".LOCATION_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RESIDENCY a SET(SID,RESIDENCY,DESCRIPT,MUNICIPALITY,PROVINCE,COUNTRYNAME,EXCLUDE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.sid,b.RESIDENCY,b.DESCRIPT,b.MUNICIPALITY,b.PROVINCE,b.COUNTRYNAME,b.EXCLUDE,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".RESIDENCY_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ACCOUNT a SET(SID,ACCOUNT,DESCRIPT,CATEGORY,TYPE,BUDGET,ACTUAL,ACTUALN,PREVBUDG,PREVACT,SEQUENCE,CHILD,PARENT,ROLLUPQ,COMPANYCODE,DEPCODE,DIVCODE,STATUSFL,STATUSFLDT,CURRENCY,NOTES,OWNER,OWNER2,P0,P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P8T,P9T,P10T,P11T)=(b.SID,b.ACCOUNT,b.DESCRIPT,b.CATEGORY,b.TYPE,b.BUDGET,b.ACTUAL,b.ACTUALN,b.PREVBUDG,b.PREVACT,b.SEQUENCE,b.CHILD,b.PARENT,b.ROLLUPQ,b.COMPANYCODE,b.DEPCODE,b.DIVCODE,b.STATUSFL,b.STATUSFLDT,b.CURRENCY,b.NOTES,b.OWNER,b.OWNER2,b.P0,b.P1,b.P2,b.P3,b.P4,b.P5,b.P6,b.P7,b.P8,b.P9,b.P10,b.P11,b.P12,b.P13,b.P14,b.P8T,b.P9T,b.P10T,b.P11T)FROM "+schemaName+".ACCOUNT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CUSTOMER a SET(SID,CUSTOMER,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,CUSTOMERASCOMPANYNAME,CUSTTOTL,CUSTTQTY,COMPANYCODE,LOCATION,MAILTOCODE,SHIPTOCODE,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,DOB,PLACEOFBIRTH,SEX,AGE,CUSRTOTL,CUSRTQTY,CUSMTOTL,CUSDTOTL,LASTORDER,LASTINVOIC,LASTPAYMNQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,TOTLPAID,CONTACTED,BYWHO,NXTCONTACT,VIA,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.CUSTOMER,b.DESCRIPT,b.TITLE,b.JOBTITLE,b.LASTNAME,b.FIRSTNAME,b.MIDDLENAM,b.CUSTOMERASCOMPANYNAME,b.CUSTTOTL,b.CUSTTQTY,b.COMPANYCODE,b.LOCATION,b.MAILTOCODE,b.SHIPTOCODE,b.TAX1,b.TAX2,b.TAX3,b.CUSTTAX1,b.CUSTTAX2,b.CUSTTAX3,b.PHONEO,b.PHONEH,b.PHONEC,b.PHONEX,b.LANADDR,b.WANADDR,b.LMAILADDR,b.IMAILADDR,b.RMAILADDR,b.INTADDR,b.INRADDR,b.DOB,b.PLACEOFBIRTH,b.SEX,b.AGE,b.CUSRTOTL,b.CUSRTQTY,b.CUSMTOTL,b.CUSDTOTL,b.LASTORDER,b.LASTINVOIC,b.LASTPAYMNQ,b.PRINTMSTAT,b.PRINMTFLDT,b.SHIPLABEL,b.TYPE,b.DEFAULTGLAC,b.INTEGRSET,b.STATUSFL,b.STATUSFLDT,b.TOTLPAID,b.CONTACTED,b.BYWHO,b.NXTCONTACT,b.VIA,b.KEYWORDS,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".CUSTOMER_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".VENDOR a SET(SID,VENDOR,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,VENDORASCOMPANYNAME,VENDTOTL,VENDTQTY,COMPANYCODE,LOCATION,MAILTOCODE,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,VENRTOTL,VENRTQTY,VENMTOTL,VENDDTOTL,LASTQUOTE,LASTORDER,LASTINVOIC,LASTPAYMQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,SHIPTOCODE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,TOTLPAID,CONTACTED,BYWHO,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.VENDOR,b.DESCRIPT,b.TITLE,b.JOBTITLE,b.LASTNAME,b.FIRSTNAME,b.MIDDLENAM,b.VENDORASCOMPANYNAME,b.VENDTOTL,b.VENDTQTY,b.COMPANYCODE,b.LOCATION,b.MAILTOCODE,b.PHONEO,b.PHONEH,b.PHONEC,b.PHONEX,b.LANADDR,b.WANADDR,b.LMAILADDR,b.IMAILADDR,b.RMAILADDR,b.INTADDR,b.INRADDR,b.VENRTOTL,b.VENRTQTY,b.VENMTOTL,b.VENDDTOTL,b.LASTQUOTE,b.LASTORDER,b.LASTINVOIC,b.LASTPAYMQ,b.PRINTMSTAT,b.PRINMTFLDT,b.SHIPLABEL,b.TYPE,b.SHIPTOCODE,b.DEFAULTGLAC,b.INTEGRSET,b.STATUSFL,b.STATUSFLDT,b.TOTLPAID,b.CONTACTED,b.BYWHO,b.KEYWORDS,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".VENDOR_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".EMPLOYEE a SET(SID,EMPLOYEE,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,COMPANYCODE,EMPLTOTL,EMPLTQTY,DIVCODE,DEPCODE,LOCATION,RESIDENCY,MAILTOCODE,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,EMPRTOTL,EMPRTQTY,EMPMTOTL,EMPDTOTL,LASTQUOTE,LASTORDER,LASTINVOIC,LASTPAYMQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,SHIPTOCODE,TYPE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,CONTACTED,BYWHO,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.EMPLOYEE,b.DESCRIPT,b.TITLE,b.JOBTITLE,b.LASTNAME,b.FIRSTNAME,b.MIDDLENAM,b.COMPANYCODE,b.EMPLTOTL,b.EMPLTQTY,b.DIVCODE,b.DEPCODE,b.LOCATION,b.RESIDENCY,b.MAILTOCODE,b.TAX1,b.TAX2,b.TAX3,b.CUSTTAX1,b.CUSTTAX2,b.CUSTTAX3,b.PHONEO,b.PHONEH,b.PHONEC,b.PHONEX,b.LANADDR,b.WANADDR,b.LMAILADDR,b.IMAILADDR,b.RMAILADDR,b.INTADDR,b.INRADDR,b.EMPRTOTL,b.EMPRTQTY,b.EMPMTOTL,b.EMPDTOTL,b.LASTQUOTE,b.LASTORDER,b.LASTINVOIC,b.LASTPAYMQ,b.PRINTMSTAT,b.PRINMTFLDT,b.SHIPLABEL,b.SHIPTOCODE,b.TYPE,b.DEFAULTGLAC,b.INTEGRSET,b.STATUSFL,b.STATUSFLDT,b.CONTACTED,b.BYWHO,b.KEYWORDS,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".EMPLOYEE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".VCONTACT a SET(SID,CONTACT,VENDOR,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,LOCATION,MAILTOCODE,SHIPTOCODE,PRINTSTA,SHIPLABEL,TYPE,STATUSFL,STATUSFLDT,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.CONTACT,b.VENDOR,b.TITLE,b.JOBTITLE,b.LASTNAME,b.FIRSTNAME,b.MIDDLENAM,b.PHONEO,b.PHONEH,b.PHONEC,b.PHONEX,b.LANADDR,b.WANADDR,b.LMAILADDR,b.IMAILADDR,b.RMAILADDR,b.INTADDR,b.INRADDR,b.LOCATION,b.MAILTOCODE,b.SHIPTOCODE,b.PRINTSTA,b.SHIPLABEL,b.TYPE,b.STATUSFL,b.STATUSFLDT,b.KEYWORDS,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".VCONTACT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CCONTACT a SET(SID,CONTACT,CUSTOMER,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,LOCATION,MAILTOCODE,SHIPTOCODE,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,STATUSFL,STATUSFLDT,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.CONTACT,b.CUSTOMER,b.TITLE,b.JOBTITLE,b.LASTNAME,b.FIRSTNAME,b.MIDDLENAM,b.TAX1,b.TAX2,b.TAX3,b.CUSTTAX1,b.CUSTTAX2,b.CUSTTAX3,b.PHONEO,b.PHONEH,b.PHONEC,b.PHONEX,b.LANADDR,b.WANADDR,b.LMAILADDR,b.IMAILADDR,b.RMAILADDR,b.INTADDR,b.INRADDR,b.LOCATION,b.MAILTOCODE,b.SHIPTOCODE,b.PRINTMSTAT,b.PRINMTFLDT,b.SHIPLABEL,b.TYPE,b.STATUSFL,b.STATUSFLDT,b.KEYWORDS,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".CCONTACT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".PERIODDATES a SET(SID,PERIOD,DESCRIPT,STARTDATE,ENDDATE,STARTOFWEEK,STARTOFBWEEK,ENDOFBWEEK,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.PERIOD,b.DESCRIPT,b.STARTDATE,b.ENDDATE,b.STARTOFWEEK,b.STARTOFBWEEK,b.ENDOFBWEEK,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".PERIODDATES_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".ACPERIOD a SET(SID,ROWID,CURRPERIOD,DESCRIPT,CURRBUSDATE,CURRCALDATE,CURRLOCALDATE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.ROWID,b.CURRPERIOD,b.DESCRIPT,b.CURRBUSDATE,b.CURRCALDATE,b.CURRLOCALDATE,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".ACPERIOD_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".WAGEEARNER a SET(SID,WAGEEARNERID,EMPLOYEE,SIN,BIRTHDT,FEDCLAIM,PROVCLAIM,PAYYRFREQ,PAYPERIOD,WCB,WCBYTD,EMPLINSUR,INSYTD,VACRETAIN,VACATONYT,WAGEUNIT,WAGERATE,OTIMEUNIT,OTIMERATE,WAGEUNITS,OTIMUNITS,WAGEOUT,OVTIMEOUT,SALARYOUT,COMMISSION,BENEFITS,VACATION,VACPAYOUT,ADVANCE,PENSION,AFTERTAX,UNIONDUES,MEDICAL,FINCOMETX,PINCOMETX,THISPAYA,LASTPAYA,PAYYTD,FPENSIYTD,PPENSIYTD,ITAXYTD,PTAXYTD,GRPAYYTD,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.WAGEEARNERID,b.EMPLOYEE,b.SIN,b.BIRTHDT,b.FEDCLAIM,b.PROVCLAIM,b.PAYYRFREQ,b.PAYPERIOD,b.WCB,b.WCBYTD,b.EMPLINSUR,b.INSYTD,b.VACRETAIN,b.VACATONYT,b.WAGEUNIT,b.WAGERATE,b.OTIMEUNIT,b.OTIMERATE,b.WAGEUNITS,b.OTIMUNITS,b.WAGEOUT,b.OVTIMEOUT,b.SALARYOUT,b.COMMISSION,b.BENEFITS,b.VACATION,b.VACPAYOUT,b.ADVANCE,b.PENSION,b.AFTERTAX,b.UNIONDUES,b.MEDICAL,b.FINCOMETX,b.PINCOMETX,b.THISPAYA,b.LASTPAYA,b.PAYYTD,b.FPENSIYTD,b.PPENSIYTD,b.ITAXYTD,b.PTAXYTD,b.GRPAYYTD,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".WAGEEARNER_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ARTHATBL a SET(SID,USAGE,WCBPERCNT,INSFACTOR,VACATONRATE,PENSIONMAX,WCBMAX,INSMAX,ITAXLV0RATE,ITAXLV1RATE,ITAXLV2RATE,ITAXLV3RATE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.USAGE,b.WCBPERCNT,b.INSFACTOR,b.VACATONRATE,b.PENSIONMAX,b.WCBMAX,b.INSMAX,b.ITAXLV0RATE,b.ITAXLV1RATE,b.ITAXLV2RATE,b.ITAXLV3RATE,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".ARTHATBL_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ROLLUPGROUP a SET(SID,GROUPID,DESCRIPT,TYPE,CURRPW,EXPIRY,CURRENCY,PERIOD0B,PERIOD0,PERIODTOTALSB,PERIODTOTALS,PERIOD1BUDGET,PERIOD1ACTUAL,PERIOD2B,PERIOD2,PERIOD3B,PERIOD3,PERIOD4B,PERIOD4,PERIOD5B,PERIOD5,PERIOD6B,PERIOD6,PERIOD7B,PERIOD7,PERIOD8B,PERIOD8,PERIOD9B,PERIOD9,PERIOD10B,PERIOD10,PERIOD11B,PERIOD11,PERIOD12B,PERIOD12,PERIODNB,PERIODN,NOTES,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.GROUPID,b.DESCRIPT,b.TYPE,b.CURRPW,b.EXPIRY,b.CURRENCY,b.PERIOD0B,b.PERIOD0,b.PERIODTOTALSB,b.PERIODTOTALS,b.PERIOD1BUDGET,b.PERIOD1ACTUAL,b.PERIOD2B,b.PERIOD2,b.PERIOD3B,b.PERIOD3,b.PERIOD4B,b.PERIOD4,b.PERIOD5B,b.PERIOD5,b.PERIOD6B,b.PERIOD6,b.PERIOD7B,b.PERIOD7,b.PERIOD8B,b.PERIOD8,b.PERIOD9B,b.PERIOD9,b.PERIOD10B,b.PERIOD10,b.PERIOD11B,b.PERIOD11,b.PERIOD12B,b.PERIOD12,b.PERIODNB,b.PERIODN,b.NOTES,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".ROLLUPGROUP_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".MEMBERSGROUP a SET(SID,GROUPID,DESCRIPT,QUANTITY,MODE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.GROUPID,b.DESCRIPT,b.QUANTITY,b.MODE,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".MEMBERSGROUP_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ARTHAHIST a SET(SID,WAGEEARNER,SIN,PERIOD,MONTH,CCYY,VACATION,WAGE,OVERTIME,SALARY,COMMISSION,BENEFIT,FINCOMETX,PINCOMETX,WCBOUT,EMPLINSUR,VACPAYOUT,ADVANCE,FPENSOBTX,FPENSOATX,UNIONDUES,MEDICAL,PAYAMT,NOTES,NOTES2,CHQNUMBER,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.WAGEEARNER,b.SIN,b.PERIOD,b.MONTH,b.CCYY,b.VACATION,b.WAGE,b.OVERTIME,b.SALARY,b.COMMISSION,b.BENEFIT,b.FINCOMETX,b.PINCOMETX,b.WCBOUT,b.EMPLINSUR,b.VACPAYOUT,b.ADVANCE,b.FPENSOBTX,b.FPENSOATX,b.UNIONDUES,b.MEDICAL,b.PAYAMT,b.NOTES,b.NOTES2,b.CHQNUMBER,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".ARTHAHIST_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".HOLIDAY a SET(SID,SHOLIDAY,HOLIDAY,DESCRIPT,TYPE,STATUSFL,STATUSFLDT,EMPLOYEE,RESIDENCY,OWNER,OWNER2)=(b.SID,b.SHOLIDAY,b.HOLIDAY,b.DESCRIPT,b.TYPE,b.STATUSFL,b.STATUSFLDT,b.EMPLOYEE,b.RESIDENCY,b.OWNER,b.OWNER2)FROM "+schemaName+".HOLIDAY_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ITEM a SET(SID,MATCODE,QUANTITY,DESCRIPT,DATEADDED,DATEEXPIRY,DATETORENEW,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,LOCATION,BARUPC)=(b.SID,b.MATCODE,b.QUANTITY,b.DESCRIPT,b.DATEADDED,b.DATEEXPIRY,b.DATETORENEW,b.SOURCE1,b.SOURCE2,b.UPCCODE,b.COST,b.REPLCOST,b.SELPRICE,b.SPRICOLD,b.SPRICNEW,b.SPRICEFFDT,b.SHIPCODE,b.PRINTMSTAT,b.PRINMTFLDT,b.MISCCODE1,b.MISCCODE2,b.QTYLEVEL1,b.UNIT,b.CASEQTY,b.TYPE,b.TAX1,b.TAX2,b.TAX3,b.ALIASCODE,b.PARENTCODE,b.AVGPRICE,b.AVGCOST,b.STATUSFL,b.STATUSFLDT,b.SUBCODESN,b.SUBCODESN2,b.SUBCODESN3,b.CUORDQTY,b.VENORQTY,b.CUPICQTY,b.VENPIQTY,b.CUINVQTY,b.CUSHIQTY,b.VENSHQTY,b.EFFDATE,b.INTEGRSET,b.NOTES,b.DOCMNT,b.OWNER,b.OWNER2,b.LOCATION,b.BARUPC)FROM "+schemaName+".ITEM_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ACTIVITY a SET(SID,ACTIVITYCODE,QUANTITY,DESCRIPT,DATE,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,BARUPC)=(b.SID,b.ACTIVITYCODE,b.QUANTITY,b.DESCRIPT,b.DATE,b.SOURCE1,b.SOURCE2,b.UPCCODE,b.COST,b.REPLCOST,b.SELPRICE,b.SPRICOLD,b.SPRICNEW,b.SPRICEFFDT,b.SHIPCODE,b.PRINTMSTAT,b.PRINMTFLDT,b.MISCCODE1,b.MISCCODE2,b.QTYLEVEL1,b.UNIT,b.CASEQTY,b.TYPE,b.TAX1,b.TAX2,b.TAX3,b.ALIASCODE,b.PARENTCODE,b.AVGPRICE,b.AVGCOST,b.STATUSFL,b.STATUSFLDT,b.SUBCODESN,b.SUBCODESN2,b.SUBCODESN3,b.CUORDQTY,b.VENORQTY,b.CUPICQTY,b.VENPIQTY,b.CUINVQTY,b.CUSHIQTY,b.VENSHQTY,b.EFFDATE,b.INTEGRSET,b.NOTES,b.DOCMNT,b.OWNER,b.OWNER2,b.BARUPC)FROM "+schemaName+".ACTIVITY_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".SCHEDULE a SET(SID,TODO,DESCRIPT,EMPLOYEE,SSDATET,ACTIVITYCODE,LOCATION,SDATET,DURATIONH,DURATIONM,STIMEH,STIMEM,STIMEAMPM,EDATET,PRIORITY,PERCNTDONE,VENDOR,VONTACT,CUSTOMER,TYPE,MAILTOCODE,OTHEREMPLO,REPEATF,STATUSFL,STATUSFLDT,PRIVATEIND,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.TODO,b.DESCRIPT,b.EMPLOYEE,b.SSDATET,b.ACTIVITYCODE,b.LOCATION,b.SDATET,b.DURATIONH,b.DURATIONM,b.STIMEH,b.STIMEM,b.STIMEAMPM,b.EDATET,b.PRIORITY,b.PERCNTDONE,b.VENDOR,b.VONTACT,b.CUSTOMER,b.TYPE,b.MAILTOCODE,b.OTHEREMPLO,b.REPEATF,b.STATUSFL,b.STATUSFLDT,b.PRIVATEIND,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".SCHEDULE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".\"USER\" a SET(SID,ID,CLIENT,EMPLOYEE,VENDOR,CUSTOMER,OTHERID,ALEVEL,BLEVEL,CURRPW,EXPIRY,OLDPW,TEMPORARYPASSWORD,PASSWORDHASH,ACTIVATIONKEY,RESTRICT1,RESTRICT2,RESTRICT3,ALLOW1,ALLOW2,ALLOW3,MAXPROFLROW,CPROFLROW,STATUSFL,STATUSFLDT,UCURRCALDA,PREPROCESS,NOTES,DOCMNT,OWNER,OWNER2)=(b.SID,b.ID,b.CLIENT,b.EMPLOYEE,b.VENDOR,b.CUSTOMER,b.OTHERID,b.ALEVEL,b.BLEVEL,b.CURRPW,b.EXPIRY,b.OLDPW,b.TEMPORARYPASSWORD,b.PASSWORDHASH,b.ACTIVATIONKEY,b.RESTRICT1,b.RESTRICT2,b.RESTRICT3,b.ALLOW1,b.ALLOW2,b.ALLOW3,b.MAXPROFLROW,b.CPROFLROW,b.STATUSFL,b.STATUSFLDT,b.UCURRCALDA,b.PREPROCESS,b.NOTES,b.DOCMNT,b.OWNER,b.OWNER2)FROM "+schemaName+".\"USER_c\" b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
if(dbProductName.equals("psql")){
 sqlScript="UPDATE "+schemaName+".\"user\" a SET(SID,ID,CLIENT,EMPLOYEE,VENDOR,CUSTOMER,OTHERID,ALEVEL,BLEVEL,CURRPW,EXPIRY,OLDPW,TEMPORARYPASSWORD,PASSWORDHASH,ACTIVATIONKEY,RESTRICT1,RESTRICT2,RESTRICT3,ALLOW1,ALLOW2,ALLOW3,MAXPROFLROW,CPROFLROW,STATUSFL,STATUSFLDT,UCURRCALDA,PREPROCESS,NOTES,DOCMNT,OWNER,OWNER2)=(b.SID,b.ID,b.CLIENT,b.EMPLOYEE,b.VENDOR,b.CUSTOMER,b.OTHERID,b.ALEVEL,b.BLEVEL,b.CURRPW,b.EXPIRY,b.OLDPW,b.TEMPORARYPASSWORD,b.PASSWORDHASH,b.ACTIVATIONKEY,b.RESTRICT1,b.RESTRICT2,b.RESTRICT3,b.ALLOW1,b.ALLOW2,b.ALLOW3,b.MAXPROFLROW,b.CPROFLROW,b.STATUSFL,b.STATUSFLDT,b.UCURRCALDA,b.PREPROCESS,b.NOTES,b.DOCMNT,b.OWNER,b.OWNER2)FROM "+schemaName+".\"user_c\" b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
}

q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".USERPROFL a SET(SID,LOGONID,ROW,OPTION,SELECTVALUE,SCRCOLOR,HILCOLOR,TEXTCOLOR,BACCOLOR,BEEPSOU,CONFIRM,PROMPTI,P1,P2,P3,P4,P5,P6,MTSTYLE,STSTYLE,DTSTYLE,FTSTYLE,DEFAULTR,DEFAULTC,DBNAME,ROOTDIR,KEYORDER,MARGIN,FOOTER,LISTBUILDC,LISTBUILDV,LISTBUILDE,LISTBROWNC,LISTBROWNV,LISTBROWNE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.LOGONID,b.ROW,b.OPTION,b.SELECTVALUE,b.SCRCOLOR,b.HILCOLOR,b.TEXTCOLOR,b.BACCOLOR,b.BEEPSOU,b.CONFIRM,b.PROMPTI,b.P1,b.P2,b.P3,b.P4,b.P5,b.P6,b.MTSTYLE,b.STSTYLE,b.DTSTYLE,b.FTSTYLE,b.DEFAULTR,b.DEFAULTC,b.DBNAME,b.ROOTDIR,b.KEYORDER,b.MARGIN,b.FOOTER,b.LISTBUILDC,b.LISTBUILDV,b.LISTBUILDE,b.LISTBROWNC,b.LISTBROWNV,b.LISTBROWNE,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".USERPROFL_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".VENARTHA a SET(SID,CHQNUMBER,RECONCILED,VENDORC,DATE,ADDRESCODE,CHQAMT,AMTVERBOS,NOTES,ADVISEL1,ADVISEL2,ADVISEL3,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.CHQNUMBER,b.RECONCILED,b.VENDORC,b.DATE,b.ADDRESCODE,b.CHQAMT,b.AMTVERBOS,b.NOTES,b.ADVISEL1,b.ADVISEL2,b.ADVISEL3,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".VENARTHA_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".ACINTEGR a SET(SID,MODULEID,USAGEDESCR,USAGECODE,SETSID,ACCOUNT,EXTRAINTFIELD,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.MODULEID,b.USAGEDESCR,b.USAGECODE,b.SETSID,b.ACCOUNT,b.EXTRAINTFIELD,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".ACINTEGR_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ITEMJOB a SET(SID,JOBNO,MATCODE,PRODDATET,QTYALLOC,PONO,QTYOSTND,QTYALSTK,QTYISSUD,JOBTOTL,STATUSFL,CUSTOMEJ,VENDOR,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,PRINTMSTATJ,PRINMTFLDTJ,TYPE,MATCODEOUT,QTYOUT,NOTES,OWNER,OWNER2)=(b.SID,b.JOBNO,b.MATCODE,b.PRODDATET,b.QTYALLOC,b.PONO,b.QTYOSTND,b.QTYALSTK,b.QTYISSUD,b.JOBTOTL,b.STATUSFL,b.CUSTOMEJ,b.VENDOR,b.STATUSFLDT,b.PRINTMSTAT,b.PRINMTFLDT,b.PRINTMSTATJ,b.PRINMTFLDTJ,b.TYPE,b.MATCODEOUT,b.QTYOUT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".ITEMJOB_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".ACTIVITYJOB a SET(SID,JOBNO,ACTIVITYCODE,PRODDATET,QTYALLOC,PONO,QTYOSTND,QTYALSTK,QTYISSUD,JOBTOTL,STATUSFL,CUSTOMEJ,VENDOR,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,PRINTMSTATJ,PRINMTFLDTJ,TYPE,MATCODEOUT,QTYOUT,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.JOBNO,b.ACTIVITYCODE,b.PRODDATET,b.QTYALLOC,b.PONO,b.QTYOSTND,b.QTYALSTK,b.QTYISSUD,b.JOBTOTL,b.STATUSFL,b.CUSTOMEJ,b.VENDOR,b.STATUSFLDT,b.PRINTMSTAT,b.PRINMTFLDT,b.PRINTMSTATJ,b.PRINMTFLDTJ,b.TYPE,b.MATCODEOUT,b.QTYOUT,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".ACTIVITYJOB_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".VENQUOTE a SET(SID,PURCHSNO,DELVDATET,VENDOR,MATCODE,REPLICATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,CINVOICE,JOBNO,VPONO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.PURCHSNO,b.DELVDATET,b.VENDOR,b.MATCODE,b.REPLICATE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.STATUSFL,b.CINVOICE,b.JOBNO,b.VPONO,b.RFPORD,b.STATUSFLDT,b.RCPONO,b.ODATET,b.TERMS,b.PRIORITY,b.PRINTMSTAT,b.PRINMTFLDT,b.TYPE,b.VINVOICE,b.ATTACH,b.SHIPCODE,b.AGENT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.STARTDATET,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".VENQUOTE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".VENDORDERS a SET(SID,PURCHSNO,DELVDATET,VENDOR,MATCODE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,JOBNO,VENDQNO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.PURCHSNO,b.DELVDATET,b.VENDOR,b.MATCODE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.STATUSFL,b.JOBNO,b.VENDQNO,b.RFPORD,b.STATUSFLDT,b.RCPONO,b.ODATET,b.TERMS,b.PRIORITY,b.PRINTMSTAT,b.PRINMTFLDT,b.TYPE,b.VINVOICE,b.ATTACH,b.SHIPCODE,b.AGENT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.STARTDATET,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".VENDORDERS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".VSHIPMEN a SET(SID,SHIPCODE,MATCODE,SHIPPER,PONO,CPONO,INVOICE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,CARRIER,TYPE,SHIPDATET,SHIPDATETA,TARENO,PACKNO,VENDOR,CUSTOMER,BILLTOCODE,BILLTOSAMEASSHIPTO,SHIPTOCODE,NOTES,STATUSFL,STATUSFLDT,SERIALNO,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2)=(b.SID,b.SHIPCODE,b.MATCODE,b.SHIPPER,b.PONO,b.CPONO,b.INVOICE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.CARRIER,b.TYPE,b.SHIPDATET,b.SHIPDATETA,b.TARENO,b.PACKNO,b.VENDOR,b.CUSTOMER,b.BILLTOCODE,b.BILLTOSAMEASSHIPTO,b.SHIPTOCODE,b.NOTES,b.STATUSFL,b.STATUSFLDT,b.SERIALNO,b.PRINTMSTAT,b.PRINMTFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".VSHIPMEN_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CUQUOTE a SET(SID,PURCHSNO,DELVDATET,VENDOR,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,CUSTOMER,MATCODE,REPLICATE,CINVOICE,ORDPRICE,JOBNO,VPONO,QUOORDT,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,TYPE,TERMS,PRIORITY,ODATET,SHIPCODE,ACTIVITYCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,ATTACH,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.PURCHSNO,b.DELVDATET,b.VENDOR,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.STATUSFL,b.CUSTOMER,b.MATCODE,b.REPLICATE,b.CINVOICE,b.ORDPRICE,b.JOBNO,b.VPONO,b.QUOORDT,b.STATUSFLDT,b.PRINTMSTAT,b.PRINMTFLDT,b.TYPE,b.TERMS,b.PRIORITY,b.ODATET,b.SHIPCODE,b.ACTIVITYCODE,b.AGENT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.ATTACH,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".CUQUOTE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".CUORDERS a SET(SID,PURCHSNO,DELVDATET,CUSTOMER,MATCODE,CUQUOTE,CINVOICE,JOBNO,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,VPONO,RFPORD,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,DOCMNT,SHIPCODEFROMPAY,SHIPCODE,BARPO)=(b.SID,b.PURCHSNO,b.DELVDATET,b.CUSTOMER,b.MATCODE,b.CUQUOTE,b.CINVOICE,b.JOBNO,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.VPONO,b.RFPORD,b.RCPONO,b.ODATET,b.TERMS,b.PRIORITY,b.PRINTMSTAT,b.PRINMTFLDT,b.TYPE,b.VINVOICE,b.ATTACH,b.AGENT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.STARTDATET,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT,b.SHIPCODEFROMPAY,b.SHIPCODE,b.BARPO)FROM "+schemaName+".CUORDERS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CUINVOICE a SET(SID,INVOICE,CUSTOMER,MATCODE,INVODATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,PONO,REF1TYP,REF1CODE,SHIPDATET,SHIPTYPE,SHIPCODE,TERMS,STATUSFL,STATUSFLDT,TERMSDAT,DISCOUNP,DISCOUDT,DISCOUDS,NETDDAT,NETDDYS,FOB,TYPE,INTEGRSET,ATTACH,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,AGENT,NOTES,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,DOCMNT,BARINVOICE)=(b.SID,b.INVOICE,b.CUSTOMER,b.MATCODE,b.INVODATE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.PONO,b.REF1TYP,b.REF1CODE,b.SHIPDATET,b.SHIPTYPE,b.SHIPCODE,b.TERMS,b.STATUSFL,b.STATUSFLDT,b.TERMSDAT,b.DISCOUNP,b.DISCOUDT,b.DISCOUDS,b.NETDDAT,b.NETDDYS,b.FOB,b.TYPE,b.INTEGRSET,b.ATTACH,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.AGENT,b.NOTES,b.PRINTMSTAT,b.PRINMTFLDT,b.OWNER,b.OWNER2,b.DOCMNT,b.BARINVOICE)FROM "+schemaName+".CUINVOICE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".SHIPMENT a SET(SID,SHIPCODE,MATCODE,SHIPPER,PONO,CPONO,INVOICE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,CARRIER,TYPE,SHIPDATET,SHIPDATETA,TARENO,PACKNO,CUSTOMER,BILLTOCODE,BILLTOSAMEASSHIPTO,SHIPTOCODE,NOTES,STATUSFL,STATUSFLDT,SERIALNO,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,BARSHIPCOD)=(b.SID,b.SHIPCODE,b.MATCODE,b.SHIPPER,b.PONO,b.CPONO,b.INVOICE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.CARRIER,b.TYPE,b.SHIPDATET,b.SHIPDATETA,b.TARENO,b.PACKNO,b.CUSTOMER,b.BILLTOCODE,b.BILLTOSAMEASSHIPTO,b.SHIPTOCODE,b.NOTES,b.STATUSFL,b.STATUSFLDT,b.SERIALNO,b.PRINTMSTAT,b.PRINMTFLDT,b.OWNER,b.OWNER2,b.BARSHIPCOD)FROM "+schemaName+".SHIPMENT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".EMPLORDERS a SET(SID,PURCHSNO,DELVDATET,EMPLOYEE,MATCODE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,JOBNO,VPONO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(b.SID,b.PURCHSNO,b.DELVDATET,b.EMPLOYEE,b.MATCODE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.STATUSFL,b.JOBNO,b.VPONO,b.RFPORD,b.STATUSFLDT,b.RCPONO,b.ODATET,b.TERMS,b.PRIORITY,b.PRINTMSTAT,b.PRINMTFLDT,b.TYPE,b.VINVOICE,b.ATTACH,b.SHIPCODE,b.AGENT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.STARTDATET,b.NOTES,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".EMPLORDERS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".HLOGFILE a SET(SID,SERIALNO,MATCODE,QUANRECD,VENDOR,LOCATION,RECVRPT,INFLG,PHY,DATETIN,DATETOUT,JOBNO,PRINTMSTAT,PRINMTFLDT,PONO,SCANDATET,QUANISSD,BUTT,STATUSFL,QUANREJD,CUSTOMER,CPONO,CUSTOMEJ,ORGCOST,ORGPONO,ORGJOBNO,ALTSERNO,SELPRICE,PHYSQTY,SPERSON,CARTONID,CARTONPR,PACKCODE,TARECODE,SHIPCODE,TYPE,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.SERIALNO,b.MATCODE,b.QUANRECD,b.VENDOR,b.LOCATION,b.RECVRPT,b.INFLG,b.PHY,b.DATETIN,b.DATETOUT,b.JOBNO,b.PRINTMSTAT,b.PRINMTFLDT,b.PONO,b.SCANDATET,b.QUANISSD,b.BUTT,b.STATUSFL,b.QUANREJD,b.CUSTOMER,b.CPONO,b.CUSTOMEJ,b.ORGCOST,b.ORGPONO,b.ORGJOBNO,b.ALTSERNO,b.SELPRICE,b.PHYSQTY,b.SPERSON,b.CARTONID,b.CARTONPR,b.PACKCODE,b.TARECODE,b.SHIPCODE,b.TYPE,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".HLOGFILE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CPAYMENT a SET(SID,PAYMENT,CUSTOMER,CINVOICE,CHEQDATE,PAYMENTDUEDATE,POSTINGPERIOD,MATCODE,INTEGRSET,ACCOUNT,AMOUNTTOTAL,AMOUNTOSTNDT,AMOUNTIN,QTYTOTAL,QTYOSTNDT,DISCOUNT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,PAYTYPE,PAYBYID,PAYBYDATE,CURRENCY,CONVRATE,LOCAMOUNTT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.PAYMENT,b.CUSTOMER,b.CINVOICE,b.CHEQDATE,b.PAYMENTDUEDATE,b.POSTINGPERIOD,b.MATCODE,b.INTEGRSET,b.ACCOUNT,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.AMOUNTIN,b.QTYTOTAL,b.QTYOSTNDT,b.DISCOUNT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.PAYTYPE,b.PAYBYID,b.PAYBYDATE,b.CURRENCY,b.CONVRATE,b.LOCAMOUNTT,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".CPAYMENT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".MACHINE a SET(SID,MACHINECODE,QUANTITY,DESCRIPT,DATEADDED,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,BARUPC)=(b.SID,b.MACHINECODE,b.QUANTITY,b.DESCRIPT,b.DATEADDED,b.SOURCE1,b.SOURCE2,b.UPCCODE,b.COST,b.REPLCOST,b.SELPRICE,b.SPRICOLD,b.SPRICNEW,b.SPRICEFFDT,b.SHIPCODE,b.PRINTMSTAT,b.PRINMTFLDT,b.MISCCODE1,b.MISCCODE2,b.QTYLEVEL1,b.UNIT,b.CASEQTY,b.TYPE,b.TAX1,b.TAX2,b.TAX3,b.ALIASCODE,b.PARENTCODE,b.AVGPRICE,b.AVGCOST,b.STATUSFL,b.STATUSFLDT,b.SUBCODESN,b.SUBCODESN2,b.SUBCODESN3,b.CUORDQTY,b.VENORQTY,b.CUPICQTY,b.VENPIQTY,b.CUINVQTY,b.CUSHIQTY,b.VENSHQTY,b.EFFDATE,b.INTEGRSET,b.NOTES,b.DOCMNT,b.OWNER,b.OWNER2,b.BARUPC)FROM "+schemaName+".MACHINE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".GROUPMEMBERS a SET(SID,GROUPID,MEMBERID,DESCRIPT,SOURCETYPE,MEMBEREM,MEMBERCU,MEMBERVE,MEMBERIT,MEMBERAC,MEMBERMA,TYPE,CURRPW,EXPIRY,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.GROUPID,b.MEMBERID,b.DESCRIPT,b.SOURCETYPE,b.MEMBEREM,b.MEMBERCU,b.MEMBERVE,b.MEMBERIT,b.MEMBERAC,b.MEMBERMA,b.TYPE,b.CURRPW,b.EXPIRY,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".GROUPMEMBERS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ITEMBOM a SET(SID,BOMCODE,DESCRIPT,QUANTITY,MODE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.BOMCODE,b.DESCRIPT,b.QUANTITY,b.MODE,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".ITEMBOM_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".ITEMBOMDETAILS a SET(SID,BOMCODE,MATCODE,MODE,SUBQTY,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.BOMCODE,b.MATCODE,b.MODE,b.SUBQTY,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".ITEMBOMDETAILS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".TASK a SET(SID,TASKID,DESCRIPT,ACTIVITYCODE,PROJECTTEAM,RESOURCE,MODE,ESTSTART,CALCSTART,ACTLSTART,ESTEND,CALCEND,ACTLEND,SUBQTY,BOMCODE,LOCATION,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.TASKID,b.DESCRIPT,b.ACTIVITYCODE,b.PROJECTTEAM,b.RESOURCE,b.MODE,b.ESTSTART,b.CALCSTART,b.ACTLSTART,b.ESTEND,b.CALCEND,b.ACTLEND,b.SUBQTY,b.BOMCODE,b.LOCATION,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".TASK_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".VINVOICE a SET(SID,INVOICE,VENDOR,MATCODE,INTEGRSET,INVODATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,PONO,REF1TYP,REF1CODE,SHIPDATET,SHIPTYPE,SHIPCODE,TERMS,STATUSFL,STATUSFLDT,TERMSDAT,DISCOUNP,DISCOUDT,DISCOUDS,NETDDAT,NETDDYS,FOB,TYPE,ATTACH,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,AGENT,NOTES,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,DOCMNT)=(b.SID,b.INVOICE,b.VENDOR,b.MATCODE,b.INTEGRSET,b.INVODATE,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.QTYTOTAL,b.QTYOSTNDT,b.PONO,b.REF1TYP,b.REF1CODE,b.SHIPDATET,b.SHIPTYPE,b.SHIPCODE,b.TERMS,b.STATUSFL,b.STATUSFLDT,b.TERMSDAT,b.DISCOUNP,b.DISCOUDT,b.DISCOUDS,b.NETDDAT,b.NETDDYS,b.FOB,b.TYPE,b.ATTACH,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.AGENT,b.NOTES,b.PRINTMSTAT,b.PRINMTFLDT,b.OWNER,b.OWNER2,b.DOCMNT)FROM "+schemaName+".VINVOICE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".VPAYMENT a SET(SID,PAYMENT,VENDOR,VINVOICE,CHEQDATE,PAYMENTDUEDATE,POSTINGPERIOD,MATCODE,INTEGRSET,ACCOUNT,AMOUNTTOTAL,AMOUNTOSTNDT,AMOUNTIN,QTYTOTAL,QTYOSTNDT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,DISCOUNT,PAYTYPE,PAYBYID,PAYBYDATE,CURRENCY,CONVRATE,LOCAMOUNT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.PAYMENT,b.VENDOR,b.VINVOICE,b.CHEQDATE,b.PAYMENTDUEDATE,b.POSTINGPERIOD,b.MATCODE,b.INTEGRSET,b.ACCOUNT,b.AMOUNTTOTAL,b.AMOUNTOSTNDT,b.AMOUNTIN,b.QTYTOTAL,b.QTYOSTNDT,b.BASEAMOUNTT,b.DELIVCHRGT,b.MISCCHRGT,b.TAX1AMTT,b.TAX2AMTT,b.TAX3AMTT,b.DISCOUNT,b.PAYTYPE,b.PAYBYID,b.PAYBYDATE,b.CURRENCY,b.CONVRATE,b.LOCAMOUNT,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".VPAYMENT_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".WAGEEARNERAUX a SET(SID,WAGEEARNERID,LINE,SIN,WCBYTDL,WCBYTDN,INSYTDL,INSYTDN,VACATONYL,VACATONYN,PAYYTDL,FPENSIYTL,PPENSIYTL,ITAXYTDL,PTAXYTDL,PAYYTDN,FPENSIYTN,PPENSIYTN,ITAXYTDN,PATXYTDN,GPAYYTDL,GPAYYTDN,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.WAGEEARNERID,b.LINE,b.SIN,b.WCBYTDL,b.WCBYTDN,b.INSYTDL,b.INSYTDN,b.VACATONYL,b.VACATONYN,b.PAYYTDL,b.FPENSIYTL,b.PPENSIYTL,b.ITAXYTDL,b.PTAXYTDL,b.PAYYTDN,b.FPENSIYTN,b.PPENSIYTN,b.ITAXYTDN,b.PATXYTDN,b.GPAYYTDL,b.GPAYYTDN,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".WAGEEARNERAUX_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".Rgenapp a SET(SID,APPNAME,DESCRIPT,APPTYPE,APPWACCOUNTING,APPWEMAIL,APPWJMSMQ,APPVENDOR,APPVERSION,APPPLATFORM,APPMODELPKG,APPACTIONPKG,APPSKIN,APPDEPLOYTYPE,CREATEFIDATA,REVENGDATA,INITIALIZEFIDATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.APPNAME,b.DESCRIPT,b.APPTYPE,b.APPWACCOUNTING,b.APPWEMAIL,b.APPWJMSMQ,b.APPVENDOR,b.APPVERSION,b.APPPLATFORM,b.APPMODELPKG,b.APPACTIONPKG,b.APPSKIN,b.APPDEPLOYTYPE,b.CREATEFIDATA,b.REVENGDATA,b.INITIALIZEFIDATA,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".Rgenapp_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RGENDB a SET(SID,DBNAME,DESCRIPT,DBTYPE,DBVENDOR,DBVERSION,DBPLATFORM,APPCODE,SQLDRIVER,SQLURL,SQLUSER,SQLPASSWORD,SQLCLASSPATH,SQLCREATEDBSCRIPT,SQLDROPDBSCRIPT,SQLCREATETBLSSCRIPT,SQLLOADTBLSSCRIPT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.DBNAME,b.DESCRIPT,b.DBTYPE,b.DBVENDOR,b.DBVERSION,b.DBPLATFORM,b.APPCODE,b.SQLDRIVER,b.SQLURL,b.SQLUSER,b.SQLPASSWORD,b.SQLCLASSPATH,b.SQLCREATEDBSCRIPT,b.SQLDROPDBSCRIPT,b.SQLCREATETBLSSCRIPT,b.SQLLOADTBLSSCRIPT,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".RGENDB_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RGENTABLE a SET(SID,TABLENAME,DBCODE,INADDMENU,INLISTMENU,INTRANSACTIONMENU,INREPORTMENU,INGRAPHSMENU,INMAILINGMENU,INGENERATEMENU,INADMINMENU,INMAINTENANCEMENU,INLABELSMENU,INSKIPMENU,INCUSTOM1MENU,MENULEVEL,MENUROLE,MENULABELGROUP,SUBMENUSEQUENCE,USAGESCOPE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.TABLENAME,b.DBCODE,b.INADDMENU,b.INLISTMENU,b.INTRANSACTIONMENU,b.INREPORTMENU,b.INGRAPHSMENU,b.INMAILINGMENU,b.INGENERATEMENU,b.INADMINMENU,b.INMAINTENANCEMENU,b.INLABELSMENU,b.INSKIPMENU,b.INCUSTOM1MENU,b.MENULEVEL,b.MENUROLE,b.MENULABELGROUP,b.SUBMENUSEQUENCE,b.USAGESCOPE,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".RGENTABLE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2);UPDATE "+schemaName+".RGENFIELDS a SET(SID,DBCODE,TABLENAME,FIELDNAME,FIELDTYPE,FIELDLENGTH,INGROUP,SEQWITHINGROUP,FOCUSSEQ,FUTURE1,INITIALVALUE,KEYORADDITIONAL,KEYORADDITIONAL2,KEYORADDITIONAL3,SHOWINMENU,SHOWINREPORT,PROCESSOPTION1,PROCESSOPTION2,FDBCODE,FTABLENAME,FFIELDKEYNAME1,FFIELDKEYNAME2,FFIELDKEYNAME3,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.DBCODE,b.TABLENAME,b.FIELDNAME,b.FIELDTYPE,b.FIELDLENGTH,b.INGROUP,b.SEQWITHINGROUP,b.FOCUSSEQ,b.FUTURE1,b.INITIALVALUE,b.KEYORADDITIONAL,b.KEYORADDITIONAL2,b.KEYORADDITIONAL3,b.SHOWINMENU,b.SHOWINREPORT,b.PROCESSOPTION1,b.PROCESSOPTION2,b.FDBCODE,b.FTABLENAME,b.FFIELDKEYNAME1,b.FFIELDKEYNAME2,b.FFIELDKEYNAME3,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".RGENFIELDS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".GENOPTIONS a SET(SID,ROW,GENOPTIONS01,GENPURPOSE01,GENVALUE01,GENOPTIONS02,GENPURPOSE02,GENVALUE02,GENOPTIONS03,GENPURPOSE03,GENVALUE03,GENOPTIONS04,GENPURPOSE04,GENVALUE04,GENOPTIONS05,GENPURPOSE05,GENVALUE05,GENOPTIONS06,GENPURPOSE06,GENVALUE06,GENOPTIONS07,GENPURPOSE07,GENVALUE07,GENOPTIONS08,GENPURPOSE08,GENVALUE08,GENOPTIONS09,GENPURPOSE09,GENVALUE09,GENOPTIONS10,GENPURPOSE10,GENVALUE10,GENOPTIONS11,GENPURPOSE11,GENVALUE11,GENOPTIONS12,GENPURPOSE12,GENVALUE12,GENOPTIONS13,GENPURPOSE13,GENVALUE13,GENOPTIONS14,GENPURPOSE14,GENVALUE14,GENOPTIONS15,GENPURPOSE15,GENVALUE15,GENOPTIONS16,GENPURPOSE16,GENVALUE16,GENOPTIONS17,GENPURPOSE17,GENVALUE17,GENOPTIONS18,GENPURPOSE18,GENVALUE18,GENOPTIONS19,GENPURPOSE19,GENVALUE19,GENOPTIONS20,GENPURPOSE20,GENVALUE20,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.ROW,b.GENOPTIONS01,b.GENPURPOSE01,b.GENVALUE01,b.GENOPTIONS02,b.GENPURPOSE02,b.GENVALUE02,b.GENOPTIONS03,b.GENPURPOSE03,b.GENVALUE03,b.GENOPTIONS04,b.GENPURPOSE04,b.GENVALUE04,b.GENOPTIONS05,b.GENPURPOSE05,b.GENVALUE05,b.GENOPTIONS06,b.GENPURPOSE06,b.GENVALUE06,b.GENOPTIONS07,b.GENPURPOSE07,b.GENVALUE07,b.GENOPTIONS08,b.GENPURPOSE08,b.GENVALUE08,b.GENOPTIONS09,b.GENPURPOSE09,b.GENVALUE09,b.GENOPTIONS10,b.GENPURPOSE10,b.GENVALUE10,b.GENOPTIONS11,b.GENPURPOSE11,b.GENVALUE11,b.GENOPTIONS12,b.GENPURPOSE12,b.GENVALUE12,b.GENOPTIONS13,b.GENPURPOSE13,b.GENVALUE13,b.GENOPTIONS14,b.GENPURPOSE14,b.GENVALUE14,b.GENOPTIONS15,b.GENPURPOSE15,b.GENVALUE15,b.GENOPTIONS16,b.GENPURPOSE16,b.GENVALUE16,b.GENOPTIONS17,b.GENPURPOSE17,b.GENVALUE17,b.GENOPTIONS18,b.GENPURPOSE18,b.GENVALUE18,b.GENOPTIONS19,b.GENPURPOSE19,b.GENVALUE19,b.GENOPTIONS20,b.GENPURPOSE20,b.GENVALUE20,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".GENOPTIONS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".BLOBDATA a SET(SID,FROMTABLE,FROMKEY,QUALIFIER,SEQUENCE,TYPE,DATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.FROMTABLE,b.FROMKEY,b.QUALIFIER,b.SEQUENCE,b.TYPE,b.DATA,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".BLOBDATA_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CLOBDATA a SET(SID,FROMTABLE,FROMKEY,QUALIFIER,SEQUENCE,TYPE,DATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(b.SID,b.FROMTABLE,b.FROMKEY,b.QUALIFIER,b.SEQUENCE,b.TYPE,b.DATA,b.STATUSFL,b.STATUSFLDT,b.NOTES,b.OWNER,b.OWNER2)FROM "+schemaName+".CLOBDATA_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CONTROLUSAGEBYPERIODS a SET(SID,CTLUSAGETRACKERID,DESCRIPT,CONTROLCODE,CURRENCY,PERIOD0LABEL,PERIOD0B,PERIOD0,PERIODTOTALSLABEL,PERIODTOTALSB,PERIODTOTALS,PERIOD1LABEL,PERIOD1BUDGET,PERIOD1ACTUAL,PERIOD2LABEL,PERIOD2B,PERIOD2,PERIOD3LABEL,PERIOD3B,PERIOD3,PERIOD4LABEL,PERIOD4B,PERIOD4,PERIOD5LABEL,PERIOD5B,PERIOD5,PERIOD6LABEL,PERIOD6B,PERIOD6,PERIOD7LABEL,PERIOD7B,PERIOD7,PERIOD8LABEL,PERIOD8B,PERIOD8,PERIOD9LABEL,PERIOD9B,PERIOD9,PERIOD10LABEL,PERIOD10B,PERIOD10,PERIOD11LABEL,PERIOD11B,PERIOD11,PERIOD12LABEL,PERIOD12B,PERIOD12,PERIODNLABEL,PERIODNB,PERIODN,NOTES,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.CTLUSAGETRACKERID,b.DESCRIPT,b.CONTROLCODE,b.CURRENCY,b.PERIOD0LABEL,b.PERIOD0B,b.PERIOD0,b.PERIODTOTALSLABEL,b.PERIODTOTALSB,b.PERIODTOTALS,b.PERIOD1LABEL,b.PERIOD1BUDGET,b.PERIOD1ACTUAL,b.PERIOD2LABEL,b.PERIOD2B,b.PERIOD2,b.PERIOD3LABEL,b.PERIOD3B,b.PERIOD3,b.PERIOD4LABEL,b.PERIOD4B,b.PERIOD4,b.PERIOD5LABEL,b.PERIOD5B,b.PERIOD5,b.PERIOD6LABEL,b.PERIOD6B,b.PERIOD6,b.PERIOD7LABEL,b.PERIOD7B,b.PERIOD7,b.PERIOD8LABEL,b.PERIOD8B,b.PERIOD8,b.PERIOD9LABEL,b.PERIOD9B,b.PERIOD9,b.PERIOD10LABEL,b.PERIOD10B,b.PERIOD10,b.PERIOD11LABEL,b.PERIOD11B,b.PERIOD11,b.PERIOD12LABEL,b.PERIOD12B,b.PERIOD12,b.PERIODNLABEL,b.PERIODNB,b.PERIODN,b.NOTES,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".CONTROLUSAGEBYPERIODS_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RESOURCE_BUNDLE a SET(SID,NAME,LANGUAGE,COUNTRY,VARIANT,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.NAME,b.LANGUAGE,b.COUNTRY,b.VARIANT,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".RESOURCE_BUNDLE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RESOURCE a SET(SID,_KEY,_VALUE,RESOURCEBUNDLE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b._KEY,b._VALUE,b.RESOURCEBUNDLE,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".RESOURCE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".TRUEFALSE a SET(SID,TABLENAME,QUALIFIER,SHOW001,SHOW002,SHOW003,SHOW004,SHOW005,SHOW006,SHOW007,SHOW008,SHOW009,SHOW010,SHOW011,SHOW012,SHOW013,SHOW014,SHOW015,SHOW016,SHOW017,SHOW018,SHOW019,SHOW020,SHOW021,SHOW022,SHOW023,SHOW024,SHOW025,SHOW026,SHOW027,SHOW028,SHOW029,SHOW030,SHOW031,SHOW032,SHOW033,SHOW034,SHOW035,SHOW036,SHOW037,SHOW038,SHOW039,SHOW040,SHOW041,SHOW042,SHOW043,SHOW044,SHOW045,SHOW046,SHOW047,SHOW048,SHOW049,SHOW050,SHOW051,SHOW052,SHOW053,SHOW054,SHOW055,SHOW056,SHOW057,SHOW058,SHOW059,SHOW060,SHOW061,SHOW062,SHOW063,SHOW064,SHOW065,SHOW066,SHOW067,SHOW068,SHOW069,SHOW070,SHOW071,SHOW072,SHOW073,SHOW074,SHOW075,SHOW076,SHOW077,SHOW078,SHOW079,SHOW080,SHOW081,SHOW082,SHOW083,SHOW084,SHOW085,SHOW086,SHOW087,SHOW088,SHOW089,SHOW090,SHOW091,SHOW092,SHOW093,SHOW094,SHOW095,SHOW096,SHOW097,SHOW098,SHOW099,SHOW100,SHOW101,SHOW102,SHOW103,SHOW104,SHOW105,SHOW106,SHOW107,SHOW108,SHOW109,SHOW110,SHOW111,SHOW112,SHOW113,SHOW114,SHOW115,SHOW116,SHOW117,SHOW118,SHOW119,SHOW120,SHOW121,SHOW122,SHOW123,SHOW124,SHOW125,SHOW126,SHOW127,SHOW128,SHOW129,SHOW130,SHOW131,SHOW132,SHOW133,SHOW134,SHOW135,SHOW136,SHOW137,SHOW138,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(b.SID,b.TABLENAME,b.QUALIFIER,b.SHOW001,b.SHOW002,b.SHOW003,b.SHOW004,b.SHOW005,b.SHOW006,b.SHOW007,b.SHOW008,b.SHOW009,b.SHOW010,b.SHOW011,b.SHOW012,b.SHOW013,b.SHOW014,b.SHOW015,b.SHOW016,b.SHOW017,b.SHOW018,b.SHOW019,b.SHOW020,b.SHOW021,b.SHOW022,b.SHOW023,b.SHOW024,b.SHOW025,b.SHOW026,b.SHOW027,b.SHOW028,b.SHOW029,b.SHOW030,b.SHOW031,b.SHOW032,b.SHOW033,b.SHOW034,b.SHOW035,b.SHOW036,b.SHOW037,b.SHOW038,b.SHOW039,b.SHOW040,b.SHOW041,b.SHOW042,b.SHOW043,b.SHOW044,b.SHOW045,b.SHOW046,b.SHOW047,b.SHOW048,b.SHOW049,b.SHOW050,b.SHOW051,b.SHOW052,b.SHOW053,b.SHOW054,b.SHOW055,b.SHOW056,b.SHOW057,b.SHOW058,b.SHOW059,b.SHOW060,b.SHOW061,b.SHOW062,b.SHOW063,b.SHOW064,b.SHOW065,b.SHOW066,b.SHOW067,b.SHOW068,b.SHOW069,b.SHOW070,b.SHOW071,b.SHOW072,b.SHOW073,b.SHOW074,b.SHOW075,b.SHOW076,b.SHOW077,b.SHOW078,b.SHOW079,b.SHOW080,b.SHOW081,b.SHOW082,b.SHOW083,b.SHOW084,b.SHOW085,b.SHOW086,b.SHOW087,b.SHOW088,b.SHOW089,b.SHOW090,b.SHOW091,b.SHOW092,b.SHOW093,b.SHOW094,b.SHOW095,b.SHOW096,b.SHOW097,b.SHOW098,b.SHOW099,b.SHOW100,b.SHOW101,b.SHOW102,b.SHOW103,b.SHOW104,b.SHOW105,b.SHOW106,b.SHOW107,b.SHOW108,b.SHOW109,b.SHOW110,b.SHOW111,b.SHOW112,b.SHOW113,b.SHOW114,b.SHOW115,b.SHOW116,b.SHOW117,b.SHOW118,b.SHOW119,b.SHOW120,b.SHOW121,b.SHOW122,b.SHOW123,b.SHOW124,b.SHOW125,b.SHOW126,b.SHOW127,b.SHOW128,b.SHOW129,b.SHOW130,b.SHOW131,b.SHOW132,b.SHOW133,b.SHOW134,b.SHOW135,b.SHOW136,b.SHOW137,b.SHOW138,b.STATUSFL,b.STATUSFLDT,b.OWNER,b.OWNER2)FROM "+schemaName+".TRUEFALSE_c b where((b.sid=a.sid) AND (b.STATUSFLDT<>a.STATUSFLDT) and b.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("restored from system backup, removed")+": "+deletedCount+" "+ bundle.getString("updated")+": "+updatedCount+" "+bundle.getString("inserted")+": "+insertedCount,""));

*/
// update client record field cadcsize to show last restoredate as a varchar
     sqlScript="update "+schemaName+".client set cadcsize=:restoredts where owner2=:owner2Code";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2Code", owner2Code).setParameter("restoredts", sdf.format(calendar.getTime()));
      q.executeUpdate();

} catch (Exception e) {
                        int len=sqlScript.length();
                        len=len>120?120:len;
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+bundle.getString("in")+" "+bundle.getString("system")+" "+bundle.getString("restore")+" "+sqlScript.substring(0,len) + ", "+e.getMessage(),""));


}
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
     FacesMessage.SEVERITY_INFO,bundle.getString("restore-")+" "+bundle.getString("removed")+": "+deletedCount+" "+bundle.getString("inserted")+": "+insertedCount,""));

	 return "restore done";
     }




    public String  backupTable(String entityName) {
     //Added in BackUp page SqlAdmin-backUp.xhtml. tableName cmes as entityName
     //sqlScript tableName is like customer not entityName like "+schemaName+".com...customer
    String tableName=entityName.substring(47);
    String sqlScript ="";
    try{
     int deletedCount=0;
     Integer updatedCount=0;
     int insertedCount=0;
     sqlScript="delete from "+schemaName+"."+tableName+"_b a where  a.owner2=:owner2";
     Query q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+tableName+bundle.getString("_b")+" "+bundle.getString("count")+" "+(deletedCount),""));

     // copy all records from _a into _b for one table only for situations where not sure about a big change in tables
     // like rate1f, since only one table need to be restored, so risk is less
      sqlScript="insert into "+schemaName+"."+tableName+"_b select * from "+schemaName+"."+tableName+" a where  not exists (select sid from "+schemaName+"."+tableName+"_b b where b.sid = a.sid)";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      return "inserted count "+insertedCount;

    } catch (Exception e) {
      int len=sqlScript.length();
      len=len>120?120:len;
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+bundle.getString("in")+" "+bundle.getString("table")+" "+tableName+" "+bundle.getString("backup")+": "+sqlScript.substring(0,len) + ", "+e.getMessage(),""));
      return "inserted count "+0;
    }
}

    public String  restoreTable(String entityName) {
     // Added in BackUp page SqlAdmin-backUp.xhtml
     //reverse of backup ie delete _a first then insert _b to -a
     //sqlScript tableName is like customer not entityName like "+schemaName+".com...customer
    String tableName=entityName.substring(47);

    String sqlScript ="";
    try{
     int deletedCount=0;
     Integer updatedCount=0;
     int insertedCount=0;
     sqlScript="delete from "+schemaName+"."+tableName+"_a a where  a.owner2=:owner2";
     Query q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+tableName+bundle.getString("_a")+" "+bundle.getString("count")+" "+(deletedCount),""));

     // copy all records from _b into _a for one table only for situations where not sure about a big change in tables
     // like rate1f, since only one table need to be restored, so risk is less
      sqlScript="insert into "+schemaName+"."+tableName+"_a select * from "+schemaName+"."+tableName+" b where  not exists (select sid from "+schemaName+"."+tableName+"_b b where b.sid = a.sid)";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      return "inserted count "+insertedCount;

    } catch (Exception e) {
      int len=sqlScript.length();
      len=len>120?120:len;
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+bundle.getString("in")+" "+bundle.getString("table")+" "+tableName+" "+bundle.getString("backup")+": "+sqlScript.substring(0,len) + ", "+e.getMessage(),""));
      return "inserted count "+0;
    }
}


	public String  backupTenantC() {
      //backup site data  to -C, daily backup also affects -C but for all sites
      // allows users have choice -b or _c data to restore from
      // C:\schemaspygui\postgres_postgre_ has tables relation and dependency info like deletionOrder.txt
      // add a lock ??
      // to file not used since in cloud pl/sql does not seem to have access to files
      // this backUp is on demand and done by tenant
      // there is daily backup to tables for all tenants while app is up and also a separate sbnapshot daily backup when app is stopped
      // snapshot is on file and meant for disaster situation
      //
      // 1-remove rows from backup if not in main ie any old (ie not used) rows in backup will be removed
      // 2-insert into backup if new rows in main
      // 3-update backup if row in main has different change time  (relies on statusfldate change)
      // follow the deletion order list produced by schemaspygui C:\schemaspygui\postgres_postgre_\deletionOrder.txt ( future use the list as input to automate )
      // insertionOrder.txt for insert, for update order does not matter because we are not dropping or adding any relation but will follow
      // insertionOrder.txt
      // resource_bundle,resource,clob and blob have SYSTEM records which need extra logic
      // SYSTEM records should not be deleted from main or backup table but should be copied into backup if needed ??? revisit
      // SELECT * FROM information_schema.columns WHERE table_schema = 'genapp'  AND table_name   = 'client'
      //use DatabaseMetaData, as in authenticator.java, to avoid harcoding here
      //using jdbc connection to get database metadata rather than entitymanager way to be ORM neutral
      DatabaseMetaData databaseMetaData=null;
      String productName="";
      String dbProductName="hsql";
      if(schemaName == null || schemaName.isEmpty()){
       schemaName="genapp";
      }
      try(Connection conn = getConnection();){
       databaseMetaData = conn.getMetaData();
       productName = databaseMetaData.getDatabaseProductName();
      } catch (Exception e) {
       log.severe("No datasouce connection or databaseMetaData, Cannot continue");
       return null;
      }
      if(productName==null || productName.isEmpty()){
       log.severe("No datasouce setup yet, check tomee.xml or standalone.xml etc. Cannot continue");
       return null;
      }
      if(productName.contains("PostgreSQL")){
       dbProductName="psql";
      }

     String sqlScript ="";
try{
     int deletedCount=0;
     int updatedCount=0;
     int insertedCount=0;
     int countp=0;

     sqlScript="delete from "+schemaName+".serialnumbers_c b where   b.owner2=:owner2 and not exists  (select sid from "+schemaName+".serialnumbers a where  a.sid = b.sid and a.owner2=:owner2)";
     Query q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("serialnumbers_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".scandate_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".scandate a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("scandate_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".rate1f_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rate1f a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("rate1f_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".options_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".options a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("options_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".nextserialno_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".nextserialno a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("nextserialno_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".journal_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".journal a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
      FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("journal_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".jjournal_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".jjournal a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".hlogfile_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".hlogfile a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".genoptions_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".genoptions a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".editlog_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".editlog a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".clobdata_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".clobdata a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cjournal_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cjournal a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".blobdata_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".blobdata a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".arthatbl_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".arthatbl a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".arthahist_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".arthahist a where  a.sid = b.sid and a.owner2=:owner2)";
     q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".acperiod_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".acperiod a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".jobassignment_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".jobassignment a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".schedule_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".schedule a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vshipmendetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vshipmendetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vcontact_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vcontact a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".shipmentdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".shipmentdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".ccontact_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".ccontact a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendqdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendqdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendpdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendpdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendodetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendodetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendidetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendidetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".resourcedetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resourcedetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".processdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".processdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".emplodetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".emplodetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuqdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuqdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuodetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuodetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuidetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuidetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".usagebyperiods_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".usagebyperiods a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgenfields_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgenfields a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".itembomdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".itembomdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".holiday_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".holiday a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".gentriesdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".gentriesdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cupdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cupdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activityjobdetails_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".activityjobdetails a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".wageearneraux_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".wageearneraux a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".venartha_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".venartha a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".userprofl_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".userprofl a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".resource_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resource a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".processattributes_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".processattributes a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".controlusagebyperiods_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".controlusagebyperiods a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".acintegr_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".acintegr a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".\"USER_c\" b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".\"USER\" a where  a.sid = b.sid and a.owner2=:owner2)";
     if(dbProductName.equals("psql")){
      sqlScript="delete from "+schemaName+".\"user_c\" b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".\"user\" a where  a.sid = b.sid and a.owner2=:owner2)";
     }

      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".emplorders_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".emplorders a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vpayment_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vpayment a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".task_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".task a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cpayment_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cpayment a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".glentries_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".glentries a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".controlusagebyperiods_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".controlusagebyperiods a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activityjob_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".activityjob a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".wageearner_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".wageearner a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".rgentable_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgentable a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".itemjob_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".itemjob a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vshipmen_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vshipmen a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".groupmembers_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".groupmembers a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vinvoice_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vinvoice a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".shipment_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".shipment a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendorders_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendorders a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuinvoice_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuinvoice a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuorders_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuorders a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".project_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".project a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".outline_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".outline a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".venquote_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".venquote a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".cuquote_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".cuquote a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".machine_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".machine a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".activity_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".activity a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".item_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".item a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".employee_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".employee a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".customer_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".customer a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".vendor_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".vendor a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

     sqlScript="delete from "+schemaName+".location_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".location a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("location_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;
     sqlScript="delete from "+schemaName+".account_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".account a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();
     FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("delete")+" "+bundle.getString("account_c")+" "+bundle.getString("count")+" "+(deletedCount-countp),""));
     countp=deletedCount;

     sqlScript="delete from "+schemaName+".rgendb_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgendb a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".company_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".company a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".rollupgroup_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rollupgroup a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".rgenapp_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".rgenapp a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".resource_bundle_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".resource_bundle a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".perioddates_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".perioddates a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".itembom_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".itembom a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where  a.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

     sqlScript="delete from "+schemaName+".control_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".control a where  a.sid = b.sid and a.owner2=:owner2 )";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".client_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".client a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".residency_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".residency a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".membersgroup_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".membersgroup a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".division_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".division a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".department_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".department a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();


     sqlScript="delete from "+schemaName+".address_c b where   b.owner2=:owner2  and  not exists  (select sid from "+schemaName+".address a where  a.sid = b.sid and a.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
     q.setParameter("owner2", owner2Code);
     deletedCount = deletedCount +q.executeUpdate();





     // insert into backup if new rows in main
     // follow insertionOrder.txt produced by schemaSpyGui which is in reverse order of deleteOrder.txt.

      sqlScript="insert into "+schemaName+".address_c select * from "+schemaName+".address a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".address_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".department_c select * from "+schemaName+".department a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".department_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".division_c select * from "+schemaName+".division a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".division_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".membersgroup_c select * from "+schemaName+".membersgroup a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".membersgroup_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".residency_c select * from "+schemaName+".residency a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".residency_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".client_c select * from "+schemaName+".client a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".client_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".control_c select * from "+schemaName+".control a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".control_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itembom_c select * from "+schemaName+".itembom a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".itembom_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".resource_bundle_c select * from "+schemaName+".resource_bundle a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".resource_bundle_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", "SYSTEM");
      insertedCount=insertedCount+q.executeUpdate();
      }


      sqlScript="insert into "+schemaName+".perioddates_c select * from "+schemaName+".perioddates a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".perioddates_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rgenapp_c select * from "+schemaName+".rgenapp a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgenapp_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rollupgroup_c select * from "+schemaName+".rollupgroup a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".rollupgroup_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".company_c select * from "+schemaName+".company a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".company_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".rgendb_c select * from "+schemaName+".rgendb a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgendb_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("insert")+" "+bundle.getString("rgendb_c ")+" "+bundle.getString("count")+" "+(insertedCount-countp),""));
      countp=insertedCount;

      sqlScript="insert into "+schemaName+".account_c select * from "+schemaName+".account a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".account_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("insert")+" "+bundle.getString("account_c ")+" "+bundle.getString("count")+" "+(insertedCount-countp),""));
      countp=insertedCount;

      sqlScript="insert into "+schemaName+".location_c select * from "+schemaName+".location a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".location_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vendor_c select * from "+schemaName+".vendor a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendor_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".customer_c select * from "+schemaName+".customer a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".customer_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".employee_c select * from "+schemaName+".employee a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".employee_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".item_c select * from "+schemaName+".item a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".item_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".activity_c select * from "+schemaName+".activity a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".activity_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".machine_c select * from "+schemaName+".machine a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".machine_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuquote_c select * from "+schemaName+".cuquote a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuquote_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".venquote_c select * from "+schemaName+".venquote a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".venquote_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".outline_c select * from "+schemaName+".outline a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".outline_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".project_c select * from "+schemaName+".project a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".project_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuorders_c select * from "+schemaName+".cuorders a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuorders_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vendorders_c select * from "+schemaName+".vendorders a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendorders_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vshipmen_c select * from "+schemaName+".vshipmen a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vshipmen_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".cuinvoice_c select * from "+schemaName+".cuinvoice a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuinvoice_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".shipment_c select * from "+schemaName+".shipment a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".shipment_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".vinvoice_c select * from "+schemaName+".vinvoice a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vinvoice_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".groupmembers_c select * from "+schemaName+".groupmembers a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".groupmembers_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".processdetails_c select * from "+schemaName+".processdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".processdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itemjob_c select * from "+schemaName+".itemjob a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".itemjob_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".rgentable_c select * from "+schemaName+".rgentable a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgentable_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".wageearner_c select * from "+schemaName+".wageearner a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".wageearner_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".activityjob_c select * from "+schemaName+".activityjob a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".activityjob_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".glentries_c select * from "+schemaName+".glentries a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".glentries_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cpayment_c select * from "+schemaName+".cpayment a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cpayment_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".task_c select * from "+schemaName+".task a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".task_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vpayment_c select * from "+schemaName+".vpayment a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vpayment_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".emplorders_c select * from "+schemaName+".emplorders a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".emplorders_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


     sqlScript="insert into "+schemaName+".\"USER_c\" select * from "+schemaName+".user a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".\"USER_c\" b where b.sid = a.sid and b.owner2=:owner2)";
     if(dbProductName.equals("psql")){
      sqlScript="insert into "+schemaName+".\"user_c\" select * from "+schemaName+".user a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".\"user_c\" b where b.sid = a.sid and b.owner2=:owner2)";
     }
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".acintegr_c select * from "+schemaName+".acintegr a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".acintegr_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".controlusagebyperiods_c select * from "+schemaName+".controlusagebyperiods a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".controlusagebyperiods_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".processattributes_c select * from "+schemaName+".processattributes a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".processattributes_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".resource_c select * from "+schemaName+".resource a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".resource_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".resource_c select * from "+schemaName+".resource a where  a.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".resource_c b where b.sid = a.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".userprofl_c select * from "+schemaName+".userprofl a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".userprofl_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".venartha_c select * from "+schemaName+".venartha a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".venartha_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".wageearneraux_c select * from "+schemaName+".wageearneraux a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".wageearneraux_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".activityjobdetails_c select * from "+schemaName+".activityjobdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".activityjobdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cupdetails_c select * from "+schemaName+".cupdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cupdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".gentriesdetails_c select * from "+schemaName+".gentriesdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".gentriesdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".holiday_c select * from "+schemaName+".holiday a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".holiday_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      sqlScript="insert into "+schemaName+".itembomdetails_c select * from "+schemaName+".itembomdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".itembomdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();




      sqlScript="insert into "+schemaName+".rgenfields_c select * from "+schemaName+".rgenfields a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".rgenfields_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".usagebyperiods_c select * from "+schemaName+".usagebyperiods a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".usagebyperiods_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuidetails_c select * from "+schemaName+".cuidetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuidetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuodetails_c select * from "+schemaName+".cuodetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuodetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".cuqdetails_c select * from "+schemaName+".cuqdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cuqdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".emplodetails_c select * from "+schemaName+".emplodetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".emplodetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".resourcedetails_c select * from "+schemaName+".resourcedetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".resourcedetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendidetails_c select * from "+schemaName+".vendidetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendidetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendodetails_c select * from "+schemaName+".vendodetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendodetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendpdetails_c select * from "+schemaName+".vendpdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendpdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vendqdetails_c select * from "+schemaName+".vendqdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vendqdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".ccontact_c select * from "+schemaName+".ccontact a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".ccontact_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".shipmentdetails_c select * from "+schemaName+".shipmentdetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".shipmentdetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vcontact_c select * from "+schemaName+".vcontact a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vcontact_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".vshipmendetails_c select * from "+schemaName+".vshipmendetails a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".vshipmendetails_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".schedule_c select * from "+schemaName+".schedule a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".schedule_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".jobassignment_c select * from "+schemaName+".jobassignment a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".jobassignment_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".acperiod_c select * from "+schemaName+".acperiod a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".acperiod_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".arthahist_c select * from "+schemaName+".arthahist a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".arthahist_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".arthatbl_c select * from "+schemaName+".arthatbl a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".arthatbl_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".holiday_c select * from "+schemaName+".holiday a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".holiday_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".blobdata_c select * from "+schemaName+".blobdata a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".blobdata_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".blobdata_c select * from "+schemaName+".blobdata a where  a.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".blobdata_c b where b.sid = a.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".cjournal_c select * from "+schemaName+".cjournal a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".cjournal_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".clobdata_c select * from "+schemaName+".clobdata a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".clobdata_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();

      if(customIdentity.isMasterSite()){
      sqlScript="insert into "+schemaName+".clobdata_c select * from "+schemaName+".clobdata a where  a.owner2='SYSTEM'  and  not exists (select sid from "+schemaName+".clobdata_c b where b.sid = a.sid and b.owner2='SYSTEM')";
      q = entityManager.createNativeQuery(sqlScript);
      insertedCount=insertedCount+q.executeUpdate();
      }

      sqlScript="insert into "+schemaName+".editlog_c select * from "+schemaName+".editlog a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".editlog_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".genoptions_c select * from "+schemaName+".genoptions a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".genoptions_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".hlogfile_c select * from "+schemaName+".hlogfile a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".hlogfile_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".jjournal_c select * from "+schemaName+".jjournal a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".jjournal_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".journal_c select * from "+schemaName+".journal a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".journal_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".nextserialno_c select * from "+schemaName+".nextserialno a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".nextserialno_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".options_c select * from "+schemaName+".options a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".options_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".rate1f_c select * from "+schemaName+".rate1f a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".rate1f_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".scandate_c select * from "+schemaName+".scandate a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".scandate_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();


      sqlScript="insert into "+schemaName+".serialnumbers_c select * from "+schemaName+".serialnumbers a where  a.owner2=:owner2  and  not exists (select sid from "+schemaName+".serialnumbers_c b where b.sid = a.sid and b.owner2=:owner2)";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2", owner2Code);
      insertedCount=insertedCount+q.executeUpdate();





      // update backup if row in main has changed (relies on statusfldate change)
      // jay whats about those not having statusfldt? either add field or rely on parent status fld
      // and group the updates together  posting date used for journal,glentries
      // order should not matter because all the foreign keys should exist but will follow insert order
//postgresql UPDATE genapp.journal_b SET sid=a.sid,spostdate=a.spostdate,postdate=a.postdate,owner2=a.owner2 FROM  genapp.journal a  where(genapp.journal_b.sid=a.sid AND a.postdate<>genapp.journal_b.postdate AND a.owner2='localhost')
//hsqldb or stanard UPDATE genapp.journal_b b SET (sid,spostdate,postdate,owner2)=(SELECT sid,spostdate,postdate,owner2 FROM  genapp.journal a where b.sid=a.sid AND a.postdate<>b.postdate AND a.owner2='localhost')
sqlScript="UPDATE "+schemaName+".journal_b b SET(sid,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,statusfl,owner,owner2)=(SELECT sid,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,statusfl,owner,owner2 FROM "+schemaName+".journal a where a.sid=b.sid AND a.postdate<>b.postdate and a.owner2=:owner2)";
if(dbProductName.equals("psql")){
 sqlScript="UPDATE "+schemaName+".journal_b SET sid=a.sid,a.spostdate=a.spostdate,postdate=a.postdate,calendardt=a.calendardt,jrnltype=a.jrnltype,jnlseqb=,jnlseq=a.jnlseq,jnlseqs=a.jnlseqs,period=a.period,account=a.account,debit=a.debit,credit=a.credit,xreference=a.xreference,descript=a.descript,statusfl=a.statusfl,owner=a.owner,owner2=a.owner2) FROM "+schemaName+".journal a where(genapp.journal_b.sid=a.sid AND a.postdate<>genapp.journal_b.postdate AND a.owner2=:owner2)";
}
/*

//?? update now done jay except for rate1f which now has statusfldt done now  but check others which manually changed
// included journal using postingdate and gl, gldetails using statusfldt.

sqlScript="UPDATE "+schemaName+".JOURNAL_c b SET(SID,spostdate,postdate,calendardt,jrnltype,jnlseqb,jnlseq,jnlseqs,period,account,debit,credit,xreference,descript,STATUSFL,OWNER,OWNER2)=(a.SID,a.spostdate,a.postdate,a.calendardt,a.jrnltype,a.jnlseqb,a.jnlseq,a.jnlseqs,a.period,a.account,a.debit,a.credit,a.xreference,a.descript,a.STATUSFL,a.OWNER,a.OWNER2)FROM "+schemaName+".journal a where((a.sid=b.sid) AND (a.postdate<>b.postdate) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".gentriesdetails_c b SET(SID,glentrysidno,line,depcode,divcode,account,debitamt,creditamt,linetotl,notes,STATUSFL,statusfldt,OWNER,OWNER2)=(a.SID,a.glentrysidno,a.line,a.depcode,a.divcode,a.account,a.debitamt,a.creditamt,a.linetotl,a.notes,a.STATUSFL,a.statusfldt,a.OWNER,a.OWNER2)FROM "+schemaName+".gentriesdetails a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".glentries_c b SET(SID,glentryno,descript,refcode,period,postdate,calendardt,depcode,divcode,account,tdebitamt,tcreditamt,notes,STATUSFL,statusfldt,OWNER,OWNER2)=(a.SID,a.glentryno,a.descript,a.refcode,a.period,a.postdate,a.calendardt,a.depcode,a.divcode,a.account,a.tdebitamt,a.tcreditamt,a.notes,a.STATUSFL,a.statusfldt,a.OWNER,a.OWNER2)FROM "+schemaName+".glentries a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ADDRESS_c b SET(SID,ADDRESCODE,ADDRL1,ADDRL2,ADDRL3,CITY,PROVNSTATE,COUNTRY,PZCODE,DESCRIPT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,PRINTMSTAT,PRINMTFLDT)=(a.SID,a.ADDRESCODE,a.ADDRL1,a.ADDRL2,a.ADDRL3,a.CITY,a.PROVNSTATE,a.COUNTRY,a.PZCODE,a.DESCRIPT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.PRINTMSTAT,a.PRINMTFLDT)FROM "+schemaName+".address a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".OPTIONS_c b SET(SID,ROW,OPTIONS01,PURPOSE01,VALUE01,OPTIONS02,PURPOSE02,VALUE02,OPTIONS03,PURPOSE03,VALUE03,OPTIONS04,PURPOSE04,VALUE04,OPTIONS05,PURPOSE05,VALUE05,OPTIONS06,PURPOSE06,VALUE06,OPTIONS07,PURPOSE07,VALUE07,OPTIONS08,PURPOSE08,VALUE08,OPTIONS09,PURPOSE09,VALUE09,OPTIONS10,PURPOSE10,VALUE10,OPTIONS11,PURPOSE11,VALUE11,OPTIONS12,PURPOSE12,VALUE12,OPTIONS13,PURPOSE13,VALUE13,OPTIONS14,PURPOSE14,VALUE14,OPTIONS15,PURPOSE15,VALUE15,OPTIONS16,PURPOSE16,VALUE16,OPTIONS17,PURPOSE17,VALUE17,OPTIONS18,PURPOSE18,VALUE18,OPTIONS19,PURPOSE19,VALUE19,OPTIONS20,PURPOSE20,VALUE20,OPTIONS21,PURPOSE21,VALUE21,OPTIONS22,PURPOSE22,VALUE22,OPTIONS23,PURPOSE23,VALUE23,OPTIONS24,PURPOSE24,VALUE24,OPTIONS25,PURPOSE25,VALUE25,OPTIONS26,PURPOSE26,VALUE26,OPTIONS27,PURPOSE27,VALUE27,OPTIONS28,PURPOSE28,VALUE28,OPTIONS29,PURPOSE29,VALUE29,OPTIONS30,PURPOSE30,VALUE30,OPTIONS31,PURPOSE31,VALUE31,OPTIONS32,PURPOSE32,VALUE32,OPTIONS33,PURPOSE33,VALUE33,OPTIONS34,PURPOSE34,VALUE34,OPTIONS35,PURPOSE35,VALUE35,OPTIONS36,PURPOSE36,VALUE36,OPTIONS37,PURPOSE37,VALUE37,OPTIONS38,PURPOSE38,VALUE38,OPTIONS39,PURPOSE39,VALUE39,OPTIONS40,PURPOSE40,VALUE40,OPTIONS41,PURPOSE41,VALUE41,OPTIONS42,PURPOSE42,VALUE42,OPTIONS43,PURPOSE43,VALUE43,OPTIONS44,PURPOSE44,VALUE44,OPTIONS45,PURPOSE45,VALUE45,OPTIONS46,PURPOSE46,VALUE46,OPTIONS47,PURPOSE47,VALUE47,OPTIONS48,PURPOSE48,VALUE48,OPTIONS49,PURPOSE49,VALUE49,OPTIONS50,PURPOSE50,VALUE50,OPTIONS51,PURPOSE51,VALUE51,OPTIONS52,PURPOSE52,VALUE52,OPTIONS53,PURPOSE53,VALUE53,OPTIONS54,PURPOSE54,VALUE54,OPTIONS55,PURPOSE55,VALUE55,OPTIONS56,PURPOSE56,VALUE56,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.ROW,a.OPTIONS01,a.PURPOSE01,a.VALUE01,a.OPTIONS02,a.PURPOSE02,a.VALUE02,a.OPTIONS03,a.PURPOSE03,a.VALUE03,a.OPTIONS04,a.PURPOSE04,a.VALUE04,a.OPTIONS05,a.PURPOSE05,a.VALUE05,a.OPTIONS06,a.PURPOSE06,a.VALUE06,a.OPTIONS07,a.PURPOSE07,a.VALUE07,a.OPTIONS08,a.PURPOSE08,a.VALUE08,a.OPTIONS09,a.PURPOSE09,a.VALUE09,a.OPTIONS10,a.PURPOSE10,a.VALUE10,a.OPTIONS11,a.PURPOSE11,a.VALUE11,a.OPTIONS12,a.PURPOSE12,a.VALUE12,a.OPTIONS13,a.PURPOSE13,a.VALUE13,a.OPTIONS14,a.PURPOSE14,a.VALUE14,a.OPTIONS15,a.PURPOSE15,a.VALUE15,a.OPTIONS16,a.PURPOSE16,a.VALUE16,a.OPTIONS17,a.PURPOSE17,a.VALUE17,a.OPTIONS18,a.PURPOSE18,a.VALUE18,a.OPTIONS19,a.PURPOSE19,a.VALUE19,a.OPTIONS20,a.PURPOSE20,a.VALUE20,a.OPTIONS21,a.PURPOSE21,a.VALUE21,a.OPTIONS22,a.PURPOSE22,a.VALUE22,a.OPTIONS23,a.PURPOSE23,a.VALUE23,a.OPTIONS24,a.PURPOSE24,a.VALUE24,a.OPTIONS25,a.PURPOSE25,a.VALUE25,a.OPTIONS26,a.PURPOSE26,a.VALUE26,a.OPTIONS27,a.PURPOSE27,a.VALUE27,a.OPTIONS28,a.PURPOSE28,a.VALUE28,a.OPTIONS29,a.PURPOSE29,a.VALUE29,a.OPTIONS30,a.PURPOSE30,a.VALUE30,a.OPTIONS31,a.PURPOSE31,a.VALUE31,a.OPTIONS32,a.PURPOSE32,a.VALUE32,a.OPTIONS33,a.PURPOSE33,a.VALUE33,a.OPTIONS34,a.PURPOSE34,a.VALUE34,a.OPTIONS35,a.PURPOSE35,a.VALUE35,a.OPTIONS36,a.PURPOSE36,a.VALUE36,a.OPTIONS37,a.PURPOSE37,a.VALUE37,a.OPTIONS38,a.PURPOSE38,a.VALUE38,a.OPTIONS39,a.PURPOSE39,a.VALUE39,a.OPTIONS40,a.PURPOSE40,a.VALUE40,a.OPTIONS41,a.PURPOSE41,a.VALUE41,a.OPTIONS42,a.PURPOSE42,a.VALUE42,a.OPTIONS43,a.PURPOSE43,a.VALUE43,a.OPTIONS44,a.PURPOSE44,a.VALUE44,a.OPTIONS45,a.PURPOSE45,a.VALUE45,a.OPTIONS46,a.PURPOSE46,a.VALUE46,a.OPTIONS47,a.PURPOSE47,a.VALUE47,a.OPTIONS48,a.PURPOSE48,a.VALUE48,a.OPTIONS49,a.PURPOSE49,a.VALUE49,a.OPTIONS50,a.PURPOSE50,a.VALUE50,a.OPTIONS51,a.PURPOSE51,a.VALUE51,a.OPTIONS52,a.PURPOSE52,a.VALUE52,a.OPTIONS53,a.PURPOSE53,a.VALUE53,a.OPTIONS54,a.PURPOSE54,a.VALUE54,a.OPTIONS55,a.PURPOSE55,a.VALUE55,a.OPTIONS56,a.PURPOSE56,a.VALUE56,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".OPTIONS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

String line1="UPDATE "+schemaName+".CLIENT_c b SET(SID,CLIENTVERSION,SERIALNUM,ENTERPRISECOMPANYNA,DESCRIPT,ADDRL1,ADDRL2,ADDRL3,CITY,PROVNSTATE,COUNTRYNAME,PZCODE,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,ENTERPRISECOMPCODE,ENTERPRISECOMPSIZE,BARCSIZE,LEVEL,POSKIPP,LOOSEIT,JOBSKIP,CARTONFL,PICKLIST,PRODDESC,PRODCODE,NJOB,NMATERIA,NACTIVITY,NBUTT,NCUSTOME,NCONTACT,NVENDOR,NEMPLOYEE,NSCHEDULE,NREJECT,NRETURN,NCODE,MANUFID,BARTYPE,CADTYPE,CARTYPE,SHITYPE,REPTYPE,LOCTYPE,BARCOL,CARCOL,CADCOL,SHICOL,REPCOL,LOCCOL,ALTSERIA,COUNTRYCODE,NALTSERI,SCRCOLOR,HILCOLOR,TEXTCOLOR,BACCOLOR,DATETYPE,CURRSYMB,CURRCODE,PRINBAR,BARPRINT,CARPRINT,CADPRINT,LOCPRINT,SHIPRINT,REPPRINT,BARPRTY,REPPRTY,CARPRTY,CADPRTY,SHIPRTY,LOCPRTY,ALTSELEN,CUSTOLEN,CARCSIZE,CADCSIZE,SHICSIZE,REPCSIZE,LOCCSIZE,CS,NCONFTYP,NLOCATIO,NDIVCODE,NDEPCODE,NADDCODE,NFLOOR,NROOM,NRACK,MENUTYPE,PADTYPE,NRATE1TA,NRATE2TA,DEFCONFT,BEEPSOU,CONFIRM,LINEFEED,REFBARADJ,SHIBARADJ,CUSBARADJ,LOCBARADJ,CARBARADJ,NCORDER,NSPERSON,PROMPTI,CUSTOMERQUOTENB,CUSTOMERQUOTEN,CUSTOMERQUOTENA,CUSTOMERORDERNB,CUSTOMERORDERN,CUSTOMERORDERNA,VENDORORDERNB,VENDORORDERN,VENDORORDERNA,EMPLOYEEORDERNB,EMPLOYEEORDERN,EMPLOYEEORDERNA,JOBNB,JOBN,JOBNA,CUSTOMERINVOICENB,CUSTOMERINVOICEN,CUSTOMERINVOICENA,VENDORINVOICENB,VENDORINVOICEN,VENDORINVOICENA,CUSTOMERPICKNB,CUSTOMERPICKN,CUSTOMERPICKNA,VENDORQUOTENB,VENDORQUOTEN,VENDORQUOTENA,CUSTOMERPAYMNTNB,CUSTOMERPAYMNTN,CUSTOMERPAYMNTNA,VENDORPAYMNTNB,VENDORPAYMNTN,VENDORPAYMNTNA,VENDORCHQNB,VENDORCHQN,VENDORCHQNA,TASKNB,TASKN,TASKNA,ARSEQB,ARSEQ,ARSEQA,APSEQB,APSEQ,APSEQA,GLSEQB,GLSEQ,GLSEQA,PASEQB,PASEQ,PASEQA,ICSEQB,ICSEQ,ICSEQA,JOSEQB,JOSEQ,JOSEQA,SGLENTRY,TAX1CODE,TAX2CODE,TAX3CODE,NDECIMAL,EDIPASSW,INTPASSW,INRPASSW,IMLPASSW,RMLPASSW,LMLPASSW,HOSPASSW,LANPASSW,WANPASSW,ASHOSTID,HDSTYLE,MTSTYLE,STSTYLE,DTSTYLE,FTSTYLE,DEFAULTR,DEFAULTC,DBNAME,ROOTDIR,KEYORDER,CURRBUSDAT,LASTBUSDAT,CURRCALDAT,LASTCALDAT,PREPROCESS,MARGIN,FOOTER,LASTUSER,LISTBUILDC,LISTBUILDV,LISTBUILDE,LISTBROWNC,LISTBROWNV,LISTBROWNE,SMTPSERVER,SMTPUSER,SMTPPASS,POP3SERVER,POP3USER,POP3PASS,SMATCODE,FYREND,FPERIODS,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,licensetype,licensestart,licenseend)=(a.sid,a.CLIENTVERSION,a.SERIALNUM,a.ENTERPRISECOMPANYNA,a.DESCRIPT,a.ADDRL1,a.ADDRL2,a.ADDRL3,a.CITY,a.PROVNSTATE,a.COUNTRYNAME,a.PZCODE,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.ENTERPRISECOMPCODE,a.ENTERPRISECOMPSIZE,a.BARCSIZE,a.LEVEL,a.POSKIPP,a.LOOSEIT,a.JOBSKIP,a.CARTONFL,a.PICKLIST,a.PRODDESC,a.PRODCODE,a.NJOB,a.NMATERIA,a.NACTIVITY,a.NBUTT,a.NCUSTOME,a.NCONTACT,a.NVENDOR,a.NEMPLOYEE,a.NSCHEDULE,a.NREJECT,a.NRETURN,a.NCODE,a.MANUFID,a.BARTYPE,a.CADTYPE,a.CARTYPE,a.SHITYPE,a.REPTYPE,a.LOCTYPE,a.BARCOL,a.CARCOL,a.CADCOL,a.SHICOL,a.REPCOL,a.LOCCOL,a.ALTSERIA,a.COUNTRYCODE,a.NALTSERI,a.SCRCOLOR,a.HILCOLOR,";
sqlScript=line1+"a.TEXTCOLOR,a.BACCOLOR,a.DATETYPE,a.CURRSYMB,a.CURRCODE,a.PRINBAR,a.BARPRINT,a.CARPRINT,a.CADPRINT,a.LOCPRINT,a.SHIPRINT,a.REPPRINT,a.BARPRTY,a.REPPRTY,a.CARPRTY,a.CADPRTY,a.SHIPRTY,a.LOCPRTY,a.ALTSELEN,a.CUSTOLEN,a.CARCSIZE,a.CADCSIZE,a.SHICSIZE,a.REPCSIZE,a.LOCCSIZE,a.CS,a.NCONFTYP,a.NLOCATIO,a.NDIVCODE,a.NDEPCODE,a.NADDCODE,a.NFLOOR,a.NROOM,a.NRACK,a.MENUTYPE,a.PADTYPE,a.NRATE1TA,a.NRATE2TA,a.DEFCONFT,a.BEEPSOU,a.CONFIRM,a.LINEFEED,a.REFBARADJ,a.SHIBARADJ,a.CUSBARADJ,a.LOCBARADJ,a.CARBARADJ,a.NCORDER,a.NSPERSON,a.PROMPTI,a.CUSTOMERQUOTENB,a.CUSTOMERQUOTEN,a.CUSTOMERQUOTENA,a.CUSTOMERORDERNB,a.CUSTOMERORDERN,a.CUSTOMERORDERNA,a.VENDORORDERNB,a.VENDORORDERN,a.VENDORORDERNA,a.EMPLOYEEORDERNB,a.EMPLOYEEORDERN,a.EMPLOYEEORDERNA,a.JOBNB,a.JOBN,a.JOBNA,a.CUSTOMERINVOICENB,a.CUSTOMERINVOICEN,a.CUSTOMERINVOICENA,a.VENDORINVOICENB,a.VENDORINVOICEN,a.VENDORINVOICENA,a.CUSTOMERPICKNB,a.CUSTOMERPICKN,a.CUSTOMERPICKNA,a.VENDORQUOTENB,a.VENDORQUOTEN,a.VENDORQUOTENA,a.CUSTOMERPAYMNTNB,a.CUSTOMERPAYMNTN,a.CUSTOMERPAYMNTNA,a.VENDORPAYMNTNB,a.VENDORPAYMNTN,a.VENDORPAYMNTNA,a.VENDORCHQNB,a.VENDORCHQN,a.VENDORCHQNA,a.TASKNB,a.TASKN,a.TASKNA,a.ARSEQB,a.ARSEQ,a.ARSEQA,a.APSEQB,a.APSEQ,a.APSEQA,a.GLSEQB,a.GLSEQ,a.GLSEQA,a.PASEQB,a.PASEQ,a.PASEQA,a.ICSEQB,a.ICSEQ,a.ICSEQA,a.JOSEQB,a.JOSEQ,a.JOSEQA,a.SGLENTRY,a.TAX1CODE,a.TAX2CODE,a.TAX3CODE,a.NDECIMAL,a.EDIPASSW,a.INTPASSW,a.INRPASSW,a.IMLPASSW,a.RMLPASSW,a.LMLPASSW,a.HOSPASSW,a.LANPASSW,a.WANPASSW,a.ASHOSTID,a.HDSTYLE,a.MTSTYLE,a.STSTYLE,a.DTSTYLE,a.FTSTYLE,a.DEFAULTR,a.DEFAULTC,a.DBNAME,a.ROOTDIR,a.KEYORDER,a.CURRBUSDAT,a.LASTBUSDAT,a.CURRCALDAT,a.LASTCALDAT,a.PREPROCESS,a.MARGIN,a.FOOTER,a.LASTUSER,a.LISTBUILDC,a.LISTBUILDV,a.LISTBUILDE,a.LISTBROWNC,a.LISTBROWNV,a.LISTBROWNE,a.SMTPSERVER,a.SMTPUSER,a.SMTPPASS,a.POP3SERVER,a.POP3USER,a.POP3PASS,a.SMATCODE,a.FYREND,a.FPERIODS,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.licensetype,a.licensestart,a.licenseend)FROM "+schemaName+".CLIENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".DEPARTMENT_c b SET(SID,DEPCODE,DESCRIPT,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.DEPCODE,a.DESCRIPT,a.GLPREFIX,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".DEPARTMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".COMPANY_c b SET(SID,COMPANYCODE,DESCRIPT,LEGALNAME,MAILTOCODE,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.COMPANYCODE,a.DESCRIPT,a.LEGALNAME,a.MAILTOCODE,a.GLPREFIX,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".COMPANY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CONTROL_c b SET(SID,CONTROLCODE,DESCRIPT,TYPEOFCONTROL,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.CONTROLCODE,a.DESCRIPT,a.TYPEOFCONTROL,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".CONTROL a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".DIVISION_c b SET(SID,DIVCODE,DESCRIPT,GLPREFIX,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.DIVCODE,a.DESCRIPT,a.GLPREFIX,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".DIVISION a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".LOCATION_c b SET(SID,LOCATION,DESCRIPT,COMPANYCODE,ADDRESSCODE,FLOOR,ROOM,RACK,PRINTMSTAT,PRINMTFLDT,EXCLUDE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.LOCATION,a.DESCRIPT,a.COMPANYCODE,a.ADDRESSCODE,a.FLOOR,a.ROOM,a.RACK,a.PRINTMSTAT,a.PRINMTFLDT,a.EXCLUDE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".LOCATION a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".RESIDENCY_c b SET(SID,RESIDENCY,DESCRIPT,MUNICIPALITY,PROVINCE,COUNTRYNAME,EXCLUDE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.sid,a.RESIDENCY,a.DESCRIPT,a.MUNICIPALITY,a.PROVINCE,a.COUNTRYNAME,a.EXCLUDE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RESIDENCY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
 FacesMessage.SEVERITY_INFO,bundle.getString("update")+" "+bundle.getString("residency_c ")+" "+bundle.getString("count")+" "+(updatedCount-countp),""));
countp=updatedCount;

sqlScript="UPDATE "+schemaName+".ACCOUNT_c b SET(SID,ACCOUNT,DESCRIPT,CATEGORY,TYPE,BUDGET,ACTUAL,ACTUALN,PREVBUDG,PREVACT,SEQUENCE,CHILD,PARENT,ROLLUPQ,COMPANYCODE,DEPCODE,DIVCODE,STATUSFL,STATUSFLDT,CURRENCY,NOTES,OWNER,OWNER2,P0,P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P8T,P9T,P10T,P11T)=(a.SID,a.ACCOUNT,a.DESCRIPT,a.CATEGORY,a.TYPE,a.BUDGET,a.ACTUAL,a.ACTUALN,a.PREVBUDG,a.PREVACT,a.SEQUENCE,a.CHILD,a.PARENT,a.ROLLUPQ,a.COMPANYCODE,a.DEPCODE,a.DIVCODE,a.STATUSFL,a.STATUSFLDT,a.CURRENCY,a.NOTES,a.OWNER,a.OWNER2,a.P0,a.P1,a.P2,a.P3,a.P4,a.P5,a.P6,a.P7,a.P8,a.P9,a.P10,a.P11,a.P12,a.P13,a.P14,a.P8T,a.P9T,a.P10T,a.P11T)FROM "+schemaName+".ACCOUNT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
                                     FacesMessage.SEVERITY_INFO,bundle.getString("update")+" "+bundle.getString("account_c ")+" "+bundle.getString("count")+" "+(updatedCount-countp),""));
countp=updatedCount;

sqlScript="UPDATE "+schemaName+".CUSTOMER_c b SET(SID,CUSTOMER,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,CUSTOMERASCOMPANYNAME,CUSTTOTL,CUSTTQTY,COMPANYCODE,LOCATION,MAILTOCODE,SHIPTOCODE,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,DOB,PLACEOFBIRTH,SEX,AGE,CUSRTOTL,CUSRTQTY,CUSMTOTL,CUSDTOTL,LASTORDER,LASTINVOIC,LASTPAYMNQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,TOTLPAID,CONTACTED,BYWHO,NXTCONTACT,VIA,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.CUSTOMER,a.DESCRIPT,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.CUSTOMERASCOMPANYNAME,a.CUSTTOTL,a.CUSTTQTY,a.COMPANYCODE,a.LOCATION,a.MAILTOCODE,a.SHIPTOCODE,a.TAX1,a.TAX2,a.TAX3,a.CUSTTAX1,a.CUSTTAX2,a.CUSTTAX3,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.DOB,a.PLACEOFBIRTH,a.SEX,a.AGE,a.CUSRTOTL,a.CUSRTQTY,a.CUSMTOTL,a.CUSDTOTL,a.LASTORDER,a.LASTINVOIC,a.LASTPAYMNQ,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.TYPE,a.DEFAULTGLAC,a.INTEGRSET,a.STATUSFL,a.STATUSFLDT,a.TOTLPAID,a.CONTACTED,a.BYWHO,a.NXTCONTACT,a.VIA,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".CUSTOMER a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);
updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VENDOR_c b SET(SID,VENDOR,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,VENDORASCOMPANYNAME,VENDTOTL,VENDTQTY,COMPANYCODE,LOCATION,MAILTOCODE,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,VENRTOTL,VENRTQTY,VENMTOTL,VENDDTOTL,LASTQUOTE,LASTORDER,LASTINVOIC,LASTPAYMQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,SHIPTOCODE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,TOTLPAID,CONTACTED,BYWHO,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.VENDOR,a.DESCRIPT,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.VENDORASCOMPANYNAME,a.VENDTOTL,a.VENDTQTY,a.COMPANYCODE,a.LOCATION,a.MAILTOCODE,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.VENRTOTL,a.VENRTQTY,a.VENMTOTL,a.VENDDTOTL,a.LASTQUOTE,a.LASTORDER,a.LASTINVOIC,a.LASTPAYMQ,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.TYPE,a.SHIPTOCODE,a.DEFAULTGLAC,a.INTEGRSET,a.STATUSFL,a.STATUSFLDT,a.TOTLPAID,a.CONTACTED,a.BYWHO,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VENDOR a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".EMPLOYEE_c b SET(SID,EMPLOYEE,DESCRIPT,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,COMPANYCODE,EMPLTOTL,EMPLTQTY,DIVCODE,DEPCODE,LOCATION,RESIDENCY,MAILTOCODE,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,EMPRTOTL,EMPRTQTY,EMPMTOTL,EMPDTOTL,LASTQUOTE,LASTORDER,LASTINVOIC,LASTPAYMQ,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,SHIPTOCODE,TYPE,DEFAULTGLAC,INTEGRSET,STATUSFL,STATUSFLDT,CONTACTED,BYWHO,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.EMPLOYEE,a.DESCRIPT,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.COMPANYCODE,a.EMPLTOTL,a.EMPLTQTY,a.DIVCODE,a.DEPCODE,a.LOCATION,a.RESIDENCY,a.MAILTOCODE,a.TAX1,a.TAX2,a.TAX3,a.CUSTTAX1,a.CUSTTAX2,a.CUSTTAX3,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.EMPRTOTL,a.EMPRTQTY,a.EMPMTOTL,a.EMPDTOTL,a.LASTQUOTE,a.LASTORDER,a.LASTINVOIC,a.LASTPAYMQ,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.SHIPTOCODE,a.TYPE,a.DEFAULTGLAC,a.INTEGRSET,a.STATUSFL,a.STATUSFLDT,a.CONTACTED,a.BYWHO,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".EMPLOYEE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VCONTACT_c b SET(SID,CONTACT,VENDOR,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,LOCATION,MAILTOCODE,SHIPTOCODE,PRINTSTA,SHIPLABEL,TYPE,STATUSFL,STATUSFLDT,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.CONTACT,a.VENDOR,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.LOCATION,a.MAILTOCODE,a.SHIPTOCODE,a.PRINTSTA,a.SHIPLABEL,a.TYPE,a.STATUSFL,a.STATUSFLDT,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VCONTACT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CCONTACT_c b SET(SID,CONTACT,CUSTOMER,TITLE,JOBTITLE,LASTNAME,FIRSTNAME,MIDDLENAM,TAX1,TAX2,TAX3,CUSTTAX1,CUSTTAX2,CUSTTAX3,PHONEO,PHONEH,PHONEC,PHONEX,LANADDR,WANADDR,LMAILADDR,IMAILADDR,RMAILADDR,INTADDR,INRADDR,LOCATION,MAILTOCODE,SHIPTOCODE,PRINTMSTAT,PRINMTFLDT,SHIPLABEL,TYPE,STATUSFL,STATUSFLDT,KEYWORDS,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.CONTACT,a.CUSTOMER,a.TITLE,a.JOBTITLE,a.LASTNAME,a.FIRSTNAME,a.MIDDLENAM,a.TAX1,a.TAX2,a.TAX3,a.CUSTTAX1,a.CUSTTAX2,a.CUSTTAX3,a.PHONEO,a.PHONEH,a.PHONEC,a.PHONEX,a.LANADDR,a.WANADDR,a.LMAILADDR,a.IMAILADDR,a.RMAILADDR,a.INTADDR,a.INRADDR,a.LOCATION,a.MAILTOCODE,a.SHIPTOCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.SHIPLABEL,a.TYPE,a.STATUSFL,a.STATUSFLDT,a.KEYWORDS,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".CCONTACT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".PERIODDATES_c b SET(SID,PERIOD,DESCRIPT,STARTDATE,ENDDATE,STARTOFWEEK,STARTOFBWEEK,ENDOFBWEEK,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PERIOD,a.DESCRIPT,a.STARTDATE,a.ENDDATE,a.STARTOFWEEK,a.STARTOFBWEEK,a.ENDOFBWEEK,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".PERIODDATES a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".ACPERIOD_c b SET(SID,ROWID,CURRPERIOD,DESCRIPT,CURRBUSDATE,CURRCALDATE,CURRLOCALDATE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.ROWID,a.CURRPERIOD,a.DESCRIPT,a.CURRBUSDATE,a.CURRCALDATE,a.CURRLOCALDATE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ACPERIOD a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".WAGEEARNER_c b SET(SID,WAGEEARNERID,EMPLOYEE,SIN,BIRTHDT,FEDCLAIM,PROVCLAIM,PAYYRFREQ,PAYPERIOD,WCB,WCBYTD,EMPLINSUR,INSYTD,VACRETAIN,VACATONYT,WAGEUNIT,WAGERATE,OTIMEUNIT,OTIMERATE,WAGEUNITS,OTIMUNITS,WAGEOUT,OVTIMEOUT,SALARYOUT,COMMISSION,BENEFITS,VACATION,VACPAYOUT,ADVANCE,PENSION,AFTERTAX,UNIONDUES,MEDICAL,FINCOMETX,PINCOMETX,THISPAYA,LASTPAYA,PAYYTD,FPENSIYTD,PPENSIYTD,ITAXYTD,PTAXYTD,GRPAYYTD,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.WAGEEARNERID,a.EMPLOYEE,a.SIN,a.BIRTHDT,a.FEDCLAIM,a.PROVCLAIM,a.PAYYRFREQ,a.PAYPERIOD,a.WCB,a.WCBYTD,a.EMPLINSUR,a.INSYTD,a.VACRETAIN,a.VACATONYT,a.WAGEUNIT,a.WAGERATE,a.OTIMEUNIT,a.OTIMERATE,a.WAGEUNITS,a.OTIMUNITS,a.WAGEOUT,a.OVTIMEOUT,a.SALARYOUT,a.COMMISSION,a.BENEFITS,a.VACATION,a.VACPAYOUT,a.ADVANCE,a.PENSION,a.AFTERTAX,a.UNIONDUES,a.MEDICAL,a.FINCOMETX,a.PINCOMETX,a.THISPAYA,a.LASTPAYA,a.PAYYTD,a.FPENSIYTD,a.PPENSIYTD,a.ITAXYTD,a.PTAXYTD,a.GRPAYYTD,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".WAGEEARNER a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ARTHATBL_c b SET(SID,USAGE,WCBPERCNT,INSFACTOR,VACATONRATE,PENSIONMAX,WCBMAX,INSMAX,ITAXLV0RATE,ITAXLV1RATE,ITAXLV2RATE,ITAXLV3RATE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.USAGE,a.WCBPERCNT,a.INSFACTOR,a.VACATONRATE,a.PENSIONMAX,a.WCBMAX,a.INSMAX,a.ITAXLV0RATE,a.ITAXLV1RATE,a.ITAXLV2RATE,a.ITAXLV3RATE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ARTHATBL a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ROLLUPGROUP_c b SET(SID,GROUPID,DESCRIPT,TYPE,CURRPW,EXPIRY,CURRENCY,PERIOD0B,PERIOD0,PERIODTOTALSB,PERIODTOTALS,PERIOD1BUDGET,PERIOD1ACTUAL,PERIOD2B,PERIOD2,PERIOD3B,PERIOD3,PERIOD4B,PERIOD4,PERIOD5B,PERIOD5,PERIOD6B,PERIOD6,PERIOD7B,PERIOD7,PERIOD8B,PERIOD8,PERIOD9B,PERIOD9,PERIOD10B,PERIOD10,PERIOD11B,PERIOD11,PERIOD12B,PERIOD12,PERIODNB,PERIODN,NOTES,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.GROUPID,a.DESCRIPT,a.TYPE,a.CURRPW,a.EXPIRY,a.CURRENCY,a.PERIOD0B,a.PERIOD0,a.PERIODTOTALSB,a.PERIODTOTALS,a.PERIOD1BUDGET,a.PERIOD1ACTUAL,a.PERIOD2B,a.PERIOD2,a.PERIOD3B,a.PERIOD3,a.PERIOD4B,a.PERIOD4,a.PERIOD5B,a.PERIOD5,a.PERIOD6B,a.PERIOD6,a.PERIOD7B,a.PERIOD7,a.PERIOD8B,a.PERIOD8,a.PERIOD9B,a.PERIOD9,a.PERIOD10B,a.PERIOD10,a.PERIOD11B,a.PERIOD11,a.PERIOD12B,a.PERIOD12,a.PERIODNB,a.PERIODN,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ROLLUPGROUP a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".MEMBERSGROUP_c b SET(SID,GROUPID,DESCRIPT,QUANTITY,MODE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.GROUPID,a.DESCRIPT,a.QUANTITY,a.MODE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".MEMBERSGROUP a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ARTHAHIST_c b SET(SID,WAGEEARNER,SIN,PERIOD,MONTH,CCYY,VACATION,WAGE,OVERTIME,SALARY,COMMISSION,BENEFIT,FINCOMETX,PINCOMETX,WCBOUT,EMPLINSUR,VACPAYOUT,ADVANCE,FPENSOBTX,FPENSOATX,UNIONDUES,MEDICAL,PAYAMT,NOTES,NOTES2,CHQNUMBER,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.WAGEEARNER,a.SIN,a.PERIOD,a.MONTH,a.CCYY,a.VACATION,a.WAGE,a.OVERTIME,a.SALARY,a.COMMISSION,a.BENEFIT,a.FINCOMETX,a.PINCOMETX,a.WCBOUT,a.EMPLINSUR,a.VACPAYOUT,a.ADVANCE,a.FPENSOBTX,a.FPENSOATX,a.UNIONDUES,a.MEDICAL,a.PAYAMT,a.NOTES,a.NOTES2,a.CHQNUMBER,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ARTHAHIST a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".HOLIDAY_c b SET(SID,SHOLIDAY,HOLIDAY,DESCRIPT,TYPE,STATUSFL,STATUSFLDT,EMPLOYEE,RESIDENCY,OWNER,OWNER2)=(a.SID,a.SHOLIDAY,a.HOLIDAY,a.DESCRIPT,a.TYPE,a.STATUSFL,a.STATUSFLDT,a.EMPLOYEE,a.RESIDENCY,a.OWNER,a.OWNER2)FROM "+schemaName+".HOLIDAY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ITEM_c b SET(SID,MATCODE,QUANTITY,DESCRIPT,DATEADDED,DATEEXPIRY,DATETORENEW,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,LOCATION,BARUPC)=(a.SID,a.MATCODE,a.QUANTITY,a.DESCRIPT,a.DATEADDED,a.DATEEXPIRY,a.DATETORENEW,a.SOURCE1,a.SOURCE2,a.UPCCODE,a.COST,a.REPLCOST,a.SELPRICE,a.SPRICOLD,a.SPRICNEW,a.SPRICEFFDT,a.SHIPCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.MISCCODE1,a.MISCCODE2,a.QTYLEVEL1,a.UNIT,a.CASEQTY,a.TYPE,a.TAX1,a.TAX2,a.TAX3,a.ALIASCODE,a.PARENTCODE,a.AVGPRICE,a.AVGCOST,a.STATUSFL,a.STATUSFLDT,a.SUBCODESN,a.SUBCODESN2,a.SUBCODESN3,a.CUORDQTY,a.VENORQTY,a.CUPICQTY,a.VENPIQTY,a.CUINVQTY,a.CUSHIQTY,a.VENSHQTY,a.EFFDATE,a.INTEGRSET,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.LOCATION,a.BARUPC)FROM "+schemaName+".ITEM a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ACTIVITY_c b SET(SID,ACTIVITYCODE,QUANTITY,DESCRIPT,DATE,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,BARUPC)=(a.SID,a.ACTIVITYCODE,a.QUANTITY,a.DESCRIPT,a.DATE,a.SOURCE1,a.SOURCE2,a.UPCCODE,a.COST,a.REPLCOST,a.SELPRICE,a.SPRICOLD,a.SPRICNEW,a.SPRICEFFDT,a.SHIPCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.MISCCODE1,a.MISCCODE2,a.QTYLEVEL1,a.UNIT,a.CASEQTY,a.TYPE,a.TAX1,a.TAX2,a.TAX3,a.ALIASCODE,a.PARENTCODE,a.AVGPRICE,a.AVGCOST,a.STATUSFL,a.STATUSFLDT,a.SUBCODESN,a.SUBCODESN2,a.SUBCODESN3,a.CUORDQTY,a.VENORQTY,a.CUPICQTY,a.VENPIQTY,a.CUINVQTY,a.CUSHIQTY,a.VENSHQTY,a.EFFDATE,a.INTEGRSET,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.BARUPC)FROM "+schemaName+".ACTIVITY a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".SCHEDULE_c b SET(SID,TODO,DESCRIPT,EMPLOYEE,SSDATET,ACTIVITYCODE,LOCATION,SDATET,DURATIONH,DURATIONM,STIMEH,STIMEM,STIMEAMPM,EDATET,PRIORITY,PERCNTDONE,VENDOR,VONTACT,CUSTOMER,TYPE,MAILTOCODE,OTHEREMPLO,REPEATF,STATUSFL,STATUSFLDT,PRIVATEIND,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.TODO,a.DESCRIPT,a.EMPLOYEE,a.SSDATET,a.ACTIVITYCODE,a.LOCATION,a.SDATET,a.DURATIONH,a.DURATIONM,a.STIMEH,a.STIMEM,a.STIMEAMPM,a.EDATET,a.PRIORITY,a.PERCNTDONE,a.VENDOR,a.VONTACT,a.CUSTOMER,a.TYPE,a.MAILTOCODE,a.OTHEREMPLO,a.REPEATF,a.STATUSFL,a.STATUSFLDT,a.PRIVATEIND,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".SCHEDULE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".USERPROFL_c b SET(SID,LOGONID,ROW,OPTION,SELECTVALUE,SCRCOLOR,HILCOLOR,TEXTCOLOR,BACCOLOR,BEEPSOU,CONFIRM,PROMPTI,P1,P2,P3,P4,P5,P6,MTSTYLE,STSTYLE,DTSTYLE,FTSTYLE,DEFAULTR,DEFAULTC,DBNAME,ROOTDIR,KEYORDER,MARGIN,FOOTER,LISTBUILDC,LISTBUILDV,LISTBUILDE,LISTBROWNC,LISTBROWNV,LISTBROWNE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.LOGONID,a.ROW,a.OPTION,a.SELECTVALUE,a.SCRCOLOR,a.HILCOLOR,a.TEXTCOLOR,a.BACCOLOR,a.BEEPSOU,a.CONFIRM,a.PROMPTI,a.P1,a.P2,a.P3,a.P4,a.P5,a.P6,a.MTSTYLE,a.STSTYLE,a.DTSTYLE,a.FTSTYLE,a.DEFAULTR,a.DEFAULTC,a.DBNAME,a.ROOTDIR,a.KEYORDER,a.MARGIN,a.FOOTER,a.LISTBUILDC,a.LISTBUILDV,a.LISTBUILDE,a.LISTBROWNC,a.LISTBROWNV,a.LISTBROWNE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".USERPROFL a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".\"USER_c\" b SET(SID,ID,CLIENT,EMPLOYEE,VENDOR,CUSTOMER,OTHERID,ALEVEL,BLEVEL,CURRPW,EXPIRY,OLDPW,TEMPORARYPASSWORD,PASSWORDHASH,ACTIVATIONKEY,RESTRICT1,RESTRICT2,RESTRICT3,ALLOW1,ALLOW2,ALLOW3,MAXPROFLROW,CPROFLROW,STATUSFL,STATUSFLDT,UCURRCALDA,PREPROCESS,NOTES,DOCMNT,OWNER,OWNER2,signature)=(a.SID,a.ID,a.CLIENT,a.EMPLOYEE,a.VENDOR,a.CUSTOMER,a.OTHERID,a.ALEVEL,a.BLEVEL,a.CURRPW,a.EXPIRY,a.OLDPW,a.TEMPORARYPASSWORD,a.PASSWORDHASH,a.ACTIVATIONKEY,a.RESTRICT1,a.RESTRICT2,a.RESTRICT3,a.ALLOW1,a.ALLOW2,a.ALLOW3,a.MAXPROFLROW,a.CPROFLROW,a.STATUSFL,a.STATUSFLDT,a.UCURRCALDA,a.PREPROCESS,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.signature)FROM "+schemaName+".\"USER\" a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
if(dbProductName.equals("psql")){
 sqlScript="UPDATE "+schemaName+".\"user_c\" b SET(SID,ID,CLIENT,EMPLOYEE,VENDOR,CUSTOMER,OTHERID,ALEVEL,BLEVEL,CURRPW,EXPIRY,OLDPW,TEMPORARYPASSWORD,PASSWORDHASH,ACTIVATIONKEY,RESTRICT1,RESTRICT2,RESTRICT3,ALLOW1,ALLOW2,ALLOW3,MAXPROFLROW,CPROFLROW,STATUSFL,STATUSFLDT,UCURRCALDA,PREPROCESS,NOTES,DOCMNT,OWNER,OWNER2,signature)=(a.SID,a.ID,a.CLIENT,a.EMPLOYEE,a.VENDOR,a.CUSTOMER,a.OTHERID,a.ALEVEL,a.BLEVEL,a.CURRPW,a.EXPIRY,a.OLDPW,a.TEMPORARYPASSWORD,a.PASSWORDHASH,a.ACTIVATIONKEY,a.RESTRICT1,a.RESTRICT2,a.RESTRICT3,a.ALLOW1,a.ALLOW2,a.ALLOW3,a.MAXPROFLROW,a.CPROFLROW,a.STATUSFL,a.STATUSFLDT,a.UCURRCALDA,a.PREPROCESS,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.signature)FROM "+schemaName+".\"user\" a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
}

q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VENARTHA_c b SET(SID,CHQNUMBER,RECONCILED,VENDORC,DATE,ADDRESCODE,CHQAMT,AMTVERBOS,NOTES,ADVISEL1,ADVISEL2,ADVISEL3,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.CHQNUMBER,a.RECONCILED,a.VENDORC,a.DATE,a.ADDRESCODE,a.CHQAMT,a.AMTVERBOS,a.NOTES,a.ADVISEL1,a.ADVISEL2,a.ADVISEL3,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".VENARTHA a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".ACINTEGR_c b SET(SID,MODULEID,USAGEDESCR,USAGECODE,SETSID,ACCOUNT,EXTRAINTFIELD,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.MODULEID,a.USAGEDESCR,a.USAGECODE,a.SETSID,a.ACCOUNT,a.EXTRAINTFIELD,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ACINTEGR a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".ITEMJOB_c b SET(SID,JOBNO,MATCODE,PRODDATET,QTYALLOC,PONO,QTYOSTND,QTYALSTK,QTYISSUD,JOBTOTL,STATUSFL,CUSTOMEJ,VENDOR,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,PRINTMSTATJ,PRINMTFLDTJ,TYPE,MATCODEOUT,QTYOUT,NOTES,OWNER,OWNER2)=(a.SID,a.JOBNO,a.MATCODE,a.PRODDATET,a.QTYALLOC,a.PONO,a.QTYOSTND,a.QTYALSTK,a.QTYISSUD,a.JOBTOTL,a.STATUSFL,a.CUSTOMEJ,a.VENDOR,a.STATUSFLDT,a.PRINTMSTAT,a.PRINMTFLDT,a.PRINTMSTATJ,a.PRINMTFLDTJ,a.TYPE,a.MATCODEOUT,a.QTYOUT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".ITEMJOB a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".ACTIVITYJOB_c b SET(SID,JOBNO,ACTIVITYCODE,PRODDATET,QTYALLOC,PONO,QTYOSTND,QTYALSTK,QTYISSUD,JOBTOTL,STATUSFL,CUSTOMEJ,VENDOR,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,PRINTMSTATJ,PRINMTFLDTJ,TYPE,MATCODEOUT,QTYOUT,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.JOBNO,a.ACTIVITYCODE,a.PRODDATET,a.QTYALLOC,a.PONO,a.QTYOSTND,a.QTYALSTK,a.QTYISSUD,a.JOBTOTL,a.STATUSFL,a.CUSTOMEJ,a.VENDOR,a.STATUSFLDT,a.PRINTMSTAT,a.PRINMTFLDT,a.PRINTMSTATJ,a.PRINMTFLDTJ,a.TYPE,a.MATCODEOUT,a.QTYOUT,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".ACTIVITYJOB a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".PROCESSATTRIBUTES_c b SET(SID,PDETAILS,NAME,VALUE,TYPE,RANGE,STEP,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PDETAILS,a.NAME,a.VALUE,a.TYPE,a.RANGE,a.STEP,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".PROCESSATTRIBUTES a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".PROCESSDETAILS_c b SET(SID,PROCESS,CPONO,MATCODE,CUSTOMER,SDATET,DURATIONH,DURATIONM,STIMEH,STIMEM,STIMEAMPM,EDATET,PRIORITY,PERCNTDONE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PROCESS,a.CPONO,a.MATCODE,a.CUSTOMER,a.SDATET,a.DURATIONH,a.DURATIONM,a.STIMEH,a.STIMEM,a.STIMEAMPM,a.EDATET,a.PRIORITY,a.PERCNTDONE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".PROCESSDETAILS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VENQUOTE_c b SET(SID,PURCHSNO,DELVDATET,VENDOR,MATCODE,REPLICATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,CINVOICE,JOBNO,VPONO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.VENDOR,a.MATCODE,a.REPLICATE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.CINVOICE,a.JOBNO,a.VPONO,a.RFPORD,a.STATUSFLDT,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.SHIPCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VENQUOTE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".VENDORDERS_c b SET(SID,PURCHSNO,DELVDATET,VENDOR,MATCODE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,JOBNO,VENDQNO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.VENDOR,a.MATCODE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.JOBNO,a.VENDQNO,a.RFPORD,a.STATUSFLDT,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.SHIPCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VENDORDERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".VSHIPMEN_c b SET(SID,SHIPCODE,MATCODE,SHIPPER,PONO,CPONO,INVOICE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,CARRIER,TYPE,SHIPDATET,SHIPDATETA,TARENO,PACKNO,VENDOR,CUSTOMER,BILLTOCODE,BILLTOSAMEASSHIPTO,SHIPTOCODE,NOTES,STATUSFL,STATUSFLDT,SERIALNO,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2)=(a.SID,a.SHIPCODE,a.MATCODE,a.SHIPPER,a.PONO,a.CPONO,a.INVOICE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.CARRIER,a.TYPE,a.SHIPDATET,a.SHIPDATETA,a.TARENO,a.PACKNO,a.VENDOR,a.CUSTOMER,a.BILLTOCODE,a.BILLTOSAMEASSHIPTO,a.SHIPTOCODE,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.SERIALNO,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".VSHIPMEN a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CUQUOTE_c b SET(SID,PURCHSNO,DELVDATET,VENDOR,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,CUSTOMER,MATCODE,REPLICATE,CINVOICE,ORDPRICE,JOBNO,VPONO,QUOORDT,STATUSFLDT,PRINTMSTAT,PRINMTFLDT,TYPE,TERMS,PRIORITY,ODATET,SHIPCODE,ACTIVITYCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,ATTACH,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.VENDOR,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.CUSTOMER,a.MATCODE,a.REPLICATE,a.CINVOICE,a.ORDPRICE,a.JOBNO,a.VPONO,a.QUOORDT,a.STATUSFLDT,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.TERMS,a.PRIORITY,a.ODATET,a.SHIPCODE,a.ACTIVITYCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.ATTACH,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".CUQUOTE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".CUORDERS_c b SET(SID,PURCHSNO,DELVDATET,CUSTOMER,MATCODE,CUQUOTE,CINVOICE,JOBNO,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,VPONO,RFPORD,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2,DOCMNT,SHIPCODEFROMPAY,SHIPCODE,BARPO)=(a.SID,a.PURCHSNO,a.DELVDATET,a.CUSTOMER,a.MATCODE,a.CUQUOTE,a.CINVOICE,a.JOBNO,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.VPONO,a.RFPORD,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT,a.SHIPCODEFROMPAY,a.SHIPCODE,a.BARPO)FROM "+schemaName+".CUORDERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".CUINVOICE_c b SET(SID,INVOICE,CUSTOMER,MATCODE,INVODATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,PONO,REF1TYP,REF1CODE,SHIPDATET,SHIPTYPE,SHIPCODE,TERMS,STATUSFL,STATUSFLDT,TERMSDAT,DISCOUNP,DISCOUDT,DISCOUDS,NETDDAT,NETDDYS,FOB,TYPE,INTEGRSET,ATTACH,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,AGENT,NOTES,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,DOCMNT,BARINVOICE)=(a.SID,a.INVOICE,a.CUSTOMER,a.MATCODE,a.INVODATE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.PONO,a.REF1TYP,a.REF1CODE,a.SHIPDATET,a.SHIPTYPE,a.SHIPCODE,a.TERMS,a.STATUSFL,a.STATUSFLDT,a.TERMSDAT,a.DISCOUNP,a.DISCOUDT,a.DISCOUDS,a.NETDDAT,a.NETDDYS,a.FOB,a.TYPE,a.INTEGRSET,a.ATTACH,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.AGENT,a.NOTES,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2,a.DOCMNT,a.BARINVOICE)FROM "+schemaName+".CUINVOICE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".SHIPMENT_c b SET(SID,SHIPCODE,MATCODE,SHIPPER,PONO,CPONO,INVOICE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,CARRIER,TYPE,SHIPDATET,SHIPDATETA,TARENO,PACKNO,CUSTOMER,BILLTOCODE,BILLTOSAMEASSHIPTO,SHIPTOCODE,NOTES,STATUSFL,STATUSFLDT,SERIALNO,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,BARSHIPCOD)=(a.SID,a.SHIPCODE,a.MATCODE,a.SHIPPER,a.PONO,a.CPONO,a.INVOICE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.CARRIER,a.TYPE,a.SHIPDATET,a.SHIPDATETA,a.TARENO,a.PACKNO,a.CUSTOMER,a.BILLTOCODE,a.BILLTOSAMEASSHIPTO,a.SHIPTOCODE,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.SERIALNO,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2,a.BARSHIPCOD)FROM "+schemaName+".SHIPMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".EMPLORDERS_c b SET(SID,PURCHSNO,DELVDATET,EMPLOYEE,MATCODE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,STATUSFL,JOBNO,VPONO,RFPORD,STATUSFLDT,RCPONO,ODATET,TERMS,PRIORITY,PRINTMSTAT,PRINMTFLDT,TYPE,VINVOICE,ATTACH,SHIPCODE,AGENT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,STARTDATET,NOTES,OWNER,OWNER2,DOCMNT)=(a.SID,a.PURCHSNO,a.DELVDATET,a.EMPLOYEE,a.MATCODE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.STATUSFL,a.JOBNO,a.VPONO,a.RFPORD,a.STATUSFLDT,a.RCPONO,a.ODATET,a.TERMS,a.PRIORITY,a.PRINTMSTAT,a.PRINMTFLDT,a.TYPE,a.VINVOICE,a.ATTACH,a.SHIPCODE,a.AGENT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.STARTDATET,a.NOTES,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".EMPLORDERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".HLOGFILE_c b SET(SID,SERIALNO,MATCODE,QUANRECD,VENDOR,LOCATION,RECVRPT,INFLG,PHY,DATETIN,DATETOUT,JOBNO,PRINTMSTAT,PRINMTFLDT,PONO,SCANDATET,QUANISSD,BUTT,STATUSFL,QUANREJD,CUSTOMER,CPONO,CUSTOMEJ,ORGCOST,ORGPONO,ORGJOBNO,ALTSERNO,SELPRICE,PHYSQTY,SPERSON,CARTONID,CARTONPR,PACKCODE,TARECODE,SHIPCODE,TYPE,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.SERIALNO,a.MATCODE,a.QUANRECD,a.VENDOR,a.LOCATION,a.RECVRPT,a.INFLG,a.PHY,a.DATETIN,a.DATETOUT,a.JOBNO,a.PRINTMSTAT,a.PRINMTFLDT,a.PONO,a.SCANDATET,a.QUANISSD,a.BUTT,a.STATUSFL,a.QUANREJD,a.CUSTOMER,a.CPONO,a.CUSTOMEJ,a.ORGCOST,a.ORGPONO,a.ORGJOBNO,a.ALTSERNO,a.SELPRICE,a.PHYSQTY,a.SPERSON,a.CARTONID,a.CARTONPR,a.PACKCODE,a.TARECODE,a.SHIPCODE,a.TYPE,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".HLOGFILE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CPAYMENT_c b SET(SID,PAYMENT,CUSTOMER,CINVOICE,CHEQDATE,PAYMENTDUEDATE,POSTINGPERIOD,MATCODE,INTEGRSET,ACCOUNT,AMOUNTTOTAL,AMOUNTOSTNDT,AMOUNTIN,QTYTOTAL,QTYOSTNDT,DISCOUNT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,PAYTYPE,PAYBYID,PAYBYDATE,CURRENCY,CONVRATE,LOCAMOUNTT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PAYMENT,a.CUSTOMER,a.CINVOICE,a.CHEQDATE,a.PAYMENTDUEDATE,a.POSTINGPERIOD,a.MATCODE,a.INTEGRSET,a.ACCOUNT,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.AMOUNTIN,a.QTYTOTAL,a.QTYOSTNDT,a.DISCOUNT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.PAYTYPE,a.PAYBYID,a.PAYBYDATE,a.CURRENCY,a.CONVRATE,a.LOCAMOUNTT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".CPAYMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".MACHINE_c b SET(SID,MACHINECODE,QUANTITY,DESCRIPT,DATEADDED,SOURCE1,SOURCE2,UPCCODE,COST,REPLCOST,SELPRICE,SPRICOLD,SPRICNEW,SPRICEFFDT,SHIPCODE,PRINTMSTAT,PRINMTFLDT,MISCCODE1,MISCCODE2,QTYLEVEL1,UNIT,CASEQTY,TYPE,TAX1,TAX2,TAX3,ALIASCODE,PARENTCODE,AVGPRICE,AVGCOST,STATUSFL,STATUSFLDT,SUBCODESN,SUBCODESN2,SUBCODESN3,CUORDQTY,VENORQTY,CUPICQTY,VENPIQTY,CUINVQTY,CUSHIQTY,VENSHQTY,EFFDATE,INTEGRSET,NOTES,DOCMNT,OWNER,OWNER2,BARUPC)=(a.SID,a.MACHINECODE,a.QUANTITY,a.DESCRIPT,a.DATEADDED,a.SOURCE1,a.SOURCE2,a.UPCCODE,a.COST,a.REPLCOST,a.SELPRICE,a.SPRICOLD,a.SPRICNEW,a.SPRICEFFDT,a.SHIPCODE,a.PRINTMSTAT,a.PRINMTFLDT,a.MISCCODE1,a.MISCCODE2,a.QTYLEVEL1,a.UNIT,a.CASEQTY,a.TYPE,a.TAX1,a.TAX2,a.TAX3,a.ALIASCODE,a.PARENTCODE,a.AVGPRICE,a.AVGCOST,a.STATUSFL,a.STATUSFLDT,a.SUBCODESN,a.SUBCODESN2,a.SUBCODESN3,a.CUORDQTY,a.VENORQTY,a.CUPICQTY,a.VENPIQTY,a.CUINVQTY,a.CUSHIQTY,a.VENSHQTY,a.EFFDATE,a.INTEGRSET,a.NOTES,a.DOCMNT,a.OWNER,a.OWNER2,a.BARUPC)FROM "+schemaName+".MACHINE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".GROUPMEMBERS_c b SET(SID,GROUPID,MEMBERID,DESCRIPT,SOURCETYPE,MEMBEREM,MEMBERCU,MEMBERVE,MEMBERIT,MEMBERAC,MEMBERMA,TYPE,CURRPW,EXPIRY,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.GROUPID,a.MEMBERID,a.DESCRIPT,a.SOURCETYPE,a.MEMBEREM,a.MEMBERCU,a.MEMBERVE,a.MEMBERIT,a.MEMBERAC,a.MEMBERMA,a.TYPE,a.CURRPW,a.EXPIRY,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".GROUPMEMBERS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".ITEMBOM_c b SET(SID,BOMCODE,DESCRIPT,QUANTITY,MODE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.BOMCODE,a.DESCRIPT,a.QUANTITY,a.MODE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ITEMBOM a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".ITEMBOMDETAILS_c b SET(SID,BOMCODE,MATCODE,MODE,SUBQTY,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.BOMCODE,a.MATCODE,a.MODE,a.SUBQTY,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".ITEMBOMDETAILS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".TASK_c b SET(SID,TASKID,DESCRIPT,ACTIVITYCODE,PROJECTTEAM,RESOURCE,MODE,ESTSTART,CALCSTART,ACTLSTART,ESTEND,CALCEND,ACTLEND,SUBQTY,BOMCODE,LOCATION,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.TASKID,a.DESCRIPT,a.ACTIVITYCODE,a.PROJECTTEAM,a.RESOURCE,a.MODE,a.ESTSTART,a.CALCSTART,a.ACTLSTART,a.ESTEND,a.CALCEND,a.ACTLEND,a.SUBQTY,a.BOMCODE,a.LOCATION,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".TASK a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".VINVOICE_c b SET(SID,INVOICE,VENDOR,MATCODE,INTEGRSET,INVODATE,AMOUNTTOTAL,AMOUNTOSTNDT,QTYTOTAL,QTYOSTNDT,PONO,REF1TYP,REF1CODE,SHIPDATET,SHIPTYPE,SHIPCODE,TERMS,STATUSFL,STATUSFLDT,TERMSDAT,DISCOUNP,DISCOUDT,DISCOUDS,NETDDAT,NETDDYS,FOB,TYPE,ATTACH,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,AGENT,NOTES,PRINTMSTAT,PRINMTFLDT,OWNER,OWNER2,DOCMNT)=(a.SID,a.INVOICE,a.VENDOR,a.MATCODE,a.INTEGRSET,a.INVODATE,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.QTYTOTAL,a.QTYOSTNDT,a.PONO,a.REF1TYP,a.REF1CODE,a.SHIPDATET,a.SHIPTYPE,a.SHIPCODE,a.TERMS,a.STATUSFL,a.STATUSFLDT,a.TERMSDAT,a.DISCOUNP,a.DISCOUDT,a.DISCOUDS,a.NETDDAT,a.NETDDYS,a.FOB,a.TYPE,a.ATTACH,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.AGENT,a.NOTES,a.PRINTMSTAT,a.PRINMTFLDT,a.OWNER,a.OWNER2,a.DOCMNT)FROM "+schemaName+".VINVOICE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".VPAYMENT_c b SET(SID,PAYMENT,VENDOR,VINVOICE,CHEQDATE,PAYMENTDUEDATE,POSTINGPERIOD,MATCODE,INTEGRSET,ACCOUNT,AMOUNTTOTAL,AMOUNTOSTNDT,AMOUNTIN,QTYTOTAL,QTYOSTNDT,BASEAMOUNTT,DELIVCHRGT,MISCCHRGT,TAX1AMTT,TAX2AMTT,TAX3AMTT,DISCOUNT,PAYTYPE,PAYBYID,PAYBYDATE,CURRENCY,CONVRATE,LOCAMOUNT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.PAYMENT,a.VENDOR,a.VINVOICE,a.CHEQDATE,a.PAYMENTDUEDATE,a.POSTINGPERIOD,a.MATCODE,a.INTEGRSET,a.ACCOUNT,a.AMOUNTTOTAL,a.AMOUNTOSTNDT,a.AMOUNTIN,a.QTYTOTAL,a.QTYOSTNDT,a.BASEAMOUNTT,a.DELIVCHRGT,a.MISCCHRGT,a.TAX1AMTT,a.TAX2AMTT,a.TAX3AMTT,a.DISCOUNT,a.PAYTYPE,a.PAYBYID,a.PAYBYDATE,a.CURRENCY,a.CONVRATE,a.LOCAMOUNT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".VPAYMENT a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".WAGEEARNERAUX_c b SET(SID,WAGEEARNERID,LINE,SIN,WCBYTDL,WCBYTDN,INSYTDL,INSYTDN,VACATONYL,VACATONYN,PAYYTDL,FPENSIYTL,PPENSIYTL,ITAXYTDL,PTAXYTDL,PAYYTDN,FPENSIYTN,PPENSIYTN,ITAXYTDN,PATXYTDN,GPAYYTDL,GPAYYTDN,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.WAGEEARNERID,a.LINE,a.SIN,a.WCBYTDL,a.WCBYTDN,a.INSYTDL,a.INSYTDN,a.VACATONYL,a.VACATONYN,a.PAYYTDL,a.FPENSIYTL,a.PPENSIYTL,a.ITAXYTDL,a.PTAXYTDL,a.PAYYTDN,a.FPENSIYTN,a.PPENSIYTN,a.ITAXYTDN,a.PATXYTDN,a.GPAYYTDL,a.GPAYYTDN,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".WAGEEARNERAUX a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".Rgenapp_c b SET(SID,APPNAME,DESCRIPT,APPTYPE,APPWACCOUNTING,APPWEMAIL,APPWJMSMQ,APPVENDOR,APPVERSION,APPPLATFORM,APPMODELPKG,APPACTIONPKG,APPSKIN,APPDEPLOYTYPE,CREATEFIDATA,REVENGDATA,INITIALIZEFIDATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.APPNAME,a.DESCRIPT,a.APPTYPE,a.APPWACCOUNTING,a.APPWEMAIL,a.APPWJMSMQ,a.APPVENDOR,a.APPVERSION,a.APPPLATFORM,a.APPMODELPKG,a.APPACTIONPKG,a.APPSKIN,a.APPDEPLOYTYPE,a.CREATEFIDATA,a.REVENGDATA,a.INITIALIZEFIDATA,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".Rgenapp a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RGENDB_c b SET(SID,DBNAME,DESCRIPT,DBTYPE,DBVENDOR,DBVERSION,DBPLATFORM,APPCODE,SQLDRIVER,SQLURL,SQLUSER,SQLPASSWORD,SQLCLASSPATH,SQLCREATEDBSCRIPT,SQLDROPDBSCRIPT,SQLCREATETBLSSCRIPT,SQLLOADTBLSSCRIPT,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.DBNAME,a.DESCRIPT,a.DBTYPE,a.DBVENDOR,a.DBVERSION,a.DBPLATFORM,a.APPCODE,a.SQLDRIVER,a.SQLURL,a.SQLUSER,a.SQLPASSWORD,a.SQLCLASSPATH,a.SQLCREATEDBSCRIPT,a.SQLDROPDBSCRIPT,a.SQLCREATETBLSSCRIPT,a.SQLLOADTBLSSCRIPT,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RGENDB a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RGENTABLE_c b SET(SID,TABLENAME,DBCODE,INADDMENU,INLISTMENU,INTRANSACTIONMENU,INREPORTMENU,INGRAPHSMENU,INMAILINGMENU,INGENERATEMENU,INADMINMENU,INMAINTENANCEMENU,INLABELSMENU,INSKIPMENU,INCUSTOM1MENU,MENULEVEL,MENUROLE,MENULABELGROUP,SUBMENUSEQUENCE,USAGESCOPE,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.TABLENAME,a.DBCODE,a.INADDMENU,a.INLISTMENU,a.INTRANSACTIONMENU,a.INREPORTMENU,a.INGRAPHSMENU,a.INMAILINGMENU,a.INGENERATEMENU,a.INADMINMENU,a.INMAINTENANCEMENU,a.INLABELSMENU,a.INSKIPMENU,a.INCUSTOM1MENU,a.MENULEVEL,a.MENUROLE,a.MENULABELGROUP,a.SUBMENUSEQUENCE,a.USAGESCOPE,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RGENTABLE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2);UPDATE "+schemaName+".RGENFIELDS_c b SET(SID,DBCODE,TABLENAME,FIELDNAME,FIELDTYPE,FIELDLENGTH,INGROUP,SEQWITHINGROUP,FOCUSSEQ,FUTURE1,INITIALVALUE,KEYORADDITIONAL,KEYORADDITIONAL2,KEYORADDITIONAL3,SHOWINMENU,SHOWINREPORT,PROCESSOPTION1,PROCESSOPTION2,FDBCODE,FTABLENAME,FFIELDKEYNAME1,FFIELDKEYNAME2,FFIELDKEYNAME3,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.DBCODE,a.TABLENAME,a.FIELDNAME,a.FIELDTYPE,a.FIELDLENGTH,a.INGROUP,a.SEQWITHINGROUP,a.FOCUSSEQ,a.FUTURE1,a.INITIALVALUE,a.KEYORADDITIONAL,a.KEYORADDITIONAL2,a.KEYORADDITIONAL3,a.SHOWINMENU,a.SHOWINREPORT,a.PROCESSOPTION1,a.PROCESSOPTION2,a.FDBCODE,a.FTABLENAME,a.FFIELDKEYNAME1,a.FFIELDKEYNAME2,a.FFIELDKEYNAME3,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".RGENFIELDS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".GENOPTIONS_c b SET(SID,ROW,GENOPTIONS01,GENPURPOSE01,GENVALUE01,GENOPTIONS02,GENPURPOSE02,GENVALUE02,GENOPTIONS03,GENPURPOSE03,GENVALUE03,GENOPTIONS04,GENPURPOSE04,GENVALUE04,GENOPTIONS05,GENPURPOSE05,GENVALUE05,GENOPTIONS06,GENPURPOSE06,GENVALUE06,GENOPTIONS07,GENPURPOSE07,GENVALUE07,GENOPTIONS08,GENPURPOSE08,GENVALUE08,GENOPTIONS09,GENPURPOSE09,GENVALUE09,GENOPTIONS10,GENPURPOSE10,GENVALUE10,GENOPTIONS11,GENPURPOSE11,GENVALUE11,GENOPTIONS12,GENPURPOSE12,GENVALUE12,GENOPTIONS13,GENPURPOSE13,GENVALUE13,GENOPTIONS14,GENPURPOSE14,GENVALUE14,GENOPTIONS15,GENPURPOSE15,GENVALUE15,GENOPTIONS16,GENPURPOSE16,GENVALUE16,GENOPTIONS17,GENPURPOSE17,GENVALUE17,GENOPTIONS18,GENPURPOSE18,GENVALUE18,GENOPTIONS19,GENPURPOSE19,GENVALUE19,GENOPTIONS20,GENPURPOSE20,GENVALUE20,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.ROW,a.GENOPTIONS01,a.GENPURPOSE01,a.GENVALUE01,a.GENOPTIONS02,a.GENPURPOSE02,a.GENVALUE02,a.GENOPTIONS03,a.GENPURPOSE03,a.GENVALUE03,a.GENOPTIONS04,a.GENPURPOSE04,a.GENVALUE04,a.GENOPTIONS05,a.GENPURPOSE05,a.GENVALUE05,a.GENOPTIONS06,a.GENPURPOSE06,a.GENVALUE06,a.GENOPTIONS07,a.GENPURPOSE07,a.GENVALUE07,a.GENOPTIONS08,a.GENPURPOSE08,a.GENVALUE08,a.GENOPTIONS09,a.GENPURPOSE09,a.GENVALUE09,a.GENOPTIONS10,a.GENPURPOSE10,a.GENVALUE10,a.GENOPTIONS11,a.GENPURPOSE11,a.GENVALUE11,a.GENOPTIONS12,a.GENPURPOSE12,a.GENVALUE12,a.GENOPTIONS13,a.GENPURPOSE13,a.GENVALUE13,a.GENOPTIONS14,a.GENPURPOSE14,a.GENVALUE14,a.GENOPTIONS15,a.GENPURPOSE15,a.GENVALUE15,a.GENOPTIONS16,a.GENPURPOSE16,a.GENVALUE16,a.GENOPTIONS17,a.GENPURPOSE17,a.GENVALUE17,a.GENOPTIONS18,a.GENPURPOSE18,a.GENVALUE18,a.GENOPTIONS19,a.GENPURPOSE19,a.GENVALUE19,a.GENOPTIONS20,a.GENPURPOSE20,a.GENVALUE20,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".GENOPTIONS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".BLOBDATA_c b SET(SID,FROMTABLE,FROMKEY,QUALIFIER,SEQUENCE,TYPE,DATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.FROMTABLE,a.FROMKEY,a.QUALIFIER,a.SEQUENCE,a.TYPE,a.DATA,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".BLOBDATA a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CLOBDATA_c b SET(SID,FROMTABLE,FROMKEY,QUALIFIER,SEQUENCE,TYPE,DATA,STATUSFL,STATUSFLDT,NOTES,OWNER,OWNER2)=(a.SID,a.FROMTABLE,a.FROMKEY,a.QUALIFIER,a.SEQUENCE,a.TYPE,a.DATA,a.STATUSFL,a.STATUSFLDT,a.NOTES,a.OWNER,a.OWNER2)FROM "+schemaName+".CLOBDATA a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".CONTROLUSAGEBYPERIODS_c b SET(SID,CTLUSAGETRACKERID,DESCRIPT,CONTROLCODE,CURRENCY,PERIOD0LABEL,PERIOD0B,PERIOD0,PERIODTOTALSLABEL,PERIODTOTALSB,PERIODTOTALS,PERIOD1LABEL,PERIOD1BUDGET,PERIOD1ACTUAL,PERIOD2LABEL,PERIOD2B,PERIOD2,PERIOD3LABEL,PERIOD3B,PERIOD3,PERIOD4LABEL,PERIOD4B,PERIOD4,PERIOD5LABEL,PERIOD5B,PERIOD5,PERIOD6LABEL,PERIOD6B,PERIOD6,PERIOD7LABEL,PERIOD7B,PERIOD7,PERIOD8LABEL,PERIOD8B,PERIOD8,PERIOD9LABEL,PERIOD9B,PERIOD9,PERIOD10LABEL,PERIOD10B,PERIOD10,PERIOD11LABEL,PERIOD11B,PERIOD11,PERIOD12LABEL,PERIOD12B,PERIOD12,PERIODNLABEL,PERIODNB,PERIODN,NOTES,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.CTLUSAGETRACKERID,a.DESCRIPT,a.CONTROLCODE,a.CURRENCY,a.PERIOD0LABEL,a.PERIOD0B,a.PERIOD0,a.PERIODTOTALSLABEL,a.PERIODTOTALSB,a.PERIODTOTALS,a.PERIOD1LABEL,a.PERIOD1BUDGET,a.PERIOD1ACTUAL,a.PERIOD2LABEL,a.PERIOD2B,a.PERIOD2,a.PERIOD3LABEL,a.PERIOD3B,a.PERIOD3,a.PERIOD4LABEL,a.PERIOD4B,a.PERIOD4,a.PERIOD5LABEL,a.PERIOD5B,a.PERIOD5,a.PERIOD6LABEL,a.PERIOD6B,a.PERIOD6,a.PERIOD7LABEL,a.PERIOD7B,a.PERIOD7,a.PERIOD8LABEL,a.PERIOD8B,a.PERIOD8,a.PERIOD9LABEL,a.PERIOD9B,a.PERIOD9,a.PERIOD10LABEL,a.PERIOD10B,a.PERIOD10,a.PERIOD11LABEL,a.PERIOD11B,a.PERIOD11,a.PERIOD12LABEL,a.PERIOD12B,a.PERIOD12,a.PERIODNLABEL,a.PERIODNB,a.PERIODN,a.NOTES,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".CONTROLUSAGEBYPERIODS a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();
sqlScript="UPDATE "+schemaName+".RESOURCE_BUNDLE_c b SET(SID,NAME,LANGUAGE,COUNTRY,VARIANT,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.NAME,a.LANGUAGE,a.COUNTRY,a.VARIANT,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".RESOURCE_BUNDLE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".RESOURCE_c b SET(SID,_KEY,_VALUE,RESOURCEBUNDLE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a._KEY,a._VALUE,a.RESOURCEBUNDLE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".RESOURCE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".TRUEFALSE_c b SET(SID,TABLENAME,QUALIFIER,SHOW001,SHOW002,SHOW003,SHOW004,SHOW005,SHOW006,SHOW007,SHOW008,SHOW009,SHOW010,SHOW011,SHOW012,SHOW013,SHOW014,SHOW015,SHOW016,SHOW017,SHOW018,SHOW019,SHOW020,SHOW021,SHOW022,SHOW023,SHOW024,SHOW025,SHOW026,SHOW027,SHOW028,SHOW029,SHOW030,SHOW031,SHOW032,SHOW033,SHOW034,SHOW035,SHOW036,SHOW037,SHOW038,SHOW039,SHOW040,SHOW041,SHOW042,SHOW043,SHOW044,SHOW045,SHOW046,SHOW047,SHOW048,SHOW049,SHOW050,SHOW051,SHOW052,SHOW053,SHOW054,SHOW055,SHOW056,SHOW057,SHOW058,SHOW059,SHOW060,SHOW061,SHOW062,SHOW063,SHOW064,SHOW065,SHOW066,SHOW067,SHOW068,SHOW069,SHOW070,SHOW071,SHOW072,SHOW073,SHOW074,SHOW075,SHOW076,SHOW077,SHOW078,SHOW079,SHOW080,SHOW081,SHOW082,SHOW083,SHOW084,SHOW085,SHOW086,SHOW087,SHOW088,SHOW089,SHOW090,SHOW091,SHOW092,SHOW093,SHOW094,SHOW095,SHOW096,SHOW097,SHOW098,SHOW099,SHOW100,SHOW101,SHOW102,SHOW103,SHOW104,SHOW105,SHOW106,SHOW107,SHOW108,SHOW109,SHOW110,SHOW111,SHOW112,SHOW113,SHOW114,SHOW115,SHOW116,SHOW117,SHOW118,SHOW119,SHOW120,SHOW121,SHOW122,SHOW123,SHOW124,SHOW125,SHOW126,SHOW127,SHOW128,SHOW129,SHOW130,SHOW131,SHOW132,SHOW133,SHOW134,SHOW135,SHOW136,SHOW137,SHOW138,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.TABLENAME,a.QUALIFIER,a.SHOW001,a.SHOW002,a.SHOW003,a.SHOW004,a.SHOW005,a.SHOW006,a.SHOW007,a.SHOW008,a.SHOW009,a.SHOW010,a.SHOW011,a.SHOW012,a.SHOW013,a.SHOW014,a.SHOW015,a.SHOW016,a.SHOW017,a.SHOW018,a.SHOW019,a.SHOW020,a.SHOW021,a.SHOW022,a.SHOW023,a.SHOW024,a.SHOW025,a.SHOW026,a.SHOW027,a.SHOW028,a.SHOW029,a.SHOW030,a.SHOW031,a.SHOW032,a.SHOW033,a.SHOW034,a.SHOW035,a.SHOW036,a.SHOW037,a.SHOW038,a.SHOW039,a.SHOW040,a.SHOW041,a.SHOW042,a.SHOW043,a.SHOW044,a.SHOW045,a.SHOW046,a.SHOW047,a.SHOW048,a.SHOW049,a.SHOW050,a.SHOW051,a.SHOW052,a.SHOW053,a.SHOW054,a.SHOW055,a.SHOW056,a.SHOW057,a.SHOW058,a.SHOW059,a.SHOW060,a.SHOW061,a.SHOW062,a.SHOW063,a.SHOW064,a.SHOW065,a.SHOW066,a.SHOW067,a.SHOW068,a.SHOW069,a.SHOW070,a.SHOW071,a.SHOW072,a.SHOW073,a.SHOW074,a.SHOW075,a.SHOW076,a.SHOW077,a.SHOW078,a.SHOW079,a.SHOW080,a.SHOW081,a.SHOW082,a.SHOW083,a.SHOW084,a.SHOW085,a.SHOW086,a.SHOW087,a.SHOW088,a.SHOW089,a.SHOW090,a.SHOW091,a.SHOW092,a.SHOW093,a.SHOW094,a.SHOW095,a.SHOW096,a.SHOW097,a.SHOW098,a.SHOW099,a.SHOW100,a.SHOW101,a.SHOW102,a.SHOW103,a.SHOW104,a.SHOW105,a.SHOW106,a.SHOW107,a.SHOW108,a.SHOW109,a.SHOW110,a.SHOW111,a.SHOW112,a.SHOW113,a.SHOW114,a.SHOW115,a.SHOW116,a.SHOW117,a.SHOW118,a.SHOW119,a.SHOW120,a.SHOW121,a.SHOW122,a.SHOW123,a.SHOW124,a.SHOW125,a.SHOW126,a.SHOW127,a.SHOW128,a.SHOW129,a.SHOW130,a.SHOW131,a.SHOW132,a.SHOW133,a.SHOW134,a.SHOW135,a.SHOW136,a.SHOW137,a.SHOW138,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".TRUEFALSE a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

sqlScript="UPDATE "+schemaName+".RATE1F_c b SET(SID,USERTYPE,PRODTYPE,STEPNAME,STEP,VALUE,EFFDATE,ENDDATE,INCENTIVE,IEFFDATE,IENDDATE,STATUSFL,STATUSFLDT,OWNER,OWNER2)=(a.SID,a.USERTYPE,a.PRODTYPE,a.STEPNAME,a.STEP,a.VALUE,a.EFFDATE,a.ENDDATE,a.INCENTIVE,a.IEFFDATE,a.IENDDATE,a.STATUSFL,a.STATUSFLDT,a.OWNER,a.OWNER2)FROM "+schemaName+".RATE1F a where((a.sid=b.sid) AND (a.STATUSFLDT<>b.STATUSFLDT) and a.owner2=:owner2)";
q=entityManager.createNativeQuery(sqlScript);
q.setParameter("owner2", owner2Code);updatedCount=updatedCount+q.executeUpdate();

      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("removed")+": "+deletedCount+" "+ bundle.getString("updated")+": "+updatedCount+" "+bundle.getString("inserted")+": "+insertedCount,""));
*/


// update client record field carcsize to show last backupdate as a varchar
     sqlScript="update "+schemaName+".client set carcsize=:backupdts where owner2=:owner2Code";
      q = entityManager.createNativeQuery(sqlScript);
      q.setParameter("owner2Code", owner2Code).setParameter("backupdts", sdf.format(calendar.getTime()));
      q.executeUpdate();
} catch (Exception e) {
      int len=sqlScript.length();
      len=len>120?120:len;
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(
       FacesMessage.SEVERITY_INFO,bundle.getString("error")+" "+bundle.getString("in")+" "+bundle.getString("backup to _c ")+" "+sqlScript.substring(0,len) + ", "+e.getMessage(),""));

}



	 return "backUp site to _c done";
}


    /**
    * used by taskAgent to send schedule reminders via sqlSupport
    * can also be manually invoked from master site in schedulelist
    * scan through all schedules, any owner2, and if type is remind and start day is next day send email
    * copy esend logic to send reminder email
    * catch exception, log and continue
    *@see taskAgent
    */
    public void emailReminders(String emailBy) {
      fxxxuq89bxwwqqhxxxxxschedule=null;
      List<Fxxxuq89bxwwqqhxxxxxschedule> sresults=null;
      sresults=getSuggestList("email");//get those schedules which are due next day
      Iterator<Fxxxuq89bxwwqqhxxxxxschedule> itr = sresults.iterator();
      int totalEntries=0;
      int foundEntries=0;
      while (itr.hasNext()) {
 	  fxxxuq89bxwwqqhxxxxxschedule = itr.next();
          if(fxxxuq89bxwwqqhxxxxxschedule.getBexxuxxrbv37xxxxxxxxtype().equals("1d")){
           totalEntries=totalEntries+1;
           //jay tbd add email to employee etc attached to this schedule
           calendar = Calendar.getInstance();
           calendar.add(Calendar.DATE, 2);// GMT 11pm wise day after next
           calendare.setTime(fxxxuq89bxwwqqhxxxxxschedule.getB5gxdxsdbvxxxxxxxxxxsdatet());
           if(!(calendar.get(Calendar.YEAR) == calendare.get(Calendar.YEAR) &&
            calendar.get(Calendar.DAY_OF_YEAR) == calendare.get(Calendar.DAY_OF_YEAR))){
            continue;
           }
          }
          //setDateTimes(fxxxuq89bxwwqqhxxxxxschedule.getB2xxuxsxbvxxxxxxxxxxssdatet());
          foundEntries=foundEntries+1;
          setDescript(fxxxuq89bxwwqqhxxxxxschedule.getB1xxhszsbv35xxxxxxxxdescript());
          setDateTimes(new SimpleDateFormat("yyyy.MMM.dd.HH.mm").format(fxxxuq89bxwwqqhxxxxxschedule.getB5gxdxsdbvxxxxxxxxxxsdatet()));
          try{
           emailRender("/scheduleReminderContent.fmt");//sent to employee for this schedule or clientEmail or jay gmail
          }catch (Exception ex){
	   log.severe("Error in emailRender, "+ ex);//continue, user need not know
          }

      }
      log.severe("Info schedule email reminders Total/Found "+ totalEntries+", "+foundEntries);//continue, user need not know

    }

  public String getDescript() {
    return descript;
  }

  public void setDescript(String descript) {
    this.descript = descript;
  }

  public String getDateTimes() {
    return dateTimes;
  }

  public void setDateTimes(String dateTimes) {
    this.dateTimes = dateTimes;
  }


    public List<Fxxxuq89bxwwqqhxxxxxschedule> getSuggestList(String prefix) {
     if(prefix !=null && (prefix.isEmpty() || prefix.equals("email")) ){
      prefix="0";
     }
     int mclosed=16;
     String type="1d";//one day reminder 1h one hour
     Date toDay= calendar.getTime();

     return entityManager.createQuery(" select cc from Fxxxuq89bxwwqqhxxxxxschedule cc where cc.a0xxhkscbxxxxxxxxxxxtodo >=:keyOfEntity AND cc.z1xxzzfxhhxxxxxxxxxxstatusfl <> :flag AND (cc.bexxuxxrbv37xxxxxxxxtype=:type  AND cc.b5gxdxsdbvxxxxxxxxxxsdatet >= CURRENT_DATE)   order by cc.a0xxhkscbxxxxxxxxxxxtodo  ")
      .setParameter("keyOfEntity", prefix).setParameter("flag", mclosed).setParameter("type", type)
      .getResultList();
    }

      public void emailRender(String content) throws MessagingException, IOException{
         /// called by another method here  schedule emailReminder
         // need to inlude employee/customer/vendor emails based on Icalsend logic
         // for now send to  originator ie logon id email
         // addes content bot
         //String fromName = "raaspi";//site name
         String fromName = customIdentity.getMasterSiteCode();//master site owner2
         String clientEMail = customIdentity.getMasterSiteEmail();
         String replyToAddress=clientEMail;
         String eMailFirstName="";
         String eMailLastName="";
         String replyToName="";
         String mailingSubject="";
         String headers ="";
         String resourceName="";

         // mail relay is done using @3rcomputer.com mail service, so fromAddress should match domain name
         String fromAddress="";
         String mailingAddress="jaymitra2@gmail.com";
         if(!mailRelayOff){
          fromAddress=clientEMail;
         }else{
          fromAddress=clientEMail; // to cover all sites
         }
         replyToName= " ";
         String toName = " ";
         String toAddress = "support@3rcomputer.com";

         String ccName = "ratna";
         String ccAddress = "";

         String htmlBody = "<html><body><b>Hello</b> World!</body></html>";
         String textBody = "This is a Text Body!";

         String ENVELOPE_FROM_ADDRESS = "support@3rcomputer.com";

         //SessionConfig mailConfig = TestMailConfigs.standardConfig();
         String messageId = "jay@3rcomputer.com";
         int port=587;//465 is used for ssl only, which is replaced by tls. 587 is used by both tls and non ssl
         String userName="apikey";
         // make this configurable via value held in client record 05
         String host="smtp.sendgrid.net";
         String password="SG.B0.............iBg";
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
         //owner2Code="raaspi";
         owner2Code=customIdentity.getMasterSiteCode();

         Yxxxch522xhhxxhxxxxxclient client;
         try {
          client =(Yxxxch522xhhxxhxxxxxclient) entityManager
	   .createQuery(
		"select cc from Yxxxch522xhhxxhxxxxxclient where a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
		.setParameter("nKeyName","05")
		.setParameter("owner2", owner2Code)
		.getSingleResult();

          if (client == null) {
	   log.severe("Error getting master site client record 05 for mail relay (bulk mail) ");
          }else{
           host=client.getDaxxuzxdssxxxxxxxxxxapiclientid().trim();
           password=client.getDbxxuzxdssxxxxxxxxxxapiclientsecret().trim();
           userName=client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser();
          }
         } catch (Exception exc) {
	    log.severe("Error getting raaspi client record 05, mail relay (bulk mail) info missing "+exc.getMessage());
         }


         try {
          client =(Yxxxch522xhhxxhxxxxxclient) entityManager
	   .createQuery(
		"select cc from Yxxxch522xhhxxhxxxxxclient where a0xxukxxbvxxxxxxxxxxclientversion = :nKeyName and zzxxu2oxxhxxxxxxxxxxowner2 = :owner2")
		.setParameter("nKeyName","01")
		.setParameter("owner2", owner2Code)
		.getSingleResult();

          if (client == null) {
	   log.severe("Error getting master site client record 01");

           return ;
          }
          if(client.getP1xxfxxxbvxxxxxxxxxxconfirm()!=null ){
                        mailRelayOff=client.getP1xxfxxxbvxxxxxxxxxxconfirm();
                      }else{//null means default is mailrelay
                        mailRelayOff=false;
                      }
                      if(!mailRelayOff){
                       //sendgrid host,userName, password already set from client record 05
                       //added logic to use version 05 client record to avoid hard coding and any mail relay
                       if(host.isEmpty() || password.isEmpty() || userName.isEmpty()){
	                log.severe("mail Relay needs non empty value "+"id:"+host+" key: "+password+" and userName: "+userName);
                        return;
                       }
                      }else{
                       if(client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver()!=null && !client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver().isEmpty()){
                        host=client.getZ8xxuxxxbvxxxxxxxxxxsmtpserver();
                       }else{
                         smtpError=true;
	                 log.severe("Error getting raaspi vclient record host info");
                       }
                       if(client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser()!=null && !client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser().isEmpty()){
                        userName=client.getZ9xxuxxxbvxxxxxxxxxxsmtpuser();
                       }else{
                         smtpError=true;
	                 log.severe("Error getting raaspi client record smtp username missing ");
                       }
                       if(client.getZaxxuxxxssxxxxxxxxxxsmtppass()!=null && !client.getZaxxuxxxssxxxxxxxxxxsmtppass().isEmpty()){
                        password=client.getZaxxuxxxssxxxxxxxxxxsmtppass();
                       }else{
                       }
                       if(client.getL6xxzxxrbvxxxxxxxxxxaltselen()!=null && client.getL6xxzxxrbvxxxxxxxxxxaltselen() !=0){
                        port=client.getL6xxzxxrbvxxxxxxxxxxaltselen();
                       }else{
                         smtpError=true;
	                 log.severe("Error getting raaspi client record smtp port missing ");

                       }
                       if(client.getO9xxfxxxbvxxxxxxxxxxbeepsou()!=null ){
                        auth=client.getO9xxfxxxbvxxxxxxxxxxbeepsou();
                       }else{
                         smtpError=true;
	                 log.severe("Error getting raaspi client record smtp authinfo missing ");

                       }
                       if(client.getP2xxfxxxbvxxxxxxxxxxlinefeed()!=null ){
                        tls=client.getP2xxfxxxbvxxxxxxxxxxlinefeed();
                       }else{
                         smtpError=true;
	                 log.severe("Error getting raaspi client record smtp ssl missing ");
                       }
                       if(smtpError){
                        bcontinue=false;
                        return ;
                       }
          }
         } catch (Exception exc) {
	                 log.severe("Error getting raaspi client record smtp info missing ");

            bcontinue=false;
            return ;
         }
         String smtpDomain="";
         urlIndex=host.indexOf(".");
         if (urlIndex != -1){
          smtpDomain=host.substring(urlIndex+1);
         }
         if(smtpDomain.isEmpty()){
	   log.severe("Error getting master site client record smtp domain, info missing ");
           return ;
         }

         SessionConfig mailConfig = TestMailConfigs.standardConfig(host,port,userName,password,auth,tls,auth_mechanisms);


         EmailMessage e;

         String uuid = java.util.UUID.randomUUID().toString();
         String subjectTemplate = "Text Message from 4.0.0 Mail - " + uuid;
         String version = "simple-mail";
         String subject = "Text Message from " + version + " Mail - " + uuid;
         resourceName="scheduleReminderContent.fmt";
         toName = eMailFirstName+" "+eMailLastName;
         toAddress = "support@3rcomputer.com";
         subjectTemplate=mailingSubject;
         boolean anyAtt=false;
         MailMessage mm =null;

       try{
          // faces env nullsubjectTemplate=bundle.getString("Reminder")+"- "+bundle.getString("Scheduled")+" "+bundle.getString("event");
          subjectTemplate="Reminder- Scheduled event";
          toName="";// mailingAddress set by esend using mailTo, headers are empty todo allow multilingual
          toAddress=mailingAddress;
          resourceName="scheduleReminderContent.fmt";

          // if usertoEmployee has Email then use it , if empty then use client which should have some value
          // instead of inject use query. schedule > employee > email
          if(fxxxuq89bxwwqqhxxxxxschedule.getJxxxbh400xwwqqhxxxxxemployee() !=null &&
           fxxxuq89bxwwqqhxxxxxschedule.getJxxxbh400xwwqqhxxxxxemployee().getN4xxhxxrbv24xxxxxxxximailaddr() !=null){
            toAddress=fxxxuq89bxwwqqhxxxxxschedule.getJxxxbh400xwwqqhxxxxxemployee().getN4xxhxxrbv24xxxxxxxximailaddr().trim();
          }
          else{
            toAddress=client.getD4xxhxxrbv24xxxxxxxximailaddr().trim();
          }
          //any toAddess hardcoded below for a content is used
          if(content.equals("bot")){
           subjectTemplate="Alert- bot detected";
           toAddress="support@3rcomputer.com";
           setDescript("RAASPI bot Alert");
           setDateTimes("2020");

          }
          if(content.substring(0,8).equals("@notify-")){
           subjectTemplate="Notification- take Action";
           toAddress="support@3rcomputer.com";
           setDescript(content);
           setDateTimes("Now");

          }
          if(content.substring(0,8).equals("@notifC-")){
           String[] msgsList = content.substring(8).split(",");
           toAddress=msgsList[0];//first part which has customer email
           subjectTemplate="Quotation request confirmation";
           setDescript(content.substring(8));
           setDateTimes("Now");

          }



          if(!mailRelayOff){
           try {
            SMTPAPI header = new SMTPAPI();
            // jay put sender's name here instead of blank ie loop through but dont send ?, mailInfo may already have attach info
            // build x-smtpi header
            header.addCategory(owner2Code);// can be used in webhook
            header.addTo(toAddress);
            header.addSubstitution("keyx", "ignore");
            header.addSubstitution("unx", "0");
            headers = header.jsonString();
           }catch (Exception ex){
	    log.severe("Error creating smtpi-X,"+ ex);//continue, user need not know
           }

            e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(resourceName)).getInput()))
                            .put("sqlSupport", this).addHeader("X-SMTPAPI",headers).importance(MessagePriority.HIGH).send();
           log.severe("schedule reminder using relay for "+ toAddress);//continue, user need not know
          }else{
            //no mail Relay
            e =
                    new MailMessageImpl(mailConfig).from(MailTestUtil.getAddressHeader(fromName, fromAddress)).replyTo(replyToAddress).to(MailTestUtil.getAddressHeader(toName, toAddress)).subject(
                            new FreeMarkerTemplate(subjectTemplate)).bodyHtml(new FreeMarkerTemplate(Resources.newInputStreamSupplier(Resources.getResource(resourceName)).getInput()))
                            .put("sqlSupport", this).importance(MessagePriority.HIGH).send();
          }
          log.severe("schedule reminder no relay for "+ toAddress);//continue, user need not know

        }catch(Exception ex){
 	    log.severe("Error in sending email "+ ex);//continue
          String cause="";
          if(ex.getCause() !=null && ex.getCause().getCause()!=null){
           cause=ex.getCause().getCause().getMessage();
	   log.severe("Error gsending reminder email "+ex.getCause().getCause().getMessage());
          }
        }
    }






	private Connection getConnection() throws SQLException, NamingException {
                //taskagent is a scheduled task, no servlet involved
                if(context==null){
                 Session session = entityManager.unwrap(Session.class);
                 SessionImpl sessionImpl = (SessionImpl) session;
                 return sessionImpl.connection();	
                }else{
		 return getDataSource().getConnection();
                }
	}
	private DataSource getDataSource() throws NamingException {
                        String serverName=context.getServerInfo();//servletContext, check if tomcat or wildfly
                        if(serverName.contains("omcat")){
                         tomeeYN=true;
                        }
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



}

