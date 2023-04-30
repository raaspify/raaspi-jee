<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,erS)?upper_case>
<#assign menuAttributesFunction = pojo.shortName?substring(efS,efE)>
<#if (menuAttributes?contains("T")  && menuAttributes?contains("E") ) >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<?xml version="1.0" encoding="UTF-8"  ?>
<!-- Created with genJaspermasterreports - A generator for JasperReports -->
<#--
   report name barcode
   PO/Invoice # ??
   Company name    design subreport-2 subreport1.jrxml
   Customer/Vendor        subreport-3 subreport2.jrxml
   Details                subreport-1 subreport0.jrxml

-->
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
 <#assign subReport0PojoName="Not Assigned Yet">
 <#assign subReport1PojoName=clientEntityName>
 <#assign subReport2PojoName=customerEntityName>
 <#assign entityName = pojo.shortName> 
 <#assign componentName = util.lower(entityName)>
 <#assign entityName = pojo.shortName>
 <#assign componentName = util.lower(entityName)>
 <#assign schema="${default_schema}">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">
 <#assign owner2Field = "owner2" >
 <#assign totalField = "Not Assigned Yet" >
 <#assign txndateField = "Not Assigned Yet" >

<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd"
		 name="${pojo.shortName}"
		 columnCount="1"
		 printOrder="Vertical"
		 orientation="Portrait"
		 pageWidth="595"
		 pageHeight="842"
		 columnWidth="535"
		 columnSpacing="0"
		 leftMargin="30"
		 rightMargin="30"
		 topMargin="20"
		 bottomMargin="20"
		 whenNoDataType="NoPages"
		 isTitleNewPage="false"
		 isSummaryNewPage="false"
		 resourceBundle="messages"
           whenResourceMissingType="Key">
	<property name="ireport.scriptlethandling" value="0" />
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
	<parameter name="Status" isForPrompting="true" class="java.lang.Integer">
		<parameterDescription><![CDATA[Status flag value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA[0]]></defaultValueExpression>
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
	<parameter name="reqUrl" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Url like https://www.xxx.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["https://www.raaspi.com"]]></defaultValueExpression>
	</parameter>
	<parameter name="subreportPath" isForPrompting="false" class="java.lang.String">
		<parameterDescription><![CDATA[SubReport class absolute path]]></parameterDescription>
		<defaultValueExpression ><![CDATA["."]]></defaultValueExpression>
	</parameter>


<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
    <#if (property.name?length >pL )>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
      <#break>
    </#if>
    </#foreach>
<#else>
     <#assign ids = pojo.identifierProperty.name>
</#if>

<#-- gen strategy ${pojo.identifierProperty.value.identifierGeneratorStrategy} ids ${ids} -->
<#if (ids?substring(5,6)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
  <#-- use natural key for master report because it is user facing ie user can select it
       but use autogen key for subreports because less logic and selected internally by system  -->
<#else>
  <#assign keyAutoGen="N">
</#if>
 <#assign INVOICEETC_ID_param_v = ids?upper_case>

<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
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
</#if>
</#foreach>


     	<queryString><![CDATA[SELECT
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign cc =cc+1>
    <#if (cc+cnc+cf < counter) || menuAttributesFunction =="24">
      ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
    <#else>
      ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(pL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}
    </#if>
    <#if keyAutoGen=="Y" && (componentProperty.name?substring(5,6)=="k" || componentProperty.name?substring(5,6)=="n")>
      <#assign ids = componentProperty.name>
    </#if>
   </#foreach>
  <#else>
   <#assign cnc =cnc+1>
   <#if (cc+cnc+cf < counter) || menuAttributesFunction =="24">
      ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?upper_case}_${property.name?substring(pL)?lower_case},
   <#else>
      ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}
   </#if>
   <#if keyAutoGen=="Y" && (property.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" ) >
      <#assign ids = property.name>
   </#if>
   <#if keyAutoGen=="Y" && (property.name?substring(5,7)=="tp" ) >
      <#assign totalField = property.name?substring(pL) >
   </#if>
  </#if>
 </#if>

 <#if c2h.isManyToOne(property) >
     <#assign lastColumn= property.columnIterator.next().name>
   <#assign cf =cf+1>
   <#if (cc+cnc+cf < counter)>
      ${pojo.shortName?substring(eL)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${lastColumn?upper_case},
   <#else>
      ${pojo.shortName?substring(eL)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${lastColumn?upper_case}
   </#if>
 </#if>
</#if>
</#foreach>
<#if menuAttributesFunction =="24">
      address.addrl1 as address_addrl1s  ,address.city as 
      address_citys ,address.provnstate as 
      address_provnstates,address.pzcode as 
      address_pzcodes

</#if>

FROM
      <#if menuAttributesFunction =="24">
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case}
         left join genapp.address  on cuorders.shipcodefrompay=address.sid WHERE 
      <#else>
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case} WHERE 
      </#if>
         (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) <= $P{End} AND (${pojo.shortName?substring(eL)?lower_case}.statusfl = $P{Status} or $P{Status} is null) AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code}]]></queryString>
