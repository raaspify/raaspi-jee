<#if ejb3?if_exists>
 <#if pojo.isComponent()>
  @${pojo.importType("javax.persistence.Embeddable")}
 <#else>
  @${pojo.importType("javax.persistence.Entity")}
<#--not needed
  <#if pojo.shortName?substring(6,8) = "1r" >
   @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
   @NamedQueries({
    @NamedQuery(
      name="keys", 
      query="select r.a0xxukrdbvxxxxxxxxxxkey from Yxxxuq1r1xwwqqhxxxxxresource r ",hints={@QueryHint(name="org.hibernate.cacheable",value="true")}),
    @NamedQuery(
      name="value", 
      query="select r.a1xxuxxxbvxxxxxxxxxxvalue,r.zzxxu2oxxhxxxxxxxxxxowner2 from Yxxxuq1r1xwwqqhxxxxxresource r where r.a0xxukrdbvxxxxxxxxxxkey = :key and r.yxxxuq1l1xwwqqhxxxxxresource_bundle.a0xxukrdbvxxxxxxxxxxname = :jName   and (r.zzxxu2oxxhxxxxxxxxxxowner2 = :owner2 or r.zzxxu2oxxhxxxxxxxxxxowner2 = 'SYSTEM') order by r.a0xxuobxbxxxxxxxxxxxsid desc",hints={@QueryHint(name="org.hibernate.cacheable",value="true")})
   })
  </#if>
-->
  @XmlRootElement
  @${pojo.importType("javax.persistence.Table")}(name="${clazz.table.name}"
  <#if clazz.table.schema?exists>
    ,schema="${clazz.table.schema}"
  </#if>
  <#if clazz.table.catalog?exists>
    ,catalog="${clazz.table.catalog}"
  </#if>
  <#assign uniqueConstraint=pojo.generateAnnTableUniqueConstraint()>
  <#if uniqueConstraint?has_content>
    , uniqueConstraints = ${uniqueConstraint} 
  </#if>)
 </#if>
</#if>