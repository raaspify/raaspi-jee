<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,erS)?upper_case>
<#assign menuAttributesFunction = pojo.shortName?substring(efS,efE)>
<#if (menuAttributes?contains("O") && (menuAttributesFunction !="66" &&  menuAttributesFunction !="8c" ) ) >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<?xml version="1.0" encoding="UTF-8"  ?>
<#-- genJaspermaster_subreport0s.ftl - A generator for JasperReports details for master detail report -->
<#-- This shows details subreport0 assume entityname 1-4 contains O denoting details 
     since join is used, it seems we need to qualify fields by _ and use alias
     apr13 2019 txn details, line -1 means removed
 -->
<!DOCTYPE jasperReport PUBLIC "//JasperReports//DTD Report Design//EN" "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd">
 <#assign counter =0>
 <#assign counternc =0>
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
 <#assign KeyIds="keyfieldnotassigned">
 <#assign QtyOrdField="xxxxxxxxxxxxQtyOrdNotFound">
 <#assign OrdPriceField="xxxxxxxxxxxxOrdPriceNotFound">
 <#assign LineTotalField="xxxxxxxxxxxxLineTotalNotFound">
 <#assign found = 'N'>
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
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
	</parameter>




<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
    <#if (property.name?length >pL )>
     <#assign propertyType = property.value.typeName>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
     <#if found == 'N'>
      <#assign KeyA0Field = ids>
      <#assign found = 'Y'>
     </#if>
    </#if>
    </#foreach>
<#else>
     <#assign propertyType = pojo.identifierProperty.value.typeName>
     <#assign ids = pojo.identifierProperty.name>
      <#if (ids?length < 8) >
        /*
        ${ids}
        */
        <#assign ids="jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj">
      </#if>  

      <#assign KeyA0Field = ids>
</#if>
<#-- gen strategy ${pojo.identifierProperty.value.identifierGeneratorStrategy} -->
  <#-- for both keyautogen and non keyautogen we will use ids except SID id is integer value -->
<#if (ids?substring(pfS,pfS2)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
	<parameter name="INVOICEETC_ID" isForPrompting="false" class="java.lang.Integer">
		<parameterDescription><![CDATA[Key Value To Connect Master To Detail]]></parameterDescription>
		<defaultValueExpression ><![CDATA[$P{INVOICEETC_ID}]]></defaultValueExpression>
	</parameter>
<#else>
  <#assign keyAutoGen="N">
	<parameter name="INVOICEETC_ID" isForPrompting="false" class="java.lang.String">
		<parameterDescription><![CDATA[Key Value To Connect Master To Detail]]></parameterDescription>
		<defaultValueExpression ><![CDATA["$P{INVOICEETC_ID}"]]></defaultValueExpression>
	</parameter>

</#if>

<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign counterc =counterc+1>
   </#foreach>
  <#else>
   <#assign counternc =counternc+1>
  </#if>
 <#elseif c2h.isManyToOne(property)>
   <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
   <#assign parentName = util.lower(parentPojo.shortName)>
   <#if menuAttributesFunction =="2c">
    <#assign KeyIds="cuqno">
   <#elseif menuAttributesFunction =="2b">
    <#assign KeyIds="cuono">
   <#elseif menuAttributesFunction =="29">
    <#assign KeyIds="shipcode">
   <#elseif menuAttributesFunction =="2a">
    <#assign KeyIds="cuino">
   <#elseif menuAttributesFunction =="28">
    <#assign KeyIds="cupno">
   <#elseif menuAttributesFunction =="3e">
    <#assign KeyIds="vendqno">
   <#elseif menuAttributesFunction =="3d">
    <#assign KeyIds="vendono">
   <#elseif menuAttributesFunction =="3c">
    <#assign KeyIds="vendino">
   <#elseif menuAttributesFunction =="39">
    <#assign KeyIds="shipcode">
   <#elseif menuAttributesFunction =="3b">
    <#assign KeyIds="vendpno">
   <#elseif menuAttributesFunction =="3c">
    <#assign KeyIds="vendino">
   <#elseif menuAttributesFunction =="45">
    <#assign KeyIds="emplono">
   <#elseif menuAttributesFunction =="94">
    <#assign KeyIds="jobno">
   <#elseif menuAttributesFunction =="9b">
    <#assign KeyIds="jobassign">
   <#elseif menuAttributesFunction =="9c">
    <#assign KeyIds="pdetails">
   <#elseif menuAttributesFunction =="9f">
    <#assign KeyIds="pdetails">
   </#if>
 </#if>
