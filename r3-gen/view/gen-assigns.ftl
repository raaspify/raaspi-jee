<#assign tobegeneratedCandidate = "N">  
<#assign entityName = pojo.shortName>
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign tobegeneratedCandidate = "Y">  
<#if tobegeneratedCandidate == "Y">  

<#assign componentName = util.lower(entityName)>
<#assign option="">
<#assign genoptions="">
<#-- assign EntityNames --> 
<#if (componentName?substring(6,8) =="11")>
 <${'#'}assign addressEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="12")>
 <${'#'}assign departmentEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="13")>
 <${'#'}assign divisionEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="14")>
 <${'#'}assign locationEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="15")>
     <${'#'}assign residencyEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="16")>
     <${'#'}assign itembomEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="17")>
     <${'#'}assign controlusagebyperiodsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="18")>
     <${'#'}assign activityEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="19")>
     <${'#'}assign itemtemptypeEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1a")>
     <${'#'}assign itemEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1b")>
     <${'#'}assign usagebyperiodsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1l")>
     <${'#'}assign resource_bundleEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1c")>
     <${'#'}assign controlEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1d")>
     <${'#'}assign companyEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1f")>
     <${'#'}assign serialnumbersEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1g")>
     <${'#'}assign membersgroupEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1h")>
     <${'#'}assign itembomdetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1i")>
     <${'#'}assign scandateEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1k")>
     <${'#'}assign taskEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1m")>
     <${'#'}assign clobdataEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1n")>
     <${'#'}assign blobdataEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1p")>
     <${'#'}assign activityjobEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1q")>
     <${'#'}assign nextserialnoEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1r")>
     <${'#'}assign resourceEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1s")>
     <${'#'}assign seatEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="1t")>
     <${'#'}assign itemproflEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="20")>
     <${'#'}assign customerEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="21")>
     <${'#'}assign ccontactEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="23")>
     <${'#'}assign cuquoteEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="24")>
     <${'#'}assign cuordersEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="25")>
     <${'#'}assign shipmentEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="26")>
     <${'#'}assign cuinvoiceEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="27")>
     <${'#'}assign cpaymentEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="28")>
     <${'#'}assign cupdetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="29")>
     <${'#'}assign shipmentdetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="2a")>
     <${'#'}assign cuidetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="2b")>
     <${'#'}assign cuodetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="2c")>
     <${'#'}assign cuqdetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="2d")>
     <${'#'}assign resourcedetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="2e")>
     <${'#'}assign projectEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="30")>
     <${'#'}assign vendorEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="31")>
     <${'#'}assign vcontactEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="33")>
     <${'#'}assign venquoteEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="34")>
     <${'#'}assign vendordersEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="36")>
     <${'#'}assign venarthaEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="37")>
     <${'#'}assign vshipmenEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="38")>
     <${'#'}assign vpaymentEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="39")>
     <${'#'}assign vshipmendetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="3a")>
     <${'#'}assign vinvoiceEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="3b")>
     <${'#'}assign vendpdetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="3c")>
     <${'#'}assign vendidetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="3d")>
     <${'#'}assign vendodetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="3e")>
     <${'#'}assign vendqdetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="40")>
     <${'#'}assign employeeEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="44")>
     <${'#'}assign emplordersEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="45")>
     <${'#'}assign emplodetailsEntityName="${componentName}"> 
<#elseif (componentName?substring(6,8) =="51")>
     <${'#'}assign optionsEntityName="${componentName}">
     <${'#'}assign optionsEntity="Y">
<#elseif (componentName?substring(6,8) =="52")>
     <${'#'}assign clientEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="53")>
     <${'#'}assign rollupgroupEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="54")>
     <${'#'}assign groupmembersEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="55")>
     <${'#'}assign holidayEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="56")>
     <${'#'}assign userEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="57")>
     <${'#'}assign userproflEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="58")>
     <${'#'}assign genoptionsEntityName="${componentName}">
     <${'#'}assign genoptionsEntity="Y">
