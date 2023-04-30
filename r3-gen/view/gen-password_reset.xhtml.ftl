<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
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
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:m="http://jboss.org/schema/seam/mail"
                xmlns:p="http://primefaces.org/ui">

<m:message >
<m:from name="3rcomputer.com" address="support@3rcomputer.com"/>
<m:to name="${'#'}{${userEntityName}Home.recoveredPasswordEmail}">${'#'}{${userEntityName}Home.recoveredPasswordEmail}</m:to>
<m:subject>3R WorkFlow ${'#'}{messages.reset_password} - ${'#'}{${userEntityName}Home.lostPasswordUserId}</m:subject>
<m:body><html>
<body>
<p>${'#'}{${userEntityName}Home.lostPasswordUserId},</p>
<p>Your password has been temporarily reset to: ${'#'}{${userEntityName}Home.resetPassword}</p>
<p>Please login as ${'#'}{${userEntityName}Home.lostPasswordUserId} and change the password to something you can remember.</p>
</body>
</html></m:body>
</m:message>
</ui:composition>

</#if>
</#if>

