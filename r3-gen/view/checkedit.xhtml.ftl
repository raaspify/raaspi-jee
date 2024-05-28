
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#-- not used
-->
<#include "../view/assigns/PositionLength.properties" >
<#assign entityName = pojo.shortName>
<#assign componentName = util.lower(entityName)>
<#assign homeName = componentName + "Home">
<#assign listName = componentName + "List">
<#assign masterPageName = entityName + "List">
<#assign editPageName = entityName + "Edit">
<#assign pageName = entityName>
<#assign menuPageName = "home">
<#assign menuAddTran = false>

<#if (entityName?length >eL) >
 <#assign menuAttributes = entityName?substring(0,eL)?upper_case>
<#else>
 <#assign entityName = "jxxxxxxxxxxxxxxxxxxx">
 <#assign menuAttributes = entityName?substring(0,eL)?upper_case>
</#if>


<#foreach property in pojo.allPropertiesIterator>
 <#if c2j.isComponent(property)>
  <#foreach componentProperty in property.value.propertyIterator>
   compprop -> ${componentProperty.name}
  </#foreach>
 <#else>
   prop -> ${property.name}
 </#if>
</#foreach>

<#assign jay='j'>
<#if jay =='j' >

<#else>






<#assign reportName = "reportName">
<#assign displayAs = "displayAs">
<#assign start = "start">
<#assign end = "end">
<#assign markedOnes = "markedOnes">    
<#assign  selectEntityFieldName ="gggggggggggggggggggggggggg" >
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:p="http://primefaces.org/ui"
                template="layout/template.xhtml">

  <#if (menuAttributes?contains("A") || menuAttributes?contains("C") || menuAttributes?contains("D") || menuAttributes?contains("F") || menuAttributes?contains("J") && menuAttributes?contains("T")) >
   <#assign menuAddTran = true>
  </#if>
<f:metadata>
    <f:viewAction action="${'#'}{${homeName}.restrict()}" />
</f:metadata>