</#if>
</#foreach>

<#-- if payment then details do not refer to item, instead refer to fields like amt in etc --> 
<#-- ${parentName} -->
   <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b" || menuAttributesFunction =="9f">
     	<queryString><![CDATA[SELECT ${schema}.${pojo.shortName?substring(eL)?lower_case}.* FROM
       ${schema}.${pojo.shortName?substring(eL)?lower_case}  WHERE ${pojo.shortName?substring(eL)?lower_case}.line > (-1) AND
       <#if propertyType== "java.lang.Integer">
        ${pojo.shortName?substring(eL)?lower_case}.${KeyIds} =   $P!{INVOICEETC_ID} AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code}  ]]></queryString>
       <#else>
         (${pojo.shortName?substring(eL)?lower_case}.${KeyIds}) =   ($P!{INVOICEETC_ID}) AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} ]]></queryString>
       </#if> 

   <#else>
     	<queryString><![CDATA[SELECT ${schema}.${pojo.shortName?substring(eL)?lower_case}.*,${schema}.${itemEntityName?substring(eL)}.matcode as ${itemEntityName?substring(eL)}_matcode  ,${schema}.${itemEntityName?substring(eL)}.descript as 
${itemEntityName?substring(eL)}_descript FROM
       ${schema}.${pojo.shortName?substring(eL)?lower_case} left join ${schema}.${itemEntityName?substring(eL)}  on 
        ${pojo.shortName?substring(eL)}.matcode=item.sid WHERE ${pojo.shortName?substring(eL)?lower_case}.line > (-1) AND
       <#if propertyType== "java.lang.Integer">
        ${pojo.shortName?substring(eL)?lower_case}.${KeyIds} =   $P!{INVOICEETC_ID} AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} AND item.owner2 = $P{owner2Code}]]></queryString>
       <#else>
         (${pojo.shortName?substring(eL)?lower_case}.${KeyIds}) =   ($P!{INVOICEETC_ID}) AND ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} AND item.owner2 = $P{owner2Code}]]></queryString>
       </#if> 
    </#if>

