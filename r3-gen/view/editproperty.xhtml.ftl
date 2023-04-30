<#--jay qtyord should be validated not null -->
<#--comes here from edit.xhtml.ftl in a loop for each property, so any assign here is repeated
    you may assign them in edit.xhtml.ftl 
    In each iteration either FromCols8On="yes" or FromCols2On="yes" and was set by edit.xhtml.ftl
    These values should not be changed here, only Temp Col values should change here
  -->
  <#assign foreignEntity="Compnamejay"> 
  <#assign divisionEntityDivisionFieldName="a0xxukoxbvxxxxxxxxxxdivcode">
  <#assign departmentEntityDepartmentFieldName="a0xxukexbvxxxxxxxxxxdepcode">
  <#assign companyEntityCompanyFieldName="a0xxukcxbvxxxxxxxxxxcompanycode">

                               
<#--  Foreign Fields including required fields ie those part of composite keys were not shown in original editproperty.xhml.ftl 
       because seam gen relied on edit.xhmtl.ftl to select them
       at the bottom of page and the logic was in edit.xhtml.ftl, but it was not very user friendly -->     
<#-- 3R extension modified edit.ftl to show all of the foreign fields as drop down  explicitly using many to one in editproperty,xhtml.ftl
     unless foreign field is part of key , then they are handled here in edit.xhtml.ftl  -->

