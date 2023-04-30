<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#-- 1a (Item) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#if (menuAttributes?substring(efS,efE) == '1A') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                xmlns:o="http://omnifaces.org/ui"
                xmlns:p="http://primefaces.org/ui"
                xmlns:pe="http://primefaces.org/ui/extensions"
                xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
                template="layout/rtemplate.xhtml">
   <ui:remove>s:defaultAction removed, eqv p:defaultCommand
     s:hasRole removed replaced w true look into calling a method
     instead of page.xml use f:template,f:viewparam
     jul22 2019 made a new copy from itemEdit to avoid processdetails property not found
     Generated from itemEditEasy.xhtml.ftl not copied
   </ui:remove>
<f:metadata>
    <f:viewParam name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid}"/>
    <f:viewParam name="fpxxfq1a5xwwqqhxxxxxitemFrom" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemFrom}"/>

    <f:viewAction action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.restrict()}" />
    <f:viewAction action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.wire()}" />
    <f:viewAction action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.setuseSeq(1)}" />
</f:metadata>
<ui:define name="title">${'#'}{customIdentity.owner2} webpage to add new ${'#'}{messages['Item']} easy way</ui:define>

<ui:define name="body">
<h:form id="fpxxfq1a5xwwqqhxxxxxitem" styleClass="edit" enctype="multipart/form-data">
<h:outputStylesheet>

</h:outputStylesheet>
    <script type="text/javascript" src="./js/eval.js"></script>
    <script type="text/javascript" src="./js/fillValue.js"></script>
    <script type="text/javascript"> var jay='${'#'}{messages['Continue_with_zero_amount']}';var jay2='${'#'}{messages['use_offsetting_entry_button_first']}';</script>
    <script>
     function goBack(n) {
     window.history.go(n);return false;
     }
    </script>
	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
              <h:button id="tdone" image="./img/home_24.png"  alt="Cancel" value="Cancel" propagation="end"  rendered="${'#'}{!fpxxfq1a5xwwqqhxxxxxitemHome.managed}" outcome="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup>
              <h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" outcome="/home.xhtml" />
              <h:outputText value="${'#'}{messages['Change']} ${'#'}{messages['done']}-${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.getCurrentTime()}"
                style="color:green;"
                rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.changeDone}">
               <f:convertDateTime   type="time" />
              </h:outputText>
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{customIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['ItemEditHelp']!='ItemEditHelp'}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['ItemEditHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
       <h:messages globalOnly="true" style = "color:red;margin:8px;" styleClass="message" id="globalMessages"/>
	</p:toolbar>

        <p:panel>
        <h:panelGrid columns="2">
            <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed ? 'Edit' : 'Add'} ${'#'}{messages['Issue']}/${'#'}{messages['Bug']}" style="font-weight:bold"
             rendered="${'#'}{(customIdentity.product =='f' and customIdentity.subProduct =='b') and (customIdentity.hasRole('UH') or customIdentity.hasRole('UQ'))}"/>
            <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed ? 'Edit' : 'Add'} ${'#'}{messages['Theme']}" style="font-weight:bold"
             rendered="${'#'}{customIdentity.masterSite and customIdentity.hasRole('PH')}"/>
            <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed ? 'Edit' : 'Add'} ${'#'}{messages['Item']}" style="font-weight:bold"
             rendered="${'#'}{customIdentity.hasRole('UH') or customIdentity.hasRole('UQ') and !(customIdentity.product =='f' and customIdentity.subProduct =='b') }"/>

         <p:messages ajaxRendered="true"  />
  
       <p:tabView switchType="client"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <!-- 2nd check not by but can be incudeaddress and quoteorderexists key property of foreign parent a0xxukixbxxxxxxxxxxxmatcode key           field a0xxuobxbxxxxxxxxxxxsid -->

          <p:tab title="${'#'}{messages['Item']}AsParent" rendered="true">
           <ui:decorate id="fpxxfq1a5xwwqqhxxxxxitemDecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Item']}AsParent 
            </ui:define>
             <p:remoteCommand name="fpxxfq1a5xwwqqhxxxxxitemFunction" process="@all" update="@all" />
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    validator="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.validateAndSelectXxxxxxxxmatcode}" 
                   required="false"
                   value= "${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.lastfpxxfq1a5xwwqqhxxxxxitemP}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSuggestList(' ')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.b1xxuszsbvxxxxxxxxxxdescript}" />
             </h:selectOneMenu>
            <br/>
           </ui:decorate>
           ${'#'}{messages['select']} ${'#'}{messages['parent']}/${'#'}{messages['category']} ${'#'}{messages['to']} ${'#'}{messages['match']} ${'#'}{messages['detail']} ${'#'}{messages['type']}
           <ui:decorate id="fpxxfq1a5xwwqqhxxxxxitemDecorationS" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['category']} ${'#'}{messages['shopping']} 
            </ui:define>
                <p:remoteCommand name="fpxxfq1a5xwwqqhxxxxxitemFunction"  update="@all" />
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    validator="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.validateAndSelectXxxxxxxxmatcode}" 
                   required="false"
                   value= "${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.lastfpxxfq1a5xwwqqhxxxxxitemP}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSuggestList('SI-L%')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.b1xxuszsbvxxxxxxxxxxdescript}" />
             </h:selectOneMenu>
            <br/>
           </ui:decorate>
           <ui:decorate id="fpxxfq1a5xwwqqhxxxxxitemDecorationI" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['category']} ${'#'}{messages['image']} 
            </ui:define>
                <p:remoteCommand name="fpxxfq1a5xwwqqhxxxxxitemFunction" update="@all" />
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    validator="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.validateAndSelectXxxxxxxxmatcode}" 
                   required="false"
                   value= "${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.lastfpxxfq1a5xwwqqhxxxxxitemP}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSuggestList('PI-L*')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.b1xxuszsbvxxxxxxxxxxdescript}" />
             </h:selectOneMenu>
            <br/>
           </ui:decorate>
           <ui:decorate id="fpxxfq1a5xwwqqhxxxxxitemDecorationB" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['category']} ${'#'}{messages['blog']} 
            </ui:define>
             <p:remoteCommand name="fpxxfq1a5xwwqqhxxxxxitemFunction"  update="@all" />
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                    validator="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.validateAndSelectXxxxxxxxmatcode}" 
                   required="false"
                   value= "${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.lastfpxxfq1a5xwwqqhxxxxxitemP}"
             >
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getSuggestList('BI-L*')}" var ="result" 
                     itemValue="${'#'}{result.a0xxukixbxxxxxxxxxxxmatcode}" 
                     itemLabel="${'#'}{result.b1xxuszsbvxxxxxxxxxxdescript}" />
             </h:selectOneMenu>
            <br/>
           </ui:decorate>


           <br/> 
          </p:tab>

  <!-- 1st check for tabpanel creation ie manytoone ie foreign fxxxcq144xwwqqhxxxxxlocation pentityfn ix -->
        <!-- 2nd check not by but can be incudeaddress and quoteorderexists key property of foreign parent a0xxukxxbvxxxxxxxxxxlocation key           field a0xxuobxbxxxxxxxxxxxsid -->
        <!-- 3rd check foreign field end of selfreferencing , if foreign fld is employee for cq,vp etc -->
           <p:tab title="${'#'}{messages['Location']}"
             rendered="true">
           <ui:decorate id="fxxxcq144xwwqqhxxxxxlocationDecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Location']} 
            </ui:define>
                <p:remoteCommand name="fxxxcq144xwwqqhxxxxxlocationFunction" execute="fxxxcq144xwwqqhxxxxxlocationIdT" />
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   required="false"
                    validator="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.validateAndSelectXxxxxxxxlocation}" 
                   value="${'#'}{fxxxcq144xwwqqhxxxxxlocationHome.lastfxxxcq144xwwqqhxxxxxlocationP}"
             >   
<!-- jay filter a/c fxxxcq144xwwqqhxxxxxlocation FPXX -->
               <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{fxxxcq144xwwqqhxxxxxlocationList.suggest(' ')}" var ="result" itemValue="${'#'}{result}" 
                     itemLabel="${'#'}{result}"/>
             </h:selectOneMenu>
           </ui:decorate>
             <br/> 
             </p:tab>




   </p:tabView>

   <h:panelGroup id="replyTo" template="layout/edit.xhtml" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='b' and fpxxfq1a5xwwqqhxxxxxitemHome.lastfpxxfq1a5xwwqqhxxxxxitem != '')}" >
    <ui:define name="label">Reply To 
    </ui:define>
    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.lastfpxxfq1a5xwwqqhxxxxxitem}" />  
   </h:panelGroup>   


