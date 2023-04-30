<#include "../view/assigns/PositionLength.properties" >
<#if ( (property.name?substring(pkS,pkE) != "k") && (property.value.identifierGeneratorStrategy == "assigned") )>
 <#if c2j.isComponent(property)>
  <#foreach componentProperty in property.value.propertyIterator>
   <#assign propertyType = componentProperty.value.typeName>
     <#if componentProperty.name?substring(8,9) == "h" >
            <ui:decorate id="${componentProperty.name}Decoration" template="layout/edit.xhtml" rendered="${'#'}{customIdentity.hasRole('EH')}">
     <#elseif componentProperty.name?substring(8,9) == "x" ||  componentProperty.name?substring(8,9) == "x"  >
            <ui:decorate id="${componentProperty.name}Decoration" template="layout/edit.xhtml" rendered="false">
     <#elseif componentProperty.name?substring(8,9) == "i" >
            <ui:decorate id="${componentProperty.name}Decoration" template="layout/edit.xhtml" rendered="${'#'}{customIdentity.hasRole('IH')}">
     <#elseif componentProperty.name?substring(8,9) == "s" >
            <ui:decorate id="${componentProperty.name}Decoration" template="layout/edit.xhtml" rendered="${'#'}{customIdentity.hasRole('SH')}">
     <#else>   
            <ui:decorate id="${componentProperty.name}Decoration" template="layout/edit.xhtml">
     </#if>
            <ui:define name="label">${'#'}{messages['${componentProperty.name?substring(pL)?cap_first}']}</ui:define>
   <#if propertyType == "date">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                <f:convertDateTime type="date" dateStyle="short"/>
            </h:outputText>
   <#elseif propertyType == "time">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                <f:convertDateTime type="time"/>
            </h:outputText>
   <#elseif propertyType == "timestamp">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                <f:convertDateTime type="both" dateStyle="short"/>
            </h:outputText>
   <#elseif propertyType == "big_decimal">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
             <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
            </h:outputText>
   <#elseif propertyType == "big_integer">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                <f:convertNumber integerOnly="true"/>
            </h:outputText>
   <#else>
            ${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}
   </#if>
        </ui:decorate>
  </#foreach>
 <#else>
  <#-- jan 13 2019 ui:decorate does not have render, use ui:fragment -->
  <#assign propertyType = property.value.typeName>
    <#if property.name?substring(8,9) == "h" >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#elseif property.name?substring(8,9) == "l" ||  property.name?substring(8,9) == "x" 
             ||  property.name?substring(5,7) == "2o"   >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#elseif property.name?substring(0,1) == "y" || property.name?substring(0,1) == "z"   >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#elseif property.name?substring(5,6) == "d"  >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#elseif property.name?substring(2,3) == "f" & property.name?substring(3,4) == "b"  >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#elseif property.name?substring(pkS,pkE)=="k" && keyfromsubkeys=="Y"> 
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml"   >
    <#elseif property.name?substring(8,9) == "i" >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#elseif property.name?substring(8,9) == "s" >
            <ui:decorate id="${property.name}Decoration" template="layout/edit.xhtml" >
    <#else>   
            <ui:decorate id="${property.name}" template="layout/display.xhtml">
    </#if>
            <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']}</ui:define>

  <#if propertyType == "date">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}}">
                <f:convertDateTime type="date" dateStyle="short"/>
            </h:outputText>
  <#elseif propertyType == "time">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}}">
                <f:convertDateTime type="time"/>
            </h:outputText>
  <#elseif propertyType == "timestamp">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}}">
                <f:convertDateTime type="both" dateStyle="short"/>
            </h:outputText>
  <#elseif propertyType == "big_decimal">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}}">
              <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
            </h:outputText>
  <#elseif propertyType == "big_integer">
            <h:outputText value="${'#'}{${homeName}.instance.${property.name}}">
                <f:convertNumber integerOnly="true"/>
            </h:outputText>
  <#else>
           <#if property.name?substring(pfS,pfE)=="zb"> 
                 <ui:remove> url allows delay to load the image as opposed to previous jsf h:graphicImage ??
                  blobdata table and data contents are different than non clob/blob
                 </ui:remove>

                 <p:panel rendered="true">
                  <img alt="image"
                   src="/ImageServletCdi/?seq=${'#'}{${blobdataEntityName}Home.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=B${'#'}{${blobdataEntityName}Home.instance.a1xxuxxxbv49xxxxxxxxfromkey}&amp;height=100" >
                  </img> 
                 </p:panel>
              <h:commandButton value="+" oncomplete="PF('popup').show()" rendered="${'#'}{${homeName}.instance.a4xxexxxbvxxxxxxxxxxtype.startsWith('j') || ${homeName}.instance.a4xxexxxbvxxxxxxxxxxtype.startsWith('pn')|| ${homeName}.instance.a4xxexxxbvxxxxxxxxxxtype.startsWith('b') and !yxxxuh566xwwqqwxxxxxuserHome.mobile}">
              </h:commandButton>
              <h:outputText value="PDF" rendered="${'#'}{${homeName}.instance.a4xxexxxbvxxxxxxxxxxtype.startsWith('pd')}" />
              <h:outputText value="XLS" rendered="${'#'}{${homeName}.instance.a4xxexxxbvxxxxxxxxxxtype.startsWith('xls')}" />
              <h:outputText value="PPT" rendered="${'#'}{${homeName}.instance.a4xxexxxbvxxxxxxxxxxtype.startsWith('ppt')}" />
              <p:dialog id="popup" modal="false" autosized="true" resizeable="false">
                             <f:facet name="header">
                              <h:outputText value=" " />
                              <h:outputLink value="${'#'}" onclick="PF('popup')}.hide()">
                                 CLOSE X
                               </h:outputLink>
                             </f:facet>
                             <f:facet name="controls">
                              <h:outputLink value="${'#'}" onclick="PF('popup')}.hide()">
                                 X
                               </h:outputLink>
                             </f:facet>
                  <img alt="image"
                   src="/ImageServletCdi/?seq=${'#'}{${blobdataEntityName}Home.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=B${'#'}{${blobdataEntityName}Home.instance.a1xxuxxxbv49xxxxxxxxfromkey}&amp;height=100" >
                  </img> 
                             <p:commandButton value="-" onclick="PF('popup')}.hide()"/>
              </p:dialog>
           <#elseif property.name?substring(pfS,pfE)=="za"> 
              <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  />
           <#elseif property.name?substring(pfS,pfE)=="zd"> 
              <h:graphicImage 
              value="/ImageServletCdi/?table=${componentName?upper_case}&amp;seq=1&amp;qlf=1&amp;id=${'#'}{${homeName}.instance.${property.name}}&amp;width=50" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('i')}">
              </h:graphicImage> 
              <h:commandButton value="+" oncomplete="PF('popup').show()" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('i')}">
              </h:commandButton>
              <h:outputText value="${homeName}.getClobdata({'${componentName?upper_case}',${homeName}.instance.${property.name},1,1,500)}" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('t')}" />
              <h:outputText value="PDF" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('pd',pL)}" />
              <h:outputText value="XLS" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('ex',20)}" />
              <h:outputText value="PPT" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('po',19)}" />
              <p:dialog id="popup" modal="false" autosized="true" resizeable="false">
                             <f:facet name="header">
                              <h:outputText value=" " />
                              <h:outputLink value="${'#'}" onclick="PF.hide()">
                                 CLOSE X
                               </h:outputLink>
                             </f:facet>
                             <f:facet name="controls">
                              <h:outputLink value="${'#'}" onclick="PF.hide()">
                                 X
                               </h:outputLink>
                             </f:facet>

                             <h:graphicImage
                               value="/ImageServletCdi/?table=${componentName?upper_case}&amp;seq=1&amp;qlf=1&amp;id=${'#'}{${homeName}.instance.${property.name}}&amp;width=200" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',${homeName}.instance.${property.name},1,1).startsWith('i')}">
                             </h:graphicImage> 
                             <p:commandButton value="-" onclick="PF.hide()"/>
              </p:dialog>

           <#elseif property.name?substring(pefS,pefE)=="po" || property.name?substring(pefS,pefE)=="ph" > 
            <a href='tel:${'#'}{${homeName}.instance.${property.name}}'>${'#'}{${homeName}.instance.${property.name}}</a>
           <#elseif property.name?substring(pfS,pfE)=="2o" > 
           <#else>
            <#if property.name?substring(pfS,pfE)=="zf"> 
             <#if (menuAttributesFunction =="20" |menuAttributesFunction =="30" |menuAttributesFunction =="40" ) >
              <h:outputText value="${'#'}{${homeName}.instance.${property.name} eq 4 ?'returned/rejected':(${homeName}.instance.${property.name} eq 8 ?'closed':(${homeName}.instance.${property.name} eq 16 ?'paid/waiting approval':( ${homeName}.instance.${property.name} eq 32 ?'shipped/approved': (${homeName}.instance.${property.name} eq 64 ?'unsubscribed':'new/other'))))}"  id="zcxxzzfxhhxxxxxxxxxxstatusfl" />
             <#else>
              <h:outputText value="${'#'}{${homeName}.instance.${property.name} eq 4 ?'returned/rejected':(${homeName}.instance.${property.name} eq 8 ?'closed':(${homeName}.instance.${property.name} eq 16 ?'paid/waiting approval':( ${homeName}.instance.${property.name} eq 32 ?'shipped/approved': (${homeName}.instance.${property.name} eq 64 ?'invoiced/final approved':'new/other'))))}"  id="zcxxzzfxhhxxxxxxxxxxstatusfl" />
             </#if>

            <#elseif property.name?substring(8,9) == "h" >
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}" rendered="${'#'}{customIdentity.hasRole('EH')}"/>
             <h:outputText value="XXXXXX" rendered="${'#'}{!customIdentity.hasRole('EH')}"/>
            <#elseif (property.name?substring(8,9) == "l" && (property.name?substring(pfS,pfE)!="tp" && property.name?substring(pfS,pfE)!="tq" && property.name?substring(pfS,pfE)!="yp")) ||  property.name?substring(8,9) == "x" 
              ||  property.name?substring(5,7) == "2o"   >
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="false"/>
            <#elseif property.name?substring(0,1) == "y" || (property.name?substring(0,1) == "z" && (property.name?substring(pfS,pfE)!="tp" && property.name?substring(pfS,pfE)!="tq" && property.name?substring(pfS,pfE)!="yp"))>
             <#if property.name?substring(8,9) == "s" >
              <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="${'#'}{customIdentity.hasRole('SH')  or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin')))  and !(customIdentity.restrict1=='D')}"/>
              <h:outputText value="XXXXXX"  rendered="${'#'}{customIdentity.hasRole('SH')  or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and customIdentity.restrict1=='D'}"/>
             <#else>
              <#if (menuAttributesFunction =="1a" && property.name?substring(property.name?length-6,property.name?length)=="ccode2")>
               <h:outputText value="${'#'}{${homeName}.instance.${property.name}}" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct =='s' and (fpxxfq1a5xwwqqhxxxxxitemHome.instance.c6xxusxrbv16xxxxxxxxtype == 'BI-L1' || fpxxfq1a5xwwqqhxxxxxitemHome.instance.c6xxusxrbv16xxxxxxxxtype == 'PI-L1')  and fpxxfq1a5xwwqqhxxxxxitemHome.instance.zexxutoxlhxxxxxxxxxxowner == customIdentity.owner )}"/>
               <h:outputText value="${'#'}{${homeName}.instance.${property.name}}" rendered="${'#'}{not(customIdentity.product=='f' and customIdentity.subProduct =='s')}"/>
              <#else>
               <h:outputText value="${'#'}{${homeName}.instance.${property.name}}" rendered="true"/>
              </#if>
             </#if>
            <#elseif property.name?substring(5,6) == "d"  >
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="false"/>
            <#elseif property.name?substring(2,3) == "f" & property.name?substring(3,4) == "b"  >
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}"/>
            <#elseif property.name?substring(pkS,pkE)=="k" && keyfromsubkeys=="Y"> 
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="false" />
            <#elseif property.name?substring(8,9) == "i" >
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="true"/>
            <#elseif property.name?substring(8,9) == "s" >
             <h:outputText value="${'#'}{${homeName}.instance.${property.name}}"  rendered="${'#'}{customIdentity.hasRole('SH')  or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and !(customIdentity.restrict1=='D')}"/>
             <h:outputText value="XXXXXX"  rendered="${'#'}{customIdentity.hasRole('SH')  or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and customIdentity.restrict1=='D'}"/>
            <#else>   
             ${'#'}{${homeName}.instance.${property.name}}
            </#if>
           </#if>
  </#if>
        </ui:decorate>
 </#if>
</#if>