<#assign INVOICEETC_ID_param_v = ids>
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
<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if componentProperty.name?substring(1,2)=='1'>
     <#assign KeyA1Field=componentProperty.name>
     <#if propertyType == "timestamp">
      <field name="${componentProperty.name?substring(pL)}" class="java.sql.Timestamp"/>
     <#elseif propertyType == "big_decimal">
      <field name="${componentProperty.name?substring(pL)}" class="java.math.BigDecimal"/>
     <#elseif propertyType == "big_integer">
      <field name="${componentProperty.name?substring(pL)}" class="java.lang.Integer"/>
     <#elseif propertyType == "boolean">
      <field name="${componentProperty.name?substring(pL)}" class="java.lang.Boolean"/>
     <#else>
      <field name="${componentProperty.name?substring(pL)}" class="java.lang.String"/>
     </#if>
    <#elseif componentProperty.name?substring(6,7)=='i'>
     <#assign KeyA1Field=componentProperty.name>
      <field name="${componentProperty.name?substring(pL)}" class="java.lang.String"/>
    <#else>
    </#if>
   </#foreach>
  <#else>
   <#if property.name?substring(1,2)=='1'>
    <#assign KeyA1Field=property.name>
   </#if>
   <#if property.name?upper_case?substring(pfS,pfS2)=='Q' || property.name?upper_case?substring(pfS,pfS2)=='T'>
    <#if menuAttributesFunction =="29" || menuAttributesFunction =="39">
     <#assign QtyOrdField='z3xxeqxxbvnxxxxxxxxxqtyshipped'>
    <#else>
     <#assign QtyOrdField=property.name>
    </#if>
   <#elseif property.name?upper_case?substring(pfS,pfS2)=='P' || property.name?upper_case?substring(pfS,pfS2)=='Y'>
    <#assign OrdPriceField=property.name>
   <#elseif property.name?upper_case?substring(pfS,pfS2)=='L'>
    <#assign LineTotalField=property.name>
   </#if>
   <#if menuAttributesFunction =="9f">
    <#assign OrdPriceField='a4xxuuxxbv19xxxxxxxxname'>
    <#assign LineTotalField='a9xxtxsolxxxxxxxxxxxvalue'>
   </#if>

   <#assign propertyType = property.value.typeName>
   <#if propertyType == "timestamp">
    <field name="${property.name?substring(pL)}" class="java.sql.Timestamp"/>
   <#elseif propertyType == "big_decimal">
    <field name="${property.name?substring(pL)}" class="java.math.BigDecimal"/>
   <#elseif propertyType == "big_integer">
    <field name="${property.name?substring(pL)}" class="java.lang.Integer"/>
   <#elseif propertyType == "boolean">
    <field name="${property.name?substring(pL)}" class="java.lang.Boolean"/>
   <#else>
    <field name="${property.name?substring(pL)}" class="java.lang.String"/>
   </#if>
  </#if>
 </#if>
 <#if c2h.isManyToOne(property) >
    <#assign lastColumn= property.columnIterator.next().name>
    <#if lastColumn?upper_case?contains("MATCODE") >
     <#assign KeyA0Field="xxxxxxxxxxxxxxxxxxxx"+lastColumn>
    </#if>
    <field name="${lastColumn}" class="java.lang.String"/>
    <#if found = 'N'>
     <#if ids?substring(6,7) == 'C' && lastcolumn?substring(6,8)=='RR'>
      <#assign TargetId_param_v = lastColumn>
      <#assign found = 'Y'>
     <#elseif ids?substring(6,7) == 'V' && lastcolumn?substring(6,8)=='VV'>
      <#assign TargetId_param_v = lastColumn>
      <#assign found = 'Y'>
     </#if>
    </#if>
 </#if>
</#if>
</#foreach>
<#if menuAttributesFunction =="28" || menuAttributesFunction =="3b" || menuAttributesFunction =="9f">
<#else>
	<field name="item_matcode" class="java.lang.String"/>
	<field name="item_descript" class="java.lang.String"/>