</h:panelGrid>
        <h:panelGrid columns="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile?1:4}">


          <h:outputText value="" />









            <h:panelGroup id="a0xxukixbxxxxxxxxxxxmatcodeDecoration"   rendered="false" >
        <h:outputLabel  for="a0xxukixbxxxxxxxxxxxmatcode" value="${'#'}{messages['Matcode']}">
      </h:outputLabel>

         <h:inputText id="a0xxukixbxxxxxxxxxxxmatcode" 

                       label="matcode"
                        required="true"
                        rendered="false"
                           size="20"
                      maxlength="32"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxukixbxxxxxxxxxxxmatcode}">

         </h:inputText>

            <p:tooltip for="a0xxukixbxxxxxxxxxxxmatcode"> <span style="white-space: nowrap"> <h:outputText value="Value generated from Sub Key Fields.."/></span> </p:tooltip> 
            </h:panelGroup>





            <h:panelGroup id="b0xxziqxlvxxsaxxxxxxquantityDecoration"  rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
        <h:outputLabel  for="b0xxziqxlvxxsaxxxxxxquantity" value="${'#'}{messages['Quantity']}">
      </h:outputLabel>
      <h:inputText id="b0xxziqxlvxxsaxxxxxxquantity"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b0xxziqxlvxxsaxxxxxxquantity}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b0xxziqxlvxxsaxxxxxxquantity}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>





            <h:panelGroup id="b1xxuszsbvxxxxxxxxxxdescriptDecoration"    >
        <h:outputLabel  for="b1xxuszsbvxxxxxxxxxxdescript" value="${'#'}{messages['Descript']}" style="font-weight:bold;color:blue;">
      </h:outputLabel>

         <h:inputText id="b1xxuszsbvxxxxxxxxxxdescript" 

                       label="descript"
                        required="true"
                           size="32"
                      maxlength="120"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b1xxuszsbvxxxxxxxxxxdescript}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="b3xxuxxrbvxxxxxxxxxxsource1Decoration"    >
        <h:outputLabel  for="b3xxuxxrbvxxxxxxxxxxsource1" value="${'#'}{messages['Source1']}">
      </h:outputLabel>

         <h:inputText id="b3xxuxxrbvxxxxxxxxxxsource1" 

                           size="20"
                      maxlength="35"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b3xxuxxrbvxxxxxxxxxxsource1}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="b5fbuxxrbvxxxxxxxxxxupccodeDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="b5fbuxxrbvxxxxxxxxxxupccode" value="${'#'}{messages['Upccode']}">
      </h:outputLabel>

         <h:inputText id="b5fbuxxrbvxxxxxxxxxxupccode" 

                           size="20"
                      maxlength="25"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b5fbuxxrbvxxxxxxxxxxupccode}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="b6fbzicxbvxxxxxxxxxxcostDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="b6fbzicxbvxxxxxxxxxxcost" value="${'#'}{messages['Cost']}">
      </h:outputLabel>
      <h:inputText id="b6fbzicxbvxxxxxxxxxxcost"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b6fbzicxbvxxxxxxxxxxcost}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b6fbzicxbvxxxxxxxxxxcost}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>





            <h:panelGroup id="b7fbzxxxbvxxxxxxxxxxreplcostDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="b7fbzxxxbvxxxxxxxxxxreplcost" value="${'#'}{messages['Replcost']}">
      </h:outputLabel>
      <h:inputText id="b7fbzxxxbvxxxxxxxxxxreplcost"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b7fbzxxxbvxxxxxxxxxxreplcost}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b7fbzxxxbvxxxxxxxxxxreplcost}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>





            <h:panelGroup id="b8fbzpxxbvxxxxxxxxxxselpriceDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="b8fbzpxxbvxxxxxxxxxxselprice" value="${'#'}{messages['Selprice']}">
      </h:outputLabel>
      <h:inputText id="b8fbzpxxbvxxxxxxxxxxselprice"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b8fbzpxxbvxxxxxxxxxxselprice}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b8fbzpxxbvxxxxxxxxxxselprice}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>





            <h:panelGroup id="b9xxzxxxlvxxxxxxxxxxspricoldDecoration"  rendered="${'#'}{customIdentity.hasRole('SH') or customIdentity.hasRole('EH')?true:false}">
        <h:outputLabel  for="b9xxzxxxlvxxxxxxxxxxspricold" value="${'#'}{messages['Spricold']}">
      </h:outputLabel>
      <h:inputText id="b9xxzxxxlvxxxxxxxxxxspricold"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b9xxzxxxlvxxxxxxxxxxspricold}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.b9xxzxxxlvxxxxxxxxxxspricold}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>





            <h:panelGroup id="c1xxzxxxbhxxsxxxxxxxspricnewDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="c1xxzxxxhhxxsxxxxxxxspricnew" value="${'#'}{messages['Spricnew']}">
      </h:outputLabel>
      <h:inputText id="c1xxzxxxc1xxzxxxhhxxsxxxxxxxspricnew"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c1xxzxxxbhxxsxxxxxxxspricnew}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c1xxzxxxbhxxsxxxxxxxspricnew}:this.value;"
                                                         
      size="21">
     </h:inputText>
            </h:panelGroup>




                </h:panelGrid>
              <h:panelGrid columns="1">

            <h:panelGroup id="c2fbcxxrehxxsxxxxxxxspriceffdtDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="c2fbcxxrehxxsxxxxxxxspriceffdt" value="${'#'}{messages['Spriceffdt']}">
      </h:outputLabel>
    				<p:calendar id="c2fbcxxrehxxsxxxxxxxspriceffdt"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c2fbcxxrehxxsxxxxxxxspriceffdt}" datePattern="MM/dd/yyyy hh:mm a" >
                   </p:calendar>

            </h:panelGroup>




                 </h:panelGrid>

         <br></br>
   <p:panel header="${'#'}{messages['variants']}" switchType="client" collapsed="true" toggleable="true" toggleableHeader="true"
     leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png">

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
            </h:panelGroup>
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
        for si-d.bi-d,pi-d subcodesn can be used for tags and for bi-d, pi-d subcodesn2 can also be used for more tags
        may be as category and subcategory. if si-d then if subcodesn2 not prepopulated then can also be used for tags  

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
     <h4 class="w3-text-red">${'#'}{messages['Following']} ${'#'}{messages['fields']} ${'#'}{messages['can']} ${'#'}{messages['be']} ${'#'}{messages['used']} ${'#'}{messages['to']}  ${'#'}{messages['show']} ${'#'}{messages['additional']} ${'#'}{messages['information']} ${'#'}{messages['to']}  ${'#'}{messages['the']} ${'#'}{messages['visitors']}. </h4>
     <h4>${'#'}{messages['For']} ${'#'}{messages['blogs']}, ${'#'}{messages['images']}  ${'#'}{messages['the']} ${'#'}{messages['first']} ${'#'}{messages['two']} ${'#'}{messages['fields']} ${'#'}{messages['are']} ${'#'}{messages['mostly']} ${'#'}{messages['not']} ${'#'}{messages['pre-populated']} ${'#'}{messages['and']} ${'#'}{messages['can']} ${'#'}{messages['be']} ${'#'}{messages['used']} ${'#'}{messages['as']} ${'#'}{messages['searchable']} ${'#'}{messages['tags']}. </h4>
     <h4>${'#'}{messages['For']} ${'#'}{messages['shopping']} ${'#'}{messages['items']},  ${'#'}{messages['the']} ${'#'}{messages['first']} ${'#'}{messages['field']} ${'#'}{messages['is']} ${'#'}{messages['mostly']} ${'#'}{messages['avialable']}. ${'#'}{messages['The']} ${'#'}{messages['second']}  ${'#'}{messages['field']}, ${'#'}{messages['if']} ${'#'}{messages['not']} ${'#'}{messages['used']} ${'#'}{messages['as']} ${'#'}{messages['item']} ${'#'}{messages['variantants']},  ${'#'}{messages['can']}   ${'#'}{messages['also']} ${'#'}{messages['be']} ${'#'}{messages['used']}. </h4>
     <h:panelGrid columns="8">
            <h:panelGroup id="g2xxuxn1bvxxxxxxxxxxsubcodesnDecoration"    >
        <h:outputLabel  for="g2xxuxn1bvxxxxxxxxxxsubcodesn" value="${'#'}{messages['Subcodesn']}">
      </h:outputLabel>

         <h:inputText id="g2xxuxn1bvxxxxxxxxxxsubcodesn" 

                           size="20"
                      maxlength="35"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.g2xxuxn1bvxxxxxxxxxxsubcodesn}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="g2xxuxn2bvxxxxxxxxxxsubcodesn2Decoration"    >
        <h:outputLabel  for="g2xxuxn2bvxxxxxxxxxxsubcodesn2" value="${'#'}{messages['Subcodesn2']}">
      </h:outputLabel>

         <h:inputText id="g2xxuxn2bvxxxxxxxxxxsubcodesn2" 

                           size="20"
                      maxlength="35"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.g2xxuxn2bvxxxxxxxxxxsubcodesn2}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="g2xxuxn3bvxxxxxxxxxxsubcodesn3Decoration"    >
        <h:outputLabel  for="g2xxuxn3bvxxxxxxxxxxsubcodesn3" value="${'#'}{messages['Subcodesn3']}">
      </h:outputLabel>

         <h:inputText id="g2xxuxn3bvxxxxxxxxxxsubcodesn3" 

                           size="20"
                      maxlength="35"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.g2xxuxn3bvxxxxxxxxxxsubcodesn3}">

         </h:inputText>
            </h:panelGroup>
       </h:panelGrid>
   </p:panel>


            <br></br><h:panelGrid columns="4">



           <h:panelGroup id="locationi"   rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['for']} ${'#'}{messages.location}"> 
            </h:outputLabel>
             <h:selectOneMenu  styleClass="autoCompleteWidth50" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y1xxuxxrbvxxxxxxxxxxsource2}" 
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
             <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['criteria']}"> 
            </h:outputLabel>
             <h:selectOneMenu styleClass="autoCompleteWidth50" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y2xxuxxrbvxxxxxxxxxxmisccode1}" 
              rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
              <f:ajax  render="dxxxch1d3xwwqqhxxlxxcompanyprovstateI" bypassUpdates="false"/>
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','52').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','52').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
              <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getSuggestList(jxxxuq201xwwqqhxxxxxcustomerHome.prefix)}" var="result"
               itemValue="${'#'}{result.s1xxuo52bvxxxxxxxxxxoptions52}" itemLabel="${'#'}{result.s2xxup52bvxxxxxxxxxxpurpose52}" />
             </h:selectOneMenu>
           </h:panelGroup>

           <h:panelGroup   rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}" >
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['event']} ${'#'}{messages['type']}"> 
            </h:outputLabel>
             <h:selectOneMenu styleClass="autoCompleteWidth50" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}" 
              rendered="${'#'}{(customIdentity.product=='s' and customIdentity.subProduct=='a')}">
              <f:ajax  render="dxxxch1d3xwwqqhxxlxxcompanyprovstateI" bypassUpdates="false"/>
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
              <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getSuggestList(jxxxuq201xwwqqhxxxxxcustomerHome.prefix)}" var="result"
               itemValue="${'#'}{result.s4xxuo53bvxxxxxxxxxxoptions53}" itemLabel="${'#'}{result.s5xxup53bvxxxxxxxxxxpurpose53}" />
             </h:selectOneMenu>
           </h:panelGroup>

           <h:panelGroup   rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct=='l' )}" >
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['test_name']}">  
            </h:outputLabel>
             <h:selectOneMenu styleClass="autoCompleteWidth50" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}"> 
              <f:ajax  render="dxxxch1d3xwwqqhxxlxxcompanyprovstateI" bypassUpdates="false"/>
              <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
               <f:selectItems value="${'#'}{yxxxuq591xwwqqhxxxxxrate1fList.getSuggestList('LT-')}" var="result"
               itemValue="${'#'}{result.b2xxuxxrbv51xxxxxxxxstepname}" itemLabel="${'#'}{result.b2xxuxxrbv51xxxxxxxxstepname}" />
               <f:selectItem itemValue="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" itemLabel="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getUserProfile('01','53').b1xxuxxrbvxxxxxxxxxxselectvalue}" />
               <f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getSuggestList(jxxxuq201xwwqqhxxxxxcustomerHome.prefix)}" var="result"
               itemValue="${'#'}{result.s4xxuo53bvxxxxxxxxxxoptions53}" itemLabel="${'#'}{result.s5xxup53bvxxxxxxxxxxpurpose53}" />
             </h:selectOneMenu>
           </h:panelGroup>

           <h:panelGroup  template="layout/edit.xhtml" 
             rendered="${'#'}{(customIdentity.product=='e' 
              and customIdentity.subProduct!='l' ) 
              or (customIdentity.product=='f' ) 
               or (customIdentity.product=='o' )
               }" >
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['Challenge']} ${'#'}{messages['question']}" 
             rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='s' )}"/>  
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['Restrict']} ${'#'}{messages['to']} ${'#'}{messages['logonid']}" 
             rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct=='b' )}"/>  
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['them']} ${'#'}{messages['vendor']} "
             rendered="${'#'}{customIdentity.hasRole('PH')}"/>  
            <ui:remove>render is in field order, so place override field later</ui:remove>
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['misccode1']}" 
             rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' )
              or (customIdentity.product=='o' )}"/>  
           <h:selectOneMenu id="f1" required="false"
                     value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y2xxuxxrbvxxxxxxxxxxmisccode1}">
            <f:ajax  render="y3xxuxxrbvxxxxxxxxxxmisccode1i" bypassUpdates="false"/>
            <f:selectItem itemValue="${'#'}{null}" itemLabel="-- select one --" />
            <f:selectItem id="item1" itemLabel="${'#'}{messages['Draft']}" itemValue="#draft" />
            <f:selectItem id="item2" itemLabel="${'#'}{messages['Promo']}" itemValue="#promo" />
            <f:selectItem id="item3" itemLabel="${'#'}{messages['Sale']}" itemValue="#sale" />
            <f:selectItem id="item4" itemLabel="${'#'}{messages['Coupon']}" itemValue="coupon" />
            <f:selectItem id="item5" itemLabel="${'#'}{messages['Trial and Subscription-default 1(bus)14 days,trialpnn for p(roduct)nn(days)']}" itemValue="trial" />
            <f:selectItem id="item6" itemLabel="${'#'}{messages['Subscription Plan']}" itemValue="recurring" />
           </h:selectOneMenu>&nbsp;
            <h:inputText id="y3xxuxxrbvxxxxxxxxxxmisccode1i" 
                           size="20"
                      maxlength="25"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y2xxuxxrbvxxxxxxxxxxmisccode1}">

            </h:inputText>

           </h:panelGroup>

           <h:panelGroup  template="layout/edit.xhtml" rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' ) or (customIdentity.product=='f' and customIdentity.subProduct =='s' ) }" >
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['misccode2']}" rendered="${'#'}{(customIdentity.product=='e' and customIdentity.subProduct!='l' )}"/>  
            <h:outputLabel  for="c3fbuxscbvxxxxxxxxxxshipcode" value="${'#'}{messages['Answer']}" rendered="${'#'}{(customIdentity.product=='f' and customIdentity.subProduct =='s' )}"/>  
            <h:inputText id="y3xxuxxrbvxxxxxxxxxxmisccode2i" 

                           size="20"
                      maxlength="25"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.y3xxuxxrbvxxxxxxxxxxmisccode2}">

            </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="c4fbzxxxbvxxxxxxxxxxqtylevel1Decoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="c4fbzxxxbvxxxxxxxxxxqtylevel1" value="${'#'}{messages['Qtylevel1']}">
      </h:outputLabel>
      <h:inputText id="c4fbzxxxbvxxxxxxxxxxqtylevel1"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c4fbzxxxbvxxxxxxxxxxqtylevel1}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c4fbzxxxbvxxxxxxxxxxqtylevel1}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>





            <h:panelGroup id="c5fbuuxrbv18xxxxxxxxunitDecoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="c5fbuuxrbv18xxxxxxxxunit" value="${'#'}{messages['Unit']}">
      </h:outputLabel>
 
		  <h:selectOneMenu styleClass="autoCompleteWidth50" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c5fbuuxrbv18xxxxxxxxunit}" required="false" id="c5fbuuxrbv18xxxxxxxxunit">
                                <f:selectItem itemValue="${'#'}{null}" itemLabel="" />

				<f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getoptionsFieldList('1a',18)}"  var="babu"  
                                 itemLabel="${'#'}{babu.key}"
                                 itemValue="${'#'}{babu.value}" /> 
 		  </h:selectOneMenu>


            </h:panelGroup>





            <h:panelGroup id="c6xxusxrbv16xxxxxxxxtypeDecoration"    >
        <h:outputLabel  for="c6xxusxrbv16xxxxxxxxtype" value="${'#'}{messages['Type']} " style="font-weight:bold;color:blue;">
      </h:outputLabel>
 
		  <h:selectOneMenu styleClass="autoCompleteWidth50" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c6xxusxrbv16xxxxxxxxtype}" required="false" id="c6xxusxrbv16xxxxxxxxtype">
                                <f:selectItem itemValue="${'#'}{null}" itemLabel="" />

				<f:selectItems value="${'#'}{yrxxch511xhhxxhxxxxxoptionsList.getoptionsFieldList('1a',16)}"  var="babu"  
                                 itemLabel="${'#'}{babu.key}"
                                 itemValue="${'#'}{babu.value}" /> 
 		  </h:selectOneMenu>


            </h:panelGroup>





            <h:panelGroup id="c7fbfxz1bvxxxxxxxxxxtax1Decoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="c7fbfxz1bvxxxxxxxxxxtax1" value="${'#'}{messages['override']} ${'#'}{messages['Tax1']}">
      </h:outputLabel>
                <h:selectBooleanCheckbox id="c7fbfxz1bvxxxxxxxxxxtax1"
                                      value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c7fbfxz1bvxxxxxxxxxxtax1}">
                 </h:selectBooleanCheckbox>
            </h:panelGroup>





            <h:panelGroup id="c8fbfxz2bvxxxxxxxxxxtax2Decoration"  rendered="${'#'}{!(customIdentity.product=='f' and customIdentity.subProduct=='b')}">
        <h:outputLabel  for="c8fbfxz2bvxxxxxxxxxxtax2" value="${'#'}{messages['override']} ${'#'}{messages['Tax2']}">
      </h:outputLabel>
                <h:selectBooleanCheckbox id="c8fbfxz2bvxxxxxxxxxxtax2"
                                      value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.c8fbfxz2bvxxxxxxxxxxtax2}">
                 </h:selectBooleanCheckbox>
            </h:panelGroup>







            <h:panelGroup id="f1xxuxxrbvxxxxxxxxxxaliascodeDecoration"    >
        <h:outputLabel  for="f1xxuxxrbvxxxxxxxxxxaliascode" value="${'#'}{messages['Aliascode']}">
      </h:outputLabel>

         <h:inputText id="f1xxuxxrbvxxxxxxxxxxaliascode" 

                           size="20"
                      maxlength="25"

                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.f1xxuxxrbvxxxxxxxxxxaliascode}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="f3xxzxxxlvxxxxxxxxxxavgpriceDecoration"  rendered="${'#'}{customIdentity.hasRole('SH') or customIdentity.hasRole('EH')?true:false}">
        <h:outputLabel  for="f3xxzxxxlvxxxxxxxxxxavgprice" value="${'#'}{messages['Avgprice']}">
      </h:outputLabel>
      <h:inputText id="f3xxzxxxlvxxxxxxxxxxavgprice"  
         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.f3xxzxxxlvxxxxxxxxxxavgprice}"
          onclick="this.value='';" onfocus="this.select()" type="text"  onblur="this.value=!this.value?${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.f3xxzxxxlvxxxxxxxxxxavgprice}:this.value;"
      size="21">
     </h:inputText>
            </h:panelGroup>













                </h:panelGrid>
              <h:panelGrid columns="1">

            <h:panelGroup id="h1xxcxxrbxxxxxxxxxxxeffdateDecoration"  rendered="true">
        <h:outputLabel  for="h1xxcxxrbxxxxxxxxxxxeffdate" value="${'#'}{messages['new']} ${'#'}{messages['price']} ${'#'}{messages['enddate']}">
      </h:outputLabel>
    				<p:calendar id="h1xxcxxrbxxxxxxxxxxxeffdate"
                          value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.h1xxcxxrbxxxxxxxxxxxeffdate}" datePattern="MM/dd/yyyy hh:mm a" >
                   </p:calendar>

            </h:panelGroup>




                 </h:panelGrid>
   <h:panelGrid columns="2">
    <h:panelGroup id="w7xxuznxbvxxxxxxxxxxnotesDecoration"    >
      <h:outputLabel  for="w7xxuznxbvxxxxxxxxxxnotes" value="${'#'}{messages['Notes']}">
      </h:outputLabel>
      <h:panelGrid>
         <pe:ckEditor id="w7xxuznxbvxxxxxxxxxxnotes" height="40" width="500"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w7xxuznxbvxxxxxxxxxxnotes}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
         </pe:ckEditor>
      </h:panelGrid>
    </h:panelGroup>
   </h:panelGrid>

   <h:panelGrid columns="4">
     <h:panelGroup id="w8xxuzdrbvxxxxxxxxxxdocmntDecoration"    >
      <h:outputLabel  for="w8xxuzdrbvxxxxxxxxxxdocmnt" value="${'#'}{messages['Docmnt']}">
      </h:outputLabel>
         <h:inputText id="w8xxuzdrbvxxxxxxxxxxdocmnt" 
           disabled="true"
           size="20"
           maxlength="90"
           value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt}">
         </h:inputText>
           <p:tooltip for="w8xxuzdrbvxxxxxxxxxxdocmntd"> <span style="white-space: nowrap"> <h:outputText value="Types allowed are: jpg, gif, png, bmp, xml,doc,txt,pdf,xls,mp3,mp4"/></span> </p:tooltip> 
         <ui:remove> if any image exists, replace  option is to avoid accidental replace.
          in future, There will be options to either replace or add as next sequence. The view then need to support multiple
          images. For now only qlf=1 and seq 1 is shown. 
         </ui:remove>         
         <h:selectOneRadio value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.upLoadPurpose}" required="false" id="w8xxuzdrbvxxxxxxxxxxdocmntd" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt ne null and yxxxuq1n1xwwqqqxxxxxblobdataList.getDocmntWPrefixToEntity(fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt) !=null}">
          <f:selectItem  
           itemLabel="Add"
           itemValue="ad" /> 
          <f:selectItem  
           itemLabel="Replace"
           itemValue="re" /> 
         </h:selectOneRadio>
         <h:commandLink action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.removeImage()}"
          value="${'#'}{messages['Remove']}" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt ne null and yxxxuq1n1xwwqqqxxxxxblobdataList.getDocmntWPrefixToEntity(fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt) !=null}" />

           <o:inputFile id="w8xxuzdrbvxxxxxxxxxxdocmnto" value="${'#'}{file.lfiles}" multiple="true" 
             accept="image/png,image/jp*,video/*,text/csv,.csv,text/comma-separated-values"/>
           <h:commandButton value="Upload" action="${'#'}{file.fileUpload('clobblob')}"/>
           <br />
         <p:panel rendered="${'#'}{not empty file.data}">
          <h:commandButton action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.clearUploadData}"
            value="${'#'}{messages['Clear']} ${'#'}{messages['Uploaded']} ${'#'}{messages['Data']}"
          rendered="${'#'}{not empty file.data}" />
          ${'#'}{messages['Uploaded']}&nbsp;
          <o:graphicImage value="${'#'}{file.data}" dataURI="true" width="100" 
           rendered="${'#'}{not empty file.data}" />
         </p:panel>
         <p:panel rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt.length() >2}">
          ${'#'}{messages['Gallery']}&nbsp;
          <img alt="image"
           src="/ImageServletCdi/?seq=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=FPXXFQ1A5XWWQQHXXXXXITEM&amp;qlf=1&amp;id=${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt}&amp;height=100" >
          </img> 
         </p:panel>
                 <p:panel rendered="${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.getSystemBlobdata(yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a0xxukbdlvxxxxxxxxxxfromtable,fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt,1,1) != null}">
                  ${'#'}{messages['System']}&nbsp;${'#'}{messages['Gallery']}&nbsp;${'#'}{messages['current']}&nbsp;
                  <h:graphicImage 
                   value="/ImageServletCdi/?seq=1&amp;id=${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.w8xxuzdrbvxxxxxxxxxxdocmnt}&amp;table=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=1&amp;height=0&amp;scope=SYSTEM"
                  class="img-responsive" style="object-fit: cover;height:90px">
                 </h:graphicImage> 
                 </p:panel>
                 <p:panel rendered="${'#'}{not empty yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.b1xxuzbxbvxxxxxxxxxxdata and yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.zzxxu2oxxhxxxxxxxxxxowner2=='SYSTEM'}">
                  ${'#'}{messages['System']}&nbsp;${'#'}{messages['Gallery']}&nbsp;${'#'}{messages['preview']}&nbsp;
                  <img alt="image"
                   src="/ImageServletCdi/?seq=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a3xxexnsbvxxxxxxxxxxsequence}&amp;table=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a0xxukbdlvxxxxxxxxxxfromtable}&amp;qlf=${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a2xxuxxxbv50xxxxxxxxqualifier}&amp;id=B${'#'}{yxxxuq1n1xwwqqqxxxxxblobdataHome.instance.a1xxuxxxbv49xxxxxxxxfromkey}&amp;height=100&amp;scope=SYSTEM" >
                  </img> 
                 </p:panel>

    </h:panelGroup>
  <ui:remove>
    needs more logic at the back end ie extract the id= from the data and overwrite the item instance docmnt with the id value
    Other alternative could be to create a clob record with these image url and associate the clobrecord to the Item record.
    <h:panelGroup id="clobdataImage"    >
      &nbsp;&nbsp;<h:outputLabel  for="clobImg" value="${'#'}{messages['Or Drag image from site Image Gallery Here']}">
      </h:outputLabel>    
      <h:panelGrid>
         <pe:ckEditor id="clobImg" height="40" width="300"  value="${'#'}{yxxxuq1m1xwwqqqxxxxxclobdataHome.instance.b1xxuzaxbvxxxxxxxxxxdata}"
                 toolbar="[['NewPage','Preview','Cut','Copy','Image','Table','HorizontalRule','Iframe','Link','Unlink','Anchor','Paste','PasteText','PasteFromWord','-', 'Scayt'], '/',['Font','FontSize','Bold','Italic','Strike','-','RemoveFormat' ] ,[ 'TextColor','BGColor' ], ['Undo', 'Redo']]">
         </pe:ckEditor>
      </h:panelGrid>
    </h:panelGroup>
  </ui:remove>


   </h:panelGrid>



        
            <div style="clear:both">
                <span class="required">*</span> 
                required fields
            </div>

            
                
