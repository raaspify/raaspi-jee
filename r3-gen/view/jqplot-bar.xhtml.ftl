<#assign tobegeneratedCandidate = "N">  
<#assign entityName = pojo.shortName>
<#assign componentName = entityName?uncap_first>
<#assign listName = componentName + "List">
<#assign homeName = componentName +  "Home">
<#assign naturalKeyName = "">
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
 <#assign menuAttributes2 = pojo.shortName?substring(0,eL)>
<#if (menuAttributes2?substring(efS,efE) == '1a' | menuAttributes2?substring(efS,efE) == '18' | menuAttributes2?substring(efS,efE) == '1b' )
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
<!-- Generated By jqplot-bar.xhtml.ftl on ${.now}
  Two charts  for customer/vendor orders, side by side , chart1 on left for high volumes and chart2 on right for latest orders 
-->
<ui:define name="body">
    <h:form id="plotsitems" styleClass="edit">
	<p:toolbar height="26" itemSeparator="grid">
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
             <p:tooltip > <span style="white-space: nowrap"> <h:inputTextarea  cols="70" rows="10" readonly="true"  value="${'#'}{messages['jqplot-barHelp']}"/></span> </p:tooltip> 
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
<script src='./js/lib/jqplot.canvasTextRenderer.min.js'></script>
<script src='./js/lib/jqplot.canvasAxisLabelRenderer.min.js'></script>
<script type="text/javascript" src="./js/lib/jqplot.json2.min.js"></script>
<script type="text/javascript" src="./js/lib/jqplot.barRenderer.min.js"></script>
<script type="text/javascript" src="./js/lib/jqplot.categoryAxisRenderer.min.js"></script>
<script type="text/javascript" src="./js/lib/jqplot.canvasAxisTickRenderer.min.js"></script>
<script type="text/javascript" src="./js/lib/jqplot.dateAxisRenderer.min.js"></script>

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
      //see EntityService.java.ftl for rest service. 
      //Fpxxfq1a5xwwqqhxxxxxitemEntityService.java calls query to return sid,matcode,qty etc 
      // for the last 6 updated items.
      // both chart1 and 2 gets 6 items but chart2 script below returns only the latest updated one
      // to plot logic
      // dec26 2019 added logic to pass the key value and if matches to one of the six then pass that to plot 
      // tbd, in the mean time just add a Tip message
  // Our ajax data renderer which here retrieves a text file.
  // it could contact any source and pull data, however.
  // The options argument isn't used in this renderer.
  var sLabels=[];
  var ajaxDataRenderer = function(url, plot, options) {
    var filtered = [];
    var setbrkt = [];
    var jay = [];
    var username="abc";
    var paasword="password";
    $.ajax({
      // have to use synchronous here, else the function
      // will return before the data is fetched
      async: false,
      url: url,
      dataType:"xml",
      beforeSend: function(xhr) {
        //alert ('jay before send');
       xhr.setRequestHeader('Authorization', 'Basic ' + btoa(unescape(encodeURIComponent('clientId' + ':' + 'restPW'))))
      },
      // alerts removed use firebug to step through find xxbar.js under script  
      success: function(data) {
       $(data).find('entity').each(function() {
        sLabels.push({label:$(this).children("label").text()});
        $(this).children("metrix").each(function(){
         filtered.push(parseFloat($(this).children("Value").text()));
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
    legend: { show:true, location: 'e' },
    grid: {borderColor: 'white', shadow: false, drawBorder: true},
    <#if (menuAttributes2?substring(efS,efE) == '1b') > 
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']}" ,
    <#elseif (menuAttributes2?substring(efS,efE) == '18') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Assigned:",
    <#elseif (menuAttributes2?substring(efS,efE) == '1a') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Orders:",
    <#else>
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Orders:",
    </#if>
    series:sLabels,
    axesDefaults: {
        tickRenderer: jQuery.jqplot.CanvasAxisTickRenderer ,
        tickOptions: {
          angle: -30,
          fontSize: '10pt'
        }
    },
    axes: {
      xaxis: {
        renderer: jQuery.jqplot.CategoryAxisRenderer
      }
    }
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
      // rest request will be /${componentName?substring(eL)}q/{m(arked)}/a(mt)q(ty)
      //                                                                         /a(ll)/r(trn)
      //                                                                         /k(ey)xxxxx/m(isc)
      //                                                                         /m/m(etrics)

  // Our ajax data renderer which here retrieves a text file.
  // it could contact any source and pull data, however.
  // The options argument isn't used in this renderer.
  var sLabels=[];
  var ajaxDataRenderer = function(url, plot, options) {
    var filtered = [];
    var setbrkt = [];
    var jay = [];
    $.ajax({
      // have to use synchronous here, else the function
      // will return before the data is fetched
      async: false,
      url: url,
      dataType:"xml",
      beforeSend: function(xhr) {
        //alert ('jay before send');
       xhr.setRequestHeader('Authorization', 'Basic ' + btoa(unescape(encodeURIComponent('clientId' + ':' + 'restPW'))))
      },
      // alerts removed use firebug to step through find xxbar.js under script  
      success: function(data) {
       $(data).find('entity').each(function() {
        sLabels.push({label:$(this).children("label").text()});
        $(this).children("metrix").each(function(){
         filtered.push(parseFloat($(this).children("Value").text()));
        });
        setbrkt.push(filtered);
        filtered=[];
       });
      } 
    });
    //check param['key'] value or use existing report staret/end fpxxfq1a5xwwqqhxxxxxitemList.start value
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
    legend: { show:true, location: 'e' },
    grid: {borderColor: 'white', shadow: false, drawBorder: true},
    <#if (menuAttributes2?substring(efS,efE) == '1b') > 
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']}" ,
    <#elseif (menuAttributes2?substring(efS,efE) == '18') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Assigned:",
    <#elseif (menuAttributes2?substring(efS,efE) == '1a') >
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Order:",
    <#else>
     title: "${'#'}{messages['${entityName?substring(eL)?cap_first}']} Order:",
    </#if>
    series:sLabels,
    axesDefaults: {
        tickRenderer: jQuery.jqplot.CanvasAxisTickRenderer ,
        tickOptions: {
          angle: -30,
          fontSize: '10pt'
        }
    },
    axes: {
      xaxis: {
        renderer: jQuery.jqplot.CategoryAxisRenderer
      }
    }
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

