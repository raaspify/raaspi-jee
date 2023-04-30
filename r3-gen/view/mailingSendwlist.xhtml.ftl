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
                xmlns:s="http://jboss.org/schema/seam/taglib"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:o="http://omnifaces.org/ui"
                xmlns:p="http://primefaces.org/ui"
                template="layout/rtemplate.xhtml">
<#-- Generated By mailingSend.xhtml.ftl on ${.now}
mailing send page
this calls send method in list, which will render mailingContent.xhtml
mailingContent calls methods in list to 
parameters passed: none
popupPanels: 0
todo:
-->
<ui:define name="body">
    
    
    <h:form id="${componentName}Mailing" styleClass="edit">
     <h:outputStylesheet>
     </h:outputStylesheet>

      <#assign keyField="a0xxukxxbvxxxxxxxxxxcustomer"> 

      <h:messages globalOnly="true" styleClass="message" id="globalMessages"/>
      <h:graphicImage value="/img/email_stop16.png" />
      <#if menuAttributesp2 ="20">
      <#assign keyField=customerKeyField> 
      <h:outputText id="jayes" value="${'#'}{${listName}.${componentName}.q4xxhxxxbv24xxxxxxxximailaddr}"/> 
      </#if>
      <#if menuAttributesp2 ="30">
      <#assign keyField=vendorKeyField> 
      <h:outputText id="jayes" value="${'#'}{${listName}.${componentName}.n4xxhxxrbv24xxxxxxxximailaddr}"/> 
      </#if>
      <#if menuAttributesp2 ="40">
      <#assign keyField=employeeKeyField> 
      <h:outputText id="jayes" value="${'#'}{${listName}.${componentName}.n4xxhxxrbv24xxxxxxxximailaddr}"/> 
      </#if>
	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
              <s:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  view="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{identity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['${componentName?substring(eL)?cap_first}MailingSendHelp']!=null}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['${componentName?substring(eL)?cap_first}MailingSendHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
	</p:toolbar>

        <div class="actionButtons">
         <h:panelGrid columns="10">      
           <#if mailingCandidate == "Y" >
            <p:commandButton id="mailingP" styleClass="buttonMain" value="${'#'}{messages['preview']} ${'#'}{messages['send.count']}" status="buttonStatus" action="${'#'}{${listName}.previewSend}"> 
             </p:commandButton> 
            <p:commandButton id="mailing" render="jayes,globalMessages" value="${'#'}{messages['mail.send']} " status="buttonStatus" action="${'#'}{${listName}.send}"> 
             </p:commandButton> 
           </#if>
             <p:status name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:status>

           <s:button view="/${'#'}{empty ${componentName}From ? '${menuPageName}' : ${componentName}From}.xhtml"
                    id="done1"
                 value="Done"/>
           <ui:remove>
           <h:outputText value="${'#'}{messages['range']}"/> 
           <#if messagingCandidate == "Y" >
            <h:outputText id="pjay" size="21" value="  Send Start/End/Qualifier "/> 
            <h:inputText id="pstartk1" size="21" value="${'#'}{${homeName}.startk1}"/> 
            <h:outputText id="pspacek1" size="5" value="    "/> 
            <h:inputText id="pstartk2" size="21" value="${'#'}{${homeName}.startk2}"/> 
            <h:outputText id="pspacek2" size="5" value="    "/> 
            <h:inputText id="pstartk3" size="21" value="${'#'}{${homeName}.startk3}"/> 
            <h:outputText id="pspace3" size="5" value="    "/> 
            <h:inputText id="pendk1" size="21" value="${'#'}{${homeName}.endk1}"/> 
            <h:outputText id="pspaceke1" size="5" value="    "/> 
            <h:inputText id="pendk2" size="21" value="${'#'}{${homeName}.endk2}"/> 
            <h:outputText id="pspaceke2" size="5" value="    "/> 
            <h:inputText id="pendk3" size="21" value="${'#'}{${homeName}.endk3}"/> 
            <h:outputText id="pspaceke3" size="5" value="    "/> 
           </#if>
            <h:graphicImage value="/img/email_start16.png" />
            <p:autocomplete mode="client"  autocompleteMethod="${'#'}{${listName}.suggest}" 
                  value="${'#'}{${listName}.start}"  inputClass="autoCompleteWidth50" popupClass="autoCompletePopupHieght" onclick="this.select()" type="text" 
                   tokens="," minChars="0" autoFill="false" selectFirst="false" showButton="true"
                   var ="result" fetchValue="${'#'}{result}" layout="table"
                   rendered="${'#'}{fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   >
                 <p:column>
                  <b>${'#'}{result}</b>
                 </p:column>
            </p:autocomplete>
                 <h:selectOneMenu  value="${'#'}{${listName}.start}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${listName}.suggest(${homeName}.prefix)}" var="result"
                   itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                 </h:selectOneMenu>
            <h:graphicImage value="/img/email_stop16.png" />
            <p:autocomplete mode="client"  autocompleteMethod="${'#'}{${listName}.suggest}" 
                  value="${'#'}{${listName}.end}"   inputClass="autoCompleteWidth50" popupClass="autoCompletePopupHieght" onclick="this.select()" type="text" 
                   tokens="," minChars="0" autoFill="false" selectFirst="false" showButton="true"
                   var ="result" fetchValue="${'#'}{result}" layout="table"
                   rendered="${'#'}{fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   >
                 <p:column>
                  <b>${'#'}{result}</b>
                 </p:column>
            </p:autocomplete>
                 <h:selectOneMenu  value="${'#'}{${listName}.end}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${listName}.suggest(${homeName}.prefix)}" var="result"
                   itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                 </h:selectOneMenu>
             </ui:remove>
            </h:panelGrid>
            <h:panelGrid columns="8">   
              <ui:remove> 
              <h:outputText value="${'#'}{messages['Or']} "/> 
              </ui:remove>
              <h:panelGroup>
              <h:graphicImage value="/img/Groupmembers16.png" />
              <h:outputText value="${'#'}{messages['select']} ${'#'}{messages['group']}"/> 
                 <h:selectOneMenu  value="${'#'}{${listName}.groupSid}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${membersgroupEntityName}List.getSuggestList(${membersgroupEntityName}.prefix)}" var="result"
                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.a0xxukxxbvxxxxxxxxxxgroupid}" />
                 </h:selectOneMenu>
              </h:panelGroup>
              <h:outputText value="${'#'}{messages['Or']} "/> 
              <h:outputText value="${'#'}{messages['To']} "/> 
                 <h:selectManyListbox  id="toSelect" value="${'#'}{${listName}.toSelects}" size="5"
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${listName}.getSuggestList(${homeName}.prefix)}" var="result"

                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.${keyField}}" />
                   <p:tooltip id="searchTip" attached="true" for="toSelect" >
                    <h:outputText value="${'#'}{messages['Ctrl']} ${'#'}{messages['for']} ${'#'}{messages['multiselect']}" />
                   </p:tooltip>
                 </h:selectManyListbox>
              <h:outputText value="${'#'}{messages['and']} "/> 
  
            <h:outputText value="${'#'}{messages['Cc']}"/> 
                 <h:selectManyListbox  value="${'#'}{${listName}.ccSelects}" size="5"
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${listName}.getSuggestList(${homeName}.prefix)}" var="result"
                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.${keyField}}" />
                 </h:selectManyListbox>


         </h:panelGrid>      

        </div>
           <f:param name="mailingSubject" value="${'#'}{${listName}.mailingSubject}"/>
           <f:param name="attachment" value="${'#'}{${listName}.attachment}" /> 
        
 <p:panel toggleable="true" toggleableHeader="true"  header="${'#'}{messages['${entityName?substring(eL)?cap_first}']}- ${'#'}{messages['ListSearchToggleBase']}" switchType="ajax" collapsed="true"
     leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">

