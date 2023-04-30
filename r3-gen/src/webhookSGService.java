package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;
import org.picketlink.Identity;
import javax.persistence.*;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import javax.faces.view.ViewScoped;
import javax.transaction.Transactional;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
//import javax.persistence.EntityManager;
import java.util.GregorianCalendar;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.google.gson.FieldNamingPolicy;


/**
 * @author 3R Computer 
 */
@Named("webhookSGService")
//@ViewScoped
//@SessionScoped
//@ApplicationScoped
@Transactional
@ApplicationPath("rest")
@Path("/sg")
public class webhookSGService extends Application implements java.io.Serializable
{
     private String owner2Code="";
     private int urlIndex=0;
     private String select="m";
     private String data="a";
     private String selectdata="ma";


   private Logger log = Logger.getLogger(Fpxxfq1a5xwwqqhxxxxxitem.class.getCanonicalName());
	@Inject
	Identity identity;
	@Inject
	Yxxxuq1m1xwwqqqxxxxxclobdataHome yxxxuq1m1xwwqqqxxxxxclobdataHome;
	Yxxxuq1m1xwwqqqxxxxxclobdataList yxxxuq1m1xwwqqqxxxxxclobdataList;
	private Yxxxuq1m1xwwqqqxxxxxclobdata yxxxuq1m1xwwqqqxxxxxclobdata;

