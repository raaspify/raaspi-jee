<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#include "../view/assigns/mergedassigns.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes2 = pojo.shortName?substring(0,eL)?upper_case>
<#if (menuAttributes2?substring(efS,efE) == '20' || menuAttributes2?substring(efS,efE) == '30'  || menuAttributes2?substring(efS,efE) == '40' || menuAttributes2?substring(efS,efE) == '1A' || menuAttributes2?substring(efS,efE) == '1F'  || menuAttributes2?substring(efS,efE) == '25')  >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<?xml version="1.0" encoding="UTF-8"  ?>
<!-- Created with genJasperlabelsreports - A generator for JasperReports Labels -->
<!DOCTYPE jasperReport PUBLIC "//JasperReports//DTD Report Design//EN" "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd">
 <#include "../view/assigns/mergedassigns.properties" >
 <#assign counter =0>
 <#assign cc =0>
 <#assign cnc =0>
 <#assign cf =0>
 <#assign wv =50>
 <#assign xv =-wv>
 <#assign yv =0>
 <#assign hv =0>
 <#assign entityFunction="">
 <#assign INVOICEETC_ID_param_v = "xxxxxxxxxxxxnot defined initial">
 <#assign TargetId_param_v="xxxxxxxxxxxxnot defined initial">
 <#-- the above 2 paramaters value will be integer jay look into passing as string but use string to integer value if Autogen key otherwise String  --> 
 <#assign entityName = pojo.shortName> 
 <#assign componentName = util.lower(entityName)>
 <#assign entityName = pojo.shortName>
 <#assign componentName = util.lower(entityName)>
 <#assign schema="${default_schema}">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">
<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd"
		 name="${pojo.shortName}Avery5960"
		 columnCount="3"
		 printOrder="Horizontal"
		 orientation="Portrait"
		 pageWidth="612"
		 pageHeight="792"
		 columnWidth="192"
		 columnSpacing="8"
		 leftMargin="13"
		 rightMargin="7"
		 topMargin="36"
		 bottomMargin="20"
		 whenNoDataType="NoPages"
		 isTitleNewPage="false"
		 isSummaryNewPage="false"
		 resourceBundle="messages"
           whenResourceMissingType="Key">
	<property name="ireport.scriptlethandling" value="2" />
	<property name="ireport.encoding" value="UTF-8" />
	<import value="java.util.*" />
	<import value="net.sf.jasperreports.engine.*" />
	<import value="net.sf.jasperreports.engine.data.*" />


	<parameter name="DisplayAs" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Report Output as HTML or as PDF]]></parameterDescription>
		<defaultValueExpression ><![CDATA["PDF"]]></defaultValueExpression>
	</parameter>
	<parameter name="Start" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Start Record Key value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA["      "]]></defaultValueExpression>
	</parameter>
	<parameter name="End" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA["      "]]></defaultValueExpression>
	</parameter>
	<parameter name="MarkedOnes" isForPrompting="true" class="java.lang.Boolean">
 		<parameterDescription><![CDATA[Select Marked Records Only]]></parameterDescription>
      </parameter>
	<parameter name="INVOICEETC_ID" isForPrompting="false" class="java.lang.Integer">
		<parameterDescription><![CDATA[Key Value To Connect Master To Detail]]></parameterDescription>
		<defaultValueExpression ><![CDATA[0]]></defaultValueExpression>
	</parameter>
	<parameter name="ForTargetId" isForPrompting="false" class="java.lang.Integer">
		<parameterDescription><![CDATA[Key Value To Connect Master To Customer,Vendor etc]]></parameterDescription>
		<defaultValueExpression ><![CDATA[9999]]></defaultValueExpression>
	</parameter>
	<parameter name="owner2Code" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
	</parameter>
	<parameter name="reference" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Reference used in the report as notes or Pono etc]]></parameterDescription>
		<defaultValueExpression ><![CDATA[""]]></defaultValueExpression>
	</parameter>


