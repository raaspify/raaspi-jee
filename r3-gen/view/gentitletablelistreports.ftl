<#assign tobegeneratedCandidate ="N" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#if (menuAttributes?substring(efS,efE) == '1R'  || menuAttributes?substring(efS,efE) == '52' || menuAttributes?substring(efS,efE) == '5A' || menuAttributes?substring(efS,efE) == '9B') >
 <#assign tobegeneratedCandidate ="N" >
<#else> 
  <#assign tobegeneratedCandidate="Y">
</#if>
<#if (tobegeneratedCandidate == "Y") >
<?xml version="1.0" encoding="UTF-8"?>
<#-- Created with gentitletablelistreports.ftl - A generator for JasperReports -->
 <#-- counterc,nc refers to total components & non components and should be set only once for an entity or pojo
   they are used to know which field is the last one so that comma is omitted after that field
 -->
<#--This uses table and avoids using subreports ie one report handles foregin entities
    customer report address column can put address data using the sid #
    ftl structure is as follows
    1. first paramters with suffix_t for tables to distinguish from main report parameters. Also use loop for showoon but no _t why??
    2. loop through properties and find foreign entity (manytoone) and create queries etc for each and these will be a cell
       in main report. parameter for these cell is sid and owner2 and query is for all the fields from foreign table
    3. then main report parameter, query etc are generated. mainreport receives parameter values from calling program
       and then xxx_t receives value from xxx  via <datasetParameter entries
       so $P{show001 becomes $P{datasetParameter using xxx_t ?


-->
 <#assign counterc =0>
 <#assign counternc =0>
 <#assign cc =0>
 <#assign cnc =0>
 <#assign crf =0>
 <#assign wv =50>
 <#assign xv =-wv>
 <#assign xs =2>
 <#assign yv =0>
 <#assign hv =0>
 <#assign addedFields ="">

 <#assign propertyns="">
 <#assign useDateKey="">
 <#assign statusFlagField="">
 <#assign firstTime="Y"> 
 <#assign schema="${default_schema}">
 <#assign keyField = "" >
 <#assign keyAutoGen="Y">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">
 <#assign owner2Field = "owner2" >

<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd"
 name="${pojo.shortName}"
 language="java"
 pageWidth="1200"
 pageHeight="592"
 orientation="Landscape"
 columnWidth="752"
 leftMargin="20"
 rightMargin="20"
 topMargin="20"
 bottomMargin="20"
 resourceBundle="messages"
 whenResourceMissingType="Key">
	<property name="ireport.zoom" value="1.0"/>
	<property name="ireport.x" value="0"/>
	<property name="ireport.y" value="10"/>
	<style name="Title" isDefault="false" fontName="DejaVu Serif" fontSize="18" isBold="true" >
		<conditionalStyle>
			<conditionExpression><![CDATA[$P{FontName}=="DejaVu Serif"]]></conditionExpression>
			<style fontName="DejaVu Serif" fontSize="24"/>
		</conditionalStyle>
	</style>
	<style name="SubTitle" isDefault="false" forecolor="#666666" fontName="DejaVu Serif" fontSize="18" />

	<style name="Column header" isDefault="false" forecolor="#666666" fontName="DejaVu Serif" fontSize="12" isBold="true" />

	<style name="table">
		<box>
			<pen lineWidth="0.0" lineColor="#000000"/>
		</box>
	</style>
	<style name="table_TH" mode="Opaque" backcolor="#F0F8FF">
		<box>
			<pen lineWidth="0.0" lineColor="#000000"/>
		</box>
	</style>
	<style name="table_CH" mode="Opaque" backcolor="#BFE1FF">
		<box>
			<pen lineWidth="0.0" lineColor="#000000"/>
		</box>
	</style>
	<style name="table_TD" mode="Opaque" backcolor="#FFFFFF">
		<box>
			<pen lineWidth="0.0" lineColor="#000000"/>
		</box>
		<conditionalStyle>
			<conditionExpression><![CDATA[new Boolean($V{REPORT_COUNT}.intValue()%2==0)]]></conditionExpression>
			<style backcolor="#EFF7FF"/>
		</conditionalStyle>
	</style>
	<subDataset name="tableDataSet" resourceBundle="messages" whenResourceMissingType="Key">
		<parameter name="DisplayAs_t" class="java.lang.String">
			<parameterDescription><![CDATA[Report Output as HTML or as PDF]]></parameterDescription>
			<defaultValueExpression><![CDATA["PDF"]]></defaultValueExpression>
		</parameter>
		<parameter name="MarkedOnes_t" class="java.lang.Boolean">
			<parameterDescription><![CDATA[Select Marked Records Only]]></parameterDescription>
		</parameter>
		<parameter name="owner2Code_t" class="java.lang.String">
			<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
			<defaultValueExpression><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
		</parameter>
		<parameter name="Start_t" class="java.lang.String">
			<parameterDescription><![CDATA[Start Record Key value for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
		</parameter>
		<parameter name="End_t" class="java.lang.String">
			<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
		</parameter>
		<parameter name="SortKey_t" class="java.lang.String">
			<parameterDescription><![CDATA[Sorting Key value for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
		</parameter>
		<parameter name="SortOrder_t" class="java.lang.String">
			<parameterDescription><![CDATA[Sorting Order value for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
		</parameter>
		<parameter name="FontName_t" class="java.lang.String">
			<parameterDescription><![CDATA[Font Name for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["DejaVu Sans"]]></defaultValueExpression>
		</parameter>
		<parameter name="CompanyName_t" class="java.lang.String">
			<parameterDescription><![CDATA[Company Name-to appear in Report]]></parameterDescription>
			<defaultValueExpression><![CDATA["Raaspi      "]]></defaultValueExpression>
		</parameter>
		<parameter name="Status_t" class="java.lang.Integer">
			<parameterDescription><![CDATA[Record status flag to filter and select]]></parameterDescription>
			<defaultValueExpression><![CDATA[null]]></defaultValueExpression>
		</parameter>

                <#assign showi=0> 
                <#foreach property in pojo.allPropertiesIterator>
                 <#if !c2h.isCollection(property) >
                  <#assign showi=showi+1> 
                  <#if c2j.isComponent(property)>
                   <#foreach componentProperty in property.value.propertyIterator>
		    <parameter name="${"show"+showi?string?left_pad(3,"0")}" isForPrompting="false" class="java.lang.Boolean">
		     <defaultValueExpression><![CDATA[true]]></defaultValueExpression>
		    </parameter>
                   </#foreach>
                  <#else>
                     <#if c2h.isManyToOne(property)>
		        <parameter name="${"show"+showi?string?left_pad(3,"0")}" isForPrompting="false" class="java.lang.Boolean">
			<defaultValueExpression><![CDATA[true]]></defaultValueExpression>
		        </parameter>
                     <#else>
		        <parameter name="${"show"+showi?string?left_pad(3,"0")}" isForPrompting="false" class="java.lang.Boolean">
			<defaultValueExpression><![CDATA[true]]></defaultValueExpression>
		        </parameter>
                     </#if>
                 </#if>
                </#if>
               </#foreach>


<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
    <#if (property.name?length >pL )>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
     <#if firstTime=="Y">
      <#assign ids1 = ids>
      <#assign firstTime="N"> 
     </#if>
      <#--
      since for components the property name is id and not prefixed column name, we use getGetterSignature to
      get the prefixed column name as in reveng.xml
      ids = pojo.getGetterSignature(property)?substring(3) >>> ${ids}
      -->
    </#if>
    </#foreach>
      <#assign ids = ids1>

      <#--
       jay Picks up the 1st key for now. enhance id1,id2,id3 etc and start parameter to have comma delimeted values 
      --> 
<#else>
  <#--
   In case of non composite ie Single Field Key

  -->
     <#assign ids = pojo.identifierProperty.name>
      <#--
      ids = pojo.identifierProperty.name >>> ${ids}
      -->
</#if>
<#-- gen strategy ${pojo.identifierProperty.value.identifierGeneratorStrategy} -->
<#if (ids?length > pL) && (ids?substring(5,6)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
<#else>
  <#assign keyAutoGen="N">
</#if>

      <#assign cc =0>
      <#assign cnc =0>
      <#assign counterc =0>
      <#assign counternc =0>

<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) >
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
   <#if (componentProperty.name?length >pL )>
    <#assign counterc =counterc+1>
    <#if  ((componentProperty.name?length > 9)  ) >
     <#assign crf =crf+1>
    </#if>
   </#if>
   </#foreach>
  <#else>
   <#assign counternc =counternc+1>
    <#if  ((property.name?length > pL)  ) >
     <#assign crf =crf+1>
    </#if>
    <#if property.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" || property.name?substring(5,6)=="j" >
      <#assign keyField=property.name>
    </#if>
  </#if>
 </#if>
</#if>
</#foreach>
<#if (crf > 18) >
 <#assign wv =58>
 <#assign xv =-wv-xs>
<#else> 
 <#assign wv =(1140/crf)?floor-xs>
 <#if wv gt 120 >
  <#assign wv=120>
 </#if>
 <#assign xv =-wv-xs>
</#if>

     	<queryString><![CDATA[SELECT
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) >
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
   <#if (componentProperty.name?length >pL )>
     <#assign cc =cc+1>
     <#if (cc < counterc)>
       ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
     <#else>
       ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
     </#if>
     <#if componentProperty.name?substring(pfS,pfE)=="ss">
      <#assign useDateKey="Y">
     </#if>
   </#if>
   </#foreach>
  <#else>
     <#assign cnc =cnc+1>
     <#if (cnc < counternc)>
       <#if c2h.isManyToOne(property)>
        ${pojo.shortName?substring(eL)?lower_case}.${property.columnIterator.next().name} AS ${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name},
       <#else>
        ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case},
       </#if>
     <#else>
       <#if c2h.isManyToOne(property)>
        ${pojo.shortName?substring(eL)?lower_case}.${property.columnIterator.next().name} AS ${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name}
       <#else>
        ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}
       </#if>
     </#if>
     <#if property.name?substring(pfS,pfE)=="ee">
      <#assign useDateKey="Y">
     </#if>
     <#if property.name?substring(pfS,pfE)=="zf"> 
      <#assign statusFlagField=property.name>
     </#if>   

  </#if>
 </#if>
</#if>
</#foreach>

FROM
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case} WHERE 
      <#if menuAttributes?substring(efS,efE) == '1A'>
         (${pojo.shortName?substring(eL)?lower_case}.quantity != 0.0) AND
      </#if>
      <#if menuAttributes?substring(efS,efE) == '1F'>
         (${pojo.shortName?substring(eL)?lower_case}.quanrecd != ${pojo.shortName?substring(eL)?lower_case}.physqty) AND
      </#if>
<#if useDateKey = "Y">
   <#if keyAutoGen=="Y" >
       <#if statusFlagField !=""> 
        ${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} >=  $P{Start_t} AND   ${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} <= $P{End_t} AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t} and (${pojo.shortName?substring(eL)?lower_case}.statusfl = $P{Status_t} or $P{Status_t} is null) ) ]]></queryString>
       <#else>
        ${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} >=  $P{Start_t} AND   ${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} <= $P{End_t} AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t} ]]></queryString>
       </#if>
   <#else>
       <#if statusFlagField !=""> 
        ${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} >=  $P{Start_t} AND   ${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} <= $P{End_t} AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t} and (${pojo.shortName?substring(eL)?lower_case}.statusfl = $P{Status_t} or $P{Status_t} is null) ) ]]></queryString>
       <#else>
        ${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} >=  $P{Start_t} AND   ${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} <= $P{End_t} AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t}  ]]></queryString>
       </#if>
   </#if>
