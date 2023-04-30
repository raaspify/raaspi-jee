package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.ResourceBundle;
import java.io.IOException;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.persistence.*;
import javax.inject.Named;
import java.lang.reflect.Method;
import java.util.Map;
import java.lang.reflect.Field;
import com.sun.faces.application.ApplicationAssociate;
import com.sun.faces.application.ApplicationResourceBundle;
import java.util.logging.Logger;






@Named("DBControl")
public class DBControl extends Control {
//   @PersistenceContext(unitName = "genappcdi")
@PersistenceUnit(unitName = puName)
   String puName="genappcdil";
   EntityManagerFactory emf;
   //EntityManagerFactory emf = Persistence.createEntityManagerFactory( puName );
   EntityManager em=emf.createEntityManager();

   Locale mlocale;
   String mlanguage;
   String mcountry;
   String mvariant;
   private Logger log = Logger.getLogger(DBControl.class.getCanonicalName());


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

        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
            return new MyResources(locale);
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
    	     log.severe("Returning null after ListResourceBundle error "+jayName+" "+e );

             return null;
            }
          }

       }
}