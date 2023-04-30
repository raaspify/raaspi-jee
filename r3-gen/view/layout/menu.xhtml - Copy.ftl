<#assign tobegeneratedCandidate = "N">  
<#include "../assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#include "../assigns/mergedassigns.properties" >
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#include "../assigns/mergedassigns.properties" >
<#-- 56 (User) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#if (menuAttributes?substring(efS,efE) == '56') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<#assign appaccounting = "${appaccounting}">  
<#assign extendedName="UnKnown">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
        xmlns:fn="http://java.sun.com/jsp/jstl/functions"
        xmlns:p="http://primefaces.org/ui">

 <style>
  .ui-widget,
  .ui-widget .ui-widget {
    font-size: 16px !important;
  }
	</style>

	<h:form>
<#--
menu tool bar
 QuickStart                                   Products 
  Shopping_items or Issue                      Item
  Image                                        Image
  Logout                                       Product-1
                                                Product_1 blob
                                                Product_1 clob
-->

               <ui:remove> menu for addon added,1st for es(stock) 2nd for ec(ecommerce), ol(seat layout) and oe(event ticket) (  
               </ui:remove>
		<p:menubar style="height:${'#'}{skinBean.menuFontSize}" rendered="${'#'}{(identity.loggedIn)
                        or (!identity.loggedIn and (yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MENU-C','TXT',0,1200) == null or yxxxuq1m1xwwqqqxxxxxclobdataHome.getClobdata('clobdata','A3R-MENU-C','TXT',0,1200).length() == 0))}">
			<p:submenu hideDelay="800"  label="${'#'}{messages['menutab.QuickStart']}" mode="ajax" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">

				<f:facet name="label"> 
					<h:panelGroup id="qsp">
						<h:graphicImage value="/img/QuickStart16.png" styleClass="pic" rendered="${'#'}{skinBean.iconShown}"/>
						<h:outputText  style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;" value="${'#'}{messages['menutab.QuickStart']}"/>
					</h:panelGroup>
				</f:facet>
                                <ui:remove> master site has client 02 to hold rest key,but show the menu under shopping items for non mastersite ie tenant sites</ui:remove>

				<p:menuitem mode="ajax" value="${'#'}{messages.Sync} ${'#'}{messages.Shopify} ${'#'}{messages.data}" 
                                  rendered="${'#'}{!(customIdentity.masterSite) and not empty ${clientEntityName}List.getKeyToEntity('02',customIdentity.owner2) and not empty ${clientEntityName}List.getKeyToEntity('02',customIdentity.owner2).dbxxuzxdssxxxxxxxxxxapiclientsecret and !skinBean.iconShown}"
					outcome="/syncData.xhtml?faces-redirect=true"   />
				<p:menuitem mode="ajax" value="${'#'}{messages.Sync} ${'#'}{messages.Shopify} ${'#'}{messages.data}" 
                                  rendered="${'#'}{!(customIdentity.masterSite) and not empty ${clientEntityName}List.getKeyToEntity('02',customIdentity.owner2) and not empty ${clientEntityName}List.getKeyToEntity('02',customIdentity.owner2).dbxxuzxdssxxxxxxxxxxapiclientsecret and identity.loggedIn and skinBean.iconShown}"
					outcome="/syncData.xhtml?faces-redirect=true}" icon="/img/arrow_right16.png"  iconClass="pic"  />

				<p:menuitem mode="ajax" value="${'#'}{messages.Shopping_Items}" 
                                  rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.itemBrowseList and skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"
					outcome="/ItemDetailsBrowse.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Shopping_Items}" 
                                  rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.itemBrowseList and !skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"
					outcome="/ItemDetailsBrowse.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages['Issue_Bug']}" rendered="${'#'}{(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.issueBrowseList and skinBean.iconShown}"
					outcome="/IssuesBrowse.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages['Issue_Bug']}" rendered="${'#'}{(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.issueBrowseList and !skinBean.iconShown}"
					outcome="/IssuesBrowse.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Find_sponsors}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa' and not empty fpxxfq1a5xwwqqhxxxxxitemList.itemDetailsFeesList) and (!identity.loggedIn or (identity.loggedIn and !customIdentity.hasRole('PH')  )) and skinBean.iconShown}"
					outcome="/ItemsGetQuote.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Find_sponsors}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa' and not empty fpxxfq1a5xwwqqhxxxxxitemList.itemDetailsFeesList) and (!identity.loggedIn or (identity.loggedIn and !customIdentity.hasRole('PH')  )) and !skinBean.iconShown}"
					outcome="/ItemsGetQuote.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Select_sponsor_offers}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa' and ${itemEntityName}List.itemSearchByParameterList !=null  and not empty fpxxfq1a5xwwqqhxxxxxitemList.itemSearchByParameterList) and (identity.loggedIn and !customIdentity.hasRole('PH') ) and skinBean.iconShown}"
					outcome="/ItemsPaidSelect.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Select_sponsor_offers}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa' and ${itemEntityName}List.itemSearchByParameterList !=null  and not empty fpxxfq1a5xwwqqhxxxxxitemList.itemSearchByParameterList) and (identity.loggedIn and !customIdentity.hasRole('PH') ) and !skinBean.iconShown}"
					outcome="/ItemsPaidSelect.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Submit_case}" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.reviewBrowseList !=null  and not empty fpxxfq1a5xwwqqhxxxxxitemList.reviewBrowseList and skinBean.iconShown}"
					outcome="/ItemsReviewSelect.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Submit_case}" rendered="${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.reviewBrowseList !=null  and not empty fpxxfq1a5xwwqqhxxxxxitemList.reviewBrowseList and !skinBean.iconShown}"
					outcome="/ItemsReviewSelect.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Check_submission_status}" rendered="${'#'}{not empty ${itemEntityName}List.getBasketedList('basket') and identity.loggedIn and (customIdentity.hasRole('VH') or customIdentity.hasRole('PH')) and skinBean.iconShown}"
					outcome="/cbasketin.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Check_submission_status}" rendered="${'#'}{not empty ${itemEntityName}List.getBasketedList('basket') and identity.loggedIn and (customIdentity.hasRole('VH') or customIdentity.hasRole('PH')) and !skinBean.iconShown}"
					outcome="/cbasketin.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Check_case_submission_status}" rendered="${'#'}{not empty ${itemEntityName}List.getBasketedList('basketCI') and identity.loggedIn and (customIdentity.hasRole('VH') or customIdentity.hasRole('PH')) and skinBean.iconShown}"
					outcome="/cbasketinCase.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Check_case_submission_status}" rendered="${'#'}{not empty ${itemEntityName}List.getBasketedList('basketCI') and identity.loggedIn and (customIdentity.hasRole('VH') or customIdentity.hasRole('PH')) and !skinBean.iconShown}"
					outcome="/cbasketinCase.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Check_submission_status}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa') and not empty ${itemEntityName}List.getManagerApprovedRejectedCartedList('basket') and identity.loggedIn and customIdentity.hasRole('PH') and skinBean.iconShown}"
					outcome="/vbasketin.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Check_submission_status}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa') and not empty ${itemEntityName}List.getManagerApprovedRejectedCartedList('basket') and identity.loggedIn and customIdentity.hasRole('PH') and !skinBean.iconShown}"
					outcome="/vbasketin.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Check_waiting_approval}" rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemList.getEmployeeApprovedRejectedCartedListCI('basket') and identity.loggedIn and customIdentity.hasRole('UH') and skinBean.iconShown}"
					outcome="/mbasketin.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Check_waiting_approval}" rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemList.getEmployeeApprovedRejectedCartedListCI('basket') and identity.loggedIn and customIdentity.hasRole('UH') and !skinBean.iconShown}"
					outcome="/mbasketin.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Check_submission_status}" rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemList.getCustomerRequestedAndUpCartedListCI('basket') and identity.loggedIn and (customIdentity.hasRole('UH') or customIdentity.hasRole('UM') or customIdentity.hasRole('UQ')) and skinBean.iconShown}"
					outcome="/ebasketin.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Check_submission_status}" rendered="${'#'}{not empty fpxxfq1a5xwwqqhxxxxxitemList.getCustomerRequestedAndUpCartedListCI('basket') and identity.loggedIn and (customIdentity.hasRole('UH') or customIdentity.hasRole('UM') or customIdentity.hasRole('UQ')) and !skinBean.iconShown}"
					outcome="/ebasketin.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Check_waiting_recommendation}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa') and not empty ${itemEntityName}List.getCustomerRequestedAndUpCartedList('basket') and identity.loggedIn and customIdentity.hasRole('UH') and skinBean.iconShown}"
					outcome="/basketin.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Check_waiting_recommendation}" rendered="${'#'}{(fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].${clientProdcode},0,2)=='sa') and not empty fpxxfq1a5xwwqqhxxxxxitemList.getCustomerRequestedAndUpCartedList('basket') and identity.loggedIn and customIdentity.hasRole('UH') and !skinBean.iconShown}"
					outcome="/basketin.xhtml?faces-redirect=true"   />
				<p:menuitem mode="ajax" value="${'#'}{messages.Browse_Picture} " 
                                 rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.imageBrowseList and skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'}"
					outcome="/ImagesBrowse.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Browse_Picture}" 
                                   rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.imageBrowseList and !skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'}"
					outcome="/ImagesBrowse.xhtml?faces-redirect=true"   />
				<p:menuitem mode="ajax" value="${'#'}{messages.Browse_Blog} " 
                                 rendered="${'#'}{not empty ${itemEntityName}List.blogBrowseList and skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'}"
					outcome="/BlogDetailsBrowse.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Browse_Blog}"
                                 rendered="${'#'}{not empty ${itemEntityName}List.blogBrowseList and !skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'}"
					outcome="/BlogDetailsBrowse.xhtml?faces-redirect=true"   />
				<p:menuitem mode="ajax" value="${'#'}{messages.Manage} ${'#'}{messages.themes}" rendered="${'#'}{(customIdentity.masterSite) and identity.loggedIn and (customIdentity.hasRole('PH') || customIdentity.hasRole('UH'))  and skinBean.iconShown}"
					outcome="/ThemesBrowse.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Manage} ${'#'}{messages.themes}" rendered="${'#'}{(customIdentity.masterSite) and identity.loggedIn and (customIdentity.hasRole('PH') || customIdentity.hasRole('UH')) and !skinBean.iconShown}"
					outcome="/ThemesBrowse.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Upload} ${'#'}{messages.photos} ${'#'}{messages.to} ${'#'}{messages.shared} ${'#'}{messages.gallery}" rendered="${'#'}{(customIdentity.masterSite) and identity.loggedIn and customIdentity.hasRole('PH') and skinBean.iconShown}"
					outcome="/blobdataEditEasy.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Upload} ${'#'}{messages.photos} ${'#'}{messages.to} ${'#'}{messages.shared} ${'#'}{messages.gallery}" rendered="${'#'}{(customIdentity.masterSite) and identity.loggedIn and customIdentity.hasRole('PH') and !skinBean.iconShown}"
					outcome="/blobdataEditEasy.xhtml?faces-redirect=true"   />
                                <ui:remove>nov04 2020 if not logged these menuitems are not used any more.Home-Ui or Home-s have their own menu</ui:remove>
				<p:menuitem mode="ajax" value="${'#'}{messages.Available} ${'#'}{messages.themes}" rendered="${'#'}{(customIdentity.masterSite) and !identity.loggedIn and skinBean.iconShown}"
					outcome="/themeCDtlsBrowse.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Available} ${'#'}{messages.themes}" rendered="${'#'}{(customIdentity.masterSite) and !identity.loggedIn and !skinBean.iconShown}"
					outcome="/themeCDtlsBrowse.xhtml?faces-redirect=true"   />




				<p:menuitem mode="ajax" value="${'#'}{messages['menutab.AddListReport.LogIn']}"
					outcome="/login.xhtml?faces-redirect=true" icon="/img/LogIn16.png" iconClass="pic" rendered="${'#'}{not identity.loggedIn and skinBean.iconShown}" />
				<p:menuitem mode="ajax" value="${'#'}{messages['menutab.AddListReport.LogIn']}"
					outcome="/login.xhtml?faces-redirect=true"  rendered="${'#'}{not identity.loggedIn and !skinBean.iconShown}" />

				<p:menuitem mode="ajax"  icon="/img/LogOut16.png" rendered="${'#'}{identity.loggedIn and skinBean.iconShown}"
                                 id="Logoutic" action="${'#'}{customIdentity.logout()}">
                                  <h:commandButton value="${'#'}{messages['Logout']}" onclick="if (! confirm('Logout ?') ) { return false;}; return true; " />
			       </p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{identity.loggedIn and !skinBean.iconShown}"
                                  id="Logout" action="${'#'}{customIdentity.logout()}"> 
                                 <h:commandButton value="${'#'}{messages['Logout']}" onclick="if (! confirm('Logout ?') ) { return false;}; return true; " />
			      </p:menuitem>

                     <p:menuitem mode="ajax" value="${'#'}{messages['QuickStartFlow']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')) and identity.loggedIn and skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/Quick.xhtml?faces-redirect=true" icon="/img/QuickStartFlow16.png">
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['QuickStartFlow']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and !skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/Quick.xhtml?faces-redirect=true" >
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['QuickFinancial']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/QuickFinancial.xhtml?faces-redirect=true" icon="/img/QuickFinancial16.png">
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['QuickFinancial']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and !skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/QuickFinancial.xhtml?faces-redirect=true" >
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['MyDashboard']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and skinBean.iconShown}"
					outcome="/MyDashboard.xhtml?faces-redirect=true" icon="/img/Clobdata16.png">
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['MyDashboard']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and !skinBean.iconShown}"
					outcome="/MyDashboard.xhtml?faces-redirect=true" >
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['StockCount']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and !skinBean.iconShown
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)=='es'}"
					outcome="/countAlias.xhtml?faces-redirect=true" >
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['ItemCount']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and !skinBean.iconShown
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)=='es'}"
					outcome="/countItem.xhtml?faces-redirect=true" >
			     </p:menuitem>
                     <p:menuitem mode="ajax" value="${'#'}{messages['Seat']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ'))and identity.loggedIn  and !skinBean.iconShown
                                     and (fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)=='ol'
                                          or fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)=='oe') }"
					outcome="/seatList.xhtml?faces-redirect=true" >
			     </p:menuitem>

			</p:submenu>

			<p:submenu hideDelay="800"  label="${'#'}{messages['menutab.Products']}"
                          rendered="${'#'}{(!identity.loggedIn  || customIdentity.hasRole('VW')) and (not empty ${clobdataEntityName}Home.getClobdata('clobdata','A3R-PRODUCT-1-C','TXT',0,1200) )
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'}"
                             style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} " >
				<f:facet name="label"> 
					<h:panelGroup>
						<h:outputText value="${'#'}{messages['menutab.Products']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