<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
      <#break>
    </#foreach>
<#else>
     <#assign ids = pojo.identifierProperty.name>
</#if>
<#-- gen strategy ${pojo.identifierProperty.value.identifierGeneratorStrategy} -->
<#--
 page width is in pixels, JasperReports uses 72 dpi so 72 will mean 1inch.
 If the report has many columns, then not all columns are shown.
 For a wide report, it is better to output as xsl since a xsl viewer knows how to print a wide spreadsheet.
 May have problem trying to print a wide html or PDF
 layout is Title or JobTitle first name,last name
           addr line1
           line 2
           city prov cntry
           pzcode
-->
<#if (ids?substring(5,6)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
  <#-- use natural key for master report because it is user facing ie user can select it
       but use autogen key for subreports because less logic and selected internally by system  -->
<#else>
  <#assign keyAutoGen="N">
</#if>
 <#assign INVOICEETC_ID_param_v = ids?upper_case>

<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign counter =counter+1>
   </#foreach>
  <#else>
   <#assign counter =counter+1>
  </#if>
 </#if>
 <#if c2h.isManyToOne(property) >
  <#assign counter =counter+1>
 </#if>
</#foreach>

<#-- final ids used for master report itself is  based on keyautogen value ${keyAutoGen}   ${ids}  -->            

     	<queryString><![CDATA[SELECT
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign cc =cc+1>
    <#if (cc+cnc+cf < counter)>
      ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
    <#else>
      ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(pL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
    </#if>
    <#if keyAutoGen=="Y" && (componentProperty.name?substring(5,6)=="k" || componentProperty.name?substring(5,6)=="n")>
      <#assign ids = componentProperty.name>
    </#if>
   </#foreach>
  <#else>
   <#assign cnc =cnc+1>
   <#if (cc+cnc+cf < counter)>
      ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?lower_case},
   <#else>
    <#if menuAttributes2?substring(efS,efE) == '1A' || menuAttributes2?substring(efS,efE) == '1F'>
      ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}
    <#else>
      ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case},
    </#if>  
   </#if>
   <#if keyAutoGen=="Y" && (property.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" ) >
      <#assign ids = property.name>
   </#if>
  </#if>
 </#if>
 <#if c2h.isManyToOne(property) >
     <#assign lastColumn= property.columnIterator.next().name>
   <#assign cf =cf+1>
   <#if (cc+cnc+cf < counter)>
      ${pojo.shortName?substring(eL)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${lastColumn?upper_case},
   <#else>
    <#if menuAttributes2?substring(efS,efE) == '1A' || menuAttributes2?substring(efS,efE) == '1F'>
      ${pojo.shortName?substring(eL)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${lastColumn?upper_case}
    <#else>
      ${pojo.shortName?substring(eL)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${lastColumn?upper_case},
    </#if>
   </#if>
 </#if>
</#foreach>
    <#if menuAttributes2?substring(efS,efE) == '1A' || menuAttributes2?substring(efS,efE) == '1F'>
    <#elseif menuAttributes2?substring(efS,efE) == '25'>
      ${addressEntityName?substring(eL)}.addrl1 AS ${addressEntityName?substring(eL)}_addrl1,
      ${addressEntityName?substring(eL)}.addrl2 AS ${addressEntityName?substring(eL)}_addrl2,
      ${addressEntityName?substring(eL)}.city AS ${addressEntityName?substring(eL)}_city,
      ${addressEntityName?substring(eL)}.provnstate AS ${addressEntityName?substring(eL)}_provnstate,
      ${addressEntityName?substring(eL)}.country AS ${addressEntityName?substring(eL)}_country,
      ${addressEntityName?substring(eL)}.pzcode AS ${addressEntityName?substring(eL)}_pzcode

    <#else>
      ${addressEntityName?substring(eL)}.addrl1 AS ${addressEntityName?substring(eL)}_addrl1,
      ${addressEntityName?substring(eL)}.addrl2 AS ${addressEntityName?substring(eL)}_addrl2,
      ${addressEntityName?substring(eL)}.city AS ${addressEntityName?substring(eL)}_city,
      ${addressEntityName?substring(eL)}.provnstate AS ${addressEntityName?substring(eL)}_provnstate,
      ${addressEntityName?substring(eL)}.country AS ${addressEntityName?substring(eL)}_country,
      ${addressEntityName?substring(eL)}.pzcode AS ${addressEntityName?substring(eL)}_pzcode
     </#if>
FROM
 <#if menuAttributes2?substring(efS,efE) == '1A'>
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case} WHERE 
      <#if menuAttributes2?substring(efS,efE) == '1A'>
         (${pojo.shortName?substring(eL)?lower_case}.aliascode <> '') AND
      </#if>
         (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) <= $P{End} AND
       ${pojo.shortName?substring(eL)?lower_case}.owner2 = $P{owner2Code}  ]]></queryString>
 <#elseif menuAttributes2?substring(efS,efE) == '1F'>
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case}  WHERE 
         (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) <= $P{End} AND
       ${pojo.shortName?substring(eL)?lower_case}.owner2 = $P{owner2Code}  ]]></queryString>
 <#elseif menuAttributes2?substring(efS,efE) == '25'>
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case} left join ${schema}.${addressEntityName?substring(eL)} address on 
        ${pojo.shortName?substring(eL)}.mailtocode=address.sid left join ${schema}.${addressEntityName?substring(eL)} address on 
        ${pojo.shortName?substring(eL)}.mailtocode=address.sid WHERE 
         (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) <= $P{End} AND
       ${pojo.shortName?substring(eL)?lower_case}.owner2 = $P{owner2Code}]]></queryString>
 <#else>
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case} left join ${schema}.${addressEntityName?substring(eL)} address on 
        ${pojo.shortName?substring(eL)}.mailtocode=address.sid WHERE 
         (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) <= $P{End} AND
       ${pojo.shortName?substring(eL)?lower_case}.owner2 = $P{owner2Code}]]></queryString>
 </#if>
