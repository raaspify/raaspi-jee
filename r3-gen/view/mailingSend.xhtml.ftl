<#assign mailingCandidate = "N">  
<#assign messagingCandidate = "N">  
<#include "../util/TypeInfo.ftl">
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
 <#assign menuAttributesp2 = menuAttributes?substring(efS,efE)>
 <#if (menuAttributes?contains("M") || menuAttributes?contains("J") ) >
  <#assign mailingCandidate ="Y" >
 </#if>
 <#if (menuAttributes?contains("P") ) >
  <#assign messagingCandidate ="Y" >
 </#if>
</#if>

<#if mailingCandidate == "Y" || messagingCandidate = "Y">                       

<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign listName = componentName + "List">
<#assign homeName = componentName + "Home">
<#assign pageName = entityName>
<#assign editPageName = entityName + "Edit">
<#assign listPageName = entityName + "MailingSend">
<#assign menuPageName = "home">
<#assign keyfromsubkeys = "Y">
<#assign start = "start">
<#assign end = "end">
<#assign markedOnes = "markedOnes">    
<#assign statusFlagField="">
<#assign documentField="">
  

<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:p="http://primefaces.org/ui"
                xmlns:pe="http://primefaces.org/ui/extensions"
                xmlns:c="http://java.sun.com/jsp/jstl/core"
                xmlns:o="http://omnifaces.org/ui"
                template="layout/rtemplate.xhtml">
<#-- Generated By mailingSend.xhtml.ftl on ${.now}
mailing send page
this calls send method in list, which will render mailingContent.xhtml
mailingContent calls methods in list to 
parameters passed: none
popupPanels: 0
todo:
-->
<f:metadata>
    <f:viewParam name="subject" value="${'#'}{${listName}.mailingSubject}"/>
    <f:viewParam name="content" value="${'#'}{${listName}.mailingSource}"/>
    <f:viewParam name="oneEmailTo" value="${'#'}{${listName}.e1mailAddress}"/>
    <f:viewAction action="${'#'}{${homeName}.restrict()}" />
</f:metadata>

