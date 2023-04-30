<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<?xml version="1.0" encoding="UTF-8"  ?>
<!-- Created with genJasperreports - A generator for JasperReports -->
<!DOCTYPE jasperReport PUBLIC "//JasperReports//DTD Report Design//EN" "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd">
 <#assign counterc =0>
 <#assign counternc =0>
 <#assign cc =0>
 <#assign cnc =0>
 <#assign wv =50>
 <#assign xv =-wv>
 <#assign yv =0>
 <#assign hv =0>
 <#assign entityColumnValidate="N">
 <#assign propertyns="">
 <#assign useDateKey="">
 <#assign firstTime="Y"> 
 <#assign schema="${default_schema}">
 <#assign keyField = "" >
 <#assign keyAutoGen="Y">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">
 


<#if (entityColumnValidate?lower_case != "Y") >

<jasperReport
		 name="${pojo.shortName}"
		 columnCount="1"
		 printOrder="Vertical"
		 orientation="Landscape"
		 pageWidth="1200"
		 pageHeight="595"
		 columnWidth="1140"
		 columnSpacing="0"
		 leftMargin="30"
		 rightMargin="30"
		 topMargin="20"
		 bottomMargin="20"
		 whenNoDataType="NoPages"
		 isTitleNewPage="false"
		 isSummaryNewPage="false"
		 resourceBundle="messages">
	<property name="ireport.scriptlethandling" value="0" />
	<property name="ireport.encoding" value="UTF-8" />
	<import value="java.util.*" />
	<import value="net.sf.jasperreports.engine.*" />
	<import value="net.sf.jasperreports.engine.data.*" />


	<parameter name="DisplayAs" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Report Output as HTML or as PDF]]></parameterDescription>
		<defaultValueExpression ><![CDATA["PDF"]]></defaultValueExpression>
	</parameter>
	<parameter name="MarkedOnes" isForPrompting="true" class="java.lang.Boolean">
 		<parameterDescription><![CDATA[Select Marked Records Only]]></parameterDescription>
      </parameter>
	<parameter name="subreportPath" isForPrompting="false" class="java.lang.String">
		<parameterDescription><![CDATA[SubReport class absolute path]]></parameterDescription>
		<defaultValueExpression ><![CDATA["."]]></defaultValueExpression>
	</parameter>


<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
     <#if firstTime=="Y">
      <#assign ids1 = ids>
      <#assign firstTime="N"> 
     </#if>
      <#--
      since for components the property name is id and not prefixed column name, we use getGetterSignature to
      get the prefixed column name as in reveng.xml
      ids = pojo.getGetterSignature(property)?substring(3) >>> ${ids}

      This is not used now ???<----------------------------

      -->
  
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
<#if (ids?substring(5,6)=="o")  || (pojo.identifierProperty.value.identifierGeneratorStrategy == "identity") >
  <#assign keyAutoGen="Y">
<#else>
  <#assign keyAutoGen="N">
</#if>


<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign counterc =counterc+1>
   </#foreach>
  <#else>
   <#assign counternc =counternc+1>
    <#if property.name?substring(5,6)=="k" || property.name?substring(5,6)=="n" || property.name?substring(5,6)=="j" >
      <#assign keyField=property.name>
    </#if>
  </#if>
  <#if keyAutoGen=="Y" && keyField == "" >
	<parameter name="Start" isForPrompting="true" class="java.lang.Integer">
		<parameterDescription><![CDATA[Start Record Key value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA[0]]></defaultValueExpression>
	</parameter>
	<parameter name="End" isForPrompting="true" class="java.lang.Integer">
		<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA[999999]]></defaultValueExpression>
	</parameter>
  <#else>
	<parameter name="Start" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Start Record Key value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA["      "]]></defaultValueExpression>
	</parameter>
	<parameter name="End" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
		<defaultValueExpression ><![CDATA["      "]]></defaultValueExpression>
	</parameter>
  </#if>

 </#if>
 <#if isToOne(property)>
  <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
  <#if parentPojo.isComponent(parentPojo.identifierProperty)>
  <#else>

	<parameter name="'ForTargetId'+parentPojo.shortName" class="java.lang.Integer" isForPrompting="false">
		<parameterDescription><![CDATA[Key Value To Connect Master To Customer,Vendor etc]]></parameterDescription>
		<defaultValueExpression><![CDATA[9999]]></defaultValueExpression>
	</parameter>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName="Jxxxuq20customer">


  </#if>
 </#if> 

