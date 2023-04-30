term RAASPI came from a concept called RAAS ie Ready Application As A Service which takes SAAS ie Software As A Service to its next level.

RAASPI offers predefined workflow models for many of the business applications including Small Business, ERP, Manufacturing, Agency, Clubs & Associations, Event Organizers. RAASPI is a multi tenant and multifunction ready application which can be used by ecommerce vendors, system integrators for their customers and companies for their departmental use.   
To use RAASPI as a product, please refer to this repository releases and download the binary suitable for your need. You also have the option to use the docker image version.
For quick non production tryouts, select release 1.0 raaspi-tomee-hsqldb. For production we recommend release 2.0 raaspi-tomee-psqldb or release 3.0 raaspi-wildfly-psqldb.

If you are a developer and interested in contributiong to RAASPI for further development or make changes for your own usage, please read on.  
RAASPI source code is generated from freemarker templates and predefined models for many of the business applications including Small Business, ERP, Manufacturing, Agency, Clubs & Associations, Event Organizers. 

Raaspi github repository is slightly different from a typical java project repository. Raaspi source is generated from templates and from datatables, so the developers should not work with and modify the generated source, as it will be overwritten. The repository directories src or view under r3-gen holds the templates and  directories like java, webapp under r3-gen/projects holds the final source.

So the development for Rasspi is a two step process-first modify templates and then generate source. Advantage is reusing logic and maintaining less code.
github repository has a dir r3-gen which holds the templates in src dir, view dir and supporting resources in resources dir. Generated source goes into projects/genappcdi dir.

The following gives detailed steps to generate RAASPI source.
Summary:
The generation process uses hibernate reverse engineering and needs postgresql database and tables and freemarker based templates.
The mvn command to generate source is mvn clean generate-sources. This first generates model classes using r3-reveng.xml and database tables.
Then it generates action classes containing business logic and reports etc using freemarker templates and the model classes.
The above command needs all the data base tables to be available so that it can create the model classes.
There are generate.bat, generate.sh and generate-ee.bat,generate-ee.sh for convenience. The -ee produces scaled down RAASPI product and meant for Ecommerce only.   
Details:
Steps 1 to 4 are needed once, at the begining. Once done
Step 1. Install postgresql locally.
Step 2. Download fatajar, run.bat or run.sh from assets under release 2 named raaspi-tomee-psqldb
Step 3. Create a dir say C:\genapp-tomee-psqldb-run-fatjar and copy the fatjar and run file into the dir. Modify run file to match postgresql settings.
Step 4. execute run file to invoke ROOT-exec.jar and RAASPI App will come up and then use localhost:8080 on a browser.
 It will detect it is a new installation and will create a schema called genapp and many tables under it. 
Step 5. Optionally, change the templates

Step 6. Once the schema and the tables exist, run generate.bat or sh generate.sh to invoke mvn clean generate-sources. This generates sources from templates and using r3-reveng.xml
the output is in r3-gen\projects\genappcdi and structured in a way 
to be copied and used as input to standard maven project build source dirs ie java, resources and webapp.
It also produces report-templates dir to hold jasper report templates ie jrxml files.

Any non app but Runtime config files are held in r3-gen\resources dir, examples being tomee or wildfly dir. 
Along with the generated source files, these config files will be used to produce the application binaries.
See separate repoositories like genapp-mvn-tomee-hsqldb-make-fatjar for more information.

TLDR:This repository is used to generate new source code for new functions or bug fixes for RAASPI application.
The generation process uses hibernate reverse engineering and needs postgresql database and tables and freemarker based templates.
Separate repositories exist which takes this source files and configuration files to create ready to use application for Tomee or Wildfly appserver. 
