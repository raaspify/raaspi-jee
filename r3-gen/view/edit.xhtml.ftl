<#assign tobegeneratedCandidate = "N">  
<#assign GroupOn="no">
<#assign FromCols8On="no">
<#assign TempCols2On="no">
<#assign FromCols2On="no">
<#assign TempCols1On="no">
<#assign TempCols8On="no">
<#assign GridAlreadyClosed="no">
<#assign showAddress="no">
<#assign showAddressPName="">
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#--maE=4 efS=6 efE=8 efS2=7 -->
<#assign menuAttributes = pojo.shortName?substring(0,maE)?upper_case>
<#assign menuAttributesFunction = pojo.shortName?substring(efS,efE)>
<#assign keyAutoGen="Y">
<#assign tabSeq=0>
<#include "../view/assigns/mergedassigns.properties" >
<#assign variation = "${variation}">  
<#if variation="includeaddress" >
 <#if (menuAttributes?contains("A") || menuAttributes?contains("C") || menuAttributes?contains("D") || 
  menuAttributes?contains("F") || menuAttributes?contains("J") ) >
  <#assign tobegeneratedCandidate ="Y" >
  <#assign menuAttributes = pojo.shortName?substring(efS,efS2)?upper_case>
  <#if (menuAttributes?contains("2") || menuAttributes?contains("3")||menuAttributes?contains("4") ) >
   <#assign tobegeneratedCandidate ="Y" >
  <#else>
   <#assign tobegeneratedCandidate ="N" >
  </#if>
 </#if>
</#if> 
<#if variation="quoteorderexists">
 <#if tobegeneratedCandidate ="N" && (menuAttributes?contains("T")) >
  <#assign tobegeneratedCandidate ="Y" >
  <#assign menuAttributes = pojo.shortName?substring(efS,efS2)?upper_case>
  <#if (menuAttributes?contains("2") || menuAttributes?contains("3")||menuAttributes?contains("4") ) >
   <#assign tobegeneratedCandidate ="Y" >
  <#else>
   <#assign tobegeneratedCandidate ="N" >
  </#if> 
 </#if>
</#if>
<#if (variation =" ") >
   <#assign tobegeneratedCandidate ="Y" >
</#if>

<#if tobegeneratedCandidate == "Y">                       
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign homeName = componentName + "Home">
<#assign listName = componentName + "List">
<#assign masterPageName = entityName?substring(eL) + "List">
<#assign editPageName = entityName?substring(eL) + "Edit">
<#assign pageName = entityName?substring(eL)>
<#assign menuPageName = "home">
<#assign menuAddTran = false>
<#if (entityName?length >eL) >
 <#assign menuAttributes = entityName?substring(0,maE)?upper_case>
<#else>
 <#assign entityName = "jxxxxxxxxxxxxxxxxxxx">
 <#assign menuAttributes = entityName?substring(0,maE)?upper_case>
</#if>
<#assign reportName = "reportName">
<#assign displayAs = "displayAs">
<#assign start = "start">
<#assign end = "end">
<#assign markedOnes = "markedOnes">    
<#assign  selectEntityFieldName ="gggggggggggggggggggggggggg" >
<#assign togglePanel="X">
<#assign mailaddressdone="N">
<#assign brCount=1>
<#assign size = 32>
<#assign cIndex=0>
<#assign statusFlagField="">
<#assign documentField="">
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
     <#if property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="zb" || property.name?substring(5,7)=="za"  > 
      <#assign documentField=property.name>
     </#if>   
 <#else>
    <#if menuAttributesFunction ="1t" >
     <#if property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="zb" || property.name?substring(5,7)=="za"  > 
      <#assign documentField=property.name>
     </#if>   
    </#if>
 </#if>
</#if>
</#foreach>




<#assign addressLine1="b1pxusa1bvxxxxxxxxxxaddrl1">

<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                xmlns:p="http://primefaces.org/ui"
                xmlns:pe="http://primefaces.org/ui/extensions"
                xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
                xmlns:o="http://omnifaces.org/ui"
                template="layout/rtemplate.xhtml">
  <#if (menuAttributes?contains("A") || menuAttributes?contains("C") || menuAttributes?contains("D") || menuAttributes?contains("F") || menuAttributes?contains("J") && menuAttributes?contains("T")) >
   <#assign menuAddTran = true>
  </#if>
   <ui:remove>s:defaultAction removed, eqv p:defaultCommand
     s:hasRole removed replaced w true look into calling a method
     instead of page.xml use f:template,f:viewparam
   </ui:remove>
<f:metadata>
  <#assign idName = componentName + util.upper(pojo.identifierProperty.name)>
   <#if c2j.isComponent(pojo.identifierProperty)>
    <#foreach componentProperty in pojo.identifierProperty.value.propertyIterator>
     <#assign cidName = componentName + util.upper(componentProperty.name)>
     <f:viewParam name="${cidName}" value="${'#'}{${homeName}.${idName}.${componentProperty.name}}"/>
    </#foreach>
   <#else>
    <f:viewParam name="${idName}" value="${'#'}{${homeName}.${idName}}"/>
    <#if documentField != "" >
     <f:viewParam name="useSeq" value="${'#'}{${homeName}.useSeq}"/>
    </#if>
    <#if menuAttributesFunction ="1m">
     <f:viewParam name="fromTable" value="${'#'}{${homeName}.instance.a0xxukcdlvxxxxxxxxxxfromtable}"/>
     <f:viewParam name="qualifier" value="${'#'}{${homeName}.instance.a2xxuxxxbv50xxxxxxxxqualifier}"/>
     <f:viewParam name="fromKey" value="${'#'}{${homeName}.instance.a1xxuxxxbv49xxxxxxxxfromkey}"/>
     <f:viewParam name="useSeq" value="${'#'}{${homeName}.instance.a3xxexnsbvxxxxxxxxxxsequence}"/>
     <f:viewParam name="data" value="${'#'}{${homeName}.instance.b1xxuzaxbvxxxxxxxxxxdata}"/>
    </#if>
    <#if menuAttributesFunction ="1n">
     <f:viewParam name="fromTable" value="${'#'}{${homeName}.instance.a0xxukbdlvxxxxxxxxxxfromtable}"/>
     <f:viewParam name="qualifier" value="${'#'}{${homeName}.instance.a2xxuxxxbv50xxxxxxxxqualifier}"/>
     <f:viewParam name="fromKey" value="${'#'}{${homeName}.instance.a1xxuxxxbv49xxxxxxxxfromkey}"/>
     <f:viewParam name="useSeq" value="${'#'}{${homeName}.instance.a3xxexnsbvxxxxxxxxxxsequence}"/>
    </#if>
    <#if menuAttributesFunction ="1r">
     <f:viewParam name="key" value="${'#'}{${homeName}.instance.a0xxukrdbvxxxxxxxxxxkey}"/>
    </#if>
   </#if>
    <f:viewParam name="${componentName}From" value="${'#'}{${homeName}.${componentName}From}"/>
    <f:viewAction action="${'#'}{${homeName}.restrict()}" />
    <f:viewAction action="${'#'}{${homeName}.wire()}" />
    <#--   -->
    <#if menuAttributesFunction ="56">
      <f:viewAction action="${'#'}{${homeName}.setEMailingAddress(${homeName}.getInstance().getC1xxuxxxbvxxxxxxxxxxotherid())}" />
    </#if>
    <#--   -->
    <#if menuAttributesFunction ="1f">
     <f:viewAction action="${'#'}{${homeName}.getInstance().setA0xxukxxbvxxxxxxxxxxserialno('0')}" />
    </#if>


    <#if menuAttributes?contains("T") >
     <#if menuAttributesFunction == "25">
      <ui:remove>shiptype optionsField 51 to match with dropdown list value  </ui:remove>
      <f:viewParam name="shipType" value="${'#'}{trexuq255xwwqqhxxxxxshipmentHome.instance.c2xxuxxrbv51xxxxxxxxtype}" />
      <f:viewParam name="prefix" value="${'#'}{trexuq255xwwqqhxxxxxshipmentHome.prefix}" />
      <f:viewAction action="${'#'}{trexuq255xwwqqhxxxxxshipmentHome.getInstance().setD2xxugbrbvxxxxxxxxxxbilltosameasshipto(true)}" />
     </#if>
     <#if menuAttributesFunction == "26">
      <f:viewParam name="shipType" value="${'#'}{${cuinvoiceEntityName}Home.instance.c2xxuxxrbv51xxxxxxxxshiptype}" />
     </#if>
     <#if menuAttributesFunction == "27">
      <f:viewParam name="inv" value="${'#'}{${cuinvoiceEntityName}Home.lasttrexuq266xwwqqhxxxxxcuinvoiceP}" />
     </#if>
     <#if menuAttributesFunction == "23" || menuAttributesFunction == "24" || menuAttributesFunction == "26" || menuAttributesFunction == "27" || menuAttributesFunction == "25">
      <f:viewAction action="${'#'}{${homeName}.showrunt()}"/>
      <f:viewAction action="${'#'}{${homeName}.setEMailingAddress(${homeName}.getInstance().get${customerEntityName?cap_first}().getQ4xxhxxxbv24xxxxxxxximailaddr())}" />
      <f:viewParam name="key" value="${'#'}{${itemEntityName}Home.lastfpxxfq1a5xwwqqhxxxxxitemP}"/>
     <#elseif menuAttributesFunction == "33" || menuAttributesFunction == "34" || menuAttributesFunction == "3a" || menuAttributesFunction == "38" || menuAttributesFunction == "37">
      <f:viewAction action="${'#'}{${homeName}.setEMailingAddress(${homeName}.getInstance().get${vendorEntityName?cap_first}().getN4xxhxxrbv24xxxxxxxximailaddr())}" />
      <f:viewAction action="${'#'}{${homeName}.showrunt()}"/>;
      <f:viewParam name="key" value="${'#'}{${itemEntityName}Home.lastfpxxfq1a5xwwqqhxxxxxitemP}"/>
     <#elseif menuAttributesFunction == "44" >
      <f:viewAction action="${'#'}{${homeName}.setEMailingAddress(${homeName}ByEmployee.getInstance().get${employeeEntityName?cap_first}().getN4xxhxxrbv24xxxxxxxximailaddr())}" />
      <f:viewAction action="${'#'}{${homeName}.showrunt()}"/>;
     </#if>
    </#if>
</f:metadata>
<ui:define name="title">${'#'}{customIdentity.owner2} webpage to add new ${'#'}{messages['${entityName?substring(pL)?cap_first}']}</ui:define>