<#--  search value is entered here and will be seached against 3 properties. The 3 property names
      will be selected in backing bean depending on entity type and would be key,subkeys or descript or amount
      etc and will be used in resultList where clause.  -->
<h:panelGrid columns="2">
<s:decorate template="layout/display.xhtml">
<ui:define name="label">${'#'}{messages['Search_string']}</ui:define>
<h:inputText id="searchV" value="${'#'}{${listName}.searchVal}"/>
</s:decorate>
</h:panelGrid>
<h:panelGrid columns="8">
          <f:facet name="header">${'#'}{messages['Search_Range']}
          </f:facet>   
          <h:graphicImage value="/img/Resultset_first16.png" />
            <p:autocomplete mode="client"  autocompleteMethod="${'#'}{${listName}.suggest}" 
                  value="${'#'}{${listName}.start}"  inputClass="autoCompleteWidth50" popupClass="autoCompletePopupHieght" onclick="this.select()" type="text" 
                   tokens="," minChars="0" autoFill="false" selectFirst="false" showButton="true"
                   var ="result" fetchValue="${'#'}{result}" layout="table"
                   rendered="${'#'}{fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   >
                 <p:column>
                  <b>${'#'}{result}</b>
                 </p:column>
            </p:autocomplete>
<#--         for item do not use suggest since it filters entries like no closed  and start / end uses keylist which does not filter  give more thought -->
<#--         suggest may need more params to make it suitable    -->
            <h:panelGrid columns="2">
                 <h:selectOneMenu  value="${'#'}{${listName}.start}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <#if (menuAttributesp2?contains("1A"))>
                   <f:selectItems value="${'#'}{${listName}.get${entityName?substring(10)}KeyList()}" var="result"
                    itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                  <#else>
                   <#if (menuAttributesp2?contains("1R") ) >
                    <f:selectItems value="${'#'}{${listName}.getSuggestList('*')}" var="result"
                     itemValue="${'#'}{result.a1xxuxxxbvxxxxxxxxxxvalue}" itemLabel="${'#'}{result.a0xxukrdbvxxxxxxxxxxkey.concat('/ ').concat(result.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname).concat('/ ').concat(result.zzxxu2oxxhxxxxxxxxxxowner2).concat('- ').concat(fn:substring(result.a1xxuxxxbvxxxxxxxxxxvalue,0,15))}" />
                   <#else>
                    <f:selectItems value="${'#'}{${listName}.suggest(${homeName}.prefix)}" var="result"
                     itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                   </#if>
                  </#if>  
                 </h:selectOneMenu>
            </h:panelGrid>
            <h:graphicImage value="/img/Resultset_last16.png" />
            <p:autocomplete mode="client"  autocompleteMethod="${'#'}{${listName}.suggest}" 
                  value="${'#'}{${listName}.end}"   inputClass="autoCompleteWidth50" popupClass="autoCompletePopupHieght" onclick="this.select()" type="text" 
                   tokens="," minChars="0" autoFill="false" selectFirst="false" showButton="true"
                   var ="result" fetchValue="${'#'}{result}" layout="table"
                   rendered="${'#'}{fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   >
                 <p:column>
                  <b>${'#'}{result}</b>
                 </p:column>
            </p:autocomplete>
            <h:panelGrid columns="2">
                 <h:selectOneMenu  value="${'#'}{${listName}.end}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <#if (menuAttributesp2?contains("1A"))>
                   <f:selectItems value="${'#'}{${listName}.get${entityName?substring(10)}KeyList()}" var="result"
                    itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                  <#else>
                   <f:selectItems value="${'#'}{${listName}.suggest(${homeName}.prefix)}" var="result"
                    itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                  </#if>  
                 </h:selectOneMenu>
            </h:panelGrid>

