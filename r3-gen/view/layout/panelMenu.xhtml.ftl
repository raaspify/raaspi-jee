<#assign tobegeneratedCandidate = "N">  
<#include "../assigns/PositionLength.properties" >
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#-- 56 (User) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#if (menuAttributes?substring(efS,efE) == '56') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<#assign appaccounting = "${appaccounting}">  
<#include "../assigns/mergedassigns.properties" >
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">

	<style>
	.pic {
		margin-bottom: -4px;
		margin-right: 2px;
	}
	</style>

	<h:form>
<h:outputStylesheet>
.rf-pm-itm-ico{
padding-left: 0px !important;
}
</h:outputStylesheet>

            <rich:panelMenu style="width:140px" itemMode="server" groupMode="ajax" groupExpandedLeftIcon="/img/info.24.png"
                groupCollapsedLeftIcon="triangleDown" topGroupExpandedRightIcon="/img/control_remove16.png"
                rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ||customIdentity.hasRole('EH')}" >

                <rich:panelMenuGroup label="${'#'}{messages.version}" leftCollapsedIcon="/img/comment_play16.png" leftIcon="/img/New16.png" leftIconClass="pic" 
                     style="width:${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? '30px;': ';'}">
                    <rich:panelMenuItem label="${'#'}{messages['dashboard']}" 
			     action="/MyDashboard.xhtml" leftIcon="/img/List16.png">
                     </rich:panelMenuItem>
                </rich:panelMenuGroup>

                <rich:panelMenuGroup label="${'#'}{messages['${customerEntityName?substring(eL)?cap_first}']}"  leftCollapsedIcon="/img/Customer16.png" leftIcon="/img/New16.png" leftIconClass="pic"
                     style="width:${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? '30px;': ';'}">

                    <rich:panelMenuItem label="${'#'}{messages['call']} ${'#'}{messages['list']}" 
			     action="/${customerEntityName?substring(eL)}List.xhtml" leftIcon="/img/List16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['to']} ${'#'}{messages['call']}" 
			     action="/${customerEntityName?substring(eL)}Fcal.xhtml" leftIcon="/img/telephone16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['load_sales_data']}" 
			     action="/${usagebyperiodsEntityName?substring(eL)}List.xhtml" leftIcon="/img/database_refresh16.png">
                     </rich:panelMenuItem>


                    <rich:panelMenuItem label="${'#'}{messages['sales_data_report']}" 
			     action="/${usagebyperiodsEntityName?substring(eL)}Report.xhtml" leftIcon="/img/chart_bar16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['menutab.Mailings']}" 
			     action="/${customerEntityName?substring(eL)}MailingSend.xhtml" leftIcon="/img/ComposeMail16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['${cuordersEntityName?substring(eL)?cap_first}']}" 
			     action="/${cuordersEntityName?substring(eL)}Edit.xhtml" leftIcon="/img/Cuorders16.png">
                     </rich:panelMenuItem>

                </rich:panelMenuGroup>

                <rich:panelMenuGroup label="${'#'}{messages['${vendorEntityName?substring(eL)?cap_first}']}"  leftCollapsedIcon="/img/Vendor16.png" leftIcon="/img/New16.png" leftIconClass="pic"                                      style="width:${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? '30px;': ';'}">

                    <rich:panelMenuItem label="${'#'}{messages['menutab.AddListReport.ListL1']}" 
			     action="/${vendorEntityName?substring(eL)}List.xhtml" leftIcon="/img/List16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['menutab.Mailings']}" 
			     action="/${vendorEntityName?substring(eL)}MailingSend.xhtml" leftIcon="/img/ComposeMail16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['${vendordersEntityName?substring(eL)?cap_first}']}" 
			     action="/${vendordersEntityName?substring(eL)}Edit.xhtml" leftIcon="/img/Vendorders16.png">
                     </rich:panelMenuItem>

                </rich:panelMenuGroup>

                <rich:panelMenuGroup label="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? 'I': messages['${itemEntityName?substring(eL)?cap_first}']}"  leftCollapsedIcon="/img/Item16.png" leftIcon="/img/New16.png" leftIconClass="pic"                      style="width:${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? '30px;': ';'}">

                    <rich:panelMenuItem label="${'#'}{messages['menutab.AddListReport.ListL1']}" 
			     action="/${itemEntityName}List.xhtml" leftIcon="/img/List16.png">
                     </rich:panelMenuItem>

                    <rich:panelMenuItem label="${'#'}{messages['Vendorders']}" 
			     action="/${vendordersEntityName?substring(eL)}Edit.xhtml" leftIcon="/img/Vendorders16.png">
                     </rich:panelMenuItem>


                </rich:panelMenuGroup>

           

                    <rich:panelMenuItem label="${'#'}{ messages['MyCalendar']}" 
			     action="/${scheduleEntityName?substring(eL)}Fcal.xhtml" leftIcon="/img/calendar_view_day16.png" leftIconClass="pic"                      style="width:${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? '30px;': ';'}">

                    </rich:panelMenuItem>


                    <rich:panelMenuItem label="${'#'}{ messages.MyTasks}" 
			     action="/${emplordersEntityName?substring(eL)}FcalOrd.xhtml" leftIcon="/img/calendar_view_day16.png" leftIconClass="pic"                      style="width:${'#'}{yxxxuh566xwwqqwxxxxxuserHome.mobile ? '30px;': ';'}">

                    </rich:panelMenuItem>


<#-- jay below this put navigation drop down list ie copy from edit.xhtml.ftl but show as vertical not horizontal
-->



            </rich:panelMenu>

	</h:form>
</ui:composition>

</#if>