<ui:define name="body">
<h:form id="${componentName}" styleClass="edit" enctype="multipart/form-data">
    <script type="text/javascript" src="./js/eval.js"></script>
    <script type="text/javascript" src="./js/fillValue.js"></script>
    <script type="text/javascript"> var jay='${'#'}{messages['Continue_with_zero_amount']}';var jay2='${'#'}{messages['use_offsetting_entry_button_first']}';</script>
    <script>
     function goBack(n) {
     window.history.go(n);return false;
     }
    </script>
    <script>
     window.onload = function(){
      document.getElementById("${componentName}:itemquantityx1").value = "1.0";
     }
    </script>

	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
              <h:button id="tdone" image="./img/home_24.png"  alt="Cancel" value="Cancel" propagation="end"  rendered="${'#'}{!${homeName}.managed}" outcome="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup>
              <h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  rendered="${'#'}{${homeName}.managed}" outcome="/home.xhtml" />
	  </p:toolbarGroup>
      <#if (menuAttributesFunction?contains("20") || menuAttributesFunction?contains("30")||menuAttributesFunction?contains("40") ) >
	  <p:toolbarGroup>
              <h:inputText value="${'#'}{${homeName}.wizardInput}" size="30" maxlength="200" 
               pt:placeholder="${'#'}{messages['Quick']} ${'#'}{messages['Tray']}, ${'#'}{messages['put']} ${'#'}{messages['FirstName']}  ${'#'}{messages['LastName']} ${'#'}{messages['Phone']}  ${'#'}{messages['house']} ${'#'}{messages['number']} ... " /> 
              <h:commandButton id="Wizardb" value="Wizard"  action="${'#'}{${homeName}.parseAndPost()}" image="/img/Go16.png" >
               <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="Put FirstName LastName Phone house number Street City ProvState postal Country space or comma separated, use - if no value and + as substitute for space in result and /L or /llastName to use LastName FirstName  "/></span> </p:tooltip> 
              </h:commandButton>
	  </p:toolbarGroup>
      </#if>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{customIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['${entityName?substring(pL)?cap_first}EditHelp']!='${entityName?substring(pL)?cap_first}EditHelp'}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['${componentName?substring(eL)?cap_first}EditHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
      <ui:remove>
       <h:messages globalOnly="true" style = "color:red;margin:8px;" styleClass="messageM" id="globalMessages"/>
      </ui:remove>
	</p:toolbar>
        <#if menuAttributesFunction ="1b" >
	<p:toolbar >
	  <p:toolbarGroup location="right">
            <h:commandButton  styleClass="buttonMain"
                          value="${'#'}{messages['Refresh_Sales_data']}" 
                         action="${'#'}{${usagebyperiodsEntityName}Home.loadSalesData()}"
                       disabled="${'#'}{${usagebyperiodsEntityName}Home.managed}"
                       rendered="${'#'}{(!${usagebyperiodsEntityName}Home.managed or ${usagebyperiodsEntityName}Home.moreActive) and !${usagebyperiodsEntityName}Home.entityDeleted}">  
                        
            </h:commandButton>    
	 <h:graphicImage id="Tel" value="/img/salesChart100x200.jpg" styleClass="pic" />
	  </p:toolbarGroup>
	</p:toolbar>
        </#if>                            			  

        <p:panel>
         <#if menuAttributesFunction ="1a" >
             <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['add']} ${'#'}{messages['new']} ${'#'}{messages['item']}, ${'#'}{messages['in']} ${'#'}{messages['general']}, ${'#'}{messages['please']} ${'#'}{messages['use']} ${'#'}{messages['the']} ${'#'}{messages['following']} ${'#'}{messages['links']} " rendered="${'#'}{customIdentity.product=='f' }"/> 
             <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['add']} ${'#'}{messages['picture']} ${'#'}{messages['or']} ${'#'}{messages['blog']} or ${'#'}{messages['case']} ${'#'}{messages['category']} or ${'#'}{messages['shopping']} ${'#'}{messages['item']}, ${'#'}{messages['in']} ${'#'}{messages['general']}, ${'#'}{messages['please']} ${'#'}{messages['use']} ${'#'}{messages['the']} ${'#'}{messages['following']} ${'#'}{messages['links']} " rendered="${'#'}{!(customIdentity.product =='f' ) and (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"/> 
             <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['add']} ${'#'}{messages['issue']}/${'#'}{messages['bug']}, ${'#'}{messages['in']} ${'#'}{messages['general']}, ${'#'}{messages['please']} ${'#'}{messages['use']} ${'#'}{messages['the']} ${'#'}{messages['following']} ${'#'}{messages['links']} " rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='b') and (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ') or customIdentity.hasRole('VH'))}"/> 
             <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['edit']}/${'#'}{messages['add']} ${'#'}{messages['theme']} ${'#'}{messages['or']} ${'#'}{messages['themeContent']} , ${'#'}{messages['please']} ${'#'}{messages['use']} ${'#'}{messages['the']} ${'#'}{messages['following']} ${'#'}{messages['links']} " rendered="${'#'}{customIdentity.masterSite and customIdentity.hasRole('PH')}"/> 
             <br></br><h:link id="SearchUpdateButton" styleClass="buttonMain"
              outcome="/imageEditEasy.xhtml" rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='s') or (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"
               style="font-size: large;color:lightblue;" value="${'#'}{messages['add']} ${'#'}{messages['image']}"/>
              <h:link id="newEntry" styleClass="buttonMain"
               outcome="/textEditEasy.xhtml" rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='s') or (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"
               value="${'#'}{messages['new']} ${'#'}{messages['blog']}"/>

              <h:link id="newEntryV" styleClass="buttonMain"
               outcome="/videoEditEasy.xhtml" rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='s') or (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"
               style="font-size: large;color:lightblue;" value="${'#'}{messages['new']} ${'#'}{messages['video']}"/>

              <h:link id="newEntryC" styleClass="buttonMain"
               outcome="/caseCatEditEasy.xhtml" rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='s') or (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"
               value="${'#'}{messages['new']} ${'#'}{messages['case']} ${'#'}{messages['category']}"/>

              <h:link id="newEntryi" styleClass="buttonMain"
               outcome="/itemEditEasy.xhtml" rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='b') and (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"
               value="${'#'}{messages['new']} ${'#'}{messages['issue']}"/>

              <h:link id="themeEdit" styleClass="buttonMain"
               outcome="/itemEditEasy.xhtml" rendered="${'#'}{customIdentity.masterSite and customIdentity.hasRole('PH')}"
               value="${'#'}{messages['edit']} ${'#'}{messages['theme']}">
                <f:param name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid}"/>
            </h:link>
              <h:link id="newtheme" styleClass="buttonMain"
               outcome="/itemEditEasy.xhtml" rendered="${'#'}{customIdentity.masterSite and customIdentity.hasRole('PH')}"
               value="${'#'}{messages['new']} ${'#'}{messages['theme']}">
            </h:link>
              <h:link id="shopE" styleClass="buttonMain"
               outcome="/itemEditEasy.xhtml" rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ') }"
               style="font-size: large;color:lightblue;" value="${'#'}{messages['shopping']} ${'#'}{messages['item']}">
            </h:link>
              <h:link id="newEntryb" styleClass="buttonMain"
               outcome="/themeCEditEasy.xhtml" rendered="${'#'}{customIdentity.masterSite and customIdentity.hasRole('PH')}"
               value="${'#'}{messages['themeContent']}">
            </h:link>

             <br></br>



             <h:outputText value="${'#'}{messages['Using']} ${'#'}{messages['the']} ${'#'}{messages['following']} ${'#'}{messages['needs']} ${'#'}{messages['more']} ${'#'}{messages['indepth']} ${'#'}{messages['knowledge']}, ${'#'}{messages['but']} ${'#'}{messages['gives']} ${'#'}{messages['more']} ${'#'}{messages['flexibility']} ${'#'}{messages['and']} ${'#'}{messages['used']} ${'#'}{messages['in']} ${'#'}{messages['specific']} ${'#'}{messages['situation']}" 
               rendered="true"/> 
             <br></br><h:outputText value="${'#'}{messages['Coming']} ${'#'}{messages['here']} ${'#'}{messages['from']} ${'#'}{messages['List']}, ${'#'}{messages['can']} ${'#'}{messages['also']} ${'#'}{messages['be']} ${'#'}{messages['used']} ${'#'}{messages['to']} ${'#'}{messages['edit']}/${'#'}{messages['delete']} ${'#'}{messages['existing']} ${'#'}{messages['item']} " rendered="true"/> 
             <br></br>
         </#if>

         <#if menuAttributesFunction ="56" >
             <h:outputText value="${'#'}{messages['You']} ${'#'}{messages['may']} ${'#'}{messages['use']} ${'#'}{messages['more']} ${'#'}{messages['fields']} ${'#'}{messages['and']} ${'#'}{messages['Picture']} + ${'#'}{messages['button']} ${'#'}{messages['to']} ${'#'}{messages['upload']} ${'#'}{messages['your']} ${'#'}{messages['profile']} ${'#'}{messages['image']} " /> 
             <br></br>
             <h:outputText value="${'#'}{messages['Other']} ${'#'}{messages['fields']} ${'#'}{messages['are']} ${'#'}{messages['not']} ${'#'}{messages['applicable']}" rendered="!(${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ')}" 
               /> 
             <br></br>
             <h:outputText value="${'#'}{messages['If']} ${'#'}{messages['creating']} ${'#'}{messages['new']} ${'#'}{messages['user']}, ${'#'}{messages['setup']} ${'#'}{messages['as']} ${'#'}{messages['employee']}/${'#'}{messages['vendor']}/${'#'}{messages['customer']}  ${'#'}{messages['first']} ${'#'}{messages['with']} ${'#'}{messages['email']} ${'#'}{messages['information']} " rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ')}" /> 
             <br></br>
             <h:outputText value="${'#'}{messages['Otherwise']}, ${'#'}{messages['later']} ${'#'}{messages['reset']} ${'#'}{messages['password']}, ${'#'}{messages['will']} ${'#'}{messages['fail']} ${'#'}{messages['to']}  ${'#'}{messages['send']} ${'#'}{messages['any']} ${'#'}{messages['email']}" rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ')}" /> 
             <br></br>
             <h:outputText value="${'#'}{messages['Enter']} ${'#'}{messages['Id']}, ${'#'}{messages['Alevel']}, ${'#'}{messages['Blevel']} ${'#'}{messages['values']}, ${'#'}{messages['Once']} ${'#'}{messages['saved']}  ${'#'}{messages['oldpw']} ${'#'}{messages['will']}  ${'#'}{messages['show']} ${'#'}{messages['generated']} ${'#'}{messages['temporary']} ${'#'}{messages['Password']} " rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ')}" /> 
             <br></br>
             <h:outputText value="${'#'}{messages['Blevel']} ${'#'}{messages['can']}, ${'#'}{messages['be']} ${'#'}{messages['further']} ${'#'}{messages['controlled']} ${'#'}{messages['using']} ${'#'}{messages['more']}  ${'#'}{messages['fields']}, ${'#'}{messages['Restrict']}  ${'#'}{messages['or']} ${'#'}{messages['Allow']}. ${'#'}{messages['Put']} ${'#'}{messages['full']} ${'#'}{messages['or']} ${'#'}{messages['partial']} ${'#'}{messages['page']} ${'#'}{messages['url']}  " rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ')}" /> 
             <br></br>
             <h:outputText value="${'#'}{messages['Example']}: ${'#'}{messages['put']}, ${'#'}{messages['ItemDetailsPOS']} ${'#'}{messages['to']} ${'#'}{messages['control']} ${'#'}{messages['POS']} ${'#'}{messages['transaction']} ${'#'}{messages['for']} ${'#'}{messages['Blevel']}  ${'#'}{messages['Low']}  " rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ')}" /> 
         </#if>

        <h:panelGrid columns="2">
        <#assign FromCols2On="yes">
        <#assign FromCols8On="no">
        <#if (entityName?length > eL)>
           <#if menuAttributesFunction ="1s">
            <f:facet name="header">${'#'}{${homeName}.managed ? 'Edit' : 'Add'} ${'#'}{messages['${entityName?substring(pL)?cap_first}']} ${'#'}{messages['row']}</f:facet>
           <#else>
            <f:facet name="header">${'#'}{${homeName}.managed ? 'Edit' : 'Add'} ${'#'}{messages['${entityName?substring(pL)?cap_first}']}</f:facet>
           </#if>

        </#if>
         <#if menuAttributesFunction ="52" >
             <h:outputText value="${'#'}{messages['To']} ${'#'}{messages['edit']} ${'#'}{messages['common']} ${'#'}{messages['fields']}, ${'#'}{messages['in']} ${'#'}{messages['general']}, ${'#'}{messages['please']} ${'#'}{messages['use']} ${'#'}{messages['the']} ${'#'}{messages['easy']} ${'#'}{messages['link']} " rendered="true"/> 
              &nbsp;&nbsp;<h:link id="config" styleClass="buttonMain"
               outcome="/clientEditEasy.xhtml" rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ') }"
               style="font-size: x-large;color:lightgreen;" value="${'#'}{messages['Easy']} ${'#'}{messages['configur']} / ${'#'}{messages['setup']}">
                <f:param name="yxxxch522xhhxxhxxxxxclientA0xxuobxbxxxxxxxxxxxsid"
                        value="${'#'}{yxxxch522xhhxxhxxxxxclientHome.yxxxch522xhhxxhxxxxxclientA0xxuobxbxxxxxxxxxxxsid==null?0:yxxxch522xhhxxhxxxxxclientHome.yxxxch522xhhxxhxxxxxclientA0xxuobxbxxxxxxxxxxxsid}"/>
              </h:link>
             <h:outputText value="${'#'}{messages['Using']} ${'#'}{messages['the']} ${'#'}{messages['following']} ${'#'}{messages['needs']} ${'#'}{messages['more']} ${'#'}{messages['indepth']} ${'#'}{messages['knowledge']}, ${'#'}{messages['but']} ${'#'}{messages['gives']} ${'#'}{messages['more']} ${'#'}{messages['flexibility']} ${'#'}{messages['and']} ${'#'}{messages['used']} ${'#'}{messages['in']} ${'#'}{messages['less']} ${'#'}{messages['common']} ${'#'}{messages['situation']}" 
               rendered="true"/> 
             <h:outputText value="${'#'}{messages['Level']}: ${'#'}{messages['debug']} ${'#'}{messages['flag']} ${'#'}{messages['ncustome']}: ${'#'}{messages['bad_user_agent']} ${'#'}{messages['contact']}: ${'#'}{messages['bad_ip']}, ${'#'}{messages['if']} ${'#'}{messages['debug']},  ${'#'}{messages['check']} ${'#'}{messages['incoming']} ${'#'}{messages['requests']} ${'#'}{messages['_and']} ${'#'}{messages['bad']} ${'#'}{messages['entries']} ${'#'}{messages['are']} ${'#'}{messages['kicked']} ${'#'}{messages['out']}" 
               rendered="${'#'}{customIdentity.owner2.equals('customIdentity.masterSiteCode')}"/> 

         </#if>

            <#if menuAttributesFunction ="5a" >
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.selectedClass}" 
              rendered="true">
              <p:ajax  />
	      <f:selectItems value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.getClassNames('all')}"   /> 
             </h:selectOneMenu>
             </h:panelGrid>
             <p:commandButton id="columnN" styleClass="buttonMain" 
                          value="${'#'}{messages['show']} ${'#'}{messages['column']} ${'#'}{messages['names']}" status="buttonStatus"  update="@form"
                         action="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.mapColumnNames('',true,false)}"
                       disabled="${'#'}{!yxxxch5a1xhhxxhxxxxxtruefalseHome.wired}"
                       rendered="${'#'}{!yxxxch5a1xhhxxhxxxxxtruefalseHome.entityDeleted }">  
             </p:commandButton>   

            </#if>
        <ui:remove>
         <p:messages ajaxRendered="true"  />
        </ui:remove>
  <p:growl id="messages" showDetail="true" sticky="true"/>
  <#assign firstTime="Y"> 
  <#assign tabPanel="N"> 
  <#assign tab="N"> 
  <#assign addressEntityAddressFieldName="a0xxukbxbvxxxxxxxxxxaddrescode">
  <#assign itemEntityItemFieldName="a0xxukixbxxxxxxxxxxxmatcode">
  <#assign itemPriceField="b8fbzpxxbvxxxxxxxxxxselprice">
  <#assign itemCostField="b6fbzicxbvxxxxxxxxxxcost">
  <#assign itemQtyField="b0xxziqxlvxxsaxxxxxxquantity">
  <#assign itemShipcode="c3fbuxscbvxxxxxxxxxxshipcode">

  <#assign employeeEntityEmployeeFieldName="a0xxuktxbvxxxxxxxxxxemployee">
  <#assign customerEntityCustomerFieldName="a0xxukxxbvxxxxxxxxxxcustomer">
  <#assign customerEntityIntegrationSetFieldName="f2xxuwmxbv42xxxxxxxxintegrset">
  <#assign customerContactEntityContactFieldName="a0xxukxxbvxxxxxxxxxxcontact">
  <#assign customerInvoiceEtcItemDetailsEntityName="xoxxuq24xxxxxxxxcupdetails">
  <#assign customerInvoiceEtcItemDetailsID1FieldName="ucdxbvxxxxxxxxxxcuqno">
  <#assign customerInvoiceEtcItemDetailsID2FieldName="zo11bvlxxxxxxxxxline">
  <#assign customerInvoiceEtcItemDetailsPriceFieldName="zpxravxxxxxxxxxxordprice">
  <#assign customerInvoiceEtcItemDetailsTax1FieldName="z1xxavxxxxxxxxxxtax1amt">
  <#assign customerInvoiceEtcItemDetailsTax2FieldName="z2xxavxxxxxxxxxxtax2amt">
  <#assign customerInvoiceEtcItemDetailsTax3FieldName="z3xxavxxxxxxxxxxtax3amt">
  <#assign customerInvoiceEtcItemDetailsUnitFieldName="uuxxbv19xxxxxxxxordunit">
  <#assign customerInvoiceEtcItemDetailsDeliveryFieldName="zlxxavxxxxxxxxxxdelivchrg">
  <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName="zmxxavxxxxxxxxxxmiscchrg">
  <#assign customerInvoiceEtcItemDetailsQtyFieldName="zqxxbvnxxxxxxxxxqtyordrd">

  <#assign customerQuoteItemDetailsEntityName="xoxxuq24xxxxxxxxcuqdetails">
  <#assign customerQuoteItemDetailsID1FieldName="a0xxucdxbvxxxxxxxxxxcuqno">
  <#assign customerQuoteItemDetailsID2FieldName="z1xxzo11bvlxxxxxxxxxline">
  <#assign customerQuoteItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign customerQuoteItemDetailsTax1FieldName="zdxxzxz1avxxxxxxxxxxtax1amt">
  <#assign customerQuoteItemDetailsTax2FieldName="zexxzxz2avxxxxxxxxxxtax2amt">
  <#assign customerQuoteItemDetailsTax3FieldName="zfxxzxz3avxxxxxxxxxxtax3amt">
  <#assign customerQuoteItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign customerQuoteItemDetailsDeliveryFieldName="zbxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign customerQuoteItemDetailsMiscelleneousFieldName="zcxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign customerQuoteItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign customerOrderItemDetailsEntityName="xoxxuq24xxxxxxxxcuodetails">
  <#assign customerOrderItemDetailsID1FieldName="a0xxucdxbvxxxxxxxxxxcuono">
  <#assign customerOrderItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign customerOrderItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign customerOrderItemDetailsTax1FieldName="zdxxzxz1avxxxxxxxxxxtax1amt">
  <#assign customerOrderItemDetailsTax2FieldName="zexxzxz2avxxxxxxxxxxtax2amt">
  <#assign customerOrderItemDetailsTax3FieldName="zfxxzxz3avxxxxxxxxxxtax3amt">
  <#assign customerOrderItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign customerOrderItemDetailsDeliveryFieldName="zbxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign customerOrderItemDetailsMiscelleneousFieldName="zcxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign customerOrderItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign customerInvoiceItemDetailsEntityName="xoxxuq24xxxxxxxxcuidetails">
  <#assign customerInvoiceItemDetailsID1FieldName="a0xxucdxbvxxxxxxxxxxcuino">
  <#assign customerInvoiceItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign customerInvoiceItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign customerInvoiceItemDetailsTax1FieldName="zdxxzxz1avxxxxxxxxxxtax1amt">
  <#assign customerInvoiceItemDetailsTax2FieldName="zexxzxz2avxxxxxxxxxxtax2amt">
  <#assign customerInvoiceItemDetailsTax3FieldName="zfxxzxz3avxxxxxxxxxxtax3amt">
  <#assign customerInvoiceItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign customerInvoiceItemDetailsDeliveryFieldName="zbxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign customerInvoiceItemDetailsMiscelleneousFieldName="zcxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign customerInvoiceItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign customerPaymentItemDetailsEntityName="xoxxuq24xxxxxxxxcupdetails">
  <#assign customerPaymentItemDetailsID1FieldName="a0xxucdxbvxxxxxxxxxxcupno">
  <#assign customerPaymentItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign customerPaymentItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign customerPaymentItemDetailsTax1FieldName="zbxxzxz1avxxxxxxxxxxtax1amt">
  <#assign customerPaymentItemDetailsTax2FieldName="zcxxzxz2avxxxxxxxxxxtax2amt">
  <#assign customerPaymentItemDetailsTax3FieldName="zdxxzxz3avxxxxxxxxxxtax3amt">
  <#assign customerPaymentItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign customerPaymentItemDetailsDeliveryFieldName="z9xxzlxxavxxxxxxxxxxdelivchrg">
  <#assign customerPaymentItemDetailsMiscelleneousFieldName="zaxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign customerPaymentItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign customerShipmentItemDetailsID1FieldName="a0xxusdxbvxxxxxxxxxxshipcode">
  <#assign customerShipmentItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign customerShipmentItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxshippingprice">
  <#assign customerShipmentItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyshipped">


  <#assign divisionEntityDivisionFieldName="a0xxukoxbvxxxxxxxxxxdivcode">
  <#assign departmentEntityDepartmentFieldName="a0xxukexbvxxxxxxxxxxdepcode">
  <#assign accountEntityAccountFieldName="a0xxukwxbvxxxxxxxxxxaccount">
  <#assign tableEntityTableFieldName="a0xxukxxbvxxxxxxxxxxtablename">
  <#assign vendorEntityVendorFieldName="a0xxukxxbvxxxxxxxxxxvendor">
  <#assign vendorContactEntityContactFieldName="a0xxukxxbvxxxxxxxxxxcontact">

  <#assign vendorInvoiceEtcItemDetailsEntityName="xoxxuq3b4xwwqqhxxxxxvendpdetails">
  <#assign vendorInvoiceEtcItemDetailsID1FieldName="uvdxbvxxxxxxxxxxvendqno">
  <#assign vendorInvoiceEtcItemDetailsID2FieldName="zo11bvlxxxxxxxxxline">
  <#assign vendorInvoiceEtcItemDetailsPriceFieldName="zpxravxxxxxxxxxxordprice">
  <#assign vendorInvoiceEtcItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign vendorInvoiceEtcItemDetailsTax2FieldName="zdxxzxz2avxxxxxxxxxxtax2amt">
  <#assign vendorInvoiceEtcItemDetailsTax3FieldName="zexxzxz3avxxxxxxxxxxtax3amt">
  <#assign vendorInvoiceEtcItemDetailsUnitFieldName="uuxxbv19xxxxxxxxordunit">
  <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName="zlxxavxxxxxxxxxxdelivchrg">
  <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign vendorInvoiceEtcItemDetailsQtyFieldName="zqxxbvnxxxxxxxxxqtyordrd">
  <#assign vendorInvoiceEtcCopyToDetailsQtyFieldName="zqxxbvnxxxxxxxxxqtyordrd">

  <#assign vendorQuoteItemDetailsEntityName="xoxxuq34xxxxxxxxvendqdetails">
  <#assign vendorQuoteItemDetailsID1FieldName="a0xxuvdxbvxxxxxxxxxxvendqno">
  <#assign vendorQuoteItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign vendorQuoteItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign vendorQuoteItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign vendorQuoteItemDetailsTax2FieldName="zdxxzxz2avxxxxxxxxxxtax2amt">
  <#assign vendorQuoteItemDetailsTax3FieldName="zexxzxz3avxxxxxxxxxxtax3amt">
  <#assign vendorQuoteItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign vendorQuoteItemDetailsDeliveryFieldName="zaxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign vendorQuoteItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign vendorQuoteItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign vendorOrderItemDetailsID1FieldName="a0xxuvdxbvxxxxxxxxxxvendono">
  <#assign vendorOrderItemDetailsID2FieldName="a1xxzo11bvlxline">
  <#assign vendorOrderItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign vendorOrderItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign vendorOrderItemDetailsTax2FieldName="zdxxzxz2avxxxxxxxxxxtax2amt">
  <#assign vendorOrderItemDetailsTax3FieldName="zexxzxz3avxxxxxxxxxxtax3amt">
  <#assign vendorOrderItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign vendorOrderItemDetailsDeliveryFieldName="zaxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign vendorOrderItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign vendorOrderItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign vendorInvoiceItemDetailsID1FieldName="a0xxuvdxbvxxxxxxxxxxvendino">
  <#assign vendorInvoiceItemDetailsID2FieldName="a1xxzo11bvlxxxxxxxxxline">
  <#assign vendorInvoiceItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign vendorInvoiceItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign vendorInvoiceItemDetailsTax2FieldName="zdxxzxz2avxxxxxxxxxxtax2amt">
  <#assign vendorInvoiceItemDetailsTax3FieldName="zexxzxz3avxxxxxxxxxxtax3amt">
  <#assign vendorInvoiceItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign vendorInvoiceItemDetailsDeliveryFieldName="zaxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign vendorInvoiceItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign vendorInvoiceItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign vendorPaymentItemDetailsID1FieldName="a0xxuvdxbvxxxxxxxxxxvendpno">
  <#assign vendorPaymentItemDetailsID2FieldName="a1xxzo11bvlxxxxxxxxxline">
  <#assign vendorPaymentItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign vendorPaymentItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign vendorPaymentItemDetailsTax2FieldName="zdxxzxz2avxxxxxxxxxxtax2amt">
  <#assign vendorPaymentItemDetailsTax3FieldName="zexxzxz3avxxxxxxxxxxtax3amt">
  <#assign vendorPaymentItemDetailsUnitFieldName="uuxxbv19xxxxxxxxordunit">
  <#assign vendorPaymentItemDetailsDeliveryFieldName="zaxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign vendorPaymentItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign vendorPaymentItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign vendorShipmentItemDetailsID1FieldName="a0xxusdxbvxxxxxxxxxxshipcode">
  <#assign vendorShipmentItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign vendorShipmentItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxshippingprice">
  <#assign vendorShipmentItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyshipped">

  <#assign employeeInvoiceEtcItemDetailsEntityName="oxxuq454xwwqqhxxxxxemplodetails">
  <#assign employeeInvoiceEtcItemDetailsID1FieldName="uvdxbvxxxxxxxxxxvendqno">
  <#assign employeeInvoiceEtcItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign employeeInvoiceEtcItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxshippingprice">
  <#assign employeeInvoiceEtcItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyshipped">

  <#assign employeeQuoteItemDetailsEntityName="xoxxuq34xxxxxxxxvendqdetails">
  <#assign employeeQuoteItemDetailsID1FieldName="a0xxuvdxbvxxxxxxxxxxvendqno">
  <#assign employeeQuoteItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign employeeQuoteItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign employeeQuoteItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign employeeQuoteItemDetailsTax2FieldName="zdxxz2xxavxxxxxxxxxxtax2amt">
  <#assign employeeQuoteItemDetailsTax3FieldName="zexxz3xxavxxxxxxxxxxtax3amt">
  <#assign employeeQuoteItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign employeeQuoteItemDetailsDeliveryFieldName="zaxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign employeeQuoteItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign employeeQuoteItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign employeeOrderItemDetailsID1FieldName="a0xxucdxbvxxxxxxxxxxemplono">
  <#assign employeeOrderItemDetailsID2FieldName="b1xxzo11bvlxxxxxxxxxline">
  <#assign employeeOrderItemDetailsPriceFieldName="z5xxzpxravxxxxxxxxxxordprice">
  <#assign employeeOrderItemDetailsTax1FieldName="zcxxzxz1avxxxxxxxxxxtax1amt">
  <#assign employeeOrderItemDetailsTax2FieldName="zdxxz2xxavxxxxxxxxxxtax2amt">
  <#assign employeeOrderItemDetailsTax3FieldName="zexxz3xxavxxxxxxxxxxtax3amt">
  <#assign employeeOrderItemDetailsUnitFieldName="z4xxuuxxbv19xxxxxxxxordunit">
  <#assign employeeOrderItemDetailsDeliveryFieldName="zaxxzlxxavxxxxxxxxxxdelivchrg">
  <#assign employeeOrderItemDetailsMiscelleneousFieldName="zbxxzmxxavxxxxxxxxxxmiscchrg">
  <#assign employeeOrderItemDetailsQtyFieldName="z3xxeqxxbvnxxxxxxxxxqtyordrd">

  <#assign miscchrgField="">
  <#assign deliveryField="">
  <#assign priceField="">
  <#assign qtyField="">
  <#assign costField="">
  <#assign tax1Field="">
  <#assign tax2Field="">
  <#assign tax3Field="">
  <#assign unitField="">
  <#assign clientVendorinField="s6xxuxvibvxxxxxxxxxxvendorinvoicen">
  <#assign clientKeyField="a0xxukxxbvxxxxxxxxxxversion">
  <#assign clientCustomerqnField="q9xxuxcqbvxxxxxxxxxxcustomerquoten">
  <#assign clientVendorqnField="t3xxuxvqbvxxxxxxxxxxvendorquoten">
  <#assign clientEmployeeqnField="">
  <#assign clientCustomeronField="r3xxuxcobvxxxxxxxxxxcustomerordern">
  <#assign clientVendoronField="r6xxuxvobvxxxxxxxxxxvendorordern">
  <#assign clientEmployeeonField="">
  <#assign clientCustomerinField="s3xxuxcibvxxxxxxxxxxcustomerinvoicen">
  <#assign clientEmployeeinField="">
  <#assign clientCustomerpnField="">
  <#assign clientVendorpnField="">
  <#assign clientEmployeepnField="">
  <#assign clientShipmentnField="">
  <#assign clientAllocateJobnField="r8xxuxjobvxxxxxxxxxxjobn">
  <#assign clientDepartmentnField="c3xxuexxbvxxxxxxxxxxndepcode">
  <#assign clientDivisionnField="c2xxuoxxbvxxxxxxxxxxndivcode">
  <#assign clientGlSeqnField="u3xxzwplbvxxxxxxxxxxglseq">
  <#assign clientArSeqnField="t6xxzwprbvxxxxxxxxxxarseq">
  <#assign pentityFunction="">
  <#assign lobkey="">
  <#assign centityName="">
  <#assign centityFieldName= "">
  <#assign keyMaxLength=19>
  <#assign keyfromclient = "N">
  <#assign wireCalled = "N">
  <#assign callCreateCdetails = "N">
  <#assign callCreateVdetails = "N">
  <#assign bycalled = "N">
  <#assign bycalled1 = "N">
  <#assign bycalled2 = "N">
  <#assign bycalled3 = "N">
  <#assign itemSelected = "N">
  <#assign keyfromsubkeys = "N">
  <#assign parentKeyName = "not assigned yet xxxxxxxxxxx">
  <#assign parentKeyName2 = "not assigned yet xxxxxxxxxxx">
  <#assign keyedKeyName = "">

  <#assign pzcodeField="">
  <#assign compositeKeyList="">
      <#assign optionField01="b1xxuo01bvxxxxxxxxxxoptions01">
      <#assign purposeField01="b2xxup01bvxxxxxxxxxxpurpose01">
      <#assign valueField01="b3xxuv01bvxxxxxxxxxxvalue01">
      <#assign optionField02="b4xxuo02bvxxxxxxxxxxoptions02">
      <#assign purposeField02="b5xxup02bvxxxxxxxxxxpurpose02">
      <#assign valueField02="b6xxuv02bvxxxxxxxxxxvalue02">
      <#assign optionField03="b7xxuo03bvxxxxxxxxxxoptions03">
      <#assign purposeField03="b8xxup03bvxxxxxxxxxxpurpose03">
      <#assign valueField03="b9xxuv03bvxxxxxxxxxxvalue03">
      <#assign optionField04="c1xxuo04bvxxxxxxxxxxoptions04">
      <#assign purposeField04="c2xxup04bvxxxxxxxxxxpurpose04">
      <#assign valueField04="c3xxuv04bvxxxxxxxxxxvalue04">
      <#assign optionField05="c4xxuo05bvxxxxxxxxxxoptions05">
      <#assign purposeField05="c5xxup05bvxxxxxxxxxxpurpose05">
      <#assign valueField05="c6xxuv05bvxxxxxxxxxxvalue05">
      <#assign optionField06="c7xxuo06bvxxxxxxxxxxoptions06">
      <#assign purposeField06="c8xxup06bvxxxxxxxxxxpurpose06">
      <#assign valueField06="c9xxuv06bvxxxxxxxxxxvalue06">
      <#assign optionField07="d1xxuo07bvxxxxxxxxxxoptions07">
      <#assign purposeField07="d2xxup07bvxxxxxxxxxxpurpose07">
      <#assign valueField07="d3xxuv07bvxxxxxxxxxxvalue07">
      <#assign optionField08="d4xxuo08bvxxxxxxxxxxoptions8">
      <#assign purposeField08="d5xxup08bvxxxxxxxxxxpurpose08">
      <#assign valueField08="d6xxuv08bvxxxxxxxxxxvalue08">
      <#assign optionField09="d7xxuo09bvxxxxxxxxxxoptions09">
      <#assign purposeField09="d8xxup09bvxxxxxxxxxxpurpose09">
      <#assign valueField09="d9xxuv09bvxxxxxxxxxxvalue09">
      <#assign optionField10="e1xxuo10bvxxxxxxxxxxoptions10">
      <#assign purposeField10="e2xxup10bvxxxxxxxxxxpurpose10">
      <#assign valueField10="e3xxuv10bvxxxxxxxxxxvalue10">
      <#assign optionField11="e4xxuo11bvxxxxxxxxxxoptions11">
      <#assign purposeField11="e5xxup11bvxxxxxxxxxxpurpose11">
      <#assign valueField11="e6xxuv11bvxxxxxxxxxxvalue11">
      <#assign optionField12="e7xxuo12bvxxxxxxxxxxoptions12">
      <#assign purposeField12="e8xxup12bvxxxxxxxxxxpurpose12">
      <#assign valueField12="e9xxuv12bvxxxxxxxxxxvalue12">
      <#assign optionField13="f1xxuo13bvxxxxxxxxxxoptions13">
      <#assign purposeField13="f2xxup13bvxxxxxxxxxxpurpose13">
      <#assign valueField13="f3xxuv13bvxxxxxxxxxxvalue13">
      <#assign optionField14="f4xxuo14bvxxxxxxxxxxoptions14">
      <#assign purposeField14="f5xxup14bvxxxxxxxxxxpurpose14">
      <#assign valueField14="f6xxuv14bvxxxxxxxxxxvalue14">
      <#assign optionField15="f7xxuo15bvxxxxxxxxxxoptions15">
      <#assign purposeField15="f8xxup15bvxxxxxxxxxxpurpose15">
      <#assign valueField15="f9xxuv15bvxxxxxxxxxxvalue15">
      <#assign optionField16="g1xxuo16bvxxxxxxxxxxoptions16">
      <#assign purposeField16="g2xxup16bvxxxxxxxxxxpurpose16">
      <#assign valueField16="g3xxuv16bvxxxxxxxxxxvalue16">
      <#assign optionField17="g4xxuo17bvxxxxxxxxxxoptions17">
      <#assign purposeField17="g5xxup17bvxxxxxxxxxxpurpose17">
      <#assign valueField17="g6xxuv17bvxxxxxxxxxxvalue17">
      <#assign optionField18="g7xxuo18bvxxxxxxxxxxoptions18">
      <#assign purposeField18="g8xxup18bvxxxxxxxxxxpurpose18">
      <#assign valueField18="g9xxuv18bvxxxxxxxxxxvalue18">
      <#assign optionField19="h1xxuo19bvxxxxxxxxxxoptions19">
      <#assign purposeField19="h2xxup19bvxxxxxxxxxxpurpose19">
      <#assign valueField19="h3xxuv19bvxxxxxxxxxxvalue19">
      <#assign optionField20="h4xxuo20bvxxxxxxxxxxoptions20">
      <#assign purposeField20="h5xxup20bvxxxxxxxxxxpurpose20">
      <#assign valueField20="h6xxuv20bvxxxxxxxxxxvalue20">
      <#assign optionField21="h7xxuo21bvxxxxxxxxxxoptions21">
      <#assign purposeField21="h8xxup21bvxxxxxxxxxxpurpose21">
      <#assign valueField21="h9xxuv21bvxxxxxxxxxxvalue21">
      <#assign optionField22="i1xxuo22bvxxxxxxxxxxoptions22">
      <#assign purposeField22="i2xxup22bvxxxxxxxxxxpurpose22">
      <#assign valueField22="i3xxuv22bvxxxxxxxxxxvalue22">
      <#assign optionField23="i4xxuo23bvxxxxxxxxxxoptions23">
      <#assign purposeField23="i5xxup23bvxxxxxxxxxxpurpose23">
      <#assign valueField23="i6xxuv23bvxxxxxxxxxxvalue23">
      <#assign optionField24="i7xxuo24bvxxxxxxxxxxoptions24">
      <#assign purposeField24="i8xxup24bvxxxxxxxxxxpurpose24">
      <#assign valueField24="i9xxuv24bvxxxxxxxxxxvalue24">
      <#assign optionField25="j1xxuo25bvxxxxxxxxxxoptions25">
      <#assign purposeField25="j2xxup25bvxxxxxxxxxxpurpose25">
      <#assign valueField25="j3xxuv25bvxxxxxxxxxxvalue25">
      <#assign optionField26="j4xxuo26bvxxxxxxxxxxoptions26">
      <#assign purposeField26="j5xxup26bvxxxxxxxxxxpurpose26">
      <#assign valueField26="j6xxuv26bvxxxxxxxxxxvalue26">
      <#assign optionField27="j7xxuo27bvxxxxxxxxxxoptions27">
      <#assign purposeField27="j8xxup27bvxxxxxxxxxxpurpose27">
      <#assign valueField27="j9xxuv27bvxxxxxxxxxxvalue27">
      <#assign optionField28="k1xxuo28bvxxxxxxxxxxoptions28">
      <#assign purposeField28="k2xxup28bvxxxxxxxxxxpurpose28">
      <#assign valueField28="k3xxuv28bvxxxxxxxxxxvalue28">
      <#assign optionField29="k4xxuo29bvxxxxxxxxxxoptions29">
      <#assign purposeField29="k5xxup29bvxxxxxxxxxxpurpose29">
      <#assign valueField29="k6xxuv29bvxxxxxxxxxxvalue29">
      <#assign optionField30="k7xxuo30bvxxxxxxxxxxoptions30">
      <#assign purposeField30="k8xxup30bvxxxxxxxxxxpurpose30">
      <#assign valueField30="k9xxuv30bvxxxxxxxxxxvalue30">
      <#assign optionField31="l1xxuo31bvxxxxxxxxxxoptions31">
      <#assign purposeField31="l2xxup31bvxxxxxxxxxxpurpose31">
      <#assign valueField31="l3xxuv31bvxxxxxxxxxxvalue31">
      <#assign optionField32="l4xxuo32bvxxxxxxxxxxoptions32">
      <#assign purposeField32="l5xxup32bvxxxxxxxxxxpurpose32">
      <#assign valueField32="l6xxuv32bvxxxxxxxxxxvalue32">
      <#assign optionField33="l7xxuo33bvxxxxxxxxxxoptions33">
      <#assign purposeField33="l8xxup33bvxxxxxxxxxxpurpose33">
      <#assign valueField33="l9xxuv33bvxxxxxxxxxxvalue33">
      <#assign optionField34="m1xxuo34bvxxxxxxxxxxoptions34">
      <#assign purposeField34="m2xxup34bvxxxxxxxxxxpurpose34">
      <#assign valueField34="m3xxuv34bvxxxxxxxxxxvalue34">
      <#assign optionField35="m4xxuo35bvxxxxxxxxxxoptions35">
      <#assign purposeField35="m5xxup35bvxxxxxxxxxxpurpose35">
      <#assign valueField35="m6xxuv35bvxxxxxxxxxxvalue35">
      <#assign optionField36="m7xxuo36bvxxxxxxxxxxoptions36">
      <#assign purposeField36="m8xxup36bvxxxxxxxxxxpurpose36">
      <#assign valueField36="m9xxuv36bvxxxxxxxxxxvalue36">
      <#assign optionField37="n1xxuo37bvxxxxxxxxxxoptions37">
      <#assign purposeField37="n2xxup37bvxxxxxxxxxxpurpose37">
      <#assign valueField37="n3xxuv37bvxxxxxxxxxxvalue37">
      <#assign optionField38="n4xxuo38bvxxxxxxxxxxoptions38">
      <#assign purposeField38="n5xxup38bvxxxxxxxxxxpurpose38">
      <#assign valueField38="n6xxuv38bvxxxxxxxxxxvalue38">
      <#assign optionField39="n7xxuo39bvxxxxxxxxxxoptions39">
      <#assign purposeField39="n8xxup39bvxxxxxxxxxxpurpose39">
      <#assign valueField39="n9xxuv39bvxxxxxxxxxxvalue39">
      <#assign optionField40="o1xxuo40bvxxxxxxxxxxoptions40">
      <#assign purposeField40="o2xxup40bvxxxxxxxxxxpurpose40">
      <#assign valueField40="o3xxuv40bvxxxxxxxxxxvalue40">
      <#assign optionField41="o4xxuo41bvxxxxxxxxxxoptions41">
      <#assign purposeField41="o5xxup41bvxxxxxxxxxxpurpose41">
      <#assign valueField41="o6xxuv41bvxxxxxxxxxxvalue41">
      <#assign optionField42="o7xxuo42bvxxxxxxxxxxoptions42">
      <#assign purposeField42="o8xxup42bvxxxxxxxxxxpurpose42">
      <#assign valueField42="o9xxuv42bvxxxxxxxxxxvalue42">
      <#assign optionField43="p1xxuo43bvxxxxxxxxxxoptions43">
      <#assign purposeField43="p2xxup43bvxxxxxxxxxxpurpose43">
      <#assign valueField43="p3xxuv43bvxxxxxxxxxxvalue43">
      <#assign optionField44="p4xxuo44bvxxxxxxxxxxoptions44">
      <#assign purposeField44="p5xxup44bvxxxxxxxxxxpurpose44">
      <#assign valueField44="p6xxuv44bvxxxxxxxxxxvalue44">
      <#assign optionField45="p7xxuo45bvxxxxxxxxxxoptions45">
      <#assign purposeField45="p8xxup45bvxxxxxxxxxxpurpose45">
      <#assign valueField45="p9xxuv45bvxxxxxxxxxxvalue45">
      <#assign optionField46="q1xxuo46bvxxxxxxxxxxoptions46">
      <#assign purposeField46="q2xxup46bvxxxxxxxxxxpurpose46">
      <#assign valueField46="q3xxuv46bvxxxxxxxxxxvalue46">
      <#assign optionField47="q4xxuo47bvxxxxxxxxxxoptions47">
      <#assign purposeField47="q5xxup47bvxxxxxxxxxxpurpose47">
      <#assign valueField47="q6xxuv47bvxxxxxxxxxxvalue47">
      <#assign optionField48="q7xxuo48bvxxxxxxxxxxoptions48">
      <#assign purposeField48="q8xxup48bvxxxxxxxxxxpurpose48">
      <#assign valueField48="q9xxuv48bvxxxxxxxxxxvalue48">
      <#assign optionField49="r1xxuo49bvxxxxxxxxxxoptions49">
      <#assign purposeField49="r2xxup49bvxxxxxxxxxxpurpose49">
      <#assign valueField49="r3xxuv49bvxxxxxxxxxxvalue49">
      <#assign optionField50="r4xxuo50bvxxxxxxxxxxoptions50">
      <#assign purposeField50="r5xxup50bvxxxxxxxxxxpurpose50">
      <#assign valueField50="r6xxuv50bvxxxxxxxxxxvalue50">
      <#assign genOptionField01="b1xxuo01bvxxxxxxxxxxgenoptions01">
      <#assign genPurposeField01="b2xxup01bvxxxxxxxxxxgenpurpose01">
      <#assign genValueField01="b3xxuv01bvxxxxxxxxxxgenvalue01">
      <#assign genOptionField02="b4xxuo02bvxxxxxxxxxxgenoptions02">
      <#assign genPurposeField02="b5xxup02bvxxxxxxxxxxgenpurpose02">
      <#assign genValueField02="b6xxuv02bvxxxxxxxxxxgenvalue02">
      <#assign genOptionField03="b7xxuo03bvxxxxxxxxxxgenoptions03">
      <#assign genPurposeField03="b8xxup03bvxxxxxxxxxxgenpurpose03">
      <#assign genValueField03="b9xxuv03bvxxxxxxxxxxgenvalue03">
      <#assign genOptionField04="c1xxuo04bvxxxxxxxxxxgenoptions04">
      <#assign genPurposeField04="c2xxup04bvxxxxxxxxxxgenpurpose04">
      <#assign genValueField04="c3xxuv04bvxxxxxxxxxxgenvalue04">
      <#assign genOptionField05="c4xxuo05bvxxxxxxxxxxgenoptions05">
      <#assign genPurposeField05="c5xxup05bvxxxxxxxxxxgenpurpose05">
      <#assign genValueField05="c6xxuv05bvxxxxxxxxxxgenvalue05">
      <#assign genOptionField06="c7xxuo06bvxxxxxxxxxxgenoptions06">
      <#assign genPurposeField06="c8xxup06bvxxxxxxxxxxgenpurpose06">
      <#assign genValueField06="c9xxuv06bvxxxxxxxxxxgenvalue06">
      <#assign genOptionField07="d1xxuo07bvxxxxxxxxxxgenoptions07">
      <#assign genPurposeField07="d2xxup07bvxxxxxxxxxxgenpurpose07">
      <#assign genValueField07="d3xxuv07bvxxxxxxxxxxgenvalue07">
      <#assign genOptionField08="d4xxuo08bvxxxxxxxxxxgenoptions08">
      <#assign genPurposeField08="d5xxup08bvxxxxxxxxxxgenpurpose08">
      <#assign genValueField08="d6xxuv08bvxxxxxxxxxxgenvalue08">
      <#assign genOptionField09="d7xxuo09bvxxxxxxxxxxgenoptions09">
      <#assign genPurposeField09="d8xxup09bvxxxxxxxxxxgenpurpose09">
      <#assign genValueField09="d9xxuv09bvxxxxxxxxxxgenvalue09">
      <#assign genOptionField10="e1xxuo10bvxxxxxxxxxxgenoptions10">
      <#assign genPurposeField10="e2xxup10bvxxxxxxxxxxgenpurpose10">
      <#assign genValueField10="e3xxuv10bvxxxxxxxxxxgenvalue10">
      <#assign genOptionField11="e4xxuo11bvxxxxxxxxxxgenoptions11">
      <#assign genPurposeField11="e5xxup11bvxxxxxxxxxxgenpurpose11">
      <#assign genValueField11="e6xxuv11bvxxxxxxxxxxgenvalue11">
      <#assign genOptionField12="e7xxuo12bvxxxxxxxxxxgenoptions12">
      <#assign genPurposeField12="e8xxup12bvxxxxxxxxxxgenpurpose12">
      <#assign genValueField12="e9xxuv12bvxxxxxxxxxxgenvalue12">
      <#assign genOptionField13="f1xxuo13bvxxxxxxxxxxgenoptions13">
      <#assign genPurposeField13="f2xxup13bvxxxxxxxxxxgenpurpose13">
      <#assign genValueField13="f3xxuv13bvxxxxxxxxxxgenvalue13">
      <#assign genOptionField14="f4xxuo14bvxxxxxxxxxxgenoptions14">
      <#assign genPurposeField14="f5xxup14bvxxxxxxxxxxgenpurpose14">
      <#assign genValueField14="f6xxuv14bvxxxxxxxxxxgenvalue14">
      <#assign genOptionField15="f7xxuo15bvxxxxxxxxxxgenoptions15">
      <#assign genPurposeField15="f8xxup15bvxxxxxxxxxxgenpurpose15">
      <#assign genValueField15="f9xxuv15bvxxxxxxxxxxgenvalue15">
      <#assign genOptionField16="g1xxuo16bvxxxxxxxxxxgenoptions16">
      <#assign genPurposeField16="g2xxup16bvxxxxxxxxxxgenpurpose16">
      <#assign genValueField16="g3xxuv16bvxxxxxxxxxxgenvalue16">
      <#assign genOptionField17="g4xxuo17bvxxxxxxxxxxgenoptions17">
      <#assign genPurposeField17="g5xxup17bvxxxxxxxxxxgenpurpose17">
      <#assign genValueField17="g6xxuv17bvxxxxxxxxxxgenvalue17">
      <#assign genOptionField18="g7xxuo18bvxxxxxxxxxxgenoptions18">
      <#assign genPurposeField18="g8xxup18bvxxxxxxxxxxgenpurpose18">
      <#assign genValueField18="g9xxuv18bvxxxxxxxxxxgenvalue18">
      <#assign genOptionField19="h1xxuo19bvxxxxxxxxxxgenoptions19">
      <#assign genPurposeField19="h2xxup19bvxxxxxxxxxxgenpurpose19">
      <#assign genValueField19="h3xxuv19bvxxxxxxxxxxgenvalue19">
      <#assign genOptionField20="h4xxuo20bvxxxxxxxxxxgenoptions20">
      <#assign genPurposeField20="h5xxup20bvxxxxxxxxxxgenpurpose20">
      <#assign genValueField20="h6xxuv20bvxxxxxxxxxxgenvalue20">