</h:panelGrid>
        <div class="actionButtons">
<#--
 search uses seam entityList provided ejbql and supporting restrictions logic to show searched list
 ListPageName.xhtml has data list which shows result of query list. The query list uses restrictions and restrictionLogicOperator etc
 whose values are passed as parameter value via xxxList.page.xml .
 currently restriction logic assume value ending with %, look into changing it to starting and ending with ie containing
-->
            <h:commandButton id="search" value="${'#'}{messages['Search']}" actionListener="${'#'}{${listName}.first}"/>
            <s:button id="reset" value="${'#'}{messages['Reset']}"  includePageParams="false"/>
        </div>


    <p:panel>
        <div class="actionButtons">
             <h:commandButton id="copyallt" value="Copy All Flagged"  action="${'#'}{${homeName}.copyAllMarked()}" status="buttonStatus"/>
             <p:status name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:status>

             <h:commandButton id="deleteallt" value="Delete All Flagged"  action="${'#'}{${homeName}.deleteAllFlagged()}"
              onclick="if (! confirm('Really delete ?') ) { return false;}; return true; " />
             <#-- checked entity was not picking up changes, even with ajax needs more trying out, use row edit -->
             <h:commandButton id="updateallt" value="Update All Flagged"  rendered="false" action="${'#'}{${homeName}.updateAllFlagged()}"/>
             <h:commandButton id="emailIcal" value="${'#'}{messages['email']} ${'#'}{messages['as']} ${'#'}{messages['iCalendar']}"  action="${'#'}{${homeName}.writeAsIcalText()}"/>
            <s:button view="/${'#'}{empty ${componentName}From ? '${menuPageName}' : ${componentName}From}.xhtml"
                    id="done"
                 value="Done"/>
        </div>

        <f:facet name="header">${entityName?substring(eL)?cap_first} search results</f:facet>
    <div class="results" id="${componentName}List" style="overflow-x:auto">

    <h:outputText value="No ${componentName?substring(eL)?cap_first} exists" 
               rendered="${'#'}{empty ${listName}.resultList}"/>
               
    <p:extendedDataTable id="${listName}"  frozenColumns="2"
                var="${componentName}"
              value="${'#'}{${listName}.resultList}" 
           rendered="${'#'}{not empty ${listName}.resultList}">

           <#assign loop =0 >
           <#if c2j.isComponent(pojo.identifierProperty)>
            <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
             <#if loop = 0>
              <#assign selectParam = '_'+componentName+'.' + pojo.identifierProperty.name>
              <#assign loop =1 >
             </#if>
            </#foreach> 
           <#else>
            <#assign selectParam = '_'+componentName +'.'+pojo.identifierProperty.name>
           </#if>

        <h:column>
                            <f:facet id="MarkerFacet" name="header">
                                <h:outputText id="markit" value="Flag" />
                            </f:facet>
                            <h:selectBooleanCheckbox id="MarkItCheckbox" value="${'#'}{${homeName}.checked[${componentName}.a0xxuobxbxxxxxxxxxxxsid]}"/>
            <s:link view="/${'#'}{empty from ? '${pageName}' : from}.xhtml"
                   value="${'#'}{empty from ? 'View' : 'Select'}"
             propagation="${'#'}{empty from ? 'none' : 'default'}"
                      id="${componentName}ViewId">
             <#if pojo.isComponent(pojo.identifierProperty)>
              <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${componentProperty.name?cap_first}"
                        value="${'#'}{${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
              </#foreach>
             <#else>
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{${componentName}.${pojo.identifierProperty.name}}"/>
             </#if>
            </s:link>
            ${'#'}{' '}
            <s:link view="/${editPageName}.xhtml"
                   value="Edit"
             propagation="none"
                      id="${componentName}Edit1"
             <#if menuAttributesp2?contains("56")>
                rendered="${'#'}{empty from and (s:hasRole('UH')||s:hasRole('UQ')||s:hasRole('VH')||s:hasRole('VQ') || s:hasRole('VW'))}">
             <#else>
                rendered="${'#'}{empty from and (s:hasRole('UH')||s:hasRole('UQ')||s:hasRole('PH') || (s:hasRole('VH')||s:hasRole('VQ') and identity.product =='f' and identity.subProduct =='s') )}">
             </#if>
             <#if pojo.isComponent(pojo.identifierProperty)>
              <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${componentProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
              </#foreach>
             <#else>
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}}"/>
             </#if>
             <#if menuAttributesp2?contains("23") || menuAttributesp2?contains("24") || menuAttributesp2?contains("25") || menuAttributesp2?contains("26")>
                <f:param name="${itemEntityName}A0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{_${componentName}.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid}"/>
                <f:param name="${customerEntityName}A0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{_${componentName}.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid}"/>
             </#if>

            </s:link>

        </h:column>