</#foreach>


     	<queryString><![CDATA[SELECT
<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
     <#assign cc =cc+1>
     <#if (cc < counterc)>
       ${pojo.shortName?substring(10)?lower_case}.${componentProperty.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case},
     <#else>
       ${pojo.shortName?substring(10)?lower_case}.${componentProperty.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case},
     </#if>
     <#if componentProperty.name?substring(5,7)=="ss">
      <#assign useDateKey="Y">
     </#if>
   </#foreach>
  <#else>
     <#assign cnc =cnc+1>
     <#if (cnc < counternc)>
       ${pojo.shortName?substring(10)?lower_case}.${property.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case},
     <#else>
       ${pojo.shortName?substring(10)?lower_case}.${property.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}
     </#if>
    <#if property.name?substring(5,7)=="ee">
      <#assign useDateKey="Y">
    </#if>

  </#if>
 </#if>
</#foreach>
FROM
       ${schema}.${pojo.shortName?substring(10)?lower_case} ${pojo.shortName?substring(10)?lower_case} WHERE 
       <#if useDateKey = "Y">
        <#if keyAutoGen=="Y" >
         ${pojo.shortName?substring(10)?lower_case}.${keyField?substring(12)?lower_case} >=  $P{Start} AND   ${pojo.shortName?substring(10)?lower_case}.${keyField?substring(12)?lower_case} <= $P{End}]]></queryString>
        <#else>
         ${pojo.shortName?substring(10)?upper_case}.${keyField?substring(12)?upper_case} >=  $P{Start} AND   ${pojo.shortName?substring(10)?upper_case}.${keyField?substring(12)?upper_case} <= $P{End}]]></queryString>
        </#if>
       <#else>
        ${pojo.shortName?substring(10)?lower_case}.${ids?substring(12)?lower_case} >=  $P{Start} AND   ${pojo.shortName?substring(10)?lower_case}.${ids?substring(12)?lower_case} <= $P{End}]]></queryString>
       </#if>
   
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
    <#foreach componentProperty in property.value.propertyIterator>
     <#assign propertyType = componentProperty.value.typeName>
     <#if propertyType == "timestamp">
      <field name="${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType == "big_decimal">
      <field name="${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType == "big_integer">
      <field name="${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType == "boolean">
      <field name="${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case}" class="java.lang.String"/>
     </#if>
    </#foreach>
  <#else>
     <#assign propertyType = property.value.typeName>
     <#if propertyType == "timestamp">
      <field name="${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}" class="java.sql.Timestamp"/>
     <#elseif propertyType == "big_decimal">
      <field name="${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}" class="java.math.BigDecimal"/>
     <#elseif propertyType == "big_integer">
      <field name="${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}" class="java.lang.Integer"/>
     <#elseif propertyType == "boolean">
      <field name="${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}" class="java.lang.Boolean"/>
     <#else>
      <field name="${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}" class="java.lang.String"/>
     </#if>
  </#if>
 </#if>