<#--
 
 original seamgen simply called editproperty.xhml.ftl for ids and non foreign fields ie not manytoone.
 For manytoone ie foreign fields edit.property showed them as links at the bottom (not drop down) and 
 was not very user friendly.
 3R extension added logic for combo box here for all forign fields (many to one) except
 the ones which are composite and needs extra handling of item foreign fields for transactions like cq,ci etc.
 The foreign fields for cq,vq etc are not handled here but in editproprty.ftl

the following copied from entityHome.ftl
 pojo ie entity has component properties for all composite key fields and entity proprties for all other fields.
 If an entity property is a foreign key then the property name will show the foreign entity not the actual field name.
 Use a filter like c2h.isManyToOne(property) and  column = property.columnIterator.next() to get the actual column name.
 or use parentPojo.identifierProperty.name to get the key field property name.
 If a persistence class has a foreign key more than once then the property name has the foreign entity plus Byxxxx to qualify
 The component properties have the identifierProperty iterator holding each key. 
 In case the key is non composite ie a single field then it will not be part of any component and will be part of properties
 Component properties seem to be tied to xxxId.java whereas non component properties are tied to xxx.java
 composite key fields declared via  Primary Key columns will appear only in component/xxId/java. If key field is a foreign 
 field then it is also declared via Foreign Key and will appear in entity properties/xxx.java. However in xxx.java
 the column name will not be shown, instead foreign Pojo class will be shown. Column iterator can be used to get
 the column name. If there are more than one fields pointing to same pojo then it will show as xxxByzz
 For those key fields which are foreign fields we need to generate validateandselect method. Currently generation 
 is hard coded by checking function of the pojo, it can be automated by xchecking component property columnname against entity ptoperty column name
 and if match the entity property name will be the pojo which needs to be validated and selected.
 jay The above may be replaced by using parentPojo.identifierProperty.name
 The same logic can be used in editproperty.ftl to automate puting validateandSelect method call  


-->
<#-- 
 original seam gem simply called editproperty.xhml.ftl for ids and non foreign fields ie not manytoone.
 For manytoone ie foreign fields edit.property showed them as links at the bottom (not drop down) and 
 was not very user friendly.
 3R extension added logic for combo box here for some foreign fields , it should be removed and editproperty 
 should have logic to cover all forign fields to have combo box. Jay investigate whether if foreign fields
 are part of the key then they are still handled here as drop box.

-->

<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
   </#foreach>
  </#if>
 </#if>
</#foreach>

<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if property.name?substring(pfS,pfE)=="zf"> 
      <#assign statusFlagField=property.name>
 </#if>   
 <#if property.name?substring(0,1) == "y" || property.name?substring(0,1) == "z"   >
  <#assign togglePanel="Y">
 </#if>
 <#if c2j.isComponent(property)>
  <#foreach componentProperty in property.value.propertyIterator>
  <#if (componentProperty.name?length > eL)>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
     <#-- jay edit component doing nothing except make KeyList here to be used for filtering later to skip foreign column
        in composite keys, they are handled in editproperty.ftl,  getsignids ${ids}  comppropname ${componentProperty.name} 
     -->
   <#assign compositeKeyList= compositeKeyList+componentProperty.name?substring(pL) >
  </#if>
  </#foreach>
 <#else>
  <#if c2h.isManyToOne(property) >
  <#-- 1st check for tabpanel creation ie manytoone ie foreign ${property.name} pentityfn ${pentityFunction} -->
   <#if tabPanel = "N">
     <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="va"
           || pentityFunction=="eo"  || pentityFunction=="cp"  || pentityFunction=="vp"    ) 
             || pentityFunction=="sh"  || pentityFunction=="sv" || menuAttributesFunction ="1b" > 
     <h:panelGrid columns="2">
     </#if>    
     <#if menuAttributesFunction ="1a" >
       <p:tabView switchType="client"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
     <#else>
       <p:tabView switchType="client" >
       <#if menuAttributesFunction ="54" >
        <h3>${'#'}{messages['Select']} ${'#'}{messages['Group']}/${'#'}{messages['Team']} ${'#'}{messages['first']}, ${'#'}{messages['then']} ${'#'}{messages['select']} ${'#'}{messages['one']} ${'#'}{messages['or']} ${'#'}{messages['more']} ${'#'}{messages['from']} ${'#'}{messages['others']}</h3>
       </#if>
     </#if>
    <#assign tabPanel="Y"> 
   </#if>
    <#--
    count how many elements are under a tab and insert that many <br/> for each tab so that all the related elements are within tab panel
    -->
    <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
    <#assign parentName = util.lower(parentPojo.shortName)>
    <#foreach parentProperty in parentPojo.allPropertiesIterator>
    <#if (parentProperty.name?length > eL)>
     <#-- jay manytoone ie only foreign properties here rest in editproperty.ftl, parentName ${parentName} parentpojoid ${parentPojo.identifierProperty.name} parentPropName ${parentProperty.name} -->
     <#if !c2h.isCollection(parentProperty) && !c2h.isManyToOne(parentProperty)>
      <#if parentPojo.isComponent(parentProperty)>
       <#-- extract the property whose value is keyed in among the composite keys to show in combo box -->
       <#assign parentKeyName="not initialized zzzzzzzzzzzzzzxxxx">
       <#assign parentKeyName2="not initialized zzzzzzzzzzzzzzxxxx">
       <#foreach componentProperty in parentProperty.value.propertyIterator>
        <#if componentProperty.name?? && componentProperty.name?length > eL && componentProperty.name.substring(pkS,pkE)= "k" || componentProperty.name.substring(pkS,pkE)= "n">
         <#assign parentKeyName =  "id."+componentProperty.name >
        <#else>
         <#-- jay composite componentProperty ${componentProperty} parentKeyName ${parentKeyName} -->
         <#assign parentKeyName2 =  "id."+componentProperty.name >
        </#if> 
       </#foreach>
      <#else>
       <#if (parentProperty.name?length > pL) >
         <#-- jay notcomposite ppn   ${parentProperty.name} ppid ${parentPojo.identifierProperty.name} -->
        <#if keyAutoGen == "Y" >
         <#if parentProperty.name.substring(pkS,pkE)= "k" || parentProperty.name.substring(pkS,pkE)= "n">
          <#assign parentKeyName =  parentProperty.name >
          <#-- jay notcomposite parentKeyName ${parentKey
         <#else> 
          <#if parentProperty.name.equals(parentPojo.identifierProperty.name)>
           <#assign parentKeyName =  parentProperty.name >
           <#-- jay notcomposite parentKeyName ${parentKeyName} -->
          </#if>
         </#if>
        </#if>
       </#if>
     </#if>
     <#if c2h.isManyToOne(parentProperty)>
      <#assign parentParentPojo = c2j.getPOJOClass(cfg.getClassMapping(parentProperty.value.referencedEntityName))>
      <#if parentParentPojo.isComponent(parentParentPojo.identifierProperty)>
       <#foreach componentProperty in parentParentPojo.identifierProperty.value.propertyIterator>
       </#foreach>
      <#else>
      </#if>
     </#if>
    </#if>
    </#foreach>
    <#-- end of count elements under tab, jay compokeylist ${compositeKeyList} parentKeyName ${parentKeyName}  -->
    <#if (property.name?length > pL) >
     <#-- cont foreign fields, jay entityfunc ${property.name} -->
     <#if property.name?substring(pkS,pkE)=="n" || property.name?substring(pkS,pkE)=="k">
      <#assign pentityFunction = property.name?substring(pefS,pefE)>
      <#assign keyedKeyName=property.name>
     </#if>
     <#-- jay2 foreign fields entityfunc ${pentityFunction} -->
      <#if pentityFunction=="cp">
       <#assign customerInvoiceEtcItemDetailsEntityName=cupdetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerPaymentItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerPaymentItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerPaymentItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerPaymentItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerPaymentItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerPaymentItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerPaymentItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerPaymentItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerPaymentItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerPaymentItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="vp">
       <#assign vendorInvoiceEtcItemDetailsEntityName=vendpdetailsEntityName>
       <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorPaymentItemDetailsID1FieldName>
       <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorPaymentItemDetailsID2FieldName>
       <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorPaymentItemDetailsPriceFieldName>
       <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorPaymentItemDetailsTax1FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorPaymentItemDetailsTax2FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorPaymentItemDetailsTax3FieldName>
       <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorPaymentItemDetailsUnitFieldName>
       <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorPaymentItemDetailsDeliveryFieldName>
       <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorPaymentItemDetailsMiscelleneousFieldName>
       <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorPaymentItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="cq">
       <#assign customerInvoiceEtcItemDetailsEntityName=cuqdetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="co">
       <#assign customerInvoiceEtcItemDetailsEntityName=cuodetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerOrderItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerOrderItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerOrderItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerOrderItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerOrderItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerOrderItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerOrderItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerOrderItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerOrderItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerOrderItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="ci">
       <#assign customerInvoiceEtcItemDetailsEntityName=cuidetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerInvoiceItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerInvoiceItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerInvoiceItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerInvoiceItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerInvoiceItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerInvoiceItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerInvoiceItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerInvoiceItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerInvoiceItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerInvoiceItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="sh">
       <#assign customerInvoiceEtcItemDetailsEntityName=shipmentdetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerShipmentItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerShipmentItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerShipmentItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerShipmentItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="ij">
       <#assign customerInvoiceEtcItemDetailsEntityName=cuqdetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="aj">
       <#assign customerInvoiceEtcItemDetailsEntityName=cuqdetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="vq">
       <#assign vendorInvoiceEtcItemDetailsEntityName=vendqdetailsEntityName>
       <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorQuoteItemDetailsID1FieldName>
       <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorQuoteItemDetailsID2FieldName>
       <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorQuoteItemDetailsPriceFieldName>
       <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorQuoteItemDetailsTax1FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorQuoteItemDetailsTax2FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorQuoteItemDetailsTax3FieldName>
       <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorQuoteItemDetailsUnitFieldName>
       <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorQuoteItemDetailsDeliveryFieldName>
       <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorQuoteItemDetailsMiscelleneousFieldName>
       <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorQuoteItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="vo">
       <#assign vendorInvoiceEtcItemDetailsEntityName=vendodetailsEntityName>
       <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorOrderItemDetailsID1FieldName>
       <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorOrderItemDetailsID2FieldName>
       <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorOrderItemDetailsPriceFieldName>
       <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorOrderItemDetailsTax1FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorOrderItemDetailsTax2FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorOrderItemDetailsTax3FieldName>
       <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorOrderItemDetailsUnitFieldName>
       <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorOrderItemDetailsDeliveryFieldName>
       <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorOrderItemDetailsMiscelleneousFieldName>
       <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorOrderItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="vi">
       <#assign vendorInvoiceEtcItemDetailsEntityName=vendidetailsEntityName>
       <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorInvoiceItemDetailsID1FieldName>
       <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorInvoiceItemDetailsID2FieldName>
       <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorInvoiceItemDetailsPriceFieldName>
       <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorInvoiceItemDetailsTax1FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorInvoiceItemDetailsTax2FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorInvoiceItemDetailsTax3FieldName>
       <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorInvoiceItemDetailsUnitFieldName>
       <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorInvoiceItemDetailsDeliveryFieldName>
       <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorInvoiceItemDetailsMiscelleneousFieldName>
       <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorInvoiceItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="sv">
       <#assign vendorInvoiceEtcItemDetailsEntityName=vshipmendetailsEntityName>
       <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorShipmentItemDetailsID1FieldName>
       <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorShipmentItemDetailsID2FieldName>
       <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorShipmentItemDetailsPriceFieldName>
       <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorShipmentItemDetailsQtyFieldName>
      </#if>
      <#if pentityFunction=="eo">
       <#assign employeeInvoiceEtcItemDetailsEntityName=emplodetailsEntityName>
       <#assign employeeInvoiceEtcItemDetailsID1FieldName=employeeOrderItemDetailsID1FieldName>
       <#assign employeeInvoiceEtcItemDetailsID2FieldName=employeeOrderItemDetailsID2FieldName>
       <#assign employeeInvoiceEtcItemDetailsPriceFieldName=employeeOrderItemDetailsPriceFieldName>
       <#assign employeeInvoiceEtcItemDetailsTax1FieldName=employeeOrderItemDetailsTax1FieldName>
       <#assign employeeInvoiceEtcItemDetailsTax2FieldName=employeeOrderItemDetailsTax2FieldName>
       <#assign employeeInvoiceEtcItemDetailsTax3FieldName=employeeOrderItemDetailsTax3FieldName>
       <#assign employeeInvoiceEtcItemDetailsUnitFieldName=employeeOrderItemDetailsUnitFieldName>
       <#assign employeeInvoiceEtcItemDetailsDeliveryFieldName=employeeOrderItemDetailsDeliveryFieldName>
       <#assign employeeInvoiceEtcItemDetailsMiscelleneousFieldName=employeeOrderItemDetailsMiscelleneousFieldName>
       <#assign employeeInvoiceEtcItemDetailsQtyFieldName=employeeOrderItemDetailsQtyFieldName>
      </#if>
    </#if>
    <#if (property.name?length > eL) >
     <#-- below extra logic for include addre ,jay do check location of By to weed out real column name with By in it --> 
     <#if (parentKeyName?length > pL) && (property.name?length > 8)  && !(parentKeyName?substring(0,3) = "id.") >
      <#if variation="includeaddress" && mailaddressdone="N" >
         <#assign showAddress="yes">
         <#assign showAddressPName=property.name>
         <#assign mailaddressdone="Y">
          <#-- use the brcount along with mailaddressdone value for each parent tabs -->
      <#elseif (parentKeyName?length > pL) && variation !="includeaddress" && property.name?contains("By") && variation !="quoteorderexists">
       <#-- 1st check for tab ie foreign fields containing By like address but not incudeaddress and not quoteorderexists           ${property.name} -->
       <#-- jay add input boxes for address if parentName is Address  -->   
       <#-- jay add logic to make ship code reqd for shipment and vship, suggest is called if only keyvalues and getSuggestList if whole list  -->
       <#-- check for db or hb in 5,7  also add create address logic in entityhome persist if addressinfo switch on-->
       <#--  if transantion like shipment etc do not show non transaction entities like address etc since they are not relevant for copy n save, not true  carrier and shipper is relevant --> 
       <#if (!property.name?contains('ByAgent') && pentityFunction!="sh") || (pentityFunction=="sh" && property.name?contains('vendorBy')  )>
        <#-- shipment do not show selecting address, validation of customer should check for empty address but include shipper             and carrier -->  
        <#-- no tab rendered can cause nullpointer on the p:tabViewl 
            so manual logic added to hide some foreign fields if empty   
        --> 
       <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}" rendered="true">
       <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml">
        <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']} 
        </ui:define>
                <p:remoteCommand name="${property.name}Function" process="@all" update="@none" />
                <p:selectOneMenu styleClass="autoCompleteWidth50"  
                 rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   <#if (pentityFunction=="sh" || pentityFunction=="sv") >
                    <#if property.name?contains('ByBill') || property.name?contains('ByCarrier')  >
                     required="false"
                    <#else>
                     <#if (pentityFunction=="sv")>
                      required="false"
                     <#else>
                      required="true"
                      label="${property.name?substring(pL)}"
                     </#if> 
                    </#if>
                    requiredMessage="${'#'}{messages['${property.name?substring(pL)?cap_first}']} ${'#'}{messages['ValueRequired']}"
                   <#elseif (pentityFunction=="eo") >
                      required="true"
                      label="${property.name?substring(pL)}"
                   </#if> 
                   validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}${property.name?substring(pL)}}" 
                   value="${'#'}{${parentName}Home.last${parentName}P}"
                 > 
                 <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                 <f:selectItems value="${'#'}{${parentName}List.suggest(' ')}" var="result"
                 itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                </p:selectOneMenu>
       </ui:decorate>
       <br/>
          <#-- if 20,30,40 put collapsible panel for new address as alternative to using existing address or allow
            entering new address values if none suitable exists
          -->
        <#if (property.name?contains('ByMailto') && menuAttributesFunction?contains("20") || menuAttributesFunction?contains("30") || menuAttributesFunction?contains("40"))>
         <p:panel header="${'#'}{messages['Address']}" toggleable="true" toggleableHeader="true"
             leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
         <ui:decorate id="l1" template="layout/edit.xhtml">
          <ui:define name="label">Address Line1 
          </ui:define>
          <h:inputText id="${property.name}addrl1" 
                          size="35"
                     maxlength="35"
                         value="${'#'}{${homeName}.addrL1}">
          </h:inputText>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="l2" template="layout/edit.xhtml">
          <ui:define name="label">Address Line2 
          </ui:define>
          <h:inputText id="${property.name}addrl2" 
                          size="35"
                     maxlength="35"
                         value="${'#'}{${homeName}.addrL2}">
          </h:inputText>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="city" template="layout/edit.xhtml">
          <ui:define name="label">City 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.city}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${property.name}CityI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','11').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','11').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',11)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${property.name}CityI" value="${'#'}{${homeName}.city}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="prov" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['Provnstate']} 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.provstate}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${property.name}provstateI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','12').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','12').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',12)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${property.name}provstateI" value="${'#'}{${homeName}.provstate}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="pz" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['Pzcode']} 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.pzcode}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${property.name}pzcodeI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','14').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','14').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',14)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${property.name}pzcodeI" value="${'#'}{${homeName}.pzcode}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
                        <#--
                           <f:validateRegex pattern="^$|(^(?i)^[a-z0-9][a-z0-9\\-]{0,10}[a-z0-9]$)"/>
                        -->
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="cntry" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['Country']} 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.country}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${property.name}countryI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','13').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','13').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',13)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${property.name}countryI" value="${'#'}{${homeName}.country}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
          <#assign brCount=1>
         </ui:decorate>
         </p:panel>
        </#if>
       </p:tab>
       </#if>
      <#elseif variation =="quoteorderexists" && property.name?contains("By")>
       <#-- copynsave and same foreignfield more than once , for shipment we need carrier/shipper  ${property.name} -->
       <#if (parentKeyName?length > pL) && (pentityFunction=="sh" && property.name?contains('vendorBy'))>
       <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}" rendered="true">
       <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml">
        <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']} 
        </ui:define>
                <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
                <p:selectOneMenu styleClass="autoCompleteWidth50"  
                 rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   <#if (pentityFunction=="sh" || pentityFunction=="sv") >
                    <#if property.name?contains('ByBill') || property.name?contains('ByCarrier')  >
                     required="false"
                    <#else>
                     <#if (pentityFunction=="sv")>
                      required="false"
                     <#else>
                      required="true"
                      label="${property.name?substring(pL)}"
                     </#if> 
                    </#if>
                    requiredMessage="${'#'}{messages['${property.name?substring(pL)?cap_first}']} ${'#'}{messages['ValueRequired']}"
                   <#elseif (pentityFunction=="eo") >
                      required="true"
                      label="${property.name?substring(pL)}"
                   </#if> 
                   validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}${property.name?substring(pL)}}" 
                   value="${'#'}{${parentName}Home.last${parentName}P}"
                 > 
                 <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                 <f:selectItems value="${'#'}{${parentName}List.suggest(' ')}" var="result"
                 itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
                </p:selectOneMenu>
       </ui:decorate>
       <br/>
       </p:tab>
       </#if>
      <#elseif (pojo.getGetterSignature(property)?length > pL) && !property.name?contains("By")>
        <#-- 2nd check not by but can be incudeaddress and quoteorderexists key property of foreign parent ${parentKeyName} key           field ${parentPojo.identifierProperty.name} -->
       <#if variation ="quoteorderexists" >
        <#-- 2nd check a non By foreign fld under extended -->
           <#-- jay add new spin box to select lines if multi line existing cq/co etc  -->
        <#-- ${pojo.getGetterSignature(property)?substring(3)}  -->
        <#if keyAutoGen == "Y" >
        <#else>
         <#if pojo.identifierProperty.name?contains("id") && pojo.isComponent(pojo.identifierProperty)>
          <#assign parentKeyName = pojo.getGetterSignature(property)?substring(3) >
         <#else>
          <#assign parentKeyName = parentPojo.identifierProperty.name >
         </#if>
        </#if>
        <#if (parentName?length > pL && parentKeyName?length >eL) && parentKeyName?substring(pefS,pefE) == "cq" ||  parentKeyName?substring(pefS,pefE) == "co" ||  parentKeyName?substring(pefS,pefE) == "ci" ||  parentKeyName?substring(pefS,pefE) == "cp"   ||  parentKeyName?substring(pefS,pefE) == "vq" ||  parentKeyName?substring(pefS,pefE) == "vo" ||  parentKeyName?substring(pefS,pefE) == "vi"  ||  parentKeyName?substring(pefS,pefE) == "sh" ||  parentKeyName?substring(pefS,pefE) == "sv"     > 
         <#--  do not show non transaction entities like customer etc since they are not relevant for copy n save
               changed rendered=true to avoid p:panel with empty tab causing xhtml issue  --> 
          <h:outputText value="${'#'}{messages['${parentName?substring(eL)}']} - ${'#'}{messages['no']} ${'#'}{messages['data']} ${'#'}{messages['to']} ${'#'}{messages['select']}" rendered="${'#'}{${parentName}List.getSuggestList('0').isEmpty()}" />
         <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}" rendered="true">
          <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml" >
          <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']} 
          </ui:define>
                <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
                <p:selectOneMenu styleClass="autoCompleteWidth50"  
                 <#if pentityFunction=="cp">
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                 <#else>
                  rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                 </#if>
                    <#if (pentityFunction=="sh" || pentityFunction=="sv") && (parentName?contains('invoice') || property.name?contains('order'))  >
                     required="false"
                    <#else>
                     required="false" 
                       label="${property.name?substring(pL)}"
                    </#if>
                    requiredMessage="${'#'}{messages['${property.name?substring(pL)?cap_first}']} ${'#'}{messages['ValueRequired']}"
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(eL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                 <#if parentKeyName?substring(pefS,pefE) == "cq" > 
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "co">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "ci">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "sh">
                   var ="result"  layout="table"  
                 <#elseif parentKeyName?substring(pefS,pefE) == "vq">
                   var ="result"  
                 <#elseif parentKeyName?substring(pefS,pefE) == "vo">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "vi">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "sv">
                   var ="result"   
                 <#else>
                   var ="result"   
                 </#if>
                   value="${'#'}{${parentName}Home.last${parentName}P}"
                 > 
                 <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                 <#if (menuAttributesFunction?contains("25") && parentKeyName?substring(pefS,pefE) == "co")>
                  <#-- ordered or paid in case shopping cart -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList(trexuq255xwwqqhxxxxxshipmentHome.prefix)}" var="result"
                 <#elseif (menuAttributesFunction?contains("25") && parentKeyName?substring(pefS,pefE) == "ci")>
                  <#-- invoiced only once shipped becomes shipped or paid later -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('I')}" var="result"
                 <#elseif (menuAttributesFunction?contains("27") && parentKeyName?substring(pefS,pefE) == "ci")>
                  <#-- invoiced only once shipped becomes shipped or paid later -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('NCI')}" var="result"
                 <#elseif (menuAttributesFunction?contains("38") && parentKeyName?substring(pefS,pefE) == "vi")>
                  <#-- invoiced only once shipped becomes shipped or paid later -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('NCI')}" var="result"
                 <#elseif (menuAttributesFunction?contains("37") && parentKeyName?substring(pefS,pefE) == "vo")>
                  <#-- invoiced only once shipped becomes shipped or paid later -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('OPNS')}" var="result"
                 <#else>
                  <#-- jay put more filter here any not closed,  cp and vp does not have copy to so no entry below -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('NCNINP')}" var="result"
                 </#if>
                 <#if parentKeyName?substring(pefS,pefE) == "cq" > 
                  itemValue="${'#'}{result.a0xxuncqbvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxuncqbvxxxxxxxxxxpurchsno">
                  <#assign amountTotName="z1xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "co">
                  itemValue="${'#'}{result.a0xxuncobvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxuncobvxxxxxxxxxxpurchsno">
                  <#assign amountTotName="z1xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "ci">
                  itemValue="${'#'}{result.a0xxuncibvxxxxxxxxxxinvoice}"
                  <#assign parentNatKey="a0xxuncibvxxxxxxxxxxinvoice">
                  <#assign amountTotName="z1xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "sh">
                  itemValue="${'#'}{result.a0xxunshbvxxxxxxxxxxshipcode}"
                  <#assign parentNatKey="a0xxunshbvxxxxxxxxxxshipcode">
                  <#assign amountTotName="z1xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "vq" > 
                  itemValue="${'#'}{result.a0xxunvqbvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxunvqbvxxxxxxxxxxpurchsno">
                  <#assign amountTotName="z1xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "vo">
                  itemValue="${'#'}{result.a0xxunvobvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxunvobvxxxxxxxxxxpurchsno">
                  <#assign amountTotName="z1xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "vi">
                  itemValue="${'#'}{result.a0xxunvibvxxxxxxxxxxinvoice}"
                  <#assign parentNatKey="a0xxunvibvxxxxxxxxxxinvoice">
                  <#assign amountTotName="b3xxztprlxxxxxxxxxxxamounttotal">
                 <#elseif parentKeyName?substring(pefS,pefE) == "sv">
                  itemValue="${'#'}{result.a0xxuksvbvxxxxxxxxxxshipcode}"
                  <#assign parentNatKey="a0xxuksvbvxxxxxxxxxxshipcode">
                  <#assign amountTotName="b5xxztprlxxxxxxxxxxxamounttotal">
                 <#else>
                  itemValue="${'#'}{result.unknown}"
                 </#if>
     
                 <#if parentKeyName?substring(pefS,pefS2)?contains("c") || parentKeyName?substring(pefS,pefE) == "sh" > 
                 itemLabel="${'#'}{result.${parentNatKey}.concat('/').concat(result.${amountTotName}).concat('/').concat(result.${itemEntityName}.b1xxuszsbvxxxxxxxxxxdescript).concat('/').concat(
                  result.${customerEntityName}.${customerLastName}).concat('/').concat(
                   result.${customerEntityName}.${customerCompanyName})}"
                 <#elseif parentKeyName?substring(pefS,pefS2)?contains( "v") || parentKeyName?substring(pefS,pefE) == "sv" > 
                 itemLabel="${'#'}{result.${parentNatKey}.concat('/').concat(result.${amountTotName}).concat('/').concat(result.${itemEntityName}.b1xxuszsbvxxxxxxxxxxdescript).concat('/').concat(
                  result.${vendorEntityName}.${vendorLastName}).concat('/').concat(
                   result.${vendorEntityName}.${vendorCompanyName})}"
                 </#if>
                  />
                </p:selectOneMenu>
          </ui:decorate>
          ${'#'}{messages['${property.name?substring(pL)?cap_first}']} [${'#'}{messages['closed']}]
                <p:selectOneMenu styleClass="autoCompleteWidth50"  
                 rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    <#if (pentityFunction=="sh" || pentityFunction=="sv") && (parentName?contains('invoice') || property.name?contains('order'))  >
                     required="false"
                    <#else>
                     required="false" 
                       label="${property.name?substring(pL)}"
                    </#if>
                    requiredMessage="${'#'}{messages['${property.name?substring(pL)?cap_first}']} ${'#'}{messages['ValueRequired']}"
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(eL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                 <#if parentKeyName?substring(pefS,pefE) == "cq" > 
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "co">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "ci">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "sh">
                   var ="result"  layout="table"  
                 <#elseif parentKeyName?substring(pefS,pefE) == "vq">
                   var ="result"  
                 <#elseif parentKeyName?substring(pefS,pefE) == "vo">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "vi">
                   var ="result"   
                 <#elseif parentKeyName?substring(pefS,pefE) == "sv">
                   var ="result"   
                 <#else>
                   var ="result"   
                 </#if>
                   value="${'#'}{${parentName}Home.last${parentName}P}"
                 > 
                 <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                 <#if (menuAttributesFunction?contains("25") && parentKeyName?substring(pefS,pefE) == "co")>
                  <#-- ordered or paid in case shopping cart -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('C')}" var="result"
                 <#else>
                  <#-- jay put more filter here any not closed -->
                  <f:selectItems value="${'#'}{${parentName}List.getSuggestList('C')}" var="result"
                 </#if>
                 <#if parentKeyName?substring(pefS,pefE) == "cq" > 
                  itemValue="${'#'}{result.a0xxuncqbvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxuncqbvxxxxxxxxxxpurchsno">
                 <#elseif parentKeyName?substring(pefS,pefE) == "co">
                  itemValue="${'#'}{result.a0xxuncobvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxuncobvxxxxxxxxxxpurchsno">
                 <#elseif parentKeyName?substring(pefS,pefE) == "ci">
                  itemValue="${'#'}{result.a0xxuncibvxxxxxxxxxxinvoice}"
                  <#assign parentNatKey="a0xxuncibvxxxxxxxxxxinvoice">
                 <#elseif parentKeyName?substring(pefS,pefE) == "sh">
                  itemValue="${'#'}{result.a0xxunshbvxxxxxxxxxxshipcode}"
                  <#assign parentNatKey="a0xxunshbvxxxxxxxxxxshipcode">
                 <#elseif parentKeyName?substring(pefS,pefE) == "vq" > 
                  itemValue="${'#'}{result.a0xxunvqbvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxunvqbvxxxxxxxxxxpurchsno">
                 <#elseif parentKeyName?substring(pefS,pefE) == "vo">
                  itemValue="${'#'}{result.a0xxunvobvxxxxxxxxxxpurchsno}"
                  <#assign parentNatKey="a0xxunvobvxxxxxxxxxxpurchsno">
                 <#elseif parentKeyName?substring(pefS,pefE) == "vi">
                  itemValue="${'#'}{result.a0xxunvibvxxxxxxxxxxinvoice}"
                  <#assign parentNatKey="a0xxunvibvxxxxxxxxxxinvoice">
                 <#elseif parentKeyName?substring(pefS,pefE) == "sv">
                  itemValue="${'#'}{result.a0xxuksvbvxxxxxxxxxxshipcode}"
                  <#assign parentNatKey="a0xxuksvbvxxxxxxxxxxshipcode">
                 <#else>
                  itemValue="${'#'}{result.unknown}"
                 </#if>
                 <#if parentKeyName?substring(pefS,pefS2)?contains("c") || parentKeyName?substring(pefS,pefE) == "sh" > 
                 itemLabel="${'#'}{result.${parentNatKey}.concat('/').concat(result.${amountTotName}).concat('/').concat(result.${itemEntityName}.b1xxuszsbvxxxxxxxxxxdescript).concat('/').concat(
                  result.${customerEntityName}.${customerLastName}).concat('/').concat(
                   result.${customerEntityName}.${customerCompanyName})}"
                 <#elseif parentKeyName?substring(pefS,pefS2)?contains( "v") || parentKeyName?substring(pefS,pefE) == "sv" > 
                 itemLabel="${'#'}{result.${parentNatKey}.concat('/').concat(result.${amountTotName}).concat('/').concat(result.${itemEntityName}.b1xxuszsbvxxxxxxxxxxdescript).concat('/').concat(
                  result.${vendorEntityName}.${vendorLastName}).concat('/').concat(
                   result.${vendorEntityName}.${vendorCompanyName})}"
                 </#if>
                  />
                </p:selectOneMenu>
          <br/>
          <ui:remove>  added vq-sv to hide qtyord </ui:remove>
         <#if  menuAttributesFunction == "27" && (property.name=customerEntityName || variation="quoteorderexists") > 
          <h:panelGroup>
             <ui:decorate id="amtinlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Amount In ${'#'}{authenticator.currencySymbol}
             </ui:define>
                <#-- for inputtext ajax use keyup so that value is selected after it is entered   blur or keypress not reliable -->
        	 <h:inputText id="amtIn" value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}"  
                 onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}}:this.value;"
                 disabled="false" >
                 <#if menuAttributesFunction ="1b" >
                 <p:ajax listener = "${'#'}{${homeName}.recalculateThis}"  event="keyup" update="@form" />
                 <#else>
                 <p:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="keyup" update="@form" />
                 </#if>
                 <f:convertNumber  maxFractionDigits="2" minFractionDigits="0" />
             </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
          </h:panelGroup>
         </#if>
      <#if menuAttributesFunction == "38" &&  (property.name=vendorEntityName || variation="quoteorderexists") > 
       <h:panelGroup>
             <ui:decorate id="amtinlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Amount In ${'#'}{authenticator.currencySymbol}
             </ui:define>
        	 <h:inputText id="amtIn" value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}"  
                 onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}}:this.value;"
                 disabled="false" >
                 <f:convertNumber minFractionDigits="0" maxFractionDigits="2"  />
                 <p:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="blur" update="@form" />
             </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
          </h:panelGroup>
         </#if>


          <#if (parentName?length > pL) && pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="sh" 
            || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="sv" > 
            <#-- if txn copy from then pentityFunction will be "" because no key,hide qty by render , if needed change via update for each line  -->
            <h:panelGroup  template="layout/edit.xhtml" rendered="false">
            <ui:define name="label">${parentName?substring(pL)} ${'#'}{messages['Qtyordrd']}
            </ui:define>
                <h:inputText  
                          value="${'#'}{empty ${componentName}Home.instance.${itemEntityName}.tempQuantity ?1.0:${componentName}Home.instance.${itemEntityName}.tempQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}:this.value;"
                           size="21">
                </h:inputText>
            </h:panelGroup>
           <#-- no qty involved  -->
          <#elseif pentityFunction=="cp">
          <#elseif pentityFunction=="vp">
          <#else>
            <ui:decorate  template="layout/edit.xhtml" >
             <ui:define name="label">${'#'}{messages['Qtyordrd']}
             </ui:define>
           <#--  myfaces expects setter if input has value=?1.0: set initial value in bean (preferred since jsf/java independent)  or via viewparam or via model initial value -->
                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}:this.value;"
                           size="21">
                </h:inputText>
            </ui:decorate>
          </#if>
         </p:tab>
        </#if>
       <#else>
        <#-- foreign fields self referencing ?  not quoteorderexists -->
        <#if (parentKeyName?length > pL) && componentName == property.name>
         <#if (property.name?length > pL && parentKeyName?length > pL) && !(parentKeyName?substring(pefS,pefE) == "cq" ||  parentKeyName?substring(pefS,pefE) == "co" ||  parentKeyName?substring(pefS,pefE) == "ci" ||  parentKeyName?substring(pefS,pefE) == "cp"   ||  parentKeyName?substring(pefS,pefE) == "vq" ||  parentKeyName?substring(pefS,pefE) == "vo" ||  parentKeyName?substring(pefS,pefE) == "vi"  ||  parentKeyName?substring(pefS,pefE) == "sh" ||  parentKeyName?substring(pefS,pefE) == "sv" )    > 
          <#-- self referencing field should not be allowed for transaction since another menu option exists to copy from -->
          <p:tab title="${'#'}{messages['${property.name?substring(eL)?cap_first}']}AsParent" rendered="true">
           <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['${property.name?substring(eL)?cap_first}']}AsParent 
            </ui:define>
             <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(pL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                   required="false"
                   value= "${'#'}{${parentName}Home.last${parentName}P}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                   <#if property.name== itemEntityName>
                    <#if menuAttributesFunction =="9c">
                     value="${'#'}{${parentName}List.getSuggestList('LT-')}" var ="result" 
                    <#else>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" 
                    </#if>
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.${itemDescript}}" />
                   <#elseif property.name== customerEntityName>
                     value="${'#'}{${parentName}List.getSuggestList('*')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukxxbvxxxxxxxxxxcustomer}" 
                     itemLabel="${'#'}{(empty result.d1xxu3cnbvixxxxxxxxxcustomerascompanyname?'':result.d1xxu3cnbvixxxxxxxxxcustomerascompanyname).concat(' ').concat(result.c1xxuslnbvixxxxxxxxxlastname).concat(' ').concat(result.c2xxu2fnbvixxxxxxxxxfirstname).concat(' ').concat(fn:substring(result.a0xxukxxbvxxxxxxxxxxcustomer,fn:length(result.a0xxukxxbvxxxxxxxxxxcustomer)-4,fn:length(result.a0xxukxxbvxxxxxxxxxxcustomer)))}"/>
                   <#else>
                     value="${'#'}{${parentName}List.suggest(' ')}" var ="result" 
                     itemValue="${'#'}{result}" 
                     itemLabel="${'#'}{result}"/>
                   </#if>
             </p:selectOneMenu>
            <br/>
           </ui:decorate>
          <#if (parentKeyName?length > pL) && menuAttributesFunction =="1a" && (parentKeyName?length > pL)>
           ${'#'}{messages['select']} ${'#'}{messages['parent']}/${'#'}{messages['category']} ${'#'}{messages['to']} ${'#'}{messages['match']} ${'#'}{messages['detail']} ${'#'}{messages['type']}
           <ui:decorate id="${property.name}DecorationS" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['category']} ${'#'}{messages['shopping']} 
            </ui:define>
                <p:remoteCommand name="${property.name}Function" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(pL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                   required="false"
                   value= "${'#'}{${parentName}Home.last${parentName}P}" onchange="${property.name}Function()"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{${parentName}List.getSuggestList('SI-L%')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.${itemDescript}}" />
             </p:selectOneMenu>
            <br/>
           </ui:decorate>
           <ui:decorate id="${property.name}DecorationI" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['category']} ${'#'}{messages['image']} 
            </ui:define>
                <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(pL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                   required="false"
                   value= "${'#'}{${parentName}Home.last${parentName}P}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{${parentName}List.getSuggestList('PI-L*')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.${itemDescript}}" />
             </p:selectOneMenu>
            <br/>
           </ui:decorate>
           <ui:decorate id="${property.name}DecorationB" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['category']} ${'#'}{messages['blog']} 
            </ui:define>
             <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(pL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                   required="false"
                   value= "${'#'}{${parentName}Home.last${parentName}P}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{${parentName}List.getSuggestList('BI-L*')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.${itemDescript}}" />
             </p:selectOneMenu>
            <br/>
           </ui:decorate>
          </#if>
          <#list 1..brCount as i>
           <br/> 
          </#list>
           <#assign brCount=1>

          </p:tab>
         </#if>
        <#else>
        <#-- 3rd check foreign field end of selfreferencing , if foreign fld is employee for cq,etc  jay tbd add vendor contact -->
         <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi"  || pentityFunction=="eo"  || pentityFunction=="cp"  || pentityFunction=="vp")
            && (property.name=employeeEntityName  ) > 
           <h:outputText value="${'#'}{messages['Sales']} ${'#'}{messages['Agent']}" />
           <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml"  >
            <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   value="${'#'}{${parentName}Home.last${parentName}P}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{${parentName}List.suggest(' ')}" var ="result" itemValue="${'#'}{result}" 
                     itemLabel="${'#'}{result}"/>
             </p:selectOneMenu>
           </ui:decorate>
         <#--not employee for cq etc or sh,sv etc ${property.name}   -->
         <#else>
          <#if (parentKeyName?length > pL) && !(property.name=cuquoteEntityName || property.name=cuordersEntityName || property.name=venquoteEntityName || property.name=vendordersEntityName  || property.name=vinvoiceEntityName
                               || property.name=cuinvoiceEntityName || property.name=vshipmenEntityName ) >
          <#-- since separate menu exists for quoteorder(invoice)exists, do not show those foreign fields under not quoteorder exists
               however not all foreign fields should be marked as required to allow flexibility, add application logic to cover when required
          -->
           <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}"
            <#if property.name=locationEntityName >
             rendered="true">
            <#else>
             rendered="true">
            </#if>
           <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']} 
            </ui:define>
               <#-- jay above if says if not cq etc then why are we checking for cq etc -->
               <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi"  || pentityFunction=="eo"  || pentityFunction=="cp"  || pentityFunction=="vp" || pentityFunction=="va"   )  > 
                <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
               <#elseif menuAttributesFunction ="65">
                <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" actionListener="${'#'}{${componentName}Home.showNetValue}"/>
               <#else>
                <p:remoteCommand name="${property.name}Function" proces="@all" />
               </#if>
             <p:selectOneMenu styleClass="autoCompleteWidth50" id="${property.name}sm"
                <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="va"
                 || pentityFunction=="eo"  || pentityFunction=="cp"  || pentityFunction=="vp"    ) 
                  || pentityFunction=="sh"  || pentityFunction=="sv" || menuAttributesFunction ="21" || menuAttributesFunction ="31" || menuAttributesFunction ="1h"   > 
                  <#if property.name=itemEntityName  >
                   required="true"  
                       label="${property.name?substring(pL)}"
                       rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                  <#elseif  property.name=employeeEntityName > 
                    required="false" value="${'#'}{${parentName}Home.last${parentName}P}" rendered="true && ${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                  <#elseif  property.name=customerEntityName > 
                    rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    <#if menuAttributesFunction ="21">
                     required="true"   
                       label="${property.name?substring(pL)}"
                    <#else>
                     <#if pentityFunction=="sv">
                      required="false"  disabled="${'#'}{${homeName}.picked}" 
                     <#else>
                      required="true"  disabled="${'#'}{${homeName}.picked}" 
                       label="${property.name?substring(pL)}"
                     </#if>
                    </#if>
                  <#elseif  property.name=vendorEntityName > 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    <#if menuAttributesFunction ="31">
                     required="true"  
                       label="${property.name?substring(pL)}"
                    <#else>
                     required="true"  disabled="${'#'}{${homeName}.picked}"
                       label="${property.name?substring(pL)}"
                    </#if>
                  <#elseif  property.name=employeeEntityName > 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                     required="true"  disabled="${'#'}{${homeName}.picked}"
                       label="${property.name?substring(pL)}"
                  <#else>
                       rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                  </#if>
                    requiredMessage="${'#'}{messages['${property.name?substring(pL)?cap_first}']} ${'#'}{messages['ValueRequired']}"
                <#else>
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                 <#if menuAttributesFunction ="54" >
                  <#if  property.name=membersgroupEntityName > 
                   required="true" 
                       label="${property.name?substring(pL)}"
                  <#else>
                   required="false"
                  </#if>
                 <#elseif menuAttributesFunction ="65" >
                  <#if  property.name=accountEntityName > 
                   required="true" 
                       label="${property.name?substring(pL)}"
                  <#else>
                   required="false"
                  </#if>
                 <#elseif menuAttributesFunction ="9a"  && machineEntityName??>
                  <#if  property.name=machineEntityName > 
                   required="true" 
                  <#else>
                   required="false"
                  </#if>
                 <#elseif menuAttributesFunction ="9c" >
                  <#if  property.name=customerEntityName > 
                   required="true" disabled="${'#'}{${homeName}.picked}"
                  <#else>
                   required="false"
                  </#if>
                 <#elseif menuAttributesFunction ="1r" >
                   required="true" 
                 <#else>
                   required="false"
                 </#if>
                </#if>
                   <#if parentKeyName?substring(0,3) = "id.">
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(pL)}}" 
                   <#else>
                    validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}}" 
                   </#if>
                   value="${'#'}{${parentName}Home.last${parentName}P}" onchange="${property.name}Function()"
             >   
