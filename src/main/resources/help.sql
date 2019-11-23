

select * from STUDENT_SUBJECT_DETAIL

insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','Karthik','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','Karthik','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','Karthik','teac01', 'Shruthi')

insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','Karthik','teac01', 'Shruthi')


insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','ENG','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Rahul0126','HIN','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Ganesh0127','SAN','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','SCI','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','MAT','teac01', 'Shruthi')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','ENG','teac02', 'Keerti')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Rahul0126','HIN','teac02', 'Keerti')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Ganesh0127','SAN','teac02', 'Keerti')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','SCI','teac02', 'Keerti')
insert into STUDENT_SUBJECT_DETAIL values ('ave01Karthik0125','MAT','teac02', 'Keerti')



CREATE TABLE PERSON_DETAILS
(
    PERSON_ID VARCHAR(200) PRIMARY KEY NOT NULL,
    PERSON_FIRSTNAME VARCHAR(200),
    PERSON_LASTNAME VARCHAR(200),
    PERSON_BDATE DATE,
    PERSON_GENDER VARCHAR(20),
    STATE VARCHAR(20),
    COUNTRY VARCHAR(200),
    PERSON_ADDRESS VARCHAR(500),
    EMAIL_ADDRESS VARCHAR(200),
    PINCODE VARCHAR(20),
    CONTACT_NUMBER VARCHAR(200),
    NOMINEE VARCHAR(200),
    NOMINEE_RELATION VARCHAR(20),
    PERSON_PASSWORD VARCHAR(200)
);


insert into PERSON_DETAILS values ('PP10001','Karthik','Neelekani','Male','KARNATAKA','INDIA','ADDRESS1',
'kartik@gmail.com','560100','6767676767','Manjunath','Father',"hello","PP10000")

insert into PERSON_DETAILS values ('ave01Rahul0126','Rahul','Male','2015-12-17','8','C section','teac01','Banalore','Manjunath','Manjunath@gmail.com','6767676767')

insert into PERSON_DETAILS values ('ave01Ganesh0127','Ganesh','Male','2015-12-17','9','C section','teac01','Banalore','Arun','Arun@gmail.com','43434343')

insert into PERSON_DETAILS values ('ave01Kishor0128','Kishor','Male','2015-12-17','9','C section','teac02','Banalore','Manjunath','Manjunath@gmail.com','6767676767')

insert into PERSON_DETAILS values ('ave01Santosh0129','Santosh','Male','2015-12-17','10','C section','teac02','Banalore','Arun','Arun@gmail.com','43434343')

insert into PERSON_DETAILS values ('ave01Sandya0121','Sandya','Female','2015-12-17','10','C section','teac03','Banalore','Arun','Arun@gmail.com','43434343')

insert into PERSON_DETAILS values ('ave01Swathi0122','Swathi','Female','2015-12-17','8','C section','teac03','Banalore','Manjunath','Manjunath@gmail.com','6767676767')



insert into Teacher values ('teac01','Shruthi','7867875','2015-12-17','Mysore')
insert into Teacher values ('teac02','Keerti','7867875','2015-12-17','Mysore')
insert into Teacher values ('teac03','Anita','7867875','2015-12-17','Bangalore')
insert into Teacher values ('teac04','Rajesh','7867875','2015-12-17','Bangalore')

select * from SUBJECT
update SUBJECT
set SUBJECT_ID= 'KAN'
where SUBJECT_ID= 'kan'

commit;