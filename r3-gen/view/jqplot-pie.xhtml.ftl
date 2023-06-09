<#assign tobegeneratedCandidate = "N">  
<#assign entityName = pojo.shortName>
<#assign componentName = entityName?uncap_first>
<#assign listName = componentName + "List">
<#assign homeName = componentName +  "Home">
<#assign naturalKeyName = "">
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign menuAttributes2 = pojo.shortName?substring(0,eL)>
 <#if (menuAttributes2?substring(efS,efE) == '1a' | menuAttributes2?substring(efS,efE) == '18'| menuAttributes2?substring(efS,efE) == '1b' )
     | menuAttributes2?substring(efS,efE) == '20' | menuAttributes2?substring(efS,efE) == '30'| menuAttributes2?substring(efS,efE) == '40'
     >
  <#assign tobegeneratedCandidate ="Y" >
 </#if>
</#if>
<#if tobegeneratedCandidate == "Y">  
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
        xmlns:p="http://primefaces.org/ui"
        template="layout/rtemplate.xhtml">
<f:metadata>
    <f:viewAction action="${'#'}{${homeName}.restrict()}" />
    <f:viewParam name="key" value="${'#'}{empty fpxxfq1a5xwwqqhxxxxxitemHome.instance?'':fpxxfq1a5xwwqqhxxxxxitemHome.instance.a0xxukixbxxxxxxxxxxxmatcode}"/>
</f:metadata>

<ui:define name="body">
    <h:form id="plotsitems" styleClass="edit">
	<p:toolbar height="26" itemSeparator="grid">
	  <p:toolbarGroup>
              <h:button id="printb" alt="Print"  onclick="this.form.target='_blank'"  action="${'#'}{${listName}.print()}" image="./img/Print16.gif" />
	  </p:toolbarGroup>
	  <p:toolbarGroup>
              <h:button id="tdone" image="./img/home_24.png"  alt="Cancel" value="Cancel"  outcome="/home.xhtml" />
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
              <h:outputText value="${'#'}{customIdentity.username}"/> 
              <h:outputText value="${'#'}{authenticator.currcaldates}"/> 
 		   <h:graphicImage value="/img/Search16.gif" styleClass="pic"/>
	  </p:toolbarGroup>
	  <p:toolbarGroup location="right">
		   <h:graphicImage id="Helpt" value="/img/help.gif" styleClass="pic">
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['jqplot-pieHelp']}"/></span> </p:tooltip> 
             </h:graphicImage>
	  </p:toolbarGroup>
       <h:messages globalOnly="false" styleClass="message" id="globalMessages"/>
	</p:toolbar>
          <div style="position: relative;">
           <h:outputText style="color:blue;" value="${'#'}{messages['Based']} ${'#'}{messages['on']} ${'#'}{messages['status']} ${'#'}{messages['timestamp']}, "  rendered="true"  />
           <br></br><h:outputText style="color:blue;" value="${'#'}{messages['left-side']} ${'#'}{messages['chart']} ${'#'}{messages['shows']} ${'#'}{messages['upto']} ${'#'}{messages['six']}"  rendered="true"  />
           <br></br><h:outputText style="color:blue;" value="${'#'}{messages['and']} ${'#'}{messages['right-side']} ${'#'}{messages['one']} ${'#'}{messages['shows']} ${'#'}{messages['most']}  ${'#'}{messages['recent']} ${'#'}{messages['updated']} ${'#'}{messages['one']}"  rendered="true"  />
            
            &nbsp;<h:button id="done" 
                   value="Done"
             propagation="end"
                    outcome="/${componentName?substring(eL)}Report.xhtml" />
             <br></br>
           </div>

<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<h:head>
<#-- each $(function) gets invoked in seq, first one shows setbrkt upto 6 by date , 2nd one shows setbrkt[0] one ie latest statusfldt
-->
<link href='./stylesheet/jquery.jqplot.min.css' rel='stylesheet' />
<script src='./js/jquery.jqplot.min.js'></script>
<script src='./js/lib/jqplot.pieRenderer.min.js'></script>
<script src='./js/lib/jqplot.donutRenderer.min.js'></script>
<script type="text/javascript" src="./js/lib/jqplot.json2.min.js"></script>

<script>
//alert (window.location.hostname);