<#-- jay filter a/c ${property.name} ${menuAttributes} -->
              <#if menuAttributesFunction =="36">
               <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
               <f:selectItem itemValue="all" itemLabel="All" />
              <#else>
               <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              </#if>
              <f:selectItems 
                   <#if property.name== itemEntityName>
                    <#if menuAttributesFunction =="9c">
                     value="${'#'}{${parentName}List.getSuggestList('LT-')}" var ="result" itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                    <#else>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                    </#if>
                    <#if menuAttributesFunction == "33" || menuAttributesFunction == "34" || menuAttributesFunction == "3a" || menuAttributesFunction == "38" || menuAttributesFunction == "37">
                      itemLabel="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode} (${'#'}{result.b6fbzicxbvxxxxxxxxxxcost}/${'#'}{result.b8fbzpxxbvxxxxxxxxxxselprice}) /${'#'}{result.${itemDescript}}"/>
                    <#else>
                      itemLabel="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode} (${'#'}{result.b8fbzpxxbvxxxxxxxxxxselprice}) /${'#'}{result.${itemDescript}}"/>
                    </#if>                    
                   <#elseif property.name== customerEntityName>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxukxxbvxxxxxxxxxxcustomer}" 
                     itemLabel="${'#'}{(empty result.d1xxu3cnbvixxxxxxxxxcustomerascompanyname?'':result.d1xxu3cnbvixxxxxxxxxcustomerascompanyname).concat(' ').concat(result.c1xxuslnbvixxxxxxxxxlastname).concat(' ').concat(result.c2xxu2fnbvixxxxxxxxxfirstname).concat(' ').concat(fn:substring(result.a0xxukxxbvxxxxxxxxxxcustomer,fn:length(result.a0xxukxxbvxxxxxxxxxxcustomer)-4,fn:length(result.a0xxukxxbvxxxxxxxxxxcustomer)))}"/>
                   <#elseif property.name== vendorEntityName>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxukxxbvxxxxxxxxxxvendor}" 
                     itemLabel="${'#'}{(empty result.d1xxu3cnbvxxxxxxxxxxvendorascompanyname?'':result.d1xxu3cnbvxxxxxxxxxxvendorascompanyname).concat(' ').concat(result.b3xxuslnbvxxxxxxxxxxlastname).concat(' ').concat(result.b4xxu2fnbvxxxxxxxxxxfirstname)}"/>
                   <#elseif property.name== employeeEntityName>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxuktxbvxxxxxxxxxxemployee}" 
                     itemLabel="${'#'}{(result.b3xxuslnbvixxxxxxxxxlastname).concat(' ').concat(result.b4xxu2fnbvxxxxxxxxxxfirstname)}"/>

                   <#elseif property.name== resource_bundleEntityName>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxukrdbvxxxxxxxxxxname}" 
                     itemLabel="${'#'}{result.a1xxuxxxbvxxxxxxxxxxlanguage.concat('/ ').concat(result.a1xxuxxxbvxxxxxxxxxxcountry).concat('/ ').concat(result.a1xxuxxxbvxxxxxxxxxxvariant).concat('/ ').concat(result.zzxxu2oxxhxxxxxxxxxxowner2)}"/>
                   <#elseif property.name== accountEntityName>
                    <#if (menuAttributesFunction?contains("20") || pentityFunction=="cp" )>
                     value="${'#'}{${parentName}List.getSuggestList('3A3DAI')}" var ="result" itemValue="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount}" 
                     itemLabel="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount.concat(' ').concat(result.a1xxuzsxbvxxxxxxxxxxdescript)}"/>