<div class="actionButtons">
             <p:ajaxStatus name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
    <ui:remove>removed 89 schedule because one schedule one detail, nov20 2018 added va after fixing report to show vendor</ui:remove>
                       <ui:remove>
                       may07 2018 allow record 2(shopify id/secret),3
                       disabled="true"
                       </ui:remove>

            <p:commandButton id="save" styleClass="buttonMain" 
                          value="${'#'}{messages['Save']}" status="buttonStatus" update="@form"
                         action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.persist()}"
                       disabled="${'#'}{!fpxxfq1a5xwwqqhxxxxxitemHome.wired}"
                       rendered="${'#'}{!fpxxfq1a5xwwqqhxxxxxitemHome.managed  and !fpxxfq1a5xwwqqhxxxxxitemHome.entityDeleted}">  
                        
            </p:commandButton>   
          
            <p:commandButton id="update" styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}" 
                          value="${'#'}{messages['Update']}" status="buttonStatus" update="@form"
                         action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.update()}"
                       rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed  and !fpxxfq1a5xwwqqhxxxxxitemHome.entityUpdated}"/>
                        			  
            <p:commandButton id="update2" 
                          value="${'#'}{messages['More_Updates']}" status="buttonStatus" update="@form"
                         action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.update()}"
                       rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed and fpxxfq1a5xwwqqhxxxxxitemHome.entityUpdated}"/>
                        			  
            <h:commandButton id="delete" 
                          value="${'#'}{messages['delete']}" 
                         action="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.remove()}"
                       rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed and !fpxxfq1a5xwwqqhxxxxxitemHome.entityDeleted}"/>

            <h:button id="new" styleClass="buttonMain" 
                   value="New"
             propagation="begin"
             includePageParams="false" 
                    outcome="/itemEdit.xhtml"
                       rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}"/>
                 

            <p:hotkey  onkeydown="PF('save').click();return false;" preventDefault="true" enabledInInput="true" key="return">
            </p:hotkey>
            <p:hotkey  onkeydown="PF('update').click();return false;" preventDefault="true" enabledInInput="true" key="ctrl+u">
            </p:hotkey>




            <f:param name="reportName" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.reportName}"/>
            <f:param name="displayAs" value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.displayAs}" /> 
            <h:button outcome="/itemList.xhtml" id="list" styleClass="buttonMain" 
              propagation="none"
                 value="${'#'}{messages['List']} ${'#'}{messages['Item']}">
            </h:button>    

            <h:button id="done" 
                   value="${'#'}{messages['Done']}"
             propagation="end"
                    outcome="/${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemFrom ? 'home' : fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemFrom}.xhtml"

                rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed or fpxxfq1a5xwwqqhxxxxxitemHome.entityDeleted}"/>
            
            <h:button id="cancel" 
                   value="${'#'}{messages['Cancel']}"
             propagation="end"
                    outcome="/${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemFrom ? 'home' : fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitemFrom}.xhtml"
                rendered="${'#'}{!fpxxfq1a5xwwqqhxxxxxitemHome.managed and !fpxxfq1a5xwwqqhxxxxxitemHome.entityDeleted}"/>