<#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
     <#if property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="zb" || property.name?substring(5,7)=="za"  > 
      <#assign documentField=property.name>
     </#if>   

 <#assign propertyIsId = property.equals(pojo.identifierProperty)>
 <#-- editproperty isid check ${property} equals ${pojo.identifierProperty}  gen strategy ${property.value.identifierGeneratorStrategy} -->
 <#if !propertyIsId || property.value.identifierGeneratorStrategy == "assigned">
  <#if pojo.isComponent(property)>
   <#foreach componentProperty in property.value.propertyIterator>
   <#if (componentProperty.name?length > pL)>
    <#assign column = componentProperty.columnIterator.next()>
   <#-- editproperty iscomponent ${componentProperty.name}  columniterator ${column} -->
    <#assign propertyType = componentProperty.value.typeName>
    <#if (componentProperty.name?length > pL)>
     <#if (propertyType?contains("tring") && column.length gt 160)>
              <#-- begin component gt >160 -->
              <#if FromCols8On=="yes">
               <#if  GridAlreadyClosed=="no" >
                </h:panelGrid>
               </#if>
                <#assign FromCols8On="no">
              </#if> 
              <h:panelGrid columns="2">
              <#assign TempCols2On="yes">
     </#if> 
     <#if (propertyType?contains("ime"))>
              <#-- component date -->
              <#if FromCols8On=="yes" || Cols2On=="yes">
               <#if  GridAlreadyClosed=="no" >
                </h:panelGrid>
               </#if>
                <#assign FromCols8On="no">
              </#if> 
              <h:panelGrid columns="1">
              <#assign Cols1On="yes">
     </#if>

     <#if componentProperty.name?substring(8,9) == "h" >
            <h:panelGroup id="${componentProperty.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('EH')}">
     <#elseif componentProperty.name?substring(8,9) == "l" ||  componentProperty.name?substring(8,9) == "x"  >
     <#--oct10 2018 list only but for repair allow -->
            <h:panelGroup id="${componentProperty.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('SH') or customIdentity.hasRole('EH')?true:false}">
     <#elseif componentProperty.name?substring(8,9) == "i" >
            <h:panelGroup id="${componentProperty.name}Decoration"  rendered="true">
     <#elseif componentProperty.name?substring(8,9) == "s" >
            <h:panelGroup id="${componentProperty.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('SH') or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and !(customIdentity.restrict1=='D')}">
     <#elseif property.name?substring(6,8)=="sc">
            jay<h:panelGroup did not come here ? seems since it has fb it was caught already
     <#else>   
            <h:panelGroup id="${componentProperty.name}Decoration" >
     </#if>
    </#if>
    <#if (componentProperty.name?length > pL)>
                <h:outputLabel  for="${componentProperty.name}" value="${'#'}{messages['${componentProperty.name?substring(pL)?cap_first}']}"/>
    </#if>
    <#if (componentProperty.name?length > pL)>
    <#if propertyType?contains("ate")>
     <p:datePicker id="${componentProperty.name}" 

     <#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
     </#if>
     <#if !column.nullable>
      <#if propertyIsId>
                       required="true" 
      <#else>
                       required="true" 
      </#if>
     </#if>
     <#if componentProperty.name?substring(4,5) == "d" >
                 value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}" />
     <#else>
                showTime="true" value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}" 
     </#if>
                    <f:ajax event="blur,onselect" render="${componentProperty.name}Decoration" bypassUpdates="true"/>

    <#elseif propertyType?contains("ime")>
     <p:datePicker id="${property.name}" 

     <#if !column.nullable>
                       required="true"
     </#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"/>
                    <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
    <#elseif propertyType?contains("imestamp")>
     <p:datePicker id="${componentProperty.name}" 
     <#if !column.nullable> 
                       required="true"
     </#if>
                         showTime="true" value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"/>
                     <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
    <#elseif propertyType?contains("ecimal")>
                <h:inputText id="${componentProperty.name}" 
     <#if !column.nullable>
                       required="true"
     </#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}:this.value;"
                           size="${column.precision+7}">
                    <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
                </h:inputText>
    <#elseif propertyType?contains("ecimal")>
                <h:inputText id="${componentProperty.name}" 
     <#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
     </#if>
     <#if !column.nullable>
                       required="true"
     </#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}:this.value;"
                           size="${column.precision+6}">
                    <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
                </h:inputText>
    <#elseif propertyType == "java.lang.Boolean" || propertyType == "yes_no" || propertyType == "true_false">
     <#if property.name?substring(4,5) == "y" >
                <h:selectOneRadio id="${componentProperty.name}"
      <#if !column.nullable>
                                    required="true"
      </#if>
      <#if propertyIsId>
                                    disabled="${'#'}{${homeName}.managed}"
      </#if>
                                    value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                 <f:selectItem itemValue="${'#'}{true}" itemLabel="Yes" />
                 <f:selectItem itemValue="${'#'}{false}" itemLabel="No" />
                </h:selectOneRadio>
     <#else>
                 <h:selectBooleanCheckbox id="${componentProperty.name}"
      <#if !column.nullable>
                                    required="true"
      </#if>
      <#if propertyIsId>
                                    disabled="${'#'}{${homeName}.managed}"
      </#if>
                                    value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                  <ui:remove>oct27 2019 added ajax to reinvoke setter otherwise page load was initializing value</ui:remove>
                  <f:ajax  render="${componentProperty.name}" bypassUpdates="false"/>
                 </h:selectBooleanCheckbox>
     </#if>
    <#elseif propertyType?contains("tring") || propertyType?contains("[B")  >
     <#if column.length gt 160 && property.name?substring(5,6) != "c">
      <#if column.length gt 800>
       <#assign rows = 10>
      <#else>
       <#assign rows = (column.length/80)?int>
      </#if>
                <h:inputTextarea id="${componentProperty.name}"
                               cols="80"
                               rows="${rows}"
      <#if propertyIsId>
       <#if keyfromsubkeys=="Y">
                   disabled="true"
       <#else> 
                   disabled="${'#'}{${homeName}.managed}"
       </#if>    
      </#if>
      <#if !column.nullable>

                           required="true"
      </#if>
              value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"/>
     <#else>
      <#if column.length gt 100>
       <#assign size = 32>
      <#else>
       <#if column.length gt 50>
        <#assign size = 28>
       </#if>
       <#assign size = 20>
      </#if>
      <#if (componentProperty.name?length > pL) >
       <#if !(componentProperty.name?substring(11,12)?contains("x") || componentProperty.name?substring(11,12)?contains("i") || componentProperty.name?substring(11,12)?contains("u") )>

        <#if (componentProperty.name?substring(4,5)?contains("g"))>
            <#if componentProperty.name?substring(10,12)== "01" >
             <#assign OptionField=genOptionField01 >
             <#assign PurposeField=genPurposeField01 >
             <#assign ValueField=genValueField01 >
            <#elseif componentProperty.name?substring(10,12)== "02" >
             <#assign OptionField=genOptionField02 >
             <#assign PurposeField=genPurposeField02 >
             <#assign ValueField=genValueField02 >
            <#elseif componentProperty.name?substring(10,12)== "03" >
             <#assign OptionField=genOptionField03 >
             <#assign PurposeField=genPurposeField03 >
             <#assign ValueField=genValueField03 >
            <#elseif componentProperty.name?substring(10,12)== "04" >
             <#assign OptionField=genOptionField04 >
             <#assign PurposeField=genPurposeField04 >
             <#assign ValueField=genValueField04 >
            <#elseif componentProperty.name?substring(10,12)== "05" >
             <#assign OptionField=genOptionField05 >
             <#assign PurposeField=genPurposeField05 >
             <#assign ValueField=genValueField05 >
            <#elseif componentProperty.name?substring(10,12)== "06" >
             <#assign OptionField=genOptionField06 >
             <#assign PurposeField=genPurposeField06 >
             <#assign ValueField=genValueField06 >
            <#elseif componentProperty.name?substring(10,12)== "07" >
             <#assign OptionField=genOptionField07 >
             <#assign PurposeField=genPurposeField07 >
             <#assign ValueField=genValueField07 >
            <#elseif componentProperty.name?substring(10,12)== "08" >
             <#assign OptionField=genOptionField08 >
             <#assign PurposeField=genPurposeField08 >
             <#assign ValueField=genValueField08 >
            <#elseif componentProperty.name?substring(10,12)== "09" >
             <#assign OptionField=genOptionField09 >
             <#assign PurposeField=genPurposeField09 >
             <#assign ValueField=genValueField09 >
            <#elseif componentProperty.name?substring(10,12)== "10" >
             <#assign OptionField=genOptionField10 >
             <#assign PurposeField=genPurposeField10 >
             <#assign ValueField=genValueField10 >
            <#elseif componentProperty.name?substring(10,12)== "11" >
             <#assign OptionField=genOptionField11 >
             <#assign PurposeField=genPurposeField11 >
             <#assign ValueField=genValueField11 >
            <#elseif componentProperty.name?substring(10,12)== "12" >
             <#assign OptionField=genOptionField12 >
             <#assign PurposeField=genPurposeField12 >
             <#assign ValueField=genValueField12 >
            <#elseif componentProperty.name?substring(10,12)== "13" >
             <#assign OptionField=genOptionField13 >
             <#assign PurposeField=genPurposeField13 >
             <#assign ValueField=genValueField13 >
            <#elseif componentProperty.name?substring(10,12)== "14" >
             <#assign OptionField=genOptionField14 >
             <#assign PurposeField=genPurposeField14 >
             <#assign ValueField=genValueField14 >
            <#elseif componentProperty.name?substring(10,12)== "15" >
             <#assign OptionField=genOptionField15 >
             <#assign PurposeField=genPurposeField15 >
             <#assign ValueField=genValueField15 >
            <#elseif componentProperty.name?substring(10,12)== "16" >
             <#assign OptionField=genOptionField16 >
             <#assign PurposeField=genPurposeField16 >
             <#assign ValueField=genValueField16 >
            <#elseif componentProperty.name?substring(10,12)== "17" >
             <#assign OptionField=genOptionField17 >
             <#assign PurposeField=genPurposeField17 >
             <#assign ValueField=genValueField17 >
            <#elseif componentProperty.name?substring(10,12)== "18" >
             <#assign OptionField=genOptionField18 >
             <#assign PurposeField=genPurposeField18 >
             <#assign ValueField=genValueField18 >
            <#elseif componentProperty.name?substring(10,12)== "19" >
             <#assign OptionField=genOptionField19 >
             <#assign PurposeField=genPurposeField19 >
             <#assign ValueField=genValueField19 >
            <#elseif componentProperty.name?substring(10,12)== "20" >
             <#assign OptionField=genOptionField20 >
             <#assign PurposeField=genPurposeField20 >
             <#assign ValueField=genValueField20 >
            <#else >
             <#assign OptionField=genOptionField01 >
             <#assign PurposeField=genPurposeField01 >
             <#assign ValueField=genValueField01 >
            </#if>
                      <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${componentProperty.name}}" required="false" id="${componentProperty.name}">
                       <f:ajax  render="${componentProperty.name}I" bypassUpdates="false"/>
                       <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('${menuAttributesFunction}',${componentProperty.name?substring(10,12)})}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
                      </h:selectOneMenu>
        <#else>
            <#if componentProperty.name?substring(10,12)== "01" >
             <#assign OptionField=optionField01 >
             <#assign PurposeField=purposeField01 >
             <#assign ValueField=valueField01 >
            <#elseif componentProperty.name?substring(10,12)== "02" >
             <#assign OptionField=optionField02 >
             <#assign PurposeField=purposeField02 >
             <#assign ValueField=valueField02 >
            <#elseif componentProperty.name?substring(10,12)== "03" >
             <#assign OptionField=optionField03 >
             <#assign PurposeField=purposeField03 >
             <#assign ValueField=valueField03 >
            <#elseif componentProperty.name?substring(10,12)== "04" >
             <#assign OptionField=optionField04 >
             <#assign PurposeField=purposeField04 >
             <#assign ValueField=valueField04 >
            <#elseif componentProperty.name?substring(10,12)== "05" >
             <#assign OptionField=optionField05 >
             <#assign PurposeField=purposeField05 >
             <#assign ValueField=valueField05 >
            <#elseif componentProperty.name?substring(10,12)== "06" >
             <#assign OptionField=optionField06 >
             <#assign PurposeField=purposeField06 >
             <#assign ValueField=valueField06 >
            <#elseif componentProperty.name?substring(10,12)== "07" >
             <#assign OptionField=optionField07 >
             <#assign PurposeField=purposeField07 >
             <#assign ValueField=valueField07 >
            <#elseif componentProperty.name?substring(10,12)== "08" >
             <#assign OptionField=optionField08 >
             <#assign PurposeField=purposeField08 >
             <#assign ValueField=valueField08 >
            <#elseif componentProperty.name?substring(10,12)== "09" >
             <#assign OptionField=optionField09 >
             <#assign PurposeField=purposeField09 >
             <#assign ValueField=valueField09 >
            <#elseif componentProperty.name?substring(10,12)== "10" >
             <#assign OptionField=optionField10 >
             <#assign PurposeField=purposeField10 >
             <#assign ValueField=valueField10 >
            <#elseif componentProperty.name?substring(10,12)== "11" >
             <#assign OptionField=optionField11 >
             <#assign PurposeField=purposeField11 >
             <#assign ValueField=valueField11 >
            <#elseif componentProperty.name?substring(10,12)== "12" >
             <#assign OptionField=optionField12 >
             <#assign PurposeField=purposeField12 >
             <#assign ValueField=valueField12 >
            <#elseif componentProperty.name?substring(10,12)== "13" >
             <#assign OptionField=optionField13 >
             <#assign PurposeField=purposeField13 >
             <#assign ValueField=valueField13 >
            <#elseif componentProperty.name?substring(10,12)== "14" >
             <#assign OptionField=optionField14 >
             <#assign PurposeField=purposeField14 >
             <#assign ValueField=valueField14 >
            <#elseif componentProperty.name?substring(10,12)== "15" >
             <#assign OptionField=optionField15 >
             <#assign PurposeField=purposeField15 >
             <#assign ValueField=valueField15 >
            <#elseif componentProperty.name?substring(10,12)== "16" >
             <#assign OptionField=optionField16 >
             <#assign PurposeField=purposeField16 >
             <#assign ValueField=valueField16 >
            <#elseif componentProperty.name?substring(10,12)== "17" >
             <#assign OptionField=optionField17 >
             <#assign PurposeField=purposeField17 >
             <#assign ValueField=valueField17 >
            <#elseif componentProperty.name?substring(10,12)== "18" >
             <#assign OptionField=optionField18 >
             <#assign PurposeField=purposeField18 >
             <#assign ValueField=valueField18 >
            <#elseif componentProperty.name?substring(10,12)== "19" >
             <#assign OptionField=optionField19 >
             <#assign PurposeField=purposeField19 >
             <#assign ValueField=valueField19 >
            <#elseif componentProperty.name?substring(10,12)== "20" >
             <#assign OptionField=optionField20 >
             <#assign PurposeField=purposeField20 >
             <#assign ValueField=valueField20 >
            <#elseif componentProperty.name?substring(10,12)== "21" >
             <#assign OptionField=optionField21 >
             <#assign PurposeField=purposeField21 >
             <#assign ValueField=valueField21 >
            <#elseif componentProperty.name?substring(10,12)== "22" >
             <#assign OptionField=optionField22 >
             <#assign PurposeField=purposeField22 >
             <#assign ValueField=valueField22 >
            <#elseif componentProperty.name?substring(10,12)== "23" >
             <#assign OptionField=optionField23 >
             <#assign PurposeField=purposeField23 >
             <#assign ValueField=valueField23 >
            <#elseif componentProperty.name?substring(10,12)== "24" >
             <#assign OptionField=optionField24 >
             <#assign PurposeField=purposeField24 >
             <#assign ValueField=valueField24 >
             <#elseif componentProperty.name?substring(10,12)== "25" >
             <#assign OptionField=optionField25 >
             <#assign PurposeField=purposeField25 >
             <#assign ValueField=valueField25 >
            <#elseif componentProperty.name?substring(10,12)== "26" >
             <#assign OptionField=optionField26 >
             <#assign PurposeField=purposeField26 >
             <#assign ValueField=valueField26 >
            <#elseif componentProperty.name?substring(10,12)== "27" >
             <#assign OptionField=optionField27 >
             <#assign PurposeField=purposeField27 >
             <#assign ValueField=valueField27 >
            <#elseif componentProperty.name?substring(10,12)== "28" >
             <#assign OptionField=optionField28 >
             <#assign PurposeField=purposeField28 >
             <#assign ValueField=valueField28 >
            <#elseif componentProperty.name?substring(10,12)== "29" >
             <#assign OptionField=optionField29 >
             <#assign PurposeField=purposeField29 >
             <#assign ValueField=valueField29 >
            <#elseif componentProperty.name?substring(10,12)== "30" >
             <#assign OptionField=optionField30 >
             <#assign PurposeField=purposeField30 >
             <#assign ValueField=valueField30 >
            <#elseif componentProperty.name?substring(10,12)== "31" >
             <#assign OptionField=optionField31 >
             <#assign PurposeField=purposeField31 >
             <#assign ValueField=valueField31 >
            <#elseif componentProperty.name?substring(10,12)== "32" >
             <#assign OptionField=optionField32 >
             <#assign PurposeField=purposeField32 >
             <#assign ValueField=valueField32 >
            <#elseif componentProperty.name?substring(10,12)== "33" >
             <#assign OptionField=optionField33 >
             <#assign PurposeField=purposeField33 >
             <#assign ValueField=valueField33 >
            <#elseif componentProperty.name?substring(10,12)== "34" >
             <#assign OptionField=optionField34 >
             <#assign PurposeField=purposeField34 >
             <#assign ValueField=valueField34 >
            <#elseif componentProperty.name?substring(10,12)== "35" >
             <#assign OptionField=optionField35 >
             <#assign PurposeField=purposeField35 >
             <#assign ValueField=valueField35 >
            <#elseif componentProperty.name?substring(10,12)== "36" >
             <#assign OptionField=optionField36 >
             <#assign PurposeField=purposeField36 >
             <#assign ValueField=valueField36 >
            <#elseif componentProperty.name?substring(10,12)== "37" >
             <#assign OptionField=optionField37 >
             <#assign PurposeField=purposeField37 >
             <#assign ValueField=valueField37 >
            <#elseif componentProperty.name?substring(10,12)== "38" >
             <#assign OptionField=optionField38 >
             <#assign PurposeField=purposeField38 >
             <#assign ValueField=valueField38 >
            <#elseif componentProperty.name?substring(10,12)== "39" >
             <#assign OptionField=optionField39 >
             <#assign PurposeField=purposeField39 >
             <#assign ValueField=valueField39 >
            <#elseif componentProperty.name?substring(10,12)== "40" >
             <#assign OptionField=optionField40 >
             <#assign PurposeField=purposeField40 >
             <#assign ValueField=valueField40 >
            <#elseif componentProperty.name?substring(10,12)== "41" >
             <#assign OptionField=optionField41 >
             <#assign PurposeField=purposeField41 >
             <#assign ValueField=valueField41 >
            <#elseif componentProperty.name?substring(10,12)== "42" >
             <#assign OptionField=optionField42 >
             <#assign PurposeField=purposeField42 >
             <#assign ValueField=valueField42 >
            <#elseif componentProperty.name?substring(10,12)== "43" >
             <#assign OptionField=optionField43 >
             <#assign PurposeField=purposeField43 >
             <#assign ValueField=valueField43 >
            <#elseif componentProperty.name?substring(10,12)== "44" >
             <#assign OptionField=optionField44 >
             <#assign PurposeField=purposeField44 >
             <#assign ValueField=valueField44 >
            <#elseif componentProperty.name?substring(10,12)== "45" >
             <#assign OptionField=optionField45 >
             <#assign PurposeField=purposeField45 >
             <#assign ValueField=valueField45 >
            <#elseif componentProperty.name?substring(10,12)== "46" >
             <#assign OptionField=optionField46 >
             <#assign PurposeField=purposeField46 >
             <#assign ValueField=valueField46 >
            <#elseif componentProperty.name?substring(10,12)== "47" >
             <#assign OptionField=optionField47 >
             <#assign PurposeField=purposeField47 >
             <#assign ValueField=valueField47 >
            <#elseif componentProperty.name?substring(10,12)== "48" >
             <#assign OptionField=optionField48 >
             <#assign PurposeField=purposeField48 >
             <#assign ValueField=valueField48 >
            <#elseif componentProperty.name?substring(10,12)== "49" >
             <#assign OptionField=optionField49 >
             <#assign PurposeField=purposeField49 >
             <#assign ValueField=valueField49 >
            <#elseif componentProperty.name?substring(10,12)== "50" >
             <#assign OptionField=optionField50 >
             <#assign PurposeField=purposeField50 >
             <#assign ValueField=valueField50 >
            <#else >
             <#assign OptionField=optionField01 >
             <#assign PurposeField=purposeField01 >
             <#assign ValueField=valueField01 >
            </#if>

            <#if (componentProperty.name?substring(4,5)?contains("h")) >
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{${homeName}.instance.${componentProperty.name}}"
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
              <f:ajax  render="${componentProperty.name}I" bypassUpdates="false"/>
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','${componentProperty.name?substring(10,12)}').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','${componentProperty.name?substring(10,12)}').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
              <#if componentProperty.name?substring(10,12) == '11' ||componentProperty.name?substring(10,12) == '12' || componentProperty.name?substring(10,12) == '13' || componentProperty.name?substring(10,12) == '14'>
                       <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',${componentProperty.name?substring(10,12)})}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
              <#else>
              <f:selectItems 
                     value="${'#'}{${optionsEntityName}List.getSuggestList(${homeName}.prefix)}" var ="result" itemValue="${'#'}{result.${OptionField}}" 
                     itemLabel="${'#'}{result.${OptionField}}"/>
              </#if>
              <f:ajax  render="${componentProperty.name}I" bypassUpdates="false"/>
             <h:inputText id="${componentProperty.name}I" value="${'#'}{${homeName}.instance.${componentProperty.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="${column.length}">
                         <#-- failing retest first
                          <#if componentProperty.name?substring(10,12)== "27">
                           <f:validateRegex pattern="^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$"/>
                          </#if>
                          <#if componentProperty.name?substring(10,12)== "14">
                           <f:validateRegex pattern="^$|(^(?i)^[a-z0-9][a-z0-9\\-]{0,10}[a-z0-9]$)"/>
                          </#if>
                         -->
             </h:inputText>

             </h:panelGrid>
            <#else>
                 <#-- trim to strip spaces in email address and others fntrim did not work-->
                 <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${componentProperty.name}}" required="false" id="${componentProperty.name}">
                  <f:ajax  render="${componentProperty.name}I" bypassUpdates="false"/>
                  <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                  <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('${menuAttributesFunction}',${componentProperty.name?substring(10,12)})}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
                  </h:selectOneMenu>
            </#if>
        </#if>
       <#else> 
        <#if propertyIsId>
           <#foreach componentProperty in property.value.propertyIterator>
            <#-- property ${property} componentProp ${componentProperty} xx   ${c2h.isManyToOne(componentProperty)?string} -->
           </#foreach>
                 <#assign foreignEntity="nonej"> 
                 <#if componentProperty.name?substring(6,7)=="c" >
                  <#assign foreignEntity =companyEntityName>
                 <#elseif componentProperty.name?substring(6,7)=="o">               
                  <#assign foreignEntity = divisionEntityName>
                 <#elseif componentProperty.name?substring(6,7)=="e">               
                  <#assign foreignEntity = departmentEntityName>
                 <#elseif componentProperty.name?substring(6,7)=="r">               
                  <#assign foreignEntity = customerEntityName>
                 <#elseif componentProperty.name?substring(6,7)=="v">               
                  <#assign foreignEntity = vendorEntityName>
                 <#elseif componentProperty.name?substring(6,8)=="gg">               
                  <#assign foreignEntity = groupnameEntityName>
                 <#elseif componentProperty.name?substring(5,7)=="ib">               
                  <#assign foreignEntity = itemBomEntityName>
                 <#elseif componentProperty.name?substring(5,7)=="tt" || componentProperty.name?substring(6,7)=="t" >               
                  <#assign foreignEntity = employeeEntityName>
                 <#elseif componentProperty.name?substring(5,7)=="im">               
                  <#assign foreignEntity = itemEntityName>
                 <#-- not sure why table entity is used  -->
                 <#elseif componentProperty.name?substring(6,7)=="s">               
                  <#assign foreignEntity = tableEntityName>
                  <#assign foreignEntity = "nonej">
                 </#if> 
         <#if ( (componentProperty.name?substring(5,6)=="k") || (foreignEntity == "nonej") )>  
           <h:inputText id="${componentProperty.name}" 
                   <#if keyfromsubkeys=="Y">
                     rendered="false"
                   <#else> 
                   </#if>
                          size="${size}"
                     maxlength="${column.length}"
                         required = "true"
                         value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                    <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
           </h:inputText>
          <#if keyfromsubkeys=="Y">
          <#else>
           <#if menuAttributesFunction ="36">
            <p:tooltip for="${componentProperty.name}"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages.Enter} ${'#'}{messages.value} ${'#'}{messages.to} ${'#'}{messages.match} ${'#'}{messages.pre-printed} ${'#'}{messages.chq}+, ${'#'}{messages.or} ${'#'}{messages.leave} ${'#'}{messages.as} ${'#'}{messages.blank} ${'#'}{messages.to} ${'#'}{messages.use} ${'#'}{messages.next} ${'#'}{messages.Enter}genersated ${'#'}{messages.number} "/></span> </p:tooltip> 
           <#else>
            <p:tooltip for="${componentProperty.name}"> <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages.Enter} ${'#'}{messages.Value} ${'#'}{messages.here}"/></span> </p:tooltip> 
           </#if>
          </#if>
         <#else>
             <#-- combo via editproperty  not k or foreign entity identified -->
                <p:comboBox id="${componentProperty.name}IdT"  
                 value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"
                 suggestionValues= "${'#'}{${foreignEntity}List.${foreignEntity?substring(8)}KeyList}" directInputSuggestions="true" defaultLabel="Enter value or select .." 
                 disabled="${'#'}{${homeName}.managed}"
                 required="true"
                 immediate="true"
                 validator="${'#'}{${homeName}.validateAndSelect${componentProperty.name?substring(12)?cap_first}}"  >
                 <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="cp"  || pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="vp" )  > 
                  <f:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="select" render="${componentProperty.name}Decoration,matcodeDescriptDecoration,matcodePriceLabelT,matcodeTDecoration,matcodeDecorationmis" bypassUpdates="false"}/>
                 <#else>
                  <f:ajax event="select" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
                 </#if>
                </p:comboBox>
         </#if>
        <#else>
          <h:inputText id="${componentProperty.name}" 
                          size="${size}"
                     maxlength="${column.length}"
                         value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"
                    <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
               </h:inputText>
        </#if>
       </#if>
      <#else>
      </#if>
     </#if>
    <#else>
                <h:inputText id="${componentProperty.name}"
      <#if !column.nullable>
                       required="false"
      </#if>
      <#if propertyIsId>
       <#if keyfromsubkeys=="Y">
                   disabled="true"
       <#else> 
                   disabled="${'#'}{${homeName}.managed}"
       </#if>    
      </#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                    <f:ajax event="blur" render="${componentProperty.name}Decoration" bypassUpdates="true"/>
                </h:inputText>
    </#if>
    </#if>
            </h:panelGroup>
     <#if (propertyType?contains("tring") && column.length gt 160)>
              <#-- end component gt >160 should check more here-->
               </h:panelGrid>
               <h:panelGrid columns="4">
               <#assign FromCols8On="yes">
     </#if> 
   </#if>
   </#foreach>
  <#else>
   <#-- end of component properties  -->
   <#-- non component properties  Begin-->
   <#assign column = property.columnIterator.next()>
   <#assign propertyType = property.value.typeName>
   <#-- non component this part sets up panel grid and ui:decorate part -->
   <#-- below this input area is done -->  
   <#if (property.name?length > 12)>
    <#assign cIndex=cIndex+1>
    <#if (propertyType?contains("tring") && column.length gt 160 && property.name?substring(5,6) != "c")>
              <#-- begin non component gt >160 -->
              <#if FromCols8On=="yes" || FromCols2On=="yes" >
               <#if  GridAlreadyClosed=="no" >
                </h:panelGrid>
               </#if>
              </#if> 
              <#if property.name?substring(2,3) == "g" >
               <h:panelGroup id="${property.name}Group"> 
               <#assign GroupOn="yes">
               <#assign GridAlreadyClosed="no">
              </#if>
              <h:panelGrid columns="2">
              <#assign TempCols2On="yes">
              <#assign TempCols1On="no">
    <#elseif menuAttributesFunction ="1b" && property.name?substring(5,7) == "l0" && TempCols8On="no">
                </h:panelGrid>
               </p:panel>
               <p:panel>
   <#-- changed to 10 cdi from 4  instead of 8 because formulae length is longer ?? -->  
                <h:panelGrid columns="4">
                <#assign TempCols8On="yes">
    <#elseif menuAttributesFunction ="1b" && property.name?substring(5,7) == "cc">
                <#assign TempCols8On="close">
    <#elseif menuAttributesFunction ="1b" && property.name?substring(5,7) == "l0" && TempCols8On="close">
                <#assign TempCols8On="no">
                </h:panelGrid>
               </p:panel>
                <h:panelGrid columns="2">
    <#elseif (propertyType?contains("ime"))>
              <#-- begin non component date  -->
              <#if FromCols8On=="yes" || FromCols2On=="yes">
               <#if  GridAlreadyClosed=="no" >
                </h:panelGrid>
               </#if>
              </#if> 
              <#if property.name?substring(2,3) == "g" >
               <h:panelGroup id="${property.name}Group"> 
               <#assign GroupOn="yes">
               <#assign GridAlreadyClosed="no">
              </#if>
              <h:panelGrid columns="1">
              <#assign TempCols1On="yes">
              <#assign TempCols2On="no">
    <#elseif menuAttributesFunction ="1s" && cIndex = 3>
                </h:panelGrid>
               </p:panel>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${'#'}{messages['Once']} ${'#'}{messages['row']} ${'#'}{messages['value']} ${'#'}{messages['entered']}, ${'#'}{messages['you']} ${'#'}{messages['can']} ${'#'}{messages['enter']} ${'#'}{messages['seat']} ${'#'}{messages['values']} ${'#'}{messages['below']} ${'#'}{messages['and']} ${'#'}{messages['save']}, ${'#'}{messages['but']} ${'#'}{messages['easier']} ${'#'}{messages['option']} ${'#'}{messages['is']} ${'#'}{messages['to']} ${'#'}{messages['save']} ${'#'}{messages['rows']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['use']} ${'#'}{messages['assign']} ${'#'}{messages['seat']} ${'#'}{messages['link']} ${'#'}{messages['in']} ${'#'}{messages['List']} ${'#'}{messages['Seat']} ${'#'}{messages['rows']} 
               <p:panel>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:outputText value="${'#'}{messages['STAGE']}" />
                <h:panelGrid columns="200">
    <#elseif menuAttributesFunction ="5b" && cIndex = 1>
                </h:panelGrid>
               </p:panel>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${'#'}{messages['Once']} ${'#'}{messages['row']} ${'#'}{messages['value']} ${'#'}{messages['entered']}, ${'#'}{messages['you']} ${'#'}{messages['can']} ${'#'}{messages['enter']} ${'#'}{messages['column']} ${'#'}{messages['values']} ${'#'}{messages['below']} ${'#'}{messages['and']} ${'#'}{messages['save']}, ${'#'}{messages['but']} ${'#'}{messages['easier']} ${'#'}{messages['option']} ${'#'}{messages['is']} ${'#'}{messages['to']} ${'#'}{messages['save']} ${'#'}{messages['rows']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['use']} ${'#'}{messages['assign']} ${'#'}{messages['column']} ${'#'}{messages['link']} ${'#'}{messages['in']} ${'#'}{messages['List']} ${'#'}{messages['Import']} ${'#'}{messages['Csv']} 
               <p:panel>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:outputText value="${'#'}{messages['row']} ${'#'}{messages['th']} ${'#'}{messages['reserved']} ${'#'}{messages['for']} ${'#'}{messages['Table']} ${'#'}{messages['column']} ${'#'}{messages['names']} ${'#'}{messages['for']} ${'#'}{messages['mapping']}" />
                <h:panelGrid columns="200">
    <#else>
              <!-- begin non component non date non long string, either continue or should end col 1 or 2 &
                switch back to 8 or 2 columns depending on where it came from  -->
                <#if property.name?substring(2,3) == "g" >
                 <h:panelGroup id="${property.name}Group"> 
                 <#assign GroupOn="yes">
                 <#assign GridAlreadyClosed="no">
                </#if>
                <#if TempCols1On=="yes" || TempCols2On=="yes">
                 </h:panelGrid>
                 <#if FromCols8On=="yes">
                  <h:panelGrid columns="4">
                  <#assign TempCols1On="no">
                  <#assign TempCols2On="no">
                 </#if>
                 <#if FromCols2On=="yes">
                  <h:panelGrid columns="2">
                  <#assign TempCols1On="no">
                  <#assign TempCols2On="no">
                 </#if>
                </#if>
                <#assign GridAlreadyClosed="no">
    </#if> 
    <#-- elesif order is important higher will take precedence, so owner (to at 5,7) will not be renderd even if it starts w z. renewal/availibility, expiry item fields are added/changed via by transaction only like vendor order will put availibility date
    -->
      <#-- debug ${property.name} -->

    <#if property.name?substring(8,9) == "h" >
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('EH')}">
    <#elseif property.name?substring(12,13) == "s" & property.name?substring(13,14) == "a"  >
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
    <#elseif (property.name?substring(8,9) == "l" && (property.name?substring(pfS,pfE)!="tp" || !property.name?contains("datetorenew"))) ||  property.name?substring(8,9) == "x" 
            ||  property.name?substring(5,7) == "to" ||  property.name?substring(5,7) == "2o"  >
     <#--oct10 2018 list only but for repair allow  nov16 2020 allow UH if clobdata-->
           <#if menuAttributesFunction ="1m">
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('SH') or customIdentity.hasRole('UH') or customIdentity.hasRole('EH')?true:false}">
           <#else>
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('SH') or customIdentity.hasRole('EH')?true:false}">
           </#if>
    <#-- if source2,misccode1 , 2 already shown then make render false here --> 
    <#elseif menuAttributesFunction ="1a" & (property.name?substring(property.name?length-6,property.name?length)=="ource2" || property.name?substring(property.name?length-6,property.name?length-1)=="ccode") >
           <h:panelGroup id="${property.name}Decoration"  rendered="false">
    <#elseif property.name?substring(0,1) == "y" || property.name?substring(0,1) == "z"  && property.name?substring(pfS,pfE)!="tp" >
     <#if property.name?substring(8,9) == "s" >
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('SH') or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and !(customIdentity.restrict1=='D')}">
     <#else>
            <h:panelGroup id="${property.name}Decoration"  rendered="true">
     </#if>
    <#elseif property.name?substring(5,6) == "d" || property.name?substring(6,8) == "up"  >
            <h:panelGroup id="${property.name}Decoration"  rendered="false">
    <#elseif property.name?substring(2,3) == "f" & property.name?substring(3,4) == "b" && property.name?substring(6,8)!="sc" >
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
    <#elseif property.name?substring(pkS,pkE)=="k" && keyfromsubkeys=="Y"> 
           <#--oct05 2018 temp, fix reveng.xml later -->
           <#if ( menuAttributesFunction?contains("63") )>
            <h:panelGroup id="${property.name}Decoration"   rendered="true" >
           <#else>
            <h:panelGroup id="${property.name}Decoration"   rendered="false" >
           </#if>
    <#elseif property.name?substring(8,9) == "i" >
            <h:panelGroup id="${property.name}Decoration"  rendered="true">
    <#elseif property.name?substring(8,9) == "s" >
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{customIdentity.hasRole('SH') or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and !(customIdentity.restrict1=='D')}">
    <#elseif property.name?substring(14,15) != "x" >
            <h:panelGroup id="${property.name}Decoration"  rendered="${'#'}{identity.size==${property.name?substring(14,15)?upper_case}}">
    <#else>   
          <#if property.name?substring(pkS,pkE)=="n">
            <h:panelGroup id="${property.name}Decoration" rendered="${'#'}{${homeName}.managed}"   >
          <#else>
           <#if menuAttributesFunction ="5a" >
            <#if cIndex == 1>
            <h:panelGroup id="${property.name}Decoration"  rendered="false" >
            <#elseif cIndex == 2>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{yxxxch5a1xhhxxhxxxxxtruefalseList.selectedQualifier}" 
              rendered="true">
              <f:selectItem id="item1" itemLabel="default" itemValue="de" />
              <f:selectItem id="item2" itemLabel="demographic(name-address)" itemValue="dg" />
              <f:selectItem id="item3" itemLabel="metrics(quantity)" itemValue="me" />
              <f:selectItem id="item4" itemLabel="adhoc-1" itemValue="a1" />
              <f:selectItem id="item5" itemLabel="adhoc-2" itemValue="a2" />
            </h:selectOneMenu>
             </h:panelGrid>
            <h:panelGroup id="${property.name}Decoration"  rendered="false" >
            <#else>
            <h:panelGroup id="${property.name}Decoration"    >
            </#if> 
           <#else>
            <#if property.name?substring(6,8) != "sc"> 
             <h:panelGroup id="${property.name}Decoration"    >
            </#if>
           </#if>
          </#if>
    </#if>
   </#if>
