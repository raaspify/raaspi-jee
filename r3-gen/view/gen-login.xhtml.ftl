<#assign tobegeneratedCandidate = "N">  
<#include "../view/assigns/mergedassigns.properties" >
<#include "../view/assigns/PositionLength.properties" >
<#if (pojo.shortName?length > eL)>
<#assign menuAttributes = pojo.shortName?substring(0,eL)?upper_case>
<#-- 56 (User) is a mandatory entity and will force .ftl to run once only even though ,ftl gets invoked for each entity -->
<#if (menuAttributes?substring(efS,efE) == '56') >
 <#assign tobegeneratedCandidate ="Y" >
</#if>
<#if tobegeneratedCandidate == "Y">                       
<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
                      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<ui:composition  xmlns="http://www.w3.org/1999/xhtml"
                 xmlns:ui="http://java.sun.com/jsf/facelets"
                 xmlns:h="http://java.sun.com/jsf/html"
                 xmlns:f="http://java.sun.com/jsf/core"
                 xmlns:c="http://java.sun.com/jsp/jstl/core"
                 xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
                 xmlns:fn="http://java.sun.com/jsp/jstl/functions"
                 template="layout/rtemplateUi.xhtml">
<#-- Generated By gen-login.xhtml.ftl on ${.now}
Login page
parameters passed: none
popupPanels: none
its on the main menu
-->
<f:metadata>
    <f:viewParam name="id" value="${'#'}{loginCredentials.userId}"/>
    <f:viewParam name="pw" value="${'#'}{loginCredentials.password}"/>
    <f:viewAction action="${'#'}{${userEntityName}Home.takeAction()}" />
</f:metadata>

<ui:define name="body">
              <ui:remove> login now shows signup link or demosignup link based on url 
              </ui:remove>
<!--                          toolbar                                     -->

<h:form id="login" onkeypress="if (event.keyCode == 13) { document.getElementById('login:loginb').click(); return false; }">    
<script>
 function myFunction() {
      var data = document.getElementById("login:password");
      if (data.type === "password") {
        data.type = "text";
      } else {
        data.type = "password";
      }
    }
</script>
    
      <div class = "btn-toolbar justify-content-between" role = "toolbar">
         <div class = "btn-group ">
              <h:outputText value="${'#'}{messages.common_notify}" style="font-size: medium;color: red"  /> 
              <h:outputText value="${'#'}{messages.site_notify}" style="font-size: medium;color: red"/> 
              <h:outputText value="${'#'}{messages.backOffice_notify}" rendered="${'#'}{identity.loggedIn}" style="font-size: medium;color: red"/> 

         </div>
         <div class = "btn-group ">
              <h:outputText value="${'#'}{customIdentity.username}" rendered="${'#'}{identity.loggedIn }"/> 
              <h:outputText value="&#160;&#160;"/>
              <!-- Button to Open the Modal -->
              <ui:fragment rendered="${'#'}{identity.loggedIn}">
              <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                ${'#'}{messages.prefs_change_password}
              </button>
              </ui:fragment>
              <h:outputText value="&#160;&#160;"/>
              <ui:remove> show fb only logout for situations where only fb login happened but not identiy login 
              </ui:remove>
              <h:link id="logoutfb" onclick="if (! confirm('Logout ?') ) { return false;}; Logout();return true;" value="Logout(FB)" rendered="${'#'}{!identity.loggedIn and customIdentity.smUid != null }"/>
              <h:commandButton class="btn btn-primary" id="logout" onclick="Logout();" action="${'#'}{customIdentity.logout()}" value="Logout" rendered="${'#'}{identity.loggedIn}"/>

              <h:outputText value="${'#'}{messages.Today} "/> 
              &#160;<h:outputText value="${'#'}{authenticator.currcaldates}"/> 
              &nbsp;<h:button id="tdoneh" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  outcome="/home.xhtml" rendered="${'#'}{!yxxxuh566xwwqqwxxxxxuserHome.mobile}"/>

              &#160;<h:link id="Cart" outcome="/checkout.xhtml" value="Cart" propagation="none"  rendered="${'#'}{!identity.loggedIn and fpxxfq1a5xwwqqhxxxxxitemList.getCartedList('cart').size() gt 0 }"  >
               <h:graphicImage value="/img/Cart32.png" />
              </h:link>
              &#160;<h:outputText value="[${'#'}{fpxxfq1a5xwwqqhxxxxxitemList.getCartedList('cart').size()}]" rendered="${'#'}{!identity.loggedIn and fpxxfq1a5xwwqqhxxxxxitemList.getCartedList('cart').size() gt 0}">
              </h:outputText>
              <h:outputText value="[${'#'}{messages['empty']}]" rendered="${'#'}{!identity.loggedIn and fpxxfq1a5xwwqqhxxxxxitemList.getCartedList('cart').size() == 0}"/>
         </div>
      </div>
      <br></br>
      <h:messages globalOnly="false" style = "color:red;margin:8px;" styleClass="message" id="globalMessages"/>
   

        <ui:fragment rendered="${'#'}{identity.loggedIn}">
           <h:outputText value="${'#'}{messages.Login} ${'#'}{messages.successful}" />
           &nbsp;<h:button id="back" image="./img/home_24.png"  alt="Home" value="Home" propagation="end"  outcome="/home.xhtml">
           </h:button>

        </ui:fragment>   