<#else>
   <#if keyAutoGen=="Y" && keyField != "" >
       <#if statusFlagField !=""> 
        (${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case}) >=  $P{Start_t} AND   (${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} <= $P{End_t}) AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t} and (${pojo.shortName?substring(eL)?lower_case}.statusfl = $P{Status_t} or $P{Status_t} is null) ) order by cast($P{SortKey_t} as varchar(32)) $P!{SortOrder_t}  ]]></queryString>
        <#else>
        (${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case}) >=  $P{Start_t} AND   (${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} <= $P{End_t}) AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t}  ) order by cast($P{SortKey_t} as varchar(32)) $P!{SortOrder_t}  ]]></queryString>
       </#if>
  <#else>
       <#if statusFlagField !=""> 
        RTRIM(${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start_t} AND   RTRIM(${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} <= $P{End_t} AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t} and (${pojo.shortName?substring(eL)?lower_case}.statusfl = $P{Status_t} or $P{Status_t} is null) ) )]]></queryString>
        <#else>
        RTRIM(${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start_t} AND   RTRIM(${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} <= $P{End_t} AND (${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code_t}  ) )]]></queryString>
       </#if>
   </#if>
</#if>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) >
  <#if c2j.isComponent(property)> 
    <#foreach componentProperty in property.value.propertyIterator>
    <#if (componentProperty.name?length >pL )>
     <#assign propertyType = componentProperty.value.typeName>
     <#if propertyType?contains("ime")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType?contains("ecimal")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType?contains("nteger")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType?contains("oolean")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.String"/>
     </#if>
    </#if>
    </#foreach>
  <#else>
     <#assign propertyType = property.value.typeName>
     <#if propertyType?contains("ime")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType?contains("ecimal")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType?contains("nteger")>
        <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType?contains(".model.")>
        <field name="${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType?contains("oolean")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.lang.String"/>
     </#if>
  </#if>
 </#if>
</#if>
</#foreach>

	</subDataset>

<#--  added ftl logic to point to foreign entity in place of pojo entity and also add ws concatanate for fields
      add logic to use By for mail and ship address
      