<#if ids?substring(6,8) == 'ci' >
 <#assign subReport0PojoName=cuidetailsEntityName>
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_invodate" >
<#elseif ids?substring(6,8) == 'co' >
 <#assign subReport0PojoName= cuodetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_odatet" >
<#elseif ids?substring(6,8) == 'cp' >
 <#assign subReport0PojoName= cupdetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_paymentduedate" >
<#elseif ids?substring(6,8) == 'cq' >
 <#assign subReport0PojoName= cuqdetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_quoordt" >
<#elseif ids?substring(6,8) == 'vi' >
 <#assign subReport0PojoName= vendidetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_invodate" >
<#elseif ids?substring(6,8) == 'vo' >
 <#assign subReport0PojoName= vendodetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_odatet" >
<#elseif ids?substring(6,8) == 'vp' >
 <#assign subReport0PojoName= vendpdetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_paymentduedate" >
<#elseif ids?substring(6,8) == 'vq' >
 <#assign subReport0PojoName= vendqdetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_odatet" >
<#elseif ids?substring(6,8) == 'sh' >
 <#assign subReport0PojoName= shipmentdetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_shipdatet" >
<#elseif ids?substring(6,8) == 'sv' >
 <#assign subReport0PojoName= vshipmendetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_shipdatet" >
<#elseif ids?substring(6,8) == 'eo' >
 <#assign subReport0PojoName= emplodetailsEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_odatet" >
<#elseif ids?substring(6,8) == 'pd' >
 <#assign subReport0PojoName= processattributesEntityName  >
 <#assign txndateField = "${pojo.shortName?substring(eL)?lower_case}_sdatet" >
</#if>


<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if propertyType == "timestamp">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.sql.Timestamp"/>
    <#elseif propertyType == "big_decimal">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.math.BigDecimal"/>
    <#elseif propertyType == "big_integer" || propertyType ==  "java.lang.Integer">       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.lang.Integer"/>
    <#elseif propertyType == "boolean">
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.lang.Boolean"/>
    <#else>
       <field name="${pojo.shortName?substring(eL)?upper_case}_${componentProperty.name?substring(pL)?upper_case}" class="java.lang.String"/>
    </#if>
   </#foreach>
  <#else>
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

     <#if (processdetailsEntityName?? && processdetailsEntityName?length >eL )>
     <#if columnNameKey == "${processdetailsEntityName}MatcodeOne">
       <#assign columnName ="b1xxuxxrbvxxxxxxxxxxmatcode">
     <#elseif columnNameKey == "${processdetailsEntityName}CustomerOne">
       <#assign columnName ="b2xxusrrbvxxxxxxxxxxcustomer">
     </#if> 
     </#if>

     
     <#if (ids?substring(6,7) == 'c' || ids?substring(6,8) == 'sh' || ids?substring(6,8) == 'pd' )   && columnName?substring(6,8)?upper_case=='RR'>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName= customerEntityName>
      <#assign found = 'Y'>
     <#elseif (ids?substring(6,7) == 'v' || ids?substring(6,8) == 'sv' ) && columnName?substring(6,8)?upper_case=='VV'>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName= vendorEntityName>
      <#assign found = 'Y'>
     <#elseif ids?substring(6,7) == 'e' && columnName?substring(6,8)?upper_case=='TT'>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName= employeeEntityName>
      <#assign found = 'Y'>
     <#else> 
      <#assign TargetId_param_v = 'xxxxxxxxxxxxnot defined'>
     </#if>
    </#if>
 </#if>
</#if>
</#foreach>
<#if menuAttributesFunction =="24">
	<field name="address_addrl1s" class="java.lang.String"/>
	<field name="address_citys" class="java.lang.String"/>
	<field name="address_provnstates" class="java.lang.String"/>
	<field name="address_pzcodes" class="java.lang.String"/>