$.jqplot.config.enablePlugins = true; 
$(document).ready(function(){
//alert (window.location);
      //pie chart  [[[n,v],[n,v]]] n name and v value
      //bar chart  [[v,v,v,v][v,v,v]] v y axis value x axis will show 1,2 etc
      //    ticks  [n,n,n,n]  n x axis tick names instead of 1,2  
      //line chart [[v,v,v]]  v y axis values x axis done automatically to show 1,2
      //    each group of [n.v] or [v,v..] is part of series
      //    series label [{label:"xx"},]    
      // pie chart series will be added later,but bar chart needs series now
      // pie chart will show distribution of say amount of purchase  among customers 
      // bar chart will show purchase amt, return amt etc for one customer and same thing for others 
      // in the series
      // rest request will be /${componentName?substring(eL)}q/{m(arked)}/a(mt)q(ty)
      //                                                                         /a(ll)/r(trn)
      //                                                                         /k(ey)xxxxx/m(isc)
      //                                                                         /m/m(etrics)

  // Our ajax data renderer which here retrieves a text file.
  // it could contact any source and pull data, however.
  // The options argument isn't used in this renderer.
  var sSeries = " ";
  <#if (menuAttributes2?substring(efS,efE) == '1a') >
   var sLabels=['Qty in Stock','Customer Orders','Vendor Orders','Customer Picked Up','Picked Up from Supplier','Customer Invoiced ','Shipped ','Received '];
  <#elseif (menuAttributes2?substring(efS,efE) == '20' || menuAttributes2?substring(efS,efE) == '30' ) >
   var sLabels=['Order Totals','Orders Qty','Return Totals','Returns Qty','Paid Totals','Misc Charges ','Delivery Charges '];
  <#elseif (menuAttributes2?substring(efS,efE) == '40'  ) >
   var sLabels=['Assignments Total'];
  <#else>
   var sLabels=[];
  </#if>
  var ajaxDataRenderer = function(url, plot, options) {
    var filtered = [];
    var setbrkt = [];
    var jay = [];
    var username="abc";
    var paasword="password";
    $.ajax({
      // have to use synchronous here, else the function
      // will return before the data is fetched
      // alerts removed use firebug to step through find xxbar.js under script  
      async: false,
      url: url,
      dataType:"xml",
      beforeSend: function(xhr) {
        //alert ('jay before send');
       xhr.setRequestHeader('Authorization', 'Basic ' + btoa(unescape(encodeURIComponent('clientId' + ':' + 'restPW'))))
      },
      success: function(data) {
       $(data).find("entity").each(function() {
        sSeries=sSeries+$(this).children("label").text()+" > " 
        $(this).children("metrix").each(function(index){
         <#if (menuAttributes2?substring(efS,efE) == '1a')> 
          filtered.push([sLabels[index],parseFloat($(this).children("Value").text())]);
         <#elseif (menuAttributes2?substring(efS,efE) == '1b')> 
          filtered.push([$(this).children("Item").text(),parseFloat($(this).children("Value").text())]);
         <#else>
          filtered.push([sLabels[index],parseFloat($(this).children("Value").text())]);
         </#if> 
        });
        setbrkt.push(filtered);
        filtered=[];
       });
      } 
    });
    return setbrkt;
  };
 
  // The url for our json data resteasy does not need front part of url
  var jsonurl = "rest/${componentName?substring(eL)}q";
  //Get the data prior to creating the graph.
  var plotData = ajaxDataRenderer(jsonurl);
 
  // passing in the url string as the jqPlot data argument is a handy
  // shortcut for our renderer.  You could also have used the
  // "dataRendererOptions" option to pass in the url.
  var ticks = ['Jan', 'Feb', 'Mar', 'Apr'];
  var plot1 = $.jqplot('chart1', plotData,{
    seriesDefaults: {
        // Make this a pie chart.
        renderer: jQuery.jqplot.DonutRenderer,
        rendererOptions: {
          // Put data labels on the pie slices.
          // By default, labels show the percentage of the slice.
          showDataLabels: true
        }
    },
    grid: {borderColor: 'white', shadow: false, drawBorder: true},
    <#if (menuAttributes2?substring(efS,efE) == '1b') > 
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} "+sSeries,
    <#elseif (menuAttributes2?substring(efS,efE) == '18') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Assigned: "+sSeries,
    <#elseif (menuAttributes2?substring(efS,efE) == '1a') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Orders: "+sSeries,
    <#else>
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Orders: "+sSeries,
    </#if>
    legend: { show:true, location: 'e' }
  });
});
</script>

<script>
//alert (window.location.hostname);

