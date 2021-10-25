CREATE DATABASE if not exists AMVDB CHARACTER SET utf8 COLLATE utf8_general_ci;

USE AMVDB;

create table if not exists USER(
    USER_ID int UNIQUE auto_increment,
    Fname varchar(255),
    Lname varchar(255),
	Phone varchar(255),
	Username varchar (255),
    Password varchar(255),
    IsActive boolean,
    PRIMARY KEY (USER_ID)
    );
	
create table if not exists TOOL(
	TOOL_ID int UNIQUE auto_increment,
	Tool_Name varchar(255),
	Tool_Info varchar(255),
	Price int,
	Picture LONGBLOB,
	IsActive boolean,
	PRIMARY KEY (TOOL_ID)
	);

create table if not exists BOOKING(
	BOOKING_ID int UNIQUE auto_increment,
	StartDate DATE,
	EndDate DATE,
	Cmnt varchar(255),
	IsDelivered boolean,
	TotalPrice int,
	USER_ID int,
	TOOL_ID int,
	PRIMARY KEY (BOOKING_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
	FOREIGN KEY (TOOL_ID) REFERENCES TOOL(TOOL_ID)
	);

create table if not exists COURSE(
    COURSE_ID int UNIQUE auto_increment,
	Course_Title varchar(255),
	PRIMARY KEY (COURSE_ID)
	);
	
create table if not exists CERTIFICATE(
	USER_ID int,
	COURSE_ID int,
	Expiry_Date DATE,
	PRIMARY KEY (USER_ID, COURSE_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
	FOREIGN KEY (COURSE_ID) REFERENCES COURSE(COURSE_ID)
	);
	
create table if not exists UNION_MEMBER(
	USER_ID int,
	PRIMARY KEY (USER_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
	);
	
create table if not exists ADMIN(	
	USER_ID int,
	PRIMARY KEY (USER_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
	);


INSERT INTO BOOKING(TOOL_ID, USER_ID, IsDelivered)
VALUES (1, 1, true),
       (2, 2, false),
       (3, 3, true),
       (4, 4, false);



SELECT TOOL.TOOL_ID AS "Verktøy-ID", Tool_Name as "Verktøynavn", BOOKING_ID FROM TOOL
LEFT JOIN BOOKING ON TOOL.TOOL_ID = BOOKING.TOOL_ID
WHERE isDelivered = true OR BOOKING_ID is null;


/*Skriver alt som er opptatt*/
SELECT * FROM TOOL
RIGHT JOIN BOOKING ON TOOL.TOOL_ID = BOOKING.TOOL_ID
WHERE isDelivered = false;
;