-->

<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if c2h.isManyToOne(property)>
      <#assign cc =0>
      <#assign cnc =0>
      <#assign counterc =0>
      <#assign counternc =0>
  <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>

  <#foreach parentProperty in parentPojo.allPropertiesIterator>
  <#if (parentProperty?? && parentProperty.name?length > pL)>  
   <#if !c2h.isCollection(parentProperty) >
    <#if c2j.isComponent(parentProperty)>
     <#foreach componentProperty in property.value.propertyIterator>
     <#if (componentProperty.name?length >pL )>
      <#assign counterc =counterc+1>
      <#if  ((componentProperty.name?length > 9)  ) >
       <#assign crf =crf+1>
      </#if>
     </#if>
     </#foreach>
    <#else>
     <#assign counternc =counternc+1>
     <#if  ((parentProperty.name?length > pL)  ) >
      <#assign crf =crf+1>
     </#if>
     <#if (parentProperty.name?length > pL) && parentProperty.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" || property.name?substring(5,6)=="j" >
      <#assign keyField=property.name>
     </#if>
    </#if>
   </#if>
  </#if>
  </#foreach>

  <#assign parentName = util.lower(parentPojo.shortName)>
  <#if (property.name?length > pL && parentName?length > pL) > 
    <#if property.name?contains("By")>
	<subDataset name="listDataSet${property.name?substring(eL)}" resourceBundle="messages">
    <#else>
	<subDataset name="listDataSet${parentName?substring(eL)}" resourceBundle="messages">
    </#if>
		<parameter name="foreign_sid${parentName?substring(eL)}" class="java.lang.Integer">
			<defaultValueExpression><![CDATA[]]></defaultValueExpression>
		</parameter>
		<parameter name="owner2Code" class="java.lang.String"/>
		<parameter name="foreign_matCodeitem" class="java.lang.String">
			<defaultValueExpression><![CDATA[]]></defaultValueExpression>
		</parameter>

     	<queryString><![CDATA[SELECT
  <#foreach parentProperty in parentPojo.allPropertiesIterator>
  <#if (parentProperty.name?length > pL && parentName?length > pL && property.name?length > pL)>
   <#if !c2h.isCollection(parentProperty) >
    <#if c2j.isComponent(parentProperty)>
     <#foreach componentProperty in parentProperty.value.propertyIterator>
     <#if (componentProperty.name?length > pL) > 
      <#assign cc =cc+1>
      <#if (cc < counterc)>
        ${parentName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
      <#else>
        ${parentName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}
      </#if>
      <#if componentProperty.name?substring(pfS,pfE)=="ss">
       <#assign useDateKey="Y">
      </#if>
     </#if>
     </#foreach>
    <#else>
     <#assign cnc =cnc+1>
     <#if (cnc < counternc)>
       <#if c2h.isManyToOne(property)>
        ${parentName?substring(eL)?lower_case}.${parentProperty.columnIterator.next().name} AS ${parentName?substring(eL)?lower_case}_${parentProperty.columnIterator.next().name},
       <#else>
        ${parentName?substring(eL)?lower_case}.${parentProperty.name?substring(pL)?lower_case} AS ${parentName?substring(eL)?lower_case}_${parentProperty.name?substring(pL)?lower_case},
       </#if>
     <#else>
       ${parentName?substring(eL)?lower_case}.${parentProperty.name?substring(pL)?lower_case} AS ${parentName?substring(eL)?lower_case}_${parentProperty.name?substring(pL)?lower_case}
     </#if>
     <#if parentProperty.name?substring(pfS,pfE)=="ee">
      <#assign useDateKey="Y">
     </#if>
    </#if>
   </#if>
  </#if>
  </#foreach>
  <#if (parentName?length > pL )>
  FROM
       ${schema}.${parentName?substring(eL)?lower_case} ${parentName?substring(eL)?lower_case} WHERE 
  <#if useDateKey = "Y">
   <#if keyAutoGen=="Y" >
        ${parentName?substring(eL)?lower_case}.sid  = $P{foreign_sid${parentName?substring(eL)}}   AND ${parentName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} ]]></queryString>
   <#else>
       ${parentName?substring(eL)?lower_case}.sid  = $P{foreign_sid${parentName?substring(eL)}}  AND ${parentName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} ]]></queryString>
   </#if>
  <#else>
   <#if keyAutoGen=="Y" && keyField != "" >
    <#if dbType="postgre">
       (${parentName?substring(eL)?lower_case}.sid)  = $P{foreign_sid${parentName?substring(eL)}}  AND ${parentName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} ]]></queryString>
    <#else>
       RTRIM(${parentName?substring(eL)?lower_case}.sid)  = $P{foreign_sid${parentName?substring(eL)}}  AND ${parentName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} )]]></queryString>
    </#if>
   <#else>
       RTRIM(${parentName?substring(eL)?lower_case}.sid)  = $P{foreign_sid${parentName?substring(eL)}}  AND ${parentName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} )]]></queryString>
    </#if>
  </#if>
  </#if>
  <#foreach parentProperty in parentPojo.allPropertiesIterator>
  <#if (parentProperty.name?length > pL && parentName?length > pL )>
   <#if !c2h.isCollection(parentProperty) >
    <#if c2j.isComponent(parentProperty)> 
     <#foreach componentProperty in parentProperty.value.propertyIterator>
      <#assign propertyType = componentProperty.value.typeName>
      <#if propertyType?contains("ime")>
       <field name="${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.sql.Timestamp"/>
      <#elseif propertyType?contains("ecimal")>
       <field name="${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.math.BigDecimal"/>
      <#elseif propertyType?contains("nteger")>
       <field name="${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.Integer"/>
      <#elseif propertyType?contains("oolean")>
       <field name="${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.Boolean"/>
      <#else>
       <field name="${parentName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.String"/>
      </#if>
     </#foreach>
    <#else>
     <#assign propertyType = parentProperty.value.typeName>
      <#if propertyType?contains("ime")>
       <field name="${parentName?substring(eL)?lower_case}_${parentProperty.columnIterator.next().name}" class="java.sql.Timestamp"/>
      <#elseif propertyType?contains("ecimal")>
       <field name="${parentName?substring(eL)?lower_case}_${parentProperty.columnIterator.next().name}" class="java.math.BigDecimal"/>
      <#elseif propertyType?contains("nteger")>
       <field name="${parentName?substring(eL)?lower_case}_${parentProperty.columnIterator.next().name}" class="java.lang.Integer"/>
      <#elseif propertyType?contains("oolean")>
       <field name="${parentName?substring(eL)?lower_case}_${parentProperty.columnIterator.next().name}" class="java.lang.Boolean"/>
      <#else>
       <field name="${parentName?substring(eL)?lower_case}_${parentProperty.columnIterator.next().name}" class="java.lang.String"/>
      </#if>
     </#if>
   </#if>
  </#if>
  </#foreach>
  </#if>

	</subDataset>
 </#if>
