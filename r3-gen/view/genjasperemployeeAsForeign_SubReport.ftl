<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >

<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#if ((menuAttributes?substring(efS,efE) == '20' || menuAttributes?substring(efS,efE) == '30'  || menuAttributes?substring(efS,efE) == '40' ))  >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<?xml version="1.0" encoding="UTF-8"  ?>
<#-- Created with genJasperreports - A generator for JasperReports -->
<#-- 7th digit =2 means customer entity  3 means vendor  -->
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
 <#assign KeyA0Field="mainkeynotassigned">
 <#assign KeyA1Field="linekeynotassigned">
 <#assign keyKField="xxxxxxxxxxxxKeyKNotFound">
 <#assign descriptionField="xxxxxxxxxxxxdescriptionNotFound">
 <#assign lastNameField="xxxxxxxxxxxxLastNameNotFound">
 <#assign titleField="xxxxxxxxxxxxtitleNotFound">
 <#assign jobTitleField="xxxxxxxxxxxxjobtitleNotFound">
 <#assign schema="${default_schema}">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">

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
		 resourceBundle="messages">
	<property name="ireport.scriptlethandling" value="0" />
	<property name="ireport.encoding" value="UTF-8" />
	<import value="java.util.*" />
	<import value="net.sf.jasperreports.engine.*" />
	<import value="net.sf.jasperreports.engine.data.*" />

<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
     <#assign propertyType = property.value.typeName>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
     <#if found == 'N'>
      <#assign KeyA0Field = ids?upper_case>
      <#assign found = 'Y'>
     </#if>
    </#foreach>
<#else>
     <#assign propertyType = pojo.identifierProperty.value.typeName>
     <#assign ids = pojo.identifierProperty.name>
     <#assign KeyA0Field = ids?upper_case>
</#if>
<#-- gen strategy ${pojo.identifierProperty.value.identifierGeneratorStrategy} -->
  <#-- for both keyautogen and non keyautogen we will use ids except SID id is integer value -->
<#if (ids?substring(5,6)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
	<parameter name="ForTargetId" isForPrompting="false" class="java.lang.Integer">
	<defaultValueExpression ><![CDATA[$P{ForTargetId}]]></defaultValueExpression>
	</parameter>
<#else>
  <#assign keyAutoGen="N">
	<parameter name="ForTargetId" isForPrompting="false" class="java.lang.String">
	<defaultValueExpression ><![CDATA["$P{ForTargetId}"]]></defaultValueExpression>
	</parameter>
</#if>


<#assign ForTargetId_param_v = ids?upper_case>
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
     	<queryString><![CDATA[SELECT *
FROM
       ${schema}.${pojo.shortName?substring(8)?lower_case} WHERE 
       <#if propertyType== "java.lang.Integer">
        ${KeyA0Field?substring(12)} =   $P!{ForTargetId}]]></queryString>
       <#else>
         (${KeyA0Field?substring(12)}) =   ($P!{ForTargetId})]]></queryString>
       </#if> 

 
<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if componentProperty.name?upper_case?substring(5,6)=='K'>
     <#assign keyKField=componentProperty.name?upper_case>
    </#if>
    <field name="${componentProperty.name?substring(12)?upper_case}" class="java.lang.String"/>
   </#foreach>
  <#else>
   <#if property.name?upper_case?substring(5,6)=='K'>
    <#assign keyKField=property.name?upper_case>
   <#elseif property.name?upper_case?substring(5,7)=='ZS'>
    <#assign descriptionField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("1TITLE")>
    <#assign titleField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("JOBTITLE")>
    <#assign jobTitleField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("LASTNAME")>
    <#assign lastNameField=property.name?upper_case>
   </#if>
   <#assign propertyType = property.value.typeName>
   <#if propertyType == "timestamp">
    <field name="${property.name?substring(12)?upper_case}" class="java.sql.Timestamp"/>
   <#elseif propertyType == "big_decimal">
    <field name="${property.name?substring(12)?upper_case}" class="java.math.BigDecimal"/>
   <#elseif propertyType == "big_integer">
    <field name="${property.name?substring(12)?upper_case}" class="java.lang.Integer"/>
   <#elseif propertyType == "boolean">
    <field name="${property.name?substring(12)?upper_case}" class="java.lang.Boolean"/>
   <#else>
    <field name="${property.name?substring(12)?upper_case}" class="java.lang.String"/>
   </#if>
  </#if>
 </#if>
 <#if c2h.isManyToOne(property) >
  <#assign lastColumn= property.columnIterator.next().name>
    <field name="${lastColumn?upper_case}" class="java.lang.String"/>
    <#if found = 'N'>
     <#if ids?substring(pefS,pefS2) == 'C' && lastcolumn?substring(pefS,pefE)=='RR'>
      <#assign ForTargetId_param_v = lastColumn?upper_case>
      <#assign found = 'Y'>
     <#elseif ids?substring(pefS,pefS2) == 'V' && lastcolumn?substring(pefS,pefE)=='VV'>
      <#assign ForTargetId_param_v = lastColumn?upper_case>
      <#assign found = 'Y'>
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
		<columnHeader>
			<band height="20"  isSplitAllowed="true" >
				<rectangle radius="0" >
					<reportElement
						mode="Opaque"
						x="1"
						y="1"
						width="534"
						height="17"
						forecolor="#000000"
						backcolor="#999999"
						key="element-22"/>
					<graphicElement stretchType="NoStretch" pen="Thin"/>
				</rectangle>
			      <textField>
				 <reportElement x="0" y="1" width="107" height="16"/>
					<textElement>
						<font fontName="SansSerif" size="12"/>
					</textElement>	
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{${keyKField?lower_case?substring(12)?cap_first}}]]></textFieldExpression>
			      </textField>	
			</band>
		</columnHeader>
		<detail>
			<band height="19"  isSplitAllowed="true" >
				<line direction="TopDown">
					<reportElement
						x="0"
						y="17"
						width="535"
						height="0"
						forecolor="#808080"
						key="line"
						positionType="FixRelativeToBottom"/>
					<graphicElement stretchType="NoStretch" pen="Thin"/>
				</line>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="107"
						y="1"
						width="107"
						height="15"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="SansSerif" size="12"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${keyKField?substring(12)}}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="214"
						y="1"
						width="107"
						height="15"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="SansSerif" size="12"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${descriptionField?substring(12)}}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="321"
						y="1"
						width="107"
						height="15"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="SansSerif" size="12"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${titleField?substring(12)}}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="428"
						y="1"
						width="107"
						height="15"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="SansSerif" size="12"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${lastNameField?substring(12)}}]]></textFieldExpression>
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





