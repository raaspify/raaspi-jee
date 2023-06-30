/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rcomputer.genapp.action;

//import com.outjected.email.api.SessionConfig;
//import com.outjected.email.impl.SimpleMailConfig;
import com.rcomputer.genapp.action.SessionConfig;
import com.rcomputer.genapp.action.SimpleMailConfig;

/**
 * 
 * original author Cody Lerum
 * 
 */
public class TestMailConfigs {

    public static SessionConfig standardConfig(String host,int port,String userName,String password,boolean auth,boolean tls,String auth_mechanisms) {
        final SimpleMailConfig mailConfig = new SimpleMailConfig();
        mailConfig.setServerHost(host);
        //mailConfig.setServerHost("smtp.sendgrid.net");
        //mailConfig.setServerPort(465); f
        mailConfig.setServerPort(port);
        //mailConfig.setServerPort(587);
        mailConfig.setUsername(userName);
        //mailConfig.setUsername("apikey");
        mailConfig.setPassword(password);
        //mailConfig.setPassword("SG.B**Bg");
        mailConfig.setAuth(auth);
        mailConfig.setAuth_mechanisms(auth_mechanisms);
        //mailConfig.setAuth(true);
        //mailConfig.setEnableTls(true);
        mailConfig.setEnableTls(tls);
        //mailConfig.setEnableSsl(false);
      /*
        String mailSessionName=mailConfig.getJndiSessionName();
        Session session = (Session) ic.lookup(mailSessionName);
      */

        return mailConfig;
    }

    public static SimpleMailConfig gmailConfig() {
        SimpleMailConfig mailConfig = new SimpleMailConfig();
        mailConfig.setServerHost("localhost");
        mailConfig.setServerPort(8978);
        mailConfig.setUsername("test");
        mailConfig.setPassword("test12!");
        mailConfig.setAuth(true);
        return mailConfig;
    }
}