</#if>
</#foreach>
<#if menuAttributes?substring(efS,efE) == '1A'>
	<subDataset name="listDataSetserialnumbers" resourceBundle="messages">
		<parameter name="foreign_matCodeitem" class="java.lang.String">
			<defaultValueExpression><![CDATA[]]></defaultValueExpression>
		</parameter>
		<parameter name="owner2Code" class="java.lang.String"/>

     	<queryString><![CDATA[SELECT
        serialnumbers.sid AS serialnumbers_sid,

        serialnumbers.serialno AS serialnumbers_serialno,

        serialnumbers.matcode AS serialnumbers_matcode,

        serialnumbers.quanrecd AS serialnumbers_quanrecd,

        serialnumbers.vendor AS serialnumbers_vendor,

        serialnumbers.location AS serialnumbers_location,

        serialnumbers.recvrpt AS serialnumbers_recvrpt,

        serialnumbers.infl AS serialnumbers_infl,

        serialnumbers.phy AS serialnumbers_phy,

        serialnumbers.datetin AS serialnumbers_datetin,

        serialnumbers.datetout AS serialnumbers_datetout,

        serialnumbers.jobno AS serialnumbers_jobno,

        serialnumbers.quanissd AS serialnumbers_quanissd,

        serialnumbers.quanrejd AS serialnumbers_quanrejd,

        serialnumbers.customer AS serialnumbers_customer,

        serialnumbers.altserno AS serialnumbers_altserno,

        serialnumbers.selprice AS serialnumbers_selprice,

        serialnumbers.physqty AS serialnumbers_physqty,

        serialnumbers.cpono AS serialnumbers_cpono,

        serialnumbers.customej AS serialnumbers_customej,

        serialnumbers.sperson AS serialnumbers_sperson,

        serialnumbers.cartonid AS serialnumbers_cartonid,

        serialnumbers.cartonpr AS serialnumbers_cartonpr,

        serialnumbers.packcode AS serialnumbers_packcode,

        serialnumbers.tarecode AS serialnumbers_tarecode,

        serialnumbers.shipcode AS serialnumbers_shipcode,

        serialnumbers.type AS serialnumbers_type,

        serialnumbers.printmstat AS serialnumbers_printmstat,

        serialnumbers.prinmtfldt AS serialnumbers_prinmtfldt,

        serialnumbers.pono AS serialnumbers_pono,

        serialnumbers.scandatet AS serialnumbers_scandatet,

        serialnumbers.butt AS serialnumbers_butt,

        serialnumbers.statusfl AS serialnumbers_statusfl,

        serialnumbers.orgcost AS serialnumbers_orgcost,

        serialnumbers.orgpono AS serialnumbers_orgpono,

        serialnumbers.orgjobno AS serialnumbers_orgjobno,

        serialnumbers.owner AS serialnumbers_owner,

        serialnumbers.barserial AS serialnumbers_barserial,

        serialnumbers.owner2 AS serialnumbers_owner2


FROM
       genapp.serialnumbers serialnumbers WHERE 
       (serialnumbers.matcode)  = $P{foreign_matCodeitem}  AND serialnumbers.owner2 = $P{owner2Code} ]]></queryString>
        <field name="serialnumbers_sid" class="java.lang.Integer"/>
      <field name="serialnumbers_serialno" class="java.lang.String"/>
      <field name="serialnumbers_matcode" class="java.lang.String"/>
      <field name="serialnumbers_quanrecd" class="java.math.BigDecimal"/>
      <field name="serialnumbers_vendor" class="java.lang.String"/>
      <field name="serialnumbers_location" class="java.lang.String"/>
      <field name="serialnumbers_recvrpt" class="java.lang.String"/>
      <field name="serialnumbers_infl" class="java.lang.Boolean"/>
      <field name="serialnumbers_phy" class="java.lang.Boolean"/>
      <field name="serialnumbers_datetin" class="java.sql.Timestamp"/>
      <field name="serialnumbers_datetout" class="java.sql.Timestamp"/>
      <field name="serialnumbers_jobno" class="java.lang.String"/>
      <field name="serialnumbers_quanissd" class="java.math.BigDecimal"/>
      <field name="serialnumbers_quanrejd" class="java.math.BigDecimal"/>
      <field name="serialnumbers_customer" class="java.lang.String"/>
      <field name="serialnumbers_altserno" class="java.lang.String"/>
      <field name="serialnumbers_selprice" class="java.math.BigDecimal"/>
      <field name="serialnumbers_physqty" class="java.math.BigDecimal"/>
      <field name="serialnumbers_cpono" class="java.lang.String"/>
      <field name="serialnumbers_customej" class="java.lang.String"/>
      <field name="serialnumbers_sperson" class="java.lang.String"/>
      <field name="serialnumbers_cartonid" class="java.lang.String"/>
      <field name="serialnumbers_cartonpr" class="java.lang.Boolean"/>
      <field name="serialnumbers_packcode" class="java.lang.String"/>
      <field name="serialnumbers_tarecode" class="java.lang.String"/>
      <field name="serialnumbers_shipcode" class="java.lang.String"/>
      <field name="serialnumbers_type" class="java.lang.String"/>
        <field name="serialnumbers_printmstat" class="java.lang.Integer"/>
      <field name="serialnumbers_prinmtfldt" class="java.sql.Timestamp"/>
      <field name="serialnumbers_pono" class="java.lang.String"/>
      <field name="serialnumbers_scandatet" class="java.sql.Timestamp"/>
      <field name="serialnumbers_butt" class="java.lang.String"/>
        <field name="serialnumbers_statusfl" class="java.lang.Integer"/>
      <field name="serialnumbers_orgcost" class="java.math.BigDecimal"/>
      <field name="serialnumbers_orgpono" class="java.lang.String"/>
      <field name="serialnumbers_orgjobno" class="java.lang.String"/>
      <field name="serialnumbers_owner" class="java.lang.String"/>
      <field name="serialnumbers_barserial" class="java.lang.String"/>
      <field name="serialnumbers_owner2" class="java.lang.String"/>
		<variable name="ser_quantityPhy" class="java.math.BigDecimal" calculation="Sum">
			<variableExpression><![CDATA[$F{serialnumbers_physqty}]]></variableExpression>
		</variable>

	</subDataset>
</#if>



