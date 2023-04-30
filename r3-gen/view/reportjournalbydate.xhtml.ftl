<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes2 = pojo.shortName?substring(0,eL)?upper_case>
<#if (menuAttributes2?substring(efS,efE) == '68') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">   
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign listName = componentName + "List">
<#assign homeName = componentName + "Home">
<#assign pageName = entityName>
<#assign editPageName = entityName + "Edit">
<#assign listPageName = "Reportjournalbydate">
<#assign menuPageName = "home">
<#assign reportName = "reportName">
<#assign displayAs = "displayAs">
<#assign start = "start">
<#assign end = "end">
<#assign markedOnes = "markedOnes">    
<#assign targetId = "targetId">   
<#assign useDateKey="">
<#assign useDateKeyField="">


 

<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:p="http://primefaces.org/ui"
                template="layout/rtemplate.xhtml">
<f:metadata>
    <f:viewAction action="${'#'}{${homeName}.restrict()}" />
</f:metadata>
                       
<ui:define name="body">
    <h:form id="${componentName}Report" styleClass="edit">
     <h:outputStylesheet>

     </h:outputStylesheet>
	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
              <h:commandButton id="printb" value="Print"  action="${'#'}{${listName}.print}" image="/img/Print16.gif" />
	  </p:toolbarGroup>
	  <p:toolbarGroup>
              <h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end" outcome="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{custoIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> >
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['reportjournalbydateHelp']!=null}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['reportjournalbydateHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
       <h:messages globalOnly="true" styleClass="message" id="globalMessages"/>
	</p:toolbar>
         <p:panel style="width: 20%;" header="${'#'}{messages['${entityName?substring(eL)?cap_first}']} Reports using default parameters          (Use the Browser back button after viewing or have multiple browser windows open)  " switchType="ajax" expanded="true"
          leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
           <h:panelGrid columns="1">
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['report.reportName']}</ui:define>
                <h:selectOneMenu id="${reportName}" value="${'#'}{${listName}.${reportName}}">
                 <f:selectItem id="ritem1" itemLabel="Journal By Date" itemValue="fiJournalbydatereport" />
                </h:selectOneMenu> 

            </ui:decorate>
           </h:panelGrid>
        </p:panel>
         <p:panel style="width: 30%;" header="Click to show Report details parameters" switchType="ajax" expanded="false"
          leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">

        <h:panelGrid columns="2">
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['report.displayAs']}</ui:define>
                <h:selectOneMenu id="${displayAs}" value="${'#'}{${listName}.${displayAs}}">
                 <f:selectItem id="ditem1" itemLabel="PDF" itemValue="PDF" />
                 <f:selectItem id="ditem2" itemLabel="HTML" itemValue="HTML" />
                 <f:selectItem id="ditem3" itemLabel="CSV" itemValue="CSV" />
                 <f:selectItem id="ditem4" itemLabel="EXCEL" itemValue="EXCEL" />
                </h:selectOneMenu> 
            </ui:decorate>
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['report.markedOnes']}</ui:define>
                <h:inputText id="${markedOnes}" value="${'#'}{${listName}.${markedOnes}}"/>
            </ui:decorate>
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['report.targetId']}</ui:define>
                <h:selectOneMenu id="${targetId}" value="${'#'}{${listName}.${targetId}}">
                 <f:selectItem id="titem1" itemLabel="None" itemValue="None" />
                 <f:selectItem id="titem2" itemLabel="DownLoad" itemValue="DownLoad" />
                 <f:selectItem id="titem3" itemLabel="Archive" itemValue="Archive" />
                </h:selectOneMenu> 

            </ui:decorate>
        </h:panelGrid>
       </p:panel>
        <div class="actionButtons">
         <h:panelGrid columns="8">      
            <h:commandButton id="report" value="Generate Report" styleClass="buttonMain"  onclick="this.form.target='_blank'"  action="${'#'}{${listName}.print}"/>

        <h:button outcome="/${'#'}{empty ${componentName}From ? '${menuPageName}' : ${componentName}From}.xhtml"
                    id="done"
                 value="Done"/>
            <f:param name="reportName" value="${'#'}{${listName}.${reportName}}"/>
            <f:param name="displayAs" value="${'#'}{${listName}.${displayAs}}" /> 
            ${'#'}{messages['Start']}&nbsp;<h:graphicImage value="/img/report_start16.png" />
            <h:panelGrid columns="2">
                   <ui:remove>gets whole entities via resultlist, so a limit of 2000 is put in, control via start/end 
                              order by seq(s), start/end by keyfields ie seq(s) we need to use integer value ie seq
                              so that 152 (15-2) comes after 2-1 (21)    
                   </ui:remove>
                 <h:selectOneMenu  value="${'#'}{${listName}.start}" >
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${listName}.getSuggestList(${homeName}.prefix)}" var="result"
                   itemValue="${'#'}{result.b5cczjsibvxxxxxxxxxxjnlseq}" itemLabel="${'#'}{result.b6xxzkjsbvxxxxxxxxxxjnlseqs}  ( ${'#'}{result.b1xxcjpdhvxxxxxxxxxxpostdate} )" />
                 </h:selectOneMenu>
            </h:panelGrid>
            ${'#'}{messages['End']}&nbsp;<h:graphicImage value="/img/report_stop16.png" />
            <h:panelGrid columns="2">
                 <h:selectOneMenu  value="${'#'}{${listName}.end}" >
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${listName}.getSuggestList(${homeName}.prefix)}" var="result"
                   itemValue="${'#'}{result.b5cczjsibvxxxxxxxxxxjnlseq}" itemLabel="${'#'}{result.b6xxzkjsbvxxxxxxxxxxjnlseqs}  ( ${'#'}{result.b1xxcjpdhvxxxxxxxxxxpostdate} )" />
                 </h:selectOneMenu>
            </h:panelGrid>
         </h:panelGrid>      
        </div>
        
    
    <p:panel>
        <f:facet name="header">${entityName?substring(eL)?cap_first} search results</f:facet>
    <div class="results" id="${componentName}List">

    <h:outputText value="No ${componentName} exists" 
               rendered="${'#'}{empty ${listName}.resultList}"/>
               
    <p:dataTable id="${listName}" frozenColumns="2" resizableColumns="true" tableStyle="table-layout:auto;"  scrollable="false" scrollWidth="100%" 

                var="${componentName}"
              value="${'#'}{${listName}.resultList}" 
           rendered="${'#'}{not empty ${listName}.resultList}">
           <#assign loop =0 >
           <#if c2j.isComponent(pojo.identifierProperty)>
            <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
             <#if loop = 0>
              <#assign selectParam = componentName+'.'+ pojo.identifierProperty.name+'.'+componentProperty.name>
              <#assign loop =1 >
             </#if>
             <#if useDateKeyField != "">
              <#assign selectParam = componentName+'.'+ pojo.identifierProperty.name+'.'+useDateKeyField>
             </#if>
            </#foreach> 
           <#else>
            <#assign selectParam = componentName +'.'+pojo.identifierProperty.name>
           </#if>

        <p:column>
          <f:facet name="header">Select</f:facet>
          <h:commandButton id="SelectStart" value="Start"  action="${'#'}{${listName}.setStart(${selectParam})}"/>
        </p:column>

        <p:column>
          <f:facet name="header">Select</f:facet>
          <h:commandButton id="SelectEnd" value="End"  action="${'#'}{${listName}.setEnd(${selectParam})}"/>
        </p:column>