<#-- not sure why home.xhtml has to be refreshed to ger rendered working -->
				<p:menuitem mode="ajax" value="${'#'}{messages['Browse_Item']}" 
                                 rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.itemBrowseList and skinBean.iconShown}"
					outcome="/ItemDetailsBrowse.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages['browse_Item']}" rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.itemBrowseList and !skinBean.iconShown}"
					outcome="/ItemDetailsBrowse.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages['Browse_Issue']}" rendered="${'#'}{(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.issueBrowseList and skinBean.iconShown}"
					outcome="/IssuesBrowse.xhtml?faces-redirect=true" icon="/img/Item16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages['browse_Issue']}" rendered="${'#'}{(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.issueBrowseList and !skinBean.iconShown}"
					outcome="/IssuesBrowse.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax" value="${'#'}{messages.Browse_Picture}" rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.imageBrowseList and skinBean.iconShown}"
					outcome="/ImagesBrowse.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Browse_Picture}" rendered="${'#'}{!(fn:substring(${clientEntityName}List.getSuggestList('01')[0].${clientProdcode},0,2)=='fb') and not empty ${itemEntityName}List.imageBrowseList and !skinBean.iconShown}"
					outcome="/ImagesBrowse.xhtml?faces-redirect=true"   />

				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-PRODUCT-1-C','TXT',0,1200) !=null) and skinBean.iconShown}"
					outcome="/Product-1.xhtml?faces-redirect=true" icon="/img/Package16.png" iconClass="pic"  >
                                        <h:outputText escape="false" value="${'#'}{messages['Products_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  
                                  rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-PRODUCT-1-C','TXT',0,1200) !=null) and !skinBean.iconShown}"
					outcome="/Product-1.xhtml?faces-redirect=true"   >
                                        <h:outputText escape="false" value="${'#'}{messages['Products_1']}" />
				</p:menuitem>
			</p:submenu>

			<p:submenu hideDelay="800" label="${'#'}{messages['menutab.News']}" 
                         rendered="${'#'}{(!identity.loggedIn  || customIdentity.hasRole('VW')) and (not empty ${clobdataEntityName}Home.getClobdata('clobdata','A3R-NEWS-1-C','TXT',0,1200) ) 
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'}"
                          style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">

				<f:facet name="label"> 
					<h:panelGroup>
						<h:outputText value="${'#'}{messages['menutab.News']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-NEWS-1-C','TXT',0,1200) !=null) and skinBean.iconShown}"
					outcome="/News-1.xhtml?faces-redirect=true" icon="/img/News16.png" iconClass="pic"  >
                             <h:outputText escape="false" value="${'#'}{messages['News_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-NEWS-1-C','TXT',0,1200) !=null) and !skinBean.iconShown}"
					outcome="/News-1.xhtml?faces-redirect=true"   >
                             <h:outputText escape="false" value="${'#'}{messages['News_1']}" />
				</p:menuitem>
			</p:submenu>


			<p:submenu hideDelay="800" label="${'#'}{messages['menutab.Calendar']}"  rendered="${'#'}{(!identity.loggedIn || customIdentity.hasRole('VW')) and ${scheduleEntityName}List.nextSchedule('FP') !=null }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">

				<f:facet name="label"> 
					<h:panelGroup>
						<h:outputText label="${'#'}{messages['menutab.Calendar']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
      <#-- 52/client shows filtered calendar ie type fp for public/visitors -->
				<p:menuitem mode="ajax" value="${'#'}{messages['Events']}" 
					outcome="/${clientEntityName?substring(eL)}Fcal.xhtml?faces-redirect=true" icon="/img/calendar_view_day16.png" iconClass="pic">
				</p:menuitem>
			</p:submenu>



			<p:submenu hideDelay="800" label="${'#'}{messages['menutab.About']}"  rendered="${'#'}{(!identity.loggedIn  || customIdentity.hasRole('VW')) and (not empty ${clobdataEntityName}Home.getClobdata('clobdata','A3R-ABOUT-1-C','TXT',0,1200) ) }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">

				<f:facet name="label"> 
					<h:panelGroup>
						<h:outputText value="${'#'}{messages['menutab.About']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-ABOUT-1-C','TXT',0,1200) !=null) and skinBean.iconShown}"
					outcome="/About-1.xhtml?faces-redirect=true" icon="/img/About16.png" iconClass="pic"  >
                             <h:outputText escape="false" value="${'#'}{messages['About_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-ABOUT-1-C','TXT',0,1200) !=null) and !skinBean.iconShown}"
					outcome="/About-1.xhtml?faces-redirect=true"   >
                             <h:outputText escape="false" value="${'#'}{messages['About_1']}" />
				</p:menuitem>
			</p:submenu>

			<p:submenu hideDelay="800"  label="${'#'}{messages['menutab.Resellers']}"  rendered="${'#'}{(!identity.loggedIn  || customIdentity.hasRole('VW')) and (not empty ${clobdataEntityName}Home.getClobdata('clobdata','A3R-RESELLERS-1-C','TXT',0,1200) ) }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">

				<f:facet name="label"> 
					<h:panelGroup>
						<h:outputText value="${'#'}{messages['menutab.Resellers']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-RESELLERS-1-C','TXT',0,1200) !=null) and skinBean.iconShown}"
					outcome="/Resellers-1.xhtml?faces-redirect=true" icon="/img/Vendor16.png" iconClass="pic"  >
                             <h:outputText escape="false" value="${'#'}{messages['Resellers_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-RESELLERS-1-C','TXT',0,1200) !=null) and !skinBean.iconShown}"
					outcome="/Resellers-1.xhtml?faces-redirect=true"   >
                             <h:outputText escape="false" value="${'#'}{messages['Resellers_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  rendered="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-RESELLERS-1-C','TXT',0,1200) !=null and skinBean.iconShown}"
					outcome="/ResellerReference.xhtml?faces-redirect=true" icon="/img/News16.png" iconClass="pic"  >
                             <h:outputText  value="${'#'}{messages['reseller']} ${'#'}{messages['reference']} ${'#'}{messages['manual']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  rendered="${'#'}{${clobdataEntityName}Home.getClobdata('clobdata','A3R-RESELLERS-1-C','TXT',0,1200) !=null and !skinBean.iconShown}"
					outcome="/ResellerReference.xhtml?faces-redirect=true"   >
                             <h:outputText  value="${'#'}{messages['Reseller']} ${'#'}{messages['reference']} ${'#'}{messages['manual']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  value="${'#'}{messages['Reseller']} ${'#'}{messages['Signup']}" rendered="${'#'}{skinBean.iconShown}"
					outcome="/vensignup.xhtml?faces-redirect=true" icon="/img/LogIn16.png" iconClass="pic"  >
				</p:menuitem>

				<p:menuitem mode="ajax"  value="${'#'}{messages['Reseller']} ${'#'}{messages['Signup']}" rendered="${'#'}{!skinBean.iconShown}"
					outcome="/vensignup.xhtml?faces-redirect=true"   >
				</p:menuitem>

			</p:submenu>



<#-- Maim menue and drop down menue items allows various actions like Add,List,transaction etc against each entity 
     Each entity name has attribute characters to indicate which actions are allowed for it.
     GenX value is set to 1 or true if there is at least one entity which allows action X.
     This avoids creating a menu but no entries under it,in case none of the entities allow that action
     toRenderXRoleYZ value is set to 1 or true if for action X, that entity allows action for user type Y and
     Role Z. 
     If an action is allways be there then we can bypass the above checking example action ALR
     GenA refers to Add and GenAB refers to Add (Others) 
     Feb 2014 update- app type ie product was added to extend whether to show a menu if X-Common ie show it for any product
     E-Erp app only O-Organization only B-Erp and Org only etc. This is in addition to User type and Role.
     For example entity machine will have E but item will have X at postion 15 (starting at 0) of the entity name
     postion 16 for sub products
     pos 0  4        5         10   11     12   13      14    15      16       17
            Role     Add Level List Report Tran Mailing Maint Product Sub Prod Size 
           Product               SubProduct  (all lowercases)
            Business e            Ecommerce         e ee
                                  Manufacturing     f ef
                                  Material Mgmt     m em future
                                  Supply Chain      c ec future
                                  Master site       g eg cloud Admin site (stats as ee, sqladmin can change to eg )

            Association o         Association       a oa                                 
                                  Club              c oc
                                  Show              s os future
                                  Conf              f of future 
            Service     s         Consulting        c sc
                                  Agency            a sa
                                  Software Dev      g sg future
            Users Forum f         Social Sharing    s fs
                                  Issues/Bugs       b fb    
                                  Blog              l fl future      
      may23 2018 there is logic for virtual products meant for a combination of multiple products
                 example Product b which means product e and 0. So if entity product say b rules for both e and o will apply  



     
     Mar update-size flag at position 17 was introduced to control showing in menu. as the company size changes this flag
     can be changed. s-small m-medium l large for example company,division or department may not apply to small company
--   below copied from createfi and used for Entity
--     pos0 0-3  4        5     6 7 8   9      10   11     12   13      14    15      16       17
--     pos1 1-4  5        6     7-8 9   10     11   12     13   14      15    16      17       18    19-20 
--     Menu      Role     Add   Fn  pos Future List Report Tran Mailing Maint Product Sub Prod Size  future  
--               Lowest   Level     in         Lvl  Lvl    Lvl  Lvl     Lvl   [x-show for all
--                                  group                                      pss- show for prod/sub
--                                  x-hide                                     /size only         ]  
--     Menu - Entity to show under 
--     pos1-  A-Add              S-Administration  Z-web service       
--     (1-4)                                                               
--            L-List             B-Label                                          
--            T-Transaction      P-Messaging
--            G-Graphs           Y-Maintenance   
--            N-Generate         E-Master O-Details(hidden from menu) 
--            R-Report           x-Skip           
--            M-Mailing          V-Custom/Future                  
--            C-Add & List, D-Add,List & Report, F-ALRB J-ALRBM Z-? digits in pos 1-4 ?
--            unused characters are H,I,K,Q,U,W          
--     Roles pos 5                                            
--     U (B)(C)      Back office user need to be employee. () means superset ie B will include U and I
--                   U can have restrict1 as D* meaning Demo user UH (like manager) but can update *own records only
--                    and email as logon id. Activated by link to demo site like act
--     I (B)         Admin user (Human Resources creates user) B means U and I C ??
--     K             Support need to look into logs
--     E             Data Access/Repair need temp access. Any changes are logged (to be done) into editlog
--     S (C)         Admin system (Client, options, message file access)
--     *limitation
--     V* (U)(I)    Front office Visitor/Guest can browse access entities like Item without logging,jay add logic to add to cart as visitor
--                   if demographic info and email and address is provided like pizza delivery         
--                    need to be customer,vendor and logged in to do updates and txns for own records like *user except Roles fields,userprofl
--     F (UQ*)(V)    Visitor for Forum products ie items can be added and own user record except for Roles fields can be maintained
--     Note          Even though a user does not have add or update access, system can do the update via bean method example Sqladmin
                     U,I,K,E,S,V,B-UI,C-US,D-UE(Roles User,Admin User,Support,Data Access/Repair,
                     Admin System,Visitor/Guest)
