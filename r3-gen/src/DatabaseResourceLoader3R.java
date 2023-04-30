package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext; 
import java.util.ResourceBundle.Control;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.transaction.Transactional;
import java.io.Serializable;
import javax.persistence.*;



///each page uses f:view locale="#{authenticator.locale} via rtemplate and authenticator is session scoped
/// at this point bean messages not using locale but can be added by adding locale to method call
///general flow:locale not in cache comes here, sets parent a new bundle using the locale
/// once created here or if locale bundle already exists then handleGetObject is called
@Named("databaseResourceLoader")
//@SessionScoped

public class DatabaseResourceLoader extends ResourceBundle {
       private Locale locale;
       Locale rbLocale;
       String BUNDLE_NAME ="m";
       private Logger log = Logger.getLogger(DatabaseResourceLoader.class.getCanonicalName());
     @PersistenceContext(unitName = "genappcdi")
     private EntityManager entityManager;


public DatabaseResourceLoader() {
       try{
        /// before coming here we need to change locale 
        /// if in server cache, wont come here, so once server is up for a while or no clearCache no activity here
        ///comes here if a new locale is detected. different browsers or users may change locale
        /// to support owner2Code as variant, locale used by resourcebundle ie DBControl needs to be 
        /// m_en_US_raaspi or m_en_US_codeitnow or m_fr_US_raaspi ie m_nanguage_US_variant. for resourcebundle all countries
        /// are mapped to US  to workaround the restriction of variant after country 
        /// we still need to use the original country code outside resourcebundle for currency and date localization 
        rbLocale=FacesContext.getCurrentInstance().getViewRoot().getLocale();
        //apr 05 2015 (in openshift wildfly only not in local wildfly) exceptions if non supported language comes
        //java.util.MissingResourceException: Can't find bundle for base name com.rcomputer.genapp.action.DatabaseResourceLoader, locale cs_US_3rcomputer 
        // tested using curl --header "Accept-Language:cs-BR;q=0.8,en-US;q=0.6,en;q=0.4" -v -i -X GET http://mybusinessp.lraaspi.com:8080/home
        //allow only en/de/fr/bn before coming here and if any exception then use default locale en/US/o2
        try{
         //2021apr16 try catch added, now at least works without locale 

         setParent(ResourceBundle.getBundle(BUNDLE_NAME,rbLocale, new DBControl()));
        }catch(Exception e){
 	 //log.severe("setParent in resourceBundle error "+e.getMessage() );
         e.printStackTrace();
        }
       }catch(Exception e){
          String emsg=e.getMessage();
          locale=new Locale("en","US","o2");
          setParent(ResourceBundle.getBundle(BUNDLE_NAME,locale, new DBControl()));
          if(rbLocale !=null){
 	   log.severe("Used locale enUSo2 after DatabaseResourceLoader error with locale "+rbLocale.getLanguage()+","+rbLocale.getCountry()+","+rbLocale.getVariant()+" "+emsg );
          }else{
 	   log.severe("Used locale enUSo2 after DatabaseResourceLoader error, locale was null "+emsg );
          }
       }

    }

  @Override
  protected Object handleGetObject(String key) {
   /// for each web page message or bean message bundle request it comes here
   /// before coming here, we need to alter the locale to m_nanguage_US_variant so that it will match the existing resource bundles locale
   /// message is searched by locale hierarchy and if not found base bundle is used
   /// m_lang_US_owner2Code value, if not found then m_lang_US , if not found m_lang , if not found m , if not found key 
   /// itself
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
  public Enumeration getKeys() {
    return parent.getKeys();
  }
}