<#-- below main report parameter, query etc 
-->
	<parameter name="DisplayAs" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Report Output as HTML or as PDF]]></parameterDescription>
		<defaultValueExpression ><![CDATA["PDF"]]></defaultValueExpression>
	</parameter>
	<parameter name="MarkedOnes" isForPrompting="true" class="java.lang.Boolean">
 		<parameterDescription><![CDATA[Select Marked Records Only]]></parameterDescription>
      </parameter>
	<parameter name="owner2Code" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
	</parameter>
	<parameter name="Start" class="java.lang.String">
		<parameterDescription><![CDATA[Start Record Key value for Select]]></parameterDescription>
		<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
	</parameter>
	<parameter name="End" class="java.lang.String">
		<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
		<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
	</parameter>
		<parameter name="SortKey" class="java.lang.String">
			<parameterDescription><![CDATA[Sorting Key value for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
		</parameter>
		<parameter name="SortOrder" class="java.lang.String">
			<parameterDescription><![CDATA[Sorting Order value for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
		</parameter>
		<parameter name="FontName" class="java.lang.String">
			<parameterDescription><![CDATA[Font Name for Select]]></parameterDescription>
			<defaultValueExpression><![CDATA["DejaVu Sans"]]></defaultValueExpression>
		</parameter>
		<parameter name="CompanyName" class="java.lang.String">
			<parameterDescription><![CDATA[Company Name-to appear in Report]]></parameterDescription>
			<defaultValueExpression><![CDATA["Raaspi      "]]></defaultValueExpression>
		</parameter>
		<parameter name="Status" class="java.lang.Integer">
			<parameterDescription><![CDATA[Record Status flag]]></parameterDescription>
			<defaultValueExpression><![CDATA[null]]></defaultValueExpression>
		</parameter>

          <#assign showi=0> 
          <#foreach property in pojo.allPropertiesIterator>
           <#if !c2h.isCollection(property) >
            <#assign showi=showi+1> 
            <#if c2j.isComponent(property)>
             <#foreach componentProperty in property.value.propertyIterator>
		<parameter name="${"show"+showi?string?left_pad(3,"0")}" isForPrompting="false" class="java.lang.Boolean">
			<defaultValueExpression><![CDATA[true]]></defaultValueExpression>
		</parameter>
             </#foreach>
          <#else>
            <#if c2h.isManyToOne(property)>
		<parameter name="${"show"+showi?string?left_pad(3,"0")}" isForPrompting="false" class="java.lang.Boolean">
			<defaultValueExpression><![CDATA[true]]></defaultValueExpression>
		</parameter>
                     <#else>
		<parameter name="${"show"+showi?string?left_pad(3,"0")}" isForPrompting="false" class="java.lang.Boolean">
			<defaultValueExpression><![CDATA[true]]></defaultValueExpression>
		</parameter>
            </#if>
          </#if>
         </#if>
        </#foreach>

      <#assign cc =0>
      <#assign cnc =0>
      <#assign counterc =0>
      <#assign counternc =0>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL)>
 <#if !c2h.isCollection(property) >
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign counterc =counterc+1>
    <#if  ((componentProperty.name?length > 9)  ) >
     <#assign crf =crf+1>
    </#if>
   </#foreach>
  <#else>
   <#assign counternc =counternc+1>
    <#if  ((property.name?length > pL)  ) >
     <#assign crf =crf+1>
    </#if>
    <#if property.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" || property.name?substring(5,6)=="j" >
      <#assign keyField=property.name>
    </#if>
  </#if>
 </#if>
</#if>
</#foreach>
<#if (crf > 18) >
 <#assign wv =58>
 <#assign xv =-wv-xs>
<#else> 
 <#assign wv =(1140/crf)?floor-xs>
 <#if wv gt 120 >
  <#assign wv=120>
 </#if>
 <#assign xv =-wv-xs>
</#if>

     	<queryString><![CDATA[SELECT
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) >
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
   <#if (componentProperty.name?length > pL)>  
     <#assign cc =cc+1>
     <#if (cc < counterc)>
       ${pojo.shortName?substring(eL)?lower_case}.${componentProperty.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case},
     </#if>
     <#if componentProperty.name?substring(pfS,pfE)=="ss">
      <#assign useDateKey="Y">
     </#if>
   </#if>
   </#foreach>

  <#else>
     <#assign cnc =cnc+1>
     <#if (cnc < counternc)>
       <#if c2h.isManyToOne(property)>
        ${pojo.shortName?substring(eL)?lower_case}.${property.columnIterator.next().name} AS ${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name},
       <#else>
        ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case},
       </#if>
     <#else>
       <#if c2h.isManyToOne(property)>
        ${pojo.shortName?substring(eL)?lower_case}.${property.columnIterator.next().name} AS ${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name}
       <#else>
        ${pojo.shortName?substring(eL)?lower_case}.${property.name?substring(pL)?lower_case} AS ${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}
       </#if>
     </#if>
    <#if property.name?substring(pfS,pfE)=="ee">
      <#assign useDateKey="Y">
    </#if>
    <#if property.name?substring(pfS,pfE)=="zf"> 
      <#assign statusFlagField=property.name>
    </#if>   


  </#if>
 </#if>
</#foreach>

FROM
       ${schema}.${pojo.shortName?substring(eL)?lower_case} ${pojo.shortName?substring(eL)?lower_case} WHERE 
<#if useDateKey = "Y">
   <#if keyAutoGen=="Y" >
        ${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} >=  $P{Start} AND   ${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} <= $P{End} AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} ]]></queryString>
   <#else>
       ${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} >=  $P{Start} AND   ${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} <= $P{End} AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} ]]></queryString>
   </#if>
<#else>
   <#if keyAutoGen=="Y" && keyField != "" >
       (${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(eL)?lower_case}.${keyField?substring(pL)?lower_case} <= $P{End}) AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} order by cast($P{SortKey} as varchar(32)) $P!{SortOrder}]]></queryString>
   <#else>
       RTRIM(${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case}) >=  $P{Start} AND   RTRIM(${pojo.shortName?substring(eL)?lower_case}.${ids?substring(pL)?lower_case} <= $P{End} AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} )]]></queryString>
    </#if>
</#if>
   
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) >
  <#if c2j.isComponent(property)> 
    <#foreach componentProperty in property.value.propertyIterator>
    <#if (componentProperty.name?length > pL)>  
     <#assign propertyType = componentProperty.value.typeName>
     <#if propertyType?contains("ime")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType?contains("ecimal")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType?contains("nteger")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType?contains("oolean")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${componentProperty.name?substring(pL)?lower_case}" class="java.lang.String"/>
     </#if>
    </#if>
    </#foreach>
  <#else>
     <#assign propertyType = property.value.typeName>
     <#assign propertyType = property.value.typeName>
     <#if propertyType?contains("ime")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType?contains("ecimal")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType?contains("nteger")>
        <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType?contains(".model.")>
        <field name="${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType?contains("oolean")>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}" class="java.lang.String"/>
     </#if>
  </#if>
 </#if>
