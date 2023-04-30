<#include "Ejb3PropertyGetAnnotation.ftl"/>
<#if !property.equals(pojo.identifierProperty) && property.type.name=='yes_no'><#-- Set column type to yes_no in seam-gen.reveng.xml to activate this annotation (or tune this condition) -->
    @${pojo.importType("org.hibernate.annotations.Type")}(type = "yes_no")
</#if>
<#if !property.optional && !c2j.isPrimitive(pojo.getJavaTypeName(property, jdk5)) && (!property.equals(pojo.identifierProperty) || property.value.identifierGeneratorStrategy == "assigned")>
    @${pojo.importType("javax.validation.constraints.NotNull")}
</#if>
<#if property.columnSpan==1>
<#assign column = property.getColumnIterator().next()/>
<#if !c2h.isManyToOne(property) && !c2h.isTemporalValue(property) && column.length!=255 && property.type.name!="character" && pojo.getJavaTypeName(property, jdk5)?lower_case!="boolean">
    @${pojo.importType("javax.validation.constraints.Size")}(max=${column.length?c})
</#if>
</#if>
<#if (property.name?length > 12) > 
 <#if property.name?substring(6,8)=="az"> <#-- \d needs to be escaped via \\d  and ^ in front and $ at end to allow null entry -->
	@Pattern(regexp = "^$|(^(?i)^[a-z0-9][a-z0-9\\- ]{0,10}[a-z0-9]$)",message="Code must be zip or postal code, any character of: a to z, 0 to 9")
 </#if>
</#if>
<#if (property.name?length > 12) > 
 <#if property.name?substring(10,12)=="27"> 
	@Pattern(regexp = "^$|^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", message="Code must be phone # pattern and digits and - . space")
 </#if>
</#if>
<#if (property.name?length > 12) > 
 <#if property.name?substring(10,12)=="24"> 
@Pattern.List({
   @Pattern(regexp = "(^$|.+@.+\\..+)" , message="Bad email value"),
   @Pattern(regexp = "(^$)|(^\\S+$)" , message="email has space character")
})
 </#if>
</#if>