<#-- 3A3 is prefixD details L liability E expns A asset I income  -->
                    <#elseif (menuAttributesFunction?contains("30")  || pentityFunction=="vp")>
                     value="${'#'}{${parentName}List.getSuggestList('3A3DLE')}" var ="result" itemValue="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount}" 
                     itemLabel="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount.concat(' ').concat(result.a1xxuzsxbvxxxxxxxxxxdescript)}"/>
                    <#elseif (menuAttributesFunction?contains("40") )>
                     value="${'#'}{${parentName}List.getSuggestList('3A3DAI')}" var ="result" itemValue="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount}" 
                     itemLabel="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount.concat(' ').concat(result.a1xxuzsxbvxxxxxxxxxxdescript)}"/>
                    <#else>
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount}" 
                     itemLabel="${'#'}{result.a0xxukwxbvxxxxxxxxxxaccount.concat('/ ').concat(result.a1xxuzsxbvxxxxxxxxxxdescript)}"/>
                    </#if> 
                   <#elseif property.name== userproflEntityName>
                     validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}${property.name?substring(pL)}}" 
                     value="${'#'}{${parentName}List.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxukuxbvxxxxxxxxxxid}" 
                     itemLabel="${'#'}{(result.a0xxukuxbvxxxxxxxxxxid.concat(' ').concat(result.c1xxuxxxbvxxxxxxxxxxotherid)}"/>
                   <#else>
                     value="${'#'}{${parentName}List.suggest(' ')}" var ="result" itemValue="${'#'}{result}" 
                     itemLabel="${'#'}{result}"/>
                   </#if>
             </p:selectOneMenu>
         <#if  menuAttributesFunction == "27" && (property.name=customerEntityName || variation="quoteorderexists") > 
          <h:panelGroup>
             <ui:decorate id="amtinlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Amount In ${'#'}{authenticator.currencySymbol}
             </ui:define>
                <#-- for inputtext ajax use keyup so that value is selected after it is entered   blur or keypress not reliable -->
        	 <h:inputText id="amtIn" value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}"  
                 onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}}:this.value;"
                 disabled="false" >
                 <#if menuAttributesFunction ="1b">
                 <p:ajax listener = "${'#'}{${homeName}.recalculateThis}"  event="keyup" update="@form" />
                 <#else>
                 <p:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="keyup" update="@form" />
                 </#if>
                 <f:convertNumber  maxFractionDigits="2" minFractionDigits="0" />
             </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
          </h:panelGroup>
         </#if>

      <#if menuAttributesFunction == "38" &&  (property.name=vendorEntityName || variation="quoteorderexists") > 
       <h:panelGroup>
             <ui:decorate id="amtinlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Amount In ${'#'}{authenticator.currencySymbol}
             </ui:define>
        	 <h:inputText id="amtIn" value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}"  
                 onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.z6xxzxxxavxxxxxxxxxxamountin}}:this.value;"
                 disabled="false" >
                 <f:convertNumber minFractionDigits="0" maxFractionDigits="2"  />
                 <p:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="blur" update="@form" />
             </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
          </h:panelGroup>
         </#if>

                <#if property.name== itemEntityName>
                </#if>
           </ui:decorate>
            <#if  !((property.name=itemEntityName || (property.name=customerEntityName && pentityFunction=="sh")) &&  menuAttributes?contains("T") && variation !="quoteorderexists" )>
             <#list 1..brCount as i>
             <br/> 
             </#list>
             <#assign brCount=1>
             </p:tab>
             <#if menuAttributesFunction =="65" && property.name== accountEntityName>
                        <p:tooltip for="${property.name}sm"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['default']} ${'#'}{messages['posting']} ${'#'}{messages['period']} ${'#'}{customIdentity.curracperiod} ${'#'}{messages['and']} ${'#'}{messages['selected']} ${'#'}{messages['period']} ${'#'}{yxxxuq632xwwqqhxxxxxperioddatesHome.lastyxxxuq632xwwqqhxxxxxperioddatesP} , ${'#'}{messages['select']}/${'#'}{messages['change']} ${'#'}{messages['as']} ${'#'}{messages['needed']}"/></span> </p:tooltip> 
             </#if> 

            </#if>
          </#if>
         </#if>
        </#if>
       </#if>
       <#-- end of not by foreign fields tabs based on copy ie exists or new  --> 
      </#if>
     <#else>
       <#-- jay add logic for id like ccontact check parentkey ${parentKeyName}  prpertyName ${property.name}  -->
      <#if (parentKeyName?length > pL) && variation !="includeaddress" && property.name?contains("By")>
       <#-- jay add input boxes for address if parentName is Address  -->   
       <#-- jay add logic to make ship code reqd for shipment and vship -->
       <#-- check for db or hb in 5,7  also add create address logic in entityhome persist if addressinfo switch on-->
        <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}" rendered="true">
       <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml">
        <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']} 
        </ui:define>
             <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(12)?cap_first}${property.name?substring(pL)}}" 
              value="${'#'}{${parentName}Home.last${parentName}P}"
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems value="${'#'}{${parentName}List.suggest(' ')}" var="result"
               itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
             </p:selectOneMenu>
       </ui:decorate>
         <#list 1..brCount as i>
          <br/> 
         </#list>
          <#assign brCount=1>
       </p:tab>
      <#elseif variation =="includeaddress" && property.name?contains("By")>
      <#else>
       <#-- comes here if foreign fld is ${property.name} -->
       <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}" rendered="true">
       <ui:decorate id="${property.name}DecorationT" template="layout/edit.xhtml"  >
        <ui:define name="label">${'#'}{messages['${property.name?substring(pL)?cap_first}']} 
        </ui:define>
                <p:remoteCommand name="${property.name}Function" proces="@all" update="@none" />
             <p:selectOneMenu styleClass="autoCompleteWidth50" validator="${'#'}{${componentName}Home.validateAndSelect${parentKeyName?substring(15)?cap_first}${property.name?substring(pL)}}" 
              value="${'#'}{${parentName}Home.last${parentName}P}"
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems value="${'#'}{${parentName}List.suggest(' ')}" var="result"
               itemValue="${'#'}{result}" itemLabel="${'#'}{result}" />
             </p:selectOneMenu>
       </ui:decorate>
         <#list 1..brCount as i>
          <br/> 
         </#list>   
         <#assign brCount=1>
       </p:tab>
      </#if>
     </#if>
    </#if>
     <#-- end of prperty length 1 chk -->
    <#-- end of tab was suppressed earlier -->
    <#-- item/customer  ${property.name} ${variation}   ${pojo.shortName?upper_case?substring(0,8)}   -->
    <#if  property.name=customerEntityName &&  menuAttributes?contains("T") && "quoteorderexists" !=variation && pentityFunction=="sh" >
             <ui:decorate id="custaddr" template="layout/edit.xhtml" >
             <ui:define name="label">${'#'}{messages['shipment']} ${'#'}{messages['to']}
             </ui:define>
                 <br></br>
        	 <h:inputText value="${'#'}{${componentName}Home.instance.${property.name}.fxxxuq111xwwqqhxxxxxaddressByShiptocode.b1pxusa1bvxxxxxxxxxxaddrl1}" disabled="true" >
             </h:inputText>
                 <br></br>
        	 <h:inputText value="${'#'}{${componentName}Home.instance.${property.name}.fxxxuq111xwwqqhxxxxxaddressByShiptocode.b3xxh2acbv11xxxxxxxxcity} ${'#'}{${componentName}Home.instance.${property.name}.fxxxuq111xwwqqhxxxxxaddressByShiptocode.b4xxhbpxbv12xxxxxxxxprovnstate} ${'#'}{${componentName}Home.instance.${property.name}.fxxxuq111xwwqqhxxxxxaddressByShiptocode.b6xxh3azbv14xxxxxxxxpzcode}" disabled="true" >
             </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
             <#assign brCount=brCount+2>
             <#list 1..brCount as i>
              <br/> 
             </#list>
             <#assign brCount=1>
            </p:tab>
    </#if>
    <#if  property.name=itemEntityName &&  menuAttributes?contains("T") && "quoteorderexists" !=variation  >
            <#assign itemSelected="Y">
            <#if menuAttributesFunction =="9c">
             <#-- above only item types begin with 3 chrs lt-(lab test) will be shown. the full type name (12 chrs) must
                 match entries in rate1f table for more attributes and their values. If entry has step value 0 then
                 result value need to be entered here. At save time a detail will be created with entered value and other
                 values coming from rate table
             --> 
             <ui:decorate id="attributeDecoration" template="layout/edit.xhtml" >
              <ui:define name="label">${'#'}{messages['lab_result']} ${'#'}{messages['value']}
              </ui:define>
                <h:inputText id="avalue" required="true"
                          value="${'#'}{${componentName}Home.keyedQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${componentName}Home.keyedQuantity}:this.value;"
                           size="21">
                </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
            <#else> 
             <ui:decorate id="matcodeDescriptDecoration" template="layout/edit.xhtml" >
             <ui:define name="label">${'#'}{messages['${itemDescript?substring(pL)?cap_first}']}
             </ui:define>
        	 <h:inputText id="matcodeDescriptDecorationT" value="${'#'}{${componentName}Home.instance.${property.name}.${itemDescript}}"  
                 disabled="true" >
             </h:inputText>
             </ui:decorate>
             <#assign brCount=brCount+1>
             <#if menuAttributesFunction?contains("25")>
              <ui:decorate id="matcodeShipCostLabelT" template="layout/edit.xhtml" >
              <ui:define name="label">${'#'}{messages['shipping']} ${'#'}{messages['size and']} ${'#'}{messages['type']}
              </ui:define>
        	    <h:inputText id="matcodeShippingSize" value="${'#'}{fn:endsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'S') ? 'Small':(fn:endsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'M')?'Medium':(fn:endsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'L')?'Large':(fn:endsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'X')?'Extra Large':'Small')))}"     
                  disabled="true" >
              </h:inputText>

        	    <h:inputText id="matcodeShippingMode" value="${'#'}{fn:startsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'E') ? 'Express':(fn:startsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'S')?'Standard':(fn:startsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'P')?'Pick Up':(fn:startsWith(${componentName}Home.instance.${property.name}.${itemShipcode},'X')?'Not Applicable':'No Restriction')))}"     
                  disabled="true" >
              </h:inputText>
              </ui:decorate>
             <#else>
              <#if pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="vp"  || pentityFunction=="sv" 
                && (itemPriceField?length >pL) > 
               <ui:decorate id="matcodePriceLabelT" template="layout/edit.xhtml" >
                <ui:define name="label">${'#'}{messages['${itemCostField?substring(pL)?cap_first}']}
                </ui:define>
        	    <h:inputText id="matcodePriceDecorationT" value="${'#'}{${componentName}Home.instance.${property.name}.${itemCostField}}"     
              <#else>
               <ui:decorate id="matcodePriceLabelT" template="layout/edit.xhtml" >
                <ui:define name="label">${'#'}{messages['${itemPriceField?substring(pL)?cap_first}']}
                </ui:define>
        	    <h:inputText id="matcodePriceDecorationT" value="${'#'}{${componentName}Home.instance.${property.name}.${itemPriceField}}"     
              </#if>
                     disabled="true" >
                    </h:inputText>
              </ui:decorate>
              <#--  reduce br if item -->
               <#assign brCount=brCount-4>

              <ui:decorate id="matcodePriceOverRide" template="layout/edit.xhtml" >
              <#if pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="vp"  || pentityFunction=="sv"  >
               <ui:define name="label">${'#'}{messages['price']} ${'#'}{messages['override']}
              <#else>
               <ui:define name="label">${'#'}{messages['cost']} ${'#'}{messages['override']}
              </#if>
               </ui:define>
       	      <h:inputText id="matcodePriceOverRideV" value="${'#'}{${componentName}Home.priceOverRide}"     
                  disabled="false" >
              </h:inputText>
              </ui:decorate>
              <ui:decorate id="matcodeOverRideCode" template="layout/edit.xhtml" >
              <ui:define name="label">${'#'}{messages['override']} ${'#'}{messages['code']}
              </ui:define>
       	      <h:inputText id="matcodePriceOverRideI" value="${'#'}{${componentName}Home.valueOverRide}"     
                  disabled="false" >
              </h:inputText>
              </ui:decorate>
             <#if pentityFunction=="ci">             
              <ui:decorate id="currencyConv" template="layout/edit.xhtml" >
               <ui:define name="label">${'#'}{messages['Use']} ${'#'}{messages['Merchant']}/${'#'}{messages['Bank']} ${'#'}{messages['currency']} 
               </ui:define>
               <p:selectBooleanCheckbox id="currencyConvI" value="${'#'}{${componentName}Home.currConv}"/>
              </ui:decorate>
             </#if>

             </#if>
            </#if>
             <#assign brCount=brCount+1>
             <#assign brCount=brCount+2>
    
             <#list 1..brCount as i>
              <br/> 
             </#list>
             <#assign brCount=1>
     <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci"  || pentityFunction=="sh" > 
            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Qtyordrd']}
            </ui:define>
                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}:this.value;"
                           size="21">
                </h:inputText>
            </ui:decorate>
            <#assign brCount=brCount+1>
     </#if>
     <#if pentityFunction=="ij" || pentityFunction=="aj"  > 
            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Qtyordrd']} 
            </ui:define>
                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}:this.value;"
                           size="21">
                    <p:ajax event="keyup" update="ztprlxxxxxxxxxxxamounttotalDecoration" />
                </h:inputText>
            </ui:decorate>
            <#assign brCount=brCount+1>
     </#if>
     <#if pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="vp"  || pentityFunction=="sv"  > 
            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" >
             <ui:define name="label">${'#'}{messages['Qtyordrd']}
             </ui:define>
                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}:this.value;"
                           size="21">
                </h:inputText>
            </ui:decorate>
            <#assign brCount=brCount+1>
     </#if>

     <#if pentityFunction=="eo" || pentityFunction=="eq"  > 
            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" >
             <ui:define name="label">${'#'}{messages['Qtyordrd']}
             </ui:define>
                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${componentName}Home.instance.${itemEntityName}.tempQuantity}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{componentName}Home.instance.${itemEntityName}.tempQuantity}:this.value;"
                           size="21">
                </h:inputText>
            </ui:decorate>
            <#assign brCount=brCount+1>
     </#if>
            </p:tab>
    </#if>
  <#else>
     <#-- not foreign (and not component ) ie autogen key or keyed in or subkey or next number jay entityfunc2 ${property.name} -->
   <#if (property.name?length > pL) >
    <#if property.name?substring(pkS,pkE)=="o"  >
           <#assign keyAutoGen="Y">
    </#if>
    <#if property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
           <#assign keyedKeyName=property.name>
    </#if>
    <#if property.name?substring(pkS,pkE)=="n" || property.name?substring(pkS,pkE)=="k">
      <#assign pentityFunction = property.name?substring(pefS,pefE)>
    </#if>
     <#-- IDENTITY field entityfunc2 ${pentityFunction} -->
    <#if property.name?substring(pkS,pkE)=="o">
      <#assign pentityFunction = property.name?substring(pefS,pefE)>
     <#-- IDENTITY field entityfunc2 ${pentityFunction} -->
    </#if>
     <#-- jay4 not foreign regular fields entityfunc2 ${pentityFunction} -->

    <#if property.name?substring(pefS,pefE)=="az"> 
      <#assign pzcodeField="property.name">
    </#if>  
    <#-- not foreign -->  
   </#if>
  </#if>
 </#if>
</#if>
</#foreach>
   <#if tabPanel = "Y" & tab = "N">
   <#-- end Tab content -->
   </p:tabView>
   <#if showAddress="yes">
      <p:panel>
         <ui:decorate id="l1" template="layout/edit.xhtml">
          <ui:define name="label">Address Line1 
          </ui:define>
          <h:inputText id="${showAddressPName}addrl1" 
                          size="35"
                     maxlength="35"
                         value="${'#'}{${homeName}.addrL1}">
          </h:inputText>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="l2" template="layout/edit.xhtml">
          <ui:define name="label">Address Line2 
          </ui:define>
          <h:inputText id="${showAddressPName}addrl2" 
                          size="35"
                     maxlength="35"
                         value="${'#'}{${homeName}.addrL2}">
          </h:inputText>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="city" template="layout/edit.xhtml">
          <ui:define name="label">City 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.city}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${showAddressPName}CityI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','11').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','11').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',11)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${showAddressPName}CityI" value="${'#'}{${homeName}.city}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="prov" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['Provnstate']} 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.provstate}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${showAddressPName}provstateI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','12').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','12').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',12)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${showAddressPName}provstateI" value="${'#'}{${homeName}.provstate}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="pz" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['Pzcode']} 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.pzcode}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${showAddressPName}pzcodeI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','14').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','14').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',14)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${showAddressPName}pzcodeI" value="${'#'}{${homeName}.pzcode}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
                        <#--
                           <f:validateRegex pattern="^$|(^(?i)^[a-z0-9][a-z0-9\\-]{0,10}[a-z0-9]$)"/>
                        -->
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
         </ui:decorate>
         <ui:decorate id="cntry" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['Country']} 
          </ui:define>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.country}" 
              rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}">
              <f:ajax  render="${showAddressPName}countryI" />
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','13').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','13').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
	      <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',13)}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
             <h:inputText id="${showAddressPName}countryI" value="${'#'}{${homeName}.country}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
             </h:inputText>
             </h:panelGrid>
          <#assign brCount=brCount+1>
          <#assign brCount=1>
         </ui:decorate>
          </p:panel>
   </#if>  
   <#if menuAttributesFunction ="1s">
    <h:link id="loctn" outcome="/locationEdit.xhtml" target="_blank" value="${'#'}{messages['Create']} ${'#'}{messages['location']}"  /><br></br>
   </#if>

   <#if menuAttributesFunction =="36">
    <br></br><h:outputText value="${'#'}{messages['If']} ${'#'}{messages['a']} ${'#'}{messages['manual']} ${'#'}{messages['check']} ${'#'}{messages['already']} ${'#'}{messages['issued']}, ${'#'}{messages['enter']} ${'#'}{messages['chqnumber']} ${'#'}{messages['and.']} ${'#'}{messages['chqamt']}, ${'#'}{messages['then']} ${'#'}{messages['use']} ${'#'}{messages['Manual_chq']} ${'#'}{messages['button']}."/> 
    <br></br><h:outputText value="${'#'}{messages['If']} ${'#'}{messages['generating']} ${'#'}{messages['checks']}, ${'#'}{messages['ignore']} ${'#'}{messages['chqamt']} ${'#'}{messages['but']} ${'#'}{messages['enter']} ${'#'}{messages['chqnumber']} ${'#'}{messages['only']} ${'#'}{messages['if']} ${'#'}{messages['the']} ${'#'}{messages['starting']} ${'#'}{messages['value']} ${'#'}{messages['of']} ${'#'}{messages['the']} ${'#'}{messages['pre-printed']} ${'#'}{messages['checks']} ${'#'}{messages['do']} ${'#'}{messages['not']} ${'#'}{messages['match']} ${'#'}{messages['value']} ${'#'}{yxxxch522xhhxxhxxxxxclientList.getKeyToEntity('01').t6xxuxvpbvxxxxxxxxxxvendorchqn+1} "/>
    
   </#if>


    <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="va"
           || pentityFunction=="eo"  || pentityFunction=="cp"  || pentityFunction=="vp" || menuAttributesFunction ="1b"   ) 
             || pentityFunction=="sh"  || pentityFunction=="sv"   > 
                        <#if pentityFunction=="cp"  || pentityFunction=="vp">
                         <ui:fragment rendered="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile}">
                          <br></br>
                          </ui:fragment>
                         <h:panelGroup>
                          <p:commandButton id="calTotalsT" styleClass="buttonMain"
                           value="${'#'}{messages['show']} ${'#'}{messages['already']} ${'#'}{messages['shipped']} ${'#'}{messages['but']} ${'#'}{messages['outstanding']} ${'#'}{messages['invoice']} ${'#'}{messages['totals']} ${'#'}{messages['for']} ${'#'}{messages['selected']} " update="@form"
                           <#if variation ="quoteorderexists" >
                            action="${'#'}{${componentName}Home.extended_persist(false)}"/>
                           <#else> 
                            action="${'#'}{${componentName}Home.showtemprunt()}"/>
                            <h:outputText value="${'#'}{messages['If']} ${'#'}{messages['invoice']} ${'#'}{messages['exists']}, ${'#'}{messages['use']} ${'#'}{messages['convert']} ${'#'}{messages['invoice']}"/>
                           </#if>
                         </h:panelGroup>
                        <#else>
                          <#if menuAttributesFunction ="1b"  >
                          <h:panelGroup>
                           <p:commandButton id="calTotalsT" styleClass="buttonMain"
                            value="${'#'}{messages['refresh']} ${'#'}{messages['totals']}" update="@form"
                            action="${'#'}{${componentName}Home.recalculateTotalThis()}"/>
                          </h:panelGroup>
                          </#if>
                        </#if>
     </h:panelGrid>
    </#if>
   <#assign tab="Y" >
   </#if>
  <#if menuAttributesFunction ="1a">
   <h:panelGroup id="replyTo" template="layout/edit.xhtml" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='b' and ${componentName}Home.last${itemEntityName} != '')}" >
    <ui:define name="label">Reply To 
    </ui:define>
    <h:outputText value="${'#'}{${componentName}Home.last${itemEntityName}}" />  
   </h:panelGroup>   
  </#if>
<#if  firstTime="N">
 </h:panelGrid>
</#if>
<#if menuAttributesFunction ="65" >
             <ui:decorate id="debitAmtlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Debit Amount ${'#'}{customIdentity.mcurrencySymbol}
             </ui:define>
                 <ui:remove>reusing existing props, del refers to debit and mis refers to credit</ui:remove>
        	 <h:inputText id="debitamtIn" value="${'#'}{${homeName}.totaldel}"  
                 onclick="this.value='';if (${'#'}{'${componentName}:creditamtIn'}.value != 0.0) {if (! confirm(jay2) ) { return false;}; return true;} " onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${gentriesDetailsEntityName}Home.instance.c4xxzxxxbvxxxxxxxxxxdebitamt}}:this.value;"
                 disabled="false"  >
                 <p:ajax listener = "${'#'}{${homeName}.showNetValue}"  event="keyup" update="@all" />
                 <f:convertNumber  maxFractionDigits="2" minFractionDigits="0" />
             </h:inputText>
                 <p:tooltip for="debitamtInT"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Generally']} ${'#'}{messages['Dividends']}, ${'#'}{messages['Expenses']}, ${'#'}{messages['Assets']}, ${'#'}{messages['Losses']} ${'#'}{messages['are']} ${'#'}{messages['increased']} ${'#'}{messages['by']} ${'#'}{messages['Debit']}"/></span> </p:tooltip> 
             </ui:decorate>
             <ui:decorate id="creditAmtlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Credit Amount ${'#'}{customIdentity.mcurrencySymbol}
             </ui:define>
        	 <h:inputText id="creditamtIn" value="${'#'}{${homeName}.totalmis}"  
                 onclick="this.value='';if (${'#'}{'${componentName}:debitamtIn'}.value != 0.0) {if (! confirm(jay2) ) { return false;}; return true;} " onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${gentriesDetailsEntityName}Home.instance.c5xxzxxxbvxxxxxxxxxxcreditamt}}:this.value;"
                 disabled="false" >
                 <p:ajax listener = "${'#'}{${homeName}.showNetValue}"  event="keyup" update="@all" />
                 <f:convertNumber  maxFractionDigits="2" minFractionDigits="0" />
             </h:inputText>
                 <p:tooltip for="creditamtIn"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Generally']} ${'#'}{messages['Income']}, ${'#'}{messages['Revenues']}, ${'#'}{messages['Liabilities']}, ${'#'}{messages['Equity']} ${'#'}{messages['are']} ${'#'}{messages['increased']} ${'#'}{messages['by']} ${'#'}{messages['Credit']}"/></span> </p:tooltip> 
             </ui:decorate>
             <ui:decorate id="netAmtlabel" template="layout/edit.xhtml" >
             <ui:define name="label">Net Amount ${'#'}{customIdentity.mcurrencySymbol}
             </ui:define>
        	 <h:outputText id="netamtIn" value="${'#'}{${homeName}.getTotalbaseamt()}"  >
                 <f:convertNumber  maxFractionDigits="2" minFractionDigits="0" />
             </h:outputText>
             </ui:decorate>
</#if>
<#-- field definitions generated are used further below, in future it would be replaced by include xxx.xx -->
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
<#if c2j.isComponent(property)>
 <#foreach componentProperty in property.value.propertyIterator>
 </#foreach>
<#else>
 <#if (property.name?length > pL) >
 <#if property.name?substring(pfS,pfS2)=="m">
  <#assign miscchrgField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="l">
  <#assign deliveryField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="p">
  <#assign priceField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="q">
  <#assign qtyField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="c">
  <#assign costField=property.name>
 </#if>
 <#if property.name?substring(pefS,pefE)=="z1">
  <#assign tax1Field=property.name>
 </#if>
 <#if property.name?substring(pefS,pefE)=="z2">
  <#assign tax2Field=property.name>
 </#if>
 <#if property.name?substring(pefS,pefE)=="z3">
  <#assign tax3Field=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="u">
  <#assign unitField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="v" || property.name?substring(pfS,pfE)=="dv" ||  property.name?substring(pfS,pfE)=="fv">
  <#assign vendorField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="t" || property.name?substring(pfS,pfE)=="dt"  || property.name?substring(pfS,pfE)=="ft">
  <#assign employeeField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="r" || property.name?substring(pfS,pfE)=="dr"  || property.name?substring(pfS,pfE)=="fr">
  <#assign customerField=property.name>
 </#if>
 <#if  property.name?substring(pfS,pfE)=="do" ||  property.name?substring(pfS,pfE)=="fo">
  <#assign divisionField=property.name>
 </#if>
 <#if property.name?substring(pfS,pfS2)=="e" || property.name?substring(pfS,pfE)=="de" ||  property.name?substring(pfS,pfE)=="fe">
  <#assign departmentField=property.name>
 </#if>
 <#if property.name?substring(pL) == "owner" >
 </#if>
<#-- keyfromsubkeys variable used in editproperty.xhtml.ftl  if foreignfield is subkey the following logic fails so hard code-->
 <#if menuAttributesFunction =="9a">
    <#assign keyfromsubkeys="Y">
 </#if>
 <#if property.name?substring(pkS,pkE)=="s" | property.name?substring(pkS,pkE)=="2" | property.name?substring(pkS,pkE)=="3"
     | property.name?substring(pkS,pkE)=="4" | property.name?substring(pkS,pkE)=="5">
  <#if keyfromsubkeys="N">
   <#-- remove this after 2o shifts to non key position -->
   <#if property.name?substring(pkS,7)!="2o">
    <#assign keyfromsubkeys="Y">
   </#if>
  </#if>
 </#if>
 </#if>
</#if>
</#if>
</#foreach>

</h:panelGrid>

     <#if menuAttributesFunction ="5a" >
        <h:panelGrid columns="4">
     <#else>
        <h:panelGrid columns="4">
     </#if>

<#-- in case of customer/vendor put a label/message explaining business and individual customer/vendor type and usage as primary contact -->
<#if ( menuAttributesFunction?contains("20") )>
         <ui:decorate id="cutypeMsg" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['business_customer_contact_below']} 
          </ui:define>
         </ui:decorate>

</#if> 
<#if ( menuAttributesFunction?contains("30") )>
         <ui:decorate id="ventypeMsg" template="layout/edit.xhtml">
          <ui:define name="label">${'#'}{messages['business_vendor_contact_below']} 
          </ui:define>
         </ui:decorate>

</#if> 
          <#-- the following seems to make below left justified if above has rendered=false -->

          <h:outputText value="" />

<#-- below calls editproperty.ftl for all properties including suppressed ones as well as the composite and foreign 
     properties handled above. Although called editproprty.ftl do not have any logic for foreign fields.
     in summary, edit.ftl handles all foreign fileds except the ones which are composite and extra handling of 
     item foreign fields for transactions like cq,ci etc.
     editproperty.ftl handles all composite keys as well as all non foreign fields 
-->
<#-- Below were generated by editproperty.xhtml.ftl -->
     <#-- jay3 entityfunc ${pentityFunction} -->

<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL)>
 <#if property.name?substring(0,1) == "y" || property.name?substring(0,1) == "z"   >
  <#if togglePanel="Y">
   <#-- below ie FromCols settings are done only once via togglePanel="N" -->
   </h:panelGrid>
   <#assign FromCols2On="no">
   <#-- if cuorders/venorders put shipping info/options here, before edit toggle
        Based on this value and the shipcode value for the item (has subcodes for shipping ie SS means Standard ship for small item)
        go to rate table to get Ship cost for the item 
        also show what the item allows for shipping, may not allow all of them
    -->
   <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="sh" 
            || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="sv" > 
            <p:panel header="${'#'}{messages['Fields']}" switchType="client" collapsed="!${'#'}{!(${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1)}"
             leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
   </#if>
   <#if (pentityFunction=="co" || pentityFunction=="cq")>
    <h:outputText value="${'#'}{messages['Shipping_Options_Msg']}"/>
                            <p:selectOneRadio id="logic" value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.z9xxtxsolxxxxxxxxxxxshipoption}" styleClass="radio">
                             <f:selectItem itemLabel="Pick Up" itemValue="P"/>
                             <f:selectItem itemLabel="Standard Ship" itemValue="S"/>
                             <f:selectItem itemLabel="Express Ship" itemValue="E"/>
                             <f:selectItem itemLabel="Not Applicable" itemValue="X"/>
                            </p:selectOneRadio>
   <#elseif  (pentityFunction=="vo" || pentityFunction=="vq") >
    <h:outputText value="${'#'}{messages['Shipping_Options_Msg']}"/>
                            <p:selectOneRadio id="logic" value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.z8xxtxsolxxxxxxxxxxxshipoption}" styleClass="radio">
                             <f:selectItem itemLabel="Pick Up" itemValue="P"/>
                             <f:selectItem itemLabel="Standard Ship" itemValue="S"/>
                             <f:selectItem itemLabel="Express Ship" itemValue="E"/>
                             <f:selectItem itemLabel="Not Applicable" itemValue="X"/>
                            </p:selectOneRadio>
   </#if> 
   <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="sh" 
            || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="sv" > 
            </p:panel>
   </#if>
   <p:panel header="${'#'}{messages['EditToggle']}" toggleable="true" toggleableHeader="true"
     leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
   <#assign togglePanel="N"> 
   <h:panelGrid columns="4">
   <#assign FromCols8On="yes">
  </#if>  
 </#if>
 <#include "editproperty.xhtml.ftl">
</#if>
</#foreach>
<#-- below generated by edit.xhtml.ftl -->
<#if togglePanel ="N">
   </h:panelGrid>
   </p:panel>
<#else>
   </h:panelGrid>
</#if>
<#if menuAttributes?contains("T") && menuAttributesFunction !="9a" && menuAttributesFunction !="9c" >
   <p:panel header="${'#'}{messages['Totals']}" toggleable="true" toggleableHeader="true"
     leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">
              <p:panel>
               <#--  from 4 to 5 -->
               <h:panelGrid columns="5">
               <ui:decorate id="status" template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['Status']}</ui:define>
               </ui:decorate>
                   <h:inputText id="statusT" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.instance.${statusFlagField} eq 32 ?'shipped': (${homeName}.instance.${statusFlagField} eq 16 ?'paid':'other')}"   >
                   </h:inputText>

               <ui:decorate id="totals" template="layout/display.xhtml">
                <ui:define name="label">Totals</ui:define>
               </ui:decorate>
                   <h:inputText id="matcodeId2T" 
                       disabled="true"
                        size="15"
                         maxlength="20"
                          value="${'#'}{${homeName}.totalamountTotal}"   >
                   <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
                   </h:inputText>
               <ui:decorate id="totalsq" template="layout/display.xhtml">
                <ui:define name="label">Qty</ui:define>
               </ui:decorate>
                   <h:inputText id="matcodeId2TQ" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totalqtyTotal}"   >
                   </h:inputText>
               <ui:decorate id="Detail_Lines" template="layout/display.xhtml">
                <ui:define name="label">Detail Lines Added</ui:define>
               </ui:decorate>
                   <h:inputText id="matcodeId2DLT" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.lastItemLine}"   >
                   </h:inputText>

             
                <ui:decorate id="matcodeTDecoration" template="layout/display.xhtml">
                 <ui:define name="label">Base Total</ui:define>
                   <h:inputText id="matcodeId2LT" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totalbaseamt}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                   </h:inputText>
                </ui:decorate>
               <#if (miscchrgField?length > pL)>
                <ui:decorate id="matcodeDecorationmis" template="layout/display.xhtml">
                 <ui:define name="label">+${'#'}{messages['${miscchrgField?substring(pL)?cap_first}']}</ui:define>
                        <h:inputText id="miscchrgIdT" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totalmis}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                        </h:inputText>
                </ui:decorate>
               </#if>


               <#if (deliveryField?length > pL)>
                <ui:decorate id="matcodeDecorationdelT" template="layout/display.xhtml">
                 <ui:define name="label">+${'#'}{messages['${deliveryField?substring(pL)?cap_first}']}</ui:define>
                        <h:inputText id="delvchrgId" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaldel}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                        </h:inputText>
                </ui:decorate>
               </#if>
               <#if menuAttributesFunction =="25">
                <ui:decorate id="matcodeDecorationdelT" template="layout/display.xhtml">
                 <ui:define name="label">+${'#'}{messages['shipping']}</ui:define>
                        <h:inputText id="delvchrgId" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaldel}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                        </h:inputText>
                </ui:decorate>
               </#if>

<#--jay add logic based on locale to show or hide tax1 etc fields
    but should based on messages so that not hard coded ie if message is null for a locale it means not used 