$.jqplot.config.enablePlugins = true; 
$(document).ready(function(){
//alert (window.location);
      //pie chart  [[[n,v],[n,v]]] n name and v value
      //bar chart  [[v,v,v,v][v,v,v]] v y axis value x axis will show 1,2 etc
      //    ticks  [n,n,n,n]  n x axis tick names instead of 1,2  
      //line chart [[v,v,v]]  v y axis values x axis done automatically to show 1,2
      //    each group of [n.v] or [v,v..] is part of series
      //    series label [{label:"xx"},]    
      // pie chart series will be added later,but bar chart needs series now
      // pie chart will show distribution of say amount of purchase  among customers 
      // bar chart will show purchase amt, return amt etc for one customer and same thing for others 
      // in the series
      // rest request will be rest/${componentName?substring(eL)}q/{m(arked)}/a(mt)q(ty)
      //                                                                         /a(ll)/r(trn)
      //                                                                         /k(ey)xxxxx/m(isc)
      //                                                                         /m/m(etrics)

  // Our ajax data renderer which here retrieves a text file.
  // it could contact any source and pull data, however.
  // The options argument isn't used in this renderer.
  var sSeries = " ";
  var executed = false;
  <#if (menuAttributes2?substring(efS,efE) == '1a') >
   var sLabels=['Qty in Stock','Customer Orders','Vendor Orders','Customer Picked Up','Picked Up from Supplier','Customer Invoiced ','Shipped ','Received '];
  <#elseif (menuAttributes2?substring(efS,efE) == '20' || menuAttributes2?substring(efS,efE) == '30' ) >
   var sLabels=['Order Totals','Orders Qty','Return Totals','Returns Qty','Paid Totals','Misc Charges ','Delivery Charges '];
  <#elseif (menuAttributes2?substring(efS,efE) == '40'  ) >
   var sLabels=['Assignments Total'];
  <#else>
   var sLabels=[];
  </#if>
  var ajaxDataRenderer = function(url, plot, options) {
    var filtered = [];
    var setbrkt = [];
    var jay = [];
    $.ajax({
      // have to use synchronous here, else the function
      // will return before the data is fetched
      // alerts removed use firebug to step through find xxbar.js under script  
      async: false,
      url: url,
      dataType:"xml",
      beforeSend: function(xhr) {
        //alert ('jay before send');
       xhr.setRequestHeader('Authorization', 'Basic ' + btoa(unescape(encodeURIComponent('clientId' + ':' + 'restPW'))))
      },
      success: function(data) {
       $(data).find("entity").each(function() {
       if (!executed) {
        executed = true;
        sSeries=sSeries+$(this).children("label").text() 
       }
        $(this).children("metrix").each(function(index){
         <#if (menuAttributes2?substring(efS,efE) == '1a')> 
          filtered.push([sLabels[index],parseFloat($(this).children("Value").text())]);
         <#elseif (menuAttributes2?substring(efS,efE) == '1b')> 
          filtered.push([$(this).children("Item").text(),parseFloat($(this).children("Value").text())]);
         <#else>
          filtered.push([sLabels[index],parseFloat($(this).children("Value").text())]);
         </#if> 
        });
        setbrkt.push(filtered);
        filtered=[];
       });
      } 
    });
    jay.push(setbrkt[0]);
    return jay;
  };
 
  // The url for our json data resteasy does not need front part of url
  var jsonurl = "rest/${componentName?substring(eL)}q";
  //Get the data prior to creating the graph.
  var plotData = ajaxDataRenderer(jsonurl);
 
  // passing in the url string as the jqPlot data argument is a handy
  // shortcut for our renderer.  You could also have used the
  // "dataRendererOptions" option to pass in the url.
  var ticks = ['Jan', 'Feb', 'Mar', 'Apr'];
  var plot2 = $.jqplot('chart2', plotData,{
    seriesDefaults: {
        // Make this a pie chart.
        renderer: jQuery.jqplot.PieRenderer,
        rendererOptions: {
          // Put data labels on the pie slices.
          // By default, labels show the percentage of the slice.
          showDataLabels: true
        }
    },
    grid: {borderColor: 'white', shadow: false, drawBorder: true},
    <#if (menuAttributes2?substring(efS,efE) == '1b') > 
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} "+sSeries[0],
    <#elseif (menuAttributes2?substring(efS,efE) == '18') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Assigned: "+sSeries,
    <#elseif (menuAttributes2?substring(efS,efE) == '1a') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Order: "+sSeries,
    <#else>
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Order: "+sSeries,
    </#if>
    legend: { show:true, location: 'e' }
  });
});
</script>

</h:head>
<h:body>
<div id="chart1" style="float: left;width:45%;height:50%; "></div>
<div id="chart2" style="float: right;width:50%;height:50%; "></div>
</h:body>
</html>
    </h:form>

</ui:define>

</ui:composition>

</#if>