<ui:define name="body">
    
    <h:messages globalOnly="true" styleClass="message" id="globalMessages"/>

    <h:form id="${componentName}" styleClass="edit">
	<p:toolBar height="26" itemSeparator="grid">
	  <p:toolBarGroup>
              <h:commandButton id="printb" value="Print"  action="${'#'}{${listName}.print}" image="/img/Print16.gif" />
	  </p:toolBarGroup>
	  <p:toolBarGroup>
		  <h:graphicImage value="/img/SaveAs16.gif" styleClass="pic"/>
		  <h:graphicImage value="/img/SaveAll16.gif" styleClass="pic"/>
	  </p:toolBarGroup>
	  <p:toolBarGroup location="right">
		  <h:graphicImage value="/img/Search16.gif" styleClass="pic"/>
		  <h:graphicImage value="/img/About16.gif" styleClass="pic"/>
	  </p:toolBarGroup>
	</p:toolBar>
        <p:panel>
        <h:panelGrid columns="4">
        <#if (entityName?length > 12)>
            <f:facet name="header">${'#'}{${homeName}.managed ? 'Edit' : 'Add'} ${'#'}{messages['${entityName?substring(eL)?cap_first}']}</f:facet>
        </#if>
  <#include "r-genmeta.xhtml.ftl">
    
  <#assign firstTime="Y"> 
  <#assign accountEntityName="dxxxuq61account">
  <#assign addressEntityName="jxxxuq11address">
  <#assign addressEntityAddressFieldName="a0xxukbxbvxxaddrescode">
  <#assign acintegrationEntityName="dxxxuq63acintegr">
  <#assign clientEntityName="yxxxuq52client">
  <#assign scheduleEntityName="fxxxuq81schedule">
  <#assign itemEntityName="fxxxuq15item">
  <#assign itemEntityItemFieldName="a0xxukixbvxxmatcode">
  <#assign itemUnitField="c5xxuuxrbvxxunit">
  <#assign itemDescriptionField="b1xxuzsxbvxxdescript">
  <#assign itemPriceField="b8xxzpxxbvxxselprice">
  <#assign itemQtyField="z1xxziqxlvxxquantity">
  <#assign journalEntityName="xlrxeh65journal">
  <#assign employeeEntityName="jxxxuq41employee">
  <#assign employeeEntityEmployeeFieldName="a0xxuktxbvxxemployee">
  <#assign customerEntityName="jxxxuq21customer">
  <#assign customerEntityCustomerFieldName="a0xxukxxbvxxcustomer">
  <#assign customerEntityIntegrationSetFieldName="f2xxuwmxbvgxintegrset">
  <#assign customerContactEntityName="jxxxuq22ccontact">
  <#assign customerContactEntityContactFieldName="a0xxukxxbvxxcontact">
  <#assign customerInvoiceEtcItemDetailsEntityName="xxxxuq24cuqoipdetails">
  <#assign customerInvoiceEtcItemDetailsID1FieldName="ucdxbvxxcuqno">
  <#assign customerInvoiceEtcItemDetailsID2FieldName="zo11bvlxline">
  <#assign customerInvoiceEtcItemDetailsPriceFieldName="zpxravxxordprice">
  <#assign customerInvoiceEtcItemDetailsTax1FieldName="z1xxavxxtax1amt">
  <#assign customerInvoiceEtcItemDetailsTax2FieldName="z2xxavxxtax2amt">
  <#assign customerInvoiceEtcItemDetailsTax3FieldName="z3xxavxxtax3amt">
  <#assign customerInvoiceEtcItemDetailsUnitFieldName="uuxxbv19ordunit">
  <#assign customerInvoiceEtcItemDetailsDeliveryFieldName="zlxxavxxdelivchrg">
  <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName="zmxxavxxmiscchrg">
  <#assign customerInvoiceEtcItemDetailsQtyFieldName="zqxxbvnxqtyordrd">
  <#assign customerQuoteItemDetailsEntityName="xxxxuq24cuqdetails">
  <#assign customerQuoteItemDetailsID1FieldName="a0xxucdxbvxxcuqno">
  <#assign customerQuoteItemDetailsID2FieldName="z1xxzo11bvlxline">
  <#assign customerQuoteItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign customerQuoteItemDetailsTax1FieldName="zdxxz1xxavxxtax1amt">
  <#assign customerQuoteItemDetailsTax2FieldName="zexxz2xxavxxtax2amt">
  <#assign customerQuoteItemDetailsTax3FieldName="zfxxz3xxavxxtax3amt">
  <#assign customerQuoteItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign customerQuoteItemDetailsDeliveryFieldName="zbxxzlxxavxxdelivchrg">
  <#assign customerQuoteItemDetailsMiscelleneousFieldName="zcxxzmxxavxxmiscchrg">
  <#assign customerQuoteItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign customerOrderItemDetailsEntityName="xxxxuq24cuodetails">
  <#assign customerOrderItemDetailsID1FieldName="a0xxucdxbvxxcuono">
  <#assign customerOrderItemDetailsID2FieldName="b1xxzo11bvlxline">
  <#assign customerOrderItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign customerOrderItemDetailsTax1FieldName="zdxxz1xxavxxtax1amt">
  <#assign customerOrderItemDetailsTax2FieldName="zexxz2xxavxxtax2amt">
  <#assign customerOrderItemDetailsTax3FieldName="zfxxz3xxavxxtax3amt">
  <#assign customerOrderItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign customerOrderItemDetailsDeliveryFieldName="zbxxzlxxavxxdelivchrg">
  <#assign customerOrderItemDetailsMiscelleneousFieldName="zcxxzmxxavxxmiscchrg">
  <#assign customerOrderItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign customerInvoiceItemDetailsEntityName="xxxxuq24cuidetails">
  <#assign customerInvoiceItemDetailsID1FieldName="a0xxucdxbvxxcuino">
  <#assign customerInvoiceItemDetailsID2FieldName="b1xxzo11bvlxline">
  <#assign customerInvoiceItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign customerInvoiceItemDetailsTax1FieldName="zdxxz1xxavxxtax1amt">
  <#assign customerInvoiceItemDetailsTax2FieldName="zexxz2xxavxxtax2amt">
  <#assign customerInvoiceItemDetailsTax3FieldName="zfxxz3xxavxxtax3amt">
  <#assign customerInvoiceItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign customerInvoiceItemDetailsDeliveryFieldName="zbxxzlxxavxxdelivchrg">
  <#assign customerInvoiceItemDetailsMiscelleneousFieldName="zcxxzmxxavxxmiscchrg">
  <#assign customerInvoiceItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign customerPaymentItemDetailsEntityName="xxxxuq24cupdetails">
  <#assign customerPaymentItemDetailsID1FieldName="a0xxucdxbvxxcupno">
  <#assign customerPaymentItemDetailsID2FieldName="b1xxzo11bvlxline">
  <#assign customerPaymentItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign customerPaymentItemDetailsTax1FieldName="zbxxz1xxavxxtax1amt">
  <#assign customerPaymentItemDetailsTax2FieldName="zcxxz2xxavxxtax2amt">
  <#assign customerPaymentItemDetailsTax3FieldName="zdxxz3xxavxxtax3amt">
  <#assign customerPaymentItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign customerPaymentItemDetailsDeliveryFieldName="z9xxzlxxavxxdelivchrg">
  <#assign customerPaymentItemDetailsMiscelleneousFieldName="zaxxzmxxavxxmiscchrg">
  <#assign customerPaymentItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign divisionEntityName="jxxxuq13division">
  <#assign divisionEntityDivisionFieldName="a0xxukoxbvxxdivcode">
  <#assign departmentEntityName="jxxxuq12department">
  <#assign departmentEntityDepartmentFieldName="a0xxukexbvxxdepcode">
  <#assign accountEntityAccountFieldName="a0xxukwxbvxxaccount">
  <#assign tableEntityName="nxxxiha1rgentable">
  <#assign tableEntityTableFieldName="a0xxukxxbvxxtablename">
  <#assign vendorEntityName="jxxxuq31vendor">
  <#assign vendorEntityVendorFieldName="a0xxukxxbvxxvendor">
  <#assign vendorContactEntityName="jxxxuq32vcontact">
  <#assign vendorContactEntityContactFieldName="a0xxukxxbvxxcontact">
  <#assign vendorInvoiceEtcItemDetailsEntityName="xxxxuq34vendqoipdetails">
  <#assign vendorInvoiceEtcItemDetailsID1FieldName="uvdxbvxxvendqno">
  <#assign vendorInvoiceEtcItemDetailsID2FieldName="zo11bvlxline">
  <#assign vendorInvoiceEtcItemDetailsPriceFieldName="zpxravxxordprice">
  <#assign vendorInvoiceEtcItemDetailsTax1FieldName="z1xxavxxtax1amt">
  <#assign vendorInvoiceEtcItemDetailsTax2FieldName="z2xxavxxtax2amt">
  <#assign vendorInvoiceEtcItemDetailsTax3FieldName="z3xxavxxtax3amt">
  <#assign vendorInvoiceEtcItemDetailsUnitFieldName="uuxxbv19ordunit">
  <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName="zlxxavxxdelivchrg">
  <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName="zmxxavxxmiscchrg">
  <#assign vendorInvoiceEtcItemDetailsQtyFieldName="zqxxbvnxqtyordrd">
  <#assign vendorQuoteItemDetailsEntityName="xxxxuq34vendqdetails">
  <#assign vendorQuoteItemDetailsID1FieldName="a0xxuvdxbvxxvendqno">
  <#assign vendorQuoteItemDetailsID2FieldName="b1xxzo11bvlxline">
  <#assign vendorQuoteItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign vendorQuoteItemDetailsTax1FieldName="zcxxz1xxavxxtax1amt">
  <#assign vendorQuoteItemDetailsTax2FieldName="zdxxz2xxavxxtax2amt">
  <#assign vendorQuoteItemDetailsTax3FieldName="zexxz3xxavxxtax3amt">
  <#assign vendorQuoteItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign vendorQuoteItemDetailsDeliveryFieldName="zaxxzlxxavxxdelivchrg">
  <#assign vendorQuoteItemDetailsMiscelleneousFieldName="zbxxzmxxavxxmiscchrg">
  <#assign vendorQuoteItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign vendorOrderItemDetailsEntityName="xxxxuq34vendodetails">
  <#assign vendorOrderItemDetailsID1FieldName="a0xxuvdxbvxxvendono">
  <#assign vendorOrderItemDetailsID2FieldName="a1xxzo11bvlxline">
  <#assign vendorOrderItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign vendorOrderItemDetailsTax1FieldName="zcxxz1xxavxxtax1amt">
  <#assign vendorOrderItemDetailsTax2FieldName="zdxxz2xxavxxtax2amt">
  <#assign vendorOrderItemDetailsTax3FieldName="zexxz3xxavxxtax3amt">
  <#assign vendorOrderItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign vendorOrderItemDetailsDeliveryFieldName="zaxxzlxxavxxdelivchrg">
  <#assign vendorOrderItemDetailsMiscelleneousFieldName="zbxxzmxxavxxmiscchrg">
  <#assign vendorOrderItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign vendorInvoiceItemDetailsEntityName="xxxxuq34vendidetails">
  <#assign vendorInvoiceItemDetailsID1FieldName="a0xxuvdxbvxxvendino">
  <#assign vendorInvoiceItemDetailsID2FieldName="a1xxzo11bvlxline">
  <#assign vendorInvoiceItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign vendorInvoiceItemDetailsTax1FieldName="zcxxz1xxavxxtax1amt">
  <#assign vendorInvoiceItemDetailsTax2FieldName="zdxxz2xxavxxtax2amt">
  <#assign vendorInvoiceItemDetailsTax3FieldName="zexxz3xxavxxtax3amt">
  <#assign vendorInvoiceItemDetailsUnitFieldName="z4xxuuxxbv19ordunit">
  <#assign vendorInvoiceItemDetailsDeliveryFieldName="zaxxzlxxavxxdelivchrg">
  <#assign vendorInvoiceItemDetailsMiscelleneousFieldName="zbxxzmxxavxxmiscchrg">
  <#assign vendorInvoiceItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">
  <#assign vendorPaymentItemDetailsEntityName="xxxxuq34vendpdetails">
  <#assign vendorPaymentItemDetailsID1FieldName="a0xxuvdxbvxxvendpno">
  <#assign vendorPaymentItemDetailsID2FieldName="a1xxzo11bvlxline">
  <#assign vendorPaymentItemDetailsPriceFieldName="z5xxzpxravxxordprice">
  <#assign vendorPaymentItemDetailsTax1FieldName="zcxxz1xxavxxtax1amt">
  <#assign vendorPaymentItemDetailsTax2FieldName="zdxxz2xxavxxtax2amt">
  <#assign vendorPaymentItemDetailsTax3FieldName="zexxz3xxavxxtax3amt">
  <#assign vendorPaymentItemDetailsUnitFieldName="uuxxbv19ordunit">
  <#assign vendorPaymentItemDetailsDeliveryFieldName="zaxxzlxxavxxdelivchrg">
  <#assign vendorPaymentItemDetailsMiscelleneousFieldName="zbxxzmxxavxxmiscchrg">
  <#assign vendorPaymentItemDetailsQtyFieldName="z3xxzqxxbvnxqtyordrd">

  <#assign miscchrgField="">
  <#assign deliveryField="">
  <#assign priceField="">
  <#assign qtyField="">
  <#assign costField="">
  <#assign tax1Field="">
  <#assign tax2Field="">
  <#assign tax3Field="">
  <#assign unitField="">


  <#assign clientVendorinField="s6xxuxvibvxxvendorinvoicen">
  <#assign clientKeyField="a0xxukxxbvxxversion">
  <#assign clientCustomerqnField="q9xxuxcqbvxxcustomerquoten">
  <#assign clientVendorqnField="t3xxuxvqbvxxvendorquoten">
  <#assign clientEmployeeqnField="">
  <#assign clientCustomeronField="r3xxuxcobvxxcustomerordern">
  <#assign clientVendoronField="r6xxuxvobvxxvendorordern">
  <#assign clientEmployeeonField="">
  <#assign clientCustomerinField="s3xxuxcibvxxcustomerinvoicen">
  <#assign clientEmployeeinField="">
  <#assign clientCustomerpnField="">
  <#assign clientVendorpnField="">
  <#assign clientEmployeepnField="">
  <#assign clientShipmentnField="">
  <#assign clientAllocateJobnField="r8xxuxjobvxxjobn">
  <#assign clientDepartmentnField="c3xxuexxbvxxndepcode">
  <#assign clientDivisionnField="c2xxuoxxbvxxndivcode">
  <#assign clientGlSeqnField="u3xxzwplbvxxglseq">
  <#assign clientArSeqnField="t6xxzwprbvxxarseq">
  <#assign entityFunction="">
  <#assign keyedKeyName="">
  <#assign centityName="">
  <#assign centityFieldName= "">
  <#assign keyMaxLength=19>
  <#assign keyfromclient = "N">
  <#assign wireCalled = "N">
  <#assign callCreateCdetails = "N">
  <#assign callCreateVdetails = "N">
  <#assign bycalled = "N">
  <#assign itemSelected = "N">
  <#assign keyfromsubkeys = "N">
  <#assign parentKeyName = "not assigned yet xxxxxxxxxxx">