<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if pojo.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
        <p:column>
            <f:facet name="header">${'#'}{messages['${componentProperty.name?substring(pL)?cap_first}']}</f:facet>
            ${'#'}{${componentName}.${property.name}.${componentProperty.name}}
        </p:column>
   </#foreach>
  <#else>
       <#if ( ((property.name?substring(pfS,pfE)!="za") && (property.name?substring(pfS,pfE)!="zb") && (property.name?substring(pfS,pfE)!="zd") && (property.name?substring(pfS,pfE)!="zf") && (property.name?substring(pfS,pfE)!="zt")) && ((property.name?substring(0,1) == "y") || (property.name?substring(0,1) == "z" )
        || (property.name?substring(0,6) == "a0xxuo" ) ) )   >
        <#-- ${property.name}-->
       <#else>
        <p:column>
            <f:facet name="header">
                <h:link styleClass="columnHeader"
                             value="${property.name?substring(pL)} ${'#'}{${listName}.order=='${property.name} asc' ? messages.down : ( ${listName}.order=='${property.name} desc' ? messages.up : '' )}">
                    <f:param name="order" value="${'#'}{${listName}.order=='${property.name} asc' ? '${property.name} desc' : '${property.name} asc'}"/>
                </h:link>
            </f:facet>
            ${'#'}{${componentName}.${property.name}}
        </p:column>
       </#if>
 </#if>