<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if propertyType == "timestamp">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.sql.Timestamp"/>
    <#elseif propertyType == "big_decimal">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.math.BigDecimal"/>
    <#elseif propertyType == "big_integer" || propertyType ==  "java.lang.Integer">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.lang.Integer"/>
    <#elseif propertyType == "boolean">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.lang.Boolean"/>
    <#else>
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.lang.String"/>
    </#if>
   </#foreach>
  <#else>
   <#if menuAttributes2?substring(efS,efE) == '1A'>
    <#assign barCodeField=pojo.shortName?substring(eL)?upper_case+"_"+"BARUPC">
    <#assign matCodeField=pojo.shortName?substring(eL)?upper_case+"_"+"MATCODE">
    <#assign matCodeAliasField=pojo.shortName?substring(eL)?upper_case+"_"+"ALIASCODE">
    <#assign sidField=pojo.shortName?substring(eL)?upper_case+"_"+"SID">

   <#elseif menuAttributes2?substring(efS,efE) == '1F'>
    <#assign barCodeField=pojo.shortName?substring(eL)?upper_case+"_"+"SERIALNO">
    <#assign matCodeField=pojo.shortName?substring(eL)?upper_case+"_"+"MATCODE">
   <#elseif menuAttributes2?substring(efS,efE) == '25'>
   <#else>
   <#if property.name?upper_case?substring(5,7)=='ZS'>
    <#assign descriptionField=pojo.shortName?substring(eL)?upper_case+"_"+property.name?substring(pL)?upper_case>
   <#elseif property.name?upper_case?contains("TITLE")>
    <#assign titleField=pojo.shortName?substring(eL)?upper_case+"_"+property.name?substring(pL)?upper_case>
   <#elseif property.name?upper_case?contains("JOBTITLE")>
    <#assign jobTitleField=pojo.shortName?substring(eL)?upper_case+"_"+property.name?substring(pL)?upper_case>
   <#elseif property.name?upper_case?contains("FIRSTNAME")>
    <#assign firstNameField=pojo.shortName?substring(eL)?upper_case+"_"+property.name?substring(pL)?upper_case>
   <#elseif property.name?upper_case?contains("LASTNAME")>
    <#assign lastNameField=pojo.shortName?substring(eL)?upper_case+"_"+property.name?substring(pL)?upper_case>
   </#if>
   </#if>
   <#assign propertyType = property.value.typeName>
   <#if propertyType == "timestamp">
      <field name="${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?upper_case}" class="java.sql.Timestamp"/>
   <#elseif propertyType == "big_decimal">
      <field name="${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?upper_case}" class="java.math.BigDecimal"/>
   <#elseif propertyType == "big_integer" || propertyType ==  "java.lang.Integer">
      <field name="${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?upper_case}" class="java.lang.Integer"/>
   <#elseif propertyType == "boolean">
      <field name="${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?upper_case}" class="java.lang.Boolean"/>
   <#else>
      <field name="${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?upper_case}" class="java.lang.String"/>
   </#if>
  </#if>
 </#if>

 <#if c2h.isManyToOne(property) >
  <#assign lastColumn= property.columnIterator.next().name>
    <#if keyAutoGen=="Y">
      <field name="${pojo.shortName?substring(eL)?upper_case}_${lastColumn?upper_case}" class="java.lang.Integer"/>
    <#else>
      <field name="${pojo.shortName?substring(eL)?upper_case}_${lastColumn?upper_case}" class="java.lang.String"/>
    </#if>
    <#if found = 'N'>
     <#assign columnName ="NOt Assigned yet   xxxxxx  ">
     <#assign lastOfKeys= property.columnIterator.next().name>
     <#assign columnNameKey= componentName+lastOfKeys?lower_case?cap_first+"One">


     <#if columnNameKey == "${vshipmenEntityName}MatcodeOne">
       <#assign columnName ="d1xxuxxrbvxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${vshipmenEntityName}VendorOne">
       <#assign columnName ="d2xxudvvbvxxxxxxxxxxvendor">
     <#elseif columnNameKey == "${vshipmenEntityName}ShipcodeOne">
       <#assign columnName ="d5xxuhbrbvxxxxxxxxxxshiptocode">
     <#elseif columnNameKey == "${vshipmenEntityName}MailtocodeOne">
       <#assign columnName ="d4xxugbrbvxxxxxxxxxxmailtocode">
     </#if> 

     <#if columnNameKey == "${venquoteEntityName}MatcodeOne">
       <#assign columnName ="b3xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${venquoteEntityName}VendorOne">
       <#assign columnName ="b2xxudvvlxxxxxxxxxxxvendor">
     <#elseif columnNameKey == "${venquoteEntityName}DepcodeOne">
       <#assign columnName ="yaxxuxeybvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${venquoteEntityName}DivcodeOne">
       <#assign columnName ="y9xxuxoxbvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${venquoteEntityName}XshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "trexuq33vinvoiceAgentOne">
       <#assign columnName ="c1xxudttblxxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${cuquoteEntityName}MatcodeOne">
       <#assign columnName ="b4xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${cuquoteEntityName}CustomerOne">
       <#assign columnName ="b3xxudrravnxxxxxxxxxcustomer">
     <#elseif columnNameKey == "${cuquoteEntityName}ContactcOne">
       <#assign columnName ="y2xxugrcavxxxxxxxxxxcontactc">
     <#elseif columnNameKey == "${cuquoteEntityName}DepcodeOne">
       <#assign columnName ="ydxxuxeybvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${cuquoteEntityName}DivcodeOne">
       <#assign columnName ="ycxxuxoybvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${cuquoteEntityName}XshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "${cuquoteEntityName}AgentOne">
       <#assign columnName ="c1xxugttavxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${cuinvoiceEntityName}MatcodeOne">
       <#assign columnName ="b2xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${cuinvoiceEntityName}CustomerOne">
       <#assign columnName ="b1xxudrravnxxxxxxxxxcustomer">
     <#elseif columnNameKey == "${cuinvoiceEntityName}ContactcOne">
       <#assign columnName ="y1xxudrcavxxxxxxxxxxcontactc">
     <#elseif columnNameKey == "${cuinvoiceEntityName}DepcodeOne">
       <#assign columnName ="y9xxuxexbvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${cuinvoiceEntityName}DivcodeOne">
       <#assign columnName ="y8xxuxoxbvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${cuinvoiceEntityName}XshipcodeOne">
       <#assign columnName ="y5xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "${cuinvoiceEntityName}AgentOne">
       <#assign columnName ="d1xxugttavxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${cpaymentEntityName}MatcodeOne">
       <#assign columnName ="b4xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${cpaymentEntityName}CustomerOne">
       <#assign columnName ="b1xxudrravnxxxxxxxxxcustomer">
     <#elseif columnNameKey == "${cpaymentEntityName}ContactcOne">
       <#assign columnName ="y2xxugrcavxxxxxxxxxxcontactc">
     <#elseif columnNameKey == "${cpaymentEntityName}DepcodeOne">
       <#assign columnName ="ydxxuxeybvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${cpaymentEntityName}DivcodeOne">
       <#assign columnName ="ycxxuxoybvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${cpaymentEntityName}XshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "${cpaymentEntityName}AgentOne">
       <#assign columnName ="c1xxugttavxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${cuordersEntityName}MatcodeOne">
       <#assign columnName ="b4xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${cuordersEntityName}CustomerOne">
       <#assign columnName ="b1xxudrravnxxxxxxxxxcustomer">
     <#elseif columnNameKey == "${cuordersEntityName}ContactcOne">
       <#assign columnName ="y2xxugrcavxxxxxxxxxxcontactc">
     <#elseif columnNameKey == "${cuordersEntityName}DepcodeOne">
       <#assign columnName ="ydxxuxeybvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${cuordersEntityName}DivcodeOne">
       <#assign columnName ="ycxxuxoybvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${cuordersEntityName}XshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "${cuordersEntityName}AgentOne">
       <#assign columnName ="c1xxugttavxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${shipmentEntityName}MatcodeOne">
       <#assign columnName ="b1xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${shipmentEntityName}CustomerOne">
       <#assign columnName ="d1xxudrrbvxxxxxxxxxxcustomer">
     <#elseif columnNameKey == "${shipmentEntityName}ShipcodeOne">
       <#assign columnName ="d3xxuhbrbvxxxxxxxxxxshiptocode">
     <#elseif columnNameKey == "${shipmentEntityName}MailtocodeOne">
       <#assign columnName ="d4xxugbrbvxxxxxxxxxxmailtocode">
     </#if> 


     <#if (jobassignmentEntityName?? && jobassignmentEntityName?length >eL )>
     <#if columnNameKey == "${jobassignmentEntityName}MatcodeOne">
       <#assign columnName ="b5xxuxxrbvxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${jobassignmentEntityName}CustomerOne">
       <#assign columnName ="baxxuxxrbvxxxxxxxxxxcustomer">
     <#elseif columnNameKey == "${jobassignmentEntityName}VendorOne">
       <#assign columnName ="b8xxudvvbvxxxxxxxxxxvendor">
     <#elseif columnNameKey == "${jobassignmentEntityName}PrevjobOne">
       <#assign columnName ="z1xxuxxrbvxxxxxxxxxxprevjob">
     <#elseif columnNameKey == "${jobassignmentEntityName}NextjobOne">
       <#assign columnName ="z2xxuxxrbvxxxxxxxxxxnextjob">
     <#elseif columnNameKey == "${jobassignmentEntityName}Jobno">
       <#assign columnName ="b4xxuxxrbvxxxxxxxxxxjobno">
     <#elseif columnNameKey == "${jobassignmentEntityName}Machine">
       <#assign columnName ="a0xxukxxbvxxxxxxxxxxmachine">
     </#if> 
     </#if>
     <#if columnNameKey == "${vendordersEntityName}MatcodeOne">
       <#assign columnName ="b3xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${vendordersEntityName}VendorOne">
       <#assign columnName ="b2xxudvvlxxxxxxxxxxxvendor">
     <#elseif columnNameKey == "${vendordersEntityName}ContactcOne">
       <#assign columnName ="y2xxugrcavxxxxxxxxxxcontactc">
     <#elseif columnNameKey == "${vendordersEntityName}DepcodeOne">
       <#assign columnName ="ydxxuxeybvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${vendordersEntityName}DivcodeOne">
       <#assign columnName ="ycxxuxoybvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${vendordersEntityName}XshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "${vendordersEntityName}AgentOne">
       <#assign columnName ="c1xxugttavxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${vinvoiceEntityName}MatcodeOne">
       <#assign columnName ="b2xxudiravxxxxxxxxxxmatcodematcode">
     <#elseif columnNameKey == "${vinvoiceEntityName}VendorOne">
       <#assign columnName ="b1xxudvvlxxxxxxxxxxxvendor">
     <#elseif columnNameKey == "${vinvoiceEntityName}DepcodeOne">
       <#assign columnName ="ybxxuxeybvxxxxxxxxxxdepcode">
     <#elseif columnNameKey == "${vinvoiceEntityName}DivcodeOne">
       <#assign columnName ="yaxxuxoybvxxxxxxxxxxdivcode">
     <#elseif columnNameKey == "${vinvoiceEntityName}XshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxxxxxxxxxshipcode">
     <#elseif columnNameKey == "${vinvoiceEntityName}AgentOne">
       <#assign columnName ="d1xxudttavxxxxxxxxxxagent">
     </#if> 

     <#if columnNameKey == "${vpaymentEntityName}MatcodeOne">
       <#assign columnName ="b2xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${vpaymentEntityName}VendorOne">
       <#assign columnName ="b1xxudvvbvxxxxxxxxxxvendor">
     </#if> 

     <#if columnNameKey == "${emplordersEntityName}MatcodeOne">
       <#assign columnName ="b3xxudiravxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${emplordersEntityName}EmployeeOne">
       <#assign columnName ="b2xxudttlxxxxxxxxxxxemployee">
     </#if> 
     
    </#if>
 </#if>