</#if>
</#foreach>
		<background>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</background>
		<title>
			<band height="50"  isSplitAllowed="true" >
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="0"
						y="48"
						width="1140"
						height="2"
						forecolor="#808080"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="0"
						y="3"
						width="1140"
						height="6"
						forecolor="#808080"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>

				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="120"
						y="19"
						width="234"
						height="22"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{${pojo.shortName?substring(10)?cap_first}}+" Report"]]></textFieldExpression>
				</textField>
			</band>
		</title>
		<pageHeader>
			<band height="36"  isSplitAllowed="true" >
				<line direction="BottomUp">
					<reportElement
						mode="Opaque"
						x="0"
						y="8"
						width="1200"
						height="0"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
     <#foreach componentProperty in property.value.propertyIterator>
      <#if  ((componentProperty.name?length > 9) && (componentProperty.name?substring(9,10) == "v")) >

				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="LocalPage"  hyperlinkTarget="Self" >
					<reportElement
      <#assign xv =xv+wv>
						x="${xv}"
						y="8"
						width="${wv}"
						height="16"
						forecolor="#000000"
						backcolor="#6666FF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement isStyledText="true">
						<font fontName="SansSerif" size="16" isBold="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{${componentProperty.name?substring(12)?cap_first}}]]></textFieldExpression>
				</textField>
      </#if>

     </#foreach>
  <#else>
   <#if  ((property.name?length > 9) && (property.name?substring(9,10) == "v")) >
    <#if xv < 800>
     <#if property.name != "statusfl" && property.name != "statusfldt" && property.name !="notes" && property.name != "owner" && property.name  != "owner">
      <#if property.name != "title" && property.name!="jobtitle">  

				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="LocalPage"  hyperlinkTarget="Self" >
					<reportElement
       <#assign xv =xv+wv>
						x="${xv}"
						y="8"
						width="${wv}"
						height="16"
						forecolor="#000000"
						backcolor="#6666FF"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement isStyledText="true">
						<font fontName="SansSerif" size="16" isBold="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{${property.name?substring(12)?cap_first}}]]></textFieldExpression>
				</textField>
      </#if>
     </#if>
    </#if>
   </#if>
  </#if>
 </#if>
</#if>
</#foreach>

			</band>
		</pageHeader>
		<columnHeader>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</columnHeader>
		<detail>
			<band height="35"  isSplitAllowed="true" >
 <#assign xv =-wv>

<#foreach property in pojo.allPropertiesIterator>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#if  ((componentProperty.name?length > 9) && (componentProperty.name?substring(9,10) == "v")) >
    <#assign propertyType = componentProperty.value.typeName>
    <#if propertyType == "timestamp">
     <#assign clss = "java.sql.Timestamp">
     <#elseif propertyType == "big_decimal">
      <#assign clss = "java.math.BigDecimal">
     <#elseif propertyType == "integer">
      <#assign clss = "java.lang.Integer">
     <#elseif propertyType == "Date">
      <#assign clss = "java.sql.Date">
     <#elseif propertyType == "Boolean">
      <#assign clss = "java.lang.Boolean">
     <#else>
      <#assign clss = "java.lang.String">
    </#if>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
    <#assign xv =xv+wv>
						x="${xv}"
						y="12"
						width="${wv}"
						height="23"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font/>
					</textElement>
				<textFieldExpression   class="${clss}"><![CDATA[$F{${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case}}]]></textFieldExpression>
				</textField>
    </#if>
   </#foreach>
  <#else>
   <#if  ((property.name?length > 9) && (property.name?substring(9,10) == "v")) >
   <#if xv < (800)>
    <#if property.name != "statusfl" && property.name != "statusfldt" && property.name !="notes" && property.name != "owner" && property.name  != "owner">
     <#if property.name != "title" && property.name!="jobtitle">  
      <#assign propertyType = property.value.typeName>
      <#if propertyType == "timestamp">
       <#assign clss = "java.sql.Timestamp">
      <#elseif propertyType == "big_decimal">
       <#assign clss = "java.math.BigDecimal">
      <#elseif propertyType == "integer">
       <#assign clss = "java.lang.Integer">
      <#elseif propertyType == "Date">
       <#assign clss = "java.sql.Date">
      <#elseif propertyType == "Boolean">
       <#assign clss = "java.lang.Boolean">
      <#else>
       <#assign clss = "java.lang.String">
      </#if>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
      <#assign xv =xv+wv>
						x="${xv}"
						y="12"
						width="${wv}"
						height="23"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font/>
					</textElement>
				<textFieldExpression   class="${clss}"><![CDATA[$F{${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}}]]></textFieldExpression>
				</textField>
      </#if>
     </#if>
    </#if>
   </#if>
  </#if>
 </#if>
