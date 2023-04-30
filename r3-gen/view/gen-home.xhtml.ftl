<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign homeName = componentName + "Home">
<#assign listName = componentName + "List">
<#assign masterPageName = entityName + "List">
<#assign editPageName = entityName + "Edit">
<#assign pageName = entityName>
<#assign menuPageName = "home">
<#assign menuAttributes = pojo.shortName?substring(0,eL)>
<#-- 56 (User) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#if (menuAttributes?substring(efS,efE) == '56') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">    
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
                xmlns:p="http://primefaces.org/ui"
                template="layout/rtemplate.xhtml">
<f:metadata>
    <f:viewAction action="${'#'}{authenticator.setClientChosenSkin('/home-s.xhtml')}" />
    <f:viewAction action="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.takeAction()}" />
</f:metadata>


<#-- Generated By gen-hxxx.xhxxx.xxx on ${.now}
Home page
-->
<#--
parameters passed: none
popupPanels: 4
todo:make clientFullUrl ajax
-->
<#--
Page Layout 
sss h sss b
bbb t bbbb 
ssb m sss o
bbb l bbb
bbbbbbbbb d
bbbbbbbbb
bbbbbbbbb y

tags
html		jsf			richfaces
div,p		h:panelGrid
span		h:outputText
list		h:panelGrid
or table	or DataTable



-->
<#-- access to url or server name ${'#'}{request.serverName.contains('3recommerce.com')}
 reload(true) foreces to load from server and not from cache. we want issue not item if product code is forum
 jan 19 2019 major change, changed again in feb 25 2019 using top-bkgr- type txt for main highlight 
 for new pages, dont use top-bkgr use top-left -HDR seq 0,1 for landing page image/text
     top-left -TXT for highlihting image(iframe for video)/text
      MENU- TXT for html menue, continue to use MID-,FOOTER but MID now can also fade in/out
     new suffix nofade and fade like noasis  
     mar18 2018 with new approach of using clobdata for text and image fadeout is supported for id="header" only
     not ids like asisxxx. id="header" is reserved for clobdata 3R-TOP-LEFT hdr,hdrm,txt,txtm(mobile) and top-bkgr txt and txtm
     old pages should still work except for any top-left existing usage
 jun04 2020
 a new client field called raaspi2 
 if raaspi2 set then redirect to home-1.xhtml
 <meta f:action  
 if(raaspi2) {
  FacesContext.getCurrentInstance().getExternalContext().redirect(url);
 }
 home-2.xhtml will use rtemplateLite no default layout or menu and will support About.xhtml, Product.xhtml etc
 or single page #About, etc sections
 Content will still be based on clobdata content but no sections 
 if new site a default content using bootstrap.css but current templates will be replaced by 
 bootstrap and w3.css css and js
 But a site owner can use cdn to add new css/js
 CkEditor will now have source edit and html header edit
 For existing site the static pages can be migrated almost as is
 since will get converted to xml compliant
 They will be raaspiLite automatically.
 The backend will continue to be jsf but being positined for using Express Nodes.js instead of j2ee/jsf
 Nodes will run using reverse proxy since Nodes supoorts http but not fast as is

 customer facing shopping cart itemdetailsBrowse,cart will be enhanced so that jsf pages will make
 use of bootstrap css/js
 same for photos.blog, case
 These will be called cart-2,blog-2 etc
-->
<ui:remove>
<div class="fb-page" data-href="https://www.facebook.com/raaspi/" data-tabs="timeline" data-width="" data-height="" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/raaspi/" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/raaspi/">Raaspi</a></blockquote></div>
</ui:remove>
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE"/>
<META HTTP-EQUIV="EXPIRES" CONTENT="Mon, 22 Jul 2002 11:12:01 GMT"/>
<ui:define name="title">${'#'}{customIdentity.owner2} ${'#'}{messages['Home_Page_title']}</ui:define>
<ui:define name="body">
    <h:form id="homeForm">
<h:outputStylesheet>


