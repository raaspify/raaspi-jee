--version 2.0
--changes-clean start point
-- comment out if needed *******
--DROP SCHEMA genapp cascade;

--CREATE SCHEMA genapp
--  AUTHORIZATION postgres;


--***********************************************
--jay make some of the tables to support versioning ie
--optionsc,optionsp,optionsn acperiodc,acperiodp,acperiodn etc
--Allow a button (normally hidden) to switch to version 
--jay make a replace all to allow statusfl to be edited but in xxxhome put extra check to allow only say mark flag boolean
-- Following naming convention will be used to allow hbm2java using templates as well as for Menuing
--Table entity names (not the sql table name) ist 10 characters reserved for the following
--            1-4th digit Menu related info ,5-6 usage related and  7 & 9th digits for menu groupings under a dropdown menu
--            8-along with 7th digit defines entity function 61 for account,62 for account period etc  
--            9-menu position within group(7th digit)
--            10-future
--            Group orFunction 
--            Type of    
--            usage                                                    5-6th digits
--            A-Add              S-Administration  Z-web service       U,I,K,E,S,V,B-UI,C-US,D-UE(Roles User,Admin User,Support,Data Access/Repair,
--                                                                      Admin System,Visitor/Guest)
--            L-List             B-Label                               H,Q,W (Level High,Medium,Low)            
--            T-Transaction      P-Messaging
--            G-Graphs           Y-Maintenance   
--            N-Generate         E-Master O-Details(hidden from menu) 
--            R-Report           x-Skip           
--            M-Mailing          V-Custom/Future                  
--            C-Add & List, D-Add,List & Report, F-ALRB J-ALRBM Z-? digits in pos 1-4 ?
--            unused characters are H,I,K,Q,U,W          
--            1-4 characters control menu, at this time does not control buttons inside a page, so via print can still invoke
--            Report even though Report is not on the menu for an entity.
--            5-6 digits User role for all user related functions but not creating other users, Admin Users can create other users and related
--            Employee,Vendor,Customer,Client(restructed) and maintain tables.
--            Support role to be created temporarily for specific support ticket and data access very restricted maybe upto  two
--            further controlled by level as it allows seeing and entering data like journal data
--            Admin user can create data access role but should be assigned to some other person part of audit group
--            at client registration one Admin User will be created ie IH
--            7-8 7th digit to be used to group under the drop down or as submenus, also gives hints about functions
--            1-Item,address etc, 2 customer, 3 vendor, 4 employee, 5 client,options,Group 6 account 7 payroll 8 Schedule 9 Machine Job
--            A-Generate B-Future
--            x-do not show in menu
--          
-- 
--            
--            8th digit to order the placement within a group  
--            value 0 is reserved for as 1st entry and to designate main entity function of a group
--            for example 60 will mean Account entity, 10 will mean Item whereas 61 can be used for account or for account period
--            values 1 to a or b to i where B to I values will be for overflow placement under second drop down list 
--            example Jxxxuq14location where 1 in pos 7 means group 1 and 4 in pos 8 means vertically 4th down.
--            Note: physically ,it could be 7th down, if there are a few tables with the same 7&8 position values say
--            12,12 etc. 
--            example Fxxxuq8bschedule where value 8 is for schedule and value b means 1st pos but in 2nd nenu group
--            under Add or List or transaction as applicable. 
-- Table name prefixes are for Menuing only and for Report generation, Entity Functions or Entity identification
--              are via key field names prefix via position 6-7
-- change aug 14 2013 use postion 7 and 8 for entity function and migrate from using key field pos 6-7
-- account related 60-account,61
-- 111xaddress 122xdepartment  133xdivision 144xlocation 155xresidency 166xitembom 177xxcontrolusagebyperiods   
-- 188xactivity 195xitemtemptype 1a5xitem 1bhxusagebyperiods 1c3xcontrol 1d3xcompany 
-- 1ffxserialnumbers 1ggxmembersgroup 1hhxitembomdetails 1iixscandate 1kktask 1m1xclobdata 1n1xblobdata 1pxactivityjob 1qxxnextserialno
-- 201xcustomer 21bxccontact 233xcuquote 244xcuorders 255xshipment 266xcuinvoice
-- 277xcpayment 284xcupdetails 295xshipmentdetails 2a4xcuidetails 2b4xcuodetails 2c4xcuqdetails 2drxresourcedetails 
-- 300xvendor 31bxvcontact 333xvenquote 344xvendorders 366xvenartha
-- 377xvshipmen 388xvpayment 399xvshipmendetails 3a6xvinvoice 3b4xvendpdetails 3c4xvendidetails 3d4xvendodetails 3e4xvendqdetails
-- 400xemployee 444xemplorders 454xemplodetails
-- 511xoptions 522xclient 53dxrollupgroup 54exgroupmembers 555xholiday 566xuser 575xuserprofl 582xgenoptions 59xxrate1f
-- 601xaccount 621xacperiod 632xperioddates 643xacintegr 65exgentries 675xcjournal 685xjournal 69jxjjournal 6ahxhlogfile 
-- 711xwageearner 722xarthatbl 732xarthahist 742xwageearneraux
-- 82bxeditlog 89bxschedule  8axxproject 8bxxoutline
-- 92bxitemjob 932xactivityjob 943xactivityjobdetails 9aaxjobassignment 9ddxitemjobdetails 9eexmachine
-- a1rxgenapp a2rxgendb a3rxgentable a4rxgenfields
--   
-- jay add extra pass to go through all entities and their properties to create include file showing
-- variables for entity function and value being the entity name                       
--Field names ist 12 characters reserved for the following:
--1st character ascending order 1 for the field display. use Alphabets like A,B,C etc and Y(last input fields) for the
--              less used fields which can be hidden under a clickable panel,Z (last calculated fields for display)
--              The fields are processed in ascending order, so names starting w y or z will allways be under 
--              collapsible panel and can be intermixed with other fields in reveng xml
--              however x in 9th position will hide (rendered=false)
--              d in 6th character will also hide ?
--              Also foreign fields are allways shown as drop down and at the begining even if they 
--              have y etc
--2nd character ascending order 2 for finer level ordering and grouping, use 1,2,3,4 etc. ist and 2nd characters could
--              be A1,A2 etc.
--              group start could be G and end of a group could be N, if special logic to be used, otherwise A1,A2 etc
--              will mean group A and B1,B2 etc will imply group B.
--3rd character focus sequence ie where cursor will rest
--              <a4j:commandLink value="Set Focus" focus="text" />
--              <h:inputText value="Hello" id="text" />
--              or <body onload="document.formName.elements[2].focus();">
--              g means <h:panelGroup id="xx"> e means </h:panelGroup>
--
--4th character future    X will mean not used
--5th character initial values E for one 0 otherwise for Numeric field, for Boolean T for True F or any non T for False shown as boolean
--              check box , Y/N as RadioButton C with Current Time 
--              D for Current Date without time (Display) otherwise with Time, N for Next Day & Time,U for null, Z same as X
--              P current posting period # F means null and 1st value of options ie pre selected
--              no initial value but G to indicate using genoptions (in 11-12 pos) for listmenu dropdown, H to indicate options 
--              combobox , no G or H but values in pos 11-12 means use listmenu dropdown. combo allows data entry but no label
--              list menu drop allows label but no data entry.So for gen options use list menu for options use combo (use field
--              name as if label unless no flexibility is needed. Both will have digits in 11-12 but H or G in 5th pos 
--              if foreign key field then both G on 5th or D on 6th  will mean combo box.
--6th character -Used to describe primary or or other type key related fields or for non key indicate additional
--               Required fields. 7th character is used in conjunction with the 6th character
--              k composite or non composite Key in field,S if subkey field to form non composite key K , X skip,
--              N composite or non composite key field value comes from the client field also having C1C2 (7th & 8th pos values),
--              C1C2 implies functions. t for existing foreign field to act as natural key(s)
--              O (oh) composite or non composite key auto incrementing field, C1C2 (3rd & 4th pos values ignore R if conflict) C1 start value C2 increment 
--              D is a Required Foreign field shown as Select Field (not ComboBox) as a convenience  & can be part of the Primary key or not. If Primary key then
--              the field is part of a composite key and is part of ID entity. If a field is D then it will be hidden to avoid showing the field
--              twice, one as part of select and the other as part of the instance-jay remove this logic of D for key fields as they are reqd   . If not part of the composite key this field can be null ie not used  
--             
--                 
--              R Required Field but no select ie Not a foreign key field
--              Required means Validity checking will be done 
--              All foreign fields and onetomany fields are shown at the bottom of the Edit form to be selected. But Select at top via D can be used for
--              Frequently used Foreign key Fields to make it user friendly. 
--              F means Foreign field to be selected like D and validated  and shown but used as a subkey Hint for keyed in Primary Key value. 
--                Can be overwritten or not used as key.Example using Employee field for Artha key. it combines D & S functions
--              G means reqd field like D and validated , shown as drop down 
--                Unlike D or F , it allows for not explicitly selecting every time, since a value is already put in and makes it user friendly.
--              Use X If it is a foreign key Field but no special action    
--              H 2nd usage of a foreign key ,Example mailto & ship to 
--              non key usage described below-------
--              If regular fields ie not key related or not required, use it to describe field function as below
--              P for Order/SELL Price ,1,2,3 for TAX1,2,3 L for Delivery, M for Misc  Q for Qty ordered/invoice/paid, C for Cost price 
--              U for UNit,V vendor T EMPLOYEE R customer I for ITEM A for Activity  (If drop down needed put them as 3rd ch)
--              ,OX Division E Department,W for Account,B for Address, I for Item  
--              5t cg c then 6 th ch 
--
--              C for cost, M misc crh will never be entity
--              7th pos  A-activity B-Address c-Cost D-Reqrd Fld & shown as Select  E-Department F-Foreign G-genOption H-2nd usage of foreign key I-Item J-Journal
--              accounting journal,costing journal and job journal
--              k-composit L- Delivery M-Misc charge N-Key value from Client O-Division P-sel price Q- Qty R-Reqd but not select
--              S-SUB key T-Employee U-Unit V-Vendor W-Account X-Skip Y-OutStanding Qty? Z-? 1,2,3-Tax1,2,3
--              If key field ie 6th pos has K
--              7th pos A-activity B-Address C-Option U-usage
--              If 6th position does not have a key designator like k or N or other postions do not have S for subkeys, it means this table
--              is meant to be populated by the system as opposed to user keying in any value. Example journal, details. 
--             
--7th character if 6th ch is S then n (1,2, 9,A )ie how many characters & TRIM to use for key or T for TRIM only
--              if 6th ch is N then  value of C1  ie C of CQ  
--              if 6th ch is D or F then V vendor T EMPLOYEE R customer O for Division, E for Department,W for Account  
--               C for Company B for Address, I for Item  U User  T for Task, S for Table( what table?)  
--              if 6th ch is N      then inhibit entering any value to combobox (digits 7 &8)  
--              if 5th character is other than these ie not S,N,D,F
--              if 6th character(key) is K then G for GenOption,D for 
--              m for machine
--6-7th character
--              used to describe key and its qualifier (S1 will mean SubKey 1 field)
--              or if non key then field function and qualifier (TO where T means Employee and O for owner)
--              6th character cannot be k,s or n
--              AJ-Activity Job Allocation
--              
--              if substring move them to 7&8th pos??? 
--              CD-Cust Details VD-Vendor Details 
--              EM-Email 
--              IA -Scan Field, IC- Cost IS-SERIAL, #  IJ-Item job allocation IR-Item Period(not used) values,IB -Item BOM  
--              IQ-Item Total Qty IP-Item Total Price
--              IFY-Fed I tax Ytd IPY-prov 
--              JT-Journal Type,JM -JMSMQ 
--              LP-Line Total price
--              LT-Delivery Total (in Parent like Quote,Invoice etc) LX if detail
--              MT-Misc Total
--              PFY-Pension Federal YTD PPY-Prov pen ytd 
--              SH-Customer Shipment SV - Shipment from vendor or Receive from vendor
--              TS-Employee SIN TB-Birthdate TFC-Fed Claim TO- Owner  TPC-Prov claim TPF-Pay freq TPP-Pay period TWC-WCB flag
--              2O-owner2
--              TWY-WCB YTD TEI-Empl ins Flag TEY-empl ins Ytd TVR-Vacation flag TVY-Vacation YTD TWU-Wage Unit TWR-Wage Rate
--              TOU-Ov Time unit TOR-Over Time Rate TWS-Wage Units for this pay TOS-O/T units TWA-Wage Amount TOA-O/T Amount
--              TSO-Salary TC-Commision TV-Benefits TVA-Vacation due TVO-Vacation Payout TPA-Pay Advance TPO-Pension
--              TAT-After Tax Flag TUD-Union Dues TMD-Medical deduct TFI-Federal Income Tx TPI-Prof I Tax TPA -Actual Pay
--              TPL-Last Pay TPY-Pay YTD  TGY-Gross Pay YTD TXY-Fed Tax ytd TYY-Prov tx ytd
--              VC-Vendor contact
--              WA-Actual WAN-Actual Next WAP-Prev Actual WB-Account Budget  WBP-Prev Budget  WC-Child  WE- Period WFE-Fisc Yr end
--              WG-Category 
--              WD-Debit WK-Account key/code 
--              WM-AC INTEGR Module ID,  
--              WPS-Posting Date String WPD-Posting date WCD-Calndr dt WPP-Period WPR-AR Seq # WPP-AP seq WPL-GL seq WPA -Payroll seq
--              WPI-Inventory Control seq WPJ- Job seq WPT-Type  
--              W9-AC Integr Set ID 
--              WP-Parent WRQ-Roll up %  WR-Credit WS-Account Seq WT-Type WU-Currency W8-A/C Int Usage CODE, WVT-payroll table WYE -Cal Yr end W0-w13 Periods 
--              U-USER/LOGON IDS UA-Alevel U,A etc UB B level H,M etc UP-PW ZA-Clob
--              
--              ZB-Blob  ZC-Company name ZD-Document ZCC Company Contact ZCD-Comp Name Code ZF-Status flags   ZK-Keyword ZQ-Print status DateTime    
--              ZN- Notes  ZP-Print status Flag ZS-Description ZT-Status Datetime 
--              G01,G02,G03 etc -GenOptions Field 1,2,..  O01,O02,O03 Options F1,F2 etc 
--              Z1,2,3 Tax1,2,3    
--              b1,2,3 etc usage budget amount period 1,2 , a1,2,3 etc actual  ,bt and at for total
--              wn-no invoice
--7th & 8th     If 6th had D etc , otherwise in 6-7th jay this causes double checking, better reserve 6 for key, 7-8 for function
--     
--              entity Functions  ie 7th & 8th cq,co,ci,cp,vq,vo,vi,vp,va,eq,eo,ei,ep,sh,pi,aj(activity allocatejob),gj,aj,pj,
--              RC-Customer for contact table
--              Vc-Vendor for Contact table   
--              VV-vendor,RR Customer, TT Employee,GG Group,GM Group Member ,SS Table ,SF Table Field,DB Db,AP App 
--              B1-Addr L1 (OR 1 in 4th pos) ,AC-City or C in 8th pos,BP-Prov/state BO-Country
--              sd-start date ed-enddate dh-duration in Hrs dm-duration in mts st-start time 
--              az-Postalzip code,ac-city  
--              if 6th is key
--               GT -Gen table GF-Gen Fields CD-clob BD-Blob      
--              ns-Number Spinner   
--              
--                              
--8th character X skip,if 6th ch is N then value of C2 ie Q of CQ. 
--              entity Functions  ie 7th & 8th cq,co,ci,cp,vq,vo,vi,vp,va,eq,eo,ei,ep,sh,pi,aj(activity allocatejob),gj,aj,pj,
--              6-8 wsr-a/c start period wer end date period 
--              va-vendor artha(dhq) 
--               
--9th character A to show in ADD/UPDATE/Transaction only, L to show for List/Tran List only B to show for Both  X do not show 
--              H for EH User/role only In case an entity is both in Add and in Tran then use
--              T Transaction only ie not in A/L U for Add/Update/List onl
--              To put under collapsable panel use C (A), D(L) E(B) F(T) . Can be used for a crowded form or rarely used field. 
--
--              If regular report as well as special report like invoices are 
--10th character V to be visible for Report,X not visible for Report H for EH user/Role only 
--11th character X or N1 of options field or I for InitCap U for All UPPER or L for incrementing Line # N for Non Zero or Non Blank
--              G for Integration set instead of Options, O for Location List   
--12th character X or N2 of options field 
--              use 6th and 7th charaters for Select an entity but 11th & 12th for a dropdown combobox in conjunction with 7th(& 8th) character
--              If 6th ch is K then K to denote keyed in and not from subkeys
--  below for future for genapp usage
--13th character Type of field ie v for varchar,i for integer
--14 & 15th      length of varchar

--structure CLIENT-COMPANY-DIVISION-DEPARTMENT-EMPLOYEE-RESIDENCY 
--CLIENT-COMPANY-CUSTOMER|VENDOR|ITEM 
--CLIENT-COMPANY-CUSTOMER|VENDOR|DIVISION-DEPARTMENT-EMPLOYEE-USER contains (LOGONID)
--CLIENT-ADDRESS-LOCATION
-- CLIENT-COMPANYCOMPANY 1-div1-dep1,dep2 company1-div2-dep1,2,3 
-- CLIENT-ACINTGR|ACCOUNT GL codes PREFIXNNNNN where PREFIX can be empty and NNNN is numeric and 1000 is asset, 4000 liability etc
-- ACCOUNT will have COMPANY,DIVISION,DEPARTMENT as optional reference
-- CLIENT-COMPANY-ACPERIOD|PERIODDATES
-- CLIENT-CONTROL codes XXXXX in PROJECT
-- CLIENT-OPTIONS
-- USER-CLIENT|CUSTOMER|VENDOR|EMPLOYEE

-- cloud env via owner2 value filter
COMMENT ON 
TABLE genapp. 
ADDRESS IS 'Address for delivery or mailing';

COMMENT ON ADDRESS.SID IS 'Auto generated Id';
COMMENT ON ADDRESS.SERIAL,
COMMENT ON ADDRESS.ADDRESCODE 
varchar(32) not null, 
COMMENT ON ADDRESS.ADDRL1 
varchar(159), 
ADDRL2 
varchar(159), 
ADDRL3 
varchar(159), 
CITY 
varchar(20), 
PROVNSTATE 
varchar(20), 
COUNTRY 
varchar(20), 
PZCODE 
varchar(20), 
DESCRIPT 
varchar(120), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP,
PRIMARY 
KEY(SID) 
)
; 
--Options exist for each client via owner2 value
COMMENT ON
TABLE genapp. 
OPTIONS 
( 
SID
SERIAL,
ROW 
varchar(2) not null, 
OPTIONS01 
varchar(159), 
PURPOSE01 
varchar(159), 
VALUE01 
varchar(159), 
OPTIONS02 
varchar(159), 
PURPOSE02 
varchar(159), 
VALUE02 
varchar(159), 
OPTIONS03 
varchar(159), 
PURPOSE03 
varchar(159), 
VALUE03 
varchar(159), 
OPTIONS04 
varchar(159), 
PURPOSE04 
varchar(159), 
VALUE04 
varchar(159), 
OPTIONS05 
varchar(159), 
PURPOSE05 
varchar(159), 
VALUE05 
varchar(159), 
OPTIONS06 
varchar(159), 
PURPOSE06 
varchar(159), 
VALUE06 
varchar(159), 
OPTIONS07 
varchar(159), 
PURPOSE07 
varchar(159), 
VALUE07 
varchar(159), 
OPTIONS8 
varchar(159), 
PURPOSE08 
varchar(159), 
VALUE08 
varchar(159), 
OPTIONS09 
varchar(159), 
PURPOSE09 
varchar(159), 
VALUE09 
varchar(159), 
OPTIONS10 
varchar(159), 
PURPOSE10 
varchar(159), 
VALUE10 
varchar(159), 
OPTIONS11 
varchar(159), 
PURPOSE11 
varchar(159), 
VALUE11 
varchar(159), 
OPTIONS12 
varchar(159), 
PURPOSE12 
varchar(159), 
VALUE12 
varchar(159), 
OPTIONS13 
varchar(159), 
PURPOSE13 
varchar(159), 
VALUE13 
varchar(159), 
OPTIONS14 
varchar(159), 
PURPOSE14 
varchar(159), 
VALUE14 
varchar(159), 
OPTIONS15 
varchar(159), 
PURPOSE15 
varchar(159), 
VALUE15 
varchar(159), 
OPTIONS16 
varchar(159), 
PURPOSE16 
varchar(159), 
VALUE16 
varchar(159), 
OPTIONS17 
varchar(159), 
PURPOSE17 
varchar(159), 
VALUE17 
varchar(159), 
OPTIONS18 
varchar(159), 
PURPOSE18 
varchar(159), 
VALUE18 
varchar(159), 
OPTIONS19 
varchar(159), 
PURPOSE19 
varchar(159), 
VALUE19 
varchar(159), 
OPTIONS20 
varchar(159), 
PURPOSE20 
varchar(159), 
VALUE20 
varchar(159), 
OPTIONS21 
varchar(159), 
PURPOSE21 
varchar(159), 
VALUE21 
varchar(159), 
OPTIONS22 
varchar(159), 
PURPOSE22 
varchar(159), 
VALUE22 
varchar(159), 
OPTIONS23 
varchar(159), 
PURPOSE23 
varchar(159), 
VALUE23 
varchar(159), 
OPTIONS24 
varchar(159), 
PURPOSE24 
varchar(159), 
VALUE24 
varchar(159), 
OPTIONS25 
varchar(159), 
PURPOSE25 
varchar(159), 
VALUE25 
varchar(159), 
OPTIONS26 
varchar(159), 
PURPOSE26 
varchar(159), 
VALUE26 
varchar(159), 
OPTIONS27 
varchar(159), 
PURPOSE27 
varchar(159), 
VALUE27 
varchar(159), 
OPTIONS28 
varchar(159), 
PURPOSE28 
varchar(159), 
VALUE28 
varchar(159), 
OPTIONS29 
varchar(159), 
PURPOSE29 
varchar(159), 
VALUE29 
varchar(159), 
OPTIONS30 
varchar(159), 
PURPOSE30 
varchar(159), 
VALUE30 
varchar(159), 
OPTIONS31 
varchar(159), 
PURPOSE31 
varchar(159), 
VALUE31 
varchar(159), 
OPTIONS32 
varchar(159), 
PURPOSE32 
varchar(159), 
VALUE32 
varchar(159), 
OPTIONS33 
varchar(159), 
PURPOSE33 
varchar(159), 
VALUE33 
varchar(159), 
OPTIONS34 
varchar(159), 
PURPOSE34 
varchar(159), 
VALUE34 
varchar(159), 
OPTIONS35 
varchar(159), 
PURPOSE35 
varchar(159), 
VALUE35 
varchar(159), 
OPTIONS36 
varchar(159), 
PURPOSE36 
varchar(159), 
VALUE36 
varchar(159), 
OPTIONS37 
varchar(159), 
PURPOSE37 
varchar(159), 
VALUE37 
varchar(159), 
OPTIONS38 
varchar(159), 
PURPOSE38 
varchar(159), 
VALUE38 
varchar(159), 
OPTIONS39 
varchar(159), 
PURPOSE39 
varchar(159), 
VALUE39 
varchar(159), 
OPTIONS40 
varchar(159), 
PURPOSE40 
varchar(159), 
VALUE40 
varchar(159), 
OPTIONS41 
varchar(159), 
PURPOSE41 
varchar(159), 
VALUE41 
varchar(159), 
OPTIONS42 
varchar(159), 
PURPOSE42 
varchar(159), 
VALUE42 
varchar(159), 
OPTIONS43 
varchar(159), 
PURPOSE43 
varchar(159), 
VALUE43 
varchar(159), 
OPTIONS44 
varchar(159), 
PURPOSE44 
varchar(159), 
VALUE44 
varchar(159), 
OPTIONS45 
varchar(159), 
PURPOSE45 
varchar(159), 
VALUE45 
varchar(159), 
OPTIONS46 
varchar(159), 
PURPOSE46 
varchar(159), 
VALUE46 
varchar(159), 
OPTIONS47 
varchar(159), 
PURPOSE47 
varchar(159), 
VALUE47 
varchar(159), 
OPTIONS48 
varchar(159), 
PURPOSE48 
varchar(159), 
VALUE48 
varchar(159), 
OPTIONS49 
varchar(159), 
PURPOSE49 
varchar(159), 
VALUE49 
varchar(159), 
OPTIONS50 
varchar(159), 
PURPOSE50 
varchar(159), 
VALUE50 
varchar(159), 
OPTIONS51 
varchar(159), 
PURPOSE51 
varchar(159), 
VALUE51 
varchar(159), 
OPTIONS52 
varchar(159), 
PURPOSE52 
varchar(159), 
VALUE52 
varchar(159), 
OPTIONS53 
varchar(159), 
PURPOSE53 
varchar(159), 
VALUE53 
varchar(159), 
OPTIONS54 
varchar(159), 
PURPOSE54 
varchar(159), 
VALUE54 
varchar(159), 
OPTIONS55 
varchar(159), 
PURPOSE55 
varchar(159), 
VALUE55 
varchar(159), 
OPTIONS56 
varchar(159), 
PURPOSE56 
varchar(159), 
VALUE56 
varchar(159), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID),
UNIQUE (ROW,OWNER2) 
); 
--clientid is stored as owner2
CREATE 
TABLE genapp. 
CLIENT 
( 
COMMENT ON ADDRESS.SID IS 'Auto generated Id';
SERIAL,
CLIENTVERSION 
varchar(5) not null, 
SERIALNUM 
varchar(15), 
ENTERPRISECOMPANYNA 
varchar(35), 
DESCRIPT 
varchar(120), 
ADDRL1 
varchar(35), 
ADDRL2 
varchar(35), 
ADDRL3 
varchar(35), 
CITY 
varchar(20), 
PROVNSTATE 
varchar(20), 
COUNTRYNAME 
varchar(20), 
PZCODE 
varchar(20), 
PHONEO 
varchar(30), 
PHONEH 
varchar(25), 
PHONEC 
varchar(25), 
PHONEX 
varchar(30), 
LANADDR 
varchar(35), 
WANADDR 
varchar(35), 
LMAILADDR 
varchar(35), 
IMAILADDR 
varchar(60), 
RMAILADDR 
varchar(35), 
INTADDR 
varchar(35), 
INRADDR 
varchar(35), 
ENTERPRISECOMPCODE 
varchar(15), 
ENTERPRISECOMPCONT 
varchar(15), 
VENDCODE 
varchar(15), 
BARCSIZE 
varchar(12), 
MATCOLEN 
INT, 
SERIALEN 
INT, 
JOBNOLEN 
INT, 
PONOLEN 
INT, 
VENDOLEN 
INT, 
INVOILEN 
varchar(2), 
LEVEL 
boolean, 
POSKIPP 
varchar(10), 
LOOSEIT 
boolean, 
JOBSKIP 
varchar(10), 
CARTONFL 
boolean, 
PICKLIST 
boolean, 
NORDER 
varchar(15), 
NALLOCAT 
varchar(15), 
NRECEIVE 
varchar(15), 
NISSUE 
varchar(15), 
PRODDESC 
varchar(15), 
PRODCODE 
varchar(12), 
NJOB 
varchar(15), 
NMATERIA 
varchar(15), 
NACTIVITY 
varchar(15), 
NBUTT 
varchar(15), 
NCUSTOME 
varchar(15), 
NCONTACT 
varchar(15), 
NVENDOR 
varchar(15), 
NEMPLOYEE 
varchar(15), 
NSCHEDULE 
varchar(15), 
NREJECT 
varchar(15), 
NRETURN 
varchar(15), 
NCODE 
varchar(15), 
MANUFID 
varchar(20), 
BARTYPE 
varchar(4), 
CADTYPE 
varchar(4), 
CARTYPE 
varchar(4), 
SHITYPE 
varchar(4), 
REPTYPE 
varchar(4), 
LOCTYPE 
varchar(4), 
BARCOL 
boolean, 
CARCOL 
boolean, 
CADCOL 
boolean, 
SHICOL 
boolean, 
REPCOL 
boolean, 
LOCCOL 
boolean, 
ALTSERIA 
boolean, 
COUNTRYCODE 
varchar(3), 
NALTSERI 
varchar(12), 
SCRCOLOR 
varchar(11), 
HILCOLOR 
varchar(11), 
TEXTCOLOR 
varchar(11), 
BACCOLOR 
varchar(11), 
DATETYPE 
varchar(7), 
DELCHAR 
varchar(2), 
CURRCODE 
varchar(2), 
PRINBAR 
boolean, 
BARPRINT 
varchar(4), 
CARPRINT 
varchar(4), 
CADPRINT 
varchar(4), 
LOCPRINT 
varchar(4), 
SHIPRINT 
varchar(4), 
REPPRINT 
varchar(4), 
BARPRTY 
varchar(4), 
REPPRTY 
varchar(4), 
CARPRTY 
varchar(4), 
CADPRTY 
varchar(4), 
SHIPRTY 
varchar(4), 
LOCPRTY 
varchar(4), 
ALTSELEN 
INT, 
CUSTOLEN 
INT, 
CARCSIZE 
varchar(12), 
CADCSIZE 
varchar(12), 
SHICSIZE 
varchar(12), 
REPCSIZE 
varchar(12), 
LOCCSIZE 
varchar(12), 
CS 
varchar(15), 
NCONFTYP 
varchar(12), 
NLOCATIO 
varchar(12), 
NDIVCODE 
varchar(12), 
NDEPCODE 
varchar(12), 
NADDCODE 
varchar(12), 
NFLOOR 
varchar(12), 
NROOM 
varchar(12), 
NRACK 
varchar(12), 
MENUTYPE 
varchar(3), 
PADTYPE 
varchar(4), 
NRATE1TA 
varchar(12), 
NRATE2TA 
varchar(12), 
DEFCONFT 
varchar(8), 
BEEPSOU 
boolean, 
CONFIRM 
boolean, 
LINEFEED 
boolean, 
REFBARADJ 
INT, 
SHIBARADJ 
INT, 
CUSBARADJ 
INT, 
LOCBARADJ 
INT, 
CARBARADJ 
INT, 
NCORDER 
varchar(12), 
NSPERSON 
varchar(12), 
PROMPTI 
boolean, 
P1 
varchar(5), 
P2 
varchar(5), 
P3 
varchar(5), 
P4 
varchar(5), 
P5 
varchar(5), 
P6 
varchar(5), 
-- b prefix a suffix to invoice digit part bbb-nn-aa or bna or bn
CUSTOMERQUOTENB 
varchar(15), 
CUSTOMERQUOTEN 
INT, 
CUSTOMERQUOTENA 
varchar(15), 
CUSTOMERORDERNB 
varchar(15), 
CUSTOMERORDERN 
INT, 
CUSTOMERORDERNA 
varchar(15), 
VENDORORDERNB 
varchar(15), 
VENDORORDERN 
INT, 
VENDORORDERNA 
varchar(15), 
JOBNB 
varchar(15), 
JOBN 
INT, 
JOBNA 
varchar(15), 
CUSTOMERINVOICENB 
varchar(15), 
CUSTOMERINVOICEN 
INT, 
CUSTOMERINVOICENA 
varchar(15), 
VENDORINVOICENB 
varchar(15), 
VENDORINVOICEN 
INT, 
VENDORINVOICENA 
varchar(15), 
CUSTOMERPICKNB 
varchar(15), 
CUSTOMERPICKN 
INT, 
CUSTOMERPICKNA 
varchar(15), 
VENDORQUOTENB 
varchar(15), 
VENDORQUOTEN 
INT, 
VENDORQUOTENA 
varchar(15), 
CUSTOMERPAYMNTNB 
varchar(15), 
CUSTOMERPAYMNTN 
INT, 
CUSTOMERPAYMNTNA 
varchar(15), 
VENDORPAYMNTNB 
varchar(15), 
VENDORPAYMNTN 
INT, 
VENDORPAYMNTNA 
varchar(15), 
VENDORCHQNB 
varchar(15), 
VENDORCHQN 
INT, 
VENDORCHQNA 
varchar(15), 
TASKNB 
varchar(15), 
TASKN 
INT, 
TASKNA 
varchar(15), 
ARSEQB 
varchar(15), 
ARSEQ 
INT, 
ARSEQA 
varchar(15), 
APSEQB 
varchar(15), 
APSEQ 
INT, 
APSEQA 
varchar(15), 
GLSEQB 
varchar(15), 
GLSEQ 
INT, 
GLSEQA 
varchar(15), 
PASEQB 
varchar(15), 
PASEQ 
INT, 
PASEQA 
varchar(15), 
ICSEQB 
varchar(15), 
ICSEQ 
INT, 
ICSEQA 
varchar(15), 
JOSEQB 
varchar(15), 
JOSEQ 
INT, 
JOSEQA 
varchar(15), 
SGLENTRY 
varchar(15), 
TAX1CODE 
varchar(25), 
TAX2CODE 
varchar(25), 
TAX3CODE 
varchar(25), 
NDECIMAL 
INT, 
EDIPASSW 
varchar(10), 
INTPASSW 
varchar(10), 
INRPASSW 
varchar(10), 
IMLPASSW 
varchar(10), 
RMLPASSW 
varchar(10), 
LMLPASSW 
varchar(10), 
HOSPASSW 
varchar(10), 
LANPASSW 
varchar(10), 
WANPASSW 
varchar(10), 
ASHOSTID 
varchar(35), 
HDSTYLE 
varchar(30), 
MTSTYLE 
varchar(30), 
STSTYLE 
varchar(30), 
DTSTYLE 
varchar(30), 
FTSTYLE 
varchar(30), 
DEFAULTR 
varchar(15), 
DEFAULTC 
varchar(3), 
DBNAME 
varchar(35), 
ROOTDIR 
varchar(25), 
KEYORDER 
varchar(3), 
CURRBUSDAT 
TIMESTAMP, 
LASTBUSDAT 
TIMESTAMP, 
CURRCALDAT 
TIMESTAMP, 
LASTCALDAT 
TIMESTAMP, 
PREPROCESS 
boolean, 
MARGIN 
INT, 
FOOTER 
INT, 
LASTUSER 
varchar(10), 
LISTBUILDC 
boolean, 
LISTBUILDV 
boolean, 
LISTBUILDE 
boolean, 
LISTBROWNC 
INT, 
LISTBROWNV 
INT, 
LISTBROWNE 
INT, 
SMTPSERVER 
varchar(30), 
SMTPUSER 
varchar(30), 
SMTPPASS 
varchar(20), 
POP3SERVER 
varchar(30), 
POP3USER 
varchar(30), 
POP3PASS 
varchar(20), 
SMATCODE 
varchar(15), 
FYREND 
TIMESTAMP, 
FPERIODS 
INT, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
DEPARTMENT 
( 
SID
SERIAL,
DEPCODE 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
GLPREFIX
varchar(20),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
COMPANY 
( 
SID
SERIAL,
COMPANYCODE 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
LEGALNAME 
varchar(60), 
MAILTOCODE
INT ,
GLPREFIX
varchar(20),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY(SID), 
FOREIGN 
KEY 
( 
MAILTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
);
-- control code usage logic not implemented yet but could be used to track certain expenses 
-- the codes will be put to be selected as foreign key. for example a project could be assoiciated a number of control codes
CREATE 
TABLE genapp. 
CONTROL 
( 
SID
SERIAL,
CONTROLCODE 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
TYPEOFCONTROL 
varchar(12), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
);
CREATE 
TABLE genapp. 
DIVISION 
( 
SID
SERIAL,
DIVCODE 
varchar(32) not null,
DESCRIPT 
varchar(120), 
GLPREFIX
varchar(20),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY KEY(SID) 
); 
CREATE 
TABLE genapp. 
LOCATION 
( 
SID
SERIAL,
LOCATION 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
COMPANYCODE
 INT  ,
ADDRESSCODE 
 INT  , 
FLOOR 
varchar(25), 
ROOM 
varchar(25), 
RACK 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
EXCLUDE 
boolean, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
COMPANYCODE 
) 
REFERENCES genapp. 
COMPANY 
( 
SID 
), 
FOREIGN 
KEY 
( 
ADDRESSCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
); 
CREATE 
TABLE genapp. 
RESIDENCY 
( 
SID
SERIAL,
RESIDENCY 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
MUNICIPALITY 
varchar(20), 
PROVINCE 
varchar(20), 
COUNTRYNAME 
varchar(20), 
EXCLUDE 
boolean, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID 
) 
); 
CREATE 
TABLE genapp. 
CUSTOMER 
( 
SID
SERIAL,
CUSTOMER 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
TITLE 
varchar(12), 
JOBTITLE 
varchar(20), 
LASTNAME 
varchar(25), 
FIRSTNAME 
varchar(25), 
MIDDLENAM 
varchar(20), 
CUSTOMERASCOMPANYNAME 
varchar(25), 
CUSTTOTL 
NUMERIC(14,2), 
CUSTTQTY 
NUMERIC(14,2),
COMPANYCODE
INT, 
LOCATION 
INT  , 
MAILTOCODE 
INT  , 
SHIPTOCODE 
INT  , 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
CUSTTAX1 
varchar(25), 
CUSTTAX2 
varchar(25), 
CUSTTAX3 
varchar(25), 
PHONEO 
varchar(20), 
PHONEH 
varchar(16), 
PHONEC 
varchar(16), 
PHONEX 
varchar(20), 
LANADDR 
varchar(35), 
WANADDR 
varchar(35), 
LMAILADDR 
varchar(35), 
IMAILADDR 
varchar(35), 
RMAILADDR 
varchar(35), 
INTADDR 
varchar(35), 
INRADDR 
varchar(35), 
DOB
TIMESTAMP,
PLACEOFBIRTH
varchar(60),
SEX
varchar(1),
AGE
int,
CUSRTOTL 
NUMERIC(14,2), 
CUSRTQTY 
NUMERIC(14,2), 
CUSMTOTL 
NUMERIC(14,2), 
CUSDTOTL 
NUMERIC(14,2), 
LASTORDER 
varchar(20), 
LASTINVOIC 
varchar(20), 
LASTPAYMNQ 
NUMERIC(14,2), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
SHIPLABEL 
boolean, 
TYPE 
varchar(10), 
INTEGRSET 
varchar(20), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
TOTLPAID 
NUMERIC(14,2), 
CONTACTED 
TIMESTAMP, 
BYWHO 
varchar(20), 
NXTCONTACT 
TIMESTAMP, 
VIA 
varchar(11), 
KEYWORDS 
varchar(30), 
NOTES 
varchar(159), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID 
), 
FOREIGN 
KEY 
( 
MAILTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
COMPANYCODE) 
REFERENCES genapp. 
COMPANY( 
SID 
), 
FOREIGN 
KEY 
( 
LOCATION 
) 
REFERENCES genapp. 
LOCATION 
( 
SID
), 
FOREIGN 
KEY 
( 
SHIPTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
); 
CREATE 
TABLE genapp. 
VENDOR 
( 
SID
SERIAL,
VENDOR 
varchar(32) not null, 
DESCRIPT 
varchar(60), 
TITLE 
varchar(20), 
JOBTITLE 
varchar(20), 
LASTNAME 
varchar(25), 
FIRSTNAME 
varchar(25), 
MIDDLENAM 
varchar(20), 
VENDORASCOMPANYNAME 
varchar(25), 
VENDTOTL 
NUMERIC(14,2), 
VENDTQTY 
NUMERIC(14,2),
COMPANYCODE
INT  , 
LOCATION 
INT  , 
MAILTOCODE 
INT  , 
PHONEO 
varchar(30), 
PHONEH 
varchar(25), 
PHONEC 
varchar(25), 
PHONEX 
varchar(30), 
LANADDR 
varchar(35), 
WANADDR 
varchar(35), 
LMAILADDR 
varchar(35), 
IMAILADDR 
varchar(35), 
RMAILADDR 
varchar(35), 
INTADDR 
varchar(35), 
INRADDR 
varchar(35), 
VENRTOTL 
NUMERIC(14,2), 
VENRTQTY 
NUMERIC(14,2), 
VENMTOTL 
NUMERIC(14,2), 
VENDDTOTL 
NUMERIC(14,2), 
LASTQUOTE 
varchar(20), 
LASTORDER 
varchar(20), 
LASTINVOIC 
varchar(20), 
LASTPAYMQ 
NUMERIC(14,2), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
SHIPLABEL 
boolean, 
TYPE 
varchar(10), 
SHIPTOCODE 
INT  , 
INTEGRSET 
varchar(20), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
TOTLPAID 
NUMERIC(14,2), 
CONTACTED 
TIMESTAMP, 
BYWHO 
varchar(20), 
KEYWORDS 
varchar(30), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
MAILTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
COMPANYCODE) 
REFERENCES genapp. 
COMPANY( 
SID 
), 
FOREIGN 
KEY 
( 
LOCATION 
) 
REFERENCES genapp. 
LOCATION 
( 
SID
), 
FOREIGN 
KEY 
( 
SHIPTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
); 
CREATE 
TABLE genapp. 
EMPLOYEE 
( 
SID
SERIAL,
EMPLOYEE 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
TITLE 
varchar(20), 
JOBTITLE 
varchar(20), 
LASTNAME 
varchar(25), 
FIRSTNAME 
varchar(25), 
MIDDLENAM 
varchar(20), 
COMPANYCODE 
INT  , 
EMPLTOTL 
NUMERIC(14,2), 
EMPLTQTY 
NUMERIC(14,2), 
DIVCODE 
INT  , 
DEPCODE 
INT  , 
LOCATION 
INT  , 
RESIDENCY 
INT  , 
MAILTOCODE 
INT  , 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
CUSTTAX1 
varchar(25), 
CUSTTAX2 
varchar(25), 
CUSTTAX3 
varchar(25), 
PHONEO 
varchar(30), 
PHONEH 
varchar(25), 
PHONEC 
varchar(25), 
PHONEX 
varchar(30), 
LANADDR 
varchar(35), 
WANADDR 
varchar(35), 
LMAILADDR 
varchar(35), 
IMAILADDR 
varchar(35), 
RMAILADDR 
varchar(35), 
INTADDR 
varchar(35), 
INRADDR 
varchar(35), 
EMPRTOTL 
NUMERIC(14,2), 
EMPRTQTY 
NUMERIC(14,2), 
EMPMTOTL 
NUMERIC(14,2), 
EMPDTOTL 
NUMERIC(14,2), 
LASTQUOTE 
varchar(20), 
LASTORDER 
varchar(20), 
LASTINVOIC 
varchar(20), 
LASTPAYMQ 
NUMERIC(14,2), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
SHIPLABEL 
boolean, 
SHIPTOCODE 
INT  , 
TYPE 
varchar(12), 
INTEGRSET 
varchar(20), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
CONTACTED 
TIMESTAMP, 
BYWHO 
varchar(20), 
KEYWORDS 
varchar(30), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
DEPCODE 
) 
REFERENCES genapp. 
DEPARTMENT 
( 
SID 
), 
FOREIGN 
KEY 
( 
DIVCODE 
) 
REFERENCES genapp. 
DIVISION 
( 
SID 
), 
FOREIGN 
KEY 
( 
COMPANYCODE 
) 
REFERENCES genapp. 
COMPANY 
( 
SID 
), 
FOREIGN 
KEY 
( 
MAILTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
LOCATION 
) 
REFERENCES genapp. 
LOCATION 
( 
SID 
), 
FOREIGN 
KEY 
( 
RESIDENCY) 
REFERENCES genapp. 
RESIDENCY 
( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
); 
CREATE 
TABLE genapp. 
VCONTACT 
( 
SID
SERIAL,
CONTACT 
varchar(20)  not null
, 
VENDOR 
INT, 
TITLE 
varchar(20), 
JOBTITLE 
varchar(20), 
LASTNAME 
varchar(25), 
FIRSTNAME 
varchar(25), 
MIDDLENAM 
varchar(20), 
PHONEO 
varchar(25), 
PHONEH 
varchar(25), 
PHONEC 
varchar(25), 
PHONEX 
varchar(20), 
LANADDR 
varchar(35), 
WANADDR 
varchar(35), 
LMAILADDR 
varchar(35), 
IMAILADDR 
varchar(35), 
RMAILADDR 
varchar(35), 
INTADDR 
varchar(35), 
INRADDR 
varchar(35), 
LOCATION 
INT, 
MAILTOCODE 
INT  , 
SHIPTOCODE 
INT  , 
PRINTSTA 
INT, 
SHIPLABEL 
boolean, 
TYPE 
varchar(12), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
KEYWORDS 
varchar(30), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
MAILTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
LOCATION) 
REFERENCES genapp. 
LOCATION( 
SID 
), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CCONTACT 
( 
SID
SERIAL,
CONTACT 
varchar(32) not null, 
CUSTOMER 
INT, 
TITLE 
varchar(20), 
JOBTITLE 
varchar(20), 
LASTNAME 
varchar(25), 
FIRSTNAME 
varchar(25), 
MIDDLENAM 
varchar(20), 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
CUSTTAX1 
varchar(25), 
CUSTTAX2 
varchar(25), 
CUSTTAX3 
varchar(25), 
PHONEO 
varchar(16), 
PHONEH 
varchar(16), 
PHONEC 
varchar(16), 
PHONEX 
varchar(20), 
LANADDR 
varchar(35), 
WANADDR 
varchar(35), 
LMAILADDR 
varchar(35), 
IMAILADDR 
varchar(35), 
RMAILADDR 
varchar(35), 
INTADDR 
varchar(35), 
INRADDR 
varchar(35), 
LOCATION 
INT, 
MAILTOCODE 
INT  , 
SHIPTOCODE 
INT  , 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
SHIPLABEL 
boolean, 
TYPE 
varchar(12), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
KEYWORDS 
varchar(30), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
MAILTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
, 
FOREIGN 
KEY 
( 
LOCATION) 
REFERENCES genapp. 
LOCATION( 
SID 
) 
, 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
ACCOUNT 
( 
SID
SERIAL,
ACCOUNT 
varchar(20) not null 
, 
DESCRIPT 
varchar(120), 
CATEGORY 
varchar(20), 
TYPE 
varchar(12), 
BUDGET 
NUMERIC(14,2), 
ACTUAL 
NUMERIC(14,2), 
ACTUALN 
NUMERIC(14,2), 
PREVBUDG 
NUMERIC(14,2), 
PREVACT 
NUMERIC(14,2), 
SEQUENCE 
INT, 
CHILD 
varchar(20), 
PARENT 
varchar(20), 
ROLLUPQ 
INT, 
COMPANYCODE 
INT  , 
DEPCODE 
INT  , 
DIVCODE 
INT  , 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
CURRENCY 
varchar(3), 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
P0 
NUMERIC(14,2), 
P1 
NUMERIC(14,2), 
P2 
NUMERIC(14,2), 
P3 
NUMERIC(14,2), 
P4 
NUMERIC(14,2), 
P5 
NUMERIC(14,2), 
P6 
NUMERIC(14,2), 
P7 
NUMERIC(14,2), 
P8 
NUMERIC(14,2), 
P9 
NUMERIC(14,2), 
P10 
NUMERIC(14,2), 
P11 
NUMERIC(14,2), 
P12 
NUMERIC(14,2), 
P13 
NUMERIC(14,2), 
P14 
NUMERIC(14,2), 
P8T 
NUMERIC(14,2), 
P9T 
NUMERIC(14,2), 
P10T 
NUMERIC(14,2), 
P11T 
NUMERIC(14,2), 
PRIMARY 
KEY 
( 
SID 
), 
FOREIGN 
KEY 
( 
COMPANYCODE 
) 
REFERENCES genapp. 
COMPANY 
( 
SID 
),
 FOREIGN 
KEY 
( 
DEPCODE 
) 
REFERENCES genapp. 
DEPARTMENT 
( 
SID 
), 
FOREIGN 
KEY 
( 
DIVCODE 
) 
REFERENCES genapp. 
DIVISION 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
ACPERIOD 
( 
SID
SERIAL,
ROWID
varchar(2) not null,
CURRPERIOD 
varchar(2), 
DESCRIPT 
varchar(120), 
CURRBUSDATE 
TIMESTAMP, 
CURRCALDATE 
TIMESTAMP, 
CURRLOCALDATE 
TIMESTAMP, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY KEY(SID)
); 
CREATE 
TABLE genapp. 
WAGEEARNER 
( 
SID
SERIAL,
WAGEEARNERID 
varchar(32) not null, 
EMPLOYEE 
INT  , 
SIN 
varchar(20), 
BIRTHDT 
TIMESTAMP, 
FEDCLAIM 
NUMERIC(14,2), 
PROVCLAIM 
NUMERIC(14,2), 
PAYYRFREQ 
INT, 
PAYPERIOD 
INT, 
WCB 
boolean, 
WCBYTD 
NUMERIC(14,2), 
EMPLINSUR 
boolean, 
INSYTD 
NUMERIC(14,2), 
VACRETAIN 
boolean, 
VACATONYT 
NUMERIC(14,2), 
WAGEUNIT 
varchar(20), 
WAGERATE 
NUMERIC(14,2), 
OTIMEUNIT 
varchar(20), 
OTIMERATE 
NUMERIC(14,2), 
WAGEUNITS 
NUMERIC(14,2), 
OTIMUNITS 
NUMERIC(14,2), 
WAGEOUT 
NUMERIC(14,2), 
OVTIMEOUT 
NUMERIC(14,2), 
SALARYOUT 
NUMERIC(14,2), 
COMMISSION 
NUMERIC(14,2), 
BENEFITS 
NUMERIC(14,2), 
VACATION 
NUMERIC(14,2), 
VACPAYOUT 
NUMERIC(14,2), 
ADVANCE 
NUMERIC(14,2), 
PENSION 
NUMERIC(14,2), 
AFTERTAX 
boolean, 
UNIONDUES 
NUMERIC(14,2), 
MEDICAL 
NUMERIC(14,2), 
FINCOMETX 
NUMERIC(14,2), 
PINCOMETX 
NUMERIC(14,2), 
THISPAYA 
NUMERIC(14,2), 
LASTPAYA 
NUMERIC(14,2), 
PAYYTD 
NUMERIC(14,2), 
FPENSIYTD 
NUMERIC(14,2), 
PPENSIYTD 
NUMERIC(14,2), 
ITAXYTD 
NUMERIC(14,2), 
PTAXYTD 
NUMERIC(14,2), 
GRPAYYTD 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
EMPLOYEE) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
ARTHATBL 
( 
SID
SERIAL,
USAGE 
varchar(32) not null, 
WCBPERCNT 
NUMERIC(14,2), 
INSFACTOR 
NUMERIC(14,2), 
VACATONRATE 
NUMERIC(14,2), 
PENSIONMAX 
NUMERIC(14,2), 
WCBMAX 
NUMERIC(14,2), 
INSMAX 
NUMERIC(14,2), 
ITAXLV0RATE 
NUMERIC(14,2), 
ITAXLV1RATE 
NUMERIC(14,2), 
ITAXLV2RATE 
NUMERIC(14,2), 
ITAXLV3RATE 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID) 
); 
CREATE 
TABLE genapp. 
ROLLUPGROUP 
( 
SID
SERIAL,
GROUPID 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
TYPE 
varchar(10), 
CURRPW 
varchar(20), 
EXPIRY 
TIMESTAMP, 
CURRENCY 
varchar(3), 
PERIOD0B 
NUMERIC(14,2), 
PERIOD0 
NUMERIC(14,2), 
PERIODTOTALSB 
NUMERIC(14,2), 
PERIODTOTALS
NUMERIC(14,2), 
PERIOD1BUDGET 
NUMERIC(14,2), 
PERIOD1ACTUAL 
NUMERIC(14,2), 
PERIOD2B 
NUMERIC(14,2), 
PERIOD2 
NUMERIC(14,2), 
PERIOD3B 
NUMERIC(14,2), 
PERIOD3 
NUMERIC(14,2), 
PERIOD4B 
NUMERIC(14,2), 
PERIOD4 
NUMERIC(14,2), 
PERIOD5B 
NUMERIC(14,2), 
PERIOD5 
NUMERIC(14,2), 
PERIOD6B 
NUMERIC(14,2), 
PERIOD6 
NUMERIC(14,2), 
PERIOD7B 
NUMERIC(14,2), 
PERIOD7 
NUMERIC(14,2), 
PERIOD8B 
NUMERIC(14,2), 
PERIOD8 
NUMERIC(14,2), 
PERIOD9B 
NUMERIC(14,2), 
PERIOD9 
NUMERIC(14,2), 
PERIOD10B 
NUMERIC(14,2), 
PERIOD10 
NUMERIC(14,2), 
PERIOD11B 
NUMERIC(14,2), 
PERIOD11 
NUMERIC(14,2), 
PERIOD12B 
NUMERIC(14,2), 
PERIOD12 
NUMERIC(14,2), 
PERIODNB 
NUMERIC(14,2), 
PERIODN 
varchar(20), 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID) 
); 
CREATE 
TABLE genapp. 
MEMBERSGROUP 
( 
SID
SERIAL,
GROUPID 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
QUANTITY
NUMERIC(14,2), 
MODE 
boolean, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 

CREATE 
TABLE genapp. 
ARTHAHIST 
( 
SID
SERIAL,
WAGEEARNER 
varchar(32) not null, 
SIN 
varchar(12), 
PERIOD 
INT, 
MONTH 
INT, 
CCYY 
INT, 
VACATION 
NUMERIC(14,2), 
WAGE 
NUMERIC(14,2), 
OVERTIME 
NUMERIC(14,2), 
SALARY 
NUMERIC(14,2), 
COMMISSION 
NUMERIC(14,2), 
BENEFIT 
NUMERIC(14,2), 
FINCOMETX 
NUMERIC(14,2), 
PINCOMETX 
NUMERIC(14,2), 
WCBOUT 
NUMERIC(14,2), 
EMPLINSUR 
NUMERIC(14,2), 
VACPAYOUT 
NUMERIC(14,2), 
ADVANCE 
NUMERIC(14,2), 
FPENSOBTX 
NUMERIC(14,2), 
FPENSOATX 
NUMERIC(14,2), 
UNIONDUES 
NUMERIC(14,2), 
MEDICAL 
NUMERIC(14,2), 
PAYAMT 
NUMERIC(14,2), 
NOTES 
varchar(60), 
NOTES2 
varchar(120), 
CHQNUMBER 
varchar(20), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
GENTRIES 
( 
SID
SERIAL,
GLSEQNUMBER 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
REFCODE 
varchar(20), 
PERIOD 
INT, 
POSTDATE 
TIMESTAMP, 
CALENDARDT 
TIMESTAMP, 
DEPCODE 
varchar(20), 
DIVCODE 
varchar(20), 
ACCOUNT 
varchar(20), 
DEBITAMT 
NUMERIC(14,2), 
CREDITAMT 
NUMERIC(14,2), 
DEPCODE2 
varchar(20), 
DIVCODE2 
varchar(20), 
ACCOUNT2 
varchar(20), 
DEBITAMT2 
NUMERIC(14,2), 
CREDTAMT2 
NUMERIC(14,2), 
NOTES 
varchar(60), 
STATUSFL 
INT, 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
HOLIDAY 
( 
SID
SERIAL,
SHOLIDAY 
varchar(32) not null, 
HOLIDAY 
TIMESTAMP, 
DESCRIPT 
varchar(120), 
TYPE 
varchar(12), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
EMPLOYEE 
INT  , 
RESIDENCY 
INT  , 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
RESIDENCY) 
REFERENCES genapp. 
RESIDENCY 
( 
SID 
), 
FOREIGN 
KEY 
( 
EMPLOYEE) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
JOURNAL 
( 
SID
SERIAL,
SPOSTDATE 
VARCHAR(25) not null, 
POSTDATE 
TIMESTAMP, 
CALENDARDT 
TIMESTAMP, 
JRNLTYPE 
varchar(12), 
JNLSEQB 
varchar(15), 
JNLSEQ 
INT, 
JNLSEQS 
varchar(15), 
PERIOD 
INT, 
ACCOUNT 
varchar(20), 
DEBIT 
NUMERIC(14,2), 
CREDIT 
NUMERIC(14,2), 
XREFERENCE 
varchar(20), 
DESCRIPT 
varchar(120), 
STATUSFL 
INT, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CJOURNAL 
( 
SID
SERIAL,
SPOSTDATE 
VARCHAR(25) not null, 
POSTDATE 
TIMESTAMP, 
CALENDARDT 
TIMESTAMP, 
JRNLTYPE 
varchar(12), 
JNLSEQB 
varchar(15), 
JNLSEQ 
INT, 
JNLSEQS 
varchar(15), 
PERIOD 
INT, 
CONTROL 
varchar(20), 
DEBIT 
NUMERIC(14,2), 
CREDIT 
NUMERIC(14,2), 
XREFERENCE 
varchar(20), 
DESCRIPT 
varchar(120), 
STATUSFL 
INT, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID) 
); 
CREATE 
TABLE genapp. 
JJOURNAL 
( 
SID
SERIAL,
SPOSTDATE 
VARCHAR(25) not null, 
POSTDATE 
TIMESTAMP, 
CALENDARDT 
TIMESTAMP, 
JRNLTYPE 
varchar(12), 
JNLSEQB 
varchar(15), 
JNLSEQ 
INT, 
JNLSEQS 
varchar(15), 
PERIOD 
INT, 
JOB 
varchar(20), 
DEBIT 
NUMERIC(14,2), 
CREDIT 
NUMERIC(14,2), 
XREFERENCE 
varchar(20), 
DESCRIPT 
varchar(120), 
STATUSFL 
INT, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID) 
); 
CREATE 
TABLE genapp. 
ITEM 
( 
SID
SERIAL,
MATCODE 
varchar(32) not null, 
QUANTITY 
NUMERIC(14,2), 
DESCRIPT 
varchar(120), 
DATEADDED 
TIMESTAMP, 
SOURCE1 
varchar(35), 
SOURCE2 
varchar(35), 
UPCCODE 
varchar(25), 
COST 
NUMERIC(14,2), 
REPLCOST 
NUMERIC(14,2), 
SELPRICE 
NUMERIC(14,2), 
SPRICOLD 
NUMERIC(14,2), 
SPRICNEW 
NUMERIC(14,2), 
SPRICEFFDT 
TIMESTAMP, 
SHIPCODE 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
MISCCODE1 
varchar(25), 
MISCCODE2 
varchar(25), 
QTYLEVEL1 
NUMERIC(14,2), 
UNIT 
varchar(12), 
CASEQTY 
NUMERIC(14,2), 
TYPE 
varchar(12), 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
ALIASCODE 
varchar(25), 
PARENTCODE 
INT  , 
AVGPRICE 
NUMERIC(14,2), 
AVGCOST 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SUBCODESN 
NUMERIC(14,2), 
CUORDQTY 
NUMERIC(14,2), 
VENORQTY 
NUMERIC(14,2), 
CUPICQTY 
NUMERIC(14,2), 
VENPIQTY 
NUMERIC(14,2), 
CUINVQTY 
NUMERIC(14,2), 
CUSHIQTY 
NUMERIC(14,2), 
VENSHQTY 
NUMERIC(14,2), 
EFFDATE 
TIMESTAMP, 
INTEGRSET 
varchar(20), 
NOTES 
varchar(60), 
DOCMNT 
varchar(90), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
LOCATION 
INT  , 
BARUPC 
varchar(30), 
PRIMARY 
KEY 
( 
SID),
FOREIGN 
KEY 
( 
PARENTCODE) 
REFERENCES genapp. 
ITEM 
( 
SID) 
,
FOREIGN 
KEY 
( 
LOCATION 
) 
REFERENCES genapp. 
LOCATION 
( 
SID
)
); 
CREATE 
TABLE genapp. 
ACTIVITY 
( 
SID
SERIAL,
ACTIVITYCODE 
varchar(32) not null, 
QUANTITY 
NUMERIC(14,2), 
DESCRIPT 
varchar(120), 
DATE 
TIMESTAMP, 
SOURCE1 
varchar(35), 
SOURCE2 
varchar(35), 
UPCCODE 
varchar(25), 
COST 
NUMERIC(14,2), 
REPLCOST 
NUMERIC(14,2), 
SELPRICE 
NUMERIC(14,2), 
SPRICOLD 
NUMERIC(14,2), 
SPRICNEW 
NUMERIC(14,2), 
SPRICEFFDT 
TIMESTAMP, 
SHIPCODE 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
MISCCODE1 
varchar(25), 
MISCCODE2 
varchar(25), 
QTYLEVEL1 
NUMERIC(14,2), 
UNIT 
varchar(12), 
CASEQTY 
NUMERIC(14,2), 
TYPE 
varchar(12), 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
ALIASCODE 
varchar(25), 
PARENTCODE 
INT  , 
AVGPRICE 
NUMERIC(14,2), 
AVGCOST 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SUBCODESN 
NUMERIC(14,2), 
CUORDQTY 
NUMERIC(14,2), 
VENORQTY 
NUMERIC(14,2), 
CUPICQTY 
NUMERIC(14,2), 
VENPIQTY 
NUMERIC(14,2), 
CUINVQTY 
NUMERIC(14,2), 
CUSHIQTY 
NUMERIC(14,2), 
VENSHQTY 
NUMERIC(14,2), 
EFFDATE 
TIMESTAMP, 
INTEGRSET 
varchar(20), 
NOTES 
varchar(60), 
DOCMNT 
varchar(90), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARUPC 
varchar(30), 
PRIMARY 
KEY 
( 
SID),
FOREIGN 
KEY 
( 
PARENTCODE) 
REFERENCES genapp. 
ACTIVITY 
( 
SID)  
); 
CREATE 
TABLE genapp. 
SCHEDULE 
( 
SID
SERIAL,
TODO 
varchar(35) not null, 
DESCRIPT 
varchar(120), 
EMPLOYEE 
INT  , 
SSDATET 
varchar(30), 
ACTIVITYCODE 
INT  , 
LOCATION 
INT  , 
SDATET 
TIMESTAMP, 
DURATIONH 
INT, 
DURATIONM 
INT, 
STIMEH 
INT, 
STIMEM 
INT, 
STIMEAMPM 
boolean, 
EDATET 
TIMESTAMP, 
PRIORITY 
boolean, 
PERCNTDONE 
NUMERIC(14,2), 
VENDOR 
INT  , 
VONTACT 
INT  , 
CUSTOMER 
INT  , 
TYPE 
varchar(20), 
MAILTOCODE 
INT  , 
OTHEREMPLO 
INT, 
REPEATF 
varchar(20), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
PRIVATEIND 
boolean, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID
), 
FOREIGN 
KEY 
( 
ACTIVITYCODE) 
REFERENCES genapp. 
ACTIVITY 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
EMPLOYEE) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
MAILTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN
KEY
(LOCATION) 
REFERENCES genapp. 
LOCATION 
( 
SID) 
); 
-- additional data including temporary data related to user is kept in userprofl table with variable number of rows
-- MAXPROFLROW will dictate max number temporary data rows ie not counting the base row,CPROFLROW will point to the current row
-- oldest data row will get deleted if maxprofl row gets exceeded
-- it is yet to be decided what values will be saved but at least the values like last customer, item, activity and some option 
-- number and their values will be kept.
-- the columns with meaning for base row will be used probably with alias name. Some column name mapping needs to be done
CREATE 
TABLE  
genapp."user" 
( 
SID
SERIAL,
ID 
varchar(60) not null, 
CLIENT 
INT  , 
EMPLOYEE 
INT  , 
VENDOR 
INT  , 
CUSTOMER 
INT  , 
OTHERID 
varchar(60), 
ALEVEL 
varchar(12), 
BLEVEL 
varchar(12), 
CURRPW 
varchar(40) not null, 
EXPIRY 
TIMESTAMP, 
OLDPW 
varchar(40), 
TEMPORARYPASSWORD 
boolean, 
PASSWORDHASH 
varchar(128), 
ACTIVATIONKEY
varchar(60), 
RESTRICT1 
varchar(20), 
RESTRICT2 
varchar(20), 
RESTRICT3 
varchar(20), 
ALLOW1 
varchar(20), 
ALLOW2 
varchar(20), 
ALLOW3 
varchar(20), 
MAXPROFLROW
varchar(20),
CPROFLROW
varchar(20),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
UCURRCALDA 
TIMESTAMP, 
PREPROCESS 
boolean, 
NOTES 
varchar(60), 
DOCMNT 
varchar(90), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
CLIENT 
) 
REFERENCES genapp. 
CLIENT 
( 
SID 
), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
EMPLOYEE) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID) 
);
--USERPROFL is like extension of USER and is normally accessed via USER, so no separate natural key
CREATE 
TABLE genapp. 
USERPROFL 
( 
SID
SERIAL,
LOGONID 
INT,
ROW
varchar(20),
OPTION
varchar(255),
SELECTVALUE
varchar(255), 
SCRCOLOR 
varchar(30), 
HILCOLOR 
varchar(30), 
TEXTCOLOR 
varchar(30), 
BACCOLOR 
varchar(30), 
BEEPSOU 
boolean, 
CONFIRM 
boolean, 
PROMPTI 
boolean, 
P1 
varchar(5), 
P2 
varchar(5), 
P3 
varchar(5), 
P4 
varchar(5), 
P5 
varchar(5), 
P6 
varchar(5), 
MTSTYLE 
varchar(30), 
STSTYLE 
varchar(30), 
DTSTYLE 
varchar(30), 
FTSTYLE 
varchar(30), 
DEFAULTR 
varchar(20), 
DEFAULTC 
varchar(3), 
DBNAME 
varchar(20), 
ROOTDIR 
varchar(35), 
KEYORDER 
varchar(3), 
MARGIN 
NUMERIC(14,2), 
FOOTER 
NUMERIC(14,2), 
LISTBUILDC 
boolean, 
LISTBUILDV 
boolean, 
LISTBUILDE 
boolean, 
LISTBROWNC 
INT, 
LISTBROWNV 
INT, 
LISTBROWNE 
INT,
OWNER 
varchar(20), 
OWNER2 
varchar(40),
PRIMARY 
KEY(SID),
FOREIGN
KEY(LOGONID)
REFERENCES 
genapp."user"(SID) 
); 
 
