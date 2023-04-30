<#assign mailingCandidate = "N">  
<#assign unsctype ="" >
<#include "../view/assigns/PositionLength.properties" >
<#include "../view/assigns/mergedassigns.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
 <#assign menuAttributesFunction = pojo.shortName?substring(efS,efE)>
 <#if (menuAttributes?contains("M") || menuAttributes?contains("J") || menuAttributesFunction?contains("89") ) >
  <#assign mailingCandidate ="Y" >
 </#if>
 <#assign qKey ="" >
 <#if (menuAttributesFunction?contains("20"))>
  <#assign unsctype ="1" >
  <#assign qKey ="a0xxukxxbvxxxxxxxxxxcustomer" >

 </#if>
 <#if (menuAttributesFunction?contains("30"))>
  <#assign unsctype ="2" >
  <#assign qKey ="a0xxukxxbvxxxxxxxxxxvendor" >
 </#if>
 <#if (menuAttributesFunction?contains("40"))>
  <#assign unsctype ="3" >
  <#assign qKey ="a0xxuktxbvxxxxxxxxxxemployee" >
 </#if>
</#if>

<#if mailingCandidate == "Y">                       

<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign listName = componentName + "List">
<#assign homeName = componentName + "Home">
<#assign pageName = entityName>
<#assign editPageName = entityName + "Edit">
<#assign listPageName = entityName + "List">
<#assign menuPageName = "home">
  

