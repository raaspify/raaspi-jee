<#-- FIXME: This file should be renamed since it now has auxiliary functions and macros -->
<#function isTimestamp property>
	<#return property.value.typeName == "timestamp"/>
</#function>

<#function isTime property>
	<#return property.value.typeName == "time"/>
</#function>

<#function isDate property>
	<#return property.value.typeName == "date" || property.value.typeName =="java.util.Date"/>
</#function>

<#function isBigDecimal property>
	<#return property.value.typeName == "big_decimal" || property.value.typeName =="java.math.BigDecimal"/>
</#function>

<#function isBigInteger property>
	<#return property.value.typeName == "big_integer" || property.value.typeName =="java.util.BigInteger"/>
</#function>

<#function isBoolean property>
	<#return property.value.typeName == "boolean" || property.value.typeName =="yes_no" || property.value.typeName =="true_false" || property.value.typeName == "java.lang.Boolean"/>
</#function>

<#function isString property>
	<#return property.value.typeName == "string" || property.value.typeName =="java.lang.String"/>
</#function>

<#function isByte property>
	<#return property.value.typeName == "[B" || property.value.typeName =="byte[]"/>
</#function>

<#function isToOne property>
    <#return property.value.class.name.matches("org.hibernate.mapping.(One|Many)ToOne")/>
</#function>

<#function label property>
    <#return property?replace("([^A-Z]*)([A-Z]|$)", "$1 $2", "r")?trim?lower_case?cap_first/>
</#function>

<#macro outputValue property expression indent rowEditType foreignKeyName>
 <#assign padding = ""?left_pad(indent)/>
 <#if isDate(property)>
 ${padding}<h:inputText readonly="true"  value="${expression}" >
 ${padding}    <f:convertDateTime type="date" dateStyle="short"/>
 ${padding}</h:inputText>
    <#elseif isTime(property)>
${padding}<h:inputText readonly="true"  value="${expression}" >
${padding}    <f:convertDateTime type="time"/>
${padding}</h:inputText>
    <#elseif isTimestamp(property)>
${padding}<h:inputText readonly="true"  value="${expression}" >
${padding}    <f:convertDateTime type="both" dateStyle="short"/>
${padding}</h:inputText>
    <#elseif isBigDecimal(property)>
${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}">
<#if property.name?substring(6,7) != "q" >
${padding}    <f:convertNumber currencySymbol="${'#'}{authenticator.currencySymbol}" maxFractionDigits="2" type="currency" />
</#if>
${padding}</h:inputText>
    <#elseif isBigInteger(property)>
${padding}<h:inputText readonly="true"  value="${expression}" >
${padding}    <f:convertNumber integerOnly="true"/>
${padding}</h:inputText>
    <#elseif isByte(property)>
${padding}<h:outputText value="${expression}" >
${padding}</h:outputText>
    <#else>
 <!-- jay util typeInfo ${property} ${property.value.typeName} ${rowEditType}  ${foreignKeyName} pfS 5 pfE 7 efS 6 efE 8 -->
<#if rowEditType="S">
 ${padding}<h:outputText value="${expression}" />
<#elseif  rowEditType="IO">
 <#if property.name?substring(pfS,pfE) == "c1" || property.name?substring(pfS,pfE) == "c2" || property.name?substring(pfS,pfE) == "c3" || property.name?substring(pfS,pfE) == "c4"
                    || property.name?substring(pfS,pfE) == "c5" || property.name?substring(pfS,pfE) == "c6" || property.name?substring(pfS,pfE) == "c7"
                    || property.name?substring(pfS,pfE) == "c8"|| property.name?substring(pfS,pfE) == "c9"  || property.name?substring(pfS,pfE) == "ca"
                    || property.name?substring(pfS,pfE) == "cb"|| property.name?substring(pfS,pfE) == "cc">
  ${padding}<h:inputText readonly="true"   value="${expression}" id="${property.name}" onchange ="calculate(this);" />
 <#else> 
    <#if property.name?substring(8,9) == "h" >
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="${'#'}{customIdentity.hasRole('EH')}"/>
    <#elseif (property.name?substring(8,9) == "x" && property.name?substring(pfS,pfE)!="2o") 
               >
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="false"/>
    <#elseif property.name?substring(0,1) == "y" || property.name?substring(0,1) == "z"   >
     <#if property.name?substring(8,9) == "s" >
      ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="${'#'}{customIdentity.hasRole('SH')  or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and !(customIdentity.restrict1=='D')}"/>
     <#else>
      ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="true"/>
     </#if>
    <#elseif property.name?substring(5,6) == "d"  >
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="false"/>
    <#elseif property.name?substring(2,3) == "f" & property.name?substring(3,4) == "b"  >
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}"/>
    <#elseif property.name?substring(pkS,pkE)=="k" && keyfromsubkeys=="Y"> 
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="true" />
    <#elseif property.name?substring(8,9) == "i" >
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="true"/>
    <#elseif property.name?substring(8,9) == "s" >
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" rendered="${'#'}{customIdentity.hasRole('SH')  or (customIdentity.hasRole('UH') and (customIdentity.username.contains('manager') or customIdentity.username.contains('admin'))) and !(customIdentity.restrict1=='D')}"/>
    <#elseif menuAttributesFunction?contains("1s") && property.name?contains("seat")> 
     <h:graphicImage  value="./img/Seat16.png" styleClass="pic" rendered="${'#'}{_${componentName}.${property.name}=='X'}"/>
     <h:graphicImage  value="./img/flag_green16.png" styleClass="pic" rendered="${'#'}{_${componentName}.${property.name}=='H'}"/>
    <#else>
     ${padding}<h:inputText readonly="true"  value="${expression}"  id="${property.name}" />
    </#if>
 </#if>
<#elseif  rowEditType="O">
  ${padding}<h:outputText value="${expression}" />
<#else>
<#-- until we can fix row edit no inputText -->
 ${padding}<h:inputText readonly="true"  value="${expression}" />
</#if>
    </#if>
</#macro>