--                   special front end menue like shpping cart.   
--     what are B,C  - they are meant for small/med size since one or two parsons does all company, for large size B,C will give warning 
--     Level H-High can add most entries
--     pos 6 Q-Medium can add some entries
--           W-Low can add very specific entities, also cannot list or report customer,vendor or employee
--
--     prod/sub prod
--     ERP    -e e Ecommerce
--             e   Manufacturing
--             e h Materials Mgmt
--             e c Supply Chain
--     ORG     o c Club
--             o a Association
--             o s Show
--             o f Conf
               o s Sharing group like facebook
--     Forum   f b Bug Reporting
--             f l blog
--     Service s a Agency
--             s c Consulting
--
--     Size    L large M Medium S Small

-->
<#-- The above described process as executed below merely establishes which menue and sub menues will be built
     based on flags or attributes which are part of each entity name and are in r3-gen.reveng.xml. 
     Actual menue is built further down and uses rendered attribute to make it dynamic based on who is looged in
     and what application type. Each page has the menu.xhtml and the rendered ajax logic is executed before 
     the menu entries and the rest of the jsf page is shown on the browser.
     rendered="#{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')|| xxxx}" means the menue entry will be shown only if the 
     logon id is a back office user with high or medium role.
     whether to show the menue for UH or UQ was established earlier ie if toRenderXRoleUH and toRenderXRoleUQ value was 1 for the
     entity.
     Similar logic is used for product and subProduct and pRenderString is used like
     pRenderString= and (customIdentity.product == '${toGenForProduct}') and (customIdentity.subProduct == '${toGenForSubProduct}') meaning menu will be shown for this Product and subProduct
     to handle situation like multipe products there is some incomplete logic to define virtual product say b which means e and o

     Level H-High can add most entries
           Q-Medium can add some entries
           W-Low can add very specific entities
     Roles                                             
     U back office user need to be employee
     I "     "     Admin user (Human Resources)
     K             Support need to look into logs
     E             Data Access/Repair need temp access
     S             Admin system (Client, options, message file access)
     V Front office Visitor/Guest can browse access entities like Item without logging,
                     need to be customer,vendor and logged in to do updates and txns except if product is os then a visitor can add/update
                     their own items. Any user can update their own user record
     Note Even though a user does not have add or update access, system can do the update via
          special front end menue like shopping cart.   

     

      
-->


                <#assign toGenALR=0>  
                <#assign toGenA=0>  
                <#assign toGenAB=0>  
                <#assign toGenL=0>  
                <#assign toGenLB=0>  
                <#assign toGenR=0>  
                <#assign toGenRB=0>  
                <#assign toGenT=0>  
                <#assign toGenTA=0>  
                <#assign toGenTL=0>  
                <#assign toGenM=0>  
                <#assign toGenY=0>  
                <#assign toGenN=0>  
                <#assign toGenTools=1>  
                <#assign toGenForProduct="">  
                <#assign pRenderString="">  
                <#-- b means prod code e and o ie show for both product types --> 
                <#assign toGenForProductB1="e">  
                <#assign toGenForProductB2="o">  
                <#assign toGenForProductB3="s">  
                <#assign toGenForProductB4="f">  
                <#assign toGenForSubProduct="">  
                <#assign toGenForSubProductB1="e">  
                <#assign toGenForSubProductB2="f">  
                <#assign toGenForSubProductB3="a">  
                <#assign toGenForSubProductB4="c">  
                <#assign toGenForSize="">  
                <#assign toRenderALRRoleU=0>  
                <#assign toRenderARoleUH=0>  
                <#assign toRenderARoleUQ=0>  
                <#assign toRenderARoleUL=0>  
                <#assign toRenderARoleUW=0>  
                <#assign toRenderARoleIH=0>  
                <#assign toRenderARoleIQ=0>  
                <#assign toRenderARoleIW=0> 
                <#assign toRenderARoleKH=0>  
                <#assign toRenderARoleKQ=0>  
                <#assign toRenderARoleKW=0>  
                <#assign toRenderARoleEH=0>  
                <#assign toRenderARoleEQ=0>  
                <#assign toRenderARoleEW=0>  
                <#assign toRenderARoleSH=0>  
                <#assign toRenderARoleSQ=0>  
                <#assign toRenderARoleSW=0>
                <#assign toRenderARoleBH=0>  
                <#assign toRenderARoleBQ=0>  
                <#assign toRenderARoleBW=0>  
                <#assign toRenderARoleCH=0>  
                <#assign toRenderARoleCQ=0>  
                <#assign toRenderARoleCW=0>  
                <#assign toRenderARoleDH=0>  
                <#assign toRenderARoleDQ=0>  
                <#assign toRenderARoleDW=0>  
                <#assign toRenderARoleFH=0>  
                <#assign toRenderARoleFQ=0>  
                <#assign toRenderARoleFW=0>  

                <#assign toRenderABRoleUH=0>  
                <#assign toRenderABRoleUQ=0>  
                <#assign toRenderABRoleUW=0>  
                <#assign toRenderABRoleIH=0>  
                <#assign toRenderABRoleIQ=0>  
                <#assign toRenderABRoleIW=0> 
                <#assign toRenderABRoleKH=0>  
                <#assign toRenderABRoleKQ=0>  
                <#assign toRenderABRoleKW=0>  
                <#assign toRenderABRoleEH=0>  
                <#assign toRenderABRoleEQ=0>  
                <#assign toRenderABRoleEW=0>  
                <#assign toRenderABRoleSH=0>  
                <#assign toRenderABRoleSQ=0>  
                <#assign toRenderABRoleSW=0>
                <#assign toRenderABRoleBH=0>  
                <#assign toRenderABRoleBQ=0>  
                <#assign toRenderABRoleBW=0>  
                <#assign toRenderABRoleCH=0>  
                <#assign toRenderABRoleCQ=0>  
                <#assign toRenderABRoleCW=0>  
                <#assign toRenderABRoleDH=0>  
                <#assign toRenderABRoleDQ=0>  
                <#assign toRenderABRoleDW=0>  

                <#assign toRenderLRoleUH=0>  
                <#assign toRenderLRoleUQ=0>  
                <#assign toRenderLRoleUL=0>  
                <#assign toRenderLRoleUW=0>  
                <#assign toRenderLRoleIH=0>  
                <#assign toRenderLRoleIQ=0>  
                <#assign toRenderLRoleIW=0> 
                <#assign toRenderLRoleKH=0>  
                <#assign toRenderLRoleKQ=0>  
                <#assign toRenderLRoleKW=0>  
                <#assign toRenderLRoleEH=0>  
                <#assign toRenderLRoleEQ=0>  
                <#assign toRenderLRoleEW=0>  
                <#assign toRenderLRoleSH=0>  
                <#assign toRenderLRoleSQ=0>  
                <#assign toRenderLRoleSW=0>
                <#assign toRenderLRoleBH=0>  
                <#assign toRenderLRoleBQ=0>  
                <#assign toRenderLRoleBW=0>  
                <#assign toRenderLRoleCH=0>  
                <#assign toRenderLRoleCQ=0>  
                <#assign toRenderLRoleCW=0>  
                <#assign toRenderLRoleDH=0>  
                <#assign toRenderLRoleDQ=0>  
                <#assign toRenderLRoleDW=0>  
                <#assign toRenderLRoleFH=0>  
                <#assign toRenderLRoleFQ=0>  
                <#assign toRenderLRoleFW=0>  

                <#assign toRenderLBRoleUH=0>  
                <#assign toRenderLBRoleUQ=0>  
                <#assign toRenderLBRoleUW=0>  
                <#assign toRenderLBRoleIH=0>  
                <#assign toRenderLBRoleIQ=0>  
                <#assign toRenderLBRoleIW=0> 
                <#assign toRenderLBRoleKH=0>  
                <#assign toRenderLBRoleKQ=0>  
                <#assign toRenderLBRoleKW=0>  
                <#assign toRenderLBRoleEH=0>  
                <#assign toRenderLBRoleEQ=0>  
                <#assign toRenderLBRoleEW=0>  
                <#assign toRenderLBRoleSH=0>  
                <#assign toRenderLBRoleSQ=0>  
                <#assign toRenderLBRoleSW=0>
                <#assign toRenderLBRoleBH=0>  
                <#assign toRenderLBRoleBQ=0>  
                <#assign toRenderLBRoleBW=0>  
                <#assign toRenderLBRoleCH=0>  
                <#assign toRenderLBRoleCQ=0>  
                <#assign toRenderLBRoleCW=0>  
                <#assign toRenderLBRoleDH=0>  
                <#assign toRenderLBRoleDQ=0>  
                <#assign toRenderLBRoleDW=0>  


                <#assign toRenderRRoleUH=0>  
                <#assign toRenderRRoleUQ=0>  
                <#assign toRenderRRoleUW=0>  
                <#assign toRenderRRoleIH=0>  
                <#assign toRenderRRoleIQ=0>  
                <#assign toRenderRRoleIW=0> 
                <#assign toRenderRRoleKH=0>  
                <#assign toRenderRRoleKQ=0>  
                <#assign toRenderRRoleKW=0>  
                <#assign toRenderRRoleEH=0>  
                <#assign toRenderRRoleEQ=0>  
                <#assign toRenderRRoleEW=0>  
                <#assign toRenderRRoleSH=0>  
                <#assign toRenderRRoleSQ=0>  
                <#assign toRenderRRoleSW=0>
                <#assign toRenderRRoleBH=0>  
                <#assign toRenderRRoleBQ=0>  
                <#assign toRenderRRoleBW=0>  
                <#assign toRenderRRoleCH=0>  
                <#assign toRenderRRoleCQ=0>  
                <#assign toRenderRRoleCW=0>  
                <#assign toRenderRRoleDH=0>  
                <#assign toRenderRRoleDQ=0>  
                <#assign toRenderRRoleDW=0>  
                <#assign toRenderRRoleFH=0>  
                <#assign toRenderRRoleFQ=0>  
                <#assign toRenderRRoleFW=0>  

                <#assign toRenderRBRoleUH=0>  
                <#assign toRenderRBRoleUQ=0>  
                <#assign toRenderRBRoleUW=0>  
                <#assign toRenderRBRoleIH=0>  
                <#assign toRenderRBRoleIQ=0>  
                <#assign toRenderRBRoleIW=0> 
                <#assign toRenderRBRoleKH=0>  
                <#assign toRenderRBRoleKQ=0>  
                <#assign toRenderRBRoleKW=0>  
                <#assign toRenderRBRoleEH=0>  
                <#assign toRenderRBRoleEQ=0>  
                <#assign toRenderRBRoleEW=0>  
                <#assign toRenderRBRoleSH=0>  
                <#assign toRenderRBRoleSQ=0>  
                <#assign toRenderRBRoleSW=0>
                <#assign toRenderRBRoleBH=0>  
                <#assign toRenderRBRoleBQ=0>  
                <#assign toRenderRBRoleBW=0>  
                <#assign toRenderRBRoleCH=0>  
                <#assign toRenderRBRoleCQ=0>  
                <#assign toRenderRBRoleCW=0>  
                <#assign toRenderRBRoleDH=0>  
                <#assign toRenderRBRoleDQ=0>  
                <#assign toRenderRBRoleDW=0>  

                <#assign toRenderTRoleUH=0>  
                <#assign toRenderTRoleUQ=0>  
                <#assign toRenderTRoleUW=0>  
                <#assign toRenderTRoleIH=0>  
                <#assign toRenderTRoleIQ=0>  
                <#assign toRenderTRoleIW=0> 
                <#assign toRenderTRoleKH=0>  
                <#assign toRenderTRoleKQ=0>  
                <#assign toRenderTRoleKW=0>  
                <#assign toRenderTRoleEH=0>  
                <#assign toRenderTRoleEQ=0>  
                <#assign toRenderTRoleEW=0>  
                <#assign toRenderTRoleSH=0>  
                <#assign toRenderTRoleSQ=0>  
                <#assign toRenderTRoleSW=0>
                <#assign toRenderTRoleBH=0>  
                <#assign toRenderTRoleBQ=0>  
                <#assign toRenderTRoleBW=0>  
                <#assign toRenderTRoleCH=0>  
                <#assign toRenderTRoleCQ=0>  
                <#assign toRenderTRoleCW=0>  
                <#assign toRenderTRoleDH=0>  
                <#assign toRenderTRoleDQ=0>  
                <#assign toRenderTRoleDW=0>  

                 <#-- transaction Add Role -->
                <#assign toRenderTARoleUH=0>  
                <#assign toRenderTARoleUQ=0>  
                <#assign toRenderTARoleUW=0>  
                <#assign toRenderTARoleIH=0>  
                <#assign toRenderTARoleIQ=0>  
                <#assign toRenderTARoleIW=0> 
                <#assign toRenderTARoleKH=0>  
                <#assign toRenderTARoleKQ=0>  
                <#assign toRenderTARoleKW=0>  
                <#assign toRenderTARoleEH=0>  
                <#assign toRenderTARoleEQ=0>  
                <#assign toRenderTARoleEW=0>  
                <#assign toRenderTARoleSH=0>  
                <#assign toRenderTARoleSQ=0>  
                <#assign toRenderTARoleSW=0>
                <#assign toRenderTARoleBH=0>  
                <#assign toRenderTARoleBQ=0>  
                <#assign toRenderTARoleBW=0>  
                <#assign toRenderTARoleCH=0>  
                <#assign toRenderTARoleCQ=0>  
                <#assign toRenderTARoleCW=0>  
                <#assign toRenderTARoleDH=0>  
                <#assign toRenderTARoleDQ=0>  
                <#assign toRenderTARoleDW=0>  


                <#-- transaction List Role -->

                <#assign toRenderTLRoleUH=0>  
                <#assign toRenderTLRoleUQ=0>  
                <#assign toRenderTLRoleUW=0>  
                <#assign toRenderTLRoleIH=0>  
                <#assign toRenderTLRoleIQ=0>  
                <#assign toRenderTLRoleIW=0> 
                <#assign toRenderTLRoleKH=0>  
                <#assign toRenderTLRoleKQ=0>  
                <#assign toRenderTLRoleKW=0>  
                <#assign toRenderTLRoleEH=0>  
                <#assign toRenderTLRoleEQ=0>  
                <#assign toRenderTLRoleEW=0>  
                <#assign toRenderTLRoleSH=0>  
                <#assign toRenderTLRoleSQ=0>  
                <#assign toRenderTLRoleSW=0>
                <#assign toRenderTLRoleBH=0>  
                <#assign toRenderTLRoleBQ=0>  
                <#assign toRenderTLRoleBW=0>  
                <#assign toRenderTLRoleCH=0>  
                <#assign toRenderTLRoleCQ=0>  
                <#assign toRenderTLRoleCW=0>  
                <#assign toRenderTLRoleDH=0>  
                <#assign toRenderTLRoleDQ=0>  
                <#assign toRenderTLRoleDW=0>  

                <#assign toRenderMRoleUH=0>  
                <#assign toRenderMRoleUQ=0>  
                <#assign toRenderMRoleUW=0>  
                <#assign toRenderMRoleIH=0>  
                <#assign toRenderMRoleIQ=0>  
                <#assign toRenderMRoleIW=0> 
                <#assign toRenderMRoleKH=0>  
                <#assign toRenderMRoleKQ=0>  
                <#assign toRenderMRoleKW=0>  
                <#assign toRenderMRoleEH=0>  
                <#assign toRenderMRoleEQ=0>  
                <#assign toRenderMRoleEW=0>  
                <#assign toRenderMRoleSH=0>  
                <#assign toRenderMRoleSQ=0>  
                <#assign toRenderMRoleSW=0>
                <#assign toRenderMRoleBH=0>  
                <#assign toRenderMRoleBQ=0>  
                <#assign toRenderMRoleBW=0>  
                <#assign toRenderMRoleCH=0>  
                <#assign toRenderMRoleCQ=0>  
                <#assign toRenderMRoleCW=0>  
                <#assign toRenderMRoleDH=0>  
                <#assign toRenderMRoleDQ=0>  
                <#assign toRenderMRoleDW=0>  

                <#assign toRenderYRoleUH=0>  
                <#assign toRenderYRoleUQ=0>  
                <#assign toRenderYRoleUW=0>  
                <#assign toRenderYRoleIH=0>  
                <#assign toRenderYRoleIQ=0>  
                <#assign toRenderYRoleIW=0> 
                <#assign toRenderYRoleKH=0>  
                <#assign toRenderYRoleKQ=0>  
                <#assign toRenderYRoleKW=0>  
                <#assign toRenderYRoleEH=0>  
                <#assign toRenderYRoleEQ=0>  
                <#assign toRenderYRoleEW=0>  
                <#assign toRenderYRoleSH=0>  
                <#assign toRenderYRoleSQ=0>  
                <#assign toRenderYRoleSW=0>
                <#assign toRenderYRoleBH=0>  
                <#assign toRenderYRoleBQ=0>  
                <#assign toRenderYRoleBW=0>  
                <#assign toRenderYRoleCH=0>  
                <#assign toRenderYRoleCQ=0>  
                <#assign toRenderYRoleCW=0>  
                <#assign toRenderYRoleDH=0>  
                <#assign toRenderYRoleDQ=0>  
                <#assign toRenderYRoleDW=0>  