<#-- The following logic was added to see whether extra select buttons need to be added for those properties which
     are foreign keys and the field name settings indicate that such a buttons are needed.
     This was considered as a convenience and intutive even though the bottom of each edit form also allloes the foreign
     fields to be selected.
     The foreign key fields are not displayed on the entity edit form, so it shows the foreign field followed by 
     select button . jay disable the fields and make text as value not selected
     It can also show other fields like qtyordrd which are not part of the parent entity being shown on the form
     An alternative solution will be to move or duplicate the select buttons from the bottom of the form to the left or side of 
     of each edit form but will not solve all the above issues
-->  
<#-- in case of multiple foreign keys for a field like contact, we need to pick the correct key. The property will 
      show the foreign entity name not the property corresponding to the column name.
      foreach column in property.columnIterator method wont work because columns will not have the prefix characters
      assign lastOfKeys=column.name need to be changed to hard code the prefix values
--> 

<#foreach property in pojo.allPropertiesIterator>
 <#if c2j.isComponent(property)>
  <#foreach componentProperty in property.value.propertyIterator>
  </#foreach>
 <#else>
  <#if c2h.isManyToOne(property)>
    <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
    <#assign parentName = util.lower(parentPojo.shortName)>
    <#foreach parentProperty in parentPojo.allPropertiesIterator>
     <#if !c2h.isCollection(parentProperty) && !c2h.isManyToOne(parentProperty)>
      <#if parentPojo.isComponent(parentProperty)>
       <#assign loop=0>
       <#foreach componentProperty in parentProperty.value.propertyIterator>
         <#if loop == 0>
          <#assign loop=1>
          <#assign parentKeyName =  parentProperty.name >
         </#if>
       </#foreach>
      <#else>
       <#if (parentProperty.name?length > 12) >
        <#if parentProperty.name?substring(5,6)=="k">
         <#assign parentKeyName =  parentProperty.name >
        </#if>
       </#if>
      </#if>
     </#if>
     <#if c2h.isManyToOne(parentProperty)>
      <#assign parentParentPojo = c2j.getPOJOClass(cfg.getClassMapping(parentProperty.value.referencedEntityName))>
      <#if parentParentPojo.isComponent(parentParentPojo.identifierProperty)>
       <#foreach componentProperty in parentParentPojo.identifierProperty.value.propertyIterator>
       </#foreach>
      <#else>

      </#if>
     </#if>
    </#foreach>
     <#assign lastOfKeys= property.columnIterator.next().name>
     <#assign columnName ="  ">

     <#assign columnNameKey= componentName+lastOfKeys?lower_case?cap_first+"One">


     <#if columnNameKey == "trxxuq37vshipmenMatcodeOne">
     <#elseif columnNameKey == "trxxuq37vshipmenCustomerOne">
       <#assign columnName ="d2xxudrrbvxxcustomer">
     <#elseif columnNameKey == "trxxuq37vshipmenShipcodeOne">
       <#assign columnName ="d5xxuhbrbvxxshiptocode">
     <#elseif columnNameKey == "trxxuq37vshipmenMailtocodeOne">
       <#assign columnName ="d4xxugbrbvxxmailtocode">
     </#if> 

     <#if columnNameKey == "trxxuq36venquoteMatcodeOne">
       <#assign columnName ="b3xxudiravxxmatcode">
     <#elseif columnNameKey == "trxxuq36venquoteVendorOne">
       <#assign columnName ="b2xxudvvlxxxvendor">
     <#elseif columnNameKey == "trxxuq36venquoteDepcodeOne">
       <#assign columnName ="yaxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trxxuq36venquoteDivcodeOne">
       <#assign columnName ="y9xxuxoxbvxxdivcode">
     <#elseif columnNameKey == "trxxuq36venquoteXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trxxuq36vinvoiceAgentOne">
       <#assign columnName ="c1xxudttblxxxagent">
     </#if> 

     <#if columnNameKey == "trxxuq23cuquoteMatcodeOne">
       <#assign columnName ="b4xxudiravxxmatcode">
     <#elseif columnNameKey == "trxxuq23cuquoteCustomerOne">
       <#assign columnName ="b3xxudrravnxcustomer">
     <#elseif columnNameKey == "trxxuq23cuquoteContactcOne">
       <#assign columnName ="y2xxugrcavxxcontactc">
     <#elseif columnNameKey == "trxxuq23cuquoteDepcodeOne">
       <#assign columnName ="ydxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trxxuq23cuquoteDivcodeOne">
       <#assign columnName ="ycxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trxxuq23cuquoteXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trxxuq23cuquoteAgentOne">
       <#assign columnName ="c1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trxxuq26cuinvoiceMatcodeOne">
       <#assign columnName ="b2xxudiravxxmatcode">
     <#elseif columnNameKey == "trxxuq26cuinvoiceCustomerOne">
       <#assign columnName ="b1xxudrravnxcustomer">
     <#elseif columnNameKey == "trxxuq26cuinvoiceContactcOne">
       <#assign columnName ="y1xxudrcavxxcontactc">
     <#elseif columnNameKey == "trxxuq26cuinvoiceDepcodeOne">
       <#assign columnName ="y9xxuxexbvxxdepcode">
     <#elseif columnNameKey == "trxxuq26cuinvoiceDivcodeOne">
       <#assign columnName ="y8xxuxoxbvxxdivcode">
     <#elseif columnNameKey == "trxxuq26cuinvoiceXshipcodeOne">
       <#assign columnName ="y5xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trxxuq26cuinvoiceAgentOne">
       <#assign columnName ="d1xxugttavxxagent">
     </#if> 

     <#if columnNameKey == "trxxuq92jobassignmentMatcodeOne">
       <#assign columnName ="b5xxuxxrbvxxmatcode">
     <#elseif columnNameKey == "trxxuq92jobassignmentCustomerOne">
       <#assign columnName ="baxxuxxrbvxxcustomer">
     <#elseif columnNameKey == "trxxuq92jobassignmentVendorOne">
       <#assign columnName ="b8xxudvvbvxxvendor">
     <#elseif columnNameKey == "trxxuq92jobassignmentPrevjobOne">
       <#assign columnName ="z1xxuxxrbvxxprevjob">
     <#elseif columnNameKey == "trxxuq92jobassignmentNextjobOne">
       <#assign columnName ="z2xxuxxrbvxxnextjob">
     <#elseif columnNameKey == "trxxuq92jobassignmentJobno">
       <#assign columnName ="b4xxuxxrbvxxjobno">
     </#if> 

     <#if columnNameKey == "trxxuq36vinvoiceMatcodeOne">
       <#assign columnName ="b2xxudiravxxmatcodematcode">
     <#elseif columnNameKey == "trxxuq36vinvoiceVendorOne">
       <#assign columnName ="b1xxudvvlxxxvendor">
     <#elseif columnNameKey == "trxxuq36vinvoiceDepcodeOne">
       <#assign columnName ="ybxxuxeybvxxdepcode">
     <#elseif columnNameKey == "trxxuq36vinvoiceDivcodeOne">
       <#assign columnName ="yaxxuxoybvxxdivcode">
     <#elseif columnNameKey == "trxxuq36vinvoiceXshipcodeOne">
       <#assign columnName ="y8xxuxxrblxxxshipcode">
     <#elseif columnNameKey == "trxxuq36vinvoiceAgentOne">
       <#assign columnName ="d1xxudttavxxagent">
     </#if> 

     <#if columnNameKey == "trxxuq36vpaymentMatcodeOne">
       <#assign columnName ="b2xxudiravxxmatcode">
     <#elseif columnNameKey == "trxxuq36vpaymentVendorOne">
       <#assign columnName ="b1xxudvvbvxxvendor">
     </#if> 

   <#if (property.name?length > 12) >
    <#if property.name?substring(5,6)=="n">
     <#assign entityFunction = property.name?substring(6,8)>
    </#if>
   </#if>
   <#if (columnName?length > 12) >
   <#if (columnName?substring(5,6)=="d") || (columnName?substring(5,6)=="g") >
    <#if columnName?substring(6,7)=="i">
     <#assign selectEntityName=itemEntityName>
     <#assign selectEntityFieldName=itemEntityItemFieldName>
    <#elseif  columnName?substring(6,8)=="rr">
      <#assign selectEntityName=customerEntityName>
      <#assign selectEntityFieldName=customerEntityCustomerFieldName>
    <#elseif  columnName?substring(6,8)=="rc">
      <#assign selectEntityName=customerContactEntityName>
      <#assign selectEntityFieldName=customerContactEntityContactFieldName>
    <#elseif  columnName?substring(6,8)=="ss">
      <#assign selectEntityName=tableEntityName>
      <#assign selectEntityFieldName=tableEntityTableFieldName>
    <#elseif  columnName?substring(6,8)=="vv">
     <#assign selectEntityName=vendorEntityName>
     <#assign selectEntityFieldName=vendorEntityVendorFieldName>
    <#elseif  columnName?substring(6,8)=="vc">
     <#assign selectEntityName=vendorContactEntityName>
     <#assign selectEntityFieldName=vendorContactEntityContactFieldName>
    <#elseif  columnName?substring(2,3)=="t">
     <#assign selectEntityName=employeeEntityName>
     <#assign selectEntityFieldName=employeeEntityEmployeeFieldName>
    <#elseif  columnName?substring(2,3)=="b" || columnName?substring(2,3)=="a">
     <#assign selectEntityName=addressEntityName>
     <#assign selectEntityFieldName=addressEntityAddressFieldName>
    <#else>
     <#assign selectEntityName=parentName>
     <#assign selectEntityFieldName= parentKeyName>
     <#if selectEntityName?length <9 >
       <#assign selectEntityName=parentName+"xxxxxxxxx">
     </#if>
     <#if selectEntityFieldName?length <13 >
       <#assign selectEntityFieldName=parentName+"Id">
     </#if>
    </#if>
    <#if firstTime=="Y">
     <h:panelGrid columns="4">
     <#assign firstTime="N"> 
    </#if>
            <#if (columnName?length > 12) >
             <ui:decorate id="${columnName}DecorationT" template="layout/edit.xhtml">
               <ui:define name="label">${'#'}{messages['${columnName?substring(12)?cap_first}']} 
               </ui:define>
               <#if (columnName?substring(5,6)=="d" || columnName?substring(5,6)=="g"  ) >
                <p:comboBox id="${columnName}IdT"  
                 <#if  columnName?substring(6,8)=="rc">
                  value="${'#'}{${selectEntityName}Home.${selectEntityName}Id.${selectEntityFieldName}}"  
                 <#elseif columnName?substring(6,8)=="vc">
                  value="${'#'}{${selectEntityName}Home.${selectEntityNameF}Id.${selectEntityFieldName}}"  
                 <#else>
                  value="${'#'}{${selectEntityName}Home.instance.${selectEntityFieldName}}"  
                  suggestionValues= "${'#'}{${selectEntityName}List.${selectEntityName?substring(eL)}KeyList}" directInputSuggestions="true" defaultLabel="Enter value or select .." 
                 </#if>
                <#if (columnName?substring(5,6)=="d" && (columnName?substring(6,8)!="rc" && columnName?substring(2,3)!="b" )) >
                 required="true"
                </#if>
                 immediate="true"
                 validator="${'#'}{${componentName}Home.validateAndSelect${selectEntityFieldName?substring(12)?cap_first}}"  >
                <a:support event="onselect" reRender="matcodeDescriptDecoration,matcodePriceLabelT"
                  bypassUpdates="true"/>
                </p:comboBox>
               <#else>
                <h:inputText id="${columnName}IdT" 
                <#if (columnName?substring(5,6)=="d" && (columnName?substring(6,8)!="rc" || columnName?substring(2,3)!="b" )) >
                 required="true"
                </#if>
                 size="20"
                 maxlength="20"
                 <#if  columnName?substring(6,8)=="rc">
                  value="${'#'}{${selectEntityName}Home.${selectEntityName}Id.${selectEntityFieldName}}"  
                 <#elseif columnName?substring(6,8)=="vc">
                  value="${'#'}{${selectEntityName}Home.${selectEntityNameF}Id.${selectEntityFieldName}}"  
                 <#else>
                  value="${'#'}{${selectEntityName}Home.instance.${selectEntityFieldName}}"  
                 </#if>
                 validator="${'#'}{${componentName}Home.validateAndSelect${selectEntityFieldName?substring(12)?cap_first}}"  >
                </h:inputText>
               </#if>
             </ui:decorate>
            </#if>
    <#if selectEntityName=itemEntityName>
             <#assign itemSelected="Y">
             <ui:decorate id="matcodeDescriptDecoration" template="layout/edit.xhtml" rendered="true">
             <ui:define name="label">${'#'}{messages['${itemDescriptionField?substring(12)?cap_first}']}
             </ui:define>
        	 <h:inputText id="matcodeDescriptDecorationT" value="${'#'}{${itemEntityName}Home.instance.${itemDescriptionField}}"  
                 disabled="true" >
             </h:inputText>
             </ui:decorate>
             <ui:decorate id="matcodePriceLabelT" template="layout/edit.xhtml" rendered="true">
             <ui:define name="label">${'#'}{messages['${itemPriceField?substring(12)?cap_first}']}
             </ui:define>
        	 <h:inputText id="matcodePriceDecorationT" value="${'#'}{${itemEntityName}Home.instance.${itemPriceField}}"     
                  disabled="true" >
             </h:inputText>
             </ui:decorate>

     <#if entityFunction=="cq" || entityFunction=="co" || entityFunction=="ci"  || entityFunction=="sh" > 
      <#if entityFunction=="cq">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerQuoteItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>
      <#if entityFunction=="co">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerOrderItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerOrderItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerOrderItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerOrderItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerOrderItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerOrderItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerOrderItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerOrderItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerOrderItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerOrderItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerOrderItemDetailsQtyFieldName>
      </#if>
      <#if entityFunction=="ci">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerInvoiceItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerInvoiceItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerInvoiceItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerInvoiceItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerInvoiceItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerInvoiceItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerInvoiceItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerInvoiceItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerInvoiceItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerInvoiceItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerInvoiceItemDetailsQtyFieldName>
      </#if>
      <#if entityFunction=="sh">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerQuoteItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>

            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" rendered="true">
            <ui:define name="label">${'#'}{messages['Qtyordrd']}
            </ui:define>

                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsQtyFieldName}}"
                           size="21">
                    <a:support event="onblur" reRender="ztprlxxxamounttotalDecoration" bypassUpdates="false"/>
                </h:inputText>
            </ui:decorate>
     </#if>

     <#if entityFunction=="cp" > 
      <#if entityFunction=="cp">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerQuoteItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>

            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" rendered="true">
            <ui:define name="label">${'#'}{messages['Qtyordrd']}
            </ui:define>

                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsQtyFieldName}}"
                           size="21">
                    <a:support event="onblur" reRender="ztprlxxxamounttotalDecoration" bypassUpdates="false"/>
                </h:inputText>
            </ui:decorate>
     </#if>

     <#if entityFunction=="ij" || entityFunction=="aj"  > 
      <#if entityFunction=="ij">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerQuoteItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>

      <#if entityFunction=="aj">
       <#assign customerInvoiceEtcItemDetailsEntityName=customerQuoteItemDetailsEntityName>
       <#assign customerInvoiceEtcItemDetailsID1FieldName=customerQuoteItemDetailsID1FieldName>
       <#assign customerInvoiceEtcItemDetailsID2FieldName=customerQuoteItemDetailsID2FieldName>
       <#assign customerInvoiceEtcItemDetailsPriceFieldName=customerQuoteItemDetailsPriceFieldName>
       <#assign customerInvoiceEtcItemDetailsTax1FieldName=customerQuoteItemDetailsTax1FieldName>
       <#assign customerInvoiceEtcItemDetailsTax2FieldName=customerQuoteItemDetailsTax2FieldName>
       <#assign customerInvoiceEtcItemDetailsTax3FieldName=customerQuoteItemDetailsTax3FieldName>
       <#assign customerInvoiceEtcItemDetailsUnitFieldName=customerQuoteItemDetailsUnitFieldName>
       <#assign customerInvoiceEtcItemDetailsDeliveryFieldName=customerQuoteItemDetailsDeliveryFieldName>
       <#assign customerInvoiceEtcItemDetailsMiscelleneousFieldName=customerQuoteItemDetailsMiscelleneousFieldName>
       <#assign customerInvoiceEtcItemDetailsQtyFieldName=customerQuoteItemDetailsQtyFieldName>
      </#if>
            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" rendered="true">
    <ui:define name="label">${'#'}{messages['Qtyordrd']}
   </ui:define>

                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsQtyFieldName}}"
                           size="21">
                    <a:support event="onblur" reRender="ztprlxxxamounttotalDecoration" bypassUpdates="false"/>
                </h:inputText>
            </ui:decorate>
     </#if>

     <#if entityFunction=="vq" || entityFunction=="vo" || entityFunction=="vi"  > 
      <#if entityFunction=="vq">
       <#assign vendorInvoiceEtcItemDetailsEntityName=vendorQuoteItemDetailsEntityName>
       <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorQuoteItemDetailsID1FieldName>
       <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorQuoteItemDetailsID2FieldName>
       <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorQuoteItemDetailsPriceFieldName>
       <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorQuoteItemDetailsTax1FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorQuoteItemDetailsTax2FieldName>
       <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorQuoteItemDetailsTax3FieldName>
       <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorQuoteItemDetailsUnitFieldName>
  <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorQuoteItemDetailsDeliveryFieldName>
  <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorQuoteItemDetailsMiscelleneousFieldName>
  <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorQuoteItemDetailsQtyFieldName>
      </#if>
      <#if entityFunction=="vo">
  <#assign vendorInvoiceEtcItemDetailsEntityName=vendorOrderItemDetailsEntityName>
  <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorOrderItemDetailsID1FieldName>
  <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorOrderItemDetailsID2FieldName>
  <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorOrderItemDetailsPriceFieldName>
  <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorOrderItemDetailsTax1FieldName>
  <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorOrderItemDetailsTax2FieldName>
  <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorOrderItemDetailsTax3FieldName>
  <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorOrderItemDetailsUnitFieldName>
  <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorOrderItemDetailsDeliveryFieldName>
  <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorOrderItemDetailsMiscelleneousFieldName>
  <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorOrderItemDetailsQtyFieldName>
      </#if>
      <#if entityFunction=="vi">
  <#assign vendorInvoiceEtcItemDetailsEntityName=vendorInvoiceItemDetailsEntityName>
  <#assign vendorInvoiceEtcItemDetailsID1FieldName=vendorInvoiceItemDetailsID1FieldName>
  <#assign vendorInvoiceEtcItemDetailsID2FieldName=vendorInvoiceItemDetailsID2FieldName>
  <#assign vendorInvoiceEtcItemDetailsPriceFieldName=vendorInvoiceItemDetailsPriceFieldName>
  <#assign vendorInvoiceEtcItemDetailsTax1FieldName=vendorInvoiceItemDetailsTax1FieldName>
  <#assign vendorInvoiceEtcItemDetailsTax2FieldName=vendorInvoiceItemDetailsTax2FieldName>
  <#assign vendorInvoiceEtcItemDetailsTax3FieldName=vendorInvoiceItemDetailsTax3FieldName>
  <#assign vendorInvoiceEtcItemDetailsUnitFieldName=vendorInvoiceItemDetailsUnitFieldName>
  <#assign vendorInvoiceEtcItemDetailsDeliveryFieldName=vendorInvoiceItemDetailsDeliveryFieldName>
  <#assign vendorInvoiceEtcItemDetailsMiscelleneousFieldName=vendorInvoiceItemDetailsMiscelleneousFieldName>
  <#assign vendorInvoiceEtcItemDetailsQtyFieldName=vendorInvoiceItemDetailsQtyFieldName>
      </#if>
            <ui:decorate id="itemQuantitygx1Decoration" template="layout/edit.xhtml" rendered="true">
    <ui:define name="label">${'#'}{messages['Qtyordrd']}
   </ui:define>

                <h:inputText id="itemquantityx1" 
                          value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsQtyFieldName}}"
                           size="21">
                    <a:support event="onblur" reRender="ztprlxxxamounttotalDecoration" bypassUpdates="false"/>
                </h:inputText>
            </ui:decorate>
     </#if>

    </#if>
   </#if>
   </#if>
  <#else>
   <#if (property.name?length > 12) >
   <#if property.name?substring(5,6)=="n">
    <#assign entityFunction = property.name?substring(6,8)>
   </#if>
   </#if>
  </#if>
 </#if>