<#--jay add logic based on locale to show or hide tax1 etc fields
     but should based on messages so that not hard coded ie if message is null for a locale it means not used 
-->
   <#if (property.name?length > 12)>
    <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="cp") && (property.name?substring(5,6)=="l" || property.name?substring(5,6)=="m" || property.name?substring(pefS,pefE)=="z1" || property.name?substring(pefS,pefE)=="z2" || property.name?substring(pefS,pefE)=="z3") > 
       <#if property.name?substring(5,6)=="l"> 
       <h:outputLabel  for="${property.name}" value="${'#'}{messages['${customerInvoiceEtcItemDetailsDeliveryFieldName?substring(pL)?cap_first}']}">
       <#elseif property.name?substring(5,6)=="m"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['${customerInvoiceEtcItemDetailsMiscelleneousFieldName?substring(pL)?cap_first}']}">
       <#elseif property.name?substring(pefS,pefE)=="z1"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['Tax1']}">
       <#elseif property.name?substring(pefS,pefE)=="z2"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['Tax2']}">
       <#elseif property.name?substring(pefS,pefE)=="z3"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['Tax3']}">
       </#if>
    <#elseif (pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="vp") && (property.name?substring(5,6)=="l" || property.name?substring(5,6)=="m" || property.name?substring(pefS,pefE)=="z1" || property.name?substring(pefS,pefE)=="z2" || property.name?substring(pefS,pefE)=="z3")  > 
       <#if property.name?substring(5,6)=="l"> 
       <h:outputLabel  for="${property.name}" value="${'#'}{messages['${vendorInvoiceEtcItemDetailsDeliveryFieldName?substring(pL)?cap_first}']}">
       <#elseif property.name?substring(5,6)=="m"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['${vendorInvoiceEtcItemDetailsMiscelleneousFieldName?substring(pL)?cap_first}']}">
       <#elseif property.name?substring(pefS,pefE)=="z1"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['Tax1']}">
       <#elseif property.name?substring(pefS,pefE)=="z2"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['Tax2']}">
       <#elseif property.name?substring(pefS,pefE)=="z3"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['Tax3']}">
       </#if>
    <#elseif menuAttributesFunction ="1a" >
       <#if property.name?substring(pefS,pefE)=="z1"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['override']} ${'#'}{messages['Tax1']}">
       <#elseif property.name?substring(pefS,pefE)=="z2"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['override']} ${'#'}{messages['Tax2']}">
       <#elseif property.name?substring(pefS,pefE)=="z3"> 
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['override']} ${'#'}{messages['Tax3']}">
       <#elseif property.name?substring(6,8) == "sc" || property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
       <#else>
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
       </#if>
    <#else>
    <#-- truefalse edit will show table,qualifier columns followed by show001,002 etc which corresponds to other table columns
         starting after its sid column    
         table.qualifier fields will get filled up by show column name action
         showColumnNames starts with index 0 and pints to column after sid, sid is not considered as property ?
         truefalse column/property show001 corresponds to other table showColumnNames index 0 and corresponds to cIndex-3  
         apr27 2020 need to be fixed since report parameter show001 expects sid
         fix is to leave <h:outputLabel index as is but change <h:selectOneRadio id say show001 but value as show002
    --> 
     <#if menuAttributesFunction ="5a" >
      <#if (cIndex > 2) >
      <h:outputLabel  for="${property.name}" value="${'#'}{messages[${listName}.showColumnNames[${cIndex-3}]]}">
      <#else>
           <#if cIndex == 2>
      <h:outputLabel  for="${property.name}" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
           <#else>
      <h:outputLabel  for="${property.name}" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
           </#if>
      </#if>
     <#else>
      <#if property.name?substring(5,7)=="zn">
       <h:outputLabel  for="${property.name}ed" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
      <#else>
       <#if menuAttributesFunction ="1s">
        <#if property.name?substring(20,22)="se">
         <h:outputLabel  for="${property.name}" value="st${property.name?substring(24,27)}">
        <#elseif property.name?substring(20,22)="na">
         <h:outputLabel  for="${property.name}" value="nme${property.name?substring(24,27)}">
        <#elseif property.name?substring(20,22)="ti">
         <h:outputLabel  for="${property.name}" value="tkt${property.name?substring(26,29)}">
        <#elseif property.name?substring(20,22)="po">
         <h:outputLabel  for="${property.name}" value="po${property.name?substring(22,25)}">
        <#else>
         <h:outputLabel  for="${property.name}" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
        </#if>
       <#elseif menuAttributesFunction ="5b">
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
       <#else>
        <h:outputLabel  for="${property.name}" value="${'#'}{messages['${property.name?substring(pL)?cap_first}']}">
       </#if>             
      </#if>
     </#if>
    </#if>
     <#if menuAttributesFunction ="1a" && (property.name?substring(6,8) == "sc" || property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3")>
     <#else>
      </h:outputLabel>
     </#if>
   </#if>
   <#--end of outputLabel for and below is for input for diff property type --> 
   <#if (property.name?length > 12)>
   <#if propertyType?contains("ate")>
    <#if property.name?substring(6,8) == "sd">
     <p:datePicker id="${property.name}" 
    <#else>   
     <p:datePicker id="${property.name}" 
    </#if>   
    
    <#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
    </#if>
    
    <#if !column.nullable>
                       required="true"
    </#if>
              <#if property.name?substring(4,5) == "d" && menuAttributesFunction !="89" >
                          value="${'#'}{${homeName}.instance.${property.name}}" >
              <#else>
                      showTime="true" value="${'#'}{${homeName}.instance.${property.name}}" >
              </#if>
              <#if propertyType?contains("ate") || propertyType?contains("ime") || propertyType?contains("imestamp")>
                </p:datePicker>
              <#else>
               </inputText>
              </#if>
               <#if menuAttributesFunction =="89">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <p:commandButton id="calRefresh${property.name}" image="/img/Reload16.png"
                          value="${'#'}{messages.reFresh}" render="@form"
                          action="${'#'}{${homeName}.validateAndSetseDates}"/>
               </#if>
   <#elseif propertyType?contains("ime")>
    <#if property.name?substring(6,8) == "sd">
     <p:datePicker id="${property.name}" 
    <#else>   
     <p:datePicker id="${property.name}" 

    </#if>   
    <#if !column.nullable>
                       required="true"
    </#if>
              <#if property.name?substring(4,5) == "d" && menuAttributesFunction !="89">
                          value="${'#'}{${homeName}.instance.${property.name}}" >
              <#else>
                          showTime="true" value="${'#'}{${homeName}.instance.${property.name}}" >
              </#if>
              <#if propertyType?contains("ate") || propertyType?contains("ime") || propertyType?contains("imestamp")>
                </p:datePicker>
              <#else>
               </inputText>
              </#if>
               <#if menuAttributesFunction =="89">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <p:commandButton id="calRefresh${property.name}" image="/img/Reload16.png"
                          value="${'#'}{messages.reFresh}" render="@form"
                          action="${'#'}{${homeName}.validateAndSetseDates}"/>
               </#if>
   <#elseif propertyType == "timestamp">
    <#if property.name?substring(6,8) == "sd">
     <p:datePicker id="${property.name}" 
    <#else>   
     <p:datePicker id="${property.name}" 
    </#if>   
    <#if !column.nullable>
                       required="true"
    </#if>
    <#if property.name?substring(4,5)=="d" && menuAttributesFunction !="89">
                          value="${'#'}{${homeName}.instance.${property.name}}"/>
    <#else>
                          showTime="true" value="${'#'}{${homeName}.instance.${property.name}}"/> 
    </#if>
              <#if propertyType?contains("ate") || propertyType?contains("ime") || propertyType?contains("imestamp")>
                </p:datePicker>
              <#else>
               </inputText>
              </#if>

   <#elseif propertyType?contains("ecimal")>
    <#if (pentityFunction=="cq" || pentityFunction=="co" || pentityFunction=="ci" || pentityFunction=="cp") && (property.name?substring(5,6)=="l" || property.name?substring(5,6)=="m" || property.name?substring(6,8)=="z1" || property.name?substring(6,8)=="z2" || property.name?substring(6,8)=="z3") > 
        <h:inputText id="${property.name}" 
                           <#-- apr16 2019 use 6,8 pefs 6 not 5,6 for tax and allow update, note parent entity checked 
                            but instead detail property used 1:1 field ${property.name} -->
                            
                           size="${column.precision+7}"
                           <#if property.name?substring(5,6)=="l" > 
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsDeliveryFieldName}}:this.value;"
                            <#if pentityFunction =="cp">
                            disabled="false"
                            </#if>
                            value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsDeliveryFieldName}}">
                           <#elseif property.name?substring(5,6)=="m" >
                            <#if pentityFunction =="cp">
                            disabled="false"
                            </#if>
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsMiscelleneousFieldName}}:this.value;"
                            value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsMiscelleneousFieldName}}">
                            <ui:remove>
                            <f:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="select" render="matcodeTDecoration,matcodeDecorationmis" bypassUpdates="false"/>
                            </ui:remove> 
                           <#elseif property.name?substring(pefS,pefE)=="z1">
                            disabled="false"
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsTax1FieldName}}:this.value;"
                            value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsTax1FieldName}}">
                           <#elseif property.name?substring(pefS,pefE)=="z2">
                            disabled="false"
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsTax2FieldName}}:this.value;"
                            value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsTax2FieldName}}">
                           <#elseif property.name?substring(pefS,pefE)=="z3">
                            disabled="false"
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsTax3FieldName}}:this.value;"
                            value="${'#'}{${customerInvoiceEtcItemDetailsEntityName}Home.instance.${customerInvoiceEtcItemDetailsTax3FieldName}}">
                           </#if>
         </h:inputText>
    <#elseif (pentityFunction=="vq" || pentityFunction=="vo" || pentityFunction=="vi" || pentityFunction=="vp") && (property.name?substring(5,6)=="l" || property.name?substring(5,6)=="m" || property.name?substring(6,8)=="z1" || property.name?substring(6,8)=="z2" || property.name?substring(6,8)=="z3")  > 
        <h:inputText id="${property.name}" 
                           size="${column.precision+7}"
       <#if property.name?substring(5,6)=="l" > 
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsDeliveryFieldName}}:this.value;"
                            <#if pentityFunction =="vp">
                            disabled="true"
                            </#if>
              value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsDeliveryFieldName}}">
       <#elseif property.name?substring(5,6)=="m" >
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsDeliveryFieldName}}:this.value;"
                            <#if pentityFunction =="vp">
                            disabled="true"
                            </#if>
                          value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsMiscelleneousFieldName}}">
       <#-- apr16 2019 use 6,8 not 5,6 and allow update -->
       <#elseif property.name?substring(pefS,pefE)=="z1">
                   disabled="false"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsTax1FieldName}}:this.value;"
                          value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsTax1FieldName}}">
       <#elseif property.name?substring(pefS,pefE)=="z2">
                   disabled="false"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsTax2FieldName}}:this.value;"
                          value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsTax2FieldName}}">
       <#elseif property.name?substring(pefS,pefE)=="z3">
                   disabled="false"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsTax3FieldName}}:this.value;"
                          value="${'#'}{${vendorInvoiceEtcItemDetailsEntityName}Home.instance.${vendorInvoiceEtcItemDetailsTax3FieldName}}">
       </#if>
         </h:inputText>
    <#else>
