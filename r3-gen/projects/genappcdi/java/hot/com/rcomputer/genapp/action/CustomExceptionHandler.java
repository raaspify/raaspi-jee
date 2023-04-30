
package com.rcomputer.genapp.action;
import java.util.logging.Logger;
import com.rcomputer.genapp.action.*;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextWrapper;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.FacesException;
import java.util.Iterator;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.inject.Named;
import javax.inject.Inject;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private Logger log = Logger.getLogger(CustomExceptionHandler.class.getCanonicalName());
    private ExceptionHandler wrapped;
    @Inject CustomIdentity customIdentity;
    CustomExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context
                    = (ExceptionQueuedEventContext) event.getSource();

            // get the exception from context
            Throwable t = context.getException();

            final FacesContext fc = FacesContext.getCurrentInstance();
            final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
            final NavigationHandler nav = fc.getApplication().getNavigationHandler();

            //here you do what ever you want with exception
            try {

                //log error ?
                if (customIdentity == null || customIdentity.isDebug()){
                 log.severe("Critical Exception!"+ t.getMessage());
                } 
                if (t instanceof ViewExpiredException) {
                    requestMap.put("javax.servlet.error.message", "Session expired, try again!");
                    String errorPageLocation = "/error-expired.html";
                    fc.setViewRoot(fc.getApplication().getViewHandler().createView(fc, errorPageLocation));
                    fc.getPartialViewContext().setRenderAll(true);
                    fc.renderResponse();
                } else {
                    //redirect error page
                    requestMap.put("javax.servlet.error.message", t.getMessage());
                    nav.handleNavigation(fc, null, "/error-exception.html");
                }

                fc.renderResponse();
                // remove the comment below if you want to report the error in a jsf error message
                //JsfUtil.addErrorMessage(t.getMessage());
            } finally {
                //remove it from queue
                i.remove();
            }
        }
        //parent hanle
        getWrapped().handle();
    }
}