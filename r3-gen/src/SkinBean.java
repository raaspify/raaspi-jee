/**
 *
 */

package com.rcomputer.genapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;
import javax.inject.Inject;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;
import java.util.Locale;



/**
 * @author jay mitra
 * web.xml uses skinbean.skin to set Richfaces skin
 * Footer.xml sets the skinbean skin using valuechangelistener and submit() to set UserChosenSkin
 * skint is used by footer (before logon) and skin used by homeMockUp (logged in)  for the current session 
 * home f:event type="preRenderView" listener is used to invoke authenticator setClientChosenSkin which sets the skin and leftShown
 * homeMockUp uses h:link with Viewparams to set skin
 *
 */
@Named("skinBean")
@SessionScoped

public class SkinBean implements Serializable {
    /**
     *
     */
     @Inject
     Yxxxuq1n1xwwqqqxxxxxblobdataHome yxxxuq1n1xwwqqqxxxxxblobdataHome;
     @Inject CustomIdentity customIdentity;

    private static final long serialVersionUID = -2399884208294434812L;
    private static final String SKIN_VIEW_PARAMETER = "skin";
    // the following will make the property skin to default value r3WhiteModern at the begin of session
    // we can make it dynamic by using a proprty value and getter/setter for it
    // Client can set default skin via customization using scrcolor field
    // user can set default skin via userprofl scrcolor field
    // at login time authenticatorAction checks userprofl and then client record
    // client loccol true means showleft side, repcol true means show icons
    // save dropdown menu labels h:outputText font in hilcolor field and fontsize in baccolor client fields
    // naltseri same as hilcolor but for mobile or make it fixed
    // fonsize for quick change to size only and font for all properties including size 
    // Actual dtopdown menu itself ie rich:menuItem is controlled by stylesheet .rf-ddm-itm which uses client textcolor
    // need to try using menuitemfont instead
    // Font can be changed in website customization ie homemockup
    // properties with suffix t are used for user override if any override value , without t means for all  users for a client
    @ManagedProperty(value = "r3WhiteModern")
    //@ManagedProperty(value ="#{skin}")
    private String skin="r3WhiteModern";
    private List<String> skins;
    private LinkedHashMap<String,String> skinsList;
    private String tbHeight="";
    private String currentSkin = "r3WhiteModern";
    private String currentSkint = null;
    private String skint=null;
    private String menuFont="menu;";
    private String menuFontSize="16px";
    private String mobileMenuFontSize="14px";
    private String menuItemFont="italic bold 12px/30px Georgia, serif;";
    private String menuFontMobile="menu;";
    private String menuItemFontMobile="italic bold 12px/30px Georgia, serif;";
    private boolean leftShown=false;//sep30 2020
    private boolean leftShownt=false;
    private boolean iconShown=true;
    private boolean iconShownt=true;
    private boolean userSet=false;
    private boolean userSetIcon=false;
    private String  previewTh=null;
    private ResourceBundle bundle=null;
    String meta="";
    FacesContext fc=null;
    String owner2;
    int urlIndex=0;
     private Locale locale;
     String language="en";
     String country="US";
     String requestCountry;
     private int excpCount=0;
     private Integer holdSid=0;
     private String holdValue3="";







    @PostConstruct
    public void initialize() {
        skins = new ArrayList<String>();
        skins.add("blueSky");
        skins.add("classic");
        skins.add("deepMarine");
        skins.add("emeraldTown");
        skins.add("japanCherry");
        skins.add("ruby");
        skins.add("wine");
        skins.add("r3GreyModern");
        skins.add("r3WhiteModern");
        skins.add("r3WhiteModern.mobile");
        skins.add("r3WhiteCanvas");
        skinsList=new LinkedHashMap<String,String>();    
        skinsList.put("Default","r3WhiteModern");
        skinsList.put("Blue" , "blueSky");
        skinsList.put("Ruby" , "ruby");
        skinsList.put("Grey-Rounded" , "r3GreyModern");
        skinsList.put("White-Modern" , "r3WhiteModern");
        skinsList.put("White-Modern.mobile" , "r3WhiteModern.mobile");
        skinsList.put("Plain" , "null");
        skinsList.put("Pink-Olive" , "wine");
        skinsList.put("White-Canvas" , "r3WhiteCanvas");
       try{
        fc = FacesContext.getCurrentInstance();
        //session bean holds on to values for the session , so do not reload bundle 
        //apr03 2019 will it solve Can't find bundle for base name com.rcomputer.genapp.action.DatabaseResourceLoader, locale en_US 
        if(fc !=null && bundle ==null ){
         ExternalContext externalContext = fc.getExternalContext(); 
         String urlName=((javax.servlet.http.HttpServletRequest) externalContext.getRequest()).getServerName();
          urlIndex=urlName.lastIndexOf(".");
          if (urlIndex == -1){
            urlIndex=urlName.length();
          }       
          if (urlName.contains("www.")){
           owner2=urlName.substring(4,urlIndex);
          }else{
           owner2=urlName.substring(0,urlIndex);
          }
          //extract subdomain if used
          owner2=owner2.replace("."+customIdentity.getMasterSiteCode(),"");
         locale = externalContext.getRequestLocale();
         requestCountry=locale.getCountry();

         //apr 05 2019 allow supported language to avoid Can't find bundle ...locale cs_US_3rcomputer
         if( locale.getLanguage().equals("en") || locale.getLanguage().equals("fr") || locale.getLanguage().equals("de")  ){
           locale=new Locale(locale.getLanguage(),"US",owner2);
         }else{
          locale=new Locale("en","US",owner2);
         }

         bundle = fc.getApplication().getResourceBundle(fc, "messages");
        }
      }catch(Exception e){
      //log error
      excpCount=excpCount+1;
     }


    }