<#-- jay inoutText ${property.name} -->
      <h:inputText id="${property.name}"  
         <#if property.name?substring(pkS,pkE)=="k" && keyfromsubkeys!="Y">
          <#if menuAttributesFunction !="59" && menuAttributesFunction !="1m">
           validator="${'#'}{${homeName}.validateKeyDuplicate${centityKeyFieldName?substring(12)?cap_first}}" 
          </#if>
         </#if>
         <#if !column.nullable | property.name?substring(pkS,pkE)=="s" >
                      <#if property.name?substring(pkS,pkE)=="n">
                       required="false"
                       rendered="${'#'}{${homeName}.managed}" 
                       disabled="${'#'}{${homeName}.managed}"
                      <#else>
                       label="${property.name?substring(pL)}"
                       required="true"
                      </#if>
         </#if>
         value="${'#'}{${homeName}.instance.${property.name}}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${homeName}.instance.${property.name}}:this.value;"
      size="${column.precision+7}">
       <#if property.name?substring(5,7) == "a1" || property.name?substring(5,7) == "a2" || property.name?substring(5,7) == "a3" || property.name?substring(5,7) == "a4"
                    || property.name?substring(5,7) == "a5" || property.name?substring(5,7) == "a6" || property.name?substring(5,7) == "a7"
                    || property.name?substring(5,7) == "a8"|| property.name?substring(5,7) == "a9"  || property.name?substring(5,7) == "aa"
                    || property.name?substring(5,7) == "ab"|| property.name?substring(5,7) == "ac">
                  <f:ajax   listener="${'#'}{${homeName}.recalculateTotalThis()}" event="keyup" render="e4xxzatrbvxxxxxxxxxxperiodtotals" bypassUpdates="false"/>
       <#elseif property.name?substring(5,7) == "b1" || property.name?substring(5,7) == "b2" || property.name?substring(5,7) == "b3" || property.name?substring(5,7) == "b4"
                    || property.name?substring(5,7) == "b5" || property.name?substring(5,7) == "b6" || property.name?substring(5,7) == "b7"
                    || property.name?substring(5,7) == "b8"|| property.name?substring(5,7) == "b9"  || property.name?substring(5,7) == "ba"
                    || property.name?substring(5,7) == "bb"|| property.name?substring(5,7) == "bc" >
                  <f:ajax   listener="${'#'}{${homeName}.recalculateTotalThis()}" event="keyup" render="e3xxzbtrbvxxxxxxxxxxperiodtotalsb" bypassUpdates="false"/>
       <#else>
       </#if>
     </h:inputText>
     <#--mar09 2018 discount -->
     <#if property.name?substring(5,7) == "zi">
	    <h:selectOneRadio value="${'#'}{${homeName}.discountType}" required="false" id="${property.name}di" rendered="${'#'}{${homeName}.instance.${property.name} ne null}">
				<f:selectItem  
                         itemLabel="Value"
                         itemValue="va" /> 
				<f:selectItem  
                         itemLabel="%"
                         itemValue="pe" /> 
         </h:selectOneRadio>
     </#if>
    </#if>
   <#elseif propertyType == "big_integer">
               <h:inputText id="${property.name}" 
     <#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
     </#if>
     <#if !column.nullable>
                       required="true"
     </#if>
                          value="${'#'}{${homeName}.instance.${property.name}}"
                          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${homeName}.instance.${property.name}}:this.value;"
                           size="${column.precision+6}">
                </h:inputText>
   <#elseif propertyType == "java.lang.Integer">
    <#if property.name?substring(6,8) == "ns">
                &nbsp;<p:spinner id="${property.name}" 
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           inputSize="2"
                           step="1">
                    </p:spinner>
    <#elseif property.name?substring(6,8) == "dh"> 
                <p:remoteCommand name="${property.name}Function" process="${property.name}"  actionListener="${'#'}{${homeName}.validateAndSetseDates}"/>
                &nbsp;<p:spinner id="${property.name}"  onchange="${property.name}Function()"
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           maxValue="12"
                           minValue="0"
                           inputSize="2"
                           step="1">
                    </p:spinner>
    <#elseif property.name?substring(6,8) == "dm" || property.name?substring(6,8) == "sm" > 
                <p:remoteCommand name="${property.name}Function" process="${property.name}"  actionListener="${'#'}{${homeName}.validateAndSetseDates}"/>
                &nbsp;<p:spinner id="${property.name}"  onchange="${property.name}Function()"
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           maxValue="60"
                           minValue="0"
                           inputSize="2"
                           step="15">
                    </p:spinner>
    <#elseif property.name?substring(6,8) == "sh"> 
                <p:remoteCommand name="${property.name}Function" process="${property.name}"  actionListener="${'#'}{${homeName}.validateAndSetseDates}"/>
                &nbsp;<p:spinner id="${property.name}"  onchange="${property.name}Function()"
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           maxValue="12"
                           minValue="0"
                           inputSize="2"
                           step="1">
                    </p:spinner>
    <#else>
                <h:inputText id="${property.name}" 
     <#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
     </#if>
     <#if !column.nullable | property.name?substring(pkS,pkE)=="s">
                       required="true"
                       label="${property.name?substring(pL)}"
     </#if>
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           size="${column.precision+2}">
                   <#if property.name?substring(6,8) == "du">
                    <f:ajax listener="${'#'}{${homeName}.validateAndSetseDates}"  event="keyup" render="b6xxceedbvxxxxxxxxxxedatetDecoration" bypassUpdates="false"/>
                   <#else>
                   </#if>
                </h:inputText>
    </#if>
   <#elseif propertyType == "java.lang.Boolean" || propertyType == "yes_no" || propertyType == "true_false">
     <#if property.name?substring(4,5) == "y" || property.name?substring(6,8) == "sa" >
                <h:selectOneRadio id="${property.name}"
                 <#if !column.nullable>
                                    required="true"
                 </#if>
                 <#if propertyIsId>
                                    disabled="${'#'}{${homeName}.managed}"
                 </#if>
                                    value="${'#'}{${homeName}.instance.${property.name}}">
                 <#if property.name?substring(6,8) == "sa" >
                  <f:selectItem itemValue="${'#'}{true}" itemLabel="AM" />
                  <f:selectItem itemValue="${'#'}{false}" itemLabel="PM" />
                 <#else>
                  <f:selectItem itemValue="${'#'}{true}" itemLabel="Yes" />
                  <f:selectItem itemValue="${'#'}{false}" itemLabel="No" />
                 </#if>  
                   <#if property.name?substring(5,7) == "wn">
                    <f:ajax listener = "${'#'}{${homeName}.showtemprunt}" ajaxSingle="true" event="change" render="matcodeDecorationtax2T" bypassUpdates="false"/>
                   </#if> 
                   <#if property.name?substring(6,8) == "sa">
                    <#-- jsf radio button event is click but does not seem to ajax -->
                    <f:ajax   listener="${'#'}{${homeName}.validateAndSetseDates}"   event="click"  render="b5gxdxsdbvxxxxxxxxxxsdatetDecoration,b8xxceedbvxxxxxxxxxxedatetDecoration,b2xxuxsxbvxxxxxxxxxxssdatetDecoration" bypassUpdates="false"/>
                   </#if> 
                </h:selectOneRadio>
     <#else>
                <h:selectBooleanCheckbox id="${property.name}"
      <#if !column.nullable>
                                   required="true"
      </#if>
      <#if propertyIsId>
                                   disabled="${'#'}{${homeName}.managed}"
      </#if>
                                      value="${'#'}{${homeName}.instance.${property.name}}">
                   <#if property.name?substring(6,8) == "sa">
                    <f:ajax   listener="${'#'}{${homeName}.validateAndSetseDates}"   event="change"  render="b5gxdxsdbvxxxxxxxxxxsdatetDecoration,b8xxceedbvxxxxxxxxxxedatetDecoration,b2xxuxsxbvxxxxxxxxxxssdatetDecoration" bypassUpdates="false"/>
                   </#if> 
                   <#if property.name?substring(5,7) == "wn">
                    <f:ajax listener = "${'#'}{${homeName}.showtemprunt}"  event="change" render="matcodeDecorationtax2T" bypassUpdates="false"/>
                   </#if> 
                   <ui:remove>oct27 2019 added ajax to reinvoke setter otherwise page load was initializing value</ui:remove>
                   <f:ajax  render="${property.name}" bypassUpdates="false"/>
                 </h:selectBooleanCheckbox>
    </#if>
   <#elseif propertyType?contains("tring")>
     <#if column.length gt 160>
      <#if column.length gt 800>
       <#assign rows = 10>
      <#else>
       <#assign rows = (column.length/80)?int>
      </#if>
      <#if property.name?substring(5,7) == "c1" || property.name?substring(5,7) == "c2" || property.name?substring(5,7) == "c3" || property.name?substring(5,7) == "c4"
                    || property.name?substring(5,7) == "c5" || property.name?substring(5,7) == "c6" || property.name?substring(5,7) == "c7"
                    || property.name?substring(5,7) == "c8"|| property.name?substring(5,7) == "c9"  || property.name?substring(5,7) == "ca"
                    || property.name?substring(5,7) == "cb"|| property.name?substring(5,7) == "cc" || property.name?substring(5,7) == "c0"|| property.name?substring(5,7) == "ct">
          <h:inputTextarea id="${property.name}" 
                   size="32"
                   maxlength="${column.length}"
                   onchange ="calculate(this);"
                   value="${'#'}{${homeName}.instance.${property.name}}">
          </h:inputTextarea>
      <#elseif property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="za" || property.name?substring(5,7)=="zb"  >
       <#-- inputtext is disabled otherwise value becomes null -->
          <h:inputTextarea id="${property.name}" 
                   readonly="true"
                   size="${size}"
                  <#if column.length gt 255>
                   maxlength="255"
                  <#else>                       
                   maxlength="${column.length}"
                  </#if>
                   value="${'#'}{${homeName}.instance.${property.name}}">
          </h:inputTextarea>
         <#if property.name?substring(5,7)=="za">  
           <p:tooltip for="${property.name}o"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: xml,txt,csv"/></span> </p:tooltip> 
         <#elseif property.name?substring(5,7)=="zb"> 
           <p:tooltip for="${property.name}o"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: jpg, gif, png, bmp, pdf, doc, xls, mp3, mp4"/></span> </p:tooltip> 
         <#else> 
           <p:tooltip for="${property.name}o"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: jpg, gif, png, bmp, xml,doc,txt,pdf, doc,xls, mp3, mp4"/></span> </p:tooltip> 
         </#if>
         <ui:remove>xss attack possible via direct input of html, server santize added using jsoup</ui:remove>
         <ui:remove>jul30 2019 check for mastersite removed to allow for all but for clobdata csv only logic in bean </ui:remove>
         <h:selectOneRadio value="${'#'}{${homeName}.upLoadPurpose}" required="false" id="${property.name}d" rendered="${'#'}{${homeName}.instance.${property.name}.length() >2}">
          <f:selectItem  
           itemLabel="Add"
           itemValue="ad" /> 
          <f:selectItem  
           itemLabel="Replace"
           itemValue="re" /> 
         </h:selectOneRadio>
         <ui:remove>For now, Item entity only</ui:remove>
         <h:commandLink action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.removeImage()}"
          value="${'#'}{messages['Remove']}" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt.length() >2}" />
         <o:inputFile  id="${property.name}o" value="${'#'}{file.lfiles}" multiple="true" 
          accept="text/*,text/csv,.csv,text/comma-separated-values"/>
         <h:commandButton value="Upload" action="${'#'}{file.fileUpload('clobblob')}"/>
         <br />
         <p:panel rendered="${'#'}{not empty file.data}">
          <h:commandButton action="${'#'}{${homeName}.clearUploadData}"
            value="${'#'}{messages['Clear']} ${'#'}{messages['Uploaded']} ${'#'}{messages['Data']}"/>
          ${'#'}{messages['Uploaded']}&nbsp;
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[0].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].data}" />
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[1].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[1].data}" />
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[2].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[2].data}" />
          <h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[0].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].text}" />
          ${'#'}{messages['Doc2:']}<h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[1].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[1].text}" />
          ${'#'}{messages['Doc3:']}<h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[2].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[2].text}" />
         </p:panel>
         <ui:remove>
          <h:outputText value="${'#'}{${homeName}.clobdata}" rendered="${'#'}{${homeName}.instance.${property.name}.length() >2}"  />
         p:upload  needs conversation or session bean to work, so have xxx.page with begin conversaation
         </ui:remove>
                  ${'#'}{messages['Saved']}&nbsp;
                <h:outputText escape="false"  value="${'#'}{${itemEntityName}Home.getClobdata('${itemEntityName}?upper_case',customIdentity.holdValue,'TXT',0,12000)}"  />
                <pe:ckEditor id="b1xxuzaxbvxxxxxxxxxxdataed" height="50" width="100%"  value="${'#'}{${homeName}.instance.${property.name}}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
                </pe:ckEditor>
      <#else>
        <#if property.name?substring(5,7)!="zn">
                <h:inputTextarea id="${property.name}"
                               cols="80"
                               rows="${rows}"
        <#else>
         <h:panelGrid>
                <pe:ckEditor id="${property.name}ed" height="50" width="100%"  value="${'#'}{${homeName}.instance.${property.name}}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
                </pe:ckEditor>
         </h:panelGrid>
        </#if> 
       <#if propertyIsId>
                           disabled="${'#'}{${homeName}.managed}"
       </#if>
       <#if !column.nullable  && !column.unique>
                           required="false"
       </#if>
                         <#if property.name?substring(5,7)!="zn">
                              value="${'#'}{${homeName}.instance.${property.name}}"/>
                         </#if>
      </#if>
     <#else>
      <#-- column length less than 160 ${property.name} -->
      <#if column.length gt 100>
       <#assign size = 32>
      <#else>
       <#if column.length gt 50>
        <#assign size = 28>
       </#if>
       <#assign size = 20>
      </#if>
      <#if (property.name?length > 12)>
       <#if !(property.name?substring(11,12)?contains("x") || property.name?substring(11,12)?contains("i") || property.name?substring(11,12)?contains("u") )>
        <#if (property.name?substring(4,5)?contains("g"))>
            <#if property.name?substring(10,12)== "01" >
             <#assign OptionField=genOptionField01 >
             <#assign PurposeField=genPurposeField01 >
             <#assign ValueField=genValueField01 >
            <#elseif property.name?substring(10,12)== "02" >
             <#assign OptionField=genOptionField02 >
             <#assign PurposeField=genPurposeField02 >
             <#assign ValueField=genValueField02 >
            <#elseif property.name?substring(10,12)== "03" >
             <#assign OptionField=genOptionField03 >
             <#assign PurposeField=genPurposeField03 >
             <#assign ValueField=genValueField03 >
            <#elseif property.name?substring(10,12)== "04" >
             <#assign OptionField=genOptionField04 >
             <#assign PurposeField=genPurposeField04 >
             <#assign ValueField=genValueField04 >
            <#elseif property.name?substring(10,12)== "05" >
             <#assign OptionField=genOptionField05 >
             <#assign PurposeField=genPurposeField05 >
             <#assign ValueField=genValueField05 >
            <#elseif property.name?substring(10,12)== "06" >
             <#assign OptionField=genOptionField06 >
             <#assign PurposeField=genPurposeField06 >
             <#assign ValueField=genValueField06 >
            <#elseif property.name?substring(10,12)== "07" >
             <#assign OptionField=genOptionField07 >
             <#assign PurposeField=genPurposeField07 >
             <#assign ValueField=genValueField07 >
            <#elseif property.name?substring(10,12)== "08" >
             <#assign OptionField=genOptionField08 >
             <#assign PurposeField=genPurposeField08 >
             <#assign ValueField=genValueField08 >
            <#elseif property.name?substring(10,12)== "09" >
             <#assign OptionField=genOptionField09 >
             <#assign PurposeField=genPurposeField09 >
             <#assign ValueField=genValueField09 >
            <#elseif property.name?substring(10,12)== "10" >
             <#assign OptionField=genOptionField10 >
             <#assign PurposeField=genPurposeField10 >
             <#assign ValueField=genValueField10 >
            <#elseif property.name?substring(10,12)== "11" >
             <#assign OptionField=genOptionField11 >
             <#assign PurposeField=genPurposeField11 >
             <#assign ValueField=genValueField11 >
            <#elseif property.name?substring(10,12)== "12" >
             <#assign OptionField=genOptionField12 >
             <#assign PurposeField=genPurposeField12 >
             <#assign ValueField=genValueField12 >
            <#elseif property.name?substring(10,12)== "13" >
             <#assign OptionField=genOptionField13 >
             <#assign PurposeField=genPurposeField13 >
             <#assign ValueField=genValueField13 >
            <#elseif property.name?substring(10,12)== "14" >
             <#assign OptionField=genOptionField14 >
             <#assign PurposeField=genPurposeField14 >
             <#assign ValueField=genValueField14 >
            <#elseif property.name?substring(10,12)== "15" >
             <#assign OptionField=genOptionField15 >
             <#assign PurposeField=genPurposeField15 >
             <#assign ValueField=genValueField15 >
            <#elseif property.name?substring(10,12)== "16" >
             <#assign OptionField=genOptionField16 >
             <#assign PurposeField=genPurposeField16 >
             <#assign ValueField=genValueField16 >
            <#elseif property.name?substring(10,12)== "17" >
             <#assign OptionField=genOptionField17 >
             <#assign PurposeField=genPurposeField17 >
             <#assign ValueField=genValueField17 >
            <#elseif property.name?substring(10,12)== "18" >
             <#assign OptionField=genOptionField18 >
             <#assign PurposeField=genPurposeField18 >
             <#assign ValueField=genValueField18 >
            <#elseif property.name?substring(10,12)== "19" >
             <#assign OptionField=genOptionField19 >
             <#assign PurposeField=genPurposeField19 >
             <#assign ValueField=genValueField19 >
            <#elseif property.name?substring(10,12)== "20" >
             <#assign OptionField=genOptionField20 >
             <#assign PurposeField=genPurposeField20 >
             <#assign ValueField=genValueField20 >
           <#else >
             <#assign OptionField=genOptionField01 >
             <#assign PurposeField=genPurposeField01 >
             <#assign ValueField=genValueField01 >
            </#if>
          <#-- no autocomplete, add one or two f:selectItem ahead of f:selectItems. f:selectItem would select last used ones
          --> 
             <#if OptionField?contains("38") || OptionField?contains("39") >
              <h:selectOneMenu id="${property.name}" value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   disabled="${'#'}{!(customIdentity.hasRole('UH')||customIdentity.hasRole('BH') || customIdentity.hasRole('CH') || customIdentity.hasRole('IH')) || customIdentity.username == ${homeName}.instance.${property.name}}"
              >
             <#elseif OptionField?contains("49")>
               <h:inputText value= "${'#'}{${homeName}.instance.a1xxuxxxbv49xxxxxxxxfromkey}" disabled="true"
              <#if menuAttributesFunction ="1m" || menuAttributesFunction ="1n" || menuAttributesFunction ="60" >
               <h:panelGrid columns="2">
                <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}" rendered="${'#'}{!fn:endsWith(${homeName}.instance.${property.name},'-M')}">
                  <f:ajax  render="${property.name}I" bypassUpdates="false"/>
              </#if>
             <#elseif OptionField?contains("50")>
               <h:inputText value= "${'#'}{${homeName}.instance.${property.name}}" disabled="true"
                  rendered="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype=='theme'}"/>
              <#if menuAttributesFunction ="1m" || menuAttributesFunction ="1n" >
               <h:panelGrid columns="2">
                <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}" 
                    rendered="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype!='theme'}">
                  <f:ajax  render="${property.name}I" bypassUpdates="false"/>
              </#if>
             <#elseif OptionField?contains("35") && menuAttributesFunction ="89" >
                <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" >
                  <f:ajax  render="${property.name}I" bypassUpdates="false"/>
             <#else>
                  <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}">
             </#if>
                        <f:ajax  render="${property.name}I" bypassUpdates="false"/>
                        <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                        <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n") >
                         <f:selectItem itemValue="3R-ATTACHMENT-1-C" itemLabel="${'#'}{messages['You']} ${'#'}{messages['can']} ${'#'}{messages['keyin']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}" />
                        </#if>
                        <#if OptionField?contains("35") && menuAttributesFunction ="89">
                         <f:selectItem itemValue="Lunch Appontment" itemLabel="${'#'}{messages['You']} ${'#'}{messages['may']} ${'#'}{messages['keyin']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}" />
                        </#if>
                       <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('${menuAttributesFunction}',${property.name?substring(10,12)})}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
                         <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n")>
                          <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['this']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['this']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
                         </#if>
                         <#if OptionField?contains("01") && (menuAttributesFunction ="60" || menuAttributesFunction ="1n")>
                          <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Only']} ${'#'}{messages['one']} H ${'#'}{messages['but']} ${'#'}{messages['groups']} ${'#'}{messages['of']} Block Header B,Details D, SubTotal S and ${'#'}{messages['finallly']} ${'#'}{messages['one']} Total T "/></span> </p:tooltip> 
                         </#if>
                         <#if OptionField?contains("35") && menuAttributesFunction ="89" >
                          <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['this']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['this']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
                         </#if>
                         <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n")>
                          <f:ajax  render="${property.name}I" bypassUpdates="false"/>
                         </#if>
                  </h:selectOneMenu>
                <#if (OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n")) || (OptionField?contains("50") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n"))>
                 <h:inputText id="${property.name}I" value="${'#'}{${homeName}.instance.${componentProperty.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
                 </h:inputText>
                 </h:panelGrid>
                </#if>
                <#if OptionField?contains("59") && (menuAttributesFunction ="1f" )>
                 <h:inputText id="${property.name}I" value="${'#'}{${homeName}.instance.${componentProperty.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
                 </h:inputText>
                 </h:panelGrid>
                </#if>
                <#if OptionField?contains("01") && (menuAttributesFunction ="60" )>
                 <h:inputText id="${property.name}I" value="${'#'}{${homeName}.instance.${componentProperty.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}"
                          maxlength="200">
                 </h:inputText>
                 </h:panelGrid>
                </#if>
        <#else>
            <#if property.name?substring(10,12)== "01" >
             <#assign OptionField=optionField01 >
             <#assign PurposeField=purposeField01 >
             <#assign ValueField=valueField01 >
            <#elseif property.name?substring(10,12)== "02" >
             <#assign OptionField=optionField02 >
             <#assign PurposeField=purposeField02 >
             <#assign ValueField=valueField02 >
            <#elseif property.name?substring(10,12)== "03" >
             <#assign OptionField=optionField03 >
             <#assign PurposeField=purposeField03 >
             <#assign ValueField=valueField03 >
            <#elseif property.name?substring(10,12)== "04" >
             <#assign OptionField=optionField04 >
             <#assign PurposeField=purposeField04 >
             <#assign ValueField=valueField04 >
            <#elseif property.name?substring(10,12)== "05" >
             <#assign OptionField=optionField05 >
             <#assign PurposeField=purposeField05 >
             <#assign ValueField=valueField05 >
            <#elseif property.name?substring(10,12)== "06" >
             <#assign OptionField=optionField06 >
             <#assign PurposeField=purposeField06 >
             <#assign ValueField=valueField06 >
            <#elseif property.name?substring(10,12)== "07" >
             <#assign OptionField=optionField07 >
             <#assign PurposeField=purposeField07 >
             <#assign ValueField=valueField07 >
            <#elseif property.name?substring(10,12)== "08" >
             <#assign OptionField=optionField08 >
             <#assign PurposeField=purposeField08 >
             <#assign ValueField=valueField08 >
            <#elseif property.name?substring(10,12)== "09" >
             <#assign OptionField=optionField09 >
             <#assign PurposeField=purposeField09 >
             <#assign ValueField=valueField09 >
            <#elseif property.name?substring(10,12)== "10" >
             <#assign OptionField=optionField10 >
             <#assign PurposeField=purposeField10 >
             <#assign ValueField=valueField10 >
            <#elseif property.name?substring(10,12)== "11" >
             <#assign OptionField=optionField11 >
             <#assign PurposeField=purposeField11 >
             <#assign ValueField=valueField11 >
            <#elseif property.name?substring(10,12)== "12" >
             <#assign OptionField=optionField12 >
             <#assign PurposeField=purposeField12 >
             <#assign ValueField=valueField12 >
            <#elseif property.name?substring(10,12)== "13" >
             <#assign OptionField=optionField13 >
             <#assign PurposeField=purposeField13 >
             <#assign ValueField=valueField13 >
            <#elseif property.name?substring(10,12)== "14" >
             <#assign OptionField=optionField14 >
             <#assign PurposeField=purposeField14 >
             <#assign ValueField=valueField14 >
            <#elseif property.name?substring(10,12)== "15" >
             <#assign OptionField=optionField15 >
             <#assign PurposeField=purposeField15 >
             <#assign ValueField=valueField15 >
            <#elseif property.name?substring(10,12)== "16" >
             <#assign OptionField=optionField16 >
             <#assign PurposeField=purposeField16 >
             <#assign ValueField=valueField16 >
            <#elseif property.name?substring(10,12)== "17" >
             <#assign OptionField=optionField17 >
             <#assign PurposeField=purposeField17 >
             <#assign ValueField=valueField17 >
            <#elseif property.name?substring(10,12)== "18" >
             <#assign OptionField=optionField18 >
             <#assign PurposeField=purposeField18 >
             <#assign ValueField=valueField18 >
            <#elseif property.name?substring(10,12)== "19" >
             <#assign OptionField=optionField19 >
             <#assign PurposeField=purposeField19 >
             <#assign ValueField=valueField19 >
            <#elseif property.name?substring(10,12)== "20" >
             <#assign OptionField=optionField20 >
             <#assign PurposeField=purposeField20 >
             <#assign ValueField=valueField20 >
            <#elseif property.name?substring(10,12)== "21" >
             <#assign OptionField=optionField21 >
             <#assign PurposeField=purposeField21 >
             <#assign ValueField=valueField21 >
            <#elseif property.name?substring(10,12)== "22" >
             <#assign OptionField=optionField22 >
             <#assign PurposeField=purposeField22 >
             <#assign ValueField=valueField22 >
            <#elseif property.name?substring(10,12)== "23" >
             <#assign OptionField=optionField23 >
             <#assign PurposeField=purposeField23 >
             <#assign ValueField=valueField23 >
            <#elseif property.name?substring(10,12)== "24" >
             <#assign OptionField=optionField24 >
             <#assign PurposeField=purposeField24 >
             <#assign ValueField=valueField24 >
             <#elseif property.name?substring(10,12)== "25" >
             <#assign OptionField=optionField25 >
             <#assign PurposeField=purposeField25 >
             <#assign ValueField=valueField25 >
            <#elseif property.name?substring(10,12)== "26" >
             <#assign OptionField=optionField26 >
             <#assign PurposeField=purposeField26 >
             <#assign ValueField=valueField26 >
            <#elseif property.name?substring(10,12)== "27" >
             <#assign OptionField=optionField27 >
             <#assign PurposeField=purposeField27 >
             <#assign ValueField=valueField27 >
            <#elseif property.name?substring(10,12)== "28" >
             <#assign OptionField=optionField28 >
             <#assign PurposeField=purposeField28 >
             <#assign ValueField=valueField28 >
            <#elseif property.name?substring(10,12)== "29" >
             <#assign OptionField=optionField29 >
             <#assign PurposeField=purposeField29 >
             <#assign ValueField=valueField29 >
            <#elseif property.name?substring(10,12)== "30" >
             <#assign OptionField=optionField30 >
             <#assign PurposeField=purposeField30 >
             <#assign ValueField=valueField30 >
            <#elseif property.name?substring(10,12)== "31" >
             <#assign OptionField=optionField31 >
             <#assign PurposeField=purposeField31 >
             <#assign ValueField=valueField31 >
            <#elseif property.name?substring(10,12)== "32" >
             <#assign OptionField=optionField32 >
             <#assign PurposeField=purposeField32 >
             <#assign ValueField=valueField32 >
            <#elseif property.name?substring(10,12)== "33" >
             <#assign OptionField=optionField33 >
             <#assign PurposeField=purposeField33 >
             <#assign ValueField=valueField33 >
            <#elseif property.name?substring(10,12)== "34" >
             <#assign OptionField=optionField34 >
             <#assign PurposeField=purposeField34 >
             <#assign ValueField=valueField34 >
            <#elseif property.name?substring(10,12)== "35" >
             <#assign OptionField=optionField35 >
             <#assign PurposeField=purposeField35 >
             <#assign ValueField=valueField35 >
            <#elseif property.name?substring(10,12)== "36" >
             <#assign OptionField=optionField36 >
             <#assign PurposeField=purposeField36 >
             <#assign ValueField=valueField36 >
            <#elseif property.name?substring(10,12)== "37" >
             <#assign OptionField=optionField37 >
             <#assign PurposeField=purposeField37 >
             <#assign ValueField=valueField37 >
            <#elseif property.name?substring(10,12)== "38" >
             <#assign OptionField=optionField38 >
             <#assign PurposeField=purposeField38 >
             <#assign ValueField=valueField38 >
            <#elseif property.name?substring(10,12)== "39" >
             <#assign OptionField=optionField39 >
             <#assign PurposeField=purposeField39 >
             <#assign ValueField=valueField39 >
            <#elseif property.name?substring(10,12)== "40" >
             <#assign OptionField=optionField40 >
             <#assign PurposeField=purposeField40 >
             <#assign ValueField=valueField40 >
            <#elseif property.name?substring(10,12)== "41" >
             <#assign OptionField=optionField41 >
             <#assign PurposeField=purposeField41 >
             <#assign ValueField=valueField41 >
            <#elseif property.name?substring(10,12)== "42" >
             <#assign OptionField=optionField42 >
             <#assign PurposeField=purposeField42 >
             <#assign ValueField=valueField42 >
            <#elseif property.name?substring(10,12)== "43" >
             <#assign OptionField=optionField43 >
             <#assign PurposeField=purposeField43 >
             <#assign ValueField=valueField43 >
            <#elseif property.name?substring(10,12)== "44" >
             <#assign OptionField=optionField44 >
             <#assign PurposeField=purposeField44 >
             <#assign ValueField=valueField44 >
            <#elseif property.name?substring(10,12)== "45" >
             <#assign OptionField=optionField45 >
             <#assign PurposeField=purposeField45 >
             <#assign ValueField=valueField45 >
            <#elseif property.name?substring(10,12)== "46" >
             <#assign OptionField=optionField46 >
             <#assign PurposeField=purposeField46 >
             <#assign ValueField=valueField46 >
            <#elseif property.name?substring(10,12)== "47" >
             <#assign OptionField=optionField47 >
             <#assign PurposeField=purposeField47 >
             <#assign ValueField=valueField47 >
            <#elseif property.name?substring(10,12)== "48" >
             <#assign OptionField=optionField48 >
             <#assign PurposeField=purposeField48 >
             <#assign ValueField=valueField48 >
            <#elseif property.name?substring(10,12)== "49" >
             <#assign OptionField=optionField49 >
             <#assign PurposeField=purposeField49 >
             <#assign ValueField=valueField49 >
            <#elseif property.name?substring(10,12)== "50" >
             <#assign OptionField=optionField50 >
             <#assign PurposeField=purposeField50 >
             <#assign ValueField=valueField50 >
            <#else >
             <#assign OptionField=optionField01 >
             <#assign PurposeField=purposeField01 >
             <#assign ValueField=valueField01 >
            </#if>
            <#if (property.name?substring(4,5)?contains("h")) >
             <#-- combo and inputText for  h-->
             <h:panelGrid columns="2">
             <#if OptionField?contains("38") || OptionField?contains("39") >
              <h:selectOneMenu id="${property.name}" value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   disabled="${'#'}{!(customIdentity.hasRole('UH')||customIdentity.hasRole('BH') || customIdentity.hasRole('CH') || customIdentity.hasRole('IH')) || customIdentity.username == ${homeName}.instance.${property.name}}"
              >
             <#elseif OptionField?contains("49") >
              <#if menuAttributesFunction ="1m" || menuAttributesFunction ="1n">
                  <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}" rendered="${'#'}{!fn:endsWith(${homeName}.instance.${property.name},'-M')}">
                   <f:ajax  render="${property.name}I" bypassUpdates="false"/>
              </#if>
             <#elseif OptionField?contains("35") && menuAttributesFunction ="89" >
                  <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" >
                   <f:ajax  render="${property.name}I" bypassUpdates="false"/>
             <#else>
                <h:selectOneMenu value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                >
             </#if>
                 <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                        <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n") >
                         <f:selectItem itemValue="3R-ATTACHMENT-1-C" itemLabel="${'#'}{messages['You']} ${'#'}{messages['can']} ${'#'}{messages['keyin']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}" />
                        </#if>
                        <#if OptionField?contains("35") && menuAttributesFunction ="89"  >
                         <f:selectItem itemValue="Lunch Appontment" itemLabel="${'#'}{messages['You']} ${'#'}{messages['may']} ${'#'}{messages['keyin']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}" />
                        </#if>

                 <f:selectItem itemValue="${'#'}{${optionsEntityName}List.getUserProfile('01','${property.name?substring(10,12)}').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{${optionsEntityName}List.getUserProfile('01','${property.name?substring(10,12)}').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
             <#if property.name?substring(10,12) == '11' ||property.name?substring(10,12) == '12' || property.name?substring(10,12) == '13' || property.name?substring(10,12) == '14'>
                       <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('xx',${property.name?substring(10,12)})}"  var="babu"  
                         itemLabel="${'#'}{babu.key}"
                         itemValue="${'#'}{babu.value}" /> 
             <#else>
                 <f:selectItems 
                     value="${'#'}{${optionsEntityName}List.getSuggestList(${homeName}.prefix)}" var ="result" itemValue="${'#'}{result.${OptionField}}" 
                     itemLabel="${'#'}{result.${OptionField}}"/>
             </#if>
             <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n")>
                          <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['this']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['this']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
             </#if>
             <#if OptionField?contains("35") && menuAttributesFunction ="89" >
                          <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['this']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['this']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
             </#if>
                 <f:ajax  render="${property.name}I" bypassUpdates="false"/>
                </h:selectOneMenu>
                <#if OptionField?contains("35") && menuAttributesFunction ="89"  >
                 <br></br>
                </#if>

                <h:inputText id="${property.name}I" value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                     size="${size}"
                   <#if property.name?substring(pkS,pkE)=="s">
                    required="true"
                   </#if>
                          maxlength="${column.length}">
                        <#--
                          <#if property.name?substring(10,12)== "27">
                           <f:validateRegex pattern="^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$"/>
                          </#if>
                          <#if property.name?substring(10,12)== "14">
                           <f:validateRegex pattern="^$|(^(?i)^[a-z0-9][a-z0-9\\-]{0,10}[a-z0-9]$)"/>
                          </#if>
                         -->
                </h:inputText>
             </h:panelGrid>
            <#else> <#-- end of option but h -->
             <#if OptionField?contains("38") || OptionField?contains("39") >
              <h:selectOneMenu id="${property.name}" value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   disabled="${'#'}{!(customIdentity.hasRole('UH')||customIdentity.hasRole('BH') || customIdentity.hasRole('CH') || customIdentity.hasRole('IH'))|| customIdentity.username == ${homeName}.instance.${property.name}}"
              >
             <#elseif OptionField?contains("49") >
              <h:inputText value= "${'#'}{${homeName}.instance.a1xxuxxxbv49xxxxxxxxfromkey}" disabled="true"
              rendered="${'#'}{fn:endsWith(${homeName}.instance.a1xxuxxxbv49xxxxxxxxfromkey,'-M')}" />
              <#if menuAttributesFunction ="1m" || menuAttributesFunction ="1n">
                <h:panelGrid columns="2">
                 <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}" rendered="${'#'}{!fn:endsWith(${homeName}.instance.${property.name},'-M')}">
                   <f:ajax  render="${property.name}I" bypassUpdates="false"/>
              </#if>
             <#elseif OptionField?contains("50")>
               <h:inputText value= "${'#'}{${homeName}.instance.${property.name}}" disabled="true"
                                   rendered="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype=='theme'}"/>
              <#if menuAttributesFunction ="1m" || menuAttributesFunction ="1n" >
               <h:panelGrid columns="2">
               <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}" 
                  rendered="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.instance.a4xxexxxbvxxxxxxxxxxtype!='theme'}">
                  <f:ajax  render="${property.name}I" bypassUpdates="false"/>
              </#if>
             <#elseif OptionField?contains("35") && menuAttributesFunction ="89" >
                <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" >
                  <f:ajax  render="${property.name}I" bypassUpdates="false"/>
             <#else>
               <h:selectOneMenu style="width:250px;"  value="${'#'}{${homeName}.instance.${property.name}}" required="false" id="${property.name}">
             </#if>
               <f:ajax  render="${property.name}I" bypassUpdates="false"/>
                             <#if menuAttributesFunction ="62">
                                <f:selectItem itemValue="01" itemLabel="01" />
                              <#else>
                                <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                              </#if>
                        <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n") >
                         <f:selectItem itemValue="3R-ATTACHMENT-1-C" itemLabel="${'#'}{messages['You']} ${'#'}{messages['can']} ${'#'}{messages['keyin']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}" />
                        </#if>
                        <#if OptionField?contains("35") && menuAttributesFunction ="89" >
                         <f:selectItem itemValue="Lunch Appontment" itemLabel="${'#'}{messages['You']} ${'#'}{messages['can']} ${'#'}{messages['keyin']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}" />
                        </#if>
                                <#if menuAttributesFunction ="59">
                                 <f:selectItem itemValue="S" itemLabel="${'#'}{messages['For']} ${'#'}{messages['coupon']} ${'#'}{messages['override']} ${'#'}{messages['using']} ${'#'}{messages['next']} ${'#'}{messages['select']}" />
                                </#if>
                               <#if menuAttributesFunction !="62">
                                <f:selectItems value="${'#'}{${optionsEntityName}List.getoptionsFieldList('${menuAttributesFunction}',${property.name?substring(10,12)})}"  var="babu"  
                                 itemLabel="${'#'}{babu.key}"
                                 itemValue="${'#'}{babu.value}" /> 
                                 <#if OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n")>
                                  <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['this']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['this']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
                                 </#if>
                                 <#if menuAttributesFunction ="59">
                                  <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['using']} ${'#'}{messages['next']} ${'#'}{messages['select']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
                                 </#if>
                                 <#if OptionField?contains("35") && menuAttributesFunction ="89">
                                  <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['this']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['this']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 
                                 </#if>
                                </#if>
                               </h:selectOneMenu>
       <#if menuAttributesFunction ="59">
                               <h:selectOneMenu style="width:250px;"  value="${'#'}{yxxxuq591xwwqqhxxxxxrate1fHome.valueOverRide}" required="false" id="b2xxuxxrbv51xxxxxxxxstepnameM">
                                <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
                                <f:selectItem itemValue="ANY" itemLabel="${'#'}{messages['Any']} ${'#'}{messages['item']}" />
                                <f:selectItems 
                                 value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSuggestList(' ')}" var ="result" itemValue="${'#'}{result.a0xxuobxbxxxxxxxxxxxsid}" 
                                 itemLabel="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode} (${'#'}{result.b8fbzpxxbvxxxxxxxxxxselprice}) /${'#'}{result.b1xxuszsbvxxxxxxxxxxdescript}"/>
                              </h:selectOneMenu>
                              &nbsp;<h:outputText value="${'#'}{yxxxuq591xwwqqhxxxxxrate1fHome.instance.b2xxuxxrbv51xxxxxxxxstepname}" />
                              &nbsp;<h:outputText rendered ="${'#'}{(yxxxuq591xwwqqhxxxxxrate1fHome.instance.a0xxukxxbvxxxxxxxxxxusertype =='PC'
                                or yxxxuq591xwwqqhxxxxxrate1fHome.instance.a0xxukxxbvxxxxxxxxxxusertype =='DC')
                                and yxxxuq591xwwqqhxxxxxrate1fHome.instance.b2xxuxxrbv51xxxxxxxxstepname !='null'}"
                               value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSidSToEntity(yxxxuq591xwwqqhxxxxxrate1fHome.instance.b2xxuxxrbv51xxxxxxxxstepname).a0xxukixbxxxxxxxxxxxmatcode}" />
      </#if>
                <#if (OptionField?contains("49") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n")) || (OptionField?contains("50") && (menuAttributesFunction ="1m" || menuAttributesFunction ="1n"))>
                 <h:inputText id="${property.name}I" value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}" label="${'#'}{messages['Source']}" required="true"
                          size="${size}" maxlength="200">
                 </h:inputText>
                </h:panelGrid>
               </#if>
                <#if OptionField?contains("59") && (menuAttributesFunction ="1f" )>
                 <h:inputText id="${property.name}I" value="${'#'}{${homeName}.instance.${property.name}}" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                          size="${size}" maxlength="200">
                 </h:inputText>
                </h:panelGrid>
               </#if>
            </#if>
            <#-- end of combo and inputText for  h-->
         <#if property.name?substring(6,8)=="az">
          <#-- add pzcode validator put it in bean until jsf 2.0
                    ^[ABCEGHJKLMNPRSTVXYabceghjklmnprstvxy]{1}\d{1}[A-Za-z]{1} *\d{1}[A-Za-z]{1}\d{1}$
          -->
         <#else>
         </#if>
        </#if>
       <#else>
        <#--non options drop down -->
        <#if property.name?substring(5,7)=="zn" >
         <h:panelGrid>
         <pe:ckEditor id="${property.name}ed" height="50" width="250"  value="${'#'}{${homeName}.instance.${property.name}}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
         </pe:ckEditor>
         </h:panelGrid>
        <#elseif property.name?substring(6,8)=="sc" && menuAttributesFunction =="1a">
         </h:panelGrid>
         <#-- jul13 2020 schedule todo has sc , item shipcode also has sc, variants apply to Item only    -->
         <#if property.name?substring(6,8)=="sc" && menuAttributesFunction =="1a">
         <p:panel header="${'#'}{messages['variants']}" switchType="client" collapsed="true"
          toggleable="true" toggleableHeader="true">

          <h:outputText value="(Shipping cost is based on shipping mode and size/weight combination)" />
          <h:outputText value="Allowed shipping options" />
          <h:panelGrid columns="2">
          <h:panelGroup id="c3fbuxscbvxxxxxxxxxxshipcodeDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
           <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['Shipcode']}">
           </h:outputLabel>
           <h:selectManyCheckbox value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.checkedData}">
   	    <f:selectItem itemValue="A" itemLabel="All" />
   	    <f:selectItem itemValue="S" itemLabel="Standard" />
   	    <f:selectItem itemValue="E" itemLabel="Express" />
   	    <f:selectItem itemValue="P" itemLabel="PickUp" />
           </h:selectManyCheckbox>
         <h:outputText value="size/weight combination category" />
		  <h:selectOneRadio value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.checkedSize}" required="false" id="c3fbuxscbvxxxxxxxxxxshipcode">
				<f:selectItem  
                         itemLabel="Free Shipment"
                         itemValue="X" /> 
				<f:selectItem  
                         itemLabel="Small"
                         itemValue="S" /> 
				<f:selectItem  
                         itemLabel="Medium"
                         itemValue="M" /> 
				<f:selectItem  
                         itemLabel="Large"
                         itemValue="L" /> 
				<f:selectItem  
                         itemLabel="Quote"
                         itemValue="Q" /> 
                 </h:selectOneRadio>
           <#-- sept30 2018 pks,pke (5,6) if key && subkey then schedule todo has sc for schedule
             use the common end panelgroup but sc also means
             shipcode as in item  -->
           <#if !((property.name?substring(pkS,pkE)=="k" && keyfromsubkeys=="Y") )>
            </h:panelGroup>
           </#if>
           <#if menuAttributesFunction =="1a">
          </h:panelGrid>
         <h:outputText value="actual measurements/values/variants" />
            <br></br><h:panelGrid columns="8">
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.unitLength}" 
              rendered="true">
              <f:selectItem itemLabel="cm" itemValue="C" />
              <f:selectItem itemLabel="meter" itemValue="M" />
              <f:selectItem itemLabel="inch" itemValue="I" />
              <f:selectItem itemLabel="foot" itemValue="F" />
             </h:selectOneMenu>
             </h:panelGrid>
            <h:panelGroup  rendered="true">
             <h:outputLabel  for="il" value="${'#'}{messages['Length']}">
             </h:outputLabel>
             <h:inputText id="il" 
                           size="11"
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{xoxxuq2b4xwwqqhxxxxxcuodetailsHome.instance.zbxxzlxxavxxxxxxxxxxdelivchrg}:this.value;"
                            value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.valueLength}">
             </h:inputText>
            </h:panelGroup>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.unitWidth}" 
              rendered="true">
              <f:selectItem itemLabel="cm" itemValue="C" />
              <f:selectItem itemLabel="meter" itemValue="M" />
              <f:selectItem itemLabel="inch" itemValue="I" />
              <f:selectItem itemLabel="foot" itemValue="F" />
             </h:selectOneMenu>
             </h:panelGrid>
            <h:panelGroup  rendered="true">
             <h:outputLabel  for="iw" value="${'#'}{messages['Width']}">
             </h:outputLabel>
             <h:inputText id="iw"  
              value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.valueWidth}"
              onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{trexuq244xwwqqhxxxxxcuordersHome.instance.z7xxzbtxavxxxxxxxxxxbaseamountt}:this.value;"
              size="11">
             </h:inputText>
            </h:panelGroup>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.unitHeight}" 
              rendered="true">
              <f:selectItem itemLabel="cm" itemValue="C" />
              <f:selectItem itemLabel="meter" itemValue="M" />
              <f:selectItem itemLabel="inch" itemValue="I" />
              <f:selectItem itemLabel="foot" itemValue="F" />
             </h:selectOneMenu>
             </h:panelGrid>
            <h:panelGroup  rendered="true">
             <h:outputLabel  for="ih" value="${'#'}{messages['Height']}">
            </h:outputLabel>
            <h:inputText id="ih" 
                           size="11"
                            onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{xoxxuq2b4xwwqqhxxxxxcuodetailsHome.instance.zcxxzmxxavxxxxxxxxxxmiscchrg}:this.value;"
                            value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.valueHeight}">
            </h:inputText>
            </h:panelGroup>
             <h:panelGrid columns="2">
             <h:selectOneMenu  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.unitWeight}" 
              rendered="true">
              <f:selectItem itemLabel="gm" itemValue="G" />
              <f:selectItem itemLabel="kg" itemValue="K" />
              <f:selectItem itemLabel="lb" itemValue="L" />
              <f:selectItem itemLabel="ton" itemValue="T" />
             </h:selectOneMenu>
             </h:panelGrid>
            <h:panelGroup  rendered="true">
             <h:outputLabel  for="it" value="${'#'}{messages['Weight']}">
             </h:outputLabel>
             <h:inputText id="it"  
              value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.valueWeight}"
              onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{trexuq244xwwqqhxxxxxcuordersHome.instance.z8xxzxz1avxxxxxxxxxxtax1amtt}:this.value;"
              size="11">
             </h:inputText>
            </h:panelGroup>
            </h:panelGrid>
            <br></br>
        <h:panelGrid columns="16">