</#if>
</#foreach>

			</band>

		</detail>
		<columnFooter>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</columnFooter>
		<pageFooter>
			<band height="27"  isSplitAllowed="true" >

				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
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
						<font fontName="SansSerif" size="16"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA["Page " + $V{PAGE_NUMBER} + " of "]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Report" hyperlinkType="None"  hyperlinkTarget="Self" >
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
						<font fontName="SansSerif" size="16"/>
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
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
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
						<font fontName="SansSerif" size="16"/>
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









<#--jay5 below is master-->
<#assign tobegeneratedCandidate = "N">  
<#assign menuAttributes = pojo.shortName?substring(0,4)?upper_case>
<#if (menuAttributes?contains("T")  && menuAttributes?contains("E") ) >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<?xml version="1.0" encoding="UTF-8"  ?>
<#-- Created with genJasperreports - A generator for JasperReports -->
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
 <#assign INVOICEETC_ID_param_v = "xxxxxxxxxxxxnot defined initial">
 <#assign TargetId_param_v="xxxxxxxxxxxxnot defined initial">
 <#-- the above 2 paramaters value will be integer jay look into passing as string but use string to integer value if Autogen key otherwise String  --> 
 <#assign subReport0PojoName="Not Assigned Yet">
 <#assign subReport1PojoName="Yxxxuq52client">
 <#assign subReport2PojoName="Jxxxuq20customer">
 <#assign entityName = pojo.shortName> 
 <#assign componentName = util.lower(entityName)>
 <#assign entityName = pojo.shortName>
 <#assign componentName = util.lower(entityName)>
 <#assign schema="${default_schema}">
 <#assign forceUpperCase="N">
 <#assign dbType="postgre">

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
		 resourceBundle="messages">
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

<#if pojo.isComponent(pojo.identifierProperty)>
    <#foreach property in pojo.identifierProperty.value.propertyIterator>
     <#assign ids = pojo.getGetterSignature(property)?substring(3)>
      <#break>
    </#foreach>
<#else>
     <#assign ids = pojo.identifierProperty.name>
