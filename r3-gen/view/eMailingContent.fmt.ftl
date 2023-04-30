<#assign mailingCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
 <#assign menuAttributesFunction = pojo.shortName?substring(efS,efE)>
  <#assign mailingCandidate ="Y" >
</#if>
<#if mailingCandidate == "Y">                       
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign listName = componentName + "List">
<#assign pageName = entityName>
<#assign editPageName = entityName + "Edit">
<#assign listPageName = entityName + "List">
<#assign menuPageName = "home">
<#assign mailingCandidate = "N">  
  
         <html>
          <body>
            <p>${'$'}{list.mailingSource} </p>

          </body>
         </html>

</#if>