CREATE 
TABLE genapp. 
VENARTHA 
( 
SID
SERIAL,
CHQNUMBER 
varchar(32) not null, 
RECONCILED 
varchar(12), 
VENDORC 
INT  , 
DATE 
TIMESTAMP, 
ADDRESCODE 
INT, 
CHQAMT 
NUMERIC(14,2), 
AMTVERBOS 
varchar(120), 
NOTES 
varchar(60), 
ADVISEL1 
varchar(60), 
ADVISEL2 
varchar(60), 
ADVISEL3 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY
(SID )
, 
FOREIGN 
KEY 
( 
VENDORC 
) 
REFERENCES genapp. 
VENDOR 
( 
SID
) 
)
; 
-- not null is not used,if companycode,divcode,depcode has null value substitute default values rather than forcing to select some suggestion box
CREATE 
TABLE genapp. 
ACINTEGR 
( 
SID
SERIAL,
MODULEID 
varchar(12) 
, 
USAGEDESCR 
varchar(35), 
USAGECODE 
varchar(3) 
, 
SETSID 
varchar(20) 
, 
ACCOUNT 
INT 
, 
EXTRAINTFIELD 
varchar(20), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
(
ACCOUNT) 
REFERENCES genapp. 
ACCOUNT 
( 
SID) 
); 
CREATE 
TABLE genapp. 
ITEMJOB 
( 
SID
SERIAL,
JOBNO 
varchar(32) not null, 
MATCODE 
INT  , 
PRODDATET 
TIMESTAMP, 
QTYALLOC 
NUMERIC(14,2), 
PONO 
varchar(20), 
QTYOSTND 
NUMERIC(14,2), 
QTYALSTK 
NUMERIC(14,2), 
QTYISSUD 
NUMERIC(14,2), 
JOBTOTL 
NUMERIC(14,2), 
STATUSFL 
INT, 
CUSTOMEJ 
INT  , 
VENDOR 
INT, 
STATUSFLDT 
TIMESTAMP, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
PRINTMSTATJ 
INT, 
PRINMTFLDTJ 
TIMESTAMP, 
TYPE 
varchar(12), 
MATCODEOUT 
varchar(20), 
QTYOUT 
NUMERIC(14,2), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMEJ 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
ACTIVITYJOB 
( 
SID
SERIAL,
JOBNO 
varchar(32) not null, 
ACTIVITYCODE 
INT  , 
PRODDATET 
TIMESTAMP, 
QTYALLOC 
NUMERIC(14,2), 
PONO 
INT, 
QTYOSTND 
NUMERIC(14,2), 
QTYALSTK 
NUMERIC(14,2), 
QTYISSUD 
NUMERIC(14,2), 
JOBTOTL 
NUMERIC(14,2), 
STATUSFL 
INT, 
CUSTOMEJ 
INT  , 
VENDOR 
INT, 
STATUSFLDT 
TIMESTAMP, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
PRINTMSTATJ 
INT, 
PRINMTFLDTJ 
TIMESTAMP, 
TYPE 
varchar(12), 
MATCODEOUT 
varchar(20), 
QTYOUT 
NUMERIC(14,2), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
ACTIVITYCODE) 
REFERENCES genapp. 
ACTIVITY 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMEJ 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
VENQUOTE 
( 
SID
SERIAL,
PURCHSNO 
varchar(32) not null, 
DELVDATET 
TIMESTAMP, 
VENDOR 
INT  , 
MATCODE 
INT  , 
REPLICATE 
INT  , 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
STATUSFL 
INT, 
CINVOICE 
varchar(20), 
JOBNO 
varchar(20), 
VPONO 
varchar(20), 
RFPORD 
varchar(20), 
STATUSFLDT 
TIMESTAMP, 
RCPONO 
varchar(20), 
ODATET 
TIMESTAMP, 
TERMS 
varchar(20), 
PRIORITY 
boolean, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
TYPE 
varchar(25), 
VINVOICE 
varchar(20), 
ATTACH 
varchar(20), 
SHIPCODE 
varchar(20), 
AGENT 
INT  , 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
STARTDATET 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID 
), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
REPLICATE) 
REFERENCES genapp. 
VENQUOTE 
( 
SID), 
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 