</#if>		<background>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</background>
		<title>
			<band height="21"  isSplitAllowed="true" >
			</band>
		</title>
		<pageHeader>
		<band height="183" splitType="Stretch">
			<textField isBlankWhenNull="true">
				<reportElement x="1" y="160" width="109" height="20"/>
				<textElement/>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{reference}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="true">
				<reportElement x="132" y="160" width="400" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[($F{${pojo.shortName?substring(eL)?upper_case}_NOTES}.length() > 7 && $F{${pojo.shortName?substring(eL)?upper_case}_NOTES}.contains("<p>"))?$F{${pojo.shortName?substring(eL)?upper_case}_NOTES}.substring(3,$F{${pojo.shortName?substring(eL)?upper_case}_NOTES}.length()-4):$F{${pojo.shortName?substring(eL)?upper_case}_NOTES}]]></textFieldExpression>
			</textField>


			<textField pattern="yyyyMMMdd">
				<reportElement x="3" y="119" width="97" height="30"/>
				<textElement>
					<font size="16"/>
				</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${txndateField?upper_case}}]]></textFieldExpression>
			</textField>

				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="140"
						y="119"
						width="90"
						height="22"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{${pojo.shortName?substring(eL)?cap_first}}]]></textFieldExpression>
				</textField>
			<textField isBlankWhenNull="true">
				<reportElement x="230" y="119" width="100" height="23"/>
				<textElement>
					<font size="16"/>
				</textElement>
				<textFieldExpression><![CDATA[$F{${pojo.shortName?substring(eL)?upper_case}_${ids?substring(pL)?upper_case}}]]></textFieldExpression>
			</textField>

			<componentElement>
				<reportElement x="370" y="120" width="156" height="29"/>
                              <#-- codes are Code128,Codabar, Code39   9c processDetails \\D non digits-->
                              <#if menuAttributesFunction =="9c">
				<jr:barbecue xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" type="Code128" drawText="true" checksumRequired="false">
					<jr:codeExpression><![CDATA[$F{${pojo.shortName?substring(eL)?upper_case}_${ids?substring(pL)?upper_case}}.trim();]]></jr:codeExpression>
				</jr:barbecue>
                              <#else>
				<jr:barbecue xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" type="Codabar" drawText="false" checksumRequired="false">
					<jr:codeExpression><![CDATA[$F{${pojo.shortName?substring(eL)?upper_case}_${ids?substring(pL)?upper_case}}.trim().replaceAll("\\D+","");]]></jr:codeExpression>
				</jr:barbecue>
                              </#if>
			</componentElement>

			<line direction="BottomUp">
				<reportElement key="line" mode="Opaque" x="0" y="8" width="562" height="1" forecolor="#000000" backcolor="#FFFFFF" uuid="aad95a22-1351-41c7-810d-e0f4924c4518"/>
			</line>
                        <#if menuAttributesFunction =="24">
 			 <textField isBlankWhenNull="true">
				<reportElement x="0" y="19" width="50" height="20" uuid="9c8e7936-d4c1-486c-9a28-be79f058483a"/>
				<textFieldExpression><![CDATA[$F{address_addrl1s}==null?"":"Ship To: "]]></textFieldExpression>
			 </textField>
			 <textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true">
				<reportElement key="textField" x="40" y="19" width="492" height="30" uuid="1e0aff1e-fdc8-4866-a395-6b2c5ac74e99"/>
				<box leftPadding="2" rightPadding="2">
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="DejaVu Serif" size="16" />
				</textElement>
				<textFieldExpression><![CDATA[($F{address_addrl1s}==null?"":$F{address_addrl1s})+' '+($F{address_citys}==null?"":$F{address_citys})+' '+($F{address_provnstates}==null?"":$F{address_provnstates})+' '+($F{address_pzcodes}==null?"":$F{address_pzcodes})]]></textFieldExpression>
			 </textField>
                        </#if>
				<subreport  isUsingCache="true">
					<reportElement
						x="0"
						y="-40"
						width="532"
						height="95"
						key="subreport-2"/>
				        <subreportParameter name="owner2Code">
					<subreportParameterExpression><![CDATA[$P{owner2Code}]]></subreportParameterExpression>
				        </subreportParameter>
				        <subreportParameter name="reqUrl">
					<subreportParameterExpression><![CDATA[$P{reqUrl}]]></subreportParameterExpression>
				        </subreportParameter>
				        <subreportParameter name="subreportPath">
					<subreportParameterExpression><![CDATA[$P{subreportPath}]]></subreportParameterExpression>
				        </subreportParameter>

					<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					<subreportExpression  class="java.lang.String"><![CDATA[$P{subreportPath}+"/${subReport1PojoName?cap_first}Master_SubReport1.jasper"]]></subreportExpression>
				</subreport>
			<line>
				<reportElement x="3" y="100" width="562" height="1" uuid="fcb687ee-85ed-4368-bfd2-757bb2e00403"/>
			</line>
			<textField isBlankWhenNull="true">
				<reportElement key="textField" x="325" y="63" width="210" height="37" uuid="d2c5a243-78f6-434b-ae8f-7e6afe1c0141"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font size="16"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{${pojo.shortName?substring(eL)?cap_first}}]]></textFieldExpression>
			</textField>


		</band>
		</pageHeader>
		<columnHeader>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</columnHeader>
		<detail>
			<band height="266"  isSplitAllowed="true" >
 <#assign xv =-wv>

				<subreport  isUsingCache="true">
					<reportElement
						x="12"
						y="157"
						width="514"
						height="107"
						key="subreport-1"/>
					<subreportParameter  name="INVOICEETC_ID">
						<subreportParameterExpression><![CDATA[$F{${pojo.shortName?substring(eL)?upper_case}_${INVOICEETC_ID_param_v?substring(pL)}}]]></subreportParameterExpression>
					</subreportParameter>
				        <subreportParameter name="owner2Code">
					 <subreportParameterExpression><![CDATA[$P{owner2Code}]]></subreportParameterExpression>
				        </subreportParameter>
				        <subreportParameter name="subreportPath">
					<subreportParameterExpression><![CDATA[$P{subreportPath}]]></subreportParameterExpression>
				        </subreportParameter>
					<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					<subreportExpression  class="java.lang.String"><![CDATA[$P{subreportPath}+"/${subReport0PojoName?cap_first}Master_SubReport0.jasper"]]></subreportExpression>
				</subreport>
				<subreport  isUsingCache="true">
					<reportElement
						x="0"
						y="71"
						width="466"
						height="31"
						key="subreport-3"/>
					<subreportParameter  name="ForTargetId">
						<subreportParameterExpression><![CDATA[$F{${pojo.shortName?substring(eL)?upper_case}_${TargetId_param_v?substring(pL)}}]]></subreportParameterExpression>
					</subreportParameter>
				        <subreportParameter name="owner2Code">
					<subreportParameterExpression><![CDATA[$P{owner2Code}]]></subreportParameterExpression>
				        </subreportParameter>
				        <subreportParameter name="subreportPath">
					<subreportParameterExpression><![CDATA[$P{subreportPath}]]></subreportParameterExpression>
				        </subreportParameter>

					<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					<subreportExpression  class="java.lang.String"><![CDATA[$P{subreportPath}+"/${subReport2PojoName?cap_first}Master_SubReport2.jasper"]]></subreportExpression>
				</subreport>

			</band>

		</detail>
               <#if menuAttributesFunction =="9c">
               <#else>
		<columnFooter>
		<band height="45" splitType="Stretch">
			<staticText>
				<reportElement x="225" y="0" width="100" height="20"/>
				<textElement textAlignment="Right">
					<font size="14" isBold="true"/>
				</textElement>
				<text><![CDATA[Totals]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="346" y="0" width="120" height="20"/>
				<textElement textAlignment="Right">
					<font size="14" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$F{${pojo.shortName?substring(eL)?upper_case}_${totalField?upper_case}}]]></textFieldExpression>
			</textField>
		</band>
		</columnFooter>
               </#if> 
		<pageFooter>
			<band height="27"  isSplitAllowed="true" >

				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="325"
						y="4"
						width="170"
						height="19"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="14"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA["Page " + $V{PAGE_NUMBER} + " of "]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="true" evaluationTime="Report" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="499"
						y="4"
						width="36"
						height="19"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="14"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA["" + $V{PAGE_NUMBER}]]></textFieldExpression>
				</textField>
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="0"
						y="3"
						width="535"
						height="0"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="1"
						y="6"
						width="209"
						height="19"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="14"/>
					</textElement>
				<textFieldExpression   class="java.util.Date"><![CDATA[new Date()]]></textFieldExpression>
				</textField>
			</band>
		</pageFooter>
		<summary>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</summary>
</jasperReport>
</#if>
</#if>








