<#assign generateCandidate = "N">  
<#include "../util/TypeInfo.ftl">
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign generateCandidate = "Y">  
</#if>
<#if generateCandidate == "Y">                       
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign variation = "${variation}">  
<#assign entityName = pojo.shortName>
<#--maE=4 efS=6 efE=8 efS2=7 -->
<#assign menuAttributesFunction = entityName?substring(efS,efE)>
<#assign componentName = entityName?uncap_first>
<#assign listName = componentName + "List">
<#assign pageName = entityName?substring(eL)>
<#assign editPageName = entityName?substring(eL) + "Edit">
<#assign listPageName = entityName?substring(eL) + "List">
<#assign menuPageName = "home">
<#assign reportName = "reportName">
<#assign displayAs = "displayAs">
<#assign start = "start">
<#assign end = "end">
<#assign markedOnes = "markedOnes">    
<#assign targetId = "targetId">    
<#assign homeName = componentName +  "Home">
<#assign statusFlagField="">
<#assign parentKeyName =  "not assigned" >
<#assign parentDescriptName =  "not assigned" >
<#assign keyAutoGen="Y">
<#assign rowEditType="">
<#assign foreignKeyName="">
<#assign documentField="">
<#assign keyfromsubkeys = "N">
<#assign renderP = "">
<#assign cIndex=0>
<#assign colIndex=0>
<#assign nameTip="">
<#assign ticketTip="">
<#assign poTip="">
<#assign skipcolEnd="n">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:ph="http://xmlns.jcp.org/jsf/passthrough"
    xmlns:p="http://primefaces.org/ui"
    template="layout/rtemplate.xhtml">
<f:metadata>
  <#assign idName = componentName + util.upper(pojo.identifierProperty.name)>
   <#if c2j.isComponent(pojo.identifierProperty)>
    <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
     <#assign cidName = componentName + util.upper(componentProperty.name)>
     <f:viewParam name="${cidName}" value="${'#'}{${homeName}.${idName}.${componentProperty.name}}"/>
    </#foreach>
   <#else>
    <f:viewParam name="${idName}" value="${'#'}{${homeName}.${idName}}"/>
   </#if>
    <f:viewParam name="firstResult"
                    value="${'#'}{${listName}.firstResult}"/>
    <f:viewParam name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
    <f:viewAction action="${'#'}{${homeName}.restrict()}" />

</f:metadata>
<ui:define name="title">${'#'}{customIdentity.owner2} webpage to list ${'#'}{messages['${entityName?substring(pL)?cap_first}']}</ui:define>

<ui:define name="body">
    
    <h:form id="${componentName}Search" styleClass="edit">
<h:outputStylesheet>
</h:outputStylesheet>
    <script type="text/javascript" src="./js/eval.js"></script>
	<p:toolbar height="26" itemSeparator="grid">
      <#if (menuAttributesFunction?contains("1a") || menuAttributesFunction?contains("18") ) >
	  <p:toolbarGroup>
              <h:button id="${componentName}TreeViewId"  value="${'#'}{messages['tree']} ${'#'}{messages['view']}"  outcome="/${pageName}Tree.xhtml" />
	  </p:toolbarGroup>
      </#if>
	  <p:toolbarGroup>
              <h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="${'#'}{messages['home']}" propagation="end"  outcome="/home.xhtml" />
             <p:ajaxStatus name="buttonStatus">
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{customIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['${componentName?substring(eL)?cap_first}ListHelp']!='${componentName?substring(eL)?cap_first}ListHelp'}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['${componentName?substring(eL)?cap_first}ListHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
       <h:messages globalOnly="true" style = "color:red;margin:8px;" styleClass="message" id="globalMessages"/>
	</p:toolbar>
        <#if menuAttributesFunction ="1b" >
	<p:toolbar >
	  <p:toolbarGroup location="right">
            <h:commandButton  styleClass="buttonMain"
                          value="${'#'}{messages['refresh']} ${'#'}{messages['sales']} ${'#'}{messages['data']}" 
                         action="${'#'}{${usagebyperiodsEntityName}Home.loadSalesData()}"
                       disabled="${'#'}{${usagebyperiodsEntityName}Home.managed}"
                       rendered="${'#'}{(!${usagebyperiodsEntityName}Home.managed or ${usagebyperiodsEntityName}Home.moreActive) and !${usagebyperiodsEntityName}Home.entityDeleted}">  
            </h:commandButton>    
	 <h:graphicImage id="Tel" value="/img/salesChart100x200.jpg" styleClass="pic" />
	  </p:toolbarGroup>
	</p:toolbar>
        </#if>                            			  


<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if property.name?substring(pfS,pfE)=="zf"> 
      <#assign statusFlagField=property.name>
 </#if>   
 <#if property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="zb" || property.name?substring(5,7)=="za"  > 
      <#assign documentField=property.name>
 </#if>  
 <#if property.name?substring(pkS,pkE)=="s" | (property.name?substring(pkS,pkE)=="2" && property.name?substring(pkS,7)!="2o" ) | property.name?substring(pkS,pkE)=="3"
     | property.name?substring(pkS,pkE)=="4" | property.name?substring(pkS,pkE)=="5">
  <#if keyfromsubkeys="N">
   <#-- ${property.name} -->
   <#assign keyfromsubkeys="Y">
  </#if>
 </#if>
</#if> 
</#foreach>

        <#if (menuAttributesFunction =="20")>
        <p:panel style="width: 50%;" header="${'#'}{messages['Call']}- ${'#'}{messages['List']}" switchType="ajax" collapsed="true"
         toggleable="true" toggleableHeader="true">
        <div class="actionButtons">
         <h:commandButton id="calllgraphs" value="${'#'}{messages['generate']} ${'#'}{messages['call']} ${'#'}{messages['list']}" 
           action="${'#'}{${customerEntityName}Home.doGraphCalls()}"/>
	 <h:graphicImage id="Tel" value="/img/telephone-icon200.jpg" styleClass="pic" />

        <h:panelGrid columns="2">
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['Calls_per_day_per_caller']}</ui:define>
         <p:spinner 
                          value="${'#'}{${homeName}.maxCallsPerDay}"
                           inputSize="2"
                           step="1">
         </p:spinner>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['How_many_callers']}</ui:define>
         <p:spinner 
                          value="${'#'}{${homeName}.howManyCallers}"
                           inputSize="2"
                           step="1">
         </p:spinner>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['Target_by']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.targetBy}" >
				<f:selectItem  
                         itemLabel="DemoGraphy"
                         itemValue="D" /> 
				<f:selectItem  
                         itemLabel="Bio"
                         itemValue="B" /> 
				<f:selectItem  
                         itemLabel="CampaignCode"
                         itemValue="C" /> 
         </h:selectOneRadio>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['Override_list']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.overrideCallList}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>
        </h:panelGrid>


       </div>
        </p:panel>
         &nbsp;<h:button id="tocall" value="${'#'}{messages['Sales']} ${'#'}{messages['Call']} ${'#'}{messages['List']}"  outcome="/${pageName}Fcal.xhtml?faces-redirect=true">
          <f:param name="from" value="${entityName}List"/>
         </h:button>

        </#if>

<#if (entityName?length > 8)>
 <p:panel style="width: 50%;" header="${'#'}{messages['${entityName?substring(eL)?cap_first}']}- ${'#'}{messages['List']} ${'#'}{messages['Search']} ${'#'}{messages['Result']}, ${'#'}{messages['click']} ${'#'}{messages['to']} ${'#'}{messages['change']} ${'#'}{messages['search']}  ${'#'}{messages['criteria']}" switchType="ajax" collapsed="true"
     toggleable="true" toggleableHeader="true">

</#if>
<#--  search value is entered here and will be seached against 3 properties. The 3 property names
      will be selected in backing bean depending on entity type and would be key,subkeys or descript or amount
      etc and will be used in resultList where clause. descript covers key,statusdt(today) covers subkey
      so changed to [descript,notes],statusfldt string and amount string
-->
<h:panelGrid columns="20">
 <ui:decorate template="layout/display.xhtml">
  <ui:define name="label">${'#'}{messages['search']} ${'#'}{messages['string']} </ui:define>
  <h:inputText id="searchV" value="${'#'}{${listName}.searchVal}"/>
 </ui:decorate>
  <h:outputText id="searchVJ" value="${'#'}{${listName}.searchValJ}" rendered="${'#'}{${listName}.searchVal.isEmpty()}"/>

 <ui:decorate template="layout/display.xhtml">
  <ui:define name="label">${'#'}{messages['search']} ${'#'}{messages['date']} ${'#'}{messages['from']} </ui:define>
  <h:inputText id="toDay" ph:type="date" value="${'#'}{${listName}.searchDate}" >
  <f:convertDateTime pattern="yyyy-MM-dd"/>  </h:inputText>
 </ui:decorate>
 <h:commandButton id="setToday" render="toDay" value="${'#'}{messages['set']} ${'#'}{messages['Today']}"   action="${'#'}{${listName}.setSearchDate(${homeName}.currentTime)}" />

 <#if statusFlagField != "">
 <ui:decorate template="layout/display.xhtml">
  <ui:define name="label"> ${'#'}{messages['status']}  </ui:define>
  <h:panelGrid columns="2" >
         <h:selectOneMenu value="${'#'}{${listName}.searchStatus}"> 
          <f:selectItem itemLabel="all" itemValue="${'#'}{null}"/>
          <f:selectItem itemLabel="open" itemValue="0"/>
          <f:selectItem itemLabel="active/ordered" itemValue="1"/>
          <#if menuAttributesFunction?contains("56")>
           <f:selectItem itemLabel="incomplete SignUps" itemValue="-2"/>
           <f:selectItem itemLabel="dropOut Users" itemValue="-1"/>
           <f:selectItem itemLabel="inActive Users" itemValue="-3"/>
          <#else>
           <f:selectItem itemLabel="return" itemValue="4"/>
          </#if>
          <f:selectItem itemLabel="closed" itemValue="8"/>
          <#if menuAttributesFunction?contains("56")>
           <f:selectItem itemLabel="Recent Logins" itemValue="-4"/>
          <#else>
           <f:selectItem itemLabel="paid" itemValue="16"/>
           <f:selectItem itemLabel="partial/shipped" itemValue="32"/>
           <f:selectItem itemLabel="printed/final approved" itemValue="512"/>
          </#if>
          <#if menuAttributesFunction?contains("23") || menuAttributesFunction?contains("24") || menuAttributesFunction?contains("25") || menuAttributesFunction?contains("26")>
           <f:selectItem itemLabel="invoiced" itemValue="64"/>
          <#elseif menuAttributesFunction?contains("20") || menuAttributesFunction?contains("30") || menuAttributesFunction?contains("40")>
           <f:selectItem itemLabel="unsubscribed" itemValue="64"/>
          </#if>
          <f:selectItem itemLabel="marked" itemValue="128"/>
          <f:selectItem itemLabel="deleted" itemValue="256"/>
         </h:selectOneMenu>
  </h:panelGrid>
 </ui:decorate>
 </#if>
</h:panelGrid>

  <#if menuAttributesFunction?contains("1a")>
 <ui:decorate template="layout/display.xhtml">
  <ui:define name="label"> ${'#'}{messages['Type']}  </ui:define>
  <h:panelGrid columns="2" >
         <h:selectOneMenu value="${'#'}{${listName}.searchType}"> 
          <f:selectItem itemLabel="all" itemValue="${'#'}{null}"/>
          <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getoptionsFieldList('1a',16)}"  var="babu"  
          itemLabel="${'#'}{babu.key}"
          itemValue="${'#'}{babu.value}"
         /> 
        </h:selectOneMenu>
   </h:panelGrid>
 </ui:decorate>
  </#if>
  <#if menuAttributesFunction?contains("24")>
 <ui:decorate template="layout/display.xhtml">
  <ui:define name="label"> ${'#'}{messages['Type']}  </ui:define>
  <h:panelGrid columns="2" >
         <h:selectOneMenu value="${'#'}{${listName}.searchType}"> 
          <f:selectItem itemLabel="all" itemValue="${'#'}{null}"/>
          <f:selectItem itemLabel="Case" itemValue="basket"/>
          <f:selectItem itemLabel="Shopping" itemValue="cart"/>
        </h:selectOneMenu>
   </h:panelGrid>
 </ui:decorate>
  </#if>


<h:panelGrid columns="8">
          <f:facet name="header">${'#'}{messages['Search_Range']}
          </f:facet>   
          <h:graphicImage value="/img/Resultset_first16.png" />
<#--         for item do not use suggest since it filters entries like no closed  and start / end uses keylist which does not filter  give more thought -->
<#--         suggest may need more params to make it suitable ,resource needs keylist to include SYSTEMS   -->
            <h:panelGrid columns="2">
                 <h:selectOneMenu  value="${'#'}{${listName}.start}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <#if (menuAttributesFunction?contains("1a"))>
                   <f:selectItems value="${'#'}{${listName}.get${entityName?substring(10)}KeyList()}" var="result"
                    itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                  <#elseif (menuAttributesFunction?contains("57"))>
                    <f:selectItems value="${'#'}{${listName}.getSuggestList('*')}" var="result"
                     itemValue="${'#'}{result.yxxxuh566xwwqqwxxxxxuser.a0xxukuxbvxxxxxxxxxxid}" itemLabel="${'#'}{result.yxxxuh566xwwqqwxxxxxuser.a0xxukuxbvxxxxxxxxxxid}" />
                  <#else>
                   <#if (menuAttributesFunction?contains("1r") ) >
                    <f:selectItems value="${'#'}{${listName}.get${entityName?substring(10)}KeyList()}" var="result"
                     itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                   <#else>
                    <f:selectItems value="${'#'}{${listName}.suggest(${homeName}.prefix)}" var="result"
                     itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                   </#if>
                  </#if>  
                 </h:selectOneMenu>
            </h:panelGrid>
            <h:graphicImage value="/img/Resultset_last16.png" />
            <h:panelGrid columns="2">
                 <h:selectOneMenu  value="${'#'}{${listName}.end}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <#if (menuAttributesFunction?contains("1a"))>
                   <f:selectItems value="${'#'}{${listName}.get${entityName?substring(10)}KeyList()}" var="result"
                    itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                  <#elseif (menuAttributesFunction?contains("57"))>
                    <f:selectItems value="${'#'}{${listName}.getSuggestList('*')}" var="result"
                     itemValue="${'#'}{result.yxxxuh566xwwqqwxxxxxuser.a0xxukuxbvxxxxxxxxxxid}" itemLabel="${'#'}{result.yxxxuh566xwwqqwxxxxxuser.a0xxukuxbvxxxxxxxxxxid}" />
                  <#elseif (menuAttributesFunction?contains("1r") ) >
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
 actionListener is needed to reorder the searched list to show first
 p:commandButton does not resubmit like h:commandButton, so for ajax we need to render the datatable
 a4j was supposed to speed up but needed render datatable went back to h:command. revisit 