<#-- @outputValue is a macro inside typeInfo.ftl in r3gen/util dir -->
       <#foreach property in pojo.allPropertiesIterator>
        <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
         <#if pojo.isComponent(property)>
          <#foreach componentProperty in property.value.propertyIterator>
           <h:column>
            <f:facet name="header">${componentProperty.name}</f:facet>
            ${'#'}{${componentName}.${property.name}.${componentProperty.name}}
           </h:column>
          </#foreach>
         <#else>
          <#if ( ((property.name?substring(pfS,pfE)!="za") && (property.name?substring(pfS,pfE)!="zb") && (property.name?substring(pfS,pfE)!="zd") && (property.name?substring(pfS,pfE)!="zf") && (property.name?substring(pfS,pfE)!="zt")) && ((property.name?substring(0,1) == "y") || (property.name?substring(0,1) == "z" )
           || (property.name?substring(0,6) == "a0xxuo" ) ) )   > 
          <#-- ${property.name}-->
          <#else>
           <h:column>
            <f:facet name="header">
                <s:link styleClass="columnHeader"
                             value="${property.name?substring(pL)} ${'#'}{${listName}.order=='${property.name} asc' ? messages.down : ( ${listName}.order=='${property.name} desc' ? messages.up : '' )}">
                    <f:param name="order" value="${'#'}{${listName}.order=='${property.name} asc' ? '${property.name} desc' : '${property.name} asc'}"/>
                </s:link>
            </f:facet>
            ${'#'}{${componentName}.${property.name}}
           </h:column>
          </#if>          
         </#if>

        </#if>
        <#if c2h.isManyToOne(property)>
         <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
         <#if parentPojo.isComponent(parentPojo.identifierProperty)>
          <#foreach componentProperty in parentPojo.identifierProperty.value.propertyIterator>
           <h:column>
            <f:facet name="header">
            <#assign propertyPath = property.name + '.' + parentPojo.identifierProperty.name + '.' + componentProperty.name>
                <s:link styleClass="columnHeader"
                    value="${property.name?substring(eL)} ${componentProperty.name?substring(pL)} ${'#'}{${listName}.order=='${propertyPath} asc' ? messages.down : ( ${listName}.order=='${propertyPath} desc' ? messages.up : '' )}">
                    <f:param name="order" value="${'#'}{${listName}.order=='${propertyPath} asc' ? '${propertyPath} desc' : '${propertyPath} asc'}"/>
                </s:link>
            </f:facet>
            ${'#'}{${componentName}.${propertyPath}}
           </h:column>
          </#foreach>
         <#else>
          <h:column>
            <f:facet name="header">
            <#assign propertyPath = property.name + '.' + parentPojo.identifierProperty.name>
                <s:link styleClass="columnHeader"
                             value="${property.name?substring(eL)} ${parentPojo.identifierProperty.name?substring(pL)} ${'#'}{${listName}.order=='${propertyPath} asc' ? messages.down : ( ${listName}.order=='${propertyPath} desc' ? messages.up : '' )}">
                    <f:param name="order" value="${'#'}{${listName}.order=='${propertyPath} asc' ? '${propertyPath} desc' : '${propertyPath} asc'}"/>
                </s:link>
            </f:facet>
            ${'#'}{${componentName}.${propertyPath}}
          </h:column>
         </#if>
        </#if>
       </#foreach>
        <p:column styleClass="action">
            <f:facet name="header">Action</f:facet>
            ${'#'}{' '}
            <s:link view="/${editPageName}.xhtml"
                   value="Edit"
             propagation="none"
                      id="${componentName}Edit"
                rendered="${'#'}{empty from and (s:hasRole('UH')||s:hasRole('UQ')||s:hasRole('VH')||s:hasRole('VQ'))}">
             <#if pojo.isComponent(pojo.identifierProperty)>
              <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${componentProperty.name?cap_first}"
                        value="${'#'}{${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
              </#foreach>
             <#else>
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{${componentName}.${pojo.identifierProperty.name}}"/>
             </#if>
            </s:link>
            ${'#'}{' '}
           <#if documentField != "" >
            <h:commandButton id="Download" value="Download" rendered="${'#'}{empty from}" action="${'#'}{${homeName}.downloadThis(${selectParam})}"/>
           </#if>
        </p:column>
    </p:extendedDataTable>
    </div>
    </p:panel>
    <div class="tableControl">
      
        <s:link view="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.previousExists}" 
               value="${'#'}{messages.left}${'#'}{messages.left} First Page"
                  id="firstPage">
          <f:param name="firstResult" value="0"/>
        </s:link>
        
        <s:link view="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.previousExists}" 
               value="${'#'}{messages.left} Previous Page"
                  id="previousPage">
            <f:param name="firstResult" 
                    value="${'#'}{${listName}.previousFirstResult}"/>
        </s:link>
        
        <s:link view="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.nextExists}" 
               value="Next Page ${'#'}{messages.right}"
                  id="nextPage">
            <f:param name="firstResult" 
                    value="${'#'}{${listName}.nextFirstResult}"/>
        </s:link>
        
        <s:link view="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.nextExists}" 
               value="Last Page ${'#'}{messages.right}${'#'}{messages.right}"
                  id="lastPage">
            <f:param name="firstResult" 
                    value="${'#'}{${listName}.lastFirstResult}"/>
        </s:link>
        
    </div>
    
    <s:div styleClass="actionButtons" rendered="${'#'}{empty from}">
     <s:button view="/${editPageName}.xhtml"
                    id="create" 
                 value="Create ${componentName?substring(eL)?cap_first}">
     <#assign idName = componentName + util.upper(pojo.identifierProperty.name)>
     <#if c2j.isComponent(pojo.identifierProperty)>
      <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
       <#assign cidName = componentName + util.upper(componentProperty.name)>
            <f:param name="${cidName}"/>
      </#foreach>
     <#else>
            <f:param name="${idName}"/>
     </#if>
     </s:button>
    </s:div>
