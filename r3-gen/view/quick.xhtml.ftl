<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,10)?upper_case>
<#-- 56 (User) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#if (menuAttributes?substring(6,8) == '56') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<ui:composition xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://primefaces.org/ui"
      template="layout/template.quick.xhtml">
 
<ui:define name="body">
    <h:form id="qflow" styleClass="edit">
	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
             <ui:remove>
              <h:button id="done" image="./img/home_24.png" style="pic" alt="Home" value="Home" propagation="end" outcome="/home.xhtml" />
             </ui:remove>
              <h:button id="done" value="Home" propagation="end" outcome="/home.xhtml" />

	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{customIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
		   <h:graphicImage value="/img/Search16.gif" styleClass="pic"/>
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['quickHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
	</p:toolbar>

    <h:messages globalOnly="false" styleClass="message" id="globalMessages"/>





   <div id="window4" class="window"><strong>Customer</strong><br/> <a href="${customerEntityName?substring(eL)}Edit.wflow"> <img src="./img/Customer16.png"  class="imtip"/>+Add </a> <br /><br /><a href="${customerEntityName?substring(eL)}List.wflow">List</a></div>
		
   <div id="window2" class="window"><strong>Employee</strong><br /> <a href="${employeeEntityName?substring(eL)}Edit.wflow"><img src="./img/Employee16.png"/>+Add </a><br /><br /><a href="${employeeEntityName?substring(eL)}List.wflow">List</a></div>
	    
   <div id="window3" class="windowItem"><strong>Item</strong><br /> <a href="${itemEntityName?substring(eL)}Edit.wflow"><img src="./img/Item16.png"/>+Add </a><br /><br /> <a href="${itemEntityName?substring(eL)}List.wflow">List</a></div>
	    
   <div id="window1" class="window"><strong>Supplier</strong><br /> <a href="${vendorEntityName?substring(eL)}Edit.wflow"><img src="./img/Vendor16.png"/>+Add </a> <br /><br /><a href="${vendorEntityName?substring(eL)}List.wflow">List</a></div>
   <br /><br />	    	
	    
   <script src="https://explorercanvas.googlecode.com/svn/trunk/excanvas.js" type="text/javascript"></script>
		
		
   <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.min.js" type="text/javascript"></script>
   <script>    jQuery.noConflict();</script>
		<#-- support lib for bezier stuff -->
		<script type="text/javascript" src="./js/lib/jsBezier-0.2-min.js"></script>
		<#-- main jsplumb engine -->
		<script type="text/javascript" src="./js/1.3.2/jsPlumb-1.3.2-RC1.js"></script>
		<#-- connectors, endpoint and overlays  -->
		<script type="text/javascript" src="./js/1.3.2/jsPlumb-defaults-1.3.2-RC1.js"></script>
		<#-- SVG renderer -->
		<script type="text/javascript" src="./js/1.3.2/jsPlumb-renderers-svg-1.3.2-RC1.js"></script>
		<#-- canvas renderer -->
		<script type="text/javascript" src="./js/1.3.2/jsPlumb-renderers-canvas-1.3.2-RC1.js"></script>
		<#-- vml renderer -->
		<script type="text/javascript" src="./js/1.3.2/jsPlumb-renderers-vml-1.3.2-RC1.js"></script>
		<#-- jquery jsPlumb adapter -->
		<script type="text/javascript" src="./js/1.3.2/jquery.jsPlumb-1.3.2-RC1.js"></script>

		<#--  demo code -->
		<script type="text/javascript" src="./js/1.3.2/quickflow.js"></script>

		<#--  demo helper code -->
		<script type="text/javascript" src="./js/1.3.2/quickflow-helper-jquery.js"></script>

  </h:form>
 <p:dialog id="popupq" modal="false" autosized="false" show="true"  width="260" resizeable="true" left="850">
 <f:facet name="header">explanation</f:facet>
        <f:facet name="controls">
            <h:outputLink value="${'#'}" onclick="PF('popupq').hide(); return false;">
                X
            </h:outputLink>
        </f:facet>	    
	    	
     This gives a <b>visual </b>presentaion of the work flow involved and initially <br/> may be a more intutive usage alternative to Menu options.<br/>
     <br/><b>Click on the Links </b>on the entity boxes to add or list them or Hover the mouse<br/> over the <b>connections </b>to highlight them and click to carry out various other functions.
   <br /><br />
 	See <a href="https://www.3rcomputer.com" target="_blank">3R Compuer Systems Website </a> <br />
	    	
 </p:dialog>


</ui:define>

</ui:composition>
</#if>
</#if>
