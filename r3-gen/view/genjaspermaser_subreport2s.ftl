<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
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
 <#assign keyKField="xxxxxxxxxxxxxxxxxxxxKeyKNotFound">
 <#assign descriptionField="xxxxxxxxxxxxxxxxxxxxdescriptionNotFound">
 <#assign firstNameField="xxxxxxxxxxxxxxxxxxxxFirstNameNotFound">
 <#assign lastNameField="xxxxxxxxxxxxxxxxxxxxLastNameNotFound">
 <#assign titleField="xxxxxxxxxxxxxxxxxxxxtitleNotFound">
 <#assign jobTitleField="xxxxxxxxxxxxxxxxxxxxjobtitleNotFound">
 <#assign schema="${default_schema}">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">
 <#assign owner2Field = "owner2" >
 <#assign customerascompanynameField = "customerascompanynot assigned" >
 <#assign address_addrl1s = "address_addrl1s" >
 <#assign address_citys = "address_citys" >
 <#assign address_provnstates = "address_provnstates" >
 <#assign address_pzcodes = "address_pzcodes" >


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
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["raaspi"]]></defaultValueExpression>
	</parameter>


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
     	<queryString><![CDATA[SELECT ${schema}.${pojo.shortName?substring(eL)?lower_case}.*,${addressEntityName?substring(eL)}.addrl1 as ${addressEntityName?substring(eL)}_addrl1s  ,${addressEntityName?substring(eL)}.city as 
${addressEntityName?substring(eL)}_citys ,${addressEntityName?substring(eL)}.provnstate as 
${addressEntityName?substring(eL)}_provnstates,${addressEntityName?substring(eL)}.pzcode as 
${addressEntityName?substring(eL)}_pzcodes FROM
       ${schema}.${pojo.shortName?substring(eL)?lower_case} left join ${schema}.${addressEntityName?substring(eL)}  on 
        ${pojo.shortName?substring(eL)}.mailtocode=${addressEntityName?substring(eL)}.sid WHERE 
       <#if propertyType== "java.lang.Integer">
        ${pojo.shortName?substring(eL)}.${KeyA0Field?substring(pL)} =   $P!{ForTargetId} AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code}]]></queryString>
       <#else>
         (${KeyA0Field?substring(pL)}) =   ($P!{ForTargetId}) AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code}]]></queryString>
       </#if> 

 
<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if componentProperty.name?upper_case?substring(5,6)=='K'>
     <#assign keyKField=componentProperty.name?upper_case>
    </#if>
    <field name="${componentProperty.name?substring(pL)?upper_case}" class="java.lang.String"/>
   </#foreach>
  <#else>

   <#if property.name?upper_case?substring(5,6)=='K'>
    <#assign keyKField=property.name?upper_case>
   <#elseif property.name?upper_case?substring(5,7)=='ZS'>
    <#assign descriptionField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("TITLE")>
    <#assign titleField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("JOBTITLE")>
    <#assign jobTitleField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("LASTNAME")>
    <#assign lastNameField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("FIRSTNAME")>
    <#assign firstNameField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("CUSTOMERASCOMPANYNAME")>
    <#assign customerascompanynameField=property.name?upper_case>
   <#elseif property.name?upper_case?contains("VENDORASCOMPANYNAME")>
    <#assign customerascompanynameField=property.name?upper_case>
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
     <#if ids?substring(pefS,pefS2) == 'C' && lastcolumn?substring(pefS,pefE)=='RR'>
      <#assign ForTargetId_param_v = lastColumn?upper_case>
      <#assign found = 'Y'>
     <#elseif ids?substring(pefS,pefS2) == 'V' && lastcolumn?substring(pefS,pefE)=='VV'>
      <#assign ForTargetId_param_v = lastColumn?upper_case>
      <#assign found = 'Y'>
     </#if>
    </#if>
 </#if>
</#if>
</#foreach>
	<field name="address_addrl1s" class="java.lang.String"/>
	<field name="address_citys" class="java.lang.String"/>
	<field name="address_provnstates" class="java.lang.String"/>
	<field name="address_pzcodes" class="java.lang.String"/>
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
			<band height="30"  isSplitAllowed="true" >
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
			      <textField isBlankWhenNull="true">
				 <reportElement x="0" y="1" width="107" height="16"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>	
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{${keyKField?lower_case?substring(pL)?cap_first}}]]></textFieldExpression>
			      </textField>	
			</band>
		</columnHeader>
	<detail>
		<band height="70" splitType="Stretch">
			<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true">
				<reportElement key="textField" x="0" y="1" width="530" height="15"/>
				<box leftPadding="2" rightPadding="2">
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="DejaVu Serif" size="16" />
				</textElement>
                                <#if menuAttributes?substring(efS,efE) == '40'>
				 <textFieldExpression><![CDATA[$F{${keyKField?substring(pL)}}.substring(0,$F{${keyKField?substring(pL)}}.length()>12?12:$F{${keyKField?substring(pL)}}.length())+".."+$F{${keyKField?substring(pL)}}.substring($F{${keyKField?substring(pL)}}.length()-4)+" "+($F{${firstNameField?substring(pL)}}==null?"":$F{${firstNameField?substring(pL)}})+' '+($F{${lastNameField?substring(pL)}}==null?"":$F{${lastNameField?substring(pL)}})]]></textFieldExpression>
                                <#else>
				 <textFieldExpression><![CDATA[$F{${keyKField?substring(pL)}}.substring(0,$F{${keyKField?substring(pL)}}.length()>12?12:$F{${keyKField?substring(pL)}}.length())+".."+$F{${keyKField?substring(pL)}}.substring($F{${keyKField?substring(pL)}}.length()-4)+" "+($F{${customerascompanynameField?substring(pL)}}==null?"":$F{${customerascompanynameField?substring(pL)}})+' '+($F{${firstNameField?substring(pL)}}==null?"":$F{${firstNameField?substring(pL)}})+' '+($F{${lastNameField?substring(pL)}}==null?"":$F{${lastNameField?substring(pL)}})]]></textFieldExpression>
                                </#if>
			</textField>
			<line>
				<reportElement key="line" positionType="FixRelativeToBottom" x="0" y="17" width="535" height="1" forecolor="#808080"/>
				<graphicElement>
					<pen lineWidth="0.5" lineStyle="Solid"/>
				</graphicElement>
			</line>
			<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true">
				<reportElement key="textField" x="0" y="18" width="530" height="15"/>
				<box leftPadding="2" rightPadding="2">
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="DejaVu Serif" size="16" />
				</textElement>
				<textFieldExpression><![CDATA[($F{${address_addrl1s}}==null?"":$F{${address_addrl1s}})+' '+($F{${address_citys}}==null?"":$F{${address_citys}})+' '+($F{${address_provnstates}}==null?"":$F{${address_provnstates}})+' '+($F{${address_pzcodes}}==null?"":$F{${address_pzcodes}})]]></textFieldExpression>
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




