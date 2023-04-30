package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext; 
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpServletRequest;

import java.util.ResourceBundle.Control;
import java.util.logging.Logger;
import javax.inject.Named;
import java.io.IOException;
import java.util.ListResourceBundle;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;



@Named("databaseResourceLoader")
public class DatabaseResourceLoader extends ResourceBundle {

       private Locale locale;
       Locale rbLocale;
       private Boolean bcontinue = new Boolean("true");
      private DataSource ds;

    protected static final String BUNDLE_NAME ="m";
    protected static final Control DB_CONTROL = new DBControl();
    private Logger log = Logger.getLogger(DatabaseResourceLoader.class.getCanonicalName());
     @PersistenceContext(unitName = "genappcdi")
     private EntityManager em;


    //private Map<String, String> messages;

    public DatabaseResourceLoader() {
       try{
        rbLocale=FacesContext.getCurrentInstance().getViewRoot().getLocale();

        setParent(ResourceBundle.getBundle(BUNDLE_NAME, 
            locale, DB_CONTROL));
       }catch(Exception e){
          String emsg=e.getMessage();
          locale=new Locale("en","US","o2");
          setParent(ResourceBundle.getBundle(BUNDLE_NAME,locale, DB_CONTROL));
          if(rbLocale !=null){
 	   //log.severe("Used locale enUSo2 after DatabaseResourceLoader error with locale "+rbLocale.getLanguage()+","+rbLocale.getCountry()+","+rbLocale.getVariant()+" "+emsg );
          }else{
 	   //log.severe("Used locale enUSo2 after DatabaseResourceLoader error, locale was null "+emsg );
          }
       }
    }
    @Override
    protected Object handleGetObject(String key) {
//        return messages != null ? messages.get(key) : parent.getObject(key);
   try{
    if(parent.getObject(key) == null){
     return key;
    }else{
     return parent.getObject(key);
    }
   }catch(Exception e){
     return key;
   }

   }

    @Override
    public Enumeration<String> getKeys() {
        //return messages != null ? Collections.enumeration(messages.keySet()) : parent.getKeys();
    return parent.getKeys();

    }

        public void reLoadBundle(String bundleName,String owner2Code){
         //menCA, strip off m
         ResourceBundle bundle=null;
         String lang=bundleName.length()>1?bundleName.substring(1,3):"en";
         String countr="US";
         bundleName="m";
         try{
          bundle = ResourceBundle.getBundle(bundleName, new Locale(lang, countr,owner2Code)); 
          bundle.clearCache();
         }catch(Exception e){
          String emsg=e.getMessage();
 	  log.severe("Ignoring ReloadBundle-getBundle error "+lang+","+countr+","+owner2Code+" "+e );

          //log error
         }
         try{
          // ResourceBundle.clearCache(Thread.currentThread().getContextClassLoader());

          //         ApplicationResourceBundle appBundle = ApplicationAssociate.getCurrentInstance().
          //                         getResourceBundles().get(DatabaseResourceLoader.class.getName());

           Class<?> applicationAssociateClass = Class.forName("com.sun.faces.application.ApplicationAssociate");
           Method getCurrentInstance = applicationAssociateClass.getMethod("getCurrentInstance");
           Object applicationAssociate = getCurrentInstance.invoke(null);
           Method getResourceBundles = applicationAssociate.getClass().getMethod("getResourceBundles");
           Map<String, ?> resourceBundles = (Map<String, ?>)getResourceBundles.invoke(applicationAssociate);
           Object appBundle = resourceBundles.get("messages");
           Map<Locale, ResourceBundle> resources = getFieldValue(appBundle, "resources");
           //Map resources = getFieldValue(appBundle, "resources");
           resources.clear(); 
         }catch(Exception e){
          String emsg=e.getMessage();
 	  log.severe("ReloadBundle-clearCashe error "+lang+","+countr+","+owner2Code+" "+e );

          //log error
         }

        }
      @SuppressWarnings("unchecked")
      private static <T> T getFieldValue(Object object, String fieldName) {
       try {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(object);
       } catch (Exception e) {
        return null;
       }
      }





    protected static class DBControl extends Control {
     Locale mlocale;
     String mlanguage;
     String mcountry;
     String mvariant;
     EntityManager em;
     EntityManagerFactory emf;
     private DataSource ds;
     private Boolean tomeeYN = false;//jun10 2021 to allow myfaces vs mojarra jsf or jndi naming
     private Logger log = Logger.getLogger(DatabaseResourceLoader.class.getCanonicalName());