<ui:define name="body">
    
    
    <h:form id="${componentName}Mailing" styleClass="edit" enctype="multipart/form-data">
     <h:outputStylesheet>
     </h:outputStylesheet>
       <c:set var = "dps" value="${'#'}{${userEntityName}Home.mobile?1:8}">
       </c:set>
       <c:set var = "dpt" value="${'#'}{${userEntityName}Home.mobile?1:14}">
       </c:set>
       <c:set var = "dpo" value="${'#'}{${userEntityName}Home.mobile?1:30}">
       </c:set>

      <#assign keyField="a0xxukxxbvxxxxxxxxxxcustomer"> 
      <#assign emailField='q4xxhxxxbv24xxxxxxxximailaddr'> 
      <#assign eemailField='n4xxhxxrbv24xxxxxxxximailaddr'> 

      <h:messages globalOnly="true" styleClass="message" id="globalMessages"/>
      <h:outputText value="${'#'}{messages['Two']} ${'#'}{messages['possible']} ${'#'}{messages['modes']}: ${'#'}{messages['relay']} ${'#'}{messages['off']}(${'#'}{messages['regular']} ${'#'}{messages['emails']}) ${'#'}{messages['and']} ${'#'}{messages['relay']} ${'#'}{messages['on']}(${'#'}{messages['bulk']} ${'#'}{messages['emails']})" /> 
      &nbsp;<h:link value="${'#'}{messages['Change']} ${'#'}{messages['mode']}"  outcome="/clientList.xhtml" target="_blank"/>
      <br></br><h:graphicImage value="/img/email_stop16.png" />
              <h:outputText value="${'#'}{messages['Current']} ${'#'}{messages['mode']}: ${'#'}{messages['smtp']} ${'#'}{messages['server']} ${'#'}{messages['no']} ${'#'}{messages['relay']}(${'#'}{messages['transaction']}/${'#'}{messages['reliable']} ${'#'}{messages['emails']})" rendered="${'#'}{jxxxuq201xwwqqhxxxxxcustomerList.mailRelayOff}"/> 
              &nbsp;&nbsp;<h:outputText value="${'#'}{messages['mode']}: ${'#'}{messages['smtp']} ${'#'}{messages['relay']} (${'#'}{messages['bulk']}  ${'#'}{messages['volume']})" rendered="${'#'}{!jxxxuq201xwwqqhxxxxxcustomerList.mailRelayOff}"/> 
      <h:outputText value="  ${'#'}{messages['user']}: ${'#'}{customIdentity.username}"/>&nbsp;
      <#if menuAttributesp2 ="20">
      <#assign keyField=customerKeyField> 
      <#assign emailField='q4xxhxxxbv24xxxxxxxximailaddr'> 
      <h:outputText id="jayes" value="${'#'}{messages['To']}: ..${'#'}{${listName}.${componentName}.q4xxhxxxbv24xxxxxxxximailaddr} ${'#'}{${homeName}.getCurrentTime()}"/> 
      </#if>
      <#if menuAttributesp2 ="30">
      <#assign keyField=vendorKeyField> 
      <#assign emailField='n4xxhxxrbv24xxxxxxxximailaddr'> 
      <h:outputText id="jayes" value="${'#'}{messages['To']}: ..${'#'}{${listName}.${componentName}.n4xxhxxrbv24xxxxxxxximailaddr}"/> 
      </#if>
      <#if menuAttributesp2 ="40">
      <#assign keyField=employeeKeyField> 
      <#assign emailField='n4xxhxxrbv24xxxxxxxximailaddr'> 
      <h:outputText id="jayes" value="${'#'}{messages['To']}: ..${'#'}{${listName}.${componentName}.n4xxhxxrbv24xxxxxxxximailaddr}"/> 
      </#if>
	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
              <h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  outcome="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['${componentName?substring(eL)?cap_first}MailingSendHelp']!=null}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['${componentName?substring(eL)?cap_first}MailingSendHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
	</p:toolbar>

        <div class="actionButtons">
         <h:panelGrid columns="${'#'}{dpt}">      
           <#if mailingCandidate == "Y" >
            <p:commandButton id="mailing" styleClass="buttonMain" update="mailing,jayes,globalMessages" value="${'#'}{messages['mail.send']} " status="buttonStatus" action="${'#'}{${listName}.send}"> 
             </p:commandButton> 
           </#if>
             <p:ajaxStatus name="buttonStatus" execute="@form" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
             <p:message for="mailingP">
             </p:message>
            <p:commandButton id="mailingSt"   value="status" update="stms"  action="${'#'}{${listName}.fetchMailingStatus}"> 
             </p:commandButton> 
             <h:outputText id="stms" value="${'#'}{${listName}.mailingStatus}" />


           &nbsp;<h:button outcome="/${'#'}{empty ${componentName?substring(eL)}From ? '${menuPageName}' : ${componentName?substring(eL)}From}.xhtml"
                    id="done1"
                 value="Done"/>
           <#if menuAttributesp2 !="40">
                &nbsp;<h:outputText value= "${'#'}{messages['include']} ${'#'}{messages['contacts']}" />
                <h:selectBooleanCheckbox value="${'#'}{${listName}.contactYN}"/>
           </#if>
            &nbsp;<ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['enter']} ${'#'}{messages['one']} ${'#'}{messages['optional']} ${'#'}{messages['email']} ${'#'}{messages['address']}</ui:define>
                &nbsp;<h:inputText id="keyedIn"  value="${'#'}{${listName}.e1mailAddress}" maxlength="60" size="30" />
            </ui:decorate>

            </h:panelGrid>
            <br></br>
            <p:commandButton id="mailingP"  update="mailingP,jayes,globalMessages" value="${'#'}{messages['preview']} ${'#'}{messages['send']}" status="buttonStatus" action="${'#'}{${listName}.previewSend}"> 
            </p:commandButton> 
            <p:commandButton id="draftS" styleClass="button" update="editor,mailingP,jayes,globalMessages" value="${'#'}{messages['save']} ${'#'}{messages['as']} ${'#'}{messages['draft']}" status="buttonStatus" action="${'#'}{${listName}.saveAsDraft}"> 
            </p:commandButton> 
            <p:commandButton id="draftL" styleClass="button" update="editor,mailingP,jayes,globalMessages" value="${'#'}{messages['load']} ${'#'}{messages['draft']}" status="buttonStatus" action="${'#'}{${listName}.loadDraft}"> 
            </p:commandButton> 



            <h:panelGrid columns="${'#'}{dps}">   
              <h:panelGroup>
              <h:graphicImage value="/img/Groupmembers16.png" />
              <h:outputText value="${'#'}{messages['select']} ${'#'}{messages['group']}"/> 
                 <h:selectOneMenu  value="${'#'}{${listName}.groupSid}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${membersgroupEntityName}List.getSuggestList('email')}" var="result"
                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.a0xxukxxbvxxxxxxxxxxgroupid}" />
                 </h:selectOneMenu>
              </h:panelGroup>
              <h:outputText value="${'#'}{messages['Or']} "/> 
              <h:outputText value="${'#'}{messages['To']} "/> 
                  <p:pickList value="${'#'}{${listName}.toDualSuggestList}" var="result" itemValue="${'#'}{result}" itemLabel="${'#'}{fn:substring(result.${keyField},0,10)},${'#'}{fn:substring(result.${emailField},0,15)}"
                   <#if menuAttributesp2 ="20">
                    converter="cEntityConverter">
                   </#if>
                   <#if menuAttributesp2 ="30">
                    converter="vEntityConverter">
                   </#if>
                   <#if menuAttributesp2 ="40">
                    converter="eEntityConverter">
                   </#if>
                  </p:pickList>
              <h:outputText value="${'#'}{messages['and']} "/> 
              <h:outputText value="${'#'}{messages['Cc']}"/> 
                  <p:pickList value="${'#'}{${employeeEntityName}List.ccDualSuggestListE}" var="result" itemValue="${'#'}{result}" itemLabel="${'#'}{fn:substring(result.${employeeKeyField},0,10)},${'#'}{fn:substring(result.${eemailField},0,15)}"
                    converter="eEntityConverter">
                  </p:pickList>



         </h:panelGrid>      

        </div>
           <f:param name="mailingSubject" value="${'#'}{${listName}.mailingSubject}"/>
           <f:param name="attachment" value="${'#'}{${listName}.attachment}" /> 
        