CREATE 
TABLE genapp. 
VENDORDERS 
( 
SID
SERIAL,
PURCHSNO 
varchar(32) not null, 
DELVDATET 
TIMESTAMP, 
VENDOR 
INT  , 
MATCODE 
INT  , 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
STATUSFL 
INT, 
JOBNO 
varchar(20), 
VENDQNO 
INT  , 
RFPORD 
varchar(20), 
STATUSFLDT 
TIMESTAMP, 
RCPONO 
varchar(20), 
ODATET 
TIMESTAMP, 
TERMS 
varchar(20), 
PRIORITY 
boolean, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
TYPE 
varchar(25), 
VINVOICE 
varchar(20), 
ATTACH 
varchar(20), 
SHIPCODE 
varchar(20), 
AGENT 
INT  , 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
STARTDATET 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN
KEY
(
VENDQNO
)
REFERENCES genapp.
VENQUOTE
( 
SID
),
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 


CREATE 
TABLE genapp. 
VSHIPMEN 
( 
SID
SERIAL,
SHIPCODE 
varchar(32) not null, 
MATCODE 
INT  , 
SHIPPER 
INT, 
PONO 
INT  , 
CPONO 
INT, 
INVOICE 
INT, 
BILLADDR 
varchar(20), 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
CARRIER 
varchar(20), 
TYPE 
varchar(12), 
SHIPDATET 
TIMESTAMP, 
SHIPDATETA 
TIMESTAMP, 
TARENO 
varchar(20), 
PACKNO 
varchar(20), 
VENDOR 
INT  , 
CUSTOMER 
INT  , 
MAILTOCODE 
INT  , 
SHIPTOCODE 
INT  , 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SERIALNO 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
SHIPTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
MAILTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
, 
FOREIGN 
KEY 
( 
VENDOR 
) 
REFERENCES genapp. 
VENDOR 
( 
SID 
),
FOREIGN 
KEY 
( 
PONO 
) 
REFERENCES genapp. 
VENDORDERS 
( 
SID 
), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
) 
); 