</h:outputStylesheet>
<script>
$(document).ready(function(){
//alert (window.location); any html element with style class slide will have slide effect with 5secs interval
// this js provides slide effect by hiding/displaying. Css class like w3-animate-fading is indepedent but can be mixed
w3.slideshow(".slide",5000);
});
</script>


    <p:toolbar height="26" itemSeparator="grid" >
	  <p:toolbarGroup location="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile?'left':'left'}">
              <h:outputText value="${'#'}{messages.common_notify}" style="font-size: medium;color: red"  /> 
              &nbsp;<h:outputText value="${'#'}{messages.site_notify}" style="font-size: medium;color: red"/> 
              &nbsp;<h:outputText value="${'#'}{messages.backOffice_notify}" rendered="${'#'}{identity.loggedIn}" style="font-size: medium;color: red"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="${'#'}{${userEntityName}Home.mobile?'left':'right'}">
              <h:outputText value="${'#'}{customIdentity.username}" rendered="${'#'}{identity.loggedIn }"/> 
              <h:outputText value="&#160;&#160;"/>
              <h:outputLink value="${'#'}" id="settings" rendered ="${'#'}{identity.loggedIn}" onclick="PF('changePWPanel').show()">
               <h:outputText value="${'#'}{messages.prefs_change_password}"/>
              </h:outputLink>
              <h:outputText value="&#160;&#160;"/>
              <ui:remove> show fb only logout for situations where only fb login happened but not identiy login 
              </ui:remove>
              <h:link id="logoutfb" onclick="if (! confirm('Logout ?') ) { return false;}; Logout();return true;" value="Logout(FB)" rendered="${'#'}{!identity.loggedIn and customIdentity.smUid != null }"/>
              <h:commandButton id="logout" onclick="if (! confirm('Logout ?') ) { return false;}; return true; " action="${'#'}{customIdentity.logout()}" value="Logout" rendered="${'#'}{identity.loggedIn}"/>

              <h:outputText value="${'#'}{messages.Today} "/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
              &nbsp;<h:inputText id="Query" style="border-style:none;"
                value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.searchPattern}" size="25" onclick="this.value='';" pt:placeholder="${'#'}{messages['xyz..']}">
              </h:inputText>
              <h:commandButton id="r3Search" action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSearchedList('s')}"  image="/img/Findblue16.png"
               value="${'#'}{messages.searchButton}" rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
              </h:commandButton>
              <h:commandButton id="r3Search2" action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSearchedList('b')}"  image="/img/Findblue16.png"
               value="${'#'}{messages.searchButton}" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='b')}" />
              <h:link id="Cart" outcome="/checkout.xhtml" value="Cart" propagation="none"  rendered="${'#'}{!identity.loggedIn and ${itemEntityName}List.getCartedList('cart').size() gt 0 }"  >
               <h:graphicImage value="/img/Cart32.png" styleClass="pic"/>
              </h:link>
              <h:outputText value="[${'#'}{${itemEntityName}List.getCartedList('cart').size()}]" rendered="${'#'}{!identity.loggedIn and ${itemEntityName}List.getCartedList('cart').size() gt 0}">
              </h:outputText>
              <h:outputText value="[${'#'}{messages['empty']}]" rendered="${'#'}{!identity.loggedIn and ${itemEntityName}List.getCartedList('cart').size() == 0}"/>
	      &nbsp;<h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  style="font-size: large;"  cols="70" rows="10" readonly="true"  value="${'#'}{messages['homeHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>&nbsp;
             <ui:remove>
               <h:graphicImage value="/img/attachment.png" style="height:20px;">
                 <a href="#footerl">language</a> 
               </h:graphicImage>
             </ui:remove>

	  </p:toolbarGroup>

    </p:toolbar>
             <ui:fragment rendered="${'#'}{!identity.loggedIn and yxxxch522xhhxxhxxxxxclientList.getSuggestList('02')[0].dbxxuzxdssxxxxxxxxxxapiclientsecret !=null 
               and yxxxch522xhhxxhxxxxxclientList.getSuggestList('02')[0].daxxuzxdssxxxxxxxxxxapiclientid ==null}">
              <h:outputText value="${'#'}{messages['This']} ${'#'}{messages['is']} ${'#'}{messages['our']} ${'#'}{messages['backoffice']} ${'#'}{messages['site']}, " /> 
              <br></br><a href="https://${'#'}{yxxxch522xhhxxhxxxxxclientList.getKeyToEntity('02').b2xxuzcxbvxxxxxxxxxxenterprisecompanyna}">${'#'}{messages['visit']} ${'#'}{messages['our']} ${'#'}{messages['shopify']} ${'#'}{messages['store']} </a>
             </ui:fragment>

    <h:messages globalOnly="true" style = "color:red;margin:8px;" styleClass="message"/>
    <ui:remove>
     Allow upto 3 graphics top seq 0,1 and FTR seq 0(rendered by if text present why? got removed to be added asis)
      100% float left or asis centre (future)
      100%  float centre or asis
      100% float left or asis
      dec24 2019 added home_midtop page anchor to be used to click to here
    </ui:remove>
    <a name="home_midtop"/>
    <p:panel styleClass="midtop" rendered="${'#'}{!identity.loggedIn}">
     <p:panel toggleable="true"  style="width: ${'#'}{${userEntityName}Home.mobile?'100%':'100%'};"  switchType="client" expanded="true" 
       rendered="${'#'}{!identity.loggedIn}"
       leftCollapsedIcon="/img/wdot.png" leftExpandedIcon="/img/wdot.png">
              <h:outputText styleClass="midtoph" escape="false" value="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','HDR',0,1200)}" 
                rendered="${'#'}{!identity.loggedIn and (${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','HDR',0,1200) !=null)}"/>
               <h:graphicImage id="midimg"  styleClass="midtopi" alt="Press Reset to load Images " style="width: 100%;float:left;padding-left:.5%;padding-top:.5%;padding-bottom:.5%;padding-right:.5%;"
                value="/ImageServletCdi/?seq=0&amp;id=A3R-MID-TOP-C&amp;width=700"
                rendered="${'#'}{!identity.loggedIn and (${blobdataEntityName}Home.getBlobdata('blobdata','A3R-MID-TOP-C','PIC',0) !=null)}">
               </h:graphicImage> 
              <h:outputText styleClass="midtoph" escape="false" value="&lt;/a&gt;" 
                rendered="${'#'}{!identity.loggedIn  and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','HDR',0,1200) !=null and yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','HDR',0,1200).contains('a  href=' ))}"/>
              <h:outputText styleClass="midtopt" escape="false"  value="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','TXT',0,4096000)}" 
                rendered="${'#'}{!identity.loggedIn and (${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','TXT',0,12000) !='')}"/>
     </p:panel> 
     <p:panel styleClass="midtop" rendered="${'#'}{!identity.loggedIn and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','VID',0,12000) !=null)}">
      <p:panel toggleable="true"  style="width: ${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile?'100%':'100%'};"  switchType="client" expanded="true" rendered="${'#'}{!identity.loggedIn and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','VID',0,12000) !=null)}"
       leftCollapsedIcon="/img/wdot.png" leftExpandedIcon="/img/wdot.png">
       <iframe width="854" height="480" src="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','VID',0,12000)}" frameborder="0" allowfullscreen="true"></iframe>
      </p:panel> 
     </p:panel>
     <p:panel toggleable="true"  style="width: ${'#'}{${userEntityName}Home.mobile?'100%':'100%'};"  switchType="client" expanded="true" 
       rendered="${'#'}{!identity.loggedIn}"
       leftCollapsedIcon="/img/wdot.png" leftExpandedIcon="/img/wdot.png">
              <h:outputText styleClass="midtoph" escape="false" value="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','HDR',1,1200)}" 
                rendered="${'#'}{!identity.loggedIn and (${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','HDR',1,1200) !=null)}"/>
               <h:graphicImage id="midimg1"  styleClass="midtopi" alt="Press Reset to load Images " style="width: 100%;float:left;padding-left:.5%;padding-top:.5%;padding-bottom:.5%;padding-right:.5%;"
                value="/ImageServletCdi/?seq=1&amp;id=A3R-MID-TOP-C&amp;width=700"
                rendered="${'#'}{!identity.loggedIn and (${blobdataEntityName}Home.getBlobdata('blobdata','A3R-MID-TOP-C','PIC',1) !=null)}">
               </h:graphicImage> 
              <h:outputText styleClass="midtoph" escape="false" value="&lt;/a&gt;" 
                rendered="${'#'}{!identity.loggedIn  and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','HDR',1,1200) !=null and yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-TOP-C','HDR',1,1200).contains('a  href=' ))}"/>
              <h:outputText styleClass="midtopt" escape="false"  value="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','TXT',1,4096000)}" 
                rendered="${'#'}{!identity.loggedIn and (${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-TOP-C','TXT',1,12000) !='')}"/>
     </p:panel> 
     <p:panel toggleable="true"  style="width: ${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile?'100%':'100%'};"  switchType="client" expanded="true" 
       rendered="${'#'}{!identity.loggedIn}"
       leftCollapsedIcon="/img/wdot.png" leftExpandedIcon="/img/wdot.png">
              <h:outputText styleClass="midtoph" escape="false" value="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-FTR-C','HDR',0,1200)}" 
                rendered="${'#'}{!identity.loggedIn and (${clobdataEntityName}Home.getClobdata('clobdata','A3R-MID-FTR-C','HDR',0,1200) !=null)}"/>
              <h:graphicImage style="width: 100%;float:left;;padding-left:.5%;padding-top:.5%;padding-bottom:.5%;padding-right:.5%;"
              value="/ImageServletCdi/?seq=0&amp;id=A3R-MID-FTR-C&amp;width=700" 
                rendered="${'#'}{!identity.loggedIn and (yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata('blobdata','A3R-MID-FTR-C','PIC',0) !=null)}">
              </h:graphicImage>
              <h:outputText styleClass="midtoph" escape="false" value="&lt;/a&gt;" 
                rendered="${'#'}{!identity.loggedIn  and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-FTR-C','HDR',0,1200) !=null and yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-FTR-C','HDR',0,1200).contains('a  href=' ))}"/>
              <h:outputText styleClass="midtopt" escape="false"  value="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-FTR-C','TXT',0,4096000)}" 
                rendered="${'#'}{!identity.loggedIn and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MID-FTR-C','TXT',0,12000) !='')}"/>
     </p:panel> 
    </p:panel>
      <p:hotkey id="keyReturn" key="return" onkeydown="PF('homeForm:r3Search').click()" enabledInInput="true"/>
      <p:hotkey id="keyCTRLR" key="ctrl+r" onkeydown="PF('homeForm:registerLink').click()" enabledInInput="true"/>

