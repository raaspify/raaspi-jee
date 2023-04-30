<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#if (menuAttributes?substring(efS,efE) == '60') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">  
 <#assign schema="${default_schema}">
 <#assign owner2Field = "owner2" >
<?xml version="1.0" encoding="UTF-8"?>
<#-- this report is called by a jsf button generate report via print method in xxxList.java. java method passes parameters like owner2Code,
     companyName for Header.
     1. Query String gets row values from account table
     2. many variables including Dsubtotal for debits and Csubtotal for credits defined
     3. each row is printed like a/c# Category Type debit value credit value Net value but some calculations are done 
        note- horizontal positioning is controlled by x value and is different from physical postioning of the above elements definition
        account-actual is printed but whether debit or credit is controlled by a printwhen expression which checks category and amount as non zero
        1 variable called subtotal sums up account_actual and shows the net Income in footer
        jay logic not complete
        a. rows not in order , add seq in query string like in trial bal. seq is normally 0 but needs change if new entry done
        b. sub totals block totals etc are missing
        c. Should show type I and E only not A or L , should it be called stmt of operations instead of Income stmt?

  
-->

<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd" name="report1" pageWidth="595" pageHeight="842" columnWidth="535" leftMargin="20" rightMargin="20" topMargin="20" bottomMargin="20" resourceBundle="messages" whenResourceMissingType="Key">
        <style name="Base" isDefault="true" fontName="DejaVu Serif" pdfFontName="DejaVu Serif"/>
	<style name="Title" isDefault="false" fontName="DejaVu Serif" fontSize="18" isBold="true" />
	<style name="SubTitle" isDefault="false" forecolor="#666666" fontName="DejaVu Serif" fontSize="18" />
	<style name="Column header" isDefault="false" forecolor="#666666" fontName="DejaVu Serif" fontSize="12" isBold="true" />
	<style name="Detail" isDefault="false" fontName="DejaVu Serif" fontSize="12" />
	<parameter name="owner2Code" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression ><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
	</parameter>
	<parameter name="CompanyName" isForPrompting="true" class="java.lang.String">
		<parameterDescription><![CDATA[Company Name]]></parameterDescription>
		<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
	</parameter>
	<parameter name="fYearEndS" isForPrompting="false" class="java.lang.String">
		<parameterDescription><![CDATA[Fiscal Year End]]></parameterDescription>
		<defaultValueExpression ><![CDATA[" "]]></defaultValueExpression>
	</parameter>

	<queryString language="SQL">
		<![CDATA[SELECT
     ACCOUNT.account AS ACCOUNT_ACCOUNT,
     ACCOUNT.descript AS ACCOUNT_DESCRIPT,
     ACCOUNT.category AS ACCOUNT_CATEGORY,
     ACCOUNT.type AS ACCOUNT_TYPE,
     ACCOUNT.actual AS ACCOUNT_ACTUAL,
     ACCOUNT.sequence AS ACCOUNT_SEQUENCE,
     ACCOUNT.depcode AS ACCOUNT_DEPCODE,
     ACCOUNT.divcode AS ACCOUNT_DIVCODE
FROM
     ${schema}.account ACCOUNT WHERE
      ${pojo.shortName?substring(eL)?lower_case}.${owner2Field} = $P{owner2Code} 
      order by ACCOUNT.sequence,ACCOUNT.account]]>
	</queryString>
	<field name="ACCOUNT_ACCOUNT" class="java.lang.String">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_DESCRIPT" class="java.lang.String">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_CATEGORY" class="java.lang.String">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_TYPE" class="java.lang.String">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_ACTUAL" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_SEQUENCE" class="java.lang.Integer">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_DEPCODE" class="java.lang.String">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_DIVCODE" class="java.lang.String">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<variable name="SUBTOTAL" class="java.lang.Double" calculation="Sum">
		<variableExpression><![CDATA[$F{ACCOUNT_ACTUAL}]]></variableExpression>
	</variable>
	<variable name="Debit_v" class="java.lang.String"/>
	<variable name="Credit_v" class="java.lang.String"/>
	<group name="category">
		<groupExpression><![CDATA[$F{ACCOUNT_CATEGORY}]]></groupExpression>
		<groupHeader>
			<band height="23">
				<printWhenExpression><![CDATA[Boolean.FALSE]]></printWhenExpression>
			</band>
		</groupHeader>
		<groupFooter>
			<band height="16">
				<printWhenExpression><![CDATA[Boolean.FALSE]]></printWhenExpression>
			</band>
		</groupFooter>
	</group>
	<group name="type">
		<groupExpression><![CDATA[$F{ACCOUNT_TYPE}]]></groupExpression>
		<groupHeader>
			<band height="23">
				<printWhenExpression><![CDATA[(($F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'I' || $F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'E' ) && ($F{ACCOUNT_TYPE}.toUpperCase().charAt(0) == 'B'  || $F{ACCOUNT_TYPE}.toUpperCase().charAt(0) == 'H'))?Boolean.TRUE:Boolean.FALSE]]></printWhenExpression>
				<textField>
					<reportElement style="Column header" x="197" y="0" width="100" height="20" uuid="ab70c539-97c3-4d55-84d8-b494f73dd7ce"/>
					<textElement textAlignment="Center">
						<font size="10" isBold="false"/>
					</textElement>
					<textFieldExpression><![CDATA[$F{ACCOUNT_DESCRIPT}]]></textFieldExpression>
				</textField>
			</band>
		</groupHeader>
		<groupFooter>
			<band height="16">
				<printWhenExpression><![CDATA[Boolean.FALSE]]></printWhenExpression>
			</band>
		</groupFooter>
	</group>
	<background>
		<band splitType="Stretch"/>
	</background>
	<title>
		<band height="71" splitType="Stretch">
			<staticText>
				<reportElement style="Title" x="0" y="13" width="263" height="33"/>
				<textElement verticalAlignment="Middle"/>
				<text><![CDATA[Income Statement Report]]></text>
			</staticText>
			<textField>
				<reportElement style="SubTitle" x="5" y="46" width="190" height="22"/>
				<textElement/>
				<textFieldExpression class="java.lang.String"><![CDATA[$P{CompanyName}]]></textFieldExpression>
			</textField>

			<textField >
				<reportElement x="250" y="51" width="300" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$R{For}+" "+ $R{The}+" "+ $R{Year}+" "+ $R{Ending}+" "+ $P{fYearEndS}]]></textFieldExpression>
			</textField>
		</band>
	</title>
	<pageHeader>
		<band splitType="Stretch"/>
	</pageHeader>
	<columnHeader>
		<band height="22" splitType="Stretch">
			<line>
				<reportElement positionType="FixRelativeToBottom" x="0" y="21" width="555" height="1"/>
				<graphicElement>
					<pen lineWidth="0.5" lineColor="#999999"/>
				</graphicElement>
			</line>
			<textField>
				<reportElement x="0" y="2" width="93" height="20"/>
				<textElement/>
				<textFieldExpression class="java.lang.String"><![CDATA[$R{Account}]]></textFieldExpression>
			</textField>
		</band>
	</columnHeader>
	<detail>
		<band height="28" splitType="Stretch">
			<printWhenExpression><![CDATA[($F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'I' || $F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'E'  ) ? Boolean.TRUE : Boolean.FALSE]]></printWhenExpression>
			<textField>
				<reportElement style="Detail" x="0" y="5" width="130" height="15" uuid="0d164ad8-035e-4567-b69b-f7e5bba5fdf6">
			         <printWhenExpression><![CDATA[($F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'I' || $F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'E'  ) ? Boolean.TRUE : Boolean.FALSE]]></printWhenExpression>
				</reportElement>
				<textFieldExpression><![CDATA[$F{ACCOUNT_DESCRIPT}]]></textFieldExpression>
			</textField>
			<elementGroup/>
			<textField pattern="#,##0.00;(-#,##0.00)">
				<reportElement x="197" y="5" width="70" height="15" uuid="3ee0f74b-dca7-4335-8a68-ddbb8560bc7f">
      			         <printWhenExpression><![CDATA[($F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'I' || $F{ACCOUNT_CATEGORY}.toUpperCase().charAt(0) == 'E'  ) ? Boolean.TRUE : Boolean.FALSE]]></printWhenExpression>
				</reportElement>
				<textFieldExpression><![CDATA[$F{ACCOUNT_ACTUAL}.abs()]]></textFieldExpression>
			</textField>
		</band>
	</detail>
	<columnFooter>
		<band height="20" splitType="Stretch">
			<line>
				<reportElement positionType="FixRelativeToBottom" x="0" y="3" width="555" height="1"/>
				<graphicElement>
					<pen lineWidth="0.5" lineColor="#999999"/>
				</graphicElement>
			</line>
		</band>
	</columnFooter>
	<pageFooter>
		<band height="21" splitType="Stretch">
			<textField>
				<reportElement style="Column header" x="433" y="0" width="80" height="20"/>
				<textElement textAlignment="Right">
					<font size="10" isBold="false"/>
				</textElement>
				<textFieldExpression class="java.lang.String"><![CDATA["Page "+$V{PAGE_NUMBER}+" of"]]></textFieldExpression>
			</textField>
			<textField evaluationTime="Report">
				<reportElement style="Column header" x="513" y="0" width="40" height="20"/>
				<textElement>
					<font size="10" isBold="false"/>
				</textElement>
				<textFieldExpression class="java.lang.String"><![CDATA[" " + $V{PAGE_NUMBER}]]></textFieldExpression>
			</textField>
			<textField pattern="EEEEE dd MMMMM yyyy">
				<reportElement style="Column header" x="0" y="0" width="197" height="20"/>
				<textElement>
					<font size="10" isBold="false"/>
				</textElement>
				<textFieldExpression class="java.util.Date"><![CDATA[new java.util.Date()]]></textFieldExpression>
			</textField>
		</band>
	</pageFooter>
	<summary>
		<band splitType="Stretch"/>
	</summary>
</jasperReport>

</#if>
</#if>