<#elseif (componentName?substring(6,8) =="59")>
     <${'#'}assign rate1fEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="5a")>
     <${'#'}assign truefalseEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="5b")>
     <${'#'}assign importcsvEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="60") >
     <${'#'}assign accountEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="62") >
     <${'#'}assign acperiodEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="63") >
     <${'#'}assign perioddatesEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="64") >
     <${'#'}assign acintegrEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="65") >
     <${'#'}assign glentriesEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="66") >
     <${'#'}assign gentriesDetailsEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="67") >
     <${'#'}assign cjournalEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="68") >
     <${'#'}assign journalEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="69") >
     <${'#'}assign jjournalEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="6a") >
     <${'#'}assign hlogfileEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="71") >
     <${'#'}assign wageearnerEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="72") >
     <${'#'}assign arthatblEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="73") >
     <${'#'}assign arthahistEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="74") >
     <${'#'}assign wageearnerauxEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="82") >
     <${'#'}assign editlogEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="89") >
     <${'#'}assign scheduleEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="8a") >
     <${'#'}assign projectEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="8b") >
     <${'#'}assign outlineEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="8c") >
     <${'#'}assign scheduleDetailsEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="92") >
     <${'#'}assign itemjobEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="93") >
     <${'#'}assign activityjobEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="94") >
     <${'#'}assign activityjobdetailsEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="9a") >
     <${'#'}assign jobassignmentEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="9b") >
     <${'#'}assign jobassignmentdetailsEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="9c") >
     <${'#'}assign processdetailsEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="9d") >
     <${'#'}assign itemjobdetailsEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="9e") >
     <${'#'}assign machineEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="9f") >
     <${'#'}assign processattributesEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="a1") >
     <${'#'}assign genappEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="a2") >
     <${'#'}assign gendbEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="a3") >
     <${'#'}assign gentableEntityName="${componentName}">
<#elseif (componentName?substring(6,8) =="a4") >
 <${'#'}assign genfieldsEntityName="${componentName}">
<#else>
 <#-- ${componentName}    -->
 <${'#'}jay ${componentName} >
 <${'#'}assign ??EntityName="not found, new table needs entry in gen-assigns.ftl">
</#if>
<#-- end if assign EntityNames --> 

<#-- Start of Entity Properties Actual Entity Name/property names can change, so functional names are used ie customer may be called 
     consumer intaddr may be called emailaddr but in template it will be referred as customerIntaddr
 --> 