<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:m="http://jboss.org/schema/seam/mail"
                xmlns:a4j="http://richfaces.org/a4j"
                xmlns:rich="http://richfaces.org/rich">
         <#assign firstNameField=" ">
         <#assign lastNameField="Not Found">
         <#assign imailaddrField="Not Found">
        <#foreach property in pojo.allPropertiesIterator>
         <#if (property.name?length > 12) >
         <#if  property.name?substring(5,7)=="sa" >
          <#assign firstNameField=property.name>
         </#if>
         <#if  property.name?substring(pefS,pefE)=="ln" >
          <#assign lastNameField=property.name>
         </#if>
         <#if  firstNameField== " " && property.name?substring(pefS,pefE)=="fn"  >
          <#assign firstNameField=property.name>
         </#if>
         <#if  property.name?substring(10,12)=="24" >
          <#assign imailaddrField=property.name>
         </#if>
         </#if>
        </#foreach>
        <#--
         m:message (holds m:from, m:cc etc) and m:body (holds mailing.source) are static ie built once
          but m:to  are set by calling bran and changes.
         From clientEMail
         Date
         Header for X-SMTPI fot sendgrid To List more efficient
         To here is dummy and same as from ie clientEMail, x-SMTPI holds actual to send list
         cc bcc
         Subject
         inline attachments upto 5 images and Text
         body (1)mailingsource comes from ckEditor 
              (2)mailingsignature(tbd) , Signature can have standard advertising msg like sent from etc
         
         add logic to get mailingtextType so that we can have ics,txt,xml etc
        -->

     <m:message>
        <m:header name="X-SMTPAPI" value="${'#'}{${listName}.headers}" />
        <m:from name="${'#'}{${listName}.userFullName}" address="${'#'}{${listName}.clientEMail}" />
        <#if (menuAttributesFunction?contains("89"))>
        <#else>
        <ui:fragment rendered="${'#'}{not empty ${listName}.ccList}">
          <ui:repeat value="${'#'}{${employeeEntityName}List.ccList}" var="c">
           <m:cc name="${'#'}{c.b4xxu2fnbvxxxxxxxxxxfirstname} ${'#'}{c.b3xxuslnbvixxxxxxxxxlastname}">${'#'}{c.n4xxhxxrbv24xxxxxxxximailaddr}</m:cc>
          </ui:repeat>
        </ui:fragment> 
        </#if>
        <ui:fragment rendered="${'#'}{not empty ${listName}.EMailingAddress2}">
        <m:bcc name="${'#'}{${listName}.EMailingAddress2}">${'#'}{${listName}.EMailingAddress2}</m:bcc>
        </ui:fragment> 
        <m:subject>${'#'}{${listName}.mailingSubject}</m:subject>
        <ui:fragment rendered="${'#'}{${listName}.checkMapI[1]}">
        <m:attachment value="${'#'}{${listName}.mailingImage1}" contentType="${'#'}{${listName}.mailingImage1TypeMime}"           fileName="attach1.${'#'}{${listName}.mailingImage1Type}"
         disposition="inline" status="banner1" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapI[2]}">
        <m:attachment value="${'#'}{${listName}.mailingImage2}"
         contentType="${'#'}{${listName}.mailingImage2TypeMime}"
           fileName="attach2.${'#'}{${listName}.mailingImage2Type}"
         disposition="inline" status="banner2" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapI[3]}">
        <m:attachment value="${'#'}{${listName}.mailingImage3}"
         contentType="${'#'}{${listName}.mailingImage3TypeMime}"
           fileName="attach3.${'#'}{${listName}.mailingImage3Type}"
         disposition="inline" status="banner3" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapI[4]}">
        <m:attachment value="${'#'}{${listName}.mailingImage4}"
         contentType="${'#'}{${listName}.mailingImage4TypeMime}" 
          fileName="attach4.${'#'}{${listName}.mailingImage4Type}"
         disposition="inline" status="banner4" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapI[5]}">
        <m:attachment value="${'#'}{${listName}.mailingImage5}"
         contentType="${'#'}{${listName}.mailingImage5TypeMime}"
           fileName="attach4.${'#'}{${listName}.mailingImage5Type}"
         disposition="inline" status="banner5" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapT[1]}">
       <#if (menuAttributesFunction?contains("89"))>
        <m:attachment value="${'#'}{${listName}.mailingText1.bytes}" contentType="text/plain" fileName="attach1.ics"
         disposition="inline" />
       <#else>
        <m:attachment value="${'#'}{${listName}.mailingText1.bytes}" contentType="text/plain" fileName="attach1.txt"
         disposition="inline" />
       </#if>
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapT[2]}">
        <m:attachment value="${'#'}{${listName}.mailingText2.bytes}" contentType="text/plain" fileName="attach2.txt"
         disposition="inline" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapT[3]}">
        <m:attachment value="${'#'}{${listName}.mailingText3.bytes}" contentType="text/plain" fileName="attach3.txt"
         disposition="inline" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapT[4]}">
        <m:attachment value="${'#'}{${listName}.mailingText4.bytes}" contentType="text/plain" fileName="attach4.txt"
         disposition="inline" />
        </ui:fragment> 
        <ui:fragment rendered="${'#'}{${listName}.checkMapT[5]}">
        <m:attachment value="${'#'}{${listName}.mailingText5.bytes}" contentType="text/plain" fileName="attach5.txt"
         disposition="inline" />
        </ui:fragment> 

        <#--
         from is display name but address is actual email address can have donotReply@3recommerce.com
         m:attachment inline must be before body 
        -->
        <#if (menuAttributesFunction?contains("89"))>
        <m:to name="${'#'}{${listName}.emailFirstName} ${'#'}{${listName}.emailLastName}">${'#'}{${listName}.emailAddress}</m:to>
       <#else>
        <m:to name="${'#'}{${listName}.${componentName}.${firstNameField}} ${'#'}{${listName}.${componentName}.${lastNameField}}">${'#'}{${listName}.${componentName}.${imailaddrField}}</m:to>
       </#if>
        <m:body>
       <#if (menuAttributesFunction?contains("89"))>
            <h:outputText value="${'#'}{${listName}.mailingSource}" />
        <#else>
         <html>
          <body>
           <p>