   @PersistenceContext(unitName = "genappcdi")
   private EntityManager entityManager;
   //@Consumes specifies what MIME type a resource accepts from the client
   //@Produces, however, specifies what MIME type a resources gives to the client.
   // For example, a resource might accept application/json (@Consumes) and return text/plain (@Produces).
   @POST
   @Produces("application/json")
   @Consumes("application/json")
   public Response getItems(String request)
   {
    //comes as json array [] of json objects {}
/*
[
   {
      "email":"example@test.com",
      "timestamp":1513299569,
      "smtp-id":"<14c5d75ce93.dfd.64b469@ismtpd-555>",
      "event":"dropped",
      "category":"cat facts",
      "sg_event_id":"zmzJhfJgAfUSOW80yEbPyw==",
      "sg_message_id":"14c5d75ce93.dfd.64b469.filter0001.16648.5515E0B88.0",
      "reason":"Bounced Address",
      "status":"5.0.0"
   }
]
[
   {
      "email":"example@test.com",
      "timestamp":1513299569,
      "smtp-id":"<14c5d75ce93.dfd.64b469@ismtpd-555>",
      "event":"bounce",
      "category":"cat facts",
      "sg_event_id":"6g4ZI7SA-xmRDv57GoPIPw==",
      "sg_message_id":"14c5d75ce93.dfd.64b469.filter0001.16648.5515E0B88.0",
      "reason":"500 unknown recipient",
      "status":"5.0.0"
   }
]
[
   {
      "email":"example@test.com",
      "timestamp":1513299569,
      "smtp-id":"<14c5d75ce93.dfd.64b469@ismtpd-555>",
      "event":"spamreport",
      "category":"cat facts",
      "sg_event_id":"37nvH5QBz858KGVYCM4uOA==",
      "sg_message_id":"14c5d75ce93.dfd.64b469.filter0001.16648.5515E0B88.0"
   }
]

*/
          int fCount=0;
          String ownercode="webhook";
          String client="";
          String email="";
          String reason="";
          //String event="";

          String fList="";
 	  try {

		 //ClientResponse<String> response = request.get(String.class);
                 //String respString= response.getEntity(String.class);
                 if(request == null){
                  return Response.status(400).build();
                 }
                 JsonElement jelement = new JsonParser().parse(request);
                 JsonArray jarray = jelement.getAsJsonArray();

                 //JsonObject jobject = jarray.getAsJsonObject();
                 for (JsonElement pa : jarray) {
                  fCount=fCount+1;
                  JsonObject jobject = pa.getAsJsonObject();
                  if(jobject.get("email") !=null){
                   email     = jobject.get("email").getAsString();
                  }
                  //event     = jobject.get("event").getAsString();
                  if(jobject.get("reason") !=null){
                   reason     = jobject.get("reason").getAsString();
                  }
                  client="unknown";
                  if(jobject.get("category") !=null){
                   client    = jobject.get("category").getAsString();
                  }
                  log.severe("mail failure "+ email+" , "+reason+" , "+client+" -check MAIL-SENT in text data for mail content");
                  // jay write to clobdata MAIL-FAILED 
                  //nov13 2018 send can fail/blocked, so keep a copy in clob after send, data is available after send 
                  //MAIL-FAILED used by icalsend and system send, MAIL-CONTENT used by customer/ventor/employee Mailing
	          // do not reuse but new seq because unlike MAIL-CONTENT, no control when gets created and overwritten
                  // automatic purge of these and others if date is old
                  // 
                  if( fCount <2 ){
                   /*
		   try {
                    yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
                    yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		    yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		    yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		    yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("yxxxuq1m1xwwqqqxxxxxclobdata");
                    int jay=yxxxuq1m1xwwqqqxxxxxclobdataList.getNextSeqAvailable("clobdata","AMAIL-FAILED",ownercode,0);
		    yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(jay);
		    yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-FAILED");
		    //yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                    yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata("to: "+email+" reason: "+reason);
                    yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                    if(client.equals("unknown"){
                     owner2Code="raaspi";
                     yxxxuq1m1xwwqqqxxxxxclobdata.setY3xxuxznbvxxxxxxxxxxnotes("email category empty/unknown site");
                    }else{
                     owner2Code=client;
                    }
                    yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                   }catch (Exception ex){
		    log.severe("Error saving mail-failed for "+client+", "+ ex);//continue, user need not know
                   }
                   */
                  }
                  if(fCount < 501){
                   fList=fList+email+" "+reason+", ";
                  }
                }//loop. give failure list
                   /*
		   try {
                    yxxxuq1m1xwwqqqxxxxxclobdataHome.clearInstance();
                    yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		    yxxxuq1m1xwwqqqxxxxxclobdata = yxxxuq1m1xwwqqqxxxxxclobdataHome.getInstance();
		    yxxxuq1m1xwwqqqxxxxxclobdataHome.setInstance(yxxxuq1m1xwwqqqxxxxxclobdata);
		    yxxxuq1m1xwwqqqxxxxxclobdata.setA0xxukcdlvxxxxxxxxxxfromtable("yxxxuq1m1xwwqqqxxxxxclobdata");
                    int jay=yxxxuq1m1xwwqqqxxxxxclobdataList.getNextSeqAvailable("clobdata","AMAIL-FAILED",ownercode,0);
		    yxxxuq1m1xwwqqqxxxxxclobdata.setA3xxexnsbvxxxxxxxxxxsequence(jay);
		    yxxxuq1m1xwwqqqxxxxxclobdata.setA1xxuxxxbv49xxxxxxxxfromkey("MAIL-FAILED");
		    //yxxxuq1m1xwwqqqxxxxxclobdata.setA2xxuxxxbv50xxxxxxxxqualifier(ownerCode);
                    yxxxuq1m1xwwqqqxxxxxclobdata.setB1xxuzaxbvxxxxxxxxxxdata("Mail failed Count: "+fCount+" For (upto 500) : "+fList);
                    yxxxuq1m1xwwqqqxxxxxclobdata.setA4xxexxxbvxxxxxxxxxxtype("txt");
                    owner2Code=client;
                    yxxxuq1m1xwwqqqxxxxxclobdataHome.persist();
                   }catch (Exception ex){
		    log.severe("Error saving mail-failed for "+client+","+ ex);//continue, user need not know
                   }
                   */ 

                return Response.status(200).build();
                //Response.status(200).entity("blah blah").build() or Response.status(200).entity("[{}]").build()
	  } catch (Exception e) {
            log.severe("webhook error"+ e.getMessage());

	  }
            return Response.status(400).build();

      
   }
@POST
@Path("/send")
@Consumes("application/json")
public Response consumeJSON() {



    return Response.status(200).build();

}

}