</#if>


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
			      <textField isBlankWhenNull="true">
				 <reportElement x="0" y="1" width="107" height="16"/>
				 <textElement/>
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{${KeyA0Field?substring(pL)?lower_case?cap_first}}]]></textFieldExpression>
			      </textField>	
			      <textField isBlankWhenNull="true">
				 <reportElement x="120" y="1" width="107" height="16"/>
				 <textElement/>
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{${KeyA1Field?substring(pL)?lower_case?cap_first}}]]></textFieldExpression>
			      </textField>	
				<staticText>
					<reportElement
						x="214"
						y="1"
						width="107"
						height="16"
						forecolor="#FFFFFF"
						key="element-90"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
				<text><![CDATA[${QtyOrdField?substring(pL)}]]></text>
				</staticText>
			      <textField isBlankWhenNull="true">
				 <reportElement x="321" y="1" width="107" height="16" forecolor="#FFFFFF"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
                               <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b">
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{due}]]></textFieldExpression>
                               <#else>
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{${OrdPriceField?substring(pL)}}]]></textFieldExpression>
                               </#if>
			      </textField>	
			      <textField isBlankWhenNull="true">
				 <reportElement x="428" y="1" width="107" height="16" forecolor="#FFFFFF"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
                               <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b">
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{payment}]]></textFieldExpression>
                               <#else>
				 <textFieldExpression class="java.lang.String"><![CDATA[$R{${LineTotalField?substring(pL)}}]]></textFieldExpression>
                               </#if>
			      </textField>	
			</band>
		</columnHeader>
		<detail>
			<band height="140"  isSplitAllowed="true" >
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="128"
						y="1"
						width="107"
						height="15"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${KeyA1Field?substring(pL)}}]]></textFieldExpression>
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
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${QtyOrdField?substring(pL)}}]]></textFieldExpression>
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
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
                               <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b">
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${LineTotalField?substring(pL)}}]]></textFieldExpression>
                               <#else>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${OrdPriceField?substring(pL)}}]]></textFieldExpression>
                               </#if>
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
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
                               <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b">
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{amountin}]]></textFieldExpression>
                               <#else>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${LineTotalField?substring(pL)}}]]></textFieldExpression>
                               </#if>
				</textField>
                               <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b" || menuAttributesFunction =="9f">
                               <#else>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="1"
						y="1"
						width="127"
						height="15"
						key="textField-1"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${itemEntityName?substring(eL)}_matcode}.substring(0,$F{${itemEntityName?substring(eL)}_matcode}.length()>12?12:$F{${itemEntityName?substring(eL)}_matcode}.length())+".."+$F{${itemEntityName?substring(eL)}_matcode}.substring($F{${itemEntityName?substring(eL)}_matcode}.length()-4)]]></textFieldExpression>
				</textField>
                               </#if>
                     <#if menuAttributesFunction =="9f">
                     <#else>
                       <#if menuAttributesFunction =="28" || menuAttributesFunction =="3b">
			<staticText>
				<reportElement x="300" y="40" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[paidby]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="40" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{paytype}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="300" y="55" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[reference]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="55" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{paybyid}]]></textFieldExpression>
			</textField>
                       <#elseif menuAttributesFunction =="29" || menuAttributesFunction =="39">
			<staticText>
				<reportElement x="0" y="40" width="43" height="15"/>
				<textElement/>
				<text><![CDATA[Id]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="57" y="40" width="105" height="15"/>
				<textFieldExpression><![CDATA[$F{matcode}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="360" y="40" width="30" height="15"/>
				<textElement/>
				<text><![CDATA[via]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="265" y="40" width="81" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{type}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="172" y="40" width="83" height="15"/>
				<textElement/>
				<text><![CDATA[track#]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="402" y="40" width="121" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{barshipcod}]]></textFieldExpression>
			</textField>
                       <#elseif menuAttributesFunction =="94">
			<staticText>
				<reportElement x="300" y="40" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[type]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="40" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{type}]]></textFieldExpression>
			</textField>
                       <#elseif menuAttributesFunction =="9b">
			<staticText>
				<reportElement x="300" y="40" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[sequence]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="40" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{sequence}]]></textFieldExpression>
			</textField>
                       <#else>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="107"
						y="40"
						width="107"
						height="15"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" leftPadding="2" rightBorder="None" rightBorderColor="#000000" rightPadding="2" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font fontName="DejaVu Serif"  size="16"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{${itemEntityName?substring(eL)}_descript}]]></textFieldExpression>
				</textField>
			<staticText>
				<reportElement x="300" y="40" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[cost]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="40" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{baseamount}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="300" y="55" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[delivchrg]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="55" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{delivchrg}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="300" y="70" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[miscchrg]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="428" y="70" width="100" height="15"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{miscchrg}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="300" y="85" width="100" height="15"/>
				<textElement/>
				<text><![CDATA[taxamt]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement x="429" y="87" width="100" height="14"/>
				<textElement/>
				<textFieldExpression><![CDATA[new Double(Double.parseDouble($F{tax1amt}) + Double.parseDouble($F{tax2amt})+ Double.parseDouble($F{tax3amt}))

]]></textFieldExpression>
			</textField>
                       </#if>
                      </#if>
			<line>
				<reportElement key="line" positionType="FixRelativeToBottom" x="0" y="100" width="535" height="1" forecolor="#808080"/>
				<graphicElement>
					<pen lineWidth="0.5" lineStyle="Solid"/>
				</graphicElement>
			</line>
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