</#foreach>
<#-- The above added selects for the various foreign keys as needed. 
-->    
<#if  firstTime="N">
     <#-- may not be needed because item is part of parent -->
     <#if itemSelected =="N" &&(entityFunction == "cq" || entityFunction == "co" || entityFunction == "ci" || entityFunction == "vq"  || entityFunction == "vo" || entityFunction == "vi") >
             <#assign selectEntityName=itemEntityName>
             <#assign selectEntityFieldName=itemEntityItemFieldName>
             <#assign itemSelected="Y">
             <ui:decorate id="selectItemg0DecorationT" template="layout/edit.xhtml">
                <ui:define name="label">${'#'}{messages['${selectEntityName?cap_first}']} 
                </ui:define>
                        <h:inputText id="selItemg0IdT" 
                       required="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${selectEntityName}Home.instance.${selectEntityFieldName}}"  
                 validator="${'#'}{${componentName}Home.validateAndSelect${selectEntityFieldName?substring(12)?cap_first}}"  >
                        </h:inputText>
             </ui:decorate>
             <h:button value="Select ${'#'}{messages['${selectEntityName?cap_first}']}"
	              id="editSelectButton${selectEntityName}Id1T"
                      outcome="/${selectEntityName?substring(eL)?cap_first}List.xhtml">
                <f:param name="from" value="${entityName}Edit"/>
             </h:button>

         	 <h:outputText id="matcodeDescriptLabelT" value="Description" 
                   rendered="${'#'}{${itemEntityName}Home.instance.${itemEntityItemFieldName} != null}"   />

        	 <h:outputText id="matcodeDescriptDecorationT" value="${'#'}{${itemEntityName}Home.instance.${itemDescriptionField}}" 
                   rendered="${'#'}{${itemEntityName}Home.instance.${itemEntityItemFieldName} != null}"   />

        	 <h:outputText id="matcodePriceLabelT" value="Price" 
                   rendered="${'#'}{${itemEntityName}Home.instance.${itemEntityItemFieldName} != null}"   />

        	 <h:outputText id="matcodePriceDecorationT" value="${'#'}{${itemEntityName}Home.instance.${itemPriceField}}"     
                   rendered="${'#'}{${itemEntityName}Home.instance.${itemEntityItemFieldName} != null}"   />

            <ui:decorate id="itemQuantityg1Decoration" template="layout/edit.xhtml" rendered="false">
    <ui:define name="label">${'#'}{messages['Qtyordrd']}
   </ui:define>

                <h:inputText id="itemquantityg2" 
                          value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsQtyFieldName}}"
                           size="21">
                    <a:support event="onblur" reRender="ztprlxxxamounttotalDecoration" bypassUpdates="true"/>
                </h:inputText>
            </ui:decorate>
    </#if>
 </h:panelGrid>