CREATE 
TABLE genapp. 
CUQUOTE 
( 
SID
SERIAL,
PURCHSNO 
varchar(32) not null, 
DELVDATET 
TIMESTAMP, 
VENDOR 
INT, 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
STATUSFL 
INT, 
CUSTOMER 
INT  , 
MATCODE 
INT  , 
REPLICATE 
INT  , 
CINVOICE 
varchar(20), 
ORDPRICE 
NUMERIC(14,2), 
JOBNO 
varchar(20), 
VPONO 
varchar(20), 
QUOORDT 
varchar(20), 
STATUSFLDT 
TIMESTAMP, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
TYPE 
varchar(12), 
TERMS 
varchar(25), 
PRIORITY 
boolean, 
ODATET 
TIMESTAMP, 
SHIPCODE 
INT, 
ACTIVITYCODE 
varchar(20), 
AGENT 
INT  , 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
ATTACH 
varchar(20), 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
REPLICATE) 
REFERENCES genapp. 
CUQUOTE 
( 
SID), 
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CUORDERS 
( 
SID
SERIAL,
PURCHSNO 
varchar(32) not null, 
DELVDATET 
TIMESTAMP, 
CUSTOMER 
INT  , 
MATCODE 
INT  , 
CUQUOTE
INT  ,
CINVOICE 
INT, 
JOBNO 
INT, 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
VPONO 
INT, 
RFPORD 
INT, 
RCPONO 
INT, 
ODATET 
TIMESTAMP, 
TERMS 
varchar(20), 
PRIORITY 
boolean, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
TYPE 
varchar(25), 
VINVOICE 
INT, 
ATTACH 
varchar(20), 
SHIPCODE 
INT, 
AGENT 
INT  , 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
STARTDATET 
TIMESTAMP, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY 
( 
SID 
), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
CUQUOTE 
) 
REFERENCES genapp. 
CUQUOTE 
( 
SID 
), 
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CUINVOICE 
( 
SID
SERIAL,
INVOICE 
varchar(32) not null, 
CUSTOMER 
INT  , 
MATCODE 
INT  , 
INVODATE 
TIMESTAMP, 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
PONO 
INT  , 
REF1TYP 
varchar(20), 
REF1CODE 
varchar(35), 
SHIPDATET 
TIMESTAMP, 
SHIPTYPE 
varchar(12), 
SHIPCODE 
varchar(20), 
TERMS 
varchar(12), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
TERMSDAT 
TIMESTAMP, 
DISCOUNP 
NUMERIC(14,2), 
DISCOUDT 
TIMESTAMP, 
DISCOUDS 
NUMERIC(14,2), 
NETDDAT 
TIMESTAMP, 
NETDDYS 
NUMERIC(14,2), 
FOB 
varchar(20), 
TYPE 
varchar(12), 
INTEGRSET 
varchar(20), 
ATTACH 
varchar(20), 
BASEAMOUNTT 
NUMERIC(14,2), 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
AGENT 
INT  , 
NOTES 
varchar(60), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
BARINVOICE 
varchar(30), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
PONO 
) 
REFERENCES genapp. 
CUORDERS 
( 
SID 
), 
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
SHIPMENT 
( 
SID
SERIAL,
SHIPCODE 
varchar(32) not null, 
MATCODE 
INT  , 
SHIPPER 
INT  , 
PONO 
INT, 
CPONO 
INT  , 
INVOICE 
INT  , 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
CARRIER 
INT, 
VENDORTYPECARRIER
varchar(12),
TYPE 
varchar(12), 
SHIPDATET 
TIMESTAMP, 
SHIPDATETA 
TIMESTAMP, 
TARENO 
varchar(20), 
PACKNO 
varchar(20), 
CUSTOMER 
INT  , 
BILLTOCODE 
INT  , 
BILLTOSAMEASSHIPTO
boolean,
SHIPTOCODE 
INT  , 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SERIALNO 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARSHIPCOD 
varchar(30), 
PRIMARY 
KEY( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPPER) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
BILLTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPTOCODE) 
REFERENCES genapp. 
ADDRESS( 
SID 
) 
, 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
INVOICE 
) 
REFERENCES genapp. 
CUINVOICE 
( 
SID 
), 
FOREIGN 
KEY 
( 
CPONO 
) 
REFERENCES genapp. 
CUORDERS 
( 
SID 
) 
); 