<#-- removed list search etc to reduce page size, response was not coming back after successful mail render if ataachment
-->
       <p:panel toggleable="true" toggleableHeader="true" header="${'#'}{messages['${entityName?substring(eL)?cap_first}']} Mailing " 
           leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
          <h:panelGrid columns="1">
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['mailing.mailingSubject']} </ui:define>
                <h:inputText id="mailingSubject"  value="${'#'}{${listName}.mailingSubject}" size="60" />
            </ui:decorate>
          <h:panelGrid columns="1">
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['mailing.mailingSource']}</ui:define>
                <pe:ckEditor id="editor"  width="100%"  value="${'#'}{${listName}.mailingSource}"
                      toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/', ['Undo', 'Redo']]">  
                </pe:ckEditor>

            </ui:decorate>
          </h:panelGrid >
          <ui:remove>
            <ui:decorate template="layout/display.xhtml" rendered="false">
                <ui:define name="label">${'#'}{messages['mailing.signature_image']}</ui:define>
                <h:selectBooleanCheckbox value="${'#'}{${listName}.signatureImageYN}"/>
            </ui:decorate>
          </ui:remove>

           <h:panelGroup>
                  <p:tooltip target="jchk">  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['change']} ${'#'}{messages['edit']} ${'#'}{messages['user']} ${'#'}{messages['profile']}"/></span> </p:tooltip> 
            <ui:decorate template="layout/display.xhtml">
                <h:outputText value="${'#'}{messages['mailing.signature_text']}"/>
                <h:selectBooleanCheckbox value="${'#'}{${listName}.signatureYN}"/>
                <h:inputTextarea id="jchk" cols="80" value="${'#'}{${listName}.signatureSource}" readonly="true" style="width: 400px;height: 25px;">
                </h:inputTextarea>
            </ui:decorate>
           </h:panelGroup>

           <h:panelGrid columns="${'#'}{dpo}">
            <ui:decorate template="layout/display.xhtml">
                <h:outputText value="${'#'}{messages['mailing.unsubscribe']}"/>
                <h:outputText value="(${'#'}{messages['use']} ${'#'}{messages['Relay']} ${'#'}{messages['on']})"
                  rendered="${'#'}{jxxxuq201xwwqqhxxxxxcustomerList.mailRelayOff}"/>
                <h:selectBooleanCheckbox value="${'#'}{jxxxuq201xwwqqhxxxxxcustomerList.unsubscribeYN}"
                  rendered="${'#'}{!jxxxuq201xwwqqhxxxxxcustomerList.mailRelayOff}"/>
            </ui:decorate>
            <ui:decorate template="layout/display.xhtml">
                &nbsp;<h:outputText value="${'#'}{messages['multilingual']} ${'#'}{messages['content']}"/>
                <h:selectBooleanCheckbox value="${'#'}{jxxxuq201xwwqqhxxxxxcustomerList.multilingualYN}"/>
            </ui:decorate>

            <ui:decorate template="layout/display.xhtml">
                &nbsp;<h:outputText value="${'#'}{messages['send']} ${'#'}{messages['all']} ${'#'}{messages['as']} ${'#'}{messages['Bcc']}"/>
                <h:selectBooleanCheckbox id="bcci" value="${'#'}{jxxxuq201xwwqqhxxxxxcustomerList.showAsBCCYN}">
                 <p:tooltip id="previwTipm" attached="true" for="bcci" >
                 <h:outputText value="${'#'}{messages['recommended']} ${'#'}{messages['for']} ${'#'}{messages['bulk']}  ${'#'}{messages['mailing']}"/>
                 </p:tooltip>
                </h:selectBooleanCheckbox>
            </ui:decorate>
            <ui:decorate template="layout/display.xhtml">
                &nbsp;<h:outputText value="${'#'}{messages['all']} ${'#'}{messages['Bcc']}, ${'#'}{messages['but']} ${'#'}{messages['show']} ${'#'}{messages['names']}"/>
                <h:selectBooleanCheckbox id="bcce" value="${'#'}{jxxxuq201xwwqqhxxxxxcustomerList.showNamesYN}">
                 <p:tooltip id="toolt" attached="true" for="bcce" >
                 <h:outputText value="${'#'}{messages['use']} ${'#'}{messages['with']} ${'#'}{messages['bcc']} ${'#'}{messages['to']} ${'#'}{messages['show']} ${'#'}{messages['names']}  ${'#'}{messages['while']}  ${'#'}{messages['hiding']} ${'#'}{messages['email']} ${'#'}{messages['information']}, ${'#'}{messages['for']} ${'#'}{messages['small']} ${'#'}{messages['to']} ${'#'}{messages['medium']} ${'#'}{messages['list']}   "/>
                 </p:tooltip>
                </h:selectBooleanCheckbox>
            </ui:decorate>
           </h:panelGrid>
                   
            <ui:decorate template="layout/display.xhtml">
   <#-- Attachments image or text -->

   <p:panel toggleable="true" toggleableHeader="true" style="width: 100%;" header="${'#'}{messages['Attachment']}" switchType="client" collapsed="${'#'}{fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Mobi') || fn:containsIgnoreCase(request.getHeader('User-Agent'), 'iPad')}"  
          leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
         <h:outputText value="${'#'}{messages['Use']} ${'#'}{messages['above']} ${'#'}{messages['editor']} ${'#'}{messages['to']} ${'#'}{messages['copy']} ${'#'}{messages['paste']} ${'#'}{messages['image']} ${'#'}{messages['or']} ${'#'}{messages['copy']} ${'#'}{messages['image']} ${'#'}{messages['url']}, ${'#'}{messages['use']}. ${'#'}{messages['attachments']} ${'#'}{messages['on']} ${'#'}{messages['need']} ${'#'}{messages['basis']}"/>
         <br></br>
         <h:outputText value="${'#'}{messages['Create']} ${'#'}{messages['or']} ${'#'}{messages['update']} ${'#'}{messages['Binary']} ${'#'}{messages['data']} ${'#'}{messages['with']} ${'#'}{messages['Fromkey']}- ${'#'}{messages['Attachment']}, ${'#'}{messages['Qualifier']}- ${'#'}{messages['PICTURE IMAGE']}, ${'#'}{messages['Sequence']}- ${'#'}{messages['any']}. ${'#'}{messages['First']} ${'#'}{messages['three']} ${'#'}{messages['are']} ${'#'}{messages['shown']} ${'#'}{messages['as']} ${'#'}{messages['attachments']}"/>
         <h:outputText value="${'#'}{messages['Same']} ${'#'}{messages['for']} ${'#'}{messages['Textdata']}, ${'#'}{messages['but']} ${'#'}{messages['Qualifier']}- ${'#'}{messages['TEXT BODY']}.  ${'#'}{messages['Upto']} ${'#'}{messages['three']} ${'#'}{messages['attachments']}"/>

         <#-- allow fileupload blob and clob here to keep it simple and easier flow  -->
         <o:inputFile  id="mailsendo" value="${'#'}{file.lfiles}" multiple="true" 
          accept="text/plain,text/csv,image/*,application/pdf"/>
         <h:commandButton value="Upload" action="${'#'}{file.fileUpload('clobblob')}"/>
         <br />
         <h:commandButton action="${'#'}{${homeName}.clearUploadData}"
           value="${'#'}{messages['Clear']} ${'#'}{messages['Uploaded']} ${'#'}{messages['Data']}"
         rendered="${'#'}{not empty file.data}" />
         <o:graphicImage value="${'#'}{file.data}" dataURI="true" width="100" 
          rendered="${'#'}{not empty file.data}" />


         <#-- below show uploaded round robin saved attachments and allow selection  -->

     <p:panel>
        <f:facet name="header">${'#'}{messages['image']} / ${'#'}{messages['pdf']}</f:facet>
         <p:commandButton id="reload" image="/img/Reload16.png"
                          value="${'#'}{messages['reFresh']}" update="@form" />
        <h:panelGrid columns="1">
            <p:outputPanel id="panelp1" layout="block">
                <ui:repeat value="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataList.getAllResultListSeqs('blobdata','A3R-ATTACHMENT-1-C','PIC',0,'')}" var="row" iterationStatusVar="status"  rowKeyVar="ij" rows="5" id="repeatp1">
                    <p:panel style="float:left; width:${'#'}{customIdentity.product=='s' and customIdentity.subProduct=='b'  ?'700px':'150px'}; padding:5px; height:100px;">
                        <f:facet name="header">
                            <h:panelGroup>
                             <h:selectBooleanCheckbox value="${'#'}{${listName}.checkMapI[ij+1]}"> 
                              <f:ajax event="click" execute="@form" render="@form" />
                             </h:selectBooleanCheckbox>

                             <h:graphicImage alt="no picture"  rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata('blobdata','A3R-ATTACHMENT-1-C','PIC',row.a3xxexnsbvxxxxxxxxxxsequence) != null and row.a4xxexxxbvxxxxxxxxxxtype !='pdf'}"
                              value="/ImageServletCdi/?seq=${'#'}{row.a3xxexnsbvxxxxxxxxxxsequence}&amp;qlf=PIC&amp;id=A3R-ATTACHMENT-1-C&amp;height=50">
                             </h:graphicImage> 
                             <h:outputText value="PDF" style="font-weight:bold" rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata('blobdata','A3R-ATTACHMENT-1-C','PIC',row.a3xxexnsbvxxxxxxxxxxsequence) != null and row.a4xxexxxbvxxxxxxxxxxtype =='pdf'}"/>
                             <p:panel id="statusPI">
                             <h:outputText value="${'#'}{fn:substring(row.y3xxuxznbvxxxxxxxxxxnotes,0,20)}" style="font-weight:bold" />
                             <h:outputText value=" " />
                             <ui:remove> 
                             <h:outputText value="${'#'}{row.a3xxexnsbvxxxxxxxxxxsequence}" style="font-weight:bold" />
                             </ui:remove>
                             </p:panel>
                            </h:panelGroup>
                        </f:facet>
                    </p:panel>
                </ui:repeat>
            </p:outputPanel>

        </h:panelGrid>

      </p:panel>
    <p:panel >
        <f:facet name="header">${'#'}{messages['Text']}</f:facet>
        <h:panelGrid columns="1">
            <p:outputPanel id="panelt1" layout="block">
                <ui:repeat value="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataList.getAllResultListSeqs('clobdata','B3R-ATTACHMENT-1-C','TXT',0,'')}" var="row" iterationStatusVar="status" rowKeyVar="ij" rows="5" id="repeatp1h">
                    <p:panel style="float:left; width:${'#'}{customIdentity.product=='s' and customIdentity.subProduct=='b'  ?'700px':'150px'}; padding:5px; height:100px;">
                        <f:facet name="header">
                            <h:panelGroup>
                             <p:panel id="statusPT">
                             <h:outputText value=" " />
                             <h:selectBooleanCheckbox value="${'#'}{${listName}.checkMapT[ij+1]}"> 
                              <f:ajax event="click" execute="@form" render="@form" />
                             </h:selectBooleanCheckbox>
                             <h:inputTextarea readonly="true"  value="${'#'}{row.b1xxuzaxbvxxxxxxxxxxdata}" />
                             <h:outputText value="${'#'}{fn:substring(row.y3xxuxznbvxxxxxxxxxxnotes,0,20)}" style="font-weight:bold" />
                             </p:panel>
                            </h:panelGroup>
                        </f:facet>
                    </p:panel>
                </ui:repeat>
            </p:outputPanel>
        </h:panelGrid>

      </p:panel>
   </p:panel>

            </ui:decorate>
          </h:panelGrid>

       </p:panel>
     <p:hotkey  onkeydown="PF('mailingP').click();return false;" preventDefault="true" enabledInInput="true" key="return">
     </p:hotkey>


   </h:form>
             <p:ajaxStatus  >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>

    
</ui:define>

<script type="text/javascript">
setTimeout(function(){
    alert('Reminder, you have reached about 30 minutes out of possible server session In Active time out at 40 minutes. If you have entered data but yet to send email, you may lose unsaved changes at server. Press the status button to avoid time out and good for another 40 minutes. If you lose the data, give browser back button a try. ');
}, 30 * 60 * 1000); // 30 minutes
</script>

</ui:composition>

</#if>