<#-- mailingSource is not a file so do not use bytes
-->
            <h:outputText value="${'#'}{${listName}.mailNameInfo}" rendered="${'#'}{${listName}.showNamesYN}"/>
            <br/><br/>
            <h:outputText value="${'#'}{${listName}.mailingSource}"  escape ="false"/>
            <br/><br/>
            <ui:fragment rendered="${'#'}{${listName}.checkMapI[1]}">
            <img   src="cid:${'#'}{banner1.contentId}"/>  
            </ui:fragment> 
            <ui:fragment rendered="${'#'}{${listName}.checkMapI[2]}">
            <img   src="cid:${'#'}{banner2.contentId}"/>  
            </ui:fragment> 
            <ui:fragment rendered="${'#'}{${listName}.checkMapI[3]}">
            <img   src="cid:${'#'}{banner3.contentId}"/>  
            </ui:fragment> 
            <ui:fragment rendered="${'#'}{${listName}.checkMapI[4]}">
            <img   src="cid:${'#'}{banner4.contentId}"/>  
            </ui:fragment> 
            <ui:fragment rendered="${'#'}{${listName}.checkMapI[5]}">
            <img   src="cid:${'#'}{banner5.contentId}"/>  
            </ui:fragment> 
            <h:outputText value="${'#'}{${listName}.signatureSource}"  escape ="false" rendered="${'#'}{${listName}.signatureYN}"/>
            <h:outputText value="   "  escape ="true" rendered="true"/>
            <h:outputText value="&lt;p style=&quot;font-family:arial;color:blue;font-size:8px;&quot;&gt;Unsubscribe by clicking &lt;a href=&quot;https://raaspi.l3recommerce.com:8080/unsc.wflow?keyCode=${'#'}{${listName}.${componentName}.${qKey}}&amp;unsc=${'#'}{${listName}.${componentName}.a0xxuobxbxxxxxxxxxxxsid}&amp;type=${unsctype}&quot;&gt;unsubscribe&lt;/a&gt;&lt;/p&gt;"  escape ="false" rendered="${'#'}{request.serverPort.toString().contains('8080') and ${listName}.unsubscribeYN}"/>
            <h:outputText value="&lt;p style=&quot;font-family:arial;color:blue;font-size:8px;&quot;&gt;Unsubscribe by clicking &lt;a href=&quot;https://raaspi.com/unsc.wflow?keyCode=${'#'}{${listName}.${componentName}.${qKey}}&amp;unsc=${'#'}{${listName}.${componentName}.a0xxuobxbxxxxxxxxxxxsid}&amp;type=${unsctype}&quot;&gt;unsubscribe&lt;/a&gt;&lt;/p&gt;"  escape ="false" rendered="${'#'}{!request.serverPort.toString().contains('8080') and ${listName}.unsubscribeYN}"/>
           </p>
          </body>
         </html>
         <f:facet name="alternative">
          Sorry, your mail reader doesn't support HTML...
          Here's in plain Text
            <h:outputText value="${'#'}{${listName}.mailingSource}" />
            <h:outputText value="${'#'}{${listName}.signatureSource}"  escape ="false" rendered="${'#'}{${listName}.signatureYN}"/>
           <#if (menuAttributesFunction?contains("89"))>
           <#else>
            <h:outputText value="   "  escape ="true" rendered="true"/>
            <h:outputText value="&lt;p style=&quot;font-family:arial;color:blue;font-size:8px;&quot;&gt;Unsubscribe by clicking &lt;a href=&quot;https://raaspi.l3recommerce.com:8080/unsc.wflow?keyCode=${'#'}{${listName}.${componentName}.${qKey}}&amp;unsc=${'#'}{${listName}.${componentName}.a0xxuobxbxxxxxxxxxxxsid}&amp;type=${unsctype}&quot;&gt;unsubscribe&lt;/a&gt;&lt;/p&gt;"  escape ="false" rendered="${'#'}{request.serverPort.toString().contains('8080') and ${listName}.unsubscribeYN}"/>
            <h:outputText value="&lt;p style=&quot;font-family:arial;color:blue;font-size:8px;&quot;&gt;Unsubscribe by clicking &lt;a href=&quot;https://raaspi.com/unsc.wflow?keyCode=${'#'}{${listName}.${componentName}.${qKey}}&amp;unsc=${'#'}{${listName}.${componentName}.a0xxuobxbxxxxxxxxxxxsid}&amp;type=${unsctype}&quot;&gt;unsubscribe&lt;/a&gt;&lt;/p&gt;"  escape ="false" rendered="${'#'}{!request.serverPort.toString().contains('8080') and ${listName}.unsubscribeYN}"/>
           </#if>
         </f:facet>  
        </#if> 

        </m:body>
     </m:message>
</ui:composition>

</#if>