CREATE 
TABLE genapp. 
EMPLORDERS 
( 
SID
SERIAL,
PURCHSNO 
varchar(32) not null, 
DELVDATET 
TIMESTAMP, 
EMPLOYEE 
INT  , 
MATCODE 
INT  , 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
STATUSFL 
INT, 
JOBNO 
INT, 
VPONO 
INT, 
RFPORD 
INT, 
STATUSFLDT 
TIMESTAMP, 
RCPONO 
INT, 
ODATET 
TIMESTAMP, 
TERMS 
varchar(20), 
PRIORITY 
boolean, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
TYPE 
varchar(25), 
VINVOICE 
INT, 
ATTACH 
varchar(20), 
SHIPCODE 
INT  , 
AGENT 
INT  , 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
STARTDATET 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
EMPLOYEE) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
SHIPCODE) 
REFERENCES genapp. 
VSHIPMEN 
( 
SID), 
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
EDITLOG 
( 
SID
SERIAL,
DATABASENM 
varchar(20) not null 
, 
RECORDNO 
INT, 
FIELD 
varchar(20), 
DATET 
TIMESTAMP, 
USERNAME 
varchar(20), 
DELETED 
boolean, 
PREVCHAR 
varchar(30), 
PREVNUM 
INT, 
PREVLOG 
boolean, 
PREVDATE 
TIMESTAMP, 
NEWCHAR 
varchar(30), 
NEWNUM 
INT, 
NEWLOG 
boolean, 
NEWDATE 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID)
); 
CREATE 
TABLE genapp. 
HLOGFILE 
( 
SID
SERIAL,
SERIALNO 
varchar(25)  not null
, 
MATCODE 
varchar(20), 
QUANRECD 
INT, 
VENDOR 
varchar(20), 
LOCATION 
varchar(20), 
RECVRPT 
varchar(25), 
INFLG 
boolean, 
PHY 
boolean, 
DATETIN 
TIMESTAMP, 
DATETOUT 
TIMESTAMP, 
JOBNO 
varchar(20), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
PONO 
varchar(20), 
SCANDATET 
TIMESTAMP, 
QUANISSD 
INT, 
BUTT 
varchar(25), 
STATUSFL 
INT, 
QUANREJD 
NUMERIC(14,2), 
CUSTOMER 
varchar(25), 
CPONO 
varchar(20), 
CUSTOMEJ 
varchar(25), 
ORGCOST 
NUMERIC(14,2), 
ORGPONO 
varchar(20), 
ORGJOBNO 
varchar(20), 
ALTSERNO 
varchar(25), 
SELPRICE 
NUMERIC(14,2), 
PHYSQTY 
NUMERIC(14,2), 
SPERSON 
varchar(25), 
CARTONID 
varchar(25), 
CARTONPR 
boolean, 
PACKCODE 
varchar(20), 
TARECODE 
varchar(20), 
SHIPCODE 
varchar(20), 
TYPE 
varchar(12), 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
CPAYMENT 
( 
SID
SERIAL,
PAYMENT 
varchar(32) not null, 
CUSTOMER 
INT  , 
CINVOICE 
INT  , 
CHEQDATE
TIMESTAMP,
PAYMENTDUEDATE
timestamp,
POSTINGPERIOD
INT,
MATCODE 
INT, 
INTEGRSET 
varchar(20), 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2),
AMOUNTIN
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
DISCOUNT 
NUMERIC(14,2), 
BASEAMOUNTT 
NUMERIC(14,2), 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
PAYTYPE 
varchar(4), 
PAYBYID 
varchar(20), 
PAYBYDATE 
TIMESTAMP, 
CURRENCY 
varchar(12), 
CONVRATE 
NUMERIC(14,2), 
LOCAMOUNTT 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
CINVOICE) 
REFERENCES genapp. 
CUINVOICE 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
SERIALNUMBERS 
( 
SID
SERIAL,
SERIALNO 
varchar(25) not null 
, 
MATCODE 
varchar(20), 
QUANRECD 
NUMERIC(14,2), 
VENDOR 
varchar(20), 
LOCATION 
varchar(20), 
RECVRPT 
varchar(20), 
INFL 
boolean, 
PHY 
boolean, 
DATETIN 
TIMESTAMP, 
DATETOUT 
TIMESTAMP, 
JOBNO 
varchar(20), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
PONO 
varchar(20), 
SCANDATET 
TIMESTAMP, 
QUANISSD 
NUMERIC(14,2), 
BUTT 
varchar(20), 
STATUSFL 
INT, 
QUANREJD 
NUMERIC(14,2), 
CUSTOMER 
varchar(20), 
CPONO 
varchar(20), 
CUSTOMEJ 
varchar(20), 
ORGCOST 
NUMERIC(14,2), 
ORGPONO 
varchar(20), 
ORGJOBNO 
varchar(20), 
ALTSERNO 
varchar(25), 
SELPRICE 
NUMERIC(14,2), 
PHYSQTY 
NUMERIC(14,2), 
SPERSON 
varchar(20), 
CARTONID 
varchar(20), 
CARTONPR 
boolean, 
PACKCODE 
varchar(20), 
TARECODE 
varchar(20), 
SHIPCODE 
varchar(20), 
TYPE 
varchar(12), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARSERIAL 
varchar(30),
PRIMARY 
KEY(SID)); 
CREATE 
TABLE genapp. 
MACHINE 
( 
SID
SERIAL,
MACHINECODE 
varchar(32) not null, 
QUANTITY 
NUMERIC(14,2), 
DESCRIPT 
varchar(120), 
DATEADDED 
TIMESTAMP, 
SOURCE1 
varchar(35), 
SOURCE2 
varchar(35), 
UPCCODE 
varchar(25), 
COST 
NUMERIC(14,2), 
REPLCOST 
NUMERIC(14,2), 
SELPRICE 
NUMERIC(14,2), 
SPRICOLD 
NUMERIC(14,2), 
SPRICNEW 
NUMERIC(14,2), 
SPRICEFFDT 
TIMESTAMP, 
SHIPCODE 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
MISCCODE1 
varchar(25), 
MISCCODE2 
varchar(25), 
QTYLEVEL1 
NUMERIC(14,2), 
UNIT 
varchar(12), 
CASEQTY 
NUMERIC(14,2), 
TYPE 
varchar(12), 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
ALIASCODE 
varchar(25), 
PARENTCODE 
INT  , 
AVGPRICE 
NUMERIC(14,2), 
AVGCOST 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SUBCODESN 
NUMERIC(14,2), 
CUORDQTY 
NUMERIC(14,2), 
VENORQTY 
NUMERIC(14,2), 
CUPICQTY 
NUMERIC(14,2), 
VENPIQTY 
NUMERIC(14,2), 
CUINVQTY 
NUMERIC(14,2), 
CUSHIQTY 
NUMERIC(14,2), 
VENSHQTY 
NUMERIC(14,2), 
EFFDATE 
TIMESTAMP, 
INTEGRSET 
varchar(20), 
NOTES 
varchar(60), 
DOCMNT 
varchar(90), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARUPC 
varchar(30), 
PRIMARY 
KEY 
( 
SID),
FOREIGN 
KEY 
( 
PARENTCODE) 
REFERENCES genapp. 
MACHINE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
GROUPMEMBERS 
( 
SID
SERIAL,
GROUPID 
INT not null, 
MEMBERID 
varchar(32) not null, 
DESCRIPT 
varchar(120),
SOURCETYPE
varchar(10), 
MEMBEREM 
INT  , 
MEMBERCU 
INT  , 
MEMBERVE 
INT  , 
MEMBERIT 
INT  , 
MEMBERAC 
INT  , 
MEMBERMA 
INT  , 
TYPE 
varchar(10), 
CURRPW 
varchar(32) not null, 
EXPIRY 
TIMESTAMP, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
GROUPID) 
REFERENCES genapp. 
MEMBERSGROUP
( 
SID), 
FOREIGN 
KEY 
( 
MEMBEREM) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID), 
FOREIGN 
KEY 
( 
MEMBERCU) 
REFERENCES genapp. 
CUSTOMER 
( 
SID), 
FOREIGN 
KEY 
( 
MEMBERIT) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
MEMBERAC) 
REFERENCES genapp. 
ACTIVITY 
( 
SID), 
FOREIGN 
KEY 
( 
MEMBERMA) 
REFERENCES genapp. 
MACHINE 
( 
SID), 
FOREIGN 
KEY 
( 
MEMBERVE) 
REFERENCES genapp. 
VENDOR 
( 
SID) 
); 