</#foreach>
    <#if menuAttributes2?substring(efS,efE) == '1A' || menuAttributes2?substring(efS,efE) == '1F'>
    <#elseif menuAttributes2?substring(efS,efE) == '25'>
    <#else>
	<field name="${addressEntityName?substring(eL)}_addrl1" class="java.lang.String"/>
	<field name="${addressEntityName?substring(eL)}_addrl2" class="java.lang.String"/>
	<field name="${addressEntityName?substring(eL)}_city" class="java.lang.String"/>
	<field name="${addressEntityName?substring(eL)}_provnstate" class="java.lang.String"/>
	<field name="${addressEntityName?substring(eL)}_country" class="java.lang.String"/>
	<field name="${addressEntityName?substring(eL)}_pzcode" class="java.lang.String"/>
    </#if>
		<background>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</background>
		<title>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</title>
		<pageHeader>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</pageHeader>
		<columnHeader>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</columnHeader>
		<detail>
			<band height="72"  isSplitAllowed="true" >
				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="9"
						y="2"
						width="138"
						height="13"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font size="8"/>
					</textElement>
                               <#if menuAttributes2?substring(efS,efE) == '1A'>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${barCodeField}}]]></textFieldExpression>
                               <#elseif menuAttributes2?substring(efS,efE) == '1F'>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${barCodeField}}]]></textFieldExpression>
                               <#elseif menuAttributes2?substring(efS,efE) == '25'>

                               <#else>
				<textFieldExpression   class="java.lang.String"><![CDATA[($F{${firstNameField}}==null?" ":$F{${firstNameField}})+"," + ($F{${lastNameField}}==null?"":$F{${lastNameField}}) + " "]]></textFieldExpression>
                               </#if>
				</textField>
                               <#if menuAttributes2?substring(efS,efE) == '1F'>
		   	        <componentElement>
				 <reportElement x="4" y="22" width="187" height="35"/>
				 <jr:barbecue xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" type="3of9" drawText="false" checksumRequired="false">
					<jr:codeExpression><![CDATA[$F{SERIALNUMBERS_SERIALNO}]]></jr:codeExpression>
				 </jr:barbecue>
			        </componentElement>
                               <#elseif menuAttributes2?substring(efS,efE) == '1A'>
		   	        <componentElement>
				  <reportElement x="4" y="22" width="187" height="35"/>
				  <jr:barbecue xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" type="3of9" drawText="false" checksumRequired="false">
                                  <#if variation ==" ">
					<jr:codeExpression><![CDATA[$F{${sidField}}]]></jr:codeExpression>
                                  <#else>
					<jr:codeExpression><![CDATA[$F{${matCodeAliasField}}.toUpperCase()]]></jr:codeExpression>
                                  </#if>
				  </jr:barbecue>
			        </componentElement>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="9"
						y="15"
						width="182"
						height="26"
						key="textField-1"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif" size="8" isBold="false"/>
					</textElement>

                               <#else>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="9"
						y="15"
						width="182"
						height="26"
						key="textField-1"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="8" isBold="false"/>
					</textElement>
                               </#if>
                               <#if menuAttributes2?substring(efS,efE) == '1A'>
                                  <#if variation ==" ">
				   <textFieldExpression   class="java.lang.String"><![CDATA[$F{${sidField}}]]></textFieldExpression>
                                  <#else>
  				   <textFieldExpression   class="java.lang.String"><![CDATA[$F{${matCodeAliasField}}]]></textFieldExpression>
                                  </#if>

                               <#elseif menuAttributes2?substring(efS,efE) == '25'>
                               <#elseif menuAttributes2?substring(efS,efE) == '1F'>
                               <#else>
				<textFieldExpression   class="java.lang.String"><![CDATA[($F{${addressEntityName?substring(eL)}_addrl1}==null?" ":$F{${addressEntityName?substring(eL)}_addrl1}) + "\n" +
($F{${addressEntityName?substring(eL)}_addrl2}==null?" ":$F{${addressEntityName?substring(eL)}_addrl2})]]></textFieldExpression>
                               </#if>
                               <#if menuAttributes2?substring(efS,efE) != '1F' >
				</textField>
                               </#if>
                               <#if (menuAttributes2?substring(efS,efE) == '1A' || menuAttributes2?substring(efS,efE) == '1F')>
                               <#elseif menuAttributes2?substring(efS,efE) == '25'>

                               <#else>
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="9"
						y="47"
						width="66"
						height="11"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font size="8"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[($F{${addressEntityName?substring(eL)}_city}.equals(null)?" ":$F{${addressEntityName?substring(eL)}_city})+" "+($F{${addressEntityName?substring(eL)}_provnstate}.equals(null)?" ":$F{${addressEntityName?substring(eL)}_provnstate})+" "+($F{${addressEntityName?substring(eL)}_country}.equals(null)?" ":$F{${addressEntityName?substring(eL)}_country})]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="90"
						y="57"
						width="77"
						height="12"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font size="8"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${addressEntityName?substring(eL)}_pzcode}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="10"
						y="53"
						width="100"
						height="16"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font size="8"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{reference}]]></textFieldExpression>
				</textField>
                               </#if> 

			</band>

		</detail>
		<columnFooter>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</columnFooter>
		<pageFooter>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</pageFooter>
		<summary>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</summary>
</jasperReport>
</#if>
</#if>








