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
<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd" name="Xlrxeh685xjournal" pageWidth="1200" pageHeight="595" columnWidth="1140" leftMargin="30" rightMargin="30" topMargin="20" bottomMargin="20" resourceBundle="messages" whenResourceMissingType="Key">
	<property name="ireport.scriptlethandling" value="0"/>
	<property name="ireport.encoding" value="UTF-8"/>
	<property name="ireport.zoom" value="1.0"/>
	<property name="ireport.x" value="0"/>
	<property name="ireport.y" value="0"/>
	<import value="net.sf.jasperreports.engine.*"/>
	<import value="java.util.*"/>
	<import value="net.sf.jasperreports.engine.data.*"/>
	<parameter name="DisplayAs" class="java.lang.String">
		<parameterDescription><![CDATA[Report Output as HTML or as PDF]]></parameterDescription>
		<defaultValueExpression><![CDATA["PDF"]]></defaultValueExpression>
	</parameter>
	<parameter name="MarkedOnes" class="java.lang.Boolean">
		<parameterDescription><![CDATA[Select Marked Records Only]]></parameterDescription>
	</parameter>
	<parameter name="owner2Code" class="java.lang.String">
		<parameterDescription><![CDATA[Account Domain like xxx.com]]></parameterDescription>
		<defaultValueExpression><![CDATA["myflow-3rcomp.rhcloud.com"]]></defaultValueExpression>
	</parameter>
	<parameter name="Start" class="java.lang.Integer">
		<parameterDescription><![CDATA[Start Record Key value for Select]]></parameterDescription>
		<defaultValueExpression><![CDATA[0]]></defaultValueExpression>
	</parameter>
	<parameter name="End" class="java.lang.Integer">
		<parameterDescription><![CDATA[End Record Key value for Select]]></parameterDescription>
		<defaultValueExpression><![CDATA[999999]]></defaultValueExpression>
	</parameter>
	<queryString>
		<![CDATA[SELECT
       journal.sid AS journal_sid,

       journal.spostdate AS journal_spostdate,

       journal.postdate AS journal_postdate,

       journal.calendardt AS journal_calendardt,

       journal.jrnltype AS journal_jrnltype,

       journal.jnlseqb AS journal_jnlseqb,

       journal.jnlseq AS journal_jnlseq,

       journal.jnlseqs AS journal_jnlseqs,

       journal.period AS journal_period,

       journal.account AS foreign_account,

       journal.debit AS journal_debit,

       journal.credit AS journal_credit,

       journal.xreference AS journal_xreference,

       journal.descript AS journal_descript,

       journal.statusfl AS journal_statusfl,

       journal.owner AS journal_owner,

       journal.owner2 AS journal_owner2,

       account.prevact AS account_prevact,

       account.descript AS account_descript
FROM
       genapp.journal journal left join genapp.account account on
        journal.account=account.account WHERE
       (journal.jnlseq) >=  $P{Start} AND   (journal.jnlseq <= $P{End}) AND
       journal.owner2 = $P{owner2Code} AND account.owner2 = $P{owner2Code}  order by journal.account,journal.period,journal.jnlseq]]>
	</queryString>
	<field name="journal_sid" class="java.lang.String"/>
	<field name="journal_spostdate" class="java.lang.String"/>
	<field name="journal_postdate" class="java.sql.Timestamp"/>
	<field name="journal_calendardt" class="java.sql.Timestamp"/>
	<field name="journal_jrnltype" class="java.lang.String"/>
	<field name="journal_jnlseqb" class="java.lang.String"/>
	<field name="journal_jnlseq" class="java.lang.String"/>
	<field name="journal_jnlseqs" class="java.lang.String"/>
	<field name="journal_period" class="java.lang.String"/>
	<field name="foreign_account" class="java.lang.String"/>
	<field name="journal_debit" class="java.math.BigDecimal"/>
	<field name="journal_credit" class="java.math.BigDecimal"/>
	<field name="journal_xreference" class="java.lang.String"/>
	<field name="journal_descript" class="java.lang.String"/>
	<field name="journal_statusfl" class="java.lang.String"/>
	<field name="journal_owner" class="java.lang.String"/>
	<field name="journal_owner2" class="java.lang.String"/>
	<field name="account_prevact" class="java.math.BigDecimal"/>
	<field name="account_descript" class="java.lang.String"/>
	<variable name="variance" class="java.math.BigDecimal" resetType="Group" resetGroup="byaccount" calculation="Sum">
		<variableExpression><![CDATA[$F{account_prevact}]]></variableExpression>
		<initialValueExpression><![CDATA[]]></initialValueExpression>
	</variable>
	<variable name="debitt" class="java.math.BigDecimal" resetType="Group" resetGroup="byaccount" calculation="Sum">
		<variableExpression><![CDATA[$F{journal_debit}]]></variableExpression>
	</variable>
	<variable name="creditt" class="java.math.BigDecimal" resetType="Group" resetGroup="byaccount" calculation="Sum">
		<variableExpression><![CDATA[$F{journal_credit}]]></variableExpression>
	</variable>
	<variable name="variancet" class="java.math.BigDecimal" resetType="Group" resetGroup="byaccount">
		<variableExpression><![CDATA[$V{debitt}.subtract( $V{creditt})]]></variableExpression>
	</variable>
	<variable name="balance" class="java.math.BigDecimal" resetType="Group" resetGroup="byaccount">
		<variableExpression><![CDATA[$V{variancet}.add( $F{account_prevact})]]></variableExpression>
	</variable>
	<variable name="debitgt" class="java.math.BigDecimal" incrementType="Group" incrementGroup="byaccount" calculation="Sum">
		<variableExpression><![CDATA[$V{debitt}]]></variableExpression>
	</variable>
	<variable name="creditgt" class="java.math.BigDecimal" incrementType="Group" incrementGroup="byaccount" calculation="Sum">
		<variableExpression><![CDATA[$V{creditt}]]></variableExpression>
	</variable>
	<group name="byaccount" isReprintHeaderOnEachPage="true">
		<groupExpression><![CDATA[$F{foreign_account}]]></groupExpression>
		<groupHeader>
			<band height="24">
				<textField isBlankWhenNull="true">
					<reportElement x="84" y="4" width="100" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$F{account_descript}]]></textFieldExpression>
				</textField>
				<textField isBlankWhenNull="true">
					<reportElement x="17" y="2" width="67" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$F{foreign_account}]]></textFieldExpression>
				</textField>
				<textField isBlankWhenNull="true">
					<reportElement x="617" y="4" width="100" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$F{account_prevact}]]></textFieldExpression>
				</textField>
			</band>
		</groupHeader>
		<groupFooter>
			<band height="61">
				<textField isBlankWhenNull="true">
					<reportElement x="550" y="9" width="50" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$V{creditt}]]></textFieldExpression>
				</textField>
				<textField isBlankWhenNull="true">
					<reportElement x="617" y="41" width="100" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$F{account_prevact}.add($V{variancet})]]></textFieldExpression>
				</textField>
				<textField isBlankWhenNull="true">
					<reportElement x="616" y="9" width="100" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$V{variancet}]]></textFieldExpression>
				</textField>
				<textField isBlankWhenNull="true">
					<reportElement x="485" y="9" width="50" height="20"/>
					<textElement/>
					<textFieldExpression><![CDATA[$V{debitt}]]></textFieldExpression>
				</textField>
			</band>
		</groupFooter>
	</group>
	<background>
		<band splitType="Stretch"/>
	</background>
	<title>
		<band height="50" splitType="Stretch">
			<line>
				<reportElement key="line" mode="Opaque" x="0" y="48" width="1140" height="2" forecolor="#808080" backcolor="#FFFFFF"/>
			</line>
			<line>
				<reportElement key="line" mode="Opaque" x="0" y="3" width="1140" height="6" forecolor="#808080" backcolor="#FFFFFF"/>
			</line>
			<textField isBlankWhenNull="false">
				<reportElement key="textField" x="120" y="19" width="234" height="22"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$R{Journal}+" Report"]]></textFieldExpression>
			</textField>
		</band>
	</title>
	<pageHeader>
		<band height="37" splitType="Stretch">
			<line direction="BottomUp">
				<reportElement key="line" mode="Opaque" x="0" y="8" width="1200" height="1" forecolor="#000000" backcolor="#FFFFFF"/>
			</line>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="200" y="8" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Jrnltype}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="254" y="9" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Jnlseqs}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="325" y="8" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Period}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="420" y="9" width="65" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Debit}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="550" y="8" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Credit}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="84" y="9" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Descript}]]></textFieldExpression>
			</textField>
			<staticText>
				<reportElement x="612" y="9" width="126" height="20"/>
				<textElement/>
				<text><![CDATA[NET CHANGE/BALANCE]]></text>
			</staticText>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="17" y="9" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Account}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="750" y="9" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Xreference}]]></textFieldExpression>
			</textField>
			<textField pattern="" isBlankWhenNull="false" hyperlinkType="LocalPage">
				<reportElement key="textField" x="810" y="9" width="50" height="16" forecolor="#000000" backcolor="#6666FF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement markup="styled">
					<font fontName="SansSerif" size="12" isBold="true"/>
				</textElement>
				<textFieldExpression><![CDATA[$R{Descript}]]></textFieldExpression>
			</textField>
		</band>
	</pageHeader>
	<columnHeader>
		<band splitType="Stretch"/>
	</columnHeader>
	<detail>
		<band height="25" splitType="Stretch">
			<textField isBlankWhenNull="false">
				<reportElement key="textField" x="200" y="2" width="50" height="23"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_jrnltype}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="false">
				<reportElement key="textField" x="325" y="0" width="50" height="23"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_period}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="false">
				<reportElement key="textField" x="550" y="2" width="50" height="23"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_credit}]]></textFieldExpression>
			</textField>
			<textField pattern="dd/MM/yyyy">
				<reportElement x="84" y="0" width="100" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_postdate}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="true">
				<reportElement key="textField" x="810" y="2" width="50" height="23"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_descript}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="true">
				<reportElement x="750" y="2" width="50" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_xreference}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="false">
				<reportElement key="textField" x="254" y="2" width="50" height="23"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_jnlseqs}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="false">
				<reportElement key="textField" x="420" y="2" width="50" height="23"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement/>
				<textFieldExpression><![CDATA[$F{journal_debit}]]></textFieldExpression>
			</textField>
		</band>
	</detail>
	<columnFooter>
		<band splitType="Stretch"/>
	</columnFooter>
	<pageFooter>
		<band height="30" splitType="Stretch">
			<textField pattern="" isBlankWhenNull="false">
				<reportElement key="textField" x="325" y="4" width="170" height="19" forecolor="#000000" backcolor="#FFFFFF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="SansSerif" size="10"/>
				</textElement>
				<textFieldExpression><![CDATA["Page " + $V{PAGE_NUMBER} + " of "]]></textFieldExpression>
			</textField>
			<textField evaluationTime="Report" pattern="" isBlankWhenNull="false">
				<reportElement key="textField" x="499" y="4" width="36" height="19" forecolor="#000000" backcolor="#FFFFFF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="SansSerif" size="10"/>
				</textElement>
				<textFieldExpression><![CDATA["" + $V{PAGE_NUMBER}]]></textFieldExpression>
			</textField>
			<line>
				<reportElement key="line" mode="Opaque" x="0" y="3" width="1140" height="1" forecolor="#000000" backcolor="#FFFFFF"/>
			</line>
			<textField pattern="" isBlankWhenNull="false">
				<reportElement key="textField" x="1" y="6" width="209" height="19" forecolor="#000000" backcolor="#FFFFFF"/>
				<box>
					<topPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<leftPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
					<rightPen lineWidth="0.0" lineStyle="Solid" lineColor="#000000"/>
				</box>
				<textElement>
					<font fontName="SansSerif" size="10"/>
				</textElement>
				<textFieldExpression><![CDATA[new Date()]]></textFieldExpression>
			</textField>
		</band>
	</pageFooter>
	<summary>
		<band height="50" splitType="Stretch">
			<textField isBlankWhenNull="true">
				<reportElement x="491" y="16" width="100" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$V{debitgt}]]></textFieldExpression>
			</textField>
			<textField isBlankWhenNull="true">
				<reportElement x="563" y="16" width="100" height="20"/>
				<textElement/>
				<textFieldExpression><![CDATA[$V{creditgt}]]></textFieldExpression>
			</textField>
		</band>
	</summary>
</jasperReport>


</#if>
</#if>