CREATE 
TABLE genapp. 
JOBASSIGNMENT 
( 
SID
SERIAL,
MACHINE 
INT not null, 
SEQUENCE 
varchar(12) not null, 
RUNDATET 
TIMESTAMP, 
STARTDTIME 
TIMESTAMP, 
PREVJOB 
INT  , 
JOBNO 
INT  , 
NEXTJOB 
INT  , 
MATCODE 
INT  , 
PONO 
INT, 
VENDOR 
INT  , 
CPONO 
INT, 
CUSTOMER 
INT  , 
PRIORITY 
boolean, 
STATUSFL 
INT, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
MACHINE) 
REFERENCES genapp. 
MACHINE 
( 
SID), 
FOREIGN 
KEY 
( 
PREVJOB) 
REFERENCES genapp. 
ITEMJOB 
( 
SID), 
FOREIGN 
KEY 
( 
NEXTJOB) 
REFERENCES genapp. 
ITEMJOB 
( 
SID), 
FOREIGN 
KEY 
( 
JOBNO) 
REFERENCES genapp. 
ITEMJOB 
( 
SID) 
); 
CREATE 
TABLE genapp. 
NEXTSERIALNO 
( 
SID
SERIAL,
NXTSERNO 
varchar(4)  not null
, 
CURSERNO 
varchar(4), 
PREVSERN 
varchar(4), 
IS9999 
boolean, 
REFNO 
varchar(14),
OWNER 
varchar(20), 
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
RATE1F 
( 
SID
SERIAL,
USERTYPE 
varchar(12)  not null
, 
PRODTYPE 
varchar(12) not null, 
STEPNAME 
varchar(25), 
STEP 
INT, 
VALUE 
NUMERIC(14,2),
OWNER 
varchar(20), 
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
);
 
CREATE 
TABLE genapp. 
ITEMBOM 
( 
SID
SERIAL,
BOMCODE 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
QUANTITY
NUMERIC(14,2), 
MODE 
boolean, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 

CREATE 
TABLE genapp. 
ITEMBOMDETAILS 
( 
SID
SERIAL,
BOMCODE 
INT not null, 
MATCODE 
INT  not null , 
MODE 
boolean, 
SUBQTY 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID 
), 
FOREIGN 
KEY 
( 
BOMCODE) 
REFERENCES genapp. 
ITEMBOM 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID) 
);

CREATE 
TABLE genapp. 
TASK 
( 
SID
SERIAL,
TASKID
varchar(32) not null, 
DESCRIPT 
varchar(120), 
ACTIVITYCODE 
INT  , 
PROJECTTEAM 
INT  , 
RESOURCE
INT  ,
MODE 
boolean, 
ESTSTART
TIMESTAMP,
CALCSTART 
TIMESTAMP, 
ACTLSTART 
TIMESTAMP, 
ESTEND 
TIMESTAMP, 
CALCEND 
TIMESTAMP, 
ACTLEND 
TIMESTAMP, 
SUBQTY 
NUMERIC(14,2), 
BOMCODE 
INT, 
LOCATION 
INT, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY(SID)
, 
FOREIGN 
KEY 
( 
PROJECTTEAM) 
REFERENCES genapp. 
MEMBERSGROUP
( 
SID), 
FOREIGN 
KEY 
(RESOURCE) 
REFERENCES genapp. 
GROUPMEMBERS 
( 
SID), 
FOREIGN 
KEY 
( 
ACTIVITYCODE 
) 
REFERENCES genapp. 
ACTIVITY 
( 
SID) 
); 

CREATE 
TABLE genapp. 
PROJECT
( 
SID
SERIAL,
PROJ 
varchar(32) not null, 
PARENTCODE 
INT  , 
DESCRIPT 
varchar(120), 
COMPANYCODE
INT  ,
DIVCODE 
INT  , 
DEPCODE 
INT  , 
LOCATION 
INT  , 
SDATET 
TIMESTAMP, 
EDATET 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY(SID), 
FOREIGN 
KEY 
( 
PARENTCODE 
) 
REFERENCES genapp. 
PROJECT 
( 
SID),
FOREIGN 
KEY 
( 
COMPANYCODE 
) 
REFERENCES genapp. 
COMPANY 
( 
SID 
), 
FOREIGN 
KEY 
( 
DEPCODE
) 
REFERENCES genapp. 
DEPARTMENT 
( 
SID 
), 
FOREIGN 
KEY 
( 
DIVCODE 
) 
REFERENCES genapp. 
DIVISION 
( 
SID 
)); 


CREATE 
TABLE genapp. 
OUTLINE 
( 
SID
SERIAL,
PROJ 
INT not null, 
PARENTCODE 
INT  , 
USEROW 
NUMERIC(14,2), 
USECOL 
NUMERIC(14,2), 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY(SID), 
FOREIGN 
KEY 
( 
PARENTCODE 
) 
REFERENCES genapp. 
OUTLINE 
( 
SID) 
); 

