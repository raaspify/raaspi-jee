<#assign generateCandidate = "N">  
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)  && seatEntityName??>
 <#assign menuAttributes = pojo.shortName?substring(0,10)?upper_case>
 <#if (menuAttributes?substring(6,8) == '1S') >
  <#assign generateCandidate ="Y" >
 </#if>
 <#if generateCandidate == "Y">                       
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                             "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "../view/assigns/mergedassigns.properties" >
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets"
                xmlns:f="http://java.sun.com/jsf/core"
                xmlns:h="http://java.sun.com/jsf/html"
                xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
                xmlns:p="http://primefaces.org/ui"
                template="layout/rtemplate.xhtml">
   <ui:remove>s:defaultAction removed, eqv p:defaultCommand
     s:hasRole removed replaced w true look into calling a method
     instead of page.xml use f:template,f:viewparam
   </ui:remove>
<f:metadata>
    <f:viewParam name="${seatEntityName}A0xxuobxbxxxxxxxxxxxsid" value="${'#'}{${seatEntityName}Home.${seatEntityName}A0xxuobxbxxxxxxxxxxxsid}"/>
    <f:viewParam name="${seatEntityName}From" value="${'#'}{${seatEntityName}Home.${seatEntityName}From}"/>
    <f:viewAction action="${'#'}{${seatEntityName}Home.restrict()}" />
    <f:viewAction action="${'#'}{${seatEntityName}Home.wire()}" />
</f:metadata>
<ui:define name="title">${'#'}{customIdentity.owner2} webpage to assign ${'#'}{messages['Seat']}</ui:define>