     @Override
     public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
                        Map<String, Object> configOverrides = new HashMap<String, Object>();
      FacesContext facesContext = FacesContext.getCurrentInstance();
      if (facesContext !=null){ 
       ExternalContext externalContext = facesContext.getExternalContext();
       ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();

                        String serverName=context.getServerInfo();//jun10 2021 check if tomcat or wildfly
                        if(serverName.contains("omcat")){
                         tomeeYN=true;
                        }
                        try{
 	                    //log.severe("tomeeYN "+tomeeYN ); flag checked by getDatasource()
 	                    //log.severe("getdatasource result "+getDataSource() );
                            configOverrides.put("javax.persistence.jtaDataSource", getDataSource());
                        }catch(Exception e){
                         String emsg=e.getMessage();
 	                 log.severe("getdatasource error "+emsg );

                         //log error
                        }
                        emf = Persistence.createEntityManagerFactory("genappcdi", configOverrides);
                        Map<String, Object> emfproperties = emf.getProperties();
                        //log.severe("proemf "+emfproperties);
                        //EntityManagerFactory emf = Persistence.createEntityManagerFactory( "genappcdi" );
                        em=emf.createEntityManager(configOverrides);
      }//facescontext not null 
      Map<String, Object> emproperties = emf.getProperties();
      //log.severe("proem "+emproperties);
      //log.severe("em "+em);
      return new MyResources(locale);
     }

	private DataSource getDataSource() throws NamingException {
		if (ds == null) {
                    try{
		     Context ctx = new InitialContext();
                     if(tomeeYN){//jun10 2021
                      ds = (DataSource) ctx.lookup("java:openejb/Resource/RaaspiSQLDS");  
                     }else{
                      ds = (DataSource) ctx.lookup("RaaspiSQLDS");   
                     }
                    }catch(Exception e){
                     String emsg=e.getMessage();
 	             log.severe("getdatasource lookup error "+emsg );
                    }
		}
		return ds;
	}


        /**
         * A simple ListResourceBundle extension to support multilanguages and variants  m/language/US/variant
           country hardcoded US to make logic simple to support variant 
         */
        protected class MyResources extends ListResourceBundle {
           // in footer.xhtml, language and country values are set to SessionMap as mlanguage and mcountry
           // sessionmap not used/not needed ? we set locale now and use it directly to get lang etc
           // see authenticator,skinbean for 
           // new try FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
           // if cached, wont come here, so dont change language here


            private Locale locale;
            String jayName="m";
            String owner2Code="raaspi";

            /**
             * ResourceBundle constructor with locale
             *
             * @param locale
             */
            public MyResources(Locale locale) {
                this.locale = locale;
            }

            @Override
            protected Object[][] getContents() {
            try{
              mlanguage=locale.getLanguage();
              if(mlanguage != null && !mlanguage.isEmpty()){
               mcountry=locale.getCountry();//country is hardcoded as US for language locale use
               if(locale.getVariant() != null){
                mvariant=locale.getVariant();// set in authenticator as owner2Code or in future as owner2Code+country
               }else{
                mvariant="";
               } 
               mlocale=new Locale(mlanguage,mcountry,mvariant);
               owner2Code=locale.getVariant();
              }else{
               mlocale=new Locale("","","");
              }
             //order by sid ensures owner key , if present, will replace system key
             //locale satisfies java resourceBundle but jayName satisfies genapp resourceBundle
             // resourceBundle variant column is 2 ch onle so map variant o2 to owner2Code and oc to owner2Code+2ch country
             jayName="m"+mlocale.getLanguage()+mlocale.getCountry();
            }catch(Exception e){
             //as if no locale
             jayName="m";
            }
            try{ 
                String urlName=null;
                int i = 0;
                List <Yxxxuq1r1xwwqqhxxxxxresource> results=null;
                if(mlocale.getVariant() !=null && !mlocale.getVariant().isEmpty() ) {
                    results=em.createQuery("select r from Yxxxuq1r1xwwqqhxxxxxresource r  where ((r.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname = :jayNameLn or r.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname = :jayName or r.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname = :jayNameO2 or r.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname = :jayNameOc) and r.zzxxu2oxxhxxxxxxxxxxowner2=:owner2) order by r.a0xxuobxbxxxxxxxxxxxsid asc").setParameter("jayNameLn", "m"+mlocale.getLanguage())
                     .setParameter("jayName", jayName).setParameter("jayNameO2", jayName+"o2").setParameter("jayNameOc", jayName+"oc").setParameter("owner2", owner2Code).getResultList();
                }else {	  
                    //only last key is kept so order should be asc to show more recent change ie client change after system           
                    results=em.createQuery("select r from Yxxxuq1r1xwwqqhxxxxxresource r  where r.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname = :jayName and (r.zzxxu2oxxhxxxxxxxxxxowner2='SYSTEM') order by r.a0xxuobxbxxxxxxxxxxxsid asc").setParameter("jayName", jayName).getResultList();
                }
                Object[][] all = new Object[results.size()][2];

			Iterator<Yxxxuq1r1xwwqqhxxxxxresource> itr = results.iterator();
			while (itr.hasNext()) {
			  Yxxxuq1r1xwwqqhxxxxxresource yxxxuq1r1xwwqqhxxxxxresourceli = itr.next();
		          all[i]=new Object[]{yxxxuq1r1xwwqqhxxxxxresourceli.getA0xxukrdbvxxxxxxxxxxkey(),yxxxuq1r1xwwqqhxxxxxresourceli.getA1xxuxxxbvxxxxxxxxxxvalue()};
                           i++;
			}

                        return all;
            }catch(Exception e){
             //checkCreateTables();//moved to Authenticator ,will do a quick return here or create tables etc and return here
     	      log.severe("Returning null after ListResourceBundle error "+jayName+" "+e );
              return null;
            }
          }

       }
     }





}