CREATE 
TABLE genapp. 
SCANDATE 
( 
SID
SERIAL,
SDSATETIMEOFSCAN 
varchar(25) not null 
, 
DATETIMEOFSCAN 
TIMESTAMP, 
LASTDATE 
TIMESTAMP, 
BKUPDATE 
TIMESTAMP,
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 

CREATE 
TABLE genapp. 
VINVOICE 
( 
SID
SERIAL,
INVOICE 
varchar(32) not null, 
VENDOR 
INT  , 
MATCODE 
INT  , 
INTEGRSET 
varchar(20), 
INVODATE 
TIMESTAMP, 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
PONO 
INT  , 
REF1TYP 
varchar(20), 
REF1CODE 
varchar(35), 
SHIPDATET 
TIMESTAMP, 
SHIPTYPE 
varchar(12), 
SHIPCODE 
INT  , 
TERMS 
varchar(12), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
TERMSDAT 
TIMESTAMP, 
DISCOUNP 
NUMERIC(14,2), 
DISCOUDT 
TIMESTAMP, 
DISCOUDS 
NUMERIC(14,2), 
NETDDAT 
TIMESTAMP, 
NETDDYS 
INT, 
FOB 
varchar(20), 
TYPE 
varchar(12), 
ATTACH 
varchar(20), 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
AGENT 
INT  , 
NOTES 
varchar(60), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
DOCMNT 
varchar(90), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
SHIPCODE) 
REFERENCES genapp. 
SHIPMENT 
( 
SID), 
FOREIGN 
KEY 
( 
PONO 
) 
REFERENCES genapp. 
VENDORDERS 
( 
SID 
), 
FOREIGN 
KEY 
( 
AGENT) 
REFERENCES genapp. 
EMPLOYEE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
VPAYMENT 
( 
SID
SERIAL,
PAYMENT 
varchar(32) not null, 
VENDOR 
INT  , 
VINVOICE 
INT  , 
CHEQDATE
TIMESTAMP,
PAYMENTDUEDATE
timestamp,
POSTINGPERIOD
INT,
MATCODE 
INT, 
INTEGRSET 
varchar(20), 
AMOUNTTOTAL 
NUMERIC(14,2), 
AMOUNTOSTNDT 
NUMERIC(14,2), 
AMOUNTIN
NUMERIC(14,2), 
QTYTOTAL 
NUMERIC(14,2), 
QTYOSTNDT 
NUMERIC(14,2), 
BASEAMOUNTT 
NUMERIC(14,2), 
DELIVCHRGT 
NUMERIC(14,2), 
MISCCHRGT 
NUMERIC(14,2), 
TAX1AMTT 
NUMERIC(14,2), 
TAX2AMTT 
NUMERIC(14,2), 
TAX3AMTT 
NUMERIC(14,2), 
DISCOUNT 
NUMERIC(14,2), 
PAYTYPE 
varchar(4), 
PAYBYID 
varchar(20), 
PAYBYDATE 
TIMESTAMP, 
CURRENCY 
varchar(12), 
CONVRATE 
NUMERIC(14,2), 
LOCAMOUNT 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
VINVOICE) 
REFERENCES genapp. 
VINVOICE 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR 
) 
REFERENCES genapp. 
VENDOR 
( 
SID) 
); 

CREATE 
TABLE genapp. 
CUQDETAILS 
( 
SID
SERIAL,
CUQNO 
INT   not null, 
LINE 
INT, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATE 
TIMESTAMP, 
IDELVDATE 
TIMESTAMP, 
VENDOR 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
CUQNO) 
REFERENCES genapp. 
CUQUOTE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CUODETAILS 
( 
SID
SERIAL,
CUONO 
INT  not null , 
LINE 
INT, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATE 
TIMESTAMP, 
IDELVDATE 
TIMESTAMP, 
VENDOR 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2),
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
CUONO) 
REFERENCES genapp. 
CUORDERS 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CUIDETAILS 
( 
SID
SERIAL,
CUINO 
INT   not null, 
LINE 
INT, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATET 
TIMESTAMP, 
DELVDATEIT 
TIMESTAMP, 
VENDOR 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
BASEAMOUNT 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
CUINO) 
REFERENCES genapp. 
CUINVOICE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
CUPDETAILS 
( 
SID
SERIAL,
CUPNO 
INT  not null , 
LINE 
INT, 
INVOICE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDPRICE 
NUMERIC(14,2), 
PAYTYPE 
varchar(12), 
PAYBYID 
varchar(12),
AMOUNTIN 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
INVOICE) 
REFERENCES genapp. 
CUINVOICE 
( 
SID), 
FOREIGN 
KEY 
( 
CUPNO) 
REFERENCES genapp. 
CPAYMENT 
( 
SID) 
); 
CREATE 
TABLE genapp. 
ITEMJOBDETAILS 
( 
SID
SERIAL,
JOBNO 
INT not null  , 
LINE 
INT, 
MATCODE 
INT  , 
PRODDATET 
TIMESTAMP, 
QTYALLOC 
NUMERIC(14,2), 
PONO 
INT, 
ORDPRICE 
NUMERIC(14,2), 
QTYOSTND 
NUMERIC(14,2), 
QTYALSTK 
NUMERIC(14,2), 
QTYISSUD 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
PRINTMSTATJ 
INT, 
PRINMTFLDTJ 
TIMESTAMP, 
TYPE 
varchar(12), 
MATCODEOUT 
INT, 
QTYOUT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
JOBNO) 
REFERENCES genapp. 
ITEMJOB 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
ACTIVITYJOBDETAILS 
( 
SID
SERIAL,
JOBNO 
INT   not null, 
LINE 
INT, 
ACTIVITYCODE 
INT  , 
PRODDATET 
TIMESTAMP, 
QTYALLOC 
NUMERIC(14,2), 
PONO 
INT, 
ORDPRICE 
NUMERIC(14,2), 
QTYOSTND 
NUMERIC(14,2), 
QTYALSTK 
NUMERIC(14,2), 
QTYISSUD 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
PRINTMSTATJ 
INT, 
PRINMTFLDTJ 
TIMESTAMP, 
TYPE 
varchar(12), 
ACTIVITYCODEOUT 
INT, 
QTYOUT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
ACTIVITYCODE) 
REFERENCES genapp. 
ACTIVITY 
( 
SID), 
FOREIGN 
KEY 
( 
JOBNO) 
REFERENCES genapp. 
ACTIVITYJOB 
( 
SID 
) 
); 
CREATE 
TABLE genapp. 
SHIPMENTDETAILS 
( 
SID
SERIAL,
SHIPCODE 
INT  not null , 
LINE 
INT, 
MATCODE 
INT  , 
QTYSHIPPED 
NUMERIC(14,2), 
SHIPPINGPRICE 
NUMERIC(14,2), 
SHIPPER 
INT, 
PONO 
INT, 
CPONO 
INT, 
INVOICE 
INT, 
BILLADDR 
INT, 
AMOUNT 
NUMERIC(14,2), 
AMOUNTOSTND 
NUMERIC(14,2), 
QTY 
NUMERIC(14,2), 
QTYOSTND 
NUMERIC(14,2), 
CARRIER 
INT, 
TYPE 
varchar(12), 
SHIPDATET 
TIMESTAMP, 
SHIPDATETA 
TIMESTAMP, 
TARENO 
varchar(20), 
PACKNO 
varchar(20), 
CUSTOMER 
INT  , 
MAILTOCODE 
INT  , 
SHIPTOCODE 
INT  , 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SERIALNO 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARSHIPCOD 
varchar(30), 
LINETOTL 
NUMERIC(14,2), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
MAILTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPCODE) 
REFERENCES genapp. 
SHIPMENT 
( 
SID) 
); 
CREATE 
TABLE genapp. 
VENDQDETAILS 
( 
SID
SERIAL,
VENDQNO 
INT  not null , 
LINE 
INT, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATET 
TIMESTAMP, 
CUSTOMER 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
VENDQNO 
) 
REFERENCES genapp. 
VENQUOTE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
VENDODETAILS 
( 
SID
SERIAL,
VENDONO 
INT  not null , 
LINE 
INT, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATET 
TIMESTAMP, 
CUSTOMER 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
VENDONO 
) 
REFERENCES genapp. 
VENDORDERS 
( 
SID) 
); 
CREATE 
TABLE genapp. 
VENDIDETAILS 
( 
SID
SERIAL,
VENDINO 
INT not null  , 
LINE 
INT, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATET 
TIMESTAMP, 
CUSTOMER 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
CUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
VENDINO 
) 
REFERENCES genapp. 
VINVOICE 
( 
SID) 
); 
CREATE 
TABLE genapp. 
VENDPDETAILS 
( 
SID
SERIAL,
VENDPNO 
INT  not null , 
LINE 
INT, 
INVOICE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDPRICE 
NUMERIC(14,2), 
PAYTYPE 
varchar(12), 
PAYBYID 
varchar(12),
AMOUNTIN 
NUMERIC(14,2), 
VENDOR 
INT  , 
VONTACT 
INT, 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
INVOICE) 
REFERENCES genapp. 
VINVOICE 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR 
) 
REFERENCES genapp. 
VENDOR 
( 
SID 
), 
FOREIGN 
KEY 
( 
VENDPNO 
) 
REFERENCES genapp. 
VPAYMENT 
( 
SID) 
); 
CREATE 
TABLE genapp. 
VSHIPMENDETAILS 
( 
SID
SERIAL,
SHIPCODE 
INT  not null , 
LINE 
INT, 
MATCODE 
INT  , 
QTYSHIPPED 
NUMERIC(14,2), 
SHIPPINGPRICE 
NUMERIC(14,2), 
SHIPPER 
INT, 
PONO 
INT, 
CPONO 
INT, 
INVOICE 
INT, 
BILLADDR 
INT, 
AMOUNT 
NUMERIC(14,2), 
AMOUNTOSTND 
NUMERIC(14,2), 
QTY 
NUMERIC(14,2), 
QTYOSTND 
NUMERIC(14,2), 
CARRIER 
INT, 
TYPE 
varchar(12), 
SHIPDATET 
TIMESTAMP, 
SHIPDATETA 
TIMESTAMP, 
TARENO 
varchar(20), 
PACKNO 
varchar(20), 
VENDOR 
INT, 
MAILTOCODE 
INT  , 
SHIPTOCODE 
INT  , 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SERIALNO 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARSHIPCOD 
varchar(30), 
LINETOTL 
NUMERIC(14,2), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
MAILTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPTOCODE 
) 
REFERENCES genapp. 
ADDRESS( 
SID 
), 
FOREIGN 
KEY 
( 
SHIPCODE) 
REFERENCES genapp. 
SHIPMENT 
( 
SID) 
); 

CREATE 
TABLE genapp. 
WAGEEARNERAUX 
( 
SID
SERIAL,
WAGEEARNERID 
INT not null, 
LINE 
INT, 
SIN 
varchar(12), 
WCBYTDL 
NUMERIC(14,2), 
WCBYTDN 
NUMERIC(14,2), 
INSYTDL 
NUMERIC(14,2), 
INSYTDN 
NUMERIC(14,2), 
VACATONYL 
NUMERIC(14,2), 
VACATONYN 
NUMERIC(14,2), 
PAYYTDL 
NUMERIC(14,2), 
FPENSIYTL 
NUMERIC(14,2), 
PPENSIYTL 
NUMERIC(14,2), 
ITAXYTDL 
NUMERIC(14,2), 
PTAXYTDL 
NUMERIC(14,2), 
PAYYTDN 
NUMERIC(14,2), 
FPENSIYTN 
NUMERIC(14,2), 
PPENSIYTN 
NUMERIC(14,2), 
ITAXYTDN 
NUMERIC(14,2), 
PATXYTDN 
NUMERIC(14,2), 
GPAYYTDL 
NUMERIC(14,2), 
GPAYYTDN 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
WAGEEARNERID) 
REFERENCES genapp. 
WAGEEARNER 
( 
SID) 
);
CREATE
TABLE genapp.
Rgenapp
(
SID
SERIAL,
APPNAME
varchar(40) not null,
DESCRIPT 
varchar(120), 
APPTYPE
varchar(20),
APPWACCOUNTING
boolean,
APPWEMAIL
boolean,
APPWJMSMQ
boolean,
APPVENDOR
varchar(20),
APPVERSION
varchar(20),
APPPLATFORM
varchar(40),
APPMODELPKG
varchar(40),
APPACTIONPKG
varchar(40),
APPSKIN
varchar(20),
APPDEPLOYTYPE
varchar(20),
CREATEFIDATA
varchar(4096000),
REVENGDATA
varchar(4096000),
INITIALIZEFIDATA
varchar(4096000),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY
KEY(SID)
); 
 
CREATE
TABLE genapp.
RGENDB
(
SID
SERIAL,
DBNAME
varchar(40) not null,
DESCRIPT 
varchar(120), 
DBTYPE
varchar(20),
DBVENDOR
varchar(20),
DBVERSION
varchar(20),
DBPLATFORM
varchar(20),
APPCODE 
INT  , 
SQLDRIVER
varchar(40),
SQLURL
varchar(40),
SQLUSER
varchar(20),
SQLPASSWORD
varchar(20),
SQLCLASSPATH
varchar(40),
SQLCREATEDBSCRIPT
varchar(20),
SQLDROPDBSCRIPT
varchar(20),
SQLCREATETBLSSCRIPT
varchar(20),
SQLLOADTBLSSCRIPT
varchar(20),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY
KEY(SID),
FOREIGN 
KEY 
( 
APPCODE 
) 
REFERENCES genapp. 
Rgenapp 
( 
SID 
)
); 

CREATE 
TABLE genapp. 
RGENTABLE  
( 
SID
SERIAL,
TABLENAME  
varchar(40)  not null
, 
DBCODE
INT  ,
INADDMENU 
boolean, 
INLISTMENU 
boolean, 
INTRANSACTIONMENU 
boolean, 
INREPORTMENU 
boolean, 
INGRAPHSMENU 
boolean, 
INMAILINGMENU 
boolean, 
INGENERATEMENU 
boolean, 
INADMINMENU 
boolean, 
INMAINTENANCEMENU 
boolean, 
INLABELSMENU 
boolean, 
INSKIPMENU 
boolean, 
INCUSTOM1MENU 
boolean, 
MENULEVEL 
varchar(12), 
MENUROLE 
varchar(12), 
MENULABELGROUP 
varchar(20), 
SUBMENUSEQUENCE 
INT, 
USAGESCOPE
varchar(12),
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID),
FOREIGN 
KEY 
( 
DBCODE 
) 
REFERENCES genapp. 
RGENDB 
( 
SID 
)
); 

