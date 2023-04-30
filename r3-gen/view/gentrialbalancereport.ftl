<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes2 = pojo.shortName?substring(0,eL)?upper_case>
<#if (menuAttributes2?substring(efS,efE) == '60') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">   
 <#assign schema="${default_schema}">
<?xml version="1.0" encoding="UTF-8"?>
 <#assign owner2Field = "owner2" >
<#-- this report is called by a jsf button generate report via print method in xxxList.java. java method passes parameters like owner2Code,
     companyName for Header.
     1. Query String gets row values from account table
     2. many variables including Dsubtotal for debits and Csubtotal for credits defined
     3. Report can use the row data including totals and subtotals as is because there is a method called accountsTotlsRollUp
        which is called as part of any individual account update 
     4. each row is printed like a/c# description debit value credit value but some calculations are done 
        note- horizontal positioning is controlled by x value and is different from physical postioning of the above elements definition
        each row credit and debit is calculated and shown as needed whereas Dsubtotal/Csubtotal is used to keep running totals for debits/credits
        spcl accounting rules stated below are used to calculate debit/credit value
        Same rule is applied in TotalsRollUp logic as well
        Debit
        if Asset, add prevact to actual and the result >0
        if expense use only actual and is >0
        if Liability, add prevact to actual and result <0
        Equites can be QR-Retained Earning QD-Dividend QC-Current Earning
        if Equity dividend use only actual and is >0
        if Equity retained earning use only actual and is <0
        if Equity current earning skip because included in retained ??. >0 goes to credit and less <0 goes to debit
        if any other Equity add prevact to actual and result <0
        if Revenue ???

        Credit
        reverse of above

          
-->
<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd" name="report1" pageWidth="595" pageHeight="842" columnWidth="535" leftMargin="20" rightMargin="20" topMargin="20" bottomMargin="20" resourceBundle="messages" whenResourceMissingType="Key">
	<property name="ireport.zoom" value="1.0"/>
	<property name="ireport.x" value="0"/>
	<property name="ireport.y" value="0"/>
	<style name="Title" fontName="DejaVu Serif" fontSize="26"  />
	<style name="SubTitle" forecolor="#666666" fontName="DejaVu Serif" fontSize="18"/>
	<style name="Column header" forecolor="#666666" fontName="DejaVu Serif" fontSize="12" />
	<style name="Detail" fontName="DejaVu Serif" fontSize="12"/>
	<parameter name="owner2Code" class="java.lang.String">
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
	</parameter>
	<parameter name="End" class="java.lang.String">
		<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
		<defaultValueExpression><![CDATA["      "]]></defaultValueExpression>
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
     ACCOUNT.prevact AS ACCOUNT_PREVACT,
     ACCOUNT.sequence AS ACCOUNT_SEQUENCE,
     ACCOUNT.depcode AS ACCOUNT_DEPCODE,
     ACCOUNT.divcode AS ACCOUNT_DIVCODE,
     ACCOUNT.p0 AS ACCOUNT_P0,
     ACCOUNT.p1 AS ACCOUNT_P1,
     ACCOUNT.p2 AS ACCOUNT_P2,
     ACCOUNT.p3 AS ACCOUNT_P3,
     ACCOUNT.p4 AS ACCOUNT_P4,
     ACCOUNT.p5 AS ACCOUNT_P5,
     ACCOUNT.p6 AS ACCOUNT_P6,
     ACCOUNT.p7 AS ACCOUNT_P7,
     ACCOUNT.p8 AS ACCOUNT_P8,
     ACCOUNT.p9 AS ACCOUNT_P9,
     ACCOUNT.p10 AS ACCOUNT_P10,
     ACCOUNT.p11 AS ACCOUNT_P11,
     ACCOUNT.p12 AS ACCOUNT_P12,
     ACCOUNT.p13 AS ACCOUNT_P13,
     ACCOUNT.p14 AS ACCOUNT_P14