<!-- custom values can come from options 54,55,56,57 select list or entered nanually  ${'#'}{messages.override} ${'#'}{messages.values} ${'#'}{messages.in} ${'#'}{messages.subcodedesn2} /  ${'#'}{messages.subcodedesn3} " />
        subcodesn2 holds values as 4 times 4ch ex:Small   White   Cotton  House    
        suncodesn3 holds 4 labels as : delimeted ex:size    :colour  :material:brand  :
        currently item variants are handled by using subcodesnx fields, but in future we need to make use of the itemprofl table which is tied to item table via itemid ie
        sid of the Item record. Row field allows multiple profile records for an item.
        ItemProfl has document fields, so can be used to hold images/texts with more flexibility than the current design which uses qualifier and seq in
        Item docmnt field -> clob/blob fromKey but many qualifier and seqs. 
--> 
		<br></br>
         <h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantSizeL}" required="false" >
				<f:selectItem  
                         itemLabel="Size"
                         itemValue="Size " /> 
				<f:selectItem  
                         itemLabel="Type"
                         itemValue="Type" /> 
				<f:selectItem  
                         itemLabel="Trend"
                         itemValue="Trend" /> 
				<f:selectItem  
                         itemLabel="Select this/override "
                         itemValue="keyin" /> 
                   <f:ajax  render="sizeL" bypassUpdates="false"/>
                   <p:tooltip>  <span style="white-space: nowrap"> <h:outputText value="${'#'}{messages['Select']} ${'#'}{messages['and']} ${'#'}{messages['use']} ${'#'}{messages['or']} ${'#'}{messages['select']} ${'#'}{messages['and']} ${'#'}{messages['then']} ${'#'}{messages['Enter']} ${'#'}{messages['override']} ${'#'}{messages['value']} ${'#'}{messages['in']} ${'#'}{messages['next']} ${'#'}{messages['box']}"/></span> </p:tooltip> 

                 </h:selectOneMenu>
                 <h:inputText id="sizeL" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantSizeL}" 
                          size="4" maxlength="8">
                 </h:inputText>
            &nbsp;&nbsp;<h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantSize}" required="false" >
				<f:selectItem  
                         itemLabel="Value"
                         itemValue=" " /> 
				<f:selectItem  
                         itemLabel="One Size Fits All"
                         itemValue="Fits All" /> 
				<f:selectItem  
                         itemLabel="Small"
                         itemValue="Small   " /> 
				<f:selectItem  
                         itemLabel="Medium"
                         itemValue="Medium  " /> 
				<f:selectItem  
                         itemLabel="Large"
                         itemValue="Large  " /> 
				<f:selectItem  
                         itemLabel="Xtra Large"
                         itemValue="X Large " /> 
				<f:selectItem  
                         itemLabel="Xtra Xtra Large"
                         itemValue="XX Large" /> 
				<f:selectItem  
                         itemLabel="Custom"
                         itemValue="Custom  " /> 
                   <f:ajax  render="sizeI" bypassUpdates="false"/>

                 </h:selectOneMenu>
                 <h:inputText id="sizeI" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantSize}" 
                          size="4" maxlength="8">
                 </h:inputText>
		  &nbsp;&nbsp;&nbsp;&nbsp;<h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantColourL}" required="false" >
				<f:selectItem  
                         itemLabel="Colour"
                         itemValue="Colour" /> 
				<f:selectItem  
                         itemLabel="Shape"
                         itemValue="Shape  " /> 
                   <f:ajax  render="colorL" bypassUpdates="false"/>
                 </h:selectOneMenu>
                 <h:inputText id="colorL" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantColourL}" 
                          size="4" maxlength="8">
                 </h:inputText>
		  &nbsp;&nbsp;<h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantColour}" required="false" >
				<f:selectItem  
                         itemLabel="Value"
                         itemValue=" " /> 
				<f:selectItem  
                         itemLabel="Varies"
                         itemValue="Varies  " /> 
				<f:selectItem  
                         itemLabel="White"
                         itemValue="White   " /> 
				<f:selectItem  
                         itemLabel="Black"
                         itemValue="Black   " /> 
				<f:selectItem  
                         itemLabel="Red"
                         itemValue="Red     " /> 
				<f:selectItem  
                         itemLabel="Yellow"
                         itemValue="Yellow  " /> 
				<f:selectItem  
                         itemLabel="Blue"
                         itemValue="Blue    " /> 
				<f:selectItem  
                         itemLabel="Green"
                         itemValue="Green   " /> 
				<f:selectItem  
                         itemLabel="Custom"
                         itemValue="Custom  " /> 
                   <f:ajax  render="colorI" bypassUpdates="false"/>
                 </h:selectOneMenu>
                 <h:inputText id="colorI" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantColour}" 
                          size="4" maxlength="8">
                 </h:inputText>
            </h:panelGrid>
            <br></br><h:panelGrid columns="16">
		  <h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantMaterialL}" required="false" >
				<f:selectItem  
                         itemLabel="Material"
                         itemValue="Material" /> 
				<f:selectItem  
                         itemLabel="Origin"
                         itemValue="Origin" /> 
				<f:selectItem  
                         itemLabel="Country"
                         itemValue="Country" /> 
				<f:selectItem  
                         itemLabel="Food"
                         itemValue="Food Typ" /> 
                   <f:ajax  render="materialL" bypassUpdates="false"/>
                 </h:selectOneMenu>
                 <h:inputText id="materialL" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantMaterialL}" 
                          size="4" maxlength="8">
                 </h:inputText>
		  &nbsp;&nbsp;<h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantMaterial}" required="false" >
				<f:selectItem  
                         itemLabel="Value"
                         itemValue=" " /> 
				<f:selectItem  
                         itemLabel="Varies"
                         itemValue="Varies  " /> 
				<f:selectItem  
                         itemLabel="Cotton"
                         itemValue="Cotton  " /> 
				<f:selectItem  
                         itemLabel="Nylon"
                         itemValue="Nylon   " /> 
				<f:selectItem  
                         itemLabel="Wool"
                         itemValue="Wool    " /> 
				<f:selectItem  
                         itemLabel="Polyster"
                         itemValue="Polyster" /> 
				<f:selectItem  
                         itemLabel="Custom"
                         itemValue="Custom  " /> 
                   <f:ajax  render="materialI" bypassUpdates="false"/>
                 </h:selectOneMenu>
                 <h:inputText id="materialI" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantMaterial}" 
                          size="4" maxlength="8">
                 </h:inputText>
		  &nbsp;&nbsp;&nbsp;&nbsp;<h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantBrandL}" required="false" >
				<f:selectItem  
                         itemLabel="Brand"
                         itemValue="Brand" /> 
				<f:selectItem  
                         itemLabel="Made By"
                         itemValue="Made By" /> 
				<f:selectItem  
                         itemLabel="Company"
                         itemValue="Company" /> 
                   <f:ajax  render="brandL" bypassUpdates="false"/>
                 </h:selectOneMenu>
                 <h:inputText id="brandL" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantBrandL}" 
                          size="4" maxlength="8">
                 </h:inputText>
		  &nbsp;&nbsp;<h:selectOneMenu value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantBrand}" required="false" >
				<f:selectItem  
                         itemLabel="Value"
                         itemValue=" " /> 
				<f:selectItem  
                         itemLabel="House"
                         itemValue="House   " /> 
				<f:selectItem  
                         itemLabel="No Name"
                         itemValue="No Name " /> 
				<f:selectItem  
                         itemLabel="Custom"
                         itemValue="Custom  " /> 
                   <f:ajax  render="brandI" bypassUpdates="false"/>
                 </h:selectOneMenu>
                 <h:inputText id="brandI" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.itemVariantBrand}" 
                          size="4" maxlength="8">
                 </h:inputText>
            </h:panelGrid>
     <h:panelGrid columns="8">
            <h:panelGroup id="subcodesnDecoration"    >
        <h:outputLabel  for="g2xxuxn1bvxxxxxxxxxxsubcodesn" value="${'#'}{messages['Subcodesn']}">
      </h:outputLabel>
         <h:inputText id="g2xxuxn1bvxxxxxxxxxxsubcodesn" 
                           size="20"
                      maxlength="35"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.g2xxuxn1bvxxxxxxxxxxsubcodesn}">
         </h:inputText>
            </h:panelGroup>
            <h:panelGroup id="subcodesn2Decoration"    >
        <h:outputLabel  for="g2xxuxn2bvxxxxxxxxxxsubcodesn2" value="${'#'}{messages['Subcodesn2']}">
      </h:outputLabel>
         <h:inputText id="g2xxuxn2bvxxxxxxxxxxsubcodesn2" 
                           size="20"
                      maxlength="35"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.g2xxuxn2bvxxxxxxxxxxsubcodesn2}">
         </h:inputText>
            </h:panelGroup>
            <h:panelGroup id="subcodesn3Decoration"    >
        <h:outputLabel  for="g2xxuxn3bvxxxxxxxxxxsubcodesn3" value="${'#'}{messages['Subcodesn3']}">
      </h:outputLabel>
         <h:inputText id="g2xxuxn3bvxxxxxxxxxxsubcodesn3" 
                          size="20"
                      maxlength="35"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.g2xxuxn3bvxxxxxxxxxxsubcodesn3}">
         </h:inputText>
            </h:panelGroup>
       </h:panelGrid>
       <hr></hr>
          </p:panel>
         <!-- end of if to put /panelgrid --> 
         </#if>
            <br></br><h:panelGrid columns="4">
           </#if>
         <!-- end of item variants panel if --> 
           <#if menuAttributesFunction =="1a">
           <#-- if shipcode exists, then also insert souece2,misc1 and 2 here based on prod and subprod
            service s agency a Erp e Lab l User forum f social s 
           -->
           <h:panelGroup id="locationi"   rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['for']} ${'#'}{messages.location}"> 
            </h:outputLabel>
             <h:selectOneMenu  style="width:250px;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y1xxuxxrbvxxxxxxxxxxsource2}" 
              rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','12').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','12').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
              <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getoptionsFieldList('xx',12)}"  var="babu"  
                itemLabel="${'#'}{babu.key}"
                itemValue="${'#'}{babu.value}" /> 
             </h:selectOneMenu>
            <br/>
           </h:panelGroup>
           <h:panelGroup   rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}" >
             <h:outputLabel  for="${property.name}" value="${'#'}{messages['criteria']}"> 
            </h:outputLabel>
             <h:selectOneMenu style="width:250px;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y2xxuxxrbvxxxxxxxxxxmisccode1}" 
              rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
              <f:ajax  render="dxxxch1d3xwwqqhxxlxxcompanyprovstateI" bypassUpdates="false"/>
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','52').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','52').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
              <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getSuggestList(${customerEntityName}Home.prefix)}" var="result"
               itemValue="${'#'}{result.s1xxuo52bvxxxxxxxxxxoptions52}" itemLabel="${'#'}{result.s2xxup52bvxxxxxxxxxxpurpose52}" />
             </h:selectOneMenu>
           </h:panelGroup>
           <h:panelGroup   rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}" >
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['event']} ${'#'}{messages['type']}"> 
            </h:outputLabel>
             <h:selectOneMenu style="width:250px;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}" 
              rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
              <f:ajax  render="dxxxch1d3xwwqqhxxlxxcompanyprovstateI" bypassUpdates="false"/>
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
              <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getSuggestList(${customerEntityName}Home.prefix)}" var="result"
               itemValue="${'#'}{result.s4xxuo53bvxxxxxxxxxxoptions53}" itemLabel="${'#'}{result.s5xxup53bvxxxxxxxxxxpurpose53}" />
             </h:selectOneMenu>
           </h:panelGroup>
           <h:panelGroup   rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct=='l' )}" >
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['test_name']}">  
            </h:outputLabel>
             <h:selectOneMenu style="width:250px;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}"> 
              <f:ajax  render="dxxxch1d3xwwqqhxxlxxcompanyprovstateI" bypassUpdates="false"/>
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
               <f:selectItems value="${'#'}{${rate1fEntityName}List.getSuggestList('LT-')}" var="result"
               itemValue="${'#'}{result.b2xxuxxrbv51xxxxxxxxstepname}" itemLabel="${'#'}{result.b2xxuxxrbv51xxxxxxxxstepname}" />
               <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
               <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getSuggestList(${customerEntityName}Home.prefix)}" var="result"
               itemValue="${'#'}{result.s4xxuo53bvxxxxxxxxxxoptions53}" itemLabel="${'#'}{result.s5xxup53bvxxxxxxxxxxpurpose53}" />
             </h:selectOneMenu>
           </h:panelGroup>
           <h:panelGroup  template="layout/edit.xhtml" rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' ) or (customIdentity.product=='f' ) }" >
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['Challenge']} ${'#'}{messages['question']}" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='s' )}"/>  
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['Restrict']} ${'#'}{messages['to']} ${'#'}{messages['logonid']}" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='b' )}"/>  
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['theme']} ${'#'}{messages['vendor']} " rendered="${'#'}{customIdentity.hasRole('PH')}"/>  
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['misccode1']}" rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' )}"/>  
            <h:inputText id="y3xxuxxrbvxxxxxxxxxxmisccode1i" 
                           size="15"
                      maxlength="25"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y2xxuxxrbvxxxxxxxxxxmisccode1}">
            </h:inputText>
           </h:panelGroup>
           <h:panelGroup  template="layout/edit.xhtml" rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' ) or (customIdentity.product=='f' and customIdentity.subProduct =='s' ) }" >
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['misccode2']}" rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' )}"/>  
            <h:outputLabel  for="${property.name}" value="${'#'}{messages['Answer']}" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct =='s' )}"/>  
            <h:inputText id="y3xxuxxrbvxxxxxxxxxxmisccode2i" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct =='s' and fpxxfq1a5xwwqqhxxxxxitemHome.instance.zexxutoxlhxxxxxxxxxxowner == customIdentity.owner )}"
                           size="15"
                      maxlength="25"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}">
            </h:inputText>
            <h:inputText id="y3xxuxxrbvxxxxxxxxxxmisccode2i2" rendered="${'#'}{not(customIdentity.product=='f' and customIdentity.subProduct =='s' )}"
                           size="15"
                      maxlength="25"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}">
            </h:inputText>
          </#if>
        <!-- non options continuing -->
        <#elseif property.name?substring(6,8) == "se">
            <h:selectOneRadio id="${property.name}" value="${'#'}{${homeName}.instance.${property.name}}" required="false">
              <f:selectItem  
                         itemLabel="Male"
                         itemValue="M" /> 
             <f:selectItem  
                         itemLabel="Female"
                         itemValue="F" /> 
             <f:selectItem  
                         itemLabel="Other"
                         itemValue="O" /> 
             </h:selectOneRadio>
        <#elseif property.name?substring(6,8) == "wm">
                <h:selectOneMenu style="width:250px;"  id="${property.name}" value="${'#'}{yxxxch643xwwqqhxxxxxacintegrHome.instance.a2xxukwmbvxxxxxxxxxxmoduleid}">
                 <f:selectItem id="wm1" itemLabel="Sales(AS)" itemValue="AS" />
                 <f:selectItem id="wm2" itemLabel="Receivable(AR)" itemValue="AR" />
                 <f:selectItem id="wm3" itemLabel="Payable(AP)" itemValue="AP" />
                </h:selectOneMenu> 
        <#elseif property.name?substring(6,8) == "w8">
                <h:selectOneMenu style="width:250px;"  id="${property.name}" value="${'#'}{yxxxch643xwwqqhxxxxxacintegrHome.instance.a3xxukw8bvxxxxxxxxxxusagecode}">
                 <f:selectItem id="wu1" itemLabel="Retained Earning(EAR)" itemValue="EAR" />
                 <f:selectItem id="wu2" itemLabel="Inventory Receipt Clearing A/C(IRC)" itemValue="IRC" />
                 <f:selectItem id="wu3" itemLabel="Revenue(CRE)" itemValue="CRE" />
                 <f:selectItem id="wu4" itemLabel="Earning Current(EAC)" itemValue="EAC" />
                 <f:selectItem id="wu5" itemLabel="Cost/Expense(CEX)" itemValue="CEX" />
                 <f:selectItem id="wu6" itemLabel="Inventory Asset(CAS)" itemValue="CAS" />
                 <f:selectItem id="wu7" itemLabel="Salary Expense(SAL)" itemValue="SAL" />
                 <f:selectItem id="wu8" itemLabel="Misc. Expns(APM}" itemValue="APM" />
                 <f:selectItem id="wu9" itemLabel="Delivery Expns(APV)" itemValue="APV" />
                 <f:selectItem id="wua" itemLabel="A/C Payable(APP)" itemValue="APP" />
                 <f:selectItem id="wub" itemLabel="A/C Cash/Bank Payable(APB)" itemValue="APB" />
                 <f:selectItem id="wuc" itemLabel="A/C Receivable(ARR)" itemValue="ARR" />
                 <f:selectItem id="wud" itemLabel="Misc. Income(ARM)" itemValue="ARM" />
                 <f:selectItem id="wue" itemLabel="Delivery Income(ARV)" itemValue="ARV" />
                 <f:selectItem id="wuf" itemLabel="A/C Asset Paid(APA)" itemValue="APA" />
                 <f:selectItem id="wug" itemLabel="Cash/Bank Receipt A/C(ARB)" itemValue="ARB" />
                 <f:selectItem id="wuh" itemLabel="Tax1 Payable(TX1)" itemValue="TX1" />
                 <f:selectItem id="wui" itemLabel="Tax2 Payable(TX2)" itemValue="TX2" />
                 <f:selectItem id="wuj" itemLabel="Purchase Payable Clearing(CLI)" itemValue="CLI" />
                 <f:selectItem id="wuk" itemLabel="Inventory Asset(CAS)" itemValue="CAS" />
                 <f:selectItem id="wum" itemLabel="Repair/Parts Cost(CEX)" itemValue="CEX" />
                 <f:selectItem id="wun" itemLabel="Tax3 Payable(TX3)" itemValue="TX3" />
                </h:selectOneMenu> 
        <#elseif property.name?substring(6,8) == "w9">
                <h:selectOneMenu style="width:250px;"  id="${property.name}" value="${'#'}{yxxxch643xwwqqhxxxxxacintegrHome.instance.a4xxukw9bvxxxxxxxxxxsetsid}">
                 <f:selectItem id="ws1" itemLabel="Default Set" itemValue="DEFAULT" />
                 <f:selectItem id="ws2" itemLabel="Consulting" itemValue="CONSULT" />
                 <f:selectItem id="ws3" itemLabel="Service" itemValue="SERVICE" />
                 <f:selectItem id="ws4" itemLabel="Other" itemValue="OTHER" />
                </h:selectOneMenu> 
        <#elseif property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="za" || property.name?substring(5,7)=="zb"  >
         <h:inputText id="${property.name}v" 
                   disabled="true"
                   size="${size}"
                  <#if column.length gt 255>
                   maxlength="255"
                  <#else>                       
                   maxlength="${column.length}"
                  </#if>
                          value="${'#'}{${homeName}.instance.${property.name}}">
         </h:inputText>
          <#if property.name?substring(5,7)=="za">  
           <p:tooltip  target="${property.name}o"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: xml,txt"/></span> </p:tooltip> 
          <#else> 
           <p:tooltip for="${property.name}o"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: jpg, gif, png, bmp, xml,doc,txt,pdf,xls,mp3,mp4"/></span> </p:tooltip> 
          </#if>
	    <h:selectOneRadio value="${'#'}{${homeName}.upLoadPurpose}" required="false" id="${property.name}d" rendered="${'#'}{${homeName}.instance.${property.name} ne null}">
             <f:selectItem  
              itemLabel="Add"
              itemValue="ad" /> 
             <f:selectItem  
              itemLabel="Replace"
              itemValue="re" /> 
           </h:selectOneRadio>
             <h:commandLink action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.removeImage()}"
                value="${'#'}{messages['Remove']}" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt ne null}" />
                 
         <ui:remove>
          <h:outputText value="${'#'}{${homeName}.clobdata}" rendered="${'#'}{${homeName}.instance.${property.name} ne null  }"  />
         </ui:remove>
                 <o:inputFile id="${property.name}o" value="${'#'}{file.lfiles}" multiple="true" onclick="upload.show()"
                   accept="image/png,image/jp*,video/*,text/*,text/csv,.csv,text/comma-separated-values"/>
                 <h:commandButton value="Upload" action="${'#'}{file.fileUpload('clobblob')}"/>
         <br />
         <p:panel rendered="${'#'}{not empty file.data}">
          <h:commandButton action="${'#'}{${homeName}.clearUploadData}"
            value="${'#'}{messages['Clear']} ${'#'}{messages['Uploaded']} ${'#'}{messages['Data']}"
          rendered="${'#'}{not empty file.data}" />
          ${'#'}{messages['Uploaded']}&nbsp;
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[0].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].data}" />
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[1].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[1].data}" />
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[2].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[2].data}" />
         </p:panel>
         <p:panel rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].text}">
          <h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[0].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].text}" />
          ${'#'}{messages['Doc2:']}<h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[1].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[1].text}" />
          ${'#'}{messages['Doc3:']}<h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[2].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[2].text}" />
         </p:panel>
         <p:panel rendered="${'#'}{${componentName}Home.instance.${documentField}.length() >2}">
          ${'#'}{messages['Saved']}&nbsp;
          <img 
           src="/ImageServletCdi/?seq=0&amp;table=${entityName?upper_case}&amp;qlf=1&amp;id=${'#'}{${componentName}Home.instance.${documentField}}&amp;height=100" >
          </img> 
          <img 
           src="/ImageServletCdi/?seq=1&amp;table=${entityName?upper_case}&amp;qlf=1&amp;id=${'#'}{${componentName}Home.instance.${documentField}}&amp;height=100" >
          </img> 
          <img 
           src="/ImageServletCdi/?seq=2&amp;table=${entityName?upper_case}&amp;qlf=1&amp;id=${'#'}{${componentName}Home.instance.${documentField}}&amp;height=100" >
          </img> 
          <h:outputText escape="false"  value="${'#'}{${componentName}Home.getClobdata('${entityName?upper_case}',${componentName}Home.instance.${documentField},'TXT',1,60)}"  />
          ${'#'}{messages['Doc2:']}<h:outputText escape="false"  value="${'#'}{${componentName}Home.getClobdata('${entityName?upper_case}',${componentName}Home.instance.${documentField},'TXT',2,60)}"  />
          ${'#'}{messages['Doc3:']}<h:outputText escape="false"  value="${'#'}{${componentName}Home.getClobdata('${entityName?upper_case}',${componentName}Home.instance.${documentField},'TXT',3,60)}"  />
         </p:panel>
                 <p:panel rendered="${'#'}{${blobdataEntityName}Home.getSystemBlobdata(${blobdataEntityName}Home.instance.a0xxukbdlvxxxxxxxxxxfromtable,fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt,1,1) != null}">
                  ${'#'}{messages['System']}&nbsp;${'#'}{messages['Gallery']}&nbsp;${'#'}{messages['current']}&nbsp;
                  <h:graphicImage 
                   value="/ImageServletCdi/?seq=${'#'}{${blobdataEntityName}Home.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;id=${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt}&amp;table=${'#'}{${blobdataEntityName}Home.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=1&amp;height=0&amp;scope=SYSTEM"
                  class="img-responsive" style="object-fit: cover;height:90px">
                 </h:graphicImage> 
                 </p:panel>
                 <p:panel rendered="${'#'}{not empty ${blobdataEntityName}Home.instance.b1xxuzbxbvxxxxxxxxxxdata and ${blobdataEntityName}Home.instance.zzxxu2oxxhxxxxxxxxxxowner2=='SYSTEM'}">
                  ${'#'}{messages['System']}&nbsp;${'#'}{messages['Gallery']}&nbsp;${'#'}{messages['preview']}&nbsp;
                  <h:graphicImage 
                   value="/ImageServletCdi/?seq=${'#'}{${blobdataEntityName}Home.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=${'#'}{${blobdataEntityName}Home.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=${'#'}{${blobdataEntityName}Home.instance.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=B${'#'}{${blobdataEntityName}Home.instance.a1xxuxxxbv49xxxxxxxxfromkey}&amp;height=100&amp;scope=SYSTEM" >
                  </h:graphicImage> 
                 </p:panel>

        <#else>
     <#if menuAttributesFunction ="1s" && property.name?substring(pkS,pkE)=="k" && seatEntityName??>
             <h:selectOneMenu style="width:250px;"  id="${property.name}"
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   required="true"
                    validator="${'#'}{${seatEntityName}Home.validateKeyDuplicateRow}" 
                   value="${'#'}{${seatEntityName}Home.instance.a2xxukstbvxxxxxxxxxxrow}"
             >   
               <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
               <f:selectItem itemValue="001" itemLabel="001" />
               <f:selectItem itemValue="002" itemLabel="002" />
               <f:selectItem itemValue="003" itemLabel="003" />
               <f:selectItem itemValue="004" itemLabel="004" />
               <f:selectItem itemValue="005" itemLabel="005" />
               <f:selectItem itemValue="006" itemLabel="006" />
               <f:selectItem itemValue="007" itemLabel="007" />
               <f:selectItem itemValue="008" itemLabel="008" />
               <f:selectItem itemValue="009" itemLabel="009" />
               <f:selectItem itemValue="010" itemLabel="010" />
               <f:selectItem itemValue="011" itemLabel="011" />
               <f:selectItem itemValue="012" itemLabel="012" />
               <f:selectItem itemValue="013" itemLabel="013" />
               <f:selectItem itemValue="014" itemLabel="014" />
               <f:selectItem itemValue="015" itemLabel="015" />
               <f:selectItem itemValue="016" itemLabel="016" />
               <f:selectItem itemValue="017" itemLabel="017" />
               <f:selectItem itemValue="018" itemLabel="018" />
               <f:selectItem itemValue="019" itemLabel="019" />
               <f:selectItem itemValue="020" itemLabel="020" />
               <f:selectItem itemValue="021" itemLabel="021" />
               <f:selectItem itemValue="022" itemLabel="022" />
               <f:selectItem itemValue="023" itemLabel="023" />
               <f:selectItem itemValue="024" itemLabel="024" />
               <f:selectItem itemValue="025" itemLabel="025" />
               <f:selectItem itemValue="026" itemLabel="026" />
               <f:selectItem itemValue="027" itemLabel="027" />
               <f:selectItem itemValue="028" itemLabel="028" />
               <f:selectItem itemValue="029" itemLabel="028" />
               <f:selectItem itemValue="030" itemLabel="030" />
               <f:selectItem itemValue="031" itemLabel="031" />
               <f:selectItem itemValue="032" itemLabel="032" />
               <f:selectItem itemValue="033" itemLabel="033" />
               <f:selectItem itemValue="034" itemLabel="034" />
               <f:selectItem itemValue="035" itemLabel="035" />
               <f:selectItem itemValue="036" itemLabel="036" />
               <f:selectItem itemValue="037" itemLabel="037" />
               <f:selectItem itemValue="038" itemLabel="038" />
               <f:selectItem itemValue="039" itemLabel="039" />
               <f:selectItem itemValue="040" itemLabel="040" />
               <f:selectItem itemValue="041" itemLabel="041" />
               <f:selectItem itemValue="042" itemLabel="042" />
               <f:selectItem itemValue="043" itemLabel="043" />
               <f:selectItem itemValue="044" itemLabel="044" />
               <f:selectItem itemValue="045" itemLabel="045" />
               <f:selectItem itemValue="046" itemLabel="046" />
               <f:selectItem itemValue="047" itemLabel="047" />
               <f:selectItem itemValue="048" itemLabel="048" />
               <f:selectItem itemValue="049" itemLabel="049" />
               <f:selectItem itemValue="050" itemLabel="050" />
             </h:selectOneMenu>
     <#else>

         <#if property.name?substring(5,7) == "c1" || property.name?substring(5,7) == "c2" || property.name?substring(5,7) == "c3" || property.name?substring(5,7) == "c4"
                    || property.name?substring(5,7) == "c5" || property.name?substring(5,7) == "c6" || property.name?substring(5,7) == "c7"
                    || property.name?substring(5,7) == "c8"|| property.name?substring(5,7) == "c9"  || property.name?substring(5,7) == "ca"
                    || property.name?substring(5,7) == "cb"|| property.name?substring(5,7) == "cc">

         <h:inputTextarea id="${property.name}" onchange ="calculate(this);"
 
         <#elseif property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
         <#else>
         <h:inputText id="${property.name}" 
         </#if>
         <#if property.name?substring(pkS,pkE)=="k" && keyfromsubkeys!="Y">
          <#if menuAttributesFunction !="59" && menuAttributesFunction !="1m">
           validator="${'#'}{${homeName}.validateKeyDuplicate${property.name?substring(pL)?cap_first}}" 
          </#if>
         </#if>
         <#if propertyIsId>
          <#if keyfromsubkeys=="Y" ||  menuAttributesFunction =="1l">
                   readonly="true"
          <#else> 
                   disabled="${'#'}{${homeName}.managed}"
          </#if>    
         </#if>
         <#if  menuAttributesFunction =="1l" && !property.name?contains("language")>
                   readonly="true"
         </#if>
         <#if !column.nullable | property.name?substring(pkS,pkE)=="s">
                      <#if property.name?substring(pkS,pkE)=="n">
                       required="false"
                       rendered="${'#'}{${homeName}.managed}"  
                       disabled="${'#'}{${homeName}.managed}"
                      <#else>
                       label="${property.name?substring(pL)}"
                       <#if (pentityFunction=="va" ) >
                        required="false"
                       <#else>
                        required="true"
                       </#if>
                      </#if>
                      <#if property.name?substring(pkS,pkE)=="k" >
                       <#if keyfromsubkeys=="Y">
                        rendered="false"
                       </#if>
                      </#if>
         </#if>
         <#if menuAttributesFunction ="1s">
                           size="4"
         <#elseif menuAttributesFunction ="5b">
                           size="8"
         <#elseif property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
         <#else>
                           size="${size}"
         </#if>
         <#if property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
         <#else>
                      maxlength="${column.length}"
         </#if>
         <#if property.name?substring(5,7) == "xs">
                        rendered="false"
         </#if>
         <#if property.name?substring(10,11)?contains("i") >
                    style="${'#'}{${homeName}.initCap()?'text-transform: capitalize;':';'}"  
         </#if>
         <#if (property.name?substring(pefS,pefE) =="ln")>
           onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{${homeName}.instance.${property.name}}:this.value;"

         </#if>
                        <#if property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
                        <#else>
                          value="${'#'}{${homeName}.instance.${property.name}}">
                        </#if>
                     <#if property.name?substring(5,6)=="k">
                     </#if>
                     <#if property.name?substring(6,8) == "uo"  >
                      pt:placeholder="Initial password"
                     </#if>

         <#if property.name?substring(5,7) == "c1" || property.name?substring(5,7) == "c2" || property.name?substring(5,7) == "c3" || property.name?substring(5,7) == "c4"
                    || property.name?substring(5,7) == "c5" || property.name?substring(5,7) == "c6" || property.name?substring(5,7) == "c7"
                    || property.name?substring(5,7) == "c8"|| property.name?substring(5,7) == "c9"  || property.name?substring(5,7) == "ca"
                    || property.name?substring(5,7) == "cb"|| property.name?substring(5,7) == "cc">
         </h:inputTextarea>
         <#elseif property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
          <#else>
         </h:inputText>
     </#if>
           <#if  menuAttributesFunction =="1l" && property.name?contains("language")>
            <p:tooltip  target="a1xxuxxxbvxxxxxxxxxxlanguage"> <span style="white-space: nowrap"> <h:outputText value="Enter en or fr or de or bn here"/></span> </p:tooltip> 
           </#if>
         </#if>
         <#if property.name?substring(5,6)=="k">  
          <#if keyfromsubkeys=="Y">
            <p:tooltip for="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Value generated from Sub Key Fields.."/></span> </p:tooltip> 
          <#else>
           <#if  menuAttributesFunction =="1l" >
            <p:tooltip  target="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Enter Language value only, this and country(zone) value will be generated"/></span> </p:tooltip> 
           <#elseif menuAttributesFunction =="36">
            <p:tooltip  target="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Enter Value to overide default"/></span> </p:tooltip> 
           <#else>
            <p:tooltip  target="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Enter Value here"/></span> </p:tooltip> 
           </#if>
          </#if>
         </#if>
         <#if property.name?substring(5,6)=="n">  
            <p:tooltip for="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Value Auto generated "/></span> </p:tooltip> 
         </#if>
        </#if>
       </#if>
      </#if>
     </#if>
   <#else>
    <#-- type unknown ${propertyType} example blob --> 
      <#if property.name?substring(5,7)=="zd" || property.name?substring(5,7)=="za" || property.name?substring(5,7)=="zb"  >
          <h:inputText id="${property.name}" 
                   disabled="true"
                   size="${size}"
                  <#if column.length gt 255>
                   maxlength="255"
                  <#else>                       
                   maxlength="${column.length}"
                  </#if>
                   value="${'#'}{${homeName}.instance.${property.name}}">
         </h:inputText>
          <#if property.name?substring(5,7)=="za">  
           <p:tooltip for="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: xml,doc,txt"/></span> </p:tooltip> 
          <#else> 
           <p:tooltip for="${property.name}d"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: jpg, gif, png, bmp, xml,doc,txt,pdf,xls,mp3,mp4"/></span> </p:tooltip> 
          </#if>
          <o:inputFile  value="${'#'}{file.lfiles}" multiple="true" 
           accept="image/png,image/jp*,video/*"/>
          <h:commandButton value="Upload" action="${'#'}{file.fileUpload('clobblob')}" />
         <br />
         <p:panel rendered="${'#'}{not empty file.data}">
          <h:commandButton action="${'#'}{${homeName}.clearUploadData}"
            value="${'#'}{messages['Clear']} ${'#'}{messages['Uploaded']} ${'#'}{messages['Data']}"
          rendered="${'#'}{not empty file.data}" />
          ${'#'}{messages['Uploaded']}&nbsp;
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[0].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].data}" />
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[1].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[1].data}" />
          <o:graphicImage value="${'#'}{${blobdataEntityName}Home.files[2].data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[2].data}" />
         </p:panel>
         <p:panel rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].text}">
          <h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[0].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[0].text}" />
          ${'#'}{messages['Doc2:']}<h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[1].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[1].text}" />
          ${'#'}{messages['Doc3:']}<h:outputText value="${'#'}{fn:substring(${blobdataEntityName}Home.files[2].text,0,50)}"  
           rendered="${'#'}{not empty ${blobdataEntityName}Home.files[2].text}" />
         </p:panel>
          <h:selectOneRadio value="${'#'}{${homeName}.upLoadPurpose}" required="false" id="${property.name}d" rendered="${'#'}{${homeName}.instance.${property.name} ne null}">
             <f:selectItem  
              itemLabel="Add"
              itemValue="ad" /> 
             <f:selectItem  
              itemLabel="Replace"
              itemValue="re" /> 
            </h:selectOneRadio>
                 <ui:remove> blobedit,url allows delay to load the image as opposed to previous jsf h:graphicImage </ui:remove>
                 <p:panel rendered="${'#'}{not empty ${componentName}Home.instance.${documentField} and ${blobdataEntityName}Home.instance.zzxxu2oxxhxxxxxxxxxxowner2 !='SYSTEM'}">
                  ${'#'}{messages['Saved']}&nbsp;
                  <img 
                   src="/ImageServletCdi/?seq=${'#'}{${blobdataEntityName}Home.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=${'#'}{${blobdataEntityName}Home.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=${'#'}{${blobdataEntityName}Home.instance.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=B${'#'}{${blobdataEntityName}Home.instance.a1xxuxxxbv49xxxxxxxxfromkey}&amp;height=100" >
                  </img> 
                 </p:panel>
                 <p:panel rendered="${'#'}{not empty ${componentName}Home.instance.${documentField} and ${blobdataEntityName}Home.instance.zzxxu2oxxhxxxxxxxxxxowner2=='SYSTEM'}">
                  ${'#'}{messages['Saved']}&nbsp;
                  <h:graphicImage 
                   value="/ImageServletCdi/?seq=${'#'}{${blobdataEntityName}Home.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=${'#'}{${blobdataEntityName}Home.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=${'#'}{${blobdataEntityName}Home.instance.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=B${'#'}{${blobdataEntityName}Home.instance.a1xxuxxxbv49xxxxxxxxfromkey}&amp;height=100&amp;scope=SYSTEM" >
                  </h:graphicImage> 
                 </p:panel>
      <#else>
       <#if property.name?substring(6,8) == "n1" || property.name?substring(6,8) == "n2" || property.name?substring(6,8) == "n3" >
        jayjay no n1,n2,n3
       <#else>
       <h:inputText id="${property.name}"
       <#if !column.nullable>
        required="false"
       </#if>
       <#if propertyIsId>
           disabled="${'#'}{${homeName}.managed}"
       </#if>
                   disabled="true"
        value="${'#'}{${homeName}.instance.${property.name}}">

       </h:inputText>
       </#if>
          <#if keyfromsubkeys=="Y">
            <p:tooltip for="${property.name}"> <span style="white-space: nowrap"> <h:outputText value="Value generated from Sub Key Fields.."/></span> </p:tooltip> 
          <#else>
          </#if>
      </#if>
    </#if>
   </#if><#-- end propertyname length check 12 ?? -->
 <#--jay2 ${property.name} jul13 2020-->
            </h:panelGroup>
            <#if (property.name?substring(6,8)=="sc" && menuAttributesFunction =="89")>
            </#if>
    <#if property.name?substring(2,3) == "e" >
              <#-- end non component group end  -->
         <#-- if this or any subsequent property needs panelgrid change the current panelGrid needs to be close
         before the Group is closed because they are nested  -->
              </h:panelGrid>
              <#assign GridAlreadyClosed="yes">
           </h:panelGroup> 
              <#assign GroupOn="no">
    </#if>
  </#if><#-- end of non component?? -->
 <#else>
 <#-- non component Autogen ID property here but they dont need any input -->
 </#if>
<#else>
<#-- place for foreign and onetomany fields which were already handled in edit.xhtml.ftl -->
</#if>