</#foreach>
       <#if (menuAttributes?substring(efS,efE) == '1A')>
	<variable name="item_quantity1" class="java.math.BigDecimal" resetType="Column" calculation="Sum">
		<variableExpression><![CDATA[$F{item_quantity}]]></variableExpression>
	</variable>
	<variable name="item_quantity2" class="java.math.BigDecimal" resetType="Column" calculation="Sum">
		<variableExpression><![CDATA[$F{item_selprice}.multiply($F{item_quantity})]]></variableExpression>
	</variable>
	<variable name="item_quantityMinus" class="java.math.BigDecimal" resetType="Column" calculation="Sum">
		<variableExpression><![CDATA[$F{item_quantity}.compareTo(BigDecimal.ZERO)<0?$F{item_quantity}:BigDecimal.ZERO]]></variableExpression>
	</variable>
        <variable name="item_quantityPhy" class="java.math.BigDecimal"/>

       </#if>
       <#if (menuAttributes?substring(efS,efE) == '20')>
	<variable name="customer_custtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{customer_custtqty}]]></variableExpression>
	</variable>
	<variable name="customer_custtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{customer_custtotl}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '30')>
	<variable name="vendor_vendtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vendor_vendtqty}]]></variableExpression>
	</variable>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vendor_vendtotl}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '40')>
	<variable name="employee_empltotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{employee_empltqty}]]></variableExpression>
	</variable>
	<variable name="employee_empltotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{employee_empltotl}]]></variableExpression>
	</variable>
       </#if>

       <#if (menuAttributes?substring(efS,efE) == '23')>
	<variable name="customer_custtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cuquote_qtytotal}]]></variableExpression>
	</variable>
	<variable name="customer_custtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cuquote_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '24')>
	<variable name="customer_custtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cuorders_qtytotal}]]></variableExpression>
	</variable>
	<variable name="customer_custtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cuorders_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '25')>
	<variable name="customer_custtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{shipment_qtytotal}]]></variableExpression>
	</variable>
	<variable name="customer_custtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{shipment_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '26')>
	<variable name="customer_custtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cuinvoice_qtytotal}]]></variableExpression>
	</variable>
	<variable name="customer_custtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cuinvoice_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '27')>
	<variable name="customer_custtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cpayment_qtytotal}]]></variableExpression>
	</variable>
	<variable name="customer_custtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{cpayment_amounttotal}]]></variableExpression>
	</variable>
       </#if>

       <#if (menuAttributes?substring(efS,efE) == '33')>
	<variable name="vendor_vendtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{venquote_qtytotal}]]></variableExpression>
	</variable>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{venquote_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '34')>
	<variable name="vendor_vendtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vendorders_qtytotal}]]></variableExpression>
	</variable>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vendorders_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '36')>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{venartha_chqamt}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '37')>
	<variable name="vendor_vendtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vshipmen_qtytotal}]]></variableExpression>
	</variable>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vshipmen_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '38')>
	<variable name="vendor_vendtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vpayment_qtytotal}]]></variableExpression>
	</variable>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vpayment_amounttotal}]]></variableExpression>
	</variable>
       </#if>
       <#if (menuAttributes?substring(efS,efE) == '3a')>
	<variable name="vendor_vendtotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vinvoice_qtytotal}]]></variableExpression>
	</variable>
	<variable name="vendor_vendtotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{vinvoice_amounttotal}]]></variableExpression>
	</variable>
       </#if>

       <#if (menuAttributes?substring(efS,efE) == '44')>
	<variable name="employee_empltotl1" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{emplorders_qtytotal}]]></variableExpression>
	</variable>
	<variable name="employee_empltotl2" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[$F{emplorders_amounttotal}]]></variableExpression>
	</variable>
       </#if>


	<background>
		<band splitType="Stretch"/>
	</background>
	<title>
		<band height="194" splitType="Stretch">
			<rectangle>
				<reportElement mode="Opaque" x="0" y="0" width="1199" height="92" forecolor="#CCCCCC" backcolor="#CCCCCC"/>
			</rectangle>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement  style="Title" 
						x="120"
						y="19"
						width="234"
						height="22"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement  textAlignment="Right" markup="styled">
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{${pojo.shortName?substring(eL)?cap_first}}]]></textFieldExpression>
				</textField>
			<staticText>
				<reportElement style="Title" x="520" y="19" width="130" height="32"/>
				<textElement>
				</textElement>
				<text><![CDATA[Report]]></text>
			</staticText>
			<rectangle>
				<reportElement mode="Transparent" x="960" y="4" width="142" height="46" forecolor="#FFFFFF" backcolor="#FFFFFF"/>
				<graphicElement>
					<pen lineWidth="0.0" lineStyle="Double"/>
				</graphicElement>
			</rectangle>

			<textField>
				<reportElement style="SubTitle" x="5" y="46" width="336" height="22"/>
				<textElement/>
				<textFieldExpression class="java.lang.String"><![CDATA[$P{CompanyName}]]></textFieldExpression>
			</textField>

			<textField pattern="dd/MM/yyyy">
				<reportElement x="453" y="51" width="100" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[new java.util.Date()]]></textFieldExpression>
			</textField>


			<componentElement>
				<reportElement key="table" style="table" x="0" y="80" width="752" height="60"/>
				<jr:table xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd">
					<datasetRun subDataset="tableDataSet">
						<datasetParameter name="DisplayAs_t">
							<datasetParameterExpression><![CDATA[$P{DisplayAs}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="MarkedOnes_t">
							<datasetParameterExpression><![CDATA[$P{MarkedOnes}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="owner2Code_t">
							<datasetParameterExpression><![CDATA[$P{owner2Code}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="Start_t">
							<datasetParameterExpression><![CDATA[$P{Start}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="End_t">
							<datasetParameterExpression><![CDATA[$P{End}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="SortKey_t">
							<datasetParameterExpression><![CDATA[$P{SortKey}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="SortOrder_t">
							<datasetParameterExpression><![CDATA[$P{SortOrder}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="FontName_t">
							<datasetParameterExpression><![CDATA[$P{FontName}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="CompanyName_t">
							<datasetParameterExpression><![CDATA[$P{CompanyName}]]></datasetParameterExpression>
						</datasetParameter>
						<datasetParameter name="Status_t">
							<datasetParameterExpression><![CDATA[$P{Status}]]></datasetParameterExpression>
						</datasetParameter>

<#assign showi=0> 
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) >
  <#assign showi=showi+1> 
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
						<datasetParameter name="${"show"+showi?string?left_pad(3,"0")}">
							<datasetParameterExpression><![CDATA[$P{${"show"+showi?string?left_pad(3,"0")}}]]></datasetParameterExpression>
						</datasetParameter>
   </#foreach>
  <#else>
                     <#if c2h.isManyToOne(property)>
						<datasetParameter name="${"show"+showi?string?left_pad(3,"0")}">
							<datasetParameterExpression><![CDATA[$P{${"show"+showi?string?left_pad(3,"0")}}]]></datasetParameterExpression>
						</datasetParameter>
                     <#else>
						<datasetParameter name="${"show"+showi?string?left_pad(3,"0")}">
							<datasetParameterExpression><![CDATA[$P{${"show"+showi?string?left_pad(3,"0")}}]]></datasetParameterExpression>
						</datasetParameter>
                     </#if>

  </#if>
 </#if>
</#foreach>




										<datasetParameter name="REPORT_RESOURCE_BUNDLE">
											<datasetParameterExpression><![CDATA[$P{REPORT_RESOURCE_BUNDLE}]]></datasetParameterExpression>
										</datasetParameter>

						<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					</datasetRun>
<#--
 copy logic from reportgenerator to iterate and produce the below logic for each entity instead of customer
 also make listDatset${pojo} below
 for each property
   jr:column which has th,tf,ch w pojo field $R,cf and detail cell. detail cell has print when and pojo $F
   if property is foreign field ie manytoone
    optional componentControl which can refer to Listsubset and parent pojo fields
   once $R works then use
	(if manytoone)			textFieldExpression   class="java.lang.String"CDATAR{property.columnIterator.next().name}}]]textFieldExpression

	(else)			textFieldExpression   class="java.lang.String"CDATA[$Rproperty.name?substring(pL)cap_firsttextFieldExpression
   if $R not solved
   use use show00xh as parameters, set messages[] value into them, pass to table parameter and use
-->
<#assign showi=0>
<#-- below iterates through each property and generates all columns and supress extra colums at report execution time using showwxxx
  
-->
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
    <#if !c2h.isCollection(property) >
      <#assign showi=showi+1> 
      <#assign propertyType = property.value.typeName>
     <#if propertyType?contains("ime")>
       <#assign clss = "java.sql.Timestamp">
     <#elseif propertyType?contains("ecimal")>
       <#assign clss = "java.math.BigDecimal">
     <#elseif propertyType?contains("nteger")>
       <#assign clss = "java.lang.Integer">
     <#elseif propertyType?contains("ate")>
       <#assign clss = "java.sql.Date">
     <#elseif propertyType?contains("oolean")>
       <#assign clss = "java.lang.Boolean">
     <#else>
       <#assign clss = "java.lang.String">
     </#if>
                         <#if clss= "java.lang.String">
					<#assign cwidth=50>
                         <#elseif clss = "java.sql.Timestamp" >
					<#assign cwidth=45>
                         <#else >
					<#assign cwidth=40>
                         </#if> 
                         <#if c2h.isManyToOne(property)>
					<#assign cwidth=100>
                         </#if> 
                         <#assign xv=xv+cwidth>

					<jr:column width="${cwidth}">
                            <#if property.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" || property.name?substring(5,6)=="j" >
					  <printWhenExpression><![CDATA[true]]></printWhenExpression>
                            <#else>
					  <printWhenExpression><![CDATA[$P{${"show"+showi?string?left_pad(3,"0")}}]]></printWhenExpression>
                            </#if>
						<jr:columnHeader style="table_CH" height="25" rowSpan="1">
							<textField>
								<reportElement x="0" y="0" width="${cwidth}" height="25">
								</reportElement>
								<textElement/>
                                           <#if c2h.isManyToOne(property)>
				                       <textFieldExpression   class="java.lang.String"><![CDATA["${property.columnIterator.next().name}"]]></textFieldExpression>
                                           <#else>
				                       <textFieldExpression   class="java.lang.String"><![CDATA["${property.name?substring(pL)?cap_first}"]]></textFieldExpression>
                                           </#if>
							</textField>
						</jr:columnHeader>
						<jr:detailCell style="table_TD" height="30" rowSpan="1">
							<textField isStretchWithOverflow="true" isBlankWhenNull="true">
                                                              <#if property.name?substring(6,7)=="q">
								<reportElement x="0" y="0" width="${cwidth}" height="15" forecolor="#FF0000">
                                                              <#else>
								<reportElement x="0" y="0" width="${cwidth}" height="15">
                                                              </#if>
								</reportElement>
								<textElement/>
                                          <#if c2h.isManyToOne(property)>
				                      <textFieldExpression   class="${clss}"><![CDATA[$F{${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name}}]]></textFieldExpression>
                                          <#else>
				                      <textFieldExpression   class="${clss}"><![CDATA[$F{${pojo.shortName?substring(eL)?lower_case}_${property.name?substring(pL)?lower_case}}]]></textFieldExpression>
                                          </#if>
							</textField>
                                     <#if c2h.isManyToOne(property)>
                                      <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
                                      <#assign parentName = util.lower(parentPojo.shortName)>
                                      <#if (parentName?length >pL )>
							 <componentElement>
								<reportElement stretchType="RelativeToBandHeight" x="0" y="15" width="${cwidth}" height="15">
                                          </reportElement>
								<jr:list printOrder="Vertical">
                                           <#if property.name?contains("By")>
									<datasetRun subDataset="listDataSet${property.name?substring(eL)}">
                                           <#else>
									<datasetRun subDataset="listDataSet${parentName?substring(eL)}">
                                           </#if>
										<datasetParameter name="foreign_sid${parentName?substring(eL)}">
											<datasetParameterExpression><![CDATA[$F{${pojo.shortName?substring(eL)?lower_case}_${property.columnIterator.next().name}}]]></datasetParameterExpression>
										</datasetParameter>
										<datasetParameter name="owner2Code">
											<datasetParameterExpression><![CDATA[$F{${pojo.shortName?substring(eL)?lower_case}_owner2}]]></datasetParameterExpression>
										</datasetParameter>
										<datasetParameter name="REPORT_RESOURCE_BUNDLE">
											<datasetParameterExpression><![CDATA[$P{REPORT_RESOURCE_BUNDLE}]]></datasetParameterExpression>
										</datasetParameter>
										<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
									</datasetRun>
									<jr:listContents height="15" width="100">
                                                <#assign addedFields ="">
                                                <#foreach parentProperty in parentPojo.allPropertiesIterator>
                                                <#if (parentProperty.name?length >pL )>
                                                <#if !c2h.isCollection(parentProperty) >
                                                 <#if c2j.isComponent(parentProperty)>
                                                  <#foreach componentProperty in parentProperty.value.propertyIterator>
                                                  </#foreach>
                                                 <#else>
                                                  <#--ex shipment parent is Item, item has descript and s(subcode) so add it. parent is customer lastname has s
                                                         shipment has cuorders and purchsno has n(genereted) in pkS,pkE
                                                   -->
                                                  <#if parentProperty.name?substring(pkS,pkE)=="s" | parentProperty.name?substring(pkS,pkE)=="n" | (parentProperty.name?substring(pkS,pkE)=="2" && parentProperty.name?substring(pfS,pfE)!="2o" ) | parentProperty.name?substring(pkS,pkE)=="3"
                                                   | parentProperty.name?substring(pkS,pkE)=="4" | parentProperty.name?substring(pkS,pkE)=="5" | parentProperty.name?substring(10,12)=="24">
                                                   <#assign addedFields=addedFields+"($F{${parentName?substring(eL)}_${parentProperty.name?substring(pL)}}==null?\"\":$F{${parentName?substring(eL)}_${parentProperty.name?substring(pL)}})+\" \"+">
                                                  <#else>
                                                  </#if>
                                                 </#if> 
                                                </#if>
                                               </#if>
                                               </#foreach>
                                               <#if addedFields !="">
                                                <#assign addedFields=addedFields?substring(0,addedFields?length-5)>
                                               </#if>
										<textField isStretchWithOverflow="true" isBlankWhenNull="true">
											<reportElement stretchType="RelativeToBandHeight" x="0" y="0" width="100" height="15"/>
											<textElement/>
											<textFieldExpression><![CDATA[${addedFields}]]></textFieldExpression>
										</textField>
									</jr:listContents>
								</jr:list>
							</componentElement>
                                   </#if>
                                  </#if>
						</jr:detailCell>
					</jr:column>
    </#if>
</#if>
</#foreach>

<#if menuAttributes?substring(efS,efE) == '1A'>

					<jr:column width="100" uuid="a641966d-1673-4129-9be7-61d00ea15afc">
						<printWhenExpression><![CDATA[true]]></printWhenExpression>
						<jr:columnHeader style="table_CH" height="25" rowSpan="1">
							<textField>
								<reportElement x="0" y="0" width="100" height="25" uuid="cdeae691-dd01-4e2d-b013-021845e7217c"/>
								<textFieldExpression><![CDATA["Counted stock"]]></textFieldExpression>
							</textField>
						</jr:columnHeader>
						<jr:detailCell style="table_TD" height="30" rowSpan="1">
							<componentElement>
								<reportElement stretchType="RelativeToBandHeight" x="0" y="15" width="100" height="15" uuid="9a33aac0-92be-4a4b-932a-7f414d20a968"/>
								<jr:list printOrder="Vertical">
									<datasetRun subDataset="listDataSetserialnumbers" uuid="8c2fd34e-21aa-476f-8285-5706f423791d">
										<datasetParameter name="foreign_matCodeitem">
											<datasetParameterExpression><![CDATA[$F{item_matcode}]]></datasetParameterExpression>
										</datasetParameter>
										<datasetParameter name="owner2Code">
											<datasetParameterExpression><![CDATA[$F{item_owner2}]]></datasetParameterExpression>
										</datasetParameter>
										<datasetParameter name="REPORT_RESOURCE_BUNDLE">
											<datasetParameterExpression><![CDATA[$P{REPORT_RESOURCE_BUNDLE}]]></datasetParameterExpression>
										</datasetParameter>
										<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
									</datasetRun>
									<jr:listContents height="15" width="100">
										<textField isStretchWithOverflow="true" isBlankWhenNull="true">
											<reportElement stretchType="RelativeToBandHeight" x="0" y="0" width="100" height="15" uuid="0f102a61-7a6f-470c-a8cf-8feecfcffc43"/>
											<textFieldExpression><![CDATA[$F{serialnumbers_physqty}]]></textFieldExpression>
										</textField>
									</jr:listContents>
								</jr:list>
							</componentElement>
						</jr:detailCell>
					</jr:column>
</#if>

				</jr:table>
			</componentElement>
		</band>
	</title>
	<columnFooter>
		<band height="56">
			<staticText>
				<reportElement  x="0" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Record count]]></text>
			</staticText>

                       <#if (menuAttributes?substring(efS,efE) == '1A')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Inventory Count]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Inventory Amount]]></text>
			</staticText>
			<staticText>
				<reportElement  x="450" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[-ve Inventory Count]]></text>
			</staticText>
			<staticText>
				<reportElement  x="600" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Phy Inventory Count]]></text>
			</staticText>

			<textField pattern="###0.00">
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{item_quantity1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{item_quantity2}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="450" y="25" width="50" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{item_quantityMinus}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="600" y="25" width="99" height="30" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[See Stock Count Report]]></text>
			</staticText>

                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '20')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Purchase Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Purchase Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl2}]]></textFieldExpression>
			</textField>

                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '30')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Purchase Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Purchase Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>

			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>

                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '40')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="30" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Purchase Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Purchase Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{employee_empltotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>

			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{employee_empltotl2}]]></textFieldExpression>
			</textField>
                       </#if>

                       <#if (menuAttributes?substring(efS,efE) == '23')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Quotation Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Quotation Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>

			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl2}]]></textFieldExpression>
			</textField>
                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '24')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Orders Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Orders Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl2}]]></textFieldExpression>
			</textField>
                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '25')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Shipment Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="30" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Shipment Charge Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title"  x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl2}]]></textFieldExpression>
			</textField>
                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '26')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Invoice Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Invoice Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl2}]]></textFieldExpression>
			</textField>
                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '27')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Payment Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Payment Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{customer_custtotl2}]]></textFieldExpression>
			</textField>
                       </#if>


                       <#if (menuAttributes?substring(efS,efE) == '33')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Quotation Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Quotation Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="20" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>
                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '34')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Orders Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Orders Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>
                       </#if>
                       <#if (menuAttributes?substring(efS,efE) == '36')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Cheq Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Chq Issued Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>
                       </#if>

                       <#if (menuAttributes?substring(efS,efE) == '37')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Shipment Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Shipment Charge Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>
                       </#if>

                       <#if (menuAttributes?substring(efS,efE) == '3a')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Invoice Items]]></text>
			</staticText>
			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl1}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement  x="300" y="25" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Invoice Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>
                       </#if>

                       <#if (menuAttributes?substring(efS,efE) == '38')>
			<staticText>
				<reportElement  x="150" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Payment Items]]></text>
			</staticText>
			<staticText>
				<reportElement  x="300" y="0" width="99" height="20" uuid="5ae4662c-7ed7-456f-aaed-7a8e074a73cc"/>
				<text><![CDATA[Payment Amount]]></text>
			</staticText>

			<textField>
				<reportElement style="Title" x="150" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl1}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Column header" x="0" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression ><![CDATA[$V{REPORT_COUNT}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement style="Title" x="300" y="25" width="99" height="30" uuid="1fa7e173-b82c-44c1-82ba-a3e7f21780fb"/>
				<textFieldExpression class="java.math.BigDecimal"><![CDATA[$V{vendor_vendtotl2}]]></textFieldExpression>
			</textField>
                       </#if>







		</band>
	</columnFooter>
		<pageFooter>
			<band height="27"  isSplitAllowed="true" >

				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement style="Column header"
						x="325"
						y="4"
						width="170"
						height="19"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA["Page " + $V{PAGE_NUMBER} + " of "]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Report" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement   style="Column header"
						x="499"
						y="4"
						width="36"
						height="19"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA["" + $V{PAGE_NUMBER}]]></textFieldExpression>
				</textField>
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="0"
						y="3"
						width="1140"
						height="0"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement  style="Column header"
						x="1"
						y="6"
						width="209"
						height="19"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
					</textElement>
				<textFieldExpression   class="java.util.Date"><![CDATA[new Date()]]></textFieldExpression>
				</textField>
			</band>
		</pageFooter>

</jasperReport>
</#if>
</#if>