<#foreach property in pojo.allPropertiesIterator>
 <#if c2j.isComponent(property)>
  <#foreach componentProperty in property.value.propertyIterator>
  </#foreach>
 <#else>
  <#if c2h.isCollection(property) >
  <#-- check entity and its properties -->
  <#-- options & genoptions logic is below and they use the same property function codes  ie p01 or v01--> 
  <#elseif (componentName?substring(6,8) =="51" | componentName?substring(6,8) =="58")>
   <#if (property.name?substring(5,8) =="o01")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField01="${property.name}">
     <#else>
      <${'#'}assign optionField01="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p01")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField01="${property.name}">
     <#else>
      <${'#'}assign purposeField01="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v01")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField01="${property.name}">
     <#else>
      <${'#'}assign valueField01="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o02")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField02="${property.name}">
     <#else>
      <${'#'}assign optionField02="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p02")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField02="${property.name}">
     <#else>
      <${'#'}assign purposeField02="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v02")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField02="${property.name}">
     <#else>
      <${'#'}assign valueField02="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o03")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField03="${property.name}">
     <#else>
      <${'#'}assign optionField03="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p03")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField03="${property.name}">
     <#else>
      <${'#'}assign purposeField03="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v03")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField03="${property.name}">
     <#else>
      <${'#'}assign valueField03="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o04")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField04="${property.name}">
     <#else>
      <${'#'}assign optionField04="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p04")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField04="${property.name}">
     <#else>
      <${'#'}assign purposeField04="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v04")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField04="${property.name}">
     <#else>
      <${'#'}assign valueField04="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o05")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField05="${property.name}">
     <#else>
      <${'#'}assign optionField05="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p05")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField05="${property.name}">
     <#else>
      <${'#'}assign purposeField05="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v05")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField05="${property.name}">
     <#else>
      <${'#'}assign valueField05="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o06")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField06="${property.name}">
     <#else>
      <${'#'}assign optionField06="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p06")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField06="${property.name}">
     <#else>
      <${'#'}assign purposeField06="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v06")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField06="${property.name}">
     <#else>
      <${'#'}assign valueField06="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o07")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField07="${property.name}">
     <#else>
      <${'#'}assign optionField07="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p07")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField07="${property.name}">
     <#else>
      <${'#'}assign purposeField07="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v07")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField07="${property.name}">
     <#else>
      <${'#'}assign valueField07="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o08")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField08="${property.name}">
     <#else>
      <${'#'}assign optionField08="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p08")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField08="${property.name}">
     <#else>
      <${'#'}assign purposeField08="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v08")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField08="${property.name}">
     <#else>
      <${'#'}assign valueField08="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o09")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField09="${property.name}">
     <#else>
      <${'#'}assign optionField09="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p09")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField09="${property.name}">
     <#else>
      <${'#'}assign purposeField09="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v09")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField09="${property.name}">
     <#else>
      <${'#'}assign valueField09="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o10")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField10="${property.name}">
     <#else>
      <${'#'}assign optionField10="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p10")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField10="${property.name}">
     <#else>
      <${'#'}assign purposeField10="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v10")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField10="${property.name}">
     <#else>
      <${'#'}assign valueField10="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o11")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField11="${property.name}">
     <#else>
      <${'#'}assign optionField11="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p11")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField11="${property.name}">
     <#else>
      <${'#'}assign purposeField11="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v11")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField11="${property.name}">
     <#else>
      <${'#'}assign valueField11="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o12")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField12="${property.name}">
     <#else>
      <${'#'}assign optionField12="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p12")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField12="${property.name}">
     <#else>
      <${'#'}assign purposeField12="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v12")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField12="${property.name}">
     <#else>
      <${'#'}assign valueField12="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o13")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField13="${property.name}">
     <#else>
      <${'#'}assign optionField13="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p13")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField13="${property.name}">
     <#else>
      <${'#'}assign purposeField13="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v13")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField13="${property.name}">
     <#else>
      <${'#'}assign valueField13="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o14")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField14="${property.name}">
     <#else>
      <${'#'}assign optionField14="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p14")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField14="${property.name}">
     <#else>
      <${'#'}assign purposeField14="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v14")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField14="${property.name}">
     <#else>
      <${'#'}assign valueField14="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o15")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField15="${property.name}">
     <#else>
      <${'#'}assign optionField15="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p15")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField15="${property.name}">
     <#else>
      <${'#'}assign purposeField15="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v15")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField15="${property.name}">
     <#else>
      <${'#'}assign valueField15="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o16")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField16="${property.name}">
     <#else>
      <${'#'}assign optionField16="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p16")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField16="${property.name}">
     <#else>
      <${'#'}assign purposeField16="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v16")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField16="${property.name}">
     <#else>
      <${'#'}assign valueField16="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o17")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField17="${property.name}">
     <#else>
      <${'#'}assign optionField17="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p17")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField17="${property.name}">
     <#else>
      <${'#'}assign purposeField17="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v17")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField17="${property.name}">
     <#else>
      <${'#'}assign valueField17="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o18")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField18="${property.name}">
     <#else>
      <${'#'}assign optionField18="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p18")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField18="${property.name}">
     <#else>
      <${'#'}assign purposeField18="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v18")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField18="${property.name}">
     <#else>
      <${'#'}assign valueField18="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o19")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField19="${property.name}">
     <#else>
      <${'#'}assign optionField19="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p19")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField19="${property.name}">
     <#else>
      <${'#'}assign purposeField19="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v19")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField19="${property.name}">
     <#else>
      <${'#'}assign valueField19="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o20")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField20="${property.name}">
     <#else>
      <${'#'}assign optionField20="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p20")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField20="${property.name}">
     <#else>
      <${'#'}assign purposeField20="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v20")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField20="${property.name}">
     <#else>
      <${'#'}assign valueField20="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o21")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField21="${property.name}">
     <#else>
      <${'#'}assign optionField21="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o22")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField22="${property.name}">
     <#else>
      <${'#'}assign optionField22="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o23")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField23="${property.name}">
     <#else>
      <${'#'}assign optionField23="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o24")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField24="${property.name}">
     <#else>
      <${'#'}assign optionField24="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o25")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField25="${property.name}">
     <#else>
      <${'#'}assign optionField25="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o26")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField26="${property.name}">
     <#else>
      <${'#'}assign optionField26="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o27")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField27="${property.name}">
     <#else>
      <${'#'}assign optionField27="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o28")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField28="${property.name}">
     <#else>
      <${'#'}assign optionField28="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o29")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField29="${property.name}">
     <#else>
      <${'#'}assign optionField29="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o30")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField30="${property.name}">
     <#else>
      <${'#'}assign optionField30="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o31")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField31="${property.name}">
     <#else>
      <${'#'}assign optionField31="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o32")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField33="${property.name}">
     <#else>
      <${'#'}assign optionField33="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o34")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField34="${property.name}">
     <#else>
      <${'#'}assign optionField34="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o35")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField35="${property.name}">
     <#else>
      <${'#'}assign optionField35="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o36")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField36="${property.name}">
     <#else>
      <${'#'}assign optionField36="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o37")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField37="${property.name}">
     <#else>
      <${'#'}assign optionField37="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o38")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField38="${property.name}">
     <#else>
      <${'#'}assign optionField38="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o39")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField39="${property.name}">
     <#else>
      <${'#'}assign optionField39="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o40")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField40="${property.name}">
     <#else>
      <${'#'}assign optionField40="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o41")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField41="${property.name}">
     <#else>
      <${'#'}assign optionField41="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o42")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField42"${property.name}">
     <#else>
      <${'#'}assign optionField42="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o44")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField44="${property.name}">
     <#else>
      <${'#'}assign optionField44="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o45")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField45="${property.name}">
     <#else>
      <${'#'}assign optionField45="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o46")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField46="${property.name}">
     <#else>
      <${'#'}assign optionField46="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o47")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField47="${property.name}">
     <#else>
      <${'#'}assign optionField47="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o48")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField48="${property.name}">
     <#else>
      <${'#'}assign optionField48="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o49")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField49="${property.name}">
     <#else>
      <${'#'}assign optionField49="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="o50")>
     <#if genoptions=="Y">
      <${'#'}assign genoptionsField50="${property.name}">
     <#else>
      <${'#'}assign optionField50="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p21")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField21="${property.name}">
     <#else>
      <${'#'}assign purposeField21="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p22")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField22="${property.name}">
     <#else>
      <${'#'}assign purposeField22="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p23")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField23="${property.name}">
     <#else>
      <${'#'}assign purposeField23="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p24")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField24="${property.name}">
     <#else>
      <${'#'}assign purposeField24="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p25")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField25="${property.name}">
     <#else>
      <${'#'}assign purposeField25="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p26")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField26="${property.name}">
     <#else>
      <${'#'}assign purposeField26="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p27")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField27="${property.name}">
     <#else>
      <${'#'}assign purposeField27="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p28")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField28="${property.name}">
     <#else>
      <${'#'}assign purposeField28="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p29")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField29="${property.name}">
     <#else>
      <${'#'}assign purposeField29="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p30")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField30="${property.name}">
     <#else>
      <${'#'}assign purposeField30="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p31")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField31="${property.name}">
     <#else>
      <${'#'}assign purposeField31="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p32")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField33="${property.name}">
     <#else>
      <${'#'}assign purposeField33="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p34")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField34="${property.name}">
     <#else>
      <${'#'}assign purposeField34="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p35")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField35="${property.name}">
     <#else>
      <${'#'}assign purposeField35="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p36")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField36="${property.name}">
     <#else>
      <${'#'}assign purposeField36="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p37")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField37="${property.name}">
     <#else>
      <${'#'}assign purposeField37="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p38")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField38="${property.name}">
     <#else>
      <${'#'}assign purposeField38="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p39")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField39="${property.name}">
     <#else>
      <${'#'}assign purposeField39="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p40")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField40="${property.name}">
     <#else>
      <${'#'}assign purposeField40="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p41")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField41="${property.name}">
     <#else>
      <${'#'}assign purposeField41="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p42")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField42"${property.name}">
     <#else>
      <${'#'}assign purposeField42="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p44")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField44="${property.name}">
     <#else>
      <${'#'}assign purposeField44="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p45")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField45="${property.name}">
     <#else>
      <${'#'}assign purposeField45="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p46")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField46="${property.name}">
     <#else>
      <${'#'}assign purposeField46="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p47")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField47="${property.name}">
     <#else>
      <${'#'}assign purposeField47="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p48")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField48="${property.name}">
     <#else>
      <${'#'}assign purposeField48="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p49")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField49="${property.name}">
     <#else>
      <${'#'}assign purposeField49="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="p50")>
     <#if genoptions=="Y">
      <${'#'}assign genPurposeField50="${property.name}">
     <#else>
      <${'#'}assign purposeField50="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v21")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField21="${property.name}">
     <#else>
      <${'#'}assign valueField21="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v22")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField22="${property.name}">
     <#else>
      <${'#'}assign valueField22="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v23")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField23="${property.name}">
     <#else>
      <${'#'}assign valueField23="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v24")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField24="${property.name}">
     <#else>
      <${'#'}assign valueField24="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v25")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField25="${property.name}">
     <#else>
      <${'#'}assign valueField25="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v26")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField26="${property.name}">
     <#else>
      <${'#'}assign valueField26="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v27")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField27="${property.name}">
     <#else>
      <${'#'}assign valueField27="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v28")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField28="${property.name}">
     <#else>
      <${'#'}assign valueField28="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v29")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField29="${property.name}">
     <#else>
      <${'#'}assign valueField29="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v30")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField30="${property.name}">
     <#else>
      <${'#'}assign valueField30="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v31")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField31="${property.name}">
     <#else>
      <${'#'}assign valueField31="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v32")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField33="${property.name}">
     <#else>
      <${'#'}assign valueField33="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v34")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField34="${property.name}">
     <#else>
      <${'#'}assign valueField34="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v35")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField35="${property.name}">
     <#else>
      <${'#'}assign valueField35="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v36")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField36="${property.name}">
     <#else>
      <${'#'}assign valueField36="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v37")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField37="${property.name}">
     <#else>
      <${'#'}assign valueField37="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v38")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField38="${property.name}">
     <#else>
      <${'#'}assign valueField38="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v39")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField39="${property.name}">
     <#else>
      <${'#'}assign valueField39="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v40")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField40="${property.name}">
     <#else>
      <${'#'}assign valueField40="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v41")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField41="${property.name}">
     <#else>
      <${'#'}assign valueField41="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v42")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField42"${property.name}">
     <#else>
      <${'#'}assign valueField42="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v44")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField44="${property.name}">
     <#else>
      <${'#'}assign valueField44="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v45")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField45="${property.name}">
     <#else>
      <${'#'}assign valueField45="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v46")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField46="${property.name}">
     <#else>
      <${'#'}assign valueField46="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v47")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField47="${property.name}">
     <#else>
      <${'#'}assign valueField47="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v48")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField48="${property.name}">
     <#else>
      <${'#'}assign valueField48="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v49")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField49="${property.name}">
     <#else>
      <${'#'}assign valueField49="${property.name}">
     </#if>
   <#elseif (property.name?substring(5,8) =="v50")>
     <#if genoptions=="Y">
      <${'#'}assign genValueField50="${property.name}">
     <#else>
      <${'#'}assign valueField50="${property.name}">
     </#if>
   </#if>
  <#-- account  efs,pefs 6 efs,pefe 8--> 
  <#elseif (componentName?substring(6,8) =="60")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign accountDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign accountKeyField="${property.name}">
   </#if> 
 
  <#-- acperiod --> 
  <#elseif (componentName?substring(6,8) =="62")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign acperiodDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign acperiodKeyField="${property.name}">
   </#if>  

  <#-- address --> 
  <#elseif (componentName?substring(6,8) =="11")> 
   <#if (property.name?substring(pefS,pefE) =="a1")>
      <${'#'}assign addressLine1="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ac")>
      <${'#'}assign addressCity="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="az")>
      <${'#'}assign addressPzcode="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign addfressDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign addressKeyField="${property.name}">
   </#if>
  <#-- activity --> 
  <#elseif (componentName?substring(6,8) =="18")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign activityDescript="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="sc")>
      <${'#'}assign activityShipcode="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign activityKeyField="${property.name}">
   </#if>  
  <#-- client --> 
  <#elseif (componentName?substring(6,8) =="52")> 
   <#if (property.name?substring(pefS,pefE) =="zc")>
      <${'#'}assign ${componentName?substring(eL)}${property.name?substring(pL)?cap_first}="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign clientDescript="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="vi")>
      <${'#'}assign ${componentName?substring(eL)}${property.name?substring(pL)?cap_first}="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign clientKeyField="${property.name}">
   <#elseif property.name?substring(pefS,pefE)=="pc" >
      <${'#'}assign ${componentName?substring(eL)}${property.name?substring(pL)?cap_first}="${property.name}">
   </#if>
  <#-- customer --> 
  <#elseif (componentName?substring(6,8) =="20")> 
   <#if (property.name?substring(pefS,pefE) =="zc")>
      <${'#'}assign customerKeyField="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign customerDescript="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ln")>
      <${'#'}assign customerLastName="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="fn")>
      <${'#'}assign customerFirstName="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="po")>
      <${'#'}assign customerPhoneO="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ph")>
      <${'#'}assign customerPhoneH="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="cn")>
      <${'#'}assign customerCompanyName="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign customerKeyField="${property.name}">
   </#if>
  <#-- cuquote --> 
  <#elseif (componentName?substring(6,8) =="23")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign cuquoteDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign cuquoteKeyField="${property.name}">
   </#if>  
  <#-- cuorders --> 
  <#elseif (componentName?substring(6,8) =="24")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign cuordersDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign cuordersKeyField="${property.name}">
   </#if>  
  <#-- cuinvoice --> 
  <#elseif (componentName?substring(6,8) =="26")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign cuinvoiceDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign cuinvoiceKeyField="${property.name}">
   </#if>  
  <#-- cpayment --> 
  <#elseif (componentName?substring(6,8) =="26")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign cpaymentDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign cpaymentKeyField="${property.name}">
   </#if>  
  <#-- cuodetails --> 
  <#elseif (componentName?substring(6,8) =="2b")> 
   <#if (property.name?substring(pefS,pefE) =="11")>
      <${'#'}assign cuodetailsLine="${property.name}">
   </#if>  

  <#-- division --> 
  <#elseif (componentName?substring(6,8) =="13")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign divisionDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign divisionKeyField="${property.name}">
   </#if>  

  <#-- department --> 
  <#elseif (componentName?substring(6,8) =="12")> 
   <#if (property.name?substring(pefS,pefE) =="zc")>
      <${'#'}assign ${componentName?substring(eL)}${property.name?substring(pL)?cap_first}="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign departmentDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign departmentKeyField="${property.name}">
   </#if>
  <#-- employee --> 
  <#elseif (componentName?substring(6,8) =="40")> 
   <#if (property.name?substring(pefS,pefE) =="zc")>
      <${'#'}assign employeeKeyField="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign employeeDescript="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ln")>
      <${'#'}assign employeeLastName="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="fn")>
      <${'#'}assign employeeFirstName="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="po")>
      <${'#'}assign employeePhoneO="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ph")>
      <${'#'}assign employeePhoneH="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="cn")>
      <${'#'}assign employeeCompanyName="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign employeeKeyField="${property.name}">
   </#if>
  <#-- item --> 
  <#elseif (componentName?substring(6,8) =="1a")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign itemDescript="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="sc")>
      <${'#'}assign itemShipcode="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign itemKeyField="${property.name}">
   <#elseif property.name?substring(poS,poE)=="18" >
      <${'#'}assign itemUnitField="${property.name}">
   </#if>  
  <#-- location --> 
  <#elseif (componentName?substring(6,8) =="14")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign locationDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign locationKeyField="${property.name}">
   </#if>  

  <#-- perioddates --> 
  <#elseif (componentName?substring(6,8) =="63")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign perioddatesDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign perioddatesKeyField="${property.name}">
  </#if>
  <#-- user no descript--> 
  <#elseif (componentName?substring(6,8) =="56")> 
   <#if (property.name?substring(pefS,pefE) =="zn")>
      <${'#'}assign userNotes="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="op")>
      <${'#'}assign userOldpw="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="oi")>
      <${'#'}assign userOtherid="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign userKeyField="${property.name}">
   </#if>
  <#-- vendor --> 
  <#elseif (componentName?substring(6,8) =="30")> 
   <#if (property.name?substring(pefS,pefE) =="zc")>
      <${'#'}assign vendorKeyField="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign vendorDescript="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ln")>
      <${'#'}assign vendorLastName="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="fn")>
      <${'#'}assign vendorFirstName="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="po")>
      <${'#'}assign vendorPhoneO="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="ph")>
      <${'#'}assign vendorPhoneH="${property.name}">
   <#elseif (property.name?substring(pefS,pefE) =="cn")>
      <${'#'}assign vendorCompanyName="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign vendorKeyField="${property.name}">
   </#if>
  <#-- venquote --> 
  <#elseif (componentName?substring(6,8) =="33")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign venquoteDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign venquoteKeyField="${property.name}">
   </#if>  
  <#-- venorders --> 
  <#elseif (componentName?substring(6,8) =="34")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign venordersDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign venordersKeyField="${property.name}">
   </#if>  
  <#-- vinvoice --> 
  <#elseif (componentName?substring(6,8) =="3a")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign vinvoiceDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign vinvoiceKeyField="${property.name}">
   </#if>  
  <#-- vpayment --> 
  <#elseif (componentName?substring(6,8) =="36")> 
   <#if (property.name?substring(pefS,pefE) =="zs")>
      <${'#'}assign vpaymentDescript="${property.name}">
   <#elseif property.name?substring(pkS,pkE)=="k" || property.name?substring(pkS,pkE)=="n"  >
      <${'#'}assign vpaymentKeyField="${property.name}">
   </#if>  


  </#if>


 </#if>
</#foreach>
</#if>
</#if>