-->
            <h:commandButton id="search" render="${listName},globalMessages" status="buttonStatus" value="${'#'}{messages['Search']}" 
              actionListener="${'#'}{${listName}.getFirstResult()}" rendered="${'#'}{${listName}.maxResultsVal lt 49}"/>
            &nbsp;<h:button id="reset" value="${'#'}{messages['Reset']}"  includePageParams="false"/>
        </div>

</p:panel>

    <p:panel>

        <div class="actionButtons">
            <#if statusFlagField != "">
<#--
  in jsf ui:remove is for comment
             <h:commandButton id="markt" value="Mark These"  action="${'#'}{${homeName}.markAll()}"/>
             <h:commandButton id="unmarkt" value="UnMark "  action="${'#'}{${homeName}.unmarkAll()}"/>
-->
            <#-- removed undone, row var assumes whole table, need to get firstResult value
             viewscope instead of requestscope fixed the issue
            -->
             <h:commandButton id="copyallt" value="Copy All Flagged"  action="${'#'}{${homeName}.copyAllMarked()}" 
                rendered="${'#'}{!yxxxuh566xwwqqwxxxxxuserHome.mobile and ${listName}.maxResultsVal lt 49}" status="buttonStatus"/>
             <p:ajaxStatus name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
             <h:commandButton id="deleteallt" value="${'#'}{messages['Delete']} ${'#'}{messages['All']} ${'#'}{messages['Flagged']}"  action="${'#'}{${homeName}.deleteAllFlagged()}"
              onclick="if (! confirm('Really delete ?') ) { return false;}; return true; " rendered="${'#'}{!yxxxuh566xwwqqwxxxxxuserHome.mobile and ${listName}.maxResultsVal lt 49}">
               <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Deletes']} ${'#'}{messages['detail']} ${'#'}{messages['records']} ${'#'}{messages['as-well']},${'#'}{messages['but']} ${'#'}{messages['not']} ${'#'}{messages['all']} ${'#'}{messages['constraints']}"/></span> </p:tooltip> 
             </h:commandButton>
             <#-- checked entity was not picking up changes, even with ajax needs more trying out, use row edit -->
           <#-- ical may be for schedule only and need to finish logic for write
            -->
             <h:commandButton id="updateallt" value="Update All Flagged"  rendered="false" action="${'#'}{${homeName}.updateAllFlagged()}" />
             <h:commandButton id="emailIcal" value="${'#'}{messages['email']} ${'#'}{messages['as']} ${'#'}{messages['iCalendar']}"  rendered="false" action="${'#'}{${homeName}.writeAsIcalText()}"/>

            </#if>
            <#if (componentName=="nxxxiha1rgenapp")>   
             <h:commandButton id="Genapp" value="Define APP .. Gen EAR(WAR)"  action="${'#'}{${homeName}.genApp()}"/>
            </#if>
            <#if (componentName=="nxxxiha2rgendb")>   
             <h:commandButton id="Gendb" value="Define and Create APP DB schema"  action="${'#'}{${homeName}.genDb()}"/>
             <h:commandButton id="Genrx" value="Define and Create APP Table and Flds"  action="${'#'}{${homeName}.genRXGSCT()}"/>
            </#if>
            <#if (componentName=="nxxxiha3rgentable")>   
             <h:commandButton id="Gentables" value="Define and Create App Tables"  action="${'#'}{${homeName}.genRXGSCT()}"/>
            </#if>
            <#if (componentName=="yxxxuq62divisiondates")>   
             <h:commandButton id="Rolldivdates" value="Year End Process"  action="${'#'}{${homeName}.yearEndProcess()}"/>
            </#if>
            <h:button outcome="/${'#'}{empty ${componentName}From ? '${menuPageName}' : ${componentName}From}.xhtml"
                    id="done"
                 value="Done"/>
             <ui:remove>  do not render list page once > 50 rows  to avoid excedding max http params </ui:remove>
             <h:outputText value="${'#'}{messages['show']}"/>
             <h:commandButton id="maxrows6" value="6 ${'#'}{messages['rows']}"  action="${'#'}{${listName}.setMaxResultsVal(6)}" rendered="${'#'}{${listName}.maxResultsVal lt 49}"/>
             <h:commandButton id="maxrows5" value="50 ${'#'}{messages['rows']}"  action="${'#'}{${listName}.setMaxResultsVal(50)}" rendered="${'#'}{!yxxxuh566xwwqqwxxxxxuserHome.mobile and ${listName}.maxResultsVal lt 49}"/>
             <h:commandButton id="maxrows1" value="100 ${'#'}{messages['rows']}"  action="${'#'}{${listName}.setMaxResultsVal(100)}" rendered="${'#'}{!yxxxuh566xwwqqwxxxxxuserHome.mobile and ${listName}.maxResultsVal lt 49}"/>
             <h:outputText value="${'#'}{messages['show']}"/>
             <h:commandButton id="skipC" value="${'#'}{messages['skip']} ${'#'}{messages['columns']}"  action="${'#'}{${listName}.setskipColumns(true)}" rendered="${'#'}{${listName}.maxResultsVal lt 49}"/>
             <h:commandButton id="resetC" value="${'#'}{messages['reset']} ${'#'}{messages['columns']}"  action="${'#'}{${listName}.setskipColumns(false)}" rendered="${'#'}{${listName}.maxResultsVal lt 49}"/>

        </div>

        <f:facet name="header">
         <h:outputText rendered="${'#'}{!(ity.hasRole('VQ') || customIdentity.hasRole('VW'))}" value="${entityName?substring(eL)?cap_first} Search Results showing ${'#'}{empty ${listName}.resultList ? 0 : (${listName}.paginated ? ${listName}.resultList.size() : ${listName}.resultCount)} of ${'#'}{${listName}.resultCount}"/>
        </f:facet>
    <div class="results" id="${componentName}List" style="overflow-x:auto">

    <h:outputText value="The ${componentName?substring(eL)?cap_first} search returned no results."
               rendered="${'#'}{empty ${listName}.resultList}"/>

            <#if menuAttributesFunction ="5a" >
           <ui:remove>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.selectedClass}" 
              rendered="true">
              <p:ajax  update="gClN" bypassUpdates="false"/>
	      <f:selectItems value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.getClassNames('all')}"   /> 
             </h:selectOneMenu>
             </h:panelGrid>
             <p:commandButton id="columnN" styleClass="buttonMain" 
                          value="${'#'}{messages['show']} ${'#'}{messages['column']} ${'#'}{messages['names']}" status="buttonStatus"                           render="@form"
                         action=
"${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.mapColumnNames(yxxxch5a1xhhxxhxxxxxtruefalseHome.instance.a0xxukrdbvxxxxxxxxxxtablename,true,false)}"
                       disabled="${'#'}{!yxxxch5a1xhhxxhxxxxxtruefalseHome.wired}"
                       rendered="${'#'}{!yxxxch5a1xhhxxhxxxxxtruefalseHome.managed  and !yxxxch5a1xhhxxhxxxxxtruefalseHome.entityDeleted}">  >
             </p:commandButton>   
           </ui:remove>

            </#if>

    <#if menuAttributesFunction?contains("1s")>
    <p:panel id="stage" style="text-align:center;align-content:center;width:90%;height:50px;${'#'}{a4jSkin.generalBackgroundColor} !important; ">
     <h:outputText value="|||||| STAGE ||||||" style="color:black;"/>
    </p:panel>
    </#if>


    <p:dataTable id="${listName}"  frozenColumns="2" resizableColumns="true" tableStyle="table-layout:auto;"  scrollable="false" scrollWidth="100%" rows="${'#'}{${listName}.maxResultsVal}" scrollRows="6"
           var="_${componentName}" selection="${'#'}{${homeName}.yxxxuq1m1xwwqqqxxxxxclobdataA0xxuobxbxxxxxxxxxxxsid}" rowKey="${'#'}{_${componentName}.a0xxuobxbxxxxxxxxxxxsid}"
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
        <#if statusFlagField != "">
        <#if menuAttributesFunction?contains("1s") || menuAttributesFunction?contains("5b")>
         <p:column >
        <#else>
         <p:column headerText="Action">
        </#if>
          <#--
            selectionMode not working, using custom solution checked[...
          -->
            <h:selectBooleanCheckbox id="MarkItCheckbox" value="${'#'}{${homeName}.checked[_${componentName}.a0xxuobxbxxxxxxxxxxxsid]}"/>
            <p:column selectionMode="multiple" style="width:16px;text-align:center"/>
            <h:link outcome="/${'#'}{empty from ? '${pageName}' : from}.xhtml"
                   value="${'#'}{empty from ? 'View' : 'Select'}"
                   propagation="${'#'}{empty from ? 'none' : 'default'}"
                      id="${componentName}ViewId">
             <#if pojo.isComponent(pojo.identifierProperty)>
              <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${componentProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
              </#foreach>
             <#else>
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}}"/>
             </#if>
            </h:link>
            ${'#'}{' '}
            <#if menuAttributesFunction?contains("52")>
             <h:link outcome="/${editPageName}Easy.xhtml"
            <#else>
             <h:link outcome="/${editPageName}.xhtml"
            </#if>
                   value="Edit"
             propagation="none"
                      id="${componentName}Edit1"
             <#if menuAttributesFunction?contains("56")>
                rendered="${'#'}{empty from and (customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ') || customIdentity.hasRole('VW'))}">
             <#else>
                rendered="${'#'}{empty from and (customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('PH') ||customIdentity.hasRole('SH') ||customIdentity.hasRole('EH') 
                  || (customIdentity.hasRole('VH') ||customIdentity.hasRole('VQ')
                  and customIdentity.product =='f' and customIdentity.subProduct =='s') )}">
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
             <#if menuAttributesFunction?contains("23") || menuAttributesFunction?contains("24") || menuAttributesFunction?contains("25") || menuAttributesFunction?contains("26")>
                <f:param name="${itemEntityName}A0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{_${componentName}.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid}"/>
                <f:param name="${customerEntityName}A0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{_${componentName}.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid}"/>
             </#if>
            </h:link>
           <#if menuAttributesFunction?contains("1s")>
            ${'#'}{' '}
            <h:link outcome="/seatAllocateEdit.xhtml"
                   value="${'#'}{messages['Assign']} ${'#'}{messages['Seat']}"
             propagation="none"
                      id="${componentName}EditA"
                rendered="${'#'}{empty from and (customIdentity.hasRole('UH') ||customIdentity.hasRole('UQ'))}">
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}}"/>
            </h:link>
           </#if>
           <#if menuAttributesFunction?contains("5b")>
            ${'#'}{' '}
            <h:link outcome="/importMappingEdit.xhtml"
                   value="${'#'}{messages['Map']} ${'#'}{messages['Column']}"
             propagation="none"
                      id="${componentName}EditA"
                rendered="${'#'}{empty from and (customIdentity.hasRole('UH') ||customIdentity.hasRole('UQ') 
                  and customIdentity.product =='o')}">
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}}"/>
            </h:link>
           </#if>
        <#-- 
           <#if documentField != "" >
            <#if menuAttributesFunction =="1m" || menuAttributesFunction =="1n">
            <h:link outcome="/${'#'}{empty from ? '${pageName}' : from}.xhtml" rendered="${'#'}{empty from and _${componentName}.${documentField} !=null}"
                   propagation="${'#'}{empty from ? 'none' : 'default'}"
                      id="${componentName}DownLoad">
             <#if pojo.isComponent(pojo.identifierProperty)>
              <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${componentProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
              </#foreach>
             <#else>
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}}"/>
             </#if>
               <h:graphicImage value="./img/arrow_down16.png" />
            </h:link>
            <#else>
            <h:link outcome="/${'#'}{empty from ? '${pageName}' : from}.xhtml" rendered="${'#'}{empty from and _${componentName}.${documentField}.length() >2}"
                   propagation="${'#'}{empty from ? 'none' : 'default'}"
                      id="${componentName}DownLoad">
             <#if pojo.isComponent(pojo.identifierProperty)>
              <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
                <f:param name="${componentName}${componentProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}.${componentProperty.name}}"/>
              </#foreach>
             <#else>
                <f:param name="${componentName}${pojo.identifierProperty.name?cap_first}"
                        value="${'#'}{_${componentName}.${pojo.identifierProperty.name}}"/>
             </#if>
               <h:graphicImage value="./img/arrow_down16.png" />
            </h:link>
            </#if>
           </#if>
          -->
          <#--
            removed because table row variable assumes all rows are shown
          -->
           <#if documentField != "" >
            <#if menuAttributesFunction =="1m" || menuAttributesFunction =="1n">
            <h:commandButton id="Download1" image="/img/arrow_down16.png" rendered="${'#'}{empty from and _${componentName}.${documentField} !=null}" action="${'#'}{${homeName}.downloadThis(${selectParam})}"/>
            <#else>
            <h:commandButton id="Download1" image="/img/arrow_down16.png" rendered="${'#'}{empty from and _${componentName}.${documentField}.length() >2}" action="${'#'}{${homeName}.downloadThis(${selectParam})}"/>
            </#if>
           </#if>
        </p:column>
        </#if>