-->
               <#if (tax1Field?length > pL)>
                <ui:decorate id="matcodeDecorationtax1T" template="layout/display.xhtml">
                 <ui:define name="label">+${'#'}{messages['${tax1Field?substring(pL)?cap_first}']}</ui:define>
                        <h:inputText id="tax1TId" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaltax1}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                        </h:inputText>
                </ui:decorate>
               </#if>
               <#if (tax2Field?length > pL)>
                <ui:decorate id="matcodeDecorationtax2T" template="layout/display.xhtml">
                 <ui:define name="label">+${'#'}{messages['${tax2Field?substring(pL)?cap_first}']}</ui:define>
                        <h:inputText id="tax2TId" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaltax2}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                        </h:inputText>
                </ui:decorate>
               </#if>
               <#if (tax3Field?length > pL)>
                <ui:decorate id="matcodeDecorationtax3T" template="layout/display.xhtml">
                 <ui:define name="label">+${'#'}{messages['${tax3Field?substring(pL)?cap_first}']}</ui:define>
                        <h:inputText id="tax3TId" 
                       disabled="true"
                                   size="15"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaltax3}"   >
                        <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" groupingUsed="true"
                     maxFractionDigits="2" type="currency" />
                        </h:inputText>
                </ui:decorate>
               </#if>

               </h:panelGrid>
              </p:panel>
</#if>

        
            <div style="clear:both">
                <span class="required">*</span> 
                ${'#'}{messages['required']} ${'#'}{messages['fields']} 
            </div>
            <#if keyedKeyName !="">
             <h:outputText value="${'#'}{messages['Key']} ${'#'}{${homeName}.instance.${keyedKeyName}} ${'#'}{messages['sid']} ${'#'}{${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid}" 
               rendered="${'#'}{${homeName}.instance.${keyedKeyName} !=''}"/> 
            </#if>
             <#if menuAttributesFunction == "25">
            ${'#'}{trexuq255xwwqqhxxxxxshipmentHome.instance.fxxxuq111xwwqqhxxxxxaddressByBilltocode ==null ? '':fxxxuq111xwwqqhxxxxxaddressList.sidToEnity(trexuq255xwwqqhxxxxxshipmentHome.instance.fxxxuq111xwwqqhxxxxxaddressByBilltocode).a0xxuobxbxxxxxxxxxxxsid}
             </#if> 
<#if menuAttributes?contains("T") && menuAttributesFunction !="9a" && menuAttributesFunction !="9c" >
   </p:panel>
</#if>

<#-- The following access during live session/transaction to display one to many is needed to avoid lazy loading exception later 
     or display some detail in view as done in glentries
-->
<#if (menuAttributes?contains("T") && menuAttributesFunction !="9c" && menuAttributesFunction !="36")  || menuAttributesFunction ="65" || menuAttributesFunction ="89">
            <p:panel id="lineItems" >

             <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="sh"  > 
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                     tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityLessStatusDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid,-1)}" var="item">
             <#elseif pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="sv">
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                      tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityLessStatusDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid,-1)}" var="item">
             <#elseif pentityFunction=="eo"  >
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                      tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityLessStatusDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid,-1)}" var="item">
             <#elseif  menuAttributesFunction =="9a"  >
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                      tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid)}" var="item">
             <#elseif pentityFunction=="vp" || pentityFunction=="cp" >
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                      tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityLessStatusDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid,-1)}" var="item">
             <#elseif  menuAttributesFunction =="65"  >
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                      tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityLessStatusDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid,-1)}" var="item">
             <#elseif  menuAttributesFunction =="89"  >
                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                     tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid)}" var="item">
             </#if>
             <#if menuAttributesFunction =="9a" && machineEntityName??>
                        <p:column id="column1">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartRemoveText" value="${'#'}{messages['removeColumn']}" />
                            </f:facet>
                            <p:selectBooleanCheckbox id="CartRemoveCheckbox" value="${'#'}{${componentName}Home.checked[item.a0xxuobxbxxxxxxxxxxxsid]}"/>
                        </p:column>

                        <p:column id="column2">
                            <f:facet id="TitleFacet" name="header">
                                <h:outputText id="TitleText" value="${'#'}{messages['descript']}" />
                            </f:facet>
                            ${'#'}{item.${machineEntityName}.b1xxuszsbvxxxxxxxxxxdescript} 
                        </p:column>     
                        <p:column id="column3">
                            <f:facet id="ActorFacet" name="header">
                                <h:outputText id="ActorText" value="${'#'}{messages['sdatet']}" />
                            </f:facet>
                            <h:outputText value="${'#'}{item.b5gxdxsdbvxxxxxxxxxxsdatet}">
                             <f:convertDateTime type="both" dateStyle="short"/>
                            </h:outputText>   
                        </p:column>                        
                        <p:column id="column5">
                            <f:facet id="QuantityFacet" name="header">
                                <h:outputText id="QuantityText" value="${'#'}{messages['durationh']}" />
                            </f:facet> 
                             <h:inputText id="QuantityValueText" value="${'#'}{item.b5xxexdhbvxxxxxxxxxxdurationh}" size="6" />
                        </p:column>                        
                    </p:dataTable>

             <#elseif menuAttributesFunction =="65">
                        <p:column id="column1">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartRemoveText" value="${'#'}{messages['removeColumn']}" />
                            </f:facet>
                            <p:selectBooleanCheckbox id="CartRemoveCheckbox" value="${'#'}{${componentName}Home.checked[item.a0xxuobxbxxxxxxxxxxxsid]}"/>
                        </p:column>
                        <p:column id="columnxxodl">
                            <f:facet id="XxodlFacet" name="header">
                                <h:outputText id="CuodlText" value="${'#'}{messages['line']}" />
                            </f:facet>
                            ${'#'}{item.b1xxzo11bvlxxxxxxxxxline} 
                        </p:column>


                        <p:column id="column2">
                            <f:facet id="TitleFacet" name="header">
                                <h:outputText id="TitleText" value="${'#'}{messages['account']}" />
                            </f:facet>
                            ${'#'}{item.${accountEntityName}.a0xxukwxbvxxxxxxxxxxaccount} 
                        </p:column>     
                        <p:column id="column3">
                            <f:facet id="ActorFacet" name="header">
                                <h:outputText id="ActorText" value="${'#'}{messages['debitamt']}" />
                            </f:facet>
                            <h:inputText value="${'#'}{item.c4xxzxxxbvxxxxxxxxxxdebitamt}">
                            </h:inputText>   
                        </p:column>                        
                        <p:column id="column5">
                            <f:facet id="QuantityFacet" name="header">
                                <h:outputText id="QuantityText" value="${'#'}{messages['creditamt']}" />
                            </f:facet> 
                             <h:inputText id="QuantityValueText" value="${'#'}{item.c5xxzxxxbvxxxxxxxxxxcreditamt}"  />
                        </p:column>                        
                        <p:column id="columnnts">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartNotesText" value="${'#'}{messages['notes']}" />
                            </f:facet>
                            ${'#'}{item.y8xxuznxbvxxxxxxxxxxnotes} 
                        </p:column>

                    </p:dataTable>
             <#elseif menuAttributesFunction =="89">
                        <p:column id="column1">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartNotesText" value="${'#'}{messages['notes']}" />
                            </f:facet>
                            ${'#'}{item.y8xxuznxbvxxxxxxxxxxnotes} 
                        </p:column>

                        <p:column id="column2">
                            <f:facet id="TitleFacet2" name="header">
                                <h:outputText id="TitleText" value="${'#'}{messages['employee']}" />
                            </f:facet>
                            ${'#'}{item.${employeeEntityName}.a0xxuktxbvxxxxxxxxxxemployee} 
                        </p:column>  
                        <p:column id="column3">
                            <f:facet id="TitleFacet3" name="header">
                                <h:outputText id="TitleText2" value="${'#'}{messages['vendor']}" />
                            </f:facet>
                            ${'#'}{item.${vendorEntityName}.a0xxukxxbvxxxxxxxxxxvendor} 
                        </p:column>  
                        <p:column id="column4">
                            <f:facet id="TitleFacet4" name="header">
                                <h:outputText id="TitleText3" value="${'#'}{messages['customer']}" />
                            </f:facet>
                            ${'#'}{item.${customerEntityName}.a0xxukxxbvxxxxxxxxxxcustomer} 
                        </p:column>  
                    </p:dataTable>

             <#elseif pentityFunction !="cp" && pentityFunction !="vp" && pentityFunction!="va" > 
                        <p:column id="column1">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartRemoveText" value="${'#'}{messages['removeColumn']}" />
                            </f:facet>
                            <p:selectBooleanCheckbox id="CartRemoveCheckbox" value="${'#'}{${componentName}Home.checked[item.a0xxuobxbxxxxxxxxxxxsid]}"/>
                        </p:column>
                        <p:column id="columnxxo">
                            <f:facet id="XxoFacet" name="header">
                              <#if pentityFunction == "sh" || pentityFunction == "sv">
                                <h:outputText id="CuoText" value="${'#'}{messages['shipment']}" />
                              <#elseif pentityFunction == "ci" || pentityFunction == "vi">
                                <h:outputText id="CuoText" value="${'#'}{messages['invoice']}" />
                              <#elseif pentityFunction == "cq" || pentityFunction == "vq">
                                <h:outputText id="CuoText" value="${'#'}{messages['quote']}" />
                              <#else>
                                <h:outputText id="CuoText" value="${'#'}{messages['order']}" />
                              </#if> 
                            </f:facet>
                            ${'#'}{item.${componentName}.${keyedKeyName}} 
                        </p:column>     
                        <p:column id="columnxxodl" >
                            <f:facet id="XxodlFacet" name="header">
                                <h:outputText id="CuodlText" value="${'#'}{messages['line']}" />
                            </f:facet>
                 <#if pentityFunction == "cq" > 
                  <#assign cuqdetailsLine="z1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${cuqdetailsLine}} 
                 <#elseif pentityFunction == "co">
                  <#assign cuodetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${cuodetailsLine}} 
                 <#elseif pentityFunction == "ci">
                  <#assign cuidetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${cuidetailsLine}} 
                 <#elseif pentityFunction == "sh">
                  <#assign shipmentdetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${shipmentdetailsLine}} 
                 <#elseif pentityFunction == "vq">
                  <#assign vendqdetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${vendqdetailsLine}} 
                 <#elseif pentityFunction == "vo">
                  <#assign vendodetailsLine="a1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${vendodetailsLine}} 
                 <#elseif pentityFunction == "vi">
                  <#assign vendidetailsLine="a1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${vendidetailsLine}} 
                 <#elseif pentityFunction == "sv">
                  <#assign vshipmendetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${vshipmendetailsLine}} 
                 <#else>
                  <#assign cuodetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${cuodetailsLine}} 
                 </#if>

                        </p:column>     


                        <p:column id="column2">
                            <f:facet id="TitleFacet" name="header">
                                <h:outputText id="TitleText" value="${'#'}{messages['matcode']}" />
                            </f:facet>
                            ${'#'}{item.${itemEntityName}.a0xxukixbxxxxxxxxxxxmatcode} 
                        </p:column>     
                        <p:column id="column3">
                            <f:facet id="ActorFacet" name="header">
                                <h:outputText id="ActorText" value="${'#'}{messages['descript']}" />
                            </f:facet>
                            ${'#'}{item.${itemEntityName}.${itemDescript}} 
                        </p:column>                        
                        <p:column id="column4">
                          <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci">
                            <f:facet id="PriceFacet" name="header">
                                <h:outputText id="PriceText" value="${'#'}{messages['price']}" />
                            </f:facet>
                            <h:outputText id="PriceValueText" value="${'#'}{item.${customerInvoiceEtcItemDetailsPriceFieldName}}" rendered= "${'#'}{!item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" >
                                <f:convertNumber type="currency" currencySymbol="${'#'}{authenticator.currencySymbol}" />
                            </h:outputText>
                            <h:outputText id="PriceValueQuote" value="Request Quotation" rendered= "${'#'}{item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" />
                          <#elseif pentityFunction=="eo">
                            <f:facet id="PriceFacet" name="header">
                                <h:outputText id="PriceText" value="${'#'}{messages['price']}" />
                            </f:facet>
                            <h:outputText id="PriceValueText" value="${'#'}{item.${employeeInvoiceEtcItemDetailsPriceFieldName}}" rendered= "${'#'}{!item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" >
                                <f:convertNumber type="currency" currencySymbol="${'#'}{authenticator.currencySymbol}" />
                            </h:outputText>
                            <h:outputText id="PriceValueQuote" value="Request Quotation" rendered= "${'#'}{item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" />
                          <#elseif pentityFunction=="sh">
                            <f:facet id="PriceFacet" name="header">
                                <h:outputText id="PriceText" value="${'#'}{messages['price']}" />
                            </f:facet>
                            <h:outputText id="PriceValueText" value="${'#'}{item.${itemEntityName}.b8fbzpxxbvxxxxxxxxxxselprice}" rendered= "${'#'}{!item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" >
                             <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
                            </h:outputText>
                            <h:outputText id="PriceValueQuote" value="Request Quotation" rendered= "${'#'}{item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" />
                          <#elseif pentityFunction=="sv">
                            <f:facet id="PriceFacet" name="header">
                                <h:outputText id="PriceText" value="${'#'}{messages['cost']}" />
                            </f:facet>
                            <h:outputText id="PriceValueText" value="${'#'}{item.${itemEntityName}.b6fbzicxbvxxxxxxxxxxcost}" rendered= "${'#'}{!item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" >
                                <f:convertNumber type="currency" currencySymbol="${'#'}{authenticator.currencySymbol}" />
                            </h:outputText>
                            <h:outputText id="PriceValueQuote" value="Request Quotation" rendered= "${'#'}{item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" />
                          <#else>
                            <f:facet id="PriceFacet" name="header">
                                <h:outputText id="PriceText" value="${'#'}{messages['cost']}" />
                            </f:facet>
                            
                            <h:outputText id="PriceValueText" value="${'#'}{item.${vendorInvoiceEtcItemDetailsPriceFieldName}}" rendered= "${'#'}{!item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" >
                                <f:convertNumber type="currency" currencySymbol="${'#'}{authenticator.currencySymbol}" />
                            </h:outputText>

                            <h:outputText id="PriceValueQuote" value="Request Quotation" rendered= "${'#'}{item.${itemEntityName}.c6xxusxrbv16xxxxxxxxtype.contains('(q)')}" />
                          </#if>
                        </p:column>     
                        <ui:remove> could not get ajax working for qty change</ui:remove>                   
                        <p:column id="column5">
                            <f:facet id="QuantityFacet" name="header">
                                <h:outputText id="QuantityText" value="${'#'}{messages['quantity']}" />
                            </f:facet> 
                            <#if pentityFunction=="sh">
                             <h:inputText id="QuantityValueText" value="${'#'}{item.z3xxeqxxbvnxxxxxxxxxqtyshipped}" size="6" readonly="true" />
                            <#elseif pentityFunction=="sv">
                             <h:inputText id="QuantityValueText" value="${'#'}{item.z3xxeqxxbvnxxxxxxxxxqtyshipped}" size="6" readonly="true"/>
                            <#else>
                             <h:inputText id="QuantityValueText" value="${'#'}{item.z3xxeqxxbvnxxxxxxxxxqtyordrd}" size="6" readonly="true" />
                            </#if> 
                        </p:column>   
                        <#if pentityFunction=="sh">
                        <p:column id="shipc">
                            <f:facet name="header">
                                <h:outputText  value="${'#'}{messages['shipping']} ${'#'}{messages['cost']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.z5xxzpxravxxxxxxxxxxshippingprice}" size="6" readonly="true" />
                        </p:column>    
                        </#if>
                        <#if pentityFunction=="sv">
                        <p:column id="shipc">
                            <f:facet name="header">
                                <h:outputText  value="${'#'}{messages['shipping']} ${'#'}{messages['cost']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.z5xxzpxravxxxxxxxxxxshippingprice}" size="6" readonly="true" />
                        </p:column>    
                        </#if>

                        <#if pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi"
                          && (miscchrgField?length > pL) && (deliveryField?length > pL) >
                        <p:column id="columntx1">
                            <f:facet id="tx1" name="header">
                                <h:outputText id="tx1Text" value="${'#'}{messages['tax']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${vendorInvoiceEtcItemDetailsTax1FieldName}}" size="6" readonly="true" />
                        </p:column>    
                        <p:column id="columnmsc">
                            <f:facet id="tx1" name="header">
                                <h:outputText  value="${'#'}{messages['${miscchrgField?substring(pL)?cap_first}']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${vendorInvoiceEtcItemDetailsMiscelleneousFieldName}}" size="6" readonly="true" />
                        </p:column>    
                        <p:column id="columndelv">
                            <f:facet  name="header">
                                <h:outputText  value="${'#'}{messages['${deliveryField?substring(pL)?cap_first}']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${vendorInvoiceEtcItemDetailsDeliveryFieldName}}" size="6" readonly="true" />
                        </p:column>  
                        <p:column id="columnlt">
                            <f:facet  name="header">
                                <h:outputText  value="${'#'}{messages['Linetotal']}" />
                            </f:facet>
                 <#if pentityFunction == "vq" > 
                             <h:inputText  value="${'#'}{item.zfxxzlpxxvxxxxxxxxxxlinetotl}" size="6" readonly="true" />
                 <#elseif pentityFunction == "vo">
                             <h:inputText  value="${'#'}{item.zfxxzlpxxvxxxxxxxxxxlinetotl}" size="6" readonly="true" />
                 <#elseif pentityFunction == "vi">
                             <h:inputText  value="${'#'}{item.zfxxzlpxxvxxxxxxxxxxlinetotl}" size="6" readonly="true" />
                 </#if>   
                        </p:column>  
                        </#if> 
                        <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci"
                           && (miscchrgField?length > pL && deliveryField?length >pL)>
                        <p:column id="columntx1">
                            <f:facet id="tx1" name="header">
                                <h:outputText id="tx1Text" value="${'#'}{messages['tax']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${customerInvoiceEtcItemDetailsTax1FieldName}}" size="6" readonly="true" />
                        </p:column>    
                        <p:column id="columnmsc">
                            <f:facet id="tx1" name="header">
                                <h:outputText  value="${'#'}{messages['${miscchrgField?substring(pL)?cap_first}']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${customerInvoiceEtcItemDetailsMiscelleneousFieldName}}" size="6" readonly="true" />
                        </p:column>    
                        <p:column id="columndelv">
                            <f:facet  name="header">
                                <h:outputText  value="${'#'}{messages['${deliveryField?substring(pL)?cap_first}']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${customerInvoiceEtcItemDetailsDeliveryFieldName}}" size="6" readonly="true" />
                        </p:column>    
                        <p:column id="columnlt">
                            <f:facet  name="header">
                                <h:outputText  value="${'#'}{messages['Linetotal']}" />
                            </f:facet>
                 <#if pentityFunction == "cq" > 
                             <h:inputText  value="${'#'}{item.zgxxzlpxxvxxxxxxxxxxlinetotl}" size="6" readonly="true" />
                 <#elseif pentityFunction == "co">
                             <h:inputText  value="${'#'}{item.zgxxzlpxxvxxxxxxxxxxlinetotl}" size="6" readonly="true" />
                 <#elseif pentityFunction == "ci">
                             <h:inputText  value="${'#'}{item.zgxxzlpxxvxxxxxxxxxxlinetotl}" size="6" readonly="true" />
                 </#if>   
                        </p:column>  
                        </#if> 

                     
                    </p:dataTable>
             <#elseif pentityFunction =="cp" > 
                        <p:column id="column1">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartRemoveText" value="${'#'}{messages['removeColumn']}" />
                            </f:facet>
                            <p:selectBooleanCheckbox id="CartRemoveCheckbox" value="${'#'}{${componentName}Home.checked[item.a0xxuobxbxxxxxxxxxxxsid]}"/>
                        </p:column>
                        <p:column id="columnxxo">
                            <f:facet id="XxoFacet" name="header">
                                <h:outputText id="CuoText" value="${'#'}{messages['payment']}" />
                            </f:facet>
                            ${'#'}{item.${componentName}.${keyedKeyName}} 
                        </p:column>     
                        <p:column id="columnxxodl">
                            <f:facet id="XxodlFacet" name="header">
                                <h:outputText id="CuodlText" value="${'#'}{messages['line']}" />
                            </f:facet>
                            <#assign cuodetailsLine="b1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${cuodetailsLine}} 

                        </p:column>     


                        <p:column id="column3">
                            <f:facet id="ActorFacet" name="header">
                                <h:outputText id="ActorText" value="${'#'}{messages['amount']}"> 
                                 <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
                                </h:outputText>
                            </f:facet>
                            ${'#'}{item.z6xxzxxxavxxxxxxxxxxamountin} 
                        </p:column>   
                        <p:column id="columntx1">
                            <f:facet id="tx1" name="header">
                                <h:outputText id="tx1Text" value="${'#'}{messages['tax']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${customerInvoiceEtcItemDetailsTax1FieldName}}" size="6" readonly="true" />
                        </p:column>    

                     
                        <p:column id="column4">
                            <f:facet id="ActorFacet4" name="header">
                                <h:outputText id="ActorText4" value="${'#'}{messages['Linetotal']}"> 
                                 <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
                                </h:outputText>
                            </f:facet>
                            ${'#'}{item.zgxxzlpxxvxxxxxxxxxxlinetotl} 
                        </p:column>                        
                    </p:dataTable>
             <#elseif pentityFunction =="vp" > 
                        <p:column id="column1">
                            <f:facet id="CartRemoveFacet" name="header">
                                <h:outputText id="CartRemoveText" value="${'#'}{messages['removeColumn']}" />
                            </f:facet>
                            <p:selectBooleanCheckbox id="CartRemoveCheckbox" value="${'#'}{${componentName}Home.checked[item.a0xxuobxbxxxxxxxxxxxsid]}"/>
                        </p:column>
                        <p:column id="columnxxo">
                            <f:facet id="XxoFacet" name="header">
                                <h:outputText id="CuoText" value="${'#'}{messages['payment']}" />
                            </f:facet>
                            ${'#'}{item.${componentName}.${keyedKeyName}} 
                        </p:column>     
                        <p:column id="columnxxodl">
                            <f:facet id="XxodlFacet" name="header">
                                <h:outputText id="CuodlText" value="${'#'}{messages['line']}" />
                            </f:facet>
                            <#assign cuodetailsLine="a1xxzo11bvlxxxxxxxxxline">
                            ${'#'}{item.${cuodetailsLine}} 

                        </p:column>     

                        <p:column id="column3">
                            <f:facet id="ActorFacet" name="header">
                                <h:outputText id="ActorText" value="${'#'}{messages['amount']}">
                                 <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
                                </h:outputText>
                            </f:facet>
                            ${'#'}{item.z6xxzxxxavxxxxxxxxxxamountin} 
                        </p:column>   
                        <p:column id="columntx1">
                            <f:facet id="tx1" name="header">
                                <h:outputText id="tx1Text" value="${'#'}{messages['tax']}" />
                            </f:facet>
                             <h:inputText  value="${'#'}{item.${vendorInvoiceEtcItemDetailsTax1FieldName}}" size="6" readonly="true" />
                        </p:column>    


                        <p:column id="column4">
                            <f:facet id="ActorFacet4" name="header">
                                <h:outputText id="ActorText4" value="${'#'}{messages['Linetotal']}"> 
                                 <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
                                </h:outputText>
                            </f:facet>
                            ${'#'}{item.zfxxzlpxxvxxxxxxxxxxlinetotl} 
                        </p:column>                        
                     
                    </p:dataTable>
             </#if>
           <ui:remove> 
             removed and !${homeName}.instance.y9xxcxxxbv10xxxxxxxxtype.startsWith('cart') from render of update,remove
              why was it there , stopped from button showing if came from list etc
             one schedule can have one detail , so remove the following
           </ui:remove> 
           <#if menuAttributesFunction !="89" && pentityFunction!="va" >
            <#if variation !="quoteorderexists">
             <p:commandButton id="more" styleClass="${'#'}{!${homeName}.managed?'':'buttonMain'}"
                         <#if menuAttributesFunction =="65">
                          value="${'#'}{messages['Confirm']} ${'#'}{messages['next']}/${'#'}{messages['offsetting']}  ${'#'}{messages['entry']}/${'#'}{messages['period']} ${'#'}{messages['entered']}" 
                         <#else>
                          <#if pentityFunction =="cp" || pentityFunction =="vp">
                           value= "${'#'}{messages['Confirm']} ${'#'}{messages['and']} ${'#'}{messages['enter']} ${'#'}{messages['next']} ${'#'}{messages['payment']} ${'#'}{messages['amount']} "  
                          <#else>
                           value= "${'#'}{messages['Confirm']} ${'#'}{messages['next']} ${'#'}{messages['Item']} ${'#'}{messages['selected']}"  
                          </#if>
                         </#if>
                         action="${'#'}{${homeName}.more()}" update="@form"
                       disabled="${'#'}{${homeName}.moreActive}"
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}">
             </p:commandButton>

             <h:commandButton id="update"  styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}"
                         <#if menuAttributesFunction =="65">
                          value="${'#'}{messages['save']} ${'#'}{messages['next']}/${'#'}{messages['offsetting']}  ${'#'}{messages['entry']}" 
                         <#else>
                          value="${'#'}{messages['Save']} ${'#'}{messages['as']} ${'#'}{messages['line']} ${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size()+1}" 
                         </#if>
                         action="${'#'}{${homeName}.updateDetailsAll()}" 
                       <#if pentityFunction =="co" > 
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
                       <#else>
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
                       </#if> 
                      <#if menuAttributesFunction =="65" || pentityFunction =="cp" || pentityFunction =="vp"
                                            || pentityFunction =="ci" || pentityFunction =="vi">
                       <#if menuAttributesFunction =="65">
                        <p:tooltip for="update"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['default']} ${'#'}{messages['posting']} ${'#'}{messages['period']} ${'#'}{customIdentity.curracperiod} ${'#'}{messages['and']} ${'#'}{messages['selected']} ${'#'}{messages['period']} ${'#'}{yxxxuq632xwwqqhxxxxxperioddatesHome.lastyxxxuq632xwwqqhxxxxxperioddatesP} , ${'#'}{messages['select']}/${'#'}{messages['change']} ${'#'}{messages['as']} ${'#'}{messages['needed']}"/></span> </p:tooltip> 
                       <#else>
                        <p:tooltip for="update"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['default']} ${'#'}{messages['posting']} ${'#'}{messages['period']} ${'#'}{customIdentity.curracperiod}  , ${'#'}{messages['select']}/${'#'}{messages['change']} ${'#'}{messages['as']} ${'#'}{messages['needed']}"/></span> </p:tooltip> 
                       </#if> 
                      </#if> 

            </#if>
            <h:commandButton id="remove"  
                          value="${'#'}{messages['remove']} ${'#'}{messages['checked']}  ${'#'}{messages['row']}" 
                         action="${'#'}{${homeName}.updateDetailsAll()}" 
                       <#if pentityFunction =="co" > 
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
                       <#else>
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
                       </#if> 
           </#if>

           <#if pentityFunction =="ci" >
            <h:commandButton id="credit"  
                          value="${'#'}{messages['credit']} ${'#'}{messages['note']}" 
                         action="${'#'}{${homeName}.issueInvoiceCredit()}" 
                       rendered="${'#'}{${homeName}.managed}"/>
           </#if>
           <#if pentityFunction =="co" || pentityFunction =="sh" || pentityFunction =="ci"  >
            <h:commandButton id="mbo"  
                          value="${'#'}{messages['B/O Entry']}" 
                         action="${'#'}{${homeName}.makeBoEntry()}" 
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>

            <ui:remove> credit note part of invoice process

            <h:commandButton id="credit"  
                          value="${'#'}{messages['credit']} ${'#'}{messages['note']}" 
                         action="${'#'}{${homeName}.issueCartCredit()}" 
                       rendered="${'#'}{${homeName}.managed and ${homeName}.instance.y9xxcxxxbv10xxxxxxxxtype.startsWith('cart') and ${homeName}.instance.zcxxzzfxhhxxxxxxxxxxstatusfl==16}"/>
            </ui:remove>

           </#if>
           <#if pentityFunction =="cp" >

      
            <h:commandButton id="close"  
                          value="${'#'}{messages['set']} ${'#'}{messages['as']} ${'#'}{messages['Closed']}" 
                         action="${'#'}{${homeName}.setAsClosed()}" 
                       rendered="${'#'}{${homeName}.managed and ${homeName}.instance.z8xxzzfxhhxxxxxxxxxxstatusfl==16}"/>
           </#if>
            </p:panel>