</p:panel>
       <p:panel header="${'#'}{messages['${entityName?substring(eL)?cap_first}']} Mailing " 
           leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
          <h:panelGrid columns="1">
            <s:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['mailing.mailingSubject']} </ui:define>
                <h:inputText id="mailingSubject" onclick="this.value='';" value="${'#'}{${listName}.mailingSubject}" size="60" />
            </s:decorate>
          <h:panelGrid columns="1">
            <s:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['mailing.mailingSource']}</ui:define>
                <p:editor id="editor" value="${'#'}{${listName}.mailingSource}">  
                  <f:facet name="config">
                    toolbar: 'custom',
                    toolbar_custom:
                        [
                            { name: 'document', items : [ 'NewPage','Preview' ] },
                            { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
                            { name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','Scayt' ] },
                            { name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'
                                     ,'Iframe' ] },
                                    '/',
                            { name: 'styles', items : [ 'Styles','Format' ] },
                            { name: 'basicstyles', items : ['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] },
                            { name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote' ] },
                            { name: 'links', items : [ 'Link','Unlink','Anchor' ] },
                            { name: 'tools', items : [ 'Maximize','-','About' ] }
                        ]
                    </f:facet>
                   </p:editor>
            </s:decorate>
          </h:panelGrid >

            <s:decorate template="layout/display.xhtml" rendered="false">
                <ui:define name="label">${'#'}{messages['mailing.signature_image']}</ui:define>
                <h:selectBooleanCheckbox value="${'#'}{${listName}.signatureImageYN}"/>
            </s:decorate>
            <s:decorate template="layout/display.xhtml">
                <h:outputText value="${'#'}{messages['mailing.signature_text']}"/>
                <h:selectBooleanCheckbox value="${'#'}{${listName}.signatureYN}"/>
                <h:inputTextarea cols="80" value="${'#'}{${listName}.signatureSource}" readonly="true" />
            </s:decorate>
            <s:decorate template="layout/display.xhtml">
                <h:outputText value="${'#'}{messages['mailing.unsubscribe']}"/>
                <h:selectBooleanCheckbox value="${'#'}{${listName}.unsubscribeYN}"/>
            </s:decorate>

                   
            <s:decorate template="layout/display.xhtml">
   <#-- Attachments image or text -->
   <p:panel toggleable="true" toggleableHeader="true" style="width: 100%;" header="${'#'}{messages['Attachment']}" switchType="client" collapsed="true"  
          leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
         <#-- allow fileupload blob and clob here to keep it simple and easier flow  -->
         <p:commandButton id="click" value="${'#'}{${homeName}.buttonPressedLabel}"  immediate="true"  execute="@this" action="${'#'}{${homeName}.makeButtonPressed}" render="click,uploadgridR"  bypassUpdates="true" />
         <h:panelGroup id="uploadgridR" >
           <h:panelGrid id="uploadgrid" columns="1" columnClasses="top,top" rendered = "${'#'}{${homeName}.buttonPressed}"  >
                 <o:inputFile id="w8xxuzdrbvxxxxxxxxxxdocmnto" value="#{file.lfiles}" multiple="true" 
                   accept="image/png,image/jp*,video/*,text/csv,.csv,text/comma-separated-values"/>
                 <h:commandButton value="Upload" action="#{file.fileUpload('clobblob')}"/>
         <br />
         <h:commandButton action="#{fpxxfq1a5xwwqqhxxxxxitemHome.clearUploadData}"
           value="#{messages['Clear']} #{messages['Uploaded']} #{messages['Data']}"
         rendered="#{not empty file.data}" />
         <o:graphicImage value="#{file.data}" dataURI="true" width="100" 
          rendered="#{not empty file.data}" />
         <p:panel rendered="#{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt.length() >2}">
          #{messages['Saved']}&nbsp;
          <img alt="image"
           src="/ImageServletCdi/?seq=#{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=FPXXFQ1A5XWWQQHXXXXXITEM&amp;qlf=1&amp;id=#{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt}&amp;height=100" >
          </img> 
         </p:panel>
           </h:panelGrid>
         </h:panelGroup>

         <#-- below show uploaded round robin saved attachments and allow selection  -->

     <p:panel>
        <f:facet name="header">${'#'}{messages['image']} / ${'#'}{messages['pdf']}</f:facet>
         <p:commandButton id="reload" image="/img/Reload16.png"
                          value="${'#'}{messages['reFresh']}" render="@form" />
        <h:panelGrid columns="1">
            <p:outputPanel id="panelp1" layout="block">
                <ui:repeat value="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataList.getAllResultListSeqs('blobdata','A3R-ATTACHMENT-1-C','PIC',0,'')}" var="row" iterationStatusVar="status"  rowKeyVar="ij" rows="5" id="repeatp1">
                    <p:panel style="float:left; width:${'#'}{identity.product=='s' and identity.subProduct=='b'  ?'700px':'150px'}; padding:5px; height:100px;">
                        <f:facet name="header">
                            <h:panelGroup>
                             <s:graphicImage alt="no picture"  rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata('blobdata','A3R-ATTACHMENT-1-C','PIC',row.a3xxexnsbvxxxxxxxxxxsequence) != null and row.a4xxexxxbvxxxxxxxxxxtype !='pdf'}"
                              value="${'#'}{row.b1xxuzbxbvxxxxxxxxxxdata}" >
                              <s:transformImageSize height="50" maintainRatio="true"/>
                             </s:graphicImage> 
                             <h:outputText value="PDF" style="font-weight:bold" rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.getBlobdata('blobdata','A3R-ATTACHMENT-1-C','PIC',row.a3xxexnsbvxxxxxxxxxxsequence) != null and row.a4xxexxxbvxxxxxxxxxxtype =='pdf'}"/>
                             <p:panel id="statusPI">
                             <h:outputText value="${'#'}{fn:substring(row.y3xxuxznbvxxxxxxxxxxnotes,0,20)}" style="font-weight:bold" />
                             <h:outputText value=" " />
                             <ui:remove> 
                             <h:outputText value="${'#'}{row.a3xxexnsbvxxxxxxxxxxsequence}" style="font-weight:bold" />
                             </ui:remove>
                             <h:selectBooleanCheckbox value="${'#'}{${listName}.checkMapI[ij+1]}"> 
                              <f:ajax event="click" execute="@form" render="@form" />
                             </h:selectBooleanCheckbox>
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
                    <p:panel style="float:left; width:${'#'}{identity.product=='s' and identity.subProduct=='b'  ?'700px':'150px'}; padding:5px; height:100px;">
                        <f:facet name="header">
                            <h:panelGroup>
                             <p:panel id="statusPT">
                             <h:inputTextarea readonly="true"  value="${'#'}{row.b1xxuzaxbvxxxxxxxxxxdata}" />
                             <h:outputText value="${'#'}{fn:substring(row.y3xxuxznbvxxxxxxxxxxnotes,0,20)}" style="font-weight:bold" />
                             <h:outputText value=" " />
                             <h:selectBooleanCheckbox value="${'#'}{${listName}.checkMapT[ij+1]}"> 
                              <f:ajax event="click" execute="@form" render="@form" />
                             </h:selectBooleanCheckbox>
                             </p:panel>
                            </h:panelGroup>
                        </f:facet>
                    </p:panel>
                </ui:repeat>
            </p:outputPanel>
        </h:panelGrid>

      </p:panel>
   </p:panel>

            </s:decorate>
          </h:panelGrid>

       </p:panel>
     <p:hotKey  onkeydown="${'#'}{p:element('mailingP')}.click();return false;" preventDefault="true" enabledInInput="true" key="return">
     </p:hotKey>


   </h:form>
             <p:status  >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:status>

    
</ui:define>

</ui:composition>

</#if>
