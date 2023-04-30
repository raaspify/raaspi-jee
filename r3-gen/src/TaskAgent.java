package com.rcomputer.genapp.action;

import java.util.List;
import java.util.logging.Level;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * 
 */
@Startup
@Singleton
//@RunAs(RolesHelper.ROLE_SYSTEM)
public class TaskAgent {
     @Inject
     SqlSupport sqlSupport;

   private Logger log = Logger.getLogger(TaskAgent.class.getCanonicalName());
/*
	@EJB
	private SystemStatusService systemStatusService;

	@EJB
	private AuditService auditService;

	@EJB
	private MailService mailService;
*/

	//@Schedule(second = "0, 10, 20, 30, 40, 50", minute = "*", hour = "*")
	@Schedule(second = "0", minute = "0", hour = "23")
	//@Schedule(second = "0", minute = "*/5", hour = "*")
	//@Schedule(second = "0", minute = "0", hour = "*/1")
        //tbd we can use the dynamic version of @Schedule by using the ScheduleWxpression class if
        // once a day at a fixed time needs to be parameterized via say web.xml or via database config
	public void checkSystemStatus() {
		try {
			//List<SystemStatusEO> listSystems = systemStatusService.getAllSystemStatus();
			log.info("taskAgent invoked " );
                        sqlSupport.backupTenants();
			log.info("backup done " );
                        sqlSupport.emailReminders("email");
			log.info("email Reminders done " );

                 /*
			for (SystemStatusEO system : listSystems) {
				AbstractSystem content = SystemStatusFactory.getSystemStatusObject(system);
				boolean changed = content.executeCheck();
				log.info("taskAgent invoked " );
				if (changed) {
					system.setContent(content.marshal());
					systemStatusService.save(system);
					broadcastSystemStatusChanged(system, content.getReadableStatus(system));
				}
                  
			}
                 */ 

		} catch (Exception ex) {
			log.severe("taskAgent error "+ex.getMessage());
		}
	}
/*
	private void broadcastSystemStatusChanged(SystemStatusEO status, String content) throws FablabException {		
		//insert int audit
		AuditUtils.addAudit(auditService, AuditObject.SYSTEM_STATUS, AuditAction.UPDATE,
				true,
				content);

		if (status.isNotify()) {
			//send mail
			mailService.sendMail("gaetancollaud@gmail.com", "System status changed", "System status changed : "+content);
		}
	}
*/

}