<div id="accordion">

  <div class="card">
    <div class="card-header">
      <a class="card-link" data-toggle="collapse" href="#collapseOne">
        ${'#'}{messages.Login}
      </a>
    </div>
    <div id="collapseOne" class="collapse show" data-parent="#accordion">
      <div class="card-body">
              <c:set var = "tpc" value="${'#'}{${userEntityName}Home.mobile?1:3}">
              </c:set>
  
              <h:outputText value=" "/>
              <h:outputText value="${'#'}{messages.demoLogin_tip}" rendered ="${'#'}{request.serverName.startsWith('myorg') or request.serverName.startsWith('mybus')}"/>
          
           <h:panelGroup>          
            <div class="dialog">
                <h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">
                    <h:inputText id="username" onclick="this.value='';"  pt:placeholder="Username"
                              required="true"
                              value="${'#'}{loginCredentials.userId}"/>
                </h:panelGrid>
                    <h:panelGrid columns="4" rowClasses="prop" columnClasses="name,value">
                    <h:inputSecret id="password" pt:placeholder="Password"
                              required="true" 
                                value="${'#'}{loginCredentials.password}" redisplay="true"/>
                    <i class="fa fa-eye" aria-hidden="true" onclick="myFunction()"></i>
                    <ui:remove>
                    <h:panelGrid columns="2">
                    <h:outputLabel for="rememberMe">${'#'}{messages.remember} ${'#'}{messages.my} ${'#'}{messages.id}</h:outputLabel>
                    <h:selectBooleanCheckbox id="rememberMe" 
                                          value="${'#'}{identity.rememberMe}"/>
                    </h:panelGrid>
                    </ui:remove>
                </h:panelGrid>
                <div class="actionButtons">
                 <h:commandButton styleClass="btn btn-primary ;" rendered="${'#'}{!identity.loggedIn}" id="loginb"  value="Login" action="${'#'}{customIdentity.login}"/>
                 &nbsp;<h:button id="ltdone"  value="Cancel" propagation="end" outcome="/home.xhtml" />

                 <h:commandButton id="resendAct" value="Resend Activation " action="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.doResendActivationEmail()}"
                  rendered = "${'#'}{yxxxuh566xwwqqwxxxxxuserHome}.activationPending}" />
                </div>
                <div>
                <br/>
                <h:outputText value="${'#'}{messages.signup_to_create_logon_Id}    " rendered ="${'#'}{(request.requestURI.contains('login.'))}"/>
                <h:link id="signupLink"  class="btn-link"  outcome="/signup.xhtml"  rendered ="${'#'}{ ( !(request.serverName.startsWith('mybusiness') or request.serverName.startsWith('myorg') or request.serverName.startsWith('mycustommade')) and not identity.loggedIn and request.requestURI.contains('login.'))}" value="${'#'}{messages.signup}" >
                </h:link>
                <h:link id="demosignupLink"  class="btn-link"  outcome="/signup.xhtml"  rendered ="${'#'}{ ( (request.serverName.startsWith('mybusiness') or request.serverName.startsWith('myorg') or request.serverName.startsWith('mycustommade')) and not identity.loggedIn and request.requestURI.contains('login.'))}" value="${'#'}{messages.demosignup}" >
                </h:link>
                <ui:remove> enable after upgrading tp oAuth and server based solution
                <br></br><br></br><h:outputText id="skpsignUp" style="font-weight:bold" value="${'#'}{messages.Skip} ${'#'}{messages.signup}, ${'#'}{messages.click} ${'#'}{messages.social} ${'#'}{messages.media} fb/Google ${'#'}{messages.login} " rendered ="${'#'}{(request.requestURI.contains('login.'))}">
                </h:outputText>
                </ui:remove>
                <br></br>
             <ui:remove> SASS vendor to offer multi-tenant multi-functions functionality where client create their own sites. Register.xhtml can show optional SASS demo sites
               client record field client record 01 prodcode eg vs ee is used to enable this optional feature. In addition param functionGroup value can be used to control which product. If master
               site prodcode is eh then show only ee product code.
              </ui:remove>
                <h:outputText value="${'#'}{messages['Like']} ${'#'}{messages['this']}? ${'#'}{messages['create']} ${'#'}{messages['your']} ${'#'}{messages['own']} ${'#'}{messages['site']} " rendered ="${'#'}{request.requestURI.contains('login.') and yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode.contains('eg')}"/>
                <h:link id="registerLink"  class="btn-link"  outcome="/register.xhtml?email=mail@yourdomain.com&amp;registrationName=name&amp;websiteName=sitename&amp;faces-redirect=true"  rendered ="${'#'}{(customIdentity.masterSite) and request.requestURI.contains('login.')and yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode.contains('eg')}" value="${'#'}{messages['free']} ${'#'}{messages['trial']}" >
                </h:link>
                <h:outputText value="${'#'}{messages['Like']} ${'#'}{messages['this']}? ${'#'}{messages['create']} ${'#'}{messages['your']} ${'#'}{messages['own']} ${'#'}{messages['site']} " rendered ="${'#'}{request.requestURI.contains('login.') and yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode.contains('eh')}"/>
                <h:link id="registerLink2"  class="btn-link"  outcome="/register.xhtml?email=mail@yourdomain.com&amp;registrationName=name&amp;websiteName=sitename&amp;functionGroup=1&amp;faces-redirect=true"  rendered ="${'#'}{(customIdentity.masterSite) and request.requestURI.contains('login.')and yxxxch522xhhxxhxxxxxclientList.getSuggestList('01')[0].g2xxuxpclvxxxxxxxxxxprodcode.contains('eh')}" value="${'#'}{messages['free']} ${'#'}{messages['trial']}" >
                </h:link>
                <!--reset pw -->
              <!-- Button to Open the Modal -->
              <br></br><ui:fragment rendered="${'#'}{!identity.loggedIn}">
              <button type="button" class="btn-link" data-toggle="modal" data-target="#myModal">
                ${'#'}{messages.reset_password}
              </button>
              </ui:fragment>

                </div>
            </div>
           </h:panelGroup> 
      </div>
    </div>
  </div>
  <ui:remove> 
  <div class="card">
    <div class="card-header">
      <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
        ${'#'}{messages.Login} ${'#'}{messages.using} ${'#'}{messages.social} ${'#'}{messages.media}
      </a>
    </div>
    <div id="collapseTwo" class="collapse" data-parent="#accordion">
      <div class="card-body">
                <br/>
                <ui:remove>
                  http://localhost:8080/urlinfo?x=1ampy=1
                  request.getRequestURL().toString(),request.getServerName(),request.getServerPort()
                  request.getQueryString()
                  Url: http://localhost:8080/urlinfo
                  Uri: /urlinfo
                  Scheme: http
                  Server Name: localhost
                  Port: 8080
                  Context Path: 
                  Servlet Path: /urlinfo
                  Path Info: null
                  Query: x=1ampy=1
                  nummbr{param['x']}
                  h:outputLink value = "//www.raaspi.com/socialLogin.wflow"
                  outputLink puts current path if va;ue is relative page we may not need port checking
                </ui:remove>
                <h:button  value="Home"  outcome="/home.xhtml" rendered="${'#'}{identity.loggedIn}"/>
                <h:outputText value="${'#'}{messages.Usage_terms}" />
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="${'#'}termsOfUse">
                 ${'#'}{messages['read']}
                </button>
                <br></br><br></br>
                <h:outputLink class="w3-button w3-blue" value = "/socialLogin.wflow" rendered="${'#'}{request.serverPort =='8080'}"> 
                 ${'#'}{messages['Social']} ${'#'}{messages['Login']}- ${'#'}{messages['Continue']} 
                 <f:param name="for" value="${'#'}{customIdentity.owner2}" />
                 <f:param name="fromUrl" value="${'#'}{request.requestURL}" />
                </h:outputLink>
                <h:outputLink class="w3-button w3-blue" value = "/socialLogin.wflow" rendered="${'#'}{request.serverPort !='8080'}"> 
                 ${'#'}{messages['Social']} ${'#'}{messages['Login']}- ${'#'}{messages['Continue']} 
                 <f:param name="for" value="${'#'}{customIdentity.owner2}" />
                 <f:param name="fromUrl" value="${'#'}{request.requestURL}" />
                </h:outputLink>
                <br></br><br></br><h:button  value="Cancel" propagation="end" outcome="/home.xhtml" />
      </div>
    </div>
  </div>
  </ui:remove> 