</div>
</p:panel>
       <p:messages ajaxRendered="true"  />


<p:panel>

<p:panel header="${'#'}{messages['NavigationToggle']}" switchType="server" collapsed="false" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}"
     leftCollapsedIcon="/img/control_add16.png" leftExpandedIcon="/img/control_remove16.png" toggleable="true" toggleableHeader="true">
<div  style="overflow: auto;width: 850px;height: auto; ">
  <p:tabView switchType="ajax">
   <#if itemjobsEntityName??>
     <p:tab title="${'#'}{messages['Itemjob']}">
        <div class="association" id="dxxxuq92bxwwqqhefxxxitemjobsChildren">
        
            <h:outputText value="No itemjobs" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.dxxxuq92bxwwqqhefxxxitemjobs}"/>
        
            <p:dataTable value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.dxxxuq92bxwwqqhefxxxitemjobs}" tableStyle="table-layout:auto;"
                           var="dxxxuq92bxwwqqhefxxxitemjob" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.dxxxuq92bxwwqqhefxxxitemjobs}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="dxxxuq92bxwwqqhefxxxitemjobsTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/itemjob.xhtml" 
                              id="selectdxxxuq92bxwwqqhefxxxitemjob" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty dxxxuq92bxwwqqhefxxxitemjob.a0xxuobxbxxxxxxxxxxxsid}" name="dxxxuq92bxwwqqhefxxxitemjobA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="dxxxuq92bxwwqqhefxxxitemjobFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">jobno</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.a0xxunijbvxxxxxxxxxxjobno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">proddatet</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.b2xxcxxrlxxxxxxxxxxxproddatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtyalloc</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.b3xxzqxrbvxxxxxxxxxxqtyalloc}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">pono</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.b4xxuxcobvxxxxxxxxxxpono}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">vendor</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.c2xxuxxrbvxxxxxxxxxxvendor}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.c3xxuxxrbv17xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.yexxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{dxxxuq92bxwwqqhefxxxitemjob.zdxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="dxxxuq92bxwwqqhefxxxitemjobs">
        <div class="actionButtons">
            <h:button id="adddxxxuq92bxwwqqhefxxxitemjob" 
                   value="Add itemjob"
                    outcome="/itemjobEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="dxxxuq92bxwwqqhefxxxitemjobFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>

   </#if> 


    <p:tab title="${'#'}{messages['Item']}">
    <div class="association" id="fpxxfq1a5xwwqqhxxxxxitemParent">
        
        <h:outputText value="No item" 
                   rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.fpxxfq1a5xwwqqhxxxxxitem == null}"/>
        
        <p:dataTable tableStyle="table-layout:auto;"  var="fpxxfq1a5xwwqqhxxxxxitem" 
                   value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.fpxxfq1a5xwwqqhxxxxxitem}" 
                rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.fpxxfq1a5xwwqqhxxxxxitem != null}"
              rowClasses="rvgRowOne,rvgRowTwo"
                      id="fpxxfq1a5xwwqqhxxxxxitemTable">
            <p:column>
                <f:facet name="header">action</f:facet>
                <h:link id="viewitem" 
                     value="View" 
                      outcome="/item.xhtml">
                       <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid}" name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                           value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid}"/>
                </h:link>
            </p:column>
                 <p:column>
                  <f:facet name="header">matcode</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode}
                 </p:column>
                 <p:column>
                  <f:facet name="header">quantity</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b0xxziqxlvxxsaxxxxxxquantity}
                 </p:column>
                 <p:column>
                  <f:facet name="header">descript</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b1xxuszsbvxxxxxxxxxxdescript}
                 </p:column>
                 <p:column>
                  <f:facet name="header">source1</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b3xxuxxrbvxxxxxxxxxxsource1}
                 </p:column>
                 <p:column>
                  <f:facet name="header">upccode</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b5fbuxxrbvxxxxxxxxxxupccode}
                 </p:column>
                 <p:column>
                  <f:facet name="header">cost</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b6fbzicxbvxxxxxxxxxxcost}
                 </p:column>
                 <p:column>
                  <f:facet name="header">replcost</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b7fbzxxxbvxxxxxxxxxxreplcost}
                 </p:column>
                 <p:column>
                  <f:facet name="header">selprice</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b8fbzpxxbvxxxxxxxxxxselprice}
                 </p:column>
                 <p:column>
                  <f:facet name="header">spricold</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b9xxzxxxlvxxxxxxxxxxspricold}
                 </p:column>
                 <p:column>
                  <f:facet name="header">spricnew</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c1xxzxxxbhxxsxxxxxxxspricnew}
                 </p:column>
                 <p:column>
                  <f:facet name="header">spriceffdt</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c2fbcxxrehxxsxxxxxxxspriceffdt} 
                 </p:column>
                 <p:column>
                  <f:facet name="header">shipcode</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c3fbuxscbvxxxxxxxxxxshipcode}
                 </p:column>
                 <p:column>
                  <f:facet name="header">qtylevel1</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c4fbzxxxbvxxxxxxxxxxqtylevel1}
                 </p:column>
                 <p:column>
                  <f:facet name="header">unit</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c5fbuuxrbv18xxxxxxxxunit}
                 </p:column>
                 <p:column>
                  <f:facet name="header">type</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype}
                 </p:column>
                 <p:column>
                  <f:facet name="header">tax1</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c7fbfxz1bvxxxxxxxxxxtax1}
                 </p:column>
                 <p:column>
                  <f:facet name="header">tax2</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c8fbfxz2bvxxxxxxxxxxtax2}
                 </p:column>
                 <p:column>
                  <f:facet name="header">aliascode</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.f1xxuxxrbvxxxxxxxxxxaliascode}
                 </p:column>
                 <p:column>
                  <f:facet name="header">avgprice</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.f3xxzxxxlvxxxxxxxxxxavgprice}
                 </p:column>
                 <p:column>
	    	       <f:facet name="header">item sid</f:facet>
		    	  ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid}
                 </p:column>
                 <p:column>
	    	       <f:facet name="header">location sid</f:facet>
		    	  ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.fxxxcq144xwwqqhxxxxxlocation.a0xxuobxbxxxxxxxxxxxsid}
                 </p:column>
                 <p:column>
                  <f:facet name="header">subcodesn</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn1bvxxxxxxxxxxsubcodesn}
                 </p:column>
                 <p:column>
                  <f:facet name="header">subcodesn2</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn2bvxxxxxxxxxxsubcodesn2}
                 </p:column>
                 <p:column>
                  <f:facet name="header">subcodesn3</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn3bvxxxxxxxxxxsubcodesn3}
                 </p:column>
                 <p:column>
                  <f:facet name="header">effdate</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.h1xxcxxrbxxxxxxxxxxxeffdate}
                 </p:column>
                 <p:column>
                  <f:facet name="header">integrset</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.h2xxuwmrbv40xxxxxxxxintegrset}
                 </p:column>
                 <p:column>
                  <f:facet name="header">notes</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.w7xxuznxbvxxxxxxxxxxnotes}
                 </p:column>
                 <p:column>
                  <f:facet name="header">docmnt</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.w8xxuzdrbvxxxxxxxxxxdocmnt}
                 </p:column>
                 <p:column>
                  <f:facet name="header">statusfl</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.z5xxzzfxhhxxxxxxxxxxstatusfl}
                 </p:column>
                 <p:column>
                  <f:facet name="header">statusfldt</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.z6xxcztxlxxxxxxxxxxxstatusfldt}
                 </p:column>
                 <p:column>
                  <f:facet name="header">owner</f:facet>
                   ${'#'}{fpxxfq1a5xwwqqhxxxxxitem.zexxutoxlhxxxxxxxxxxowner}
                 </p:column>
        </p:dataTable>
        
    </div>
    </p:tab>


     <p:tab title="${'#'}{messages['Item']}">
        <div class="association" id="fpxxfq1a5xwwqqhxxxxxitemsChildren">
        
            <h:outputText value="No items" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitems}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitems}" 
                           var="fpxxfq1a5xwwqqhxxxxxitem" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.fpxxfq1a5xwwqqhxxxxxitems}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="fpxxfq1a5xwwqqhxxxxxitemsTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/item.xhtml" 
                              id="selectfpxxfq1a5xwwqqhxxxxxitem" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid}" name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="fpxxfq1a5xwwqqhxxxxxitemFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">matcode</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.a0xxukixbxxxxxxxxxxxmatcode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">quantity</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b0xxziqxlvxxsaxxxxxxquantity}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">descript</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b1xxuszsbvxxxxxxxxxxdescript}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">source1</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b3xxuxxrbvxxxxxxxxxxsource1}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">upccode</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b5fbuxxrbvxxxxxxxxxxupccode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">cost</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b6fbzicxbvxxxxxxxxxxcost}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">replcost</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b7fbzxxxbvxxxxxxxxxxreplcost}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">selprice</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b8fbzpxxbvxxxxxxxxxxselprice}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">spricold</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.b9xxzxxxlvxxxxxxxxxxspricold}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">spricnew</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c1xxzxxxbhxxsxxxxxxxspricnew}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">spriceffdt</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c2fbcxxrehxxsxxxxxxxspriceffdt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">shipcode</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c3fbuxscbvxxxxxxxxxxshipcode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtylevel1</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c4fbzxxxbvxxxxxxxxxxqtylevel1}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">unit</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c5fbuuxrbv18xxxxxxxxunit}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c6xxusxrbv16xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">tax1</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c7fbfxz1bvxxxxxxxxxxtax1}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">tax2</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.c8fbfxz2bvxxxxxxxxxxtax2}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">aliascode</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.f1xxuxxrbvxxxxxxxxxxaliascode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">avgprice</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.f3xxzxxxlvxxxxxxxxxxavgprice}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">subcodesn</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn1bvxxxxxxxxxxsubcodesn}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">subcodesn2</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn2bvxxxxxxxxxxsubcodesn2}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">subcodesn3</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.g2xxuxn3bvxxxxxxxxxxsubcodesn3}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">effdate</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.h1xxcxxrbxxxxxxxxxxxeffdate}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">integrset</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.h2xxuwmrbv40xxxxxxxxintegrset}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">notes</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.w7xxuznxbvxxxxxxxxxxnotes}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.w8xxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{fpxxfq1a5xwwqqhxxxxxitem.zexxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="fpxxfq1a5xwwqqhxxxxxitems">
        <div class="actionButtons">
            <h:button id="addfpxxfq1a5xwwqqhxxxxxitem" 
                   value="Add item"
                    outcome="/itemEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="fpxxfq1a5xwwqqhxxxxxitemFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>

    <p:tab title="${'#'}{messages['Location']}">
    <div class="association" id="fxxxcq144xwwqqhxxxxxlocationParent">
        
        <h:outputText value="No location" 
                   rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.fxxxcq144xwwqqhxxxxxlocation == null}"/>
        
        <p:dataTable tableStyle="table-layout:auto;"  var="fxxxcq144xwwqqhxxxxxlocation" 
                   value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.fxxxcq144xwwqqhxxxxxlocation}" 
                rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.fxxxcq144xwwqqhxxxxxlocation != null}"
              rowClasses="rvgRowOne,rvgRowTwo"
                      id="fxxxcq144xwwqqhxxxxxlocationTable">
            <p:column>
                <f:facet name="header">action</f:facet>
                <h:link id="viewlocation" 
                     value="View" 
                      outcome="/location.xhtml">
                       <f:param disable="${'#'}{empty fxxxcq144xwwqqhxxxxxlocation.a0xxuobxbxxxxxxxxxxxsid}" name="fxxxcq144xwwqqhxxxxxlocationA0xxuobxbxxxxxxxxxxxsid" 
                           value="${'#'}{fxxxcq144xwwqqhxxxxxlocation.a0xxuobxbxxxxxxxxxxxsid}"/>
                </h:link>
            </p:column>
                 <p:column>
                  <f:facet name="header">location</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.a0xxukxxbvxxxxxxxxxxlocation}
                 </p:column>
                 <p:column>
                  <f:facet name="header">descript</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.b1xxuszsbvxxxxxxxxxxdescript}
                 </p:column>
                 <p:column>
                  <f:facet name="header">floor</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.b5xxhxxxbv31xxxxxxxxfloor}
                 </p:column>
                 <p:column>
                  <f:facet name="header">room</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.b6xxhxxxbv32xxxxxxxxroom}
                 </p:column>
                 <p:column>
                  <f:facet name="header">rack</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.b7xxhxxxbv33xxxxxxxxrack}
                 </p:column>
                 <p:column>
                  <f:facet name="header">printmstat</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.b8xxzzprhvxxxxxxxxxxprintmstat}
                 </p:column>
                 <p:column>
                  <f:facet name="header">prinmtfldt</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.b9xxczqxlhxxxxxxxxxxprinmtfldt}
                 </p:column>
                 <p:column>
                  <f:facet name="header">exclude</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.c1xxfxxxbvxxxxxxxxxxexclude}
                 </p:column>
                 <p:column>
	    	       <f:facet name="header">company sid</f:facet>
		    	  ${'#'}{fxxxcq144xwwqqhxxxxxlocation.dxxxch1d3xwwqqhxxlxxcompany.a0xxuobxbxxxxxxxxxxxsid}
                 </p:column>
                 <p:column>
	    	       <f:facet name="header">address sid</f:facet>
		    	  ${'#'}{fxxxcq144xwwqqhxxxxxlocation.fxxxuq111xwwqqhxxxxxaddress.a0xxuobxbxxxxxxxxxxxsid}
                 </p:column>
                 <p:column>
                  <f:facet name="header">statusfl</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.z2xxzzfxhhxxxxxxxxxxstatusfl}
                 </p:column>
                 <p:column>
                  <f:facet name="header">statusfldt</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.z3xxcztxlxxxxxxxxxxxstatusfldt}
                 </p:column>
                 <p:column>
                  <f:facet name="header">owner</f:facet>
                   ${'#'}{fxxxcq144xwwqqhxxxxxlocation.z5xxutoxlhxxxxxxxxxxowner}
                 </p:column>
        </p:dataTable>
        
    </div>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Usagebyperiods']}">
        <div class="association" id="fxxxuq1bhxwwqqhxxxxxusagebyperiodsesChildren">
        
            <h:outputText value="No usagebyperiodses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.fxxxuq1bhxwwqqhxxxxxusagebyperiodses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.fxxxuq1bhxwwqqhxxxxxusagebyperiodses}" 
                           var="fxxxuq1bhxwwqqhxxxxxusagebyperiods" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.fxxxuq1bhxwwqqhxxxxxusagebyperiodses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="fxxxuq1bhxwwqqhxxxxxusagebyperiodsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/usagebyperiods.xhtml" 
                              id="selectfxxxuq1bhxwwqqhxxxxxusagebyperiods" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty fxxxuq1bhxwwqqhxxxxxusagebyperiods.a0xxuobxbxxxxxxxxxxxsid}" name="fxxxuq1bhxwwqqhxxxxxusagebyperiodsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="fxxxuq1bhxwwqqhxxxxxusagebyperiodsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">usagetrackerid</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.a0xxukupbvxxxxxxxxxxusagetrackerid}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">descript</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.a1xxuszsbxxxxxxxxxxxdescript}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">currency</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.b2xxuxxrbxxxxxxxxxxxcurrency}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period0label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.d3xxul0rbvxxxxxxxxxxperiod0label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period0b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.d3xxzb0rbvxxxxxxxxxxperiod0b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period0</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.d4xxza0rbvxxxxxxxxxxperiod0}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period0formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.d5xxzc0rbxxxxxxxxxxxperiod0formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodtotalslabel</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.e3xxul0rbvxxxxxxxxxxperiodtotalslabel}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodtotalsb</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.e3xxzbtrbvxxxxxxxxxxperiodtotalsb}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodtotals</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.e4xxzatrbvxxxxxxxxxxperiodtotals}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodtotalsformulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.e5xxzctrbxxxxxxxxxxxperiodtotalsformulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period1label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.f3xxul1rbvxxxxxxxxxxperiod1label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period1budget</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.f3xxzb1rbvxxxxxxxxxxperiod1budget}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period1</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.f4xxza1rbvxxxxxxxxxxperiod1}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period1formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.f5xxzc1rbxxxxxxxxxxxperiod1formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period2label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.g3xxul2rbvxxxxxxxxxxperiod2label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period2b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.g3xxzb2rbvxxxxxxxxxxperiod2b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period2</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.g4xxza2rbvxxxxxxxxxxperiod2}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period2formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.g5xxzc2rbxxxxxxxxxxxperiod2formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period3label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.h3xxul3rbvxxxxxxxxxxperiod3label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period3b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.h3xxzb3rbvxxxxxxxxxxperiod3b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period3</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.h4xxza3rbvxxxxxxxxxxperiod3}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period3formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.h5xxzc3rbxxxxxxxxxxxperiod3formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period4label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.i3xxul4rbvxxxxxxxxxxperiod4label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period4b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.i3xxzb4rbvxxxxxxxxxxperiod4b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period4</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.i4xxza4rbvxxxxxxxxxxperiod4}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period4formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.i5xxzc4rbxxxxxxxxxxxperiod4formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period5label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.j3xxul5rbvxxxxxxxxxxperiod5label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period5b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.j3xxzb5rbvxxxxxxxxxxperiod5b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period5</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.j4xxza5rbvxxxxxxxxxxperiod5}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period5formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.j5xxzc5rbxxxxxxxxxxxperiod5formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period6label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.k3xxul6rbvxxxxxxxxxxperiod6label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period6b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.k3xxzb6rbvxxxxxxxxxxperiod6b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period6</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.k4xxza6rbvxxxxxxxxxxperiod6}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period6formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.k5xxzc6rbxxxxxxxxxxxperiod6formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period7label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.l3xxul7rbvxxxxxxxxxxperiod7label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period7b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.l3xxzb7rbvxxxxxxxxxxperiod7b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period7</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.l4xxza7rbvxxxxxxxxxxperiod7}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period7formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.l5xxzc7rbxxxxxxxxxxxperiod7formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period8label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.m3xxul8rbvxxxxxxxxxxperiod8label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period8b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.m3xxzb8rbvxxxxxxxxxxperiod8b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period8</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.m4xxza8rbvxxxxxxxxxxperiod8}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period8formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.m5xxzc8rbxxxxxxxxxxxperiod8formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period9label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.n3xxul9rbvxxxxxxxxxxperiod9label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period9b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.n3xxzb9rbvxxxxxxxxxxperiod9b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period9</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.n4xxza9rbvxxxxxxxxxxperiod9}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period9formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.n5xxzc9rbxxxxxxxxxxxperiod9formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period10label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.o3xxularbvxxxxxxxxxxperiod10label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period10b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.o3xxzbarbvxxxxxxxxxxperiod10b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period10</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.o4xxzaarbvxxxxxxxxxxperiod10}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period10formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.o5xxzcarbxxxxxxxxxxxperiod10formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period11label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.p3xxulbrbvxxxxxxxxxxperiod11label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period11b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.p3xxzbbrbvxxxxxxxxxxperiod11b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period11</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.p4xxzabrbvxxxxxxxxxxperiod11}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period11formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.p5xxzcbrbxxxxxxxxxxxperiod11formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period12label</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.q3xxulcrbvxxxxxxxxxxperiod12label}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period12b</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.q3xxzbcrbvxxxxxxxxxxperiod12b}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period12</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.q4xxzacrbvxxxxxxxxxxperiod12}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">period12formulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.q5xxzccrbxxxxxxxxxxxperiod12formulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodnlabel</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.r3xxuldrbvxxxxxxxxxxperiodnlabel}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodnb</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.r3xxzbdrbvxxxxxxxxxxperiodnb}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodn</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.r4xxzadrbvxxxxxxxxxxperiodn}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">periodnformulae</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.r5xxzxxrbxxxxxxxxxxxperiodnformulae}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.zixxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.zjxxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1bhxwwqqhxxxxxusagebyperiods.zjxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="fxxxuq1bhxwwqqhxxxxxusagebyperiodses">
        <div class="actionButtons">
            <h:button id="addfxxxuq1bhxwwqqhxxxxxusagebyperiods" 
                   value="Add usagebyperiods"
                    outcome="/usagebyperiodsEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="fxxxuq1bhxwwqqhxxxxxusagebyperiodsFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Itembomdetails']}">
        <div class="association" id="fxxxuq1hhxwwqqhefxxxitembomdetailsesChildren">
        
            <h:outputText value="No itembomdetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.fxxxuq1hhxwwqqhefxxxitembomdetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.fxxxuq1hhxwwqqhefxxxitembomdetailses}" 
                           var="fxxxuq1hhxwwqqhefxxxitembomdetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.fxxxuq1hhxwwqqhefxxxitembomdetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="fxxxuq1hhxwwqqhefxxxitembomdetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/itembomdetails.xhtml" 
                              id="selectfxxxuq1hhxwwqqhefxxxitembomdetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty fxxxuq1hhxwwqqhefxxxitembomdetails.a0xxuobxbxxxxxxxxxxxsid}" name="fxxxuq1hhxwwqqhefxxxitembomdetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="fxxxuq1hhxwwqqhefxxxitembomdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">mode</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.b2xxfxxxbvxxxxxxxxxxmode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">subqty</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.b3xxzqxxavxxxxxxxxxxsubqty}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">descript</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.b4xxuxzsbvxxxxxxxxxxdescript}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">seq</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.b5xxzkxrbvxxxxxxxxxxseq}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">notes</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.b6xxzwprbvxxxxxxxxxxnotes}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.z1xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.z2xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{fxxxuq1hhxwwqqhefxxxitembomdetails.z3xxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="fxxxuq1hhxwwqqhefxxxitembomdetailses">
        <div class="actionButtons">
            <h:button id="addfxxxuq1hhxwwqqhefxxxitembomdetails" 
                   value="Add itembomdetails"
                    outcome="/itembomdetailsEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="fxxxuq1hhxwwqqhefxxxitembomdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>







     <p:tab title="${'#'}{messages['Groupmembers']}">
        <div class="association" id="jxxxuq54exwwqqhxxxxxgroupmembersesChildren">
        
            <h:outputText value="No groupmemberses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.jxxxuq54exwwqqhxxxxxgroupmemberses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.jxxxuq54exwwqqhxxxxxgroupmemberses}" 
                           var="jxxxuq54exwwqqhxxxxxgroupmembers" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.jxxxuq54exwwqqhxxxxxgroupmemberses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="jxxxuq54exwwqqhxxxxxgroupmembersesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/groupmembers.xhtml" 
                              id="selectjxxxuq54exwwqqhxxxxxgroupmembers" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty jxxxuq54exwwqqhxxxxxgroupmembers.a0xxuobxbxxxxxxxxxxxsid}" name="jxxxuq54exwwqqhxxxxxgroupmembersA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="jxxxuq54exwwqqhxxxxxgroupmembersFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">memberid</f:facet>
                    <h:outputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.b1xxukgmbvxxxxxxxxxxmemberid}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">descript</f:facet>
                    <h:outputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.b2xxuxzsbvxxxxxxxxxxdescript}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">sourcetype</f:facet>
                    <h:outputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.b3xxuzyxbv46xxxxxxxxsourcetype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.z1xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.z2xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{jxxxuq54exwwqqhxxxxxgroupmembers.z3xxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="jxxxuq54exwwqqhxxxxxgroupmemberses">
        <div class="actionButtons">
            <h:button id="addjxxxuq54exwwqqhxxxxxgroupmembers" 
                   value="Add groupmembers"
                    outcome="/groupmembersEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="jxxxuq54exwwqqhxxxxxgroupmembersFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Cuquote']}">
        <div class="association" id="trexuq233xwwqqhxxxxxcuquotesChildren">
        
            <h:outputText value="No cuquotes" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq233xwwqqhxxxxxcuquotes}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq233xwwqqhxxxxxcuquotes}" 
                           var="trexuq233xwwqqhxxxxxcuquote" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq233xwwqqhxxxxxcuquotes}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq233xwwqqhxxxxxcuquotesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/cuquote.xhtml" 
                              id="selecttrexuq233xwwqqhxxxxxcuquote" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq233xwwqqhxxxxxcuquote.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq233xwwqqhxxxxxcuquoteA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq233xwwqqhxxxxxcuquote.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq233xwwqqhxxxxxcuquoteFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">purchsno</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.a0xxuncqbvxxxxxxxxxxpurchsno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">delvdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.b1xxcxxrlxxxxxxxxxxxdelvdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.b5xxuxxrbl10xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.b6xxuxxrbl09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.b7xxfxxrbvxxxxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">odatet</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.b8xxcxxrlxxxxxxxxxxxodatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.ycxxuzdrblxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq233xwwqqhxxxxxcuquote.zexxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq233xwwqqhxxxxxcuquotes">
        <div class="actionButtons">
            <h:button id="addtrexuq233xwwqqhxxxxxcuquote" 
                   value="Add cuquote"
                    outcome="/cuquoteEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq233xwwqqhxxxxxcuquoteFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Cuorders']}">
        <div class="association" id="trexuq244xwwqqhxxxxxcuordersesChildren">
        
            <h:outputText value="No cuorderses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq244xwwqqhxxxxxcuorderses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq244xwwqqhxxxxxcuorderses}" 
                           var="trexuq244xwwqqhxxxxxcuorders" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq244xwwqqhxxxxxcuorderses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq244xwwqqhxxxxxcuordersesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/cuorders.xhtml" 
                              id="selecttrexuq244xwwqqhxxxxxcuorders" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq244xwwqqhxxxxxcuordersA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq244xwwqqhxxxxxcuorders.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq244xwwqqhxxxxxcuordersFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">purchsno</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.a0xxuncobvxxxxxxxxxxpurchsno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">delvdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.b1xxcxxxbvxxxxxxxxxxdelvdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">cinvoice</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.b4xxuxxrlxxxcxxxxxxxcinvoice}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtytotal</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.b5xxztqrlxxxxxxxxxxxqtytotal}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">odatet</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.c1xxcxxxbxxxxxxxxxxxodatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.c2xxcxxxbv09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.c3xxfxxrbv09xxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.yfxxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.zcxxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.zdxxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq244xwwqqhxxxxxcuorders.zexxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq244xwwqqhxxxxxcuorderses">
        <div class="actionButtons">
            <h:button id="addtrexuq244xwwqqhxxxxxcuorders" 
                   value="Add cuorders"
                    outcome="/cuordersEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq244xwwqqhxxxxxcuordersFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Shipment']}">
        <div class="association" id="trexuq255xwwqqhxxxxxshipmentsChildren">
        
            <h:outputText value="No shipments" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq255xwwqqhxxxxxshipments}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq255xwwqqhxxxxxshipments}" 
                           var="trexuq255xwwqqhxxxxxshipment" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq255xwwqqhxxxxxshipments}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq255xwwqqhxxxxxshipmentsTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/shipment.xhtml" 
                              id="selecttrexuq255xwwqqhxxxxxshipment" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq255xwwqqhxxxxxshipment.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq255xwwqqhxxxxxshipmentA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq255xwwqqhxxxxxshipment.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq255xwwqqhxxxxxshipmentFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">shipcode</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.a0xxunshbvxxxxxxxxxxshipcode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">pono</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.b3xxuxcobvxxxxxxxxxxpono}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.c2xxuxxrbv51xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">shipdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.c3xxcxxrlxxxxxxxxxxxshipdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">billtosameasshipto</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.d2xxugbrbvxxxxxxxxxxbilltosameasshipto}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">packno</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.u5xxuxxrbvxxxxxxxxxxpackno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.z7xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.z8xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq255xwwqqhxxxxxshipment.zcxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq255xwwqqhxxxxxshipments">
        <div class="actionButtons">
            <h:button id="addtrexuq255xwwqqhxxxxxshipment" 
                   value="Add shipment"
                    outcome="/shipmentEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq255xwwqqhxxxxxshipmentFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Cuinvoice']}">
        <div class="association" id="trexuq266xwwqqhxxxxxcuinvoicesChildren">
        
            <h:outputText value="No cuinvoices" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq266xwwqqhxxxxxcuinvoices}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq266xwwqqhxxxxxcuinvoices}" 
                           var="trexuq266xwwqqhxxxxxcuinvoice" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq266xwwqqhxxxxxcuinvoices}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq266xwwqqhxxxxxcuinvoicesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/cuinvoice.xhtml" 
                              id="selecttrexuq266xwwqqhxxxxxcuinvoice" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq266xwwqqhxxxxxcuinvoice.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq266xwwqqhxxxxxcuinvoiceA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq266xwwqqhxxxxxcuinvoiceFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">invoice</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.a0xxuncibvxxxxxxxxxxinvoice}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">invodate</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.b3xxcxxrlxxxxxxxxxxxinvodate}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">shipdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c1xxcxxrlxxxxxxxxxxxshipdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">shiptype</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c2xxuxxrbv51xxxxxxxxshiptype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c3xxuxxrbv09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">termsdat</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c4xxcxxrlxxxxxxxxxxxtermsdat}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">discounp</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c5xxzixrbxxxxxxxxxxxdiscounp}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">discoudt</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c6xxcxxrlxxxxxxxxxxxdiscoudt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">discouds</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c7xxzxxrlxxxxxxxxxxxdiscouds}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">netddat</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c8xxcxxrlxxxxxxxxxxxnetddat}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">netddys</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.c9xxzxxrlxxxxxxxxxxxnetddys}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.yexxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq266xwwqqhxxxxxcuinvoice.zexxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq266xwwqqhxxxxxcuinvoices">
        <div class="actionButtons">
            <h:button id="addtrexuq266xwwqqhxxxxxcuinvoice" 
                   value="Add cuinvoice"
                    outcome="/cuinvoiceEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq266xwwqqhxxxxxcuinvoiceFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Venquote']}">
        <div class="association" id="trexuq333xwwqqhxxxxxvenquotesChildren">
        
            <h:outputText value="No venquotes" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq333xwwqqhxxxxxvenquotes}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq333xwwqqhxxxxxvenquotes}" 
                           var="trexuq333xwwqqhxxxxxvenquote" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq333xwwqqhxxxxxvenquotes}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq333xwwqqhxxxxxvenquotesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/venquote.xhtml" 
                              id="selecttrexuq333xwwqqhxxxxxvenquote" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq333xwwqqhxxxxxvenquote.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq333xwwqqhxxxxxvenquoteA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq333xwwqqhxxxxxvenquote.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq333xwwqqhxxxxxvenquoteFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">purchsno</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.a0xxunvqbvxxxxxxxxxxpurchsno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">delvdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.b1xxcxxxbvxxxxxxxxxxdelvdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">odatet</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.b1xxcxxxbxxxxxxxxxxxodatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.b2xxcxxxbv09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.b3xxfxxrbv09xxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.b4xxcxxxbv10xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">startdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.c2xxcxxxbxxxxxxxxxxxstartdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.ydxxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq333xwwqqhxxxxxvenquote.zexxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq333xwwqqhxxxxxvenquotes">
        <div class="actionButtons">
            <h:button id="addtrexuq333xwwqqhxxxxxvenquote" 
                   value="Add venquote"
                    outcome="/venquoteEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq333xwwqqhxxxxxvenquoteFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Vendorders']}">
        <div class="association" id="trexuq344xwwqqhxxxxxvendordersesChildren">
        
            <h:outputText value="No vendorderses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq344xwwqqhxxxxxvendorderses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq344xwwqqhxxxxxvendorderses}" 
                           var="trexuq344xwwqqhxxxxxvendorders" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq344xwwqqhxxxxxvendorderses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq344xwwqqhxxxxxvendordersesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vendorders.xhtml" 
                              id="selecttrexuq344xwwqqhxxxxxvendorders" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq344xwwqqhxxxxxvendorders.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq344xwwqqhxxxxxvendordersA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq344xwwqqhxxxxxvendorders.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq344xwwqqhxxxxxvendordersFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">purchsno</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.a0xxunvobvxxxxxxxxxxpurchsno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">delvdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.b1xxcxxxbvxxxxxxxxxxdelvdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">odatet</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.c1xxcxxxbxxxxxxxxxxxodatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.c2xxcxxxbv09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.c3xxfxxrbv09xxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.d1xxcxxxbv10xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">startdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.d3xxcxxxbxxxxxxxxxxxstartdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.ybxxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq344xwwqqhxxxxxvendorders.zdxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq344xwwqqhxxxxxvendorderses">
        <div class="actionButtons">
            <h:button id="addtrexuq344xwwqqhxxxxxvendorders" 
                   value="Add vendorders"
                    outcome="/vendordersEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq344xwwqqhxxxxxvendordersFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Vshipmen']}">
        <div class="association" id="trexuq377xwwqqhxxxxxvshipmensChildren">
        
            <h:outputText value="No vshipmens" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq377xwwqqhxxxxxvshipmens}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq377xwwqqhxxxxxvshipmens}" 
                           var="trexuq377xwwqqhxxxxxvshipmen" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq377xwwqqhxxxxxvshipmens}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq377xwwqqhxxxxxvshipmensTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vshipmen.xhtml" 
                              id="selecttrexuq377xwwqqhxxxxxvshipmen" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq377xwwqqhxxxxxvshipmen.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq377xwwqqhxxxxxvshipmenA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq377xwwqqhxxxxxvshipmenFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">shipcode</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.a0xxuksvbvxxxxxxxxxxshipcode}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">shipper</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.b1xxuxxrbvxxxxxxxxxxshipper}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">invoice</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.b3xxuxxrbvxxxxxxxxxxinvoice}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">amounttotal</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.b5xxztprlxxxxxxxxxxxamounttotal}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">amountostndt</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.b6xxzyprlxxxxxxxxxxxamountostndt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtytotal</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.b7xxztqrlxxxxxxxxxxxqtytotal}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtyostndt</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.b8xxzyqrlxxxxxxxxxxxqtyostndt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">carrier</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.c1xxuxxrbvxxxxxxxxxxcarrier}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.c2xxuxxrbv51xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">shipdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.c3xxcxxrlxxxxxxxxxxxshipdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">billtosameasshipto</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.d4xxugbrbvxxxxxxxxxxbilltosameasshipto}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.z4xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.z5xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq377xwwqqhxxxxxvshipmen.z9xxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq377xwwqqhxxxxxvshipmens">
        <div class="actionButtons">
            <h:button id="addtrexuq377xwwqqhxxxxxvshipmen" 
                   value="Add vshipmen"
                    outcome="/vshipmenEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq377xwwqqhxxxxxvshipmenFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Vinvoice']}">
        <div class="association" id="trexuq3a6xwwqqhxxxxxvinvoicesChildren">
        
            <h:outputText value="No vinvoices" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq3a6xwwqqhxxxxxvinvoices}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq3a6xwwqqhxxxxxvinvoices}" 
                           var="trexuq3a6xwwqqhxxxxxvinvoice" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq3a6xwwqqhxxxxxvinvoices}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq3a6xwwqqhxxxxxvinvoicesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vinvoice.xhtml" 
                              id="selecttrexuq3a6xwwqqhxxxxxvinvoice" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq3a6xwwqqhxxxxxvinvoice.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq3a6xwwqqhxxxxxvinvoiceA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq3a6xwwqqhxxxxxvinvoiceFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">invoice</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.a0xxunvibvxxxxxxxxxxinvoice}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">invodate</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.b3xxuxxrbvxxxxxxxxxxinvodate}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">amounttotal</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.b3xxztprlxxxxxxxxxxxamounttotal}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.b4xxuxxrbv09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">discounp</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c1xxzixrbvxxxxxxxxxxdiscounp}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">discoudt</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c2xxcxxrlxxxxxxxxxxxdiscoudt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">discouds</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c3xxzxxrlvxxxxxxxxxxdiscouds}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">netddat</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c4xxcxxrlxxxxxxxxxxxnetddat}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">netddys</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c5xxzxxrbvxxxxxxxxxxnetddys}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">fob</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c6xxuxxrbvxxxxxxxxxxfob}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.c7xxuxxrbv10xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.yfxxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.z4xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.z5xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq3a6xwwqqhxxxxxvinvoice.zexxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq3a6xwwqqhxxxxxvinvoices">
        <div class="actionButtons">
            <h:button id="addtrexuq3a6xwwqqhxxxxxvinvoice" 
                   value="Add vinvoice"
                    outcome="/vinvoiceEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq3a6xwwqqhxxxxxvinvoiceFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Emplorders']}">
        <div class="association" id="trexuq444xwwqqhxxxxxemplordersesChildren">
        
            <h:outputText value="No emplorderses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq444xwwqqhxxxxxemplorderses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trexuq444xwwqqhxxxxxemplorderses}" 
                           var="trexuq444xwwqqhxxxxxemplorders" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trexuq444xwwqqhxxxxxemplorderses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trexuq444xwwqqhxxxxxemplordersesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/emplorders.xhtml" 
                              id="selecttrexuq444xwwqqhxxxxxemplorders" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trexuq444xwwqqhxxxxxemplorders.a0xxuobxbxxxxxxxxxxxsid}" name="trexuq444xwwqqhxxxxxemplordersA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trexuq444xwwqqhxxxxxemplorders.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trexuq444xwwqqhxxxxxemplordersFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">purchsno</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.a0xxuneobvxxxxxxxxxxpurchsno}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">delvdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.b1xxcxxxbvxxxxxxxxxxdelvdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">vpono</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.b4xxuxxrlxxxxxxxxxxxvpono}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">odatet</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.c1xxcxxxbxxxxxxxxxxxodatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">terms</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.c2xxcxxxbv09xxxxxxxxterms}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.c3xxfxxrbv09xxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">type</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.d1xxcxxxbv10xxxxxxxxtype}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">startdatet</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.d3xxcxxxbxxxxxxxxxxxstartdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">docmnt</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.ybxxuzdrbvxxxxxxxxxxdocmnt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.z5xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.z6xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trexuq444xwwqqhxxxxxemplorders.zdxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trexuq444xwwqqhxxxxxemplorderses">
        <div class="actionButtons">
            <h:button id="addtrexuq444xwwqqhxxxxxemplorders" 
                   value="Add emplorders"
                    outcome="/emplordersEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trexuq444xwwqqhxxxxxemplordersFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit.quoteorderexists"/>
            </h:button>
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
   <#if jobassignmentEntityName??>
     <p:tab title="${'#'}{messages['Jobassignment']}">
        <div class="association" id="trxxuq9aaxwwqqhefxxxjobassignmentsChildren">
        
            <h:outputText value="No jobassignments" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.trxxuq9aaxwwqqhefxxxjobassignments}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.trxxuq9aaxwwqqhefxxxjobassignments}" 
                           var="trxxuq9aaxwwqqhefxxxjobassignment" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.trxxuq9aaxwwqqhefxxxjobassignments}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="trxxuq9aaxwwqqhefxxxjobassignmentsTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/jobassignment.xhtml" 
                              id="selecttrxxuq9aaxwwqqhefxxxjobassignment" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty trxxuq9aaxwwqqhefxxxjobassignment.a0xxuobxbxxxxxxxxxxxsid}" name="trxxuq9aaxwwqqhefxxxjobassignmentA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="trxxuq9aaxwwqqhefxxxjobassignmentFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">jobassign</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.a0xxukxxbvxxxxxxxxxxjobassign}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">sequence</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b1xxuxxrbvxxxxxxxxxxsequence}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">sdatet</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b5gxdxsdbvxxxxxxxxxxsdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">durationh</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b5xxexdhbvxxxxxxxxxxdurationh}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtytotal</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b5xxztqrlxxxxxxxxxxxqtytotal}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">durationm</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b6xx0xdmbvxxxxxxxxxxdurationm}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtyostndt</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b6xxzyqrlxxxxxxxxxxxqtyostndt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">stimeh</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b7xxexshbvxxxxxxxxxxstimeh}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">stimem</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b8bx0xsmbvxxxxxxxxxxstimem}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">stimeampm</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b8extxsabvxxxxxxxxxxstimeampm}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">edatet</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b8xxceedbvxxxxxxxxxxedatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.b9xxfxxxbv08xxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">percntdone</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.baxxzxxrlvxxxxxxxxxxpercntdone}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">repeatf</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.bgxxuxxrbv18xxxxxxxxrepeatf}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.z2xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.z3xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{trxxuq9aaxwwqqhefxxxjobassignment.z4xxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="trxxuq9aaxwwqqhefxxxjobassignments">
        <div class="actionButtons">
            <h:button id="addtrxxuq9aaxwwqqhefxxxjobassignment" 
                   value="Add jobassignment"
                    outcome="/jobassignmentEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="trxxuq9aaxwwqqhefxxxjobassignmentFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>

   </#if>


     <p:tab title="${'#'}{messages['Shipmentdetails']}">
        <div class="association" id="xoxxuq295xwwqqhxxxxxshipmentdetailsesChildren">
        
            <h:outputText value="No shipmentdetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq295xwwqqhxxxxxshipmentdetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq295xwwqqhxxxxxshipmentdetailses}" 
                           var="xoxxuq295xwwqqhxxxxxshipmentdetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq295xwwqqhxxxxxshipmentdetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq295xwwqqhxxxxxshipmentdetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/shipmentdetails.xhtml" 
                              id="selectxoxxuq295xwwqqhxxxxxshipmentdetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq295xwwqqhxxxxxshipmentdetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq295xwwqqhxxxxxshipmentdetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq295xwwqqhxxxxxshipmentdetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq295xwwqqhxxxxxshipmentdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq295xwwqqhxxxxxshipmentdetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{xoxxuq295xwwqqhxxxxxshipmentdetails.xznxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{xoxxuq295xwwqqhxxxxxshipmentdetails.zmxxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{xoxxuq295xwwqqhxxxxxshipmentdetails.zrxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq295xwwqqhxxxxxshipmentdetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Cuidetails']}">
        <div class="association" id="xoxxuq2a4xwwqqhxxxxxcuidetailsesChildren">
        
            <h:outputText value="No cuidetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2a4xwwqqhxxxxxcuidetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2a4xwwqqhxxxxxcuidetailses}" 
                           var="xoxxuq2a4xwwqqhxxxxxcuidetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2a4xwwqqhxxxxxcuidetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq2a4xwwqqhxxxxxcuidetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/cuidetails.xhtml" 
                              id="selectxoxxuq2a4xwwqqhxxxxxcuidetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq2a4xwwqqhxxxxxcuidetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq2a4xwwqqhxxxxxcuidetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq2a4xwwqqhxxxxxcuidetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq2a4xwwqqhxxxxxcuidetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq2a4xwwqqhxxxxxcuidetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq2a4xwwqqhxxxxxcuidetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Cuodetails']}">
        <div class="association" id="xoxxuq2b4xwwqqhxxxxxcuodetailsesChildren">
        
            <h:outputText value="No cuodetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2b4xwwqqhxxxxxcuodetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2b4xwwqqhxxxxxcuodetailses}" 
                           var="xoxxuq2b4xwwqqhxxxxxcuodetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2b4xwwqqhxxxxxcuodetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq2b4xwwqqhxxxxxcuodetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/cuodetails.xhtml" 
                              id="selectxoxxuq2b4xwwqqhxxxxxcuodetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq2b4xwwqqhxxxxxcuodetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq2b4xwwqqhxxxxxcuodetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq2b4xwwqqhxxxxxcuodetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq2b4xwwqqhxxxxxcuodetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq2b4xwwqqhxxxxxcuodetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{xoxxuq2b4xwwqqhxxxxxcuodetails.zhxxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{xoxxuq2b4xwwqqhxxxxxcuodetails.zixxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq2b4xwwqqhxxxxxcuodetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Cuqdetails']}">
        <div class="association" id="xoxxuq2c4xwwqqhxxxxxcuqdetailsesChildren">
        
            <h:outputText value="No cuqdetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2c4xwwqqhxxxxxcuqdetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2c4xwwqqhxxxxxcuqdetailses}" 
                           var="xoxxuq2c4xwwqqhxxxxxcuqdetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq2c4xwwqqhxxxxxcuqdetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq2c4xwwqqhxxxxxcuqdetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/cuqdetails.xhtml" 
                              id="selectxoxxuq2c4xwwqqhxxxxxcuqdetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq2c4xwwqqhxxxxxcuqdetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq2c4xwwqqhxxxxxcuqdetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq2c4xwwqqhxxxxxcuqdetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq2c4xwwqqhxxxxxcuqdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq2c4xwwqqhxxxxxcuqdetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Vshipmendetails']}">
        <div class="association" id="xoxxuq399xvwwqqhxxxxvshipmendetailsesChildren">
        
            <h:outputText value="No vshipmendetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq399xvwwqqhxxxxvshipmendetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq399xvwwqqhxxxxvshipmendetailses}" 
                           var="xoxxuq399xvwwqqhxxxxvshipmendetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq399xvwwqqhxxxxvshipmendetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq399xvwwqqhxxxxvshipmendetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vshipmendetails.xhtml" 
                              id="selectxoxxuq399xvwwqqhxxxxvshipmendetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq399xvwwqqhxxxxvshipmendetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq399xvwwqqhxxxxvshipmendetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq399xvwwqqhxxxxvshipmendetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq399xvwwqqhxxxxvshipmendetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq399xvwwqqhxxxxvshipmendetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{xoxxuq399xvwwqqhxxxxvshipmendetails.xznxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{xoxxuq399xvwwqqhxxxxvshipmendetails.zmxxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{xoxxuq399xvwwqqhxxxxvshipmendetails.zrxxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq399xvwwqqhxxxxvshipmendetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Vendidetails']}">
        <div class="association" id="xoxxuq3c4xwwqqhxxxxxvendidetailsesChildren">
        
            <h:outputText value="No vendidetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3c4xwwqqhxxxxxvendidetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3c4xwwqqhxxxxxvendidetailses}" 
                           var="xoxxuq3c4xwwqqhxxxxxvendidetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3c4xwwqqhxxxxxvendidetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq3c4xwwqqhxxxxxvendidetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vendidetails.xhtml" 
                              id="selectxoxxuq3c4xwwqqhxxxxxvendidetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq3c4xwwqqhxxxxxvendidetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq3c4xwwqqhxxxxxvendidetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq3c4xwwqqhxxxxxvendidetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq3c4xwwqqhxxxxxvendidetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq3c4xwwqqhxxxxxvendidetails.a1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq3c4xwwqqhxxxxxvendidetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Vendodetails']}">
        <div class="association" id="xoxxuq3d4xwwqqhxxxxxvendodetailsesChildren">
        
            <h:outputText value="No vendodetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3d4xwwqqhxxxxxvendodetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3d4xwwqqhxxxxxvendodetailses}" 
                           var="xoxxuq3d4xwwqqhxxxxxvendodetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3d4xwwqqhxxxxxvendodetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq3d4xwwqqhxxxxxvendodetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vendodetails.xhtml" 
                              id="selectxoxxuq3d4xwwqqhxxxxxvendodetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq3d4xwwqqhxxxxxvendodetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq3d4xwwqqhxxxxxvendodetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq3d4xwwqqhxxxxxvendodetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq3d4xwwqqhxxxxxvendodetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq3d4xwwqqhxxxxxvendodetails.a1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq3d4xwwqqhxxxxxvendodetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>


     <p:tab title="${'#'}{messages['Vendqdetails']}">
        <div class="association" id="xoxxuq3e4xwwqqhxxxxxvendqdetailsesChildren">
        
            <h:outputText value="No vendqdetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3e4xwwqqhxxxxxvendqdetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3e4xwwqqhxxxxxvendqdetailses}" 
                           var="xoxxuq3e4xwwqqhxxxxxvendqdetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq3e4xwwqqhxxxxxvendqdetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq3e4xwwqqhxxxxxvendqdetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/vendqdetails.xhtml" 
                              id="selectxoxxuq3e4xwwqqhxxxxxvendqdetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq3e4xwwqqhxxxxxvendqdetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq3e4xwwqqhxxxxxvendqdetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq3e4xwwqqhxxxxxvendqdetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq3e4xwwqqhxxxxxvendqdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq3e4xwwqqhxxxxxvendqdetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq3e4xwwqqhxxxxxvendqdetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>

    </p:tabView>

  <p:tabView switchType="ajax">
     <p:tab title="${'#'}{messages['Emplodetails']}">
        <div class="association" id="xoxxuq454xwwqqhxxxxxemplodetailsesChildren">
        
            <h:outputText value="No emplodetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq454xwwqqhxxxxxemplodetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq454xwwqqhxxxxxemplodetailses}" 
                           var="xoxxuq454xwwqqhxxxxxemplodetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq454xwwqqhxxxxxemplodetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq454xwwqqhxxxxxemplodetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/emplodetails.xhtml" 
                              id="selectxoxxuq454xwwqqhxxxxxemplodetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq454xwwqqhxxxxxemplodetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq454xwwqqhxxxxxemplodetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq454xwwqqhxxxxxemplodetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq454xwwqqhxxxxxemplodetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq454xwwqqhxxxxxemplodetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq454xwwqqhxxxxxemplodetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>


   <#if jobassignmentEntityName??>
     <p:tab title="${'#'}{messages['Jobassignmentdetails']}">
        <div class="association" id="xoxxuq9bfxwwqqhexxxxjobassignmentdetailsesChildren">
        
            <h:outputText value="No jobassignmentdetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses}" 
                           var="xoxxuq9bfxwwqqhexxxxjobassignmentdetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xoxxuq9bfxwwqqhexxxxjobassignmentdetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xoxxuq9bfxwwqqhexxxxjobassignmentdetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/jobassignmentdetails.xhtml" 
                              id="selectxoxxuq9bfxwwqqhexxxxjobassignmentdetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xoxxuq9bfxwwqqhexxxxjobassignmentdetails.a0xxuobxbxxxxxxxxxxxsid}" name="xoxxuq9bfxwwqqhexxxxjobassignmentdetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xoxxuq9bfxwwqqhexxxxjobassignmentdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">sequence</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b1xxuxxrbvxxxxxxxxxxsequence}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">line</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b1xxzo11bvlxxxxxxxxxline}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">sdatet</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b5gxdxsdbvxxxxxxxxxxsdatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">durationh</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b5xxexdhbvxxxxxxxxxxdurationh}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtytotal</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b5xxztqrlxxxxxxxxxxxqtytotal}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">durationm</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b6xx0xdmbvxxxxxxxxxxdurationm}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">pono</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b6xxuxcobvxxxxxxxxxxpono}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">qtyostndt</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b6xxzyqrlxxxxxxxxxxxqtyostndt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">stimeh</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b7xxexshbvxxxxxxxxxxstimeh}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">stimem</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b8bx0xsmbvxxxxxxxxxxstimem}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">stimeampm</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b8extxsabvxxxxxxxxxxstimeampm}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">edatet</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b8xxceedbvxxxxxxxxxxedatet}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">priority</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxfxxxbv08xxxxxxxxpriority}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">cpono</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxuxxrbvxxxxxxxxxxcpono}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">jafield1</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxuxxrbvxxxxxxxxxxjafield1}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">jafield2</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxuxxrbvxxxxxxxxxxjafield2}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">jafield3</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxuxxrbvxxxxxxxxxxjafield3}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">jafield4</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxuxxrbvxxxxxxxxxxjafield4}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">notes</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.b9xxuxznbvxxxxxxxxxxnotes}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">percntdone</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.baxxzxxrlvxxxxxxxxxxpercntdone}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">repeatf</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.bgxxuxxrbv18xxxxxxxxrepeatf}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.z3xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{xoxxuq9bfxwwqqhexxxxjobassignmentdetails.z4xxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xoxxuq9bfxwwqqhexxxxjobassignmentdetailses">
        <div class="actionButtons">
        </div>
        </f:subview>
    </p:tab>

   </#if>
   <#if processdetailsesEntityName??>
     <p:tab title="${'#'}{messages['Processdetails']}">
        <div class="association" id="xxxxuq9ccxwwqqhxxxxxprocessdetailsesChildren">
        
            <h:outputText value="No processdetailses" 
                       rendered="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.xxxxuq9ccxwwqqhxxxxxprocessdetailses}"/>
        
            <p:dataTable tableStyle="table-layout:auto;"  value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.xxxxuq9ccxwwqqhxxxxxprocessdetailses}" 
                           var="xxxxuq9ccxwwqqhxxxxxprocessdetails" 
                      rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemHome.xxxxuq9ccxwwqqhxxxxxprocessdetailses}" 
                    rowClasses="rvgRowOne,rvgRowTwo"
                            id="xxxxuq9ccxwwqqhxxxxxprocessdetailsesTable">
                <p:column>
                    <f:facet name="header">action</f:facet>
                    <h:link outcome="/processdetails.xhtml" 
                              id="selectxxxxuq9ccxwwqqhxxxxxprocessdetails" 
                           value="Select"
                     propagation="none">
                        <f:param disable="${'#'}{empty xxxxuq9ccxwwqqhxxxxxprocessdetails.a0xxuobxbxxxxxxxxxxxsid}" name="xxxxuq9ccxwwqqhxxxxxprocessdetailsA0xxuobxbxxxxxxxxxxxsid" 
                                value="${'#'}{xxxxuq9ccxwwqqhxxxxxprocessdetails.a0xxuobxbxxxxxxxxxxxsid}"/>
                        <f:param name="xxxxuq9ccxwwqqhxxxxxprocessdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitem"/>
                    </h:link>
                </p:column>
                <p:column>
                    <f:facet name="header">process</f:facet>
                    <h:outputText value="${'#'}{xxxxuq9ccxwwqqhxxxxxprocessdetails.a0xxukpdbvxxxxxxxxxxprocess}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">notes</f:facet>
                    <h:outputText value="${'#'}{xxxxuq9ccxwwqqhxxxxxprocessdetails.b9xxuxznbvxxxxxxxxxxnotes}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfl</f:facet>
                    <h:outputText value="${'#'}{xxxxuq9ccxwwqqhxxxxxprocessdetails.z2xxzzfxhhxxxxxxxxxxstatusfl}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">statusfldt</f:facet>
                    <h:outputText value="${'#'}{xxxxuq9ccxwwqqhxxxxxprocessdetails.z3xxcztxlxxxxxxxxxxxstatusfldt}"/>
                </p:column>
                <p:column>
                    <f:facet name="header">owner</f:facet>
                    <h:outputText value="${'#'}{xxxxuq9ccxwwqqhxxxxxprocessdetails.z4xxutoxlhxxxxxxxxxxowner}"/>
                </p:column>
            </p:dataTable>
        
        </div>
          
        <f:subview rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.managed}" id="xxxxuq9ccxwwqqhxxxxxprocessdetailses">
        <div class="actionButtons">
            <h:button id="addxxxxuq9ccxwwqqhxxxxxprocessdetails" 
                   value="Add processdetails"
                    outcome="/processdetailsEdit.xhtml"
                    propagation="none">
                 <f:param disable="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"  name="fpxxfq1a5xwwqqhxxxxxitemA0xxuobxbxxxxxxxxxxxsid" 
                         value="${'#'}{fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxuobxbxxxxxxxxxxxsid}"/>
                   <f:param name="xxxxuq9ccxwwqqhxxxxxprocessdetailsFrom" value="Fpxxfq1a5xwwqqhxxxxxitemEdit" />
            </h:button>
        </div>
        </f:subview>
    </p:tab>

   </#if>
    </p:tabView>


</div>
</p:panel>
</p:panel>
</h:form>

</ui:define>

</ui:composition>
</#if>
</#if>