FROM
     genapp.account ACCOUNT WHERE
      account.owner2 = $P{owner2Code}
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
	<field name="ACCOUNT_PREVACT" class="java.math.BigDecimal">
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
	<field name="ACCOUNT_P0" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P1" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P2" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P3" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P4" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P5" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P6" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P7" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P8" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P9" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P10" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P11" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P12" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P13" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<field name="ACCOUNT_P14" class="java.math.BigDecimal">
		<fieldDescription><![CDATA[]]></fieldDescription>
	</field>
	<variable name="DSUBTOTAL" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[($F{ACCOUNT_TYPE}.charAt(0) == 'D'
           && ( ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))> 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'E'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'I'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'L'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))< 0)
                ||($F{ACCOUNT_CATEGORY}.startsWith("QD")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                ||($F{ACCOUNT_CATEGORY}.startsWith("QR")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC") && !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))< 0)


           )
           ? ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A' ||$F{ACCOUNT_CATEGORY}.charAt(0) == 'L' ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC")&& !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))) ? $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).abs():$F{ACCOUNT_ACTUAL}.abs()) : new BigDecimal("0.0") )]]></variableExpression>
	</variable>
	<variable name="Debit_v" class="java.lang.String"/>
	<variable name="Credit_v" class="java.lang.String"/>
	<variable name="endp1" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1})]]></variableExpression>
	</variable>
	<variable name="endp2" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})]]></variableExpression>
	</variable>
	<variable name="endp3" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})
        .add($F{ACCOUNT_P3})]]></variableExpression>
	</variable>
	<variable name="endp4" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})
        .add($F{ACCOUNT_P3}).add($F{ACCOUNT_P4})]]></variableExpression>
	</variable>
	<variable name="endp5" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})
        .add($F{ACCOUNT_P3}).add($F{ACCOUNT_P4}).add($F{ACCOUNT_P5})]]></variableExpression>
	</variable>
	<variable name="endp6" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})
        .add($F{ACCOUNT_P3}).add($F{ACCOUNT_P4}).add($F{ACCOUNT_P5}).add($F{ACCOUNT_P6})]]></variableExpression>
	</variable>
	<variable name="endp7" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})
        .add($F{ACCOUNT_P3}).add($F{ACCOUNT_P4}).add($F{ACCOUNT_P5}).add($F{ACCOUNT_P6})
        .add($F{ACCOUNT_P7})]]></variableExpression>
	</variable>
	<variable name="endp8" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$F{ACCOUNT_PREVACT}.add($F{ACCOUNT_P1}).add($F{ACCOUNT_P2})
        .add($F{ACCOUNT_P3}).add($F{ACCOUNT_P4}).add($F{ACCOUNT_P5}).add($F{ACCOUNT_P6})
        .add($F{ACCOUNT_P7}).add($F{ACCOUNT_P8})]]></variableExpression>
	</variable>
	<variable name="endp9" class="java.math.BigDecimal"/>
	<variable name="endp10" class="java.math.BigDecimal"/>
	<variable name="endp11" class="java.math.BigDecimal"/>
	<variable name="endp12" class="java.math.BigDecimal"/>
	<variable name="endp13" class="java.math.BigDecimal"/>
	<variable name="CSUBTOTAL" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[($F{ACCOUNT_TYPE}.charAt(0) == 'D'
           && ( ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))< 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'E'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'I'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'L'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))> 0)
                ||($F{ACCOUNT_CATEGORY}.startsWith("QR")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                ||($F{ACCOUNT_CATEGORY}.startsWith("QD")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC") && !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))> 0)

           )
           ? ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A' ||$F{ACCOUNT_CATEGORY}.charAt(0) == 'L' ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC")&& !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))) ? $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).abs():$F{ACCOUNT_ACTUAL}.abs()) : new BigDecimal("0.0") )]]></variableExpression>
	</variable>
	<variable name="debitv" class="java.math.BigDecimal"/>
	<variable name="creditv" class="java.lang.String"/>
	<variable name="debitlesscredit" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$V{CSUBTOTAL}.subtract($V{DSUBTOTAL})]]></variableExpression>
	</variable>
	<variable name="revenuet" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[($F{ACCOUNT_CATEGORY}.charAt(0) == 'I')&&($F{ACCOUNT_TYPE}.charAt(0) == 'D')?$F{ACCOUNT_ACTUAL}:new BigDecimal("0.0")]]></variableExpression>
	</variable>
	<variable name="expenset" class="java.math.BigDecimal" calculation="Sum">
		<variableExpression><![CDATA[($F{ACCOUNT_CATEGORY}.charAt(0) == 'E')&&($F{ACCOUNT_TYPE}.charAt(0) == 'D')?$F{ACCOUNT_ACTUAL}:new BigDecimal("0.0")]]></variableExpression>
	</variable>
	<variable name="netprofit" class="java.math.BigDecimal">
		<variableExpression><![CDATA[$V{revenuet}.subtract($V{expenset})]]></variableExpression>
	</variable>
	<background>
		<band splitType="Stretch"/>
	</background>
	<title>
		<band height="71" splitType="Stretch">
			<staticText>
				<reportElement style="Title" x="0" y="13" width="263" height="33"/>
				<textElement verticalAlignment="Middle"/>
				<text><![CDATA[Trial Balance Report]]></text>
			</staticText>
			<textField isBlankWhenNull="true">
				<reportElement style="SubTitle" x="5" y="46" width="200" height="22"/>
				<textElement/>
				<textFieldExpression class="java.lang.String"><![CDATA[$P{CompanyName}]]></textFieldExpression>
			</textField>
			        <textField >
				 <reportElement x="197" y="51" width="300" height="20"/>
				 <textElement/>
				 <textFieldExpression><![CDATA[$R{For}+" "+ $R{The}+" "+ $R{Year}+" "+ $R{Ending}+" "+ $P{fYearEndS}]]></textFieldExpression>
			        </textField>
		</band>
	</title>
	<pageHeader>
		<band splitType="Stretch"/>
	</pageHeader>
	<columnHeader>
		<band height="30" splitType="Stretch">
			<line>
				<reportElement positionType="FixRelativeToBottom" x="0" y="21" width="555" height="1"/>
				<graphicElement>
					<pen lineWidth="0.5" lineColor="#999999"/>
				</graphicElement>
			</line>
			<textField>
				<reportElement x="0" y="2" width="60" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$R{Account}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="74" y="2" width="100" height="20"/>
				<textElement/>
				<text><![CDATA[ACCOUNT_DESCRIPT]]></text>
			</staticText>
			<staticText>
				<reportElement x="341" y="5" width="105" height="20"/>
				<textElement/>
				<text><![CDATA[DEBIT]]></text>
			</staticText>
			<staticText>
				<reportElement x="461" y="6" width="100" height="20"/>
				<textElement/>
				<text><![CDATA[CREDIT]]></text>
			</staticText>
		</band>
	</columnHeader>
	<detail>
		<band height="25" splitType="Stretch">
			<textField>
				<reportElement style="Detail" x="0" y="0" width="60" height="19"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{ACCOUNT_ACCOUNT}]]></textFieldExpression>
			</textField>
			<elementGroup/>
			<elementGroup/>
			<textField pattern="#,##0.00;-#,##0.00">
				<reportElement x="341" y="0" width="92" height="19">
				</reportElement>
				<textElement/>
				<textFieldExpression><![CDATA[(
                         ( ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))> 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'E'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'I'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'L'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))< 0)
                        ||($F{ACCOUNT_CATEGORY}.startsWith("QD")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                        ||($F{ACCOUNT_CATEGORY}.startsWith("QR")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC") && !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))< 0)
                        )
                        ? ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A' ||$F{ACCOUNT_CATEGORY}.charAt(0) == 'L' ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC")&& !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR")))  ? $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).abs():$F{ACCOUNT_ACTUAL}.abs()):""  )]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement x="74" y="0" width="189" height="19"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{ACCOUNT_DESCRIPT}]]></textFieldExpression>
			</textField>
			<textField pattern="###0.00;-###0.00">
				<reportElement x="461" y="0" width="84" height="19">
				</reportElement>
				<textElement/>
				<textFieldExpression><![CDATA[(
                         ( ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))< 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'E'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'I'  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'L'  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))> 0)
                        ||($F{ACCOUNT_CATEGORY}.startsWith("QR")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))> 0)
                        ||($F{ACCOUNT_CATEGORY}.startsWith("QD")  && $F{ACCOUNT_ACTUAL}.compareTo( new BigDecimal("0.0"))< 0)
                        ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC") && !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))  && $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).compareTo( new BigDecimal("0.0"))> 0)
                        )
                        ? ($F{ACCOUNT_CATEGORY}.charAt(0) == 'A' ||$F{ACCOUNT_CATEGORY}.charAt(0) == 'L' ||($F{ACCOUNT_CATEGORY}.charAt(0) == 'Q' && (!$F{ACCOUNT_CATEGORY}.startsWith("QC")&& !$F{ACCOUNT_CATEGORY}.startsWith("QD") && !$F{ACCOUNT_CATEGORY}.startsWith("QR"))) ? $F{ACCOUNT_ACTUAL}.add($F{ACCOUNT_PREVACT}).abs():$F{ACCOUNT_ACTUAL}.abs()) :  "" )]]></textFieldExpression>
			</textField>
			<line>
				<reportElement positionType="FixRelativeToBottom" x="0" y="19" width="555" height="1"/>
				<graphicElement>
					<pen lineWidth="0.5" lineStyle="Double" lineColor="#999999"/>
				</graphicElement>
			</line>
		</band>
	</detail>
	<columnFooter>
		<band height="2" splitType="Stretch"/>
	</columnFooter>
	<pageFooter>
		<band height="21" splitType="Stretch">
			<textField>
				<reportElement style="Column header" x="433" y="0" width="80" height="20"/>
				<textElement textAlignment="Right">
					<font size="10" isBold="false"/>
				</textElement>
				<textFieldExpression><![CDATA["Page "+$V{PAGE_NUMBER}+" of"]]></textFieldExpression>
			</textField>
			<textField evaluationTime="Report">
				<reportElement style="Column header" x="513" y="0" width="40" height="20"/>
				<textElement>
					<font size="10" isBold="false"/>
				</textElement>
				<textFieldExpression><![CDATA[" " + $V{PAGE_NUMBER}]]></textFieldExpression>
			</textField>
			<textField pattern="EEEEE dd MMMMM yyyy">
				<reportElement style="Column header" x="0" y="0" width="197" height="20"/>
				<textElement>
					<font size="10" isBold="false"/>
				</textElement>
				<textFieldExpression><![CDATA[new java.util.Date()]]></textFieldExpression>
			</textField>
		</band>
	</pageFooter>
	<summary>
		<band height="68" splitType="Stretch">
			<staticText>
				<reportElement x="198" y="48" width="159" height="20"/>
				<textElement/>
				<text><![CDATA[ Net Income for accounts Listed                          ]]></text>
			</staticText>
			<textField pattern="#,##0.00;-#,##0.00">
				<reportElement x="461" y="22" width="72" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$V{CSUBTOTAL}]]></textFieldExpression>
			</textField>
			<textField pattern="#,##0.00;-#,##0.00">
				<reportElement x="341" y="22" width="92" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$V{DSUBTOTAL}]]></textFieldExpression>
			</textField>
			<textField pattern="#,##0.00;-#,##0.00">
				<reportElement x="215" y="22" width="100" height="20" forecolor="#FF0000">
					<printWhenExpression><![CDATA[$V{debitlesscredit}.compareTo( new BigDecimal("0.0")) !=0]]></printWhenExpression>
				</reportElement>
				<textElement/>
				<textFieldExpression><![CDATA[$V{debitlesscredit}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="false">
				<reportElement x="23" y="21" width="100" height="20">
					<printWhenExpression><![CDATA[false]]></printWhenExpression>
				</reportElement>
				<textElement/>
				<textFieldExpression><![CDATA[$V{revenuet}]]></textFieldExpression>
			</textField>
			<textField>
				<reportElement x="145" y="24" width="70" height="20">
					<printWhenExpression><![CDATA[false]]></printWhenExpression>
				</reportElement>
				<textElement/>
				<textFieldExpression><![CDATA[$V{expenset}]]></textFieldExpression>
			</textField>
			<textField pattern="#,##0.00;(-#,##0.00)">
				<reportElement x="433" y="48" width="100" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$V{netprofit}]]></textFieldExpression>
			</textField>
		</band>
	</summary>
</jasperReport>


</#if>
</#if>





