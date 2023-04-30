<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes2 = pojo.shortName?substring(0,eL)?upper_case>
<#if (menuAttributes2?substring(efS,efE) == '52') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<?xml version="1.0" encoding="UTF-8"  ?>
<#-- Created with genJasperreports_subreport1s(client) - A generator for JasperReports -->
<#-- hard code now but later use a include file to check for client entity  -->
<!DOCTYPE jasperReport PUBLIC "//JasperReports//DTD Report Design//EN" "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd">
 <#assign counter =0>
 <#assign cc =0>
 <#assign cnc =0>
 <#assign cf =0>
 <#assign wv =50>
 <#assign xv =-wv>
 <#assign yv =0>
 <#assign hv =0>
 <#assign entityFunction="">
 <#assign KeyA0Field="">
 <#assign KeyA1Field="">
 <#assign companyNameField="xxxxxxxxxxxxcompanyNameNotFound">
 <#assign OrdPriceField="xxxxxxxxxxxxOrdPriceNotFound">
 <#assign LineTotalField="xxxxxxxxxxxxLineTotalNotFound">
 <#assign schema="${default_schema}">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">
 <#assign owner2Field = "owner2" >

<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd"
		 name="${pojo.shortName}"
		 columnCount="1"
		 printOrder="Vertical"
		 orientation="Portrait"
		 pageWidth="535"
		 pageHeight="802"
		 columnWidth="535"
		 columnSpacing="0"
		 leftMargin="0"
		 rightMargin="0"
		 topMargin="0"
		 bottomMargin="0"
		 whenNoDataType="NoPages"
		 isTitleNewPage="false"
		 isSummaryNewPage="false"
           whenResourceMissingType="Key">
	<property name="ireport.scriptlethandling" value="0" />
	<property name="ireport.encoding" value="UTF-8" />
	<import value="java.util.*" />
	<import value="net.sf.jasperreports.engine.*" />
	<import value="net.sf.jasperreports.engine.data.*" />

	<parameter name="owner2Code" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Account Domain like raaspi.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["raaspi"]]></defaultValueExpression>
	</parameter>
	<parameter name="reqUrl" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Url like xxx.com:80]]></parameterDescription>
		<defaultValueExpression ><![CDATA["raaspi.com:80"]]></defaultValueExpression>
	</parameter>


<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
    </#foreach>
<#else>
     <#assign ids = pojo.identifierProperty.name>
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
     	<queryString><![CDATA[SELECT *
FROM

       ${schema}.${pojo.shortName?substring(eL)?lower_case} WHERE 
         (client.clientversion) =   '01' AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code}]]></queryString>
  
<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if componentProperty.name?upper_case?substring(1,2)=='1'>
     <#assign KeyA1Field=componentProperty.name?upper_case>
     <#if propertyType == "timestamp">
      <field name="${componentProperty.name?substring(pL)?upper_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType == "big_decimal">
      <field name="${componentProperty.name?substring(pL)?upper_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType == "big_integer">
      <field name="${componentProperty.name?substring(pL)?upper_case}" class="java.lang.Integer"/>
     <#elseif propertyType == "boolean">
      <field name="${componentProperty.name?substring(pL)?upper_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${componentProperty.name?substring(pL)?upper_case}" class="java.lang.String"/>
     </#if>
    <#else>
     <#assign KeyA0Field=componentProperty.name?upper_case>
    </#if>
   </#foreach>
  <#else>
   <#if property.name?substring(1,2)=='1'>
    <#assign KeyA1Field=property.name?upper_case>
   </#if>
   <#if property.name?upper_case?substring(5,7)=='ZC'>
    <#assign companyNameField=property.name?upper_case>
   <#elseif property.name?upper_case?substring(5,6)=='P'>
    <#assign OrdPriceField=property.name?upper_case>
   <#elseif property.name?upper_case?substring(5,6)=='L'>
    <#assign LineTotalField=property.name?upper_case>
   </#if>
   <#assign propertyType = property.value.typeName>
   <#if propertyType == "timestamp">
    <field name="${property.name?substring(pL)?upper_case}" class="java.sql.Timestamp"/>
   <#elseif propertyType == "big_decimal">
    <field name="${property.name?substring(pL)?upper_case}" class="java.math.BigDecimal"/>
   <#elseif propertyType == "big_integer">
    <field name="${property.name?substring(pL)?upper_case}" class="java.lang.Integer"/>
   <#elseif propertyType == "boolean">
    <field name="${property.name?substring(pL)?upper_case}" class="java.lang.Boolean"/>
   <#else>
    <field name="${property.name?substring(pL)?upper_case}" class="java.lang.String"/>
   </#if>
  </#if>
 </#if>
 <#if c2h.isManyToOne(property) >
  <#assign lastColumn= property.columnIterator.next().name>
    <field name="${lastColumn?upper_case}" class="java.lang.String"/>
    <#if found = 'N'>
     <#if ids?substring(6,7) == 'C' && lastcolumn?substring(6,8)=='RR'>
      <#assign TargetId_param_v = lastColumn?upper_case>
      <#assign found = 'Y'>
     <#elseif ids?substring(6,7) == 'V' && lastcolumn?substring(6,8)=='VV'>
      <#assign TargetId_param_v = lastColumn?upper_case>
      <#assign found = 'Y'>
     </#if>
    </#if>
 </#if>
</#if>
</#foreach>
<#-- hard code above and below for now, later add For loop and check for flags for subreport fields
-->

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
	<detail>
		<band height="90" splitType="Stretch">
			<image onErrorType="Blank">
				<reportElement x="0" y="0" width="100" height="60" uuid="06f6c569-69d0-4e06-a0a3-209f3c25dd32"/>
				<imageExpression><![CDATA[$P{reqUrl}+"/ImageServletCdi/?table=blobdata&seq=0&qlf=PIC&id=X3R-LOGO-C&width=60 "]]></imageExpression>
			</image>
			<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true">
				<reportElement key="textField" x="80" y="2" width="455" height="28" uuid="f2f35404-de5e-4362-9ecd-1abe39cf7669"/>
				<box leftPadding="2" rightPadding="2">
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="DejaVu Serif" size="20"/>
				</textElement>
				<textFieldExpression><![CDATA[$F{ENTERPRISECOMPANYNA}]]></textFieldExpression>
			</textField>
			<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true">
				<reportElement key="textField" x="80" y="30" width="535" height="15" uuid="98b28139-89b3-4ce4-83b2-59b5dcb4351d"/>
				<box leftPadding="2" rightPadding="2">
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="DejaVu Serif" size="12"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Tax}+" "+$R{Registration}+" "+$R{Number}+": "+$F{TAX1CODE}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="true">
				<reportElement key="textField" x="80" y="50" width="455" height="20" uuid="b88d8e68-b5c9-4102-b330-3983208fea57"/>
				<box leftPadding="2" rightPadding="2">
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font size="16"/>
				</textElement>
				<textFieldExpression><![CDATA[$F{ADDRL1}==null?"":$F{ADDRL1}+' '+$F{ADDRL2}==null?"":$F{ADDRL2}==null?"":$F{ADDRL2}+' '+$F{CITY}==null?"":$F{CITY}+' '+$F{PROVNSTATE}==null?"":$F{PROVNSTATE}+' '+$F{PZCODE}==null?"":$F{PZCODE}+' '+$F{PHONEO}==null?"":$F{PHONEO}+' '+$F{IMAILADDR}==null?"":$F{IMAILADDR}]]></textFieldExpression>
			</textField>
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