CREATE 
TABLE genapp. 
RGENFIELDS 
( 
SID
SERIAL,
DBCODE
INT  
,
TABLENAME  
INT  
, 
FIELDNAME 
varchar(60) not null, 
FIELDTYPE
varchar(20),
FIELDLENGTH
varchar(2),
INGROUP 
varchar(20), 
SEQWITHINGROUP 
INT, 
FOCUSSEQ 
INT, 
FUTURE1 
varchar(20), 
INITIALVALUE 
varchar(12), 
KEYORADDITIONAL 
varchar(12), 
KEYORADDITIONAL2 
varchar(12), 
KEYORADDITIONAL3 
varchar(12), 
SHOWINMENU 
varchar(20), 
SHOWINREPORT 
varchar(20), 
PROCESSOPTION1 
varchar(20), 
PROCESSOPTION2 
varchar(20),
FDBCODE
varchar(40)  , 
FTABLENAME  
varchar(60)  , 
FFIELDKEYNAME1 
varchar(60), 
FFIELDKEYNAME2 
varchar(60), 
FFIELDKEYNAME3 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID),
FOREIGN 
KEY 
( 
TABLENAME 
) 
REFERENCES genapp. 
RGENTABLE 
( 
SID),
FOREIGN 
KEY 
( 
DBCODE
) 
REFERENCES genapp. 
RGENDB 
( 
SID)
); 
CREATE 
TABLE genapp. 
GENOPTIONS 
( 
SID
SERIAL,
ROW 
varchar(2) not null, 
GENOPTIONS01 
varchar(159), 
GENPURPOSE01 
varchar(159), 
GENVALUE01 
varchar(159), 
GENOPTIONS02 
varchar(159), 
GENPURPOSE02 
varchar(159), 
GENVALUE02 
varchar(159), 
GENOPTIONS03 
varchar(159), 
GENPURPOSE03 
varchar(159), 
GENVALUE03 
varchar(159), 
GENOPTIONS04 
varchar(159), 
GENPURPOSE04 
varchar(159), 
GENVALUE04 
varchar(159), 
GENOPTIONS05 
varchar(159), 
GENPURPOSE05 
varchar(159), 
GENVALUE05 
varchar(159), 
GENOPTIONS06 
varchar(159), 
GENPURPOSE06 
varchar(159), 
GENVALUE06 
varchar(159), 
GENOPTIONS07 
varchar(159), 
GENPURPOSE07 
varchar(159), 
GENVALUE07 
varchar(159), 
GENOPTIONS08 
varchar(159), 
GENPURPOSE08 
varchar(159), 
GENVALUE08 
varchar(159), 
GENOPTIONS09 
varchar(159), 
GENPURPOSE09 
varchar(159), 
GENVALUE09 
varchar(159), 
GENOPTIONS10 
varchar(159), 
GENPURPOSE10 
varchar(159), 
GENVALUE10 
varchar(159), 
GENOPTIONS11 
varchar(159), 
GENPURPOSE11 
varchar(159), 
GENVALUE11 
varchar(159), 
GENOPTIONS12 
varchar(159), 
GENPURPOSE12 
varchar(159), 
GENVALUE12 
varchar(159), 
GENOPTIONS13 
varchar(159), 
GENPURPOSE13 
varchar(159), 
GENVALUE13 
varchar(159), 
GENOPTIONS14 
varchar(159), 
GENPURPOSE14 
varchar(159), 
GENVALUE14 
varchar(159), 
GENOPTIONS15 
varchar(159), 
GENPURPOSE15 
varchar(159), 
GENVALUE15 
varchar(159), 
GENOPTIONS16 
varchar(159), 
GENPURPOSE16 
varchar(159), 
GENVALUE16 
varchar(159), 
GENOPTIONS17 
varchar(159), 
GENPURPOSE17 
varchar(159), 
GENVALUE17 
varchar(159), 
GENOPTIONS18 
varchar(159), 
GENPURPOSE18 
varchar(159), 
GENVALUE18 
varchar(159), 
GENOPTIONS19 
varchar(159), 
GENPURPOSE19 
varchar(159), 
GENVALUE19 
varchar(159), 
GENOPTIONS20 
varchar(159), 
GENPURPOSE20 
varchar(159), 
GENVALUE20 
varchar(159), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20),
OWNER2 
varchar(40),
PRIMARY 
KEY(SID) 
); 
CREATE 
TABLE genapp. 
PERIODDATES 
( 
SID
SERIAL,
PERIOD 
varchar(2) not null, 
DESCRIPT 
varchar(120), 
STARTDATE 
TIMESTAMP, 
ENDDATE 
TIMESTAMP, 
STARTOFWEEK
INT,
STARTOFBWEEK
INT,
ENDOFBWEEK
INT,
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID)
); 
-- FROMTABLE genapp.,FROMKEY,QUALIFIER values will be keyed in unless created in another xxxHome, where fromtable is the tablename
-- and from key will be key to which clob data value will be associated.
-- QUALIFIER will be 1,2,3 etc depending on how many attachments are uploaded
-- for CLOB and BLOB data QUALIFIER will be keyed in value appended with attachment # ie say REQUEST1,REQUEST2 etc
-- SEQUENCE Column is not part of the key but can be used for additional sequence control(no template logic yet)
-- standalone xml messages can be added to clobdata,fromtable can say testCase and key will have testScript#
CREATE 
TABLE genapp. 
CLOBDATA 
( 
SID
SERIAL,
FROMTABLE 
varchar(35) not null, 
FROMKEY
varchar(35) not null,
QUALIFIER 
varchar(32) not null, 
SEQUENCE 
INT, 
TYPE
varchar(40),
DATA 
VARCHAR(4096000), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID)); 
CREATE 
TABLE genapp. 
BLOBDATA 
( 
SID
SERIAL,
FROMTABLE 
varchar(35) not null, 
FROMKEY
varchar(35) not null,
QUALIFIER 
varchar(32) not null, 
SEQUENCE 
INT, 
TYPE
varchar(40),
DATA 
BYTEA, 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(255), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID
)); 
CREATE 
TABLE genapp. 
ITEMTEMPTYPE 
( 
SID
SERIAL,
MATCODETEMP 
varchar(32) not null, 
FORCUSTOMER 
INT  , 
DESCRIPT 
varchar(120), 
DATEADDED 
TIMESTAMP, 
DATEEXPIRY 
TIMESTAMP, 
DATETORENEW 
TIMESTAMP, 
FROMSUPPLIER 
INT  , 
SOURCE2 
varchar(35), 
UPCCODE 
varchar(25), 
COST 
NUMERIC(14,2), 
REPLCOST 
NUMERIC(14,2), 
SELPRICE 
NUMERIC(14,2), 
SPRICOLD 
NUMERIC(14,2), 
SPRICNEW 
NUMERIC(14,2), 
SPRICEFFDT 
TIMESTAMP, 
SHIPCODE 
varchar(25), 
PRINTMSTAT 
INT, 
PRINMTFLDT 
TIMESTAMP, 
MISCCODE1 
varchar(25), 
MISCCODE2 
varchar(25), 
QTYLEVEL1 
NUMERIC(14,2), 
UNIT 
varchar(12), 
CASEQTY 
NUMERIC(14,2), 
TYPE 
varchar(12), 
TAX1 
boolean, 
TAX2 
boolean, 
TAX3 
boolean, 
ALIASCODE 
varchar(25), 
PARENTCODE 
INT  , 
AVGPRICE 
NUMERIC(14,2), 
AVGCOST 
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
SUBCODESN 
NUMERIC(14,2), 
CUORDQTY 
NUMERIC(14,2), 
VENORQTY 
NUMERIC(14,2), 
CUPICQTY 
NUMERIC(14,2), 
VENPIQTY 
NUMERIC(14,2), 
CUINVQTY 
NUMERIC(14,2), 
CUSHIQTY 
NUMERIC(14,2), 
VENSHQTY 
NUMERIC(14,2), 
EFFDATE 
TIMESTAMP, 
INTEGRSET 
varchar(20), 
NOTES 
varchar(60), 
DOCMNT 
varchar(90), 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
BARUPC 
varchar(30), 
PRIMARY 
KEY 
( 
SID 
), 
FOREIGN 
KEY 
( 
FORCUSTOMER 
) 
REFERENCES genapp. 
CUSTOMER 
( 
SID 
), 
FOREIGN 
KEY 
( 
FROMSUPPLIER 
) 
REFERENCES genapp. 
VENDOR 
( 
SID),
FOREIGN 
KEY 
( 
PARENTCODE) 
REFERENCES genapp. 
ITEMTEMPTYPE 
( 
SID) 
);
CREATE 
TABLE genapp. 
CONTROLUSAGEBYPERIODS 
( 
SID
SERIAL,
CONTROLCODE 
INT not null, 
DESCRIPT 
varchar(120), 
CURRENCY 
varchar(3), 
PERIOD0B 
NUMERIC(14,2), 
PERIOD0 
NUMERIC(14,2), 
PERIODTOTALSB 
NUMERIC(14,2), 
PERIODTOTALS 
NUMERIC(14,2), 
PERIOD1BUDGET 
NUMERIC(14,2), 
PERIOD1ACTUAL 
NUMERIC(14,2), 
PERIOD2B 
NUMERIC(14,2), 
PERIOD2 
NUMERIC(14,2), 
PERIOD3B 
NUMERIC(14,2), 
PERIOD3 
NUMERIC(14,2), 
PERIOD4B 
NUMERIC(14,2), 
PERIOD4 
NUMERIC(14,2), 
PERIOD5B 
NUMERIC(14,2), 
PERIOD5 
NUMERIC(14,2), 
PERIOD6B 
NUMERIC(14,2), 
PERIOD6 
NUMERIC(14,2), 
PERIOD7B 
NUMERIC(14,2), 
PERIOD7 
NUMERIC(14,2), 
PERIOD8B 
NUMERIC(14,2), 
PERIOD8 
NUMERIC(14,2), 
PERIOD9B 
NUMERIC(14,2), 
PERIOD9 
NUMERIC(14,2), 
PERIOD10B 
NUMERIC(14,2), 
PERIOD10 
NUMERIC(14,2), 
PERIOD11B 
NUMERIC(14,2), 
PERIOD11 
NUMERIC(14,2), 
PERIOD12B 
NUMERIC(14,2), 
PERIOD12 
NUMERIC(14,2), 
PERIODNB 
NUMERIC(14,2), 
PERIODN 
varchar(20), 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
PRIMARY 
KEY 
( 
SID), 

FOREIGN 
KEY 
( 
CONTROLCODE) 
REFERENCES genapp. 
CONTROL 
( 
SID) 
);
CREATE 
TABLE genapp. 
RESOURCEDETAILS 
( 
SID
SERIAL,
TASKNO 
INT, 
RESOURCENUMBER 
INT, 
PROJECTTEAM 
INT  , 
RESOURCE 
INT  not null , 
USAGEPERCENT
NUMERIC(14,2), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20),
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
(PROJECTTEAM) 
REFERENCES genapp. 
MEMBERSGROUP 
( 
SID), 
FOREIGN 
KEY 
(RESOURCE) 
REFERENCES genapp. 
GROUPMEMBERS 
( 
SID), 
FOREIGN 
KEY 
( 
TASKNO) 
REFERENCES genapp. 
TASK 
( 
SID) 
);

CREATE 
TABLE genapp. 
EMPLODETAILS 
( 
SID
SERIAL,
EMPLONO 
INT  not null , 
LINE 
INT not null, 
MATCODE 
INT  , 
QTYORDRD 
NUMERIC(14,2), 
ORDUNIT 
varchar(12), 
ORDPRICE 
NUMERIC(14,2), 
IODATE 
TIMESTAMP, 
IDELVDATE 
TIMESTAMP, 
VENDOR 
INT  , 
QTYOSTND 
NUMERIC(14,2), 
DELIVCHRG 
NUMERIC(14,2), 
MISCCHRG 
NUMERIC(14,2), 
TAX1AMT 
NUMERIC(14,2), 
TAX2AMT 
NUMERIC(14,2), 
TAX3AMT 
NUMERIC(14,2), 
LINETOTL 
NUMERIC(14,2), 
OWNER2 
varchar(40), 
PRIMARY 
KEY( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID), 
FOREIGN 
KEY 
( 
VENDOR) 
REFERENCES genapp. 
VENDOR 
( 
SID), 
FOREIGN 
KEY 
( 
EMPLONO) 
REFERENCES genapp. 
EMPLORDERS 
( 
SID) 
); 
 
CREATE 
TABLE genapp. 
USAGEBYPERIODS 
( 
SID
SERIAL,
USAGETRACKERID 
varchar(32) not null, 
DESCRIPT 
varchar(120), 
MATCODE
INT  ,
CURRENCY 
varchar(3), 
PERIOD0B 
NUMERIC(14,2), 
PERIOD0 
NUMERIC(14,2), 
PERIOD0FORMULAE 
VARCHAR(159), 
PERIODTOTALSB 
NUMERIC(14,2), 
PERIODTOTALS
NUMERIC(14,2), 
PERIOD1BUDGET 
NUMERIC(14,2), 
PERIOD1ACTUAL 
NUMERIC(14,2), 
PERIOD1ACTUALFORMULAE 
VARCHAR(159), 
PERIOD2B 
NUMERIC(14,2), 
PERIOD2 
NUMERIC(14,2), 
PERIOD2FORMULAE 
VARCHAR(159), 
PERIOD3B 
NUMERIC(14,2), 
PERIOD3 
NUMERIC(14,2), 
PERIOD3FORMULAE 
VARCHAR(159), 
PERIOD4B 
NUMERIC(14,2), 
PERIOD4 
NUMERIC(14,2), 
PERIOD4FORMULAE 
VARCHAR(159), 
PERIOD5B 
NUMERIC(14,2), 
PERIOD5 
NUMERIC(14,2), 
PERIOD5FORMULAE 
VARCHAR(159), 
PERIOD6B 
NUMERIC(14,2), 
PERIOD6 
NUMERIC(14,2), 
PERIOD6FORMULAE 
VARCHAR(159), 
PERIOD7B 
NUMERIC(14,2), 
PERIOD7 
NUMERIC(14,2), 
PERIOD7FORMULAE 
VARCHAR(159), 
PERIOD8B 
NUMERIC(14,2), 
PERIOD8 
NUMERIC(14,2), 
PERIOD8FORMULAE 
VARCHAR(159), 
PERIOD9B 
NUMERIC(14,2), 
PERIOD9 
NUMERIC(14,2), 
PERIOD9FORMULAE 
VARCHAR(159), 
PERIOD10B 
NUMERIC(14,2), 
PERIOD10 
NUMERIC(14,2), 
PERIOD10FORMULAE 
VARCHAR(159), 
PERIOD11B 
NUMERIC(14,2), 
PERIOD11 
NUMERIC(14,2), 
PERIOD11FORMULAE 
VARCHAR(159), 
PERIOD12B 
NUMERIC(14,2), 
PERIOD12 
NUMERIC(14,2), 
PERIOD12FORMULAE 
VARCHAR(159), 
PERIODNB 
NUMERIC(14,2), 
PERIODN 
varchar(20), 
PERIODNFORMULAE 
VARCHAR(159), 
NOTES 
varchar(60), 
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
OWNER 
varchar(20), 
OWNER2 
varchar(40), 
GROUPCODE 
INT  , 
PRIMARY 
KEY 
( 
SID), 
FOREIGN 
KEY 
( 
MATCODE) 
REFERENCES genapp. 
ITEM 
( 
SID),
FOREIGN 
KEY 
( 
GROUPCODE) 
REFERENCES genapp. 
ROLLUPGROUP 
( 
SID) 
); 