</#if>

<#--
 The following checks the prefix values to identify the prpoperty's function like price field, tax1 field
   etc for the current entity and are used in the next section where editproperty.xhml.ftl is called for each 
   property. editproperty.xhml.ftl generates the inputtexts so that values can be keyed in
-->
<#foreach property in pojo.allPropertiesIterator>
<#if c2j.isComponent(property)>
 <#foreach componentProperty in property.value.propertyIterator>
 </#foreach>
<#else>
 <#if (property.name?length > 12) >
 <#if property.name?substring(5,6)=="m">
  <#assign miscchrgField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="l">
  <#assign deliveryField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="p">
  <#assign priceField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="q">
  <#assign qtyField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="c">
  <#assign costField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="1">
  <#assign tax1Field=property.name>
 </#if>
 <#if property.name?substring(5,6)=="2">
  <#assign tax2Field=property.name>
 </#if>
 <#if property.name?substring(5,6)=="3">
  <#assign tax3Field=property.name>
 </#if>
 <#if property.name?substring(5,6)=="u">
  <#assign unitField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="v" || property.name?substring(5,7)=="dv" ||  property.name?substring(5,7)=="fv">
  <#assign vendorField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="t" || property.name?substring(5,7)=="dt"  || property.name?substring(5,7)=="ft">
  <#assign employeeField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="r" || property.name?substring(5,7)=="dr"  || property.name?substring(5,7)=="fr">
  <#assign customerField=property.name>
 </#if>
 <#if  property.name?substring(5,7)=="do" ||  property.name?substring(5,7)=="fo">
  <#assign divisionField=property.name>
 </#if>
 <#if property.name?substring(5,6)=="e" || property.name?substring(5,7)=="de" ||  property.name?substring(5,7)=="fe">
  <#assign departmentField=property.name>
 </#if>
 <#if property.name?substring(12) == "owner" >
 </#if>
 <#if property.name?substring(5,6)=="s">
  <#assign keyfromsubkeys="Y">
 </#if>
 </#if>
