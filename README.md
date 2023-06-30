# Introduction
Term RAASPI came from a concept called RAAS ie Ready Application As A Service which takes SAAS ie Software As A Service to its next level.
RAASPI offers predefined workflow models for many of the business applications including Small Business, ERP, Manufacturing, Agency, Clubs & Associations, Event Organizers. RAASPI is a multi tenant and multifunction ready application which can be used by ecommerce vendors, system integrators for their customers and companies for their departmental use.   

## Using the product
To use RAASPI as a product, please refer to this repository releases and download the binary suitable for your need. You also have the option to use the docker image version.
For quick non production tryouts, select release tomee-hsqldb named raaspi-tomee-hsqldb. For production we recommend release tomee-psqldb named raaspi-tomee-psqldb or release wildfly-psqldb named raaspi-wildfly-psqldb.

## Enhance or modify the product
If you are a developer and interested in contributing to RAASPI for further development or make changes for your own usage, please read on.  
RAASPI source code is generated from freemarker templates and predefined models for many of the business applications including Small Business, ERP, Manufacturing, Agency, Clubs & Associations, Event Organizers. 

Raaspi github repository is slightly different from a typical java project repository. Raaspi source is generated from templates and from data tables, so the developers should not work with and modify the generated source, as it will be overwritten. The repository directories src or view under r3-gen holds the templates and  directories like java, webapp under r3-gen/projects holds the final source.

So the development for Rasspi is a two step process-first modify templates and then generate source. Advantage is reusing logic and maintaining less code.
github repository has a dir r3-gen which holds the templates in src dir, view dir and supporting resources in resources dir. Generated source goes into projects/genappcdi dir.

The following gives detailed steps to generate RAASPI source.
### Summary:
The generation process **step1** uses hibernate reverse engineering and needs postgresql database and tables and freemarker based templates .
For **step 2**, the mvn command to generate source is mvn clean generate-sources. This first generates model classes using r3-reveng.xml and database tables.
Then it generates action classes containing business logic and reports etc using freemarker templates and the model classes.
The above command needs all the data base tables to be available so that it can create the model classes.
There are generate.bat, generate.sh and generate-ee.bat,generate-ee.sh for convenience. The -ee produces scaled down RAASPI product and meant for Ecommerce only.   

### Details:
Steps 1 to 4 below, are needed once, at the beginning. They are needed to make sure tables exist and model pojos are created using reveng.xml and the tables.
Step 1. Install postgresql locally. 
Step 2. Download fatajar, run.bat or run.sh from assets under release 2 named raaspi-tomee-psqldb  
Step 3. Create a dir say C:\genapp-tomee-psqldb-run-fatjar and copy the fatjar and run file into the dir. Modify run file to match postgresql settings.  
Step 4. execute run file to invoke ROOT-exec.jar and RAASPI App will come up and then use localhost:8080 on a browser.  
 It will detect it is a new installation and will create a schema called genapp and many tables under it. 
Step 5. Optionally, change the templates

Step 6. Once the schema and the tables exist, run generate.bat or sh generate.sh to invoke mvn clean generate-sources. This generates sources from templates and using r3-reveng.xml
the output is in r3-gen\projects\genappcdi and structured in a way 
to be copied and used as input to standard maven project build source dirs ie java, resources and webapp.
For generate to work, r3-gen/build-r3gen.properties file connection values must match the local postgresql connection values.  
It also produces report-templates dir to hold jasper report templates ie jrxml files.
Any non app but Runtime config files are held in r3-gen\resources dir, examples being tomee or wildfly dir. 
Along with the generated source files, these config files will be used to produce the application binaries.


The following gives detailed steps to produce javaDoc for the generated RAASPI java source.  
windows  
Generate file list:  
cd C:\genapp-mvn-create-fatjar-source\r3-gen\projects\genappcdi\java

dir /s /b *.java > file.lst

Generate javadoc: in dir javadocs
cd C:\genapp-mvn-create-fatjar-source\r3-gen\projects\genappcdi\java
if file.list exists  

javadoc -d javadocs -author -version -nonavbar  @file.lst

unix
find . -type f -name "*.java" | xargs javadoc -d javadocs -author -version -nonavbar

## RAASPI concept:
Concept of RAAS (Ready Application As Service) is based on a very simple idea. 
If you think about it, most of the business functions follow a pattern The pattern is that we have some Item and some one like a Vendor supplies or produces it
and someone like a Customer will buy or use it. And there are established process to carry out these buying and selling operations.
We also need Employee who runs the operation or business.
The pattern we just described applies to many applications. This pattern applies equally for a retailer who sells some merchandise as well as to an event
organizer who sells event tickets. Even a bug or issues tracking system follows the same pattern.
RAASPI utilizes this concept and generates the necessary code for a ready to use application using the following algorithm.

### RAASPI application generation algorithm: 
1. Define data models and store as r3-gen-reveng.xml. Models will support a specific business application or many of the business applications including Small Business, ERP, Manufacturing, Agency, Clubs & Associations, Event Organizers.
 r3-gen-reveng.xml  under the resources dir has prefixes for the table and column names to control the code generation.
2. Define templates for the logic as well as for the views. We will be using freemarker templates ie files ending with .ftl but other alternatives can be used.
3. Define resources including javascripts, images, style sheets etc.
4. Use maven and ant task to utilize hibernate reverse engineering process, which will take in the model definations, resources and the templates and output the
 target code language and view definitions. We will be using java and .xhml and .xml configuration files. 
5. There is a final step to take the source and configuration files and other supporting files to create the binary meant for different run environment. 
 Examples Tomee or Wildfly Appserver and postgresql or hsqldb.
A separate initiative is underway to use Node.js /Express and postgresql.

## TLDR:
This repository is used to generate new source code for new functions or bug fixes for RAASPI application. For convenience, it also contains releases for
downloading ready to use application as binary files.
The application generation process uses hibernate reverse engineering and needs postgresql database and tables and freemarker based templates.
Separate repositories exist which takes the generated source files and configuration files to create ready to use application for Tomee or Wildfly appserver as binary files.