<#-- All submenu render flags are set here --> 
                <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp11 = entity.shortName?substring(4,5)?upper_case>
                         <#assign menuAttributesp12 = entity.shortName?substring(5,6)?upper_case>
                         <#assign menuAttributesp22 = entity.shortName?substring(8,9)?upper_case>
                         <#assign menuAttributesp1L = entity.shortName?substring(10,11)?upper_case>  
                         <#assign menuAttributesp1R = entity.shortName?substring(11,12)?upper_case>  
                         <#assign menuAttributesp1T = entity.shortName?substring(12,13)?upper_case> 
                         <#assign menuAttributesp1M = entity.shortName?substring(13,14)?upper_case>       
                         <#assign menuAttributesp1I = entity.shortName?substring(14,15)?upper_case>  
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case>    
                         <#if menuAttributesp0?contains("A") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J") >
                          <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenA=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderARoleUH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleUQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleIH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleIQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleKH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleKQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleEH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleEQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleSH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleSQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleBH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleBQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleCH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleCQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleDH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleDQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleDW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("F") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderARoleFH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderARoleFQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderARoleFW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                          <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenAB=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleUH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleUQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleIH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleIQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleKH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleKQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleEH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleEQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleSH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleSQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleBH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleBQ=1>  
                              <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleCH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleCQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp12?contains("H") >
                              <#assign toRenderABRoleDH=1>  
                             <#elseif menuAttributesp12?contains("Q") >
                              <#assign toRenderABRoleDQ=1>  
                             <#elseif menuAttributesp12?contains("W") >
                              <#assign toRenderABRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                         </#if>
                         <#if menuAttributesp0?contains("L") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J") >
                          <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenL=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleUH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleUQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleIH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleIQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleKH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleKQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleEH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleEQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleSH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleSQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleBH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleBQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleCH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleCQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleDH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleDQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleDW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("F") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLRoleFH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLRoleFQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLRoleFW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                          <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenLB=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleUH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleUQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleIH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleIQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleKH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleKQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleEH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleEQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleSH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleSQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleBH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleBQ=1>  
                              <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleCH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleCQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1L?contains("H") >
                              <#assign toRenderLBRoleDH=1>  
                             <#elseif menuAttributesp1L?contains("Q") >
                              <#assign toRenderLBRoleDQ=1>  
                             <#elseif menuAttributesp1L?contains("W") >
                              <#assign toRenderLBRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                         </#if>
                         <#if menuAttributesp0?contains("R") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J") >
                          <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenR=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleUH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleUQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleIH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleIQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleKH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleKQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleEH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleEQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleSH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleSQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleBH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleBQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleCH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleCQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRRoleDH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRRoleDQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                          <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenRB=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleUH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleUQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleIH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleIQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleKH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleKQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleEH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleEQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleSH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleSQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleBH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleBQ=1>  
                              <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleCH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleCQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1R?contains("H") >
                              <#assign toRenderRBRoleDH=1>  
                             <#elseif menuAttributesp1R?contains("Q") >
                              <#assign toRenderRBRoleDQ=1>  
                             <#elseif menuAttributesp1R?contains("W") >
                              <#assign toRenderRBRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                         </#if>
                         <#if menuAttributesp0?contains("T") >
                          <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenT=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleUH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleUQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleIH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleIQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleKH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleKQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleEH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleEQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleSH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleSQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleBH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleBQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleCH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleCQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderTRoleDH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderTRoleDQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderTRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                          <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenTL=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleUH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleUQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleIH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleIQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleKH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleKQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleEH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleEQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleSH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleSQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleBH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleBQ=1>  
                              <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleCH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleCQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1T?contains("H") >
                              <#assign toRenderLBRoleDH=1>  
                             <#elseif menuAttributesp1T?contains("Q") >
                              <#assign toRenderLBRoleDQ=1>  
                             <#elseif menuAttributesp1T?contains("W") >
                              <#assign toRenderLBRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                         </#if>
                         <#if menuAttributesp0?contains("M") || menuAttributesp0?contains("J") || menuAttributesp0?contains("F") || menuAttributesp0?contains("B")>
                          <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenM=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleUH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleUQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleIH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleIQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleKH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleKQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleEH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleEQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleSH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleSQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleBH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleBQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleCH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleCQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderMRoleDH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderMRoleDQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderMRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                          <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#-- genMB ?? -->
                            <#assign toGenLB=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleUH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleUQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleIH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleIQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleKH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleKQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleEH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleEQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleSH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleSQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleBH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleBQ=1>  
                              <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleCH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleCQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1M?contains("H") >
                              <#assign toRenderLBRoleDH=1>  
                             <#elseif menuAttributesp1M?contains("Q") >
                              <#assign toRenderLBRoleDQ=1>  
                             <#elseif menuAttributesp1M?contains("W") >
                              <#assign toRenderLBRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                         </#if>
                         <#if menuAttributesp0?contains("Y") >
                          <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenY=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleUH=1>
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleUQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleIH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleIQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleKH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleKQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleEH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleEQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleSH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleSQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleBH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleBQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleCH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleCQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderYRoleDH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderYRoleDQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderYRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                          <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                           <#if menuAttributesp22?contains(j) >
                            <#assign toGenLB=1>  
                           </#if>
                           <#if menuAttributesp11?contains("U") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleUH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleUQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleUW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("I") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleIH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleIQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleIW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("K") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleKH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleKQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleKW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("E") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleEH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleEQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleEW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("S") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleSH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleSQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleSW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("B") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleBH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleBQ=1>  
                              <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleBW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("C") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleCH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleCQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleCW=1>  
                             </#if>
                           </#if>
                           <#if menuAttributesp11?contains("D") >
                             <#if menuAttributesp1I?contains("H") >
                              <#assign toRenderLBRoleDH=1>  
                             <#elseif menuAttributesp1I?contains("Q") >
                              <#assign toRenderLBRoleDQ=1>  
                             <#elseif menuAttributesp1I?contains("W") >
                              <#assign toRenderLBRoleDW=1>  
                             </#if>
                           </#if>
                          </#foreach> 
                         </#if>
                </#foreach>
<#-- End of All submenu render flags setting to prevent menu without menu item --> 
                <#if toGenA==1 || toGenL==1 || toGenR==1 || toGenAB==1 || toGenLB==1 || toGenRB==1 >
<#-- Add/List/Report Menu Group allways rendered -->
			 <p:submenu hideDelay="800" label="${'#'}{messages['menutab.AddListReport']}"
                              rendered="${'#'}{identity.loggedIn and !customIdentity.hasRole('VW') }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
			    <f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/AddListReport16.png" styleClass="pic"/>
						<h:outputText value="${'#'}{messages['menutab.AddListReport']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
			    </f:facet>
                    <#if toGenA==1 >
                      <#assign renderString="">
                      <#assign jrenderString="">
                      <#assign orString="||">
                      <#if toRenderARoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderARoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderARoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderARoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderARoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderARoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderARoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderARoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderARoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderARoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderARoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderARoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderARoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderARoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderARoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderARoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderARoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderARoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderARoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderARoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderARoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderARoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderARoleBQ=1>
                       <#if toRenderARoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderARoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderARoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderARoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderARoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderARoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderARoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderARoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderARoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderARoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderARoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderARoleFH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('PH')"+orString>
                      </#if>
                      <#if toRenderARoleFQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('PH')"+orString>
                      </#if>
                      <#if toRenderARoleFW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('PH')"+orString>
                      </#if>