</#if>
<#if menuAttributesFunction =="9c">
            <p:panel id="lineItems" >

                    <p:dataTable id="LineItemsTable" rendered="${'#'}{${homeName}.managed or ${homeName}.entityDeleted}"
                        tableStyle="table-layout:auto;" value="${'#'}{${componentName}List.entityDetailedList(${componentName}Home.instance.a0xxuobxbxxxxxxxxxxxsid)}" var="item">
                        <p:column id="column1">
                            <f:facet id="an" name="header">
                                <h:outputText id="ant" value="${'#'}{messages['name']}" />
                            </f:facet>
                            <h:outputText value="${'#'}{item.a4xxuuxxbv19xxxxxxxxname}"/>
                        </p:column>

                        <p:column id="column2">
                            <f:facet id="avh" name="header">
                                <h:outputText id="avt" value="${'#'}{messages['value']}" />
                            </f:facet>
                             <h:inputText id="av" value="${'#'}{item.a9xxtxsolxxxxxxxxxxxvalue}" size="6" rendered="true" />
                        </p:column>     
                        <p:column id="column3">
                            <f:facet id="au" name="header">
                                <h:outputText id="aut" value="${'#'}{messages['unit']}" />
                            </f:facet>
                            <h:outputText value="${'#'}{item.a9xxtxsclxxxxxxxxxxxtype}"/>
                        </p:column>
                        <p:column id="column4">
                            <f:facet id="arh" name="header">
                                <h:outputText id="art" value="${'#'}{messages['range']}" />
                            </f:facet>
                            <h:outputText value="${'#'}{item.a8xxuxxrlxxxxxxxxxxxrange}" rendered="true">
                            </h:outputText>   
                        </p:column>                        
                    </p:dataTable>
                    <h:commandButton id="update"  styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}"
                          value="${'#'}{messages['Save']} ${'#'}{messages['as']} ${'#'}{messages['line']} ${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size()+1}" 
                         action="${'#'}{${homeName}.updateDetailsAll()}" 
                       rendered="${'#'}{${homeName}.managed}"/>
            </p:panel>


</#if>
            
                
<div class="actionButtons">
             <p:ajaxStatus name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
    <ui:remove>removed 89 schedule because one schedule one detail,  added va after fixing report to show vendor</ui:remove>
     <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="sh" || pentityFunction=="cp" || pentityFunction == "vq"  || pentityFunction == "vo" 
      || pentityFunction == "vi" || pentityFunction == "vp" || pentityFunction == "va" || pentityFunction == "sv" || pentityFunction == "eo" || menuAttributesFunction ="65" 
       || menuAttributesFunction ="9a" || menuAttributesFunction ="1f" || menuAttributesFunction ="9c"> 
           
           <#if variation =="quoteorderexists">
            <p:commandButton id="save" styleClass="${'#'}{${homeName}.managed?'':'buttonMain'}" 
                          value="${'#'}{messages['convert']} ${'#'}{messages['to']} ${'#'}{messages['${componentName?substring(eL)}']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.extended_persist(true)}"
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() eq 0}">  
            </p:commandButton>   
            <#if pentityFunction=="sh">     
             <h:button outcome="/pickList.xhtml"
              id="opick" styleClass="buttonMain" 
              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}"
              value="${'#'}{messages['Order']} ${'#'}{messages['Pick']}  ${'#'}{messages['List']} ">
              <f:param name="pick" value="po"/>
             </h:button>
             <h:commandButton id="shpd"  styleClass="${'#'}{${homeName}.managed?'':'buttonMain'}"
                          value="${'#'}{messages['set']} ${'#'}{messages['as']} ${'#'}{messages['Shipped']}/${'#'}{messages['PickUp']} ${'#'}{messages['Ready']}" 
                         action="${'#'}{${homeName}.setAsShipped()}" 
                       rendered="${'#'}{${homeName}.managed and ${homeName}.instance.z7xxzzfxhhxxxxxxxxxxstatusfl==1}"/>
            </#if>
           <#elseif pentityFunction == "va">
            <p:commandButton id="save" styleClass="${'#'}{${homeName}.managed?'':'buttonMain'}" 
                          value="${'#'}{messages['Manual_CHQ']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.createManualChq()}"
                       disabled="${'#'}{${homeName}.managed}"
                       rendered="${'#'}{(!${homeName}.managed or ${homeName}.moreActive) and !${homeName}.entityDeleted}">  
            </p:commandButton>  
            <p:commandButton id="genchq" 
                          value="${'#'}{messages['generate']} ${'#'}{messages['cheques']} (${'#'}{messages['for']} ${'#'}{messages['each']} ${'#'}{messages['payment']})" styleClass="${'#'}{${homeName}.managed?'':'buttonMain'}" 
                         action="${'#'}{${homeName}.generateCheques()}" status="buttonStatus" update="@form"
                       disabled="${'#'}{${homeName}.managed}"
                       rendered="${'#'}{(!${homeName}.managed or ${homeName}.moreActive) and !${homeName}.entityDeleted}">  
                        
            </p:commandButton>     

            <p:commandButton id="genchqM" 
                          value="${'#'}{messages['generate']} ${'#'}{messages['cheques']} (${'#'}{messages['one']} ${'#'}{messages['consolidated']}/ ${'#'}{messages['vendor']})" styleClass="${'#'}{${homeName}.managed?'':'buttonMain'}" 
                         action="${'#'}{${homeName}.generateMergedCheques()}" status="buttonStatus" update="@form"
                       disabled="${'#'}{${homeName}.managed}"
                       rendered="${'#'}{(!${homeName}.managed or ${homeName}.moreActive) and !${homeName}.entityDeleted}">  
                        
            </p:commandButton>     
           <#elseif pentityFunction=="sh">  
            <p:commandButton id="save" styleClass="${'#'}{${homeName}.managed?'buttonMain':'buttonMain'}" 
                          value="${'#'}{messages['Save']}" status="buttonStatus" update="@form"
                          action="${'#'}{${homeName}.addWithDetails()}"
                          disabled="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"
                          rendered="${'#'}{!${homeName}.entityDeleted}">  
            </p:commandButton>           
            <h:commandButton id="shpd"  
                          value="${'#'}{messages['set']} ${'#'}{messages['as']} ${'#'}{messages['Shipped']}/${'#'}{messages['PickUp']} ${'#'}{messages['Ready']}" 
                         action="${'#'}{${homeName}.setAsShipped()}" 
                       rendered="${'#'}{${homeName}.managed and ${homeName}.instance.z7xxzzfxhhxxxxxxxxxxstatusfl==1}"/>
            <h:button outcome="/pickList.xhtml"
              id="opick" styleClass="buttonMain" 
              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')}"
              value="${'#'}{messages['Order']} ${'#'}{messages['Pick']}  ${'#'}{messages['List']} ">
              <f:param name="pick" value="po"/>
            </h:button>
           <#elseif menuAttributesFunction =="1f">   
            <p:commandButton id="genser" 
                          value="${'#'}{messages['generate']} ${'#'}{messages['serial']} ${'#'}{messages['numbers']}" styleClass="${'#'}{${homeName}.managed?'':'buttonMain'}" 
                         action="${'#'}{${homeName}.generateSerials('','',28)}" status="buttonStatus" update="@form"
                       disabled="${'#'}{${homeName}.managed}"
                       rendered="${'#'}{(!${homeName}.managed or ${homeName}.moreActive) and !${homeName}.entityDeleted}">  
                        
            </p:commandButton>   
            <p:commandButton id="update" styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}" 
                          value="${'#'}{messages['Update']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.update()}"
                       rendered="${'#'}{${homeName}.managed  and !${homeName}.entityUpdated}"/>
                        			  
            <p:commandButton id="update2" 
                          value="${'#'}{messages['More_Updates']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.update()}"
                       rendered="${'#'}{${homeName}.managed and ${homeName}.entityUpdated}"/>
  
           <#else>
            <p:commandButton id="save" styleClass="${'#'}{${homeName}.managed?'buttonMain':'buttonMain'}" 
                          value="${'#'}{messages['Save']}" status="buttonStatus" update="@form"
                          <#if pentityFunction=="cp" || pentityFunction=="vp">
                           onclick="if (${'#'}{'${componentName}:amtIn'}.value == 0.0) {if (! confirm(jay) ) { return false;}; return true;} "
                          </#if>
                         action="${'#'}{${homeName}.addWithDetails()}"
                       rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() eq 0}">                        
                      <#if menuAttributesFunction =="65" || pentityFunction =="cp" || pentityFunction =="vp"
                                            || pentityFunction =="ci" || pentityFunction =="vi">
                       <#if menuAttributesFunction =="65">
                        <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['default']} ${'#'}{messages['posting']} ${'#'}{messages['period']} ${'#'}{customIdentity.curracperiod} ${'#'}{messages['and']} ${'#'}{messages['selected']} ${'#'}{messages['period']} ${'#'}{yxxxuq632xwwqqhxxxxxperioddatesHome.lastyxxxuq632xwwqqhxxxxxperioddatesP} , ${'#'}{messages['select']}/${'#'}{messages['change']} ${'#'}{messages['as']} ${'#'}{messages['needed']}"/></span> </p:tooltip> 
                       <#else>
                        <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['default']} ${'#'}{messages['posting']} ${'#'}{messages['period']} ${'#'}{customIdentity.curracperiod}  , ${'#'}{messages['select']}/${'#'}{messages['change']} ${'#'}{messages['as']} ${'#'}{messages['needed']}"/></span> </p:tooltip> 
                       </#if> 
                      </#if> 
            </p:commandButton>                                  			  
           </#if>

           <h:commandButton id="delete" 
                         value="${'#'}{messages['Delete']} ${'#'}{messages['${componentName?substring(eL)?cap_first}']}" onclick="if (! confirm('Really delete ?') ) { return false;}; return true; " 
                         action="${'#'}{${homeName}.remove()}"
                       <#if pentityFunction =="co" > 
                        rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 0}">
                       <#else>
                        rendered="${'#'}{${homeName}.managed and !${homeName}.entityDeleted}">
                       </#if>
               <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Use']} ${'#'}{messages['List']} ${'#'}{messages['to']} ${'#'}{messages['delete']} ${'#'}{messages['details']} ${'#'}{messages['records']} ${'#'}{messages['sametime']},${'#'}{messages['but']} ${'#'}{messages['manually']} ${'#'}{messages['delete']} ${'#'}{messages['other']} ${'#'}{messages['constraints']}"/></span> </p:tooltip> 
           </h:commandButton>
          <#if componentName=="cuorders">
            <h:commandButton id="deleteall" 
                          value="${'#'}{messages['Delete']} ${'#'}{messages['All']}" 
                         action="${'#'}{${homeName}.removeall()}"
                        rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 0}"/>
          </#if>
          <#if pentityFunction == "va">
            <h:commandButton id="reprint" 
                          value="${'#'}{messages['Allow']} ${'#'}{messages['Reprint']}" 
                         action="${'#'}{${homeName}.markPaid()}"
                       rendered="${'#'}{${homeName}.instance.z2xxzzfxhhxxxxxxxxxxstatusfl == 512}"/>
          
          <#else>
          </#if>

            <h:button id="new" styleClass="buttonMain" 
             value="New"
             propagation="begin"
             includePageParams="false" 
                  <#if variation="includeaddress">
                    outcome="/${entityName?substring(eL)}Edit.address.xhtml"
                  <#else>
                    outcome="/${entityName?substring(eL)}Edit.xhtml"
                  </#if>
                rendered="${'#'}{${homeName}.managed}"/>


<#--
            <h:commandButton id="markCompleted" 
                          value="${'#'}{messages['Mark_Completed']}" 
                         action="${'#'}{${homeName}.markCompleted()}"
                       rendered="${'#'}{${homeName}.managed}"/>
            <h:commandButton id="marlAllCompleted" 
                          value="${'#'}{messages['Mark_All_Completed']}" 
                         action="${'#'}{${homeName}.markAllCompleted()}"
                       rendered="${'#'}{${homeName}.managed}"/>
