drop schema selgold cascade;
CREATE SCHEMA selgold AUTHORIZATION DBA;
set schema selgold;
CREATE 
TABLE 
COMPANY 
( 
COMPANYCODE 
varchar(20) 
PRIMARY 
KEY, 
DESCRIPT 
varchar(120), 
LEGALNAME 
varchar(60), 
MAILTOCODE
varchar(20),
ADDADDRESSINFO
bit,
STATUSFL 
INT, 
STATUSFLDT 
TIMESTAMP, 
NOTES 
varchar(60), 
OWNER 
varchar(20));