</#if>
</#foreach>
<#assign togglePanel="Y">
<#--
 below generated by editProperty.xhtml.ftl
 It is assumed that property prefixes forces them to be in order ie visible ones first and the simple toggle
 followed by hidden ones
-->

<#foreach property in pojo.allPropertiesIterator>
 <#if property.name?substring(0,1) == "y" || property.name?substring(0,1) == "z"   >
  <#if togglePanel="Y">
   </h:panelGrid>
   <p:simpleTogglePanel label="${'#'}{messages['EditToggle']}" switchType="client" opened="false">
   <#assign togglePanel="N"> 
   <h:panelGrid columns="4">
  </#if>  
 </#if>
  <#include "editproperty.xhtml.ftl">
</#foreach>

<#if togglePanel ="N">
   </h:panelGrid>
   </p:simpleTogglePanel>
<#else>
   </h:panelGrid>
</#if>
<#--
The following adds total sub panel for transaction entities only
-->
<#if pojo.shortName?upper_case?substring(0,8)?contains ("T")>
              <p:panel>
               <ui:decorate id="totals" template="layout/edit.xhtml">
                <ui:define name="label">Totals</ui:define>
               </ui:decorate>
               <h:panelGrid columns="2">
             
                <ui:decorate id="matcodeTDecoration" template="layout/edit.xhtml">
                 <ui:define name="label">${'#'}{messages['${itemEntityItemFieldName?substring(12)?cap_first}']} Line Total</ui:define>
                        <h:inputText id="matcodeId2T" 
                       disabled="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${homeName}.elt}"   >
                        </h:inputText>
                </ui:decorate>
               <#if (miscchrgField?length > 12)>
                <ui:decorate id="matcodeDecorationmis" template="layout/edit.xhtml">
                 <ui:define name="label">${'#'}{messages['${miscchrgField?substring(12)?cap_first}']}</ui:define>
                        <h:inputText id="miscchrgIdT" 
                       disabled="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totalmis}"   >
                        </h:inputText>
                </ui:decorate>
               </#if>


               <#if (deliveryField?length > 12)>
                <ui:decorate id="matcodeDecorationdelT" template="layout/edit.xhtml">
                 <ui:define name="label">${'#'}{messages['${deliveryField?substring(12)?cap_first}']}</ui:define>
                        <h:inputText id="delvchrgId" 
                       disabled="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaldel}"   >
                        </h:inputText>
                </ui:decorate>
               </#if>

               <#if (tax1Field?length > 12)>
                <ui:decorate id="matcodeDecorationtax1T" template="layout/edit.xhtml">
                 <ui:define name="label">${'#'}{messages['${tax1Field?substring(12)?cap_first}']}</ui:define>
                        <h:inputText id="tax1TId" 
                       disabled="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaltax1}"   >
                        </h:inputText>
                </ui:decorate>
               </#if>
               <#if (tax2Field?length > 12)>
                <ui:decorate id="matcodeDecorationtax2T" template="layout/edit.xhtml">
                 <ui:define name="label">${'#'}{messages['${tax2Field?substring(12)?cap_first}']}</ui:define>
                        <h:inputText id="tax2TId" 
                       disabled="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaltax2}"   >
                        </h:inputText>
                </ui:decorate>
               </#if>
               <#if (tax3Field?length > 12)>
                <ui:decorate id="matcodeDecorationtax3T" template="layout/edit.xhtml">
                 <ui:define name="label">${'#'}{messages['${tax3Field?substring(12)?cap_first}']}</ui:define>
                        <h:inputText id="tax3TId" 
                       disabled="true"
                                   size="20"
                              maxlength="20"
                                  value="${'#'}{${homeName}.totaltax3}"   >
                        </h:inputText>
                </ui:decorate>
               </#if>

         </h:panelGrid>
             

              </p:panel>