</h:form>





<h:form id="PassWordChange"  >

 <p:dialog id="changePWPanel" widgetVar="changePWPanel" modal="true" width="360" height="300" show="${'#'}{${userEntityName}Home.changePasswordError}" rendered="${'#'}{identity.loggedIn}"
                    domElementAttachment="parent">
  <f:facet name="header"><h:outputText value="${'#'}{messages.chngpswd}"/></f:facet>
  <f:facet name="controls">
   <h:form>
    <p:commandButton onclick="PF('changePWPanel').hide()" type="image" image="/img/Cancel16.png"/>

   </h:form>
  </f:facet>
    <h:panelGrid >
      <f:facet name="header"><h:outputText value="${'#'}{messages.chngpswd_directive}"/></f:facet>
      <ui:decorate id="changePWUserIdField" template="layout/edit.xhtml">
            <div class="dialog">
                <h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">
                    <h:outputLabel for="password">New Password</h:outputLabel>
				<h:inputSecret id="password" value="${'#'}{${userEntityName}Home.resetPassword}" required="true"/>
			
                    <h:outputLabel for="verify">ReType New Password</h:outputLabel>
				<h:inputSecret id="verify" value="${'#'}{${userEntityName}Home.verify}" required="true"/>
                </h:panelGrid>
            </div>
      </ui:decorate>

    </h:panelGrid>
        <p:commandButton  id="changePWCommand" action="${'#'}{${userEntityName}Home.changePassword()}"
        value="${'#'}{messages.prefs_change_password}" update="changePWPanel"  process="changePWPanel"
        oncomplete="${'#'}{facesContext.maximumSeverity.ordinal != 0}?PF('changePWPanel').show():PF('changePWPanel').show()"
         status="buttonStatus"  rendered="${'#'}{!${userEntityName}Home.changed}"/>

        <p:commandButton  id="changePWCommand2" action="${'#'}{${userEntityName}Home.changePassword()}"
        value="${'#'}{messages.prefs_change_password} ${'#'}{messages.again}" update="changePWPanel"  process="changePWPanel"
        oncomplete="${'#'}{facesContext.maximumSeverity.ordinal != 0}?PF('changePWPanel').show():PF('changePWPanel').show()"
         status="buttonStatus"  rendered="${'#'}{${userEntityName}Home.changed}"/>

             <p:ajaxStatus name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
    <p:commandButton type="button" id="chDoneButton" value="${'#'}{messages.done}" 
     update="changePWPanel" process="changePWPanel"
     onclick="PF('changePWPanel').hide()"/>
       <h:messages globalOnly="false" style = "color:red;margin:8px;" styleClass="message" id="globalMessages"/>
    <p:message for="changePWCommand">
      <f:facet name="errorMarker"><h:graphicImage value="/img/error.gif"/></f:facet>
    </p:message>


 </p:dialog>
</h:form>





</ui:define> 
</ui:composition>
</#if>
</#if>
