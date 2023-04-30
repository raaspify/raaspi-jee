<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)>
<#-- 56 (User) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#-- unlike create site, this can come from any tenant, so enhance logic to use tenant details rather then 3r, 3r is one of the tenants -->
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
                xmlns:rich="http://richfaces.org/rich">
<m:message >
<m:from name="3rcomputer.com" address="support@3rcomputer.com"/>
<m:to name="${'#'}{${userEntityName}Home.clientEmail}">${'#'}{${userEntityName}Home.clientEmail}</m:to>
<m:bcc name="3rcomputer.com" address="support@3rcomputer.com"/>
<m:subject>3R WorkFlow Account Activation-${'#'}{${userEntityName}Home.instance.a0xxukuxbvxxxxxxxxxxid}</m:subject>
<m:body>
<html>
<body>
<p>Dear ${'#'}{${userEntityName}Home.instance.a0xxukuxbvxxxxxxxxxxid},</p>
<p style="font-family:arial;color:black;font-size:20px;">Thank you for signing up with us . To complete your new account Sign Up, you will need to confirm that you
received this email by clicking the link below:</p>
<p><a href="${'#'}{${userEntityName}Home.newUserLink}">${'#'}{${userEntityName}Home.newUserLink}</a></p>
<p>If clicking the link does not work, just copy and paste the entire
link into your browser.</p>
<br/>
<p>Logon Email Id: ${'#'}{${userEntityName}Home.instance.c1xxuxxxbvxxxxxxxxxxotherid}</p>
<p style="font-family:arial;color:red;font-size:20px;">Logon Id: ${'#'}{${userEntityName}Home.instance.a0xxukuxbvxxxxxxxxxxid}</p>

<p style="font-family:arial;color:red;font-size:20px;">The Password is:  ${'#'}{${userEntityName}Home.instance.c6xxuxuoivxxxxxxxxxxoldpw}</p>
<br/>
<p>You may find it easier to cut and paste the password</p>
 
<p>Sincerely,</p>
<p>${'#'}{request.serverName} Support</p>
</body>
</html>
</m:body>
</m:message>
</ui:composition>

</#if>
</#if>