<#-- Add Menu group rendered here -->
  				<p:submenu label="${'#'}{messages['menutab.AddListReport.AddL1']}" icon="/img/New16.png" iconClass="pic"
                      <#if renderString="">
                              rendered="false">
                      <#else>
                              rendered="${'#'}{${renderString[0..renderString?length-3]} }" >
                      </#if>                        
                      <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                       <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                        <#assign found=0>  
                        <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,6)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case> 
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                         </#if>
                         <#if menuAttributesFunction == "1A" || menuAttributesFunction == "40">
                         <#elseif menuAttributesFunction == "20">
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                         <#elseif menuAttributesFunction == "30">
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'">
                         <#else>
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                         </#if>
                         <#if (!menuAttributesp0?contains("T") && (menuAttributesp0?contains("A") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J"))) && menuAttributesFG == i && menuAttributesGP == j>
                          <#assign found=1>
<#-- Add for Customer etc has xtra menu item for with Address -->
                          <#if (menuAttributesFunction ="20" || menuAttributesFunction = "30"||menuAttributesFunction="40" ) >
                            <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("F") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW')
                               ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')
                               ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('VH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("T"))>
					  outcome="${entity.shortName}Add.address.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Add"/>
                            <#else>
					  outcome="/${entity.shortName?substring(eL)}Edit.address.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				      </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']} ${'#'}{messages['ExistingAddress']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("T") && !(menuAttributesp0?contains("B")))>
					  outcome="${entity.shortName}Add.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Add"/>
                            <#else>
					  outcome="/${entity.shortName?substring(eL)}Edit.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				       </p:menuitem>
<#-- Add but Non Customer/Vendor/Employee Entities -->
                          <#else>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("F") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||((customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW'))
                                ${pRenderString} and customIdentity.product =='f' and customIdentity.subProduct =='s')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||((customIdentity.hasRole('VH')||customIdentity.hasRole('VQ'))
                                ${pRenderString} and customIdentity.product =='f' and customIdentity.subProduct =='s')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('VH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("T") && !(menuAttributesp0?contains("B")) ) >
					  outcome="${entity.shortName}Add.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Add"/>
                            <#else>
					  outcome="/${entity.shortName?substring(eL)}Edit.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				      </p:menuitem>
                          </#if>
                         </#if>
                        </#foreach>
                       </#foreach>
                       <#if found != 0 && i != "A">
     				     <p:separator/>
                       </#if>
                      </#foreach>      
				</p:submenu>
                    </#if>

<#-- List -->
                    <#if toGenL==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderLRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderLRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderLRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderLRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderLRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderLRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderLRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderLRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderLRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderLRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderLRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderLRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderLRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderLRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderLRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderLRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderLRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderLRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderLRoleBQ=1>
                       <#if toRenderLRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderLRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderLRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderLRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderLRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderLRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderLRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderLRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderLRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderLRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderLRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderLRoleFH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('PH')"+orString>
                      </#if>
                      <#if toRenderLRoleFQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('PH')"+orString>
                      </#if>
                      <#if toRenderLRoleFW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('PH')"+orString>
                      </#if>
				<p:submenu label="${'#'}{messages['menutab.AddListReport.ListL1']}" icon="/img/List16.png" iconClass="pic"
                      <#if renderString="">
                              rendered="false">
                      <#else>
                              rendered="${'#'}{${renderString[0..renderString?length-3]} }" > 
                      </#if>                        
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(10,11)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case>
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                         </#if>
                         <#if menuAttributesFunction == "1A" || menuAttributesFunction == "40">
                         <#elseif menuAttributesFunction == "20">
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                         <#elseif menuAttributesFunction == "30">
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'">
                         <#else>
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                         </#if>
                          <#if (!menuAttributesp0?contains("T") && (menuAttributesp0?contains("L") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J"))) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("F") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('PH')
                               ||(customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW')
                                ${pRenderString}  and customIdentity.product =='f' and customIdentity.subProduct =='s')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('PH')||customIdentity.hasRole('VQ')
                               ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('VH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("F") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW')
                               ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')
                               ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('PH')||customIdentity.hasRole('VH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}List.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
				     </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>     
				</p:submenu>
                    </#if> 
<#-- Report -->
                    <#if toGenR==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderRRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderRRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderRRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderRRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderRRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderRRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderRRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderRRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderRRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderRRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderRRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderRRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderRRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderRRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderRRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderRRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderRRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderRRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderRRoleBQ=1>
                       <#if toRenderRRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderRRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderRRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderRRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderRRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderRRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderRRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderRRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderRRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderRRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderRRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderRRoleFH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                      </#if>
                      <#if toRenderRRoleFQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                      </#if>
                      <#if toRenderRRoleFW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('VH')"+orString>
                      </#if>
            	     <p:submenu label="${'#'}{messages['menutab.AddListReport.ReportL1']}" icon="/img/Report16.png" iconClass="pic"
                      <#if renderString="">
                              rendered="false">
                      <#else>
                              rendered="${'#'}{${renderString[0..renderString?length-3]} }" > 
                      </#if>                        
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(11,12)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case>
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                         <#if menuAttributesFunction == "1A" || menuAttributesFunction == "40">
                         <#elseif menuAttributesFunction == "20">
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                         <#elseif menuAttributesFunction == "30">
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'">
                         <#else>
                          <#assign pRenderString=pRenderString+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                         </#if>
                          <#if  !menuAttributesp0?contains("T") && ((menuAttributesp0?contains("R") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J")) && menuAttributesFG == i && menuAttributesGP == j)
                            && (menuAttributesFunction != "5B" )>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("F") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW')
                               ||customIdentity.hasRole('FH')||customIdentity.hasRole('FQ')||customIdentity.hasRole('FW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')
                               ||customIdentity.hasRole('FH')||customIdentity.hasRole('FQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('VH')||customIdentity.hasRole('FH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}Report.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
				   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				       <p:separator/>
                         </#if>
                        </#foreach>    
                         <#if appaccounting == 'y'>
                           <p:menuitem mode="ajax" value="${'#'}{messages['journalbyaccoun']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
					  outcome="/Reportjrnlbyaccoun.xhtml?faces-redirect=true" icon="/img/journalbyacountreport16.png">
 				      </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['journalbydate']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
					  outcome="/Reportjrnlbydate.xhtml?faces-redirect=true" icon="/img/journalbydatereport16.png">
 				      </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['trailbalancereport']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
					  outcome="/Reporttrialbalance.xhtml?faces-redirect=true" icon="/img/trialbalancereport16.png">
 				      </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['balancesheetreport']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
					  outcome="/Reportbalancesheet.xhtml?faces-redirect=true" icon="/img/balancesheetreport16.png">
 				      </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['incomestatementreport']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
					  outcome="/Reportincomestmnt.xhtml?faces-redirect=true" icon="/img/incomestatementreport16.png">
 				      </p:menuitem>
                         </#if>
 			     </p:submenu>
                    </#if>
                    <#if toGenAB==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderABRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderABRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderABRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderABRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderABRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderABRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderABRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderABRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderABRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderABRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderABRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderABRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderABRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderABRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderABRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderABRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderABRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderABRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderABRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderABRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderABRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderABRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderABRoleBQ=1>
                       <#if toRenderABRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderABRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderABRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderABRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderABRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderABRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderABRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderABRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderABRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderABRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderABRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                          <#assign renderString="("+renderString[0..renderString?length-3]+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">

				<p:submenu label="${'#'}{messages['menutab.AddListReport.AddLB']}" icon="/img/New16.png" iconClass="pic"
                      <#if renderString="">
                              rendered="false">
                      <#else>
                              rendered="${'#'}{${renderString}}" > 
                      </#if>                        
                     <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                       <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                        <#assign found=0>  
                        <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,6)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                         </#if>
                         <#if (menuAttributesp0?contains("A") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J")) && menuAttributesFG == i && menuAttributesGP == j>
                          <#assign found=1>
                          <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("T"))>
					  outcome="${entity.shortName}Add.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Add"/>
                            <#else>
					  outcome="/${entity.shortName?substring(eL)}Edit.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				     </p:menuitem>
                         </#if>
                        </#foreach>
                       </#foreach>
                       <#if found != 0 && i != "A">
     				    <p:separator/>
                       </#if>
                      </#foreach>      
				</p:submenu>
                    </#if>
                    <#if toGenLB==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderLBRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderLBRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderLBRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLBRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderLBRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderLBRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLBRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderLBRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderLBRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLBRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderLBRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderLBRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderLBRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderLBRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderLBRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderLBRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderLBRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderLBRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderLBRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderLBRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderLBRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderLBRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderLBRoleBQ=1>
                       <#if toRenderLBRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderLBRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderLBRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderLBRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderLBRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderLBRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderLBRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderLBRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderLBRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderLBRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderLBRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                          <#assign renderString="("+renderString[0..renderString?length-3]+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">

				<p:submenu label="${'#'}{messages['menutab.AddListReport.ListLB']}" icon="/img/New16.png" iconClass="pic"
                      <#if renderString="">
                              rendered="false">
                      <#else>
                              rendered="${'#'}{${renderString} }" > 
                      </#if>                        
                      <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                       <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                        <#assign found=0>  
                        <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,6)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(10,11)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                         <#if (menuAttributesp0?contains("L") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J")) && menuAttributesFG == i && menuAttributesGP == j>
                          <#assign found=1>
                          <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("T"))>
					  outcome="${entity.shortName}Add.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Add"/>
                            <#else>
					  outcome="/${entity.shortName?substring(eL)}List.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				     </p:menuitem>
                         </#if>
                        </#foreach>
                       </#foreach>
                       <#if found != 0 && i != "A">
     				    <p:separator/>
                       </#if>
                      </#foreach>     
 				</p:submenu>
                    </#if>
                    <#if toGenRB==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderRBRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderRBRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderRBRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRBRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderRBRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderRBRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRBRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderRBRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderRBRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRBRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderRBRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderRBRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderRBRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderRBRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderRBRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderRBRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderRBRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderRBRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderRBRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderRBRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderRBRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderRBRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderRBRoleBQ=1>
                       <#if toRenderRBRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderRBRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderRBRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderRBRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderRBRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderRBRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderRBRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderRBRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderRBRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderRBRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderRBRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                          <#assign renderString="("+renderString[0..renderString?length-3]+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">

            	     <p:submenu label="${'#'}{messages['menutab.AddListReport.ReportLB']}" icon="/img/Report16.png" iconClass="pic"
                      <#if renderString="">
                              rendered="false">
                      <#else>
                              rendered="${'#'}{${renderString} }" > 
                      </#if>                        
                    
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                         <#foreach j in ["B","C","D","E","F","G","H","I","J","K"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(11,12)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">

                          </#if>
                          <#if (menuAttributesp0?contains("R") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J")) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}Report.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
				   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>      
 			     </p:submenu>
                    </#if>
			 </p:submenu>
                </#if>
                <#if toGenT==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderTRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderTRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderTRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderTRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderTRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderTRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderTRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderTRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderTRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderTRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderTRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderTRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderTRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderTRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderTRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderTRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderTRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderTRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderTRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderTRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderTRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderTRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderTRoleBQ=1>
                       <#if toRenderTRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderTRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderTRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderTRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderTRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderTRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderTRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderTRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderTRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderTRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderTRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
			 <p:submenu hideDelay="800" label="${'#'}{messages['menutab.Transactions']}"
                      <#if renderString="">
                              rendered="false" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
                      <#else>
                              rendered="${'#'}{identity.loggedIn and !customIdentity.hasRole('VW') and (customIdentity.hasRole('UW') || ${renderString[0..renderString?length-3]}) }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} "> 
                      </#if>                        
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/Transactions16.png" styleClass="pic"/>
						<h:outputText value="${'#'}{messages['menutab.Transactions']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
                            <p:menuitem mode="ajax" value="${'#'}{messages['POS']}"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ||customIdentity.hasRole('UW') ) 
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                }"
					 outcome="/cartPOS.xhtml?faces-redirect=true" icon="/img/icons8-pricing-96.png">
			    </p:menuitem>
				<p:submenu label="${'#'}{messages['menutab.Transactions.New']}" icon="/img/New16.png"
                            <#if renderString="">
                              rendered="false">
                            <#else>
                              rendered="${'#'}{identity.loggedIn and (${renderString[0..renderString?length-3]}) }" > 
                            </#if>
 <#--
 transactions do no have others category, so j has more entries for postions. i (menuAttributesFG pos 6,7) j(menuAttributesGP 8,9)
 -->                  
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A","B","C","D"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(12,13)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if menuAttributesp0?contains("T")  && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                            <#if (menuAttributesFG ="2" || menuAttributesFG = "3"||menuAttributesFG="4" 
                             || menuAttributesFunction ="9A"|| menuAttributesFunction ="9C") >
			     <p:submenu label="${'#'}{messages['${realEntityName}']}" icon="/img/${realEntityName}16.png"
                             <#if renderString="">
                              rendered="false">
                             <#else>
                         <#if menuAttributesFG ="2">
                          <#assign jrenderString="("+renderString[0..renderString?length-3]+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                         <#elseif menuAttributesFG ="3">
                          <#assign jrenderString="("+renderString[0..renderString?length-3]+")"+
                            " and (fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec')">
                         <#else>
                          <#assign jrenderString="("+renderString[0..renderString?length-3]+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                         </#if>
                              <#if menuAttributesFunction ="9A">
                               rendered="${'#'}{identity.loggedIn and ${jrenderString} ${pRenderString} }" > 
                              <#else>
                               rendered="${'#'}{identity.loggedIn and ${jrenderString} }" > 
                              </#if>
                             </#if>                        
                            </#if> 
                            <#if (menuAttributesFG?contains("2") || menuAttributesFG?contains("3")||menuAttributesFG?contains("4") || menuAttributesFunction ="9A" || menuAttributesFunction ="9C") >
                             <#-- jobassign and emplorder has one menuitem -->
                             <#if menuAttributesGP?contains("3")>
                              <#assign extendedName="Quote">
                             <#elseif menuAttributesGP?contains("4")>
                              <#assign extendedName="Quote">
                             <#elseif menuAttributesGP?contains("5")>
                              <#if menuAttributesFG?contains("2")>
                               <#assign extendedName="(Existing Order/invoice)">
                              <#else>
                               <#assign extendedName="Order">
                              </#if>
                             <#elseif menuAttributesGP?contains("6")>
                              <#assign extendedName="Order">
                             <#elseif menuAttributesGP?contains("7")>
                              <#if menuAttributesFG?contains("2") >                            
                               <#assign extendedName="Invoice">
                              <#else>
                               <#assign extendedName="Order">
                              </#if>
                             <#elseif menuAttributesGP?contains("8")>
                              <#assign extendedName="Invoice">
                             </#if>    
                             <#if !menuAttributesFG?contains("4") && !menuAttributesFunction?contains("36") && !menuAttributesFunction?contains("9A") && !menuAttributesFunction?contains("9C")>   
                              <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']} ${'#'}{messages['${extendedName}']}"
                             <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("A") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J"))>
					  outcome="${entity.shortName}Tran" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Tran"/>
                            <#else>
					  outcome="/${entity.shortName?substring(eL)}Edit.quoteorderexists.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				       </p:menuitem>
                            </#if>
                            <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("A") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J"))>
					  outcome="${entity.shortName}Tran" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Tran"/>
                            <#else>
					 outcome="/${entity.shortName?substring(eL)}Edit.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
			    </p:menuitem>
                           </p:submenu>
                           </#if>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     			     <p:separator/>
                         </#if>
                        </#foreach>   
                         <#if appaccounting == 'y'>
                           <p:menuitem mode="ajax" value="${'#'}{messages['Print']} ${'#'}{messages['vendorcheques']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					  outcome="/Vendorcheques.xhtml?faces-redirect=true" icon="/img/Print16.gif">
 				      </p:menuitem>
                         </#if>
                      </p:submenu>
				<p:submenu label="${'#'}{messages['menutab.Transactions.List']}" icon="/img/List16.png"
                            <#if renderString="">
                              rendered="false">
                            <#else>
                              rendered="${'#'}{identity.loggedIn and (${jrenderString}) }" > 
                            </#if>
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A","B","C","D"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(12,13)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if menuAttributesp0?contains("T")  && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                            <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("A") || menuAttributesp0?contains("L") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J"))>
					  outcome="${entity.shortName}Tran" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Tran"/>
                            <#else>
					 outcome="/${entity.shortName?substring(eL)}List.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				      </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				       <p:separator/>
                         </#if>
                        </#foreach>   
                         <#if appaccounting == 'y'>
                           <p:menuitem mode="ajax" value="${'#'}{messages['Print']} ${'#'}{messages['vendorcheques']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
					  outcome="/Vendorcheques.xhtml?faces-redirect=true" icon="/img/vendorcheques16.png">
 				      </p:menuitem>
                         </#if>
                      </p:submenu>
                         <#assign jrenderString="("+renderString[0..renderString?length-3]+")">
				<p:submenu label="${'#'}{messages['menutab.AddListReport.ReportL1']}" icon="/img/Report16.png"
                            <#if renderString="">
                              rendered="false">
                            <#else>
                              rendered="${'#'}{identity.loggedIn and (${jrenderString})}" > 
                            </#if>
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A","B","C","D"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(12,13)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if menuAttributesp0?contains("T")  && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <#if menuAttributesFG ="2">
                            <#if pRenderString ="">
                             <#assign jrenderString=" and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                            <#else>
                             <#assign jrenderString=pRenderString+
                             " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                            </#if> 
                           <#elseif menuAttributesFG ="3">
                            <#if pRenderString ="">
                             <#assign jrenderString=" and (fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec')">
                            <#else>
                             <#assign jrenderString=pRenderString+
                              " and (fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec')">
                            </#if> 
                           <#else>
                            <#if pRenderString ="">
                             <#assign jrenderString=" and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                            <#else>
                             <#assign jrenderString=pRenderString+
                              " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                            </#if> 
                          </#if>
                            <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${jrenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${jrenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${jrenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${jrenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${jrenderString}}"
                            </#if>
                            <#if (menuAttributesp0?contains("A") || menuAttributesp0?contains("C") || menuAttributesp0?contains("D") || menuAttributesp0?contains("F") || menuAttributesp0?contains("J"))>
					  outcome="${entity.shortName}Tran" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Tran"/>
                            <#else>
					 outcome="/${entity.shortName?substring(eL)}Report.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				      </p:menuitem>
                            <#if menuAttributesFunction ="26">
                            <p:menuitem mode="ajax" value="${'#'}{messages['Customer']} ${'#'}{messages['statements']}"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) }"
					 outcome="/customerStatements.xhtml?faces-redirect=true" icon="/img/Cuinvoice16.png">
				      </p:menuitem>
                            </#if>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				       <p:separator/>
                         </#if>
                        </#foreach>   
                         <#if appaccounting == 'y'>
                           <p:menuitem mode="ajax" value="${'#'}{messages['Print']} ${'#'}{messages['vendorcheques']}"
                             rendered="${'#'}{(customIdentity.hasRole('UH') ) ${jrenderString}}"
					  outcome="/Vendorcheques.xhtml?faces-redirect=true" icon="/img/vendorcheques16.png">
 				      </p:menuitem>
                         </#if>
                      </p:submenu>
			 </p:submenu>
                </#if>
                <#if toGenM==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderMRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderMRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderMRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderMRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderMRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderMRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderMRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderMRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderMRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderMRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderMRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderMRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderMRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderMRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderMRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderMRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderMRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderMRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderMRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderMRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderMRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderMRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderMRoleBQ=1>
                       <#if toRenderMRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderMRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderMRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderMRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderMRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderMRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderMRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderMRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderMRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderMRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderMRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
			 <p:submenu hideDelay="800" label="${'#'}{messages['menutab.Mailings']}"
                      <#if renderString="">
                              rendered="false" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
                      <#else>
                              rendered="${'#'}{identity.loggedIn and !customIdentity.hasRole('VW') and (${renderString[0..renderString?length-3]}) }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} " > 
                      </#if>                        
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/ComposeMail16.png" styleClass="pic"/>
						<h:outputText value="${'#'}{messages['menutab.Mailings']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:submenu label="${'#'}{messages['menutab.Mailings.Labels']}" icon="/img/tag_blue16.png"
                            <#if renderString="">
                              rendered="false">
                            <#else>
                              rendered="${'#'}{identity.loggedIn and (${renderString[0..renderString?length-3]}) }" > 
                            </#if>
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(13,14)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                         <#if menuAttributesFG ="2" && pRenderString !="">
                          <#assign jrenderString="("+pRenderString+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'">
                         <#elseif menuAttributesFG ="3" && pRenderString !="">
                          <#assign jrenderString="("+pRenderString+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'">
                         <#elseif renderString="" || pRenderString ="">
                          <#assign jrenderString="">        
                         <#else>
                          <#assign jrenderString="("+pRenderString+")"+
                            " and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'">
                         </#if>
                          <#-- add F for div,item etc later put B for it now, b is used for serial but is in b group so hardcode item  and serial-->
                          <#if (menuAttributesp0?contains("M") || menuAttributesp0?contains("J") || menuAttributesFunction?contains("1A") || menuAttributesFunction?contains("1F") || menuAttributesp0?contains("B") ) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${jrenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${jrenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("F") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('PH')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW')
                               ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')
                               ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('VH') ) ${jrenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${jrenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${jrenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${jrenderString}}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}LabelsPrint.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
			   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>   
                        <p:menuitem mode="ajax" value="${'#'}{messages['serialnumbers']}"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')
                               ) and (customIdentity.product == 'e' and customIdentity.subProduct == 'f') }"
					outcome="/${serialnumbersEntityName?substring(eL)}LabelsPrint.xhtml?faces-redirect=true" icon="/img/Item16.png">
			   </p:menuitem>
                      </p:submenu>
				<p:submenu label="${'#'}{messages['menutab.Mailings.EMails']}" icon="/img/email16.png"
                            <#if renderString="">
                              rendered="false">
                            <#else>
                              rendered="${'#'}{identity.loggedIn and (${renderString[0..renderString?length-3]}) }" > 
                            </#if>
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(13,14)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if (menuAttributesp0?contains("M") || menuAttributesp0?contains("J") ) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}MailingSend.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
			   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>    
                      </p:submenu>
			 </p:submenu>
                </#if>
                <#if toGenTools==1 >
			 <p:submenu hideDelay="800" label="${'#'}{messages['menutab.Tools']}"
                   rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('UQ') ||customIdentity.hasRole('UW') ||customIdentity.hasRole('VW') || customIdentity.hasRole('PH')) and identity.loggedIn }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/Tools16.png" styleClass="pic"/>
						<h:outputText value="${'#'}{messages['menutab.Tools']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
 			        </f:facet>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Calculator']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('VW') ) ${pRenderString}}"
					outcome="/calculatorBasic.xhtml?faces-redirect=true" icon="/img/calculator.png">
				   </p:menuitem>
			<p:submenu label="${'#'}{messages['Inventory']} ${'#'}{messages['count']}" icon="/img/tag_blue16.png"
                              rendered="${'#'}{identity.loggedIn and (customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')||customIdentity.hasRole('UH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('BQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('SQ')||customIdentity.hasRole('CQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH'))
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }">
                           <p:menuitem mode="ajax" value="${'#'}{messages['Stock']} ${'#'}{messages['count']} [SKU]"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')
                               ) 
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/countAlias.xhtml?faces-redirect=true" icon="/img/Serialnumbers16.png">
			   </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['Item']} ${'#'}{messages['count']} [no SKU]"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ||customIdentity.hasRole('UW')) }"
					outcome="/countItem.xhtml?faces-redirect=true" icon="/img/Serialnumbers16.png">
			   </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['Scan']}/${'#'}{messages['Count']} ${'#'}{messages['Dates']}"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ||customIdentity.hasRole('UW'))}"
					outcome="/scandateList.xhtml?faces-redirect=true" icon="/img/Scandate16.png">
			   </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['Serialnumber']}/${'#'}{messages['Physical']} ${'#'}{messages['Count']} ${'#'}{messages['records']}"
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ||customIdentity.hasRole('UW'))}" 
					outcome="/serialnumbersList.xhtml?faces-redirect=true" icon="/img/Serialnumbers16.png">
			   </p:menuitem>
                      </p:submenu>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Image_Editor']}/${'#'}{messages['Text_Editor']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/ImageTouchUp.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Language']} ${'#'}{messages['translate']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/Translate.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Theme']} ${'#'}{messages['Gallery']}"
                              rendered="${'#'}{(customIdentity.masterSite) and customIdentity.hasRole('PH') 
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/homeThemePreview.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
				<p:menuitem mode="ajax" value="${'#'}{messages.Upload} ${'#'}{messages.photos} ${'#'}{messages.to} ${'#'}{messages.shared} ${'#'}{messages.gallery}" rendered="${'#'}{(customIdentity.masterSite) and identity.loggedIn and customIdentity.hasRole('PH') and skinBean.iconShown
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/blobdataEditEasy.xhtml?faces-redirect=true" icon="/img/Photos16.png" iconClass="pic"  />
				<p:menuitem mode="ajax" value="${'#'}{messages.Upload} ${'#'}{messages.photos} ${'#'}{messages.to} ${'#'}{messages.shared} ${'#'}{messages.gallery}" rendered="${'#'}{(customIdentity.masterSite) and identity.loggedIn and customIdentity.hasRole('PH') and !skinBean.iconShown
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/blobdataEditEasy.xhtml?faces-redirect=true"   />

                        <p:menuitem mode="ajax" value="${'#'}{messages['Migrate']} ${'#'}{messages['site']} ${'#'}{messages['pages']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/migrateTools.xhtml?faces-redirect=true" icon="/img/Directionalarrow right_256.png">
				   </p:menuitem>

                        <p:menuitem mode="ajax" value="${'#'}{messages['Import']} ${'#'}{messages['theme']} ${'#'}{messages['to']} ${'#'}{messages['gallery']}"
                              rendered="${'#'}{customIdentity.masterSite and (customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/themeImport.xhtml?faces-redirect=true" icon="/img/Directionalarrow right_256.png">
                        </p:menuitem>

                        <p:menuitem mode="ajax" value="${'#'}{messages['Export']} ${'#'}{messages['theme']} ${'#'}{messages['as']} ${'#'}{messages['csv']} ${'#'}{messages['file']}"
                              rendered="${'#'}{customIdentity.masterSite and (customIdentity.hasRole('PH') || customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/themeExport.xhtml?faces-redirect=true" icon="/img/Directionalarrow right_256.png">
                        </p:menuitem>

                        <p:menuitem mode="ajax" value="${'#'}{messages['Quick']} ${'#'}{messages['site']} ${'#'}{messages['edit']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) 
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/siteEditEasy.xhtml?faces-redirect=true" icon="/img/Homeblue16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['menue']} / ${'#'}{messages['resource']} ${'#'}{messages['label']} / ${'#'}{messages['SEO']} ${'#'}{messages['customization']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/resourcelabelEdtr.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
			</p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Refresh_Sales_data']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
					outcome="/${usagebyperiodsEntityName?substring(eL)}Edit.xhtml?faces-redirect=true" icon="/img/database_refresh16.png">
				   </p:menuitem>
                           <p:menuitem mode="ajax" value="${'#'}{messages['BackUpData']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}}"
					outcome="/SqlAdmin-backUp.xhtml?faces-redirect=true" icon="/img/Clobdata16.png">
				   </p:menuitem>
                      <ui:remove> better approach will be new report (as csv) to show status date older than 360 days  
                           Report can be used to decide edit/delete or not                        
                           <p:menuitem mode="ajax" value="${'#'}{messages['ArchiveData']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}}"
					outcome="/SqlAdmin-archive.xhtml?faces-redirect=true" icon="/img/Clobdata16.png">
				   </p:menuitem>
                      </ui:remove>
				<p:menuitem mode="ajax" value="${'#'}{messages.online} ${'#'}{messages.tutorial} " rendered="${'#'}{not empty ${itemEntityName}List.systemBlogBrowseList}"
					outcome="/BlogDetailsSBrowse.xhtml?faces-redirect=true" icon="/img/comment_play16.png" iconClass="pic"  />
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-CONTACTUS-1-C','HDR',0,1200) !=null) }"
					outcome="/ContactUs-1.xhtml?faces-redirect=true" icon="/img/Ccontact16.png" iconClass="pic"  >
                                 <h:outputText escape="false" value="${'#'}{messages['HelpChat']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  value="${'#'}{messages['help']} ${'#'}{messages['guide']}" rendered="${'#'}{!skinBean.iconShown}"
					outcome="/HelpReference.xhtml?faces-redirect=true"   >
				</p:menuitem>
				<p:menuitem mode="ajax"  value="${'#'}{messages['help']} ${'#'}{messages['guide']}"  rendered="${'#'}{skinBean.iconShown}"
					outcome="/HelpReference.xhtml?faces-redirect=true" icon="/img/help.gif" iconClass="pic"  >
				</p:menuitem>
				<p:menuitem mode="ajax"  value="${'#'}{messages['reseller']} ${'#'}{messages['reference']} ${'#'}{messages['manual']}" 
                                 rendered="${'#'}{skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/ResellerReference.xhtml?faces-redirect=true" icon="/img/News16.png" iconClass="pic"  >
				</p:menuitem>
				<p:menuitem mode="ajax"  value="${'#'}{messages['reseller']} ${'#'}{messages['reference']} ${'#'}{messages['manual']}"
                                  rendered="${'#'}{!skinBean.iconShown
                                   and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                    and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                     and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                      and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'}"	
					outcome="/ResellerReference.xhtml?faces-redirect=true"   >
				</p:menuitem>
                           <#--
                           <p:menuitem mode="ajax" value="${'#'}{messages['BackUp']} ${'#'}{messages['Local']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}}"
					outcome="/SqlAdmin-backUpLocal.xhtml?faces-redirect=true" icon="/img/Clobdata16.png">
				   </p:menuitem>
                           -->
			 </p:submenu>
                </#if>

                <#if toGenY==1 >
                      <#assign renderString="">
                      <#assign orString="||">
                      <#if toRenderYRoleUH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                      </#if>
                      <#if toRenderYRoleUQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#if toRenderYRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderYRoleUW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#if toRenderYRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderYRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderYRoleIH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                      </#if>
                      <#if toRenderYRoleIQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#if toRenderYRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderYRoleIW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#if toRenderYRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#if toRenderYRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                      </#if>
                      <#if toRenderYRoleKH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderYRoleKQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderYRoleKW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('KW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('KH')"+orString>
                      </#if>
                      <#if toRenderYRoleEH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderYRoleEQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderYRoleEW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                      </#if>
                      <#if toRenderYRoleSH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderYRoleSQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderYRoleSW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                      </#if>
                      <#if toRenderYRoleBH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderYRoleBQ=1>
                       <#if toRenderYRoleUQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       </#if>
                       <#if toRenderYRoleIQ=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#if toRenderYRoleUH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       </#if>
                       <#if toRenderYRoleIH=0>
                        <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       </#if>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderYRoleBW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('IH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('BH')"+orString>
                      </#if>
                      <#if toRenderYRoleCH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderYRoleCQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderYRoleCW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('SH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('CH')"+orString>
                      </#if>
                      <#if toRenderYRoleDH=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderYRoleDQ=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
                      <#if toRenderYRoleDW=1>
                       <#assign renderString=renderString+"customIdentity.hasRole('UW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DW')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DQ')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('UH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('EH')"+orString>
                       <#assign renderString=renderString+"customIdentity.hasRole('DH')"+orString>
                      </#if>
			 <p:submenu hideDelay="800" label="${'#'}{messages['menutab.Maintenance']}"
                    rendered="${'#'}{identity.loggedIn
                               and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='es'
                                and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ec'
                                 and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='ol'
                                  and fn:substring(yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode,0,2)!='oe'
                               }"
                            style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/Information16.png" styleClass="pic"/>
						<h:outputText value="${'#'}{messages['menutab.Maintenance']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(14,15)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case>
                          <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if menuAttributesp0?contains("Y") && menuAttributesFG == i && menuAttributesGP == j
                             && (menuAttributesFunction != "5B" ) >
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              <#if menuAttributesFunction == "56">
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                              <#else>
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                              </#if> 
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('SH')||s:hSasRole('SQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('SH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("V") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ')||customIdentity.hasRole('VW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('VH')||customIdentity.hasRole('VQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('VH') ) ${pRenderString}}"
                             </#if>
                            <#else>
                              rendered="${'#'}{(customIdentity.hasRole('EH') ) ${pRenderString}}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}List.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
				   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				      <p:separator/>
                         </#if>
                        </#foreach> 
                        <p:menuitem mode="ajax" value="${'#'}{messages['account']}  ${'#'}{messages['period']} ${'#'}{messages['totals']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
					outcome="/${accountEntityName?substring(eL)}List.more.xhtml?faces-redirect=true" icon="/img/Account16.png">
			        </p:menuitem>   
                        <p:menuitem mode="ajax" value="${'#'}{messages['YearEnd']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
					outcome="/${perioddatesEntityName?substring(eL)}List.xhtml?faces-redirect=true" icon="/img/YearEnd16.png">
			        </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Theme']} ${'#'}{messages['Gallery']}"
                              rendered="${'#'}{(customIdentity.masterSite) and customIdentity.hasRole('PH') }"
					outcome="/homeThemePreview.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                          <p:menuitem mode="ajax" value="${'#'}{messages['Home']} ${'#'}{messages['page']} ${'#'}{messages['customization']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}}"
					outcome="/homePageEditor.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['visitor']} ${'#'}{messages['pages']} ${'#'}{messages['customization']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}}"
					outcome="/homeOtherPagesEdtr.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['menue']} / ${'#'}{messages['resource']} ${'#'}{messages['label']} ${'#'}{messages['customization']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('IH')) ${pRenderString}}"
					outcome="/resourcelabelEdtr.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Web Site Customization']}"
                              rendered="${'#'}{(customIdentity.size == 'L' and (customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')||customIdentity.hasRole('CH')||customIdentity.hasRole('UQ') )) ${pRenderString}}"
					outcome="/homeMockUp.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
			        </p:menuitem>   
                    <ui:remove> part of backup page, less menu sep19 2020
                        <p:menuitem mode="ajax" value="${'#'}{messages['RestoreData']}"
                              rendered="${'#'}{(customIdentity.hasRole('UH')) ${pRenderString}}"
					outcome="/SqlAdmin-restore.xhtml?faces-redirect=true" icon="/img/Clobdata16.png">
				   </p:menuitem>
                    </ui:remove>
                        <p:menuitem mode="ajax" value="${'#'}{messages['profile']} ${'#'}{messages['update']}"
                              rendered="${'#'}{(customIdentity.hasRole('VH') || customIdentity.hasRole('PH')) ${pRenderString}}"
					outcome="/userselfList.xhtml?faces-redirect=true" icon="/img/User16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Gallery']} ${'#'}{messages['home']} ${'#'}{messages['page']} ${'#'}{messages['template']}"
                              rendered="${'#'}{(customIdentity.masterSite) and customIdentity.hasRole('PH') }"
					outcome="/homePageEditor.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
                        <p:menuitem mode="ajax" value="${'#'}{messages['Gallery']} ${'#'}{messages['visitor']} ${'#'}{messages['pages']} ${'#'}{messages['template']}"
                              rendered="${'#'}{(customIdentity.masterSite) and customIdentity.hasRole('PH') }"
					outcome="/homeOtherPagesEdtr.xhtml?faces-redirect=true" icon="/img/shape_square_edit16.png">
				   </p:menuitem>
			 </p:submenu>
                </#if>
                <#if toGenN==1 >
			 <p:submenu hideDelay="800"  label="${'#'}{messages['menutab.Generate']}"
                    rendered="${'#'}{identity.loggedIn }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} " >
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/Generate16.png" styleClass="pic"/>
						<h:outputText value="${'#'}{messages['menutab.Generate']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:submenu label="${'#'}{messages['menutab.Generate.AddL1']}" icon="/img/New16.png" iconClass="pic">
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(17,18)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                          <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                         <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if (menuAttributesp0?contains("N")) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('UH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('IH')||customIdentity.hasRole('IQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('IH') ) ${pRenderString}}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('KH')||customIdentity.hasRole('KQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{(customIdentity.hasRole('KH') ) ${pRenderString}}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('EH')||customIdentity.hasRole('EQ') ) ${pRenderString}}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('EH')}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('SH')||s:hSasRole('SQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('SH')}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH')}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH')}"
                             </#if>
                            <#else>
                              rendered="${'#'}{customIdentity.hasRole('EH')}"
                            </#if>
                            <#if (menuAttributesp0?contains("T"))>
					   outcome="${entity.shortName}Add.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                              <f:param name="menuFrom" value="Add"/>
                            <#else>
					   outcome="/${entity.shortName?substring(eL)}Edit.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
                            </#if>
				   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>      
				</p:submenu>
				<p:submenu label="${'#'}{messages['menutab.Generate.ListL1']}" icon="/img/List16.png" iconClass="pic">
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(10,11)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case>    
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                          <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if (menuAttributesp0?contains("N")) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                            <#if menuAttributesp1?contains("U") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')}"
                             </#if>
                            <#elseif menuAttributesp1?contains("I") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('IH')}"
                             </#if>
                            <#elseif menuAttributesp1?contains("K")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('KH')}"
                            </#if>
                            <#elseif menuAttributesp1?contains("E")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('EH')}"
                            </#if>
                            <#elseif menuAttributesp1?contains("S")>
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('H')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('SH')||s:hSasRole('SQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('SH')}"
                            </#if>
                            <#elseif menuAttributesp1?contains("B") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')||customIdentity.hasRole('BW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')
                               ||customIdentity.hasRole('BH')||customIdentity.hasRole('BQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('IH')||customIdentity.hasRole('BH')}"
                             </#if>
                            <#elseif menuAttributesp1?contains("C") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')||customIdentity.hasRole('SW')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')||customIdentity.hasRole('CW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('SH')||customIdentity.hasRole('SQ')
                               ||customIdentity.hasRole('CH')||customIdentity.hasRole('CQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('SH')||customIdentity.hasRole('CH')}"
                             </#if>
                            <#elseif menuAttributesp1?contains("D") >
                             <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')||customIdentity.hasRole('EW')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')||customIdentity.hasRole('DW')}"
                             <#elseif menuAttributesp1?contains("Q") >
                               rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')
                               ||customIdentity.hasRole('EH')||customIdentity.hasRole('EQ')
                               ||customIdentity.hasRole('DH')||customIdentity.hasRole('DQ')}"
                             <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')||customIdentity.hasRole('EH')||customIdentity.hasRole('DH')}"
                             </#if>
                            <#else>
                              rendered="${'#'}{customIdentity.hasRole('EH')}"
                            </#if>
					outcome="/${entity.shortName?substring(eL)}List.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
				   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>      
				</p:submenu>
            	     <p:submenu label="${'#'}{messages['menutab.AddListReport.ReportL1']}" icon="/img/Report16.png" iconClass="pic">
                        <#foreach i in ["1","2","3","4","5","6","7","8","9","A"]>  
                        <#foreach j in ["0","1","2","3","4","5","6","7","8","9","A"]>  
                         <#assign found=0>  
                         <#foreach entity in c2j.getPOJOIterator(cfg.classMappings)>
                         <#assign menuAttributesp0 = entity.shortName?substring(0,4)?upper_case>
                         <#assign menuAttributesp1 = entity.shortName?substring(4,5)?upper_case+entity.shortName?substring(11,12)?upper_case>
                         <#assign menuAttributesFunction = entity.shortName?substring(6,8)?upper_case>
                         <#assign menuAttributesFG = entity.shortName?substring(6,7)?upper_case>
                         <#assign menuAttributesGP = entity.shortName?substring(8,9)?upper_case>
                         <#assign realEntityName = entity.shortName?substring(eL)?cap_first>
                         <#assign toGenForProduct = entity.shortName?substring(15,16)?lower_case> 
                         <#assign toGenForSubProduct = entity.shortName?substring(16,17)?lower_case>    
                          <#assign toGenForSize = entity.shortName?substring(17,18)?lower_case> 
                         <#if toGenForProduct=="b" && toGenForSubProduct=="x">
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}')">
                         <#elseif toGenForProduct=="b" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and (customIdentity.product == '${toGenForProductB1}' || customIdentity.product == '${toGenForProductB2}') and (customIdentity.subProduct == '${toGenForSubProduct}')">
                         <#elseif toGenForProduct !="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString=" and (customIdentity.product == '${toGenForProduct}')">
                         <#elseif toGenForProduct=="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif toGenForProduct!="x" && toGenForSubProduct !="x">  
                           <#assign pRenderString=" and customIdentity.product == '${toGenForProduct}' and customIdentity.subProduct == '${toGenForSubProduct}'">
                         <#elseif  toGenForProduct="x" && toGenForSubProduct=="x">  
                          <#assign pRenderString="">
                         <#elseif  toGenForSize="m" >  
                          <#assign pRenderString=" and (customIdentity.size == '${toGenForSize}' or customIdentity.size == 'l' ">
                         <#elseif  toGenForSize="l" >  
                          <#assign pRenderString=" and customIdentity.subProduct == '${toGenForSize}'">
                          </#if>
                          <#if (menuAttributesp0?contains("N")) && menuAttributesFG == i && menuAttributesGP == j>
                           <#assign found=1>
                           <p:menuitem mode="ajax" value="${'#'}{messages['${realEntityName}']}"
                           <#if menuAttributesp1?contains("U") || menuAttributesp1?contains("B")  || menuAttributesp1?contains("C")>
                            <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')||customIdentity.hasRole('UW')}"
                            <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{(customIdentity.hasRole('UH')||customIdentity.hasRole('UQ')}"
                            <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('UH')}"
                            </#if>
                           <#elseif menuAttributesp1?contains("I") || menuAttributesp1?contains("B")>
                            <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')||customIdentity.hasRole('IW')}"
                            <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('IH')||customIdentity.hasRole('IQ')}"
                            <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('IH')}"
                            </#if>
                           <#elseif menuAttributesp1?contains("K")>
                            <#if menuAttributesp1?contains("W")>
                              rendered="${'#'}{customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')||customIdentity.hasRole('KW')}"
                            <#elseif menuAttributesp1?contains("Q") >
                              rendered="${'#'}{customIdentity.hasRole('KH')||customIdentity.hasRole('KQ')}"
                            <#elseif menuAttributesp1?contains("H") >
                              rendered="${'#'}{customIdentity.hasRole('KH')}"
                            </#if>
                           <#else>
                              rendered="${'#'}{customIdentity.hasRole('EH')}"
                           </#if>
					outcome="/${entity.shortName?substring(eL)}Report.xhtml?faces-redirect=true" icon="/img/${realEntityName}16.png">
				   </p:menuitem>
                          </#if>
                         </#foreach>
                         </#foreach>
                         <#if found != 0 && i != "A">
     				    <p:separator/>
                         </#if>
                        </#foreach>      
 			     </p:submenu>
			 </p:submenu>
                </#if>
			<p:submenu hideDelay="800" label="${'#'}{messages['menutab.ContactUs']}" rendered="${'#'}{(!identity.loggedIn  || customIdentity.hasRole('VW')) and (not empty ${clobdataEntityName}Home.getClobdata('clobdata','A3R-CONTACTUS-1-C','TXT',0,1200) ) }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/ContactUs16.png" styleClass="pic" rendered="${'#'}{skinBean.iconShown}"/>
						<h:outputText value="${'#'}{messages['menutab.ContactUs']}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-CONTACTUS-1-C','TXT',0,1200) !=null) and skinBean.iconShown}"
					outcome="/ContactUs-1.xhtml?faces-redirect=true" icon="/img/ContactUs16.png" iconClass="pic"  >
                             <h:outputText escape="false" value="${'#'}{messages['ContactUs_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{(${clobdataEntityName}Home.getClobdata('clobdata','A3R-CONTACTUS-1-C','TXT',0,1200) !=null) and !skinBean.iconShown}"
					outcome="/ContactUs-1.xhtml?faces-redirect=true"   >
                             <h:outputText escape="false" value="${'#'}{messages['ContactUs_1']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{!skinBean.iconShown}"
					outcome="/invoicecart.xhtml?faces-redirect=true"   >
                             <h:outputText escape="false" value="${'#'}{messages['Customer']} ${'#'}{messages['Payment']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  rendered="${'#'}{skinBean.iconShown}"
					outcome="/invoicecart.xhtml?faces-redirect=true" icon="/img/Cpayment16.png" iconClass="pic"  >
                             <h:outputText  value="${'#'}{messages['Customer']} ${'#'}{messages['Payment']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  rendered="${'#'}{!skinBean.iconShown}"
					outcome="/HelpReference.xhtml?faces-redirect=true"   >
                             <h:outputText  value="${'#'}{messages['help']} ${'#'}{messages['guide']}" />
				</p:menuitem>
				<p:menuitem mode="ajax"  rendered="${'#'}{skinBean.iconShown}"
					outcome="/HelpReference.xhtml?faces-redirect=true" icon="/img/help.gif" iconClass="pic"  >
                             <h:outputText  value="${'#'}{messages['help']} ${'#'}{messages['guide']}" />
				</p:menuitem>
			</p:submenu>
                      <ui:remove>no need for this page via memu. either from shopify app store or from shopify partner app install
			<p:submenu hideDelay="800"  label="${'#'}{messages['Install']}" rendered="${'#'}{!identity.loggedIn}" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
				<f:facet name="label"> 
					<h:panelGroup>
						<h:graphicImage value="/img/Generate16.png" styleClass="pic" rendered="${'#'}{(customIdentity.masterSite) and skinBean.iconShown}"/>
						<h:outputText value="${'#'}{messages['Install']} ${'#'}{messages['App']}" rendered="${'#'}{customIdentity.masterSite}" style="font-size: ${'#'}{skinBean.menuFontSize} !important;font: ${'#'}{skinBean.menuFont} !important;"/>
					</h:panelGroup>
				</f:facet>
				<p:menuitem mode="ajax"   rendered="${'#'}{(customIdentity.masterSite) and skinBean.iconShown}"
					outcome="/installApp.xhtml?faces-redirect=true" icon="/img/Shopify16.png" iconClass="pic"  >
                             <h:outputText escape="false" value="${'#'}{messages['Shopify']} ${'#'}{messages['Store']} ${'#'}{messages['BackOffice']}(Beta)" />
				</p:menuitem>
				<p:menuitem mode="ajax"   rendered="${'#'}{(customIdentity.masterSite) and !skinBean.iconShown}"
					outcome="/installApp.xhtml?faces-redirect=true" icon="/img/Shopify16.png" iconClass="pic"  >
                             <h:outputText escape="false" value="${'#'}{messages['Shopify']} ${'#'}{messages['Store']} ${'#'}{messages['BackOffice']}(Beta)" />
				</p:menuitem>
			</p:submenu>
                      </ui:remove> 
             <p:ajaxStatus  >
              <f:facet name="start">
               <h:graphicImage value="./img/ajax-loader16.gif" />
              </f:facet>
             </p:ajaxStatus>
      <p:submenu hideDelay="800" label="${'#'}{messages['More']}"
         <#if renderString="">
          rendered="false" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} ">
         <#else>
          rendered="${'#'}{identity.loggedIn and !customIdentity.hasRole('VW') and (customIdentity.hasRole('UW') || ${renderString[0..renderString?length-3]}) }" style="background-color:${'#'}{fn:contains(skinBean.skint,'Grey')?'black;':';'} height:${'#'}{skinBean.menuFontSize} "> 
         </#if>   
       <p:menuitem>
        <h:commandLink  id="newtb" styleClass="hdrLink" outcome="/home.xhtml" target="_blank"  iconClass="pic" value="${'#'}{messages['New']} ${'#'}{messages['Tab']}"
         rendered ="${'#'}{!request.requestURI.contains('home.')}" >
        </h:commandLink>
       </p:menuitem>
       <p:menuitem>
        <h:commandLink  id="resetb" styleClass="hdrLink" onclick="myReload()"  iconClass="pic" value="${'#'}{messages['Reload']}" >
        </h:commandLink>
       </p:menuitem>
       <p:menuitem>
        <h:button id="tdonehh" image="./img/home_24.png"  alt="Home" value="Home"  outcome="/home.xhtml" />
       </p:menuitem>
       <p:menuitem action="${'#'}{authenticator.setHomePageclickCount(-1)}">
        <h:commandButton id="shLnd" rendered="${'#'}{!identity.loggedIn and authenticator.homePageclickCount gt 1}"  image="./img/control_add16.png" >
         <p:tooltip id="shLndTip" attached="true" for="shLnd">
              <h:outputText value="${'#'}{messages['Show']} ${'#'}{messages['home']} ${'#'}{messages['top']}"/>
         </p:tooltip>
        </h:commandButton>
       </p:menuitem>
       <p:menuitem>
        <h:commandLink id="registerLink"  style="font-family:arial;color:coral;font-size:18px;" styleClass="hdrLink"  outcome="/register.xhtml?email=mail@yourdomain.com&amp;registrationName=name&amp;websiteName=sitename&amp;faces-redirect=true"  rendered ="${'#'}{(customIdentity.masterSite) and request.requestURI.contains('home.')}" value="${'#'}{messages.Free} ${'#'}{messages.Trial} " >
         <p:tooltip id="demoRegisterTip" attached="true" for="registerLink">
              <h:outputText value="${'#'}{messages.register_tip}"/>
         </p:tooltip>
        </h:commandLink>
       </p:menuitem>
      </p:submenu> 
       </p:menubar>
	</h:form>
</ui:composition>

</#if>
</#if>