</div>

 


</h:form>
<!-- The Modal -->
<ui:fragment rendered="${'#'}{!identity.loggedIn}">
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">${'#'}{messages.reset_password}</h4>
        <button type="button" class="close" data-dismiss="modal">&#215;</button>
      </div>
       <h:messages globalOnly="false" style = "color:red;margin:8px;" styleClass="message" id="globalMessages2"/>

      <!-- Modal body -->

      <div class="modal-body">
 <h:form>   
 
       ${'#'}{messages.forgot_form_desc}
       <br></br>
                <h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">
                    <h:outputLabel class="w3-text-light-blue" for="lostPasswordUserId">login_username</h:outputLabel>
	    <h:inputText id="lostPasswordUserId" value="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.lostPasswordUserId}" required="true"
                      class="w3-input w3-light-grey"/>
                </h:panelGrid>
        <h:commandButton class="btn btn-primary" id="resetPW" action="${'#'}{yxxxuh566xwwqqwxxxxxuserHome.doRecoverLostPassword()}"
         value="${'#'}{messages.reset_password}" />
 </h:form>

      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div> 


 <div class="modal" id="termsOfUse">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">${'#'}{messages.terms_of_use}</h4>
        <button type="button" class="close" data-dismiss="modal">&${'#'}215;</button>
      </div>

      <!-- Modal body -->

      <div class="modal-body">
       <ui:include src="signupTerms.xhtml"/>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

   </div>
  </div>

 </div>


</ui:fragment>

 </ui:define> 
</ui:composition>


</#if>
</#if>