</#if>
<#if c2h.isManyToOne(property)>
<#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
<#if parentPojo.isComponent(parentPojo.identifierProperty)>
<#foreach componentProperty in parentPojo.identifierProperty.value.propertyIterator>
        <p:column>
            <f:facet name="header">
<#assign propertyPath = property.name + '.' + parentPojo.identifierProperty.name + '.' + componentProperty.name>
                <h:link styleClass="columnHeader"
                             value="${property.name?substring(eL)} ${componentProperty.name?substring(pL)} ${'#'}{${listName}.order=='${propertyPath} asc' ? messages.down : ( ${listName}.order=='${propertyPath} desc' ? messages.up : '' )}">
                    <f:param name="order" value="${'#'}{${listName}.order=='${propertyPath} asc' ? '${propertyPath} desc' : '${propertyPath} asc'}"/>
                </h:link>
            </f:facet>
            ${'#'}{${componentName}.${propertyPath}}
        </p:column>
</#foreach>
<#else>
        <p:column>
            <f:facet name="header">
<#assign propertyPath = property.name + '.' + parentPojo.identifierProperty.name>
                <h:link styleClass="columnHeader"
                             value="${property.name?substring(eL)} ${parentPojo.identifierProperty.name?substring(pL)} ${'#'}{${listName}.order=='${propertyPath} asc' ? messages.down : ( ${listName}.order=='${propertyPath} desc' ? messages.up : '' )}">
                    <f:param name="order" value="${'#'}{${listName}.order=='${propertyPath} asc' ? '${propertyPath} desc' : '${propertyPath} asc'}"/>
                </h:link>
            </f:facet>
            ${'#'}{${componentName}.${propertyPath}}
        </p:column>
</#if>
</#if>
</#foreach>
        <p:column>
            <f:facet name="header">action</f:facet>
            <h:link outcome="/${'#'}{empty from ? '${pageName}' : from}.xhtml" 
                   value="Select" 
                      id="${componentName}">
<#if pojo.isComponent(pojo.identifierProperty)>
<#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${util.upper(componentProperty.name)}" 
                        value="${'#'}{${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
</#foreach>
<#else>
                <f:param name="${componentName}${util.upper(pojo.identifierProperty.name)}" 
                        value="${'#'}{${componentName}.${pojo.identifierProperty.name}}"/>
</#if>
            </h:link>
        </p:column>
    </p:dataTable>

    </div>
    </p:panel>
    
    <div class="tableControl">
      
        <h:link outcome="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.previousExists}" 
               value="${'#'}{messages.left}${'#'}{messages.left} First Page"
                  id="firstPage">
          <f:param name="firstResult" value="0"/>
        </h:link>
        
        <h:link outcome="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.previousExists}" 
               value="${'#'}{messages.left} Previous Page"
                  id="previousPage">
            <f:param name="firstResult" 
                    value="${'#'}{${listName}.previousFirstResult}"/>
        </h:link>
        
        <h:link outcome="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.nextExists}" 
               value="Next Page ${'#'}{messages.right}"
                  id="nextPage">
            <f:param name="firstResult" 
                    value="${'#'}{${listName}.nextFirstResult}"/>
        </h:link>
        
        <h:link outcome="/${listPageName}.xhtml" 
            rendered="${'#'}{${listName}.nextExists}" 
               value="Last Page ${'#'}{messages.right}${'#'}{messages.right}"
                  id="lastPage">
            <f:param name="firstResult" 
                    value="${'#'}{${listName}.lastFirstResult}"/>
        </h:link>
        
    </div>
    
    </h:form>
    
</ui:define>

</ui:composition>
</#if>
</#if>