<ui:define name="body">
<h:form id="${seatEntityName}" styleClass="edit">
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
              <h:button id="tdone" image="./img/home_24.png"  alt="Cancel" value="Cancel" propagation="end"  rendered="${'#'}{!${seatEntityName}Home.managed}" outcome="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup>
              <h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  rendered="${'#'}{${seatEntityName}Home.managed}" outcome="/home.xhtml" />
              <h:outputText value="${'#'}{messages['Change']} ${'#'}{messages['done']}-${'#'}{${seatEntityName}Home.getCurrentTime()}"
                style="color:green;"
                rendered="${'#'}{${seatEntityName}Home.changeDone}">
               <f:convertDateTime   type="time" />
              </h:outputText>
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{customIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic" rendered="${'#'}{messages['SeatEditHelp']!='SeatEditHelp'}">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['CompanyEditHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
       <h:messages globalOnly="true" style = "color:red;margin:8px;" styleClass="message" id="globalMessages"/>
	</p:toolbar>

        <p:panel>


        <h:panelGrid columns="2">

            <f:facet name="header">${'#'}{messages['Allocate']} ${'#'}{messages['Seat']} (Beta)</f:facet>

        <ui:remove>
         <p:messages ajaxRendered="true"  />
        </ui:remove>



  
           <ui:decorate id="locationDecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Location']} 
            </ui:define>
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   required="false"
                    disabled="${'#'}{${seatEntityName}Home.instance.a0xxuobxbxxxxxxxxxxxsid !=null?true:false}"
                    validator="${'#'}{${seatEntityName}Home.validateAndSelectXxxxxxxxlocation}" 
                   value="${'#'}{fxxxcq144xwwqqhxxxxxlocationHome.lastfxxxcq144xwwqqhxxxxxlocationP}"
             >   
               <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
              <f:selectItems 
                     value="${'#'}{fxxxcq144xwwqqhxxxxxlocationList.suggest(' ')}" var ="result" itemValue="${'#'}{result}" 
                     itemLabel="${'#'}{result}"/>
             </h:selectOneMenu>
           </ui:decorate>
         </h:panelGrid>

        <h:panelGrid columns="12">

           <ui:decorate id="rowDecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Seat']} ${'#'}{messages['row']} 
            </ui:define>
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   required="false"
                    disabled="${'#'}{${seatEntityName}Home.instance.a0xxuobxbxxxxxxxxxxxsid !=null?true:false}"
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
           </ui:decorate>

           <ui:decorate id="seatDecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Seat']} ${'#'}{messages['number']} 
            </ui:define>
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   required="false"
                    validator="${'#'}{${seatEntityName}Home.validateKeyDuplicateRow}" 
                   value="${'#'}{${seatEntityName}Home.mailingText5}"
             >   
              <p:ajax  render="seatDecorationT" bypassUpdates="false"/>

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
           </ui:decorate>

</h:panelGrid>
             <br/> 


        <h:panelGrid columns="18">


          <h:outputText value="" />

           <ui:decorate id="statusDecorationT" template="layout/edit.xhtml" >
            <ui:define name="label">${'#'}{messages['Seat']} ${'#'}{messages['status']} 
            </ui:define>
             <h:selectOneMenu styleClass="autoCompleteWidth50" 
                   rendered="${'#'}{!fn:containsIgnoreCase(request.getHeader('User-Agent'), 'Jayfox')}"
                   required="false"
                   value="${'#'}{${seatEntityName}Home.mailingText1}"
             >   
               <f:selectItem itemValue="${'#'}{null}" itemLabel="" />
               <f:selectItem itemValue="X" itemLabel="Assign" />
               <f:selectItem itemValue="H" itemLabel="Hold" />
               <f:selectItem itemValue=" " itemLabel="Remove Hold" />
             </h:selectOneMenu>
           </ui:decorate>



            <h:panelGroup id="seatnameDecoration"    >
        <h:outputLabel  for="seatname" value="${'#'}{messages['customer']} ${'#'}{messages['Name']}">

      </h:outputLabel>
         <h:inputText id="seatname" 

                           size="20"
                      maxlength="60"

                          value="${'#'}{${seatEntityName}Home.mailingText2}">

         </h:inputText>

            </h:panelGroup>

            <h:panelGroup id="ticketDecoration"  >
        <h:outputLabel  for="ticket" value="${'#'}{messages['Ticket']} ${'#'}{messages['number']}">

      </h:outputLabel>
         <h:inputText id="ticket" 

                           size="20"
                      maxlength="60"

                          value="${'#'}{${seatEntityName}Home.mailingText3}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="orderDecoration"    >
        <h:outputLabel  for="order" value="${'#'}{messages['order']} ${'#'}{messages['number']}">

      </h:outputLabel>
         <h:inputText id="order" 

                           size="20"
                      maxlength="60"

                          value="${'#'}{${seatEntityName}Home.mailingText4}">

         </h:inputText>

            </h:panelGroup>





            <h:panelGroup id="b6xxutoxlhxxxxxxxxxxownerDecoration"  rendered="${'#'}{customIdentity.hasRole('SH') or customIdentity.hasRole('EH')?true:false}">
        <h:outputLabel  for="b6xxutoxlhxxxxxxxxxxowner" value="${'#'}{messages['Owner']}">

      </h:outputLabel>
         <h:inputText id="b6xxutoxlhxxxxxxxxxxowner" 

                           size="20"
                      maxlength="40"

                          value="${'#'}{${seatEntityName}Home.instance.b6xxutoxlhxxxxxxxxxxowner}">

         </h:inputText>

            </h:panelGroup>


   </h:panelGrid>



        
            <div style="clear:both">
                <span class="required">*</span> 
                required fields
            </div>

            
                
<div class="actionButtons">
             <p:status name="buttonStatus" >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:status>
    <ui:remove>removed 89 schedule because one schedule one detail, nov20 2018 added va after fixing report to show vendor</ui:remove>
                       <ui:remove>
                       may07 2018 allow record 2(shopify id/secret),3
                       disabled="true"
                       </ui:remove>

          
            <p:commandButton id="assign" styleClass="${'#'}{!trexuq244xwwqqhxxxxxcuordersHome.managed?'button':'buttonMain'}" 
                          value="${'#'}{messages['Assign']}" status="buttonStatus" render="@form"
                         action="${'#'}{${seatEntityName}Home.assign(${seatEntityName}Home.last${seatEntityName},${seatEntityName}Home.instance.a2xxukstbvxxxxxxxxxxrow,${seatEntityName}Home.mailingText5,${seatEntityName}Home.mailingText1,${seatEntityName}Home.mailingText2,${seatEntityName}Home.mailingText3,${seatEntityName}Home.mailingText4)}"
                       rendered="true"/>
                        			  

            <p:commandButton id="update2" 
                          value="${'#'}{messages['More_Updates']}" status="buttonStatus" render="@form"
                         action="${'#'}{${seatEntityName}Home.update()}"
                       rendered="${'#'}{${seatEntityName}Home.managed and ${seatEntityName}Home.entityUpdated}"/>
                        			  
            <h:commandButton id="delete" 
                          value="${'#'}{messages['delete']}" 
                         action="${'#'}{${seatEntityName}Home.remove()}"
                       rendered="${'#'}{${seatEntityName}Home.managed and !${seatEntityName}Home.entityDeleted}"/>

            <h:button id="new" styleClass="buttonMain" 
                   value="New"
             propagation="begin"
             includePageParams="false" 
                    outcome="/seatEdit.xhtml"
                       rendered="${'#'}{${seatEntityName}Home.managed}"/>
                 

            <p:hotKey  onkeydown="${'#'}{p:element('save')}.click();return false;" preventDefault="true" enabledInInput="true" key="return">
            </p:hotKey>
            <p:hotKey  onkeydown="${'#'}{p:element('update')}.click();return false;" preventDefault="true" enabledInInput="true" key="ctrl+u">
            </p:hotKey>




            <f:param name="reportName" value="${'#'}{${seatEntityName}List.reportName}"/>
            <f:param name="displayAs" value="${'#'}{${seatEntityName}List.displayAs}" /> 
            <h:button outcome="/seatList.xhtml" id="list" styleClass="buttonMain" 
              propagation="none"
                 value="${'#'}{messages['List']} ${'#'}{messages['Seat']} ${'#'}{messages['rows']}">
            </h:button>    

            <h:button id="done" 
                   value="${'#'}{messages['Done']}"
             propagation="end"
                    outcome="/${'#'}{empty ${seatEntityName}Home.${seatEntityName}From ? 'home' : ${seatEntityName}Home.${seatEntityName}From}.xhtml"

                rendered="${'#'}{${seatEntityName}Home.managed or ${seatEntityName}Home.entityDeleted}"/>
            
            <h:button id="cancel" 
                   value="${'#'}{messages['Cancel']}"
             propagation="end"
                    outcome="/${'#'}{empty ${seatEntityName}Home.${seatEntityName}From ? 'home' : ${seatEntityName}Home.${seatEntityName}From}.xhtml"
                rendered="${'#'}{!${seatEntityName}Home.managed and !${seatEntityName}Home.entityDeleted}"/>






</div>
</p:panel>
       <p:messages ajaxRendered="true"  />


<p:panel>


</p:panel>
</h:form>

</ui:define>

</ui:composition>
</#if>
</#if>