</#if>
<#-- gen strategy ${pojo.identifierProperty.value.identifierGeneratorStrategy} -->
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
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign cc =cc+1>
    <#if (cc+cnc+cf < counter)>
      ${pojo.shortName?substring(10)?lower_case}.${componentProperty.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${componentProperty.name?substring(12)?lower_case},
    <#else>
      ${pojo.shortName?substring(10)?lower_case}.${componentProperty.name?substring(12)?lower_case} AS ${pojo.shortName?substring(12)?lower_case}_${componentProperty.name?substring(12)?lower_case}
    </#if>
    <#if keyAutoGen=="Y" && (componentProperty.name?substring(5,6)=="k" || componentProperty.name?substring(5,6)=="n")>
      <#assign ids = componentProperty.name>
    </#if>
   </#foreach>
  <#else>
   <#assign cnc =cnc+1>
   <#if (cc+cnc+cf < counter)>
      ${pojo.shortName?substring(10)?lower_case}.${property.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?upper_case}_${property.name?substring(12)?lower_case},
   <#else>
      ${pojo.shortName?substring(10)?lower_case}.${property.name?substring(12)?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${property.name?substring(12)?lower_case}
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
      ${pojo.shortName?substring(10)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${lastColumn?upper_case},
   <#else>
      ${pojo.shortName?substring(10)?lower_case}.${lastColumn?lower_case} AS ${pojo.shortName?substring(10)?lower_case}_${lastColumn?upper_case}
   </#if>
 </#if>
</#if>
</#foreach>
FROM
       ${schema}.${pojo.shortName?substring(10)?lower_case} ${pojo.shortName?substring(10)?lower_case} WHERE 
         (${pojo.shortName?substring(10)?lower_case}.${ids?substring(12)?lower_case}) >=  $P{Start} AND   (${pojo.shortName?substring(10)?lower_case}.${ids?substring(12)?lower_case}) <= $P{End}]]></queryString>
<#if ids?substring(6,8) == 'ci' >
 <#assign subReport0PojoName="Xoxxuq24cuidetails">
<#elseif ids?substring(6,8) == 'co' >
 <#assign subReport0PojoName="Xoxxuq24cuodetails">
<#elseif ids?substring(6,8) == 'cp' >
 <#assign subReport0PojoName="Xoxxuq24cupdetails">
<#elseif ids?substring(6,8) == 'cq' >
 <#assign subReport0PojoName="Xoxxuq24cuqdetails">
<#elseif ids?substring(6,8) == 'vi' >
 <#assign subReport0PojoName="Xoxxuq34vendidetails">
<#elseif ids?substring(6,8) == 'vo' >
 <#assign subReport0PojoName="Xoxxuq34vendodetails">
<#elseif ids?substring(6,8) == 'vp' >
 <#assign subReport0PojoName="Xoxxuq34vendpdetails">
<#elseif ids?substring(6,8) == 'vq' >
 <#assign subReport0PojoName="Xoxxuq34vendqdetails">
<#elseif ids?substring(6,8) == 'sh' >
 <#assign subReport0PojoName="Xoxxuq25shipmentdetails">
<#elseif ids?substring(6,8) == 'sv' >
 <#assign subReport0PojoName="Xoxxuq39vshipmendetails">
</#if>


<#assign found = 'N'>
<#foreach property in pojo.allPropertiesIterator>
<#if (property.name?length >pL )>
 <#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
  <#if c2j.isComponent(property)> 
   <#foreach componentProperty in property.value.propertyIterator>
    <#assign propertyType = componentProperty.value.typeName>
    <#if propertyType == "timestamp">
       <field name="${pojo.shortName?substring(10)?upper_case}_${componentProperty.name?substring(12)?upper_case}" class="java.sql.Timestamp"/>
    <#elseif propertyType == "big_decimal">
       <field name="${pojo.shortName?substring(10)?upper_case}_${componentProperty.name?substring(12)?upper_case}" class="java.math.BigDecimal"/>
    <#elseif propertyType == "big_integer" || propertyType ==  "java.lang.Integer">       <field name="${pojo.shortName?substring(10)?upper_case}_${componentProperty.name?substring(12)?upper_case}" class="java.lang.Integer"/>
    <#elseif propertyType == "boolean">
       <field name="${pojo.shortName?substring(10)?upper_case}_${componentProperty.name?substring(12)?upper_case}" class="java.lang.Boolean"/>
    <#else>
       <field name="${pojo.shortName?substring(10)?upper_case}_${componentProperty.name?substring(12)?upper_case}" class="java.lang.String"/>
    </#if>
   </#foreach>
  <#else>
   <#assign propertyType = property.value.typeName>
   <#if propertyType == "timestamp">
      <field name="${pojo.shortName?substring(10)?upper_case}_${property.name?substring(12)?upper_case}" class="java.sql.Timestamp"/>
   <#elseif propertyType == "big_decimal">
      <field name="${pojo.shortName?substring(10)?upper_case}_${property.name?substring(12)?upper_case}" class="java.math.BigDecimal"/>
   <#elseif propertyType == "big_integer" || propertyType ==  "java.lang.Integer">
      <field name="${pojo.shortName?substring(10)?upper_case}_${property.name?substring(12)?upper_case}" class="java.lang.Integer"/>
   <#elseif propertyType == "boolean">
      <field name="${pojo.shortName?substring(10)?upper_case}_${property.name?substring(12)?upper_case}" class="java.lang.Boolean"/>
   <#else>
      <field name="${pojo.shortName?substring(10)?upper_case}_${property.name?substring(12)?upper_case}" class="java.lang.String"/>
   </#if>
  </#if>
 </#if>
 <#if c2h.isManyToOne(property) >
  <#assign lastColumn= property.columnIterator.next().name>
    <#if keyAutoGen=="Y">
      <field name="${pojo.shortName?substring(10)?upper_case}_${lastColumn?upper_case}" class="java.lang.Integer"/>
    <#else>
      <field name="${pojo.shortName?substring(10)?upper_case}_${lastColumn?upper_case}" class="java.lang.String"/>
    </#if>
    <#if found = 'N'>
     <#assign columnName ="NOt Assigned yet   xxxxxx  ">
     <#assign lastOfKeys= property.columnIterator.next().name>
     <#assign columnNameKey= componentName+lastOfKeys?lower_case?cap_first+"One">


     <#if columnNameKey == "trexuq37vshipmenMatcodeOne">
       <#assign columnName ="d1xxuxxrbvxxmatcode">
     <#elseif columnNameKey == "trexuq37vshipmenVendorOne">
       <#assign columnName ="d2xxudvvbvxxvendor">
     <#elseif columnNameKey == "trexuq37vshipmenShipcodeOne">
       <#assign columnName ="d5xxuhbrbvxxshiptocode">
     <#elseif columnNameKey == "trexuq37vshipmenMailtocodeOne">
       <#assign columnName ="d4xxugbrbvxxmailtocode">
     </#if> 

     <#if columnNameKey == "trexuq33venquoteMatcodeOne">
       <#assign columnName ="b3xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq33venquoteVendorOne">
       <#assign columnName ="b2xxudvvlxxxvendor">
     <#elseif columnNameKey == "trexuq33venquoteDepcodeOne">
       <#assign columnName ="yaxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trexuq33venquoteDivcodeOne">
       <#assign columnName ="y9xxuxoxbvxxdivcode">
     <#elseif columnNameKey == "trexuq33venquoteXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq33vinvoiceAgentOne">
       <#assign columnName ="c1xxudttblxxxagent">
     </#if> 

     <#if columnNameKey == "trexuq23cuquoteMatcodeOne">
       <#assign columnName ="b4xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq23cuquoteCustomerOne">
       <#assign columnName ="b3xxudrravnxcustomer">
     <#elseif columnNameKey == "trexuq23cuquoteContactcOne">
       <#assign columnName ="y2xxugrcavxxcontactc">
     <#elseif columnNameKey == "trexuq23cuquoteDepcodeOne">
       <#assign columnName ="ydxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trexuq23cuquoteDivcodeOne">
       <#assign columnName ="ycxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trexuq23cuquoteXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq23cuquoteAgentOne">
       <#assign columnName ="c1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trexuq26cuinvoiceMatcodeOne">
       <#assign columnName ="b2xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq26cuinvoiceCustomerOne">
       <#assign columnName ="b1xxudrravnxcustomer">
     <#elseif columnNameKey == "trexuq26cuinvoiceContactcOne">
       <#assign columnName ="y1xxudrcavxxcontactc">
     <#elseif columnNameKey == "trexuq26cuinvoiceDepcodeOne">
       <#assign columnName ="y9xxuxexbvxxdepcode">
     <#elseif columnNameKey == "trexuq26cuinvoiceDivcodeOne">
       <#assign columnName ="y8xxuxoxbvxxdivcode">
     <#elseif columnNameKey == "trexuq26cuinvoiceXshipcodeOne">
       <#assign columnName ="y5xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq26cuinvoiceAgentOne">
       <#assign columnName ="d1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trexuq27cpaymentMatcodeOne">
       <#assign columnName ="b4xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq27cpaymentCustomerOne">
       <#assign columnName ="b1xxudrravnxcustomer">
     <#elseif columnNameKey == "trexuq27cpaymentContactcOne">
       <#assign columnName ="y2xxugrcavxxcontactc">
     <#elseif columnNameKey == "trexuq27cpaymentDepcodeOne">
       <#assign columnName ="ydxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trexuq27cpaymentDivcodeOne">
       <#assign columnName ="ycxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trexuq27cpaymentXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq27cpaymentAgentOne">
       <#assign columnName ="c1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trexuq24cuordersMatcodeOne">
       <#assign columnName ="b4xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq24cuordersCustomerOne">
       <#assign columnName ="b1xxudrravnxcustomer">
     <#elseif columnNameKey == "trexuq24cuordersContactcOne">
       <#assign columnName ="y2xxugrcavxxcontactc">
     <#elseif columnNameKey == "trexuq24cuordersDepcodeOne">
       <#assign columnName ="ydxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trexuq24cuordersDivcodeOne">
       <#assign columnName ="ycxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trexuq24cuordersXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq24cuordersAgentOne">
       <#assign columnName ="c1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trexuq25shipmentMatcodeOne">
       <#assign columnName ="b1xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq25shipmentCustomerOne">
       <#assign columnName ="d1xxudrrbvxxcustomer">
     <#elseif columnNameKey == "trexuq25shipmentShipcodeOne">
       <#assign columnName ="d3xxuhbrbvxxshiptocode">
     <#elseif columnNameKey == "trexuq25shipmentMailtocodeOne">
       <#assign columnName ="d4xxugbrbvxxmailtocode">
     </#if> 



     <#if columnNameKey == "trexuq92jobassignmentMatcodeOne">
       <#assign columnName ="b5xxuxxrbvxxmatcode">
     <#elseif columnNameKey == "trexuq92jobassignmentCustomerOne">
       <#assign columnName ="baxxuxxrbvxxcustomer">
     <#elseif columnNameKey == "trexuq92jobassignmentVendorOne">
       <#assign columnName ="b8xxudvvbvxxvendor">
     <#elseif columnNameKey == "trexuq92jobassignmentPrevjobOne">
       <#assign columnName ="z1xxuxxrbvxxprevjob">
     <#elseif columnNameKey == "trexuq92jobassignmentNextjobOne">
       <#assign columnName ="z2xxuxxrbvxxnextjob">
     <#elseif columnNameKey == "trexuq92jobassignmentJobno">
       <#assign columnName ="b4xxuxxrbvxxjobno">
     <#elseif columnNameKey == "trexuq92jobassignmentMachine">
       <#assign columnName ="a0xxukxxbvxxmachine">
     </#if> 

     <#if columnNameKey == "trexuq34vendordersMatcodeOne">
       <#assign columnName ="b3xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq34vendordersVendorOne">
       <#assign columnName ="b2xxudvvlxxxvendor">
     <#elseif columnNameKey == "trexuq34vendordersContactcOne">
       <#assign columnName ="y2xxugrcavxxcontactc">
     <#elseif columnNameKey == "trexuq34vendordersDepcodeOne">
       <#assign columnName ="ydxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trexuq34vendordersDivcodeOne">
       <#assign columnName ="ycxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trexuq34vendordersXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq34vendordersAgentOne">
       <#assign columnName ="c1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trexuq36vinvoiceMatcodeOne">
       <#assign columnName ="b2xxudiravxxmatcodematcode">
     <#elseif columnNameKey == "trexuq36vinvoiceVendorOne">
       <#assign columnName ="b1xxudvvlxxxvendor">
     <#elseif columnNameKey == "trexuq36vinvoiceDepcodeOne">
       <#assign columnName ="ybxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trexuq36vinvoiceDivcodeOne">
       <#assign columnName ="yaxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trexuq36vinvoiceXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trexuq36vinvoiceAgentOne">
       <#assign columnName ="d1xxudttavxxagent">
     </#if> 

     <#if columnNameKey == "trexuq38vpaymentMatcodeOne">
       <#assign columnName ="b2xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq38vpaymentVendorOne">
       <#assign columnName ="b1xxudvvbvxxvendor">
     </#if> 

     <#if columnNameKey == "trexuq44emplordersMatcodeOne">
       <#assign columnName ="b3xxudiravxxmatcode">
     <#elseif columnNameKey == "trexuq44emplordersEmployeeOne">
       <#assign columnName ="b2xxudttlxxxemployee">
     </#if> 
     
     <#if (ids?substring(6,7) == 'c' || ids?substring(6,8) == 'sh'  )   && columnName?substring(6,8)?upper_case=='RR'>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName="Jxxxuq20customer">
      <#assign found = 'Y'>
     <#elseif (ids?substring(6,7) == 'v' || ids?substring(6,8) == 'sv' ) && columnName?substring(6,8)?upper_case=='VV'>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName="Jxxxuq30vendor">
      <#assign found = 'Y'>
     <#elseif ids?substring(6,7) == 'e' && columnName?substring(6,8)?upper_case=='TT'>
      <#assign TargetId_param_v = columnName?upper_case>
      <#assign subReport2PojoName="Jxxxuq40employee">
      <#assign found = 'Y'>
     <#else> 
      <#assign TargetId_param_v = 'xxxxxxxxxxxxnot defined'>
     </#if>
    </#if>
 </#if>
</#if>
</#foreach>
		<background>
			<band height="0"  isSplitAllowed="true" >
			</band>
		</background>
		<title>
			<band height="50"  isSplitAllowed="true" >
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="0"
						y="48"
						width="1140"
						height="2"
						forecolor="#808080"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="0"
						y="3"
						width="1140"
						height="6"
						forecolor="#808080"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>

				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="120"
						y="19"
						width="234"
						height="22"
						key="textField"/>
					<box topBorder="None" topBorderColor="#000000" leftBorder="None" leftBorderColor="#000000" rightBorder="None" rightBorderColor="#000000" bottomBorder="None" bottomBorderColor="#000000"/>
					<textElement>
						<font/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$R{${pojo.shortName?substring(10)?cap_first}}]]></textFieldExpression>
				</textField>
			<componentElement>
				<reportElement x="370" y="1" width="156" height="29"/>
				<jr:barbecue xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd" type="Codabar" drawText="false" checksumRequired="false">
					<jr:codeExpression><![CDATA[$P{Start}.trim()]]></jr:codeExpression>
				</jr:barbecue>
			</componentElement>
			</band>
		</title>
		<pageHeader>
			<band height="27"  isSplitAllowed="true" >
				<line direction="BottomUp">
					<reportElement
						mode="Opaque"
						x="0"
						y="8"
						width="1200"
						height="0"
						forecolor="#000000"
						backcolor="#FFFFFF"
						key="line"/>
					<graphicElement stretchType="NoStretch"/>
				</line>

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
						<subreportParameterExpression><![CDATA[$F{${pojo.shortName?substring(10)?upper_case}_${INVOICEETC_ID_param_v?substring(12)}}]]></subreportParameterExpression>
					</subreportParameter>
				        <subreportParameter name="subreportPath">
					<subreportParameterExpression><![CDATA[$P{subreportPath}]]></subreportParameterExpression>
				        </subreportParameter>

					<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					<subreportExpression  class="java.lang.String"><![CDATA[$P{subreportPath}+"/${subReport0PojoName}Master_SubReport0.jasper"]]></subreportExpression>
				</subreport>
				<subreport  isUsingCache="true">
					<reportElement
						x="0"
						y="11"
						width="532"
						height="46"
						key="subreport-2"/>
				        <subreportParameter name="subreportPath">
					<subreportParameterExpression><![CDATA[$P{subreportPath}]]></subreportParameterExpression>
				        </subreportParameter>

					<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					<subreportExpression  class="java.lang.String"><![CDATA[$P{subreportPath}+"/${subReport1PojoName}Master_SubReport1.jasper"]]></subreportExpression>
				</subreport>
				<subreport  isUsingCache="true">
					<reportElement
						x="0"
						y="71"
						width="466"
						height="31"
						key="subreport-3"/>
					<subreportParameter  name="ForTargetId">
						<subreportParameterExpression><![CDATA[$F{${pojo.shortName?substring(10)?upper_case}_${TargetId_param_v?substring(12)}}]]></subreportParameterExpression>
					</subreportParameter>
					<subreportParameterExpression><![CDATA[$P{subreportPath}]]></subreportParameterExpression>
				        </subreportParameter>

					<connectionExpression><![CDATA[$P{REPORT_CONNECTION}]]></connectionExpression>
					<subreportExpression  class="java.lang.String"><![CDATA[$P{subreportPath}+"/${subReport2PojoName}Master_SubReport2.jasper"]]></subreportExpression>
				</subreport>

			</band>

		</detail>
		<columnFooter>
			<band height="80"  isSplitAllowed="true" >
			</band>
		</columnFooter>
		<pageFooter>
			<band height="27"  isSplitAllowed="true" >

				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
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
						<font fontName="SansSerif" size="16"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA["Page " + $V{PAGE_NUMBER} + " of "]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Report" hyperlinkType="None"  hyperlinkTarget="Self" >
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
						<font fontName="SansSerif" size="16"/>
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
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
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
						<font fontName="SansSerif" size="16"/>
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