-->

     <#else>
                       <ui:remove>
                       allow record 2(shopify id/secret),3
                       disabled="true"
                       </ui:remove>

            <p:commandButton id="save" styleClass="buttonMain" 
                          value="${'#'}{messages['Save']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.persist()}"
                       disabled="${'#'}{!${homeName}.wired}"
                       rendered="${'#'}{!${homeName}.managed  and !${homeName}.entityDeleted and !customIdentity.hasRole('PH')}">  
                        
            </p:commandButton>   
           <#if menuAttributesFunction ="1m">
            <p:commandButton id="saveSys" styleClass="buttonMain" 
                          value="${'#'}{messages['Save']} ${'#'}{messages['In']} ${'#'}{messages['Gallery']}" status="buttonStatus" update="@form" 
                         action="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.persist('SYSTEM')}"
                       disabled="${'#'}{!yxxxuq1m1xwwqqqxxxxxclobdataHome.wired}"
                       rendered="${'#'}{!${homeName}.managed  and customIdentity.masterSite}">  
            </p:commandButton>  
           </#if>
           <#if menuAttributesFunction ="1n">
            <p:commandButton id="saveSys" styleClass="buttonMain" 
                          value="${'#'}{messages['Save']} ${'#'}{messages['In']} ${'#'}{messages['Gallery']}" status="buttonStatus" update="@form" 
                         action="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.persist('SYSTEM')}"
                       disabled="${'#'}{!yxxxuq1n1xwwqqqxxxxxblobdataHome.wired}"
                       rendered="${'#'}{!${homeName}.managed  and customIdentity.masterSite}">  
            </p:commandButton>  
                        <h:commandLink value="${'#'}{messages['Add']} ${'#'}{messages['fading']}" action="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.allowFading(yxxxuq1n1xwwqqqxxxxxblobdataHome.instance)}"
                           rendered="${'#'}{!yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype.contains('asis') and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 1 or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 2) and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-M' or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-C') }"  >
                        </h:commandLink>
                        <h:outputText value="${'#'}{messages['fading']} ${'#'}{messages['added']} ${'#'}{messages['or']} ${'#'}{messages['in']} ${'#'}{messages['place']}" rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype.contains('asis') and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 1 or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 2) and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-M' or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-C') }" />  

                        <h:commandLink value="${'#'}{messages['Remove']} ${'#'}{messages['fading']}" action="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.removeFading(yxxxuq1n1xwwqqqxxxxxblobdataHome.instance)}"
                           rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype.contains('asis') and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 1 or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 2) and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-M' or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-C') }"  >
                        </h:commandLink>
                        <h:outputText value="${'#'}{messages['fading']} ${'#'}{messages['removed']} ${'#'}{messages['or']} ${'#'}{messages['not']} ${'#'}{messages['in']} ${'#'}{messages['place']}" rendered="${'#'}{!yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype.contains('asis') and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 1 or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence == 2) and (yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-M' or yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey =='3R-TOP-BKGR-C') }" />  

            <p:commandButton id="rotate" styleClass="buttonMain" 
                          value="${'#'}{messages['Rotate']}" status="buttonStatus" update="@form"
                         action="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.rotateClockwise90('u')}"
                       rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.managed}"/>
            <h:commandLink  id="resetb" styleClass="hdrLink" onclick="myReload()"  iconClass="pic" value="${'#'}{messages['Reload']}" 
              rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.managed}" >
            </h:commandLink>

           </#if>
          
           <#if menuAttributesFunction ="1r" >
            <ui:remove> allowupdate not done, delete/save will do the same and keep risk low</ui:remove>
            <p:commandButton id="saveSys" styleClass="buttonMain" 
                          value="${'#'}{messages['Save']} ${'#'}{messages['In']} ${'#'}{messages['Shared']} (${'#'}{messages['save_twice_to_pass_validation']})" status="buttonStatus" update="@form" 
                         action="${'#'}{${homeName}.persist('SYSTEM')}"
                       disabled="${'#'}{!${homeName}.wired}"
                       rendered="${'#'}{!${homeName}.managed  and customIdentity.masterSite}">  
            </p:commandButton>  
            <br></br>
             <h:outputText value="${'#'}{messages['Message_bundle']} ${'#'}{messages['default']} ${'#'}{messages['///SYSTEM']}, ${'#'}{messages['structure']}: ${'#'}{messages['m(message)']}, ${'#'}{messages['en(language)']}, ${'#'}{messages['US(country)']} ${'#'}{messages['o2(variant)']}. o2 ${'#'}{messages['makes']} ${'#'}{messages['message']} ${'#'}{messages['site']} ${'#'}{messages['specific']}." /> 
            <br></br>
             <h:outputText value="${'#'}{customIdentity.masterSiteCode} ${'#'}{messages['has']}: ${'#'}{messages['prebult']} ${'#'}{messages['messages']} ${'#'}{messages['for']} ${'#'}{messages['each']} ${'#'}{messages['level']} ${'#'}{messages['except']} ${'#'}{messages['for']} o2. ${'#'}{messages['Lower']} ${'#'}{messages['level']} ${'#'}{messages['overrides']} ${'#'}{messages['upper']} ${'#'}{messages['level']}." /> 
            <br></br>

           </#if>
            <p:commandButton id="update" styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}" 
                          value="${'#'}{messages['Update']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.update()}"
                       rendered="${'#'}{${homeName}.managed  and !${homeName}.entityUpdated}"/>
                        			  
            <p:commandButton id="update2" 
                          value="${'#'}{messages['More_Updates']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.update()}"
                       rendered="${'#'}{${homeName}.managed and ${homeName}.entityUpdated}"/>
                        			  
            <h:commandButton id="delete" 
                          value="${'#'}{messages['delete']}" 
                         action="${'#'}{${homeName}.remove()}"
                       rendered="${'#'}{${homeName}.managed and !${homeName}.entityDeleted}"/>

            <h:button id="new" styleClass="buttonMain" 
                   value="New"
             propagation="begin"
             includePageParams="false" 
                  <#if variation="includeaddress">
                    outcome="/${entityName?substring(eL)}Edit.address.xhtml"
                  <#else>
                    outcome="/${entityName?substring(eL)}Edit.xhtml"
                  </#if>
                      <#if menuAttributesFunction ="52" >
                       rendered="false"/>
                      <#else>
                       rendered="${'#'}{${homeName}.managed}"/>
                      </#if>
                 

            <p:hotkey  action="${'#'}{${homeName}.persist()}" bind="return">
            </p:hotkey>
            <p:hotkey  action="${'#'}{${homeName}.update()}" bind="ctrl+u">
            </p:hotkey>


     </#if>                   			  


            <f:param name="reportName" value="${'#'}{${listName}.${reportName}}"/>
            <f:param name="displayAs" value="${'#'}{${listName}.${displayAs}}" /> 
            <h:button outcome="/${masterPageName}.xhtml" id="list" styleClass="buttonMain" 
              propagation="none"
                <#if menuAttributesFunction ="1s">
                 value="${'#'}{messages['List']} ${'#'}{messages['${componentName?substring(eL)?cap_first}']} ${'#'}{messages['rows']}">
                <#else>
                 value="${'#'}{messages['List']} ${'#'}{messages['${componentName?substring(eL)?cap_first}']}">
                </#if>
            </h:button>  
             <#if pentityFunction=="cp">   
              <p:commandButton id="capture" styleClass="${'#'}{${shipmentEntityName}Home.managed?'buttonMain':'buttonMain'}" 
                          value="${'#'}{messages['Captute']} ${'#'}{messages['Payment']}" status="buttonStatus" update="@form"
                         action="${'#'}{${homeName}.payPalCapturePayment('payerid','guid')}"
                         onclick="if (! confirm('shipment/pickUp/invoice done ?') ) { return false;}; return true; "
                         disabled="${'#'}{${homeName}.instance.a0xxuncpbvxxxxxxxxxxpayment == null}" 
                       rendered="true">  
              </p:commandButton> 
             </#if>
            <h:button id="done" 
                   value="${'#'}{messages['Done']}"
             propagation="end"
                    outcome="/${'#'}{empty ${homeName}.${componentName}From ? '${menuPageName}' : ${homeName}.${componentName}From}.xhtml"
             <#if pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="sh"  
               || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="sv" || pentityFunction=="vp" || pentityFunction=="cp"
                || pentityFunction=="eo" || menuAttributesFunction =="9a" || menuAttributesFunction =="65" || menuAttributesFunction =="89"> 
                rendered="${'#'}{${homeName}.managed or ${homeName}.entityDeleted or ${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
          <ui:remove> needs more work on method rendered and ui issue, look into using EH
            <h:commandButton id="close" 
                          value="${'#'}{messages['Set']} ${'#'}{messages['as']} ${'#'}{messages['Closed']}" 
                         action="${'#'}{${componentName}Home.closeRecord(${componentName}Home.instance)}"
                       rendered="${'#'}{${homeName}.managed and customIdentity.hasRole('UH')}">  
            </h:commandButton>
          </ui:remove>

             <#else>
                rendered="${'#'}{${homeName}.managed or ${homeName}.entityDeleted}"/>
             </#if>

            
            <h:button id="cancel" 
                   value="${'#'}{messages['Cancel']}"
             propagation="end"
                    outcome="/${'#'}{empty ${homeName}.${componentName}From ? '${menuPageName}' : ${homeName}.${componentName}From}.xhtml"
                rendered="${'#'}{!${homeName}.managed and !${homeName}.entityDeleted}"/>

           <#if pentityFunction=="89">
            <h:outputText value="${'#'}{messages['For']} ${'#'}{messages['restricted']} ${'#'}{messages['view']}, ${'#'}{messages['begin']} ${'#'}{messages['schedule']} ${'#'}{messages['description']} ${'#'}{messages['with']} ${'#'}{messages['any']} 4 ${'#'}{messages['characters']} ${'#'}{messages['as']} ${'#'}{messages['passcode']}. ${'#'}{messages['This']} ${'#'}{messages['allows']} ${'#'}{messages['checking']} ${'#'}{messages['next']} ${'#'}{messages['schedule']} ${'#'}{messages['without']} ${'#'}{messages['login']}." />
           </#if>
           <#if pentityFunction=="sv" || pentityFunction=="sh">
              <br></br><h:outputText value="${'#'}{messages['Shipment']} ${'#'}{messages['reference']} ${'#'}{messages['should']} ${'#'}{messages['contain']} ${'#'}{messages['some']} ${'#'}{messages['numeric']} ${'#'}{messages['digits']} ${'#'}{messages['for']} ${'#'}{messages['barcode']}, ${'#'}{messages['recommend']} ${'#'}{messages['using']} ${'#'}{messages['date']} ${'#'}{messages['time']} ${'#'}{messages['like']} ${'#'}{messages['shvrt20092623']}." />
           </#if>
           <#if pentityFunction=="sv">
             <br></br>  
             <ui:fragment rendered="${'#'}{(customIdentity.product == 'e' and customIdentity.subProduct == 'f')}">
              <h:outputText value="${'#'}{messages['enter']} ${'#'}{messages['material']} ${'#'}{messages['weight']}/${'#'}{messages['length']}/${'#'}{messages['etc']} ${'#'}{messages['as']} ${'#'}{messages['quantity']}, ${'#'}{messages['if']} ${'#'}{messages['serial']} ${'#'}{messages['number']} ${'#'}{messages['field']} ${'#'}{messages['value']} ${'#'}{messages['is']} ${'#'}{messages['keyedIn']} ${'#'}{messages['or']} ${'#'}{messages['scanned']}."/>
              <br></br><h:outputText value="${'#'}{messages['Item']} ${'#'}{messages['count']} ${'#'}{messages['quantity']} ${'#'}{messages['will']} ${'#'}{messages['be']} ${'#'}{messages['impicit']} ${'#'}{messages['as']} ${'#'}{messages['one']}." />
              <br></br>
              <h:outputText value="${'#'}{messages['At']} ${'#'}{messages['ItemProcessingJob']} ${'#'}{messages['create']}, ${'#'}{messages['enter']} ${'#'}{messages['same']} ${'#'}{messages['serialnumber']} ${'#'}{messages['to']} ${'#'}{messages['track']} ${'#'}{messages['consumption']}."/>
              <br></br><hr></hr>
              <h:outputText value="${'#'}{messages['Use']} ${'#'}{messages['serialized']} ${'#'}{messages['inventory']} ${'#'}{messages['only']} ${'#'}{messages['for']} ${'#'}{messages['special']} ${'#'}{messages['need']}, ${'#'}{messages['like']} ${'#'}{messages['material']} ${'#'}{messages['usage']} ${'#'}{messages['or']} ${'#'}{messages['for']} ${'#'}{messages['say']} ${'#'}{messages['defence']} ${'#'}{messages['contract']}.  " /> 
              <br></br><h:outputText value="${'#'}{messages['Unlike']} ${'#'}{messages['regular']} ${'#'}{messages['inventory']}, ${'#'}{messages['each']} ${'#'}{messages['physical']} ${'#'}{messages['item']} ${'#'}{messages['for']} ${'#'}{messages['a']} ${'#'}{messages['product']} ${'#'}{messages['will']} ${'#'}{messages['have']} ${'#'}{messages['its']} ${'#'}{messages['own']} ${'#'}{messages['serialnumber']}.  " /> 
             </ui:fragment>
           </#if>
           <#if menuAttributesFunction =="1f"> 
             <br></br>  
             <ui:fragment rendered="${'#'}{(customIdentity.product == 'e' and customIdentity.subProduct == 'f')}">
              <h:outputText value="${'#'}{messages['Use']} ${'#'}{messages['serialized']} ${'#'}{messages['inventory']} ${'#'}{messages['only']} ${'#'}{messages['for']} ${'#'}{messages['special']} ${'#'}{messages['need']}, ${'#'}{messages['like']} ${'#'}{messages['material']} ${'#'}{messages['usage']} ${'#'}{messages['or']} ${'#'}{messages['for']} ${'#'}{messages['say']} ${'#'}{messages['defence']} ${'#'}{messages['contract']}.  " /> 
              <br></br><h:outputText value="${'#'}{messages['Unlike']} ${'#'}{messages['regular']} ${'#'}{messages['inventory']}, ${'#'}{messages['each']} ${'#'}{messages['physical']} ${'#'}{messages['item']} ${'#'}{messages['for']} ${'#'}{messages['a']} ${'#'}{messages['product']} ${'#'}{messages['will']} ${'#'}{messages['have']} ${'#'}{messages['its']} ${'#'}{messages['own']} ${'#'}{messages['serialnumber']}.  " /> 
              <br></br><hr></hr>
              <h:outputText value="${'#'}{messages['Last']} ${'#'}{messages['Serial']} ${'#'}{messages['Generated']}: ${'#'}{fxxxuq1ffxwwqqhefxxxserialnumbersList.getSuggestList('s').size() gt 0?fxxxuq1ffxwwqqhefxxxserialnumbersList.getSuggestList('s').get(fxxxuq1ffxwwqqhefxxxserialnumbersList.getSuggestList('s').size()-1).a0xxukxxbvxxxxxxxxxxserialno:'none'}"/>
              <br></br><h:outputText value="${'#'}{messages['Generate']} ${'#'}{messages['Serial']} ${'#'}{messages['number']} ${'#'}{messages['creates']} ${'#'}{messages['next']} ${'#'}{messages['set']} ${'#'}{messages['of']} ${'#'}{messages['28']} ${'#'}{messages['labels']}  ${'#'}{messages['type']} ${'#'}{messages['s']}" /> 
              <br></br><h:outputText value="${'#'}{messages['Then']} ${'#'}{messages['use']} ${'#'}{messages['Mailings']}- ${'#'}{messages['Labels']}- ${'#'}{messages['Serialnumbers']} ${'#'}{messages['to']} ${'#'}{messages['print']}, ${'#'}{messages['barcoded']} ${'#'}{messages['labels']}." />
              <br></br>
              <h:outputText value="${'#'}{messages['At']} ${'#'}{messages['Vshipmen']} ${'#'}{messages['receive']}, ${'#'}{messages['enter']} ${'#'}{messages['material']} ${'#'}{messages['weight']}/${'#'}{messages['length']}/${'#'}{messages['etc']} ${'#'}{messages['as']} ${'#'}{messages['quantity']}, ${'#'}{messages['if']} ${'#'}{messages['serial']} ${'#'}{messages['number']} ${'#'}{messages['field']} ${'#'}{messages['value']} ${'#'}{messages['is']} ${'#'}{messages['keyedIn']} ${'#'}{messages['or']} ${'#'}{messages['scanned']}."/>
              <br></br><h:outputText value="${'#'}{messages['Item']} ${'#'}{messages['count']} ${'#'}{messages['quantity']} ${'#'}{messages['will']} ${'#'}{messages['be']} ${'#'}{messages['impicit']} ${'#'}{messages['as']} ${'#'}{messages['one']}." />
              <br></br>
              <h:outputText value="${'#'}{messages['Then']} ${'#'}{messages['at']} ${'#'}{messages['ItemProcessingJob']} ${'#'}{messages['create']}, ${'#'}{messages['enter']} ${'#'}{messages['serialnumber']} ${'#'}{messages['to']} ${'#'}{messages['track']} ${'#'}{messages['consumption']}."/>
             </ui:fragment>
           </#if>
            <#if menuAttributesFunction ="89" >
             <h:commandButton id="eVite" value="${'#'}{messages['Invite']}"  status="buttonStatus"
              action="${'#'}{${listName}.eVite('XML',${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,false)}" rendered="${'#'}{${homeName}.managed or ${homeName}.entityDeleted}"/>
            </#if>
     <#if menuAttributesFunction ="1b" >
            <h:commandButton id="salesdata" 
                          value="${'#'}{messages['Refresh_Sales_data']}" 
                         action="${'#'}{${homeName}.loadSalesData()}"
                       disabled="${'#'}{${homeName}.managed}"
                       rendered="${'#'}{(!${homeName}.managed or ${homeName}.moreActive) and !${homeName}.entityDeleted}">  
                        
            </h:commandButton>    
    <#elseif menuAttributesFunction ="1r" >
            <h:commandButton id="reload" 
                          value="${'#'}{messages['load']} ${'#'}{messages['new']}/${'#'}{messages['changed']} ${'#'}{messages['messages']}" 
                         action="${'#'}{databaseResourceLoader.reLoadBundle(${resource_bundleEntityName}Home.getLastyxxxuq1l1xwwqqhxxxxxresource_bundleP(),customIdentity.owner2)}"
                       rendered="${'#'}{${homeName}.picked or ${homeName}.entityUpdated}"/>

            <h:outputText  value="${'#'}{messages['load']} ${'#'}{messages['once']} ${'#'}{messages['after']} ${'#'}{messages['all']} ${'#'}{messages['changes']} ${'#'}{messages['done']}, ${'#'}{messages['more']} ${'#'}{messages['efficient']} ${'#'}{messages['use']} " rendered="${'#'}{${homeName}.picked or ${homeName}.entityUpdated}" />
  
     </#if>                            			  

            <#if componentName=="cuorders">
             <h:commandButton id="next" styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}"
                          value="Next" 
                         action="${'#'}{${homeName}.next()}"
                       rendered="${'#'}{${homeName}.multipicked}"/>
             <h:commandButton id="prev" 
                          value="Prev" 
                         action="${'#'}{${homeName}.prev()}"
                       rendered="${'#'}{${homeName}.multipicked}"/>
           </#if>
     <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="va"
           || pentityFunction=="eo"  || pentityFunction=="cp"  || pentityFunction=="vp"    ) 
             || pentityFunction=="sh"  || pentityFunction=="sv"  > 
            <h:commandButton id="refreshj" 
                          value="${'#'}{messages['Refresh']} ${'#'}{messages['data']}" 
                         action="${'#'}{${homeName}.showtemprunt()}"
                       rendered="${'#'}{!${homeName}.managed}"/>
     </#if>   

          <#if menuAttributes?contains("T") >
           <h:panelGroup>
            <#--
             onclick part needs h:commandButton but if form is submitted without reqd value entered validation error 
             look into both h:button and h:command but rendered via managed status.
             also look into start/end logic 
             _blank means stay on same window after redirect via action
             put mailingAddress validation
             setup start/end the same and value of current key ie purchase no not sid
            -->
            <#--   ${homeName} - ${keyedKeyName}
            <#if pentityFunction=="vo">
             <h:commandButton id="genO" 
                          value="${'#'}{messages['Generate']} re-${'#'}{messages['orders']} [${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getCountItemsToOrder()}]" 
                         action="${'#'}{trexuq344xwwqqhxxxxxvendordersHome.generateOrders()}"
                         disabled="${homeName}.moreActive)"
                       rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getCountItemsToOrder() gt 0}">
               <p:tooltip > <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Create']} ${'#'}{messages['vendor']} ${'#'}{messages['orders']} ${'#'}{messages['for']} ${'#'}{messages['items']} ${'#'}{messages['below']} ${'#'}{messages['reorder']} ${'#'}{messages['level']},}"/></span> </p:tooltip> 
             </h:commandButton>
           </#if>
            -->

            &nbsp;&nbsp;
            <h:panelGrid columns="2">
             <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['report.displayAs']}</ui:define>
                <p:selectOneMenu id="displayAs" value="${'#'}{${listName}.displayAs}">
                 <f:selectItem id="ditem2" itemLabel="HTML" itemValue="HTML" />
                 <f:selectItem id="ditem1" itemLabel="PDF" itemValue="PDF" />
                </p:selectOneMenu> 
             </ui:decorate>
            </h:panelGrid>
            <#if menuAttributesFunction !="36" > 
             <h:commandButton id="ePrint" value="${'#'}{messages['Print']}/${'#'}{messages['Preview']} ${'#'}{messages['report']}"   onclick="this.form.target='_blank'"
               action="${'#'}{${listName}.ePrint('IGNORE',${homeName}.instance.${keyedKeyName},${homeName}.instance.${keyedKeyName},false,'${entityName}Master')}"
                rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
            </#if>

            <#if menuAttributesFunction !="36" > 
             <h:commandButton id="email" value="Email_to" onclick="this.form.target='_self'"
               action="${'#'}{${listName}.eSend('EMAIL'.concat(${listName}.displayAs),${homeName}.instance.${keyedKeyName},${homeName}.instance.${keyedKeyName},false,${homeName}.EMailingAddress)}"
                rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
            </#if>

            <#if menuAttributesFunction !="36" > 
               <ui:fragment id="ejay"  template="layout/edit.xhtml" 
                rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}">
               <ui:define name="label">${'#'}{messages['emailTo']} 
               </ui:define>
               <h:inputText  id="eMailA"
                          size="35"
                     maxlength="50"
                         value="${'#'}{${homeName}.EMailingAddress}">
               </h:inputText>
               </ui:fragment>
            </#if>
            <#if menuAttributesFunction?contains("25") >
              <h:commandButton id="shLabel" value="${'#'}{messages['shipment']} ${'#'}{messages['label']}"   onclick="this.form.target='_blank'"
                action="${'#'}{${listName}.eLabel(messages['cpono'].concat(' ').concat(${homeName}.instance.${cuordersEntityName}.a0xxuncobvxxxxxxxxxxpurchsno),'PDF',${homeName}.instance.${customerEntityName}.${customerKeyField},${homeName}.instance.${customerEntityName}.${customerKeyField},false,'${customerEntityName?cap_first}labelsReport')}" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}"/>
            </#if>
           </h:panelGroup>
         <#if menuAttributesFunction ="36" > 
          <h:panelGrid columns="1" rendered="${'#'}{${listName}.suggest(${homeName}.prefix).size() ge 1}">
         <#else>
          <h:panelGrid columns="1" rendered="${'#'}{${listName}.entityLessStatusDetailedList(${homeName}.instance.a0xxuobxbxxxxxxxxxxxsid,-1).size() ge 1}">
         </#if>
            <ui:remove>tbd inputText or clobdata 3R-mailingS.. to change defaultGreeting setMailingSubject</ui:remove>
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['Greeting']} ${'#'}{messages['text']}- ${'#'}{messages['Transaction']} ${'#'}{messages['Receipt']} ${'#'}{messages['from']} ${'#'}{customIdentity.owner2}
                   </ui:define>
                <pe:ckEditor id="editor" height="100" width="100%"  value="${'#'}{${listName}.mailingSource}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
                </pe:ckEditor>
            </ui:decorate>
          </h:panelGrid >
          </#if>
     <#if menuAttributesFunction ="56" >
      <h:outputText value="     "/>
      <h:outputText value="${'#'}{messages['theme']}"/>
      <h:selectOneMenu value="${'#'}{${homeName}.userSkin}">
       <f:selectItems value="${'#'}{skinBean.skinsList}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
      </h:selectOneMenu>

            <h:commandButton id="setTheme" 
                          value="${'#'}{messages['set']} ${'#'}{messages['theme']}" 
                         action="${'#'}{${homeName}.setUserTheme()}"/>
      <br></br>
          <#assign keyField="a0xxukuxbvxxxxxxxxxxid"> 
          <br></br>
          <h:panelGroup>
           <h:commandButton id="email" value="Email_to" onclick="this.form.target='_self'"
               action="${'#'}{${listName}.eSend('UEMAIL',${homeName}.instance.${keyField},${homeName}.instance.${keyField},false,${homeName}.EMailingAddress)}" rendered="${'#'}{yxxxuh566xwwqqwxxxxxuserList.suggest(yxxxuh566xwwqqwxxxxxuserHome.prefix).size() ge 1}"/>
           <ui:fragment id="ejay"  template="layout/edit.xhtml" rendered="${'#'}{yxxxuh566xwwqqwxxxxxuserList.suggest(yxxxuh566xwwqqwxxxxxuserHome.prefix).size() ge 1}">
               <ui:define name="label">${'#'}{messages['emailTo']} 
               </ui:define>
            <h:inputText  id="eMailA"
                          size="35"
                     maxlength="50"
                         value="${'#'}{${homeName}.EMailingAddress}">
            </h:inputText>
           </ui:fragment>
          </h:panelGroup>
          <h:panelGrid columns="1" rendered="${'#'}{yxxxuh566xwwqqwxxxxxuserList.suggest(yxxxuh566xwwqqwxxxxxuserHome.prefix).size() ge 1}">
            <ui:decorate template="layout/display.xhtml">
                <ui:define name="label">${'#'}{messages['Greeting']} ${'#'}{messages['text']}</ui:define>
                <pe:ckEditor id="editor" height="100" width="100%"  value="${'#'}{${listName}.mailingSource}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
                </pe:ckEditor>
            </ui:decorate>
          </h:panelGrid >
     </#if>   

     <#if menuAttributesFunction ="52" >
      <h:outputText value="     "/>
      <h:outputText value="${'#'}{messages['theme']}"/>
      <p:selectOneMenu value="${'#'}{${homeName}.clientSkin}">
       <f:selectItems value="${'#'}{skinBean.skinsList}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
      </p:selectOneMenu>

            <h:commandButton id="setTheme" 
                          value="${'#'}{messages['set']} ${'#'}{messages['theme']}" 
                         action="${'#'}{${homeName}.setClientTheme()}"/>
     </#if>   

        <#if (menuAttributesFunction =="59") >
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
         <h:outputText value="${'#'}{messages['step']} : 0  ${'#'}{messages['value']} amount like 8.90 or 5.00 "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']}  (${'#'}{messages['can']} ${'#'}{messages['also']} ${'#'}{messages['hold']} (${'#'}{messages['item']} ${'#'}{messages['key']}, ${'#'}{messages['value']}) ${'#'}{messages['special']} ${'#'}{messages['shipping']} ${'#'}{messages['charge']} "/>
         <br></br><br></br> 
         <h:outputText value="${'#'}{messages['usertype']} : DC ${'#'}{messages['item']} ${'#'}{messages['discount']} ${'#'}{messages['coupon']} or DC% (${'#'}{messages['if']} ${'#'}{messages['discount']} ${'#'}{messages['value']} ${'#'}{messages['is']} (${'#'}{messages['in']} ${'#'}{messages['percentage']}), SC (${'#'}{messages['subscription']} ${'#'}{messages['discount']} ${'#'}{messages['coupon']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['prodtype']} : P (${'#'}{messages['production']}"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : ${'#'}{messages['Coupon']} ${'#'}{messages['override']} ANY (${'#'}{messages['any']} ${'#'}{messages['item']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['stepname']} : ${'#'}{messages['Coupon']} ${'#'}{messages['override']} ${'#'}{messages['item']} ${'#'}{messages['id']} (${'#'}{messages['like']}) ${'#'}{messages['281']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['step']} : 0 or nnn number of random coupons if incentive contains #random "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['value']} amount like 8.90 or 5.00 or if userType SC then 180 for 180 days period or 0 if random coupon (365 is harcoded) "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['incentive']} : ${'#'}{messages['Coupon']} ${'#'}{messages['name']}  (${'#'}{messages['DC']}- ${'#'}{messages['backtoschool21']}), (${'#'}{messages['SC']}-${'#'}{messages['trial3R36517']}), (${'#'}{messages['SC']}-${'#'}{messages['renew3R39520']}) ${'#'}{messages['or']} ${'#'}{messages['prefix']} ${'#'}{messages['#random']} "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['incentive']} : ${'#'}{messages['if']} ${'#'}{messages['userType']}  ${'#'}{messages['SC']}, ${'#'}{messages['incentive']} ${'#'}{messages['name']} ${'#'}{messages['must']} ${'#'}{messages['contain']} ${'#'}{messages['trial']} ${'#'}{messages['or']} ${'#'}{messages['renew']} ${'#'}{messages['matching']} ${'#'}{messages['subcription']} ${'#'}{messages['period']} "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['Effdate']} : ${'#'}{messages['Coupon']} ${'#'}{messages['effective']}  ${'#'}{messages['date']} "/>
         <br></br> 
         <h:outputText value="${'#'}{messages['Enddate']} : ${'#'}{messages['Coupon']} ${'#'}{messages['end']}  ${'#'}{messages['date']} "/>
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
         <h:outputText value="${'#'}{messages['step']} : 0  ${'#'}{messages['value']} amount 0.00 (${'#'}{messages['not']} ${'#'}{messages['used']})"/>
         <br></br> 
         <h:outputText value="${'#'}{messages['incentive']} : ${'#'}{messages['Site']} ${'#'}{messages['productCode']}  (${'#'}{messages['example']}: ${'#'}{messages['ee']} (${'#'}{messages['Business']} ${'#'}{messages['Ecommerce']},${'#'}{messages['oa']} (${'#'}{messages['Organization']} ${'#'}{messages['Association']} )"/>
         </ui:fragment>

        </#if>



</div>
</p:panel>
      <ui:remove>
       <p:messages ajaxRendered="true"  />
      </ui:remove>


<p:panel>
<#assign hasAssociations=false>
<#foreach property in pojo.allPropertiesIterator>
 <#if c2h.isManyToOne(property) || c2h.isOneToManyCollection(property)>
  <#assign hasAssociations=true>
 </#if>
</#foreach>

<#if hasAssociations>
<p:panel header="${'#'}{messages['NavigationToggle']}" switchType="server" collapsed="true" rendered="${'#'}{${homeName}.managed}"
     leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png" toggleable="true" toggleableHeader="true">
<div  style="overflow: auto;width: 850px;height: auto; ">
</#if>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length > eL )>
<#if c2h.isManyToOne(property)>
 <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
 <#if (parentPojo.shortName?length > eL )>
 <#assign parentPageName = parentPojo.shortName?substring(eL)>
 <#assign parentName = util.lower(parentPojo.shortName)>
 <#assign tabSeq=tabSeq+1>
  <#if tabSeq=1>
  <p:tabView switchType="ajax">
  </#if>
   <ui:remove > addres gives lazy loading error, needs more checking</ui:remove>
   <#if !property.name?contains("address")>
    <p:tab title="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
    <div class="association" id="${property.name}Parent">
        
        <h:outputText value="No ${property.name?substring(pL)}" 
                   rendered="${'#'}{${homeName}.instance.${property.name} == null}"/>
        
        <p:dataTable var="${parentName}" tableStyle="table-layout:auto;"
                   value="${'#'}{${homeName}.instance.${property.name}}" 
                rendered="${'#'}{${homeName}.instance.${property.name} != null}"
              rowClasses="rvgRowOne,rvgRowTwo"
                      id="${property.name}Table">
            <p:column>
            <#if (parentName?length > eL )>
                <f:facet name="header">action</f:facet>
                <h:link id="view${parentName?substring(eL)}" 
                     value="View" 
                      outcome="/${parentPageName}.xhtml">
                      <#if parentPojo.isComponent(parentPojo.identifierProperty)>
                       <#foreach componentProperty in parentPojo.identifierProperty.value.propertyIterator>
                        <f:param disable="${'#'}{empty ${parentName}.${parentPojo.identifierProperty.name}.${componentProperty.name}}" name="${parentName}${util.upper(componentProperty.name)}" 
                            value="${'#'}{${parentName}.${parentPojo.identifierProperty.name}.${componentProperty.name}}"/>
                       </#foreach>
                      <#else>
                       <f:param disable="${'#'}{empty ${parentName}.${parentPojo.identifierProperty.name}}" name="${parentName}${util.upper(parentPojo.identifierProperty.name)}" 
                           value="${'#'}{${parentName}.${parentPojo.identifierProperty.name}}"/>
                      </#if>
                </h:link>
            </#if>
            </p:column>
              <#foreach parentProperty in parentPojo.allPropertiesIterator>
              <#if (parentProperty.name?length >eL)>
               <#if !c2h.isCollection(parentProperty) && !c2h.isManyToOne(parentProperty)>
                <#if parentPojo.isComponent(parentProperty)>
                 <#foreach componentProperty in parentProperty.value.propertyIterator>
                 <#if (componentProperty.name?length >eL)>
                  <#if ( ((componentProperty.name?substring(pfS,pfE)!="za") && (componentProperty.name?substring(pfS,pfE)!="zb") && (componentProperty.name?substring(pfS,pfE)!="zd") && (componentProperty.name?substring(pfS,pfE)!="zf") && (componentProperty.name?substring(pfS,pfE)!="zt") && (componentProperty.name?substring(pfS,pfE)!="to")) && ((componentProperty.name?substring(0,1) == "y") || (componentProperty.name?substring(0,1) == "z" )
                   || (componentProperty.name?substring(0,6) == "a0xxuo" ) ) )   >
                  <#else>
                  <p:column>
                   <f:facet name="header">${componentProperty.name?substring(pL)}</f:facet>
                    ${'#'}{${parentName}.${parentProperty.name}.${componentProperty.name}}
                  </p:column>
                  </#if>
                 </#if>
                 </#foreach>
                <#else>
                 <#if ( ((parentProperty.name?substring(pfS,pfE)!="za") && (parentProperty.name?substring(pfS,pfE)!="zb") && (parentProperty.name?substring(pfS,pfE)!="zd") && (parentProperty.name?substring(pfS,pfE)!="zf") && (parentProperty.name?substring(pfS,pfE)!="zt") && (parentProperty.name?substring(pfS,pfE)!="to")) && ((parentProperty.name?substring(0,1) == "y") || (parentProperty.name?substring(0,1) == "z" )
                   || (parentProperty.name?substring(0,6) == "a0xxuo" ) ) )   >
                 <#else>
                 <p:column>
                  <f:facet name="header">${parentProperty.name?substring(pL)}</f:facet>
                   ${'#'}{${parentName}.${parentProperty.name}}
                 </p:column>
                 </#if>
                </#if>
               </#if>
               <#if c2h.isManyToOne(parentProperty)>
                <#assign parentParentPojo = c2j.getPOJOClass(cfg.getClassMapping(parentProperty.value.referencedEntityName))>
                <#if (parentProperty.name?length >eL && parentParentPojo.identifierProperty.name?length >eL)>
                <#if parentParentPojo.isComponent(parentParentPojo.identifierProperty)>
                 <#foreach componentProperty in parentParentPojo.identifierProperty.value.propertyIterator>
                 <#if (componentProperty.name?length >eL)>
                  <#if ( ((parentProperty.name?substring(pfS,pfE)!="za") && (parentProperty.name?substring(pfS,pfE)!="zb") && (parentProperty.name?substring(pfS,pfE)!="zd") && (parentProperty.name?substring(pfS,pfE)!="zf") && (parentProperty.name?substring(pfS,pfE)!="zt") && (parentProperty.name?substring(pfS,pfE)!="to")) && ((parentProperty.name?substring(0,1) == "y") || (parentProperty.name?substring(0,1) == "z" )
                   || (parentProperty.name?substring(0,6) == "a0xxuo" ) ) )   >
                  <#else>
                  <p:column>
	    	        <f:facet name="header">${parentProperty.name?substring(pL)} ${componentProperty.name?substring(pL)}</f:facet>
		    	    ${'#'}{${parentName}.${parentProperty.name}.${parentParentPojo.identifierProperty.name}.${componentProperty.name}}
                  </p:column>
                  </#if>
                 </#if>
                 </#foreach>
                <#else>
                 <#if ( ((parentProperty.name?substring(pfS,pfE)!="za") && (parentProperty.name?substring(pfS,pfE)!="zb") && (parentProperty.name?substring(pfS,pfE)!="zd") && (parentProperty.name?substring(pfS,pfE)!="zf") && (parentProperty.name?substring(pfS,pfE)!="zt") && (parentProperty.name?substring(pfS,pfE)!="to")) && ((parentProperty.name?substring(0,1) == "y") || (parentProperty.name?substring(0,1) == "z" )
                   || (parentProperty.name?substring(0,6) == "a0xxuo" ) ) )   >
                 <#else>
                 <p:column>
	    	       <f:facet name="header">${parentProperty.name?substring(pL)} ${parentParentPojo.identifierProperty.name?substring(pL)}</f:facet>
		    	  ${'#'}{${parentName}.${parentProperty.name}.${parentParentPojo.identifierProperty.name}}
                 </p:column>
                 </#if>
                </#if>
                </#if>
               </#if>
              </#if>
              </#foreach>
        </p:dataTable>
    </div>
    </p:tab>
   </#if>
</#if>
</#if>
 <#if c2h.isOneToManyCollection(property) && (property.name?length >eL)>
    <#assign tabSeq=tabSeq+1>
  <#if tabSeq=1>
  <p:tabView switchType="ajax">
  </#if>
    <#if (property.name?length > pL) && property.name?ends_with("ses")>
     <p:tab title="${'#'}{messages['${property.name?substring(eL,property.name.length()-2)?cap_first}']}">
    <#elseif property.name?ends_with("ies")>
     <p:tab title="${'#'}{messages['${property.name?substring(eL,property.name.length()-3)?cap_first}y']}">
    <#else>  
     <p:tab title="${'#'}{messages['${property.name?substring(eL,property.name.length()-1)?cap_first}']}">
    </#if>
        <div class="association" id="${property.name}Children">
         <#assign childPojo = c2j.getPOJOClass(property.value.element.associatedClass)>
         <#if (childPojo.shortName?length > eL)>
         <#assign childPageName = childPojo.shortName?substring(eL)>
         <#assign childEditPageName = childPojo.shortName?substring(eL) + "Edit">
         <#assign childName = util.lower(childPojo.shortName)>
         <ui:remove></ui:remove>
            <h:outputText value="No ${property.name?substring(pL)}" 
                       rendered="${'#'}{empty ${homeName} or empty ${homeName}.${property.name}}"/>
        
            <p:dataTable value="${'#'}{${homeName}.${property.name}}" tableStyle="table-layout:auto;"
                           var="${childName}" 
                      rendered="${'#'}{not empty ${homeName}.${property.name}}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="${property.name}Table">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/${childPageName}.xhtml" 
                              id="select${childName}" 
                           value="Select"
                     propagation="none">
                     <#if childPojo.isComponent(childPojo.identifierProperty)>
                      <#foreach componentProperty in childPojo.identifierProperty.value.propertyIterator>
                        <f:param disable="${'#'}{empty ${childName}.${childPojo.identifierProperty.name}.${componentProperty.name}}" name="${childName}${util.upper(componentProperty.name)}" 
                                value="${'#'}{${childName}.${childPojo.identifierProperty.name}.${componentProperty.name}}"/>
                      </#foreach>
                     <#else>
                        <f:param disable="${'#'}{empty ${childName}.${childPojo.identifierProperty.name}}" name="${childName}${util.upper(childPojo.identifierProperty.name)}" 
                                value="${'#'}{${childName}.${childPojo.identifierProperty.name}}"/>
                     </#if>
                        <f:param name="${childName}From" value="${entityName}"/>
                    </h:link>
                </p:column>
             <#foreach childProperty in childPojo.allPropertiesIterator>
             <#if (childProperty.name?length >eL)>
              <#if !c2h.isCollection(childProperty) && !c2h.isManyToOne(childProperty)>
               <#if childPojo.isComponent(childProperty)>
                <#foreach componentProperty in childProperty.value.propertyIterator> 
                <#if (componentProperty.name?length > pL) >
                 <#if x ( ((componentProperty.name?substring(pfS,pfE)!="za") && (componentProperty.name?substring(pfS,pfE)!="zb") && (componentProperty.name?substring(pfS,pfE)!="zd") && (componentProperty.name?substring(pfS,pfE)!="zf") && (componentProperty.name?substring(pfS,pfE)!="zt") && (componentProperty.name?substring(pfS,pfE)!="to")) && ((componentProperty.name?substring(0,1) == "y") || (componentProperty.name?substring(0,1) == "z" )
                   || (componentProperty.name?substring(0,6) == "a0xxuo" ) ) )   >
                 <#else>
                 <p:column>
                    <f:facet name="header">${componentProperty.name?substring(pL)}</f:facet>
                    ${'#'}{${childName}.${childProperty.name}.${componentProperty.name}}
                 </p:column>
                 </#if>
                </#if>
                </#foreach>
               <#else>
                <#if (childProperty.name?length > pL) && ( ((childProperty.name?substring(pfS,pfE)!="za") && (childProperty.name?substring(pfS,pfE)!="zb") && (childProperty.name?substring(pfS,pfE)!="zd") && (childProperty.name?substring(pfS,pfE)!="zf") && (childProperty.name?substring(pfS,pfE)!="zt") && (childProperty.name?substring(pfS,pfE)!="to")) && ((childProperty.name?substring(0,1) == "y") || (childProperty.name?substring(0,1) == "z" )
                   || (childProperty.name?substring(0,6) == "a0xxuo" ) ) )   >
                <#else>
                <p:column>
                    <f:facet name="header">${childProperty.name?substring(pL)}</f:facet>
                    <h:outputText value="${'#'}{${childName}.${childProperty.name}}"/>
                </p:column>
                </#if>
               </#if>
              </#if>
             </#if>
             </#foreach>
            </p:dataTable>
        </#if>
        </div>
        <f:subview rendered="${'#'}{${homeName}.managed}" id="${property.name}">
        <#if (childName?? && childName?length > pL)>
        <div class="actionButtons">
            <#if childName?substring(0,maE)?upper_case?contains("O")>
            <#else>
            <h:button id="add${childName}" 
                   value="Add ${childName?substring(pL)}"
                  <#if childName?upper_case?substring(0,4)?contains ("T") && componentName?upper_case?substring(0,4)?contains ("T") && childName?substring(efS,efE) !="9a" >
                    outcome="/${childEditPageName}.quoteorderexists.xhtml"
                  <#else>
                    outcome="/${childEditPageName}.xhtml"
                  </#if> 
                    propagation="none">
                 <f:param disable="${'#'}{empty ${homeName}.instance.${pojo.identifierProperty.name}}"  name="${componentName}${util.upper(pojo.identifierProperty.name)}" 
                         value="${'#'}{${homeName}.instance.${pojo.identifierProperty.name}}"/>
                  <#if childName?upper_case?substring(0,4)?contains ("T") && childName?substring(efS,efE) !="9a">
                   <f:param name="${childName}From" value="${entityName?substring(eL)}Edit.quoteorderexists"/>
                  <#else>
                   <f:param name="${childName}From" value="${entityName?substring(eL)}Edit" />
                  </#if>
            </h:button>
            </#if>
        </div>
        </#if>
        </f:subview>
    </p:tab>
 </#if>
 <#if hasAssociations>
  <#if tabSeq = 6 >
    <#assign tabSeq=0>
    </p:tabView>
  </#if>
 </#if>
</#if>
</#foreach>
<#if hasAssociations  >
 <#if tabSeq != 0>
 </p:tabView>
 </#if>
</div>
</p:panel>
</#if>
</p:panel>
</h:form>

</ui:define>

</ui:composition>
</#if>
</#if>