    // TODO: move to utility class. used in navigator also. not used
    private String getViewParameter(String name) {
        FacesContext fc = FacesContext.getCurrentInstance();
        String param = (String) fc.getExternalContext().getRequestParameterMap().get(name);
        if (param != null && param.trim().length() > 0) {
            return param;
        } else {
            return null;
        }
    }

    public String getSkin() {
        //String currentSkin = getViewParameter(SKIN_VIEW_PARAMETER);
        return currentSkin;
    }

    public void setSkin(String skin) {
        this.currentSkin = skin;
    }


    public String getSkint() {
        return currentSkint;
    }

    public void setSkint(String skin) {
        this.currentSkint = skin;
    }

    public boolean getUserSet() {
        return userSet;
    }

    public void setUserSet(boolean userSet) {
        this.userSet = userSet;
    }

    public String getPreviewTh() {
        return previewTh;
    }

    public void setPreviewTh(String previewTh) {
        this.previewTh = previewTh;
    }

    public boolean getUserSetIcon() {
        return userSetIcon;
    }

    public void setUserSetIcon(boolean userSet) {
        this.userSetIcon = userSetIcon;
    }

    public String getMenuFont() {
        return menuFont;
    }

    public void setMenuFont(String menuFont) {
        this.menuFont = menuFont;
    }

    public String getMenuFontMobile() {
        return menuFontMobile;
    }

    public void setMenuFontMobile(String menuFontMobile) {
        this.menuFontMobile = menuFontMobile;
    }

    public String getMenuFontSize() {
        return menuFontSize;
    }

   public void setMenuFontSize(String menuFontSize) {
        this.menuFontSize = menuFontSize;
    }

    public String getMobileMenuFontSize() {
        return mobileMenuFontSize;
    }

   public void setMobileMenuFontSize(String mobileMenuFontSize) {
        this.mobileMenuFontSize = mobileMenuFontSize;
    }


    public String getMenuItemFont() {
        return menuItemFont;
    }

    public void setMenuItemFont(String menuItemFont) {
        this.menuItemFont = menuItemFont;
    }
 
    public String getMenuItemFontMobile() {
        return menuItemFontMobile;
    }

    public void setMenuItemFontMobile(String menuItemFontMobile) {
        this.menuItemFontMobile = menuItemFontMobile;
    }

  public Integer getHoldSid() {
    return holdSid;
  }

  public void setHoldSid(Integer holdSid) {
    this.holdSid = holdSid;//may27 2019 needed by imageBrowse datascroller
  }


    public List<String> getSkins() {
        return skins;
    }

    public Map<String, String> getSkinsList(){
        return skinsList;
    }

    // following not used since same can be done via skin.properties
    // change this to alter non skinnable  css properties to match a skin or to make them user selectable 
    public String getTBHeight() {
        tbHeight="26px";
          if (skin.equals("r3Modern")){
            tbHeight = "82px";
          }
        return tbHeight;
    }

    public void setTbHeight(String tbHeight) {
        this.tbHeight = tbHeight;
    }
    public boolean getLeftShown(){
     return leftShown;
    }
    public void setLeftShown(boolean leftShown){
     this.leftShown= leftShown;
    }

    public boolean getLeftShownt(){
     return leftShownt;
    }
    public void setLeftShownt(boolean leftShownt){
     userSet=true;
     this.leftShownt= leftShownt;
    }

    public boolean getIconShown(){
     return iconShown;
    }
    public void setIconShown(boolean iconShown){
     this.iconShown= iconShown;
    }

    public boolean getIconShownt(){
     return iconShownt;
    }
    public void setIconShownt(boolean iconShownt){
     userSetIcon=true;
     this.iconShownt= iconShownt;
    }

    public Boolean ContainsSkin(String skin){
     if(skins.contains(skin)){
      return true;
     }
      return false;
     
    }
  public String getHoldValue3() {
    return holdValue3;
  }

  public void setHoldValue3(String holdValue3) {
    this.holdValue3 = holdValue3;
  }





    public void setCurrentSkin(String event){
        // dont set it , wont allow change use @managedProperty as above       currentSkin = "r3WhiteModern";
        FacesContext facesContext = FacesContext.getCurrentInstance(); 
        ExternalContext externalContext = facesContext.getExternalContext(); 
        HttpServletRequest req = (HttpServletRequest) externalContext.getRequest(); 
        if(req !=null && req.getHeader("user-agent") !=null && req.getHeader("user-agent").contains("Mobi")){
         currentSkin = "r3WhiteModern.mobile";
        }

    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String metaDescript(){
     if(owner2 == null){
      owner2="";
     }
     
     String defaultM="Visit "+owner2+" website for the latest updates";
     try{
     fc = FacesContext.getCurrentInstance();
     if(fc ==null || fc.getViewRoot()==null ){
        return defaultM;
     }
     String viewId = fc.getViewRoot().getViewId();
     String messg="";
     
     //three characters page ItemEdit ite clientFcal clf ItemDetailsBrowse idb cart cax
     if (meta != null && !meta.isEmpty()){
      return meta;
     }
     if(bundle == null){
      if(viewId !=null && !viewId.isEmpty()){
       defaultM = owner2+" "+viewId.substring(1,viewId.length()-6)+" page";
      }
      return defaultM;
     }
     switch (viewId){
      case "/itemFcal.xhtml":
       messg=bundle.getString("itemFcal.m");
       if(messg.equals("itemFcal.m")){
        return defaultM;
       }else{
        return owner2+"Calendar page, "+messg;
       }
      default: return owner2+" "+viewId.substring(1,viewId.length()-6)+" page";
     }
     }catch(Exception e){
      return defaultM;
     }

    }  

}