<#-- @outputValue is a macro inside typeInfo.ftl in r3gen/util dir -->
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if !c2h.isCollection(property) && !isToOne(property) && property != pojo.versionProperty!>
  <#assign colIndex=colIndex+1>
  <#if pojo.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
        <#if (colIndex < 8) >
        <p:column headerText="${'#'}{messages['${componentProperty.name?substring(pL)?cap_first}']}" rendered = "${'#'}{!${componentName}List.skipColumns}">
        <#else>
        <p:column >
        </#if>
             <@outputValue property=componentProperty expression="${'#'}{_${componentName}.${property.name}.${componentProperty.name}}" indent=iL rowEditType="IO" foreignKeyName=""/>
        </p:column>
   </#foreach>
  <#else>
   <#--non component replace hardcoded sid and key column by checking for hide flag, will give flexibility or look into rendered with EH to be done
    hiding key not good because start/end uses key values unless start/end shows sub keys , show k until later  -->
   <#if variation ==" ">
     <#-- all ${property.name}  ${keyfromsubkeys}  ${menuAttributesFunction} -->
    <#if
     (
      ( (property.name?substring(pfS,pfE)!="za") && (property.name?substring(pfS,pfE)!="zb") && (property.name?substring(pfS,pfE)!="zd") && (property.name?substring(pfS,pfE)!="zf") && (property.name?substring(pfS,pfE)!="zt") 
       && (property.name?substring(pfS,pfE)!="to")  && (menuAttributesFunction!="1r" && property.name?substring(pfS,pfE)!="2o")
       && (menuAttributesFunction!="1l" && property.name?substring(pfS,pfE)!="2o")
       && (menuAttributesFunction!="1m" && property.name?substring(pfS,pfE)!="2o")
       && (menuAttributesFunction!="1n" && property.name?substring(pfS,pfE)!="2o")
       && ( menuAttributesFunction?contains("24") && !property.name?contains("type")) )
      &&
      (
       property.name?substring(0,1) == "y" || (property.name?substring(0,1) == "z" && property.name?substring(pfS,pfE)!="tp") 
      )
     )
     || property.name?substring(0,6) == "a0xxuo" || property.name?contains("a1xxuxxxbvxxxxxxxxxxcountry") || property.name?contains("a1xxuxxxbvxxxxxxxxxxvariant")
        || ( menuAttributesFunction?contains("1s") && (property.name?contains("name") || property.name?contains("ticket") || property.name?contains("po")))
    >
     <#-- hide ${property.name}  ${keyfromsubkeys}  ${menuAttributesFunction}-->
      <#if ( menuAttributesFunction?contains("1s") && property.name?contains("name") ) >
        <#assign nameTip=property.name>
      </#if>
      <#if ( menuAttributesFunction?contains("1s") && property.name?contains("ticket") )>
        <#assign ticketTip=property.name>
      </#if>
      <#if ( menuAttributesFunction?contains("1s") && property.name?contains("po") )>
        <#assign poTip=property.name>
        <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{_${componentName}.${nameTip}}"/><h:outputText value=" ${'#'}{_${componentName}.${ticketTip}}"/><h:outputText value=" ${'#'}{_${componentName}.${poTip}}"/></span> </p:tooltip> 
        <#if skipcolEnd=="y">
         </p:column> 
         <#assign skipcolEnd="n">
        </#if>
      </#if>
    <#else>
     <#-- not hide ${property.name}  ${keyfromsubkeys}  ${menuAttributesFunction} ${colIndex}-->
         <#if (colIndex < 8) >     
          <#if menuAttributesFunction?contains("1s") && property.name?contains("seat") && property.name?contains("status")>
           <p:column rendered="${'#'}{!${componentName}List.skipColumns}" 
           <#assign skipcolEnd="y">
          <#else>
           <p:column rendered="${'#'}{!${componentName}List.skipColumns}"
          </#if>
         <#else>
          <#if menuAttributesFunction?contains("1s") && property.name?contains("seat") && property.name?contains("status")>
           <p:column  
           <#assign skipcolEnd="y">
          <#else>
           <p:column 
          </#if>
         </#if> 
                    <#if menuAttributesFunction ="5a" >
                     <#assign cIndex=cIndex+1>
                     <#if (cIndex > 2) >
                     headerText="${'#'}{messages[${listName}.showColumnNames[${cIndex}]]}">
                     <#else>
                     headerText="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
                     </#if>
                    <#else>
                     <#if menuAttributesFunction?contains("1s") && property.name?contains("seat")>
                      headerText="${'#'}{messages['${property.name?substring(24,27)}']}">
                     <#else>
                      headerText="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
                     </#if>
                    </#if>
           <#if property.name?substring(pfS,pfE)=="zb"> 
              <ui:remove>
               blobdata itself so look at the type directly, use id,seq etc cannot use the image data via url 
              </ui:remove>
              <p:commandButton value=" + " id="popup" style="vertical-align:top;" rendered="${'#'}{_${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('j') || _${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('pn')|| _${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('b')|| _${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('asi')}">
              </p:commandButton>
              <h:graphicImage id="${listName}I"
               value="/ImageServletCdi/?table=${'#'}{_${blobdataEntityName}.a0xxukbdlvxxxxxxxxxxfromtable}&amp;seq=${'#'}{_${blobdataEntityName}.a3xxexnsbvxxxxxxxxxxsequence}&amp;qlf=${'#'}{_${blobdataEntityName}.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=X${'#'}{_${blobdataEntityName}.a1xxuxxxbv49xxxxxxxxfromkey}&amp;width=50"  rendered="true">
              </h:graphicImage> 
              <h:outputText value="PDF" rendered="${'#'}{_${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('pdf')}" />
              <h:outputText value="XLS" rendered="${'#'}{_${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('xls')}" />
              <h:outputText value="PPT" rendered="${'#'}{_${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('ppt')}" />
              <h:outputText value="URL" rendered="${'#'}{_${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('url')}" />
              <p:overlayPanel for="popup" modal="true" showCloseIcon="true">
                              <h:outputText value="copy &amp; paste url shown below " /><br></br>
                              <h:outputText value="in HTML cKEditor image url or as source in iframe " /><br></br>
                              <h:outputText value="(you may also use drag drop, click on the video at the bottom to see how) " /><br></br>
                              <h:outputText value="Adjust Width as needed " /><br></br>
                              <br></br>${'#'}{messages['Relative']} ${'#'}{messages['URL']} (Within this site)
                              <br></br><h:outputText value="/ImageServletCdi/?table=${'#'}{_${blobdataEntityName}.a0xxukbdlvxxxxxxxxxxfromtable}&amp;seq=${'#'}{_${blobdataEntityName}.a3xxexnsbvxxxxxxxxxxsequence}&amp;qlf=${'#'}{_${blobdataEntityName}.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=X${'#'}{_${blobdataEntityName}.a1xxuxxxbv49xxxxxxxxfromkey}&amp;width=700" />
                             <br></br>
                             <h:graphicImage
                               value="/ImageServletCdi/?table=${'#'}{_${blobdataEntityName}.a0xxukbdlvxxxxxxxxxxfromtable}&amp;seq=${'#'}{_${blobdataEntityName}.a3xxexnsbvxxxxxxxxxxsequence}&amp;qlf=${'#'}{_${blobdataEntityName}.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=X${'#'}{_${blobdataEntityName}.a1xxuxxxbv49xxxxxxxxfromkey}&amp;width=200"  rendered="${'#'}{_${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('j') || _${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('pn')|| _${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('b')|| _${componentName}.a4xxexxxbvxxxxxxxxxxtype.startsWith('asi')}">
                             </h:graphicImage> 
                              <br></br>${'#'}{messages['External']} ${'#'}{messages['URL']} (in Email body)
                              <br></br><h:outputText value="${'#'}{request.scheme}://${'#'}{request.serverName}:${'#'}{request.serverPort}/ImageServletCdi/?table=${'#'}{_${blobdataEntityName}.a0xxukbdlvxxxxxxxxxxfromtable}&amp;seq=${'#'}{_${blobdataEntityName}.a3xxexnsbvxxxxxxxxxxsequence}&amp;qlf=${'#'}{_${blobdataEntityName}.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=X${'#'}{_${blobdataEntityName}.a1xxuxxxbv49xxxxxxxxfromkey}&amp;width=700" />
                              <br></br>
              </p:overlayPanel>
           <#elseif property.name?substring(pfS,pfE)=="za"> 
              <h:outputText value="${'#'}{fn:substring(_${componentName}.${property.name},0,50)}"  />
           <#elseif property.name?substring(pfS,pfE)=="zf"> 
            <#if (menuAttributesFunction =="20" |menuAttributesFunction =="30" |menuAttributesFunction =="40" ) >
              <h:outputText value="${'#'}{_${componentName}.${property.name} eq 4 ?'returned/rejected':(_${componentName}.${property.name} eq 8 ?'closed':(_${componentName}.${property.name} eq 16 ?'paid/waiting approval':( _${componentName}.${property.name} eq 32 ?'shipped/approved': (_${componentName}.${property.name} eq 64 ?'unsubscribed':(_trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl eq 1 ?'active/ordered':'new/other')))))}"  id="zcxxzzfxhhxxxxxxxxxxstatusfl" />
            <#else>
              <h:outputText value="${'#'}{_${componentName}.${property.name} eq 4 ?'returned/rejected':(_${componentName}.${property.name} eq 8 ?'closed':(_${componentName}.${property.name} eq 16 ?'paid/waiting approval':( _${componentName}.${property.name} eq 32 ?'shipped/approved': (_${componentName}.${property.name} eq 64 ?'invoiced/final approved':(_trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl eq 1 ?'active/ordered':'new/other')))))}"  id="zcxxzzfxhhxxxxxxxxxxstatusfl" />
            </#if>
           <#elseif property.name?substring(pfS,pfE)=="zt"> 
              <h:outputText value="${'#'}{_${componentName}.${property.name}}"  id="statusfldt" >
               <f:convertDateTime pattern="dd/MM/yy h:mm:s z"/>
              </h:outputText>
           <#elseif property.name?substring(pfS,pfE)=="zd"> 
              <ui:remove>
               non blobdata so look at the type via getblobdataTypeMime, could have used blobDataType
              </ui:remove>
              <p:commandButton value=" + " id="popup" style="vertical-align:top;" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',_${componentName}.${property.name},1,1).contains('image/')}">
              </p:commandButton>
              <h:graphicImage 
              value="/ImageServletCdi/?table=${componentName?upper_case}&amp;seq=1&amp;qlf=1&amp;id=${'#'}{_${componentName}.${property.name}}&amp;width=50" rendered="${'#'}{_${componentName}.${property.name}.length()>2}">
            </h:graphicImage> 
              <h:outputText value="${homeName}.getClobdata('${componentName?upper_case}',_${componentName}.${property.name},1,1,500)}" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',_${componentName}.${property.name},1,1).startsWith('t')}" />
              <h:outputText value="PDF" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',_${componentName}.${property.name},1,1).startsWith('application/pdf')}" />
              <h:outputText value="XLS" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',_${componentName}.${property.name},1,1).startsWith('application/vnd.ms-excel')}" />
              <h:outputText value="PPT" rendered="${'#'}{${homeName}.getBlobdataTypeMime('${componentName?upper_case}',_${componentName}.${property.name},1,1).startsWith('application/vnd.ms-powerpoint')}" />
              <p:overlayPanel for="popup" modal="true" showCloseIcon="true">
                             <h:graphicImage
                              value="/ImageServletCdi/?table=${componentName?upper_case}&amp;seq=1&amp;qlf=1&amp;id=${'#'}{_${componentName}.${property.name}}&amp;width=200" rendered="${'#'}{_${componentName}.${property.name}.length()>2}">
                             </h:graphicImage> 
              </p:overlayPanel>
           <#elseif property.name?substring(poS,poE)=="38" || property.name?substring(poS,poE)=="39"  > 
              <h:outputText value="${'#'}{_${componentName}.${property.name}}"  />
           <#elseif property.name?substring(pkS,pkE) == "k" && menuAttributesFunction =="56" > 
              <h:outputText value="${'#'}{_${componentName}.${property.name}}" />
           <#else>
            <@outputValue property=property expression="${'#'}{_${componentName}.${property.name}}"  indent=iL rowEditType="IO" foreignKeyName=""/>
           </#if>
           <#if skipcolEnd =="n">
            </p:column>
           </#if>
    </#if>
   <#else>
    <#if ( (property.name?substring(pkS,pkE)!="k") && !((property.name?substring(pfS,pfE)!="za") && (property.name?substring(pfS,pfE)!="zb") && (property.name?substring(pfS,pfE)!="zd") && (property.name?substring(pfS,pfE)!="zf") && (property.name?substring(pfS,pfE)!="to") ) && ((property.name?substring(0,1) == "y") || (property.name?substring(0,1) == "z" )) )   >
     <#-- variance/more ${property.name}-->
    <#else>
        <#if (colIndex < 8) >
        <p:column rendered = "${'#'}{!${componentName}List.skipColumns}"
        <#else>
        <p:column 
        </#if>
                    headerText="${label(property.name?substring(pL))}">
            <@outputValue property=property expression="${'#'}{_${componentName}.${property.name}}"  indent=iL rowEditType="IO" foreignKeyName=""/>
        </p:column>
    </#if>
   </#if>
  </#if>
 </#if>
 <#if isToOne(property)>
  <#assign colIndex=colIndex+1>
  <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
  <#if parentPojo.isComponent(parentPojo.identifierProperty)>
   <#-- parent pojo is component -->
   <#foreach componentProperty in parentPojo.identifierProperty.value.propertyIterator>
        <#if (colIndex < 8) >
        <p:column rendered = "${'#'}{!${componentName}List.skipColumns}"
        <#else>
        <p:column 
        </#if>
                    headerText="${label(property.name?substring(peL))} Key">
            <@outputValue property=componentProperty expression="${'#'}{_${componentName}.${propertyPath}}" indent=iL rowEditType="S" foreignKeyName=property.name/>
        </p:column>
   </#foreach>
  <#else>
    <#foreach parentProperty in parentPojo.allPropertiesIterator>
       <#if (parentProperty.name?length > pL) >
         <#-- jay notcomposite ppn   ${parentProperty.name} ppid ${parentPojo.identifierProperty.name} zs means descript -->
        <#if keyAutoGen == "Y" >
         <#if parentProperty.name.substring(pfS,pfE)= "zs" >
          <p:column
                    headerText="${label(property.name?substring(peL))} Details">
            <#if property.name?contains("By")>
             <#assign iBy=property.name?index_of("By")>
             <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name?substring(0,iBy)}List.getKeyValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="O" foreignKeyName=property.name/>
            <#else>
              <#if property.name?substring(efS,efE) == "20" || property.name?substring(pfS,pfE) == "30" || property.name?substring(pfS,pfE) == "40" >
               <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name}List.getKeyDemographValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="O" foreignKeyName=property.name/>
              <#else>
               <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name}List.getKeyValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="O" foreignKeyName=property.name/>
              </#if>
            </#if>
          </p:column>
         </#if>
         <#if parentProperty.name.substring(pkS,pkE)= "k" || parentProperty.name.substring(pkS,pkE)= "n">
          <#assign parentKeyName =  parentProperty.name >
          <#-- jay notcomposite parentKeyName ${parentKey} -->
        <#if (colIndex < 8) >
        <p:column rendered = "${'#'}{!${componentName}List.skipColumns}"
        <#else>
        <p:column 
        </#if>
                    headerText="${label(property.name?substring(peL))} Key">
            <#if property.name?contains("By")>
            <#assign iBy=property.name?index_of("By")>
            <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name?substring(0,iBy)}List.getKeyValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="S" foreignKeyName=property.name/>
            <#else>
             <#-- ${menuAttributesFunction} -->
             <#if (menuAttributesFunction?contains("1r") || parentKeyName?contains("a0xxukrdbvxxxxxxxxxxname") ) >
              <h:outputText value="${'#'}{yxxxuq1l1xwwqqhxxxxxresource_bundleList.getKeyValue(_yxxxuq1r1xwwqqhxxxxxresource.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxuobxbxxxxxxxxxxxsid).concat('/ ').concat(_yxxxuq1r1xwwqqhxxxxxresource.yxxxuq1l1xwwqqhxxxxxresource_bundle.zzxxu2oxxhxxxxxxxxxxowner2)}" />
             <#else>
              <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name}List.getKeyValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="S" foreignKeyName=property.name/>
             </#if> 
            </#if>
          </p:column>
         <#else> 
          <#if parentProperty.name.equals(parentPojo.identifierProperty.name) && variation !=" ">
           <#assign parentKeyName =  parentProperty.name >
           <#-- jay notcomposite id parentKeyName ${parentKeyName} show if more  -->
        <#if (colIndex < 8) >
        <p:column rendered = "${'#'}{!${componentName}List.skipColumns}"
        <#else>
        <p:column 
        </#if>
                    headerText="${label(property.name?substring(peL))} Key">
            <#if property.name?contains("By")>
            <#assign iBy=property.name?index_of("By")>
            <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name?substring(0,iBy)}List.getKeyValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="S" foreignKeyName=property.name/>
            <#else>
            <@outputValue property=parentPojo.identifierProperty expression="${'#'}{${property.name}List.getKeyValue(_${componentName}.${property.name}.a0xxuobxbxxxxxxxxxxxsid)}" indent=iL rowEditType="S" foreignKeyName=property.name/>
            </#if>
           </p:column>
          </#if>
         </#if>
        </#if>
       </#if>
    </#foreach>
  </#if>
 </#if>