</#if>

        
            <div style="clear:both">
                <span class="required">*</span> 
                required fields
            </div>
            
        </p:panel>
                
        <div class="actionButtons">

     <#if entityFunction=="cq" || entityFunction=="co" || entityFunction=="ci" || entityFunction == "vq"  || entityFunction == "vo" || entityFunction == "vi" > 

            <h:commandButton id="save" 
                          value="Save" 
                         action="${'#'}{${homeName}.persist}"
                       disabled="${'#'}{!${homeName}.wired}"
                       rendered="${'#'}{!${homeName}.managed || ${homeName}.moreActive}"/>  
                          			  
            <h:commandButton id="update" 
                          value="Update" 
                         action="${'#'}{${homeName}.update}"
                       rendered="${'#'}{${homeName}.managed  || !${homeName}.moreActive}"/>
                        			  
            <h:commandButton id="delete" 
                          value="Delete" 
                         action="${'#'}{${homeName}.remove}"
                       rendered="${'#'}{${homeName}.managed}"/>
      <#if componentName=="cuorders">
            <h:commandButton id="deleteall" 
                          value="Delete All" 
                         action="${'#'}{${homeName}.removeall}"
                       rendered="${'#'}{${homeName}.multipicked}"/>
      </#if>
            <h:commandButton id="more" 
                          value="More" 
                         action="${'#'}{${homeName}.more}"
                       disabled="${'#'}{${homeName}.moreActive}"
                       rendered="${'#'}{${homeName}.picked}"/>
     <#else>
            <h:commandButton id="save" 
                          value="Save" 
                         action="${'#'}{${homeName}.persist}"
                       disabled="${'#'}{!${homeName}.wired}"
                       rendered="${'#'}{!${homeName}.managed}"/>  
                          			  
            <h:commandButton id="update" 
                          value="Update" 
                         action="${'#'}{${homeName}.update}"
                       rendered="${'#'}{${homeName}.managed}"/>
                        			  
            <h:commandButton id="delete" 
                          value="Delete" 
                         action="${'#'}{${homeName}.remove}"
                       rendered="${'#'}{${homeName}.managed}"/>
     </#if>                   			  

            <h:commandButton id="print" value="Print"  action="${'#'}{${listName}.print}"/>

            <f:param name="reportName" value="${'#'}{${listName}.${reportName}}"/>
            <f:param name="displayAs" value="${'#'}{${listName}.${displayAs}}" /> 

            <h:button id="done" 
                   value="Done"
             propagation="end"
                    outcome="/${menuPageName}.xhtml"
                rendered="${'#'}{${homeName}.managed}"/>
                
            <h:button id="cancel" 
                   value="Cancel"
             propagation="end"
                    outcome="/${'#'}{empty ${componentName}From ? '${menuPageName}' : ${componentName}From}.xhtml"
                rendered="${'#'}{!${homeName}.managed}"/>

            <#if componentName=="cuorders">
             <h:commandButton id="next" 
                          value="Next" 
                         action="${'#'}{${homeName}.next}"
                       rendered="${'#'}{${homeName}.multipicked}"/>
             <h:commandButton id="prev" 
                          value="Prev" 
                         action="${'#'}{${homeName}.prev}"
                       rendered="${'#'}{${homeName}.multipicked}"/>
           </#if>
             <ui:decorate id="pjay" template="layout/edit.xhtml">
               <ui:define name="label">${'#'}{messages['PrintStart']} 
               </ui:define>
                <p:comboBox id="pstart"  
                  value="${'#'}{${listName}.start}"  
                  suggestionValues= "${'#'}{${listName}.${componentName?substring(eL)}KeyList}" directInputSuggestions="true" defaultLabel="Enter value or select .." 
                 immediate="true" >
                <a:support event="onselect" reRender="matcodeDescriptDecoration,matcodePriceLabelT"
                  bypassUpdates="true"/>
                </p:comboBox>
              </ui:decorate>
             <ui:decorate id="pjaye" template="layout/edit.xhtml">
               <ui:define name="label">${'#'}{messages['PrintEnd']} 
               </ui:define>
                <p:comboBox id="pend"  
                  value="${'#'}{${listName}.end}"  
                  suggestionValues= "${'#'}{${listName}.${componentName?substring(eL)}KeyList}" directInputSuggestions="true" defaultLabel="Enter value or select .." 
                 immediate="true" >
                <a:support event="onselect" reRender="matcodeDescriptDecoration,matcodePriceLabelT"
                  bypassUpdates="true"/>
                </p:comboBox>
              </ui:decorate>

        </div>



    </h:form>