</#if>
</#foreach>
        <p:column 
            headerText="Action">
            ${'#'}{' '}
            <#if menuAttributesFunction?contains("52")>
             <h:link outcome="/${editPageName}Easy.xhtml"
            <#else>
             <h:link outcome="/${editPageName}.xhtml"
            </#if>
                   value="Edit"
             propagation="none"
                      id="${componentName}Edit"
             <#if menuAttributesFunction?contains("56")>
                rendered="${'#'}{empty from and (customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ') || customIdentity.hasRole('VW'))}">
             <#else>
                rendered="${'#'}{empty from and (customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('PH') || (customIdentity.hasRole('VH')||customIdentity.hasRole('VQ') and customIdentity.product =='f' and customIdentity.subProduct =='s') )}">
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
             <#if menuAttributesFunction?contains("23") || menuAttributesFunction?contains("24") || menuAttributesFunction?contains("25") || menuAttributesFunction?contains("26")>
                <f:param name="${itemEntityName}A0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{_${componentName}.${itemEntityName}.a0xxuobxbxxxxxxxxxxxsid}"/>
                <f:param name="${customerEntityName}A0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{_${componentName}.${customerEntityName}.a0xxuobxbxxxxxxxxxxxsid}"/>
             </#if>
            </h:link>
          <#-- removed
          -->
            ${'#'}{' '}
           <#if documentField != "" >
            <#if menuAttributesFunction =="1m" || menuAttributesFunction =="1n">
            <h:commandButton id="Download" image="/img/arrow_down16.png" rendered="${'#'}{empty from and _${componentName}.${documentField} !=null}" action="${'#'}{${homeName}.downloadThis(${selectParam})}"/>
            <#else>
            <h:commandButton id="Download" image="/img/arrow_down16.png" rendered="${'#'}{empty from and _${componentName}.${documentField}.length() >2}" action="${'#'}{${homeName}.downloadThis(${selectParam})}"/>
            </#if>
           </#if>
        </p:column>
    </p:dataTable>
    </div>
    </p:panel>
    <div class="tableControl">
      <#if variation ==" ">
        <h:link outcome="/${listPageName}.xhtml"
            rendered="${'#'}{${listName}.previousExists}"
               value="${'#'}{messages.left}${'#'}{messages.left} First Page"
                  id="firstPage">
          <f:param name="firstResult" value="0"/>
          <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>
        <h:link outcome="/${listPageName}.xhtml"
            rendered="${'#'}{${listName}.previousExists}"
               value="${'#'}{messages.left} Previous Page "
                  id="previousPage">
            <f:param name="firstResult"
                    value="${'#'}{${listName}.previousFirstResult}"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>

        <h:link outcome="/${listPageName}.xhtml"
            rendered="${'#'}{${listName}.nextExists}"
               value=" Next Page ${'#'}{messages.right}"
                  id="nextPage">
            <f:param name="firstResult"
                    value="${'#'}{${listName}.nextFirstResult}"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>

        <h:link outcome="/${listPageName}.xhtml"
            rendered="${'#'}{${listName}.nextExists}"
               value="Last Page ${'#'}{messages.right}${'#'}{messages.right}"
                  id="lastPage">
            <f:param name="firstResult"
                    value="${'#'}{${listName}.lastFirstResult}"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>
     <#else>
        <h:link outcome="/${listPageName}.more.xhtml"
            rendered="${'#'}{${listName}.previousExists}"
               value="${'#'}{messages.left}${'#'}{messages.left} First Page"
                  id="firstPage">
          <f:param name="firstResult" value="0"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>

        <h:link outcome="/${listPageName}.more.xhtml"
            rendered="${'#'}{${listName}.previousExists}"
               value="${'#'}{messages.left} Previous Page "
                  id="previousPage">
            <f:param name="firstResult"
                    value="${'#'}{${listName}.previousFirstResult}"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>

        <h:link outcome="/${listPageName}.more.xhtml"
            rendered="${'#'}{${listName}.nextExists}"
               value=" Next Page ${'#'}{messages.right}"
                  id="nextPage">
            <f:param name="firstResult"
                    value="${'#'}{${listName}.nextFirstResult}"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>

        <h:link outcome="/${listPageName}.more.xhtml"
            rendered="${'#'}{${listName}.nextExists}"
               value="Last Page ${'#'}{messages.right}${'#'}{messages.right}"
                  id="lastPage">
            <f:param name="firstResult"
                    value="${'#'}{${listName}.lastFirstResult}"/>
            <f:param name="maxResultsVal"
                    value="${'#'}{${listName}.maxResultsVal}"/>
        </h:link>
     </#if>

    </div>

    <div styleClass="actionButtons" >
      <#if menuAttributesFunction !="5b">
       <#if (menuAttributesFunction ="20" || menuAttributesFunction = "30"||menuAttributesFunction="40" ) >
        <h:button outcome="/${editPageName}.address.xhtml"
       <#else>
        <#if menuAttributesFunction?contains("52")>
         <h:button outcome="/${editPageName}Easy.xhtml"
        <#else>
         <h:button outcome="/${editPageName}.xhtml"
        </#if>
       </#if>
                    id="create" styleClass="buttonMain" 
           propagation="none"
           <#if menuAttributesFunction?contains("1f")>
            rendered="false"
           <#else> 
            rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}"
           </#if>
                 value="${'#'}{messages['Create']} ${'#'}{messages['${componentName?substring(eL)?cap_first}']}">
         <#assign idName = componentName + pojo.identifierProperty.name?cap_first>
         <#if c2j.isComponent(pojo.identifierProperty)>
          <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
           <#assign cidName = componentName + componentProperty.name?cap_first>
          </#foreach>
         <#else>
         </#if>
        </h:button>
       </#if>
        <#if (menuAttributesFunction =="5b" ) >
        <h:button outcome="/importMappingEdit.xhtml"
                    id="createM" styleClass="buttonMain" 
           propagation="none"
           rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}"
                 value="${'#'}{messages['CSV']} ${'#'}{messages['Mapping']} ${'#'}{messages['Template']}">
               <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['One']} ${'#'}{messages['template']} ${'#'}{messages['needed']} ${'#'}{messages['per']} ${'#'}{messages['table']} ${'#'}{messages['and']} ${'#'}{messages['can']} ${'#'}{messages['be']} ${'#'}{messages['rebuilt']},  ${'#'}{messages['Column']} ${'#'}{messages['mapping']} ${'#'}{messages['for']} ${'#'}{messages['a']} ${'#'}{messages['table']} ${'#'}{messages['is']} ${'#'}{messages['done']} ${'#'}{messages['by']} ${'#'}{messages['Map']} ${'#'}{messages['Column']} ${'#'}{messages['link']}"/></span> </p:tooltip> 

        </h:button>

        <h:button outcome="/importUsingMapping.xhtml"
                    id="importM" styleClass="buttonMain" 
           rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}"
                 value="${'#'}{messages['Import']} ${'#'}{messages['using']} ${'#'}{messages['Mapping']}">

        </h:button>
            <br></br>
            <h:outputText value="${'#'}{messages['Step1']}: ${'#'}{messages['Upload']} ${'#'}{messages['CSV']} ${'#'}{messages['file']} ${'#'}{messages['content']} ${'#'}{messages['as']} ${'#'}{messages['text']} ${'#'}{messages['data']} (${'#'}{messages['select']} ${'#'}{messages['or']} ${'#'}{messages['enter']} ${'#'}{messages['table']} ${'#'}{messages['name']} ${'#'}{messages['as']} ${'#'}{messages['key']}, ${'#'}{messages['select']} ${'#'}{messages['type']} ${'#'}{messages['as']} ${'#'}{messages['CSV']}) "/>
            &nbsp;<h:link value="${'#'}{messages['Step1']}"  outcome="/clobdataEdit.xhtml" target="_blank"/>
            <br></br>
            ${'#'}{messages['Step2']}: ${'#'}{messages['Create']} / ${'#'}{messages['rebuilt']} ${'#'}{messages['CSV']} ${'#'}{messages['Template']} (${'#'}{messages['holds']} ${'#'}{messages['mapping']} ${'#'}{messages['header']} ${'#'}{messages['and']} ${'#'}{messages['subset']} ${'#'}{messages['of']} ${'#'}{messages['csv']} ${'#'}{messages['data']} ${'#'}{messages['to']} ${'#'}{messages['help']} ${'#'}{messages['mapping']}) 
            &nbsp;<h:link value="${'#'}{messages['Step2']}"  outcome="/importMappingEdit.xhtml" target="_blank"/>
            <br></br>
            ${'#'}{messages['Step3']}: ${'#'}{messages['Map']} ${'#'}{messages['header']} ${'#'}{messages['column']} ${'#'}{messages['value']} ${'#'}{messages['to']} ${'#'}{messages['table']} ${'#'}{messages['field']} (${'#'}{messages['use']} ${'#'}{messages['CSV']} ${'#'}{messages['data']} ${'#'}{messages['shown']} ${'#'}{messages['as']} ${'#'}{messages['a']} ${'#'}{messages['guide']}) 
            &nbsp;<h:link value="${'#'}{messages['Step3']}"  outcome="/columnMappingEdit.xhtml" target="_blank"/>
            <br></br>
            ${'#'}{messages['FinalStep']}: ${'#'}{messages['Import']} ${'#'}{messages['using']} ${'#'}{messages['mapping']} (${'#'}{messages['copies']} ${'#'}{messages['csv']} ${'#'}{messages['data']} ${'#'}{messages['as']} ${'#'}{messages['table']} ${'#'}{messages['rows']} ${'#'}{messages['using']} ${'#'}{messages['column']} ${'#'}{messages['mapping']})
            &nbsp;<h:link value="${'#'}{messages['FinalStep']}"  outcome="/importUsingMapping.xhtml" target="_blank"/>


        </#if>


        <#if (menuAttributesFunction =="60" ) >
         <#-- put logic to check csv in clob for both account and acintegr before continuing since accountHome does both 
         allow del csv here for convenience and automatic overide may not allways apply 
         -->
         <h:outputLink value="/clobdataEdit.wflow">${'#'}{messages['load']} ${'#'}{messages['account']} ${'#'}{messages['CSV']} 
          <f:param name="fromKey" value="accounts" />
          <f:param name="qualifier" value="csv" />
          <f:param name="sequence" value="1" />
          <f:param name="from" value="${entityName}List"/>
         </h:outputLink>
         <h:outputLink value="/clobdataEdit.wflow">${'#'}{messages['load']} ${'#'}{messages['account_integration']} ${'#'}{messages['CSV']} 
          <f:param name="fromKey" value="acintegr" />
          <f:param name="qualifier" value="csv" />
          <f:param name="sequence" value="1" />
          <f:param name="from" value="${entityName}List"/>
         </h:outputLink>
         
         <h:commandButton id="importcsv" status="buttonStatus" value="Import"  action="${'#'}{${accountEntityName}Home.importCsvData('accounts','csv',1,90000)}" 
             render="importcsv,globalMessages" rendered="${'#'}{${listName}.maxResultsVal lt 49}">
             <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Take a backup first,Import will add to or override any existing data"/></span> </p:tooltip> 
          <f:param name="from" value="${entityName}List"/>
         </h:commandButton>
         <h:commandButton id="delImport" status="buttonStatus" value="Undo Import"  action="${'#'}{${accountEntityName}Home.deleteAllRecentCopied()}" 
             render="importcsv,globalMessages" rendered="${'#'}{${listName}.maxResultsVal lt 49}">
             <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Will remove Recent (upto 5 days) imported data"/></span> </p:tooltip> 
         </h:commandButton>

        </#if>
        <#if (menuAttributesFunction =="63" ) >
         <#-- put logic for perioddates  flag and purge removed  may add later after able to pass before date-->
         <h:commandButton id="fyrend" value="Fiscal Year End"  action="${'#'}{${accountEntityName}Home.doFYearEnd()}" onclick="if (! confirm('${'#'}{messages.account} ${'#'}{messages.report} ${'#'}{messages.done} ?') ) { return false;}; yxxxch601xwwqqhxxxxxaccountHome.doFYearEnd();return true; "/>
       <ui:remove>
         <h:commandButton id="flagJournal" value="${'#'}{messages['Close_Old_Journals']}"  action="${'#'}{${accountEntityName}Home.doFlagJournals()}"/>
         <h:commandButton id="purgeJournal" value="${'#'}{messages['Delete_Old_Journals']}"  action="${'#'}{${accountEntityName}Home.doPurgeJournals()}"/>
       </ui:remove>
        </#if>
        <#if (menuAttributesFunction =="62" ) >
         <#-- put logic for acperiod -->
         <h:commandButton id="holdbusdate" value="${'#'}{messages['Hold']} ${'#'}{messages['Currbusdate']}" 
            disabled="${'#'}{authenticator.isBitSet(yxxxch621xwwqqhxxxxxacperiodList.getKeyToEntity('01').getZ1xxzzfxhhxxxxxxxxxxstatusfl(),6)}"  action="${'#'}{${acperiodEntityName}Home.holdCurrBusDate()}">
             <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Stop rollover to next Business Date"/></span> </p:tooltip> 
         </h:commandButton>

         <h:commandButton id="rholdbusdate" value="${'#'}{messages['Remove']} ${'#'}{messages['Currbusdate']} ${'#'}{messages['Hold']}" 
            disabled="${'#'}{!authenticator.isBitSet(yxxxch621xwwqqhxxxxxacperiodList.getKeyToEntity('01').getZ1xxzzfxhhxxxxxxxxxxstatusfl(),6)}" action="${'#'}{${acperiodEntityName}Home.removeHoldCurrBusDate()}">
             <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Resume rollover after adjustmens are done"/></span> </p:tooltip> 
         </h:commandButton>
        </#if>
        <#if menuAttributesFunction ="1b" >
            <h:commandButton id="salesdata" 
                          value="${'#'}{messages.load_sales_data}" 
                         action="${'#'}{${homeName}.loadSalesData()}">
            </h:commandButton>      
        </#if>                            			  

        <#if (menuAttributesFunction =="1a" || menuAttributesFunction =="18" ) >
         <#-- put logic for item jay add grid for activity and may be for all-->
         <#if (menuAttributesFunction =="1a")>
         <h:button id="gridV" value="Cards View"  outcome="/ItemDetailsBrowse.xhtml?faces-redirect=true"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b' )}">
         <#else>
         <h:button id="gridV" value="List View"  outcome="/ActivityDetailsBrowse.xhtml?faces-redirect=true"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b' )}">
         </#if>
          <f:param name="from" value="${entityName}List"/>
         </h:button>
         <h:button id="gridVI" value="List View"  outcome="/IssueDetailsBrowse.xhtml?faces-redirect=true"  rendered="${'#'}{customIdentity.product=='f'}">
          <f:param name="from" value="${entityName}List"/>
         </h:button>
         <h:button id="treeV" value="Tree View"  outcome="/${pageName}Tree.xhtml?faces-redirect=true">
          <f:param name="from" value="${entityName}List"/>
         </h:button>
         <h:button id="calendarview" value="CalendarView"  outcome="/${pageName}Fcal.xhtml?faces-redirect=true">
          <f:param name="from" value="${entityName}List"/>
         </h:button>

         <#if menuAttributesFunction =="1a">
            &nbsp;&nbsp;&nbsp;&nbsp;<h:button outcome="/itemLabelsPrint.xhtml" id="label" styleClass="button" 
                 value="${'#'}{messages['Print']} ${'#'}{messages['Label']}">
            </h:button>   
            <h:button outcome="/countAlias.xhtml" id="labela" styleClass="button" 
                              rendered="${'#'}{identity.loggedIn and (customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('UH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('BQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('SQ')||customIdentity.hasRole('CQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH'))
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"

                 value="${'#'}{messages['Stock']} ${'#'}{messages['Count']} ${'#'}{messages['SKU']}">
            </h:button>   
            <h:button outcome="/countItem.xhtml" id="labeli" styleClass="button" 
                              rendered="${'#'}{identity.loggedIn and (customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('UH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('BQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('SQ')||customIdentity.hasRole('CQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH'))
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
                 value="${'#'}{messages['Item']} ${'#'}{messages['Count']} ${'#'}{messages['no SKU']}">
            </h:button>   
         </#if> 
        </#if>
        <#if (menuAttributesFunction =="11" | menuAttributesFunction =="1a" | menuAttributesFunction =="20" |menuAttributesFunction =="30" |menuAttributesFunction =="40" 
              ) >
         <h:outputLink value="/clobdataEdit.wflow" 
                              rendered="${'#'}{identity.loggedIn and (customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('UH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('BQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('SQ')||customIdentity.hasRole('CQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH'))
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }">${'#'}{messages['load']} ${'#'}{messages['CSV']}
          <#if (menuAttributesFunction =="11")>
           <f:param name="fromKey" value="address" />
          </#if>
          <#if (menuAttributesFunction =="1a")>
           <f:param name="fromKey" value="item" />
          </#if>
          <#if (menuAttributesFunction =="20")>
           <f:param name="fromKey" value="customer" />
          </#if>
          <#if (menuAttributesFunction =="30")>
           <f:param name="fromKey" value="vendor" />
          </#if>
          <#if (menuAttributesFunction =="40")>
           <f:param name="fromKey" value="employee" />
          </#if>
          <#if (menuAttributesFunction =="1m")>
           <f:param name="fromKey" value="clobdata" />
          </#if>
          <#if (menuAttributesFunction =="1n")>
           <#-- blob csv data needs to be in base64, raaspi blobdata export automatically saves in base64. file is 33% bigger -->   
           <f:param name="fromKey" value="blobdata" />
          </#if>
          <f:param name="qualifier" value="csv" />
          <f:param name="sequence" value="1" />
          <f:param name="from" value="${entityName}List"/>
         </h:outputLink>
         <#if (menuAttributesFunction =="20" |menuAttributesFunction =="30" |menuAttributesFunction =="40" ) >
          <h:outputLink value="/clobdataEdit.wflow">${'#'}{messages['load']} ${'#'}{messages['address']} ${'#'}{messages['CSV']} >
           <f:param name="fromKey" value="address" />
           <f:param name="qualifier" value="csv" />
           <f:param name="sequence" value="1" />
           <f:param name="from" value="${entityName}List"/>
          </h:outputLink>
         </#if>

         <#-- a4j did not invoke put logic to check csv in clob for both customer before continuing -done  -->
         <h:commandButton id="importcsv" value="Import"  action="${'#'}{${homeName}.importCsvData('${componentName?substring(eL)}','csv',1,90000)}"
                              rendered="${'#'}{identity.loggedIn and (customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('UH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('BQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('SQ')||customIdentity.hasRole('CQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH'))
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }">
          <f:param name="from" value="${entityName}List"/>
         </h:commandButton>
         <h:commandButton id="delImport" status="buttonStatus" value="Undo Import"  action="${'#'}{${homeName}.deleteAllRecentCopied()}" 
             render="importcsv,globalMessages" 
                              rendered="${'#'}{identity.loggedIn and ${listName}.maxResultsVal lt 49 and (customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('UH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('BQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('SQ')||customIdentity.hasRole('CQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH'))
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }">
             <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Will remove Recent (upto 5 days) imported data"/></span> </p:tooltip> 
         </h:commandButton>

         <#if (menuAttributesFunction !="1a" && menuAttributesFunction !="11")>
          <h:button id="calendarview" value="${'#'}{messages['calendar']} ${'#'}{messages['view']}"  outcome="/${pageName}Fcal.xhtml?faces-redirect=true">
           <f:param name="from" value="${entityName}List"/>
          </h:button>
         </#if>
        </#if>
        <#if (menuAttributesFunction =="89" | menuAttributesFunction =="9a"  ) >
         <#-- put logic for schedule -->
         <h:button id="calendarview" value="${'#'}{messages['calendar']} ${'#'}{messages['view']}"  outcome="/${pageName}Fcal.xhtml?faces-redirect=true">
          <f:param name="from" value="${entityName}List"/>
         </h:button>
         <#if menuAttributesFunction =="89">
          <h:button id="calendarPview" value="${'#'}{messages['Events']} ${'#'}{messages['view']}"  outcome="/clientFcal.xhtml?faces-redirect=true">
           <f:param name="from" value="${entityName}List"/>
          </h:button>
         </#if>
        </#if>
        <#if (menuAttributesFunction =="56"   ) >
         <#-- put logic for dropout user -->
         <h:outputText value="${'#'}{messages['dropout']} ${'#'}{messages['count']}-"/>
         <h:outputText value="${'#'}{${homeName}.deleteStatDropOuts('dc')}"/>
      <ui:remove>
         <h:commandButton id="udropout" value="${'#'}{messages['Delete']} ${'#'}{messages['dropout']} ${'#'}{messages['user']}"  action="${'#'}{${homeName}.deleteStatDropOuts('dd')}">
         </h:commandButton>
      </ui:remove>
         <#-- put logic for inactive signup user -->
         <h:outputText value="${'#'}{messages['incomplete']} ${'#'}{messages['signup']} ${'#'}{messages['count']}-"/>
         <h:outputText value="${'#'}{${homeName}.deleteStatDropOuts('sc')}"/>
      <ui:remove>
         <h:commandButton id="usignup" value="${'#'}{messages['Delete']} ${'#'}{messages['inactive']} ${'#'}{messages['signup']}"  action="${'#'}{${homeName}.deleteStatDropOuts('sd')}">
         </h:commandButton>
      </ui:remove>
         <#-- put logic for inactive user -->
         <h:outputText value="${'#'}{messages['inactive']} ${'#'}{messages['user']} ${'#'}{messages['count']}-"/>
         <h:outputText value="${'#'}{${homeName}.deleteStatDropOuts('uc')}"/>
      <ui:remove>
         <h:commandButton id="uuser" value="${'#'}{messages['Delete']} ${'#'}{messages['inactive']} ${'#'}{messages['user']}"  action="${'#'}{${homeName}.deleteStatDropOuts('ud')}">
         </h:commandButton>
      </ui:remove>
        </#if>
        <#if (menuAttributesFunction =="25") >
         <h:button outcome="/pickList.xhtml"
            id="opick" styleClass="buttonMain" 
            rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}"
            value="${'#'}{messages['Order']} ${'#'}{messages['Pick']}  ${'#'}{messages['List']} ">
            <f:param name="pick" value="po"/>
         </h:button>
        </#if>
         <h:button outcome="/${'#'}{empty ${componentName}From ? '${menuPageName}' : ${componentName}From}.xhtml"
          id="donefy"
         value="Done"/>&nbsp;
        <#if menuAttributesFunction =="1a">
         <h:button   value="${'#'}{messages['List']} ${'#'}{messages['shared']} ${'#'}{messages['Item']}"  outcome="/itemSystemList.xhtml" 
          rendered="${'#'}{(customIdentity.masterSite)}" >
         </h:button> 
        </#if>
        <#if menuAttributesFunction =="89">
             <h:commandButton id="emalRemind" action="${'#'}{sqlSupport.emailReminders('email')}"  
               value="send schedule reminder" rendered="${'#'}{customIdentity.masterSite}"/>  
        </#if>


        <#if menuAttributesFunction =="1m">
         <h:button   value="${'#'}{messages['List']} ${'#'}{messages['shared']} ${'#'}{messages['clobdata']}"  outcome="/clobdataSystemList.xhtml" 
          rendered="${'#'}{customIdentity.masterSite}" >
         </h:button> 
        </#if>
        <#if menuAttributesFunction =="1n">
         <h:button   value="${'#'}{messages['List']} ${'#'}{messages['shared']} ${'#'}{messages['blobdata']}"  outcome="/blobdataSystemList.xhtml" 
          rendered="${'#'}{customIdentity.masterSite}" >
         </h:button> 
         <h:outputText style="color:blue;" value="${'#'}{messages['Click']} ${'#'}{messages['below']} ${'#'}{messages['to']} ${'#'}{messages['see']} ${'#'}{messages['how']} ${'#'}{messages['drag']}/${'#'}{messages['drop']} ${'#'}{messages['Images']} ${'#'}{messages['work']}"   />
         <p:panel style="width: 50%;background-color:white;"  header="${'#'}{messages['Click']}  " switchType="client" collapsed="false" rendered="${'#'}{customIdentity.labelView.contains('VM') }"
          toggleable="true" toggleableHeader="true">
          <h:graphicImage value="/img/imagedrag.gif" height="450">
          </h:graphicImage>
         </p:panel>

        </#if>
        <#if menuAttributesFunction =="1r">
         <h:button   value="${'#'}{messages['List']} ${'#'}{messages['shared']} ${'#'}{messages['Resource']}"  outcome="/resourceSystemList.xhtml" 
          rendered="true" >
         </h:button> 

            <br></br>
             <h:outputText value="${'#'}{messages['Message_bundle']} ${'#'}{messages['structure']}: ${'#'}{messages['m(message)']}, ${'#'}{messages['en(language)']}, ${'#'}{messages['US(country)']} ${'#'}{messages['o2(variant)']}. o2 ${'#'}{messages['makes']} ${'#'}{messages['message']} ${'#'}{messages['site']} ${'#'}{messages['specific']}." /> 
            <br></br>
             <h:outputText value="${'#'}{messages['customIdentity.masterSiteCode']} ${'#'}{messages['has']}: ${'#'}{messages['prebult']} ${'#'}{messages['messages']} ${'#'}{messages['for']} ${'#'}{messages['each']} ${'#'}{messages['level']} ${'#'}{messages['except']} ${'#'}{messages['for']} o2. ${'#'}{messages['Lower']} ${'#'}{messages['level']} ${'#'}{messages['overrides']} ${'#'}{messages['upper']} ${'#'}{messages['level']}." /> 
            <br></br>
        </#if>
        <#if menuAttributesFunction =="1l">
         <h:button   value="${'#'}{messages['List']} ${'#'}{messages['shared']} ${'#'}{messages['Resource_bundle']}"  outcome="/resource_bSList.xhtml" 
          rendered="true" >
         </h:button> 
            <br></br>
             <h:outputText value="${'#'}{messages['Message_bundle']} ${'#'}{messages['structure']}: ${'#'}{messages['m(message)']}, ${'#'}{messages['en(language)']}, ${'#'}{messages['US(country)']} ${'#'}{messages['o2(variant)']}. o2 ${'#'}{messages['makes']} ${'#'}{messages['message']} ${'#'}{messages['site']} ${'#'}{messages['specific']}." /> 
            <br></br>
             <h:outputText value="${'#'}{messages['customIdentity.masterSiteCode']} ${'#'}{messages['has']}: ${'#'}{messages['prebult']} ${'#'}{messages['messages']} ${'#'}{messages['for']} ${'#'}{messages['each']} ${'#'}{messages['level']} ${'#'}{messages['except']} ${'#'}{messages['for']} o2. ${'#'}{messages['Lower']} ${'#'}{messages['level']} ${'#'}{messages['overrides']} ${'#'}{messages['upper']} ${'#'}{messages['level']}." /> 
            <br></br>
        </#if>
       <ui:remove>
        <#if menuAttributesFunction =="1s">
         <h:button id="seatAllo" value="${'#'}{messages['Assign']} ${'#'}{messages['seat']}"   outcome="/seatAllocateEdit.xhtml" target="_blank"/>
        </#if>
       </ui:remove>

        <#if (menuAttributesFunction =="52") >
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:bold" value="${'#'}{messages['configure']} ${'#'}{messages['Paypal']} ${'#'}{messages['payment']} ${'#'}{messages['integration']} / ${'#'}{messages['Outgoing']} ${'#'}{messages['Email']} and ${'#'}{messages['Others']} - ${'#'}{messages['use']} ${'#'}{messages['version']} 01 " /> 
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Shopify']} ${'#'}{messages['integration']} - ${'#'}{messages['auto']} ${'#'}{messages['created']} ${'#'}{messages['version']} 02 " /> 
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Square']} ${'#'}{messages['payment']} ${'#'}{messages['integration']} - ${'#'}{messages['create']}/${'#'}{messages['use']} ${'#'}{messages['version']} 03 " /> 
            <h:commandButton id="sqr" value="${'#'}{messages['Create']} ${'#'}{messages['Square']} ${'#'}{messages['Payment']} ${'#'}{messages['Record']}"  rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}" action="${'#'}{${homeName}.createRecord('03')}" />
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Sprite']} ${'#'}{messages['payment']} ${'#'}{messages['integration']} - ${'#'}{messages['create']}/${'#'}{messages['use']} ${'#'}{messages['version']} 04 (${'#'}{messages['Beta']})" /> 
            <h:commandButton id="spr" value="${'#'}{messages['Create']} ${'#'}{messages['Sprite']} ${'#'}{messages['Payment']} ${'#'}{messages['Record']}"  rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}" action="${'#'}{${homeName}.createRecord('04')}" />
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['mailRelay']} ${'#'}{messages['server']} - ${'#'}{messages['auto']} ${'#'}{messages['created']} ${'#'}{messages['version']} 05 " /> 
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Google']} ${'#'}{messages['Mail']} ${'#'}{messages['Server']} ${'#'}{messages['integration']} - ${'#'}{messages['create']}/${'#'}{messages['use']} ${'#'}{messages['version']} 07 " /> 
            <h:commandButton id="gsmtp" value="${'#'}{messages['Create']} ${'#'}{messages['Google']} ${'#'}{messages['Oauth']} ${'#'}{messages['Record']}"  rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}" action="${'#'}{${homeName}.createRecord('07')}" >
               <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['store']} ${'#'}{messages['Oauth']} ${'#'}{messages['tokens']} ${'#'}{messages['and']} ${'#'}{messages['set']} ${'#'}{messages['record 01']} ${'#'}{messages['SMTP']} ${'#'}{messages['parameters']}"/></span> </p:tooltip> 
            </h:commandButton>
          <ui:fragment rendered="${'#'}{customIdentity.masterSite}">
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Openshift']} ${'#'}{messages['Oauth']} ${'#'}{messages['Server']} ${'#'}{messages['integration']} - ${'#'}{messages['create']}/${'#'}{messages['use']} ${'#'}{messages['version']} 08 " /> 
            <h:commandButton id="openshft" value="${'#'}{messages['Create']} ${'#'}{messages['Openshift']} ${'#'}{messages['Oauth']} ${'#'}{messages['Record']}"  rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}" action="${'#'}{${homeName}.createRecord('08')}" >
            </h:commandButton>
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Openshift']} ${'#'}{messages['Route']} ${'#'}{messages['ssl_cert']} ${'#'}{messages['integration']} - ${'#'}{messages['create']}/${'#'}{messages['use']} ${'#'}{messages['version']} 09 " /> 
            <h:commandButton id="opnroutrcrt" value="${'#'}{messages['Create']} ${'#'}{messages['Openshift']} ${'#'}{messages['Route']} ${'#'}{messages['Record']}"  rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}" action="${'#'}{${homeName}.createRecord('09')}" >
            </h:commandButton>
            <br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['configure']} ${'#'}{messages['Openshift']} ${'#'}{messages['Route']} ${'#'}{messages['ssl_pkey']} ${'#'}{messages['integration']} - ${'#'}{messages['create']}/${'#'}{messages['use']} ${'#'}{messages['version']} 10 " /> 
            <h:commandButton id="opnroutrpvt" value="${'#'}{messages['Create']} ${'#'}{messages['Openshift']} ${'#'}{messages['Route']} ${'#'}{messages['Record']}"  rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}" action="${'#'}{${homeName}.createRecord('10')}" >
            </h:commandButton>
          </ui:fragment>
            <br></br><br></br>
            &nbsp;&nbsp;<h:outputText style="font-weight:lighter" value="${'#'}{messages['Change']} ${'#'}{messages['Appname']} ${'#'}{messages['needs']} ${'#'}{messages['new']} ${'#'}{messages['name']} ${'#'}{messages['in']} ${'#'}{messages['requestor']} ${'#'}{messages['client']} ${'#'}{messages['record']} ${'#'}{messages['field']} hdstyle" 
              rendered="${'#'}{customIdentity.masterSite}"/> 
        </#if>
        <#if (menuAttributesFunction =="51" || menuAttributesFunction =="59")
              || menuAttributesFunction =="60" ||menuAttributesFunction =="61" ||menuAttributesFunction =="65">
         <h:button outcome="/${pageName}Report.xhtml" id="report" styleClass="button" 
                 value="${'#'}{messages['Report']}">
         </h:button>  


        </#if>
        <#if (menuAttributesFunction =="51") >
         <br></br><h:outputText value="${'#'}{messages['Rate']} ${'#'}{messages['is']} ${'#'}{messages['based']} ${'#'}{messages['on']} ${'#'}{messages['regulations']} ${'#'}{messages['applicapable']}  ${'#'}{messages['to']} ${'#'}{messages['where']}  ${'#'}{messages['business']} ${'#'}{messages['is']} ${'#'}{messages['located']}"/>
         <br></br><h:outputText value="${'#'}{messages['Whether']} ${'#'}{messages['to']} ${'#'}{messages['collect/remit']} ${'#'}{messages['the']} ${'#'}{messages['tax']} ${'#'}{messages['will']}  ${'#'}{messages['depend']} ${'#'}{messages['on']} ${'#'}{messages['customer']} ${'#'}{messages['shipment']} ${'#'}{messages['address']} ${'#'}{messages['location']}"/>
         <br></br><h:outputText value="${'#'}{messages['Generally']} ${'#'}{messages['tax']} ${'#'}{messages['is']} ${'#'}{messages['not']} ${'#'}{messages['collected']} ${'#'}{messages['if']}  ${'#'}{messages['shipped']} ${'#'}{messages['outside']} ${'#'}{messages['business']} ${'#'}{messages['jurisdiction']}, ${'#'}{messages['please']} ${'#'}{messages['consult']} ${'#'}{messages['experts']}"/>
         <br></br><h:outputText value="${'#'}{messages['tax1']} (${'#'}{messages['federal']}/${'#'}{messages['central']} ${'#'}{messages['level']} ${'#'}{messages['rate']} : ${'#'}{messages['options']} ${'#'}{messages['column']} 04, ${'#'}{messages['row']} 01 for item cost, ${'#'}{messages['row']} 02 for shipment cost,${'#'}{messages['row']} 03 for handling cost  "/>
         <br></br><h:outputText value="${'#'}{messages['tax2']} (${'#'}{messages['provincial']}/${'#'}{messages['state']} ${'#'}{messages['level']} ${'#'}{messages['level']}: ${'#'}{messages['options']} ${'#'}{messages['column']} 05, ${'#'}{messages['row']} 01 for item cost, ${'#'}{messages['row']} 02 for shipment cost,${'#'}{messages['row']} 03 for handling cost  "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['tax3']} (${'#'}{messages['municipal']}/${'#'}{messages['food']} ${'#'}{messages['level']} ${'#'}{messages['level']}: ${'#'}{messages['options']} ${'#'}{messages['column']} 06, ${'#'}{messages['row']} 01 for item cost, ${'#'}{messages['row']} 02 for shipment cost,${'#'}{messages['row']} 03 for handling cost  "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['Set']} ${'#'}{messages['the']} ${'#'}{messages['Tax']} ${'#'}{messages['rates']} ${'#'}{messages['here']}, ${'#'}{messages['but']} ${'#'}{messages['control']} ${'#'}{messages['to']} ${'#'}{messages['apply']} ${'#'}{messages['or']} ${'#'}{messages['not']} ${'#'}{messages['using']}"/>
         <h:link value="${'#'}{messages['Base']} ${'#'}{messages['level']}"  outcome="/clientList.xhtml" target="_blank"/>
         &nbsp;<h:link value="${'#'}{messages['Item']} ${'#'}{messages['level']}"  outcome="/itemList.xhtml" target="_blank"/>
         &nbsp;<h:link value="${'#'}{messages['customer']} ${'#'}{messages['level']}"  outcome="/customerList.xhtml" target="_blank"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['item']}/${'#'}{messages['customer']}, ${'#'}{messages['to']} ${'#'}{messages['tax']} ${'#'}{messages['or']} ${'#'}{messages['not']}, ${'#'}{messages['defaults']} ${'#'}{messages['to']} ${'#'}{messages['base']} ${'#'}{messages['level']}, ${'#'}{messages['unless']} ${'#'}{messages['flag']} ${'#'}{messages['changed']} ${'#'}{messages['to']} ${'#'}{messages['true']} ${'#'}{messages['to']} ${'#'}{messages['reverse']}"/>

         <br></br> 
         <br></br> 
         <h:outputText value="${'#'}{messages['item']} (${'#'}{messages['type']} : ${'#'}{messages['options']} ${'#'}{messages['column']} 16"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['schedule']} (${'#'}{messages['description']} : ${'#'}{messages['options']} ${'#'}{messages['column']} 35 ${'#'}{messages['type']} : ${'#'}{messages['options']} ${'#'}{messages['column']} 37"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['tax']} ${'#'}{messages['labels']} ${'#'}{messages['can']} ${'#'}{messages['be']} ${'#'}{messages['changed']} ${'#'}{messages['using']} ${'#'}{messages['message']} ${'#'}{messages['keys']} ${'#'}{messages['as']} Tax1, Tax2, Tax3 Upper Case for T"/>
        </#if>

        <#if (menuAttributesFunction =="59") >
          <ui:fragment rendered="${'#'}{customIdentity.masterSite}">
           <ui:remove>
             String entityName,String fieldName,String oldValue,String newValue,Integer repairCount
           </ui:remove>
             <h4>${'#'}{messages['Select']} ${'#'}{messages['Table']}</h4>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.selectedClass}" 
              rendered="true">
	      <f:selectItems value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.getClassNames('all')}"   /> 
             </h:selectOneMenu>
             </h:panelGrid>
            <h:inputText id="fldName" required="true" value="${'#'}{customIdentity.holdValue}" size="35"
              ph:placeholder="Table column name" maxlength="35" onclick="this.value='';" onfocus="this.select()"
              class="w3-input  w3-light-gray">
            </h:inputText>
            <h:inputText id="currValue" required="true" value="${'#'}{customIdentity.holdValue2}" size="35"
              ph:placeholder="current Value" maxlength="35" onclick="this.value='';" onfocus="this.select()"
              class="w3-input  w3-light-gray">
            </h:inputText>
            <h:inputText id="newValue" required="true" value="${'#'}{customIdentity.holdValue3}" size="35"
              ph:placeholder="New Value" maxlength="35" onclick="this.value='';" onfocus="this.select()"
              class="w3-input  w3-light-gray">
            </h:inputText>
            <h:inputText id="recCounts" required="true" value="${'#'}{customIdentity.imailaddr}" size="35"
              ph:placeholder="record Counts" maxlength="35" onclick="this.value='';" onfocus="this.select()"
              class="w3-input  w3-light-gray">
            </h:inputText>

          <h:commandButton id="repairTbl" value="Repair Table"  action="${'#'}{sqlSupport.repairTable(yxxxch5a1xhhxxhxxxxxtruefalseList.selectedClass,customIdentity.holdValue,customIdentity.holdValue2,customIdentity.holdValue3,customIdentity.imailaddr)}" 
            rendered="true" />
         </ui:fragment>



         <br></br> 
         <h:outputText value="${'#'}{messages['usertype']} : CS (${'#'}{messages['customer']} ${'#'}{messages['shipment']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['prodtype']} : P (${'#'}{messages['production']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : SS (${'#'}{messages['standard']} ${'#'}{messages['shipment']}/${'#'}{messages['small']}) ES (${'#'}{messages['express']} ${'#'}{messages['shipment']}/${'#'}{messages['small']}) PS (${'#'}{messages['pickup']}/${'#'}{messages['small']} CS (${'#'}{messages['COD']}/${'#'}{messages['small']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : SM (${'#'}{messages['standard']} ${'#'}{messages['shipment']}/${'#'}{messages['medium']}) EM (${'#'}{messages['express']} ${'#'}{messages['shipment']}/${'#'}{messages['medium']}) PM (${'#'}{messages['pickup']}/${'#'}{messages['medium']} CM (${'#'}{messages['COD']}/${'#'}{messages['medium']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : SL (${'#'}{messages['standard']} ${'#'}{messages['shipment']}/${'#'}{messages['large']}) EL (${'#'}{messages['express']} ${'#'}{messages['shipment']}/${'#'}{messages['large']}) PL (${'#'}{messages['pickup']}/${'#'}{messages['large']} CL (${'#'}{messages['COD']}/${'#'}{messages['large']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['step']} : 0 ${'#'}{messages['value']} amount like 8.90 or 5.00 "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']}  (${'#'}{messages['can']} ${'#'}{messages['also']} ${'#'}{messages['hold']} (${'#'}{messages['item']} ${'#'}{messages['key']}, ${'#'}{messages['value']}) ${'#'}{messages['special']} ${'#'}{messages['shipping']} ${'#'}{messages['charge']} "/>
         <br></br><br></br> 
         <h:outputText value="${'#'}{messages['usertype']} : DC (${'#'}{messages['item']} ${'#'}{messages['discount']} ${'#'}{messages['coupon']}, SC (${'#'}{messages['subscription']} ${'#'}{messages['discount']} ${'#'}{messages['coupon']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['prodtype']} : P (${'#'}{messages['production']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : ${'#'}{messages['Coupon']} ${'#'}{messages['override']} ANY (${'#'}{messages['any']} ${'#'}{messages['item']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : ${'#'}{messages['Coupon']} ${'#'}{messages['override']} ${'#'}{messages['item']} ${'#'}{messages['id']} (${'#'}{messages['like']}) ${'#'}{messages['281']}) (${'#'}{messages['normally']}) ${'#'}{messages['Digital']} ${'#'}{messages['items']})"/>"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['step']} : 0 or nnn number of random coupons if incentive contains #random "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['value']} amount like 8.90 or 5.00 or if userType SC then 180 for 180 days period or 0 if random coupon (365 is harcoded) "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['incentive']} : ${'#'}{messages['Coupon']} ${'#'}{messages['name']}  (${'#'}{messages['DC']}- ${'#'}{messages['backtoschool21']}), (${'#'}{messages['SC']}-${'#'}{messages['trial3R36517']}), (${'#'}{messages['SC']}-${'#'}{messages['renew3R39520']}) ${'#'}{messages['or']} ${'#'}{messages['prefix']} ${'#'}{messages['#random']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['incentive']} : ${'#'}{messages['if']} ${'#'}{messages['userType']}  ${'#'}{messages['SC']}, ${'#'}{messages['incentive']} ${'#'}{messages['name']} ${'#'}{messages['must']} ${'#'}{messages['contain']} ${'#'}{messages['trial']} ${'#'}{messages['or']} ${'#'}{messages['renew']} ${'#'}{messages['matching']} ${'#'}{messages['subcription']} ${'#'}{messages['period']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['Effdate']} : ${'#'}{messages['Coupon']} ${'#'}{messages['effective']}  ${'#'}{messages['date']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['Enddate']} : ${'#'}{messages['Coupon']} ${'#'}{messages['end']}  ${'#'}{messages['date']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['StepName']} (${'#'}{messages['list']} : ${'#'}{messages['options']} ${'#'}{messages['column']} 51"/>
         <ui:fragment rendered="${'#'}{customIdentity.masterSite}">
         <br></br><br></br> 
         <h:outputText value="${'#'}{messages['usertype']} : PC (${'#'}{messages['item']} ${'#'}{messages['to']} ${'#'}{messages['site']} ${'#'}{messages['productcode']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['prodtype']} : P (${'#'}{messages['production']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : ${'#'}{messages['Coupon']} ${'#'}{messages['override']} ${'#'}{messages['item']} ${'#'}{messages['id']} (${'#'}{messages['like']}) ${'#'}{messages['281']}) (${'#'}{messages['normally']}) ${'#'}{messages['Digital']} ${'#'}{messages['items']})"/>"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['step']} : 0 ${'#'}{messages['value']} amount 0.00 (${'#'}{messages['not']} ${'#'}{messages['used']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['incentive']} : ${'#'}{messages['Site']} ${'#'}{messages['productCode']}  (${'#'}{messages['example']}: ${'#'}{messages['ee']} (${'#'}{messages['Business']} ${'#'}{messages['Ecommerce']},${'#'}{messages['oa']} (${'#'}{messages['Organization']} ${'#'}{messages['Association']} )"/>
         </ui:fragment>
        </#if>
        <#if (menuAttributesFunction =="60") >
         <h:outputText value="${'#'}{messages['use']} ${'#'}{messages['account']} ${'#'}{messages['import']} ${'#'}{messages['only']} ${'#'}{messages['if']} ${'#'}{messages['customIdentity.masterSiteCode']} ${'#'}{messages['default']} ${'#'}{messages['set']} ${'#'}{messages['not']} ${'#'}{messages['suitable']}"/>
         <br></br>
         <h:outputText value="${'#'}{messages['account']} ${'#'}{messages['categories']} : ${'#'}{messages['Asset']}(A), ${'#'}{messages['Liability']}(L), ${'#'}{messages['Equity']}(Q), ${'#'}{messages['Income']}/${'#'}{messages['Revenue']}, (I) ${'#'}{messages['Expenses']}(E)  "/>
         <br></br><br></br>
         <h:outputText value="${'#'}{messages['Load']} ${'#'}{messages['both']} ${'#'}{messages['Account']} ${'#'}{messages['and']} ${'#'}{messages['Account']} ${'#'}{messages['Integration']} ${'#'}{messages['csv']} ${'#'}{messages['data']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['account']} ${'#'}{messages['Import ']} ${'#'}{messages['data']} ${'#'}{messages['must']} ${'#'}{messages['follow']} ${'#'}{messages['the']} ${'#'}{messages['template']} ${'#'}{messages['below']}, ${'#'}{messages['a']} ${'#'}{messages['delimeter']} ${'#'}{messages['still']} ${'#'}{messages['needed']} ${'#'}{messages['for']} ${'#'}{messages['any']} ${'#'}{messages['missing']} ${'#'}{messages['data']}"/>
         <br></br><h:outputText value="${'#'}{messages['Template']}: ${'#'}{messages['account']} ${'#'}{messages['delimeter']} ${'#'}{messages['description']} ${'#'}{messages['delimeter']} ${'#'}{messages['category']} ${'#'}{messages['delimeter']} ${'#'}{messages['type']} ${'#'}{messages['delimeter']} ${'#'}{messages['actual']} ${'#'}{messages['delimeter']} ${'#'}{messages['prev-actual']}  ${'#'}{messages['delimeter']}  ${'#'}{messages['delimeter']} ... ${'#'}{messages['LineDelimeter']}" />
         <br></br><h:outputText value="${'#'}{messages['Sample']}: 1005,BANK X,A,D,158,686.54 or &quot;1005&quot;,&quot;BANK&quot; &quot;X&quot;,&quot;A&quot;,&quot;D&quot;,&quot;158,686.54&quot; or '1005','BANK X','A','D','158,686.54'" />
         <br></br>
         <br></br> 
         <h:outputText value="${'#'}{messages['account']} ${'#'}{messages['Integration']} ${'#'}{messages['Import ']} ${'#'}{messages['data']} ${'#'}{messages['must']} ${'#'}{messages['follow']} ${'#'}{messages['the']} ${'#'}{messages['template']} ${'#'}{messages['below']}, ${'#'}{messages['a']} ${'#'}{messages['delimeter']} ${'#'}{messages['still']} ${'#'}{messages['needed']} ${'#'}{messages['for']} ${'#'}{messages['any']} ${'#'}{messages['missing']} ${'#'}{messages['data']}"/>
         <br></br><h:outputText value="${'#'}{messages['Template']}: ${'#'}{messages['moduleId']} ${'#'}{messages['delimeter']} ${'#'}{messages['setsId']} ${'#'}{messages['delimeter']} ${'#'}{messages['usageDescription']} ${'#'}{messages['delimeter']} ${'#'}{messages['usageCode']} ${'#'}{messages['delimeter']} [${'#'}{messages['delimeter']}] ... ${'#'}{messages['LineDelimeter']}" />
         <br></br><h:outputText value="${'#'}{messages['Sample']}: AR,ARB,DEFAULT,Cash/Bank Receipt Account,1005 or AR ARB DEFAULT Cash/Bank Receipt Account 1005" />
         <br></br>
        <br></br> 
        <h:outputText value="${'#'}{messages['import']} ${'#'}{messages['settings']}  "/>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['complete']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.importSet}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>

         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['skip']} ${'#'}{messages['first']} ${'#'}{messages['record']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.skipRecordOne}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>

         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['delimeter']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.delimeterBy}" >
				<f:selectItem  
                         itemLabel="Comma"
                         itemValue="C" /> 
				<f:selectItem  
                         itemLabel="Space"
                         itemValue="S" /> 
         </h:selectOneRadio>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['enclosed']} ${'#'}{messages['by']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.enclosedBy}" >
				<f:selectItem  
                         itemLabel="Single Quote"
                         itemValue="S" /> 
				<f:selectItem  
                         itemLabel="Double Quote"
                         itemValue="D" /> 
				<f:selectItem  
                         itemLabel="None"
                         itemValue="N" /> 
         </h:selectOneRadio>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['line']} ${'#'}{messages['end']} ${'#'}{messages['by']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.lineBy}" >
				<f:selectItem  
                         itemLabel="Semi Colon"
                         itemValue="S" /> 
				<f:selectItem  
                         itemLabel="Back Slash"
                         itemValue="B" /> 
				<f:selectItem  
                         itemLabel="None"
                         itemValue="N" /> 
         </h:selectOneRadio>
         </ui:decorate>
        <br></br> 

        </#if>


        <#if (menuAttributesFunction =="54") >
         <#assign keyField="a0xxukxxbvxxxxxxxxxxcustomer"> 
         <h:commandButton id="importcustomer" value="Import"  status="buttonStatus" action="${'#'}{${homeName}.importEntityData('customer',0,'001')}">
         </h:commandButton>
         <h:commandButton id="delImport" status="buttonStatus" value="Undo Import"  action="${'#'}{${groupmembersEntityName}Home.deleteAllRecentCopied()}" 
             render="importcsv,globalMessages" rendered="${'#'}{${listName}.maxResultsVal lt 49}">
             <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Will remove Recent (upto 5 days) imported data"/></span> </p:tooltip> 
         </h:commandButton>

        <br></br> 
        <h:outputText value="${'#'}{messages['for']} ${'#'}{messages['now']} , ${'#'}{messages['import']} ${'#'}{messages['allows']} ${'#'}{messages['customer']} ${'#'}{messages['selection']} ${'#'}{messages['only']}. "/>
        <h:outputText value="${'#'}{messages['create']} ${'#'}{messages['members']} ${'#'}{messages['button']} ${'#'}{messages['can']} ${'#'}{messages['be']} ${'#'}{messages['used']} ${'#'}{messages['for']} ${'#'}{messages['all']} ${'#'}{messages['types']}"/>
        <br></br> 
        <h:outputText value="${'#'}{messages['import']} ${'#'}{messages['data']} ${'#'}{messages['selection']} ${'#'}{messages['done']}?"/>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['set']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.importSet}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>
              <h:outputText value="${'#'}{messages['import']}"/> 
              <h:outputText value="${'#'}{messages['for']}"/> 
              <h:graphicImage value="/img/Groupmembers16.png" />
              <h:outputText value="${'#'}{messages['select']} ${'#'}{messages['group']}"/> 
                 <h:selectOneMenu  value="${'#'}{${listName}.groupSid}" 
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${membersgroupEntityName}List.getSuggestList(' ')}" var="result"
                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.a0xxukxxbvxxxxxxxxxxgroupid}" />
                 </h:selectOneMenu>
              <h:outputText value="${'#'}{messages['from']}"/> 
                 <h:selectManyListbox  id="toSelect" value="${'#'}{${groupmembersEntityName}List.toSelects}" size="5"
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${customerEntityName}List.getSuggestList(' ')}" var="result"

                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.${keyField}}" />
                   <p:tooltip id="searchTip" attached="true" for="toSelect" >
                    <h:outputText value="${'#'}{messages['Ctrl']} ${'#'}{messages['for']} ${'#'}{messages['multiselect']}" />
                   </p:tooltip>
                 </h:selectManyListbox>

              <h:outputText value=" ${'#'}{messages['or']}"/> 

                 <h:selectManyListbox  id="ccSelect" value="${'#'}{${groupmembersEntityName}List.ccSelects}" size="5"
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${customerEntityName}List.getSuggestList('time')}" var="result"

                   itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" itemLabel="${'#'}{result.${keyField}}" />
                   <p:tooltip id="searchTipC" attached="true" for="ccSelect" >
                    <h:outputText value="${'#'}{messages['Ctrl']} ${'#'}{messages['for']} ${'#'}{messages['multiselect']}" />
                   </p:tooltip>
                 </h:selectManyListbox>
                 <br></br><br></br>
         <h:outputText value="${'#'}{messages['either']} ${'#'}{messages['make']} ${'#'}{messages['selection']} ${'#'}{messages['from']} ${'#'}{messages['above']} ${'#'}{messages['alphabetic']}/${'#'}{messages['newest']} ${'#'}{messages['dropdown']} ${'#'}{messages['list']}, ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['below']} ${'#'}{messages['to']} ${'#'}{messages['include']} ${'#'}{messages['all']} ${'#'}{messages['records']}"/> 

         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['include']} ${'#'}{messages['all']} ${'#'}{messages['records']} </ui:define>
	    <h:selectOneRadio value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembersHome.importAllSet}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
           </h:selectOneRadio>
         </ui:decorate>
                 <br></br><br></br>
         <h:outputText value=" ${'#'}{messages['And']} ${'#'}{messages['apply']} ${'#'}{messages['following']} ${'#'}{messages['filters']}"/> 


         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['lastName']} ${'#'}{messages['contains']} (${'#'}{messages['comma']} ${'#'}{messages['or']} ${'#'}{messages['space']} ${'#'}{messages['separated']} ${'#'}{messages['upto']} ${'#'}{messages['20']})</ui:define>
	    <h:inputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembersHome.importLastName}" >
            </h:inputText>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['exclude']} ${'#'}{messages['if']} ${'#'}{messages['email']} ${'#'}{messages['is']} ${'#'}{messages['empty']}</ui:define>
	    <h:selectOneRadio value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembersHome.importEmailSet}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>




        </#if>
        <h:messages globalOnly="true" style = "color:red;margin:8px;" styleClass="message" id="globalMessagesb"/>

        <#if (menuAttributesFunction =="11" | menuAttributesFunction =="1a" | menuAttributesFunction =="20" |menuAttributesFunction =="30" |menuAttributesFunction =="40" ) >
        <br></br> 
        <h:outputText value="${'#'}{messages['import']} ${'#'}{messages['settings']} ${'#'}{messages['done']} ${'#'}{messages['and']} ${'#'}{messages['ready']} ${'#'}{messages['to']} ${'#'}{messages['import']} ?"/>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['complete']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.importSet}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>

         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['skip']} ${'#'}{messages['first']} ${'#'}{messages['record']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.skipRecordOne}" >
				<f:selectItem  
                         itemLabel="No"
                         itemValue="N" /> 
				<f:selectItem  
                         itemLabel="Yes"
                         itemValue="Y" /> 
         </h:selectOneRadio>
         </ui:decorate>

         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['delimeter']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.delimeterBy}" >
				<f:selectItem  
                         itemLabel="Comma"
                         itemValue="C" /> 
				<f:selectItem  
                         itemLabel="Space"
                         itemValue="S" /> 
         </h:selectOneRadio>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['enclosed']} ${'#'}{messages['by']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.enclosedBy}" >
				<f:selectItem  
                         itemLabel="Single Quote"
                         itemValue="S" /> 
				<f:selectItem  
                         itemLabel="Double Quote"
                         itemValue="D" /> 
				<f:selectItem  
                         itemLabel="None"
                         itemValue="N" /> 
         </h:selectOneRadio>
         </ui:decorate>
         <ui:decorate template="layout/edit.xhtml" >
         <ui:define name="label">${'#'}{messages['line']} ${'#'}{messages['end']} ${'#'}{messages['by']}</ui:define>
	    <h:selectOneRadio value="${'#'}{${homeName}.lineBy}" >
				<f:selectItem  
                         itemLabel="Semi Colon"
                         itemValue="S" /> 
				<f:selectItem  
                         itemLabel="Back Slash"
                         itemValue="B" /> 
				<f:selectItem  
                         itemLabel="None"
                         itemValue="N" /> 
         </h:selectOneRadio>
         </ui:decorate>
        <br></br>
         <h:outputText value="${'#'}{messages['Load']} ${'#'}{messages['csv']} ${'#'}{messages['data']}"/>
        <br></br><h:outputText value="${'#'}{messages['Import ']} ${'#'}{messages['data']} ${'#'}{messages['must']} ${'#'}{messages['follow']} ${'#'}{messages['the']} ${'#'}{messages['template']} ${'#'}{messages['below']}, ${'#'}{messages['a']} ${'#'}{messages['delimeter']} ${'#'}{messages['still']} ${'#'}{messages['needed']} ${'#'}{messages['for']} ${'#'}{messages['any']} ${'#'}{messages['missing']} ${'#'}{messages['data']}. "/>
        <br></br><h:outputText value="[] ${'#'}{messages['means']} ${'#'}{messages['optional']}, ${'#'}{messages['but']} ${'#'}{messages['still']} ${'#'}{messages['needs']} ${'#'}{messages['delimeter']}"/>
       <#if menuAttributesFunction =="1a" >
        <br></br><h:outputText value="${'#'}{messages['Template']}: [${'#'}{messages['key']}] ${'#'}{messages['delimeter']} [${'#'}{messages['quantity']}] ${'#'}{messages['delimeter']} ${'#'}{messages['description']} ${'#'}{messages['delimeter']} [${'#'}{messages['cost']}] ${'#'}{messages['delimeter']} [${'#'}{messages['price']}] ${'#'}{messages['delimeter']} [${'#'}{messages['upc']}] ${'#'}{messages['delimeter']} [${'#'}{messages['type']}] ${'#'}{messages['delimeter']}  ${'#'}{messages['delimeter']} ... ${'#'}{messages['LineDelimeter']}" />
        <br></br><h:outputText value="${'#'}{messages['Only ']} ${'#'}{messages['description']} ${'#'}{messages['is']} ${'#'}{messages['not']} ${'#'}{messages['optional']}"/>
         <br></br><h:outputText value="${'#'}{messages['Sample']}: white shirt063252,,white shirt,20.90,30.99,, " />
         <br></br><h:outputText value="${'#'}{messages['type']}: default value SI-D(shopping) , other accepted values INV,BI-D(Blog),CI-D(Case/Query),PI-D(Picture) " />
       <#elseif menuAttributesFunction =="11">
        <br></br><h:outputText value="${'#'}{messages['Template']}: [${'#'}{messages['key']}] ${'#'}{messages['delimeter']} [${'#'}{messages['addressL1']}] [${'#'}{messages['city']}] ${'#'}{messages['delimeter']} [${'#'}{messages['prov/state']}] ${'#'}{messages['delimeter']} ${'#'}{messages['postal/zip/pin']} ${'#'}{messages['delimeter']}   ${'#'}{messages['delimeter']} ... ${'#'}{messages['LineDelimeter']}" />
        <br></br><h:outputText value="${'#'}{messages['Only ']} ${'#'}{messages['addressL1']} ${'#'}{messages['is']} ${'#'}{messages['not']} ${'#'}{messages['optional']}"/>
         <br></br><h:outputText value="${'#'}{messages['Sample']}: ,21 some st,my city,my state,1234567 " />
       <#else>
        <br></br><h:outputText value="${'#'}{messages['Template']}: [${'#'}{messages['key']}] ${'#'}{messages['delimeter']} [${'#'}{messages['description']}] ${'#'}{messages['delimeter']} [${'#'}{messages['title']}] ${'#'}{messages['delimeter']} ${'#'}{messages['namePart1']} ${'#'}{messages['delimeter']} [${'#'}{messages['namePart2']}] ${'#'}{messages['delimeter']} [${'#'}{messages['company']}] ${'#'}{messages['delimeter']} [${'#'}{messages['officePh']}] ${'#'}{messages['delimeter']} [${'#'}{messages['homePh']}] ${'#'}{messages['delimeter']} [${'#'}{messages['cellPh']}] ${'#'}{messages['delimeter']} [${'#'}{messages['email']}] ${'#'}{messages['delimeter']} [${'#'}{messages['Type']}] ${'#'}{messages['delimeter']}  ${'#'}{messages['delimeter']} ... ${'#'}{messages['LineDelimeter']}" />
        <br></br><h:outputText value="${'#'}{messages['Only ']} ${'#'}{messages['namePart1']} ${'#'}{messages['is']} ${'#'}{messages['not']} ${'#'}{messages['optional']}"/>
        <br></br><h:outputText value="${'#'}{messages['Sample']}: riedstrale-1837063252,,Ms,riedstra,Nancy,,222-333-6666 " />
        <br></br><br></br>
        <h:outputText value="${'#'}{messages['Address']} ${'#'}{messages['records']} ${'#'}{messages['match']} ${'#'}{messages['to']} ${'#'}{messages['above']} ${'#'}{messages['table']}, ${'#'}{messages['no']} ${'#'}{messages['address']} ${'#'}{messages['needs']} ${'#'}{messages['row']} ${'#'}{messages['with']} ${'#'}{messages['delimeters']}" />
        <br></br><h:outputText value="${'#'}{messages['Template']}: [${'#'}{messages['key']}] ${'#'}{messages['delimeter']} [${'#'}{messages['addressL1']}] [${'#'}{messages['city']}] ${'#'}{messages['delimeter']} [${'#'}{messages['prov/state']}] ${'#'}{messages['delimeter']} ${'#'}{messages['postal/zip/pin']} ${'#'}{messages['delimeter']}   ${'#'}{messages['delimeter']} ... ${'#'}{messages['LineDelimeter']}" />
        <br></br><h:outputText value="${'#'}{messages['Only ']} ${'#'}{messages['addressL1']} ${'#'}{messages['is']} ${'#'}{messages['not']} ${'#'}{messages['optional']}"/>
         <br></br><h:outputText value="${'#'}{messages['Sample']}: ,21 some st,my city,my state,1234567 " />

       </#if>
        <br></br>
         <h:outputText value="${'#'}{messages['Create']} ${'#'}{messages['csv']} ${'#'}{messages['data']}"/>
        <br></br><h:outputText value="${'#'}{messages['Use ']} ${'#'}{messages['one']} ${'#'}{messages['of']} ${'#'}{messages['the']} ${'#'}{messages['options']} ${'#'}{messages['below']}: "/>
        <br></br><h:outputText value="${'#'}{messages['If']}: ${'#'}{messages['the']} ${'#'}{messages['data']} ${'#'}{messages['exists']} ${'#'}{messages['in']} ${'#'}{messages['another']} ${'#'}{messages['system']}, ${'#'}{messages['it']} ${'#'}{messages['may']} ${'#'}{messages['have']} ${'#'}{messages['data']} ${'#'}{messages['export']} ${'#'}{messages['or']} ${'#'}{messages['report']} ${'#'}{messages['producing']} ${'#'}{messages['CSV']} ${'#'}{messages['data']}  " />
        <br></br><h:outputText value="${'#'}{messages['For ']} ${'#'}{messages['example']} ${'#'}{messages['customIdentity.masterSiteCode']} ${'#'}{messages['application']} ${'#'}{messages['has']}  ${'#'}{messages['report']} ${'#'}{messages['generation']} ${'#'}{messages['parameter']} ${'#'}{messages['display']} ${'#'}{messages['as']} ${'#'}{messages['CSV']}, ${'#'}{messages['which']} ${'#'}{messages['produces']} ${'#'}{messages['text']}  ${'#'}{messages['file']} ${'#'}{messages['with']} ${'#'}{messages['comma']} ${'#'}{messages['delimeted']} ${'#'}{messages['value']} ${'#'}{messages['and']} ${'#'}{messages['downloads']} ${'#'}{messages['to']} ${'#'}{messages['your']} ${'#'}{messages['machine']} ${'#'}{messages['via']} ${'#'}{messages['browser']} . "/>
        <br></br><h:outputText value="${'#'}{messages['You']}: ${'#'}{messages['can']} ${'#'}{messages['also']} ${'#'}{messages['mannually']} ${'#'}{messages['keyin']} ${'#'}{messages['the']} ${'#'}{messages['data']} ${'#'}{messages['and']} ${'#'}{messages['create']} ${'#'}{messages['the']} ${'#'}{messages['CSV']} ${'#'}{messages['text']} ${'#'}{messages['file']}  " />
        <br></br><h:outputText value="${'#'}{messages['The']}: ${'#'}{messages['CSV']} ${'#'}{messages['data']} ${'#'}{messages['must']} ${'#'}{messages['follow']} ${'#'}{messages['the']} ${'#'}{messages['template']} ${'#'}{messages['pattern']} ${'#'}{messages['shown']} ${'#'}{messages['above']}, ${'#'}{messages['delete']} ${'#'}{messages['records']} ${'#'}{messages['and']} ${'#'}{messages['edit']} ${'#'}{messages['as']} ${'#'}{messages['needed']}" />
        <br></br><h:outputText value="${'#'}{messages['You']}: ${'#'}{messages['may']} ${'#'}{messages['find']} ${'#'}{messages['opening']} ${'#'}{messages['and']} ${'#'}{messages['editing']} ${'#'}{messages['the']} ${'#'}{messages['csv']} ${'#'}{messages['file']} ${'#'}{messages['using']}, ${'#'}{messages['say']} ${'#'}{messages['OpenOffice']} ${'#'}{messages['or']} ${'#'}{messages['LibreOffice']} ${'#'}{messages['or']} ${'#'}{messages['Microsoft']} ${'#'}{messages['Office']} ${'#'}{messages['makes']} ${'#'}{messages['the']} ${'#'}{messages['job']} ${'#'}{messages['easier']}" />


        </#if>
<br/>
    </div>
            <p:hotkey  actionListener="${'#'}{${listName}.getFirstResult()}" bind="return">
            </p:hotkey>

    <br style="clear: both" />
 
 


 </h:form>

</ui:define>

</ui:composition>
</#if>
                                