<p:simpleTogglePanel label="${'#'}{messages['EditToggle']}" switchType="server" opened="false">

<#assign hasAssociations=false>
<#foreach property in pojo.allPropertiesIterator>
 <#if c2h.isManyToOne(property) || c2h.isOneToManyCollection(property)>
  <#assign hasAssociations=true>
 </#if>
</#foreach>

<#if hasAssociations>
 <p:tabPanel switchType="ajax">
</#if>
<#foreach property in pojo.allPropertiesIterator>
 <#if c2h.isManyToOne(property)>
  <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
  <#assign parentPageName = parentPojo.shortName>
  <#assign parentName = util.lower(parentPojo.shortName)>
    
  <#if property.optional>
    <p:tab label="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
  <#else>
    <p:tab label="${'#'}{messages['${property.name?substring(pL)?cap_first}']}*" labelClass="required">
  </#if>
    <div class="association" id="${property.name}Parent">
    
        <h:outputText value="No ${property.name?substring(pL)} Selected" 
                   rendered="${'#'}{${homeName}.instance.${property.name} == null}"/>
        
        <p:dataTable var="${parentName}" 
                   value="${'#'}{${homeName}.instance.${property.name}}" 
                rendered="${'#'}{${homeName}.instance.${property.name} != null}"
              rowClasses="rvgRowOne,rvgRowTwo"
                      id="${property.name}Table">
  <#foreach parentProperty in parentPojo.allPropertiesIterator>
   <#if !c2h.isCollection(parentProperty) && !c2h.isManyToOne(parentProperty)>
    <#if parentPojo.isComponent(parentProperty)>
     <#foreach componentProperty in parentProperty.value.propertyIterator>
            <h:column>
                <f:facet name="header">${componentProperty.name?substring(12)}</f:facet>
                ${'#'}{${parentName}.${parentProperty.name}.${componentProperty.name}}
            </h:column>
     </#foreach>
    <#else>
            <h:column>
                <f:facet name="header">${parentProperty.name?substring(12)}</f:facet>
                ${'#'}{${parentName}.${parentProperty.name}}
            </h:column>
    </#if>
   </#if>
   <#if c2h.isManyToOne(parentProperty)>
    <#assign parentParentPojo = c2j.getPOJOClass(cfg.getClassMapping(parentProperty.value.referencedEntityName))>
    <#if parentParentPojo.isComponent(parentParentPojo.identifierProperty)>
     <#foreach componentProperty in parentParentPojo.identifierProperty.value.propertyIterator>
            <h:column>
	    	    <f:facet name="header">${parentProperty.name?substring(8)} ${componentProperty.name?substring(12)}</f:facet>
		    	${'#'}{${parentName}.${parentProperty.name}.${parentParentPojo.identifierProperty.name}.${componentProperty.name}}
            </h:column>
     </#foreach>
    <#else>
            <h:column>
	    	    <f:facet name="header">${parentProperty.name?substring(8)} ${parentParentPojo.identifierProperty.name?substring(12)}</f:facet>
		    	${'#'}{${parentName}.${parentProperty.name}.${parentParentPojo.identifierProperty.name}}
            </h:column>
    </#if>
   </#if>
  </#foreach>
            <h:column>
                <f:facet name="header">action</f:facet>
                <h:link outcome="/${parentPageName}.xhtml" 
                         id="view${parentName}" 
                      value="View" 
                propagation="none">
  <#if parentPojo.isComponent(parentPojo.identifierProperty)>
   <#foreach componentProperty in parentPojo.identifierProperty.value.propertyIterator>
                    <f:param name="${parentName}${util.upper(componentProperty.name)}" 
                            value="${'#'}${parentName}.${parentPojo.identifierProperty.name}.${componentProperty.name}"/>
   </#foreach>
  <#else>
                    <f:param name="${parentName}${util.upper(parentPojo.identifierProperty.name)}" 
                           value="${'#'}${parentName}.${parentPojo.identifierProperty.name}"/>
  </#if>
                </h:link>
            </h:column>
        </p:dataTable>

  <#if parentPojo.shortName!=pojo.shortName>
        <div class="actionButtons">
            <h:button value="Select ${property.name?substring(pL)}"
                       outcome="/${parentPageName}List.xhtml">
                <f:param name="from" value="${pageName}Edit"/>
            </h:button>
        </div>
        
  </#if>
    </div>
    </p:tab>
 </#if>
 <#if c2h.isOneToManyCollection(property)>

    <p:tab label="${'#'}{messages['${property.name?substring(pL,property.name?length-1)?cap_first}']}">
        <div class="association" id="${property.name}Children">
        
  <#assign childPojo = c2j.getPOJOClass(property.value.element.associatedClass)>
  <#assign childPageName = childPojo.shortName>
  <#assign childEditPageName = childPojo.shortName + "Edit">
  <#assign childName = util.lower(childPojo.shortName)>
            <h:outputText value="No ${property.name?substring(pL)}" 
                       rendered="${'#'}{empty ${homeName}.${property.name}}"/>
        
            <p:dataTable value="${'#'}{${homeName}.${property.name}}" 
                           var="${childName}" 
                      rendered="${'#'}{not empty ${homeName}.${property.name}}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="${property.name}Table">
  <#foreach childProperty in childPojo.allPropertiesIterator>
   <#if !c2h.isCollection(childProperty) && !c2h.isManyToOne(childProperty)>
    <#if childPojo.isComponent(childProperty)>
     <#foreach componentProperty in childProperty.value.propertyIterator>
                <h:column>
                    <f:facet name="header">${componentProperty.name?substring(12)}</f:facet>
                    ${'#'}{${childName}.${childProperty.name}.${componentProperty.name}}
                </h:column>
     </#foreach>
    <#else>
                <h:column>
                    <f:facet name="header">${childProperty.name?substring(12)}</f:facet>
                    <h:outputText value="${'#'}{${childName}.${childProperty.name}}"/>
                </h:column>
    </#if>
   </#if>
  </#foreach>
                <h:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/${childPageName}.xhtml" 
                              id="select${childName}" 
                           value="Select"
                     propagation="none">
  <#if childPojo.isComponent(childPojo.identifierProperty)>
   <#foreach componentProperty in childPojo.identifierProperty.value.propertyIterator>
                        <f:param name="${childName}${util.upper(componentProperty.name)}" 
                                value="${'#'}{${childName}.${childPojo.identifierProperty.name}.${componentProperty.name}}"/>
   </#foreach>
  <#else>
                        <f:param name="${childName}${util.upper(childPojo.identifierProperty.name)}" 
                                value="${'#'}{${childName}.${childPojo.identifierProperty.name}}"/>
  </#if>
                        <f:param name="${childName}From" value="${entityName}"/>
                    </h:link>
                </h:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{${homeName}.managed}" id="${property.name}">
        <div class="actionButtons">
            <h:button id="add${childName}" 
                   value="Add ${childName?substring(8)}"
                    outcome="/${childEditPageName}.xhtml"
             propagation="none">
                 <f:param name="${componentName}${util.upper(pojo.identifierProperty.name)}" 
                         value="${'#'}{${homeName}.instance.${pojo.identifierProperty.name}}"/>
                 <f:param name="${childName}From" value="${entityName}"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>
 </#if>
</#foreach>
<#if hasAssociations>
 </p:tabPanel>
</#if>
</p:simpleTogglePanel>

</ui:define>

</ui:composition>

</#if>
